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
import com.tencent.mm.al.b.b;
import com.tencent.mm.am.a.j;
import com.tencent.mm.am.a.l;
import com.tencent.mm.am.a.m;
import com.tencent.mm.am.ag;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.nd;
import com.tencent.mm.protocal.protobuf.ne;
import com.tencent.mm.protocal.protobuf.nf;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.protocal.protobuf.pt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
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
  String Jve;
  private String Jvf;
  private c Jvg;
  private BizChatSearchListView Jvh;
  private a Jvi;
  private TextView fQg;
  com.tencent.mm.modelvoiceaddr.ui.b nYf;
  String nZh;
  private int scene;
  private AbsListView.OnScrollListener ulN;
  
  public BizChatSearchUI()
  {
    AppMethodBeat.i(34012);
    this.ulN = new AbsListView.OnScrollListener()
    {
      boolean nXU = false;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
        {
          this.nXU = true;
          return;
        }
        this.nXU = false;
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33989);
        if ((paramAnonymousInt == 0) && (this.nXU) && (BizChatSearchUI.a(BizChatSearchUI.this).JvD))
        {
          paramAnonymousAbsListView = BizChatSearchUI.a(BizChatSearchUI.this);
          if ((paramAnonymousAbsListView.fzU()) && (!paramAnonymousAbsListView.JvF))
          {
            paramAnonymousAbsListView.JvF = true;
            m localm = new m(paramAnonymousAbsListView.nZh, paramAnonymousAbsListView.fSM, paramAnonymousAbsListView.JvL);
            ba.aiU().a(localm, 0);
            paramAnonymousAbsListView.fzY();
          }
        }
        AppMethodBeat.o(33989);
      }
    };
    AppMethodBeat.o(34012);
  }
  
  private void acz(int paramInt)
  {
    AppMethodBeat.i(34025);
    if (this.Jvg != null) {
      this.Jvg.updateStatus(paramInt);
    }
    AppMethodBeat.o(34025);
  }
  
  public final boolean Jp(String paramString)
  {
    AppMethodBeat.i(34018);
    hideVKB();
    AppMethodBeat.o(34018);
    return true;
  }
  
  public final void Jq(String paramString)
  {
    a locala = null;
    AppMethodBeat.i(34017);
    if ((bt.isNullOrNil(paramString)) && (this.Jvf != null))
    {
      paramString = this.Jvf;
      this.Jvf = null;
      if (!paramString.equals("")) {
        this.nYf.setSearchContent(paramString);
      }
      com.tencent.mm.modelvoiceaddr.ui.b localb = this.nYf;
      if (a.c(this.Jvi)) {
        paramString = getContext().getResources().getString(2131756682);
      }
      for (;;)
      {
        localb.setHint(paramString);
        this.nYf.clearFocus();
        AppMethodBeat.o(34017);
        return;
        if (a.b(this.Jvi))
        {
          paramString = getContext().getResources().getString(2131756686);
        }
        else
        {
          paramString = locala;
          if (a.e(this.Jvi)) {
            paramString = getContext().getResources().getString(2131756679);
          }
        }
      }
    }
    locala = this.Jvi;
    locala.fSM = paramString;
    if (bt.isNullOrNil(paramString))
    {
      locala.clearData();
      locala.JvE = false;
      locala.JvK = false;
      locala.xK(true);
      AppMethodBeat.o(34017);
      return;
    }
    if (locala.scene == 4) {}
    for (int i = 1; i != 0; i = 0)
    {
      locala.clearData();
      locala.JvE = false;
      locala.JvK = false;
      locala.aVL(paramString);
      AppMethodBeat.o(34017);
      return;
    }
    if (locala.fzU())
    {
      locala.JvE = true;
      locala.JvK = false;
      locala.fzY();
      locala.cQ(paramString, false);
      locala.aVM(paramString);
      AppMethodBeat.o(34017);
      return;
    }
    locala.cQ(paramString, true);
    if ((locala.Jvm) && (locala.JvE)) {
      locala.aVM(paramString);
    }
    if (locala.Jvo) {
      locala.aVL(paramString);
    }
    AppMethodBeat.o(34017);
  }
  
  final void a(com.tencent.mm.api.c paramc, int paramInt)
  {
    AppMethodBeat.i(193811);
    com.tencent.mm.am.d locald = ag.aGi().Dy(this.Jve);
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
      long l3 = paramc.Ks();
      com.tencent.mm.plugin.report.service.g.yhR.f(14507, new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(paramInt) });
      ad.d("MicroMsg.BizChatSearchUI", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(paramInt) });
      AppMethodBeat.o(193811);
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
      if (bt.isNullOrNil(a.d(parama)))
      {
        this.fQg.setVisibility(8);
        this.Jvh.setVisibility(8);
        AppMethodBeat.o(34015);
        return;
      }
      if (parama.getCount() <= 0)
      {
        this.fQg.setVisibility(0);
        this.Jvh.setVisibility(8);
        AppMethodBeat.o(34015);
        return;
      }
      this.fQg.setVisibility(8);
      this.Jvh.setVisibility(0);
      AppMethodBeat.o(34015);
      return;
    }
    if (bt.isNullOrNil(a.d(parama)))
    {
      this.fQg.setVisibility(0);
      this.fQg.setText("");
      this.Jvh.setVisibility(8);
    }
    while (a.b(parama)) {
      if (parama.JvF)
      {
        acz(1);
        AppMethodBeat.o(34015);
        return;
        if ((a.b(parama)) && (parama.JvE))
        {
          this.fQg.setVisibility(0);
          this.fQg.setText(2131756680);
          this.Jvh.setVisibility(8);
        }
        else if ((a.b(parama)) && (parama.JvK))
        {
          this.fQg.setVisibility(0);
          this.fQg.setText(2131756681);
          this.Jvh.setVisibility(8);
        }
        else if (parama.getCount() <= 0)
        {
          this.fQg.setVisibility(0);
          this.fQg.setText(com.tencent.mm.plugin.fts.a.f.a(getString(2131762920), getString(2131762919), com.tencent.mm.plugin.fts.a.a.e.c(a.d(parama), a.d(parama))).tuE);
          this.Jvh.setVisibility(8);
        }
        else
        {
          this.fQg.setVisibility(8);
          this.Jvh.setVisibility(0);
        }
      }
      else
      {
        if (parama.JvD)
        {
          acz(2);
          AppMethodBeat.o(34015);
          return;
        }
        acz(0);
      }
    }
    AppMethodBeat.o(34015);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final void aOh()
  {
    AppMethodBeat.i(34019);
    hideVKB();
    AppMethodBeat.o(34019);
  }
  
  public final void aSm()
  {
    AppMethodBeat.i(34016);
    finish();
    AppMethodBeat.o(34016);
  }
  
  public final void aSn() {}
  
  public final void aSo() {}
  
  public final void aSp() {}
  
  public final boolean bNV()
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
    if (bt.isNullOrNil(this.nZh))
    {
      this.nZh = getIntent().getStringExtra("enterprise_biz_name");
      this.Jve = getIntent().getStringExtra("enterprise_biz_father_name");
      this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
      this.Jvf = getIntent().getStringExtra("biz_chat_search_text");
      if (bt.isNullOrNil(this.nZh)) {
        finish();
      }
    }
    this.Jvh = ((BizChatSearchListView)findViewById(2131297412));
    this.fQg = ((TextView)findViewById(2131302884));
    this.Jvi = new a(getContext(), this.nZh, this.Jve, this.scene);
    if (a.b(this.Jvi))
    {
      this.Jvg = new c((byte)0);
      BizChatSearchListView localBizChatSearchListView = this.Jvh;
      c localc = this.Jvg;
      View localView = View.inflate(getContext(), 2131494592, null);
      localc.nXW = localView.findViewById(2131301508);
      localc.nXX = localView.findViewById(2131301499);
      localc.nXY = localView.findViewById(2131301510);
      localc.nXW.setVisibility(8);
      localc.nXX.setVisibility(8);
      localc.nXY.setVisibility(8);
      localBizChatSearchListView.addFooterView(localView);
      acz(0);
    }
    this.Jvh.setAdapter(this.Jvi);
    this.Jvh.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33990);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatSearchUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        paramAnonymousAdapterView = BizChatSearchUI.a(BizChatSearchUI.this).acA(paramAnonymousInt);
        localObject1 = BizChatSearchUI.this;
        if ((paramAnonymousAdapterView.oIb == BizChatSearchUI.g.JvP) || (paramAnonymousAdapterView.oIb == BizChatSearchUI.g.JvQ))
        {
          paramAnonymousLong = -1L;
          if ((paramAnonymousAdapterView.data instanceof com.tencent.mm.am.a.c))
          {
            paramAnonymousAdapterView = (com.tencent.mm.am.a.c)paramAnonymousAdapterView.data;
            if (paramAnonymousAdapterView != null) {
              paramAnonymousLong = paramAnonymousAdapterView.field_bizChatLocalId;
            }
            if ((!bt.isNullOrNil(((BizChatSearchUI)localObject1).nZh)) && (paramAnonymousLong >= 0L)) {
              break label431;
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatSearchUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(33990);
          return;
          if (!(paramAnonymousAdapterView.data instanceof nd)) {
            break;
          }
          paramAnonymousView = ((nd)paramAnonymousAdapterView.data).FHe;
          Object localObject2 = ((BizChatSearchUI)localObject1).nZh;
          boolean bool1 = true;
          paramAnonymousAdapterView = new com.tencent.mm.am.a.k();
          paramAnonymousAdapterView.field_userId = paramAnonymousView.FHc;
          paramAnonymousAdapterView.field_userName = paramAnonymousView.oBW;
          paramAnonymousAdapterView.field_brandUserName = ((String)localObject2);
          paramAnonymousAdapterView.field_headImageUrl = paramAnonymousView.FGV;
          paramAnonymousAdapterView.field_profileUrl = paramAnonymousView.FHk;
          paramAnonymousAdapterView.field_UserVersion = paramAnonymousView.ver;
          paramAnonymousAdapterView.field_addMemberUrl = paramAnonymousView.FGZ;
          if (!ag.aGd().b(paramAnonymousAdapterView)) {
            bool1 = ag.aGd().a(paramAnonymousAdapterView);
          }
          if (!bool1)
          {
            paramAnonymousLong = -1L;
            break;
          }
          paramAnonymousView = new com.tencent.mm.am.a.c();
          paramAnonymousView.field_bizChatServId = paramAnonymousAdapterView.field_userId;
          paramAnonymousView.field_brandUserName = paramAnonymousAdapterView.field_brandUserName;
          paramAnonymousView.field_chatName = paramAnonymousAdapterView.field_userName;
          paramAnonymousView.field_chatType = j.hSi.hSl;
          paramAnonymousAdapterView = com.tencent.mm.am.a.e.e(paramAnonymousView);
          if (paramAnonymousAdapterView == null)
          {
            paramAnonymousLong = -1L;
            break;
          }
          paramAnonymousView = ag.aGc().rS(paramAnonymousAdapterView.field_bizChatLocalId);
          paramAnonymousView.field_bizChatId = paramAnonymousAdapterView.field_bizChatLocalId;
          paramAnonymousView.field_unReadCount = 0;
          if (bt.isNullOrNil(paramAnonymousView.field_brandUserName))
          {
            paramAnonymousView.field_brandUserName = paramAnonymousAdapterView.field_brandUserName;
            paramAnonymousView.field_lastMsgTime = System.currentTimeMillis();
            paramAnonymousView.field_flag = paramAnonymousView.field_lastMsgTime;
          }
          if (!ag.aGc().b(paramAnonymousView)) {
            ag.aGc().a(paramAnonymousView);
          }
          paramAnonymousLong = paramAnonymousAdapterView.field_bizChatLocalId;
          break;
          label431:
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("Chat_User", ((BizChatSearchUI)localObject1).nZh);
          paramAnonymousAdapterView.putExtra("key_biz_chat_id", paramAnonymousLong);
          paramAnonymousAdapterView.putExtra("finish_direct", true);
          paramAnonymousAdapterView.putExtra("key_need_send_video", false);
          paramAnonymousAdapterView.putExtra("key_is_biz_chat", true);
          com.tencent.mm.bs.d.f(((BizChatSearchUI)localObject1).getContext(), ".ui.chatting.ChattingUI", paramAnonymousAdapterView);
          continue;
          if (paramAnonymousAdapterView.oIb == BizChatSearchUI.g.JvU) {}
          try
          {
            localObject2 = (pt)((com.tencent.mm.ui.base.sortview.d)paramAnonymousAdapterView.data).data;
            if (localObject2 == null) {
              continue;
            }
            bool1 = com.tencent.mm.am.g.DR(((pt)localObject2).userName);
            boolean bool2 = com.tencent.mm.am.g.vd(((pt)localObject2).userName);
            com.tencent.mm.api.c localc = com.tencent.mm.am.g.eS(((pt)localObject2).userName);
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
                paramAnonymousAdapterView.putExtra("srcUsername", ((pt)localObject2).userName);
                paramAnonymousAdapterView.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                paramAnonymousAdapterView.addFlags(67108864);
                com.tencent.mm.bs.d.b(((BizChatSearchUI)localObject1).getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousAdapterView);
                ((BizChatSearchUI)localObject1).a(localc, 2);
                break;
                paramAnonymousAdapterView = localc.Kr();
                break label1255;
              }
              if (bool2)
              {
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("Contact_User", ((pt)localObject2).userName);
                paramAnonymousAdapterView.addFlags(67108864);
                paramAnonymousAdapterView.putExtra("biz_chat_from_scene", 3);
                com.tencent.mm.bs.d.f(((BizChatSearchUI)localObject1).getContext(), ".ui.bizchat.BizChatConversationUI", paramAnonymousAdapterView);
                break;
              }
              paramAnonymousAdapterView = new Intent();
              paramAnonymousAdapterView.addFlags(67108864);
              paramAnonymousAdapterView.putExtra("finish_direct", true);
              paramAnonymousAdapterView.putExtra("Chat_User", ((pt)localObject2).userName);
              paramAnonymousAdapterView.putExtra("chat_from_scene", 2);
              com.tencent.mm.plugin.brandservice.b.d(paramAnonymousAdapterView, ((BizChatSearchUI)localObject1).getContext());
              ((BizChatSearchUI)localObject1).a(localc, 1);
              break;
              if (paramAnonymousAdapterView.oIb != BizChatSearchUI.g.JvR) {
                break;
              }
              if (((Integer)paramAnonymousAdapterView.data).intValue() == BizChatSearchUI.g.JvW)
              {
                paramAnonymousAdapterView = new Intent(((BizChatSearchUI)localObject1).getContext(), BizChatSearchUI.class);
                paramAnonymousAdapterView.putExtra("enterprise_biz_name", ((BizChatSearchUI)localObject1).nZh);
                paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 2);
                paramAnonymousAdapterView.putExtra("biz_chat_search_text", ((BizChatSearchUI)localObject1).nYf.getSearchContent());
                paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousAdapterView.ahp(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((BizChatSearchUI)localObject1).startActivity((Intent)paramAnonymousAdapterView.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
              }
              if (((Integer)paramAnonymousAdapterView.data).intValue() == BizChatSearchUI.g.JvX)
              {
                paramAnonymousAdapterView = new Intent(((BizChatSearchUI)localObject1).getContext(), BizChatSearchUI.class);
                paramAnonymousAdapterView.putExtra("enterprise_biz_name", ((BizChatSearchUI)localObject1).nZh);
                paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 3);
                paramAnonymousAdapterView.putExtra("biz_chat_search_text", ((BizChatSearchUI)localObject1).nYf.getSearchContent());
                paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousAdapterView.ahp(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreGroupUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((BizChatSearchUI)localObject1).startActivity((Intent)paramAnonymousAdapterView.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreGroupUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
              }
              if (((Integer)paramAnonymousAdapterView.data).intValue() != BizChatSearchUI.g.JvY) {
                break;
              }
              paramAnonymousAdapterView = new Intent(((BizChatSearchUI)localObject1).getContext(), BizChatSearchUI.class);
              paramAnonymousAdapterView.putExtra("enterprise_biz_name", ((BizChatSearchUI)localObject1).nZh);
              paramAnonymousAdapterView.putExtra("enterprise_biz_father_name", ((BizChatSearchUI)localObject1).Jve);
              paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 4);
              paramAnonymousAdapterView.putExtra("biz_chat_search_text", ((BizChatSearchUI)localObject1).nYf.getSearchContent());
              paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousAdapterView.ahp(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreAppUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((BizChatSearchUI)localObject1).startActivity((Intent)paramAnonymousAdapterView.mq(0));
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
    this.Jvh.setOnTouchListener(this);
    if (a.b(this.Jvi)) {
      this.Jvh.setOnScrollListener(this.ulN);
    }
    this.nYf = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.nYf.yC(a.c(this.Jvi));
    this.nYf.a(this);
    this.nYf.izx = false;
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
    this.nYf.a(this, paramMenu);
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
    this.nYf.cancel();
    this.nYf.clearFocus();
    AppMethodBeat.o(34020);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(34023);
    this.nYf.a(this, paramMenu);
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
    implements com.tencent.mm.al.f
  {
    public static int Jvk = 3;
    private BizChatSearchUI.g JvA;
    private ArrayList<BizChatSearchUI.g> JvB;
    private BizChatSearchUI.g JvC;
    public boolean JvD;
    public boolean JvE;
    public boolean JvF;
    private boolean JvG;
    private boolean JvH;
    private int JvI;
    private int JvJ;
    public boolean JvK;
    int JvL;
    private String Jve;
    private int Jvl;
    boolean Jvm;
    boolean Jvn;
    boolean Jvo;
    private ArrayList<com.tencent.mm.am.a.c> Jvp;
    private ArrayList<Object> Jvq;
    private ArrayList<com.tencent.mm.am.a.c> Jvr;
    private ArrayList<com.tencent.mm.ui.base.sortview.d> Jvs;
    private List<com.tencent.mm.ui.base.sortview.d> Jvt;
    private BizChatSearchUI.g Jvu;
    private ArrayList<BizChatSearchUI.g> Jvv;
    private BizChatSearchUI.g Jvw;
    private BizChatSearchUI.g Jvx;
    private ArrayList<BizChatSearchUI.g> Jvy;
    private BizChatSearchUI.g Jvz;
    private int ajO;
    private Context context;
    String fSM;
    private com.tencent.mm.aw.a.a.c idd;
    String nZh;
    int scene;
    
    public a(Context paramContext, String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(193807);
      this.Jvp = new ArrayList();
      this.Jvq = new ArrayList();
      this.Jvr = new ArrayList();
      this.Jvs = new ArrayList();
      this.Jvv = new ArrayList();
      this.Jvy = new ArrayList();
      this.JvB = new ArrayList();
      this.JvD = true;
      this.JvE = false;
      this.JvF = false;
      this.JvG = true;
      this.JvH = true;
      this.JvI = 0;
      this.JvJ = 0;
      this.ajO = 0;
      this.JvK = false;
      this.JvL = 0;
      this.context = paramContext;
      this.nZh = paramString1;
      this.Jve = paramString2;
      this.scene = paramInt;
      boolean bool1;
      if ((this.scene == 1) || (this.scene == 2))
      {
        bool1 = true;
        this.Jvm = bool1;
        if ((this.scene != 1) && (this.scene != 3)) {
          break label359;
        }
        bool1 = true;
        label204:
        this.Jvn = bool1;
        bool1 = bool2;
        if (!bt.isNullOrNil(this.Jve)) {
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
        this.Jvo = bool1;
        if (this.scene != 1) {
          break label365;
        }
      }
      label359:
      label365:
      for (paramInt = Jvk;; paramInt = 2147483647)
      {
        this.Jvl = paramInt;
        paramContext = new c.a();
        paramContext.prefixPath = com.tencent.mm.am.a.e.es(this.nZh);
        paramContext.idr = true;
        paramContext.hdX = true;
        paramContext.idD = 2131690013;
        this.idd = paramContext.aJc();
        if (this.Jvo) {
          this.Jvt = getSortEntityList();
        }
        if (this.Jvm) {
          ba.aiU().a(1364, this);
        }
        AppMethodBeat.o(193807);
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
      AppMethodBeat.i(193809);
      if ((!bt.isNullOrNil(paramString)) && (paramd != null))
      {
        Object localObject = (pt)paramd.data;
        if (localObject == null)
        {
          AppMethodBeat.o(193809);
          return false;
        }
        paramd = ((pt)localObject).contact.adv();
        String str = ((pt)localObject).contact.VD();
        localObject = ((pt)localObject).contact.VE();
        paramString = paramString.toUpperCase();
        if (((!bt.isNullOrNil(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!bt.isNullOrNil(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString))))
        {
          AppMethodBeat.o(193809);
          return true;
        }
      }
      AppMethodBeat.o(193809);
      return false;
    }
    
    private void fzS()
    {
      AppMethodBeat.i(33997);
      if (fzU())
      {
        this.JvE = false;
        this.JvK = true;
        fzY();
      }
      AppMethodBeat.o(33997);
    }
    
    private boolean fzT()
    {
      return this.scene == 1;
    }
    
    private boolean fzV()
    {
      return this.scene == 3;
    }
    
    private void fzW()
    {
      int k = 1;
      AppMethodBeat.i(34001);
      int i = this.Jvq.size();
      int n = this.Jvr.size();
      int m = this.Jvs.size();
      boolean bool;
      label82:
      label105:
      int j;
      if (this.scene != 2)
      {
        if (this.Jvq.size() > this.Jvl)
        {
          bool = true;
          this.JvD = bool;
        }
      }
      else
      {
        if (this.Jvr.size() <= this.Jvl) {
          break label275;
        }
        bool = true;
        this.JvG = bool;
        if (this.Jvs.size() <= this.Jvl) {
          break label281;
        }
        bool = true;
        this.JvH = bool;
        if ((i <= 0) && (!this.JvE)) {
          break label310;
        }
        j = Math.min(i, this.Jvl) + 1;
        if (!fzT()) {
          break label307;
        }
        if ((!this.JvE) && (!this.JvD)) {
          break label287;
        }
        i = 1;
        label156:
        j = i + j;
      }
      for (;;)
      {
        this.JvI = j;
        i = j;
        if (n > 0)
        {
          j = Math.min(n, this.Jvl) + (j + 1);
          if (!fzT()) {
            break label302;
          }
          if (!this.JvG) {
            break label292;
          }
          i = 1;
          label202:
          i += j;
        }
        for (;;)
        {
          this.JvJ = i;
          j = i;
          if (m > 0)
          {
            m = i + 1 + Math.min(m, this.Jvl);
            j = m;
            if (fzT()) {
              if (!this.JvH) {
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
    
    private void fzX()
    {
      int k = 0;
      AppMethodBeat.i(34004);
      this.Jvv.clear();
      this.Jvy.clear();
      this.JvB.clear();
      int i = 0;
      while (i < Math.min(this.Jvl, this.Jvq.size()))
      {
        this.Jvv.add(new BizChatSearchUI.g(BizChatSearchUI.g.JvP, this.Jvq.get(i)));
        i += 1;
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= Math.min(this.Jvl, this.Jvr.size())) {
          break;
        }
        this.Jvy.add(new BizChatSearchUI.g(BizChatSearchUI.g.JvQ, this.Jvr.get(i)));
        i += 1;
      }
      while (j < Math.min(this.Jvl, this.Jvs.size()))
      {
        this.JvB.add(new BizChatSearchUI.g(BizChatSearchUI.g.JvU, this.Jvs.get(j)));
        j += 1;
      }
      AppMethodBeat.o(34004);
    }
    
    private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList()
    {
      AppMethodBeat.i(193810);
      ArrayList localArrayList = new ArrayList();
      ag.aFZ();
      Cursor localCursor = com.tencent.mm.am.f.M(this.Jve, true);
      while (localCursor.moveToNext())
      {
        pt localpt = new pt();
        Object localObject;
        if (localCursor != null)
        {
          localObject = new am();
          ((am)localObject).convertFrom(localCursor);
          com.tencent.mm.api.c localc = new com.tencent.mm.api.c();
          localc.convertFrom(localCursor);
          localpt.userName = ((aw)localObject).field_username;
          localpt.contact = ((am)localObject);
          localpt.wPN = localc;
        }
        if (localpt.contact != null)
        {
          localObject = new com.tencent.mm.ui.base.sortview.d();
          ((com.tencent.mm.ui.base.sortview.d)localObject).data = localpt;
          if (localpt.wPN.Kp()) {
            ((com.tencent.mm.ui.base.sortview.d)localObject).Juj = "!1";
          }
          for (;;)
          {
            localArrayList.add(localObject);
            break;
            if (localpt.contact.adq())
            {
              ((com.tencent.mm.ui.base.sortview.d)localObject).Juj = "!2";
            }
            else
            {
              int j = localpt.contact.acE();
              int i = j;
              if (j >= 97)
              {
                i = j;
                if (j <= 122) {
                  i = j - 32;
                }
              }
              if ((i >= 65) && (i <= 90)) {
                ((com.tencent.mm.ui.base.sortview.d)localObject).Juj = ((char)i);
              } else {
                ((com.tencent.mm.ui.base.sortview.d)localObject).Juj = "#";
              }
            }
          }
        }
      }
      localCursor.close();
      Collections.sort(localArrayList, new a((byte)0));
      AppMethodBeat.o(193810);
      return localArrayList;
    }
    
    final void aVL(String paramString)
    {
      AppMethodBeat.i(193808);
      this.Jvs.clear();
      if ((!bt.isNullOrNil(paramString)) && (this.Jvt != null))
      {
        Iterator localIterator = this.Jvt.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.ui.base.sortview.d locald = (com.tencent.mm.ui.base.sortview.d)localIterator.next();
          if (a(paramString, locald)) {
            this.Jvs.add(locald);
          }
        }
      }
      xK(true);
      AppMethodBeat.o(193808);
    }
    
    final void aVM(final String paramString)
    {
      AppMethodBeat.i(34000);
      if (!this.Jvm)
      {
        AppMethodBeat.o(34000);
        return;
      }
      aq.o(new Runnable()
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
          ba.aiU().a(localm, 0);
          AppMethodBeat.o(33991);
        }
      }, 200L);
      AppMethodBeat.o(34000);
    }
    
    public final BizChatSearchUI.g acA(int paramInt)
    {
      AppMethodBeat.i(33994);
      if (paramInt < this.JvI)
      {
        if (paramInt == 0)
        {
          if (this.Jvu == null) {
            this.Jvu = new BizChatSearchUI.g(BizChatSearchUI.g.JvT, Integer.valueOf(BizChatSearchUI.g.JvW));
          }
          localg = this.Jvu;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.JvI - 1) && (this.JvE) && (fzT()))
        {
          if (this.Jvw == null) {
            this.Jvw = new BizChatSearchUI.g();
          }
          this.Jvw.oIb = BizChatSearchUI.g.JvS;
          this.Jvw.data = Integer.valueOf(BizChatSearchUI.g.JvW);
          localg = this.Jvw;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.JvI - 1) && (this.JvD) && (fzT()))
        {
          if (this.Jvw == null) {
            this.Jvw = new BizChatSearchUI.g();
          }
          this.Jvw.oIb = BizChatSearchUI.g.JvR;
          this.Jvw.data = Integer.valueOf(BizChatSearchUI.g.JvW);
          localg = this.Jvw;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt -= 1;
        if ((paramInt >= 0) && (paramInt < this.Jvv.size()))
        {
          localg = (BizChatSearchUI.g)this.Jvv.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      else if (paramInt < this.JvJ)
      {
        if (paramInt == this.JvI)
        {
          if (this.Jvx == null) {
            this.Jvx = new BizChatSearchUI.g(BizChatSearchUI.g.JvT, Integer.valueOf(BizChatSearchUI.g.JvX));
          }
          localg = this.Jvx;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.ajO - 1) && (this.JvG) && (fzT()))
        {
          if (this.Jvz == null) {
            this.Jvz = new BizChatSearchUI.g(BizChatSearchUI.g.JvR, Integer.valueOf(BizChatSearchUI.g.JvX));
          }
          localg = this.Jvz;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt = paramInt - this.JvI - 1;
        if ((paramInt >= 0) && (paramInt < this.Jvy.size()))
        {
          localg = (BizChatSearchUI.g)this.Jvy.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      else
      {
        if (paramInt == this.JvJ)
        {
          if (this.JvA == null) {
            this.JvA = new BizChatSearchUI.g(BizChatSearchUI.g.JvT, Integer.valueOf(BizChatSearchUI.g.JvY));
          }
          localg = this.JvA;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.ajO - 1) && (this.JvH) && (fzT()))
        {
          if (this.JvC == null) {
            this.JvC = new BizChatSearchUI.g(BizChatSearchUI.g.JvR, Integer.valueOf(BizChatSearchUI.g.JvY));
          }
          localg = this.JvC;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt = paramInt - this.JvJ - 1;
        if ((paramInt >= 0) && (paramInt < this.JvB.size()))
        {
          localg = (BizChatSearchUI.g)this.JvB.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      BizChatSearchUI.g localg = new BizChatSearchUI.g();
      AppMethodBeat.o(33994);
      return localg;
    }
    
    final void cQ(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(33999);
      paramString = ag.aGc().be(this.nZh, paramString);
      clearData();
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        com.tencent.mm.am.a.c localc = (com.tencent.mm.am.a.c)paramString.next();
        bool = localc.isGroup();
        if ((bool) && (this.Jvn))
        {
          this.Jvr.add(localc);
        }
        else if ((!bool) && (this.Jvm))
        {
          this.Jvq.add(localc);
          this.Jvp.add(localc);
        }
      }
      if (this.Jvm) {
        if (this.Jvq.size() > this.Jvl) {
          break label153;
        }
      }
      label153:
      for (boolean bool = true;; bool = false)
      {
        this.JvE = bool;
        xK(paramBoolean);
        AppMethodBeat.o(33999);
        return;
      }
    }
    
    final void clearData()
    {
      AppMethodBeat.i(34002);
      this.JvL = 0;
      this.Jvq.clear();
      this.Jvp.clear();
      this.Jvr.clear();
      AppMethodBeat.o(34002);
    }
    
    final boolean fzU()
    {
      return this.scene == 2;
    }
    
    final void fzY()
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
      BizChatSearchUI.g localg = acA(paramInt);
      if (localg != null)
      {
        paramInt = localg.oIb;
        AppMethodBeat.o(33993);
        return paramInt;
      }
      paramInt = BizChatSearchUI.g.JvO;
      AppMethodBeat.o(33993);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(33995);
      BizChatSearchUI.g localg = acA(paramInt);
      View localView;
      int i;
      BizChatSearchUI.f localf;
      Object localObject2;
      boolean bool1;
      String str;
      Object localObject1;
      if ((localg.oIb == BizChatSearchUI.g.JvP) || (localg.oIb == BizChatSearchUI.g.JvQ) || (localg.oIb == BizChatSearchUI.g.JvU))
      {
        localView = paramView;
        if (paramView == null)
        {
          localView = LayoutInflater.from(this.context).inflate(2131494192, paramViewGroup, false);
          i = paramViewGroup.getPaddingLeft();
          int j = paramViewGroup.getPaddingRight();
          localView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(paramViewGroup.getWidth(), 1073741824), i + j, -1), View.MeasureSpec.makeMeasureSpec(-2, 1073741824));
          paramView = new BizChatSearchUI.f((byte)0);
          paramView.fOf = ((ImageView)localView.findViewById(2131297008));
          paramView.iVq = ((TextView)localView.findViewById(2131305948));
          paramView.iCV = ((TextView)localView.findViewById(2131299008));
          paramView.contentView = localView.findViewById(2131304428);
          localView.setTag(paramView);
        }
        localf = (BizChatSearchUI.f)localView.getTag();
        paramViewGroup = "";
        localObject2 = "";
        bool1 = false;
        str = "";
        if ((localg.data instanceof com.tencent.mm.am.a.c))
        {
          paramView = (com.tencent.mm.am.a.c)localg.data;
          if (paramView == null) {
            break label1414;
          }
          if (!paramView.isGroup())
          {
            localObject1 = ag.aGd().eK(paramView.field_bizChatServId);
            if (localObject1 != null)
            {
              paramViewGroup = ((com.tencent.mm.am.a.k)localObject1).field_userName;
              paramView = ((com.tencent.mm.am.a.k)localObject1).field_headImageUrl;
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
            paramViewGroup = com.tencent.mm.plugin.fts.a.f.b(paramViewGroup, this.fSM);
            paramViewGroup = a(this.context, paramViewGroup, com.tencent.mm.plugin.fts.ui.b.c.tyf);
            label309:
            if (!bool1) {
              break label686;
            }
            localObject2 = this.context.getString(2131756687);
            localObject1 = com.tencent.mm.plugin.fts.a.f.b((CharSequence)localObject1, this.fSM);
          }
          label686:
          for (localObject1 = TextUtils.concat(new CharSequence[] { localObject2, a(this.context, (Spannable)localObject1, com.tencent.mm.plugin.fts.ui.b.c.tyf) });; localObject1 = "")
          {
            boolean bool2 = true;
            bool1 = bool2;
            if (localg.oIb == BizChatSearchUI.g.JvP)
            {
              bool1 = bool2;
              if (paramInt == this.JvI - 1)
              {
                bool1 = bool2;
                if (this.JvI != this.ajO) {
                  bool1 = false;
                }
              }
            }
            com.tencent.mm.plugin.fts.ui.n.q(localf.contentView, bool1);
            com.tencent.mm.aw.q.aIJ().a(paramView, localf.fOf, this.idd);
            com.tencent.mm.plugin.fts.ui.n.a(paramViewGroup, localf.iVq);
            com.tencent.mm.plugin.fts.ui.n.a((CharSequence)localObject1, localf.iCV);
            AppMethodBeat.o(33995);
            return localView;
            paramViewGroup = paramView.field_chatName;
            paramView = paramView.field_headImageUrl;
            break;
            if ((localg.data instanceof nd))
            {
              localObject1 = (nd)localg.data;
              paramView = ((nd)localObject1).FHe;
              paramViewGroup = paramView.oBW;
              paramView = paramView.FGV;
              bool1 = "userid".equals(((nd)localObject1).FHf);
              if (!bool1) {}
              for (i = 1;; i = 0)
              {
                localObject1 = ((nd)localObject1).FHg;
                break;
              }
            }
            if (!(localg.data instanceof com.tencent.mm.ui.base.sortview.d)) {
              break label1396;
            }
            pt localpt = (pt)((com.tencent.mm.ui.base.sortview.d)localg.data).data;
            localObject1 = localObject2;
            paramView = paramViewGroup;
            if (localpt != null)
            {
              if (localpt.contact != null) {
                paramViewGroup = localpt.contact.adv();
              }
              localObject1 = localObject2;
              paramView = paramViewGroup;
              if (localpt.wPN != null)
              {
                localObject1 = localpt.wPN.field_brandIconURL;
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
            paramViewGroup = a(this.context, new SpannableString(paramViewGroup), com.tencent.mm.plugin.fts.ui.b.c.tyf);
            break label309;
          }
          if (localg.oIb == BizChatSearchUI.g.JvT)
          {
            localObject1 = paramView;
            if (paramView == null)
            {
              localObject1 = LayoutInflater.from(this.context).inflate(2131493192, paramViewGroup, false);
              paramView = new BizChatSearchUI.b((byte)0);
              paramView.oUO = ((TextView)((View)localObject1).findViewById(2131305880));
              paramView.tAS = ((View)localObject1).findViewById(2131303131);
              paramView.contentView = ((View)localObject1).findViewById(2131304428);
              ((View)localObject1).setTag(paramView);
            }
            paramViewGroup = (BizChatSearchUI.b)((View)localObject1).getTag();
            if (((Integer)localg.data).intValue() == BizChatSearchUI.g.JvW) {
              paramView = this.context.getResources().getString(2131756685);
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.fts.ui.n.a(paramView, paramViewGroup.oUO);
            if (paramInt == 0) {
              paramViewGroup.tAS.setVisibility(8);
            }
            for (;;)
            {
              paramViewGroup.contentView.setBackgroundResource(2131232878);
              AppMethodBeat.o(33995);
              return localObject1;
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.JvX)
              {
                paramView = this.context.getResources().getString(2131756678);
                break;
              }
              if (((Integer)localg.data).intValue() != BizChatSearchUI.g.JvY) {
                break label1389;
              }
              paramView = this.context.getResources().getString(2131760268);
              break;
              paramViewGroup.tAS.setVisibility(0);
            }
            if (localg.oIb == BizChatSearchUI.g.JvR)
            {
              localObject1 = paramView;
              if (paramView == null)
              {
                localObject1 = LayoutInflater.from(this.context).inflate(2131493193, paramViewGroup, false);
                paramView = new BizChatSearchUI.e((byte)0);
                paramView.tAA = ((TextView)((View)localObject1).findViewById(2131305880));
                paramView.lZa = ((ImageView)((View)localObject1).findViewById(2131300891));
                paramView.contentView = ((View)localObject1).findViewById(2131304428);
                ((View)localObject1).setTag(paramView);
              }
              paramViewGroup = (BizChatSearchUI.e)((View)localObject1).getTag();
              paramView = "";
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.JvW)
              {
                paramView = this.context.getResources().getString(2131756684);
                if ((((Integer)localg.data).intValue() != BizChatSearchUI.g.JvW) || (this.JvI == this.ajO)) {
                  break label1383;
                }
              }
            }
            label1377:
            label1383:
            for (bool1 = false;; bool1 = true)
            {
              com.tencent.mm.plugin.fts.ui.n.q(paramViewGroup.contentView, bool1);
              paramViewGroup.tAA.setText(paramView);
              paramViewGroup.lZa.setImageResource(2131690258);
              AppMethodBeat.o(33995);
              return localObject1;
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.JvX)
              {
                paramView = this.context.getResources().getString(2131756683);
                break;
              }
              if (((Integer)localg.data).intValue() != BizChatSearchUI.g.JvY) {
                break;
              }
              paramView = this.context.getResources().getString(2131760275);
              break;
              if (localg.oIb == BizChatSearchUI.g.JvS)
              {
                localObject1 = paramView;
                if (paramView == null)
                {
                  localObject1 = LayoutInflater.from(this.context).inflate(2131494207, paramViewGroup, false);
                  paramView = new BizChatSearchUI.d((byte)0);
                  paramView.tAA = ((TextView)((View)localObject1).findViewById(2131305880));
                  paramView.contentView = ((View)localObject1).findViewById(2131304428);
                  ((View)localObject1).setTag(paramView);
                }
                paramView = (BizChatSearchUI.d)((View)localObject1).getTag();
                if ((((Integer)localg.data).intValue() != BizChatSearchUI.g.JvW) || (this.JvI == this.ajO)) {
                  break label1377;
                }
              }
              for (bool1 = false;; bool1 = true)
              {
                com.tencent.mm.plugin.fts.ui.n.q(paramView.contentView, bool1);
                paramView.tAA.setText(this.context.getResources().getString(2131756680));
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
      return BizChatSearchUI.g.JvV;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
    {
      AppMethodBeat.i(33996);
      Object localObject1;
      Object localObject2;
      if ((this.Jvm) && (paramn.getType() == 1364) && ((paramn instanceof m)))
      {
        this.JvF = false;
        localObject1 = (m)paramn;
        if ((((m)localObject1).rr != null) && (((m)localObject1).rr.hNK.hNQ != null)) {}
        for (paramString = (ne)((m)localObject1).rr.hNK.hNQ;; paramString = null)
        {
          paramn = paramString.dld;
          localObject2 = paramString.FHb;
          if ((paramn.equals(this.fSM)) && (((String)localObject2).equals(this.nZh)) && (this.JvL == paramString.offset)) {
            break;
          }
          AppMethodBeat.o(33996);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          fzS();
          AppMethodBeat.o(33996);
          return;
        }
        if ((((m)localObject1).rr != null) && (((m)localObject1).rr.hNL.hNQ != null)) {}
        for (paramString = (nf)((m)localObject1).rr.hNL.hNQ; (paramString == null) || (paramString.FHh == null) || (paramString.FHh.ret != 0); paramString = null)
        {
          fzS();
          AppMethodBeat.o(33996);
          return;
        }
        localObject1 = paramString.FHi;
        boolean bool = paramString.FHj;
        if (paramn.equals(this.fSM))
        {
          this.JvE = false;
          this.JvL += ((List)localObject1).size();
          if (fzT())
          {
            if (this.Jvq.size() < this.Jvp.size())
            {
              cQ(paramn, true);
              AppMethodBeat.o(33996);
              return;
            }
            if (this.Jvq.size() > this.Jvp.size()) {}
          }
          else
          {
            if (fzU()) {
              this.JvD = bool;
            }
            if (fzV()) {
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
          paramn = (nd)paramString.next();
          localObject1 = paramn.FHe;
          if (!bt.isNullOrNil(((ng)localObject1).FHc))
          {
            localObject2 = this.Jvp.iterator();
            com.tencent.mm.am.a.c localc;
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localc = (com.tencent.mm.am.a.c)((Iterator)localObject2).next();
            } while (!((ng)localObject1).FHc.equals(localc.field_bizChatServId));
          }
        }
        else
        {
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              break label480;
            }
            this.Jvq.add(paramn);
            break;
            xK(true);
            AppMethodBeat.o(33996);
            return;
          }
        }
      }
    }
    
    final void xK(boolean paramBoolean)
    {
      AppMethodBeat.i(34003);
      fzX();
      fzW();
      if (paramBoolean)
      {
        notifyDataSetChanged();
        fzY();
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
    public TextView oUO;
    public View tAS;
  }
  
  static final class c
  {
    View nXW;
    View nXX;
    View nXY;
    
    private void H(boolean paramBoolean1, boolean paramBoolean2)
    {
      int j = 0;
      AppMethodBeat.i(34011);
      View localView = this.nXW;
      if (paramBoolean1)
      {
        i = 0;
        localView.setVisibility(i);
        this.nXX.setVisibility(8);
        localView = this.nXY;
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
    public TextView tAA;
  }
  
  static final class e
  {
    public View contentView;
    public ImageView lZa;
    public TextView tAA;
  }
  
  static final class f
  {
    public View contentView;
    public ImageView fOf;
    public TextView iCV;
    public TextView iVq;
  }
  
  static final class g
  {
    public static int JvO = 0;
    public static int JvP = 1;
    public static int JvQ = 2;
    public static int JvR = 3;
    public static int JvS = 4;
    public static int JvT = 5;
    public static int JvU = 6;
    public static int JvV = 7;
    public static int JvW = 1;
    public static int JvX = 2;
    public static int JvY = 3;
    public Object data;
    public int oIb;
    
    public g()
    {
      this.oIb = JvO;
      this.data = null;
    }
    
    public g(int paramInt, Object paramObject)
    {
      this.oIb = paramInt;
      this.data = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchUI
 * JD-Core Version:    0.7.0.1
 */