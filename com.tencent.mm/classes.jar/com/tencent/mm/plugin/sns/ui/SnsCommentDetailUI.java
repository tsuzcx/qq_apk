package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Guideline;
import com.tencent.c.a.a.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.f.a.jg;
import com.tencent.mm.f.a.jh;
import com.tencent.mm.f.a.no;
import com.tencent.mm.f.a.np;
import com.tencent.mm.f.a.sw;
import com.tencent.mm.f.a.we;
import com.tencent.mm.f.a.xo;
import com.tencent.mm.f.a.xq;
import com.tencent.mm.f.a.xr;
import com.tencent.mm.f.a.zo;
import com.tencent.mm.f.b.a.ko;
import com.tencent.mm.f.b.a.ld;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.b.j.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.a.a;
import com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ap.a;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.at.b;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.protocal.protobuf.eju;
import com.tencent.mm.protocal.protobuf.ekr;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.protocal.protobuf.fiu;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.kernel.k
public class SnsCommentDetailUI
  extends MMSecDataActivity
  implements com.tencent.mm.an.i, j.a, com.tencent.mm.plugin.sns.model.c.b, ad
{
  private static com.tencent.mm.ay.a.a.c KPH;
  private static com.tencent.mm.ay.a.a.c KPI;
  public static int KPk;
  private static com.tencent.mm.loader.c.d<String, Bitmap> zuz;
  private com.tencent.mm.plugin.sns.ui.d.c JIp;
  private LinearLayout JTg;
  private boolean JXf;
  private boolean JXh;
  private boolean KBP;
  private SnsCommentFooter KBS;
  private bd KBU;
  private b KCa;
  private com.tencent.mm.plugin.sns.h.b KCb;
  private ar KCc;
  private bx KCd;
  private com.tencent.mm.ui.base.s KCf;
  private IListener KCh;
  private View.OnTouchListener KDW;
  private volatile boolean KLC;
  private ScreenShotUtil.ScreenShotCallback KMx;
  private long KOF;
  private long KOG;
  private View KOH;
  private TextView KOI;
  private LinearLayout KOJ;
  private SnsDetailLuckyHeader KOK;
  private ListView KOL;
  private View KOM;
  private View KON;
  private b KOO;
  private ScaleAnimation KOP;
  private ScaleAnimation KOQ;
  LinearLayout KOR;
  LinearLayout KOS;
  private LinkedList<ejo> KOT;
  private int KOU;
  private boolean KOV;
  private bg KOW;
  private String KOX;
  private com.tencent.mm.storage.bv KOY;
  private int KOZ;
  private FrameLayout KPA;
  private com.tencent.mm.ui.blur.f KPB;
  private com.tencent.mm.plugin.sns.model.ak KPC;
  private IListener KPD;
  private IListener KPE;
  private IListener KPF;
  private IListener KPG;
  private c KPJ;
  private View.OnClickListener KPK;
  private IListener KPL;
  private IListener KPM;
  boolean KPN;
  private LinearLayout KPO;
  private boolean KPP;
  PhotosContent KPQ;
  int KPR;
  public az.b.a KPS;
  private bt KPT;
  private ImageView KPa;
  private WeImageView KPb;
  private j KPc;
  private l KPd;
  private boolean KPe;
  private long KPf;
  private bu KPg;
  private boolean KPh;
  private int KPi;
  private int KPj;
  public int KPl;
  private com.tencent.mm.plugin.sns.ui.c.a.b KPm;
  public com.tencent.mm.plugin.sns.ad.f.l KPn;
  private SnsTranslateResultView KPo;
  private boolean KPp;
  private Dialog KPq;
  private boolean KPr;
  private boolean KPs;
  private String KPt;
  private boolean KPu;
  private int KPv;
  private boolean KPw;
  private int KPx;
  private n KPy;
  private TextView KPz;
  private String fLp;
  private String fMd;
  private String iRj;
  private final com.tencent.mm.pluginsdk.ui.span.a mAdTagClickCallback;
  private int mScreenHeight;
  private int mScreenWidth;
  private boolean oZY;
  private IListener ozM;
  private int rWq;
  private View.OnClickListener sAi;
  private com.tencent.mm.ui.widget.b.a szq;
  private View.OnClickListener uqL;
  private int viewType;
  private IListener wNM;
  
  static
  {
    AppMethodBeat.i(163117);
    KPk = 34;
    c.a locala = new c.a();
    locala.lRD = true;
    locala.lRB = true;
    KPH = locala.bmL();
    zuz = new SnsCommentDetailUI.46();
    locala = new c.a();
    locala.lRD = true;
    locala.lRB = true;
    KPI = locala.bmL();
    AppMethodBeat.o(163117);
  }
  
  public SnsCommentDetailUI()
  {
    AppMethodBeat.i(98590);
    this.KOF = 0L;
    this.KOG = 0L;
    this.KOU = -1;
    this.KOV = false;
    this.KDW = Util.genLinearPressedListener();
    this.KCf = null;
    this.rWq = 0;
    this.KOZ = 0;
    this.oZY = false;
    this.fMd = "";
    this.KPe = false;
    this.KPf = 0L;
    this.KPh = false;
    this.KPj = 103;
    this.KPl = 210;
    this.KPp = false;
    this.KPq = null;
    this.KPr = false;
    this.KPs = false;
    this.KPt = "";
    this.KPu = true;
    this.KPw = false;
    this.KPx = 0;
    this.JXf = false;
    this.JXh = false;
    this.KPy = null;
    this.KPz = null;
    this.KLC = false;
    this.KPB = null;
    this.KPC = new com.tencent.mm.plugin.sns.model.ak();
    this.KPD = new IListener() {};
    this.KPE = new IListener() {};
    this.KPF = new IListener() {};
    this.KPG = new IListener() {};
    this.KCh = new IListener() {};
    this.KPJ = new c();
    this.sAi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(98579);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        localObject1 = (String)paramAnonymousView.getTag();
        Log.d("MicroMsg.SnsCommentDetailUI", "onCommentClick:".concat(String.valueOf(localObject1)));
        SnsInfo localSnsInfo = SnsCommentDetailUI.a(SnsCommentDetailUI.this, true);
        if ((localSnsInfo != null) && (localSnsInfo.isAd()))
        {
          SnsAdClick localSnsAdClick = new SnsAdClick(SnsCommentDetailUI.this.getSource(), 2, localSnsInfo.field_snsId, 1, 0);
          com.tencent.mm.plugin.sns.data.m.a(localSnsAdClick, SnsCommentDetailUI.e(SnsCommentDetailUI.this), localSnsInfo, 1);
          if ((localObject1 != null) && (((String)localObject1).equals(localSnsInfo.getUserName())))
          {
            Object localObject2 = localSnsInfo.getAdXml();
            if (localObject2 != null)
            {
              if ((((ADXml)localObject2).headClickType == 1) && (!Util.isNullOrNil(((ADXml)localObject2).headClickParam)))
              {
                localObject1 = ((ADXml)localObject2).headClickParam;
                localObject3 = SnsCommentDetailUI.a(SnsCommentDetailUI.this, localSnsInfo);
                paramAnonymousView = (View)localObject1;
                if (localObject3 != null) {
                  paramAnonymousView = com.tencent.mm.plugin.sns.data.t.kw((String)localObject1, ((ADInfo)localObject3).uxInfo);
                }
                Log.i("MicroMsg.SnsCommentDetailUI", "headClickParam url " + paramAnonymousView + " " + ((ADXml)localObject2).headClickRightBarShow);
                localObject1 = new Intent();
                if (((ADXml)localObject2).headClickRightBarShow == 0) {
                  bool = true;
                }
                ((Intent)localObject1).putExtra("KsnsViewId", SnsCommentDetailUI.a(SnsCommentDetailUI.this, localSnsInfo).viewId);
                ((Intent)localObject1).putExtra("KRightBtn", bool);
                ((Intent)localObject1).putExtra("jsapiargs", new Bundle());
                ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView);
                ((Intent)localObject1).putExtra("useJs", true);
                com.tencent.mm.plugin.sns.c.a.mIG.h((Intent)localObject1, SnsCommentDetailUI.this);
                com.tencent.mm.plugin.sns.data.t.a(localSnsAdClick);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98579);
                return;
              }
              localObject2 = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
              ((com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject2).put("ext_sns_ad_click", localSnsAdClick);
              Object localObject3 = com.tencent.mm.plugin.sns.ad.timeline.a.a.e(1, SnsCommentDetailUI.this);
              if ((localObject3 != null) && (((com.tencent.mm.plugin.sns.ad.timeline.a.c)localObject3).a(paramAnonymousView, SnsCommentDetailUI.this.getSource(), localSnsInfo, (com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject2)))
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98579);
                return;
              }
            }
          }
          com.tencent.mm.plugin.sns.data.t.a(localSnsAdClick);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", (String)localObject1);
          paramAnonymousView.putExtra("Contact_Scene", 37);
          com.tencent.mm.plugin.sns.c.a.mIG.c(paramAnonymousView, SnsCommentDetailUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98579);
          return;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", (String)localObject1);
        com.tencent.mm.plugin.sns.c.a.mIG.c(paramAnonymousView, SnsCommentDetailUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98579);
      }
    };
    this.KPK = new SnsCommentDetailUI.48(this);
    this.uqL = new SnsCommentDetailUI.3(this);
    this.KPL = new SnsCommentDetailUI.8(this);
    this.ozM = new IListener() {};
    this.wNM = new IListener() {};
    this.KPM = new SnsCommentDetailUI.11(this);
    this.KMx = new ScreenShotUtil.ScreenShotCallback()
    {
      public final void onScreenShot(String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(270586);
        Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onScreenShot， path = " + paramAnonymousString + "， dateAdded = " + paramAnonymousLong);
        SnsCommentDetailUI.u(SnsCommentDetailUI.this);
        AppMethodBeat.o(270586);
      }
    };
    this.KPN = false;
    this.KPO = null;
    this.KPP = false;
    this.KPQ = null;
    this.KPR = 0;
    this.KPS = new az.b.a()
    {
      public final void s(final String paramAnonymousString, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(206171);
        Log.i("MicroMsg.SnsCommentDetailUI", "setAvatar, getContactCallBack, userName=" + paramAnonymousString + ", succ=" + paramAnonymousBoolean + ", retryCount=" + SnsCommentDetailUI.this.KPR);
        new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198021);
            if ((paramAnonymousBoolean) && (!SnsCommentDetailUI.this.isFinishing()) && (SnsCommentDetailUI.this.KPR < 5))
            {
              Log.i("MicroMsg.SnsCommentDetailUI", "setAvatar, setHeader after getContact, userName=" + paramAnonymousString);
              SnsCommentDetailUI.this.fWc();
            }
            SnsCommentDetailUI localSnsCommentDetailUI = SnsCommentDetailUI.this;
            localSnsCommentDetailUI.KPR += 1;
            AppMethodBeat.o(198021);
          }
        }, 500L);
        AppMethodBeat.o(206171);
      }
    };
    this.KPT = null;
    this.mAdTagClickCallback = new com.tencent.mm.pluginsdk.ui.span.a()
    {
      public final void jU(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(197910);
        try
        {
          SnsInfo localSnsInfo = SnsCommentDetailUI.a(SnsCommentDetailUI.this, false);
          if (localSnsInfo != null)
          {
            Log.i("AdTagClickableHelper", "In SnsCommentDetailUI, snsId = " + localSnsInfo.field_snsId + ", source = " + SnsCommentDetailUI.this.getSource() + ", clickPos = " + paramAnonymousInt2);
            com.tencent.mm.plugin.sns.ad.timeline.b.c.a(SnsCommentDetailUI.this, SnsCommentDetailUI.this.getSource(), localSnsInfo, paramAnonymousInt2);
            AppMethodBeat.o(197910);
            return;
          }
          Log.e("AdTagClickableHelper", "In SnsCommentDetailUI, snsInfo is null");
          AppMethodBeat.o(197910);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("AdTagClickableHelper", localThrowable.toString());
          AppMethodBeat.o(197910);
        }
      }
    };
    AppMethodBeat.o(98590);
  }
  
  private static void a(SnsInfo paramSnsInfo, PhotosContent paramPhotosContent, int paramInt)
  {
    AppMethodBeat.i(220069);
    if ((paramSnsInfo != null) && (paramSnsInfo.isAd()) && (paramInt == 2))
    {
      FrameLayout.LayoutParams localLayoutParams = null;
      try
      {
        paramSnsInfo = paramSnsInfo.getAdXml();
        if ((paramSnsInfo != null) && (paramSnsInfo.isShowPlayIconOnCover()))
        {
          paramSnsInfo = paramPhotosContent.findViewById(i.f.status_icon);
          if (paramSnsInfo == null) {}
        }
        int i;
        int j;
        if (paramPhotosContent == null) {
          break label182;
        }
      }
      catch (Throwable paramSnsInfo)
      {
        try
        {
          paramSnsInfo.setVisibility(0);
          paramPhotosContent = (FrameLayout.LayoutParams)paramPhotosContent.agW(0).getLayoutParams();
          localLayoutParams = (FrameLayout.LayoutParams)paramSnsInfo.getLayoutParams();
          paramInt = paramPhotosContent.width / 2 - localLayoutParams.width / 2 + paramPhotosContent.leftMargin;
          i = paramPhotosContent.height / 2;
          j = localLayoutParams.height / 2;
          i = paramPhotosContent.topMargin + (i - j);
          if ((paramInt != localLayoutParams.leftMargin) || (i != localLayoutParams.topMargin))
          {
            localLayoutParams.leftMargin = paramInt;
            localLayoutParams.topMargin = i;
            paramSnsInfo.setLayoutParams(localLayoutParams);
          }
          AppMethodBeat.o(220069);
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            paramPhotosContent = paramSnsInfo;
            paramSnsInfo = localThrowable;
          }
        }
        paramSnsInfo = paramSnsInfo;
        paramPhotosContent = localLayoutParams;
      }
      paramPhotosContent.setVisibility(8);
      label182:
      Log.e("MicroMsg.SnsCommentDetailUI", "checkShowStatusIcon exp=" + paramSnsInfo.toString());
    }
    else
    {
      AppMethodBeat.o(220069);
      return;
    }
  }
  
  private void a(PhotosContent paramPhotosContent)
  {
    AppMethodBeat.i(220003);
    if (paramPhotosContent == null)
    {
      AppMethodBeat.o(220003);
      return;
    }
    try
    {
      ImageView localImageView = new ImageView(getContext());
      int i = com.tencent.mm.ci.a.fromDPToPix(getContext(), 24);
      int j = com.tencent.mm.ci.a.fromDPToPix(getContext(), 4);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
      localLayoutParams.leftMargin = j;
      localLayoutParams.topMargin = j;
      localImageView.setImageDrawable(com.tencent.mm.ci.a.m(getContext(), i.e.we_app_icon));
      localImageView.setLayoutParams(localLayoutParams);
      paramPhotosContent.addView(localImageView);
      AppMethodBeat.o(220003);
      return;
    }
    catch (Throwable paramPhotosContent)
    {
      Log.e("MicroMsg.SnsCommentDetailUI", paramPhotosContent.toString());
      AppMethodBeat.o(220003);
    }
  }
  
  private void a(PhotosContent paramPhotosContent, int paramInt)
  {
    AppMethodBeat.i(220007);
    if ((paramPhotosContent == null) || (paramInt <= 1))
    {
      Log.e("MicroMsg.SnsCommentDetailUI", "photosContent == null or imgNums <= 1");
      AppMethodBeat.o(220007);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = com.tencent.mm.ci.a.fromDPToPix(getContext(), 20);
        i = 0;
        if (i < paramInt) {
          if (paramPhotosContent.agW(i).getVisibility() == 8)
          {
            Log.i("MicroMsg.SnsCommentDetailUI", "current index " + i + " imageView is a placeholder, so visibility is gone");
          }
          else
          {
            ImageView localImageView = com.tencent.mm.plugin.sns.ad.timeline.b.d.a(getContext(), paramPhotosContent, i, j);
            if (localImageView != null) {
              paramPhotosContent.addView(localImageView);
            }
          }
        }
      }
      catch (Throwable paramPhotosContent)
      {
        Log.e("MicroMsg.SnsCommentDetailUI", paramPhotosContent.toString());
        AppMethodBeat.o(220007);
        return;
      }
      AppMethodBeat.o(220007);
      return;
      i += 1;
    }
  }
  
  private LinearLayout ahe(int paramInt)
  {
    AppMethodBeat.i(98601);
    if (this.KPO == null)
    {
      this.KPO = ((LinearLayout)com.tencent.mm.ui.ad.kS(this).inflate(paramInt, null));
      localLinearLayout = this.KPO;
      AppMethodBeat.o(98601);
      return localLinearLayout;
    }
    this.KPN = true;
    LinearLayout localLinearLayout = this.KPO;
    AppMethodBeat.o(98601);
    return localLinearLayout;
  }
  
  private void f(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(98603);
    if (this.KPz == null)
    {
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
      this.KPz = new TextView(this);
      this.KPz.setLayoutParams(localLayoutParams);
      this.KPz.setText(getString(i.j.sns_detail_private_link_tip));
      this.KPz.setTextColor(getResources().getColor(i.c.normal_text_color));
      this.KPz.setGravity(17);
      this.KPz.setPadding(0, BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 7.0F), 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 12.0F));
      this.KPz.setVisibility(8);
      this.KOL.addFooterView(this.KPz);
    }
    if (paramSnsInfo != null)
    {
      if ((paramSnsInfo.getLocalPrivate() & 0x1) != 0)
      {
        findViewById(i.f.comment_footer).setVisibility(8);
        paramSnsInfo = paramSnsInfo.getTimeLine();
        if (paramSnsInfo != null) {
          switch (paramSnsInfo.ContentObj.Sqq)
          {
          }
        }
        for (;;)
        {
          this.KPz.setVisibility(0);
          AppMethodBeat.o(98603);
          return;
          this.KPz.setText(getString(i.j.sns_detail_private_photo_tip));
          continue;
          this.KPz.setText(getString(i.j.sns_detail_private_video_tip));
          continue;
          this.KPz.setText(getString(i.j.sns_detail_private_text_tip));
        }
      }
      if (paramBoolean) {
        findViewById(i.f.comment_footer).setVisibility(0);
      }
      this.KPz.setVisibility(8);
    }
    AppMethodBeat.o(98603);
  }
  
  private int fWa()
  {
    AppMethodBeat.i(98600);
    if ((this.KOL != null) && (this.KOL.getChildCount() > 1))
    {
      View localView = this.KOL.getChildAt(0);
      if (localView != null)
      {
        int i = localView.getHeight();
        AppMethodBeat.o(98600);
        return i;
      }
    }
    AppMethodBeat.o(98600);
    return 0;
  }
  
  private static boolean fWb()
  {
    AppMethodBeat.i(98602);
    if ((ap.a.fPq() & 0x1) <= 0)
    {
      AppMethodBeat.o(98602);
      return true;
    }
    AppMethodBeat.o(98602);
    return false;
  }
  
  private void fWd()
  {
    AppMethodBeat.i(98605);
    if ((this.KOM == null) || (this.KOM.getVisibility() == 8))
    {
      AppMethodBeat.o(98605);
      return;
    }
    this.KOM.startAnimation(this.KOQ);
    this.KOQ.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(236541);
        Log.d("MicroMsg.SnsCommentDetailUI", "onAnimationEnd");
        if (SnsCommentDetailUI.G(SnsCommentDetailUI.this) != null)
        {
          SnsCommentDetailUI.G(SnsCommentDetailUI.this).clearAnimation();
          SnsCommentDetailUI.G(SnsCommentDetailUI.this).setVisibility(8);
        }
        AppMethodBeat.o(236541);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    AppMethodBeat.o(98605);
  }
  
  private void fWe()
  {
    AppMethodBeat.i(98606);
    if ((keyboardState() == 1) || (this.KBS.fWj()))
    {
      this.KPJ.run();
      AppMethodBeat.o(98606);
      return;
    }
    this.KBP = true;
    AppMethodBeat.o(98606);
  }
  
  private void fWf()
  {
    AppMethodBeat.i(98607);
    if (this.KPa == null)
    {
      AppMethodBeat.o(98607);
      return;
    }
    this.KPa.setPressed(false);
    if (bu.aXq(this.fMd))
    {
      this.KPa.setImageResource(i.e.music_pauseicon);
      AppMethodBeat.o(98607);
      return;
    }
    this.KPa.setImageResource(i.e.music_playicon);
    AppMethodBeat.o(98607);
  }
  
  @SuppressLint({"ResourceType"})
  private void fWg()
  {
    AppMethodBeat.i(220016);
    if (this.KPb == null)
    {
      AppMethodBeat.o(220016);
      return;
    }
    this.KPb.setPressed(false);
    if (bu.aXq(this.fMd)) {
      this.KPb.setImageResource(i.i.icons_outlined_pause2);
    }
    for (;;)
    {
      this.KPb.setIconColor(getContext().getResources().getColor(i.c.black_color));
      AppMethodBeat.o(220016);
      return;
      this.KPb.setImageResource(i.i.icons_outlined_play2);
    }
  }
  
  private static boolean g(LinkedList<ejo> paramLinkedList1, LinkedList<ejo> paramLinkedList2)
  {
    AppMethodBeat.i(98591);
    if ((paramLinkedList1 == null) || (paramLinkedList2 == null))
    {
      AppMethodBeat.o(98591);
      return false;
    }
    if (paramLinkedList1.size() != paramLinkedList2.size())
    {
      AppMethodBeat.o(98591);
      return false;
    }
    int j = paramLinkedList1.size();
    int i = 0;
    while (i < j)
    {
      if (!((ejo)paramLinkedList1.get(i)).Username.equals(((ejo)paramLinkedList2.get(i)).Username))
      {
        AppMethodBeat.o(98591);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(98591);
    return true;
  }
  
  private ADInfo h(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(98594);
    if (paramSnsInfo != null)
    {
      if (getSource() == 2)
      {
        paramSnsInfo = paramSnsInfo.getAtAdInfo();
        AppMethodBeat.o(98594);
        return paramSnsInfo;
      }
      paramSnsInfo = paramSnsInfo.getAdInfo();
      AppMethodBeat.o(98594);
      return paramSnsInfo;
    }
    AppMethodBeat.o(98594);
    return null;
  }
  
  private boolean p(List<ejo> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(98608);
    int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 32.0F);
    int m = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 6.0F);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 10.0F);
    int j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 17.0F);
    if (this.KOJ == null)
    {
      AppMethodBeat.o(98608);
      return false;
    }
    int n = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    float f = getResources().getDimension(i.d.NormalPadding);
    Log.d("MicroMsg.SnsCommentDetailUI", "guess size %d %f", new Object[] { Integer.valueOf(n), Float.valueOf(f) });
    f = n - f * 2.0F;
    if (paramList.size() <= 0)
    {
      if (this.KOJ.getParent() != null) {
        this.KOJ.setVisibility(8);
      }
      this.KOJ.removeAllViews();
      this.KOJ.setVisibility(8);
      this.JTg.setVisibility(8);
      AppMethodBeat.o(98608);
      return false;
    }
    this.KOJ.getParent();
    this.KOJ.removeAllViews();
    this.KOJ.setVisibility(0);
    Object localObject1;
    if (this.viewType == 10) {
      if (!this.KPp)
      {
        this.KOJ.setBackgroundResource(i.e.friendactivity_comment_detail_list_golden_arror);
        this.KOJ.setPadding(0, m, 0, m);
        localObject1 = new ImageView(getContext());
        if (this.viewType != 10) {
          break label692;
        }
        ((ImageView)localObject1).setImageResource(i.i.friendactivity_likeicon_golden);
      }
    }
    for (;;)
    {
      ((ImageView)localObject1).setPadding(i, j, i, 0);
      Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 49;
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ImageView)localObject1).setClickable(false);
      ((ImageView)localObject1).setFocusable(false);
      this.KOJ.addView((View)localObject1);
      n = com.tencent.mm.ci.a.fromDPToPix(getContext(), KPk);
      j = (int)(f - n) / (m + k);
      i = j;
      if ((int)(f - n) % (m + k) > k) {
        i = j + 1;
      }
      Log.d("MicroMsg.SnsCommentDetailUI", "guess size %d", new Object[] { Integer.valueOf(i) });
      localObject1 = new h(getContext());
      ((h)localObject1).setClipChildren(false);
      ((h)localObject1).setClipToPadding(false);
      ((h)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((h)localObject1).setLineMaxCounte(i);
      i = 0;
      while (i < paramList.size())
      {
        localObject2 = (ejo)paramList.get(i);
        StoryTouchImageView localStoryTouchImageView = new StoryTouchImageView(getContext());
        localStoryTouchImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localStoryTouchImageView.setImageResource(i.e.friendactivity_personalportrait);
        Object localObject3 = ((ejo)localObject2).Username;
        localStoryTouchImageView.LeM.gp((String)localObject3, 1);
        localObject3 = new LinearLayout.LayoutParams(k, k);
        ((LinearLayout.LayoutParams)localObject3).setMargins(0, m, m, 0);
        localStoryTouchImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localStoryTouchImageView.setTag(((ejo)localObject2).Username);
        com.tencent.mm.pluginsdk.ui.a.b.C(localStoryTouchImageView, ((ejo)localObject2).Username);
        localStoryTouchImageView.setOnClickListener(this.sAi);
        ((h)localObject1).addView(localStoryTouchImageView);
        i += 1;
      }
      localObject1 = yW(false);
      if (localObject1 != null)
      {
        if (this.iRj.equals(((SnsInfo)localObject1).getUserName()))
        {
          this.KOJ.setBackgroundResource(i.e.friendactivity_comment_detail_list_golden_myself);
          break;
        }
        this.KOJ.setBackgroundResource(i.e.friendactivity_comment_detail_list_golden_arror);
        break;
      }
      this.KOJ.setBackgroundResource(i.e.friendactivity_comment_detail_list_golden_arror);
      break;
      this.KOJ.setBackgroundResource(i.e.friendactivity_comment_list_normal);
      break;
      label692:
      ((ImageView)localObject1).setImageDrawable(au.o(getContext(), i.i.friendactivity_likeicon, getContext().getResources().getColor(i.c.Link)));
    }
    this.KOJ.addView((View)localObject1);
    paramList = this.JTg;
    if (paramBoolean) {}
    for (i = 8;; i = 0)
    {
      paramList.setVisibility(i);
      AppMethodBeat.o(98608);
      return true;
    }
  }
  
  private void yV(boolean paramBoolean)
  {
    AppMethodBeat.i(98592);
    this.KOV = false;
    if (this.KBS.fWi())
    {
      this.KBS.KQF = 0;
      this.KBS.fWl();
      this.KBS.setCommentHint(getString(i.j.sns_ui_comment));
    }
    this.KBS.yX(false);
    if (paramBoolean)
    {
      Object localObject1 = this.KOL;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "scrollDown", "(Z)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
      BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "scrollDown", "(Z)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    }
    AppMethodBeat.o(98592);
  }
  
  private SnsInfo yW(boolean paramBoolean)
  {
    AppMethodBeat.i(98593);
    SnsInfo localSnsInfo;
    if (!Util.isNullOrNil(this.KOX))
    {
      localSnsInfo = com.tencent.mm.plugin.sns.storage.f.bbl(this.KOX);
      if (localSnsInfo == null)
      {
        if (paramBoolean) {
          Toast.makeText(this, i.j.sns_msg_not_found, 0).show();
        }
        finish();
        AppMethodBeat.o(98593);
        return null;
      }
      this.fLp = localSnsInfo.getSnsId();
    }
    for (;;)
    {
      AppMethodBeat.o(98593);
      return localSnsInfo;
      localSnsInfo = com.tencent.mm.plugin.sns.storage.f.bbk(this.fLp);
      if (localSnsInfo == null)
      {
        finish();
        AppMethodBeat.o(98593);
        return null;
      }
      this.KOX = localSnsInfo.getLocalid();
    }
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void aYK(String paramString) {}
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void cq(String paramString, boolean paramBoolean) {}
  
  public final void cr(String paramString, boolean paramBoolean) {}
  
  public final void fLL() {}
  
  public final ar fTn()
  {
    return this.KCc;
  }
  
  public final b fTo()
  {
    return this.KCa;
  }
  
  public final bv fTp()
  {
    return null;
  }
  
  public final bx fTq()
  {
    return this.KCd;
  }
  
  @SuppressLint({"ResourceType"})
  final boolean fWc()
  {
    AppMethodBeat.i(98604);
    final SnsInfo localSnsInfo = yW(true);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(98604);
      return false;
    }
    Log.i("MicroMsg.SnsCommentDetailUI", "setheader " + this.KOH.toString());
    this.KPi = aj.fOV();
    Object localObject7 = localSnsInfo.getTimeLine();
    this.viewType = bm.g(localSnsInfo, false);
    Object localObject1 = (SnsAvatarImageView)this.KOH.findViewById(i.f.album_avatar_iv);
    Object localObject5 = (RelativeLayout)this.KOH.findViewById(i.f.openim_tag_ll);
    ((RelativeLayout)localObject5).setVisibility(8);
    ((RelativeLayout)localObject5).setOnClickListener(this.JIp.Lpt);
    Object localObject2;
    boolean bool1;
    if ((localObject1 == null) || (localSnsInfo == null))
    {
      localObject2 = new StringBuilder("unknow error ? ");
      if (localObject1 == null)
      {
        bool1 = true;
        localObject1 = ((StringBuilder)localObject2).append(bool1).append(" ");
        if (localSnsInfo != null) {
          break label211;
        }
      }
      label211:
      for (bool1 = true;; bool1 = false)
      {
        Log.e("MicroMsg.SnsCommentDetailUI", bool1);
        AppMethodBeat.o(98604);
        return false;
        bool1 = false;
        break;
      }
    }
    ((SnsAvatarImageView)localObject1).setWeakContext(this);
    ((MaskImageButton)localObject1).kQV = localSnsInfo.getLocalid();
    ((SnsAvatarImageView)localObject1).setTag(localSnsInfo.getUserName());
    boolean bool2 = false;
    if ((localSnsInfo.getAdXml() != null) && (localSnsInfo.getAdXml().usePreferedInfo))
    {
      if (Util.isNullOrNil(localSnsInfo.getAdXml().preferAvatar)) {
        break label16745;
      }
      localObject2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", localSnsInfo.getAdXml().preferAvatar);
      ((SnsAvatarImageView)localObject1).setTag(i.f.sns_prefer_avatar_url, localSnsInfo.getAdXml().preferAvatar);
      if (u.agG((String)localObject2)) {
        if (com.tencent.mm.plugin.sns.ad.timeline.b.h.fLz())
        {
          com.tencent.mm.plugin.sns.ad.timeline.b.h.i((ImageView)localObject1, (String)localObject2, 1);
          bool1 = true;
        }
      }
    }
    label336:
    label599:
    label1241:
    label2530:
    label5229:
    label14701:
    for (;;)
    {
      ((SnsAvatarImageView)localObject1).setOnClickListener(this.JIp.LoQ);
      Object localObject4 = (TextView)this.KOH.findViewById(i.f.nickname_tv);
      com.tencent.mm.kernel.h.aHH();
      Object localObject8 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(localSnsInfo.getUserName());
      Log.i("MicroMsg.SnsCommentDetailUI", "snsinfo username " + localSnsInfo.getUserName() + " " + localSnsInfo.getSnsId() + " " + localSnsInfo.getCreateTime() + ", isAdAndUsePreferedInfo=" + bool1);
      if ((localObject8 != null) && (((as)localObject8).ayq() == 0) && (!bool1))
      {
        Log.i("MicroMsg.SnsCommentDetailUI", "getContact %s", new Object[] { localSnsInfo.getUserName() });
        az.a.ber().a(localSnsInfo.getUserName(), "", this.KPS);
      }
      int j = 0;
      if (localObject8 == null) {}
      int i;
      int k;
      for (localObject1 = localSnsInfo.getUserName();; localObject1 = ((as)localObject8).ays())
      {
        localObject1 = Util.nullAs((String)localObject1, "");
        if (!localSnsInfo.isAd()) {
          break label1782;
        }
        localObject2 = localSnsInfo.getAdXml();
        if (localObject2 == null) {
          break label16742;
        }
        if (!((ADXml)localObject2).usePreferedInfo) {
          break label1746;
        }
        localObject2 = ((ADXml)localObject2).preferNickName;
        i = 0;
        ((String)localObject2).length();
        if (this.viewType != 10) {
          break label1908;
        }
        k = 3;
        localObject1 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(this, (CharSequence)localObject2));
        ((com.tencent.mm.pluginsdk.ui.span.m)localObject1).a(new com.tencent.mm.pluginsdk.ui.span.q(new com.tencent.mm.plugin.sns.data.d(localSnsInfo.isAd(), ((as)localObject8).getUsername(), localSnsInfo.getLocalid(), 2), this.KPc, k), (CharSequence)localObject2);
        if ((j >= 0) && (i > j)) {
          ((com.tencent.mm.pluginsdk.ui.span.m)localObject1).setSpan(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).a(this, ((as)localObject8).apr(), this.KPx, i.c.BW_0_Alpha_0_5), j, i, 33);
        }
        ((TextView)localObject4).setOnTouchListener(new ah());
        ((TextView)localObject4).setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        ((TextView)this.KOH.findViewById(i.f.type_desc_tv)).setText("");
        if (this.KPT == null) {
          this.KPT = new bt(this.KOH, this.KPn, 1, new com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b()
          {
            public final void fLc()
            {
              AppMethodBeat.i(268575);
              if ((SnsCommentDetailUI.D(SnsCommentDetailUI.this) != null) && (SnsCommentDetailUI.x(SnsCommentDetailUI.this) != null)) {
                SnsCommentDetailUI.D(SnsCommentDetailUI.this).a(SnsCommentDetailUI.x(SnsCommentDetailUI.this), null);
              }
              AppMethodBeat.o(268575);
            }
            
            public final ViewGroup fLd()
            {
              AppMethodBeat.i(268576);
              ViewGroup localViewGroup;
              if ((SnsCommentDetailUI.x(SnsCommentDetailUI.this) instanceof com.tencent.mm.plugin.sns.ui.c.a.c))
              {
                localViewGroup = (ViewGroup)SnsCommentDetailUI.x(SnsCommentDetailUI.this).contentView.findViewById(i.f.media_container);
                AppMethodBeat.o(268576);
                return localViewGroup;
              }
              if ((SnsCommentDetailUI.x(SnsCommentDetailUI.this) instanceof com.tencent.mm.plugin.sns.ui.c.a.e))
              {
                localViewGroup = (ViewGroup)((com.tencent.mm.plugin.sns.ui.c.a.e)SnsCommentDetailUI.x(SnsCommentDetailUI.this)).LjM.xYJ;
                AppMethodBeat.o(268576);
                return localViewGroup;
              }
              if ((SnsCommentDetailUI.x(SnsCommentDetailUI.this) instanceof com.tencent.mm.plugin.sns.ui.c.a.d))
              {
                localViewGroup = (ViewGroup)((com.tencent.mm.plugin.sns.ui.c.a.d)SnsCommentDetailUI.x(SnsCommentDetailUI.this)).xYJ;
                AppMethodBeat.o(268576);
                return localViewGroup;
              }
              AppMethodBeat.o(268576);
              return null;
            }
          });
        }
        if (!localSnsInfo.isAd()) {
          break label1914;
        }
        this.KPT.G(Long.valueOf(localSnsInfo.field_snsId), new com.tencent.mm.plugin.sns.data.e(this.KPT, 0, this.KOX, localSnsInfo.field_snsId, h(localSnsInfo).viewId));
        this.KPT.a(localSnsInfo, localSnsInfo.getAdXml(), h(localSnsInfo));
        this.KPT.b(this.JIp.Lpa, this.JIp.Lpq);
        this.KPT.setVisibility(0);
        label885:
        localObject1 = ((TimeLineObject)localObject7).ContentDesc;
        this.KOI = ((TextView)this.KOH.findViewById(i.f.desc_tv));
        localObject4 = new bi(this.fLp, localSnsInfo.getLocalid(), true, false, 2);
        this.KOI.setTag(localObject4);
        this.szq.c(this.KOI, this.JIp.LoS, this.JIp.LoP);
        if (!Util.isNullOrNil((String)localObject1)) {
          break label1926;
        }
        this.KOI.setVisibility(8);
        localObject1 = (ViewStub)this.KOH.findViewById(i.f.images_keeper_li);
        if (!this.KPP) {
          ((ViewStub)localObject1).setLayoutResource(-1);
        }
        switch (this.viewType)
        {
        case 6: 
        case 7: 
        case 8: 
        case 12: 
        case 16: 
        case 17: 
        case 22: 
        case 24: 
        default: 
          ((ViewStub)localObject1).setVisibility(8);
          if (((ViewStub)localObject1).getLayoutResource() == -1) {
            break label2520;
          }
          localObject4 = ((ViewStub)localObject1).inflate();
          if (this.KPm != null)
          {
            this.KPm.oFW = findViewById(i.f.timeline_root);
            this.KPm.n((View)localObject4, this.KON);
            if (this.KPA != null)
            {
              if (!(this.KPm instanceof com.tencent.mm.plugin.sns.ui.c.a.e)) {
                break label2493;
              }
              ((com.tencent.mm.plugin.sns.ui.c.a.e)this.KPm).h(this.KPA);
            }
          }
          this.KPP = true;
          k = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
          if (this.viewType == 6) {
            break label3069;
          }
          if ((this.viewType != 2) && (this.viewType != 3) && (this.viewType != 4) && (this.viewType != 5)) {
            break label4718;
          }
          this.KPQ = ((PhotosContent)findViewById(i.f.photo_content));
          if (this.KPQ == null) {
            break label4675;
          }
          this.KPQ.fUL();
          if (this.viewType != 2) {
            break label2530;
          }
          i = 1;
          j = 0;
          while (j < i)
          {
            localObject1 = (TagImageView)this.KPQ.findViewById(bg.KUt[j]);
            this.KPQ.a((TagImageView)localObject1);
            ((TagImageView)localObject1).setOnClickListener(this.JIp.KEA);
            this.szq.c((View)localObject1, this.JIp.Lpd, this.JIp.LoP);
            j += 1;
          }
          localObject2 = com.tencent.mm.plugin.sns.ad.f.o.JFQ.JL((String)localObject2);
          if (localObject2 != null) {
            ((SnsAvatarImageView)localObject1).setImageBitmap((Bitmap)localObject2);
          }
          bool1 = true;
          break label336;
          if (com.tencent.mm.plugin.sns.ad.timeline.b.h.fLz())
          {
            Log.i("MicroMsg.SnsCommentDetailUI", "detail: download use avatar with cdn, but the statement should not reach!");
            com.tencent.mm.plugin.sns.ad.timeline.b.h.j((ImageView)localObject1, localSnsInfo.getAdXml().preferAvatar, 1);
            bool1 = true;
            break label336;
          }
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localSnsInfo.getAdXml().preferAvatar, false, new f.a()
          {
            public final void aYs(String paramAnonymousString)
            {
              AppMethodBeat.i(219452);
              Log.i("MicroMsg.SnsCommentDetailUI", "download img %s", new Object[] { paramAnonymousString });
              String str = (String)this.KQb.getTag(i.f.sns_prefer_avatar_url);
              if ((!Util.isNullOrNil(new String[] { str, paramAnonymousString })) && (paramAnonymousString.equals(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kU("adId", str))))
              {
                paramAnonymousString = com.tencent.mm.plugin.sns.ad.f.o.JFQ.JL(paramAnonymousString);
                if (paramAnonymousString != null) {
                  this.KQb.setImageBitmap(paramAnonymousString);
                }
              }
              AppMethodBeat.o(219452);
            }
            
            public final void fJU() {}
            
            public final void fJV()
            {
              AppMethodBeat.i(219447);
              Log.e("MicroMsg.SnsCommentDetailUI", "onDownloadError");
              AppMethodBeat.o(219447);
            }
          });
          bool1 = true;
          break label336;
          if (!localSnsInfo.getUserName().endsWith("@ad"))
          {
            if (localSnsInfo.isAd()) {}
            for (;;)
            {
              try
              {
                com.tencent.mm.kernel.h.aHH();
                localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(localSnsInfo.getUserName());
                if ((localObject2 == null) || (((as)localObject2).ayq() == 0)) {
                  continue;
                }
                com.tencent.mm.pluginsdk.ui.a.b.C((ImageView)localObject1, localSnsInfo.getUserName());
                Log.i("MicroMsg.SnsCommentDetailUI", "has contact before setAvatar, userName=" + localSnsInfo.getUserName());
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.SnsCommentDetailUI", "setAvatar exp=" + localException.toString());
                continue;
              }
              ((SnsAvatarImageView)localObject1).gp(localSnsInfo.getUserName(), 2);
              bool1 = bool2;
              if (Util.isEqual(this.iRj, localSnsInfo.getUserName())) {
                break;
              }
              bool1 = bool2;
              break;
              Log.e("MicroMsg.SnsCommentDetailUI", "has no contact before setAvatar, userName=" + localSnsInfo.getUserName());
              continue;
              com.tencent.mm.pluginsdk.ui.a.b.C((ImageView)localObject1, localSnsInfo.getUserName());
            }
          }
          bool1 = true;
          break label336;
        }
      }
      if ((Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(localException.nickname))) {
        localObject1 = localException.nickname;
      }
      label3182:
      label15343:
      for (;;)
      {
        i = 0;
        Object localObject3 = localObject1;
        break;
        label1782:
        if ((localObject8 != null) && (as.bvK(((as)localObject8).getUsername())) && ("3552365301".equals(((as)localObject8).apr())))
        {
          j = ((String)localObject1).length();
          localObject3 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).bR(((as)localObject8).apr(), ((as)localObject8).apq());
          localObject3 = (String)localObject1 + " @" + (String)localObject3;
          i = ((String)localObject3).length();
          ((RelativeLayout)localObject5).setTag(new com.tencent.mm.plugin.sns.data.i((View)localObject5, localSnsInfo.getLocalid()));
          ((RelativeLayout)localObject5).setVisibility(0);
          break;
          k = 2;
          break label599;
          label1914:
          this.KPT.setVisibility(8);
          break label885;
          this.KOI.setText((String)localObject1 + " ");
          localObject1 = com.tencent.mm.pluginsdk.ui.span.t.hmY();
          ((Bundle)localObject1).putInt("ShareScene", 3);
          ((Bundle)localObject1).putString("ShareSceneId", localSnsInfo.getUserName() + "#" + com.tencent.mm.plugin.sns.data.t.Qu(localSnsInfo.field_snsId));
          ((Bundle)localObject1).putLong("CreateTime", localSnsInfo.field_createTime);
          ((Bundle)localObject1).putInt("TimelineEnterSource", 3);
          ((Bundle)localObject1).putInt("SnsContentType", localSnsInfo.field_type);
          if (com.tencent.mm.plugin.sns.ad.timeline.b.c.ag(localSnsInfo.isAd(), this.viewType)) {
            com.tencent.mm.pluginsdk.ui.span.l.a(this.KOI, this.mAdTagClickCallback, localObject1);
          }
          for (;;)
          {
            this.KOI.setVisibility(0);
            com.tencent.mm.plugin.sns.k.g.Kia.fQr().amA();
            localObject1 = com.tencent.mm.plugin.sns.i.a.KeP;
            a.a.a(localSnsInfo, this.KOI);
            break;
            com.tencent.mm.pluginsdk.ui.span.l.a(this.KOI, 2, 2, localObject1);
          }
          ((ViewStub)localObject1).setLayoutResource(i.g.sns_timeline_imagesline_one);
          break label1155;
          ((ViewStub)localObject1).setLayoutResource(i.g.sns_timeline_imagesline1);
          break label1155;
          ((ViewStub)localObject1).setLayoutResource(i.g.sns_timeline_imagesline2);
          break label1155;
          ((ViewStub)localObject1).setLayoutResource(i.g.sns_timeline_imagesline3);
          break label1155;
          ((ViewStub)localObject1).setLayoutResource(i.g.sns_media_sight_item);
          break label1155;
          ((ViewStub)localObject1).setLayoutResource(i.g.sns_hb_reward_item);
          break label1155;
          ((ViewStub)localObject1).setLayoutResource(i.g.sns_finder_media_item);
          break label1155;
          ((ViewStub)localObject1).setLayoutResource(i.g.sns_finder_media_item);
          break label1155;
          ((ViewStub)localObject1).setLayoutResource(i.g.sns_ad_card_layout_item);
          this.KPm = new com.tencent.mm.plugin.sns.ui.c.a.c((TimeLineObject)localObject7, localSnsInfo, this.JIp, this.KPn);
          break label1155;
          ((ViewStub)localObject1).setLayoutResource(i.g.sns_timeline_turn_media);
          this.KPm = new com.tencent.mm.plugin.sns.ui.c.a.i((TimeLineObject)localObject7, localSnsInfo, this.JIp, this.KPn);
          break label1155;
          ((ViewStub)localObject1).setLayoutResource(i.g.sns_timeline_ad_full_card);
          this.KPm = new com.tencent.mm.plugin.sns.ui.c.a.d((TimeLineObject)localObject7, localSnsInfo, this.JIp, this.KPn);
          break label1155;
          ((ViewStub)localObject1).setLayoutResource(i.g.sns_timeline_ad_full_card_new);
          this.KPm = new com.tencent.mm.plugin.sns.ui.c.a.e((TimeLineObject)localObject7, localSnsInfo, this.JIp, this.KPn);
          break label1155;
          ((ViewStub)localObject1).setLayoutResource(i.g.sns_timeline_ad_sphere_card);
          this.KPm = new com.tencent.mm.plugin.sns.ui.c.a.g((TimeLineObject)localObject7, localSnsInfo, this.JIp);
          break label1155;
          ((ViewStub)localObject1).setLayoutResource(i.g.sns_media_sight_item);
          this.KPm = new com.tencent.mm.plugin.sns.ui.c.a.a((TimeLineObject)localObject7, localSnsInfo, this.JIp, this.KPn);
          break label1155;
          ((ViewStub)localObject1).setLayoutResource(i.g.sns_finder_live_time_line_item);
          break label1155;
          ((ViewStub)localObject1).setLayoutResource(i.g.sns_ad_finder_topic_item_content);
          this.KPm = new com.tencent.mm.plugin.sns.ui.c.a.h((TimeLineObject)localObject7, localSnsInfo, this.JIp, this.KPn);
          break label1155;
          ((ViewStub)localObject1).setLayoutResource(i.g.sns_ad_slide_full_card);
          this.KPm = new com.tencent.mm.plugin.sns.ui.c.a.f((TimeLineObject)localObject7, localSnsInfo, this.JIp, this.KPn);
          break label1155;
          if (!(this.KPm instanceof com.tencent.mm.plugin.sns.ui.c.a.d)) {
            break label1236;
          }
          ((com.tencent.mm.plugin.sns.ui.c.a.d)this.KPm).h(this.KPA);
          break label1236;
          ((ViewStub)localObject1).setVisibility(8);
          break label1241;
          i = bg.KUp[this.viewType];
          break label1344;
          this.KPQ.setImageViewWidth(this.KPi);
          localObject1 = new LinkedList();
          float f2;
          float f1;
          Object localObject6;
          if ((localSnsInfo.isAd()) && (this.viewType == 2))
          {
            localObject4 = localSnsInfo.getAdXml();
            this.KPQ.agW(0).setScaleType(QImageView.a.Ydm);
            if ((localObject4 != null) && (!((ADXml)localObject4).isCardAd()) && (((ADXml)localObject4).adMediaDisplayWidth > 0.0F) && (((ADXml)localObject4).adMediaDisplayHeight > 0.0F))
            {
              f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((ADXml)localObject4).adMediaDisplayWidth, 1, ((ADXml)localObject4).adBasicRemWidth, ((ADXml)localObject4).adBasicRootFontSize);
              f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((ADXml)localObject4).adMediaDisplayHeight, 1, ((ADXml)localObject4).adBasicRemWidth, ((ADXml)localObject4).adBasicRootFontSize);
              if (((ADXml)localObject4).adMediaDisplayMode != 0) {
                break label4389;
              }
              float f3 = f1;
              f1 = f2;
              if (f2 >= k - com.tencent.mm.ci.a.aY(this, i.d.sns_avatar_size) - com.tencent.mm.ci.a.aY(this, i.d.SmallestPadding) - getResources().getDimensionPixelSize(i.d.NormalPadding) - getResources().getDimensionPixelSize(i.d.NormalPadding))
              {
                f1 = k - com.tencent.mm.ci.a.aY(this, i.d.sns_avatar_size) - com.tencent.mm.ci.a.aY(this, i.d.SmallestPadding) - getResources().getDimensionPixelSize(i.d.NormalPadding) - getResources().getDimensionPixelSize(i.d.NormalPadding);
                f3 = (int)(((ADXml)localObject4).adMediaDisplayHeight * f1 / ((ADXml)localObject4).adMediaDisplayWidth);
              }
              localObject5 = new cvv();
              ((cvv)localObject5).TEu = f1;
              ((cvv)localObject5).TEv = f3;
              ((cvv)localObject5).TEw = (((cvv)localObject5).TEu * ((cvv)localObject5).TEv);
              ((LinkedList)localObject1).add(localObject5);
            }
            if ((com.tencent.mm.plugin.sns.data.m.b(localSnsInfo, getSource())) && (!com.tencent.mm.plugin.sns.data.m.t(localSnsInfo))) {
              a(this.KPQ);
            }
            if (!Util.isNullOrNil(((ADXml)localObject4).adMediaIconUrl))
            {
              localObject5 = this.KPQ;
              localObject6 = this.KPQ.agW(0);
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", ((ADXml)localObject4).adMediaIconUrl, new f.a()
              {
                public final void aYs(String paramAnonymousString)
                {
                  AppMethodBeat.i(248563);
                  MaskImageView localMaskImageView = (MaskImageView)this.KQc.findViewById(i.f.media_icon);
                  if (localMaskImageView != null)
                  {
                    localMaskImageView.setVisibility(0);
                    localMaskImageView.setImageBitmap(BitmapUtil.decodeFile(paramAnonymousString));
                    float f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.KQd.adMediaIconWidth, 1, this.KQd.adBasicRemWidth, this.KQd.adBasicRootFontSize);
                    float f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.KQd.adMediaIconHeight, 1, this.KQd.adBasicRemWidth, this.KQd.adBasicRootFontSize);
                    float f3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.KQd.adMediaIconPaddingRight, 1, this.KQd.adBasicRemWidth, this.KQd.adBasicRootFontSize);
                    float f4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.KQd.adMediaIconPaddingBottom, 1, this.KQd.adBasicRemWidth, this.KQd.adBasicRootFontSize);
                    paramAnonymousString = new FrameLayout.LayoutParams((int)f1, (int)f2);
                    paramAnonymousString.setMargins((int)(this.KQe.getRight() - f3 - f1), (int)(this.KQe.getBottom() - f4 - f2), 0, 0);
                    localMaskImageView.setLayoutParams(paramAnonymousString);
                  }
                  AppMethodBeat.o(248563);
                }
                
                public final void fJU() {}
                
                public final void fJV() {}
              });
            }
          }
          this.KOH.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
          {
            boolean KQf = false;
            
            public final void onViewAttachedToWindow(View paramAnonymousView)
            {
              AppMethodBeat.i(267108);
              Log.i("MicroMsg.SnsCommentDetailUI", "onViewAttachedToWindow infoHeader %s", new Object[] { Boolean.valueOf(this.KQf) });
              if (!this.KQf)
              {
                AppMethodBeat.o(267108);
                return;
              }
              this.KQf = false;
              if (this.KQg == null)
              {
                AppMethodBeat.o(267108);
                return;
              }
              if (localSnsInfo == null)
              {
                AppMethodBeat.o(267108);
                return;
              }
              if (SnsCommentDetailUI.this.KPQ == null)
              {
                AppMethodBeat.o(267108);
                return;
              }
              paramAnonymousView = SnsCommentDetailUI.F(SnsCommentDetailUI.this);
              PhotosContent localPhotosContent = SnsCommentDetailUI.this.KPQ;
              TimeLineObject localTimeLineObject = this.KQg;
              String str = localSnsInfo.getLocalid();
              SnsCommentDetailUI.D(SnsCommentDetailUI.this);
              paramAnonymousView.a(localPhotosContent, localTimeLineObject, str, SnsCommentDetailUI.this.hashCode(), SnsCommentDetailUI.E(SnsCommentDetailUI.this), -1, localSnsInfo.isSourceExist(32), false, bp.VGo, this.KQh, localSnsInfo.getSnsId(), localSnsInfo);
              SnsCommentDetailUI.b(localSnsInfo, SnsCommentDetailUI.this.KPQ, SnsCommentDetailUI.E(SnsCommentDetailUI.this));
              AppMethodBeat.o(267108);
            }
            
            public final void onViewDetachedFromWindow(View paramAnonymousView)
            {
              AppMethodBeat.i(267109);
              Log.i("MicroMsg.SnsCommentDetailUI", "onViewDetachedFromWindow infoHeader");
              this.KQf = true;
              AppMethodBeat.o(267109);
            }
          });
          this.KOW.a(this.KPQ, (TimeLineObject)localObject7, localSnsInfo.getLocalid(), hashCode(), this.viewType, -1, localSnsInfo.isSourceExist(32), false, bp.VGo, (List)localObject1, localSnsInfo.getSnsId(), localSnsInfo);
          a(localSnsInfo, this.KPQ, this.viewType);
          if ((localSnsInfo.isAd()) && ((this.viewType == 3) || (this.viewType == 4) || (this.viewType == 5)) && (com.tencent.mm.plugin.sns.data.m.b(localSnsInfo, getSource())) && (!com.tencent.mm.plugin.sns.data.m.t(localSnsInfo)))
          {
            i = bg.KUp[this.viewType];
            a(this.KPQ, i);
          }
          label3069:
          label3198:
          Object localObject9;
          label3837:
          Object localObject10;
          for (;;)
          {
            localObject5 = (TextView)this.KOH.findViewById(i.f.album_address);
            if (!localSnsInfo.isAd()) {
              break label14617;
            }
            localObject4 = h(localSnsInfo);
            if (localObject4 == null) {
              break label14607;
            }
            localObject1 = ((ADInfo)localObject4).adActionPOIName;
            localObject4 = ((ADInfo)localObject4).adActionPOILink;
            ((TextView)localObject5).setTag(localSnsInfo.getLocalid());
            if (Util.isNullOrNil((String)localObject1)) {
              break label14607;
            }
            if (!Util.isNullOrNil((String)localObject4)) {
              break label14559;
            }
            ((TextView)localObject5).setVisibility(0);
            ((TextView)localObject5).setText((CharSequence)localObject1);
            ((TextView)localObject5).setClickable(false);
            ((TextView)localObject5).setTextColor(getContext().getResources().getColor(i.c.desc_text_color));
            this.KOH.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(244186);
                SnsCommentDetailUI.e(SnsCommentDetailUI.this).yo(false);
                AppMethodBeat.o(244186);
              }
            });
            ((TextView)localObject5).setOnClickListener(this.JIp.Lpn);
            ((TextView)this.KOH.findViewById(i.f.album_publish_time)).setText(bo.t(getContext(), localSnsInfo.getCreateTime() * 1000L));
            localObject5 = (AsyncTextView)this.KOH.findViewById(i.f.album_ad_tail_desc);
            ((TextView)localObject5).setOnClickListener(this.JIp.Lpr);
            ((TextView)localObject5).setVisibility(8);
            localObject6 = (AsyncTextView)this.KOH.findViewById(i.f.album_ad_at_tail);
            ((TextView)localObject6).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(163113);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
                paramAnonymousView = new SnsAdClick(SnsCommentDetailUI.this.getSource(), 2, localSnsInfo.field_snsId, 24, 0);
                com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, SnsCommentDetailUI.e(SnsCommentDetailUI.this), localSnsInfo, 24);
                com.tencent.mm.plugin.sns.data.t.a(paramAnonymousView);
                localObject = this.jkl.ays();
                paramAnonymousView = (View)localObject;
                if (localSnsInfo.isAd()) {
                  paramAnonymousView = com.tencent.mm.plugin.sns.ui.widget.e.d(localSnsInfo.getAdXml(), (String)localObject);
                }
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentFlag(1);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentHint(paramAnonymousView);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).yX(true);
                SnsCommentDetailUI.G(SnsCommentDetailUI.this).setVisibility(8);
                SnsCommentDetailUI.B(SnsCommentDetailUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(163113);
              }
            });
            ((TextView)localObject6).setVisibility(8);
            if (localSnsInfo.isAd())
            {
              localObject8 = h(localSnsInfo);
              ((TextView)localObject5).setTag(localSnsInfo.getLocalid());
              if (!com.tencent.mm.plugin.sns.ad.timeline.b.e.a((ADInfo)localObject8)) {
                break label14835;
              }
              com.tencent.mm.plugin.sns.ad.timeline.b.e.a((TextView)localObject5, an.D(localSnsInfo), (ADInfo)localObject8);
              break label15174;
              if ((((TextView)localObject5).getVisibility() != 8) && (Util.isNullOrNil(((ADInfo)localObject8).adActionExtTailLink)))
              {
                ((TextView)localObject5).setTextColor(getResources().getColor(i.c.sns_word_color));
                ((TextView)localObject5).setOnClickListener(null);
              }
              if ((localSnsInfo.getTimeLine().ContentObj.Sqs & 0x4) == 0) {
                break label15343;
              }
              ((TextView)localObject6).setTag(localSnsInfo.getLocalid());
              ((TextView)localObject6).setVisibility(0);
              ((TextView)localObject6).setText(String.format("%s%s%s", new Object[] { getContext().getResources().getString(i.j.sns_ad_at_tips1), localObject3, getContext().getResources().getString(i.j.sns_ad_at_tips2) }));
            }
            localObject1 = (WeImageView)this.KOH.findViewById(i.f.album_type_icon);
            if (((TimeLineObject)localObject7).ContentObj.Sqq != 30) {
              break label15353;
            }
            i = 0;
            ((WeImageView)localObject1).setVisibility(i);
            ((WeImageView)localObject1).setIconColor(getResources().getColor(i.c.BW_0_Alpha_0_3));
            localObject4 = (TextView)this.KOH.findViewById(i.f.album_from);
            ((TextView)localObject4).setOnTouchListener(new ah());
            localObject3 = com.tencent.mm.plugin.sns.c.a.mIH.t(this, ((TimeLineObject)localObject7).AppInfo.Id);
            if (((TimeLineObject)localObject7).ContentObj.Sqq != 26) {
              break label15360;
            }
            localObject1 = getString(i.j.favorite);
            bm.a((TimeLineObject)localObject7, this);
            if (!com.tencent.mm.plugin.sns.c.a.mIH.gZ((String)localObject1)) {
              break label16065;
            }
            ((TextView)localObject4).setVisibility(0);
            localObject3 = new SpannableString(getString(i.j.sns_comefrome) + (String)localObject1);
            ((SpannableString)localObject3).setSpan(new a(), 0, ((SpannableString)localObject3).length(), 33);
            ((TextView)localObject4).setText((CharSequence)localObject3, TextView.BufferType.SPANNABLE);
            if ((((TimeLineObject)localObject7).AppInfo == null) || (!com.tencent.mm.pluginsdk.model.app.h.bpU(((TimeLineObject)localObject7).AppInfo.Id)))
            {
              ((TextView)localObject4).setTextColor(getResources().getColor(i.c.sns_word_color));
              ((TextView)localObject4).setOnTouchListener(null);
            }
            ((TextView)localObject4).setTag(localObject7);
            if ((((TimeLineObject)localObject7).ContentObj.Sqq != 1) || (((TimeLineObject)localObject7).ContentObj.yNL == null) || (Util.isNullOrNil((String)localObject1))) {
              break label16075;
            }
            ((TextView)localObject4).setTextColor(getResources().getColor(i.c.sns_link_color));
            ((TextView)localObject4).setOnTouchListener(null);
            ((TextView)localObject4).setTag(localObject7);
            ((TextView)localObject4).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(199127);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
                long l1 = com.tencent.mm.plugin.sns.data.t.aZs(this.KQg.ContentObj.yNL.kwM);
                long l2 = com.tencent.mm.plugin.sns.data.t.aZs(this.KQg.ContentObj.yNL.feedId);
                if ((l1 != 0L) && (l2 != 0L))
                {
                  if (Util.isEqual(z.bdh(), this.KQg.ContentObj.yNL.username))
                  {
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("KEY_PARAMS_SOURCE_TYPE", this.KQg.ContentObj.yNL.sourceType);
                    ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).enterFinderLiveAnchorUI(paramAnonymousView, SnsCommentDetailUI.this, l2, Long.valueOf(l1), this.KQg.ContentObj.yNL.objectNonceId, this.KQg.ContentObj.yNL.desc, "", "", "");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(199127);
                    return;
                  }
                  if (this.KQg.UserName == null)
                  {
                    paramAnonymousView = "";
                    label222:
                    com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkl = paramAnonymousView;
                    com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkm = this.KQg.Id;
                    com.tencent.mm.plugin.expt.hellhound.a.aww("temp_6");
                    paramAnonymousView = (com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class);
                    localObject = this.KQg.ContentObj.yNL.username;
                    if (this.KQg.ContentObj.yNL.liveStatus != 1) {
                      break label437;
                    }
                  }
                  label437:
                  for (int i = 1;; i = 2)
                  {
                    paramAnonymousView.report21053OnClick(l2, l1, (String)localObject, -1, -1, 7L, "temp_6", i, com.tencent.mm.plugin.expt.hellhound.a.b.b.c.deb(), com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkl, com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkm, System.currentTimeMillis(), 1);
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("key_enter_live_param_visitor_enter_scene", 2);
                    ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).enterFinderLiveVisitorUI(paramAnonymousView, SnsCommentDetailUI.this, l2, Long.valueOf(l1), this.KQg.ContentObj.yNL.username, this.KQg.ContentObj.yNL.objectNonceId, this.KQg.ContentObj.yNL.desc, "", "", "", 4, "", 1, ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).getFinderUtilApi().eeK());
                    break;
                    paramAnonymousView = this.KQg.UserName;
                    break label222;
                  }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(199127);
              }
            });
            localObject1 = (TextView)this.KOH.findViewById(i.f.album_del);
            if (!localSnsInfo.getUserName().equals(this.iRj)) {
              break label16167;
            }
            ((TextView)localObject1).setVisibility(0);
            ((TextView)localObject1).setTag(localSnsInfo.getLocalid() + ";" + localSnsInfo.getSnsId());
            ((TextView)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(238127);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                com.tencent.mm.ui.base.h.a(SnsCommentDetailUI.this, i.j.sns_timeline_ui_confirm_del, i.j.app_tip, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(237956);
                    Log.d("MicroMsg.SnsCommentDetailUI", "to del by localId " + SnsCommentDetailUI.j(SnsCommentDetailUI.this));
                    paramAnonymous2DialogInterface = com.tencent.mm.plugin.sns.storage.f.bbl(SnsCommentDetailUI.j(SnsCommentDetailUI.this));
                    if (paramAnonymous2DialogInterface == null)
                    {
                      Log.e("MicroMsg.SnsCommentDetailUI", "try to del item fail can not get snsinfo by localid %s", new Object[] { SnsCommentDetailUI.j(SnsCommentDetailUI.this) });
                      AppMethodBeat.o(237956);
                      return;
                    }
                    if (paramAnonymous2DialogInterface.isAd())
                    {
                      AppMethodBeat.o(237956);
                      return;
                    }
                    Object localObject;
                    if (paramAnonymous2DialogInterface.field_snsId == 0L)
                    {
                      aj.fOI().agJ(paramAnonymous2DialogInterface.localid);
                      localObject = new Intent();
                      ((Intent)localObject).putExtra("sns_gallery_op_id", y.bbI(SnsCommentDetailUI.j(SnsCommentDetailUI.this)));
                      SnsCommentDetailUI.this.setResult(-1, (Intent)localObject);
                      if ((SnsCommentDetailUI.v(SnsCommentDetailUI.this)) && (!paramAnonymous2DialogInterface.isValid())) {
                        ((Intent)localObject).putExtra("sns_gallery_force_finish", true);
                      }
                      localObject = paramAnonymous2DialogInterface.getTimeLine();
                      if (localObject != null) {
                        if (((TimeLineObject)localObject).AppInfo != null) {
                          break label366;
                        }
                      }
                    }
                    label366:
                    for (paramAnonymous2DialogInterface = null;; paramAnonymous2DialogInterface = ((TimeLineObject)localObject).AppInfo.Id)
                    {
                      if ((!Util.isNullOrNil(paramAnonymous2DialogInterface)) && (com.tencent.mm.plugin.sns.c.a.mIH.ha(paramAnonymous2DialogInterface)))
                      {
                        String str = com.tencent.mm.plugin.sns.c.a.mIH.gY(paramAnonymous2DialogInterface);
                        sw localsw = new sw();
                        localsw.fSi.appId = paramAnonymous2DialogInterface;
                        localsw.fSi.fSj = ((TimeLineObject)localObject).UserName;
                        localsw.fSi.pkgName = str;
                        EventCenter.instance.publish(localsw);
                      }
                      SnsCommentDetailUI.this.finish();
                      AppMethodBeat.o(237956);
                      return;
                      aj.fOH().QK(paramAnonymous2DialogInterface.field_snsId);
                      com.tencent.mm.kernel.h.aHH();
                      com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.plugin.sns.model.s(paramAnonymous2DialogInterface.field_snsId, 1), 0);
                      aj.fOI().delete(paramAnonymous2DialogInterface.field_snsId);
                      aj.fON().Rb(paramAnonymous2DialogInterface.field_snsId);
                      com.tencent.mm.plugin.sns.storage.g.Ra(paramAnonymous2DialogInterface.field_snsId);
                      break;
                    }
                  }
                }, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(238127);
              }
            });
            localObject4 = (TextView)this.KOH.findViewById(i.f.with_info_tv);
            localObject5 = an.C(localSnsInfo);
            if (localObject5 != null) {
              break label16177;
            }
            ((TextView)localObject4).setVisibility(8);
            this.KOP = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
            this.KOP.setDuration(150L);
            this.KOQ = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
            this.KOQ.setDuration(150L);
            if (this.KOM == null)
            {
              this.KOM = this.KOH.findViewById(i.f.album_comment_container);
              this.KOM.setVisibility(8);
            }
            this.KOR = ((LinearLayout)this.KOH.findViewById(i.f.album_comment_li));
            this.KOR.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(199829);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                if (!com.tencent.mm.plugin.sns.lucky.a.m.aZC(localSnsInfo.getLocalid()))
                {
                  com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.KPQ.agW(0));
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(199829);
                  return;
                }
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentInfo(null);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentFlag(0);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentHint(SnsCommentDetailUI.this.getString(i.j.sns_ui_comment));
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentInfo(new ejo());
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setToSendTextColor(true);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).yX(true);
                if ((localSnsInfo.isAd()) && ((localSnsInfo.getTimeLine().ContentObj.Sqs & 0x8) != 0)) {
                  SnsCommentDetailUI.c(SnsCommentDetailUI.this).rs(true);
                }
                for (;;)
                {
                  SnsCommentDetailUI.G(SnsCommentDetailUI.this).setVisibility(8);
                  SnsCommentDetailUI.B(SnsCommentDetailUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(199829);
                  return;
                  SnsCommentDetailUI.c(SnsCommentDetailUI.this).rs(false);
                }
              }
            });
            this.KOR.setOnTouchListener(this.KDW);
            this.KOS = ((LinearLayout)this.KOH.findViewById(i.f.album_like_img));
            this.KOS.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(200823);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
                if ((SnsCommentDetailUI.e(SnsCommentDetailUI.this) != null) && (localSnsInfo.getLikeFlag() == 0)) {
                  SnsCommentDetailUI.e(SnsCommentDetailUI.this).Qk(localSnsInfo.field_snsId);
                }
                localObject = SnsCommentDetailUI.this;
                paramAnonymousView = (LinearLayout)paramAnonymousView;
                ImageView localImageView = (ImageView)paramAnonymousView.findViewById(i.f.album_like_icon);
                ScaleAnimation localScaleAnimation = new ScaleAnimation(0.9F, 1.5F, 0.9F, 1.5F, 1, 0.5F, 1, 0.5F);
                localScaleAnimation.setDuration(400L);
                localScaleAnimation.setStartOffset(100L);
                localScaleAnimation.setRepeatCount(0);
                localImageView.clearAnimation();
                localImageView.startAnimation(localScaleAnimation);
                localScaleAnimation.setAnimationListener(new SnsCommentDetailUI.44((SnsCommentDetailUI)localObject, paramAnonymousView));
                SnsCommentDetailUI.H(SnsCommentDetailUI.this);
                com.tencent.mm.plugin.sns.k.g.Kia.fQr().gOH = 3L;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(200823);
              }
            });
            this.KOS.setOnTouchListener(this.KDW);
            localObject1 = (ImageButton)this.KOH.findViewById(i.f.album_show_comment_tv);
            localObject3 = yW(true);
            if ((localObject3 != null) && ((((SnsInfo)localObject3).getLocalPrivate() & 0x1) != 0)) {
              ((ImageButton)localObject1).setVisibility(8);
            }
            if ((localObject3 != null) && (!((SnsInfo)localObject3).isExtFlag())) {
              ((ImageButton)localObject1).setVisibility(8);
            }
            localObject3 = (ImageView)this.KOS.findViewById(i.f.album_like_icon);
            localObject4 = (ImageView)this.KOR.findViewById(i.f.album_comment_icon);
            localObject5 = (TextView)this.KOS.findViewById(i.f.album_like_tv);
            localObject6 = (TextView)this.KOR.findViewById(i.f.album_comment_tv);
            if (this.viewType == 10)
            {
              this.KOH.findViewById(i.f.album_comment_container).setBackgroundResource(i.e.friendactivity_comment_frame_bg_golden);
              ((ImageButton)localObject1).setImageResource(i.e.lucky_friendactivity_comment_icon);
              ((ImageView)localObject3).setImageResource(i.e.lucky_friendactivity_comment_likeicon);
              ((ImageView)localObject4).setImageResource(i.e.lucky_friendactivity_comment_writeicon);
              ((TextView)localObject5).setTextColor(getResources().getColor(i.c.sns_lucky_comment));
              ((TextView)localObject6).setTextColor(getResources().getColor(i.c.sns_lucky_comment));
              this.KOS.setBackgroundResource(i.e.lucky_sns_comment_btn_left);
              this.KOR.setBackgroundResource(i.e.lucky_sns_comment_btn_right);
            }
            ((ImageButton)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(267751);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$47", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                Log.d("MicroMsg.SnsCommentDetailUI", "showComment click" + SnsCommentDetailUI.G(SnsCommentDetailUI.this).getVisibility());
                com.tencent.mm.plugin.sns.ad.i.j.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a(localSnsInfo, true, paramAnonymousView, SnsCommentDetailUI.e(SnsCommentDetailUI.this)));
                paramAnonymousView = localSnsInfo.getTimeLine();
                if ((paramAnonymousView != null) && (paramAnonymousView.ContentObj.Sqq == 21) && (!com.tencent.mm.plugin.sns.lucky.a.m.aZC(localSnsInfo.getLocalid())))
                {
                  com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.KPQ.agW(0));
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$47", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(267751);
                  return;
                }
                if (SnsCommentDetailUI.G(SnsCommentDetailUI.this).getVisibility() == 0) {
                  SnsCommentDetailUI.f(SnsCommentDetailUI.this);
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$47", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(267751);
                  return;
                  SnsCommentDetailUI.G(SnsCommentDetailUI.this).setVisibility(0);
                  SnsCommentDetailUI.G(SnsCommentDetailUI.this).startAnimation(SnsCommentDetailUI.I(SnsCommentDetailUI.this));
                  if (SnsCommentDetailUI.E(SnsCommentDetailUI.this) == 10) {
                    SnsCommentDetailUI.y(SnsCommentDetailUI.this).findViewById(i.f.album_comment_container).setBackgroundResource(i.e.friendactivity_comment_frame_bg_golden);
                  }
                  if (!y.bbJ(SnsCommentDetailUI.m(SnsCommentDetailUI.this)))
                  {
                    SnsCommentDetailUI.this.KOR.setEnabled(false);
                    SnsCommentDetailUI.this.KOS.setEnabled(false);
                    this.KQm.setText(SnsCommentDetailUI.this.getString(i.j.sns_like));
                    this.KQm.setTextColor(SnsCommentDetailUI.this.getResources().getColor(i.c.sns_like_color));
                    this.KQn.setTextColor(SnsCommentDetailUI.this.getResources().getColor(i.c.sns_like_color));
                    if (SnsCommentDetailUI.E(SnsCommentDetailUI.this) == 10) {
                      this.KQo.setImageResource(i.i.friendactivity_comment_likeicon_golden_normal);
                    } else {
                      this.KQo.setImageResource(i.i.friendactivity_comment_likeicon_normal);
                    }
                  }
                  else
                  {
                    SnsCommentDetailUI.this.KOR.setEnabled(true);
                    this.KQo.setImageResource(i.e.friendactivity_comment_likeicon);
                    SnsCommentDetailUI.this.KOS.setEnabled(true);
                    this.KQm.setTextColor(SnsCommentDetailUI.this.getResources().getColor(i.c.white_text_color));
                    this.KQn.setTextColor(SnsCommentDetailUI.this.getResources().getColor(i.c.white_text_color));
                    paramAnonymousView = com.tencent.mm.plugin.sns.storage.f.bbk(SnsCommentDetailUI.m(SnsCommentDetailUI.this));
                    if (SnsCommentDetailUI.E(SnsCommentDetailUI.this) == 10)
                    {
                      this.KQo.setImageResource(i.e.lucky_friendactivity_comment_likeicon);
                      this.KQp.setImageResource(i.e.lucky_friendactivity_comment_writeicon);
                      this.KQm.setTextColor(SnsCommentDetailUI.this.getResources().getColor(i.c.sns_lucky_comment));
                      this.KQn.setTextColor(SnsCommentDetailUI.this.getResources().getColor(i.c.sns_lucky_comment));
                    }
                    for (;;)
                    {
                      if ((paramAnonymousView == null) || (paramAnonymousView.getLikeFlag() != 0)) {
                        break label626;
                      }
                      this.KQm.setText(SnsCommentDetailUI.this.getString(i.j.sns_like));
                      break;
                      this.KQo.setImageResource(i.e.friendactivity_comment_likeicon);
                      this.KQm.setTextColor(SnsCommentDetailUI.this.getResources().getColor(i.c.white_text_color));
                      this.KQn.setTextColor(SnsCommentDetailUI.this.getResources().getColor(i.c.white_text_color));
                    }
                    label626:
                    this.KQm.setText(SnsCommentDetailUI.this.getString(i.j.sns_has_liked));
                  }
                }
              }
            });
            AppMethodBeat.o(98604);
            return true;
            if (((ADXml)localObject4).adMediaDisplayMode == 1)
            {
              i = k - com.tencent.mm.ci.a.aY(this, i.d.sns_avatar_size) - com.tencent.mm.ci.a.aY(this, i.d.sns_avatar_size) - com.tencent.mm.ci.a.aY(this, i.d.SmallestPadding) - com.tencent.mm.ci.a.aY(this, i.d.SmallestPadding) - getResources().getDimensionPixelSize(i.d.NormalPadding) - getResources().getDimensionPixelSize(i.d.NormalPadding);
              j = (int)(i * ((ADXml)localObject4).adMediaDisplayHeight / ((ADXml)localObject4).adMediaDisplayWidth);
              localObject5 = new cvv();
              if (i > 0) {
                f2 = i;
              }
              ((cvv)localObject5).TEu = f2;
              if (j > 0) {
                f1 = j;
              }
              ((cvv)localObject5).TEv = f1;
              ((cvv)localObject5).TEw = (((cvv)localObject5).TEu * ((cvv)localObject5).TEv);
              ((LinkedList)localObject1).add(localObject5);
              break;
            }
            if (((ADXml)localObject4).adMediaDisplayMode != 2) {
              break;
            }
            i = k - com.tencent.mm.ci.a.aY(this, i.d.sns_avatar_size) - com.tencent.mm.ci.a.aY(this, i.d.SmallestPadding) - getResources().getDimensionPixelSize(i.d.NormalPadding) - getResources().getDimensionPixelSize(i.d.NormalPadding);
            j = (int)(i * ((ADXml)localObject4).adMediaDisplayHeight / ((ADXml)localObject4).adMediaDisplayWidth);
            localObject5 = new cvv();
            if (i > 0) {
              f2 = i;
            }
            ((cvv)localObject5).TEu = f2;
            if (j > 0) {
              f1 = j;
            }
            ((cvv)localObject5).TEv = f1;
            ((cvv)localObject5).TEw = (((cvv)localObject5).TEu * ((cvv)localObject5).TEv);
            ((LinkedList)localObject1).add(localObject5);
            break;
            Log.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.viewType + ",stub is " + ((ViewStub)localObject1).toString());
            continue;
            if (this.viewType == 10)
            {
              this.KPQ = ((PhotosContent)findViewById(i.f.hb_content_rl));
              this.KPQ.fUL();
              localObject1 = (TagImageView)this.KPQ.findViewById(i.f.album_img_0);
              this.KPQ.a((TagImageView)localObject1);
              ((TagImageView)localObject1).setOnClickListener(this.JIp.KEA);
              localObject4 = localSnsInfo.getLocalid();
              localObject5 = new ArrayList();
              ((List)localObject5).add(localObject1);
              localObject6 = new be();
              ((be)localObject6).fCM = ((String)localObject4);
              ((be)localObject6).index = 0;
              ((be)localObject6).KRL = ((List)localObject5);
              ((be)localObject6).KOn = true;
              if (localObject1 != null) {
                ((TagImageView)localObject1).setTag(localObject6);
              }
              localObject1 = (TextView)this.KOH.findViewById(i.f.hb_tip);
              if (!z.bcZ().equals(((TimeLineObject)localObject7).UserName))
              {
                localObject4 = an.D(localSnsInfo);
                if ((((SnsObject)localObject4).SnsRedEnvelops != null) && (((SnsObject)localObject4).SnsRedEnvelops.Umy != 0))
                {
                  ((TextView)localObject1).setText(getString(i.j.lucky_sns_reward_numbers, new Object[] { Integer.valueOf(((SnsObject)localObject4).SnsRedEnvelops.Umy) }));
                  ((TextView)localObject1).setVisibility(0);
                }
              }
              for (;;)
              {
                localObject1 = localSnsInfo.getPostInfo();
                if (localObject1 == null) {
                  break label5229;
                }
                if (!z.bcZ().equals(((TimeLineObject)localObject7).UserName)) {
                  break label5057;
                }
                localObject1 = this.KOW;
                localObject4 = this.KPQ;
                localObject5 = localSnsInfo.getLocalid();
                i = hashCode();
                j = this.viewType;
                localSnsInfo.isSourceExist(32);
                ((bg)localObject1).a((PhotosContent)localObject4, (TimeLineObject)localObject7, (String)localObject5, i, j, -1, false, bp.VGo, true);
                break;
                ((TextView)localObject1).setVisibility(8);
                continue;
                ((TextView)localObject1).setVisibility(8);
              }
              if (com.tencent.mm.plugin.sns.lucky.a.m.x(localSnsInfo))
              {
                localObject1 = this.KOW;
                localObject4 = this.KPQ;
                localObject5 = localSnsInfo.getLocalid();
                i = hashCode();
                j = this.viewType;
                localSnsInfo.isSourceExist(32);
                ((bg)localObject1).a((PhotosContent)localObject4, (TimeLineObject)localObject7, (String)localObject5, i, j, -1, false, bp.VGo, false);
              }
              else if (((cvu)localObject1).gbp == 0)
              {
                localObject1 = this.KOW;
                localObject4 = this.KPQ;
                localObject5 = localSnsInfo.getLocalid();
                i = hashCode();
                j = this.viewType;
                localSnsInfo.isSourceExist(32);
                ((bg)localObject1).a((PhotosContent)localObject4, (TimeLineObject)localObject7, (String)localObject5, i, j, -1, false, bp.VGo, true);
              }
              else
              {
                Log.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo.hbStatus is " + ((cvu)localObject1).gbp);
                continue;
                Log.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo is null " + localSnsInfo.getLocalid());
              }
            }
            else if (this.viewType == 19)
            {
              this.KPr = true;
            }
            else if (this.viewType == 9)
            {
              this.KPr = true;
              localObject4 = new av();
              localObject9 = this.KOH;
              localObject5 = ((View)localObject9).findViewById(i.f.chatting_click_area);
              localObject6 = (VideoSightView)((View)localObject9).findViewById(i.f.image);
              ((av)localObject4).KKj = ((View)localObject9);
              ((av)localObject4).KKm = ((View)localObject5);
              ((av)localObject4).JAL = ((ImageView)((View)localObject9).findViewById(i.f.status_btn));
              ((av)localObject4).KKn = ((MMPinProgressBtn)((View)localObject9).findViewById(i.f.progress));
              ((av)localObject4).Ktc = ((TextView)((View)localObject9).findViewById(i.f.errorTv));
              ((av)localObject4).KKo = ((TextView)((View)localObject9).findViewById(i.f.endtv));
              ((av)localObject4).KKk = ((VideoSightView)localObject6);
              ((av)localObject4).KKk.setMute(true);
              ((av)localObject4).a((TimeLineObject)localObject7, 0, localSnsInfo.getLocalid(), localSnsInfo.isAd());
              ((av)localObject4).Ktc.setVisibility(8);
              ((av)localObject4).KKk.setTagObject(localObject4);
              ((av)localObject4).KKk.setIsAdVideo(localSnsInfo.isAd());
              ((av)localObject4).KKq = 5;
              ((View)localObject5).setTag(localObject4);
              ((av)localObject4).KKm.setOnClickListener(this.JIp.Lpo);
              if (!localSnsInfo.isCardAd())
              {
                this.szq.c((View)localObject5, this.JIp.Lpf, this.JIp.LoP);
                if ((!localSnsInfo.isAd()) || (!com.tencent.mm.plugin.sns.data.m.d((TimeLineObject)localObject7))) {
                  break label6105;
                }
                j = 1;
                i = 0;
                if (localSnsInfo != null) {
                  i = localSnsInfo.getAdXml().verticalVideoDisplayType;
                }
                if (i != 1) {
                  break label6086;
                }
                localObject1 = com.tencent.mm.modelsns.o.dc(((av)localObject4).KKk.getUIContext());
                Log.i("MicroMsg.SnsCommentDetailUI", "isVerticalAdVideo=true, snsId=" + localSnsInfo.field_snsId + ", showW=" + ((Pair)localObject1).first + ", showH=" + ((Pair)localObject1).second);
                i = j;
                if (localObject1 != null)
                {
                  if ((((av)localObject4).KKk instanceof SightPlayImageView))
                  {
                    if (localSnsInfo.isAd()) {
                      break label6131;
                    }
                    ((av)localObject4).KKk.setScaleMode(1);
                    ((av)localObject4).KKk.setScaleType(QImageView.a.Ydm);
                  }
                  ((VideoSightView)localObject6).ju(((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue());
                  if ((((av)localObject4).KKk instanceof SightPlayImageView))
                  {
                    if (i == 0) {
                      break label6182;
                    }
                    ((av)localObject4).KKk.fIN();
                  }
                  localObject10 = ((av)localObject4).KKo.getLayoutParams();
                  ((ViewGroup.LayoutParams)localObject10).width = ((Integer)((Pair)localObject1).first).intValue();
                  ((ViewGroup.LayoutParams)localObject10).height = ((Integer)((Pair)localObject1).second).intValue();
                  ((av)localObject4).KKo.setLayoutParams((ViewGroup.LayoutParams)localObject10);
                  localObject9 = (FrameLayout)((View)localObject9).findViewById(i.f.sns_video_container);
                  localObject10 = (FrameLayout.LayoutParams)((FrameLayout)localObject9).getLayoutParams();
                  ((FrameLayout.LayoutParams)localObject10).width = ((Integer)((Pair)localObject1).first).intValue();
                  ((FrameLayout.LayoutParams)localObject10).height = ((Integer)((Pair)localObject1).second).intValue();
                  ((FrameLayout)localObject9).setLayoutParams((ViewGroup.LayoutParams)localObject10);
                }
                if ((((TimeLineObject)localObject7).ContentObj == null) || (((TimeLineObject)localObject7).ContentObj.Sqr.size() <= 0)) {
                  break label6194;
                }
                localObject1 = (cvt)((TimeLineObject)localObject7).ContentObj.Sqr.get(0);
                if ((((TimeLineObject)localObject7).ContentObj == null) || (((TimeLineObject)localObject7).ContentObj.Sqr.size() <= 0)) {
                  break label6198;
                }
                aj.fOF();
                if (com.tencent.mm.plugin.sns.model.g.u((cvt)localObject1)) {
                  break label6303;
                }
                if (!aj.fOF().x((cvt)localObject1)) {
                  break label6200;
                }
                ((av)localObject4).JAL.setVisibility(8);
                ((av)localObject4).KKn.setVisibility(0);
                ((av)localObject4).KKn.hZF();
                ((VideoSightView)localObject6).setTagObject(localObject4);
                aj.fOF().a(localSnsInfo, (cvt)localObject1, (VideoSightView)localObject6, hashCode(), 0, bp.VGo, localSnsInfo.isAd());
                ((VideoSightView)localObject6).start();
                ((View)localObject5).setTag(localObject4);
                if (this.KPn == null) {
                  continue;
                }
                if (!localSnsInfo.isAd()) {
                  break label6587;
                }
                if (aj.fOF().B(localSnsInfo) != 5) {
                  break label6581;
                }
                bool1 = true;
              }
              for (;;)
              {
                this.KPn.J(localSnsInfo.field_snsId, bool1);
                break;
                this.szq.c((View)localObject5, this.JIp.Lph, this.JIp.LoP);
                break label5532;
                localObject1 = com.tencent.mm.modelsns.o.a((TimeLineObject)localObject7, ((av)localObject4).KKk.getUIContext(), false);
                break label5588;
                localObject1 = com.tencent.mm.modelsns.o.a((TimeLineObject)localObject7, ((av)localObject4).KKk.getUIContext(), localSnsInfo.isAd());
                i = 0;
                break label5647;
                if (i != 0)
                {
                  ((av)localObject4).KKk.setScaleMode(1);
                  ((av)localObject4).KKk.setScaleType(QImageView.a.Ydm);
                  break label5691;
                }
                ((av)localObject4).KKk.setScaleMode(0);
                ((av)localObject4).KKk.setScaleType(QImageView.a.Ydh);
                break label5691;
                ((av)localObject4).KKk.setDrawWidthAndHeightFix(false);
                break label5742;
                localObject1 = null;
                break label5895;
                break;
                if ((localSnsInfo.isAd()) && (aj.fOF().B(localSnsInfo) == 5))
                {
                  aj.fOF().B((cvt)localObject1);
                  ((av)localObject4).JAL.setVisibility(8);
                  ((av)localObject4).KKn.setVisibility(0);
                  ((av)localObject4).KKn.hZF();
                  break label5967;
                }
                aj.fOF().z((cvt)localObject1);
                ((av)localObject4).JAL.setVisibility(0);
                ((av)localObject4).KKn.setVisibility(8);
                ((av)localObject4).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this, i.i.shortvideo_play_btn));
                break label5967;
                if (aj.fOF().v((cvt)localObject1))
                {
                  ((av)localObject4).JAL.setVisibility(0);
                  ((av)localObject4).KKn.setVisibility(8);
                  ((av)localObject4).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this, i.i.shortvideo_play_btn));
                }
                for (;;)
                {
                  if (!((av)localObject4).KKk.fIO()) {
                    break label6579;
                  }
                  Log.d("MicroMsg.SnsCommentDetailUI", "play video error " + ((cvt)localObject1).Id + " " + ((cvt)localObject1).Url + " " + ((cvt)localObject1).TDF);
                  aj.fOF().z((cvt)localObject1);
                  ((av)localObject4).JAL.setVisibility(0);
                  ((av)localObject4).KKn.setVisibility(8);
                  ((av)localObject4).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this, i.i.shortvideo_play_btn));
                  break;
                  if (aj.fOF().w((cvt)localObject1))
                  {
                    ((av)localObject4).JAL.setVisibility(8);
                    ((av)localObject4).KKn.setVisibility(8);
                  }
                  else if ((localSnsInfo.isAd()) && (aj.fOF().B(localSnsInfo) <= 5))
                  {
                    ((av)localObject4).JAL.setVisibility(8);
                    ((av)localObject4).KKn.setVisibility(8);
                  }
                  else
                  {
                    aj.fOF().z((cvt)localObject1);
                    ((av)localObject4).JAL.setVisibility(0);
                    ((av)localObject4).KKn.setVisibility(8);
                    ((av)localObject4).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this, i.i.shortvideo_play_btn));
                  }
                }
                break label5967;
                bool1 = false;
                continue;
                if (aj.fOF().A(localSnsInfo) == 5) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
              }
            }
            else
            {
              if (this.viewType != 0) {
                break label7028;
              }
              localObject1 = (LinearLayout)this.KOH.findViewById(i.f.sns_meida_frame);
              localObject4 = ahe(i.g.sns_media_sub_item);
              if (!this.KPN)
              {
                ((LinearLayout)localObject1).removeView(this.KPQ);
                ((LinearLayout)localObject1).addView((View)localObject4, 3);
                if (((LinearLayout)localObject4).getLayoutParams() == null) {
                  break label7003;
                }
              }
              for (localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject4).getLayoutParams());; localObject1 = new LinearLayout.LayoutParams(-1, -2))
              {
                ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.ci.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                ((LinearLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject1);
                if (((TimeLineObject)localObject7).ContentObj.Sqr.isEmpty()) {
                  break label7018;
                }
                localObject5 = (cvt)((TimeLineObject)localObject7).ContentObj.Sqr.get(0);
                localObject1 = (MMImageView)((LinearLayout)localObject4).findViewById(i.f.image_left);
                aj.fOF().a((cvt)localObject5, (View)localObject1, i.i.app_attach_file_icon_music, hashCode(), bp.VGo);
                this.KPa = ((ImageView)((LinearLayout)localObject4).findViewById(i.f.state));
                this.KPa.setOnTouchListener(this.KDW);
                this.fMd = ((TimeLineObject)localObject7).Id;
                fWf();
                bool1 = getIntent().getBooleanExtra("SNS_FROM_MUSIC_ITEM", false);
                ((MMImageView)localObject1).setTag(new s((TimeLineObject)localObject7, this.KOX, bool1));
                ((MMImageView)localObject1).setOnClickListener(this.KPg.Lfs);
                localObject6 = ((cvt)localObject5).CMB;
                if (!Util.isNullOrNil((String)localObject6)) {
                  ((TextView)((LinearLayout)localObject4).findViewById(i.f.righttext)).setText((CharSequence)localObject6);
                }
                localObject5 = ((cvt)localObject5).fwr;
                if (!Util.isNullOrNil((String)localObject5)) {
                  ((TextView)((LinearLayout)localObject4).findViewById(i.f.titletext)).setText(new SpannableString((CharSequence)localObject5), TextView.BufferType.SPANNABLE);
                }
                ((LinearLayout)localObject4).setTag(new s((TimeLineObject)localObject7, this.KOX));
                this.szq.c((View)localObject4, this.JIp.Lpe, this.JIp.LoP);
                ((LinearLayout)localObject4).setOnClickListener(this.KPg.KWe);
                com.tencent.mm.plugin.sns.data.t.b((View)localObject1, this);
                break;
              }
              ((LinearLayout)localObject4).setVisibility(8);
            }
          }
          Object localObject11;
          View localView;
          MMRoundCornerImageView localMMRoundCornerImageView;
          TextView localTextView1;
          TextView localTextView2;
          if (this.viewType == 24)
          {
            localObject1 = (LinearLayout)this.KOH.findViewById(i.f.sns_meida_frame);
            localObject11 = ahe(i.g.sns_media_music_item);
            if (!this.KPN)
            {
              ((LinearLayout)localObject1).removeView(this.KPQ);
              ((LinearLayout)localObject1).addView((View)localObject11, 3);
              if (((LinearLayout)localObject11).getLayoutParams() != null)
              {
                localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject11).getLayoutParams());
                ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.ci.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                ((LinearLayout)localObject11).setLayoutParams((ViewGroup.LayoutParams)localObject1);
              }
            }
            else
            {
              this.fMd = ((TimeLineObject)localObject7).Id;
              localObject1 = (RoundCornerRelativeLayout)((LinearLayout)localObject11).findViewById(i.f.round_corner_rl);
              ((RoundCornerRelativeLayout)localObject1).setRadius(com.tencent.mm.ci.a.fromDPToPix(getContext(), 4));
              localView = ((RoundCornerRelativeLayout)localObject1).findViewById(i.f.blur_bg_view);
              localObject9 = ((RoundCornerRelativeLayout)localObject1).findViewById(i.f.music_container);
              if (!com.tencent.mm.ui.ar.isDarkMode()) {
                break label7921;
              }
              ((View)localObject9).setBackgroundResource(i.e.sns_music_mv_dark_gradient_bg);
              localMMRoundCornerImageView = (MMRoundCornerImageView)((View)localObject9).findViewById(i.f.chatting_music_cover);
              localTextView1 = (TextView)((View)localObject9).findViewById(i.f.chatting_music_singer_name);
              localObject10 = (TextView)((View)localObject9).findViewById(i.f.chatting_music_song_name);
              localTextView2 = (TextView)((View)localObject9).findViewById(i.f.chatting_music_mv_info);
              this.KPb = ((WeImageView)((View)localObject9).findViewById(i.f.chatting_music_media_icon));
              this.KPb.setOnTouchListener(this.KDW);
              localObject1 = "";
              localObject6 = null;
              localObject5 = localObject6;
              localObject4 = localObject1;
              if (localObject7 != null)
              {
                localObject5 = localObject6;
                localObject4 = localObject1;
                if (((TimeLineObject)localObject7).ContentObj != null) {
                  if (((TimeLineObject)localObject7).ContentObj.Sqr.isEmpty()) {
                    break label16726;
                  }
                }
              }
            }
          }
          for (localObject1 = (cvt)((TimeLineObject)localObject7).ContentObj.Sqr.get(0);; localObject1 = null)
          {
            localObject5 = "";
            if (((TimeLineObject)localObject7).ContentObj.lVY != null)
            {
              localObject5 = ((TimeLineObject)localObject7).ContentObj.lVY.Rux;
              if (!Util.isNullOrNil((String)localObject5))
              {
                Log.i("MicroMsg.SnsCommentDetailUI", "has mvInfo:%s", new Object[] { localObject5 });
                ((ViewGroup.MarginLayoutParams)((TextView)localObject10).getLayoutParams()).topMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 6);
                ((ViewGroup.MarginLayoutParams)localTextView1.getLayoutParams()).topMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 2);
                ((View)localObject9).findViewById(i.f.padding_view).setVisibility(0);
                localTextView2.setVisibility(0);
                localTextView2.setText((String)localObject5 + getContext().getString(i.j.music_mv_info_share_suffix));
              }
            }
            for (localObject4 = ((TimeLineObject)localObject7).ContentObj.lVY.Ruw;; localObject4 = "")
            {
              if (!Util.isNullOrNil((String)localObject4))
              {
                bool1 = true;
                Log.i("MicroMsg.SnsCommentDetailUI", "coverInfo: hasCover:%b, postInfo:%s", new Object[] { Boolean.valueOf(bool1), localObject5 });
                localObject5 = localObject1;
                if (Util.isNullOrNil((String)localObject4)) {
                  break label7999;
                }
                localObject1 = com.tencent.mm.plugin.music.h.b.aSv((String)localObject4);
              }
              for (;;)
              {
                if (!Util.isNullOrNil((String)localObject4))
                {
                  localObject6 = new c.a();
                  ((c.a)localObject6).Wq((String)localObject1);
                  ((c.a)localObject6).bmF();
                  ((c.a)localObject6).bmJ();
                  ((c.a)localObject6).gs(true);
                  ((c.a)localObject6).bmI();
                  ((c.a)localObject6).aw(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 2));
                  localObject6 = ((c.a)localObject6).bmL();
                  com.tencent.mm.ay.q.bml().a((String)localObject4, localMMRoundCornerImageView, (com.tencent.mm.ay.a.a.c)localObject6, new SnsCommentDetailUI.30(this, localView));
                  this.KPb.setPressed(false);
                  fWg();
                  if (localObject5 != null)
                  {
                    localObject4 = ((cvt)localObject5).CMB;
                    if ((((TimeLineObject)localObject7).ContentObj.lVY == null) || (Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.lVY.singerName))) {
                      break label8105;
                    }
                    localTextView1.setVisibility(0);
                    localTextView1.setText(((TimeLineObject)localObject7).ContentObj.lVY.singerName);
                    if (localObject5 == null) {
                      break label8146;
                    }
                    localObject4 = ((cvt)localObject5).fwr;
                    if (Util.isNullOrNil((String)localObject4)) {
                      break label8154;
                    }
                    ((TextView)localObject10).setVisibility(0);
                    ((TextView)localObject10).setText(new SpannableString((CharSequence)localObject4), TextView.BufferType.SPANNABLE);
                  }
                  for (;;)
                  {
                    if (((TimeLineObject)localObject7).ContentObj.lVY == null) {
                      ((TimeLineObject)localObject7).ContentObj.lVY = new dbr();
                    }
                    ((TimeLineObject)localObject7).ContentObj.lVY.lVZ = ((String)localObject1);
                    localObject1 = new s((TimeLineObject)localObject7, this.KOX);
                    ((s)localObject1).lnm = 2;
                    this.KPb.setTag(localObject1);
                    this.KPb.setOnClickListener(this.KPg.Lft);
                    ((View)localObject9).setTag(localObject1);
                    this.szq.c((View)localObject9, this.JIp.Lpe, this.JIp.LoP);
                    ((View)localObject9).setOnClickListener(this.KPg.Lfh);
                    break;
                    localObject1 = new LinearLayout.LayoutParams(-1, -2);
                    break label7107;
                    ((View)localObject9).setBackgroundResource(i.e.sns_music_mv_light_gradient_bg);
                    break label7210;
                    ((ViewGroup.MarginLayoutParams)((TextView)localObject10).getLayoutParams()).topMargin = 0;
                    ((ViewGroup.MarginLayoutParams)localTextView1.getLayoutParams()).topMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 4);
                    ((View)localObject9).findViewById(i.f.padding_view).setVisibility(8);
                    localTextView2.setText("");
                    localTextView2.setVisibility(8);
                    break label7499;
                    bool1 = false;
                    break label7523;
                    if (localObject5 == null) {
                      break label16710;
                    }
                    if (!Util.isNullOrNil(((cvt)localObject5).TDF))
                    {
                      localObject4 = ((cvt)localObject5).TDF;
                      localObject1 = com.tencent.mm.plugin.music.h.b.aSv(((cvt)localObject5).TDF);
                      break label7568;
                    }
                    localObject1 = aj.fOx().Re(((cvt)localObject5).fWh);
                    localObject4 = com.tencent.mm.plugin.sns.data.t.aZf(((com.tencent.mm.plugin.sns.storage.q)localObject1).fSW());
                    localObject4 = aq.kD(aj.getAccSnsPath(), ((com.tencent.mm.plugin.sns.storage.q)localObject1).fSW()) + (String)localObject4;
                    localObject1 = localObject4;
                    break label7568;
                    localObject4 = "";
                    break label7685;
                    if (!Util.isNullOrNil((String)localObject4))
                    {
                      localTextView1.setVisibility(0);
                      localTextView1.setText((CharSequence)localObject4);
                      break label7735;
                    }
                    localTextView1.setText("");
                    localTextView1.setVisibility(0);
                    break label7735;
                    localObject4 = "";
                    break label7747;
                    Log.e("MicroMsg.SnsCommentDetailUI", "Not allow title is empty");
                  }
                }
                ((LinearLayout)localObject11).setVisibility(8);
                break;
                if (this.viewType == 13)
                {
                  this.KOI.setVisibility(8);
                  this.KON.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                  break;
                }
                if ((this.viewType == 11) || (com.tencent.mm.plugin.sns.data.m.afz(this.viewType)) || (this.viewType == 15)) {
                  break;
                }
                if (this.viewType == 16)
                {
                  localObject1 = (LinearLayout)this.KOH.findViewById(i.f.sns_meida_frame);
                  localObject5 = ahe(i.g.sns_media_link_item);
                  if (!this.KPN)
                  {
                    ((LinearLayout)localObject1).removeView(this.KPQ);
                    ((LinearLayout)localObject1).addView((View)localObject5, 3);
                    if (((LinearLayout)localObject5).getLayoutParams() != null)
                    {
                      localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject5).getLayoutParams());
                      ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.ci.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                      ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject1);
                    }
                  }
                  else
                  {
                    localObject6 = (MMImageView)((LinearLayout)localObject5).findViewById(i.f.image_left);
                    ((MMImageView)localObject6).setVisibility(0);
                    localObject9 = (TextView)((LinearLayout)localObject5).findViewById(i.f.titletext);
                    if (((TimeLineObject)localObject7).ContentObj.fFJ == null) {
                      break label8821;
                    }
                    Log.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderShareObject not null");
                    if ((!Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.fFJ.nickname)) || (Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.fFJ.desc))) {
                      break label8725;
                    }
                    localObject1 = ((TimeLineObject)localObject7).ContentObj.fFJ.desc;
                  }
                  for (;;)
                  {
                    ((TextView)localObject9).setText(new SpannableString((CharSequence)localObject1), TextView.BufferType.SPANNABLE);
                    ((TextView)localObject9).setMaxLines(2);
                    if (!((TimeLineObject)localObject7).ContentObj.fFJ.mediaList.isEmpty())
                    {
                      localObject1 = new cvt();
                      ((cvt)localObject1).Url = ((bjc)((TimeLineObject)localObject7).ContentObj.fFJ.mediaList.get(0)).thumbUrl;
                      ((cvt)localObject1).TDF = ((bjc)((TimeLineObject)localObject7).ContentObj.fFJ.mediaList.get(0)).thumbUrl;
                      ((cvt)localObject1).rWu = 2;
                      ((cvt)localObject1).TDG = 1;
                      ((cvt)localObject1).TDH = new cvv();
                      ((cvt)localObject1).TlV = 1;
                      ((cvt)localObject1).TDH.TEu = ((bjc)((TimeLineObject)localObject7).ContentObj.fFJ.mediaList.get(0)).width;
                      ((cvt)localObject1).TDH.TEv = ((bjc)((TimeLineObject)localObject7).ContentObj.fFJ.mediaList.get(0)).height;
                      ((cvt)localObject1).Id = localSnsInfo.getSnsId();
                      aj.fOF().b((cvt)localObject1, (View)localObject6, hashCode(), bp.hzh().asH(((TimeLineObject)localObject7).CreateTime));
                    }
                    ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject7, this.KOX));
                    ((LinearLayout)localObject5).setOnClickListener(this.KPg.KWe);
                    break;
                    localObject1 = new LinearLayout.LayoutParams(-1, -2);
                    break label8321;
                    if (!Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.fFJ.desc)) {
                      localObject1 = ((TimeLineObject)localObject7).ContentObj.fFJ.nickname + ": " + ((TimeLineObject)localObject7).ContentObj.fFJ.desc;
                    } else {
                      localObject1 = getString(i.j.sns_share_finder_feed_title, new Object[] { ((TimeLineObject)localObject7).ContentObj.fFJ.nickname });
                    }
                  }
                  if (((TimeLineObject)localObject7).ContentObj.Sqy != null)
                  {
                    Log.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.megaVideoShareObject not null");
                    if ((Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.Sqy.nickname)) && (!Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.Sqy.desc)))
                    {
                      localObject1 = ((TimeLineObject)localObject7).ContentObj.Sqy.desc;
                      ((TextView)localObject9).setText(new SpannableString((CharSequence)localObject1), TextView.BufferType.SPANNABLE);
                      ((TextView)localObject9).setMaxLines(2);
                      if (!((TimeLineObject)localObject7).ContentObj.Sqy.mediaList.isEmpty())
                      {
                        localObject4 = new cvt();
                        if (TextUtils.isEmpty(((cww)((TimeLineObject)localObject7).ContentObj.Sqy.mediaList.get(0)).coverUrl)) {
                          break label9253;
                        }
                      }
                    }
                    for (localObject1 = ((cww)((TimeLineObject)localObject7).ContentObj.Sqy.mediaList.get(0)).coverUrl;; localObject1 = ((cww)((TimeLineObject)localObject7).ContentObj.Sqy.mediaList.get(0)).thumbUrl)
                    {
                      ((cvt)localObject4).Url = ((String)localObject1);
                      ((cvt)localObject4).TDF = ((String)localObject1);
                      ((cvt)localObject4).rWu = 2;
                      ((cvt)localObject4).TDG = 1;
                      ((cvt)localObject4).TDH = new cvv();
                      ((cvt)localObject4).TlV = 1;
                      ((cvt)localObject4).TDH.TEu = ((cww)((TimeLineObject)localObject7).ContentObj.Sqy.mediaList.get(0)).width;
                      ((cvt)localObject4).TDH.TEv = ((cww)((TimeLineObject)localObject7).ContentObj.Sqy.mediaList.get(0)).height;
                      ((cvt)localObject4).Id = localSnsInfo.getSnsId();
                      aj.fOF().b((cvt)localObject4, (View)localObject6, hashCode(), bp.hzh().asH(((TimeLineObject)localObject7).CreateTime));
                      ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject7, this.KOX));
                      ((LinearLayout)localObject5).setOnClickListener(this.KPg.KWe);
                      break;
                      if (!Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.Sqy.desc))
                      {
                        localObject1 = ((TimeLineObject)localObject7).ContentObj.Sqy.nickname + ": " + ((TimeLineObject)localObject7).ContentObj.Sqy.desc;
                        break label8888;
                      }
                      localObject1 = getString(i.j.sns_share_finder_feed_title, new Object[] { ((TimeLineObject)localObject7).ContentObj.Sqy.nickname });
                      break label8888;
                    }
                  }
                  if (((TimeLineObject)localObject7).ContentObj.Sqz != null)
                  {
                    Log.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderShareTopic not null");
                    localObject1 = getString(i.j.app_finder_topic);
                    if (((TimeLineObject)localObject7).ContentObj.Sqz == null) {
                      break label16703;
                    }
                    if ((((TimeLineObject)localObject7).ContentObj.Sqz.wXA != 7) || (((TimeLineObject)localObject7).ContentObj.Sqz.STw == null)) {
                      break label16700;
                    }
                    localObject1 = MMApplicationContext.getContext().getString(i.j.sns_share_finder_activity_card, new Object[] { ((TimeLineObject)localObject7).ContentObj.Sqz.STw.SCS, ((TimeLineObject)localObject7).ContentObj.Sqz.STw.SCR });
                    localObject4 = localObject1;
                    if (!Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.Sqz.desc))
                    {
                      localObject4 = (TextView)((LinearLayout)localObject5).findViewById(i.f.righttext);
                      ((TextView)localObject4).setVisibility(0);
                      ((TextView)localObject4).setText(((TimeLineObject)localObject7).ContentObj.Sqv.desc);
                    }
                  }
                }
                for (localObject4 = localObject1;; localObject4 = localObject1)
                {
                  ((TextView)localObject9).setText(new SpannableString((CharSequence)localObject4), TextView.BufferType.SPANNABLE);
                  ((TextView)localObject9).setMaxLines(2);
                  if (!Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.Sqz.iconUrl))
                  {
                    localObject1 = new cvt();
                    ((cvt)localObject1).Url = ((TimeLineObject)localObject7).ContentObj.Sqz.iconUrl;
                    ((cvt)localObject1).TDF = ((TimeLineObject)localObject7).ContentObj.Sqz.iconUrl;
                    ((cvt)localObject1).rWu = 2;
                    ((cvt)localObject1).TDG = 1;
                    ((cvt)localObject1).TDH = new cvv();
                    ((cvt)localObject1).TlV = 1;
                    ((cvt)localObject1).TDH.TEu = 0.0F;
                    ((cvt)localObject1).TDH.TEv = 0.0F;
                    ((cvt)localObject1).Id = localSnsInfo.getSnsId();
                    ((MMImageView)localObject6).setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).loadImageForSns(((TimeLineObject)localObject7).ContentObj.Sqz.iconUrl, (View)localObject6);
                  }
                  for (;;)
                  {
                    ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject7, this.KOX));
                    ((LinearLayout)localObject5).setOnClickListener(this.KPg.KWe);
                    break;
                    aj.fOF().d((View)localObject6, -1, i.i.icon_filled_activity, hashCode());
                  }
                  if (((TimeLineObject)localObject7).ContentObj.Sqv != null)
                  {
                    Log.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderShareTopic not null");
                    localObject4 = getString(i.j.app_finder_topic);
                    if (((TimeLineObject)localObject7).ContentObj.Sqv != null)
                    {
                      if (((TimeLineObject)localObject7).ContentObj.Sqv.wXA != 1) {
                        break label10008;
                      }
                      localObject1 = "#" + ((TimeLineObject)localObject7).ContentObj.Sqv.topic;
                    }
                    for (;;)
                    {
                      localObject4 = localObject1;
                      if (!Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.Sqv.desc))
                      {
                        localObject4 = (TextView)((LinearLayout)localObject5).findViewById(i.f.righttext);
                        ((TextView)localObject4).setVisibility(0);
                        ((TextView)localObject4).setText(((TimeLineObject)localObject7).ContentObj.Sqv.desc);
                        localObject4 = localObject1;
                      }
                      ((TextView)localObject9).setText(new SpannableString((CharSequence)localObject4), TextView.BufferType.SPANNABLE);
                      ((TextView)localObject9).setMaxLines(2);
                      localObject1 = new cvt();
                      ((cvt)localObject1).Url = ((TimeLineObject)localObject7).ContentObj.Sqv.iconUrl;
                      ((cvt)localObject1).TDF = ((TimeLineObject)localObject7).ContentObj.Sqv.iconUrl;
                      ((cvt)localObject1).rWu = 2;
                      ((cvt)localObject1).TDG = 1;
                      ((cvt)localObject1).TDH = new cvv();
                      ((cvt)localObject1).TlV = 1;
                      ((cvt)localObject1).TDH.TEu = 0.0F;
                      ((cvt)localObject1).TDH.TEv = 0.0F;
                      ((cvt)localObject1).Id = localSnsInfo.getSnsId();
                      aj.fOF().b((cvt)localObject1, (View)localObject6, hashCode(), bp.hzh().asH(((TimeLineObject)localObject7).CreateTime));
                      ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject7, this.KOX));
                      ((LinearLayout)localObject5).setOnClickListener(this.KPg.KWe);
                      break;
                      if ((((TimeLineObject)localObject7).ContentObj.Sqv.wXA == 7) && (((TimeLineObject)localObject7).ContentObj.Sqv.STw != null)) {
                        localObject1 = MMApplicationContext.getContext().getString(i.j.sns_share_finder_activity_card, new Object[] { ((TimeLineObject)localObject7).ContentObj.Sqv.STw.SCS, ((TimeLineObject)localObject7).ContentObj.Sqv.STw.SCR });
                      } else {
                        localObject1 = ((TimeLineObject)localObject7).ContentObj.Sqv.topic;
                      }
                    }
                  }
                  if (((TimeLineObject)localObject7).ContentObj.Sqx != null)
                  {
                    ((TextView)localObject9).setText(new SpannableString(((TimeLineObject)localObject7).ContentObj.Sqx.title), TextView.BufferType.SPANNABLE);
                    ((TextView)localObject9).setMaxLines(2);
                    localObject1 = new cvt();
                    ((cvt)localObject1).Url = ((String)((TimeLineObject)localObject7).ContentObj.Sqx.STk.get(0) + (String)((TimeLineObject)localObject7).ContentObj.Sqx.STl.get(0));
                    ((cvt)localObject1).TDF = ((cvt)localObject1).Url;
                    ((cvt)localObject1).rWu = 2;
                    ((cvt)localObject1).TDG = 1;
                    ((cvt)localObject1).TDH = new cvv();
                    ((cvt)localObject1).TlV = 1;
                    ((cvt)localObject1).TDH.TEu = 0.0F;
                    ((cvt)localObject1).TDH.TEv = 0.0F;
                    ((cvt)localObject1).Id = localSnsInfo.getSnsId();
                    aj.fOF().b((cvt)localObject1, (View)localObject6, hashCode(), bp.hzh().asH(((TimeLineObject)localObject7).CreateTime));
                    ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject7, this.KOX));
                    ((LinearLayout)localObject5).setOnClickListener(this.KPg.KWe);
                    break;
                  }
                  if (((TimeLineObject)localObject7).ContentObj.yNL != null)
                  {
                    Log.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderLiveShareObject not null");
                    if ((Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.yNL.nickName)) && (!Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.yNL.desc))) {
                      localObject1 = ((TimeLineObject)localObject7).ContentObj.yNL.desc;
                    }
                    for (;;)
                    {
                      ((TextView)localObject9).setText(new SpannableString((CharSequence)localObject1), TextView.BufferType.SPANNABLE);
                      ((TextView)localObject9).setMaxLines(2);
                      if (!((TimeLineObject)localObject7).ContentObj.yNL.coverUrl.isEmpty())
                      {
                        localObject1 = new cvt();
                        ((cvt)localObject1).Url = ((TimeLineObject)localObject7).ContentObj.yNL.coverUrl;
                        ((cvt)localObject1).TDF = ((TimeLineObject)localObject7).ContentObj.yNL.coverUrl;
                        ((cvt)localObject1).rWu = 2;
                        ((cvt)localObject1).TDG = 1;
                        ((cvt)localObject1).TDH = new cvv();
                        ((cvt)localObject1).TlV = 1;
                        ((cvt)localObject1).TDH.TEu = ((TimeLineObject)localObject7).ContentObj.yNL.width;
                        ((cvt)localObject1).TDH.TEv = ((TimeLineObject)localObject7).ContentObj.yNL.height;
                        ((cvt)localObject1).Id = localSnsInfo.getSnsId();
                        aj.fOF().b((cvt)localObject1, (View)localObject6, hashCode(), bp.hzh().asH(((TimeLineObject)localObject7).CreateTime));
                      }
                      ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject7, this.KOX));
                      ((LinearLayout)localObject5).setOnClickListener(this.KPg.KWe);
                      break;
                      if (!Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.yNL.desc)) {
                        localObject1 = ((TimeLineObject)localObject7).ContentObj.yNL.nickName + ": " + ((TimeLineObject)localObject7).ContentObj.yNL.desc;
                      } else {
                        localObject1 = getString(i.j.sns_share_finder_feed_title, new Object[] { ((TimeLineObject)localObject7).ContentObj.yNL.nickName });
                      }
                    }
                  }
                  if (((TimeLineObject)localObject7).ContentObj.SqA == null) {
                    break;
                  }
                  Log.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderSharePoi not null");
                  localObject1 = ((TimeLineObject)localObject7).ContentObj.SqA.poiName;
                  if (!Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.SqA.xzN))
                  {
                    localObject4 = (TextView)((LinearLayout)localObject5).findViewById(i.f.righttext);
                    ((TextView)localObject4).setVisibility(0);
                    ((TextView)localObject4).setText(((TimeLineObject)localObject7).ContentObj.SqA.xzN);
                  }
                  ((TextView)localObject9).setText(new SpannableString((CharSequence)localObject1), TextView.BufferType.SPANNABLE);
                  ((TextView)localObject9).setMaxLines(2);
                  if (!Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.SqA.QSw))
                  {
                    localObject1 = new cvt();
                    ((cvt)localObject1).Url = ((TimeLineObject)localObject7).ContentObj.SqA.QSw;
                    ((cvt)localObject1).TDF = ((TimeLineObject)localObject7).ContentObj.SqA.QSw;
                    ((cvt)localObject1).rWu = 2;
                    ((cvt)localObject1).TDG = 1;
                    ((cvt)localObject1).TDH = new cvv();
                    ((cvt)localObject1).TlV = 1;
                    ((cvt)localObject1).TDH.TEu = 0.0F;
                    ((cvt)localObject1).TDH.TEv = 0.0F;
                    ((cvt)localObject1).Id = localSnsInfo.getSnsId();
                    aj.fOF().b((cvt)localObject1, (View)localObject6, hashCode(), bp.hzh().asH(((TimeLineObject)localObject7).CreateTime));
                  }
                  for (;;)
                  {
                    ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject7, this.KOX));
                    ((LinearLayout)localObject5).setOnClickListener(this.KPg.KWe);
                    break;
                    aj.fOF().d((View)localObject6, -1, i.i.icons_outlined_location, hashCode());
                  }
                  if (this.viewType == 17)
                  {
                    localObject1 = (LinearLayout)this.KOH.findViewById(i.f.sns_meida_frame);
                    localObject4 = ahe(i.g.sns_media_link_item);
                    if (!this.KPN)
                    {
                      ((LinearLayout)localObject1).removeView(this.KPQ);
                      ((LinearLayout)localObject1).addView((View)localObject4, 3);
                      if (((LinearLayout)localObject4).getLayoutParams() == null) {
                        break label11468;
                      }
                    }
                    for (localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject4).getLayoutParams());; localObject1 = new LinearLayout.LayoutParams(-1, -2))
                    {
                      ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.ci.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                      ((LinearLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject1);
                      if (((TimeLineObject)localObject7).ContentObj.Sqw == null) {
                        break label11483;
                      }
                      localObject1 = (MMImageView)((LinearLayout)localObject4).findViewById(i.f.image_left);
                      ((MMImageView)localObject1).setVisibility(0);
                      localObject5 = new cvt();
                      ((cvt)localObject5).Url = ((TimeLineObject)localObject7).ContentObj.Sqw.lpK;
                      ((cvt)localObject5).TDF = ((TimeLineObject)localObject7).ContentObj.Sqw.lpK;
                      ((cvt)localObject5).rWu = 2;
                      ((cvt)localObject5).TDG = 1;
                      ((cvt)localObject5).TDH = new cvv();
                      ((cvt)localObject5).TlV = 1;
                      ((cvt)localObject5).TDH.TEu = ((TimeLineObject)localObject7).ContentObj.Sqw.width;
                      ((cvt)localObject5).TDH.TEv = ((TimeLineObject)localObject7).ContentObj.Sqw.height;
                      ((cvt)localObject5).Id = localSnsInfo.getSnsId();
                      aj.fOF().b((cvt)localObject5, (View)localObject1, hashCode(), bp.hzh().asH(((TimeLineObject)localObject7).CreateTime));
                      localObject5 = (ImageView)((LinearLayout)localObject4).findViewById(i.f.state);
                      ((ImageView)localObject5).setVisibility(0);
                      ((ImageView)localObject5).setImageDrawable(au.o(((ImageView)localObject5).getContext(), i.i.icons_outlined_video_call, -1));
                      localObject5 = ((TimeLineObject)localObject7).ContentObj.Sqw.title;
                      if (!Util.isNullOrNil((String)localObject5))
                      {
                        localObject6 = (TextView)((LinearLayout)localObject4).findViewById(i.f.titletext);
                        ((TextView)localObject6).setMaxLines(2);
                        ((TextView)localObject6).setText(new SpannableString((CharSequence)localObject5), TextView.BufferType.SPANNABLE);
                      }
                      ((LinearLayout)localObject4).setTag(new ak((TimeLineObject)localObject7, (View)localObject1, localSnsInfo.getLocalid()));
                      ((LinearLayout)localObject4).setOnClickListener(this.KPg.Lfe);
                      this.szq.c((View)localObject4, this.JIp.Lpk, this.JIp.LoP);
                      com.tencent.mm.plugin.sns.data.t.b((View)localObject1, this);
                      break;
                    }
                    ((LinearLayout)localObject4).setVisibility(8);
                    break;
                  }
                  if ((this.viewType == 18) || (this.viewType == 21))
                  {
                    localObject1 = this.KOH.findViewById(i.f.sns_finder_media_content_rl);
                    localObject4 = (ImageView)this.KOH.findViewById(i.f.sns_finder_media_status_icon);
                    localObject5 = (ImageIndicatorView)this.KOH.findViewById(i.f.sns_finder_media_image_count_indicator);
                    localObject6 = (ImageView)this.KOH.findViewById(i.f.sns_finder_media_thumb);
                    if ((localObject7 != null) && (((TimeLineObject)localObject7).ContentObj != null) && (((TimeLineObject)localObject7).ContentObj.fFJ != null))
                    {
                      localObject9 = ((TimeLineObject)localObject7).ContentObj.fFJ;
                      if (!Util.isNullOrNil(((bje)localObject9).mediaList))
                      {
                        localObject10 = (bjc)((bje)localObject9).mediaList.get(0);
                        if (localObject10 != null)
                        {
                          if (((bje)localObject9).ACQ != 4) {
                            break label11799;
                          }
                          localObject11 = com.tencent.mm.modelsns.o.a((int)((bjc)localObject10).width, (int)((bjc)localObject10).height, this, false);
                          i = ((Integer)((Pair)localObject11).first).intValue();
                          j = ((Integer)((Pair)localObject11).second).intValue();
                          ((View)localObject1).getLayoutParams().width = i;
                          ((View)localObject1).getLayoutParams().height = j;
                          ((View)localObject1).requestLayout();
                          ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).loadImage(((bjc)localObject10).thumbUrl, (ImageView)localObject6);
                        }
                      }
                      if (((bje)localObject9).ACQ == 4)
                      {
                        ((ImageView)localObject4).setVisibility(0);
                        ((ImageIndicatorView)localObject5).setVisibility(8);
                      }
                      for (;;)
                      {
                        ((View)localObject1).setTag(localObject7);
                        ((View)localObject1).setOnClickListener(this.KPg.Lfj);
                        this.szq.c((View)localObject1, this.JIp.Lpl, this.JIp.LoP);
                        break;
                        localObject11 = com.tencent.mm.modelsns.o.a((int)((bjc)localObject10).width, (int)((bjc)localObject10).height, this);
                        i = ((Integer)((Pair)localObject11).first).intValue();
                        j = ((Integer)((Pair)localObject11).second).intValue();
                        ((View)localObject1).getLayoutParams().width = i;
                        ((View)localObject1).getLayoutParams().height = j;
                        ((View)localObject1).requestLayout();
                        break label11711;
                        ((ImageView)localObject4).setVisibility(8);
                        ((ImageIndicatorView)localObject5).setVisibility(8);
                        ((ImageIndicatorView)localObject5).ahH(((bje)localObject9).fCa);
                      }
                    }
                    if ((localObject7 == null) || (((TimeLineObject)localObject7).ContentObj == null) || (((TimeLineObject)localObject7).ContentObj.Sqy == null)) {
                      break;
                    }
                    localObject9 = ((TimeLineObject)localObject7).ContentObj.Sqy;
                    if (!Util.isNullOrNil(((cwx)localObject9).mediaList))
                    {
                      localObject9 = (cww)((cwx)localObject9).mediaList.get(0);
                      if (localObject9 != null)
                      {
                        localObject10 = com.tencent.mm.modelsns.o.a((int)((cww)localObject9).width, (int)((cww)localObject9).height, this, false);
                        i = ((Integer)((Pair)localObject10).first).intValue();
                        j = ((Integer)((Pair)localObject10).second).intValue();
                        ((View)localObject1).getLayoutParams().width = i;
                        ((View)localObject1).getLayoutParams().height = j;
                        ((View)localObject1).requestLayout();
                        if (TextUtils.isEmpty(((cww)localObject9).coverUrl)) {
                          break label12122;
                        }
                        ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).loadImage(((cww)localObject9).coverUrl, (ImageView)localObject6);
                      }
                    }
                    for (;;)
                    {
                      ((ImageView)localObject4).setVisibility(0);
                      ((ImageIndicatorView)localObject5).setVisibility(8);
                      ((View)localObject1).setTag(localObject7);
                      ((View)localObject1).setOnClickListener(this.KPg.Lfj);
                      this.szq.c((View)localObject1, this.JIp.Lpl, this.JIp.LoP);
                      break;
                      ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).loadImage(((cww)localObject9).thumbUrl, (ImageView)localObject6);
                    }
                  }
                  if (this.viewType == 25)
                  {
                    localObject4 = this.KOH.findViewById(i.f.sns_finder_media_content_rl);
                    if ((localObject7 == null) || (((TimeLineObject)localObject7).ContentObj == null) || (((TimeLineObject)localObject7).ContentObj.yNL == null)) {
                      break;
                    }
                    localObject1 = ((TimeLineObject)localObject7).ContentObj.yNL;
                    com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.festival.a.a.class);
                    localObject5 = ao.ib(((View)localObject4).getContext());
                    localObject5 = com.tencent.mm.modelsns.o.a(localObject5[0], localObject5[1], ((View)localObject4).getContext(), false);
                    i = ((Integer)((Pair)localObject5).first).intValue();
                    ((Integer)((Pair)localObject5).second).intValue();
                    localObject5 = (LinearLayout.LayoutParams)((View)localObject4).getLayoutParams();
                    ((LinearLayout.LayoutParams)localObject5).width = i;
                    ((LinearLayout.LayoutParams)localObject5).height = ((int)(i * 3.5F / 3.0F));
                    ((View)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
                    ((View)localObject4).requestLayout();
                    localObject6 = this.KOH.findViewById(i.f.finder_live_icon);
                    localObject9 = this.KOH.findViewById(i.f.finder_live_end_tag);
                    localObject5 = (ImageView)this.KOH.findViewById(i.f.sns_finder_media_thumb);
                    if ((((TimeLineObject)localObject7).ContentObj != null) && (((TimeLineObject)localObject7).ContentObj.yNL != null)) {
                      ((TimeLineObject)localObject7).ContentObj.yNL.liveStatus = 2;
                    }
                    ((View)localObject6).setVisibility(8);
                    ((View)localObject9).setVisibility(0);
                    if (!TextUtils.isEmpty(((bcp)localObject1).coverUrl)) {
                      localObject1 = ((bcp)localObject1).coverUrl;
                    }
                  }
                  for (;;)
                  {
                    ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).getFinderUtilApi().f((ImageView)localObject5, (String)localObject1);
                    ((View)localObject4).setTag(localObject7);
                    ((View)localObject4).setOnClickListener(new SnsCommentDetailUI.31(this));
                    this.szq.c((View)localObject4, this.JIp.Lpl, this.JIp.LoP);
                    break;
                    if (!TextUtils.isEmpty(((bcp)localObject1).headUrl))
                    {
                      localObject1 = ((bcp)localObject1).headUrl;
                      continue;
                      if (this.viewType == 20)
                      {
                        localObject1 = this.KOH.findViewById(i.f.sns_finder_media_content_rl);
                        if ((localObject7 == null) || (((TimeLineObject)localObject7).ContentObj == null) || (((TimeLineObject)localObject7).ContentObj.yNL == null)) {
                          break;
                        }
                        localObject4 = ((TimeLineObject)localObject7).ContentObj.yNL;
                        localObject5 = ao.ib(((View)localObject1).getContext());
                        localObject5 = com.tencent.mm.modelsns.o.a(localObject5[0], localObject5[1], ((View)localObject1).getContext(), false);
                        i = ((Integer)((Pair)localObject5).first).intValue();
                        ((Integer)((Pair)localObject5).second).intValue();
                        localObject5 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
                        ((LinearLayout.LayoutParams)localObject5).width = i;
                        ((LinearLayout.LayoutParams)localObject5).height = ((int)(i * 3.5F / 3.0F));
                        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject5);
                        ((View)localObject1).requestLayout();
                        if (((bcp)localObject4).liveStatus == 1) {
                          ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).loadImage(((bcp)localObject4).coverUrl, (ImageView)this.KOH.findViewById(i.f.sns_finder_media_thumb));
                        }
                        final long l1 = 0L;
                        try
                        {
                          long l2 = Long.parseLong(((bcp)localObject4).kwM);
                          l1 = l2;
                        }
                        catch (NumberFormatException localNumberFormatException)
                        {
                          for (;;)
                          {
                            Log.e("MicroMsg.SnsCommentDetailUI", localNumberFormatException.getMessage());
                          }
                        }
                        localObject4 = new b.d()
                        {
                          public final void a(long paramAnonymousLong, int paramAnonymousInt, Object paramAnonymousObject)
                          {
                            AppMethodBeat.i(262405);
                            paramAnonymousObject = SnsCommentDetailUI.y(SnsCommentDetailUI.this).findViewById(i.f.finder_live_icon);
                            View localView = SnsCommentDetailUI.y(SnsCommentDetailUI.this).findViewById(i.f.finder_live_end_tag);
                            ImageView localImageView = (ImageView)SnsCommentDetailUI.y(SnsCommentDetailUI.this).findViewById(i.f.sns_finder_media_thumb);
                            if (l1 == paramAnonymousLong) {
                              if (paramAnonymousInt == 2)
                              {
                                if ((this.KQg.ContentObj != null) && (this.KQg.ContentObj.yNL != null)) {
                                  this.KQg.ContentObj.yNL.liveStatus = paramAnonymousInt;
                                }
                                paramAnonymousObject.setVisibility(8);
                                localView.setVisibility(0);
                                if (!TextUtils.isEmpty(this.KQk.coverUrl)) {
                                  paramAnonymousObject = this.KQk.coverUrl;
                                }
                              }
                            }
                            for (;;)
                            {
                              ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).getFinderUtilApi().f(localImageView, paramAnonymousObject);
                              AppMethodBeat.o(262405);
                              return;
                              if (!TextUtils.isEmpty(this.KQk.headUrl))
                              {
                                paramAnonymousObject = this.KQk.headUrl;
                                continue;
                                if (paramAnonymousInt == 1)
                                {
                                  if ((this.KQg.ContentObj != null) && (this.KQg.ContentObj.yNL != null)) {
                                    this.KQg.ContentObj.yNL.liveStatus = paramAnonymousInt;
                                  }
                                  paramAnonymousObject.setVisibility(0);
                                  localView.setVisibility(8);
                                }
                                AppMethodBeat.o(262405);
                              }
                              else
                              {
                                paramAnonymousObject = "";
                              }
                            }
                          }
                        };
                        ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).refreshLiveStatus(l1, this, (b.d)localObject4);
                        ((View)localObject1).setTag(localObject7);
                        ((View)localObject1).setOnClickListener(this.KPg.Lfg);
                        this.szq.c((View)localObject1, this.JIp.Lpl, this.JIp.LoP);
                        break;
                      }
                      if (this.viewType == 23)
                      {
                        Log.d("MicroMsg.SnsCommentDetailUI", "this is finder topic card item");
                        break;
                      }
                      if (this.viewType == 26)
                      {
                        Log.d("MicroMsg.SnsCommentDetailUI", "this is slide full card item");
                        break;
                      }
                      localObject1 = (LinearLayout)this.KOH.findViewById(i.f.sns_meida_frame);
                      LinearLayout localLinearLayout = ahe(i.g.sns_media_link_item);
                      localObject6 = (MMImageView)localLinearLayout.findViewById(i.f.image_left);
                      if (!this.KPN)
                      {
                        ((LinearLayout)localObject1).removeView(this.KPQ);
                        ((LinearLayout)localObject1).addView(localLinearLayout, 3);
                        if (localLinearLayout.getLayoutParams() != null)
                        {
                          localObject1 = new LinearLayout.LayoutParams(localLinearLayout.getLayoutParams());
                          ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.ci.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                          localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                        }
                      }
                      else
                      {
                        i = 0;
                        if (!localSnsInfo.isAd()) {
                          break label13396;
                        }
                        if (localSnsInfo.getAdXml().isLinkAd())
                        {
                          i = 1;
                          localLinearLayout.setTag(localSnsInfo);
                          localLinearLayout.setTag(i.f.link_ad_left_iv, localObject6);
                          localLinearLayout.setOnClickListener(this.JIp.LpG);
                        }
                        j = 0;
                      }
                      for (;;)
                      {
                        if (i != 0)
                        {
                          this.szq.c(localLinearLayout, this.JIp.Lpi, this.JIp.LoP);
                          label13051:
                          if (!fWb()) {
                            break label14221;
                          }
                          localObject4 = bm.bcg(((TimeLineObject)localObject7).ContentObj.Url);
                          localObject1 = ((TimeLineObject)localObject7).ContentObj.fwr;
                          if (i != 0) {
                            localObject4 = ((TimeLineObject)localObject7).ContentObj.CMB;
                          }
                          if ((((TimeLineObject)localObject7).ContentObj.Squ == null) || (((TimeLineObject)localObject7).ContentObj.Squ.lls != 1)) {
                            break label16680;
                          }
                          localObject4 = MMApplicationContext.getContext().getString(i.j.mp_pay_content);
                        }
                        for (;;)
                        {
                          localLinearLayout.findViewById(i.f.state).setVisibility(8);
                          if (!((TimeLineObject)localObject7).ContentObj.Sqr.isEmpty())
                          {
                            ((MMImageView)localObject6).setVisibility(0);
                            localObject9 = (cvt)((TimeLineObject)localObject7).ContentObj.Sqr.get(0);
                            if (((TimeLineObject)localObject7).ContentObj.Sqq == 15)
                            {
                              ((ImageView)localLinearLayout.findViewById(i.f.state)).setImageResource(i.e.music_playicon);
                              ((ImageView)localLinearLayout.findViewById(i.f.state)).setVisibility(0);
                              aj.fOF().a((cvt)localObject9, (View)localObject6, i.i.app_attach_file_icon_video, hashCode(), bp.hzh().asH(((TimeLineObject)localObject7).CreateTime));
                              com.tencent.mm.plugin.sns.data.t.b((View)localObject6, this);
                              if (((TimeLineObject)localObject7).ContentObj.Sqq != 15) {
                                break label16677;
                              }
                              localObject4 = "";
                              localObject1 = getString(i.j.sns_folder_sight_title);
                            }
                          }
                          for (;;)
                          {
                            localObject6 = (TextView)localLinearLayout.findViewById(i.f.titletext);
                            if (!Util.isNullOrNil((String)localObject4))
                            {
                              localLinearLayout.findViewById(i.f.righttext).setVisibility(0);
                              ((TextView)localLinearLayout.findViewById(i.f.righttext)).setText((CharSequence)localObject4);
                              ((TextView)localObject6).setMaxLines(1);
                            }
                            for (;;)
                            {
                              if (!Util.isNullOrNil((String)localObject1))
                              {
                                ((TextView)localObject6).setVisibility(0);
                                if (j != 0)
                                {
                                  ((TextView)localObject6).setText(com.tencent.mm.plugin.sns.data.t.a((String)localObject1, getContext(), (TextView)localObject6));
                                  break;
                                  localObject1 = new LinearLayout.LayoutParams(-1, -2);
                                  break label12933;
                                  if (((TimeLineObject)localObject7).ContentObj.Sqq == 9)
                                  {
                                    if (((TimeLineObject)localObject7).ContentObj.Sqr.size() <= 0) {
                                      break label16683;
                                    }
                                    localLinearLayout.setTag(new s((TimeLineObject)localObject7, this.KOX));
                                    localLinearLayout.setOnClickListener(this.KPg.Lfm);
                                    i = 0;
                                    j = 0;
                                    break label13023;
                                  }
                                  if (((TimeLineObject)localObject7).ContentObj.Sqq == 10)
                                  {
                                    if (((TimeLineObject)localObject7).ContentObj.Sqr.size() <= 0) {
                                      break label16683;
                                    }
                                    localLinearLayout.setTag(new s((TimeLineObject)localObject7, this.KOX));
                                    localLinearLayout.setOnClickListener(this.KPg.Lfo);
                                    i = 0;
                                    j = 0;
                                    break label13023;
                                  }
                                  if (((TimeLineObject)localObject7).ContentObj.Sqq == 17)
                                  {
                                    if (((TimeLineObject)localObject7).ContentObj.Sqr.size() <= 0) {
                                      break label16683;
                                    }
                                    localLinearLayout.setTag(new s((TimeLineObject)localObject7, this.KOX));
                                    localLinearLayout.setOnClickListener(this.KPg.Lfp);
                                    i = 0;
                                    j = 0;
                                    break label13023;
                                  }
                                  if (((TimeLineObject)localObject7).ContentObj.Sqq == 22)
                                  {
                                    if (((TimeLineObject)localObject7).ContentObj.Sqr.size() <= 0) {
                                      break label16683;
                                    }
                                    localLinearLayout.setTag(new s((TimeLineObject)localObject7, this.KOX));
                                    localLinearLayout.setOnClickListener(this.KPg.Lfq);
                                    i = 0;
                                    j = 0;
                                    break label13023;
                                  }
                                  if (((TimeLineObject)localObject7).ContentObj.Sqq == 23)
                                  {
                                    if (((TimeLineObject)localObject7).ContentObj.Sqr.size() <= 0) {
                                      break label16683;
                                    }
                                    localLinearLayout.setTag(new s((TimeLineObject)localObject7, this.KOX));
                                    localLinearLayout.setOnClickListener(this.KPg.Lfr);
                                    i = 0;
                                    j = 0;
                                    break label13023;
                                  }
                                  if (((TimeLineObject)localObject7).ContentObj.Sqq == 14)
                                  {
                                    if (((TimeLineObject)localObject7).ContentObj.Sqr.size() <= 0) {
                                      break label16683;
                                    }
                                    localLinearLayout.setTag(new s((TimeLineObject)localObject7, this.KOX));
                                    localLinearLayout.setOnClickListener(this.KPg.Lfn);
                                    i = 0;
                                    j = 0;
                                    break label13023;
                                  }
                                  if (((TimeLineObject)localObject7).ContentObj.Sqq == 12)
                                  {
                                    if (((TimeLineObject)localObject7).ContentObj.Sqr.size() <= 0) {
                                      break label16683;
                                    }
                                    localLinearLayout.setTag(new s((TimeLineObject)localObject7, this.KOX));
                                    localLinearLayout.setOnClickListener(this.KPg.Lfx);
                                    i = 0;
                                    j = 0;
                                    break label13023;
                                  }
                                  if (((TimeLineObject)localObject7).ContentObj.Sqq == 30)
                                  {
                                    localLinearLayout.setTag(new s((TimeLineObject)localObject7, this.KOX));
                                    localLinearLayout.setOnClickListener(this.KPg.Lfv);
                                    i = 0;
                                    j = 0;
                                    break label13023;
                                  }
                                  if (((TimeLineObject)localObject7).ContentObj.Sqq == 13)
                                  {
                                    if (((TimeLineObject)localObject7).ContentObj.Sqr.size() <= 0) {
                                      break label16683;
                                    }
                                    localLinearLayout.setTag(new s((TimeLineObject)localObject7, this.KOX));
                                    localLinearLayout.setOnClickListener(this.KPg.Lfy);
                                    i = 0;
                                    j = 0;
                                    break label13023;
                                  }
                                  if (((TimeLineObject)localObject7).ContentObj.Sqq == 15)
                                  {
                                    if (((TimeLineObject)localObject7).ContentObj.Sqr.size() <= 0) {
                                      break label16683;
                                    }
                                    localLinearLayout.setTag(new s((TimeLineObject)localObject7, this.KOX));
                                    localLinearLayout.setOnClickListener(this.JIp.Lpp);
                                    i = 0;
                                    j = 0;
                                    break label13023;
                                  }
                                  if (((TimeLineObject)localObject7).ContentObj.Sqq == 26)
                                  {
                                    localLinearLayout.setTag(new s((TimeLineObject)localObject7, this.KOX));
                                    localLinearLayout.setOnClickListener(this.KPg.Lfz);
                                    i = 0;
                                    j = 0;
                                    break label13023;
                                  }
                                  if (((TimeLineObject)localObject7).ContentObj.Sqq == 41)
                                  {
                                    localLinearLayout.setTag(new s((TimeLineObject)localObject7, this.KOX));
                                    localLinearLayout.setOnClickListener(this.KPg.LfA);
                                    i = 0;
                                    j = 0;
                                    break label13023;
                                  }
                                  localLinearLayout.setTag(new s((TimeLineObject)localObject7, this.KOX));
                                  localLinearLayout.setOnClickListener(this.KPg.KWe);
                                  if ((((TimeLineObject)localObject7).contentattr & 0x1) <= 0) {
                                    break label16683;
                                  }
                                  i = 0;
                                  j = 1;
                                  break label13023;
                                  this.szq.c(localLinearLayout, this.JIp.Lpe, this.JIp.LoP);
                                  break label13051;
                                  localObject4 = "";
                                  break label13070;
                                  if (((TimeLineObject)localObject7).ContentObj.Sqq == 5)
                                  {
                                    localObject4 = bm.bcg(((cvt)localObject9).Url);
                                    localObject1 = ((cvt)localObject9).fwr;
                                    localLinearLayout.findViewById(i.f.state).setVisibility(0);
                                    aj.fOF().a((cvt)localObject9, (View)localObject6, i.i.app_attach_file_icon_video, hashCode(), bp.VGo);
                                    break label13255;
                                  }
                                  if (((TimeLineObject)localObject7).ContentObj.Sqq == 18)
                                  {
                                    localLinearLayout.findViewById(i.f.state).setVisibility(0);
                                    ((ImageView)localLinearLayout.findViewById(i.f.state)).setImageResource(i.e.video_playicon_normal);
                                    ((MMImageView)localObject6).setVisibility(0);
                                    aj.fOF().a((cvt)localObject9, (View)localObject6, i.i.app_attach_file_icon_video, hashCode(), bp.VGo);
                                    break label13255;
                                  }
                                  aj.fOF().b((cvt)localObject9, (View)localObject6, hashCode(), bp.VGo);
                                  break label13255;
                                  if (((TimeLineObject)localObject7).ContentObj.Sqq == 18)
                                  {
                                    ((ImageView)localLinearLayout.findViewById(i.f.state)).setVisibility(0);
                                    ((ImageView)localLinearLayout.findViewById(i.f.state)).setImageResource(i.e.video_playicon_normal);
                                    ((MMImageView)localObject6).setVisibility(0);
                                    aj.fOF().d((View)localObject6, -1, i.i.app_attach_file_icon_video, hashCode());
                                    break label13255;
                                  }
                                  if (((TimeLineObject)localObject7).ContentObj.Sqq == 26)
                                  {
                                    ((MMImageView)localObject6).setVisibility(0);
                                    aj.fOF().d((View)localObject6, -1, i.i.note_sns_link_default, hashCode());
                                    break label13255;
                                  }
                                  ((MMImageView)localObject6).setVisibility(0);
                                  aj.fOF().d((View)localObject6, -1, i.i.app_attach_file_icon_webpage, hashCode());
                                  break label13255;
                                  localLinearLayout.findViewById(i.f.righttext).setVisibility(8);
                                  ((TextView)localObject6).setMaxLines(2);
                                  continue;
                                }
                                ((TextView)localObject6).setText((CharSequence)localObject1);
                                break;
                              }
                            }
                            ((TextView)localObject6).setVisibility(8);
                            break;
                            localLinearLayout.setVisibility(0);
                            if (Util.isNullOrNil((String)localObject1)) {
                              break label3151;
                            }
                            localLinearLayout.setTextColor(getContext().getResources().getColor(i.c.Link));
                            localLinearLayout.setClickable(true);
                            localLinearLayout.setText((CharSequence)localObject1);
                            break label3182;
                            localLinearLayout.setVisibility(8);
                            break label3182;
                            if (((TimeLineObject)localObject7).Location == null)
                            {
                              localObject1 = null;
                              if (((TimeLineObject)localObject7).Location != null) {
                                break label14688;
                              }
                            }
                            for (localObject4 = null;; localObject4 = ((TimeLineObject)localObject7).Location.poiName)
                            {
                              localLinearLayout.setTag(localSnsInfo.getLocalid());
                              if ((!Util.isNullOrNil((String)localObject1)) || (!Util.isNullOrNil((String)localObject4))) {
                                break label14701;
                              }
                              localLinearLayout.setVisibility(8);
                              break;
                              localObject1 = ((TimeLineObject)localObject7).Location.mVA;
                              break label14628;
                            }
                            localLinearLayout.setVisibility(0);
                            if (!Util.isNullOrNil((String)localObject4))
                            {
                              localLinearLayout.setTextColor(getContext().getResources().getColor(i.c.Link));
                              localLinearLayout.setClickable(true);
                              if ((localSnsInfo.field_snsId == 0L) && (!Util.isNullOrNil((String)localObject1)))
                              {
                                localLinearLayout.setText((String)localObject1 + "·" + (String)localObject4);
                                break label3198;
                              }
                              localLinearLayout.setText((CharSequence)localObject4);
                              break label3198;
                            }
                            localLinearLayout.setText((CharSequence)localObject1);
                            localLinearLayout.setClickable(false);
                            localLinearLayout.setTextColor(getContext().getResources().getColor(i.c.desc_text_color));
                            break label3198;
                            if (((ADInfo)localObject8).adActionExtTailType == ADInfo.ADChainStrengthenDefaultWording)
                            {
                              if (!Util.isNullOrNil(((ADInfo)localObject8).adActionExtTailWording))
                              {
                                localLinearLayout.setText(((ADInfo)localObject8).adActionExtTailWording);
                                localLinearLayout.setVisibility(0);
                                break label3375;
                              }
                              localLinearLayout.setVisibility(8);
                              break label3375;
                            }
                            if (((ADInfo)localObject8).adActionExtTailType != ADInfo.ADChainStrengthenUserInfoFormatWording) {
                              break label3375;
                            }
                            if (!Util.isNullOrNil(((ADInfo)localObject8).adActionExtTailWording))
                            {
                              localObject1 = "";
                              localObject9 = ((ADInfo)localObject8).adActionExtUserList.iterator();
                              if (((Iterator)localObject9).hasNext())
                              {
                                localObject10 = (String)((Iterator)localObject9).next();
                                localObject4 = this.KOY.bwh((String)localObject10);
                                if (localObject4 != null)
                                {
                                  localObject4 = ((com.tencent.mm.contact.d)localObject4).ays();
                                  if (!Util.isNullOrNil((String)localObject4)) {
                                    localObject4 = (String)localObject1 + (String)localObject4;
                                  }
                                }
                                for (;;)
                                {
                                  localObject1 = localObject4;
                                  if (((ADInfo)localObject8).adActionExtUserList.getLast() == localObject10) {
                                    break;
                                  }
                                  localObject1 = (String)localObject4 + ",";
                                  break;
                                  localObject4 = (String)localObject1 + (String)localObject10;
                                  continue;
                                  localObject4 = (String)localObject1 + (String)localObject10;
                                }
                              }
                              localObject4 = String.format(((ADInfo)localObject8).adActionExtTailWording, new Object[] { localObject1 });
                              localLinearLayout.getTextSize();
                              localObject9 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.e(this, (CharSequence)localObject4, 1));
                              ((com.tencent.mm.pluginsdk.ui.span.m)localObject9).a(null, (CharSequence)localObject4);
                              localObject4 = localLinearLayout.getPaint();
                              if (com.tencent.mm.ci.a.H(this, (int)Layout.getDesiredWidth((CharSequence)localObject9, 0, ((com.tencent.mm.pluginsdk.ui.span.m)localObject9).length(), (TextPaint)localObject4)) > this.KPl)
                              {
                                if (((String)localObject1).length() <= 1) {
                                  break label3375;
                                }
                                localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
                                localObject9 = String.format(((ADInfo)localObject8).adActionExtTailWording, new Object[] { (String)localObject1 + "..." });
                                localLinearLayout.getTextSize();
                                localObject10 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.e(this, (CharSequence)localObject9, 1));
                                ((com.tencent.mm.pluginsdk.ui.span.m)localObject10).a(null, (CharSequence)localObject9);
                                i = com.tencent.mm.ci.a.H(this, (int)Layout.getDesiredWidth((CharSequence)localObject10, 0, ((com.tencent.mm.pluginsdk.ui.span.m)localObject10).length(), (TextPaint)localObject4));
                                localLinearLayout.setText((CharSequence)localObject10, TextView.BufferType.SPANNABLE);
                                localLinearLayout.setVisibility(0);
                                if (i > this.KPl) {
                                  break label3374;
                                }
                                break label3375;
                              }
                              localLinearLayout.setText((CharSequence)localObject9, TextView.BufferType.SPANNABLE);
                              localLinearLayout.setVisibility(0);
                              break label3375;
                            }
                            localLinearLayout.setVisibility(8);
                            break label3375;
                            ((TextView)localObject6).setVisibility(8);
                            break label3501;
                            label15353:
                            i = 8;
                            break label3532;
                            if (((TimeLineObject)localObject7).ContentObj.Sqq == 30)
                            {
                              localObject1 = ((TimeLineObject)localObject7).weappInfo.username;
                              localObject1 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW((String)localObject1);
                              if ((localObject1 != null) && (!Util.isNullOrNil(((WxaAttributes)localObject1).field_nickname))) {}
                              for (localObject3 = ((WxaAttributes)localObject1).field_nickname;; localObject3 = getString(i.j.appbrand_app_name))
                              {
                                localObject1 = localObject3;
                                if (((TimeLineObject)localObject7).weappInfo.subType != 1) {
                                  break;
                                }
                                this.KPO.findViewById(i.f.state).setVisibility(0);
                                localObject1 = localObject3;
                                break;
                              }
                            }
                            if (((TimeLineObject)localObject7).ContentObj.Sqq == 28)
                            {
                              localObject3 = getContext().getResources().getString(i.j.finder_app_name);
                              localObject1 = localObject3;
                              if (((TimeLineObject)localObject7).ContentObj.fFJ == null) {
                                break label3622;
                              }
                              localObject1 = localObject3;
                              if (Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.fFJ.nickname)) {
                                break label3622;
                              }
                              localObject1 = (String)localObject3 + " · " + ((TimeLineObject)localObject7).ContentObj.fFJ.nickname;
                              break label3622;
                            }
                            if (((TimeLineObject)localObject7).ContentObj.Sqq == 36)
                            {
                              localObject3 = getContext().getResources().getString(i.j.finder_app_name);
                              localObject1 = localObject3;
                              if (((TimeLineObject)localObject7).ContentObj.Sqy == null) {
                                break label3622;
                              }
                              localObject1 = localObject3;
                              if (Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.Sqy.nickname)) {
                                break label3622;
                              }
                              localObject1 = (String)localObject3 + " · " + ((TimeLineObject)localObject7).ContentObj.Sqy.nickname;
                              break label3622;
                            }
                            if (((TimeLineObject)localObject7).ContentObj.Sqq == 29)
                            {
                              localObject1 = getContext().getResources().getString(i.j.finder_app_name);
                              break label3622;
                            }
                            if (((TimeLineObject)localObject7).ContentObj.Sqq == 38)
                            {
                              localObject1 = getContext().getResources().getString(i.j.finder_app_name);
                              break label3622;
                            }
                            if (((TimeLineObject)localObject7).ContentObj.Sqq == 37)
                            {
                              localObject1 = getContext().getResources().getString(i.j.finder_app_name);
                              break label3622;
                            }
                            if (((TimeLineObject)localObject7).ContentObj.Sqq == 39) {
                              switch (((TimeLineObject)localObject7).ContentObj.loX)
                              {
                              default: 
                                localObject1 = localObject3;
                                break;
                              case 3: 
                              case 100000000: 
                                localObject1 = getContext().getResources().getString(i.j.finder_app_name);
                                break;
                              }
                            }
                            if (localSnsInfo.isAd())
                            {
                              localObject1 = localObject3;
                              if (!com.tencent.mm.plugin.sns.ad.d.l.a(localSnsInfo.getAdXml(), localSnsInfo.getAdInfo())) {
                                break label3622;
                              }
                              localObject1 = localSnsInfo.getAdXml();
                              if ((localObject1 != null) && (((ADXml)localObject1).adActionLinkHidden == 1) && (!((ADXml)localObject1).isCardAd()) && (!((ADXml)localObject1).isFullCardAd()))
                              {
                                j = 0;
                                localObject1 = localSnsInfo.getAdInfo();
                                i = j;
                                if (localObject1 != null) {
                                  if (TextUtils.isEmpty(((ADInfo)localObject1).adActionExtTailWording))
                                  {
                                    i = j;
                                    if (TextUtils.isEmpty(((ADInfo)localObject1).adActionExtTailFormattedWording)) {}
                                  }
                                  else
                                  {
                                    i = 1;
                                  }
                                }
                                if (i == 0)
                                {
                                  localObject1 = getContext().getResources().getString(i.j.finder_app_name);
                                  break label3622;
                                }
                                localObject1 = "";
                                break label3622;
                              }
                              localObject1 = "";
                              break label3622;
                            }
                            localObject1 = localObject3;
                            if (((TimeLineObject)localObject7).ContentObj.Sqq != 1) {
                              break label3622;
                            }
                            localObject1 = localObject3;
                            if (((TimeLineObject)localObject7).ContentObj.yNL == null) {
                              break label3622;
                            }
                            localObject1 = localObject3;
                            if (Util.isNullOrNil(((TimeLineObject)localObject7).ContentObj.yNL.nickName)) {
                              break label3622;
                            }
                            localObject1 = ((TimeLineObject)localObject7).ContentObj.yNL.nickName;
                            break label3622;
                            ((TextView)localObject4).setVisibility(8);
                            break label3763;
                            if (((TimeLineObject)localObject7).ContentObj.Sqq != 28) {
                              break label3837;
                            }
                            ((TextView)localObject4).setTextColor(getResources().getColor(i.c.sns_link_color));
                            ((TextView)localObject4).setOnTouchListener(null);
                            if (this.KOH != null)
                            {
                              localObject1 = (Guideline)this.KOH.findViewById(i.f.sns_finder_media_image_count_indicator_guide_line);
                              if (localObject1 != null) {
                                ((Guideline)localObject1).setGuidelineEnd(0);
                              }
                            }
                            ((TextView)localObject4).setTag(localObject7);
                            ((TextView)localObject4).setOnClickListener(new View.OnClickListener()
                            {
                              public final void onClick(View paramAnonymousView)
                              {
                                AppMethodBeat.i(264750);
                                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                                ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
                                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
                                if (!WeChatBrands.Business.Entries.MomentChannels.checkAvailable(paramAnonymousView.getContext()))
                                {
                                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                  AppMethodBeat.o(264750);
                                  return;
                                }
                                Intent localIntent = new Intent();
                                localIntent.putExtra("key_from_profile_share_scene", 3);
                                localIntent.putExtra("key_enter_profile_type", 8);
                                String str1;
                                String str2;
                                if (this.KQg.ContentObj.fFJ != null) {
                                  if (Util.isNullOrNil(this.KQg.ContentObj.fFJ.username))
                                  {
                                    localIntent.putExtra("finder_username", "");
                                    localIntent.putExtra("key_finder_object_Id", this.KQg.ContentObj.fFJ.objectId);
                                    localIntent.putExtra("key_finder_object_nonce_id_key", this.KQg.ContentObj.fFJ.objectNonceId);
                                    str1 = Util.nullAsNil(((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr());
                                    str2 = Util.nullAsNil(this.KQg.UserName);
                                    localObject = "";
                                    if (this.KQg.ContentObj.fFJ == null) {
                                      break label508;
                                    }
                                    localObject = this.KQg.ContentObj.fFJ.objectId;
                                  }
                                }
                                for (;;)
                                {
                                  String str3 = this.KQg.Id;
                                  localObject = str1 + "," + str2 + "," + (String)localObject + "," + str3;
                                  Log.i("MicroMsg.SnsCommentDetailUI", "report20587, ".concat(String.valueOf(localObject)));
                                  com.tencent.mm.plugin.report.service.h.IzE.kvStat(20587, (String)localObject);
                                  localIntent.putExtra("key_finder_teen_mode_check", true);
                                  localIntent.putExtra("key_finder_teen_mode_scene", 3);
                                  localIntent.putExtra("key_finder_teen_mode_user_name", this.KQg.ContentObj.fFJ.nickname);
                                  localIntent.putExtra("key_finder_teen_mode_user_id", this.KQg.ContentObj.fFJ.username);
                                  ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(4, 2, 32, localIntent);
                                  ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderProfileUI(paramAnonymousView.getContext(), localIntent);
                                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                  AppMethodBeat.o(264750);
                                  return;
                                  localIntent.putExtra("finder_username", this.KQg.ContentObj.fFJ.username);
                                  break;
                                  if (this.KQg.ContentObj.Sqy == null) {
                                    break;
                                  }
                                  localIntent.putExtra("finder_username", "");
                                  localIntent.putExtra("key_finder_object_Id", this.KQg.ContentObj.Sqy.objectId);
                                  localIntent.putExtra("key_finder_object_nonce_id_key", this.KQg.ContentObj.Sqy.objectNonceId);
                                  break;
                                  label508:
                                  if (this.KQg.ContentObj.Sqy != null) {
                                    localObject = this.KQg.ContentObj.Sqy.objectId;
                                  }
                                }
                              }
                            });
                            break label3837;
                            ((TextView)localObject1).setVisibility(8);
                            break label3923;
                            if (localLinearLayout.WithUserList.size() <= 0) {
                              ((TextView)localObject4).setVisibility(8);
                            }
                            for (;;)
                            {
                              if ((localLinearLayout == null) || (this.iRj == null) || (!this.iRj.equals(localLinearLayout.Username)) || (((localLinearLayout.ExtFlag != 3) || (localLinearLayout.BlackList == null)) && ((localLinearLayout.ExtFlag != 5) || (localLinearLayout.GroupUser == null)))) {
                                break label16659;
                              }
                              this.KOH.findViewById(i.f.album_groupid).setVisibility(0);
                              this.KOH.findViewById(i.f.album_groupid).setTag(Integer.valueOf(localSnsInfo.localid));
                              this.KOH.findViewById(i.f.album_groupid).setOnClickListener(new View.OnClickListener()
                              {
                                public final void onClick(View paramAnonymousView)
                                {
                                  AppMethodBeat.i(211779);
                                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                                  localb.bn(paramAnonymousView);
                                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                                  try
                                  {
                                    int i = ((Integer)paramAnonymousView.getTag()).intValue();
                                    paramAnonymousView = new Intent();
                                    paramAnonymousView.putExtra("sns_label_sns_info", i);
                                    com.tencent.mm.plugin.sns.c.a.mIG.s(paramAnonymousView, SnsCommentDetailUI.this);
                                    label74:
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(211779);
                                    return;
                                  }
                                  catch (Exception paramAnonymousView)
                                  {
                                    break label74;
                                  }
                                }
                              });
                              break;
                              if (this.iRj.equals(localLinearLayout.Username))
                              {
                                ((TextView)localObject4).setVisibility(0);
                                i = 0;
                                localObject6 = localLinearLayout.WithUserList.iterator();
                                localObject1 = "";
                                if (((Iterator)localObject6).hasNext())
                                {
                                  localObject7 = (ejo)((Iterator)localObject6).next();
                                  if (i == 0)
                                  {
                                    i = 1;
                                    localObject1 = (String)localObject1 + "  ";
                                    if (((ejo)localObject7).Nickname == null) {
                                      break label16477;
                                    }
                                    localObject3 = new StringBuilder().append((String)localObject1);
                                    localObject1 = ((ejo)localObject7).Nickname;
                                  }
                                  for (;;)
                                  {
                                    localObject1 = (String)localObject1;
                                    break;
                                    localObject1 = (String)localObject1 + ",  ";
                                    break label16407;
                                    localObject8 = this.KOY.RG(((ejo)localObject7).Username);
                                    localObject3 = new StringBuilder().append((String)localObject1);
                                    if (localObject8 == null) {
                                      localObject1 = ((ejo)localObject7).Username;
                                    } else {
                                      localObject1 = ((com.tencent.mm.contact.d)localObject8).ays();
                                    }
                                  }
                                }
                                ((TextView)localObject4).setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, getString(i.j.sns_timeline_ui_with_to, new Object[] { localObject1 }), ((TextView)localObject4).getTextSize()));
                              }
                              else
                              {
                                ((TextView)localObject4).setVisibility(8);
                                localObject1 = localLinearLayout.WithUserList.iterator();
                                if (((Iterator)localObject1).hasNext())
                                {
                                  localObject3 = (ejo)((Iterator)localObject1).next();
                                  if (!this.iRj.equals(((ejo)localObject3).Username)) {
                                    break label16194;
                                  }
                                  ((TextView)localObject4).setVisibility(0);
                                  localObject1 = getString(i.j.sns_timeline_ui_with_you);
                                  ((TextView)localObject4).setVisibility(0);
                                  ((TextView)localObject4).setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, (CharSequence)localObject1, ((TextView)localObject4).getTextSize()));
                                }
                              }
                            }
                            this.KOH.findViewById(i.f.album_groupid).setVisibility(8);
                            break label3957;
                          }
                        }
                        i = 0;
                        j = 0;
                      }
                    }
                    localObject1 = "";
                  }
                  break label9398;
                }
                localObject1 = "";
              }
            }
          }
        }
        label1908:
        label3957:
        i = 0;
        label6131:
        label7028:
        label8821:
        localObject3 = localObject1;
        label7921:
        label14835:
        break;
      }
      label4718:
      label5742:
      bool1 = true;
    }
  }
  
  public int getLayoutId()
  {
    return i.g.sns_comment_detail;
  }
  
  public final int getSource()
  {
    if (this.KPv == 16) {
      return 2;
    }
    return 1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98599);
    setMMTitle(i.j.sns_comment_detial_ui_title);
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(269894);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = SnsCommentDetailUI.a(SnsCommentDetailUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$28", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$28", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(269894);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(223708);
        if (SnsCommentDetailUI.c(SnsCommentDetailUI.this) != null) {
          SnsCommentDetailUI.c(SnsCommentDetailUI.this).yX(false);
        }
        SnsCommentDetailUI.this.finish();
        AppMethodBeat.o(223708);
        return true;
      }
    });
    this.iRj = z.bcZ();
    if (aj.isInValid()) {
      finish();
    }
    final SnsInfo localSnsInfo = yW(true);
    if (localSnsInfo == null)
    {
      Log.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.fLp);
      finish();
      AppMethodBeat.o(98599);
      return;
    }
    Log.i("MicroMsg.SnsCommentDetailUI", "snsId: " + this.fLp + "localId " + this.KOX + "  username:" + localSnsInfo.getUserName());
    Object localObject1 = (TextView)findViewById(i.f.content_collapse_hint);
    int i;
    if (this.KPs)
    {
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(this.KPt);
      if ((y.bbJ(this.fLp)) || (!localSnsInfo.isDieItem())) {
        break label746;
      }
      localObject1 = localSnsInfo.getPostInfo();
      findViewById(i.f.sns_post_again_ll).setVisibility(0);
      localObject2 = (TextView)findViewById(i.f.post_error_tv);
      switch (((cvu)localObject1).TEj)
      {
      default: 
        if (!Util.isNullOrNil(((cvu)localObject1).TEq))
        {
          ((TextView)localObject2).setText(((cvu)localObject1).TEq);
          findViewById(i.f.sns_post_btn).setVisibility(0);
          i = 1;
          label310:
          if (i != 0) {
            findViewById(i.f.sns_post_again_ll).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(232424);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                if (localSnsInfo.isAd())
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(232424);
                  return;
                }
                an.afU(localSnsInfo.localid);
                an.afT(localSnsInfo.localid);
                aj.fOE().fNd();
                paramAnonymousView = new Intent();
                SnsCommentDetailUI.this.setResult(-1, paramAnonymousView);
                if (SnsCommentDetailUI.v(SnsCommentDetailUI.this)) {
                  paramAnonymousView.putExtra("sns_gallery_force_finish", true);
                }
                SnsCommentDetailUI.this.finish();
                SnsCommentDetailUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(232424);
              }
            });
          }
          this.KOL = ((ListView)findViewById(i.f.album_comment_list));
          this.KOL.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193636);
              SnsCommentDetailUI.a(SnsCommentDetailUI.this, SnsCommentDetailUI.a(SnsCommentDetailUI.this).getBottom());
              Log.d("MicroMsg.SnsCommentDetailUI", "listOriginalBottom: " + SnsCommentDetailUI.d(SnsCommentDetailUI.this));
              AppMethodBeat.o(193636);
            }
          });
          this.KOL.setOnScrollListener(new AbsListView.OnScrollListener()
          {
            public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AppMethodBeat.i(234301);
              if (paramAnonymousInt2 > 0) {
                if ((paramAnonymousInt1 == 0) && (!SnsCommentDetailUI.w(SnsCommentDetailUI.this)))
                {
                  SnsCommentDetailUI.b(SnsCommentDetailUI.this, true);
                  if (SnsCommentDetailUI.x(SnsCommentDetailUI.this) != null)
                  {
                    SnsCommentDetailUI.x(SnsCommentDetailUI.this).refreshView();
                    AppMethodBeat.o(234301);
                    return;
                  }
                  if (SnsCommentDetailUI.y(SnsCommentDetailUI.this) != null)
                  {
                    SnsCommentDetailUI.this.fWc();
                    AppMethodBeat.o(234301);
                  }
                }
                else if (paramAnonymousInt1 > 0)
                {
                  SnsCommentDetailUI.b(SnsCommentDetailUI.this, false);
                }
              }
              AppMethodBeat.o(234301);
            }
            
            public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
            {
              AppMethodBeat.i(234303);
              if (paramAnonymousInt == 1)
              {
                SnsCommentDetailUI.this.hideVKB();
                SnsCommentDetailUI.z(SnsCommentDetailUI.this);
              }
              if ((paramAnonymousInt == 0) && (SnsCommentDetailUI.e(SnsCommentDetailUI.this) != null)) {
                SnsCommentDetailUI.e(SnsCommentDetailUI.this).yo(true);
              }
              AppMethodBeat.o(234303);
            }
          });
          localObject1 = yW(false);
          this.KOH = com.tencent.mm.ui.ad.kS(getContext()).inflate(i.g.sns_comment_detail_header, null);
          this.KON = this.KOH.findViewById(i.f.images_keeper_linear_layout);
          this.KOH.setOnClickListener(this.KPK);
          if ((localObject1 == null) || (!((SnsInfo)localObject1).isAd()) || (!((SnsInfo)localObject1).isLongPressGestureAd())) {
            break label763;
          }
          this.KPA = ((FrameLayout)com.tencent.mm.ui.ad.kS(getContext()).inflate(i.g.sns_ad_longpress_gesture_detail_head_container, null));
          this.KPA.addView(this.KOH, 0);
          this.KOL.addHeaderView(this.KPA);
        }
        break;
      }
    }
    for (;;)
    {
      boolean bool = fWc();
      if (bool) {
        break label777;
      }
      Log.i("MicroMsg.SnsCommentDetailUI", "error isOk setheader ".concat(String.valueOf(bool)));
      finish();
      AppMethodBeat.o(98599);
      return;
      ((TextView)localObject1).setVisibility(8);
      break;
      if (!Util.isNullOrNil(((cvu)localObject1).TEq)) {
        ((TextView)localObject2).setText(((cvu)localObject1).TEq);
      }
      for (;;)
      {
        findViewById(i.f.sns_post_btn).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(i.j.sns_post_error_ban_again);
      }
      if (!Util.isNullOrNil(((cvu)localObject1).TEq)) {
        ((TextView)localObject2).setText(((cvu)localObject1).TEq);
      }
      for (;;)
      {
        findViewById(i.f.sns_post_btn).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(i.j.sns_post_error_to_long_again);
      }
      if (!Util.isNullOrNil(((cvu)localObject1).TEq)) {
        ((TextView)localObject2).setText(((cvu)localObject1).TEq);
      }
      for (;;)
      {
        findViewById(i.f.sns_post_btn).setVisibility(8);
        i = 1;
        break;
        ((TextView)localObject2).setText(i.j.sns_post_error_ten_min_again);
      }
      if (localSnsInfo.getTypeFlag() == 28)
      {
        ((TextView)localObject2).setText(i.j.sns_post_finder_media_error);
        findViewById(i.f.sns_post_btn).setVisibility(8);
        i = 0;
        break label310;
      }
      ((TextView)localObject2).setText(i.j.sns_post_error_touch_again);
      findViewById(i.f.sns_post_btn).setVisibility(0);
      i = 1;
      break label310;
      label746:
      findViewById(i.f.sns_post_again_ll).setVisibility(8);
      i = 0;
      break label310;
      label763:
      this.KOL.addHeaderView(this.KOH);
    }
    label777:
    if (localObject1 != null) {
      this.viewType = bm.g((SnsInfo)localObject1, false);
    }
    if ((this.viewType == 10) && (z.bcZ().equals(localSnsInfo.field_userName)))
    {
      this.KOK = new SnsDetailLuckyHeader(this);
      localObject1 = new AbsListView.LayoutParams(-1, -2);
      this.KOK.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.KOK.setOnClickListener(this.KPK);
    }
    this.KOJ = new LinearLayout(getContext());
    localObject1 = new AbsListView.LayoutParams(-1, -2);
    this.KOJ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.KOJ.setOnClickListener(this.KPK);
    BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 2.0F);
    localObject1 = new AbsListView.LayoutParams(-1, 1);
    Object localObject2 = new LinearLayout(getContext());
    ((LinearLayout)localObject2).setBackgroundResource(i.e.sns_divider_line);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.JTg = ((LinearLayout)localObject2);
    f(localSnsInfo, true);
    if (this.KOK != null)
    {
      this.KPp = true;
      this.KOL.addHeaderView(this.KOK);
    }
    localObject2 = an.C(localSnsInfo);
    label1126:
    ejo localejo;
    label1289:
    long l;
    if (localObject2 == null)
    {
      this.KOJ.setVisibility(8);
      this.KOO = new b(new LinkedList(), new LinkedList(), this, localSnsInfo.getLocalid());
      this.KOL.addHeaderView(this.KOJ);
      this.KOL.setAdapter(this.KOO);
      this.KBS = ((SnsCommentFooter)findViewById(i.f.comment_footer));
      if ((localSnsInfo == null) || (localSnsInfo.getTimeLine() == null) || (localSnsInfo.getTimeLine().ContentObj == null) || ((localSnsInfo.getTimeLine().ContentObj.Sqs & 0x80) != 0)) {
        break label1815;
      }
      this.KBS.setFeedEmojiCommentEnable(true);
      this.KBS.setTag(localSnsInfo);
      this.KBS.setOnEditTouchListener(new SnsCommentFooter.a()
      {
        public final void fWh()
        {
          AppMethodBeat.i(270744);
          if (!com.tencent.mm.plugin.sns.lucky.a.m.aZC(localSnsInfo.getLocalid()))
          {
            if ((SnsCommentDetailUI.A(SnsCommentDetailUI.this) != null) && (SnsCommentDetailUI.A(SnsCommentDetailUI.this).isShowing()))
            {
              AppMethodBeat.o(270744);
              return;
            }
            SnsCommentDetailUI.a(SnsCommentDetailUI.this, com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.KPQ.agW(0)));
            AppMethodBeat.o(270744);
            return;
          }
          if ((SnsCommentDetailUI.this.keyboardState() == 1) || (SnsCommentDetailUI.c(SnsCommentDetailUI.this).fWj()))
          {
            AppMethodBeat.o(270744);
            return;
          }
          SnsCommentDetailUI.B(SnsCommentDetailUI.this);
          AppMethodBeat.o(270744);
        }
      });
      this.KBS.setOnSmileyShowListener(new SnsCommentFooter.c()
      {
        public final void onShow()
        {
          AppMethodBeat.i(230846);
          if (SnsCommentDetailUI.c(SnsCommentDetailUI.this).KQL)
          {
            AppMethodBeat.o(230846);
            return;
          }
          SnsCommentDetailUI.B(SnsCommentDetailUI.this);
          AppMethodBeat.o(230846);
        }
      });
      localObject1 = yW(true);
      if ((localObject1 != null) && (!((SnsInfo)localObject1).isExtFlag())) {
        this.KBS.setVisibility(8);
      }
      this.KBS.setAfterEditAction(this.KPJ);
      this.KBS.fWk();
      this.KBS.setOnCommentSendImp(new SnsCommentFooter.b()
      {
        public final void ll(String paramAnonymousString1, String paramAnonymousString2)
        {
          int j = 8;
          AppMethodBeat.i(270549);
          if (!com.tencent.mm.plugin.sns.lucky.a.m.aZC(localSnsInfo.getLocalid()))
          {
            if (SnsCommentDetailUI.this.KPQ.agW(0) != null) {
              com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.KPQ.agW(0));
            }
            AppMethodBeat.o(270549);
            return;
          }
          if (localSnsInfo.isAd()) {}
          for (int i = SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentFlag();; i = 0)
          {
            if (com.tencent.mm.plugin.sns.ui.widget.e.ki(i, 8))
            {
              paramAnonymousString1 = paramAnonymousString1.substring(SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentAtPrefix().length());
              Log.i("MicroMsg.SnsCommentDetailUI", "send atFriend ad detail comment");
              ap.a.a(localSnsInfo, 16, paramAnonymousString1, SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentInfo(), i, SnsCommentDetailUI.this.getSource(), paramAnonymousString2);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setText("");
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).yX(false);
              Log.i("MicroMsg.SnsCommentDetailUI", "comment send imp!");
              com.tencent.mm.plugin.sns.k.g.Kia.fQr().gOG = 3L;
              SnsCommentDetailUI.z(SnsCommentDetailUI.this);
              AppMethodBeat.o(270549);
              return;
            }
            Log.i("MicroMsg.SnsCommentDetailUI", "send detail comment");
            SnsInfo localSnsInfo = localSnsInfo;
            if (localSnsInfo.isAd()) {}
            for (;;)
            {
              ap.a.a(localSnsInfo, j, paramAnonymousString1, SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentInfo(), i, SnsCommentDetailUI.this.getSource(), paramAnonymousString2);
              break;
              j = 2;
            }
          }
        }
      });
      this.KPe = getIntent().getBooleanExtra("INTENT_FROMSUI", false);
      if (this.KPe)
      {
        this.KPf = getIntent().getLongExtra("INTENT_FROMSUI_COMMENTID", 0L);
        if ((this.KPf != 0L) && (this.KOO.commentList != null))
        {
          i = 0;
          if (i < this.KOO.commentList.size())
          {
            localejo = (ejo)this.KOO.commentList.get(i);
            if (localejo.Uln == 0) {
              break label1826;
            }
            l = localejo.Uln;
            label1335:
            if (l != this.KPf) {
              break label1864;
            }
            this.KOL.setSelection(i);
            localObject1 = this.KOY.RG(localejo.Username);
            if (localObject1 == null) {
              break label1836;
            }
            localObject1 = ((com.tencent.mm.contact.d)localObject1).ays();
            label1381:
            this.KBS.KQF = 0;
            this.KBS.fWl();
            this.KBS.setCommentHint(getString(i.j.sns_reply) + (String)localObject1);
            this.KBS.setCommentInfo(localejo);
            if (((SnsObject)localObject2).LikeUserList.size() <= 0) {
              break label1903;
            }
            int j = i + 1;
            i = j;
            if (j > this.KOO.getCount()) {
              i = this.KOO.getCount() - 1;
            }
          }
        }
      }
    }
    label1815:
    label1826:
    label1836:
    label1864:
    label1903:
    for (;;)
    {
      this.KPJ.QB = i;
      if (this.KPe) {
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193761);
            SnsCommentDetailUI.this.hideVKB();
            SnsCommentDetailUI.l(SnsCommentDetailUI.this).bwU = SnsCommentDetailUI.C(SnsCommentDetailUI.this);
            SnsCommentDetailUI.l(SnsCommentDetailUI.this).run();
            AppMethodBeat.o(193761);
          }
        }, 100L);
      }
      this.KPo = ((SnsTranslateResultView)this.KOH.findViewById(i.f.sns_translate_result_view));
      this.KPo.setResultTextSize(((TextView)this.KOH.findViewById(i.f.desc_tv)).getTextSize());
      this.KPo.getResultTextView().setBackgroundResource(i.e.sns_clickable_bg);
      localObject1 = new bi(this.fLp, localSnsInfo.getLocalid(), false, true, 2);
      this.KPo.getResultTextView().setTag(localObject1);
      this.szq.c(this.KPo.getResultTextView(), this.JIp.LoS, this.JIp.LoP);
      if (at.gf(this.fLp, 4))
      {
        localObject1 = at.bal(this.fLp);
        if ((localObject1 != null) && (((at.b)localObject1).lwF))
        {
          this.KPo.setVisibility(0);
          this.KPo.a(null, 1, ((at.b)localObject1).result, ((at.b)localObject1).brand, false);
          AppMethodBeat.o(98599);
          return;
          this.KOT = ((SnsObject)localObject2).LikeUserList;
          p(((SnsObject)localObject2).LikeUserList, ((SnsObject)localObject2).CommentUserList.isEmpty());
          if (this.KOK != null) {
            this.KOK.a(localSnsInfo, this.JIp);
          }
          this.KOO = new b(((SnsObject)localObject2).CommentUserList, ((SnsObject)localObject2).LikeUserList, this, localSnsInfo.getLocalid());
          if (!this.KPw) {
            break;
          }
          com.tencent.mm.plugin.sns.k.g.Kia.fQr().gOE = ((SnsObject)localObject2).CommentUserList.size();
          com.tencent.mm.plugin.sns.k.g.Kia.fQr().gOF = ((SnsObject)localObject2).LikeUserList.size();
          break;
          this.KBS.setFeedEmojiCommentEnable(false);
          break label1126;
          l = localejo.Ulp;
          break label1335;
          if (localejo.Nickname != null)
          {
            localObject1 = localejo.Nickname;
            break label1381;
          }
          localObject1 = localejo.Username;
          break label1381;
          i += 1;
          break label1289;
        }
        this.KPo.setVisibility(8);
        AppMethodBeat.o(98599);
        return;
      }
      this.KPo.setVisibility(8);
      AppMethodBeat.o(98599);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98610);
    Log.i("MicroMsg.SnsCommentDetailUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt1 == 15)
    {
      if ((this.JIp != null) && (this.JIp.LoP != null)) {
        this.JIp.LoP.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      AppMethodBeat.o(98610);
      return;
    }
    if (paramInt1 == 16)
    {
      Log.i("MicroMsg.SnsCommentDetailUI", "REQUEST_CODE_FOR_FULLSCREEN");
      paramIntent = new jg();
      paramIntent.fGx.scene = 1;
      EventCenter.instance.publish(paramIntent);
      AppMethodBeat.o(98610);
      return;
    }
    if (paramInt1 == 2333)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        if (!Util.isNullOrNil(paramIntent))
        {
          paramIntent = paramIntent.split(",");
          if (paramIntent.length > 0)
          {
            this.KBS.iXq.showVKB();
            String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(paramIntent[0]);
            if (!Util.isNullOrNil(str))
            {
              this.KBS.fWl();
              this.KBS.setText("@" + str + " ");
              this.KBS.setCommentAtPrefix("@" + str + " ");
              this.KBS.setCommentInfo(new ejo());
              this.KBS.getCommentInfo().Username = paramIntent[0];
              this.KBS.setCommentFlag(8);
            }
          }
        }
      }
      AppMethodBeat.o(98610);
      return;
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(98610);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(98610);
      return;
      if (paramInt2 == -1)
      {
        paramIntent = managedQuery(paramIntent.getData(), null, null, null, null);
        if (paramIntent.moveToFirst())
        {
          paramIntent = new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(paramIntent.getString(paramIntent.getColumnIndexOrThrow("_id"))))));
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aFh(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98609);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = com.tencent.mm.plugin.sns.storage.f.bbk(this.fLp);
    Object localObject = an.C(paramConfiguration);
    p(((SnsObject)localObject).LikeUserList, ((SnsObject)localObject).CommentUserList.isEmpty());
    if (this.KOK != null) {
      this.KOK.a(paramConfiguration, this.JIp);
    }
    paramConfiguration = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    localObject = new Point();
    ((Point)localObject).x = paramConfiguration.widthPixels;
    ((Point)localObject).y = paramConfiguration.heightPixels;
    aj.k((Point)localObject);
    if (this.KPQ != null)
    {
      this.KPi = aj.fOV();
      this.KPQ.setImageViewWidth(this.KPi);
    }
    AppMethodBeat.o(98609);
  }
  
  /* Error */
  public void onCreate(final Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 3910
    //   3: invokestatic 270	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 3915	com/tencent/mm/pluginsdk/h:r	(Lcom/tencent/mm/ui/MMActivity;)V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 3917	com/tencent/mm/ui/report/MMSecDataActivity:onCreate	(Landroid/os/Bundle;)V
    //   15: aload_0
    //   16: ldc_w 3919
    //   19: invokestatic 3088	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   22: checkcast 3919	com/tencent/mm/plugin/story/api/e
    //   25: invokeinterface 3923 1 0
    //   30: getstatic 3929	com/tencent/mm/plugin/story/api/f$a:LEw	Lcom/tencent/mm/plugin/story/api/f$a;
    //   33: invokeinterface 3934 2 0
    //   38: putfield 358	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:JXf	Z
    //   41: aload_0
    //   42: ldc_w 3919
    //   45: invokestatic 3088	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   48: checkcast 3919	com/tencent/mm/plugin/story/api/e
    //   51: invokeinterface 3923 1 0
    //   56: getstatic 3937	com/tencent/mm/plugin/story/api/f$a:LEx	Lcom/tencent/mm/plugin/story/api/f$a;
    //   59: invokeinterface 3934 2 0
    //   64: putfield 360	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:JXh	Z
    //   67: aload_0
    //   68: iconst_1
    //   69: invokestatic 3942	com/tencent/mm/ui/c:f	(Landroid/app/Activity;Z)V
    //   72: invokestatic 3946	com/tencent/mm/plugin/sns/model/aj:fOy	()Lcom/tencent/mm/plugin/sns/model/ap$a;
    //   75: iconst_5
    //   76: ldc_w 3948
    //   79: aload_0
    //   80: invokevirtual 3951	com/tencent/mm/plugin/sns/model/ap$a:a	(ILjava/lang/String;Lcom/tencent/mm/plugin/sns/b/j$a;)V
    //   83: iconst_2
    //   84: invokestatic 3956	com/tencent/mm/plugin/sns/ad/timeline/c/b/a:afc	(I)V
    //   87: aload_0
    //   88: aload_0
    //   89: bipush 14
    //   91: invokestatic 3959	com/tencent/mm/ui/aw:fromDPToPix	(Landroid/content/Context;I)I
    //   94: putfield 356	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPx	I
    //   97: aload_0
    //   98: invokestatic 3963	com/tencent/mm/ui/ar:au	(Landroid/content/Context;)Landroid/graphics/Point;
    //   101: astore_1
    //   102: aload_0
    //   103: aload_1
    //   104: getfield 3897	android/graphics/Point:x	I
    //   107: putfield 3965	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenWidth	I
    //   110: aload_0
    //   111: aload_1
    //   112: getfield 3902	android/graphics/Point:y	I
    //   115: putfield 3967	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenHeight	I
    //   118: aload_0
    //   119: invokestatic 3973	java/lang/System:currentTimeMillis	()J
    //   122: putfield 304	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KOF	J
    //   125: aload_0
    //   126: new 1818	com/tencent/mm/ui/widget/b/a
    //   129: dup
    //   130: aload_0
    //   131: invokespecial 3974	com/tencent/mm/ui/widget/b/a:<init>	(Landroid/content/Context;)V
    //   134: putfield 633	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:szq	Lcom/tencent/mm/ui/widget/b/a;
    //   137: aload_0
    //   138: aload_0
    //   139: invokevirtual 2734	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   142: ldc_w 3976
    //   145: iconst_0
    //   146: invokevirtual 3980	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   149: putfield 3551	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPv	I
    //   152: aload_0
    //   153: aload_0
    //   154: invokevirtual 2734	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   157: ldc_w 3982
    //   160: iconst_0
    //   161: invokevirtual 2742	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   164: putfield 354	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPw	Z
    //   167: aload_0
    //   168: getfield 354	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPw	Z
    //   171: ifeq +10 -> 181
    //   174: getstatic 573	com/tencent/mm/plugin/sns/k/g:Kia	Lcom/tencent/mm/plugin/sns/k/g;
    //   177: invokevirtual 3985	com/tencent/mm/plugin/sns/k/g:fQt	()Lcom/tencent/mm/f/b/a/ko;
    //   180: pop
    //   181: getstatic 1998	com/tencent/mm/plugin/sns/i/a:KeP	Lcom/tencent/mm/plugin/sns/i/a$a;
    //   184: astore_1
    //   185: aload_0
    //   186: invokestatic 3988	com/tencent/mm/plugin/sns/i/a$a:ia	(Landroid/content/Context;)V
    //   189: aload_0
    //   190: aload_0
    //   191: invokevirtual 2734	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   194: ldc_w 3990
    //   197: invokevirtual 3801	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   200: ldc_w 328
    //   203: invokestatic 1698	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   206: putfield 486	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:fLp	Ljava/lang/String;
    //   209: aload_0
    //   210: getfield 486	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:fLp	Ljava/lang/String;
    //   213: invokestatic 981	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   216: ifeq +24 -> 240
    //   219: aload_0
    //   220: ldc_w 3992
    //   223: aload_0
    //   224: invokevirtual 2734	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   227: ldc_w 3990
    //   230: lconst_0
    //   231: invokevirtual 3712	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   234: invokestatic 3996	com/tencent/mm/plugin/sns/storage/y:bs	(Ljava/lang/String;J)Ljava/lang/String;
    //   237: putfield 486	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:fLp	Ljava/lang/String;
    //   240: aload_0
    //   241: aload_0
    //   242: invokevirtual 2734	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   245: ldc_w 3998
    //   248: invokevirtual 3801	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   251: ldc_w 328
    //   254: invokestatic 1698	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   257: putfield 924	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KOX	Ljava/lang/String;
    //   260: aload_0
    //   261: getfield 924	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KOX	Ljava/lang/String;
    //   264: invokestatic 981	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   267: ifeq +32 -> 299
    //   270: aload_0
    //   271: invokevirtual 2734	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   274: ldc_w 3998
    //   277: iconst_m1
    //   278: invokevirtual 3980	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   281: istore_2
    //   282: iload_2
    //   283: iconst_m1
    //   284: if_icmpeq +15 -> 299
    //   287: aload_0
    //   288: ldc_w 3992
    //   291: iload_2
    //   292: i2l
    //   293: invokestatic 3996	com/tencent/mm/plugin/sns/storage/y:bs	(Ljava/lang/String;J)Ljava/lang/String;
    //   296: putfield 924	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KOX	Ljava/lang/String;
    //   299: aload_0
    //   300: new 78	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$4
    //   303: dup
    //   304: aload_0
    //   305: aload_0
    //   306: invokevirtual 559	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   309: aload_0
    //   310: aload_0
    //   311: getfield 373	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPC	Lcom/tencent/mm/plugin/sns/model/ak;
    //   314: invokespecial 4001	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$4:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;ILandroid/app/Activity;Lcom/tencent/mm/plugin/sns/model/ai;)V
    //   317: putfield 518	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:JIp	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   320: aload_0
    //   321: getstatic 1839	com/tencent/mm/plugin/sns/i$f:timeline_root	I
    //   324: invokevirtual 1108	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:findViewById	(I)Landroid/view/View;
    //   327: checkcast 2617	android/widget/FrameLayout
    //   330: astore_1
    //   331: aload_0
    //   332: new 4003	com/tencent/mm/plugin/sns/h/b
    //   335: dup
    //   336: aload_0
    //   337: aload_0
    //   338: getfield 518	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:JIp	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   341: aload_1
    //   342: invokespecial 4006	com/tencent/mm/plugin/sns/h/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/c;Landroid/widget/FrameLayout;)V
    //   345: putfield 4008	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KCb	Lcom/tencent/mm/plugin/sns/h/b;
    //   348: aload_0
    //   349: new 4010	com/tencent/mm/plugin/sns/ui/b
    //   352: dup
    //   353: aload_0
    //   354: aload_0
    //   355: getfield 518	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:JIp	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   358: aload_1
    //   359: aload_0
    //   360: getfield 4008	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KCb	Lcom/tencent/mm/plugin/sns/h/b;
    //   363: invokespecial 4013	com/tencent/mm/plugin/sns/ui/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/c;Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/sns/h/b;)V
    //   366: putfield 1245	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KCa	Lcom/tencent/mm/plugin/sns/ui/b;
    //   369: aload_0
    //   370: new 4015	com/tencent/mm/plugin/sns/ui/ar
    //   373: dup
    //   374: aload_0
    //   375: aload_0
    //   376: getfield 518	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:JIp	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   379: aload_1
    //   380: invokespecial 4016	com/tencent/mm/plugin/sns/ui/ar:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/c;Landroid/widget/FrameLayout;)V
    //   383: putfield 1248	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KCc	Lcom/tencent/mm/plugin/sns/ui/ar;
    //   386: aload_0
    //   387: new 4018	com/tencent/mm/plugin/sns/ui/bx
    //   390: dup
    //   391: aload_0
    //   392: aload_0
    //   393: getfield 518	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:JIp	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   396: aload_1
    //   397: invokespecial 4019	com/tencent/mm/plugin/sns/ui/bx:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/c;Landroid/widget/FrameLayout;)V
    //   400: putfield 1551	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KCd	Lcom/tencent/mm/plugin/sns/ui/bx;
    //   403: aload_0
    //   404: getfield 518	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:JIp	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   407: invokevirtual 4022	com/tencent/mm/plugin/sns/ui/d/c:eKx	()V
    //   410: aload_0
    //   411: aload_0
    //   412: invokevirtual 2734	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   415: ldc_w 4024
    //   418: iconst_0
    //   419: invokevirtual 2742	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   422: putfield 348	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPs	Z
    //   425: aload_0
    //   426: aload_0
    //   427: invokevirtual 2734	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   430: ldc_w 4026
    //   433: invokevirtual 3801	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   436: putfield 350	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPt	Ljava/lang/String;
    //   439: aload_0
    //   440: new 1176	com/tencent/mm/plugin/sns/ui/bu
    //   443: dup
    //   444: aload_0
    //   445: new 96	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$5
    //   448: dup
    //   449: aload_0
    //   450: invokespecial 4027	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$5:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   453: aload_0
    //   454: invokevirtual 559	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   457: aload_0
    //   458: getfield 373	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPC	Lcom/tencent/mm/plugin/sns/model/ak;
    //   461: invokespecial 4030	com/tencent/mm/plugin/sns/ui/bu:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/bu$a;ILcom/tencent/mm/plugin/sns/model/ai;)V
    //   464: putfield 1232	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPg	Lcom/tencent/mm/plugin/sns/ui/bu;
    //   467: invokestatic 3973	java/lang/System:currentTimeMillis	()J
    //   470: lstore_3
    //   471: aload_0
    //   472: invokevirtual 2734	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   475: ldc_w 4032
    //   478: invokevirtual 4036	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   481: astore_1
    //   482: aload_1
    //   483: ifnull +184 -> 667
    //   486: new 800	com/tencent/mm/protocal/protobuf/TimeLineObject
    //   489: dup
    //   490: invokespecial 4037	com/tencent/mm/protocal/protobuf/TimeLineObject:<init>	()V
    //   493: astore 6
    //   495: aload 6
    //   497: aload_1
    //   498: invokevirtual 4041	com/tencent/mm/protocal/protobuf/TimeLineObject:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   501: pop
    //   502: invokestatic 4045	com/tencent/mm/plugin/sns/model/aj:fOI	()Lcom/tencent/mm/plugin/sns/storage/n;
    //   505: new 4047	java/math/BigInteger
    //   508: dup
    //   509: aload 6
    //   511: getfield 2730	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   514: invokespecial 4048	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   517: invokevirtual 4051	java/math/BigInteger:longValue	()J
    //   520: invokevirtual 4057	com/tencent/mm/plugin/sns/storage/n:Rd	(J)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   523: ifnonnull +766 -> 1289
    //   526: ldc_w 711
    //   529: ldc_w 4059
    //   532: invokestatic 787	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   535: new 539	com/tencent/mm/plugin/sns/storage/SnsInfo
    //   538: dup
    //   539: invokespecial 4060	com/tencent/mm/plugin/sns/storage/SnsInfo:<init>	()V
    //   542: astore_1
    //   543: aload_1
    //   544: new 4047	java/math/BigInteger
    //   547: dup
    //   548: aload 6
    //   550: getfield 2730	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   553: invokespecial 4048	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   556: invokevirtual 4051	java/math/BigInteger:longValue	()J
    //   559: putfield 1773	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   562: aload_1
    //   563: aload 6
    //   565: invokevirtual 4064	com/tencent/mm/protocal/protobuf/TimeLineObject:toByteArray	()[B
    //   568: putfield 4068	com/tencent/mm/plugin/sns/storage/SnsInfo:field_content	[B
    //   571: aload_1
    //   572: aload 6
    //   574: getfield 3004	com/tencent/mm/protocal/protobuf/TimeLineObject:CreateTime	I
    //   577: putfield 1969	com/tencent/mm/plugin/sns/storage/SnsInfo:field_createTime	I
    //   580: aload_1
    //   581: aload 6
    //   583: getfield 2455	com/tencent/mm/protocal/protobuf/TimeLineObject:UserName	Ljava/lang/String;
    //   586: putfield 3657	com/tencent/mm/plugin/sns/storage/SnsInfo:field_userName	Ljava/lang/String;
    //   589: aload_1
    //   590: aload 6
    //   592: getfield 804	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adw;
    //   595: getfield 809	com/tencent/mm/protocal/protobuf/adw:Sqq	I
    //   598: putfield 1980	com/tencent/mm/plugin/sns/storage/SnsInfo:field_type	I
    //   601: aload_1
    //   602: invokevirtual 4071	com/tencent/mm/plugin/sns/storage/SnsInfo:setExtFlag	()V
    //   605: new 500	com/tencent/mm/protocal/protobuf/SnsObject
    //   608: dup
    //   609: invokespecial 4072	com/tencent/mm/protocal/protobuf/SnsObject:<init>	()V
    //   612: astore 6
    //   614: aload 6
    //   616: new 4074	com/tencent/mm/protocal/protobuf/eae
    //   619: dup
    //   620: invokespecial 4075	com/tencent/mm/protocal/protobuf/eae:<init>	()V
    //   623: putfield 4079	com/tencent/mm/protocal/protobuf/SnsObject:ObjectDesc	Lcom/tencent/mm/protocal/protobuf/eae;
    //   626: aload_1
    //   627: aload 6
    //   629: invokevirtual 4080	com/tencent/mm/protocal/protobuf/SnsObject:toByteArray	()[B
    //   632: putfield 4083	com/tencent/mm/plugin/sns/storage/SnsInfo:field_attrBuf	[B
    //   635: invokestatic 4045	com/tencent/mm/plugin/sns/model/aj:fOI	()Lcom/tencent/mm/plugin/sns/storage/n;
    //   638: aload_1
    //   639: invokevirtual 4087	com/tencent/mm/plugin/sns/storage/n:insert	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;)Z
    //   642: pop
    //   643: ldc_w 4089
    //   646: ldc_w 4091
    //   649: iconst_1
    //   650: anewarray 1283	java/lang/Object
    //   653: dup
    //   654: iconst_0
    //   655: invokestatic 3973	java/lang/System:currentTimeMillis	()J
    //   658: lload_3
    //   659: lsub
    //   660: invokestatic 1778	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   663: aastore
    //   664: invokestatic 1684	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   667: aload_0
    //   668: iconst_1
    //   669: invokespecial 653	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yW	(Z)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   672: astore_1
    //   673: ldc_w 711
    //   676: new 713	java/lang/StringBuilder
    //   679: dup
    //   680: ldc_w 4093
    //   683: invokespecial 717	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   686: aload_0
    //   687: getfield 486	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:fLp	Ljava/lang/String;
    //   690: invokevirtual 724	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: ldc_w 4095
    //   696: invokevirtual 724	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: aload_0
    //   700: getfield 924	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KOX	Ljava/lang/String;
    //   703: invokevirtual 724	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: invokevirtual 725	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 787	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   712: aload_1
    //   713: ifnull +29 -> 742
    //   716: ldc_w 711
    //   719: ldc_w 4097
    //   722: iconst_1
    //   723: anewarray 1283	java/lang/Object
    //   726: dup
    //   727: iconst_0
    //   728: aload_1
    //   729: invokevirtual 944	com/tencent/mm/plugin/sns/storage/SnsInfo:getUserName	()Ljava/lang/String;
    //   732: ldc_w 328
    //   735: invokestatic 1698	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   738: aastore
    //   739: invokestatic 1684	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   742: aload_0
    //   743: getfield 486	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:fLp	Ljava/lang/String;
    //   746: invokestatic 537	com/tencent/mm/plugin/sns/storage/y:bbJ	(Ljava/lang/String;)Z
    //   749: ifeq +56 -> 805
    //   752: aload_0
    //   753: getfield 486	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:fLp	Ljava/lang/String;
    //   756: invokestatic 4100	com/tencent/mm/plugin/sns/storage/y:aYj	(Ljava/lang/String;)Z
    //   759: ifeq +574 -> 1333
    //   762: aload_1
    //   763: ifnull +538 -> 1301
    //   766: aload_1
    //   767: invokevirtual 944	com/tencent/mm/plugin/sns/storage/SnsInfo:getUserName	()Ljava/lang/String;
    //   770: invokestatic 4105	com/tencent/mm/model/ab:Qk	(Ljava/lang/String;)Z
    //   773: ifne +32 -> 805
    //   776: invokestatic 1652	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
    //   779: pop
    //   780: invokestatic 4109	com/tencent/mm/kernel/h:aHF	()Lcom/tencent/mm/kernel/c;
    //   783: getfield 4115	com/tencent/mm/kernel/c:kcd	Lcom/tencent/mm/an/t;
    //   786: new 4117	com/tencent/mm/plugin/sns/model/r
    //   789: dup
    //   790: aload_0
    //   791: getfield 486	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:fLp	Ljava/lang/String;
    //   794: invokestatic 4120	com/tencent/mm/plugin/sns/storage/y:aYS	(Ljava/lang/String;)J
    //   797: invokespecial 4122	com/tencent/mm/plugin/sns/model/r:<init>	(J)V
    //   800: iconst_0
    //   801: invokevirtual 4127	com/tencent/mm/an/t:a	(Lcom/tencent/mm/an/q;I)Z
    //   804: pop
    //   805: invokestatic 1652	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
    //   808: pop
    //   809: invokestatic 4109	com/tencent/mm/kernel/h:aHF	()Lcom/tencent/mm/kernel/c;
    //   812: getfield 4115	com/tencent/mm/kernel/c:kcd	Lcom/tencent/mm/an/t;
    //   815: sipush 210
    //   818: aload_0
    //   819: invokevirtual 4130	com/tencent/mm/an/t:a	(ILcom/tencent/mm/an/i;)V
    //   822: invokestatic 1652	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
    //   825: pop
    //   826: invokestatic 4109	com/tencent/mm/kernel/h:aHF	()Lcom/tencent/mm/kernel/c;
    //   829: getfield 4115	com/tencent/mm/kernel/c:kcd	Lcom/tencent/mm/an/t;
    //   832: sipush 218
    //   835: aload_0
    //   836: invokevirtual 4130	com/tencent/mm/an/t:a	(ILcom/tencent/mm/an/i;)V
    //   839: invokestatic 1652	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
    //   842: pop
    //   843: invokestatic 4109	com/tencent/mm/kernel/h:aHF	()Lcom/tencent/mm/kernel/c;
    //   846: getfield 4115	com/tencent/mm/kernel/c:kcd	Lcom/tencent/mm/an/t;
    //   849: sipush 213
    //   852: aload_0
    //   853: invokevirtual 4130	com/tencent/mm/an/t:a	(ILcom/tencent/mm/an/i;)V
    //   856: invokestatic 1652	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
    //   859: pop
    //   860: invokestatic 4109	com/tencent/mm/kernel/h:aHF	()Lcom/tencent/mm/kernel/c;
    //   863: getfield 4115	com/tencent/mm/kernel/c:kcd	Lcom/tencent/mm/an/t;
    //   866: sipush 682
    //   869: aload_0
    //   870: invokevirtual 4130	com/tencent/mm/an/t:a	(ILcom/tencent/mm/an/i;)V
    //   873: invokestatic 1652	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
    //   876: pop
    //   877: invokestatic 4109	com/tencent/mm/kernel/h:aHF	()Lcom/tencent/mm/kernel/c;
    //   880: getfield 4115	com/tencent/mm/kernel/c:kcd	Lcom/tencent/mm/an/t;
    //   883: sipush 214
    //   886: aload_0
    //   887: invokevirtual 4130	com/tencent/mm/an/t:a	(ILcom/tencent/mm/an/i;)V
    //   890: invokestatic 1652	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
    //   893: pop
    //   894: invokestatic 4109	com/tencent/mm/kernel/h:aHF	()Lcom/tencent/mm/kernel/c;
    //   897: getfield 4115	com/tencent/mm/kernel/c:kcd	Lcom/tencent/mm/an/t;
    //   900: sipush 683
    //   903: aload_0
    //   904: invokevirtual 4130	com/tencent/mm/an/t:a	(ILcom/tencent/mm/an/i;)V
    //   907: aload_0
    //   908: invokestatic 4133	com/tencent/mm/plugin/sns/model/aj:fOw	()Lcom/tencent/mm/storage/bv;
    //   911: putfield 3415	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KOY	Lcom/tencent/mm/storage/bv;
    //   914: aload_0
    //   915: new 4135	com/tencent/mm/plugin/sns/ui/bd
    //   918: dup
    //   919: aload_0
    //   920: invokespecial 4138	com/tencent/mm/plugin/sns/ui/bd:<init>	(Landroid/app/Activity;)V
    //   923: putfield 1242	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KBU	Lcom/tencent/mm/plugin/sns/ui/bd;
    //   926: aload_0
    //   927: new 814	com/tencent/mm/plugin/sns/ui/bg
    //   930: dup
    //   931: aload_0
    //   932: invokevirtual 739	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   935: invokespecial 4139	com/tencent/mm/plugin/sns/ui/bg:<init>	(Landroid/content/Context;)V
    //   938: putfield 525	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KOW	Lcom/tencent/mm/plugin/sns/ui/bg;
    //   941: aload_0
    //   942: new 4141	com/tencent/mm/plugin/sns/ui/j
    //   945: dup
    //   946: aload_0
    //   947: aload_0
    //   948: invokevirtual 559	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   951: aload_0
    //   952: getfield 373	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPC	Lcom/tencent/mm/plugin/sns/model/ak;
    //   955: invokespecial 4144	com/tencent/mm/plugin/sns/ui/j:<init>	(Landroid/app/Activity;ILcom/tencent/mm/plugin/sns/model/ai;)V
    //   958: putfield 626	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPc	Lcom/tencent/mm/plugin/sns/ui/j;
    //   961: aload_0
    //   962: new 4146	com/tencent/mm/plugin/sns/ui/l
    //   965: dup
    //   966: aload_0
    //   967: invokespecial 4149	com/tencent/mm/plugin/sns/ui/l:<init>	(Lcom/tencent/mm/plugin/sns/ui/ad;)V
    //   970: putfield 4151	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPd	Lcom/tencent/mm/plugin/sns/ui/l;
    //   973: aload_1
    //   974: ifnull +76 -> 1050
    //   977: aload_0
    //   978: aload_1
    //   979: iconst_0
    //   980: invokestatic 1572	com/tencent/mm/plugin/sns/ui/bm:g	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Z)I
    //   983: putfield 521	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:viewType	I
    //   986: getstatic 573	com/tencent/mm/plugin/sns/k/g:Kia	Lcom/tencent/mm/plugin/sns/k/g;
    //   989: invokestatic 3973	java/lang/System:currentTimeMillis	()J
    //   992: putfield 4154	com/tencent/mm/plugin/sns/k/g:Kiz	J
    //   995: getstatic 573	com/tencent/mm/plugin/sns/k/g:Kia	Lcom/tencent/mm/plugin/sns/k/g;
    //   998: astore 6
    //   1000: aload_1
    //   1001: ifnull +40 -> 1041
    //   1004: aload_1
    //   1005: getfield 1773	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1008: invokestatic 4157	com/tencent/mm/plugin/sns/data/t:Qv	(J)Ljava/lang/String;
    //   1011: astore 7
    //   1013: aload 6
    //   1015: getfield 4160	com/tencent/mm/plugin/sns/k/g:Kit	Ljava/util/List;
    //   1018: aload 7
    //   1020: invokeinterface 4163 2 0
    //   1025: ifne +16 -> 1041
    //   1028: aload 6
    //   1030: getfield 4160	com/tencent/mm/plugin/sns/k/g:Kit	Ljava/util/List;
    //   1033: aload 7
    //   1035: invokeinterface 2427 2 0
    //   1040: pop
    //   1041: getstatic 573	com/tencent/mm/plugin/sns/k/g:Kia	Lcom/tencent/mm/plugin/sns/k/g;
    //   1044: invokestatic 3973	java/lang/System:currentTimeMillis	()J
    //   1047: putfield 4166	com/tencent/mm/plugin/sns/k/g:KiG	J
    //   1050: aload_1
    //   1051: ifnull +89 -> 1140
    //   1054: aload_1
    //   1055: invokevirtual 556	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
    //   1058: ifeq +82 -> 1140
    //   1061: aload_0
    //   1062: getfield 3551	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPv	I
    //   1065: bipush 16
    //   1067: if_icmpne +307 -> 1374
    //   1070: aload_0
    //   1071: new 2648	com/tencent/mm/plugin/sns/ad/f/l
    //   1074: dup
    //   1075: iconst_2
    //   1076: invokespecial 4168	com/tencent/mm/plugin/sns/ad/f/l:<init>	(I)V
    //   1079: putfield 1047	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPn	Lcom/tencent/mm/plugin/sns/ad/f/l;
    //   1082: getstatic 1455	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   1085: sipush 1697
    //   1088: bipush 17
    //   1090: invokevirtual 4171	com/tencent/mm/plugin/report/service/h:el	(II)V
    //   1093: aload_0
    //   1094: getfield 1047	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPn	Lcom/tencent/mm/plugin/sns/ad/f/l;
    //   1097: aload_0
    //   1098: getfield 3967	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenHeight	I
    //   1101: aload_0
    //   1102: invokevirtual 4175	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSupportActionBar	()Landroidx/appcompat/app/ActionBar;
    //   1105: invokevirtual 4180	androidx/appcompat/app/ActionBar:getCustomView	()Landroid/view/View;
    //   1108: aload_0
    //   1109: invokevirtual 4183	com/tencent/mm/plugin/sns/ad/f/l:a	(ILandroid/view/View;Landroid/app/Activity;)V
    //   1112: aload_1
    //   1113: iconst_0
    //   1114: invokestatic 1572	com/tencent/mm/plugin/sns/ui/bm:g	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Z)I
    //   1117: pop
    //   1118: aload_0
    //   1119: getfield 518	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:JIp	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   1122: aload_0
    //   1123: getfield 1047	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPn	Lcom/tencent/mm/plugin/sns/ad/f/l;
    //   1126: invokevirtual 4186	com/tencent/mm/plugin/sns/ui/d/c:c	(Lcom/tencent/mm/plugin/sns/ad/f/l;)V
    //   1129: aload_0
    //   1130: getfield 1245	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KCa	Lcom/tencent/mm/plugin/sns/ui/b;
    //   1133: aload_0
    //   1134: getfield 1047	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPn	Lcom/tencent/mm/plugin/sns/ad/f/l;
    //   1137: putfield 4189	com/tencent/mm/plugin/sns/ui/b:JHg	Lcom/tencent/mm/plugin/sns/ad/f/l;
    //   1140: aload_0
    //   1141: invokevirtual 4191	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:initView	()V
    //   1144: aload_1
    //   1145: ifnull +47 -> 1192
    //   1148: aload_1
    //   1149: invokevirtual 556	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
    //   1152: ifeq +40 -> 1192
    //   1155: aload_1
    //   1156: invokestatic 498	com/tencent/mm/plugin/sns/model/an:C	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   1159: astore 6
    //   1161: aload_0
    //   1162: getfield 1047	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPn	Lcom/tencent/mm/plugin/sns/ad/f/l;
    //   1165: iconst_0
    //   1166: aload_1
    //   1167: invokevirtual 991	com/tencent/mm/plugin/sns/storage/SnsInfo:getLocalid	()Ljava/lang/String;
    //   1170: aload_1
    //   1171: invokevirtual 4194	com/tencent/mm/plugin/sns/storage/SnsInfo:isExposures	()Z
    //   1174: aload_0
    //   1175: getfield 1466	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KOH	Landroid/view/View;
    //   1178: aload_1
    //   1179: getfield 1773	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1182: aload 6
    //   1184: aload_0
    //   1185: getfield 521	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:viewType	I
    //   1188: iconst_2
    //   1189: invokevirtual 4197	com/tencent/mm/plugin/sns/ad/f/l:a	(ILjava/lang/String;ZLandroid/view/View;JLcom/tencent/mm/protocal/protobuf/SnsObject;II)V
    //   1192: aload_0
    //   1193: getfield 1466	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KOH	Landroid/view/View;
    //   1196: ifnull +79 -> 1275
    //   1199: aload_1
    //   1200: ifnull +75 -> 1275
    //   1203: aload_0
    //   1204: getfield 1466	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KOH	Landroid/view/View;
    //   1207: getstatic 2499	com/tencent/mm/plugin/sns/i$f:image	I
    //   1210: invokevirtual 1576	android/view/View:findViewById	(I)Landroid/view/View;
    //   1213: checkcast 4199	com/tencent/mm/plugin/sight/decode/a/a
    //   1216: astore 6
    //   1218: aload_1
    //   1219: invokevirtual 798	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1222: getfield 804	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adw;
    //   1225: ifnull +339 -> 1564
    //   1228: aload_1
    //   1229: invokevirtual 798	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1232: getfield 804	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adw;
    //   1235: getfield 809	com/tencent/mm/protocal/protobuf/adw:Sqq	I
    //   1238: bipush 15
    //   1240: if_icmpne +324 -> 1564
    //   1243: aload 6
    //   1245: instanceof 2597
    //   1248: ifeq +316 -> 1564
    //   1251: aload 6
    //   1253: checkcast 2597	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView
    //   1256: getfield 4203	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView:JsW	Lcom/tencent/mm/plugin/sight/decode/a/b;
    //   1259: invokevirtual 4208	com/tencent/mm/plugin/sight/decode/a/b:fIB	()Z
    //   1262: istore 5
    //   1264: aload_1
    //   1265: iconst_1
    //   1266: iload 5
    //   1268: aload_0
    //   1269: invokevirtual 559	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   1272: invokestatic 4213	com/tencent/mm/plugin/sns/ad/f/p:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;ZZI)V
    //   1275: aload_0
    //   1276: getfield 641	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KOL	Landroid/widget/ListView;
    //   1279: ifnonnull +121 -> 1400
    //   1282: ldc_w 3910
    //   1285: invokestatic 299	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1288: return
    //   1289: ldc_w 711
    //   1292: ldc_w 4215
    //   1295: invokestatic 787	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1298: goto -631 -> 667
    //   1301: invokestatic 1652	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
    //   1304: pop
    //   1305: invokestatic 4109	com/tencent/mm/kernel/h:aHF	()Lcom/tencent/mm/kernel/c;
    //   1308: getfield 4115	com/tencent/mm/kernel/c:kcd	Lcom/tencent/mm/an/t;
    //   1311: new 4117	com/tencent/mm/plugin/sns/model/r
    //   1314: dup
    //   1315: aload_0
    //   1316: getfield 486	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:fLp	Ljava/lang/String;
    //   1319: invokestatic 4120	com/tencent/mm/plugin/sns/storage/y:aYS	(Ljava/lang/String;)J
    //   1322: invokespecial 4122	com/tencent/mm/plugin/sns/model/r:<init>	(J)V
    //   1325: iconst_0
    //   1326: invokevirtual 4127	com/tencent/mm/an/t:a	(Lcom/tencent/mm/an/q;I)Z
    //   1329: pop
    //   1330: goto -525 -> 805
    //   1333: invokestatic 1652	com/tencent/mm/kernel/h:aHH	()Lcom/tencent/mm/kernel/h;
    //   1336: pop
    //   1337: invokestatic 4109	com/tencent/mm/kernel/h:aHF	()Lcom/tencent/mm/kernel/c;
    //   1340: getfield 4115	com/tencent/mm/kernel/c:kcd	Lcom/tencent/mm/an/t;
    //   1343: new 4217	com/tencent/mm/plugin/sns/model/m
    //   1346: dup
    //   1347: aload_0
    //   1348: getfield 486	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:fLp	Ljava/lang/String;
    //   1351: invokestatic 4120	com/tencent/mm/plugin/sns/storage/y:aYS	(Ljava/lang/String;)J
    //   1354: iconst_0
    //   1355: aload_0
    //   1356: aload_1
    //   1357: invokespecial 647	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:h	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   1360: getfield 4220	com/tencent/mm/plugin/sns/storage/ADInfo:adInfoSyncBuffer	Ljava/lang/String;
    //   1363: invokespecial 4223	com/tencent/mm/plugin/sns/model/m:<init>	(JILjava/lang/String;)V
    //   1366: iconst_0
    //   1367: invokevirtual 4127	com/tencent/mm/an/t:a	(Lcom/tencent/mm/an/q;I)Z
    //   1370: pop
    //   1371: goto -566 -> 805
    //   1374: aload_0
    //   1375: new 2648	com/tencent/mm/plugin/sns/ad/f/l
    //   1378: dup
    //   1379: iconst_1
    //   1380: invokespecial 4168	com/tencent/mm/plugin/sns/ad/f/l:<init>	(I)V
    //   1383: putfield 1047	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPn	Lcom/tencent/mm/plugin/sns/ad/f/l;
    //   1386: getstatic 1455	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   1389: sipush 1697
    //   1392: bipush 16
    //   1394: invokevirtual 4171	com/tencent/mm/plugin/report/service/h:el	(II)V
    //   1397: goto -304 -> 1093
    //   1400: aload_0
    //   1401: getfield 641	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KOL	Landroid/widget/ListView;
    //   1404: new 98	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$6
    //   1407: dup
    //   1408: aload_0
    //   1409: invokespecial 4224	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$6:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   1412: invokevirtual 4225	android/widget/ListView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1415: aload_0
    //   1416: new 4227	com/tencent/mm/plugin/sns/ui/n
    //   1419: dup
    //   1420: aload_0
    //   1421: invokespecial 4228	com/tencent/mm/plugin/sns/ui/n:<init>	(Landroid/content/Context;)V
    //   1424: putfield 362	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPy	Lcom/tencent/mm/plugin/sns/ui/n;
    //   1427: aload_1
    //   1428: ifnull +34 -> 1462
    //   1431: aload_0
    //   1432: getfield 1389	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:iRj	Ljava/lang/String;
    //   1435: aload_1
    //   1436: invokevirtual 944	com/tencent/mm/plugin/sns/storage/SnsInfo:getUserName	()Ljava/lang/String;
    //   1439: invokestatic 1908	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1442: ifeq +20 -> 1462
    //   1445: aload_0
    //   1446: iconst_0
    //   1447: getstatic 4231	com/tencent/mm/plugin/sns/i$i:icons_outlined_more	I
    //   1450: new 100	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7
    //   1453: dup
    //   1454: aload_0
    //   1455: aload_1
    //   1456: invokespecial 4232	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
    //   1459: invokevirtual 4236	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:addIconOptionMenu	(IILandroid/view/MenuItem$OnMenuItemClickListener;)V
    //   1462: getstatic 3792	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   1465: aload_0
    //   1466: getfield 378	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPD	Lcom/tencent/mm/sdk/event/IListener;
    //   1469: invokevirtual 4240	com/tencent/mm/sdk/event/EventCenter:addListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   1472: pop
    //   1473: getstatic 3792	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   1476: aload_0
    //   1477: getfield 381	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPE	Lcom/tencent/mm/sdk/event/IListener;
    //   1480: invokevirtual 4240	com/tencent/mm/sdk/event/EventCenter:addListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   1483: pop
    //   1484: getstatic 3792	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   1487: aload_0
    //   1488: getfield 384	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPF	Lcom/tencent/mm/sdk/event/IListener;
    //   1491: invokevirtual 4240	com/tencent/mm/sdk/event/EventCenter:addListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   1494: pop
    //   1495: getstatic 3792	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   1498: aload_0
    //   1499: getfield 387	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPG	Lcom/tencent/mm/sdk/event/IListener;
    //   1502: invokevirtual 4240	com/tencent/mm/sdk/event/EventCenter:addListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   1505: pop
    //   1506: getstatic 3792	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   1509: aload_0
    //   1510: getfield 411	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPL	Lcom/tencent/mm/sdk/event/IListener;
    //   1513: invokevirtual 4240	com/tencent/mm/sdk/event/EventCenter:addListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   1516: pop
    //   1517: getstatic 3792	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   1520: aload_0
    //   1521: getfield 422	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KPM	Lcom/tencent/mm/sdk/event/IListener;
    //   1524: invokevirtual 4240	com/tencent/mm/sdk/event/EventCenter:addListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   1527: pop
    //   1528: getstatic 3792	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   1531: aload_0
    //   1532: getfield 390	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:KCh	Lcom/tencent/mm/sdk/event/IListener;
    //   1535: invokevirtual 4240	com/tencent/mm/sdk/event/EventCenter:addListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   1538: pop
    //   1539: aload_0
    //   1540: invokestatic 4242	com/tencent/mm/pluginsdk/h:s	(Lcom/tencent/mm/ui/MMActivity;)V
    //   1543: ldc_w 3910
    //   1546: invokestatic 299	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1549: return
    //   1550: astore_1
    //   1551: goto -884 -> 667
    //   1554: astore 6
    //   1556: goto -921 -> 635
    //   1559: astore 7
    //   1561: goto -990 -> 571
    //   1564: iconst_0
    //   1565: istore 5
    //   1567: goto -303 -> 1264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1570	0	this	SnsCommentDetailUI
    //   0	1570	1	paramBundle	Bundle
    //   281	11	2	i	int
    //   470	189	3	l	long
    //   1262	304	5	bool	boolean
    //   493	759	6	localObject	Object
    //   1554	1	6	localIOException	java.io.IOException
    //   1011	23	7	str	String
    //   1559	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   495	502	1550	java/io/IOException
    //   626	635	1554	java/io/IOException
    //   562	571	1559	java/lang/Exception
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98596);
    aj.fOy().a(this, 5);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(210, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(218, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(213, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(214, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(683, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(682, this);
    aj.fOF().aO(this);
    if (this.KPc != null) {
      this.KPc.activity = null;
    }
    ah.fTU();
    if (this.KBS != null) {
      this.KBS.fWn();
    }
    SnsInfo localSnsInfo = yW(false);
    Object localObject;
    if ((localSnsInfo != null) && (localSnsInfo.isAd()))
    {
      if (this.KPn != null) {
        this.KPn.a(0, localSnsInfo.getLocalid(), localSnsInfo.field_snsId, 2);
      }
      localObject = h(localSnsInfo);
      if (localObject != null) {
        break label615;
      }
      localObject = "";
      if (!localSnsInfo.isRecExpAd()) {
        break label623;
      }
      aj.fOC().a(14652, new Object[] { com.tencent.mm.plugin.sns.ad.f.k.a(localSnsInfo.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.t.Qu(localSnsInfo.field_snsId), localObject, Long.valueOf(this.KOF), Long.valueOf(System.currentTimeMillis()) }) });
    }
    for (;;)
    {
      com.tencent.mm.modelsns.l locall = com.tencent.mm.modelsns.l.wP(732);
      locall.Xf(com.tencent.mm.plugin.sns.data.t.Qu(localSnsInfo.field_snsId)).Xf((String)localObject).Xf(this.KOF).Xf(System.currentTimeMillis());
      locall.bpa();
      this.JIp.removeListener();
      EventCenter.instance.removeListener(this.KPD);
      EventCenter.instance.removeListener(this.KPE);
      EventCenter.instance.removeListener(this.KPF);
      EventCenter.instance.removeListener(this.KPG);
      EventCenter.instance.removeListener(this.KPL);
      EventCenter.instance.removeListener(this.KPM);
      EventCenter.instance.removeListener(this.KCh);
      super.onDestroy();
      localObject = com.tencent.mm.plugin.sns.k.g.Kia;
      if (((com.tencent.mm.plugin.sns.k.g)localObject).Kiz != 0L)
      {
        ((com.tencent.mm.plugin.sns.k.g)localObject).KiA += System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.k.g)localObject).Kiz;
        ((com.tencent.mm.plugin.sns.k.g)localObject).Kiz = 0L;
      }
      localObject = com.tencent.mm.plugin.sns.k.g.Kia;
      if (((com.tencent.mm.plugin.sns.k.g)localObject).KiG != 0L)
      {
        ((com.tencent.mm.plugin.sns.k.g)localObject).KiH += System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.k.g)localObject).KiG;
        ((com.tencent.mm.plugin.sns.k.g)localObject).KiG = 0L;
      }
      if ((this.KPw) && (localSnsInfo != null) && (localSnsInfo.getTimeLine() != null) && (localSnsInfo.getTimeLine().ContentObj != null))
      {
        localObject = com.tencent.mm.plugin.sns.k.g.Kia.fQr();
        ((ko)localObject).gBe = com.tencent.mm.plugin.sns.k.g.Kia.Kio.gBe;
        ((ko)localObject).BD(com.tencent.mm.plugin.sns.k.g.Kia.Kio.gQg).BE(com.tencent.mm.plugin.sns.data.t.Qv(localSnsInfo.field_snsId)).gmU = localSnsInfo.getTimeLine().ContentObj.Sqq;
        com.tencent.mm.plugin.sns.k.g.Kia.fQw();
      }
      if (this.KPB != null) {
        this.KPB.destroy();
      }
      AppMethodBeat.o(98596);
      return;
      label615:
      localObject = ((ADInfo)localObject).uxInfo;
      break;
      label623:
      aj.fOC().a(12012, new Object[] { com.tencent.mm.plugin.sns.ad.f.k.a(localSnsInfo.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.t.Qu(localSnsInfo.field_snsId), localObject, Long.valueOf(this.KOF), Long.valueOf(System.currentTimeMillis()) }) });
    }
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(98612);
    if (keyboardState() == 2)
    {
      Log.i("MicroMsg.SnsCommentDetailUI", "keybaordhide! ");
      this.KOV = false;
      AppMethodBeat.o(98612);
      return;
    }
    if (keyboardState() == 1)
    {
      Log.i("MicroMsg.SnsCommentDetailUI", "keybaordShow");
      fWd();
      this.KBP = false;
      this.KPJ.run();
      if (this.KCa != null) {
        this.KCa.fQe();
      }
    }
    AppMethodBeat.o(98612);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98598);
    aj.fOD().b(this);
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, null);
      this.KLC = false;
      super.onPause();
      this.KBS.iXq.hideVKB();
      SnsCommentFooter localSnsCommentFooter = this.KBS;
      if (localSnsCommentFooter.jPN != null) {
        localSnsCommentFooter.jPN.onPause();
      }
      localSnsCommentFooter.KQB.onPause();
      new zo().fYR.type = 1;
      if (this.KPn != null) {
        this.KPn.onPause();
      }
      if (this.KPm != null) {
        this.KPm.onPause();
      }
      this.ozM.dead();
      this.wNM.dead();
      AppMethodBeat.o(98598);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable.toString());
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98597);
    try
    {
      if (!this.KLC)
      {
        Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onResume callback");
        ScreenShotUtil.setScreenShotCallback(this, this.KMx);
        this.KLC = true;
      }
      aj.fOD().a(this);
      zo localzo = new zo();
      localzo.fYR.fYS = 0;
      localzo.fYR.fYT = 1;
      localzo.fYR.fYU = 0;
      localzo.fYR.type = 0;
      EventCenter.instance.publish(localzo);
      if (this.KPn != null) {
        this.KPn.onResume();
      }
      if (this.KPm != null) {
        this.KPm.refreshView();
      }
      super.onResume();
      this.ozM.alive();
      this.wNM.alive();
      AppMethodBeat.o(98597);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable.toString());
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(98611);
    if ((paramq.getType() == 218) && (this.KCf != null)) {
      this.KCf.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((this.KPy != null) && (this.KPy.tipDialog != null) && (this.KPy.tipDialog.isShowing())) {
        this.KPy.tipDialog.dismiss();
      }
      Object localObject = com.tencent.mm.plugin.sns.storage.f.bbk(this.fLp);
      if (localObject == null)
      {
        Log.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.fLp);
        finish();
        AppMethodBeat.o(98611);
        return;
      }
      Log.d("MicroMsg.SnsCommentDetailUI", "snsId: " + this.fLp + "  username:" + ((SnsInfo)localObject).getUserName());
      if (this.KOH == null)
      {
        Log.e("MicroMsg.SnsCommentDetailUI", "fatal error! Sns onSceneEnd before initView and infoHeader is null!");
        finish();
        AppMethodBeat.o(98611);
        return;
      }
      fWc();
      f((SnsInfo)localObject, false);
      paramString = an.C((SnsInfo)localObject);
      Log.i("MicroMsg.SnsCommentDetailUI", "onSceneEnd " + paramString.LikeUserList.size() + " " + paramString.CommentUserList.size());
      if (paramString == null)
      {
        AppMethodBeat.o(98611);
        return;
      }
      if (!g(this.KOT, paramString.LikeUserList))
      {
        p(paramString.LikeUserList, paramString.CommentUserList.isEmpty());
        this.KOT = paramString.LikeUserList;
      }
      if (this.KOK != null) {
        this.KOK.a((SnsInfo)localObject, this.JIp);
      }
      localObject = this.KOO;
      LinkedList localLinkedList = paramString.CommentUserList;
      paramString = paramString.LikeUserList;
      ((b)localObject).commentList = localLinkedList;
      ((b)localObject).KQt = paramString;
      this.KOO.notifyDataSetChanged();
    }
    SnsTimeLineUI.a(paramInt1, paramInt2, paramq, this);
    AppMethodBeat.o(98611);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(219736);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, null);
      this.KLC = false;
      AppMethodBeat.o(219736);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      Log.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.o(219736);
    }
    if (!this.KLC)
    {
      Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onWindowFocusChanged callback");
      ScreenShotUtil.setScreenShotCallback(this, this.KMx);
      this.KLC = true;
    }
    AppMethodBeat.o(219736);
    return;
  }
  
  final class a
    extends com.tencent.mm.pluginsdk.ui.span.q
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(98583);
      SnsCommentDetailUI.i(SnsCommentDetailUI.this).Lfk.onClick(paramView);
      AppMethodBeat.o(98583);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(98584);
      int i = SnsCommentDetailUI.this.getResources().getColor(i.c.sns_link_bg_color);
      if (getPress())
      {
        paramTextPaint.bgColor = i;
        AppMethodBeat.o(98584);
        return;
      }
      paramTextPaint.bgColor = 0;
      AppMethodBeat.o(98584);
    }
  }
  
  final class b
    extends BaseAdapter
  {
    LinkedList<ejo> KQt;
    Activity activity;
    public LinkedList<ejo> commentList;
    String fAg;
    
    public b(LinkedList<ejo> paramLinkedList, Activity paramActivity, String paramString)
    {
      this.commentList = paramLinkedList;
      this.KQt = paramActivity;
      this.activity = paramString;
      Object localObject;
      this.fAg = localObject;
    }
    
    public final int getCount()
    {
      int i = 0;
      AppMethodBeat.i(98587);
      if (this.KQt.size() > 0)
      {
        if (this.commentList == null) {}
        for (;;)
        {
          AppMethodBeat.o(98587);
          return i + 1;
          i = this.commentList.size();
        }
      }
      if (this.commentList == null)
      {
        AppMethodBeat.o(98587);
        return 0;
      }
      i = this.commentList.size();
      AppMethodBeat.o(98587);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(98588);
      int i = paramInt;
      if (this.KQt.size() > 0)
      {
        if (paramInt == 0)
        {
          paramView = SnsCommentDetailUI.J(SnsCommentDetailUI.this);
          AppMethodBeat.o(98588);
          return paramView;
        }
        i = paramInt - 1;
      }
      Object localObject3 = (ejo)this.commentList.get(i);
      ((ejo)localObject3).lpy = Util.nullAsNil(((ejo)localObject3).lpy);
      View localView;
      if ((paramView == null) || (!(paramView.getTag() instanceof a)))
      {
        localView = com.tencent.mm.ui.ad.kS(this.activity).inflate(i.g.sns_comment_detail_item, null);
        localView.setOnTouchListener(SnsCommentDetailUI.K(SnsCommentDetailUI.this));
        paramViewGroup = new a();
        paramViewGroup.iZG = ((ImageView)localView.findViewById(i.f.album_comment_avatar_iv));
        paramViewGroup.iZG.setOnClickListener(SnsCommentDetailUI.L(SnsCommentDetailUI.this));
        paramViewGroup.mZA = ((TextView)localView.findViewById(i.f.album_comment_nick_tv));
        paramViewGroup.mZA.setOnTouchListener(new ah());
        paramViewGroup.mZA.setOnClickListener(new SnsCommentDetailUI.b.1(this));
        paramViewGroup.timeTv = ((TextView)localView.findViewById(i.f.album_comment_time_tv));
        paramViewGroup.kMh = ((TextView)localView.findViewById(i.f.album_comment_content_tv));
        paramViewGroup.KQv = ((FrameLayout)localView.findViewById(i.f.album_comment_content_fl));
        paramViewGroup.kMh.setOnTouchListener(new ah());
        paramViewGroup.KQw = ((SnsTranslateResultView)localView.findViewById(i.f.sns_translate_result_view));
        paramViewGroup.KQw.setVisibility(8);
        paramViewGroup.KQy = ((EmojiStatusView)localView.findViewById(i.f.album_comment_emoji_view));
        if (SnsCommentDetailUI.E(SnsCommentDetailUI.this) != 10) {
          break label2014;
        }
        localView.findViewById(i.f.comment_view_parent).setBackgroundResource(i.e.friendactivity_comment_detail_list_golden);
      }
      label446:
      label855:
      label2011:
      label2014:
      for (;;)
      {
        paramViewGroup.KQx = ((ejo)localObject3);
        paramViewGroup.userName = ((ejo)localObject3).Username;
        ((SnsAvatarImageView)paramViewGroup.iZG).gp(((ejo)localObject3).Username, 3);
        ((SnsAvatarImageView)paramViewGroup.iZG).setWeakContext(this.activity);
        label376:
        label505:
        SnsInfo localSnsInfo;
        if (SnsCommentDetailUI.E(SnsCommentDetailUI.this) == 10)
        {
          paramInt = 3;
          SnsCommentDetailUI.E(SnsCommentDetailUI.this);
          com.tencent.mm.kernel.h.aHH();
          paramView = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwg(paramViewGroup.userName);
          if ((i != 0) || (!this.KQt.isEmpty())) {
            break label1660;
          }
          if (SnsCommentDetailUI.E(SnsCommentDetailUI.this) != 10) {
            break label1649;
          }
          localView.setBackgroundResource(i.e.friendactivity_comment_detail_list_golden_arror);
          if (i != 0) {
            break label1694;
          }
          localView.findViewById(i.f.sns_comment_left_icon).setVisibility(0);
          localView.findViewById(i.f.sns_comment_line).setVisibility(8);
          if (SnsCommentDetailUI.E(SnsCommentDetailUI.this) == 10) {
            ((ImageView)localView.findViewById(i.f.sns_comment_left_icon)).setImageResource(i.i.friendactivity_writeicon_golden);
          }
          localSnsInfo = com.tencent.mm.plugin.sns.storage.f.bbk(SnsCommentDetailUI.m(SnsCommentDetailUI.this));
          paramViewGroup.iZG.setTag(((ejo)localObject3).Username);
          if (!com.tencent.mm.plugin.sns.ui.widget.e.a(paramViewGroup.iZG, localSnsInfo, ((ejo)localObject3).Username)) {
            com.tencent.mm.pluginsdk.ui.a.b.C(paramViewGroup.iZG, ((ejo)localObject3).Username);
          }
          if (paramView == null) {
            break label1721;
          }
          paramView = paramView.ays();
          if (!com.tencent.mm.plugin.sns.ui.widget.e.b(localSnsInfo, ((ejo)localObject3).Username)) {
            break label2011;
          }
          paramView = com.tencent.mm.plugin.sns.ui.widget.e.d(localSnsInfo.getAdXml(), paramView);
        }
        for (;;)
        {
          String str;
          CharSequence localCharSequence;
          Object localObject2;
          Object localObject1;
          label764:
          int j;
          long l;
          if (localSnsInfo != null)
          {
            str = localSnsInfo.field_userName;
            paramViewGroup.kMh.setText(((ejo)localObject3).lpy + " ");
            localCharSequence = com.tencent.mm.plugin.sns.ui.widget.e.a(SnsCommentDetailUI.this, (ejo)localObject3, SnsCommentDetailUI.M(SnsCommentDetailUI.this), localSnsInfo.field_type, localSnsInfo.getUserName(), 2, SnsCommentDetailUI.N(SnsCommentDetailUI.this), SnsCommentDetailUI.O(SnsCommentDetailUI.this), localSnsInfo);
            localObject2 = null;
            localObject1 = localObject2;
            if (!Util.isNullOrNil(((ejo)localObject3).Uls))
            {
              localObject1 = localObject2;
              if (((ejo)localObject3).Uls.get(0) != null)
              {
                localObject1 = ((eju)((ejo)localObject3).Uls.get(0)).Md5;
                localObject1 = bj.hyV().VFH.bxK((String)localObject1);
              }
            }
            if (localObject1 != null) {
              break label1747;
            }
            paramViewGroup.KQy.setVisibility(8);
            paramViewGroup.KQy.setEmojiInfo(null);
            paramViewGroup.mZA.setText(paramView, TextView.BufferType.SPANNABLE);
            com.tencent.mm.pluginsdk.ui.span.l.q(paramViewGroup.mZA, paramInt);
            localObject1 = new com.tencent.mm.pluginsdk.ui.span.m(paramViewGroup.mZA.getText());
            Log.i("MicroMsg.SnsCommentDetailUI", "test %s,%s", new Object[] { ((ejo)localObject3).Username, paramView });
            if (!com.tencent.mm.plugin.sns.ui.widget.e.b(localSnsInfo, ((ejo)localObject3).Username)) {
              break label1841;
            }
            if (!com.tencent.mm.plugin.sns.ui.widget.e.ki(((ejo)localObject3).Ulr, 32)) {
              break label1835;
            }
            j = 27;
            ((com.tencent.mm.pluginsdk.ui.span.m)localObject1).a(new com.tencent.mm.pluginsdk.ui.span.q(new com.tencent.mm.plugin.sns.data.d(localSnsInfo.isAd(), ((ejo)localObject3).Username, localSnsInfo.getLocalid(), 2, j), SnsCommentDetailUI.M(SnsCommentDetailUI.this), paramInt), paramView, 0);
            paramViewGroup.mZA.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
            l = ((ejo)localObject3).CreateTime;
            if (com.tencent.mm.plugin.sns.ui.widget.e.ki(((ejo)localObject3).Ulr, 32)) {
              l = localSnsInfo.getCreateTime();
            }
            paramViewGroup.timeTv.setText(bo.t(this.activity, l * 1000L));
            if (!Util.isNullOrNil(localCharSequence)) {
              break label1871;
            }
            paramViewGroup.kMh.setVisibility(8);
            label993:
            SnsCommentDetailUI.P(SnsCommentDetailUI.this).c(localView, SnsCommentDetailUI.D(SnsCommentDetailUI.this).Lpc, SnsCommentDetailUI.D(SnsCommentDetailUI.this).LoP);
            SnsCommentDetailUI.P(SnsCommentDetailUI.this).c(paramViewGroup.KQv, SnsCommentDetailUI.D(SnsCommentDetailUI.this).Lpc, SnsCommentDetailUI.D(SnsCommentDetailUI.this).LoP);
            if (((ejo)localObject3).Uln == 0) {
              break label1930;
            }
            l = ((ejo)localObject3).Uln;
            localObject2 = at.kE(SnsCommentDetailUI.m(SnsCommentDetailUI.this), String.valueOf(l));
            if ((at.gf((String)localObject2, 4)) && (paramViewGroup.KQw != null))
            {
              localObject2 = at.bal((String)localObject2);
              if (localObject2 == null) {
                break label1963;
              }
              paramViewGroup.KQw.setVisibility(0);
              if (!((at.b)localObject2).lwF) {
                break label1952;
              }
              if (((at.b)localObject2).lAQ) {
                break label1940;
              }
              paramViewGroup.KQw.a((at.b)localObject2, 2, ((at.b)localObject2).result, ((at.b)localObject2).brand, ((at.b)localObject2).Kak);
            }
            localView.setClickable(true);
            Log.d("MicroMsg.SnsCommentDetailUI", "position " + ((ejo)localObject3).Username + " self " + SnsCommentDetailUI.s(SnsCommentDetailUI.this) + " commentid " + ((ejo)localObject3).Uln + " snsid " + SnsCommentDetailUI.m(SnsCommentDetailUI.this));
            if (!SnsCommentDetailUI.s(SnsCommentDetailUI.this).equals(((ejo)localObject3).Username)) {
              break label1975;
            }
          }
          for (paramViewGroup.info = localObject3;; paramViewGroup.info = new Object[] { Integer.valueOf(i), localObject3, ((ejo)localObject3).Username, paramView })
          {
            paramView = new m(SnsCommentDetailUI.j(SnsCommentDetailUI.this), SnsCommentDetailUI.m(SnsCommentDetailUI.this), (ejo)localObject3, ((ejo)localObject3).Username, ((ejo)localObject3).lpy, paramViewGroup.kMh, 2, str);
            paramView.tag = paramViewGroup;
            localView.setTag(paramView);
            paramViewGroup.kMh.setTag(paramView);
            localView.setOnClickListener(SnsCommentDetailUI.Q(SnsCommentDetailUI.this));
            localObject2 = new com.tencent.mm.pluginsdk.ui.span.o(SnsCommentDetailUI.this);
            if (com.tencent.mm.plugin.sns.ui.widget.e.b(localSnsInfo, ((ejo)localObject3).Username))
            {
              ((com.tencent.mm.pluginsdk.ui.span.o)localObject2).setAdTagClickCallback(SnsCommentDetailUI.R(SnsCommentDetailUI.this), 0);
              ((com.tencent.mm.pluginsdk.ui.span.o)localObject2).mAdTagClickScene = 31;
            }
            paramViewGroup.kMh.setOnTouchListener((View.OnTouchListener)localObject2);
            paramViewGroup.KQv.setTag(paramView);
            paramViewGroup.KQv.setOnClickListener(SnsCommentDetailUI.Q(SnsCommentDetailUI.this));
            if ((!localSnsInfo.isAd()) && (((ejo)localObject3).DeleteFlag > 0))
            {
              ((com.tencent.mm.pluginsdk.ui.span.m)localObject1).setSpan(new ForegroundColorSpan(SnsCommentDetailUI.this.getContext().getResources().getColor(i.c.BW_50)), 0, ((com.tencent.mm.pluginsdk.ui.span.m)localObject1).length(), 33);
              paramViewGroup.mZA.setText((CharSequence)localObject1);
              paramView = paramViewGroup.kMh;
              localObject1 = SnsCommentDetailUI.this.getContext();
              localObject2 = ((Context)localObject1).getResources().getString(i.j.sns_comment_deleted);
              localObject3 = new SpannableStringBuilder((CharSequence)localObject2);
              ((SpannableStringBuilder)localObject3).setSpan(new ForegroundColorSpan(((Context)localObject1).getResources().getColor(i.c.BW_50)), 0, ((String)localObject2).length(), 0);
              ((SpannableStringBuilder)localObject3).setSpan(new BackgroundColorSpan(((Context)localObject1).getResources().getColor(i.c.BW_90)), 0, ((String)localObject2).length(), 0);
              paramView.setText((CharSequence)localObject3);
              paramViewGroup.kMh.setOnTouchListener(null);
              paramViewGroup.KQv.setOnLongClickListener(null);
              paramViewGroup.KQv.setOnClickListener(null);
              localView.setOnClickListener(null);
              localView.setOnLongClickListener(null);
            }
            AppMethodBeat.o(98588);
            return localView;
            paramViewGroup = (a)paramView.getTag();
            localView = paramView;
            break;
            paramInt = 2;
            break label376;
            label1649:
            localView.setBackgroundResource(i.e.friendactivity_comment_list_normal);
            break label446;
            label1660:
            if (SnsCommentDetailUI.E(SnsCommentDetailUI.this) == 10)
            {
              localView.setBackgroundResource(i.e.sns_comment_detail_item_bg_golden);
              break label446;
            }
            localView.setBackgroundResource(i.e.sns_comment_detail_item_bg);
            break label446;
            localView.findViewById(i.f.sns_comment_left_icon).setVisibility(4);
            localView.findViewById(i.f.sns_comment_line).setVisibility(0);
            break label505;
            if (((ejo)localObject3).Nickname != null)
            {
              paramView = ((ejo)localObject3).Nickname;
              break label567;
            }
            paramView = ((ejo)localObject3).Username;
            break label567;
            localObject2 = new m(SnsCommentDetailUI.j(SnsCommentDetailUI.this), SnsCommentDetailUI.m(SnsCommentDetailUI.this), (ejo)localObject3, ((ejo)localObject3).Username, ((ejo)localObject3).lpy, paramViewGroup.kMh, 2, str);
            paramViewGroup.KQy.setTag(localObject2);
            paramViewGroup.KQy.setVisibility(0);
            paramViewGroup.KQy.setEmojiInfo((EmojiInfo)localObject1);
            paramViewGroup.KQy.setOnClickListener(SnsCommentDetailUI.D(SnsCommentDetailUI.this).Lpv);
            break label764;
            j = 2;
            break label855;
            ((com.tencent.mm.pluginsdk.ui.span.m)localObject1).a(new com.tencent.mm.pluginsdk.ui.span.q(((ejo)localObject3).Username, SnsCommentDetailUI.M(SnsCommentDetailUI.this), paramInt), paramView, 0);
            break label902;
            localObject2 = new SpannableStringBuilder(localCharSequence);
            ((SpannableStringBuilder)localObject2).append(" ");
            paramViewGroup.kMh.setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
            paramViewGroup.kMh.setVisibility(0);
            localObject2 = com.tencent.mm.plugin.sns.i.a.KeP;
            a.a.a(paramViewGroup.kMh, paramViewGroup.KQx);
            break label993;
            l = ((ejo)localObject3).Ulp;
            break label1075;
            paramViewGroup.KQw.setVisibility(8);
            break label1169;
            paramViewGroup.KQw.aht(2);
            break label1169;
            paramViewGroup.KQw.setVisibility(8);
            break label1169;
          }
        }
      }
    }
    
    final class a
    {
      FrameLayout KQv;
      SnsTranslateResultView KQw;
      ejo KQx;
      EmojiStatusView KQy;
      ImageView iZG;
      Object info;
      TextView kMh;
      TextView mZA;
      TextView timeTv;
      String userName;
      
      a() {}
    }
  }
  
  final class c
    implements Runnable
  {
    private int KQA = 10;
    private int KQz = -1;
    int QB = -1;
    int bwU;
    private int offset = 0;
    
    c() {}
    
    public final void run()
    {
      AppMethodBeat.i(98589);
      this.KQA = 10;
      SnsCommentDetailUI.b(SnsCommentDetailUI.this);
      this.KQz = SnsCommentDetailUI.c(SnsCommentDetailUI.this).getTop();
      int i = this.KQz - this.bwU;
      Log.i("MicroMsg.SnsCommentDetailUI", "list.bottom: %d, listOriginalBottom: %d, footerTop: %d, commentFooter.getTop: %d, topSelection: %d", new Object[] { Integer.valueOf(SnsCommentDetailUI.a(SnsCommentDetailUI.this).getBottom()), Integer.valueOf(SnsCommentDetailUI.d(SnsCommentDetailUI.this)), Integer.valueOf(this.KQz), Integer.valueOf(SnsCommentDetailUI.c(SnsCommentDetailUI.this).getTop()), Integer.valueOf(i) });
      if (i == this.offset)
      {
        SnsCommentDetailUI.a(SnsCommentDetailUI.this).setSelectionFromTop(SnsCommentDetailUI.a(SnsCommentDetailUI.this).getHeaderViewsCount() + this.QB, i);
        this.KQA = 0;
        this.offset = 0;
        AppMethodBeat.o(98589);
        return;
      }
      int j = this.KQA;
      this.KQA = (j - 1);
      if (j > 0)
      {
        new MMHandler().postDelayed(this, 100L);
        this.offset = i;
        AppMethodBeat.o(98589);
        return;
      }
      this.offset = 0;
      this.KQA = 0;
      AppMethodBeat.o(98589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI
 * JD-Core Version:    0.7.0.1
 */