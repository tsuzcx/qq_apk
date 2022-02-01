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
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.a.j;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.a.m;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.g;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dis;
import com.tencent.mm.protocal.protobuf.nx;
import com.tencent.mm.protocal.protobuf.ny;
import com.tencent.mm.protocal.protobuf.nz;
import com.tencent.mm.protocal.protobuf.oa;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
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
  String PaZ;
  private String Pba;
  private c Pbb;
  private BizChatSearchListView Pbc;
  private a Pbd;
  com.tencent.mm.modelvoiceaddr.ui.b poM;
  String ppO;
  private int scene;
  private TextView tipView;
  private AbsListView.OnScrollListener xPk;
  
  public BizChatSearchUI()
  {
    AppMethodBeat.i(34012);
    this.xPk = new AbsListView.OnScrollListener()
    {
      boolean poB = false;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
        {
          this.poB = true;
          return;
        }
        this.poB = false;
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33989);
        if ((paramAnonymousInt == 0) && (this.poB) && (BizChatSearchUI.a(BizChatSearchUI.this).Pby))
        {
          paramAnonymousAbsListView = BizChatSearchUI.a(BizChatSearchUI.this);
          if ((paramAnonymousAbsListView.gMd()) && (!paramAnonymousAbsListView.PbA))
          {
            paramAnonymousAbsListView.PbA = true;
            m localm = new m(paramAnonymousAbsListView.ppO, paramAnonymousAbsListView.gzZ, paramAnonymousAbsListView.PbG);
            bg.azz().a(localm, 0);
            paramAnonymousAbsListView.gMh();
          }
        }
        AppMethodBeat.o(33989);
      }
    };
    AppMethodBeat.o(34012);
  }
  
  private void alR(int paramInt)
  {
    AppMethodBeat.i(34025);
    if (this.Pbb != null) {
      this.Pbb.updateStatus(paramInt);
    }
    AppMethodBeat.o(34025);
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(34018);
    hideVKB();
    AppMethodBeat.o(34018);
    return true;
  }
  
  public final void SO(String paramString)
  {
    a locala = null;
    AppMethodBeat.i(34017);
    if ((Util.isNullOrNil(paramString)) && (this.Pba != null))
    {
      paramString = this.Pba;
      this.Pba = null;
      if (!paramString.equals("")) {
        this.poM.setSearchContent(paramString);
      }
      com.tencent.mm.modelvoiceaddr.ui.b localb = this.poM;
      if (a.c(this.Pbd)) {
        paramString = getContext().getResources().getString(2131756839);
      }
      for (;;)
      {
        localb.setHint(paramString);
        this.poM.clearFocus();
        AppMethodBeat.o(34017);
        return;
        if (a.b(this.Pbd))
        {
          paramString = getContext().getResources().getString(2131756844);
        }
        else
        {
          paramString = locala;
          if (a.e(this.Pbd)) {
            paramString = getContext().getResources().getString(2131756836);
          }
        }
      }
    }
    locala = this.Pbd;
    locala.gzZ = paramString;
    if (Util.isNullOrNil(paramString))
    {
      locala.clearData();
      locala.Pbz = false;
      locala.PbF = false;
      locala.BG(true);
      AppMethodBeat.o(34017);
      return;
    }
    if (locala.scene == 4) {}
    for (int i = 1; i != 0; i = 0)
    {
      locala.clearData();
      locala.Pbz = false;
      locala.PbF = false;
      locala.bmq(paramString);
      AppMethodBeat.o(34017);
      return;
    }
    if (locala.gMd())
    {
      locala.Pbz = true;
      locala.PbF = false;
      locala.gMh();
      locala.dp(paramString, false);
      locala.bmr(paramString);
      AppMethodBeat.o(34017);
      return;
    }
    locala.dp(paramString, true);
    if ((locala.Pbh) && (locala.Pbz)) {
      locala.bmr(paramString);
    }
    if (locala.Pbj) {
      locala.bmq(paramString);
    }
    AppMethodBeat.o(34017);
  }
  
  final void a(com.tencent.mm.api.c paramc, int paramInt)
  {
    AppMethodBeat.i(232792);
    com.tencent.mm.al.d locald = ag.bar().MO(this.PaZ);
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
      long l3 = paramc.UK();
      h.CyF.a(14507, new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(paramInt) });
      Log.d("MicroMsg.BizChatSearchUI", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(paramInt) });
      AppMethodBeat.o(232792);
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
      if (Util.isNullOrNil(a.d(parama)))
      {
        this.tipView.setVisibility(8);
        this.Pbc.setVisibility(8);
        AppMethodBeat.o(34015);
        return;
      }
      if (parama.getCount() <= 0)
      {
        this.tipView.setVisibility(0);
        this.Pbc.setVisibility(8);
        AppMethodBeat.o(34015);
        return;
      }
      this.tipView.setVisibility(8);
      this.Pbc.setVisibility(0);
      AppMethodBeat.o(34015);
      return;
    }
    if (Util.isNullOrNil(a.d(parama)))
    {
      this.tipView.setVisibility(0);
      this.tipView.setText("");
      this.Pbc.setVisibility(8);
    }
    while (a.b(parama)) {
      if (parama.PbA)
      {
        alR(1);
        AppMethodBeat.o(34015);
        return;
        if ((a.b(parama)) && (parama.Pbz))
        {
          this.tipView.setVisibility(0);
          this.tipView.setText(2131756837);
          this.Pbc.setVisibility(8);
        }
        else if ((a.b(parama)) && (parama.PbF))
        {
          this.tipView.setVisibility(0);
          this.tipView.setText(2131756838);
          this.Pbc.setVisibility(8);
        }
        else if (parama.getCount() <= 0)
        {
          this.tipView.setVisibility(0);
          this.tipView.setText(com.tencent.mm.plugin.fts.a.f.a(getString(2131765056), getString(2131765055), com.tencent.mm.plugin.fts.a.a.e.c(a.d(parama), a.d(parama))).wWu);
          this.Pbc.setVisibility(8);
        }
        else
        {
          this.tipView.setVisibility(8);
          this.Pbc.setVisibility(0);
        }
      }
      else
      {
        if (parama.Pby)
        {
          alR(2);
          AppMethodBeat.o(34015);
          return;
        }
        alR(0);
      }
    }
    AppMethodBeat.o(34015);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final void biM()
  {
    AppMethodBeat.i(34019);
    hideVKB();
    AppMethodBeat.o(34019);
  }
  
  public final void bnA() {}
  
  public final void bnB() {}
  
  public final void bny()
  {
    AppMethodBeat.i(34016);
    finish();
    AppMethodBeat.o(34016);
  }
  
  public final void bnz() {}
  
  public final boolean clY()
  {
    AppMethodBeat.i(34024);
    hideVKB();
    AppMethodBeat.o(34024);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131494002;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34014);
    if (Util.isNullOrNil(this.ppO))
    {
      this.ppO = getIntent().getStringExtra("enterprise_biz_name");
      this.PaZ = getIntent().getStringExtra("enterprise_biz_father_name");
      this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
      this.Pba = getIntent().getStringExtra("biz_chat_search_text");
      if (Util.isNullOrNil(this.ppO)) {
        finish();
      }
    }
    this.Pbc = ((BizChatSearchListView)findViewById(2131297630));
    this.tipView = ((TextView)findViewById(2131305461));
    this.Pbd = new a(getContext(), this.ppO, this.PaZ, this.scene);
    if (a.b(this.Pbd))
    {
      this.Pbb = new c((byte)0);
      BizChatSearchListView localBizChatSearchListView = this.Pbc;
      c localc = this.Pbb;
      View localView = View.inflate(getContext(), 2131495303, null);
      localc.poD = localView.findViewById(2131303711);
      localc.poE = localView.findViewById(2131303700);
      localc.poF = localView.findViewById(2131303714);
      localc.poD.setVisibility(8);
      localc.poE.setVisibility(8);
      localc.poF.setVisibility(8);
      localBizChatSearchListView.addFooterView(localView);
      alR(0);
    }
    this.Pbc.setAdapter(this.Pbd);
    this.Pbc.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33990);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatSearchUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        paramAnonymousAdapterView = BizChatSearchUI.a(BizChatSearchUI.this).alS(paramAnonymousInt);
        localObject1 = BizChatSearchUI.this;
        if ((paramAnonymousAdapterView.qcr == BizChatSearchUI.g.PbK) || (paramAnonymousAdapterView.qcr == BizChatSearchUI.g.PbL))
        {
          paramAnonymousLong = -1L;
          if ((paramAnonymousAdapterView.data instanceof com.tencent.mm.al.a.c))
          {
            paramAnonymousAdapterView = (com.tencent.mm.al.a.c)paramAnonymousAdapterView.data;
            if (paramAnonymousAdapterView != null) {
              paramAnonymousLong = paramAnonymousAdapterView.field_bizChatLocalId;
            }
            if ((!Util.isNullOrNil(((BizChatSearchUI)localObject1).ppO)) && (paramAnonymousLong >= 0L)) {
              break label431;
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatSearchUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(33990);
          return;
          if (!(paramAnonymousAdapterView.data instanceof nx)) {
            break;
          }
          paramAnonymousView = ((nx)paramAnonymousAdapterView.data).KTw;
          Object localObject2 = ((BizChatSearchUI)localObject1).ppO;
          boolean bool1 = true;
          paramAnonymousAdapterView = new k();
          paramAnonymousAdapterView.field_userId = paramAnonymousView.KTu;
          paramAnonymousAdapterView.field_userName = paramAnonymousView.pWm;
          paramAnonymousAdapterView.field_brandUserName = ((String)localObject2);
          paramAnonymousAdapterView.field_headImageUrl = paramAnonymousView.KTm;
          paramAnonymousAdapterView.field_profileUrl = paramAnonymousView.gTH;
          paramAnonymousAdapterView.field_UserVersion = paramAnonymousView.ver;
          paramAnonymousAdapterView.field_addMemberUrl = paramAnonymousView.KTr;
          if (!ag.bal().b(paramAnonymousAdapterView)) {
            bool1 = ag.bal().a(paramAnonymousAdapterView);
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
          paramAnonymousView.field_chatType = j.iQn.iQq;
          paramAnonymousAdapterView = com.tencent.mm.al.a.e.e(paramAnonymousView);
          if (paramAnonymousAdapterView == null)
          {
            paramAnonymousLong = -1L;
            break;
          }
          paramAnonymousView = ag.bak().Al(paramAnonymousAdapterView.field_bizChatLocalId);
          paramAnonymousView.field_bizChatId = paramAnonymousAdapterView.field_bizChatLocalId;
          paramAnonymousView.field_unReadCount = 0;
          if (Util.isNullOrNil(paramAnonymousView.field_brandUserName))
          {
            paramAnonymousView.field_brandUserName = paramAnonymousAdapterView.field_brandUserName;
            paramAnonymousView.field_lastMsgTime = System.currentTimeMillis();
            paramAnonymousView.field_flag = paramAnonymousView.field_lastMsgTime;
          }
          if (!ag.bak().b(paramAnonymousView)) {
            ag.bak().a(paramAnonymousView);
          }
          paramAnonymousLong = paramAnonymousAdapterView.field_bizChatLocalId;
          break;
          label431:
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("Chat_User", ((BizChatSearchUI)localObject1).ppO);
          paramAnonymousAdapterView.putExtra("key_biz_chat_id", paramAnonymousLong);
          paramAnonymousAdapterView.putExtra("finish_direct", true);
          paramAnonymousAdapterView.putExtra("key_need_send_video", false);
          paramAnonymousAdapterView.putExtra("key_is_biz_chat", true);
          com.tencent.mm.br.c.f(((BizChatSearchUI)localObject1).getContext(), ".ui.chatting.ChattingUI", paramAnonymousAdapterView);
          continue;
          if (paramAnonymousAdapterView.qcr == BizChatSearchUI.g.PbP) {}
          try
          {
            localObject2 = (qw)((com.tencent.mm.ui.base.sortview.d)paramAnonymousAdapterView.data).data;
            if (localObject2 == null) {
              continue;
            }
            bool1 = g.Nh(((qw)localObject2).userName);
            boolean bool2 = g.DQ(((qw)localObject2).userName);
            com.tencent.mm.api.c localc = g.fJ(((qw)localObject2).userName);
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
                paramAnonymousAdapterView.putExtra("srcUsername", ((qw)localObject2).userName);
                paramAnonymousAdapterView.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                paramAnonymousAdapterView.addFlags(67108864);
                com.tencent.mm.br.c.b(((BizChatSearchUI)localObject1).getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousAdapterView);
                ((BizChatSearchUI)localObject1).a(localc, 2);
                break;
                paramAnonymousAdapterView = localc.UJ();
                break label1255;
              }
              if (bool2)
              {
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("Contact_User", ((qw)localObject2).userName);
                paramAnonymousAdapterView.addFlags(67108864);
                paramAnonymousAdapterView.putExtra("biz_chat_from_scene", 3);
                com.tencent.mm.br.c.f(((BizChatSearchUI)localObject1).getContext(), ".ui.bizchat.BizChatConversationUI", paramAnonymousAdapterView);
                break;
              }
              paramAnonymousAdapterView = new Intent();
              paramAnonymousAdapterView.addFlags(67108864);
              paramAnonymousAdapterView.putExtra("finish_direct", true);
              paramAnonymousAdapterView.putExtra("Chat_User", ((qw)localObject2).userName);
              paramAnonymousAdapterView.putExtra("chat_from_scene", 2);
              com.tencent.mm.plugin.brandservice.b.d(paramAnonymousAdapterView, ((BizChatSearchUI)localObject1).getContext());
              ((BizChatSearchUI)localObject1).a(localc, 1);
              break;
              if (paramAnonymousAdapterView.qcr != BizChatSearchUI.g.PbM) {
                break;
              }
              if (((Integer)paramAnonymousAdapterView.data).intValue() == BizChatSearchUI.g.PbR)
              {
                paramAnonymousAdapterView = new Intent(((BizChatSearchUI)localObject1).getContext(), BizChatSearchUI.class);
                paramAnonymousAdapterView.putExtra("enterprise_biz_name", ((BizChatSearchUI)localObject1).ppO);
                paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 2);
                paramAnonymousAdapterView.putExtra("biz_chat_search_text", ((BizChatSearchUI)localObject1).poM.getSearchContent());
                paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousAdapterView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousAdapterView.axQ(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((BizChatSearchUI)localObject1).startActivity((Intent)paramAnonymousAdapterView.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
              }
              if (((Integer)paramAnonymousAdapterView.data).intValue() == BizChatSearchUI.g.PbS)
              {
                paramAnonymousAdapterView = new Intent(((BizChatSearchUI)localObject1).getContext(), BizChatSearchUI.class);
                paramAnonymousAdapterView.putExtra("enterprise_biz_name", ((BizChatSearchUI)localObject1).ppO);
                paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 3);
                paramAnonymousAdapterView.putExtra("biz_chat_search_text", ((BizChatSearchUI)localObject1).poM.getSearchContent());
                paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousAdapterView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousAdapterView.axQ(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreGroupUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((BizChatSearchUI)localObject1).startActivity((Intent)paramAnonymousAdapterView.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreGroupUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
              }
              if (((Integer)paramAnonymousAdapterView.data).intValue() != BizChatSearchUI.g.PbT) {
                break;
              }
              paramAnonymousAdapterView = new Intent(((BizChatSearchUI)localObject1).getContext(), BizChatSearchUI.class);
              paramAnonymousAdapterView.putExtra("enterprise_biz_name", ((BizChatSearchUI)localObject1).ppO);
              paramAnonymousAdapterView.putExtra("enterprise_biz_father_name", ((BizChatSearchUI)localObject1).PaZ);
              paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 4);
              paramAnonymousAdapterView.putExtra("biz_chat_search_text", ((BizChatSearchUI)localObject1).poM.getSearchContent());
              paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousAdapterView.axQ(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreAppUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((BizChatSearchUI)localObject1).startActivity((Intent)paramAnonymousAdapterView.pG(0));
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
    this.Pbc.setOnTouchListener(this);
    if (a.b(this.Pbd)) {
      this.Pbc.setOnScrollListener(this.xPk);
    }
    this.poM = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.poM.CK(a.c(this.Pbd));
    this.poM.a(this);
    this.poM.jxF = false;
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
    this.poM.a(this, paramMenu);
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
    this.poM.cancel();
    this.poM.clearFocus();
    AppMethodBeat.o(34020);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(34023);
    this.poM.a(this, paramMenu);
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
    implements i
  {
    public static int Pbf = 3;
    private String PaZ;
    public boolean PbA;
    private boolean PbB;
    private boolean PbC;
    private int PbD;
    private int PbE;
    public boolean PbF;
    int PbG;
    private int Pbg;
    boolean Pbh;
    boolean Pbi;
    boolean Pbj;
    private ArrayList<com.tencent.mm.al.a.c> Pbk;
    private ArrayList<Object> Pbl;
    private ArrayList<com.tencent.mm.al.a.c> Pbm;
    private ArrayList<com.tencent.mm.ui.base.sortview.d> Pbn;
    private List<com.tencent.mm.ui.base.sortview.d> Pbo;
    private BizChatSearchUI.g Pbp;
    private ArrayList<BizChatSearchUI.g> Pbq;
    private BizChatSearchUI.g Pbr;
    private BizChatSearchUI.g Pbs;
    private ArrayList<BizChatSearchUI.g> Pbt;
    private BizChatSearchUI.g Pbu;
    private BizChatSearchUI.g Pbv;
    private ArrayList<BizChatSearchUI.g> Pbw;
    private BizChatSearchUI.g Pbx;
    public boolean Pby;
    public boolean Pbz;
    private int akb;
    private Context context;
    String gzZ;
    private com.tencent.mm.av.a.a.c jaR;
    String ppO;
    int scene;
    
    public a(Context paramContext, String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(232788);
      this.Pbk = new ArrayList();
      this.Pbl = new ArrayList();
      this.Pbm = new ArrayList();
      this.Pbn = new ArrayList();
      this.Pbq = new ArrayList();
      this.Pbt = new ArrayList();
      this.Pbw = new ArrayList();
      this.Pby = true;
      this.Pbz = false;
      this.PbA = false;
      this.PbB = true;
      this.PbC = true;
      this.PbD = 0;
      this.PbE = 0;
      this.akb = 0;
      this.PbF = false;
      this.PbG = 0;
      this.context = paramContext;
      this.ppO = paramString1;
      this.PaZ = paramString2;
      this.scene = paramInt;
      boolean bool1;
      if ((this.scene == 1) || (this.scene == 2))
      {
        bool1 = true;
        this.Pbh = bool1;
        if ((this.scene != 1) && (this.scene != 3)) {
          break label359;
        }
        bool1 = true;
        label204:
        this.Pbi = bool1;
        bool1 = bool2;
        if (!Util.isNullOrNil(this.PaZ)) {
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
        this.Pbj = bool1;
        if (this.scene != 1) {
          break label365;
        }
      }
      label359:
      label365:
      for (paramInt = Pbf;; paramInt = 2147483647)
      {
        this.Pbg = paramInt;
        paramContext = new c.a();
        paramContext.prefixPath = com.tencent.mm.al.a.e.fe(this.ppO);
        paramContext.jbf = true;
        paramContext.hZF = true;
        paramContext.jbq = 2131690042;
        this.jaR = paramContext.bdv();
        if (this.Pbj) {
          this.Pbo = getSortEntityList();
        }
        if (this.Pbh) {
          bg.azz().a(1364, this);
        }
        AppMethodBeat.o(232788);
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
      paramContext = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, paramSpannable, paramInt);
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
      AppMethodBeat.i(232790);
      if ((!Util.isNullOrNil(paramString)) && (paramd != null))
      {
        Object localObject = (qw)paramd.data;
        if (localObject == null)
        {
          AppMethodBeat.o(232790);
          return false;
        }
        paramd = ((qw)localObject).contact.arJ();
        String str = ((qw)localObject).contact.ajz();
        localObject = ((qw)localObject).contact.ajA();
        paramString = paramString.toUpperCase();
        if (((!Util.isNullOrNil(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!Util.isNullOrNil(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString))))
        {
          AppMethodBeat.o(232790);
          return true;
        }
      }
      AppMethodBeat.o(232790);
      return false;
    }
    
    private void gMb()
    {
      AppMethodBeat.i(33997);
      if (gMd())
      {
        this.Pbz = false;
        this.PbF = true;
        gMh();
      }
      AppMethodBeat.o(33997);
    }
    
    private boolean gMc()
    {
      return this.scene == 1;
    }
    
    private boolean gMe()
    {
      return this.scene == 3;
    }
    
    private void gMf()
    {
      int k = 1;
      AppMethodBeat.i(34001);
      int i = this.Pbl.size();
      int n = this.Pbm.size();
      int m = this.Pbn.size();
      boolean bool;
      label82:
      label105:
      int j;
      if (this.scene != 2)
      {
        if (this.Pbl.size() > this.Pbg)
        {
          bool = true;
          this.Pby = bool;
        }
      }
      else
      {
        if (this.Pbm.size() <= this.Pbg) {
          break label275;
        }
        bool = true;
        this.PbB = bool;
        if (this.Pbn.size() <= this.Pbg) {
          break label281;
        }
        bool = true;
        this.PbC = bool;
        if ((i <= 0) && (!this.Pbz)) {
          break label310;
        }
        j = Math.min(i, this.Pbg) + 1;
        if (!gMc()) {
          break label307;
        }
        if ((!this.Pbz) && (!this.Pby)) {
          break label287;
        }
        i = 1;
        label156:
        j = i + j;
      }
      for (;;)
      {
        this.PbD = j;
        i = j;
        if (n > 0)
        {
          j = Math.min(n, this.Pbg) + (j + 1);
          if (!gMc()) {
            break label302;
          }
          if (!this.PbB) {
            break label292;
          }
          i = 1;
          label202:
          i += j;
        }
        for (;;)
        {
          this.PbE = i;
          j = i;
          if (m > 0)
          {
            m = i + 1 + Math.min(m, this.Pbg);
            j = m;
            if (gMc()) {
              if (!this.PbC) {
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
            this.akb = j;
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
    
    private void gMg()
    {
      int k = 0;
      AppMethodBeat.i(34004);
      this.Pbq.clear();
      this.Pbt.clear();
      this.Pbw.clear();
      int i = 0;
      while (i < Math.min(this.Pbg, this.Pbl.size()))
      {
        this.Pbq.add(new BizChatSearchUI.g(BizChatSearchUI.g.PbK, this.Pbl.get(i)));
        i += 1;
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= Math.min(this.Pbg, this.Pbm.size())) {
          break;
        }
        this.Pbt.add(new BizChatSearchUI.g(BizChatSearchUI.g.PbL, this.Pbm.get(i)));
        i += 1;
      }
      while (j < Math.min(this.Pbg, this.Pbn.size()))
      {
        this.Pbw.add(new BizChatSearchUI.g(BizChatSearchUI.g.PbP, this.Pbn.get(j)));
        j += 1;
      }
      AppMethodBeat.o(34004);
    }
    
    private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList()
    {
      AppMethodBeat.i(232791);
      ArrayList localArrayList = new ArrayList();
      ag.bah();
      Cursor localCursor = com.tencent.mm.al.f.O(this.PaZ, true);
      while (localCursor.moveToNext())
      {
        qw localqw = new qw();
        Object localObject;
        if (localCursor != null)
        {
          localObject = new as();
          ((as)localObject).convertFrom(localCursor);
          com.tencent.mm.api.c localc = new com.tencent.mm.api.c();
          localc.convertFrom(localCursor);
          localqw.userName = ((ax)localObject).field_username;
          localqw.contact = ((as)localObject);
          localqw.Bdk = localc;
        }
        if (localqw.contact != null)
        {
          localObject = new com.tencent.mm.ui.base.sortview.d();
          ((com.tencent.mm.ui.base.sortview.d)localObject).data = localqw;
          if (localqw.Bdk.UH()) {
            ((com.tencent.mm.ui.base.sortview.d)localObject).Pae = "!1";
          }
          for (;;)
          {
            localArrayList.add(localObject);
            break;
            if (localqw.contact.arE())
            {
              ((com.tencent.mm.ui.base.sortview.d)localObject).Pae = "!2";
            }
            else
            {
              int j = localqw.contact.aqN();
              int i = j;
              if (j >= 97)
              {
                i = j;
                if (j <= 122) {
                  i = j - 32;
                }
              }
              if ((i >= 65) && (i <= 90)) {
                ((com.tencent.mm.ui.base.sortview.d)localObject).Pae = ((char)i);
              } else {
                ((com.tencent.mm.ui.base.sortview.d)localObject).Pae = "#";
              }
            }
          }
        }
      }
      localCursor.close();
      Collections.sort(localArrayList, new a((byte)0));
      AppMethodBeat.o(232791);
      return localArrayList;
    }
    
    final void BG(boolean paramBoolean)
    {
      AppMethodBeat.i(34003);
      gMg();
      gMf();
      if (paramBoolean)
      {
        notifyDataSetChanged();
        gMh();
      }
      AppMethodBeat.o(34003);
    }
    
    public final BizChatSearchUI.g alS(int paramInt)
    {
      AppMethodBeat.i(33994);
      if (paramInt < this.PbD)
      {
        if (paramInt == 0)
        {
          if (this.Pbp == null) {
            this.Pbp = new BizChatSearchUI.g(BizChatSearchUI.g.PbO, Integer.valueOf(BizChatSearchUI.g.PbR));
          }
          localg = this.Pbp;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.PbD - 1) && (this.Pbz) && (gMc()))
        {
          if (this.Pbr == null) {
            this.Pbr = new BizChatSearchUI.g();
          }
          this.Pbr.qcr = BizChatSearchUI.g.PbN;
          this.Pbr.data = Integer.valueOf(BizChatSearchUI.g.PbR);
          localg = this.Pbr;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.PbD - 1) && (this.Pby) && (gMc()))
        {
          if (this.Pbr == null) {
            this.Pbr = new BizChatSearchUI.g();
          }
          this.Pbr.qcr = BizChatSearchUI.g.PbM;
          this.Pbr.data = Integer.valueOf(BizChatSearchUI.g.PbR);
          localg = this.Pbr;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt -= 1;
        if ((paramInt >= 0) && (paramInt < this.Pbq.size()))
        {
          localg = (BizChatSearchUI.g)this.Pbq.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      else if (paramInt < this.PbE)
      {
        if (paramInt == this.PbD)
        {
          if (this.Pbs == null) {
            this.Pbs = new BizChatSearchUI.g(BizChatSearchUI.g.PbO, Integer.valueOf(BizChatSearchUI.g.PbS));
          }
          localg = this.Pbs;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.akb - 1) && (this.PbB) && (gMc()))
        {
          if (this.Pbu == null) {
            this.Pbu = new BizChatSearchUI.g(BizChatSearchUI.g.PbM, Integer.valueOf(BizChatSearchUI.g.PbS));
          }
          localg = this.Pbu;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt = paramInt - this.PbD - 1;
        if ((paramInt >= 0) && (paramInt < this.Pbt.size()))
        {
          localg = (BizChatSearchUI.g)this.Pbt.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      else
      {
        if (paramInt == this.PbE)
        {
          if (this.Pbv == null) {
            this.Pbv = new BizChatSearchUI.g(BizChatSearchUI.g.PbO, Integer.valueOf(BizChatSearchUI.g.PbT));
          }
          localg = this.Pbv;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.akb - 1) && (this.PbC) && (gMc()))
        {
          if (this.Pbx == null) {
            this.Pbx = new BizChatSearchUI.g(BizChatSearchUI.g.PbM, Integer.valueOf(BizChatSearchUI.g.PbT));
          }
          localg = this.Pbx;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt = paramInt - this.PbE - 1;
        if ((paramInt >= 0) && (paramInt < this.Pbw.size()))
        {
          localg = (BizChatSearchUI.g)this.Pbw.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      BizChatSearchUI.g localg = new BizChatSearchUI.g();
      AppMethodBeat.o(33994);
      return localg;
    }
    
    final void bmq(String paramString)
    {
      AppMethodBeat.i(232789);
      this.Pbn.clear();
      if ((!Util.isNullOrNil(paramString)) && (this.Pbo != null))
      {
        Iterator localIterator = this.Pbo.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.ui.base.sortview.d locald = (com.tencent.mm.ui.base.sortview.d)localIterator.next();
          if (a(paramString, locald)) {
            this.Pbn.add(locald);
          }
        }
      }
      BG(true);
      AppMethodBeat.o(232789);
    }
    
    final void bmr(final String paramString)
    {
      AppMethodBeat.i(34000);
      if (!this.Pbh)
      {
        AppMethodBeat.o(34000);
        return;
      }
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
          bg.azz().a(localm, 0);
          AppMethodBeat.o(33991);
        }
      }, 200L);
      AppMethodBeat.o(34000);
    }
    
    final void clearData()
    {
      AppMethodBeat.i(34002);
      this.PbG = 0;
      this.Pbl.clear();
      this.Pbk.clear();
      this.Pbm.clear();
      AppMethodBeat.o(34002);
    }
    
    final void dp(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(33999);
      paramString = ag.bak().bi(this.ppO, paramString);
      clearData();
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        com.tencent.mm.al.a.c localc = (com.tencent.mm.al.a.c)paramString.next();
        bool = localc.isGroup();
        if ((bool) && (this.Pbi))
        {
          this.Pbm.add(localc);
        }
        else if ((!bool) && (this.Pbh))
        {
          this.Pbl.add(localc);
          this.Pbk.add(localc);
        }
      }
      if (this.Pbh) {
        if (this.Pbl.size() > this.Pbg) {
          break label153;
        }
      }
      label153:
      for (boolean bool = true;; bool = false)
      {
        this.Pbz = bool;
        BG(paramBoolean);
        AppMethodBeat.o(33999);
        return;
      }
    }
    
    final boolean gMd()
    {
      return this.scene == 2;
    }
    
    final void gMh()
    {
      AppMethodBeat.i(34005);
      ((BizChatSearchUI)this.context).a(this);
      AppMethodBeat.o(34005);
    }
    
    public final int getCount()
    {
      return this.akb;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(33993);
      BizChatSearchUI.g localg = alS(paramInt);
      if (localg != null)
      {
        paramInt = localg.qcr;
        AppMethodBeat.o(33993);
        return paramInt;
      }
      paramInt = BizChatSearchUI.g.PbJ;
      AppMethodBeat.o(33993);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(33995);
      BizChatSearchUI.g localg = alS(paramInt);
      View localView;
      int i;
      BizChatSearchUI.f localf;
      Object localObject2;
      boolean bool1;
      String str;
      Object localObject1;
      if ((localg.qcr == BizChatSearchUI.g.PbK) || (localg.qcr == BizChatSearchUI.g.PbL) || (localg.qcr == BizChatSearchUI.g.PbP))
      {
        localView = paramView;
        if (paramView == null)
        {
          localView = LayoutInflater.from(this.context).inflate(2131494744, paramViewGroup, false);
          i = paramViewGroup.getPaddingLeft();
          int j = paramViewGroup.getPaddingRight();
          localView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(paramViewGroup.getWidth(), 1073741824), i + j, -1), View.MeasureSpec.makeMeasureSpec(-2, 1073741824));
          paramView = new BizChatSearchUI.f((byte)0);
          paramView.gvv = ((ImageView)localView.findViewById(2131297134));
          paramView.jVO = ((TextView)localView.findViewById(2131309249));
          paramView.jBR = ((TextView)localView.findViewById(2131299510));
          paramView.contentView = localView.findViewById(2131307399);
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
            localObject1 = ag.bal().fB(paramView.field_bizChatServId);
            if (localObject1 != null)
            {
              paramViewGroup = ((k)localObject1).field_userName;
              paramView = ((k)localObject1).field_headImageUrl;
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
            paramViewGroup = com.tencent.mm.plugin.fts.a.f.b(paramViewGroup, this.gzZ);
            paramViewGroup = a(this.context, paramViewGroup, b.c.wZV);
            label309:
            if (!bool1) {
              break label686;
            }
            localObject2 = this.context.getString(2131756845);
            localObject1 = com.tencent.mm.plugin.fts.a.f.b((CharSequence)localObject1, this.gzZ);
          }
          label686:
          for (localObject1 = TextUtils.concat(new CharSequence[] { localObject2, a(this.context, (Spannable)localObject1, b.c.wZV) });; localObject1 = "")
          {
            boolean bool2 = true;
            bool1 = bool2;
            if (localg.qcr == BizChatSearchUI.g.PbK)
            {
              bool1 = bool2;
              if (paramInt == this.PbD - 1)
              {
                bool1 = bool2;
                if (this.PbD != this.akb) {
                  bool1 = false;
                }
              }
            }
            n.r(localf.contentView, bool1);
            com.tencent.mm.av.q.bcV().a(paramView, localf.gvv, this.jaR);
            n.a(paramViewGroup, localf.jVO);
            n.a((CharSequence)localObject1, localf.jBR);
            AppMethodBeat.o(33995);
            return localView;
            paramViewGroup = paramView.field_chatName;
            paramView = paramView.field_headImageUrl;
            break;
            if ((localg.data instanceof nx))
            {
              localObject1 = (nx)localg.data;
              paramView = ((nx)localObject1).KTw;
              paramViewGroup = paramView.pWm;
              paramView = paramView.KTm;
              bool1 = "userid".equals(((nx)localObject1).KTx);
              if (!bool1) {}
              for (i = 1;; i = 0)
              {
                localObject1 = ((nx)localObject1).KTy;
                break;
              }
            }
            if (!(localg.data instanceof com.tencent.mm.ui.base.sortview.d)) {
              break label1396;
            }
            qw localqw = (qw)((com.tencent.mm.ui.base.sortview.d)localg.data).data;
            localObject1 = localObject2;
            paramView = paramViewGroup;
            if (localqw != null)
            {
              if (localqw.contact != null) {
                paramViewGroup = localqw.contact.arJ();
              }
              localObject1 = localObject2;
              paramView = paramViewGroup;
              if (localqw.Bdk != null)
              {
                localObject1 = localqw.Bdk.field_brandIconURL;
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
            paramViewGroup = a(this.context, new SpannableString(paramViewGroup), b.c.wZV);
            break label309;
          }
          if (localg.qcr == BizChatSearchUI.g.PbO)
          {
            localObject1 = paramView;
            if (paramView == null)
            {
              localObject1 = LayoutInflater.from(this.context).inflate(2131493238, paramViewGroup, false);
              paramView = new BizChatSearchUI.b((byte)0);
              paramView.qqq = ((TextView)((View)localObject1).findViewById(2131309163));
              paramView.xcK = ((View)localObject1).findViewById(2131305768);
              paramView.contentView = ((View)localObject1).findViewById(2131307399);
              ((View)localObject1).setTag(paramView);
            }
            paramViewGroup = (BizChatSearchUI.b)((View)localObject1).getTag();
            if (((Integer)localg.data).intValue() == BizChatSearchUI.g.PbR) {
              paramView = this.context.getResources().getString(2131756843);
            }
          }
          for (;;)
          {
            n.b(paramView, paramViewGroup.qqq);
            if (paramInt == 0) {
              paramViewGroup.xcK.setVisibility(8);
            }
            for (;;)
            {
              paramViewGroup.contentView.setBackgroundResource(2131233338);
              AppMethodBeat.o(33995);
              return localObject1;
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.PbS)
              {
                paramView = this.context.getResources().getString(2131756835);
                break;
              }
              if (((Integer)localg.data).intValue() != BizChatSearchUI.g.PbT) {
                break label1389;
              }
              paramView = this.context.getResources().getString(2131756834);
              break;
              paramViewGroup.xcK.setVisibility(0);
            }
            if (localg.qcr == BizChatSearchUI.g.PbM)
            {
              localObject1 = paramView;
              if (paramView == null)
              {
                localObject1 = LayoutInflater.from(this.context).inflate(2131493239, paramViewGroup, false);
                paramView = new BizChatSearchUI.e((byte)0);
                paramView.xcs = ((TextView)((View)localObject1).findViewById(2131309163));
                paramView.nnL = ((ImageView)((View)localObject1).findViewById(2131302497));
                paramView.contentView = ((View)localObject1).findViewById(2131307399);
                ((View)localObject1).setTag(paramView);
              }
              paramViewGroup = (BizChatSearchUI.e)((View)localObject1).getTag();
              paramView = "";
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.PbR)
              {
                paramView = this.context.getResources().getString(2131756842);
                if ((((Integer)localg.data).intValue() != BizChatSearchUI.g.PbR) || (this.PbD == this.akb)) {
                  break label1383;
                }
              }
            }
            label1377:
            label1383:
            for (bool1 = false;; bool1 = true)
            {
              n.r(paramViewGroup.contentView, bool1);
              paramViewGroup.xcs.setText(paramView);
              paramViewGroup.nnL.setImageResource(2131690354);
              AppMethodBeat.o(33995);
              return localObject1;
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.PbS)
              {
                paramView = this.context.getResources().getString(2131756841);
                break;
              }
              if (((Integer)localg.data).intValue() != BizChatSearchUI.g.PbT) {
                break;
              }
              paramView = this.context.getResources().getString(2131756840);
              break;
              if (localg.qcr == BizChatSearchUI.g.PbN)
              {
                localObject1 = paramView;
                if (paramView == null)
                {
                  localObject1 = LayoutInflater.from(this.context).inflate(2131494762, paramViewGroup, false);
                  paramView = new BizChatSearchUI.d((byte)0);
                  paramView.xcs = ((TextView)((View)localObject1).findViewById(2131309163));
                  paramView.contentView = ((View)localObject1).findViewById(2131307399);
                  ((View)localObject1).setTag(paramView);
                }
                paramView = (BizChatSearchUI.d)((View)localObject1).getTag();
                if ((((Integer)localg.data).intValue() != BizChatSearchUI.g.PbR) || (this.PbD == this.akb)) {
                  break label1377;
                }
              }
              for (bool1 = false;; bool1 = true)
              {
                n.r(paramView.contentView, bool1);
                paramView.xcs.setText(this.context.getResources().getString(2131756837));
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
      return BizChatSearchUI.g.PbQ;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(33996);
      Object localObject1;
      Object localObject2;
      if ((this.Pbh) && (paramq.getType() == 1364) && ((paramq instanceof m)))
      {
        this.PbA = false;
        localObject1 = (m)paramq;
        if ((((m)localObject1).rr != null) && (((m)localObject1).rr.iLK.iLR != null)) {}
        for (paramString = (ny)((m)localObject1).rr.iLK.iLR;; paramString = null)
        {
          paramq = paramString.dDv;
          localObject2 = paramString.KTt;
          if ((paramq.equals(this.gzZ)) && (((String)localObject2).equals(this.ppO)) && (this.PbG == paramString.offset)) {
            break;
          }
          AppMethodBeat.o(33996);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          gMb();
          AppMethodBeat.o(33996);
          return;
        }
        if ((((m)localObject1).rr != null) && (((m)localObject1).rr.iLL.iLR != null)) {}
        for (paramString = (nz)((m)localObject1).rr.iLL.iLR; (paramString == null) || (paramString.KTz == null) || (paramString.KTz.ret != 0); paramString = null)
        {
          gMb();
          AppMethodBeat.o(33996);
          return;
        }
        localObject1 = paramString.KTA;
        boolean bool = paramString.KTB;
        if (paramq.equals(this.gzZ))
        {
          this.Pbz = false;
          this.PbG += ((List)localObject1).size();
          if (gMc())
          {
            if (this.Pbl.size() < this.Pbk.size())
            {
              dp(paramq, true);
              AppMethodBeat.o(33996);
              return;
            }
            if (this.Pbl.size() > this.Pbk.size()) {}
          }
          else
          {
            if (gMd()) {
              this.Pby = bool;
            }
            if (gMe()) {
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
          paramq = (nx)paramString.next();
          localObject1 = paramq.KTw;
          if (!Util.isNullOrNil(((oa)localObject1).KTu))
          {
            localObject2 = this.Pbk.iterator();
            com.tencent.mm.al.a.c localc;
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localc = (com.tencent.mm.al.a.c)((Iterator)localObject2).next();
            } while (!((oa)localObject1).KTu.equals(localc.field_bizChatServId));
          }
        }
        else
        {
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              break label480;
            }
            this.Pbl.add(paramq);
            break;
            BG(true);
            AppMethodBeat.o(33996);
            return;
          }
        }
      }
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
    public TextView qqq;
    public View xcK;
  }
  
  static final class c
  {
    View poD;
    View poE;
    View poF;
    
    private void G(boolean paramBoolean1, boolean paramBoolean2)
    {
      int j = 0;
      AppMethodBeat.i(34011);
      View localView = this.poD;
      if (paramBoolean1)
      {
        i = 0;
        localView.setVisibility(i);
        this.poE.setVisibility(8);
        localView = this.poF;
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
        G(false, false);
        AppMethodBeat.o(34010);
        return;
      case 1: 
        G(true, false);
        AppMethodBeat.o(34010);
        return;
      }
      G(false, true);
      AppMethodBeat.o(34010);
    }
  }
  
  static final class d
  {
    public View contentView;
    public TextView xcs;
  }
  
  static final class e
  {
    public View contentView;
    public ImageView nnL;
    public TextView xcs;
  }
  
  static final class f
  {
    public View contentView;
    public ImageView gvv;
    public TextView jBR;
    public TextView jVO;
  }
  
  static final class g
  {
    public static int PbJ = 0;
    public static int PbK = 1;
    public static int PbL = 2;
    public static int PbM = 3;
    public static int PbN = 4;
    public static int PbO = 5;
    public static int PbP = 6;
    public static int PbQ = 7;
    public static int PbR = 1;
    public static int PbS = 2;
    public static int PbT = 3;
    public Object data;
    public int qcr;
    
    public g()
    {
      this.qcr = PbJ;
      this.data = null;
    }
    
    public g(int paramInt, Object paramObject)
    {
      this.qcr = paramInt;
      this.data = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchUI
 * JD-Core Version:    0.7.0.1
 */