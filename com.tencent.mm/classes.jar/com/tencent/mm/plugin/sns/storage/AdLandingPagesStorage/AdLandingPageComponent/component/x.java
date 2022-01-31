package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.SnsAdStreamVideoPlayUI;
import com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public final class x
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a
{
  public static int rxF = 999;
  private Context context;
  private boolean eAT;
  private ak faV;
  private String hIH;
  private View jbK;
  int jgE;
  private long oXt;
  private int playCount;
  public int qZF;
  public int qZG;
  public int qZH;
  ImageView rwH;
  private boolean rwI;
  private TextView rwK;
  boolean rwP;
  private boolean rwR;
  private boolean rwS;
  private boolean rwT;
  private boolean rwU;
  boolean rwV;
  boolean rwW;
  private int rwX;
  private int rwY;
  private int rwZ;
  private int rxA;
  private int rxB;
  int rxC;
  int rxD;
  private boolean rxE;
  int rxb;
  private OfflineVideoView rxz;
  
  public x(Context paramContext, q paramq, ViewGroup paramViewGroup)
  {
    super(paramContext, paramq, paramViewGroup);
    AppMethodBeat.i(37285);
    this.oXt = 0L;
    this.rwY = 0;
    this.playCount = 0;
    this.rwZ = 0;
    this.rxB = 0;
    this.qZF = 0;
    this.qZG = 0;
    this.qZH = 0;
    this.rxb = 0;
    this.rxC = 0;
    this.rwP = true;
    this.rxD = 0;
    this.jgE = 0;
    this.rwX = 0;
    this.rwR = false;
    this.rwS = true;
    this.rwT = false;
    this.rwV = true;
    this.rwW = true;
    this.rwU = false;
    this.context = paramContext;
    this.faV = new ak(Looper.getMainLooper());
    AppMethodBeat.o(37285);
  }
  
  private void bhD()
  {
    AppMethodBeat.i(37289);
    if (this.rwU)
    {
      ab.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "last download fail ,try again");
      this.rxz.byu();
      AppMethodBeat.o(37289);
      return;
    }
    ab.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "starting play");
    if ((!this.rxE) && (!TextUtils.isEmpty(this.hIH)))
    {
      this.rxz.Oh(this.hIH);
      this.rxE = true;
    }
    this.faV.post(new x.6(this));
    this.oXt = System.currentTimeMillis();
    this.playCount += 1;
    AppMethodBeat.o(37289);
  }
  
  private void crn()
  {
    AppMethodBeat.i(37290);
    ab.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "pause play");
    this.faV.post(new x.7(this));
    if (this.oXt != 0L)
    {
      this.rwY = ((int)(this.rwY + (System.currentTimeMillis() - this.oXt)));
      this.oXt = 0L;
    }
    AppMethodBeat.o(37290);
  }
  
  private boolean crr()
  {
    AppMethodBeat.i(37288);
    if (!bo.isNullOrNil(((q)this.rve).rrW))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("sns_landig_pages_from_source", 14);
      localIntent.putExtra("sns_landig_pages_origin_from_source", crc().rtf);
      localIntent.putExtra("sns_landing_pages_ux_info", crc().cFe);
      localIntent.putExtra("sns_landing_pages_xml", "");
      localIntent.putExtra("sns_landing_pages_canvasid", ((q)this.rve).rrW);
      localIntent.putExtra("sns_landing_pages_canvas_ext", ((q)this.rve).rrX);
      localIntent.putExtra("sns_landing_pages_no_store", ((q)this.rve).rrY);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
      String str3;
      String str1;
      String str2;
      JSONObject localJSONObject;
      if (((this.context instanceof Activity)) && (crc().rth == 2))
      {
        str3 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
        str1 = ((Activity)this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
        if (!bo.isNullOrNil(str3))
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
          localJSONObject.put("cid", ((q)this.rve).rsI);
          if (bo.isNullOrNil(str1)) {
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
        this.rxz.getLocationOnScreen((int[])localObject);
        localIntent.putExtra("img_gallery_top", localObject[1]);
        localIntent.putExtra("img_gallery_left", localObject[0]);
        localIntent.putExtra("img_gallery_width", this.rxz.getWidth());
        localIntent.putExtra("img_gallery_height", this.rxz.getHeight());
        d.b(this.context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        AppMethodBeat.o(37288);
        return true;
        localObject = "";
      }
    }
    AppMethodBeat.o(37288);
    return false;
  }
  
  public final boolean aq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(37297);
    if (!super.aq(paramJSONObject))
    {
      AppMethodBeat.o(37297);
      return false;
    }
    try
    {
      paramJSONObject.put("sightDuration", this.rxA * 1000);
      paramJSONObject.put("playTimeInterval", this.rwY);
      paramJSONObject.put("playCount", this.playCount);
      paramJSONObject.put("playCompletedCount", this.rwZ);
      paramJSONObject.put("clickVoiceControlCount", this.rxb);
      if (this.rwT) {}
      for (String str = "1";; str = "0")
      {
        paramJSONObject.put("isAutoPlay", str);
        if (((q)this.rve).type == 61) {
          paramJSONObject.put("clickSightCount", this.rxC);
        }
        JSONObject localJSONObject;
        if (!this.rwW)
        {
          str = ag.cE(((q)this.rve).rsz);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("sightUrlInfo", localJSONObject);
        }
        if (!this.rwV)
        {
          str = ag.cE(((q)this.rve).rsA);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        paramJSONObject.put("streamVideoEnterCount", this.rxB);
        paramJSONObject.put("streamVideoPlayCount", this.qZF);
        paramJSONObject.put("streamVideoPlayCompleteCount", this.qZG);
        paramJSONObject.put("streamVideoTotalPlayTimeInMs", this.qZH);
        AppMethodBeat.o(37297);
        return true;
      }
      return false;
    }
    catch (JSONException paramJSONObject)
    {
      ab.printErrStackTrace("MicroMsg.Sns.AdLandingPageSightVideoComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(37297);
    }
  }
  
  public final void cqA()
  {
    AppMethodBeat.i(37293);
    super.cqA();
    AppMethodBeat.o(37293);
  }
  
  public final void cqB()
  {
    AppMethodBeat.i(37294);
    super.cqB();
    crn();
    if ((!this.rwR) && (!this.rwS))
    {
      AppMethodBeat.o(37294);
      return;
    }
    this.rwS = false;
    this.rwR = false;
    if (this.rwX == 1) {
      this.rwX = 2;
    }
    ab.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "disappear handleType %d", new Object[] { Integer.valueOf(this.rwX) });
    AppMethodBeat.o(37294);
  }
  
  public final void cqC()
  {
    AppMethodBeat.i(37296);
    super.cqC();
    int i = cqW();
    int j = getView().getHeight();
    ab.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 0) || (j == 0))
    {
      AppMethodBeat.o(37296);
      return;
    }
    this.rxD = i;
    this.jgE = j;
    if (i < 0)
    {
      AppMethodBeat.o(37296);
      return;
    }
    ab.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "appeared handleType %d", new Object[] { Integer.valueOf(this.rwX) });
    if (i >= j * 0.5F)
    {
      if ((this.rwR) && (!this.rwS))
      {
        AppMethodBeat.o(37296);
        return;
      }
      this.rwS = false;
      this.rwR = true;
      if (this.rwX == 0)
      {
        if (this.rwP) {
          cqy();
        }
        for (;;)
        {
          this.rwX = 1;
          bhD();
          AppMethodBeat.o(37296);
          return;
          cqD();
        }
      }
      if (this.rwX == 2)
      {
        if (this.rwP) {
          cqy();
        }
        for (;;)
        {
          bhD();
          this.rwX = 1;
          AppMethodBeat.o(37296);
          return;
          cqD();
        }
      }
      if (this.rwX == 3)
      {
        if (this.rwP) {
          cqy();
        }
        for (;;)
        {
          bhD();
          AppMethodBeat.o(37296);
          return;
          cqD();
        }
      }
    }
    else
    {
      this.rwS = false;
      this.rwR = false;
      crn();
      if (this.rwX == 1) {
        this.rwX = 2;
      }
    }
    AppMethodBeat.o(37296);
  }
  
  public final void cqD()
  {
    AppMethodBeat.i(37292);
    super.cqD();
    this.rwH.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2131231433));
    this.rxz.setMute(false);
    this.rwP = false;
    AppMethodBeat.o(37292);
  }
  
  public final void cqK()
  {
    AppMethodBeat.i(37286);
    if (!com.tencent.mm.vfs.e.cN(h.gy("adId", ((q)this.rve).rsA))) {
      this.rwV = false;
    }
    if (!com.tencent.mm.vfs.e.cN(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/adId_stream_" + ag.cE(((q)this.rve).rsz))) {
      this.rwW = false;
    }
    Object localObject1 = this.contentView.findViewById(2131827864);
    Object localObject2 = (ViewGroup)((View)localObject1).findViewById(2131827865);
    this.rxz = new OfflineVideoView(this.context);
    ((ViewGroup)localObject2).addView(this.rxz, new LinearLayout.LayoutParams(-1, -1));
    Object localObject3;
    if (((q)this.rve).rsF == 0) {
      if ((int)((q)this.rve).width > 0)
      {
        i = this.iiW;
        localObject3 = new RelativeLayout.LayoutParams(i, (int)(i * ((q)this.rve).height / ((q)this.rve).width));
        ((ViewGroup)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject2 = h.gy("adId", ((q)this.rve).rsA);
        if (!com.tencent.mm.vfs.e.cN((String)localObject2)) {
          break label956;
        }
        this.rxz.acb((String)localObject2);
        label256:
        this.rwK = ((TextView)((View)localObject1).findViewById(2131827796));
        this.rwK.setText(this.context.getString(2131299004));
        this.jbK = ((View)localObject1).findViewById(2131827859);
        if (this.jbK != null)
        {
          localObject2 = new RelativeLayout.LayoutParams(-1, -1);
          localObject3 = this.jbK.getParent();
          if ((localObject3 instanceof ViewGroup)) {
            ((ViewGroup)localObject3).removeView(this.jbK);
          }
          ((ViewGroup)localObject1).addView(this.jbK, (ViewGroup.LayoutParams)localObject2);
        }
        this.rwH = ((ImageView)((View)localObject1).findViewById(2131827860));
        this.rwH.setVisibility(0);
        this.rwH.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37273);
            paramAnonymousView = x.this;
            paramAnonymousView.rxb += 1;
            if (x.this.rwP)
            {
              x.this.cqE();
              x.this.cqD();
              AppMethodBeat.o(37273);
              return;
            }
            x.this.cqy();
            AppMethodBeat.o(37273);
          }
        });
        this.rwH.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.context, 8), com.tencent.mm.cb.a.fromDPToPix(this.context, 13));
        localObject2 = this.rwH.getParent();
        if ((localObject2 instanceof ViewGroup)) {
          ((ViewGroup)localObject2).removeView(this.rwH);
        }
        ((ViewGroup)localObject1).addView(this.rwH);
        this.rxz.setVideoCallback(new OfflineVideoView.a()
        {
          public final void Ef(int paramAnonymousInt)
          {
            AppMethodBeat.i(37280);
            al.d(new x.3.2(this, paramAnonymousInt));
            AppMethodBeat.o(37280);
          }
          
          public final void Es()
          {
            AppMethodBeat.i(37278);
            x.d(x.this);
            x.e(x.this);
            AppMethodBeat.o(37278);
          }
          
          public final boolean a(PString paramAnonymousPString)
          {
            AppMethodBeat.i(37277);
            String str1 = x.b(x.this).rsz;
            String str2 = h.gz("adId", str1);
            if (com.tencent.mm.vfs.e.cN(str2))
            {
              paramAnonymousPString.value = str2;
              x.c(x.this);
              AppMethodBeat.o(37277);
              return true;
            }
            h.d("adId", str1, false, 62, new x.3.1(this));
            AppMethodBeat.o(37277);
            return false;
          }
          
          public final void onStart(int paramAnonymousInt)
          {
            AppMethodBeat.i(37279);
            x.f(x.this);
            x.a(x.this, paramAnonymousInt);
            x.this.rwH.setVisibility(0);
            AppMethodBeat.o(37279);
          }
        });
        this.rwH.setVisibility(8);
        this.rxz.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37281);
            if (x.j(x.this))
            {
              paramAnonymousView = x.this;
              paramAnonymousView.rxC += 1;
              if (x.k(x.this))
              {
                AppMethodBeat.o(37281);
                return;
              }
            }
            AppMethodBeat.o(37281);
          }
        });
        localObject1 = (q)this.rve;
        if ((((q)localObject1).subType != 1) || (((q)localObject1).rsC.length() <= 0) || (((q)localObject1).rsB.length() <= 0)) {
          break label987;
        }
      }
    }
    label956:
    label987:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = this.contentView.findViewById(2131827866);
        ((View)localObject1).setVisibility(0);
        localObject2 = (Button)((View)localObject1).findViewById(2131827867);
        ((Button)localObject2).setTextColor(((q)this.rve).rsD);
        ((Button)localObject2).setText(((q)this.rve).rsC);
        ((Button)localObject2).setOnClickListener(new x.5(this));
        ((View)localObject1).findViewById(2131827868).setBackgroundColor(((q)this.rve).rsE);
      }
      AppMethodBeat.o(37286);
      return;
      ((ViewGroup)localObject2).setLayoutParams(new RelativeLayout.LayoutParams(this.iiW, this.iiX));
      ((View)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.iiW, this.iiX));
      break;
      if (((q)this.rve).rsF == 1)
      {
        int j;
        if (((q)this.rve).width / this.iiW > ((q)this.rve).height / this.iiX)
        {
          j = this.iiW;
          i = (int)(j * ((q)this.rve).height / ((q)this.rve).width) + 1;
        }
        for (;;)
        {
          localObject3 = new RelativeLayout.LayoutParams(j, i);
          ((RelativeLayout.LayoutParams)localObject3).leftMargin = ((this.iiW - j) / 2);
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = ((RelativeLayout.LayoutParams)localObject3).leftMargin;
          ((RelativeLayout.LayoutParams)localObject3).topMargin = ((this.iiX - i) / 2);
          ((RelativeLayout.LayoutParams)localObject3).bottomMargin = ((RelativeLayout.LayoutParams)localObject3).topMargin;
          ((ViewGroup)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          ((View)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(this.iiW, this.iiX));
          break;
          i = this.iiX;
          j = (int)(i * ((q)this.rve).width / ((q)this.rve).height) + 1;
        }
      }
      if (((q)this.rve).rsF != 2) {
        break;
      }
      localObject3 = new RelativeLayout.LayoutParams((int)((q)this.rve).width, (int)((q)this.rve).height);
      ((ViewGroup)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ((View)localObject1).setLayoutParams(new RelativeLayout.LayoutParams((RelativeLayout.LayoutParams)localObject3));
      break;
      h.c("adId", ((q)this.rve).rsA, false, 1000000001, new x.1(this));
      break label256;
    }
  }
  
  protected final void cqP()
  {
    AppMethodBeat.i(37298);
    ab.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", getClass().getName() + "not support update now");
    AppMethodBeat.o(37298);
  }
  
  public final void cqy()
  {
    AppMethodBeat.i(37291);
    super.cqy();
    this.rwH.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2131231432));
    this.rxz.setMute(true);
    this.rwP = true;
    AppMethodBeat.o(37291);
  }
  
  public final void cqz()
  {
    AppMethodBeat.i(37295);
    super.cqz();
    OfflineVideoView localOfflineVideoView = this.rxz;
    ab.d("MicroMsg.OfflineVideoView", "%d on destroy %s", new Object[] { Integer.valueOf(localOfflineVideoView.hashCode()), bo.dtY() });
    ab.i("MicroMsg.OfflineVideoView", "%d logic unInit", new Object[] { Integer.valueOf(localOfflineVideoView.hashCode()) });
    localOfflineVideoView.kuE.removeCallbacksAndMessages(null);
    localOfflineVideoView.kvM.stopTimer();
    if (localOfflineVideoView.kvG != null) {
      localOfflineVideoView.kvG.stop();
    }
    AppMethodBeat.o(37295);
  }
  
  public final void cra()
  {
    AppMethodBeat.i(37299);
    super.cra();
    String str = h.gy("adId", ((q)this.rve).rsA);
    crn();
    if (com.tencent.mm.vfs.e.cN(str))
    {
      this.rxz.acb(str);
      this.rxz.a(false, 0.0F);
    }
    AppMethodBeat.o(37299);
  }
  
  public final void crq()
  {
    AppMethodBeat.i(37287);
    q localq = (q)this.rve;
    if (bo.isNullOrNil(localq.rsB))
    {
      ab.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click without streamVideoUrl!");
      AppMethodBeat.o(37287);
      return;
    }
    if (!(this.context instanceof Activity))
    {
      ab.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click but context not activity!");
      AppMethodBeat.o(37287);
      return;
    }
    ab.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click, jumpto [%s]", new Object[] { localq.rsB });
    Intent localIntent = new Intent();
    if (AdLandingPagesProxy.getInstance().getStreamVideoPlayerConfig() > 0)
    {
      localIntent.setClass(this.context, SnsAdStreamVideoPlayUI.class);
      ab.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "use new stream video play UI");
    }
    for (;;)
    {
      localIntent.putExtra("KFromTimeLine", true);
      localIntent.putExtra("KMediaId", ag.cE(localq.rsB));
      localIntent.putExtra("KThumUrl", localq.rsA);
      localIntent.putExtra("KStremVideoUrl", localq.rsB);
      localIntent.putExtra("ForceLandscape", true);
      localIntent.putExtra("ShareBtnHidden", 1);
      localIntent.putExtra("KComponentCid", cqY());
      ((Activity)this.context).startActivityForResult(localIntent, rxF);
      this.rxB += 1;
      AppMethodBeat.o(37287);
      return;
      localIntent.setClass(this.context, VideoAdPlayerUI.class);
    }
  }
  
  protected final int getLayout()
  {
    return 2130970788;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x
 * JD-Core Version:    0.7.0.1
 */