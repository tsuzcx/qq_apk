package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.e;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public final class z
  extends y
{
  private Context context;
  boolean dDs;
  ah dPi;
  String goK;
  View hoY;
  int jsr;
  long mxx;
  VideoPlayerSeekBar oGR;
  ImageView oGS;
  private ImageView oGT;
  private TextView oGU;
  boolean oGW;
  boolean oGZ;
  OfflineVideoView oHK;
  private ProgressBar oHL;
  int oHM;
  boolean oHN;
  int oHQ;
  boolean oHR;
  boolean oHS;
  boolean oHU;
  boolean oHa;
  private boolean oHb;
  private boolean oHc;
  private boolean oHd;
  boolean oHe;
  boolean oHf;
  boolean oHg;
  int oHh;
  int oHi;
  int oHj;
  int oHk;
  int oHl;
  ac oHm;
  private int playCount;
  
  public final void W(int paramInt1, int paramInt2, int paramInt3)
  {
    super.W(paramInt1, paramInt2, paramInt3);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "height " + paramInt2);
    if ((paramInt1 == 0) || (paramInt2 == 0)) {}
    label244:
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
            this.oGR.setVisibility(0);
            this.oGS.setVisibility(0);
            this.hoY.setVisibility(0);
          }
          ai.l(new Runnable()
          {
            public final void run()
            {
              if (z.this.oHR) {
                return;
              }
              if (z.this.oHm != null) {
                z.this.oHm.jp(false);
              }
              z.this.oGR.setVisibility(4);
              z.this.oGS.setVisibility(8);
              z.this.hoY.setVisibility(4);
            }
          }, 3000L);
        }
        if (this.oHa)
        {
          if ((localNetworkInfo != null) && ((localNetworkInfo == null) || (localNetworkInfo.getType() == 1))) {
            break;
          }
          this.oGT.setVisibility(0);
          this.oHN = false;
          this.oHd = false;
        }
        if (this.oHh != 0) {
          break label311;
        }
      } while ((localNetworkInfo == null) || (localNetworkInfo.getType() != 1));
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
        break label244;
        bEV();
        this.oHU = true;
        break label276;
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
    label276:
    label311:
    this.oHh = 2;
  }
  
  final void aEw()
  {
    if (this.oHe)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "last download fail ,try again");
      this.oHK.bHJ();
      return;
    }
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "starting play");
    if ((!this.oHS) && (!TextUtils.isEmpty(this.goK)))
    {
      this.oHK.Df(this.goK);
      this.oHS = true;
    }
    this.oGT.setVisibility(8);
    this.dPi.post(new z.10(this));
    this.mxx = System.currentTimeMillis();
    this.playCount += 1;
  }
  
  public final boolean ah(JSONObject paramJSONObject)
  {
    if (!super.ah(paramJSONObject)) {
      return false;
    }
    try
    {
      paramJSONObject.put("streamVideoDuraion", this.oHM * 1000);
      paramJSONObject.put("playTimeInterval", this.oHi);
      paramJSONObject.put("playCount", this.playCount);
      paramJSONObject.put("playCompletedCount", this.oHj);
      paramJSONObject.put("clickPlayControlCount", this.oHk);
      paramJSONObject.put("clickVoiceControlCount", this.oHl);
      if (this.oHd) {}
      for (String str = "1";; str = "0")
      {
        paramJSONObject.put("isAutoPlay", str);
        if (!this.oHf)
        {
          str = ad.bB(((w)this.oFE).oDK);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        if (this.oHg) {
          break;
        }
        str = ad.bB(((w)this.oFE).oCZ);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("urlMd5", str);
        localJSONObject.put("needDownload", 1);
        paramJSONObject.put("streamVideoUrlInfo", localJSONObject);
        break;
      }
      return true;
    }
    catch (JSONException paramJSONObject)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", paramJSONObject, "", new Object[0]);
      return false;
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
  
  public final int bFE()
  {
    if (this.oGR.getVisibility() == 0)
    {
      int[] arrayOfInt = new int[2];
      this.oGR.getLocationOnScreen(arrayOfInt);
      return this.gHS - arrayOfInt[1] - (this.oGR.getHeight() >>> 1);
    }
    return -1;
  }
  
  public final View bFf()
  {
    boolean bool2 = true;
    if (!e.bK(h.eS("adId", ((w)this.oFE).oDK))) {
      this.oHf = false;
    }
    if (!e.bK(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/adId_stream_" + ad.bB(((w)this.oFE).oCZ))) {
      this.oHg = false;
    }
    View localView = this.contentView.findViewById(i.f.sns_ad_native_landing_pages_item_video_container);
    Object localObject1 = (ViewGroup)localView.findViewById(i.f.sns_ad_native_landing_pages_item_sight_container);
    this.oHK = new OfflineVideoView(this.context);
    Object localObject2 = new LinearLayout.LayoutParams(-1, -1);
    ((ViewGroup)localObject1).addView(this.oHK, 0, (ViewGroup.LayoutParams)localObject2);
    int i;
    if (((w)this.oFE).oDL == 1) {
      if ((int)((w)this.oFE).width > 0)
      {
        i = this.gHR * (int)((w)this.oFE).height / (int)((w)this.oFE).width;
        localObject2 = new RelativeLayout.LayoutParams(this.gHR, i);
        localView.setPadding((int)((w)this.oFE).oDk, (int)((w)this.oFE).oDi, (int)((w)this.oFE).oDl, (int)((w)this.oFE).oDj);
        ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localView.setMinimumHeight(i);
        localObject1 = h.eS("adId", ((w)this.oFE).oDK);
        if (!e.bK((String)localObject1)) {
          break label1024;
        }
        this.oHK.Ph((String)localObject1);
        label319:
        this.oGU = ((TextView)localView.findViewById(i.f.errorTv));
        this.oGU.setText(this.context.getString(i.j.download_fail));
        this.hoY = localView.findViewById(i.f.sns_ad_native_landing_pages_sight_background);
        if (this.hoY != null)
        {
          localObject1 = new RelativeLayout.LayoutParams(this.gHR, this.gHS);
          localObject2 = this.hoY.getParent();
          if ((localObject2 instanceof ViewGroup)) {
            ((ViewGroup)localObject2).removeView(this.hoY);
          }
          ((ViewGroup)localView).addView(this.hoY, (ViewGroup.LayoutParams)localObject1);
        }
        localObject1 = new RelativeLayout.LayoutParams(this.gHR - com.tencent.mm.cb.a.fromDPToPix(this.context, 30), -2);
        ((RelativeLayout.LayoutParams)localObject1).addRule(12);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = this.context.getResources().getDimensionPixelSize(i.d.NoPadding);
        this.oGR = new VideoPlayerSeekBar(this.context);
        this.oGR.setVisibility(4);
        if (this.oHm != null)
        {
          localObject2 = this.oHm;
          if (this.oGR.getVisibility() != 0) {
            break label1055;
          }
          bool1 = true;
          label528:
          ((ac)localObject2).jp(bool1);
        }
        this.oGR.setIplaySeekCallback(new b()
        {
          public final void akz()
          {
            if (z.this.oHK != null) {
              z.this.oHK.bHK();
            }
          }
          
          public final void lE(int paramAnonymousInt)
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "onSeek time " + paramAnonymousInt);
            if (z.this.oGZ) {
              z.this.bER();
            }
            for (;;)
            {
              z.this.oHK.Y(paramAnonymousInt, z.this.oGR.bNU);
              return;
              z.this.bEV();
            }
          }
        });
        this.oGR.setOnPlayButtonClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "btn onclick view [%b] bar[%b]", new Object[] { Boolean.valueOf(z.this.oHK.isPlaying()), Boolean.valueOf(z.this.oGR.bNU) });
            z.this.oHN = true;
            if (z.this.oGR.bNU)
            {
              z.this.bFy();
              z.this.oHh = 4;
              if (z.this.oCc)
              {
                paramAnonymousView = z.this;
                paramAnonymousView.oHk += 1;
              }
              return;
            }
            if (z.this.oGZ) {
              z.this.bER();
            }
            for (;;)
            {
              z.this.aEw();
              z.this.oHh = 3;
              if (!z.this.oCa) {
                break;
              }
              z.this.bEW();
              break;
              z.this.bEV();
              z.this.oHU = true;
            }
          }
        });
        this.oGR.setIsPlay(this.oHK.isPlaying());
        this.oGR.seek(0);
        ((ViewGroup)localView).addView(this.oGR, (ViewGroup.LayoutParams)localObject1);
        this.oGS = ((ImageView)localView.findViewById(i.f.sns_ad_native_landing_pages_sight_voice_btn));
        this.oGS.setVisibility(0);
        this.oGS.setOnClickListener(new z.6(this));
        this.oGS.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.context, 8), com.tencent.mm.cb.a.fromDPToPix(this.context, 13));
        localObject1 = this.oGS.getParent();
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(this.oGS);
        }
        ((ViewGroup)localView).addView(this.oGS);
        this.oGT = ((ImageView)localView.findViewById(i.f.status_btn));
        this.oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.context, i.i.shortvideo_play_btn));
        this.oGT.setVisibility(8);
        this.oGT.setOnClickListener(new z.7(this));
        this.oHK.setVideoCallback(new z.8(this));
        this.oGR.setVisibility(4);
        this.oGS.setVisibility(8);
        this.hoY.setVisibility(4);
        if (this.oHm != null)
        {
          localObject1 = this.oHm;
          if (this.oGR.getVisibility() != 0) {
            break label1060;
          }
        }
      }
    }
    label1024:
    label1055:
    label1060:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((ac)localObject1).jp(bool1);
      this.oHK.setOnClickListener(new z.9(this));
      this.oHL = ((ProgressBar)localView.findViewById(i.f.progressbar));
      this.oHL.setVisibility(8);
      return this.contentView;
      ((ViewGroup)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.gHR, this.gHS));
      localView.setLayoutParams(new RelativeLayout.LayoutParams(this.gHR, this.gHS));
      localView.setMinimumHeight(this.gHS);
      break;
      i = this.gHS;
      localObject2 = new RelativeLayout.LayoutParams(this.gHR, i);
      localView.setPadding((int)((w)this.oFE).oDk, (int)((w)this.oFE).oDi, (int)((w)this.oFE).oDl, (int)((w)this.oFE).oDj);
      ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localView.setMinimumHeight(i);
      break;
      h.c("adId", ((w)this.oFE).oDK, false, 1000000001, new z.3(this));
      break label319;
      bool1 = false;
      break label528;
    }
  }
  
  protected final void bFj()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", getClass().getName() + "not support update now");
  }
  
  final void bFy()
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "pause play");
    if (!this.oHN) {
      this.oGT.setVisibility(0);
    }
    this.dPi.post(new z.1(this));
    if (this.mxx != 0L)
    {
      this.oHi = ((int)(this.oHi + (System.currentTimeMillis() - this.mxx)));
      this.mxx = 0L;
    }
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_sight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z
 * JD-Core Version:    0.7.0.1
 */