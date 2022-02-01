package com.tencent.mm.plugin.profile.ui.tab;

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
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.an.af;
import com.tencent.mm.an.g;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.h;
import com.tencent.mm.api.n;
import com.tencent.mm.api.r;
import com.tencent.mm.autogen.a.ei;
import com.tencent.mm.autogen.a.ei.b;
import com.tencent.mm.autogen.a.em;
import com.tencent.mm.autogen.a.em.b;
import com.tencent.mm.autogen.a.ug;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.brandservice.api.h.a;
import com.tencent.mm.plugin.finder.view.EllipsizedTextView;
import com.tencent.mm.plugin.finder.view.FlowTextMixView;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.fws;
import com.tencent.mm.protocal.protobuf.nj;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.protocal.protobuf.rl;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.protocal.protobuf.rp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.f.a;
import com.tencent.mm.ui.tools.o;
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

public final class ContactWidgetTabBizHeaderController
  implements com.tencent.mm.am.h
{
  private static long NcY = 0L;
  private View DmL;
  View FwQ;
  private AppBarLayout HJa;
  private MMNeat7extView Ilj;
  IListener Ixi;
  com.tencent.mm.plugin.brandservice.api.a Ixk;
  private String MVf;
  com.tencent.mm.api.c MVg;
  private boolean MVt;
  private int MXc;
  private Bundle MXh;
  private SnsAdClick MXi;
  private String MXj;
  qm NcO;
  boolean NcZ;
  private ImageView Nda;
  private FlowTextMixView Ndb;
  private EllipsizedTextView Ndc;
  private Button Ndd;
  private Button Nde;
  private ImageButton Ndf;
  private View Ndg;
  private View Ndh;
  private View Ndi;
  private MMNeat7extView Ndj;
  private View Ndk;
  private TextView Ndl;
  c Ndm;
  private View Ndn;
  private boolean Ndo;
  private String Ndp;
  private b Ndq;
  a Ndr;
  private String Nds;
  private boolean Ndt;
  private int Ndu;
  private boolean Ndv;
  long Ndw;
  private au contact;
  private long enterTime;
  String hAw;
  private c.b hcC;
  private String hcL;
  private ImageView lKK;
  private MMActivity lzt;
  String pPi;
  private int pUt;
  private View rootView;
  private com.tencent.mm.ui.base.w tipDialog;
  private LabelsView vII;
  private View xQI;
  
  public ContactWidgetTabBizHeaderController(MMActivity paramMMActivity, View paramView)
  {
    AppMethodBeat.i(305945);
    this.NcZ = false;
    this.hAw = null;
    this.MXi = null;
    this.Ndo = false;
    this.Ndp = "";
    this.MXc = 0;
    this.Nds = "";
    this.Ndu = 0;
    this.Ndv = false;
    this.Ixk = null;
    this.Ixi = null;
    this.Ndw = 0L;
    this.rootView = paramView;
    this.lzt = paramMMActivity;
    this.lKK = ((ImageView)this.rootView.findViewById(R.h.fuG));
    this.Nda = ((ImageView)this.rootView.findViewById(R.h.fuI));
    this.Ndb = ((FlowTextMixView)this.rootView.findViewById(R.h.ftR));
    this.Ndc = ((EllipsizedTextView)this.rootView.findViewById(R.h.fuK));
    this.Ilj = ((MMNeat7extView)this.rootView.findViewById(R.h.fuH));
    this.DmL = this.rootView.findViewById(R.h.fLN);
    this.Ndd = ((Button)this.rootView.findViewById(R.h.ftE));
    this.Nde = ((Button)this.rootView.findViewById(R.h.ftC));
    this.Ndf = ((ImageButton)this.rootView.findViewById(R.h.ftG));
    this.Ndg = this.rootView.findViewById(R.h.ftF);
    this.Ndh = this.rootView.findViewById(R.h.ftD);
    this.Ndi = this.rootView.findViewById(R.h.ftH);
    this.Ndj = ((MMNeat7extView)this.rootView.findViewById(R.h.ftK));
    this.vII = ((LabelsView)this.rootView.findViewById(R.h.ftM));
    this.FwQ = this.rootView.findViewById(R.h.ftJ);
    this.Ndk = this.rootView.findViewById(R.h.ftL);
    this.HJa = ((AppBarLayout)this.rootView.findViewById(R.h.ftP));
    this.xQI = this.rootView.findViewById(R.h.ftO);
    this.Ndl = ((TextView)this.rootView.findViewById(R.h.ftN));
    this.Ndn = this.rootView.findViewById(R.h.fBU);
    o.F(this.xQI, 0.7F);
    this.HJa.a(new AppBarLayout.b()
    {
      public final void onOffsetChanged(AppBarLayout paramAnonymousAppBarLayout, int paramAnonymousInt)
      {
        AppMethodBeat.i(305899);
        int i = paramAnonymousAppBarLayout.getTotalScrollRange();
        int j = Math.abs(paramAnonymousInt);
        if (ContactWidgetTabBizHeaderController.b(ContactWidgetTabBizHeaderController.this) != null) {}
        for (paramAnonymousInt = ContactWidgetTabBizHeaderController.b(ContactWidgetTabBizHeaderController.this).getBottom();; paramAnonymousInt = 0)
        {
          if (ContactWidgetTabBizHeaderController.c(ContactWidgetTabBizHeaderController.this) == null)
          {
            AppMethodBeat.o(305899);
            return;
          }
          if (j >= paramAnonymousInt)
          {
            if (ContactWidgetTabBizHeaderController.d(ContactWidgetTabBizHeaderController.this) != null) {
              ContactWidgetTabBizHeaderController.d(ContactWidgetTabBizHeaderController.this).AG(false);
            }
            ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this, ContactWidgetTabBizHeaderController.c(ContactWidgetTabBizHeaderController.this).field_nickname);
          }
          for (;;)
          {
            if ((ContactWidgetTabBizHeaderController.e(ContactWidgetTabBizHeaderController.this) >= i) && (j < ContactWidgetTabBizHeaderController.e(ContactWidgetTabBizHeaderController.this)) && (ContactWidgetTabBizHeaderController.d(ContactWidgetTabBizHeaderController.this) != null)) {
              ContactWidgetTabBizHeaderController.d(ContactWidgetTabBizHeaderController.this).gCL();
            }
            ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this, j);
            AppMethodBeat.o(305899);
            return;
            if (ContactWidgetTabBizHeaderController.d(ContactWidgetTabBizHeaderController.this) != null) {
              ContactWidgetTabBizHeaderController.d(ContactWidgetTabBizHeaderController.this).AG(true);
            }
            ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this, ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this).getString(R.l.gvI));
          }
        }
      }
    });
    this.Nde.setOnClickListener(new ContactWidgetTabBizHeaderController.17(this));
    this.Ndd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(305903);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (ContactWidgetTabBizHeaderController.f(ContactWidgetTabBizHeaderController.this) != null)
        {
          paramAnonymousView = new ug();
          ContactWidgetTabBizHeaderController.f(ContactWidgetTabBizHeaderController.this).oTP = 5;
          paramAnonymousView.hXY.hXZ = ContactWidgetTabBizHeaderController.f(ContactWidgetTabBizHeaderController.this);
          paramAnonymousView.publish();
        }
        ContactWidgetTabBizHeaderController.g(ContactWidgetTabBizHeaderController.this);
        ContactWidgetTabBizHeaderController.b(ContactWidgetTabBizHeaderController.this, 5);
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(ContactWidgetTabBizHeaderController.c(ContactWidgetTabBizHeaderController.this).field_username, 300, ContactWidgetTabBizHeaderController.h(ContactWidgetTabBizHeaderController.this), ContactWidgetTabBizHeaderController.i(ContactWidgetTabBizHeaderController.this), ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this).getIntent());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(305903);
      }
    });
    this.Ndf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(305891);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ContactWidgetTabBizHeaderController.this.gCz();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(305891);
      }
    });
    o.F(this.Ndk, 0.7F);
    this.Ndk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(305894);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        ContactWidgetTabBizHeaderController.j(ContactWidgetTabBizHeaderController.this).setMaxLines(0);
        ContactWidgetTabBizHeaderController.k(ContactWidgetTabBizHeaderController.this).setVisibility(8);
        paramAnonymousView = com.tencent.mm.plugin.profile.ui.tab.data.b.Ner;
        com.tencent.mm.plugin.profile.ui.tab.data.b.ap(ContactWidgetTabBizHeaderController.c(ContactWidgetTabBizHeaderController.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(305894);
      }
    });
    this.vII.setOnLabelClickListener(new LabelsView.b()
    {
      public final void onLabelClick(TextView paramAnonymousTextView, Object paramAnonymousObject, int paramAnonymousInt)
      {
        AppMethodBeat.i(305892);
        paramAnonymousTextView = (rl)paramAnonymousObject;
        paramAnonymousObject = new Intent();
        paramAnonymousObject.putExtra("rawUrl", paramAnonymousTextView.YWu);
        paramAnonymousObject.putExtra("geta8key_scene", 3);
        com.tencent.mm.br.c.b(ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this), "webview", ".ui.tools.WebViewUI", paramAnonymousObject);
        paramAnonymousObject = com.tencent.mm.plugin.profile.ui.tab.data.b.Ner;
        com.tencent.mm.plugin.profile.ui.tab.data.b.a(ContactWidgetTabBizHeaderController.c(ContactWidgetTabBizHeaderController.this), paramAnonymousTextView);
        AppMethodBeat.o(305892);
      }
    });
    this.MXi = ((SnsAdClick)this.lzt.getIntent().getParcelableExtra("KSnsAdTag"));
    this.MXj = this.lzt.getIntent().getStringExtra("key_add_contact_report_info");
    this.MXc = this.lzt.getIntent().getIntExtra("add_more_friend_search_scene", 0);
    this.MXh = this.lzt.getIntent().getBundleExtra("Contact_Ext_Args");
    if (this.MXh != null) {
      this.Ndp = this.MXh.getString("Contact_Ext_Args_Search_Click_Id", "");
    }
    this.enterTime = System.currentTimeMillis();
    AppMethodBeat.o(305945);
  }
  
  private String AF(boolean paramBoolean)
  {
    AppMethodBeat.i(306111);
    Object localObject = new StringBuilder();
    if (this.NcO.YVm != null)
    {
      String str1 = this.NcO.YVm.YRz;
      String str2 = this.NcO.YVm.YRA;
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
          AppMethodBeat.o(306111);
          return localObject;
          ((StringBuilder)localObject).append("  ");
        }
      }
      if (!Util.isNullOrNil(str1))
      {
        ((StringBuilder)localObject).append(str1);
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(306111);
        return localObject;
      }
      if (!Util.isNullOrNil(str2))
      {
        ((StringBuilder)localObject).append(str2);
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(306111);
        return localObject;
      }
    }
    AppMethodBeat.o(306111);
    return "";
  }
  
  private void aSg(String paramString)
  {
    AppMethodBeat.i(306015);
    long l = System.currentTimeMillis();
    if (l - this.Ndw < 1000L)
    {
      AppMethodBeat.o(306015);
      return;
    }
    this.Ndw = l;
    int i = ad.getSessionId();
    int j = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiE(this.hAw);
    com.tencent.mm.plugin.report.service.h.OAn.b(23044, new Object[] { Integer.valueOf(1), this.hAw, Integer.valueOf(this.pUt), Integer.valueOf(i), paramString, Integer.valueOf(j), Integer.valueOf(1), "" });
    Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "reportExposed bizUserName=%s, liveScene=%d, addContactScene=%d", new Object[] { this.hAw, Integer.valueOf(j), Integer.valueOf(this.pUt) });
    AppMethodBeat.o(306015);
  }
  
  private static int aSh(String paramString)
  {
    int j = 10000;
    AppMethodBeat.i(306135);
    int i = j;
    if (!Util.isNullOrNil(paramString)) {}
    try
    {
      i = Util.getInt(Uri.parse(paramString).getQueryParameter("scene"), 10000);
      AppMethodBeat.o(306135);
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
  
  private LinkedList<rl> c(qm paramqm)
  {
    if (paramqm == null) {
      return null;
    }
    try
    {
      paramqm = paramqm.YVv;
      if (paramqm == null) {
        return null;
      }
    }
    finally {}
    paramqm = paramqm.YWw;
    return paramqm;
  }
  
  static boolean dbC()
  {
    AppMethodBeat.i(305956);
    boolean bool = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).dbC();
    AppMethodBeat.o(305956);
    return bool;
  }
  
  private boolean gBA()
  {
    AppMethodBeat.i(306117);
    if (this.lzt.getIntent() == null)
    {
      AppMethodBeat.o(306117);
      return false;
    }
    String str1 = this.lzt.getIntent().getStringExtra("device_id");
    String str2 = this.lzt.getIntent().getStringExtra("device_type");
    em localem = new em();
    localem.hEt.hEl = str1;
    localem.hEt.hEr = str2;
    localem.publish();
    boolean bool = localem.hEu.hEv;
    AppMethodBeat.o(306117);
    return bool;
  }
  
  private void gBz()
  {
    AppMethodBeat.i(306127);
    NcY = System.currentTimeMillis();
    if ((this.lzt.getIntent() != null) && (this.lzt.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.lzt.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!Util.isNullOrNil((String)localObject1)) {
        break label326;
      }
      Log.i("MicroMsg.ContactWidgetTabBizHeaderController", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label326:
    while (gBA())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.lzt, new a.a()
      {
        public final void canAddContact(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(305898);
          au localau;
          if (paramAnonymousBoolean1)
          {
            com.tencent.mm.ui.base.k.cZ(ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this), ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this).getString(R.l.gAU));
            localau = ContactWidgetTabBizHeaderController.c(ContactWidgetTabBizHeaderController.this);
            if ((localau != null) && (!Util.isNullOrNil(paramAnonymousString1))) {
              break label383;
            }
            Log.e("MicroMsg.ContactWidgetTabBizHeaderController", "respUsername == " + paramAnonymousString1 + ", contact = " + localau);
            if (ContactWidgetTabBizHeaderController.f(ContactWidgetTabBizHeaderController.this) != null)
            {
              paramAnonymousString1 = new ug();
              ContactWidgetTabBizHeaderController.f(ContactWidgetTabBizHeaderController.this).oTP = 4;
              paramAnonymousString1.hXY.hXZ = ContactWidgetTabBizHeaderController.f(ContactWidgetTabBizHeaderController.this);
              paramAnonymousString1.publish();
            }
            if (ContactWidgetTabBizHeaderController.w(ContactWidgetTabBizHeaderController.this) != null) {
              ContactWidgetTabBizHeaderController.w(ContactWidgetTabBizHeaderController.this);
            }
            paramAnonymousString1 = af.bHf().Mn(ContactWidgetTabBizHeaderController.c(ContactWidgetTabBizHeaderController.this).field_username);
            if (paramAnonymousString1 != null)
            {
              paramAnonymousString1.field_status = 1;
              if ((!Util.isNullOrNil(paramAnonymousString1.field_extInfo)) || (Util.isNullOrNil(paramAnonymousString1.field_username)) || (ContactWidgetTabBizHeaderController.x(ContactWidgetTabBizHeaderController.this) == null) || (!paramAnonymousString1.field_username.equals(Util.nullAsNil(ContactWidgetTabBizHeaderController.x(ContactWidgetTabBizHeaderController.this).field_username)))) {
                break label671;
              }
              af.bHf().h(ContactWidgetTabBizHeaderController.x(ContactWidgetTabBizHeaderController.this));
              label244:
              paramAnonymousBoolean1 = ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this).getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
              paramAnonymousBoolean2 = ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this).getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
              if (!paramAnonymousString1.aAP()) {
                break label682;
              }
              paramAnonymousString1 = new Intent();
              paramAnonymousString1.putExtra("enterprise_biz_name", ContactWidgetTabBizHeaderController.c(ContactWidgetTabBizHeaderController.this).field_username);
              paramAnonymousString1.putExtra("enterprise_biz_display_name", aa.getDisplayName(ContactWidgetTabBizHeaderController.c(ContactWidgetTabBizHeaderController.this).field_username));
              paramAnonymousString1.putExtra("enterprise_from_scene", 7);
              paramAnonymousString1.addFlags(67108864);
              com.tencent.mm.br.c.g(ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this), ".ui.conversation.EnterpriseConversationUI", paramAnonymousString1);
            }
          }
          label612:
          for (;;)
          {
            label359:
            ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this).finish();
            label383:
            do
            {
              ContactWidgetTabBizHeaderController.b(ContactWidgetTabBizHeaderController.this, 3);
              AppMethodBeat.o(305898);
              return;
              paramAnonymousString2 = null;
              if (au.bxa(localau.field_username))
              {
                String str = Util.nullAsNil(localau.field_username);
                paramAnonymousString2 = g.hU(str);
                if (paramAnonymousString2 != null) {
                  paramAnonymousString2.field_username = paramAnonymousString1;
                }
                af.bHf().Mo(str);
                localau.Bd(str);
              }
              localau.setUsername(paramAnonymousString1);
              if ((int)localau.maN == 0)
              {
                bh.bCz();
                com.tencent.mm.model.c.bzA().aC(localau);
              }
              if ((int)localau.maN <= 0)
              {
                Log.e("MicroMsg.ContactWidgetTabBizHeaderController", "addContact : insert contact failed");
                break;
              }
              ab.I(localau);
              bh.bCz();
              paramAnonymousString1 = com.tencent.mm.model.c.bzA().JE(localau.field_username);
              if (paramAnonymousString2 != null)
              {
                af.bHf().g(paramAnonymousString2);
                break;
              }
              paramAnonymousString2 = g.hU(paramAnonymousString1.field_username);
              if ((paramAnonymousString1.iZC()) && (com.tencent.mm.an.a.bGz())) {}
              for (int i = 1;; i = 0)
              {
                if ((paramAnonymousString2 != null) && ((!paramAnonymousString2.aAJ()) || (i != 0))) {
                  break label612;
                }
                Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "shouldUpdate");
                az.a.okP.aZ(paramAnonymousString1.field_username, "");
                com.tencent.mm.modelavatar.d.LA(paramAnonymousString1.field_username);
                break;
              }
              if ((!paramAnonymousString1.iZI()) || (i != 0)) {
                break;
              }
              Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramAnonymousString1.kak) });
              az.a.okP.aZ(paramAnonymousString1.field_username, "");
              com.tencent.mm.modelavatar.d.LA(paramAnonymousString1.field_username);
              break;
              af.bHf().h(paramAnonymousString1);
              break label244;
              paramAnonymousString1 = new Intent();
              paramAnonymousString1.putExtra("Chat_User", ContactWidgetTabBizHeaderController.c(ContactWidgetTabBizHeaderController.this).field_username);
              paramAnonymousString1.putExtra("key_has_add_contact", true);
              paramAnonymousString1.putExtra("finish_direct", true);
              if (paramAnonymousBoolean2) {
                paramAnonymousString1.addFlags(268435456);
              }
              ad.bvE(ContactWidgetTabBizHeaderController.c(ContactWidgetTabBizHeaderController.this).field_username);
              com.tencent.mm.plugin.profile.b.pFn.d(paramAnonymousString1, ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this));
              if (paramAnonymousBoolean1) {
                break label359;
              }
            } while (!paramAnonymousBoolean2);
          }
        }
      });
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(this.pUt));
      if (this.hcL != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).His = this.hcL;
      }
      if (!Util.isNullOrNil(this.pPi)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).pPi = this.pPi;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).YaS = true;
      String str = this.lzt.getIntent().getStringExtra("url");
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).YaT = str;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).AcJ = f.a.azW(this.lzt.getIntent().getIntExtra("qbarScene", -1));
      fws localfws = new fws();
      localfws.YIc = this.lzt.getIntent().getIntExtra("Contact_Sub_Scene", 0);
      localfws.Zsa = this.lzt.getIntent().getStringExtra("Contact_Scene_Note");
      localfws.YVk = this.Ndp;
      if (!Util.isNullOrNil(str))
      {
        if (Util.isNullOrNil(localfws.Zsa)) {
          localfws.Zsa = str;
        }
        if (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiy(str)) {
          localfws.abUy = aSh(str);
        }
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).YaU = localfws;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.MXj);
      gCK();
      AppMethodBeat.o(306127);
      return;
    }
    Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    bh.aZW().a(536, this);
    Object localObject2 = new ei();
    ((ei)localObject2).hEe.hEg = ((String)localObject1);
    ((ei)localObject2).hEe.opType = 1;
    ((ei)localObject2).publish();
    Object localObject1 = ((ei)localObject2).hEf.hEi;
    localObject2 = this.lzt;
    this.lzt.getString(R.l.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.k.a((Context)localObject2, this.lzt.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(305885);
        bh.aZW().b(536, ContactWidgetTabBizHeaderController.this);
        paramAnonymousDialogInterface = new ei();
        paramAnonymousDialogInterface.hEe.opType = 2;
        paramAnonymousDialogInterface.hEe.hEi = this.hxO;
        paramAnonymousDialogInterface.publish();
        AppMethodBeat.o(305885);
      }
    });
    AppMethodBeat.o(306127);
  }
  
  private void gCB()
  {
    int m = 4;
    AppMethodBeat.i(306005);
    int i;
    boolean bool1;
    Object localObject1;
    SpannableString localSpannableString;
    Object localObject2;
    int j;
    label154:
    int k;
    float f;
    Object localObject3;
    if ((com.tencent.mm.contact.d.rs(this.contact.field_type)) && (this.contact.aSQ()) && (g.My(this.contact.field_username)))
    {
      i = 1;
      bool1 = this.contact.iZD();
      localObject1 = Util.nullAsNil(this.contact.field_nickname);
      localSpannableString = com.tencent.mm.pluginsdk.ui.span.p.b(this.lzt, (CharSequence)localObject1, this.Ndc.getTextSize());
      boolean bool2 = aw.isDarkMode();
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.profile.ui.a)com.tencent.mm.ui.component.k.d(this.lzt).q(com.tencent.mm.plugin.profile.ui.a.class)).setValue("biz_timeline_profile_author_title", (String)localObject1);
      localObject2 = new SpannableString("");
      if (!bool1) {
        break label880;
      }
      localObject2 = this.lzt.getResources();
      if (!bool2) {
        break label815;
      }
      j = R.g.fnU;
      localObject2 = ((Resources)localObject2).getDrawable(j);
      k = com.tencent.mm.cd.a.fromDPToPix(this.lzt, 4);
      f = com.tencent.mm.cd.a.getScaleSize(this.lzt);
      j = com.tencent.mm.cd.a.fromDPToPix(this.lzt, 19);
      if (f >= 1.125F) {
        j = com.tencent.mm.cd.a.fromDPToPix(this.lzt, 23);
      }
      ((Drawable)localObject2).setBounds(k, 0, j + k, j);
      localObject3 = new com.tencent.mm.ui.widget.a((Drawable)localObject2, 1);
      localObject2 = new SpannableString("@");
      ((SpannableString)localObject2).setSpan(localObject3, 0, 1, 33);
      localObject1 = (String)localObject1 + MMApplicationContext.getResources().getString(R.l.biz_timeline_auth);
    }
    label328:
    label611:
    label880:
    for (;;)
    {
      Object localObject4 = new SpannableString("");
      if (i != 0)
      {
        localObject3 = this.lzt.getResources().getDrawable(R.g.biz_timeline_star_icon);
        localObject4 = this.lzt;
        if (bool1)
        {
          j = 2;
          k = com.tencent.mm.cd.a.fromDPToPix((Context)localObject4, j);
          f = com.tencent.mm.cd.a.getScaleSize(this.lzt);
          j = com.tencent.mm.cd.a.fromDPToPix(this.lzt, 18);
          if (f >= 1.125F) {
            j = com.tencent.mm.cd.a.fromDPToPix(this.lzt, 21);
          }
          ((Drawable)localObject3).setBounds(k, 0, j + k, j);
          localObject4 = new com.tencent.mm.ui.widget.a((Drawable)localObject3, 1);
          localObject3 = new SpannableString("@");
          ((SpannableString)localObject3).setSpan(localObject4, 0, 1, 33);
          localObject4 = (String)localObject1 + MMApplicationContext.getResources().getString(R.l.biz_timeline_star);
          localObject1 = localObject3;
          localObject3 = localObject4;
        }
      }
      for (;;)
      {
        localObject4 = com.tencent.mm.ui.component.k.aeZF;
        ((com.tencent.mm.plugin.profile.ui.a)com.tencent.mm.ui.component.k.d(this.lzt).q(com.tencent.mm.plugin.profile.ui.a.class)).setValue("biz_timeline_profile_author_title_with_state", (String)localObject3);
        if (dbC())
        {
          localObject3 = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiD(this.hAw);
          if ((Util.isNullOrNil((String)localObject3)) || (!((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiF(this.hAw))) {
            break label827;
          }
          j = 1;
          if ((j == 0) && (!MultiProcessMMKV.getSingleMMKV("brandService").decodeBool("ProfileAllaysShowLive", false))) {
            break label857;
          }
          this.Nda.setVisibility(0);
          localObject4 = LocaleUtil.getApplicationLanguage();
          if ((!Util.isEqual((String)localObject4, "zh_CN")) && (!Util.isEqual((String)localObject4, "zh_HK")) && (!Util.isEqual((String)localObject4, "zh_TW"))) {
            break label832;
          }
          j = 1;
          localObject4 = this.Nda;
          if (j == 0) {
            break label837;
          }
          k = R.g.biz_live_chinese;
          label626:
          ((ImageView)localObject4).setImageResource(k);
          localObject4 = this.lzt;
          if (j == 0) {
            break label845;
          }
          j = 53;
          k = com.tencent.mm.cd.a.fromDPToPix((Context)localObject4, j);
          localObject4 = this.lzt;
          j = m;
          if (!bool1)
          {
            if (i == 0) {
              break label851;
            }
            j = m;
          }
          i = com.tencent.mm.cd.a.fromDPToPix((Context)localObject4, j);
          this.Ndb.setItemSpacing(i);
          this.Ndc.setExtraEllipsizeWidth(k);
          aSg((String)localObject3);
          o.F(this.Nda, 0.5F);
          localObject4 = (FrameLayout.LayoutParams)this.Nda.getLayoutParams();
          ((FrameLayout.LayoutParams)localObject4).width = k;
          ((FrameLayout.LayoutParams)localObject4).height = com.tencent.mm.cd.a.fromDPToPix(this.lzt, 18);
          this.Nda.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.Nda.setOnClickListener(new ContactWidgetTabBizHeaderController.4(this, (String)localObject3));
        }
        for (;;)
        {
          this.Ndc.setText(TextUtils.concat(new CharSequence[] { localSpannableString, localObject2, localObject1 }));
          AppMethodBeat.o(306005);
          return;
          i = 0;
          break;
          j = R.g.fnT;
          break label154;
          j = 4;
          break label328;
          j = 0;
          break label543;
          j = 0;
          break label611;
          k = R.g.biz_live_eng;
          break label626;
          j = 42;
          break label646;
          j = 7;
          break label675;
          this.Nda.setVisibility(8);
        }
        localObject3 = localObject1;
        localObject1 = localObject4;
      }
    }
  }
  
  private void gCC()
  {
    AppMethodBeat.i(306031);
    if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("FinderProfileForbidenDisplayRedPacketLink", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      final String str = this.lzt.getIntent().getStringExtra("biz_profile_enter_from_luck_money_spring_event_url");
      Log.i("MicroMsg.ContactWidgetTabBizHeaderController", "shouldBanLuckMoney = %s, springEventLuckMoneyUrl = %s", new Object[] { Boolean.valueOf(bool), str });
      if ((Util.isNullOrNil(str)) || (bool)) {
        break;
      }
      TextView localTextView = (TextView)this.Ndn.findViewById(R.h.fBV);
      com.tencent.mm.plugin.brandservice.ui.b.e locale = com.tencent.mm.plugin.brandservice.ui.b.e.vYK;
      com.tencent.mm.plugin.brandservice.ui.b.e.l(localTextView);
      Log.i("MicroMsg.ContactWidgetTabBizHeaderController", "show luck money cover tips");
      if (!this.Ndt)
      {
        this.Ndt = true;
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(this.contact.field_username, 1801, this.pUt, this.enterTime, this.lzt.getIntent());
      }
      this.Ndn.setVisibility(0);
      this.Ndn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(305869);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i("MicroMsg.ContactWidgetTabBizHeaderController", "click luck money cover tips");
          if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
          {
            Log.i("MicroMsg.ContactWidgetTabBizHeaderController", "click luck money, teen mode");
            ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this));
            com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(ContactWidgetTabBizHeaderController.c(ContactWidgetTabBizHeaderController.this).field_username, 1803, ContactWidgetTabBizHeaderController.h(ContactWidgetTabBizHeaderController.this), ContactWidgetTabBizHeaderController.i(ContactWidgetTabBizHeaderController.this), ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this).getIntent());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(305869);
            return;
          }
          com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(ContactWidgetTabBizHeaderController.c(ContactWidgetTabBizHeaderController.this).field_username, 1802, ContactWidgetTabBizHeaderController.h(ContactWidgetTabBizHeaderController.this), ContactWidgetTabBizHeaderController.i(ContactWidgetTabBizHeaderController.this), ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this).getIntent());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", str);
          paramAnonymousView.putExtra("geta8key_scene", 3);
          com.tencent.mm.br.c.b(ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(305869);
        }
      });
      AppMethodBeat.o(306031);
      return;
    }
    Log.i("MicroMsg.ContactWidgetTabBizHeaderController", "hide luck money cover tips");
    this.Ndn.setVisibility(8);
    AppMethodBeat.o(306031);
  }
  
  private void gCD()
  {
    boolean bool = true;
    AppMethodBeat.i(306046);
    this.lKK.setVisibility(0);
    int i;
    ImageView localImageView;
    au localau;
    String str;
    if (System.currentTimeMillis() - NcY < 2000L)
    {
      i = 1;
      localImageView = this.lKK;
      localau = this.contact;
      if (!this.NcZ) {
        break label101;
      }
      str = "";
      label54:
      if ((this.NcZ) || (i == 0)) {
        break label109;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.brandservice.model.e.a(localImageView, localau, str, bool);
      if (!this.NcZ) {
        break label114;
      }
      this.lKK.setClickable(false);
      AppMethodBeat.o(306046);
      return;
      i = 0;
      break;
      label101:
      str = this.MVf;
      break label54;
      label109:
      bool = false;
    }
    label114:
    this.lKK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(305868);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        localObject = ContactWidgetTabBizHeaderController.c(ContactWidgetTabBizHeaderController.this).field_username;
        paramAnonymousView = new Intent(ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this), ProfileHdHeadImg.class);
        paramAnonymousView.putExtra("username", (String)localObject);
        paramAnonymousView.putExtra("brand_icon_url", ContactWidgetTabBizHeaderController.t(ContactWidgetTabBizHeaderController.this));
        localObject = ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject).startActivity((Intent)paramAnonymousView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$14", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(305868);
      }
    });
    AppMethodBeat.o(306046);
  }
  
  private void gCE()
  {
    AppMethodBeat.i(306061);
    String str = this.contact.signature;
    Object localObject = b.NcM;
    localObject = str;
    if (b.a.aSf(str)) {
      localObject = this.lzt.getString(R.l.gAT);
    }
    localObject = com.tencent.mm.pluginsdk.ui.span.p.b(this.lzt, (CharSequence)localObject);
    this.Ilj.aZ((CharSequence)localObject);
    this.Ilj.setVisibility(0);
    if ((this.MVg == null) || (this.MVg.dO(false) == null) || (this.MVg.dO(false).aBl() == null) || (Util.isNullOrNil(this.MVg.dO(false).aBl().hdK)))
    {
      Log.i("MicroMsg.ContactWidgetTabBizHeaderController", "bizInfo aboutBizUrl is null, arrow setVisibility GONE");
      this.DmL.setVisibility(8);
    }
    for (;;)
    {
      this.Ilj.setOnTouchListener(new l(this.Ilj, new com.tencent.mm.pluginsdk.ui.span.s())
      {
        public final void onLongPress(MotionEvent paramAnonymousMotionEvent) {}
        
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(305877);
          ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this, paramAnonymousMotionEvent);
          boolean bool = super.onTouch(paramAnonymousView, paramAnonymousMotionEvent);
          AppMethodBeat.o(305877);
          return bool;
        }
      });
      this.DmL.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(305871);
          ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this, paramAnonymousMotionEvent);
          AppMethodBeat.o(305871);
          return false;
        }
      });
      this.Ilj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(305870);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          ContactWidgetTabBizHeaderController.u(ContactWidgetTabBizHeaderController.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(305870);
        }
      });
      this.DmL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(305888);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          ContactWidgetTabBizHeaderController.u(ContactWidgetTabBizHeaderController.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(305888);
        }
      });
      AppMethodBeat.o(306061);
      return;
      this.DmL.setVisibility(0);
    }
  }
  
  private void gCF()
  {
    int j = 1;
    AppMethodBeat.i(306080);
    if (this.contact == null)
    {
      this.Nde.setVisibility(8);
      this.Ndf.setVisibility(8);
      this.Ndd.setVisibility(8);
      this.Ndh.setVisibility(8);
      this.Ndi.setVisibility(8);
      this.Ndg.setVisibility(8);
      AppMethodBeat.o(306080);
      return;
    }
    if ((this.lzt.getIntent() != null) && (this.lzt.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      i = 1;
      if (i != 0)
      {
        Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "Hard device biz...");
        boolean bool = gBA();
        Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "contact.isContact()(%b), isHarDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.contact.d.rs(this.contact.field_type)), Boolean.valueOf(bool) });
        if ((!com.tencent.mm.contact.d.rs(this.contact.field_type)) || (!bool))
        {
          if (!bool) {
            break label284;
          }
          this.Nde.setText(R.l.gAG);
        }
      }
      label190:
      if ((i == 0) || (gBA())) {
        break label297;
      }
    }
    label284:
    label297:
    for (int i = j;; i = 0)
    {
      if ((com.tencent.mm.contact.d.rs(this.contact.field_type)) && (i == 0)) {
        break label302;
      }
      this.Ndf.setVisibility(8);
      this.Ndd.setVisibility(8);
      this.Nde.setVisibility(0);
      this.Ndi.setVisibility(8);
      this.Ndg.setVisibility(8);
      this.Ndh.setVisibility(0);
      AppMethodBeat.o(306080);
      return;
      i = 0;
      break;
      this.Nde.setText(R.l.gAI);
      break label190;
    }
    label302:
    this.Ndf.setVisibility(0);
    this.Ndd.setVisibility(0);
    this.Nde.setVisibility(8);
    this.Ndi.setVisibility(0);
    this.Ndg.setVisibility(0);
    this.Ndh.setVisibility(8);
    AppMethodBeat.o(306080);
  }
  
  private void gCG()
  {
    int i = 0;
    AppMethodBeat.i(306089);
    Object localObject = AF(false);
    if (!Util.isNullOrNil((String)localObject))
    {
      this.Ndj.setVisibility(0);
      this.Ndj.aZ((CharSequence)localObject);
      int j = this.NcO.YVm.YRw;
      int k = this.NcO.YVm.YRx;
      if ((j > 0) && (k > 0))
      {
        j = com.tencent.mm.cd.a.ms(this.lzt);
        k = (int)(com.tencent.mm.cd.a.getDensity(this.lzt) * 32.0F);
        localObject = this.Ndj.pE(j - k, 2147483647);
        if (localObject != null) {
          i = ((com.tencent.neattextview.textview.layout.a)localObject).jQH();
        }
        if (i > 1)
        {
          localObject = AF(true);
          this.Ndj.aZ((CharSequence)localObject);
        }
      }
      AppMethodBeat.o(306089);
      return;
    }
    this.Ndj.setVisibility(8);
    AppMethodBeat.o(306089);
  }
  
  private void gCH()
  {
    AppMethodBeat.i(306102);
    if ((this.NcO == null) || (this.NcO.YVw == null))
    {
      AppMethodBeat.o(306102);
      return;
    }
    Object localObject = this.NcO.YVw;
    final String str = com.tencent.mm.platformtools.w.a(((rp)localObject).YWz);
    localObject = com.tencent.mm.platformtools.w.a(((rp)localObject).YWA);
    if ((Util.isNullOrNil((String)localObject)) || (Util.isNullOrNil(str)))
    {
      this.xQI.setVisibility(8);
      AppMethodBeat.o(306102);
      return;
    }
    this.Ndl.setText(Util.safeFormatString(this.lzt.getString(R.l.gAO), new Object[] { localObject }));
    this.xQI.setVisibility(0);
    this.xQI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(305880);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.plugin.report.service.h.OAn.b(22118, new Object[] { Long.valueOf(ContactWidgetTabBizHeaderController.i(ContactWidgetTabBizHeaderController.this)), ContactWidgetTabBizHeaderController.c(ContactWidgetTabBizHeaderController.this).field_username, Integer.valueOf(2), str, this.NdF });
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_enter_profile_type", 12);
        paramAnonymousView.putExtra("finder_username", str);
        paramAnonymousView.putExtra("KEY_DO_NOT_CHECK_ENTER_BIZ_PROFILE", true);
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderProfileUI(ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this), paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(305880);
      }
    });
    AppMethodBeat.o(306102);
  }
  
  /* Error */
  private void gCK()
  {
    // Byte code:
    //   0: ldc_w 1299
    //   3: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 181	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   10: invokevirtual 343	com/tencent/mm/ui/MMActivity:getIntent	()Landroid/content/Intent;
    //   13: astore 13
    //   15: aload 13
    //   17: ldc_w 1301
    //   20: iconst_0
    //   21: invokevirtual 367	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   24: invokestatic 1306	com/tencent/mm/plugin/profile/ui/newbizinfo/b/b:afU	(I)I
    //   27: istore_1
    //   28: aload 13
    //   30: ldc_w 1308
    //   33: invokevirtual 359	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 14
    //   38: aload 13
    //   40: ldc_w 1310
    //   43: invokevirtual 359	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 15
    //   48: aload 13
    //   50: ldc_w 1312
    //   53: iconst_0
    //   54: invokevirtual 367	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   57: aload 14
    //   59: invokestatic 1316	com/tencent/mm/plugin/profile/ui/newbizinfo/b/b:cw	(ILjava/lang/String;)I
    //   62: istore_2
    //   63: aload 13
    //   65: ldc_w 1318
    //   68: invokevirtual 359	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 8
    //   73: aload 13
    //   75: ldc_w 773
    //   78: invokevirtual 359	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 12
    //   83: aload 13
    //   85: ldc_w 369
    //   88: invokevirtual 373	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   91: astore 10
    //   93: ldc 161
    //   95: astore 9
    //   97: aload 10
    //   99: ifnull +15 -> 114
    //   102: aload 10
    //   104: ldc_w 592
    //   107: ldc 161
    //   109: invokevirtual 383	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   112: astore 9
    //   114: aload 13
    //   116: ldc_w 778
    //   119: iconst_m1
    //   120: invokevirtual 367	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   123: invokestatic 783	com/tencent/mm/ui/f$a:azW	(I)I
    //   126: istore_3
    //   127: aload_0
    //   128: getfield 582	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController:contact	Lcom/tencent/mm/storage/au;
    //   131: getfield 611	com/tencent/mm/autogen/b/az:field_username	Ljava/lang/String;
    //   134: astore 16
    //   136: aload 9
    //   138: invokestatic 422	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   141: ifne +430 -> 571
    //   144: aload 9
    //   146: invokestatic 595	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   149: ldc_w 1320
    //   152: invokestatic 1325	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   155: astore 9
    //   157: aload 8
    //   159: astore 10
    //   161: aload 8
    //   163: invokestatic 595	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   166: ldc_w 1320
    //   169: invokestatic 1325	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 8
    //   174: aload 8
    //   176: astore 10
    //   178: aload 12
    //   180: invokestatic 595	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   183: ldc_w 1320
    //   186: invokestatic 1325	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   189: astore 11
    //   191: aload 11
    //   193: astore 10
    //   195: getstatic 533	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   198: sipush 16232
    //   201: bipush 9
    //   203: anewarray 4	java/lang/Object
    //   206: dup
    //   207: iconst_0
    //   208: iload_1
    //   209: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: dup
    //   214: iconst_1
    //   215: iload_2
    //   216: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
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
    //   250: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   253: aastore
    //   254: dup
    //   255: bipush 8
    //   257: aload 16
    //   259: aastore
    //   260: invokevirtual 544	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   263: aload_0
    //   264: getfield 361	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController:MXj	Ljava/lang/String;
    //   267: invokestatic 422	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   270: ifne +16 -> 286
    //   273: getstatic 533	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   276: sipush 16697
    //   279: aload_0
    //   280: getfield 361	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController:MXj	Ljava/lang/String;
    //   283: invokevirtual 626	com/tencent/mm/plugin/report/service/h:kvStat	(ILjava/lang/String;)V
    //   286: aload 13
    //   288: ldc_w 1301
    //   291: iconst_0
    //   292: invokevirtual 367	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   295: istore_1
    //   296: invokestatic 389	java/lang/System:currentTimeMillis	()J
    //   299: ldc2_w 509
    //   302: ldiv
    //   303: l2i
    //   304: i2l
    //   305: lstore 4
    //   307: iload_1
    //   308: sipush 160
    //   311: if_icmpne +148 -> 459
    //   314: aload 13
    //   316: ldc_w 1327
    //   319: lconst_0
    //   320: invokevirtual 1331	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   323: lstore 6
    //   325: getstatic 533	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   328: sipush 15721
    //   331: bipush 9
    //   333: anewarray 4	java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: aload_0
    //   339: getfield 582	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController:contact	Lcom/tencent/mm/storage/au;
    //   342: getfield 611	com/tencent/mm/autogen/b/az:field_username	Ljava/lang/String;
    //   345: aastore
    //   346: dup
    //   347: iconst_1
    //   348: iconst_0
    //   349: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   352: aastore
    //   353: dup
    //   354: iconst_2
    //   355: bipush 14
    //   357: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   360: aastore
    //   361: dup
    //   362: iconst_3
    //   363: lload 4
    //   365: invokestatic 1336	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   368: aastore
    //   369: dup
    //   370: iconst_4
    //   371: invokestatic 515	com/tencent/mm/storage/ad:getSessionId	()I
    //   374: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: aastore
    //   378: dup
    //   379: iconst_5
    //   380: iconst_0
    //   381: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   384: aastore
    //   385: dup
    //   386: bipush 6
    //   388: lload 6
    //   390: invokestatic 1336	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   393: aastore
    //   394: dup
    //   395: bipush 7
    //   397: ldc 161
    //   399: aastore
    //   400: dup
    //   401: bipush 8
    //   403: iconst_1
    //   404: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: aastore
    //   408: invokevirtual 544	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   411: getstatic 533	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   414: ldc2_w 1337
    //   417: ldc2_w 1339
    //   420: lconst_1
    //   421: iconst_0
    //   422: invokevirtual 1344	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   425: ldc_w 1299
    //   428: invokestatic 394	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   431: return
    //   432: astore 10
    //   434: ldc 161
    //   436: astore 9
    //   438: ldc_w 546
    //   441: aload 10
    //   443: ldc 161
    //   445: iconst_0
    //   446: anewarray 4	java/lang/Object
    //   449: invokestatic 1348	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   452: aload 12
    //   454: astore 10
    //   456: goto -261 -> 195
    //   459: iload_1
    //   460: sipush 174
    //   463: if_icmpne +88 -> 551
    //   466: getstatic 533	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   469: sipush 15721
    //   472: bipush 9
    //   474: anewarray 4	java/lang/Object
    //   477: dup
    //   478: iconst_0
    //   479: aload_0
    //   480: getfield 582	com/tencent/mm/plugin/profile/ui/tab/ContactWidgetTabBizHeaderController:contact	Lcom/tencent/mm/storage/au;
    //   483: getfield 611	com/tencent/mm/autogen/b/az:field_username	Ljava/lang/String;
    //   486: aastore
    //   487: dup
    //   488: iconst_1
    //   489: iconst_0
    //   490: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   493: aastore
    //   494: dup
    //   495: iconst_2
    //   496: bipush 21
    //   498: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   501: aastore
    //   502: dup
    //   503: iconst_3
    //   504: lload 4
    //   506: invokestatic 1336	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   509: aastore
    //   510: dup
    //   511: iconst_4
    //   512: invokestatic 515	com/tencent/mm/storage/ad:getSessionId	()I
    //   515: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   518: aastore
    //   519: dup
    //   520: iconst_5
    //   521: iconst_0
    //   522: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   525: aastore
    //   526: dup
    //   527: bipush 6
    //   529: iconst_0
    //   530: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   533: aastore
    //   534: dup
    //   535: bipush 7
    //   537: ldc 161
    //   539: aastore
    //   540: dup
    //   541: bipush 8
    //   543: iconst_3
    //   544: invokestatic 539	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   547: aastore
    //   548: invokevirtual 544	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   551: ldc_w 1299
    //   554: invokestatic 394	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   557: return
    //   558: astore 11
    //   560: aload 10
    //   562: astore 8
    //   564: aload 11
    //   566: astore 10
    //   568: goto -130 -> 438
    //   571: ldc 161
    //   573: astore 9
    //   575: aload 12
    //   577: astore 10
    //   579: goto -384 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	this	ContactWidgetTabBizHeaderController
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
  
  public final void a(au paramau, String paramString, com.tencent.mm.api.c paramc, qm paramqm, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(306290);
    this.MVf = paramString;
    this.MVg = paramc;
    this.contact = paramau;
    this.NcO = paramqm;
    this.pUt = paramInt;
    this.MVt = paramBoolean;
    if (paramc != null) {
      this.hcC = paramc.dO(false);
    }
    if (paramau != null)
    {
      this.hAw = paramau.field_username;
      if ((!this.hAw.startsWith("gh_")) && (paramqm != null) && (paramqm.YVl != null)) {
        this.hAw = paramqm.YVl.UserName;
      }
    }
    if ((this.hcC != null) && (this.hcC.aBc() != null) && (this.hcC.aBc().length() > 0)) {
      this.hcL = this.hcC.aBc();
    }
    if (paramqm != null) {
      this.Ndm = new c(this.lzt, paramqm, this.rootView, this.enterTime);
    }
    updateView();
    AppMethodBeat.o(306290);
  }
  
  public final void gCA()
  {
    AppMethodBeat.i(306296);
    if (this.Ndo)
    {
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(this.lzt);
      if ((this.contact != null) && (this.contact.field_username != null)) {
        ((r)com.tencent.mm.kernel.h.ax(r.class)).e(7, this.contact.field_username, this.contact.field_nickname);
      }
      AppMethodBeat.o(306296);
      return;
    }
    if (!com.tencent.mm.model.gdpr.c.bEh()) {
      gBz();
    }
    for (;;)
    {
      if (this.MXc != 0) {
        com.tencent.mm.plugin.report.service.h.OAn.b(11263, new Object[] { Integer.valueOf(this.MXc), this.contact.field_username });
      }
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(this.contact.field_username, 200, this.pUt, this.enterTime, this.lzt.getIntent());
      AppMethodBeat.o(306296);
      return;
      com.tencent.mm.model.gdpr.c.a(this.lzt, com.tencent.mm.model.gdpr.a.ooo, this.contact.field_username, new com.tencent.mm.model.gdpr.b()
      {
        public final void onPermissionReturn(int paramAnonymousInt)
        {
          AppMethodBeat.i(305881);
          if (paramAnonymousInt == 0) {
            ContactWidgetTabBizHeaderController.v(ContactWidgetTabBizHeaderController.this);
          }
          AppMethodBeat.o(305881);
        }
      });
    }
  }
  
  final boolean gCI()
  {
    boolean bool1 = true;
    AppMethodBeat.i(306304);
    try
    {
      String str = this.hcC.aBf();
      boolean bool2 = Util.isNullOrNil(str);
      if (bool2)
      {
        AppMethodBeat.o(306304);
        return false;
      }
      long l = Util.getLong(str, 0L);
      if ((l > 0L) && (l - System.currentTimeMillis() / 1000L < 0L)) {}
      for (;;)
      {
        Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "isBizAccountTimeExpired:%b", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(306304);
        return bool1;
        bool1 = false;
      }
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(306304);
    }
  }
  
  public final void gCJ()
  {
    AppMethodBeat.i(306308);
    if (this.HJa != null) {
      this.HJa.c(true, true, true);
    }
    AppMethodBeat.o(306308);
  }
  
  public final void gCz()
  {
    AppMethodBeat.i(306293);
    ((n)com.tencent.mm.kernel.h.ax(n.class)).a(this.MVg, this.lzt, this.contact, true, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(305893);
        ContactWidgetTabBizHeaderController.b(ContactWidgetTabBizHeaderController.this, 4);
        ContactWidgetTabBizHeaderController.m(ContactWidgetTabBizHeaderController.this).announceForAccessibility(ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this).getResources().getString(R.l.biz_timeline_unfollow_remind));
        if (ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this).getIntent().getIntExtra("Kdel_from", -1) == 1)
        {
          Intent localIntent = new Intent();
          localIntent.addFlags(67108864);
          com.tencent.mm.br.c.b(ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this), "shake", ".ui.ShakeReportUI", localIntent);
        }
        AppMethodBeat.o(305893);
      }
    });
    com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.a(this.contact.field_username, 1000, this.pUt, this.enterTime, this.lzt.getIntent());
    AppMethodBeat.o(306293);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(306306);
    Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramp == null)
    {
      Log.e("MicroMsg.ContactWidgetTabBizHeaderController", "scene == null");
      AppMethodBeat.o(306306);
      return;
    }
    bh.aZW().b(paramp.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.ContactWidgetTabBizHeaderController", "scene.getType() = %s", new Object[] { Integer.valueOf(paramp.getType()) });
      AppMethodBeat.o(306306);
      return;
    }
    Log.d("MicroMsg.ContactWidgetTabBizHeaderController", "scene.getType() = %s", new Object[] { Integer.valueOf(paramp.getType()) });
    if (paramp.getType() == 536)
    {
      bh.aZW().b(536, this);
      updateView();
    }
    AppMethodBeat.o(306306);
  }
  
  final void updateView()
  {
    AppMethodBeat.i(306300);
    if (this.contact == null)
    {
      Log.w("MicroMsg.ContactWidgetTabBizHeaderController", "initView contact is null, return");
      AppMethodBeat.o(306300);
      return;
    }
    if (this.MVg == null) {
      this.MVg = g.hU(this.contact.field_username);
    }
    if ((this.MVg != null) && (!Util.isNullOrNil(this.MVg.field_brandIconURL))) {
      this.MVf = this.MVg.field_brandIconURL;
    }
    gCB();
    gCD();
    gCE();
    gCF();
    gCG();
    gCH();
    gCC();
    this.Ndm.gCy();
    this.rootView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(305863);
        ContactWidgetTabBizHeaderController.n(ContactWidgetTabBizHeaderController.this).getViewTreeObserver().removeOnPreDrawListener(this);
        Object localObject = ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this, ContactWidgetTabBizHeaderController.o(ContactWidgetTabBizHeaderController.this));
        if ((ContactWidgetTabBizHeaderController.j(ContactWidgetTabBizHeaderController.this).getLineCount() > 1) && (localObject != null) && (!((LinkedList)localObject).isEmpty()) && (ContactWidgetTabBizHeaderController.j(ContactWidgetTabBizHeaderController.this).getMaxLines() > 0)) {
          ContactWidgetTabBizHeaderController.k(ContactWidgetTabBizHeaderController.this).setVisibility(0);
        }
        for (;;)
        {
          if (ContactWidgetTabBizHeaderController.p(ContactWidgetTabBizHeaderController.this).getLineCount() >= 3)
          {
            localObject = ContactWidgetTabBizHeaderController.n(ContactWidgetTabBizHeaderController.this).findViewById(R.h.fuJ);
            androidx.constraintlayout.widget.a locala = new androidx.constraintlayout.widget.a();
            locala.b((ConstraintLayout)localObject);
            locala.au(R.h.ftR, 2);
            locala.l(R.h.ftR, 2, 0, 2);
            locala.au(R.h.ftJ, 3);
            locala.au(R.h.ftJ, 4);
            locala.e(R.h.ftJ, 3, R.h.ftR, 4, com.tencent.mm.cd.a.fromDPToPix(ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this), 12));
            locala.c((ConstraintLayout)localObject);
            ContactWidgetTabBizHeaderController.n(ContactWidgetTabBizHeaderController.this).getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
            {
              public final boolean onPreDraw()
              {
                AppMethodBeat.i(305873);
                ContactWidgetTabBizHeaderController.n(ContactWidgetTabBizHeaderController.this).getViewTreeObserver().removeOnPreDrawListener(this);
                if (ContactWidgetTabBizHeaderController.p(ContactWidgetTabBizHeaderController.this).getLineCount() >= 3)
                {
                  ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)ContactWidgetTabBizHeaderController.q(ContactWidgetTabBizHeaderController.this).getLayoutParams();
                  localLayoutParams.setMargins(localLayoutParams.leftMargin, com.tencent.mm.cd.a.fromDPToPix(ContactWidgetTabBizHeaderController.a(ContactWidgetTabBizHeaderController.this), 20), localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
                  ContactWidgetTabBizHeaderController.q(ContactWidgetTabBizHeaderController.this).setLayoutParams(localLayoutParams);
                }
                AppMethodBeat.o(305873);
                return true;
              }
            });
          }
          boolean bool = ContactWidgetTabBizHeaderController.r(ContactWidgetTabBizHeaderController.this);
          AppMethodBeat.o(305863);
          return bool;
          ContactWidgetTabBizHeaderController.k(ContactWidgetTabBizHeaderController.this).setVisibility(8);
        }
      }
    });
    Object localObject = c(this.NcO);
    if ((localObject != null) && (!((LinkedList)localObject).isEmpty()))
    {
      this.vII.setVisibility(0);
      ArrayList localArrayList;
      label244:
      rl localrl;
      h.a locala;
      if (this.vII.getLineCount() > 1)
      {
        this.Ndk.setVisibility(0);
        localArrayList = new ArrayList((Collection)localObject);
        final int i = (com.tencent.mm.cd.a.ms(this.lzt) - (int)(com.tencent.mm.cd.a.getDensity(this.lzt) * 40.0F)) / 2;
        this.vII.a(localArrayList, new LabelsView.a() {});
        localArrayList = new ArrayList();
        Iterator localIterator = ((LinkedList)localObject).iterator();
        if (!localIterator.hasNext()) {
          break label363;
        }
        localrl = (rl)localIterator.next();
        locala = new h.a();
        if (this.MVg == null) {
          break label357;
        }
      }
      label357:
      for (localObject = this.MVg.field_appId;; localObject = "")
      {
        locala.appId = ((String)localObject);
        locala.url = localrl.YWu;
        locala.title = localrl.YWs;
        locala.desc = localrl.YWt;
        locala.vAZ = 126;
        localArrayList.add(locala);
        break label244;
        this.Ndk.setVisibility(8);
        break;
      }
      label363:
      ((com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class)).z(localArrayList, 32);
      AppMethodBeat.o(306300);
      return;
    }
    this.vII.setVisibility(8);
    this.Ndk.setVisibility(8);
    AppMethodBeat.o(306300);
  }
  
  public static abstract interface a
  {
    public abstract void AG(boolean paramBoolean);
    
    public abstract void gCL();
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.ContactWidgetTabBizHeaderController
 * JD-Core Version:    0.7.0.1
 */