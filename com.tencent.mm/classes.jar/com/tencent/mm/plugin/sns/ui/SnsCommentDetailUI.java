package com.tencent.mm.plugin.sns.ui;

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
import android.os.Looper;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
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
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Guideline;
import androidx.e.a.b.b;
import com.tencent.d.a.a.a.b.b.k;
import com.tencent.d.a.a.a.b.b.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.abi;
import com.tencent.mm.autogen.a.kh;
import com.tencent.mm.autogen.a.ki;
import com.tencent.mm.autogen.a.ow;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.autogen.a.ul;
import com.tencent.mm.autogen.a.xx;
import com.tencent.mm.autogen.a.zh;
import com.tencent.mm.autogen.a.zj;
import com.tencent.mm.autogen.a.zk;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.MomentsTogetherTailActionStruct;
import com.tencent.mm.autogen.mmdata.rpt.ni;
import com.tencent.mm.autogen.mmdata.rpt.od;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.findersdk.a.ad;
import com.tencent.mm.plugin.findersdk.a.bq;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.c.k.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.data.u.a;
import com.tencent.mm.plugin.sns.j.a.a;
import com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.av.b;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.plugin.sns.ui.widget.Tiger2022Helper;
import com.tencent.mm.plugin.story.api.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.span.x;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.dll;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.epj;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.protocal.protobuf.feb;
import com.tencent.mm.protocal.protobuf.fez;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.protocal.protobuf.gfh;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.gom;
import com.tencent.mm.protocal.protobuf.jz;
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
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.ag;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.y;
import com.tencent.mm.view.e.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@com.tencent.mm.kernel.k
public class SnsCommentDetailUI
  extends MMSecDataActivity
  implements com.tencent.mm.am.h, k.a, com.tencent.mm.plugin.sns.model.c.b, ae
{
  private static com.tencent.mm.loader.b.d<String, Bitmap> Eys;
  public static int RoW;
  private static com.tencent.mm.modelimage.loader.a.c Rpu;
  private static com.tencent.mm.modelimage.loader.a.c Rpv;
  private IListener Akp;
  private int Gix;
  private boolean LXq;
  private com.tencent.mm.plugin.sns.ui.listener.c PZr;
  private LinearLayout Qqi;
  private boolean Qun;
  private boolean Qup;
  private SnsCommentFooter RbA;
  private be RbC;
  private b RbI;
  private com.tencent.mm.plugin.sns.i.b RbJ;
  private as RbK;
  private by RbL;
  private com.tencent.mm.ui.base.w RbN;
  private IListener RbP;
  private boolean Rbx;
  private View.OnTouchListener Rdy;
  private volatile boolean Rlo;
  private ScreenShotUtil.ScreenShotCallback Rmk;
  private View RoA;
  private b RoB;
  private ScaleAnimation RoC;
  private ScaleAnimation RoD;
  LinearLayout RoE;
  LinearLayout RoF;
  private LinkedList<fdv> RoG;
  private int RoH;
  private boolean RoI;
  private bh RoJ;
  private String RoK;
  private bx RoL;
  private ImageView RoM;
  private WeImageView RoN;
  private j RoO;
  private l RoP;
  private boolean RoQ;
  private long RoR;
  private bv RoS;
  private boolean RoT;
  private int RoU;
  private int RoV;
  public int RoX;
  private com.tencent.mm.plugin.sns.ui.c.a.b RoY;
  public com.tencent.mm.plugin.sns.ad.g.l RoZ;
  private long Ros;
  private long Rot;
  private View Rou;
  private TextView Rov;
  private LinearLayout Row;
  private SnsDetailLuckyHeader Rox;
  private ListView Roy;
  private View Roz;
  boolean RpA;
  private LinearLayout RpB;
  private boolean RpC;
  PhotosContent RpD;
  int RpE;
  public az.b.a RpF;
  private bu RpG;
  private SnsTranslateResultView Rpa;
  private boolean Rpb;
  private Dialog Rpc;
  private boolean Rpd;
  private boolean Rpe;
  private String Rpf;
  private boolean Rpg;
  private int Rph;
  private boolean Rpi;
  private int Rpj;
  private n Rpk;
  private TextView Rpl;
  private com.tencent.mm.ui.blur.f Rpm;
  private boolean Rpn;
  private boolean Rpo;
  private am Rpp;
  private IListener Rpq;
  private IListener Rpr;
  private IListener Rps;
  private IListener Rpt;
  private d Rpw;
  private View.OnClickListener Rpx;
  private IListener Rpy;
  private IListener Rpz;
  private gom akiL;
  private String hQX;
  private String ltf;
  private final com.tencent.mm.pluginsdk.ui.span.a mAdTagClickCallback;
  private int mScreenHeight;
  private int mScreenWidth;
  private String musicId;
  private IListener rDF;
  private boolean sfu;
  private com.tencent.mm.ui.widget.b.a vEV;
  private View.OnClickListener vFU;
  private int vhG;
  private int viewType;
  private View.OnClickListener xxi;
  
  static
  {
    AppMethodBeat.i(163117);
    RoW = 34;
    c.a locala = new c.a();
    locala.oKp = true;
    locala.oKn = true;
    Rpu = locala.bKx();
    Eys = new com.tencent.mm.loader.b.c()
    {
      public final com.tencent.mm.loader.d.c.a<Bitmap> blz()
      {
        AppMethodBeat.i(163115);
        com.tencent.mm.loader.d.c.a locala = new com.tencent.mm.loader.d.c.a(new com.tencent.mm.loader.d.c.c(0.5F).blN());
        AppMethodBeat.o(163115);
        return locala;
      }
    };
    locala = new c.a();
    locala.oKp = true;
    locala.oKn = true;
    Rpv = locala.bKx();
    AppMethodBeat.o(163117);
  }
  
  public SnsCommentDetailUI()
  {
    AppMethodBeat.i(98590);
    this.Ros = 0L;
    this.Rot = 0L;
    this.RoH = -1;
    this.RoI = false;
    this.Rdy = Util.genLinearPressedListener();
    this.RbN = null;
    this.vhG = 0;
    this.Gix = 0;
    this.sfu = false;
    this.musicId = "";
    this.RoQ = false;
    this.RoR = 0L;
    this.RoT = false;
    this.RoV = 103;
    this.RoX = 210;
    this.Rpb = false;
    this.Rpc = null;
    this.Rpd = false;
    this.Rpe = false;
    this.Rpf = "";
    this.Rpg = true;
    this.Rpi = false;
    this.Rpj = 0;
    this.Qun = false;
    this.Qup = false;
    this.Rpk = null;
    this.Rpl = null;
    this.Rlo = false;
    this.Rpm = null;
    this.Rpo = false;
    this.Rpp = new am();
    this.Rpq = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Rpr = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Rps = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Rpt = new IListener(com.tencent.mm.app.f.hfK) {};
    this.RbP = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Rpw = new d();
    this.vFU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(98579);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
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
                  paramAnonymousView = t.lY((String)localObject1, ((ADInfo)localObject3).uxInfo);
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
                com.tencent.mm.plugin.sns.d.a.pFn.h((Intent)localObject1, SnsCommentDetailUI.this);
                t.a(localSnsAdClick);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98579);
                return;
              }
              localObject2 = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
              ((com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject2).put("ext_sns_ad_click", localSnsAdClick);
              Object localObject3 = com.tencent.mm.plugin.sns.ad.timeline.a.a.f(1, SnsCommentDetailUI.this);
              if ((localObject3 != null) && (((com.tencent.mm.plugin.sns.ad.timeline.a.c)localObject3).a(paramAnonymousView, SnsCommentDetailUI.this.getSource(), localSnsInfo, (com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject2)))
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98579);
                return;
              }
            }
          }
          t.a(localSnsAdClick);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_User", (String)localObject1);
          paramAnonymousView.putExtra("Contact_Scene", 37);
          com.tencent.mm.plugin.sns.d.a.pFn.c(paramAnonymousView, SnsCommentDetailUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98579);
          return;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Contact_User", (String)localObject1);
        com.tencent.mm.plugin.sns.d.a.pFn.c(paramAnonymousView, SnsCommentDetailUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98579);
      }
    };
    this.Rpx = new SnsCommentDetailUI.51(this);
    this.xxi = new SnsCommentDetailUI.9(this);
    this.Rpy = new SnsCommentDetailUI.18(this, com.tencent.mm.app.f.hfK);
    this.rDF = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Akp = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Rpz = new SnsCommentDetailUI.21(this, com.tencent.mm.app.f.hfK);
    this.Rmk = new ScreenShotUtil.ScreenShotCallback()
    {
      public final void onScreenShot(String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(308254);
        Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onScreenShot， path = " + paramAnonymousString + "， dateAdded = " + paramAnonymousLong);
        SnsCommentDetailUI.y(SnsCommentDetailUI.this);
        AppMethodBeat.o(308254);
      }
    };
    this.RpA = false;
    this.RpB = null;
    this.RpC = false;
    this.RpD = null;
    this.RpE = 0;
    this.RpF = new az.b.a()
    {
      public final void getContactCallBack(final String paramAnonymousString, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(307793);
        Log.i("MicroMsg.SnsCommentDetailUI", "setAvatar, getContactCallBack, userName=" + paramAnonymousString + ", succ=" + paramAnonymousBoolean + ", retryCount=" + SnsCommentDetailUI.this.RpE);
        new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(163103);
            if ((paramAnonymousBoolean) && (!SnsCommentDetailUI.this.isFinishing()) && (SnsCommentDetailUI.this.RpE < 5))
            {
              Log.i("MicroMsg.SnsCommentDetailUI", "setAvatar, setHeader after getContact, userName=" + paramAnonymousString);
              SnsCommentDetailUI.this.hoq();
            }
            SnsCommentDetailUI localSnsCommentDetailUI = SnsCommentDetailUI.this;
            localSnsCommentDetailUI.RpE += 1;
            AppMethodBeat.o(163103);
          }
        }, 500L);
        AppMethodBeat.o(307793);
      }
    };
    this.RpG = null;
    this.mAdTagClickCallback = new com.tencent.mm.pluginsdk.ui.span.a()
    {
      public final void lG(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(307807);
        try
        {
          SnsInfo localSnsInfo = SnsCommentDetailUI.a(SnsCommentDetailUI.this, false);
          if (localSnsInfo != null)
          {
            Log.i("AdTagClickableHelper", "In SnsCommentDetailUI, snsId = " + localSnsInfo.field_snsId + ", source = " + SnsCommentDetailUI.this.getSource() + ", clickPos = " + paramAnonymousInt2);
            com.tencent.mm.plugin.sns.ad.timeline.helper.c.a(SnsCommentDetailUI.this, SnsCommentDetailUI.this.getSource(), localSnsInfo, paramAnonymousInt2);
            AppMethodBeat.o(307807);
            return;
          }
          Log.e("AdTagClickableHelper", "In SnsCommentDetailUI, snsInfo is null");
          AppMethodBeat.o(307807);
          return;
        }
        finally
        {
          Log.e("AdTagClickableHelper", localObject.toString());
          AppMethodBeat.o(307807);
        }
      }
    };
    AppMethodBeat.o(98590);
  }
  
  private boolean D(List<fdv> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(98608);
    int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 32.0F);
    int m = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 6.0F);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 10.0F);
    int j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 17.0F);
    if (this.Row == null)
    {
      AppMethodBeat.o(98608);
      return false;
    }
    int n = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    float f = getResources().getDimension(com.tencent.mm.plugin.sns.b.d.NormalPadding);
    Log.d("MicroMsg.SnsCommentDetailUI", "guess size %d %f", new Object[] { Integer.valueOf(n), Float.valueOf(f) });
    f = n - f * 2.0F;
    if (paramList.size() <= 0)
    {
      if (this.Row.getParent() != null) {
        this.Row.setVisibility(8);
      }
      this.Row.removeAllViews();
      this.Row.setVisibility(8);
      this.Qqi.setVisibility(8);
      AppMethodBeat.o(98608);
      return false;
    }
    this.Row.getParent();
    this.Row.removeAllViews();
    this.Row.setVisibility(0);
    Object localObject1;
    Object localObject2;
    if (this.viewType == 10) {
      if (!this.Rpb)
      {
        this.Row.setBackgroundResource(b.e.friendactivity_comment_detail_list_golden_arror);
        this.Row.setPadding(0, m, 0, m);
        localObject1 = new ImageView(getContext());
        localObject2 = Eh(true);
        if (this.viewType != 10) {
          break label739;
        }
        ((ImageView)localObject1).setImageResource(b.i.friendactivity_likeicon_golden);
      }
    }
    for (;;)
    {
      Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject3).gravity = 49;
      if ((localObject2 == null) || (!((SnsInfo)localObject2).isSocialAttitudeAd()))
      {
        ((ImageView)localObject1).setPadding(i, j, i, 0);
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      }
      ((ImageView)localObject1).setClickable(false);
      ((ImageView)localObject1).setFocusable(false);
      this.Row.addView((View)localObject1);
      n = com.tencent.mm.cd.a.fromDPToPix(getContext(), RoW);
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
        localObject2 = (fdv)paramList.get(i);
        localObject3 = new StoryTouchImageView(getContext());
        ((StoryTouchImageView)localObject3).setContentDescription(String.format(getString(com.tencent.mm.plugin.sns.b.j.shake_avatar), new Object[] { ((fdv)localObject2).Nickname }));
        ((StoryTouchImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_XY);
        ((StoryTouchImageView)localObject3).setImageResource(b.e.friendactivity_personalportrait);
        Object localObject4 = ((fdv)localObject2).Username;
        ((StoryTouchImageView)localObject3).REW.hj((String)localObject4, 1);
        localObject4 = new LinearLayout.LayoutParams(k, k);
        ((LinearLayout.LayoutParams)localObject4).setMargins(0, m, m, 0);
        ((StoryTouchImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((StoryTouchImageView)localObject3).setTag(((fdv)localObject2).Username);
        com.tencent.mm.pluginsdk.ui.a.b.C((ImageView)localObject3, ((fdv)localObject2).Username);
        ((StoryTouchImageView)localObject3).setOnClickListener(this.vFU);
        ((h)localObject1).addView((View)localObject3);
        i += 1;
      }
      localObject1 = Eh(false);
      if (localObject1 != null)
      {
        if (this.ltf.equals(((SnsInfo)localObject1).getUserName()))
        {
          this.Row.setBackgroundResource(b.e.friendactivity_comment_detail_list_golden_myself);
          break;
        }
        this.Row.setBackgroundResource(b.e.friendactivity_comment_detail_list_golden_arror);
        break;
      }
      this.Row.setBackgroundResource(b.e.friendactivity_comment_detail_list_golden_arror);
      break;
      this.Row.setBackgroundResource(b.e.friendactivity_comment_list_normal);
      break;
      label739:
      if ((localObject2 != null) && (((SnsInfo)localObject2).isSocialAttitudeAd())) {
        com.tencent.mm.plugin.sns.ad.j.a.a(((SnsInfo)localObject2).getAdXml().adSocialInfo.QYg, new SnsCommentDetailUI.c((ImageView)localObject1));
      } else {
        ((ImageView)localObject1).setImageDrawable(bb.m(getContext(), b.i.friendactivity_likeicon, getContext().getResources().getColor(b.c.Link)));
      }
    }
    this.Row.addView((View)localObject1);
    paramList = this.Qqi;
    if (paramBoolean) {}
    for (i = 8;; i = 0)
    {
      paramList.setVisibility(i);
      AppMethodBeat.o(98608);
      return true;
    }
  }
  
  private void Eg(boolean paramBoolean)
  {
    AppMethodBeat.i(98592);
    this.RoI = false;
    if (this.RbA.how())
    {
      this.RbA.Rqx = 0;
      this.RbA.hoz();
      this.RbA.setCommentHint(getString(com.tencent.mm.plugin.sns.b.j.sns_ui_comment));
    }
    this.RbA.wh(false);
    if (paramBoolean)
    {
      Object localObject1 = this.Roy;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "scrollDown", "(Z)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
      BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "scrollDown", "(Z)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    }
    AppMethodBeat.o(98592);
  }
  
  private SnsInfo Eh(boolean paramBoolean)
  {
    AppMethodBeat.i(98593);
    SnsInfo localSnsInfo;
    if (!Util.isNullOrNil(this.RoK))
    {
      localSnsInfo = com.tencent.mm.plugin.sns.storage.l.aZL(this.RoK);
      if (localSnsInfo == null)
      {
        if (paramBoolean) {
          Toast.makeText(this, com.tencent.mm.plugin.sns.b.j.sns_msg_not_found, 0).show();
        }
        finish();
        AppMethodBeat.o(98593);
        return null;
      }
      this.hQX = localSnsInfo.getSnsId();
    }
    for (;;)
    {
      AppMethodBeat.o(98593);
      return localSnsInfo;
      localSnsInfo = com.tencent.mm.plugin.sns.storage.l.aZK(this.hQX);
      if (localSnsInfo == null)
      {
        finish();
        AppMethodBeat.o(98593);
        return null;
      }
      this.RoK = localSnsInfo.getLocalid();
    }
  }
  
  private boolean Z(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(307848);
    if ((paramSnsInfo != null) && (paramSnsInfo.getAdSnsInfo() != null))
    {
      paramSnsInfo = paramSnsInfo.getAdSnsInfo().getRemindInfoGroup();
      if (paramSnsInfo != null)
      {
        if (getSource() == 2)
        {
          boolean bool = a(paramSnsInfo.YFa);
          AppMethodBeat.o(307848);
          return bool;
        }
        if ((a(paramSnsInfo.YEZ)) || (a(paramSnsInfo.YFa)))
        {
          AppMethodBeat.o(307848);
          return true;
        }
        AppMethodBeat.o(307848);
        return false;
      }
    }
    Log.w("MicroMsg.SnsCommentDetailUI", "isAtInfoValid called obj is null!");
    AppMethodBeat.o(307848);
    return false;
  }
  
  private static void a(SnsInfo paramSnsInfo, PhotosContent paramPhotosContent, int paramInt)
  {
    AppMethodBeat.i(307890);
    if ((paramSnsInfo != null) && (paramSnsInfo.isAd()) && (paramInt == 2))
    {
      FrameLayout.LayoutParams localLayoutParams = null;
      try
      {
        paramSnsInfo = paramSnsInfo.getAdXml();
        if ((paramSnsInfo != null) && (paramSnsInfo.isShowPlayIconOnCover()))
        {
          paramSnsInfo = paramPhotosContent.findViewById(b.f.status_icon);
          if (paramSnsInfo == null) {}
        }
        int i;
        int j;
        if (paramPhotosContent == null) {
          break label182;
        }
      }
      finally
      {
        try
        {
          paramSnsInfo.setVisibility(0);
          paramPhotosContent = (FrameLayout.LayoutParams)paramPhotosContent.alP(0).getLayoutParams();
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
          AppMethodBeat.o(307890);
          return;
        }
        finally
        {
          for (;;)
          {
            paramPhotosContent = paramSnsInfo;
            paramSnsInfo = localObject;
          }
        }
        paramSnsInfo = finally;
        paramPhotosContent = localLayoutParams;
      }
      paramPhotosContent.setVisibility(8);
      label182:
      Log.e("MicroMsg.SnsCommentDetailUI", "checkShowStatusIcon exp=" + paramSnsInfo.toString());
    }
    else
    {
      AppMethodBeat.o(307890);
      return;
    }
  }
  
  private void a(PhotosContent paramPhotosContent)
  {
    AppMethodBeat.i(307865);
    if (paramPhotosContent == null)
    {
      AppMethodBeat.o(307865);
      return;
    }
    try
    {
      ImageView localImageView = new ImageView(getContext());
      int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
      int j = com.tencent.mm.cd.a.fromDPToPix(getContext(), 4);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
      localLayoutParams.leftMargin = j;
      localLayoutParams.topMargin = j;
      localImageView.setImageDrawable(com.tencent.mm.cd.a.m(getContext(), b.e.we_app_icon));
      localImageView.setLayoutParams(localLayoutParams);
      paramPhotosContent.addView(localImageView);
      AppMethodBeat.o(307865);
      return;
    }
    finally
    {
      Log.e("MicroMsg.SnsCommentDetailUI", paramPhotosContent.toString());
      AppMethodBeat.o(307865);
    }
  }
  
  private void a(PhotosContent paramPhotosContent, int paramInt)
  {
    AppMethodBeat.i(307870);
    if ((paramPhotosContent == null) || (paramInt <= 1))
    {
      Log.e("MicroMsg.SnsCommentDetailUI", "photosContent == null or imgNums <= 1");
      AppMethodBeat.o(307870);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = com.tencent.mm.cd.a.fromDPToPix(getContext(), 20);
        i = 0;
        if (i < paramInt) {
          if (paramPhotosContent.alP(i).getVisibility() == 8)
          {
            Log.i("MicroMsg.SnsCommentDetailUI", "current index " + i + " imageView is a placeholder, so visibility is gone");
          }
          else
          {
            ImageView localImageView = com.tencent.mm.plugin.sns.ad.timeline.helper.d.a(getContext(), paramPhotosContent, i, j);
            if (localImageView != null) {
              paramPhotosContent.addView(localImageView);
            }
          }
        }
      }
      finally
      {
        Log.e("MicroMsg.SnsCommentDetailUI", paramPhotosContent.toString());
        AppMethodBeat.o(307870);
        return;
      }
      AppMethodBeat.o(307870);
      return;
      i += 1;
    }
  }
  
  private static void a(SnsObject paramSnsObject, SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(307863);
    if (((paramSnsObject.ExtFlag & 0x20) > 0) || ((paramSnsObject.ExtFlag & 0x40) > 0)) {
      paramSnsInfo.setLocalPrivate();
    }
    AppMethodBeat.o(307863);
  }
  
  private static boolean a(epj paramepj)
  {
    AppMethodBeat.i(307854);
    if (paramepj == null)
    {
      Log.w("MicroMsg.SnsCommentDetailUI", "isRemindInfoValid called with: remindInfo = [null]");
      AppMethodBeat.o(307854);
      return false;
    }
    if ((paramepj.abty == 0) && (paramepj.abtD == 0L))
    {
      Log.w("MicroMsg.SnsCommentDetailUI", "isRemindInfoValid called with: remindInfo.ADGroupId = [" + paramepj.abty + "] remindInfo.ADGroupId64 = [" + paramepj.abtD + "]");
      AppMethodBeat.o(307854);
      return false;
    }
    gol localgol = paramepj.abtB;
    if ((localgol == null) || (!localgol.aklm))
    {
      Log.w("MicroMsg.SnsCommentDetailUI", "isRemindInfoValid called with: paidInfo is blank!");
      AppMethodBeat.o(307854);
      return false;
    }
    paramepj = paramepj.abtC;
    if ((paramepj == null) || (!paramepj.aklm))
    {
      Log.w("MicroMsg.SnsCommentDetailUI", "isRemindInfoValid called with: extraInfo is blank!");
      AppMethodBeat.o(307854);
      return false;
    }
    AppMethodBeat.o(307854);
    return true;
  }
  
  private LinearLayout alY(int paramInt)
  {
    AppMethodBeat.i(98601);
    if (this.RpB == null)
    {
      this.RpB = ((LinearLayout)af.mU(this).inflate(paramInt, null));
      localLinearLayout = this.RpB;
      AppMethodBeat.o(98601);
      return localLinearLayout;
    }
    this.RpA = true;
    LinearLayout localLinearLayout = this.RpB;
    AppMethodBeat.o(98601);
    return localLinearLayout;
  }
  
  private void f(SnsInfo paramSnsInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(98603);
    Object localObject;
    if (this.Rpl == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      this.Rpl = new TextView(this);
      this.Rpl.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.Rpl.setText(getString(com.tencent.mm.plugin.sns.b.j.sns_detail_private_link_tip));
      this.Rpl.setTextColor(getResources().getColor(b.c.normal_text_color));
      this.Rpl.setGravity(17);
      this.Rpl.setPadding(0, BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 7.0F), 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 12.0F));
      this.Rpl.setVisibility(8);
      this.Roy.addFooterView(this.Rpl);
    }
    if (paramSnsInfo != null)
    {
      localObject = ap.D(paramSnsInfo);
      if (localObject != null) {
        a((SnsObject)localObject, paramSnsInfo);
      }
      if ((paramSnsInfo.getLocalPrivate() & 0x1) != 0)
      {
        findViewById(b.f.comment_footer).setVisibility(8);
        paramSnsInfo = paramSnsInfo.getTimeLine();
        if (paramSnsInfo != null) {
          switch (paramSnsInfo.ContentObj.Zpq)
          {
          }
        }
        for (;;)
        {
          if (((((SnsObject)localObject).ExtFlag & 0x20) > 0) || ((((SnsObject)localObject).ExtFlag & 0x40) > 0)) {
            this.Rpl.setText(com.tencent.mm.plugin.sns.b.j.sns_detail_invisiable_text_tip);
          }
          this.Rpl.setVisibility(0);
          AppMethodBeat.o(98603);
          return;
          this.Rpl.setText(getString(com.tencent.mm.plugin.sns.b.j.sns_detail_private_photo_tip));
          continue;
          this.Rpl.setText(getString(com.tencent.mm.plugin.sns.b.j.sns_detail_private_video_tip));
          continue;
          this.Rpl.setText(getString(com.tencent.mm.plugin.sns.b.j.sns_detail_private_text_tip));
        }
      }
      if (paramBoolean) {
        findViewById(b.f.comment_footer).setVisibility(0);
      }
      this.Rpl.setVisibility(8);
    }
    AppMethodBeat.o(98603);
  }
  
  private static boolean h(LinkedList<fdv> paramLinkedList1, LinkedList<fdv> paramLinkedList2)
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
      if (!((fdv)paramLinkedList1.get(i)).Username.equals(((fdv)paramLinkedList2.get(i)).Username))
      {
        AppMethodBeat.o(98591);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(98591);
    return true;
  }
  
  private int hoo()
  {
    AppMethodBeat.i(98600);
    if ((this.Roy != null) && (this.Roy.getChildCount() > 1))
    {
      View localView = this.Roy.getChildAt(0);
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
  
  private static boolean hop()
  {
    AppMethodBeat.i(98602);
    if ((ar.a.hhj() & 0x1) <= 0)
    {
      AppMethodBeat.o(98602);
      return true;
    }
    AppMethodBeat.o(98602);
    return false;
  }
  
  private void hor()
  {
    AppMethodBeat.i(98605);
    if ((this.Roz == null) || (this.Roz.getVisibility() == 8))
    {
      AppMethodBeat.o(98605);
      return;
    }
    this.Roz.startAnimation(this.RoD);
    this.RoD.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(307633);
        Log.d("MicroMsg.SnsCommentDetailUI", "onAnimationEnd");
        if (SnsCommentDetailUI.q(SnsCommentDetailUI.this) != null)
        {
          SnsCommentDetailUI.q(SnsCommentDetailUI.this).clearAnimation();
          SnsCommentDetailUI.q(SnsCommentDetailUI.this).setVisibility(8);
        }
        AppMethodBeat.o(307633);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    AppMethodBeat.o(98605);
  }
  
  private void hos()
  {
    AppMethodBeat.i(98606);
    if ((keyboardState() == 1) || (this.RbA.hox()))
    {
      this.Rpw.run();
      AppMethodBeat.o(98606);
      return;
    }
    this.Rbx = true;
    AppMethodBeat.o(98606);
  }
  
  private void hot()
  {
    AppMethodBeat.i(98607);
    if (this.RoM == null)
    {
      AppMethodBeat.o(98607);
      return;
    }
    this.RoM.setPressed(false);
    if (bv.aUY(this.musicId))
    {
      this.RoM.setImageResource(b.e.music_pauseicon);
      AppMethodBeat.o(98607);
      return;
    }
    this.RoM.setImageResource(b.e.music_playicon);
    AppMethodBeat.o(98607);
  }
  
  private void hou()
  {
    AppMethodBeat.i(307881);
    if (this.RoN == null)
    {
      AppMethodBeat.o(307881);
      return;
    }
    this.RoN.setPressed(false);
    if (bv.aUY(this.musicId))
    {
      this.RoN.setImageResource(b.i.icons_outlined_pause2);
      this.RoN.setContentDescription(getString(com.tencent.mm.plugin.sns.b.j.sns_stop_music));
    }
    for (;;)
    {
      this.RoN.setIconColor(getContext().getResources().getColor(b.c.black_color));
      AppMethodBeat.o(307881);
      return;
      this.RoN.setImageResource(b.i.icons_outlined_play2);
      this.RoN.setContentDescription(getString(com.tencent.mm.plugin.sns.b.j.sns_play_music));
    }
  }
  
  private ADInfo j(SnsInfo paramSnsInfo)
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
  
  public final void EE(String paramString) {}
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, com.tencent.mm.plugin.sns.c.b paramb, boolean paramBoolean2) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.c.b paramb) {}
  
  public final void aXr() {}
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.c.b paramb) {}
  
  public final void g(final LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(308158);
    com.tencent.mm.ui.anim.b.a.a((ImageView)paramLinearLayout.findViewById(b.f.album_like_icon), com.tencent.mm.ui.anim.b.c.adMn, 4.0F, new b.b()
    {
      boolean Rqf = false;
      
      public final void a(androidx.e.a.b paramAnonymousb)
      {
        AppMethodBeat.i(307621);
        paramAnonymousb = paramAnonymousb.bzv;
        int i = paramAnonymousb.indexOf(this);
        if (i >= 0) {
          paramAnonymousb.set(i, null);
        }
        if (paramLinearLayout != null) {
          paramLinearLayout.setPressed(false);
        }
        if (!this.Rqf)
        {
          this.Rqf = true;
          if (SnsCommentDetailUI.q(SnsCommentDetailUI.this) != null)
          {
            SnsCommentDetailUI.q(SnsCommentDetailUI.this).clearAnimation();
            SnsCommentDetailUI.q(SnsCommentDetailUI.this).setVisibility(8);
          }
        }
        AppMethodBeat.o(307621);
      }
    });
    AppMethodBeat.o(308158);
  }
  
  public int getLayoutId()
  {
    return b.g.sns_comment_detail;
  }
  
  public final int getSource()
  {
    if (this.Rph == 16) {
      return 2;
    }
    return 1;
  }
  
  public final as hlE()
  {
    return this.RbK;
  }
  
  public final b hlF()
  {
    return this.RbI;
  }
  
  public final bw hlG()
  {
    return null;
  }
  
  public final by hlH()
  {
    return this.RbL;
  }
  
  final boolean hoq()
  {
    AppMethodBeat.i(98604);
    Log.i("MicroMsg.SnsCommentDetailUI", "setHeader isRequestDetail:%s", new Object[] { Boolean.valueOf(this.Rpo) });
    if (!this.Rpo) {}
    final SnsInfo localSnsInfo;
    for (boolean bool = true;; bool = false)
    {
      localSnsInfo = Eh(bool);
      if (localSnsInfo != null) {
        break;
      }
      AppMethodBeat.o(98604);
      return false;
    }
    Log.i("MicroMsg.SnsCommentDetailUI", "setheader " + this.Rou.toString());
    this.RoU = com.tencent.mm.plugin.sns.model.al.hgP();
    Object localObject8 = localSnsInfo.getTimeLine();
    if (Tiger2022Helper.h((TimeLineObject)localObject8)) {
      this.akiL = ((TimeLineObject)localObject8).ContentObj.akiL;
    }
    com.tencent.mm.plugin.sns.h.a.aXN(((TimeLineObject)localObject8).ContentDesc + " ");
    this.viewType = bn.g(localSnsInfo, false);
    Object localObject5 = (SnsAvatarImageView)this.Rou.findViewById(b.f.album_avatar_iv);
    Object localObject1;
    if ((localObject5 == null) || (localSnsInfo == null))
    {
      localObject1 = new StringBuilder("unknow error ? ");
      if (localObject5 == null)
      {
        bool = true;
        localObject1 = ((StringBuilder)localObject1).append(bool).append(" ");
        if (localSnsInfo != null) {
          break label264;
        }
      }
      label264:
      for (bool = true;; bool = false)
      {
        Log.e("MicroMsg.SnsCommentDetailUI", bool);
        AppMethodBeat.o(98604);
        return false;
        bool = false;
        break;
      }
    }
    ((SnsAvatarImageView)localObject5).setWeakContext(this);
    ((MaskImageButton)localObject5).nsy = localSnsInfo.getLocalid();
    ((SnsAvatarImageView)localObject5).setTag(localSnsInfo.getUserName());
    if ((localSnsInfo.getAdXml() != null) && (localSnsInfo.getAdXml().usePreferedInfo))
    {
      if (Util.isNullOrNil(localSnsInfo.getAdXml().preferAvatar)) {
        break label17385;
      }
      localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.mC("adId", localSnsInfo.getAdXml().preferAvatar);
      ((SnsAvatarImageView)localObject5).setTag(b.f.sns_prefer_avatar_url, localSnsInfo.getAdXml().preferAvatar);
      if (y.ZC((String)localObject1)) {
        if (com.tencent.mm.plugin.sns.ad.timeline.helper.k.hbW())
        {
          com.tencent.mm.plugin.sns.ad.timeline.helper.k.i((ImageView)localObject5, (String)localObject1, 1);
          bool = true;
        }
      }
    }
    label386:
    label649:
    label962:
    label1872:
    label11473:
    label17106:
    label17363:
    for (;;)
    {
      ((SnsAvatarImageView)localObject5).setOnClickListener(this.PZr.RPV);
      Object localObject6 = (TextView)this.Rou.findViewById(b.f.nickname_tv);
      com.tencent.mm.kernel.h.baF();
      Object localObject9 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(localSnsInfo.getUserName());
      Log.i("MicroMsg.SnsCommentDetailUI", "snsinfo username " + localSnsInfo.getUserName() + " " + localSnsInfo.getSnsId() + " " + localSnsInfo.getCreateTime() + ", isAdAndUsePreferedInfo=" + bool);
      if ((localObject9 != null) && (((au)localObject9).aST() == 0) && (!bool))
      {
        Log.i("MicroMsg.SnsCommentDetailUI", "getContact %s", new Object[] { localSnsInfo.getUserName() });
        az.a.bCk().a(localSnsInfo.getUserName(), "", this.RpF);
      }
      int j = 0;
      int i = 0;
      if (localObject9 == null) {}
      Object localObject4;
      int k;
      Object localObject2;
      for (localObject1 = localSnsInfo.getUserName();; localObject2 = ((au)localObject9).aSV())
      {
        localObject1 = Util.nullAs((String)localObject1, "");
        if (!localSnsInfo.isAd()) {
          break label1872;
        }
        localObject4 = localSnsInfo.getAdXml();
        if (localObject4 == null) {
          break label17376;
        }
        if (!((ADXml)localObject4).usePreferedInfo) {
          break label1839;
        }
        localObject4 = ((ADXml)localObject4).preferNickName;
        ((String)localObject4).length();
        if (this.viewType != 10) {
          break label1973;
        }
        k = 3;
        localObject1 = new com.tencent.mm.pluginsdk.ui.span.q(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject4));
        ((com.tencent.mm.pluginsdk.ui.span.q)localObject1).a(new com.tencent.mm.pluginsdk.ui.span.u(new com.tencent.mm.plugin.sns.data.d(localSnsInfo.isAd(), ((au)localObject9).getUsername(), localSnsInfo.getLocalid(), 2), this.RoO, k), (CharSequence)localObject4);
        if ((j >= 0) && (i > j)) {
          ((com.tencent.mm.pluginsdk.ui.span.q)localObject1).setSpan(((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).a(this, ((au)localObject9).aJy(), this.Rpj, b.c.Orange_100), j, i, 33);
        }
        ((TextView)localObject6).setOnTouchListener(new ai());
        ((TextView)localObject6).setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        ((SnsAvatarImageView)localObject5).setContentDescription(String.format(getResources().getString(com.tencent.mm.plugin.sns.b.j.shake_avatar), new Object[] { localObject4 }));
        ((TextView)this.Rou.findViewById(b.f.type_desc_tv)).setText("");
        if (this.RpG == null) {
          this.RpG = new bu(this.Rou, this.RoZ, 1, new com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b()
          {
            public final void hbt()
            {
              AppMethodBeat.i(308079);
              if ((SnsCommentDetailUI.G(SnsCommentDetailUI.this) != null) && (SnsCommentDetailUI.p(SnsCommentDetailUI.this) != null)) {
                SnsCommentDetailUI.G(SnsCommentDetailUI.this).a(SnsCommentDetailUI.p(SnsCommentDetailUI.this));
              }
              AppMethodBeat.o(308079);
            }
            
            public final ViewGroup hbu()
            {
              AppMethodBeat.i(308083);
              ViewGroup localViewGroup;
              if ((SnsCommentDetailUI.p(SnsCommentDetailUI.this) instanceof com.tencent.mm.plugin.sns.ui.c.a.c))
              {
                localViewGroup = (ViewGroup)SnsCommentDetailUI.p(SnsCommentDetailUI.this).contentView.findViewById(b.f.media_container);
                AppMethodBeat.o(308083);
                return localViewGroup;
              }
              if ((SnsCommentDetailUI.p(SnsCommentDetailUI.this) instanceof com.tencent.mm.plugin.sns.ui.c.a.d))
              {
                localViewGroup = (ViewGroup)((com.tencent.mm.plugin.sns.ui.c.a.d)SnsCommentDetailUI.p(SnsCommentDetailUI.this)).RJA.Cxb;
                AppMethodBeat.o(308083);
                return localViewGroup;
              }
              AppMethodBeat.o(308083);
              return null;
            }
          });
        }
        if (!localSnsInfo.isAd()) {
          break label1979;
        }
        this.RpG.R(Long.valueOf(localSnsInfo.field_snsId), new com.tencent.mm.plugin.sns.data.e(this.RpG, 0, this.RoK, localSnsInfo.field_snsId, j(localSnsInfo).viewId));
        this.RpG.a(localSnsInfo, localSnsInfo.getAdXml(), j(localSnsInfo));
        this.RpG.b(this.PZr.RQf, this.PZr.RQv);
        this.RpG.setVisibility(0);
        localObject1 = ((TimeLineObject)localObject8).ContentDesc;
        this.Rov = ((TextView)this.Rou.findViewById(b.f.desc_tv));
        if (this.akiL != null)
        {
          this.Rov.setVisibility(8);
          this.Rou.findViewById(b.f.tiger2022_container).setVisibility(0);
          this.Rov = ((TextView)this.Rou.findViewById(b.f.tiger2022_text));
        }
        localObject5 = new bj(this.hQX, localSnsInfo.getLocalid(), true, false, 2);
        this.Rov.setTag(localObject5);
        this.vEV.c(this.Rov, this.PZr.RPX, this.PZr.RPU);
        if (!Util.isNullOrNil((String)localObject1)) {
          break label1991;
        }
        this.Rov.setVisibility(8);
        localObject1 = (ViewStub)this.Rou.findViewById(b.f.images_keeper_li);
        if (!this.RpC) {
          ((ViewStub)localObject1).setLayoutResource(-1);
        }
        switch (this.viewType)
        {
        case 6: 
        case 7: 
        case 8: 
        case 12: 
        case 14: 
        case 16: 
        case 17: 
        case 22: 
        case 24: 
        default: 
          ((ViewStub)localObject1).setVisibility(8);
          if (((ViewStub)localObject1).getLayoutResource() == -1) {
            break label2552;
          }
          localObject5 = ((ViewStub)localObject1).inflate();
          if (this.RoY != null)
          {
            this.RoY.Qcs = this.Rou;
            this.RoY.t((View)localObject5, this.RoA);
          }
          this.RpC = true;
          k = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
          if (this.viewType == 6) {
            break label3101;
          }
          if ((this.viewType != 2) && (this.viewType != 3) && (this.viewType != 4) && (this.viewType != 5)) {
            break label4782;
          }
          this.RpD = ((PhotosContent)findViewById(b.f.photo_content));
          if (this.RpD == null) {
            break label4739;
          }
          this.RpD.hnc();
          if (this.viewType != 2) {
            break label2562;
          }
          i = 1;
          j = 0;
          while (j < i)
          {
            localObject1 = (TagImageView)this.RpD.findViewById(bh.Rur[j]);
            this.RpD.a((TagImageView)localObject1);
            ((TagImageView)localObject1).setOnClickListener(this.PZr.Rea);
            this.vEV.c((View)localObject1, this.PZr.RQi, this.PZr.RPU);
            j += 1;
          }
          localObject1 = com.tencent.mm.plugin.sns.ad.g.o.PWQ.Cr((String)localObject1);
          if (localObject1 != null) {
            ((SnsAvatarImageView)localObject5).setImageBitmap((Bitmap)localObject1);
          }
          bool = true;
          break label386;
          if (com.tencent.mm.plugin.sns.ad.timeline.helper.k.hbW())
          {
            Log.i("MicroMsg.SnsCommentDetailUI", "detail: download use avatar with cdn, but the statement should not reach!");
            com.tencent.mm.plugin.sns.ad.timeline.helper.k.j((ImageView)localObject5, localSnsInfo.getAdXml().preferAvatar, 1);
            bool = true;
            break label386;
          }
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.a(localSnsInfo.getAdXml().preferAvatar, false, new g.a()
          {
            public final void aWn(String paramAnonymousString)
            {
              AppMethodBeat.i(308054);
              Log.i("MicroMsg.SnsCommentDetailUI", "download img %s", new Object[] { paramAnonymousString });
              String str = (String)this.RpM.getTag(b.f.sns_prefer_avatar_url);
              if ((!Util.isNullOrNil(new String[] { str, paramAnonymousString })) && (paramAnonymousString.equals(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.mC("adId", str))))
              {
                paramAnonymousString = com.tencent.mm.plugin.sns.ad.g.o.PWQ.Cr(paramAnonymousString);
                if (paramAnonymousString != null) {
                  this.RpM.setImageBitmap(paramAnonymousString);
                }
              }
              AppMethodBeat.o(308054);
            }
            
            public final void gZM() {}
            
            public final void gZN()
            {
              AppMethodBeat.i(308052);
              Log.e("MicroMsg.SnsCommentDetailUI", "onDownloadError");
              AppMethodBeat.o(308052);
            }
          });
          bool = true;
          break label386;
          if (!localSnsInfo.getUserName().endsWith("@ad"))
          {
            if (localSnsInfo.isAd()) {}
            for (;;)
            {
              try
              {
                com.tencent.mm.kernel.h.baF();
                localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(localSnsInfo.getUserName());
                if ((localObject1 == null) || (((au)localObject1).aST() == 0)) {
                  continue;
                }
                com.tencent.mm.pluginsdk.ui.a.b.C((ImageView)localObject5, localSnsInfo.getUserName());
                Log.i("MicroMsg.SnsCommentDetailUI", "has contact before setAvatar, userName=" + localSnsInfo.getUserName());
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.SnsCommentDetailUI", "setAvatar exp=" + localException.toString());
                continue;
              }
              ((SnsAvatarImageView)localObject5).hj(localSnsInfo.getUserName(), 2);
              if (Util.isEqual(this.ltf, localSnsInfo.getUserName())) {
                break label17379;
              }
              bool = false;
              break;
              Log.e("MicroMsg.SnsCommentDetailUI", "has no contact before setAvatar, userName=" + localSnsInfo.getUserName());
              continue;
              com.tencent.mm.pluginsdk.ui.a.b.C((ImageView)localObject5, localSnsInfo.getUserName());
            }
          }
          bool = true;
          break label386;
        }
      }
      if ((Util.isNullOrNil((String)localObject2)) && (!Util.isNullOrNil(((ADXml)localObject4).nickname))) {
        localObject2 = ((ADXml)localObject4).nickname;
      }
      label3414:
      label3415:
      label3679:
      label17376:
      for (;;)
      {
        localObject4 = localObject2;
        break;
        label2552:
        label5755:
        label8959:
        Object localObject3;
        if ((localObject9 != null) && (au.bwO(((au)localObject9).getUsername())) && ("3552365301".equals(((au)localObject9).aJy())))
        {
          j = ((String)localObject2).length();
          localObject4 = ((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).cc(((au)localObject9).aJy(), ((au)localObject9).aJx());
          localObject4 = (String)localObject2 + " @" + (String)localObject4;
          i = ((String)localObject4).length();
          break;
          k = 2;
          break label649;
          this.RpG.setVisibility(8);
          break label962;
          this.Rov.setText((String)localObject2 + " ");
          localObject2 = x.iNO();
          ((Bundle)localObject2).putInt("ShareScene", 3);
          ((Bundle)localObject2).putString("ShareSceneId", localSnsInfo.getUserName() + "#" + t.uA(localSnsInfo.field_snsId));
          ((Bundle)localObject2).putLong("CreateTime", localSnsInfo.field_createTime);
          ((Bundle)localObject2).putInt("TimelineEnterSource", 3);
          ((Bundle)localObject2).putInt("SnsContentType", localSnsInfo.field_type);
          if (com.tencent.mm.plugin.sns.ad.timeline.helper.c.ai(localSnsInfo.isAd(), this.viewType)) {
            com.tencent.mm.pluginsdk.ui.span.p.a(this.Rov, this.mAdTagClickCallback, localObject2);
          }
          for (;;)
          {
            this.Rov.setVisibility(0);
            com.tencent.mm.plugin.sns.statistics.j.QFS.hip().aIT();
            localObject2 = com.tencent.mm.plugin.sns.j.a.QCu;
            a.a.a(localSnsInfo, this.Rov);
            break;
            com.tencent.mm.pluginsdk.ui.span.p.a(this.Rov, 2, 2, localObject2);
            this.Rov.setText(com.tencent.mm.plugin.sns.h.a.a(localSnsInfo.field_snsId, this.Rov.getText(), 0));
          }
          ((ViewStub)localObject2).setLayoutResource(b.g.sns_timeline_imagesline_one);
          break label1287;
          ((ViewStub)localObject2).setLayoutResource(b.g.sns_timeline_imagesline1);
          break label1287;
          ((ViewStub)localObject2).setLayoutResource(b.g.sns_timeline_imagesline2);
          break label1287;
          ((ViewStub)localObject2).setLayoutResource(b.g.sns_timeline_imagesline3);
          break label1287;
          ((ViewStub)localObject2).setLayoutResource(b.g.sns_media_sight_item);
          break label1287;
          ((ViewStub)localObject2).setLayoutResource(b.g.sns_hb_reward_item);
          break label1287;
          ((ViewStub)localObject2).setLayoutResource(b.g.sns_finder_media_item);
          break label1287;
          ((ViewStub)localObject2).setLayoutResource(b.g.sns_finder_media_item);
          break label1287;
          ((ViewStub)localObject2).setLayoutResource(b.g.sns_ad_card_layout_item);
          this.RoY = new com.tencent.mm.plugin.sns.ui.c.a.c((TimeLineObject)localObject8, localSnsInfo, this.PZr, this.RoZ);
          break label1287;
          ((ViewStub)localObject2).setLayoutResource(b.g.sns_timeline_turn_media);
          this.RoY = new com.tencent.mm.plugin.sns.ui.c.a.h((TimeLineObject)localObject8, localSnsInfo, this.PZr, this.RoZ);
          break label1287;
          ((ViewStub)localObject2).setLayoutResource(b.g.sns_timeline_ad_full_card_new);
          this.RoY = new com.tencent.mm.plugin.sns.ui.c.a.d(this, this.viewType, (TimeLineObject)localObject8, localSnsInfo, this.PZr, this.RoZ);
          break label1287;
          ((ViewStub)localObject2).setLayoutResource(b.g.sns_timeline_ad_sphere_card);
          this.RoY = new com.tencent.mm.plugin.sns.ui.c.a.f((TimeLineObject)localObject8, localSnsInfo, this.PZr);
          break label1287;
          ((ViewStub)localObject2).setLayoutResource(b.g.sns_media_sight_item);
          this.RoY = new com.tencent.mm.plugin.sns.ui.c.a.a((TimeLineObject)localObject8, localSnsInfo, this.PZr, this.RoZ);
          break label1287;
          ((ViewStub)localObject2).setLayoutResource(b.g.sns_finder_live_time_line_item);
          break label1287;
          ((ViewStub)localObject2).setLayoutResource(b.g.sns_ad_finder_topic_item_content);
          this.RoY = new com.tencent.mm.plugin.sns.ui.c.a.g((TimeLineObject)localObject8, localSnsInfo, this.PZr, this.RoZ);
          break label1287;
          ((ViewStub)localObject2).setLayoutResource(b.g.sns_ad_slide_full_card);
          this.RoY = new com.tencent.mm.plugin.sns.ui.c.a.e((TimeLineObject)localObject8, localSnsInfo, this.PZr, this.RoZ);
          break label1287;
          ((ViewStub)localObject2).setVisibility(8);
          break label1339;
          i = bh.Run[this.viewType];
          break label1442;
          this.RpD.setImageViewWidth(this.RoU);
          localObject2 = new LinkedList();
          float f2;
          float f1;
          Object localObject7;
          if ((localSnsInfo.isAd()) && (this.viewType == 2))
          {
            localObject5 = localSnsInfo.getAdXml();
            this.RpD.alP(0).setScaleType(QImageView.a.afVc);
            if ((localObject5 != null) && (!((ADXml)localObject5).isCardAd()) && (((ADXml)localObject5).adMediaDisplayWidth > 0.0F) && (((ADXml)localObject5).adMediaDisplayHeight > 0.0F))
            {
              f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a(((ADXml)localObject5).adMediaDisplayWidth, 1, ((ADXml)localObject5).adBasicRemWidth, ((ADXml)localObject5).adBasicRootFontSize);
              f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a(((ADXml)localObject5).adMediaDisplayHeight, 1, ((ADXml)localObject5).adBasicRemWidth, ((ADXml)localObject5).adBasicRootFontSize);
              if (((ADXml)localObject5).adMediaDisplayMode != 0) {
                break label4453;
              }
              float f3 = f1;
              f1 = f2;
              if (f2 >= k - com.tencent.mm.cd.a.br(this, com.tencent.mm.plugin.sns.b.d.sns_avatar_size) - com.tencent.mm.cd.a.br(this, com.tencent.mm.plugin.sns.b.d.SmallestPadding) - getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.b.d.NormalPadding) - getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.b.d.NormalPadding))
              {
                f1 = k - com.tencent.mm.cd.a.br(this, com.tencent.mm.plugin.sns.b.d.sns_avatar_size) - com.tencent.mm.cd.a.br(this, com.tencent.mm.plugin.sns.b.d.SmallestPadding) - getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.b.d.NormalPadding) - getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.b.d.NormalPadding);
                f3 = (int)(((ADXml)localObject5).adMediaDisplayHeight * f1 / ((ADXml)localObject5).adMediaDisplayWidth);
              }
              localObject6 = new dnb();
              ((dnb)localObject6).aaUb = f1;
              ((dnb)localObject6).aaUc = f3;
              ((dnb)localObject6).aaUd = (((dnb)localObject6).aaUb * ((dnb)localObject6).aaUc);
              ((LinkedList)localObject2).add(localObject6);
            }
            if ((com.tencent.mm.plugin.sns.data.m.c(localSnsInfo, getSource())) && (!com.tencent.mm.plugin.sns.data.m.v(localSnsInfo))) {
              a(this.RpD);
            }
            if (!Util.isNullOrNil(((ADXml)localObject5).adMediaIconUrl))
            {
              localObject6 = this.RpD;
              localObject7 = this.RpD.alP(0);
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k.b("adId", ((ADXml)localObject5).adMediaIconUrl, new g.a()
              {
                public final void aWn(String paramAnonymousString)
                {
                  AppMethodBeat.i(308076);
                  MaskImageView localMaskImageView = (MaskImageView)this.RpN.findViewById(b.f.media_icon);
                  if (localMaskImageView != null)
                  {
                    localMaskImageView.setVisibility(0);
                    localMaskImageView.setImageBitmap(BitmapUtil.decodeFile(paramAnonymousString));
                    float f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a(this.RpO.adMediaIconWidth, 1, this.RpO.adBasicRemWidth, this.RpO.adBasicRootFontSize);
                    float f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a(this.RpO.adMediaIconHeight, 1, this.RpO.adBasicRemWidth, this.RpO.adBasicRootFontSize);
                    float f3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a(this.RpO.adMediaIconPaddingRight, 1, this.RpO.adBasicRemWidth, this.RpO.adBasicRootFontSize);
                    float f4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a(this.RpO.adMediaIconPaddingBottom, 1, this.RpO.adBasicRemWidth, this.RpO.adBasicRootFontSize);
                    paramAnonymousString = new FrameLayout.LayoutParams((int)f1, (int)f2);
                    paramAnonymousString.setMargins((int)(this.RpP.getRight() - f3 - f1), (int)(this.RpP.getBottom() - f4 - f2), 0, 0);
                    localMaskImageView.setLayoutParams(paramAnonymousString);
                  }
                  AppMethodBeat.o(308076);
                }
                
                public final void gZM() {}
                
                public final void gZN() {}
              });
            }
          }
          this.Rou.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
          {
            boolean RpQ = false;
            
            public final void onViewAttachedToWindow(View paramAnonymousView)
            {
              AppMethodBeat.i(308067);
              Log.i("MicroMsg.SnsCommentDetailUI", "onViewAttachedToWindow infoHeader %s", new Object[] { Boolean.valueOf(this.RpQ) });
              if (!this.RpQ)
              {
                AppMethodBeat.o(308067);
                return;
              }
              this.RpQ = false;
              if (this.RpR == null)
              {
                AppMethodBeat.o(308067);
                return;
              }
              if (localSnsInfo == null)
              {
                AppMethodBeat.o(308067);
                return;
              }
              if (SnsCommentDetailUI.this.RpD == null)
              {
                AppMethodBeat.o(308067);
                return;
              }
              paramAnonymousView = SnsCommentDetailUI.I(SnsCommentDetailUI.this);
              PhotosContent localPhotosContent = SnsCommentDetailUI.this.RpD;
              TimeLineObject localTimeLineObject = this.RpR;
              String str = localSnsInfo.getLocalid();
              SnsCommentDetailUI.G(SnsCommentDetailUI.this);
              paramAnonymousView.a(localPhotosContent, localTimeLineObject, str, SnsCommentDetailUI.this.hashCode(), SnsCommentDetailUI.H(SnsCommentDetailUI.this), -1, localSnsInfo.isSourceExist(32), false, br.adkc, this.RpS, localSnsInfo.getSnsId(), localSnsInfo);
              SnsCommentDetailUI.b(localSnsInfo, SnsCommentDetailUI.this.RpD, SnsCommentDetailUI.H(SnsCommentDetailUI.this));
              AppMethodBeat.o(308067);
            }
            
            public final void onViewDetachedFromWindow(View paramAnonymousView)
            {
              AppMethodBeat.i(308071);
              Log.i("MicroMsg.SnsCommentDetailUI", "onViewDetachedFromWindow infoHeader");
              this.RpQ = true;
              AppMethodBeat.o(308071);
            }
          });
          this.RoJ.a(this.RpD, (TimeLineObject)localObject8, localSnsInfo.getLocalid(), hashCode(), this.viewType, -1, localSnsInfo.isSourceExist(32), false, br.adkc, (List)localObject2, localSnsInfo.getSnsId(), localSnsInfo);
          a(localSnsInfo, this.RpD, this.viewType);
          if ((localSnsInfo.isAd()) && ((this.viewType == 3) || (this.viewType == 4) || (this.viewType == 5)) && (com.tencent.mm.plugin.sns.data.m.c(localSnsInfo, getSource())) && (!com.tencent.mm.plugin.sns.data.m.v(localSnsInfo)))
          {
            i = bh.Run[this.viewType];
            a(this.RpD, i);
          }
          label3191:
          Object localObject10;
          label3558:
          label3820:
          Object localObject11;
          for (;;)
          {
            localObject6 = (TextView)this.Rou.findViewById(b.f.album_address);
            ((TextView)localObject6).setText("");
            if (!localSnsInfo.isAd()) {
              break label15176;
            }
            localObject5 = j(localSnsInfo);
            if (localObject5 == null) {
              break label15166;
            }
            localObject2 = ((ADInfo)localObject5).adActionPOIName;
            localObject5 = ((ADInfo)localObject5).adActionPOILink;
            ((TextView)localObject6).setTag(localSnsInfo.getLocalid());
            if (Util.isNullOrNil((String)localObject2)) {
              break label15166;
            }
            if (!Util.isNullOrNil((String)localObject5)) {
              break label15118;
            }
            ((TextView)localObject6).setVisibility(0);
            ((TextView)localObject6).setText((CharSequence)localObject2);
            ((TextView)localObject6).setClickable(false);
            ((TextView)localObject6).setTextColor(getContext().getResources().getColor(b.c.desc_text_color));
            this.Rou.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(307931);
                SnsCommentDetailUI.e(SnsCommentDetailUI.this).Ds(false);
                AppMethodBeat.o(307931);
              }
            });
            ((TextView)localObject6).setOnClickListener(this.PZr.RQs);
            ((TextView)this.Rou.findViewById(b.f.album_publish_time)).setText(bp.w(getContext(), localSnsInfo.getCreateTime() * 1000L));
            localObject6 = (TextView)this.Rou.findViewById(b.f.album_ad_tail_desc);
            ((TextView)localObject6).setOnClickListener(this.PZr.RQw);
            ((TextView)localObject6).setVisibility(8);
            localObject7 = (TextView)this.Rou.findViewById(b.f.album_ad_at_tail);
            ((TextView)localObject7).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(307930);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
                paramAnonymousView = new SnsAdClick(SnsCommentDetailUI.this.getSource(), 2, localSnsInfo.field_snsId, 24, 0);
                com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, SnsCommentDetailUI.e(SnsCommentDetailUI.this), localSnsInfo, 24);
                t.a(paramAnonymousView);
                localObject = this.lMP.aSV();
                paramAnonymousView = (View)localObject;
                if (localSnsInfo.isAd()) {
                  paramAnonymousView = com.tencent.mm.plugin.sns.ui.widget.g.e(localSnsInfo.getAdXml(), (String)localObject);
                }
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentFlag(1);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentHint(paramAnonymousView);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).wh(true);
                SnsCommentDetailUI.q(SnsCommentDetailUI.this).setVisibility(8);
                SnsCommentDetailUI.r(SnsCommentDetailUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(307930);
              }
            });
            ((TextView)localObject7).setVisibility(8);
            if (localSnsInfo.isAd())
            {
              localObject9 = j(localSnsInfo);
              ((TextView)localObject6).setTag(localSnsInfo.getLocalid());
              if (!com.tencent.mm.plugin.sns.ad.timeline.helper.e.a((ADInfo)localObject9)) {
                break label15394;
              }
              com.tencent.mm.plugin.sns.ad.timeline.helper.e.a((TextView)localObject6, ap.E(localSnsInfo), (ADInfo)localObject9);
              break label15733;
              if ((((TextView)localObject6).getVisibility() != 8) && (Util.isNullOrNil(((ADInfo)localObject9).adActionExtTailLink)))
              {
                ((TextView)localObject6).setTextColor(getResources().getColor(b.c.sns_word_color));
                ((TextView)localObject6).setOnClickListener(null);
              }
              if (com.tencent.mm.plugin.sns.data.m.jP(getContext())) {
                ((TextView)localObject6).setVisibility(8);
              }
              if ((localSnsInfo.getTimeLine().ContentObj.Zps & 0x4) == 0) {
                break label15902;
              }
              ((TextView)localObject7).setTag(localSnsInfo.getLocalid());
              ((TextView)localObject7).setVisibility(0);
              ((TextView)localObject7).setText(String.format("%s%s%s", new Object[] { getContext().getResources().getString(com.tencent.mm.plugin.sns.b.j.sns_ad_at_tips1), localObject4, getContext().getResources().getString(com.tencent.mm.plugin.sns.b.j.sns_ad_at_tips2) }));
            }
            localObject2 = (WeImageView)this.Rou.findViewById(b.f.album_type_icon);
            if (((TimeLineObject)localObject8).ContentObj.Zpq != 30) {
              break label15912;
            }
            i = 0;
            ((WeImageView)localObject2).setVisibility(i);
            ((WeImageView)localObject2).setIconColor(getResources().getColor(b.c.BW_0_Alpha_0_3));
            localObject5 = (TextView)this.Rou.findViewById(b.f.album_from);
            ((TextView)localObject5).setOnTouchListener(new ai());
            localObject4 = com.tencent.mm.plugin.sns.d.a.pFo.x(this, ((TimeLineObject)localObject8).AppInfo.Id);
            if (((TimeLineObject)localObject8).ContentObj.Zpq != 26) {
              break label15919;
            }
            localObject2 = getString(com.tencent.mm.plugin.sns.b.j.favorite);
            bn.a((TimeLineObject)localObject8, this);
            if (!com.tencent.mm.plugin.sns.d.a.pFo.iA((String)localObject2)) {
              break label16625;
            }
            ((TextView)localObject5).setVisibility(0);
            localObject4 = new SpannableString(getString(com.tencent.mm.plugin.sns.b.j.sns_comefrome) + (String)localObject2);
            ((SpannableString)localObject4).setSpan(new a(), 0, ((SpannableString)localObject4).length(), 33);
            ((TextView)localObject5).setText((CharSequence)localObject4, TextView.BufferType.SPANNABLE);
            if ((((TimeLineObject)localObject8).AppInfo == null) || (!com.tencent.mm.pluginsdk.model.app.h.bpK(((TimeLineObject)localObject8).AppInfo.Id)))
            {
              ((TextView)localObject5).setTextColor(getResources().getColor(b.c.sns_word_color));
              ((TextView)localObject5).setOnTouchListener(null);
            }
            ((TextView)localObject5).setTag(localObject8);
            if ((((TimeLineObject)localObject8).ContentObj.Zpq != 1) || (((TimeLineObject)localObject8).ContentObj.DHa == null) || (Util.isNullOrNil((String)localObject2))) {
              break label16635;
            }
            ((TextView)localObject5).setTextColor(getResources().getColor(b.c.sns_link_color));
            ((TextView)localObject5).setOnTouchListener(null);
            ((TextView)localObject5).setTag(localObject8);
            ((TextView)localObject5).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(307605);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
                long l1 = t.aXD(this.RpR.ContentObj.DHa.liveId);
                long l2 = t.aXD(this.RpR.ContentObj.DHa.feedId);
                if ((l1 != 0L) && (l2 != 0L))
                {
                  if (Util.isEqual(com.tencent.mm.model.z.bAW(), this.RpR.ContentObj.DHa.username))
                  {
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("KEY_PARAMS_SOURCE_TYPE", this.RpR.ContentObj.DHa.sourceType);
                    ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).enterFinderLiveAnchorUI(paramAnonymousView, SnsCommentDetailUI.this, l2, Long.valueOf(l1), this.RpR.ContentObj.DHa.objectNonceId, this.RpR.ContentObj.DHa.desc, "", "", "");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(307605);
                    return;
                  }
                  label222:
                  int i;
                  if (this.RpR.UserName == null)
                  {
                    paramAnonymousView = "";
                    com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGq = paramAnonymousView;
                    com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGr = this.RpR.Id;
                    com.tencent.mm.plugin.expt.hellhound.a.aqz("temp_6");
                    paramAnonymousView = (cn)com.tencent.mm.kernel.h.az(cn.class);
                    localObject = this.RpR.ContentObj.DHa.username;
                    if (this.RpR.ContentObj.DHa.liveStatus != 1) {
                      break label483;
                    }
                    i = 1;
                    label284:
                    paramAnonymousView.report21053OnClick(l2, l1, (String)localObject, -1, -1, 7L, "temp_6", i, com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKk(), com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGq, com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGr, System.currentTimeMillis(), 1);
                    localObject = new Intent();
                    ((Intent)localObject).putExtra("key_enter_live_param_visitor_enter_scene", 2);
                    if (this.RpR.ContentObj.DHa.ecSource != null) {
                      break label488;
                    }
                  }
                  label483:
                  label488:
                  for (paramAnonymousView = "";; paramAnonymousView = this.RpR.ContentObj.DHa.ecSource)
                  {
                    ((Intent)localObject).putExtra("key_enter_live_param_ecsource", paramAnonymousView);
                    paramAnonymousView = b.k.ahpq;
                    ((Intent)localObject).putExtra("KEY_ENTER_LIVE_PARAM_LIVE_EVENT_SOURCE", b.k.a.jWn());
                    ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).enterFinderLiveVisitorUI((Intent)localObject, SnsCommentDetailUI.this, l2, Long.valueOf(l1), this.RpR.ContentObj.DHa.username, this.RpR.ContentObj.DHa.objectNonceId, this.RpR.ContentObj.DHa.desc, "", "", "", 4, "", 1, ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().fgH());
                    break;
                    paramAnonymousView = this.RpR.UserName;
                    break label222;
                    i = 2;
                    break label284;
                  }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(307605);
              }
            });
            localObject2 = (TextView)this.Rou.findViewById(b.f.album_del);
            if (!localSnsInfo.getUserName().equals(this.ltf)) {
              break label16727;
            }
            ((TextView)localObject2).setVisibility(0);
            ((TextView)localObject2).setTag(localSnsInfo.getLocalid() + ";" + localSnsInfo.getSnsId());
            ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(307613);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                com.tencent.mm.ui.base.k.a(SnsCommentDetailUI.this, com.tencent.mm.plugin.sns.b.j.sns_timeline_ui_confirm_del, com.tencent.mm.plugin.sns.b.j.app_tip, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(308348);
                    Log.d("MicroMsg.SnsCommentDetailUI", "to del by localId " + SnsCommentDetailUI.j(SnsCommentDetailUI.this));
                    paramAnonymous2DialogInterface = com.tencent.mm.plugin.sns.storage.l.aZL(SnsCommentDetailUI.j(SnsCommentDetailUI.this));
                    if (paramAnonymous2DialogInterface == null)
                    {
                      Log.e("MicroMsg.SnsCommentDetailUI", "try to del item fail can not get snsinfo by localid %s", new Object[] { SnsCommentDetailUI.j(SnsCommentDetailUI.this) });
                      AppMethodBeat.o(308348);
                      return;
                    }
                    if (paramAnonymous2DialogInterface.isAd())
                    {
                      AppMethodBeat.o(308348);
                      return;
                    }
                    Object localObject;
                    if (paramAnonymous2DialogInterface.field_snsId == 0L)
                    {
                      com.tencent.mm.plugin.sns.model.al.hgB().alC(paramAnonymous2DialogInterface.localid);
                      localObject = new Intent();
                      ((Intent)localObject).putExtra("sns_gallery_op_id", com.tencent.mm.plugin.sns.storage.ai.bap(SnsCommentDetailUI.j(SnsCommentDetailUI.this)));
                      SnsCommentDetailUI.this.setResult(-1, (Intent)localObject);
                      if ((SnsCommentDetailUI.z(SnsCommentDetailUI.this)) && (!paramAnonymous2DialogInterface.isValid())) {
                        ((Intent)localObject).putExtra("sns_gallery_force_finish", true);
                      }
                      localObject = paramAnonymous2DialogInterface.getTimeLine();
                      if (localObject != null) {
                        if (((TimeLineObject)localObject).AppInfo != null) {
                          break label363;
                        }
                      }
                    }
                    label363:
                    for (paramAnonymous2DialogInterface = null;; paramAnonymous2DialogInterface = ((TimeLineObject)localObject).AppInfo.Id)
                    {
                      if ((!Util.isNullOrNil(paramAnonymous2DialogInterface)) && (com.tencent.mm.plugin.sns.d.a.pFo.iB(paramAnonymous2DialogInterface)))
                      {
                        String str = com.tencent.mm.plugin.sns.d.a.pFo.iz(paramAnonymous2DialogInterface);
                        ul localul = new ul();
                        localul.hYf.appId = paramAnonymous2DialogInterface;
                        localul.hYf.hYg = ((TimeLineObject)localObject).UserName;
                        localul.hYf.pkgName = str;
                        localul.publish();
                      }
                      SnsCommentDetailUI.this.finish();
                      AppMethodBeat.o(308348);
                      return;
                      com.tencent.mm.plugin.sns.model.al.hgA().uQ(paramAnonymous2DialogInterface.field_snsId);
                      com.tencent.mm.kernel.h.baF();
                      com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.plugin.sns.model.s(paramAnonymous2DialogInterface.field_snsId, 1), 0);
                      com.tencent.mm.plugin.sns.model.al.hgB().delete(paramAnonymous2DialogInterface.field_snsId);
                      com.tencent.mm.plugin.sns.model.al.hgH().vh(paramAnonymous2DialogInterface.field_snsId);
                      com.tencent.mm.plugin.sns.storage.n.vg(paramAnonymous2DialogInterface.field_snsId);
                      break;
                    }
                  }
                }, null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$46", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(307613);
              }
            });
            localObject6 = (TextView)this.Rou.findViewById(b.f.with_info_tv);
            localObject5 = ap.D(localSnsInfo);
            if (localObject5 != null) {
              break label16737;
            }
            ((TextView)localObject6).setVisibility(8);
            this.RoC = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
            this.RoC.setDuration(150L);
            this.RoD = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
            this.RoD.setDuration(150L);
            if (this.Roz == null)
            {
              this.Roz = this.Rou.findViewById(b.f.album_comment_container);
              this.Roz.setVisibility(8);
            }
            this.RoE = ((LinearLayout)this.Rou.findViewById(b.f.album_comment_li));
            this.RoE.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(307609);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$48", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                if (!com.tencent.mm.plugin.sns.lucky.a.m.aXP(localSnsInfo.getLocalid()))
                {
                  com.tencent.mm.plugin.sns.lucky.ui.a.h(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.RpD.alP(0));
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$48", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(307609);
                  return;
                }
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentInfo(null);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentFlag(0);
                paramAnonymousView = localSnsInfo.getTimeLine();
                if ((Tiger2022Helper.h(paramAnonymousView)) && (Tiger2022Helper.kLN()))
                {
                  SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentHint(SnsCommentDetailUI.this.getString(com.tencent.mm.plugin.sns.b.j.sns_tiger2022_comment_hint, new Object[] { Integer.valueOf(Tiger2022Helper.bC(paramAnonymousView.ContentDesc)) }));
                  SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentInfo(new fdv());
                  SnsCommentDetailUI.c(SnsCommentDetailUI.this).setSnsInfo(localSnsInfo);
                  SnsCommentDetailUI.c(SnsCommentDetailUI.this).setToSendTextColor(true);
                  SnsCommentDetailUI.c(SnsCommentDetailUI.this).wh(true);
                  if ((!localSnsInfo.isAd()) || ((localSnsInfo.getTimeLine().ContentObj.Zps & 0x8) == 0)) {
                    break label348;
                  }
                  if (!SnsCommentDetailUI.b(SnsCommentDetailUI.this, localSnsInfo)) {
                    break label334;
                  }
                  SnsCommentDetailUI.c(SnsCommentDetailUI.this).uW(true);
                }
                for (;;)
                {
                  SnsCommentDetailUI.q(SnsCommentDetailUI.this).setVisibility(8);
                  SnsCommentDetailUI.r(SnsCommentDetailUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$48", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(307609);
                  return;
                  SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentHint(SnsCommentDetailUI.this.getString(com.tencent.mm.plugin.sns.b.j.sns_ui_comment));
                  break;
                  label334:
                  SnsCommentDetailUI.c(SnsCommentDetailUI.this).uW(false);
                  continue;
                  label348:
                  SnsCommentDetailUI.c(SnsCommentDetailUI.this).uW(false);
                }
              }
            });
            this.RoE.setOnTouchListener(this.Rdy);
            this.RoF = ((LinearLayout)this.Rou.findViewById(b.f.album_like_img));
            this.RoF.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(307618);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$49", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                if ((SnsCommentDetailUI.e(SnsCommentDetailUI.this) != null) && (localSnsInfo.getLikeFlag() == 0)) {
                  SnsCommentDetailUI.e(SnsCommentDetailUI.this).ur(localSnsInfo.field_snsId);
                }
                SnsCommentDetailUI.this.g((LinearLayout)paramAnonymousView);
                SnsCommentDetailUI.o(SnsCommentDetailUI.this);
                com.tencent.mm.plugin.sns.statistics.j.QFS.hip().jeW = 3L;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$49", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(307618);
              }
            });
            this.RoF.setOnTouchListener(this.Rdy);
            localObject2 = (ImageButton)this.Rou.findViewById(b.f.album_show_comment_tv);
            localObject4 = Eh(true);
            a((SnsObject)localObject5, (SnsInfo)localObject4);
            if ((localObject4 != null) && ((((SnsInfo)localObject4).getLocalPrivate() & 0x1) != 0)) {
              ((ImageButton)localObject2).setVisibility(8);
            }
            if ((localObject4 != null) && (!((SnsInfo)localObject4).isExtFlag())) {
              ((ImageButton)localObject2).setVisibility(8);
            }
            localObject4 = (ImageView)this.RoF.findViewById(b.f.album_like_icon);
            localObject5 = (ImageView)this.RoE.findViewById(b.f.album_comment_icon);
            localObject6 = (TextView)this.RoF.findViewById(b.f.album_like_tv);
            localObject7 = (TextView)this.RoE.findViewById(b.f.album_comment_tv);
            if (this.viewType == 10)
            {
              this.Rou.findViewById(b.f.album_comment_container).setBackgroundResource(b.e.friendactivity_comment_frame_bg_golden);
              ((ImageButton)localObject2).setImageResource(b.e.lucky_friendactivity_comment_icon);
              ((ImageView)localObject4).setImageResource(b.e.lucky_friendactivity_comment_likeicon);
              ((ImageView)localObject5).setImageResource(b.e.lucky_friendactivity_comment_writeicon);
              ((TextView)localObject6).setTextColor(getResources().getColor(b.c.sns_lucky_comment));
              ((TextView)localObject7).setTextColor(getResources().getColor(b.c.sns_lucky_comment));
              this.RoF.setBackgroundResource(b.e.lucky_sns_comment_btn_left);
              this.RoE.setBackgroundResource(b.e.lucky_sns_comment_btn_right);
            }
            ((ImageButton)localObject2).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(307626);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$50", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                Log.d("MicroMsg.SnsCommentDetailUI", "showComment click" + SnsCommentDetailUI.q(SnsCommentDetailUI.this).getVisibility());
                com.tencent.mm.plugin.sns.ad.j.j.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a(localSnsInfo, true, paramAnonymousView, SnsCommentDetailUI.e(SnsCommentDetailUI.this)));
                paramAnonymousView = localSnsInfo.getTimeLine();
                if ((paramAnonymousView != null) && (paramAnonymousView.ContentObj.Zpq == 21) && (!com.tencent.mm.plugin.sns.lucky.a.m.aXP(localSnsInfo.getLocalid())))
                {
                  com.tencent.mm.plugin.sns.lucky.ui.a.h(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.RpD.alP(0));
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$50", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(307626);
                  return;
                }
                if (SnsCommentDetailUI.q(SnsCommentDetailUI.this).getVisibility() == 0) {
                  SnsCommentDetailUI.f(SnsCommentDetailUI.this);
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$50", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(307626);
                  return;
                  SnsCommentDetailUI.q(SnsCommentDetailUI.this).setVisibility(0);
                  SnsCommentDetailUI.q(SnsCommentDetailUI.this).startAnimation(SnsCommentDetailUI.J(SnsCommentDetailUI.this));
                  if (SnsCommentDetailUI.H(SnsCommentDetailUI.this) == 10) {
                    SnsCommentDetailUI.B(SnsCommentDetailUI.this).findViewById(b.f.album_comment_container).setBackgroundResource(b.e.friendactivity_comment_frame_bg_golden);
                  }
                  if (!com.tencent.mm.plugin.sns.storage.ai.baq(SnsCommentDetailUI.m(SnsCommentDetailUI.this)))
                  {
                    SnsCommentDetailUI.this.RoE.setEnabled(false);
                    SnsCommentDetailUI.this.RoF.setEnabled(false);
                    this.Rqb.setText(SnsCommentDetailUI.this.getString(com.tencent.mm.plugin.sns.b.j.sns_like));
                    this.Rqb.setTextColor(SnsCommentDetailUI.this.getResources().getColor(b.c.sns_like_color));
                    this.Rqc.setTextColor(SnsCommentDetailUI.this.getResources().getColor(b.c.sns_like_color));
                    if (SnsCommentDetailUI.H(SnsCommentDetailUI.this) == 10) {
                      this.Rqd.setImageResource(b.i.friendactivity_comment_likeicon_golden_normal);
                    } else {
                      this.Rqd.setImageResource(b.i.friendactivity_comment_likeicon_normal);
                    }
                  }
                  else
                  {
                    SnsCommentDetailUI.this.RoE.setEnabled(true);
                    this.Rqd.setImageResource(b.e.friendactivity_comment_likeicon);
                    SnsCommentDetailUI.this.RoF.setEnabled(true);
                    this.Rqb.setTextColor(SnsCommentDetailUI.this.getResources().getColor(b.c.white_text_color));
                    this.Rqc.setTextColor(SnsCommentDetailUI.this.getResources().getColor(b.c.white_text_color));
                    paramAnonymousView = com.tencent.mm.plugin.sns.storage.l.aZK(SnsCommentDetailUI.m(SnsCommentDetailUI.this));
                    if (SnsCommentDetailUI.H(SnsCommentDetailUI.this) == 10)
                    {
                      this.Rqd.setImageResource(b.e.lucky_friendactivity_comment_likeicon);
                      this.Rqe.setImageResource(b.e.lucky_friendactivity_comment_writeicon);
                      this.Rqb.setTextColor(SnsCommentDetailUI.this.getResources().getColor(b.c.sns_lucky_comment));
                      this.Rqc.setTextColor(SnsCommentDetailUI.this.getResources().getColor(b.c.sns_lucky_comment));
                    }
                    for (;;)
                    {
                      if ((paramAnonymousView == null) || (paramAnonymousView.getLikeFlag() != 0)) {
                        break label626;
                      }
                      this.Rqb.setText(SnsCommentDetailUI.this.getString(com.tencent.mm.plugin.sns.b.j.sns_like));
                      break;
                      this.Rqd.setImageResource(b.e.friendactivity_comment_likeicon);
                      this.Rqb.setTextColor(SnsCommentDetailUI.this.getResources().getColor(b.c.white_text_color));
                      this.Rqc.setTextColor(SnsCommentDetailUI.this.getResources().getColor(b.c.white_text_color));
                    }
                    label626:
                    this.Rqb.setText(SnsCommentDetailUI.this.getString(com.tencent.mm.plugin.sns.b.j.sns_has_liked));
                  }
                }
              }
            });
            AppMethodBeat.o(98604);
            return true;
            label4453:
            if (((ADXml)localObject5).adMediaDisplayMode == 1)
            {
              i = k - com.tencent.mm.cd.a.br(this, com.tencent.mm.plugin.sns.b.d.sns_avatar_size) - com.tencent.mm.cd.a.br(this, com.tencent.mm.plugin.sns.b.d.sns_avatar_size) - com.tencent.mm.cd.a.br(this, com.tencent.mm.plugin.sns.b.d.SmallestPadding) - com.tencent.mm.cd.a.br(this, com.tencent.mm.plugin.sns.b.d.SmallestPadding) - getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.b.d.NormalPadding) - getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.b.d.NormalPadding);
              j = (int)(i * ((ADXml)localObject5).adMediaDisplayHeight / ((ADXml)localObject5).adMediaDisplayWidth);
              localObject6 = new dnb();
              if (i > 0) {
                f2 = i;
              }
              ((dnb)localObject6).aaUb = f2;
              if (j > 0) {
                f1 = j;
              }
              ((dnb)localObject6).aaUc = f1;
              ((dnb)localObject6).aaUd = (((dnb)localObject6).aaUb * ((dnb)localObject6).aaUc);
              ((LinkedList)localObject2).add(localObject6);
              break;
            }
            if (((ADXml)localObject5).adMediaDisplayMode != 2) {
              break;
            }
            i = k - com.tencent.mm.cd.a.br(this, com.tencent.mm.plugin.sns.b.d.sns_avatar_size) - com.tencent.mm.cd.a.br(this, com.tencent.mm.plugin.sns.b.d.SmallestPadding) - getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.b.d.NormalPadding) - getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.b.d.NormalPadding);
            j = (int)(i * ((ADXml)localObject5).adMediaDisplayHeight / ((ADXml)localObject5).adMediaDisplayWidth);
            localObject6 = new dnb();
            if (i > 0) {
              f2 = i;
            }
            ((dnb)localObject6).aaUb = f2;
            if (j > 0) {
              f1 = j;
            }
            ((dnb)localObject6).aaUc = f1;
            ((dnb)localObject6).aaUd = (((dnb)localObject6).aaUb * ((dnb)localObject6).aaUc);
            ((LinkedList)localObject2).add(localObject6);
            break;
            Log.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.viewType + ",stub is " + ((ViewStub)localObject2).toString());
            continue;
            if (this.viewType == 10)
            {
              this.RpD = ((PhotosContent)findViewById(b.f.hb_content_rl));
              this.RpD.hnc();
              localObject2 = (TagImageView)this.RpD.findViewById(b.f.album_img_0);
              this.RpD.a((TagImageView)localObject2);
              ((TagImageView)localObject2).setOnClickListener(this.PZr.Rea);
              localObject5 = localSnsInfo.getLocalid();
              localObject6 = new ArrayList();
              ((List)localObject6).add(localObject2);
              localObject7 = new bf();
              ((bf)localObject7).hHB = ((String)localObject5);
              ((bf)localObject7).index = 0;
              ((bf)localObject7).RrK = ((List)localObject6);
              ((bf)localObject7).Roa = true;
              if (localObject2 != null) {
                ((TagImageView)localObject2).setTag(localObject7);
              }
              localObject2 = (TextView)this.Rou.findViewById(b.f.hb_tip);
              if (!com.tencent.mm.model.z.bAM().equals(((TimeLineObject)localObject8).UserName))
              {
                localObject5 = ap.E(localSnsInfo);
                if ((((SnsObject)localObject5).SnsRedEnvelops != null) && (((SnsObject)localObject5).SnsRedEnvelops.abEF != 0))
                {
                  ((TextView)localObject2).setText(getString(com.tencent.mm.plugin.sns.b.j.lucky_sns_reward_numbers, new Object[] { Integer.valueOf(((SnsObject)localObject5).SnsRedEnvelops.abEF) }));
                  ((TextView)localObject2).setVisibility(0);
                }
              }
              for (;;)
              {
                localObject2 = localSnsInfo.getPostInfo();
                if (localObject2 == null) {
                  break label5293;
                }
                if (!com.tencent.mm.model.z.bAM().equals(((TimeLineObject)localObject8).UserName)) {
                  break label5121;
                }
                localObject2 = this.RoJ;
                localObject5 = this.RpD;
                localObject6 = localSnsInfo.getLocalid();
                i = hashCode();
                j = this.viewType;
                localSnsInfo.isSourceExist(32);
                ((bh)localObject2).a((PhotosContent)localObject5, (TimeLineObject)localObject8, (String)localObject6, i, j, -1, false, br.adkc, true);
                break;
                ((TextView)localObject2).setVisibility(8);
                continue;
                ((TextView)localObject2).setVisibility(8);
              }
              if (com.tencent.mm.plugin.sns.lucky.a.m.y(localSnsInfo))
              {
                localObject2 = this.RoJ;
                localObject5 = this.RpD;
                localObject6 = localSnsInfo.getLocalid();
                i = hashCode();
                j = this.viewType;
                localSnsInfo.isSourceExist(32);
                ((bh)localObject2).a((PhotosContent)localObject5, (TimeLineObject)localObject8, (String)localObject6, i, j, -1, false, br.adkc, false);
              }
              else if (((dna)localObject2).ihz == 0)
              {
                localObject2 = this.RoJ;
                localObject5 = this.RpD;
                localObject6 = localSnsInfo.getLocalid();
                i = hashCode();
                j = this.viewType;
                localSnsInfo.isSourceExist(32);
                ((bh)localObject2).a((PhotosContent)localObject5, (TimeLineObject)localObject8, (String)localObject6, i, j, -1, false, br.adkc, true);
              }
              else
              {
                Log.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo.hbStatus is " + ((dna)localObject2).ihz);
                continue;
                Log.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo is null " + localSnsInfo.getLocalid());
              }
            }
            else if (this.viewType == 19)
            {
              this.Rpd = true;
            }
            else if (this.viewType == 9)
            {
              this.Rpd = true;
              localObject5 = new aw();
              localObject10 = this.Rou;
              localObject6 = ((View)localObject10).findViewById(b.f.chatting_click_area);
              localObject7 = (VideoSightView)((View)localObject10).findViewById(b.f.image);
              ((aw)localObject5).RjL = ((View)localObject10);
              ((aw)localObject5).RjO = ((View)localObject6);
              ((aw)localObject5).PQu = ((ImageView)((View)localObject10).findViewById(b.f.status_btn));
              ((aw)localObject5).RjP = ((MMPinProgressBtn)((View)localObject10).findViewById(b.f.progress));
              ((aw)localObject5).QRC = ((TextView)((View)localObject10).findViewById(b.f.errorTv));
              ((aw)localObject5).RjQ = ((TextView)((View)localObject10).findViewById(b.f.endtv));
              ((aw)localObject5).RjM = ((VideoSightView)localObject7);
              ((aw)localObject5).RjM.setMute(true);
              ((aw)localObject5).a((TimeLineObject)localObject8, 0, localSnsInfo.getLocalid(), localSnsInfo.isAd());
              ((aw)localObject5).QRC.setVisibility(8);
              ((aw)localObject5).RjM.setTagObject(localObject5);
              ((aw)localObject5).RjM.setIsAdVideo(localSnsInfo.isAd());
              ((aw)localObject5).RjS = 5;
              ((View)localObject6).setTag(localObject5);
              ((aw)localObject5).RjO.setOnClickListener(this.PZr.RQt);
              if (!localSnsInfo.isCardAd())
              {
                this.vEV.c((View)localObject6, this.PZr.RQk, this.PZr.RPU);
                if ((!localSnsInfo.isAd()) || (!com.tencent.mm.plugin.sns.data.m.d((TimeLineObject)localObject8))) {
                  break label6169;
                }
                j = 1;
                i = 0;
                if (localSnsInfo != null) {
                  i = localSnsInfo.getAdXml().verticalVideoDisplayType;
                }
                if (i != 1) {
                  break label6150;
                }
                localObject2 = com.tencent.mm.modelsns.o.dV(((aw)localObject5).RjM.getUIContext());
                Log.i("MicroMsg.SnsCommentDetailUI", "isVerticalAdVideo=true, snsId=" + localSnsInfo.field_snsId + ", showW=" + ((Pair)localObject2).first + ", showH=" + ((Pair)localObject2).second);
                i = j;
                if (localObject2 != null)
                {
                  if ((((aw)localObject5).RjM instanceof SightPlayImageView))
                  {
                    if (localSnsInfo.isAd()) {
                      break label6195;
                    }
                    ((aw)localObject5).RjM.setScaleMode(1);
                    ((aw)localObject5).RjM.setScaleType(QImageView.a.afVc);
                  }
                  ((VideoSightView)localObject7).ld(((Integer)((Pair)localObject2).first).intValue(), ((Integer)((Pair)localObject2).second).intValue());
                  if ((((aw)localObject5).RjM instanceof SightPlayImageView))
                  {
                    if (i == 0) {
                      break label6246;
                    }
                    ((aw)localObject5).RjM.gYG();
                  }
                  localObject11 = ((aw)localObject5).RjQ.getLayoutParams();
                  ((ViewGroup.LayoutParams)localObject11).width = ((Integer)((Pair)localObject2).first).intValue();
                  ((ViewGroup.LayoutParams)localObject11).height = ((Integer)((Pair)localObject2).second).intValue();
                  ((aw)localObject5).RjQ.setLayoutParams((ViewGroup.LayoutParams)localObject11);
                  localObject10 = (FrameLayout)((View)localObject10).findViewById(b.f.sns_video_container);
                  localObject11 = (FrameLayout.LayoutParams)((FrameLayout)localObject10).getLayoutParams();
                  ((FrameLayout.LayoutParams)localObject11).width = ((Integer)((Pair)localObject2).first).intValue();
                  ((FrameLayout.LayoutParams)localObject11).height = ((Integer)((Pair)localObject2).second).intValue();
                  ((FrameLayout)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject11);
                }
                if ((((TimeLineObject)localObject8).ContentObj == null) || (((TimeLineObject)localObject8).ContentObj.Zpr.size() <= 0)) {
                  break label6258;
                }
                localObject2 = (dmz)((TimeLineObject)localObject8).ContentObj.Zpr.get(0);
                if ((((TimeLineObject)localObject8).ContentObj == null) || (((TimeLineObject)localObject8).ContentObj.Zpr.size() <= 0)) {
                  break label6262;
                }
                com.tencent.mm.plugin.sns.model.al.hgy();
                if (com.tencent.mm.plugin.sns.model.g.u((dmz)localObject2)) {
                  break label6367;
                }
                if (!com.tencent.mm.plugin.sns.model.al.hgy().x((dmz)localObject2)) {
                  break label6264;
                }
                ((aw)localObject5).PQu.setVisibility(8);
                ((aw)localObject5).RjP.setVisibility(0);
                ((aw)localObject5).RjP.jEN();
                ((VideoSightView)localObject7).setTagObject(localObject5);
                com.tencent.mm.plugin.sns.model.al.hgy().a(localSnsInfo, (dmz)localObject2, (VideoSightView)localObject7, hashCode(), 0, br.adkc, localSnsInfo.isAd());
                ((VideoSightView)localObject7).start();
                ((View)localObject6).setTag(localObject5);
                if (this.RoZ == null) {
                  continue;
                }
                if (!localSnsInfo.isAd()) {
                  break label6651;
                }
                if (com.tencent.mm.plugin.sns.model.al.hgy().C(localSnsInfo) != 5) {
                  break label6645;
                }
                bool = true;
              }
              for (;;)
              {
                this.RoZ.T(localSnsInfo.field_snsId, bool);
                break;
                this.vEV.c((View)localObject6, this.PZr.RQm, this.PZr.RPU);
                break label5596;
                localObject2 = com.tencent.mm.modelsns.o.a((TimeLineObject)localObject8, ((aw)localObject5).RjM.getUIContext(), false);
                break label5652;
                localObject2 = com.tencent.mm.modelsns.o.a((TimeLineObject)localObject8, ((aw)localObject5).RjM.getUIContext(), localSnsInfo.isAd());
                i = 0;
                break label5711;
                if (i != 0)
                {
                  ((aw)localObject5).RjM.setScaleMode(1);
                  ((aw)localObject5).RjM.setScaleType(QImageView.a.afVc);
                  break label5755;
                }
                ((aw)localObject5).RjM.setScaleMode(0);
                ((aw)localObject5).RjM.setScaleType(QImageView.a.afUX);
                break label5755;
                label6246:
                ((aw)localObject5).RjM.setDrawWidthAndHeightFix(false);
                break label5806;
                label6258:
                localObject2 = null;
                break label5959;
                label6262:
                break;
                label6264:
                if ((localSnsInfo.isAd()) && (com.tencent.mm.plugin.sns.model.al.hgy().C(localSnsInfo) == 5))
                {
                  com.tencent.mm.plugin.sns.model.al.hgy().B((dmz)localObject2);
                  ((aw)localObject5).PQu.setVisibility(8);
                  ((aw)localObject5).RjP.setVisibility(0);
                  ((aw)localObject5).RjP.jEN();
                  break label6031;
                }
                com.tencent.mm.plugin.sns.model.al.hgy().z((dmz)localObject2);
                ((aw)localObject5).PQu.setVisibility(0);
                ((aw)localObject5).RjP.setVisibility(8);
                ((aw)localObject5).PQu.setImageDrawable(com.tencent.mm.cd.a.m(this, b.i.shortvideo_play_btn));
                break label6031;
                if (com.tencent.mm.plugin.sns.model.al.hgy().v((dmz)localObject2))
                {
                  ((aw)localObject5).PQu.setVisibility(0);
                  ((aw)localObject5).RjP.setVisibility(8);
                  ((aw)localObject5).PQu.setImageDrawable(com.tencent.mm.cd.a.m(this, b.i.shortvideo_play_btn));
                }
                for (;;)
                {
                  if (!((aw)localObject5).RjM.gYH()) {
                    break label6643;
                  }
                  Log.d("MicroMsg.SnsCommentDetailUI", "play video error " + ((dmz)localObject2).Id + " " + ((dmz)localObject2).Url + " " + ((dmz)localObject2).aaTl);
                  com.tencent.mm.plugin.sns.model.al.hgy().z((dmz)localObject2);
                  ((aw)localObject5).PQu.setVisibility(0);
                  ((aw)localObject5).RjP.setVisibility(8);
                  ((aw)localObject5).PQu.setImageDrawable(com.tencent.mm.cd.a.m(this, b.i.shortvideo_play_btn));
                  break;
                  if (com.tencent.mm.plugin.sns.model.al.hgy().w((dmz)localObject2))
                  {
                    ((aw)localObject5).PQu.setVisibility(8);
                    ((aw)localObject5).RjP.setVisibility(8);
                  }
                  else if ((localSnsInfo.isAd()) && (com.tencent.mm.plugin.sns.model.al.hgy().C(localSnsInfo) <= 5))
                  {
                    ((aw)localObject5).PQu.setVisibility(8);
                    ((aw)localObject5).RjP.setVisibility(8);
                  }
                  else
                  {
                    com.tencent.mm.plugin.sns.model.al.hgy().z((dmz)localObject2);
                    ((aw)localObject5).PQu.setVisibility(0);
                    ((aw)localObject5).RjP.setVisibility(8);
                    ((aw)localObject5).PQu.setImageDrawable(com.tencent.mm.cd.a.m(this, b.i.shortvideo_play_btn));
                  }
                }
                label6643:
                break label6031;
                label6645:
                bool = false;
                continue;
                label6651:
                if (com.tencent.mm.plugin.sns.model.al.hgy().B(localSnsInfo) == 5) {
                  bool = true;
                } else {
                  bool = false;
                }
              }
            }
            else
            {
              if (this.viewType != 0) {
                break label7092;
              }
              localObject2 = (LinearLayout)this.Rou.findViewById(b.f.sns_meida_frame);
              localObject5 = alY(b.g.sns_media_sub_item);
              if (!this.RpA)
              {
                ((LinearLayout)localObject2).removeView(this.RpD);
                ((LinearLayout)localObject2).addView((View)localObject5, 3);
                if (((LinearLayout)localObject5).getLayoutParams() == null) {
                  break label7067;
                }
              }
              for (localObject2 = new LinearLayout.LayoutParams(((LinearLayout)localObject5).getLayoutParams());; localObject2 = new LinearLayout.LayoutParams(-1, -2))
              {
                ((LinearLayout.LayoutParams)localObject2).setMargins(((LinearLayout.LayoutParams)localObject2).leftMargin, com.tencent.mm.cd.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject2).rightMargin, ((LinearLayout.LayoutParams)localObject2).bottomMargin);
                ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                if (((TimeLineObject)localObject8).ContentObj.Zpr.isEmpty()) {
                  break label7082;
                }
                localObject6 = (dmz)((TimeLineObject)localObject8).ContentObj.Zpr.get(0);
                localObject2 = (MMImageView)((LinearLayout)localObject5).findViewById(b.f.image_left);
                com.tencent.mm.plugin.sns.model.al.hgy().a((dmz)localObject6, (View)localObject2, b.i.app_attach_file_icon_music, hashCode(), br.adkc);
                this.RoM = ((ImageView)((LinearLayout)localObject5).findViewById(b.f.state));
                this.RoM.setOnTouchListener(this.Rdy);
                this.musicId = ((TimeLineObject)localObject8).Id;
                hot();
                bool = getIntent().getBooleanExtra("SNS_FROM_MUSIC_ITEM", false);
                ((MMImageView)localObject2).setTag(new s((TimeLineObject)localObject8, this.RoK, bool));
                ((MMImageView)localObject2).setOnClickListener(this.RoS.RFE);
                localObject7 = ((dmz)localObject6).IGG;
                if (!Util.isNullOrNil((String)localObject7)) {
                  ((TextView)((LinearLayout)localObject5).findViewById(b.f.righttext)).setText((CharSequence)localObject7);
                }
                localObject6 = ((dmz)localObject6).hAP;
                if (!Util.isNullOrNil((String)localObject6)) {
                  ((TextView)((LinearLayout)localObject5).findViewById(b.f.titletext)).setText(new SpannableString((CharSequence)localObject6), TextView.BufferType.SPANNABLE);
                }
                ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject8, this.RoK));
                this.vEV.c((View)localObject5, this.PZr.RQj, this.PZr.RPU);
                ((LinearLayout)localObject5).setOnClickListener(this.RoS.Rwb);
                t.c((View)localObject2, this);
                break;
              }
              ((LinearLayout)localObject5).setVisibility(8);
            }
          }
          Object localObject12;
          final View localView;
          MMRoundCornerImageView localMMRoundCornerImageView;
          TextView localTextView1;
          TextView localTextView2;
          if (this.viewType == 24)
          {
            localObject2 = (LinearLayout)this.Rou.findViewById(b.f.sns_meida_frame);
            localObject12 = alY(b.g.sns_media_music_item);
            if (!this.RpA)
            {
              ((LinearLayout)localObject2).removeView(this.RpD);
              ((LinearLayout)localObject2).addView((View)localObject12, 3);
              if (((LinearLayout)localObject12).getLayoutParams() == null) {
                break label7239;
              }
            }
            for (localObject2 = new LinearLayout.LayoutParams(((LinearLayout)localObject12).getLayoutParams());; localObject2 = new LinearLayout.LayoutParams(-1, -2))
            {
              ((LinearLayout.LayoutParams)localObject2).setMargins(((LinearLayout.LayoutParams)localObject2).leftMargin, com.tencent.mm.cd.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject2).rightMargin, ((LinearLayout.LayoutParams)localObject2).bottomMargin);
              ((LinearLayout)localObject12).setLayoutParams((ViewGroup.LayoutParams)localObject2);
              this.musicId = ((TimeLineObject)localObject8).Id;
              localObject2 = (RoundCornerRelativeLayout)((LinearLayout)localObject12).findViewById(b.f.round_corner_rl);
              if (localObject2 != null) {
                break;
              }
              AppMethodBeat.o(98604);
              return false;
            }
            ((RoundCornerRelativeLayout)localObject2).setRadius(com.tencent.mm.cd.a.fromDPToPix(getContext(), 4));
            localView = ((RoundCornerRelativeLayout)localObject2).findViewById(b.f.blur_bg_view);
            localObject10 = ((RoundCornerRelativeLayout)localObject2).findViewById(b.f.music_container);
            if (com.tencent.mm.ui.aw.isDarkMode())
            {
              ((View)localObject10).setBackgroundResource(b.e.sns_music_mv_dark_gradient_bg);
              localMMRoundCornerImageView = (MMRoundCornerImageView)((View)localObject10).findViewById(b.f.chatting_music_cover);
              localTextView1 = (TextView)((View)localObject10).findViewById(b.f.chatting_music_singer_name);
              localObject11 = (TextView)((View)localObject10).findViewById(b.f.chatting_music_song_name);
              localTextView2 = (TextView)((View)localObject10).findViewById(b.f.chatting_music_mv_info);
              this.RoN = ((WeImageView)((View)localObject10).findViewById(b.f.chatting_music_media_icon));
              this.RoN.setOnTouchListener(this.Rdy);
              localObject2 = "";
              localObject7 = null;
              localObject6 = localObject7;
              localObject5 = localObject2;
              if (localObject8 != null)
              {
                localObject6 = localObject7;
                localObject5 = localObject2;
                if (((TimeLineObject)localObject8).ContentObj != null) {
                  if (((TimeLineObject)localObject8).ContentObj.Zpr.isEmpty()) {
                    break label17363;
                  }
                }
              }
            }
          }
          for (localObject2 = (dmz)((TimeLineObject)localObject8).ContentObj.Zpr.get(0);; localObject3 = null)
          {
            if (((TimeLineObject)localObject8).ContentObj.oPb != null)
            {
              localObject6 = ((TimeLineObject)localObject8).ContentObj.oPb.YqQ;
              if (!Util.isNullOrNil((String)localObject6))
              {
                Log.i("MicroMsg.SnsCommentDetailUI", "has mvInfo:%s", new Object[] { localObject6 });
                ((ViewGroup.MarginLayoutParams)((TextView)localObject11).getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 6);
                ((ViewGroup.MarginLayoutParams)localTextView1.getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 2);
                ((View)localObject10).findViewById(b.f.padding_view).setVisibility(0);
                localTextView2.setVisibility(0);
                localTextView2.setText((String)localObject6 + getContext().getString(com.tencent.mm.plugin.sns.b.j.music_mv_info_share_suffix));
              }
            }
            for (localObject5 = ((TimeLineObject)localObject8).ContentObj.oPb.YqP;; localObject5 = "")
            {
              if (!Util.isNullOrNil((String)localObject5))
              {
                bool = true;
                Log.i("MicroMsg.SnsCommentDetailUI", "coverInfo: hasCover:%b, postInfo:%s", new Object[] { Boolean.valueOf(bool), localObject6 });
                localObject6 = localObject2;
                if (Util.isNullOrNil((String)localObject5)) {
                  break label8070;
                }
                localObject2 = com.tencent.mm.plugin.music.h.b.aPp((String)localObject5);
              }
              for (;;)
              {
                label7655:
                if (!Util.isNullOrNil((String)localObject5))
                {
                  localObject7 = new c.a();
                  ((c.a)localObject7).Oq((String)localObject2);
                  ((c.a)localObject7).bKt();
                  ((c.a)localObject7).bKw();
                  ((c.a)localObject7).bKs();
                  ((c.a)localObject7).bKv();
                  ((c.a)localObject7).bt(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 2));
                  localObject7 = ((c.a)localObject7).bKx();
                  r.bKe().a((String)localObject5, localMMRoundCornerImageView, (com.tencent.mm.modelimage.loader.a.c)localObject7, new com.tencent.mm.modelimage.loader.b.h()
                  {
                    public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
                    {
                      return null;
                    }
                    
                    public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
                    {
                      AppMethodBeat.i(308102);
                      if ((paramAnonymousb.bitmap != null) && (!paramAnonymousb.bitmap.isRecycled()))
                      {
                        paramAnonymousString = com.tencent.mm.b.g.getMessageDigest(paramAnonymousString.getBytes());
                        paramAnonymousView = com.tencent.mm.plugin.comm.b.xeH;
                        com.tencent.mm.plugin.comm.b.a(MMApplicationContext.getContext(), localView, paramAnonymousb.bitmap, paramAnonymousString);
                      }
                      AppMethodBeat.o(308102);
                    }
                    
                    public final void c(String paramAnonymousString, View paramAnonymousView) {}
                  });
                  this.RoN.setPressed(false);
                  hou();
                  if (localObject6 != null)
                  {
                    localObject5 = ((dmz)localObject6).IGG;
                    if ((((TimeLineObject)localObject8).ContentObj.oPb == null) || (Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.oPb.singerName))) {
                      break label8176;
                    }
                    localTextView1.setVisibility(0);
                    localTextView1.setText(((TimeLineObject)localObject8).ContentObj.oPb.singerName);
                    if (localObject6 == null) {
                      break label8217;
                    }
                    localObject5 = ((dmz)localObject6).hAP;
                    if (Util.isNullOrNil((String)localObject5)) {
                      break label8225;
                    }
                    ((TextView)localObject11).setVisibility(0);
                    ((TextView)localObject11).setText(new SpannableString((CharSequence)localObject5), TextView.BufferType.SPANNABLE);
                  }
                  for (;;)
                  {
                    if (((TimeLineObject)localObject8).ContentObj.oPb == null) {
                      ((TimeLineObject)localObject8).ContentObj.oPb = new dtj();
                    }
                    ((TimeLineObject)localObject8).ContentObj.oPb.oPc = ((String)localObject2);
                    localObject2 = new s((TimeLineObject)localObject8, this.RoK);
                    ((s)localObject2).nSq = 2;
                    this.RoN.setTag(localObject2);
                    this.RoN.setOnClickListener(this.RoS.RFF);
                    ((View)localObject10).setTag(localObject2);
                    this.vEV.c((View)localObject10, this.PZr.RQj, this.PZr.RPU);
                    ((View)localObject10).setOnClickListener(this.RoS.RFt);
                    break;
                    ((View)localObject10).setBackgroundResource(b.e.sns_music_mv_light_gradient_bg);
                    break label7302;
                    ((ViewGroup.MarginLayoutParams)((TextView)localObject11).getLayoutParams()).topMargin = 0;
                    ((ViewGroup.MarginLayoutParams)localTextView1.getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 4);
                    ((View)localObject10).findViewById(b.f.padding_view).setVisibility(8);
                    localTextView2.setText("");
                    localTextView2.setVisibility(8);
                    break label7586;
                    bool = false;
                    break label7610;
                    if (localObject6 == null) {
                      break label17342;
                    }
                    if (!Util.isNullOrNil(((dmz)localObject6).aaTl))
                    {
                      localObject5 = ((dmz)localObject6).aaTl;
                      localObject2 = com.tencent.mm.plugin.music.h.b.aPp(((dmz)localObject6).aaTl);
                      break label7655;
                    }
                    localObject2 = com.tencent.mm.plugin.sns.model.al.hgq().vk(((dmz)localObject6).icg);
                    localObject5 = t.aXq(((com.tencent.mm.plugin.sns.storage.z)localObject2).hli());
                    localObject5 = com.tencent.mm.plugin.sns.model.as.mg(com.tencent.mm.plugin.sns.model.al.getAccSnsPath(), ((com.tencent.mm.plugin.sns.storage.z)localObject2).hli()) + (String)localObject5;
                    localObject2 = localObject5;
                    break label7655;
                    localObject5 = "";
                    break label7771;
                    label8176:
                    if (!Util.isNullOrNil((String)localObject5))
                    {
                      localTextView1.setVisibility(0);
                      localTextView1.setText((CharSequence)localObject5);
                      break label7821;
                    }
                    localTextView1.setText("");
                    localTextView1.setVisibility(0);
                    break label7821;
                    localObject5 = "";
                    break label7833;
                    Log.e("MicroMsg.SnsCommentDetailUI", "Not allow title is empty");
                  }
                }
                ((LinearLayout)localObject12).setVisibility(8);
                break;
                if (this.viewType == 13)
                {
                  this.Rov.setVisibility(8);
                  this.RoA.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                  break;
                }
                if ((this.viewType == 11) || (com.tencent.mm.plugin.sns.ui.item.a.a.b.amu(this.viewType)) || (this.viewType == 15)) {
                  break;
                }
                if (this.viewType == 16)
                {
                  localObject2 = (LinearLayout)this.Rou.findViewById(b.f.sns_meida_frame);
                  localObject6 = alY(b.g.sns_media_link_item);
                  if (!this.RpA)
                  {
                    ((LinearLayout)localObject2).removeView(this.RpD);
                    ((LinearLayout)localObject2).addView((View)localObject6, 3);
                    if (((LinearLayout)localObject6).getLayoutParams() != null)
                    {
                      localObject2 = new LinearLayout.LayoutParams(((LinearLayout)localObject6).getLayoutParams());
                      ((LinearLayout.LayoutParams)localObject2).setMargins(((LinearLayout.LayoutParams)localObject2).leftMargin, com.tencent.mm.cd.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject2).rightMargin, ((LinearLayout.LayoutParams)localObject2).bottomMargin);
                      ((LinearLayout)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                    }
                  }
                  else
                  {
                    localObject7 = (MMImageView)((LinearLayout)localObject6).findViewById(b.f.image_left);
                    ((MMImageView)localObject7).setVisibility(0);
                    localObject10 = (TextView)((LinearLayout)localObject6).findViewById(b.f.titletext);
                    if (((TimeLineObject)localObject8).ContentObj.hKU == null) {
                      break label8892;
                    }
                    Log.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderShareObject not null");
                    if ((!Util.isNullOrNil(t.e(((TimeLineObject)localObject8).ContentObj.hKU))) || (Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.hKU.desc))) {
                      break label8796;
                    }
                    localObject2 = ((TimeLineObject)localObject8).ContentObj.hKU.desc;
                  }
                  for (;;)
                  {
                    ((TextView)localObject10).setText(new SpannableString((CharSequence)localObject2), TextView.BufferType.SPANNABLE);
                    ((TextView)localObject10).setMaxLines(2);
                    if (!((TimeLineObject)localObject8).ContentObj.hKU.mediaList.isEmpty())
                    {
                      localObject2 = new dmz();
                      ((dmz)localObject2).Url = ((bvj)((TimeLineObject)localObject8).ContentObj.hKU.mediaList.get(0)).thumbUrl;
                      ((dmz)localObject2).aaTl = ((bvj)((TimeLineObject)localObject8).ContentObj.hKU.mediaList.get(0)).thumbUrl;
                      ((dmz)localObject2).vhJ = 2;
                      ((dmz)localObject2).aaTm = 1;
                      ((dmz)localObject2).aaTn = new dnb();
                      ((dmz)localObject2).aazR = 1;
                      ((dmz)localObject2).aaTn.aaUb = ((bvj)((TimeLineObject)localObject8).ContentObj.hKU.mediaList.get(0)).width;
                      ((dmz)localObject2).aaTn.aaUc = ((bvj)((TimeLineObject)localObject8).ContentObj.hKU.mediaList.get(0)).height;
                      ((dmz)localObject2).Id = localSnsInfo.getSnsId();
                      com.tencent.mm.plugin.sns.model.al.hgy().b((dmz)localObject2, (View)localObject7, hashCode(), br.jbh().ayX(((TimeLineObject)localObject8).CreateTime));
                    }
                    ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                    ((LinearLayout)localObject6).setOnClickListener(this.RoS.Rwb);
                    break;
                    localObject2 = new LinearLayout.LayoutParams(-1, -2);
                    break label8392;
                    if (!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.hKU.desc)) {
                      localObject2 = t.e(((TimeLineObject)localObject8).ContentObj.hKU) + ": " + ((TimeLineObject)localObject8).ContentObj.hKU.desc;
                    } else {
                      localObject2 = getString(com.tencent.mm.plugin.sns.b.j.sns_share_finder_feed_title, new Object[] { t.e(((TimeLineObject)localObject8).ContentObj.hKU) });
                    }
                  }
                  if (((TimeLineObject)localObject8).ContentObj.Zpy != null)
                  {
                    Log.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.megaVideoShareObject not null");
                    if ((Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.Zpy.nickname)) && (!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.Zpy.desc)))
                    {
                      localObject2 = ((TimeLineObject)localObject8).ContentObj.Zpy.desc;
                      ((TextView)localObject10).setText(new SpannableString((CharSequence)localObject2), TextView.BufferType.SPANNABLE);
                      ((TextView)localObject10).setMaxLines(2);
                      if (!((TimeLineObject)localObject8).ContentObj.Zpy.mediaList.isEmpty())
                      {
                        localObject5 = new dmz();
                        if (TextUtils.isEmpty(((dob)((TimeLineObject)localObject8).ContentObj.Zpy.mediaList.get(0)).coverUrl)) {
                          break label9324;
                        }
                      }
                    }
                    label9324:
                    for (localObject2 = ((dob)((TimeLineObject)localObject8).ContentObj.Zpy.mediaList.get(0)).coverUrl;; localObject2 = ((dob)((TimeLineObject)localObject8).ContentObj.Zpy.mediaList.get(0)).thumbUrl)
                    {
                      ((dmz)localObject5).Url = ((String)localObject2);
                      ((dmz)localObject5).aaTl = ((String)localObject2);
                      ((dmz)localObject5).vhJ = 2;
                      ((dmz)localObject5).aaTm = 1;
                      ((dmz)localObject5).aaTn = new dnb();
                      ((dmz)localObject5).aazR = 1;
                      ((dmz)localObject5).aaTn.aaUb = ((dob)((TimeLineObject)localObject8).ContentObj.Zpy.mediaList.get(0)).width;
                      ((dmz)localObject5).aaTn.aaUc = ((dob)((TimeLineObject)localObject8).ContentObj.Zpy.mediaList.get(0)).height;
                      ((dmz)localObject5).Id = localSnsInfo.getSnsId();
                      com.tencent.mm.plugin.sns.model.al.hgy().b((dmz)localObject5, (View)localObject7, hashCode(), br.jbh().ayX(((TimeLineObject)localObject8).CreateTime));
                      ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                      ((LinearLayout)localObject6).setOnClickListener(this.RoS.Rwb);
                      break;
                      if (!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.Zpy.desc))
                      {
                        localObject2 = ((TimeLineObject)localObject8).ContentObj.Zpy.nickname + ": " + ((TimeLineObject)localObject8).ContentObj.Zpy.desc;
                        break label8959;
                      }
                      localObject2 = getString(com.tencent.mm.plugin.sns.b.j.sns_share_finder_feed_title, new Object[] { ((TimeLineObject)localObject8).ContentObj.Zpy.nickname });
                      break label8959;
                    }
                  }
                  if (((TimeLineObject)localObject8).ContentObj.Zpz != null)
                  {
                    Log.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderShareTopic not null");
                    localObject2 = getString(com.tencent.mm.plugin.sns.b.j.app_finder_topic);
                    if (((TimeLineObject)localObject8).ContentObj.Zpz == null) {
                      break label17335;
                    }
                    if ((((TimeLineObject)localObject8).ContentObj.Zpz.Auy != 7) || (((TimeLineObject)localObject8).ContentObj.Zpz.aade == null)) {
                      break label17332;
                    }
                    localObject2 = com.tencent.mm.modelstat.o.a(((TimeLineObject)localObject8).ContentObj.Zpz.aade);
                    localObject5 = localObject2;
                    if (!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.Zpz.desc))
                    {
                      localObject5 = (TextView)((LinearLayout)localObject6).findViewById(b.f.righttext);
                      ((TextView)localObject5).setVisibility(0);
                      ((TextView)localObject5).setText(((TimeLineObject)localObject8).ContentObj.Zpv.desc);
                    }
                  }
                }
                for (localObject5 = localObject2;; localObject5 = localObject3)
                {
                  ((TextView)localObject10).setText(new SpannableString((CharSequence)localObject5), TextView.BufferType.SPANNABLE);
                  ((TextView)localObject10).setMaxLines(2);
                  if (!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.Zpz.iconUrl))
                  {
                    localObject2 = new dmz();
                    ((dmz)localObject2).Url = ((TimeLineObject)localObject8).ContentObj.Zpz.iconUrl;
                    ((dmz)localObject2).aaTl = ((TimeLineObject)localObject8).ContentObj.Zpz.iconUrl;
                    ((dmz)localObject2).vhJ = 2;
                    ((dmz)localObject2).aaTm = 1;
                    ((dmz)localObject2).aaTn = new dnb();
                    ((dmz)localObject2).aazR = 1;
                    ((dmz)localObject2).aaTn.aaUb = 0.0F;
                    ((dmz)localObject2).aaTn.aaUc = 0.0F;
                    ((dmz)localObject2).Id = localSnsInfo.getSnsId();
                    ((MMImageView)localObject7).setScaleType(ImageView.ScaleType.CENTER_CROP);
                    ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadImageForSns(((TimeLineObject)localObject8).ContentObj.Zpz.iconUrl, (View)localObject7);
                  }
                  for (;;)
                  {
                    ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                    ((LinearLayout)localObject6).setOnClickListener(this.RoS.Rwb);
                    break;
                    com.tencent.mm.plugin.sns.model.al.hgy().c((View)localObject7, -1, b.i.icon_filled_activity, hashCode());
                  }
                  if (((TimeLineObject)localObject8).ContentObj.Zpv != null)
                  {
                    Log.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderShareTopic not null");
                    localObject5 = getString(com.tencent.mm.plugin.sns.b.j.app_finder_topic);
                    if (((TimeLineObject)localObject8).ContentObj.Zpv != null)
                    {
                      if (((TimeLineObject)localObject8).ContentObj.Zpv.Auy != 1) {
                        break label10046;
                      }
                      localObject2 = "#" + ((TimeLineObject)localObject8).ContentObj.Zpv.topic;
                    }
                    for (;;)
                    {
                      localObject5 = localObject2;
                      if (!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.Zpv.desc))
                      {
                        localObject5 = (TextView)((LinearLayout)localObject6).findViewById(b.f.righttext);
                        ((TextView)localObject5).setVisibility(0);
                        ((TextView)localObject5).setText(((TimeLineObject)localObject8).ContentObj.Zpv.desc);
                        localObject5 = localObject2;
                      }
                      ((TextView)localObject10).setText(new SpannableString((CharSequence)localObject5), TextView.BufferType.SPANNABLE);
                      ((TextView)localObject10).setMaxLines(2);
                      localObject2 = new dmz();
                      ((dmz)localObject2).Url = ((TimeLineObject)localObject8).ContentObj.Zpv.iconUrl;
                      ((dmz)localObject2).aaTl = ((TimeLineObject)localObject8).ContentObj.Zpv.iconUrl;
                      ((dmz)localObject2).vhJ = 2;
                      ((dmz)localObject2).aaTm = 1;
                      ((dmz)localObject2).aaTn = new dnb();
                      ((dmz)localObject2).aazR = 1;
                      ((dmz)localObject2).aaTn.aaUb = 0.0F;
                      ((dmz)localObject2).aaTn.aaUc = 0.0F;
                      ((dmz)localObject2).Id = localSnsInfo.getSnsId();
                      com.tencent.mm.plugin.sns.model.al.hgy().b((dmz)localObject2, (View)localObject7, hashCode(), br.jbh().ayX(((TimeLineObject)localObject8).CreateTime));
                      ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                      ((LinearLayout)localObject6).setOnClickListener(this.RoS.Rwb);
                      break;
                      if ((((TimeLineObject)localObject8).ContentObj.Zpv.Auy == 7) && (((TimeLineObject)localObject8).ContentObj.Zpv.aade != null)) {
                        localObject2 = com.tencent.mm.modelstat.o.a(((TimeLineObject)localObject8).ContentObj.Zpz.aade);
                      } else {
                        localObject2 = ((TimeLineObject)localObject8).ContentObj.Zpv.topic;
                      }
                    }
                  }
                  if (((TimeLineObject)localObject8).ContentObj.Zpx != null)
                  {
                    ((TextView)localObject10).setText(new SpannableString(((TimeLineObject)localObject8).ContentObj.Zpx.title), TextView.BufferType.SPANNABLE);
                    ((TextView)localObject10).setMaxLines(2);
                    localObject2 = new dmz();
                    ((dmz)localObject2).Url = ((String)((TimeLineObject)localObject8).ContentObj.Zpx.aacP.get(0) + (String)((TimeLineObject)localObject8).ContentObj.Zpx.aacQ.get(0));
                    ((dmz)localObject2).aaTl = ((dmz)localObject2).Url;
                    ((dmz)localObject2).vhJ = 2;
                    ((dmz)localObject2).aaTm = 1;
                    ((dmz)localObject2).aaTn = new dnb();
                    ((dmz)localObject2).aazR = 1;
                    ((dmz)localObject2).aaTn.aaUb = 0.0F;
                    ((dmz)localObject2).aaTn.aaUc = 0.0F;
                    ((dmz)localObject2).Id = localSnsInfo.getSnsId();
                    com.tencent.mm.plugin.sns.model.al.hgy().b((dmz)localObject2, (View)localObject7, hashCode(), br.jbh().ayX(((TimeLineObject)localObject8).CreateTime));
                    ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                    ((LinearLayout)localObject6).setOnClickListener(this.RoS.Rwb);
                    break;
                  }
                  if (((TimeLineObject)localObject8).ContentObj.DHa != null)
                  {
                    Log.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderLiveShareObject not null");
                    if ((Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.DHa.nickName)) && (!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.DHa.desc))) {
                      localObject2 = ((TimeLineObject)localObject8).ContentObj.DHa.desc;
                    }
                    for (;;)
                    {
                      ((TextView)localObject10).setText(new SpannableString((CharSequence)localObject2), TextView.BufferType.SPANNABLE);
                      ((TextView)localObject10).setMaxLines(2);
                      if (!((TimeLineObject)localObject8).ContentObj.DHa.coverUrl.isEmpty())
                      {
                        localObject2 = new dmz();
                        ((dmz)localObject2).Url = ((TimeLineObject)localObject8).ContentObj.DHa.coverUrl;
                        ((dmz)localObject2).aaTl = ((TimeLineObject)localObject8).ContentObj.DHa.coverUrl;
                        ((dmz)localObject2).vhJ = 2;
                        ((dmz)localObject2).aaTm = 1;
                        ((dmz)localObject2).aaTn = new dnb();
                        ((dmz)localObject2).aazR = 1;
                        ((dmz)localObject2).aaTn.aaUb = ((TimeLineObject)localObject8).ContentObj.DHa.width;
                        ((dmz)localObject2).aaTn.aaUc = ((TimeLineObject)localObject8).ContentObj.DHa.height;
                        ((dmz)localObject2).Id = localSnsInfo.getSnsId();
                        com.tencent.mm.plugin.sns.model.al.hgy().b((dmz)localObject2, (View)localObject7, hashCode(), br.jbh().ayX(((TimeLineObject)localObject8).CreateTime));
                      }
                      ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                      ((LinearLayout)localObject6).setOnClickListener(this.RoS.Rwb);
                      break;
                      if (!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.DHa.desc)) {
                        localObject2 = ((TimeLineObject)localObject8).ContentObj.DHa.nickName + ": " + ((TimeLineObject)localObject8).ContentObj.DHa.desc;
                      } else {
                        localObject2 = getString(com.tencent.mm.plugin.sns.b.j.sns_share_finder_feed_title, new Object[] { ((TimeLineObject)localObject8).ContentObj.DHa.nickName });
                      }
                    }
                  }
                  if (((TimeLineObject)localObject8).ContentObj.ZpA == null) {
                    break;
                  }
                  Log.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderSharePoi not null");
                  localObject2 = ((TimeLineObject)localObject8).ContentObj.ZpA.poiName;
                  if (!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.ZpA.AXm))
                  {
                    localObject5 = (TextView)((LinearLayout)localObject6).findViewById(b.f.righttext);
                    ((TextView)localObject5).setVisibility(0);
                    ((TextView)localObject5).setText(((TimeLineObject)localObject8).ContentObj.ZpA.AXm);
                  }
                  ((TextView)localObject10).setText(new SpannableString((CharSequence)localObject2), TextView.BufferType.SPANNABLE);
                  ((TextView)localObject10).setMaxLines(2);
                  if (!Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.ZpA.XOv))
                  {
                    localObject2 = new dmz();
                    ((dmz)localObject2).Url = ((TimeLineObject)localObject8).ContentObj.ZpA.XOv;
                    ((dmz)localObject2).aaTl = ((TimeLineObject)localObject8).ContentObj.ZpA.XOv;
                    ((dmz)localObject2).vhJ = 2;
                    ((dmz)localObject2).aaTm = 1;
                    ((dmz)localObject2).aaTn = new dnb();
                    ((dmz)localObject2).aazR = 1;
                    ((dmz)localObject2).aaTn.aaUb = 0.0F;
                    ((dmz)localObject2).aaTn.aaUc = 0.0F;
                    ((dmz)localObject2).Id = localSnsInfo.getSnsId();
                    com.tencent.mm.plugin.sns.model.al.hgy().b((dmz)localObject2, (View)localObject7, hashCode(), br.jbh().ayX(((TimeLineObject)localObject8).CreateTime));
                  }
                  for (;;)
                  {
                    ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                    ((LinearLayout)localObject6).setOnClickListener(this.RoS.Rwb);
                    break;
                    com.tencent.mm.plugin.sns.model.al.hgy().c((View)localObject7, -1, b.i.icons_outlined_location, hashCode());
                  }
                  if (this.viewType == 17)
                  {
                    localObject2 = (LinearLayout)this.Rou.findViewById(b.f.sns_meida_frame);
                    localObject5 = alY(b.g.sns_media_link_item);
                    if (!this.RpA)
                    {
                      ((LinearLayout)localObject2).removeView(this.RpD);
                      ((LinearLayout)localObject2).addView((View)localObject5, 3);
                      if (((LinearLayout)localObject5).getLayoutParams() == null) {
                        break label11473;
                      }
                    }
                    for (localObject2 = new LinearLayout.LayoutParams(((LinearLayout)localObject5).getLayoutParams());; localObject2 = new LinearLayout.LayoutParams(-1, -2))
                    {
                      ((LinearLayout.LayoutParams)localObject2).setMargins(((LinearLayout.LayoutParams)localObject2).leftMargin, com.tencent.mm.cd.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject2).rightMargin, ((LinearLayout.LayoutParams)localObject2).bottomMargin);
                      ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                      if (((TimeLineObject)localObject8).ContentObj.Zpw == null) {
                        break label11488;
                      }
                      localObject2 = (MMImageView)((LinearLayout)localObject5).findViewById(b.f.image_left);
                      ((MMImageView)localObject2).setVisibility(0);
                      localObject6 = new dmz();
                      ((dmz)localObject6).Url = ((TimeLineObject)localObject8).ContentObj.Zpw.nUM;
                      ((dmz)localObject6).aaTl = ((TimeLineObject)localObject8).ContentObj.Zpw.nUM;
                      ((dmz)localObject6).vhJ = 2;
                      ((dmz)localObject6).aaTm = 1;
                      ((dmz)localObject6).aaTn = new dnb();
                      ((dmz)localObject6).aazR = 1;
                      ((dmz)localObject6).aaTn.aaUb = ((TimeLineObject)localObject8).ContentObj.Zpw.width;
                      ((dmz)localObject6).aaTn.aaUc = ((TimeLineObject)localObject8).ContentObj.Zpw.height;
                      ((dmz)localObject6).Id = localSnsInfo.getSnsId();
                      com.tencent.mm.plugin.sns.model.al.hgy().b((dmz)localObject6, (View)localObject2, hashCode(), br.jbh().ayX(((TimeLineObject)localObject8).CreateTime));
                      localObject6 = (ImageView)((LinearLayout)localObject5).findViewById(b.f.state);
                      ((ImageView)localObject6).setVisibility(0);
                      ((ImageView)localObject6).setImageDrawable(bb.m(((ImageView)localObject6).getContext(), b.i.icons_outlined_video_call, -1));
                      localObject6 = ((TimeLineObject)localObject8).ContentObj.Zpw.title;
                      if (!Util.isNullOrNil((String)localObject6))
                      {
                        localObject7 = (TextView)((LinearLayout)localObject5).findViewById(b.f.titletext);
                        ((TextView)localObject7).setMaxLines(2);
                        ((TextView)localObject7).setText(new SpannableString((CharSequence)localObject6), TextView.BufferType.SPANNABLE);
                      }
                      ((LinearLayout)localObject5).setTag(new al((TimeLineObject)localObject8, (View)localObject2, localSnsInfo.getLocalid()));
                      ((LinearLayout)localObject5).setOnClickListener(this.RoS.RFq);
                      this.vEV.c((View)localObject5, this.PZr.RQp, this.PZr.RPU);
                      t.c((View)localObject2, this);
                      break;
                    }
                    label11488:
                    ((LinearLayout)localObject5).setVisibility(8);
                    break;
                  }
                  if ((this.viewType == 18) || (this.viewType == 21))
                  {
                    localObject2 = this.Rou.findViewById(b.f.sns_finder_media_content_rl);
                    localObject5 = (ImageView)this.Rou.findViewById(b.f.sns_finder_media_status_icon);
                    localObject6 = (ImageIndicatorView)this.Rou.findViewById(b.f.sns_finder_media_image_count_indicator);
                    localObject7 = (ImageView)this.Rou.findViewById(b.f.sns_finder_media_thumb);
                    if ((localObject8 != null) && (((TimeLineObject)localObject8).ContentObj != null) && (((TimeLineObject)localObject8).ContentObj.hKU != null))
                    {
                      localObject10 = ((TimeLineObject)localObject8).ContentObj.hKU;
                      if (!Util.isNullOrNil(((bvl)localObject10).mediaList))
                      {
                        localObject11 = (bvj)((bvl)localObject10).mediaList.get(0);
                        if (localObject11 != null)
                        {
                          if (((bvl)localObject10).GfT != 4) {
                            break label11821;
                          }
                          localObject12 = com.tencent.mm.modelsns.o.a((int)((bvj)localObject11).width, (int)((bvj)localObject11).height, this, false);
                          i = ((Integer)((Pair)localObject12).first).intValue();
                          j = ((Integer)((Pair)localObject12).second).intValue();
                          ((View)localObject2).getLayoutParams().width = i;
                          ((View)localObject2).getLayoutParams().height = j;
                          ((View)localObject2).requestLayout();
                          ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadImage(((bvj)localObject11).thumbUrl, (ImageView)localObject7);
                        }
                      }
                      if (((bvl)localObject10).GfT == 4)
                      {
                        ((ImageView)localObject5).setVisibility(0);
                        ((ImageIndicatorView)localObject6).setVisibility(8);
                      }
                      for (;;)
                      {
                        ((View)localObject2).setTag(localObject8);
                        ((View)localObject2).setOnClickListener(this.RoS.RFv);
                        this.vEV.c((View)localObject2, this.PZr.RQq, this.PZr.RPU);
                        com.tencent.mm.view.f.a((View)localObject2, new e.b()
                        {
                          public final void a(View paramAnonymousView, long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
                          {
                            AppMethodBeat.i(308088);
                            if (paramAnonymousBoolean) {
                              ((bq)com.tencent.mm.kernel.h.ax(bq.class)).a(com.tencent.mm.ae.d.FK(this.RpU.objectId), this.RpU.objectNonceId, 37, null, this.RpV.getContext(), false, null);
                            }
                            AppMethodBeat.o(308088);
                          }
                        });
                        break;
                        localObject12 = com.tencent.mm.modelsns.o.a((int)((bvj)localObject11).width, (int)((bvj)localObject11).height, this);
                        i = ((Integer)((Pair)localObject12).first).intValue();
                        j = ((Integer)((Pair)localObject12).second).intValue();
                        ((View)localObject2).getLayoutParams().width = i;
                        ((View)localObject2).getLayoutParams().height = j;
                        ((View)localObject2).requestLayout();
                        break label11716;
                        ((ImageView)localObject5).setVisibility(8);
                        ((ImageIndicatorView)localObject6).setVisibility(8);
                        ((ImageIndicatorView)localObject6).amK(((bvl)localObject10).hGP);
                      }
                    }
                    if ((localObject8 == null) || (((TimeLineObject)localObject8).ContentObj == null) || (((TimeLineObject)localObject8).ContentObj.Zpy == null)) {
                      break;
                    }
                    localObject10 = ((TimeLineObject)localObject8).ContentObj.Zpy;
                    if (!Util.isNullOrNil(((doc)localObject10).mediaList))
                    {
                      localObject10 = (dob)((doc)localObject10).mediaList.get(0);
                      if (localObject10 != null)
                      {
                        localObject11 = com.tencent.mm.modelsns.o.a((int)((dob)localObject10).width, (int)((dob)localObject10).height, this, false);
                        i = ((Integer)((Pair)localObject11).first).intValue();
                        j = ((Integer)((Pair)localObject11).second).intValue();
                        ((View)localObject2).getLayoutParams().width = i;
                        ((View)localObject2).getLayoutParams().height = j;
                        ((View)localObject2).requestLayout();
                        if (TextUtils.isEmpty(((dob)localObject10).coverUrl)) {
                          break label12144;
                        }
                        ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadImage(((dob)localObject10).coverUrl, (ImageView)localObject7);
                      }
                    }
                    for (;;)
                    {
                      ((ImageView)localObject5).setVisibility(0);
                      ((ImageIndicatorView)localObject6).setVisibility(8);
                      ((View)localObject2).setTag(localObject8);
                      ((View)localObject2).setOnClickListener(this.RoS.RFv);
                      this.vEV.c((View)localObject2, this.PZr.RQq, this.PZr.RPU);
                      break;
                      label12144:
                      ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadImage(((dob)localObject10).thumbUrl, (ImageView)localObject7);
                    }
                  }
                  if (this.viewType == 25)
                  {
                    localObject5 = this.Rou.findViewById(b.f.sns_finder_media_content_rl);
                    if ((localObject8 == null) || (((TimeLineObject)localObject8).ContentObj == null) || (((TimeLineObject)localObject8).ContentObj.DHa == null)) {
                      break;
                    }
                    localObject2 = ((TimeLineObject)localObject8).ContentObj.DHa;
                    if (((com.tencent.mm.plugin.festival.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.festival.a.a.class)).dTk())
                    {
                      i = 1;
                      localObject6 = ar.jR(((View)localObject5).getContext());
                      localObject6 = com.tencent.mm.modelsns.o.a(localObject6[0], localObject6[1], ((View)localObject5).getContext(), false);
                      j = ((Integer)((Pair)localObject6).first).intValue();
                      ((Integer)((Pair)localObject6).second).intValue();
                      localObject6 = (LinearLayout.LayoutParams)((View)localObject5).getLayoutParams();
                      ((LinearLayout.LayoutParams)localObject6).width = j;
                      ((LinearLayout.LayoutParams)localObject6).height = ((int)(j * 3.5F / 3.0F));
                      ((View)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
                      ((View)localObject5).requestLayout();
                      localObject7 = this.Rou.findViewById(b.f.finder_live_icon);
                      localObject10 = this.Rou.findViewById(b.f.finder_live_end_tag);
                      localObject6 = (ImageView)this.Rou.findViewById(b.f.sns_finder_media_thumb);
                      if (i != 2) {
                        break label12547;
                      }
                      if ((((TimeLineObject)localObject8).ContentObj != null) && (((TimeLineObject)localObject8).ContentObj.DHa != null)) {
                        ((TimeLineObject)localObject8).ContentObj.DHa.liveStatus = i;
                      }
                      ((View)localObject7).setVisibility(8);
                      ((View)localObject10).setVisibility(0);
                      if (TextUtils.isEmpty(((bmr)localObject2).coverUrl)) {
                        break label12526;
                      }
                      localObject2 = ((bmr)localObject2).coverUrl;
                    }
                  }
                  for (;;)
                  {
                    ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().a((ImageView)localObject6, (String)localObject2);
                    for (;;)
                    {
                      ((View)localObject5).setTag(localObject8);
                      ((View)localObject5).setOnClickListener(new SnsCommentDetailUI.36(this));
                      this.vEV.c((View)localObject5, this.PZr.RQq, this.PZr.RPU);
                      break;
                      i = 2;
                      break label12243;
                      label12526:
                      if (TextUtils.isEmpty(((bmr)localObject2).headUrl)) {
                        break label17324;
                      }
                      localObject2 = ((bmr)localObject2).headUrl;
                      break label12451;
                      if ((((TimeLineObject)localObject8).ContentObj != null) && (((TimeLineObject)localObject8).ContentObj.DHa != null)) {
                        ((TimeLineObject)localObject8).ContentObj.DHa.liveStatus = i;
                      }
                      ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadImage(((bmr)localObject2).coverUrl, (ImageView)this.Rou.findViewById(b.f.sns_finder_media_thumb));
                      ((View)localObject7).setVisibility(0);
                      ((View)localObject10).setVisibility(8);
                    }
                    if ((this.viewType == 20) || (this.viewType == 33))
                    {
                      localObject6 = this.Rou.findViewById(b.f.sns_finder_media_content_rl);
                      if ((localObject8 == null) || (((TimeLineObject)localObject8).ContentObj == null) || (((TimeLineObject)localObject8).ContentObj.DHa == null)) {
                        break;
                      }
                      localObject7 = ((TimeLineObject)localObject8).ContentObj.DHa;
                      localObject2 = ar.jR(((View)localObject6).getContext());
                      localObject2 = com.tencent.mm.modelsns.o.a(localObject2[0], localObject2[1], ((View)localObject6).getContext(), false);
                      i = ((Integer)((Pair)localObject2).first).intValue();
                      ((Integer)((Pair)localObject2).second).intValue();
                      localObject2 = (LinearLayout.LayoutParams)((View)localObject6).getLayoutParams();
                      ((LinearLayout.LayoutParams)localObject2).width = i;
                      ((LinearLayout.LayoutParams)localObject2).height = ((int)(i * 3.5F / 3.0F));
                      ((View)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject2);
                      ((View)localObject6).requestLayout();
                      if (((bmr)localObject7).liveStatus == 1) {
                        ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadImage(((bmr)localObject7).coverUrl, (ImageView)this.Rou.findViewById(b.f.sns_finder_media_thumb));
                      }
                      localObject10 = this.Rou.findViewById(b.f.finder_olympic_invite_view);
                      localObject11 = (ImageView)this.Rou.findViewById(b.f.sns_finder_media_thumb);
                      if ((((bmr)localObject7).ZVq != null) && (!((bmr)localObject7).ZVq.isEmpty()) && (((bmr)localObject7).liveStatus != 2) && (Objects.equals(((bmr)localObject7).eventId, "1")))
                      {
                        localObject2 = (ImageView)((View)localObject10).findViewById(b.f.finder_olympic_invite_bg);
                        localObject5 = (ImageView)((View)localObject10).findViewById(b.f.finder_olympic_invite_icon);
                        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).loadOlympicsImage((ImageView)localObject2, com.tencent.d.a.a.a.b.b.j.ahpn, b.e.finder_olympic_live_share_bg);
                        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).loadOlympicsImage((ImageView)localObject5, com.tencent.d.a.a.a.b.b.j.ahpo, b.e.finder_olympic_live_share_icon);
                        localObject12 = (TextView)((View)localObject10).findViewById(b.f.finder_olympic_invite_text);
                        ((TextView)localObject12).setTextSize(1, 14.0F);
                        localObject2 = (TextView)((View)localObject10).findViewById(b.f.finder_olympic_invite_name);
                        ((TextView)localObject2).setTextSize(1, 14.0F);
                        localObject5 = (TextView)((View)localObject10).findViewById(b.f.finder_olympic_invite_you);
                        ((TextView)localObject5).setTextSize(1, 13.0F);
                        com.tencent.mm.ui.aw.a(((TextView)localObject12).getPaint(), 0.8F);
                        com.tencent.mm.ui.aw.a(((TextView)localObject2).getPaint(), 0.8F);
                        com.tencent.mm.ui.aw.a(((TextView)localObject5).getPaint(), 0.8F);
                        if ((((bmr)localObject7).ZVr == null) || (((bmr)localObject7).ZVr.isEmpty()))
                        {
                          ((TextView)localObject2).setVisibility(8);
                          localObject2 = MMApplicationContext.getContext().getResources().getString(com.tencent.mm.plugin.sns.b.j.finder_olympic_invite_text_3, new Object[] { ((bmr)localObject7).ZVq });
                          j = com.tencent.mm.cd.a.fromDPToPix(getContext(), 12);
                          localObject5 = ((String)localObject2).replace("\n", "");
                          if (new StaticLayout((CharSequence)localObject5, 0, ((String)localObject5).length(), ((TextView)localObject12).getPaint(), i - j * 2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() > 1) {
                            break label17321;
                          }
                          localObject2 = localObject5;
                        }
                      }
                    }
                    for (;;)
                    {
                      ((TextView)localObject12).setText((CharSequence)localObject2);
                      ((View)localObject10).setVisibility(0);
                      ((ImageView)localObject11).setVisibility(8);
                      for (;;)
                      {
                        final long l1 = 0L;
                        try
                        {
                          long l2 = Long.parseLong(((bmr)localObject7).liveId);
                          l1 = l2;
                        }
                        catch (NumberFormatException localNumberFormatException)
                        {
                          for (;;)
                          {
                            Log.e("MicroMsg.SnsCommentDetailUI", localNumberFormatException.getMessage());
                          }
                        }
                        localObject2 = new com.tencent.d.a.a.a.b.d()
                        {
                          public final void onLiveStatusCallback(long paramAnonymousLong, int paramAnonymousInt, Object paramAnonymousObject)
                          {
                            AppMethodBeat.i(308104);
                            paramAnonymousObject = SnsCommentDetailUI.B(SnsCommentDetailUI.this).findViewById(b.f.finder_live_icon);
                            View localView = SnsCommentDetailUI.B(SnsCommentDetailUI.this).findViewById(b.f.finder_live_end_tag);
                            ImageView localImageView = (ImageView)SnsCommentDetailUI.B(SnsCommentDetailUI.this).findViewById(b.f.sns_finder_media_thumb);
                            if (l1 == paramAnonymousLong) {
                              if (paramAnonymousInt == 2)
                              {
                                if ((this.RpR.ContentObj != null) && (this.RpR.ContentObj.DHa != null)) {
                                  this.RpR.ContentObj.DHa.liveStatus = paramAnonymousInt;
                                }
                                paramAnonymousObject.setVisibility(8);
                                localView.setVisibility(0);
                                this.RpX.setVisibility(0);
                                this.RpY.setVisibility(8);
                                if (!TextUtils.isEmpty(this.RpZ.coverUrl)) {
                                  paramAnonymousObject = this.RpZ.coverUrl;
                                }
                              }
                            }
                            for (;;)
                            {
                              ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderUtilApi().a(localImageView, paramAnonymousObject);
                              AppMethodBeat.o(308104);
                              return;
                              if (!TextUtils.isEmpty(this.RpZ.headUrl))
                              {
                                paramAnonymousObject = this.RpZ.headUrl;
                                continue;
                                if (paramAnonymousInt == 1)
                                {
                                  if ((this.RpR.ContentObj != null) && (this.RpR.ContentObj.DHa != null)) {
                                    this.RpR.ContentObj.DHa.liveStatus = paramAnonymousInt;
                                  }
                                  paramAnonymousObject.setVisibility(0);
                                  localView.setVisibility(8);
                                }
                                AppMethodBeat.o(308104);
                              }
                              else
                              {
                                paramAnonymousObject = "";
                              }
                            }
                          }
                        };
                        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getLiveInfo(l1, false, this, (com.tencent.d.a.a.a.b.d)localObject2);
                        ((View)localObject6).setTag(localObject8);
                        ((View)localObject6).setOnClickListener(this.RoS.RFs);
                        this.vEV.c((View)localObject6, this.PZr.RQq, this.PZr.RPU);
                        break;
                        ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, ((bmr)localObject7).ZVr));
                        ((TextView)localObject2).setVisibility(0);
                        break label13096;
                        ((View)localObject10).setVisibility(8);
                        ((ImageView)localObject11).setVisibility(0);
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
                      localObject3 = (LinearLayout)this.Rou.findViewById(b.f.sns_meida_frame);
                      localObject6 = alY(b.g.sns_media_link_item);
                      localObject7 = (MMImageView)((LinearLayout)localObject6).findViewById(b.f.image_left);
                      if (!this.RpA)
                      {
                        ((LinearLayout)localObject3).removeView(this.RpD);
                        ((LinearLayout)localObject3).addView((View)localObject6, 3);
                        if (((LinearLayout)localObject6).getLayoutParams() != null)
                        {
                          localObject3 = new LinearLayout.LayoutParams(((LinearLayout)localObject6).getLayoutParams());
                          ((LinearLayout.LayoutParams)localObject3).setMargins(((LinearLayout.LayoutParams)localObject3).leftMargin, com.tencent.mm.cd.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject3).rightMargin, ((LinearLayout.LayoutParams)localObject3).bottomMargin);
                          ((LinearLayout)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject3);
                        }
                      }
                      else
                      {
                        i = 0;
                        if (!localSnsInfo.isAd()) {
                          break label13955;
                        }
                        if (localSnsInfo.getAdXml().isLinkAd())
                        {
                          i = 1;
                          ((LinearLayout)localObject6).setTag(localSnsInfo);
                          ((LinearLayout)localObject6).setTag(b.f.link_ad_left_iv, localObject7);
                          ((LinearLayout)localObject6).setOnClickListener(this.PZr.RQL);
                        }
                        j = 0;
                      }
                      for (;;)
                      {
                        if (i != 0)
                        {
                          this.vEV.c((View)localObject6, this.PZr.RQn, this.PZr.RPU);
                          if (!hop()) {
                            break label14780;
                          }
                          localObject5 = bn.baM(((TimeLineObject)localObject8).ContentObj.Url);
                          localObject3 = ((TimeLineObject)localObject8).ContentObj.hAP;
                          if (i != 0) {
                            localObject5 = ((TimeLineObject)localObject8).ContentObj.IGG;
                          }
                          if ((((TimeLineObject)localObject8).ContentObj.Zpu == null) || (((TimeLineObject)localObject8).ContentObj.Zpu.nQp != 1)) {
                            break label17309;
                          }
                          localObject5 = MMApplicationContext.getContext().getString(com.tencent.mm.plugin.sns.b.j.mp_pay_content);
                        }
                        for (;;)
                        {
                          ((LinearLayout)localObject6).findViewById(b.f.state).setVisibility(8);
                          if (!((TimeLineObject)localObject8).ContentObj.Zpr.isEmpty())
                          {
                            ((MMImageView)localObject7).setVisibility(0);
                            localObject10 = (dmz)((TimeLineObject)localObject8).ContentObj.Zpr.get(0);
                            if (((TimeLineObject)localObject8).ContentObj.Zpq == 15)
                            {
                              ((ImageView)((LinearLayout)localObject6).findViewById(b.f.state)).setImageResource(b.e.music_playicon);
                              ((ImageView)((LinearLayout)localObject6).findViewById(b.f.state)).setVisibility(0);
                              com.tencent.mm.plugin.sns.model.al.hgy().a((dmz)localObject10, (View)localObject7, b.i.app_attach_file_icon_video, hashCode(), br.jbh().ayX(((TimeLineObject)localObject8).CreateTime));
                              label13814:
                              t.c((View)localObject7, this);
                              if (((TimeLineObject)localObject8).ContentObj.Zpq != 15) {
                                break label17306;
                              }
                              localObject5 = "";
                              localObject3 = getString(com.tencent.mm.plugin.sns.b.j.sns_folder_sight_title);
                            }
                          }
                          for (;;)
                          {
                            localObject7 = (TextView)((LinearLayout)localObject6).findViewById(b.f.titletext);
                            if (!Util.isNullOrNil((String)localObject5))
                            {
                              ((LinearLayout)localObject6).findViewById(b.f.righttext).setVisibility(0);
                              ((TextView)((LinearLayout)localObject6).findViewById(b.f.righttext)).setText((CharSequence)localObject5);
                              ((TextView)localObject7).setMaxLines(1);
                            }
                            for (;;)
                            {
                              if (!Util.isNullOrNil((String)localObject3))
                              {
                                ((TextView)localObject7).setVisibility(0);
                                if (j != 0)
                                {
                                  ((TextView)localObject7).setText(t.a((String)localObject3, getContext(), (TextView)localObject7));
                                  break;
                                  localObject3 = new LinearLayout.LayoutParams(-1, -2);
                                  break label13492;
                                  if (((TimeLineObject)localObject8).ContentObj.Zpq == 9)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.Zpr.size() <= 0) {
                                      break label17312;
                                    }
                                    ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                                    ((LinearLayout)localObject6).setOnClickListener(this.RoS.RFy);
                                    i = 0;
                                    j = 0;
                                    break label13582;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.Zpq == 10)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.Zpr.size() <= 0) {
                                      break label17312;
                                    }
                                    ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                                    ((LinearLayout)localObject6).setOnClickListener(this.RoS.RFA);
                                    i = 0;
                                    j = 0;
                                    break label13582;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.Zpq == 17)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.Zpr.size() <= 0) {
                                      break label17312;
                                    }
                                    ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                                    ((LinearLayout)localObject6).setOnClickListener(this.RoS.RFB);
                                    i = 0;
                                    j = 0;
                                    break label13582;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.Zpq == 22)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.Zpr.size() <= 0) {
                                      break label17312;
                                    }
                                    ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                                    ((LinearLayout)localObject6).setOnClickListener(this.RoS.RFC);
                                    i = 0;
                                    j = 0;
                                    break label13582;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.Zpq == 23)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.Zpr.size() <= 0) {
                                      break label17312;
                                    }
                                    ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                                    ((LinearLayout)localObject6).setOnClickListener(this.RoS.RFD);
                                    i = 0;
                                    j = 0;
                                    break label13582;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.Zpq == 14)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.Zpr.size() <= 0) {
                                      break label17312;
                                    }
                                    ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                                    ((LinearLayout)localObject6).setOnClickListener(this.RoS.RFz);
                                    i = 0;
                                    j = 0;
                                    break label13582;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.Zpq == 12)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.Zpr.size() <= 0) {
                                      break label17312;
                                    }
                                    ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                                    ((LinearLayout)localObject6).setOnClickListener(this.RoS.RFJ);
                                    i = 0;
                                    j = 0;
                                    break label13582;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.Zpq == 30)
                                  {
                                    ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                                    ((LinearLayout)localObject6).setOnClickListener(this.RoS.RFH);
                                    i = 0;
                                    j = 0;
                                    break label13582;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.Zpq == 13)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.Zpr.size() <= 0) {
                                      break label17312;
                                    }
                                    ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                                    ((LinearLayout)localObject6).setOnClickListener(this.RoS.RFK);
                                    i = 0;
                                    j = 0;
                                    break label13582;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.Zpq == 15)
                                  {
                                    if (((TimeLineObject)localObject8).ContentObj.Zpr.size() <= 0) {
                                      break label17312;
                                    }
                                    ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                                    ((LinearLayout)localObject6).setOnClickListener(this.PZr.RQu);
                                    i = 0;
                                    j = 0;
                                    break label13582;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.Zpq == 26)
                                  {
                                    ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                                    ((LinearLayout)localObject6).setOnClickListener(this.RoS.RFL);
                                    i = 0;
                                    j = 0;
                                    break label13582;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.Zpq == 41)
                                  {
                                    ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                                    ((LinearLayout)localObject6).setOnClickListener(this.RoS.RFM);
                                    i = 0;
                                    j = 0;
                                    break label13582;
                                  }
                                  ((LinearLayout)localObject6).setTag(new s((TimeLineObject)localObject8, this.RoK));
                                  ((LinearLayout)localObject6).setOnClickListener(this.RoS.Rwb);
                                  if ((((TimeLineObject)localObject8).contentattr & 0x1) <= 0) {
                                    break label17312;
                                  }
                                  i = 0;
                                  j = 1;
                                  break label13582;
                                  this.vEV.c((View)localObject6, this.PZr.RQj, this.PZr.RPU);
                                  break label13610;
                                  localObject5 = "";
                                  break label13629;
                                  if (((TimeLineObject)localObject8).ContentObj.Zpq == 5)
                                  {
                                    localObject5 = bn.baM(((dmz)localObject10).Url);
                                    localObject3 = ((dmz)localObject10).hAP;
                                    ((LinearLayout)localObject6).findViewById(b.f.state).setVisibility(0);
                                    com.tencent.mm.plugin.sns.model.al.hgy().a((dmz)localObject10, (View)localObject7, b.i.app_attach_file_icon_video, hashCode(), br.adkc);
                                    break label13814;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.Zpq == 18)
                                  {
                                    ((LinearLayout)localObject6).findViewById(b.f.state).setVisibility(0);
                                    ((ImageView)((LinearLayout)localObject6).findViewById(b.f.state)).setImageResource(b.e.video_playicon_normal);
                                    ((MMImageView)localObject7).setVisibility(0);
                                    com.tencent.mm.plugin.sns.model.al.hgy().a((dmz)localObject10, (View)localObject7, b.i.app_attach_file_icon_video, hashCode(), br.adkc);
                                    break label13814;
                                  }
                                  com.tencent.mm.plugin.sns.model.al.hgy().b((dmz)localObject10, (View)localObject7, hashCode(), br.adkc);
                                  break label13814;
                                  if (((TimeLineObject)localObject8).ContentObj.Zpq == 18)
                                  {
                                    ((ImageView)((LinearLayout)localObject6).findViewById(b.f.state)).setVisibility(0);
                                    ((ImageView)((LinearLayout)localObject6).findViewById(b.f.state)).setImageResource(b.e.video_playicon_normal);
                                    ((MMImageView)localObject7).setVisibility(0);
                                    com.tencent.mm.plugin.sns.model.al.hgy().c((View)localObject7, -1, b.i.app_attach_file_icon_video, hashCode());
                                    break label13814;
                                  }
                                  if (((TimeLineObject)localObject8).ContentObj.Zpq == 26)
                                  {
                                    ((MMImageView)localObject7).setVisibility(0);
                                    com.tencent.mm.plugin.sns.model.al.hgy().c((View)localObject7, -1, b.i.note_sns_link_default, hashCode());
                                    break label13814;
                                  }
                                  ((MMImageView)localObject7).setVisibility(0);
                                  com.tencent.mm.plugin.sns.model.al.hgy().c((View)localObject7, -1, b.i.app_attach_file_icon_webpage, hashCode());
                                  break label13814;
                                  ((LinearLayout)localObject6).findViewById(b.f.righttext).setVisibility(8);
                                  ((TextView)localObject7).setMaxLines(2);
                                  continue;
                                }
                                ((TextView)localObject7).setText((CharSequence)localObject3);
                                break;
                              }
                            }
                            ((TextView)localObject7).setVisibility(8);
                            break;
                            ((TextView)localObject6).setVisibility(0);
                            if (Util.isNullOrNil((String)localObject3)) {
                              break label3191;
                            }
                            ((TextView)localObject6).setTextColor(getContext().getResources().getColor(b.c.Link));
                            ((TextView)localObject6).setClickable(true);
                            ((TextView)localObject6).setText((CharSequence)localObject3);
                            break label3222;
                            ((TextView)localObject6).setVisibility(8);
                            break label3222;
                            if (((TimeLineObject)localObject8).Location == null)
                            {
                              localObject3 = null;
                              if (((TimeLineObject)localObject8).Location != null) {
                                break label15247;
                              }
                            }
                            for (localObject5 = null;; localObject5 = ((TimeLineObject)localObject8).Location.poiName)
                            {
                              ((TextView)localObject6).setTag(localSnsInfo.getLocalid());
                              if ((!Util.isNullOrNil((String)localObject3)) || (!Util.isNullOrNil((String)localObject5))) {
                                break label15260;
                              }
                              ((TextView)localObject6).setVisibility(8);
                              break;
                              localObject3 = ((TimeLineObject)localObject8).Location.pSh;
                              break label15187;
                            }
                            ((TextView)localObject6).setVisibility(0);
                            if (!Util.isNullOrNil((String)localObject5))
                            {
                              ((TextView)localObject6).setTextColor(getContext().getResources().getColor(b.c.Link));
                              ((TextView)localObject6).setClickable(true);
                              if ((localSnsInfo.field_snsId == 0L) && (!Util.isNullOrNil((String)localObject3)))
                              {
                                ((TextView)localObject6).setText((String)localObject3 + "·" + (String)localObject5);
                                break label3238;
                              }
                              ((TextView)localObject6).setText((CharSequence)localObject5);
                              break label3238;
                            }
                            ((TextView)localObject6).setText((CharSequence)localObject3);
                            ((TextView)localObject6).setClickable(false);
                            ((TextView)localObject6).setTextColor(getContext().getResources().getColor(b.c.desc_text_color));
                            break label3238;
                            if (((ADInfo)localObject9).adActionExtTailType == ADInfo.ADChainStrengthenDefaultWording)
                            {
                              if (!Util.isNullOrNil(((ADInfo)localObject9).adActionExtTailWording))
                              {
                                ((TextView)localObject6).setText(((ADInfo)localObject9).adActionExtTailWording);
                                ((TextView)localObject6).setVisibility(0);
                                break label3415;
                              }
                              ((TextView)localObject6).setVisibility(8);
                              break label3415;
                            }
                            if (((ADInfo)localObject9).adActionExtTailType != ADInfo.ADChainStrengthenUserInfoFormatWording) {
                              break label3415;
                            }
                            if (!Util.isNullOrNil(((ADInfo)localObject9).adActionExtTailWording))
                            {
                              localObject3 = "";
                              localObject10 = ((ADInfo)localObject9).adActionExtUserList.iterator();
                              if (((Iterator)localObject10).hasNext())
                              {
                                localObject11 = (String)((Iterator)localObject10).next();
                                localObject5 = this.RoL.bxv((String)localObject11);
                                if (localObject5 != null)
                                {
                                  localObject5 = ((com.tencent.mm.contact.d)localObject5).aSV();
                                  if (!Util.isNullOrNil((String)localObject5)) {
                                    localObject5 = (String)localObject3 + (String)localObject5;
                                  }
                                }
                                for (;;)
                                {
                                  localObject3 = localObject5;
                                  if (((ADInfo)localObject9).adActionExtUserList.getLast() == localObject11) {
                                    break;
                                  }
                                  localObject3 = (String)localObject5 + ",";
                                  break;
                                  localObject5 = (String)localObject3 + (String)localObject11;
                                  continue;
                                  localObject5 = (String)localObject3 + (String)localObject11;
                                }
                              }
                              localObject5 = String.format(((ADInfo)localObject9).adActionExtTailWording, new Object[] { localObject3 });
                              ((TextView)localObject6).getTextSize();
                              localObject10 = new com.tencent.mm.pluginsdk.ui.span.q(com.tencent.mm.pluginsdk.ui.span.p.e(this, (CharSequence)localObject5, 1));
                              ((com.tencent.mm.pluginsdk.ui.span.q)localObject10).a(null, (CharSequence)localObject5);
                              localObject5 = ((TextView)localObject6).getPaint();
                              if (com.tencent.mm.cd.a.K(this, (int)Layout.getDesiredWidth((CharSequence)localObject10, 0, ((com.tencent.mm.pluginsdk.ui.span.q)localObject10).length(), (TextPaint)localObject5)) > this.RoX)
                              {
                                label15733:
                                if (((String)localObject3).length() <= 1) {
                                  break label3415;
                                }
                                localObject3 = ((String)localObject3).substring(0, ((String)localObject3).length() - 2);
                                localObject10 = String.format(((ADInfo)localObject9).adActionExtTailWording, new Object[] { (String)localObject3 + "..." });
                                ((TextView)localObject6).getTextSize();
                                localObject11 = new com.tencent.mm.pluginsdk.ui.span.q(com.tencent.mm.pluginsdk.ui.span.p.e(this, (CharSequence)localObject10, 1));
                                ((com.tencent.mm.pluginsdk.ui.span.q)localObject11).a(null, (CharSequence)localObject10);
                                i = com.tencent.mm.cd.a.K(this, (int)Layout.getDesiredWidth((CharSequence)localObject11, 0, ((com.tencent.mm.pluginsdk.ui.span.q)localObject11).length(), (TextPaint)localObject5));
                                ((TextView)localObject6).setText((CharSequence)localObject11, TextView.BufferType.SPANNABLE);
                                ((TextView)localObject6).setVisibility(0);
                                if (i > this.RoX) {
                                  break label3414;
                                }
                                break label3415;
                              }
                              ((TextView)localObject6).setText((CharSequence)localObject10, TextView.BufferType.SPANNABLE);
                              ((TextView)localObject6).setVisibility(0);
                              break label3415;
                            }
                            ((TextView)localObject6).setVisibility(8);
                            break label3415;
                            ((TextView)localObject7).setVisibility(8);
                            break label3558;
                            i = 8;
                            break label3589;
                            if (((TimeLineObject)localObject8).ContentObj.Zpq == 30)
                            {
                              localObject3 = ((TimeLineObject)localObject8).weappInfo.username;
                              localObject3 = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy((String)localObject3);
                              if ((localObject3 != null) && (!Util.isNullOrNil(((WxaAttributes)localObject3).field_nickname))) {}
                              for (localObject4 = ((WxaAttributes)localObject3).field_nickname;; localObject4 = getString(com.tencent.mm.plugin.sns.b.j.appbrand_app_name))
                              {
                                localObject3 = localObject4;
                                if (((TimeLineObject)localObject8).weappInfo.subType != 1) {
                                  break;
                                }
                                this.RpB.findViewById(b.f.state).setVisibility(0);
                                localObject3 = localObject4;
                                break;
                              }
                            }
                            if (((TimeLineObject)localObject8).ContentObj.Zpq == 28)
                            {
                              localObject4 = getContext().getResources().getString(com.tencent.mm.plugin.sns.b.j.finder_app_name);
                              localObject3 = localObject4;
                              if (((TimeLineObject)localObject8).ContentObj.hKU == null) {
                                break label3679;
                              }
                              localObject3 = localObject4;
                              if (Util.isNullOrNil(t.e(((TimeLineObject)localObject8).ContentObj.hKU))) {
                                break label3679;
                              }
                              localObject3 = (String)localObject4 + " · " + t.e(((TimeLineObject)localObject8).ContentObj.hKU);
                              break label3679;
                            }
                            if (((TimeLineObject)localObject8).ContentObj.Zpq == 36)
                            {
                              localObject4 = getContext().getResources().getString(com.tencent.mm.plugin.sns.b.j.finder_app_name);
                              localObject3 = localObject4;
                              if (((TimeLineObject)localObject8).ContentObj.Zpy == null) {
                                break label3679;
                              }
                              localObject3 = localObject4;
                              if (Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.Zpy.nickname)) {
                                break label3679;
                              }
                              localObject3 = (String)localObject4 + " · " + ((TimeLineObject)localObject8).ContentObj.Zpy.nickname;
                              break label3679;
                            }
                            if (((TimeLineObject)localObject8).ContentObj.Zpq == 29)
                            {
                              localObject3 = getContext().getResources().getString(com.tencent.mm.plugin.sns.b.j.finder_app_name);
                              break label3679;
                            }
                            if (((TimeLineObject)localObject8).ContentObj.Zpq == 38)
                            {
                              localObject3 = getContext().getResources().getString(com.tencent.mm.plugin.sns.b.j.finder_app_name);
                              break label3679;
                            }
                            if (((TimeLineObject)localObject8).ContentObj.Zpq == 37)
                            {
                              localObject3 = getContext().getResources().getString(com.tencent.mm.plugin.sns.b.j.finder_app_name);
                              break label3679;
                            }
                            if (((TimeLineObject)localObject8).ContentObj.Zpq == 39) {
                              switch (((TimeLineObject)localObject8).ContentObj.nUa)
                              {
                              default: 
                                localObject3 = localObject4;
                                break;
                              case 3: 
                              case 100000000: 
                                localObject3 = getContext().getResources().getString(com.tencent.mm.plugin.sns.b.j.finder_app_name);
                                break;
                              }
                            }
                            if (localSnsInfo.isAd())
                            {
                              localObject3 = localObject4;
                              if (!com.tencent.mm.plugin.sns.ad.d.n.a(localSnsInfo.getAdXml(), localSnsInfo.getAdInfo())) {
                                break label3679;
                              }
                              localObject3 = localSnsInfo.getAdXml();
                              if ((localObject3 != null) && (((ADXml)localObject3).adActionLinkHidden == 1) && (!((ADXml)localObject3).isCardAd()) && (!((ADXml)localObject3).isFullCardAd()))
                              {
                                j = 0;
                                localObject3 = localSnsInfo.getAdInfo();
                                i = j;
                                if (localObject3 != null) {
                                  if (TextUtils.isEmpty(((ADInfo)localObject3).adActionExtTailWording))
                                  {
                                    i = j;
                                    if (TextUtils.isEmpty(((ADInfo)localObject3).adActionExtTailFormattedWording)) {}
                                  }
                                  else
                                  {
                                    i = 1;
                                  }
                                }
                                if (i == 0)
                                {
                                  localObject3 = getContext().getResources().getString(com.tencent.mm.plugin.sns.b.j.finder_app_name);
                                  break label3679;
                                }
                                localObject3 = "";
                                break label3679;
                              }
                              localObject3 = "";
                              break label3679;
                            }
                            localObject3 = localObject4;
                            if (((TimeLineObject)localObject8).ContentObj.Zpq != 1) {
                              break label3679;
                            }
                            localObject3 = localObject4;
                            if (((TimeLineObject)localObject8).ContentObj.DHa == null) {
                              break label3679;
                            }
                            localObject3 = localObject4;
                            if (Util.isNullOrNil(((TimeLineObject)localObject8).ContentObj.DHa.nickName)) {
                              break label3679;
                            }
                            localObject3 = ((TimeLineObject)localObject8).ContentObj.DHa.nickName;
                            break label3679;
                            label16625:
                            ((TextView)localObject5).setVisibility(8);
                            break label3820;
                            label16635:
                            if (((TimeLineObject)localObject8).ContentObj.Zpq != 28) {
                              break label3894;
                            }
                            ((TextView)localObject5).setTextColor(getResources().getColor(b.c.sns_link_color));
                            ((TextView)localObject5).setOnTouchListener(null);
                            if (this.Rou != null)
                            {
                              localObject3 = (Guideline)this.Rou.findViewById(b.f.sns_finder_media_image_count_indicator_guide_line);
                              if (localObject3 != null) {
                                ((Guideline)localObject3).setGuidelineEnd(0);
                              }
                            }
                            ((TextView)localObject5).setTag(localObject8);
                            ((TextView)localObject5).setOnClickListener(new View.OnClickListener()
                            {
                              public final void onClick(View paramAnonymousView)
                              {
                                AppMethodBeat.i(307598);
                                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                                ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
                                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
                                if (!WeChatBrands.Business.Entries.MomentChannels.checkAvailable(paramAnonymousView.getContext()))
                                {
                                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                  AppMethodBeat.o(307598);
                                  return;
                                }
                                Intent localIntent = new Intent();
                                localIntent.putExtra("key_from_profile_share_scene", 3);
                                localIntent.putExtra("key_enter_profile_type", 8);
                                String str1;
                                String str2;
                                if (this.RpR.ContentObj.hKU != null) {
                                  if (Util.isNullOrNil(this.RpR.ContentObj.hKU.username))
                                  {
                                    localIntent.putExtra("finder_username", "");
                                    localIntent.putExtra("key_finder_object_Id", this.RpR.ContentObj.hKU.objectId);
                                    localIntent.putExtra("key_finder_object_nonce_id_key", this.RpR.ContentObj.hKU.objectNonceId);
                                    str1 = Util.nullAsNil(((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN());
                                    str2 = Util.nullAsNil(this.RpR.UserName);
                                    localObject = "";
                                    if (this.RpR.ContentObj.hKU == null) {
                                      break label563;
                                    }
                                    localObject = this.RpR.ContentObj.hKU.objectId;
                                  }
                                }
                                for (;;)
                                {
                                  String str3 = this.RpR.Id;
                                  localObject = str1 + "," + str2 + "," + (String)localObject + "," + str3;
                                  Log.i("MicroMsg.SnsCommentDetailUI", "report20587, ".concat(String.valueOf(localObject)));
                                  com.tencent.mm.plugin.report.service.h.OAn.kvStat(20587, (String)localObject);
                                  localIntent.putExtra("key_finder_teen_mode_check", true);
                                  localIntent.putExtra("key_finder_teen_mode_scene", 3);
                                  localIntent.putExtra("key_finder_teen_mode_user_name", t.e(this.RpR.ContentObj.hKU));
                                  localIntent.putExtra("key_finder_teen_mode_user_id", this.RpR.ContentObj.hKU.username);
                                  localObject = this.RpR.ContentObj.hKU.hUQ;
                                  if (!Util.isNullOrNil(this.RpR.ContentObj.hKU.aacW)) {
                                    localObject = this.RpR.ContentObj.hKU.aacW;
                                  }
                                  localIntent.putExtra("key_biz_username", (String)localObject);
                                  ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 2, 32, localIntent);
                                  ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderProfileUI(paramAnonymousView.getContext(), localIntent);
                                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                  AppMethodBeat.o(307598);
                                  return;
                                  localIntent.putExtra("finder_username", this.RpR.ContentObj.hKU.username);
                                  break;
                                  if (this.RpR.ContentObj.Zpy == null) {
                                    break;
                                  }
                                  localIntent.putExtra("finder_username", "");
                                  localIntent.putExtra("key_finder_object_Id", this.RpR.ContentObj.Zpy.objectId);
                                  localIntent.putExtra("key_finder_object_nonce_id_key", this.RpR.ContentObj.Zpy.objectNonceId);
                                  break;
                                  label563:
                                  if (this.RpR.ContentObj.Zpy != null) {
                                    localObject = this.RpR.ContentObj.Zpy.objectId;
                                  }
                                }
                              }
                            });
                            break label3894;
                            ((TextView)localObject3).setVisibility(8);
                            break label3980;
                            label16737:
                            if (((SnsObject)localObject5).NewWithTaListCount > 0)
                            {
                              ((TextView)localObject6).setVisibility(0);
                              localObject3 = com.tencent.mm.plugin.sns.data.u.Qoz;
                              ((TextView)localObject6).setText(u.a.a(this, this.hQX, this.ltf.equals(((SnsObject)localObject5).Username), ((SnsObject)localObject5).NewWithTaList), TextView.BufferType.SPANNABLE);
                              ((TextView)localObject6).setOnTouchListener(new ai());
                            }
                            for (;;)
                            {
                              if ((localObject5 == null) || (this.ltf == null) || (!this.ltf.equals(((SnsObject)localObject5).Username)) || ((((((SnsObject)localObject5).ExtFlag & 0x2) <= 0) || (((SnsObject)localObject5).BlackList == null)) && (((((SnsObject)localObject5).ExtFlag & 0x4) <= 0) || (((SnsObject)localObject5).GroupUser == null)))) {
                                break label17288;
                              }
                              this.Rou.findViewById(b.f.album_groupid).setVisibility(0);
                              this.Rou.findViewById(b.f.album_groupid).setTag(Integer.valueOf(localSnsInfo.localid));
                              this.Rou.findViewById(b.f.album_groupid).setOnClickListener(new SnsCommentDetailUI.43(this));
                              break;
                              if (((SnsObject)localObject5).WithUserList.size() <= 0)
                              {
                                ((TextView)localObject6).setVisibility(8);
                              }
                              else if (this.ltf.equals(((SnsObject)localObject5).Username))
                              {
                                ((TextView)localObject6).setVisibility(0);
                                localObject7 = ((SnsObject)localObject5).WithUserList.iterator();
                                i = 0;
                                localObject3 = "";
                                if (((Iterator)localObject7).hasNext())
                                {
                                  localObject8 = (fdv)((Iterator)localObject7).next();
                                  if (i == 0)
                                  {
                                    i = 1;
                                    localObject3 = (String)localObject3 + "  ";
                                    if (((fdv)localObject8).Nickname == null) {
                                      break label17106;
                                    }
                                    localObject4 = new StringBuilder().append((String)localObject3);
                                    localObject3 = ((fdv)localObject8).Nickname;
                                  }
                                  for (;;)
                                  {
                                    localObject3 = (String)localObject3;
                                    break;
                                    localObject3 = (String)localObject3 + ",  ";
                                    break label17036;
                                    localObject9 = this.RoL.JE(((fdv)localObject8).Username);
                                    localObject4 = new StringBuilder().append((String)localObject3);
                                    if (localObject9 == null) {
                                      localObject3 = ((fdv)localObject8).Username;
                                    } else {
                                      localObject3 = ((com.tencent.mm.contact.d)localObject9).aSV();
                                    }
                                  }
                                }
                                ((TextView)localObject6).setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, getString(com.tencent.mm.plugin.sns.b.j.sns_timeline_ui_with_to, new Object[] { localObject3 }), ((TextView)localObject6).getTextSize()));
                              }
                              else
                              {
                                ((TextView)localObject6).setVisibility(8);
                                localObject3 = ((SnsObject)localObject5).WithUserList.iterator();
                                if (((Iterator)localObject3).hasNext())
                                {
                                  localObject4 = (fdv)((Iterator)localObject3).next();
                                  if (!this.ltf.equals(((fdv)localObject4).Username)) {
                                    break label16800;
                                  }
                                  ((TextView)localObject6).setVisibility(0);
                                  localObject3 = getString(com.tencent.mm.plugin.sns.b.j.sns_timeline_ui_with_you);
                                  ((TextView)localObject6).setVisibility(0);
                                  ((TextView)localObject6).setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject3, ((TextView)localObject6).getTextSize()));
                                }
                              }
                            }
                            this.Rou.findViewById(b.f.album_groupid).setVisibility(8);
                            break label4014;
                          }
                        }
                        i = 0;
                        j = 0;
                      }
                    }
                    localObject3 = "";
                  }
                  break label9436;
                }
                localObject3 = "";
              }
              localObject6 = "";
            }
          }
        }
        localObject4 = localObject3;
        break;
      }
      label5596:
      label6367:
      label17379:
      bool = false;
      label7771:
      label8796:
      label9436:
      continue;
      label12243:
      label15187:
      label16727:
      label17385:
      bool = true;
    }
  }
  
  public void initView()
  {
    AppMethodBeat.i(98599);
    setMMTitle(com.tencent.mm.plugin.sns.b.j.sns_comment_detial_ui_title);
    setToTop(new SnsCommentDetailUI.26(this));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(307800);
        if (SnsCommentDetailUI.c(SnsCommentDetailUI.this) != null) {
          SnsCommentDetailUI.c(SnsCommentDetailUI.this).wh(false);
        }
        SnsCommentDetailUI.this.finish();
        AppMethodBeat.o(307800);
        return true;
      }
    });
    this.ltf = com.tencent.mm.model.z.bAM();
    if (com.tencent.mm.plugin.sns.model.al.isInValid()) {
      finish();
    }
    final SnsInfo localSnsInfo = Eh(true);
    if (localSnsInfo == null)
    {
      Log.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.hQX);
      finish();
      AppMethodBeat.o(98599);
      return;
    }
    Log.i("MicroMsg.SnsCommentDetailUI", "snsId: " + this.hQX + "localId " + this.RoK + "  username:" + localSnsInfo.getUserName());
    Object localObject1 = (TextView)findViewById(b.f.content_collapse_hint);
    if (this.Rpe)
    {
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(this.Rpf);
      if ((com.tencent.mm.plugin.sns.storage.ai.baq(this.hQX)) || (!localSnsInfo.isDieItem())) {
        break label769;
      }
      localObject1 = localSnsInfo.getPostInfo();
      findViewById(b.f.sns_post_again_ll).setVisibility(0);
      localObject2 = (TextView)findViewById(b.f.post_error_tv);
      switch (((dna)localObject1).aaTP)
      {
      default: 
        if (!Util.isNullOrNil(((dna)localObject1).aaTW))
        {
          ((TextView)localObject2).setText(((dna)localObject1).aaTW);
          if (((dna)localObject1).aaTP == 2006)
          {
            findViewById(b.f.sns_post_again_btn).setVisibility(0);
            findViewById(b.f.sns_post_btn).setVisibility(8);
            i = 1;
            label333:
            localObject1 = new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(308247);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                if (localSnsInfo.isAd())
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(308247);
                  return;
                }
                if (localSnsInfo.getPostInfo().aaTP == 2006)
                {
                  SnsCommentDetailUI.a(SnsCommentDetailUI.this, paramAnonymousView.getContext(), localSnsInfo);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(308247);
                  return;
                }
                ap.akJ(localSnsInfo.localid);
                ap.akI(localSnsInfo.localid);
                com.tencent.mm.plugin.sns.model.al.hgx().hej();
                paramAnonymousView = new Intent();
                SnsCommentDetailUI.this.setResult(-1, paramAnonymousView);
                if (SnsCommentDetailUI.z(SnsCommentDetailUI.this)) {
                  paramAnonymousView.putExtra("sns_gallery_force_finish", true);
                }
                SnsCommentDetailUI.this.finish();
                SnsCommentDetailUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(308247);
              }
            };
            if (i != 0)
            {
              findViewById(b.f.sns_post_again_ll).setOnClickListener((View.OnClickListener)localObject1);
              findViewById(b.f.sns_post_again_btn).setOnClickListener((View.OnClickListener)localObject1);
            }
            this.Roy = ((ListView)findViewById(b.f.album_comment_list));
            this.Roy.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(98554);
                SnsCommentDetailUI.a(SnsCommentDetailUI.this, SnsCommentDetailUI.a(SnsCommentDetailUI.this).getBottom());
                Log.d("MicroMsg.SnsCommentDetailUI", "listOriginalBottom: " + SnsCommentDetailUI.d(SnsCommentDetailUI.this));
                AppMethodBeat.o(98554);
              }
            });
            this.Roy.setOnScrollListener(new AbsListView.OnScrollListener()
            {
              public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
              {
                AppMethodBeat.i(308256);
                if (paramAnonymousInt2 > 0) {
                  if ((paramAnonymousInt1 == 0) && (!SnsCommentDetailUI.A(SnsCommentDetailUI.this)))
                  {
                    SnsCommentDetailUI.b(SnsCommentDetailUI.this, true);
                    if (SnsCommentDetailUI.p(SnsCommentDetailUI.this) != null)
                    {
                      SnsCommentDetailUI.p(SnsCommentDetailUI.this).refreshView();
                      AppMethodBeat.o(308256);
                      return;
                    }
                    if (SnsCommentDetailUI.B(SnsCommentDetailUI.this) != null)
                    {
                      SnsCommentDetailUI.this.hoq();
                      AppMethodBeat.o(308256);
                    }
                  }
                  else if (paramAnonymousInt1 > 0)
                  {
                    SnsCommentDetailUI.b(SnsCommentDetailUI.this, false);
                  }
                }
                AppMethodBeat.o(308256);
              }
              
              public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
              {
                AppMethodBeat.i(308257);
                if (paramAnonymousInt == 1)
                {
                  SnsCommentDetailUI.this.hideVKB();
                  SnsCommentDetailUI.C(SnsCommentDetailUI.this);
                }
                if ((paramAnonymousInt == 0) && (SnsCommentDetailUI.e(SnsCommentDetailUI.this) != null)) {
                  SnsCommentDetailUI.e(SnsCommentDetailUI.this).Ds(true);
                }
                AppMethodBeat.o(308257);
              }
            });
            localObject1 = Eh(false);
            localObject2 = af.mU(getContext());
            if ((!com.tencent.mm.ui.aw.jkS()) || (ag.aAk(getTaskId()))) {
              break label786;
            }
          }
        }
        break;
      }
    }
    label769:
    label786:
    for (int i = b.g.sns_comment_detail_header_large;; i = b.g.sns_comment_detail_header)
    {
      this.Rou = ((LayoutInflater)localObject2).inflate(i, null);
      this.RoA = this.Rou.findViewById(b.f.images_keeper_linear_layout);
      this.Rou.setOnClickListener(this.Rpx);
      this.Roy.addHeaderView(this.Rou);
      boolean bool = hoq();
      if (bool) {
        break label793;
      }
      Log.i("MicroMsg.SnsCommentDetailUI", "error isOk setheader ".concat(String.valueOf(bool)));
      finish();
      AppMethodBeat.o(98599);
      return;
      ((TextView)localObject1).setVisibility(8);
      break;
      if (!Util.isNullOrNil(((dna)localObject1).aaTW)) {
        ((TextView)localObject2).setText(((dna)localObject1).aaTW);
      }
      for (;;)
      {
        findViewById(b.f.sns_post_btn).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(com.tencent.mm.plugin.sns.b.j.sns_post_error_ban_again);
      }
      if (!Util.isNullOrNil(((dna)localObject1).aaTW)) {
        ((TextView)localObject2).setText(((dna)localObject1).aaTW);
      }
      for (;;)
      {
        findViewById(b.f.sns_post_btn).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(com.tencent.mm.plugin.sns.b.j.sns_post_error_to_long_again);
      }
      if (!Util.isNullOrNil(((dna)localObject1).aaTW)) {
        ((TextView)localObject2).setText(((dna)localObject1).aaTW);
      }
      for (;;)
      {
        findViewById(b.f.sns_post_btn).setVisibility(8);
        i = 1;
        break;
        ((TextView)localObject2).setText(com.tencent.mm.plugin.sns.b.j.sns_post_error_ten_min_again);
      }
      findViewById(b.f.sns_post_btn).setVisibility(0);
      i = 1;
      break label333;
      if (localSnsInfo.getTypeFlag() == 28)
      {
        ((TextView)localObject2).setText(com.tencent.mm.plugin.sns.b.j.sns_post_finder_media_error);
        findViewById(b.f.sns_post_btn).setVisibility(8);
        i = 0;
        break label333;
      }
      ((TextView)localObject2).setText(com.tencent.mm.plugin.sns.b.j.sns_post_error_touch_again);
      findViewById(b.f.sns_post_btn).setVisibility(0);
      i = 1;
      break label333;
      findViewById(b.f.sns_post_again_ll).setVisibility(8);
      i = 0;
      break label333;
    }
    label793:
    if (localObject1 != null) {
      this.viewType = bn.g((SnsInfo)localObject1, false);
    }
    if ((this.viewType == 10) && (com.tencent.mm.model.z.bAM().equals(localSnsInfo.field_userName)))
    {
      this.Rox = new SnsDetailLuckyHeader(this);
      localObject1 = new AbsListView.LayoutParams(-1, -2);
      this.Rox.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.Rox.setOnClickListener(this.Rpx);
    }
    this.Row = new LinearLayout(getContext());
    localObject1 = new AbsListView.LayoutParams(-1, -2);
    this.Row.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.Row.setOnClickListener(this.Rpx);
    BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 2.0F);
    localObject1 = new AbsListView.LayoutParams(-1, 1);
    Object localObject2 = new LinearLayout(getContext());
    ((LinearLayout)localObject2).setBackgroundResource(b.e.sns_divider_line);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.Qqi = ((LinearLayout)localObject2);
    f(localSnsInfo, true);
    if (this.Rox != null)
    {
      this.Rpb = true;
      this.Roy.addHeaderView(this.Rox);
    }
    localObject2 = ap.D(localSnsInfo);
    label1142:
    fdv localfdv;
    label1318:
    label1376:
    long l;
    if (localObject2 == null)
    {
      this.Row.setVisibility(8);
      this.RoB = new b(new LinkedList(), new LinkedList(), this, localSnsInfo.getLocalid());
      this.Roy.addHeaderView(this.Row);
      this.Roy.setAdapter(this.RoB);
      this.RbA = ((SnsCommentFooter)findViewById(b.f.comment_footer));
      if ((localSnsInfo == null) || (localSnsInfo.getTimeLine() == null) || (localSnsInfo.getTimeLine().ContentObj == null) || ((localSnsInfo.getTimeLine().ContentObj.Zps & 0x80) != 0)) {
        break label1902;
      }
      this.RbA.setFeedEmojiCommentEnable(true);
      this.RbA.setTag(localSnsInfo);
      this.RbA.setOnEditTouchListener(new SnsCommentFooter.a()
      {
        public final void hov()
        {
          AppMethodBeat.i(307913);
          if (!com.tencent.mm.plugin.sns.lucky.a.m.aXP(localSnsInfo.getLocalid()))
          {
            if ((SnsCommentDetailUI.D(SnsCommentDetailUI.this) != null) && (SnsCommentDetailUI.D(SnsCommentDetailUI.this).isShowing()))
            {
              AppMethodBeat.o(307913);
              return;
            }
            SnsCommentDetailUI.a(SnsCommentDetailUI.this, com.tencent.mm.plugin.sns.lucky.ui.a.h(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.RpD.alP(0)));
            AppMethodBeat.o(307913);
            return;
          }
          if ((SnsCommentDetailUI.this.keyboardState() == 1) || (SnsCommentDetailUI.c(SnsCommentDetailUI.this).hox()))
          {
            AppMethodBeat.o(307913);
            return;
          }
          SnsCommentDetailUI.r(SnsCommentDetailUI.this);
          AppMethodBeat.o(307913);
        }
      });
      this.RbA.setOnSmileyShowListener(new SnsCommentFooter.c()
      {
        public final void onShow()
        {
          AppMethodBeat.i(307923);
          if (SnsCommentDetailUI.c(SnsCommentDetailUI.this).RqD)
          {
            AppMethodBeat.o(307923);
            return;
          }
          SnsCommentDetailUI.r(SnsCommentDetailUI.this);
          AppMethodBeat.o(307923);
        }
      });
      localObject1 = Eh(true);
      if ((localObject1 != null) && (!((SnsInfo)localObject1).isExtFlag())) {
        this.RbA.setVisibility(8);
      }
      this.RbA.setAfterEditAction(this.Rpw);
      this.RbA.hoy();
      this.RbA.setOnCommentSendImp(new SnsCommentFooter.b()
      {
        public final void mU(String paramAnonymousString1, String paramAnonymousString2)
        {
          int j = 8;
          AppMethodBeat.i(307921);
          if (Util.isNullOrNil(paramAnonymousString1))
          {
            AppMethodBeat.o(307921);
            return;
          }
          if (!com.tencent.mm.plugin.sns.lucky.a.m.aXP(localSnsInfo.getLocalid()))
          {
            if (SnsCommentDetailUI.this.RpD.alP(0) != null) {
              com.tencent.mm.plugin.sns.lucky.ui.a.h(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.RpD.alP(0));
            }
            AppMethodBeat.o(307921);
            return;
          }
          if (localSnsInfo.isAd()) {}
          for (int i = SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentFlag();; i = 0)
          {
            if (com.tencent.mm.plugin.sns.ui.widget.g.lU(i, 8))
            {
              paramAnonymousString1 = paramAnonymousString1.substring(SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentAtPrefix().length());
              Log.i("MicroMsg.SnsCommentDetailUI", "send atFriend ad detail comment");
              ar.a.a(localSnsInfo, 16, paramAnonymousString1, SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentInfo(), i, SnsCommentDetailUI.this.getSource(), paramAnonymousString2);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setText("");
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).wh(false);
              Log.i("MicroMsg.SnsCommentDetailUI", "comment send imp!");
              SnsCommentDetailUI.E(SnsCommentDetailUI.this);
              com.tencent.mm.plugin.sns.statistics.j.QFS.hip().jeV = 3L;
              SnsCommentDetailUI.C(SnsCommentDetailUI.this);
              AppMethodBeat.o(307921);
              return;
            }
            Log.i("MicroMsg.SnsCommentDetailUI", "send detail comment");
            SnsInfo localSnsInfo = localSnsInfo;
            if (localSnsInfo.isAd()) {}
            for (;;)
            {
              ar.a.a(localSnsInfo, j, paramAnonymousString1, SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentInfo(), i, SnsCommentDetailUI.this.getSource(), paramAnonymousString2);
              break;
              j = 2;
            }
          }
        }
      });
      this.RbA.setSnsInfo(localSnsInfo);
      localObject1 = localSnsInfo.getTimeLine();
      if ((!Tiger2022Helper.h((TimeLineObject)localObject1)) || (!Tiger2022Helper.kLN())) {
        break label1913;
      }
      this.RbA.setCommentHint(getString(com.tencent.mm.plugin.sns.b.j.sns_tiger2022_comment_hint, new Object[] { Integer.valueOf(Tiger2022Helper.bC(((TimeLineObject)localObject1).ContentDesc)) }));
      this.RbA.setSnsInfo(localSnsInfo);
      this.RoQ = getIntent().getBooleanExtra("INTENT_FROMSUI", false);
      if (this.RoQ)
      {
        this.RoR = getIntent().getLongExtra("INTENT_FROMSUI_COMMENTID", 0L);
        if ((this.RoR != 0L) && (this.RoB.commentList != null))
        {
          i = 0;
          if (i < this.RoB.commentList.size())
          {
            localfdv = (fdv)this.RoB.commentList.get(i);
            if (localfdv.abDh == 0) {
              break label1930;
            }
            l = localfdv.abDh;
            label1422:
            if (l != this.RoR) {
              break label1968;
            }
            this.Roy.setSelection(i);
            localObject1 = this.RoL.JE(localfdv.Username);
            if (localObject1 == null) {
              break label1940;
            }
            localObject1 = ((com.tencent.mm.contact.d)localObject1).aSV();
            label1468:
            this.RbA.Rqx = 0;
            this.RbA.hoz();
            this.RbA.setCommentHint(getString(com.tencent.mm.plugin.sns.b.j.sns_reply) + (String)localObject1);
            this.RbA.setCommentInfo(localfdv);
            if (((SnsObject)localObject2).LikeUserList.size() <= 0) {
              break label2007;
            }
            int j = i + 1;
            i = j;
            if (j > this.RoB.getCount()) {
              i = this.RoB.getCount() - 1;
            }
          }
        }
      }
    }
    label1930:
    label1940:
    label1968:
    label2007:
    for (;;)
    {
      this.Rpw.bwS = i;
      if (this.RoQ) {
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(307787);
            SnsCommentDetailUI.this.hideVKB();
            SnsCommentDetailUI.l(SnsCommentDetailUI.this).dpX = SnsCommentDetailUI.F(SnsCommentDetailUI.this);
            SnsCommentDetailUI.l(SnsCommentDetailUI.this).run();
            AppMethodBeat.o(307787);
          }
        }, 100L);
      }
      this.Rpa = ((SnsTranslateResultView)this.Rou.findViewById(b.f.sns_translate_result_view));
      this.Rpa.setResultTextSize(((TextView)this.Rou.findViewById(b.f.desc_tv)).getTextSize());
      this.Rpa.getResultTextView().setBackgroundResource(b.e.sns_clickable_bg);
      localObject1 = new bj(this.hQX, localSnsInfo.getLocalid(), false, true, 2);
      this.Rpa.getResultTextView().setTag(localObject1);
      this.vEV.c(this.Rpa.getResultTextView(), this.PZr.RPX, this.PZr.RPU);
      if (av.gY(this.hQX, 4))
      {
        localObject1 = av.aYE(this.hQX);
        if ((localObject1 != null) && (((av.b)localObject1).ooe))
        {
          this.Rpa.setVisibility(0);
          this.Rpa.a(null, 1, ((av.b)localObject1).result, ((av.b)localObject1).brand, false);
          AppMethodBeat.o(98599);
          return;
          this.RoG = ((SnsObject)localObject2).LikeUserList;
          D(((SnsObject)localObject2).LikeUserList, ((SnsObject)localObject2).CommentUserList.isEmpty());
          if (this.Rox != null) {
            this.Rox.a(localSnsInfo, this.PZr);
          }
          this.RoB = new b(((SnsObject)localObject2).CommentUserList, ((SnsObject)localObject2).LikeUserList, this, localSnsInfo.getLocalid());
          if (!this.Rpi) {
            break;
          }
          com.tencent.mm.plugin.sns.statistics.j.QFS.hip().jeT = ((SnsObject)localObject2).CommentUserList.size();
          com.tencent.mm.plugin.sns.statistics.j.QFS.hip().jeU = ((SnsObject)localObject2).LikeUserList.size();
          break;
          label1902:
          this.RbA.setFeedEmojiCommentEnable(false);
          break label1142;
          label1913:
          this.RbA.setCommentHint(getString(com.tencent.mm.plugin.sns.b.j.sns_ui_comment));
          break label1318;
          l = localfdv.abDj;
          break label1422;
          if (localfdv.Nickname != null)
          {
            localObject1 = localfdv.Nickname;
            break label1468;
          }
          localObject1 = localfdv.Username;
          break label1468;
          i += 1;
          break label1376;
        }
        this.Rpa.setVisibility(8);
        AppMethodBeat.o(98599);
        return;
      }
      this.Rpa.setVisibility(8);
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
      if ((this.PZr != null) && (this.PZr.RPU != null)) {
        this.PZr.RPU.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      AppMethodBeat.o(98610);
      return;
    }
    if (paramInt1 == 16)
    {
      Log.i("MicroMsg.SnsCommentDetailUI", "REQUEST_CODE_FOR_FULLSCREEN");
      paramIntent = new kh();
      paramIntent.hLT.scene = 1;
      paramIntent.publish();
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
            this.RbA.evh();
            String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(paramIntent[0]);
            if (!Util.isNullOrNil(str))
            {
              this.RbA.hoz();
              this.RbA.setText("@" + str + " ");
              this.RbA.setCommentAtPrefix("@" + str + " ");
              this.RbA.setCommentInfo(new fdv());
              this.RbA.getCommentInfo().Username = paramIntent[0];
              this.RbA.setCommentFlag(8);
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
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aYi(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98609);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = com.tencent.mm.plugin.sns.storage.l.aZK(this.hQX);
    Object localObject = ap.D(paramConfiguration);
    D(((SnsObject)localObject).LikeUserList, ((SnsObject)localObject).CommentUserList.isEmpty());
    if (this.Rox != null) {
      this.Rox.a(paramConfiguration, this.PZr);
    }
    paramConfiguration = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    localObject = new Point();
    ((Point)localObject).x = paramConfiguration.widthPixels;
    ((Point)localObject).y = paramConfiguration.heightPixels;
    com.tencent.mm.plugin.sns.model.al.m((Point)localObject);
    if (this.RpD != null)
    {
      this.RoU = com.tencent.mm.plugin.sns.model.al.hgP();
      this.RpD.setImageViewWidth(this.RoU);
    }
    AppMethodBeat.o(98609);
  }
  
  /* Error */
  public void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 4323
    //   3: invokestatic 275	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 4327	com/tencent/mm/ui/aw:bW	(Landroid/app/Activity;)V
    //   10: aload_0
    //   11: invokestatic 4332	com/tencent/mm/pluginsdk/h:w	(Lcom/tencent/mm/ui/MMActivity;)V
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 4334	com/tencent/mm/plugin/secdata/ui/MMSecDataActivity:onCreate	(Landroid/os/Bundle;)V
    //   19: aload_0
    //   20: ldc_w 4336
    //   23: invokestatic 3403	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   26: checkcast 4336	com/tencent/mm/plugin/story/api/e
    //   29: invokeinterface 4340 1 0
    //   34: getstatic 4346	com/tencent/mm/plugin/story/api/f$a:Sih	Lcom/tencent/mm/plugin/story/api/f$a;
    //   37: invokeinterface 4351 2 0
    //   42: putfield 374	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Qun	Z
    //   45: aload_0
    //   46: ldc_w 4336
    //   49: invokestatic 3403	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   52: checkcast 4336	com/tencent/mm/plugin/story/api/e
    //   55: invokeinterface 4340 1 0
    //   60: getstatic 4354	com/tencent/mm/plugin/story/api/f$a:Sii	Lcom/tencent/mm/plugin/story/api/f$a;
    //   63: invokeinterface 4351 2 0
    //   68: putfield 376	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Qup	Z
    //   71: aload_0
    //   72: iconst_1
    //   73: invokestatic 4359	com/tencent/mm/ui/c:h	(Landroid/app/Activity;Z)V
    //   76: aload_0
    //   77: aload_0
    //   78: invokevirtual 638	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   81: invokevirtual 886	androidx/appcompat/app/AppCompatActivity:getResources	()Landroid/content/res/Resources;
    //   84: getstatic 4362	com/tencent/mm/plugin/sns/b$c:BW_97	I
    //   87: invokevirtual 895	android/content/res/Resources:getColor	(I)I
    //   90: invokevirtual 4365	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:setNavigationbarColor	(I)V
    //   93: invokestatic 4369	com/tencent/mm/plugin/sns/model/al:hgr	()Lcom/tencent/mm/plugin/sns/model/ar$a;
    //   96: iconst_5
    //   97: ldc_w 4371
    //   100: aload_0
    //   101: invokevirtual 4374	com/tencent/mm/plugin/sns/model/ar$a:a	(ILjava/lang/String;Lcom/tencent/mm/plugin/sns/c/k$a;)V
    //   104: iconst_2
    //   105: invokestatic 4379	com/tencent/mm/plugin/sns/ad/timeline/b/b/a:ajL	(I)V
    //   108: aload_0
    //   109: aload_0
    //   110: bipush 14
    //   112: invokestatic 4382	com/tencent/mm/ui/bd:fromDPToPix	(Landroid/content/Context;I)I
    //   115: putfield 372	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rpj	I
    //   118: aload_0
    //   119: invokestatic 4386	com/tencent/mm/ui/aw:bf	(Landroid/content/Context;)Landroid/graphics/Point;
    //   122: astore_1
    //   123: aload_0
    //   124: aload_1
    //   125: getfield 4310	android/graphics/Point:x	I
    //   128: putfield 4388	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenWidth	I
    //   131: aload_0
    //   132: aload_1
    //   133: getfield 4315	android/graphics/Point:y	I
    //   136: putfield 4390	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenHeight	I
    //   139: aload_0
    //   140: invokestatic 4396	java/lang/System:currentTimeMillis	()J
    //   143: putfield 320	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Ros	J
    //   146: aload_0
    //   147: new 2183	com/tencent/mm/ui/widget/b/a
    //   150: dup
    //   151: aload_0
    //   152: invokespecial 4397	com/tencent/mm/ui/widget/b/a:<init>	(Landroid/content/Context;)V
    //   155: putfield 1026	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:vEV	Lcom/tencent/mm/ui/widget/b/a;
    //   158: aload_0
    //   159: aload_0
    //   160: invokevirtual 3061	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   163: ldc_w 4399
    //   166: iconst_0
    //   167: invokevirtual 4403	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   170: putfield 1907	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rph	I
    //   173: aload_0
    //   174: aload_0
    //   175: invokevirtual 3061	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   178: ldc_w 4405
    //   181: iconst_0
    //   182: invokevirtual 3069	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   185: putfield 370	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rpi	Z
    //   188: aload_0
    //   189: getfield 370	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rpi	Z
    //   192: ifeq +10 -> 202
    //   195: getstatic 1402	com/tencent/mm/plugin/sns/statistics/j:QFS	Lcom/tencent/mm/plugin/sns/statistics/j;
    //   198: invokevirtual 4408	com/tencent/mm/plugin/sns/statistics/j:hir	()Lcom/tencent/mm/autogen/mmdata/rpt/ni;
    //   201: pop
    //   202: getstatic 2347	com/tencent/mm/plugin/sns/j/a:QCu	Lcom/tencent/mm/plugin/sns/j/a$a;
    //   205: astore_1
    //   206: aload_0
    //   207: invokestatic 4411	com/tencent/mm/plugin/sns/j/a$a:jQ	(Landroid/content/Context;)V
    //   210: aload_0
    //   211: aload_0
    //   212: invokevirtual 3061	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   215: ldc_w 4413
    //   218: invokevirtual 4220	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   221: ldc_w 344
    //   224: invokestatic 2058	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   227: putfield 987	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:hQX	Ljava/lang/String;
    //   230: aload_0
    //   231: getfield 987	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:hQX	Ljava/lang/String;
    //   234: invokestatic 961	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   237: ifeq +24 -> 261
    //   240: aload_0
    //   241: ldc_w 4415
    //   244: aload_0
    //   245: invokevirtual 3061	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   248: ldc_w 4413
    //   251: lconst_0
    //   252: invokevirtual 4138	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   255: invokestatic 4419	com/tencent/mm/plugin/sns/storage/ai:bE	(Ljava/lang/String;J)Ljava/lang/String;
    //   258: putfield 987	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:hQX	Ljava/lang/String;
    //   261: aload_0
    //   262: aload_0
    //   263: invokevirtual 3061	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   266: ldc_w 4421
    //   269: invokevirtual 4220	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   272: ldc_w 344
    //   275: invokestatic 2058	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   278: putfield 957	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RoK	Ljava/lang/String;
    //   281: aload_0
    //   282: getfield 957	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RoK	Ljava/lang/String;
    //   285: invokestatic 961	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   288: ifeq +32 -> 320
    //   291: aload_0
    //   292: invokevirtual 3061	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   295: ldc_w 4421
    //   298: iconst_m1
    //   299: invokevirtual 4403	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   302: istore_2
    //   303: iload_2
    //   304: iconst_m1
    //   305: if_icmpeq +15 -> 320
    //   308: aload_0
    //   309: ldc_w 4415
    //   312: iload_2
    //   313: i2l
    //   314: invokestatic 4419	com/tencent/mm/plugin/sns/storage/ai:bE	(Ljava/lang/String;J)Ljava/lang/String;
    //   317: putfield 957	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RoK	Ljava/lang/String;
    //   320: getstatic 4427	com/tencent/mm/plugin/comm/b/e:xfd	Lcom/tencent/mm/plugin/comm/b/e$a;
    //   323: getstatic 4433	com/tencent/mm/plugin/comm/b/b:xeP	Lcom/tencent/mm/plugin/comm/b/b;
    //   326: invokevirtual 4436	com/tencent/mm/plugin/comm/b/b:name	()Ljava/lang/String;
    //   329: aload_0
    //   330: getfield 987	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:hQX	Ljava/lang/String;
    //   333: ldc_w 4437
    //   336: getstatic 4443	com/tencent/mm/autogen/mmdata/rpt/MomentsTogetherTailActionStruct$a:iVj	Lcom/tencent/mm/autogen/mmdata/rpt/MomentsTogetherTailActionStruct$a;
    //   339: invokevirtual 4448	com/tencent/mm/plugin/comm/b/e$a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   342: getstatic 4427	com/tencent/mm/plugin/comm/b/e:xfd	Lcom/tencent/mm/plugin/comm/b/e$a;
    //   345: getstatic 4433	com/tencent/mm/plugin/comm/b/b:xeP	Lcom/tencent/mm/plugin/comm/b/b;
    //   348: invokevirtual 4436	com/tencent/mm/plugin/comm/b/b:name	()Ljava/lang/String;
    //   351: aload_0
    //   352: getfield 987	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:hQX	Ljava/lang/String;
    //   355: ldc_w 4450
    //   358: aload_0
    //   359: getfield 987	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:hQX	Ljava/lang/String;
    //   362: invokestatic 1353	com/tencent/mm/plugin/sns/storage/ai:aXe	(Ljava/lang/String;)J
    //   365: invokestatic 2140	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   368: invokevirtual 4448	com/tencent/mm/plugin/comm/b/e$a:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   371: aload_0
    //   372: new 16	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$10
    //   375: dup
    //   376: aload_0
    //   377: aload_0
    //   378: invokevirtual 1043	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   381: aload_0
    //   382: aload_0
    //   383: getfield 391	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rpp	Lcom/tencent/mm/plugin/sns/model/am;
    //   386: invokespecial 4453	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$10:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;ILandroid/app/Activity;Lcom/tencent/mm/plugin/sns/model/ak;)V
    //   389: putfield 1003	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:PZr	Lcom/tencent/mm/plugin/sns/ui/listener/c;
    //   392: aload_0
    //   393: getstatic 4456	com/tencent/mm/plugin/sns/b$f:timeline_root	I
    //   396: invokevirtual 1597	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:findViewById	(I)Landroid/view/View;
    //   399: checkcast 2943	android/widget/FrameLayout
    //   402: astore_1
    //   403: aload_0
    //   404: new 4458	com/tencent/mm/plugin/sns/i/b
    //   407: dup
    //   408: aload_0
    //   409: aload_0
    //   410: getfield 1003	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:PZr	Lcom/tencent/mm/plugin/sns/ui/listener/c;
    //   413: aload_1
    //   414: invokespecial 4461	com/tencent/mm/plugin/sns/i/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/listener/c;Landroid/widget/FrameLayout;)V
    //   417: putfield 4463	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RbJ	Lcom/tencent/mm/plugin/sns/i/b;
    //   420: aload_0
    //   421: new 4465	com/tencent/mm/plugin/sns/ui/b
    //   424: dup
    //   425: aload_0
    //   426: aload_0
    //   427: getfield 1003	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:PZr	Lcom/tencent/mm/plugin/sns/ui/listener/c;
    //   430: aload_1
    //   431: aload_0
    //   432: getfield 4463	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RbJ	Lcom/tencent/mm/plugin/sns/i/b;
    //   435: invokespecial 4468	com/tencent/mm/plugin/sns/ui/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/listener/c;Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/sns/i/b;)V
    //   438: putfield 1818	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RbI	Lcom/tencent/mm/plugin/sns/ui/b;
    //   441: aload_0
    //   442: new 4470	com/tencent/mm/plugin/sns/ui/as
    //   445: dup
    //   446: aload_0
    //   447: aload_0
    //   448: getfield 1003	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:PZr	Lcom/tencent/mm/plugin/sns/ui/listener/c;
    //   451: aload_1
    //   452: invokespecial 4471	com/tencent/mm/plugin/sns/ui/as:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/listener/c;Landroid/widget/FrameLayout;)V
    //   455: putfield 1822	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RbK	Lcom/tencent/mm/plugin/sns/ui/as;
    //   458: aload_0
    //   459: new 4473	com/tencent/mm/plugin/sns/ui/by
    //   462: dup
    //   463: aload_0
    //   464: aload_0
    //   465: getfield 1003	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:PZr	Lcom/tencent/mm/plugin/sns/ui/listener/c;
    //   468: aload_1
    //   469: invokespecial 4474	com/tencent/mm/plugin/sns/ui/by:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/listener/c;Landroid/widget/FrameLayout;)V
    //   472: putfield 1917	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RbL	Lcom/tencent/mm/plugin/sns/ui/by;
    //   475: aload_0
    //   476: getfield 1003	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:PZr	Lcom/tencent/mm/plugin/sns/ui/listener/c;
    //   479: invokevirtual 4477	com/tencent/mm/plugin/sns/ui/listener/c:fSy	()V
    //   482: aload_0
    //   483: aload_0
    //   484: invokevirtual 3061	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   487: ldc_w 4479
    //   490: iconst_0
    //   491: invokevirtual 3069	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   494: putfield 364	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rpe	Z
    //   497: aload_0
    //   498: aload_0
    //   499: invokevirtual 3061	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   502: ldc_w 4481
    //   505: invokevirtual 4220	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   508: putfield 366	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rpf	Ljava/lang/String;
    //   511: aload_0
    //   512: new 1677	com/tencent/mm/plugin/sns/ui/bv
    //   515: dup
    //   516: aload_0
    //   517: new 18	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$11
    //   520: dup
    //   521: aload_0
    //   522: invokespecial 4482	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$11:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   525: aload_0
    //   526: invokevirtual 1043	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   529: aload_0
    //   530: getfield 391	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rpp	Lcom/tencent/mm/plugin/sns/model/am;
    //   533: invokespecial 4485	com/tencent/mm/plugin/sns/ui/bv:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/bv$a;ILcom/tencent/mm/plugin/sns/model/ak;)V
    //   536: putfield 1716	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RoS	Lcom/tencent/mm/plugin/sns/ui/bv;
    //   539: invokestatic 4396	java/lang/System:currentTimeMillis	()J
    //   542: lstore_3
    //   543: aload_0
    //   544: invokevirtual 3061	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   547: ldc_w 4487
    //   550: invokevirtual 4491	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   553: astore_1
    //   554: aload_1
    //   555: ifnull +184 -> 739
    //   558: new 517	com/tencent/mm/protocal/protobuf/TimeLineObject
    //   561: dup
    //   562: invokespecial 4492	com/tencent/mm/protocal/protobuf/TimeLineObject:<init>	()V
    //   565: astore 6
    //   567: aload 6
    //   569: aload_1
    //   570: invokevirtual 4496	com/tencent/mm/protocal/protobuf/TimeLineObject:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   573: pop
    //   574: invokestatic 1219	com/tencent/mm/plugin/sns/model/al:hgB	()Lcom/tencent/mm/plugin/sns/storage/w;
    //   577: new 4498	java/math/BigInteger
    //   580: dup
    //   581: aload 6
    //   583: getfield 3057	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   586: invokespecial 4499	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   589: invokevirtual 4502	java/math/BigInteger:longValue	()J
    //   592: invokevirtual 4506	com/tencent/mm/plugin/sns/storage/w:vj	(J)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   595: ifnonnull +771 -> 1366
    //   598: ldc_w 574
    //   601: ldc_w 4508
    //   604: invokestatic 1150	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   607: new 544	com/tencent/mm/plugin/sns/storage/SnsInfo
    //   610: dup
    //   611: invokespecial 4509	com/tencent/mm/plugin/sns/storage/SnsInfo:<init>	()V
    //   614: astore_1
    //   615: aload_1
    //   616: new 4498	java/math/BigInteger
    //   619: dup
    //   620: aload 6
    //   622: getfield 3057	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   625: invokespecial 4499	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   628: invokevirtual 4502	java/math/BigInteger:longValue	()J
    //   631: putfield 2135	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   634: aload_1
    //   635: aload 6
    //   637: invokevirtual 4513	com/tencent/mm/protocal/protobuf/TimeLineObject:toByteArray	()[B
    //   640: putfield 4517	com/tencent/mm/plugin/sns/storage/SnsInfo:field_content	[B
    //   643: aload_1
    //   644: aload 6
    //   646: getfield 3327	com/tencent/mm/protocal/protobuf/TimeLineObject:CreateTime	I
    //   649: putfield 2318	com/tencent/mm/plugin/sns/storage/SnsInfo:field_createTime	I
    //   652: aload_1
    //   653: aload 6
    //   655: getfield 2788	com/tencent/mm/protocal/protobuf/TimeLineObject:UserName	Ljava/lang/String;
    //   658: putfield 4083	com/tencent/mm/plugin/sns/storage/SnsInfo:field_userName	Ljava/lang/String;
    //   661: aload_1
    //   662: aload 6
    //   664: getfield 555	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   667: getfield 1160	com/tencent/mm/protocal/protobuf/agh:Zpq	I
    //   670: putfield 2329	com/tencent/mm/plugin/sns/storage/SnsInfo:field_type	I
    //   673: aload_1
    //   674: invokevirtual 4520	com/tencent/mm/plugin/sns/storage/SnsInfo:setExtFlag	()V
    //   677: new 1318	com/tencent/mm/protocal/protobuf/SnsObject
    //   680: dup
    //   681: invokespecial 4521	com/tencent/mm/protocal/protobuf/SnsObject:<init>	()V
    //   684: astore 6
    //   686: aload 6
    //   688: new 1512	com/tencent/mm/protocal/protobuf/gol
    //   691: dup
    //   692: invokespecial 4522	com/tencent/mm/protocal/protobuf/gol:<init>	()V
    //   695: putfield 4525	com/tencent/mm/protocal/protobuf/SnsObject:ObjectDesc	Lcom/tencent/mm/protocal/protobuf/gol;
    //   698: aload_1
    //   699: aload 6
    //   701: invokevirtual 4526	com/tencent/mm/protocal/protobuf/SnsObject:toByteArray	()[B
    //   704: putfield 4529	com/tencent/mm/plugin/sns/storage/SnsInfo:field_attrBuf	[B
    //   707: invokestatic 1219	com/tencent/mm/plugin/sns/model/al:hgB	()Lcom/tencent/mm/plugin/sns/storage/w;
    //   710: aload_1
    //   711: invokevirtual 4533	com/tencent/mm/plugin/sns/storage/w:insert	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;)Z
    //   714: pop
    //   715: ldc_w 4535
    //   718: ldc_w 4537
    //   721: iconst_1
    //   722: anewarray 515	java/lang/Object
    //   725: dup
    //   726: iconst_0
    //   727: invokestatic 4396	java/lang/System:currentTimeMillis	()J
    //   730: lload_3
    //   731: lsub
    //   732: invokestatic 2140	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   735: aastore
    //   736: invokestatic 1930	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   739: aload_0
    //   740: iconst_1
    //   741: invokespecial 499	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Eh	(Z)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
    //   744: astore_1
    //   745: ldc_w 574
    //   748: new 1108	java/lang/StringBuilder
    //   751: dup
    //   752: ldc_w 4539
    //   755: invokespecial 1112	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   758: aload_0
    //   759: getfield 987	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:hQX	Ljava/lang/String;
    //   762: invokevirtual 1121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: ldc_w 4541
    //   768: invokevirtual 1121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: aload_0
    //   772: getfield 957	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RoK	Ljava/lang/String;
    //   775: invokevirtual 1121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: invokevirtual 1122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   781: invokestatic 1150	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   784: aload_1
    //   785: ifnull +29 -> 814
    //   788: ldc_w 574
    //   791: ldc_w 4543
    //   794: iconst_1
    //   795: anewarray 515	java/lang/Object
    //   798: dup
    //   799: iconst_0
    //   800: aload_1
    //   801: invokevirtual 849	com/tencent/mm/plugin/sns/storage/SnsInfo:getUserName	()Ljava/lang/String;
    //   804: ldc_w 344
    //   807: invokestatic 2058	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   810: aastore
    //   811: invokestatic 1930	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   814: aload_0
    //   815: iconst_0
    //   816: putfield 386	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rpo	Z
    //   819: aload_0
    //   820: getfield 987	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:hQX	Ljava/lang/String;
    //   823: invokestatic 1737	com/tencent/mm/plugin/sns/storage/ai:baq	(Ljava/lang/String;)Z
    //   826: ifeq +56 -> 882
    //   829: aload_0
    //   830: getfield 987	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:hQX	Ljava/lang/String;
    //   833: invokestatic 1356	com/tencent/mm/plugin/sns/storage/ai:aWb	(Ljava/lang/String;)Z
    //   836: ifeq +574 -> 1410
    //   839: aload_1
    //   840: ifnull +538 -> 1378
    //   843: aload_1
    //   844: invokevirtual 849	com/tencent/mm/plugin/sns/storage/SnsInfo:getUserName	()Ljava/lang/String;
    //   847: invokestatic 4546	com/tencent/mm/storage/au:bxa	(Ljava/lang/String;)Z
    //   850: ifne +32 -> 882
    //   853: invokestatic 1367	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   856: pop
    //   857: invokestatic 1371	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   860: getfield 1377	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   863: new 4548	com/tencent/mm/plugin/sns/model/r
    //   866: dup
    //   867: aload_0
    //   868: getfield 987	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:hQX	Ljava/lang/String;
    //   871: invokestatic 1353	com/tencent/mm/plugin/sns/storage/ai:aXe	(Ljava/lang/String;)J
    //   874: invokespecial 4550	com/tencent/mm/plugin/sns/model/r:<init>	(J)V
    //   877: iconst_0
    //   878: invokevirtual 1382	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   881: pop
    //   882: invokestatic 1367	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   885: pop
    //   886: invokestatic 1371	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   889: getfield 1377	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   892: sipush 210
    //   895: aload_0
    //   896: invokevirtual 4553	com/tencent/mm/am/s:a	(ILcom/tencent/mm/am/h;)V
    //   899: invokestatic 1367	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   902: pop
    //   903: invokestatic 1371	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   906: getfield 1377	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   909: sipush 218
    //   912: aload_0
    //   913: invokevirtual 4553	com/tencent/mm/am/s:a	(ILcom/tencent/mm/am/h;)V
    //   916: invokestatic 1367	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   919: pop
    //   920: invokestatic 1371	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   923: getfield 1377	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   926: sipush 213
    //   929: aload_0
    //   930: invokevirtual 4553	com/tencent/mm/am/s:a	(ILcom/tencent/mm/am/h;)V
    //   933: invokestatic 1367	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   936: pop
    //   937: invokestatic 1371	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   940: getfield 1377	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   943: sipush 682
    //   946: aload_0
    //   947: invokevirtual 4553	com/tencent/mm/am/s:a	(ILcom/tencent/mm/am/h;)V
    //   950: invokestatic 1367	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   953: pop
    //   954: invokestatic 1371	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   957: getfield 1377	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   960: sipush 214
    //   963: aload_0
    //   964: invokevirtual 4553	com/tencent/mm/am/s:a	(ILcom/tencent/mm/am/h;)V
    //   967: invokestatic 1367	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   970: pop
    //   971: invokestatic 1371	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   974: getfield 1377	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   977: sipush 683
    //   980: aload_0
    //   981: invokevirtual 4553	com/tencent/mm/am/s:a	(ILcom/tencent/mm/am/h;)V
    //   984: aload_0
    //   985: invokestatic 4556	com/tencent/mm/plugin/sns/model/al:hgp	()Lcom/tencent/mm/storage/bx;
    //   988: putfield 3834	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RoL	Lcom/tencent/mm/storage/bx;
    //   991: aload_0
    //   992: new 4558	com/tencent/mm/plugin/sns/ui/be
    //   995: dup
    //   996: aload_0
    //   997: invokespecial 4560	com/tencent/mm/plugin/sns/ui/be:<init>	(Landroid/app/Activity;)V
    //   1000: putfield 1733	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RbC	Lcom/tencent/mm/plugin/sns/ui/be;
    //   1003: aload_0
    //   1004: new 1168	com/tencent/mm/plugin/sns/ui/bh
    //   1007: dup
    //   1008: aload_0
    //   1009: invokevirtual 638	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getContext	()Landroidx/appcompat/app/AppCompatActivity;
    //   1012: invokespecial 4561	com/tencent/mm/plugin/sns/ui/bh:<init>	(Landroid/content/Context;)V
    //   1015: putfield 1007	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RoJ	Lcom/tencent/mm/plugin/sns/ui/bh;
    //   1018: aload_0
    //   1019: new 4563	com/tencent/mm/plugin/sns/ui/j
    //   1022: dup
    //   1023: aload_0
    //   1024: aload_0
    //   1025: invokevirtual 1043	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   1028: aload_0
    //   1029: getfield 391	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rpp	Lcom/tencent/mm/plugin/sns/model/am;
    //   1032: invokespecial 4566	com/tencent/mm/plugin/sns/ui/j:<init>	(Landroid/app/Activity;ILcom/tencent/mm/plugin/sns/model/ak;)V
    //   1035: putfield 1020	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RoO	Lcom/tencent/mm/plugin/sns/ui/j;
    //   1038: aload_0
    //   1039: new 4568	com/tencent/mm/plugin/sns/ui/l
    //   1042: dup
    //   1043: aload_0
    //   1044: invokespecial 4571	com/tencent/mm/plugin/sns/ui/l:<init>	(Lcom/tencent/mm/plugin/sns/ui/ae;)V
    //   1047: putfield 4573	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RoP	Lcom/tencent/mm/plugin/sns/ui/l;
    //   1050: aload_1
    //   1051: ifnull +76 -> 1127
    //   1054: aload_0
    //   1055: aload_1
    //   1056: iconst_0
    //   1057: invokestatic 1953	com/tencent/mm/plugin/sns/ui/bn:g	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Z)I
    //   1060: putfield 702	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:viewType	I
    //   1063: getstatic 1402	com/tencent/mm/plugin/sns/statistics/j:QFS	Lcom/tencent/mm/plugin/sns/statistics/j;
    //   1066: invokestatic 4396	java/lang/System:currentTimeMillis	()J
    //   1069: putfield 4576	com/tencent/mm/plugin/sns/statistics/j:QGt	J
    //   1072: getstatic 1402	com/tencent/mm/plugin/sns/statistics/j:QFS	Lcom/tencent/mm/plugin/sns/statistics/j;
    //   1075: astore 6
    //   1077: aload_1
    //   1078: ifnull +40 -> 1118
    //   1081: aload_1
    //   1082: getfield 2135	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1085: invokestatic 4579	com/tencent/mm/plugin/sns/data/t:uB	(J)Ljava/lang/String;
    //   1088: astore 7
    //   1090: aload 6
    //   1092: getfield 4582	com/tencent/mm/plugin/sns/statistics/j:QGn	Ljava/util/List;
    //   1095: aload 7
    //   1097: invokeinterface 4585 2 0
    //   1102: ifne +16 -> 1118
    //   1105: aload 6
    //   1107: getfield 4582	com/tencent/mm/plugin/sns/statistics/j:QGn	Ljava/util/List;
    //   1110: aload 7
    //   1112: invokeinterface 2760 2 0
    //   1117: pop
    //   1118: getstatic 1402	com/tencent/mm/plugin/sns/statistics/j:QFS	Lcom/tencent/mm/plugin/sns/statistics/j;
    //   1121: invokestatic 4396	java/lang/System:currentTimeMillis	()J
    //   1124: putfield 4588	com/tencent/mm/plugin/sns/statistics/j:QGA	J
    //   1127: aload_1
    //   1128: ifnull +89 -> 1217
    //   1131: aload_1
    //   1132: invokevirtual 547	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
    //   1135: ifeq +82 -> 1217
    //   1138: aload_0
    //   1139: getfield 1907	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rph	I
    //   1142: bipush 16
    //   1144: if_icmpne +307 -> 1451
    //   1147: aload_0
    //   1148: new 2974	com/tencent/mm/plugin/sns/ad/g/l
    //   1151: dup
    //   1152: iconst_2
    //   1153: invokespecial 4590	com/tencent/mm/plugin/sns/ad/g/l:<init>	(I)V
    //   1156: putfield 1556	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   1159: getstatic 1869	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1162: sipush 1697
    //   1165: bipush 17
    //   1167: invokevirtual 4593	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   1170: aload_0
    //   1171: getfield 1556	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   1174: aload_0
    //   1175: getfield 4390	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenHeight	I
    //   1178: aload_0
    //   1179: invokevirtual 4597	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSupportActionBar	()Landroidx/appcompat/app/ActionBar;
    //   1182: invokevirtual 4602	androidx/appcompat/app/ActionBar:getCustomView	()Landroid/view/View;
    //   1185: aload_0
    //   1186: invokevirtual 4605	com/tencent/mm/plugin/sns/ad/g/l:a	(ILandroid/view/View;Landroid/app/Activity;)V
    //   1189: aload_1
    //   1190: iconst_0
    //   1191: invokestatic 1953	com/tencent/mm/plugin/sns/ui/bn:g	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Z)I
    //   1194: pop
    //   1195: aload_0
    //   1196: getfield 1003	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:PZr	Lcom/tencent/mm/plugin/sns/ui/listener/c;
    //   1199: aload_0
    //   1200: getfield 1556	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   1203: invokevirtual 4608	com/tencent/mm/plugin/sns/ui/listener/c:c	(Lcom/tencent/mm/plugin/sns/ad/g/l;)V
    //   1206: aload_0
    //   1207: getfield 1818	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RbI	Lcom/tencent/mm/plugin/sns/ui/b;
    //   1210: aload_0
    //   1211: getfield 1556	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   1214: putfield 4611	com/tencent/mm/plugin/sns/ui/b:PYh	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   1217: aload_0
    //   1218: invokevirtual 4613	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:initView	()V
    //   1221: aload_1
    //   1222: ifnull +47 -> 1269
    //   1225: aload_1
    //   1226: invokevirtual 547	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
    //   1229: ifeq +40 -> 1269
    //   1232: aload_1
    //   1233: invokestatic 1588	com/tencent/mm/plugin/sns/model/ap:D	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   1236: astore 6
    //   1238: aload_0
    //   1239: getfield 1556	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   1242: iconst_0
    //   1243: aload_1
    //   1244: invokevirtual 993	com/tencent/mm/plugin/sns/storage/SnsInfo:getLocalid	()Ljava/lang/String;
    //   1247: aload_1
    //   1248: invokevirtual 4616	com/tencent/mm/plugin/sns/storage/SnsInfo:isExposures	()Z
    //   1251: aload_0
    //   1252: getfield 475	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rou	Landroid/view/View;
    //   1255: aload_1
    //   1256: getfield 2135	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
    //   1259: aload 6
    //   1261: aload_0
    //   1262: getfield 702	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:viewType	I
    //   1265: iconst_2
    //   1266: invokevirtual 4619	com/tencent/mm/plugin/sns/ad/g/l:a	(ILjava/lang/String;ZLandroid/view/View;JLcom/tencent/mm/protocal/protobuf/SnsObject;II)V
    //   1269: aload_0
    //   1270: getfield 475	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rou	Landroid/view/View;
    //   1273: ifnull +79 -> 1352
    //   1276: aload_1
    //   1277: ifnull +75 -> 1352
    //   1280: aload_0
    //   1281: getfield 475	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rou	Landroid/view/View;
    //   1284: getstatic 2829	com/tencent/mm/plugin/sns/b$f:image	I
    //   1287: invokevirtual 612	android/view/View:findViewById	(I)Landroid/view/View;
    //   1290: checkcast 4621	com/tencent/mm/plugin/sight/decode/model/a
    //   1293: astore 6
    //   1295: aload_1
    //   1296: invokevirtual 551	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1299: getfield 555	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   1302: ifnull +345 -> 1647
    //   1305: aload_1
    //   1306: invokevirtual 551	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1309: getfield 555	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
    //   1312: getfield 1160	com/tencent/mm/protocal/protobuf/agh:Zpq	I
    //   1315: bipush 15
    //   1317: if_icmpne +330 -> 1647
    //   1320: aload 6
    //   1322: instanceof 2923
    //   1325: ifeq +322 -> 1647
    //   1328: aload 6
    //   1330: checkcast 2923	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView
    //   1333: getfield 4625	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView:PGy	Lcom/tencent/mm/plugin/sight/decode/model/SightPlayController;
    //   1336: invokevirtual 4630	com/tencent/mm/plugin/sight/decode/model/SightPlayController:gYu	()Z
    //   1339: istore 5
    //   1341: aload_1
    //   1342: iconst_1
    //   1343: iload 5
    //   1345: aload_0
    //   1346: invokevirtual 1043	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   1349: invokestatic 4635	com/tencent/mm/plugin/sns/ad/g/p:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;ZZI)V
    //   1352: aload_0
    //   1353: getfield 914	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Roy	Landroid/widget/ListView;
    //   1356: ifnonnull +121 -> 1477
    //   1359: ldc_w 4323
    //   1362: invokestatic 281	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1365: return
    //   1366: ldc_w 574
    //   1369: ldc_w 4637
    //   1372: invokestatic 1150	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1375: goto -636 -> 739
    //   1378: invokestatic 1367	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   1381: pop
    //   1382: invokestatic 1371	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   1385: getfield 1377	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   1388: new 4548	com/tencent/mm/plugin/sns/model/r
    //   1391: dup
    //   1392: aload_0
    //   1393: getfield 987	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:hQX	Ljava/lang/String;
    //   1396: invokestatic 1353	com/tencent/mm/plugin/sns/storage/ai:aXe	(Ljava/lang/String;)J
    //   1399: invokespecial 4550	com/tencent/mm/plugin/sns/model/r:<init>	(J)V
    //   1402: iconst_0
    //   1403: invokevirtual 1382	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   1406: pop
    //   1407: goto -525 -> 882
    //   1410: invokestatic 1367	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
    //   1413: pop
    //   1414: invokestatic 1371	com/tencent/mm/kernel/h:baD	()Lcom/tencent/mm/kernel/c;
    //   1417: getfield 1377	com/tencent/mm/kernel/c:mCm	Lcom/tencent/mm/am/s;
    //   1420: new 4639	com/tencent/mm/plugin/sns/model/m
    //   1423: dup
    //   1424: aload_0
    //   1425: getfield 987	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:hQX	Ljava/lang/String;
    //   1428: invokestatic 1353	com/tencent/mm/plugin/sns/storage/ai:aXe	(Ljava/lang/String;)J
    //   1431: iconst_0
    //   1432: aload_0
    //   1433: aload_1
    //   1434: invokespecial 1069	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:j	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
    //   1437: getfield 4642	com/tencent/mm/plugin/sns/storage/ADInfo:adInfoSyncBuffer	Ljava/lang/String;
    //   1440: invokespecial 4645	com/tencent/mm/plugin/sns/model/m:<init>	(JILjava/lang/String;)V
    //   1443: iconst_0
    //   1444: invokevirtual 1382	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   1447: pop
    //   1448: goto -566 -> 882
    //   1451: aload_0
    //   1452: new 2974	com/tencent/mm/plugin/sns/ad/g/l
    //   1455: dup
    //   1456: iconst_1
    //   1457: invokespecial 4590	com/tencent/mm/plugin/sns/ad/g/l:<init>	(I)V
    //   1460: putfield 1556	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
    //   1463: getstatic 1869	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   1466: sipush 1697
    //   1469: bipush 16
    //   1471: invokevirtual 4593	com/tencent/mm/plugin/report/service/h:kJ	(II)V
    //   1474: goto -304 -> 1170
    //   1477: aload_0
    //   1478: getfield 914	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Roy	Landroid/widget/ListView;
    //   1481: new 20	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$12
    //   1484: dup
    //   1485: aload_0
    //   1486: invokespecial 4646	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$12:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   1489: invokevirtual 4647	android/widget/ListView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1492: aload_1
    //   1493: invokestatic 1588	com/tencent/mm/plugin/sns/model/ap:D	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   1496: astore 6
    //   1498: aload_0
    //   1499: new 4649	com/tencent/mm/plugin/sns/ui/n
    //   1502: dup
    //   1503: aload_0
    //   1504: invokespecial 4650	com/tencent/mm/plugin/sns/ui/n:<init>	(Landroid/content/Context;)V
    //   1507: putfield 378	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rpk	Lcom/tencent/mm/plugin/sns/ui/n;
    //   1510: aload_1
    //   1511: ifnull +94 -> 1605
    //   1514: aload_0
    //   1515: getfield 845	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:ltf	Ljava/lang/String;
    //   1518: aload_1
    //   1519: invokevirtual 849	com/tencent/mm/plugin/sns/storage/SnsInfo:getUserName	()Ljava/lang/String;
    //   1522: invokestatic 2263	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1525: ifeq +80 -> 1605
    //   1528: aload_0
    //   1529: iconst_0
    //   1530: getstatic 4653	com/tencent/mm/plugin/sns/b$i:icons_outlined_more	I
    //   1533: new 4655	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$13
    //   1536: dup
    //   1537: aload_0
    //   1538: aload_1
    //   1539: invokespecial 4656	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$13:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
    //   1542: invokevirtual 4660	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:addIconOptionMenu	(IILandroid/view/MenuItem$OnMenuItemClickListener;)V
    //   1545: aload_0
    //   1546: getfield 402	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rpq	Lcom/tencent/mm/sdk/event/IListener;
    //   1549: invokevirtual 4665	com/tencent/mm/sdk/event/IListener:alive	()V
    //   1552: aload_0
    //   1553: getfield 405	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rpr	Lcom/tencent/mm/sdk/event/IListener;
    //   1556: invokevirtual 4665	com/tencent/mm/sdk/event/IListener:alive	()V
    //   1559: aload_0
    //   1560: getfield 408	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rps	Lcom/tencent/mm/sdk/event/IListener;
    //   1563: invokevirtual 4665	com/tencent/mm/sdk/event/IListener:alive	()V
    //   1566: aload_0
    //   1567: getfield 411	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rpt	Lcom/tencent/mm/sdk/event/IListener;
    //   1570: invokevirtual 4665	com/tencent/mm/sdk/event/IListener:alive	()V
    //   1573: aload_0
    //   1574: getfield 437	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rpy	Lcom/tencent/mm/sdk/event/IListener;
    //   1577: invokevirtual 4665	com/tencent/mm/sdk/event/IListener:alive	()V
    //   1580: aload_0
    //   1581: getfield 448	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Rpz	Lcom/tencent/mm/sdk/event/IListener;
    //   1584: invokevirtual 4665	com/tencent/mm/sdk/event/IListener:alive	()V
    //   1587: aload_0
    //   1588: getfield 414	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:RbP	Lcom/tencent/mm/sdk/event/IListener;
    //   1591: invokevirtual 4665	com/tencent/mm/sdk/event/IListener:alive	()V
    //   1594: aload_0
    //   1595: invokestatic 4667	com/tencent/mm/pluginsdk/h:x	(Lcom/tencent/mm/ui/MMActivity;)V
    //   1598: ldc_w 4323
    //   1601: invokestatic 281	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1604: return
    //   1605: aload 6
    //   1607: getfield 3927	com/tencent/mm/protocal/protobuf/SnsObject:NewWithTaListCount	I
    //   1610: ifle -65 -> 1545
    //   1613: aload_0
    //   1614: iconst_0
    //   1615: getstatic 4653	com/tencent/mm/plugin/sns/b$i:icons_outlined_more	I
    //   1618: new 4669	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$$ExternalSyntheticLambda0
    //   1621: dup
    //   1622: aload_0
    //   1623: aload_1
    //   1624: invokespecial 4670	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$$ExternalSyntheticLambda0:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
    //   1627: invokevirtual 4660	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:addIconOptionMenu	(IILandroid/view/MenuItem$OnMenuItemClickListener;)V
    //   1630: goto -85 -> 1545
    //   1633: astore_1
    //   1634: goto -895 -> 739
    //   1637: astore 6
    //   1639: goto -932 -> 707
    //   1642: astore 7
    //   1644: goto -1001 -> 643
    //   1647: iconst_0
    //   1648: istore 5
    //   1650: goto -309 -> 1341
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1653	0	this	SnsCommentDetailUI
    //   0	1653	1	paramBundle	Bundle
    //   302	11	2	i	int
    //   542	189	3	l	long
    //   1339	310	5	bool	boolean
    //   565	1041	6	localObject	Object
    //   1637	1	6	localIOException	java.io.IOException
    //   1088	23	7	str	String
    //   1642	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   567	574	1633	java/io/IOException
    //   698	707	1637	java/io/IOException
    //   634	643	1642	java/lang/Exception
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98596);
    com.tencent.mm.plugin.sns.model.al.hgr().a(this, 5);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(210, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(218, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(213, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(214, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(683, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(682, this);
    com.tencent.mm.plugin.sns.model.al.hgy().bq(this);
    if (this.RoO != null) {
      this.RoO.activity = null;
    }
    ai.hmn();
    if (this.RbA != null) {
      this.RbA.hoB();
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.Ros;
    Object localObject = com.tencent.mm.plugin.comm.b.e.xfd;
    localObject = com.tencent.mm.plugin.comm.b.b.xeN.name();
    long l3 = com.tencent.mm.plugin.sns.storage.ai.aXe(this.hQX);
    int i;
    int j;
    label206:
    SnsInfo localSnsInfo;
    if (this.LXq)
    {
      i = 1;
      if (!this.Rpn) {
        break label807;
      }
      j = 1;
      e.a.a((String)localObject, "withFriendDetailAction", Long.valueOf(l3), String.format("%d#%d#%d#%d#%d", new Object[] { Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Long.valueOf(l1 - l2) }), com.tencent.mm.plugin.comm.b.c.xeX);
      com.tencent.mm.plugin.comm.b.e.xfd.a(com.tencent.mm.plugin.comm.b.b.xeN.name(), "withFriendDetailTime", Long.valueOf(System.currentTimeMillis() - this.Ros), com.tencent.mm.plugin.comm.b.c.xeT);
      localSnsInfo = Eh(false);
      if ((localSnsInfo != null) && (localSnsInfo.isAd()))
      {
        if (this.RoZ != null) {
          this.RoZ.a(0, localSnsInfo.getLocalid(), localSnsInfo.field_snsId, 2);
        }
        localObject = j(localSnsInfo);
        if (localObject != null) {
          break label812;
        }
        localObject = "";
        label363:
        if (!localSnsInfo.isRecExpAd()) {
          break label822;
        }
        com.tencent.mm.plugin.sns.model.al.hgv().b(14652, new Object[] { com.tencent.mm.plugin.sns.ad.g.k.a(localSnsInfo.field_snsId, new Object[] { t.uA(localSnsInfo.field_snsId), localObject, Long.valueOf(this.Ros), Long.valueOf(System.currentTimeMillis()) }) });
      }
    }
    for (;;)
    {
      com.tencent.mm.modelsns.l locall = com.tencent.mm.modelsns.l.wP(732);
      locall.Ph(t.uA(localSnsInfo.field_snsId)).Ph((String)localObject).Ph(this.Ros).Ph(System.currentTimeMillis());
      locall.bMH();
      if (this.RoY != null) {
        this.RoY.onUIDestroy();
      }
      this.PZr.removeListener();
      this.Rpq.dead();
      this.Rpr.dead();
      this.Rps.dead();
      this.Rpt.dead();
      this.Rpy.dead();
      this.Rpz.dead();
      this.RbP.dead();
      super.onDestroy();
      localObject = com.tencent.mm.plugin.sns.statistics.j.QFS;
      if (((com.tencent.mm.plugin.sns.statistics.j)localObject).QGt != 0L)
      {
        ((com.tencent.mm.plugin.sns.statistics.j)localObject).QGu += System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.statistics.j)localObject).QGt;
        ((com.tencent.mm.plugin.sns.statistics.j)localObject).QGt = 0L;
      }
      localObject = com.tencent.mm.plugin.sns.statistics.j.QFS;
      if (((com.tencent.mm.plugin.sns.statistics.j)localObject).QGA != 0L)
      {
        ((com.tencent.mm.plugin.sns.statistics.j)localObject).QGB += System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.statistics.j)localObject).QGA;
        ((com.tencent.mm.plugin.sns.statistics.j)localObject).QGA = 0L;
      }
      if ((this.Rpi) && (localSnsInfo != null) && (localSnsInfo.getTimeLine() != null) && (localSnsInfo.getTimeLine().ContentObj != null))
      {
        localObject = com.tencent.mm.plugin.sns.statistics.j.QFS.hip();
        ((ni)localObject).iOd = com.tencent.mm.plugin.sns.statistics.j.QFS.QGh.iOd;
        ((ni)localObject).vF(com.tencent.mm.plugin.sns.statistics.j.QFS.QGh.jfs).vG(t.uB(localSnsInfo.field_snsId)).iwe = localSnsInfo.getTimeLine().ContentObj.Zpq;
        com.tencent.mm.plugin.sns.statistics.j.QFS.hiu();
      }
      if (this.Rpm != null) {
        this.Rpm.destroy();
      }
      localObject = com.tencent.mm.plugin.comm.b.e.xfd;
      e.a.gw(com.tencent.mm.plugin.comm.b.b.xeP.name(), MomentsTogetherTailActionStruct.class.getCanonicalName());
      AppMethodBeat.o(98596);
      return;
      i = 0;
      break;
      label807:
      j = 0;
      break label206;
      label812:
      localObject = ((ADInfo)localObject).uxInfo;
      break label363;
      label822:
      com.tencent.mm.plugin.sns.model.al.hgv().b(12012, new Object[] { com.tencent.mm.plugin.sns.ad.g.k.a(localSnsInfo.field_snsId, new Object[] { t.uA(localSnsInfo.field_snsId), localObject, Long.valueOf(this.Ros), Long.valueOf(System.currentTimeMillis()) }) });
    }
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(98612);
    if (keyboardState() == 2)
    {
      Log.i("MicroMsg.SnsCommentDetailUI", "keybaordhide! ");
      this.RoI = false;
      AppMethodBeat.o(98612);
      return;
    }
    if (keyboardState() == 1)
    {
      Log.i("MicroMsg.SnsCommentDetailUI", "keybaordShow");
      hor();
      this.Rbx = false;
      this.Rpw.run();
      if (this.RbI != null) {
        this.RbI.hib();
      }
    }
    AppMethodBeat.o(98612);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98598);
    com.tencent.mm.plugin.sns.model.al.hgw().b(this);
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, null);
      this.Rlo = false;
      super.onPause();
      Object localObject1 = (ad)com.tencent.mm.kernel.h.ax(ad.class);
      if (localObject1 != null) {
        ((ad)localObject1).bUU();
      }
      this.RbA.lzt.hideVKB();
      localObject1 = this.RbA;
      if (((SnsCommentFooter)localObject1).moD != null) {
        ((SnsCommentFooter)localObject1).moD.onPause();
      }
      ((SnsCommentFooter)localObject1).Rqt.onPause();
      new abi().ieT.type = 1;
      if (this.RoZ != null) {
        this.RoZ.onPause();
      }
      if (this.RoY != null) {
        this.RoY.onPause();
      }
      this.rDF.dead();
      this.Akp.dead();
      AppMethodBeat.o(98598);
      return;
    }
    finally
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localObject2.toString());
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98597);
    try
    {
      if (!this.Rlo)
      {
        Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onResume callback");
        ScreenShotUtil.setScreenShotCallback(this, this.Rmk);
        this.Rlo = true;
      }
      com.tencent.mm.plugin.sns.model.al.hgw().a(this);
      Object localObject1 = new abi();
      ((abi)localObject1).ieT.ieU = 0;
      ((abi)localObject1).ieT.ieV = 1;
      ((abi)localObject1).ieT.ieW = 0;
      ((abi)localObject1).ieT.type = 0;
      ((abi)localObject1).publish();
      if (this.RoZ != null) {
        this.RoZ.onResume();
      }
      if (this.RoY != null) {
        this.RoY.refreshView();
      }
      super.onResume();
      localObject1 = (ad)com.tencent.mm.kernel.h.ax(ad.class);
      if ((localObject1 != null) && (((ad)localObject1).E(this)))
      {
        AppMethodBeat.o(98597);
        return;
      }
    }
    finally
    {
      for (;;)
      {
        Log.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localObject2.toString());
      }
      this.rDF.alive();
      this.Akp.alive();
      AppMethodBeat.o(98597);
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(98611);
    if ((paramp.getType() == 218) && (this.RbN != null)) {
      this.RbN.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((this.Rpk != null) && (this.Rpk.tipDialog != null) && (this.Rpk.tipDialog.isShowing())) {
        this.Rpk.tipDialog.dismiss();
      }
      Object localObject = com.tencent.mm.plugin.sns.storage.l.aZK(this.hQX);
      if (localObject == null)
      {
        Log.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.hQX);
        finish();
        AppMethodBeat.o(98611);
        return;
      }
      Log.d("MicroMsg.SnsCommentDetailUI", "snsId: " + this.hQX + "  username:" + ((SnsInfo)localObject).getUserName());
      if (this.Rou == null)
      {
        Log.e("MicroMsg.SnsCommentDetailUI", "fatal error! Sns onSceneEnd before initView and infoHeader is null!");
        finish();
        AppMethodBeat.o(98611);
        return;
      }
      hoq();
      f((SnsInfo)localObject, false);
      paramString = ap.D((SnsInfo)localObject);
      Log.i("MicroMsg.SnsCommentDetailUI", "onSceneEnd " + paramString.LikeUserList.size() + " " + paramString.CommentUserList.size());
      if (paramString == null)
      {
        AppMethodBeat.o(98611);
        return;
      }
      if (!h(this.RoG, paramString.LikeUserList))
      {
        D(paramString.LikeUserList, paramString.CommentUserList.isEmpty());
        this.RoG = paramString.LikeUserList;
        if ((this.RoY != null) && (((SnsInfo)localObject).isSocialAttitudeAd())) {
          this.RoY.refreshView();
        }
      }
      if (this.Rox != null) {
        this.Rox.a((SnsInfo)localObject, this.PZr);
      }
      localObject = this.RoB;
      LinkedList localLinkedList = paramString.CommentUserList;
      paramString = paramString.LikeUserList;
      ((b)localObject).commentList = localLinkedList;
      ((b)localObject).Rqi = paramString;
      this.RoB.notifyDataSetChanged();
      if ((paramp.getType() == 683) || (paramp.getType() == 210))
      {
        Log.i("MicroMsg.SnsCommentDetailUI", "onScene objectDetail type:%s, isRequestDetail:%s", new Object[] { Integer.valueOf(paramp.getType()), Boolean.valueOf(this.Rpo) });
        this.Rpo = true;
      }
    }
    SnsTimeLineUI.a(paramInt1, paramInt2, paramp, this);
    AppMethodBeat.o(98611);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(308091);
    ad localad = (ad)com.tencent.mm.kernel.h.ax(ad.class);
    if (localad != null) {
      localad.bUT();
    }
    super.onStart();
    AppMethodBeat.o(308091);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(308080);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      ScreenShotUtil.setScreenShotCallback(this, null);
      this.Rlo = false;
      AppMethodBeat.o(308080);
      return;
    }
    finally
    {
      Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      Log.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localObject.toString());
      AppMethodBeat.o(308080);
    }
    if (!this.Rlo)
    {
      Log.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onWindowFocusChanged callback");
      ScreenShotUtil.setScreenShotCallback(this, this.Rmk);
      this.Rlo = true;
    }
    AppMethodBeat.o(308080);
    return;
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(308043);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.sns.a.a.class);
    AppMethodBeat.o(308043);
  }
  
  public final void w(String paramString, boolean paramBoolean) {}
  
  public final void x(String paramString, boolean paramBoolean) {}
  
  final class a
    extends com.tencent.mm.pluginsdk.ui.span.u
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(98583);
      SnsCommentDetailUI.i(SnsCommentDetailUI.this).RFw.onClick(paramView);
      AppMethodBeat.o(98583);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(98584);
      int i = SnsCommentDetailUI.this.getResources().getColor(b.c.sns_link_bg_color);
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
    LinkedList<fdv> Rqi;
    Activity activity;
    public LinkedList<fdv> commentList;
    String hES;
    
    public b(LinkedList<fdv> paramLinkedList, Activity paramActivity, String paramString)
    {
      this.commentList = paramLinkedList;
      this.Rqi = paramActivity;
      this.activity = paramString;
      Object localObject;
      this.hES = localObject;
    }
    
    public final int getCount()
    {
      int i = 0;
      AppMethodBeat.i(98587);
      if (this.Rqi.size() > 0)
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
      if (this.Rqi.size() > 0)
      {
        if (paramInt == 0)
        {
          paramView = SnsCommentDetailUI.K(SnsCommentDetailUI.this);
          AppMethodBeat.o(98588);
          return paramView;
        }
        i = paramInt - 1;
      }
      Object localObject3 = (fdv)this.commentList.get(i);
      com.tencent.mm.plugin.sns.h.a.aXN(((fdv)localObject3).nUB);
      ((fdv)localObject3).nUB = Util.nullAsNil(((fdv)localObject3).nUB);
      View localView;
      if ((paramView == null) || (!(paramView.getTag() instanceof a)))
      {
        localView = af.mU(this.activity).inflate(b.g.sns_comment_detail_item, null);
        localView.setOnTouchListener(SnsCommentDetailUI.L(SnsCommentDetailUI.this));
        paramViewGroup = new a();
        paramViewGroup.lBC = ((ImageView)localView.findViewById(b.f.album_comment_avatar_iv));
        paramViewGroup.lBC.setContentDescription(String.format(SnsCommentDetailUI.this.getString(com.tencent.mm.plugin.sns.b.j.shake_avatar), new Object[] { ((fdv)localObject3).Nickname }));
        paramViewGroup.lBC.setOnClickListener(SnsCommentDetailUI.M(SnsCommentDetailUI.this));
        paramViewGroup.pWj = ((TextView)localView.findViewById(b.f.album_comment_nick_tv));
        paramViewGroup.pWj.setOnTouchListener(new ai());
        paramViewGroup.timeTv = ((TextView)localView.findViewById(b.f.album_comment_time_tv));
        paramViewGroup.noc = ((TextView)localView.findViewById(b.f.album_comment_content_tv));
        paramViewGroup.Rqj = ((FrameLayout)localView.findViewById(b.f.album_comment_content_fl));
        paramViewGroup.noc.setOnTouchListener(new ai());
        paramViewGroup.Rqk = ((SnsTranslateResultView)localView.findViewById(b.f.sns_translate_result_view));
        paramViewGroup.Rqk.setVisibility(8);
        paramViewGroup.Rqm = ((EmojiStatusView)localView.findViewById(b.f.album_comment_emoji_view));
        if (SnsCommentDetailUI.H(SnsCommentDetailUI.this) != 10) {
          break label2312;
        }
        localView.findViewById(b.f.comment_view_parent).setBackgroundResource(b.e.friendactivity_comment_detail_list_golden);
      }
      label1028:
      label2309:
      label2312:
      for (;;)
      {
        paramViewGroup.Rql = ((fdv)localObject3);
        paramViewGroup.userName = ((fdv)localObject3).Username;
        ((SnsAvatarImageView)paramViewGroup.lBC).hj(((fdv)localObject3).Username, 3);
        ((SnsAvatarImageView)paramViewGroup.lBC).setWeakContext(this.activity);
        label401:
        Object localObject4;
        label473:
        SnsInfo localSnsInfo;
        if (SnsCommentDetailUI.H(SnsCommentDetailUI.this) == 10)
        {
          paramInt = 3;
          SnsCommentDetailUI.H(SnsCommentDetailUI.this);
          com.tencent.mm.kernel.h.baF();
          localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxu(paramViewGroup.userName);
          if ((i != 0) || (!this.Rqi.isEmpty())) {
            break label1890;
          }
          if (SnsCommentDetailUI.H(SnsCommentDetailUI.this) != 10) {
            break label1879;
          }
          localView.setBackgroundResource(b.e.friendactivity_comment_detail_list_golden_arror);
          if (i != 0) {
            break label1924;
          }
          localView.findViewById(b.f.sns_comment_left_icon).setVisibility(0);
          localView.findViewById(b.f.sns_comment_line).setVisibility(8);
          if (SnsCommentDetailUI.H(SnsCommentDetailUI.this) == 10) {
            ((ImageView)localView.findViewById(b.f.sns_comment_left_icon)).setImageResource(b.i.friendactivity_writeicon_golden);
          }
          label532:
          localSnsInfo = com.tencent.mm.plugin.sns.storage.l.aZK(SnsCommentDetailUI.m(SnsCommentDetailUI.this));
          paramViewGroup.lBC.setTag(((fdv)localObject3).Username);
          if (!com.tencent.mm.plugin.sns.ui.widget.g.a(paramViewGroup.lBC, localSnsInfo, ((fdv)localObject3).Username)) {
            com.tencent.mm.pluginsdk.ui.a.b.C(paramViewGroup.lBC, ((fdv)localObject3).Username);
          }
          if (localObject4 == null) {
            break label1951;
          }
          paramView = ((au)localObject4).aSV();
          label596:
          if (!com.tencent.mm.plugin.sns.ui.widget.g.b(localSnsInfo, ((fdv)localObject3).Username)) {
            break label2309;
          }
          paramView = com.tencent.mm.plugin.sns.ui.widget.g.e(localSnsInfo.getAdXml(), paramView);
        }
        for (;;)
        {
          String str1;
          Object localObject5;
          Object localObject2;
          Object localObject1;
          int j;
          int k;
          if (localSnsInfo != null)
          {
            str1 = localSnsInfo.field_userName;
            paramViewGroup.noc.setText(((fdv)localObject3).nUB + " ");
            localObject5 = com.tencent.mm.plugin.sns.ui.widget.g.a(SnsCommentDetailUI.this, (fdv)localObject3, SnsCommentDetailUI.N(SnsCommentDetailUI.this), localSnsInfo.field_type, localSnsInfo.getUserName(), 2, SnsCommentDetailUI.O(SnsCommentDetailUI.this), SnsCommentDetailUI.P(SnsCommentDetailUI.this), localSnsInfo);
            localObject2 = null;
            localObject1 = localObject2;
            if (!Util.isNullOrNil(((fdv)localObject3).abDm))
            {
              localObject1 = localObject2;
              if (((fdv)localObject3).abDm.get(0) != null)
              {
                localObject1 = ((feb)((fdv)localObject3).abDm.get(0)).Md5;
                localObject1 = bl.jba().adju.bza((String)localObject1);
              }
            }
            if (localObject1 != null) {
              break label1977;
            }
            paramViewGroup.Rqm.setVisibility(8);
            paramViewGroup.Rqm.setEmojiInfo(null);
            if ((localObject4 == null) || (!au.bwO(((az)localObject4).field_username)) || (!"3552365301".equals(((az)localObject4).field_openImAppid))) {
              break label2297;
            }
            j = paramView.length();
            localObject1 = ((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).cc(((az)localObject4).field_openImAppid, ((az)localObject4).field_descWordingId);
            localObject1 = paramView + " @" + (String)localObject1;
            k = ((String)localObject1).length();
          }
          for (;;)
          {
            paramViewGroup.pWj.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
            com.tencent.mm.pluginsdk.ui.span.p.t(paramViewGroup.pWj, paramInt);
            localObject1 = new com.tencent.mm.pluginsdk.ui.span.q(paramViewGroup.pWj.getText());
            Log.i("MicroMsg.SnsCommentDetailUI", "test %s,%s", new Object[] { ((fdv)localObject3).Username, paramView });
            int m;
            label981:
            long l;
            label1180:
            label1262:
            String str2;
            label1356:
            Object localObject6;
            if (com.tencent.mm.plugin.sns.ui.widget.g.b(localSnsInfo, ((fdv)localObject3).Username)) {
              if (com.tencent.mm.plugin.sns.ui.widget.g.lU(((fdv)localObject3).abDl, 32))
              {
                m = 27;
                ((com.tencent.mm.pluginsdk.ui.span.q)localObject1).a(new com.tencent.mm.pluginsdk.ui.span.u(new com.tencent.mm.plugin.sns.data.d(localSnsInfo.isAd(), ((fdv)localObject3).Username, localSnsInfo.getLocalid(), 2, m), SnsCommentDetailUI.N(SnsCommentDetailUI.this), paramInt), paramView, 0);
                if ((j >= 0) && (k > j)) {
                  ((com.tencent.mm.pluginsdk.ui.span.q)localObject1).setSpan(((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).a(SnsCommentDetailUI.this, ((az)localObject4).field_openImAppid, bd.fromDPToPix(SnsCommentDetailUI.this.getContext(), 12), b.c.Orange_100), j, k, 33);
                }
                paramViewGroup.pWj.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
                l = ((fdv)localObject3).CreateTime;
                if (com.tencent.mm.plugin.sns.ui.widget.g.lU(((fdv)localObject3).abDl, 32)) {
                  l = localSnsInfo.getCreateTime();
                }
                paramViewGroup.timeTv.setText(bp.w(this.activity, l * 1000L));
                if (!Util.isNullOrNil((CharSequence)localObject5)) {
                  break label2152;
                }
                paramViewGroup.noc.setVisibility(8);
                SnsCommentDetailUI.Q(SnsCommentDetailUI.this).c(localView, SnsCommentDetailUI.G(SnsCommentDetailUI.this).RQh, SnsCommentDetailUI.G(SnsCommentDetailUI.this).RPU);
                SnsCommentDetailUI.Q(SnsCommentDetailUI.this).c(paramViewGroup.Rqj, SnsCommentDetailUI.G(SnsCommentDetailUI.this).RQh, SnsCommentDetailUI.G(SnsCommentDetailUI.this).RPU);
                if (((fdv)localObject3).abDh == 0) {
                  break label2211;
                }
                l = ((fdv)localObject3).abDh;
                localObject2 = av.mj(SnsCommentDetailUI.m(SnsCommentDetailUI.this), String.valueOf(l));
                if ((av.gY((String)localObject2, 4)) && (paramViewGroup.Rqk != null))
                {
                  localObject2 = av.aYE((String)localObject2);
                  if (localObject2 == null) {
                    break label2244;
                  }
                  paramViewGroup.Rqk.setVisibility(0);
                  if (!((av.b)localObject2).ooe) {
                    break label2233;
                  }
                  if (((av.b)localObject2).oss) {
                    break label2221;
                  }
                  paramViewGroup.Rqk.a((av.b)localObject2, 2, ((av.b)localObject2).result, ((av.b)localObject2).brand, ((av.b)localObject2).Qxt);
                }
                localView.setClickable(true);
                Log.d("MicroMsg.SnsCommentDetailUI", "position " + ((fdv)localObject3).Username + " self " + SnsCommentDetailUI.w(SnsCommentDetailUI.this) + " commentid " + ((fdv)localObject3).abDh + " snsid " + SnsCommentDetailUI.m(SnsCommentDetailUI.this));
                if (!SnsCommentDetailUI.w(SnsCommentDetailUI.this).equals(((fdv)localObject3).Username)) {
                  break label2256;
                }
                paramViewGroup.info = localObject3;
                label1459:
                localObject2 = SnsCommentDetailUI.j(SnsCommentDetailUI.this);
                localObject4 = SnsCommentDetailUI.m(SnsCommentDetailUI.this);
                localObject5 = ((fdv)localObject3).Username;
                str2 = ((fdv)localObject3).nUB;
                localObject6 = paramViewGroup.noc;
                if ((localSnsInfo == null) || (localSnsInfo.getTimeLine() == null)) {
                  break label2292;
                }
              }
            }
            label1879:
            label1890:
            label2152:
            label2292:
            for (paramView = localSnsInfo.getTimeLine().Id;; paramView = null)
            {
              paramView = new m((String)localObject2, (String)localObject4, (fdv)localObject3, (String)localObject5, str2, (View)localObject6, 2, str1, paramView);
              paramView.tag = paramViewGroup;
              localView.setTag(paramView);
              paramViewGroup.noc.setTag(paramView);
              localView.setOnClickListener(SnsCommentDetailUI.R(SnsCommentDetailUI.this));
              localObject2 = new com.tencent.mm.pluginsdk.ui.span.s(SnsCommentDetailUI.this);
              if (com.tencent.mm.plugin.sns.ui.widget.g.b(localSnsInfo, ((fdv)localObject3).Username))
              {
                ((com.tencent.mm.pluginsdk.ui.span.s)localObject2).setAdTagClickCallback(SnsCommentDetailUI.S(SnsCommentDetailUI.this), 0);
                ((com.tencent.mm.pluginsdk.ui.span.s)localObject2).mAdTagClickScene = 31;
              }
              paramViewGroup.noc.setOnTouchListener((View.OnTouchListener)localObject2);
              paramViewGroup.Rqj.setTag(paramView);
              paramViewGroup.Rqj.setOnClickListener(SnsCommentDetailUI.R(SnsCommentDetailUI.this));
              if ((!localSnsInfo.isAd()) && (((fdv)localObject3).DeleteFlag > 0))
              {
                ((com.tencent.mm.pluginsdk.ui.span.q)localObject1).setSpan(new ForegroundColorSpan(SnsCommentDetailUI.this.getContext().getResources().getColor(b.c.BW_50)), 0, ((com.tencent.mm.pluginsdk.ui.span.q)localObject1).length(), 33);
                paramViewGroup.pWj.setText((CharSequence)localObject1);
                paramView = paramViewGroup.noc;
                localObject1 = SnsCommentDetailUI.this.getContext();
                localObject2 = ((Context)localObject1).getResources().getString(com.tencent.mm.plugin.sns.b.j.sns_comment_deleted);
                localObject3 = new SpannableStringBuilder((CharSequence)localObject2);
                ((SpannableStringBuilder)localObject3).setSpan(new ForegroundColorSpan(((Context)localObject1).getResources().getColor(b.c.BW_50)), 0, ((String)localObject2).length(), 0);
                ((SpannableStringBuilder)localObject3).setSpan(new BackgroundColorSpan(((Context)localObject1).getResources().getColor(b.c.BW_90)), 0, ((String)localObject2).length(), 0);
                paramView.setText((CharSequence)localObject3);
                paramViewGroup.noc.setOnTouchListener(null);
                paramViewGroup.Rqj.setOnLongClickListener(null);
                paramViewGroup.Rqj.setOnClickListener(null);
                localView.setOnClickListener(null);
                localView.setOnLongClickListener(null);
              }
              AppMethodBeat.o(98588);
              return localView;
              paramViewGroup = (a)paramView.getTag();
              localView = paramView;
              break;
              paramInt = 2;
              break label401;
              localView.setBackgroundResource(b.e.friendactivity_comment_list_normal);
              break label473;
              if (SnsCommentDetailUI.H(SnsCommentDetailUI.this) == 10)
              {
                localView.setBackgroundResource(b.e.sns_comment_detail_item_bg_golden);
                break label473;
              }
              localView.setBackgroundResource(b.e.sns_comment_detail_item_bg);
              break label473;
              localView.findViewById(b.f.sns_comment_left_icon).setVisibility(4);
              localView.findViewById(b.f.sns_comment_line).setVisibility(0);
              break label532;
              if (((fdv)localObject3).Nickname != null)
              {
                paramView = ((fdv)localObject3).Nickname;
                break label596;
              }
              paramView = ((fdv)localObject3).Username;
              break label596;
              str2 = SnsCommentDetailUI.j(SnsCommentDetailUI.this);
              localObject6 = SnsCommentDetailUI.m(SnsCommentDetailUI.this);
              String str3 = ((fdv)localObject3).Username;
              String str4 = ((fdv)localObject3).nUB;
              TextView localTextView = paramViewGroup.noc;
              if ((localSnsInfo != null) && (localSnsInfo.getTimeLine() != null)) {}
              for (localObject2 = localSnsInfo.getTimeLine().Id;; localObject2 = null)
              {
                localObject2 = new m(str2, (String)localObject6, (fdv)localObject3, str3, str4, localTextView, 2, str1, (String)localObject2);
                paramViewGroup.Rqm.setTag(localObject2);
                paramViewGroup.Rqm.setVisibility(0);
                paramViewGroup.Rqm.setEmojiInfo((EmojiInfo)localObject1);
                paramViewGroup.Rqm.setOnClickListener(SnsCommentDetailUI.G(SnsCommentDetailUI.this).RQA);
                break;
              }
              m = 2;
              break label981;
              ((com.tencent.mm.pluginsdk.ui.span.q)localObject1).a(new com.tencent.mm.pluginsdk.ui.span.u(((fdv)localObject3).Username, SnsCommentDetailUI.N(SnsCommentDetailUI.this), paramInt), paramView, 0);
              break label1028;
              localObject2 = new SpannableStringBuilder((CharSequence)localObject5);
              ((SpannableStringBuilder)localObject2).append(" ");
              paramViewGroup.noc.setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
              paramViewGroup.noc.setVisibility(0);
              localObject2 = com.tencent.mm.plugin.sns.j.a.QCu;
              a.a.a(paramViewGroup.noc, paramViewGroup.Rql);
              break label1180;
              l = ((fdv)localObject3).abDj;
              break label1262;
              paramViewGroup.Rqk.setVisibility(8);
              break label1356;
              paramViewGroup.Rqk.amo(2);
              break label1356;
              paramViewGroup.Rqk.setVisibility(8);
              break label1356;
              paramViewGroup.info = new Object[] { Integer.valueOf(i), localObject3, ((fdv)localObject3).Username, paramView };
              break label1459;
            }
            label1951:
            label1977:
            label2233:
            label2244:
            label2256:
            label2297:
            j = 0;
            label2211:
            label2221:
            k = 0;
            localObject1 = paramView;
          }
        }
      }
    }
    
    final class a
    {
      FrameLayout Rqj;
      SnsTranslateResultView Rqk;
      fdv Rql;
      EmojiStatusView Rqm;
      Object info;
      ImageView lBC;
      TextView noc;
      TextView pWj;
      TextView timeTv;
      String userName;
      
      a() {}
    }
  }
  
  final class d
    implements Runnable
  {
    private int Rqr = -1;
    private int Rqs = 10;
    int bwS = -1;
    int dpX;
    private int offset = 0;
    
    d() {}
    
    public final void run()
    {
      AppMethodBeat.i(98589);
      this.Rqs = 10;
      SnsCommentDetailUI.b(SnsCommentDetailUI.this);
      this.Rqr = SnsCommentDetailUI.c(SnsCommentDetailUI.this).getTop();
      int i = this.Rqr - this.dpX;
      Log.i("MicroMsg.SnsCommentDetailUI", "list.bottom: %d, listOriginalBottom: %d, footerTop: %d, commentFooter.getTop: %d, topSelection: %d", new Object[] { Integer.valueOf(SnsCommentDetailUI.a(SnsCommentDetailUI.this).getBottom()), Integer.valueOf(SnsCommentDetailUI.d(SnsCommentDetailUI.this)), Integer.valueOf(this.Rqr), Integer.valueOf(SnsCommentDetailUI.c(SnsCommentDetailUI.this).getTop()), Integer.valueOf(i) });
      if (i == this.offset)
      {
        SnsCommentDetailUI.a(SnsCommentDetailUI.this).setSelectionFromTop(SnsCommentDetailUI.a(SnsCommentDetailUI.this).getHeaderViewsCount() + this.bwS, i);
        this.Rqs = 0;
        this.offset = 0;
        AppMethodBeat.o(98589);
        return;
      }
      int j = this.Rqs;
      this.Rqs = (j - 1);
      if (j > 0)
      {
        new MMHandler().postDelayed(this, 100L);
        this.offset = i;
        AppMethodBeat.o(98589);
        return;
      }
      this.offset = 0;
      this.Rqs = 0;
      AppMethodBeat.o(98589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI
 * JD-Core Version:    0.7.0.1
 */