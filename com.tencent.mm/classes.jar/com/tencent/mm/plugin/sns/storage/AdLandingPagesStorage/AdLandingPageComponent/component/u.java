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
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class u
  extends i
  implements SensorEventListener
{
  private SensorManager aVT;
  Sensor aZD;
  Sensor accelerometer;
  ImageView bNu;
  ProgressBar frw;
  float[] oHA;
  float[] oHB;
  private int oHC = 0;
  boolean oHD = true;
  int oHw;
  final float oHx = 10.0F;
  final int oHy = 1;
  HorizontalScrollView oHz;
  
  public u(Context paramContext, o paramo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramo, paramViewGroup);
  }
  
  public final boolean ah(JSONObject paramJSONObject)
  {
    if (!super.ah(paramJSONObject)) {
      return false;
    }
    try
    {
      paramJSONObject.put("swipeCount", this.oHC);
      if (!this.oHD)
      {
        String str = ad.bB(((o)this.oFE).oCV);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("urlMd5", str);
        localJSONObject.put("needDownload", 1);
        paramJSONObject.put("imgUrlInfo", localJSONObject);
      }
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      y.printErrStackTrace("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", paramJSONObject, "", new Object[0]);
    }
    return false;
  }
  
  public final void bET()
  {
    super.bET();
    this.aVT.registerListener(this, this.accelerometer, 1);
    this.aVT.registerListener(this, this.aZD, 1);
  }
  
  public final void bEU()
  {
    super.bEU();
    this.aVT.unregisterListener(this);
  }
  
  public final View bFf()
  {
    View localView = this.contentView;
    this.aVT = ((SensorManager)this.context.getSystemService("sensor"));
    this.accelerometer = this.aVT.getDefaultSensor(1);
    this.aZD = this.aVT.getDefaultSensor(2);
    this.oHz = ((HorizontalScrollView)localView.findViewById(i.f.activity_gyroscope_horizontalscrollview));
    this.bNu = ((ImageView)localView.findViewById(i.f.activity_gyroscope_img));
    this.frw = ((ProgressBar)localView.findViewById(i.f.progressbar));
    this.frw.setVisibility(8);
    return localView;
  }
  
  protected final void bFj()
  {
    if (!e.bK(h.eS("adId", ((o)this.oFE).oCV))) {
      this.oHD = false;
    }
    this.oHz.setLayoutParams(new RelativeLayout.LayoutParams(this.gHR, this.gHS));
    this.bNu.setLayoutParams(new RelativeLayout.LayoutParams(this.gHR, this.gHS));
    this.contentView.setLayoutParams(new LinearLayout.LayoutParams(this.gHR, this.gHS));
    this.contentView.setPadding(this.contentView.getPaddingLeft(), (int)((o)this.oFE).oDi, this.contentView.getPaddingRight(), (int)((o)this.oFE).oDj);
    String str = ((o)this.oFE).oCV;
    Bitmap localBitmap = h.eV("adId", str);
    if (localBitmap != null)
    {
      y.i("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "loaded cached image with  " + str);
      setImage(localBitmap);
      return;
    }
    startLoading();
    h.a(str, ((o)this.oFE).oDh, new u.1(this));
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_gyroscope_image_view;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f2 = -10.0F;
    if (paramSensorEvent.sensor.getType() == 1) {
      this.oHA = paramSensorEvent.values;
    }
    if (paramSensorEvent.sensor.getType() == 2) {
      this.oHB = paramSensorEvent.values;
    }
    float f1;
    if ((this.oHA != null) && (this.oHB != null))
    {
      paramSensorEvent = new float[9];
      if (SensorManager.getRotationMatrix(paramSensorEvent, new float[9], this.oHA, this.oHB))
      {
        float[] arrayOfFloat = new float[3];
        SensorManager.getOrientation(paramSensorEvent, arrayOfFloat);
        float f3 = arrayOfFloat[2];
        if (this.oHw != 0)
        {
          f1 = f3;
          if (f3 > 10.0F) {
            f1 = 10.0F;
          }
          if (f1 >= -10.0F) {
            break label151;
          }
          f1 = f2;
        }
      }
    }
    label151:
    for (;;)
    {
      f1 = f1 * this.oHw / 10.0F;
      this.oHz.scrollBy((int)f1, 0);
      return;
    }
  }
  
  public final void setImage(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      y.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp is null!");
    }
    do
    {
      return;
      if (this.bNu == null)
      {
        y.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the imageView is null!");
        return;
      }
      if (paramBitmap.getHeight() == 0)
      {
        y.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp.getHeight is 0!");
        return;
      }
      this.frw.setVisibility(8);
      this.bNu.setImageBitmap(paramBitmap);
      this.bNu.setLayoutParams(new RelativeLayout.LayoutParams(paramBitmap.getWidth() * this.gHS / paramBitmap.getHeight(), this.gHS));
      this.bNu.post(new u.2(this));
    } while (paramBitmap.getHeight() == 0);
    this.contentView.setLayoutParams(new LinearLayout.LayoutParams(paramBitmap.getWidth() * this.gHS / paramBitmap.getHeight(), this.gHS));
  }
  
  public final void startLoading()
  {
    this.frw.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u
 * JD-Core Version:    0.7.0.1
 */