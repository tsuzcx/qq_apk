package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.constraint.Guideline;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
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
import android.view.ViewStub;
import android.view.WindowManager;
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
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.g.a.ib;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.g.a.vi;
import com.tencent.mm.g.a.vk;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.g.b.a.ey;
import com.tencent.mm.g.b.a.fh;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ao.a;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.as.b;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.bzi;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgn;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.protocal.protobuf.edv;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bi.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.kernel.i
public class SnsCommentDetailUI
  extends MMActivity
  implements com.tencent.mm.ak.f, i.a, c.b, aa
{
  private static com.tencent.mm.loader.c.e Ahx;
  private static com.tencent.mm.loader.c.e AsM;
  public static int Asn;
  private static com.tencent.mm.loader.c.d<String, Bitmap> srN;
  private com.tencent.mm.ui.base.p AgA;
  private com.tencent.mm.sdk.b.c AgC;
  private boolean Agk;
  private SnsCommentFooter Agn;
  private ay Agp;
  private b Agv;
  private com.tencent.mm.plugin.sns.h.b Agw;
  private am Agx;
  private br Agy;
  private View.OnTouchListener Aib;
  private volatile boolean AoZ;
  private bi.a ApP;
  private long ArJ;
  private long ArK;
  private View ArL;
  private TextView ArM;
  private LinearLayout ArN;
  private SnsDetailLuckyHeader ArO;
  private ListView ArP;
  private View ArQ;
  private View ArR;
  private b ArS;
  private ScaleAnimation ArT;
  private ScaleAnimation ArU;
  LinearLayout ArV;
  LinearLayout ArW;
  private LinkedList<dgh> ArX;
  private int ArY;
  private boolean ArZ;
  private int AsA;
  private boolean AsB;
  private boolean AsC;
  private n AsD;
  private TextView AsE;
  private boolean AsF;
  private FrameLayout AsG;
  private ai AsH;
  private com.tencent.mm.sdk.b.c AsI;
  private com.tencent.mm.sdk.b.c AsJ;
  private com.tencent.mm.sdk.b.c AsK;
  private com.tencent.mm.sdk.b.c AsL;
  private d AsN;
  private View.OnClickListener AsO;
  private com.tencent.mm.sdk.b.c AsP;
  private com.tencent.mm.sdk.b.c AsQ;
  boolean AsR;
  private LinearLayout AsS;
  private boolean AsT;
  PhotosContent AsU;
  int AsV;
  public au.b.a AsW;
  private bn AsX;
  private bb Asa;
  private String Asb;
  private bq Asc;
  private int Asd;
  private ImageView Ase;
  private j Asf;
  private l Asg;
  private boolean Ash;
  private long Asi;
  private bo Asj;
  private boolean Ask;
  private int Asl;
  private int Asm;
  public int Aso;
  private com.tencent.mm.plugin.sns.ui.c.a.a Asp;
  com.tencent.mm.plugin.sns.ad.e.j Asq;
  private SnsTranslateResultView Asr;
  private boolean Ass;
  private Dialog Ast;
  private boolean Asu;
  private boolean Asv;
  private String Asw;
  private boolean Asx;
  private int Asy;
  private boolean Asz;
  private String dAQ;
  private String dAg;
  private String fHO;
  private boolean kWY;
  private com.tencent.mm.sdk.b.c kzS;
  private int mScreenHeight;
  private int mScreenWidth;
  private int nJx;
  private int oOD;
  private com.tencent.mm.ui.widget.b.a ofu;
  private View.OnClickListener ogu;
  private View.OnClickListener pzq;
  private ClipboardManager rJr;
  private com.tencent.mm.plugin.sns.ui.d.c zrv;
  private LinearLayout zvX;
  
  static
  {
    AppMethodBeat.i(163117);
    Asn = 34;
    e.a locala = new e.a();
    locala.hgP = true;
    locala.hgO = true;
    AsM = locala.aru();
    srN = new SnsCommentDetailUI.41();
    locala = new e.a();
    locala.hgP = true;
    locala.hgO = true;
    Ahx = locala.aru();
    AppMethodBeat.o(163117);
  }
  
  public SnsCommentDetailUI()
  {
    AppMethodBeat.i(98590);
    this.ArJ = 0L;
    this.ArK = 0L;
    this.ArY = -1;
    this.ArZ = false;
    this.Aib = bu.fpL();
    this.AgA = null;
    this.nJx = 0;
    this.Asd = 0;
    this.kWY = false;
    this.dAQ = "";
    this.Ash = false;
    this.Asi = 0L;
    this.Ask = false;
    this.Asm = 103;
    this.Aso = 210;
    this.Ass = false;
    this.Ast = null;
    this.Asu = false;
    this.Asv = false;
    this.Asw = "";
    this.Asx = true;
    this.Asz = false;
    this.AsA = 0;
    this.AsB = false;
    this.AsC = false;
    this.AsD = null;
    this.AsE = null;
    this.AoZ = false;
    this.AsH = new ai();
    this.AsI = new com.tencent.mm.sdk.b.c() {};
    this.AsJ = new com.tencent.mm.sdk.b.c() {};
    this.AsK = new com.tencent.mm.sdk.b.c() {};
    this.AsL = new com.tencent.mm.sdk.b.c() {};
    this.AgC = new com.tencent.mm.sdk.b.c() {};
    this.AsN = new d();
    this.ogu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(98579);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = (String)paramAnonymousView.getTag();
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsCommentDetailUI", "onCommentClick:".concat(String.valueOf(paramAnonymousView)));
        com.tencent.mm.plugin.sns.storage.p localp = SnsCommentDetailUI.e(SnsCommentDetailUI.this);
        if ((localp != null) && (localp.Rt(32)))
        {
          localObject = new SnsAdClick(SnsCommentDetailUI.this.getSource(), 2, localp.field_snsId, 1, 0);
          com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject, SnsCommentDetailUI.f(SnsCommentDetailUI.this), localp, 1);
          com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject);
          if ((paramAnonymousView != null) && (paramAnonymousView.equals(localp.field_userName)))
          {
            com.tencent.mm.plugin.sns.storage.b localb = localp.dVj();
            if ((localb != null) && (localb.zNc == 1) && (!bu.isNullOrNil(localb.zNd)))
            {
              localObject = localb.zNd;
              com.tencent.mm.plugin.sns.storage.a locala = SnsCommentDetailUI.a(SnsCommentDetailUI.this, localp);
              paramAnonymousView = (View)localObject;
              if (locala != null) {
                paramAnonymousView = com.tencent.mm.plugin.sns.data.r.jo((String)localObject, locala.dGD);
              }
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "headClickParam url " + paramAnonymousView + " " + localb.zNe);
              localObject = new Intent();
              if (localb.zNe == 0) {
                bool = true;
              }
              ((Intent)localObject).putExtra("KsnsViewId", SnsCommentDetailUI.a(SnsCommentDetailUI.this, localp).aQj);
              ((Intent)localObject).putExtra("KRightBtn", bool);
              ((Intent)localObject).putExtra("jsapiargs", new Bundle());
              ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
              ((Intent)localObject).putExtra("useJs", true);
              com.tencent.mm.plugin.sns.c.a.iUz.i((Intent)localObject, SnsCommentDetailUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(98579);
              return;
            }
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
          ((Intent)localObject).putExtra("Contact_Scene", 37);
          com.tencent.mm.plugin.sns.c.a.iUz.c((Intent)localObject, SnsCommentDetailUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98579);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
        com.tencent.mm.plugin.sns.c.a.iUz.c((Intent)localObject, SnsCommentDetailUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98579);
      }
    };
    this.AsO = new SnsCommentDetailUI.43(this);
    this.pzq = new SnsCommentDetailUI.3(this);
    this.AsP = new SnsCommentDetailUI.8(this);
    this.kzS = new com.tencent.mm.sdk.b.c() {};
    this.AsQ = new SnsCommentDetailUI.10(this);
    this.ApP = new bi.a()
    {
      public final void X(String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(219847);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onScreenShot， path = " + paramAnonymousString + "， dateAdded = " + paramAnonymousLong);
        SnsCommentDetailUI.v(SnsCommentDetailUI.this);
        AppMethodBeat.o(219847);
      }
    };
    this.AsR = false;
    this.AsS = null;
    this.AsT = false;
    this.AsU = null;
    this.AsV = 0;
    this.AsW = new au.b.a()
    {
      public final void p(final String paramAnonymousString, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(219859);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "setAvatar, getContactCallBack, userName=" + paramAnonymousString + ", succ=" + paramAnonymousBoolean + ", retryCount=" + SnsCommentDetailUI.this.AsV);
        new com.tencent.mm.sdk.platformtools.aq(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219858);
            if ((paramAnonymousBoolean) && (!SnsCommentDetailUI.this.isFinishing()) && (SnsCommentDetailUI.this.AsV < 5))
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "setAvatar, setHeader after getContact, userName=" + paramAnonymousString);
              SnsCommentDetailUI.this.efr();
            }
            SnsCommentDetailUI localSnsCommentDetailUI = SnsCommentDetailUI.this;
            localSnsCommentDetailUI.AsV += 1;
            AppMethodBeat.o(219858);
          }
        }, 500L);
        AppMethodBeat.o(219859);
      }
    };
    this.AsX = null;
    AppMethodBeat.o(98590);
  }
  
  private LinearLayout RL(int paramInt)
  {
    AppMethodBeat.i(98601);
    if (this.AsS == null)
    {
      this.AsS = ((LinearLayout)z.jV(this).inflate(paramInt, null));
      localLinearLayout = this.AsS;
      AppMethodBeat.o(98601);
      return localLinearLayout;
    }
    this.AsR = true;
    LinearLayout localLinearLayout = this.AsS;
    AppMethodBeat.o(98601);
    return localLinearLayout;
  }
  
  private static void a(com.tencent.mm.plugin.sns.storage.p paramp, PhotosContent paramPhotosContent, int paramInt)
  {
    AppMethodBeat.i(219879);
    if ((paramp != null) && (paramp.Rt(32)) && (paramInt == 2))
    {
      FrameLayout.LayoutParams localLayoutParams = null;
      try
      {
        paramp = paramp.dVj();
        if ((paramp != null) && (paramp.dZM()))
        {
          paramp = paramPhotosContent.findViewById(2131305201);
          if (paramp == null) {}
        }
        int i;
        int j;
        if (paramPhotosContent == null) {
          break label184;
        }
      }
      catch (Throwable paramp)
      {
        try
        {
          paramp.setVisibility(0);
          paramPhotosContent = (FrameLayout.LayoutParams)paramPhotosContent.RH(0).getLayoutParams();
          localLayoutParams = (FrameLayout.LayoutParams)paramp.getLayoutParams();
          paramInt = paramPhotosContent.width / 2 - localLayoutParams.width / 2 + paramPhotosContent.leftMargin;
          i = paramPhotosContent.height / 2;
          j = localLayoutParams.height / 2;
          i = paramPhotosContent.topMargin + (i - j);
          if ((paramInt != localLayoutParams.leftMargin) || (i != localLayoutParams.topMargin))
          {
            localLayoutParams.leftMargin = paramInt;
            localLayoutParams.topMargin = i;
            paramp.setLayoutParams(localLayoutParams);
          }
          AppMethodBeat.o(219879);
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            paramPhotosContent = paramp;
            paramp = localThrowable;
          }
        }
        paramp = paramp;
        paramPhotosContent = localLayoutParams;
      }
      paramPhotosContent.setVisibility(8);
      label184:
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI", "checkShowStatusIcon exp=" + paramp.toString());
    }
    else
    {
      AppMethodBeat.o(219879);
      return;
    }
  }
  
  private void a(PhotosContent paramPhotosContent)
  {
    AppMethodBeat.i(219876);
    if (paramPhotosContent == null)
    {
      AppMethodBeat.o(219876);
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
      localImageView.setImageDrawable(com.tencent.mm.cb.a.l(getContext(), 2131235087));
      localImageView.setLayoutParams(localLayoutParams);
      paramPhotosContent.addView(localImageView);
      AppMethodBeat.o(219876);
      return;
    }
    catch (Throwable paramPhotosContent)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI", paramPhotosContent.toString());
      AppMethodBeat.o(219876);
    }
  }
  
  private void a(PhotosContent paramPhotosContent, int paramInt)
  {
    AppMethodBeat.i(219877);
    if ((paramPhotosContent == null) || (paramInt <= 1))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI", "photosContent == null or imgNums <= 1");
      AppMethodBeat.o(219877);
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
          if (paramPhotosContent.RH(i).getVisibility() == 8)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "current index " + i + " imageView is a placeholder, so visibility is gone");
          }
          else
          {
            ImageView localImageView = com.tencent.mm.plugin.sns.ad.timeline.a.b.a(getContext(), paramPhotosContent, i, j);
            if (localImageView != null) {
              paramPhotosContent.addView(localImageView);
            }
          }
        }
      }
      catch (Throwable paramPhotosContent)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI", paramPhotosContent.toString());
        AppMethodBeat.o(219877);
        return;
      }
      AppMethodBeat.o(219877);
      return;
      i += 1;
    }
  }
  
  private boolean a(com.tencent.mm.plugin.sns.storage.p paramp, SnsAdTimelineVideoView paramSnsAdTimelineVideoView)
  {
    AppMethodBeat.i(219878);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramSnsAdTimelineVideoView != null)
    {
      bool1 = bool2;
      if (this.AsF)
      {
        bool1 = bool2;
        if (paramp != null)
        {
          bool1 = bool2;
          if (paramp.Rt(32)) {
            bool1 = true;
          }
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "the useNewPlayer return value is ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(219878);
    return bool1;
  }
  
  private void b(com.tencent.mm.plugin.sns.storage.p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(98603);
    if (this.AsE == null)
    {
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
      this.AsE = new TextView(this);
      this.AsE.setLayoutParams(localLayoutParams);
      this.AsE.setText(getString(2131763801));
      this.AsE.setTextColor(getResources().getColor(2131100711));
      this.AsE.setGravity(17);
      this.AsE.setPadding(0, BackwardSupportUtil.b.h(this, 7.0F), 0, BackwardSupportUtil.b.h(this, 12.0F));
      this.AsE.setVisibility(8);
      this.ArP.addFooterView(this.AsE);
    }
    if (paramp != null)
    {
      if ((paramp.field_localPrivate & 0x1) != 0)
      {
        findViewById(2131298521).setVisibility(8);
        paramp = paramp.ebP();
        if (paramp != null) {
          switch (paramp.HUG.Gtw)
          {
          }
        }
        for (;;)
        {
          this.AsE.setVisibility(0);
          AppMethodBeat.o(98603);
          return;
          this.AsE.setText(getString(2131763802));
          continue;
          this.AsE.setText(getString(2131763805));
          continue;
          this.AsE.setText(getString(2131763803));
        }
      }
      if (paramBoolean) {
        findViewById(2131298521).setVisibility(0);
      }
      this.AsE.setVisibility(8);
    }
    AppMethodBeat.o(98603);
  }
  
  private int efp()
  {
    AppMethodBeat.i(98600);
    if ((this.ArP != null) && (this.ArP.getChildCount() > 1))
    {
      View localView = this.ArP.getChildAt(0);
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
  
  private static boolean efq()
  {
    AppMethodBeat.i(98602);
    if ((ao.a.dYj() & 0x1) <= 0)
    {
      AppMethodBeat.o(98602);
      return true;
    }
    AppMethodBeat.o(98602);
    return false;
  }
  
  private void efs()
  {
    AppMethodBeat.i(98605);
    if ((this.ArQ == null) || (this.ArQ.getVisibility() == 8))
    {
      AppMethodBeat.o(98605);
      return;
    }
    this.ArQ.startAnimation(this.ArU);
    this.ArU.setAnimationListener(new SnsCommentDetailUI.38(this));
    AppMethodBeat.o(98605);
  }
  
  private void eft()
  {
    AppMethodBeat.i(98606);
    if ((keyboardState() == 1) || (this.Agn.efx()))
    {
      this.AsN.run();
      AppMethodBeat.o(98606);
      return;
    }
    this.Agk = true;
    AppMethodBeat.o(98606);
  }
  
  private void efu()
  {
    AppMethodBeat.i(98607);
    if (this.Ase == null)
    {
      AppMethodBeat.o(98607);
      return;
    }
    this.Ase.setPressed(false);
    if (bo.aye(this.dAQ))
    {
      this.Ase.setImageResource(2131233393);
      AppMethodBeat.o(98607);
      return;
    }
    this.Ase.setImageResource(2131233395);
    AppMethodBeat.o(98607);
  }
  
  private static boolean f(LinkedList<dgh> paramLinkedList1, LinkedList<dgh> paramLinkedList2)
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
      if (!((dgh)paramLinkedList1.get(i)).Username.equals(((dgh)paramLinkedList2.get(i)).Username))
      {
        AppMethodBeat.o(98591);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(98591);
    return true;
  }
  
  private com.tencent.mm.plugin.sns.storage.a g(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(98594);
    if (paramp != null)
    {
      if (getSource() == 2)
      {
        paramp = paramp.ebM();
        AppMethodBeat.o(98594);
        return paramp;
      }
      paramp = paramp.dVi();
      AppMethodBeat.o(98594);
      return paramp;
    }
    AppMethodBeat.o(98594);
    return null;
  }
  
  private boolean j(List<dgh> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(98608);
    int k = BackwardSupportUtil.b.h(this, 32.0F);
    int m = BackwardSupportUtil.b.h(this, 6.0F);
    int i = BackwardSupportUtil.b.h(this, 10.0F);
    int j = BackwardSupportUtil.b.h(this, 17.0F);
    if (this.ArN == null)
    {
      AppMethodBeat.o(98608);
      return false;
    }
    int n = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    float f = getResources().getDimension(2131165516);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsCommentDetailUI", "guess size %d %f", new Object[] { Integer.valueOf(n), Float.valueOf(f) });
    f = n - f * 2.0F;
    if (paramList.size() <= 0)
    {
      if (this.ArN.getParent() != null) {
        this.ArN.setVisibility(8);
      }
      this.ArN.removeAllViews();
      this.ArN.setVisibility(8);
      this.zvX.setVisibility(8);
      AppMethodBeat.o(98608);
      return false;
    }
    this.ArN.getParent();
    this.ArN.removeAllViews();
    this.ArN.setVisibility(0);
    Object localObject1;
    if (this.oOD == 10) {
      if (!this.Ass)
      {
        this.ArN.setBackgroundResource(2131232445);
        this.ArN.setPadding(0, m, 0, m);
        localObject1 = new ImageView(getContext());
        if (this.oOD != 10) {
          break label692;
        }
        ((ImageView)localObject1).setImageResource(2131690248);
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
      this.ArN.addView((View)localObject1);
      n = com.tencent.mm.cb.a.fromDPToPix(getContext(), Asn);
      j = (int)(f - n) / (m + k);
      i = j;
      if ((int)(f - n) % (m + k) > k) {
        i = j + 1;
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsCommentDetailUI", "guess size %d", new Object[] { Integer.valueOf(i) });
      localObject1 = new h(getContext());
      ((h)localObject1).setClipChildren(false);
      ((h)localObject1).setClipToPadding(false);
      ((h)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((h)localObject1).setLineMaxCounte(i);
      i = 0;
      while (i < paramList.size())
      {
        localObject2 = (dgh)paramList.get(i);
        StoryTouchImageView localStoryTouchImageView = new StoryTouchImageView(getContext());
        localStoryTouchImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localStoryTouchImageView.setImageResource(2131232455);
        Object localObject3 = ((dgh)localObject2).Username;
        localStoryTouchImageView.AGW.fn((String)localObject3, 1);
        localObject3 = new LinearLayout.LayoutParams(k, k);
        ((LinearLayout.LayoutParams)localObject3).setMargins(0, m, m, 0);
        localStoryTouchImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localStoryTouchImageView.setTag(((dgh)localObject2).Username);
        a.b.w(localStoryTouchImageView, ((dgh)localObject2).Username);
        localStoryTouchImageView.setOnClickListener(this.ogu);
        ((h)localObject1).addView(localStoryTouchImageView);
        i += 1;
      }
      localObject1 = rW(false);
      if (localObject1 != null)
      {
        if (this.fHO.equals(((com.tencent.mm.plugin.sns.storage.p)localObject1).field_userName))
        {
          this.ArN.setBackgroundResource(2131232446);
          break;
        }
        this.ArN.setBackgroundResource(2131232445);
        break;
      }
      this.ArN.setBackgroundResource(2131232445);
      break;
      this.ArN.setBackgroundResource(2131232453);
      break;
      label692:
      ((ImageView)localObject1).setImageDrawable(ao.k(getContext(), 2131690247, getContext().getResources().getColor(2131099769)));
    }
    this.ArN.addView((View)localObject1);
    paramList = this.zvX;
    if (paramBoolean) {}
    for (i = 8;; i = 0)
    {
      paramList.setVisibility(i);
      AppMethodBeat.o(98608);
      return true;
    }
  }
  
  private void rV(boolean paramBoolean)
  {
    AppMethodBeat.i(98592);
    this.ArZ = false;
    if (this.Agn.efw())
    {
      this.Agn.AtF = 0;
      this.Agn.efz();
      this.Agn.setCommentHint(getString(2131764046));
    }
    this.Agn.rX(false);
    if (paramBoolean)
    {
      Object localObject1 = this.ArP;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "scrollDown", "(Z)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
      BackwardSupportUtil.c.b((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "scrollDown", "(Z)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    }
    AppMethodBeat.o(98592);
  }
  
  private com.tencent.mm.plugin.sns.storage.p rW(boolean paramBoolean)
  {
    AppMethodBeat.i(98593);
    com.tencent.mm.plugin.sns.storage.p localp;
    if (!bu.isNullOrNil(this.Asb))
    {
      localp = com.tencent.mm.plugin.sns.storage.h.aBr(this.Asb);
      if (localp == null)
      {
        if (paramBoolean) {
          Toast.makeText(this, 2131763915, 0).show();
        }
        finish();
        AppMethodBeat.o(98593);
        return null;
      }
      this.dAg = localp.getSnsId();
    }
    for (;;)
    {
      AppMethodBeat.o(98593);
      return localp;
      localp = com.tencent.mm.plugin.sns.storage.h.aBq(this.dAg);
      if (localp == null)
      {
        finish();
        AppMethodBeat.o(98593);
        return null;
      }
      this.Asb = localp.eco();
    }
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void azJ(String paramString) {}
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void bQ(String paramString, boolean paramBoolean) {}
  
  public final void bR(String paramString, boolean paramBoolean) {}
  
  public final void dWB() {}
  
  public final am edc()
  {
    return this.Agx;
  }
  
  public final b edd()
  {
    return this.Agv;
  }
  
  public final bp ede()
  {
    return null;
  }
  
  public final br edf()
  {
    return this.Agy;
  }
  
  final boolean efr()
  {
    AppMethodBeat.i(98604);
    final com.tencent.mm.plugin.sns.storage.p localp = rW(true);
    if (localp == null)
    {
      AppMethodBeat.o(98604);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "setheader " + this.ArL.toString());
    this.Asl = ah.dXP();
    Object localObject6 = localp.ebP();
    this.oOD = bh.c(localp, false);
    Object localObject1 = (SnsAvatarImageView)this.ArL.findViewById(2131296533);
    Object localObject5 = (RelativeLayout)this.ArL.findViewById(2131303033);
    ((RelativeLayout)localObject5).setVisibility(8);
    ((RelativeLayout)localObject5).setOnClickListener(this.zrv.AQq);
    Object localObject2;
    boolean bool1;
    if ((localObject1 == null) || (localp == null))
    {
      localObject2 = new StringBuilder("unknow error ? ");
      if (localObject1 == null)
      {
        bool1 = true;
        localObject1 = ((StringBuilder)localObject2).append(bool1).append(" ");
        if (localp != null) {
          break label211;
        }
      }
      label211:
      for (bool1 = true;; bool1 = false)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI", bool1);
        AppMethodBeat.o(98604);
        return false;
        bool1 = false;
        break;
      }
    }
    ((SnsAvatarImageView)localObject1).setWeakContext(this);
    ((MaskImageButton)localObject1).hjr = localp.eco();
    ((SnsAvatarImageView)localObject1).setTag(localp.getUserName());
    boolean bool2 = false;
    if ((localp.dVj() != null) && (localp.dVj().zNN))
    {
      if (bu.isNullOrNil(localp.dVj().zNP)) {
        break label12281;
      }
      localObject2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", localp.dVj().zNP);
      ((SnsAvatarImageView)localObject1).setTag(2131305044, localp.dVj().zNP);
      if (com.tencent.mm.vfs.o.fB((String)localObject2))
      {
        localObject2 = com.tencent.mm.plugin.sns.ad.e.m.zqi.getBitmap((String)localObject2);
        if (localObject2 != null) {
          ((SnsAvatarImageView)localObject1).setImageBitmap((Bitmap)localObject2);
        }
        bool1 = true;
      }
    }
    label344:
    label607:
    label868:
    label10727:
    label11243:
    for (;;)
    {
      ((SnsAvatarImageView)localObject1).setOnClickListener(this.zrv.APM);
      localObject2 = (TextView)this.ArL.findViewById(2131302867);
      com.tencent.mm.kernel.g.ajS();
      Object localObject7 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(localp.getUserName());
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "snsinfo username " + localp.getUserName() + " " + localp.getSnsId() + " " + localp.getCreateTime() + ", isAdAndUsePreferedInfo=" + bool1);
      if ((localObject7 != null) && (((an)localObject7).adE() == 0) && (!bool1))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "getContact %s", new Object[] { localp.getUserName() });
        au.a.aBQ().a(localp.getUserName(), "", this.AsW);
      }
      int j = 0;
      if (localObject7 == null) {}
      Object localObject4;
      int i;
      int k;
      for (localObject1 = localp.getUserName();; localObject1 = ((an)localObject7).adG())
      {
        localObject1 = bu.bI((String)localObject1, "");
        if (!localp.vx()) {
          break label1655;
        }
        localObject4 = localp.dVj();
        if (localObject4 == null) {
          break label12278;
        }
        if (!((com.tencent.mm.plugin.sns.storage.b)localObject4).zNN) {
          break label1619;
        }
        localObject4 = ((com.tencent.mm.plugin.sns.storage.b)localObject4).zNO;
        i = 0;
        ((String)localObject4).length();
        if (this.oOD != 10) {
          break label1781;
        }
        k = 3;
        localObject1 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject4));
        ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).b(new com.tencent.mm.pluginsdk.ui.span.p(new com.tencent.mm.plugin.sns.data.a(localp.vx(), ((an)localObject7).getUsername(), localp.eco(), 2), this.Asf, k), (CharSequence)localObject4);
        if ((j >= 0) && (i > j)) {
          ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).setSpan(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).f(this, ((an)localObject7).VP(), this.AsA), j, i, 33);
        }
        ((TextView)localObject2).setOnTouchListener(new ae());
        ((TextView)localObject2).setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        ((TextView)this.ArL.findViewById(2131306175)).setText("");
        this.AsX = new bn(this.ArL);
        if (!localp.vx()) {
          break label1787;
        }
        this.AsX.H(Long.valueOf(localp.field_snsId), new com.tencent.mm.plugin.sns.data.b(this.AsX, 0, this.Asb, localp.field_snsId, g(localp).aQj));
        this.AsX.b(localp.dVj(), g(localp));
        this.AsX.a(this.zrv.APX, this.zrv.AQn);
        this.AsX.setVisibility(0);
        localObject1 = ((TimeLineObject)localObject6).HUD;
        this.ArM = ((TextView)this.ArL.findViewById(2131299008));
        localObject2 = new bd(this.dAg, localp.eco(), true, false, 2);
        this.ArM.setTag(localObject2);
        this.ofu.c(this.ArM, this.zrv.APO, this.zrv.APL);
        if (!bu.isNullOrNil((String)localObject1)) {
          break label1799;
        }
        this.ArM.setVisibility(8);
        localObject1 = (ViewStub)this.ArL.findViewById(2131300969);
        if (!this.AsT) {
          ((ViewStub)localObject1).setLayoutResource(-1);
        }
        switch (this.oOD)
        {
        case 6: 
        case 7: 
        case 8: 
        case 12: 
        case 16: 
        case 17: 
        default: 
          ((ViewStub)localObject1).setVisibility(8);
          if (((ViewStub)localObject1).getLayoutResource() == -1) {
            break label2077;
          }
          localObject2 = ((ViewStub)localObject1).inflate();
          if (this.Asp != null)
          {
            this.Asp.kFh = findViewById(2131305824);
            this.Asp.m((View)localObject2, this.ArR);
            if (((this.Asp instanceof com.tencent.mm.plugin.sns.ui.c.a.c)) && (this.AsG != null)) {
              ((com.tencent.mm.plugin.sns.ui.c.a.c)this.Asp).c(this.AsG);
            }
          }
          this.AsT = true;
          k = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
          if (this.oOD == 6) {
            break label2629;
          }
          if ((this.oOD != 2) && (this.oOD != 3) && (this.oOD != 4) && (this.oOD != 5)) {
            break label4311;
          }
          this.AsU = ((PhotosContent)findViewById(2131303243));
          if (this.AsU == null) {
            break label4268;
          }
          this.AsU.eeo();
          if (this.oOD != 2) {
            break label2087;
          }
          i = 1;
          j = 0;
          while (j < i)
          {
            localObject1 = (TagImageView)this.AsU.findViewById(bb.Axj[j]);
            this.AsU.a((TagImageView)localObject1);
            ((TagImageView)localObject1).setOnClickListener(this.zrv.AiC);
            this.ofu.c((View)localObject1, this.zrv.AQa, this.zrv.APL);
            j += 1;
          }
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localp.dVj().zNP, false, new f.a()
          {
            public final void ayY(String paramAnonymousString)
            {
              AppMethodBeat.i(163106);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "download img %s", new Object[] { paramAnonymousString });
              String str = (String)this.Atf.getTag(2131305044);
              if ((!bu.V(new String[] { str, paramAnonymousString })) && (paramAnonymousString.equals(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jL("adId", str))))
              {
                paramAnonymousString = com.tencent.mm.plugin.sns.ad.e.m.zqi.getBitmap(paramAnonymousString);
                if (paramAnonymousString != null) {
                  this.Atf.setImageBitmap(paramAnonymousString);
                }
              }
              AppMethodBeat.o(163106);
            }
            
            public final void dVu() {}
            
            public final void dVv()
            {
              AppMethodBeat.i(219860);
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI", "onDownloadError");
              AppMethodBeat.o(219860);
            }
          });
          bool1 = true;
          break label344;
          if (!localp.getUserName().endsWith("@ad"))
          {
            if (localp.vx()) {}
            for (;;)
            {
              try
              {
                com.tencent.mm.kernel.g.ajS();
                localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(localp.getUserName());
                if ((localObject2 == null) || (((an)localObject2).adE() == 0)) {
                  continue;
                }
                a.b.w((ImageView)localObject1, localp.getUserName());
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "has contact before setAvatar, userName=" + localp.getUserName());
              }
              catch (Exception localException)
              {
                com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI", "setAvatar exp=" + localException.toString());
                continue;
              }
              ((SnsAvatarImageView)localObject1).fn(localp.getUserName(), 2);
              bool1 = bool2;
              if (bu.lX(this.fHO, localp.getUserName())) {
                break;
              }
              bool1 = bool2;
              break;
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI", "has no contact before setAvatar, userName=" + localp.getUserName());
              continue;
              a.b.w((ImageView)localObject1, localp.getUserName());
            }
          }
          bool1 = true;
          break label344;
        }
      }
      if ((bu.isNullOrNil((String)localObject1)) && (!bu.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject4).nickname))) {
        localObject1 = ((com.tencent.mm.plugin.sns.storage.b)localObject4).nickname;
      }
      label1781:
      label5365:
      label12278:
      for (;;)
      {
        i = 0;
        localObject4 = localObject1;
        break;
        label1655:
        if ((localObject7 != null) && (an.aUq(((an)localObject7).getUsername())) && ("3552365301".equals(((an)localObject7).VP())))
        {
          j = ((String)localObject1).length();
          localObject4 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).bC(((an)localObject7).VP(), ((an)localObject7).VO());
          localObject4 = (String)localObject1 + " @" + (String)localObject4;
          i = ((String)localObject4).length();
          ((RelativeLayout)localObject5).setTag(new com.tencent.mm.plugin.sns.data.f((View)localObject5, localp.eco()));
          ((RelativeLayout)localObject5).setVisibility(0);
          break;
          k = 2;
          break label607;
          label1787:
          this.AsX.setVisibility(8);
          break label868;
          this.ArM.setText((String)localObject1 + " ");
          com.tencent.mm.pluginsdk.ui.span.k.o(this.ArM, 2);
          this.ArM.setVisibility(0);
          com.tencent.mm.plugin.sns.j.e.zKO.dZk().Tr();
          break label964;
          ((ViewStub)localObject1).setLayoutResource(2131495611);
          break label1091;
          ((ViewStub)localObject1).setLayoutResource(2131495608);
          break label1091;
          ((ViewStub)localObject1).setLayoutResource(2131495609);
          break label1091;
          ((ViewStub)localObject1).setLayoutResource(2131495610);
          break label1091;
          ((ViewStub)localObject1).setLayoutResource(2131495566);
          break label1091;
          ((ViewStub)localObject1).setLayoutResource(2131495550);
          break label1091;
          ((ViewStub)localObject1).setLayoutResource(2131496489);
          break label1091;
          ((ViewStub)localObject1).setLayoutResource(2131495488);
          this.Asp = new com.tencent.mm.plugin.sns.ui.c.a.b((TimeLineObject)localObject6, localp, this.zrv, this.Asq);
          break label1091;
          ((ViewStub)localObject1).setLayoutResource(2131495614);
          this.Asp = new com.tencent.mm.plugin.sns.ui.c.a.e((TimeLineObject)localObject6, localp, this.zrv, this.Asq);
          break label1091;
          ((ViewStub)localObject1).setLayoutResource(2131495603);
          this.Asp = new com.tencent.mm.plugin.sns.ui.c.a.c((TimeLineObject)localObject6, localp, this.zrv, this.Asq);
          break label1091;
          ((ViewStub)localObject1).setLayoutResource(2131495604);
          this.Asp = new com.tencent.mm.plugin.sns.ui.c.a.d((TimeLineObject)localObject6, localp, this.zrv);
          break label1091;
          ((ViewStub)localObject1).setLayoutResource(2131495566);
          break label1091;
          ((ViewStub)localObject1).setVisibility(8);
          break label1177;
          i = bb.Axf[this.oOD];
          break label1280;
          this.AsU.setImageViewWidth(this.Asl);
          localObject1 = new LinkedList();
          Object localObject3;
          float f2;
          float f1;
          Object localObject8;
          if ((localp.vx()) && (this.oOD == 2))
          {
            localObject3 = localp.dVj();
            this.AsU.RH(0).setScaleType(QImageView.a.Lpz);
            if ((localObject3 != null) && (!((com.tencent.mm.plugin.sns.storage.b)localObject3).dZA()) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).zNt > 0.0F) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).zNu > 0.0F))
            {
              f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).zNt, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNv, ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNw);
              f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).zNu, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNv, ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNw);
              if (((com.tencent.mm.plugin.sns.storage.b)localObject3).zNs != 0) {
                break label3982;
              }
              float f3 = f1;
              f1 = f2;
              if (f2 >= k - com.tencent.mm.cb.a.ax(this, 2131166827) - com.tencent.mm.cb.a.ax(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516))
              {
                f1 = k - com.tencent.mm.cb.a.ax(this, 2131166827) - com.tencent.mm.cb.a.ax(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
                f3 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject3).zNu * f1 / ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNt);
              }
              localObject5 = new bzj();
              ((bzj)localObject5).Hna = f1;
              ((bzj)localObject5).Hnb = f3;
              ((bzj)localObject5).Hnc = (((bzj)localObject5).Hna * ((bzj)localObject5).Hnb);
              ((LinkedList)localObject1).add(localObject5);
            }
            if ((com.tencent.mm.plugin.sns.data.k.a(localp, getSource())) && (!com.tencent.mm.plugin.sns.data.k.m(localp))) {
              a(this.AsU);
            }
            if (!bu.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject3).zNy))
            {
              localObject5 = this.AsU;
              localObject8 = this.AsU.RH(0);
              com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNy, false, 41, new f.a()
              {
                public final void ayY(String paramAnonymousString)
                {
                  AppMethodBeat.i(219861);
                  MaskImageView localMaskImageView = (MaskImageView)this.Atg.findViewById(2131302209);
                  if (localMaskImageView != null)
                  {
                    localMaskImageView.setVisibility(0);
                    localMaskImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymousString));
                    float f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.Ath.zNz, 1, this.Ath.zNv, this.Ath.zNw);
                    float f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.Ath.zNA, 1, this.Ath.zNv, this.Ath.zNw);
                    float f3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.Ath.zNB, 1, this.Ath.zNv, this.Ath.zNw);
                    float f4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.Ath.zNC, 1, this.Ath.zNv, this.Ath.zNw);
                    paramAnonymousString = new FrameLayout.LayoutParams((int)f1, (int)f2);
                    paramAnonymousString.setMargins((int)(this.Ati.getRight() - f3 - f1), (int)(this.Ati.getBottom() - f4 - f2), 0, 0);
                    localMaskImageView.setLayoutParams(paramAnonymousString);
                  }
                  AppMethodBeat.o(219861);
                }
                
                public final void dVu() {}
                
                public final void dVv() {}
              });
            }
          }
          this.ArL.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
          {
            boolean Atj = false;
            
            public final void onViewAttachedToWindow(View paramAnonymousView)
            {
              AppMethodBeat.i(219862);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "onViewAttachedToWindow infoHeader %s", new Object[] { Boolean.valueOf(this.Atj) });
              if (!this.Atj)
              {
                AppMethodBeat.o(219862);
                return;
              }
              this.Atj = false;
              if (this.Atk == null)
              {
                AppMethodBeat.o(219862);
                return;
              }
              if (localp == null)
              {
                AppMethodBeat.o(219862);
                return;
              }
              if (SnsCommentDetailUI.this.AsU == null)
              {
                AppMethodBeat.o(219862);
                return;
              }
              paramAnonymousView = SnsCommentDetailUI.G(SnsCommentDetailUI.this);
              PhotosContent localPhotosContent = SnsCommentDetailUI.this.AsU;
              TimeLineObject localTimeLineObject = this.Atk;
              String str = localp.eco();
              SnsCommentDetailUI.E(SnsCommentDetailUI.this);
              paramAnonymousView.a(localPhotosContent, localTimeLineObject, str, SnsCommentDetailUI.this.hashCode(), SnsCommentDetailUI.F(SnsCommentDetailUI.this), -1, localp.Rt(32), false, bk.JgB, this.Atl, localp.getSnsId(), localp);
              SnsCommentDetailUI.b(localp, SnsCommentDetailUI.this.AsU, SnsCommentDetailUI.F(SnsCommentDetailUI.this));
              AppMethodBeat.o(219862);
            }
            
            public final void onViewDetachedFromWindow(View paramAnonymousView)
            {
              AppMethodBeat.i(219863);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "onViewDetachedFromWindow infoHeader");
              this.Atj = true;
              AppMethodBeat.o(219863);
            }
          });
          this.Asa.a(this.AsU, (TimeLineObject)localObject6, localp.eco(), hashCode(), this.oOD, -1, localp.Rt(32), false, bk.JgB, (List)localObject1, localp.getSnsId(), localp);
          a(localp, this.AsU, this.oOD);
          if ((localp.vx()) && ((this.oOD == 3) || (this.oOD == 4) || (this.oOD == 5)) && (com.tencent.mm.plugin.sns.data.k.a(localp, getSource())) && (!com.tencent.mm.plugin.sns.data.k.m(localp)))
          {
            i = bb.Axf[this.oOD];
            a(this.AsU, i);
          }
          for (;;)
          {
            localObject5 = (TextView)this.ArL.findViewById(2131296531);
            if (!localp.vx()) {
              break label10727;
            }
            localObject3 = g(localp);
            if (localObject3 == null) {
              break label10717;
            }
            localObject1 = ((com.tencent.mm.plugin.sns.storage.a)localObject3).zLY;
            localObject3 = ((com.tencent.mm.plugin.sns.storage.a)localObject3).zLZ;
            ((TextView)localObject5).setTag(localp.eco());
            if (bu.isNullOrNil((String)localObject1)) {
              break label10717;
            }
            if (!bu.isNullOrNil((String)localObject3)) {
              break label10669;
            }
            ((TextView)localObject5).setVisibility(0);
            ((TextView)localObject5).setText((CharSequence)localObject1);
            ((TextView)localObject5).setClickable(false);
            ((TextView)localObject5).setTextColor(getContext().getResources().getColor(2131100212));
            this.ArL.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(219866);
                SnsCommentDetailUI.f(SnsCommentDetailUI.this).rq(false);
                AppMethodBeat.o(219866);
              }
            });
            ((TextView)localObject5).setOnClickListener(this.zrv.AQk);
            ((TextView)this.ArL.findViewById(2131296598)).setText(bj.r(getContext(), localp.getCreateTime() * 1000L));
            localObject5 = (AsyncTextView)this.ArL.findViewById(2131296528);
            ((TextView)localObject5).setOnClickListener(this.zrv.AQo);
            ((TextView)localObject5).setVisibility(8);
            localObject8 = (AsyncTextView)this.ArL.findViewById(2131296527);
            ((TextView)localObject8).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(98570);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
                paramAnonymousView = new SnsAdClick(SnsCommentDetailUI.this.getSource(), 2, localp.field_snsId, 24, 0);
                com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, SnsCommentDetailUI.f(SnsCommentDetailUI.this), localp, 24);
                com.tencent.mm.plugin.sns.data.r.a(paramAnonymousView);
                localObject = this.fVb.adG();
                paramAnonymousView = (View)localObject;
                if (localp.Rt(32)) {
                  paramAnonymousView = com.tencent.mm.plugin.sns.ui.widget.e.b(localp.dVj(), (String)localObject);
                }
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentFlag(1);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentHint(paramAnonymousView);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).rX(true);
                SnsCommentDetailUI.H(SnsCommentDetailUI.this).setVisibility(8);
                SnsCommentDetailUI.C(SnsCommentDetailUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98570);
              }
            });
            ((TextView)localObject8).setVisibility(8);
            if (localp.vx())
            {
              localObject7 = g(localp);
              ((TextView)localObject5).setTag(localp.eco());
              if (((com.tencent.mm.plugin.sns.storage.a)localObject7).zMa != com.tencent.mm.plugin.sns.storage.a.zLM) {
                break label10955;
              }
              if (bu.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject7).zMb)) {
                break label10945;
              }
              ((TextView)localObject5).setText(((com.tencent.mm.plugin.sns.storage.a)localObject7).zMb);
              ((TextView)localObject5).setVisibility(0);
              break label11243;
              if ((((TextView)localObject5).getVisibility() != 8) && (bu.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject7).zMc)))
              {
                ((TextView)localObject5).setTextColor(getResources().getColor(2131100943));
                ((TextView)localObject5).setOnClickListener(null);
              }
              if ((localp.ebP().HUG.Gty & 0x4) == 0) {
                break label11412;
              }
              ((TextView)localObject8).setTag(localp.eco());
              ((TextView)localObject8).setVisibility(0);
              ((TextView)localObject8).setText(String.format("%s%s%s", new Object[] { getContext().getResources().getString(2131763743), localObject4, getContext().getResources().getString(2131763744) }));
            }
            localObject1 = (WeImageView)this.ArL.findViewById(2131296627);
            if (((TimeLineObject)localObject6).HUG.Gtw != 30) {
              break label11422;
            }
            i = 0;
            ((WeImageView)localObject1).setVisibility(i);
            ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099660));
            localObject4 = (TextView)this.ArL.findViewById(2131296569);
            ((TextView)localObject4).setOnTouchListener(new ae());
            localObject3 = com.tencent.mm.plugin.sns.c.a.iUA.r(this, ((TimeLineObject)localObject6).HUF.Id);
            if (((TimeLineObject)localObject6).HUG.Gtw != 26) {
              break label11429;
            }
            localObject1 = getString(2131758845);
            bh.a((TimeLineObject)localObject6, this);
            if (!com.tencent.mm.plugin.sns.c.a.iUA.fD((String)localObject1)) {
              break label11727;
            }
            ((TextView)localObject4).setVisibility(0);
            localObject1 = new SpannableString(getString(2131763791) + (String)localObject1);
            ((SpannableString)localObject1).setSpan(new a(), 0, ((SpannableString)localObject1).length(), 33);
            ((TextView)localObject4).setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
            if ((((TimeLineObject)localObject6).HUF == null) || (!com.tencent.mm.pluginsdk.model.app.h.aNb(((TimeLineObject)localObject6).HUF.Id)))
            {
              ((TextView)localObject4).setTextColor(getResources().getColor(2131100943));
              ((TextView)localObject4).setOnTouchListener(null);
            }
            ((TextView)localObject4).setTag(localObject6);
            if (((TimeLineObject)localObject6).HUG.Gtw == 28)
            {
              ((TextView)localObject4).setTextColor(getResources().getColor(2131100914));
              ((TextView)localObject4).setOnTouchListener(null);
              if (this.ArL != null)
              {
                localObject1 = (Guideline)this.ArL.findViewById(2131308428);
                if (localObject1 != null) {
                  ((Guideline)localObject1).setGuidelineEnd(0);
                }
              }
              ((TextView)localObject4).setTag(localObject6);
              ((TextView)localObject4).setOnClickListener(new SnsCommentDetailUI.31(this, (TimeLineObject)localObject6));
            }
            localObject1 = (TextView)this.ArL.findViewById(2131296566);
            if (!localp.getUserName().equals(this.fHO)) {
              break label11737;
            }
            ((TextView)localObject1).setVisibility(0);
            ((TextView)localObject1).setTag(localp.eco() + ";" + localp.getSnsId());
            ((TextView)localObject1).setOnClickListener(new SnsCommentDetailUI.32(this));
            localObject4 = (TextView)this.ArL.findViewById(2131306999);
            localObject5 = al.u(localp);
            if (localObject5 != null) {
              break label11747;
            }
            ((TextView)localObject4).setVisibility(8);
            this.ArT = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
            this.ArT.setDuration(150L);
            this.ArU = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
            this.ArU.setDuration(150L);
            if (this.ArQ == null)
            {
              this.ArQ = this.ArL.findViewById(2131296548);
              this.ArQ.setVisibility(8);
            }
            this.ArV = ((LinearLayout)this.ArL.findViewById(2131296555));
            this.ArV.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(163113);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                if (!com.tencent.mm.plugin.sns.lucky.a.m.azK(localp.eco()))
                {
                  com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.AsU.RH(0));
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(163113);
                  return;
                }
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentInfo(null);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentFlag(0);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentHint(SnsCommentDetailUI.this.getString(2131764046));
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentInfo(new dgh());
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).setToSendTextColor(true);
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).rX(true);
                if ((localp.Rt(32)) && ((localp.ebP().HUG.Gty & 0x8) != 0)) {
                  SnsCommentDetailUI.c(SnsCommentDetailUI.this).mv(true);
                }
                for (;;)
                {
                  SnsCommentDetailUI.H(SnsCommentDetailUI.this).setVisibility(8);
                  SnsCommentDetailUI.C(SnsCommentDetailUI.this);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(163113);
                  return;
                  SnsCommentDetailUI.c(SnsCommentDetailUI.this).mv(false);
                }
              }
            });
            this.ArV.setOnTouchListener(this.Aib);
            this.ArW = ((LinearLayout)this.ArL.findViewById(2131296586));
            this.ArW.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(219868);
                Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
                if ((SnsCommentDetailUI.f(SnsCommentDetailUI.this) != null) && (localp.field_likeFlag == 0)) {
                  SnsCommentDetailUI.f(SnsCommentDetailUI.this).zM(localp.field_snsId);
                }
                localObject = SnsCommentDetailUI.this;
                paramAnonymousView = (LinearLayout)paramAnonymousView;
                ImageView localImageView = (ImageView)paramAnonymousView.findViewById(2131296585);
                ScaleAnimation localScaleAnimation = new ScaleAnimation(0.9F, 1.5F, 0.9F, 1.5F, 1, 0.5F, 1, 0.5F);
                localScaleAnimation.setDuration(400L);
                localScaleAnimation.setStartOffset(100L);
                localScaleAnimation.setRepeatCount(0);
                localImageView.clearAnimation();
                localImageView.startAnimation(localScaleAnimation);
                localScaleAnimation.setAnimationListener(new SnsCommentDetailUI.39((SnsCommentDetailUI)localObject, paramAnonymousView));
                SnsCommentDetailUI.I(SnsCommentDetailUI.this);
                com.tencent.mm.plugin.sns.j.e.zKO.dZk().eld = 3L;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(219868);
              }
            });
            this.ArW.setOnTouchListener(this.Aib);
            localObject1 = (ImageButton)this.ArL.findViewById(2131296599);
            localObject3 = rW(true);
            if ((localObject3 != null) && ((((com.tencent.mm.plugin.sns.storage.p)localObject3).ecj() & 0x1) != 0)) {
              ((ImageButton)localObject1).setVisibility(8);
            }
            if ((localObject3 != null) && (!((com.tencent.mm.plugin.sns.storage.p)localObject3).ecn())) {
              ((ImageButton)localObject1).setVisibility(8);
            }
            localObject3 = (ImageView)this.ArW.findViewById(2131296585);
            localObject4 = (ImageView)this.ArV.findViewById(2131296554);
            localObject5 = (TextView)this.ArW.findViewById(2131296587);
            localObject6 = (TextView)this.ArV.findViewById(2131296563);
            if (this.oOD == 10)
            {
              this.ArL.findViewById(2131296548).setBackgroundResource(2131232447);
              ((ImageButton)localObject1).setImageResource(2131232932);
              ((ImageView)localObject3).setImageResource(2131232933);
              ((ImageView)localObject4).setImageResource(2131232934);
              ((TextView)localObject5).setTextColor(getResources().getColor(2131100920));
              ((TextView)localObject6).setTextColor(getResources().getColor(2131100920));
              this.ArW.setBackgroundResource(2131233161);
              this.ArV.setBackgroundResource(2131233162);
            }
            ((ImageButton)localObject1).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(219869);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsCommentDetailUI", "showComment click" + SnsCommentDetailUI.H(SnsCommentDetailUI.this).getVisibility());
                com.tencent.mm.plugin.sns.ad.f.g.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a(localp, true, paramAnonymousView, SnsCommentDetailUI.f(SnsCommentDetailUI.this)));
                paramAnonymousView = localp.ebP();
                if ((paramAnonymousView != null) && (paramAnonymousView.HUG.Gtw == 21) && (!com.tencent.mm.plugin.sns.lucky.a.m.azK(localp.eco())))
                {
                  com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.AsU.RH(0));
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(219869);
                  return;
                }
                if (SnsCommentDetailUI.H(SnsCommentDetailUI.this).getVisibility() == 0) {
                  SnsCommentDetailUI.g(SnsCommentDetailUI.this);
                }
                for (;;)
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(219869);
                  return;
                  SnsCommentDetailUI.H(SnsCommentDetailUI.this).setVisibility(0);
                  SnsCommentDetailUI.H(SnsCommentDetailUI.this).startAnimation(SnsCommentDetailUI.J(SnsCommentDetailUI.this));
                  if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10) {
                    SnsCommentDetailUI.z(SnsCommentDetailUI.this).findViewById(2131296548).setBackgroundResource(2131232447);
                  }
                  if (!x.aBO(SnsCommentDetailUI.o(SnsCommentDetailUI.this)))
                  {
                    SnsCommentDetailUI.this.ArV.setEnabled(false);
                    SnsCommentDetailUI.this.ArW.setEnabled(false);
                    this.Atn.setText(SnsCommentDetailUI.this.getString(2131763882));
                    this.Atn.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131100911));
                    this.Ato.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131100911));
                    if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10) {
                      this.Atp.setImageResource(2131690238);
                    } else {
                      this.Atp.setImageResource(2131690241);
                    }
                  }
                  else
                  {
                    SnsCommentDetailUI.this.ArV.setEnabled(true);
                    this.Atp.setImageResource(2131232452);
                    SnsCommentDetailUI.this.ArW.setEnabled(true);
                    this.Atn.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101182));
                    this.Ato.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101182));
                    paramAnonymousView = com.tencent.mm.plugin.sns.storage.h.aBq(SnsCommentDetailUI.o(SnsCommentDetailUI.this));
                    if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10)
                    {
                      this.Atp.setImageResource(2131232933);
                      this.Atq.setImageResource(2131232934);
                      this.Atn.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131100920));
                      this.Ato.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131100920));
                    }
                    for (;;)
                    {
                      if ((paramAnonymousView == null) || (paramAnonymousView.field_likeFlag != 0)) {
                        break label616;
                      }
                      this.Atn.setText(SnsCommentDetailUI.this.getString(2131763882));
                      break;
                      this.Atp.setImageResource(2131232452);
                      this.Atn.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101182));
                      this.Ato.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101182));
                    }
                    label616:
                    this.Atn.setText(SnsCommentDetailUI.this.getString(2131763839));
                  }
                }
              }
            });
            AppMethodBeat.o(98604);
            return true;
            if (((com.tencent.mm.plugin.sns.storage.b)localObject3).zNs == 1)
            {
              i = k - com.tencent.mm.cb.a.ax(this, 2131166827) - com.tencent.mm.cb.a.ax(this, 2131166827) - com.tencent.mm.cb.a.ax(this, 2131165575) - com.tencent.mm.cb.a.ax(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
              j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNu / ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNt);
              localObject5 = new bzj();
              if (i > 0) {
                f2 = i;
              }
              ((bzj)localObject5).Hna = f2;
              if (j > 0) {
                f1 = j;
              }
              ((bzj)localObject5).Hnb = f1;
              ((bzj)localObject5).Hnc = (((bzj)localObject5).Hna * ((bzj)localObject5).Hnb);
              ((LinkedList)localObject1).add(localObject5);
              break;
            }
            if (((com.tencent.mm.plugin.sns.storage.b)localObject3).zNs != 2) {
              break;
            }
            i = k - com.tencent.mm.cb.a.ax(this, 2131166827) - com.tencent.mm.cb.a.ax(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
            j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNu / ((com.tencent.mm.plugin.sns.storage.b)localObject3).zNt);
            localObject5 = new bzj();
            if (i > 0) {
              f2 = i;
            }
            ((bzj)localObject5).Hna = f2;
            if (j > 0) {
              f1 = j;
            }
            ((bzj)localObject5).Hnb = f1;
            ((bzj)localObject5).Hnc = (((bzj)localObject5).Hna * ((bzj)localObject5).Hnb);
            ((LinkedList)localObject1).add(localObject5);
            break;
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.oOD + ",stub is " + ((ViewStub)localObject1).toString());
            continue;
            if (this.oOD != 10) {
              break label4768;
            }
            this.AsU = ((PhotosContent)findViewById(2131300686));
            this.AsU.eeo();
            localObject1 = (TagImageView)this.AsU.findViewById(2131296575);
            this.AsU.a((TagImageView)localObject1);
            ((TagImageView)localObject1).setOnClickListener(this.zrv.AiC);
            localObject3 = localp.eco();
            localObject5 = new ArrayList();
            ((List)localObject5).add(localObject1);
            localObject8 = new az();
            ((az)localObject8).dsN = ((String)localObject3);
            ((az)localObject8).index = 0;
            ((az)localObject8).AuK = ((List)localObject5);
            ((az)localObject8).Arr = true;
            if (localObject1 != null) {
              ((TagImageView)localObject1).setTag(localObject8);
            }
            localObject1 = (TextView)this.ArL.findViewById(2131300687);
            if (!v.aAC().equals(((TimeLineObject)localObject6).nIJ))
            {
              localObject3 = al.v(localp);
              if ((((SnsObject)localObject3).SnsRedEnvelops != null) && (((SnsObject)localObject3).SnsRedEnvelops.HOt != 0))
              {
                ((TextView)localObject1).setText(getString(2131760986, new Object[] { Integer.valueOf(((SnsObject)localObject3).SnsRedEnvelops.HOt) }));
                ((TextView)localObject1).setVisibility(0);
              }
            }
            for (;;)
            {
              localObject1 = localp.ech();
              if (localObject1 == null) {
                break label4738;
              }
              if (!v.aAC().equals(((TimeLineObject)localObject6).nIJ)) {
                break label4622;
              }
              this.Asa.a(this.AsU, (TimeLineObject)localObject6, localp.eco(), hashCode(), this.oOD, -1, false, bk.JgB, true);
              break;
              ((TextView)localObject1).setVisibility(8);
              continue;
              ((TextView)localObject1).setVisibility(8);
            }
            if (com.tencent.mm.plugin.sns.lucky.a.m.p(localp))
            {
              this.Asa.a(this.AsU, (TimeLineObject)localObject6, localp.eco(), hashCode(), this.oOD, -1, false, bk.JgB, false);
            }
            else if (((bzi)localObject1).dPd == 0)
            {
              this.Asa.a(this.AsU, (TimeLineObject)localObject6, localp.eco(), hashCode(), this.oOD, -1, false, bk.JgB, true);
            }
            else
            {
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo.hbStatus is " + ((bzi)localObject1).dPd);
              continue;
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo is null " + localp.eco());
            }
          }
          Object localObject10;
          Object localObject9;
          Object localObject11;
          if ((this.oOD == 9) || (this.oOD == 19))
          {
            this.Asu = true;
            localObject3 = new aq();
            localObject10 = this.ArL;
            localObject5 = ((View)localObject10).findViewById(2131298069);
            localObject8 = (VideoSightView)((View)localObject10).findViewById(2131300914);
            localObject9 = (SnsAdTimelineVideoView)((View)localObject10).findViewById(2131308163);
            ((aq)localObject3).AnG = ((View)localObject10);
            ((aq)localObject3).AnJ = ((View)localObject5);
            ((aq)localObject3).zWJ = ((ImageView)((View)localObject10).findViewById(2131305196));
            ((aq)localObject3).AnK = ((MMPinProgressBtn)((View)localObject10).findViewById(2131303515));
            ((aq)localObject3).zWK = ((TextView)((View)localObject10).findViewById(2131299517));
            ((aq)localObject3).AnL = ((TextView)((View)localObject10).findViewById(2131299492));
            ((aq)localObject3).AnH = ((VideoSightView)localObject8);
            ((aq)localObject3).AnH.setMute(true);
            ((aq)localObject3).a((TimeLineObject)localObject6, 0, localp.eco(), localp.vx());
            ((aq)localObject3).zWK.setVisibility(8);
            ((aq)localObject3).AnH.setTagObject(localObject3);
            ((aq)localObject3).AnH.setIsAdVideo(localp.vx());
            ((aq)localObject3).AnM = 5;
            ((aq)localObject3).AnI = ((SnsAdTimelineVideoView)localObject9);
            com.tencent.mm.plugin.sns.ad.timeline.a.e.a((SnsAdTimelineVideoView)localObject9);
            ((View)localObject5).setTag(localObject3);
            ((aq)localObject3).AnJ.setOnClickListener(this.zrv.AQl);
            if (!localp.dZA())
            {
              this.ofu.c((View)localObject5, this.zrv.AQc, this.zrv.APL);
              if ((!localp.vx()) || (!com.tencent.mm.plugin.sns.data.k.d((TimeLineObject)localObject6))) {
                break label5924;
              }
              localObject1 = com.tencent.mm.modelsns.h.a((TimeLineObject)localObject6, ((aq)localObject3).AnH.getUIContext(), false);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "isVerticalAdVideo=true, snsId=" + localp.field_snsId + ", showW=" + ((Pair)localObject1).first + ", showH=" + ((Pair)localObject1).second);
              i = 1;
              if (!localp.vx()) {
                break label12262;
              }
              localObject11 = localp.dVj();
              if ((localObject11 == null) || (!((com.tencent.mm.plugin.sns.storage.b)localObject11).dZA()) || (((com.tencent.mm.plugin.sns.storage.b)localObject11).zNt <= 0.0F) || (((com.tencent.mm.plugin.sns.storage.b)localObject11).zNu <= 0.0F)) {
                break label12262;
              }
              f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject11).zNt, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject11).zNv, ((com.tencent.mm.plugin.sns.storage.b)localObject11).zNw);
              f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject11).zNu, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject11).zNv, ((com.tencent.mm.plugin.sns.storage.b)localObject11).zNw);
              if (((com.tencent.mm.plugin.sns.storage.b)localObject11).zNs != 0) {
                break label5950;
              }
              if (f1 < k - com.tencent.mm.cb.a.ax(this, 2131166827) - com.tencent.mm.cb.a.ax(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516)) {
                break label12265;
              }
              f1 = k - com.tencent.mm.cb.a.ax(this, 2131166827) - com.tencent.mm.cb.a.ax(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
              f2 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject11).zNu * f1 / ((com.tencent.mm.plugin.sns.storage.b)localObject11).zNt);
            }
          }
          for (;;)
          {
            localObject1 = Pair.create(Integer.valueOf((int)f1), Integer.valueOf((int)f2));
            for (;;)
            {
              if (localObject1 != null)
              {
                if ((((aq)localObject3).AnH instanceof SightPlayImageView))
                {
                  if (!localp.vx())
                  {
                    ((aq)localObject3).AnH.setScaleMode(1);
                    ((aq)localObject3).AnH.setScaleType(QImageView.a.Lpz);
                  }
                }
                else
                {
                  ((VideoSightView)localObject8).hy(((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue());
                  if ((((aq)localObject3).AnH instanceof SightPlayImageView))
                  {
                    if (i == 0) {
                      break label6183;
                    }
                    ((aq)localObject3).AnH.dTL();
                  }
                  localObject11 = ((aq)localObject3).AnL.getLayoutParams();
                  ((ViewGroup.LayoutParams)localObject11).width = ((Integer)((Pair)localObject1).first).intValue();
                  ((ViewGroup.LayoutParams)localObject11).height = ((Integer)((Pair)localObject1).second).intValue();
                  ((aq)localObject3).AnL.setLayoutParams((ViewGroup.LayoutParams)localObject11);
                  localObject10 = (FrameLayout)((View)localObject10).findViewById(2131305105);
                  localObject11 = (FrameLayout.LayoutParams)((FrameLayout)localObject10).getLayoutParams();
                  ((FrameLayout.LayoutParams)localObject11).width = ((Integer)((Pair)localObject1).first).intValue();
                  ((FrameLayout.LayoutParams)localObject11).height = ((Integer)((Pair)localObject1).second).intValue();
                  ((FrameLayout)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject11);
                  com.tencent.mm.plugin.sns.ad.timeline.a.e.a((SnsAdTimelineVideoView)localObject9, ((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue());
                }
              }
              else
              {
                if ((((TimeLineObject)localObject6).HUG == null) || (((TimeLineObject)localObject6).HUG.Gtx.size() <= 0)) {
                  break label6195;
                }
                localObject1 = (bzh)((TimeLineObject)localObject6).HUG.Gtx.get(0);
                if (localp.vx())
                {
                  ((aq)localObject3).AnH.setOnCompletionListener(new b.e()
                  {
                    public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
                    {
                      AppMethodBeat.i(219864);
                      if (paramAnonymousInt != -1)
                      {
                        if (SnsCommentDetailUI.f(SnsCommentDetailUI.this) == null)
                        {
                          AppMethodBeat.o(219864);
                          return;
                        }
                        SnsCommentDetailUI.f(SnsCommentDetailUI.this).C(localp.field_snsId, false);
                      }
                      AppMethodBeat.o(219864);
                    }
                  });
                  ((aq)localObject3).AnH.setOnDecodeDurationListener(new b.f()
                  {
                    public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
                    {
                      AppMethodBeat.i(219865);
                      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsCommentDetailUI", "onDecodeProgress:".concat(String.valueOf(paramAnonymousLong)));
                      if ((SnsCommentDetailUI.f(SnsCommentDetailUI.this) != null) && (localp != null))
                      {
                        SnsCommentDetailUI.f(SnsCommentDetailUI.this).zO(localp.field_snsId);
                        SnsCommentDetailUI.f(SnsCommentDetailUI.this).aj(localp.field_snsId, 1000L * paramAnonymousLong);
                        if (!SnsCommentDetailUI.f(SnsCommentDetailUI.this).zL(localp.field_snsId))
                        {
                          int i = (int)paramAnonymousb.dTD();
                          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "updatePlayStartTime, duration=".concat(String.valueOf(i)));
                          SnsCommentDetailUI.f(SnsCommentDetailUI.this).d(localp.field_snsId, bu.HQ(), false);
                          SnsCommentDetailUI.f(SnsCommentDetailUI.this).e(localp.field_snsId, i, false);
                          SnsCommentDetailUI.f(SnsCommentDetailUI.this).ai(localp.field_snsId, localp.field_snsId);
                        }
                      }
                      AppMethodBeat.o(219865);
                    }
                  });
                  if (a(localp, (SnsAdTimelineVideoView)localObject9)) {
                    ((SnsAdTimelineVideoView)localObject9).setVideoCallback(new c(localp, (SnsAdTimelineVideoView)localObject9));
                  }
                }
                if ((((TimeLineObject)localObject6).HUG == null) || (((TimeLineObject)localObject6).HUG.Gtx.size() <= 0)) {
                  break;
                }
                ah.dXB();
                if (com.tencent.mm.plugin.sns.model.g.t((bzh)localObject1)) {
                  break label6304;
                }
                if (!ah.dXB().w((bzh)localObject1)) {
                  break label6201;
                }
                ((aq)localObject3).zWJ.setVisibility(8);
                ((aq)localObject3).AnK.setVisibility(0);
                ((aq)localObject3).AnK.fPL();
                ((VideoSightView)localObject8).setTagObject(localObject3);
                if (!a(localp, (SnsAdTimelineVideoView)localObject9)) {
                  break label6607;
                }
                ((SnsAdTimelineVideoView)localObject9).setTag(localObject3);
                ((VideoSightView)localObject8).setVisibility(8);
                com.tencent.mm.plugin.sns.ad.timeline.a.e.a((SnsAdTimelineVideoView)localObject9, true);
                com.tencent.mm.plugin.sns.ad.timeline.a.e.a((SnsAdTimelineVideoView)localObject9, ah.dXB(), localp, this, (bzh)localObject1, 0, bk.JgB);
                com.tencent.mm.plugin.sns.ad.timeline.a.e.b((SnsAdTimelineVideoView)localObject9);
                ((View)localObject5).setTag(localObject3);
                if (this.Asq == null) {
                  break;
                }
                if (!localp.vx()) {
                  break label6648;
                }
                if (ah.dXB().t(localp) != 5) {
                  break label6642;
                }
                bool1 = true;
              }
              for (;;)
              {
                this.Asq.E(localp.field_snsId, bool1);
                break;
                this.ofu.c((View)localObject5, this.zrv.AQe, this.zrv.APL);
                break label5058;
                localObject1 = com.tencent.mm.modelsns.h.a((TimeLineObject)localObject6, ((aq)localObject3).AnH.getUIContext(), localp.vx());
                i = 0;
                break label5148;
                if (((com.tencent.mm.plugin.sns.storage.b)localObject11).zNs == 1)
                {
                  j = k - com.tencent.mm.cb.a.ax(this, 2131166827) - com.tencent.mm.cb.a.ax(this, 2131166827) - com.tencent.mm.cb.a.ax(this, 2131165575) - com.tencent.mm.cb.a.ax(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
                  localObject1 = Pair.create(Integer.valueOf(j), Integer.valueOf((int)(j * ((com.tencent.mm.plugin.sns.storage.b)localObject11).zNu / ((com.tencent.mm.plugin.sns.storage.b)localObject11).zNt)));
                  break label5365;
                }
                if (((com.tencent.mm.plugin.sns.storage.b)localObject11).zNs != 2) {
                  break label12262;
                }
                j = k - com.tencent.mm.cb.a.ax(this, 2131166827) - com.tencent.mm.cb.a.ax(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
                localObject1 = Pair.create(Integer.valueOf(j), Integer.valueOf((int)(j * ((com.tencent.mm.plugin.sns.storage.b)localObject11).zNu / ((com.tencent.mm.plugin.sns.storage.b)localObject11).zNt)));
                break label5365;
                if (i != 0)
                {
                  ((aq)localObject3).AnH.setScaleMode(1);
                  ((aq)localObject3).AnH.setScaleType(QImageView.a.Lpz);
                  break label5409;
                }
                ((aq)localObject3).AnH.setScaleMode(0);
                ((aq)localObject3).AnH.setScaleType(QImageView.a.Lpu);
                break label5409;
                ((aq)localObject3).AnH.setDrawWidthAndHeightFix(false);
                break label5460;
                localObject1 = null;
                break label5640;
                if ((localp.vx()) && (ah.dXB().t(localp) == 5))
                {
                  ah.dXB().A((bzh)localObject1);
                  ((aq)localObject3).zWJ.setVisibility(8);
                  ((aq)localObject3).AnK.setVisibility(0);
                  ((aq)localObject3).AnK.fPL();
                  break label5784;
                }
                ah.dXB().y((bzh)localObject1);
                ((aq)localObject3).zWJ.setVisibility(0);
                ((aq)localObject3).AnK.setVisibility(8);
                ((aq)localObject3).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this, 2131691166));
                break label5784;
                if (ah.dXB().u((bzh)localObject1))
                {
                  ((aq)localObject3).zWJ.setVisibility(0);
                  ((aq)localObject3).AnK.setVisibility(8);
                  ((aq)localObject3).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this, 2131691166));
                  if (!a(localp, (SnsAdTimelineVideoView)localObject9)) {
                    break label6594;
                  }
                }
                for (bool1 = ((SnsAdTimelineVideoView)localObject9).isError();; bool1 = ((aq)localObject3).AnH.dTM())
                {
                  if (!bool1) {
                    break label6605;
                  }
                  com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsCommentDetailUI", "play video error " + ((bzh)localObject1).Id + " " + ((bzh)localObject1).Url + " " + ((bzh)localObject1).Hmj);
                  ah.dXB().y((bzh)localObject1);
                  ((aq)localObject3).zWJ.setVisibility(0);
                  ((aq)localObject3).AnK.setVisibility(8);
                  ((aq)localObject3).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this, 2131691166));
                  break;
                  if (ah.dXB().v((bzh)localObject1))
                  {
                    ((aq)localObject3).zWJ.setVisibility(8);
                    ((aq)localObject3).AnK.setVisibility(8);
                    break label6349;
                  }
                  if ((localp.vx()) && (ah.dXB().t(localp) <= 5))
                  {
                    ((aq)localObject3).zWJ.setVisibility(8);
                    ((aq)localObject3).AnK.setVisibility(8);
                    break label6349;
                  }
                  ah.dXB().y((bzh)localObject1);
                  ((aq)localObject3).zWJ.setVisibility(0);
                  ((aq)localObject3).AnK.setVisibility(8);
                  ((aq)localObject3).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this, 2131691166));
                  break label6349;
                }
                break label5784;
                ah.dXB().a(localp, (bzh)localObject1, (VideoSightView)localObject8, hashCode(), 0, bk.JgB, localp.vx());
                ((VideoSightView)localObject8).start();
                break label5844;
                bool1 = false;
                continue;
                label6648:
                if (ah.dXB().s(localp) == 5) {
                  bool1 = true;
                } else {
                  bool1 = false;
                }
              }
              if (this.oOD == 0)
              {
                localObject1 = (LinearLayout)this.ArL.findViewById(2131305006);
                localObject3 = RL(2131495567);
                if (!this.AsR)
                {
                  ((LinearLayout)localObject1).removeView(this.AsU);
                  ((LinearLayout)localObject1).addView((View)localObject3, 3);
                  if (((LinearLayout)localObject3).getLayoutParams() == null) {
                    break label7064;
                  }
                }
                for (localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject3).getLayoutParams());; localObject1 = new LinearLayout.LayoutParams(-1, -2))
                {
                  ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cb.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                  ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  if (((TimeLineObject)localObject6).HUG.Gtx.isEmpty()) {
                    break label7079;
                  }
                  localObject5 = (bzh)((TimeLineObject)localObject6).HUG.Gtx.get(0);
                  localObject1 = (MMImageView)((LinearLayout)localObject3).findViewById(2131300948);
                  ah.dXB().a((bzh)localObject5, (View)localObject1, 2131689564, hashCode(), bk.JgB);
                  this.Ase = ((ImageView)((LinearLayout)localObject3).findViewById(2131305185));
                  this.Ase.setOnTouchListener(this.Aib);
                  this.dAQ = ((TimeLineObject)localObject6).Id;
                  efu();
                  bool1 = getIntent().getBooleanExtra("SNS_FROM_MUSIC_ITEM", false);
                  ((MMImageView)localObject1).setTag(new s((TimeLineObject)localObject6, this.Asb, bool1));
                  ((MMImageView)localObject1).setOnClickListener(this.Asj.AHw);
                  localObject8 = ((bzh)localObject5).Desc;
                  if (!bu.isNullOrNil((String)localObject8)) {
                    ((TextView)((LinearLayout)localObject3).findViewById(2131304202)).setText((CharSequence)localObject8);
                  }
                  localObject5 = ((bzh)localObject5).Title;
                  if (!bu.isNullOrNil((String)localObject5)) {
                    ((TextView)((LinearLayout)localObject3).findViewById(2131305950)).setText(new SpannableString((CharSequence)localObject5), TextView.BufferType.SPANNABLE);
                  }
                  ((LinearLayout)localObject3).setTag(new s((TimeLineObject)localObject6, this.Asb));
                  this.ofu.c((View)localObject3, this.zrv.AQb, this.zrv.APL);
                  ((LinearLayout)localObject3).setOnClickListener(this.Asj.AyK);
                  com.tencent.mm.plugin.sns.data.r.b((View)localObject1, this);
                  break;
                }
                ((LinearLayout)localObject3).setVisibility(8);
                break;
              }
              if (this.oOD == 13)
              {
                this.ArM.setVisibility(8);
                this.ArR.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                break;
              }
              if ((this.oOD == 11) || (this.oOD == 14) || (this.oOD == 15)) {
                break;
              }
              if (this.oOD == 16)
              {
                localObject1 = (LinearLayout)this.ArL.findViewById(2131305006);
                localObject5 = RL(2131495565);
                if (!this.AsR)
                {
                  ((LinearLayout)localObject1).removeView(this.AsU);
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
                  localObject8 = (MMImageView)((LinearLayout)localObject5).findViewById(2131300948);
                  ((MMImageView)localObject8).setVisibility(0);
                  localObject9 = (TextView)((LinearLayout)localObject5).findViewById(2131305950);
                  if (((TimeLineObject)localObject6).HUG.GtB == null) {
                    break label7733;
                  }
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderShareObject not null");
                  if ((!bu.isNullOrNil(((TimeLineObject)localObject6).HUG.GtB.nickname)) || (bu.isNullOrNil(((TimeLineObject)localObject6).HUG.GtB.desc))) {
                    break label7637;
                  }
                  localObject1 = ((TimeLineObject)localObject6).HUG.GtB.desc;
                }
                for (;;)
                {
                  ((TextView)localObject9).setText(new SpannableString((CharSequence)localObject1), TextView.BufferType.SPANNABLE);
                  ((TextView)localObject9).setMaxLines(2);
                  if (!((TimeLineObject)localObject6).HUG.GtB.mediaList.isEmpty())
                  {
                    localObject1 = new bzh();
                    ((bzh)localObject1).Url = ((arx)((TimeLineObject)localObject6).HUG.GtB.mediaList.get(0)).thumbUrl;
                    ((bzh)localObject1).Hmj = ((arx)((TimeLineObject)localObject6).HUG.GtB.mediaList.get(0)).thumbUrl;
                    ((bzh)localObject1).nJA = 2;
                    ((bzh)localObject1).Hmk = 1;
                    ((bzh)localObject1).Hmm = new bzj();
                    ((bzh)localObject1).GXH = 1;
                    ((bzh)localObject1).Hmm.Hna = ((arx)((TimeLineObject)localObject6).HUG.GtB.mediaList.get(0)).width;
                    ((bzh)localObject1).Hmm.Hnb = ((arx)((TimeLineObject)localObject6).HUG.GtB.mediaList.get(0)).height;
                    ((bzh)localObject1).Id = localp.getSnsId();
                    ah.dXB().b((bzh)localObject1, (View)localObject8, hashCode(), bk.fvn().abC(((TimeLineObject)localObject6).CreateTime));
                  }
                  ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject6, this.Asb));
                  ((LinearLayout)localObject5).setOnClickListener(this.Asj.AyK);
                  break;
                  localObject1 = new LinearLayout.LayoutParams(-1, -2);
                  break label7233;
                  if (!bu.isNullOrNil(((TimeLineObject)localObject6).HUG.GtB.desc)) {
                    localObject1 = ((TimeLineObject)localObject6).HUG.GtB.nickname + ": " + ((TimeLineObject)localObject6).HUG.GtB.desc;
                  } else {
                    localObject1 = getString(2131763973, new Object[] { ((TimeLineObject)localObject6).HUG.GtB.nickname });
                  }
                }
                if (((TimeLineObject)localObject6).HUG.GtC == null) {
                  break;
                }
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderShareTopic not null");
                localObject3 = getString(2131755778);
                if (((TimeLineObject)localObject6).HUG.GtC != null) {
                  if (((TimeLineObject)localObject6).HUG.GtC.sXu != 1) {
                    break label8057;
                  }
                }
                label8057:
                for (localObject1 = "#" + ((TimeLineObject)localObject6).HUG.GtC.dBe;; localObject1 = ((TimeLineObject)localObject6).HUG.GtC.dBe)
                {
                  localObject3 = localObject1;
                  if (!bu.isNullOrNil(((TimeLineObject)localObject6).HUG.GtC.desc))
                  {
                    localObject3 = (TextView)((LinearLayout)localObject5).findViewById(2131304202);
                    ((TextView)localObject3).setVisibility(0);
                    ((TextView)localObject3).setText(((TimeLineObject)localObject6).HUG.GtC.desc);
                    localObject3 = localObject1;
                  }
                  ((TextView)localObject9).setText(new SpannableString((CharSequence)localObject3), TextView.BufferType.SPANNABLE);
                  ((TextView)localObject9).setMaxLines(2);
                  localObject1 = new bzh();
                  ((bzh)localObject1).Url = ((TimeLineObject)localObject6).HUG.GtC.iconUrl;
                  ((bzh)localObject1).Hmj = ((TimeLineObject)localObject6).HUG.GtC.iconUrl;
                  ((bzh)localObject1).nJA = 2;
                  ((bzh)localObject1).Hmk = 1;
                  ((bzh)localObject1).Hmm = new bzj();
                  ((bzh)localObject1).GXH = 1;
                  ((bzh)localObject1).Hmm.Hna = 0.0F;
                  ((bzh)localObject1).Hmm.Hnb = 0.0F;
                  ((bzh)localObject1).Id = localp.getSnsId();
                  ah.dXB().b((bzh)localObject1, (View)localObject8, hashCode(), bk.fvn().abC(((TimeLineObject)localObject6).CreateTime));
                  ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject6, this.Asb));
                  ((LinearLayout)localObject5).setOnClickListener(this.Asj.AyK);
                  break;
                }
              }
              if (this.oOD == 17)
              {
                localObject1 = (LinearLayout)this.ArL.findViewById(2131305006);
                localObject3 = RL(2131495565);
                if (!this.AsR)
                {
                  ((LinearLayout)localObject1).removeView(this.AsU);
                  ((LinearLayout)localObject1).addView((View)localObject3, 3);
                  if (((LinearLayout)localObject3).getLayoutParams() == null) {
                    break label8519;
                  }
                }
                for (localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject3).getLayoutParams());; localObject1 = new LinearLayout.LayoutParams(-1, -2))
                {
                  ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cb.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                  ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  if (((TimeLineObject)localObject6).HUG.GtD == null) {
                    break label8534;
                  }
                  localObject1 = (MMImageView)((LinearLayout)localObject3).findViewById(2131300948);
                  ((MMImageView)localObject1).setVisibility(0);
                  localObject5 = new bzh();
                  ((bzh)localObject5).Url = ((TimeLineObject)localObject6).HUG.GtD.hGe;
                  ((bzh)localObject5).Hmj = ((TimeLineObject)localObject6).HUG.GtD.hGe;
                  ((bzh)localObject5).nJA = 2;
                  ((bzh)localObject5).Hmk = 1;
                  ((bzh)localObject5).Hmm = new bzj();
                  ((bzh)localObject5).GXH = 1;
                  ((bzh)localObject5).Hmm.Hna = ((TimeLineObject)localObject6).HUG.GtD.width;
                  ((bzh)localObject5).Hmm.Hnb = ((TimeLineObject)localObject6).HUG.GtD.height;
                  ((bzh)localObject5).Id = localp.getSnsId();
                  ah.dXB().b((bzh)localObject5, (View)localObject1, hashCode(), bk.fvn().abC(((TimeLineObject)localObject6).CreateTime));
                  localObject5 = (ImageView)((LinearLayout)localObject3).findViewById(2131305185);
                  ((ImageView)localObject5).setVisibility(0);
                  ((ImageView)localObject5).setImageDrawable(ao.k(((ImageView)localObject5).getContext(), 2131690672, -1));
                  localObject5 = ((TimeLineObject)localObject6).HUG.GtD.title;
                  if (!bu.isNullOrNil((String)localObject5))
                  {
                    localObject8 = (TextView)((LinearLayout)localObject3).findViewById(2131305950);
                    ((TextView)localObject8).setMaxLines(2);
                    ((TextView)localObject8).setText(new SpannableString((CharSequence)localObject5), TextView.BufferType.SPANNABLE);
                  }
                  ((LinearLayout)localObject3).setTag(new ag((TimeLineObject)localObject6, (View)localObject1, localp.eco()));
                  ((LinearLayout)localObject3).setOnClickListener(this.Asj.AHl);
                  this.ofu.c((View)localObject3, this.zrv.AQh, this.zrv.APL);
                  com.tencent.mm.plugin.sns.data.r.b((View)localObject1, this);
                  break;
                }
                ((LinearLayout)localObject3).setVisibility(8);
                break;
              }
              if (this.oOD == 18)
              {
                localObject1 = this.ArL.findViewById(2131308426);
                localObject3 = (ImageView)this.ArL.findViewById(2131308429);
                localObject5 = (ImageIndicatorView)this.ArL.findViewById(2131308427);
                localObject8 = (ImageView)this.ArL.findViewById(2131308430);
                if ((localObject6 == null) || (((TimeLineObject)localObject6).HUG == null) || (((TimeLineObject)localObject6).HUG.GtB == null)) {
                  break;
                }
                localObject9 = ((TimeLineObject)localObject6).HUG.GtB;
                if (!bu.ht(((ary)localObject9).mediaList))
                {
                  localObject10 = (arx)((ary)localObject9).mediaList.get(0);
                  if (localObject10 != null)
                  {
                    if (((ary)localObject9).GIy != 4) {
                      break label8841;
                    }
                    localObject11 = com.tencent.mm.modelsns.h.a((int)((arx)localObject10).width, (int)((arx)localObject10).height, this, false);
                    i = ((Integer)((Pair)localObject11).first).intValue();
                    j = ((Integer)((Pair)localObject11).second).intValue();
                    ((View)localObject1).getLayoutParams().width = i;
                    ((View)localObject1).getLayoutParams().height = j;
                    ((View)localObject1).requestLayout();
                    ((t)com.tencent.mm.kernel.g.ad(t.class)).loadImage(((arx)localObject10).thumbUrl, (ImageView)localObject8);
                  }
                }
                if (((ary)localObject9).GIy == 4)
                {
                  ((ImageView)localObject3).setVisibility(0);
                  ((ImageIndicatorView)localObject5).setVisibility(8);
                }
                for (;;)
                {
                  ((View)localObject1).setTag(localObject6);
                  ((View)localObject1).setOnClickListener(this.Asj.AHn);
                  this.ofu.c((View)localObject1, this.zrv.AQi, this.zrv.APL);
                  break;
                  localObject11 = com.tencent.mm.modelsns.h.a((int)((arx)localObject10).width, (int)((arx)localObject10).height, this);
                  i = ((Integer)((Pair)localObject11).first).intValue();
                  j = ((Integer)((Pair)localObject11).second).intValue();
                  ((View)localObject1).getLayoutParams().width = i;
                  ((View)localObject1).getLayoutParams().height = j;
                  ((View)localObject1).requestLayout();
                  break label8753;
                  ((ImageView)localObject3).setVisibility(8);
                  ((ImageIndicatorView)localObject5).setVisibility(8);
                  ((ImageIndicatorView)localObject5).Sr(((ary)localObject9).drZ);
                }
              }
              localObject1 = (LinearLayout)this.ArL.findViewById(2131305006);
              localObject8 = RL(2131495565);
              localObject9 = (MMImageView)((LinearLayout)localObject8).findViewById(2131300948);
              if (!this.AsR)
              {
                ((LinearLayout)localObject1).removeView(this.AsU);
                ((LinearLayout)localObject1).addView((View)localObject8, 3);
                if (((LinearLayout)localObject8).getLayoutParams() != null)
                {
                  localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject8).getLayoutParams());
                  ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cb.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                  ((LinearLayout)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject1);
                }
              }
              else
              {
                i = 0;
                if (!localp.vx()) {
                  break label9498;
                }
                if (localp.dVj().dZz())
                {
                  i = 1;
                  ((LinearLayout)localObject8).setTag(localp);
                  ((LinearLayout)localObject8).setTag(2131301433, localObject9);
                  ((LinearLayout)localObject8).setOnClickListener(this.zrv.AQD);
                }
                j = 0;
              }
              for (;;)
              {
                if (i != 0)
                {
                  this.ofu.c((View)localObject8, this.zrv.AQf, this.zrv.APL);
                  if (!efq()) {
                    break label10271;
                  }
                  localObject1 = bh.aCj(((TimeLineObject)localObject6).HUG.Url);
                  localObject3 = ((TimeLineObject)localObject6).HUG.Title;
                  if (i != 0) {
                    localObject1 = ((TimeLineObject)localObject6).HUG.Desc;
                  }
                  if ((((TimeLineObject)localObject6).HUG.GtA == null) || (((TimeLineObject)localObject6).HUG.GtA.hBY != 1)) {
                    break label12250;
                  }
                  localObject1 = ak.getContext().getString(2131761345);
                }
                for (;;)
                {
                  ((LinearLayout)localObject8).findViewById(2131305185).setVisibility(8);
                  if (!((TimeLineObject)localObject6).HUG.Gtx.isEmpty())
                  {
                    ((MMImageView)localObject9).setVisibility(0);
                    localObject5 = (bzh)((TimeLineObject)localObject6).HUG.Gtx.get(0);
                    if (((TimeLineObject)localObject6).HUG.Gtw == 15)
                    {
                      ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setImageResource(2131233395);
                      ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setVisibility(0);
                      ah.dXB().a((bzh)localObject5, (View)localObject9, 2131689581, hashCode(), bk.fvn().abC(((TimeLineObject)localObject6).CreateTime));
                      localObject5 = localObject3;
                      localObject3 = localObject1;
                      localObject1 = localObject5;
                      com.tencent.mm.plugin.sns.data.r.b((View)localObject9, this);
                      if (((TimeLineObject)localObject6).HUG.Gtw != 15) {
                        break label12247;
                      }
                      localObject1 = getString(2131763826);
                      localObject3 = "";
                    }
                  }
                  for (;;)
                  {
                    localObject5 = (TextView)((LinearLayout)localObject8).findViewById(2131305950);
                    if (!bu.isNullOrNil((String)localObject3))
                    {
                      ((LinearLayout)localObject8).findViewById(2131304202).setVisibility(0);
                      ((TextView)((LinearLayout)localObject8).findViewById(2131304202)).setText((CharSequence)localObject3);
                      ((TextView)localObject5).setMaxLines(1);
                    }
                    for (;;)
                    {
                      if (!bu.isNullOrNil((String)localObject1))
                      {
                        ((TextView)localObject5).setVisibility(0);
                        if (j != 0)
                        {
                          ((TextView)localObject5).setText(com.tencent.mm.plugin.sns.data.r.a((String)localObject1, getContext(), (TextView)localObject5));
                          break;
                          localObject1 = new LinearLayout.LayoutParams(-1, -2);
                          break label9023;
                          if (((TimeLineObject)localObject6).HUG.Gtw == 9)
                          {
                            if (((TimeLineObject)localObject6).HUG.Gtx.size() <= 0) {
                              break label12253;
                            }
                            ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.Asb));
                            ((LinearLayout)localObject8).setOnClickListener(this.Asj.AHq);
                            i = 0;
                            j = 0;
                            break label9113;
                          }
                          if (((TimeLineObject)localObject6).HUG.Gtw == 10)
                          {
                            if (((TimeLineObject)localObject6).HUG.Gtx.size() <= 0) {
                              break label12253;
                            }
                            ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.Asb));
                            ((LinearLayout)localObject8).setOnClickListener(this.Asj.AHs);
                            i = 0;
                            j = 0;
                            break label9113;
                          }
                          if (((TimeLineObject)localObject6).HUG.Gtw == 17)
                          {
                            if (((TimeLineObject)localObject6).HUG.Gtx.size() <= 0) {
                              break label12253;
                            }
                            ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.Asb));
                            ((LinearLayout)localObject8).setOnClickListener(this.Asj.AHt);
                            i = 0;
                            j = 0;
                            break label9113;
                          }
                          if (((TimeLineObject)localObject6).HUG.Gtw == 22)
                          {
                            if (((TimeLineObject)localObject6).HUG.Gtx.size() <= 0) {
                              break label12253;
                            }
                            ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.Asb));
                            ((LinearLayout)localObject8).setOnClickListener(this.Asj.AHu);
                            i = 0;
                            j = 0;
                            break label9113;
                          }
                          if (((TimeLineObject)localObject6).HUG.Gtw == 23)
                          {
                            if (((TimeLineObject)localObject6).HUG.Gtx.size() <= 0) {
                              break label12253;
                            }
                            ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.Asb));
                            ((LinearLayout)localObject8).setOnClickListener(this.Asj.AHv);
                            i = 0;
                            j = 0;
                            break label9113;
                          }
                          if (((TimeLineObject)localObject6).HUG.Gtw == 14)
                          {
                            if (((TimeLineObject)localObject6).HUG.Gtx.size() <= 0) {
                              break label12253;
                            }
                            ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.Asb));
                            ((LinearLayout)localObject8).setOnClickListener(this.Asj.AHr);
                            i = 0;
                            j = 0;
                            break label9113;
                          }
                          if (((TimeLineObject)localObject6).HUG.Gtw == 12)
                          {
                            if (((TimeLineObject)localObject6).HUG.Gtx.size() <= 0) {
                              break label12253;
                            }
                            ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.Asb));
                            ((LinearLayout)localObject8).setOnClickListener(this.Asj.AHA);
                            i = 0;
                            j = 0;
                            break label9113;
                          }
                          if (((TimeLineObject)localObject6).HUG.Gtw == 30)
                          {
                            ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.Asb));
                            ((LinearLayout)localObject8).setOnClickListener(this.Asj.AHy);
                            i = 0;
                            j = 0;
                            break label9113;
                          }
                          if (((TimeLineObject)localObject6).HUG.Gtw == 13)
                          {
                            if (((TimeLineObject)localObject6).HUG.Gtx.size() <= 0) {
                              break label12253;
                            }
                            ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.Asb));
                            ((LinearLayout)localObject8).setOnClickListener(this.Asj.AHB);
                            i = 0;
                            j = 0;
                            break label9113;
                          }
                          if (((TimeLineObject)localObject6).HUG.Gtw == 15)
                          {
                            if (((TimeLineObject)localObject6).HUG.Gtx.size() <= 0) {
                              break label12253;
                            }
                            ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.Asb));
                            ((LinearLayout)localObject8).setOnClickListener(this.zrv.AQm);
                            i = 0;
                            j = 0;
                            break label9113;
                          }
                          if (((TimeLineObject)localObject6).HUG.Gtw == 26)
                          {
                            ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.Asb));
                            ((LinearLayout)localObject8).setOnClickListener(this.Asj.AHC);
                            i = 0;
                            j = 0;
                            break label9113;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.Asb));
                          ((LinearLayout)localObject8).setOnClickListener(this.Asj.AyK);
                          if ((((TimeLineObject)localObject6).hCH & 0x1) <= 0) {
                            break label12253;
                          }
                          i = 0;
                          j = 1;
                          break label9113;
                          this.ofu.c((View)localObject8, this.zrv.AQb, this.zrv.APL);
                          break label9141;
                          localObject1 = "";
                          break label9160;
                          if (((TimeLineObject)localObject6).HUG.Gtw == 5)
                          {
                            localObject3 = bh.aCj(((bzh)localObject5).Url);
                            localObject1 = ((bzh)localObject5).Title;
                            ((LinearLayout)localObject8).findViewById(2131305185).setVisibility(0);
                            ah.dXB().a((bzh)localObject5, (View)localObject9, 2131689581, hashCode(), bk.JgB);
                            break label9357;
                          }
                          if (((TimeLineObject)localObject6).HUG.Gtw == 18)
                          {
                            ((LinearLayout)localObject8).findViewById(2131305185).setVisibility(0);
                            ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setImageResource(2131234474);
                            ((MMImageView)localObject9).setVisibility(0);
                            ah.dXB().a((bzh)localObject5, (View)localObject9, 2131689581, hashCode(), bk.JgB);
                            localObject5 = localObject1;
                            localObject1 = localObject3;
                            localObject3 = localObject5;
                            break label9357;
                          }
                          ah.dXB().b((bzh)localObject5, (View)localObject9, hashCode(), bk.JgB);
                          localObject5 = localObject1;
                          localObject1 = localObject3;
                          localObject3 = localObject5;
                          break label9357;
                          if (((TimeLineObject)localObject6).HUG.Gtw == 18)
                          {
                            ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setVisibility(0);
                            ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setImageResource(2131234474);
                            ((MMImageView)localObject9).setVisibility(0);
                            ah.dXB().d((View)localObject9, -1, 2131689581, hashCode());
                            localObject5 = localObject1;
                            localObject1 = localObject3;
                            localObject3 = localObject5;
                            break label9357;
                          }
                          if (((TimeLineObject)localObject6).HUG.Gtw == 26)
                          {
                            ((MMImageView)localObject9).setVisibility(0);
                            ah.dXB().d((View)localObject9, -1, 2131690949, hashCode());
                            localObject5 = localObject1;
                            localObject1 = localObject3;
                            localObject3 = localObject5;
                            break label9357;
                          }
                          ((MMImageView)localObject9).setVisibility(0);
                          ah.dXB().d((View)localObject9, -1, 2131689584, hashCode());
                          localObject5 = localObject1;
                          localObject1 = localObject3;
                          localObject3 = localObject5;
                          break label9357;
                          ((LinearLayout)localObject8).findViewById(2131304202).setVisibility(8);
                          ((TextView)localObject5).setMaxLines(2);
                          continue;
                        }
                        ((TextView)localObject5).setText((CharSequence)localObject1);
                        break;
                      }
                    }
                    ((TextView)localObject5).setVisibility(8);
                    break;
                    ((TextView)localObject5).setVisibility(0);
                    if (bu.isNullOrNil((String)localObject1)) {
                      break label2711;
                    }
                    ((TextView)localObject5).setTextColor(getContext().getResources().getColor(2131099769));
                    ((TextView)localObject5).setClickable(true);
                    ((TextView)localObject5).setText((CharSequence)localObject1);
                    break label2742;
                    ((TextView)localObject5).setVisibility(8);
                    break label2742;
                    if (((TimeLineObject)localObject6).HUE == null)
                    {
                      localObject1 = null;
                      if (((TimeLineObject)localObject6).HUE != null) {
                        break label10798;
                      }
                    }
                    for (localObject3 = null;; localObject3 = ((TimeLineObject)localObject6).HUE.jGd)
                    {
                      ((TextView)localObject5).setTag(localp.eco());
                      if ((!bu.isNullOrNil((String)localObject1)) || (!bu.isNullOrNil((String)localObject3))) {
                        break label10811;
                      }
                      ((TextView)localObject5).setVisibility(8);
                      break;
                      localObject1 = ((TimeLineObject)localObject6).HUE.jfX;
                      break label10738;
                    }
                    ((TextView)localObject5).setVisibility(0);
                    if (!bu.isNullOrNil((String)localObject3))
                    {
                      ((TextView)localObject5).setTextColor(getContext().getResources().getColor(2131099769));
                      ((TextView)localObject5).setClickable(true);
                      if ((localp.field_snsId == 0L) && (!bu.isNullOrNil((String)localObject1)))
                      {
                        ((TextView)localObject5).setText((String)localObject1 + "·" + (String)localObject3);
                        break label2758;
                      }
                      ((TextView)localObject5).setText((CharSequence)localObject3);
                      break label2758;
                    }
                    ((TextView)localObject5).setText((CharSequence)localObject1);
                    ((TextView)localObject5).setClickable(false);
                    ((TextView)localObject5).setTextColor(getContext().getResources().getColor(2131100212));
                    break label2758;
                    ((TextView)localObject5).setVisibility(8);
                    break label2953;
                    if (((com.tencent.mm.plugin.sns.storage.a)localObject7).zMa != com.tencent.mm.plugin.sns.storage.a.zLN) {
                      break label2953;
                    }
                    if (!bu.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject7).zMb))
                    {
                      localObject1 = "";
                      localObject9 = ((com.tencent.mm.plugin.sns.storage.a)localObject7).zMd.iterator();
                      if (((Iterator)localObject9).hasNext())
                      {
                        localObject10 = (String)((Iterator)localObject9).next();
                        localObject3 = this.Asc.aUL((String)localObject10);
                        if (localObject3 != null)
                        {
                          localObject3 = ((com.tencent.mm.contact.c)localObject3).adG();
                          if (!bu.isNullOrNil((String)localObject3)) {
                            localObject3 = (String)localObject1 + (String)localObject3;
                          }
                        }
                        for (;;)
                        {
                          localObject1 = localObject3;
                          if (((com.tencent.mm.plugin.sns.storage.a)localObject7).zMd.getLast() == localObject10) {
                            break;
                          }
                          localObject1 = (String)localObject3 + ",";
                          break;
                          localObject3 = (String)localObject1 + (String)localObject10;
                          continue;
                          localObject3 = (String)localObject1 + (String)localObject10;
                        }
                      }
                      localObject3 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject7).zMb, new Object[] { localObject1 });
                      ((TextView)localObject5).getTextSize();
                      localObject9 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject3, 1));
                      ((com.tencent.mm.pluginsdk.ui.span.l)localObject9).b(null, (CharSequence)localObject3);
                      localObject3 = ((TextView)localObject5).getPaint();
                      if (com.tencent.mm.cb.a.aA(this, (int)Layout.getDesiredWidth((CharSequence)localObject9, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject9).length(), (TextPaint)localObject3)) > this.Aso)
                      {
                        if (((String)localObject1).length() <= 1) {
                          break label2953;
                        }
                        localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
                        localObject9 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject7).zMb, new Object[] { (String)localObject1 + "..." });
                        ((TextView)localObject5).getTextSize();
                        localObject10 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject9, 1));
                        ((com.tencent.mm.pluginsdk.ui.span.l)localObject10).b(null, (CharSequence)localObject9);
                        i = com.tencent.mm.cb.a.aA(this, (int)Layout.getDesiredWidth((CharSequence)localObject10, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject10).length(), (TextPaint)localObject3));
                        ((TextView)localObject5).setText((CharSequence)localObject10, TextView.BufferType.SPANNABLE);
                        ((TextView)localObject5).setVisibility(0);
                        if (i > this.Aso) {
                          break label2952;
                        }
                        break label2953;
                      }
                      ((TextView)localObject5).setText((CharSequence)localObject9, TextView.BufferType.SPANNABLE);
                      ((TextView)localObject5).setVisibility(0);
                      break label2953;
                    }
                    ((TextView)localObject5).setVisibility(8);
                    break label2953;
                    ((TextView)localObject8).setVisibility(8);
                    break label3079;
                    i = 8;
                    break label3110;
                    if (((TimeLineObject)localObject6).HUG.Gtw == 30)
                    {
                      localObject1 = ((TimeLineObject)localObject6).HUM.username;
                      localObject1 = ((com.tencent.mm.plugin.appbrand.service.o)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.o.class)).Ob((String)localObject1);
                      if ((localObject1 != null) && (!bu.isNullOrNil(((WxaAttributes)localObject1).field_nickname))) {}
                      for (localObject3 = ((WxaAttributes)localObject1).field_nickname;; localObject3 = getString(2131755945))
                      {
                        localObject1 = localObject3;
                        if (((TimeLineObject)localObject6).HUM.subType != 1) {
                          break;
                        }
                        this.AsS.findViewById(2131305185).setVisibility(0);
                        localObject1 = localObject3;
                        break;
                      }
                    }
                    if (((TimeLineObject)localObject6).HUG.Gtw == 28)
                    {
                      localObject3 = getContext().getResources().getString(2131759151);
                      localObject1 = localObject3;
                      if (((TimeLineObject)localObject6).HUG.GtB == null) {
                        break label3200;
                      }
                      localObject1 = localObject3;
                      if (bu.isNullOrNil(((TimeLineObject)localObject6).HUG.GtB.nickname)) {
                        break label3200;
                      }
                      localObject1 = (String)localObject3 + " · " + ((TimeLineObject)localObject6).HUG.GtB.nickname;
                      break label3200;
                    }
                    if (((TimeLineObject)localObject6).HUG.Gtw == 29)
                    {
                      localObject1 = getContext().getResources().getString(2131759151);
                      break label3200;
                    }
                    localObject1 = localObject3;
                    if (!localp.vx()) {
                      break label3200;
                    }
                    localObject1 = localObject3;
                    if (!com.tencent.mm.plugin.sns.ad.c.d.a(localp.dVj(), localp.dVi())) {
                      break label3200;
                    }
                    localObject1 = getContext().getResources().getString(2131759151);
                    break label3200;
                    ((TextView)localObject4).setVisibility(8);
                    break label3341;
                    ((TextView)localObject1).setVisibility(8);
                    break label3516;
                    if (((SnsObject)localObject5).WithUserList.size() <= 0) {
                      ((TextView)localObject4).setVisibility(8);
                    }
                    for (;;)
                    {
                      if ((localObject5 == null) || (this.fHO == null) || (!this.fHO.equals(((SnsObject)localObject5).Username)) || (((((SnsObject)localObject5).ExtFlag != 3) || (((SnsObject)localObject5).BlackList == null)) && ((((SnsObject)localObject5).ExtFlag != 5) || (((SnsObject)localObject5).GroupUser == null)))) {
                        break label12229;
                      }
                      this.ArL.findViewById(2131296570).setVisibility(0);
                      this.ArL.findViewById(2131296570).setTag(Integer.valueOf(localp.AdJ));
                      this.ArL.findViewById(2131296570).setOnClickListener(new SnsCommentDetailUI.33(this));
                      break;
                      if (this.fHO.equals(((SnsObject)localObject5).Username))
                      {
                        ((TextView)localObject4).setVisibility(0);
                        i = 0;
                        localObject6 = ((SnsObject)localObject5).WithUserList.iterator();
                        localObject1 = "";
                        if (((Iterator)localObject6).hasNext())
                        {
                          localObject7 = (dgh)((Iterator)localObject6).next();
                          if (i == 0)
                          {
                            i = 1;
                            localObject1 = (String)localObject1 + "  ";
                            if (((dgh)localObject7).Nickname == null) {
                              break label12047;
                            }
                            localObject3 = new StringBuilder().append((String)localObject1);
                            localObject1 = ((dgh)localObject7).Nickname;
                          }
                          for (;;)
                          {
                            localObject1 = (String)localObject1;
                            break;
                            localObject1 = (String)localObject1 + ",  ";
                            break label11977;
                            localObject8 = this.Asc.BH(((dgh)localObject7).Username);
                            localObject3 = new StringBuilder().append((String)localObject1);
                            if (localObject8 == null) {
                              localObject1 = ((dgh)localObject7).Username;
                            } else {
                              localObject1 = ((com.tencent.mm.contact.c)localObject8).adG();
                            }
                          }
                        }
                        ((TextView)localObject4).setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, getString(2131764039, new Object[] { localObject1 }), ((TextView)localObject4).getTextSize()));
                      }
                      else
                      {
                        ((TextView)localObject4).setVisibility(8);
                        localObject1 = ((SnsObject)localObject5).WithUserList.iterator();
                        if (((Iterator)localObject1).hasNext())
                        {
                          localObject3 = (dgh)((Iterator)localObject1).next();
                          if (!this.fHO.equals(((dgh)localObject3).Username)) {
                            break label11764;
                          }
                          ((TextView)localObject4).setVisibility(0);
                          localObject1 = getString(2131764040);
                          ((TextView)localObject4).setVisibility(0);
                          ((TextView)localObject4).setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject1, ((TextView)localObject4).getTextSize()));
                        }
                      }
                    }
                    this.ArL.findViewById(2131296570).setVisibility(8);
                    break label3550;
                  }
                }
                i = 0;
                j = 0;
              }
            }
          }
        }
        i = 0;
        localObject4 = localObject1;
        break;
      }
      label6642:
      label10738:
      label11764:
      label12281:
      bool1 = true;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495537;
  }
  
  public final int getSource()
  {
    if (this.Asy == 16) {
      return 2;
    }
    return 1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98599);
    setMMTitle(2131763794);
    setToTop(new SnsCommentDetailUI.20(this));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(219857);
        if (SnsCommentDetailUI.c(SnsCommentDetailUI.this) != null) {
          SnsCommentDetailUI.c(SnsCommentDetailUI.this).rX(false);
        }
        SnsCommentDetailUI.this.finish();
        AppMethodBeat.o(219857);
        return true;
      }
    });
    this.fHO = v.aAC();
    if (ah.dXn()) {
      finish();
    }
    final com.tencent.mm.plugin.sns.storage.p localp = rW(true);
    if (localp == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.dAg);
      finish();
      AppMethodBeat.o(98599);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "snsId: " + this.dAg + "localId " + this.Asb + "  username:" + localp.field_userName);
    Object localObject1 = (TextView)findViewById(2131298750);
    label297:
    int i;
    if (this.Asv)
    {
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(this.Asw);
      if ((x.aBO(this.dAg)) || (!localp.ecq())) {
        break label700;
      }
      localObject1 = localp.ech();
      findViewById(2131305039).setVisibility(0);
      localObject2 = (TextView)findViewById(2131303362);
      switch (((bzi)localObject1).HmP)
      {
      default: 
        if (!bu.isNullOrNil(((bzi)localObject1).HmW))
        {
          ((TextView)localObject2).setText(((bzi)localObject1).HmW);
          findViewById(2131305040).setVisibility(0);
          i = 1;
          label310:
          if (i != 0) {
            findViewById(2131305039).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(219848);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                if (localp.Rt(32))
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(219848);
                  return;
                }
                al.QF(localp.AdJ);
                al.QD(localp.AdJ);
                ah.dXA().dWc();
                paramAnonymousView = new Intent();
                SnsCommentDetailUI.this.setResult(-1, paramAnonymousView);
                if (SnsCommentDetailUI.w(SnsCommentDetailUI.this)) {
                  paramAnonymousView.putExtra("sns_gallery_force_finish", true);
                }
                SnsCommentDetailUI.this.finish();
                SnsCommentDetailUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(219848);
              }
            });
          }
          this.ArP = ((ListView)findViewById(2131296556));
          this.ArP.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(219849);
              SnsCommentDetailUI.a(SnsCommentDetailUI.this, SnsCommentDetailUI.a(SnsCommentDetailUI.this).getBottom());
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsCommentDetailUI", "listOriginalBottom: " + SnsCommentDetailUI.d(SnsCommentDetailUI.this));
              AppMethodBeat.o(219849);
            }
          });
          this.ArP.setOnScrollListener(new AbsListView.OnScrollListener()
          {
            public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AppMethodBeat.i(219850);
              if (paramAnonymousInt2 > 0) {
                if ((paramAnonymousInt1 == 0) && (!SnsCommentDetailUI.x(SnsCommentDetailUI.this)))
                {
                  SnsCommentDetailUI.a(SnsCommentDetailUI.this, true);
                  if (SnsCommentDetailUI.y(SnsCommentDetailUI.this) != null)
                  {
                    SnsCommentDetailUI.y(SnsCommentDetailUI.this).refreshView();
                    AppMethodBeat.o(219850);
                    return;
                  }
                  if (SnsCommentDetailUI.z(SnsCommentDetailUI.this) != null)
                  {
                    SnsCommentDetailUI.this.efr();
                    AppMethodBeat.o(219850);
                  }
                }
                else if (paramAnonymousInt1 > 0)
                {
                  SnsCommentDetailUI.a(SnsCommentDetailUI.this, false);
                }
              }
              AppMethodBeat.o(219850);
            }
            
            public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
            {
              AppMethodBeat.i(219851);
              if (paramAnonymousInt == 1)
              {
                SnsCommentDetailUI.this.hideVKB();
                SnsCommentDetailUI.A(SnsCommentDetailUI.this);
              }
              if ((paramAnonymousInt == 0) && (SnsCommentDetailUI.f(SnsCommentDetailUI.this) != null)) {
                SnsCommentDetailUI.f(SnsCommentDetailUI.this).rq(true);
              }
              AppMethodBeat.o(219851);
            }
          });
          localObject1 = rW(false);
          this.ArL = z.jV(getContext()).inflate(2131495538, null);
          this.ArR = this.ArL.findViewById(2131300970);
          this.ArL.setOnClickListener(this.AsO);
          if ((localObject1 == null) || (!((com.tencent.mm.plugin.sns.storage.p)localObject1).Rt(32)) || (!((com.tencent.mm.plugin.sns.storage.p)localObject1).dZD())) {
            break label717;
          }
          this.AsG = ((FrameLayout)z.jV(getContext()).inflate(2131496422, null));
          this.AsG.addView(this.ArL, 0);
          this.ArP.addHeaderView(this.AsG);
        }
        break;
      }
    }
    for (;;)
    {
      boolean bool = efr();
      if (bool) {
        break label731;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "error isOk setheader ".concat(String.valueOf(bool)));
      finish();
      AppMethodBeat.o(98599);
      return;
      ((TextView)localObject1).setVisibility(8);
      break;
      if (!bu.isNullOrNil(((bzi)localObject1).HmW)) {
        ((TextView)localObject2).setText(((bzi)localObject1).HmW);
      }
      for (;;)
      {
        findViewById(2131305040).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(2131763943);
      }
      if (!bu.isNullOrNil(((bzi)localObject1).HmW)) {
        ((TextView)localObject2).setText(((bzi)localObject1).HmW);
      }
      for (;;)
      {
        findViewById(2131305040).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(2131763945);
      }
      if (!bu.isNullOrNil(((bzi)localObject1).HmW)) {
        ((TextView)localObject2).setText(((bzi)localObject1).HmW);
      }
      for (;;)
      {
        findViewById(2131305040).setVisibility(8);
        i = 1;
        break;
        ((TextView)localObject2).setText(2131763944);
      }
      ((TextView)localObject2).setText(2131763946);
      break label297;
      label700:
      findViewById(2131305039).setVisibility(8);
      i = 0;
      break label310;
      label717:
      this.ArP.addHeaderView(this.ArL);
    }
    label731:
    if (localObject1 != null) {
      this.oOD = bh.c((com.tencent.mm.plugin.sns.storage.p)localObject1, false);
    }
    if ((this.oOD == 10) && (v.aAC().equals(localp.field_userName)))
    {
      this.ArO = new SnsDetailLuckyHeader(this);
      localObject1 = new AbsListView.LayoutParams(-1, -2);
      this.ArO.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.ArO.setOnClickListener(this.AsO);
    }
    this.ArN = new LinearLayout(getContext());
    localObject1 = new AbsListView.LayoutParams(-1, -2);
    this.ArN.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.ArN.setOnClickListener(this.AsO);
    BackwardSupportUtil.b.h(this, 2.0F);
    localObject1 = new AbsListView.LayoutParams(-1, 1);
    Object localObject2 = new LinearLayout(getContext());
    ((LinearLayout)localObject2).setBackgroundResource(2131234115);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.zvX = ((LinearLayout)localObject2);
    b(localp, true);
    if (this.ArO != null)
    {
      this.Ass = true;
      this.ArP.addHeaderView(this.ArO);
    }
    localObject2 = al.u(localp);
    label1080:
    label1243:
    dgh localdgh;
    long l;
    if (localObject2 == null)
    {
      this.ArN.setVisibility(8);
      this.ArS = new b(new LinkedList(), new LinkedList(), this, localp.eco());
      this.ArP.addHeaderView(this.ArN);
      this.ArP.setAdapter(this.ArS);
      this.Agn = ((SnsCommentFooter)findViewById(2131298521));
      if ((localp == null) || (localp.ebP() == null) || (localp.ebP().HUG == null) || ((localp.ebP().HUG.Gty & 0x80) != 0)) {
        break label1769;
      }
      this.Agn.setFeedEmojiCommentEnable(true);
      this.Agn.setTag(localp);
      this.Agn.setOnEditTouchListener(new SnsCommentFooter.a()
      {
        public final void efv()
        {
          AppMethodBeat.i(219852);
          if (!com.tencent.mm.plugin.sns.lucky.a.m.azK(localp.eco()))
          {
            if ((SnsCommentDetailUI.B(SnsCommentDetailUI.this) != null) && (SnsCommentDetailUI.B(SnsCommentDetailUI.this).isShowing()))
            {
              AppMethodBeat.o(219852);
              return;
            }
            SnsCommentDetailUI.a(SnsCommentDetailUI.this, com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.AsU.RH(0)));
            AppMethodBeat.o(219852);
            return;
          }
          if ((SnsCommentDetailUI.this.keyboardState() == 1) || (SnsCommentDetailUI.c(SnsCommentDetailUI.this).efx()))
          {
            AppMethodBeat.o(219852);
            return;
          }
          SnsCommentDetailUI.C(SnsCommentDetailUI.this);
          AppMethodBeat.o(219852);
        }
      });
      this.Agn.setOnSmileyShowListener(new SnsCommentFooter.c()
      {
        public final void onShow()
        {
          AppMethodBeat.i(219853);
          if (SnsCommentDetailUI.c(SnsCommentDetailUI.this).AtO)
          {
            AppMethodBeat.o(219853);
            return;
          }
          SnsCommentDetailUI.C(SnsCommentDetailUI.this);
          AppMethodBeat.o(219853);
        }
      });
      localObject1 = rW(true);
      if ((localObject1 != null) && (!((com.tencent.mm.plugin.sns.storage.p)localObject1).ecn())) {
        this.Agn.setVisibility(8);
      }
      this.Agn.setAfterEditAction(this.AsN);
      this.Agn.efy();
      this.Agn.setOnCommentSendImp(new SnsCommentFooter.b()
      {
        public final void kb(String paramAnonymousString1, String paramAnonymousString2)
        {
          int j = 8;
          AppMethodBeat.i(219854);
          if (!com.tencent.mm.plugin.sns.lucky.a.m.azK(localp.eco()))
          {
            if (SnsCommentDetailUI.this.AsU.RH(0) != null) {
              com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.AsU.RH(0));
            }
            AppMethodBeat.o(219854);
            return;
          }
          if (localp.Rt(32)) {}
          for (int i = SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentFlag();; i = 0)
          {
            if (com.tencent.mm.plugin.sns.ui.widget.e.id(i, 8))
            {
              paramAnonymousString1 = paramAnonymousString1.substring(SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentAtPrefix().length());
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "send atFriend ad detail comment");
              ao.a.a(localp, 16, paramAnonymousString1, SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentInfo(), i, SnsCommentDetailUI.this.getSource(), paramAnonymousString2);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setText("");
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).rX(false);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "comment send imp!");
              com.tencent.mm.plugin.sns.j.e.zKO.dZk().elc = 3L;
              SnsCommentDetailUI.A(SnsCommentDetailUI.this);
              AppMethodBeat.o(219854);
              return;
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "send detail comment");
            com.tencent.mm.plugin.sns.storage.p localp = localp;
            if (localp.Rt(32)) {}
            for (;;)
            {
              ao.a.a(localp, j, paramAnonymousString1, SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentInfo(), i, SnsCommentDetailUI.this.getSource(), paramAnonymousString2);
              break;
              j = 2;
            }
          }
        }
      });
      this.Ash = getIntent().getBooleanExtra("INTENT_FROMSUI", false);
      if (this.Ash)
      {
        this.Asi = getIntent().getLongExtra("INTENT_FROMSUI_COMMENTID", 0L);
        if ((this.Asi != 0L) && (this.ArS.commentList != null))
        {
          i = 0;
          if (i < this.ArS.commentList.size())
          {
            localdgh = (dgh)this.ArS.commentList.get(i);
            if (localdgh.HNk == 0) {
              break label1780;
            }
            l = localdgh.HNk;
            label1289:
            if (l != this.Asi) {
              break label1818;
            }
            this.ArP.setSelection(i);
            localObject1 = this.Asc.BH(localdgh.Username);
            if (localObject1 == null) {
              break label1790;
            }
            localObject1 = ((com.tencent.mm.contact.c)localObject1).adG();
            label1335:
            this.Agn.AtF = 0;
            this.Agn.efz();
            this.Agn.setCommentHint(getString(2131763952) + (String)localObject1);
            this.Agn.setCommentInfo(localdgh);
            if (((SnsObject)localObject2).LikeUserList.size() <= 0) {
              break label1857;
            }
            int j = i + 1;
            i = j;
            if (j > this.ArS.getCount()) {
              i = this.ArS.getCount() - 1;
            }
          }
        }
      }
    }
    label1818:
    label1857:
    for (;;)
    {
      this.AsN.UL = i;
      if (this.Ash) {
        new com.tencent.mm.sdk.platformtools.aq().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219855);
            SnsCommentDetailUI.this.hideVKB();
            SnsCommentDetailUI.m(SnsCommentDetailUI.this).kl = SnsCommentDetailUI.D(SnsCommentDetailUI.this);
            SnsCommentDetailUI.m(SnsCommentDetailUI.this).run();
            AppMethodBeat.o(219855);
          }
        }, 100L);
      }
      this.Asr = ((SnsTranslateResultView)this.ArL.findViewById(2131305091));
      this.Asr.setResultTextSize(((TextView)this.ArL.findViewById(2131299008)).getTextSize());
      this.Asr.getResultTextView().setBackgroundResource(2131234100);
      localObject1 = new bd(this.dAg, localp.eco(), false, true, 2);
      this.Asr.getResultTextView().setTag(localObject1);
      this.ofu.c(this.Asr.getResultTextView(), this.zrv.APO, this.zrv.APL);
      if (as.fe(this.dAg, 4))
      {
        localObject1 = as.aAt(this.dAg);
        if ((localObject1 != null) && (((as.b)localObject1).hLB))
        {
          this.Asr.setVisibility(0);
          this.Asr.a(null, 1, ((as.b)localObject1).result, ((as.b)localObject1).hTy, false);
          AppMethodBeat.o(98599);
          return;
          this.ArX = ((SnsObject)localObject2).LikeUserList;
          j(((SnsObject)localObject2).LikeUserList, ((SnsObject)localObject2).CommentUserList.isEmpty());
          if (this.ArO != null) {
            this.ArO.a(localp, this.zrv);
          }
          this.ArS = new b(((SnsObject)localObject2).CommentUserList, ((SnsObject)localObject2).LikeUserList, this, localp.eco());
          if (!this.Asz) {
            break;
          }
          com.tencent.mm.plugin.sns.j.e.zKO.dZk().ela = ((SnsObject)localObject2).CommentUserList.size();
          com.tencent.mm.plugin.sns.j.e.zKO.dZk().elb = ((SnsObject)localObject2).LikeUserList.size();
          break;
          label1769:
          this.Agn.setFeedEmojiCommentEnable(false);
          break label1080;
          label1780:
          l = localdgh.HNm;
          break label1289;
          label1790:
          if (localdgh.Nickname != null)
          {
            localObject1 = localdgh.Nickname;
            break label1335;
          }
          localObject1 = localdgh.Username;
          break label1335;
          i += 1;
          break label1243;
        }
        this.Asr.setVisibility(8);
        AppMethodBeat.o(98599);
        return;
      }
      this.Asr.setVisibility(8);
      AppMethodBeat.o(98599);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98610);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt1 == 15)
    {
      if ((this.zrv != null) && (this.zrv.APL != null)) {
        this.zrv.APL.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      AppMethodBeat.o(98610);
      return;
    }
    if (paramInt1 == 16)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "REQUEST_CODE_FOR_FULLSCREEN");
      paramIntent = new ib();
      paramIntent.dvE.scene = 1;
      com.tencent.mm.sdk.b.a.IvT.l(paramIntent);
      AppMethodBeat.o(98610);
      return;
    }
    if (paramInt1 == 2333)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        if (!bu.isNullOrNil(paramIntent))
        {
          paramIntent = paramIntent.split(",");
          if (paramIntent.length > 0)
          {
            this.Agn.fNT.showVKB();
            String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zP(paramIntent[0]);
            if (!bu.isNullOrNil(str))
            {
              this.Agn.efz();
              this.Agn.setText("@" + str + " ");
              this.Agn.setCommentAtPrefix("@" + str + " ");
              this.Agn.setCommentInfo(new dgh());
              this.Agn.getCommentInfo().Username = paramIntent[0];
              this.Agn.setCommentFlag(8);
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
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahE(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98609);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = com.tencent.mm.plugin.sns.storage.h.aBq(this.dAg);
    Object localObject = al.u(paramConfiguration);
    j(((SnsObject)localObject).LikeUserList, ((SnsObject)localObject).CommentUserList.isEmpty());
    if (this.ArO != null) {
      this.ArO.a(paramConfiguration, this.zrv);
    }
    paramConfiguration = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    localObject = new Point();
    ((Point)localObject).x = paramConfiguration.widthPixels;
    ((Point)localObject).y = paramConfiguration.heightPixels;
    ah.j((Point)localObject);
    if (this.AsU != null)
    {
      this.Asl = ah.dXP();
      this.AsU.setImageViewWidth(this.Asl);
    }
    AppMethodBeat.o(98609);
  }
  
  /* Error */
  public void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 3164
    //   3: invokestatic 245	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 3169	com/tencent/mm/pluginsdk/h:q	(Lcom/tencent/mm/ui/MMActivity;)V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 3171	com/tencent/mm/ui/MMActivity:onCreate	(Landroid/os/Bundle;)V
    //   15: aload_0
    //   16: invokestatic 3174	com/tencent/mm/plugin/sns/ad/timeline/a/e:dVw	()Z
    //   19: putfield 990	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AsF	Z
    //   22: aload_0
    //   23: ldc_w 3176
    //   26: invokestatic 2607	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   29: checkcast 3176	com/tencent/mm/plugin/story/api/e
    //   32: invokeinterface 3180 1 0
    //   37: getstatic 3186	com/tencent/mm/plugin/story/api/f$a:AZw	Lcom/tencent/mm/plugin/story/api/f$a;
    //   40: invokeinterface 3191 2 0
    //   45: putfield 333	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AsB	Z
    //   48: aload_0
    //   49: ldc_w 3176
    //   52: invokestatic 2607	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   55: checkcast 3176	com/tencent/mm/plugin/story/api/e
    //   58: invokeinterface 3180 1 0
    //   63: getstatic 3194	com/tencent/mm/plugin/story/api/f$a:AZx	Lcom/tencent/mm/plugin/story/api/f$a;
    //   66: invokeinterface 3191 2 0
    //   71: putfield 335	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AsC	Z
    //   74: aload_0
    //   75: iconst_1
    //   76: invokestatic 3199	com/tencent/mm/ui/b:c	(Landroid/app/Activity;Z)V
    //   79: invokestatic 3203	com/tencent/mm/plugin/sns/model/ah:dXu	()Lcom/tencent/mm/plugin/sns/model/ao$a;
    //   82: iconst_5
    //   83: ldc_w 3205
    //   86: aload_0
    //   87: invokevirtual 3208	com/tencent/mm/plugin/sns/model/ao$a:a	(ILjava/lang/String;Lcom/tencent/mm/plugin/sns/b/i$a;)V
    //   90: aload_0
    //   91: aload_0
    //   92: invokevirtual 3211	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getApplicationContext	()Landroid/content/Context;
    //   95: ldc_w 3213
    //   98: invokevirtual 3214	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   101: checkcast 3216	android/text/ClipboardManager
    //   104: putfield 1305	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rJr	Landroid/text/ClipboardManager;
    //   107: aload_0
    //   108: aload_0
    //   109: bipush 14
    //   111: invokestatic 3219	com/tencent/mm/ui/aq:fromDPToPix	(Landroid/content/Context;I)I
    //   114: putfield 331	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AsA	I
    //   117: aload_0
    //   118: invokestatic 3225	com/tencent/mm/ui/al:ck	(Landroid/content/Context;)Landroid/graphics/Point;
    //   121: astore_1
    //   122: aload_0
    //   123: aload_1
    //   124: getfield 3151	android/graphics/Point:x	I
    //   127: putfield 3227	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenWidth	I
    //   130: aload_0
    //   131: aload_1
    //   132: getfield 3156	android/graphics/Point:y	I
    //   135: putfield 3229	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenHeight	I
    //   138: aload_0
    //   139: invokestatic 3235	java/lang/System:currentTimeMillis	()J
    //   142: putfield 279	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:ArJ	J
    //   145: aload_0
    //   146: new 1694	com/tencent/mm/ui/widget/b/a
    //   149: dup
    //   150: aload_0
    //   151: invokespecial 3236	com/tencent/mm/ui/widget/b/a:<init>	(Landroid/content/Context;)V
    //   154: putfield 647	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:ofu	Lcom/tencent/mm/ui/widget/b/a;
    //   157: aload_0
    //   158: aload_0
    //   159: invokevirtual 2432	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   162: ldc_w 3238
    //   165: iconst_0
    //   166: invokevirtual 3242	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   169: putfield 2849	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asy	I
    //   172: aload_0
    //   173: aload_0
    //   174: invokevirtual 2432	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   177: ldc_w 3244
    //   180: iconst_0
    //   181: invokevirtual 2440	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   184: putfield 329	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asz	Z
    //   187: aload_0
    //   188: getfield 329	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asz	Z
    //   191: ifeq +10 -> 201
    //   194: getstatic 587	com/tencent/mm/plugin/sns/j/e:zKO	Lcom/tencent/mm/plugin/sns/j/e;
    //   197: invokevirtual 3247	com/tencent/mm/plugin/sns/j/e:dZm	()Lcom/tencent/mm/g/b/a/ey;
    //   200: pop
    //   201: aload_0
    //   202: aload_0
    //   203: invokevirtual 2432	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   206: ldc_w 3249
    //   209: invokevirtual 3057	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   212: ldc_w 303
    //   215: invokestatic 1580	com/tencent/mm/sdk/platformtools/bu:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   218: putfield 509	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dAg	Ljava/lang/String;
    //   221: aload_0
    //   222: getfield 509	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dAg	Ljava/lang/String;
    //   225: invokestatic 955	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   228: ifeq +24 -> 252
    //   231: aload_0
    //   232: ldc_w 3251
    //   235: aload_0
    //   236: invokevirtual 2432	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   239: ldc_w 3249
    //   242: lconst_0
    //   243: invokevirtual 2972	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   246: invokestatic 3255	com/tencent/mm/plugin/sns/storage/x:bn	(Ljava/lang/String;J)Ljava/lang/String;
    //   249: putfield 509	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dAg	Ljava/lang/String;
    //   252: aload_0
    //   253: aload_0
    //   254: invokevirtual 2432	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   257: ldc_w 3257
    //   260: invokevirtual 3057	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   263: ldc_w 303
    //   266: invokestatic 1580	com/tencent/mm/sdk/platformtools/bu:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   269: putfield 912	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asb	Ljava/lang/String;
    //   272: aload_0
    //   273: getfield 912	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asb	Ljava/lang/String;
    //   276: invokestatic 955	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   279: ifeq +32 -> 311
    //   282: aload_0
    //   283: invokevirtual 2432	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   286: ldc_w 3257
    //   289: iconst_m1
    //   290: invokevirtual 3242	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   293: istore_2
    //   294: iload_2
    //   295: iconst_m1
    //   296: if_icmpeq +15 -> 311
    //   299: aload_0
    //   300: ldc_w 3251
    //   303: iload_2
    //   304: i2l
    //   305: invokestatic 3255	com/tencent/mm/plugin/sns/storage/x:bn	(Ljava/lang/String;J)Ljava/lang/String;
    //   308: putfield 912	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asb	Ljava/lang/String;
    //   311: aload_0
    //   312: new 66	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$4
    //   315: dup
    //   316: aload_0
    //   317: aload_0
    //   318: invokevirtual 573	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   321: aload_0
    //   322: aload_0
    //   323: getfield 346	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AsH	Lcom/tencent/mm/plugin/sns/model/ai;
    //   326: invokespecial 3260	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$4:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;ILandroid/app/Activity;Lcom/tencent/mm/plugin/sns/model/ag;)V
    //   329: putfield 542	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zrv	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   332: aload_0
    //   333: ldc_w 1711
    //   336: invokevirtual 1056	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:findViewById	(I)Landroid/view/View;
    //   339: checkcast 2293	android/widget/FrameLayout
    //   342: astore_1
    //   343: aload_0
    //   344: new 3262	com/tencent/mm/plugin/sns/h/b
    //   347: dup
    //   348: aload_0
    //   349: aload_0
    //   350: getfield 542	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zrv	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   353: aload_1
    //   354: invokespecial 3265	com/tencent/mm/plugin/sns/h/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/c;Landroid/widget/FrameLayout;)V
    //   357: putfield 3267	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Agw	Lcom/tencent/mm/plugin/sns/h/b;
    //   360: aload_0
    //   361: new 3269	com/tencent/mm/plugin/sns/ui/b
    //   364: dup
    //   365: aload_0
    //   366: aload_0
    //   367: getfield 542	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zrv	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   370: aload_1
    //   371: aload_0
    //   372: getfield 3267	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Agw	Lcom/tencent/mm/plugin/sns/h/b;
    //   375: invokespecial 3272	com/tencent/mm/plugin/sns/ui/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/c;Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/sns/h/b;)V
    //   378: putfield 1313	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Agv	Lcom/tencent/mm/plugin/sns/ui/b;
    //   381: aload_0
    //   382: new 3274	com/tencent/mm/plugin/sns/ui/am
    //   385: dup
    //   386: aload_0
    //   387: aload_0
    //   388: getfield 542	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zrv	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   391: aload_1
    //   392: invokespecial 3275	com/tencent/mm/plugin/sns/ui/am:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/c;Landroid/widget/FrameLayout;)V
    //   395: putfield 1317	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Agx	Lcom/tencent/mm/plugin/sns/ui/am;
    //   398: aload_0
    //   399: new 3277	com/tencent/mm/plugin/sns/ui/br
    //   402: dup
    //   403: aload_0
    //   404: aload_0
    //   405: getfield 542	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zrv	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   408: aload_1
    //   409: invokespecial 3278	com/tencent/mm/plugin/sns/ui/br:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/c;Landroid/widget/FrameLayout;)V
    //   412: putfield 1434	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Agy	Lcom/tencent/mm/plugin/sns/ui/br;
    //   415: aload_0
    //   416: getfield 542	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zrv	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   419: invokevirtual 3281	com/tencent/mm/plugin/sns/ui/d/c:dhH	()V
    //   422: aload_0
    //   423: aload_0
    //   424: invokevirtual 2432	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   427: ldc_w 3283
    //   430: iconst_0
    //   431: invokevirtual 2440	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   434: putfield 323	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asv	Z
    //   437: aload_0
    //   438: aload_0
    //   439: invokevirtual 2432	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   442: ldc_w 3285
    //   445: invokevirtual 3057	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   448: putfield 325	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asw	Ljava/lang/String;
    //   451: aload_0
    //   452: new 1123	com/tencent/mm/plugin/sns/ui/bo
    //   455: dup
    //   456: aload_0
    //   457: new 74	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$5
    //   460: dup
    //   461: aload_0
    //   462: invokespecial 3286	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$5:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   465: aload_0
    //   466: invokevirtual 573	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   469: aload_0
    //   470: getfield 346	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AsH	Lcom/tencent/mm/plugin/sns/model/ai;
    //   473: invokespecial 3289	com/tencent/mm/plugin/sns/ui/bo:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/bo$a;ILcom/tencent/mm/plugin/sns/model/ag;)V
    //   476: putfield 1154	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asj	Lcom/tencent/mm/plugin/sns/ui/bo;
    //   479: invokestatic 3235	java/lang/System:currentTimeMillis	()J
    //   482: lstore_3
    //   483: aload_0
    //   484: invokevirtual 2432	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   487: ldc_w 3291
    //   490: invokevirtual 3295	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   493: astore_1
    //   494: aload_1
    //   495: ifnull +184 -> 679
    //   498: new 455	com/tencent/mm/protocal/protobuf/TimeLineObject
    //   501: dup
    //   502: invokespecial 3296	com/tencent/mm/protocal/protobuf/TimeLineObject:<init>	()V
    //   505: astore 6
    //   507: aload 6
    //   509: aload_1
    //   510: invokevirtual 3300	com/tencent/mm/protocal/protobuf/TimeLineObject:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   513: pop
    //   514: invokestatic 3304	com/tencent/mm/plugin/sns/model/ah:dXE	()Lcom/tencent/mm/plugin/sns/storage/q;
    //   517: new 3306	java/math/BigInteger
    //   520: dup
    //   521: aload 6
    //   523: getfield 2428	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   526: invokespecial 3307	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   529: invokevirtual 3310	java/math/BigInteger:longValue	()J
    //   532: invokevirtual 3316	com/tencent/mm/plugin/sns/storage/q:AG	(J)Lcom/tencent/mm/plugin/sns/storage/p;
    //   535: ifnonnull +759 -> 1294
    //   538: ldc_w 730
    //   541: ldc_w 3318
    //   544: invokestatic 802	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   547: new 445	com/tencent/mm/plugin/sns/storage/p
    //   550: dup
    //   551: invokespecial 3319	com/tencent/mm/plugin/sns/storage/p:<init>	()V
    //   554: astore_1
    //   555: aload_1
    //   556: new 3306	java/math/BigInteger
    //   559: dup
    //   560: aload 6
    //   562: getfield 2428	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   565: invokespecial 3307	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   568: invokevirtual 3310	java/math/BigInteger:longValue	()J
    //   571: putfield 1651	com/tencent/mm/plugin/sns/storage/p:field_snsId	J
    //   574: aload_1
    //   575: aload 6
    //   577: invokevirtual 3323	com/tencent/mm/protocal/protobuf/TimeLineObject:toByteArray	()[B
    //   580: putfield 3327	com/tencent/mm/plugin/sns/storage/p:field_content	[B
    //   583: aload_1
    //   584: aload 6
    //   586: getfield 2523	com/tencent/mm/protocal/protobuf/TimeLineObject:CreateTime	I
    //   589: putfield 3330	com/tencent/mm/plugin/sns/storage/p:field_createTime	I
    //   592: aload_1
    //   593: aload 6
    //   595: getfield 2135	com/tencent/mm/protocal/protobuf/TimeLineObject:nIJ	Ljava/lang/String;
    //   598: putfield 923	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
    //   601: aload_1
    //   602: aload 6
    //   604: getfield 459	com/tencent/mm/protocal/protobuf/TimeLineObject:HUG	Lcom/tencent/mm/protocal/protobuf/abo;
    //   607: getfield 812	com/tencent/mm/protocal/protobuf/abo:Gtw	I
    //   610: putfield 3333	com/tencent/mm/plugin/sns/storage/p:field_type	I
    //   613: aload_1
    //   614: invokevirtual 3336	com/tencent/mm/plugin/sns/storage/p:ecl	()V
    //   617: new 523	com/tencent/mm/protocal/protobuf/SnsObject
    //   620: dup
    //   621: invokespecial 3337	com/tencent/mm/protocal/protobuf/SnsObject:<init>	()V
    //   624: astore 6
    //   626: aload 6
    //   628: new 3339	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   631: dup
    //   632: invokespecial 3340	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   635: putfield 3344	com/tencent/mm/protocal/protobuf/SnsObject:ObjectDesc	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   638: aload_1
    //   639: aload 6
    //   641: invokevirtual 3345	com/tencent/mm/protocal/protobuf/SnsObject:toByteArray	()[B
    //   644: putfield 3348	com/tencent/mm/plugin/sns/storage/p:field_attrBuf	[B
    //   647: invokestatic 3304	com/tencent/mm/plugin/sns/model/ah:dXE	()Lcom/tencent/mm/plugin/sns/storage/q;
    //   650: aload_1
    //   651: invokevirtual 3352	com/tencent/mm/plugin/sns/storage/q:insert	(Lcom/tencent/mm/sdk/e/c;)Z
    //   654: pop
    //   655: ldc_w 3354
    //   658: ldc_w 3356
    //   661: iconst_1
    //   662: anewarray 1185	java/lang/Object
    //   665: dup
    //   666: iconst_0
    //   667: invokestatic 3235	java/lang/System:currentTimeMillis	()J
    //   670: lload_3
    //   671: lsub
    //   672: invokestatic 1656	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   675: aastore
    //   676: invokestatic 1566	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   679: aload_0
    //   680: iconst_1
    //   681: invokespecial 443	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rW	(Z)Lcom/tencent/mm/plugin/sns/storage/p;
    //   684: astore_1
    //   685: ldc_w 730
    //   688: new 732	java/lang/StringBuilder
    //   691: dup
    //   692: ldc_w 3358
    //   695: invokespecial 736	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   698: aload_0
    //   699: getfield 509	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dAg	Ljava/lang/String;
    //   702: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: ldc_w 3360
    //   708: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: aload_0
    //   712: getfield 912	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asb	Ljava/lang/String;
    //   715: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: invokevirtual 744	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokestatic 802	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   724: aload_1
    //   725: ifnull +29 -> 754
    //   728: ldc_w 730
    //   731: ldc_w 3362
    //   734: iconst_1
    //   735: anewarray 1185	java/lang/Object
    //   738: dup
    //   739: iconst_0
    //   740: aload_1
    //   741: getfield 923	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
    //   744: ldc_w 303
    //   747: invokestatic 1580	com/tencent/mm/sdk/platformtools/bu:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   750: aastore
    //   751: invokestatic 1566	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   754: aload_0
    //   755: getfield 509	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dAg	Ljava/lang/String;
    //   758: invokestatic 560	com/tencent/mm/plugin/sns/storage/x:aBO	(Ljava/lang/String;)Z
    //   761: ifeq +56 -> 817
    //   764: aload_0
    //   765: getfield 509	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dAg	Ljava/lang/String;
    //   768: invokestatic 3365	com/tencent/mm/plugin/sns/storage/x:ayP	(Ljava/lang/String;)Z
    //   771: ifeq +567 -> 1338
    //   774: aload_1
    //   775: ifnull +531 -> 1306
    //   778: aload_1
    //   779: getfield 923	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
    //   782: invokestatic 3370	com/tencent/mm/model/x:Am	(Ljava/lang/String;)Z
    //   785: ifne +32 -> 817
    //   788: invokestatic 1534	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   791: pop
    //   792: invokestatic 3374	com/tencent/mm/kernel/g:ajQ	()Lcom/tencent/mm/kernel/b;
    //   795: getfield 3380	com/tencent/mm/kernel/b:gDv	Lcom/tencent/mm/ak/q;
    //   798: new 3382	com/tencent/mm/plugin/sns/model/q
    //   801: dup
    //   802: aload_0
    //   803: getfield 509	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dAg	Ljava/lang/String;
    //   806: invokestatic 3386	com/tencent/mm/plugin/sns/storage/x:aze	(Ljava/lang/String;)J
    //   809: invokespecial 3388	com/tencent/mm/plugin/sns/model/q:<init>	(J)V
    //   812: iconst_0
    //   813: invokevirtual 3393	com/tencent/mm/ak/q:a	(Lcom/tencent/mm/ak/n;I)Z
    //   816: pop
    //   817: invokestatic 1534	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   820: pop
    //   821: invokestatic 3374	com/tencent/mm/kernel/g:ajQ	()Lcom/tencent/mm/kernel/b;
    //   824: getfield 3380	com/tencent/mm/kernel/b:gDv	Lcom/tencent/mm/ak/q;
    //   827: sipush 210
    //   830: aload_0
    //   831: invokevirtual 3396	com/tencent/mm/ak/q:a	(ILcom/tencent/mm/ak/f;)V
    //   834: invokestatic 1534	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   837: pop
    //   838: invokestatic 3374	com/tencent/mm/kernel/g:ajQ	()Lcom/tencent/mm/kernel/b;
    //   841: getfield 3380	com/tencent/mm/kernel/b:gDv	Lcom/tencent/mm/ak/q;
    //   844: sipush 218
    //   847: aload_0
    //   848: invokevirtual 3396	com/tencent/mm/ak/q:a	(ILcom/tencent/mm/ak/f;)V
    //   851: invokestatic 1534	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   854: pop
    //   855: invokestatic 3374	com/tencent/mm/kernel/g:ajQ	()Lcom/tencent/mm/kernel/b;
    //   858: getfield 3380	com/tencent/mm/kernel/b:gDv	Lcom/tencent/mm/ak/q;
    //   861: sipush 213
    //   864: aload_0
    //   865: invokevirtual 3396	com/tencent/mm/ak/q:a	(ILcom/tencent/mm/ak/f;)V
    //   868: invokestatic 1534	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   871: pop
    //   872: invokestatic 3374	com/tencent/mm/kernel/g:ajQ	()Lcom/tencent/mm/kernel/b;
    //   875: getfield 3380	com/tencent/mm/kernel/b:gDv	Lcom/tencent/mm/ak/q;
    //   878: sipush 682
    //   881: aload_0
    //   882: invokevirtual 3396	com/tencent/mm/ak/q:a	(ILcom/tencent/mm/ak/f;)V
    //   885: invokestatic 1534	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   888: pop
    //   889: invokestatic 3374	com/tencent/mm/kernel/g:ajQ	()Lcom/tencent/mm/kernel/b;
    //   892: getfield 3380	com/tencent/mm/kernel/b:gDv	Lcom/tencent/mm/ak/q;
    //   895: sipush 214
    //   898: aload_0
    //   899: invokevirtual 3396	com/tencent/mm/ak/q:a	(ILcom/tencent/mm/ak/f;)V
    //   902: invokestatic 1534	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   905: pop
    //   906: invokestatic 3374	com/tencent/mm/kernel/g:ajQ	()Lcom/tencent/mm/kernel/b;
    //   909: getfield 3380	com/tencent/mm/kernel/b:gDv	Lcom/tencent/mm/ak/q;
    //   912: sipush 683
    //   915: aload_0
    //   916: invokevirtual 3396	com/tencent/mm/ak/q:a	(ILcom/tencent/mm/ak/f;)V
    //   919: aload_0
    //   920: invokestatic 3399	com/tencent/mm/plugin/sns/model/ah:dXs	()Lcom/tencent/mm/storage/bq;
    //   923: putfield 2743	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asc	Lcom/tencent/mm/storage/bq;
    //   926: aload_0
    //   927: new 3401	com/tencent/mm/plugin/sns/ui/ay
    //   930: dup
    //   931: aload_0
    //   932: invokespecial 3404	com/tencent/mm/plugin/sns/ui/ay:<init>	(Landroid/app/Activity;)V
    //   935: putfield 1309	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Agp	Lcom/tencent/mm/plugin/sns/ui/ay;
    //   938: aload_0
    //   939: new 817	com/tencent/mm/plugin/sns/ui/bb
    //   942: dup
    //   943: aload_0
    //   944: invokevirtual 758	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
    //   947: invokespecial 3405	com/tencent/mm/plugin/sns/ui/bb:<init>	(Landroid/content/Context;)V
    //   950: putfield 549	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asa	Lcom/tencent/mm/plugin/sns/ui/bb;
    //   953: aload_0
    //   954: new 3407	com/tencent/mm/plugin/sns/ui/j
    //   957: dup
    //   958: aload_0
    //   959: aload_0
    //   960: invokevirtual 573	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   963: aload_0
    //   964: getfield 346	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AsH	Lcom/tencent/mm/plugin/sns/model/ai;
    //   967: invokespecial 3410	com/tencent/mm/plugin/sns/ui/j:<init>	(Landroid/app/Activity;ILcom/tencent/mm/plugin/sns/model/ag;)V
    //   970: putfield 640	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asf	Lcom/tencent/mm/plugin/sns/ui/j;
    //   973: aload_0
    //   974: new 3412	com/tencent/mm/plugin/sns/ui/l
    //   977: dup
    //   978: aload_0
    //   979: invokespecial 3415	com/tencent/mm/plugin/sns/ui/l:<init>	(Lcom/tencent/mm/plugin/sns/ui/aa;)V
    //   982: putfield 3417	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asg	Lcom/tencent/mm/plugin/sns/ui/l;
    //   985: aload_1
    //   986: ifnull +76 -> 1062
    //   989: aload_0
    //   990: aload_1
    //   991: iconst_0
    //   992: invokestatic 1453	com/tencent/mm/plugin/sns/ui/bh:c	(Lcom/tencent/mm/plugin/sns/storage/p;Z)I
    //   995: putfield 545	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oOD	I
    //   998: getstatic 587	com/tencent/mm/plugin/sns/j/e:zKO	Lcom/tencent/mm/plugin/sns/j/e;
    //   1001: invokestatic 3235	java/lang/System:currentTimeMillis	()J
    //   1004: putfield 3420	com/tencent/mm/plugin/sns/j/e:zLn	J
    //   1007: getstatic 587	com/tencent/mm/plugin/sns/j/e:zKO	Lcom/tencent/mm/plugin/sns/j/e;
    //   1010: astore 6
    //   1012: aload_1
    //   1013: ifnull +40 -> 1053
    //   1016: aload_1
    //   1017: getfield 1651	com/tencent/mm/plugin/sns/storage/p:field_snsId	J
    //   1020: invokestatic 3424	com/tencent/mm/plugin/sns/data/r:zW	(J)Ljava/lang/String;
    //   1023: astore 7
    //   1025: aload 6
    //   1027: getfield 3427	com/tencent/mm/plugin/sns/j/e:zLh	Ljava/util/List;
    //   1030: aload 7
    //   1032: invokeinterface 3430 2 0
    //   1037: ifne +16 -> 1053
    //   1040: aload 6
    //   1042: getfield 3427	com/tencent/mm/plugin/sns/j/e:zLh	Ljava/util/List;
    //   1045: aload 7
    //   1047: invokeinterface 2109 2 0
    //   1052: pop
    //   1053: getstatic 587	com/tencent/mm/plugin/sns/j/e:zKO	Lcom/tencent/mm/plugin/sns/j/e;
    //   1056: invokestatic 3235	java/lang/System:currentTimeMillis	()J
    //   1059: putfield 3433	com/tencent/mm/plugin/sns/j/e:zLu	J
    //   1062: aload_1
    //   1063: ifnull +80 -> 1143
    //   1066: aload_1
    //   1067: bipush 32
    //   1069: invokevirtual 449	com/tencent/mm/plugin/sns/storage/p:Rt	(I)Z
    //   1072: ifeq +71 -> 1143
    //   1075: aload_0
    //   1076: getfield 2849	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asy	I
    //   1079: bipush 16
    //   1081: if_icmpne +298 -> 1379
    //   1084: aload_0
    //   1085: new 2350	com/tencent/mm/plugin/sns/ad/e/j
    //   1088: dup
    //   1089: iconst_2
    //   1090: invokespecial 3435	com/tencent/mm/plugin/sns/ad/e/j:<init>	(I)V
    //   1093: putfield 1135	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asq	Lcom/tencent/mm/plugin/sns/ad/e/j;
    //   1096: aload_0
    //   1097: getfield 1135	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asq	Lcom/tencent/mm/plugin/sns/ad/e/j;
    //   1100: aload_0
    //   1101: getfield 3229	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenHeight	I
    //   1104: aload_0
    //   1105: invokevirtual 3439	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSupportActionBar	()Landroid/support/v7/app/ActionBar;
    //   1108: invokevirtual 3444	android/support/v7/app/ActionBar:getCustomView	()Landroid/view/View;
    //   1111: aload_0
    //   1112: invokevirtual 3447	com/tencent/mm/plugin/sns/ad/e/j:a	(ILandroid/view/View;Landroid/app/Activity;)V
    //   1115: aload_1
    //   1116: iconst_0
    //   1117: invokestatic 1453	com/tencent/mm/plugin/sns/ui/bh:c	(Lcom/tencent/mm/plugin/sns/storage/p;Z)I
    //   1120: pop
    //   1121: aload_0
    //   1122: getfield 542	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zrv	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   1125: aload_0
    //   1126: getfield 1135	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asq	Lcom/tencent/mm/plugin/sns/ad/e/j;
    //   1129: invokevirtual 3450	com/tencent/mm/plugin/sns/ui/d/c:b	(Lcom/tencent/mm/plugin/sns/ad/e/j;)V
    //   1132: aload_0
    //   1133: getfield 1313	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Agv	Lcom/tencent/mm/plugin/sns/ui/b;
    //   1136: aload_0
    //   1137: getfield 1135	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asq	Lcom/tencent/mm/plugin/sns/ad/e/j;
    //   1140: putfield 3453	com/tencent/mm/plugin/sns/ui/b:zrZ	Lcom/tencent/mm/plugin/sns/ad/e/j;
    //   1143: aload_0
    //   1144: invokevirtual 3455	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:initView	()V
    //   1147: aload_1
    //   1148: ifnull +49 -> 1197
    //   1151: aload_1
    //   1152: bipush 32
    //   1154: invokevirtual 449	com/tencent/mm/plugin/sns/storage/p:Rt	(I)Z
    //   1157: ifeq +40 -> 1197
    //   1160: aload_1
    //   1161: invokestatic 521	com/tencent/mm/plugin/sns/model/al:u	(Lcom/tencent/mm/plugin/sns/storage/p;)Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   1164: astore 6
    //   1166: aload_0
    //   1167: getfield 1135	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asq	Lcom/tencent/mm/plugin/sns/ad/e/j;
    //   1170: iconst_0
    //   1171: aload_1
    //   1172: invokevirtual 965	com/tencent/mm/plugin/sns/storage/p:eco	()Ljava/lang/String;
    //   1175: aload_1
    //   1176: invokevirtual 3458	com/tencent/mm/plugin/sns/storage/p:eck	()Z
    //   1179: aload_0
    //   1180: getfield 1417	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:ArL	Landroid/view/View;
    //   1183: aload_1
    //   1184: getfield 1651	com/tencent/mm/plugin/sns/storage/p:field_snsId	J
    //   1187: aload 6
    //   1189: aload_0
    //   1190: getfield 545	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oOD	I
    //   1193: iconst_2
    //   1194: invokevirtual 3461	com/tencent/mm/plugin/sns/ad/e/j:a	(ILjava/lang/String;ZLandroid/view/View;JLcom/tencent/mm/protocal/protobuf/SnsObject;II)V
    //   1197: aload_0
    //   1198: getfield 1417	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:ArL	Landroid/view/View;
    //   1201: ifnull +79 -> 1280
    //   1204: aload_1
    //   1205: ifnull +75 -> 1280
    //   1208: aload_0
    //   1209: getfield 1417	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:ArL	Landroid/view/View;
    //   1212: ldc_w 2173
    //   1215: invokevirtual 1455	android/view/View:findViewById	(I)Landroid/view/View;
    //   1218: checkcast 3463	com/tencent/mm/plugin/sight/decode/a/a
    //   1221: astore 6
    //   1223: aload_1
    //   1224: invokevirtual 453	com/tencent/mm/plugin/sns/storage/p:ebP	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1227: getfield 459	com/tencent/mm/protocal/protobuf/TimeLineObject:HUG	Lcom/tencent/mm/protocal/protobuf/abo;
    //   1230: ifnull +339 -> 1569
    //   1233: aload_1
    //   1234: invokevirtual 453	com/tencent/mm/plugin/sns/storage/p:ebP	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1237: getfield 459	com/tencent/mm/protocal/protobuf/TimeLineObject:HUG	Lcom/tencent/mm/protocal/protobuf/abo;
    //   1240: getfield 812	com/tencent/mm/protocal/protobuf/abo:Gtw	I
    //   1243: bipush 15
    //   1245: if_icmpne +324 -> 1569
    //   1248: aload 6
    //   1250: instanceof 2275
    //   1253: ifeq +316 -> 1569
    //   1256: aload 6
    //   1258: checkcast 2275	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView
    //   1261: getfield 3467	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView:ziA	Lcom/tencent/mm/plugin/sight/decode/a/b;
    //   1264: invokevirtual 3472	com/tencent/mm/plugin/sight/decode/a/b:dTz	()Z
    //   1267: istore 5
    //   1269: aload_1
    //   1270: iconst_1
    //   1271: iload 5
    //   1273: aload_0
    //   1274: invokevirtual 573	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   1277: invokestatic 3477	com/tencent/mm/plugin/sns/ad/e/n:a	(Lcom/tencent/mm/plugin/sns/storage/p;ZZI)V
    //   1280: aload_0
    //   1281: getfield 670	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:ArP	Landroid/widget/ListView;
    //   1284: ifnonnull +110 -> 1394
    //   1287: ldc_w 3164
    //   1290: invokestatic 274	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1293: return
    //   1294: ldc_w 730
    //   1297: ldc_w 3479
    //   1300: invokestatic 802	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1303: goto -624 -> 679
    //   1306: invokestatic 1534	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   1309: pop
    //   1310: invokestatic 3374	com/tencent/mm/kernel/g:ajQ	()Lcom/tencent/mm/kernel/b;
    //   1313: getfield 3380	com/tencent/mm/kernel/b:gDv	Lcom/tencent/mm/ak/q;
    //   1316: new 3382	com/tencent/mm/plugin/sns/model/q
    //   1319: dup
    //   1320: aload_0
    //   1321: getfield 509	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dAg	Ljava/lang/String;
    //   1324: invokestatic 3386	com/tencent/mm/plugin/sns/storage/x:aze	(Ljava/lang/String;)J
    //   1327: invokespecial 3388	com/tencent/mm/plugin/sns/model/q:<init>	(J)V
    //   1330: iconst_0
    //   1331: invokevirtual 3393	com/tencent/mm/ak/q:a	(Lcom/tencent/mm/ak/n;I)Z
    //   1334: pop
    //   1335: goto -518 -> 817
    //   1338: invokestatic 1534	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
    //   1341: pop
    //   1342: invokestatic 3374	com/tencent/mm/kernel/g:ajQ	()Lcom/tencent/mm/kernel/b;
    //   1345: getfield 3380	com/tencent/mm/kernel/b:gDv	Lcom/tencent/mm/ak/q;
    //   1348: new 3481	com/tencent/mm/plugin/sns/model/m
    //   1351: dup
    //   1352: aload_0
    //   1353: getfield 509	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dAg	Ljava/lang/String;
    //   1356: invokestatic 3386	com/tencent/mm/plugin/sns/storage/x:aze	(Ljava/lang/String;)J
    //   1359: iconst_0
    //   1360: aload_0
    //   1361: aload_1
    //   1362: invokespecial 676	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:g	(Lcom/tencent/mm/plugin/sns/storage/p;)Lcom/tencent/mm/plugin/sns/storage/a;
    //   1365: getfield 3484	com/tencent/mm/plugin/sns/storage/a:zMt	Ljava/lang/String;
    //   1368: invokespecial 3487	com/tencent/mm/plugin/sns/model/m:<init>	(JILjava/lang/String;)V
    //   1371: iconst_0
    //   1372: invokevirtual 3393	com/tencent/mm/ak/q:a	(Lcom/tencent/mm/ak/n;I)Z
    //   1375: pop
    //   1376: goto -559 -> 817
    //   1379: aload_0
    //   1380: new 2350	com/tencent/mm/plugin/sns/ad/e/j
    //   1383: dup
    //   1384: iconst_1
    //   1385: invokespecial 3435	com/tencent/mm/plugin/sns/ad/e/j:<init>	(I)V
    //   1388: putfield 1135	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Asq	Lcom/tencent/mm/plugin/sns/ad/e/j;
    //   1391: goto -295 -> 1096
    //   1394: aload_0
    //   1395: getfield 670	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:ArP	Landroid/widget/ListView;
    //   1398: new 76	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$6
    //   1401: dup
    //   1402: aload_0
    //   1403: invokespecial 3488	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$6:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   1406: invokevirtual 3489	android/widget/ListView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1409: aload_0
    //   1410: new 3491	com/tencent/mm/plugin/sns/ui/n
    //   1413: dup
    //   1414: aload_0
    //   1415: invokespecial 3492	com/tencent/mm/plugin/sns/ui/n:<init>	(Landroid/content/Context;)V
    //   1418: putfield 337	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AsD	Lcom/tencent/mm/plugin/sns/ui/n;
    //   1421: aload_1
    //   1422: ifnull +34 -> 1456
    //   1425: aload_0
    //   1426: getfield 1285	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:fHO	Ljava/lang/String;
    //   1429: aload_1
    //   1430: getfield 923	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
    //   1433: invokestatic 1760	com/tencent/mm/sdk/platformtools/bu:lX	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1436: ifeq +20 -> 1456
    //   1439: aload_0
    //   1440: iconst_0
    //   1441: ldc_w 3493
    //   1444: new 3495	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7
    //   1447: dup
    //   1448: aload_0
    //   1449: aload_1
    //   1450: invokespecial 3496	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;Lcom/tencent/mm/plugin/sns/storage/p;)V
    //   1453: invokevirtual 3500	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:addIconOptionMenu	(IILandroid/view/MenuItem$OnMenuItemClickListener;)V
    //   1456: getstatic 3049	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   1459: aload_0
    //   1460: getfield 387	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:kzS	Lcom/tencent/mm/sdk/b/c;
    //   1463: invokevirtual 3503	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1466: pop
    //   1467: getstatic 3049	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   1470: aload_0
    //   1471: getfield 351	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AsI	Lcom/tencent/mm/sdk/b/c;
    //   1474: invokevirtual 3503	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1477: pop
    //   1478: getstatic 3049	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   1481: aload_0
    //   1482: getfield 354	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AsJ	Lcom/tencent/mm/sdk/b/c;
    //   1485: invokevirtual 3503	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1488: pop
    //   1489: getstatic 3049	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   1492: aload_0
    //   1493: getfield 357	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AsK	Lcom/tencent/mm/sdk/b/c;
    //   1496: invokevirtual 3503	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1499: pop
    //   1500: getstatic 3049	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   1503: aload_0
    //   1504: getfield 360	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AsL	Lcom/tencent/mm/sdk/b/c;
    //   1507: invokevirtual 3503	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1510: pop
    //   1511: getstatic 3049	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   1514: aload_0
    //   1515: getfield 384	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AsP	Lcom/tencent/mm/sdk/b/c;
    //   1518: invokevirtual 3503	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1521: pop
    //   1522: getstatic 3049	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   1525: aload_0
    //   1526: getfield 392	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AsQ	Lcom/tencent/mm/sdk/b/c;
    //   1529: invokevirtual 3503	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1532: pop
    //   1533: getstatic 3049	com/tencent/mm/sdk/b/a:IvT	Lcom/tencent/mm/sdk/b/a;
    //   1536: aload_0
    //   1537: getfield 363	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AgC	Lcom/tencent/mm/sdk/b/c;
    //   1540: invokevirtual 3503	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1543: pop
    //   1544: aload_0
    //   1545: invokestatic 3505	com/tencent/mm/pluginsdk/h:r	(Lcom/tencent/mm/ui/MMActivity;)V
    //   1548: ldc_w 3164
    //   1551: invokestatic 274	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1554: return
    //   1555: astore_1
    //   1556: goto -877 -> 679
    //   1559: astore 6
    //   1561: goto -914 -> 647
    //   1564: astore 7
    //   1566: goto -983 -> 583
    //   1569: iconst_0
    //   1570: istore 5
    //   1572: goto -303 -> 1269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1575	0	this	SnsCommentDetailUI
    //   0	1575	1	paramBundle	Bundle
    //   293	11	2	i	int
    //   482	189	3	l	long
    //   1267	304	5	bool	boolean
    //   505	752	6	localObject	Object
    //   1559	1	6	localIOException	java.io.IOException
    //   1023	23	7	str	String
    //   1564	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   507	514	1555	java/io/IOException
    //   638	647	1559	java/io/IOException
    //   574	583	1564	java/lang/Exception
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98596);
    ah.dXu().a(this, 5);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(210, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(218, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(213, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(214, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(683, this);
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajQ().gDv.b(682, this);
    ah.dXB().aE(this);
    com.tencent.mm.sdk.b.a.IvT.d(this.kzS);
    if (this.Asf != null) {
      this.Asf.activity = null;
    }
    ae.edF();
    if (this.Agn != null) {
      this.Agn.efC();
    }
    com.tencent.mm.plugin.sns.storage.p localp = rW(false);
    Object localObject;
    if ((localp != null) && (localp.Rt(32)))
    {
      if (this.Asq != null) {
        this.Asq.a(0, localp.eco(), localp.field_snsId, 2);
      }
      localObject = g(localp);
      if (localObject != null) {
        break label614;
      }
      localObject = "";
      if (!localp.dZL()) {
        break label622;
      }
      ah.dXy().f(14652, new Object[] { com.tencent.mm.plugin.sns.ad.e.i.a(localp.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.r.zV(localp.field_snsId), localObject, Long.valueOf(this.ArJ), Long.valueOf(System.currentTimeMillis()) }) });
    }
    for (;;)
    {
      com.tencent.mm.modelsns.e locale = com.tencent.mm.modelsns.e.pZ(732);
      locale.GU(com.tencent.mm.plugin.sns.data.r.zV(localp.field_snsId)).GU((String)localObject).GU(this.ArJ).GU(System.currentTimeMillis());
      locale.aLH();
      this.zrv.removeListener();
      com.tencent.mm.sdk.b.a.IvT.d(this.AsI);
      com.tencent.mm.sdk.b.a.IvT.d(this.AsJ);
      com.tencent.mm.sdk.b.a.IvT.d(this.AsK);
      com.tencent.mm.sdk.b.a.IvT.d(this.AsL);
      com.tencent.mm.sdk.b.a.IvT.d(this.AsP);
      com.tencent.mm.sdk.b.a.IvT.d(this.AsQ);
      com.tencent.mm.sdk.b.a.IvT.d(this.AgC);
      super.onDestroy();
      localObject = com.tencent.mm.plugin.sns.j.e.zKO;
      if (((com.tencent.mm.plugin.sns.j.e)localObject).zLn != 0L)
      {
        ((com.tencent.mm.plugin.sns.j.e)localObject).zLo += System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.j.e)localObject).zLn;
        ((com.tencent.mm.plugin.sns.j.e)localObject).zLn = 0L;
      }
      localObject = com.tencent.mm.plugin.sns.j.e.zKO;
      if (((com.tencent.mm.plugin.sns.j.e)localObject).zLu != 0L)
      {
        ((com.tencent.mm.plugin.sns.j.e)localObject).zLv += System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.j.e)localObject).zLu;
        ((com.tencent.mm.plugin.sns.j.e)localObject).zLu = 0L;
      }
      if ((this.Asz) && (localp != null) && (localp.ebP() != null) && (localp.ebP().HUG != null))
      {
        localObject = com.tencent.mm.plugin.sns.j.e.zKO.dZk();
        ((ey)localObject).edv = com.tencent.mm.plugin.sns.j.e.zKO.zLc.edv;
        ((ey)localObject).oy(com.tencent.mm.plugin.sns.j.e.zKO.zLc.emc).oz(com.tencent.mm.plugin.sns.data.r.zW(localp.field_snsId)).dWn = localp.ebP().HUG.Gtw;
        com.tencent.mm.plugin.sns.j.e.zKO.dZp();
      }
      AppMethodBeat.o(98596);
      return;
      label614:
      localObject = ((com.tencent.mm.plugin.sns.storage.a)localObject).dGD;
      break;
      label622:
      ah.dXy().f(12012, new Object[] { com.tencent.mm.plugin.sns.ad.e.i.a(localp.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.r.zV(localp.field_snsId), localObject, Long.valueOf(this.ArJ), Long.valueOf(System.currentTimeMillis()) }) });
    }
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(98612);
    if (keyboardState() == 2)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "keybaordhide! ");
      this.ArZ = false;
      AppMethodBeat.o(98612);
      return;
    }
    if (keyboardState() == 1)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "keybaordShow");
      efs();
      this.Agk = false;
      this.AsN.run();
      if (this.Agv != null) {
        this.Agv.dYX();
      }
    }
    AppMethodBeat.o(98612);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98598);
    ah.dXz().b(this);
    try
    {
      bi.a(this, null);
      this.AoZ = false;
      super.onPause();
      this.Agn.fNT.hideVKB();
      Object localObject = this.Agn;
      if (((SnsCommentFooter)localObject).qdo != null) {
        ((SnsCommentFooter)localObject).qdo.onPause();
      }
      new xg().dMK.type = 1;
      try
      {
        if ((this.Asu) && (this.ArL != null))
        {
          localObject = rW(false);
          if ((localObject != null) && (((com.tencent.mm.plugin.sns.storage.p)localObject).Rt(32)))
          {
            localVideoSightView = (VideoSightView)this.ArL.findViewById(2131300914);
            SnsAdTimelineVideoView localSnsAdTimelineVideoView = (SnsAdTimelineVideoView)this.ArL.findViewById(2131308163);
            if (!a((com.tencent.mm.plugin.sns.storage.p)localObject, localSnsAdTimelineVideoView)) {
              break label246;
            }
            if ((localSnsAdTimelineVideoView.isPlaying()) && (localSnsAdTimelineVideoView.getVisibility() == 0))
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "new video vie pauseNormalVideoAd");
              com.tencent.mm.plugin.sns.ad.timeline.a.e.c(localSnsAdTimelineVideoView);
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          VideoSightView localVideoSightView;
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI", "pauseNormalVideoAd, exp=" + localThrowable2.toString());
        }
      }
      if (this.Asq != null)
      {
        this.Asq.onPause();
        localObject = rW(false);
        if ((localObject != null) && (((com.tencent.mm.plugin.sns.storage.p)localObject).Rt(32))) {
          this.Asq.zP(((com.tencent.mm.plugin.sns.storage.p)localObject).field_snsId);
        }
      }
      if (this.Asp != null) {
        this.Asp.onPause();
      }
      AppMethodBeat.o(98598);
      return;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable1.toString());
        continue;
        label246:
        if ((localVideoSightView.isPlaying()) && (localVideoSightView.getVisibility() == 0))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "pauseNormalVideoAd");
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
      if (!this.AoZ)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onResume callback");
        bi.a(this, this.ApP);
        this.AoZ = true;
      }
      ah.dXz().a(this);
      localObject = new xg();
      ((xg)localObject).dMK.dML = 0;
      ((xg)localObject).dMK.dMM = 1;
      ((xg)localObject).dMK.dMN = 0;
      ((xg)localObject).dMK.type = 0;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      if (this.Asq != null) {
        this.Asq.onResume();
      }
      if (this.Asp != null) {
        this.Asp.refreshView();
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
          if ((this.Asu) && (this.ArL != null))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "new video vie resumeNormalVideoAd called");
            localObject = (SnsAdTimelineVideoView)this.ArL.findViewById(2131308163);
            if (a(rW(false), (SnsAdTimelineVideoView)localObject))
            {
              com.tencent.mm.plugin.sns.ad.timeline.a.e.b((SnsAdTimelineVideoView)localObject);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "new video vie resumeNormalVideoAd");
            }
          }
          AppMethodBeat.o(98597);
          return;
        }
        catch (Throwable localThrowable2)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI", "resumeNormalVideoAd, exp=" + localThrowable2.toString());
          AppMethodBeat.o(98597);
        }
        localThrowable1 = localThrowable1;
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable1.toString());
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(98611);
    if ((paramn.getType() == 218) && (this.AgA != null)) {
      this.AgA.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((this.AsD != null) && (this.AsD.tipDialog != null) && (this.AsD.tipDialog.isShowing())) {
        this.AsD.tipDialog.dismiss();
      }
      paramn = com.tencent.mm.plugin.sns.storage.h.aBq(this.dAg);
      if (paramn == null)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.dAg);
        finish();
        AppMethodBeat.o(98611);
        return;
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsCommentDetailUI", "snsId: " + this.dAg + "  username:" + paramn.field_userName);
      if (this.ArL == null)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI", "fatal error! Sns onSceneEnd before initView and infoHeader is null!");
        finish();
        AppMethodBeat.o(98611);
        return;
      }
      efr();
      b(paramn, false);
      paramString = al.u(paramn);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "onsceneend " + paramString.LikeUserList.size() + " " + paramString.CommentUserList.size());
      if (paramString == null)
      {
        AppMethodBeat.o(98611);
        return;
      }
      if (!f(this.ArX, paramString.LikeUserList))
      {
        j(paramString.LikeUserList, paramString.CommentUserList.isEmpty());
        this.ArX = paramString.LikeUserList;
      }
      if (this.ArO != null) {
        this.ArO.a(paramn, this.zrv);
      }
      paramn = this.ArS;
      LinkedList localLinkedList = paramString.CommentUserList;
      paramString = paramString.LikeUserList;
      paramn.commentList = localLinkedList;
      paramn.Atu = paramString;
      this.ArS.notifyDataSetChanged();
      paramString = this.ArS;
      new com.tencent.mm.sdk.platformtools.aq().postDelayed(new SnsCommentDetailUI.b.1(paramString), 60L);
    }
    AppMethodBeat.o(98611);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(219875);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      bi.a(this, null);
      this.AoZ = false;
      AppMethodBeat.o(219875);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.o(219875);
    }
    if (!this.AoZ)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onWindowFocusChanged callback");
      bi.a(this, this.ApP);
      this.AoZ = true;
    }
    AppMethodBeat.o(219875);
    return;
  }
  
  final class a
    extends com.tencent.mm.pluginsdk.ui.span.p
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(98583);
      SnsCommentDetailUI.j(SnsCommentDetailUI.this).AHo.onClick(paramView);
      AppMethodBeat.o(98583);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(98584);
      int i = SnsCommentDetailUI.this.getResources().getColor(2131100913);
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
    LinkedList<dgh> Atu;
    Activity activity;
    public LinkedList<dgh> commentList;
    String dqc;
    
    public b(LinkedList<dgh> paramLinkedList, Activity paramActivity, String paramString)
    {
      this.commentList = paramLinkedList;
      this.Atu = paramActivity;
      this.activity = paramString;
      Object localObject;
      this.dqc = localObject;
    }
    
    public final int getCount()
    {
      int i = 0;
      AppMethodBeat.i(98587);
      if (this.Atu.size() > 0)
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
      if (this.Atu.size() > 0)
      {
        if (paramInt == 0)
        {
          paramView = SnsCommentDetailUI.K(SnsCommentDetailUI.this);
          AppMethodBeat.o(98588);
          return paramView;
        }
        i = paramInt - 1;
      }
      Object localObject3 = (dgh)this.commentList.get(i);
      ((dgh)localObject3).hFS = bu.nullAsNil(((dgh)localObject3).hFS);
      View localView;
      if ((paramView == null) || (!(paramView.getTag() instanceof a)))
      {
        localView = z.jV(this.activity).inflate(2131495539, null);
        localView.setOnTouchListener(SnsCommentDetailUI.L(SnsCommentDetailUI.this));
        paramViewGroup = new a();
        paramViewGroup.fQl = ((ImageView)localView.findViewById(2131296547));
        paramViewGroup.fQl.setOnClickListener(SnsCommentDetailUI.M(SnsCommentDetailUI.this));
        paramViewGroup.jjZ = ((TextView)localView.findViewById(2131296559));
        paramViewGroup.jjZ.setOnTouchListener(new ae());
        paramViewGroup.jjZ.setOnClickListener(new SnsCommentDetailUI.b.2(this));
        paramViewGroup.timeTv = ((TextView)localView.findViewById(2131296562));
        paramViewGroup.heO = ((TextView)localView.findViewById(2131296551));
        paramViewGroup.Atw = ((FrameLayout)localView.findViewById(2131296550));
        paramViewGroup.heO.setOnTouchListener(new ae());
        paramViewGroup.Atx = ((SnsTranslateResultView)localView.findViewById(2131305091));
        paramViewGroup.Atx.setVisibility(8);
        paramViewGroup.Atz = ((EmojiStatusView)localView.findViewById(2131296552));
        if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) != 10) {
          break label1946;
        }
        localView.findViewById(2131298543).setBackgroundResource(2131232444);
      }
      label435:
      label840:
      label1611:
      label1872:
      for (;;)
      {
        paramViewGroup.Aty = ((dgh)localObject3);
        paramViewGroup.userName = ((dgh)localObject3).Username;
        ((SnsAvatarImageView)paramViewGroup.fQl).fn(((dgh)localObject3).Username, 3);
        ((SnsAvatarImageView)paramViewGroup.fQl).setWeakContext(this.activity);
        label366:
        com.tencent.mm.plugin.sns.storage.p localp;
        if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10)
        {
          paramInt = 3;
          SnsCommentDetailUI.F(SnsCommentDetailUI.this);
          com.tencent.mm.kernel.g.ajS();
          paramView = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().aUK(paramViewGroup.userName);
          if ((i != 0) || (!this.Atu.isEmpty())) {
            break label1611;
          }
          if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) != 10) {
            break label1600;
          }
          localView.setBackgroundResource(2131232445);
          if (i != 0) {
            break label1645;
          }
          localView.findViewById(2131304961).setVisibility(0);
          localView.findViewById(2131304962).setVisibility(8);
          if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10) {
            ((ImageView)localView.findViewById(2131304961)).setImageResource(2131690252);
          }
          label490:
          localp = com.tencent.mm.plugin.sns.storage.h.aBq(SnsCommentDetailUI.o(SnsCommentDetailUI.this));
          paramViewGroup.fQl.setTag(((dgh)localObject3).Username);
          if (!com.tencent.mm.plugin.sns.ui.widget.e.a(paramViewGroup.fQl, localp, ((dgh)localObject3).Username)) {
            a.b.w(paramViewGroup.fQl, ((dgh)localObject3).Username);
          }
          if (paramView == null) {
            break label1670;
          }
          paramView = paramView.adG();
          if (!com.tencent.mm.plugin.sns.ui.widget.e.b(localp, ((dgh)localObject3).Username)) {
            break label1943;
          }
          paramView = com.tencent.mm.plugin.sns.ui.widget.e.b(localp.dVj(), paramView);
        }
        label979:
        label1884:
        label1895:
        for (;;)
        {
          String str;
          CharSequence localCharSequence;
          Object localObject2;
          Object localObject1;
          label749:
          int j;
          label888:
          long l;
          if (localp != null)
          {
            str = localp.field_userName;
            paramViewGroup.heO.setText(((dgh)localObject3).hFS + " ");
            localCharSequence = com.tencent.mm.plugin.sns.ui.widget.e.a(SnsCommentDetailUI.this, (dgh)localObject3, SnsCommentDetailUI.N(SnsCommentDetailUI.this), localp.field_type, localp.field_userName, 2, SnsCommentDetailUI.O(SnsCommentDetailUI.this), SnsCommentDetailUI.P(SnsCommentDetailUI.this), localp);
            localObject2 = null;
            localObject1 = localObject2;
            if (!bu.ht(((dgh)localObject3).HNp))
            {
              localObject1 = localObject2;
              if (((dgh)localObject3).HNp.get(0) != null)
              {
                localObject1 = ((dgn)((dgh)localObject3).HNp.get(0)).Md5;
                localObject1 = be.fvc().JfU.aWl((String)localObject1);
              }
            }
            if (localObject1 != null) {
              break label1696;
            }
            paramViewGroup.Atz.setVisibility(8);
            paramViewGroup.Atz.setEmojiInfo(null);
            paramViewGroup.jjZ.setText(paramView, TextView.BufferType.SPANNABLE);
            com.tencent.mm.pluginsdk.ui.span.k.o(paramViewGroup.jjZ, paramInt);
            localObject1 = new com.tencent.mm.pluginsdk.ui.span.l(paramViewGroup.jjZ.getText());
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "test %s,%s", new Object[] { ((dgh)localObject3).Username, paramView });
            if (!com.tencent.mm.plugin.sns.ui.widget.e.b(localp, ((dgh)localObject3).Username)) {
              break label1790;
            }
            if (!com.tencent.mm.plugin.sns.ui.widget.e.id(((dgh)localObject3).HNo, 32)) {
              break label1784;
            }
            j = 27;
            ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).a(new com.tencent.mm.pluginsdk.ui.span.p(new com.tencent.mm.plugin.sns.data.a(localp.Rt(32), ((dgh)localObject3).Username, localp.eco(), 2, j), SnsCommentDetailUI.N(SnsCommentDetailUI.this), paramInt), paramView);
            paramViewGroup.jjZ.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
            l = ((dgh)localObject3).CreateTime;
            if (com.tencent.mm.plugin.sns.ui.widget.e.id(((dgh)localObject3).HNo, 32)) {
              l = localp.field_createTime;
            }
            paramViewGroup.timeTv.setText(bj.r(this.activity, l * 1000L));
            if (!bu.ah(localCharSequence)) {
              break label1819;
            }
            paramViewGroup.heO.setVisibility(8);
            SnsCommentDetailUI.Q(SnsCommentDetailUI.this).c(localView, SnsCommentDetailUI.E(SnsCommentDetailUI.this).APZ, SnsCommentDetailUI.E(SnsCommentDetailUI.this).APL);
            SnsCommentDetailUI.Q(SnsCommentDetailUI.this).c(paramViewGroup.Atw, SnsCommentDetailUI.E(SnsCommentDetailUI.this).APZ, SnsCommentDetailUI.E(SnsCommentDetailUI.this).APL);
            if (((dgh)localObject3).HNk == 0) {
              break label1862;
            }
            l = ((dgh)localObject3).HNk;
            localObject2 = as.jw(SnsCommentDetailUI.o(SnsCommentDetailUI.this), String.valueOf(l));
            if ((as.fe((String)localObject2, 4)) && (paramViewGroup.Atx != null))
            {
              localObject2 = as.aAt((String)localObject2);
              if (localObject2 == null) {
                break label1895;
              }
              paramViewGroup.Atx.setVisibility(0);
              if (!((as.b)localObject2).hLB) {
                break label1884;
              }
              if (((as.b)localObject2).aGQ) {
                break label1872;
              }
              paramViewGroup.Atx.a((as.b)localObject2, 2, ((as.b)localObject2).result, ((as.b)localObject2).hTy, ((as.b)localObject2).zDf);
            }
            localView.setClickable(true);
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SnsCommentDetailUI", "position " + ((dgh)localObject3).Username + " self " + SnsCommentDetailUI.t(SnsCommentDetailUI.this) + " commentid " + ((dgh)localObject3).HNk + " snsid " + SnsCommentDetailUI.o(SnsCommentDetailUI.this));
            if (!SnsCommentDetailUI.t(SnsCommentDetailUI.this).equals(((dgh)localObject3).Username)) {
              break label1907;
            }
          }
          label1645:
          label1907:
          for (paramViewGroup.info = localObject3;; paramViewGroup.info = new Object[] { Integer.valueOf(i), localObject3, ((dgh)localObject3).Username, paramView })
          {
            paramView = new m(SnsCommentDetailUI.k(SnsCommentDetailUI.this), SnsCommentDetailUI.o(SnsCommentDetailUI.this), (dgh)localObject3, ((dgh)localObject3).Username, ((dgh)localObject3).hFS, paramViewGroup.heO, 2, str);
            paramView.tag = paramViewGroup;
            localView.setTag(paramView);
            paramViewGroup.heO.setTag(paramView);
            localView.setOnClickListener(SnsCommentDetailUI.R(SnsCommentDetailUI.this));
            paramViewGroup.heO.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(SnsCommentDetailUI.this));
            paramViewGroup.Atw.setTag(paramView);
            paramViewGroup.Atw.setOnClickListener(SnsCommentDetailUI.R(SnsCommentDetailUI.this));
            if ((!localp.Rt(32)) && (((dgh)localObject3).DeleteFlag > 0))
            {
              ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).setSpan(new ForegroundColorSpan(SnsCommentDetailUI.this.getContext().getResources().getColor(2131099676)), 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).length(), 33);
              paramViewGroup.jjZ.setText((CharSequence)localObject1);
              paramView = paramViewGroup.heO;
              localObject1 = SnsCommentDetailUI.this.getContext();
              localObject2 = ((Context)localObject1).getResources().getString(2131766982);
              localObject3 = new SpannableStringBuilder((CharSequence)localObject2);
              ((SpannableStringBuilder)localObject3).setSpan(new ForegroundColorSpan(((Context)localObject1).getResources().getColor(2131099676)), 0, ((String)localObject2).length(), 0);
              ((SpannableStringBuilder)localObject3).setSpan(new BackgroundColorSpan(((Context)localObject1).getResources().getColor(2131099678)), 0, ((String)localObject2).length(), 0);
              paramView.setText((CharSequence)localObject3);
              paramViewGroup.heO.setOnTouchListener(null);
              paramViewGroup.Atw.setOnLongClickListener(null);
              paramViewGroup.Atw.setOnClickListener(null);
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
            localView.setBackgroundResource(2131232453);
            break label435;
            if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10)
            {
              localView.setBackgroundResource(2131234110);
              break label435;
            }
            localView.setBackgroundResource(2131234109);
            break label435;
            localView.findViewById(2131304961).setVisibility(4);
            localView.findViewById(2131304962).setVisibility(0);
            break label490;
            if (((dgh)localObject3).Nickname != null)
            {
              paramView = ((dgh)localObject3).Nickname;
              break label552;
            }
            paramView = ((dgh)localObject3).Username;
            break label552;
            localObject2 = new m(SnsCommentDetailUI.k(SnsCommentDetailUI.this), SnsCommentDetailUI.o(SnsCommentDetailUI.this), (dgh)localObject3, ((dgh)localObject3).Username, ((dgh)localObject3).hFS, paramViewGroup.heO, 2, str);
            paramViewGroup.Atz.setTag(localObject2);
            paramViewGroup.Atz.setVisibility(0);
            paramViewGroup.Atz.setEmojiInfo((EmojiInfo)localObject1);
            paramViewGroup.Atz.setOnClickListener(SnsCommentDetailUI.E(SnsCommentDetailUI.this).AQs);
            break label749;
            label1784:
            j = 2;
            break label840;
            label1790:
            ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).a(new com.tencent.mm.pluginsdk.ui.span.p(((dgh)localObject3).Username, SnsCommentDetailUI.N(SnsCommentDetailUI.this), paramInt), paramView);
            break label888;
            localObject2 = new SpannableStringBuilder(localCharSequence);
            ((SpannableStringBuilder)localObject2).append(" ");
            paramViewGroup.heO.setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
            paramViewGroup.heO.setVisibility(0);
            break label979;
            l = ((dgh)localObject3).HNm;
            break label1061;
            paramViewGroup.Atx.setVisibility(8);
            break label1155;
            paramViewGroup.Atx.Sa(2);
            break label1155;
            paramViewGroup.Atx.setVisibility(8);
            break label1155;
          }
        }
      }
    }
    
    final class a
    {
      FrameLayout Atw;
      SnsTranslateResultView Atx;
      dgh Aty;
      EmojiStatusView Atz;
      ImageView fQl;
      TextView heO;
      Object info;
      TextView jjZ;
      TextView timeTv;
      String userName;
      
      a() {}
    }
  }
  
  final class c
    implements OfflineVideoView.a
  {
    private SnsAdTimelineVideoView AnI;
    private com.tencent.mm.plugin.sns.storage.p znm;
    
    c(com.tencent.mm.plugin.sns.storage.p paramp, SnsAdTimelineVideoView paramSnsAdTimelineVideoView)
    {
      this.znm = paramp;
      this.AnI = paramSnsAdTimelineVideoView;
    }
    
    public final boolean a(PString paramPString)
    {
      return false;
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(219873);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "the detail new video player onCompletion return value is ");
      if ((SnsCommentDetailUI.f(SnsCommentDetailUI.this) == null) || (this.znm == null) || (this.AnI == null))
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.SnsCommentDetailUI", "the snsAdStatistic or snsInfo is null in onCompletion!!!");
        AppMethodBeat.o(219873);
        return;
      }
      this.AnI.restart();
      SnsCommentDetailUI.f(SnsCommentDetailUI.this).C(this.znm.field_snsId, false);
      AppMethodBeat.o(219873);
    }
    
    public final void onStart(int paramInt)
    {
      AppMethodBeat.i(219872);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "the detail new video player onStart called,  durationSecond = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(219872);
    }
    
    public final void tx(int paramInt)
    {
      AppMethodBeat.i(219874);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "the detail new video player updateTime called, playTimeMs = ".concat(String.valueOf(paramInt)));
      if ((SnsCommentDetailUI.f(SnsCommentDetailUI.this) == null) || (this.znm == null) || (this.AnI == null))
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.SnsCommentDetailUI", "the snsAdStatistic or snsInfo is null in updateTime!!!");
        AppMethodBeat.o(219874);
        return;
      }
      SnsCommentDetailUI.f(SnsCommentDetailUI.this).zO(this.znm.field_snsId);
      SnsCommentDetailUI.f(SnsCommentDetailUI.this).aj(this.znm.field_snsId, paramInt);
      if (!SnsCommentDetailUI.f(SnsCommentDetailUI.this).zL(this.znm.field_snsId))
      {
        paramInt = this.AnI.getDurationMs() / 1000;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "updatePlayStartTime, duration=".concat(String.valueOf(paramInt)));
        SnsCommentDetailUI.f(SnsCommentDetailUI.this).d(this.znm.field_snsId, bu.HQ(), false);
        SnsCommentDetailUI.f(SnsCommentDetailUI.this).e(this.znm.field_snsId, paramInt, false);
        SnsCommentDetailUI.f(SnsCommentDetailUI.this).ai(this.znm.field_snsId, this.znm.field_snsId);
      }
      AppMethodBeat.o(219874);
    }
  }
  
  final class d
    implements Runnable
  {
    private int AtA = -1;
    private int AtB = 10;
    int UL = -1;
    int kl;
    private int offset = 0;
    
    d() {}
    
    public final void run()
    {
      AppMethodBeat.i(98589);
      this.AtB = 10;
      SnsCommentDetailUI.b(SnsCommentDetailUI.this);
      this.AtA = SnsCommentDetailUI.c(SnsCommentDetailUI.this).getTop();
      int i = this.AtA - this.kl;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SnsCommentDetailUI", "list.bottom: %d, listOriginalBottom: %d, footerTop: %d, commentFooter.getTop: %d, topSelection: %d", new Object[] { Integer.valueOf(SnsCommentDetailUI.a(SnsCommentDetailUI.this).getBottom()), Integer.valueOf(SnsCommentDetailUI.d(SnsCommentDetailUI.this)), Integer.valueOf(this.AtA), Integer.valueOf(SnsCommentDetailUI.c(SnsCommentDetailUI.this).getTop()), Integer.valueOf(i) });
      if (i == this.offset)
      {
        SnsCommentDetailUI.a(SnsCommentDetailUI.this).setSelectionFromTop(SnsCommentDetailUI.a(SnsCommentDetailUI.this).getHeaderViewsCount() + this.UL, i);
        this.AtB = 0;
        this.offset = 0;
        AppMethodBeat.o(98589);
        return;
      }
      int j = this.AtB;
      this.AtB = (j - 1);
      if (j > 0)
      {
        new com.tencent.mm.sdk.platformtools.aq().postDelayed(this, 100L);
        this.offset = i;
        AppMethodBeat.o(98589);
        return;
      }
      this.offset = 0;
      this.AtB = 0;
      AppMethodBeat.o(98589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI
 * JD-Core Version:    0.7.0.1
 */