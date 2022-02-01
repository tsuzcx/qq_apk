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
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class ad
  extends n
  implements SensorEventListener
{
  Sensor QQT;
  Sensor QQU;
  int QQV;
  final float QQW = 10.0F;
  final int QQX = 1;
  HorizontalScrollView QQY;
  float[] QQZ;
  float[] QRa;
  private int QRb = 0;
  boolean QRc = true;
  ImageView hIz;
  private SensorManager mSensorManager;
  ProgressBar progressBar;
  
  public ad(Context paramContext, t paramt, ViewGroup paramViewGroup)
  {
    super(paramContext, paramt, paramViewGroup);
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(96668);
    View localView = this.contentView;
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    this.QQT = this.mSensorManager.getDefaultSensor(1);
    this.QQU = this.mSensorManager.getDefaultSensor(2);
    this.QQY = ((HorizontalScrollView)localView.findViewById(b.f.activity_gyroscope_horizontalscrollview));
    this.hIz = ((ImageView)localView.findViewById(b.f.activity_gyroscope_img));
    this.progressBar = ((ProgressBar)localView.findViewById(b.f.progressbar));
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(96668);
  }
  
  public final boolean bP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96676);
    if (!super.bP(paramJSONObject))
    {
      AppMethodBeat.o(96676);
      return false;
    }
    try
    {
      paramJSONObject.put("swipeCount", this.QRb);
      if (!this.QRc)
      {
        String str = MD5Util.getMD5String(((t)this.QOV).QKj);
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
  
  protected final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_gyroscope_image_view;
  }
  
  protected final void had()
  {
    AppMethodBeat.i(96669);
    if (!y.ZC(k.mC("adId", ((t)this.QOV).QKj))) {
      this.QRc = false;
    }
    String str = ((t)this.QOV).QKj;
    Bitmap localBitmap = k.mH("adId", str);
    if (localBitmap != null)
    {
      Log.i("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "loaded cached image with  ".concat(String.valueOf(str)));
      setImage(localBitmap);
      AppMethodBeat.o(96669);
      return;
    }
    startLoading();
    k.b("adId", str, new g.a()
    {
      public final void aWn(String paramAnonymousString)
      {
        AppMethodBeat.i(96666);
        try
        {
          paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString);
          ad.this.setImage(paramAnonymousString);
          AppMethodBeat.o(96666);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "%s" + Util.stackTraceToString(paramAnonymousString));
          AppMethodBeat.o(96666);
        }
      }
      
      public final void gZM()
      {
        AppMethodBeat.i(96664);
        ad.this.startLoading();
        AppMethodBeat.o(96664);
      }
      
      public final void gZN()
      {
        AppMethodBeat.i(96665);
        ad.this.progressBar.setVisibility(8);
        AppMethodBeat.o(96665);
      }
    });
    AppMethodBeat.o(96669);
  }
  
  public final void hao()
  {
    AppMethodBeat.i(96674);
    super.hao();
    this.mSensorManager.registerListener(this, this.QQT, 1);
    this.mSensorManager.registerListener(this, this.QQU, 1);
    AppMethodBeat.o(96674);
  }
  
  public final void hap()
  {
    AppMethodBeat.i(96675);
    super.hap();
    this.mSensorManager.unregisterListener(this);
    AppMethodBeat.o(96675);
  }
  
  public final boolean hji()
  {
    AppMethodBeat.i(96673);
    if (hjh() >= (int)(getView().getHeight() * 0.1F))
    {
      AppMethodBeat.o(96673);
      return true;
    }
    AppMethodBeat.o(96673);
    return false;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f2 = -10.0F;
    AppMethodBeat.i(96672);
    if (paramSensorEvent.sensor.getType() == 1) {
      this.QQZ = paramSensorEvent.values;
    }
    if (paramSensorEvent.sensor.getType() == 2) {
      this.QRa = paramSensorEvent.values;
    }
    float f1;
    if ((this.QQZ != null) && (this.QRa != null))
    {
      paramSensorEvent = new float[9];
      if (SensorManager.getRotationMatrix(paramSensorEvent, new float[9], this.QQZ, this.QRa))
      {
        float[] arrayOfFloat = new float[3];
        SensorManager.getOrientation(paramSensorEvent, arrayOfFloat);
        float f3 = arrayOfFloat[2];
        if (this.QQV != 0)
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
      f1 = f1 * this.QQV / 10.0F;
      this.QQY.scrollBy((int)f1, 0);
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
    if (this.hIz == null)
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
    this.hIz.setImageBitmap(paramBitmap);
    this.hIz.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96667);
        int i = ad.this.hIz.getMeasuredWidth();
        if (i > ad.this.sJv)
        {
          ad localad = ad.this;
          localad.QQV = ((i - localad.sJv) / 2);
          ad.this.QQY.scrollBy(ad.this.QQV, 0);
        }
        AppMethodBeat.o(96667);
      }
    });
    int i;
    if (paramBitmap.getHeight() != 0)
    {
      i = this.pvg;
      if (((t)this.QOV).QKJ == 2.147484E+009F) {
        break label176;
      }
      i = (int)((t)this.QOV).QKJ;
    }
    label176:
    for (;;)
    {
      this.hIz.setLayoutParams(new RelativeLayout.LayoutParams(paramBitmap.getWidth() * i / paramBitmap.getHeight(), i));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad
 * JD-Core Version:    0.7.0.1
 */