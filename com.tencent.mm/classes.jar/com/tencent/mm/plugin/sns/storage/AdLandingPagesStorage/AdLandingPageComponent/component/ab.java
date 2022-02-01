package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab
  extends m
  implements SensorEventListener
{
  Sensor caA;
  Sensor cay;
  ImageView dtJ;
  private SensorManager mSensorManager;
  ProgressBar progressBar;
  int zXj;
  final float zXk = 10.0F;
  final int zXl = 1;
  HorizontalScrollView zXm;
  float[] zXn;
  float[] zXo;
  private int zXp = 0;
  boolean zXq = true;
  
  public ab(Context paramContext, r paramr, ViewGroup paramViewGroup)
  {
    super(paramContext, paramr, paramViewGroup);
  }
  
  public final boolean aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96676);
    if (!super.aQ(paramJSONObject))
    {
      AppMethodBeat.o(96676);
      return false;
    }
    try
    {
      paramJSONObject.put("swipeCount", this.zXp);
      if (!this.zXq)
      {
        String str = aj.ej(((r)this.zUP).zQK);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("urlMd5", str);
        localJSONObject.put("needDownload", 1);
        paramJSONObject.put("imgUrlInfo", localJSONObject);
      }
      AppMethodBeat.o(96676);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ae.printErrStackTrace("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96676);
    }
    return false;
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(96668);
    View localView = this.contentView;
    this.mSensorManager = ((SensorManager)ak.getContext().getSystemService("sensor"));
    this.cay = this.mSensorManager.getDefaultSensor(1);
    this.caA = this.mSensorManager.getDefaultSensor(2);
    this.zXm = ((HorizontalScrollView)localView.findViewById(2131296423));
    this.dtJ = ((ImageView)localView.findViewById(2131296424));
    this.progressBar = ((ProgressBar)localView.findViewById(2131303535));
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(96668);
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(96669);
    if (!o.fB(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", ((r)this.zUP).zQK))) {
      this.zXq = false;
    }
    String str = ((r)this.zUP).zQK;
    Bitmap localBitmap = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jP("adId", str);
    if (localBitmap != null)
    {
      ae.i("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "loaded cached image with  ".concat(String.valueOf(str)));
      setImage(localBitmap);
      AppMethodBeat.o(96669);
      return;
    }
    startLoading();
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(str, ((r)this.zUP).zRh, new f.a()
    {
      public final void ayY(String paramAnonymousString)
      {
        AppMethodBeat.i(96666);
        try
        {
          paramAnonymousString = com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymousString);
          ab.this.setImage(paramAnonymousString);
          AppMethodBeat.o(96666);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ae.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "%s" + bu.o(paramAnonymousString));
          AppMethodBeat.o(96666);
        }
      }
      
      public final void dVu()
      {
        AppMethodBeat.i(96664);
        ab.this.startLoading();
        AppMethodBeat.o(96664);
      }
      
      public final void dVv()
      {
        AppMethodBeat.i(96665);
        ab.this.progressBar.setVisibility(8);
        AppMethodBeat.o(96665);
      }
    });
    AppMethodBeat.o(96669);
  }
  
  public final void dUK()
  {
    AppMethodBeat.i(96674);
    super.dUK();
    this.mSensorManager.registerListener(this, this.cay, 1);
    this.mSensorManager.registerListener(this, this.caA, 1);
    AppMethodBeat.o(96674);
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(96675);
    super.dUL();
    this.mSensorManager.unregisterListener(this);
    AppMethodBeat.o(96675);
  }
  
  public final boolean eay()
  {
    AppMethodBeat.i(96673);
    if (eax() >= (int)(getView().getHeight() * 0.1F))
    {
      AppMethodBeat.o(96673);
      return true;
    }
    AppMethodBeat.o(96673);
    return false;
  }
  
  protected final int getLayout()
  {
    return 2131495494;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f2 = -10.0F;
    AppMethodBeat.i(96672);
    if (paramSensorEvent.sensor.getType() == 1) {
      this.zXn = paramSensorEvent.values;
    }
    if (paramSensorEvent.sensor.getType() == 2) {
      this.zXo = paramSensorEvent.values;
    }
    float f1;
    if ((this.zXn != null) && (this.zXo != null))
    {
      paramSensorEvent = new float[9];
      if (SensorManager.getRotationMatrix(paramSensorEvent, new float[9], this.zXn, this.zXo))
      {
        float[] arrayOfFloat = new float[3];
        SensorManager.getOrientation(paramSensorEvent, arrayOfFloat);
        float f3 = arrayOfFloat[2];
        if (this.zXj != 0)
        {
          f1 = f3;
          if (f3 > 10.0F) {
            f1 = 10.0F;
          }
          if (f1 >= -10.0F) {
            break label163;
          }
          f1 = f2;
        }
      }
    }
    label163:
    for (;;)
    {
      f1 = f1 * this.zXj / 10.0F;
      this.zXm.scrollBy((int)f1, 0);
      AppMethodBeat.o(96672);
      return;
    }
  }
  
  public final void setImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96671);
    if (paramBitmap == null)
    {
      ae.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp is null!");
      AppMethodBeat.o(96671);
      return;
    }
    if (this.dtJ == null)
    {
      ae.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the imageView is null!");
      AppMethodBeat.o(96671);
      return;
    }
    if (paramBitmap.getHeight() == 0)
    {
      ae.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp.getHeight is 0!");
      AppMethodBeat.o(96671);
      return;
    }
    this.progressBar.setVisibility(8);
    this.dtJ.setImageBitmap(paramBitmap);
    this.dtJ.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96667);
        int i = ab.this.dtJ.getMeasuredWidth();
        if (i > ab.this.lxZ)
        {
          ab localab = ab.this;
          localab.zXj = ((i - localab.lxZ) / 2);
          ab.this.zXm.scrollBy(ab.this.zXj, 0);
        }
        AppMethodBeat.o(96667);
      }
    });
    int i;
    if (paramBitmap.getHeight() != 0)
    {
      i = this.lya;
      if (((r)this.zUP).zRj == 2.147484E+009F) {
        break label176;
      }
      i = (int)((r)this.zUP).zRj;
    }
    label176:
    for (;;)
    {
      this.dtJ.setLayoutParams(new RelativeLayout.LayoutParams(paramBitmap.getWidth() * i / paramBitmap.getHeight(), i));
      AppMethodBeat.o(96671);
      return;
    }
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(96670);
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(96670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab
 * JD-Core Version:    0.7.0.1
 */