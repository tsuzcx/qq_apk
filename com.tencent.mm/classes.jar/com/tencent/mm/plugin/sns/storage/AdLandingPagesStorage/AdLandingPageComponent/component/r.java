package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.vfs.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class r
  extends y
  implements b, h.b
{
  private Context context;
  private ah dPi;
  private ProgressBar fea;
  private View hoY;
  ImageView kHQ;
  private long mxx = 0L;
  AdLandingVideoWrapper oGQ;
  VideoPlayerSeekBar oGR;
  private ImageView oGS;
  private ImageView oGT;
  private TextView oGU;
  private Runnable oGV;
  boolean oGW = false;
  boolean oGX = false;
  boolean oGY = false;
  boolean oGZ = true;
  boolean oHa = true;
  private boolean oHb = false;
  private boolean oHc = true;
  private boolean oHd = false;
  private boolean oHe = false;
  private boolean oHf = false;
  private boolean oHg = false;
  int oHh = 0;
  private int oHi = 0;
  private int oHj = 0;
  int oHk = 0;
  int oHl = 0;
  private ac oHm = null;
  private View.OnClickListener oHn = new r.5(this);
  private View.OnClickListener oHo = new r.6(this);
  private View.OnClickListener oHp = new r.7(this);
  private View.OnClickListener oHq = new r.8(this);
  private int playCount = 0;
  
  public r(Context paramContext, w paramw, ViewGroup paramViewGroup)
  {
    super(paramContext, paramw, paramViewGroup);
    this.context = paramContext;
    this.dPi = new ah(Looper.getMainLooper());
    this.oGV = new r.1(this);
    this.oHm = new r.3(this, paramContext);
  }
  
  private void aEw()
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "starting play");
    if (this.oHe)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "last download fail ,try again");
      this.oGQ.c(false, ((w)this.oFE).oCZ, 0);
      yf(0);
      return;
    }
    this.dPi.post(new r.9(this));
    this.mxx = System.currentTimeMillis();
    this.playCount += 1;
  }
  
  public final void W(int paramInt1, int paramInt2, int paramInt3)
  {
    super.W(paramInt1, paramInt2, paramInt3);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "height " + paramInt2);
    if ((paramInt1 == 0) || (paramInt2 == 0)) {}
    label36:
    label226:
    do
    {
      NetworkInfo localNetworkInfo;
      do
      {
        do
        {
          break label36;
          break label36;
          do
          {
            return;
          } while (paramInt1 < 0);
          if (paramInt1 < 0.5F * paramInt2) {
            break;
          }
        } while ((this.oHb) && (!this.oHc));
        this.oHc = false;
        this.oHb = true;
        localNetworkInfo = ((ConnectivityManager)ae.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if ((!this.oHa) || ((this.oHa) && (localNetworkInfo != null) && (localNetworkInfo.getType() == 1)))
        {
          jo(true);
          ai.l(new r.2(this), 3000L);
        }
        if (this.oHa)
        {
          if ((localNetworkInfo == null) || ((localNetworkInfo != null) && (localNetworkInfo.getType() != 1)))
          {
            this.oGT.setVisibility(0);
            this.oHd = false;
            this.oHa = false;
            return;
          }
          this.oHd = true;
          this.oHa = false;
        }
        if (this.oHh != 0) {
          break;
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
        bEV();
        break label226;
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
          }
        }
        if (this.oHh != 3) {
          break;
        }
        if (this.oGZ) {
          bER();
        } else {
          bEV();
        }
      }
      this.oHc = false;
      this.oHb = false;
      bFy();
    } while (this.oHh != 1);
    this.oHh = 2;
  }
  
  public final boolean ah(JSONObject paramJSONObject)
  {
    if (!super.ah(paramJSONObject)) {
      return false;
    }
    try
    {
      paramJSONObject.put("streamVideoDuraion", this.oGQ.getVideoDurationSec() * 1000);
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
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", paramJSONObject, "", new Object[0]);
      return false;
    }
  }
  
  public final void akz()
  {
    if (this.oGQ != null) {
      this.oGQ.Se();
    }
    this.oGY = true;
  }
  
  public final void bER()
  {
    super.bER();
    this.oGS.setImageDrawable(a.g(this.context, i.e.landing_page_video_sound_off));
    this.oGQ.setMute(true);
    this.oGZ = true;
  }
  
  public final void bES()
  {
    super.bES();
    this.oGQ.akT();
  }
  
  public final void bET()
  {
    super.bET();
  }
  
  public final void bEU()
  {
    super.bEU();
    bFy();
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
    this.oGS.setImageDrawable(a.g(this.context, i.e.landing_page_video_sound_on));
    this.oGQ.setMute(false);
    this.oGZ = false;
  }
  
  public final View bFf()
  {
    View localView = this.contentView.findViewById(i.f.content_root);
    localView.setBackgroundColor(-16777216);
    int k = this.gHR;
    int j = this.gHS;
    int i = j;
    if (((w)this.oFE).oDL == 1)
    {
      i = j;
      if ((int)((w)this.oFE).width > 0) {
        i = k * (int)((w)this.oFE).height / (int)((w)this.oFE).width;
      }
    }
    else
    {
      localView.setPadding((int)((w)this.oFE).oDk, (int)((w)this.oFE).oDi, (int)((w)this.oFE).oDl, (int)((w)this.oFE).oDj);
    }
    localView.setLayoutParams(new RelativeLayout.LayoutParams(k, i));
    localView.setMinimumHeight(i);
    this.oGQ = ((AdLandingVideoWrapper)localView.findViewById(i.f.video_view));
    this.oGQ.setIMMVideoViewCallback(this);
    this.oGQ.setOnClickListener(this.oHq);
    this.oGQ.c(false, ((w)this.oFE).oCZ, 0);
    this.oGQ.setIsShowBasicControls(true);
    this.fea = ((ProgressBar)localView.findViewById(i.f.progressbar));
    this.kHQ = ((ImageView)localView.findViewById(i.f.thumb_iv));
    Object localObject = h.eS("adId", ((w)this.oFE).oDK);
    if (!e.bK((String)localObject)) {
      this.oHf = false;
    }
    if (this.oHf)
    {
      this.kHQ.setImageBitmap(MMBitmapFactory.decodeFile((String)localObject));
      this.oGU = ((TextView)localView.findViewById(i.f.errorTv));
      this.oGU.setText(this.context.getString(i.j.download_fail));
      this.hoY = localView.findViewById(i.f.sns_ad_native_landing_pages_sight_background);
      this.hoY.setVisibility(4);
      this.oGR = new VideoPlayerSeekBar(this.context);
      this.oGR.setVisibility(4);
      if (this.oHm != null)
      {
        localObject = this.oHm;
        if (this.oGR.getVisibility() != 0) {
          break label654;
        }
      }
    }
    label654:
    for (boolean bool = true;; bool = false)
    {
      ((ac)localObject).jp(bool);
      this.oGR.setIplaySeekCallback(this);
      this.oGR.setOnPlayButtonClickListener(this.oHn);
      localObject = new RelativeLayout.LayoutParams(k - a.fromDPToPix(this.context, 30), -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.oGR.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.oGQ.setVideoFooterView(this.oGR);
      this.oGS = ((ImageView)localView.findViewById(i.f.sns_ad_native_landing_pages_sight_voice_btn));
      this.oGS.setVisibility(4);
      this.oGS.setOnClickListener(this.oHo);
      this.oGS.setPadding(0, 0, a.fromDPToPix(this.context, 8), 0);
      this.oGT = ((ImageView)localView.findViewById(i.f.status_btn));
      this.oGT.setImageDrawable(a.g(this.context, i.i.shortvideo_play_btn));
      this.oGT.setVisibility(8);
      this.oGT.setOnClickListener(this.oHp);
      ((ViewGroup)this.oGR.getParent()).removeView(this.oGR);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
      ((ViewGroup)localView).addView(this.oGR, (ViewGroup.LayoutParams)localObject);
      return this.contentView;
      h.c("adId", ((w)this.oFE).oDK, false, 1000000001, new r.4(this));
      break;
    }
  }
  
  protected final void bFj() {}
  
  public final void bFo()
  {
    super.bFo();
    bFy();
    String str = h.eS("adId", ((w)this.oFE).oDK);
    if (e.bK(str))
    {
      this.kHQ.setImageBitmap(MMBitmapFactory.decodeFile(str));
      this.kHQ.setVisibility(0);
    }
  }
  
  final void bFy()
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "pause play");
    this.dPi.post(new r.10(this));
    if (this.mxx != 0L)
    {
      this.oHi = ((int)(this.oHi + (System.currentTimeMillis() - this.mxx)));
      this.mxx = 0L;
    }
  }
  
  public final void bH(String paramString1, String paramString2)
  {
    this.oHe = false;
  }
  
  public final void bI(String paramString1, String paramString2)
  {
    this.oHj += 1;
    jo(true);
    if (this.mxx != 0L)
    {
      this.oHi = ((int)(this.oHi + (System.currentTimeMillis() - this.mxx)));
      this.mxx = 0L;
    }
    this.oHh = 5;
    this.oGQ.Se();
  }
  
  public final void bJ(String paramString1, String paramString2) {}
  
  public final void bK(String paramString1, String paramString2)
  {
    if (this.kHQ.getVisibility() == 0)
    {
      this.kHQ.setVisibility(8);
      this.fea.setVisibility(8);
    }
  }
  
  public final void bL(String paramString1, String paramString2) {}
  
  public final void bM(String paramString1, String paramString2) {}
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "online play error, %s", new Object[] { paramString3 });
    this.oHe = true;
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_new_stream;
  }
  
  final void jo(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.oGR.setVisibility(0);
      this.oGS.setVisibility(0);
      this.hoY.setVisibility(0);
      if (this.oHm != null) {
        this.oHm.jp(true);
      }
      this.dPi.postDelayed(this.oGV, 5000L);
      return;
    }
    this.oGR.setVisibility(4);
    this.oGS.setVisibility(8);
    this.hoY.setVisibility(4);
    if (this.oHm != null) {
      this.oHm.jp(false);
    }
    this.dPi.removeCallbacks(this.oGV);
  }
  
  public final void lE(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "onSeek time " + paramInt);
    if (this.oGZ) {
      bER();
    }
    for (;;)
    {
      yf(paramInt);
      return;
      bEW();
      bEV();
    }
  }
  
  final void yf(int paramInt)
  {
    if (this.oGQ != null)
    {
      this.oGT.setVisibility(8);
      if (this.kHQ.getVisibility() == 0) {
        this.fea.setVisibility(0);
      }
      this.oGQ.y(paramInt, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r
 * JD-Core Version:    0.7.0.1
 */