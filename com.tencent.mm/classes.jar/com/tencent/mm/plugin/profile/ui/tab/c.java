package com.tencent.mm.plugin.profile.ui.tab;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.b;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.dv.b;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.eqb;
import com.tencent.mm.protocal.protobuf.np;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.protocal.protobuf.qj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.a;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.happybubble.LabelsView;
import com.tencent.mm.ui.widget.happybubble.LabelsView.a;
import com.tencent.mm.ui.widget.happybubble.LabelsView.b;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements i
{
  private static long Bjx = 0L;
  private String Bdj;
  private com.tencent.mm.api.c Bdk;
  private boolean Bdx;
  private int Bfb;
  private SnsAdClick Bfh;
  private String Bfi;
  private ph BiU;
  private boolean BiX;
  private boolean Bjy;
  private Button BlT;
  private Button BlU;
  private ImageButton BlV;
  private MMNeat7extView BlW;
  private View BlX;
  private View BlY;
  private TextView BlZ;
  private b Bma;
  private a Bmb;
  private int Bmc;
  private as contact;
  private String dhE;
  private com.tencent.mm.api.c.b dhv;
  private long enterTime;
  private MMActivity gte;
  private ImageView gyr;
  private ImageView hXw;
  private int kgm;
  private View lJI;
  private String pHz;
  private MMNeat7extView pIP;
  private LabelsView ptA;
  private com.tencent.mm.ui.base.q tipDialog;
  private TextView titleTv;
  private View vun;
  private String wZz;
  private AppBarLayout xkh;
  
  public c(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(231985);
    this.Bjy = false;
    this.Bfh = null;
    this.BiX = false;
    this.Bfb = 0;
    this.pHz = "";
    this.Bmc = 0;
    this.lJI = paramView;
    this.gte = paramMMActivity;
    this.gyr = ((ImageView)this.lJI.findViewById(2131297631));
    this.titleTv = ((TextView)this.lJI.findViewById(2131297635));
    this.pIP = ((MMNeat7extView)this.lJI.findViewById(2131297632));
    this.hXw = ((ImageView)this.lJI.findViewById(2131302879));
    this.BlT = ((Button)this.lJI.findViewById(2131297448));
    this.BlU = ((Button)this.lJI.findViewById(2131297447));
    this.BlV = ((ImageButton)this.lJI.findViewById(2131297449));
    this.BlW = ((MMNeat7extView)this.lJI.findViewById(2131297452));
    this.ptA = ((LabelsView)this.lJI.findViewById(2131297454));
    this.vun = this.lJI.findViewById(2131297451);
    this.BlX = this.lJI.findViewById(2131297453);
    this.xkh = ((AppBarLayout)this.lJI.findViewById(2131297458));
    this.BlY = this.lJI.findViewById(2131297456);
    this.BlZ = ((TextView)this.lJI.findViewById(2131297455));
    com.tencent.mm.ui.tools.o.hq(this.BlY);
    this.xkh.a(new AppBarLayout.b()
    {
      public final void c(AppBarLayout paramAnonymousAppBarLayout, int paramAnonymousInt)
      {
        AppMethodBeat.i(231967);
        int i = paramAnonymousAppBarLayout.getTotalScrollRange();
        int j = Math.abs(paramAnonymousInt);
        if (j >= c.a(c.this).getBottom()) {
          c.b(c.this).setMMTitleColor(c.b(c.this).getResources().getColor(2131099746));
        }
        for (;;)
        {
          if ((c.c(c.this) >= i) && (j < c.c(c.this)) && (c.d(c.this) != null)) {
            c.d(c.this).eFF();
          }
          c.a(c.this, j);
          Log.v("MicroMsg.ContactWidgetTabBizHeaderController", "callback i:%d, Y:%f", new Object[] { Integer.valueOf(paramAnonymousInt), Float.valueOf(c.a(c.this).getY()) });
          AppMethodBeat.o(231967);
          return;
          c.b(c.this).setMMTitleColor(0);
        }
      }
    });
    this.BlU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(231976);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (c.e(c.this))
        {
          ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).hr(c.b(c.this));
          if ((c.f(c.this) != null) && (c.f(c.this).field_username != null)) {
            ((com.tencent.mm.api.q)com.tencent.mm.kernel.g.af(com.tencent.mm.api.q.class)).d(7, c.f(c.this).field_username, c.f(c.this).field_nickname);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(231976);
          return;
        }
        c.g(c.this);
        if (c.h(c.this) != 0) {
          com.tencent.mm.plugin.report.service.h.CyF.a(11263, new Object[] { Integer.valueOf(c.h(c.this)), c.f(c.this).field_username });
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(c.f(c.this).field_username, 200, c.i(c.this), c.j(c.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(231976);
      }
    });
    this.BlT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(231977);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (c.k(c.this) != null)
        {
          paramAnonymousView = new rr();
          c.k(c.this).jkU = 5;
          paramAnonymousView.dYk.dYl = c.k(c.this);
          EventCenter.instance.publish(paramAnonymousView);
        }
        c.l(c.this);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(c.f(c.this).field_username, 300, c.i(c.this), c.j(c.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(231977);
      }
    });
    this.BlV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(231979);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ((com.tencent.mm.api.m)com.tencent.mm.kernel.g.af(com.tencent.mm.api.m.class)).a(c.m(c.this), c.b(c.this), c.f(c.this), true, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(231978);
            if (c.b(c.this).getIntent().getIntExtra("Kdel_from", -1) == 1)
            {
              Intent localIntent = new Intent();
              localIntent.addFlags(67108864);
              com.tencent.mm.br.c.b(c.b(c.this), "shake", ".ui.ShakeReportUI", localIntent);
            }
            AppMethodBeat.o(231978);
          }
        });
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(c.f(c.this).field_username, 1000, c.i(c.this), c.j(c.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(231979);
      }
    });
    com.tencent.mm.ui.tools.o.hq(this.BlX);
    this.BlX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(231980);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        c.n(c.this).setMaxLines(0);
        c.o(c.this).setVisibility(8);
        paramAnonymousView = com.tencent.mm.plugin.profile.ui.tab.data.b.BmM;
        com.tencent.mm.plugin.profile.ui.tab.data.b.ac(c.f(c.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(231980);
      }
    });
    this.ptA.setOnLabelClickListener(new LabelsView.b()
    {
      public final void j(Object paramAnonymousObject, int paramAnonymousInt)
      {
        AppMethodBeat.i(231981);
        paramAnonymousObject = (qf)paramAnonymousObject;
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("rawUrl", paramAnonymousObject.KXf);
        ((Intent)localObject).putExtra("geta8key_scene", 3);
        com.tencent.mm.br.c.b(c.b(c.this), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        localObject = com.tencent.mm.plugin.profile.ui.tab.data.b.BmM;
        com.tencent.mm.plugin.profile.ui.tab.data.b.a(c.f(c.this), paramAnonymousObject);
        AppMethodBeat.o(231981);
      }
    });
    this.Bfh = ((SnsAdClick)this.gte.getIntent().getParcelableExtra("KSnsAdTag"));
    this.Bfi = this.gte.getIntent().getStringExtra("key_add_contact_report_info");
    this.Bfb = this.gte.getIntent().getIntExtra("add_more_friend_search_scene", 0);
    this.enterTime = System.currentTimeMillis();
    AppMethodBeat.o(231985);
  }
  
  private static int aKw(String paramString)
  {
    int j = 10000;
    AppMethodBeat.i(231999);
    int i = j;
    if (!Util.isNullOrNil(paramString)) {}
    try
    {
      i = Util.getInt(Uri.parse(paramString).getQueryParameter("scene"), 10000);
      AppMethodBeat.o(231999);
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
  
  /* Error */
  private LinkedList<qf> c(ph arg1)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +7 -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: aconst_null
    //   9: areturn
    //   10: aload_1
    //   11: getfield 334	com/tencent/mm/protocal/protobuf/ph:KWo	Lcom/tencent/mm/protocal/protobuf/qg;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnonnull +12 -> 28
    //   19: aload_0
    //   20: monitorexit
    //   21: aconst_null
    //   22: areturn
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    //   28: aload_1
    //   29: getfield 340	com/tencent/mm/protocal/protobuf/qg:KXh	Ljava/util/LinkedList;
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	c
    // Exception table:
    //   from	to	target	type
    //   6	8	23	finally
    //   10	15	23	finally
    //   19	21	23	finally
    //   24	26	23	finally
    //   28	35	23	finally
  }
  
  private void eEr()
  {
    AppMethodBeat.i(231998);
    if ((this.gte.getIntent() != null) && (this.gte.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.gte.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!Util.isNullOrNil((String)localObject1)) {
        break label307;
      }
      Log.i("MicroMsg.ContactWidgetTabBizHeaderController", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label307:
    while (eEs())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.gte, new a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(231975);
          as localas;
          if (paramAnonymousBoolean1)
          {
            com.tencent.mm.ui.base.h.cD(c.b(c.this), c.b(c.this).getString(2131757835));
            localas = c.f(c.this);
            if ((localas != null) && (!Util.isNullOrNil(paramAnonymousString1))) {
              break label373;
            }
            Log.e("MicroMsg.ContactWidgetTabBizHeaderController", "respUsername == " + paramAnonymousString1 + ", contact = " + localas);
            if (c.k(c.this) != null)
            {
              paramAnonymousString1 = new rr();
              c.k(c.this).jkU = 4;
              paramAnonymousString1.dYk.dYl = c.k(c.this);
              EventCenter.instance.publish(paramAnonymousString1);
            }
            if (c.v(c.this) != null) {
              c.v(c.this);
            }
            paramAnonymousString1 = ag.bah().MT(c.f(c.this).field_username);
            paramAnonymousString1.field_status = 1;
            if ((!Util.isNullOrNil(paramAnonymousString1.field_extInfo)) || (Util.isNullOrNil(paramAnonymousString1.field_username)) || (c.m(c.this) == null) || (!paramAnonymousString1.field_username.equals(Util.nullAsNil(c.m(c.this).field_username)))) {
              break label661;
            }
            ag.bah().h(c.m(c.this));
            label242:
            paramAnonymousBoolean1 = c.b(c.this).getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
            paramAnonymousBoolean2 = c.b(c.this).getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
            if (!paramAnonymousString1.UF()) {
              break label672;
            }
            paramAnonymousString1 = new Intent();
            paramAnonymousString1.putExtra("enterprise_biz_name", c.f(c.this).field_username);
            paramAnonymousString1.putExtra("enterprise_biz_display_name", aa.getDisplayName(c.f(c.this).field_username));
            paramAnonymousString1.putExtra("enterprise_from_scene", 7);
            paramAnonymousString1.addFlags(67108864);
            com.tencent.mm.br.c.f(c.b(c.this), ".ui.conversation.EnterpriseConversationUI", paramAnonymousString1);
          }
          label602:
          for (;;)
          {
            label357:
            c.b(c.this).finish();
            label373:
            do
            {
              AppMethodBeat.o(231975);
              return;
              paramAnonymousString2 = null;
              if (com.tencent.mm.model.ab.IR(localas.field_username))
              {
                String str = Util.nullAsNil(localas.field_username);
                paramAnonymousString2 = com.tencent.mm.al.g.fJ(str);
                if (paramAnonymousString2 != null) {
                  paramAnonymousString2.field_username = paramAnonymousString1;
                }
                ag.bah().delete(str);
                localas.BK(str);
              }
              localas.setUsername(paramAnonymousString1);
              if ((int)localas.gMZ == 0)
              {
                bg.aVF();
                com.tencent.mm.model.c.aSN().aq(localas);
              }
              if ((int)localas.gMZ <= 0)
              {
                Log.e("MicroMsg.ContactWidgetTabBizHeaderController", "addContact : insert contact failed");
                break;
              }
              com.tencent.mm.model.ab.B(localas);
              bg.aVF();
              paramAnonymousString1 = com.tencent.mm.model.c.aSN().Kn(localas.field_username);
              if (paramAnonymousString2 != null)
              {
                ag.bah().g(paramAnonymousString2);
                break;
              }
              paramAnonymousString2 = com.tencent.mm.al.g.fJ(paramAnonymousString1.field_username);
              if ((paramAnonymousString1.gBM()) && (com.tencent.mm.al.a.aZz())) {}
              for (int i = 1;; i = 0)
              {
                if ((paramAnonymousString2 != null) && ((!paramAnonymousString2.Uz()) || (i != 0))) {
                  break label602;
                }
                Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "shouldUpdate");
                ay.a.iDq.aL(paramAnonymousString1.field_username, "");
                com.tencent.mm.aj.c.Mf(paramAnonymousString1.field_username);
                break;
              }
              if ((!paramAnonymousString1.gBQ()) || (i != 0)) {
                break;
              }
              Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramAnonymousString1.fuP) });
              ay.a.iDq.aL(paramAnonymousString1.field_username, "");
              com.tencent.mm.aj.c.Mf(paramAnonymousString1.field_username);
              break;
              ag.bah().h(paramAnonymousString1);
              break label242;
              paramAnonymousString1 = new Intent();
              paramAnonymousString1.putExtra("Chat_User", c.f(c.this).field_username);
              paramAnonymousString1.putExtra("key_has_add_contact", true);
              paramAnonymousString1.putExtra("finish_direct", true);
              if (paramAnonymousBoolean2) {
                paramAnonymousString1.addFlags(268435456);
              }
              com.tencent.mm.storage.ab.bja(c.f(c.this).field_username);
              com.tencent.mm.plugin.profile.b.jRt.d(paramAnonymousString1, c.b(c.this));
              if (paramAnonymousBoolean1) {
                break label357;
              }
            } while (!paramAnonymousBoolean2);
          }
        }
      });
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(this.kgm));
      if (this.dhE != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).wHV = this.dhE;
      }
      if (!Util.isNullOrNil(this.wZz)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).wZz = this.wZz;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).Keg = true;
      String str = this.gte.getIntent().getStringExtra("url");
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).Keh = str;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).pHw = e.a.akL(this.gte.getIntent().getIntExtra("qbarScene", -1));
      eqb localeqb = new eqb();
      localeqb.KJS = this.gte.getIntent().getIntExtra("Contact_Sub_Scene", 0);
      localeqb.Lru = this.gte.getIntent().getStringExtra("Contact_Scene_Note");
      if (!Util.isNullOrNil(str))
      {
        if (Util.isNullOrNil(localeqb.Lru)) {
          localeqb.Lru = str;
        }
        if (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(str)) {
          localeqb.NnE = aKw(str);
        }
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).Kei = localeqb;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.Bfi);
      AppMethodBeat.o(231998);
      return;
    }
    Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    bg.azz().a(536, this);
    Object localObject2 = new dr();
    ((dr)localObject2).dGF.dGH = ((String)localObject1);
    ((dr)localObject2).dGF.opType = 1;
    EventCenter.instance.publish((IEvent)localObject2);
    Object localObject1 = ((dr)localObject2).dGG.dGJ;
    localObject2 = this.gte;
    this.gte.getString(2131755998);
    this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject2, this.gte.getString(2131756029), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(231974);
        bg.azz().b(536, c.this);
        paramAnonymousDialogInterface = new dr();
        paramAnonymousDialogInterface.dGF.opType = 2;
        paramAnonymousDialogInterface.dGF.dGJ = this.dAK;
        EventCenter.instance.publish(paramAnonymousDialogInterface);
        AppMethodBeat.o(231974);
      }
    });
    AppMethodBeat.o(231998);
  }
  
  private boolean eEs()
  {
    AppMethodBeat.i(231997);
    if (this.gte.getIntent() == null)
    {
      AppMethodBeat.o(231997);
      return false;
    }
    String str1 = this.gte.getIntent().getStringExtra("device_id");
    String str2 = this.gte.getIntent().getStringExtra("device_type");
    dv localdv = new dv();
    localdv.dGR.dGL = str1;
    localdv.dGR.dGP = str2;
    EventCenter.instance.publish(localdv);
    boolean bool = localdv.dGS.dGT;
    AppMethodBeat.o(231997);
    return bool;
  }
  
  private void eFA()
  {
    boolean bool = true;
    AppMethodBeat.i(231990);
    this.gyr.setVisibility(0);
    int i;
    ImageView localImageView;
    as localas;
    String str;
    if (System.currentTimeMillis() - Bjx < 2000L)
    {
      i = 1;
      localImageView = this.gyr;
      localas = this.contact;
      if (!this.Bjy) {
        break label101;
      }
      str = "";
      label54:
      if ((this.Bjy) || (i == 0)) {
        break label109;
      }
    }
    for (;;)
    {
      d.a(localImageView, localas, str, bool);
      if (!this.Bjy) {
        break label114;
      }
      this.gyr.setClickable(false);
      AppMethodBeat.o(231990);
      return;
      i = 0;
      break;
      label101:
      str = this.Bdj;
      break label54;
      label109:
      bool = false;
    }
    label114:
    this.gyr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(231984);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = c.f(c.this).field_username;
        paramAnonymousView = new Intent(c.b(c.this), ProfileHdHeadImg.class);
        paramAnonymousView.putExtra("username", (String)localObject);
        paramAnonymousView.putExtra("brand_icon_url", c.s(c.this));
        localObject = c.b(c.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.axQ(), "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(231984);
      }
    });
    AppMethodBeat.o(231990);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void eFB()
  {
    AppMethodBeat.i(231991);
    String str = this.contact.signature;
    Object localObject = b.BlS;
    localObject = str;
    if (b.a.aKA(str)) {
      localObject = this.gte.getString(2131757834);
    }
    localObject = l.c(this.gte, (CharSequence)localObject);
    this.pIP.aw((CharSequence)localObject);
    this.pIP.setVisibility(0);
    if ((this.Bdk == null) || (this.Bdk.cG(false) == null) || (this.Bdk.cG(false).Vb() == null) || (Util.isNullOrNil(this.Bdk.cG(false).Vb().diD)))
    {
      Log.i("MicroMsg.ContactWidgetTabBizHeaderController", "bizInfo aboutBizUrl is null, arrow setVisibility GONE");
      this.hXw.setVisibility(8);
    }
    for (;;)
    {
      this.pIP.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.h(this.pIP, new com.tencent.mm.pluginsdk.ui.span.o())
      {
        public final void onLongPress(MotionEvent paramAnonymousMotionEvent) {}
        
        @SuppressLint({"ResourceType"})
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(231968);
          c.a(c.this, paramAnonymousMotionEvent);
          boolean bool = super.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          AppMethodBeat.o(231968);
          return bool;
        }
      });
      this.hXw.setOnTouchListener(new View.OnTouchListener()
      {
        @SuppressLint({"ResourceType"})
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(231969);
          c.a(c.this, paramAnonymousMotionEvent);
          AppMethodBeat.o(231969);
          return false;
        }
      });
      this.pIP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(231970);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          c.t(c.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(231970);
        }
      });
      this.hXw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(231971);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          c.t(c.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(231971);
        }
      });
      AppMethodBeat.o(231991);
      return;
      this.hXw.setVisibility(0);
    }
  }
  
  private void eFC()
  {
    int j = 1;
    AppMethodBeat.i(231992);
    if (this.contact == null)
    {
      this.BlU.setVisibility(8);
      this.BlV.setVisibility(8);
      this.BlT.setVisibility(8);
      AppMethodBeat.o(231992);
      return;
    }
    if ((this.gte.getIntent() != null) && (this.gte.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      i = 1;
      if (i != 0)
      {
        Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "Hard device biz...");
        boolean bool = eEs();
        Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "contact.isContact()(%b), isHarDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.contact.c.oR(this.contact.field_type)), Boolean.valueOf(bool) });
        if ((!com.tencent.mm.contact.c.oR(this.contact.field_type)) || (!bool))
        {
          if (!bool) {
            break label231;
          }
          this.BlU.setText(2131757816);
        }
      }
      label163:
      if ((i == 0) || (eEs())) {
        break label244;
      }
    }
    label231:
    label244:
    for (int i = j;; i = 0)
    {
      if ((com.tencent.mm.contact.c.oR(this.contact.field_type)) && (i == 0)) {
        break label249;
      }
      this.BlV.setVisibility(8);
      this.BlT.setVisibility(8);
      this.BlU.setVisibility(0);
      AppMethodBeat.o(231992);
      return;
      i = 0;
      break;
      this.BlU.setText(2131757823);
      break label163;
    }
    label249:
    this.BlV.setVisibility(0);
    this.BlT.setVisibility(0);
    this.BlU.setVisibility(8);
    AppMethodBeat.o(231992);
  }
  
  private void eFD()
  {
    int i = 0;
    AppMethodBeat.i(231993);
    Object localObject = sM(false);
    if (!Util.isNullOrNil((String)localObject))
    {
      this.BlW.setVisibility(0);
      this.BlW.aw((CharSequence)localObject);
      int j = this.BiU.KWf.KSY;
      int k = this.BiU.KWf.KSZ;
      if ((j > 0) && (k > 0))
      {
        j = com.tencent.mm.cb.a.jn(this.gte);
        k = (int)(com.tencent.mm.cb.a.getDensity(this.gte) * 32.0F);
        localObject = this.BlW.mq(j - k, 2147483647);
        if (localObject != null) {
          i = ((com.tencent.neattextview.textview.layout.a)localObject).hiG();
        }
        if (i > 1)
        {
          localObject = sM(true);
          this.BlW.aw((CharSequence)localObject);
        }
      }
      AppMethodBeat.o(231993);
      return;
    }
    this.BlW.setVisibility(8);
    AppMethodBeat.o(231993);
  }
  
  private void eFE()
  {
    AppMethodBeat.i(231994);
    if ((this.BiU == null) || (this.BiU.KWp == null))
    {
      AppMethodBeat.o(231994);
      return;
    }
    Object localObject = this.BiU.KWp;
    final String str = z.a(((qj)localObject).KXl);
    localObject = z.a(((qj)localObject).KXm);
    if ((Util.isNullOrNil((String)localObject)) || (Util.isNullOrNil(str)))
    {
      this.BlY.setVisibility(8);
      AppMethodBeat.o(231994);
      return;
    }
    this.BlZ.setText(Util.safeFormatString(this.gte.getString(2131757826), new Object[] { localObject }));
    this.BlY.setVisibility(0);
    this.BlY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(231972);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.plugin.report.service.h.CyF.a(22118, new Object[] { Long.valueOf(c.j(c.this)), c.f(c.this).field_username, Integer.valueOf(2), str, this.Bmf });
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_enter_profile_type", 12);
        paramAnonymousView.putExtra("finder_username", str);
        ((aj)com.tencent.mm.kernel.g.ah(aj.class)).enterFinderProfileUI(MMApplicationContext.getContext(), paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(231972);
      }
    });
    AppMethodBeat.o(231994);
  }
  
  private boolean eFb()
  {
    boolean bool1 = true;
    AppMethodBeat.i(231996);
    try
    {
      String str = this.dhv.UV();
      boolean bool2 = Util.isNullOrNil(str);
      if (bool2)
      {
        AppMethodBeat.o(231996);
        return false;
      }
      long l = Util.getLong(str, 0L);
      if ((l > 0L) && (l - System.currentTimeMillis() / 1000L < 0L)) {}
      for (;;)
      {
        Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "isBizAccountTimeExpired:%b", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(231996);
        return bool1;
        bool1 = false;
      }
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(231996);
    }
  }
  
  private void eFz()
  {
    AppMethodBeat.i(231989);
    int i;
    boolean bool;
    if ((com.tencent.mm.storage.ab.clc()) && (com.tencent.mm.contact.c.oR(this.contact.field_type)) && (this.contact.arE()) && (com.tencent.mm.al.g.Nd(this.contact.field_username)))
    {
      i = 1;
      bool = this.contact.gBN();
      if (i == 0) {
        break label361;
      }
    }
    label361:
    for (Object localObject1 = Util.nullAsNil(this.contact.field_nickname) + "*";; localObject1 = Util.nullAsNil(this.contact.field_nickname))
    {
      Object localObject2 = localObject1;
      if (bool) {
        localObject2 = (String)localObject1 + "*";
      }
      localObject1 = l.b(this.gte, (CharSequence)localObject2, this.titleTv.getTextSize());
      int k = ((SpannableString)localObject1).length() - 1;
      int j;
      if (bool)
      {
        j = k;
        if (i != 0) {
          j = k - 1;
        }
        localObject2 = this.gte.getResources().getDrawable(2131233123);
        k = (int)(this.gte.getResources().getDisplayMetrics().density * 6.0F + 0.5F);
        int m = com.tencent.mm.cb.a.fromDPToPix(this.gte, 18);
        ((Drawable)localObject2).setBounds(k, 0, m + k, m);
        ((SpannableString)localObject1).setSpan(new com.tencent.mm.ui.widget.a((Drawable)localObject2), j, j + 1, 17);
      }
      if (i != 0)
      {
        localObject2 = this.gte.getResources().getDrawable(2131231352);
        i = (int)(this.gte.getResources().getDisplayMetrics().density * 6.0F + 0.5F);
        j = com.tencent.mm.cb.a.fromDPToPix(this.gte, 18);
        ((Drawable)localObject2).setBounds(i, 0, j + i, j);
        ((SpannableString)localObject1).setSpan(new com.tencent.mm.ui.widget.a((Drawable)localObject2), ((SpannableString)localObject1).length() - 1, ((SpannableString)localObject1).length(), 17);
      }
      this.titleTv.setText((CharSequence)localObject1);
      AppMethodBeat.o(231989);
      return;
      i = 0;
      break;
    }
  }
  
  private String sM(boolean paramBoolean)
  {
    AppMethodBeat.i(231995);
    Object localObject = new StringBuilder();
    if (this.BiU.KWf != null)
    {
      String str1 = this.BiU.KWf.KTb;
      String str2 = this.BiU.KWf.KTc;
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
          AppMethodBeat.o(231995);
          return localObject;
          ((StringBuilder)localObject).append("  ");
        }
      }
      if (!Util.isNullOrNil(str1))
      {
        ((StringBuilder)localObject).append(str1);
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(231995);
        return localObject;
      }
      if (!Util.isNullOrNil(str2))
      {
        ((StringBuilder)localObject).append(str2);
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(231995);
        return localObject;
      }
    }
    AppMethodBeat.o(231995);
    return "";
  }
  
  private void updateView()
  {
    AppMethodBeat.i(231988);
    if (this.contact == null)
    {
      Log.w("MicroMsg.ContactWidgetTabBizHeaderController", "initView contact is null, return");
      AppMethodBeat.o(231988);
      return;
    }
    if (this.Bdk == null) {
      this.Bdk = com.tencent.mm.al.g.fJ(this.contact.field_username);
    }
    if (this.Bdk != null) {
      this.Bdj = this.Bdk.field_brandIconURL;
    }
    eFz();
    eFA();
    eFB();
    eFC();
    eFD();
    eFE();
    this.lJI.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(231982);
        c.p(c.this).getViewTreeObserver().removeOnPreDrawListener(this);
        LinkedList localLinkedList = c.a(c.this, c.q(c.this));
        if ((c.n(c.this).getLineCount() > 1) && (localLinkedList != null) && (!localLinkedList.isEmpty())) {
          c.o(c.this).setVisibility(0);
        }
        for (;;)
        {
          if (c.a(c.this).getLineCount() >= 3) {
            c.a(c.this).setTextSize(0, com.tencent.mm.cb.a.aH(c.r(c.this), 2131165589));
          }
          AppMethodBeat.o(231982);
          return true;
          c.o(c.this).setVisibility(8);
        }
      }
    });
    Object localObject = c(this.BiU);
    if ((localObject != null) && (!((LinkedList)localObject).isEmpty()))
    {
      this.ptA.setVisibility(0);
      if (this.ptA.getLineCount() > 1) {
        this.BlX.setVisibility(0);
      }
      for (;;)
      {
        localObject = new ArrayList((Collection)localObject);
        final int i = (com.tencent.mm.cb.a.jn(this.gte) - (int)(com.tencent.mm.cb.a.getDensity(this.gte) * 40.0F)) / 2;
        this.ptA.a((List)localObject, new LabelsView.a() {});
        AppMethodBeat.o(231988);
        return;
        this.BlX.setVisibility(8);
      }
    }
    this.ptA.setVisibility(8);
    this.BlX.setVisibility(8);
    AppMethodBeat.o(231988);
  }
  
  public final void a(a parama)
  {
    this.Bmb = parama;
  }
  
  public final void a(ph paramph, com.tencent.mm.api.c paramc, String paramString)
  {
    AppMethodBeat.i(231987);
    this.BiU = paramph;
    this.Bdk = paramc;
    this.wZz = paramString;
    if (paramph != null)
    {
      if ((paramph.KTf & 0x2) != 0) {
        this.Bjy = true;
      }
      if (!eFb()) {
        break label66;
      }
      this.vun.setVisibility(8);
    }
    for (;;)
    {
      updateView();
      AppMethodBeat.o(231987);
      return;
      label66:
      this.vun.setVisibility(0);
    }
  }
  
  public final void a(as paramas, String paramString, com.tencent.mm.api.c paramc, ph paramph, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(231986);
    this.Bdj = paramString;
    this.Bdk = paramc;
    this.contact = paramas;
    this.BiU = paramph;
    this.kgm = paramInt;
    this.Bdx = paramBoolean;
    if (paramc != null) {
      this.dhv = paramc.cG(false);
    }
    if ((this.dhv != null) && (this.dhv.US() != null) && (this.dhv.US().length() > 0)) {
      this.dhE = this.dhv.US();
    }
    updateView();
    AppMethodBeat.o(231986);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(232000);
    Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramq == null)
    {
      Log.e("MicroMsg.ContactWidgetTabBizHeaderController", "scene == null");
      AppMethodBeat.o(232000);
      return;
    }
    bg.azz().b(paramq.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.ContactWidgetTabBizHeaderController", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
      AppMethodBeat.o(232000);
      return;
    }
    Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
    if (paramq.getType() == 536)
    {
      bg.azz().b(536, this);
      updateView();
    }
    AppMethodBeat.o(232000);
  }
  
  public static abstract interface a
  {
    public abstract void eFF();
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.c
 * JD-Core Version:    0.7.0.1
 */