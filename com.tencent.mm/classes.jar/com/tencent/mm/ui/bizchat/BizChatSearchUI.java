package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.al.a.j;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.a.m;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.protocal.protobuf.nf;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.protocal.protobuf.pv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class BizChatSearchUI
  extends MMActivity
  implements b.a, BizChatSearchListView.a
{
  String JPU;
  private String JPV;
  private c JPW;
  private BizChatSearchListView JPX;
  private a JPY;
  private TextView fSm;
  com.tencent.mm.modelvoiceaddr.ui.b odO;
  String oeQ;
  private int scene;
  private AbsListView.OnScrollListener uxk;
  
  public BizChatSearchUI()
  {
    AppMethodBeat.i(34012);
    this.uxk = new AbsListView.OnScrollListener()
    {
      boolean odD = false;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
        {
          this.odD = true;
          return;
        }
        this.odD = false;
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33989);
        if ((paramAnonymousInt == 0) && (this.odD) && (BizChatSearchUI.a(BizChatSearchUI.this).JQt))
        {
          paramAnonymousAbsListView = BizChatSearchUI.a(BizChatSearchUI.this);
          if ((paramAnonymousAbsListView.fDW()) && (!paramAnonymousAbsListView.JQv))
          {
            paramAnonymousAbsListView.JQv = true;
            m localm = new m(paramAnonymousAbsListView.oeQ, paramAnonymousAbsListView.fUS, paramAnonymousAbsListView.JQB);
            bc.ajj().a(localm, 0);
            paramAnonymousAbsListView.fEa();
          }
        }
        AppMethodBeat.o(33989);
      }
    };
    AppMethodBeat.o(34012);
  }
  
  private void adh(int paramInt)
  {
    AppMethodBeat.i(34025);
    if (this.JPW != null) {
      this.JPW.updateStatus(paramInt);
    }
    AppMethodBeat.o(34025);
  }
  
  public final boolean JO(String paramString)
  {
    AppMethodBeat.i(34018);
    hideVKB();
    AppMethodBeat.o(34018);
    return true;
  }
  
  public final void JP(String paramString)
  {
    a locala = null;
    AppMethodBeat.i(34017);
    if ((bu.isNullOrNil(paramString)) && (this.JPV != null))
    {
      paramString = this.JPV;
      this.JPV = null;
      if (!paramString.equals("")) {
        this.odO.setSearchContent(paramString);
      }
      com.tencent.mm.modelvoiceaddr.ui.b localb = this.odO;
      if (a.c(this.JPY)) {
        paramString = getContext().getResources().getString(2131756682);
      }
      for (;;)
      {
        localb.setHint(paramString);
        this.odO.clearFocus();
        AppMethodBeat.o(34017);
        return;
        if (a.b(this.JPY))
        {
          paramString = getContext().getResources().getString(2131756686);
        }
        else
        {
          paramString = locala;
          if (a.e(this.JPY)) {
            paramString = getContext().getResources().getString(2131756679);
          }
        }
      }
    }
    locala = this.JPY;
    locala.fUS = paramString;
    if (bu.isNullOrNil(paramString))
    {
      locala.clearData();
      locala.JQu = false;
      locala.JQA = false;
      locala.xR(true);
      AppMethodBeat.o(34017);
      return;
    }
    if (locala.scene == 4) {}
    for (int i = 1; i != 0; i = 0)
    {
      locala.clearData();
      locala.JQu = false;
      locala.JQA = false;
      locala.aXm(paramString);
      AppMethodBeat.o(34017);
      return;
    }
    if (locala.fDW())
    {
      locala.JQu = true;
      locala.JQA = false;
      locala.fEa();
      locala.cU(paramString, false);
      locala.aXn(paramString);
      AppMethodBeat.o(34017);
      return;
    }
    locala.cU(paramString, true);
    if ((locala.JQc) && (locala.JQu)) {
      locala.aXn(paramString);
    }
    if (locala.JQe) {
      locala.aXm(paramString);
    }
    AppMethodBeat.o(34017);
  }
  
  final void a(com.tencent.mm.api.c paramc, int paramInt)
  {
    AppMethodBeat.i(187107);
    com.tencent.mm.al.d locald = ag.aGy().Ea(this.JPU);
    long l1;
    if (locald != null)
    {
      l1 = locald.field_wwCorpId;
      if (locald == null) {
        break label171;
      }
    }
    label171:
    for (long l2 = locald.field_wwUserVid;; l2 = 0L)
    {
      long l3 = paramc.KA();
      com.tencent.mm.plugin.report.service.g.yxI.f(14507, new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(paramInt) });
      ae.d("MicroMsg.BizChatSearchUI", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(paramInt) });
      AppMethodBeat.o(187107);
      return;
      l1 = 0L;
      break;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(34015);
    if (a.c(parama))
    {
      if (bu.isNullOrNil(a.d(parama)))
      {
        this.fSm.setVisibility(8);
        this.JPX.setVisibility(8);
        AppMethodBeat.o(34015);
        return;
      }
      if (parama.getCount() <= 0)
      {
        this.fSm.setVisibility(0);
        this.JPX.setVisibility(8);
        AppMethodBeat.o(34015);
        return;
      }
      this.fSm.setVisibility(8);
      this.JPX.setVisibility(0);
      AppMethodBeat.o(34015);
      return;
    }
    if (bu.isNullOrNil(a.d(parama)))
    {
      this.fSm.setVisibility(0);
      this.fSm.setText("");
      this.JPX.setVisibility(8);
    }
    while (a.b(parama)) {
      if (parama.JQv)
      {
        adh(1);
        AppMethodBeat.o(34015);
        return;
        if ((a.b(parama)) && (parama.JQu))
        {
          this.fSm.setVisibility(0);
          this.fSm.setText(2131756680);
          this.JPX.setVisibility(8);
        }
        else if ((a.b(parama)) && (parama.JQA))
        {
          this.fSm.setVisibility(0);
          this.fSm.setText(2131756681);
          this.JPX.setVisibility(8);
        }
        else if (parama.getCount() <= 0)
        {
          this.fSm.setVisibility(0);
          this.fSm.setText(com.tencent.mm.plugin.fts.a.f.a(getString(2131762920), getString(2131762919), com.tencent.mm.plugin.fts.a.a.e.c(a.d(parama), a.d(parama))).tFv);
          this.JPX.setVisibility(8);
        }
        else
        {
          this.fSm.setVisibility(8);
          this.JPX.setVisibility(0);
        }
      }
      else
      {
        if (parama.JQt)
        {
          adh(2);
          AppMethodBeat.o(34015);
          return;
        }
        adh(0);
      }
    }
    AppMethodBeat.o(34015);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final void aOF()
  {
    AppMethodBeat.i(34019);
    hideVKB();
    AppMethodBeat.o(34019);
  }
  
  public final void aSL()
  {
    AppMethodBeat.i(34016);
    finish();
    AppMethodBeat.o(34016);
  }
  
  public final void aSM() {}
  
  public final void aSN() {}
  
  public final void aSO() {}
  
  public final boolean bOS()
  {
    AppMethodBeat.i(34024);
    hideVKB();
    AppMethodBeat.o(34024);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131493847;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34014);
    if (bu.isNullOrNil(this.oeQ))
    {
      this.oeQ = getIntent().getStringExtra("enterprise_biz_name");
      this.JPU = getIntent().getStringExtra("enterprise_biz_father_name");
      this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
      this.JPV = getIntent().getStringExtra("biz_chat_search_text");
      if (bu.isNullOrNil(this.oeQ)) {
        finish();
      }
    }
    this.JPX = ((BizChatSearchListView)findViewById(2131297412));
    this.fSm = ((TextView)findViewById(2131302884));
    this.JPY = new a(getContext(), this.oeQ, this.JPU, this.scene);
    if (a.b(this.JPY))
    {
      this.JPW = new c((byte)0);
      BizChatSearchListView localBizChatSearchListView = this.JPX;
      c localc = this.JPW;
      View localView = View.inflate(getContext(), 2131494592, null);
      localc.odF = localView.findViewById(2131301508);
      localc.odG = localView.findViewById(2131301499);
      localc.odH = localView.findViewById(2131301510);
      localc.odF.setVisibility(8);
      localc.odG.setVisibility(8);
      localc.odH.setVisibility(8);
      localBizChatSearchListView.addFooterView(localView);
      adh(0);
    }
    this.JPX.setAdapter(this.JPY);
    this.JPX.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33990);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatSearchUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        paramAnonymousAdapterView = BizChatSearchUI.a(BizChatSearchUI.this).adi(paramAnonymousInt);
        localObject1 = BizChatSearchUI.this;
        if ((paramAnonymousAdapterView.oOD == BizChatSearchUI.g.JQF) || (paramAnonymousAdapterView.oOD == BizChatSearchUI.g.JQG))
        {
          paramAnonymousLong = -1L;
          if ((paramAnonymousAdapterView.data instanceof com.tencent.mm.al.a.c))
          {
            paramAnonymousAdapterView = (com.tencent.mm.al.a.c)paramAnonymousAdapterView.data;
            if (paramAnonymousAdapterView != null) {
              paramAnonymousLong = paramAnonymousAdapterView.field_bizChatLocalId;
            }
            if ((!bu.isNullOrNil(((BizChatSearchUI)localObject1).oeQ)) && (paramAnonymousLong >= 0L)) {
              break label431;
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatSearchUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(33990);
          return;
          if (!(paramAnonymousAdapterView.data instanceof nf)) {
            break;
          }
          paramAnonymousView = ((nf)paramAnonymousAdapterView.data).FZA;
          Object localObject2 = ((BizChatSearchUI)localObject1).oeQ;
          boolean bool1 = true;
          paramAnonymousAdapterView = new com.tencent.mm.al.a.k();
          paramAnonymousAdapterView.field_userId = paramAnonymousView.FZy;
          paramAnonymousAdapterView.field_userName = paramAnonymousView.oIy;
          paramAnonymousAdapterView.field_brandUserName = ((String)localObject2);
          paramAnonymousAdapterView.field_headImageUrl = paramAnonymousView.FZr;
          paramAnonymousAdapterView.field_profileUrl = paramAnonymousView.FZG;
          paramAnonymousAdapterView.field_UserVersion = paramAnonymousView.ver;
          paramAnonymousAdapterView.field_addMemberUrl = paramAnonymousView.FZv;
          if (!ag.aGt().b(paramAnonymousAdapterView)) {
            bool1 = ag.aGt().a(paramAnonymousAdapterView);
          }
          if (!bool1)
          {
            paramAnonymousLong = -1L;
            break;
          }
          paramAnonymousView = new com.tencent.mm.al.a.c();
          paramAnonymousView.field_bizChatServId = paramAnonymousAdapterView.field_userId;
          paramAnonymousView.field_brandUserName = paramAnonymousAdapterView.field_brandUserName;
          paramAnonymousView.field_chatName = paramAnonymousAdapterView.field_userName;
          paramAnonymousView.field_chatType = j.hVa.hVd;
          paramAnonymousAdapterView = com.tencent.mm.al.a.e.e(paramAnonymousView);
          if (paramAnonymousAdapterView == null)
          {
            paramAnonymousLong = -1L;
            break;
          }
          paramAnonymousView = ag.aGs().sf(paramAnonymousAdapterView.field_bizChatLocalId);
          paramAnonymousView.field_bizChatId = paramAnonymousAdapterView.field_bizChatLocalId;
          paramAnonymousView.field_unReadCount = 0;
          if (bu.isNullOrNil(paramAnonymousView.field_brandUserName))
          {
            paramAnonymousView.field_brandUserName = paramAnonymousAdapterView.field_brandUserName;
            paramAnonymousView.field_lastMsgTime = System.currentTimeMillis();
            paramAnonymousView.field_flag = paramAnonymousView.field_lastMsgTime;
          }
          if (!ag.aGs().b(paramAnonymousView)) {
            ag.aGs().a(paramAnonymousView);
          }
          paramAnonymousLong = paramAnonymousAdapterView.field_bizChatLocalId;
          break;
          label431:
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("Chat_User", ((BizChatSearchUI)localObject1).oeQ);
          paramAnonymousAdapterView.putExtra("key_biz_chat_id", paramAnonymousLong);
          paramAnonymousAdapterView.putExtra("finish_direct", true);
          paramAnonymousAdapterView.putExtra("key_need_send_video", false);
          paramAnonymousAdapterView.putExtra("key_is_biz_chat", true);
          com.tencent.mm.br.d.f(((BizChatSearchUI)localObject1).getContext(), ".ui.chatting.ChattingUI", paramAnonymousAdapterView);
          continue;
          if (paramAnonymousAdapterView.oOD == BizChatSearchUI.g.JQK) {}
          try
          {
            localObject2 = (pv)((com.tencent.mm.ui.base.sortview.d)paramAnonymousAdapterView.data).data;
            if (localObject2 == null) {
              continue;
            }
            bool1 = com.tencent.mm.al.g.Et(((pv)localObject2).userName);
            boolean bool2 = com.tencent.mm.al.g.vz(((pv)localObject2).userName);
            com.tencent.mm.api.c localc = com.tencent.mm.al.g.eX(((pv)localObject2).userName);
            if (localc == null) {
              paramAnonymousAdapterView = null;
            }
            for (;;)
            {
              if (bool1)
              {
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("rawUrl", paramAnonymousView);
                paramAnonymousAdapterView.putExtra("useJs", true);
                paramAnonymousAdapterView.putExtra("srcUsername", ((pv)localObject2).userName);
                paramAnonymousAdapterView.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                paramAnonymousAdapterView.addFlags(67108864);
                com.tencent.mm.br.d.b(((BizChatSearchUI)localObject1).getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousAdapterView);
                ((BizChatSearchUI)localObject1).a(localc, 2);
                break;
                paramAnonymousAdapterView = localc.Kz();
                break label1255;
              }
              if (bool2)
              {
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("Contact_User", ((pv)localObject2).userName);
                paramAnonymousAdapterView.addFlags(67108864);
                paramAnonymousAdapterView.putExtra("biz_chat_from_scene", 3);
                com.tencent.mm.br.d.f(((BizChatSearchUI)localObject1).getContext(), ".ui.bizchat.BizChatConversationUI", paramAnonymousAdapterView);
                break;
              }
              paramAnonymousAdapterView = new Intent();
              paramAnonymousAdapterView.addFlags(67108864);
              paramAnonymousAdapterView.putExtra("finish_direct", true);
              paramAnonymousAdapterView.putExtra("Chat_User", ((pv)localObject2).userName);
              paramAnonymousAdapterView.putExtra("chat_from_scene", 2);
              com.tencent.mm.plugin.brandservice.b.d(paramAnonymousAdapterView, ((BizChatSearchUI)localObject1).getContext());
              ((BizChatSearchUI)localObject1).a(localc, 1);
              break;
              if (paramAnonymousAdapterView.oOD != BizChatSearchUI.g.JQH) {
                break;
              }
              if (((Integer)paramAnonymousAdapterView.data).intValue() == BizChatSearchUI.g.JQM)
              {
                paramAnonymousAdapterView = new Intent(((BizChatSearchUI)localObject1).getContext(), BizChatSearchUI.class);
                paramAnonymousAdapterView.putExtra("enterprise_biz_name", ((BizChatSearchUI)localObject1).oeQ);
                paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 2);
                paramAnonymousAdapterView.putExtra("biz_chat_search_text", ((BizChatSearchUI)localObject1).odO.getSearchContent());
                paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousAdapterView.ahE(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((BizChatSearchUI)localObject1).startActivity((Intent)paramAnonymousAdapterView.mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
              }
              if (((Integer)paramAnonymousAdapterView.data).intValue() == BizChatSearchUI.g.JQN)
              {
                paramAnonymousAdapterView = new Intent(((BizChatSearchUI)localObject1).getContext(), BizChatSearchUI.class);
                paramAnonymousAdapterView.putExtra("enterprise_biz_name", ((BizChatSearchUI)localObject1).oeQ);
                paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 3);
                paramAnonymousAdapterView.putExtra("biz_chat_search_text", ((BizChatSearchUI)localObject1).odO.getSearchContent());
                paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousAdapterView.ahE(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreGroupUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((BizChatSearchUI)localObject1).startActivity((Intent)paramAnonymousAdapterView.mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreGroupUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
              }
              if (((Integer)paramAnonymousAdapterView.data).intValue() != BizChatSearchUI.g.JQO) {
                break;
              }
              paramAnonymousAdapterView = new Intent(((BizChatSearchUI)localObject1).getContext(), BizChatSearchUI.class);
              paramAnonymousAdapterView.putExtra("enterprise_biz_name", ((BizChatSearchUI)localObject1).oeQ);
              paramAnonymousAdapterView.putExtra("enterprise_biz_father_name", ((BizChatSearchUI)localObject1).JPU);
              paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 4);
              paramAnonymousAdapterView.putExtra("biz_chat_search_text", ((BizChatSearchUI)localObject1).odO.getSearchContent());
              paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousAdapterView.ahE(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreAppUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((BizChatSearchUI)localObject1).startActivity((Intent)paramAnonymousAdapterView.mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreAppUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              break;
              label1255:
              paramAnonymousView = paramAnonymousAdapterView;
              if (paramAnonymousAdapterView == null) {
                paramAnonymousView = "";
              }
            }
          }
          catch (Throwable paramAnonymousAdapterView) {}
        }
      }
    });
    this.JPX.setOnTouchListener(this);
    if (a.b(this.JPY)) {
      this.JPX.setOnScrollListener(this.uxk);
    }
    this.odO = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.odO.yP(a.c(this.JPY));
    this.odO.a(this);
    this.odO.iCq = false;
    AppMethodBeat.o(34014);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34013);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(34013);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(34022);
    this.odO.a(this, paramMenu);
    AppMethodBeat.o(34022);
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34021);
    super.onDestroy();
    AppMethodBeat.o(34021);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34020);
    super.onPause();
    this.odO.cancel();
    this.odO.clearFocus();
    AppMethodBeat.o(34020);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(34023);
    this.odO.a(this, paramMenu);
    AppMethodBeat.o(34023);
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
    implements com.tencent.mm.ak.f
  {
    public static int JQa = 3;
    private String JPU;
    public boolean JQA;
    int JQB;
    private int JQb;
    boolean JQc;
    boolean JQd;
    boolean JQe;
    private ArrayList<com.tencent.mm.al.a.c> JQf;
    private ArrayList<Object> JQg;
    private ArrayList<com.tencent.mm.al.a.c> JQh;
    private ArrayList<com.tencent.mm.ui.base.sortview.d> JQi;
    private List<com.tencent.mm.ui.base.sortview.d> JQj;
    private BizChatSearchUI.g JQk;
    private ArrayList<BizChatSearchUI.g> JQl;
    private BizChatSearchUI.g JQm;
    private BizChatSearchUI.g JQn;
    private ArrayList<BizChatSearchUI.g> JQo;
    private BizChatSearchUI.g JQp;
    private BizChatSearchUI.g JQq;
    private ArrayList<BizChatSearchUI.g> JQr;
    private BizChatSearchUI.g JQs;
    public boolean JQt;
    public boolean JQu;
    public boolean JQv;
    private boolean JQw;
    private boolean JQx;
    private int JQy;
    private int JQz;
    private int ajO;
    private Context context;
    String fUS;
    private com.tencent.mm.av.a.a.c ifW;
    String oeQ;
    int scene;
    
    public a(Context paramContext, String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(187103);
      this.JQf = new ArrayList();
      this.JQg = new ArrayList();
      this.JQh = new ArrayList();
      this.JQi = new ArrayList();
      this.JQl = new ArrayList();
      this.JQo = new ArrayList();
      this.JQr = new ArrayList();
      this.JQt = true;
      this.JQu = false;
      this.JQv = false;
      this.JQw = true;
      this.JQx = true;
      this.JQy = 0;
      this.JQz = 0;
      this.ajO = 0;
      this.JQA = false;
      this.JQB = 0;
      this.context = paramContext;
      this.oeQ = paramString1;
      this.JPU = paramString2;
      this.scene = paramInt;
      boolean bool1;
      if ((this.scene == 1) || (this.scene == 2))
      {
        bool1 = true;
        this.JQc = bool1;
        if ((this.scene != 1) && (this.scene != 3)) {
          break label359;
        }
        bool1 = true;
        label204:
        this.JQd = bool1;
        bool1 = bool2;
        if (!bu.isNullOrNil(this.JPU)) {
          if (this.scene != 1)
          {
            bool1 = bool2;
            if (this.scene != 4) {}
          }
          else
          {
            bool1 = true;
          }
        }
        this.JQe = bool1;
        if (this.scene != 1) {
          break label365;
        }
      }
      label359:
      label365:
      for (paramInt = JQa;; paramInt = 2147483647)
      {
        this.JQb = paramInt;
        paramContext = new c.a();
        paramContext.prefixPath = com.tencent.mm.al.a.e.ex(this.oeQ);
        paramContext.igk = true;
        paramContext.hgL = true;
        paramContext.igv = 2131690013;
        this.ifW = paramContext.aJu();
        if (this.JQe) {
          this.JQj = getSortEntityList();
        }
        if (this.JQc) {
          bc.ajj().a(1364, this);
        }
        AppMethodBeat.o(187103);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label204;
      }
    }
    
    private static SpannableString a(Context paramContext, Spannable paramSpannable, int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(33998);
      paramContext = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, paramSpannable, paramInt);
      ForegroundColorSpan[] arrayOfForegroundColorSpan = (ForegroundColorSpan[])paramSpannable.getSpans(0, paramSpannable.length(), ForegroundColorSpan.class);
      if (arrayOfForegroundColorSpan != null)
      {
        int j = arrayOfForegroundColorSpan.length;
        paramInt = i;
        while (paramInt < j)
        {
          ForegroundColorSpan localForegroundColorSpan = arrayOfForegroundColorSpan[paramInt];
          paramContext.setSpan(localForegroundColorSpan, paramSpannable.getSpanStart(localForegroundColorSpan), paramSpannable.getSpanEnd(localForegroundColorSpan), paramSpannable.getSpanFlags(localForegroundColorSpan));
          paramInt += 1;
        }
      }
      AppMethodBeat.o(33998);
      return paramContext;
    }
    
    private static boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
    {
      AppMethodBeat.i(187105);
      if ((!bu.isNullOrNil(paramString)) && (paramd != null))
      {
        Object localObject = (pv)paramd.data;
        if (localObject == null)
        {
          AppMethodBeat.o(187105);
          return false;
        }
        paramd = ((pv)localObject).contact.adG();
        String str = ((pv)localObject).contact.VL();
        localObject = ((pv)localObject).contact.VM();
        paramString = paramString.toUpperCase();
        if (((!bu.isNullOrNil(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!bu.isNullOrNil(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!bu.isNullOrNil((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString))))
        {
          AppMethodBeat.o(187105);
          return true;
        }
      }
      AppMethodBeat.o(187105);
      return false;
    }
    
    private void fDU()
    {
      AppMethodBeat.i(33997);
      if (fDW())
      {
        this.JQu = false;
        this.JQA = true;
        fEa();
      }
      AppMethodBeat.o(33997);
    }
    
    private boolean fDV()
    {
      return this.scene == 1;
    }
    
    private boolean fDX()
    {
      return this.scene == 3;
    }
    
    private void fDY()
    {
      int k = 1;
      AppMethodBeat.i(34001);
      int i = this.JQg.size();
      int n = this.JQh.size();
      int m = this.JQi.size();
      boolean bool;
      label82:
      label105:
      int j;
      if (this.scene != 2)
      {
        if (this.JQg.size() > this.JQb)
        {
          bool = true;
          this.JQt = bool;
        }
      }
      else
      {
        if (this.JQh.size() <= this.JQb) {
          break label275;
        }
        bool = true;
        this.JQw = bool;
        if (this.JQi.size() <= this.JQb) {
          break label281;
        }
        bool = true;
        this.JQx = bool;
        if ((i <= 0) && (!this.JQu)) {
          break label310;
        }
        j = Math.min(i, this.JQb) + 1;
        if (!fDV()) {
          break label307;
        }
        if ((!this.JQu) && (!this.JQt)) {
          break label287;
        }
        i = 1;
        label156:
        j = i + j;
      }
      for (;;)
      {
        this.JQy = j;
        i = j;
        if (n > 0)
        {
          j = Math.min(n, this.JQb) + (j + 1);
          if (!fDV()) {
            break label302;
          }
          if (!this.JQw) {
            break label292;
          }
          i = 1;
          label202:
          i += j;
        }
        for (;;)
        {
          this.JQz = i;
          j = i;
          if (m > 0)
          {
            m = i + 1 + Math.min(m, this.JQb);
            j = m;
            if (fDV()) {
              if (!this.JQx) {
                break label297;
              }
            }
          }
          label275:
          label281:
          label287:
          label292:
          label297:
          for (i = k;; i = 0)
          {
            j = m + i;
            this.ajO = j;
            AppMethodBeat.o(34001);
            return;
            bool = false;
            break;
            bool = false;
            break label82;
            bool = false;
            break label105;
            i = 0;
            break label156;
            i = 0;
            break label202;
          }
          label302:
          i = j;
        }
        label307:
        continue;
        label310:
        j = 0;
      }
    }
    
    private void fDZ()
    {
      int k = 0;
      AppMethodBeat.i(34004);
      this.JQl.clear();
      this.JQo.clear();
      this.JQr.clear();
      int i = 0;
      while (i < Math.min(this.JQb, this.JQg.size()))
      {
        this.JQl.add(new BizChatSearchUI.g(BizChatSearchUI.g.JQF, this.JQg.get(i)));
        i += 1;
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= Math.min(this.JQb, this.JQh.size())) {
          break;
        }
        this.JQo.add(new BizChatSearchUI.g(BizChatSearchUI.g.JQG, this.JQh.get(i)));
        i += 1;
      }
      while (j < Math.min(this.JQb, this.JQi.size()))
      {
        this.JQr.add(new BizChatSearchUI.g(BizChatSearchUI.g.JQK, this.JQi.get(j)));
        j += 1;
      }
      AppMethodBeat.o(34004);
    }
    
    private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList()
    {
      AppMethodBeat.i(187106);
      ArrayList localArrayList = new ArrayList();
      ag.aGp();
      Cursor localCursor = com.tencent.mm.al.f.M(this.JPU, true);
      while (localCursor.moveToNext())
      {
        pv localpv = new pv();
        Object localObject;
        if (localCursor != null)
        {
          localObject = new an();
          ((an)localObject).convertFrom(localCursor);
          com.tencent.mm.api.c localc = new com.tencent.mm.api.c();
          localc.convertFrom(localCursor);
          localpv.userName = ((aw)localObject).field_username;
          localpv.contact = ((an)localObject);
          localpv.xfE = localc;
        }
        if (localpv.contact != null)
        {
          localObject = new com.tencent.mm.ui.base.sortview.d();
          ((com.tencent.mm.ui.base.sortview.d)localObject).data = localpv;
          if (localpv.xfE.Kx()) {
            ((com.tencent.mm.ui.base.sortview.d)localObject).JOY = "!1";
          }
          for (;;)
          {
            localArrayList.add(localObject);
            break;
            if (localpv.contact.adB())
            {
              ((com.tencent.mm.ui.base.sortview.d)localObject).JOY = "!2";
            }
            else
            {
              int j = localpv.contact.acP();
              int i = j;
              if (j >= 97)
              {
                i = j;
                if (j <= 122) {
                  i = j - 32;
                }
              }
              if ((i >= 65) && (i <= 90)) {
                ((com.tencent.mm.ui.base.sortview.d)localObject).JOY = ((char)i);
              } else {
                ((com.tencent.mm.ui.base.sortview.d)localObject).JOY = "#";
              }
            }
          }
        }
      }
      localCursor.close();
      Collections.sort(localArrayList, new a((byte)0));
      AppMethodBeat.o(187106);
      return localArrayList;
    }
    
    final void aXm(String paramString)
    {
      AppMethodBeat.i(187104);
      this.JQi.clear();
      if ((!bu.isNullOrNil(paramString)) && (this.JQj != null))
      {
        Iterator localIterator = this.JQj.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.ui.base.sortview.d locald = (com.tencent.mm.ui.base.sortview.d)localIterator.next();
          if (a(paramString, locald)) {
            this.JQi.add(locald);
          }
        }
      }
      xR(true);
      AppMethodBeat.o(187104);
    }
    
    final void aXn(final String paramString)
    {
      AppMethodBeat.i(34000);
      if (!this.JQc)
      {
        AppMethodBeat.o(34000);
        return;
      }
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33991);
          if (!paramString.equals(BizChatSearchUI.a.d(BizChatSearchUI.a.this)))
          {
            AppMethodBeat.o(33991);
            return;
          }
          m localm = new m(BizChatSearchUI.a.f(BizChatSearchUI.a.this), paramString, 0);
          bc.ajj().a(localm, 0);
          AppMethodBeat.o(33991);
        }
      }, 200L);
      AppMethodBeat.o(34000);
    }
    
    public final BizChatSearchUI.g adi(int paramInt)
    {
      AppMethodBeat.i(33994);
      if (paramInt < this.JQy)
      {
        if (paramInt == 0)
        {
          if (this.JQk == null) {
            this.JQk = new BizChatSearchUI.g(BizChatSearchUI.g.JQJ, Integer.valueOf(BizChatSearchUI.g.JQM));
          }
          localg = this.JQk;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.JQy - 1) && (this.JQu) && (fDV()))
        {
          if (this.JQm == null) {
            this.JQm = new BizChatSearchUI.g();
          }
          this.JQm.oOD = BizChatSearchUI.g.JQI;
          this.JQm.data = Integer.valueOf(BizChatSearchUI.g.JQM);
          localg = this.JQm;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.JQy - 1) && (this.JQt) && (fDV()))
        {
          if (this.JQm == null) {
            this.JQm = new BizChatSearchUI.g();
          }
          this.JQm.oOD = BizChatSearchUI.g.JQH;
          this.JQm.data = Integer.valueOf(BizChatSearchUI.g.JQM);
          localg = this.JQm;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt -= 1;
        if ((paramInt >= 0) && (paramInt < this.JQl.size()))
        {
          localg = (BizChatSearchUI.g)this.JQl.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      else if (paramInt < this.JQz)
      {
        if (paramInt == this.JQy)
        {
          if (this.JQn == null) {
            this.JQn = new BizChatSearchUI.g(BizChatSearchUI.g.JQJ, Integer.valueOf(BizChatSearchUI.g.JQN));
          }
          localg = this.JQn;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.ajO - 1) && (this.JQw) && (fDV()))
        {
          if (this.JQp == null) {
            this.JQp = new BizChatSearchUI.g(BizChatSearchUI.g.JQH, Integer.valueOf(BizChatSearchUI.g.JQN));
          }
          localg = this.JQp;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt = paramInt - this.JQy - 1;
        if ((paramInt >= 0) && (paramInt < this.JQo.size()))
        {
          localg = (BizChatSearchUI.g)this.JQo.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      else
      {
        if (paramInt == this.JQz)
        {
          if (this.JQq == null) {
            this.JQq = new BizChatSearchUI.g(BizChatSearchUI.g.JQJ, Integer.valueOf(BizChatSearchUI.g.JQO));
          }
          localg = this.JQq;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.ajO - 1) && (this.JQx) && (fDV()))
        {
          if (this.JQs == null) {
            this.JQs = new BizChatSearchUI.g(BizChatSearchUI.g.JQH, Integer.valueOf(BizChatSearchUI.g.JQO));
          }
          localg = this.JQs;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt = paramInt - this.JQz - 1;
        if ((paramInt >= 0) && (paramInt < this.JQr.size()))
        {
          localg = (BizChatSearchUI.g)this.JQr.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      BizChatSearchUI.g localg = new BizChatSearchUI.g();
      AppMethodBeat.o(33994);
      return localg;
    }
    
    final void cU(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(33999);
      paramString = ag.aGs().be(this.oeQ, paramString);
      clearData();
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        com.tencent.mm.al.a.c localc = (com.tencent.mm.al.a.c)paramString.next();
        bool = localc.isGroup();
        if ((bool) && (this.JQd))
        {
          this.JQh.add(localc);
        }
        else if ((!bool) && (this.JQc))
        {
          this.JQg.add(localc);
          this.JQf.add(localc);
        }
      }
      if (this.JQc) {
        if (this.JQg.size() > this.JQb) {
          break label153;
        }
      }
      label153:
      for (boolean bool = true;; bool = false)
      {
        this.JQu = bool;
        xR(paramBoolean);
        AppMethodBeat.o(33999);
        return;
      }
    }
    
    final void clearData()
    {
      AppMethodBeat.i(34002);
      this.JQB = 0;
      this.JQg.clear();
      this.JQf.clear();
      this.JQh.clear();
      AppMethodBeat.o(34002);
    }
    
    final boolean fDW()
    {
      return this.scene == 2;
    }
    
    final void fEa()
    {
      AppMethodBeat.i(34005);
      ((BizChatSearchUI)this.context).a(this);
      AppMethodBeat.o(34005);
    }
    
    public final int getCount()
    {
      return this.ajO;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(33993);
      BizChatSearchUI.g localg = adi(paramInt);
      if (localg != null)
      {
        paramInt = localg.oOD;
        AppMethodBeat.o(33993);
        return paramInt;
      }
      paramInt = BizChatSearchUI.g.JQE;
      AppMethodBeat.o(33993);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(33995);
      BizChatSearchUI.g localg = adi(paramInt);
      View localView;
      int i;
      BizChatSearchUI.f localf;
      Object localObject2;
      boolean bool1;
      String str;
      Object localObject1;
      if ((localg.oOD == BizChatSearchUI.g.JQF) || (localg.oOD == BizChatSearchUI.g.JQG) || (localg.oOD == BizChatSearchUI.g.JQK))
      {
        localView = paramView;
        if (paramView == null)
        {
          localView = LayoutInflater.from(this.context).inflate(2131494192, paramViewGroup, false);
          i = paramViewGroup.getPaddingLeft();
          int j = paramViewGroup.getPaddingRight();
          localView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(paramViewGroup.getWidth(), 1073741824), i + j, -1), View.MeasureSpec.makeMeasureSpec(-2, 1073741824));
          paramView = new BizChatSearchUI.f((byte)0);
          paramView.fQl = ((ImageView)localView.findViewById(2131297008));
          paramView.iYj = ((TextView)localView.findViewById(2131305948));
          paramView.iFO = ((TextView)localView.findViewById(2131299008));
          paramView.contentView = localView.findViewById(2131304428);
          localView.setTag(paramView);
        }
        localf = (BizChatSearchUI.f)localView.getTag();
        paramViewGroup = "";
        localObject2 = "";
        bool1 = false;
        str = "";
        if ((localg.data instanceof com.tencent.mm.al.a.c))
        {
          paramView = (com.tencent.mm.al.a.c)localg.data;
          if (paramView == null) {
            break label1414;
          }
          if (!paramView.isGroup())
          {
            localObject1 = ag.aGt().eP(paramView.field_bizChatServId);
            if (localObject1 != null)
            {
              paramViewGroup = ((com.tencent.mm.al.a.k)localObject1).field_userName;
              paramView = ((com.tencent.mm.al.a.k)localObject1).field_headImageUrl;
            }
          }
        }
      }
      for (;;)
      {
        bool1 = false;
        i = 1;
        localObject1 = str;
        for (;;)
        {
          label283:
          if (i != 0)
          {
            paramViewGroup = com.tencent.mm.plugin.fts.a.f.b(paramViewGroup, this.fUS);
            paramViewGroup = a(this.context, paramViewGroup, com.tencent.mm.plugin.fts.ui.b.c.tIW);
            label309:
            if (!bool1) {
              break label686;
            }
            localObject2 = this.context.getString(2131756687);
            localObject1 = com.tencent.mm.plugin.fts.a.f.b((CharSequence)localObject1, this.fUS);
          }
          label686:
          for (localObject1 = TextUtils.concat(new CharSequence[] { localObject2, a(this.context, (Spannable)localObject1, com.tencent.mm.plugin.fts.ui.b.c.tIW) });; localObject1 = "")
          {
            boolean bool2 = true;
            bool1 = bool2;
            if (localg.oOD == BizChatSearchUI.g.JQF)
            {
              bool1 = bool2;
              if (paramInt == this.JQy - 1)
              {
                bool1 = bool2;
                if (this.JQy != this.ajO) {
                  bool1 = false;
                }
              }
            }
            com.tencent.mm.plugin.fts.ui.n.q(localf.contentView, bool1);
            com.tencent.mm.av.q.aJb().a(paramView, localf.fQl, this.ifW);
            com.tencent.mm.plugin.fts.ui.n.a(paramViewGroup, localf.iYj);
            com.tencent.mm.plugin.fts.ui.n.a((CharSequence)localObject1, localf.iFO);
            AppMethodBeat.o(33995);
            return localView;
            paramViewGroup = paramView.field_chatName;
            paramView = paramView.field_headImageUrl;
            break;
            if ((localg.data instanceof nf))
            {
              localObject1 = (nf)localg.data;
              paramView = ((nf)localObject1).FZA;
              paramViewGroup = paramView.oIy;
              paramView = paramView.FZr;
              bool1 = "userid".equals(((nf)localObject1).FZB);
              if (!bool1) {}
              for (i = 1;; i = 0)
              {
                localObject1 = ((nf)localObject1).FZC;
                break;
              }
            }
            if (!(localg.data instanceof com.tencent.mm.ui.base.sortview.d)) {
              break label1396;
            }
            pv localpv = (pv)((com.tencent.mm.ui.base.sortview.d)localg.data).data;
            localObject1 = localObject2;
            paramView = paramViewGroup;
            if (localpv != null)
            {
              if (localpv.contact != null) {
                paramViewGroup = localpv.contact.adG();
              }
              localObject1 = localObject2;
              paramView = paramViewGroup;
              if (localpv.xfE != null)
              {
                localObject1 = localpv.xfE.field_brandIconURL;
                paramView = paramViewGroup;
              }
            }
            bool1 = false;
            i = 1;
            paramViewGroup = (ViewGroup)localObject1;
            localObject2 = paramView;
            localObject1 = str;
            paramView = paramViewGroup;
            paramViewGroup = (ViewGroup)localObject2;
            break label283;
            paramViewGroup = a(this.context, new SpannableString(paramViewGroup), com.tencent.mm.plugin.fts.ui.b.c.tIW);
            break label309;
          }
          if (localg.oOD == BizChatSearchUI.g.JQJ)
          {
            localObject1 = paramView;
            if (paramView == null)
            {
              localObject1 = LayoutInflater.from(this.context).inflate(2131493192, paramViewGroup, false);
              paramView = new BizChatSearchUI.b((byte)0);
              paramView.pbr = ((TextView)((View)localObject1).findViewById(2131305880));
              paramView.tLJ = ((View)localObject1).findViewById(2131303131);
              paramView.contentView = ((View)localObject1).findViewById(2131304428);
              ((View)localObject1).setTag(paramView);
            }
            paramViewGroup = (BizChatSearchUI.b)((View)localObject1).getTag();
            if (((Integer)localg.data).intValue() == BizChatSearchUI.g.JQM) {
              paramView = this.context.getResources().getString(2131756685);
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.fts.ui.n.a(paramView, paramViewGroup.pbr);
            if (paramInt == 0) {
              paramViewGroup.tLJ.setVisibility(8);
            }
            for (;;)
            {
              paramViewGroup.contentView.setBackgroundResource(2131232878);
              AppMethodBeat.o(33995);
              return localObject1;
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.JQN)
              {
                paramView = this.context.getResources().getString(2131756678);
                break;
              }
              if (((Integer)localg.data).intValue() != BizChatSearchUI.g.JQO) {
                break label1389;
              }
              paramView = this.context.getResources().getString(2131760268);
              break;
              paramViewGroup.tLJ.setVisibility(0);
            }
            if (localg.oOD == BizChatSearchUI.g.JQH)
            {
              localObject1 = paramView;
              if (paramView == null)
              {
                localObject1 = LayoutInflater.from(this.context).inflate(2131493193, paramViewGroup, false);
                paramView = new BizChatSearchUI.e((byte)0);
                paramView.tLr = ((TextView)((View)localObject1).findViewById(2131305880));
                paramView.mdt = ((ImageView)((View)localObject1).findViewById(2131300891));
                paramView.contentView = ((View)localObject1).findViewById(2131304428);
                ((View)localObject1).setTag(paramView);
              }
              paramViewGroup = (BizChatSearchUI.e)((View)localObject1).getTag();
              paramView = "";
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.JQM)
              {
                paramView = this.context.getResources().getString(2131756684);
                if ((((Integer)localg.data).intValue() != BizChatSearchUI.g.JQM) || (this.JQy == this.ajO)) {
                  break label1383;
                }
              }
            }
            label1377:
            label1383:
            for (bool1 = false;; bool1 = true)
            {
              com.tencent.mm.plugin.fts.ui.n.q(paramViewGroup.contentView, bool1);
              paramViewGroup.tLr.setText(paramView);
              paramViewGroup.mdt.setImageResource(2131690258);
              AppMethodBeat.o(33995);
              return localObject1;
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.JQN)
              {
                paramView = this.context.getResources().getString(2131756683);
                break;
              }
              if (((Integer)localg.data).intValue() != BizChatSearchUI.g.JQO) {
                break;
              }
              paramView = this.context.getResources().getString(2131760275);
              break;
              if (localg.oOD == BizChatSearchUI.g.JQI)
              {
                localObject1 = paramView;
                if (paramView == null)
                {
                  localObject1 = LayoutInflater.from(this.context).inflate(2131494207, paramViewGroup, false);
                  paramView = new BizChatSearchUI.d((byte)0);
                  paramView.tLr = ((TextView)((View)localObject1).findViewById(2131305880));
                  paramView.contentView = ((View)localObject1).findViewById(2131304428);
                  ((View)localObject1).setTag(paramView);
                }
                paramView = (BizChatSearchUI.d)((View)localObject1).getTag();
                if ((((Integer)localg.data).intValue() != BizChatSearchUI.g.JQM) || (this.JQy == this.ajO)) {
                  break label1377;
                }
              }
              for (bool1 = false;; bool1 = true)
              {
                com.tencent.mm.plugin.fts.ui.n.q(paramView.contentView, bool1);
                paramView.tLr.setText(this.context.getResources().getString(2131756680));
                AppMethodBeat.o(33995);
                return localObject1;
                AppMethodBeat.o(33995);
                return null;
              }
            }
            label1389:
            paramView = "";
          }
          label1396:
          i = 0;
          paramView = "";
          paramViewGroup = "";
          localObject1 = str;
        }
        label1414:
        paramView = "";
      }
    }
    
    public final int getViewTypeCount()
    {
      return BizChatSearchUI.g.JQL;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
    {
      AppMethodBeat.i(33996);
      Object localObject1;
      Object localObject2;
      if ((this.JQc) && (paramn.getType() == 1364) && ((paramn instanceof m)))
      {
        this.JQv = false;
        localObject1 = (m)paramn;
        if ((((m)localObject1).rr != null) && (((m)localObject1).rr.hQD.hQJ != null)) {}
        for (paramString = (ng)((m)localObject1).rr.hQD.hQJ;; paramString = null)
        {
          paramn = paramString.dmf;
          localObject2 = paramString.FZx;
          if ((paramn.equals(this.fUS)) && (((String)localObject2).equals(this.oeQ)) && (this.JQB == paramString.offset)) {
            break;
          }
          AppMethodBeat.o(33996);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          fDU();
          AppMethodBeat.o(33996);
          return;
        }
        if ((((m)localObject1).rr != null) && (((m)localObject1).rr.hQE.hQJ != null)) {}
        for (paramString = (nh)((m)localObject1).rr.hQE.hQJ; (paramString == null) || (paramString.FZD == null) || (paramString.FZD.ret != 0); paramString = null)
        {
          fDU();
          AppMethodBeat.o(33996);
          return;
        }
        localObject1 = paramString.FZE;
        boolean bool = paramString.FZF;
        if (paramn.equals(this.fUS))
        {
          this.JQu = false;
          this.JQB += ((List)localObject1).size();
          if (fDV())
          {
            if (this.JQg.size() < this.JQf.size())
            {
              cU(paramn, true);
              AppMethodBeat.o(33996);
              return;
            }
            if (this.JQg.size() > this.JQf.size()) {}
          }
          else
          {
            if (fDW()) {
              this.JQt = bool;
            }
            if (fDX()) {
              break label470;
            }
            paramString = ((List)localObject1).iterator();
          }
        }
      }
      label470:
      label480:
      for (;;)
      {
        if (paramString.hasNext())
        {
          paramn = (nf)paramString.next();
          localObject1 = paramn.FZA;
          if (!bu.isNullOrNil(((ni)localObject1).FZy))
          {
            localObject2 = this.JQf.iterator();
            com.tencent.mm.al.a.c localc;
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localc = (com.tencent.mm.al.a.c)((Iterator)localObject2).next();
            } while (!((ni)localObject1).FZy.equals(localc.field_bizChatServId));
          }
        }
        else
        {
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              break label480;
            }
            this.JQg.add(paramn);
            break;
            xR(true);
            AppMethodBeat.o(33996);
            return;
          }
        }
      }
    }
    
    final void xR(boolean paramBoolean)
    {
      AppMethodBeat.i(34003);
      fDZ();
      fDY();
      if (paramBoolean)
      {
        notifyDataSetChanged();
        fEa();
      }
      AppMethodBeat.o(34003);
    }
    
    final class a
      implements Comparator<com.tencent.mm.ui.base.sortview.d>
    {
      private a() {}
    }
  }
  
  static final class b
  {
    public View contentView;
    public TextView pbr;
    public View tLJ;
  }
  
  static final class c
  {
    View odF;
    View odG;
    View odH;
    
    private void H(boolean paramBoolean1, boolean paramBoolean2)
    {
      int j = 0;
      AppMethodBeat.i(34011);
      View localView = this.odF;
      if (paramBoolean1)
      {
        i = 0;
        localView.setVisibility(i);
        this.odG.setVisibility(8);
        localView = this.odH;
        if (!paramBoolean2) {
          break label66;
        }
      }
      label66:
      for (int i = j;; i = 8)
      {
        localView.setVisibility(i);
        AppMethodBeat.o(34011);
        return;
        i = 8;
        break;
      }
    }
    
    public final void updateStatus(int paramInt)
    {
      AppMethodBeat.i(34010);
      switch (paramInt)
      {
      default: 
        H(false, false);
        AppMethodBeat.o(34010);
        return;
      case 1: 
        H(true, false);
        AppMethodBeat.o(34010);
        return;
      }
      H(false, true);
      AppMethodBeat.o(34010);
    }
  }
  
  static final class d
  {
    public View contentView;
    public TextView tLr;
  }
  
  static final class e
  {
    public View contentView;
    public ImageView mdt;
    public TextView tLr;
  }
  
  static final class f
  {
    public View contentView;
    public ImageView fQl;
    public TextView iFO;
    public TextView iYj;
  }
  
  static final class g
  {
    public static int JQE = 0;
    public static int JQF = 1;
    public static int JQG = 2;
    public static int JQH = 3;
    public static int JQI = 4;
    public static int JQJ = 5;
    public static int JQK = 6;
    public static int JQL = 7;
    public static int JQM = 1;
    public static int JQN = 2;
    public static int JQO = 3;
    public Object data;
    public int oOD;
    
    public g()
    {
      this.oOD = JQE;
      this.data = null;
    }
    
    public g(int paramInt, Object paramObject)
    {
      this.oOD = paramInt;
      this.data = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchUI
 * JD-Core Version:    0.7.0.1
 */