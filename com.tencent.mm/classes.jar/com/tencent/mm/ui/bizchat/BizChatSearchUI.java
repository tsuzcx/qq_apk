package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.s;
import com.tencent.mm.an.a.j;
import com.tencent.mm.an.a.k;
import com.tencent.mm.an.a.l;
import com.tencent.mm.an.a.m;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.protocal.protobuf.elf;
import com.tencent.mm.protocal.protobuf.ot;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.protocal.protobuf.sa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
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
  private AbsListView.OnScrollListener INJ;
  String aebE;
  private String aebF;
  private c aebG;
  private BizChatSearchListView aebH;
  private a aebI;
  private TextView lDI;
  private int scene;
  com.tencent.mm.modelvoiceaddr.ui.b vDu;
  String vEu;
  
  public BizChatSearchUI()
  {
    AppMethodBeat.i(34012);
    this.INJ = new AbsListView.OnScrollListener()
    {
      boolean vDh = false;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
        {
          this.vDh = true;
          return;
        }
        this.vDh = false;
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33989);
        if ((paramAnonymousInt == 0) && (this.vDh) && (BizChatSearchUI.a(BizChatSearchUI.this).aecd))
        {
          paramAnonymousAbsListView = BizChatSearchUI.a(BizChatSearchUI.this);
          if ((paramAnonymousAbsListView.jnN()) && (!paramAnonymousAbsListView.aecf))
          {
            paramAnonymousAbsListView.aecf = true;
            m localm = new m(paramAnonymousAbsListView.vEu, paramAnonymousAbsListView.lMG, paramAnonymousAbsListView.aecl);
            bh.aZW().a(localm, 0);
            paramAnonymousAbsListView.jnQ();
          }
        }
        AppMethodBeat.o(33989);
      }
    };
    AppMethodBeat.o(34012);
  }
  
  private void aBt(int paramInt)
  {
    AppMethodBeat.i(34025);
    if (this.aebG != null) {
      this.aebG.updateStatus(paramInt);
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
    if ((Util.isNullOrNil(paramString)) && (this.aebF != null))
    {
      paramString = this.aebF;
      this.aebF = null;
      if (!paramString.equals("")) {
        this.vDu.setSearchContent(paramString);
      }
      com.tencent.mm.modelvoiceaddr.ui.b localb = this.vDu;
      if (a.c(this.aebI)) {
        paramString = getContext().getResources().getString(R.l.bizchat_search_main_hint);
      }
      for (;;)
      {
        localb.setHint(paramString);
        this.vDu.clearFocus();
        AppMethodBeat.o(34017);
        return;
        if (a.b(this.aebI))
        {
          paramString = getContext().getResources().getString(R.l.bizchat_search_user_hint);
        }
        else
        {
          paramString = locala;
          if (a.e(this.aebI)) {
            paramString = getContext().getResources().getString(R.l.bizchat_search_group_hint);
          }
        }
      }
    }
    locala = this.aebI;
    locala.lMG = paramString;
    if (Util.isNullOrNil(paramString))
    {
      locala.clearData();
      locala.aece = false;
      locala.aeck = false;
      locala.LM(true);
      AppMethodBeat.o(34017);
      return;
    }
    if (locala.scene == 4) {}
    for (int i = 1; i != 0; i = 0)
    {
      locala.clearData();
      locala.aece = false;
      locala.aeck = false;
      locala.bAs(paramString);
      AppMethodBeat.o(34017);
      return;
    }
    if (locala.jnN())
    {
      locala.aece = true;
      locala.aeck = false;
      locala.jnQ();
      locala.ei(paramString, false);
      locala.bAt(paramString);
      AppMethodBeat.o(34017);
      return;
    }
    locala.ei(paramString, true);
    if ((locala.aebM) && (locala.aece)) {
      locala.bAt(paramString);
    }
    if (locala.aebO) {
      locala.bAs(paramString);
    }
    AppMethodBeat.o(34017);
  }
  
  final void a(com.tencent.mm.api.c paramc, int paramInt)
  {
    AppMethodBeat.i(250786);
    com.tencent.mm.an.d locald = af.bHq().Mi(this.aebE);
    long l1;
    if (locald != null)
    {
      l1 = locald.field_wwCorpId;
      if (locald == null) {
        break label173;
      }
    }
    label173:
    for (long l2 = locald.field_wwUserVid;; l2 = 0L)
    {
      long l3 = paramc.aAU();
      com.tencent.mm.plugin.report.service.h.OAn.b(14507, new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(paramInt) });
      Log.d("MicroMsg.BizChatSearchUI", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(paramInt) });
      AppMethodBeat.o(250786);
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
        this.lDI.setVisibility(8);
        this.aebH.setVisibility(8);
        AppMethodBeat.o(34015);
        return;
      }
      if (parama.getCount() <= 0)
      {
        this.lDI.setVisibility(0);
        this.aebH.setVisibility(8);
        AppMethodBeat.o(34015);
        return;
      }
      this.lDI.setVisibility(8);
      this.aebH.setVisibility(0);
      AppMethodBeat.o(34015);
      return;
    }
    if (Util.isNullOrNil(a.d(parama)))
    {
      this.lDI.setVisibility(0);
      this.lDI.setText("");
      this.aebH.setVisibility(8);
    }
    while (a.b(parama)) {
      if (parama.aecf)
      {
        aBt(1);
        AppMethodBeat.o(34015);
        return;
        if ((a.b(parama)) && (parama.aece))
        {
          this.lDI.setVisibility(0);
          this.lDI.setText(R.l.bizchat_search_loading);
          this.aebH.setVisibility(8);
        }
        else if ((a.b(parama)) && (parama.aeck))
        {
          this.lDI.setVisibility(0);
          this.lDI.setText(R.l.bizchat_search_loading_error);
          this.aebH.setVisibility(8);
        }
        else if (parama.getCount() <= 0)
        {
          this.lDI.setVisibility(0);
          this.lDI.setText(com.tencent.mm.plugin.fts.a.f.a(getString(R.l.search_contact_no_result_pre), getString(R.l.search_contact_no_result_post), com.tencent.mm.plugin.fts.a.a.g.c(a.d(parama), a.d(parama))).HsX);
          this.aebH.setVisibility(8);
        }
        else
        {
          this.lDI.setVisibility(8);
          this.aebH.setVisibility(0);
        }
      }
      else
      {
        if (parama.aecd)
        {
          aBt(2);
          AppMethodBeat.o(34015);
          return;
        }
        aBt(0);
      }
    }
    AppMethodBeat.o(34015);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final void bPQ()
  {
    AppMethodBeat.i(34019);
    hideVKB();
    AppMethodBeat.o(34019);
  }
  
  public final void bWw()
  {
    AppMethodBeat.i(34016);
    finish();
    AppMethodBeat.o(34016);
  }
  
  public final void bWx() {}
  
  public final void bWy() {}
  
  public final void bWz() {}
  
  public final boolean dcu()
  {
    AppMethodBeat.i(34024);
    hideVKB();
    AppMethodBeat.o(34024);
    return false;
  }
  
  public int getLayoutId()
  {
    return R.i.enterprise_bizchat_search;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34014);
    if (Util.isNullOrNil(this.vEu))
    {
      this.vEu = getIntent().getStringExtra("enterprise_biz_name");
      this.aebE = getIntent().getStringExtra("enterprise_biz_father_name");
      this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
      this.aebF = getIntent().getStringExtra("biz_chat_search_text");
      if (Util.isNullOrNil(this.vEu)) {
        finish();
      }
    }
    this.aebH = ((BizChatSearchListView)findViewById(R.h.bizchat_lv));
    this.lDI = ((TextView)findViewById(R.h.no_result_tv));
    this.aebI = new a(getContext(), this.vEu, this.aebE, this.scene);
    if (a.b(this.aebI))
    {
      this.aebG = new c((byte)0);
      BizChatSearchListView localBizChatSearchListView = this.aebH;
      c localc = this.aebG;
      View localView = View.inflate(getContext(), R.i.loading_footer, null);
      localc.vDj = localView.findViewById(R.h.loading_progress);
      localc.vDk = localView.findViewById(R.h.loading_end);
      localc.vDl = localView.findViewById(R.h.loading_tip);
      localc.vDj.setVisibility(8);
      localc.vDk.setVisibility(8);
      localc.vDl.setVisibility(8);
      localBizChatSearchListView.addFooterView(localView);
      aBt(0);
    }
    this.aebH.setAdapter(this.aebI);
    this.aebH.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33990);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/bizchat/BizChatSearchUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        paramAnonymousAdapterView = BizChatSearchUI.a(BizChatSearchUI.this).aBu(paramAnonymousInt);
        localObject1 = BizChatSearchUI.this;
        if ((paramAnonymousAdapterView.viewType == BizChatSearchUI.g.aecp) || (paramAnonymousAdapterView.viewType == BizChatSearchUI.g.aecq))
        {
          paramAnonymousLong = -1L;
          if ((paramAnonymousAdapterView.cpt instanceof com.tencent.mm.an.a.c))
          {
            paramAnonymousAdapterView = (com.tencent.mm.an.a.c)paramAnonymousAdapterView.cpt;
            if (paramAnonymousAdapterView != null) {
              paramAnonymousLong = paramAnonymousAdapterView.field_bizChatLocalId;
            }
            if ((!Util.isNullOrNil(((BizChatSearchUI)localObject1).vEu)) && (paramAnonymousLong >= 0L)) {
              break label451;
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatSearchUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(33990);
          return;
          if (!(paramAnonymousAdapterView.cpt instanceof ot)) {
            break;
          }
          paramAnonymousView = ((ot)paramAnonymousAdapterView.cpt).YRT;
          Object localObject2 = ((BizChatSearchUI)localObject1).vEu;
          boolean bool1 = true;
          paramAnonymousAdapterView = new k();
          paramAnonymousAdapterView.field_userId = paramAnonymousView.YRR;
          paramAnonymousAdapterView.field_userName = paramAnonymousView.wwH;
          paramAnonymousAdapterView.field_brandUserName = ((String)localObject2);
          paramAnonymousAdapterView.field_headImageUrl = paramAnonymousView.YRK;
          paramAnonymousAdapterView.field_profileUrl = paramAnonymousView.mef;
          paramAnonymousAdapterView.field_UserVersion = paramAnonymousView.ver;
          paramAnonymousAdapterView.field_addMemberUrl = paramAnonymousView.YRO;
          if (!af.bHj().b(paramAnonymousAdapterView)) {
            bool1 = af.bHj().a(paramAnonymousAdapterView);
          }
          if (!bool1)
          {
            paramAnonymousLong = -1L;
            break;
          }
          paramAnonymousView = new com.tencent.mm.an.a.c();
          paramAnonymousView.field_bizChatServId = paramAnonymousAdapterView.field_userId;
          paramAnonymousView.field_brandUserName = paramAnonymousAdapterView.field_brandUserName;
          paramAnonymousView.field_chatName = paramAnonymousAdapterView.field_userName;
          paramAnonymousView.field_chatType = j.oyk.oyn;
          localObject2 = com.tencent.mm.an.a.e.e(paramAnonymousView);
          if (localObject2 == null)
          {
            paramAnonymousLong = -1L;
            break;
          }
          paramAnonymousView = af.bHi().iD(((com.tencent.mm.an.a.c)localObject2).field_bizChatLocalId);
          paramAnonymousAdapterView = paramAnonymousView;
          if (paramAnonymousView == null) {
            paramAnonymousAdapterView = new com.tencent.mm.an.a.a();
          }
          paramAnonymousAdapterView.field_bizChatId = ((com.tencent.mm.an.a.c)localObject2).field_bizChatLocalId;
          paramAnonymousAdapterView.field_unReadCount = 0;
          if (Util.isNullOrNil(paramAnonymousAdapterView.field_brandUserName))
          {
            paramAnonymousAdapterView.field_brandUserName = ((com.tencent.mm.an.a.c)localObject2).field_brandUserName;
            paramAnonymousAdapterView.field_lastMsgTime = System.currentTimeMillis();
            paramAnonymousAdapterView.field_flag = paramAnonymousAdapterView.field_lastMsgTime;
          }
          if (!af.bHi().b(paramAnonymousAdapterView)) {
            af.bHi().a(paramAnonymousAdapterView);
          }
          paramAnonymousLong = ((com.tencent.mm.an.a.c)localObject2).field_bizChatLocalId;
          break;
          label451:
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("Chat_User", ((BizChatSearchUI)localObject1).vEu);
          paramAnonymousAdapterView.putExtra("key_biz_chat_id", paramAnonymousLong);
          paramAnonymousAdapterView.putExtra("finish_direct", true);
          paramAnonymousAdapterView.putExtra("key_need_send_video", false);
          paramAnonymousAdapterView.putExtra("key_is_biz_chat", true);
          com.tencent.mm.br.c.g(((BizChatSearchUI)localObject1).getContext(), ".ui.chatting.ChattingUI", paramAnonymousAdapterView);
          continue;
          if (paramAnonymousAdapterView.viewType == BizChatSearchUI.g.aecu) {}
          try
          {
            localObject2 = (sa)((com.tencent.mm.ui.base.sortview.d)paramAnonymousAdapterView.cpt).cpt;
            if (localObject2 == null) {
              continue;
            }
            bool1 = com.tencent.mm.an.g.MC(((sa)localObject2).userName);
            boolean bool2 = com.tencent.mm.an.g.Dn(((sa)localObject2).userName);
            com.tencent.mm.api.c localc = com.tencent.mm.an.g.hU(((sa)localObject2).userName);
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
                paramAnonymousAdapterView.putExtra("srcUsername", ((sa)localObject2).userName);
                paramAnonymousAdapterView.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                paramAnonymousAdapterView.addFlags(67108864);
                com.tencent.mm.br.c.b(((BizChatSearchUI)localObject1).getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousAdapterView);
                ((BizChatSearchUI)localObject1).a(localc, 2);
                break;
                paramAnonymousAdapterView = localc.aAT();
                break label1275;
              }
              if (bool2)
              {
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("Contact_User", ((sa)localObject2).userName);
                paramAnonymousAdapterView.addFlags(67108864);
                paramAnonymousAdapterView.putExtra("biz_chat_from_scene", 3);
                com.tencent.mm.br.c.g(((BizChatSearchUI)localObject1).getContext(), ".ui.bizchat.BizChatConversationUI", paramAnonymousAdapterView);
                break;
              }
              paramAnonymousAdapterView = new Intent();
              paramAnonymousAdapterView.addFlags(67108864);
              paramAnonymousAdapterView.putExtra("finish_direct", true);
              paramAnonymousAdapterView.putExtra("Chat_User", ((sa)localObject2).userName);
              paramAnonymousAdapterView.putExtra("chat_from_scene", 2);
              com.tencent.mm.plugin.brandservice.b.d(paramAnonymousAdapterView, ((BizChatSearchUI)localObject1).getContext());
              ((BizChatSearchUI)localObject1).a(localc, 1);
              break;
              if (paramAnonymousAdapterView.viewType != BizChatSearchUI.g.aecr) {
                break;
              }
              if (((Integer)paramAnonymousAdapterView.cpt).intValue() == BizChatSearchUI.g.aecw)
              {
                paramAnonymousAdapterView = new Intent(((BizChatSearchUI)localObject1).getContext(), BizChatSearchUI.class);
                paramAnonymousAdapterView.putExtra("enterprise_biz_name", ((BizChatSearchUI)localObject1).vEu);
                paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 2);
                paramAnonymousAdapterView.putExtra("biz_chat_search_text", ((BizChatSearchUI)localObject1).vDu.getSearchContent());
                paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousAdapterView);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousAdapterView.aYi(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((BizChatSearchUI)localObject1).startActivity((Intent)paramAnonymousAdapterView.sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
              }
              if (((Integer)paramAnonymousAdapterView.cpt).intValue() == BizChatSearchUI.g.aecx)
              {
                paramAnonymousAdapterView = new Intent(((BizChatSearchUI)localObject1).getContext(), BizChatSearchUI.class);
                paramAnonymousAdapterView.putExtra("enterprise_biz_name", ((BizChatSearchUI)localObject1).vEu);
                paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 3);
                paramAnonymousAdapterView.putExtra("biz_chat_search_text", ((BizChatSearchUI)localObject1).vDu.getSearchContent());
                paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousAdapterView);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousAdapterView.aYi(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreGroupUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((BizChatSearchUI)localObject1).startActivity((Intent)paramAnonymousAdapterView.sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreGroupUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
              }
              if (((Integer)paramAnonymousAdapterView.cpt).intValue() != BizChatSearchUI.g.aecy) {
                break;
              }
              paramAnonymousAdapterView = new Intent(((BizChatSearchUI)localObject1).getContext(), BizChatSearchUI.class);
              paramAnonymousAdapterView.putExtra("enterprise_biz_name", ((BizChatSearchUI)localObject1).vEu);
              paramAnonymousAdapterView.putExtra("enterprise_biz_father_name", ((BizChatSearchUI)localObject1).aebE);
              paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 4);
              paramAnonymousAdapterView.putExtra("biz_chat_search_text", ((BizChatSearchUI)localObject1).vDu.getSearchContent());
              paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousAdapterView.aYi(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreAppUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((BizChatSearchUI)localObject1).startActivity((Intent)paramAnonymousAdapterView.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreAppUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              break;
              label1275:
              paramAnonymousView = paramAnonymousAdapterView;
              if (paramAnonymousAdapterView == null) {
                paramAnonymousView = "";
              }
            }
          }
          finally {}
        }
      }
    });
    this.aebH.setOnTouchListener(this);
    if (a.b(this.aebI)) {
      this.aebH.setOnScrollListener(this.INJ);
    }
    this.vDu = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.vDu.MY(a.c(this.aebI));
    this.vDu.a(this);
    this.vDu.pgU = false;
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
    this.vDu.a(this, paramMenu);
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
    this.vDu.cancel();
    this.vDu.clearFocus();
    AppMethodBeat.o(34020);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(34023);
    this.vDu.a(this, paramMenu);
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
    implements com.tencent.mm.am.h
  {
    public static int aebK = 3;
    private String aebE;
    private int aebL;
    boolean aebM;
    boolean aebN;
    boolean aebO;
    private ArrayList<com.tencent.mm.an.a.c> aebP;
    private ArrayList<Object> aebQ;
    private ArrayList<com.tencent.mm.an.a.c> aebR;
    private ArrayList<com.tencent.mm.ui.base.sortview.d> aebS;
    private List<com.tencent.mm.ui.base.sortview.d> aebT;
    private BizChatSearchUI.g aebU;
    private ArrayList<BizChatSearchUI.g> aebV;
    private BizChatSearchUI.g aebW;
    private BizChatSearchUI.g aebX;
    private ArrayList<BizChatSearchUI.g> aebY;
    private BizChatSearchUI.g aebZ;
    private BizChatSearchUI.g aeca;
    private ArrayList<BizChatSearchUI.g> aecb;
    private BizChatSearchUI.g aecc;
    public boolean aecd;
    public boolean aece;
    public boolean aecf;
    private boolean aecg;
    private boolean aech;
    private int aeci;
    private int aecj;
    public boolean aeck;
    int aecl;
    private int bUo;
    private Context context;
    String lMG;
    private com.tencent.mm.modelimage.loader.a.c oKb;
    int scene;
    String vEu;
    
    public a(Context paramContext, String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(250755);
      this.aebP = new ArrayList();
      this.aebQ = new ArrayList();
      this.aebR = new ArrayList();
      this.aebS = new ArrayList();
      this.aebV = new ArrayList();
      this.aebY = new ArrayList();
      this.aecb = new ArrayList();
      this.aecd = true;
      this.aece = false;
      this.aecf = false;
      this.aecg = true;
      this.aech = true;
      this.aeci = 0;
      this.aecj = 0;
      this.bUo = 0;
      this.aeck = false;
      this.aecl = 0;
      this.context = paramContext;
      this.vEu = paramString1;
      this.aebE = paramString2;
      this.scene = paramInt;
      boolean bool1;
      if ((this.scene == 1) || (this.scene == 2))
      {
        bool1 = true;
        this.aebM = bool1;
        if ((this.scene != 1) && (this.scene != 3)) {
          break label360;
        }
        bool1 = true;
        label204:
        this.aebN = bool1;
        bool1 = bool2;
        if (!Util.isNullOrNil(this.aebE)) {
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
        this.aebO = bool1;
        if (this.scene != 1) {
          break label366;
        }
      }
      label360:
      label366:
      for (paramInt = aebK;; paramInt = 2147483647)
      {
        this.aebL = paramInt;
        paramContext = new c.a();
        paramContext.prefixPath = com.tencent.mm.an.a.e.hx(this.vEu);
        paramContext.oKp = true;
        paramContext.nqa = true;
        paramContext.oKB = R.k.default_avatar;
        this.oKb = paramContext.bKx();
        if (this.aebO) {
          this.aebT = getSortEntityList();
        }
        if (this.aebM) {
          bh.aZW().a(1364, this);
        }
        AppMethodBeat.o(250755);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label204;
      }
    }
    
    private static boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
    {
      AppMethodBeat.i(250757);
      if ((!Util.isNullOrNil(paramString)) && (paramd != null))
      {
        Object localObject = (sa)paramd.cpt;
        if (localObject == null)
        {
          AppMethodBeat.o(250757);
          return false;
        }
        paramd = ((sa)localObject).contact.aSV();
        String str = ((sa)localObject).contact.aJt();
        localObject = ((sa)localObject).contact.aJu();
        paramString = paramString.toUpperCase();
        if (((!Util.isNullOrNil(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!Util.isNullOrNil(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString))))
        {
          AppMethodBeat.o(250757);
          return true;
        }
      }
      AppMethodBeat.o(250757);
      return false;
    }
    
    private static SpannableString b(Context paramContext, Spannable paramSpannable, int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(33998);
      paramContext = com.tencent.mm.pluginsdk.ui.span.p.d(paramContext, paramSpannable, paramInt);
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
    
    private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList()
    {
      AppMethodBeat.i(250760);
      ArrayList localArrayList = new ArrayList();
      af.bHf();
      Cursor localCursor = com.tencent.mm.an.f.U(this.aebE, true);
      while (localCursor.moveToNext())
      {
        sa localsa = new sa();
        Object localObject;
        if (localCursor != null)
        {
          localObject = new au();
          ((au)localObject).convertFrom(localCursor);
          com.tencent.mm.api.c localc = new com.tencent.mm.api.c();
          localc.convertFrom(localCursor);
          localsa.userName = ((az)localObject).field_username;
          localsa.contact = ((au)localObject);
          localsa.MVg = localc;
        }
        if (localsa.contact != null)
        {
          localObject = new com.tencent.mm.ui.base.sortview.d();
          ((com.tencent.mm.ui.base.sortview.d)localObject).cpt = localsa;
          if (localsa.MVg.aAR()) {
            ((com.tencent.mm.ui.base.sortview.d)localObject).aeaK = "!1";
          }
          for (;;)
          {
            localArrayList.add(localObject);
            break;
            if (localsa.contact.aSQ())
            {
              ((com.tencent.mm.ui.base.sortview.d)localObject).aeaK = "!2";
            }
            else
            {
              int j = localsa.contact.aRH();
              int i = j;
              if (j >= 97)
              {
                i = j;
                if (j <= 122) {
                  i = j - 32;
                }
              }
              if ((i >= 65) && (i <= 90)) {
                ((com.tencent.mm.ui.base.sortview.d)localObject).aeaK = ((char)i);
              } else {
                ((com.tencent.mm.ui.base.sortview.d)localObject).aeaK = "#";
              }
            }
          }
        }
      }
      localCursor.close();
      Collections.sort(localArrayList, new a((byte)0));
      AppMethodBeat.o(250760);
      return localArrayList;
    }
    
    private void hFo()
    {
      int k = 1;
      AppMethodBeat.i(34001);
      int i = this.aebQ.size();
      int n = this.aebR.size();
      int m = this.aebS.size();
      boolean bool;
      label82:
      label105:
      int j;
      if (this.scene != 2)
      {
        if (this.aebQ.size() > this.aebL)
        {
          bool = true;
          this.aecd = bool;
        }
      }
      else
      {
        if (this.aebR.size() <= this.aebL) {
          break label275;
        }
        bool = true;
        this.aecg = bool;
        if (this.aebS.size() <= this.aebL) {
          break label281;
        }
        bool = true;
        this.aech = bool;
        if ((i <= 0) && (!this.aece)) {
          break label310;
        }
        j = Math.min(i, this.aebL) + 1;
        if (!jnM()) {
          break label307;
        }
        if ((!this.aece) && (!this.aecd)) {
          break label287;
        }
        i = 1;
        label156:
        j = i + j;
      }
      for (;;)
      {
        this.aeci = j;
        i = j;
        if (n > 0)
        {
          j = Math.min(n, this.aebL) + (j + 1);
          if (!jnM()) {
            break label302;
          }
          if (!this.aecg) {
            break label292;
          }
          i = 1;
          label202:
          i += j;
        }
        for (;;)
        {
          this.aecj = i;
          j = i;
          if (m > 0)
          {
            m = i + 1 + Math.min(m, this.aebL);
            j = m;
            if (jnM()) {
              if (!this.aech) {
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
            this.bUo = j;
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
    
    private void jnL()
    {
      AppMethodBeat.i(33997);
      if (jnN())
      {
        this.aece = false;
        this.aeck = true;
        jnQ();
      }
      AppMethodBeat.o(33997);
    }
    
    private boolean jnM()
    {
      return this.scene == 1;
    }
    
    private boolean jnO()
    {
      return this.scene == 3;
    }
    
    private void jnP()
    {
      int k = 0;
      AppMethodBeat.i(34004);
      this.aebV.clear();
      this.aebY.clear();
      this.aecb.clear();
      int i = 0;
      while (i < Math.min(this.aebL, this.aebQ.size()))
      {
        this.aebV.add(new BizChatSearchUI.g(BizChatSearchUI.g.aecp, this.aebQ.get(i)));
        i += 1;
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= Math.min(this.aebL, this.aebR.size())) {
          break;
        }
        this.aebY.add(new BizChatSearchUI.g(BizChatSearchUI.g.aecq, this.aebR.get(i)));
        i += 1;
      }
      while (j < Math.min(this.aebL, this.aebS.size()))
      {
        this.aecb.add(new BizChatSearchUI.g(BizChatSearchUI.g.aecu, this.aebS.get(j)));
        j += 1;
      }
      AppMethodBeat.o(34004);
    }
    
    final void LM(boolean paramBoolean)
    {
      AppMethodBeat.i(34003);
      jnP();
      hFo();
      if (paramBoolean)
      {
        notifyDataSetChanged();
        jnQ();
      }
      AppMethodBeat.o(34003);
    }
    
    public final BizChatSearchUI.g aBu(int paramInt)
    {
      AppMethodBeat.i(33994);
      if (paramInt < this.aeci)
      {
        if (paramInt == 0)
        {
          if (this.aebU == null) {
            this.aebU = new BizChatSearchUI.g(BizChatSearchUI.g.aect, Integer.valueOf(BizChatSearchUI.g.aecw));
          }
          localg = this.aebU;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.aeci - 1) && (this.aece) && (jnM()))
        {
          if (this.aebW == null) {
            this.aebW = new BizChatSearchUI.g();
          }
          this.aebW.viewType = BizChatSearchUI.g.aecs;
          this.aebW.cpt = Integer.valueOf(BizChatSearchUI.g.aecw);
          localg = this.aebW;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.aeci - 1) && (this.aecd) && (jnM()))
        {
          if (this.aebW == null) {
            this.aebW = new BizChatSearchUI.g();
          }
          this.aebW.viewType = BizChatSearchUI.g.aecr;
          this.aebW.cpt = Integer.valueOf(BizChatSearchUI.g.aecw);
          localg = this.aebW;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt -= 1;
        if ((paramInt >= 0) && (paramInt < this.aebV.size()))
        {
          localg = (BizChatSearchUI.g)this.aebV.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      else if (paramInt < this.aecj)
      {
        if (paramInt == this.aeci)
        {
          if (this.aebX == null) {
            this.aebX = new BizChatSearchUI.g(BizChatSearchUI.g.aect, Integer.valueOf(BizChatSearchUI.g.aecx));
          }
          localg = this.aebX;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.bUo - 1) && (this.aecg) && (jnM()))
        {
          if (this.aebZ == null) {
            this.aebZ = new BizChatSearchUI.g(BizChatSearchUI.g.aecr, Integer.valueOf(BizChatSearchUI.g.aecx));
          }
          localg = this.aebZ;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt = paramInt - this.aeci - 1;
        if ((paramInt >= 0) && (paramInt < this.aebY.size()))
        {
          localg = (BizChatSearchUI.g)this.aebY.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      else
      {
        if (paramInt == this.aecj)
        {
          if (this.aeca == null) {
            this.aeca = new BizChatSearchUI.g(BizChatSearchUI.g.aect, Integer.valueOf(BizChatSearchUI.g.aecy));
          }
          localg = this.aeca;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.bUo - 1) && (this.aech) && (jnM()))
        {
          if (this.aecc == null) {
            this.aecc = new BizChatSearchUI.g(BizChatSearchUI.g.aecr, Integer.valueOf(BizChatSearchUI.g.aecy));
          }
          localg = this.aecc;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt = paramInt - this.aecj - 1;
        if ((paramInt >= 0) && (paramInt < this.aecb.size()))
        {
          localg = (BizChatSearchUI.g)this.aecb.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      BizChatSearchUI.g localg = new BizChatSearchUI.g();
      AppMethodBeat.o(33994);
      return localg;
    }
    
    final void bAs(String paramString)
    {
      AppMethodBeat.i(250768);
      this.aebS.clear();
      if ((!Util.isNullOrNil(paramString)) && (this.aebT != null))
      {
        Iterator localIterator = this.aebT.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.ui.base.sortview.d locald = (com.tencent.mm.ui.base.sortview.d)localIterator.next();
          if (a(paramString, locald)) {
            this.aebS.add(locald);
          }
        }
      }
      LM(true);
      AppMethodBeat.o(250768);
    }
    
    final void bAt(final String paramString)
    {
      AppMethodBeat.i(34000);
      if (!this.aebM)
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
          bh.aZW().a(localm, 0);
          AppMethodBeat.o(33991);
        }
      }, 200L);
      AppMethodBeat.o(34000);
    }
    
    final void clearData()
    {
      AppMethodBeat.i(34002);
      this.aecl = 0;
      this.aebQ.clear();
      this.aebP.clear();
      this.aebR.clear();
      AppMethodBeat.o(34002);
    }
    
    final void ei(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(33999);
      paramString = af.bHi().bx(this.vEu, paramString);
      clearData();
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        com.tencent.mm.an.a.c localc = (com.tencent.mm.an.a.c)paramString.next();
        bool = localc.bHx();
        if ((bool) && (this.aebN))
        {
          this.aebR.add(localc);
        }
        else if ((!bool) && (this.aebM))
        {
          this.aebQ.add(localc);
          this.aebP.add(localc);
        }
      }
      if (this.aebM) {
        if (this.aebQ.size() > this.aebL) {
          break label153;
        }
      }
      label153:
      for (boolean bool = true;; bool = false)
      {
        this.aece = bool;
        LM(paramBoolean);
        AppMethodBeat.o(33999);
        return;
      }
    }
    
    public final int getCount()
    {
      return this.bUo;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(33993);
      BizChatSearchUI.g localg = aBu(paramInt);
      if (localg != null)
      {
        paramInt = localg.viewType;
        AppMethodBeat.o(33993);
        return paramInt;
      }
      paramInt = BizChatSearchUI.g.aeco;
      AppMethodBeat.o(33993);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(33995);
      BizChatSearchUI.g localg = aBu(paramInt);
      View localView;
      int i;
      BizChatSearchUI.f localf;
      Object localObject2;
      boolean bool1;
      String str;
      Object localObject1;
      if ((localg.viewType == BizChatSearchUI.g.aecp) || (localg.viewType == BizChatSearchUI.g.aecq) || (localg.viewType == BizChatSearchUI.g.aecu))
      {
        localView = paramView;
        if (paramView == null)
        {
          localView = LayoutInflater.from(this.context).inflate(R.i.fts_contact_item, paramViewGroup, false);
          i = paramViewGroup.getPaddingLeft();
          int j = paramViewGroup.getPaddingRight();
          localView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(paramViewGroup.getWidth(), 1073741824), i + j, -1), View.MeasureSpec.makeMeasureSpec(-2, 1073741824));
          paramView = new BizChatSearchUI.f((byte)0);
          paramView.lBC = ((ImageView)localView.findViewById(R.h.avatar_iv));
          paramView.pJJ = ((TextView)localView.findViewById(R.h.title_tv));
          paramView.plr = ((TextView)localView.findViewById(R.h.desc_tv));
          paramView.contentView = localView.findViewById(R.h.search_item_content_layout);
          localView.setTag(paramView);
        }
        localf = (BizChatSearchUI.f)localView.getTag();
        paramViewGroup = "";
        localObject2 = "";
        bool1 = false;
        str = "";
        if ((localg.cpt instanceof com.tencent.mm.an.a.c))
        {
          paramView = (com.tencent.mm.an.a.c)localg.cpt;
          if (paramView == null) {
            break label1414;
          }
          if (!paramView.bHx())
          {
            localObject1 = af.bHj().hM(paramView.field_bizChatServId);
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
            paramViewGroup = com.tencent.mm.plugin.fts.a.f.b(paramViewGroup, this.lMG);
            paramViewGroup = b(this.context, paramViewGroup, b.c.HwQ);
            label309:
            if (!bool1) {
              break label686;
            }
            localObject2 = this.context.getString(R.l.bizchat_search_user_tag_userid);
            localObject1 = com.tencent.mm.plugin.fts.a.f.b((CharSequence)localObject1, this.lMG);
          }
          label686:
          for (localObject1 = TextUtils.concat(new CharSequence[] { localObject2, b(this.context, (Spannable)localObject1, b.c.HwQ) });; localObject1 = "")
          {
            boolean bool2 = true;
            bool1 = bool2;
            if (localg.viewType == BizChatSearchUI.g.aecp)
            {
              bool1 = bool2;
              if (paramInt == this.aeci - 1)
              {
                bool1 = bool2;
                if (this.aeci != this.bUo) {
                  bool1 = false;
                }
              }
            }
            o.x(localf.contentView, bool1);
            r.bKe().a(paramView, localf.lBC, this.oKb);
            o.a(paramViewGroup, localf.pJJ);
            o.a((CharSequence)localObject1, localf.plr);
            AppMethodBeat.o(33995);
            return localView;
            paramViewGroup = paramView.field_chatName;
            paramView = paramView.field_headImageUrl;
            break;
            if ((localg.cpt instanceof ot))
            {
              localObject1 = (ot)localg.cpt;
              paramView = ((ot)localObject1).YRT;
              paramViewGroup = paramView.wwH;
              paramView = paramView.YRK;
              bool1 = "userid".equals(((ot)localObject1).YRU);
              if (!bool1) {}
              for (i = 1;; i = 0)
              {
                localObject1 = ((ot)localObject1).YRV;
                break;
              }
            }
            if (!(localg.cpt instanceof com.tencent.mm.ui.base.sortview.d)) {
              break label1396;
            }
            sa localsa = (sa)((com.tencent.mm.ui.base.sortview.d)localg.cpt).cpt;
            localObject1 = localObject2;
            paramView = paramViewGroup;
            if (localsa != null)
            {
              if (localsa.contact != null) {
                paramViewGroup = localsa.contact.aSV();
              }
              localObject1 = localObject2;
              paramView = paramViewGroup;
              if (localsa.MVg != null)
              {
                localObject1 = localsa.MVg.field_brandIconURL;
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
            paramViewGroup = b(this.context, new SpannableString(paramViewGroup), b.c.HwQ);
            break label309;
          }
          if (localg.viewType == BizChatSearchUI.g.aect)
          {
            localObject1 = paramView;
            if (paramView == null)
            {
              localObject1 = LayoutInflater.from(this.context).inflate(R.i.geH, paramViewGroup, false);
              paramView = new BizChatSearchUI.b((byte)0);
              paramView.wSo = ((TextView)((View)localObject1).findViewById(R.h.tip_tv));
              paramView.HAy = ((View)localObject1).findViewById(R.h.padding_view);
              paramView.contentView = ((View)localObject1).findViewById(R.h.search_item_content_layout);
              ((View)localObject1).setTag(paramView);
            }
            paramViewGroup = (BizChatSearchUI.b)((View)localObject1).getTag();
            if (((Integer)localg.cpt).intValue() == BizChatSearchUI.g.aecw) {
              paramView = this.context.getResources().getString(R.l.bizchat_search_user);
            }
          }
          for (;;)
          {
            o.b(paramView, paramViewGroup.wSo);
            if (paramInt == 0) {
              paramViewGroup.HAy.setVisibility(8);
            }
            for (;;)
            {
              paramViewGroup.contentView.setBackgroundResource(R.g.list_thicklinecell_bg);
              AppMethodBeat.o(33995);
              return localObject1;
              if (((Integer)localg.cpt).intValue() == BizChatSearchUI.g.aecx)
              {
                paramView = this.context.getResources().getString(R.l.bizchat_search_group);
                break;
              }
              if (((Integer)localg.cpt).intValue() != BizChatSearchUI.g.aecy) {
                break label1389;
              }
              paramView = this.context.getResources().getString(R.l.bizchat_search_app);
              break;
              paramViewGroup.HAy.setVisibility(0);
            }
            if (localg.viewType == BizChatSearchUI.g.aecr)
            {
              localObject1 = paramView;
              if (paramView == null)
              {
                localObject1 = LayoutInflater.from(this.context).inflate(R.i.geI, paramViewGroup, false);
                paramView = new BizChatSearchUI.e((byte)0);
                paramView.DSB = ((TextView)((View)localObject1).findViewById(R.h.tip_tv));
                paramView.ttT = ((ImageView)((View)localObject1).findViewById(R.h.icon_iv));
                paramView.contentView = ((View)localObject1).findViewById(R.h.search_item_content_layout);
                ((View)localObject1).setTag(paramView);
              }
              paramViewGroup = (BizChatSearchUI.e)((View)localObject1).getTag();
              paramView = "";
              if (((Integer)localg.cpt).intValue() == BizChatSearchUI.g.aecw)
              {
                paramView = this.context.getResources().getString(R.l.bizchat_search_more_user);
                if ((((Integer)localg.cpt).intValue() != BizChatSearchUI.g.aecw) || (this.aeci == this.bUo)) {
                  break label1383;
                }
              }
            }
            label1377:
            label1383:
            for (bool1 = false;; bool1 = true)
            {
              o.x(paramViewGroup.contentView, bool1);
              paramViewGroup.DSB.setText(paramView);
              paramViewGroup.ttT.setImageResource(R.k.fts_more_button_icon);
              AppMethodBeat.o(33995);
              return localObject1;
              if (((Integer)localg.cpt).intValue() == BizChatSearchUI.g.aecx)
              {
                paramView = this.context.getResources().getString(R.l.bizchat_search_more_group);
                break;
              }
              if (((Integer)localg.cpt).intValue() != BizChatSearchUI.g.aecy) {
                break;
              }
              paramView = this.context.getResources().getString(R.l.bizchat_search_more_app);
              break;
              if (localg.viewType == BizChatSearchUI.g.aecs)
              {
                localObject1 = paramView;
                if (paramView == null)
                {
                  localObject1 = LayoutInflater.from(this.context).inflate(R.i.fts_loading_item, paramViewGroup, false);
                  paramView = new BizChatSearchUI.d((byte)0);
                  paramView.DSB = ((TextView)((View)localObject1).findViewById(R.h.tip_tv));
                  paramView.contentView = ((View)localObject1).findViewById(R.h.search_item_content_layout);
                  ((View)localObject1).setTag(paramView);
                }
                paramView = (BizChatSearchUI.d)((View)localObject1).getTag();
                if ((((Integer)localg.cpt).intValue() != BizChatSearchUI.g.aecw) || (this.aeci == this.bUo)) {
                  break label1377;
                }
              }
              for (bool1 = false;; bool1 = true)
              {
                o.x(paramView.contentView, bool1);
                paramView.DSB.setText(this.context.getResources().getString(R.l.bizchat_search_loading));
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
      return BizChatSearchUI.g.aecv;
    }
    
    final boolean jnN()
    {
      return this.scene == 2;
    }
    
    final void jnQ()
    {
      AppMethodBeat.i(34005);
      ((BizChatSearchUI)this.context).a(this);
      AppMethodBeat.o(34005);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(33996);
      Object localObject1;
      Object localObject2;
      if ((this.aebM) && (paramp.getType() == 1364) && ((paramp instanceof m)))
      {
        this.aecf = false;
        localObject1 = (m)paramp;
        if ((((m)localObject1).rr != null) && (c.b.b(((m)localObject1).rr.otB) != null)) {}
        for (paramString = (ou)c.b.b(((m)localObject1).rr.otB);; paramString = null)
        {
          paramp = paramString.hAB;
          localObject2 = paramString.YRQ;
          if ((paramp.equals(this.lMG)) && (((String)localObject2).equals(this.vEu)) && (this.aecl == paramString.offset)) {
            break;
          }
          AppMethodBeat.o(33996);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          jnL();
          AppMethodBeat.o(33996);
          return;
        }
        if ((((m)localObject1).rr != null) && (c.c.b(((m)localObject1).rr.otC) != null)) {}
        for (paramString = (ov)c.c.b(((m)localObject1).rr.otC); (paramString == null) || (paramString.YRW == null) || (paramString.YRW.ret != 0); paramString = null)
        {
          jnL();
          AppMethodBeat.o(33996);
          return;
        }
        localObject1 = paramString.YRX;
        boolean bool = paramString.YRY;
        if (paramp.equals(this.lMG))
        {
          this.aece = false;
          this.aecl += ((List)localObject1).size();
          if (jnM())
          {
            if (this.aebQ.size() < this.aebP.size())
            {
              ei(paramp, true);
              AppMethodBeat.o(33996);
              return;
            }
            if (this.aebQ.size() > this.aebP.size()) {}
          }
          else
          {
            if (jnN()) {
              this.aecd = bool;
            }
            if (jnO()) {
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
          paramp = (ot)paramString.next();
          localObject1 = paramp.YRT;
          if (!Util.isNullOrNil(((ow)localObject1).YRR))
          {
            localObject2 = this.aebP.iterator();
            com.tencent.mm.an.a.c localc;
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localc = (com.tencent.mm.an.a.c)((Iterator)localObject2).next();
            } while (!((ow)localObject1).YRR.equals(localc.field_bizChatServId));
          }
        }
        else
        {
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              break label480;
            }
            this.aebQ.add(paramp);
            break;
            LM(true);
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
    public View HAy;
    public View contentView;
    public TextView wSo;
  }
  
  static final class c
  {
    View vDj;
    View vDk;
    View vDl;
    
    private void O(boolean paramBoolean1, boolean paramBoolean2)
    {
      int j = 0;
      AppMethodBeat.i(34011);
      View localView = this.vDj;
      if (paramBoolean1)
      {
        i = 0;
        localView.setVisibility(i);
        this.vDk.setVisibility(8);
        localView = this.vDl;
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
        O(false, false);
        AppMethodBeat.o(34010);
        return;
      case 1: 
        O(true, false);
        AppMethodBeat.o(34010);
        return;
      }
      O(false, true);
      AppMethodBeat.o(34010);
    }
  }
  
  static final class d
  {
    public TextView DSB;
    public View contentView;
  }
  
  static final class e
  {
    public TextView DSB;
    public View contentView;
    public ImageView ttT;
  }
  
  static final class f
  {
    public View contentView;
    public ImageView lBC;
    public TextView pJJ;
    public TextView plr;
  }
  
  static final class g
  {
    public static int aeco = 0;
    public static int aecp = 1;
    public static int aecq = 2;
    public static int aecr = 3;
    public static int aecs = 4;
    public static int aect = 5;
    public static int aecu = 6;
    public static int aecv = 7;
    public static int aecw = 1;
    public static int aecx = 2;
    public static int aecy = 3;
    public Object cpt;
    public int viewType;
    
    public g()
    {
      this.viewType = aeco;
      this.cpt = null;
    }
    
    public g(int paramInt, Object paramObject)
    {
      this.viewType = paramInt;
      this.cpt = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchUI
 * JD-Core Version:    0.7.0.1
 */