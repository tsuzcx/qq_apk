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
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
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
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.g.a.ud;
import com.tencent.mm.g.a.ue;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.g.b.a.ck;
import com.tencent.mm.g.b.a.cs;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.c.i.a;
import com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.cuu;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bh.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.kernel.i
public class SnsCommentDetailUI
  extends MMActivity
  implements com.tencent.mm.al.g, i.a, b.b, z
{
  private static com.tencent.mm.loader.c.d<String, Bitmap> qCy;
  public static int xwQ;
  private static com.tencent.mm.loader.c.e xxn;
  private static com.tencent.mm.loader.c.e xxo;
  private String dpC;
  private String dqm;
  private String fki;
  private com.tencent.mm.sdk.b.c jBI;
  private boolean jWx;
  private int mBE;
  private int mScreenHeight;
  private int mScreenWidth;
  private com.tencent.mm.ui.widget.b.a mVN;
  private View.OnClickListener mXa;
  private int nBH;
  private View.OnClickListener olC;
  private ClipboardManager qiE;
  private LinearLayout wCT;
  private boolean xkZ;
  private SnsCommentFooter xlc;
  private av xle;
  private b xlk;
  private com.tencent.mm.plugin.sns.i.b xll;
  private aj xlm;
  private bo xln;
  private com.tencent.mm.ui.base.p xlp;
  private com.tencent.mm.sdk.b.c xlr;
  private View.OnTouchListener xmL;
  private volatile boolean xtG;
  private com.tencent.mm.plugin.sns.ui.d.b xta;
  private bh.a xuu;
  private LinkedList<cuo> xwA;
  private int xwB;
  private boolean xwC;
  private ay xwD;
  private String xwE;
  private com.tencent.mm.storage.bg xwF;
  private int xwG;
  private ImageView xwH;
  private j xwI;
  private l xwJ;
  private boolean xwK;
  private long xwL;
  private bl xwM;
  private boolean xwN;
  private int xwO;
  private int xwP;
  public int xwR;
  private com.tencent.mm.plugin.sns.ui.c.a.a xwS;
  com.tencent.mm.plugin.sns.a.b.i xwT;
  private SnsTranslateResultView xwU;
  private boolean xwV;
  private Dialog xwW;
  private boolean xwX;
  private boolean xwY;
  private String xwZ;
  private long xwm;
  private long xwn;
  private View xwo;
  private TextView xwp;
  private LinearLayout xwq;
  private SnsDetailLuckyHeader xwr;
  private ListView xws;
  private View xwt;
  private View xwu;
  private b xwv;
  private ScaleAnimation xww;
  private ScaleAnimation xwx;
  LinearLayout xwy;
  LinearLayout xwz;
  private boolean xxa;
  private int xxb;
  private boolean xxc;
  private int xxd;
  private boolean xxe;
  private boolean xxf;
  private n xxg;
  private TextView xxh;
  private ag xxi;
  private com.tencent.mm.sdk.b.c xxj;
  private com.tencent.mm.sdk.b.c xxk;
  private com.tencent.mm.sdk.b.c xxl;
  private com.tencent.mm.sdk.b.c xxm;
  private c xxp;
  private View.OnClickListener xxq;
  private com.tencent.mm.sdk.b.c xxr;
  private com.tencent.mm.sdk.b.c xxs;
  boolean xxt;
  private LinearLayout xxu;
  private boolean xxv;
  PhotosContent xxw;
  int xxx;
  public ar.b.a xxy;
  private bk xxz;
  
  static
  {
    AppMethodBeat.i(163117);
    xwQ = 34;
    e.a locala = new e.a();
    locala.gjE = true;
    locala.gjD = true;
    xxn = locala.ahr();
    qCy = new SnsCommentDetailUI.40();
    locala = new e.a();
    locala.gjE = true;
    locala.gjD = true;
    xxo = locala.ahr();
    AppMethodBeat.o(163117);
  }
  
  public SnsCommentDetailUI()
  {
    AppMethodBeat.i(98590);
    this.xwm = 0L;
    this.xwn = 0L;
    this.xwB = -1;
    this.xwC = false;
    this.xmL = bt.eGL();
    this.xlp = null;
    this.mBE = 0;
    this.xwG = 0;
    this.jWx = false;
    this.dqm = "";
    this.xwK = false;
    this.xwL = 0L;
    this.xwN = false;
    this.xwP = 103;
    this.xwR = 210;
    this.xwV = false;
    this.xwW = null;
    this.xwX = false;
    this.xwY = false;
    this.xwZ = "";
    this.xxa = true;
    this.xxc = false;
    this.xxd = 0;
    this.xxe = false;
    this.xxf = false;
    this.xxg = null;
    this.xxh = null;
    this.xtG = false;
    this.xxi = new ag();
    this.xxj = new com.tencent.mm.sdk.b.c() {};
    this.xxk = new com.tencent.mm.sdk.b.c() {};
    this.xxl = new com.tencent.mm.sdk.b.c() {};
    this.xxm = new com.tencent.mm.sdk.b.c() {};
    this.xlr = new com.tencent.mm.sdk.b.c() {};
    this.xxp = new c();
    this.mXa = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(98579);
        paramAnonymousView = (String)paramAnonymousView.getTag();
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsCommentDetailUI", "onCommentClick:".concat(String.valueOf(paramAnonymousView)));
        com.tencent.mm.plugin.sns.storage.p localp = SnsCommentDetailUI.e(SnsCommentDetailUI.this);
        if ((localp != null) && (localp.Nb(32)))
        {
          localObject = new SnsAdClick(SnsCommentDetailUI.this.getSource(), 2, localp.field_snsId, 1, 0);
          com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject, SnsCommentDetailUI.f(SnsCommentDetailUI.this), localp, 1);
          com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject);
          if ((paramAnonymousView != null) && (paramAnonymousView.equals(localp.field_userName)))
          {
            com.tencent.mm.plugin.sns.storage.b localb = localp.dxs();
            if ((localb != null) && (localb.wSV == 1) && (!bt.isNullOrNil(localb.wSW)))
            {
              localObject = localb.wSW;
              com.tencent.mm.plugin.sns.storage.a locala = SnsCommentDetailUI.a(SnsCommentDetailUI.this, localp);
              paramAnonymousView = (View)localObject;
              if (locala != null) {
                paramAnonymousView = com.tencent.mm.plugin.sns.data.q.iy((String)localObject, locala.dvK);
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "headClickParam url " + paramAnonymousView + " " + localb.wSX);
              localObject = new Intent();
              if (localb.wSX == 0) {
                bool = true;
              }
              ((Intent)localObject).putExtra("KsnsViewId", SnsCommentDetailUI.a(SnsCommentDetailUI.this, localp).dAM);
              ((Intent)localObject).putExtra("KRightBtn", bool);
              ((Intent)localObject).putExtra("jsapiargs", new Bundle());
              ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
              ((Intent)localObject).putExtra("useJs", true);
              com.tencent.mm.plugin.sns.d.a.hYt.i((Intent)localObject, SnsCommentDetailUI.this);
              AppMethodBeat.o(98579);
              return;
            }
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
          ((Intent)localObject).putExtra("Contact_Scene", 37);
          com.tencent.mm.plugin.sns.d.a.hYt.c((Intent)localObject, SnsCommentDetailUI.this);
          AppMethodBeat.o(98579);
          return;
        }
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
        com.tencent.mm.plugin.sns.d.a.hYt.c((Intent)localObject, SnsCommentDetailUI.this);
        AppMethodBeat.o(98579);
      }
    };
    this.xxq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163116);
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
        SnsCommentDetailUI.g(SnsCommentDetailUI.this);
        if (!SnsCommentDetailUI.h(SnsCommentDetailUI.this))
        {
          AppMethodBeat.o(163116);
          return;
        }
        SnsCommentDetailUI.i(SnsCommentDetailUI.this);
        AppMethodBeat.o(163116);
      }
    };
    this.olC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163081);
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
        SnsCommentDetailUI.a(SnsCommentDetailUI.this, paramAnonymousView);
        AppMethodBeat.o(163081);
      }
    };
    this.xxr = new SnsCommentDetailUI.8(this);
    this.jBI = new com.tencent.mm.sdk.b.c() {};
    this.xxs = new SnsCommentDetailUI.10(this);
    this.xuu = new bh.a()
    {
      public final void P(String paramAnonymousString, long paramAnonymousLong)
      {
        AppMethodBeat.i(187665);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onScreenShot， path = " + paramAnonymousString + "， dateAdded = " + paramAnonymousLong);
        SnsCommentDetailUI.v(SnsCommentDetailUI.this);
        AppMethodBeat.o(187665);
      }
    };
    this.xxt = false;
    this.xxu = null;
    this.xxv = false;
    this.xxw = null;
    this.xxx = 0;
    this.xxy = new ar.b.a()
    {
      public final void p(final String paramAnonymousString, final boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(187677);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "setAvatar, getContactCallBack, userName=" + paramAnonymousString + ", succ=" + paramAnonymousBoolean + ", retryCount=" + SnsCommentDetailUI.this.xxx);
        new com.tencent.mm.sdk.platformtools.ap(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187676);
            if ((paramAnonymousBoolean) && (!SnsCommentDetailUI.this.isFinishing()) && (SnsCommentDetailUI.this.xxx < 5))
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "setAvatar, setHeader after getContact, userName=" + paramAnonymousString);
              SnsCommentDetailUI.this.dAW();
            }
            SnsCommentDetailUI localSnsCommentDetailUI = SnsCommentDetailUI.this;
            localSnsCommentDetailUI.xxx += 1;
            AppMethodBeat.o(187676);
          }
        }, 500L);
        AppMethodBeat.o(187677);
      }
    };
    this.xxz = null;
    AppMethodBeat.o(98590);
  }
  
  private LinearLayout Nr(int paramInt)
  {
    AppMethodBeat.i(98601);
    if (this.xxu == null)
    {
      this.xxu = ((LinearLayout)y.js(this).inflate(paramInt, null));
      localLinearLayout = this.xxu;
      AppMethodBeat.o(98601);
      return localLinearLayout;
    }
    this.xxt = true;
    LinearLayout localLinearLayout = this.xxu;
    AppMethodBeat.o(98601);
    return localLinearLayout;
  }
  
  private void b(com.tencent.mm.plugin.sns.storage.p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(98603);
    if (this.xxh == null)
    {
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
      this.xxh = new TextView(this);
      this.xxh.setLayoutParams(localLayoutParams);
      this.xxh.setText(getString(2131763801));
      this.xxh.setTextColor(getResources().getColor(2131100711));
      this.xxh.setGravity(17);
      this.xxh.setPadding(0, BackwardSupportUtil.b.g(this, 7.0F), 0, BackwardSupportUtil.b.g(this, 12.0F));
      this.xxh.setVisibility(8);
      this.xws.addFooterView(this.xxh);
    }
    if (paramp != null)
    {
      if ((paramp.field_localPrivate & 0x1) != 0)
      {
        findViewById(2131298521).setVisibility(8);
        paramp = paramp.dxy();
        if (paramp != null) {
          switch (paramp.Etm.DaB)
          {
          }
        }
        for (;;)
        {
          this.xxh.setVisibility(0);
          AppMethodBeat.o(98603);
          return;
          this.xxh.setText(getString(2131763802));
          continue;
          this.xxh.setText(getString(2131763805));
          continue;
          this.xxh.setText(getString(2131763803));
        }
      }
      if (paramBoolean) {
        findViewById(2131298521).setVisibility(0);
      }
      this.xxh.setVisibility(8);
    }
    AppMethodBeat.o(98603);
  }
  
  private int dAU()
  {
    AppMethodBeat.i(98600);
    if ((this.xws != null) && (this.xws.getChildCount() > 1))
    {
      View localView = this.xws.getChildAt(0);
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
  
  private static boolean dAV()
  {
    AppMethodBeat.i(98602);
    if ((am.a.dtY() & 0x1) <= 0)
    {
      AppMethodBeat.o(98602);
      return true;
    }
    AppMethodBeat.o(98602);
    return false;
  }
  
  private void dAX()
  {
    AppMethodBeat.i(98605);
    if ((this.xwt == null) || (this.xwt.getVisibility() == 8))
    {
      AppMethodBeat.o(98605);
      return;
    }
    this.xwt.startAnimation(this.xwx);
    this.xwx.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(163114);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsCommentDetailUI", "onAnimationEnd");
        if (SnsCommentDetailUI.H(SnsCommentDetailUI.this) != null)
        {
          SnsCommentDetailUI.H(SnsCommentDetailUI.this).clearAnimation();
          SnsCommentDetailUI.H(SnsCommentDetailUI.this).setVisibility(8);
        }
        AppMethodBeat.o(163114);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    AppMethodBeat.o(98605);
  }
  
  private void dAY()
  {
    AppMethodBeat.i(98606);
    if ((keyboardState() == 1) || (this.xlc.dBc()))
    {
      this.xxp.run();
      AppMethodBeat.o(98606);
      return;
    }
    this.xkZ = true;
    AppMethodBeat.o(98606);
  }
  
  private void dAZ()
  {
    AppMethodBeat.i(98607);
    if (this.xwH == null)
    {
      AppMethodBeat.o(98607);
      return;
    }
    this.xwH.setPressed(false);
    if (bl.amF(this.dqm))
    {
      this.xwH.setImageResource(2131233393);
      AppMethodBeat.o(98607);
      return;
    }
    this.xwH.setImageResource(2131233395);
    AppMethodBeat.o(98607);
  }
  
  private com.tencent.mm.plugin.sns.storage.a f(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(98594);
    if (paramp != null)
    {
      if (getSource() == 2)
      {
        paramp = paramp.dxv();
        AppMethodBeat.o(98594);
        return paramp;
      }
      paramp = paramp.dxu();
      AppMethodBeat.o(98594);
      return paramp;
    }
    AppMethodBeat.o(98594);
    return null;
  }
  
  private static boolean f(LinkedList<cuo> paramLinkedList1, LinkedList<cuo> paramLinkedList2)
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
      if (!((cuo)paramLinkedList1.get(i)).Username.equals(((cuo)paramLinkedList2.get(i)).Username))
      {
        AppMethodBeat.o(98591);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(98591);
    return true;
  }
  
  private boolean h(List<cuo> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(98608);
    int k = BackwardSupportUtil.b.g(this, 32.0F);
    int m = BackwardSupportUtil.b.g(this, 6.0F);
    int i = BackwardSupportUtil.b.g(this, 10.0F);
    int j = BackwardSupportUtil.b.g(this, 17.0F);
    if (this.xwq == null)
    {
      AppMethodBeat.o(98608);
      return false;
    }
    int n = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    float f = getResources().getDimension(2131165516);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsCommentDetailUI", "guess size %d %f", new Object[] { Integer.valueOf(n), Float.valueOf(f) });
    f = n - f * 2.0F;
    if (paramList.size() <= 0)
    {
      if (this.xwq.getParent() != null) {
        this.xwq.setVisibility(8);
      }
      this.xwq.removeAllViews();
      this.xwq.setVisibility(8);
      this.wCT.setVisibility(8);
      AppMethodBeat.o(98608);
      return false;
    }
    this.xwq.getParent();
    this.xwq.removeAllViews();
    this.xwq.setVisibility(0);
    Object localObject1;
    if (this.nBH == 10) {
      if (!this.xwV)
      {
        this.xwq.setBackgroundResource(2131232445);
        this.xwq.setPadding(0, m, 0, m);
        localObject1 = new ImageView(getContext());
        if (this.nBH != 10) {
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
      this.xwq.addView((View)localObject1);
      n = com.tencent.mm.cd.a.fromDPToPix(getContext(), xwQ);
      j = (int)(f - n) / (m + k);
      i = j;
      if ((int)(f - n) % (m + k) > k) {
        i = j + 1;
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsCommentDetailUI", "guess size %d", new Object[] { Integer.valueOf(i) });
      localObject1 = new h(getContext());
      ((h)localObject1).setClipChildren(false);
      ((h)localObject1).setClipToPadding(false);
      ((h)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((h)localObject1).setLineMaxCounte(i);
      i = 0;
      while (i < paramList.size())
      {
        localObject2 = (cuo)paramList.get(i);
        StoryTouchImageView localStoryTouchImageView = new StoryTouchImageView(getContext());
        localStoryTouchImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localStoryTouchImageView.setImageResource(2131232455);
        Object localObject3 = ((cuo)localObject2).Username;
        localStoryTouchImageView.xLj.eE((String)localObject3, 1);
        localObject3 = new LinearLayout.LayoutParams(k, k);
        ((LinearLayout.LayoutParams)localObject3).setMargins(0, m, m, 0);
        localStoryTouchImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localStoryTouchImageView.setTag(((cuo)localObject2).Username);
        a.b.w(localStoryTouchImageView, ((cuo)localObject2).Username);
        localStoryTouchImageView.setOnClickListener(this.mXa);
        ((h)localObject1).addView(localStoryTouchImageView);
        i += 1;
      }
      localObject1 = qm(false);
      if (localObject1 != null)
      {
        if (this.fki.equals(((com.tencent.mm.plugin.sns.storage.p)localObject1).field_userName))
        {
          this.xwq.setBackgroundResource(2131232446);
          break;
        }
        this.xwq.setBackgroundResource(2131232445);
        break;
      }
      this.xwq.setBackgroundResource(2131232445);
      break;
      this.xwq.setBackgroundResource(2131232453);
      break;
      label692:
      ((ImageView)localObject1).setImageDrawable(am.i(getContext(), 2131690247, getContext().getResources().getColor(2131099769)));
    }
    this.xwq.addView((View)localObject1);
    paramList = this.wCT;
    if (paramBoolean) {}
    for (i = 8;; i = 0)
    {
      paramList.setVisibility(i);
      AppMethodBeat.o(98608);
      return true;
    }
  }
  
  private void ql(boolean paramBoolean)
  {
    AppMethodBeat.i(98592);
    this.xwC = false;
    if (this.xlc.dBb())
    {
      this.xlc.xyh = 0;
      this.xlc.dBe();
      this.xlc.setCommentHint(getString(2131764046));
    }
    this.xlc.qn(false);
    if (paramBoolean)
    {
      Object localObject1 = this.xws;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "scrollDown", "(Z)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
      BackwardSupportUtil.c.b((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "scrollDown", "(Z)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    }
    AppMethodBeat.o(98592);
  }
  
  private com.tencent.mm.plugin.sns.storage.p qm(boolean paramBoolean)
  {
    AppMethodBeat.i(98593);
    com.tencent.mm.plugin.sns.storage.p localp;
    if (!bt.isNullOrNil(this.xwE))
    {
      localp = com.tencent.mm.plugin.sns.storage.h.apK(this.xwE);
      if (localp == null)
      {
        if (paramBoolean) {
          Toast.makeText(this, 2131763915, 0).show();
        }
        finish();
        AppMethodBeat.o(98593);
        return null;
      }
      this.dpC = localp.getSnsId();
    }
    for (;;)
    {
      AppMethodBeat.o(98593);
      return localp;
      localp = com.tencent.mm.plugin.sns.storage.h.apJ(this.dpC);
      if (localp == null)
      {
        finish();
        AppMethodBeat.o(98593);
        return null;
      }
      this.xwE = localp.dxX();
    }
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.c.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.c.b paramb) {}
  
  public final void aob(String paramString) {}
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.c.b paramb) {}
  
  public final void by(String paramString, boolean paramBoolean) {}
  
  public final void bz(String paramString, boolean paramBoolean) {}
  
  final boolean dAW()
  {
    AppMethodBeat.i(98604);
    final com.tencent.mm.plugin.sns.storage.p localp = qm(true);
    if (localp == null)
    {
      AppMethodBeat.o(98604);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "setheader " + this.xwo.toString());
    this.xwO = com.tencent.mm.plugin.sns.model.af.dtE();
    Object localObject6 = localp.dxy();
    this.nBH = be.c(localp, false);
    Object localObject1 = (SnsAvatarImageView)this.xwo.findViewById(2131296533);
    Object localObject5 = (RelativeLayout)this.xwo.findViewById(2131303033);
    ((RelativeLayout)localObject5).setVisibility(8);
    ((RelativeLayout)localObject5).setOnClickListener(this.xta.xTV);
    Object localObject2;
    boolean bool;
    if ((localObject1 == null) || (localp == null))
    {
      localObject2 = new StringBuilder("unknow error ? ");
      if (localObject1 == null)
      {
        bool = true;
        localObject1 = ((StringBuilder)localObject2).append(bool).append(" ");
        if (localp != null) {
          break label211;
        }
      }
      label211:
      for (bool = true;; bool = false)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCommentDetailUI", bool);
        AppMethodBeat.o(98604);
        return false;
        bool = false;
        break;
      }
    }
    ((SnsAvatarImageView)localObject1).setWeakContext(this);
    ((MaskImageButton)localObject1).glT = localp.dxX();
    ((SnsAvatarImageView)localObject1).setTag(localp.getUserName());
    label338:
    Object localObject7;
    int j;
    if ((localp.dxs() != null) && (localp.dxs().wTG))
    {
      if (!bt.isNullOrNil(localp.dxs().wTI))
      {
        localObject2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.iU("adId", localp.dxs().wTI);
        ((SnsAvatarImageView)localObject1).setTag(2131305044, localp.dxs().wTI);
        if (!com.tencent.mm.vfs.i.eK((String)localObject2)) {
          break label1290;
        }
        localObject2 = com.tencent.mm.plugin.sns.a.b.l.wyR.getBitmap((String)localObject2);
        if (localObject2 != null) {
          ((SnsAvatarImageView)localObject1).setImageBitmap((Bitmap)localObject2);
        }
      }
      ((SnsAvatarImageView)localObject1).setOnClickListener(this.xta.xTu);
      localObject2 = (TextView)this.xwo.findViewById(2131302867);
      com.tencent.mm.kernel.g.afC();
      localObject7 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(localp.getUserName());
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "snsinfo username " + localp.getUserName() + " " + localp.getSnsId() + " " + localp.getCreateTime());
      if ((localObject7 != null) && (((com.tencent.mm.storage.af)localObject7).ZV() == 0))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "getContact %s", new Object[] { localp.getUserName() });
        ar.a.arF().a(localp.getUserName(), "", this.xxy);
      }
      j = 0;
      if (localObject7 != null) {
        break label1518;
      }
    }
    Object localObject4;
    int i;
    int k;
    label585:
    label846:
    label1106:
    label1518:
    for (localObject1 = localp.getUserName();; localObject1 = ((com.tencent.mm.storage.af)localObject7).ZX())
    {
      localObject1 = bt.by((String)localObject1, "");
      if (!localp.tQ()) {
        break label1564;
      }
      localObject4 = localp.dxs();
      if (localObject4 == null) {
        break label10739;
      }
      if (!((com.tencent.mm.plugin.sns.storage.b)localObject4).wTG) {
        break label1528;
      }
      localObject4 = ((com.tencent.mm.plugin.sns.storage.b)localObject4).wTH;
      i = 0;
      ((String)localObject4).length();
      if (this.nBH != 10) {
        break label1690;
      }
      k = 3;
      localObject1 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject4));
      ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).b(new com.tencent.mm.pluginsdk.ui.span.p(new com.tencent.mm.plugin.sns.data.a(localp.tQ(), ((com.tencent.mm.storage.af)localObject7).getUsername(), localp.dxX(), 2), this.xwI, k), (CharSequence)localObject4);
      if ((j >= 0) && (i > j)) {
        ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).setSpan(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).f(this, ((com.tencent.mm.storage.af)localObject7).Sz(), this.xxd), j, i, 33);
      }
      ((TextView)localObject2).setOnTouchListener(new ad());
      ((TextView)localObject2).setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      ((TextView)this.xwo.findViewById(2131306175)).setText("");
      this.xxz = new bk(this.xwo);
      if (!localp.tQ()) {
        break label1696;
      }
      this.xxz.F(Long.valueOf(localp.field_snsId), new com.tencent.mm.plugin.sns.data.b(this.xxz, 0, this.xwE, localp.field_snsId, f(localp).dAM));
      this.xxz.a(localp.dxs(), f(localp));
      this.xxz.a(this.xta.xTE, this.xta.xTS);
      this.xxz.setVisibility(0);
      localObject1 = ((TimeLineObject)localObject6).Etj;
      this.xwp = ((TextView)this.xwo.findViewById(2131299008));
      localObject2 = new ba(this.dpC, localp.dxX(), true, false, 2);
      this.xwp.setTag(localObject2);
      this.mVN.c(this.xwp, this.xta.xTw, this.xta.xTt);
      if (!bt.isNullOrNil((String)localObject1)) {
        break label1708;
      }
      this.xwp.setVisibility(8);
      localObject1 = (ViewStub)this.xwo.findViewById(2131300969);
      if (!this.xxv) {
        ((ViewStub)localObject1).setLayoutResource(-1);
      }
      switch (this.nBH)
      {
      case 6: 
      case 7: 
      case 8: 
      case 12: 
      default: 
        ((ViewStub)localObject1).setVisibility(8);
        if (((ViewStub)localObject1).getLayoutResource() == -1) {
          break label1964;
        }
        localObject2 = ((ViewStub)localObject1).inflate();
        if (this.xwS != null)
        {
          this.xwS.jGG = findViewById(2131305824);
          this.xwS.k((View)localObject2, this.xwu);
        }
        this.xxv = true;
        k = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        if (this.nBH == 6) {
          break label2401;
        }
        if ((this.nBH != 2) && (this.nBH != 3) && (this.nBH != 4) && (this.nBH != 5)) {
          break label3994;
        }
        this.xxw = ((PhotosContent)findViewById(2131303243));
        if (this.xxw == null) {
          break label3951;
        }
        this.xxw.dzX();
        if (this.nBH != 2) {
          break label1974;
        }
        i = 1;
        j = 0;
        while (j < i)
        {
          localObject1 = (TagImageView)this.xxw.findViewById(ay.xBN[j]);
          this.xxw.a((TagImageView)localObject1);
          ((TagImageView)localObject1).setOnClickListener(this.xta.xno);
          this.mVN.c((View)localObject1, this.xta.xTH, this.xta.xTt);
          j += 1;
        }
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localp.dxs().wTI, new f.a()
        {
          public final void apm(String paramAnonymousString)
          {
            AppMethodBeat.i(163106);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "download img %s", new Object[] { paramAnonymousString });
            String str = (String)this.xxH.getTag(2131305044);
            if ((!bt.T(new String[] { str, paramAnonymousString })) && (paramAnonymousString.equals(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.iU("adId", str))))
            {
              paramAnonymousString = com.tencent.mm.plugin.sns.a.b.l.wyR.getBitmap(paramAnonymousString);
              if (paramAnonymousString != null) {
                this.xxH.setImageBitmap(paramAnonymousString);
              }
            }
            AppMethodBeat.o(163106);
          }
          
          public final void dsA()
          {
            AppMethodBeat.i(187678);
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCommentDetailUI", "onDownloadError");
            AppMethodBeat.o(187678);
          }
          
          public final void duP() {}
        });
        break label338;
        if (localp.getUserName().endsWith("@ad")) {
          break label338;
        }
        if (localp.tQ()) {}
        for (;;)
        {
          try
          {
            com.tencent.mm.kernel.g.afC();
            localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(localp.getUserName());
            if ((localObject2 == null) || (((com.tencent.mm.storage.af)localObject2).ZV() == 0)) {
              continue;
            }
            a.b.w((ImageView)localObject1, localp.getUserName());
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "has contact before setAvatar, userName=" + localp.getUserName());
          }
          catch (Exception localException)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCommentDetailUI", "setAvatar exp=" + localException.toString());
            continue;
          }
          ((SnsAvatarImageView)localObject1).eE(localp.getUserName(), 2);
          bt.kU(this.fki, localp.getUserName());
          break;
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCommentDetailUI", "has no contact before setAvatar, userName=" + localp.getUserName());
          continue;
          a.b.w((ImageView)localObject1, localp.getUserName());
        }
      }
    }
    label942:
    label1209:
    label1528:
    if ((bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject4).nickname))) {
      localObject1 = ((com.tencent.mm.plugin.sns.storage.b)localObject4).nickname;
    }
    label1051:
    label1564:
    label1696:
    label1708:
    label1964:
    label1974:
    label2401:
    label2530:
    label3951:
    label9457:
    label10225:
    label10739:
    for (;;)
    {
      i = 0;
      localObject4 = localObject1;
      break;
      if ((localObject7 != null) && (com.tencent.mm.storage.af.aHH(((com.tencent.mm.storage.af)localObject7).getUsername())) && ("3552365301".equals(((com.tencent.mm.storage.af)localObject7).Sz())))
      {
        j = ((String)localObject1).length();
        localObject4 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bt(((com.tencent.mm.storage.af)localObject7).Sz(), ((com.tencent.mm.storage.af)localObject7).Sy());
        localObject4 = (String)localObject1 + " @" + (String)localObject4;
        i = ((String)localObject4).length();
        ((RelativeLayout)localObject5).setTag(new com.tencent.mm.plugin.sns.data.e((View)localObject5, localp.dxX()));
        ((RelativeLayout)localObject5).setVisibility(0);
        break;
        k = 2;
        break label585;
        this.xxz.setVisibility(8);
        break label846;
        this.xwp.setText((String)localObject1 + " ");
        com.tencent.mm.pluginsdk.ui.span.k.m(this.xwp, 2);
        this.xwp.setVisibility(0);
        com.tencent.mm.plugin.sns.k.f.wQY.duX().QC();
        break label942;
        ((ViewStub)localObject1).setLayoutResource(2131495611);
        break label1051;
        ((ViewStub)localObject1).setLayoutResource(2131495608);
        break label1051;
        ((ViewStub)localObject1).setLayoutResource(2131495609);
        break label1051;
        ((ViewStub)localObject1).setLayoutResource(2131495610);
        break label1051;
        ((ViewStub)localObject1).setLayoutResource(2131495566);
        break label1051;
        ((ViewStub)localObject1).setLayoutResource(2131495550);
        break label1051;
        ((ViewStub)localObject1).setLayoutResource(2131495488);
        this.xwS = new com.tencent.mm.plugin.sns.ui.c.a.b((TimeLineObject)localObject6, localp, this.xta, this.xwT);
        break label1051;
        ((ViewStub)localObject1).setLayoutResource(2131495614);
        this.xwS = new com.tencent.mm.plugin.sns.ui.c.a.e((TimeLineObject)localObject6, localp, this.xta, this.xwT);
        break label1051;
        ((ViewStub)localObject1).setLayoutResource(2131495603);
        this.xwS = new com.tencent.mm.plugin.sns.ui.c.a.c((TimeLineObject)localObject6, localp, this.xta, this.xwT);
        break label1051;
        ((ViewStub)localObject1).setLayoutResource(2131495604);
        this.xwS = new com.tencent.mm.plugin.sns.ui.c.a.d((TimeLineObject)localObject6, localp, this.xta);
        break label1051;
        ((ViewStub)localObject1).setVisibility(8);
        break label1106;
        i = ay.xBJ[this.nBH];
        break label1209;
        this.xxw.setImageViewWidth(this.xwO);
        localObject1 = new LinkedList();
        Object localObject3;
        float f2;
        float f1;
        Object localObject8;
        if ((localp.tQ()) && (this.nBH == 2))
        {
          localObject3 = localp.dxs();
          this.xxw.No(0).setScaleType(QImageView.a.HBy);
          if ((localObject3 != null) && (!((com.tencent.mm.plugin.sns.storage.b)localObject3).dvm()) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).wTm > 0.0F) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).wTn > 0.0F))
          {
            f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).wTm, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTo, ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTp);
            f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).wTn, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTo, ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTp);
            if (((com.tencent.mm.plugin.sns.storage.b)localObject3).wTl != 0) {
              break label3665;
            }
            float f3 = f1;
            f1 = f2;
            if (f2 >= k - com.tencent.mm.cd.a.ao(this, 2131166827) - com.tencent.mm.cd.a.ao(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516))
            {
              f1 = k - com.tencent.mm.cd.a.ao(this, 2131166827) - com.tencent.mm.cd.a.ao(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
              f3 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject3).wTn * f1 / ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTm);
            }
            localObject5 = new bpk();
            ((bpk)localObject5).DNH = f1;
            ((bpk)localObject5).DNI = f3;
            ((bpk)localObject5).DNJ = (((bpk)localObject5).DNH * ((bpk)localObject5).DNI);
            ((LinkedList)localObject1).add(localObject5);
          }
          if (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject3).wTr))
          {
            localObject5 = this.xxw;
            localObject8 = this.xxw.No(0);
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTr, false, 41, new f.a()
            {
              public final void apm(String paramAnonymousString)
              {
                AppMethodBeat.i(187679);
                MaskImageView localMaskImageView = (MaskImageView)this.xxI.findViewById(2131302209);
                if (localMaskImageView != null)
                {
                  localMaskImageView.setVisibility(0);
                  localMaskImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.f.decodeFile(paramAnonymousString));
                  float f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.xxJ.wTs, 1, this.xxJ.wTo, this.xxJ.wTp);
                  float f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.xxJ.wTt, 1, this.xxJ.wTo, this.xxJ.wTp);
                  float f3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.xxJ.wTu, 1, this.xxJ.wTo, this.xxJ.wTp);
                  float f4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.xxJ.wTv, 1, this.xxJ.wTo, this.xxJ.wTp);
                  paramAnonymousString = new FrameLayout.LayoutParams((int)f1, (int)f2);
                  paramAnonymousString.setMargins((int)(this.xxK.getRight() - f3 - f1), (int)(this.xxK.getBottom() - f4 - f2), 0, 0);
                  localMaskImageView.setLayoutParams(paramAnonymousString);
                }
                AppMethodBeat.o(187679);
              }
              
              public final void dsA() {}
              
              public final void duP() {}
            });
          }
        }
        this.xwo.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
        {
          boolean xxL = false;
          
          public final void onViewAttachedToWindow(View paramAnonymousView)
          {
            AppMethodBeat.i(187680);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "onViewAttachedToWindow infoHeader %s", new Object[] { Boolean.valueOf(this.xxL) });
            if (!this.xxL)
            {
              AppMethodBeat.o(187680);
              return;
            }
            this.xxL = false;
            if (this.xxM == null)
            {
              AppMethodBeat.o(187680);
              return;
            }
            if (localp == null)
            {
              AppMethodBeat.o(187680);
              return;
            }
            if (SnsCommentDetailUI.this.xxw == null)
            {
              AppMethodBeat.o(187680);
              return;
            }
            paramAnonymousView = SnsCommentDetailUI.G(SnsCommentDetailUI.this);
            PhotosContent localPhotosContent = SnsCommentDetailUI.this.xxw;
            TimeLineObject localTimeLineObject = this.xxM;
            String str = localp.dxX();
            SnsCommentDetailUI.E(SnsCommentDetailUI.this);
            paramAnonymousView.a(localPhotosContent, localTimeLineObject, str, SnsCommentDetailUI.this.hashCode(), SnsCommentDetailUI.F(SnsCommentDetailUI.this), -1, localp.Nb(32), false, bc.FzE, this.xxN, localp.getSnsId());
            AppMethodBeat.o(187680);
          }
          
          public final void onViewDetachedFromWindow(View paramAnonymousView)
          {
            AppMethodBeat.i(187681);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "onViewDetachedFromWindow infoHeader");
            this.xxL = true;
            AppMethodBeat.o(187681);
          }
        });
        this.xwD.a(this.xxw, (TimeLineObject)localObject6, localp.dxX(), hashCode(), this.nBH, -1, localp.Nb(32), false, bc.FzE, (List)localObject1, localp.getSnsId());
        for (;;)
        {
          localObject5 = (TextView)this.xwo.findViewById(2131296531);
          if (!localp.tQ()) {
            break label9373;
          }
          localObject3 = f(localp);
          if (localObject3 == null) {
            break label9363;
          }
          localObject1 = ((com.tencent.mm.plugin.sns.storage.a)localObject3).wSa;
          localObject3 = ((com.tencent.mm.plugin.sns.storage.a)localObject3).wSb;
          ((TextView)localObject5).setTag(localp.dxX());
          if (bt.isNullOrNil((String)localObject1)) {
            break label9363;
          }
          if (!bt.isNullOrNil((String)localObject3)) {
            break label9315;
          }
          ((TextView)localObject5).setVisibility(0);
          ((TextView)localObject5).setText((CharSequence)localObject1);
          ((TextView)localObject5).setClickable(false);
          ((TextView)localObject5).setTextColor(getContext().getResources().getColor(2131100212));
          this.xwo.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187684);
              SnsCommentDetailUI.f(SnsCommentDetailUI.this).pH(false);
              AppMethodBeat.o(187684);
            }
          });
          ((TextView)localObject5).setOnClickListener(this.xta.xTP);
          ((TextView)this.xwo.findViewById(2131296598)).setText(bg.p(getContext(), localp.getCreateTime() * 1000L));
          localObject5 = (AsyncTextView)this.xwo.findViewById(2131296528);
          ((TextView)localObject5).setOnClickListener(this.xta.xTT);
          ((TextView)localObject5).setVisibility(8);
          localObject8 = (AsyncTextView)this.xwo.findViewById(2131296527);
          ((TextView)localObject8).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(98570);
              paramAnonymousView = new SnsAdClick(SnsCommentDetailUI.this.getSource(), 2, localp.field_snsId, 24, 0);
              com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, SnsCommentDetailUI.f(SnsCommentDetailUI.this), localp, 24);
              com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
              String str = this.fvY.ZX();
              paramAnonymousView = str;
              if (localp.Nb(32)) {
                paramAnonymousView = com.tencent.mm.plugin.sns.ui.widget.e.a(localp.dxs(), str);
              }
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentFlag(1);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentHint(paramAnonymousView);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).qn(true);
              SnsCommentDetailUI.H(SnsCommentDetailUI.this).setVisibility(8);
              SnsCommentDetailUI.C(SnsCommentDetailUI.this);
              AppMethodBeat.o(98570);
            }
          });
          ((TextView)localObject8).setVisibility(8);
          if (localp.tQ())
          {
            localObject7 = f(localp);
            ((TextView)localObject5).setTag(localp.dxX());
            if (((com.tencent.mm.plugin.sns.storage.a)localObject7).wSc != com.tencent.mm.plugin.sns.storage.a.wRO) {
              break label9601;
            }
            if (bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject7).wSd)) {
              break label9591;
            }
            ((TextView)localObject5).setText(((com.tencent.mm.plugin.sns.storage.a)localObject7).wSd);
            ((TextView)localObject5).setVisibility(0);
            break label9889;
            if ((((TextView)localObject5).getVisibility() != 8) && (bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject7).wSe)))
            {
              ((TextView)localObject5).setTextColor(getResources().getColor(2131100943));
              ((TextView)localObject5).setOnClickListener(null);
            }
            if ((localp.dxy().Etm.DaD & 0x4) == 0) {
              break label10058;
            }
            ((TextView)localObject8).setTag(localp.dxX());
            ((TextView)localObject8).setVisibility(0);
            ((TextView)localObject8).setText(String.format("%s%s%s", new Object[] { getContext().getResources().getString(2131763743), localObject4, getContext().getResources().getString(2131763744) }));
          }
          localObject1 = (WeImageView)this.xwo.findViewById(2131296627);
          if (((TimeLineObject)localObject6).Etm.DaB != 30) {
            break label10068;
          }
          i = 0;
          ((WeImageView)localObject1).setVisibility(i);
          ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099660));
          localObject4 = (TextView)this.xwo.findViewById(2131296569);
          ((TextView)localObject4).setOnTouchListener(new ad());
          localObject1 = com.tencent.mm.plugin.sns.d.a.hYu.s(this, ((TimeLineObject)localObject6).Etl.Id);
          if (((TimeLineObject)localObject6).Etm.DaB != 26) {
            break label10075;
          }
          localObject1 = getString(2131758845);
          be.a((TimeLineObject)localObject6, this);
          if (!com.tencent.mm.plugin.sns.d.a.hYu.eM((String)localObject1)) {
            break label10188;
          }
          ((TextView)localObject4).setVisibility(0);
          localObject1 = new SpannableString(getString(2131763791) + (String)localObject1);
          ((SpannableString)localObject1).setSpan(new a(), 0, ((SpannableString)localObject1).length(), 33);
          ((TextView)localObject4).setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
          if ((((TimeLineObject)localObject6).Etl == null) || (!com.tencent.mm.pluginsdk.model.app.h.aAN(((TimeLineObject)localObject6).Etl.Id)))
          {
            ((TextView)localObject4).setTextColor(getResources().getColor(2131100943));
            ((TextView)localObject4).setOnTouchListener(null);
          }
          ((TextView)localObject4).setTag(localObject6);
          localObject1 = (TextView)this.xwo.findViewById(2131296566);
          if (!localp.getUserName().equals(this.fki)) {
            break label10198;
          }
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setTag(localp.dxX() + ";" + localp.getSnsId());
          ((TextView)localObject1).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(98571);
              com.tencent.mm.ui.base.h.a(SnsCommentDetailUI.this, 2131764024, 2131755906, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(187685);
                  com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsCommentDetailUI", "to del by localId " + SnsCommentDetailUI.k(SnsCommentDetailUI.this));
                  paramAnonymous2DialogInterface = com.tencent.mm.plugin.sns.storage.h.apK(SnsCommentDetailUI.k(SnsCommentDetailUI.this));
                  if (paramAnonymous2DialogInterface == null)
                  {
                    com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCommentDetailUI", "try to del item fail can not get snsinfo by localid %s", new Object[] { SnsCommentDetailUI.k(SnsCommentDetailUI.this) });
                    AppMethodBeat.o(187685);
                    return;
                  }
                  if (paramAnonymous2DialogInterface.Nb(32))
                  {
                    AppMethodBeat.o(187685);
                    return;
                  }
                  Object localObject;
                  if (paramAnonymous2DialogInterface.field_snsId == 0L)
                  {
                    com.tencent.mm.plugin.sns.model.af.dtu().Nf(paramAnonymous2DialogInterface.xiB);
                    localObject = new Intent();
                    ((Intent)localObject).putExtra("sns_gallery_op_id", x.aqg(SnsCommentDetailUI.k(SnsCommentDetailUI.this)));
                    SnsCommentDetailUI.this.setResult(-1, (Intent)localObject);
                    if ((SnsCommentDetailUI.w(SnsCommentDetailUI.this)) && (!paramAnonymous2DialogInterface.isValid())) {
                      ((Intent)localObject).putExtra("sns_gallery_force_finish", true);
                    }
                    localObject = paramAnonymous2DialogInterface.dxy();
                    if (localObject != null) {
                      if (((TimeLineObject)localObject).Etl != null) {
                        break label368;
                      }
                    }
                  }
                  label368:
                  for (paramAnonymous2DialogInterface = null;; paramAnonymous2DialogInterface = ((TimeLineObject)localObject).Etl.Id)
                  {
                    if ((!bt.isNullOrNil(paramAnonymous2DialogInterface)) && (com.tencent.mm.plugin.sns.d.a.hYu.eN(paramAnonymous2DialogInterface)))
                    {
                      String str = com.tencent.mm.plugin.sns.d.a.hYu.eL(paramAnonymous2DialogInterface);
                      qh localqh = new qh();
                      localqh.dvO.appId = paramAnonymous2DialogInterface;
                      localqh.dvO.dvQ = ((TimeLineObject)localObject).mAQ;
                      localqh.dvO.dvP = str;
                      com.tencent.mm.sdk.b.a.ESL.l(localqh);
                    }
                    SnsCommentDetailUI.this.finish();
                    AppMethodBeat.o(187685);
                    return;
                    com.tencent.mm.plugin.sns.model.af.dtt().sL(paramAnonymous2DialogInterface.field_snsId);
                    com.tencent.mm.kernel.g.afC();
                    com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.plugin.sns.model.q(paramAnonymous2DialogInterface.field_snsId, 1), 0);
                    com.tencent.mm.plugin.sns.model.af.dtu().delete(paramAnonymous2DialogInterface.field_snsId);
                    com.tencent.mm.plugin.sns.model.af.dtz().tc(paramAnonymous2DialogInterface.field_snsId);
                    com.tencent.mm.plugin.sns.storage.i.tb(paramAnonymous2DialogInterface.field_snsId);
                    break;
                  }
                }
              }, null);
              AppMethodBeat.o(98571);
            }
          });
          label3199:
          localObject4 = (TextView)this.xwo.findViewById(2131306999);
          localObject5 = com.tencent.mm.plugin.sns.model.aj.s(localp);
          if (localObject5 != null) {
            break label10208;
          }
          ((TextView)localObject4).setVisibility(8);
          this.xww = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
          this.xww.setDuration(150L);
          this.xwx = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
          this.xwx.setDuration(150L);
          if (this.xwt == null)
          {
            this.xwt = this.xwo.findViewById(2131296548);
            this.xwt.setVisibility(8);
          }
          this.xwy = ((LinearLayout)this.xwo.findViewById(2131296555));
          this.xwy.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(98573);
              if (!com.tencent.mm.plugin.sns.lucky.a.m.aoc(localp.dxX()))
              {
                com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.xxw.No(0));
                AppMethodBeat.o(98573);
                return;
              }
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentInfo(null);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentFlag(0);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentHint(SnsCommentDetailUI.this.getString(2131764046));
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentInfo(new cuo());
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setToSendTextColor(true);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).qn(true);
              if ((localp.Nb(32)) && ((localp.dxy().Etm.DaD & 0x8) != 0)) {
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).qo(true);
              }
              for (;;)
              {
                SnsCommentDetailUI.H(SnsCommentDetailUI.this).setVisibility(8);
                SnsCommentDetailUI.C(SnsCommentDetailUI.this);
                AppMethodBeat.o(98573);
                return;
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).qo(false);
              }
            }
          });
          this.xwy.setOnTouchListener(this.xmL);
          this.xwz = ((LinearLayout)this.xwo.findViewById(2131296586));
          this.xwz.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(163113);
              if ((SnsCommentDetailUI.f(SnsCommentDetailUI.this) != null) && (localp.field_likeFlag == 0)) {
                SnsCommentDetailUI.f(SnsCommentDetailUI.this).sk(localp.field_snsId);
              }
              SnsCommentDetailUI localSnsCommentDetailUI = SnsCommentDetailUI.this;
              paramAnonymousView = (LinearLayout)paramAnonymousView;
              ImageView localImageView = (ImageView)paramAnonymousView.findViewById(2131296585);
              ScaleAnimation localScaleAnimation = new ScaleAnimation(0.9F, 1.5F, 0.9F, 1.5F, 1, 0.5F, 1, 0.5F);
              localScaleAnimation.setDuration(400L);
              localScaleAnimation.setStartOffset(100L);
              localScaleAnimation.setRepeatCount(0);
              localImageView.clearAnimation();
              localImageView.startAnimation(localScaleAnimation);
              localScaleAnimation.setAnimationListener(new SnsCommentDetailUI.38(localSnsCommentDetailUI, paramAnonymousView));
              SnsCommentDetailUI.I(SnsCommentDetailUI.this);
              com.tencent.mm.plugin.sns.k.f.wQY.duX().dRv = 3L;
              AppMethodBeat.o(163113);
            }
          });
          this.xwz.setOnTouchListener(this.xmL);
          localObject1 = (ImageButton)this.xwo.findViewById(2131296599);
          localObject3 = qm(true);
          if ((localObject3 != null) && ((((com.tencent.mm.plugin.sns.storage.p)localObject3).dxS() & 0x1) != 0)) {
            ((ImageButton)localObject1).setVisibility(8);
          }
          if ((localObject3 != null) && (!((com.tencent.mm.plugin.sns.storage.p)localObject3).dxW())) {
            ((ImageButton)localObject1).setVisibility(8);
          }
          localObject3 = (ImageView)this.xwz.findViewById(2131296585);
          localObject4 = (ImageView)this.xwy.findViewById(2131296554);
          localObject5 = (TextView)this.xwz.findViewById(2131296587);
          localObject6 = (TextView)this.xwy.findViewById(2131296563);
          if (this.nBH == 10)
          {
            this.xwo.findViewById(2131296548).setBackgroundResource(2131232447);
            ((ImageButton)localObject1).setImageResource(2131232932);
            ((ImageView)localObject3).setImageResource(2131232933);
            ((ImageView)localObject4).setImageResource(2131232934);
            ((TextView)localObject5).setTextColor(getResources().getColor(2131100920));
            ((TextView)localObject6).setTextColor(getResources().getColor(2131100920));
            this.xwz.setBackgroundResource(2131233161);
            this.xwy.setBackgroundResource(2131233162);
          }
          ((ImageButton)localObject1).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(187686);
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsCommentDetailUI", "showComment click" + SnsCommentDetailUI.H(SnsCommentDetailUI.this).getVisibility());
              paramAnonymousView = localp.dxy();
              if ((paramAnonymousView != null) && (paramAnonymousView.Etm.DaB == 21) && (!com.tencent.mm.plugin.sns.lucky.a.m.aoc(localp.dxX())))
              {
                com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.xxw.No(0));
                AppMethodBeat.o(187686);
                return;
              }
              if (SnsCommentDetailUI.H(SnsCommentDetailUI.this).getVisibility() == 0)
              {
                SnsCommentDetailUI.g(SnsCommentDetailUI.this);
                AppMethodBeat.o(187686);
                return;
              }
              SnsCommentDetailUI.H(SnsCommentDetailUI.this).setVisibility(0);
              SnsCommentDetailUI.H(SnsCommentDetailUI.this).startAnimation(SnsCommentDetailUI.J(SnsCommentDetailUI.this));
              if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10) {
                SnsCommentDetailUI.z(SnsCommentDetailUI.this).findViewById(2131296548).setBackgroundResource(2131232447);
              }
              if (!x.aqh(SnsCommentDetailUI.o(SnsCommentDetailUI.this)))
              {
                SnsCommentDetailUI.this.xwy.setEnabled(false);
                SnsCommentDetailUI.this.xwz.setEnabled(false);
                this.xxP.setText(SnsCommentDetailUI.this.getString(2131763882));
                this.xxP.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131100911));
                this.xxQ.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131100911));
                if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10)
                {
                  this.xxR.setImageResource(2131690238);
                  AppMethodBeat.o(187686);
                  return;
                }
                this.xxR.setImageResource(2131690241);
                AppMethodBeat.o(187686);
                return;
              }
              SnsCommentDetailUI.this.xwy.setEnabled(true);
              this.xxR.setImageResource(2131232452);
              SnsCommentDetailUI.this.xwz.setEnabled(true);
              this.xxP.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101182));
              this.xxQ.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101182));
              paramAnonymousView = com.tencent.mm.plugin.sns.storage.h.apJ(SnsCommentDetailUI.o(SnsCommentDetailUI.this));
              if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10)
              {
                this.xxR.setImageResource(2131232933);
                this.xxS.setImageResource(2131232934);
                this.xxP.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131100920));
                this.xxQ.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131100920));
              }
              while (paramAnonymousView.field_likeFlag == 0)
              {
                this.xxP.setText(SnsCommentDetailUI.this.getString(2131763882));
                AppMethodBeat.o(187686);
                return;
                this.xxR.setImageResource(2131232452);
                this.xxP.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101182));
                this.xxQ.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101182));
              }
              this.xxP.setText(SnsCommentDetailUI.this.getString(2131763839));
              AppMethodBeat.o(187686);
            }
          });
          AppMethodBeat.o(98604);
          return true;
          if (((com.tencent.mm.plugin.sns.storage.b)localObject3).wTl == 1)
          {
            i = k - com.tencent.mm.cd.a.ao(this, 2131166827) - com.tencent.mm.cd.a.ao(this, 2131166827) - com.tencent.mm.cd.a.ao(this, 2131165575) - com.tencent.mm.cd.a.ao(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
            j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTn / ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTm);
            localObject5 = new bpk();
            if (i > 0) {
              f2 = i;
            }
            ((bpk)localObject5).DNH = f2;
            if (j > 0) {
              f1 = j;
            }
            ((bpk)localObject5).DNI = f1;
            ((bpk)localObject5).DNJ = (((bpk)localObject5).DNH * ((bpk)localObject5).DNI);
            ((LinkedList)localObject1).add(localObject5);
            break;
          }
          if (((com.tencent.mm.plugin.sns.storage.b)localObject3).wTl != 2) {
            break;
          }
          i = k - com.tencent.mm.cd.a.ao(this, 2131166827) - com.tencent.mm.cd.a.ao(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
          j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTn / ((com.tencent.mm.plugin.sns.storage.b)localObject3).wTm);
          localObject5 = new bpk();
          if (i > 0) {
            f2 = i;
          }
          ((bpk)localObject5).DNH = f2;
          if (j > 0) {
            f1 = j;
          }
          ((bpk)localObject5).DNI = f1;
          ((bpk)localObject5).DNJ = (((bpk)localObject5).DNH * ((bpk)localObject5).DNI);
          ((LinkedList)localObject1).add(localObject5);
          break;
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.nBH + ",stub is " + ((ViewStub)localObject1).toString());
          continue;
          if (this.nBH != 10) {
            break label4451;
          }
          this.xxw = ((PhotosContent)findViewById(2131300686));
          this.xxw.dzX();
          localObject1 = (TagImageView)this.xxw.findViewById(2131296575);
          this.xxw.a((TagImageView)localObject1);
          ((TagImageView)localObject1).setOnClickListener(this.xta.xno);
          localObject3 = localp.dxX();
          localObject5 = new ArrayList();
          ((List)localObject5).add(localObject1);
          localObject8 = new aw();
          ((aw)localObject8).diQ = ((String)localObject3);
          ((aw)localObject8).index = 0;
          ((aw)localObject8).xzo = ((List)localObject5);
          ((aw)localObject8).xvU = true;
          if (localObject1 != null) {
            ((TagImageView)localObject1).setTag(localObject8);
          }
          localObject1 = (TextView)this.xwo.findViewById(2131300687);
          if (!u.aqG().equals(((TimeLineObject)localObject6).mAQ))
          {
            localObject3 = com.tencent.mm.plugin.sns.model.aj.t(localp);
            if ((((SnsObject)localObject3).SnsRedEnvelops != null) && (((SnsObject)localObject3).SnsRedEnvelops.Enj != 0))
            {
              ((TextView)localObject1).setText(getString(2131760986, new Object[] { Integer.valueOf(((SnsObject)localObject3).SnsRedEnvelops.Enj) }));
              ((TextView)localObject1).setVisibility(0);
            }
          }
          for (;;)
          {
            localObject1 = localp.dxQ();
            if (localObject1 == null) {
              break label4421;
            }
            if (!u.aqG().equals(((TimeLineObject)localObject6).mAQ)) {
              break label4305;
            }
            this.xwD.a(this.xxw, (TimeLineObject)localObject6, localp.dxX(), hashCode(), this.nBH, -1, false, bc.FzE, true);
            break;
            ((TextView)localObject1).setVisibility(8);
            continue;
            ((TextView)localObject1).setVisibility(8);
          }
          if (com.tencent.mm.plugin.sns.lucky.a.m.n(localp))
          {
            this.xwD.a(this.xxw, (TimeLineObject)localObject6, localp.dxX(), hashCode(), this.nBH, -1, false, bc.FzE, false);
          }
          else if (((bpj)localObject1).dDO == 0)
          {
            this.xwD.a(this.xxw, (TimeLineObject)localObject6, localp.dxX(), hashCode(), this.nBH, -1, false, bc.FzE, true);
          }
          else
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo.hbStatus is " + ((bpj)localObject1).dDO);
            continue;
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo is null " + localp.dxX());
          }
        }
        Object localObject9;
        Object localObject10;
        if (this.nBH == 9)
        {
          this.xwX = true;
          localObject3 = new an();
          localObject9 = this.xwo;
          localObject5 = ((View)localObject9).findViewById(2131298069);
          localObject8 = (VideoSightView)((View)localObject9).findViewById(2131300914);
          ((an)localObject3).xsm = ((View)localObject9);
          ((an)localObject3).xsp = ((View)localObject5);
          ((an)localObject3).xbT = ((ImageView)((View)localObject9).findViewById(2131305196));
          ((an)localObject3).xsq = ((MMPinProgressBtn)((View)localObject9).findViewById(2131303515));
          ((an)localObject3).xbU = ((TextView)((View)localObject9).findViewById(2131299517));
          ((an)localObject3).xsr = ((TextView)((View)localObject9).findViewById(2131299492));
          ((an)localObject3).xsn = ((VideoSightView)localObject8);
          ((an)localObject3).xsn.setMute(true);
          ((an)localObject3).a((TimeLineObject)localObject6, 0, localp.dxX(), localp.tQ());
          ((an)localObject3).xbU.setVisibility(8);
          ((an)localObject3).xsn.setTagObject(localObject3);
          ((an)localObject3).xsn.setIsAdVideo(localp.tQ());
          ((an)localObject3).xss = 5;
          ((View)localObject5).setTag(localObject3);
          ((an)localObject3).xsp.setOnClickListener(this.xta.xTQ);
          if (!localp.dvm())
          {
            this.mVN.c((View)localObject5, this.xta.xTJ, this.xta.xTt);
            if ((!localp.tQ()) || (!com.tencent.mm.plugin.sns.data.j.c((TimeLineObject)localObject6))) {
              break label5497;
            }
            localObject1 = com.tencent.mm.modelsns.g.a((TimeLineObject)localObject6, ((an)localObject3).xsn.getUIContext(), false);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "isVerticalAdVideo=true, snsId=" + localp.field_snsId + ", showW=" + ((Pair)localObject1).first + ", showH=" + ((Pair)localObject1).second);
            i = 1;
            if (!localp.tQ()) {
              break label10723;
            }
            localObject10 = localp.dxs();
            if ((localObject10 == null) || (!((com.tencent.mm.plugin.sns.storage.b)localObject10).dvm()) || (((com.tencent.mm.plugin.sns.storage.b)localObject10).wTm <= 0.0F) || (((com.tencent.mm.plugin.sns.storage.b)localObject10).wTn <= 0.0F)) {
              break label10723;
            }
            f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject10).wTm, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject10).wTo, ((com.tencent.mm.plugin.sns.storage.b)localObject10).wTp);
            f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject10).wTn, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject10).wTo, ((com.tencent.mm.plugin.sns.storage.b)localObject10).wTp);
            if (((com.tencent.mm.plugin.sns.storage.b)localObject10).wTl != 0) {
              break label5523;
            }
            if (f2 < k - com.tencent.mm.cd.a.ao(this, 2131166827) - com.tencent.mm.cd.a.ao(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516)) {
              break label10726;
            }
            f2 = k - com.tencent.mm.cd.a.ao(this, 2131166827) - com.tencent.mm.cd.a.ao(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
            f1 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject10).wTn * f2 / ((com.tencent.mm.plugin.sns.storage.b)localObject10).wTm);
          }
        }
        for (;;)
        {
          localObject1 = Pair.create(Integer.valueOf((int)f2), Integer.valueOf((int)f1));
          for (;;)
          {
            if (localObject1 != null)
            {
              if ((((an)localObject3).xsn instanceof SightPlayImageView))
              {
                if (!localp.tQ())
                {
                  ((an)localObject3).xsn.setScaleMode(1);
                  ((an)localObject3).xsn.setScaleType(QImageView.a.HBy);
                }
              }
              else
              {
                ((VideoSightView)localObject8).gW(((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue());
                if ((((an)localObject3).xsn instanceof SightPlayImageView))
                {
                  if (i == 0) {
                    break label5756;
                  }
                  ((an)localObject3).xsn.dqC();
                }
                label5109:
                localObject10 = ((an)localObject3).xsr.getLayoutParams();
                ((ViewGroup.LayoutParams)localObject10).width = ((Integer)((Pair)localObject1).first).intValue();
                ((ViewGroup.LayoutParams)localObject10).height = ((Integer)((Pair)localObject1).second).intValue();
                ((an)localObject3).xsr.setLayoutParams((ViewGroup.LayoutParams)localObject10);
                localObject9 = (FrameLayout)((View)localObject9).findViewById(2131305105);
                localObject10 = (FrameLayout.LayoutParams)((FrameLayout)localObject9).getLayoutParams();
                ((FrameLayout.LayoutParams)localObject10).width = ((Integer)((Pair)localObject1).first).intValue();
                ((FrameLayout.LayoutParams)localObject10).height = ((Integer)((Pair)localObject1).second).intValue();
                ((FrameLayout)localObject9).setLayoutParams((ViewGroup.LayoutParams)localObject10);
              }
            }
            else
            {
              if ((((TimeLineObject)localObject6).Etm == null) || (((TimeLineObject)localObject6).Etm.DaC.size() <= 0)) {
                break label5768;
              }
              localObject1 = (bpi)((TimeLineObject)localObject6).Etm.DaC.get(0);
              if (localp.tQ())
              {
                ((an)localObject3).xsn.setOnCompletionListener(new b.e()
                {
                  public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(187682);
                    if (paramAnonymousInt != -1)
                    {
                      if (SnsCommentDetailUI.f(SnsCommentDetailUI.this) == null)
                      {
                        AppMethodBeat.o(187682);
                        return;
                      }
                      SnsCommentDetailUI.f(SnsCommentDetailUI.this).A(localp.field_snsId, false);
                    }
                    AppMethodBeat.o(187682);
                  }
                });
                ((an)localObject3).xsn.setOnDecodeDurationListener(new b.f()
                {
                  public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
                  {
                    AppMethodBeat.i(187683);
                    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsCommentDetailUI", "onDecodeProgress:".concat(String.valueOf(paramAnonymousLong)));
                    if ((SnsCommentDetailUI.f(SnsCommentDetailUI.this) != null) && (localp != null))
                    {
                      SnsCommentDetailUI.f(SnsCommentDetailUI.this).sm(localp.field_snsId);
                      SnsCommentDetailUI.f(SnsCommentDetailUI.this).ak(localp.field_snsId, 1000L * paramAnonymousLong);
                      if (!SnsCommentDetailUI.f(SnsCommentDetailUI.this).sj(localp.field_snsId))
                      {
                        int i = (int)paramAnonymousb.dqu();
                        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "updatePlayStartTime, duration=".concat(String.valueOf(i)));
                        SnsCommentDetailUI.f(SnsCommentDetailUI.this).d(localp.field_snsId, bt.GC(), false);
                        SnsCommentDetailUI.f(SnsCommentDetailUI.this).e(localp.field_snsId, i, false);
                        SnsCommentDetailUI.f(SnsCommentDetailUI.this).aj(localp.field_snsId, localp.field_snsId);
                      }
                    }
                    AppMethodBeat.o(187683);
                  }
                });
              }
              if ((((TimeLineObject)localObject6).Etm == null) || (((TimeLineObject)localObject6).Etm.DaC.size() <= 0)) {
                break;
              }
              com.tencent.mm.plugin.sns.model.af.dtr();
              if (com.tencent.mm.plugin.sns.model.f.t((bpi)localObject1)) {
                break label5877;
              }
              if (!com.tencent.mm.plugin.sns.model.af.dtr().w((bpi)localObject1)) {
                break label5774;
              }
              ((an)localObject3).xbT.setVisibility(8);
              ((an)localObject3).xsq.setVisibility(0);
              ((an)localObject3).xsq.feJ();
              ((VideoSightView)localObject8).setTagObject(localObject3);
              com.tencent.mm.plugin.sns.model.af.dtr().a(localp, (bpi)localObject1, (VideoSightView)localObject8, hashCode(), 0, bc.FzE, localp.tQ());
              ((VideoSightView)localObject8).start();
              ((View)localObject5).setTag(localObject3);
              if (this.xwT == null) {
                break;
              }
              if (!localp.tQ()) {
                break label6161;
              }
              if (com.tencent.mm.plugin.sns.model.af.dtr().r(localp) != 5) {
                break label6155;
              }
              bool = true;
            }
            for (;;)
            {
              this.xwT.C(localp.field_snsId, bool);
              break;
              this.mVN.c((View)localObject5, this.xta.xTL, this.xta.xTt);
              break label4707;
              label5497:
              localObject1 = com.tencent.mm.modelsns.g.a((TimeLineObject)localObject6, ((an)localObject3).xsn.getUIContext(), localp.tQ());
              i = 0;
              break label4797;
              if (((com.tencent.mm.plugin.sns.storage.b)localObject10).wTl == 1)
              {
                j = k - com.tencent.mm.cd.a.ao(this, 2131166827) - com.tencent.mm.cd.a.ao(this, 2131166827) - com.tencent.mm.cd.a.ao(this, 2131165575) - com.tencent.mm.cd.a.ao(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
                localObject1 = Pair.create(Integer.valueOf(j), Integer.valueOf((int)(j * ((com.tencent.mm.plugin.sns.storage.b)localObject10).wTn / ((com.tencent.mm.plugin.sns.storage.b)localObject10).wTm)));
                break label5014;
              }
              if (((com.tencent.mm.plugin.sns.storage.b)localObject10).wTl != 2) {
                break label10723;
              }
              j = k - com.tencent.mm.cd.a.ao(this, 2131166827) - com.tencent.mm.cd.a.ao(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
              localObject1 = Pair.create(Integer.valueOf(j), Integer.valueOf((int)(j * ((com.tencent.mm.plugin.sns.storage.b)localObject10).wTn / ((com.tencent.mm.plugin.sns.storage.b)localObject10).wTm)));
              break label5014;
              if (i != 0)
              {
                ((an)localObject3).xsn.setScaleMode(1);
                ((an)localObject3).xsn.setScaleType(QImageView.a.HBy);
                break label5058;
              }
              ((an)localObject3).xsn.setScaleMode(0);
              ((an)localObject3).xsn.setScaleType(QImageView.a.HBt);
              break label5058;
              label5756:
              ((an)localObject3).xsn.setDrawWidthAndHeightFix(false);
              break label5109;
              localObject1 = null;
              break label5262;
              if ((localp.tQ()) && (com.tencent.mm.plugin.sns.model.af.dtr().r(localp) == 5))
              {
                com.tencent.mm.plugin.sns.model.af.dtr().A((bpi)localObject1);
                ((an)localObject3).xbT.setVisibility(8);
                ((an)localObject3).xsq.setVisibility(0);
                ((an)localObject3).xsq.feJ();
                break label5378;
              }
              com.tencent.mm.plugin.sns.model.af.dtr().y((bpi)localObject1);
              ((an)localObject3).xbT.setVisibility(0);
              ((an)localObject3).xsq.setVisibility(8);
              ((an)localObject3).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this, 2131691166));
              break label5378;
              label5877:
              if (com.tencent.mm.plugin.sns.model.af.dtr().u((bpi)localObject1))
              {
                ((an)localObject3).xbT.setVisibility(0);
                ((an)localObject3).xsq.setVisibility(8);
                ((an)localObject3).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this, 2131691166));
              }
              for (;;)
              {
                if (!((an)localObject3).xsn.dqD()) {
                  break label6153;
                }
                com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsCommentDetailUI", "play video error " + ((bpi)localObject1).Id + " " + ((bpi)localObject1).Url + " " + ((bpi)localObject1).DMQ);
                com.tencent.mm.plugin.sns.model.af.dtr().y((bpi)localObject1);
                ((an)localObject3).xbT.setVisibility(0);
                ((an)localObject3).xsq.setVisibility(8);
                ((an)localObject3).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this, 2131691166));
                break;
                if (com.tencent.mm.plugin.sns.model.af.dtr().v((bpi)localObject1))
                {
                  ((an)localObject3).xbT.setVisibility(8);
                  ((an)localObject3).xsq.setVisibility(8);
                }
                else if ((localp.tQ()) && (com.tencent.mm.plugin.sns.model.af.dtr().r(localp) <= 5))
                {
                  ((an)localObject3).xbT.setVisibility(8);
                  ((an)localObject3).xsq.setVisibility(8);
                }
                else
                {
                  com.tencent.mm.plugin.sns.model.af.dtr().y((bpi)localObject1);
                  ((an)localObject3).xbT.setVisibility(0);
                  ((an)localObject3).xsq.setVisibility(8);
                  ((an)localObject3).xbT.setImageDrawable(com.tencent.mm.cd.a.l(this, 2131691166));
                }
              }
              break label5378;
              bool = false;
              continue;
              if (com.tencent.mm.plugin.sns.model.af.dtr().q(localp) == 5) {
                bool = true;
              } else {
                bool = false;
              }
            }
            if (this.nBH == 0)
            {
              localObject1 = (LinearLayout)this.xwo.findViewById(2131305006);
              localObject3 = Nr(2131495567);
              if (!this.xxt)
              {
                ((LinearLayout)localObject1).removeView(this.xxw);
                ((LinearLayout)localObject1).addView((View)localObject3, 3);
                if (((LinearLayout)localObject3).getLayoutParams() == null) {
                  break label6577;
                }
              }
              for (localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject3).getLayoutParams());; localObject1 = new LinearLayout.LayoutParams(-1, -2))
              {
                ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cd.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
                if (((TimeLineObject)localObject6).Etm.DaC.isEmpty()) {
                  break label6592;
                }
                localObject5 = (bpi)((TimeLineObject)localObject6).Etm.DaC.get(0);
                localObject1 = (MMImageView)((LinearLayout)localObject3).findViewById(2131300948);
                com.tencent.mm.plugin.sns.model.af.dtr().a((bpi)localObject5, (View)localObject1, 2131689564, hashCode(), bc.FzE);
                this.xwH = ((ImageView)((LinearLayout)localObject3).findViewById(2131305185));
                this.xwH.setOnTouchListener(this.xmL);
                this.dqm = ((TimeLineObject)localObject6).Id;
                dAZ();
                bool = getIntent().getBooleanExtra("SNS_FROM_MUSIC_ITEM", false);
                ((MMImageView)localObject1).setTag(new s((TimeLineObject)localObject6, this.xwE, bool));
                ((MMImageView)localObject1).setOnClickListener(this.xwM.xLF);
                localObject8 = ((bpi)localObject5).Desc;
                if (!bt.isNullOrNil((String)localObject8)) {
                  ((TextView)((LinearLayout)localObject3).findViewById(2131304202)).setText((CharSequence)localObject8);
                }
                localObject5 = ((bpi)localObject5).Title;
                if (!bt.isNullOrNil((String)localObject5)) {
                  ((TextView)((LinearLayout)localObject3).findViewById(2131305950)).setText(new SpannableString((CharSequence)localObject5), TextView.BufferType.SPANNABLE);
                }
                ((LinearLayout)localObject3).setTag(new s((TimeLineObject)localObject6, this.xwE));
                this.mVN.c((View)localObject3, this.xta.xTI, this.xta.xTt);
                ((LinearLayout)localObject3).setOnClickListener(this.xwM.xDo);
                com.tencent.mm.plugin.sns.data.q.b((View)localObject1, this);
                break;
              }
              ((LinearLayout)localObject3).setVisibility(8);
              break;
            }
            if (this.nBH == 13)
            {
              this.xwp.setVisibility(8);
              this.xwu.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
              break;
            }
            if ((this.nBH == 11) || (this.nBH == 14) || (this.nBH == 15)) {
              break;
            }
            if (this.nBH == 16)
            {
              localObject1 = (LinearLayout)this.xwo.findViewById(2131305006);
              localObject5 = Nr(2131495565);
              if (!this.xxt)
              {
                ((LinearLayout)localObject1).removeView(this.xxw);
                ((LinearLayout)localObject1).addView((View)localObject5, 3);
                if (((LinearLayout)localObject5).getLayoutParams() != null)
                {
                  localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject5).getLayoutParams());
                  ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cd.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                  ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject1);
                }
              }
              else
              {
                localObject8 = (MMImageView)((LinearLayout)localObject5).findViewById(2131300948);
                ((MMImageView)localObject8).setVisibility(0);
                localObject9 = (TextView)((LinearLayout)localObject5).findViewById(2131305950);
                if (((TimeLineObject)localObject6).Etm.DaG == null) {
                  break label7246;
                }
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderShareObject not null");
                if ((!bt.isNullOrNil(((TimeLineObject)localObject6).Etm.DaG.nickname)) || (bt.isNullOrNil(((TimeLineObject)localObject6).Etm.DaG.desc))) {
                  break label7150;
                }
                localObject1 = ((TimeLineObject)localObject6).Etm.DaG.desc;
              }
              for (;;)
              {
                ((TextView)localObject9).setText(new SpannableString((CharSequence)localObject1), TextView.BufferType.SPANNABLE);
                ((TextView)localObject9).setMaxLines(2);
                if (!((TimeLineObject)localObject6).Etm.DaG.mediaList.isEmpty())
                {
                  localObject1 = new bpi();
                  ((bpi)localObject1).Url = ((alc)((TimeLineObject)localObject6).Etm.DaG.mediaList.get(0)).thumbUrl;
                  ((bpi)localObject1).DMQ = ((alc)((TimeLineObject)localObject6).Etm.DaG.mediaList.get(0)).thumbUrl;
                  ((bpi)localObject1).mBH = 2;
                  ((bpi)localObject1).DMR = 1;
                  ((bpi)localObject1).DMT = new bpk();
                  ((bpi)localObject1).Dzl = 1;
                  ((bpi)localObject1).DMT.DNH = ((alc)((TimeLineObject)localObject6).Etm.DaG.mediaList.get(0)).width;
                  ((bpi)localObject1).DMT.DNI = ((alc)((TimeLineObject)localObject6).Etm.DaG.mediaList.get(0)).height;
                  ((bpi)localObject1).Id = localp.getSnsId();
                  com.tencent.mm.plugin.sns.model.af.dtr().b((bpi)localObject1, (View)localObject8, hashCode(), bc.eLG().WB(((TimeLineObject)localObject6).CreateTime));
                }
                ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject6, this.xwE));
                ((LinearLayout)localObject5).setOnClickListener(this.xwM.xDo);
                break;
                localObject1 = new LinearLayout.LayoutParams(-1, -2);
                break label6746;
                if (!bt.isNullOrNil(((TimeLineObject)localObject6).Etm.DaG.desc)) {
                  localObject1 = ((TimeLineObject)localObject6).Etm.DaG.nickname + ": " + ((TimeLineObject)localObject6).Etm.DaG.desc;
                } else {
                  localObject1 = getString(2131763973, new Object[] { ((TimeLineObject)localObject6).Etm.DaG.nickname });
                }
              }
              if (((TimeLineObject)localObject6).Etm.DaH == null) {
                break;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderShareTopic not null");
              localObject3 = getString(2131755778);
              if (((TimeLineObject)localObject6).Etm.DaH != null) {
                if (((TimeLineObject)localObject6).Etm.DaH.qSS != 1) {
                  break label7570;
                }
              }
              for (localObject1 = "#" + ((TimeLineObject)localObject6).Etm.DaH.dqA;; localObject1 = ((TimeLineObject)localObject6).Etm.DaH.dqA)
              {
                localObject3 = localObject1;
                if (!bt.isNullOrNil(((TimeLineObject)localObject6).Etm.DaH.desc))
                {
                  localObject3 = (TextView)((LinearLayout)localObject5).findViewById(2131304202);
                  ((TextView)localObject3).setVisibility(0);
                  ((TextView)localObject3).setText(((TimeLineObject)localObject6).Etm.DaH.desc);
                  localObject3 = localObject1;
                }
                ((TextView)localObject9).setText(new SpannableString((CharSequence)localObject3), TextView.BufferType.SPANNABLE);
                ((TextView)localObject9).setMaxLines(2);
                localObject1 = new bpi();
                ((bpi)localObject1).Url = ((TimeLineObject)localObject6).Etm.DaH.iconUrl;
                ((bpi)localObject1).DMQ = ((TimeLineObject)localObject6).Etm.DaH.iconUrl;
                ((bpi)localObject1).mBH = 2;
                ((bpi)localObject1).DMR = 1;
                ((bpi)localObject1).DMT = new bpk();
                ((bpi)localObject1).Dzl = 1;
                ((bpi)localObject1).DMT.DNH = 0.0F;
                ((bpi)localObject1).DMT.DNI = 0.0F;
                ((bpi)localObject1).Id = localp.getSnsId();
                com.tencent.mm.plugin.sns.model.af.dtr().b((bpi)localObject1, (View)localObject8, hashCode(), bc.eLG().WB(((TimeLineObject)localObject6).CreateTime));
                ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject6, this.xwE));
                ((LinearLayout)localObject5).setOnClickListener(this.xwM.xDo);
                break;
              }
            }
            localObject1 = (LinearLayout)this.xwo.findViewById(2131305006);
            localObject8 = Nr(2131495565);
            localObject9 = (MMImageView)((LinearLayout)localObject8).findViewById(2131300948);
            if (!this.xxt)
            {
              ((LinearLayout)localObject1).removeView(this.xxw);
              ((LinearLayout)localObject1).addView((View)localObject8, 3);
              if (((LinearLayout)localObject8).getLayoutParams() != null)
              {
                localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject8).getLayoutParams());
                label7669:
                ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cd.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                ((LinearLayout)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject1);
              }
            }
            else
            {
              i = 0;
              if (!localp.tQ()) {
                break label8144;
              }
              if (localp.dxs().dvl())
              {
                i = 1;
                ((LinearLayout)localObject8).setTag(localp);
                ((LinearLayout)localObject8).setTag(2131301433, localObject9);
                ((LinearLayout)localObject8).setOnClickListener(this.xta.xUi);
              }
              j = 0;
            }
            for (;;)
            {
              if (i != 0)
              {
                this.mVN.c((View)localObject8, this.xta.xTM, this.xta.xTt);
                if (!dAV()) {
                  break label8917;
                }
                localObject1 = be.aqC(((TimeLineObject)localObject6).Etm.Url);
                label7806:
                localObject3 = ((TimeLineObject)localObject6).Etm.Title;
                if (i != 0) {
                  localObject1 = ((TimeLineObject)localObject6).Etm.Desc;
                }
                if ((((TimeLineObject)localObject6).Etm.DaF == null) || (((TimeLineObject)localObject6).Etm.DaF.gGA != 1)) {
                  break label10711;
                }
                localObject1 = com.tencent.mm.sdk.platformtools.aj.getContext().getString(2131761345);
              }
              for (;;)
              {
                ((LinearLayout)localObject8).findViewById(2131305185).setVisibility(8);
                if (!((TimeLineObject)localObject6).Etm.DaC.isEmpty())
                {
                  ((MMImageView)localObject9).setVisibility(0);
                  localObject5 = (bpi)((TimeLineObject)localObject6).Etm.DaC.get(0);
                  if (((TimeLineObject)localObject6).Etm.DaB == 15)
                  {
                    ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setImageResource(2131233395);
                    ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setVisibility(0);
                    com.tencent.mm.plugin.sns.model.af.dtr().a((bpi)localObject5, (View)localObject9, 2131689581, hashCode(), bc.eLG().WB(((TimeLineObject)localObject6).CreateTime));
                    localObject5 = localObject3;
                    localObject3 = localObject1;
                    localObject1 = localObject5;
                    com.tencent.mm.plugin.sns.data.q.b((View)localObject9, this);
                    if (((TimeLineObject)localObject6).Etm.DaB != 15) {
                      break label10708;
                    }
                    localObject1 = getString(2131763826);
                    localObject3 = "";
                  }
                }
                for (;;)
                {
                  localObject5 = (TextView)((LinearLayout)localObject8).findViewById(2131305950);
                  if (!bt.isNullOrNil((String)localObject3))
                  {
                    ((LinearLayout)localObject8).findViewById(2131304202).setVisibility(0);
                    ((TextView)((LinearLayout)localObject8).findViewById(2131304202)).setText((CharSequence)localObject3);
                    ((TextView)localObject5).setMaxLines(1);
                  }
                  for (;;)
                  {
                    if (!bt.isNullOrNil((String)localObject1))
                    {
                      ((TextView)localObject5).setVisibility(0);
                      if (j != 0)
                      {
                        ((TextView)localObject5).setText(com.tencent.mm.plugin.sns.data.q.a((String)localObject1, getContext(), (TextView)localObject5));
                        break;
                        localObject1 = new LinearLayout.LayoutParams(-1, -2);
                        break label7669;
                        if (((TimeLineObject)localObject6).Etm.DaB == 9)
                        {
                          if (((TimeLineObject)localObject6).Etm.DaC.size() <= 0) {
                            break label10714;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.xwE));
                          ((LinearLayout)localObject8).setOnClickListener(this.xwM.xLz);
                          i = 0;
                          j = 0;
                          break label7759;
                        }
                        if (((TimeLineObject)localObject6).Etm.DaB == 10)
                        {
                          if (((TimeLineObject)localObject6).Etm.DaC.size() <= 0) {
                            break label10714;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.xwE));
                          ((LinearLayout)localObject8).setOnClickListener(this.xwM.xLB);
                          i = 0;
                          j = 0;
                          break label7759;
                        }
                        if (((TimeLineObject)localObject6).Etm.DaB == 17)
                        {
                          if (((TimeLineObject)localObject6).Etm.DaC.size() <= 0) {
                            break label10714;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.xwE));
                          ((LinearLayout)localObject8).setOnClickListener(this.xwM.xLC);
                          i = 0;
                          j = 0;
                          break label7759;
                        }
                        if (((TimeLineObject)localObject6).Etm.DaB == 22)
                        {
                          if (((TimeLineObject)localObject6).Etm.DaC.size() <= 0) {
                            break label10714;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.xwE));
                          ((LinearLayout)localObject8).setOnClickListener(this.xwM.xLD);
                          i = 0;
                          j = 0;
                          break label7759;
                        }
                        if (((TimeLineObject)localObject6).Etm.DaB == 23)
                        {
                          if (((TimeLineObject)localObject6).Etm.DaC.size() <= 0) {
                            break label10714;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.xwE));
                          ((LinearLayout)localObject8).setOnClickListener(this.xwM.xLE);
                          i = 0;
                          j = 0;
                          break label7759;
                        }
                        if (((TimeLineObject)localObject6).Etm.DaB == 14)
                        {
                          if (((TimeLineObject)localObject6).Etm.DaC.size() <= 0) {
                            break label10714;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.xwE));
                          ((LinearLayout)localObject8).setOnClickListener(this.xwM.xLA);
                          i = 0;
                          j = 0;
                          break label7759;
                        }
                        if (((TimeLineObject)localObject6).Etm.DaB == 12)
                        {
                          if (((TimeLineObject)localObject6).Etm.DaC.size() <= 0) {
                            break label10714;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.xwE));
                          ((LinearLayout)localObject8).setOnClickListener(this.xwM.xLJ);
                          i = 0;
                          j = 0;
                          break label7759;
                        }
                        if (((TimeLineObject)localObject6).Etm.DaB == 30)
                        {
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.xwE));
                          ((LinearLayout)localObject8).setOnClickListener(this.xwM.xLH);
                          i = 0;
                          j = 0;
                          break label7759;
                        }
                        if (((TimeLineObject)localObject6).Etm.DaB == 13)
                        {
                          if (((TimeLineObject)localObject6).Etm.DaC.size() <= 0) {
                            break label10714;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.xwE));
                          ((LinearLayout)localObject8).setOnClickListener(this.xwM.xLK);
                          i = 0;
                          j = 0;
                          break label7759;
                        }
                        if (((TimeLineObject)localObject6).Etm.DaB == 15)
                        {
                          if (((TimeLineObject)localObject6).Etm.DaC.size() <= 0) {
                            break label10714;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.xwE));
                          ((LinearLayout)localObject8).setOnClickListener(this.xta.xTR);
                          i = 0;
                          j = 0;
                          break label7759;
                        }
                        if (((TimeLineObject)localObject6).Etm.DaB == 26)
                        {
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.xwE));
                          ((LinearLayout)localObject8).setOnClickListener(this.xwM.xLL);
                          i = 0;
                          j = 0;
                          break label7759;
                        }
                        ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.xwE));
                        ((LinearLayout)localObject8).setOnClickListener(this.xwM.xDo);
                        if ((((TimeLineObject)localObject6).gHj & 0x1) <= 0) {
                          break label10714;
                        }
                        i = 0;
                        j = 1;
                        break label7759;
                        this.mVN.c((View)localObject8, this.xta.xTI, this.xta.xTt);
                        break label7787;
                        localObject1 = "";
                        break label7806;
                        if (((TimeLineObject)localObject6).Etm.DaB == 5)
                        {
                          localObject3 = be.aqC(((bpi)localObject5).Url);
                          localObject1 = ((bpi)localObject5).Title;
                          ((LinearLayout)localObject8).findViewById(2131305185).setVisibility(0);
                          com.tencent.mm.plugin.sns.model.af.dtr().a((bpi)localObject5, (View)localObject9, 2131689581, hashCode(), bc.FzE);
                          break label8003;
                        }
                        if (((TimeLineObject)localObject6).Etm.DaB == 18)
                        {
                          ((LinearLayout)localObject8).findViewById(2131305185).setVisibility(0);
                          ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setImageResource(2131234474);
                          ((MMImageView)localObject9).setVisibility(0);
                          com.tencent.mm.plugin.sns.model.af.dtr().a((bpi)localObject5, (View)localObject9, 2131689581, hashCode(), bc.FzE);
                          localObject5 = localObject1;
                          localObject1 = localObject3;
                          localObject3 = localObject5;
                          break label8003;
                        }
                        com.tencent.mm.plugin.sns.model.af.dtr().b((bpi)localObject5, (View)localObject9, hashCode(), bc.FzE);
                        localObject5 = localObject1;
                        localObject1 = localObject3;
                        localObject3 = localObject5;
                        break label8003;
                        if (((TimeLineObject)localObject6).Etm.DaB == 18)
                        {
                          ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setVisibility(0);
                          ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setImageResource(2131234474);
                          ((MMImageView)localObject9).setVisibility(0);
                          com.tencent.mm.plugin.sns.model.af.dtr().c((View)localObject9, -1, 2131689581, hashCode());
                          localObject5 = localObject1;
                          localObject1 = localObject3;
                          localObject3 = localObject5;
                          break label8003;
                        }
                        if (((TimeLineObject)localObject6).Etm.DaB == 26)
                        {
                          ((MMImageView)localObject9).setVisibility(0);
                          com.tencent.mm.plugin.sns.model.af.dtr().c((View)localObject9, -1, 2131690949, hashCode());
                          localObject5 = localObject1;
                          localObject1 = localObject3;
                          localObject3 = localObject5;
                          break label8003;
                        }
                        ((MMImageView)localObject9).setVisibility(0);
                        com.tencent.mm.plugin.sns.model.af.dtr().c((View)localObject9, -1, 2131689584, hashCode());
                        localObject5 = localObject1;
                        localObject1 = localObject3;
                        localObject3 = localObject5;
                        break label8003;
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
                  if (bt.isNullOrNil((String)localObject1)) {
                    break label2483;
                  }
                  ((TextView)localObject5).setTextColor(getContext().getResources().getColor(2131099769));
                  ((TextView)localObject5).setClickable(true);
                  ((TextView)localObject5).setText((CharSequence)localObject1);
                  break label2514;
                  ((TextView)localObject5).setVisibility(8);
                  break label2514;
                  if (((TimeLineObject)localObject6).Etk == null)
                  {
                    localObject1 = null;
                    if (((TimeLineObject)localObject6).Etk != null) {
                      break label9444;
                    }
                  }
                  for (localObject3 = null;; localObject3 = ((TimeLineObject)localObject6).Etk.goQ)
                  {
                    ((TextView)localObject5).setTag(localp.dxX());
                    if ((!bt.isNullOrNil((String)localObject1)) || (!bt.isNullOrNil((String)localObject3))) {
                      break label9457;
                    }
                    ((TextView)localObject5).setVisibility(8);
                    break;
                    localObject1 = ((TimeLineObject)localObject6).Etk.ijO;
                    break label9384;
                  }
                  ((TextView)localObject5).setVisibility(0);
                  if (!bt.isNullOrNil((String)localObject3))
                  {
                    ((TextView)localObject5).setTextColor(getContext().getResources().getColor(2131099769));
                    ((TextView)localObject5).setClickable(true);
                    if ((localp.field_snsId == 0L) && (!bt.isNullOrNil((String)localObject1)))
                    {
                      ((TextView)localObject5).setText((String)localObject1 + "·" + (String)localObject3);
                      break label2530;
                    }
                    ((TextView)localObject5).setText((CharSequence)localObject3);
                    break label2530;
                  }
                  ((TextView)localObject5).setText((CharSequence)localObject1);
                  ((TextView)localObject5).setClickable(false);
                  ((TextView)localObject5).setTextColor(getContext().getResources().getColor(2131100212));
                  break label2530;
                  label9591:
                  ((TextView)localObject5).setVisibility(8);
                  break label2725;
                  if (((com.tencent.mm.plugin.sns.storage.a)localObject7).wSc != com.tencent.mm.plugin.sns.storage.a.wRP) {
                    break label2725;
                  }
                  if (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject7).wSd))
                  {
                    localObject1 = "";
                    localObject9 = ((com.tencent.mm.plugin.sns.storage.a)localObject7).wSf.iterator();
                    if (((Iterator)localObject9).hasNext())
                    {
                      localObject10 = (String)((Iterator)localObject9).next();
                      localObject3 = this.xwF.aHX((String)localObject10);
                      if (localObject3 != null)
                      {
                        localObject3 = ((com.tencent.mm.n.b)localObject3).ZX();
                        if (!bt.isNullOrNil((String)localObject3)) {
                          localObject3 = (String)localObject1 + (String)localObject3;
                        }
                      }
                      for (;;)
                      {
                        localObject1 = localObject3;
                        if (((com.tencent.mm.plugin.sns.storage.a)localObject7).wSf.getLast() == localObject10) {
                          break;
                        }
                        localObject1 = (String)localObject3 + ",";
                        break;
                        localObject3 = (String)localObject1 + (String)localObject10;
                        continue;
                        localObject3 = (String)localObject1 + (String)localObject10;
                      }
                    }
                    localObject3 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject7).wSd, new Object[] { localObject1 });
                    ((TextView)localObject5).getTextSize();
                    localObject9 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject3, 1));
                    ((com.tencent.mm.pluginsdk.ui.span.l)localObject9).b(null, (CharSequence)localObject3);
                    localObject3 = ((TextView)localObject5).getPaint();
                    if (com.tencent.mm.cd.a.ar(this, (int)Layout.getDesiredWidth((CharSequence)localObject9, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject9).length(), (TextPaint)localObject3)) > this.xwR)
                    {
                      if (((String)localObject1).length() <= 1) {
                        break label2725;
                      }
                      localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
                      localObject9 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject7).wSd, new Object[] { (String)localObject1 + "..." });
                      ((TextView)localObject5).getTextSize();
                      localObject10 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject9, 1));
                      ((com.tencent.mm.pluginsdk.ui.span.l)localObject10).b(null, (CharSequence)localObject9);
                      i = com.tencent.mm.cd.a.ar(this, (int)Layout.getDesiredWidth((CharSequence)localObject10, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject10).length(), (TextPaint)localObject3));
                      ((TextView)localObject5).setText((CharSequence)localObject10, TextView.BufferType.SPANNABLE);
                      ((TextView)localObject5).setVisibility(0);
                      if (i > this.xwR) {
                        break label2724;
                      }
                      break label2725;
                    }
                    ((TextView)localObject5).setText((CharSequence)localObject9, TextView.BufferType.SPANNABLE);
                    ((TextView)localObject5).setVisibility(0);
                    break label2725;
                  }
                  ((TextView)localObject5).setVisibility(8);
                  break label2725;
                  ((TextView)localObject8).setVisibility(8);
                  break label2851;
                  i = 8;
                  break label2882;
                  if (((TimeLineObject)localObject6).Etm.DaB != 30) {
                    break label2972;
                  }
                  localObject1 = ((TimeLineObject)localObject6).Ets.username;
                  localObject1 = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).FW((String)localObject1);
                  if ((localObject1 != null) && (!bt.isNullOrNil(((WxaAttributes)localObject1).field_nickname))) {}
                  for (localObject3 = ((WxaAttributes)localObject1).field_nickname;; localObject3 = getString(2131755945))
                  {
                    localObject1 = localObject3;
                    if (((TimeLineObject)localObject6).Ets.subType != 1) {
                      break;
                    }
                    this.xxu.findViewById(2131305185).setVisibility(0);
                    localObject1 = localObject3;
                    break;
                  }
                  ((TextView)localObject4).setVisibility(8);
                  break label3113;
                  ((TextView)localObject1).setVisibility(8);
                  break label3199;
                  if (((SnsObject)localObject5).WithUserList.size() <= 0) {
                    ((TextView)localObject4).setVisibility(8);
                  }
                  for (;;)
                  {
                    if ((localObject5 == null) || (this.fki == null) || (!this.fki.equals(((SnsObject)localObject5).Username)) || (((((SnsObject)localObject5).ExtFlag != 3) || (((SnsObject)localObject5).BlackList == null)) && ((((SnsObject)localObject5).ExtFlag != 5) || (((SnsObject)localObject5).GroupUser == null)))) {
                      break label10690;
                    }
                    this.xwo.findViewById(2131296570).setVisibility(0);
                    this.xwo.findViewById(2131296570).setTag(Integer.valueOf(localp.xiB));
                    this.xwo.findViewById(2131296570).setOnClickListener(new SnsCommentDetailUI.32(this));
                    break;
                    if (this.fki.equals(((SnsObject)localObject5).Username))
                    {
                      ((TextView)localObject4).setVisibility(0);
                      i = 0;
                      localObject6 = ((SnsObject)localObject5).WithUserList.iterator();
                      localObject1 = "";
                      if (((Iterator)localObject6).hasNext())
                      {
                        localObject7 = (cuo)((Iterator)localObject6).next();
                        if (i == 0)
                        {
                          i = 1;
                          localObject1 = (String)localObject1 + "  ";
                          if (((cuo)localObject7).Nickname == null) {
                            break label10508;
                          }
                          localObject3 = new StringBuilder().append((String)localObject1);
                          localObject1 = ((cuo)localObject7).Nickname;
                        }
                        for (;;)
                        {
                          localObject1 = (String)localObject1;
                          break;
                          localObject1 = (String)localObject1 + ",  ";
                          break label10438;
                          localObject8 = this.xwF.aHY(((cuo)localObject7).Username);
                          localObject3 = new StringBuilder().append((String)localObject1);
                          if (localObject8 == null) {
                            localObject1 = ((cuo)localObject7).Username;
                          } else {
                            localObject1 = ((com.tencent.mm.n.b)localObject8).ZX();
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
                        localObject3 = (cuo)((Iterator)localObject1).next();
                        if (!this.fki.equals(((cuo)localObject3).Username)) {
                          break label10225;
                        }
                        ((TextView)localObject4).setVisibility(0);
                        localObject1 = getString(2131764040);
                        ((TextView)localObject4).setVisibility(0);
                        ((TextView)localObject4).setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject1, ((TextView)localObject4).getTextSize()));
                      }
                    }
                  }
                  this.xwo.findViewById(2131296570).setVisibility(8);
                  break label3233;
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
  }
  
  public final void dsp() {}
  
  public final aj dyL()
  {
    return this.xlm;
  }
  
  public final b dyM()
  {
    return this.xlk;
  }
  
  public final bm dyN()
  {
    return null;
  }
  
  public final bo dyO()
  {
    return this.xln;
  }
  
  public int getLayoutId()
  {
    return 2131495537;
  }
  
  public final int getSource()
  {
    if (this.xxb == 16) {
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
        AppMethodBeat.i(187675);
        if (SnsCommentDetailUI.c(SnsCommentDetailUI.this) != null) {
          SnsCommentDetailUI.c(SnsCommentDetailUI.this).qn(false);
        }
        SnsCommentDetailUI.this.finish();
        AppMethodBeat.o(187675);
        return true;
      }
    });
    this.fki = u.aqG();
    if (com.tencent.mm.plugin.sns.model.af.dtd()) {
      finish();
    }
    final com.tencent.mm.plugin.sns.storage.p localp = qm(true);
    if (localp == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.dpC);
      finish();
      AppMethodBeat.o(98599);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "snsId: " + this.dpC + "localId " + this.xwE + "  username:" + localp.field_userName);
    Object localObject1 = (TextView)findViewById(2131298750);
    label297:
    int i;
    if (this.xwY)
    {
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(this.xwZ);
      if ((x.aqh(this.dpC)) || (!localp.dxZ())) {
        break label637;
      }
      localObject1 = localp.dxQ();
      findViewById(2131305039).setVisibility(0);
      localObject2 = (TextView)findViewById(2131303362);
      switch (((bpj)localObject1).DNw)
      {
      default: 
        if (!bt.isNullOrNil(((bpj)localObject1).DND))
        {
          ((TextView)localObject2).setText(((bpj)localObject1).DND);
          findViewById(2131305040).setVisibility(0);
          i = 1;
        }
        break;
      }
    }
    for (;;)
    {
      if (i != 0) {
        findViewById(2131305039).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(187666);
            if (localp.Nb(32))
            {
              AppMethodBeat.o(187666);
              return;
            }
            com.tencent.mm.plugin.sns.model.aj.Mp(localp.xiB);
            com.tencent.mm.plugin.sns.model.aj.Mn(localp.xiB);
            com.tencent.mm.plugin.sns.model.af.dtq().drS();
            paramAnonymousView = new Intent();
            SnsCommentDetailUI.this.setResult(-1, paramAnonymousView);
            if (SnsCommentDetailUI.w(SnsCommentDetailUI.this)) {
              paramAnonymousView.putExtra("sns_gallery_force_finish", true);
            }
            SnsCommentDetailUI.this.finish();
            SnsCommentDetailUI.this.finish();
            AppMethodBeat.o(187666);
          }
        });
      }
      this.xws = ((ListView)findViewById(2131296556));
      this.xws.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187667);
          SnsCommentDetailUI.a(SnsCommentDetailUI.this, SnsCommentDetailUI.a(SnsCommentDetailUI.this).getBottom());
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsCommentDetailUI", "listOriginalBottom: " + SnsCommentDetailUI.d(SnsCommentDetailUI.this));
          AppMethodBeat.o(187667);
        }
      });
      this.xws.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(187668);
          if (paramAnonymousInt2 > 0) {
            if ((paramAnonymousInt1 == 0) && (!SnsCommentDetailUI.x(SnsCommentDetailUI.this)))
            {
              SnsCommentDetailUI.a(SnsCommentDetailUI.this, true);
              if (SnsCommentDetailUI.y(SnsCommentDetailUI.this) != null)
              {
                SnsCommentDetailUI.y(SnsCommentDetailUI.this).refreshView();
                AppMethodBeat.o(187668);
                return;
              }
              if (SnsCommentDetailUI.z(SnsCommentDetailUI.this) != null)
              {
                SnsCommentDetailUI.this.dAW();
                AppMethodBeat.o(187668);
              }
            }
            else if (paramAnonymousInt1 > 0)
            {
              SnsCommentDetailUI.a(SnsCommentDetailUI.this, false);
            }
          }
          AppMethodBeat.o(187668);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(187669);
          if (paramAnonymousInt == 1)
          {
            SnsCommentDetailUI.this.hideVKB();
            SnsCommentDetailUI.A(SnsCommentDetailUI.this);
          }
          if ((paramAnonymousInt == 0) && (SnsCommentDetailUI.f(SnsCommentDetailUI.this) != null)) {
            SnsCommentDetailUI.f(SnsCommentDetailUI.this).pH(true);
          }
          AppMethodBeat.o(187669);
        }
      });
      this.xwo = y.js(getContext()).inflate(2131495538, null);
      this.xwu = this.xwo.findViewById(2131300970);
      this.xwo.setOnClickListener(this.xxq);
      this.xws.addHeaderView(this.xwo);
      boolean bool = dAW();
      if (bool) {
        break label654;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "error isOk setheader ".concat(String.valueOf(bool)));
      finish();
      AppMethodBeat.o(98599);
      return;
      ((TextView)localObject1).setVisibility(8);
      break;
      if (!bt.isNullOrNil(((bpj)localObject1).DND)) {
        ((TextView)localObject2).setText(((bpj)localObject1).DND);
      }
      for (;;)
      {
        findViewById(2131305040).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(2131763943);
      }
      if (!bt.isNullOrNil(((bpj)localObject1).DND)) {
        ((TextView)localObject2).setText(((bpj)localObject1).DND);
      }
      for (;;)
      {
        findViewById(2131305040).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(2131763945);
      }
      if (!bt.isNullOrNil(((bpj)localObject1).DND)) {
        ((TextView)localObject2).setText(((bpj)localObject1).DND);
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
      label637:
      findViewById(2131305039).setVisibility(8);
      i = 0;
    }
    label654:
    localObject1 = qm(false);
    if (localObject1 != null) {
      this.nBH = be.c((com.tencent.mm.plugin.sns.storage.p)localObject1, false);
    }
    if ((this.nBH == 10) && (u.aqG().equals(localp.field_userName)))
    {
      this.xwr = new SnsDetailLuckyHeader(this);
      localObject1 = new AbsListView.LayoutParams(-1, -2);
      this.xwr.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.xwr.setOnClickListener(this.xxq);
    }
    this.xwq = new LinearLayout(getContext());
    localObject1 = new AbsListView.LayoutParams(-1, -2);
    this.xwq.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.xwq.setOnClickListener(this.xxq);
    BackwardSupportUtil.b.g(this, 2.0F);
    localObject1 = new AbsListView.LayoutParams(-1, 1);
    Object localObject2 = new LinearLayout(getContext());
    ((LinearLayout)localObject2).setBackgroundResource(2131234115);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.wCT = ((LinearLayout)localObject2);
    b(localp, true);
    if (this.xwr != null)
    {
      this.xwV = true;
      this.xws.addHeaderView(this.xwr);
    }
    localObject2 = com.tencent.mm.plugin.sns.model.aj.s(localp);
    label1010:
    cuo localcuo;
    label1173:
    long l;
    if (localObject2 == null)
    {
      this.xwq.setVisibility(8);
      this.xwv = new b(new LinkedList(), new LinkedList(), this, localp.dxX());
      this.xws.addHeaderView(this.xwq);
      this.xws.setAdapter(this.xwv);
      this.xlc = ((SnsCommentFooter)findViewById(2131298521));
      if ((localp == null) || (localp.dxy() == null) || (localp.dxy().Etm == null) || ((localp.dxy().Etm.DaD & 0x80) != 0)) {
        break label1699;
      }
      this.xlc.setFeedEmojiCommentEnable(true);
      this.xlc.setTag(localp);
      this.xlc.setOnEditTouchListener(new SnsCommentFooter.a()
      {
        public final void dBa()
        {
          AppMethodBeat.i(187670);
          if (!com.tencent.mm.plugin.sns.lucky.a.m.aoc(localp.dxX()))
          {
            if ((SnsCommentDetailUI.B(SnsCommentDetailUI.this) != null) && (SnsCommentDetailUI.B(SnsCommentDetailUI.this).isShowing()))
            {
              AppMethodBeat.o(187670);
              return;
            }
            SnsCommentDetailUI.a(SnsCommentDetailUI.this, com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.xxw.No(0)));
            AppMethodBeat.o(187670);
            return;
          }
          if ((SnsCommentDetailUI.this.keyboardState() == 1) || (SnsCommentDetailUI.c(SnsCommentDetailUI.this).dBc()))
          {
            AppMethodBeat.o(187670);
            return;
          }
          SnsCommentDetailUI.C(SnsCommentDetailUI.this);
          AppMethodBeat.o(187670);
        }
      });
      this.xlc.setOnSmileyShowListener(new SnsCommentFooter.c()
      {
        public final void onShow()
        {
          AppMethodBeat.i(187671);
          if (SnsCommentDetailUI.c(SnsCommentDetailUI.this).xyq)
          {
            AppMethodBeat.o(187671);
            return;
          }
          SnsCommentDetailUI.C(SnsCommentDetailUI.this);
          AppMethodBeat.o(187671);
        }
      });
      localObject1 = qm(true);
      if ((localObject1 != null) && (!((com.tencent.mm.plugin.sns.storage.p)localObject1).dxW())) {
        this.xlc.setVisibility(8);
      }
      this.xlc.setAfterEditAction(this.xxp);
      this.xlc.dBd();
      this.xlc.setOnCommentSendImp(new SnsCommentFooter.b()
      {
        public final void jj(String paramAnonymousString1, String paramAnonymousString2)
        {
          int j = 8;
          AppMethodBeat.i(187672);
          if (!com.tencent.mm.plugin.sns.lucky.a.m.aoc(localp.dxX()))
          {
            if (SnsCommentDetailUI.this.xxw.No(0) != null) {
              com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.xxw.No(0));
            }
            AppMethodBeat.o(187672);
            return;
          }
          if (localp.Nb(32)) {}
          for (int i = SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentFlag();; i = 0)
          {
            if (com.tencent.mm.plugin.sns.ui.widget.e.hA(i, 8))
            {
              paramAnonymousString1 = paramAnonymousString1.substring(SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentAtPrefix().length());
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "send atFriend ad detail comment");
              am.a.a(localp, 16, paramAnonymousString1, SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentInfo(), i, SnsCommentDetailUI.this.getSource(), paramAnonymousString2);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setText("");
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).qn(false);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "comment send imp!");
              com.tencent.mm.plugin.sns.k.f.wQY.duX().dRu = 3L;
              SnsCommentDetailUI.A(SnsCommentDetailUI.this);
              AppMethodBeat.o(187672);
              return;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "send detail comment");
            com.tencent.mm.plugin.sns.storage.p localp = localp;
            if (localp.Nb(32)) {}
            for (;;)
            {
              am.a.a(localp, j, paramAnonymousString1, SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentInfo(), i, SnsCommentDetailUI.this.getSource(), paramAnonymousString2);
              break;
              j = 2;
            }
          }
        }
      });
      this.xwK = getIntent().getBooleanExtra("INTENT_FROMSUI", false);
      if (this.xwK)
      {
        this.xwL = getIntent().getLongExtra("INTENT_FROMSUI_COMMENTID", 0L);
        if ((this.xwL != 0L) && (this.xwv.commentList != null))
        {
          i = 0;
          if (i < this.xwv.commentList.size())
          {
            localcuo = (cuo)this.xwv.commentList.get(i);
            if (localcuo.Ema == 0) {
              break label1710;
            }
            l = localcuo.Ema;
            label1219:
            if (l != this.xwL) {
              break label1748;
            }
            this.xws.setSelection(i);
            localObject1 = this.xwF.aHY(localcuo.Username);
            if (localObject1 == null) {
              break label1720;
            }
            localObject1 = ((com.tencent.mm.n.b)localObject1).ZX();
            label1265:
            this.xlc.xyh = 0;
            this.xlc.dBe();
            this.xlc.setCommentHint(getString(2131763952) + (String)localObject1);
            this.xlc.setCommentInfo(localcuo);
            if (((SnsObject)localObject2).LikeUserList.size() <= 0) {
              break label1787;
            }
            int j = i + 1;
            i = j;
            if (j > this.xwv.getCount()) {
              i = this.xwv.getCount() - 1;
            }
          }
        }
      }
    }
    label1699:
    label1710:
    label1720:
    label1748:
    label1787:
    for (;;)
    {
      this.xxp.Sb = i;
      if (this.xwK) {
        new com.tencent.mm.sdk.platformtools.ap().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187673);
            SnsCommentDetailUI.this.hideVKB();
            SnsCommentDetailUI.m(SnsCommentDetailUI.this).hr = SnsCommentDetailUI.D(SnsCommentDetailUI.this);
            SnsCommentDetailUI.m(SnsCommentDetailUI.this).run();
            AppMethodBeat.o(187673);
          }
        }, 100L);
      }
      this.xwU = ((SnsTranslateResultView)this.xwo.findViewById(2131305091));
      this.xwU.setResultTextSize(((TextView)this.xwo.findViewById(2131299008)).getTextSize());
      this.xwU.getResultTextView().setBackgroundResource(2131234100);
      localObject1 = new ba(this.dpC, localp.dxX(), false, true, 2);
      this.xwU.getResultTextView().setTag(localObject1);
      this.mVN.c(this.xwU.getResultTextView(), this.xta.xTw, this.xta.xTt);
      if (com.tencent.mm.plugin.sns.model.ap.ev(this.dpC, 4))
      {
        localObject1 = com.tencent.mm.plugin.sns.model.ap.aoL(this.dpC);
        if ((localObject1 != null) && (((ap.b)localObject1).gPQ))
        {
          this.xwU.setVisibility(0);
          this.xwU.a(null, 1, ((ap.b)localObject1).result, ((ap.b)localObject1).gXN, false);
          AppMethodBeat.o(98599);
          return;
          this.xwA = ((SnsObject)localObject2).LikeUserList;
          h(((SnsObject)localObject2).LikeUserList, ((SnsObject)localObject2).CommentUserList.isEmpty());
          if (this.xwr != null) {
            this.xwr.a(localp, this.xta);
          }
          this.xwv = new b(((SnsObject)localObject2).CommentUserList, ((SnsObject)localObject2).LikeUserList, this, localp.dxX());
          if (!this.xxc) {
            break;
          }
          com.tencent.mm.plugin.sns.k.f.wQY.duX().dRs = ((SnsObject)localObject2).CommentUserList.size();
          com.tencent.mm.plugin.sns.k.f.wQY.duX().dRt = ((SnsObject)localObject2).LikeUserList.size();
          break;
          this.xlc.setFeedEmojiCommentEnable(false);
          break label1010;
          l = localcuo.Emc;
          break label1219;
          if (localcuo.Nickname != null)
          {
            localObject1 = localcuo.Nickname;
            break label1265;
          }
          localObject1 = localcuo.Username;
          break label1265;
          i += 1;
          break label1173;
        }
        this.xwU.setVisibility(8);
        AppMethodBeat.o(98599);
        return;
      }
      this.xwU.setVisibility(8);
      AppMethodBeat.o(98599);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98610);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt1 == 15)
    {
      if ((this.xta != null) && (this.xta.xTt != null)) {
        this.xta.xTt.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      AppMethodBeat.o(98610);
      return;
    }
    if (paramInt1 == 16)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "REQUEST_CODE_FOR_FULLSCREEN");
      paramIntent = new hm();
      paramIntent.dle.scene = 1;
      com.tencent.mm.sdk.b.a.ESL.l(paramIntent);
      AppMethodBeat.o(98610);
      return;
    }
    if (paramInt1 == 2333)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        if (!bt.isNullOrNil(paramIntent))
        {
          paramIntent = paramIntent.split(",");
          if (paramIntent.length > 0)
          {
            this.xlc.imP.showVKB();
            String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh(paramIntent[0]);
            if (!bt.isNullOrNil(str))
            {
              this.xlc.dBe();
              this.xlc.setText("@" + str + " ");
              this.xlc.setCommentAtPrefix("@" + str + " ");
              this.xlc.setCommentInfo(new cuo());
              this.xlc.getCommentInfo().Username = paramIntent[0];
              this.xlc.setCommentFlag(8);
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
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.adn(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98609);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = com.tencent.mm.plugin.sns.storage.h.apJ(this.dpC);
    Object localObject = com.tencent.mm.plugin.sns.model.aj.s(paramConfiguration);
    h(((SnsObject)localObject).LikeUserList, ((SnsObject)localObject).CommentUserList.isEmpty());
    if (this.xwr != null) {
      this.xwr.a(paramConfiguration, this.xta);
    }
    paramConfiguration = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    localObject = new Point();
    ((Point)localObject).x = paramConfiguration.widthPixels;
    ((Point)localObject).y = paramConfiguration.heightPixels;
    com.tencent.mm.plugin.sns.model.af.f((Point)localObject);
    if (this.xxw != null)
    {
      this.xwO = com.tencent.mm.plugin.sns.model.af.dtE();
      this.xxw.setImageViewWidth(this.xwO);
    }
    AppMethodBeat.o(98609);
  }
  
  /* Error */
  public void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 2974
    //   3: invokestatic 255	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 2979	com/tencent/mm/pluginsdk/g:o	(Lcom/tencent/mm/ui/MMActivity;)V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 2981	com/tencent/mm/ui/MMActivity:onCreate	(Landroid/os/Bundle;)V
    //   15: aload_0
    //   16: ldc_w 2983
    //   19: invokestatic 2987	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   22: checkcast 2983	com/tencent/mm/plugin/story/api/e
    //   25: invokeinterface 2991 1 0
    //   30: getstatic 2997	com/tencent/mm/plugin/story/api/f$a:ycZ	Lcom/tencent/mm/plugin/story/api/f$a;
    //   33: invokeinterface 3002 2 0
    //   38: putfield 343	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xxe	Z
    //   41: aload_0
    //   42: ldc_w 2983
    //   45: invokestatic 2987	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   48: checkcast 2983	com/tencent/mm/plugin/story/api/e
    //   51: invokeinterface 2991 1 0
    //   56: getstatic 3005	com/tencent/mm/plugin/story/api/f$a:yda	Lcom/tencent/mm/plugin/story/api/f$a;
    //   59: invokeinterface 3002 2 0
    //   64: putfield 345	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xxf	Z
    //   67: aload_0
    //   68: iconst_1
    //   69: invokestatic 3010	com/tencent/mm/ui/b:c	(Landroid/app/Activity;Z)V
    //   72: invokestatic 3014	com/tencent/mm/plugin/sns/model/af:dtk	()Lcom/tencent/mm/plugin/sns/model/am$a;
    //   75: iconst_5
    //   76: ldc_w 3016
    //   79: aload_0
    //   80: invokevirtual 3019	com/tencent/mm/plugin/sns/model/am$a:a	(ILjava/lang/String;Lcom/tencent/mm/plugin/sns/c/i$a;)V
    //   83: aload_0
    //   84: aload_0
    //   85: invokevirtual 3022	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getApplicationContext	()Landroid/content/Context;
    //   88: ldc_w 3024
    //   91: invokevirtual 3025	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   94: checkcast 3027	android/text/ClipboardManager
    //   97: putfield 1222	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:qiE	Landroid/text/ClipboardManager;
    //   100: aload_0
    //   101: aload_0
    //   102: bipush 14
    //   104: invokestatic 3030	com/tencent/mm/ui/ao:fromDPToPix	(Landroid/content/Context;I)I
    //   107: putfield 341	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xxd	I
    //   110: aload_0
    //   111: invokestatic 3036	com/tencent/mm/ui/ai:cf	(Landroid/content/Context;)Landroid/graphics/Point;
    //   114: astore_1
    //   115: aload_0
    //   116: aload_1
    //   117: getfield 2961	android/graphics/Point:x	I
    //   120: putfield 3038	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenWidth	I
    //   123: aload_0
    //   124: aload_1
    //   125: getfield 2966	android/graphics/Point:y	I
    //   128: putfield 3040	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenHeight	I
    //   131: aload_0
    //   132: invokestatic 3046	java/lang/System:currentTimeMillis	()J
    //   135: putfield 289	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwm	J
    //   138: aload_0
    //   139: new 1620	com/tencent/mm/ui/widget/b/a
    //   142: dup
    //   143: aload_0
    //   144: invokespecial 3047	com/tencent/mm/ui/widget/b/a:<init>	(Landroid/content/Context;)V
    //   147: putfield 670	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mVN	Lcom/tencent/mm/ui/widget/b/a;
    //   150: aload_0
    //   151: aload_0
    //   152: invokevirtual 2312	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   155: ldc_w 3049
    //   158: iconst_0
    //   159: invokevirtual 3053	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   162: putfield 2661	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xxb	I
    //   165: aload_0
    //   166: aload_0
    //   167: invokevirtual 2312	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   170: ldc_w 3055
    //   173: iconst_0
    //   174: invokevirtual 2320	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   177: putfield 339	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xxc	Z
    //   180: aload_0
    //   181: getfield 339	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xxc	Z
    //   184: ifeq +10 -> 194
    //   187: getstatic 593	com/tencent/mm/plugin/sns/k/f:wQY	Lcom/tencent/mm/plugin/sns/k/f;
    //   190: invokevirtual 3058	com/tencent/mm/plugin/sns/k/f:duZ	()Lcom/tencent/mm/g/b/a/ck;
    //   193: pop
    //   194: aload_0
    //   195: aload_0
    //   196: invokevirtual 2312	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   199: ldc_w 3060
    //   202: invokevirtual 2867	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   205: ldc_w 313
    //   208: invokestatic 1506	com/tencent/mm/sdk/platformtools/bt:by	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   211: putfield 515	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dpC	Ljava/lang/String;
    //   214: aload_0
    //   215: getfield 515	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dpC	Ljava/lang/String;
    //   218: invokestatic 854	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   221: ifeq +24 -> 245
    //   224: aload_0
    //   225: ldc_w 3062
    //   228: aload_0
    //   229: invokevirtual 2312	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   232: ldc_w 3060
    //   235: lconst_0
    //   236: invokevirtual 2782	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   239: invokestatic 3066	com/tencent/mm/plugin/sns/storage/x:bh	(Ljava/lang/String;J)Ljava/lang/String;
    //   242: putfield 515	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dpC	Ljava/lang/String;
    //   245: aload_0
    //   246: aload_0
    //   247: invokevirtual 2312	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   250: ldc_w 3068
    //   253: invokevirtual 2867	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   256: ldc_w 313
    //   259: invokestatic 1506	com/tencent/mm/sdk/platformtools/bt:by	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   262: putfield 804	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwE	Ljava/lang/String;
    //   265: aload_0
    //   266: getfield 804	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwE	Ljava/lang/String;
    //   269: invokestatic 854	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   272: ifeq +32 -> 304
    //   275: aload_0
    //   276: invokevirtual 2312	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   279: ldc_w 3068
    //   282: iconst_m1
    //   283: invokevirtual 3053	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   286: istore_2
    //   287: iload_2
    //   288: iconst_m1
    //   289: if_icmpeq +15 -> 304
    //   292: aload_0
    //   293: ldc_w 3062
    //   296: iload_2
    //   297: i2l
    //   298: invokestatic 3066	com/tencent/mm/plugin/sns/storage/x:bh	(Ljava/lang/String;J)Ljava/lang/String;
    //   301: putfield 804	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwE	Ljava/lang/String;
    //   304: aload_0
    //   305: new 78	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$4
    //   308: dup
    //   309: aload_0
    //   310: aload_0
    //   311: invokevirtual 579	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   314: aload_0
    //   315: aload_0
    //   316: getfield 356	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xxi	Lcom/tencent/mm/plugin/sns/model/ag;
    //   319: invokespecial 3071	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$4:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;ILandroid/app/Activity;Lcom/tencent/mm/plugin/sns/model/ae;)V
    //   322: putfield 548	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xta	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   325: aload_0
    //   326: ldc_w 1637
    //   329: invokevirtual 948	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:findViewById	(I)Landroid/view/View;
    //   332: checkcast 2189	android/widget/FrameLayout
    //   335: astore_1
    //   336: aload_0
    //   337: new 3073	com/tencent/mm/plugin/sns/i/b
    //   340: dup
    //   341: aload_0
    //   342: aload_0
    //   343: getfield 548	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xta	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   346: aload_1
    //   347: invokespecial 3076	com/tencent/mm/plugin/sns/i/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/b;Landroid/widget/FrameLayout;)V
    //   350: putfield 3078	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xll	Lcom/tencent/mm/plugin/sns/i/b;
    //   353: aload_0
    //   354: new 3080	com/tencent/mm/plugin/sns/ui/b
    //   357: dup
    //   358: aload_0
    //   359: aload_0
    //   360: getfield 548	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xta	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   363: aload_1
    //   364: aload_0
    //   365: getfield 3078	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xll	Lcom/tencent/mm/plugin/sns/i/b;
    //   368: invokespecial 3083	com/tencent/mm/plugin/sns/ui/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/b;Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/sns/i/b;)V
    //   371: putfield 1230	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xlk	Lcom/tencent/mm/plugin/sns/ui/b;
    //   374: aload_0
    //   375: new 3085	com/tencent/mm/plugin/sns/ui/aj
    //   378: dup
    //   379: aload_0
    //   380: aload_0
    //   381: getfield 548	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xta	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   384: aload_1
    //   385: invokespecial 3086	com/tencent/mm/plugin/sns/ui/aj:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/b;Landroid/widget/FrameLayout;)V
    //   388: putfield 1286	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xlm	Lcom/tencent/mm/plugin/sns/ui/aj;
    //   391: aload_0
    //   392: new 3088	com/tencent/mm/plugin/sns/ui/bo
    //   395: dup
    //   396: aload_0
    //   397: aload_0
    //   398: getfield 548	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xta	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   401: aload_1
    //   402: invokespecial 3089	com/tencent/mm/plugin/sns/ui/bo:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/b;Landroid/widget/FrameLayout;)V
    //   405: putfield 2657	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xln	Lcom/tencent/mm/plugin/sns/ui/bo;
    //   408: aload_0
    //   409: getfield 548	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xta	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   412: invokevirtual 3092	com/tencent/mm/plugin/sns/ui/d/b:cIt	()V
    //   415: aload_0
    //   416: aload_0
    //   417: invokevirtual 2312	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   420: ldc_w 3094
    //   423: iconst_0
    //   424: invokevirtual 2320	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   427: putfield 333	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwY	Z
    //   430: aload_0
    //   431: aload_0
    //   432: invokevirtual 2312	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   435: ldc_w 3096
    //   438: invokevirtual 2867	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   441: putfield 335	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwZ	Ljava/lang/String;
    //   444: aload_0
    //   445: new 1016	com/tencent/mm/plugin/sns/ui/bl
    //   448: dup
    //   449: aload_0
    //   450: new 86	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$5
    //   453: dup
    //   454: aload_0
    //   455: invokespecial 3097	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$5:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   458: aload_0
    //   459: invokevirtual 579	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   462: aload_0
    //   463: getfield 356	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xxi	Lcom/tencent/mm/plugin/sns/model/ag;
    //   466: invokespecial 3100	com/tencent/mm/plugin/sns/ui/bl:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/bl$a;ILcom/tencent/mm/plugin/sns/model/ae;)V
    //   469: putfield 1212	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwM	Lcom/tencent/mm/plugin/sns/ui/bl;
    //   472: invokestatic 3046	java/lang/System:currentTimeMillis	()J
    //   475: lstore_3
    //   476: aload_0
    //   477: invokevirtual 2312	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   480: ldc_w 3102
    //   483: invokevirtual 3106	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   486: astore_1
    //   487: aload_1
    //   488: ifnull +184 -> 672
    //   491: new 461	com/tencent/mm/protocal/protobuf/TimeLineObject
    //   494: dup
    //   495: invokespecial 3107	com/tencent/mm/protocal/protobuf/TimeLineObject:<init>	()V
    //   498: astore 6
    //   500: aload 6
    //   502: aload_1
    //   503: invokevirtual 3111	com/tencent/mm/protocal/protobuf/TimeLineObject:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   506: pop
    //   507: invokestatic 3115	com/tencent/mm/plugin/sns/model/af:dtu	()Lcom/tencent/mm/plugin/sns/storage/q;
    //   510: new 3117	java/math/BigInteger
    //   513: dup
    //   514: aload 6
    //   516: getfield 2308	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   519: invokespecial 3118	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   522: invokevirtual 3121	java/math/BigInteger:longValue	()J
    //   525: invokevirtual 3127	com/tencent/mm/plugin/sns/storage/q:th	(J)Lcom/tencent/mm/plugin/sns/storage/p;
    //   528: ifnonnull +748 -> 1276
    //   531: ldc_w 1075
    //   534: ldc_w 3129
    //   537: invokestatic 1317	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: new 451	com/tencent/mm/plugin/sns/storage/p
    //   543: dup
    //   544: invokespecial 3130	com/tencent/mm/plugin/sns/storage/p:<init>	()V
    //   547: astore_1
    //   548: aload_1
    //   549: new 3117	java/math/BigInteger
    //   552: dup
    //   553: aload 6
    //   555: getfield 2308	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   558: invokespecial 3118	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   561: invokevirtual 3121	java/math/BigInteger:longValue	()J
    //   564: putfield 1577	com/tencent/mm/plugin/sns/storage/p:field_snsId	J
    //   567: aload_1
    //   568: aload 6
    //   570: invokevirtual 3134	com/tencent/mm/protocal/protobuf/TimeLineObject:toByteArray	()[B
    //   573: putfield 3138	com/tencent/mm/plugin/sns/storage/p:field_content	[B
    //   576: aload_1
    //   577: aload 6
    //   579: getfield 2404	com/tencent/mm/protocal/protobuf/TimeLineObject:CreateTime	I
    //   582: putfield 3141	com/tencent/mm/plugin/sns/storage/p:field_createTime	I
    //   585: aload_1
    //   586: aload 6
    //   588: getfield 2033	com/tencent/mm/protocal/protobuf/TimeLineObject:mAQ	Ljava/lang/String;
    //   591: putfield 822	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
    //   594: aload_1
    //   595: aload 6
    //   597: getfield 465	com/tencent/mm/protocal/protobuf/TimeLineObject:Etm	Lcom/tencent/mm/protocal/protobuf/yk;
    //   600: getfield 688	com/tencent/mm/protocal/protobuf/yk:DaB	I
    //   603: putfield 3144	com/tencent/mm/plugin/sns/storage/p:field_type	I
    //   606: aload_1
    //   607: invokevirtual 3147	com/tencent/mm/plugin/sns/storage/p:dxU	()V
    //   610: new 529	com/tencent/mm/protocal/protobuf/SnsObject
    //   613: dup
    //   614: invokespecial 3148	com/tencent/mm/protocal/protobuf/SnsObject:<init>	()V
    //   617: astore 6
    //   619: aload 6
    //   621: new 3150	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   624: dup
    //   625: invokespecial 3151	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   628: putfield 3155	com/tencent/mm/protocal/protobuf/SnsObject:ObjectDesc	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   631: aload_1
    //   632: aload 6
    //   634: invokevirtual 3156	com/tencent/mm/protocal/protobuf/SnsObject:toByteArray	()[B
    //   637: putfield 3159	com/tencent/mm/plugin/sns/storage/p:field_attrBuf	[B
    //   640: invokestatic 3115	com/tencent/mm/plugin/sns/model/af:dtu	()Lcom/tencent/mm/plugin/sns/storage/q;
    //   643: aload_1
    //   644: invokevirtual 3163	com/tencent/mm/plugin/sns/storage/q:insert	(Lcom/tencent/mm/sdk/e/c;)Z
    //   647: pop
    //   648: ldc_w 3165
    //   651: ldc_w 3167
    //   654: iconst_1
    //   655: anewarray 1079	java/lang/Object
    //   658: dup
    //   659: iconst_0
    //   660: invokestatic 3046	java/lang/System:currentTimeMillis	()J
    //   663: lload_3
    //   664: lsub
    //   665: invokestatic 1582	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   668: aastore
    //   669: invokestatic 1493	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   672: aload_0
    //   673: iconst_1
    //   674: invokespecial 449	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:qm	(Z)Lcom/tencent/mm/plugin/sns/storage/p;
    //   677: astore_1
    //   678: ldc_w 1075
    //   681: new 809	java/lang/StringBuilder
    //   684: dup
    //   685: ldc_w 3169
    //   688: invokespecial 1360	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   691: aload_0
    //   692: getfield 515	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dpC	Ljava/lang/String;
    //   695: invokevirtual 815	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: ldc_w 3171
    //   701: invokevirtual 815	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload_0
    //   705: getfield 804	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwE	Ljava/lang/String;
    //   708: invokevirtual 815	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: invokevirtual 819	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokestatic 1317	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   717: aload_1
    //   718: ifnull +29 -> 747
    //   721: ldc_w 1075
    //   724: ldc_w 3173
    //   727: iconst_1
    //   728: anewarray 1079	java/lang/Object
    //   731: dup
    //   732: iconst_0
    //   733: aload_1
    //   734: getfield 822	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
    //   737: ldc_w 313
    //   740: invokestatic 1506	com/tencent/mm/sdk/platformtools/bt:by	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   743: aastore
    //   744: invokestatic 1493	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   747: aload_0
    //   748: getfield 515	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dpC	Ljava/lang/String;
    //   751: invokestatic 566	com/tencent/mm/plugin/sns/storage/x:aqh	(Ljava/lang/String;)Z
    //   754: ifeq +56 -> 810
    //   757: aload_0
    //   758: getfield 515	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dpC	Ljava/lang/String;
    //   761: invokestatic 3176	com/tencent/mm/plugin/sns/storage/x:anq	(Ljava/lang/String;)Z
    //   764: ifeq +556 -> 1320
    //   767: aload_1
    //   768: ifnull +520 -> 1288
    //   771: aload_1
    //   772: getfield 822	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
    //   775: invokestatic 3181	com/tencent/mm/model/w:sC	(Ljava/lang/String;)Z
    //   778: ifne +32 -> 810
    //   781: invokestatic 1460	com/tencent/mm/kernel/g:afC	()Lcom/tencent/mm/kernel/g;
    //   784: pop
    //   785: invokestatic 3185	com/tencent/mm/kernel/g:afA	()Lcom/tencent/mm/kernel/b;
    //   788: getfield 3191	com/tencent/mm/kernel/b:gcy	Lcom/tencent/mm/al/q;
    //   791: new 3193	com/tencent/mm/plugin/sns/model/p
    //   794: dup
    //   795: aload_0
    //   796: getfield 515	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dpC	Ljava/lang/String;
    //   799: invokestatic 3197	com/tencent/mm/plugin/sns/storage/x:anz	(Ljava/lang/String;)J
    //   802: invokespecial 3199	com/tencent/mm/plugin/sns/model/p:<init>	(J)V
    //   805: iconst_0
    //   806: invokevirtual 3204	com/tencent/mm/al/q:a	(Lcom/tencent/mm/al/n;I)Z
    //   809: pop
    //   810: invokestatic 1460	com/tencent/mm/kernel/g:afC	()Lcom/tencent/mm/kernel/g;
    //   813: pop
    //   814: invokestatic 3185	com/tencent/mm/kernel/g:afA	()Lcom/tencent/mm/kernel/b;
    //   817: getfield 3191	com/tencent/mm/kernel/b:gcy	Lcom/tencent/mm/al/q;
    //   820: sipush 210
    //   823: aload_0
    //   824: invokevirtual 3207	com/tencent/mm/al/q:a	(ILcom/tencent/mm/al/g;)V
    //   827: invokestatic 1460	com/tencent/mm/kernel/g:afC	()Lcom/tencent/mm/kernel/g;
    //   830: pop
    //   831: invokestatic 3185	com/tencent/mm/kernel/g:afA	()Lcom/tencent/mm/kernel/b;
    //   834: getfield 3191	com/tencent/mm/kernel/b:gcy	Lcom/tencent/mm/al/q;
    //   837: sipush 218
    //   840: aload_0
    //   841: invokevirtual 3207	com/tencent/mm/al/q:a	(ILcom/tencent/mm/al/g;)V
    //   844: invokestatic 1460	com/tencent/mm/kernel/g:afC	()Lcom/tencent/mm/kernel/g;
    //   847: pop
    //   848: invokestatic 3185	com/tencent/mm/kernel/g:afA	()Lcom/tencent/mm/kernel/b;
    //   851: getfield 3191	com/tencent/mm/kernel/b:gcy	Lcom/tencent/mm/al/q;
    //   854: sipush 213
    //   857: aload_0
    //   858: invokevirtual 3207	com/tencent/mm/al/q:a	(ILcom/tencent/mm/al/g;)V
    //   861: invokestatic 1460	com/tencent/mm/kernel/g:afC	()Lcom/tencent/mm/kernel/g;
    //   864: pop
    //   865: invokestatic 3185	com/tencent/mm/kernel/g:afA	()Lcom/tencent/mm/kernel/b;
    //   868: getfield 3191	com/tencent/mm/kernel/b:gcy	Lcom/tencent/mm/al/q;
    //   871: sipush 682
    //   874: aload_0
    //   875: invokevirtual 3207	com/tencent/mm/al/q:a	(ILcom/tencent/mm/al/g;)V
    //   878: invokestatic 1460	com/tencent/mm/kernel/g:afC	()Lcom/tencent/mm/kernel/g;
    //   881: pop
    //   882: invokestatic 3185	com/tencent/mm/kernel/g:afA	()Lcom/tencent/mm/kernel/b;
    //   885: getfield 3191	com/tencent/mm/kernel/b:gcy	Lcom/tencent/mm/al/q;
    //   888: sipush 214
    //   891: aload_0
    //   892: invokevirtual 3207	com/tencent/mm/al/q:a	(ILcom/tencent/mm/al/g;)V
    //   895: invokestatic 1460	com/tencent/mm/kernel/g:afC	()Lcom/tencent/mm/kernel/g;
    //   898: pop
    //   899: invokestatic 3185	com/tencent/mm/kernel/g:afA	()Lcom/tencent/mm/kernel/b;
    //   902: getfield 3191	com/tencent/mm/kernel/b:gcy	Lcom/tencent/mm/al/q;
    //   905: sipush 683
    //   908: aload_0
    //   909: invokevirtual 3207	com/tencent/mm/al/q:a	(ILcom/tencent/mm/al/g;)V
    //   912: aload_0
    //   913: invokestatic 3210	com/tencent/mm/plugin/sns/model/af:dti	()Lcom/tencent/mm/storage/bg;
    //   916: putfield 2552	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwF	Lcom/tencent/mm/storage/bg;
    //   919: aload_0
    //   920: new 3212	com/tencent/mm/plugin/sns/ui/av
    //   923: dup
    //   924: aload_0
    //   925: invokespecial 3215	com/tencent/mm/plugin/sns/ui/av:<init>	(Landroid/app/Activity;)V
    //   928: putfield 1226	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xle	Lcom/tencent/mm/plugin/sns/ui/av;
    //   931: aload_0
    //   932: new 693	com/tencent/mm/plugin/sns/ui/ay
    //   935: dup
    //   936: aload_0
    //   937: invokevirtual 773	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
    //   940: invokespecial 3216	com/tencent/mm/plugin/sns/ui/ay:<init>	(Landroid/content/Context;)V
    //   943: putfield 555	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwD	Lcom/tencent/mm/plugin/sns/ui/ay;
    //   946: aload_0
    //   947: new 3218	com/tencent/mm/plugin/sns/ui/j
    //   950: dup
    //   951: aload_0
    //   952: aload_0
    //   953: invokevirtual 579	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   956: aload_0
    //   957: getfield 356	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xxi	Lcom/tencent/mm/plugin/sns/model/ag;
    //   960: invokespecial 3221	com/tencent/mm/plugin/sns/ui/j:<init>	(Landroid/app/Activity;ILcom/tencent/mm/plugin/sns/model/ae;)V
    //   963: putfield 646	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwI	Lcom/tencent/mm/plugin/sns/ui/j;
    //   966: aload_0
    //   967: new 3223	com/tencent/mm/plugin/sns/ui/l
    //   970: dup
    //   971: aload_0
    //   972: invokespecial 3226	com/tencent/mm/plugin/sns/ui/l:<init>	(Lcom/tencent/mm/plugin/sns/ui/z;)V
    //   975: putfield 3228	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwJ	Lcom/tencent/mm/plugin/sns/ui/l;
    //   978: aload_1
    //   979: ifnull +76 -> 1055
    //   982: aload_0
    //   983: aload_1
    //   984: iconst_0
    //   985: invokestatic 1373	com/tencent/mm/plugin/sns/ui/be:c	(Lcom/tencent/mm/plugin/sns/storage/p;Z)I
    //   988: putfield 551	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:nBH	I
    //   991: getstatic 593	com/tencent/mm/plugin/sns/k/f:wQY	Lcom/tencent/mm/plugin/sns/k/f;
    //   994: invokestatic 3046	java/lang/System:currentTimeMillis	()J
    //   997: putfield 3231	com/tencent/mm/plugin/sns/k/f:wRv	J
    //   1000: getstatic 593	com/tencent/mm/plugin/sns/k/f:wQY	Lcom/tencent/mm/plugin/sns/k/f;
    //   1003: astore 6
    //   1005: aload_1
    //   1006: ifnull +40 -> 1046
    //   1009: aload_1
    //   1010: getfield 1577	com/tencent/mm/plugin/sns/storage/p:field_snsId	J
    //   1013: invokestatic 3235	com/tencent/mm/plugin/sns/data/q:su	(J)Ljava/lang/String;
    //   1016: astore 7
    //   1018: aload 6
    //   1020: getfield 3238	com/tencent/mm/plugin/sns/k/f:wRp	Ljava/util/List;
    //   1023: aload 7
    //   1025: invokeinterface 3241 2 0
    //   1030: ifne +16 -> 1046
    //   1033: aload 6
    //   1035: getfield 3238	com/tencent/mm/plugin/sns/k/f:wRp	Ljava/util/List;
    //   1038: aload 7
    //   1040: invokeinterface 2007 2 0
    //   1045: pop
    //   1046: getstatic 593	com/tencent/mm/plugin/sns/k/f:wQY	Lcom/tencent/mm/plugin/sns/k/f;
    //   1049: invokestatic 3046	java/lang/System:currentTimeMillis	()J
    //   1052: putfield 3244	com/tencent/mm/plugin/sns/k/f:wRC	J
    //   1055: aload_1
    //   1056: ifnull +69 -> 1125
    //   1059: aload_1
    //   1060: bipush 32
    //   1062: invokevirtual 455	com/tencent/mm/plugin/sns/storage/p:Nb	(I)Z
    //   1065: ifeq +60 -> 1125
    //   1068: aload_0
    //   1069: getfield 2661	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xxb	I
    //   1072: bipush 16
    //   1074: if_icmpne +287 -> 1361
    //   1077: aload_0
    //   1078: new 2234	com/tencent/mm/plugin/sns/a/b/i
    //   1081: dup
    //   1082: iconst_2
    //   1083: invokespecial 3246	com/tencent/mm/plugin/sns/a/b/i:<init>	(I)V
    //   1086: putfield 1031	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwT	Lcom/tencent/mm/plugin/sns/a/b/i;
    //   1089: aload_0
    //   1090: getfield 1031	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwT	Lcom/tencent/mm/plugin/sns/a/b/i;
    //   1093: aload_0
    //   1094: getfield 3040	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenHeight	I
    //   1097: aload_0
    //   1098: invokevirtual 3250	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSupportActionBar	()Landroid/support/v7/app/ActionBar;
    //   1101: invokevirtual 3255	android/support/v7/app/ActionBar:getCustomView	()Landroid/view/View;
    //   1104: aload_0
    //   1105: invokevirtual 3258	com/tencent/mm/plugin/sns/a/b/i:a	(ILandroid/view/View;Landroid/app/Activity;)V
    //   1108: aload_1
    //   1109: iconst_0
    //   1110: invokestatic 1373	com/tencent/mm/plugin/sns/ui/be:c	(Lcom/tencent/mm/plugin/sns/storage/p;Z)I
    //   1113: pop
    //   1114: aload_0
    //   1115: getfield 548	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xta	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   1118: aload_0
    //   1119: getfield 1031	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwT	Lcom/tencent/mm/plugin/sns/a/b/i;
    //   1122: invokevirtual 3261	com/tencent/mm/plugin/sns/ui/d/b:b	(Lcom/tencent/mm/plugin/sns/a/b/i;)V
    //   1125: aload_0
    //   1126: invokevirtual 3263	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:initView	()V
    //   1129: aload_1
    //   1130: ifnull +49 -> 1179
    //   1133: aload_1
    //   1134: bipush 32
    //   1136: invokevirtual 455	com/tencent/mm/plugin/sns/storage/p:Nb	(I)Z
    //   1139: ifeq +40 -> 1179
    //   1142: aload_1
    //   1143: invokestatic 527	com/tencent/mm/plugin/sns/model/aj:s	(Lcom/tencent/mm/plugin/sns/storage/p;)Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   1146: astore 6
    //   1148: aload_0
    //   1149: getfield 1031	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwT	Lcom/tencent/mm/plugin/sns/a/b/i;
    //   1152: iconst_0
    //   1153: aload_1
    //   1154: invokevirtual 866	com/tencent/mm/plugin/sns/storage/p:dxX	()Ljava/lang/String;
    //   1157: aload_1
    //   1158: invokevirtual 3266	com/tencent/mm/plugin/sns/storage/p:dxT	()Z
    //   1161: aload_0
    //   1162: getfield 1346	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwo	Landroid/view/View;
    //   1165: aload_1
    //   1166: getfield 1577	com/tencent/mm/plugin/sns/storage/p:field_snsId	J
    //   1169: aload 6
    //   1171: aload_0
    //   1172: getfield 551	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:nBH	I
    //   1175: iconst_2
    //   1176: invokevirtual 3269	com/tencent/mm/plugin/sns/a/b/i:a	(ILjava/lang/String;ZLandroid/view/View;JLcom/tencent/mm/protocal/protobuf/SnsObject;II)V
    //   1179: aload_0
    //   1180: getfield 1346	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwo	Landroid/view/View;
    //   1183: ifnull +79 -> 1262
    //   1186: aload_1
    //   1187: ifnull +75 -> 1262
    //   1190: aload_0
    //   1191: getfield 1346	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwo	Landroid/view/View;
    //   1194: ldc_w 2072
    //   1197: invokevirtual 1375	android/view/View:findViewById	(I)Landroid/view/View;
    //   1200: checkcast 3271	com/tencent/mm/plugin/sight/decode/a/a
    //   1203: astore 6
    //   1205: aload_1
    //   1206: invokevirtual 459	com/tencent/mm/plugin/sns/storage/p:dxy	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1209: getfield 465	com/tencent/mm/protocal/protobuf/TimeLineObject:Etm	Lcom/tencent/mm/protocal/protobuf/yk;
    //   1212: ifnull +339 -> 1551
    //   1215: aload_1
    //   1216: invokevirtual 459	com/tencent/mm/plugin/sns/storage/p:dxy	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1219: getfield 465	com/tencent/mm/protocal/protobuf/TimeLineObject:Etm	Lcom/tencent/mm/protocal/protobuf/yk;
    //   1222: getfield 688	com/tencent/mm/protocal/protobuf/yk:DaB	I
    //   1225: bipush 15
    //   1227: if_icmpne +324 -> 1551
    //   1230: aload 6
    //   1232: instanceof 2164
    //   1235: ifeq +316 -> 1551
    //   1238: aload 6
    //   1240: checkcast 2164	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView
    //   1243: getfield 3275	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView:wsq	Lcom/tencent/mm/plugin/sight/decode/a/b;
    //   1246: invokevirtual 3280	com/tencent/mm/plugin/sight/decode/a/b:dqq	()Z
    //   1249: istore 5
    //   1251: aload_1
    //   1252: iconst_1
    //   1253: iload 5
    //   1255: aload_0
    //   1256: invokevirtual 579	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   1259: invokestatic 3285	com/tencent/mm/plugin/sns/a/b/m:a	(Lcom/tencent/mm/plugin/sns/storage/p;ZZI)V
    //   1262: aload_0
    //   1263: getfield 676	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xws	Landroid/widget/ListView;
    //   1266: ifnonnull +110 -> 1376
    //   1269: ldc_w 2974
    //   1272: invokestatic 284	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1275: return
    //   1276: ldc_w 1075
    //   1279: ldc_w 3287
    //   1282: invokestatic 1317	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1285: goto -613 -> 672
    //   1288: invokestatic 1460	com/tencent/mm/kernel/g:afC	()Lcom/tencent/mm/kernel/g;
    //   1291: pop
    //   1292: invokestatic 3185	com/tencent/mm/kernel/g:afA	()Lcom/tencent/mm/kernel/b;
    //   1295: getfield 3191	com/tencent/mm/kernel/b:gcy	Lcom/tencent/mm/al/q;
    //   1298: new 3193	com/tencent/mm/plugin/sns/model/p
    //   1301: dup
    //   1302: aload_0
    //   1303: getfield 515	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dpC	Ljava/lang/String;
    //   1306: invokestatic 3197	com/tencent/mm/plugin/sns/storage/x:anz	(Ljava/lang/String;)J
    //   1309: invokespecial 3199	com/tencent/mm/plugin/sns/model/p:<init>	(J)V
    //   1312: iconst_0
    //   1313: invokevirtual 3204	com/tencent/mm/al/q:a	(Lcom/tencent/mm/al/n;I)Z
    //   1316: pop
    //   1317: goto -507 -> 810
    //   1320: invokestatic 1460	com/tencent/mm/kernel/g:afC	()Lcom/tencent/mm/kernel/g;
    //   1323: pop
    //   1324: invokestatic 3185	com/tencent/mm/kernel/g:afA	()Lcom/tencent/mm/kernel/b;
    //   1327: getfield 3191	com/tencent/mm/kernel/b:gcy	Lcom/tencent/mm/al/q;
    //   1330: new 3289	com/tencent/mm/plugin/sns/model/l
    //   1333: dup
    //   1334: aload_0
    //   1335: getfield 515	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dpC	Ljava/lang/String;
    //   1338: invokestatic 3197	com/tencent/mm/plugin/sns/storage/x:anz	(Ljava/lang/String;)J
    //   1341: iconst_0
    //   1342: aload_0
    //   1343: aload_1
    //   1344: invokespecial 682	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:f	(Lcom/tencent/mm/plugin/sns/storage/p;)Lcom/tencent/mm/plugin/sns/storage/a;
    //   1347: getfield 3292	com/tencent/mm/plugin/sns/storage/a:wSr	Ljava/lang/String;
    //   1350: invokespecial 3295	com/tencent/mm/plugin/sns/model/l:<init>	(JILjava/lang/String;)V
    //   1353: iconst_0
    //   1354: invokevirtual 3204	com/tencent/mm/al/q:a	(Lcom/tencent/mm/al/n;I)Z
    //   1357: pop
    //   1358: goto -548 -> 810
    //   1361: aload_0
    //   1362: new 2234	com/tencent/mm/plugin/sns/a/b/i
    //   1365: dup
    //   1366: iconst_1
    //   1367: invokespecial 3246	com/tencent/mm/plugin/sns/a/b/i:<init>	(I)V
    //   1370: putfield 1031	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xwT	Lcom/tencent/mm/plugin/sns/a/b/i;
    //   1373: goto -284 -> 1089
    //   1376: aload_0
    //   1377: getfield 676	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xws	Landroid/widget/ListView;
    //   1380: new 88	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$6
    //   1383: dup
    //   1384: aload_0
    //   1385: invokespecial 3296	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$6:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   1388: invokevirtual 3297	android/widget/ListView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1391: aload_0
    //   1392: new 3299	com/tencent/mm/plugin/sns/ui/n
    //   1395: dup
    //   1396: aload_0
    //   1397: invokespecial 3300	com/tencent/mm/plugin/sns/ui/n:<init>	(Landroid/content/Context;)V
    //   1400: putfield 347	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xxg	Lcom/tencent/mm/plugin/sns/ui/n;
    //   1403: aload_1
    //   1404: ifnull +34 -> 1438
    //   1407: aload_0
    //   1408: getfield 1192	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:fki	Ljava/lang/String;
    //   1411: aload_1
    //   1412: getfield 822	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
    //   1415: invokestatic 1679	com/tencent/mm/sdk/platformtools/bt:kU	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1418: ifeq +20 -> 1438
    //   1421: aload_0
    //   1422: iconst_0
    //   1423: ldc_w 3301
    //   1426: new 3303	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7
    //   1429: dup
    //   1430: aload_0
    //   1431: aload_1
    //   1432: invokespecial 3304	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;Lcom/tencent/mm/plugin/sns/storage/p;)V
    //   1435: invokevirtual 3308	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:addIconOptionMenu	(IILandroid/view/MenuItem$OnMenuItemClickListener;)V
    //   1438: getstatic 2859	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   1441: aload_0
    //   1442: getfield 393	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:jBI	Lcom/tencent/mm/sdk/b/c;
    //   1445: invokevirtual 3311	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1448: pop
    //   1449: getstatic 2859	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   1452: aload_0
    //   1453: getfield 361	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xxj	Lcom/tencent/mm/sdk/b/c;
    //   1456: invokevirtual 3311	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1459: pop
    //   1460: getstatic 2859	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   1463: aload_0
    //   1464: getfield 364	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xxk	Lcom/tencent/mm/sdk/b/c;
    //   1467: invokevirtual 3311	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1470: pop
    //   1471: getstatic 2859	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   1474: aload_0
    //   1475: getfield 367	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xxl	Lcom/tencent/mm/sdk/b/c;
    //   1478: invokevirtual 3311	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1481: pop
    //   1482: getstatic 2859	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   1485: aload_0
    //   1486: getfield 370	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xxm	Lcom/tencent/mm/sdk/b/c;
    //   1489: invokevirtual 3311	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1492: pop
    //   1493: getstatic 2859	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   1496: aload_0
    //   1497: getfield 390	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xxr	Lcom/tencent/mm/sdk/b/c;
    //   1500: invokevirtual 3311	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1503: pop
    //   1504: getstatic 2859	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   1507: aload_0
    //   1508: getfield 398	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xxs	Lcom/tencent/mm/sdk/b/c;
    //   1511: invokevirtual 3311	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1514: pop
    //   1515: getstatic 2859	com/tencent/mm/sdk/b/a:ESL	Lcom/tencent/mm/sdk/b/a;
    //   1518: aload_0
    //   1519: getfield 373	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xlr	Lcom/tencent/mm/sdk/b/c;
    //   1522: invokevirtual 3311	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1525: pop
    //   1526: aload_0
    //   1527: invokestatic 3313	com/tencent/mm/pluginsdk/g:p	(Lcom/tencent/mm/ui/MMActivity;)V
    //   1530: ldc_w 2974
    //   1533: invokestatic 284	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1536: return
    //   1537: astore_1
    //   1538: goto -866 -> 672
    //   1541: astore 6
    //   1543: goto -903 -> 640
    //   1546: astore 7
    //   1548: goto -972 -> 576
    //   1551: iconst_0
    //   1552: istore 5
    //   1554: goto -303 -> 1251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1557	0	this	SnsCommentDetailUI
    //   0	1557	1	paramBundle	Bundle
    //   286	11	2	i	int
    //   475	189	3	l	long
    //   1249	304	5	bool	boolean
    //   498	741	6	localObject	Object
    //   1541	1	6	localIOException	java.io.IOException
    //   1016	23	7	str	String
    //   1546	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   500	507	1537	java/io/IOException
    //   631	640	1541	java/io/IOException
    //   567	576	1546	java/lang/Exception
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98596);
    com.tencent.mm.plugin.sns.model.af.dtk().a(this, 5);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(210, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(218, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(213, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(214, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(683, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(682, this);
    com.tencent.mm.plugin.sns.model.af.dtr().az(this);
    com.tencent.mm.sdk.b.a.ESL.d(this.jBI);
    if (this.xwI != null) {
      this.xwI.activity = null;
    }
    ad.dzp();
    if (this.xlc != null) {
      this.xlc.dBh();
    }
    com.tencent.mm.plugin.sns.storage.p localp = qm(false);
    Object localObject;
    if ((localp != null) && (localp.Nb(32)))
    {
      if (this.xwT != null) {
        this.xwT.o(0, localp.dxX(), 2);
      }
      localObject = f(localp);
      if (localObject != null) {
        break label610;
      }
      localObject = "";
      if (!localp.dvv()) {
        break label618;
      }
      com.tencent.mm.plugin.sns.model.af.dto().f(14652, new Object[] { com.tencent.mm.plugin.sns.a.b.h.a(localp.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.q.st(localp.field_snsId), localObject, Long.valueOf(this.xwm), Long.valueOf(System.currentTimeMillis()) }) });
    }
    for (;;)
    {
      com.tencent.mm.modelsns.d locald = com.tencent.mm.modelsns.d.oF(732);
      locald.zi(com.tencent.mm.plugin.sns.data.q.st(localp.field_snsId)).zi((String)localObject).zi(this.xwm).zi(System.currentTimeMillis());
      locald.aBj();
      this.xta.removeListener();
      com.tencent.mm.sdk.b.a.ESL.d(this.xxj);
      com.tencent.mm.sdk.b.a.ESL.d(this.xxk);
      com.tencent.mm.sdk.b.a.ESL.d(this.xxl);
      com.tencent.mm.sdk.b.a.ESL.d(this.xxm);
      com.tencent.mm.sdk.b.a.ESL.d(this.xxr);
      com.tencent.mm.sdk.b.a.ESL.d(this.xxs);
      com.tencent.mm.sdk.b.a.ESL.d(this.xlr);
      super.onDestroy();
      localObject = com.tencent.mm.plugin.sns.k.f.wQY;
      if (((com.tencent.mm.plugin.sns.k.f)localObject).wRv != 0L)
      {
        ((com.tencent.mm.plugin.sns.k.f)localObject).wRw += System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.k.f)localObject).wRv;
        ((com.tencent.mm.plugin.sns.k.f)localObject).wRv = 0L;
      }
      localObject = com.tencent.mm.plugin.sns.k.f.wQY;
      if (((com.tencent.mm.plugin.sns.k.f)localObject).wRC != 0L)
      {
        ((com.tencent.mm.plugin.sns.k.f)localObject).wRD += System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.k.f)localObject).wRC;
        ((com.tencent.mm.plugin.sns.k.f)localObject).wRC = 0L;
      }
      if ((this.xxc) && (localp != null) && (localp.dxy() != null) && (localp.dxy().Etm != null))
      {
        localObject = com.tencent.mm.plugin.sns.k.f.wQY.duX();
        ((ck)localObject).dMB = com.tencent.mm.plugin.sns.k.f.wQY.wRk.dMB;
        ((ck)localObject).jd(com.tencent.mm.plugin.sns.k.f.wQY.wRk.dSp).je(com.tencent.mm.plugin.sns.data.q.su(localp.field_snsId)).dJX = localp.dxy().Etm.DaB;
        com.tencent.mm.plugin.sns.k.f.wQY.dvc();
      }
      AppMethodBeat.o(98596);
      return;
      label610:
      localObject = ((com.tencent.mm.plugin.sns.storage.a)localObject).dvK;
      break;
      label618:
      com.tencent.mm.plugin.sns.model.af.dto().f(12012, new Object[] { com.tencent.mm.plugin.sns.a.b.h.a(localp.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.q.st(localp.field_snsId), localObject, Long.valueOf(this.xwm), Long.valueOf(System.currentTimeMillis()) }) });
    }
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(98612);
    if (keyboardState() == 2)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "keybaordhide! ");
      this.xwC = false;
      AppMethodBeat.o(98612);
      return;
    }
    if (keyboardState() == 1)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "keybaordShow");
      dAX();
      this.xkZ = false;
      this.xxp.run();
      if (this.xlk != null) {
        this.xlk.duJ();
      }
    }
    AppMethodBeat.o(98612);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98598);
    com.tencent.mm.plugin.sns.model.af.dtp().b(this);
    try
    {
      bh.a(this, null);
      this.xtG = false;
      super.onPause();
      this.xlc.imP.hideVKB();
      localObject = this.xlc;
      if (((SnsCommentFooter)localObject).fSY != null) {
        ((SnsCommentFooter)localObject).fSY.onPause();
      }
      new vy().dBv.type = 1;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        Object localObject;
        if ((this.xwX) && (this.xwo != null) && (qm(false).Nb(32)))
        {
          localObject = (VideoSightView)this.xwo.findViewById(2131300914);
          if ((((VideoSightView)localObject).isPlaying()) && (((VideoSightView)localObject).getVisibility() == 0))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "pauseNormalVideoAd");
            ((VideoSightView)localObject).pause();
          }
        }
        if (this.xwT != null)
        {
          this.xwT.onPause();
          localObject = qm(false);
          if ((localObject != null) && (((com.tencent.mm.plugin.sns.storage.p)localObject).Nb(32))) {
            this.xwT.sn(((com.tencent.mm.plugin.sns.storage.p)localObject).field_snsId);
          }
        }
        if (this.xwS != null) {
          this.xwS.onPause();
        }
        AppMethodBeat.o(98598);
        return;
        localThrowable1 = localThrowable1;
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable1.toString());
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCommentDetailUI", "pauseNormalVideoAd, exp=" + localThrowable2.toString());
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98597);
    try
    {
      if (!this.xtG)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onResume callback");
        bh.a(this, this.xuu);
        this.xtG = true;
      }
      com.tencent.mm.plugin.sns.model.af.dtp().a(this);
      vy localvy = new vy();
      localvy.dBv.dBw = 0;
      localvy.dBv.dBx = 1;
      localvy.dBv.dBy = 0;
      localvy.dBv.type = 0;
      com.tencent.mm.sdk.b.a.ESL.l(localvy);
      if (this.xwT != null) {
        this.xwT.onResume();
      }
      if (this.xwS != null) {
        this.xwS.refreshView();
      }
      super.onResume();
      AppMethodBeat.o(98597);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable.toString());
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(98611);
    if ((paramn.getType() == 218) && (this.xlp != null)) {
      this.xlp.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((this.xxg != null) && (this.xxg.tipDialog != null) && (this.xxg.tipDialog.isShowing())) {
        this.xxg.tipDialog.dismiss();
      }
      paramn = com.tencent.mm.plugin.sns.storage.h.apJ(this.dpC);
      if (paramn == null)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.dpC);
        finish();
        AppMethodBeat.o(98611);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsCommentDetailUI", "snsId: " + this.dpC + "  username:" + paramn.field_userName);
      if (this.xwo == null)
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCommentDetailUI", "fatal error! Sns onSceneEnd before initView and infoHeader is null!");
        finish();
        AppMethodBeat.o(98611);
        return;
      }
      dAW();
      b(paramn, false);
      paramString = com.tencent.mm.plugin.sns.model.aj.s(paramn);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "onsceneend " + paramString.LikeUserList.size() + " " + paramString.CommentUserList.size());
      if (paramString == null)
      {
        AppMethodBeat.o(98611);
        return;
      }
      if (!f(this.xwA, paramString.LikeUserList))
      {
        h(paramString.LikeUserList, paramString.CommentUserList.isEmpty());
        this.xwA = paramString.LikeUserList;
      }
      if (this.xwr != null) {
        this.xwr.a(paramn, this.xta);
      }
      paramn = this.xwv;
      LinkedList localLinkedList = paramString.CommentUserList;
      paramString = paramString.LikeUserList;
      paramn.commentList = localLinkedList;
      paramn.xxW = paramString;
      this.xwv.notifyDataSetChanged();
      paramString = this.xwv;
      new com.tencent.mm.sdk.platformtools.ap().postDelayed(new SnsCommentDetailUI.b.1(paramString), 60L);
    }
    AppMethodBeat.o(98611);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(187688);
    super.onWindowFocusChanged(paramBoolean);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      bh.a(this, null);
      this.xtG = false;
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(187688);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(187688);
    }
    if (!this.xtG)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onWindowFocusChanged callback");
      bh.a(this, this.xuu);
      this.xtG = true;
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(187688);
    return;
  }
  
  final class a
    extends com.tencent.mm.pluginsdk.ui.span.p
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(98583);
      SnsCommentDetailUI.j(SnsCommentDetailUI.this).xLx.onClick(paramView);
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
    Activity activity;
    public LinkedList<cuo> commentList;
    String dgg;
    LinkedList<cuo> xxW;
    
    public b(LinkedList<cuo> paramLinkedList, Activity paramActivity, String paramString)
    {
      this.commentList = paramLinkedList;
      this.xxW = paramActivity;
      this.activity = paramString;
      Object localObject;
      this.dgg = localObject;
    }
    
    public final int getCount()
    {
      int i = 0;
      AppMethodBeat.i(98587);
      if (this.xxW.size() > 0)
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
      if (this.xxW.size() > 0)
      {
        if (paramInt == 0)
        {
          paramView = SnsCommentDetailUI.K(SnsCommentDetailUI.this);
          AppMethodBeat.o(98588);
          return paramView;
        }
        i = paramInt - 1;
      }
      cuo localcuo = (cuo)this.commentList.get(i);
      localcuo.gKr = bt.nullAsNil(localcuo.gKr);
      View localView;
      if ((paramView == null) || (!(paramView.getTag() instanceof a)))
      {
        localView = y.js(this.activity).inflate(2131495539, null);
        localView.setOnTouchListener(SnsCommentDetailUI.L(SnsCommentDetailUI.this));
        paramViewGroup = new a();
        paramViewGroup.frr = ((ImageView)localView.findViewById(2131296547));
        paramViewGroup.frr.setOnClickListener(SnsCommentDetailUI.M(SnsCommentDetailUI.this));
        paramViewGroup.inR = ((TextView)localView.findViewById(2131296559));
        paramViewGroup.inR.setOnTouchListener(new ad());
        paramViewGroup.inR.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(98586);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "onClick nickTv");
            AppMethodBeat.o(98586);
          }
        });
        paramViewGroup.timeTv = ((TextView)localView.findViewById(2131296562));
        paramViewGroup.izX = ((TextView)localView.findViewById(2131296551));
        paramViewGroup.xxY = ((FrameLayout)localView.findViewById(2131296550));
        paramViewGroup.izX.setOnTouchListener(new ad());
        paramViewGroup.xxZ = ((SnsTranslateResultView)localView.findViewById(2131305091));
        paramViewGroup.xxZ.setVisibility(8);
        paramViewGroup.xyb = ((EmojiStatusView)localView.findViewById(2131296552));
        if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) != 10) {
          break label1734;
        }
        localView.findViewById(2131298543).setBackgroundResource(2131232444);
      }
      label435:
      label833:
      label1731:
      label1734:
      for (;;)
      {
        paramViewGroup.xya = localcuo;
        paramViewGroup.userName = localcuo.Username;
        ((SnsAvatarImageView)paramViewGroup.frr).eE(localcuo.Username, 3);
        ((SnsAvatarImageView)paramViewGroup.frr).setWeakContext(this.activity);
        label366:
        com.tencent.mm.plugin.sns.storage.p localp;
        if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10)
        {
          paramInt = 3;
          SnsCommentDetailUI.F(SnsCommentDetailUI.this);
          com.tencent.mm.kernel.g.afC();
          paramView = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHW(paramViewGroup.userName);
          if ((i != 0) || (!this.xxW.isEmpty())) {
            break label1400;
          }
          if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) != 10) {
            break label1389;
          }
          localView.setBackgroundResource(2131232445);
          if (i != 0) {
            break label1434;
          }
          localView.findViewById(2131304961).setVisibility(0);
          localView.findViewById(2131304962).setVisibility(8);
          if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10) {
            ((ImageView)localView.findViewById(2131304961)).setImageResource(2131690252);
          }
          label490:
          localp = com.tencent.mm.plugin.sns.storage.h.apJ(SnsCommentDetailUI.o(SnsCommentDetailUI.this));
          paramViewGroup.frr.setTag(localcuo.Username);
          if (!com.tencent.mm.plugin.sns.ui.widget.e.a(paramViewGroup.frr, localp, localcuo.Username)) {
            a.b.w(paramViewGroup.frr, localcuo.Username);
          }
          if (paramView == null) {
            break label1459;
          }
          paramView = paramView.ZX();
          if (!com.tencent.mm.plugin.sns.ui.widget.e.b(localp, localcuo.Username)) {
            break label1731;
          }
          paramView = com.tencent.mm.plugin.sns.ui.widget.e.a(localp.dxs(), paramView);
        }
        for (;;)
        {
          CharSequence localCharSequence;
          m localm;
          Object localObject;
          label742:
          int j;
          label882:
          long l;
          if (localp != null)
          {
            paramViewGroup.izX.setText(localcuo.gKr + " ");
            localCharSequence = com.tencent.mm.plugin.sns.ui.widget.e.a(SnsCommentDetailUI.this, localcuo, SnsCommentDetailUI.N(SnsCommentDetailUI.this), localp.field_type, localp.field_userName, 2, SnsCommentDetailUI.O(SnsCommentDetailUI.this), SnsCommentDetailUI.P(SnsCommentDetailUI.this), localp);
            localm = null;
            localObject = localm;
            if (!bt.gL(localcuo.Emf))
            {
              localObject = localm;
              if (localcuo.Emf.get(0) != null)
              {
                localObject = ((cuu)localcuo.Emf.get(0)).Md5;
                localObject = com.tencent.mm.storage.aw.eLx().FyY.aJx((String)localObject);
              }
            }
            if (localObject != null) {
              break label1485;
            }
            paramViewGroup.xyb.setVisibility(8);
            paramViewGroup.xyb.setEmojiInfo(null);
            paramViewGroup.inR.setText(paramView, TextView.BufferType.SPANNABLE);
            com.tencent.mm.pluginsdk.ui.span.k.m(paramViewGroup.inR, paramInt);
            localObject = new com.tencent.mm.pluginsdk.ui.span.l(paramViewGroup.inR.getText());
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "test %s,%s", new Object[] { localcuo.Username, paramView });
            if (!com.tencent.mm.plugin.sns.ui.widget.e.b(localp, localcuo.Username)) {
              break label1577;
            }
            if (!com.tencent.mm.plugin.sns.ui.widget.e.hA(localcuo.Eme, 32)) {
              break label1571;
            }
            j = 27;
            ((com.tencent.mm.pluginsdk.ui.span.l)localObject).a(new com.tencent.mm.pluginsdk.ui.span.p(new com.tencent.mm.plugin.sns.data.a(localp.Nb(32), localcuo.Username, localp.dxX(), 2, j), SnsCommentDetailUI.N(SnsCommentDetailUI.this), paramInt), paramView, 0);
            paramViewGroup.inR.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
            l = localcuo.CreateTime;
            if (com.tencent.mm.plugin.sns.ui.widget.e.hA(localcuo.Eme, 32)) {
              l = localp.field_createTime;
            }
            paramViewGroup.timeTv.setText(bg.p(this.activity, l * 1000L));
            if (!bt.ai(localCharSequence)) {
              break label1607;
            }
            paramViewGroup.izX.setVisibility(8);
            label973:
            SnsCommentDetailUI.Q(SnsCommentDetailUI.this).c(localView, SnsCommentDetailUI.E(SnsCommentDetailUI.this).xTG, SnsCommentDetailUI.E(SnsCommentDetailUI.this).xTt);
            SnsCommentDetailUI.Q(SnsCommentDetailUI.this).c(paramViewGroup.xxY, SnsCommentDetailUI.E(SnsCommentDetailUI.this).xTG, SnsCommentDetailUI.E(SnsCommentDetailUI.this).xTt);
            if (localcuo.Ema == 0) {
              break label1650;
            }
            l = localcuo.Ema;
            localObject = com.tencent.mm.plugin.sns.model.ap.iG(SnsCommentDetailUI.o(SnsCommentDetailUI.this), String.valueOf(l));
            if ((com.tencent.mm.plugin.sns.model.ap.ev((String)localObject, 4)) && (paramViewGroup.xxZ != null))
            {
              localObject = com.tencent.mm.plugin.sns.model.ap.aoL((String)localObject);
              if (localObject == null) {
                break label1683;
              }
              paramViewGroup.xxZ.setVisibility(0);
              if (!((ap.b)localObject).gPQ) {
                break label1672;
              }
              if (((ap.b)localObject).aEj) {
                break label1660;
              }
              paramViewGroup.xxZ.a((ap.b)localObject, 2, ((ap.b)localObject).result, ((ap.b)localObject).gXN, ((ap.b)localObject).wJm);
            }
            label1149:
            localView.setClickable(true);
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SnsCommentDetailUI", "position " + localcuo.Username + " self " + SnsCommentDetailUI.t(SnsCommentDetailUI.this) + " commentid " + localcuo.Ema + " snsid " + SnsCommentDetailUI.o(SnsCommentDetailUI.this));
            if (!SnsCommentDetailUI.t(SnsCommentDetailUI.this).equals(localcuo.Username)) {
              break label1695;
            }
          }
          for (paramViewGroup.info = localcuo;; paramViewGroup.info = new Object[] { Integer.valueOf(i), localcuo, localcuo.Username, paramView })
          {
            paramView = new m(SnsCommentDetailUI.k(SnsCommentDetailUI.this), SnsCommentDetailUI.o(SnsCommentDetailUI.this), localcuo, localcuo.Username, localcuo.gKr, paramViewGroup.izX, 2);
            paramView.tag = paramViewGroup;
            localView.setTag(paramView);
            paramViewGroup.izX.setTag(paramView);
            localView.setOnClickListener(SnsCommentDetailUI.R(SnsCommentDetailUI.this));
            paramViewGroup.izX.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(SnsCommentDetailUI.this));
            paramViewGroup.xxY.setTag(paramView);
            paramViewGroup.xxY.setOnClickListener(SnsCommentDetailUI.R(SnsCommentDetailUI.this));
            AppMethodBeat.o(98588);
            return localView;
            paramViewGroup = (a)paramView.getTag();
            localView = paramView;
            break;
            paramInt = 2;
            break label366;
            label1389:
            localView.setBackgroundResource(2131232453);
            break label435;
            label1400:
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
            if (localcuo.Nickname != null)
            {
              paramView = localcuo.Nickname;
              break label552;
            }
            paramView = localcuo.Username;
            break label552;
            label1485:
            localm = new m(SnsCommentDetailUI.k(SnsCommentDetailUI.this), SnsCommentDetailUI.o(SnsCommentDetailUI.this), localcuo, localcuo.Username, localcuo.gKr, paramViewGroup.izX, 2);
            paramViewGroup.xyb.setTag(localm);
            paramViewGroup.xyb.setVisibility(0);
            paramViewGroup.xyb.setEmojiInfo((EmojiInfo)localObject);
            paramViewGroup.xyb.setOnClickListener(SnsCommentDetailUI.E(SnsCommentDetailUI.this).xTX);
            break label742;
            j = 2;
            break label833;
            ((com.tencent.mm.pluginsdk.ui.span.l)localObject).a(new com.tencent.mm.pluginsdk.ui.span.p(localcuo.Username, SnsCommentDetailUI.N(SnsCommentDetailUI.this), paramInt), paramView, 0);
            break label882;
            label1607:
            localObject = new SpannableStringBuilder(localCharSequence);
            ((SpannableStringBuilder)localObject).append(" ");
            paramViewGroup.izX.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
            paramViewGroup.izX.setVisibility(0);
            break label973;
            label1650:
            l = localcuo.Emc;
            break label1055;
            label1660:
            paramViewGroup.xxZ.setVisibility(8);
            break label1149;
            paramViewGroup.xxZ.NG(2);
            break label1149;
            paramViewGroup.xxZ.setVisibility(8);
            break label1149;
          }
        }
      }
    }
    
    final class a
    {
      ImageView frr;
      TextView inR;
      Object info;
      TextView izX;
      TextView timeTv;
      String userName;
      FrameLayout xxY;
      SnsTranslateResultView xxZ;
      cuo xya;
      EmojiStatusView xyb;
      
      a() {}
    }
  }
  
  final class c
    implements Runnable
  {
    int Sb = -1;
    int hr;
    private int offset = 0;
    private int xyc = -1;
    private int xyd = 10;
    
    c() {}
    
    public final void run()
    {
      AppMethodBeat.i(98589);
      this.xyd = 10;
      SnsCommentDetailUI.b(SnsCommentDetailUI.this);
      this.xyc = SnsCommentDetailUI.c(SnsCommentDetailUI.this).getTop();
      int i = this.xyc - this.hr;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SnsCommentDetailUI", "list.bottom: %d, listOriginalBottom: %d, footerTop: %d, commentFooter.getTop: %d, topSelection: %d", new Object[] { Integer.valueOf(SnsCommentDetailUI.a(SnsCommentDetailUI.this).getBottom()), Integer.valueOf(SnsCommentDetailUI.d(SnsCommentDetailUI.this)), Integer.valueOf(this.xyc), Integer.valueOf(SnsCommentDetailUI.c(SnsCommentDetailUI.this).getTop()), Integer.valueOf(i) });
      if (i == this.offset)
      {
        SnsCommentDetailUI.a(SnsCommentDetailUI.this).setSelectionFromTop(SnsCommentDetailUI.a(SnsCommentDetailUI.this).getHeaderViewsCount() + this.Sb, i);
        this.xyd = 0;
        this.offset = 0;
        AppMethodBeat.o(98589);
        return;
      }
      int j = this.xyd;
      this.xyd = (j - 1);
      if (j > 0)
      {
        new com.tencent.mm.sdk.platformtools.ap().postDelayed(this, 100L);
        this.offset = i;
        AppMethodBeat.o(98589);
        return;
      }
      this.offset = 0;
      this.xyd = 0;
      AppMethodBeat.o(98589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI
 * JD-Core Version:    0.7.0.1
 */