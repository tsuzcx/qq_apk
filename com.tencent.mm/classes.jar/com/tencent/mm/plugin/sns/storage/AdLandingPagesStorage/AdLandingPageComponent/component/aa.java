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
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import org.json.JSONException;
import org.json.JSONObject;

public final class aa
  extends m
  implements SensorEventListener
{
  HorizontalScrollView KsA;
  float[] KsB;
  float[] KsC;
  private int KsD = 0;
  boolean KsE = true;
  Sensor Ksv;
  Sensor Ksw;
  int Ksx;
  final float Ksy = 10.0F;
  final int Ksz = 1;
  ImageView fDJ;
  private SensorManager mSensorManager;
  ProgressBar progressBar;
  
  public aa(Context paramContext, t paramt, ViewGroup paramViewGroup)
  {
    super(paramContext, paramt, paramViewGroup);
  }
  
  public final boolean by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96676);
    if (!super.by(paramJSONObject))
    {
      AppMethodBeat.o(96676);
      return false;
    }
    try
    {
      paramJSONObject.put("swipeCount", this.KsD);
      if (!this.KsE)
      {
        String str = MD5Util.getMD5String(((t)this.KqB).Kmf);
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
  
  protected final void fKe()
  {
    AppMethodBeat.i(96669);
    if (!u.agG(h.kU("adId", ((t)this.KqB).Kmf))) {
      this.KsE = false;
    }
    String str = ((t)this.KqB).Kmf;
    Bitmap localBitmap = h.kZ("adId", str);
    if (localBitmap != null)
    {
      Log.i("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "loaded cached image with  ".concat(String.valueOf(str)));
      setImage(localBitmap);
      AppMethodBeat.o(96669);
      return;
    }
    startLoading();
    h.a("adId", str, new f.a()
    {
      public final void aYs(String paramAnonymousString)
      {
        AppMethodBeat.i(96666);
        try
        {
          paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString);
          aa.this.setImage(paramAnonymousString);
          AppMethodBeat.o(96666);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "%s" + Util.stackTraceToString(paramAnonymousString));
          AppMethodBeat.o(96666);
        }
      }
      
      public final void fJU()
      {
        AppMethodBeat.i(96664);
        aa.this.startLoading();
        AppMethodBeat.o(96664);
      }
      
      public final void fJV()
      {
        AppMethodBeat.i(96665);
        aa.this.progressBar.setVisibility(8);
        AppMethodBeat.o(96665);
      }
    });
    AppMethodBeat.o(96669);
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(96674);
    super.fKk();
    this.mSensorManager.registerListener(this, this.Ksv, 1);
    this.mSensorManager.registerListener(this, this.Ksw, 1);
    AppMethodBeat.o(96674);
  }
  
  public final void fKl()
  {
    AppMethodBeat.i(96675);
    super.fKl();
    this.mSensorManager.unregisterListener(this);
    AppMethodBeat.o(96675);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(96668);
    View localView = this.contentView;
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    this.Ksv = this.mSensorManager.getDefaultSensor(1);
    this.Ksw = this.mSensorManager.getDefaultSensor(2);
    this.KsA = ((HorizontalScrollView)localView.findViewById(i.f.activity_gyroscope_horizontalscrollview));
    this.fDJ = ((ImageView)localView.findViewById(i.f.activity_gyroscope_img));
    this.progressBar = ((ProgressBar)localView.findViewById(i.f.progressbar));
    this.progressBar.setVisibility(8);
    AppMethodBeat.o(96668);
  }
  
  public final boolean fRj()
  {
    AppMethodBeat.i(96673);
    if (fRi() >= (int)(getView().getHeight() * 0.1F))
    {
      AppMethodBeat.o(96673);
      return true;
    }
    AppMethodBeat.o(96673);
    return false;
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_gyroscope_image_view;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f2 = -10.0F;
    AppMethodBeat.i(96672);
    if (paramSensorEvent.sensor.getType() == 1) {
      this.KsB = paramSensorEvent.values;
    }
    if (paramSensorEvent.sensor.getType() == 2) {
      this.KsC = paramSensorEvent.values;
    }
    float f1;
    if ((this.KsB != null) && (this.KsC != null))
    {
      paramSensorEvent = new float[9];
      if (SensorManager.getRotationMatrix(paramSensorEvent, new float[9], this.KsB, this.KsC))
      {
        float[] arrayOfFloat = new float[3];
        SensorManager.getOrientation(paramSensorEvent, arrayOfFloat);
        float f3 = arrayOfFloat[2];
        if (this.Ksx != 0)
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
      f1 = f1 * this.Ksx / 10.0F;
      this.KsA.scrollBy((int)f1, 0);
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
    if (this.fDJ == null)
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
    this.fDJ.setImageBitmap(paramBitmap);
    this.fDJ.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(96667);
        int i = aa.this.fDJ.getMeasuredWidth();
        if (i > aa.this.pEj)
        {
          aa localaa = aa.this;
          localaa.Ksx = ((i - localaa.pEj) / 2);
          aa.this.KsA.scrollBy(aa.this.Ksx, 0);
        }
        AppMethodBeat.o(96667);
      }
    });
    int i;
    if (paramBitmap.getHeight() != 0)
    {
      i = this.pEk;
      if (((t)this.KqB).KmE == 2.147484E+009F) {
        break label176;
      }
      i = (int)((t)this.KqB).KmE;
    }
    label176:
    for (;;)
    {
      this.fDJ.setLayoutParams(new RelativeLayout.LayoutParams(paramBitmap.getWidth() * i / paramBitmap.getHeight(), i));
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