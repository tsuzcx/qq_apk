package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.Guideline;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.g.a.iq;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.g.a.va;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.g.a.wk;
import com.tencent.mm.g.a.wl;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.b.a.ih;
import com.tencent.mm.g.b.a.iu;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.i.a.a;
import com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq.a;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.au.b;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cli;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzu;
import com.tencent.mm.protocal.protobuf.ear;
import com.tencent.mm.protocal.protobuf.eyd;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
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
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.kernel.i
public class SnsCommentDetailUI
  extends MMSecDataActivity
  implements com.tencent.mm.ak.i, i.a, c.b, ab
{
  private static com.tencent.mm.av.a.a.c EBQ;
  private static com.tencent.mm.av.a.a.c EBR;
  public static int EBs;
  private static com.tencent.mm.loader.c.d<String, Bitmap> uIN;
  private LinearLayout DGk;
  private boolean DKd;
  private boolean DKf;
  private com.tencent.mm.plugin.sns.ui.d.c Dyw;
  private long EAN;
  private long EAO;
  private View EAP;
  private TextView EAQ;
  private LinearLayout EAR;
  private SnsDetailLuckyHeader EAS;
  private ListView EAT;
  private View EAU;
  private View EAV;
  private b EAW;
  private ScaleAnimation EAX;
  private ScaleAnimation EAY;
  LinearLayout EAZ;
  private boolean EBA;
  private String EBB;
  private boolean EBC;
  private int EBD;
  private boolean EBE;
  private int EBF;
  private n EBG;
  private TextView EBH;
  private boolean EBI;
  private FrameLayout EBJ;
  private com.tencent.mm.ui.blur.f EBK;
  private ak EBL;
  private IListener EBM;
  private IListener EBN;
  private IListener EBO;
  private IListener EBP;
  private d EBS;
  private View.OnClickListener EBT;
  private IListener EBU;
  private IListener EBV;
  boolean EBW;
  private LinearLayout EBX;
  private boolean EBY;
  PhotosContent EBZ;
  LinearLayout EBa;
  private LinkedList<dzo> EBb;
  private int EBc;
  private boolean EBd;
  private be EBe;
  private String EBf;
  private bv EBg;
  private int EBh;
  private ImageView EBi;
  private WeImageView EBj;
  private j EBk;
  private l EBl;
  private boolean EBm;
  private long EBn;
  private br EBo;
  private boolean EBp;
  private int EBq;
  private int EBr;
  public int EBt;
  private com.tencent.mm.plugin.sns.ui.c.a.a EBu;
  public com.tencent.mm.plugin.sns.ad.g.k EBv;
  private SnsTranslateResultView EBw;
  private boolean EBx;
  private Dialog EBy;
  private boolean EBz;
  int ECa;
  public ay.b.a ECb;
  private bq ECc;
  private boolean EoG;
  private SnsCommentFooter EoJ;
  private bb EoL;
  private b EoR;
  private com.tencent.mm.plugin.sns.h.b EoS;
  private ap EoT;
  private bu EoU;
  private com.tencent.mm.ui.base.q EoW;
  private IListener EoY;
  private View.OnTouchListener EqE;
  private volatile boolean ExJ;
  private ScreenShotUtil.ScreenShotCallback EyL;
  private String dRS;
  private String dSF;
  private String gna;
  private IListener lEl;
  private com.tencent.mm.pluginsdk.ui.span.a mAdTagClickCallback;
  private int mScreenHeight;
  private int mScreenWidth;
  private boolean mci;
  private int oUs;
  private com.tencent.mm.ui.widget.b.a pqr;
  private View.OnClickListener pri;
  private View.OnClickListener qOH;
  private int qcr;
  
  static
  {
    AppMethodBeat.i(163117);
    EBs = 34;
    c.a locala = new c.a();
    locala.jbf = true;
    locala.jbd = true;
    EBQ = locala.bdv();
    uIN = new SnsCommentDetailUI.44();
    locala = new c.a();
    locala.jbf = true;
    locala.jbd = true;
    EBR = locala.bdv();
    AppMethodBeat.o(163117);
  }
  
  public SnsCommentDetailUI()
  {
    AppMethodBeat.i(98590);
    this.EAN = 0L;
    this.EAO = 0L;
    this.EBc = -1;
    this.EBd = false;
    this.EqE = Util.genLinearPressedListener();
    this.EoW = null;
    this.oUs = 0;
    this.EBh = 0;
    this.mci = false;
    this.dSF = "";
    this.EBm = false;
    this.EBn = 0L;
    this.EBp = false;
    this.EBr = 103;
    this.EBt = 210;
    this.EBx = false;
    this.EBy = null;
    this.EBz = false;
    this.EBA = false;
    this.EBB = "";
    this.EBC = true;
    this.EBE = false;
    this.EBF = 0;
    this.DKd = false;
    this.DKf = false;
    this.EBG = null;
    this.EBH = null;
    this.ExJ = false;
    this.EBK = null;
    this.EBL = new ak();
    this.EBM = new IListener() {};
    this.EBN = new IListener() {};
    this.EBO = new IListener() {};
    this.EBP = new IListener() {};
    this.EoY = new IListener() {};
    this.EBS = new d();
    this.pri = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(98579);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        localObject1 = (String)paramAnonymousView.getTag();
        Log.d("MicroMsg.SnsCommentDetailUI", "onCommentClick:".concat(String.valueOf(localObject1)));
        SnsInfo localSnsInfo = SnsCommentDetailUI.a(SnsCommentDetailUI.this, true);
        if ((localSnsInfo != null) && (localSnsInfo.isAd()))
        {
          SnsAdClick localSnsAdClick = new SnsAdClick(SnsCommentDetailUI.this.getSource(), 2, localSnsInfo.field_snsId, 1, 0);
          com.tencent.mm.plugin.sns.data.k.a(localSnsAdClick, SnsCommentDetailUI.e(SnsCommentDetailUI.this), localSnsInfo, 1);
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
                  paramAnonymousView = com.tencent.mm.plugin.sns.data.r.kb((String)localObject1, ((ADInfo)localObject3).uxInfo);
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
                com.tencent.mm.plugin.sns.c.a.jRt.i((Intent)localObject1, SnsCommentDetailUI.this);
                com.tencent.mm.plugin.sns.data.r.a(localSnsAdClick);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98579);
                return;
              }
              localObject2 = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
              ((com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject2).put("ext_sns_ad_click", localSnsAdClick);
              Object localObject3 = com.tencent.mm.plugin.sns.ad.timeline.a.a.d(1, SnsCommentDetailUI.this);
              if ((localObject3 != null) && (((com.tencent.mm.plugin.sns.ad.timeline.a.c)localObject3).a(paramAnonymousView, SnsCommentDetailUI.this.getSource(), localSnsInfo, (com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject2)))
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98579);
                return;
              }
            }
          }
          com.tencent.mm.plugin.sns.data.r.a(localSnsAdClick);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", (String)localObject1);
          paramAnonymousView.putExtra("Contact_Scene", 37);
          com.tencent.mm.plugin.sns.c.a.jRt.c(paramAnonymousView, SnsCommentDetailUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98579);
          return;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", (String)localObject1);
        com.tencent.mm.plugin.sns.c.a.jRt.c(paramAnonymousView, SnsCommentDetailUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98579);
      }
    };
    this.EBT = new SnsCommentDetailUI.46(this);
    this.qOH = new SnsCommentDetailUI.3(this);
    this.EBU = new SnsCommentDetailUI.8(this);
    this.lEl = new IListener() {};
    this.EBV = new SnsCommentDetailUI.10(this);
    this.EyL = new ScreenShotUtil.ScreenShotCallback()
    {
      public final void onScreenShot(String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(203504);
        Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onScreenShot， path = " + paramAnonymousString + "， dateAdded = " + paramAnonymousLong);
        SnsCommentDetailUI.u(SnsCommentDetailUI.this);
        AppMethodBeat.o(203504);
      }
    };
    this.EBW = false;
    this.EBX = null;
    this.EBY = false;
    this.EBZ = null;
    this.ECa = 0;
    this.ECb = new SnsCommentDetailUI.22(this);
    this.ECc = null;
    this.mAdTagClickCallback = new com.tencent.mm.pluginsdk.ui.span.a()
    {
      public final void iL(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(203517);
        try
        {
          SnsInfo localSnsInfo = SnsCommentDetailUI.a(SnsCommentDetailUI.this, false);
          if (localSnsInfo != null)
          {
            Log.i("AdTagClickableHelper", "In SnsCommentDetailUI, snsId = " + localSnsInfo.field_snsId + ", source = " + SnsCommentDetailUI.this.getSource() + ", clickPos = " + paramAnonymousInt2);
            com.tencent.mm.plugin.sns.ad.timeline.b.b.a(SnsCommentDetailUI.this, SnsCommentDetailUI.this.getSource(), localSnsInfo, paramAnonymousInt2);
            AppMethodBeat.o(203517);
            return;
          }
          Log.e("AdTagClickableHelper", "In SnsCommentDetailUI, snsInfo is null");
          AppMethodBeat.o(203517);
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.e("AdTagClickableHelper", localThrowable.toString());
          AppMethodBeat.o(203517);
        }
      }
    };
    AppMethodBeat.o(98590);
  }
  
  private LinearLayout ZH(int paramInt)
  {
    AppMethodBeat.i(98601);
    if (this.EBX == null)
    {
      this.EBX = ((LinearLayout)aa.jQ(this).inflate(paramInt, null));
      localLinearLayout = this.EBX;
      AppMethodBeat.o(98601);
      return localLinearLayout;
    }
    this.EBW = true;
    LinearLayout localLinearLayout = this.EBX;
    AppMethodBeat.o(98601);
    return localLinearLayout;
  }
  
  private static void a(SnsInfo paramSnsInfo, PhotosContent paramPhotosContent, int paramInt)
  {
    AppMethodBeat.i(203543);
    if ((paramSnsInfo != null) && (paramSnsInfo.isAd()) && (paramInt == 2))
    {
      FrameLayout.LayoutParams localLayoutParams = null;
      try
      {
        paramSnsInfo = paramSnsInfo.getAdXml();
        if ((paramSnsInfo != null) && (paramSnsInfo.isShowPlayIconOnCover()))
        {
          paramSnsInfo = paramPhotosContent.findViewById(2131308398);
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
          paramPhotosContent = (FrameLayout.LayoutParams)paramPhotosContent.ZD(0).getLayoutParams();
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
          AppMethodBeat.o(203543);
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
      AppMethodBeat.o(203543);
      return;
    }
  }
  
  private void a(PhotosContent paramPhotosContent)
  {
    AppMethodBeat.i(203539);
    if (paramPhotosContent == null)
    {
      AppMethodBeat.o(203539);
      return;
    }
    try
    {
      ImageView localImageView = new ImageView(getContext());
      int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
      int j = com.tencent.mm.cb.a.fromDPToPix(getContext(), 4);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
      localLayoutParams.leftMargin = j;
      localLayoutParams.topMargin = j;
      localImageView.setImageDrawable(com.tencent.mm.cb.a.l(getContext(), 2131235696));
      localImageView.setLayoutParams(localLayoutParams);
      paramPhotosContent.addView(localImageView);
      AppMethodBeat.o(203539);
      return;
    }
    catch (Throwable paramPhotosContent)
    {
      Log.e("MicroMsg.SnsCommentDetailUI", paramPhotosContent.toString());
      AppMethodBeat.o(203539);
    }
  }
  
  private void a(PhotosContent paramPhotosContent, int paramInt)
  {
    AppMethodBeat.i(203540);
    if ((paramPhotosContent == null) || (paramInt <= 1))
    {
      Log.e("MicroMsg.SnsCommentDetailUI", "photosContent == null or imgNums <= 1");
      AppMethodBeat.o(203540);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = com.tencent.mm.cb.a.fromDPToPix(getContext(), 20);
        i = 0;
        if (i < paramInt) {
          if (paramPhotosContent.ZD(i).getVisibility() == 8)
          {
            Log.i("MicroMsg.SnsCommentDetailUI", "current index " + i + " imageView is a placeholder, so visibility is gone");
          }
          else
          {
            ImageView localImageView = com.tencent.mm.plugin.sns.ad.timeline.b.c.a(getContext(), paramPhotosContent, i, j);
            if (localImageView != null) {
              paramPhotosContent.addView(localImageView);
            }
          }
        }
      }
      catch (Throwable paramPhotosContent)
      {
        Log.e("MicroMsg.SnsCommentDetailUI", paramPhotosContent.toString());
        AppMethodBeat.o(203540);
        return;
      }
      AppMethodBeat.o(203540);
      return;
      i += 1;
    }
  }
  
  private boolean a(SnsInfo paramSnsInfo, SnsAdTimelineVideoView paramSnsAdTimelineVideoView)
  {
    AppMethodBeat.i(203542);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramSnsAdTimelineVideoView != null)
    {
      bool1 = bool2;
      if (this.EBI)
      {
        bool1 = bool2;
        if (paramSnsInfo != null)
        {
          bool1 = bool2;
          if (paramSnsInfo.isAd()) {
            bool1 = true;
          }
        }
      }
    }
    Log.i("MicroMsg.SnsCommentDetailUI", "the useNewPlayer return value is ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(203542);
    return bool1;
  }
  
  private void f(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(98603);
    if (this.EBH == null)
    {
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
      this.EBH = new TextView(this);
      this.EBH.setLayoutParams(localLayoutParams);
      this.EBH.setText(getString(2131766025));
      this.EBH.setTextColor(getResources().getColor(2131100904));
      this.EBH.setGravity(17);
      this.EBH.setPadding(0, BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 7.0F), 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 12.0F));
      this.EBH.setVisibility(8);
      this.EAT.addFooterView(this.EBH);
    }
    if (paramSnsInfo != null)
    {
      if ((paramSnsInfo.getLocalPrivate() & 0x1) != 0)
      {
        findViewById(2131298947).setVisibility(8);
        paramSnsInfo = paramSnsInfo.getTimeLine();
        if (paramSnsInfo != null) {
          switch (paramSnsInfo.ContentObj.LoU)
          {
          }
        }
        for (;;)
        {
          this.EBH.setVisibility(0);
          AppMethodBeat.o(98603);
          return;
          this.EBH.setText(getString(2131766026));
          continue;
          this.EBH.setText(getString(2131766029));
          continue;
          this.EBH.setText(getString(2131766027));
        }
      }
      if (paramBoolean) {
        findViewById(2131298947).setVisibility(0);
      }
      this.EBH.setVisibility(8);
    }
    AppMethodBeat.o(98603);
  }
  
  private static boolean f(LinkedList<dzo> paramLinkedList1, LinkedList<dzo> paramLinkedList2)
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
      if (!((dzo)paramLinkedList1.get(i)).Username.equals(((dzo)paramLinkedList2.get(i)).Username))
      {
        AppMethodBeat.o(98591);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(98591);
    return true;
  }
  
  private int fhN()
  {
    AppMethodBeat.i(98600);
    if ((this.EAT != null) && (this.EAT.getChildCount() > 1))
    {
      View localView = this.EAT.getChildAt(0);
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
  
  private static boolean fhO()
  {
    AppMethodBeat.i(98602);
    if ((aq.a.fbx() & 0x1) <= 0)
    {
      AppMethodBeat.o(98602);
      return true;
    }
    AppMethodBeat.o(98602);
    return false;
  }
  
  private void fhQ()
  {
    AppMethodBeat.i(98605);
    if ((this.EAU == null) || (this.EAU.getVisibility() == 8))
    {
      AppMethodBeat.o(98605);
      return;
    }
    this.EAU.startAnimation(this.EAY);
    this.EAY.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(203533);
        Log.d("MicroMsg.SnsCommentDetailUI", "onAnimationEnd");
        if (SnsCommentDetailUI.G(SnsCommentDetailUI.this) != null)
        {
          SnsCommentDetailUI.G(SnsCommentDetailUI.this).clearAnimation();
          SnsCommentDetailUI.G(SnsCommentDetailUI.this).setVisibility(8);
        }
        AppMethodBeat.o(203533);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    AppMethodBeat.o(98605);
  }
  
  private void fhR()
  {
    AppMethodBeat.i(98606);
    if ((keyboardState() == 1) || (this.EoJ.fhW()))
    {
      this.EBS.run();
      AppMethodBeat.o(98606);
      return;
    }
    this.EoG = true;
    AppMethodBeat.o(98606);
  }
  
  private void fhS()
  {
    AppMethodBeat.i(98607);
    if (this.EBi == null)
    {
      AppMethodBeat.o(98607);
      return;
    }
    this.EBi.setPressed(false);
    if (br.aMJ(this.dSF))
    {
      this.EBi.setImageResource(2131234170);
      AppMethodBeat.o(98607);
      return;
    }
    this.EBi.setImageResource(2131234185);
    AppMethodBeat.o(98607);
  }
  
  @SuppressLint({"ResourceType"})
  private void fhT()
  {
    AppMethodBeat.i(203541);
    if (this.EBj == null)
    {
      AppMethodBeat.o(203541);
      return;
    }
    this.EBj.setPressed(false);
    if (br.aMJ(this.dSF)) {
      this.EBj.setImageResource(2131690862);
    }
    for (;;)
    {
      this.EBj.setIconColor(getContext().getResources().getColor(2131100044));
      AppMethodBeat.o(203541);
      return;
      this.EBj.setImageResource(2131690885);
    }
  }
  
  private ADInfo g(SnsInfo paramSnsInfo)
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
  
  private boolean n(List<dzo> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(98608);
    int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 32.0F);
    int m = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 6.0F);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 10.0F);
    int j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 17.0F);
    if (this.EAR == null)
    {
      AppMethodBeat.o(98608);
      return false;
    }
    int n = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    float f = getResources().getDimension(2131165534);
    Log.d("MicroMsg.SnsCommentDetailUI", "guess size %d %f", new Object[] { Integer.valueOf(n), Float.valueOf(f) });
    f = n - f * 2.0F;
    if (paramList.size() <= 0)
    {
      if (this.EAR.getParent() != null) {
        this.EAR.setVisibility(8);
      }
      this.EAR.removeAllViews();
      this.EAR.setVisibility(8);
      this.DGk.setVisibility(8);
      AppMethodBeat.o(98608);
      return false;
    }
    this.EAR.getParent();
    this.EAR.removeAllViews();
    this.EAR.setVisibility(0);
    Object localObject1;
    if (this.qcr == 10) {
      if (!this.EBx)
      {
        this.EAR.setBackgroundResource(2131232827);
        this.EAR.setPadding(0, m, 0, m);
        localObject1 = new ImageView(getContext());
        if (this.qcr != 10) {
          break label692;
        }
        ((ImageView)localObject1).setImageResource(2131690344);
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
      this.EAR.addView((View)localObject1);
      n = com.tencent.mm.cb.a.fromDPToPix(getContext(), EBs);
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
        localObject2 = (dzo)paramList.get(i);
        StoryTouchImageView localStoryTouchImageView = new StoryTouchImageView(getContext());
        localStoryTouchImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localStoryTouchImageView.setImageResource(2131232837);
        Object localObject3 = ((dzo)localObject2).Username;
        localStoryTouchImageView.EQN.fL((String)localObject3, 1);
        localObject3 = new LinearLayout.LayoutParams(k, k);
        ((LinearLayout.LayoutParams)localObject3).setMargins(0, m, m, 0);
        localStoryTouchImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localStoryTouchImageView.setTag(((dzo)localObject2).Username);
        a.b.A(localStoryTouchImageView, ((dzo)localObject2).Username);
        localStoryTouchImageView.setOnClickListener(this.pri);
        ((h)localObject1).addView(localStoryTouchImageView);
        i += 1;
      }
      localObject1 = vs(false);
      if (localObject1 != null)
      {
        if (this.gna.equals(((SnsInfo)localObject1).getUserName()))
        {
          this.EAR.setBackgroundResource(2131232828);
          break;
        }
        this.EAR.setBackgroundResource(2131232827);
        break;
      }
      this.EAR.setBackgroundResource(2131232827);
      break;
      this.EAR.setBackgroundResource(2131232835);
      break;
      label692:
      ((ImageView)localObject1).setImageDrawable(com.tencent.mm.ui.ar.m(getContext(), 2131690343, getContext().getResources().getColor(2131099783)));
    }
    this.EAR.addView((View)localObject1);
    paramList = this.DGk;
    if (paramBoolean) {}
    for (i = 8;; i = 0)
    {
      paramList.setVisibility(i);
      AppMethodBeat.o(98608);
      return true;
    }
  }
  
  private void vr(boolean paramBoolean)
  {
    AppMethodBeat.i(98592);
    this.EBd = false;
    if (this.EoJ.fhV())
    {
      this.EoJ.ECO = 0;
      this.EoJ.fhY();
      this.EoJ.setCommentHint(getString(2131766285));
    }
    this.EoJ.vt(false);
    if (paramBoolean)
    {
      Object localObject1 = this.EAT;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "scrollDown", "(Z)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
      BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "scrollDown", "(Z)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    }
    AppMethodBeat.o(98592);
  }
  
  private SnsInfo vs(boolean paramBoolean)
  {
    AppMethodBeat.i(98593);
    SnsInfo localSnsInfo;
    if (!Util.isNullOrNil(this.EBf))
    {
      localSnsInfo = com.tencent.mm.plugin.sns.storage.f.aQm(this.EBf);
      if (localSnsInfo == null)
      {
        if (paramBoolean) {
          Toast.makeText(this, 2131766142, 0).show();
        }
        finish();
        AppMethodBeat.o(98593);
        return null;
      }
      this.dRS = localSnsInfo.getSnsId();
    }
    for (;;)
    {
      AppMethodBeat.o(98593);
      return localSnsInfo;
      localSnsInfo = com.tencent.mm.plugin.sns.storage.f.aQl(this.dRS);
      if (localSnsInfo == null)
      {
        finish();
        AppMethodBeat.o(98593);
        return null;
      }
      this.EBf = localSnsInfo.getLocalid();
    }
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void aOG(String paramString) {}
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void ci(String paramString, boolean paramBoolean) {}
  
  public final void cj(String paramString, boolean paramBoolean) {}
  
  public final void eZJ() {}
  
  public final ap ffr()
  {
    return this.EoT;
  }
  
  public final b ffs()
  {
    return this.EoR;
  }
  
  public final bs fft()
  {
    return null;
  }
  
  public final bu ffu()
  {
    return this.EoU;
  }
  
  @SuppressLint({"ResourceType"})
  final boolean fhP()
  {
    AppMethodBeat.i(98604);
    final SnsInfo localSnsInfo = vs(true);
    if (localSnsInfo == null)
    {
      AppMethodBeat.o(98604);
      return false;
    }
    Log.i("MicroMsg.SnsCommentDetailUI", "setheader " + this.EAP.toString());
    this.EBq = com.tencent.mm.plugin.sns.model.aj.fbb();
    Object localObject8 = localSnsInfo.getTimeLine();
    this.qcr = bk.g(localSnsInfo, false);
    Object localObject1 = (SnsAvatarImageView)this.EAP.findViewById(2131296609);
    Object localObject5 = (RelativeLayout)this.EAP.findViewById(2131305636);
    ((RelativeLayout)localObject5).setVisibility(8);
    ((RelativeLayout)localObject5).setOnClickListener(this.Dyw.FaV);
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
    ((MaskImageButton)localObject1).ico = localSnsInfo.getLocalid();
    ((SnsAvatarImageView)localObject1).setTag(localSnsInfo.getUserName());
    boolean bool2 = false;
    if ((localSnsInfo.getAdXml() != null) && (localSnsInfo.getAdXml().usePreferedInfo))
    {
      if (Util.isNullOrNil(localSnsInfo.getAdXml().preferAvatar)) {
        break label16234;
      }
      localObject2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kz("adId", localSnsInfo.getAdXml().preferAvatar);
      ((SnsAvatarImageView)localObject1).setTag(2131308195, localSnsInfo.getAdXml().preferAvatar);
      if (com.tencent.mm.vfs.s.YS((String)localObject2))
      {
        localObject2 = com.tencent.mm.plugin.sns.ad.g.n.Dwr.getBitmap((String)localObject2);
        if (localObject2 != null) {
          ((SnsAvatarImageView)localObject1).setImageBitmap((Bitmap)localObject2);
        }
        bool1 = true;
      }
    }
    label344:
    label3293:
    label12765:
    for (;;)
    {
      ((SnsAvatarImageView)localObject1).setOnClickListener(this.Dyw.Fas);
      localObject2 = (TextView)this.EAP.findViewById(2131305440);
      com.tencent.mm.kernel.g.aAi();
      Object localObject9 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(localSnsInfo.getUserName());
      Log.i("MicroMsg.SnsCommentDetailUI", "snsinfo username " + localSnsInfo.getUserName() + " " + localSnsInfo.getSnsId() + " " + localSnsInfo.getCreateTime() + ", isAdAndUsePreferedInfo=" + bool1);
      if ((localObject9 != null) && (((as)localObject9).arH() == 0) && (!bool1))
      {
        Log.i("MicroMsg.SnsCommentDetailUI", "getContact %s", new Object[] { localSnsInfo.getUserName() });
        ay.a.aVo().a(localSnsInfo.getUserName(), "", this.ECb);
      }
      int j = 0;
      if (localObject9 == null) {}
      Object localObject4;
      int i;
      int k;
      for (localObject1 = localSnsInfo.getUserName();; localObject1 = ((as)localObject9).arJ())
      {
        localObject1 = Util.nullAs((String)localObject1, "");
        if (!localSnsInfo.isAd()) {
          break label1671;
        }
        localObject4 = localSnsInfo.getAdXml();
        if (localObject4 == null) {
          break label16231;
        }
        if (!((ADXml)localObject4).usePreferedInfo) {
          break label1635;
        }
        localObject4 = ((ADXml)localObject4).preferNickName;
        i = 0;
        ((String)localObject4).length();
        if (this.qcr != 10) {
          break label1797;
        }
        k = 3;
        label607:
        localObject1 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(this, (CharSequence)localObject4));
        ((com.tencent.mm.pluginsdk.ui.span.m)localObject1).a(new com.tencent.mm.pluginsdk.ui.span.q(new com.tencent.mm.plugin.sns.data.b(localSnsInfo.isAd(), ((as)localObject9).getUsername(), localSnsInfo.getLocalid(), 2), this.EBk, k), (CharSequence)localObject4);
        if ((j >= 0) && (i > j)) {
          ((com.tencent.mm.pluginsdk.ui.span.m)localObject1).setSpan(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).f(this, ((as)localObject9).ajD(), this.EBF), j, i, 33);
        }
        ((TextView)localObject2).setOnTouchListener(new af());
        ((TextView)localObject2).setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        ((TextView)this.EAP.findViewById(2131309561)).setText("");
        this.ECc = new bq(this.EAP);
        if (!localSnsInfo.isAd()) {
          break label1803;
        }
        this.ECc.N(Long.valueOf(localSnsInfo.field_snsId), new com.tencent.mm.plugin.sns.data.c(this.ECc, 0, this.EBf, localSnsInfo.field_snsId, g(localSnsInfo).viewId));
        this.ECc.b(localSnsInfo.getAdXml(), g(localSnsInfo));
        this.ECc.b(this.Dyw.FaC, this.Dyw.FaS);
        this.ECc.setVisibility(0);
        label868:
        localObject1 = ((TimeLineObject)localObject8).ContentDesc;
        this.EAQ = ((TextView)this.EAP.findViewById(2131299510));
        localObject2 = new bg(this.dRS, localSnsInfo.getLocalid(), true, false, 2);
        this.EAQ.setTag(localObject2);
        this.pqr.c(this.EAQ, this.Dyw.Fau, this.Dyw.Far);
        if (!Util.isNullOrNil((String)localObject1)) {
          break label1815;
        }
        this.EAQ.setVisibility(8);
        localObject1 = (ViewStub)this.EAP.findViewById(2131302605);
        if (!this.EBY) {
          ((ViewStub)localObject1).setLayoutResource(-1);
        }
        switch (this.qcr)
        {
        case 6: 
        case 7: 
        case 8: 
        case 12: 
        case 16: 
        case 17: 
        case 22: 
        default: 
          ((ViewStub)localObject1).setVisibility(8);
          if (((ViewStub)localObject1).getLayoutResource() == -1) {
            break label2291;
          }
          localObject2 = ((ViewStub)localObject1).inflate();
          if (this.EBu != null)
          {
            this.EBu.lJI = findViewById(2131309104);
            this.EBu.n((View)localObject2, this.EAV);
            if (((this.EBu instanceof com.tencent.mm.plugin.sns.ui.c.a.c)) && (this.EBJ != null)) {
              ((com.tencent.mm.plugin.sns.ui.c.a.c)this.EBu).d(this.EBJ);
            }
          }
          this.EBY = true;
          k = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
          if (this.qcr == 6) {
            break label2843;
          }
          if ((this.qcr != 2) && (this.qcr != 3) && (this.qcr != 4) && (this.qcr != 5)) {
            break label4525;
          }
          this.EBZ = ((PhotosContent)findViewById(2131305911));
          if (this.EBZ == null) {
            break label4482;
          }
          this.EBZ.fgF();
          if (this.qcr != 2) {
            break label2301;
          }
          i = 1;
          j = 0;
          while (j < i)
          {
            localObject1 = (TagImageView)this.EBZ.findViewById(be.EGz[j]);
            this.EBZ.a((TagImageView)localObject1);
            ((TagImageView)localObject1).setOnClickListener(this.Dyw.Erh);
            this.pqr.c((View)localObject1, this.Dyw.FaF, this.Dyw.Far);
            j += 1;
          }
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localSnsInfo.getAdXml().preferAvatar, false, new f.a()
          {
            public final void aNH(String paramAnonymousString)
            {
              AppMethodBeat.i(203519);
              Log.i("MicroMsg.SnsCommentDetailUI", "download img %s", new Object[] { paramAnonymousString });
              String str = (String)this.ECk.getTag(2131308195);
              if ((!Util.isNullOrNil(new String[] { str, paramAnonymousString })) && (paramAnonymousString.equals(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kz("adId", str))))
              {
                paramAnonymousString = com.tencent.mm.plugin.sns.ad.g.n.Dwr.getBitmap(paramAnonymousString);
                if (paramAnonymousString != null) {
                  this.ECk.setImageBitmap(paramAnonymousString);
                }
              }
              AppMethodBeat.o(203519);
            }
            
            public final void eWN() {}
            
            public final void eWO()
            {
              AppMethodBeat.i(203518);
              Log.e("MicroMsg.SnsCommentDetailUI", "onDownloadError");
              AppMethodBeat.o(203518);
            }
          });
          bool1 = true;
          break label344;
          if (!localSnsInfo.getUserName().endsWith("@ad"))
          {
            if (localSnsInfo.isAd()) {}
            for (;;)
            {
              try
              {
                com.tencent.mm.kernel.g.aAi();
                localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(localSnsInfo.getUserName());
                if ((localObject2 == null) || (((as)localObject2).arH() == 0)) {
                  continue;
                }
                a.b.A((ImageView)localObject1, localSnsInfo.getUserName());
                Log.i("MicroMsg.SnsCommentDetailUI", "has contact before setAvatar, userName=" + localSnsInfo.getUserName());
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.SnsCommentDetailUI", "setAvatar exp=" + localException.toString());
                continue;
              }
              ((SnsAvatarImageView)localObject1).fL(localSnsInfo.getUserName(), 2);
              bool1 = bool2;
              if (Util.isEqual(this.gna, localSnsInfo.getUserName())) {
                break;
              }
              bool1 = bool2;
              break;
              Log.e("MicroMsg.SnsCommentDetailUI", "has no contact before setAvatar, userName=" + localSnsInfo.getUserName());
              continue;
              a.b.A((ImageView)localObject1, localSnsInfo.getUserName());
            }
          }
          bool1 = true;
          break label344;
        }
      }
      label1635:
      if ((Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(((ADXml)localObject4).nickname))) {
        localObject1 = ((ADXml)localObject4).nickname;
      }
      label3166:
      label3167:
      label3555:
      label4196:
      label7653:
      label16231:
      for (;;)
      {
        i = 0;
        localObject4 = localObject1;
        break;
        if ((localObject9 != null) && (as.bjp(((as)localObject9).getUsername())) && ("3552365301".equals(((as)localObject9).ajD())))
        {
          j = ((String)localObject1).length();
          localObject4 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).bN(((as)localObject9).ajD(), ((as)localObject9).ajC());
          localObject4 = (String)localObject1 + " @" + (String)localObject4;
          i = ((String)localObject4).length();
          ((RelativeLayout)localObject5).setTag(new com.tencent.mm.plugin.sns.data.g((View)localObject5, localSnsInfo.getLocalid()));
          ((RelativeLayout)localObject5).setVisibility(0);
          break;
          k = 2;
          break label607;
          this.ECc.setVisibility(8);
          break label868;
          this.EAQ.setText((String)localObject1 + " ");
          localObject1 = com.tencent.mm.pluginsdk.ui.span.t.grY();
          ((Bundle)localObject1).putInt("ShareScene", 3);
          ((Bundle)localObject1).putString("ShareSceneId", localSnsInfo.getUserName() + "#" + com.tencent.mm.plugin.sns.data.r.Jb(localSnsInfo.field_snsId));
          ((Bundle)localObject1).putLong("CreateTime", localSnsInfo.field_createTime);
          ((Bundle)localObject1).putInt("TimelineEnterSource", 3);
          ((Bundle)localObject1).putInt("SnsContentType", localSnsInfo.field_type);
          if (com.tencent.mm.plugin.sns.ad.timeline.b.b.V(localSnsInfo.isAd(), this.qcr)) {
            com.tencent.mm.pluginsdk.ui.span.l.a(this.EAQ, this.mAdTagClickCallback, localObject1);
          }
          for (;;)
          {
            this.EAQ.setVisibility(0);
            com.tencent.mm.plugin.sns.k.e.DUQ.fcy().ahg();
            localObject1 = com.tencent.mm.plugin.sns.i.a.DRI;
            a.a.a(localSnsInfo, this.EAQ);
            break;
            com.tencent.mm.pluginsdk.ui.span.l.a(this.EAQ, 2, 2, localObject1);
          }
          ((ViewStub)localObject1).setLayoutResource(2131496510);
          break label1107;
          ((ViewStub)localObject1).setLayoutResource(2131496507);
          break label1107;
          ((ViewStub)localObject1).setLayoutResource(2131496508);
          break label1107;
          ((ViewStub)localObject1).setLayoutResource(2131496509);
          break label1107;
          ((ViewStub)localObject1).setLayoutResource(2131496459);
          break label1107;
          ((ViewStub)localObject1).setLayoutResource(2131496442);
          break label1107;
          ((ViewStub)localObject1).setLayoutResource(2131496437);
          break label1107;
          ((ViewStub)localObject1).setLayoutResource(2131496437);
          break label1107;
          ((ViewStub)localObject1).setLayoutResource(2131496363);
          this.EBu = new com.tencent.mm.plugin.sns.ui.c.a.b((TimeLineObject)localObject8, localSnsInfo, this.Dyw, this.EBv);
          break label1107;
          ((ViewStub)localObject1).setLayoutResource(2131496513);
          this.EBu = new com.tencent.mm.plugin.sns.ui.c.a.f((TimeLineObject)localObject8, localSnsInfo, this.Dyw, this.EBv);
          break label1107;
          ((ViewStub)localObject1).setLayoutResource(2131496502);
          this.EBu = new com.tencent.mm.plugin.sns.ui.c.a.c((TimeLineObject)localObject8, localSnsInfo, this.Dyw, this.EBv);
          break label1107;
          ((ViewStub)localObject1).setLayoutResource(2131496503);
          this.EBu = new com.tencent.mm.plugin.sns.ui.c.a.d((TimeLineObject)localObject8, localSnsInfo, this.Dyw);
          break label1107;
          ((ViewStub)localObject1).setLayoutResource(2131496459);
          break label1107;
          ((ViewStub)localObject1).setLayoutResource(2131496436);
          break label1107;
          ((ViewStub)localObject1).setLayoutResource(2131496367);
          this.EBu = new com.tencent.mm.plugin.sns.ui.c.a.e((TimeLineObject)localObject8, localSnsInfo, this.Dyw, this.EBv);
          break label1107;
          label2291:
          ((ViewStub)localObject1).setVisibility(8);
          break label1193;
          label2301:
          i = be.EGv[this.qcr];
          break label1296;
          this.EBZ.setImageViewWidth(this.EBq);
          localObject1 = new LinkedList();
          Object localObject3;
          float f2;
          float f1;
          Object localObject7;
          if ((localSnsInfo.isAd()) && (this.qcr == 2))
          {
            localObject3 = localSnsInfo.getAdXml();
            this.EBZ.ZD(0).setScaleType(QImageView.a.QEL);
            if ((localObject3 != null) && (!((ADXml)localObject3).isCardAd()) && (((ADXml)localObject3).adMediaDisplayWidth > 0.0F) && (((ADXml)localObject3).adMediaDisplayHeight > 0.0F))
            {
              f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((ADXml)localObject3).adMediaDisplayWidth, 1, ((ADXml)localObject3).adBasicRemWidth, ((ADXml)localObject3).adBasicRootFontSize);
              f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((ADXml)localObject3).adMediaDisplayHeight, 1, ((ADXml)localObject3).adBasicRemWidth, ((ADXml)localObject3).adBasicRootFontSize);
              if (((ADXml)localObject3).adMediaDisplayMode != 0) {
                break label4196;
              }
              float f3 = f1;
              f1 = f2;
              if (f2 >= k - com.tencent.mm.cb.a.aG(this, 2131166954) - com.tencent.mm.cb.a.aG(this, 2131165593) - getResources().getDimensionPixelSize(2131165534) - getResources().getDimensionPixelSize(2131165534))
              {
                f1 = k - com.tencent.mm.cb.a.aG(this, 2131166954) - com.tencent.mm.cb.a.aG(this, 2131165593) - getResources().getDimensionPixelSize(2131165534) - getResources().getDimensionPixelSize(2131165534);
                f3 = (int)(((ADXml)localObject3).adMediaDisplayHeight * f1 / ((ADXml)localObject3).adMediaDisplayWidth);
              }
              localObject5 = new cnd();
              ((cnd)localObject5).Mto = f1;
              ((cnd)localObject5).Mtp = f3;
              ((cnd)localObject5).Mtq = (((cnd)localObject5).Mto * ((cnd)localObject5).Mtp);
              ((LinkedList)localObject1).add(localObject5);
            }
            if ((com.tencent.mm.plugin.sns.data.k.a(localSnsInfo, getSource())) && (!com.tencent.mm.plugin.sns.data.k.t(localSnsInfo))) {
              a(this.EBZ);
            }
            if (!Util.isNullOrNil(((ADXml)localObject3).adMediaIconUrl))
            {
              localObject5 = this.EBZ;
              localObject7 = this.EBZ.ZD(0);
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", ((ADXml)localObject3).adMediaIconUrl, false, 41, new f.a()
              {
                public final void aNH(String paramAnonymousString)
                {
                  AppMethodBeat.i(203520);
                  MaskImageView localMaskImageView = (MaskImageView)this.ECl.findViewById(2131304558);
                  if (localMaskImageView != null)
                  {
                    localMaskImageView.setVisibility(0);
                    localMaskImageView.setImageBitmap(BitmapUtil.decodeFile(paramAnonymousString));
                    float f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.ECm.adMediaIconWidth, 1, this.ECm.adBasicRemWidth, this.ECm.adBasicRootFontSize);
                    float f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.ECm.adMediaIconHeight, 1, this.ECm.adBasicRemWidth, this.ECm.adBasicRootFontSize);
                    float f3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.ECm.adMediaIconPaddingRight, 1, this.ECm.adBasicRemWidth, this.ECm.adBasicRootFontSize);
                    float f4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.ECm.adMediaIconPaddingBottom, 1, this.ECm.adBasicRemWidth, this.ECm.adBasicRootFontSize);
                    paramAnonymousString = new FrameLayout.LayoutParams((int)f1, (int)f2);
                    paramAnonymousString.setMargins((int)(this.ECn.getRight() - f3 - f1), (int)(this.ECn.getBottom() - f4 - f2), 0, 0);
                    localMaskImageView.setLayoutParams(paramAnonymousString);
                  }
                  AppMethodBeat.o(203520);
                }
                
                public final void eWN() {}
                
                public final void eWO() {}
              });
            }
          }
          this.EAP.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
          {
            boolean ECo = false;
            
            public final void onViewAttachedToWindow(View paramAnonymousView)
            {
              AppMethodBeat.i(203521);
              Log.i("MicroMsg.SnsCommentDetailUI", "onViewAttachedToWindow infoHeader %s", new Object[] { Boolean.valueOf(this.ECo) });
              if (!this.ECo)
              {
                AppMethodBeat.o(203521);
                return;
              }
              this.ECo = false;
              if (this.ECp == null)
              {
                AppMethodBeat.o(203521);
                return;
              }
              if (localSnsInfo == null)
              {
                AppMethodBeat.o(203521);
                return;
              }
              if (SnsCommentDetailUI.this.EBZ == null)
              {
                AppMethodBeat.o(203521);
                return;
              }
              paramAnonymousView = SnsCommentDetailUI.F(SnsCommentDetailUI.this);
              PhotosContent localPhotosContent = SnsCommentDetailUI.this.EBZ;
              TimeLineObject localTimeLineObject = this.ECp;
              String str = localSnsInfo.getLocalid();
              SnsCommentDetailUI.D(SnsCommentDetailUI.this);
              paramAnonymousView.a(localPhotosContent, localTimeLineObject, str, SnsCommentDetailUI.this.hashCode(), SnsCommentDetailUI.E(SnsCommentDetailUI.this), -1, localSnsInfo.isSourceExist(32), false, bp.Oqs, this.ECq, localSnsInfo.getSnsId(), localSnsInfo);
              SnsCommentDetailUI.b(localSnsInfo, SnsCommentDetailUI.this.EBZ, SnsCommentDetailUI.E(SnsCommentDetailUI.this));
              AppMethodBeat.o(203521);
            }
            
            public final void onViewDetachedFromWindow(View paramAnonymousView)
            {
              AppMethodBeat.i(203522);
              Log.i("MicroMsg.SnsCommentDetailUI", "onViewDetachedFromWindow infoHeader");
              this.ECo = true;
              AppMethodBeat.o(203522);
            }
          });
          this.EBe.a(this.EBZ, (TimeLineObject)localObject8, localSnsInfo.getLocalid(), hashCode(), this.qcr, -1, localSnsInfo.isSourceExist(32), false, bp.Oqs, (List)localObject1, localSnsInfo.getSnsId(), localSnsInfo);
          a(localSnsInfo, this.EBZ, this.qcr);
          if ((localSnsInfo.isAd()) && ((this.qcr == 3) || (this.qcr == 4) || (this.qcr == 5)) && (com.tencent.mm.plugin.sns.data.k.a(localSnsInfo, getSource())) && (!com.tencent.mm.plugin.sns.data.k.t(localSnsInfo)))
          {
            i = be.EGv[this.qcr];
            a(this.EBZ, i);
          }
          for (;;)
          {
            localObject5 = (TextView)this.EAP.findViewById(2131296607);
            if (!localSnsInfo.isAd()) {
              break label14403;
            }
            localObject3 = g(localSnsInfo);
            if (localObject3 == null) {
              break label14393;
            }
            localObject1 = ((ADInfo)localObject3).adActionPOIName;
            localObject3 = ((ADInfo)localObject3).adActionPOILink;
            ((TextView)localObject5).setTag(localSnsInfo.getLocalid());
            if (Util.isNullOrNil((String)localObject1)) {
              break label14393;
            }
            if (!Util.isNullOrNil((String)localObject3)) {
              break label14345;
            }
            ((TextView)localObject5).setVisibility(0);
            label2925:
            ((TextView)localObject5).setText((CharSequence)localObject1);
            ((TextView)localObject5).setClickable(false);
            ((TextView)localObject5).setTextColor(getContext().getResources().getColor(2131100245));
            this.EAP.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(203527);
                SnsCommentDetailUI.e(SnsCommentDetailUI.this).uM(false);
                AppMethodBeat.o(203527);
              }
            });
            ((TextView)localObject5).setOnClickListener(this.Dyw.FaP);
            ((TextView)this.EAP.findViewById(2131296675)).setText(bm.r(getContext(), localSnsInfo.getCreateTime() * 1000L));
            localObject5 = (AsyncTextView)this.EAP.findViewById(2131296604);
            ((TextView)localObject5).setOnClickListener(this.Dyw.FaT);
            ((TextView)localObject5).setVisibility(8);
            localObject7 = (AsyncTextView)this.EAP.findViewById(2131296603);
            ((TextView)localObject7).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(98573);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
                paramAnonymousView = new SnsAdClick(SnsCommentDetailUI.this.getSource(), 2, localSnsInfo.field_snsId, 24, 0);
                com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, SnsCommentDetailUI.e(SnsCommentDetailUI.this), localSnsInfo, 24);
                com.tencent.mm.plugin.sns.data.r.a(paramAnonymousView);
                localObject = this.gAi.arJ();
                paramAnonymousView = (View)localObject;
                if (localSnsInfo.isAd()) {
                  paramAnonymousView = com.tencent.mm.plugin.sns.ui.widget.e.c(localSnsInfo.getAdXml(), (String)localObject);
                }
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentFlag(1);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentHint(paramAnonymousView);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).vt(true);
                SnsCommentDetailUI.G(SnsCommentDetailUI.this).setVisibility(8);
                SnsCommentDetailUI.B(SnsCommentDetailUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98573);
              }
            });
            ((TextView)localObject7).setVisibility(8);
            if (localSnsInfo.isAd())
            {
              localObject9 = g(localSnsInfo);
              ((TextView)localObject5).setTag(localSnsInfo.getLocalid());
              if (((ADInfo)localObject9).adActionExtTailType != ADInfo.ADChainStrengthenDefaultWording) {
                break label14631;
              }
              if (Util.isNullOrNil(((ADInfo)localObject9).adActionExtTailWording)) {
                break label14621;
              }
              ((TextView)localObject5).setText(((ADInfo)localObject9).adActionExtTailWording);
              ((TextView)localObject5).setVisibility(0);
              break label14919;
              if ((((TextView)localObject5).getVisibility() != 8) && (Util.isNullOrNil(((ADInfo)localObject9).adActionExtTailLink)))
              {
                ((TextView)localObject5).setTextColor(getResources().getColor(2131101161));
                ((TextView)localObject5).setOnClickListener(null);
              }
              if ((localSnsInfo.getTimeLine().ContentObj.LoW & 0x4) == 0) {
                break label15088;
              }
              ((TextView)localObject7).setTag(localSnsInfo.getLocalid());
              ((TextView)localObject7).setVisibility(0);
              ((TextView)localObject7).setText(String.format("%s%s%s", new Object[] { getContext().getResources().getString(2131765936), localObject4, getContext().getResources().getString(2131765937) }));
            }
            localObject1 = (WeImageView)this.EAP.findViewById(2131296704);
            if (((TimeLineObject)localObject8).ContentObj.LoU != 30) {
              break label15098;
            }
            i = 0;
            label3324:
            ((WeImageView)localObject1).setVisibility(i);
            ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099662));
            localObject4 = (TextView)this.EAP.findViewById(2131296646);
            ((TextView)localObject4).setOnTouchListener(new af());
            localObject3 = com.tencent.mm.plugin.sns.c.a.jRu.r(this, ((TimeLineObject)localObject8).AppInfo.Id);
            if (((TimeLineObject)localObject8).ContentObj.LoU != 26) {
              break label15105;
            }
            localObject1 = getString(2131759168);
            bk.a((TimeLineObject)localObject8, this);
            if (!com.tencent.mm.plugin.sns.c.a.jRu.gp((String)localObject1)) {
              break label15643;
            }
            ((TextView)localObject4).setVisibility(0);
            localObject1 = new SpannableString(getString(2131766013) + (String)localObject1);
            ((SpannableString)localObject1).setSpan(new a(), 0, ((SpannableString)localObject1).length(), 33);
            ((TextView)localObject4).setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
            if ((((TimeLineObject)localObject8).AppInfo == null) || (!com.tencent.mm.pluginsdk.model.app.h.bdz(((TimeLineObject)localObject8).AppInfo.Id)))
            {
              ((TextView)localObject4).setTextColor(getResources().getColor(2131101161));
              ((TextView)localObject4).setOnTouchListener(null);
            }
            ((TextView)localObject4).setTag(localObject8);
            if (((TimeLineObject)localObject8).ContentObj.LoU == 28)
            {
              ((TextView)localObject4).setTextColor(getResources().getColor(2131101131));
              ((TextView)localObject4).setOnTouchListener(null);
              if (this.EAP != null)
              {
                localObject1 = (Guideline)this.EAP.findViewById(2131308125);
                if (localObject1 != null) {
                  ((Guideline)localObject1).setGuidelineEnd(0);
                }
              }
              ((TextView)localObject4).setTag(localObject8);
              ((TextView)localObject4).setOnClickListener(new SnsCommentDetailUI.35(this, (TimeLineObject)localObject8));
            }
            localObject1 = (TextView)this.EAP.findViewById(2131296643);
            if (!localSnsInfo.getUserName().equals(this.gna)) {
              break label15653;
            }
            ((TextView)localObject1).setVisibility(0);
            ((TextView)localObject1).setTag(localSnsInfo.getLocalid() + ";" + localSnsInfo.getSnsId());
            ((TextView)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(203528);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                com.tencent.mm.ui.base.h.a(SnsCommentDetailUI.this, 2131766262, 2131755998, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(163112);
                    Log.d("MicroMsg.SnsCommentDetailUI", "to del by localId " + SnsCommentDetailUI.j(SnsCommentDetailUI.this));
                    paramAnonymous2DialogInterface = com.tencent.mm.plugin.sns.storage.f.aQm(SnsCommentDetailUI.j(SnsCommentDetailUI.this));
                    if (paramAnonymous2DialogInterface == null)
                    {
                      Log.e("MicroMsg.SnsCommentDetailUI", "try to del item fail can not get snsinfo by localid %s", new Object[] { SnsCommentDetailUI.j(SnsCommentDetailUI.this) });
                      AppMethodBeat.o(163112);
                      return;
                    }
                    if (paramAnonymous2DialogInterface.isAd())
                    {
                      AppMethodBeat.o(163112);
                      return;
                    }
                    Object localObject;
                    if (paramAnonymous2DialogInterface.field_snsId == 0L)
                    {
                      com.tencent.mm.plugin.sns.model.aj.faO().Zs(paramAnonymous2DialogInterface.localid);
                      localObject = new Intent();
                      ((Intent)localObject).putExtra("sns_gallery_op_id", y.aQI(SnsCommentDetailUI.j(SnsCommentDetailUI.this)));
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
                      if ((!Util.isNullOrNil(paramAnonymous2DialogInterface)) && (com.tencent.mm.plugin.sns.c.a.jRu.gq(paramAnonymous2DialogInterface)))
                      {
                        String str = com.tencent.mm.plugin.sns.c.a.jRu.go(paramAnonymous2DialogInterface);
                        rw localrw = new rw();
                        localrw.dYr.appId = paramAnonymous2DialogInterface;
                        localrw.dYr.dYs = ((TimeLineObject)localObject).UserName;
                        localrw.dYr.pkgName = str;
                        EventCenter.instance.publish(localrw);
                      }
                      SnsCommentDetailUI.this.finish();
                      AppMethodBeat.o(163112);
                      return;
                      com.tencent.mm.plugin.sns.model.aj.faN().Jr(paramAnonymous2DialogInterface.field_snsId);
                      com.tencent.mm.kernel.g.aAi();
                      com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.sns.model.s(paramAnonymous2DialogInterface.field_snsId, 1), 0);
                      com.tencent.mm.plugin.sns.model.aj.faO().delete(paramAnonymous2DialogInterface.field_snsId);
                      com.tencent.mm.plugin.sns.model.aj.faT().JI(paramAnonymous2DialogInterface.field_snsId);
                      com.tencent.mm.plugin.sns.storage.g.JH(paramAnonymous2DialogInterface.field_snsId);
                      break;
                    }
                  }
                }, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203528);
              }
            });
            localObject4 = (TextView)this.EAP.findViewById(2131310522);
            localObject5 = an.B(localSnsInfo);
            if (localObject5 != null) {
              break label15663;
            }
            ((TextView)localObject4).setVisibility(8);
            this.EAX = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
            this.EAX.setDuration(150L);
            this.EAY = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
            this.EAY.setDuration(150L);
            if (this.EAU == null)
            {
              this.EAU = this.EAP.findViewById(2131296625);
              this.EAU.setVisibility(8);
            }
            this.EAZ = ((LinearLayout)this.EAP.findViewById(2131296632));
            this.EAZ.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(203530);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                if (!com.tencent.mm.plugin.sns.lucky.a.m.aOH(localSnsInfo.getLocalid()))
                {
                  com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.EBZ.ZD(0));
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(203530);
                  return;
                }
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentInfo(null);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentFlag(0);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentHint(SnsCommentDetailUI.this.getString(2131766285));
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentInfo(new dzo());
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setToSendTextColor(true);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).vt(true);
                if ((localSnsInfo.isAd()) && ((localSnsInfo.getTimeLine().ContentObj.LoW & 0x8) != 0)) {
                  SnsCommentDetailUI.c(SnsCommentDetailUI.this).oY(true);
                }
                for (;;)
                {
                  SnsCommentDetailUI.G(SnsCommentDetailUI.this).setVisibility(8);
                  SnsCommentDetailUI.B(SnsCommentDetailUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(203530);
                  return;
                  SnsCommentDetailUI.c(SnsCommentDetailUI.this).oY(false);
                }
              }
            });
            this.EAZ.setOnTouchListener(this.EqE);
            this.EBa = ((LinearLayout)this.EAP.findViewById(2131296663));
            this.EBa.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(203531);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
                if ((SnsCommentDetailUI.e(SnsCommentDetailUI.this) != null) && (localSnsInfo.getLikeFlag() == 0)) {
                  SnsCommentDetailUI.e(SnsCommentDetailUI.this).IR(localSnsInfo.field_snsId);
                }
                localObject = SnsCommentDetailUI.this;
                paramAnonymousView = (LinearLayout)paramAnonymousView;
                ImageView localImageView = (ImageView)paramAnonymousView.findViewById(2131296662);
                ScaleAnimation localScaleAnimation = new ScaleAnimation(0.9F, 1.5F, 0.9F, 1.5F, 1, 0.5F, 1, 0.5F);
                localScaleAnimation.setDuration(400L);
                localScaleAnimation.setStartOffset(100L);
                localScaleAnimation.setRepeatCount(0);
                localImageView.clearAnimation();
                localImageView.startAnimation(localScaleAnimation);
                localScaleAnimation.setAnimationListener(new SnsCommentDetailUI.42((SnsCommentDetailUI)localObject, paramAnonymousView));
                SnsCommentDetailUI.H(SnsCommentDetailUI.this);
                com.tencent.mm.plugin.sns.k.e.DUQ.fcy().eOB = 3L;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203531);
              }
            });
            this.EBa.setOnTouchListener(this.EqE);
            localObject1 = (ImageButton)this.EAP.findViewById(2131296676);
            localObject3 = vs(true);
            if ((localObject3 != null) && ((((SnsInfo)localObject3).getLocalPrivate() & 0x1) != 0)) {
              ((ImageButton)localObject1).setVisibility(8);
            }
            if ((localObject3 != null) && (!((SnsInfo)localObject3).isExtFlag())) {
              ((ImageButton)localObject1).setVisibility(8);
            }
            localObject3 = (ImageView)this.EBa.findViewById(2131296662);
            localObject4 = (ImageView)this.EAZ.findViewById(2131296631);
            localObject5 = (TextView)this.EBa.findViewById(2131296664);
            localObject7 = (TextView)this.EAZ.findViewById(2131296640);
            if (this.qcr == 10)
            {
              this.EAP.findViewById(2131296625).setBackgroundResource(2131232829);
              ((ImageButton)localObject1).setImageResource(2131233582);
              ((ImageView)localObject3).setImageResource(2131233583);
              ((ImageView)localObject4).setImageResource(2131233584);
              ((TextView)localObject5).setTextColor(getResources().getColor(2131101137));
              ((TextView)localObject7).setTextColor(getResources().getColor(2131101137));
              this.EBa.setBackgroundResource(2131233818);
              this.EAZ.setBackgroundResource(2131233819);
            }
            ((ImageButton)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(203532);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                Log.d("MicroMsg.SnsCommentDetailUI", "showComment click" + SnsCommentDetailUI.G(SnsCommentDetailUI.this).getVisibility());
                com.tencent.mm.plugin.sns.ad.i.i.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a(localSnsInfo, true, paramAnonymousView, SnsCommentDetailUI.e(SnsCommentDetailUI.this)));
                paramAnonymousView = localSnsInfo.getTimeLine();
                if ((paramAnonymousView != null) && (paramAnonymousView.ContentObj.LoU == 21) && (!com.tencent.mm.plugin.sns.lucky.a.m.aOH(localSnsInfo.getLocalid())))
                {
                  com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.EBZ.ZD(0));
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(203532);
                  return;
                }
                if (SnsCommentDetailUI.G(SnsCommentDetailUI.this).getVisibility() == 0) {
                  SnsCommentDetailUI.f(SnsCommentDetailUI.this);
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(203532);
                  return;
                  SnsCommentDetailUI.G(SnsCommentDetailUI.this).setVisibility(0);
                  SnsCommentDetailUI.G(SnsCommentDetailUI.this).startAnimation(SnsCommentDetailUI.I(SnsCommentDetailUI.this));
                  if (SnsCommentDetailUI.E(SnsCommentDetailUI.this) == 10) {
                    SnsCommentDetailUI.y(SnsCommentDetailUI.this).findViewById(2131296625).setBackgroundResource(2131232829);
                  }
                  if (!y.aQJ(SnsCommentDetailUI.m(SnsCommentDetailUI.this)))
                  {
                    SnsCommentDetailUI.this.EAZ.setEnabled(false);
                    SnsCommentDetailUI.this.EBa.setEnabled(false);
                    this.ECv.setText(SnsCommentDetailUI.this.getString(2131766109));
                    this.ECv.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101128));
                    this.ECw.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101128));
                    if (SnsCommentDetailUI.E(SnsCommentDetailUI.this) == 10) {
                      this.ECx.setImageResource(2131690334);
                    } else {
                      this.ECx.setImageResource(2131690337);
                    }
                  }
                  else
                  {
                    SnsCommentDetailUI.this.EAZ.setEnabled(true);
                    this.ECx.setImageResource(2131232834);
                    SnsCommentDetailUI.this.EBa.setEnabled(true);
                    this.ECv.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101427));
                    this.ECw.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101427));
                    paramAnonymousView = com.tencent.mm.plugin.sns.storage.f.aQl(SnsCommentDetailUI.m(SnsCommentDetailUI.this));
                    if (SnsCommentDetailUI.E(SnsCommentDetailUI.this) == 10)
                    {
                      this.ECx.setImageResource(2131233583);
                      this.ECy.setImageResource(2131233584);
                      this.ECv.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101137));
                      this.ECw.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101137));
                    }
                    for (;;)
                    {
                      if ((paramAnonymousView == null) || (paramAnonymousView.getLikeFlag() != 0)) {
                        break label616;
                      }
                      this.ECv.setText(SnsCommentDetailUI.this.getString(2131766109));
                      break;
                      this.ECx.setImageResource(2131232834);
                      this.ECv.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101427));
                      this.ECw.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101427));
                    }
                    label616:
                    this.ECv.setText(SnsCommentDetailUI.this.getString(2131766065));
                  }
                }
              }
            });
            AppMethodBeat.o(98604);
            return true;
            if (((ADXml)localObject3).adMediaDisplayMode == 1)
            {
              i = k - com.tencent.mm.cb.a.aG(this, 2131166954) - com.tencent.mm.cb.a.aG(this, 2131166954) - com.tencent.mm.cb.a.aG(this, 2131165593) - com.tencent.mm.cb.a.aG(this, 2131165593) - getResources().getDimensionPixelSize(2131165534) - getResources().getDimensionPixelSize(2131165534);
              j = (int)(i * ((ADXml)localObject3).adMediaDisplayHeight / ((ADXml)localObject3).adMediaDisplayWidth);
              localObject5 = new cnd();
              if (i > 0) {
                f2 = i;
              }
              ((cnd)localObject5).Mto = f2;
              if (j > 0) {
                f1 = j;
              }
              ((cnd)localObject5).Mtp = f1;
              ((cnd)localObject5).Mtq = (((cnd)localObject5).Mto * ((cnd)localObject5).Mtp);
              ((LinkedList)localObject1).add(localObject5);
              break;
            }
            if (((ADXml)localObject3).adMediaDisplayMode != 2) {
              break;
            }
            i = k - com.tencent.mm.cb.a.aG(this, 2131166954) - com.tencent.mm.cb.a.aG(this, 2131165593) - getResources().getDimensionPixelSize(2131165534) - getResources().getDimensionPixelSize(2131165534);
            j = (int)(i * ((ADXml)localObject3).adMediaDisplayHeight / ((ADXml)localObject3).adMediaDisplayWidth);
            localObject5 = new cnd();
            if (i > 0) {
              f2 = i;
            }
            ((cnd)localObject5).Mto = f2;
            if (j > 0) {
              f1 = j;
            }
            ((cnd)localObject5).Mtp = f1;
            ((cnd)localObject5).Mtq = (((cnd)localObject5).Mto * ((cnd)localObject5).Mtp);
            ((LinkedList)localObject1).add(localObject5);
            break;
            Log.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.qcr + ",stub is " + ((ViewStub)localObject1).toString());
            continue;
            if (this.qcr != 10) {
              break label5066;
            }
            this.EBZ = ((PhotosContent)findViewById(2131302255));
            this.EBZ.fgF();
            localObject1 = (TagImageView)this.EBZ.findViewById(2131296652);
            this.EBZ.a((TagImageView)localObject1);
            ((TagImageView)localObject1).setOnClickListener(this.Dyw.Erh);
            localObject3 = localSnsInfo.getLocalid();
            localObject5 = new ArrayList();
            ((List)localObject5).add(localObject1);
            localObject7 = new bc();
            ((bc)localObject7).dJX = ((String)localObject3);
            ((bc)localObject7).index = 0;
            ((bc)localObject7).EDW = ((List)localObject5);
            ((bc)localObject7).EAv = true;
            if (localObject1 != null) {
              ((TagImageView)localObject1).setTag(localObject7);
            }
            localObject1 = (TextView)this.EAP.findViewById(2131302256);
            if (!z.aTY().equals(((TimeLineObject)localObject8).UserName))
            {
              localObject3 = an.C(localSnsInfo);
              if ((((SnsObject)localObject3).SnsRedEnvelops != null) && (((SnsObject)localObject3).SnsRedEnvelops.Nae != 0))
              {
                ((TextView)localObject1).setText(getString(2131762762, new Object[] { Integer.valueOf(((SnsObject)localObject3).SnsRedEnvelops.Nae) }));
                ((TextView)localObject1).setVisibility(0);
              }
            }
            for (;;)
            {
              localObject1 = localSnsInfo.getPostInfo();
              if (localObject1 == null) {
                break label5036;
              }
              if (!z.aTY().equals(((TimeLineObject)localObject8).UserName)) {
                break label4864;
              }
              localObject1 = this.EBe;
              localObject3 = this.EBZ;
              localObject5 = localSnsInfo.getLocalid();
              i = hashCode();
              j = this.qcr;
              localSnsInfo.isSourceExist(32);
              ((be)localObject1).a((PhotosContent)localObject3, (TimeLineObject)localObject8, (String)localObject5, i, j, -1, false, bp.Oqs, true);
              break;
              ((TextView)localObject1).setVisibility(8);
              continue;
              ((TextView)localObject1).setVisibility(8);
            }
            if (com.tencent.mm.plugin.sns.lucky.a.m.w(localSnsInfo))
            {
              localObject1 = this.EBe;
              localObject3 = this.EBZ;
              localObject5 = localSnsInfo.getLocalid();
              i = hashCode();
              j = this.qcr;
              localSnsInfo.isSourceExist(32);
              ((be)localObject1).a((PhotosContent)localObject3, (TimeLineObject)localObject8, (String)localObject5, i, j, -1, false, bp.Oqs, false);
            }
            else if (((cnc)localObject1).egZ == 0)
            {
              localObject1 = this.EBe;
              localObject3 = this.EBZ;
              localObject5 = localSnsInfo.getLocalid();
              i = hashCode();
              j = this.qcr;
              localSnsInfo.isSourceExist(32);
              ((be)localObject1).a((PhotosContent)localObject3, (TimeLineObject)localObject8, (String)localObject5, i, j, -1, false, bp.Oqs, true);
            }
            else
            {
              Log.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo.hbStatus is " + ((cnc)localObject1).egZ);
              continue;
              Log.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo is null " + localSnsInfo.getLocalid());
            }
          }
          Object localObject10;
          Object localObject11;
          Object localObject12;
          if ((this.qcr == 9) || (this.qcr == 19))
          {
            this.EBz = true;
            localObject7 = new at();
            localObject3 = this.EAP;
            localObject10 = ((View)localObject3).findViewById(2131298411);
            localObject11 = (VideoSightView)((View)localObject3).findViewById(2131302526);
            localObject12 = (SnsAdTimelineVideoView)((View)localObject3).findViewById(2131305364);
            ((at)localObject7).Ewr = ((View)localObject3);
            ((at)localObject7).Ewu = ((View)localObject10);
            ((at)localObject7).EeS = ((ImageView)((View)localObject3).findViewById(2131308392));
            ((at)localObject7).Ewv = ((MMPinProgressBtn)((View)localObject3).findViewById(2131306281));
            ((at)localObject7).EeT = ((TextView)((View)localObject3).findViewById(2131300154));
            ((at)localObject7).Eww = ((TextView)((View)localObject3).findViewById(2131300128));
            ((at)localObject7).Ews = ((VideoSightView)localObject11);
            ((at)localObject7).Ews.setMute(true);
            ((at)localObject7).a((TimeLineObject)localObject8, 0, localSnsInfo.getLocalid(), localSnsInfo.isAd());
            ((at)localObject7).EeT.setVisibility(8);
            ((at)localObject7).Ews.setTagObject(localObject7);
            ((at)localObject7).Ews.setIsAdVideo(localSnsInfo.isAd());
            ((at)localObject7).Ewx = 5;
            ((at)localObject7).Ewt = ((SnsAdTimelineVideoView)localObject12);
            com.tencent.mm.plugin.sns.ad.timeline.b.f.a((SnsAdTimelineVideoView)localObject12);
            ((View)localObject10).setTag(localObject7);
            ((at)localObject7).Ewu.setOnClickListener(this.Dyw.FaQ);
            if (!localSnsInfo.isCardAd())
            {
              this.pqr.c((View)localObject10, this.Dyw.FaH, this.Dyw.Far);
              label5356:
              if ((!localSnsInfo.isAd()) || (!com.tencent.mm.plugin.sns.data.k.d((TimeLineObject)localObject8))) {
                break label6306;
              }
              j = 1;
              i = 0;
              if (localSnsInfo != null) {
                i = localSnsInfo.getAdXml().verticalVideoDisplayType;
              }
              if (i != 1) {
                break label6287;
              }
              localObject1 = com.tencent.mm.modelsns.n.df(((at)localObject7).Ews.getUIContext());
              Log.i("MicroMsg.SnsCommentDetailUI", "isVerticalAdVideo=true, snsId=" + localSnsInfo.field_snsId + ", showW=" + ((Pair)localObject1).first + ", showH=" + ((Pair)localObject1).second);
              i = j;
              if (!localSnsInfo.isAd()) {
                break label16215;
              }
              ((VideoSightView)localObject11).setEnableConfigChanged(false);
              localObject5 = localSnsInfo.getAdXml();
              if ((localObject5 == null) || (!((ADXml)localObject5).isCardAd()) || (((ADXml)localObject5).adMediaDisplayWidth <= 0.0F) || (((ADXml)localObject5).adMediaDisplayHeight <= 0.0F)) {
                break label16215;
              }
              f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((ADXml)localObject5).adMediaDisplayWidth, 1, ((ADXml)localObject5).adBasicRemWidth, ((ADXml)localObject5).adBasicRootFontSize);
              f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((ADXml)localObject5).adMediaDisplayHeight, 1, ((ADXml)localObject5).adBasicRemWidth, ((ADXml)localObject5).adBasicRootFontSize);
              if (((ADXml)localObject5).adMediaDisplayMode != 0) {
                break label6332;
              }
              if (f2 < k - com.tencent.mm.cb.a.aG(this, 2131166954) - com.tencent.mm.cb.a.aG(this, 2131165593) - getResources().getDimensionPixelSize(2131165534) - getResources().getDimensionPixelSize(2131165534)) {
                break label16218;
              }
              f2 = k - com.tencent.mm.cb.a.aG(this, 2131166954) - com.tencent.mm.cb.a.aG(this, 2131165593) - getResources().getDimensionPixelSize(2131165534) - getResources().getDimensionPixelSize(2131165534);
              f1 = (int)(((ADXml)localObject5).adMediaDisplayHeight * f2 / ((ADXml)localObject5).adMediaDisplayWidth);
            }
          }
          for (;;)
          {
            localObject1 = Pair.create(Integer.valueOf((int)f2), Integer.valueOf((int)f1));
            for (;;)
            {
              if (localObject1 != null)
              {
                if ((((at)localObject7).Ews instanceof SightPlayImageView))
                {
                  if (!localSnsInfo.isAd())
                  {
                    ((at)localObject7).Ews.setScaleMode(1);
                    ((at)localObject7).Ews.setScaleType(QImageView.a.QEL);
                  }
                }
                else
                {
                  label5738:
                  ((VideoSightView)localObject11).im(((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue());
                  if ((((at)localObject7).Ews instanceof SightPlayImageView))
                  {
                    if (i == 0) {
                      break label6565;
                    }
                    ((at)localObject7).Ews.eVK();
                  }
                  localObject5 = ((at)localObject7).Eww.getLayoutParams();
                  ((ViewGroup.LayoutParams)localObject5).width = ((Integer)((Pair)localObject1).first).intValue();
                  ((ViewGroup.LayoutParams)localObject5).height = ((Integer)((Pair)localObject1).second).intValue();
                  ((at)localObject7).Eww.setLayoutParams((ViewGroup.LayoutParams)localObject5);
                  localObject3 = (FrameLayout)((View)localObject3).findViewById(2131308264);
                  localObject5 = (FrameLayout.LayoutParams)((FrameLayout)localObject3).getLayoutParams();
                  ((FrameLayout.LayoutParams)localObject5).width = ((Integer)((Pair)localObject1).first).intValue();
                  ((FrameLayout.LayoutParams)localObject5).height = ((Integer)((Pair)localObject1).second).intValue();
                  ((FrameLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject5);
                  com.tencent.mm.plugin.sns.ad.timeline.b.f.a((SnsAdTimelineVideoView)localObject12, ((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue());
                }
              }
              else
              {
                if ((((TimeLineObject)localObject8).ContentObj == null) || (((TimeLineObject)localObject8).ContentObj.LoV.size() <= 0)) {
                  break label6577;
                }
                localObject1 = (cnb)((TimeLineObject)localObject8).ContentObj.LoV.get(0);
                localObject5 = localObject1;
                if (localSnsInfo.isAd())
                {
                  localObject3 = localObject1;
                  if (localObject1 != null)
                  {
                    localObject3 = com.tencent.mm.plugin.sns.ad.e.b.a((cnb)localObject1);
                    com.tencent.mm.plugin.sns.ad.e.b.a((cnb)localObject3, false);
                  }
                  ((at)localObject7).Ews.setOnCompletionListener(new b.e()
                  {
                    public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
                    {
                      AppMethodBeat.i(203523);
                      if (paramAnonymousInt != -1)
                      {
                        if (SnsCommentDetailUI.e(SnsCommentDetailUI.this) == null)
                        {
                          AppMethodBeat.o(203523);
                          return;
                        }
                        SnsCommentDetailUI.e(SnsCommentDetailUI.this).I(localSnsInfo.field_snsId, false);
                      }
                      AppMethodBeat.o(203523);
                    }
                  });
                  ((at)localObject7).Ews.setOnDecodeDurationListener(new b.f()
                  {
                    public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
                    {
                      AppMethodBeat.i(203524);
                      Log.d("MicroMsg.SnsCommentDetailUI", "onDecodeProgress:".concat(String.valueOf(paramAnonymousLong)));
                      if ((SnsCommentDetailUI.e(SnsCommentDetailUI.this) != null) && (localSnsInfo != null))
                      {
                        SnsCommentDetailUI.e(SnsCommentDetailUI.this).IT(localSnsInfo.field_snsId);
                        SnsCommentDetailUI.e(SnsCommentDetailUI.this).ao(localSnsInfo.field_snsId, 1000L * paramAnonymousLong);
                        if (!SnsCommentDetailUI.e(SnsCommentDetailUI.this).IQ(localSnsInfo.field_snsId))
                        {
                          int i = (int)paramAnonymousb.eVC();
                          Log.i("MicroMsg.SnsCommentDetailUI", "updatePlayStartTime, duration=".concat(String.valueOf(i)));
                          SnsCommentDetailUI.e(SnsCommentDetailUI.this).c(localSnsInfo.field_snsId, Util.currentTicks(), false);
                          SnsCommentDetailUI.e(SnsCommentDetailUI.this).e(localSnsInfo.field_snsId, i, false);
                          SnsCommentDetailUI.e(SnsCommentDetailUI.this).an(localSnsInfo.field_snsId, localSnsInfo.field_snsId);
                        }
                      }
                      AppMethodBeat.o(203524);
                    }
                  });
                  localObject5 = localObject3;
                  if (a(localSnsInfo, (SnsAdTimelineVideoView)localObject12))
                  {
                    ((SnsAdTimelineVideoView)localObject12).setVideoCallback(new c(localSnsInfo, (SnsAdTimelineVideoView)localObject12));
                    localObject5 = localObject3;
                  }
                }
                if ((((TimeLineObject)localObject8).ContentObj == null) || (((TimeLineObject)localObject8).ContentObj.LoV.size() <= 0)) {
                  break;
                }
                com.tencent.mm.plugin.sns.model.aj.faL();
                if (com.tencent.mm.plugin.sns.model.g.u((cnb)localObject5)) {
                  break label6686;
                }
                if (!com.tencent.mm.plugin.sns.model.aj.faL().x((cnb)localObject5)) {
                  break label6583;
                }
                ((at)localObject7).EeS.setVisibility(8);
                ((at)localObject7).Ewv.setVisibility(0);
                ((at)localObject7).Ewv.gYN();
                ((VideoSightView)localObject11).setTagObject(localObject7);
                if (!a(localSnsInfo, (SnsAdTimelineVideoView)localObject12)) {
                  break label6989;
                }
                ((SnsAdTimelineVideoView)localObject12).setTag(localObject7);
                ((VideoSightView)localObject11).setVisibility(8);
                com.tencent.mm.plugin.sns.ad.timeline.b.f.a((SnsAdTimelineVideoView)localObject12, true);
                com.tencent.mm.plugin.sns.ad.timeline.b.f.a((SnsAdTimelineVideoView)localObject12, com.tencent.mm.plugin.sns.model.aj.faL(), localSnsInfo, this, (cnb)localObject5, 0, bp.Oqs);
                com.tencent.mm.plugin.sns.ad.timeline.b.f.b((SnsAdTimelineVideoView)localObject12);
                ((View)localObject10).setTag(localObject7);
                if (this.EBv == null) {
                  break;
                }
                if (!localSnsInfo.isAd()) {
                  break label7030;
                }
                if (com.tencent.mm.plugin.sns.model.aj.faL().A(localSnsInfo) != 5) {
                  break label7024;
                }
                bool1 = true;
              }
              for (;;)
              {
                this.EBv.J(localSnsInfo.field_snsId, bool1);
                break;
                this.pqr.c((View)localObject10, this.Dyw.FaJ, this.Dyw.Far);
                break label5356;
                localObject1 = com.tencent.mm.modelsns.n.a((TimeLineObject)localObject8, ((at)localObject7).Ews.getUIContext(), false);
                break label5412;
                localObject1 = com.tencent.mm.modelsns.n.a((TimeLineObject)localObject8, ((at)localObject7).Ews.getUIContext(), localSnsInfo.isAd());
                i = 0;
                break label5471;
                if (((ADXml)localObject5).adMediaDisplayMode == 1)
                {
                  j = k - com.tencent.mm.cb.a.aG(this, 2131166954) - com.tencent.mm.cb.a.aG(this, 2131166954) - com.tencent.mm.cb.a.aG(this, 2131165593) - com.tencent.mm.cb.a.aG(this, 2131165593) - getResources().getDimensionPixelSize(2131165534) - getResources().getDimensionPixelSize(2131165534);
                  localObject1 = Pair.create(Integer.valueOf(j), Integer.valueOf((int)(j * ((ADXml)localObject5).adMediaDisplayHeight / ((ADXml)localObject5).adMediaDisplayWidth)));
                  break label5694;
                }
                if (((ADXml)localObject5).adMediaDisplayMode != 2) {
                  break label16215;
                }
                j = k - com.tencent.mm.cb.a.aG(this, 2131166954) - com.tencent.mm.cb.a.aG(this, 2131165593) - getResources().getDimensionPixelSize(2131165534) - getResources().getDimensionPixelSize(2131165534);
                localObject1 = Pair.create(Integer.valueOf(j), Integer.valueOf((int)(j * ((ADXml)localObject5).adMediaDisplayHeight / ((ADXml)localObject5).adMediaDisplayWidth)));
                break label5694;
                if (i != 0)
                {
                  ((at)localObject7).Ews.setScaleMode(1);
                  ((at)localObject7).Ews.setScaleType(QImageView.a.QEL);
                  break label5738;
                }
                ((at)localObject7).Ews.setScaleMode(0);
                ((at)localObject7).Ews.setScaleType(QImageView.a.QEG);
                break label5738;
                ((at)localObject7).Ews.setDrawWidthAndHeightFix(false);
                break label5789;
                localObject1 = null;
                break label5969;
                if ((localSnsInfo.isAd()) && (com.tencent.mm.plugin.sns.model.aj.faL().A(localSnsInfo) == 5))
                {
                  com.tencent.mm.plugin.sns.model.aj.faL().B((cnb)localObject5);
                  ((at)localObject7).EeS.setVisibility(8);
                  ((at)localObject7).Ewv.setVisibility(0);
                  ((at)localObject7).Ewv.gYN();
                  break label6147;
                }
                com.tencent.mm.plugin.sns.model.aj.faL().z((cnb)localObject5);
                ((at)localObject7).EeS.setVisibility(0);
                ((at)localObject7).Ewv.setVisibility(8);
                ((at)localObject7).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this, 2131691480));
                break label6147;
                if (com.tencent.mm.plugin.sns.model.aj.faL().v((cnb)localObject5))
                {
                  ((at)localObject7).EeS.setVisibility(0);
                  ((at)localObject7).Ewv.setVisibility(8);
                  ((at)localObject7).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this, 2131691480));
                  if (!a(localSnsInfo, (SnsAdTimelineVideoView)localObject12)) {
                    break label6976;
                  }
                }
                for (bool1 = ((SnsAdTimelineVideoView)localObject12).isError();; bool1 = ((at)localObject7).Ews.eVL())
                {
                  if (!bool1) {
                    break label6987;
                  }
                  Log.d("MicroMsg.SnsCommentDetailUI", "play video error " + ((cnb)localObject5).Id + " " + ((cnb)localObject5).Url + " " + ((cnb)localObject5).Msz);
                  com.tencent.mm.plugin.sns.model.aj.faL().z((cnb)localObject5);
                  ((at)localObject7).EeS.setVisibility(0);
                  ((at)localObject7).Ewv.setVisibility(8);
                  ((at)localObject7).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this, 2131691480));
                  break;
                  if (com.tencent.mm.plugin.sns.model.aj.faL().w((cnb)localObject5))
                  {
                    ((at)localObject7).EeS.setVisibility(8);
                    ((at)localObject7).Ewv.setVisibility(8);
                    break label6731;
                  }
                  if ((localSnsInfo.isAd()) && (com.tencent.mm.plugin.sns.model.aj.faL().A(localSnsInfo) <= 5))
                  {
                    ((at)localObject7).EeS.setVisibility(8);
                    ((at)localObject7).Ewv.setVisibility(8);
                    break label6731;
                  }
                  com.tencent.mm.plugin.sns.model.aj.faL().z((cnb)localObject5);
                  ((at)localObject7).EeS.setVisibility(0);
                  ((at)localObject7).Ewv.setVisibility(8);
                  ((at)localObject7).EeS.setImageDrawable(com.tencent.mm.cb.a.l(this, 2131691480));
                  break label6731;
                }
                break label6147;
                com.tencent.mm.plugin.sns.model.aj.faL().a(localSnsInfo, (cnb)localObject5, (VideoSightView)localObject11, hashCode(), 0, bp.Oqs, localSnsInfo.isAd());
                ((VideoSightView)localObject11).start();
                break label6207;
                label7024:
                bool1 = false;
                continue;
                label7030:
                if (com.tencent.mm.plugin.sns.model.aj.faL().z(localSnsInfo) == 5) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
              }
              if (this.qcr == 0)
              {
                localObject1 = (LinearLayout)this.EAP.findViewById(2131308157);
                localObject3 = ZH(2131496460);
                if (!this.EBW)
                {
                  ((LinearLayout)localObject1).removeView(this.EBZ);
                  ((LinearLayout)localObject1).addView((View)localObject3, 3);
                  if (((LinearLayout)localObject3).getLayoutParams() == null) {
                    break label7446;
                  }
                }
                for (localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject3).getLayoutParams());; localObject1 = new LinearLayout.LayoutParams(-1, -2))
                {
                  ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cb.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                  ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  if (((TimeLineObject)localObject8).ContentObj.LoV.isEmpty()) {
                    break label7461;
                  }
                  localObject5 = (cnb)((TimeLineObject)localObject8).ContentObj.LoV.get(0);
                  localObject1 = (MMImageView)((LinearLayout)localObject3).findViewById(2131302578);
                  com.tencent.mm.plugin.sns.model.aj.faL().a((cnb)localObject5, (View)localObject1, 2131689567, hashCode(), bp.Oqs);
                  this.EBi = ((ImageView)((LinearLayout)localObject3).findViewById(2131308376));
                  this.EBi.setOnTouchListener(this.EqE);
                  this.dSF = ((TimeLineObject)localObject8).Id;
                  fhS();
                  bool1 = getIntent().getBooleanExtra("SNS_FROM_MUSIC_ITEM", false);
                  ((MMImageView)localObject1).setTag(new s((TimeLineObject)localObject8, this.EBf, bool1));
                  ((MMImageView)localObject1).setOnClickListener(this.EBo.ERq);
                  localObject7 = ((cnb)localObject5).Desc;
                  if (!Util.isNullOrNil((String)localObject7)) {
                    ((TextView)((LinearLayout)localObject3).findViewById(2131307116)).setText((CharSequence)localObject7);
                  }
                  localObject5 = ((cnb)localObject5).Title;
                  if (!Util.isNullOrNil((String)localObject5)) {
                    ((TextView)((LinearLayout)localObject3).findViewById(2131309253)).setText(new SpannableString((CharSequence)localObject5), TextView.BufferType.SPANNABLE);
                  }
                  ((LinearLayout)localObject3).setTag(new s((TimeLineObject)localObject8, this.EBf));
                  this.pqr.c((View)localObject3, this.Dyw.FaG, this.Dyw.Far);
                  ((LinearLayout)localObject3).setOnClickListener(this.EBo.EIc);
                  com.tencent.mm.plugin.sns.data.r.b((View)localObject1, this);
                  break;
                }
                ((LinearLayout)localObject3).setVisibility(8);
                break;
              }
              label7550:
              View localView;
              MMRoundCornerImageView localMMRoundCornerImageView;
              TextView localTextView1;
              TextView localTextView2;
              if (this.qcr == 24)
              {
                localObject1 = (LinearLayout)this.EAP.findViewById(2131308157);
                localObject12 = ZH(2131496458);
                if (!this.EBW)
                {
                  ((LinearLayout)localObject1).removeView(this.EBZ);
                  ((LinearLayout)localObject1).addView((View)localObject12, 3);
                  if (((LinearLayout)localObject12).getLayoutParams() != null)
                  {
                    localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject12).getLayoutParams());
                    ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cb.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                    ((LinearLayout)localObject12).setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  }
                }
                else
                {
                  this.dSF = ((TimeLineObject)localObject8).Id;
                  localObject1 = (RoundCornerRelativeLayout)((LinearLayout)localObject12).findViewById(2131307176);
                  ((RoundCornerRelativeLayout)localObject1).setRadius(com.tencent.mm.cb.a.fromDPToPix(getContext(), 4));
                  localView = ((RoundCornerRelativeLayout)localObject1).findViewById(2131297645);
                  localObject10 = ((RoundCornerRelativeLayout)localObject1).findViewById(2131305087);
                  if (!ao.isDarkMode()) {
                    break label8359;
                  }
                  ((View)localObject10).setBackgroundResource(2131234996);
                  localMMRoundCornerImageView = (MMRoundCornerImageView)((View)localObject10).findViewById(2131298519);
                  localTextView1 = (TextView)((View)localObject10).findViewById(2131298523);
                  localObject11 = (TextView)((View)localObject10).findViewById(2131298524);
                  localTextView2 = (TextView)((View)localObject10).findViewById(2131298521);
                  this.EBj = ((WeImageView)((View)localObject10).findViewById(2131298520));
                  this.EBj.setOnTouchListener(this.EqE);
                  localObject1 = "";
                  localObject7 = null;
                  localObject5 = localObject7;
                  localObject3 = localObject1;
                  if (localObject8 != null)
                  {
                    localObject5 = localObject7;
                    localObject3 = localObject1;
                    if (((TimeLineObject)localObject8).ContentObj != null) {
                      if (((TimeLineObject)localObject8).ContentObj.LoV.isEmpty()) {
                        break label16209;
                      }
                    }
                  }
                }
              }
              for (localObject1 = (cnb)((TimeLineObject)localObject8).ContentObj.LoV.get(0);; localObject1 = null)
              {
                if (((TimeLineObject)localObject8).ContentObj.jfy != null)
                {
                  localObject5 = ((TimeLineObject)localObject8).ContentObj.jfy.Ktq;
                  if (!Util.isNullOrNil((String)localObject5))
                  {
                    Log.i("MicroMsg.SnsCommentDetailUI", "has mvInfo:%s", new Object[] { localObject5 });
                    ((ViewGroup.MarginLayoutParams)((TextView)localObject11).getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 6);
                    ((ViewGroup.MarginLayoutParams)localTextView1.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2);
                    ((View)localObject10).findViewById(2131305768).setVisibility(0);
                    localTextView2.setVisibility(0);
                    localTextView2.setText((String)localObject5 + getContext().getString(2131763368));
                  }
                }
                for (localObject3 = ((TimeLineObject)localObject8).ContentObj.jfy.Ktp;; localObject3 = "")
                {
                  if (!Util.isNullOrNil((String)localObject3))
                  {
                    bool1 = true;
                    Log.i("MicroMsg.SnsCommentDetailUI", "coverInfo: hasCover:%b, postInfo:%s", new Object[] { Boolean.valueOf(bool1), localObject5 });
                    localObject5 = localObject1;
                    if (Util.isNullOrNil((String)localObject3)) {
                      break label8437;
                    }
                    localObject1 = com.tencent.mm.plugin.music.h.b.aIf((String)localObject3);
                  }
                  for (;;)
                  {
                    if (!Util.isNullOrNil((String)localObject3))
                    {
                      localObject7 = new c.a();
                      ((c.a)localObject7).OS((String)localObject1);
                      ((c.a)localObject7).bdp();
                      ((c.a)localObject7).bdt();
                      ((c.a)localObject7).bdo();
                      ((c.a)localObject7).bds();
                      ((c.a)localObject7).aw(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2));
                      localObject7 = ((c.a)localObject7).bdv();
                      com.tencent.mm.av.q.bcV().a((String)localObject3, localMMRoundCornerImageView, (com.tencent.mm.av.a.a.c)localObject7, new SnsCommentDetailUI.30(this, localView));
                      this.EBj.setPressed(false);
                      fhT();
                      if (localObject5 != null)
                      {
                        localObject3 = ((cnb)localObject5).Desc;
                        if ((((TimeLineObject)localObject8).ContentObj.jfy == null) || (Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.jfy.singerName))) {
                          break label8543;
                        }
                        localTextView1.setVisibility(0);
                        localTextView1.setText(((TimeLineObject)localObject8).ContentObj.jfy.singerName);
                        label8172:
                        if (localObject5 == null) {
                          break label8584;
                        }
                        localObject3 = ((cnb)localObject5).Title;
                        label8184:
                        if (Util.isNullOrNil((String)localObject3)) {
                          break label8592;
                        }
                        ((TextView)localObject11).setVisibility(0);
                        ((TextView)localObject11).setText(new SpannableString((CharSequence)localObject3), TextView.BufferType.SPANNABLE);
                      }
                      for (;;)
                      {
                        if (((TimeLineObject)localObject8).ContentObj.jfy == null) {
                          ((TimeLineObject)localObject8).ContentObj.jfy = new css();
                        }
                        ((TimeLineObject)localObject8).ContentObj.jfy.jfz = ((String)localObject1);
                        this.EBj.setTag(new s((TimeLineObject)localObject8, this.EBf));
                        this.EBj.setOnClickListener(this.EBo.ERr);
                        ((View)localObject10).setTag(new s((TimeLineObject)localObject8, this.EBf));
                        this.pqr.c((View)localObject10, this.Dyw.FaG, this.Dyw.Far);
                        ((View)localObject10).setOnClickListener(this.EBo.ERf);
                        break;
                        localObject1 = new LinearLayout.LayoutParams(-1, -2);
                        break label7550;
                        ((View)localObject10).setBackgroundResource(2131234997);
                        break label7653;
                        ((ViewGroup.MarginLayoutParams)((TextView)localObject11).getLayoutParams()).topMargin = 0;
                        ((ViewGroup.MarginLayoutParams)localTextView1.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4);
                        ((View)localObject10).findViewById(2131305768).setVisibility(8);
                        localTextView2.setText("");
                        localTextView2.setVisibility(8);
                        break label7937;
                        bool1 = false;
                        break label7961;
                        label8437:
                        if (localObject5 == null) {
                          break label16188;
                        }
                        if (!Util.isNullOrNil(((cnb)localObject5).Msz))
                        {
                          localObject3 = ((cnb)localObject5).Msz;
                          localObject1 = com.tencent.mm.plugin.music.h.b.aIf(((cnb)localObject5).Msz);
                          break label8006;
                        }
                        localObject1 = com.tencent.mm.plugin.sns.model.aj.faD().JK(((cnb)localObject5).ecf);
                        localObject3 = com.tencent.mm.plugin.sns.data.r.aOj(((com.tencent.mm.plugin.sns.storage.q)localObject1).ffb());
                        localObject3 = com.tencent.mm.plugin.sns.model.ar.ki(com.tencent.mm.plugin.sns.model.aj.getAccSnsPath(), ((com.tencent.mm.plugin.sns.storage.q)localObject1).ffb()) + (String)localObject3;
                        localObject1 = localObject3;
                        break label8006;
                        localObject3 = "";
                        break label8122;
                        if (!Util.isNullOrNil((String)localObject3))
                        {
                          localTextView1.setVisibility(0);
                          localTextView1.setText((CharSequence)localObject3);
                          break label8172;
                        }
                        localTextView1.setText("");
                        localTextView1.setVisibility(0);
                        break label8172;
                        localObject3 = "";
                        break label8184;
                        Log.e("MicroMsg.SnsCommentDetailUI", "Not allow title is empty");
                      }
                    }
                    ((LinearLayout)localObject12).setVisibility(8);
                    break;
                    if (this.qcr == 13)
                    {
                      this.EAQ.setVisibility(8);
                      this.EAV.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                      break;
                    }
                    if ((this.qcr == 11) || (this.qcr == 14) || (this.qcr == 15)) {
                      break;
                    }
                    if (this.qcr == 16)
                    {
                      localObject1 = (LinearLayout)this.EAP.findViewById(2131308157);
                      localObject5 = ZH(2131496457);
                      if (!this.EBW)
                      {
                        ((LinearLayout)localObject1).removeView(this.EBZ);
                        ((LinearLayout)localObject1).addView((View)localObject5, 3);
                        if (((LinearLayout)localObject5).getLayoutParams() != null)
                        {
                          localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject5).getLayoutParams());
                          ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cb.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                          ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject1);
                        }
                      }
                      else
                      {
                        localObject7 = (MMImageView)((LinearLayout)localObject5).findViewById(2131302578);
                        ((MMImageView)localObject7).setVisibility(0);
                        localObject10 = (TextView)((LinearLayout)localObject5).findViewById(2131309253);
                        if (((TimeLineObject)localObject8).ContentObj.dME == null) {
                          break label9258;
                        }
                        Log.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderShareObject not null");
                        if ((!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.dME.nickname)) || (Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.dME.desc))) {
                          break label9162;
                        }
                        localObject1 = ((TimeLineObject)localObject8).ContentObj.dME.desc;
                      }
                      for (;;)
                      {
                        ((TextView)localObject10).setText(new SpannableString((CharSequence)localObject1), TextView.BufferType.SPANNABLE);
                        ((TextView)localObject10).setMaxLines(2);
                        if (!((TimeLineObject)localObject8).ContentObj.dME.mediaList.isEmpty())
                        {
                          localObject1 = new cnb();
                          ((cnb)localObject1).Url = ((bch)((TimeLineObject)localObject8).ContentObj.dME.mediaList.get(0)).thumbUrl;
                          ((cnb)localObject1).Msz = ((bch)((TimeLineObject)localObject8).ContentObj.dME.mediaList.get(0)).thumbUrl;
                          ((cnb)localObject1).oUv = 2;
                          ((cnb)localObject1).MsA = 1;
                          ((cnb)localObject1).MsB = new cnd();
                          ((cnb)localObject1).Mcw = 1;
                          ((cnb)localObject1).MsB.Mto = ((bch)((TimeLineObject)localObject8).ContentObj.dME.mediaList.get(0)).width;
                          ((cnb)localObject1).MsB.Mtp = ((bch)((TimeLineObject)localObject8).ContentObj.dME.mediaList.get(0)).height;
                          ((cnb)localObject1).Id = localSnsInfo.getSnsId();
                          com.tencent.mm.plugin.sns.model.aj.faL().b((cnb)localObject1, (View)localObject7, hashCode(), bp.gCU().akk(((TimeLineObject)localObject8).CreateTime));
                        }
                        ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject8, this.EBf));
                        ((LinearLayout)localObject5).setOnClickListener(this.EBo.EIc);
                        break;
                        localObject1 = new LinearLayout.LayoutParams(-1, -2);
                        break label8758;
                        if (!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.dME.desc)) {
                          localObject1 = ((TimeLineObject)localObject8).ContentObj.dME.nickname + ": " + ((TimeLineObject)localObject8).ContentObj.dME.desc;
                        } else {
                          localObject1 = getString(2131766209, new Object[] { ((TimeLineObject)localObject8).ContentObj.dME.nickname });
                        }
                      }
                      if (((TimeLineObject)localObject8).ContentObj.Lpd != null)
                      {
                        Log.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.megaVideoShareObject not null");
                        if ((Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.Lpd.nickname)) && (!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.Lpd.desc)))
                        {
                          localObject1 = ((TimeLineObject)localObject8).ContentObj.Lpd.desc;
                          label9325:
                          ((TextView)localObject10).setText(new SpannableString((CharSequence)localObject1), TextView.BufferType.SPANNABLE);
                          ((TextView)localObject10).setMaxLines(2);
                          if (!((TimeLineObject)localObject8).ContentObj.Lpd.mediaList.isEmpty())
                          {
                            localObject3 = new cnb();
                            if (TextUtils.isEmpty(((cok)((TimeLineObject)localObject8).ContentObj.Lpd.mediaList.get(0)).coverUrl)) {
                              break label9690;
                            }
                          }
                        }
                        for (localObject1 = ((cok)((TimeLineObject)localObject8).ContentObj.Lpd.mediaList.get(0)).coverUrl;; localObject1 = ((cok)((TimeLineObject)localObject8).ContentObj.Lpd.mediaList.get(0)).thumbUrl)
                        {
                          ((cnb)localObject3).Url = ((String)localObject1);
                          ((cnb)localObject3).Msz = ((String)localObject1);
                          ((cnb)localObject3).oUv = 2;
                          ((cnb)localObject3).MsA = 1;
                          ((cnb)localObject3).MsB = new cnd();
                          ((cnb)localObject3).Mcw = 1;
                          ((cnb)localObject3).MsB.Mto = ((cok)((TimeLineObject)localObject8).ContentObj.Lpd.mediaList.get(0)).width;
                          ((cnb)localObject3).MsB.Mtp = ((cok)((TimeLineObject)localObject8).ContentObj.Lpd.mediaList.get(0)).height;
                          ((cnb)localObject3).Id = localSnsInfo.getSnsId();
                          com.tencent.mm.plugin.sns.model.aj.faL().b((cnb)localObject3, (View)localObject7, hashCode(), bp.gCU().akk(((TimeLineObject)localObject8).CreateTime));
                          ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject8, this.EBf));
                          ((LinearLayout)localObject5).setOnClickListener(this.EBo.EIc);
                          break;
                          if (!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.Lpd.desc))
                          {
                            localObject1 = ((TimeLineObject)localObject8).ContentObj.Lpd.nickname + ": " + ((TimeLineObject)localObject8).ContentObj.Lpd.desc;
                            break label9325;
                          }
                          localObject1 = getString(2131766209, new Object[] { ((TimeLineObject)localObject8).ContentObj.Lpd.nickname });
                          break label9325;
                        }
                      }
                      if (((TimeLineObject)localObject8).ContentObj.LoZ != null)
                      {
                        Log.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderShareTopic not null");
                        localObject3 = getString(2131755857);
                        if (((TimeLineObject)localObject8).ContentObj.LoZ != null)
                        {
                          if (((TimeLineObject)localObject8).ContentObj.LoZ.tvC != 1) {
                            break label10040;
                          }
                          localObject1 = "#" + ((TimeLineObject)localObject8).ContentObj.LoZ.dST;
                        }
                        for (;;)
                        {
                          localObject3 = localObject1;
                          if (!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.LoZ.desc))
                          {
                            localObject3 = (TextView)((LinearLayout)localObject5).findViewById(2131307116);
                            ((TextView)localObject3).setVisibility(0);
                            ((TextView)localObject3).setText(((TimeLineObject)localObject8).ContentObj.LoZ.desc);
                            localObject3 = localObject1;
                          }
                          ((TextView)localObject10).setText(new SpannableString((CharSequence)localObject3), TextView.BufferType.SPANNABLE);
                          ((TextView)localObject10).setMaxLines(2);
                          localObject1 = new cnb();
                          ((cnb)localObject1).Url = ((TimeLineObject)localObject8).ContentObj.LoZ.iconUrl;
                          ((cnb)localObject1).Msz = ((TimeLineObject)localObject8).ContentObj.LoZ.iconUrl;
                          ((cnb)localObject1).oUv = 2;
                          ((cnb)localObject1).MsA = 1;
                          ((cnb)localObject1).MsB = new cnd();
                          ((cnb)localObject1).Mcw = 1;
                          ((cnb)localObject1).MsB.Mto = 0.0F;
                          ((cnb)localObject1).MsB.Mtp = 0.0F;
                          ((cnb)localObject1).Id = localSnsInfo.getSnsId();
                          com.tencent.mm.plugin.sns.model.aj.faL().b((cnb)localObject1, (View)localObject7, hashCode(), bp.gCU().akk(((TimeLineObject)localObject8).CreateTime));
                          ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject8, this.EBf));
                          ((LinearLayout)localObject5).setOnClickListener(this.EBo.EIc);
                          break;
                          if ((((TimeLineObject)localObject8).ContentObj.LoZ.tvC == 7) && (((TimeLineObject)localObject8).ContentObj.LoZ.LLD != null)) {
                            localObject1 = MMApplicationContext.getContext().getString(2131766207, new Object[] { ((TimeLineObject)localObject8).ContentObj.LoZ.LLD.LAr, ((TimeLineObject)localObject8).ContentObj.LoZ.LLD.LAq });
                          } else {
                            localObject1 = ((TimeLineObject)localObject8).ContentObj.LoZ.dST;
                          }
                        }
                      }
                      if (((TimeLineObject)localObject8).ContentObj.Lpe != null)
                      {
                        Log.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderShareTopic not null");
                        localObject1 = getString(2131755857);
                        if (((TimeLineObject)localObject8).ContentObj.Lpe == null) {
                          break label16181;
                        }
                        if ((((TimeLineObject)localObject8).ContentObj.Lpe.tvC != 7) || (((TimeLineObject)localObject8).ContentObj.Lpe.LLD == null)) {
                          break label16178;
                        }
                        localObject1 = MMApplicationContext.getContext().getString(2131766207, new Object[] { ((TimeLineObject)localObject8).ContentObj.Lpe.LLD.LAr, ((TimeLineObject)localObject8).ContentObj.Lpe.LLD.LAq });
                        localObject3 = localObject1;
                        if (!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.Lpe.desc))
                        {
                          localObject3 = (TextView)((LinearLayout)localObject5).findViewById(2131307116);
                          ((TextView)localObject3).setVisibility(0);
                          ((TextView)localObject3).setText(((TimeLineObject)localObject8).ContentObj.LoZ.desc);
                        }
                      }
                    }
                    for (localObject3 = localObject1;; localObject3 = localObject1)
                    {
                      ((TextView)localObject10).setText(new SpannableString((CharSequence)localObject3), TextView.BufferType.SPANNABLE);
                      ((TextView)localObject10).setMaxLines(2);
                      localObject1 = new cnb();
                      ((cnb)localObject1).Url = ((TimeLineObject)localObject8).ContentObj.Lpe.iconUrl;
                      ((cnb)localObject1).Msz = ((TimeLineObject)localObject8).ContentObj.Lpe.iconUrl;
                      ((cnb)localObject1).oUv = 2;
                      ((cnb)localObject1).MsA = 1;
                      ((cnb)localObject1).MsB = new cnd();
                      ((cnb)localObject1).Mcw = 1;
                      ((cnb)localObject1).MsB.Mto = 0.0F;
                      ((cnb)localObject1).MsB.Mtp = 0.0F;
                      ((cnb)localObject1).Id = localSnsInfo.getSnsId();
                      com.tencent.mm.plugin.sns.model.aj.faL().b((cnb)localObject1, (View)localObject7, hashCode(), bp.gCU().akk(((TimeLineObject)localObject8).CreateTime));
                      ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject8, this.EBf));
                      ((LinearLayout)localObject5).setOnClickListener(this.EBo.EIc);
                      break;
                      if (((TimeLineObject)localObject8).ContentObj.Lpb != null)
                      {
                        ((TextView)localObject10).setText(new SpannableString(((TimeLineObject)localObject8).ContentObj.Lpb.title), TextView.BufferType.SPANNABLE);
                        ((TextView)localObject10).setMaxLines(2);
                        localObject1 = new cnb();
                        ((cnb)localObject1).Url = ((String)((TimeLineObject)localObject8).ContentObj.Lpb.LLt.get(0) + (String)((TimeLineObject)localObject8).ContentObj.Lpb.LLu.get(0));
                        ((cnb)localObject1).Msz = ((cnb)localObject1).Url;
                        ((cnb)localObject1).oUv = 2;
                        ((cnb)localObject1).MsA = 1;
                        ((cnb)localObject1).MsB = new cnd();
                        ((cnb)localObject1).Mcw = 1;
                        ((cnb)localObject1).MsB.Mto = 0.0F;
                        ((cnb)localObject1).MsB.Mtp = 0.0F;
                        ((cnb)localObject1).Id = localSnsInfo.getSnsId();
                        com.tencent.mm.plugin.sns.model.aj.faL().b((cnb)localObject1, (View)localObject7, hashCode(), bp.gCU().akk(((TimeLineObject)localObject8).CreateTime));
                        ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject8, this.EBf));
                        ((LinearLayout)localObject5).setOnClickListener(this.EBo.EIc);
                        break;
                      }
                      if (((TimeLineObject)localObject8).ContentObj.Lpc == null) {
                        break;
                      }
                      Log.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderLiveShareObject not null");
                      if ((Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.Lpc.nickName)) && (!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.Lpc.desc))) {
                        localObject1 = ((TimeLineObject)localObject8).ContentObj.Lpc.desc;
                      }
                      for (;;)
                      {
                        ((TextView)localObject10).setText(new SpannableString((CharSequence)localObject1), TextView.BufferType.SPANNABLE);
                        ((TextView)localObject10).setMaxLines(2);
                        if (!((TimeLineObject)localObject8).ContentObj.Lpc.coverUrl.isEmpty())
                        {
                          localObject1 = new cnb();
                          ((cnb)localObject1).Url = ((TimeLineObject)localObject8).ContentObj.Lpc.coverUrl;
                          ((cnb)localObject1).Msz = ((TimeLineObject)localObject8).ContentObj.Lpc.coverUrl;
                          ((cnb)localObject1).oUv = 2;
                          ((cnb)localObject1).MsA = 1;
                          ((cnb)localObject1).MsB = new cnd();
                          ((cnb)localObject1).Mcw = 1;
                          ((cnb)localObject1).MsB.Mto = ((TimeLineObject)localObject8).ContentObj.Lpc.width;
                          ((cnb)localObject1).MsB.Mtp = ((TimeLineObject)localObject8).ContentObj.Lpc.height;
                          ((cnb)localObject1).Id = localSnsInfo.getSnsId();
                          com.tencent.mm.plugin.sns.model.aj.faL().b((cnb)localObject1, (View)localObject7, hashCode(), bp.gCU().akk(((TimeLineObject)localObject8).CreateTime));
                        }
                        ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject8, this.EBf));
                        ((LinearLayout)localObject5).setOnClickListener(this.EBo.EIc);
                        break;
                        if (!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.Lpc.desc)) {
                          localObject1 = ((TimeLineObject)localObject8).ContentObj.Lpc.nickName + ": " + ((TimeLineObject)localObject8).ContentObj.Lpc.desc;
                        } else {
                          localObject1 = getString(2131766209, new Object[] { ((TimeLineObject)localObject8).ContentObj.Lpc.nickName });
                        }
                      }
                      if (this.qcr == 17)
                      {
                        localObject1 = (LinearLayout)this.EAP.findViewById(2131308157);
                        localObject3 = ZH(2131496457);
                        if (!this.EBW)
                        {
                          ((LinearLayout)localObject1).removeView(this.EBZ);
                          ((LinearLayout)localObject1).addView((View)localObject3, 3);
                          if (((LinearLayout)localObject3).getLayoutParams() == null) {
                            break label11558;
                          }
                        }
                        for (localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject3).getLayoutParams());; localObject1 = new LinearLayout.LayoutParams(-1, -2))
                        {
                          ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cb.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                          ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
                          if (((TimeLineObject)localObject8).ContentObj.Lpa == null) {
                            break label11573;
                          }
                          localObject1 = (MMImageView)((LinearLayout)localObject3).findViewById(2131302578);
                          ((MMImageView)localObject1).setVisibility(0);
                          localObject5 = new cnb();
                          ((cnb)localObject5).Url = ((TimeLineObject)localObject8).ContentObj.Lpa.iAo;
                          ((cnb)localObject5).Msz = ((TimeLineObject)localObject8).ContentObj.Lpa.iAo;
                          ((cnb)localObject5).oUv = 2;
                          ((cnb)localObject5).MsA = 1;
                          ((cnb)localObject5).MsB = new cnd();
                          ((cnb)localObject5).Mcw = 1;
                          ((cnb)localObject5).MsB.Mto = ((TimeLineObject)localObject8).ContentObj.Lpa.width;
                          ((cnb)localObject5).MsB.Mtp = ((TimeLineObject)localObject8).ContentObj.Lpa.height;
                          ((cnb)localObject5).Id = localSnsInfo.getSnsId();
                          com.tencent.mm.plugin.sns.model.aj.faL().b((cnb)localObject5, (View)localObject1, hashCode(), bp.gCU().akk(((TimeLineObject)localObject8).CreateTime));
                          localObject5 = (ImageView)((LinearLayout)localObject3).findViewById(2131308376);
                          ((ImageView)localObject5).setVisibility(0);
                          ((ImageView)localObject5).setImageDrawable(com.tencent.mm.ui.ar.m(((ImageView)localObject5).getContext(), 2131690929, -1));
                          localObject5 = ((TimeLineObject)localObject8).ContentObj.Lpa.title;
                          if (!Util.isNullOrNil((String)localObject5))
                          {
                            localObject7 = (TextView)((LinearLayout)localObject3).findViewById(2131309253);
                            ((TextView)localObject7).setMaxLines(2);
                            ((TextView)localObject7).setText(new SpannableString((CharSequence)localObject5), TextView.BufferType.SPANNABLE);
                          }
                          ((LinearLayout)localObject3).setTag(new ai((TimeLineObject)localObject8, (View)localObject1, localSnsInfo.getLocalid()));
                          ((LinearLayout)localObject3).setOnClickListener(this.EBo.ERc);
                          this.pqr.c((View)localObject3, this.Dyw.FaM, this.Dyw.Far);
                          com.tencent.mm.plugin.sns.data.r.b((View)localObject1, this);
                          break;
                        }
                        ((LinearLayout)localObject3).setVisibility(8);
                        break;
                      }
                      if ((this.qcr == 18) || (this.qcr == 21))
                      {
                        localObject1 = this.EAP.findViewById(2131308123);
                        localObject3 = (ImageView)this.EAP.findViewById(2131308126);
                        localObject5 = (ImageIndicatorView)this.EAP.findViewById(2131308124);
                        localObject7 = (ImageView)this.EAP.findViewById(2131308127);
                        if ((localObject8 != null) && (((TimeLineObject)localObject8).ContentObj != null) && (((TimeLineObject)localObject8).ContentObj.dME != null))
                        {
                          localObject10 = ((TimeLineObject)localObject8).ContentObj.dME;
                          if (!Util.isNullOrNil(((bcj)localObject10).mediaList))
                          {
                            localObject11 = (bch)((bcj)localObject10).mediaList.get(0);
                            if (localObject11 != null)
                            {
                              if (((bcj)localObject10).vXJ != 4) {
                                break label11889;
                              }
                              localObject12 = com.tencent.mm.modelsns.n.a((int)((bch)localObject11).width, (int)((bch)localObject11).height, this, false);
                              i = ((Integer)((Pair)localObject12).first).intValue();
                              j = ((Integer)((Pair)localObject12).second).intValue();
                              ((View)localObject1).getLayoutParams().width = i;
                              ((View)localObject1).getLayoutParams().height = j;
                              ((View)localObject1).requestLayout();
                              ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).loadImage(((bch)localObject11).thumbUrl, (ImageView)localObject7);
                            }
                          }
                          if (((bcj)localObject10).vXJ == 4)
                          {
                            ((ImageView)localObject3).setVisibility(0);
                            ((ImageIndicatorView)localObject5).setVisibility(8);
                          }
                          for (;;)
                          {
                            ((View)localObject1).setTag(localObject8);
                            ((View)localObject1).setOnClickListener(this.EBo.ERh);
                            this.pqr.c((View)localObject1, this.Dyw.FaN, this.Dyw.Far);
                            break;
                            label11889:
                            localObject12 = com.tencent.mm.modelsns.n.a((int)((bch)localObject11).width, (int)((bch)localObject11).height, this);
                            i = ((Integer)((Pair)localObject12).first).intValue();
                            j = ((Integer)((Pair)localObject12).second).intValue();
                            ((View)localObject1).getLayoutParams().width = i;
                            ((View)localObject1).getLayoutParams().height = j;
                            ((View)localObject1).requestLayout();
                            break label11801;
                            ((ImageView)localObject3).setVisibility(8);
                            ((ImageIndicatorView)localObject5).setVisibility(8);
                            ((ImageIndicatorView)localObject5).aan(((bcj)localObject10).dJl);
                          }
                        }
                        if ((localObject8 == null) || (((TimeLineObject)localObject8).ContentObj == null) || (((TimeLineObject)localObject8).ContentObj.Lpd == null)) {
                          break;
                        }
                        localObject10 = ((TimeLineObject)localObject8).ContentObj.Lpd;
                        if (!Util.isNullOrNil(((col)localObject10).mediaList))
                        {
                          localObject10 = (cok)((col)localObject10).mediaList.get(0);
                          if (localObject10 != null)
                          {
                            localObject11 = com.tencent.mm.modelsns.n.a((int)((cok)localObject10).width, (int)((cok)localObject10).height, this, false);
                            i = ((Integer)((Pair)localObject11).first).intValue();
                            j = ((Integer)((Pair)localObject11).second).intValue();
                            ((View)localObject1).getLayoutParams().width = i;
                            ((View)localObject1).getLayoutParams().height = j;
                            ((View)localObject1).requestLayout();
                            if (TextUtils.isEmpty(((cok)localObject10).coverUrl)) {
                              break label12212;
                            }
                            ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).loadImage(((cok)localObject10).coverUrl, (ImageView)localObject7);
                          }
                        }
                        for (;;)
                        {
                          ((ImageView)localObject3).setVisibility(0);
                          ((ImageIndicatorView)localObject5).setVisibility(8);
                          ((View)localObject1).setTag(localObject8);
                          ((View)localObject1).setOnClickListener(this.EBo.ERh);
                          this.pqr.c((View)localObject1, this.Dyw.FaN, this.Dyw.Far);
                          break;
                          ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).loadImage(((cok)localObject10).thumbUrl, (ImageView)localObject7);
                        }
                      }
                      if (this.qcr == 20)
                      {
                        localObject1 = this.EAP.findViewById(2131308123);
                        if ((localObject8 == null) || (((TimeLineObject)localObject8).ContentObj == null) || (((TimeLineObject)localObject8).ContentObj.Lpc == null)) {
                          break;
                        }
                        localObject3 = ((TimeLineObject)localObject8).ContentObj.Lpc;
                        localObject5 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap.ha(((View)localObject1).getContext());
                        localObject5 = com.tencent.mm.modelsns.n.a(localObject5[0], localObject5[1], ((View)localObject1).getContext(), false);
                        i = ((Integer)((Pair)localObject5).first).intValue();
                        ((Integer)((Pair)localObject5).second).intValue();
                        localObject5 = (LinearLayout.LayoutParams)((View)localObject1).getLayoutParams();
                        ((LinearLayout.LayoutParams)localObject5).width = i;
                        ((LinearLayout.LayoutParams)localObject5).height = ((int)(i * 3.5F / 3.0F));
                        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject5);
                        ((View)localObject1).requestLayout();
                        if (((axf)localObject3).liveStatus == 1) {
                          ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).loadImage(((axf)localObject3).coverUrl, (ImageView)this.EAP.findViewById(2131308127));
                        }
                        long l1 = 0L;
                        try
                        {
                          long l2 = Long.parseLong(((axf)localObject3).hJs);
                          l1 = l2;
                        }
                        catch (NumberFormatException localNumberFormatException)
                        {
                          for (;;)
                          {
                            Log.e("MicroMsg.SnsCommentDetailUI", localNumberFormatException.getMessage());
                          }
                        }
                        ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).refreshLiveStatus(Long.valueOf(l1), new SnsCommentDetailUI.31(this, l1, (TimeLineObject)localObject8, (axf)localObject3));
                        ((View)localObject1).setTag(localObject8);
                        ((View)localObject1).setOnClickListener(this.EBo.ERe);
                        this.pqr.c((View)localObject1, this.Dyw.FaN, this.Dyw.Far);
                        break;
                      }
                      if (this.qcr == 23)
                      {
                        Log.d("MicroMsg.SnsCommentDetailUI", "this is finder topic card item");
                        break;
                      }
                      localObject1 = (LinearLayout)this.EAP.findViewById(2131308157);
                      localObject7 = ZH(2131496457);
                      localObject10 = (MMImageView)((LinearLayout)localObject7).findViewById(2131302578);
                      if (!this.EBW)
                      {
                        ((LinearLayout)localObject1).removeView(this.EBZ);
                        ((LinearLayout)localObject1).addView((View)localObject7, 3);
                        if (((LinearLayout)localObject7).getLayoutParams() != null)
                        {
                          localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject7).getLayoutParams());
                          label12647:
                          ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cb.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                          ((LinearLayout)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject1);
                        }
                      }
                      else
                      {
                        i = 0;
                        if (!localSnsInfo.isAd()) {
                          break label13122;
                        }
                        if (localSnsInfo.getAdXml().isLinkAd())
                        {
                          i = 1;
                          ((LinearLayout)localObject7).setTag(localSnsInfo);
                          ((LinearLayout)localObject7).setTag(2131303213, localObject10);
                          ((LinearLayout)localObject7).setOnClickListener(this.Dyw.Fbi);
                        }
                        j = 0;
                      }
                      for (;;)
                      {
                        if (i != 0)
                        {
                          this.pqr.c((View)localObject7, this.Dyw.FaK, this.Dyw.Far);
                          if (!fhO()) {
                            break label13947;
                          }
                          localObject1 = bk.aRf(((TimeLineObject)localObject8).ContentObj.Url);
                          label12784:
                          localObject3 = ((TimeLineObject)localObject8).ContentObj.Title;
                          if (i != 0) {
                            localObject1 = ((TimeLineObject)localObject8).ContentObj.Desc;
                          }
                          if ((((TimeLineObject)localObject8).ContentObj.LoY == null) || (((TimeLineObject)localObject8).ContentObj.LoY.iwf != 1)) {
                            break label16166;
                          }
                          localObject1 = MMApplicationContext.getContext().getString(2131763172);
                        }
                        for (;;)
                        {
                          ((LinearLayout)localObject7).findViewById(2131308376).setVisibility(8);
                          if (!((TimeLineObject)localObject8).ContentObj.LoV.isEmpty())
                          {
                            ((MMImageView)localObject10).setVisibility(0);
                            localObject6 = (cnb)((TimeLineObject)localObject8).ContentObj.LoV.get(0);
                            if (((TimeLineObject)localObject8).ContentObj.LoU == 15)
                            {
                              ((ImageView)((LinearLayout)localObject7).findViewById(2131308376)).setImageResource(2131234185);
                              ((ImageView)((LinearLayout)localObject7).findViewById(2131308376)).setVisibility(0);
                              com.tencent.mm.plugin.sns.model.aj.faL().a((cnb)localObject6, (View)localObject10, 2131689584, hashCode(), bp.gCU().akk(((TimeLineObject)localObject8).CreateTime));
                              localObject6 = localObject3;
                              localObject3 = localObject1;
                              localObject1 = localObject6;
                              com.tencent.mm.plugin.sns.data.r.b((View)localObject10, this);
                              if (((TimeLineObject)localObject8).ContentObj.LoU != 15) {
                                break label16163;
                              }
                              localObject1 = getString(2131766052);
                              localObject3 = "";
                            }
                          }
                          for (;;)
                          {
                            localObject6 = (TextView)((LinearLayout)localObject7).findViewById(2131309253);
                            if (!Util.isNullOrNil((String)localObject3))
                            {
                              ((LinearLayout)localObject7).findViewById(2131307116).setVisibility(0);
                              ((TextView)((LinearLayout)localObject7).findViewById(2131307116)).setText((CharSequence)localObject3);
                              ((TextView)localObject6).setMaxLines(1);
                            }
                            for (;;)
                            {
                              if (!Util.isNullOrNil((String)localObject1))
                              {
                                ((TextView)localObject6).setVisibility(0);
                                if (j != 0)
                                {
                                  ((TextView)localObject6).setText(com.tencent.mm.plugin.sns.data.r.a((String)localObject1, getContext(), (TextView)localObject6));
                                  break;
                                  localObject1 = new LinearLayout.LayoutParams(-1, -2);
                                  break label12647;
                                  if (((TimeLineObject)localObject8).ContentObj.LoU == 9)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.LoV.size() <= 0) {
                                      break label16169;
                                    }
                                    ((LinearLayout)localObject7).setTag(new s((TimeLineObject)localObject8, this.EBf));
                                    ((LinearLayout)localObject7).setOnClickListener(this.EBo.ERk);
                                    i = 0;
                                    j = 0;
                                    break label12737;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.LoU == 10)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.LoV.size() <= 0) {
                                      break label16169;
                                    }
                                    ((LinearLayout)localObject7).setTag(new s((TimeLineObject)localObject8, this.EBf));
                                    ((LinearLayout)localObject7).setOnClickListener(this.EBo.ERm);
                                    i = 0;
                                    j = 0;
                                    break label12737;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.LoU == 17)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.LoV.size() <= 0) {
                                      break label16169;
                                    }
                                    ((LinearLayout)localObject7).setTag(new s((TimeLineObject)localObject8, this.EBf));
                                    ((LinearLayout)localObject7).setOnClickListener(this.EBo.ERn);
                                    i = 0;
                                    j = 0;
                                    break label12737;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.LoU == 22)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.LoV.size() <= 0) {
                                      break label16169;
                                    }
                                    ((LinearLayout)localObject7).setTag(new s((TimeLineObject)localObject8, this.EBf));
                                    ((LinearLayout)localObject7).setOnClickListener(this.EBo.ERo);
                                    i = 0;
                                    j = 0;
                                    break label12737;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.LoU == 23)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.LoV.size() <= 0) {
                                      break label16169;
                                    }
                                    ((LinearLayout)localObject7).setTag(new s((TimeLineObject)localObject8, this.EBf));
                                    ((LinearLayout)localObject7).setOnClickListener(this.EBo.ERp);
                                    i = 0;
                                    j = 0;
                                    break label12737;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.LoU == 14)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.LoV.size() <= 0) {
                                      break label16169;
                                    }
                                    ((LinearLayout)localObject7).setTag(new s((TimeLineObject)localObject8, this.EBf));
                                    ((LinearLayout)localObject7).setOnClickListener(this.EBo.ERl);
                                    i = 0;
                                    j = 0;
                                    break label12737;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.LoU == 12)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.LoV.size() <= 0) {
                                      break label16169;
                                    }
                                    ((LinearLayout)localObject7).setTag(new s((TimeLineObject)localObject8, this.EBf));
                                    ((LinearLayout)localObject7).setOnClickListener(this.EBo.ERv);
                                    i = 0;
                                    j = 0;
                                    break label12737;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.LoU == 30)
                                  {
                                    ((LinearLayout)localObject7).setTag(new s((TimeLineObject)localObject8, this.EBf));
                                    ((LinearLayout)localObject7).setOnClickListener(this.EBo.ERt);
                                    i = 0;
                                    j = 0;
                                    break label12737;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.LoU == 13)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.LoV.size() <= 0) {
                                      break label16169;
                                    }
                                    ((LinearLayout)localObject7).setTag(new s((TimeLineObject)localObject8, this.EBf));
                                    ((LinearLayout)localObject7).setOnClickListener(this.EBo.ERw);
                                    i = 0;
                                    j = 0;
                                    break label12737;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.LoU == 15)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.LoV.size() <= 0) {
                                      break label16169;
                                    }
                                    ((LinearLayout)localObject7).setTag(new s((TimeLineObject)localObject8, this.EBf));
                                    ((LinearLayout)localObject7).setOnClickListener(this.Dyw.FaR);
                                    i = 0;
                                    j = 0;
                                    break label12737;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.LoU == 26)
                                  {
                                    ((LinearLayout)localObject7).setTag(new s((TimeLineObject)localObject8, this.EBf));
                                    ((LinearLayout)localObject7).setOnClickListener(this.EBo.ERx);
                                    i = 0;
                                    j = 0;
                                    break label12737;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.LoU == 41)
                                  {
                                    ((LinearLayout)localObject7).setTag(new s((TimeLineObject)localObject8, this.EBf));
                                    ((LinearLayout)localObject7).setOnClickListener(this.EBo.ERy);
                                    i = 0;
                                    j = 0;
                                    break label12737;
                                  }
                                  ((LinearLayout)localObject7).setTag(new s((TimeLineObject)localObject8, this.EBf));
                                  ((LinearLayout)localObject7).setOnClickListener(this.EBo.EIc);
                                  if ((((TimeLineObject)localObject8).contentattr & 0x1) <= 0) {
                                    break label16169;
                                  }
                                  i = 0;
                                  j = 1;
                                  break label12737;
                                  this.pqr.c((View)localObject7, this.Dyw.FaG, this.Dyw.Far);
                                  break label12765;
                                  label13947:
                                  localObject1 = "";
                                  break label12784;
                                  if (((TimeLineObject)localObject8).ContentObj.LoU == 5)
                                  {
                                    localObject3 = bk.aRf(((cnb)localObject6).Url);
                                    localObject1 = ((cnb)localObject6).Title;
                                    ((LinearLayout)localObject7).findViewById(2131308376).setVisibility(0);
                                    com.tencent.mm.plugin.sns.model.aj.faL().a((cnb)localObject6, (View)localObject10, 2131689584, hashCode(), bp.Oqs);
                                    break label12981;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.LoU == 18)
                                  {
                                    ((LinearLayout)localObject7).findViewById(2131308376).setVisibility(0);
                                    ((ImageView)((LinearLayout)localObject7).findViewById(2131308376)).setImageResource(2131235417);
                                    ((MMImageView)localObject10).setVisibility(0);
                                    com.tencent.mm.plugin.sns.model.aj.faL().a((cnb)localObject6, (View)localObject10, 2131689584, hashCode(), bp.Oqs);
                                    localObject6 = localObject1;
                                    localObject1 = localObject3;
                                    localObject3 = localObject6;
                                    break label12981;
                                  }
                                  com.tencent.mm.plugin.sns.model.aj.faL().b((cnb)localObject6, (View)localObject10, hashCode(), bp.Oqs);
                                  localObject6 = localObject1;
                                  localObject1 = localObject3;
                                  localObject3 = localObject6;
                                  break label12981;
                                  if (((TimeLineObject)localObject8).ContentObj.LoU == 18)
                                  {
                                    ((ImageView)((LinearLayout)localObject7).findViewById(2131308376)).setVisibility(0);
                                    ((ImageView)((LinearLayout)localObject7).findViewById(2131308376)).setImageResource(2131235417);
                                    ((MMImageView)localObject10).setVisibility(0);
                                    com.tencent.mm.plugin.sns.model.aj.faL().d((View)localObject10, -1, 2131689584, hashCode());
                                    localObject6 = localObject1;
                                    localObject1 = localObject3;
                                    localObject3 = localObject6;
                                    break label12981;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.LoU == 26)
                                  {
                                    ((MMImageView)localObject10).setVisibility(0);
                                    com.tencent.mm.plugin.sns.model.aj.faL().d((View)localObject10, -1, 2131691246, hashCode());
                                    localObject6 = localObject1;
                                    localObject1 = localObject3;
                                    localObject3 = localObject6;
                                    break label12981;
                                  }
                                  ((MMImageView)localObject10).setVisibility(0);
                                  com.tencent.mm.plugin.sns.model.aj.faL().d((View)localObject10, -1, 2131689587, hashCode());
                                  localObject6 = localObject1;
                                  localObject1 = localObject3;
                                  localObject3 = localObject6;
                                  break label12981;
                                  ((LinearLayout)localObject7).findViewById(2131307116).setVisibility(8);
                                  ((TextView)localObject6).setMaxLines(2);
                                  continue;
                                }
                                ((TextView)localObject6).setText((CharSequence)localObject1);
                                break;
                              }
                            }
                            ((TextView)localObject6).setVisibility(8);
                            break;
                            ((TextView)localObject6).setVisibility(0);
                            if (Util.isNullOrNil((String)localObject1)) {
                              break label2925;
                            }
                            ((TextView)localObject6).setTextColor(getContext().getResources().getColor(2131099783));
                            ((TextView)localObject6).setClickable(true);
                            ((TextView)localObject6).setText((CharSequence)localObject1);
                            break label2956;
                            ((TextView)localObject6).setVisibility(8);
                            break label2956;
                            if (((TimeLineObject)localObject8).Location == null)
                            {
                              localObject1 = null;
                              if (((TimeLineObject)localObject8).Location != null) {
                                break label14474;
                              }
                            }
                            for (localObject3 = null;; localObject3 = ((TimeLineObject)localObject8).Location.kHV)
                            {
                              ((TextView)localObject6).setTag(localSnsInfo.getLocalid());
                              if ((!Util.isNullOrNil((String)localObject1)) || (!Util.isNullOrNil((String)localObject3))) {
                                break label14487;
                              }
                              ((TextView)localObject6).setVisibility(8);
                              break;
                              localObject1 = ((TimeLineObject)localObject8).Location.kea;
                              break label14414;
                            }
                            ((TextView)localObject6).setVisibility(0);
                            if (!Util.isNullOrNil((String)localObject3))
                            {
                              ((TextView)localObject6).setTextColor(getContext().getResources().getColor(2131099783));
                              ((TextView)localObject6).setClickable(true);
                              if ((localSnsInfo.field_snsId == 0L) && (!Util.isNullOrNil((String)localObject1)))
                              {
                                ((TextView)localObject6).setText((String)localObject1 + "·" + (String)localObject3);
                                break label2972;
                              }
                              ((TextView)localObject6).setText((CharSequence)localObject3);
                              break label2972;
                            }
                            ((TextView)localObject6).setText((CharSequence)localObject1);
                            ((TextView)localObject6).setClickable(false);
                            ((TextView)localObject6).setTextColor(getContext().getResources().getColor(2131100245));
                            break label2972;
                            ((TextView)localObject6).setVisibility(8);
                            break label3167;
                            if (((ADInfo)localObject9).adActionExtTailType != ADInfo.ADChainStrengthenUserInfoFormatWording) {
                              break label3167;
                            }
                            if (!Util.isNullOrNil(((ADInfo)localObject9).adActionExtTailWording))
                            {
                              localObject1 = "";
                              localObject10 = ((ADInfo)localObject9).adActionExtUserList.iterator();
                              if (((Iterator)localObject10).hasNext())
                              {
                                localObject11 = (String)((Iterator)localObject10).next();
                                localObject3 = this.EBg.bjK((String)localObject11);
                                if (localObject3 != null)
                                {
                                  localObject3 = ((com.tencent.mm.contact.c)localObject3).arJ();
                                  if (!Util.isNullOrNil((String)localObject3)) {
                                    localObject3 = (String)localObject1 + (String)localObject3;
                                  }
                                }
                                for (;;)
                                {
                                  localObject1 = localObject3;
                                  if (((ADInfo)localObject9).adActionExtUserList.getLast() == localObject11) {
                                    break;
                                  }
                                  localObject1 = (String)localObject3 + ",";
                                  break;
                                  localObject3 = (String)localObject1 + (String)localObject11;
                                  continue;
                                  localObject3 = (String)localObject1 + (String)localObject11;
                                }
                              }
                              localObject3 = String.format(((ADInfo)localObject9).adActionExtTailWording, new Object[] { localObject1 });
                              ((TextView)localObject6).getTextSize();
                              localObject10 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.f(this, (CharSequence)localObject3, 1));
                              ((com.tencent.mm.pluginsdk.ui.span.m)localObject10).a(null, (CharSequence)localObject3);
                              localObject3 = ((TextView)localObject6).getPaint();
                              if (com.tencent.mm.cb.a.E(this, (int)Layout.getDesiredWidth((CharSequence)localObject10, 0, ((com.tencent.mm.pluginsdk.ui.span.m)localObject10).length(), (TextPaint)localObject3)) > this.EBt)
                              {
                                if (((String)localObject1).length() <= 1) {
                                  break label3167;
                                }
                                localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
                                localObject10 = String.format(((ADInfo)localObject9).adActionExtTailWording, new Object[] { (String)localObject1 + "..." });
                                ((TextView)localObject6).getTextSize();
                                localObject11 = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.f(this, (CharSequence)localObject10, 1));
                                ((com.tencent.mm.pluginsdk.ui.span.m)localObject11).a(null, (CharSequence)localObject10);
                                i = com.tencent.mm.cb.a.E(this, (int)Layout.getDesiredWidth((CharSequence)localObject11, 0, ((com.tencent.mm.pluginsdk.ui.span.m)localObject11).length(), (TextPaint)localObject3));
                                ((TextView)localObject6).setText((CharSequence)localObject11, TextView.BufferType.SPANNABLE);
                                ((TextView)localObject6).setVisibility(0);
                                if (i > this.EBt) {
                                  break label3166;
                                }
                                break label3167;
                              }
                              ((TextView)localObject6).setText((CharSequence)localObject10, TextView.BufferType.SPANNABLE);
                              ((TextView)localObject6).setVisibility(0);
                              break label3167;
                            }
                            ((TextView)localObject6).setVisibility(8);
                            break label3167;
                            label15088:
                            ((TextView)localObject7).setVisibility(8);
                            break label3293;
                            label15098:
                            i = 8;
                            break label3324;
                            if (((TimeLineObject)localObject8).ContentObj.LoU == 30)
                            {
                              localObject1 = ((TimeLineObject)localObject8).weappInfo.username;
                              localObject1 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk((String)localObject1);
                              if ((localObject1 != null) && (!Util.isNullOrNil(((WxaAttributes)localObject1).field_nickname))) {}
                              for (localObject3 = ((WxaAttributes)localObject1).field_nickname;; localObject3 = getString(2131756040))
                              {
                                localObject1 = localObject3;
                                if (((TimeLineObject)localObject8).weappInfo.subType != 1) {
                                  break;
                                }
                                this.EBX.findViewById(2131308376).setVisibility(0);
                                localObject1 = localObject3;
                                break;
                              }
                            }
                            if (((TimeLineObject)localObject8).ContentObj.LoU == 28)
                            {
                              localObject3 = getContext().getResources().getString(2131759540);
                              localObject1 = localObject3;
                              if (((TimeLineObject)localObject8).ContentObj.dME == null) {
                                break label3414;
                              }
                              localObject1 = localObject3;
                              if (Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.dME.nickname)) {
                                break label3414;
                              }
                              localObject1 = (String)localObject3 + " · " + ((TimeLineObject)localObject8).ContentObj.dME.nickname;
                              break label3414;
                            }
                            if (((TimeLineObject)localObject8).ContentObj.LoU == 36)
                            {
                              localObject3 = getContext().getResources().getString(2131759540);
                              localObject1 = localObject3;
                              if (((TimeLineObject)localObject8).ContentObj.Lpd == null) {
                                break label3414;
                              }
                              localObject1 = localObject3;
                              if (Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.Lpd.nickname)) {
                                break label3414;
                              }
                              localObject1 = (String)localObject3 + " · " + ((TimeLineObject)localObject8).ContentObj.Lpd.nickname;
                              break label3414;
                            }
                            if (((TimeLineObject)localObject8).ContentObj.LoU == 29)
                            {
                              localObject1 = getContext().getResources().getString(2131759540);
                              break label3414;
                            }
                            if (((TimeLineObject)localObject8).ContentObj.LoU == 38)
                            {
                              localObject1 = getContext().getResources().getString(2131759540);
                              break label3414;
                            }
                            if (((TimeLineObject)localObject8).ContentObj.LoU == 37)
                            {
                              localObject1 = getContext().getResources().getString(2131759540);
                              break label3414;
                            }
                            if (((TimeLineObject)localObject8).ContentObj.LoU == 39) {
                              switch (((TimeLineObject)localObject8).ContentObj.izD)
                              {
                              default: 
                                localObject1 = localObject3;
                                break;
                              case 1: 
                              case 100000000: 
                                localObject1 = getContext().getResources().getString(2131759540);
                                break;
                              }
                            }
                            localObject1 = localObject3;
                            if (!localSnsInfo.isAd()) {
                              break label3414;
                            }
                            localObject1 = localObject3;
                            if (!com.tencent.mm.plugin.sns.ad.e.h.a(localSnsInfo.getAdXml(), localSnsInfo.getAdInfo())) {
                              break label3414;
                            }
                            localObject1 = getContext().getResources().getString(2131759540);
                            break label3414;
                            ((TextView)localObject4).setVisibility(8);
                            break label3555;
                            ((TextView)localObject1).setVisibility(8);
                            break label3730;
                            if (((SnsObject)localObject6).WithUserList.size() <= 0) {
                              ((TextView)localObject4).setVisibility(8);
                            }
                            for (;;)
                            {
                              if ((localObject6 == null) || (this.gna == null) || (!this.gna.equals(((SnsObject)localObject6).Username)) || (((((SnsObject)localObject6).ExtFlag != 3) || (((SnsObject)localObject6).BlackList == null)) && ((((SnsObject)localObject6).ExtFlag != 5) || (((SnsObject)localObject6).GroupUser == null)))) {
                                break label16145;
                              }
                              this.EAP.findViewById(2131296647).setVisibility(0);
                              this.EAP.findViewById(2131296647).setTag(Integer.valueOf(localSnsInfo.localid));
                              this.EAP.findViewById(2131296647).setOnClickListener(new SnsCommentDetailUI.37(this));
                              break;
                              if (this.gna.equals(((SnsObject)localObject6).Username))
                              {
                                ((TextView)localObject4).setVisibility(0);
                                i = 0;
                                localObject7 = ((SnsObject)localObject6).WithUserList.iterator();
                                localObject1 = "";
                                if (((Iterator)localObject7).hasNext())
                                {
                                  localObject8 = (dzo)((Iterator)localObject7).next();
                                  if (i == 0)
                                  {
                                    i = 1;
                                    localObject1 = (String)localObject1 + "  ";
                                    if (((dzo)localObject8).Nickname == null) {
                                      break label15963;
                                    }
                                    localObject3 = new StringBuilder().append((String)localObject1);
                                    localObject1 = ((dzo)localObject8).Nickname;
                                  }
                                  for (;;)
                                  {
                                    localObject1 = (String)localObject1;
                                    break;
                                    localObject1 = (String)localObject1 + ",  ";
                                    break label15893;
                                    localObject9 = this.EBg.Kn(((dzo)localObject8).Username);
                                    localObject3 = new StringBuilder().append((String)localObject1);
                                    if (localObject9 == null) {
                                      localObject1 = ((dzo)localObject8).Username;
                                    } else {
                                      localObject1 = ((com.tencent.mm.contact.c)localObject9).arJ();
                                    }
                                  }
                                }
                                ((TextView)localObject4).setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, getString(2131766277, new Object[] { localObject1 }), ((TextView)localObject4).getTextSize()));
                              }
                              else
                              {
                                ((TextView)localObject4).setVisibility(8);
                                localObject1 = ((SnsObject)localObject6).WithUserList.iterator();
                                if (((Iterator)localObject1).hasNext())
                                {
                                  localObject3 = (dzo)((Iterator)localObject1).next();
                                  if (!this.gna.equals(((dzo)localObject3).Username)) {
                                    break label15680;
                                  }
                                  ((TextView)localObject4).setVisibility(0);
                                  localObject1 = getString(2131766278);
                                  ((TextView)localObject4).setVisibility(0);
                                  ((TextView)localObject4).setText(com.tencent.mm.pluginsdk.ui.span.l.b(this, (CharSequence)localObject1, ((TextView)localObject4).getTextSize()));
                                }
                              }
                            }
                            this.EAP.findViewById(2131296647).setVisibility(8);
                            break label3764;
                          }
                        }
                        i = 0;
                        j = 0;
                      }
                      break label10257;
                    }
                    localObject1 = "";
                  }
                  Object localObject6 = "";
                }
              }
            }
          }
        }
        i = 0;
        localObject4 = localObject1;
        break;
      }
      label5471:
      label8543:
      label16234:
      bool1 = true;
    }
  }
  
  public int getLayoutId()
  {
    return 2131496425;
  }
  
  public final int getSource()
  {
    if (this.EBD == 16) {
      return 2;
    }
    return 1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98599);
    setMMTitle(2131766018);
    setToTop(new SnsCommentDetailUI.20(this));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(203514);
        if (SnsCommentDetailUI.c(SnsCommentDetailUI.this) != null) {
          SnsCommentDetailUI.c(SnsCommentDetailUI.this).vt(false);
        }
        SnsCommentDetailUI.this.finish();
        AppMethodBeat.o(203514);
        return true;
      }
    });
    this.gna = z.aTY();
    if (com.tencent.mm.plugin.sns.model.aj.isInValid()) {
      finish();
    }
    final SnsInfo localSnsInfo = vs(true);
    if (localSnsInfo == null)
    {
      Log.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.dRS);
      finish();
      AppMethodBeat.o(98599);
      return;
    }
    Log.i("MicroMsg.SnsCommentDetailUI", "snsId: " + this.dRS + "localId " + this.EBf + "  username:" + localSnsInfo.getUserName());
    Object localObject1 = (TextView)findViewById(2131299193);
    int i;
    if (this.EBA)
    {
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(this.EBB);
      if ((y.aQJ(this.dRS)) || (!localSnsInfo.isDieItem())) {
        break label746;
      }
      localObject1 = localSnsInfo.getPostInfo();
      findViewById(2131308190).setVisibility(0);
      localObject2 = (TextView)findViewById(2131306061);
      switch (((cnc)localObject1).Mtd)
      {
      default: 
        if (!Util.isNullOrNil(((cnc)localObject1).Mtk))
        {
          ((TextView)localObject2).setText(((cnc)localObject1).Mtk);
          findViewById(2131308191).setVisibility(0);
          i = 1;
          label310:
          if (i != 0) {
            findViewById(2131308190).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(203505);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                if (localSnsInfo.isAd())
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(203505);
                  return;
                }
                an.YD(localSnsInfo.localid);
                an.YB(localSnsInfo.localid);
                com.tencent.mm.plugin.sns.model.aj.faK().eZn();
                paramAnonymousView = new Intent();
                SnsCommentDetailUI.this.setResult(-1, paramAnonymousView);
                if (SnsCommentDetailUI.v(SnsCommentDetailUI.this)) {
                  paramAnonymousView.putExtra("sns_gallery_force_finish", true);
                }
                SnsCommentDetailUI.this.finish();
                SnsCommentDetailUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203505);
              }
            });
          }
          this.EAT = ((ListView)findViewById(2131296633));
          this.EAT.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(203506);
              SnsCommentDetailUI.a(SnsCommentDetailUI.this, SnsCommentDetailUI.a(SnsCommentDetailUI.this).getBottom());
              Log.d("MicroMsg.SnsCommentDetailUI", "listOriginalBottom: " + SnsCommentDetailUI.d(SnsCommentDetailUI.this));
              AppMethodBeat.o(203506);
            }
          });
          this.EAT.setOnScrollListener(new AbsListView.OnScrollListener()
          {
            public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AppMethodBeat.i(203507);
              if (paramAnonymousInt2 > 0) {
                if ((paramAnonymousInt1 == 0) && (!SnsCommentDetailUI.w(SnsCommentDetailUI.this)))
                {
                  SnsCommentDetailUI.b(SnsCommentDetailUI.this, true);
                  if (SnsCommentDetailUI.x(SnsCommentDetailUI.this) != null)
                  {
                    SnsCommentDetailUI.x(SnsCommentDetailUI.this).refreshView();
                    AppMethodBeat.o(203507);
                    return;
                  }
                  if (SnsCommentDetailUI.y(SnsCommentDetailUI.this) != null)
                  {
                    SnsCommentDetailUI.this.fhP();
                    AppMethodBeat.o(203507);
                  }
                }
                else if (paramAnonymousInt1 > 0)
                {
                  SnsCommentDetailUI.b(SnsCommentDetailUI.this, false);
                }
              }
              AppMethodBeat.o(203507);
            }
            
            public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
            {
              AppMethodBeat.i(203508);
              if (paramAnonymousInt == 1)
              {
                SnsCommentDetailUI.this.hideVKB();
                SnsCommentDetailUI.z(SnsCommentDetailUI.this);
              }
              if ((paramAnonymousInt == 0) && (SnsCommentDetailUI.e(SnsCommentDetailUI.this) != null)) {
                SnsCommentDetailUI.e(SnsCommentDetailUI.this).uM(true);
              }
              AppMethodBeat.o(203508);
            }
          });
          localObject1 = vs(false);
          this.EAP = aa.jQ(getContext()).inflate(2131496426, null);
          this.EAV = this.EAP.findViewById(2131302606);
          this.EAP.setOnClickListener(this.EBT);
          if ((localObject1 == null) || (!((SnsInfo)localObject1).isAd()) || (!((SnsInfo)localObject1).isLongPressGestureAd())) {
            break label763;
          }
          this.EBJ = ((FrameLayout)aa.jQ(getContext()).inflate(2131496373, null));
          this.EBJ.addView(this.EAP, 0);
          this.EAT.addHeaderView(this.EBJ);
        }
        break;
      }
    }
    for (;;)
    {
      boolean bool = fhP();
      if (bool) {
        break label777;
      }
      Log.i("MicroMsg.SnsCommentDetailUI", "error isOk setheader ".concat(String.valueOf(bool)));
      finish();
      AppMethodBeat.o(98599);
      return;
      ((TextView)localObject1).setVisibility(8);
      break;
      if (!Util.isNullOrNil(((cnc)localObject1).Mtk)) {
        ((TextView)localObject2).setText(((cnc)localObject1).Mtk);
      }
      for (;;)
      {
        findViewById(2131308191).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(2131766170);
      }
      if (!Util.isNullOrNil(((cnc)localObject1).Mtk)) {
        ((TextView)localObject2).setText(((cnc)localObject1).Mtk);
      }
      for (;;)
      {
        findViewById(2131308191).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(2131766172);
      }
      if (!Util.isNullOrNil(((cnc)localObject1).Mtk)) {
        ((TextView)localObject2).setText(((cnc)localObject1).Mtk);
      }
      for (;;)
      {
        findViewById(2131308191).setVisibility(8);
        i = 1;
        break;
        ((TextView)localObject2).setText(2131766171);
      }
      if (localSnsInfo.getTypeFlag() == 28)
      {
        ((TextView)localObject2).setText(2131766174);
        findViewById(2131308191).setVisibility(8);
        i = 0;
        break label310;
      }
      ((TextView)localObject2).setText(2131766173);
      findViewById(2131308191).setVisibility(0);
      i = 1;
      break label310;
      label746:
      findViewById(2131308190).setVisibility(8);
      i = 0;
      break label310;
      label763:
      this.EAT.addHeaderView(this.EAP);
    }
    label777:
    if (localObject1 != null) {
      this.qcr = bk.g((SnsInfo)localObject1, false);
    }
    if ((this.qcr == 10) && (z.aTY().equals(localSnsInfo.field_userName)))
    {
      this.EAS = new SnsDetailLuckyHeader(this);
      localObject1 = new AbsListView.LayoutParams(-1, -2);
      this.EAS.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.EAS.setOnClickListener(this.EBT);
    }
    this.EAR = new LinearLayout(getContext());
    localObject1 = new AbsListView.LayoutParams(-1, -2);
    this.EAR.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.EAR.setOnClickListener(this.EBT);
    BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 2.0F);
    localObject1 = new AbsListView.LayoutParams(-1, 1);
    Object localObject2 = new LinearLayout(getContext());
    ((LinearLayout)localObject2).setBackgroundResource(2131234977);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.DGk = ((LinearLayout)localObject2);
    f(localSnsInfo, true);
    if (this.EAS != null)
    {
      this.EBx = true;
      this.EAT.addHeaderView(this.EAS);
    }
    localObject2 = an.B(localSnsInfo);
    label1126:
    dzo localdzo;
    label1289:
    long l;
    if (localObject2 == null)
    {
      this.EAR.setVisibility(8);
      this.EAW = new b(new LinkedList(), new LinkedList(), this, localSnsInfo.getLocalid());
      this.EAT.addHeaderView(this.EAR);
      this.EAT.setAdapter(this.EAW);
      this.EoJ = ((SnsCommentFooter)findViewById(2131298947));
      if ((localSnsInfo == null) || (localSnsInfo.getTimeLine() == null) || (localSnsInfo.getTimeLine().ContentObj == null) || ((localSnsInfo.getTimeLine().ContentObj.LoW & 0x80) != 0)) {
        break label1815;
      }
      this.EoJ.setFeedEmojiCommentEnable(true);
      this.EoJ.setTag(localSnsInfo);
      this.EoJ.setOnEditTouchListener(new SnsCommentFooter.a()
      {
        public final void fhU()
        {
          AppMethodBeat.i(203509);
          if (!com.tencent.mm.plugin.sns.lucky.a.m.aOH(localSnsInfo.getLocalid()))
          {
            if ((SnsCommentDetailUI.A(SnsCommentDetailUI.this) != null) && (SnsCommentDetailUI.A(SnsCommentDetailUI.this).isShowing()))
            {
              AppMethodBeat.o(203509);
              return;
            }
            SnsCommentDetailUI.a(SnsCommentDetailUI.this, com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.EBZ.ZD(0)));
            AppMethodBeat.o(203509);
            return;
          }
          if ((SnsCommentDetailUI.this.keyboardState() == 1) || (SnsCommentDetailUI.c(SnsCommentDetailUI.this).fhW()))
          {
            AppMethodBeat.o(203509);
            return;
          }
          SnsCommentDetailUI.B(SnsCommentDetailUI.this);
          AppMethodBeat.o(203509);
        }
      });
      this.EoJ.setOnSmileyShowListener(new SnsCommentFooter.c()
      {
        public final void onShow()
        {
          AppMethodBeat.i(203510);
          if (SnsCommentDetailUI.c(SnsCommentDetailUI.this).ECW)
          {
            AppMethodBeat.o(203510);
            return;
          }
          SnsCommentDetailUI.B(SnsCommentDetailUI.this);
          AppMethodBeat.o(203510);
        }
      });
      localObject1 = vs(true);
      if ((localObject1 != null) && (!((SnsInfo)localObject1).isExtFlag())) {
        this.EoJ.setVisibility(8);
      }
      this.EoJ.setAfterEditAction(this.EBS);
      this.EoJ.fhX();
      this.EoJ.setOnCommentSendImp(new SnsCommentFooter.b()
      {
        public final void kP(String paramAnonymousString1, String paramAnonymousString2)
        {
          int j = 8;
          AppMethodBeat.i(203511);
          if (!com.tencent.mm.plugin.sns.lucky.a.m.aOH(localSnsInfo.getLocalid()))
          {
            if (SnsCommentDetailUI.this.EBZ.ZD(0) != null) {
              com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.EBZ.ZD(0));
            }
            AppMethodBeat.o(203511);
            return;
          }
          if (localSnsInfo.isAd()) {}
          for (int i = SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentFlag();; i = 0)
          {
            if (com.tencent.mm.plugin.sns.ui.widget.e.iY(i, 8))
            {
              paramAnonymousString1 = paramAnonymousString1.substring(SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentAtPrefix().length());
              Log.i("MicroMsg.SnsCommentDetailUI", "send atFriend ad detail comment");
              aq.a.a(localSnsInfo, 16, paramAnonymousString1, SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentInfo(), i, SnsCommentDetailUI.this.getSource(), paramAnonymousString2);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setText("");
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).vt(false);
              Log.i("MicroMsg.SnsCommentDetailUI", "comment send imp!");
              com.tencent.mm.plugin.sns.k.e.DUQ.fcy().eOA = 3L;
              SnsCommentDetailUI.z(SnsCommentDetailUI.this);
              AppMethodBeat.o(203511);
              return;
            }
            Log.i("MicroMsg.SnsCommentDetailUI", "send detail comment");
            SnsInfo localSnsInfo = localSnsInfo;
            if (localSnsInfo.isAd()) {}
            for (;;)
            {
              aq.a.a(localSnsInfo, j, paramAnonymousString1, SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentInfo(), i, SnsCommentDetailUI.this.getSource(), paramAnonymousString2);
              break;
              j = 2;
            }
          }
        }
      });
      this.EBm = getIntent().getBooleanExtra("INTENT_FROMSUI", false);
      if (this.EBm)
      {
        this.EBn = getIntent().getLongExtra("INTENT_FROMSUI_COMMENTID", 0L);
        if ((this.EBn != 0L) && (this.EAW.commentList != null))
        {
          i = 0;
          if (i < this.EAW.commentList.size())
          {
            localdzo = (dzo)this.EAW.commentList.get(i);
            if (localdzo.MYT == 0) {
              break label1826;
            }
            l = localdzo.MYT;
            label1335:
            if (l != this.EBn) {
              break label1864;
            }
            this.EAT.setSelection(i);
            localObject1 = this.EBg.Kn(localdzo.Username);
            if (localObject1 == null) {
              break label1836;
            }
            localObject1 = ((com.tencent.mm.contact.c)localObject1).arJ();
            label1381:
            this.EoJ.ECO = 0;
            this.EoJ.fhY();
            this.EoJ.setCommentHint(getString(2131766183) + (String)localObject1);
            this.EoJ.setCommentInfo(localdzo);
            if (((SnsObject)localObject2).LikeUserList.size() <= 0) {
              break label1903;
            }
            int j = i + 1;
            i = j;
            if (j > this.EAW.getCount()) {
              i = this.EAW.getCount() - 1;
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
      this.EBS.UZ = i;
      if (this.EBm) {
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(203512);
            SnsCommentDetailUI.this.hideVKB();
            SnsCommentDetailUI.l(SnsCommentDetailUI.this).kn = SnsCommentDetailUI.C(SnsCommentDetailUI.this);
            SnsCommentDetailUI.l(SnsCommentDetailUI.this).run();
            AppMethodBeat.o(203512);
          }
        }, 100L);
      }
      this.EBw = ((SnsTranslateResultView)this.EAP.findViewById(2131308248));
      this.EBw.setResultTextSize(((TextView)this.EAP.findViewById(2131299510)).getTextSize());
      this.EBw.getResultTextView().setBackgroundResource(2131234959);
      localObject1 = new bg(this.dRS, localSnsInfo.getLocalid(), false, true, 2);
      this.EBw.getResultTextView().setTag(localObject1);
      this.pqr.c(this.EBw.getResultTextView(), this.Dyw.Fau, this.Dyw.Far);
      if (au.fC(this.dRS, 4))
      {
        localObject1 = au.aPp(this.dRS);
        if ((localObject1 != null) && (((au.b)localObject1).iGD))
        {
          this.EBw.setVisibility(0);
          this.EBw.a(null, 1, ((au.b)localObject1).result, ((au.b)localObject1).brand, false);
          AppMethodBeat.o(98599);
          return;
          this.EBb = ((SnsObject)localObject2).LikeUserList;
          n(((SnsObject)localObject2).LikeUserList, ((SnsObject)localObject2).CommentUserList.isEmpty());
          if (this.EAS != null) {
            this.EAS.a(localSnsInfo, this.Dyw);
          }
          this.EAW = new b(((SnsObject)localObject2).CommentUserList, ((SnsObject)localObject2).LikeUserList, this, localSnsInfo.getLocalid());
          if (!this.EBE) {
            break;
          }
          com.tencent.mm.plugin.sns.k.e.DUQ.fcy().eOy = ((SnsObject)localObject2).CommentUserList.size();
          com.tencent.mm.plugin.sns.k.e.DUQ.fcy().eOz = ((SnsObject)localObject2).LikeUserList.size();
          break;
          this.EoJ.setFeedEmojiCommentEnable(false);
          break label1126;
          l = localdzo.MYV;
          break label1335;
          if (localdzo.Nickname != null)
          {
            localObject1 = localdzo.Nickname;
            break label1381;
          }
          localObject1 = localdzo.Username;
          break label1381;
          i += 1;
          break label1289;
        }
        this.EBw.setVisibility(8);
        AppMethodBeat.o(98599);
        return;
      }
      this.EBw.setVisibility(8);
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
      if ((this.Dyw != null) && (this.Dyw.Far != null)) {
        this.Dyw.Far.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      AppMethodBeat.o(98610);
      return;
    }
    if (paramInt1 == 16)
    {
      Log.i("MicroMsg.SnsCommentDetailUI", "REQUEST_CODE_FOR_FULLSCREEN");
      paramIntent = new iq();
      paramIntent.dNl.scene = 1;
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
            this.EoJ.gte.showVKB();
            String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramIntent[0]);
            if (!Util.isNullOrNil(str))
            {
              this.EoJ.fhY();
              this.EoJ.setText("@" + str + " ");
              this.EoJ.setCommentAtPrefix("@" + str + " ");
              this.EoJ.setCommentInfo(new dzo());
              this.EoJ.getCommentInfo().Username = paramIntent[0];
              this.EoJ.setCommentFlag(8);
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
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.axQ(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98609);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = com.tencent.mm.plugin.sns.storage.f.aQl(this.dRS);
    Object localObject = an.B(paramConfiguration);
    n(((SnsObject)localObject).LikeUserList, ((SnsObject)localObject).CommentUserList.isEmpty());
    if (this.EAS != null) {
      this.EAS.a(paramConfiguration, this.Dyw);
    }
    paramConfiguration = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    localObject = new Point();
    ((Point)localObject).x = paramConfiguration.widthPixels;
    ((Point)localObject).y = paramConfiguration.heightPixels;
    com.tencent.mm.plugin.sns.model.aj.k((Point)localObject);
    if (this.EBZ != null)
    {
      this.EBq = com.tencent.mm.plugin.sns.model.aj.fbb();
      this.EBZ.setImageViewWidth(this.EBq);
    }
    AppMethodBeat.o(98609);
  }
  
  /* Error */
  public void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 3530
    //   3: invokestatic 255	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 3535	com/tencent/mm/pluginsdk/h:q	(Lcom/tencent/mm/ui/MMActivity;)V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 3537	com/tencent/mm/ui/report/MMSecDataActivity:onCreate	(Landroid/os/Bundle;)V
    //   15: aload_0
    //   16: invokestatic 3540	com/tencent/mm/plugin/sns/ad/timeline/b/f:eXW	()Z
    //   19: putfield 999	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBI	Z
    //   22: aload_0
    //   23: ldc_w 3542
    //   26: invokestatic 2926	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   29: checkcast 3542	com/tencent/mm/plugin/story/api/e
    //   32: invokeinterface 3546 1 0
    //   37: getstatic 3552	com/tencent/mm/plugin/story/api/f$a:Fku	Lcom/tencent/mm/plugin/story/api/f$a;
    //   40: invokeinterface 3557 2 0
    //   45: putfield 343	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:DKd	Z
    //   48: aload_0
    //   49: ldc_w 3542
    //   52: invokestatic 2926	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   55: checkcast 3542	com/tencent/mm/plugin/story/api/e
    //   58: invokeinterface 3546 1 0
    //   63: getstatic 3560	com/tencent/mm/plugin/story/api/f$a:Fkv	Lcom/tencent/mm/plugin/story/api/f$a;
    //   66: invokeinterface 3557 2 0
    //   71: putfield 345	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:DKf	Z
    //   74: aload_0
    //   75: iconst_1
    //   76: invokestatic 3565	com/tencent/mm/ui/b:e	(Landroid/app/Activity;Z)V
    //   79: invokestatic 3569	com/tencent/mm/plugin/sns/model/aj:faE	()Lcom/tencent/mm/plugin/sns/model/aq$a;
    //   82: iconst_5
    //   83: ldc_w 3571
    //   86: aload_0
    //   87: invokevirtual 3574	com/tencent/mm/plugin/sns/model/aq$a:a	(ILjava/lang/String;Lcom/tencent/mm/plugin/sns/b/i$a;)V
    //   90: aload_0
    //   91: aload_0
    //   92: bipush 14
    //   94: invokestatic 3577	com/tencent/mm/ui/at:fromDPToPix	(Landroid/content/Context;I)I
    //   97: putfield 341	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBF	I
    //   100: aload_0
    //   101: invokestatic 3581	com/tencent/mm/ui/ao:az	(Landroid/content/Context;)Landroid/graphics/Point;
    //   104: astore_1
    //   105: aload_0
    //   106: aload_1
    //   107: getfield 3517	android/graphics/Point:x	I
    //   110: putfield 3583	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenWidth	I
    //   113: aload_0
    //   114: aload_1
    //   115: getfield 3522	android/graphics/Point:y	I
    //   118: putfield 3585	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenHeight	I
    //   121: aload_0
    //   122: invokestatic 3591	java/lang/System:currentTimeMillis	()J
    //   125: putfield 289	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EAN	J
    //   128: aload_0
    //   129: new 1726	com/tencent/mm/ui/widget/b/a
    //   132: dup
    //   133: aload_0
    //   134: invokespecial 3592	com/tencent/mm/ui/widget/b/a:<init>	(Landroid/content/Context;)V
    //   137: putfield 617	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:pqr	Lcom/tencent/mm/ui/widget/b/a;
    //   140: aload_0
    //   141: aload_0
    //   142: invokevirtual 2543	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   145: ldc_w 3594
    //   148: iconst_0
    //   149: invokevirtual 3598	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   152: putfield 3206	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBD	I
    //   155: aload_0
    //   156: aload_0
    //   157: invokevirtual 2543	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   160: ldc_w 3600
    //   163: iconst_0
    //   164: invokevirtual 2551	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   167: putfield 339	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBE	Z
    //   170: aload_0
    //   171: getfield 339	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBE	Z
    //   174: ifeq +10 -> 184
    //   177: getstatic 557	com/tencent/mm/plugin/sns/k/e:DUQ	Lcom/tencent/mm/plugin/sns/k/e;
    //   180: invokevirtual 3603	com/tencent/mm/plugin/sns/k/e:fcA	()Lcom/tencent/mm/g/b/a/ih;
    //   183: pop
    //   184: getstatic 1882	com/tencent/mm/plugin/sns/i/a:DRI	Lcom/tencent/mm/plugin/sns/i/a$a;
    //   187: astore_1
    //   188: aload_0
    //   189: invokestatic 3606	com/tencent/mm/plugin/sns/i/a$a:gZ	(Landroid/content/Context;)V
    //   192: aload_0
    //   193: aload_0
    //   194: invokevirtual 2543	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   197: ldc_w 3608
    //   200: invokevirtual 3421	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   203: ldc_w 313
    //   206: invokestatic 1615	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   209: putfield 470	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dRS	Ljava/lang/String;
    //   212: aload_0
    //   213: getfield 470	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dRS	Ljava/lang/String;
    //   216: invokestatic 964	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   219: ifeq +24 -> 243
    //   222: aload_0
    //   223: ldc_w 3610
    //   226: aload_0
    //   227: invokevirtual 2543	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   230: ldc_w 3608
    //   233: lconst_0
    //   234: invokevirtual 3336	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   237: invokestatic 3614	com/tencent/mm/plugin/sns/storage/y:bp	(Ljava/lang/String;J)Ljava/lang/String;
    //   240: putfield 470	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dRS	Ljava/lang/String;
    //   243: aload_0
    //   244: aload_0
    //   245: invokevirtual 2543	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   248: ldc_w 3616
    //   251: invokevirtual 3421	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   254: ldc_w 313
    //   257: invokestatic 1615	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   260: putfield 909	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBf	Ljava/lang/String;
    //   263: aload_0
    //   264: getfield 909	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBf	Ljava/lang/String;
    //   267: invokestatic 964	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   270: ifeq +32 -> 302
    //   273: aload_0
    //   274: invokevirtual 2543	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   277: ldc_w 3616
    //   280: iconst_m1
    //   281: invokevirtual 3598	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   284: istore_2
    //   285: iload_2
    //   286: iconst_m1
    //   287: if_icmpeq +15 -> 302
    //   290: aload_0
    //   291: ldc_w 3610
    //   294: iload_2
    //   295: i2l
    //   296: invokestatic 3614	com/tencent/mm/plugin/sns/storage/y:bp	(Ljava/lang/String;J)Ljava/lang/String;
    //   299: putfield 909	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBf	Ljava/lang/String;
    //   302: aload_0
    //   303: new 66	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$4
    //   306: dup
    //   307: aload_0
    //   308: aload_0
    //   309: invokevirtual 543	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   312: aload_0
    //   313: aload_0
    //   314: getfield 358	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBL	Lcom/tencent/mm/plugin/sns/model/ak;
    //   317: invokespecial 3619	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$4:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;ILandroid/app/Activity;Lcom/tencent/mm/plugin/sns/model/ai;)V
    //   320: putfield 502	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Dyw	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   323: aload_0
    //   324: ldc_w 1743
    //   327: invokevirtual 1079	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:findViewById	(I)Landroid/view/View;
    //   330: checkcast 2393	android/widget/FrameLayout
    //   333: astore_1
    //   334: aload_0
    //   335: new 3621	com/tencent/mm/plugin/sns/h/b
    //   338: dup
    //   339: aload_0
    //   340: aload_0
    //   341: getfield 502	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Dyw	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   344: aload_1
    //   345: invokespecial 3624	com/tencent/mm/plugin/sns/h/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/c;Landroid/widget/FrameLayout;)V
    //   348: putfield 3626	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EoS	Lcom/tencent/mm/plugin/sns/h/b;
    //   351: aload_0
    //   352: new 3628	com/tencent/mm/plugin/sns/ui/b
    //   355: dup
    //   356: aload_0
    //   357: aload_0
    //   358: getfield 502	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Dyw	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   361: aload_1
    //   362: aload_0
    //   363: getfield 3626	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EoS	Lcom/tencent/mm/plugin/sns/h/b;
    //   366: invokespecial 3631	com/tencent/mm/plugin/sns/ui/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/c;Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/sns/h/b;)V
    //   369: putfield 1330	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EoR	Lcom/tencent/mm/plugin/sns/ui/b;
    //   372: aload_0
    //   373: new 3633	com/tencent/mm/plugin/sns/ui/ap
    //   376: dup
    //   377: aload_0
    //   378: aload_0
    //   379: getfield 502	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Dyw	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   382: aload_1
    //   383: invokespecial 3634	com/tencent/mm/plugin/sns/ui/ap:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/c;Landroid/widget/FrameLayout;)V
    //   386: putfield 1334	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EoT	Lcom/tencent/mm/plugin/sns/ui/ap;
    //   389: aload_0
    //   390: new 3636	com/tencent/mm/plugin/sns/ui/bu
    //   393: dup
    //   394: aload_0
    //   395: aload_0
    //   396: getfield 502	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Dyw	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   399: aload_1
    //   400: invokespecial 3637	com/tencent/mm/plugin/sns/ui/bu:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/c;Landroid/widget/FrameLayout;)V
    //   403: putfield 1470	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EoU	Lcom/tencent/mm/plugin/sns/ui/bu;
    //   406: aload_0
    //   407: getfield 502	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Dyw	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   410: invokevirtual 3640	com/tencent/mm/plugin/sns/ui/d/c:ebz	()V
    //   413: aload_0
    //   414: aload_0
    //   415: invokevirtual 2543	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   418: ldc_w 3642
    //   421: iconst_0
    //   422: invokevirtual 2551	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   425: putfield 333	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBA	Z
    //   428: aload_0
    //   429: aload_0
    //   430: invokevirtual 2543	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   433: ldc_w 3644
    //   436: invokevirtual 3421	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   439: putfield 335	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBB	Ljava/lang/String;
    //   442: aload_0
    //   443: new 1138	com/tencent/mm/plugin/sns/ui/br
    //   446: dup
    //   447: aload_0
    //   448: new 80	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$5
    //   451: dup
    //   452: aload_0
    //   453: invokespecial 3645	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$5:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   456: aload_0
    //   457: invokevirtual 543	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   460: aload_0
    //   461: getfield 358	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBL	Lcom/tencent/mm/plugin/sns/model/ak;
    //   464: invokespecial 3648	com/tencent/mm/plugin/sns/ui/br:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/br$a;ILcom/tencent/mm/plugin/sns/model/ai;)V
    //   467: putfield 1178	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBo	Lcom/tencent/mm/plugin/sns/ui/br;
    //   470: invokestatic 3591	java/lang/System:currentTimeMillis	()J
    //   473: lstore_3
    //   474: aload_0
    //   475: invokevirtual 2543	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   478: ldc_w 3650
    //   481: invokevirtual 3654	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   484: astore_1
    //   485: aload_1
    //   486: ifnull +184 -> 670
    //   489: new 793	com/tencent/mm/protocal/protobuf/TimeLineObject
    //   492: dup
    //   493: invokespecial 3655	com/tencent/mm/protocal/protobuf/TimeLineObject:<init>	()V
    //   496: astore 6
    //   498: aload 6
    //   500: aload_1
    //   501: invokevirtual 3659	com/tencent/mm/protocal/protobuf/TimeLineObject:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   504: pop
    //   505: invokestatic 3663	com/tencent/mm/plugin/sns/model/aj:faO	()Lcom/tencent/mm/plugin/sns/storage/n;
    //   508: new 3665	java/math/BigInteger
    //   511: dup
    //   512: aload 6
    //   514: getfield 2539	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   517: invokespecial 3666	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   520: invokevirtual 3669	java/math/BigInteger:longValue	()J
    //   523: invokevirtual 3675	com/tencent/mm/plugin/sns/storage/n:JJ	(J)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   526: ifnonnull +755 -> 1281
    //   529: ldc_w 708
    //   532: ldc_w 3677
    //   535: invokestatic 780	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   538: new 523	com/tencent/mm/plugin/sns/storage/SnsInfo
    //   541: dup
    //   542: invokespecial 3678	com/tencent/mm/plugin/sns/storage/SnsInfo:<init>	()V
    //   545: astore_1
    //   546: aload_1
    //   547: new 3665	java/math/BigInteger
    //   550: dup
    //   551: aload 6
    //   553: getfield 2539	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   556: invokespecial 3666	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   559: invokevirtual 3669	java/math/BigInteger:longValue	()J
    //   562: putfield 1683	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   565: aload_1
    //   566: aload 6
    //   568: invokevirtual 3682	com/tencent/mm/protocal/protobuf/TimeLineObject:toByteArray	()[B
    //   571: putfield 3686	com/tencent/mm/plugin/sns/storage/SnsInfo:field_content	[B
    //   574: aload_1
    //   575: aload 6
    //   577: getfield 2774	com/tencent/mm/protocal/protobuf/TimeLineObject:CreateTime	I
    //   580: putfield 1853	com/tencent/mm/plugin/sns/storage/SnsInfo:field_createTime	I
    //   583: aload_1
    //   584: aload 6
    //   586: getfield 2228	com/tencent/mm/protocal/protobuf/TimeLineObject:UserName	Ljava/lang/String;
    //   589: putfield 3283	com/tencent/mm/plugin/sns/storage/SnsInfo:field_userName	Ljava/lang/String;
    //   592: aload_1
    //   593: aload 6
    //   595: getfield 797	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adp;
    //   598: getfield 802	com/tencent/mm/protocal/protobuf/adp:LoU	I
    //   601: putfield 1864	com/tencent/mm/plugin/sns/storage/SnsInfo:field_type	I
    //   604: aload_1
    //   605: invokevirtual 3689	com/tencent/mm/plugin/sns/storage/SnsInfo:setExtFlag	()V
    //   608: new 483	com/tencent/mm/protocal/protobuf/SnsObject
    //   611: dup
    //   612: invokespecial 3690	com/tencent/mm/protocal/protobuf/SnsObject:<init>	()V
    //   615: astore 6
    //   617: aload 6
    //   619: new 3692	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   622: dup
    //   623: invokespecial 3693	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   626: putfield 3697	com/tencent/mm/protocal/protobuf/SnsObject:ObjectDesc	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   629: aload_1
    //   630: aload 6
    //   632: invokevirtual 3698	com/tencent/mm/protocal/protobuf/SnsObject:toByteArray	()[B
    //   635: putfield 3701	com/tencent/mm/plugin/sns/storage/SnsInfo:field_attrBuf	[B
    //   638: invokestatic 3663	com/tencent/mm/plugin/sns/model/aj:faO	()Lcom/tencent/mm/plugin/sns/storage/n;
    //   641: aload_1
    //   642: invokevirtual 3705	com/tencent/mm/plugin/sns/storage/n:insert	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;)Z
    //   645: pop
    //   646: ldc_w 3707
    //   649: ldc_w 3709
    //   652: iconst_1
    //   653: anewarray 1218	java/lang/Object
    //   656: dup
    //   657: iconst_0
    //   658: invokestatic 3591	java/lang/System:currentTimeMillis	()J
    //   661: lload_3
    //   662: lsub
    //   663: invokestatic 1688	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   666: aastore
    //   667: invokestatic 1601	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   670: aload_0
    //   671: iconst_1
    //   672: invokespecial 654	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:vs	(Z)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   675: astore_1
    //   676: ldc_w 708
    //   679: new 710	java/lang/StringBuilder
    //   682: dup
    //   683: ldc_w 3711
    //   686: invokespecial 714	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   689: aload_0
    //   690: getfield 470	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dRS	Ljava/lang/String;
    //   693: invokevirtual 721	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: ldc_w 3713
    //   699: invokevirtual 721	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload_0
    //   703: getfield 909	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBf	Ljava/lang/String;
    //   706: invokevirtual 721	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: invokevirtual 722	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   712: invokestatic 780	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   715: aload_1
    //   716: ifnull +29 -> 745
    //   719: ldc_w 708
    //   722: ldc_w 3715
    //   725: iconst_1
    //   726: anewarray 1218	java/lang/Object
    //   729: dup
    //   730: iconst_0
    //   731: aload_1
    //   732: invokevirtual 927	com/tencent/mm/plugin/sns/storage/SnsInfo:getUserName	()Ljava/lang/String;
    //   735: ldc_w 313
    //   738: invokestatic 1615	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   741: aastore
    //   742: invokestatic 1601	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   745: aload_0
    //   746: getfield 470	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dRS	Ljava/lang/String;
    //   749: invokestatic 521	com/tencent/mm/plugin/sns/storage/y:aQJ	(Ljava/lang/String;)Z
    //   752: ifeq +56 -> 808
    //   755: aload_0
    //   756: getfield 470	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dRS	Ljava/lang/String;
    //   759: invokestatic 3718	com/tencent/mm/plugin/sns/storage/y:aNz	(Ljava/lang/String;)Z
    //   762: ifeq +563 -> 1325
    //   765: aload_1
    //   766: ifnull +527 -> 1293
    //   769: aload_1
    //   770: invokevirtual 927	com/tencent/mm/plugin/sns/storage/SnsInfo:getUserName	()Ljava/lang/String;
    //   773: invokestatic 3723	com/tencent/mm/model/ab:IR	(Ljava/lang/String;)Z
    //   776: ifne +32 -> 808
    //   779: invokestatic 1569	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
    //   782: pop
    //   783: invokestatic 3727	com/tencent/mm/kernel/g:aAg	()Lcom/tencent/mm/kernel/b;
    //   786: getfield 3733	com/tencent/mm/kernel/b:hqi	Lcom/tencent/mm/ak/t;
    //   789: new 3735	com/tencent/mm/plugin/sns/model/r
    //   792: dup
    //   793: aload_0
    //   794: getfield 470	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dRS	Ljava/lang/String;
    //   797: invokestatic 3738	com/tencent/mm/plugin/sns/storage/y:aOa	(Ljava/lang/String;)J
    //   800: invokespecial 3740	com/tencent/mm/plugin/sns/model/r:<init>	(J)V
    //   803: iconst_0
    //   804: invokevirtual 3745	com/tencent/mm/ak/t:a	(Lcom/tencent/mm/ak/q;I)Z
    //   807: pop
    //   808: invokestatic 1569	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
    //   811: pop
    //   812: invokestatic 3727	com/tencent/mm/kernel/g:aAg	()Lcom/tencent/mm/kernel/b;
    //   815: getfield 3733	com/tencent/mm/kernel/b:hqi	Lcom/tencent/mm/ak/t;
    //   818: sipush 210
    //   821: aload_0
    //   822: invokevirtual 3748	com/tencent/mm/ak/t:a	(ILcom/tencent/mm/ak/i;)V
    //   825: invokestatic 1569	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
    //   828: pop
    //   829: invokestatic 3727	com/tencent/mm/kernel/g:aAg	()Lcom/tencent/mm/kernel/b;
    //   832: getfield 3733	com/tencent/mm/kernel/b:hqi	Lcom/tencent/mm/ak/t;
    //   835: sipush 218
    //   838: aload_0
    //   839: invokevirtual 3748	com/tencent/mm/ak/t:a	(ILcom/tencent/mm/ak/i;)V
    //   842: invokestatic 1569	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
    //   845: pop
    //   846: invokestatic 3727	com/tencent/mm/kernel/g:aAg	()Lcom/tencent/mm/kernel/b;
    //   849: getfield 3733	com/tencent/mm/kernel/b:hqi	Lcom/tencent/mm/ak/t;
    //   852: sipush 213
    //   855: aload_0
    //   856: invokevirtual 3748	com/tencent/mm/ak/t:a	(ILcom/tencent/mm/ak/i;)V
    //   859: invokestatic 1569	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
    //   862: pop
    //   863: invokestatic 3727	com/tencent/mm/kernel/g:aAg	()Lcom/tencent/mm/kernel/b;
    //   866: getfield 3733	com/tencent/mm/kernel/b:hqi	Lcom/tencent/mm/ak/t;
    //   869: sipush 682
    //   872: aload_0
    //   873: invokevirtual 3748	com/tencent/mm/ak/t:a	(ILcom/tencent/mm/ak/i;)V
    //   876: invokestatic 1569	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
    //   879: pop
    //   880: invokestatic 3727	com/tencent/mm/kernel/g:aAg	()Lcom/tencent/mm/kernel/b;
    //   883: getfield 3733	com/tencent/mm/kernel/b:hqi	Lcom/tencent/mm/ak/t;
    //   886: sipush 214
    //   889: aload_0
    //   890: invokevirtual 3748	com/tencent/mm/ak/t:a	(ILcom/tencent/mm/ak/i;)V
    //   893: invokestatic 1569	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
    //   896: pop
    //   897: invokestatic 3727	com/tencent/mm/kernel/g:aAg	()Lcom/tencent/mm/kernel/b;
    //   900: getfield 3733	com/tencent/mm/kernel/b:hqi	Lcom/tencent/mm/ak/t;
    //   903: sipush 683
    //   906: aload_0
    //   907: invokevirtual 3748	com/tencent/mm/ak/t:a	(ILcom/tencent/mm/ak/i;)V
    //   910: aload_0
    //   911: invokestatic 3751	com/tencent/mm/plugin/sns/model/aj:faC	()Lcom/tencent/mm/storage/bv;
    //   914: putfield 3098	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBg	Lcom/tencent/mm/storage/bv;
    //   917: aload_0
    //   918: new 3753	com/tencent/mm/plugin/sns/ui/bb
    //   921: dup
    //   922: aload_0
    //   923: invokespecial 3756	com/tencent/mm/plugin/sns/ui/bb:<init>	(Landroid/app/Activity;)V
    //   926: putfield 1187	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EoL	Lcom/tencent/mm/plugin/sns/ui/bb;
    //   929: aload_0
    //   930: new 807	com/tencent/mm/plugin/sns/ui/be
    //   933: dup
    //   934: aload_0
    //   935: invokevirtual 736	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
    //   938: invokespecial 3757	com/tencent/mm/plugin/sns/ui/be:<init>	(Landroid/content/Context;)V
    //   941: putfield 509	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBe	Lcom/tencent/mm/plugin/sns/ui/be;
    //   944: aload_0
    //   945: new 3759	com/tencent/mm/plugin/sns/ui/j
    //   948: dup
    //   949: aload_0
    //   950: aload_0
    //   951: invokevirtual 543	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   954: aload_0
    //   955: getfield 358	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBL	Lcom/tencent/mm/plugin/sns/model/ak;
    //   958: invokespecial 3762	com/tencent/mm/plugin/sns/ui/j:<init>	(Landroid/app/Activity;ILcom/tencent/mm/plugin/sns/model/ai;)V
    //   961: putfield 610	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBk	Lcom/tencent/mm/plugin/sns/ui/j;
    //   964: aload_0
    //   965: new 3764	com/tencent/mm/plugin/sns/ui/l
    //   968: dup
    //   969: aload_0
    //   970: invokespecial 3767	com/tencent/mm/plugin/sns/ui/l:<init>	(Lcom/tencent/mm/plugin/sns/ui/ab;)V
    //   973: putfield 3769	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBl	Lcom/tencent/mm/plugin/sns/ui/l;
    //   976: aload_1
    //   977: ifnull +76 -> 1053
    //   980: aload_0
    //   981: aload_1
    //   982: iconst_0
    //   983: invokestatic 1491	com/tencent/mm/plugin/sns/ui/bk:g	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Z)I
    //   986: putfield 505	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:qcr	I
    //   989: getstatic 557	com/tencent/mm/plugin/sns/k/e:DUQ	Lcom/tencent/mm/plugin/sns/k/e;
    //   992: invokestatic 3591	java/lang/System:currentTimeMillis	()J
    //   995: putfield 3772	com/tencent/mm/plugin/sns/k/e:DVp	J
    //   998: getstatic 557	com/tencent/mm/plugin/sns/k/e:DUQ	Lcom/tencent/mm/plugin/sns/k/e;
    //   1001: astore 6
    //   1003: aload_1
    //   1004: ifnull +40 -> 1044
    //   1007: aload_1
    //   1008: getfield 1683	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1011: invokestatic 3775	com/tencent/mm/plugin/sns/data/r:Jc	(J)Ljava/lang/String;
    //   1014: astore 7
    //   1016: aload 6
    //   1018: getfield 3778	com/tencent/mm/plugin/sns/k/e:DVj	Ljava/util/List;
    //   1021: aload 7
    //   1023: invokeinterface 3781 2 0
    //   1028: ifne +16 -> 1044
    //   1031: aload 6
    //   1033: getfield 3778	com/tencent/mm/plugin/sns/k/e:DVj	Ljava/util/List;
    //   1036: aload 7
    //   1038: invokeinterface 2202 2 0
    //   1043: pop
    //   1044: getstatic 557	com/tencent/mm/plugin/sns/k/e:DUQ	Lcom/tencent/mm/plugin/sns/k/e;
    //   1047: invokestatic 3591	java/lang/System:currentTimeMillis	()J
    //   1050: putfield 3784	com/tencent/mm/plugin/sns/k/e:DVw	J
    //   1053: aload_1
    //   1054: ifnull +78 -> 1132
    //   1057: aload_1
    //   1058: invokevirtual 540	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
    //   1061: ifeq +71 -> 1132
    //   1064: aload_0
    //   1065: getfield 3206	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBD	I
    //   1068: bipush 16
    //   1070: if_icmpne +296 -> 1366
    //   1073: aload_0
    //   1074: new 2458	com/tencent/mm/plugin/sns/ad/g/k
    //   1077: dup
    //   1078: iconst_2
    //   1079: invokespecial 3786	com/tencent/mm/plugin/sns/ad/g/k:<init>	(I)V
    //   1082: putfield 1026	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBv	Lcom/tencent/mm/plugin/sns/ad/g/k;
    //   1085: aload_0
    //   1086: getfield 1026	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBv	Lcom/tencent/mm/plugin/sns/ad/g/k;
    //   1089: aload_0
    //   1090: getfield 3585	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenHeight	I
    //   1093: aload_0
    //   1094: invokevirtual 3790	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSupportActionBar	()Landroid/support/v7/app/ActionBar;
    //   1097: invokevirtual 3795	android/support/v7/app/ActionBar:getCustomView	()Landroid/view/View;
    //   1100: aload_0
    //   1101: invokevirtual 3798	com/tencent/mm/plugin/sns/ad/g/k:a	(ILandroid/view/View;Landroid/app/Activity;)V
    //   1104: aload_1
    //   1105: iconst_0
    //   1106: invokestatic 1491	com/tencent/mm/plugin/sns/ui/bk:g	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Z)I
    //   1109: pop
    //   1110: aload_0
    //   1111: getfield 502	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Dyw	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   1114: aload_0
    //   1115: getfield 1026	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBv	Lcom/tencent/mm/plugin/sns/ad/g/k;
    //   1118: invokevirtual 3801	com/tencent/mm/plugin/sns/ui/d/c:c	(Lcom/tencent/mm/plugin/sns/ad/g/k;)V
    //   1121: aload_0
    //   1122: getfield 1330	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EoR	Lcom/tencent/mm/plugin/sns/ui/b;
    //   1125: aload_0
    //   1126: getfield 1026	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBv	Lcom/tencent/mm/plugin/sns/ad/g/k;
    //   1129: putfield 3804	com/tencent/mm/plugin/sns/ui/b:DzW	Lcom/tencent/mm/plugin/sns/ad/g/k;
    //   1132: aload_0
    //   1133: invokevirtual 3806	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:initView	()V
    //   1136: aload_1
    //   1137: ifnull +47 -> 1184
    //   1140: aload_1
    //   1141: invokevirtual 540	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
    //   1144: ifeq +40 -> 1184
    //   1147: aload_1
    //   1148: invokestatic 481	com/tencent/mm/plugin/sns/model/an:B	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   1151: astore 6
    //   1153: aload_0
    //   1154: getfield 1026	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBv	Lcom/tencent/mm/plugin/sns/ad/g/k;
    //   1157: iconst_0
    //   1158: aload_1
    //   1159: invokevirtual 974	com/tencent/mm/plugin/sns/storage/SnsInfo:getLocalid	()Ljava/lang/String;
    //   1162: aload_1
    //   1163: invokevirtual 3809	com/tencent/mm/plugin/sns/storage/SnsInfo:isExposures	()Z
    //   1166: aload_0
    //   1167: getfield 1445	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EAP	Landroid/view/View;
    //   1170: aload_1
    //   1171: getfield 1683	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1174: aload 6
    //   1176: aload_0
    //   1177: getfield 505	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:qcr	I
    //   1180: iconst_2
    //   1181: invokevirtual 3812	com/tencent/mm/plugin/sns/ad/g/k:a	(ILjava/lang/String;ZLandroid/view/View;JLcom/tencent/mm/protocal/protobuf/SnsObject;II)V
    //   1184: aload_0
    //   1185: getfield 1445	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EAP	Landroid/view/View;
    //   1188: ifnull +79 -> 1267
    //   1191: aload_1
    //   1192: ifnull +75 -> 1267
    //   1195: aload_0
    //   1196: getfield 1445	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EAP	Landroid/view/View;
    //   1199: ldc_w 2266
    //   1202: invokevirtual 1493	android/view/View:findViewById	(I)Landroid/view/View;
    //   1205: checkcast 3814	com/tencent/mm/plugin/sight/decode/a/a
    //   1208: astore 6
    //   1210: aload_1
    //   1211: invokevirtual 791	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1214: getfield 797	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adp;
    //   1217: ifnull +339 -> 1556
    //   1220: aload_1
    //   1221: invokevirtual 791	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1224: getfield 797	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/adp;
    //   1227: getfield 802	com/tencent/mm/protocal/protobuf/adp:LoU	I
    //   1230: bipush 15
    //   1232: if_icmpne +324 -> 1556
    //   1235: aload 6
    //   1237: instanceof 2375
    //   1240: ifeq +316 -> 1556
    //   1243: aload 6
    //   1245: checkcast 2375	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView
    //   1248: getfield 3818	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView:Dnr	Lcom/tencent/mm/plugin/sight/decode/a/b;
    //   1251: invokevirtual 3823	com/tencent/mm/plugin/sight/decode/a/b:eVy	()Z
    //   1254: istore 5
    //   1256: aload_1
    //   1257: iconst_1
    //   1258: iload 5
    //   1260: aload_0
    //   1261: invokevirtual 543	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   1264: invokestatic 3828	com/tencent/mm/plugin/sns/ad/g/o:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;ZZI)V
    //   1267: aload_0
    //   1268: getfield 642	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EAT	Landroid/widget/ListView;
    //   1271: ifnonnull +110 -> 1381
    //   1274: ldc_w 3530
    //   1277: invokestatic 284	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1280: return
    //   1281: ldc_w 708
    //   1284: ldc_w 3830
    //   1287: invokestatic 780	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1290: goto -620 -> 670
    //   1293: invokestatic 1569	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
    //   1296: pop
    //   1297: invokestatic 3727	com/tencent/mm/kernel/g:aAg	()Lcom/tencent/mm/kernel/b;
    //   1300: getfield 3733	com/tencent/mm/kernel/b:hqi	Lcom/tencent/mm/ak/t;
    //   1303: new 3735	com/tencent/mm/plugin/sns/model/r
    //   1306: dup
    //   1307: aload_0
    //   1308: getfield 470	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dRS	Ljava/lang/String;
    //   1311: invokestatic 3738	com/tencent/mm/plugin/sns/storage/y:aOa	(Ljava/lang/String;)J
    //   1314: invokespecial 3740	com/tencent/mm/plugin/sns/model/r:<init>	(J)V
    //   1317: iconst_0
    //   1318: invokevirtual 3745	com/tencent/mm/ak/t:a	(Lcom/tencent/mm/ak/q;I)Z
    //   1321: pop
    //   1322: goto -514 -> 808
    //   1325: invokestatic 1569	com/tencent/mm/kernel/g:aAi	()Lcom/tencent/mm/kernel/g;
    //   1328: pop
    //   1329: invokestatic 3727	com/tencent/mm/kernel/g:aAg	()Lcom/tencent/mm/kernel/b;
    //   1332: getfield 3733	com/tencent/mm/kernel/b:hqi	Lcom/tencent/mm/ak/t;
    //   1335: new 3832	com/tencent/mm/plugin/sns/model/m
    //   1338: dup
    //   1339: aload_0
    //   1340: getfield 470	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dRS	Ljava/lang/String;
    //   1343: invokestatic 3738	com/tencent/mm/plugin/sns/storage/y:aOa	(Ljava/lang/String;)J
    //   1346: iconst_0
    //   1347: aload_0
    //   1348: aload_1
    //   1349: invokespecial 648	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:g	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   1352: getfield 3835	com/tencent/mm/plugin/sns/storage/ADInfo:adInfoSyncBuffer	Ljava/lang/String;
    //   1355: invokespecial 3838	com/tencent/mm/plugin/sns/model/m:<init>	(JILjava/lang/String;)V
    //   1358: iconst_0
    //   1359: invokevirtual 3745	com/tencent/mm/ak/t:a	(Lcom/tencent/mm/ak/q;I)Z
    //   1362: pop
    //   1363: goto -555 -> 808
    //   1366: aload_0
    //   1367: new 2458	com/tencent/mm/plugin/sns/ad/g/k
    //   1370: dup
    //   1371: iconst_1
    //   1372: invokespecial 3786	com/tencent/mm/plugin/sns/ad/g/k:<init>	(I)V
    //   1375: putfield 1026	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBv	Lcom/tencent/mm/plugin/sns/ad/g/k;
    //   1378: goto -293 -> 1085
    //   1381: aload_0
    //   1382: getfield 642	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EAT	Landroid/widget/ListView;
    //   1385: new 82	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$6
    //   1388: dup
    //   1389: aload_0
    //   1390: invokespecial 3839	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$6:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   1393: invokevirtual 3840	android/widget/ListView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1396: aload_0
    //   1397: new 3842	com/tencent/mm/plugin/sns/ui/n
    //   1400: dup
    //   1401: aload_0
    //   1402: invokespecial 3843	com/tencent/mm/plugin/sns/ui/n:<init>	(Landroid/content/Context;)V
    //   1405: putfield 347	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBG	Lcom/tencent/mm/plugin/sns/ui/n;
    //   1408: aload_1
    //   1409: ifnull +34 -> 1443
    //   1412: aload_0
    //   1413: getfield 1317	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:gna	Ljava/lang/String;
    //   1416: aload_1
    //   1417: invokevirtual 927	com/tencent/mm/plugin/sns/storage/SnsInfo:getUserName	()Ljava/lang/String;
    //   1420: invokestatic 1792	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1423: ifeq +20 -> 1443
    //   1426: aload_0
    //   1427: iconst_0
    //   1428: ldc_w 3844
    //   1431: new 3846	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7
    //   1434: dup
    //   1435: aload_0
    //   1436: aload_1
    //   1437: invokespecial 3847	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
    //   1440: invokevirtual 3851	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:addIconOptionMenu	(IILandroid/view/MenuItem$OnMenuItemClickListener;)V
    //   1443: getstatic 3412	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   1446: aload_0
    //   1447: getfield 399	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:lEl	Lcom/tencent/mm/sdk/event/IListener;
    //   1450: invokevirtual 3855	com/tencent/mm/sdk/event/EventCenter:addListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   1453: pop
    //   1454: getstatic 3412	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   1457: aload_0
    //   1458: getfield 363	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBM	Lcom/tencent/mm/sdk/event/IListener;
    //   1461: invokevirtual 3855	com/tencent/mm/sdk/event/EventCenter:addListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   1464: pop
    //   1465: getstatic 3412	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   1468: aload_0
    //   1469: getfield 366	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBN	Lcom/tencent/mm/sdk/event/IListener;
    //   1472: invokevirtual 3855	com/tencent/mm/sdk/event/EventCenter:addListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   1475: pop
    //   1476: getstatic 3412	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   1479: aload_0
    //   1480: getfield 369	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBO	Lcom/tencent/mm/sdk/event/IListener;
    //   1483: invokevirtual 3855	com/tencent/mm/sdk/event/EventCenter:addListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   1486: pop
    //   1487: getstatic 3412	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   1490: aload_0
    //   1491: getfield 372	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBP	Lcom/tencent/mm/sdk/event/IListener;
    //   1494: invokevirtual 3855	com/tencent/mm/sdk/event/EventCenter:addListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   1497: pop
    //   1498: getstatic 3412	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   1501: aload_0
    //   1502: getfield 396	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBU	Lcom/tencent/mm/sdk/event/IListener;
    //   1505: invokevirtual 3855	com/tencent/mm/sdk/event/EventCenter:addListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   1508: pop
    //   1509: getstatic 3412	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   1512: aload_0
    //   1513: getfield 404	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EBV	Lcom/tencent/mm/sdk/event/IListener;
    //   1516: invokevirtual 3855	com/tencent/mm/sdk/event/EventCenter:addListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   1519: pop
    //   1520: getstatic 3412	com/tencent/mm/sdk/event/EventCenter:instance	Lcom/tencent/mm/sdk/event/EventCenter;
    //   1523: aload_0
    //   1524: getfield 375	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:EoY	Lcom/tencent/mm/sdk/event/IListener;
    //   1527: invokevirtual 3855	com/tencent/mm/sdk/event/EventCenter:addListener	(Lcom/tencent/mm/sdk/event/IListener;)Z
    //   1530: pop
    //   1531: aload_0
    //   1532: invokestatic 3857	com/tencent/mm/pluginsdk/h:r	(Lcom/tencent/mm/ui/MMActivity;)V
    //   1535: ldc_w 3530
    //   1538: invokestatic 284	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1541: return
    //   1542: astore_1
    //   1543: goto -873 -> 670
    //   1546: astore 6
    //   1548: goto -910 -> 638
    //   1551: astore 7
    //   1553: goto -979 -> 574
    //   1556: iconst_0
    //   1557: istore 5
    //   1559: goto -303 -> 1256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1562	0	this	SnsCommentDetailUI
    //   0	1562	1	paramBundle	Bundle
    //   284	11	2	i	int
    //   473	189	3	l	long
    //   1254	304	5	bool	boolean
    //   496	748	6	localObject	Object
    //   1546	1	6	localIOException	java.io.IOException
    //   1014	23	7	str	String
    //   1551	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   498	505	1542	java/io/IOException
    //   629	638	1546	java/io/IOException
    //   565	574	1551	java/lang/Exception
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98596);
    com.tencent.mm.plugin.sns.model.aj.faE().a(this, 5);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(210, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(218, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(213, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(214, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(683, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(682, this);
    com.tencent.mm.plugin.sns.model.aj.faL().aI(this);
    EventCenter.instance.removeListener(this.lEl);
    if (this.EBk != null) {
      this.EBk.activity = null;
    }
    af.ffX();
    if (this.EoJ != null) {
      this.EoJ.fib();
    }
    SnsInfo localSnsInfo = vs(false);
    Object localObject;
    if ((localSnsInfo != null) && (localSnsInfo.isAd()))
    {
      if (this.EBv != null) {
        this.EBv.a(0, localSnsInfo.getLocalid(), localSnsInfo.field_snsId, 2);
      }
      localObject = g(localSnsInfo);
      if (localObject != null) {
        break label626;
      }
      localObject = "";
      if (!localSnsInfo.isRecExpAd()) {
        break label634;
      }
      com.tencent.mm.plugin.sns.model.aj.faI().a(14652, new Object[] { com.tencent.mm.plugin.sns.ad.g.j.a(localSnsInfo.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.r.Jb(localSnsInfo.field_snsId), localObject, Long.valueOf(this.EAN), Long.valueOf(System.currentTimeMillis()) }) });
    }
    for (;;)
    {
      com.tencent.mm.modelsns.k localk = com.tencent.mm.modelsns.k.tP(732);
      localk.PH(com.tencent.mm.plugin.sns.data.r.Jb(localSnsInfo.field_snsId)).PH((String)localObject).PH(this.EAN).PH(System.currentTimeMillis());
      localk.bfK();
      this.Dyw.removeListener();
      EventCenter.instance.removeListener(this.EBM);
      EventCenter.instance.removeListener(this.EBN);
      EventCenter.instance.removeListener(this.EBO);
      EventCenter.instance.removeListener(this.EBP);
      EventCenter.instance.removeListener(this.EBU);
      EventCenter.instance.removeListener(this.EBV);
      EventCenter.instance.removeListener(this.EoY);
      super.onDestroy();
      localObject = com.tencent.mm.plugin.sns.k.e.DUQ;
      if (((com.tencent.mm.plugin.sns.k.e)localObject).DVp != 0L)
      {
        ((com.tencent.mm.plugin.sns.k.e)localObject).DVq += System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.k.e)localObject).DVp;
        ((com.tencent.mm.plugin.sns.k.e)localObject).DVp = 0L;
      }
      localObject = com.tencent.mm.plugin.sns.k.e.DUQ;
      if (((com.tencent.mm.plugin.sns.k.e)localObject).DVw != 0L)
      {
        ((com.tencent.mm.plugin.sns.k.e)localObject).DVx += System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.k.e)localObject).DVw;
        ((com.tencent.mm.plugin.sns.k.e)localObject).DVw = 0L;
      }
      if ((this.EBE) && (localSnsInfo != null) && (localSnsInfo.getTimeLine() != null) && (localSnsInfo.getTimeLine().ContentObj != null))
      {
        localObject = com.tencent.mm.plugin.sns.k.e.DUQ.fcy();
        ((ih)localObject).eDV = com.tencent.mm.plugin.sns.k.e.DUQ.DVe.eDV;
        ((ih)localObject).we(com.tencent.mm.plugin.sns.k.e.DUQ.DVe.ePK).wf(com.tencent.mm.plugin.sns.data.r.Jc(localSnsInfo.field_snsId)).erx = localSnsInfo.getTimeLine().ContentObj.LoU;
        com.tencent.mm.plugin.sns.k.e.DUQ.fcD();
      }
      if (this.EBK != null) {
        this.EBK.destroy();
      }
      AppMethodBeat.o(98596);
      return;
      label626:
      localObject = ((ADInfo)localObject).uxInfo;
      break;
      label634:
      com.tencent.mm.plugin.sns.model.aj.faI().a(12012, new Object[] { com.tencent.mm.plugin.sns.ad.g.j.a(localSnsInfo.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.r.Jb(localSnsInfo.field_snsId), localObject, Long.valueOf(this.EAN), Long.valueOf(System.currentTimeMillis()) }) });
    }
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(98612);
    if (keyboardState() == 2)
    {
      Log.i("MicroMsg.SnsCommentDetailUI", "keybaordhide! ");
      this.EBd = false;
      AppMethodBeat.o(98612);
      return;
    }
    if (keyboardState() == 1)
    {
      Log.i("MicroMsg.SnsCommentDetailUI", "keybaordShow");
      fhQ();
      this.EoG = false;
      this.EBS.run();
      if (this.EoR != null) {
        this.EoR.fcl();
      }
    }
    AppMethodBeat.o(98612);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98598);
    com.tencent.mm.plugin.sns.model.aj.faJ().b(this);
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, null);
      this.ExJ = false;
      super.onPause();
      this.EoJ.gte.hideVKB();
      Object localObject = this.EoJ;
      if (((SnsCommentFooter)localObject).rum != null) {
        ((SnsCommentFooter)localObject).rum.onPause();
      }
      ((SnsCommentFooter)localObject).ECK.onPause();
      new yh().eeC.type = 1;
      try
      {
        if ((this.EBz) && (this.EAP != null))
        {
          localObject = vs(false);
          if ((localObject != null) && (((SnsInfo)localObject).isAd()))
          {
            localVideoSightView = (VideoSightView)this.EAP.findViewById(2131302526);
            SnsAdTimelineVideoView localSnsAdTimelineVideoView = (SnsAdTimelineVideoView)this.EAP.findViewById(2131305364);
            if (!a((SnsInfo)localObject, localSnsAdTimelineVideoView)) {
              break label251;
            }
            if ((localSnsAdTimelineVideoView.isPlaying()) && (localSnsAdTimelineVideoView.getVisibility() == 0))
            {
              Log.i("MicroMsg.SnsCommentDetailUI", "new video vie pauseNormalVideoAd");
              com.tencent.mm.plugin.sns.ad.timeline.b.f.c(localSnsAdTimelineVideoView);
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          VideoSightView localVideoSightView;
          Log.e("MicroMsg.SnsCommentDetailUI", "pauseNormalVideoAd, exp=" + localThrowable2.toString());
        }
      }
      if (this.EBv != null)
      {
        this.EBv.onPause();
        localObject = vs(false);
        if ((localObject != null) && (((SnsInfo)localObject).isAd())) {
          this.EBv.IU(((SnsInfo)localObject).field_snsId);
        }
      }
      if (this.EBu != null) {
        this.EBu.onPause();
      }
      AppMethodBeat.o(98598);
      return;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable1.toString());
        continue;
        label251:
        if ((localVideoSightView.isPlaying()) && (localVideoSightView.getVisibility() == 0))
        {
          Log.i("MicroMsg.SnsCommentDetailUI", "pauseNormalVideoAd");
          localVideoSightView.pause();
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98597);
    try
    {
      if (!this.ExJ)
      {
        Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onResume callback");
        ScreenShotUtil.setScreenShotCallback(this, this.EyL);
        this.ExJ = true;
      }
      com.tencent.mm.plugin.sns.model.aj.faJ().a(this);
      localObject = new yh();
      ((yh)localObject).eeC.eeD = 0;
      ((yh)localObject).eeC.eeE = 1;
      ((yh)localObject).eeC.eeF = 0;
      ((yh)localObject).eeC.type = 0;
      EventCenter.instance.publish((IEvent)localObject);
      if (this.EBv != null) {
        this.EBv.onResume();
      }
      if (this.EBu != null) {
        this.EBu.refreshView();
      }
      super.onResume();
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          Object localObject;
          if ((this.EBz) && (this.EAP != null))
          {
            Log.i("MicroMsg.SnsCommentDetailUI", "new video vie resumeNormalVideoAd called");
            localObject = (SnsAdTimelineVideoView)this.EAP.findViewById(2131305364);
            if (a(vs(false), (SnsAdTimelineVideoView)localObject))
            {
              com.tencent.mm.plugin.sns.ad.timeline.b.f.b((SnsAdTimelineVideoView)localObject);
              Log.i("MicroMsg.SnsCommentDetailUI", "new video vie resumeNormalVideoAd");
            }
          }
          AppMethodBeat.o(98597);
          return;
        }
        catch (Throwable localThrowable2)
        {
          Log.e("MicroMsg.SnsCommentDetailUI", "resumeNormalVideoAd, exp=" + localThrowable2.toString());
          AppMethodBeat.o(98597);
        }
        localThrowable1 = localThrowable1;
        Log.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable1.toString());
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(98611);
    if ((paramq.getType() == 218) && (this.EoW != null)) {
      this.EoW.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((this.EBG != null) && (this.EBG.tipDialog != null) && (this.EBG.tipDialog.isShowing())) {
        this.EBG.tipDialog.dismiss();
      }
      Object localObject = com.tencent.mm.plugin.sns.storage.f.aQl(this.dRS);
      if (localObject == null)
      {
        Log.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.dRS);
        finish();
        AppMethodBeat.o(98611);
        return;
      }
      Log.d("MicroMsg.SnsCommentDetailUI", "snsId: " + this.dRS + "  username:" + ((SnsInfo)localObject).getUserName());
      if (this.EAP == null)
      {
        Log.e("MicroMsg.SnsCommentDetailUI", "fatal error! Sns onSceneEnd before initView and infoHeader is null!");
        finish();
        AppMethodBeat.o(98611);
        return;
      }
      fhP();
      f((SnsInfo)localObject, false);
      paramString = an.B((SnsInfo)localObject);
      Log.i("MicroMsg.SnsCommentDetailUI", "onsceneend " + paramString.LikeUserList.size() + " " + paramString.CommentUserList.size());
      if (paramString == null)
      {
        AppMethodBeat.o(98611);
        return;
      }
      if (!f(this.EBb, paramString.LikeUserList))
      {
        n(paramString.LikeUserList, paramString.CommentUserList.isEmpty());
        this.EBb = paramString.LikeUserList;
      }
      if (this.EAS != null) {
        this.EAS.a((SnsInfo)localObject, this.Dyw);
      }
      localObject = this.EAW;
      LinkedList localLinkedList = paramString.CommentUserList;
      paramString = paramString.LikeUserList;
      ((b)localObject).commentList = localLinkedList;
      ((b)localObject).ECC = paramString;
      this.EAW.notifyDataSetChanged();
      paramString = this.EAW;
      new MMHandler().postDelayed(new SnsCommentDetailUI.b.1(paramString), 60L);
    }
    SnsTimeLineUI.a(paramInt1, paramInt2, paramq, this);
    AppMethodBeat.o(98611);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(203538);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, null);
      this.ExJ = false;
      AppMethodBeat.o(203538);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      Log.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.o(203538);
    }
    if (!this.ExJ)
    {
      Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onWindowFocusChanged callback");
      ScreenShotUtil.setScreenShotCallback(this, this.EyL);
      this.ExJ = true;
    }
    AppMethodBeat.o(203538);
    return;
  }
  
  final class a
    extends com.tencent.mm.pluginsdk.ui.span.q
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(98583);
      SnsCommentDetailUI.i(SnsCommentDetailUI.this).ERi.onClick(paramView);
      AppMethodBeat.o(98583);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(98584);
      int i = SnsCommentDetailUI.this.getResources().getColor(2131101130);
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
    LinkedList<dzo> ECC;
    Activity activity;
    public LinkedList<dzo> commentList;
    String dHp;
    
    public b(LinkedList<dzo> paramLinkedList, Activity paramActivity, String paramString)
    {
      this.commentList = paramLinkedList;
      this.ECC = paramActivity;
      this.activity = paramString;
      Object localObject;
      this.dHp = localObject;
    }
    
    public final int getCount()
    {
      int i = 0;
      AppMethodBeat.i(98587);
      if (this.ECC.size() > 0)
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
      if (this.ECC.size() > 0)
      {
        if (paramInt == 0)
        {
          paramView = SnsCommentDetailUI.J(SnsCommentDetailUI.this);
          AppMethodBeat.o(98588);
          return paramView;
        }
        i = paramInt - 1;
      }
      Object localObject3 = (dzo)this.commentList.get(i);
      ((dzo)localObject3).iAc = Util.nullAsNil(((dzo)localObject3).iAc);
      View localView;
      if ((paramView == null) || (!(paramView.getTag() instanceof a)))
      {
        localView = aa.jQ(this.activity).inflate(2131496427, null);
        localView.setOnTouchListener(SnsCommentDetailUI.K(SnsCommentDetailUI.this));
        paramViewGroup = new a();
        paramViewGroup.gvv = ((ImageView)localView.findViewById(2131296624));
        paramViewGroup.gvv.setOnClickListener(SnsCommentDetailUI.L(SnsCommentDetailUI.this));
        paramViewGroup.kib = ((TextView)localView.findViewById(2131296636));
        paramViewGroup.kib.setOnTouchListener(new af());
        paramViewGroup.kib.setOnClickListener(new SnsCommentDetailUI.b.2(this));
        paramViewGroup.timeTv = ((TextView)localView.findViewById(2131296639));
        paramViewGroup.hXC = ((TextView)localView.findViewById(2131296628));
        paramViewGroup.ECE = ((FrameLayout)localView.findViewById(2131296627));
        paramViewGroup.hXC.setOnTouchListener(new af());
        paramViewGroup.ECF = ((SnsTranslateResultView)localView.findViewById(2131308248));
        paramViewGroup.ECF.setVisibility(8);
        paramViewGroup.ECH = ((EmojiStatusView)localView.findViewById(2131296629));
        if (SnsCommentDetailUI.E(SnsCommentDetailUI.this) != 10) {
          break label1997;
        }
        localView.findViewById(2131298974).setBackgroundResource(2131232826);
      }
      label435:
      label840:
      label1994:
      label1997:
      for (;;)
      {
        paramViewGroup.ECG = ((dzo)localObject3);
        paramViewGroup.userName = ((dzo)localObject3).Username;
        ((SnsAvatarImageView)paramViewGroup.gvv).fL(((dzo)localObject3).Username, 3);
        ((SnsAvatarImageView)paramViewGroup.gvv).setWeakContext(this.activity);
        label366:
        SnsInfo localSnsInfo;
        if (SnsCommentDetailUI.E(SnsCommentDetailUI.this) == 10)
        {
          paramInt = 3;
          SnsCommentDetailUI.E(SnsCommentDetailUI.this);
          com.tencent.mm.kernel.g.aAi();
          paramView = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(paramViewGroup.userName);
          if ((i != 0) || (!this.ECC.isEmpty())) {
            break label1645;
          }
          if (SnsCommentDetailUI.E(SnsCommentDetailUI.this) != 10) {
            break label1634;
          }
          localView.setBackgroundResource(2131232827);
          if (i != 0) {
            break label1679;
          }
          localView.findViewById(2131308101).setVisibility(0);
          localView.findViewById(2131308102).setVisibility(8);
          if (SnsCommentDetailUI.E(SnsCommentDetailUI.this) == 10) {
            ((ImageView)localView.findViewById(2131308101)).setImageResource(2131690348);
          }
          label490:
          localSnsInfo = com.tencent.mm.plugin.sns.storage.f.aQl(SnsCommentDetailUI.m(SnsCommentDetailUI.this));
          paramViewGroup.gvv.setTag(((dzo)localObject3).Username);
          if (!com.tencent.mm.plugin.sns.ui.widget.e.a(paramViewGroup.gvv, localSnsInfo, ((dzo)localObject3).Username)) {
            a.b.A(paramViewGroup.gvv, ((dzo)localObject3).Username);
          }
          if (paramView == null) {
            break label1704;
          }
          paramView = paramView.arJ();
          if (!com.tencent.mm.plugin.sns.ui.widget.e.b(localSnsInfo, ((dzo)localObject3).Username)) {
            break label1994;
          }
          paramView = com.tencent.mm.plugin.sns.ui.widget.e.c(localSnsInfo.getAdXml(), paramView);
        }
        for (;;)
        {
          String str;
          CharSequence localCharSequence;
          Object localObject2;
          Object localObject1;
          label749:
          int j;
          label887:
          long l;
          if (localSnsInfo != null)
          {
            str = localSnsInfo.field_userName;
            paramViewGroup.hXC.setText(((dzo)localObject3).iAc + " ");
            localCharSequence = com.tencent.mm.plugin.sns.ui.widget.e.a(SnsCommentDetailUI.this, (dzo)localObject3, SnsCommentDetailUI.M(SnsCommentDetailUI.this), localSnsInfo.field_type, localSnsInfo.getUserName(), 2, SnsCommentDetailUI.N(SnsCommentDetailUI.this), SnsCommentDetailUI.O(SnsCommentDetailUI.this), localSnsInfo);
            localObject2 = null;
            localObject1 = localObject2;
            if (!Util.isNullOrNil(((dzo)localObject3).MYY))
            {
              localObject1 = localObject2;
              if (((dzo)localObject3).MYY.get(0) != null)
              {
                localObject1 = ((dzu)((dzo)localObject3).MYY.get(0)).Md5;
                localObject1 = bj.gCJ().OpN.blk((String)localObject1);
              }
            }
            if (localObject1 != null) {
              break label1730;
            }
            paramViewGroup.ECH.setVisibility(8);
            paramViewGroup.ECH.setEmojiInfo(null);
            paramViewGroup.kib.setText(paramView, TextView.BufferType.SPANNABLE);
            com.tencent.mm.pluginsdk.ui.span.l.p(paramViewGroup.kib, paramInt);
            localObject1 = new com.tencent.mm.pluginsdk.ui.span.m(paramViewGroup.kib.getText());
            Log.i("MicroMsg.SnsCommentDetailUI", "test %s,%s", new Object[] { ((dzo)localObject3).Username, paramView });
            if (!com.tencent.mm.plugin.sns.ui.widget.e.b(localSnsInfo, ((dzo)localObject3).Username)) {
              break label1824;
            }
            if (!com.tencent.mm.plugin.sns.ui.widget.e.iY(((dzo)localObject3).MYX, 32)) {
              break label1818;
            }
            j = 27;
            ((com.tencent.mm.pluginsdk.ui.span.m)localObject1).a(new com.tencent.mm.pluginsdk.ui.span.q(new com.tencent.mm.plugin.sns.data.b(localSnsInfo.isAd(), ((dzo)localObject3).Username, localSnsInfo.getLocalid(), 2, j), SnsCommentDetailUI.M(SnsCommentDetailUI.this), paramInt), paramView, 0);
            paramViewGroup.kib.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
            l = ((dzo)localObject3).CreateTime;
            if (com.tencent.mm.plugin.sns.ui.widget.e.iY(((dzo)localObject3).MYX, 32)) {
              l = localSnsInfo.getCreateTime();
            }
            paramViewGroup.timeTv.setText(bm.r(this.activity, l * 1000L));
            if (!Util.isNullOrNil(localCharSequence)) {
              break label1854;
            }
            paramViewGroup.hXC.setVisibility(8);
            label978:
            SnsCommentDetailUI.P(SnsCommentDetailUI.this).c(localView, SnsCommentDetailUI.D(SnsCommentDetailUI.this).FaE, SnsCommentDetailUI.D(SnsCommentDetailUI.this).Far);
            SnsCommentDetailUI.P(SnsCommentDetailUI.this).c(paramViewGroup.ECE, SnsCommentDetailUI.D(SnsCommentDetailUI.this).FaE, SnsCommentDetailUI.D(SnsCommentDetailUI.this).Far);
            if (((dzo)localObject3).MYT == 0) {
              break label1913;
            }
            l = ((dzo)localObject3).MYT;
            localObject2 = au.kj(SnsCommentDetailUI.m(SnsCommentDetailUI.this), String.valueOf(l));
            if ((au.fC((String)localObject2, 4)) && (paramViewGroup.ECF != null))
            {
              localObject2 = au.aPp((String)localObject2);
              if (localObject2 == null) {
                break label1946;
              }
              paramViewGroup.ECF.setVisibility(0);
              if (!((au.b)localObject2).iGD) {
                break label1935;
              }
              if (((au.b)localObject2).aGI) {
                break label1923;
              }
              paramViewGroup.ECF.a((au.b)localObject2, 2, ((au.b)localObject2).result, ((au.b)localObject2).brand, ((au.b)localObject2).DNi);
            }
            localView.setClickable(true);
            Log.d("MicroMsg.SnsCommentDetailUI", "position " + ((dzo)localObject3).Username + " self " + SnsCommentDetailUI.s(SnsCommentDetailUI.this) + " commentid " + ((dzo)localObject3).MYT + " snsid " + SnsCommentDetailUI.m(SnsCommentDetailUI.this));
            if (!SnsCommentDetailUI.s(SnsCommentDetailUI.this).equals(((dzo)localObject3).Username)) {
              break label1958;
            }
          }
          for (paramViewGroup.info = localObject3;; paramViewGroup.info = new Object[] { Integer.valueOf(i), localObject3, ((dzo)localObject3).Username, paramView })
          {
            paramView = new m(SnsCommentDetailUI.j(SnsCommentDetailUI.this), SnsCommentDetailUI.m(SnsCommentDetailUI.this), (dzo)localObject3, ((dzo)localObject3).Username, ((dzo)localObject3).iAc, paramViewGroup.hXC, 2, str);
            paramView.tag = paramViewGroup;
            localView.setTag(paramView);
            paramViewGroup.hXC.setTag(paramView);
            localView.setOnClickListener(SnsCommentDetailUI.Q(SnsCommentDetailUI.this));
            localObject2 = new o(SnsCommentDetailUI.this);
            if (com.tencent.mm.plugin.sns.ui.widget.e.b(localSnsInfo, ((dzo)localObject3).Username))
            {
              ((o)localObject2).setAdTagClickCallback(SnsCommentDetailUI.R(SnsCommentDetailUI.this), 0);
              ((o)localObject2).mAdTagClickScene = 31;
            }
            paramViewGroup.hXC.setOnTouchListener((View.OnTouchListener)localObject2);
            paramViewGroup.ECE.setTag(paramView);
            paramViewGroup.ECE.setOnClickListener(SnsCommentDetailUI.Q(SnsCommentDetailUI.this));
            if ((!localSnsInfo.isAd()) && (((dzo)localObject3).DeleteFlag > 0))
            {
              ((com.tencent.mm.pluginsdk.ui.span.m)localObject1).setSpan(new ForegroundColorSpan(SnsCommentDetailUI.this.getContext().getResources().getColor(2131099683)), 0, ((com.tencent.mm.pluginsdk.ui.span.m)localObject1).length(), 33);
              paramViewGroup.kib.setText((CharSequence)localObject1);
              paramView = paramViewGroup.hXC;
              localObject1 = SnsCommentDetailUI.this.getContext();
              localObject2 = ((Context)localObject1).getResources().getString(2131766017);
              localObject3 = new SpannableStringBuilder((CharSequence)localObject2);
              ((SpannableStringBuilder)localObject3).setSpan(new ForegroundColorSpan(((Context)localObject1).getResources().getColor(2131099683)), 0, ((String)localObject2).length(), 0);
              ((SpannableStringBuilder)localObject3).setSpan(new BackgroundColorSpan(((Context)localObject1).getResources().getColor(2131099687)), 0, ((String)localObject2).length(), 0);
              paramView.setText((CharSequence)localObject3);
              paramViewGroup.hXC.setOnTouchListener(null);
              paramViewGroup.ECE.setOnLongClickListener(null);
              paramViewGroup.ECE.setOnClickListener(null);
              localView.setOnClickListener(null);
              localView.setOnLongClickListener(null);
            }
            AppMethodBeat.o(98588);
            return localView;
            paramViewGroup = (a)paramView.getTag();
            localView = paramView;
            break;
            paramInt = 2;
            break label366;
            label1634:
            localView.setBackgroundResource(2131232835);
            break label435;
            label1645:
            if (SnsCommentDetailUI.E(SnsCommentDetailUI.this) == 10)
            {
              localView.setBackgroundResource(2131234971);
              break label435;
            }
            localView.setBackgroundResource(2131234970);
            break label435;
            localView.findViewById(2131308101).setVisibility(4);
            localView.findViewById(2131308102).setVisibility(0);
            break label490;
            if (((dzo)localObject3).Nickname != null)
            {
              paramView = ((dzo)localObject3).Nickname;
              break label552;
            }
            paramView = ((dzo)localObject3).Username;
            break label552;
            localObject2 = new m(SnsCommentDetailUI.j(SnsCommentDetailUI.this), SnsCommentDetailUI.m(SnsCommentDetailUI.this), (dzo)localObject3, ((dzo)localObject3).Username, ((dzo)localObject3).iAc, paramViewGroup.hXC, 2, str);
            paramViewGroup.ECH.setTag(localObject2);
            paramViewGroup.ECH.setVisibility(0);
            paramViewGroup.ECH.setEmojiInfo((EmojiInfo)localObject1);
            paramViewGroup.ECH.setOnClickListener(SnsCommentDetailUI.D(SnsCommentDetailUI.this).FaX);
            break label749;
            j = 2;
            break label840;
            ((com.tencent.mm.pluginsdk.ui.span.m)localObject1).a(new com.tencent.mm.pluginsdk.ui.span.q(((dzo)localObject3).Username, SnsCommentDetailUI.M(SnsCommentDetailUI.this), paramInt), paramView, 0);
            break label887;
            localObject2 = new SpannableStringBuilder(localCharSequence);
            ((SpannableStringBuilder)localObject2).append(" ");
            paramViewGroup.hXC.setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
            paramViewGroup.hXC.setVisibility(0);
            localObject2 = com.tencent.mm.plugin.sns.i.a.DRI;
            a.a.a(paramViewGroup.hXC, paramViewGroup.ECG);
            break label978;
            label1913:
            l = ((dzo)localObject3).MYV;
            break label1060;
            paramViewGroup.ECF.setVisibility(8);
            break label1154;
            paramViewGroup.ECF.ZW(2);
            break label1154;
            paramViewGroup.ECF.setVisibility(8);
            break label1154;
          }
        }
      }
    }
    
    final class a
    {
      FrameLayout ECE;
      SnsTranslateResultView ECF;
      dzo ECG;
      EmojiStatusView ECH;
      ImageView gvv;
      TextView hXC;
      Object info;
      TextView kib;
      TextView timeTv;
      String userName;
      
      a() {}
    }
  }
  
  final class c
    implements OfflineVideoView.a
  {
    private SnsInfo DsC;
    private SnsAdTimelineVideoView Ewt;
    
    c(SnsInfo paramSnsInfo, SnsAdTimelineVideoView paramSnsAdTimelineVideoView)
    {
      this.DsC = paramSnsInfo;
      this.Ewt = paramSnsAdTimelineVideoView;
    }
    
    public final boolean a(PString paramPString)
    {
      return false;
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(203536);
      Log.i("MicroMsg.SnsCommentDetailUI", "the detail new video player onCompletion return value is ");
      if ((SnsCommentDetailUI.e(SnsCommentDetailUI.this) == null) || (this.DsC == null) || (this.Ewt == null))
      {
        Log.w("MicroMsg.SnsCommentDetailUI", "the snsAdStatistic or snsInfo is null in onCompletion!!!");
        AppMethodBeat.o(203536);
        return;
      }
      this.Ewt.restart();
      SnsCommentDetailUI.e(SnsCommentDetailUI.this).I(this.DsC.field_snsId, false);
      AppMethodBeat.o(203536);
    }
    
    public final void onStart(int paramInt)
    {
      AppMethodBeat.i(203535);
      Log.i("MicroMsg.SnsCommentDetailUI", "the detail new video player onStart called,  durationSecond = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(203535);
    }
    
    public final void xv(int paramInt)
    {
      AppMethodBeat.i(203537);
      Log.i("MicroMsg.SnsCommentDetailUI", "the detail new video player updateTime called, playTimeMs = ".concat(String.valueOf(paramInt)));
      if ((SnsCommentDetailUI.e(SnsCommentDetailUI.this) == null) || (this.DsC == null) || (this.Ewt == null))
      {
        Log.w("MicroMsg.SnsCommentDetailUI", "the snsAdStatistic or snsInfo is null in updateTime!!!");
        AppMethodBeat.o(203537);
        return;
      }
      SnsCommentDetailUI.e(SnsCommentDetailUI.this).IT(this.DsC.field_snsId);
      SnsCommentDetailUI.e(SnsCommentDetailUI.this).ao(this.DsC.field_snsId, paramInt);
      if (!SnsCommentDetailUI.e(SnsCommentDetailUI.this).IQ(this.DsC.field_snsId))
      {
        paramInt = this.Ewt.getDurationMs() / 1000;
        Log.i("MicroMsg.SnsCommentDetailUI", "updatePlayStartTime, duration=".concat(String.valueOf(paramInt)));
        SnsCommentDetailUI.e(SnsCommentDetailUI.this).c(this.DsC.field_snsId, Util.currentTicks(), false);
        SnsCommentDetailUI.e(SnsCommentDetailUI.this).e(this.DsC.field_snsId, paramInt, false);
        SnsCommentDetailUI.e(SnsCommentDetailUI.this).an(this.DsC.field_snsId, this.DsC.field_snsId);
      }
      AppMethodBeat.o(203537);
    }
  }
  
  final class d
    implements Runnable
  {
    private int ECI = -1;
    private int ECJ = 10;
    int UZ = -1;
    int kn;
    private int offset = 0;
    
    d() {}
    
    public final void run()
    {
      AppMethodBeat.i(98589);
      this.ECJ = 10;
      SnsCommentDetailUI.b(SnsCommentDetailUI.this);
      this.ECI = SnsCommentDetailUI.c(SnsCommentDetailUI.this).getTop();
      int i = this.ECI - this.kn;
      Log.i("MicroMsg.SnsCommentDetailUI", "list.bottom: %d, listOriginalBottom: %d, footerTop: %d, commentFooter.getTop: %d, topSelection: %d", new Object[] { Integer.valueOf(SnsCommentDetailUI.a(SnsCommentDetailUI.this).getBottom()), Integer.valueOf(SnsCommentDetailUI.d(SnsCommentDetailUI.this)), Integer.valueOf(this.ECI), Integer.valueOf(SnsCommentDetailUI.c(SnsCommentDetailUI.this).getTop()), Integer.valueOf(i) });
      if (i == this.offset)
      {
        SnsCommentDetailUI.a(SnsCommentDetailUI.this).setSelectionFromTop(SnsCommentDetailUI.a(SnsCommentDetailUI.this).getHeaderViewsCount() + this.UZ, i);
        this.ECJ = 0;
        this.offset = 0;
        AppMethodBeat.o(98589);
        return;
      }
      int j = this.ECJ;
      this.ECJ = (j - 1);
      if (j > 0)
      {
        new MMHandler().postDelayed(this, 100L);
        this.offset = i;
        AppMethodBeat.o(98589);
        return;
      }
      this.offset = 0;
      this.ECJ = 0;
      AppMethodBeat.o(98589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI
 * JD-Core Version:    0.7.0.1
 */