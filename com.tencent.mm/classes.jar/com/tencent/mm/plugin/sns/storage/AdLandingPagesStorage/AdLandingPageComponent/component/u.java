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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class u
  extends h
  implements SensorEventListener
{
  Sensor accelerometer;
  private SensorManager bmB;
  Sensor bqj;
  ImageView cuM;
  ProgressBar progressBar;
  int rxm;
  final float rxn = 10.0F;
  final int rxo = 1;
  HorizontalScrollView rxp;
  float[] rxq;
  float[] rxr;
  private int rxs = 0;
  boolean rxt = true;
  
  public u(Context paramContext, n paramn, ViewGroup paramViewGroup)
  {
    super(paramContext, paramn, paramViewGroup);
  }
  
  public final boolean aq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(37256);
    if (!super.aq(paramJSONObject))
    {
      AppMethodBeat.o(37256);
      return false;
    }
    try
    {
      paramJSONObject.put("swipeCount", this.rxs);
      if (!this.rxt)
      {
        String str = ag.cE(((n)this.rve).rsw);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("urlMd5", str);
        localJSONObject.put("needDownload", 1);
        paramJSONObject.put("imgUrlInfo", localJSONObject);
      }
      AppMethodBeat.o(37256);
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      ab.printErrStackTrace("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(37256);
    }
    return false;
  }
  
  public final void cqA()
  {
    AppMethodBeat.i(37254);
    super.cqA();
    this.bmB.registerListener(this, this.accelerometer, 1);
    this.bmB.registerListener(this, this.bqj, 1);
    AppMethodBeat.o(37254);
  }
  
  public final void cqB()
  {
    AppMethodBeat.i(37255);
    super.cqB();
    this.bmB.unregisterListener(this);
    AppMethodBeat.o(37255);
  }
  
  public final void cqK()
  {
    AppMethodBeat.i(37248);
    View localView = this.contentView;
    this.bmB = ((SensorManager)ah.getContext().getSystemService("sensor"));
    this.accelerometer = this.bmB.getDefaultSensor(1);
    this.bqj = this.bmB.getDefaultSensor(2);
    this.rxp = ((HorizontalScrollView)localView.findViewById(2131827845));
    this.cuM = ((ImageView)localView.findViewById(2131827846));
    this.progressBar = ((ProgressBar)localView.findViewById(2131821246));
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(37248);
  }
  
  protected final void cqP()
  {
    AppMethodBeat.i(37249);
    if (!e.cN(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.gy("adId", ((n)this.rve).rsw))) {
      this.rxt = false;
    }
    String str = ((n)this.rve).rsw;
    Bitmap localBitmap = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.gB("adId", str);
    if (localBitmap != null)
    {
      ab.i("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "loaded cached image with  ".concat(String.valueOf(str)));
      setImage(localBitmap);
      AppMethodBeat.o(37249);
      return;
    }
    startLoading();
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(str, ((n)this.rve).rsJ, new u.1(this));
    AppMethodBeat.o(37249);
  }
  
  public final boolean cqX()
  {
    AppMethodBeat.i(37253);
    if (cqW() >= (int)(getView().getHeight() * 0.1F))
    {
      AppMethodBeat.o(37253);
      return true;
    }
    AppMethodBeat.o(37253);
    return false;
  }
  
  protected final int getLayout()
  {
    return 2130970776;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f2 = -10.0F;
    AppMethodBeat.i(37252);
    if (paramSensorEvent.sensor.getType() == 1) {
      this.rxq = paramSensorEvent.values;
    }
    if (paramSensorEvent.sensor.getType() == 2) {
      this.rxr = paramSensorEvent.values;
    }
    float f1;
    if ((this.rxq != null) && (this.rxr != null))
    {
      paramSensorEvent = new float[9];
      if (SensorManager.getRotationMatrix(paramSensorEvent, new float[9], this.rxq, this.rxr))
      {
        float[] arrayOfFloat = new float[3];
        SensorManager.getOrientation(paramSensorEvent, arrayOfFloat);
        float f3 = arrayOfFloat[2];
        if (this.rxm != 0)
        {
          f1 = f3;
          if (f3 > 10.0F) {
            f1 = 10.0F;
          }
          if (f1 >= -10.0F) {
            break label159;
          }
          f1 = f2;
        }
      }
    }
    label159:
    for (;;)
    {
      f1 = f1 * this.rxm / 10.0F;
      this.rxp.scrollBy((int)f1, 0);
      AppMethodBeat.o(37252);
      return;
    }
  }
  
  public final void setImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(37251);
    if (paramBitmap == null)
    {
      ab.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp is null!");
      AppMethodBeat.o(37251);
      return;
    }
    if (this.cuM == null)
    {
      ab.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the imageView is null!");
      AppMethodBeat.o(37251);
      return;
    }
    if (paramBitmap.getHeight() == 0)
    {
      ab.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp.getHeight is 0!");
      AppMethodBeat.o(37251);
      return;
    }
    this.progressBar.setVisibility(8);
    this.cuM.setImageBitmap(paramBitmap);
    this.cuM.post(new u.2(this));
    int i;
    if (paramBitmap.getHeight() != 0)
    {
      i = this.iiX;
      if (((n)this.rve).rsL == 2.147484E+009F) {
        break label176;
      }
      i = (int)((n)this.rve).rsL;
    }
    label176:
    for (;;)
    {
      this.cuM.setLayoutParams(new RelativeLayout.LayoutParams(paramBitmap.getWidth() * i / paramBitmap.getHeight(), i));
      AppMethodBeat.o(37251);
      return;
    }
  }
  
  public final void startLoading()
  {
    AppMethodBeat.i(37250);
    this.progressBar.setVisibility(0);
    AppMethodBeat.o(37250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u
 * JD-Core Version:    0.7.0.1
 */