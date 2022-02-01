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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.vfs.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class aa
  extends l
  implements SensorEventListener
{
  Sensor caA;
  Sensor cay;
  ImageView dsD;
  private SensorManager mSensorManager;
  ProgressBar progressBar;
  int zGd;
  final float zGe = 10.0F;
  final int zGf = 1;
  HorizontalScrollView zGg;
  float[] zGh;
  float[] zGi;
  private int zGj = 0;
  boolean zGk = true;
  
  public aa(Context paramContext, r paramr, ViewGroup paramViewGroup)
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
      paramJSONObject.put("swipeCount", this.zGj);
      if (!this.zGk)
      {
        String str = ai.ee(((r)this.zDK).zzL);
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
      ad.printErrStackTrace("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96676);
    }
    return false;
  }
  
  public final void dRk()
  {
    AppMethodBeat.i(96668);
    View localView = this.contentView;
    this.mSensorManager = ((SensorManager)aj.getContext().getSystemService("sensor"));
    this.cay = this.mSensorManager.getDefaultSensor(1);
    this.caA = this.mSensorManager.getDefaultSensor(2);
    this.zGg = ((HorizontalScrollView)localView.findViewById(2131296423));
    this.dsD = ((ImageView)localView.findViewById(2131296424));
    this.progressBar = ((ProgressBar)localView.findViewById(2131303535));
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(96668);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96669);
    if (!i.fv(h.jF("adId", ((r)this.zDK).zzL))) {
      this.zGk = false;
    }
    String str = ((r)this.zDK).zzL;
    Bitmap localBitmap = h.jJ("adId", str);
    if (localBitmap != null)
    {
      ad.i("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "loaded cached image with  ".concat(String.valueOf(str)));
      setImage(localBitmap);
      AppMethodBeat.o(96669);
      return;
    }
    startLoading();
    h.a(str, ((r)this.zDK).zAh, new f.a()
    {
      public final void axG(String paramAnonymousString)
      {
        AppMethodBeat.i(96666);
        try
        {
          paramAnonymousString = g.decodeFile(paramAnonymousString);
          aa.this.setImage(paramAnonymousString);
          AppMethodBeat.o(96666);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ad.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "%s" + bt.n(paramAnonymousString));
          AppMethodBeat.o(96666);
        }
      }
      
      public final void dRW()
      {
        AppMethodBeat.i(96664);
        aa.this.startLoading();
        AppMethodBeat.o(96664);
      }
      
      public final void dRX()
      {
        AppMethodBeat.i(96665);
        aa.this.progressBar.setVisibility(8);
        AppMethodBeat.o(96665);
      }
    });
    AppMethodBeat.o(96669);
  }
  
  public final void dRm()
  {
    AppMethodBeat.i(96674);
    super.dRm();
    this.mSensorManager.registerListener(this, this.cay, 1);
    this.mSensorManager.registerListener(this, this.caA, 1);
    AppMethodBeat.o(96674);
  }
  
  public final void dRn()
  {
    AppMethodBeat.i(96675);
    super.dRn();
    this.mSensorManager.unregisterListener(this);
    AppMethodBeat.o(96675);
  }
  
  public final boolean dWU()
  {
    AppMethodBeat.i(96673);
    if (dWT() >= (int)(getView().getHeight() * 0.1F))
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
      this.zGh = paramSensorEvent.values;
    }
    if (paramSensorEvent.sensor.getType() == 2) {
      this.zGi = paramSensorEvent.values;
    }
    float f1;
    if ((this.zGh != null) && (this.zGi != null))
    {
      paramSensorEvent = new float[9];
      if (SensorManager.getRotationMatrix(paramSensorEvent, new float[9], this.zGh, this.zGi))
      {
        float[] arrayOfFloat = new float[3];
        SensorManager.getOrientation(paramSensorEvent, arrayOfFloat);
        float f3 = arrayOfFloat[2];
        if (this.zGd != 0)
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
      f1 = f1 * this.zGd / 10.0F;
      this.zGg.scrollBy((int)f1, 0);
      AppMethodBeat.o(96672);
      return;
    }
  }
  
  public final void setImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96671);
    if (paramBitmap == null)
    {
      ad.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp is null!");
      AppMethodBeat.o(96671);
      return;
    }
    if (this.dsD == null)
    {
      ad.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the imageView is null!");
      AppMethodBeat.o(96671);
      return;
    }
    if (paramBitmap.getHeight() == 0)
    {
      ad.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp.getHeight is 0!");
      AppMethodBeat.o(96671);
      return;
    }
    this.progressBar.setVisibility(8);
    this.dsD.setImageBitmap(paramBitmap);
    this.dsD.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96667);
        int i = aa.this.dsD.getMeasuredWidth();
        if (i > aa.this.ltA)
        {
          aa localaa = aa.this;
          localaa.zGd = ((i - localaa.ltA) / 2);
          aa.this.zGg.scrollBy(aa.this.zGd, 0);
        }
        AppMethodBeat.o(96667);
      }
    });
    int i;
    if (paramBitmap.getHeight() != 0)
    {
      i = this.ltB;
      if (((r)this.zDK).zAj == 2.147484E+009F) {
        break label176;
      }
      i = (int)((r)this.zDK).zAj;
    }
    label176:
    for (;;)
    {
      this.dsD.setLayoutParams(new RelativeLayout.LayoutParams(paramBitmap.getWidth() * i / paramBitmap.getHeight(), i));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa
 * JD-Core Version:    0.7.0.1
 */