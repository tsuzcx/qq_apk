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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class z
  extends k
  implements SensorEventListener
{
  Sensor bQl;
  Sensor bQn;
  ImageView dhf;
  private SensorManager mSensorManager;
  ProgressBar progressBar;
  int ypi;
  final float ypj = 10.0F;
  final int ypk = 1;
  HorizontalScrollView ypl;
  float[] ypm;
  float[] ypn;
  private int ypo = 0;
  boolean ypp = true;
  
  public z(Context paramContext, r paramr, ViewGroup paramViewGroup)
  {
    super(paramContext, paramr, paramViewGroup);
  }
  
  public final boolean aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96676);
    if (!super.aH(paramJSONObject))
    {
      AppMethodBeat.o(96676);
      return false;
    }
    try
    {
      paramJSONObject.put("swipeCount", this.ypo);
      if (!this.ypp)
      {
        String str = ah.dg(((r)this.ymQ).yjd);
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
      ac.printErrStackTrace("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(96676);
    }
    return false;
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(96668);
    View localView = this.contentView;
    this.mSensorManager = ((SensorManager)ai.getContext().getSystemService("sensor"));
    this.bQl = this.mSensorManager.getDefaultSensor(1);
    this.bQn = this.mSensorManager.getDefaultSensor(2);
    this.ypl = ((HorizontalScrollView)localView.findViewById(2131296423));
    this.dhf = ((ImageView)localView.findViewById(2131296424));
    this.progressBar = ((ProgressBar)localView.findViewById(2131303535));
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(96668);
  }
  
  public final void dJY()
  {
    AppMethodBeat.i(96674);
    super.dJY();
    this.mSensorManager.registerListener(this, this.bQl, 1);
    this.mSensorManager.registerListener(this, this.bQn, 1);
    AppMethodBeat.o(96674);
  }
  
  public final void dJZ()
  {
    AppMethodBeat.i(96675);
    super.dJZ();
    this.mSensorManager.unregisterListener(this);
    AppMethodBeat.o(96675);
  }
  
  public final boolean dKC()
  {
    AppMethodBeat.i(96673);
    if (dKB() >= (int)(getView().getHeight() * 0.1F))
    {
      AppMethodBeat.o(96673);
      return true;
    }
    AppMethodBeat.o(96673);
    return false;
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96669);
    if (!i.eA(h.js("adId", ((r)this.ymQ).yjd))) {
      this.ypp = false;
    }
    String str = ((r)this.ymQ).yjd;
    Bitmap localBitmap = h.jw("adId", str);
    if (localBitmap != null)
    {
      ac.i("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "loaded cached image with  ".concat(String.valueOf(str)));
      setImage(localBitmap);
      AppMethodBeat.o(96669);
      return;
    }
    startLoading();
    h.a(str, ((r)this.ymQ).yjt, new f.a()
    {
      public final void asD(String paramAnonymousString)
      {
        AppMethodBeat.i(96666);
        try
        {
          paramAnonymousString = f.decodeFile(paramAnonymousString);
          z.this.setImage(paramAnonymousString);
          AppMethodBeat.o(96666);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          ac.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "%s" + bs.m(paramAnonymousString));
          AppMethodBeat.o(96666);
        }
      }
      
      public final void dFC()
      {
        AppMethodBeat.i(96664);
        z.this.startLoading();
        AppMethodBeat.o(96664);
      }
      
      public final void dFD()
      {
        AppMethodBeat.i(96665);
        z.this.progressBar.setVisibility(8);
        AppMethodBeat.o(96665);
      }
    });
    AppMethodBeat.o(96669);
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
      this.ypm = paramSensorEvent.values;
    }
    if (paramSensorEvent.sensor.getType() == 2) {
      this.ypn = paramSensorEvent.values;
    }
    float f1;
    if ((this.ypm != null) && (this.ypn != null))
    {
      paramSensorEvent = new float[9];
      if (SensorManager.getRotationMatrix(paramSensorEvent, new float[9], this.ypm, this.ypn))
      {
        float[] arrayOfFloat = new float[3];
        SensorManager.getOrientation(paramSensorEvent, arrayOfFloat);
        float f3 = arrayOfFloat[2];
        if (this.ypi != 0)
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
      f1 = f1 * this.ypi / 10.0F;
      this.ypl.scrollBy((int)f1, 0);
      AppMethodBeat.o(96672);
      return;
    }
  }
  
  public final void setImage(Bitmap paramBitmap)
  {
    AppMethodBeat.i(96671);
    if (paramBitmap == null)
    {
      ac.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp is null!");
      AppMethodBeat.o(96671);
      return;
    }
    if (this.dhf == null)
    {
      ac.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the imageView is null!");
      AppMethodBeat.o(96671);
      return;
    }
    if (paramBitmap.getHeight() == 0)
    {
      ac.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp.getHeight is 0!");
      AppMethodBeat.o(96671);
      return;
    }
    this.progressBar.setVisibility(8);
    this.dhf.setImageBitmap(paramBitmap);
    this.dhf.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96667);
        int i = z.this.dhf.getMeasuredWidth();
        if (i > z.this.kWB)
        {
          z localz = z.this;
          localz.ypi = ((i - localz.kWB) / 2);
          z.this.ypl.scrollBy(z.this.ypi, 0);
        }
        AppMethodBeat.o(96667);
      }
    });
    int i;
    if (paramBitmap.getHeight() != 0)
    {
      i = this.kWC;
      if (((r)this.ymQ).yjv == 2.147484E+009F) {
        break label176;
      }
      i = (int)((r)this.ymQ).yjv;
    }
    label176:
    for (;;)
    {
      this.dhf.setLayoutParams(new RelativeLayout.LayoutParams(paramBitmap.getWidth() * i / paramBitmap.getHeight(), i));
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
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z
 * JD-Core Version:    0.7.0.1
 */