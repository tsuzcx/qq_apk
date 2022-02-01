package com.tencent.mm.plugin.profile.ui.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.g;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.f.a.dy;
import com.tencent.mm.f.a.dy.b;
import com.tencent.mm.f.a.ec;
import com.tencent.mm.f.a.ec.b;
import com.tencent.mm.f.a.sr;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.finder.view.EllipsizedTextView;
import com.tencent.mm.plugin.finder.view.FlowTextMixView;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.pluginsdk.model.b.b;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.protocal.protobuf.nf;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.protocal.protobuf.qc;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.happybubble.LabelsView;
import com.tencent.mm.ui.widget.happybubble.LabelsView.a;
import com.tencent.mm.ui.widget.happybubble.LabelsView.b;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements i
{
  private static long HdT = 0L;
  private View Abg;
  private String BLy;
  private AppBarLayout BWB;
  private String GXi;
  private com.tencent.mm.api.c GXj;
  private boolean GXw;
  private int GYZ;
  private Bundle GZe;
  private SnsAdClick GZf;
  private String GZg;
  private MMNeat7extView HdL;
  private boolean HdU;
  private pd Hdu;
  private String Hdw;
  private boolean Hdy;
  private ImageView Hge;
  private FlowTextMixView Hgf;
  private EllipsizedTextView Hgg;
  private Button Hgh;
  private Button Hgi;
  private ImageButton Hgj;
  private MMNeat7extView Hgk;
  private View Hgl;
  private TextView Hgm;
  private c Hgn;
  private b Hgo;
  private int Hgp;
  com.tencent.mm.plugin.brandservice.a.a Hgq;
  private IListener Hgr;
  long Hgs;
  private as contact;
  private com.tencent.mm.api.c.b eZc;
  private String eZl;
  private long enterTime;
  private String fvZ;
  private MMActivity iXq;
  private ImageView jiu;
  private ImageView kMb;
  private int mXL;
  private View oFW;
  private LabelsView sCN;
  private s tipDialog;
  private View uHV;
  
  public c(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(272298);
    this.HdU = false;
    this.fvZ = null;
    this.GZf = null;
    this.Hdy = false;
    this.GYZ = 0;
    this.Hdw = "";
    this.Hgp = 0;
    this.Hgq = null;
    this.Hgr = null;
    this.Hgs = 0L;
    this.oFW = paramView;
    this.iXq = paramMMActivity;
    this.jiu = ((ImageView)this.oFW.findViewById(R.h.dup));
    this.Hge = ((ImageView)this.oFW.findViewById(R.h.dus));
    this.Hgf = ((FlowTextMixView)this.oFW.findViewById(R.h.dtA));
    this.Hgg = ((EllipsizedTextView)this.oFW.findViewById(R.h.duu));
    this.HdL = ((MMNeat7extView)this.oFW.findViewById(R.h.duq));
    this.kMb = ((ImageView)this.oFW.findViewById(R.h.dKr));
    this.Hgh = ((Button)this.oFW.findViewById(R.h.dto));
    this.Hgi = ((Button)this.oFW.findViewById(R.h.dtn));
    this.Hgj = ((ImageButton)this.oFW.findViewById(R.h.dtp));
    this.Hgk = ((MMNeat7extView)this.oFW.findViewById(R.h.dtt));
    this.sCN = ((LabelsView)this.oFW.findViewById(R.h.dtv));
    this.Abg = this.oFW.findViewById(R.h.dtr);
    this.Hgl = this.oFW.findViewById(R.h.dtu);
    this.BWB = ((AppBarLayout)this.oFW.findViewById(R.h.dty));
    this.uHV = this.oFW.findViewById(R.h.dtx);
    this.Hgm = ((TextView)this.oFW.findViewById(R.h.dtw));
    p.E(this.uHV, 0.7F);
    this.BWB.a(new AppBarLayout.b()
    {
      public final void c(AppBarLayout paramAnonymousAppBarLayout, int paramAnonymousInt)
      {
        AppMethodBeat.i(288884);
        int i = paramAnonymousAppBarLayout.getTotalScrollRange();
        int j = Math.abs(paramAnonymousInt);
        if (c.a(c.this) != null) {}
        for (paramAnonymousInt = c.a(c.this).getBottom();; paramAnonymousInt = 0)
        {
          if (j >= paramAnonymousInt)
          {
            if (c.b(c.this) != null) {
              c.b(c.this).wh(false);
            }
            c.c(c.this).setMMTitleVisibility(0);
          }
          for (;;)
          {
            if ((c.d(c.this) >= i) && (j < c.d(c.this)) && (c.b(c.this) != null)) {
              c.b(c.this).frC();
            }
            c.a(c.this, j);
            AppMethodBeat.o(288884);
            return;
            if (c.b(c.this) != null) {
              c.b(c.this).wh(true);
            }
            c.c(c.this).setMMTitleVisibility(8);
          }
        }
      }
    });
    this.Hgi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(221030);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        c.this.fru();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(221030);
      }
    });
    this.Hgh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220303);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (c.e(c.this) != null)
        {
          paramAnonymousView = new sr();
          c.e(c.this).maV = 5;
          paramAnonymousView.fSb.fSc = c.e(c.this);
          EventCenter.instance.publish(paramAnonymousView);
        }
        c.f(c.this);
        c.b(c.this, 5);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(c.g(c.this).field_username, 300, c.h(c.this), c.i(c.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(220303);
      }
    });
    this.Hgj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(245472);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        c.this.frt();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(245472);
      }
    });
    p.E(this.Hgl, 0.7F);
    this.Hgl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(287315);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        c.j(c.this).setMaxLines(0);
        c.k(c.this).setVisibility(8);
        paramAnonymousView = com.tencent.mm.plugin.profile.ui.tab.data.b.Hhf;
        com.tencent.mm.plugin.profile.ui.tab.data.b.aj(c.g(c.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(287315);
      }
    });
    this.sCN.setOnLabelClickListener(new LabelsView.b()
    {
      public final void n(Object paramAnonymousObject, int paramAnonymousInt)
      {
        AppMethodBeat.i(284631);
        paramAnonymousObject = (qb)paramAnonymousObject;
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("rawUrl", paramAnonymousObject.RYu);
        ((Intent)localObject).putExtra("geta8key_scene", 3);
        com.tencent.mm.by.c.b(c.c(c.this), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        localObject = com.tencent.mm.plugin.profile.ui.tab.data.b.Hhf;
        com.tencent.mm.plugin.profile.ui.tab.data.b.a(c.g(c.this), paramAnonymousObject);
        AppMethodBeat.o(284631);
      }
    });
    this.GZf = ((SnsAdClick)this.iXq.getIntent().getParcelableExtra("KSnsAdTag"));
    this.GZg = this.iXq.getIntent().getStringExtra("key_add_contact_report_info");
    this.GYZ = this.iXq.getIntent().getIntExtra("add_more_friend_search_scene", 0);
    this.GZe = this.iXq.getIntent().getBundleExtra("Contact_Ext_Args");
    this.enterTime = System.currentTimeMillis();
    AppMethodBeat.o(272298);
  }
  
  private static int aUU(String paramString)
  {
    int j = 10000;
    AppMethodBeat.i(272321);
    int i = j;
    if (!Util.isNullOrNil(paramString)) {}
    try
    {
      i = Util.getInt(Uri.parse(paramString).getQueryParameter("scene"), 10000);
      AppMethodBeat.o(272321);
      return i;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private void aUZ(String paramString)
  {
    AppMethodBeat.i(272310);
    long l = System.currentTimeMillis();
    if (l - this.Hgs < 1000L)
    {
      AppMethodBeat.o(272310);
      return;
    }
    this.Hgs = l;
    int i = com.tencent.mm.storage.ab.getSessionId();
    int j = ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).aph(this.fvZ);
    com.tencent.mm.plugin.report.service.h.IzE.a(23044, new Object[] { Integer.valueOf(1), this.fvZ, Integer.valueOf(this.mXL), Integer.valueOf(i), paramString, Integer.valueOf(j), Integer.valueOf(1), "" });
    Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "reportExposed bizUserName=%s, liveScene=%d, addContactScene=%d", new Object[] { this.fvZ, Integer.valueOf(j), Integer.valueOf(this.mXL) });
    AppMethodBeat.o(272310);
  }
  
  private LinkedList<qb> c(pd parampd)
  {
    if (parampd == null) {
      return null;
    }
    try
    {
      parampd = parampd.RXC;
      if (parampd == null) {
        return null;
      }
    }
    finally {}
    parampd = parampd.RYw;
    return parampd;
  }
  
  private static boolean cyF()
  {
    AppMethodBeat.i(272302);
    boolean bool = ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).cyF();
    AppMethodBeat.o(272302);
    return bool;
  }
  
  private boolean fqS()
  {
    boolean bool1 = true;
    AppMethodBeat.i(272318);
    try
    {
      String str = this.eZc.Zn();
      boolean bool2 = Util.isNullOrNil(str);
      if (bool2)
      {
        AppMethodBeat.o(272318);
        return false;
      }
      long l = Util.getLong(str, 0L);
      if ((l > 0L) && (l - System.currentTimeMillis() / 1000L < 0L)) {}
      for (;;)
      {
        Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "isBizAccountTimeExpired:%b", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(272318);
        return bool1;
        bool1 = false;
      }
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(272318);
    }
  }
  
  /* Error */
  private void fqT()
  {
    // Byte code:
    //   0: ldc_w 626
    //   3: invokestatic 138	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 164	com/tencent/mm/plugin/profile/ui/tab/c:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   10: invokevirtual 305	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   13: astore 13
    //   15: aload 13
    //   17: ldc_w 628
    //   20: iconst_0
    //   21: invokevirtual 329	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   24: invokestatic 633	com/tencent/mm/plugin/profile/ui/newbizinfo/b/f:abH	(I)I
    //   27: istore_1
    //   28: aload 13
    //   30: ldc_w 635
    //   33: invokevirtual 321	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 14
    //   38: aload 13
    //   40: ldc_w 637
    //   43: invokevirtual 321	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 15
    //   48: aload 13
    //   50: ldc_w 639
    //   53: iconst_0
    //   54: invokevirtual 329	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   57: aload 14
    //   59: invokestatic 643	com/tencent/mm/plugin/profile/ui/newbizinfo/b/f:bO	(ILjava/lang/String;)I
    //   62: istore_2
    //   63: aload 13
    //   65: ldc_w 645
    //   68: invokevirtual 321	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 8
    //   73: aload 13
    //   75: ldc_w 647
    //   78: invokevirtual 321	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 12
    //   83: aload 13
    //   85: ldc_w 331
    //   88: invokevirtual 335	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   91: astore 10
    //   93: ldc 150
    //   95: astore 9
    //   97: aload 10
    //   99: ifnull +15 -> 114
    //   102: aload 10
    //   104: ldc_w 482
    //   107: ldc 150
    //   109: invokevirtual 650	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   112: astore 9
    //   114: aload 13
    //   116: ldc_w 652
    //   119: iconst_m1
    //   120: invokevirtual 329	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   123: invokestatic 657	com/tencent/mm/ui/f$a:atF	(I)I
    //   126: istore_3
    //   127: aload_0
    //   128: getfield 469	com/tencent/mm/plugin/profile/ui/tab/c:contact	Lcom/tencent/mm/storage/as;
    //   131: getfield 508	com/tencent/mm/f/c/ax:field_username	Ljava/lang/String;
    //   134: astore 16
    //   136: aload 9
    //   138: invokestatic 395	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   141: ifne +430 -> 571
    //   144: aload 9
    //   146: invokestatic 485	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   149: ldc_w 659
    //   152: invokestatic 664	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   155: astore 9
    //   157: aload 8
    //   159: astore 10
    //   161: aload 8
    //   163: invokestatic 485	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   166: ldc_w 659
    //   169: invokestatic 664	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 8
    //   174: aload 8
    //   176: astore 10
    //   178: aload 12
    //   180: invokestatic 485	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   183: ldc_w 659
    //   186: invokestatic 664	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   189: astore 11
    //   191: aload 11
    //   193: astore 10
    //   195: getstatic 436	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   198: sipush 16232
    //   201: bipush 9
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: iload_1
    //   209: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: iload_2
    //   216: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: aastore
    //   220: dup
    //   221: iconst_2
    //   222: aload 14
    //   224: aastore
    //   225: dup
    //   226: iconst_3
    //   227: aload 15
    //   229: aastore
    //   230: dup
    //   231: iconst_4
    //   232: aload 8
    //   234: aastore
    //   235: dup
    //   236: iconst_5
    //   237: aload 10
    //   239: aastore
    //   240: dup
    //   241: bipush 6
    //   243: aload 9
    //   245: aastore
    //   246: dup
    //   247: bipush 7
    //   249: iload_3
    //   250: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   253: aastore
    //   254: dup
    //   255: bipush 8
    //   257: aload 16
    //   259: aastore
    //   260: invokevirtual 447	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   263: aload_0
    //   264: getfield 323	com/tencent/mm/plugin/profile/ui/tab/c:GZg	Ljava/lang/String;
    //   267: invokestatic 395	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   270: ifne +16 -> 286
    //   273: getstatic 436	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   276: sipush 16697
    //   279: aload_0
    //   280: getfield 323	com/tencent/mm/plugin/profile/ui/tab/c:GZg	Ljava/lang/String;
    //   283: invokevirtual 524	com/tencent/mm/plugin/report/service/h:kvStat	(ILjava/lang/String;)V
    //   286: aload 13
    //   288: ldc_w 628
    //   291: iconst_0
    //   292: invokevirtual 329	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   295: istore_1
    //   296: invokestatic 343	java/lang/System:currentTimeMillis	()J
    //   299: ldc2_w 413
    //   302: ldiv
    //   303: l2i
    //   304: i2l
    //   305: lstore 4
    //   307: iload_1
    //   308: sipush 160
    //   311: if_icmpne +148 -> 459
    //   314: aload 13
    //   316: ldc_w 666
    //   319: lconst_0
    //   320: invokevirtual 669	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   323: lstore 6
    //   325: getstatic 436	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   328: sipush 15721
    //   331: bipush 9
    //   333: anewarray 4	java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: aload_0
    //   339: getfield 469	com/tencent/mm/plugin/profile/ui/tab/c:contact	Lcom/tencent/mm/storage/as;
    //   342: getfield 508	com/tencent/mm/f/c/ax:field_username	Ljava/lang/String;
    //   345: aastore
    //   346: dup
    //   347: iconst_1
    //   348: iconst_0
    //   349: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: aastore
    //   353: dup
    //   354: iconst_2
    //   355: bipush 14
    //   357: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   360: aastore
    //   361: dup
    //   362: iconst_3
    //   363: lload 4
    //   365: invokestatic 674	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   368: aastore
    //   369: dup
    //   370: iconst_4
    //   371: invokestatic 419	com/tencent/mm/storage/ab:getSessionId	()I
    //   374: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: aastore
    //   378: dup
    //   379: iconst_5
    //   380: iconst_0
    //   381: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   384: aastore
    //   385: dup
    //   386: bipush 6
    //   388: lload 6
    //   390: invokestatic 674	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   393: aastore
    //   394: dup
    //   395: bipush 7
    //   397: ldc 150
    //   399: aastore
    //   400: dup
    //   401: bipush 8
    //   403: iconst_1
    //   404: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: aastore
    //   408: invokevirtual 447	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   411: getstatic 436	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   414: ldc2_w 675
    //   417: ldc2_w 677
    //   420: lconst_1
    //   421: iconst_0
    //   422: invokevirtual 682	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   425: ldc_w 626
    //   428: invokestatic 348	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   431: return
    //   432: astore 10
    //   434: ldc 150
    //   436: astore 9
    //   438: ldc_w 449
    //   441: aload 10
    //   443: ldc 150
    //   445: iconst_0
    //   446: anewarray 4	java/lang/Object
    //   449: invokestatic 686	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   452: aload 12
    //   454: astore 10
    //   456: goto -261 -> 195
    //   459: iload_1
    //   460: sipush 174
    //   463: if_icmpne +88 -> 551
    //   466: getstatic 436	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   469: sipush 15721
    //   472: bipush 9
    //   474: anewarray 4	java/lang/Object
    //   477: dup
    //   478: iconst_0
    //   479: aload_0
    //   480: getfield 469	com/tencent/mm/plugin/profile/ui/tab/c:contact	Lcom/tencent/mm/storage/as;
    //   483: getfield 508	com/tencent/mm/f/c/ax:field_username	Ljava/lang/String;
    //   486: aastore
    //   487: dup
    //   488: iconst_1
    //   489: iconst_0
    //   490: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   493: aastore
    //   494: dup
    //   495: iconst_2
    //   496: bipush 21
    //   498: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   501: aastore
    //   502: dup
    //   503: iconst_3
    //   504: lload 4
    //   506: invokestatic 674	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   509: aastore
    //   510: dup
    //   511: iconst_4
    //   512: invokestatic 419	com/tencent/mm/storage/ab:getSessionId	()I
    //   515: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   518: aastore
    //   519: dup
    //   520: iconst_5
    //   521: iconst_0
    //   522: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   525: aastore
    //   526: dup
    //   527: bipush 6
    //   529: iconst_0
    //   530: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   533: aastore
    //   534: dup
    //   535: bipush 7
    //   537: ldc 150
    //   539: aastore
    //   540: dup
    //   541: bipush 8
    //   543: iconst_3
    //   544: invokestatic 442	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   547: aastore
    //   548: invokevirtual 447	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   551: ldc_w 626
    //   554: invokestatic 348	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   557: return
    //   558: astore 11
    //   560: aload 10
    //   562: astore 8
    //   564: aload 11
    //   566: astore 10
    //   568: goto -130 -> 438
    //   571: ldc 150
    //   573: astore 9
    //   575: aload 12
    //   577: astore 10
    //   579: goto -384 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	this	c
    //   27	437	1	i	int
    //   62	154	2	j	int
    //   126	124	3	k	int
    //   305	200	4	l1	long
    //   323	66	6	l2	long
    //   71	492	8	localObject1	Object
    //   95	479	9	str1	String
    //   91	147	10	localObject2	Object
    //   432	10	10	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   454	124	10	localObject3	Object
    //   189	3	11	str2	String
    //   558	7	11	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   81	495	12	str3	String
    //   13	302	13	localIntent	Intent
    //   36	187	14	str4	String
    //   46	182	15	str5	String
    //   134	124	16	str6	String
    // Exception table:
    //   from	to	target	type
    //   144	157	432	java/io/UnsupportedEncodingException
    //   161	174	558	java/io/UnsupportedEncodingException
    //   178	191	558	java/io/UnsupportedEncodingException
  }
  
  private void fqj()
  {
    AppMethodBeat.i(272320);
    HdT = System.currentTimeMillis();
    if ((this.iXq.getIntent() != null) && (this.iXq.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.iXq.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!Util.isNullOrNil((String)localObject1)) {
        break label317;
      }
      Log.i("MicroMsg.ContactWidgetTabBizHeaderController", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label317:
    while (fqk())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.iXq, new a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(233026);
          as localas;
          if (paramAnonymousBoolean1)
          {
            com.tencent.mm.ui.base.h.cO(c.c(c.this), c.c(c.this).getString(R.l.eya));
            localas = c.g(c.this);
            if ((localas != null) && (!Util.isNullOrNil(paramAnonymousString1))) {
              break label382;
            }
            Log.e("MicroMsg.ContactWidgetTabBizHeaderController", "respUsername == " + paramAnonymousString1 + ", contact = " + localas);
            if (c.e(c.this) != null)
            {
              paramAnonymousString1 = new sr();
              c.e(c.this).maV = 4;
              paramAnonymousString1.fSb.fSc = c.e(c.this);
              EventCenter.instance.publish(paramAnonymousString1);
            }
            if (c.v(c.this) != null) {
              c.v(c.this);
            }
            paramAnonymousString1 = af.bjv().Uo(c.g(c.this).field_username);
            paramAnonymousString1.field_status = 1;
            if ((!Util.isNullOrNil(paramAnonymousString1.field_extInfo)) || (Util.isNullOrNil(paramAnonymousString1.field_username)) || (c.w(c.this) == null) || (!paramAnonymousString1.field_username.equals(Util.nullAsNil(c.w(c.this).field_username)))) {
              break label670;
            }
            af.bjv().h(c.w(c.this));
            label243:
            paramAnonymousBoolean1 = c.c(c.this).getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
            paramAnonymousBoolean2 = c.c(c.this).getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
            if (!paramAnonymousString1.YX()) {
              break label681;
            }
            paramAnonymousString1 = new Intent();
            paramAnonymousString1.putExtra("enterprise_biz_name", c.g(c.this).field_username);
            paramAnonymousString1.putExtra("enterprise_biz_display_name", aa.PJ(c.g(c.this).field_username));
            paramAnonymousString1.putExtra("enterprise_from_scene", 7);
            paramAnonymousString1.addFlags(67108864);
            com.tencent.mm.by.c.f(c.c(c.this), ".ui.conversation.EnterpriseConversationUI", paramAnonymousString1);
          }
          label611:
          for (;;)
          {
            label358:
            c.c(c.this).finish();
            label382:
            do
            {
              c.b(c.this, 3);
              AppMethodBeat.o(233026);
              return;
              paramAnonymousString2 = null;
              if (com.tencent.mm.model.ab.Qk(localas.field_username))
              {
                String str = Util.nullAsNil(localas.field_username);
                paramAnonymousString2 = g.gu(str);
                if (paramAnonymousString2 != null) {
                  paramAnonymousString2.field_username = paramAnonymousString1;
                }
                af.bjv().Up(str);
                localas.Iy(str);
              }
              localas.setUsername(paramAnonymousString1);
              if ((int)localas.jxt == 0)
              {
                bh.beI();
                com.tencent.mm.model.c.bbL().aw(localas);
              }
              if ((int)localas.jxt <= 0)
              {
                Log.e("MicroMsg.ContactWidgetTabBizHeaderController", "addContact : insert contact failed");
                break;
              }
              com.tencent.mm.model.ab.H(localas);
              bh.beI();
              paramAnonymousString1 = com.tencent.mm.model.c.bbL().RG(localas.field_username);
              if (paramAnonymousString2 != null)
              {
                af.bjv().g(paramAnonymousString2);
                break;
              }
              paramAnonymousString2 = g.gu(paramAnonymousString1.field_username);
              if ((paramAnonymousString1.hxX()) && (com.tencent.mm.ao.a.biP())) {}
              for (int i = 1;; i = 0)
              {
                if ((paramAnonymousString2 != null) && ((!paramAnonymousString2.YR()) || (i != 0))) {
                  break label611;
                }
                Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "shouldUpdate");
                az.a.ltq.aP(paramAnonymousString1.field_username, "");
                com.tencent.mm.am.d.TA(paramAnonymousString1.field_username);
                break;
              }
              if ((!paramAnonymousString1.hyb()) || (i != 0)) {
                break;
              }
              Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramAnonymousString1.hDo) });
              az.a.ltq.aP(paramAnonymousString1.field_username, "");
              com.tencent.mm.am.d.TA(paramAnonymousString1.field_username);
              break;
              af.bjv().h(paramAnonymousString1);
              break label243;
              paramAnonymousString1 = new Intent();
              paramAnonymousString1.putExtra("Chat_User", c.g(c.this).field_username);
              paramAnonymousString1.putExtra("key_has_add_contact", true);
              paramAnonymousString1.putExtra("finish_direct", true);
              if (paramAnonymousBoolean2) {
                paramAnonymousString1.addFlags(268435456);
              }
              com.tencent.mm.storage.ab.bvv(c.g(c.this).field_username);
              com.tencent.mm.plugin.profile.b.mIG.d(paramAnonymousString1, c.c(c.this));
              if (paramAnonymousBoolean1) {
                break label358;
              }
            } while (!paramAnonymousBoolean2);
          }
        }
      });
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(this.mXL));
      if (this.eZl != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).BAU = this.eZl;
      }
      if (!Util.isNullOrNil(this.BLy)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).BLy = this.BLy;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).ReN = true;
      String str = this.iXq.getIntent().getStringExtra("url");
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).ReO = str;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).wGA = com.tencent.mm.ui.f.a.atF(this.iXq.getIntent().getIntExtra("qbarScene", -1));
      fam localfam = new fam();
      localfam.RKI = this.iXq.getIntent().getIntExtra("Contact_Sub_Scene", 0);
      localfam.SsR = this.iXq.getIntent().getStringExtra("Contact_Scene_Note");
      if (!Util.isNullOrNil(str))
      {
        if (Util.isNullOrNil(localfam.SsR)) {
          localfam.SsR = str;
        }
        if (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apb(str)) {
          localfam.UAv = aUU(str);
        }
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).ReP = localfam;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.GZg);
      fqT();
      AppMethodBeat.o(272320);
      return;
    }
    Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    bh.aGY().a(536, this);
    Object localObject2 = new dy();
    ((dy)localObject2).fzv.fzx = ((String)localObject1);
    ((dy)localObject2).fzv.opType = 1;
    EventCenter.instance.publish((IEvent)localObject2);
    Object localObject1 = ((dy)localObject2).fzw.fzz;
    localObject2 = this.iXq;
    this.iXq.getString(R.l.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject2, this.iXq.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(277582);
        bh.aGY().b(536, c.this);
        paramAnonymousDialogInterface = new dy();
        paramAnonymousDialogInterface.fzv.opType = 2;
        paramAnonymousDialogInterface.fzv.fzz = this.ftz;
        EventCenter.instance.publish(paramAnonymousDialogInterface);
        AppMethodBeat.o(277582);
      }
    });
    AppMethodBeat.o(272320);
  }
  
  private boolean fqk()
  {
    AppMethodBeat.i(272319);
    if (this.iXq.getIntent() == null)
    {
      AppMethodBeat.o(272319);
      return false;
    }
    String str1 = this.iXq.getIntent().getStringExtra("device_id");
    String str2 = this.iXq.getIntent().getStringExtra("device_type");
    ec localec = new ec();
    localec.fzH.fzB = str1;
    localec.fzH.fzF = str2;
    EventCenter.instance.publish(localec);
    boolean bool = localec.fzI.fzJ;
    AppMethodBeat.o(272319);
    return bool;
  }
  
  private void frA()
  {
    AppMethodBeat.i(272316);
    if ((this.Hdu == null) || (this.Hdu.RXD == null))
    {
      AppMethodBeat.o(272316);
      return;
    }
    Object localObject = this.Hdu.RXD;
    final String str = z.a(((qf)localObject).RYA);
    localObject = z.a(((qf)localObject).RYB);
    if ((Util.isNullOrNil((String)localObject)) || (Util.isNullOrNil(str)))
    {
      this.uHV.setVisibility(8);
      AppMethodBeat.o(272316);
      return;
    }
    this.Hgm.setText(Util.safeFormatString(this.iXq.getString(R.l.exX), new Object[] { localObject }));
    this.uHV.setVisibility(0);
    this.uHV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(291562);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.plugin.report.service.h.IzE.a(22118, new Object[] { Long.valueOf(c.i(c.this)), c.g(c.this).field_username, Integer.valueOf(2), str, this.Hgw });
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_enter_profile_type", 12);
        paramAnonymousView.putExtra("finder_username", str);
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).enterFinderProfileUI(MMApplicationContext.getContext(), paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(291562);
      }
    });
    AppMethodBeat.o(272316);
  }
  
  private void frv()
  {
    int m = 4;
    AppMethodBeat.i(272309);
    int i;
    boolean bool1;
    Object localObject1;
    SpannableString localSpannableString;
    boolean bool2;
    int j;
    label125:
    int k;
    Object localObject2;
    if ((com.tencent.mm.contact.d.rk(this.contact.field_type)) && (this.contact.ayn()) && (g.Uz(this.contact.field_username)))
    {
      i = 1;
      bool1 = this.contact.hxY();
      localObject1 = Util.nullAsNil(this.contact.field_nickname);
      localSpannableString = l.b(this.iXq, (CharSequence)localObject1, this.Hgg.getTextSize());
      bool2 = ar.isDarkMode();
      localObject1 = new SpannableString("");
      if (!bool1) {
        break label702;
      }
      localObject1 = this.iXq.getResources();
      if (!bool2) {
        break label639;
      }
      j = R.g.dnE;
      localObject1 = ((Resources)localObject1).getDrawable(j);
      j = com.tencent.mm.ci.a.fromDPToPix(this.iXq, 4);
      k = com.tencent.mm.ci.a.fromDPToPix(this.iXq, 20);
      ((Drawable)localObject1).setBounds(j, 0, k + j, k);
      localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject1, 1);
      localObject1 = new SpannableString("@");
      ((SpannableString)localObject1).setSpan(localObject2, 0, 1, 33);
    }
    label440:
    label702:
    for (;;)
    {
      localObject2 = new SpannableString("");
      label231:
      Object localObject3;
      if (i != 0)
      {
        localObject2 = this.iXq.getResources();
        if (bool2)
        {
          j = R.g.biz_icons_filled_star_dm;
          localObject2 = ((Resources)localObject2).getDrawable(j);
          localObject3 = this.iXq;
          if (!bool1) {
            break label653;
          }
          j = 2;
          label252:
          j = com.tencent.mm.ci.a.fromDPToPix((Context)localObject3, j);
          k = com.tencent.mm.ci.a.fromDPToPix(this.iXq, 20);
          ((Drawable)localObject2).setBounds(j, 0, k + j, k);
          localObject3 = new com.tencent.mm.ui.widget.a((Drawable)localObject2, 1);
          localObject2 = new SpannableString("@");
          ((SpannableString)localObject2).setSpan(localObject3, 0, 1, 33);
        }
      }
      for (;;)
      {
        if (cyF())
        {
          localObject3 = ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apg(this.fvZ);
          if ((Util.isNullOrNil((String)localObject3)) || (!((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).api(this.fvZ))) {
            break label658;
          }
          j = 1;
          label372:
          if ((j == 0) && (!MultiProcessMMKV.getSingleMMKV("brandService").decodeBool("ProfileAllaysShowLive", false))) {
            break label687;
          }
          this.Hge.setVisibility(0);
          Object localObject4 = LocaleUtil.getApplicationLanguage();
          if ((!Util.isEqual((String)localObject4, "zh_CN")) && (!Util.isEqual((String)localObject4, "zh_HK")) && (!Util.isEqual((String)localObject4, "zh_TW"))) {
            break label663;
          }
          j = 1;
          localObject4 = this.Hge;
          if (j == 0) {
            break label668;
          }
          k = R.g.biz_live_chinese;
          label454:
          ((ImageView)localObject4).setImageResource(k);
          localObject4 = this.iXq;
          if (j == 0) {
            break label675;
          }
          j = 53;
          label473:
          k = com.tencent.mm.ci.a.fromDPToPix((Context)localObject4, j);
          localObject4 = this.iXq;
          j = m;
          if (!bool1)
          {
            if (i == 0) {
              break label681;
            }
            j = m;
          }
          label501:
          i = com.tencent.mm.ci.a.fromDPToPix((Context)localObject4, j);
          this.Hgf.setItemSpacing(i);
          this.Hgg.setExtraEllipsizeWidth(k);
          aUZ((String)localObject3);
          p.E(this.Hge, 0.5F);
          localObject4 = (FrameLayout.LayoutParams)this.Hge.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject4).width = k;
          ((FrameLayout.LayoutParams)localObject4).height = com.tencent.mm.ci.a.fromDPToPix(this.iXq, 18);
          this.Hge.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.Hge.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(197796);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              int i = com.tencent.mm.storage.ab.getSessionId();
              int j = ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).aph(c.r(c.this));
              ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(c.c(c.this), c.r(c.this), this.Hgu, 8, j);
              com.tencent.mm.plugin.report.service.h.IzE.a(23044, new Object[] { Integer.valueOf(2), c.r(c.this), Integer.valueOf(c.h(c.this)), Integer.valueOf(i), this.Hgu, Integer.valueOf(j), Integer.valueOf(1), "" });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(197796);
            }
          });
        }
        for (;;)
        {
          this.Hgg.setText(TextUtils.concat(new CharSequence[] { localSpannableString, localObject1, localObject2 }));
          AppMethodBeat.o(272309);
          return;
          i = 0;
          break;
          label639:
          j = R.g.dnD;
          break label125;
          j = R.g.biz_icons_filled_star;
          break label231;
          j = 4;
          break label252;
          j = 0;
          break label372;
          j = 0;
          break label440;
          k = R.g.biz_live_eng;
          break label454;
          j = 42;
          break label473;
          j = 7;
          break label501;
          this.Hge.setVisibility(8);
        }
      }
    }
  }
  
  private void frw()
  {
    boolean bool = true;
    AppMethodBeat.i(272311);
    this.jiu.setVisibility(0);
    int i;
    ImageView localImageView;
    as localas;
    String str;
    if (System.currentTimeMillis() - HdT < 2000L)
    {
      i = 1;
      localImageView = this.jiu;
      localas = this.contact;
      if (!this.HdU) {
        break label101;
      }
      str = "";
      label54:
      if ((this.HdU) || (i == 0)) {
        break label109;
      }
    }
    for (;;)
    {
      e.a(localImageView, localas, str, bool);
      if (!this.HdU) {
        break label114;
      }
      this.jiu.setClickable(false);
      AppMethodBeat.o(272311);
      return;
      i = 0;
      break;
      label101:
      str = this.GXi;
      break label54;
      label109:
      bool = false;
    }
    label114:
    this.jiu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(265991);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = c.g(c.this).field_username;
        paramAnonymousView = new Intent(c.c(c.this), ProfileHdHeadImg.class);
        paramAnonymousView.putExtra("username", (String)localObject);
        paramAnonymousView.putExtra("brand_icon_url", c.s(c.this));
        localObject = c.c(c.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(265991);
      }
    });
    AppMethodBeat.o(272311);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void frx()
  {
    AppMethodBeat.i(272313);
    String str = this.contact.signature;
    Object localObject = b.Hgd;
    localObject = str;
    if (b.a.aUY(str)) {
      localObject = this.iXq.getString(R.l.exZ);
    }
    localObject = l.c(this.iXq, (CharSequence)localObject);
    this.HdL.aL((CharSequence)localObject);
    this.HdL.setVisibility(0);
    if ((this.GXj == null) || (this.GXj.dc(false) == null) || (this.GXj.dc(false).Zt() == null) || (Util.isNullOrNil(this.GXj.dc(false).Zt().faj)))
    {
      Log.i("MicroMsg.ContactWidgetTabBizHeaderController", "bizInfo aboutBizUrl is null, arrow setVisibility GONE");
      this.kMb.setVisibility(8);
    }
    for (;;)
    {
      this.HdL.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.h(this.HdL, new o())
      {
        public final void onLongPress(MotionEvent paramAnonymousMotionEvent) {}
        
        @SuppressLint({"ResourceType"})
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(291389);
          c.a(c.this, paramAnonymousMotionEvent);
          boolean bool = super.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          AppMethodBeat.o(291389);
          return bool;
        }
      });
      this.kMb.setOnTouchListener(new View.OnTouchListener()
      {
        @SuppressLint({"ResourceType"})
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(270622);
          c.a(c.this, paramAnonymousMotionEvent);
          AppMethodBeat.o(270622);
          return false;
        }
      });
      this.HdL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(274896);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          c.t(c.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(274896);
        }
      });
      this.kMb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(279425);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          c.t(c.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(279425);
        }
      });
      AppMethodBeat.o(272313);
      return;
      this.kMb.setVisibility(0);
    }
  }
  
  private void fry()
  {
    int j = 1;
    AppMethodBeat.i(272314);
    if (this.contact == null)
    {
      this.Hgi.setVisibility(8);
      this.Hgj.setVisibility(8);
      this.Hgh.setVisibility(8);
      AppMethodBeat.o(272314);
      return;
    }
    if ((this.iXq.getIntent() != null) && (this.iXq.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      i = 1;
      if (i != 0)
      {
        Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "Hard device biz...");
        boolean bool = fqk();
        Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "contact.isContact()(%b), isHarDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.contact.d.rk(this.contact.field_type)), Boolean.valueOf(bool) });
        if ((!com.tencent.mm.contact.d.rk(this.contact.field_type)) || (!bool))
        {
          if (!bool) {
            break label231;
          }
          this.Hgi.setText(R.l.exR);
        }
      }
      label163:
      if ((i == 0) || (fqk())) {
        break label244;
      }
    }
    label231:
    label244:
    for (int i = j;; i = 0)
    {
      if ((com.tencent.mm.contact.d.rk(this.contact.field_type)) && (i == 0)) {
        break label249;
      }
      this.Hgj.setVisibility(8);
      this.Hgh.setVisibility(8);
      this.Hgi.setVisibility(0);
      AppMethodBeat.o(272314);
      return;
      i = 0;
      break;
      this.Hgi.setText(R.l.exU);
      break label163;
    }
    label249:
    this.Hgj.setVisibility(0);
    this.Hgh.setVisibility(0);
    this.Hgi.setVisibility(8);
    AppMethodBeat.o(272314);
  }
  
  private void frz()
  {
    int i = 0;
    AppMethodBeat.i(272315);
    Object localObject = we(false);
    if (!Util.isNullOrNil((String)localObject))
    {
      this.Hgk.setVisibility(0);
      this.Hgk.aL((CharSequence)localObject);
      int j = this.Hdu.RXt.RTV;
      int k = this.Hdu.RXt.RTW;
      if ((j > 0) && (k > 0))
      {
        j = com.tencent.mm.ci.a.kr(this.iXq);
        k = (int)(com.tencent.mm.ci.a.getDensity(this.iXq) * 32.0F);
        localObject = this.Hgk.nH(j - k, 2147483647);
        if (localObject != null) {
          i = ((com.tencent.neattextview.textview.layout.a)localObject).ikp();
        }
        if (i > 1)
        {
          localObject = we(true);
          this.Hgk.aL((CharSequence)localObject);
        }
      }
      AppMethodBeat.o(272315);
      return;
    }
    this.Hgk.setVisibility(8);
    AppMethodBeat.o(272315);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(272308);
    if (this.contact == null)
    {
      Log.w("MicroMsg.ContactWidgetTabBizHeaderController", "initView contact is null, return");
      AppMethodBeat.o(272308);
      return;
    }
    if (this.GXj == null) {
      this.GXj = g.gu(this.contact.field_username);
    }
    if (this.GXj != null) {
      this.GXi = this.GXj.field_brandIconURL;
    }
    frv();
    frw();
    frx();
    fry();
    frz();
    frA();
    this.oFW.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(279819);
        c.m(c.this).getViewTreeObserver().removeOnPreDrawListener(this);
        LinkedList localLinkedList = c.a(c.this, c.n(c.this));
        if ((c.j(c.this).getLineCount() > 1) && (localLinkedList != null) && (!localLinkedList.isEmpty())) {
          c.k(c.this).setVisibility(0);
        }
        for (;;)
        {
          if (c.o(c.this).getLineCount() >= 3) {
            c.o(c.this).setTextSize(0, com.tencent.mm.ci.a.aZ(c.p(c.this), R.f.Small_TextSize));
          }
          boolean bool = c.q(c.this);
          AppMethodBeat.o(279819);
          return bool;
          c.k(c.this).setVisibility(8);
        }
      }
    });
    Object localObject = c(this.Hdu);
    if ((localObject != null) && (!((LinkedList)localObject).isEmpty()))
    {
      this.sCN.setVisibility(0);
      ArrayList localArrayList;
      label220:
      qb localqb;
      com.tencent.mm.plugin.brandservice.a.f.a locala;
      if (this.sCN.getLineCount() > 1)
      {
        this.Hgl.setVisibility(0);
        localArrayList = new ArrayList((Collection)localObject);
        final int i = (com.tencent.mm.ci.a.kr(this.iXq) - (int)(com.tencent.mm.ci.a.getDensity(this.iXq) * 40.0F)) / 2;
        this.sCN.a(localArrayList, new LabelsView.a() {});
        localArrayList = new ArrayList();
        Iterator localIterator = ((LinkedList)localObject).iterator();
        if (!localIterator.hasNext()) {
          break label339;
        }
        localqb = (qb)localIterator.next();
        locala = new com.tencent.mm.plugin.brandservice.a.f.a();
        if (this.GXj == null) {
          break label333;
        }
      }
      label333:
      for (localObject = this.GXj.field_appId;; localObject = "")
      {
        locala.appId = ((String)localObject);
        locala.url = localqb.RYu;
        locala.title = localqb.RYs;
        locala.desc = localqb.RYt;
        locala.svv = 126;
        localArrayList.add(locala);
        break label220;
        this.Hgl.setVisibility(8);
        break;
      }
      label339:
      ((com.tencent.mm.plugin.brandservice.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.f.class)).m(localArrayList, 32);
      AppMethodBeat.o(272308);
      return;
    }
    this.sCN.setVisibility(8);
    this.Hgl.setVisibility(8);
    AppMethodBeat.o(272308);
  }
  
  private String we(boolean paramBoolean)
  {
    AppMethodBeat.i(272317);
    Object localObject = new StringBuilder();
    if (this.Hdu.RXt != null)
    {
      String str1 = this.Hdu.RXt.RTY;
      String str2 = this.Hdu.RXt.RTZ;
      if ((!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(str2)))
      {
        ((StringBuilder)localObject).append(str1);
        if (paramBoolean) {
          ((StringBuilder)localObject).append("\n");
        }
        for (;;)
        {
          ((StringBuilder)localObject).append(str2);
          localObject = ((StringBuilder)localObject).toString();
          AppMethodBeat.o(272317);
          return localObject;
          ((StringBuilder)localObject).append("  ");
        }
      }
      if (!Util.isNullOrNil(str1))
      {
        ((StringBuilder)localObject).append(str1);
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(272317);
        return localObject;
      }
      if (!Util.isNullOrNil(str2))
      {
        ((StringBuilder)localObject).append(str2);
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(272317);
        return localObject;
      }
    }
    AppMethodBeat.o(272317);
    return "";
  }
  
  public final void a(b paramb)
  {
    this.Hgo = paramb;
  }
  
  public final void a(pd parampd, com.tencent.mm.api.c paramc, String paramString)
  {
    AppMethodBeat.i(272307);
    this.Hdu = parampd;
    this.GXj = paramc;
    this.BLy = paramString;
    if (parampd != null)
    {
      if ((parampd.RUc & 0x2) != 0) {
        this.HdU = true;
      }
      if (!fqS()) {
        break label66;
      }
      this.Abg.setVisibility(8);
    }
    for (;;)
    {
      updateView();
      AppMethodBeat.o(272307);
      return;
      label66:
      this.Abg.setVisibility(0);
    }
  }
  
  public final void a(as paramas, String paramString, com.tencent.mm.api.c paramc, pd parampd, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(272299);
    this.GXi = paramString;
    this.GXj = paramc;
    this.contact = paramas;
    this.Hdu = parampd;
    this.mXL = paramInt;
    this.GXw = paramBoolean;
    if (paramc != null) {
      this.eZc = paramc.dc(false);
    }
    if (paramas != null)
    {
      this.fvZ = paramas.field_username;
      if ((!this.fvZ.startsWith("gh_")) && (parampd != null) && (parampd.RXs != null)) {
        this.fvZ = parampd.RXs.UserName;
      }
    }
    if ((this.eZc != null) && (this.eZc.Zk() != null) && (this.eZc.Zk().length() > 0)) {
      this.eZl = this.eZc.Zk();
    }
    updateView();
    AppMethodBeat.o(272299);
  }
  
  public final void frB()
  {
    AppMethodBeat.i(272323);
    if (this.BWB != null) {
      this.BWB.c(true, true, true);
    }
    AppMethodBeat.o(272323);
  }
  
  public final void frt()
  {
    AppMethodBeat.i(272305);
    ((com.tencent.mm.api.m)com.tencent.mm.kernel.h.ae(com.tencent.mm.api.m.class)).a(this.GXj, this.iXq, this.contact, true, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(280345);
        c.b(c.this, 4);
        if (c.c(c.this).getIntent().getIntExtra("Kdel_from", -1) == 1)
        {
          Intent localIntent = new Intent();
          localIntent.addFlags(67108864);
          com.tencent.mm.by.c.b(c.c(c.this), "shake", ".ui.ShakeReportUI", localIntent);
        }
        AppMethodBeat.o(280345);
      }
    });
    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(this.contact.field_username, 1000, this.mXL, this.enterTime);
    AppMethodBeat.o(272305);
  }
  
  public final void fru()
  {
    AppMethodBeat.i(272306);
    if (this.Hdy)
    {
      ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ir(this.iXq);
      if ((this.contact != null) && (this.contact.field_username != null)) {
        ((com.tencent.mm.api.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.api.q.class)).d(7, this.contact.field_username, this.contact.field_nickname);
      }
      AppMethodBeat.o(272306);
      return;
    }
    if (!com.tencent.mm.model.gdpr.c.bgq()) {
      fqj();
    }
    for (;;)
    {
      if (this.GYZ != 0) {
        com.tencent.mm.plugin.report.service.h.IzE.a(11263, new Object[] { Integer.valueOf(this.GYZ), this.contact.field_username });
      }
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(this.contact.field_username, 200, this.mXL, this.enterTime);
      AppMethodBeat.o(272306);
      return;
      com.tencent.mm.model.gdpr.c.a(this.iXq, com.tencent.mm.model.gdpr.a.lwP, this.contact.field_username, new com.tencent.mm.model.gdpr.b()
      {
        public final void vu(int paramAnonymousInt)
        {
          AppMethodBeat.i(285884);
          if (paramAnonymousInt == 0) {
            c.u(c.this);
          }
          AppMethodBeat.o(285884);
        }
      });
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(272303);
    if ((this.Hgr == null) && (cyF()))
    {
      this.Hgr = new c.a(this);
      this.Hgr.alive();
    }
    AppMethodBeat.o(272303);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(272304);
    if (this.Hgr != null)
    {
      this.Hgr.dead();
      this.Hgr = null;
    }
    AppMethodBeat.o(272304);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(272301);
    if (this.Hgq != null) {
      this.Hgq.stopCheck();
    }
    AppMethodBeat.o(272301);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(272300);
    if (cyF())
    {
      if (this.Hgq == null)
      {
        com.tencent.mm.plugin.brandservice.a.c localc = (com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class);
        b.b localb = b.b.QUa;
        this.Hgq = localc.Gy(b.b.hgG());
      }
      ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).cyH();
      this.Hgq.apt(this.fvZ);
    }
    AppMethodBeat.o(272300);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(272322);
    Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramq == null)
    {
      Log.e("MicroMsg.ContactWidgetTabBizHeaderController", "scene == null");
      AppMethodBeat.o(272322);
      return;
    }
    bh.aGY().b(paramq.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.ContactWidgetTabBizHeaderController", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
      AppMethodBeat.o(272322);
      return;
    }
    Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
    if (paramq.getType() == 536)
    {
      bh.aGY().b(536, this);
      updateView();
    }
    AppMethodBeat.o(272322);
  }
  
  public static abstract interface b
  {
    public abstract void frC();
    
    public abstract void wh(boolean paramBoolean);
  }
  
  public static abstract interface c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.c
 * JD-Core Version:    0.7.0.1
 */