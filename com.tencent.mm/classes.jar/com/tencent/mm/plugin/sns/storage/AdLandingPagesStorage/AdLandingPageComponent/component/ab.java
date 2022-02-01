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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab
  extends m
  implements SensorEventListener
{
  int Efs;
  final float Eft = 10.0F;
  final int Efu = 1;
  HorizontalScrollView Efv;
  float[] Efw;
  float[] Efx;
  private int Efy = 0;
  boolean Efz = true;
  Sensor cle;
  Sensor clg;
  ImageView dKU;
  private SensorManager mSensorManager;
  ProgressBar progressBar;
  
  public ab(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s params, ViewGroup paramViewGroup)
  {
    super(paramContext, params, paramViewGroup);
  }
  
  public final boolean bp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96676);
    if (!super.bp(paramJSONObject))
    {
      AppMethodBeat.o(96676);
      return false;
    }
    try
    {
      paramJSONObject.put("swipeCount", this.Efy);
      if (!this.Efz)
      {
        String str = MD5Util.getMD5String(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)this.EcX).DYK);
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
      Log.printErrStackTrace("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96676);
    }
    return false;
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(96669);
    if (!com.tencent.mm.vfs.s.YS(h.kz("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)this.EcX).DYK))) {
      this.Efz = false;
    }
    String str = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)this.EcX).DYK;
    Bitmap localBitmap = h.kD("adId", str);
    if (localBitmap != null)
    {
      Log.i("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "loaded cached image with  ".concat(String.valueOf(str)));
      setImage(localBitmap);
      AppMethodBeat.o(96669);
      return;
    }
    startLoading();
    h.a(str, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)this.EcX).DZj, new f.a()
    {
      public final void aNH(String paramAnonymousString)
      {
        AppMethodBeat.i(96666);
        try
        {
          paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString);
          ab.this.setImage(paramAnonymousString);
          AppMethodBeat.o(96666);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "%s" + Util.stackTraceToString(paramAnonymousString));
          AppMethodBeat.o(96666);
        }
      }
      
      public final void eWN()
      {
        AppMethodBeat.i(96664);
        ab.this.startLoading();
        AppMethodBeat.o(96664);
      }
      
      public final void eWO()
      {
        AppMethodBeat.i(96665);
        ab.this.progressBar.setVisibility(8);
        AppMethodBeat.o(96665);
      }
    });
    AppMethodBeat.o(96669);
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(96674);
    super.eWZ();
    this.mSensorManager.registerListener(this, this.cle, 1);
    this.mSensorManager.registerListener(this, this.clg, 1);
    AppMethodBeat.o(96674);
  }
  
  public final void eXa()
  {
    AppMethodBeat.i(96675);
    super.eXa();
    this.mSensorManager.unregisterListener(this);
    AppMethodBeat.o(96675);
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(96668);
    View localView = this.contentView;
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    this.cle = this.mSensorManager.getDefaultSensor(1);
    this.clg = this.mSensorManager.getDefaultSensor(2);
    this.Efv = ((HorizontalScrollView)localView.findViewById(2131296458));
    this.dKU = ((ImageView)localView.findViewById(2131296459));
    this.progressBar = ((ProgressBar)localView.findViewById(2131306302));
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(96668);
  }
  
  public final boolean fdm()
  {
    AppMethodBeat.i(96673);
    if (fdl() >= (int)(getView().getHeight() * 0.1F))
    {
      AppMethodBeat.o(96673);
      return true;
    }
    AppMethodBeat.o(96673);
    return false;
  }
  
  protected final int getLayout()
  {
    return 2131496377;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f2 = -10.0F;
    AppMethodBeat.i(96672);
    if (paramSensorEvent.sensor.getType() == 1) {
      this.Efw = paramSensorEvent.values;
    }
    if (paramSensorEvent.sensor.getType() == 2) {
      this.Efx = paramSensorEvent.values;
    }
    float f1;
    if ((this.Efw != null) && (this.Efx != null))
    {
      paramSensorEvent = new float[9];
      if (SensorManager.getRotationMatrix(paramSensorEvent, new float[9], this.Efw, this.Efx))
      {
        float[] arrayOfFloat = new float[3];
        SensorManager.getOrientation(paramSensorEvent, arrayOfFloat);
        float f3 = arrayOfFloat[2];
        if (this.Efs != 0)
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
      f1 = f1 * this.Efs / 10.0F;
      this.Efv.scrollBy((int)f1, 0);
      AppMethodBeat.o(96672);
      return;
    }
  }
  
  public final void setImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96671);
    if (paramBitmap == null)
    {
      Log.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp is null!");
      AppMethodBeat.o(96671);
      return;
    }
    if (this.dKU == null)
    {
      Log.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the imageView is null!");
      AppMethodBeat.o(96671);
      return;
    }
    if (paramBitmap.getHeight() == 0)
    {
      Log.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp.getHeight is 0!");
      AppMethodBeat.o(96671);
      return;
    }
    this.progressBar.setVisibility(8);
    this.dKU.setImageBitmap(paramBitmap);
    this.dKU.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96667);
        int i = ab.this.dKU.getMeasuredWidth();
        if (i > ab.this.mEX)
        {
          ab localab = ab.this;
          localab.Efs = ((i - localab.mEX) / 2);
          ab.this.Efv.scrollBy(ab.this.Efs, 0);
        }
        AppMethodBeat.o(96667);
      }
    });
    int i;
    if (paramBitmap.getHeight() != 0)
    {
      i = this.mEY;
      if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)this.EcX).DZl == 2.147484E+009F) {
        break label176;
      }
      i = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s)this.EcX).DZl;
    }
    label176:
    for (;;)
    {
      this.dKU.setLayoutParams(new RelativeLayout.LayoutParams(paramBitmap.getWidth() * i / paramBitmap.getHeight(), i));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab
 * JD-Core Version:    0.7.0.1
 */