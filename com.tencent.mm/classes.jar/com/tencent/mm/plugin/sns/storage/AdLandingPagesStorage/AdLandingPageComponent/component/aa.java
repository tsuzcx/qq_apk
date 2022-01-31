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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vfs.e;
import org.json.JSONException;
import org.json.JSONObject;

public final class aa
  extends z
  implements b, h.b
{
  private Context context;
  private ak faV;
  private ProgressBar gvK;
  private View jbK;
  ImageView mZY;
  private long oXt;
  private int playCount;
  AdLandingVideoWrapper rwF;
  private VideoPlayerSeekBar rwG;
  private ImageView rwH;
  boolean rwI;
  private ImageView rwJ;
  private TextView rwK;
  private Runnable rwL;
  boolean rwM;
  boolean rwN;
  boolean rwO;
  boolean rwP;
  boolean rwQ;
  private boolean rwR;
  private boolean rwS;
  private boolean rwT;
  private boolean rwU;
  private boolean rwV;
  private boolean rwW;
  int rwX;
  private int rwY;
  private int rwZ;
  int rxa;
  int rxb;
  private ad rxc;
  private View.OnClickListener rxd;
  private View.OnClickListener rxe;
  private View.OnClickListener rxf;
  private View.OnClickListener rxg;
  
  public aa(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab paramab, ViewGroup paramViewGroup)
  {
    super(paramContext, paramab, paramViewGroup);
    AppMethodBeat.i(37314);
    this.rwM = false;
    this.rwN = false;
    this.rwO = false;
    this.rwP = true;
    this.rwQ = true;
    this.rwR = false;
    this.rwS = true;
    this.rwT = false;
    this.rwU = false;
    this.rwV = false;
    this.rwW = false;
    this.rwX = 0;
    this.oXt = 0L;
    this.rwY = 0;
    this.playCount = 0;
    this.rwZ = 0;
    this.rxa = 0;
    this.rxb = 0;
    this.rxc = null;
    this.rxd = new aa.7(this);
    this.rxe = new aa.8(this);
    this.rxf = new aa.9(this);
    this.rxg = new aa.10(this);
    this.context = paramContext;
    this.faV = new ak(Looper.getMainLooper());
    this.rwL = new aa.1(this);
    this.rxc = new aa.4(this, paramContext);
    AppMethodBeat.o(37314);
  }
  
  private void bhD()
  {
    AppMethodBeat.i(37316);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "starting play");
    if (this.rwU)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "last download fail ,try again");
      this.rwF.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)this.rve).rsB, 0);
      Ee(0);
      this.rwF.crz();
      AppMethodBeat.o(37316);
      return;
    }
    this.faV.post(new aa.11(this));
    this.oXt = System.currentTimeMillis();
    this.playCount += 1;
    AppMethodBeat.o(37316);
  }
  
  final void Ee(int paramInt)
  {
    AppMethodBeat.i(37319);
    if (this.rwF != null)
    {
      this.rwJ.setVisibility(8);
      if (this.mZY.getVisibility() == 0) {
        this.gvK.setVisibility(0);
      }
      this.rwF.d(paramInt, true);
    }
    AppMethodBeat.o(37319);
  }
  
  public final void aFf()
  {
    this.rwO = true;
  }
  
  public final boolean aq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(37326);
    if (!super.aq(paramJSONObject))
    {
      AppMethodBeat.o(37326);
      return false;
    }
    try
    {
      paramJSONObject.put("streamVideoDuraion", this.rwF.getVideoDurationSec() * 1000);
      paramJSONObject.put("playTimeInterval", this.rwY);
      paramJSONObject.put("playCount", this.playCount);
      paramJSONObject.put("playCompletedCount", this.rwZ);
      paramJSONObject.put("clickPlayControlCount", this.rxa);
      paramJSONObject.put("clickVoiceControlCount", this.rxb);
      if (this.rwT) {}
      for (String str = "1";; str = "0")
      {
        paramJSONObject.put("isAutoPlay", str);
        JSONObject localJSONObject;
        if (!this.rwV)
        {
          str = ag.cE(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)this.rve).rtl);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("thumbUrlInfo", localJSONObject);
        }
        if (!this.rwW)
        {
          str = ag.cE(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)this.rve).rsB);
          localJSONObject = new JSONObject();
          localJSONObject.put("urlMd5", str);
          localJSONObject.put("needDownload", 1);
          paramJSONObject.put("streamVideoUrlInfo", localJSONObject);
        }
        AppMethodBeat.o(37326);
        return true;
      }
      return false;
    }
    catch (JSONException paramJSONObject)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", paramJSONObject, "", new Object[0]);
      AppMethodBeat.o(37326);
    }
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37330);
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "online play error, %s", new Object[] { paramString3 });
    this.rwU = true;
    AppMethodBeat.o(37330);
  }
  
  public final void cq(String paramString1, String paramString2)
  {
    this.rwU = false;
  }
  
  public final void cqA()
  {
    AppMethodBeat.i(37322);
    super.cqA();
    AppMethodBeat.o(37322);
  }
  
  public final void cqB()
  {
    AppMethodBeat.i(37323);
    super.cqB();
    crn();
    if ((!this.rwR) && (!this.rwS))
    {
      AppMethodBeat.o(37323);
      return;
    }
    this.rwS = false;
    this.rwR = false;
    if (this.rwX == 1) {
      this.rwX = 2;
    }
    AppMethodBeat.o(37323);
  }
  
  public final void cqC()
  {
    AppMethodBeat.i(37325);
    super.cqC();
    int i = cqW();
    int j = getView().getHeight();
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "inScreenHeight %d, height %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i == 0) || (j == 0))
    {
      AppMethodBeat.o(37325);
      return;
    }
    if (i < 0)
    {
      AppMethodBeat.o(37325);
      return;
    }
    if (i >= j * 0.5F)
    {
      if ((this.rwR) && (!this.rwS))
      {
        AppMethodBeat.o(37325);
        return;
      }
      this.rwS = false;
      this.rwR = true;
      this.mZY.setVisibility(0);
      NetworkInfo localNetworkInfo = ((ConnectivityManager)ah.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if ((!this.rwQ) || ((this.rwQ) && (localNetworkInfo != null) && (localNetworkInfo.getType() == 1)))
      {
        setFocus(true);
        al.p(new aa.3(this), 3000L);
      }
      if (this.rwQ)
      {
        if ((localNetworkInfo == null) || ((localNetworkInfo != null) && (localNetworkInfo.getType() != 1)))
        {
          this.rwJ.setVisibility(0);
          this.rwT = false;
          this.rwQ = false;
          AppMethodBeat.o(37325);
          return;
        }
        this.rwT = true;
        this.rwQ = false;
      }
      if (this.rwX == 0) {
        if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1))
        {
          if (!this.rwP) {
            break label291;
          }
          cqy();
          this.rwX = 1;
        }
      }
      for (;;)
      {
        bhD();
        label291:
        do
        {
          AppMethodBeat.o(37325);
          return;
          cqD();
          break;
          if (this.rwX == 2)
          {
            if (this.rwP) {
              cqy();
            }
            for (;;)
            {
              bhD();
              this.rwX = 1;
              AppMethodBeat.o(37325);
              return;
              cqD();
            }
          }
        } while (this.rwX != 3);
        if (this.rwP) {
          cqy();
        } else {
          cqD();
        }
      }
    }
    this.rwS = false;
    this.rwR = false;
    crn();
    if (this.rwX == 1) {
      this.rwX = 2;
    }
    AppMethodBeat.o(37325);
  }
  
  public final void cqD()
  {
    AppMethodBeat.i(37321);
    super.cqD();
    this.rwH.setImageDrawable(a.k(this.context, 2130839257));
    this.rwF.setMute(false);
    this.rwP = false;
    AppMethodBeat.o(37321);
  }
  
  public final void cqK()
  {
    AppMethodBeat.i(37315);
    View localView = this.contentView.findViewById(2131821354);
    localView.setBackgroundColor(-16777216);
    int k = this.iiW;
    int j = this.iiX;
    int i = j;
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)this.rve).rtm == 1)
    {
      i = j;
      if ((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)this.rve).width > 0) {
        i = k * (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)this.rve).height / (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)this.rve).width;
      }
    }
    else
    {
      localView.setPadding((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)this.rve).paddingLeft, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)this.rve).paddingTop, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)this.rve).paddingRight, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)this.rve).paddingBottom);
    }
    localView.setLayoutParams(new RelativeLayout.LayoutParams(k, i));
    localView.setMinimumHeight(i);
    this.rwF = ((AdLandingVideoWrapper)localView.findViewById(2131821436));
    this.rwF.setIMMVideoViewCallback(this);
    this.rwF.setOnClickListener(this.rxg);
    this.rwF.c(false, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)this.rve).rsB, 0);
    this.rwF.setIsShowBasicControls(true);
    this.gvK = ((ProgressBar)localView.findViewById(2131821246));
    this.mZY = ((ImageView)localView.findViewById(2131821549));
    Object localObject = h.gy("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)this.rve).rtl);
    if (!e.cN((String)localObject)) {
      this.rwV = false;
    }
    if (this.rwV)
    {
      this.mZY.setImageBitmap(MMBitmapFactory.decodeFile((String)localObject));
      this.rwK = ((TextView)localView.findViewById(2131827796));
      this.rwK.setText(this.context.getString(2131299004));
      this.jbK = localView.findViewById(2131827859);
      this.jbK.setVisibility(4);
      this.rwG = new VideoPlayerSeekBar(this.context);
      this.rwG.setVisibility(4);
      if (this.rxc != null)
      {
        localObject = this.rxc;
        if (this.rwG.getVisibility() != 0) {
          break label677;
        }
      }
    }
    label677:
    for (boolean bool = true;; bool = false)
    {
      ((ad)localObject).ls(bool);
      this.rwG.setIplaySeekCallback(this);
      this.rwG.setOnPlayButtonClickListener(this.rxd);
      localObject = new RelativeLayout.LayoutParams(k - a.fromDPToPix(this.context, 30), -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      this.rwG.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.rwF.setVideoFooterView(this.rwG);
      this.rwH = ((ImageView)localView.findViewById(2131827860));
      this.rwH.setVisibility(4);
      this.rwH.setOnClickListener(this.rxe);
      this.rwH.setPadding(0, 0, a.fromDPToPix(this.context, 8), 0);
      this.rwJ = ((ImageView)localView.findViewById(2131820996));
      this.rwJ.setImageDrawable(a.k(this.context, 2131231980));
      this.rwJ.setVisibility(8);
      this.rwJ.setOnClickListener(this.rxf);
      ((ViewGroup)this.rwG.getParent()).removeView(this.rwG);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
      ((ViewGroup)localView).addView(this.rwG, (ViewGroup.LayoutParams)localObject);
      this.rwF.setVideoPlayCallback(new aa.6(this));
      AppMethodBeat.o(37315);
      return;
      h.c("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)this.rve).rtl, false, 1000000001, new aa.5(this));
      break;
    }
  }
  
  protected final void cqP() {}
  
  public final void cqy()
  {
    AppMethodBeat.i(37320);
    super.cqy();
    this.rwH.setImageDrawable(a.k(this.context, 2130839256));
    this.rwF.setMute(true);
    this.rwP = true;
    AppMethodBeat.o(37320);
  }
  
  public final void cqz()
  {
    AppMethodBeat.i(37324);
    super.cqz();
    this.rwF.aEM();
    AppMethodBeat.o(37324);
  }
  
  public final void cr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37328);
    this.rwZ += 1;
    setFocus(true);
    this.rwF.ryl.stopTimer();
    if (this.oXt != 0L)
    {
      this.rwY = ((int)(this.rwY + (System.currentTimeMillis() - this.oXt)));
      this.oXt = 0L;
    }
    this.rwX = 5;
    this.rwF.alo();
    AppMethodBeat.o(37328);
  }
  
  public final void cra()
  {
    AppMethodBeat.i(37331);
    super.cra();
    crn();
    String str = h.gy("adId", ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)this.rve).rtl);
    if (e.cN(str))
    {
      this.mZY.setImageBitmap(MMBitmapFactory.decodeFile(str));
      this.mZY.setVisibility(0);
    }
    AppMethodBeat.o(37331);
  }
  
  final void crn()
  {
    AppMethodBeat.i(37317);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "pause play");
    this.faV.post(new aa.2(this));
    if (this.oXt != 0L)
    {
      this.rwY = ((int)(this.rwY + (System.currentTimeMillis() - this.oXt)));
      this.oXt = 0L;
    }
    AppMethodBeat.o(37317);
  }
  
  public final void cs(String paramString1, String paramString2) {}
  
  public final void ct(String paramString1, String paramString2)
  {
    AppMethodBeat.i(37329);
    this.mZY.setVisibility(8);
    this.gvK.setVisibility(8);
    AppMethodBeat.o(37329);
  }
  
  public final void cu(String paramString1, String paramString2) {}
  
  public final void cv(String paramString1, String paramString2) {}
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  protected final int getLayout()
  {
    return 2130970785;
  }
  
  public final void on(int paramInt)
  {
    AppMethodBeat.i(37327);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.Sns.AdLandingPageStreamVideoPlayerComponent", "onSeek time ".concat(String.valueOf(paramInt)));
    if (this.rwP) {
      cqy();
    }
    for (;;)
    {
      Ee(paramInt);
      AppMethodBeat.o(37327);
      return;
      cqE();
      cqD();
    }
  }
  
  final void setFocus(boolean paramBoolean)
  {
    AppMethodBeat.i(37318);
    if (paramBoolean)
    {
      this.rwG.setVisibility(0);
      this.rwH.setVisibility(0);
      this.jbK.setVisibility(0);
      if (this.rxc != null) {
        this.rxc.ls(true);
      }
      this.faV.postDelayed(this.rwL, 5000L);
      AppMethodBeat.o(37318);
      return;
    }
    this.rwO = false;
    this.rwG.setVisibility(4);
    this.rwH.setVisibility(8);
    this.jbK.setVisibility(4);
    if (this.rxc != null) {
      this.rxc.ls(false);
    }
    this.faV.removeCallbacks(this.rwL);
    AppMethodBeat.o(37318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aa
 * JD-Core Version:    0.7.0.1
 */