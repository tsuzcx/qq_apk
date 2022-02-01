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
import com.tencent.mm.g.a.ht;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.g.a.ti;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.un;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.g.b.a.dy;
import com.tencent.mm.g.b.a.eg;
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
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.aq.b;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.protocal.protobuf.dbb;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bg.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.kernel.i
public class SnsCommentDetailUI
  extends MMActivity
  implements com.tencent.mm.ak.g, i.a, b.b, z
{
  private static com.tencent.mm.loader.c.d<String, Bitmap> rtB;
  public static int yJG;
  private static com.tencent.mm.loader.c.e yKd;
  private static com.tencent.mm.loader.c.e yKe;
  private String dnX;
  private String dnn;
  private String fnC;
  private com.tencent.mm.sdk.b.c kce;
  private boolean kxj;
  private int mScreenHeight;
  private int mScreenWidth;
  private int ndF;
  private com.tencent.mm.ui.widget.b.a nym;
  private View.OnClickListener nzz;
  private View.OnClickListener oPc;
  private int oeH;
  private ClipboardManager qRg;
  private com.tencent.mm.plugin.sns.ui.d.b xLF;
  private LinearLayout xPo;
  private volatile boolean yGw;
  private bg.a yHk;
  private boolean yJA;
  private long yJB;
  private bl yJC;
  private boolean yJD;
  private int yJE;
  private int yJF;
  public int yJH;
  private com.tencent.mm.plugin.sns.ui.c.a.a yJI;
  com.tencent.mm.plugin.sns.ad.d.i yJJ;
  private SnsTranslateResultView yJK;
  private boolean yJL;
  private Dialog yJM;
  private boolean yJN;
  private boolean yJO;
  private String yJP;
  private boolean yJQ;
  private int yJR;
  private boolean yJS;
  private int yJT;
  private boolean yJU;
  private boolean yJV;
  private n yJW;
  private TextView yJX;
  private ag yJY;
  private com.tencent.mm.sdk.b.c yJZ;
  private long yJc;
  private long yJd;
  private View yJe;
  private TextView yJf;
  private LinearLayout yJg;
  private SnsDetailLuckyHeader yJh;
  private ListView yJi;
  private View yJj;
  private View yJk;
  private b yJl;
  private ScaleAnimation yJm;
  private ScaleAnimation yJn;
  LinearLayout yJo;
  LinearLayout yJp;
  private LinkedList<daa> yJq;
  private int yJr;
  private boolean yJs;
  private ay yJt;
  private String yJu;
  private bj yJv;
  private int yJw;
  private ImageView yJx;
  private j yJy;
  private l yJz;
  private com.tencent.mm.sdk.b.c yKa;
  private com.tencent.mm.sdk.b.c yKb;
  private com.tencent.mm.sdk.b.c yKc;
  private c yKf;
  private View.OnClickListener yKg;
  private com.tencent.mm.sdk.b.c yKh;
  private com.tencent.mm.sdk.b.c yKi;
  boolean yKj;
  private LinearLayout yKk;
  private boolean yKl;
  PhotosContent yKm;
  int yKn;
  public ar.b.a yKo;
  private bk yKp;
  private boolean yxR;
  private SnsCommentFooter yxU;
  private av yxW;
  private b yyc;
  private com.tencent.mm.plugin.sns.h.b yyd;
  private aj yye;
  private bo yyf;
  private com.tencent.mm.ui.base.p yyh;
  private com.tencent.mm.sdk.b.c yyj;
  private View.OnTouchListener yzD;
  
  static
  {
    AppMethodBeat.i(163117);
    yJG = 34;
    e.a locala = new e.a();
    locala.gKq = true;
    locala.gKp = true;
    yKd = locala.aot();
    rtB = new com.tencent.mm.loader.c.c()
    {
      public final com.tencent.mm.loader.e.c.a<Bitmap> aoj()
      {
        AppMethodBeat.i(163115);
        com.tencent.mm.loader.e.c.a locala = new com.tencent.mm.loader.e.c.a(new com.tencent.mm.loader.e.c.c(0.5F).aoy());
        AppMethodBeat.o(163115);
        return locala;
      }
    };
    locala = new e.a();
    locala.gKq = true;
    locala.gKp = true;
    yKe = locala.aot();
    AppMethodBeat.o(163117);
  }
  
  public SnsCommentDetailUI()
  {
    AppMethodBeat.i(98590);
    this.yJc = 0L;
    this.yJd = 0L;
    this.yJr = -1;
    this.yJs = false;
    this.yzD = bs.eWg();
    this.yyh = null;
    this.ndF = 0;
    this.yJw = 0;
    this.kxj = false;
    this.dnX = "";
    this.yJA = false;
    this.yJB = 0L;
    this.yJD = false;
    this.yJF = 103;
    this.yJH = 210;
    this.yJL = false;
    this.yJM = null;
    this.yJN = false;
    this.yJO = false;
    this.yJP = "";
    this.yJQ = true;
    this.yJS = false;
    this.yJT = 0;
    this.yJU = false;
    this.yJV = false;
    this.yJW = null;
    this.yJX = null;
    this.yGw = false;
    this.yJY = new ag();
    this.yJZ = new com.tencent.mm.sdk.b.c() {};
    this.yKa = new com.tencent.mm.sdk.b.c() {};
    this.yKb = new com.tencent.mm.sdk.b.c() {};
    this.yKc = new SnsCommentDetailUI.34(this);
    this.yyj = new com.tencent.mm.sdk.b.c() {};
    this.yKf = new c();
    this.nzz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(98579);
        paramAnonymousView = (String)paramAnonymousView.getTag();
        ac.d("MicroMsg.SnsCommentDetailUI", "onCommentClick:".concat(String.valueOf(paramAnonymousView)));
        com.tencent.mm.plugin.sns.storage.p localp = SnsCommentDetailUI.e(SnsCommentDetailUI.this);
        if ((localp != null) && (localp.Pe(32)))
        {
          localObject = new SnsAdClick(SnsCommentDetailUI.this.getSource(), 2, localp.field_snsId, 1, 0);
          com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject, SnsCommentDetailUI.f(SnsCommentDetailUI.this), localp, 1);
          com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject);
          if ((paramAnonymousView != null) && (paramAnonymousView.equals(localp.field_userName)))
          {
            com.tencent.mm.plugin.sns.storage.b localb = localp.dFR();
            if ((localb != null) && (localb.yfF == 1) && (!bs.isNullOrNil(localb.yfG)))
            {
              localObject = localb.yfG;
              com.tencent.mm.plugin.sns.storage.a locala = SnsCommentDetailUI.a(SnsCommentDetailUI.this, localp);
              paramAnonymousView = (View)localObject;
              if (locala != null) {
                paramAnonymousView = com.tencent.mm.plugin.sns.data.q.iV((String)localObject, locala.dtx);
              }
              ac.i("MicroMsg.SnsCommentDetailUI", "headClickParam url " + paramAnonymousView + " " + localb.yfH);
              localObject = new Intent();
              if (localb.yfH == 0) {
                bool = true;
              }
              ((Intent)localObject).putExtra("KsnsViewId", SnsCommentDetailUI.a(SnsCommentDetailUI.this, localp).dyy);
              ((Intent)localObject).putExtra("KRightBtn", bool);
              ((Intent)localObject).putExtra("jsapiargs", new Bundle());
              ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
              ((Intent)localObject).putExtra("useJs", true);
              com.tencent.mm.plugin.sns.c.a.iyx.i((Intent)localObject, SnsCommentDetailUI.this);
              AppMethodBeat.o(98579);
              return;
            }
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
          ((Intent)localObject).putExtra("Contact_Scene", 37);
          com.tencent.mm.plugin.sns.c.a.iyx.c((Intent)localObject, SnsCommentDetailUI.this);
          AppMethodBeat.o(98579);
          return;
        }
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
        com.tencent.mm.plugin.sns.c.a.iyx.c((Intent)localObject, SnsCommentDetailUI.this);
        AppMethodBeat.o(98579);
      }
    };
    this.yKg = new SnsCommentDetailUI.42(this);
    this.oPc = new SnsCommentDetailUI.3(this);
    this.yKh = new SnsCommentDetailUI.8(this);
    this.kce = new SnsCommentDetailUI.9(this);
    this.yKi = new SnsCommentDetailUI.10(this);
    this.yHk = new SnsCommentDetailUI.11(this);
    this.yKj = false;
    this.yKk = null;
    this.yKl = false;
    this.yKm = null;
    this.yKn = 0;
    this.yKo = new SnsCommentDetailUI.22(this);
    this.yKp = null;
    AppMethodBeat.o(98590);
  }
  
  private LinearLayout Pv(int paramInt)
  {
    AppMethodBeat.i(98601);
    if (this.yKk == null)
    {
      this.yKk = ((LinearLayout)com.tencent.mm.ui.z.jD(this).inflate(paramInt, null));
      localLinearLayout = this.yKk;
      AppMethodBeat.o(98601);
      return localLinearLayout;
    }
    this.yKj = true;
    LinearLayout localLinearLayout = this.yKk;
    AppMethodBeat.o(98601);
    return localLinearLayout;
  }
  
  private void b(com.tencent.mm.plugin.sns.storage.p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(98603);
    if (this.yJX == null)
    {
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
      this.yJX = new TextView(this);
      this.yJX.setLayoutParams(localLayoutParams);
      this.yJX.setText(getString(2131763801));
      this.yJX.setTextColor(getResources().getColor(2131100711));
      this.yJX.setGravity(17);
      this.yJX.setPadding(0, BackwardSupportUtil.b.g(this, 7.0F), 0, BackwardSupportUtil.b.g(this, 12.0F));
      this.yJX.setVisibility(8);
      this.yJi.addFooterView(this.yJX);
    }
    if (paramp != null)
    {
      if ((paramp.field_localPrivate & 0x1) != 0)
      {
        findViewById(2131298521).setVisibility(8);
        paramp = paramp.dLV();
        if (paramp != null) {
          switch (paramp.FQo.Ety)
          {
          }
        }
        for (;;)
        {
          this.yJX.setVisibility(0);
          AppMethodBeat.o(98603);
          return;
          this.yJX.setText(getString(2131763802));
          continue;
          this.yJX.setText(getString(2131763805));
          continue;
          this.yJX.setText(getString(2131763803));
        }
      }
      if (paramBoolean) {
        findViewById(2131298521).setVisibility(0);
      }
      this.yJX.setVisibility(8);
    }
    AppMethodBeat.o(98603);
  }
  
  private int dPr()
  {
    AppMethodBeat.i(98600);
    if ((this.yJi != null) && (this.yJi.getChildCount() > 1))
    {
      View localView = this.yJi.getChildAt(0);
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
  
  private static boolean dPs()
  {
    AppMethodBeat.i(98602);
    if ((am.a.dIw() & 0x1) <= 0)
    {
      AppMethodBeat.o(98602);
      return true;
    }
    AppMethodBeat.o(98602);
    return false;
  }
  
  private void dPu()
  {
    AppMethodBeat.i(98605);
    if ((this.yJj == null) || (this.yJj.getVisibility() == 8))
    {
      AppMethodBeat.o(98605);
      return;
    }
    this.yJj.startAnimation(this.yJn);
    this.yJn.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(163114);
        ac.d("MicroMsg.SnsCommentDetailUI", "onAnimationEnd");
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
  
  private void dPv()
  {
    AppMethodBeat.i(98606);
    if ((keyboardState() == 1) || (this.yxU.dPz()))
    {
      this.yKf.run();
      AppMethodBeat.o(98606);
      return;
    }
    this.yxR = true;
    AppMethodBeat.o(98606);
  }
  
  private void dPw()
  {
    AppMethodBeat.i(98607);
    if (this.yJx == null)
    {
      AppMethodBeat.o(98607);
      return;
    }
    this.yJx.setPressed(false);
    if (bl.arO(this.dnX))
    {
      this.yJx.setImageResource(2131233393);
      AppMethodBeat.o(98607);
      return;
    }
    this.yJx.setImageResource(2131233395);
    AppMethodBeat.o(98607);
  }
  
  private com.tencent.mm.plugin.sns.storage.a f(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(98594);
    if (paramp != null)
    {
      if (getSource() == 2)
      {
        paramp = paramp.dLS();
        AppMethodBeat.o(98594);
        return paramp;
      }
      paramp = paramp.dFQ();
      AppMethodBeat.o(98594);
      return paramp;
    }
    AppMethodBeat.o(98594);
    return null;
  }
  
  private static boolean f(LinkedList<daa> paramLinkedList1, LinkedList<daa> paramLinkedList2)
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
      if (!((daa)paramLinkedList1.get(i)).Username.equals(((daa)paramLinkedList2.get(i)).Username))
      {
        AppMethodBeat.o(98591);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(98591);
    return true;
  }
  
  private boolean i(List<daa> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(98608);
    int k = BackwardSupportUtil.b.g(this, 32.0F);
    int m = BackwardSupportUtil.b.g(this, 6.0F);
    int i = BackwardSupportUtil.b.g(this, 10.0F);
    int j = BackwardSupportUtil.b.g(this, 17.0F);
    if (this.yJg == null)
    {
      AppMethodBeat.o(98608);
      return false;
    }
    int n = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    float f = getResources().getDimension(2131165516);
    ac.d("MicroMsg.SnsCommentDetailUI", "guess size %d %f", new Object[] { Integer.valueOf(n), Float.valueOf(f) });
    f = n - f * 2.0F;
    if (paramList.size() <= 0)
    {
      if (this.yJg.getParent() != null) {
        this.yJg.setVisibility(8);
      }
      this.yJg.removeAllViews();
      this.yJg.setVisibility(8);
      this.xPo.setVisibility(8);
      AppMethodBeat.o(98608);
      return false;
    }
    this.yJg.getParent();
    this.yJg.removeAllViews();
    this.yJg.setVisibility(0);
    Object localObject1;
    if (this.oeH == 10) {
      if (!this.yJL)
      {
        this.yJg.setBackgroundResource(2131232445);
        this.yJg.setPadding(0, m, 0, m);
        localObject1 = new ImageView(getContext());
        if (this.oeH != 10) {
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
      this.yJg.addView((View)localObject1);
      n = com.tencent.mm.cc.a.fromDPToPix(getContext(), yJG);
      j = (int)(f - n) / (m + k);
      i = j;
      if ((int)(f - n) % (m + k) > k) {
        i = j + 1;
      }
      ac.d("MicroMsg.SnsCommentDetailUI", "guess size %d", new Object[] { Integer.valueOf(i) });
      localObject1 = new h(getContext());
      ((h)localObject1).setClipChildren(false);
      ((h)localObject1).setClipToPadding(false);
      ((h)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((h)localObject1).setLineMaxCounte(i);
      i = 0;
      while (i < paramList.size())
      {
        localObject2 = (daa)paramList.get(i);
        StoryTouchImageView localStoryTouchImageView = new StoryTouchImageView(getContext());
        localStoryTouchImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localStoryTouchImageView.setImageResource(2131232455);
        Object localObject3 = ((daa)localObject2).Username;
        localStoryTouchImageView.yXY.eM((String)localObject3, 1);
        localObject3 = new LinearLayout.LayoutParams(k, k);
        ((LinearLayout.LayoutParams)localObject3).setMargins(0, m, m, 0);
        localStoryTouchImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localStoryTouchImageView.setTag(((daa)localObject2).Username);
        a.b.w(localStoryTouchImageView, ((daa)localObject2).Username);
        localStoryTouchImageView.setOnClickListener(this.nzz);
        ((h)localObject1).addView(localStoryTouchImageView);
        i += 1;
      }
      localObject1 = rl(false);
      if (localObject1 != null)
      {
        if (this.fnC.equals(((com.tencent.mm.plugin.sns.storage.p)localObject1).field_userName))
        {
          this.yJg.setBackgroundResource(2131232446);
          break;
        }
        this.yJg.setBackgroundResource(2131232445);
        break;
      }
      this.yJg.setBackgroundResource(2131232445);
      break;
      this.yJg.setBackgroundResource(2131232453);
      break;
      label692:
      ((ImageView)localObject1).setImageDrawable(am.k(getContext(), 2131690247, getContext().getResources().getColor(2131099769)));
    }
    this.yJg.addView((View)localObject1);
    paramList = this.xPo;
    if (paramBoolean) {}
    for (i = 8;; i = 0)
    {
      paramList.setVisibility(i);
      AppMethodBeat.o(98608);
      return true;
    }
  }
  
  private void rk(boolean paramBoolean)
  {
    AppMethodBeat.i(98592);
    this.yJs = false;
    if (this.yxU.dPy())
    {
      this.yxU.yKW = 0;
      this.yxU.dPB();
      this.yxU.setCommentHint(getString(2131764046));
    }
    this.yxU.rm(false);
    if (paramBoolean)
    {
      Object localObject1 = this.yJi;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "scrollDown", "(Z)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
      BackwardSupportUtil.c.b((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "scrollDown", "(Z)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    }
    AppMethodBeat.o(98592);
  }
  
  private com.tencent.mm.plugin.sns.storage.p rl(boolean paramBoolean)
  {
    AppMethodBeat.i(98593);
    com.tencent.mm.plugin.sns.storage.p localp;
    if (!bs.isNullOrNil(this.yJu))
    {
      localp = com.tencent.mm.plugin.sns.storage.h.auT(this.yJu);
      if (localp == null)
      {
        if (paramBoolean) {
          Toast.makeText(this, 2131763915, 0).show();
        }
        finish();
        AppMethodBeat.o(98593);
        return null;
      }
      this.dnn = localp.getSnsId();
    }
    for (;;)
    {
      AppMethodBeat.o(98593);
      return localp;
      localp = com.tencent.mm.plugin.sns.storage.h.auS(this.dnn);
      if (localp == null)
      {
        finish();
        AppMethodBeat.o(98593);
        return null;
      }
      this.yJu = localp.dMu();
    }
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void atn(String paramString) {}
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void bF(String paramString, boolean paramBoolean) {}
  
  public final void bG(String paramString, boolean paramBoolean) {}
  
  public final void dGO() {}
  
  public final aj dNi()
  {
    return this.yye;
  }
  
  public final b dNj()
  {
    return this.yyc;
  }
  
  public final bm dNk()
  {
    return null;
  }
  
  public final bo dNl()
  {
    return this.yyf;
  }
  
  final boolean dPt()
  {
    AppMethodBeat.i(98604);
    final com.tencent.mm.plugin.sns.storage.p localp = rl(true);
    if (localp == null)
    {
      AppMethodBeat.o(98604);
      return false;
    }
    ac.i("MicroMsg.SnsCommentDetailUI", "setheader " + this.yJe.toString());
    this.yJE = af.dIc();
    Object localObject6 = localp.dLV();
    this.oeH = be.c(localp, false);
    Object localObject1 = (SnsAvatarImageView)this.yJe.findViewById(2131296533);
    Object localObject5 = (RelativeLayout)this.yJe.findViewById(2131303033);
    ((RelativeLayout)localObject5).setVisibility(8);
    ((RelativeLayout)localObject5).setOnClickListener(this.xLF.zgR);
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
        ac.e("MicroMsg.SnsCommentDetailUI", bool);
        AppMethodBeat.o(98604);
        return false;
        bool = false;
        break;
      }
    }
    ((SnsAvatarImageView)localObject1).setWeakContext(this);
    ((MaskImageButton)localObject1).gMG = localp.dMu();
    ((SnsAvatarImageView)localObject1).setTag(localp.getUserName());
    label338:
    Object localObject7;
    int j;
    if ((localp.dFR() != null) && (localp.dFR().ygq))
    {
      if (!bs.isNullOrNil(localp.dFR().ygs))
      {
        localObject2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.js("adId", localp.dFR().ygs);
        ((SnsAvatarImageView)localObject1).setTag(2131305044, localp.dFR().ygs);
        if (!com.tencent.mm.vfs.i.eA((String)localObject2)) {
          break label1290;
        }
        localObject2 = com.tencent.mm.plugin.sns.ad.d.l.xKs.getBitmap((String)localObject2);
        if (localObject2 != null) {
          ((SnsAvatarImageView)localObject1).setImageBitmap((Bitmap)localObject2);
        }
      }
      ((SnsAvatarImageView)localObject1).setOnClickListener(this.xLF.zgq);
      localObject2 = (TextView)this.yJe.findViewById(2131302867);
      com.tencent.mm.kernel.g.agS();
      localObject7 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(localp.getUserName());
      ac.i("MicroMsg.SnsCommentDetailUI", "snsinfo username " + localp.getUserName() + " " + localp.getSnsId() + " " + localp.getCreateTime());
      if ((localObject7 != null) && (((com.tencent.mm.storage.ai)localObject7).aaQ() == 0))
      {
        ac.i("MicroMsg.SnsCommentDetailUI", "getContact %s", new Object[] { localp.getUserName() });
        ar.a.ayw().a(localp.getUserName(), "", this.yKo);
      }
      j = 0;
      if (localObject7 != null) {
        break label1519;
      }
    }
    Object localObject4;
    int i;
    int k;
    label585:
    label846:
    label1106:
    label1519:
    for (localObject1 = localp.getUserName();; localObject1 = ((com.tencent.mm.storage.ai)localObject7).aaS())
    {
      localObject1 = bs.bG((String)localObject1, "");
      if (!localp.tY()) {
        break label1565;
      }
      localObject4 = localp.dFR();
      if (localObject4 == null) {
        break label10740;
      }
      if (!((com.tencent.mm.plugin.sns.storage.b)localObject4).ygq) {
        break label1529;
      }
      localObject4 = ((com.tencent.mm.plugin.sns.storage.b)localObject4).ygr;
      i = 0;
      ((String)localObject4).length();
      if (this.oeH != 10) {
        break label1691;
      }
      k = 3;
      localObject1 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject4));
      ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).b(new com.tencent.mm.pluginsdk.ui.span.p(new com.tencent.mm.plugin.sns.data.a(localp.tY(), ((com.tencent.mm.storage.ai)localObject7).getUsername(), localp.dMu(), 2), this.yJy, k), (CharSequence)localObject4);
      if ((j >= 0) && (i > j)) {
        ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).setSpan(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).f(this, ((com.tencent.mm.storage.ai)localObject7).Ts(), this.yJT), j, i, 33);
      }
      ((TextView)localObject2).setOnTouchListener(new ad());
      ((TextView)localObject2).setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      ((TextView)this.yJe.findViewById(2131306175)).setText("");
      this.yKp = new bk(this.yJe);
      if (!localp.tY()) {
        break label1697;
      }
      this.yKp.F(Long.valueOf(localp.field_snsId), new com.tencent.mm.plugin.sns.data.b(this.yKp, 0, this.yJu, localp.field_snsId, f(localp).dyy));
      this.yKp.a(localp.dFR(), f(localp));
      this.yKp.a(this.xLF.zgA, this.xLF.zgO);
      this.yKp.setVisibility(0);
      localObject1 = ((TimeLineObject)localObject6).FQl;
      this.yJf = ((TextView)this.yJe.findViewById(2131299008));
      localObject2 = new ba(this.dnn, localp.dMu(), true, false, 2);
      this.yJf.setTag(localObject2);
      this.nym.c(this.yJf, this.xLF.zgs, this.xLF.zgp);
      if (!bs.isNullOrNil((String)localObject1)) {
        break label1709;
      }
      this.yJf.setVisibility(8);
      localObject1 = (ViewStub)this.yJe.findViewById(2131300969);
      if (!this.yKl) {
        ((ViewStub)localObject1).setLayoutResource(-1);
      }
      switch (this.oeH)
      {
      case 6: 
      case 7: 
      case 8: 
      case 12: 
      default: 
        ((ViewStub)localObject1).setVisibility(8);
        if (((ViewStub)localObject1).getLayoutResource() == -1) {
          break label1965;
        }
        localObject2 = ((ViewStub)localObject1).inflate();
        if (this.yJI != null)
        {
          this.yJI.khe = findViewById(2131305824);
          this.yJI.l((View)localObject2, this.yJk);
        }
        this.yKl = true;
        k = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        if (this.oeH == 6) {
          break label2402;
        }
        if ((this.oeH != 2) && (this.oeH != 3) && (this.oeH != 4) && (this.oeH != 5)) {
          break label3995;
        }
        this.yKm = ((PhotosContent)findViewById(2131303243));
        if (this.yKm == null) {
          break label3952;
        }
        this.yKm.dOu();
        if (this.oeH != 2) {
          break label1975;
        }
        i = 1;
        j = 0;
        while (j < i)
        {
          localObject1 = (TagImageView)this.yKm.findViewById(ay.yOB[j]);
          this.yKm.a((TagImageView)localObject1);
          ((TagImageView)localObject1).setOnClickListener(this.xLF.yAf);
          this.nym.c((View)localObject1, this.xLF.zgD, this.xLF.zgp);
          j += 1;
        }
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localp.dFR().ygs, false, new f.a()
        {
          public final void asD(String paramAnonymousString)
          {
            AppMethodBeat.i(163106);
            ac.i("MicroMsg.SnsCommentDetailUI", "download img %s", new Object[] { paramAnonymousString });
            String str = (String)this.yKx.getTag(2131305044);
            if ((!bs.T(new String[] { str, paramAnonymousString })) && (paramAnonymousString.equals(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.js("adId", str))))
            {
              paramAnonymousString = com.tencent.mm.plugin.sns.ad.d.l.xKs.getBitmap(paramAnonymousString);
              if (paramAnonymousString != null) {
                this.yKx.setImageBitmap(paramAnonymousString);
              }
            }
            AppMethodBeat.o(163106);
          }
          
          public final void dFC() {}
          
          public final void dFD()
          {
            AppMethodBeat.i(200493);
            ac.e("MicroMsg.SnsCommentDetailUI", "onDownloadError");
            AppMethodBeat.o(200493);
          }
        });
        break label338;
        if (localp.getUserName().endsWith("@ad")) {
          break label338;
        }
        if (localp.tY()) {}
        for (;;)
        {
          try
          {
            com.tencent.mm.kernel.g.agS();
            localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(localp.getUserName());
            if ((localObject2 == null) || (((com.tencent.mm.storage.ai)localObject2).aaQ() == 0)) {
              continue;
            }
            a.b.w((ImageView)localObject1, localp.getUserName());
            ac.i("MicroMsg.SnsCommentDetailUI", "has contact before setAvatar, userName=" + localp.getUserName());
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.SnsCommentDetailUI", "setAvatar exp=" + localException.toString());
            continue;
          }
          ((SnsAvatarImageView)localObject1).eM(localp.getUserName(), 2);
          bs.lr(this.fnC, localp.getUserName());
          break;
          ac.e("MicroMsg.SnsCommentDetailUI", "has no contact before setAvatar, userName=" + localp.getUserName());
          continue;
          a.b.w((ImageView)localObject1, localp.getUserName());
        }
      }
    }
    label942:
    label1209:
    label1529:
    if ((bs.isNullOrNil((String)localObject1)) && (!bs.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject4).nickname))) {
      localObject1 = ((com.tencent.mm.plugin.sns.storage.b)localObject4).nickname;
    }
    label1051:
    label1565:
    label1697:
    label1709:
    label1965:
    label1975:
    label2402:
    label2531:
    label3952:
    label9458:
    label10226:
    label10740:
    for (;;)
    {
      i = 0;
      localObject4 = localObject1;
      break;
      if ((localObject7 != null) && (com.tencent.mm.storage.ai.aNc(((com.tencent.mm.storage.ai)localObject7).getUsername())) && ("3552365301".equals(((com.tencent.mm.storage.ai)localObject7).Ts())))
      {
        j = ((String)localObject1).length();
        localObject4 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bB(((com.tencent.mm.storage.ai)localObject7).Ts(), ((com.tencent.mm.storage.ai)localObject7).Tr());
        localObject4 = (String)localObject1 + " @" + (String)localObject4;
        i = ((String)localObject4).length();
        ((RelativeLayout)localObject5).setTag(new com.tencent.mm.plugin.sns.data.e((View)localObject5, localp.dMu()));
        ((RelativeLayout)localObject5).setVisibility(0);
        break;
        k = 2;
        break label585;
        this.yKp.setVisibility(8);
        break label846;
        this.yJf.setText((String)localObject1 + " ");
        com.tencent.mm.pluginsdk.ui.span.k.m(this.yJf, 2);
        this.yJf.setVisibility(0);
        com.tencent.mm.plugin.sns.j.f.ydE.dJw().Re();
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
        this.yJI = new com.tencent.mm.plugin.sns.ui.c.a.b((TimeLineObject)localObject6, localp, this.xLF, this.yJJ);
        break label1051;
        ((ViewStub)localObject1).setLayoutResource(2131495614);
        this.yJI = new com.tencent.mm.plugin.sns.ui.c.a.e((TimeLineObject)localObject6, localp, this.xLF, this.yJJ);
        break label1051;
        ((ViewStub)localObject1).setLayoutResource(2131495603);
        this.yJI = new com.tencent.mm.plugin.sns.ui.c.a.c((TimeLineObject)localObject6, localp, this.xLF, this.yJJ);
        break label1051;
        ((ViewStub)localObject1).setLayoutResource(2131495604);
        this.yJI = new com.tencent.mm.plugin.sns.ui.c.a.d((TimeLineObject)localObject6, localp, this.xLF);
        break label1051;
        ((ViewStub)localObject1).setVisibility(8);
        break label1106;
        i = ay.yOx[this.oeH];
        break label1209;
        this.yKm.setImageViewWidth(this.yJE);
        localObject1 = new LinkedList();
        Object localObject3;
        float f2;
        float f1;
        Object localObject8;
        if ((localp.tY()) && (this.oeH == 2))
        {
          localObject3 = localp.dFR();
          this.yKm.Pr(0).setScaleType(QImageView.a.JbU);
          if ((localObject3 != null) && (!((com.tencent.mm.plugin.sns.storage.b)localObject3).dJL()) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).yfW > 0.0F) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).yfX > 0.0F))
          {
            f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).yfW, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfY, ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfZ);
            f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).yfX, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfY, ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfZ);
            if (((com.tencent.mm.plugin.sns.storage.b)localObject3).yfV != 0) {
              break label3666;
            }
            float f3 = f1;
            f1 = f2;
            if (f2 >= k - com.tencent.mm.cc.a.au(this, 2131166827) - com.tencent.mm.cc.a.au(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516))
            {
              f1 = k - com.tencent.mm.cc.a.au(this, 2131166827) - com.tencent.mm.cc.a.au(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
              f3 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject3).yfX * f1 / ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfW);
            }
            localObject5 = new bub();
            ((bub)localObject5).FjY = f1;
            ((bub)localObject5).FjZ = f3;
            ((bub)localObject5).Fka = (((bub)localObject5).FjY * ((bub)localObject5).FjZ);
            ((LinkedList)localObject1).add(localObject5);
          }
          if (!bs.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject3).ygb))
          {
            localObject5 = this.yKm;
            localObject8 = this.yKm.Pr(0);
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((com.tencent.mm.plugin.sns.storage.b)localObject3).ygb, false, 41, new f.a()
            {
              public final void asD(String paramAnonymousString)
              {
                AppMethodBeat.i(200494);
                MaskImageView localMaskImageView = (MaskImageView)this.yKy.findViewById(2131302209);
                if (localMaskImageView != null)
                {
                  localMaskImageView.setVisibility(0);
                  localMaskImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.f.decodeFile(paramAnonymousString));
                  float f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.yKz.ygc, 1, this.yKz.yfY, this.yKz.yfZ);
                  float f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.yKz.ygd, 1, this.yKz.yfY, this.yKz.yfZ);
                  float f3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.yKz.yge, 1, this.yKz.yfY, this.yKz.yfZ);
                  float f4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.yKz.ygf, 1, this.yKz.yfY, this.yKz.yfZ);
                  paramAnonymousString = new FrameLayout.LayoutParams((int)f1, (int)f2);
                  paramAnonymousString.setMargins((int)(this.yKA.getRight() - f3 - f1), (int)(this.yKA.getBottom() - f4 - f2), 0, 0);
                  localMaskImageView.setLayoutParams(paramAnonymousString);
                }
                AppMethodBeat.o(200494);
              }
              
              public final void dFC() {}
              
              public final void dFD() {}
            });
          }
        }
        this.yJe.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
        {
          boolean yKB = false;
          
          public final void onViewAttachedToWindow(View paramAnonymousView)
          {
            AppMethodBeat.i(200495);
            ac.i("MicroMsg.SnsCommentDetailUI", "onViewAttachedToWindow infoHeader %s", new Object[] { Boolean.valueOf(this.yKB) });
            if (!this.yKB)
            {
              AppMethodBeat.o(200495);
              return;
            }
            this.yKB = false;
            if (this.yKC == null)
            {
              AppMethodBeat.o(200495);
              return;
            }
            if (localp == null)
            {
              AppMethodBeat.o(200495);
              return;
            }
            if (SnsCommentDetailUI.this.yKm == null)
            {
              AppMethodBeat.o(200495);
              return;
            }
            paramAnonymousView = SnsCommentDetailUI.G(SnsCommentDetailUI.this);
            PhotosContent localPhotosContent = SnsCommentDetailUI.this.yKm;
            TimeLineObject localTimeLineObject = this.yKC;
            String str = localp.dMu();
            SnsCommentDetailUI.E(SnsCommentDetailUI.this);
            paramAnonymousView.a(localPhotosContent, localTimeLineObject, str, SnsCommentDetailUI.this.hashCode(), SnsCommentDetailUI.F(SnsCommentDetailUI.this), -1, localp.Pe(32), false, bf.GYG, this.yKD, localp.getSnsId());
            AppMethodBeat.o(200495);
          }
          
          public final void onViewDetachedFromWindow(View paramAnonymousView)
          {
            AppMethodBeat.i(200496);
            ac.i("MicroMsg.SnsCommentDetailUI", "onViewDetachedFromWindow infoHeader");
            this.yKB = true;
            AppMethodBeat.o(200496);
          }
        });
        this.yJt.a(this.yKm, (TimeLineObject)localObject6, localp.dMu(), hashCode(), this.oeH, -1, localp.Pe(32), false, bf.GYG, (List)localObject1, localp.getSnsId());
        for (;;)
        {
          localObject5 = (TextView)this.yJe.findViewById(2131296531);
          if (!localp.tY()) {
            break label9374;
          }
          localObject3 = f(localp);
          if (localObject3 == null) {
            break label9364;
          }
          localObject1 = ((com.tencent.mm.plugin.sns.storage.a)localObject3).yeG;
          localObject3 = ((com.tencent.mm.plugin.sns.storage.a)localObject3).yeH;
          ((TextView)localObject5).setTag(localp.dMu());
          if (bs.isNullOrNil((String)localObject1)) {
            break label9364;
          }
          if (!bs.isNullOrNil((String)localObject3)) {
            break label9316;
          }
          ((TextView)localObject5).setVisibility(0);
          ((TextView)localObject5).setText((CharSequence)localObject1);
          ((TextView)localObject5).setClickable(false);
          ((TextView)localObject5).setTextColor(getContext().getResources().getColor(2131100212));
          this.yJe.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(200499);
              SnsCommentDetailUI.f(SnsCommentDetailUI.this).qG(false);
              AppMethodBeat.o(200499);
            }
          });
          ((TextView)localObject5).setOnClickListener(this.xLF.zgL);
          ((TextView)this.yJe.findViewById(2131296598)).setText(bg.q(getContext(), localp.getCreateTime() * 1000L));
          localObject5 = (AsyncTextView)this.yJe.findViewById(2131296528);
          ((TextView)localObject5).setOnClickListener(this.xLF.zgP);
          ((TextView)localObject5).setVisibility(8);
          localObject8 = (AsyncTextView)this.yJe.findViewById(2131296527);
          ((TextView)localObject8).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(98570);
              paramAnonymousView = new SnsAdClick(SnsCommentDetailUI.this.getSource(), 2, localp.field_snsId, 24, 0);
              com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, SnsCommentDetailUI.f(SnsCommentDetailUI.this), localp, 24);
              com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
              String str = this.fzF.aaS();
              paramAnonymousView = str;
              if (localp.Pe(32)) {
                paramAnonymousView = com.tencent.mm.plugin.sns.ui.widget.e.b(localp.dFR(), str);
              }
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentFlag(1);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentHint(paramAnonymousView);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).rm(true);
              SnsCommentDetailUI.H(SnsCommentDetailUI.this).setVisibility(8);
              SnsCommentDetailUI.C(SnsCommentDetailUI.this);
              AppMethodBeat.o(98570);
            }
          });
          ((TextView)localObject8).setVisibility(8);
          if (localp.tY())
          {
            localObject7 = f(localp);
            ((TextView)localObject5).setTag(localp.dMu());
            if (((com.tencent.mm.plugin.sns.storage.a)localObject7).yeI != com.tencent.mm.plugin.sns.storage.a.yeu) {
              break label9602;
            }
            if (bs.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject7).yeJ)) {
              break label9592;
            }
            ((TextView)localObject5).setText(((com.tencent.mm.plugin.sns.storage.a)localObject7).yeJ);
            ((TextView)localObject5).setVisibility(0);
            break label9890;
            if ((((TextView)localObject5).getVisibility() != 8) && (bs.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject7).yeK)))
            {
              ((TextView)localObject5).setTextColor(getResources().getColor(2131100943));
              ((TextView)localObject5).setOnClickListener(null);
            }
            if ((localp.dLV().FQo.EtA & 0x4) == 0) {
              break label10059;
            }
            ((TextView)localObject8).setTag(localp.dMu());
            ((TextView)localObject8).setVisibility(0);
            ((TextView)localObject8).setText(String.format("%s%s%s", new Object[] { getContext().getResources().getString(2131763743), localObject4, getContext().getResources().getString(2131763744) }));
          }
          localObject1 = (WeImageView)this.yJe.findViewById(2131296627);
          if (((TimeLineObject)localObject6).FQo.Ety != 30) {
            break label10069;
          }
          i = 0;
          ((WeImageView)localObject1).setVisibility(i);
          ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099660));
          localObject4 = (TextView)this.yJe.findViewById(2131296569);
          ((TextView)localObject4).setOnTouchListener(new ad());
          localObject1 = com.tencent.mm.plugin.sns.c.a.iyy.s(this, ((TimeLineObject)localObject6).FQn.Id);
          if (((TimeLineObject)localObject6).FQo.Ety != 26) {
            break label10076;
          }
          localObject1 = getString(2131758845);
          be.a((TimeLineObject)localObject6, this);
          if (!com.tencent.mm.plugin.sns.c.a.iyy.eC((String)localObject1)) {
            break label10189;
          }
          ((TextView)localObject4).setVisibility(0);
          localObject1 = new SpannableString(getString(2131763791) + (String)localObject1);
          ((SpannableString)localObject1).setSpan(new a(), 0, ((SpannableString)localObject1).length(), 33);
          ((TextView)localObject4).setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
          if ((((TimeLineObject)localObject6).FQn == null) || (!com.tencent.mm.pluginsdk.model.app.h.aGf(((TimeLineObject)localObject6).FQn.Id)))
          {
            ((TextView)localObject4).setTextColor(getResources().getColor(2131100943));
            ((TextView)localObject4).setOnTouchListener(null);
          }
          ((TextView)localObject4).setTag(localObject6);
          localObject1 = (TextView)this.yJe.findViewById(2131296566);
          if (!localp.getUserName().equals(this.fnC)) {
            break label10199;
          }
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setTag(localp.dMu() + ";" + localp.getSnsId());
          ((TextView)localObject1).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(98571);
              com.tencent.mm.ui.base.h.a(SnsCommentDetailUI.this, 2131764024, 2131755906, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(200500);
                  ac.d("MicroMsg.SnsCommentDetailUI", "to del by localId " + SnsCommentDetailUI.k(SnsCommentDetailUI.this));
                  paramAnonymous2DialogInterface = com.tencent.mm.plugin.sns.storage.h.auT(SnsCommentDetailUI.k(SnsCommentDetailUI.this));
                  if (paramAnonymous2DialogInterface == null)
                  {
                    ac.e("MicroMsg.SnsCommentDetailUI", "try to del item fail can not get snsinfo by localid %s", new Object[] { SnsCommentDetailUI.k(SnsCommentDetailUI.this) });
                    AppMethodBeat.o(200500);
                    return;
                  }
                  if (paramAnonymous2DialogInterface.Pe(32))
                  {
                    AppMethodBeat.o(200500);
                    return;
                  }
                  Object localObject;
                  if (paramAnonymous2DialogInterface.field_snsId == 0L)
                  {
                    af.dHR().Pi(paramAnonymous2DialogInterface.yvp);
                    localObject = new Intent();
                    ((Intent)localObject).putExtra("sns_gallery_op_id", x.avp(SnsCommentDetailUI.k(SnsCommentDetailUI.this)));
                    SnsCommentDetailUI.this.setResult(-1, (Intent)localObject);
                    if ((SnsCommentDetailUI.w(SnsCommentDetailUI.this)) && (!paramAnonymous2DialogInterface.isValid())) {
                      ((Intent)localObject).putExtra("sns_gallery_force_finish", true);
                    }
                    localObject = paramAnonymous2DialogInterface.dLV();
                    if (localObject != null) {
                      if (((TimeLineObject)localObject).FQn != null) {
                        break label368;
                      }
                    }
                  }
                  label368:
                  for (paramAnonymous2DialogInterface = null;; paramAnonymous2DialogInterface = ((TimeLineObject)localObject).FQn.Id)
                  {
                    if ((!bs.isNullOrNil(paramAnonymous2DialogInterface)) && (com.tencent.mm.plugin.sns.c.a.iyy.eD(paramAnonymous2DialogInterface)))
                    {
                      String str = com.tencent.mm.plugin.sns.c.a.iyy.eB(paramAnonymous2DialogInterface);
                      qq localqq = new qq();
                      localqq.dtB.appId = paramAnonymous2DialogInterface;
                      localqq.dtB.dtD = ((TimeLineObject)localObject).ncR;
                      localqq.dtB.dtC = str;
                      com.tencent.mm.sdk.b.a.GpY.l(localqq);
                    }
                    SnsCommentDetailUI.this.finish();
                    AppMethodBeat.o(200500);
                    return;
                    af.dHQ().xo(paramAnonymous2DialogInterface.field_snsId);
                    com.tencent.mm.kernel.g.agS();
                    com.tencent.mm.kernel.g.agQ().ghe.a(new com.tencent.mm.plugin.sns.model.q(paramAnonymous2DialogInterface.field_snsId, 1), 0);
                    af.dHR().delete(paramAnonymous2DialogInterface.field_snsId);
                    af.dHW().xF(paramAnonymous2DialogInterface.field_snsId);
                    com.tencent.mm.plugin.sns.storage.i.xE(paramAnonymous2DialogInterface.field_snsId);
                    break;
                  }
                }
              }, null);
              AppMethodBeat.o(98571);
            }
          });
          localObject4 = (TextView)this.yJe.findViewById(2131306999);
          localObject5 = com.tencent.mm.plugin.sns.model.aj.s(localp);
          if (localObject5 != null) {
            break label10209;
          }
          ((TextView)localObject4).setVisibility(8);
          this.yJm = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
          this.yJm.setDuration(150L);
          this.yJn = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
          this.yJn.setDuration(150L);
          if (this.yJj == null)
          {
            this.yJj = this.yJe.findViewById(2131296548);
            this.yJj.setVisibility(8);
          }
          this.yJo = ((LinearLayout)this.yJe.findViewById(2131296555));
          this.yJo.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(98573);
              if (!com.tencent.mm.plugin.sns.lucky.a.m.ato(localp.dMu()))
              {
                com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.yKm.Pr(0));
                AppMethodBeat.o(98573);
                return;
              }
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentInfo(null);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentFlag(0);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentHint(SnsCommentDetailUI.this.getString(2131764046));
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentInfo(new daa());
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setToSendTextColor(true);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).rm(true);
              if ((localp.Pe(32)) && ((localp.dLV().FQo.EtA & 0x8) != 0)) {
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).lY(true);
              }
              for (;;)
              {
                SnsCommentDetailUI.H(SnsCommentDetailUI.this).setVisibility(8);
                SnsCommentDetailUI.C(SnsCommentDetailUI.this);
                AppMethodBeat.o(98573);
                return;
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).lY(false);
              }
            }
          });
          this.yJo.setOnTouchListener(this.yzD);
          this.yJp = ((LinearLayout)this.yJe.findViewById(2131296586));
          this.yJp.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(163113);
              if ((SnsCommentDetailUI.f(SnsCommentDetailUI.this) != null) && (localp.field_likeFlag == 0)) {
                SnsCommentDetailUI.f(SnsCommentDetailUI.this).wN(localp.field_snsId);
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
              com.tencent.mm.plugin.sns.j.f.ydE.dJw().dTj = 3L;
              AppMethodBeat.o(163113);
            }
          });
          this.yJp.setOnTouchListener(this.yzD);
          localObject1 = (ImageButton)this.yJe.findViewById(2131296599);
          localObject3 = rl(true);
          if ((localObject3 != null) && ((((com.tencent.mm.plugin.sns.storage.p)localObject3).dMp() & 0x1) != 0)) {
            ((ImageButton)localObject1).setVisibility(8);
          }
          if ((localObject3 != null) && (!((com.tencent.mm.plugin.sns.storage.p)localObject3).dMt())) {
            ((ImageButton)localObject1).setVisibility(8);
          }
          localObject3 = (ImageView)this.yJp.findViewById(2131296585);
          localObject4 = (ImageView)this.yJo.findViewById(2131296554);
          localObject5 = (TextView)this.yJp.findViewById(2131296587);
          localObject6 = (TextView)this.yJo.findViewById(2131296563);
          if (this.oeH == 10)
          {
            this.yJe.findViewById(2131296548).setBackgroundResource(2131232447);
            ((ImageButton)localObject1).setImageResource(2131232932);
            ((ImageView)localObject3).setImageResource(2131232933);
            ((ImageView)localObject4).setImageResource(2131232934);
            ((TextView)localObject5).setTextColor(getResources().getColor(2131100920));
            ((TextView)localObject6).setTextColor(getResources().getColor(2131100920));
            this.yJp.setBackgroundResource(2131233161);
            this.yJo.setBackgroundResource(2131233162);
          }
          ((ImageButton)localObject1).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(200501);
              ac.d("MicroMsg.SnsCommentDetailUI", "showComment click" + SnsCommentDetailUI.H(SnsCommentDetailUI.this).getVisibility());
              com.tencent.mm.plugin.sns.ad.e.d.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a(localp, true, paramAnonymousView, SnsCommentDetailUI.f(SnsCommentDetailUI.this)));
              paramAnonymousView = localp.dLV();
              if ((paramAnonymousView != null) && (paramAnonymousView.FQo.Ety == 21) && (!com.tencent.mm.plugin.sns.lucky.a.m.ato(localp.dMu())))
              {
                com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.yKm.Pr(0));
                AppMethodBeat.o(200501);
                return;
              }
              if (SnsCommentDetailUI.H(SnsCommentDetailUI.this).getVisibility() == 0)
              {
                SnsCommentDetailUI.g(SnsCommentDetailUI.this);
                AppMethodBeat.o(200501);
                return;
              }
              SnsCommentDetailUI.H(SnsCommentDetailUI.this).setVisibility(0);
              SnsCommentDetailUI.H(SnsCommentDetailUI.this).startAnimation(SnsCommentDetailUI.J(SnsCommentDetailUI.this));
              if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10) {
                SnsCommentDetailUI.z(SnsCommentDetailUI.this).findViewById(2131296548).setBackgroundResource(2131232447);
              }
              if (!x.avq(SnsCommentDetailUI.o(SnsCommentDetailUI.this)))
              {
                SnsCommentDetailUI.this.yJo.setEnabled(false);
                SnsCommentDetailUI.this.yJp.setEnabled(false);
                this.yKF.setText(SnsCommentDetailUI.this.getString(2131763882));
                this.yKF.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131100911));
                this.yKG.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131100911));
                if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10)
                {
                  this.yKH.setImageResource(2131690238);
                  AppMethodBeat.o(200501);
                  return;
                }
                this.yKH.setImageResource(2131690241);
                AppMethodBeat.o(200501);
                return;
              }
              SnsCommentDetailUI.this.yJo.setEnabled(true);
              this.yKH.setImageResource(2131232452);
              SnsCommentDetailUI.this.yJp.setEnabled(true);
              this.yKF.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101182));
              this.yKG.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101182));
              paramAnonymousView = com.tencent.mm.plugin.sns.storage.h.auS(SnsCommentDetailUI.o(SnsCommentDetailUI.this));
              if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10)
              {
                this.yKH.setImageResource(2131232933);
                this.yKI.setImageResource(2131232934);
                this.yKF.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131100920));
                this.yKG.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131100920));
              }
              while (paramAnonymousView.field_likeFlag == 0)
              {
                this.yKF.setText(SnsCommentDetailUI.this.getString(2131763882));
                AppMethodBeat.o(200501);
                return;
                this.yKH.setImageResource(2131232452);
                this.yKF.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101182));
                this.yKG.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101182));
              }
              this.yKF.setText(SnsCommentDetailUI.this.getString(2131763839));
              AppMethodBeat.o(200501);
            }
          });
          AppMethodBeat.o(98604);
          return true;
          if (((com.tencent.mm.plugin.sns.storage.b)localObject3).yfV == 1)
          {
            i = k - com.tencent.mm.cc.a.au(this, 2131166827) - com.tencent.mm.cc.a.au(this, 2131166827) - com.tencent.mm.cc.a.au(this, 2131165575) - com.tencent.mm.cc.a.au(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
            j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfX / ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfW);
            localObject5 = new bub();
            if (i > 0) {
              f2 = i;
            }
            ((bub)localObject5).FjY = f2;
            if (j > 0) {
              f1 = j;
            }
            ((bub)localObject5).FjZ = f1;
            ((bub)localObject5).Fka = (((bub)localObject5).FjY * ((bub)localObject5).FjZ);
            ((LinkedList)localObject1).add(localObject5);
            break;
          }
          if (((com.tencent.mm.plugin.sns.storage.b)localObject3).yfV != 2) {
            break;
          }
          i = k - com.tencent.mm.cc.a.au(this, 2131166827) - com.tencent.mm.cc.a.au(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
          j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfX / ((com.tencent.mm.plugin.sns.storage.b)localObject3).yfW);
          localObject5 = new bub();
          if (i > 0) {
            f2 = i;
          }
          ((bub)localObject5).FjY = f2;
          if (j > 0) {
            f1 = j;
          }
          ((bub)localObject5).FjZ = f1;
          ((bub)localObject5).Fka = (((bub)localObject5).FjY * ((bub)localObject5).FjZ);
          ((LinkedList)localObject1).add(localObject5);
          break;
          ac.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.oeH + ",stub is " + ((ViewStub)localObject1).toString());
          continue;
          if (this.oeH != 10) {
            break label4452;
          }
          this.yKm = ((PhotosContent)findViewById(2131300686));
          this.yKm.dOu();
          localObject1 = (TagImageView)this.yKm.findViewById(2131296575);
          this.yKm.a((TagImageView)localObject1);
          ((TagImageView)localObject1).setOnClickListener(this.xLF.yAf);
          localObject3 = localp.dMu();
          localObject5 = new ArrayList();
          ((List)localObject5).add(localObject1);
          localObject8 = new aw();
          ((aw)localObject8).dgl = ((String)localObject3);
          ((aw)localObject8).index = 0;
          ((aw)localObject8).yMc = ((List)localObject5);
          ((aw)localObject8).yIK = true;
          if (localObject1 != null) {
            ((TagImageView)localObject1).setTag(localObject8);
          }
          localObject1 = (TextView)this.yJe.findViewById(2131300687);
          if (!u.axw().equals(((TimeLineObject)localObject6).ncR))
          {
            localObject3 = com.tencent.mm.plugin.sns.model.aj.t(localp);
            if ((((SnsObject)localObject3).SnsRedEnvelops != null) && (((SnsObject)localObject3).SnsRedEnvelops.FKi != 0))
            {
              ((TextView)localObject1).setText(getString(2131760986, new Object[] { Integer.valueOf(((SnsObject)localObject3).SnsRedEnvelops.FKi) }));
              ((TextView)localObject1).setVisibility(0);
            }
          }
          for (;;)
          {
            localObject1 = localp.dMn();
            if (localObject1 == null) {
              break label4422;
            }
            if (!u.axw().equals(((TimeLineObject)localObject6).ncR)) {
              break label4306;
            }
            this.yJt.a(this.yKm, (TimeLineObject)localObject6, localp.dMu(), hashCode(), this.oeH, -1, false, bf.GYG, true);
            break;
            ((TextView)localObject1).setVisibility(8);
            continue;
            ((TextView)localObject1).setVisibility(8);
          }
          if (com.tencent.mm.plugin.sns.lucky.a.m.n(localp))
          {
            this.yJt.a(this.yKm, (TimeLineObject)localObject6, localp.dMu(), hashCode(), this.oeH, -1, false, bf.GYG, false);
          }
          else if (((bua)localObject1).dBA == 0)
          {
            this.yJt.a(this.yKm, (TimeLineObject)localObject6, localp.dMu(), hashCode(), this.oeH, -1, false, bf.GYG, true);
          }
          else
          {
            ac.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo.hbStatus is " + ((bua)localObject1).dBA);
            continue;
            ac.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo is null " + localp.dMu());
          }
        }
        Object localObject9;
        Object localObject10;
        if (this.oeH == 9)
        {
          this.yJN = true;
          localObject3 = new an();
          localObject9 = this.yJe;
          localObject5 = ((View)localObject9).findViewById(2131298069);
          localObject8 = (VideoSightView)((View)localObject9).findViewById(2131300914);
          ((an)localObject3).yFc = ((View)localObject9);
          ((an)localObject3).yFf = ((View)localObject5);
          ((an)localObject3).yoI = ((ImageView)((View)localObject9).findViewById(2131305196));
          ((an)localObject3).yFg = ((MMPinProgressBtn)((View)localObject9).findViewById(2131303515));
          ((an)localObject3).yoJ = ((TextView)((View)localObject9).findViewById(2131299517));
          ((an)localObject3).yFh = ((TextView)((View)localObject9).findViewById(2131299492));
          ((an)localObject3).yFd = ((VideoSightView)localObject8);
          ((an)localObject3).yFd.setMute(true);
          ((an)localObject3).a((TimeLineObject)localObject6, 0, localp.dMu(), localp.tY());
          ((an)localObject3).yoJ.setVisibility(8);
          ((an)localObject3).yFd.setTagObject(localObject3);
          ((an)localObject3).yFd.setIsAdVideo(localp.tY());
          ((an)localObject3).yFi = 5;
          ((View)localObject5).setTag(localObject3);
          ((an)localObject3).yFf.setOnClickListener(this.xLF.zgM);
          if (!localp.dJL())
          {
            this.nym.c((View)localObject5, this.xLF.zgF, this.xLF.zgp);
            if ((!localp.tY()) || (!com.tencent.mm.plugin.sns.data.j.d((TimeLineObject)localObject6))) {
              break label5498;
            }
            localObject1 = com.tencent.mm.modelsns.g.a((TimeLineObject)localObject6, ((an)localObject3).yFd.getUIContext(), false);
            ac.i("MicroMsg.SnsCommentDetailUI", "isVerticalAdVideo=true, snsId=" + localp.field_snsId + ", showW=" + ((Pair)localObject1).first + ", showH=" + ((Pair)localObject1).second);
            i = 1;
            if (!localp.tY()) {
              break label10724;
            }
            localObject10 = localp.dFR();
            if ((localObject10 == null) || (!((com.tencent.mm.plugin.sns.storage.b)localObject10).dJL()) || (((com.tencent.mm.plugin.sns.storage.b)localObject10).yfW <= 0.0F) || (((com.tencent.mm.plugin.sns.storage.b)localObject10).yfX <= 0.0F)) {
              break label10724;
            }
            f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject10).yfW, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject10).yfY, ((com.tencent.mm.plugin.sns.storage.b)localObject10).yfZ);
            f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject10).yfX, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject10).yfY, ((com.tencent.mm.plugin.sns.storage.b)localObject10).yfZ);
            if (((com.tencent.mm.plugin.sns.storage.b)localObject10).yfV != 0) {
              break label5524;
            }
            if (f2 < k - com.tencent.mm.cc.a.au(this, 2131166827) - com.tencent.mm.cc.a.au(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516)) {
              break label10727;
            }
            f2 = k - com.tencent.mm.cc.a.au(this, 2131166827) - com.tencent.mm.cc.a.au(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
            f1 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject10).yfX * f2 / ((com.tencent.mm.plugin.sns.storage.b)localObject10).yfW);
          }
        }
        for (;;)
        {
          localObject1 = Pair.create(Integer.valueOf((int)f2), Integer.valueOf((int)f1));
          for (;;)
          {
            if (localObject1 != null)
            {
              if ((((an)localObject3).yFd instanceof SightPlayImageView))
              {
                if (!localp.tY())
                {
                  ((an)localObject3).yFd.setScaleMode(1);
                  ((an)localObject3).yFd.setScaleType(QImageView.a.JbU);
                }
              }
              else
              {
                ((VideoSightView)localObject8).hf(((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue());
                if ((((an)localObject3).yFd instanceof SightPlayImageView))
                {
                  if (i == 0) {
                    break label5757;
                  }
                  ((an)localObject3).yFd.dEL();
                }
                label5110:
                localObject10 = ((an)localObject3).yFh.getLayoutParams();
                ((ViewGroup.LayoutParams)localObject10).width = ((Integer)((Pair)localObject1).first).intValue();
                ((ViewGroup.LayoutParams)localObject10).height = ((Integer)((Pair)localObject1).second).intValue();
                ((an)localObject3).yFh.setLayoutParams((ViewGroup.LayoutParams)localObject10);
                localObject9 = (FrameLayout)((View)localObject9).findViewById(2131305105);
                localObject10 = (FrameLayout.LayoutParams)((FrameLayout)localObject9).getLayoutParams();
                ((FrameLayout.LayoutParams)localObject10).width = ((Integer)((Pair)localObject1).first).intValue();
                ((FrameLayout.LayoutParams)localObject10).height = ((Integer)((Pair)localObject1).second).intValue();
                ((FrameLayout)localObject9).setLayoutParams((ViewGroup.LayoutParams)localObject10);
              }
            }
            else
            {
              if ((((TimeLineObject)localObject6).FQo == null) || (((TimeLineObject)localObject6).FQo.Etz.size() <= 0)) {
                break label5769;
              }
              localObject1 = (btz)((TimeLineObject)localObject6).FQo.Etz.get(0);
              if (localp.tY())
              {
                ((an)localObject3).yFd.setOnCompletionListener(new b.e()
                {
                  public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(200497);
                    if (paramAnonymousInt != -1)
                    {
                      if (SnsCommentDetailUI.f(SnsCommentDetailUI.this) == null)
                      {
                        AppMethodBeat.o(200497);
                        return;
                      }
                      SnsCommentDetailUI.f(SnsCommentDetailUI.this).A(localp.field_snsId, false);
                    }
                    AppMethodBeat.o(200497);
                  }
                });
                ((an)localObject3).yFd.setOnDecodeDurationListener(new b.f()
                {
                  public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
                  {
                    AppMethodBeat.i(200498);
                    ac.d("MicroMsg.SnsCommentDetailUI", "onDecodeProgress:".concat(String.valueOf(paramAnonymousLong)));
                    if ((SnsCommentDetailUI.f(SnsCommentDetailUI.this) != null) && (localp != null))
                    {
                      SnsCommentDetailUI.f(SnsCommentDetailUI.this).wP(localp.field_snsId);
                      SnsCommentDetailUI.f(SnsCommentDetailUI.this).ah(localp.field_snsId, 1000L * paramAnonymousLong);
                      if (!SnsCommentDetailUI.f(SnsCommentDetailUI.this).wM(localp.field_snsId))
                      {
                        int i = (int)paramAnonymousb.dED();
                        ac.i("MicroMsg.SnsCommentDetailUI", "updatePlayStartTime, duration=".concat(String.valueOf(i)));
                        SnsCommentDetailUI.f(SnsCommentDetailUI.this).d(localp.field_snsId, bs.Gn(), false);
                        SnsCommentDetailUI.f(SnsCommentDetailUI.this).e(localp.field_snsId, i, false);
                        SnsCommentDetailUI.f(SnsCommentDetailUI.this).ag(localp.field_snsId, localp.field_snsId);
                      }
                    }
                    AppMethodBeat.o(200498);
                  }
                });
              }
              if ((((TimeLineObject)localObject6).FQo == null) || (((TimeLineObject)localObject6).FQo.Etz.size() <= 0)) {
                break;
              }
              af.dHO();
              if (com.tencent.mm.plugin.sns.model.f.t((btz)localObject1)) {
                break label5878;
              }
              if (!af.dHO().w((btz)localObject1)) {
                break label5775;
              }
              ((an)localObject3).yoI.setVisibility(8);
              ((an)localObject3).yFg.setVisibility(0);
              ((an)localObject3).yFg.fuE();
              ((VideoSightView)localObject8).setTagObject(localObject3);
              af.dHO().a(localp, (btz)localObject1, (VideoSightView)localObject8, hashCode(), 0, bf.GYG, localp.tY());
              ((VideoSightView)localObject8).start();
              ((View)localObject5).setTag(localObject3);
              if (this.yJJ == null) {
                break;
              }
              if (!localp.tY()) {
                break label6162;
              }
              if (af.dHO().r(localp) != 5) {
                break label6156;
              }
              bool = true;
            }
            for (;;)
            {
              this.yJJ.C(localp.field_snsId, bool);
              break;
              this.nym.c((View)localObject5, this.xLF.zgH, this.xLF.zgp);
              break label4708;
              label5498:
              localObject1 = com.tencent.mm.modelsns.g.a((TimeLineObject)localObject6, ((an)localObject3).yFd.getUIContext(), localp.tY());
              i = 0;
              break label4798;
              if (((com.tencent.mm.plugin.sns.storage.b)localObject10).yfV == 1)
              {
                j = k - com.tencent.mm.cc.a.au(this, 2131166827) - com.tencent.mm.cc.a.au(this, 2131166827) - com.tencent.mm.cc.a.au(this, 2131165575) - com.tencent.mm.cc.a.au(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
                localObject1 = Pair.create(Integer.valueOf(j), Integer.valueOf((int)(j * ((com.tencent.mm.plugin.sns.storage.b)localObject10).yfX / ((com.tencent.mm.plugin.sns.storage.b)localObject10).yfW)));
                break label5015;
              }
              if (((com.tencent.mm.plugin.sns.storage.b)localObject10).yfV != 2) {
                break label10724;
              }
              j = k - com.tencent.mm.cc.a.au(this, 2131166827) - com.tencent.mm.cc.a.au(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
              localObject1 = Pair.create(Integer.valueOf(j), Integer.valueOf((int)(j * ((com.tencent.mm.plugin.sns.storage.b)localObject10).yfX / ((com.tencent.mm.plugin.sns.storage.b)localObject10).yfW)));
              break label5015;
              if (i != 0)
              {
                ((an)localObject3).yFd.setScaleMode(1);
                ((an)localObject3).yFd.setScaleType(QImageView.a.JbU);
                break label5059;
              }
              ((an)localObject3).yFd.setScaleMode(0);
              ((an)localObject3).yFd.setScaleType(QImageView.a.JbP);
              break label5059;
              label5757:
              ((an)localObject3).yFd.setDrawWidthAndHeightFix(false);
              break label5110;
              localObject1 = null;
              break label5263;
              if ((localp.tY()) && (af.dHO().r(localp) == 5))
              {
                af.dHO().A((btz)localObject1);
                ((an)localObject3).yoI.setVisibility(8);
                ((an)localObject3).yFg.setVisibility(0);
                ((an)localObject3).yFg.fuE();
                break label5379;
              }
              af.dHO().y((btz)localObject1);
              ((an)localObject3).yoI.setVisibility(0);
              ((an)localObject3).yFg.setVisibility(8);
              ((an)localObject3).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this, 2131691166));
              break label5379;
              label5878:
              if (af.dHO().u((btz)localObject1))
              {
                ((an)localObject3).yoI.setVisibility(0);
                ((an)localObject3).yFg.setVisibility(8);
                ((an)localObject3).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this, 2131691166));
              }
              for (;;)
              {
                if (!((an)localObject3).yFd.dEM()) {
                  break label6154;
                }
                ac.d("MicroMsg.SnsCommentDetailUI", "play video error " + ((btz)localObject1).Id + " " + ((btz)localObject1).Url + " " + ((btz)localObject1).Fjh);
                af.dHO().y((btz)localObject1);
                ((an)localObject3).yoI.setVisibility(0);
                ((an)localObject3).yFg.setVisibility(8);
                ((an)localObject3).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this, 2131691166));
                break;
                if (af.dHO().v((btz)localObject1))
                {
                  ((an)localObject3).yoI.setVisibility(8);
                  ((an)localObject3).yFg.setVisibility(8);
                }
                else if ((localp.tY()) && (af.dHO().r(localp) <= 5))
                {
                  ((an)localObject3).yoI.setVisibility(8);
                  ((an)localObject3).yFg.setVisibility(8);
                }
                else
                {
                  af.dHO().y((btz)localObject1);
                  ((an)localObject3).yoI.setVisibility(0);
                  ((an)localObject3).yFg.setVisibility(8);
                  ((an)localObject3).yoI.setImageDrawable(com.tencent.mm.cc.a.l(this, 2131691166));
                }
              }
              break label5379;
              bool = false;
              continue;
              if (af.dHO().q(localp) == 5) {
                bool = true;
              } else {
                bool = false;
              }
            }
            if (this.oeH == 0)
            {
              localObject1 = (LinearLayout)this.yJe.findViewById(2131305006);
              localObject3 = Pv(2131495567);
              if (!this.yKj)
              {
                ((LinearLayout)localObject1).removeView(this.yKm);
                ((LinearLayout)localObject1).addView((View)localObject3, 3);
                if (((LinearLayout)localObject3).getLayoutParams() == null) {
                  break label6578;
                }
              }
              for (localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject3).getLayoutParams());; localObject1 = new LinearLayout.LayoutParams(-1, -2))
              {
                ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cc.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
                if (((TimeLineObject)localObject6).FQo.Etz.isEmpty()) {
                  break label6593;
                }
                localObject5 = (btz)((TimeLineObject)localObject6).FQo.Etz.get(0);
                localObject1 = (MMImageView)((LinearLayout)localObject3).findViewById(2131300948);
                af.dHO().a((btz)localObject5, (View)localObject1, 2131689564, hashCode(), bf.GYG);
                this.yJx = ((ImageView)((LinearLayout)localObject3).findViewById(2131305185));
                this.yJx.setOnTouchListener(this.yzD);
                this.dnX = ((TimeLineObject)localObject6).Id;
                dPw();
                bool = getIntent().getBooleanExtra("SNS_FROM_MUSIC_ITEM", false);
                ((MMImageView)localObject1).setTag(new s((TimeLineObject)localObject6, this.yJu, bool));
                ((MMImageView)localObject1).setOnClickListener(this.yJC.yYu);
                localObject8 = ((btz)localObject5).Desc;
                if (!bs.isNullOrNil((String)localObject8)) {
                  ((TextView)((LinearLayout)localObject3).findViewById(2131304202)).setText((CharSequence)localObject8);
                }
                localObject5 = ((btz)localObject5).Title;
                if (!bs.isNullOrNil((String)localObject5)) {
                  ((TextView)((LinearLayout)localObject3).findViewById(2131305950)).setText(new SpannableString((CharSequence)localObject5), TextView.BufferType.SPANNABLE);
                }
                ((LinearLayout)localObject3).setTag(new s((TimeLineObject)localObject6, this.yJu));
                this.nym.c((View)localObject3, this.xLF.zgE, this.xLF.zgp);
                ((LinearLayout)localObject3).setOnClickListener(this.yJC.yQc);
                com.tencent.mm.plugin.sns.data.q.b((View)localObject1, this);
                break;
              }
              ((LinearLayout)localObject3).setVisibility(8);
              break;
            }
            if (this.oeH == 13)
            {
              this.yJf.setVisibility(8);
              this.yJk.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
              break;
            }
            if ((this.oeH == 11) || (this.oeH == 14) || (this.oeH == 15)) {
              break;
            }
            if (this.oeH == 16)
            {
              localObject1 = (LinearLayout)this.yJe.findViewById(2131305006);
              localObject5 = Pv(2131495565);
              if (!this.yKj)
              {
                ((LinearLayout)localObject1).removeView(this.yKm);
                ((LinearLayout)localObject1).addView((View)localObject5, 3);
                if (((LinearLayout)localObject5).getLayoutParams() != null)
                {
                  localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject5).getLayoutParams());
                  ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cc.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                  ((LinearLayout)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject1);
                }
              }
              else
              {
                localObject8 = (MMImageView)((LinearLayout)localObject5).findViewById(2131300948);
                ((MMImageView)localObject8).setVisibility(0);
                localObject9 = (TextView)((LinearLayout)localObject5).findViewById(2131305950);
                if (((TimeLineObject)localObject6).FQo.EtD == null) {
                  break label7247;
                }
                ac.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderShareObject not null");
                if ((!bs.isNullOrNil(((TimeLineObject)localObject6).FQo.EtD.nickname)) || (bs.isNullOrNil(((TimeLineObject)localObject6).FQo.EtD.desc))) {
                  break label7151;
                }
                localObject1 = ((TimeLineObject)localObject6).FQo.EtD.desc;
              }
              for (;;)
              {
                ((TextView)localObject9).setText(new SpannableString((CharSequence)localObject1), TextView.BufferType.SPANNABLE);
                ((TextView)localObject9).setMaxLines(2);
                if (!((TimeLineObject)localObject6).FQo.EtD.mediaList.isEmpty())
                {
                  localObject1 = new btz();
                  ((btz)localObject1).Url = ((anw)((TimeLineObject)localObject6).FQo.EtD.mediaList.get(0)).thumbUrl;
                  ((btz)localObject1).Fjh = ((anw)((TimeLineObject)localObject6).FQo.EtD.mediaList.get(0)).thumbUrl;
                  ((btz)localObject1).ndI = 2;
                  ((btz)localObject1).Fji = 1;
                  ((btz)localObject1).Fjk = new bub();
                  ((btz)localObject1).EUH = 1;
                  ((btz)localObject1).Fjk.FjY = ((anw)((TimeLineObject)localObject6).FQo.EtD.mediaList.get(0)).width;
                  ((btz)localObject1).Fjk.FjZ = ((anw)((TimeLineObject)localObject6).FQo.EtD.mediaList.get(0)).height;
                  ((btz)localObject1).Id = localp.getSnsId();
                  af.dHO().b((btz)localObject1, (View)localObject8, hashCode(), bf.fbk().YL(((TimeLineObject)localObject6).CreateTime));
                }
                ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject6, this.yJu));
                ((LinearLayout)localObject5).setOnClickListener(this.yJC.yQc);
                break;
                localObject1 = new LinearLayout.LayoutParams(-1, -2);
                break label6747;
                if (!bs.isNullOrNil(((TimeLineObject)localObject6).FQo.EtD.desc)) {
                  localObject1 = ((TimeLineObject)localObject6).FQo.EtD.nickname + ": " + ((TimeLineObject)localObject6).FQo.EtD.desc;
                } else {
                  localObject1 = getString(2131763973, new Object[] { ((TimeLineObject)localObject6).FQo.EtD.nickname });
                }
              }
              if (((TimeLineObject)localObject6).FQo.EtE == null) {
                break;
              }
              ac.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderShareTopic not null");
              localObject3 = getString(2131755778);
              if (((TimeLineObject)localObject6).FQo.EtE != null) {
                if (((TimeLineObject)localObject6).FQo.EtE.rPI != 1) {
                  break label7571;
                }
              }
              for (localObject1 = "#" + ((TimeLineObject)localObject6).FQo.EtE.dol;; localObject1 = ((TimeLineObject)localObject6).FQo.EtE.dol)
              {
                localObject3 = localObject1;
                if (!bs.isNullOrNil(((TimeLineObject)localObject6).FQo.EtE.desc))
                {
                  localObject3 = (TextView)((LinearLayout)localObject5).findViewById(2131304202);
                  ((TextView)localObject3).setVisibility(0);
                  ((TextView)localObject3).setText(((TimeLineObject)localObject6).FQo.EtE.desc);
                  localObject3 = localObject1;
                }
                ((TextView)localObject9).setText(new SpannableString((CharSequence)localObject3), TextView.BufferType.SPANNABLE);
                ((TextView)localObject9).setMaxLines(2);
                localObject1 = new btz();
                ((btz)localObject1).Url = ((TimeLineObject)localObject6).FQo.EtE.iconUrl;
                ((btz)localObject1).Fjh = ((TimeLineObject)localObject6).FQo.EtE.iconUrl;
                ((btz)localObject1).ndI = 2;
                ((btz)localObject1).Fji = 1;
                ((btz)localObject1).Fjk = new bub();
                ((btz)localObject1).EUH = 1;
                ((btz)localObject1).Fjk.FjY = 0.0F;
                ((btz)localObject1).Fjk.FjZ = 0.0F;
                ((btz)localObject1).Id = localp.getSnsId();
                af.dHO().b((btz)localObject1, (View)localObject8, hashCode(), bf.fbk().YL(((TimeLineObject)localObject6).CreateTime));
                ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject6, this.yJu));
                ((LinearLayout)localObject5).setOnClickListener(this.yJC.yQc);
                break;
              }
            }
            localObject1 = (LinearLayout)this.yJe.findViewById(2131305006);
            localObject8 = Pv(2131495565);
            localObject9 = (MMImageView)((LinearLayout)localObject8).findViewById(2131300948);
            if (!this.yKj)
            {
              ((LinearLayout)localObject1).removeView(this.yKm);
              ((LinearLayout)localObject1).addView((View)localObject8, 3);
              if (((LinearLayout)localObject8).getLayoutParams() != null)
              {
                localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject8).getLayoutParams());
                label7670:
                ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cc.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                ((LinearLayout)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject1);
              }
            }
            else
            {
              i = 0;
              if (!localp.tY()) {
                break label8145;
              }
              if (localp.dFR().dJK())
              {
                i = 1;
                ((LinearLayout)localObject8).setTag(localp);
                ((LinearLayout)localObject8).setTag(2131301433, localObject9);
                ((LinearLayout)localObject8).setOnClickListener(this.xLF.zhe);
              }
              j = 0;
            }
            for (;;)
            {
              if (i != 0)
              {
                this.nym.c((View)localObject8, this.xLF.zgI, this.xLF.zgp);
                if (!dPs()) {
                  break label8918;
                }
                localObject1 = be.avL(((TimeLineObject)localObject6).FQo.Url);
                label7807:
                localObject3 = ((TimeLineObject)localObject6).FQo.Title;
                if (i != 0) {
                  localObject1 = ((TimeLineObject)localObject6).FQo.Desc;
                }
                if ((((TimeLineObject)localObject6).FQo.EtC == null) || (((TimeLineObject)localObject6).FQo.EtC.hhb != 1)) {
                  break label10712;
                }
                localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761345);
              }
              for (;;)
              {
                ((LinearLayout)localObject8).findViewById(2131305185).setVisibility(8);
                if (!((TimeLineObject)localObject6).FQo.Etz.isEmpty())
                {
                  ((MMImageView)localObject9).setVisibility(0);
                  localObject5 = (btz)((TimeLineObject)localObject6).FQo.Etz.get(0);
                  if (((TimeLineObject)localObject6).FQo.Ety == 15)
                  {
                    ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setImageResource(2131233395);
                    ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setVisibility(0);
                    af.dHO().a((btz)localObject5, (View)localObject9, 2131689581, hashCode(), bf.fbk().YL(((TimeLineObject)localObject6).CreateTime));
                    localObject5 = localObject3;
                    localObject3 = localObject1;
                    localObject1 = localObject5;
                    com.tencent.mm.plugin.sns.data.q.b((View)localObject9, this);
                    if (((TimeLineObject)localObject6).FQo.Ety != 15) {
                      break label10709;
                    }
                    localObject1 = getString(2131763826);
                    localObject3 = "";
                  }
                }
                for (;;)
                {
                  localObject5 = (TextView)((LinearLayout)localObject8).findViewById(2131305950);
                  if (!bs.isNullOrNil((String)localObject3))
                  {
                    ((LinearLayout)localObject8).findViewById(2131304202).setVisibility(0);
                    ((TextView)((LinearLayout)localObject8).findViewById(2131304202)).setText((CharSequence)localObject3);
                    ((TextView)localObject5).setMaxLines(1);
                  }
                  for (;;)
                  {
                    if (!bs.isNullOrNil((String)localObject1))
                    {
                      ((TextView)localObject5).setVisibility(0);
                      if (j != 0)
                      {
                        ((TextView)localObject5).setText(com.tencent.mm.plugin.sns.data.q.a((String)localObject1, getContext(), (TextView)localObject5));
                        break;
                        localObject1 = new LinearLayout.LayoutParams(-1, -2);
                        break label7670;
                        if (((TimeLineObject)localObject6).FQo.Ety == 9)
                        {
                          if (((TimeLineObject)localObject6).FQo.Etz.size() <= 0) {
                            break label10715;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.yJu));
                          ((LinearLayout)localObject8).setOnClickListener(this.yJC.yYo);
                          i = 0;
                          j = 0;
                          break label7760;
                        }
                        if (((TimeLineObject)localObject6).FQo.Ety == 10)
                        {
                          if (((TimeLineObject)localObject6).FQo.Etz.size() <= 0) {
                            break label10715;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.yJu));
                          ((LinearLayout)localObject8).setOnClickListener(this.yJC.yYq);
                          i = 0;
                          j = 0;
                          break label7760;
                        }
                        if (((TimeLineObject)localObject6).FQo.Ety == 17)
                        {
                          if (((TimeLineObject)localObject6).FQo.Etz.size() <= 0) {
                            break label10715;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.yJu));
                          ((LinearLayout)localObject8).setOnClickListener(this.yJC.yYr);
                          i = 0;
                          j = 0;
                          break label7760;
                        }
                        if (((TimeLineObject)localObject6).FQo.Ety == 22)
                        {
                          if (((TimeLineObject)localObject6).FQo.Etz.size() <= 0) {
                            break label10715;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.yJu));
                          ((LinearLayout)localObject8).setOnClickListener(this.yJC.yYs);
                          i = 0;
                          j = 0;
                          break label7760;
                        }
                        if (((TimeLineObject)localObject6).FQo.Ety == 23)
                        {
                          if (((TimeLineObject)localObject6).FQo.Etz.size() <= 0) {
                            break label10715;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.yJu));
                          ((LinearLayout)localObject8).setOnClickListener(this.yJC.yYt);
                          i = 0;
                          j = 0;
                          break label7760;
                        }
                        if (((TimeLineObject)localObject6).FQo.Ety == 14)
                        {
                          if (((TimeLineObject)localObject6).FQo.Etz.size() <= 0) {
                            break label10715;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.yJu));
                          ((LinearLayout)localObject8).setOnClickListener(this.yJC.yYp);
                          i = 0;
                          j = 0;
                          break label7760;
                        }
                        if (((TimeLineObject)localObject6).FQo.Ety == 12)
                        {
                          if (((TimeLineObject)localObject6).FQo.Etz.size() <= 0) {
                            break label10715;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.yJu));
                          ((LinearLayout)localObject8).setOnClickListener(this.yJC.yYy);
                          i = 0;
                          j = 0;
                          break label7760;
                        }
                        if (((TimeLineObject)localObject6).FQo.Ety == 30)
                        {
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.yJu));
                          ((LinearLayout)localObject8).setOnClickListener(this.yJC.yYw);
                          i = 0;
                          j = 0;
                          break label7760;
                        }
                        if (((TimeLineObject)localObject6).FQo.Ety == 13)
                        {
                          if (((TimeLineObject)localObject6).FQo.Etz.size() <= 0) {
                            break label10715;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.yJu));
                          ((LinearLayout)localObject8).setOnClickListener(this.yJC.yYz);
                          i = 0;
                          j = 0;
                          break label7760;
                        }
                        if (((TimeLineObject)localObject6).FQo.Ety == 15)
                        {
                          if (((TimeLineObject)localObject6).FQo.Etz.size() <= 0) {
                            break label10715;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.yJu));
                          ((LinearLayout)localObject8).setOnClickListener(this.xLF.zgN);
                          i = 0;
                          j = 0;
                          break label7760;
                        }
                        if (((TimeLineObject)localObject6).FQo.Ety == 26)
                        {
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.yJu));
                          ((LinearLayout)localObject8).setOnClickListener(this.yJC.yYA);
                          i = 0;
                          j = 0;
                          break label7760;
                        }
                        ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.yJu));
                        ((LinearLayout)localObject8).setOnClickListener(this.yJC.yQc);
                        if ((((TimeLineObject)localObject6).hhK & 0x1) <= 0) {
                          break label10715;
                        }
                        i = 0;
                        j = 1;
                        break label7760;
                        this.nym.c((View)localObject8, this.xLF.zgE, this.xLF.zgp);
                        break label7788;
                        localObject1 = "";
                        break label7807;
                        if (((TimeLineObject)localObject6).FQo.Ety == 5)
                        {
                          localObject3 = be.avL(((btz)localObject5).Url);
                          localObject1 = ((btz)localObject5).Title;
                          ((LinearLayout)localObject8).findViewById(2131305185).setVisibility(0);
                          af.dHO().a((btz)localObject5, (View)localObject9, 2131689581, hashCode(), bf.GYG);
                          break label8004;
                        }
                        if (((TimeLineObject)localObject6).FQo.Ety == 18)
                        {
                          ((LinearLayout)localObject8).findViewById(2131305185).setVisibility(0);
                          ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setImageResource(2131234474);
                          ((MMImageView)localObject9).setVisibility(0);
                          af.dHO().a((btz)localObject5, (View)localObject9, 2131689581, hashCode(), bf.GYG);
                          localObject5 = localObject1;
                          localObject1 = localObject3;
                          localObject3 = localObject5;
                          break label8004;
                        }
                        af.dHO().b((btz)localObject5, (View)localObject9, hashCode(), bf.GYG);
                        localObject5 = localObject1;
                        localObject1 = localObject3;
                        localObject3 = localObject5;
                        break label8004;
                        if (((TimeLineObject)localObject6).FQo.Ety == 18)
                        {
                          ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setVisibility(0);
                          ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setImageResource(2131234474);
                          ((MMImageView)localObject9).setVisibility(0);
                          af.dHO().c((View)localObject9, -1, 2131689581, hashCode());
                          localObject5 = localObject1;
                          localObject1 = localObject3;
                          localObject3 = localObject5;
                          break label8004;
                        }
                        if (((TimeLineObject)localObject6).FQo.Ety == 26)
                        {
                          ((MMImageView)localObject9).setVisibility(0);
                          af.dHO().c((View)localObject9, -1, 2131690949, hashCode());
                          localObject5 = localObject1;
                          localObject1 = localObject3;
                          localObject3 = localObject5;
                          break label8004;
                        }
                        ((MMImageView)localObject9).setVisibility(0);
                        af.dHO().c((View)localObject9, -1, 2131689584, hashCode());
                        localObject5 = localObject1;
                        localObject1 = localObject3;
                        localObject3 = localObject5;
                        break label8004;
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
                  if (bs.isNullOrNil((String)localObject1)) {
                    break label2484;
                  }
                  ((TextView)localObject5).setTextColor(getContext().getResources().getColor(2131099769));
                  ((TextView)localObject5).setClickable(true);
                  ((TextView)localObject5).setText((CharSequence)localObject1);
                  break label2515;
                  ((TextView)localObject5).setVisibility(8);
                  break label2515;
                  if (((TimeLineObject)localObject6).FQm == null)
                  {
                    localObject1 = null;
                    if (((TimeLineObject)localObject6).FQm != null) {
                      break label9445;
                    }
                  }
                  for (localObject3 = null;; localObject3 = ((TimeLineObject)localObject6).FQm.gPy)
                  {
                    ((TextView)localObject5).setTag(localp.dMu());
                    if ((!bs.isNullOrNil((String)localObject1)) || (!bs.isNullOrNil((String)localObject3))) {
                      break label9458;
                    }
                    ((TextView)localObject5).setVisibility(8);
                    break;
                    localObject1 = ((TimeLineObject)localObject6).FQm.iJV;
                    break label9385;
                  }
                  ((TextView)localObject5).setVisibility(0);
                  if (!bs.isNullOrNil((String)localObject3))
                  {
                    ((TextView)localObject5).setTextColor(getContext().getResources().getColor(2131099769));
                    ((TextView)localObject5).setClickable(true);
                    if ((localp.field_snsId == 0L) && (!bs.isNullOrNil((String)localObject1)))
                    {
                      ((TextView)localObject5).setText((String)localObject1 + "·" + (String)localObject3);
                      break label2531;
                    }
                    ((TextView)localObject5).setText((CharSequence)localObject3);
                    break label2531;
                  }
                  ((TextView)localObject5).setText((CharSequence)localObject1);
                  ((TextView)localObject5).setClickable(false);
                  ((TextView)localObject5).setTextColor(getContext().getResources().getColor(2131100212));
                  break label2531;
                  label9592:
                  ((TextView)localObject5).setVisibility(8);
                  break label2726;
                  if (((com.tencent.mm.plugin.sns.storage.a)localObject7).yeI != com.tencent.mm.plugin.sns.storage.a.yev) {
                    break label2726;
                  }
                  if (!bs.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject7).yeJ))
                  {
                    localObject1 = "";
                    localObject9 = ((com.tencent.mm.plugin.sns.storage.a)localObject7).yeL.iterator();
                    if (((Iterator)localObject9).hasNext())
                    {
                      localObject10 = (String)((Iterator)localObject9).next();
                      localObject3 = this.yJv.aNs((String)localObject10);
                      if (localObject3 != null)
                      {
                        localObject3 = ((com.tencent.mm.n.b)localObject3).aaS();
                        if (!bs.isNullOrNil((String)localObject3)) {
                          localObject3 = (String)localObject1 + (String)localObject3;
                        }
                      }
                      for (;;)
                      {
                        localObject1 = localObject3;
                        if (((com.tencent.mm.plugin.sns.storage.a)localObject7).yeL.getLast() == localObject10) {
                          break;
                        }
                        localObject1 = (String)localObject3 + ",";
                        break;
                        localObject3 = (String)localObject1 + (String)localObject10;
                        continue;
                        localObject3 = (String)localObject1 + (String)localObject10;
                      }
                    }
                    localObject3 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject7).yeJ, new Object[] { localObject1 });
                    ((TextView)localObject5).getTextSize();
                    localObject9 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject3, 1));
                    ((com.tencent.mm.pluginsdk.ui.span.l)localObject9).b(null, (CharSequence)localObject3);
                    localObject3 = ((TextView)localObject5).getPaint();
                    if (com.tencent.mm.cc.a.ax(this, (int)Layout.getDesiredWidth((CharSequence)localObject9, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject9).length(), (TextPaint)localObject3)) > this.yJH)
                    {
                      if (((String)localObject1).length() <= 1) {
                        break label2726;
                      }
                      localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
                      localObject9 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject7).yeJ, new Object[] { (String)localObject1 + "..." });
                      ((TextView)localObject5).getTextSize();
                      localObject10 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject9, 1));
                      ((com.tencent.mm.pluginsdk.ui.span.l)localObject10).b(null, (CharSequence)localObject9);
                      i = com.tencent.mm.cc.a.ax(this, (int)Layout.getDesiredWidth((CharSequence)localObject10, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject10).length(), (TextPaint)localObject3));
                      ((TextView)localObject5).setText((CharSequence)localObject10, TextView.BufferType.SPANNABLE);
                      ((TextView)localObject5).setVisibility(0);
                      if (i > this.yJH) {
                        break label2725;
                      }
                      break label2726;
                    }
                    ((TextView)localObject5).setText((CharSequence)localObject9, TextView.BufferType.SPANNABLE);
                    ((TextView)localObject5).setVisibility(0);
                    break label2726;
                  }
                  ((TextView)localObject5).setVisibility(8);
                  break label2726;
                  ((TextView)localObject8).setVisibility(8);
                  break label2852;
                  i = 8;
                  break label2883;
                  if (((TimeLineObject)localObject6).FQo.Ety != 30) {
                    break label2973;
                  }
                  localObject1 = ((TimeLineObject)localObject6).FQu.username;
                  localObject1 = ((com.tencent.mm.plugin.appbrand.service.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.m.class)).Ka((String)localObject1);
                  if ((localObject1 != null) && (!bs.isNullOrNil(((WxaAttributes)localObject1).field_nickname))) {}
                  for (localObject3 = ((WxaAttributes)localObject1).field_nickname;; localObject3 = getString(2131755945))
                  {
                    localObject1 = localObject3;
                    if (((TimeLineObject)localObject6).FQu.subType != 1) {
                      break;
                    }
                    this.yKk.findViewById(2131305185).setVisibility(0);
                    localObject1 = localObject3;
                    break;
                  }
                  ((TextView)localObject4).setVisibility(8);
                  break label3114;
                  ((TextView)localObject1).setVisibility(8);
                  break label3200;
                  if (((SnsObject)localObject5).WithUserList.size() <= 0) {
                    ((TextView)localObject4).setVisibility(8);
                  }
                  for (;;)
                  {
                    if ((localObject5 == null) || (this.fnC == null) || (!this.fnC.equals(((SnsObject)localObject5).Username)) || (((((SnsObject)localObject5).ExtFlag != 3) || (((SnsObject)localObject5).BlackList == null)) && ((((SnsObject)localObject5).ExtFlag != 5) || (((SnsObject)localObject5).GroupUser == null)))) {
                      break label10691;
                    }
                    this.yJe.findViewById(2131296570).setVisibility(0);
                    this.yJe.findViewById(2131296570).setTag(Integer.valueOf(localp.yvp));
                    this.yJe.findViewById(2131296570).setOnClickListener(new SnsCommentDetailUI.32(this));
                    break;
                    if (this.fnC.equals(((SnsObject)localObject5).Username))
                    {
                      ((TextView)localObject4).setVisibility(0);
                      i = 0;
                      localObject6 = ((SnsObject)localObject5).WithUserList.iterator();
                      localObject1 = "";
                      if (((Iterator)localObject6).hasNext())
                      {
                        localObject7 = (daa)((Iterator)localObject6).next();
                        if (i == 0)
                        {
                          i = 1;
                          localObject1 = (String)localObject1 + "  ";
                          if (((daa)localObject7).Nickname == null) {
                            break label10509;
                          }
                          localObject3 = new StringBuilder().append((String)localObject1);
                          localObject1 = ((daa)localObject7).Nickname;
                        }
                        for (;;)
                        {
                          localObject1 = (String)localObject1;
                          break;
                          localObject1 = (String)localObject1 + ",  ";
                          break label10439;
                          localObject8 = this.yJv.aNt(((daa)localObject7).Username);
                          localObject3 = new StringBuilder().append((String)localObject1);
                          if (localObject8 == null) {
                            localObject1 = ((daa)localObject7).Username;
                          } else {
                            localObject1 = ((com.tencent.mm.n.b)localObject8).aaS();
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
                        localObject3 = (daa)((Iterator)localObject1).next();
                        if (!this.fnC.equals(((daa)localObject3).Username)) {
                          break label10226;
                        }
                        ((TextView)localObject4).setVisibility(0);
                        localObject1 = getString(2131764040);
                        ((TextView)localObject4).setVisibility(0);
                        ((TextView)localObject4).setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject1, ((TextView)localObject4).getTextSize()));
                      }
                    }
                  }
                  this.yJe.findViewById(2131296570).setVisibility(8);
                  break label3234;
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
  
  public int getLayoutId()
  {
    return 2131495537;
  }
  
  public final int getSource()
  {
    if (this.yJR == 16) {
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
        AppMethodBeat.i(200490);
        if (SnsCommentDetailUI.c(SnsCommentDetailUI.this) != null) {
          SnsCommentDetailUI.c(SnsCommentDetailUI.this).rm(false);
        }
        SnsCommentDetailUI.this.finish();
        AppMethodBeat.o(200490);
        return true;
      }
    });
    this.fnC = u.axw();
    if (af.dHA()) {
      finish();
    }
    final com.tencent.mm.plugin.sns.storage.p localp = rl(true);
    if (localp == null)
    {
      ac.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.dnn);
      finish();
      AppMethodBeat.o(98599);
      return;
    }
    ac.i("MicroMsg.SnsCommentDetailUI", "snsId: " + this.dnn + "localId " + this.yJu + "  username:" + localp.field_userName);
    Object localObject1 = (TextView)findViewById(2131298750);
    label297:
    int i;
    if (this.yJO)
    {
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(this.yJP);
      if ((x.avq(this.dnn)) || (!localp.dMw())) {
        break label637;
      }
      localObject1 = localp.dMn();
      findViewById(2131305039).setVisibility(0);
      localObject2 = (TextView)findViewById(2131303362);
      switch (((bua)localObject1).FjN)
      {
      default: 
        if (!bs.isNullOrNil(((bua)localObject1).FjU))
        {
          ((TextView)localObject2).setText(((bua)localObject1).FjU);
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
            AppMethodBeat.i(200481);
            if (localp.Pe(32))
            {
              AppMethodBeat.o(200481);
              return;
            }
            com.tencent.mm.plugin.sns.model.aj.Or(localp.yvp);
            com.tencent.mm.plugin.sns.model.aj.Op(localp.yvp);
            af.dHN().dGr();
            paramAnonymousView = new Intent();
            SnsCommentDetailUI.this.setResult(-1, paramAnonymousView);
            if (SnsCommentDetailUI.w(SnsCommentDetailUI.this)) {
              paramAnonymousView.putExtra("sns_gallery_force_finish", true);
            }
            SnsCommentDetailUI.this.finish();
            SnsCommentDetailUI.this.finish();
            AppMethodBeat.o(200481);
          }
        });
      }
      this.yJi = ((ListView)findViewById(2131296556));
      this.yJi.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200482);
          SnsCommentDetailUI.a(SnsCommentDetailUI.this, SnsCommentDetailUI.a(SnsCommentDetailUI.this).getBottom());
          ac.d("MicroMsg.SnsCommentDetailUI", "listOriginalBottom: " + SnsCommentDetailUI.d(SnsCommentDetailUI.this));
          AppMethodBeat.o(200482);
        }
      });
      this.yJi.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(200483);
          if (paramAnonymousInt2 > 0) {
            if ((paramAnonymousInt1 == 0) && (!SnsCommentDetailUI.x(SnsCommentDetailUI.this)))
            {
              SnsCommentDetailUI.a(SnsCommentDetailUI.this, true);
              if (SnsCommentDetailUI.y(SnsCommentDetailUI.this) != null)
              {
                SnsCommentDetailUI.y(SnsCommentDetailUI.this).refreshView();
                AppMethodBeat.o(200483);
                return;
              }
              if (SnsCommentDetailUI.z(SnsCommentDetailUI.this) != null)
              {
                SnsCommentDetailUI.this.dPt();
                AppMethodBeat.o(200483);
              }
            }
            else if (paramAnonymousInt1 > 0)
            {
              SnsCommentDetailUI.a(SnsCommentDetailUI.this, false);
            }
          }
          AppMethodBeat.o(200483);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(200484);
          if (paramAnonymousInt == 1)
          {
            SnsCommentDetailUI.this.hideVKB();
            SnsCommentDetailUI.A(SnsCommentDetailUI.this);
          }
          if ((paramAnonymousInt == 0) && (SnsCommentDetailUI.f(SnsCommentDetailUI.this) != null)) {
            SnsCommentDetailUI.f(SnsCommentDetailUI.this).qG(true);
          }
          AppMethodBeat.o(200484);
        }
      });
      this.yJe = com.tencent.mm.ui.z.jD(getContext()).inflate(2131495538, null);
      this.yJk = this.yJe.findViewById(2131300970);
      this.yJe.setOnClickListener(this.yKg);
      this.yJi.addHeaderView(this.yJe);
      boolean bool = dPt();
      if (bool) {
        break label654;
      }
      ac.i("MicroMsg.SnsCommentDetailUI", "error isOk setheader ".concat(String.valueOf(bool)));
      finish();
      AppMethodBeat.o(98599);
      return;
      ((TextView)localObject1).setVisibility(8);
      break;
      if (!bs.isNullOrNil(((bua)localObject1).FjU)) {
        ((TextView)localObject2).setText(((bua)localObject1).FjU);
      }
      for (;;)
      {
        findViewById(2131305040).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(2131763943);
      }
      if (!bs.isNullOrNil(((bua)localObject1).FjU)) {
        ((TextView)localObject2).setText(((bua)localObject1).FjU);
      }
      for (;;)
      {
        findViewById(2131305040).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(2131763945);
      }
      if (!bs.isNullOrNil(((bua)localObject1).FjU)) {
        ((TextView)localObject2).setText(((bua)localObject1).FjU);
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
    localObject1 = rl(false);
    if (localObject1 != null) {
      this.oeH = be.c((com.tencent.mm.plugin.sns.storage.p)localObject1, false);
    }
    if ((this.oeH == 10) && (u.axw().equals(localp.field_userName)))
    {
      this.yJh = new SnsDetailLuckyHeader(this);
      localObject1 = new AbsListView.LayoutParams(-1, -2);
      this.yJh.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.yJh.setOnClickListener(this.yKg);
    }
    this.yJg = new LinearLayout(getContext());
    localObject1 = new AbsListView.LayoutParams(-1, -2);
    this.yJg.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.yJg.setOnClickListener(this.yKg);
    BackwardSupportUtil.b.g(this, 2.0F);
    localObject1 = new AbsListView.LayoutParams(-1, 1);
    Object localObject2 = new LinearLayout(getContext());
    ((LinearLayout)localObject2).setBackgroundResource(2131234115);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.xPo = ((LinearLayout)localObject2);
    b(localp, true);
    if (this.yJh != null)
    {
      this.yJL = true;
      this.yJi.addHeaderView(this.yJh);
    }
    localObject2 = com.tencent.mm.plugin.sns.model.aj.s(localp);
    label1010:
    daa localdaa;
    label1173:
    long l;
    if (localObject2 == null)
    {
      this.yJg.setVisibility(8);
      this.yJl = new b(new LinkedList(), new LinkedList(), this, localp.dMu());
      this.yJi.addHeaderView(this.yJg);
      this.yJi.setAdapter(this.yJl);
      this.yxU = ((SnsCommentFooter)findViewById(2131298521));
      if ((localp == null) || (localp.dLV() == null) || (localp.dLV().FQo == null) || ((localp.dLV().FQo.EtA & 0x80) != 0)) {
        break label1699;
      }
      this.yxU.setFeedEmojiCommentEnable(true);
      this.yxU.setTag(localp);
      this.yxU.setOnEditTouchListener(new SnsCommentFooter.a()
      {
        public final void dPx()
        {
          AppMethodBeat.i(200485);
          if (!com.tencent.mm.plugin.sns.lucky.a.m.ato(localp.dMu()))
          {
            if ((SnsCommentDetailUI.B(SnsCommentDetailUI.this) != null) && (SnsCommentDetailUI.B(SnsCommentDetailUI.this).isShowing()))
            {
              AppMethodBeat.o(200485);
              return;
            }
            SnsCommentDetailUI.a(SnsCommentDetailUI.this, com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.yKm.Pr(0)));
            AppMethodBeat.o(200485);
            return;
          }
          if ((SnsCommentDetailUI.this.keyboardState() == 1) || (SnsCommentDetailUI.c(SnsCommentDetailUI.this).dPz()))
          {
            AppMethodBeat.o(200485);
            return;
          }
          SnsCommentDetailUI.C(SnsCommentDetailUI.this);
          AppMethodBeat.o(200485);
        }
      });
      this.yxU.setOnSmileyShowListener(new SnsCommentFooter.c()
      {
        public final void onShow()
        {
          AppMethodBeat.i(200486);
          if (SnsCommentDetailUI.c(SnsCommentDetailUI.this).yLf)
          {
            AppMethodBeat.o(200486);
            return;
          }
          SnsCommentDetailUI.C(SnsCommentDetailUI.this);
          AppMethodBeat.o(200486);
        }
      });
      localObject1 = rl(true);
      if ((localObject1 != null) && (!((com.tencent.mm.plugin.sns.storage.p)localObject1).dMt())) {
        this.yxU.setVisibility(8);
      }
      this.yxU.setAfterEditAction(this.yKf);
      this.yxU.dPA();
      this.yxU.setOnCommentSendImp(new SnsCommentFooter.b()
      {
        public final void jH(String paramAnonymousString1, String paramAnonymousString2)
        {
          int j = 8;
          AppMethodBeat.i(200487);
          if (!com.tencent.mm.plugin.sns.lucky.a.m.ato(localp.dMu()))
          {
            if (SnsCommentDetailUI.this.yKm.Pr(0) != null) {
              com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.yKm.Pr(0));
            }
            AppMethodBeat.o(200487);
            return;
          }
          if (localp.Pe(32)) {}
          for (int i = SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentFlag();; i = 0)
          {
            if (com.tencent.mm.plugin.sns.ui.widget.e.hJ(i, 8))
            {
              paramAnonymousString1 = paramAnonymousString1.substring(SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentAtPrefix().length());
              ac.i("MicroMsg.SnsCommentDetailUI", "send atFriend ad detail comment");
              am.a.a(localp, 16, paramAnonymousString1, SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentInfo(), i, SnsCommentDetailUI.this.getSource(), paramAnonymousString2);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setText("");
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).rm(false);
              ac.i("MicroMsg.SnsCommentDetailUI", "comment send imp!");
              com.tencent.mm.plugin.sns.j.f.ydE.dJw().dTi = 3L;
              SnsCommentDetailUI.A(SnsCommentDetailUI.this);
              AppMethodBeat.o(200487);
              return;
            }
            ac.i("MicroMsg.SnsCommentDetailUI", "send detail comment");
            com.tencent.mm.plugin.sns.storage.p localp = localp;
            if (localp.Pe(32)) {}
            for (;;)
            {
              am.a.a(localp, j, paramAnonymousString1, SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentInfo(), i, SnsCommentDetailUI.this.getSource(), paramAnonymousString2);
              break;
              j = 2;
            }
          }
        }
      });
      this.yJA = getIntent().getBooleanExtra("INTENT_FROMSUI", false);
      if (this.yJA)
      {
        this.yJB = getIntent().getLongExtra("INTENT_FROMSUI_COMMENTID", 0L);
        if ((this.yJB != 0L) && (this.yJl.commentList != null))
        {
          i = 0;
          if (i < this.yJl.commentList.size())
          {
            localdaa = (daa)this.yJl.commentList.get(i);
            if (localdaa.FIZ == 0) {
              break label1710;
            }
            l = localdaa.FIZ;
            label1219:
            if (l != this.yJB) {
              break label1748;
            }
            this.yJi.setSelection(i);
            localObject1 = this.yJv.aNt(localdaa.Username);
            if (localObject1 == null) {
              break label1720;
            }
            localObject1 = ((com.tencent.mm.n.b)localObject1).aaS();
            label1265:
            this.yxU.yKW = 0;
            this.yxU.dPB();
            this.yxU.setCommentHint(getString(2131763952) + (String)localObject1);
            this.yxU.setCommentInfo(localdaa);
            if (((SnsObject)localObject2).LikeUserList.size() <= 0) {
              break label1787;
            }
            int j = i + 1;
            i = j;
            if (j > this.yJl.getCount()) {
              i = this.yJl.getCount() - 1;
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
      this.yKf.SW = i;
      if (this.yJA) {
        new ao().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200488);
            SnsCommentDetailUI.this.hideVKB();
            SnsCommentDetailUI.m(SnsCommentDetailUI.this).it = SnsCommentDetailUI.D(SnsCommentDetailUI.this);
            SnsCommentDetailUI.m(SnsCommentDetailUI.this).run();
            AppMethodBeat.o(200488);
          }
        }, 100L);
      }
      this.yJK = ((SnsTranslateResultView)this.yJe.findViewById(2131305091));
      this.yJK.setResultTextSize(((TextView)this.yJe.findViewById(2131299008)).getTextSize());
      this.yJK.getResultTextView().setBackgroundResource(2131234100);
      localObject1 = new ba(this.dnn, localp.dMu(), false, true, 2);
      this.yJK.getResultTextView().setTag(localObject1);
      this.nym.c(this.yJK.getResultTextView(), this.xLF.zgs, this.xLF.zgp);
      if (aq.eD(this.dnn, 4))
      {
        localObject1 = aq.atX(this.dnn);
        if ((localObject1 != null) && (((aq.b)localObject1).hqq))
        {
          this.yJK.setVisibility(0);
          this.yJK.a(null, 1, ((aq.b)localObject1).result, ((aq.b)localObject1).hym, false);
          AppMethodBeat.o(98599);
          return;
          this.yJq = ((SnsObject)localObject2).LikeUserList;
          i(((SnsObject)localObject2).LikeUserList, ((SnsObject)localObject2).CommentUserList.isEmpty());
          if (this.yJh != null) {
            this.yJh.a(localp, this.xLF);
          }
          this.yJl = new b(((SnsObject)localObject2).CommentUserList, ((SnsObject)localObject2).LikeUserList, this, localp.dMu());
          if (!this.yJS) {
            break;
          }
          com.tencent.mm.plugin.sns.j.f.ydE.dJw().dTg = ((SnsObject)localObject2).CommentUserList.size();
          com.tencent.mm.plugin.sns.j.f.ydE.dJw().dTh = ((SnsObject)localObject2).LikeUserList.size();
          break;
          this.yxU.setFeedEmojiCommentEnable(false);
          break label1010;
          l = localdaa.FJb;
          break label1219;
          if (localdaa.Nickname != null)
          {
            localObject1 = localdaa.Nickname;
            break label1265;
          }
          localObject1 = localdaa.Username;
          break label1265;
          i += 1;
          break label1173;
        }
        this.yJK.setVisibility(8);
        AppMethodBeat.o(98599);
        return;
      }
      this.yJK.setVisibility(8);
      AppMethodBeat.o(98599);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98610);
    ac.i("MicroMsg.SnsCommentDetailUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt1 == 15)
    {
      if ((this.xLF != null) && (this.xLF.zgp != null)) {
        this.xLF.zgp.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      AppMethodBeat.o(98610);
      return;
    }
    if (paramInt1 == 16)
    {
      ac.i("MicroMsg.SnsCommentDetailUI", "REQUEST_CODE_FOR_FULLSCREEN");
      paramIntent = new ht();
      paramIntent.diN.scene = 1;
      com.tencent.mm.sdk.b.a.GpY.l(paramIntent);
      AppMethodBeat.o(98610);
      return;
    }
    if (paramInt1 == 2333)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        if (!bs.isNullOrNil(paramIntent))
        {
          paramIntent = paramIntent.split(",");
          if (paramIntent.length > 0)
          {
            this.yxU.iMV.showVKB();
            String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk(paramIntent[0]);
            if (!bs.isNullOrNil(str))
            {
              this.yxU.dPB();
              this.yxU.setText("@" + str + " ");
              this.yxU.setCommentAtPrefix("@" + str + " ");
              this.yxU.setCommentInfo(new daa());
              this.yxU.getCommentInfo().Username = paramIntent[0];
              this.yxU.setCommentFlag(8);
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
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.aeD(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98609);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = com.tencent.mm.plugin.sns.storage.h.auS(this.dnn);
    Object localObject = com.tencent.mm.plugin.sns.model.aj.s(paramConfiguration);
    i(((SnsObject)localObject).LikeUserList, ((SnsObject)localObject).CommentUserList.isEmpty());
    if (this.yJh != null) {
      this.yJh.a(paramConfiguration, this.xLF);
    }
    paramConfiguration = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    localObject = new Point();
    ((Point)localObject).x = paramConfiguration.widthPixels;
    ((Point)localObject).y = paramConfiguration.heightPixels;
    af.h((Point)localObject);
    if (this.yKm != null)
    {
      this.yJE = af.dIc();
      this.yKm.setImageViewWidth(this.yJE);
    }
    AppMethodBeat.o(98609);
  }
  
  /* Error */
  public void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 2969
    //   3: invokestatic 241	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 2974	com/tencent/mm/pluginsdk/g:o	(Lcom/tencent/mm/ui/MMActivity;)V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 2976	com/tencent/mm/ui/MMActivity:onCreate	(Landroid/os/Bundle;)V
    //   15: aload_0
    //   16: ldc_w 2978
    //   19: invokestatic 2982	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   22: checkcast 2978	com/tencent/mm/plugin/story/api/e
    //   25: invokeinterface 2986 1 0
    //   30: getstatic 2992	com/tencent/mm/plugin/story/api/f$a:zpZ	Lcom/tencent/mm/plugin/story/api/f$a;
    //   33: invokeinterface 2997 2 0
    //   38: putfield 327	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJU	Z
    //   41: aload_0
    //   42: ldc_w 2978
    //   45: invokestatic 2982	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   48: checkcast 2978	com/tencent/mm/plugin/story/api/e
    //   51: invokeinterface 2986 1 0
    //   56: getstatic 3000	com/tencent/mm/plugin/story/api/f$a:zqa	Lcom/tencent/mm/plugin/story/api/f$a;
    //   59: invokeinterface 2997 2 0
    //   64: putfield 329	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJV	Z
    //   67: aload_0
    //   68: iconst_1
    //   69: invokestatic 3005	com/tencent/mm/ui/b:c	(Landroid/app/Activity;Z)V
    //   72: invokestatic 3009	com/tencent/mm/plugin/sns/model/af:dHH	()Lcom/tencent/mm/plugin/sns/model/am$a;
    //   75: iconst_5
    //   76: ldc_w 3011
    //   79: aload_0
    //   80: invokevirtual 3014	com/tencent/mm/plugin/sns/model/am$a:a	(ILjava/lang/String;Lcom/tencent/mm/plugin/sns/b/i$a;)V
    //   83: aload_0
    //   84: aload_0
    //   85: invokevirtual 3017	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getApplicationContext	()Landroid/content/Context;
    //   88: ldc_w 3019
    //   91: invokevirtual 3020	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   94: checkcast 3022	android/text/ClipboardManager
    //   97: putfield 1218	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:qRg	Landroid/text/ClipboardManager;
    //   100: aload_0
    //   101: aload_0
    //   102: bipush 14
    //   104: invokestatic 3025	com/tencent/mm/ui/ao:fromDPToPix	(Landroid/content/Context;I)I
    //   107: putfield 325	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJT	I
    //   110: aload_0
    //   111: invokestatic 3031	com/tencent/mm/ui/aj:cl	(Landroid/content/Context;)Landroid/graphics/Point;
    //   114: astore_1
    //   115: aload_0
    //   116: aload_1
    //   117: getfield 2956	android/graphics/Point:x	I
    //   120: putfield 3033	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenWidth	I
    //   123: aload_0
    //   124: aload_1
    //   125: getfield 2961	android/graphics/Point:y	I
    //   128: putfield 3035	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenHeight	I
    //   131: aload_0
    //   132: invokestatic 3041	java/lang/System:currentTimeMillis	()J
    //   135: putfield 273	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJc	J
    //   138: aload_0
    //   139: new 1627	com/tencent/mm/ui/widget/b/a
    //   142: dup
    //   143: aload_0
    //   144: invokespecial 3042	com/tencent/mm/ui/widget/b/a:<init>	(Landroid/content/Context;)V
    //   147: putfield 665	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:nym	Lcom/tencent/mm/ui/widget/b/a;
    //   150: aload_0
    //   151: aload_0
    //   152: invokevirtual 2318	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   155: ldc_w 3044
    //   158: iconst_0
    //   159: invokevirtual 3048	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   162: putfield 2656	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJR	I
    //   165: aload_0
    //   166: aload_0
    //   167: invokevirtual 2318	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   170: ldc_w 3050
    //   173: iconst_0
    //   174: invokevirtual 2326	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   177: putfield 323	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJS	Z
    //   180: aload_0
    //   181: getfield 323	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJS	Z
    //   184: ifeq +10 -> 194
    //   187: getstatic 589	com/tencent/mm/plugin/sns/j/f:ydE	Lcom/tencent/mm/plugin/sns/j/f;
    //   190: invokevirtual 3053	com/tencent/mm/plugin/sns/j/f:dJy	()Lcom/tencent/mm/g/b/a/dy;
    //   193: pop
    //   194: aload_0
    //   195: aload_0
    //   196: invokevirtual 2318	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   199: ldc_w 3055
    //   202: invokevirtual 2862	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   205: ldc_w 297
    //   208: invokestatic 1513	com/tencent/mm/sdk/platformtools/bs:bG	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   211: putfield 511	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dnn	Ljava/lang/String;
    //   214: aload_0
    //   215: getfield 511	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dnn	Ljava/lang/String;
    //   218: invokestatic 849	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   221: ifeq +24 -> 245
    //   224: aload_0
    //   225: ldc_w 3057
    //   228: aload_0
    //   229: invokevirtual 2318	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   232: ldc_w 3055
    //   235: lconst_0
    //   236: invokevirtual 2777	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   239: invokestatic 3061	com/tencent/mm/plugin/sns/storage/x:bj	(Ljava/lang/String;J)Ljava/lang/String;
    //   242: putfield 511	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dnn	Ljava/lang/String;
    //   245: aload_0
    //   246: aload_0
    //   247: invokevirtual 2318	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   250: ldc_w 3063
    //   253: invokevirtual 2862	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   256: ldc_w 297
    //   259: invokestatic 1513	com/tencent/mm/sdk/platformtools/bs:bG	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   262: putfield 799	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJu	Ljava/lang/String;
    //   265: aload_0
    //   266: getfield 799	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJu	Ljava/lang/String;
    //   269: invokestatic 849	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   272: ifeq +32 -> 304
    //   275: aload_0
    //   276: invokevirtual 2318	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   279: ldc_w 3063
    //   282: iconst_m1
    //   283: invokevirtual 3048	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   286: istore_2
    //   287: iload_2
    //   288: iconst_m1
    //   289: if_icmpeq +15 -> 304
    //   292: aload_0
    //   293: ldc_w 3057
    //   296: iload_2
    //   297: i2l
    //   298: invokestatic 3061	com/tencent/mm/plugin/sns/storage/x:bj	(Ljava/lang/String;J)Ljava/lang/String;
    //   301: putfield 799	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJu	Ljava/lang/String;
    //   304: aload_0
    //   305: new 68	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$4
    //   308: dup
    //   309: aload_0
    //   310: aload_0
    //   311: invokevirtual 575	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   314: aload_0
    //   315: aload_0
    //   316: getfield 340	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJY	Lcom/tencent/mm/plugin/sns/model/ag;
    //   319: invokespecial 3066	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$4:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;ILandroid/app/Activity;Lcom/tencent/mm/plugin/sns/model/ae;)V
    //   322: putfield 544	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xLF	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   325: aload_0
    //   326: ldc_w 1644
    //   329: invokevirtual 943	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:findViewById	(I)Landroid/view/View;
    //   332: checkcast 2195	android/widget/FrameLayout
    //   335: astore_1
    //   336: aload_0
    //   337: new 3068	com/tencent/mm/plugin/sns/h/b
    //   340: dup
    //   341: aload_0
    //   342: aload_0
    //   343: getfield 544	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xLF	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   346: aload_1
    //   347: invokespecial 3071	com/tencent/mm/plugin/sns/h/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/b;Landroid/widget/FrameLayout;)V
    //   350: putfield 3073	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yyd	Lcom/tencent/mm/plugin/sns/h/b;
    //   353: aload_0
    //   354: new 3075	com/tencent/mm/plugin/sns/ui/b
    //   357: dup
    //   358: aload_0
    //   359: aload_0
    //   360: getfield 544	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xLF	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   363: aload_1
    //   364: aload_0
    //   365: getfield 3073	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yyd	Lcom/tencent/mm/plugin/sns/h/b;
    //   368: invokespecial 3078	com/tencent/mm/plugin/sns/ui/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/b;Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/sns/h/b;)V
    //   371: putfield 1226	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yyc	Lcom/tencent/mm/plugin/sns/ui/b;
    //   374: aload_0
    //   375: new 3080	com/tencent/mm/plugin/sns/ui/aj
    //   378: dup
    //   379: aload_0
    //   380: aload_0
    //   381: getfield 544	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xLF	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   384: aload_1
    //   385: invokespecial 3081	com/tencent/mm/plugin/sns/ui/aj:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/b;Landroid/widget/FrameLayout;)V
    //   388: putfield 1230	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yye	Lcom/tencent/mm/plugin/sns/ui/aj;
    //   391: aload_0
    //   392: new 3083	com/tencent/mm/plugin/sns/ui/bo
    //   395: dup
    //   396: aload_0
    //   397: aload_0
    //   398: getfield 544	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xLF	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   401: aload_1
    //   402: invokespecial 3084	com/tencent/mm/plugin/sns/ui/bo:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/b;Landroid/widget/FrameLayout;)V
    //   405: putfield 1359	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yyf	Lcom/tencent/mm/plugin/sns/ui/bo;
    //   408: aload_0
    //   409: getfield 544	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xLF	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   412: invokevirtual 3087	com/tencent/mm/plugin/sns/ui/d/b:cVE	()V
    //   415: aload_0
    //   416: aload_0
    //   417: invokevirtual 2318	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   420: ldc_w 3089
    //   423: iconst_0
    //   424: invokevirtual 2326	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   427: putfield 317	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJO	Z
    //   430: aload_0
    //   431: aload_0
    //   432: invokevirtual 2318	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   435: ldc_w 3091
    //   438: invokevirtual 2862	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   441: putfield 319	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJP	Ljava/lang/String;
    //   444: aload_0
    //   445: new 1011	com/tencent/mm/plugin/sns/ui/bl
    //   448: dup
    //   449: aload_0
    //   450: new 76	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$5
    //   453: dup
    //   454: aload_0
    //   455: invokespecial 3092	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$5:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   458: aload_0
    //   459: invokevirtual 575	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   462: aload_0
    //   463: getfield 340	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJY	Lcom/tencent/mm/plugin/sns/model/ag;
    //   466: invokespecial 3095	com/tencent/mm/plugin/sns/ui/bl:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/bl$a;ILcom/tencent/mm/plugin/sns/model/ae;)V
    //   469: putfield 1209	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJC	Lcom/tencent/mm/plugin/sns/ui/bl;
    //   472: invokestatic 3041	java/lang/System:currentTimeMillis	()J
    //   475: lstore_3
    //   476: aload_0
    //   477: invokevirtual 2318	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   480: ldc_w 3097
    //   483: invokevirtual 3101	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   486: astore_1
    //   487: aload_1
    //   488: ifnull +184 -> 672
    //   491: new 457	com/tencent/mm/protocal/protobuf/TimeLineObject
    //   494: dup
    //   495: invokespecial 3102	com/tencent/mm/protocal/protobuf/TimeLineObject:<init>	()V
    //   498: astore 6
    //   500: aload 6
    //   502: aload_1
    //   503: invokevirtual 3106	com/tencent/mm/protocal/protobuf/TimeLineObject:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   506: pop
    //   507: invokestatic 3110	com/tencent/mm/plugin/sns/model/af:dHR	()Lcom/tencent/mm/plugin/sns/storage/q;
    //   510: new 3112	java/math/BigInteger
    //   513: dup
    //   514: aload 6
    //   516: getfield 2314	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   519: invokespecial 3113	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   522: invokevirtual 3116	java/math/BigInteger:longValue	()J
    //   525: invokevirtual 3122	com/tencent/mm/plugin/sns/storage/q:xK	(J)Lcom/tencent/mm/plugin/sns/storage/p;
    //   528: ifnonnull +759 -> 1287
    //   531: ldc_w 1072
    //   534: ldc_w 3124
    //   537: invokestatic 1313	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: new 447	com/tencent/mm/plugin/sns/storage/p
    //   543: dup
    //   544: invokespecial 3125	com/tencent/mm/plugin/sns/storage/p:<init>	()V
    //   547: astore_1
    //   548: aload_1
    //   549: new 3112	java/math/BigInteger
    //   552: dup
    //   553: aload 6
    //   555: getfield 2314	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   558: invokespecial 3113	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   561: invokevirtual 3116	java/math/BigInteger:longValue	()J
    //   564: putfield 1584	com/tencent/mm/plugin/sns/storage/p:field_snsId	J
    //   567: aload_1
    //   568: aload 6
    //   570: invokevirtual 3129	com/tencent/mm/protocal/protobuf/TimeLineObject:toByteArray	()[B
    //   573: putfield 3133	com/tencent/mm/plugin/sns/storage/p:field_content	[B
    //   576: aload_1
    //   577: aload 6
    //   579: getfield 2410	com/tencent/mm/protocal/protobuf/TimeLineObject:CreateTime	I
    //   582: putfield 3136	com/tencent/mm/plugin/sns/storage/p:field_createTime	I
    //   585: aload_1
    //   586: aload 6
    //   588: getfield 2039	com/tencent/mm/protocal/protobuf/TimeLineObject:ncR	Ljava/lang/String;
    //   591: putfield 817	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
    //   594: aload_1
    //   595: aload 6
    //   597: getfield 461	com/tencent/mm/protocal/protobuf/TimeLineObject:FQo	Lcom/tencent/mm/protocal/protobuf/zf;
    //   600: getfield 683	com/tencent/mm/protocal/protobuf/zf:Ety	I
    //   603: putfield 3139	com/tencent/mm/plugin/sns/storage/p:field_type	I
    //   606: aload_1
    //   607: invokevirtual 3142	com/tencent/mm/plugin/sns/storage/p:dMr	()V
    //   610: new 525	com/tencent/mm/protocal/protobuf/SnsObject
    //   613: dup
    //   614: invokespecial 3143	com/tencent/mm/protocal/protobuf/SnsObject:<init>	()V
    //   617: astore 6
    //   619: aload 6
    //   621: new 3145	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   624: dup
    //   625: invokespecial 3146	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   628: putfield 3150	com/tencent/mm/protocal/protobuf/SnsObject:ObjectDesc	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   631: aload_1
    //   632: aload 6
    //   634: invokevirtual 3151	com/tencent/mm/protocal/protobuf/SnsObject:toByteArray	()[B
    //   637: putfield 3154	com/tencent/mm/plugin/sns/storage/p:field_attrBuf	[B
    //   640: invokestatic 3110	com/tencent/mm/plugin/sns/model/af:dHR	()Lcom/tencent/mm/plugin/sns/storage/q;
    //   643: aload_1
    //   644: invokevirtual 3158	com/tencent/mm/plugin/sns/storage/q:insert	(Lcom/tencent/mm/sdk/e/c;)Z
    //   647: pop
    //   648: ldc_w 3160
    //   651: ldc_w 3162
    //   654: iconst_1
    //   655: anewarray 1076	java/lang/Object
    //   658: dup
    //   659: iconst_0
    //   660: invokestatic 3041	java/lang/System:currentTimeMillis	()J
    //   663: lload_3
    //   664: lsub
    //   665: invokestatic 1589	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   668: aastore
    //   669: invokestatic 1500	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   672: aload_0
    //   673: iconst_1
    //   674: invokespecial 445	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rl	(Z)Lcom/tencent/mm/plugin/sns/storage/p;
    //   677: astore_1
    //   678: ldc_w 1072
    //   681: new 804	java/lang/StringBuilder
    //   684: dup
    //   685: ldc_w 3164
    //   688: invokespecial 1367	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   691: aload_0
    //   692: getfield 511	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dnn	Ljava/lang/String;
    //   695: invokevirtual 810	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: ldc_w 3166
    //   701: invokevirtual 810	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload_0
    //   705: getfield 799	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJu	Ljava/lang/String;
    //   708: invokevirtual 810	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: invokevirtual 814	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokestatic 1313	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   717: aload_1
    //   718: ifnull +29 -> 747
    //   721: ldc_w 1072
    //   724: ldc_w 3168
    //   727: iconst_1
    //   728: anewarray 1076	java/lang/Object
    //   731: dup
    //   732: iconst_0
    //   733: aload_1
    //   734: getfield 817	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
    //   737: ldc_w 297
    //   740: invokestatic 1513	com/tencent/mm/sdk/platformtools/bs:bG	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   743: aastore
    //   744: invokestatic 1500	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   747: aload_0
    //   748: getfield 511	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dnn	Ljava/lang/String;
    //   751: invokestatic 562	com/tencent/mm/plugin/sns/storage/x:avq	(Ljava/lang/String;)Z
    //   754: ifeq +56 -> 810
    //   757: aload_0
    //   758: getfield 511	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dnn	Ljava/lang/String;
    //   761: invokestatic 3171	com/tencent/mm/plugin/sns/storage/x:asz	(Ljava/lang/String;)Z
    //   764: ifeq +567 -> 1331
    //   767: aload_1
    //   768: ifnull +531 -> 1299
    //   771: aload_1
    //   772: getfield 817	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
    //   775: invokestatic 3176	com/tencent/mm/model/w:wF	(Ljava/lang/String;)Z
    //   778: ifne +32 -> 810
    //   781: invokestatic 1467	com/tencent/mm/kernel/g:agS	()Lcom/tencent/mm/kernel/g;
    //   784: pop
    //   785: invokestatic 3180	com/tencent/mm/kernel/g:agQ	()Lcom/tencent/mm/kernel/b;
    //   788: getfield 3186	com/tencent/mm/kernel/b:ghe	Lcom/tencent/mm/ak/q;
    //   791: new 3188	com/tencent/mm/plugin/sns/model/p
    //   794: dup
    //   795: aload_0
    //   796: getfield 511	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dnn	Ljava/lang/String;
    //   799: invokestatic 3192	com/tencent/mm/plugin/sns/storage/x:asL	(Ljava/lang/String;)J
    //   802: invokespecial 3194	com/tencent/mm/plugin/sns/model/p:<init>	(J)V
    //   805: iconst_0
    //   806: invokevirtual 3199	com/tencent/mm/ak/q:a	(Lcom/tencent/mm/ak/n;I)Z
    //   809: pop
    //   810: invokestatic 1467	com/tencent/mm/kernel/g:agS	()Lcom/tencent/mm/kernel/g;
    //   813: pop
    //   814: invokestatic 3180	com/tencent/mm/kernel/g:agQ	()Lcom/tencent/mm/kernel/b;
    //   817: getfield 3186	com/tencent/mm/kernel/b:ghe	Lcom/tencent/mm/ak/q;
    //   820: sipush 210
    //   823: aload_0
    //   824: invokevirtual 3202	com/tencent/mm/ak/q:a	(ILcom/tencent/mm/ak/g;)V
    //   827: invokestatic 1467	com/tencent/mm/kernel/g:agS	()Lcom/tencent/mm/kernel/g;
    //   830: pop
    //   831: invokestatic 3180	com/tencent/mm/kernel/g:agQ	()Lcom/tencent/mm/kernel/b;
    //   834: getfield 3186	com/tencent/mm/kernel/b:ghe	Lcom/tencent/mm/ak/q;
    //   837: sipush 218
    //   840: aload_0
    //   841: invokevirtual 3202	com/tencent/mm/ak/q:a	(ILcom/tencent/mm/ak/g;)V
    //   844: invokestatic 1467	com/tencent/mm/kernel/g:agS	()Lcom/tencent/mm/kernel/g;
    //   847: pop
    //   848: invokestatic 3180	com/tencent/mm/kernel/g:agQ	()Lcom/tencent/mm/kernel/b;
    //   851: getfield 3186	com/tencent/mm/kernel/b:ghe	Lcom/tencent/mm/ak/q;
    //   854: sipush 213
    //   857: aload_0
    //   858: invokevirtual 3202	com/tencent/mm/ak/q:a	(ILcom/tencent/mm/ak/g;)V
    //   861: invokestatic 1467	com/tencent/mm/kernel/g:agS	()Lcom/tencent/mm/kernel/g;
    //   864: pop
    //   865: invokestatic 3180	com/tencent/mm/kernel/g:agQ	()Lcom/tencent/mm/kernel/b;
    //   868: getfield 3186	com/tencent/mm/kernel/b:ghe	Lcom/tencent/mm/ak/q;
    //   871: sipush 682
    //   874: aload_0
    //   875: invokevirtual 3202	com/tencent/mm/ak/q:a	(ILcom/tencent/mm/ak/g;)V
    //   878: invokestatic 1467	com/tencent/mm/kernel/g:agS	()Lcom/tencent/mm/kernel/g;
    //   881: pop
    //   882: invokestatic 3180	com/tencent/mm/kernel/g:agQ	()Lcom/tencent/mm/kernel/b;
    //   885: getfield 3186	com/tencent/mm/kernel/b:ghe	Lcom/tencent/mm/ak/q;
    //   888: sipush 214
    //   891: aload_0
    //   892: invokevirtual 3202	com/tencent/mm/ak/q:a	(ILcom/tencent/mm/ak/g;)V
    //   895: invokestatic 1467	com/tencent/mm/kernel/g:agS	()Lcom/tencent/mm/kernel/g;
    //   898: pop
    //   899: invokestatic 3180	com/tencent/mm/kernel/g:agQ	()Lcom/tencent/mm/kernel/b;
    //   902: getfield 3186	com/tencent/mm/kernel/b:ghe	Lcom/tencent/mm/ak/q;
    //   905: sipush 683
    //   908: aload_0
    //   909: invokevirtual 3202	com/tencent/mm/ak/q:a	(ILcom/tencent/mm/ak/g;)V
    //   912: aload_0
    //   913: invokestatic 3205	com/tencent/mm/plugin/sns/model/af:dHF	()Lcom/tencent/mm/storage/bj;
    //   916: putfield 2558	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJv	Lcom/tencent/mm/storage/bj;
    //   919: aload_0
    //   920: new 3207	com/tencent/mm/plugin/sns/ui/av
    //   923: dup
    //   924: aload_0
    //   925: invokespecial 3210	com/tencent/mm/plugin/sns/ui/av:<init>	(Landroid/app/Activity;)V
    //   928: putfield 1222	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yxW	Lcom/tencent/mm/plugin/sns/ui/av;
    //   931: aload_0
    //   932: new 688	com/tencent/mm/plugin/sns/ui/ay
    //   935: dup
    //   936: aload_0
    //   937: invokevirtual 768	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
    //   940: invokespecial 3211	com/tencent/mm/plugin/sns/ui/ay:<init>	(Landroid/content/Context;)V
    //   943: putfield 551	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJt	Lcom/tencent/mm/plugin/sns/ui/ay;
    //   946: aload_0
    //   947: new 3213	com/tencent/mm/plugin/sns/ui/j
    //   950: dup
    //   951: aload_0
    //   952: aload_0
    //   953: invokevirtual 575	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   956: aload_0
    //   957: getfield 340	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJY	Lcom/tencent/mm/plugin/sns/model/ag;
    //   960: invokespecial 3216	com/tencent/mm/plugin/sns/ui/j:<init>	(Landroid/app/Activity;ILcom/tencent/mm/plugin/sns/model/ae;)V
    //   963: putfield 641	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJy	Lcom/tencent/mm/plugin/sns/ui/j;
    //   966: aload_0
    //   967: new 3218	com/tencent/mm/plugin/sns/ui/l
    //   970: dup
    //   971: aload_0
    //   972: invokespecial 3221	com/tencent/mm/plugin/sns/ui/l:<init>	(Lcom/tencent/mm/plugin/sns/ui/z;)V
    //   975: putfield 3223	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJz	Lcom/tencent/mm/plugin/sns/ui/l;
    //   978: aload_1
    //   979: ifnull +76 -> 1055
    //   982: aload_0
    //   983: aload_1
    //   984: iconst_0
    //   985: invokestatic 1380	com/tencent/mm/plugin/sns/ui/be:c	(Lcom/tencent/mm/plugin/sns/storage/p;Z)I
    //   988: putfield 547	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oeH	I
    //   991: getstatic 589	com/tencent/mm/plugin/sns/j/f:ydE	Lcom/tencent/mm/plugin/sns/j/f;
    //   994: invokestatic 3041	java/lang/System:currentTimeMillis	()J
    //   997: putfield 3226	com/tencent/mm/plugin/sns/j/f:yeb	J
    //   1000: getstatic 589	com/tencent/mm/plugin/sns/j/f:ydE	Lcom/tencent/mm/plugin/sns/j/f;
    //   1003: astore 6
    //   1005: aload_1
    //   1006: ifnull +40 -> 1046
    //   1009: aload_1
    //   1010: getfield 1584	com/tencent/mm/plugin/sns/storage/p:field_snsId	J
    //   1013: invokestatic 3230	com/tencent/mm/plugin/sns/data/q:wX	(J)Ljava/lang/String;
    //   1016: astore 7
    //   1018: aload 6
    //   1020: getfield 3233	com/tencent/mm/plugin/sns/j/f:ydV	Ljava/util/List;
    //   1023: aload 7
    //   1025: invokeinterface 3236 2 0
    //   1030: ifne +16 -> 1046
    //   1033: aload 6
    //   1035: getfield 3233	com/tencent/mm/plugin/sns/j/f:ydV	Ljava/util/List;
    //   1038: aload 7
    //   1040: invokeinterface 2013 2 0
    //   1045: pop
    //   1046: getstatic 589	com/tencent/mm/plugin/sns/j/f:ydE	Lcom/tencent/mm/plugin/sns/j/f;
    //   1049: invokestatic 3041	java/lang/System:currentTimeMillis	()J
    //   1052: putfield 3239	com/tencent/mm/plugin/sns/j/f:yei	J
    //   1055: aload_1
    //   1056: ifnull +80 -> 1136
    //   1059: aload_1
    //   1060: bipush 32
    //   1062: invokevirtual 451	com/tencent/mm/plugin/sns/storage/p:Pe	(I)Z
    //   1065: ifeq +71 -> 1136
    //   1068: aload_0
    //   1069: getfield 2656	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJR	I
    //   1072: bipush 16
    //   1074: if_icmpne +298 -> 1372
    //   1077: aload_0
    //   1078: new 2240	com/tencent/mm/plugin/sns/ad/d/i
    //   1081: dup
    //   1082: iconst_2
    //   1083: invokespecial 3241	com/tencent/mm/plugin/sns/ad/d/i:<init>	(I)V
    //   1086: putfield 1026	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJJ	Lcom/tencent/mm/plugin/sns/ad/d/i;
    //   1089: aload_0
    //   1090: getfield 1026	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJJ	Lcom/tencent/mm/plugin/sns/ad/d/i;
    //   1093: aload_0
    //   1094: getfield 3035	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenHeight	I
    //   1097: aload_0
    //   1098: invokevirtual 3245	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSupportActionBar	()Landroid/support/v7/app/ActionBar;
    //   1101: invokevirtual 3250	android/support/v7/app/ActionBar:getCustomView	()Landroid/view/View;
    //   1104: aload_0
    //   1105: invokevirtual 3253	com/tencent/mm/plugin/sns/ad/d/i:a	(ILandroid/view/View;Landroid/app/Activity;)V
    //   1108: aload_1
    //   1109: iconst_0
    //   1110: invokestatic 1380	com/tencent/mm/plugin/sns/ui/be:c	(Lcom/tencent/mm/plugin/sns/storage/p;Z)I
    //   1113: pop
    //   1114: aload_0
    //   1115: getfield 544	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:xLF	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   1118: aload_0
    //   1119: getfield 1026	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJJ	Lcom/tencent/mm/plugin/sns/ad/d/i;
    //   1122: invokevirtual 3256	com/tencent/mm/plugin/sns/ui/d/b:b	(Lcom/tencent/mm/plugin/sns/ad/d/i;)V
    //   1125: aload_0
    //   1126: getfield 1226	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yyc	Lcom/tencent/mm/plugin/sns/ui/b;
    //   1129: aload_0
    //   1130: getfield 1026	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJJ	Lcom/tencent/mm/plugin/sns/ad/d/i;
    //   1133: putfield 3259	com/tencent/mm/plugin/sns/ui/b:ywr	Lcom/tencent/mm/plugin/sns/ad/d/i;
    //   1136: aload_0
    //   1137: invokevirtual 3261	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:initView	()V
    //   1140: aload_1
    //   1141: ifnull +49 -> 1190
    //   1144: aload_1
    //   1145: bipush 32
    //   1147: invokevirtual 451	com/tencent/mm/plugin/sns/storage/p:Pe	(I)Z
    //   1150: ifeq +40 -> 1190
    //   1153: aload_1
    //   1154: invokestatic 523	com/tencent/mm/plugin/sns/model/aj:s	(Lcom/tencent/mm/plugin/sns/storage/p;)Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   1157: astore 6
    //   1159: aload_0
    //   1160: getfield 1026	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJJ	Lcom/tencent/mm/plugin/sns/ad/d/i;
    //   1163: iconst_0
    //   1164: aload_1
    //   1165: invokevirtual 861	com/tencent/mm/plugin/sns/storage/p:dMu	()Ljava/lang/String;
    //   1168: aload_1
    //   1169: invokevirtual 3264	com/tencent/mm/plugin/sns/storage/p:dMq	()Z
    //   1172: aload_0
    //   1173: getfield 1342	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJe	Landroid/view/View;
    //   1176: aload_1
    //   1177: getfield 1584	com/tencent/mm/plugin/sns/storage/p:field_snsId	J
    //   1180: aload 6
    //   1182: aload_0
    //   1183: getfield 547	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oeH	I
    //   1186: iconst_2
    //   1187: invokevirtual 3267	com/tencent/mm/plugin/sns/ad/d/i:a	(ILjava/lang/String;ZLandroid/view/View;JLcom/tencent/mm/protocal/protobuf/SnsObject;II)V
    //   1190: aload_0
    //   1191: getfield 1342	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJe	Landroid/view/View;
    //   1194: ifnull +79 -> 1273
    //   1197: aload_1
    //   1198: ifnull +75 -> 1273
    //   1201: aload_0
    //   1202: getfield 1342	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJe	Landroid/view/View;
    //   1205: ldc_w 2078
    //   1208: invokevirtual 1382	android/view/View:findViewById	(I)Landroid/view/View;
    //   1211: checkcast 3269	com/tencent/mm/plugin/sight/decode/a/a
    //   1214: astore 6
    //   1216: aload_1
    //   1217: invokevirtual 455	com/tencent/mm/plugin/sns/storage/p:dLV	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1220: getfield 461	com/tencent/mm/protocal/protobuf/TimeLineObject:FQo	Lcom/tencent/mm/protocal/protobuf/zf;
    //   1223: ifnull +339 -> 1562
    //   1226: aload_1
    //   1227: invokevirtual 455	com/tencent/mm/plugin/sns/storage/p:dLV	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1230: getfield 461	com/tencent/mm/protocal/protobuf/TimeLineObject:FQo	Lcom/tencent/mm/protocal/protobuf/zf;
    //   1233: getfield 683	com/tencent/mm/protocal/protobuf/zf:Ety	I
    //   1236: bipush 15
    //   1238: if_icmpne +324 -> 1562
    //   1241: aload 6
    //   1243: instanceof 2170
    //   1246: ifeq +316 -> 1562
    //   1249: aload 6
    //   1251: checkcast 2170	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView
    //   1254: getfield 3273	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView:xDG	Lcom/tencent/mm/plugin/sight/decode/a/b;
    //   1257: invokevirtual 3278	com/tencent/mm/plugin/sight/decode/a/b:dEz	()Z
    //   1260: istore 5
    //   1262: aload_1
    //   1263: iconst_1
    //   1264: iload 5
    //   1266: aload_0
    //   1267: invokevirtual 575	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   1270: invokestatic 3283	com/tencent/mm/plugin/sns/ad/d/m:a	(Lcom/tencent/mm/plugin/sns/storage/p;ZZI)V
    //   1273: aload_0
    //   1274: getfield 671	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJi	Landroid/widget/ListView;
    //   1277: ifnonnull +110 -> 1387
    //   1280: ldc_w 2969
    //   1283: invokestatic 268	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1286: return
    //   1287: ldc_w 1072
    //   1290: ldc_w 3285
    //   1293: invokestatic 1313	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1296: goto -624 -> 672
    //   1299: invokestatic 1467	com/tencent/mm/kernel/g:agS	()Lcom/tencent/mm/kernel/g;
    //   1302: pop
    //   1303: invokestatic 3180	com/tencent/mm/kernel/g:agQ	()Lcom/tencent/mm/kernel/b;
    //   1306: getfield 3186	com/tencent/mm/kernel/b:ghe	Lcom/tencent/mm/ak/q;
    //   1309: new 3188	com/tencent/mm/plugin/sns/model/p
    //   1312: dup
    //   1313: aload_0
    //   1314: getfield 511	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dnn	Ljava/lang/String;
    //   1317: invokestatic 3192	com/tencent/mm/plugin/sns/storage/x:asL	(Ljava/lang/String;)J
    //   1320: invokespecial 3194	com/tencent/mm/plugin/sns/model/p:<init>	(J)V
    //   1323: iconst_0
    //   1324: invokevirtual 3199	com/tencent/mm/ak/q:a	(Lcom/tencent/mm/ak/n;I)Z
    //   1327: pop
    //   1328: goto -518 -> 810
    //   1331: invokestatic 1467	com/tencent/mm/kernel/g:agS	()Lcom/tencent/mm/kernel/g;
    //   1334: pop
    //   1335: invokestatic 3180	com/tencent/mm/kernel/g:agQ	()Lcom/tencent/mm/kernel/b;
    //   1338: getfield 3186	com/tencent/mm/kernel/b:ghe	Lcom/tencent/mm/ak/q;
    //   1341: new 3287	com/tencent/mm/plugin/sns/model/l
    //   1344: dup
    //   1345: aload_0
    //   1346: getfield 511	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dnn	Ljava/lang/String;
    //   1349: invokestatic 3192	com/tencent/mm/plugin/sns/storage/x:asL	(Ljava/lang/String;)J
    //   1352: iconst_0
    //   1353: aload_0
    //   1354: aload_1
    //   1355: invokespecial 677	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:f	(Lcom/tencent/mm/plugin/sns/storage/p;)Lcom/tencent/mm/plugin/sns/storage/a;
    //   1358: getfield 3290	com/tencent/mm/plugin/sns/storage/a:yeX	Ljava/lang/String;
    //   1361: invokespecial 3293	com/tencent/mm/plugin/sns/model/l:<init>	(JILjava/lang/String;)V
    //   1364: iconst_0
    //   1365: invokevirtual 3199	com/tencent/mm/ak/q:a	(Lcom/tencent/mm/ak/n;I)Z
    //   1368: pop
    //   1369: goto -559 -> 810
    //   1372: aload_0
    //   1373: new 2240	com/tencent/mm/plugin/sns/ad/d/i
    //   1376: dup
    //   1377: iconst_1
    //   1378: invokespecial 3241	com/tencent/mm/plugin/sns/ad/d/i:<init>	(I)V
    //   1381: putfield 1026	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJJ	Lcom/tencent/mm/plugin/sns/ad/d/i;
    //   1384: goto -295 -> 1089
    //   1387: aload_0
    //   1388: getfield 671	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJi	Landroid/widget/ListView;
    //   1391: new 78	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$6
    //   1394: dup
    //   1395: aload_0
    //   1396: invokespecial 3294	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$6:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   1399: invokevirtual 3295	android/widget/ListView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1402: aload_0
    //   1403: new 3297	com/tencent/mm/plugin/sns/ui/n
    //   1406: dup
    //   1407: aload_0
    //   1408: invokespecial 3298	com/tencent/mm/plugin/sns/ui/n:<init>	(Landroid/content/Context;)V
    //   1411: putfield 331	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJW	Lcom/tencent/mm/plugin/sns/ui/n;
    //   1414: aload_1
    //   1415: ifnull +34 -> 1449
    //   1418: aload_0
    //   1419: getfield 1189	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:fnC	Ljava/lang/String;
    //   1422: aload_1
    //   1423: getfield 817	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
    //   1426: invokestatic 1686	com/tencent/mm/sdk/platformtools/bs:lr	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1429: ifeq +20 -> 1449
    //   1432: aload_0
    //   1433: iconst_0
    //   1434: ldc_w 3299
    //   1437: new 3301	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7
    //   1440: dup
    //   1441: aload_0
    //   1442: aload_1
    //   1443: invokespecial 3302	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;Lcom/tencent/mm/plugin/sns/storage/p;)V
    //   1446: invokevirtual 3306	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:addIconOptionMenu	(IILandroid/view/MenuItem$OnMenuItemClickListener;)V
    //   1449: getstatic 2854	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   1452: aload_0
    //   1453: getfield 385	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:kce	Lcom/tencent/mm/sdk/b/c;
    //   1456: invokevirtual 3309	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1459: pop
    //   1460: getstatic 2854	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   1463: aload_0
    //   1464: getfield 345	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yJZ	Lcom/tencent/mm/sdk/b/c;
    //   1467: invokevirtual 3309	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1470: pop
    //   1471: getstatic 2854	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   1474: aload_0
    //   1475: getfield 348	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yKa	Lcom/tencent/mm/sdk/b/c;
    //   1478: invokevirtual 3309	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1481: pop
    //   1482: getstatic 2854	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   1485: aload_0
    //   1486: getfield 351	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yKb	Lcom/tencent/mm/sdk/b/c;
    //   1489: invokevirtual 3309	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1492: pop
    //   1493: getstatic 2854	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   1496: aload_0
    //   1497: getfield 356	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yKc	Lcom/tencent/mm/sdk/b/c;
    //   1500: invokevirtual 3309	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1503: pop
    //   1504: getstatic 2854	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   1507: aload_0
    //   1508: getfield 380	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yKh	Lcom/tencent/mm/sdk/b/c;
    //   1511: invokevirtual 3309	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1514: pop
    //   1515: getstatic 2854	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   1518: aload_0
    //   1519: getfield 390	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yKi	Lcom/tencent/mm/sdk/b/c;
    //   1522: invokevirtual 3309	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1525: pop
    //   1526: getstatic 2854	com/tencent/mm/sdk/b/a:GpY	Lcom/tencent/mm/sdk/b/a;
    //   1529: aload_0
    //   1530: getfield 359	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:yyj	Lcom/tencent/mm/sdk/b/c;
    //   1533: invokevirtual 3309	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1536: pop
    //   1537: aload_0
    //   1538: invokestatic 3311	com/tencent/mm/pluginsdk/g:p	(Lcom/tencent/mm/ui/MMActivity;)V
    //   1541: ldc_w 2969
    //   1544: invokestatic 268	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1547: return
    //   1548: astore_1
    //   1549: goto -877 -> 672
    //   1552: astore 6
    //   1554: goto -914 -> 640
    //   1557: astore 7
    //   1559: goto -983 -> 576
    //   1562: iconst_0
    //   1563: istore 5
    //   1565: goto -303 -> 1262
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1568	0	this	SnsCommentDetailUI
    //   0	1568	1	paramBundle	Bundle
    //   286	11	2	i	int
    //   475	189	3	l	long
    //   1260	304	5	bool	boolean
    //   498	752	6	localObject	Object
    //   1552	1	6	localIOException	java.io.IOException
    //   1016	23	7	str	String
    //   1557	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   500	507	1548	java/io/IOException
    //   631	640	1552	java/io/IOException
    //   567	576	1557	java/lang/Exception
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98596);
    af.dHH().a(this, 5);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(210, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(218, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(213, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(214, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(683, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(682, this);
    af.dHO().aD(this);
    com.tencent.mm.sdk.b.a.GpY.d(this.kce);
    if (this.yJy != null) {
      this.yJy.activity = null;
    }
    ad.dNM();
    if (this.yxU != null) {
      this.yxU.dPE();
    }
    com.tencent.mm.plugin.sns.storage.p localp = rl(false);
    Object localObject;
    if ((localp != null) && (localp.Pe(32)))
    {
      if (this.yJJ != null) {
        this.yJJ.q(0, localp.dMu(), 2);
      }
      localObject = f(localp);
      if (localObject != null) {
        break label610;
      }
      localObject = "";
      if (!localp.dJU()) {
        break label618;
      }
      af.dHL().f(14652, new Object[] { com.tencent.mm.plugin.sns.ad.d.h.a(localp.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.q.wW(localp.field_snsId), localObject, Long.valueOf(this.yJc), Long.valueOf(System.currentTimeMillis()) }) });
    }
    for (;;)
    {
      com.tencent.mm.modelsns.d locald = com.tencent.mm.modelsns.d.pt(732);
      locald.Dn(com.tencent.mm.plugin.sns.data.q.wW(localp.field_snsId)).Dn((String)localObject).Dn(this.yJc).Dn(System.currentTimeMillis());
      locald.aHZ();
      this.xLF.removeListener();
      com.tencent.mm.sdk.b.a.GpY.d(this.yJZ);
      com.tencent.mm.sdk.b.a.GpY.d(this.yKa);
      com.tencent.mm.sdk.b.a.GpY.d(this.yKb);
      com.tencent.mm.sdk.b.a.GpY.d(this.yKc);
      com.tencent.mm.sdk.b.a.GpY.d(this.yKh);
      com.tencent.mm.sdk.b.a.GpY.d(this.yKi);
      com.tencent.mm.sdk.b.a.GpY.d(this.yyj);
      super.onDestroy();
      localObject = com.tencent.mm.plugin.sns.j.f.ydE;
      if (((com.tencent.mm.plugin.sns.j.f)localObject).yeb != 0L)
      {
        ((com.tencent.mm.plugin.sns.j.f)localObject).yec += System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.j.f)localObject).yeb;
        ((com.tencent.mm.plugin.sns.j.f)localObject).yeb = 0L;
      }
      localObject = com.tencent.mm.plugin.sns.j.f.ydE;
      if (((com.tencent.mm.plugin.sns.j.f)localObject).yei != 0L)
      {
        ((com.tencent.mm.plugin.sns.j.f)localObject).yej += System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.j.f)localObject).yei;
        ((com.tencent.mm.plugin.sns.j.f)localObject).yei = 0L;
      }
      if ((this.yJS) && (localp != null) && (localp.dLV() != null) && (localp.dLV().FQo != null))
      {
        localObject = com.tencent.mm.plugin.sns.j.f.ydE.dJw();
        ((dy)localObject).dNc = com.tencent.mm.plugin.sns.j.f.ydE.ydQ.dNc;
        ((dy)localObject).lT(com.tencent.mm.plugin.sns.j.f.ydE.ydQ.dUd).lU(com.tencent.mm.plugin.sns.data.q.wX(localp.field_snsId)).dHS = localp.dLV().FQo.Ety;
        com.tencent.mm.plugin.sns.j.f.ydE.dJB();
      }
      AppMethodBeat.o(98596);
      return;
      label610:
      localObject = ((com.tencent.mm.plugin.sns.storage.a)localObject).dtx;
      break;
      label618:
      af.dHL().f(12012, new Object[] { com.tencent.mm.plugin.sns.ad.d.h.a(localp.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.q.wW(localp.field_snsId), localObject, Long.valueOf(this.yJc), Long.valueOf(System.currentTimeMillis()) }) });
    }
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(98612);
    if (keyboardState() == 2)
    {
      ac.i("MicroMsg.SnsCommentDetailUI", "keybaordhide! ");
      this.yJs = false;
      AppMethodBeat.o(98612);
      return;
    }
    if (keyboardState() == 1)
    {
      ac.i("MicroMsg.SnsCommentDetailUI", "keybaordShow");
      dPu();
      this.yxR = false;
      this.yKf.run();
      if (this.yyc != null) {
        this.yyc.dJj();
      }
    }
    AppMethodBeat.o(98612);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98598);
    af.dHM().b(this);
    try
    {
      com.tencent.mm.sdk.platformtools.bg.a(this, null);
      this.yGw = false;
      super.onPause();
      this.yxU.iMV.hideVKB();
      localObject = this.yxU;
      if (((SnsCommentFooter)localObject).fWT != null) {
        ((SnsCommentFooter)localObject).fWT.onPause();
      }
      new wj().dzj.type = 1;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        Object localObject;
        if ((this.yJN) && (this.yJe != null) && (rl(false).Pe(32)))
        {
          localObject = (VideoSightView)this.yJe.findViewById(2131300914);
          if ((((VideoSightView)localObject).isPlaying()) && (((VideoSightView)localObject).getVisibility() == 0))
          {
            ac.i("MicroMsg.SnsCommentDetailUI", "pauseNormalVideoAd");
            ((VideoSightView)localObject).pause();
          }
        }
        if (this.yJJ != null)
        {
          this.yJJ.onPause();
          localObject = rl(false);
          if ((localObject != null) && (((com.tencent.mm.plugin.sns.storage.p)localObject).Pe(32))) {
            this.yJJ.wQ(((com.tencent.mm.plugin.sns.storage.p)localObject).field_snsId);
          }
        }
        if (this.yJI != null) {
          this.yJI.onPause();
        }
        AppMethodBeat.o(98598);
        return;
        localThrowable1 = localThrowable1;
        ac.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable1.toString());
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          ac.e("MicroMsg.SnsCommentDetailUI", "pauseNormalVideoAd, exp=" + localThrowable2.toString());
        }
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98597);
    try
    {
      if (!this.yGw)
      {
        ac.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onResume callback");
        com.tencent.mm.sdk.platformtools.bg.a(this, this.yHk);
        this.yGw = true;
      }
      af.dHM().a(this);
      wj localwj = new wj();
      localwj.dzj.dzk = 0;
      localwj.dzj.dzl = 1;
      localwj.dzj.dzm = 0;
      localwj.dzj.type = 0;
      com.tencent.mm.sdk.b.a.GpY.l(localwj);
      if (this.yJJ != null) {
        this.yJJ.onResume();
      }
      if (this.yJI != null) {
        this.yJI.refreshView();
      }
      super.onResume();
      AppMethodBeat.o(98597);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ac.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable.toString());
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(98611);
    if ((paramn.getType() == 218) && (this.yyh != null)) {
      this.yyh.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((this.yJW != null) && (this.yJW.tipDialog != null) && (this.yJW.tipDialog.isShowing())) {
        this.yJW.tipDialog.dismiss();
      }
      paramn = com.tencent.mm.plugin.sns.storage.h.auS(this.dnn);
      if (paramn == null)
      {
        ac.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.dnn);
        finish();
        AppMethodBeat.o(98611);
        return;
      }
      ac.d("MicroMsg.SnsCommentDetailUI", "snsId: " + this.dnn + "  username:" + paramn.field_userName);
      if (this.yJe == null)
      {
        ac.e("MicroMsg.SnsCommentDetailUI", "fatal error! Sns onSceneEnd before initView and infoHeader is null!");
        finish();
        AppMethodBeat.o(98611);
        return;
      }
      dPt();
      b(paramn, false);
      paramString = com.tencent.mm.plugin.sns.model.aj.s(paramn);
      ac.i("MicroMsg.SnsCommentDetailUI", "onsceneend " + paramString.LikeUserList.size() + " " + paramString.CommentUserList.size());
      if (paramString == null)
      {
        AppMethodBeat.o(98611);
        return;
      }
      if (!f(this.yJq, paramString.LikeUserList))
      {
        i(paramString.LikeUserList, paramString.CommentUserList.isEmpty());
        this.yJq = paramString.LikeUserList;
      }
      if (this.yJh != null) {
        this.yJh.a(paramn, this.xLF);
      }
      paramn = this.yJl;
      LinkedList localLinkedList = paramString.CommentUserList;
      paramString = paramString.LikeUserList;
      paramn.commentList = localLinkedList;
      paramn.yKM = paramString;
      this.yJl.notifyDataSetChanged();
      paramString = this.yJl;
      new ao().postDelayed(new SnsCommentDetailUI.b.1(paramString), 60L);
    }
    AppMethodBeat.o(98611);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(200503);
    super.onWindowFocusChanged(paramBoolean);
    ac.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      com.tencent.mm.sdk.platformtools.bg.a(this, null);
      this.yGw = false;
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(200503);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      ac.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(200503);
    }
    if (!this.yGw)
    {
      ac.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onWindowFocusChanged callback");
      com.tencent.mm.sdk.platformtools.bg.a(this, this.yHk);
      this.yGw = true;
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(200503);
    return;
  }
  
  final class a
    extends com.tencent.mm.pluginsdk.ui.span.p
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(98583);
      SnsCommentDetailUI.j(SnsCommentDetailUI.this).yYm.onClick(paramView);
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
    public LinkedList<daa> commentList;
    String ddB;
    LinkedList<daa> yKM;
    
    public b(LinkedList<daa> paramLinkedList, Activity paramActivity, String paramString)
    {
      this.commentList = paramLinkedList;
      this.yKM = paramActivity;
      this.activity = paramString;
      Object localObject;
      this.ddB = localObject;
    }
    
    public final int getCount()
    {
      int i = 0;
      AppMethodBeat.i(98587);
      if (this.yKM.size() > 0)
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
      if (this.yKM.size() > 0)
      {
        if (paramInt == 0)
        {
          paramView = SnsCommentDetailUI.K(SnsCommentDetailUI.this);
          AppMethodBeat.o(98588);
          return paramView;
        }
        i = paramInt - 1;
      }
      daa localdaa = (daa)this.commentList.get(i);
      localdaa.hkR = bs.nullAsNil(localdaa.hkR);
      View localView;
      if ((paramView == null) || (!(paramView.getTag() instanceof a)))
      {
        localView = com.tencent.mm.ui.z.jD(this.activity).inflate(2131495539, null);
        localView.setOnTouchListener(SnsCommentDetailUI.L(SnsCommentDetailUI.this));
        paramViewGroup = new a();
        paramViewGroup.fuY = ((ImageView)localView.findViewById(2131296547));
        paramViewGroup.fuY.setOnClickListener(SnsCommentDetailUI.M(SnsCommentDetailUI.this));
        paramViewGroup.iNX = ((TextView)localView.findViewById(2131296559));
        paramViewGroup.iNX.setOnTouchListener(new ad());
        paramViewGroup.iNX.setOnClickListener(new SnsCommentDetailUI.b.2(this));
        paramViewGroup.timeTv = ((TextView)localView.findViewById(2131296562));
        paramViewGroup.gIq = ((TextView)localView.findViewById(2131296551));
        paramViewGroup.yKO = ((FrameLayout)localView.findViewById(2131296550));
        paramViewGroup.gIq.setOnTouchListener(new ad());
        paramViewGroup.yKP = ((SnsTranslateResultView)localView.findViewById(2131305091));
        paramViewGroup.yKP.setVisibility(8);
        paramViewGroup.yKR = ((EmojiStatusView)localView.findViewById(2131296552));
        if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) != 10) {
          break label1732;
        }
        localView.findViewById(2131298543).setBackgroundResource(2131232444);
      }
      label435:
      label833:
      label1732:
      for (;;)
      {
        paramViewGroup.yKQ = localdaa;
        paramViewGroup.userName = localdaa.Username;
        ((SnsAvatarImageView)paramViewGroup.fuY).eM(localdaa.Username, 3);
        ((SnsAvatarImageView)paramViewGroup.fuY).setWeakContext(this.activity);
        label366:
        com.tencent.mm.plugin.sns.storage.p localp;
        if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10)
        {
          paramInt = 3;
          SnsCommentDetailUI.F(SnsCommentDetailUI.this);
          com.tencent.mm.kernel.g.agS();
          paramView = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNr(paramViewGroup.userName);
          if ((i != 0) || (!this.yKM.isEmpty())) {
            break label1399;
          }
          if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) != 10) {
            break label1388;
          }
          localView.setBackgroundResource(2131232445);
          if (i != 0) {
            break label1433;
          }
          localView.findViewById(2131304961).setVisibility(0);
          localView.findViewById(2131304962).setVisibility(8);
          if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10) {
            ((ImageView)localView.findViewById(2131304961)).setImageResource(2131690252);
          }
          label490:
          localp = com.tencent.mm.plugin.sns.storage.h.auS(SnsCommentDetailUI.o(SnsCommentDetailUI.this));
          paramViewGroup.fuY.setTag(localdaa.Username);
          if (!com.tencent.mm.plugin.sns.ui.widget.e.a(paramViewGroup.fuY, localp, localdaa.Username)) {
            a.b.w(paramViewGroup.fuY, localdaa.Username);
          }
          if (paramView == null) {
            break label1458;
          }
          paramView = paramView.aaS();
          if (!com.tencent.mm.plugin.sns.ui.widget.e.b(localp, localdaa.Username)) {
            break label1729;
          }
          paramView = com.tencent.mm.plugin.sns.ui.widget.e.b(localp.dFR(), paramView);
        }
        for (;;)
        {
          CharSequence localCharSequence;
          m localm;
          Object localObject;
          label742:
          int j;
          label881:
          long l;
          if (localp != null)
          {
            paramViewGroup.gIq.setText(localdaa.hkR + " ");
            localCharSequence = com.tencent.mm.plugin.sns.ui.widget.e.a(SnsCommentDetailUI.this, localdaa, SnsCommentDetailUI.N(SnsCommentDetailUI.this), localp.field_type, localp.field_userName, 2, SnsCommentDetailUI.O(SnsCommentDetailUI.this), SnsCommentDetailUI.P(SnsCommentDetailUI.this), localp);
            localm = null;
            localObject = localm;
            if (!bs.gY(localdaa.FJe))
            {
              localObject = localm;
              if (localdaa.FJe.get(0) != null)
              {
                localObject = ((dag)localdaa.FJe.get(0)).Md5;
                localObject = az.faZ().GXZ.aOT((String)localObject);
              }
            }
            if (localObject != null) {
              break label1484;
            }
            paramViewGroup.yKR.setVisibility(8);
            paramViewGroup.yKR.setEmojiInfo(null);
            paramViewGroup.iNX.setText(paramView, TextView.BufferType.SPANNABLE);
            com.tencent.mm.pluginsdk.ui.span.k.m(paramViewGroup.iNX, paramInt);
            localObject = new com.tencent.mm.pluginsdk.ui.span.l(paramViewGroup.iNX.getText());
            ac.i("MicroMsg.SnsCommentDetailUI", "test %s,%s", new Object[] { localdaa.Username, paramView });
            if (!com.tencent.mm.plugin.sns.ui.widget.e.b(localp, localdaa.Username)) {
              break label1576;
            }
            if (!com.tencent.mm.plugin.sns.ui.widget.e.hJ(localdaa.FJd, 32)) {
              break label1570;
            }
            j = 27;
            ((com.tencent.mm.pluginsdk.ui.span.l)localObject).a(new com.tencent.mm.pluginsdk.ui.span.p(new com.tencent.mm.plugin.sns.data.a(localp.Pe(32), localdaa.Username, localp.dMu(), 2, j), SnsCommentDetailUI.N(SnsCommentDetailUI.this), paramInt), paramView);
            paramViewGroup.iNX.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
            l = localdaa.CreateTime;
            if (com.tencent.mm.plugin.sns.ui.widget.e.hJ(localdaa.FJd, 32)) {
              l = localp.field_createTime;
            }
            paramViewGroup.timeTv.setText(bg.q(this.activity, l * 1000L));
            if (!bs.aj(localCharSequence)) {
              break label1605;
            }
            paramViewGroup.gIq.setVisibility(8);
            label972:
            SnsCommentDetailUI.Q(SnsCommentDetailUI.this).c(localView, SnsCommentDetailUI.E(SnsCommentDetailUI.this).zgC, SnsCommentDetailUI.E(SnsCommentDetailUI.this).zgp);
            SnsCommentDetailUI.Q(SnsCommentDetailUI.this).c(paramViewGroup.yKO, SnsCommentDetailUI.E(SnsCommentDetailUI.this).zgC, SnsCommentDetailUI.E(SnsCommentDetailUI.this).zgp);
            if (localdaa.FIZ == 0) {
              break label1648;
            }
            l = localdaa.FIZ;
            localObject = aq.jd(SnsCommentDetailUI.o(SnsCommentDetailUI.this), String.valueOf(l));
            if ((aq.eD((String)localObject, 4)) && (paramViewGroup.yKP != null))
            {
              localObject = aq.atX((String)localObject);
              if (localObject == null) {
                break label1681;
              }
              paramViewGroup.yKP.setVisibility(0);
              if (!((aq.b)localObject).hqq) {
                break label1670;
              }
              if (((aq.b)localObject).aEZ) {
                break label1658;
              }
              paramViewGroup.yKP.a((aq.b)localObject, 2, ((aq.b)localObject).result, ((aq.b)localObject).hym, ((aq.b)localObject).xVS);
            }
            label1148:
            localView.setClickable(true);
            ac.d("MicroMsg.SnsCommentDetailUI", "position " + localdaa.Username + " self " + SnsCommentDetailUI.t(SnsCommentDetailUI.this) + " commentid " + localdaa.FIZ + " snsid " + SnsCommentDetailUI.o(SnsCommentDetailUI.this));
            if (!SnsCommentDetailUI.t(SnsCommentDetailUI.this).equals(localdaa.Username)) {
              break label1693;
            }
          }
          for (paramViewGroup.info = localdaa;; paramViewGroup.info = new Object[] { Integer.valueOf(i), localdaa, localdaa.Username, paramView })
          {
            paramView = new m(SnsCommentDetailUI.k(SnsCommentDetailUI.this), SnsCommentDetailUI.o(SnsCommentDetailUI.this), localdaa, localdaa.Username, localdaa.hkR, paramViewGroup.gIq, 2);
            paramView.tag = paramViewGroup;
            localView.setTag(paramView);
            paramViewGroup.gIq.setTag(paramView);
            localView.setOnClickListener(SnsCommentDetailUI.R(SnsCommentDetailUI.this));
            paramViewGroup.gIq.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(SnsCommentDetailUI.this));
            paramViewGroup.yKO.setTag(paramView);
            paramViewGroup.yKO.setOnClickListener(SnsCommentDetailUI.R(SnsCommentDetailUI.this));
            AppMethodBeat.o(98588);
            return localView;
            paramViewGroup = (a)paramView.getTag();
            localView = paramView;
            break;
            paramInt = 2;
            break label366;
            label1388:
            localView.setBackgroundResource(2131232453);
            break label435;
            label1399:
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
            if (localdaa.Nickname != null)
            {
              paramView = localdaa.Nickname;
              break label552;
            }
            paramView = localdaa.Username;
            break label552;
            label1484:
            localm = new m(SnsCommentDetailUI.k(SnsCommentDetailUI.this), SnsCommentDetailUI.o(SnsCommentDetailUI.this), localdaa, localdaa.Username, localdaa.hkR, paramViewGroup.gIq, 2);
            paramViewGroup.yKR.setTag(localm);
            paramViewGroup.yKR.setVisibility(0);
            paramViewGroup.yKR.setEmojiInfo((EmojiInfo)localObject);
            paramViewGroup.yKR.setOnClickListener(SnsCommentDetailUI.E(SnsCommentDetailUI.this).zgT);
            break label742;
            j = 2;
            break label833;
            ((com.tencent.mm.pluginsdk.ui.span.l)localObject).a(new com.tencent.mm.pluginsdk.ui.span.p(localdaa.Username, SnsCommentDetailUI.N(SnsCommentDetailUI.this), paramInt), paramView);
            break label881;
            label1605:
            localObject = new SpannableStringBuilder(localCharSequence);
            ((SpannableStringBuilder)localObject).append(" ");
            paramViewGroup.gIq.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
            paramViewGroup.gIq.setVisibility(0);
            break label972;
            label1648:
            l = localdaa.FJb;
            break label1054;
            label1658:
            paramViewGroup.yKP.setVisibility(8);
            break label1148;
            paramViewGroup.yKP.PK(2);
            break label1148;
            paramViewGroup.yKP.setVisibility(8);
            break label1148;
          }
        }
      }
    }
    
    final class a
    {
      ImageView fuY;
      TextView gIq;
      TextView iNX;
      Object info;
      TextView timeTv;
      String userName;
      FrameLayout yKO;
      SnsTranslateResultView yKP;
      daa yKQ;
      EmojiStatusView yKR;
      
      a() {}
    }
  }
  
  final class c
    implements Runnable
  {
    int SW = -1;
    int it;
    private int offset = 0;
    private int yKS = -1;
    private int yKT = 10;
    
    c() {}
    
    public final void run()
    {
      AppMethodBeat.i(98589);
      this.yKT = 10;
      SnsCommentDetailUI.b(SnsCommentDetailUI.this);
      this.yKS = SnsCommentDetailUI.c(SnsCommentDetailUI.this).getTop();
      int i = this.yKS - this.it;
      ac.i("MicroMsg.SnsCommentDetailUI", "list.bottom: %d, listOriginalBottom: %d, footerTop: %d, commentFooter.getTop: %d, topSelection: %d", new Object[] { Integer.valueOf(SnsCommentDetailUI.a(SnsCommentDetailUI.this).getBottom()), Integer.valueOf(SnsCommentDetailUI.d(SnsCommentDetailUI.this)), Integer.valueOf(this.yKS), Integer.valueOf(SnsCommentDetailUI.c(SnsCommentDetailUI.this).getTop()), Integer.valueOf(i) });
      if (i == this.offset)
      {
        SnsCommentDetailUI.a(SnsCommentDetailUI.this).setSelectionFromTop(SnsCommentDetailUI.a(SnsCommentDetailUI.this).getHeaderViewsCount() + this.SW, i);
        this.yKT = 0;
        this.offset = 0;
        AppMethodBeat.o(98589);
        return;
      }
      int j = this.yKT;
      this.yKT = (j - 1);
      if (j > 0)
      {
        new ao().postDelayed(this, 100L);
        this.offset = i;
        AppMethodBeat.o(98589);
        return;
      }
      this.offset = 0;
      this.yKT = 0;
      AppMethodBeat.o(98589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI
 * JD-Core Version:    0.7.0.1
 */