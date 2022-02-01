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
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.g.a.ua;
import com.tencent.mm.g.a.ve;
import com.tencent.mm.g.a.vg;
import com.tencent.mm.g.a.vh;
import com.tencent.mm.g.a.xc;
import com.tencent.mm.g.b.a.ew;
import com.tencent.mm.g.b.a.ff;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ar.b;
import com.tencent.mm.plugin.sns.model.b.b;
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
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dft;
import com.tencent.mm.protocal.protobuf.dgo;
import com.tencent.mm.protocal.protobuf.ece;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bh.a;
import com.tencent.mm.sdk.platformtools.bt;
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
  implements com.tencent.mm.al.f, i.a, b.b, aa
{
  public static int Aba;
  private static com.tencent.mm.loader.c.e Abz;
  private static com.tencent.mm.loader.c.d<String, Bitmap> siR;
  private static com.tencent.mm.loader.c.e zQq;
  private LinearLayout AaA;
  private SnsDetailLuckyHeader AaB;
  private ListView AaC;
  private View AaD;
  private View AaE;
  private b AaF;
  private ScaleAnimation AaG;
  private ScaleAnimation AaH;
  LinearLayout AaI;
  LinearLayout AaJ;
  private LinkedList<dfn> AaK;
  private int AaL;
  private boolean AaM;
  private bb AaN;
  private String AaO;
  private com.tencent.mm.storage.bp AaP;
  private int AaQ;
  private ImageView AaR;
  private j AaS;
  private l AaT;
  private boolean AaU;
  private long AaV;
  private bo AaW;
  private boolean AaX;
  private int AaY;
  private int AaZ;
  private long Aaw;
  private long Aax;
  private View Aay;
  private TextView Aaz;
  private d AbA;
  private View.OnClickListener AbB;
  private com.tencent.mm.sdk.b.c AbC;
  private com.tencent.mm.sdk.b.c AbD;
  boolean AbE;
  private LinearLayout AbF;
  private boolean AbG;
  PhotosContent AbH;
  int AbI;
  public as.b.a AbJ;
  private bn AbK;
  public int Abb;
  private com.tencent.mm.plugin.sns.ui.c.a.a Abc;
  com.tencent.mm.plugin.sns.ad.d.i Abd;
  private SnsTranslateResultView Abe;
  private boolean Abf;
  private Dialog Abg;
  private boolean Abh;
  private boolean Abi;
  private String Abj;
  private boolean Abk;
  private int Abl;
  private boolean Abm;
  private int Abn;
  private boolean Abo;
  private boolean Abp;
  private n Abq;
  private TextView Abr;
  private boolean Abs;
  private FrameLayout Abt;
  private ah Abu;
  private com.tencent.mm.sdk.b.c Abv;
  private com.tencent.mm.sdk.b.c Abw;
  private com.tencent.mm.sdk.b.c Abx;
  private com.tencent.mm.sdk.b.c Aby;
  private String dzL;
  private String dzb;
  private String fFK;
  private boolean kTp;
  private com.tencent.mm.sdk.b.c kwD;
  private int mScreenHeight;
  private int mScreenWidth;
  private int nEc;
  private com.tencent.mm.ui.widget.b.a nZK;
  private int oIb;
  private View.OnClickListener oaE;
  private View.OnClickListener psK;
  private ClipboardManager rBg;
  private boolean zPd;
  private SnsCommentFooter zPg;
  private ay zPi;
  private b zPo;
  private com.tencent.mm.plugin.sns.h.b zPp;
  private am zPq;
  private br zPr;
  private com.tencent.mm.ui.base.p zPt;
  private com.tencent.mm.sdk.b.c zPv;
  private View.OnTouchListener zQU;
  private volatile boolean zXO;
  private bh.a zYD;
  private com.tencent.mm.plugin.sns.ui.d.c zaU;
  private LinearLayout zfi;
  
  static
  {
    AppMethodBeat.i(163117);
    Aba = 34;
    e.a locala = new e.a();
    locala.heb = true;
    locala.hea = true;
    Abz = locala.arf();
    siR = new com.tencent.mm.loader.c.c()
    {
      public final com.tencent.mm.loader.e.c.a<Bitmap> aqW()
      {
        AppMethodBeat.i(163115);
        com.tencent.mm.loader.e.c.a locala = new com.tencent.mm.loader.e.c.a(new com.tencent.mm.loader.e.c.c(0.5F).ark());
        AppMethodBeat.o(163115);
        return locala;
      }
    };
    locala = new e.a();
    locala.heb = true;
    locala.hea = true;
    zQq = locala.arf();
    AppMethodBeat.o(163117);
  }
  
  public SnsCommentDetailUI()
  {
    AppMethodBeat.i(98590);
    this.Aaw = 0L;
    this.Aax = 0L;
    this.AaL = -1;
    this.AaM = false;
    this.zQU = bt.flQ();
    this.zPt = null;
    this.nEc = 0;
    this.AaQ = 0;
    this.kTp = false;
    this.dzL = "";
    this.AaU = false;
    this.AaV = 0L;
    this.AaX = false;
    this.AaZ = 103;
    this.Abb = 210;
    this.Abf = false;
    this.Abg = null;
    this.Abh = false;
    this.Abi = false;
    this.Abj = "";
    this.Abk = true;
    this.Abm = false;
    this.Abn = 0;
    this.Abo = false;
    this.Abp = false;
    this.Abq = null;
    this.Abr = null;
    this.zXO = false;
    this.Abu = new ah();
    this.Abv = new com.tencent.mm.sdk.b.c() {};
    this.Abw = new com.tencent.mm.sdk.b.c() {};
    this.Abx = new com.tencent.mm.sdk.b.c() {};
    this.Aby = new SnsCommentDetailUI.34(this);
    this.zPv = new com.tencent.mm.sdk.b.c() {};
    this.AbA = new d();
    this.oaE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        AppMethodBeat.i(98579);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = (String)paramAnonymousView.getTag();
        ad.d("MicroMsg.SnsCommentDetailUI", "onCommentClick:".concat(String.valueOf(paramAnonymousView)));
        com.tencent.mm.plugin.sns.storage.p localp = SnsCommentDetailUI.e(SnsCommentDetailUI.this);
        if ((localp != null) && (localp.QM(32)))
        {
          localObject = new SnsAdClick(SnsCommentDetailUI.this.getSource(), 2, localp.field_snsId, 1, 0);
          com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject, SnsCommentDetailUI.f(SnsCommentDetailUI.this), localp, 1);
          com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject);
          if ((paramAnonymousView != null) && (paramAnonymousView.equals(localp.field_userName)))
          {
            com.tencent.mm.plugin.sns.storage.b localb = localp.dRL();
            if ((localb != null) && (localb.zvH == 1) && (!bt.isNullOrNil(localb.zvI)))
            {
              localObject = localb.zvI;
              com.tencent.mm.plugin.sns.storage.a locala = SnsCommentDetailUI.a(SnsCommentDetailUI.this, localp);
              paramAnonymousView = (View)localObject;
              if (locala != null) {
                paramAnonymousView = com.tencent.mm.plugin.sns.data.q.jh((String)localObject, locala.dFy);
              }
              ad.i("MicroMsg.SnsCommentDetailUI", "headClickParam url " + paramAnonymousView + " " + localb.zvJ);
              localObject = new Intent();
              if (localb.zvJ == 0) {
                bool = true;
              }
              ((Intent)localObject).putExtra("KsnsViewId", SnsCommentDetailUI.a(SnsCommentDetailUI.this, localp).aQj);
              ((Intent)localObject).putExtra("KRightBtn", bool);
              ((Intent)localObject).putExtra("jsapiargs", new Bundle());
              ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
              ((Intent)localObject).putExtra("useJs", true);
              com.tencent.mm.plugin.sns.c.a.iRG.i((Intent)localObject, SnsCommentDetailUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(98579);
              return;
            }
          }
          localObject = new Intent();
          ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
          ((Intent)localObject).putExtra("Contact_Scene", 37);
          com.tencent.mm.plugin.sns.c.a.iRG.c((Intent)localObject, SnsCommentDetailUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98579);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
        com.tencent.mm.plugin.sns.c.a.iRG.c((Intent)localObject, SnsCommentDetailUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(98579);
      }
    };
    this.AbB = new SnsCommentDetailUI.43(this);
    this.psK = new SnsCommentDetailUI.3(this);
    this.AbC = new SnsCommentDetailUI.8(this);
    this.kwD = new SnsCommentDetailUI.9(this);
    this.AbD = new SnsCommentDetailUI.10(this);
    this.zYD = new SnsCommentDetailUI.11(this);
    this.AbE = false;
    this.AbF = null;
    this.AbG = false;
    this.AbH = null;
    this.AbI = 0;
    this.AbJ = new SnsCommentDetailUI.22(this);
    this.AbK = null;
    AppMethodBeat.o(98590);
  }
  
  private LinearLayout Re(int paramInt)
  {
    AppMethodBeat.i(98601);
    if (this.AbF == null)
    {
      this.AbF = ((LinearLayout)z.jO(this).inflate(paramInt, null));
      localLinearLayout = this.AbF;
      AppMethodBeat.o(98601);
      return localLinearLayout;
    }
    this.AbE = true;
    LinearLayout localLinearLayout = this.AbF;
    AppMethodBeat.o(98601);
    return localLinearLayout;
  }
  
  private void a(PhotosContent paramPhotosContent)
  {
    AppMethodBeat.i(198341);
    if (paramPhotosContent == null)
    {
      AppMethodBeat.o(198341);
      return;
    }
    try
    {
      ImageView localImageView = new ImageView(getContext());
      int i = com.tencent.mm.cc.a.fromDPToPix(getContext(), 24);
      int j = com.tencent.mm.cc.a.fromDPToPix(getContext(), 4);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
      localLayoutParams.leftMargin = j;
      localLayoutParams.topMargin = j;
      localImageView.setImageDrawable(com.tencent.mm.cc.a.l(getContext(), 2131235087));
      localImageView.setLayoutParams(localLayoutParams);
      paramPhotosContent.addView(localImageView);
      AppMethodBeat.o(198341);
      return;
    }
    catch (Throwable paramPhotosContent)
    {
      ad.e("MicroMsg.SnsCommentDetailUI", paramPhotosContent.toString());
      AppMethodBeat.o(198341);
    }
  }
  
  private boolean a(com.tencent.mm.plugin.sns.storage.p paramp, SnsAdTimelineVideoView paramSnsAdTimelineVideoView)
  {
    AppMethodBeat.i(198342);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramSnsAdTimelineVideoView != null)
    {
      bool1 = bool2;
      if (this.Abs)
      {
        bool1 = bool2;
        if (paramp != null)
        {
          bool1 = bool2;
          if (paramp.QM(32)) {
            bool1 = true;
          }
        }
      }
    }
    ad.i("MicroMsg.SnsCommentDetailUI", "the useNewPlayer return value is ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(198342);
    return bool1;
  }
  
  private void b(com.tencent.mm.plugin.sns.storage.p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(98603);
    if (this.Abr == null)
    {
      AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
      this.Abr = new TextView(this);
      this.Abr.setLayoutParams(localLayoutParams);
      this.Abr.setText(getString(2131763801));
      this.Abr.setTextColor(getResources().getColor(2131100711));
      this.Abr.setGravity(17);
      this.Abr.setPadding(0, BackwardSupportUtil.b.g(this, 7.0F), 0, BackwardSupportUtil.b.g(this, 12.0F));
      this.Abr.setVisibility(8);
      this.AaC.addFooterView(this.Abr);
    }
    if (paramp != null)
    {
      if ((paramp.field_localPrivate & 0x1) != 0)
      {
        findViewById(2131298521).setVisibility(8);
        paramp = paramp.dYl();
        if (paramp != null) {
          switch (paramp.HAT.GaP)
          {
          }
        }
        for (;;)
        {
          this.Abr.setVisibility(0);
          AppMethodBeat.o(98603);
          return;
          this.Abr.setText(getString(2131763802));
          continue;
          this.Abr.setText(getString(2131763805));
          continue;
          this.Abr.setText(getString(2131763803));
        }
      }
      if (paramBoolean) {
        findViewById(2131298521).setVisibility(0);
      }
      this.Abr.setVisibility(8);
    }
    AppMethodBeat.o(98603);
  }
  
  private int ebI()
  {
    AppMethodBeat.i(98600);
    if ((this.AaC != null) && (this.AaC.getChildCount() > 1))
    {
      View localView = this.AaC.getChildAt(0);
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
  
  private static boolean ebJ()
  {
    AppMethodBeat.i(98602);
    if ((an.a.dUJ() & 0x1) <= 0)
    {
      AppMethodBeat.o(98602);
      return true;
    }
    AppMethodBeat.o(98602);
    return false;
  }
  
  private void ebL()
  {
    AppMethodBeat.i(98605);
    if ((this.AaD == null) || (this.AaD.getVisibility() == 8))
    {
      AppMethodBeat.o(98605);
      return;
    }
    this.AaD.startAnimation(this.AaH);
    this.AaH.setAnimationListener(new SnsCommentDetailUI.38(this));
    AppMethodBeat.o(98605);
  }
  
  private void ebM()
  {
    AppMethodBeat.i(98606);
    if ((keyboardState() == 1) || (this.zPg.ebQ()))
    {
      this.AbA.run();
      AppMethodBeat.o(98606);
      return;
    }
    this.zPd = true;
    AppMethodBeat.o(98606);
  }
  
  private void ebN()
  {
    AppMethodBeat.i(98607);
    if (this.AaR == null)
    {
      AppMethodBeat.o(98607);
      return;
    }
    this.AaR.setPressed(false);
    if (bo.awP(this.dzL))
    {
      this.AaR.setImageResource(2131233393);
      AppMethodBeat.o(98607);
      return;
    }
    this.AaR.setImageResource(2131233395);
    AppMethodBeat.o(98607);
  }
  
  private com.tencent.mm.plugin.sns.storage.a f(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(98594);
    if (paramp != null)
    {
      if (getSource() == 2)
      {
        paramp = paramp.dYi();
        AppMethodBeat.o(98594);
        return paramp;
      }
      paramp = paramp.dRK();
      AppMethodBeat.o(98594);
      return paramp;
    }
    AppMethodBeat.o(98594);
    return null;
  }
  
  private static boolean f(LinkedList<dfn> paramLinkedList1, LinkedList<dfn> paramLinkedList2)
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
      if (!((dfn)paramLinkedList1.get(i)).Username.equals(((dfn)paramLinkedList2.get(i)).Username))
      {
        AppMethodBeat.o(98591);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(98591);
    return true;
  }
  
  private boolean j(List<dfn> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(98608);
    int k = BackwardSupportUtil.b.g(this, 32.0F);
    int m = BackwardSupportUtil.b.g(this, 6.0F);
    int i = BackwardSupportUtil.b.g(this, 10.0F);
    int j = BackwardSupportUtil.b.g(this, 17.0F);
    if (this.AaA == null)
    {
      AppMethodBeat.o(98608);
      return false;
    }
    int n = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    float f = getResources().getDimension(2131165516);
    ad.d("MicroMsg.SnsCommentDetailUI", "guess size %d %f", new Object[] { Integer.valueOf(n), Float.valueOf(f) });
    f = n - f * 2.0F;
    if (paramList.size() <= 0)
    {
      if (this.AaA.getParent() != null) {
        this.AaA.setVisibility(8);
      }
      this.AaA.removeAllViews();
      this.AaA.setVisibility(8);
      this.zfi.setVisibility(8);
      AppMethodBeat.o(98608);
      return false;
    }
    this.AaA.getParent();
    this.AaA.removeAllViews();
    this.AaA.setVisibility(0);
    Object localObject1;
    if (this.oIb == 10) {
      if (!this.Abf)
      {
        this.AaA.setBackgroundResource(2131232445);
        this.AaA.setPadding(0, m, 0, m);
        localObject1 = new ImageView(getContext());
        if (this.oIb != 10) {
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
      this.AaA.addView((View)localObject1);
      n = com.tencent.mm.cc.a.fromDPToPix(getContext(), Aba);
      j = (int)(f - n) / (m + k);
      i = j;
      if ((int)(f - n) % (m + k) > k) {
        i = j + 1;
      }
      ad.d("MicroMsg.SnsCommentDetailUI", "guess size %d", new Object[] { Integer.valueOf(i) });
      localObject1 = new h(getContext());
      ((h)localObject1).setClipChildren(false);
      ((h)localObject1).setClipToPadding(false);
      ((h)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((h)localObject1).setLineMaxCounte(i);
      i = 0;
      while (i < paramList.size())
      {
        localObject2 = (dfn)paramList.get(i);
        StoryTouchImageView localStoryTouchImageView = new StoryTouchImageView(getContext());
        localStoryTouchImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localStoryTouchImageView.setImageResource(2131232455);
        Object localObject3 = ((dfn)localObject2).Username;
        localStoryTouchImageView.ApJ.fe((String)localObject3, 1);
        localObject3 = new LinearLayout.LayoutParams(k, k);
        ((LinearLayout.LayoutParams)localObject3).setMargins(0, m, m, 0);
        localStoryTouchImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localStoryTouchImageView.setTag(((dfn)localObject2).Username);
        a.b.w(localStoryTouchImageView, ((dfn)localObject2).Username);
        localStoryTouchImageView.setOnClickListener(this.oaE);
        ((h)localObject1).addView(localStoryTouchImageView);
        i += 1;
      }
      localObject1 = rP(false);
      if (localObject1 != null)
      {
        if (this.fFK.equals(((com.tencent.mm.plugin.sns.storage.p)localObject1).field_userName))
        {
          this.AaA.setBackgroundResource(2131232446);
          break;
        }
        this.AaA.setBackgroundResource(2131232445);
        break;
      }
      this.AaA.setBackgroundResource(2131232445);
      break;
      this.AaA.setBackgroundResource(2131232453);
      break;
      label692:
      ((ImageView)localObject1).setImageDrawable(ao.k(getContext(), 2131690247, getContext().getResources().getColor(2131099769)));
    }
    this.AaA.addView((View)localObject1);
    paramList = this.zfi;
    if (paramBoolean) {}
    for (i = 8;; i = 0)
    {
      paramList.setVisibility(i);
      AppMethodBeat.o(98608);
      return true;
    }
  }
  
  private void rO(boolean paramBoolean)
  {
    AppMethodBeat.i(98592);
    this.AaM = false;
    if (this.zPg.ebP())
    {
      this.zPg.Acs = 0;
      this.zPg.ebS();
      this.zPg.setCommentHint(getString(2131764046));
    }
    this.zPg.rQ(false);
    if (paramBoolean)
    {
      Object localObject1 = this.AaC;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "scrollDown", "(Z)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
      BackwardSupportUtil.c.b((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "scrollDown", "(Z)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    }
    AppMethodBeat.o(98592);
  }
  
  private com.tencent.mm.plugin.sns.storage.p rP(boolean paramBoolean)
  {
    AppMethodBeat.i(98593);
    com.tencent.mm.plugin.sns.storage.p localp;
    if (!bt.isNullOrNil(this.AaO))
    {
      localp = com.tencent.mm.plugin.sns.storage.h.aAa(this.AaO);
      if (localp == null)
      {
        if (paramBoolean) {
          Toast.makeText(this, 2131763915, 0).show();
        }
        finish();
        AppMethodBeat.o(98593);
        return null;
      }
      this.dzb = localp.getSnsId();
    }
    for (;;)
    {
      AppMethodBeat.o(98593);
      return localp;
      localp = com.tencent.mm.plugin.sns.storage.h.azZ(this.dzb);
      if (localp == null)
      {
        finish();
        AppMethodBeat.o(98593);
        return null;
      }
      this.AaO = localp.dYK();
    }
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void ays(String paramString) {}
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void bM(String paramString, boolean paramBoolean) {}
  
  public final void bN(String paramString, boolean paramBoolean) {}
  
  public final void dTb() {}
  
  public final br dZA()
  {
    return this.zPr;
  }
  
  public final am dZx()
  {
    return this.zPq;
  }
  
  public final b dZy()
  {
    return this.zPo;
  }
  
  public final bp dZz()
  {
    return null;
  }
  
  final boolean ebK()
  {
    AppMethodBeat.i(98604);
    final com.tencent.mm.plugin.sns.storage.p localp = rP(true);
    if (localp == null)
    {
      AppMethodBeat.o(98604);
      return false;
    }
    ad.i("MicroMsg.SnsCommentDetailUI", "setheader " + this.Aay.toString());
    this.AaY = com.tencent.mm.plugin.sns.model.ag.dUp();
    Object localObject6 = localp.dYl();
    this.oIb = bh.c(localp, false);
    Object localObject1 = (SnsAvatarImageView)this.Aay.findViewById(2131296533);
    Object localObject5 = (RelativeLayout)this.Aay.findViewById(2131303033);
    ((RelativeLayout)localObject5).setVisibility(8);
    ((RelativeLayout)localObject5).setOnClickListener(this.zaU.AyU);
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
        ad.e("MicroMsg.SnsCommentDetailUI", bool);
        AppMethodBeat.o(98604);
        return false;
        bool = false;
        break;
      }
    }
    ((SnsAvatarImageView)localObject1).setWeakContext(this);
    ((MaskImageButton)localObject1).hgD = localp.dYK();
    ((SnsAvatarImageView)localObject1).setTag(localp.getUserName());
    label338:
    Object localObject7;
    int j;
    if ((localp.dRL() != null) && (localp.dRL().zws))
    {
      if (!bt.isNullOrNil(localp.dRL().zwu))
      {
        localObject2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jF("adId", localp.dRL().zwu);
        ((SnsAvatarImageView)localObject1).setTag(2131305044, localp.dRL().zwu);
        if (!com.tencent.mm.vfs.i.fv((String)localObject2)) {
          break label1337;
        }
        localObject2 = com.tencent.mm.plugin.sns.ad.d.l.yZH.getBitmap((String)localObject2);
        if (localObject2 != null) {
          ((SnsAvatarImageView)localObject1).setImageBitmap((Bitmap)localObject2);
        }
      }
      ((SnsAvatarImageView)localObject1).setOnClickListener(this.zaU.Ayr);
      localObject2 = (TextView)this.Aay.findViewById(2131302867);
      com.tencent.mm.kernel.g.ajD();
      localObject7 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(localp.getUserName());
      ad.i("MicroMsg.SnsCommentDetailUI", "snsinfo username " + localp.getUserName() + " " + localp.getSnsId() + " " + localp.getCreateTime());
      if ((localObject7 != null) && (((com.tencent.mm.storage.am)localObject7).adt() == 0))
      {
        ad.i("MicroMsg.SnsCommentDetailUI", "getContact %s", new Object[] { localp.getUserName() });
        as.a.aBA().a(localp.getUserName(), "", this.AbJ);
      }
      j = 0;
      if (localObject7 != null) {
        break label1566;
      }
    }
    Object localObject4;
    int i;
    int k;
    label1153:
    label1566:
    for (localObject1 = localp.getUserName();; localObject1 = ((com.tencent.mm.storage.am)localObject7).adv())
    {
      localObject1 = bt.bI((String)localObject1, "");
      if (!localp.vx()) {
        break label1612;
      }
      localObject4 = localp.dRL();
      if (localObject4 == null) {
        break label12098;
      }
      if (!((com.tencent.mm.plugin.sns.storage.b)localObject4).zws) {
        break label1576;
      }
      localObject4 = ((com.tencent.mm.plugin.sns.storage.b)localObject4).zwt;
      i = 0;
      ((String)localObject4).length();
      if (this.oIb != 10) {
        break label1738;
      }
      k = 3;
      label585:
      localObject1 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject4));
      ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).b(new com.tencent.mm.pluginsdk.ui.span.p(new com.tencent.mm.plugin.sns.data.a(localp.vx(), ((com.tencent.mm.storage.am)localObject7).getUsername(), localp.dYK(), 2), this.AaS, k), (CharSequence)localObject4);
      if ((j >= 0) && (i > j)) {
        ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).setSpan(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).f(this, ((com.tencent.mm.storage.am)localObject7).VH(), this.Abn), j, i, 33);
      }
      ((TextView)localObject2).setOnTouchListener(new ae());
      ((TextView)localObject2).setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
      ((TextView)this.Aay.findViewById(2131306175)).setText("");
      this.AbK = new bn(this.Aay);
      if (!localp.vx()) {
        break label1744;
      }
      this.AbK.H(Long.valueOf(localp.field_snsId), new com.tencent.mm.plugin.sns.data.b(this.AbK, 0, this.AaO, localp.field_snsId, f(localp).aQj));
      this.AbK.a(localp.dRL(), f(localp));
      this.AbK.a(this.zaU.AyB, this.zaU.AyR);
      this.AbK.setVisibility(0);
      label846:
      localObject1 = ((TimeLineObject)localObject6).HAQ;
      this.Aaz = ((TextView)this.Aay.findViewById(2131299008));
      localObject2 = new bd(this.dzb, localp.dYK(), true, false, 2);
      this.Aaz.setTag(localObject2);
      this.nZK.c(this.Aaz, this.zaU.Ayt, this.zaU.Ayq);
      if (!bt.isNullOrNil((String)localObject1)) {
        break label1756;
      }
      this.Aaz.setVisibility(8);
      label942:
      localObject1 = (ViewStub)this.Aay.findViewById(2131300969);
      if (!this.AbG) {
        ((ViewStub)localObject1).setLayoutResource(-1);
      }
      switch (this.oIb)
      {
      case 6: 
      case 7: 
      case 8: 
      case 12: 
      case 16: 
      case 17: 
      default: 
        ((ViewStub)localObject1).setVisibility(8);
        label1067:
        if (((ViewStub)localObject1).getLayoutResource() == -1) {
          break label2034;
        }
        localObject2 = ((ViewStub)localObject1).inflate();
        if (this.Abc != null)
        {
          this.Abc.kBS = findViewById(2131305824);
          this.Abc.m((View)localObject2, this.AaE);
          if (((this.Abc instanceof com.tencent.mm.plugin.sns.ui.c.a.c)) && (this.Abt != null)) {
            ((com.tencent.mm.plugin.sns.ui.c.a.c)this.Abc).c(this.Abt);
          }
        }
        this.AbG = true;
        k = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        if (this.oIb == 6) {
          break label2499;
        }
        if ((this.oIb != 2) && (this.oIb != 3) && (this.oIb != 4) && (this.oIb != 5)) {
          break label4181;
        }
        this.AbH = ((PhotosContent)findViewById(2131303243));
        if (this.AbH == null) {
          break label4138;
        }
        this.AbH.eaI();
        if (this.oIb != 2) {
          break label2044;
        }
        i = 1;
        label1256:
        j = 0;
        while (j < i)
        {
          localObject1 = (TagImageView)this.AbH.findViewById(bb.AfX[j]);
          this.AbH.a((TagImageView)localObject1);
          ((TagImageView)localObject1).setOnClickListener(this.zaU.zRv);
          this.nZK.c((View)localObject1, this.zaU.AyE, this.zaU.Ayq);
          j += 1;
        }
        label1337:
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localp.dRL().zwu, false, new f.a()
        {
          public final void axG(String paramAnonymousString)
          {
            AppMethodBeat.i(163106);
            ad.i("MicroMsg.SnsCommentDetailUI", "download img %s", new Object[] { paramAnonymousString });
            String str = (String)this.AbS.getTag(2131305044);
            if ((!bt.V(new String[] { str, paramAnonymousString })) && (paramAnonymousString.equals(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.jF("adId", str))))
            {
              paramAnonymousString = com.tencent.mm.plugin.sns.ad.d.l.yZH.getBitmap(paramAnonymousString);
              if (paramAnonymousString != null) {
                this.AbS.setImageBitmap(paramAnonymousString);
              }
            }
            AppMethodBeat.o(163106);
          }
          
          public final void dRW() {}
          
          public final void dRX()
          {
            AppMethodBeat.i(198325);
            ad.e("MicroMsg.SnsCommentDetailUI", "onDownloadError");
            AppMethodBeat.o(198325);
          }
        });
        break label338;
        if (localp.getUserName().endsWith("@ad")) {
          break label338;
        }
        if (localp.vx()) {}
        for (;;)
        {
          try
          {
            com.tencent.mm.kernel.g.ajD();
            localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(localp.getUserName());
            if ((localObject2 == null) || (((com.tencent.mm.storage.am)localObject2).adt() == 0)) {
              continue;
            }
            a.b.w((ImageView)localObject1, localp.getUserName());
            ad.i("MicroMsg.SnsCommentDetailUI", "has contact before setAvatar, userName=" + localp.getUserName());
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.SnsCommentDetailUI", "setAvatar exp=" + localException.toString());
            continue;
          }
          ((SnsAvatarImageView)localObject1).fe(localp.getUserName(), 2);
          bt.lQ(this.fFK, localp.getUserName());
          break;
          ad.e("MicroMsg.SnsCommentDetailUI", "has no contact before setAvatar, userName=" + localp.getUserName());
          continue;
          a.b.w((ImageView)localObject1, localp.getUserName());
        }
      }
    }
    label1576:
    if ((bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject4).nickname))) {
      localObject1 = ((com.tencent.mm.plugin.sns.storage.b)localObject4).nickname;
    }
    label2581:
    label2612:
    label3386:
    label4928:
    label6464:
    label11584:
    label12098:
    for (;;)
    {
      i = 0;
      localObject4 = localObject1;
      break;
      label1612:
      if ((localObject7 != null) && (com.tencent.mm.storage.am.aSQ(((com.tencent.mm.storage.am)localObject7).getUsername())) && ("3552365301".equals(((com.tencent.mm.storage.am)localObject7).VH())))
      {
        j = ((String)localObject1).length();
        localObject4 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bC(((com.tencent.mm.storage.am)localObject7).VH(), ((com.tencent.mm.storage.am)localObject7).VG());
        localObject4 = (String)localObject1 + " @" + (String)localObject4;
        i = ((String)localObject4).length();
        ((RelativeLayout)localObject5).setTag(new com.tencent.mm.plugin.sns.data.e((View)localObject5, localp.dYK()));
        ((RelativeLayout)localObject5).setVisibility(0);
        break;
        k = 2;
        break label585;
        label1744:
        this.AbK.setVisibility(8);
        break label846;
        label1756:
        this.Aaz.setText((String)localObject1 + " ");
        com.tencent.mm.pluginsdk.ui.span.k.n(this.Aaz, 2);
        this.Aaz.setVisibility(0);
        com.tencent.mm.plugin.sns.j.e.ztz.dVJ().Tl();
        break label942;
        ((ViewStub)localObject1).setLayoutResource(2131495611);
        break label1067;
        ((ViewStub)localObject1).setLayoutResource(2131495608);
        break label1067;
        ((ViewStub)localObject1).setLayoutResource(2131495609);
        break label1067;
        ((ViewStub)localObject1).setLayoutResource(2131495610);
        break label1067;
        ((ViewStub)localObject1).setLayoutResource(2131495566);
        break label1067;
        ((ViewStub)localObject1).setLayoutResource(2131495550);
        break label1067;
        ((ViewStub)localObject1).setLayoutResource(2131496489);
        break label1067;
        ((ViewStub)localObject1).setLayoutResource(2131495488);
        this.Abc = new com.tencent.mm.plugin.sns.ui.c.a.b((TimeLineObject)localObject6, localp, this.zaU, this.Abd);
        break label1067;
        ((ViewStub)localObject1).setLayoutResource(2131495614);
        this.Abc = new com.tencent.mm.plugin.sns.ui.c.a.e((TimeLineObject)localObject6, localp, this.zaU, this.Abd);
        break label1067;
        ((ViewStub)localObject1).setLayoutResource(2131495603);
        this.Abc = new com.tencent.mm.plugin.sns.ui.c.a.c((TimeLineObject)localObject6, localp, this.zaU, this.Abd);
        break label1067;
        ((ViewStub)localObject1).setLayoutResource(2131495604);
        this.Abc = new com.tencent.mm.plugin.sns.ui.c.a.d((TimeLineObject)localObject6, localp, this.zaU);
        break label1067;
        ((ViewStub)localObject1).setLayoutResource(2131495566);
        break label1067;
        label2034:
        ((ViewStub)localObject1).setVisibility(8);
        break label1153;
        label2044:
        i = bb.AfT[this.oIb];
        break label1256;
        this.AbH.setImageViewWidth(this.AaY);
        localObject1 = new LinkedList();
        Object localObject3;
        float f2;
        float f1;
        Object localObject8;
        if ((localp.vx()) && (this.oIb == 2))
        {
          localObject3 = localp.dRL();
          this.AbH.Ra(0).setScaleType(QImageView.a.KTb);
          if ((localObject3 != null) && (!((com.tencent.mm.plugin.sns.storage.b)localObject3).dVZ()) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).zvY > 0.0F) && (((com.tencent.mm.plugin.sns.storage.b)localObject3).zvZ > 0.0F))
          {
            f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).zvY, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).zwa, ((com.tencent.mm.plugin.sns.storage.b)localObject3).zwb);
            f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).zvZ, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).zwa, ((com.tencent.mm.plugin.sns.storage.b)localObject3).zwb);
            if (((com.tencent.mm.plugin.sns.storage.b)localObject3).zvX != 0) {
              break label3852;
            }
            float f3 = f1;
            f1 = f2;
            if (f2 >= k - com.tencent.mm.cc.a.ax(this, 2131166827) - com.tencent.mm.cc.a.ax(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516))
            {
              f1 = k - com.tencent.mm.cc.a.ax(this, 2131166827) - com.tencent.mm.cc.a.ax(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
              f3 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject3).zvZ * f1 / ((com.tencent.mm.plugin.sns.storage.b)localObject3).zvY);
            }
            localObject5 = new byp();
            ((byp)localObject5).GTz = f1;
            ((byp)localObject5).GTA = f3;
            ((byp)localObject5).GTB = (((byp)localObject5).GTz * ((byp)localObject5).GTA);
            ((LinkedList)localObject1).add(localObject5);
          }
          if ((com.tencent.mm.plugin.sns.data.j.a(localp, getSource())) && (!com.tencent.mm.plugin.sns.data.j.l(localp))) {
            a(this.AbH);
          }
          if (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.b)localObject3).zwd))
          {
            localObject5 = this.AbH;
            localObject8 = this.AbH.Ra(0);
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((com.tencent.mm.plugin.sns.storage.b)localObject3).zwd, false, 41, new f.a()
            {
              public final void axG(String paramAnonymousString)
              {
                AppMethodBeat.i(198326);
                MaskImageView localMaskImageView = (MaskImageView)this.AbT.findViewById(2131302209);
                if (localMaskImageView != null)
                {
                  localMaskImageView.setVisibility(0);
                  localMaskImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.g.decodeFile(paramAnonymousString));
                  float f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.AbU.zwe, 1, this.AbU.zwa, this.AbU.zwb);
                  float f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.AbU.zwf, 1, this.AbU.zwa, this.AbU.zwb);
                  float f3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.AbU.zwg, 1, this.AbU.zwa, this.AbU.zwb);
                  float f4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(this.AbU.zwh, 1, this.AbU.zwa, this.AbU.zwb);
                  paramAnonymousString = new FrameLayout.LayoutParams((int)f1, (int)f2);
                  paramAnonymousString.setMargins((int)(this.AbV.getRight() - f3 - f1), (int)(this.AbV.getBottom() - f4 - f2), 0, 0);
                  localMaskImageView.setLayoutParams(paramAnonymousString);
                }
                AppMethodBeat.o(198326);
              }
              
              public final void dRW() {}
              
              public final void dRX() {}
            });
          }
        }
        this.Aay.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
        {
          boolean AbW = false;
          
          public final void onViewAttachedToWindow(View paramAnonymousView)
          {
            AppMethodBeat.i(198327);
            ad.i("MicroMsg.SnsCommentDetailUI", "onViewAttachedToWindow infoHeader %s", new Object[] { Boolean.valueOf(this.AbW) });
            if (!this.AbW)
            {
              AppMethodBeat.o(198327);
              return;
            }
            this.AbW = false;
            if (this.AbX == null)
            {
              AppMethodBeat.o(198327);
              return;
            }
            if (localp == null)
            {
              AppMethodBeat.o(198327);
              return;
            }
            if (SnsCommentDetailUI.this.AbH == null)
            {
              AppMethodBeat.o(198327);
              return;
            }
            paramAnonymousView = SnsCommentDetailUI.G(SnsCommentDetailUI.this);
            PhotosContent localPhotosContent = SnsCommentDetailUI.this.AbH;
            TimeLineObject localTimeLineObject = this.AbX;
            String str = localp.dYK();
            SnsCommentDetailUI.E(SnsCommentDetailUI.this);
            paramAnonymousView.a(localPhotosContent, localTimeLineObject, str, SnsCommentDetailUI.this.hashCode(), SnsCommentDetailUI.F(SnsCommentDetailUI.this), -1, localp.QM(32), false, com.tencent.mm.storage.bj.ILU, this.AbY, localp.getSnsId());
            AppMethodBeat.o(198327);
          }
          
          public final void onViewDetachedFromWindow(View paramAnonymousView)
          {
            AppMethodBeat.i(198328);
            ad.i("MicroMsg.SnsCommentDetailUI", "onViewDetachedFromWindow infoHeader");
            this.AbW = true;
            AppMethodBeat.o(198328);
          }
        });
        this.AaN.a(this.AbH, (TimeLineObject)localObject6, localp.dYK(), hashCode(), this.oIb, -1, localp.QM(32), false, com.tencent.mm.storage.bj.ILU, (List)localObject1, localp.getSnsId());
        for (;;)
        {
          localObject5 = (TextView)this.Aay.findViewById(2131296531);
          if (!localp.vx()) {
            break label10597;
          }
          localObject3 = f(localp);
          if (localObject3 == null) {
            break label10587;
          }
          localObject1 = ((com.tencent.mm.plugin.sns.storage.a)localObject3).zuH;
          localObject3 = ((com.tencent.mm.plugin.sns.storage.a)localObject3).zuI;
          ((TextView)localObject5).setTag(localp.dYK());
          if (bt.isNullOrNil((String)localObject1)) {
            break label10587;
          }
          if (!bt.isNullOrNil((String)localObject3)) {
            break label10539;
          }
          ((TextView)localObject5).setVisibility(0);
          ((TextView)localObject5).setText((CharSequence)localObject1);
          ((TextView)localObject5).setClickable(false);
          ((TextView)localObject5).setTextColor(getContext().getResources().getColor(2131100212));
          this.Aay.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(198331);
              SnsCommentDetailUI.f(SnsCommentDetailUI.this).rj(false);
              AppMethodBeat.o(198331);
            }
          });
          ((TextView)localObject5).setOnClickListener(this.zaU.AyO);
          ((TextView)this.Aay.findViewById(2131296598)).setText(bj.q(getContext(), localp.getCreateTime() * 1000L));
          localObject5 = (AsyncTextView)this.Aay.findViewById(2131296528);
          ((TextView)localObject5).setOnClickListener(this.zaU.AyS);
          ((TextView)localObject5).setVisibility(8);
          localObject8 = (AsyncTextView)this.Aay.findViewById(2131296527);
          ((TextView)localObject8).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(98570);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
              paramAnonymousView = new SnsAdClick(SnsCommentDetailUI.this.getSource(), 2, localp.field_snsId, 24, 0);
              com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, SnsCommentDetailUI.f(SnsCommentDetailUI.this), localp, 24);
              com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
              localObject = this.fSV.adv();
              paramAnonymousView = (View)localObject;
              if (localp.QM(32)) {
                paramAnonymousView = com.tencent.mm.plugin.sns.ui.widget.e.b(localp.dRL(), (String)localObject);
              }
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentFlag(1);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentHint(paramAnonymousView);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).rQ(true);
              SnsCommentDetailUI.H(SnsCommentDetailUI.this).setVisibility(8);
              SnsCommentDetailUI.C(SnsCommentDetailUI.this);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(98570);
            }
          });
          ((TextView)localObject8).setVisibility(8);
          if (localp.vx())
          {
            localObject7 = f(localp);
            ((TextView)localObject5).setTag(localp.dYK());
            if (((com.tencent.mm.plugin.sns.storage.a)localObject7).zuJ != com.tencent.mm.plugin.sns.storage.a.zuv) {
              break label10825;
            }
            if (bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject7).zuK)) {
              break label10815;
            }
            ((TextView)localObject5).setText(((com.tencent.mm.plugin.sns.storage.a)localObject7).zuK);
            ((TextView)localObject5).setVisibility(0);
            break label11113;
            if ((((TextView)localObject5).getVisibility() != 8) && (bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject7).zuL)))
            {
              ((TextView)localObject5).setTextColor(getResources().getColor(2131100943));
              ((TextView)localObject5).setOnClickListener(null);
            }
            if ((localp.dYl().HAT.GaR & 0x4) == 0) {
              break label11282;
            }
            ((TextView)localObject8).setTag(localp.dYK());
            ((TextView)localObject8).setVisibility(0);
            ((TextView)localObject8).setText(String.format("%s%s%s", new Object[] { getContext().getResources().getString(2131763743), localObject4, getContext().getResources().getString(2131763744) }));
          }
          localObject1 = (WeImageView)this.Aay.findViewById(2131296627);
          if (((TimeLineObject)localObject6).HAT.GaP != 30) {
            break label11292;
          }
          i = 0;
          ((WeImageView)localObject1).setVisibility(i);
          ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099660));
          localObject4 = (TextView)this.Aay.findViewById(2131296569);
          ((TextView)localObject4).setOnTouchListener(new ae());
          localObject1 = com.tencent.mm.plugin.sns.c.a.iRH.r(this, ((TimeLineObject)localObject6).HAS.Id);
          if (((TimeLineObject)localObject6).HAT.GaP != 26) {
            break label11299;
          }
          localObject1 = getString(2131758845);
          label3070:
          bh.a((TimeLineObject)localObject6, this);
          if (!com.tencent.mm.plugin.sns.c.a.iRH.fx((String)localObject1)) {
            break label11547;
          }
          ((TextView)localObject4).setVisibility(0);
          localObject1 = new SpannableString(getString(2131763791) + (String)localObject1);
          ((SpannableString)localObject1).setSpan(new a(), 0, ((SpannableString)localObject1).length(), 33);
          ((TextView)localObject4).setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
          if ((((TimeLineObject)localObject6).HAS == null) || (!com.tencent.mm.pluginsdk.model.app.h.aLF(((TimeLineObject)localObject6).HAS.Id)))
          {
            ((TextView)localObject4).setTextColor(getResources().getColor(2131100943));
            ((TextView)localObject4).setOnTouchListener(null);
          }
          ((TextView)localObject4).setTag(localObject6);
          if (((TimeLineObject)localObject6).HAT.GaP == 28)
          {
            ((TextView)localObject4).setTextColor(getResources().getColor(2131100914));
            ((TextView)localObject4).setOnTouchListener(null);
            if (this.Aay != null)
            {
              localObject1 = (Guideline)this.Aay.findViewById(2131308428);
              if (localObject1 != null) {
                ((Guideline)localObject1).setGuidelineEnd(0);
              }
            }
            ((TextView)localObject4).setTag(localObject6);
            ((TextView)localObject4).setOnClickListener(new SnsCommentDetailUI.31(this, (TimeLineObject)localObject6));
          }
          localObject1 = (TextView)this.Aay.findViewById(2131296566);
          if (!localp.getUserName().equals(this.fFK)) {
            break label11557;
          }
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setTag(localp.dYK() + ";" + localp.getSnsId());
          ((TextView)localObject1).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(98572);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              com.tencent.mm.ui.base.h.a(SnsCommentDetailUI.this, 2131764024, 2131755906, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(198332);
                  ad.d("MicroMsg.SnsCommentDetailUI", "to del by localId " + SnsCommentDetailUI.k(SnsCommentDetailUI.this));
                  paramAnonymous2DialogInterface = com.tencent.mm.plugin.sns.storage.h.aAa(SnsCommentDetailUI.k(SnsCommentDetailUI.this));
                  if (paramAnonymous2DialogInterface == null)
                  {
                    ad.e("MicroMsg.SnsCommentDetailUI", "try to del item fail can not get snsinfo by localid %s", new Object[] { SnsCommentDetailUI.k(SnsCommentDetailUI.this) });
                    AppMethodBeat.o(198332);
                    return;
                  }
                  if (paramAnonymous2DialogInterface.QM(32))
                  {
                    AppMethodBeat.o(198332);
                    return;
                  }
                  Object localObject;
                  if (paramAnonymous2DialogInterface.field_snsId == 0L)
                  {
                    com.tencent.mm.plugin.sns.model.ag.dUe().QQ(paramAnonymous2DialogInterface.zMC);
                    localObject = new Intent();
                    ((Intent)localObject).putExtra("sns_gallery_op_id", x.aAw(SnsCommentDetailUI.k(SnsCommentDetailUI.this)));
                    SnsCommentDetailUI.this.setResult(-1, (Intent)localObject);
                    if ((SnsCommentDetailUI.w(SnsCommentDetailUI.this)) && (!paramAnonymous2DialogInterface.isValid())) {
                      ((Intent)localObject).putExtra("sns_gallery_force_finish", true);
                    }
                    localObject = paramAnonymous2DialogInterface.dYl();
                    if (localObject != null) {
                      if (((TimeLineObject)localObject).HAS != null) {
                        break label368;
                      }
                    }
                  }
                  label368:
                  for (paramAnonymous2DialogInterface = null;; paramAnonymous2DialogInterface = ((TimeLineObject)localObject).HAS.Id)
                  {
                    if ((!bt.isNullOrNil(paramAnonymous2DialogInterface)) && (com.tencent.mm.plugin.sns.c.a.iRH.fy(paramAnonymous2DialogInterface)))
                    {
                      String str = com.tencent.mm.plugin.sns.c.a.iRH.fw(paramAnonymous2DialogInterface);
                      rb localrb = new rb();
                      localrb.dFC.appId = paramAnonymous2DialogInterface;
                      localrb.dFC.dFE = ((TimeLineObject)localObject).nDo;
                      localrb.dFC.dFD = str;
                      com.tencent.mm.sdk.b.a.IbL.l(localrb);
                    }
                    SnsCommentDetailUI.this.finish();
                    AppMethodBeat.o(198332);
                    return;
                    com.tencent.mm.plugin.sns.model.ag.dUd().zN(paramAnonymous2DialogInterface.field_snsId);
                    com.tencent.mm.kernel.g.ajD();
                    com.tencent.mm.kernel.g.ajB().gAO.a(new com.tencent.mm.plugin.sns.model.q(paramAnonymous2DialogInterface.field_snsId, 1), 0);
                    com.tencent.mm.plugin.sns.model.ag.dUe().delete(paramAnonymous2DialogInterface.field_snsId);
                    com.tencent.mm.plugin.sns.model.ag.dUj().Ad(paramAnonymous2DialogInterface.field_snsId);
                    com.tencent.mm.plugin.sns.storage.i.Ac(paramAnonymous2DialogInterface.field_snsId);
                    break;
                  }
                }
              }, null);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(98572);
            }
          });
          localObject4 = (TextView)this.Aay.findViewById(2131306999);
          localObject5 = ak.u(localp);
          if (localObject5 != null) {
            break label11567;
          }
          ((TextView)localObject4).setVisibility(8);
          label3420:
          this.AaG = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
          this.AaG.setDuration(150L);
          this.AaH = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
          this.AaH.setDuration(150L);
          if (this.AaD == null)
          {
            this.AaD = this.Aay.findViewById(2131296548);
            this.AaD.setVisibility(8);
          }
          this.AaI = ((LinearLayout)this.Aay.findViewById(2131296555));
          this.AaI.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(163113);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              if (!com.tencent.mm.plugin.sns.lucky.a.m.ayt(localp.dYK()))
              {
                com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.AbH.Ra(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(163113);
                return;
              }
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentInfo(null);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentFlag(0);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentHint(SnsCommentDetailUI.this.getString(2131764046));
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setCommentInfo(new dfn());
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setToSendTextColor(true);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).rQ(true);
              if ((localp.QM(32)) && ((localp.dYl().HAT.GaR & 0x8) != 0)) {
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).mq(true);
              }
              for (;;)
              {
                SnsCommentDetailUI.H(SnsCommentDetailUI.this).setVisibility(8);
                SnsCommentDetailUI.C(SnsCommentDetailUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(163113);
                return;
                SnsCommentDetailUI.c(SnsCommentDetailUI.this).mq(false);
              }
            }
          });
          this.AaI.setOnTouchListener(this.zQU);
          this.AaJ = ((LinearLayout)this.Aay.findViewById(2131296586));
          this.AaJ.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(198333);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
              if ((SnsCommentDetailUI.f(SnsCommentDetailUI.this) != null) && (localp.field_likeFlag == 0)) {
                SnsCommentDetailUI.f(SnsCommentDetailUI.this).zn(localp.field_snsId);
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
              com.tencent.mm.plugin.sns.j.e.ztz.dVJ().ejw = 3L;
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(198333);
            }
          });
          this.AaJ.setOnTouchListener(this.zQU);
          localObject1 = (ImageButton)this.Aay.findViewById(2131296599);
          localObject3 = rP(true);
          if ((localObject3 != null) && ((((com.tencent.mm.plugin.sns.storage.p)localObject3).dYF() & 0x1) != 0)) {
            ((ImageButton)localObject1).setVisibility(8);
          }
          if ((localObject3 != null) && (!((com.tencent.mm.plugin.sns.storage.p)localObject3).dYJ())) {
            ((ImageButton)localObject1).setVisibility(8);
          }
          localObject3 = (ImageView)this.AaJ.findViewById(2131296585);
          localObject4 = (ImageView)this.AaI.findViewById(2131296554);
          localObject5 = (TextView)this.AaJ.findViewById(2131296587);
          localObject6 = (TextView)this.AaI.findViewById(2131296563);
          if (this.oIb == 10)
          {
            this.Aay.findViewById(2131296548).setBackgroundResource(2131232447);
            ((ImageButton)localObject1).setImageResource(2131232932);
            ((ImageView)localObject3).setImageResource(2131232933);
            ((ImageView)localObject4).setImageResource(2131232934);
            ((TextView)localObject5).setTextColor(getResources().getColor(2131100920));
            ((TextView)localObject6).setTextColor(getResources().getColor(2131100920));
            this.AaJ.setBackgroundResource(2131233161);
            this.AaI.setBackgroundResource(2131233162);
          }
          ((ImageButton)localObject1).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(198334);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              ad.d("MicroMsg.SnsCommentDetailUI", "showComment click" + SnsCommentDetailUI.H(SnsCommentDetailUI.this).getVisibility());
              com.tencent.mm.plugin.sns.ad.e.g.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a(localp, true, paramAnonymousView, SnsCommentDetailUI.f(SnsCommentDetailUI.this)));
              paramAnonymousView = localp.dYl();
              if ((paramAnonymousView != null) && (paramAnonymousView.HAT.GaP == 21) && (!com.tencent.mm.plugin.sns.lucky.a.m.ayt(localp.dYK())))
              {
                com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.AbH.Ra(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198334);
                return;
              }
              if (SnsCommentDetailUI.H(SnsCommentDetailUI.this).getVisibility() == 0) {
                SnsCommentDetailUI.g(SnsCommentDetailUI.this);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198334);
                return;
                SnsCommentDetailUI.H(SnsCommentDetailUI.this).setVisibility(0);
                SnsCommentDetailUI.H(SnsCommentDetailUI.this).startAnimation(SnsCommentDetailUI.J(SnsCommentDetailUI.this));
                if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10) {
                  SnsCommentDetailUI.z(SnsCommentDetailUI.this).findViewById(2131296548).setBackgroundResource(2131232447);
                }
                if (!x.aAx(SnsCommentDetailUI.o(SnsCommentDetailUI.this)))
                {
                  SnsCommentDetailUI.this.AaI.setEnabled(false);
                  SnsCommentDetailUI.this.AaJ.setEnabled(false);
                  this.Aca.setText(SnsCommentDetailUI.this.getString(2131763882));
                  this.Aca.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131100911));
                  this.Acb.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131100911));
                  if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10) {
                    this.Acc.setImageResource(2131690238);
                  } else {
                    this.Acc.setImageResource(2131690241);
                  }
                }
                else
                {
                  SnsCommentDetailUI.this.AaI.setEnabled(true);
                  this.Acc.setImageResource(2131232452);
                  SnsCommentDetailUI.this.AaJ.setEnabled(true);
                  this.Aca.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101182));
                  this.Acb.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101182));
                  paramAnonymousView = com.tencent.mm.plugin.sns.storage.h.azZ(SnsCommentDetailUI.o(SnsCommentDetailUI.this));
                  if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10)
                  {
                    this.Acc.setImageResource(2131232933);
                    this.Acd.setImageResource(2131232934);
                    this.Aca.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131100920));
                    this.Acb.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131100920));
                  }
                  for (;;)
                  {
                    if ((paramAnonymousView == null) || (paramAnonymousView.field_likeFlag != 0)) {
                      break label616;
                    }
                    this.Aca.setText(SnsCommentDetailUI.this.getString(2131763882));
                    break;
                    this.Acc.setImageResource(2131232452);
                    this.Aca.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101182));
                    this.Acb.setTextColor(SnsCommentDetailUI.this.getResources().getColor(2131101182));
                  }
                  label616:
                  this.Aca.setText(SnsCommentDetailUI.this.getString(2131763839));
                }
              }
            }
          });
          AppMethodBeat.o(98604);
          return true;
          if (((com.tencent.mm.plugin.sns.storage.b)localObject3).zvX == 1)
          {
            i = k - com.tencent.mm.cc.a.ax(this, 2131166827) - com.tencent.mm.cc.a.ax(this, 2131166827) - com.tencent.mm.cc.a.ax(this, 2131165575) - com.tencent.mm.cc.a.ax(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
            j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject3).zvZ / ((com.tencent.mm.plugin.sns.storage.b)localObject3).zvY);
            localObject5 = new byp();
            if (i > 0) {
              f2 = i;
            }
            ((byp)localObject5).GTz = f2;
            if (j > 0) {
              f1 = j;
            }
            ((byp)localObject5).GTA = f1;
            ((byp)localObject5).GTB = (((byp)localObject5).GTz * ((byp)localObject5).GTA);
            ((LinkedList)localObject1).add(localObject5);
            break;
          }
          if (((com.tencent.mm.plugin.sns.storage.b)localObject3).zvX != 2) {
            break;
          }
          i = k - com.tencent.mm.cc.a.ax(this, 2131166827) - com.tencent.mm.cc.a.ax(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
          j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject3).zvZ / ((com.tencent.mm.plugin.sns.storage.b)localObject3).zvY);
          localObject5 = new byp();
          if (i > 0) {
            f2 = i;
          }
          ((byp)localObject5).GTz = f2;
          if (j > 0) {
            f1 = j;
          }
          ((byp)localObject5).GTA = f1;
          ((byp)localObject5).GTB = (((byp)localObject5).GTz * ((byp)localObject5).GTA);
          ((LinkedList)localObject1).add(localObject5);
          break;
          ad.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.oIb + ",stub is " + ((ViewStub)localObject1).toString());
          continue;
          label4181:
          if (this.oIb != 10) {
            break label4638;
          }
          this.AbH = ((PhotosContent)findViewById(2131300686));
          this.AbH.eaI();
          localObject1 = (TagImageView)this.AbH.findViewById(2131296575);
          this.AbH.a((TagImageView)localObject1);
          ((TagImageView)localObject1).setOnClickListener(this.zaU.zRv);
          localObject3 = localp.dYK();
          localObject5 = new ArrayList();
          ((List)localObject5).add(localObject1);
          localObject8 = new az();
          ((az)localObject8).drH = ((String)localObject3);
          ((az)localObject8).index = 0;
          ((az)localObject8).Ady = ((List)localObject5);
          ((az)localObject8).Aae = true;
          if (localObject1 != null) {
            ((TagImageView)localObject1).setTag(localObject8);
          }
          localObject1 = (TextView)this.Aay.findViewById(2131300687);
          if (!u.aAm().equals(((TimeLineObject)localObject6).nDo))
          {
            localObject3 = ak.v(localp);
            if ((((SnsObject)localObject3).SnsRedEnvelops != null) && (((SnsObject)localObject3).SnsRedEnvelops.HuQ != 0))
            {
              ((TextView)localObject1).setText(getString(2131760986, new Object[] { Integer.valueOf(((SnsObject)localObject3).SnsRedEnvelops.HuQ) }));
              ((TextView)localObject1).setVisibility(0);
            }
          }
          for (;;)
          {
            localObject1 = localp.dYD();
            if (localObject1 == null) {
              break label4608;
            }
            if (!u.aAm().equals(((TimeLineObject)localObject6).nDo)) {
              break label4492;
            }
            this.AaN.a(this.AbH, (TimeLineObject)localObject6, localp.dYK(), hashCode(), this.oIb, -1, false, com.tencent.mm.storage.bj.ILU, true);
            break;
            ((TextView)localObject1).setVisibility(8);
            continue;
            ((TextView)localObject1).setVisibility(8);
          }
          if (com.tencent.mm.plugin.sns.lucky.a.m.p(localp))
          {
            this.AaN.a(this.AbH, (TimeLineObject)localObject6, localp.dYK(), hashCode(), this.oIb, -1, false, com.tencent.mm.storage.bj.ILU, false);
          }
          else if (((byo)localObject1).dNN == 0)
          {
            this.AaN.a(this.AbH, (TimeLineObject)localObject6, localp.dYK(), hashCode(), this.oIb, -1, false, com.tencent.mm.storage.bj.ILU, true);
          }
          else
          {
            ad.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo.hbStatus is " + ((byo)localObject1).dNN);
            continue;
            ad.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo is null " + localp.dYK());
          }
        }
        Object localObject10;
        Object localObject9;
        Object localObject11;
        if ((this.oIb == 9) || (this.oIb == 19))
        {
          this.Abh = true;
          localObject3 = new aq();
          localObject10 = this.Aay;
          localObject5 = ((View)localObject10).findViewById(2131298069);
          localObject8 = (VideoSightView)((View)localObject10).findViewById(2131300914);
          localObject9 = (SnsAdTimelineVideoView)((View)localObject10).findViewById(2131308163);
          ((aq)localObject3).zWx = ((View)localObject10);
          ((aq)localObject3).zWA = ((View)localObject5);
          ((aq)localObject3).zFD = ((ImageView)((View)localObject10).findViewById(2131305196));
          ((aq)localObject3).zWB = ((MMPinProgressBtn)((View)localObject10).findViewById(2131303515));
          ((aq)localObject3).zFE = ((TextView)((View)localObject10).findViewById(2131299517));
          ((aq)localObject3).zWC = ((TextView)((View)localObject10).findViewById(2131299492));
          ((aq)localObject3).zWy = ((VideoSightView)localObject8);
          ((aq)localObject3).zWy.setMute(true);
          ((aq)localObject3).a((TimeLineObject)localObject6, 0, localp.dYK(), localp.vx());
          ((aq)localObject3).zFE.setVisibility(8);
          ((aq)localObject3).zWy.setTagObject(localObject3);
          ((aq)localObject3).zWy.setIsAdVideo(localp.vx());
          ((aq)localObject3).zWD = 5;
          ((aq)localObject3).zWz = ((SnsAdTimelineVideoView)localObject9);
          com.tencent.mm.plugin.sns.ad.timeline.a.c.a((SnsAdTimelineVideoView)localObject9);
          ((View)localObject5).setTag(localObject3);
          ((aq)localObject3).zWA.setOnClickListener(this.zaU.AyP);
          if (!localp.dVZ())
          {
            this.nZK.c((View)localObject5, this.zaU.AyG, this.zaU.Ayq);
            if ((!localp.vx()) || (!com.tencent.mm.plugin.sns.data.j.d((TimeLineObject)localObject6))) {
              break label5794;
            }
            localObject1 = com.tencent.mm.modelsns.h.a((TimeLineObject)localObject6, ((aq)localObject3).zWy.getUIContext(), false);
            ad.i("MicroMsg.SnsCommentDetailUI", "isVerticalAdVideo=true, snsId=" + localp.field_snsId + ", showW=" + ((Pair)localObject1).first + ", showH=" + ((Pair)localObject1).second);
            i = 1;
            if (!localp.vx()) {
              break label12082;
            }
            localObject11 = localp.dRL();
            if ((localObject11 == null) || (!((com.tencent.mm.plugin.sns.storage.b)localObject11).dVZ()) || (((com.tencent.mm.plugin.sns.storage.b)localObject11).zvY <= 0.0F) || (((com.tencent.mm.plugin.sns.storage.b)localObject11).zvZ <= 0.0F)) {
              break label12082;
            }
            f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject11).zvY, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject11).zwa, ((com.tencent.mm.plugin.sns.storage.b)localObject11).zwb);
            f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject11).zvZ, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject11).zwa, ((com.tencent.mm.plugin.sns.storage.b)localObject11).zwb);
            if (((com.tencent.mm.plugin.sns.storage.b)localObject11).zvX != 0) {
              break label5820;
            }
            if (f1 < k - com.tencent.mm.cc.a.ax(this, 2131166827) - com.tencent.mm.cc.a.ax(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516)) {
              break label12085;
            }
            f1 = k - com.tencent.mm.cc.a.ax(this, 2131166827) - com.tencent.mm.cc.a.ax(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
            f2 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject11).zvZ * f1 / ((com.tencent.mm.plugin.sns.storage.b)localObject11).zvY);
          }
        }
        for (;;)
        {
          localObject1 = Pair.create(Integer.valueOf((int)f1), Integer.valueOf((int)f2));
          for (;;)
          {
            label5235:
            if (localObject1 != null)
            {
              if ((((aq)localObject3).zWy instanceof SightPlayImageView))
              {
                if (!localp.vx())
                {
                  ((aq)localObject3).zWy.setScaleMode(1);
                  ((aq)localObject3).zWy.setScaleType(QImageView.a.KTb);
                }
              }
              else
              {
                ((VideoSightView)localObject8).hw(((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue());
                if ((((aq)localObject3).zWy instanceof SightPlayImageView))
                {
                  if (i == 0) {
                    break label6053;
                  }
                  ((aq)localObject3).zWy.dQo();
                }
                localObject11 = ((aq)localObject3).zWC.getLayoutParams();
                ((ViewGroup.LayoutParams)localObject11).width = ((Integer)((Pair)localObject1).first).intValue();
                ((ViewGroup.LayoutParams)localObject11).height = ((Integer)((Pair)localObject1).second).intValue();
                ((aq)localObject3).zWC.setLayoutParams((ViewGroup.LayoutParams)localObject11);
                localObject10 = (FrameLayout)((View)localObject10).findViewById(2131305105);
                localObject11 = (FrameLayout.LayoutParams)((FrameLayout)localObject10).getLayoutParams();
                ((FrameLayout.LayoutParams)localObject11).width = ((Integer)((Pair)localObject1).first).intValue();
                ((FrameLayout.LayoutParams)localObject11).height = ((Integer)((Pair)localObject1).second).intValue();
                ((FrameLayout)localObject10).setLayoutParams((ViewGroup.LayoutParams)localObject11);
                com.tencent.mm.plugin.sns.ad.timeline.a.c.a((SnsAdTimelineVideoView)localObject9, ((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue());
              }
            }
            else
            {
              if ((((TimeLineObject)localObject6).HAT == null) || (((TimeLineObject)localObject6).HAT.GaQ.size() <= 0)) {
                break label6065;
              }
              localObject1 = (byn)((TimeLineObject)localObject6).HAT.GaQ.get(0);
              if (localp.vx())
              {
                ((aq)localObject3).zWy.setOnCompletionListener(new b.e()
                {
                  public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(198329);
                    if (paramAnonymousInt != -1)
                    {
                      if (SnsCommentDetailUI.f(SnsCommentDetailUI.this) == null)
                      {
                        AppMethodBeat.o(198329);
                        return;
                      }
                      SnsCommentDetailUI.f(SnsCommentDetailUI.this).A(localp.field_snsId, false);
                    }
                    AppMethodBeat.o(198329);
                  }
                });
                ((aq)localObject3).zWy.setOnDecodeDurationListener(new b.f()
                {
                  public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
                  {
                    AppMethodBeat.i(198330);
                    ad.d("MicroMsg.SnsCommentDetailUI", "onDecodeProgress:".concat(String.valueOf(paramAnonymousLong)));
                    if ((SnsCommentDetailUI.f(SnsCommentDetailUI.this) != null) && (localp != null))
                    {
                      SnsCommentDetailUI.f(SnsCommentDetailUI.this).zp(localp.field_snsId);
                      SnsCommentDetailUI.f(SnsCommentDetailUI.this).ak(localp.field_snsId, 1000L * paramAnonymousLong);
                      if (!SnsCommentDetailUI.f(SnsCommentDetailUI.this).zm(localp.field_snsId))
                      {
                        int i = (int)paramAnonymousb.dQg();
                        ad.i("MicroMsg.SnsCommentDetailUI", "updatePlayStartTime, duration=".concat(String.valueOf(i)));
                        SnsCommentDetailUI.f(SnsCommentDetailUI.this).d(localp.field_snsId, bt.HI(), false);
                        SnsCommentDetailUI.f(SnsCommentDetailUI.this).e(localp.field_snsId, i, false);
                        SnsCommentDetailUI.f(SnsCommentDetailUI.this).aj(localp.field_snsId, localp.field_snsId);
                      }
                    }
                    AppMethodBeat.o(198330);
                  }
                });
                if (a(localp, (SnsAdTimelineVideoView)localObject9)) {
                  ((SnsAdTimelineVideoView)localObject9).setVideoCallback(new c(localp, (SnsAdTimelineVideoView)localObject9));
                }
              }
              if ((((TimeLineObject)localObject6).HAT == null) || (((TimeLineObject)localObject6).HAT.GaQ.size() <= 0)) {
                break;
              }
              com.tencent.mm.plugin.sns.model.ag.dUb();
              if (com.tencent.mm.plugin.sns.model.f.t((byn)localObject1)) {
                break label6174;
              }
              if (!com.tencent.mm.plugin.sns.model.ag.dUb().w((byn)localObject1)) {
                break label6071;
              }
              ((aq)localObject3).zFD.setVisibility(8);
              ((aq)localObject3).zWB.setVisibility(0);
              ((aq)localObject3).zWB.fLr();
              ((VideoSightView)localObject8).setTagObject(localObject3);
              if (!a(localp, (SnsAdTimelineVideoView)localObject9)) {
                break label6477;
              }
              ((SnsAdTimelineVideoView)localObject9).setTag(localObject3);
              ((VideoSightView)localObject8).setVisibility(8);
              com.tencent.mm.plugin.sns.ad.timeline.a.c.a((SnsAdTimelineVideoView)localObject9, true);
              com.tencent.mm.plugin.sns.ad.timeline.a.c.a((SnsAdTimelineVideoView)localObject9, com.tencent.mm.plugin.sns.model.ag.dUb(), localp, this, (byn)localObject1, 0, com.tencent.mm.storage.bj.ILU);
              com.tencent.mm.plugin.sns.ad.timeline.a.c.b((SnsAdTimelineVideoView)localObject9);
              ((View)localObject5).setTag(localObject3);
              if (this.Abd == null) {
                break;
              }
              if (!localp.vx()) {
                break label6518;
              }
              if (com.tencent.mm.plugin.sns.model.ag.dUb().t(localp) != 5) {
                break label6512;
              }
              bool = true;
            }
            for (;;)
            {
              label5330:
              this.Abd.C(localp.field_snsId, bool);
              label5714:
              break;
              this.nZK.c((View)localObject5, this.zaU.AyI, this.zaU.Ayq);
              break label4928;
              localObject1 = com.tencent.mm.modelsns.h.a((TimeLineObject)localObject6, ((aq)localObject3).zWy.getUIContext(), localp.vx());
              i = 0;
              break label5018;
              if (((com.tencent.mm.plugin.sns.storage.b)localObject11).zvX == 1)
              {
                j = k - com.tencent.mm.cc.a.ax(this, 2131166827) - com.tencent.mm.cc.a.ax(this, 2131166827) - com.tencent.mm.cc.a.ax(this, 2131165575) - com.tencent.mm.cc.a.ax(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
                localObject1 = Pair.create(Integer.valueOf(j), Integer.valueOf((int)(j * ((com.tencent.mm.plugin.sns.storage.b)localObject11).zvZ / ((com.tencent.mm.plugin.sns.storage.b)localObject11).zvY)));
                break label5235;
              }
              if (((com.tencent.mm.plugin.sns.storage.b)localObject11).zvX != 2) {
                break label12082;
              }
              j = k - com.tencent.mm.cc.a.ax(this, 2131166827) - com.tencent.mm.cc.a.ax(this, 2131165575) - getResources().getDimensionPixelSize(2131165516) - getResources().getDimensionPixelSize(2131165516);
              localObject1 = Pair.create(Integer.valueOf(j), Integer.valueOf((int)(j * ((com.tencent.mm.plugin.sns.storage.b)localObject11).zvZ / ((com.tencent.mm.plugin.sns.storage.b)localObject11).zvY)));
              break label5235;
              if (i != 0)
              {
                ((aq)localObject3).zWy.setScaleMode(1);
                ((aq)localObject3).zWy.setScaleType(QImageView.a.KTb);
                break label5279;
              }
              ((aq)localObject3).zWy.setScaleMode(0);
              ((aq)localObject3).zWy.setScaleType(QImageView.a.KSW);
              break label5279;
              ((aq)localObject3).zWy.setDrawWidthAndHeightFix(false);
              break label5330;
              localObject1 = null;
              break label5510;
              if ((localp.vx()) && (com.tencent.mm.plugin.sns.model.ag.dUb().t(localp) == 5))
              {
                com.tencent.mm.plugin.sns.model.ag.dUb().A((byn)localObject1);
                ((aq)localObject3).zFD.setVisibility(8);
                ((aq)localObject3).zWB.setVisibility(0);
                ((aq)localObject3).zWB.fLr();
                break label5654;
              }
              com.tencent.mm.plugin.sns.model.ag.dUb().y((byn)localObject1);
              ((aq)localObject3).zFD.setVisibility(0);
              ((aq)localObject3).zWB.setVisibility(8);
              ((aq)localObject3).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this, 2131691166));
              break label5654;
              if (com.tencent.mm.plugin.sns.model.ag.dUb().u((byn)localObject1))
              {
                ((aq)localObject3).zFD.setVisibility(0);
                ((aq)localObject3).zWB.setVisibility(8);
                ((aq)localObject3).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this, 2131691166));
                if (!a(localp, (SnsAdTimelineVideoView)localObject9)) {
                  break label6464;
                }
              }
              for (bool = ((SnsAdTimelineVideoView)localObject9).isError();; bool = ((aq)localObject3).zWy.dQp())
              {
                if (!bool) {
                  break label6475;
                }
                ad.d("MicroMsg.SnsCommentDetailUI", "play video error " + ((byn)localObject1).Id + " " + ((byn)localObject1).Url + " " + ((byn)localObject1).GSI);
                com.tencent.mm.plugin.sns.model.ag.dUb().y((byn)localObject1);
                ((aq)localObject3).zFD.setVisibility(0);
                ((aq)localObject3).zWB.setVisibility(8);
                ((aq)localObject3).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this, 2131691166));
                break;
                if (com.tencent.mm.plugin.sns.model.ag.dUb().v((byn)localObject1))
                {
                  ((aq)localObject3).zFD.setVisibility(8);
                  ((aq)localObject3).zWB.setVisibility(8);
                  break label6219;
                }
                if ((localp.vx()) && (com.tencent.mm.plugin.sns.model.ag.dUb().t(localp) <= 5))
                {
                  ((aq)localObject3).zFD.setVisibility(8);
                  ((aq)localObject3).zWB.setVisibility(8);
                  break label6219;
                }
                com.tencent.mm.plugin.sns.model.ag.dUb().y((byn)localObject1);
                ((aq)localObject3).zFD.setVisibility(0);
                ((aq)localObject3).zWB.setVisibility(8);
                ((aq)localObject3).zFD.setImageDrawable(com.tencent.mm.cc.a.l(this, 2131691166));
                break label6219;
              }
              break label5654;
              label6477:
              com.tencent.mm.plugin.sns.model.ag.dUb().a(localp, (byn)localObject1, (VideoSightView)localObject8, hashCode(), 0, com.tencent.mm.storage.bj.ILU, localp.vx());
              ((VideoSightView)localObject8).start();
              break label5714;
              label6512:
              bool = false;
              continue;
              label6518:
              if (com.tencent.mm.plugin.sns.model.ag.dUb().s(localp) == 5) {
                bool = true;
              } else {
                bool = false;
              }
            }
            if (this.oIb == 0)
            {
              localObject1 = (LinearLayout)this.Aay.findViewById(2131305006);
              localObject3 = Re(2131495567);
              if (!this.AbE)
              {
                ((LinearLayout)localObject1).removeView(this.AbH);
                ((LinearLayout)localObject1).addView((View)localObject3, 3);
                if (((LinearLayout)localObject3).getLayoutParams() == null) {
                  break label6934;
                }
              }
              for (localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject3).getLayoutParams());; localObject1 = new LinearLayout.LayoutParams(-1, -2))
              {
                ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cc.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
                if (((TimeLineObject)localObject6).HAT.GaQ.isEmpty()) {
                  break label6949;
                }
                localObject5 = (byn)((TimeLineObject)localObject6).HAT.GaQ.get(0);
                localObject1 = (MMImageView)((LinearLayout)localObject3).findViewById(2131300948);
                com.tencent.mm.plugin.sns.model.ag.dUb().a((byn)localObject5, (View)localObject1, 2131689564, hashCode(), com.tencent.mm.storage.bj.ILU);
                this.AaR = ((ImageView)((LinearLayout)localObject3).findViewById(2131305185));
                this.AaR.setOnTouchListener(this.zQU);
                this.dzL = ((TimeLineObject)localObject6).Id;
                ebN();
                bool = getIntent().getBooleanExtra("SNS_FROM_MUSIC_ITEM", false);
                ((MMImageView)localObject1).setTag(new s((TimeLineObject)localObject6, this.AaO, bool));
                ((MMImageView)localObject1).setOnClickListener(this.AaW.Aqi);
                localObject8 = ((byn)localObject5).Desc;
                if (!bt.isNullOrNil((String)localObject8)) {
                  ((TextView)((LinearLayout)localObject3).findViewById(2131304202)).setText((CharSequence)localObject8);
                }
                localObject5 = ((byn)localObject5).Title;
                if (!bt.isNullOrNil((String)localObject5)) {
                  ((TextView)((LinearLayout)localObject3).findViewById(2131305950)).setText(new SpannableString((CharSequence)localObject5), TextView.BufferType.SPANNABLE);
                }
                ((LinearLayout)localObject3).setTag(new s((TimeLineObject)localObject6, this.AaO));
                this.nZK.c((View)localObject3, this.zaU.AyF, this.zaU.Ayq);
                ((LinearLayout)localObject3).setOnClickListener(this.AaW.Ahy);
                com.tencent.mm.plugin.sns.data.q.b((View)localObject1, this);
                break;
              }
              ((LinearLayout)localObject3).setVisibility(8);
              break;
            }
            if (this.oIb == 13)
            {
              this.Aaz.setVisibility(8);
              this.AaE.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
              break;
            }
            if ((this.oIb == 11) || (this.oIb == 14) || (this.oIb == 15)) {
              break;
            }
            if (this.oIb == 16)
            {
              localObject1 = (LinearLayout)this.Aay.findViewById(2131305006);
              localObject5 = Re(2131495565);
              if (!this.AbE)
              {
                ((LinearLayout)localObject1).removeView(this.AbH);
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
                if (((TimeLineObject)localObject6).HAT.GaU == null) {
                  break label7603;
                }
                ad.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderShareObject not null");
                if ((!bt.isNullOrNil(((TimeLineObject)localObject6).HAT.GaU.nickname)) || (bt.isNullOrNil(((TimeLineObject)localObject6).HAT.GaU.desc))) {
                  break label7507;
                }
                localObject1 = ((TimeLineObject)localObject6).HAT.GaU.desc;
              }
              for (;;)
              {
                ((TextView)localObject9).setText(new SpannableString((CharSequence)localObject1), TextView.BufferType.SPANNABLE);
                ((TextView)localObject9).setMaxLines(2);
                if (!((TimeLineObject)localObject6).HAT.GaU.mediaList.isEmpty())
                {
                  localObject1 = new byn();
                  ((byn)localObject1).Url = ((ari)((TimeLineObject)localObject6).HAT.GaU.mediaList.get(0)).thumbUrl;
                  ((byn)localObject1).GSI = ((ari)((TimeLineObject)localObject6).HAT.GaU.mediaList.get(0)).thumbUrl;
                  ((byn)localObject1).nEf = 2;
                  ((byn)localObject1).GSJ = 1;
                  ((byn)localObject1).GSL = new byp();
                  ((byn)localObject1).GEe = 1;
                  ((byn)localObject1).GSL.GTz = ((ari)((TimeLineObject)localObject6).HAT.GaU.mediaList.get(0)).width;
                  ((byn)localObject1).GSL.GTA = ((ari)((TimeLineObject)localObject6).HAT.GaU.mediaList.get(0)).height;
                  ((byn)localObject1).Id = localp.getSnsId();
                  com.tencent.mm.plugin.sns.model.ag.dUb().b((byn)localObject1, (View)localObject8, hashCode(), com.tencent.mm.storage.bj.frn().aaU(((TimeLineObject)localObject6).CreateTime));
                }
                ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject6, this.AaO));
                ((LinearLayout)localObject5).setOnClickListener(this.AaW.Ahy);
                break;
                localObject1 = new LinearLayout.LayoutParams(-1, -2);
                break label7103;
                label7507:
                if (!bt.isNullOrNil(((TimeLineObject)localObject6).HAT.GaU.desc)) {
                  localObject1 = ((TimeLineObject)localObject6).HAT.GaU.nickname + ": " + ((TimeLineObject)localObject6).HAT.GaU.desc;
                } else {
                  localObject1 = getString(2131763973, new Object[] { ((TimeLineObject)localObject6).HAT.GaU.nickname });
                }
              }
              if (((TimeLineObject)localObject6).HAT.GaV == null) {
                break;
              }
              ad.i("MicroMsg.SnsCommentDetailUI", "tlObj.ContentObj.finderShareTopic not null");
              localObject3 = getString(2131755778);
              if (((TimeLineObject)localObject6).HAT.GaV != null) {
                if (((TimeLineObject)localObject6).HAT.GaV.sMj != 1) {
                  break label7927;
                }
              }
              label7927:
              for (localObject1 = "#" + ((TimeLineObject)localObject6).HAT.GaV.dzZ;; localObject1 = ((TimeLineObject)localObject6).HAT.GaV.dzZ)
              {
                localObject3 = localObject1;
                if (!bt.isNullOrNil(((TimeLineObject)localObject6).HAT.GaV.desc))
                {
                  localObject3 = (TextView)((LinearLayout)localObject5).findViewById(2131304202);
                  ((TextView)localObject3).setVisibility(0);
                  ((TextView)localObject3).setText(((TimeLineObject)localObject6).HAT.GaV.desc);
                  localObject3 = localObject1;
                }
                ((TextView)localObject9).setText(new SpannableString((CharSequence)localObject3), TextView.BufferType.SPANNABLE);
                ((TextView)localObject9).setMaxLines(2);
                localObject1 = new byn();
                ((byn)localObject1).Url = ((TimeLineObject)localObject6).HAT.GaV.iconUrl;
                ((byn)localObject1).GSI = ((TimeLineObject)localObject6).HAT.GaV.iconUrl;
                ((byn)localObject1).nEf = 2;
                ((byn)localObject1).GSJ = 1;
                ((byn)localObject1).GSL = new byp();
                ((byn)localObject1).GEe = 1;
                ((byn)localObject1).GSL.GTz = 0.0F;
                ((byn)localObject1).GSL.GTA = 0.0F;
                ((byn)localObject1).Id = localp.getSnsId();
                com.tencent.mm.plugin.sns.model.ag.dUb().b((byn)localObject1, (View)localObject8, hashCode(), com.tencent.mm.storage.bj.frn().aaU(((TimeLineObject)localObject6).CreateTime));
                ((LinearLayout)localObject5).setTag(new s((TimeLineObject)localObject6, this.AaO));
                ((LinearLayout)localObject5).setOnClickListener(this.AaW.Ahy);
                break;
              }
            }
            if (this.oIb == 17)
            {
              localObject1 = (LinearLayout)this.Aay.findViewById(2131305006);
              localObject3 = Re(2131495565);
              if (!this.AbE)
              {
                ((LinearLayout)localObject1).removeView(this.AbH);
                ((LinearLayout)localObject1).addView((View)localObject3, 3);
                if (((LinearLayout)localObject3).getLayoutParams() == null) {
                  break label8389;
                }
              }
              for (localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject3).getLayoutParams());; localObject1 = new LinearLayout.LayoutParams(-1, -2))
              {
                ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cc.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
                if (((TimeLineObject)localObject6).HAT.GaW == null) {
                  break label8404;
                }
                localObject1 = (MMImageView)((LinearLayout)localObject3).findViewById(2131300948);
                ((MMImageView)localObject1).setVisibility(0);
                localObject5 = new byn();
                ((byn)localObject5).Url = ((TimeLineObject)localObject6).HAT.GaW.hDm;
                ((byn)localObject5).GSI = ((TimeLineObject)localObject6).HAT.GaW.hDm;
                ((byn)localObject5).nEf = 2;
                ((byn)localObject5).GSJ = 1;
                ((byn)localObject5).GSL = new byp();
                ((byn)localObject5).GEe = 1;
                ((byn)localObject5).GSL.GTz = ((TimeLineObject)localObject6).HAT.GaW.width;
                ((byn)localObject5).GSL.GTA = ((TimeLineObject)localObject6).HAT.GaW.height;
                ((byn)localObject5).Id = localp.getSnsId();
                com.tencent.mm.plugin.sns.model.ag.dUb().b((byn)localObject5, (View)localObject1, hashCode(), com.tencent.mm.storage.bj.frn().aaU(((TimeLineObject)localObject6).CreateTime));
                localObject5 = (ImageView)((LinearLayout)localObject3).findViewById(2131305185);
                ((ImageView)localObject5).setVisibility(0);
                ((ImageView)localObject5).setImageDrawable(ao.k(((ImageView)localObject5).getContext(), 2131690672, -1));
                localObject5 = ((TimeLineObject)localObject6).HAT.GaW.title;
                if (!bt.isNullOrNil((String)localObject5))
                {
                  localObject8 = (TextView)((LinearLayout)localObject3).findViewById(2131305950);
                  ((TextView)localObject8).setMaxLines(2);
                  ((TextView)localObject8).setText(new SpannableString((CharSequence)localObject5), TextView.BufferType.SPANNABLE);
                }
                ((LinearLayout)localObject3).setTag(new ag((TimeLineObject)localObject6, (View)localObject1, localp.dYK()));
                ((LinearLayout)localObject3).setOnClickListener(this.AaW.ApX);
                this.nZK.c((View)localObject3, this.zaU.AyL, this.zaU.Ayq);
                com.tencent.mm.plugin.sns.data.q.b((View)localObject1, this);
                break;
              }
              label8404:
              ((LinearLayout)localObject3).setVisibility(8);
              break;
            }
            if (this.oIb == 18)
            {
              localObject1 = this.Aay.findViewById(2131308426);
              localObject3 = (ImageView)this.Aay.findViewById(2131308429);
              localObject5 = (ImageIndicatorView)this.Aay.findViewById(2131308427);
              localObject8 = (ImageView)this.Aay.findViewById(2131308430);
              if ((localObject6 == null) || (((TimeLineObject)localObject6).HAT == null) || (((TimeLineObject)localObject6).HAT.GaU == null)) {
                break;
              }
              localObject9 = ((TimeLineObject)localObject6).HAT.GaU;
              if (!bt.hj(((arj)localObject9).mediaList))
              {
                localObject10 = (ari)((arj)localObject9).mediaList.get(0);
                if (localObject10 != null)
                {
                  if (((arj)localObject9).Gpi != 4) {
                    break label8711;
                  }
                  localObject11 = com.tencent.mm.modelsns.h.a((int)((ari)localObject10).width, (int)((ari)localObject10).height, this, false);
                  i = ((Integer)((Pair)localObject11).first).intValue();
                  j = ((Integer)((Pair)localObject11).second).intValue();
                  ((View)localObject1).getLayoutParams().width = i;
                  ((View)localObject1).getLayoutParams().height = j;
                  ((View)localObject1).requestLayout();
                  ((t)com.tencent.mm.kernel.g.ad(t.class)).loadImage(((ari)localObject10).thumbUrl, (ImageView)localObject8);
                }
              }
              if (((arj)localObject9).Gpi == 4)
              {
                ((ImageView)localObject3).setVisibility(0);
                ((ImageIndicatorView)localObject5).setVisibility(8);
              }
              for (;;)
              {
                ((View)localObject1).setTag(localObject6);
                ((View)localObject1).setOnClickListener(this.AaW.ApZ);
                this.nZK.c((View)localObject1, this.zaU.AyM, this.zaU.Ayq);
                break;
                localObject11 = com.tencent.mm.modelsns.h.a((int)((ari)localObject10).width, (int)((ari)localObject10).height, this);
                i = ((Integer)((Pair)localObject11).first).intValue();
                j = ((Integer)((Pair)localObject11).second).intValue();
                ((View)localObject1).getLayoutParams().width = i;
                ((View)localObject1).getLayoutParams().height = j;
                ((View)localObject1).requestLayout();
                break label8623;
                ((ImageView)localObject3).setVisibility(8);
                ((ImageIndicatorView)localObject5).setVisibility(8);
                ((ImageIndicatorView)localObject5).RK(((arj)localObject9).dqU);
              }
            }
            localObject1 = (LinearLayout)this.Aay.findViewById(2131305006);
            localObject8 = Re(2131495565);
            localObject9 = (MMImageView)((LinearLayout)localObject8).findViewById(2131300948);
            if (!this.AbE)
            {
              ((LinearLayout)localObject1).removeView(this.AbH);
              ((LinearLayout)localObject1).addView((View)localObject8, 3);
              if (((LinearLayout)localObject8).getLayoutParams() != null)
              {
                localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject8).getLayoutParams());
                ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cc.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
                ((LinearLayout)localObject8).setLayoutParams((ViewGroup.LayoutParams)localObject1);
              }
            }
            else
            {
              i = 0;
              if (!localp.vx()) {
                break label9368;
              }
              if (localp.dRL().dVY())
              {
                i = 1;
                ((LinearLayout)localObject8).setTag(localp);
                ((LinearLayout)localObject8).setTag(2131301433, localObject9);
                ((LinearLayout)localObject8).setOnClickListener(this.zaU.Azh);
              }
              j = 0;
            }
            for (;;)
            {
              if (i != 0)
              {
                this.nZK.c((View)localObject8, this.zaU.AyJ, this.zaU.Ayq);
                if (!ebJ()) {
                  break label10141;
                }
                localObject1 = bh.aAS(((TimeLineObject)localObject6).HAT.Url);
                localObject3 = ((TimeLineObject)localObject6).HAT.Title;
                if (i != 0) {
                  localObject1 = ((TimeLineObject)localObject6).HAT.Desc;
                }
                if ((((TimeLineObject)localObject6).HAT.GaT == null) || (((TimeLineObject)localObject6).HAT.GaT.hzk != 1)) {
                  break label12070;
                }
                localObject1 = aj.getContext().getString(2131761345);
              }
              for (;;)
              {
                ((LinearLayout)localObject8).findViewById(2131305185).setVisibility(8);
                if (!((TimeLineObject)localObject6).HAT.GaQ.isEmpty())
                {
                  ((MMImageView)localObject9).setVisibility(0);
                  localObject5 = (byn)((TimeLineObject)localObject6).HAT.GaQ.get(0);
                  if (((TimeLineObject)localObject6).HAT.GaP == 15)
                  {
                    ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setImageResource(2131233395);
                    ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setVisibility(0);
                    com.tencent.mm.plugin.sns.model.ag.dUb().a((byn)localObject5, (View)localObject9, 2131689581, hashCode(), com.tencent.mm.storage.bj.frn().aaU(((TimeLineObject)localObject6).CreateTime));
                    localObject5 = localObject3;
                    localObject3 = localObject1;
                    localObject1 = localObject5;
                    com.tencent.mm.plugin.sns.data.q.b((View)localObject9, this);
                    if (((TimeLineObject)localObject6).HAT.GaP != 15) {
                      break label12067;
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
                        break label8893;
                        if (((TimeLineObject)localObject6).HAT.GaP == 9)
                        {
                          if (((TimeLineObject)localObject6).HAT.GaQ.size() <= 0) {
                            break label12073;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.AaO));
                          ((LinearLayout)localObject8).setOnClickListener(this.AaW.Aqc);
                          i = 0;
                          j = 0;
                          break label8983;
                        }
                        if (((TimeLineObject)localObject6).HAT.GaP == 10)
                        {
                          if (((TimeLineObject)localObject6).HAT.GaQ.size() <= 0) {
                            break label12073;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.AaO));
                          ((LinearLayout)localObject8).setOnClickListener(this.AaW.Aqe);
                          i = 0;
                          j = 0;
                          break label8983;
                        }
                        if (((TimeLineObject)localObject6).HAT.GaP == 17)
                        {
                          if (((TimeLineObject)localObject6).HAT.GaQ.size() <= 0) {
                            break label12073;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.AaO));
                          ((LinearLayout)localObject8).setOnClickListener(this.AaW.Aqf);
                          i = 0;
                          j = 0;
                          break label8983;
                        }
                        if (((TimeLineObject)localObject6).HAT.GaP == 22)
                        {
                          if (((TimeLineObject)localObject6).HAT.GaQ.size() <= 0) {
                            break label12073;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.AaO));
                          ((LinearLayout)localObject8).setOnClickListener(this.AaW.Aqg);
                          i = 0;
                          j = 0;
                          break label8983;
                        }
                        if (((TimeLineObject)localObject6).HAT.GaP == 23)
                        {
                          if (((TimeLineObject)localObject6).HAT.GaQ.size() <= 0) {
                            break label12073;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.AaO));
                          ((LinearLayout)localObject8).setOnClickListener(this.AaW.Aqh);
                          i = 0;
                          j = 0;
                          break label8983;
                        }
                        if (((TimeLineObject)localObject6).HAT.GaP == 14)
                        {
                          if (((TimeLineObject)localObject6).HAT.GaQ.size() <= 0) {
                            break label12073;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.AaO));
                          ((LinearLayout)localObject8).setOnClickListener(this.AaW.Aqd);
                          i = 0;
                          j = 0;
                          break label8983;
                        }
                        if (((TimeLineObject)localObject6).HAT.GaP == 12)
                        {
                          if (((TimeLineObject)localObject6).HAT.GaQ.size() <= 0) {
                            break label12073;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.AaO));
                          ((LinearLayout)localObject8).setOnClickListener(this.AaW.Aqm);
                          i = 0;
                          j = 0;
                          break label8983;
                        }
                        if (((TimeLineObject)localObject6).HAT.GaP == 30)
                        {
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.AaO));
                          ((LinearLayout)localObject8).setOnClickListener(this.AaW.Aqk);
                          i = 0;
                          j = 0;
                          break label8983;
                        }
                        if (((TimeLineObject)localObject6).HAT.GaP == 13)
                        {
                          if (((TimeLineObject)localObject6).HAT.GaQ.size() <= 0) {
                            break label12073;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.AaO));
                          ((LinearLayout)localObject8).setOnClickListener(this.AaW.Aqn);
                          i = 0;
                          j = 0;
                          break label8983;
                        }
                        if (((TimeLineObject)localObject6).HAT.GaP == 15)
                        {
                          if (((TimeLineObject)localObject6).HAT.GaQ.size() <= 0) {
                            break label12073;
                          }
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.AaO));
                          ((LinearLayout)localObject8).setOnClickListener(this.zaU.AyQ);
                          i = 0;
                          j = 0;
                          break label8983;
                        }
                        if (((TimeLineObject)localObject6).HAT.GaP == 26)
                        {
                          ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.AaO));
                          ((LinearLayout)localObject8).setOnClickListener(this.AaW.Aqo);
                          i = 0;
                          j = 0;
                          break label8983;
                        }
                        ((LinearLayout)localObject8).setTag(new s((TimeLineObject)localObject6, this.AaO));
                        ((LinearLayout)localObject8).setOnClickListener(this.AaW.Ahy);
                        if ((((TimeLineObject)localObject6).hzT & 0x1) <= 0) {
                          break label12073;
                        }
                        i = 0;
                        j = 1;
                        break label8983;
                        this.nZK.c((View)localObject8, this.zaU.AyF, this.zaU.Ayq);
                        break label9011;
                        localObject1 = "";
                        break label9030;
                        if (((TimeLineObject)localObject6).HAT.GaP == 5)
                        {
                          localObject3 = bh.aAS(((byn)localObject5).Url);
                          localObject1 = ((byn)localObject5).Title;
                          ((LinearLayout)localObject8).findViewById(2131305185).setVisibility(0);
                          com.tencent.mm.plugin.sns.model.ag.dUb().a((byn)localObject5, (View)localObject9, 2131689581, hashCode(), com.tencent.mm.storage.bj.ILU);
                          break label9227;
                        }
                        if (((TimeLineObject)localObject6).HAT.GaP == 18)
                        {
                          ((LinearLayout)localObject8).findViewById(2131305185).setVisibility(0);
                          ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setImageResource(2131234474);
                          ((MMImageView)localObject9).setVisibility(0);
                          com.tencent.mm.plugin.sns.model.ag.dUb().a((byn)localObject5, (View)localObject9, 2131689581, hashCode(), com.tencent.mm.storage.bj.ILU);
                          localObject5 = localObject1;
                          localObject1 = localObject3;
                          localObject3 = localObject5;
                          break label9227;
                        }
                        com.tencent.mm.plugin.sns.model.ag.dUb().b((byn)localObject5, (View)localObject9, hashCode(), com.tencent.mm.storage.bj.ILU);
                        localObject5 = localObject1;
                        localObject1 = localObject3;
                        localObject3 = localObject5;
                        break label9227;
                        if (((TimeLineObject)localObject6).HAT.GaP == 18)
                        {
                          ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setVisibility(0);
                          ((ImageView)((LinearLayout)localObject8).findViewById(2131305185)).setImageResource(2131234474);
                          ((MMImageView)localObject9).setVisibility(0);
                          com.tencent.mm.plugin.sns.model.ag.dUb().d((View)localObject9, -1, 2131689581, hashCode());
                          localObject5 = localObject1;
                          localObject1 = localObject3;
                          localObject3 = localObject5;
                          break label9227;
                        }
                        if (((TimeLineObject)localObject6).HAT.GaP == 26)
                        {
                          ((MMImageView)localObject9).setVisibility(0);
                          com.tencent.mm.plugin.sns.model.ag.dUb().d((View)localObject9, -1, 2131690949, hashCode());
                          localObject5 = localObject1;
                          localObject1 = localObject3;
                          localObject3 = localObject5;
                          break label9227;
                        }
                        ((MMImageView)localObject9).setVisibility(0);
                        com.tencent.mm.plugin.sns.model.ag.dUb().d((View)localObject9, -1, 2131689584, hashCode());
                        localObject5 = localObject1;
                        localObject1 = localObject3;
                        localObject3 = localObject5;
                        break label9227;
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
                    break label2581;
                  }
                  ((TextView)localObject5).setTextColor(getContext().getResources().getColor(2131099769));
                  ((TextView)localObject5).setClickable(true);
                  ((TextView)localObject5).setText((CharSequence)localObject1);
                  break label2612;
                  label10587:
                  ((TextView)localObject5).setVisibility(8);
                  break label2612;
                  label10597:
                  if (((TimeLineObject)localObject6).HAR == null)
                  {
                    localObject1 = null;
                    label10608:
                    if (((TimeLineObject)localObject6).HAR != null) {
                      break label10668;
                    }
                  }
                  for (localObject3 = null;; localObject3 = ((TimeLineObject)localObject6).HAR.jDf)
                  {
                    ((TextView)localObject5).setTag(localp.dYK());
                    if ((!bt.isNullOrNil((String)localObject1)) || (!bt.isNullOrNil((String)localObject3))) {
                      break label10681;
                    }
                    ((TextView)localObject5).setVisibility(8);
                    break;
                    localObject1 = ((TimeLineObject)localObject6).HAR.jde;
                    break label10608;
                  }
                  ((TextView)localObject5).setVisibility(0);
                  if (!bt.isNullOrNil((String)localObject3))
                  {
                    ((TextView)localObject5).setTextColor(getContext().getResources().getColor(2131099769));
                    ((TextView)localObject5).setClickable(true);
                    if ((localp.field_snsId == 0L) && (!bt.isNullOrNil((String)localObject1)))
                    {
                      ((TextView)localObject5).setText((String)localObject1 + "·" + (String)localObject3);
                      break label2628;
                    }
                    ((TextView)localObject5).setText((CharSequence)localObject3);
                    break label2628;
                  }
                  ((TextView)localObject5).setText((CharSequence)localObject1);
                  ((TextView)localObject5).setClickable(false);
                  ((TextView)localObject5).setTextColor(getContext().getResources().getColor(2131100212));
                  break label2628;
                  ((TextView)localObject5).setVisibility(8);
                  break label2823;
                  if (((com.tencent.mm.plugin.sns.storage.a)localObject7).zuJ != com.tencent.mm.plugin.sns.storage.a.zuw) {
                    break label2823;
                  }
                  if (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject7).zuK))
                  {
                    localObject1 = "";
                    localObject9 = ((com.tencent.mm.plugin.sns.storage.a)localObject7).zuM.iterator();
                    if (((Iterator)localObject9).hasNext())
                    {
                      localObject10 = (String)((Iterator)localObject9).next();
                      localObject3 = this.AaP.aTk((String)localObject10);
                      if (localObject3 != null)
                      {
                        localObject3 = ((com.tencent.mm.o.b)localObject3).adv();
                        if (!bt.isNullOrNil((String)localObject3)) {
                          localObject3 = (String)localObject1 + (String)localObject3;
                        }
                      }
                      for (;;)
                      {
                        localObject1 = localObject3;
                        if (((com.tencent.mm.plugin.sns.storage.a)localObject7).zuM.getLast() == localObject10) {
                          break;
                        }
                        localObject1 = (String)localObject3 + ",";
                        break;
                        localObject3 = (String)localObject1 + (String)localObject10;
                        continue;
                        localObject3 = (String)localObject1 + (String)localObject10;
                      }
                    }
                    localObject3 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject7).zuK, new Object[] { localObject1 });
                    ((TextView)localObject5).getTextSize();
                    localObject9 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject3, 1));
                    ((com.tencent.mm.pluginsdk.ui.span.l)localObject9).b(null, (CharSequence)localObject3);
                    localObject3 = ((TextView)localObject5).getPaint();
                    if (com.tencent.mm.cc.a.aA(this, (int)Layout.getDesiredWidth((CharSequence)localObject9, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject9).length(), (TextPaint)localObject3)) > this.Abb)
                    {
                      label11113:
                      if (((String)localObject1).length() <= 1) {
                        break label2823;
                      }
                      localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
                      localObject9 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject7).zuK, new Object[] { (String)localObject1 + "..." });
                      ((TextView)localObject5).getTextSize();
                      localObject10 = new com.tencent.mm.pluginsdk.ui.span.l(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject9, 1));
                      ((com.tencent.mm.pluginsdk.ui.span.l)localObject10).b(null, (CharSequence)localObject9);
                      i = com.tencent.mm.cc.a.aA(this, (int)Layout.getDesiredWidth((CharSequence)localObject10, 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject10).length(), (TextPaint)localObject3));
                      ((TextView)localObject5).setText((CharSequence)localObject10, TextView.BufferType.SPANNABLE);
                      ((TextView)localObject5).setVisibility(0);
                      if (i > this.Abb) {
                        break label2822;
                      }
                      break label2823;
                    }
                    ((TextView)localObject5).setText((CharSequence)localObject9, TextView.BufferType.SPANNABLE);
                    ((TextView)localObject5).setVisibility(0);
                    break label2823;
                  }
                  ((TextView)localObject5).setVisibility(8);
                  break label2823;
                  ((TextView)localObject8).setVisibility(8);
                  break label2949;
                  i = 8;
                  break label2980;
                  if (((TimeLineObject)localObject6).HAT.GaP == 30)
                  {
                    localObject1 = ((TimeLineObject)localObject6).HAZ.username;
                    localObject1 = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt((String)localObject1);
                    if ((localObject1 != null) && (!bt.isNullOrNil(((WxaAttributes)localObject1).field_nickname))) {}
                    for (localObject3 = ((WxaAttributes)localObject1).field_nickname;; localObject3 = getString(2131755945))
                    {
                      localObject1 = localObject3;
                      if (((TimeLineObject)localObject6).HAZ.subType != 1) {
                        break;
                      }
                      this.AbF.findViewById(2131305185).setVisibility(0);
                      localObject1 = localObject3;
                      break;
                    }
                  }
                  if (((TimeLineObject)localObject6).HAT.GaP == 28)
                  {
                    localObject3 = getContext().getResources().getString(2131759151);
                    localObject1 = localObject3;
                    if (((TimeLineObject)localObject6).HAT.GaU == null) {
                      break label3070;
                    }
                    localObject1 = localObject3;
                    if (bt.isNullOrNil(((TimeLineObject)localObject6).HAT.GaU.nickname)) {
                      break label3070;
                    }
                    localObject1 = (String)localObject3 + " · " + ((TimeLineObject)localObject6).HAT.GaU.nickname;
                    break label3070;
                  }
                  if (((TimeLineObject)localObject6).HAT.GaP != 29) {
                    break label3070;
                  }
                  localObject1 = getContext().getResources().getString(2131759151);
                  break label3070;
                  ((TextView)localObject4).setVisibility(8);
                  break label3211;
                  ((TextView)localObject1).setVisibility(8);
                  break label3386;
                  if (((SnsObject)localObject5).WithUserList.size() <= 0) {
                    ((TextView)localObject4).setVisibility(8);
                  }
                  for (;;)
                  {
                    if ((localObject5 == null) || (this.fFK == null) || (!this.fFK.equals(((SnsObject)localObject5).Username)) || (((((SnsObject)localObject5).ExtFlag != 3) || (((SnsObject)localObject5).BlackList == null)) && ((((SnsObject)localObject5).ExtFlag != 5) || (((SnsObject)localObject5).GroupUser == null)))) {
                      break label12049;
                    }
                    this.Aay.findViewById(2131296570).setVisibility(0);
                    this.Aay.findViewById(2131296570).setTag(Integer.valueOf(localp.zMC));
                    this.Aay.findViewById(2131296570).setOnClickListener(new SnsCommentDetailUI.33(this));
                    break;
                    if (this.fFK.equals(((SnsObject)localObject5).Username))
                    {
                      ((TextView)localObject4).setVisibility(0);
                      i = 0;
                      localObject6 = ((SnsObject)localObject5).WithUserList.iterator();
                      localObject1 = "";
                      if (((Iterator)localObject6).hasNext())
                      {
                        localObject7 = (dfn)((Iterator)localObject6).next();
                        if (i == 0)
                        {
                          i = 1;
                          localObject1 = (String)localObject1 + "  ";
                          if (((dfn)localObject7).Nickname == null) {
                            break label11867;
                          }
                          localObject3 = new StringBuilder().append((String)localObject1);
                          localObject1 = ((dfn)localObject7).Nickname;
                        }
                        for (;;)
                        {
                          localObject1 = (String)localObject1;
                          break;
                          localObject1 = (String)localObject1 + ",  ";
                          break label11797;
                          label11867:
                          localObject8 = this.AaP.Bf(((dfn)localObject7).Username);
                          localObject3 = new StringBuilder().append((String)localObject1);
                          if (localObject8 == null) {
                            localObject1 = ((dfn)localObject7).Username;
                          } else {
                            localObject1 = ((com.tencent.mm.o.b)localObject8).adv();
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
                        localObject3 = (dfn)((Iterator)localObject1).next();
                        if (!this.fFK.equals(((dfn)localObject3).Username)) {
                          break label11584;
                        }
                        ((TextView)localObject4).setVisibility(0);
                        localObject1 = getString(2131764040);
                        ((TextView)localObject4).setVisibility(0);
                        ((TextView)localObject4).setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject1, ((TextView)localObject4).getTextSize()));
                      }
                    }
                  }
                  this.Aay.findViewById(2131296570).setVisibility(8);
                  break label3420;
                }
              }
              i = 0;
              j = 0;
            }
          }
        }
      }
      label1738:
      label6219:
      i = 0;
      label2499:
      label2628:
      label6475:
      localObject4 = localObject1;
      label8389:
      label9030:
      label10825:
      break;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495537;
  }
  
  public final int getSource()
  {
    if (this.Abl == 16) {
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
        AppMethodBeat.i(198322);
        if (SnsCommentDetailUI.c(SnsCommentDetailUI.this) != null) {
          SnsCommentDetailUI.c(SnsCommentDetailUI.this).rQ(false);
        }
        SnsCommentDetailUI.this.finish();
        AppMethodBeat.o(198322);
        return true;
      }
    });
    this.fFK = u.aAm();
    if (com.tencent.mm.plugin.sns.model.ag.dTN()) {
      finish();
    }
    final com.tencent.mm.plugin.sns.storage.p localp = rP(true);
    if (localp == null)
    {
      ad.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.dzb);
      finish();
      AppMethodBeat.o(98599);
      return;
    }
    ad.i("MicroMsg.SnsCommentDetailUI", "snsId: " + this.dzb + "localId " + this.AaO + "  username:" + localp.field_userName);
    Object localObject1 = (TextView)findViewById(2131298750);
    label297:
    int i;
    if (this.Abi)
    {
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(this.Abj);
      if ((x.aAx(this.dzb)) || (!localp.dYM())) {
        break label700;
      }
      localObject1 = localp.dYD();
      findViewById(2131305039).setVisibility(0);
      localObject2 = (TextView)findViewById(2131303362);
      switch (((byo)localObject1).GTo)
      {
      default: 
        if (!bt.isNullOrNil(((byo)localObject1).GTv))
        {
          ((TextView)localObject2).setText(((byo)localObject1).GTv);
          findViewById(2131305040).setVisibility(0);
          i = 1;
          label310:
          if (i != 0) {
            findViewById(2131305039).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(198313);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                if (localp.QM(32))
                {
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(198313);
                  return;
                }
                ak.PY(localp.zMC);
                ak.PW(localp.zMC);
                com.tencent.mm.plugin.sns.model.ag.dUa().dSE();
                paramAnonymousView = new Intent();
                SnsCommentDetailUI.this.setResult(-1, paramAnonymousView);
                if (SnsCommentDetailUI.w(SnsCommentDetailUI.this)) {
                  paramAnonymousView.putExtra("sns_gallery_force_finish", true);
                }
                SnsCommentDetailUI.this.finish();
                SnsCommentDetailUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198313);
              }
            });
          }
          this.AaC = ((ListView)findViewById(2131296556));
          this.AaC.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(198314);
              SnsCommentDetailUI.a(SnsCommentDetailUI.this, SnsCommentDetailUI.a(SnsCommentDetailUI.this).getBottom());
              ad.d("MicroMsg.SnsCommentDetailUI", "listOriginalBottom: " + SnsCommentDetailUI.d(SnsCommentDetailUI.this));
              AppMethodBeat.o(198314);
            }
          });
          this.AaC.setOnScrollListener(new AbsListView.OnScrollListener()
          {
            public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AppMethodBeat.i(198315);
              if (paramAnonymousInt2 > 0) {
                if ((paramAnonymousInt1 == 0) && (!SnsCommentDetailUI.x(SnsCommentDetailUI.this)))
                {
                  SnsCommentDetailUI.a(SnsCommentDetailUI.this, true);
                  if (SnsCommentDetailUI.y(SnsCommentDetailUI.this) != null)
                  {
                    SnsCommentDetailUI.y(SnsCommentDetailUI.this).refreshView();
                    AppMethodBeat.o(198315);
                    return;
                  }
                  if (SnsCommentDetailUI.z(SnsCommentDetailUI.this) != null)
                  {
                    SnsCommentDetailUI.this.ebK();
                    AppMethodBeat.o(198315);
                  }
                }
                else if (paramAnonymousInt1 > 0)
                {
                  SnsCommentDetailUI.a(SnsCommentDetailUI.this, false);
                }
              }
              AppMethodBeat.o(198315);
            }
            
            public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
            {
              AppMethodBeat.i(198316);
              if (paramAnonymousInt == 1)
              {
                SnsCommentDetailUI.this.hideVKB();
                SnsCommentDetailUI.A(SnsCommentDetailUI.this);
              }
              if ((paramAnonymousInt == 0) && (SnsCommentDetailUI.f(SnsCommentDetailUI.this) != null)) {
                SnsCommentDetailUI.f(SnsCommentDetailUI.this).rj(true);
              }
              AppMethodBeat.o(198316);
            }
          });
          localObject1 = rP(false);
          this.Aay = z.jO(getContext()).inflate(2131495538, null);
          this.AaE = this.Aay.findViewById(2131300970);
          this.Aay.setOnClickListener(this.AbB);
          if ((localObject1 == null) || (!((com.tencent.mm.plugin.sns.storage.p)localObject1).QM(32)) || (!((com.tencent.mm.plugin.sns.storage.p)localObject1).dWc())) {
            break label717;
          }
          this.Abt = ((FrameLayout)z.jO(getContext()).inflate(2131496422, null));
          this.Abt.addView(this.Aay, 0);
          this.AaC.addHeaderView(this.Abt);
        }
        break;
      }
    }
    for (;;)
    {
      boolean bool = ebK();
      if (bool) {
        break label731;
      }
      ad.i("MicroMsg.SnsCommentDetailUI", "error isOk setheader ".concat(String.valueOf(bool)));
      finish();
      AppMethodBeat.o(98599);
      return;
      ((TextView)localObject1).setVisibility(8);
      break;
      if (!bt.isNullOrNil(((byo)localObject1).GTv)) {
        ((TextView)localObject2).setText(((byo)localObject1).GTv);
      }
      for (;;)
      {
        findViewById(2131305040).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(2131763943);
      }
      if (!bt.isNullOrNil(((byo)localObject1).GTv)) {
        ((TextView)localObject2).setText(((byo)localObject1).GTv);
      }
      for (;;)
      {
        findViewById(2131305040).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(2131763945);
      }
      if (!bt.isNullOrNil(((byo)localObject1).GTv)) {
        ((TextView)localObject2).setText(((byo)localObject1).GTv);
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
      this.AaC.addHeaderView(this.Aay);
    }
    label731:
    if (localObject1 != null) {
      this.oIb = bh.c((com.tencent.mm.plugin.sns.storage.p)localObject1, false);
    }
    if ((this.oIb == 10) && (u.aAm().equals(localp.field_userName)))
    {
      this.AaB = new SnsDetailLuckyHeader(this);
      localObject1 = new AbsListView.LayoutParams(-1, -2);
      this.AaB.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.AaB.setOnClickListener(this.AbB);
    }
    this.AaA = new LinearLayout(getContext());
    localObject1 = new AbsListView.LayoutParams(-1, -2);
    this.AaA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.AaA.setOnClickListener(this.AbB);
    BackwardSupportUtil.b.g(this, 2.0F);
    localObject1 = new AbsListView.LayoutParams(-1, 1);
    Object localObject2 = new LinearLayout(getContext());
    ((LinearLayout)localObject2).setBackgroundResource(2131234115);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.zfi = ((LinearLayout)localObject2);
    b(localp, true);
    if (this.AaB != null)
    {
      this.Abf = true;
      this.AaC.addHeaderView(this.AaB);
    }
    localObject2 = ak.u(localp);
    label1080:
    label1243:
    dfn localdfn;
    long l;
    if (localObject2 == null)
    {
      this.AaA.setVisibility(8);
      this.AaF = new b(new LinkedList(), new LinkedList(), this, localp.dYK());
      this.AaC.addHeaderView(this.AaA);
      this.AaC.setAdapter(this.AaF);
      this.zPg = ((SnsCommentFooter)findViewById(2131298521));
      if ((localp == null) || (localp.dYl() == null) || (localp.dYl().HAT == null) || ((localp.dYl().HAT.GaR & 0x80) != 0)) {
        break label1769;
      }
      this.zPg.setFeedEmojiCommentEnable(true);
      this.zPg.setTag(localp);
      this.zPg.setOnEditTouchListener(new SnsCommentFooter.a()
      {
        public final void ebO()
        {
          AppMethodBeat.i(198317);
          if (!com.tencent.mm.plugin.sns.lucky.a.m.ayt(localp.dYK()))
          {
            if ((SnsCommentDetailUI.B(SnsCommentDetailUI.this) != null) && (SnsCommentDetailUI.B(SnsCommentDetailUI.this).isShowing()))
            {
              AppMethodBeat.o(198317);
              return;
            }
            SnsCommentDetailUI.a(SnsCommentDetailUI.this, com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.AbH.Ra(0)));
            AppMethodBeat.o(198317);
            return;
          }
          if ((SnsCommentDetailUI.this.keyboardState() == 1) || (SnsCommentDetailUI.c(SnsCommentDetailUI.this).ebQ()))
          {
            AppMethodBeat.o(198317);
            return;
          }
          SnsCommentDetailUI.C(SnsCommentDetailUI.this);
          AppMethodBeat.o(198317);
        }
      });
      this.zPg.setOnSmileyShowListener(new SnsCommentFooter.c()
      {
        public final void onShow()
        {
          AppMethodBeat.i(198318);
          if (SnsCommentDetailUI.c(SnsCommentDetailUI.this).AcB)
          {
            AppMethodBeat.o(198318);
            return;
          }
          SnsCommentDetailUI.C(SnsCommentDetailUI.this);
          AppMethodBeat.o(198318);
        }
      });
      localObject1 = rP(true);
      if ((localObject1 != null) && (!((com.tencent.mm.plugin.sns.storage.p)localObject1).dYJ())) {
        this.zPg.setVisibility(8);
      }
      this.zPg.setAfterEditAction(this.AbA);
      this.zPg.ebR();
      this.zPg.setOnCommentSendImp(new SnsCommentFooter.b()
      {
        public final void jU(String paramAnonymousString1, String paramAnonymousString2)
        {
          int j = 8;
          AppMethodBeat.i(198319);
          if (!com.tencent.mm.plugin.sns.lucky.a.m.ayt(localp.dYK()))
          {
            if (SnsCommentDetailUI.this.AbH.Ra(0) != null) {
              com.tencent.mm.plugin.sns.lucky.ui.a.f(SnsCommentDetailUI.this.getContext(), SnsCommentDetailUI.this.AbH.Ra(0));
            }
            AppMethodBeat.o(198319);
            return;
          }
          if (localp.QM(32)) {}
          for (int i = SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentFlag();; i = 0)
          {
            if (com.tencent.mm.plugin.sns.ui.widget.e.ia(i, 8))
            {
              paramAnonymousString1 = paramAnonymousString1.substring(SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentAtPrefix().length());
              ad.i("MicroMsg.SnsCommentDetailUI", "send atFriend ad detail comment");
              an.a.a(localp, 16, paramAnonymousString1, SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentInfo(), i, SnsCommentDetailUI.this.getSource(), paramAnonymousString2);
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).setText("");
              SnsCommentDetailUI.c(SnsCommentDetailUI.this).rQ(false);
              ad.i("MicroMsg.SnsCommentDetailUI", "comment send imp!");
              com.tencent.mm.plugin.sns.j.e.ztz.dVJ().ejv = 3L;
              SnsCommentDetailUI.A(SnsCommentDetailUI.this);
              AppMethodBeat.o(198319);
              return;
            }
            ad.i("MicroMsg.SnsCommentDetailUI", "send detail comment");
            com.tencent.mm.plugin.sns.storage.p localp = localp;
            if (localp.QM(32)) {}
            for (;;)
            {
              an.a.a(localp, j, paramAnonymousString1, SnsCommentDetailUI.c(SnsCommentDetailUI.this).getCommentInfo(), i, SnsCommentDetailUI.this.getSource(), paramAnonymousString2);
              break;
              j = 2;
            }
          }
        }
      });
      this.AaU = getIntent().getBooleanExtra("INTENT_FROMSUI", false);
      if (this.AaU)
      {
        this.AaV = getIntent().getLongExtra("INTENT_FROMSUI_COMMENTID", 0L);
        if ((this.AaV != 0L) && (this.AaF.commentList != null))
        {
          i = 0;
          if (i < this.AaF.commentList.size())
          {
            localdfn = (dfn)this.AaF.commentList.get(i);
            if (localdfn.HtH == 0) {
              break label1780;
            }
            l = localdfn.HtH;
            label1289:
            if (l != this.AaV) {
              break label1818;
            }
            this.AaC.setSelection(i);
            localObject1 = this.AaP.Bf(localdfn.Username);
            if (localObject1 == null) {
              break label1790;
            }
            localObject1 = ((com.tencent.mm.o.b)localObject1).adv();
            label1335:
            this.zPg.Acs = 0;
            this.zPg.ebS();
            this.zPg.setCommentHint(getString(2131763952) + (String)localObject1);
            this.zPg.setCommentInfo(localdfn);
            if (((SnsObject)localObject2).LikeUserList.size() <= 0) {
              break label1857;
            }
            int j = i + 1;
            i = j;
            if (j > this.AaF.getCount()) {
              i = this.AaF.getCount() - 1;
            }
          }
        }
      }
    }
    label1818:
    label1857:
    for (;;)
    {
      this.AbA.UL = i;
      if (this.AaU) {
        new ap().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(198320);
            SnsCommentDetailUI.this.hideVKB();
            SnsCommentDetailUI.m(SnsCommentDetailUI.this).kl = SnsCommentDetailUI.D(SnsCommentDetailUI.this);
            SnsCommentDetailUI.m(SnsCommentDetailUI.this).run();
            AppMethodBeat.o(198320);
          }
        }, 100L);
      }
      this.Abe = ((SnsTranslateResultView)this.Aay.findViewById(2131305091));
      this.Abe.setResultTextSize(((TextView)this.Aay.findViewById(2131299008)).getTextSize());
      this.Abe.getResultTextView().setBackgroundResource(2131234100);
      localObject1 = new bd(this.dzb, localp.dYK(), false, true, 2);
      this.Abe.getResultTextView().setTag(localObject1);
      this.nZK.c(this.Abe.getResultTextView(), this.zaU.Ayt, this.zaU.Ayq);
      if (ar.eV(this.dzb, 4))
      {
        localObject1 = ar.azc(this.dzb);
        if ((localObject1 != null) && (((ar.b)localObject1).hII))
        {
          this.Abe.setVisibility(0);
          this.Abe.a(null, 1, ((ar.b)localObject1).result, ((ar.b)localObject1).hQG, false);
          AppMethodBeat.o(98599);
          return;
          this.AaK = ((SnsObject)localObject2).LikeUserList;
          j(((SnsObject)localObject2).LikeUserList, ((SnsObject)localObject2).CommentUserList.isEmpty());
          if (this.AaB != null) {
            this.AaB.a(localp, this.zaU);
          }
          this.AaF = new b(((SnsObject)localObject2).CommentUserList, ((SnsObject)localObject2).LikeUserList, this, localp.dYK());
          if (!this.Abm) {
            break;
          }
          com.tencent.mm.plugin.sns.j.e.ztz.dVJ().ejt = ((SnsObject)localObject2).CommentUserList.size();
          com.tencent.mm.plugin.sns.j.e.ztz.dVJ().eju = ((SnsObject)localObject2).LikeUserList.size();
          break;
          label1769:
          this.zPg.setFeedEmojiCommentEnable(false);
          break label1080;
          label1780:
          l = localdfn.HtJ;
          break label1289;
          label1790:
          if (localdfn.Nickname != null)
          {
            localObject1 = localdfn.Nickname;
            break label1335;
          }
          localObject1 = localdfn.Username;
          break label1335;
          i += 1;
          break label1243;
        }
        this.Abe.setVisibility(8);
        AppMethodBeat.o(98599);
        return;
      }
      this.Abe.setVisibility(8);
      AppMethodBeat.o(98599);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98610);
    ad.i("MicroMsg.SnsCommentDetailUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt1 == 15)
    {
      if ((this.zaU != null) && (this.zaU.Ayq != null)) {
        this.zaU.Ayq.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      AppMethodBeat.o(98610);
      return;
    }
    if (paramInt1 == 16)
    {
      ad.i("MicroMsg.SnsCommentDetailUI", "REQUEST_CODE_FOR_FULLSCREEN");
      paramIntent = new ia();
      paramIntent.duz.scene = 1;
      com.tencent.mm.sdk.b.a.IbL.l(paramIntent);
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
            this.zPg.fLP.showVKB();
            String str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf(paramIntent[0]);
            if (!bt.isNullOrNil(str))
            {
              this.zPg.ebS();
              this.zPg.setText("@" + str + " ");
              this.zPg.setCommentAtPrefix("@" + str + " ");
              this.zPg.setCommentInfo(new dfn());
              this.zPg.getCommentInfo().Username = paramIntent[0];
              this.zPg.setCommentFlag(8);
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
          com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahp(), "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98609);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = com.tencent.mm.plugin.sns.storage.h.azZ(this.dzb);
    Object localObject = ak.u(paramConfiguration);
    j(((SnsObject)localObject).LikeUserList, ((SnsObject)localObject).CommentUserList.isEmpty());
    if (this.AaB != null) {
      this.AaB.a(paramConfiguration, this.zaU);
    }
    paramConfiguration = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    localObject = new Point();
    ((Point)localObject).x = paramConfiguration.widthPixels;
    ((Point)localObject).y = paramConfiguration.heightPixels;
    com.tencent.mm.plugin.sns.model.ag.i((Point)localObject);
    if (this.AbH != null)
    {
      this.AaY = com.tencent.mm.plugin.sns.model.ag.dUp();
      this.AbH.setImageViewWidth(this.AaY);
    }
    AppMethodBeat.o(98609);
  }
  
  /* Error */
  public void onCreate(final Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc_w 3131
    //   3: invokestatic 243	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 3136	com/tencent/mm/pluginsdk/h:q	(Lcom/tencent/mm/ui/MMActivity;)V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 3138	com/tencent/mm/ui/MMActivity:onCreate	(Landroid/os/Bundle;)V
    //   15: aload_0
    //   16: invokestatic 3141	com/tencent/mm/plugin/sns/ad/timeline/a/c:dRY	()Z
    //   19: putfield 941	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abs	Z
    //   22: aload_0
    //   23: ldc_w 3143
    //   26: invokestatic 2579	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   29: checkcast 3143	com/tencent/mm/plugin/story/api/e
    //   32: invokeinterface 3147 1 0
    //   37: getstatic 3153	com/tencent/mm/plugin/story/api/f$a:AHT	Lcom/tencent/mm/plugin/story/api/f$a;
    //   40: invokeinterface 3158 2 0
    //   45: putfield 329	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abo	Z
    //   48: aload_0
    //   49: ldc_w 3143
    //   52: invokestatic 2579	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   55: checkcast 3143	com/tencent/mm/plugin/story/api/e
    //   58: invokeinterface 3147 1 0
    //   63: getstatic 3161	com/tencent/mm/plugin/story/api/f$a:AHU	Lcom/tencent/mm/plugin/story/api/f$a;
    //   66: invokeinterface 3158 2 0
    //   71: putfield 331	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abp	Z
    //   74: aload_0
    //   75: iconst_1
    //   76: invokestatic 3166	com/tencent/mm/ui/b:c	(Landroid/app/Activity;Z)V
    //   79: invokestatic 3170	com/tencent/mm/plugin/sns/model/ag:dTU	()Lcom/tencent/mm/plugin/sns/model/an$a;
    //   82: iconst_5
    //   83: ldc_w 3172
    //   86: aload_0
    //   87: invokevirtual 3175	com/tencent/mm/plugin/sns/model/an$a:a	(ILjava/lang/String;Lcom/tencent/mm/plugin/sns/b/i$a;)V
    //   90: aload_0
    //   91: aload_0
    //   92: invokevirtual 3178	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getApplicationContext	()Landroid/content/Context;
    //   95: ldc_w 3180
    //   98: invokevirtual 3181	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   101: checkcast 3183	android/text/ClipboardManager
    //   104: putfield 1258	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rBg	Landroid/text/ClipboardManager;
    //   107: aload_0
    //   108: aload_0
    //   109: bipush 14
    //   111: invokestatic 3186	com/tencent/mm/ui/aq:fromDPToPix	(Landroid/content/Context;I)I
    //   114: putfield 327	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abn	I
    //   117: aload_0
    //   118: invokestatic 3192	com/tencent/mm/ui/al:ci	(Landroid/content/Context;)Landroid/graphics/Point;
    //   121: astore_1
    //   122: aload_0
    //   123: aload_1
    //   124: getfield 3118	android/graphics/Point:x	I
    //   127: putfield 3194	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenWidth	I
    //   130: aload_0
    //   131: aload_1
    //   132: getfield 3123	android/graphics/Point:y	I
    //   135: putfield 3196	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenHeight	I
    //   138: aload_0
    //   139: invokestatic 3202	java/lang/System:currentTimeMillis	()J
    //   142: putfield 275	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Aaw	J
    //   145: aload_0
    //   146: new 1655	com/tencent/mm/ui/widget/b/a
    //   149: dup
    //   150: aload_0
    //   151: invokespecial 3203	com/tencent/mm/ui/widget/b/a:<init>	(Landroid/content/Context;)V
    //   154: putfield 651	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:nZK	Lcom/tencent/mm/ui/widget/b/a;
    //   157: aload_0
    //   158: aload_0
    //   159: invokevirtual 2402	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   162: ldc_w 3205
    //   165: iconst_0
    //   166: invokevirtual 3209	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   169: putfield 2816	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abl	I
    //   172: aload_0
    //   173: aload_0
    //   174: invokevirtual 2402	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   177: ldc_w 3211
    //   180: iconst_0
    //   181: invokevirtual 2410	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   184: putfield 325	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abm	Z
    //   187: aload_0
    //   188: getfield 325	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abm	Z
    //   191: ifeq +10 -> 201
    //   194: getstatic 591	com/tencent/mm/plugin/sns/j/e:ztz	Lcom/tencent/mm/plugin/sns/j/e;
    //   197: invokevirtual 3214	com/tencent/mm/plugin/sns/j/e:dVL	()Lcom/tencent/mm/g/b/a/ew;
    //   200: pop
    //   201: aload_0
    //   202: aload_0
    //   203: invokevirtual 2402	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   206: ldc_w 3216
    //   209: invokevirtual 3024	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   212: ldc_w 299
    //   215: invokestatic 1541	com/tencent/mm/sdk/platformtools/bt:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   218: putfield 513	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dzb	Ljava/lang/String;
    //   221: aload_0
    //   222: getfield 513	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dzb	Ljava/lang/String;
    //   225: invokestatic 904	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   228: ifeq +24 -> 252
    //   231: aload_0
    //   232: ldc_w 3218
    //   235: aload_0
    //   236: invokevirtual 2402	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   239: ldc_w 3216
    //   242: lconst_0
    //   243: invokevirtual 2939	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   246: invokestatic 3222	com/tencent/mm/plugin/sns/storage/x:bm	(Ljava/lang/String;J)Ljava/lang/String;
    //   249: putfield 513	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dzb	Ljava/lang/String;
    //   252: aload_0
    //   253: aload_0
    //   254: invokevirtual 2402	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   257: ldc_w 3224
    //   260: invokevirtual 3024	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   263: ldc_w 299
    //   266: invokestatic 1541	com/tencent/mm/sdk/platformtools/bt:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   269: putfield 854	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AaO	Ljava/lang/String;
    //   272: aload_0
    //   273: getfield 854	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AaO	Ljava/lang/String;
    //   276: invokestatic 904	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   279: ifeq +32 -> 311
    //   282: aload_0
    //   283: invokevirtual 2402	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   286: ldc_w 3224
    //   289: iconst_m1
    //   290: invokevirtual 3209	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   293: istore_2
    //   294: iload_2
    //   295: iconst_m1
    //   296: if_icmpeq +15 -> 311
    //   299: aload_0
    //   300: ldc_w 3218
    //   303: iload_2
    //   304: i2l
    //   305: invokestatic 3222	com/tencent/mm/plugin/sns/storage/x:bm	(Ljava/lang/String;J)Ljava/lang/String;
    //   308: putfield 854	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AaO	Ljava/lang/String;
    //   311: aload_0
    //   312: new 62	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$4
    //   315: dup
    //   316: aload_0
    //   317: aload_0
    //   318: invokevirtual 577	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   321: aload_0
    //   322: aload_0
    //   323: getfield 342	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abu	Lcom/tencent/mm/plugin/sns/model/ah;
    //   326: invokespecial 3227	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$4:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;ILandroid/app/Activity;Lcom/tencent/mm/plugin/sns/model/af;)V
    //   329: putfield 546	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zaU	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   332: aload_0
    //   333: ldc_w 1672
    //   336: invokevirtual 1006	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:findViewById	(I)Landroid/view/View;
    //   339: checkcast 2261	android/widget/FrameLayout
    //   342: astore_1
    //   343: aload_0
    //   344: new 3229	com/tencent/mm/plugin/sns/h/b
    //   347: dup
    //   348: aload_0
    //   349: aload_0
    //   350: getfield 546	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zaU	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   353: aload_1
    //   354: invokespecial 3232	com/tencent/mm/plugin/sns/h/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/c;Landroid/widget/FrameLayout;)V
    //   357: putfield 3234	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zPp	Lcom/tencent/mm/plugin/sns/h/b;
    //   360: aload_0
    //   361: new 3236	com/tencent/mm/plugin/sns/ui/b
    //   364: dup
    //   365: aload_0
    //   366: aload_0
    //   367: getfield 546	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zaU	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   370: aload_1
    //   371: aload_0
    //   372: getfield 3234	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zPp	Lcom/tencent/mm/plugin/sns/h/b;
    //   375: invokespecial 3239	com/tencent/mm/plugin/sns/ui/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/c;Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/sns/h/b;)V
    //   378: putfield 1266	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zPo	Lcom/tencent/mm/plugin/sns/ui/b;
    //   381: aload_0
    //   382: new 3241	com/tencent/mm/plugin/sns/ui/am
    //   385: dup
    //   386: aload_0
    //   387: aload_0
    //   388: getfield 546	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zaU	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   391: aload_1
    //   392: invokespecial 3242	com/tencent/mm/plugin/sns/ui/am:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/c;Landroid/widget/FrameLayout;)V
    //   395: putfield 1270	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zPq	Lcom/tencent/mm/plugin/sns/ui/am;
    //   398: aload_0
    //   399: new 3244	com/tencent/mm/plugin/sns/ui/br
    //   402: dup
    //   403: aload_0
    //   404: aload_0
    //   405: getfield 546	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zaU	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   408: aload_1
    //   409: invokespecial 3245	com/tencent/mm/plugin/sns/ui/br:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/c;Landroid/widget/FrameLayout;)V
    //   412: putfield 1380	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zPr	Lcom/tencent/mm/plugin/sns/ui/br;
    //   415: aload_0
    //   416: getfield 546	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zaU	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   419: invokevirtual 3248	com/tencent/mm/plugin/sns/ui/d/c:deP	()V
    //   422: aload_0
    //   423: aload_0
    //   424: invokevirtual 2402	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   427: ldc_w 3250
    //   430: iconst_0
    //   431: invokevirtual 2410	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   434: putfield 319	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abi	Z
    //   437: aload_0
    //   438: aload_0
    //   439: invokevirtual 2402	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   442: ldc_w 3252
    //   445: invokevirtual 3024	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   448: putfield 321	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abj	Ljava/lang/String;
    //   451: aload_0
    //   452: new 1076	com/tencent/mm/plugin/sns/ui/bo
    //   455: dup
    //   456: aload_0
    //   457: new 72	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$5
    //   460: dup
    //   461: aload_0
    //   462: invokespecial 3253	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$5:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   465: aload_0
    //   466: invokevirtual 577	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   469: aload_0
    //   470: getfield 342	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abu	Lcom/tencent/mm/plugin/sns/model/ah;
    //   473: invokespecial 3256	com/tencent/mm/plugin/sns/ui/bo:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/bo$a;ILcom/tencent/mm/plugin/sns/model/af;)V
    //   476: putfield 1107	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AaW	Lcom/tencent/mm/plugin/sns/ui/bo;
    //   479: invokestatic 3202	java/lang/System:currentTimeMillis	()J
    //   482: lstore_3
    //   483: aload_0
    //   484: invokevirtual 2402	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   487: ldc_w 3258
    //   490: invokevirtual 3262	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   493: astore_1
    //   494: aload_1
    //   495: ifnull +184 -> 679
    //   498: new 459	com/tencent/mm/protocal/protobuf/TimeLineObject
    //   501: dup
    //   502: invokespecial 3263	com/tencent/mm/protocal/protobuf/TimeLineObject:<init>	()V
    //   505: astore 6
    //   507: aload 6
    //   509: aload_1
    //   510: invokevirtual 3267	com/tencent/mm/protocal/protobuf/TimeLineObject:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   513: pop
    //   514: invokestatic 3271	com/tencent/mm/plugin/sns/model/ag:dUe	()Lcom/tencent/mm/plugin/sns/storage/q;
    //   517: new 3273	java/math/BigInteger
    //   520: dup
    //   521: aload 6
    //   523: getfield 2398	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   526: invokespecial 3274	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   529: invokevirtual 3277	java/math/BigInteger:longValue	()J
    //   532: invokevirtual 3283	com/tencent/mm/plugin/sns/storage/q:Ai	(J)Lcom/tencent/mm/plugin/sns/storage/p;
    //   535: ifnonnull +759 -> 1294
    //   538: ldc_w 732
    //   541: ldc_w 3285
    //   544: invokestatic 953	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   547: new 449	com/tencent/mm/plugin/sns/storage/p
    //   550: dup
    //   551: invokespecial 3286	com/tencent/mm/plugin/sns/storage/p:<init>	()V
    //   554: astore_1
    //   555: aload_1
    //   556: new 3273	java/math/BigInteger
    //   559: dup
    //   560: aload 6
    //   562: getfield 2398	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
    //   565: invokespecial 3274	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   568: invokevirtual 3277	java/math/BigInteger:longValue	()J
    //   571: putfield 1612	com/tencent/mm/plugin/sns/storage/p:field_snsId	J
    //   574: aload_1
    //   575: aload 6
    //   577: invokevirtual 3290	com/tencent/mm/protocal/protobuf/TimeLineObject:toByteArray	()[B
    //   580: putfield 3294	com/tencent/mm/plugin/sns/storage/p:field_content	[B
    //   583: aload_1
    //   584: aload 6
    //   586: getfield 2494	com/tencent/mm/protocal/protobuf/TimeLineObject:CreateTime	I
    //   589: putfield 3297	com/tencent/mm/plugin/sns/storage/p:field_createTime	I
    //   592: aload_1
    //   593: aload 6
    //   595: getfield 2096	com/tencent/mm/protocal/protobuf/TimeLineObject:nDo	Ljava/lang/String;
    //   598: putfield 872	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
    //   601: aload_1
    //   602: aload 6
    //   604: getfield 463	com/tencent/mm/protocal/protobuf/TimeLineObject:HAT	Lcom/tencent/mm/protocal/protobuf/abf;
    //   607: getfield 746	com/tencent/mm/protocal/protobuf/abf:GaP	I
    //   610: putfield 3300	com/tencent/mm/plugin/sns/storage/p:field_type	I
    //   613: aload_1
    //   614: invokevirtual 3303	com/tencent/mm/plugin/sns/storage/p:dYH	()V
    //   617: new 527	com/tencent/mm/protocal/protobuf/SnsObject
    //   620: dup
    //   621: invokespecial 3304	com/tencent/mm/protocal/protobuf/SnsObject:<init>	()V
    //   624: astore 6
    //   626: aload 6
    //   628: new 3306	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   631: dup
    //   632: invokespecial 3307	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   635: putfield 3311	com/tencent/mm/protocal/protobuf/SnsObject:ObjectDesc	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   638: aload_1
    //   639: aload 6
    //   641: invokevirtual 3312	com/tencent/mm/protocal/protobuf/SnsObject:toByteArray	()[B
    //   644: putfield 3315	com/tencent/mm/plugin/sns/storage/p:field_attrBuf	[B
    //   647: invokestatic 3271	com/tencent/mm/plugin/sns/model/ag:dUe	()Lcom/tencent/mm/plugin/sns/storage/q;
    //   650: aload_1
    //   651: invokevirtual 3319	com/tencent/mm/plugin/sns/storage/q:insert	(Lcom/tencent/mm/sdk/e/c;)Z
    //   654: pop
    //   655: ldc_w 3321
    //   658: ldc_w 3323
    //   661: iconst_1
    //   662: anewarray 1138	java/lang/Object
    //   665: dup
    //   666: iconst_0
    //   667: invokestatic 3202	java/lang/System:currentTimeMillis	()J
    //   670: lload_3
    //   671: lsub
    //   672: invokestatic 1617	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   675: aastore
    //   676: invokestatic 1527	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   679: aload_0
    //   680: iconst_1
    //   681: invokespecial 447	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:rP	(Z)Lcom/tencent/mm/plugin/sns/storage/p;
    //   684: astore_1
    //   685: ldc_w 732
    //   688: new 859	java/lang/StringBuilder
    //   691: dup
    //   692: ldc_w 3325
    //   695: invokespecial 1394	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   698: aload_0
    //   699: getfield 513	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dzb	Ljava/lang/String;
    //   702: invokevirtual 865	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: ldc_w 3327
    //   708: invokevirtual 865	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: aload_0
    //   712: getfield 854	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AaO	Ljava/lang/String;
    //   715: invokevirtual 865	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: invokevirtual 869	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokestatic 953	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   724: aload_1
    //   725: ifnull +29 -> 754
    //   728: ldc_w 732
    //   731: ldc_w 3329
    //   734: iconst_1
    //   735: anewarray 1138	java/lang/Object
    //   738: dup
    //   739: iconst_0
    //   740: aload_1
    //   741: getfield 872	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
    //   744: ldc_w 299
    //   747: invokestatic 1541	com/tencent/mm/sdk/platformtools/bt:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   750: aastore
    //   751: invokestatic 1527	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   754: aload_0
    //   755: getfield 513	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dzb	Ljava/lang/String;
    //   758: invokestatic 564	com/tencent/mm/plugin/sns/storage/x:aAx	(Ljava/lang/String;)Z
    //   761: ifeq +56 -> 817
    //   764: aload_0
    //   765: getfield 513	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dzb	Ljava/lang/String;
    //   768: invokestatic 3332	com/tencent/mm/plugin/sns/storage/x:axz	(Ljava/lang/String;)Z
    //   771: ifeq +567 -> 1338
    //   774: aload_1
    //   775: ifnull +531 -> 1306
    //   778: aload_1
    //   779: getfield 872	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
    //   782: invokestatic 3337	com/tencent/mm/model/w:zC	(Ljava/lang/String;)Z
    //   785: ifne +32 -> 817
    //   788: invokestatic 1494	com/tencent/mm/kernel/g:ajD	()Lcom/tencent/mm/kernel/g;
    //   791: pop
    //   792: invokestatic 3341	com/tencent/mm/kernel/g:ajB	()Lcom/tencent/mm/kernel/b;
    //   795: getfield 3347	com/tencent/mm/kernel/b:gAO	Lcom/tencent/mm/al/q;
    //   798: new 3349	com/tencent/mm/plugin/sns/model/p
    //   801: dup
    //   802: aload_0
    //   803: getfield 513	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dzb	Ljava/lang/String;
    //   806: invokestatic 3353	com/tencent/mm/plugin/sns/storage/x:axN	(Ljava/lang/String;)J
    //   809: invokespecial 3355	com/tencent/mm/plugin/sns/model/p:<init>	(J)V
    //   812: iconst_0
    //   813: invokevirtual 3360	com/tencent/mm/al/q:a	(Lcom/tencent/mm/al/n;I)Z
    //   816: pop
    //   817: invokestatic 1494	com/tencent/mm/kernel/g:ajD	()Lcom/tencent/mm/kernel/g;
    //   820: pop
    //   821: invokestatic 3341	com/tencent/mm/kernel/g:ajB	()Lcom/tencent/mm/kernel/b;
    //   824: getfield 3347	com/tencent/mm/kernel/b:gAO	Lcom/tencent/mm/al/q;
    //   827: sipush 210
    //   830: aload_0
    //   831: invokevirtual 3363	com/tencent/mm/al/q:a	(ILcom/tencent/mm/al/f;)V
    //   834: invokestatic 1494	com/tencent/mm/kernel/g:ajD	()Lcom/tencent/mm/kernel/g;
    //   837: pop
    //   838: invokestatic 3341	com/tencent/mm/kernel/g:ajB	()Lcom/tencent/mm/kernel/b;
    //   841: getfield 3347	com/tencent/mm/kernel/b:gAO	Lcom/tencent/mm/al/q;
    //   844: sipush 218
    //   847: aload_0
    //   848: invokevirtual 3363	com/tencent/mm/al/q:a	(ILcom/tencent/mm/al/f;)V
    //   851: invokestatic 1494	com/tencent/mm/kernel/g:ajD	()Lcom/tencent/mm/kernel/g;
    //   854: pop
    //   855: invokestatic 3341	com/tencent/mm/kernel/g:ajB	()Lcom/tencent/mm/kernel/b;
    //   858: getfield 3347	com/tencent/mm/kernel/b:gAO	Lcom/tencent/mm/al/q;
    //   861: sipush 213
    //   864: aload_0
    //   865: invokevirtual 3363	com/tencent/mm/al/q:a	(ILcom/tencent/mm/al/f;)V
    //   868: invokestatic 1494	com/tencent/mm/kernel/g:ajD	()Lcom/tencent/mm/kernel/g;
    //   871: pop
    //   872: invokestatic 3341	com/tencent/mm/kernel/g:ajB	()Lcom/tencent/mm/kernel/b;
    //   875: getfield 3347	com/tencent/mm/kernel/b:gAO	Lcom/tencent/mm/al/q;
    //   878: sipush 682
    //   881: aload_0
    //   882: invokevirtual 3363	com/tencent/mm/al/q:a	(ILcom/tencent/mm/al/f;)V
    //   885: invokestatic 1494	com/tencent/mm/kernel/g:ajD	()Lcom/tencent/mm/kernel/g;
    //   888: pop
    //   889: invokestatic 3341	com/tencent/mm/kernel/g:ajB	()Lcom/tencent/mm/kernel/b;
    //   892: getfield 3347	com/tencent/mm/kernel/b:gAO	Lcom/tencent/mm/al/q;
    //   895: sipush 214
    //   898: aload_0
    //   899: invokevirtual 3363	com/tencent/mm/al/q:a	(ILcom/tencent/mm/al/f;)V
    //   902: invokestatic 1494	com/tencent/mm/kernel/g:ajD	()Lcom/tencent/mm/kernel/g;
    //   905: pop
    //   906: invokestatic 3341	com/tencent/mm/kernel/g:ajB	()Lcom/tencent/mm/kernel/b;
    //   909: getfield 3347	com/tencent/mm/kernel/b:gAO	Lcom/tencent/mm/al/q;
    //   912: sipush 683
    //   915: aload_0
    //   916: invokevirtual 3363	com/tencent/mm/al/q:a	(ILcom/tencent/mm/al/f;)V
    //   919: aload_0
    //   920: invokestatic 3366	com/tencent/mm/plugin/sns/model/ag:dTS	()Lcom/tencent/mm/storage/bp;
    //   923: putfield 2715	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AaP	Lcom/tencent/mm/storage/bp;
    //   926: aload_0
    //   927: new 3368	com/tencent/mm/plugin/sns/ui/ay
    //   930: dup
    //   931: aload_0
    //   932: invokespecial 3371	com/tencent/mm/plugin/sns/ui/ay:<init>	(Landroid/app/Activity;)V
    //   935: putfield 1262	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zPi	Lcom/tencent/mm/plugin/sns/ui/ay;
    //   938: aload_0
    //   939: new 751	com/tencent/mm/plugin/sns/ui/bb
    //   942: dup
    //   943: aload_0
    //   944: invokevirtual 691	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getContext	()Landroid/support/v7/app/AppCompatActivity;
    //   947: invokespecial 3372	com/tencent/mm/plugin/sns/ui/bb:<init>	(Landroid/content/Context;)V
    //   950: putfield 553	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AaN	Lcom/tencent/mm/plugin/sns/ui/bb;
    //   953: aload_0
    //   954: new 3374	com/tencent/mm/plugin/sns/ui/j
    //   957: dup
    //   958: aload_0
    //   959: aload_0
    //   960: invokevirtual 577	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   963: aload_0
    //   964: getfield 342	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abu	Lcom/tencent/mm/plugin/sns/model/ah;
    //   967: invokespecial 3377	com/tencent/mm/plugin/sns/ui/j:<init>	(Landroid/app/Activity;ILcom/tencent/mm/plugin/sns/model/af;)V
    //   970: putfield 644	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AaS	Lcom/tencent/mm/plugin/sns/ui/j;
    //   973: aload_0
    //   974: new 3379	com/tencent/mm/plugin/sns/ui/l
    //   977: dup
    //   978: aload_0
    //   979: invokespecial 3382	com/tencent/mm/plugin/sns/ui/l:<init>	(Lcom/tencent/mm/plugin/sns/ui/aa;)V
    //   982: putfield 3384	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AaT	Lcom/tencent/mm/plugin/sns/ui/l;
    //   985: aload_1
    //   986: ifnull +76 -> 1062
    //   989: aload_0
    //   990: aload_1
    //   991: iconst_0
    //   992: invokestatic 1407	com/tencent/mm/plugin/sns/ui/bh:c	(Lcom/tencent/mm/plugin/sns/storage/p;Z)I
    //   995: putfield 549	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oIb	I
    //   998: getstatic 591	com/tencent/mm/plugin/sns/j/e:ztz	Lcom/tencent/mm/plugin/sns/j/e;
    //   1001: invokestatic 3202	java/lang/System:currentTimeMillis	()J
    //   1004: putfield 3387	com/tencent/mm/plugin/sns/j/e:ztW	J
    //   1007: getstatic 591	com/tencent/mm/plugin/sns/j/e:ztz	Lcom/tencent/mm/plugin/sns/j/e;
    //   1010: astore 6
    //   1012: aload_1
    //   1013: ifnull +40 -> 1053
    //   1016: aload_1
    //   1017: getfield 1612	com/tencent/mm/plugin/sns/storage/p:field_snsId	J
    //   1020: invokestatic 3391	com/tencent/mm/plugin/sns/data/q:zx	(J)Ljava/lang/String;
    //   1023: astore 7
    //   1025: aload 6
    //   1027: getfield 3394	com/tencent/mm/plugin/sns/j/e:ztQ	Ljava/util/List;
    //   1030: aload 7
    //   1032: invokeinterface 3397 2 0
    //   1037: ifne +16 -> 1053
    //   1040: aload 6
    //   1042: getfield 3394	com/tencent/mm/plugin/sns/j/e:ztQ	Ljava/util/List;
    //   1045: aload 7
    //   1047: invokeinterface 2070 2 0
    //   1052: pop
    //   1053: getstatic 591	com/tencent/mm/plugin/sns/j/e:ztz	Lcom/tencent/mm/plugin/sns/j/e;
    //   1056: invokestatic 3202	java/lang/System:currentTimeMillis	()J
    //   1059: putfield 3400	com/tencent/mm/plugin/sns/j/e:zud	J
    //   1062: aload_1
    //   1063: ifnull +80 -> 1143
    //   1066: aload_1
    //   1067: bipush 32
    //   1069: invokevirtual 453	com/tencent/mm/plugin/sns/storage/p:QM	(I)Z
    //   1072: ifeq +71 -> 1143
    //   1075: aload_0
    //   1076: getfield 2816	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abl	I
    //   1079: bipush 16
    //   1081: if_icmpne +298 -> 1379
    //   1084: aload_0
    //   1085: new 2320	com/tencent/mm/plugin/sns/ad/d/i
    //   1088: dup
    //   1089: iconst_2
    //   1090: invokespecial 3402	com/tencent/mm/plugin/sns/ad/d/i:<init>	(I)V
    //   1093: putfield 1087	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abd	Lcom/tencent/mm/plugin/sns/ad/d/i;
    //   1096: aload_0
    //   1097: getfield 1087	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abd	Lcom/tencent/mm/plugin/sns/ad/d/i;
    //   1100: aload_0
    //   1101: getfield 3196	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:mScreenHeight	I
    //   1104: aload_0
    //   1105: invokevirtual 3406	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSupportActionBar	()Landroid/support/v7/app/ActionBar;
    //   1108: invokevirtual 3411	android/support/v7/app/ActionBar:getCustomView	()Landroid/view/View;
    //   1111: aload_0
    //   1112: invokevirtual 3414	com/tencent/mm/plugin/sns/ad/d/i:a	(ILandroid/view/View;Landroid/app/Activity;)V
    //   1115: aload_1
    //   1116: iconst_0
    //   1117: invokestatic 1407	com/tencent/mm/plugin/sns/ui/bh:c	(Lcom/tencent/mm/plugin/sns/storage/p;Z)I
    //   1120: pop
    //   1121: aload_0
    //   1122: getfield 546	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zaU	Lcom/tencent/mm/plugin/sns/ui/d/c;
    //   1125: aload_0
    //   1126: getfield 1087	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abd	Lcom/tencent/mm/plugin/sns/ad/d/i;
    //   1129: invokevirtual 3417	com/tencent/mm/plugin/sns/ui/d/c:b	(Lcom/tencent/mm/plugin/sns/ad/d/i;)V
    //   1132: aload_0
    //   1133: getfield 1266	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zPo	Lcom/tencent/mm/plugin/sns/ui/b;
    //   1136: aload_0
    //   1137: getfield 1087	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abd	Lcom/tencent/mm/plugin/sns/ad/d/i;
    //   1140: putfield 3420	com/tencent/mm/plugin/sns/ui/b:zbv	Lcom/tencent/mm/plugin/sns/ad/d/i;
    //   1143: aload_0
    //   1144: invokevirtual 3422	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:initView	()V
    //   1147: aload_1
    //   1148: ifnull +49 -> 1197
    //   1151: aload_1
    //   1152: bipush 32
    //   1154: invokevirtual 453	com/tencent/mm/plugin/sns/storage/p:QM	(I)Z
    //   1157: ifeq +40 -> 1197
    //   1160: aload_1
    //   1161: invokestatic 525	com/tencent/mm/plugin/sns/model/ak:u	(Lcom/tencent/mm/plugin/sns/storage/p;)Lcom/tencent/mm/protocal/protobuf/SnsObject;
    //   1164: astore 6
    //   1166: aload_0
    //   1167: getfield 1087	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abd	Lcom/tencent/mm/plugin/sns/ad/d/i;
    //   1170: iconst_0
    //   1171: aload_1
    //   1172: invokevirtual 916	com/tencent/mm/plugin/sns/storage/p:dYK	()Ljava/lang/String;
    //   1175: aload_1
    //   1176: invokevirtual 3425	com/tencent/mm/plugin/sns/storage/p:dYG	()Z
    //   1179: aload_0
    //   1180: getfield 1369	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Aay	Landroid/view/View;
    //   1183: aload_1
    //   1184: getfield 1612	com/tencent/mm/plugin/sns/storage/p:field_snsId	J
    //   1187: aload 6
    //   1189: aload_0
    //   1190: getfield 549	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oIb	I
    //   1193: iconst_2
    //   1194: invokevirtual 3428	com/tencent/mm/plugin/sns/ad/d/i:a	(ILjava/lang/String;ZLandroid/view/View;JLcom/tencent/mm/protocal/protobuf/SnsObject;II)V
    //   1197: aload_0
    //   1198: getfield 1369	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Aay	Landroid/view/View;
    //   1201: ifnull +79 -> 1280
    //   1204: aload_1
    //   1205: ifnull +75 -> 1280
    //   1208: aload_0
    //   1209: getfield 1369	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Aay	Landroid/view/View;
    //   1212: ldc_w 2134
    //   1215: invokevirtual 1409	android/view/View:findViewById	(I)Landroid/view/View;
    //   1218: checkcast 3430	com/tencent/mm/plugin/sight/decode/a/a
    //   1221: astore 6
    //   1223: aload_1
    //   1224: invokevirtual 457	com/tencent/mm/plugin/sns/storage/p:dYl	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1227: getfield 463	com/tencent/mm/protocal/protobuf/TimeLineObject:HAT	Lcom/tencent/mm/protocal/protobuf/abf;
    //   1230: ifnull +339 -> 1569
    //   1233: aload_1
    //   1234: invokevirtual 457	com/tencent/mm/plugin/sns/storage/p:dYl	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
    //   1237: getfield 463	com/tencent/mm/protocal/protobuf/TimeLineObject:HAT	Lcom/tencent/mm/protocal/protobuf/abf;
    //   1240: getfield 746	com/tencent/mm/protocal/protobuf/abf:GaP	I
    //   1243: bipush 15
    //   1245: if_icmpne +324 -> 1569
    //   1248: aload 6
    //   1250: instanceof 2236
    //   1253: ifeq +316 -> 1569
    //   1256: aload 6
    //   1258: checkcast 2236	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView
    //   1261: getfield 3434	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView:ySq	Lcom/tencent/mm/plugin/sight/decode/a/b;
    //   1264: invokevirtual 3439	com/tencent/mm/plugin/sight/decode/a/b:dQc	()Z
    //   1267: istore 5
    //   1269: aload_1
    //   1270: iconst_1
    //   1271: iload 5
    //   1273: aload_0
    //   1274: invokevirtual 577	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   1277: invokestatic 3444	com/tencent/mm/plugin/sns/ad/d/m:a	(Lcom/tencent/mm/plugin/sns/storage/p;ZZI)V
    //   1280: aload_0
    //   1281: getfield 674	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AaC	Landroid/widget/ListView;
    //   1284: ifnonnull +110 -> 1394
    //   1287: ldc_w 3131
    //   1290: invokestatic 270	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1293: return
    //   1294: ldc_w 732
    //   1297: ldc_w 3446
    //   1300: invokestatic 953	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1303: goto -624 -> 679
    //   1306: invokestatic 1494	com/tencent/mm/kernel/g:ajD	()Lcom/tencent/mm/kernel/g;
    //   1309: pop
    //   1310: invokestatic 3341	com/tencent/mm/kernel/g:ajB	()Lcom/tencent/mm/kernel/b;
    //   1313: getfield 3347	com/tencent/mm/kernel/b:gAO	Lcom/tencent/mm/al/q;
    //   1316: new 3349	com/tencent/mm/plugin/sns/model/p
    //   1319: dup
    //   1320: aload_0
    //   1321: getfield 513	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dzb	Ljava/lang/String;
    //   1324: invokestatic 3353	com/tencent/mm/plugin/sns/storage/x:axN	(Ljava/lang/String;)J
    //   1327: invokespecial 3355	com/tencent/mm/plugin/sns/model/p:<init>	(J)V
    //   1330: iconst_0
    //   1331: invokevirtual 3360	com/tencent/mm/al/q:a	(Lcom/tencent/mm/al/n;I)Z
    //   1334: pop
    //   1335: goto -518 -> 817
    //   1338: invokestatic 1494	com/tencent/mm/kernel/g:ajD	()Lcom/tencent/mm/kernel/g;
    //   1341: pop
    //   1342: invokestatic 3341	com/tencent/mm/kernel/g:ajB	()Lcom/tencent/mm/kernel/b;
    //   1345: getfield 3347	com/tencent/mm/kernel/b:gAO	Lcom/tencent/mm/al/q;
    //   1348: new 3448	com/tencent/mm/plugin/sns/model/l
    //   1351: dup
    //   1352: aload_0
    //   1353: getfield 513	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:dzb	Ljava/lang/String;
    //   1356: invokestatic 3353	com/tencent/mm/plugin/sns/storage/x:axN	(Ljava/lang/String;)J
    //   1359: iconst_0
    //   1360: aload_0
    //   1361: aload_1
    //   1362: invokespecial 680	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:f	(Lcom/tencent/mm/plugin/sns/storage/p;)Lcom/tencent/mm/plugin/sns/storage/a;
    //   1365: getfield 3451	com/tencent/mm/plugin/sns/storage/a:zuY	Ljava/lang/String;
    //   1368: invokespecial 3454	com/tencent/mm/plugin/sns/model/l:<init>	(JILjava/lang/String;)V
    //   1371: iconst_0
    //   1372: invokevirtual 3360	com/tencent/mm/al/q:a	(Lcom/tencent/mm/al/n;I)Z
    //   1375: pop
    //   1376: goto -559 -> 817
    //   1379: aload_0
    //   1380: new 2320	com/tencent/mm/plugin/sns/ad/d/i
    //   1383: dup
    //   1384: iconst_1
    //   1385: invokespecial 3402	com/tencent/mm/plugin/sns/ad/d/i:<init>	(I)V
    //   1388: putfield 1087	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abd	Lcom/tencent/mm/plugin/sns/ad/d/i;
    //   1391: goto -295 -> 1096
    //   1394: aload_0
    //   1395: getfield 674	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AaC	Landroid/widget/ListView;
    //   1398: new 74	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$6
    //   1401: dup
    //   1402: aload_0
    //   1403: invokespecial 3455	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$6:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   1406: invokevirtual 3456	android/widget/ListView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1409: aload_0
    //   1410: new 3458	com/tencent/mm/plugin/sns/ui/n
    //   1413: dup
    //   1414: aload_0
    //   1415: invokespecial 3459	com/tencent/mm/plugin/sns/ui/n:<init>	(Landroid/content/Context;)V
    //   1418: putfield 333	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abq	Lcom/tencent/mm/plugin/sns/ui/n;
    //   1421: aload_1
    //   1422: ifnull +34 -> 1456
    //   1425: aload_0
    //   1426: getfield 1238	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:fFK	Ljava/lang/String;
    //   1429: aload_1
    //   1430: getfield 872	com/tencent/mm/plugin/sns/storage/p:field_userName	Ljava/lang/String;
    //   1433: invokestatic 1721	com/tencent/mm/sdk/platformtools/bt:lQ	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1436: ifeq +20 -> 1456
    //   1439: aload_0
    //   1440: iconst_0
    //   1441: ldc_w 3460
    //   1444: new 76	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7
    //   1447: dup
    //   1448: aload_0
    //   1449: aload_1
    //   1450: invokespecial 3461	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$7:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;Lcom/tencent/mm/plugin/sns/storage/p;)V
    //   1453: invokevirtual 3465	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:addIconOptionMenu	(IILandroid/view/MenuItem$OnMenuItemClickListener;)V
    //   1456: getstatic 3016	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   1459: aload_0
    //   1460: getfield 387	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:kwD	Lcom/tencent/mm/sdk/b/c;
    //   1463: invokevirtual 3468	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1466: pop
    //   1467: getstatic 3016	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   1470: aload_0
    //   1471: getfield 347	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abv	Lcom/tencent/mm/sdk/b/c;
    //   1474: invokevirtual 3468	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1477: pop
    //   1478: getstatic 3016	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   1481: aload_0
    //   1482: getfield 350	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abw	Lcom/tencent/mm/sdk/b/c;
    //   1485: invokevirtual 3468	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1488: pop
    //   1489: getstatic 3016	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   1492: aload_0
    //   1493: getfield 353	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Abx	Lcom/tencent/mm/sdk/b/c;
    //   1496: invokevirtual 3468	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1499: pop
    //   1500: getstatic 3016	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   1503: aload_0
    //   1504: getfield 358	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:Aby	Lcom/tencent/mm/sdk/b/c;
    //   1507: invokevirtual 3468	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1510: pop
    //   1511: getstatic 3016	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   1514: aload_0
    //   1515: getfield 382	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AbC	Lcom/tencent/mm/sdk/b/c;
    //   1518: invokevirtual 3468	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1521: pop
    //   1522: getstatic 3016	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   1525: aload_0
    //   1526: getfield 392	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:AbD	Lcom/tencent/mm/sdk/b/c;
    //   1529: invokevirtual 3468	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1532: pop
    //   1533: getstatic 3016	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   1536: aload_0
    //   1537: getfield 361	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:zPv	Lcom/tencent/mm/sdk/b/c;
    //   1540: invokevirtual 3468	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1543: pop
    //   1544: aload_0
    //   1545: invokestatic 3470	com/tencent/mm/pluginsdk/h:r	(Lcom/tencent/mm/ui/MMActivity;)V
    //   1548: ldc_w 3131
    //   1551: invokestatic 270	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    com.tencent.mm.plugin.sns.model.ag.dTU().a(this, 5);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(210, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(218, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(213, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(214, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(683, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(682, this);
    com.tencent.mm.plugin.sns.model.ag.dUb().aD(this);
    com.tencent.mm.sdk.b.a.IbL.d(this.kwD);
    if (this.AaS != null) {
      this.AaS.activity = null;
    }
    ae.dZZ();
    if (this.zPg != null) {
      this.zPg.ebV();
    }
    com.tencent.mm.plugin.sns.storage.p localp = rP(false);
    Object localObject;
    if ((localp != null) && (localp.QM(32)))
    {
      if (this.Abd != null) {
        this.Abd.a(0, localp.dYK(), localp.field_snsId, 2);
      }
      localObject = f(localp);
      if (localObject != null) {
        break label614;
      }
      localObject = "";
      if (!localp.dWk()) {
        break label622;
      }
      com.tencent.mm.plugin.sns.model.ag.dTY().f(14652, new Object[] { com.tencent.mm.plugin.sns.ad.d.h.a(localp.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.q.zw(localp.field_snsId), localObject, Long.valueOf(this.Aaw), Long.valueOf(System.currentTimeMillis()) }) });
    }
    for (;;)
    {
      com.tencent.mm.modelsns.e locale = com.tencent.mm.modelsns.e.pW(732);
      locale.Gs(com.tencent.mm.plugin.sns.data.q.zw(localp.field_snsId)).Gs((String)localObject).Gs(this.Aaw).Gs(System.currentTimeMillis());
      locale.aLk();
      this.zaU.removeListener();
      com.tencent.mm.sdk.b.a.IbL.d(this.Abv);
      com.tencent.mm.sdk.b.a.IbL.d(this.Abw);
      com.tencent.mm.sdk.b.a.IbL.d(this.Abx);
      com.tencent.mm.sdk.b.a.IbL.d(this.Aby);
      com.tencent.mm.sdk.b.a.IbL.d(this.AbC);
      com.tencent.mm.sdk.b.a.IbL.d(this.AbD);
      com.tencent.mm.sdk.b.a.IbL.d(this.zPv);
      super.onDestroy();
      localObject = com.tencent.mm.plugin.sns.j.e.ztz;
      if (((com.tencent.mm.plugin.sns.j.e)localObject).ztW != 0L)
      {
        ((com.tencent.mm.plugin.sns.j.e)localObject).ztX += System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.j.e)localObject).ztW;
        ((com.tencent.mm.plugin.sns.j.e)localObject).ztW = 0L;
      }
      localObject = com.tencent.mm.plugin.sns.j.e.ztz;
      if (((com.tencent.mm.plugin.sns.j.e)localObject).zud != 0L)
      {
        ((com.tencent.mm.plugin.sns.j.e)localObject).zue += System.currentTimeMillis() - ((com.tencent.mm.plugin.sns.j.e)localObject).zud;
        ((com.tencent.mm.plugin.sns.j.e)localObject).zud = 0L;
      }
      if ((this.Abm) && (localp != null) && (localp.dYl() != null) && (localp.dYl().HAT != null))
      {
        localObject = com.tencent.mm.plugin.sns.j.e.ztz.dVJ();
        ((ew)localObject).eca = com.tencent.mm.plugin.sns.j.e.ztz.ztL.eca;
        ((ew)localObject).od(com.tencent.mm.plugin.sns.j.e.ztz.ztL.ekv).oe(com.tencent.mm.plugin.sns.data.q.zx(localp.field_snsId)).dUX = localp.dYl().HAT.GaP;
        com.tencent.mm.plugin.sns.j.e.ztz.dVO();
      }
      AppMethodBeat.o(98596);
      return;
      label614:
      localObject = ((com.tencent.mm.plugin.sns.storage.a)localObject).dFy;
      break;
      label622:
      com.tencent.mm.plugin.sns.model.ag.dTY().f(12012, new Object[] { com.tencent.mm.plugin.sns.ad.d.h.a(localp.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.q.zw(localp.field_snsId), localObject, Long.valueOf(this.Aaw), Long.valueOf(System.currentTimeMillis()) }) });
    }
  }
  
  public void onKeyboardStateChanged()
  {
    AppMethodBeat.i(98612);
    if (keyboardState() == 2)
    {
      ad.i("MicroMsg.SnsCommentDetailUI", "keybaordhide! ");
      this.AaM = false;
      AppMethodBeat.o(98612);
      return;
    }
    if (keyboardState() == 1)
    {
      ad.i("MicroMsg.SnsCommentDetailUI", "keybaordShow");
      ebL();
      this.zPd = false;
      this.AbA.run();
      if (this.zPo != null) {
        this.zPo.dVw();
      }
    }
    AppMethodBeat.o(98612);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98598);
    com.tencent.mm.plugin.sns.model.ag.dTZ().b(this);
    try
    {
      com.tencent.mm.sdk.platformtools.bh.a(this, null);
      this.zXO = false;
      super.onPause();
      this.zPg.fLP.hideVKB();
      Object localObject = this.zPg;
      if (((SnsCommentFooter)localObject).pWJ != null) {
        ((SnsCommentFooter)localObject).pWJ.onPause();
      }
      new xc().dLv.type = 1;
      try
      {
        if ((this.Abh) && (this.Aay != null))
        {
          localObject = rP(false);
          if ((localObject != null) && (((com.tencent.mm.plugin.sns.storage.p)localObject).QM(32)))
          {
            localVideoSightView = (VideoSightView)this.Aay.findViewById(2131300914);
            SnsAdTimelineVideoView localSnsAdTimelineVideoView = (SnsAdTimelineVideoView)this.Aay.findViewById(2131308163);
            if (!a((com.tencent.mm.plugin.sns.storage.p)localObject, localSnsAdTimelineVideoView)) {
              break label246;
            }
            if ((localSnsAdTimelineVideoView.isPlaying()) && (localSnsAdTimelineVideoView.getVisibility() == 0))
            {
              ad.i("MicroMsg.SnsCommentDetailUI", "new video vie pauseNormalVideoAd");
              com.tencent.mm.plugin.sns.ad.timeline.a.c.c(localSnsAdTimelineVideoView);
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          VideoSightView localVideoSightView;
          ad.e("MicroMsg.SnsCommentDetailUI", "pauseNormalVideoAd, exp=" + localThrowable2.toString());
        }
      }
      if (this.Abd != null)
      {
        this.Abd.onPause();
        localObject = rP(false);
        if ((localObject != null) && (((com.tencent.mm.plugin.sns.storage.p)localObject).QM(32))) {
          this.Abd.zq(((com.tencent.mm.plugin.sns.storage.p)localObject).field_snsId);
        }
      }
      if (this.Abc != null) {
        this.Abc.onPause();
      }
      AppMethodBeat.o(98598);
      return;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        ad.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable1.toString());
        continue;
        label246:
        if ((localVideoSightView.isPlaying()) && (localVideoSightView.getVisibility() == 0))
        {
          ad.i("MicroMsg.SnsCommentDetailUI", "pauseNormalVideoAd");
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
      if (!this.zXO)
      {
        ad.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onResume callback");
        com.tencent.mm.sdk.platformtools.bh.a(this, this.zYD);
        this.zXO = true;
      }
      com.tencent.mm.plugin.sns.model.ag.dTZ().a(this);
      localObject = new xc();
      ((xc)localObject).dLv.dLw = 0;
      ((xc)localObject).dLv.dLx = 1;
      ((xc)localObject).dLv.dLy = 0;
      ((xc)localObject).dLv.type = 0;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      if (this.Abd != null) {
        this.Abd.onResume();
      }
      if (this.Abc != null) {
        this.Abc.refreshView();
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
          if ((this.Abh) && (this.Aay != null))
          {
            ad.i("MicroMsg.SnsCommentDetailUI", "new video vie resumeNormalVideoAd called");
            localObject = (SnsAdTimelineVideoView)this.Aay.findViewById(2131308163);
            if (a(rP(false), (SnsAdTimelineVideoView)localObject))
            {
              com.tencent.mm.plugin.sns.ad.timeline.a.c.b((SnsAdTimelineVideoView)localObject);
              ad.i("MicroMsg.SnsCommentDetailUI", "new video vie resumeNormalVideoAd");
            }
          }
          AppMethodBeat.o(98597);
          return;
        }
        catch (Throwable localThrowable2)
        {
          ad.e("MicroMsg.SnsCommentDetailUI", "resumeNormalVideoAd, exp=" + localThrowable2.toString());
          AppMethodBeat.o(98597);
        }
        localThrowable1 = localThrowable1;
        ad.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable1.toString());
      }
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(98611);
    if ((paramn.getType() == 218) && (this.zPt != null)) {
      this.zPt.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((this.Abq != null) && (this.Abq.tipDialog != null) && (this.Abq.tipDialog.isShowing())) {
        this.Abq.tipDialog.dismiss();
      }
      paramn = com.tencent.mm.plugin.sns.storage.h.azZ(this.dzb);
      if (paramn == null)
      {
        ad.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.dzb);
        finish();
        AppMethodBeat.o(98611);
        return;
      }
      ad.d("MicroMsg.SnsCommentDetailUI", "snsId: " + this.dzb + "  username:" + paramn.field_userName);
      if (this.Aay == null)
      {
        ad.e("MicroMsg.SnsCommentDetailUI", "fatal error! Sns onSceneEnd before initView and infoHeader is null!");
        finish();
        AppMethodBeat.o(98611);
        return;
      }
      ebK();
      b(paramn, false);
      paramString = ak.u(paramn);
      ad.i("MicroMsg.SnsCommentDetailUI", "onsceneend " + paramString.LikeUserList.size() + " " + paramString.CommentUserList.size());
      if (paramString == null)
      {
        AppMethodBeat.o(98611);
        return;
      }
      if (!f(this.AaK, paramString.LikeUserList))
      {
        j(paramString.LikeUserList, paramString.CommentUserList.isEmpty());
        this.AaK = paramString.LikeUserList;
      }
      if (this.AaB != null) {
        this.AaB.a(paramn, this.zaU);
      }
      if (!paramn.QM(32)) {
        ak.c(paramn, paramString);
      }
      paramn = this.AaF;
      LinkedList localLinkedList = paramString.CommentUserList;
      paramString = paramString.LikeUserList;
      paramn.commentList = localLinkedList;
      paramn.Ach = paramString;
      this.AaF.notifyDataSetChanged();
      paramString = this.AaF;
      new ap().postDelayed(new SnsCommentDetailUI.b.1(paramString), 60L);
    }
    AppMethodBeat.o(98611);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(198340);
    super.onWindowFocusChanged(paramBoolean);
    ad.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    try
    {
      com.tencent.mm.sdk.platformtools.bh.a(this, null);
      this.zXO = false;
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(198340);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "hasFocus = ".concat(String.valueOf(paramBoolean)));
      ad.e("MicroMsg.SnsCommentDetailUI.ScreenShot", localThrowable.toString());
      AppMethodBeat.at(this, paramBoolean);
      AppMethodBeat.o(198340);
    }
    if (!this.zXO)
    {
      ad.i("MicroMsg.SnsCommentDetailUI.ScreenShot", "onWindowFocusChanged callback");
      com.tencent.mm.sdk.platformtools.bh.a(this, this.zYD);
      this.zXO = true;
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(198340);
    return;
  }
  
  final class a
    extends com.tencent.mm.pluginsdk.ui.span.p
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(98583);
      SnsCommentDetailUI.j(SnsCommentDetailUI.this).Aqa.onClick(paramView);
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
    LinkedList<dfn> Ach;
    Activity activity;
    public LinkedList<dfn> commentList;
    String doX;
    
    public b(LinkedList<dfn> paramLinkedList, Activity paramActivity, String paramString)
    {
      this.commentList = paramLinkedList;
      this.Ach = paramActivity;
      this.activity = paramString;
      Object localObject;
      this.doX = localObject;
    }
    
    public final int getCount()
    {
      int i = 0;
      AppMethodBeat.i(98587);
      if (this.Ach.size() > 0)
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
      if (this.Ach.size() > 0)
      {
        if (paramInt == 0)
        {
          paramView = SnsCommentDetailUI.K(SnsCommentDetailUI.this);
          AppMethodBeat.o(98588);
          return paramView;
        }
        i = paramInt - 1;
      }
      Object localObject3 = (dfn)this.commentList.get(i);
      ((dfn)localObject3).hDa = bt.nullAsNil(((dfn)localObject3).hDa);
      View localView;
      if ((paramView == null) || (!(paramView.getTag() instanceof a)))
      {
        localView = z.jO(this.activity).inflate(2131495539, null);
        localView.setOnTouchListener(SnsCommentDetailUI.L(SnsCommentDetailUI.this));
        paramViewGroup = new a();
        paramViewGroup.fOf = ((ImageView)localView.findViewById(2131296547));
        paramViewGroup.fOf.setOnClickListener(SnsCommentDetailUI.M(SnsCommentDetailUI.this));
        paramViewGroup.jhg = ((TextView)localView.findViewById(2131296559));
        paramViewGroup.jhg.setOnTouchListener(new ae());
        paramViewGroup.jhg.setOnClickListener(new SnsCommentDetailUI.b.2(this));
        paramViewGroup.timeTv = ((TextView)localView.findViewById(2131296562));
        paramViewGroup.hca = ((TextView)localView.findViewById(2131296551));
        paramViewGroup.Acj = ((FrameLayout)localView.findViewById(2131296550));
        paramViewGroup.hca.setOnTouchListener(new ae());
        paramViewGroup.Ack = ((SnsTranslateResultView)localView.findViewById(2131305091));
        paramViewGroup.Ack.setVisibility(8);
        paramViewGroup.Acm = ((EmojiStatusView)localView.findViewById(2131296552));
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
        paramViewGroup.Acl = ((dfn)localObject3);
        paramViewGroup.userName = ((dfn)localObject3).Username;
        ((SnsAvatarImageView)paramViewGroup.fOf).fe(((dfn)localObject3).Username, 3);
        ((SnsAvatarImageView)paramViewGroup.fOf).setWeakContext(this.activity);
        label366:
        com.tencent.mm.plugin.sns.storage.p localp;
        if (SnsCommentDetailUI.F(SnsCommentDetailUI.this) == 10)
        {
          paramInt = 3;
          SnsCommentDetailUI.F(SnsCommentDetailUI.this);
          com.tencent.mm.kernel.g.ajD();
          paramView = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTj(paramViewGroup.userName);
          if ((i != 0) || (!this.Ach.isEmpty())) {
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
          localp = com.tencent.mm.plugin.sns.storage.h.azZ(SnsCommentDetailUI.o(SnsCommentDetailUI.this));
          paramViewGroup.fOf.setTag(((dfn)localObject3).Username);
          if (!com.tencent.mm.plugin.sns.ui.widget.e.a(paramViewGroup.fOf, localp, ((dfn)localObject3).Username)) {
            a.b.w(paramViewGroup.fOf, ((dfn)localObject3).Username);
          }
          if (paramView == null) {
            break label1670;
          }
          paramView = paramView.adv();
          if (!com.tencent.mm.plugin.sns.ui.widget.e.b(localp, ((dfn)localObject3).Username)) {
            break label1943;
          }
          paramView = com.tencent.mm.plugin.sns.ui.widget.e.b(localp.dRL(), paramView);
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
            paramViewGroup.hca.setText(((dfn)localObject3).hDa + " ");
            localCharSequence = com.tencent.mm.plugin.sns.ui.widget.e.a(SnsCommentDetailUI.this, (dfn)localObject3, SnsCommentDetailUI.N(SnsCommentDetailUI.this), localp.field_type, localp.field_userName, 2, SnsCommentDetailUI.O(SnsCommentDetailUI.this), SnsCommentDetailUI.P(SnsCommentDetailUI.this), localp);
            localObject2 = null;
            localObject1 = localObject2;
            if (!bt.hj(((dfn)localObject3).HtM))
            {
              localObject1 = localObject2;
              if (((dfn)localObject3).HtM.get(0) != null)
              {
                localObject1 = ((dft)((dfn)localObject3).HtM.get(0)).Md5;
                localObject1 = com.tencent.mm.storage.bd.frc().ILn.aUK((String)localObject1);
              }
            }
            if (localObject1 != null) {
              break label1696;
            }
            paramViewGroup.Acm.setVisibility(8);
            paramViewGroup.Acm.setEmojiInfo(null);
            paramViewGroup.jhg.setText(paramView, TextView.BufferType.SPANNABLE);
            com.tencent.mm.pluginsdk.ui.span.k.n(paramViewGroup.jhg, paramInt);
            localObject1 = new com.tencent.mm.pluginsdk.ui.span.l(paramViewGroup.jhg.getText());
            ad.i("MicroMsg.SnsCommentDetailUI", "test %s,%s", new Object[] { ((dfn)localObject3).Username, paramView });
            if (!com.tencent.mm.plugin.sns.ui.widget.e.b(localp, ((dfn)localObject3).Username)) {
              break label1790;
            }
            if (!com.tencent.mm.plugin.sns.ui.widget.e.ia(((dfn)localObject3).HtL, 32)) {
              break label1784;
            }
            j = 27;
            ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).a(new com.tencent.mm.pluginsdk.ui.span.p(new com.tencent.mm.plugin.sns.data.a(localp.QM(32), ((dfn)localObject3).Username, localp.dYK(), 2, j), SnsCommentDetailUI.N(SnsCommentDetailUI.this), paramInt), paramView);
            paramViewGroup.jhg.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
            l = ((dfn)localObject3).CreateTime;
            if (com.tencent.mm.plugin.sns.ui.widget.e.ia(((dfn)localObject3).HtL, 32)) {
              l = localp.field_createTime;
            }
            paramViewGroup.timeTv.setText(bj.q(this.activity, l * 1000L));
            if (!bt.ai(localCharSequence)) {
              break label1819;
            }
            paramViewGroup.hca.setVisibility(8);
            SnsCommentDetailUI.Q(SnsCommentDetailUI.this).c(localView, SnsCommentDetailUI.E(SnsCommentDetailUI.this).AyD, SnsCommentDetailUI.E(SnsCommentDetailUI.this).Ayq);
            SnsCommentDetailUI.Q(SnsCommentDetailUI.this).c(paramViewGroup.Acj, SnsCommentDetailUI.E(SnsCommentDetailUI.this).AyD, SnsCommentDetailUI.E(SnsCommentDetailUI.this).Ayq);
            if (((dfn)localObject3).HtH == 0) {
              break label1862;
            }
            l = ((dfn)localObject3).HtH;
            localObject2 = ar.jp(SnsCommentDetailUI.o(SnsCommentDetailUI.this), String.valueOf(l));
            if ((ar.eV((String)localObject2, 4)) && (paramViewGroup.Ack != null))
            {
              localObject2 = ar.azc((String)localObject2);
              if (localObject2 == null) {
                break label1895;
              }
              paramViewGroup.Ack.setVisibility(0);
              if (!((ar.b)localObject2).hII) {
                break label1884;
              }
              if (((ar.b)localObject2).aGQ) {
                break label1872;
              }
              paramViewGroup.Ack.a((ar.b)localObject2, 2, ((ar.b)localObject2).result, ((ar.b)localObject2).hQG, ((ar.b)localObject2).zlQ);
            }
            localView.setClickable(true);
            ad.d("MicroMsg.SnsCommentDetailUI", "position " + ((dfn)localObject3).Username + " self " + SnsCommentDetailUI.t(SnsCommentDetailUI.this) + " commentid " + ((dfn)localObject3).HtH + " snsid " + SnsCommentDetailUI.o(SnsCommentDetailUI.this));
            if (!SnsCommentDetailUI.t(SnsCommentDetailUI.this).equals(((dfn)localObject3).Username)) {
              break label1907;
            }
          }
          label1645:
          label1907:
          for (paramViewGroup.info = localObject3;; paramViewGroup.info = new Object[] { Integer.valueOf(i), localObject3, ((dfn)localObject3).Username, paramView })
          {
            paramView = new m(SnsCommentDetailUI.k(SnsCommentDetailUI.this), SnsCommentDetailUI.o(SnsCommentDetailUI.this), (dfn)localObject3, ((dfn)localObject3).Username, ((dfn)localObject3).hDa, paramViewGroup.hca, 2, str);
            paramView.tag = paramViewGroup;
            localView.setTag(paramView);
            paramViewGroup.hca.setTag(paramView);
            localView.setOnClickListener(SnsCommentDetailUI.R(SnsCommentDetailUI.this));
            paramViewGroup.hca.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(SnsCommentDetailUI.this));
            paramViewGroup.Acj.setTag(paramView);
            paramViewGroup.Acj.setOnClickListener(SnsCommentDetailUI.R(SnsCommentDetailUI.this));
            if ((!localp.QM(32)) && (((dfn)localObject3).DeleteFlag > 0))
            {
              ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).setSpan(new ForegroundColorSpan(SnsCommentDetailUI.this.getContext().getResources().getColor(2131099676)), 0, ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).length(), 33);
              paramViewGroup.jhg.setText((CharSequence)localObject1);
              paramView = paramViewGroup.hca;
              localObject1 = SnsCommentDetailUI.this.getContext();
              localObject2 = ((Context)localObject1).getResources().getString(2131766982);
              localObject3 = new SpannableStringBuilder((CharSequence)localObject2);
              ((SpannableStringBuilder)localObject3).setSpan(new ForegroundColorSpan(((Context)localObject1).getResources().getColor(2131099676)), 0, ((String)localObject2).length(), 0);
              ((SpannableStringBuilder)localObject3).setSpan(new BackgroundColorSpan(((Context)localObject1).getResources().getColor(2131099678)), 0, ((String)localObject2).length(), 0);
              paramView.setText((CharSequence)localObject3);
              paramViewGroup.hca.setOnTouchListener(null);
              paramViewGroup.Acj.setOnLongClickListener(null);
              paramViewGroup.Acj.setOnClickListener(null);
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
            if (((dfn)localObject3).Nickname != null)
            {
              paramView = ((dfn)localObject3).Nickname;
              break label552;
            }
            paramView = ((dfn)localObject3).Username;
            break label552;
            localObject2 = new m(SnsCommentDetailUI.k(SnsCommentDetailUI.this), SnsCommentDetailUI.o(SnsCommentDetailUI.this), (dfn)localObject3, ((dfn)localObject3).Username, ((dfn)localObject3).hDa, paramViewGroup.hca, 2, str);
            paramViewGroup.Acm.setTag(localObject2);
            paramViewGroup.Acm.setVisibility(0);
            paramViewGroup.Acm.setEmojiInfo((EmojiInfo)localObject1);
            paramViewGroup.Acm.setOnClickListener(SnsCommentDetailUI.E(SnsCommentDetailUI.this).AyW);
            break label749;
            label1784:
            j = 2;
            break label840;
            label1790:
            ((com.tencent.mm.pluginsdk.ui.span.l)localObject1).a(new com.tencent.mm.pluginsdk.ui.span.p(((dfn)localObject3).Username, SnsCommentDetailUI.N(SnsCommentDetailUI.this), paramInt), paramView);
            break label888;
            localObject2 = new SpannableStringBuilder(localCharSequence);
            ((SpannableStringBuilder)localObject2).append(" ");
            paramViewGroup.hca.setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
            paramViewGroup.hca.setVisibility(0);
            break label979;
            l = ((dfn)localObject3).HtJ;
            break label1061;
            paramViewGroup.Ack.setVisibility(8);
            break label1155;
            paramViewGroup.Ack.Rt(2);
            break label1155;
            paramViewGroup.Ack.setVisibility(8);
            break label1155;
          }
        }
      }
    }
    
    final class a
    {
      FrameLayout Acj;
      SnsTranslateResultView Ack;
      dfn Acl;
      EmojiStatusView Acm;
      ImageView fOf;
      TextView hca;
      Object info;
      TextView jhg;
      TextView timeTv;
      String userName;
      
      a() {}
    }
  }
  
  final class c
    implements OfflineVideoView.a
  {
    private com.tencent.mm.plugin.sns.storage.p yXF;
    private SnsAdTimelineVideoView zWz;
    
    c(com.tencent.mm.plugin.sns.storage.p paramp, SnsAdTimelineVideoView paramSnsAdTimelineVideoView)
    {
      this.yXF = paramp;
      this.zWz = paramSnsAdTimelineVideoView;
    }
    
    public final boolean a(PString paramPString)
    {
      return false;
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(198338);
      ad.i("MicroMsg.SnsCommentDetailUI", "the detail new video player onCompletion return value is ");
      if ((SnsCommentDetailUI.f(SnsCommentDetailUI.this) == null) || (this.yXF == null) || (this.zWz == null))
      {
        ad.w("MicroMsg.SnsCommentDetailUI", "the snsAdStatistic or snsInfo is null in onCompletion!!!");
        AppMethodBeat.o(198338);
        return;
      }
      this.zWz.restart();
      SnsCommentDetailUI.f(SnsCommentDetailUI.this).A(this.yXF.field_snsId, false);
      AppMethodBeat.o(198338);
    }
    
    public final void onStart(int paramInt)
    {
      AppMethodBeat.i(198337);
      ad.i("MicroMsg.SnsCommentDetailUI", "the detail new video player onStart called,  durationSecond = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(198337);
    }
    
    public final void tt(int paramInt)
    {
      AppMethodBeat.i(198339);
      ad.i("MicroMsg.SnsCommentDetailUI", "the detail new video player updateTime called, playTimeMs = ".concat(String.valueOf(paramInt)));
      if ((SnsCommentDetailUI.f(SnsCommentDetailUI.this) == null) || (this.yXF == null) || (this.zWz == null))
      {
        ad.w("MicroMsg.SnsCommentDetailUI", "the snsAdStatistic or snsInfo is null in updateTime!!!");
        AppMethodBeat.o(198339);
        return;
      }
      SnsCommentDetailUI.f(SnsCommentDetailUI.this).zp(this.yXF.field_snsId);
      SnsCommentDetailUI.f(SnsCommentDetailUI.this).ak(this.yXF.field_snsId, paramInt);
      if (!SnsCommentDetailUI.f(SnsCommentDetailUI.this).zm(this.yXF.field_snsId))
      {
        paramInt = this.zWz.getDurationMs() / 1000;
        ad.i("MicroMsg.SnsCommentDetailUI", "updatePlayStartTime, duration=".concat(String.valueOf(paramInt)));
        SnsCommentDetailUI.f(SnsCommentDetailUI.this).d(this.yXF.field_snsId, bt.HI(), false);
        SnsCommentDetailUI.f(SnsCommentDetailUI.this).e(this.yXF.field_snsId, paramInt, false);
        SnsCommentDetailUI.f(SnsCommentDetailUI.this).aj(this.yXF.field_snsId, this.yXF.field_snsId);
      }
      AppMethodBeat.o(198339);
    }
  }
  
  final class d
    implements Runnable
  {
    private int Acn = -1;
    private int Aco = 10;
    int UL = -1;
    int kl;
    private int offset = 0;
    
    d() {}
    
    public final void run()
    {
      AppMethodBeat.i(98589);
      this.Aco = 10;
      SnsCommentDetailUI.b(SnsCommentDetailUI.this);
      this.Acn = SnsCommentDetailUI.c(SnsCommentDetailUI.this).getTop();
      int i = this.Acn - this.kl;
      ad.i("MicroMsg.SnsCommentDetailUI", "list.bottom: %d, listOriginalBottom: %d, footerTop: %d, commentFooter.getTop: %d, topSelection: %d", new Object[] { Integer.valueOf(SnsCommentDetailUI.a(SnsCommentDetailUI.this).getBottom()), Integer.valueOf(SnsCommentDetailUI.d(SnsCommentDetailUI.this)), Integer.valueOf(this.Acn), Integer.valueOf(SnsCommentDetailUI.c(SnsCommentDetailUI.this).getTop()), Integer.valueOf(i) });
      if (i == this.offset)
      {
        SnsCommentDetailUI.a(SnsCommentDetailUI.this).setSelectionFromTop(SnsCommentDetailUI.a(SnsCommentDetailUI.this).getHeaderViewsCount() + this.UL, i);
        this.Aco = 0;
        this.offset = 0;
        AppMethodBeat.o(98589);
        return;
      }
      int j = this.Aco;
      this.Aco = (j - 1);
      if (j > 0)
      {
        new ap().postDelayed(this, 100L);
        this.offset = i;
        AppMethodBeat.o(98589);
        return;
      }
      this.offset = 0;
      this.Aco = 0;
      AppMethodBeat.o(98589);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI
 * JD-Core Version:    0.7.0.1
 */