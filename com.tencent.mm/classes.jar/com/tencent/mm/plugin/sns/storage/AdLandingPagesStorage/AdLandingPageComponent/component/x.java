package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public final class x
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
{
  public static int oHT = 999;
  private Context context;
  private boolean dDs;
  private ah dPi;
  private String goK;
  private View hoY;
  int jsr = 0;
  private long mxx = 0L;
  VideoPlayerSeekBar oGR;
  ImageView oGS;
  private ImageView oGT;
  private TextView oGU;
  private boolean oGW = false;
  boolean oGZ = true;
  private OfflineVideoView oHK;
  private ProgressBar oHL;
  private int oHM;
  private boolean oHN = true;
  private int oHO = 0;
  int oHP = 0;
  int oHQ = 0;
  private boolean oHR = false;
  private boolean oHS;
  private boolean oHU = false;
  private boolean oHa = true;
  private boolean oHb = false;
  private boolean oHc = true;
  private boolean oHd = false;
  private boolean oHe = false;
  boolean oHf = true;
  boolean oHg = true;
  private int oHh = 0;
  private int oHi = 0;
  private int oHj = 0;
  private int oHk = 0;
  int oHl = 0;
  ac oHm = null;
  public int olt = 0;
  public int olu = 0;
  public int olv = 0;
  private int playCount = 0;
  
  public x(Context paramContext, q paramq, ViewGroup paramViewGroup)
  {
    super(paramContext, paramq, paramViewGroup);
    this.context = paramContext;
    this.dPi = new ah(Looper.getMainLooper());
    this.oHm = new x.1(this, paramContext);
  }
  
  private void aEw()
  {
    if (this.oHe)
    {
      y.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "last download fail ,try again");
      this.oHK.bHJ();
      return;
    }
    y.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "starting play");
    if ((!this.oHS) && (!TextUtils.isEmpty(this.goK)))
    {
      this.oHK.Df(this.goK);
      this.oHS = true;
    }
    this.oGT.setVisibility(8);
    this.dPi.post(new x.2(this));
    this.mxx = System.currentTimeMillis();
    this.playCount += 1;
  }
  
  private boolean bFC()
  {
    if (!bk.bl(((q)this.oFE).oCx))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("sns_landig_pages_from_source", 14);
      localIntent.putExtra("sns_landig_pages_origin_from_source", ((q)this.oFE).oDu);
      localIntent.putExtra("sns_landing_pages_ux_info", ((q)this.oFE).ovV);
      localIntent.putExtra("sns_landing_pages_xml", "");
      localIntent.putExtra("sns_landing_pages_canvasid", ((q)this.oFE).oCx);
      localIntent.putExtra("sns_landing_pages_canvas_ext", ((q)this.oFE).oCy);
      localIntent.putExtra("sns_landing_pages_no_store", ((q)this.oFE).oCz);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
      String str3;
      String str1;
      String str2;
      JSONObject localJSONObject;
      if (((this.context instanceof Activity)) && (((q)this.oFE).oDw == 2))
      {
        str3 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        str1 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
        if (!bk.bl(str3))
        {
          str2 = String.valueOf(System.currentTimeMillis() / 1000L);
          localJSONObject = new JSONObject();
        }
      }
      for (;;)
      {
        try
        {
          localJSONObject.put("sessionId", str2);
          localJSONObject.put("cid", ((q)this.oFE).oDg);
          if (bk.bl(str1)) {
            continue;
          }
          localObject = str1;
          localJSONObject.put("adBuffer", localObject);
          localJSONObject.put("preSessionId", str3);
        }
        catch (Exception localException)
        {
          Object localObject;
          continue;
        }
        localIntent.putExtra("sns_landing_pages_search_extra", localJSONObject.toString());
        localIntent.putExtra("sns_landing_pages_sessionId", str2);
        localIntent.putExtra("sns_landing_pages_ad_buffer", str1);
        localObject = new int[2];
        this.oHK.getLocationOnScreen((int[])localObject);
        localIntent.putExtra("img_gallery_top", localObject[1]);
        localIntent.putExtra("img_gallery_left", localObject[0]);
        localIntent.putExtra("img_gallery_width", this.oHK.getWidth());
        localIntent.putExtra("img_gallery_height", this.oHK.getHeight());
        d.b(this.context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        return true;
        localObject = "";
      }
    }
    return false;
  }
  
  private void bFy()
  {
    y.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "pause play");
    if (!this.oHN) {
      this.oGT.setVisibility(0);
    }
    this.dPi.post(new x.3(this));
    if (this.mxx != 0L)
    {
      this.oHi = ((int)(this.oHi + (System.currentTimeMillis() - this.mxx)));
      this.mxx = 0L;
    }
  }
  
  public final void W(int paramInt1, int paramInt2, int paramInt3)
  {
    super.W(paramInt1, paramInt2, paramInt3);
    y.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "height " + paramInt2);
    if ((paramInt1 == 0) || (paramInt2 == 0)) {}
    label233:
    do
    {
      NetworkInfo localNetworkInfo;
      do
      {
        do
        {
          do
          {
            return;
            this.oHQ = paramInt1;
            this.jsr = paramInt2;
          } while (paramInt1 < 0);
          if (paramInt1 < 0.5F * paramInt2) {
            break;
          }
        } while ((this.oHb) && (!this.oHc));
        this.oHU = false;
        this.oHc = false;
        this.oHb = true;
        localNetworkInfo = ((ConnectivityManager)ae.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if ((!this.oHa) || ((this.oHa) && (localNetworkInfo != null) && (localNetworkInfo.getType() == 1)))
        {
          if (this.oHm != null) {
            this.oHm.jp(true);
          }
          if (this.oGR.getVideoTotalTime() > 0)
          {
            this.oGR.setVisibility(4);
            this.oGS.setVisibility(0);
            this.hoY.setVisibility(0);
          }
          ai.l(new Runnable()
          {
            public final void run()
            {
              if (x.k(x.this)) {
                return;
              }
              if (x.this.oHm != null) {
                x.this.oHm.jp(false);
              }
              x.this.oGR.setVisibility(4);
              x.this.oGS.setVisibility(8);
              x.j(x.this).setVisibility(4);
            }
          }, 3000L);
        }
        if (this.oHa)
        {
          if (localNetworkInfo != null) {
            break;
          }
          this.oGT.setVisibility(0);
          this.oHN = false;
          this.oHd = false;
        }
        if (this.oHh != 0) {
          break label291;
        }
      } while (localNetworkInfo == null);
      if (this.oGZ)
      {
        bER();
        this.oHh = 1;
      }
      for (;;)
      {
        aEw();
        return;
        this.oHd = true;
        this.oHa = false;
        break label233;
        bEV();
        this.oHU = true;
        break label256;
        if (this.oHh == 2)
        {
          if (this.oGZ) {
            bER();
          }
          for (;;)
          {
            aEw();
            this.oHh = 1;
            return;
            bEV();
            this.oHU = true;
          }
        }
        if (this.oHh != 3) {
          break;
        }
        if (this.oGZ)
        {
          bER();
        }
        else
        {
          bEV();
          this.oHU = true;
        }
      }
      this.oHU = false;
      this.oHc = false;
      this.oHb = false;
      bFy();
    } while (this.oHh != 1);
    label256:
    label291:
    this.oHh = 2;
  }
  
  public final boolean ah(JSONObject paramJSONObject)
  {
    if (!super.ah(paramJSONObject)) {
      return false;
    }
    try
    {
      paramJSONObject.put("sightDuration", this.oHM * 1000);
      paramJSONObject.put("playTimeInterval", this.oHi);
      paramJSONObject.put("playCount", this.playCount);
      paramJSONObject.put("playCompletedCount", this.oHj);
      paramJSONObject.put("clickVoiceControlCount", this.oHl);
      if (this.oHd) {}
      for (String str = "1";; str = "0")
      {
        paramJSONObject.put("isAutoPlay", str);
        if (((q)this.oFE).type == 61) {
          paramJSONObject.put("clickSightCount", this.oHP);
        }
        JSONObject localJSONObject;
        if (!this.oHg)
        {
          str = ad.bB(((q)this.oFE).oCX);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("sightUrlInfo", localJSONObject);
        }
        if (!this.oHf)
        {
          str = ad.bB(((q)this.oFE).oCY);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        paramJSONObject.put("streamVideoEnterCount", this.oHO);
        paramJSONObject.put("streamVideoPlayCount", this.olt);
        paramJSONObject.put("streamVideoPlayCompleteCount", this.olu);
        paramJSONObject.put("streamVideoTotalPlayTimeInMs", this.olv);
        return true;
      }
      return false;
    }
    catch (JSONException paramJSONObject)
    {
      y.printErrStackTrace("MicroMsg.Sns.AdLandingPageSightVideoComponent", paramJSONObject, "", new Object[0]);
    }
  }
  
  public final void bER()
  {
    super.bER();
    this.oGS.setImageDrawable(com.tencent.mm.cb.a.g(this.context, i.e.landing_page_video_sound_off));
    this.oHK.setMute(true);
    this.oGZ = true;
  }
  
  public final void bES()
  {
    super.bES();
    this.oHK.onDestroy();
  }
  
  public final void bET()
  {
    super.bET();
  }
  
  public final void bEU()
  {
    super.bEU();
    bFy();
    this.oHU = false;
    if ((!this.oHb) && (!this.oHc)) {}
    do
    {
      return;
      this.oHc = false;
      this.oHb = false;
    } while (this.oHh != 1);
    this.oHh = 2;
  }
  
  public final void bEV()
  {
    super.bEV();
    this.oGS.setImageDrawable(com.tencent.mm.cb.a.g(this.context, i.e.landing_page_video_sound_on));
    this.oHK.setMute(false);
    this.oGZ = false;
  }
  
  public final void bFB()
  {
    q localq = (q)this.oFE;
    if (bk.bl(localq.oCZ))
    {
      y.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click without streamVideoUrl!");
      return;
    }
    if (!(this.context instanceof Activity))
    {
      y.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click but context not activity!");
      return;
    }
    y.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click, jumpto [%s]", new Object[] { localq.oCZ });
    Intent localIntent = new Intent();
    localIntent.setClass(this.context, VideoAdPlayerUI.class);
    localIntent.putExtra("IsAd", true);
    localIntent.putExtra("KMediaId", ad.bB(localq.oCZ));
    localIntent.putExtra("KThumUrl", localq.oCY);
    localIntent.putExtra("KStremVideoUrl", localq.oCZ);
    localIntent.putExtra("ForceLandscape", true);
    localIntent.putExtra("ShareBtnHidden", 1);
    localIntent.putExtra("KComponentCid", bFn());
    ((Activity)this.context).startActivityForResult(localIntent, oHT);
    this.oHO += 1;
  }
  
  public final void bFD()
  {
    if ((this.oHK != null) && (this.oGR != null) && (Math.abs(this.oHK.getCurrentPosition() - this.oGR.getmPosition()) > 1)) {
      this.oHK.X(this.oGR.getmPosition(), true);
    }
  }
  
  public final View bFf()
  {
    int i = 1;
    if (!e.bK(h.eS("adId", ((q)this.oFE).oCY))) {
      this.oHf = false;
    }
    if (!e.bK(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/adId_stream_" + ad.bB(((q)this.oFE).oCX))) {
      this.oHg = false;
    }
    Object localObject1 = this.contentView.findViewById(i.f.sns_ad_native_landing_pages_item_video_container);
    Object localObject2 = (ViewGroup)((View)localObject1).findViewById(i.f.sns_ad_native_landing_pages_item_sight_container);
    this.oHK = new OfflineVideoView(this.context);
    Object localObject3 = new LinearLayout.LayoutParams(-1, -1);
    ((ViewGroup)localObject2).addView(this.oHK, 0, (ViewGroup.LayoutParams)localObject3);
    int j;
    label313:
    boolean bool;
    if (((q)this.oFE).oDd == 1) {
      if ((int)((q)this.oFE).width > 0)
      {
        j = this.gHR * (int)((q)this.oFE).height / (int)((q)this.oFE).width;
        localObject3 = new RelativeLayout.LayoutParams(this.gHR, j);
        ((View)localObject1).setPadding((int)((q)this.oFE).oDk, (int)((q)this.oFE).oDi, (int)((q)this.oFE).oDl, (int)((q)this.oFE).oDj);
        ((ViewGroup)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject2 = h.eS("adId", ((q)this.oFE).oCY);
        if (!e.bK((String)localObject2)) {
          break label1187;
        }
        this.oHK.Ph((String)localObject2);
        this.oGU = ((TextView)((View)localObject1).findViewById(i.f.errorTv));
        this.oGU.setText(this.context.getString(i.j.download_fail));
        this.hoY = ((View)localObject1).findViewById(i.f.sns_ad_native_landing_pages_sight_background);
        if (this.hoY != null)
        {
          localObject2 = new RelativeLayout.LayoutParams(-1, -1);
          localObject3 = this.hoY.getParent();
          if ((localObject3 instanceof ViewGroup)) {
            ((ViewGroup)localObject3).removeView(this.hoY);
          }
          ((ViewGroup)localObject1).addView(this.hoY, (ViewGroup.LayoutParams)localObject2);
        }
        localObject2 = new RelativeLayout.LayoutParams(this.gHR - com.tencent.mm.cb.a.fromDPToPix(this.context, 30), -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(12);
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = this.context.getResources().getDimensionPixelSize(i.d.NoPadding);
        this.oGR = new VideoPlayerSeekBar(this.context);
        this.oGR.setVisibility(4);
        if (this.oHm != null)
        {
          localObject3 = this.oHm;
          if (this.oGR.getVisibility() != 0) {
            break label1218;
          }
          bool = true;
          label517:
          ((ac)localObject3).jp(bool);
        }
        this.oGR.setIplaySeekCallback(new x.6(this));
        this.oGR.setOnPlayButtonClickListener(new x.7(this));
        this.oGR.setIsPlay(this.oHK.isPlaying());
        this.oGR.seek(0);
        ((ViewGroup)localObject1).addView(this.oGR, (ViewGroup.LayoutParams)localObject2);
        this.oGS = ((ImageView)((View)localObject1).findViewById(i.f.sns_ad_native_landing_pages_sight_voice_btn));
        this.oGS.setVisibility(0);
        this.oGS.setOnClickListener(new x.8(this));
        this.oGS.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.context, 8), com.tencent.mm.cb.a.fromDPToPix(this.context, 13));
        localObject2 = this.oGS.getParent();
        if ((localObject2 instanceof ViewGroup)) {
          ((ViewGroup)localObject2).removeView(this.oGS);
        }
        ((ViewGroup)localObject1).addView(this.oGS);
        this.oGT = ((ImageView)((View)localObject1).findViewById(i.f.status_btn));
        this.oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.context, i.i.shortvideo_play_btn));
        this.oGT.setVisibility(8);
        this.oGT.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            x.b(x.this);
            x.e(x.this);
            x.h(x.this);
            if (x.i(x.this)) {
              if (x.this.oGZ) {
                x.this.bER();
              }
            }
            for (;;)
            {
              x.a(x.this, 3);
              x.this.oGR.setVisibility(4);
              x.this.oGS.setVisibility(0);
              x.j(x.this).setVisibility(0);
              if (x.this.oHm != null) {
                x.this.oHm.jp(true);
              }
              ai.l(new x.9.1(this), 10000L);
              return;
              x.this.bEV();
              x.d(x.this);
              continue;
              x.this.bEV();
              x.d(x.this);
              x.g(x.this);
            }
          }
        });
        this.oHK.setVideoCallback(new x.10(this));
        this.oGR.setVisibility(4);
        this.oGS.setVisibility(8);
        this.hoY.setVisibility(4);
        if (this.oHm != null)
        {
          localObject2 = this.oHm;
          if (this.oGR.getVisibility() != 0) {
            break label1224;
          }
          bool = true;
          label820:
          ((ac)localObject2).jp(bool);
        }
        this.oHK.setOnClickListener(new x.11(this));
        this.oHL = ((ProgressBar)((View)localObject1).findViewById(i.f.progressbar));
        this.oHL.setVisibility(8);
        localObject1 = (q)this.oFE;
        if ((((q)localObject1).brC != 1) || (((q)localObject1).oDa.length() <= 0) || (((q)localObject1).oCZ.length() <= 0)) {
          break label1230;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = this.contentView.findViewById(i.f.sns_ad_native_landing_pages_item_stream_video_click_area);
        ((View)localObject1).setVisibility(0);
        localObject2 = (Button)((View)localObject1).findViewById(i.f.sns_ad_native_landing_pages_item_stream_video_click_area_button);
        ((Button)localObject2).setTextColor(((q)this.oFE).oDb);
        ((Button)localObject2).setText(((q)this.oFE).oDa);
        ((Button)localObject2).setOnClickListener(new x.12(this));
        ((View)localObject1).findViewById(i.f.sns_ad_native_landing_pages_item_stream_video_click_area_separator).setBackgroundColor(((q)this.oFE).oDc);
      }
      return this.contentView;
      ((ViewGroup)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(this.gHR, this.gHS));
      ((View)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.gHR, this.gHS));
      ((View)localObject1).setMinimumHeight(this.gHS);
      break;
      j = (int)((q)this.oFE).width;
      int k = (int)((q)this.oFE).height;
      ((ViewGroup)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(j, k));
      localObject2 = new RelativeLayout.LayoutParams(j, k);
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)((q)this.oFE).oDk);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)((q)this.oFE).oDl);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)((q)this.oFE).oDi);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)((q)this.oFE).oDj);
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break;
      label1187:
      h.c("adId", ((q)this.oFE).oCY, false, 1000000001, new x.5(this));
      break label313;
      label1218:
      bool = false;
      break label517;
      label1224:
      bool = false;
      break label820;
      label1230:
      i = 0;
    }
  }
  
  protected final void bFj()
  {
    y.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", getClass().getName() + "not support update now");
  }
  
  public final void bFo()
  {
    super.bFo();
    String str = h.eS("adId", ((q)this.oFE).oCY);
    bFy();
    if (e.bK(str))
    {
      this.oHK.Ph(str);
      this.oHK.a(false, 0.0F);
    }
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_sight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x
 * JD-Core Version:    0.7.0.1
 */