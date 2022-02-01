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
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class z
  extends k
  implements SensorEventListener
{
  Sensor bSD;
  Sensor bSF;
  ImageView djK;
  private SensorManager mSensorManager;
  ProgressBar progressBar;
  private int xcA = 0;
  boolean xcB = true;
  int xcu;
  final float xcv = 10.0F;
  final int xcw = 1;
  HorizontalScrollView xcx;
  float[] xcy;
  float[] xcz;
  
  public z(Context paramContext, r paramr, ViewGroup paramViewGroup)
  {
    super(paramContext, paramr, paramViewGroup);
  }
  
  public final boolean aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96676);
    if (!super.aG(paramJSONObject))
    {
      AppMethodBeat.o(96676);
      return false;
    }
    try
    {
      paramJSONObject.put("swipeCount", this.xcA);
      if (!this.xcB)
      {
        String str = ai.du(((r)this.xab).wWp);
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
  
  public final void dvA()
  {
    AppMethodBeat.i(96675);
    super.dvA();
    this.mSensorManager.unregisterListener(this);
    AppMethodBeat.o(96675);
  }
  
  protected final void dvN()
  {
    AppMethodBeat.i(96669);
    if (!i.eK(h.iU("adId", ((r)this.xab).wWp))) {
      this.xcB = false;
    }
    String str = ((r)this.xab).wWp;
    Bitmap localBitmap = h.iY("adId", str);
    if (localBitmap != null)
    {
      ad.i("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "loaded cached image with  ".concat(String.valueOf(str)));
      setImage(localBitmap);
      AppMethodBeat.o(96669);
      return;
    }
    startLoading();
    h.a(str, ((r)this.xab).wWF, new f.a()
    {
      public final void apm(String paramAnonymousString)
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
          ad.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "%s" + bt.m(paramAnonymousString));
          AppMethodBeat.o(96666);
        }
      }
      
      public final void dsA()
      {
        AppMethodBeat.i(96665);
        z.this.progressBar.setVisibility(8);
        AppMethodBeat.o(96665);
      }
      
      public final void duP()
      {
        AppMethodBeat.i(96664);
        z.this.startLoading();
        AppMethodBeat.o(96664);
      }
    });
    AppMethodBeat.o(96669);
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(96668);
    View localView = this.contentView;
    this.mSensorManager = ((SensorManager)aj.getContext().getSystemService("sensor"));
    this.bSD = this.mSensorManager.getDefaultSensor(1);
    this.bSF = this.mSensorManager.getDefaultSensor(2);
    this.xcx = ((HorizontalScrollView)localView.findViewById(2131296423));
    this.djK = ((ImageView)localView.findViewById(2131296424));
    this.progressBar = ((ProgressBar)localView.findViewById(2131303535));
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(96668);
  }
  
  public final void dvz()
  {
    AppMethodBeat.i(96674);
    super.dvz();
    this.mSensorManager.registerListener(this, this.bSD, 1);
    this.mSensorManager.registerListener(this, this.bSF, 1);
    AppMethodBeat.o(96674);
  }
  
  public final boolean dwd()
  {
    AppMethodBeat.i(96673);
    if (dwc() >= (int)(getView().getHeight() * 0.1F))
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
      this.xcy = paramSensorEvent.values;
    }
    if (paramSensorEvent.sensor.getType() == 2) {
      this.xcz = paramSensorEvent.values;
    }
    float f1;
    if ((this.xcy != null) && (this.xcz != null))
    {
      paramSensorEvent = new float[9];
      if (SensorManager.getRotationMatrix(paramSensorEvent, new float[9], this.xcy, this.xcz))
      {
        float[] arrayOfFloat = new float[3];
        SensorManager.getOrientation(paramSensorEvent, arrayOfFloat);
        float f3 = arrayOfFloat[2];
        if (this.xcu != 0)
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
      f1 = f1 * this.xcu / 10.0F;
      this.xcx.scrollBy((int)f1, 0);
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
    if (this.djK == null)
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
    this.djK.setImageBitmap(paramBitmap);
    this.djK.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96667);
        int i = z.this.djK.getMeasuredWidth();
        if (i > z.this.kvn)
        {
          z localz = z.this;
          localz.xcu = ((i - localz.kvn) / 2);
          z.this.xcx.scrollBy(z.this.xcu, 0);
        }
        AppMethodBeat.o(96667);
      }
    });
    int i;
    if (paramBitmap.getHeight() != 0)
    {
      i = this.kvo;
      if (((r)this.xab).wWH == 2.147484E+009F) {
        break label176;
      }
      i = (int)((r)this.xab).wWH;
    }
    label176:
    for (;;)
    {
      this.djK.setLayoutParams(new RelativeLayout.LayoutParams(paramBitmap.getWidth() * i / paramBitmap.getHeight(), i));
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
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z
 * JD-Core Version:    0.7.0.1
 */