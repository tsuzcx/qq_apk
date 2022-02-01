package com.tencent.mm.ui.bizchat;

import android.app.Activity;
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
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.a.j;
import com.tencent.mm.ao.a.k;
import com.tencent.mm.ao.a.m;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.g;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.protocal.protobuf.no;
import com.tencent.mm.protocal.protobuf.np;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.protocal.protobuf.qp;
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
  private AbsListView.OnScrollListener CTt;
  String Wum;
  private String Wun;
  private c Wuo;
  private BizChatSearchListView Wup;
  private a Wuq;
  private TextView jbI;
  private int scene;
  com.tencent.mm.modelvoiceaddr.ui.b sxL;
  String syN;
  
  public BizChatSearchUI()
  {
    AppMethodBeat.i(34012);
    this.CTt = new AbsListView.OnScrollListener()
    {
      boolean sxA = false;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
        {
          this.sxA = true;
          return;
        }
        this.sxA = false;
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33989);
        if ((paramAnonymousInt == 0) && (this.sxA) && (BizChatSearchUI.a(BizChatSearchUI.this).WuL))
        {
          paramAnonymousAbsListView = BizChatSearchUI.a(BizChatSearchUI.this);
          if ((paramAnonymousAbsListView.hLl()) && (!paramAnonymousAbsListView.WuN))
          {
            paramAnonymousAbsListView.WuN = true;
            m localm = new m(paramAnonymousAbsListView.syN, paramAnonymousAbsListView.jkc, paramAnonymousAbsListView.WuT);
            bh.aGY().a(localm, 0);
            paramAnonymousAbsListView.hLo();
          }
        }
        AppMethodBeat.o(33989);
      }
    };
    AppMethodBeat.o(34012);
  }
  
  private void auR(int paramInt)
  {
    AppMethodBeat.i(34025);
    if (this.Wuo != null) {
      this.Wuo.updateStatus(paramInt);
    }
    AppMethodBeat.o(34025);
  }
  
  final void a(com.tencent.mm.api.c paramc, int paramInt)
  {
    AppMethodBeat.i(283795);
    com.tencent.mm.ao.d locald = af.bjF().Uj(this.Wum);
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
      long l3 = paramc.Zc();
      h.IzE.a(14507, new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(paramInt) });
      Log.d("MicroMsg.BizChatSearchUI", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(paramInt) });
      AppMethodBeat.o(283795);
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
        this.jbI.setVisibility(8);
        this.Wup.setVisibility(8);
        AppMethodBeat.o(34015);
        return;
      }
      if (parama.getCount() <= 0)
      {
        this.jbI.setVisibility(0);
        this.Wup.setVisibility(8);
        AppMethodBeat.o(34015);
        return;
      }
      this.jbI.setVisibility(8);
      this.Wup.setVisibility(0);
      AppMethodBeat.o(34015);
      return;
    }
    if (Util.isNullOrNil(a.d(parama)))
    {
      this.jbI.setVisibility(0);
      this.jbI.setText("");
      this.Wup.setVisibility(8);
    }
    while (a.b(parama)) {
      if (parama.WuN)
      {
        auR(1);
        AppMethodBeat.o(34015);
        return;
        if ((a.b(parama)) && (parama.WuM))
        {
          this.jbI.setVisibility(0);
          this.jbI.setText(R.l.etg);
          this.Wup.setVisibility(8);
        }
        else if ((a.b(parama)) && (parama.WuS))
        {
          this.jbI.setVisibility(0);
          this.jbI.setText(R.l.eth);
          this.Wup.setVisibility(8);
        }
        else if (parama.getCount() <= 0)
        {
          this.jbI.setVisibility(0);
          this.jbI.setText(com.tencent.mm.plugin.fts.a.f.a(getString(R.l.search_contact_no_result_pre), getString(R.l.search_contact_no_result_post), com.tencent.mm.plugin.fts.a.a.e.c(a.d(parama), a.d(parama))).BIp);
          this.Wup.setVisibility(8);
        }
        else
        {
          this.jbI.setVisibility(8);
          this.Wup.setVisibility(0);
        }
      }
      else
      {
        if (parama.WuL)
        {
          auR(2);
          AppMethodBeat.o(34015);
          return;
        }
        auR(0);
      }
    }
    AppMethodBeat.o(34015);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final boolean aat(String paramString)
  {
    AppMethodBeat.i(34018);
    hideVKB();
    AppMethodBeat.o(34018);
    return true;
  }
  
  public final void aau(String paramString)
  {
    a locala = null;
    AppMethodBeat.i(34017);
    if ((Util.isNullOrNil(paramString)) && (this.Wun != null))
    {
      paramString = this.Wun;
      this.Wun = null;
      if (!paramString.equals("")) {
        this.sxL.setSearchContent(paramString);
      }
      com.tencent.mm.modelvoiceaddr.ui.b localb = this.sxL;
      if (a.c(this.Wuq)) {
        paramString = getContext().getResources().getString(R.l.eti);
      }
      for (;;)
      {
        localb.setHint(paramString);
        this.sxL.clearFocus();
        AppMethodBeat.o(34017);
        return;
        if (a.b(this.Wuq))
        {
          paramString = getContext().getResources().getString(R.l.etn);
        }
        else
        {
          paramString = locala;
          if (a.e(this.Wuq)) {
            paramString = getContext().getResources().getString(R.l.etf);
          }
        }
      }
    }
    locala = this.Wuq;
    locala.jkc = paramString;
    if (Util.isNullOrNil(paramString))
    {
      locala.clearData();
      locala.WuM = false;
      locala.WuS = false;
      locala.Ga(true);
      AppMethodBeat.o(34017);
      return;
    }
    if (locala.scene == 4) {}
    for (int i = 1; i != 0; i = 0)
    {
      locala.clearData();
      locala.WuM = false;
      locala.WuS = false;
      locala.byP(paramString);
      AppMethodBeat.o(34017);
      return;
    }
    if (locala.hLl())
    {
      locala.WuM = true;
      locala.WuS = false;
      locala.hLo();
      locala.dA(paramString, false);
      locala.byQ(paramString);
      AppMethodBeat.o(34017);
      return;
    }
    locala.dA(paramString, true);
    if ((locala.Wuu) && (locala.WuM)) {
      locala.byQ(paramString);
    }
    if (locala.Wuw) {
      locala.byP(paramString);
    }
    AppMethodBeat.o(34017);
  }
  
  public final void bsk()
  {
    AppMethodBeat.i(34019);
    hideVKB();
    AppMethodBeat.o(34019);
  }
  
  public final void bxH()
  {
    AppMethodBeat.i(34016);
    finish();
    AppMethodBeat.o(34016);
  }
  
  public final void bxI() {}
  
  public final void bxJ() {}
  
  public final void bxK() {}
  
  public final boolean czC()
  {
    AppMethodBeat.i(34024);
    hideVKB();
    AppMethodBeat.o(34024);
    return false;
  }
  
  public int getLayoutId()
  {
    return R.i.ega;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34014);
    if (Util.isNullOrNil(this.syN))
    {
      this.syN = getIntent().getStringExtra("enterprise_biz_name");
      this.Wum = getIntent().getStringExtra("enterprise_biz_father_name");
      this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
      this.Wun = getIntent().getStringExtra("biz_chat_search_text");
      if (Util.isNullOrNil(this.syN)) {
        finish();
      }
    }
    this.Wup = ((BizChatSearchListView)findViewById(R.h.duo));
    this.jbI = ((TextView)findViewById(R.h.no_result_tv));
    this.Wuq = new a(getContext(), this.syN, this.Wum, this.scene);
    if (a.b(this.Wuq))
    {
      this.Wuo = new c((byte)0);
      BizChatSearchListView localBizChatSearchListView = this.Wup;
      c localc = this.Wuo;
      View localView = View.inflate(getContext(), R.i.ein, null);
      localc.sxC = localView.findViewById(R.h.loading_progress);
      localc.sxD = localView.findViewById(R.h.loading_end);
      localc.sxE = localView.findViewById(R.h.dLy);
      localc.sxC.setVisibility(8);
      localc.sxD.setVisibility(8);
      localc.sxE.setVisibility(8);
      localBizChatSearchListView.addFooterView(localView);
      auR(0);
    }
    this.Wup.setAdapter(this.Wuq);
    this.Wup.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33990);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/bizchat/BizChatSearchUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        paramAnonymousAdapterView = BizChatSearchUI.a(BizChatSearchUI.this).auS(paramAnonymousInt);
        localObject1 = BizChatSearchUI.this;
        if ((paramAnonymousAdapterView.viewType == BizChatSearchUI.g.WuX) || (paramAnonymousAdapterView.viewType == BizChatSearchUI.g.WuY))
        {
          paramAnonymousLong = -1L;
          if ((paramAnonymousAdapterView.bnW instanceof com.tencent.mm.ao.a.c))
          {
            paramAnonymousAdapterView = (com.tencent.mm.ao.a.c)paramAnonymousAdapterView.bnW;
            if (paramAnonymousAdapterView != null) {
              paramAnonymousLong = paramAnonymousAdapterView.field_bizChatLocalId;
            }
            if ((!Util.isNullOrNil(((BizChatSearchUI)localObject1).syN)) && (paramAnonymousLong >= 0L)) {
              break label431;
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatSearchUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(33990);
          return;
          if (!(paramAnonymousAdapterView.bnW instanceof nn)) {
            break;
          }
          paramAnonymousView = ((nn)paramAnonymousAdapterView.bnW).RUs;
          Object localObject2 = ((BizChatSearchUI)localObject1).syN;
          boolean bool1 = true;
          paramAnonymousAdapterView = new k();
          paramAnonymousAdapterView.field_userId = paramAnonymousView.RUq;
          paramAnonymousAdapterView.field_userName = paramAnonymousView.tsk;
          paramAnonymousAdapterView.field_brandUserName = ((String)localObject2);
          paramAnonymousAdapterView.field_headImageUrl = paramAnonymousView.RUj;
          paramAnonymousAdapterView.field_profileUrl = paramAnonymousView.jEj;
          paramAnonymousAdapterView.field_UserVersion = paramAnonymousView.ver;
          paramAnonymousAdapterView.field_addMemberUrl = paramAnonymousView.RUn;
          if (!af.bjz().b(paramAnonymousAdapterView)) {
            bool1 = af.bjz().a(paramAnonymousAdapterView);
          }
          if (!bool1)
          {
            paramAnonymousLong = -1L;
            break;
          }
          paramAnonymousView = new com.tencent.mm.ao.a.c();
          paramAnonymousView.field_bizChatServId = paramAnonymousAdapterView.field_userId;
          paramAnonymousView.field_brandUserName = paramAnonymousAdapterView.field_brandUserName;
          paramAnonymousView.field_chatName = paramAnonymousAdapterView.field_userName;
          paramAnonymousView.field_chatType = j.lGD.lGG;
          paramAnonymousAdapterView = com.tencent.mm.ao.a.e.e(paramAnonymousView);
          if (paramAnonymousAdapterView == null)
          {
            paramAnonymousLong = -1L;
            break;
          }
          paramAnonymousView = af.bjy().Gt(paramAnonymousAdapterView.field_bizChatLocalId);
          paramAnonymousView.field_bizChatId = paramAnonymousAdapterView.field_bizChatLocalId;
          paramAnonymousView.field_unReadCount = 0;
          if (Util.isNullOrNil(paramAnonymousView.field_brandUserName))
          {
            paramAnonymousView.field_brandUserName = paramAnonymousAdapterView.field_brandUserName;
            paramAnonymousView.field_lastMsgTime = System.currentTimeMillis();
            paramAnonymousView.field_flag = paramAnonymousView.field_lastMsgTime;
          }
          if (!af.bjy().b(paramAnonymousView)) {
            af.bjy().a(paramAnonymousView);
          }
          paramAnonymousLong = paramAnonymousAdapterView.field_bizChatLocalId;
          break;
          label431:
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("Chat_User", ((BizChatSearchUI)localObject1).syN);
          paramAnonymousAdapterView.putExtra("key_biz_chat_id", paramAnonymousLong);
          paramAnonymousAdapterView.putExtra("finish_direct", true);
          paramAnonymousAdapterView.putExtra("key_need_send_video", false);
          paramAnonymousAdapterView.putExtra("key_is_biz_chat", true);
          com.tencent.mm.by.c.f(((BizChatSearchUI)localObject1).getContext(), ".ui.chatting.ChattingUI", paramAnonymousAdapterView);
          continue;
          if (paramAnonymousAdapterView.viewType == BizChatSearchUI.g.Wvc) {}
          try
          {
            localObject2 = (qp)((com.tencent.mm.ui.base.sortview.d)paramAnonymousAdapterView.bnW).bnW;
            if (localObject2 == null) {
              continue;
            }
            bool1 = g.UD(((qp)localObject2).userName);
            boolean bool2 = g.KI(((qp)localObject2).userName);
            com.tencent.mm.api.c localc = g.gu(((qp)localObject2).userName);
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
                paramAnonymousAdapterView.putExtra("srcUsername", ((qp)localObject2).userName);
                paramAnonymousAdapterView.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                paramAnonymousAdapterView.addFlags(67108864);
                com.tencent.mm.by.c.b(((BizChatSearchUI)localObject1).getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousAdapterView);
                ((BizChatSearchUI)localObject1).a(localc, 2);
                break;
                paramAnonymousAdapterView = localc.Zb();
                break label1256;
              }
              if (bool2)
              {
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("Contact_User", ((qp)localObject2).userName);
                paramAnonymousAdapterView.addFlags(67108864);
                paramAnonymousAdapterView.putExtra("biz_chat_from_scene", 3);
                com.tencent.mm.by.c.f(((BizChatSearchUI)localObject1).getContext(), ".ui.bizchat.BizChatConversationUI", paramAnonymousAdapterView);
                break;
              }
              paramAnonymousAdapterView = new Intent();
              paramAnonymousAdapterView.addFlags(67108864);
              paramAnonymousAdapterView.putExtra("finish_direct", true);
              paramAnonymousAdapterView.putExtra("Chat_User", ((qp)localObject2).userName);
              paramAnonymousAdapterView.putExtra("chat_from_scene", 2);
              com.tencent.mm.plugin.brandservice.b.d(paramAnonymousAdapterView, ((BizChatSearchUI)localObject1).getContext());
              ((BizChatSearchUI)localObject1).a(localc, 1);
              break;
              if (paramAnonymousAdapterView.viewType != BizChatSearchUI.g.WuZ) {
                break;
              }
              if (((Integer)paramAnonymousAdapterView.bnW).intValue() == BizChatSearchUI.g.Wve)
              {
                paramAnonymousAdapterView = new Intent(((BizChatSearchUI)localObject1).getContext(), BizChatSearchUI.class);
                paramAnonymousAdapterView.putExtra("enterprise_biz_name", ((BizChatSearchUI)localObject1).syN);
                paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 2);
                paramAnonymousAdapterView.putExtra("biz_chat_search_text", ((BizChatSearchUI)localObject1).sxL.getSearchContent());
                paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousAdapterView);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousAdapterView.aFh(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((BizChatSearchUI)localObject1).startActivity((Intent)paramAnonymousAdapterView.sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
              }
              if (((Integer)paramAnonymousAdapterView.bnW).intValue() == BizChatSearchUI.g.Wvf)
              {
                paramAnonymousAdapterView = new Intent(((BizChatSearchUI)localObject1).getContext(), BizChatSearchUI.class);
                paramAnonymousAdapterView.putExtra("enterprise_biz_name", ((BizChatSearchUI)localObject1).syN);
                paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 3);
                paramAnonymousAdapterView.putExtra("biz_chat_search_text", ((BizChatSearchUI)localObject1).sxL.getSearchContent());
                paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousAdapterView);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousAdapterView.aFh(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreGroupUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((BizChatSearchUI)localObject1).startActivity((Intent)paramAnonymousAdapterView.sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreGroupUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
              }
              if (((Integer)paramAnonymousAdapterView.bnW).intValue() != BizChatSearchUI.g.Wvg) {
                break;
              }
              paramAnonymousAdapterView = new Intent(((BizChatSearchUI)localObject1).getContext(), BizChatSearchUI.class);
              paramAnonymousAdapterView.putExtra("enterprise_biz_name", ((BizChatSearchUI)localObject1).syN);
              paramAnonymousAdapterView.putExtra("enterprise_biz_father_name", ((BizChatSearchUI)localObject1).Wum);
              paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 4);
              paramAnonymousAdapterView.putExtra("biz_chat_search_text", ((BizChatSearchUI)localObject1).sxL.getSearchContent());
              paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousAdapterView.aFh(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreAppUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((BizChatSearchUI)localObject1).startActivity((Intent)paramAnonymousAdapterView.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreAppUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              break;
              label1256:
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
    this.Wup.setOnTouchListener(this);
    if (a.b(this.Wuq)) {
      this.Wup.setOnScrollListener(this.CTt);
    }
    this.sxL = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.sxL.He(a.c(this.Wuq));
    this.sxL.a(this);
    this.sxL.mni = false;
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
    this.sxL.a(this, paramMenu);
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
    this.sxL.cancel();
    this.sxL.clearFocus();
    AppMethodBeat.o(34020);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(34023);
    this.sxL.a(this, paramMenu);
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
    public static int Wus = 3;
    private ArrayList<com.tencent.mm.ui.base.sortview.d> WuA;
    private List<com.tencent.mm.ui.base.sortview.d> WuB;
    private BizChatSearchUI.g WuC;
    private ArrayList<BizChatSearchUI.g> WuD;
    private BizChatSearchUI.g WuE;
    private BizChatSearchUI.g WuF;
    private ArrayList<BizChatSearchUI.g> WuG;
    private BizChatSearchUI.g WuH;
    private BizChatSearchUI.g WuI;
    private ArrayList<BizChatSearchUI.g> WuJ;
    private BizChatSearchUI.g WuK;
    public boolean WuL;
    public boolean WuM;
    public boolean WuN;
    private boolean WuO;
    private boolean WuP;
    private int WuQ;
    private int WuR;
    public boolean WuS;
    int WuT;
    private String Wum;
    private int Wut;
    boolean Wuu;
    boolean Wuv;
    boolean Wuw;
    private ArrayList<com.tencent.mm.ao.a.c> Wux;
    private ArrayList<Object> Wuy;
    private ArrayList<com.tencent.mm.ao.a.c> Wuz;
    private int afI;
    private Context context;
    String jkc;
    private com.tencent.mm.ay.a.a.c lRp;
    int scene;
    String syN;
    
    public a(Context paramContext, String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(273054);
      this.Wux = new ArrayList();
      this.Wuy = new ArrayList();
      this.Wuz = new ArrayList();
      this.WuA = new ArrayList();
      this.WuD = new ArrayList();
      this.WuG = new ArrayList();
      this.WuJ = new ArrayList();
      this.WuL = true;
      this.WuM = false;
      this.WuN = false;
      this.WuO = true;
      this.WuP = true;
      this.WuQ = 0;
      this.WuR = 0;
      this.afI = 0;
      this.WuS = false;
      this.WuT = 0;
      this.context = paramContext;
      this.syN = paramString1;
      this.Wum = paramString2;
      this.scene = paramInt;
      boolean bool1;
      if ((this.scene == 1) || (this.scene == 2))
      {
        bool1 = true;
        this.Wuu = bool1;
        if ((this.scene != 1) && (this.scene != 3)) {
          break label360;
        }
        bool1 = true;
        label204:
        this.Wuv = bool1;
        bool1 = bool2;
        if (!Util.isNullOrNil(this.Wum)) {
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
        this.Wuw = bool1;
        if (this.scene != 1) {
          break label366;
        }
      }
      label360:
      label366:
      for (paramInt = Wus;; paramInt = 2147483647)
      {
        this.Wut = paramInt;
        paramContext = new c.a();
        paramContext.prefixPath = com.tencent.mm.ao.a.e.fU(this.syN);
        paramContext.lRD = true;
        paramContext.kOl = true;
        paramContext.lRP = R.k.default_avatar;
        this.lRp = paramContext.bmL();
        if (this.Wuw) {
          this.WuB = getSortEntityList();
        }
        if (this.Wuu) {
          bh.aGY().a(1364, this);
        }
        AppMethodBeat.o(273054);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label204;
      }
    }
    
    private static boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
    {
      AppMethodBeat.i(273058);
      if ((!Util.isNullOrNil(paramString)) && (paramd != null))
      {
        Object localObject = (qp)paramd.bnW;
        if (localObject == null)
        {
          AppMethodBeat.o(273058);
          return false;
        }
        paramd = ((qp)localObject).contact.ays();
        String str = ((qp)localObject).contact.aph();
        localObject = ((qp)localObject).contact.api();
        paramString = paramString.toUpperCase();
        if (((!Util.isNullOrNil(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!Util.isNullOrNil(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!Util.isNullOrNil((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString))))
        {
          AppMethodBeat.o(273058);
          return true;
        }
      }
      AppMethodBeat.o(273058);
      return false;
    }
    
    private static SpannableString b(Context paramContext, Spannable paramSpannable, int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(33998);
      paramContext = com.tencent.mm.pluginsdk.ui.span.l.d(paramContext, paramSpannable, paramInt);
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
      AppMethodBeat.i(273064);
      ArrayList localArrayList = new ArrayList();
      af.bjv();
      Cursor localCursor = com.tencent.mm.ao.f.Q(this.Wum, true);
      while (localCursor.moveToNext())
      {
        qp localqp = new qp();
        Object localObject;
        if (localCursor != null)
        {
          localObject = new as();
          ((as)localObject).convertFrom(localCursor);
          com.tencent.mm.api.c localc = new com.tencent.mm.api.c();
          localc.convertFrom(localCursor);
          localqp.userName = ((ax)localObject).field_username;
          localqp.contact = ((as)localObject);
          localqp.GXj = localc;
        }
        if (localqp.contact != null)
        {
          localObject = new com.tencent.mm.ui.base.sortview.d();
          ((com.tencent.mm.ui.base.sortview.d)localObject).bnW = localqp;
          if (localqp.GXj.YZ()) {
            ((com.tencent.mm.ui.base.sortview.d)localObject).Wtr = "!1";
          }
          for (;;)
          {
            localArrayList.add(localObject);
            break;
            if (localqp.contact.ayn())
            {
              ((com.tencent.mm.ui.base.sortview.d)localObject).Wtr = "!2";
            }
            else
            {
              int j = localqp.contact.axh();
              int i = j;
              if (j >= 97)
              {
                i = j;
                if (j <= 122) {
                  i = j - 32;
                }
              }
              if ((i >= 65) && (i <= 90)) {
                ((com.tencent.mm.ui.base.sortview.d)localObject).Wtr = ((char)i);
              } else {
                ((com.tencent.mm.ui.base.sortview.d)localObject).Wtr = "#";
              }
            }
          }
        }
      }
      localCursor.close();
      Collections.sort(localArrayList, new a((byte)0));
      AppMethodBeat.o(273064);
      return localArrayList;
    }
    
    private void gkD()
    {
      int k = 1;
      AppMethodBeat.i(34001);
      int i = this.Wuy.size();
      int n = this.Wuz.size();
      int m = this.WuA.size();
      boolean bool;
      label82:
      label105:
      int j;
      if (this.scene != 2)
      {
        if (this.Wuy.size() > this.Wut)
        {
          bool = true;
          this.WuL = bool;
        }
      }
      else
      {
        if (this.Wuz.size() <= this.Wut) {
          break label275;
        }
        bool = true;
        this.WuO = bool;
        if (this.WuA.size() <= this.Wut) {
          break label281;
        }
        bool = true;
        this.WuP = bool;
        if ((i <= 0) && (!this.WuM)) {
          break label310;
        }
        j = Math.min(i, this.Wut) + 1;
        if (!hLk()) {
          break label307;
        }
        if ((!this.WuM) && (!this.WuL)) {
          break label287;
        }
        i = 1;
        label156:
        j = i + j;
      }
      for (;;)
      {
        this.WuQ = j;
        i = j;
        if (n > 0)
        {
          j = Math.min(n, this.Wut) + (j + 1);
          if (!hLk()) {
            break label302;
          }
          if (!this.WuO) {
            break label292;
          }
          i = 1;
          label202:
          i += j;
        }
        for (;;)
        {
          this.WuR = i;
          j = i;
          if (m > 0)
          {
            m = i + 1 + Math.min(m, this.Wut);
            j = m;
            if (hLk()) {
              if (!this.WuP) {
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
            this.afI = j;
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
    
    private void hLj()
    {
      AppMethodBeat.i(33997);
      if (hLl())
      {
        this.WuM = false;
        this.WuS = true;
        hLo();
      }
      AppMethodBeat.o(33997);
    }
    
    private boolean hLk()
    {
      return this.scene == 1;
    }
    
    private boolean hLm()
    {
      return this.scene == 3;
    }
    
    private void hLn()
    {
      int k = 0;
      AppMethodBeat.i(34004);
      this.WuD.clear();
      this.WuG.clear();
      this.WuJ.clear();
      int i = 0;
      while (i < Math.min(this.Wut, this.Wuy.size()))
      {
        this.WuD.add(new BizChatSearchUI.g(BizChatSearchUI.g.WuX, this.Wuy.get(i)));
        i += 1;
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= Math.min(this.Wut, this.Wuz.size())) {
          break;
        }
        this.WuG.add(new BizChatSearchUI.g(BizChatSearchUI.g.WuY, this.Wuz.get(i)));
        i += 1;
      }
      while (j < Math.min(this.Wut, this.WuA.size()))
      {
        this.WuJ.add(new BizChatSearchUI.g(BizChatSearchUI.g.Wvc, this.WuA.get(j)));
        j += 1;
      }
      AppMethodBeat.o(34004);
    }
    
    final void Ga(boolean paramBoolean)
    {
      AppMethodBeat.i(34003);
      hLn();
      gkD();
      if (paramBoolean)
      {
        notifyDataSetChanged();
        hLo();
      }
      AppMethodBeat.o(34003);
    }
    
    public final BizChatSearchUI.g auS(int paramInt)
    {
      AppMethodBeat.i(33994);
      if (paramInt < this.WuQ)
      {
        if (paramInt == 0)
        {
          if (this.WuC == null) {
            this.WuC = new BizChatSearchUI.g(BizChatSearchUI.g.Wvb, Integer.valueOf(BizChatSearchUI.g.Wve));
          }
          localg = this.WuC;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.WuQ - 1) && (this.WuM) && (hLk()))
        {
          if (this.WuE == null) {
            this.WuE = new BizChatSearchUI.g();
          }
          this.WuE.viewType = BizChatSearchUI.g.Wva;
          this.WuE.bnW = Integer.valueOf(BizChatSearchUI.g.Wve);
          localg = this.WuE;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.WuQ - 1) && (this.WuL) && (hLk()))
        {
          if (this.WuE == null) {
            this.WuE = new BizChatSearchUI.g();
          }
          this.WuE.viewType = BizChatSearchUI.g.WuZ;
          this.WuE.bnW = Integer.valueOf(BizChatSearchUI.g.Wve);
          localg = this.WuE;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt -= 1;
        if ((paramInt >= 0) && (paramInt < this.WuD.size()))
        {
          localg = (BizChatSearchUI.g)this.WuD.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      else if (paramInt < this.WuR)
      {
        if (paramInt == this.WuQ)
        {
          if (this.WuF == null) {
            this.WuF = new BizChatSearchUI.g(BizChatSearchUI.g.Wvb, Integer.valueOf(BizChatSearchUI.g.Wvf));
          }
          localg = this.WuF;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.afI - 1) && (this.WuO) && (hLk()))
        {
          if (this.WuH == null) {
            this.WuH = new BizChatSearchUI.g(BizChatSearchUI.g.WuZ, Integer.valueOf(BizChatSearchUI.g.Wvf));
          }
          localg = this.WuH;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt = paramInt - this.WuQ - 1;
        if ((paramInt >= 0) && (paramInt < this.WuG.size()))
        {
          localg = (BizChatSearchUI.g)this.WuG.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      else
      {
        if (paramInt == this.WuR)
        {
          if (this.WuI == null) {
            this.WuI = new BizChatSearchUI.g(BizChatSearchUI.g.Wvb, Integer.valueOf(BizChatSearchUI.g.Wvg));
          }
          localg = this.WuI;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.afI - 1) && (this.WuP) && (hLk()))
        {
          if (this.WuK == null) {
            this.WuK = new BizChatSearchUI.g(BizChatSearchUI.g.WuZ, Integer.valueOf(BizChatSearchUI.g.Wvg));
          }
          localg = this.WuK;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt = paramInt - this.WuR - 1;
        if ((paramInt >= 0) && (paramInt < this.WuJ.size()))
        {
          localg = (BizChatSearchUI.g)this.WuJ.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      BizChatSearchUI.g localg = new BizChatSearchUI.g();
      AppMethodBeat.o(33994);
      return localg;
    }
    
    final void byP(String paramString)
    {
      AppMethodBeat.i(273056);
      this.WuA.clear();
      if ((!Util.isNullOrNil(paramString)) && (this.WuB != null))
      {
        Iterator localIterator = this.WuB.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.ui.base.sortview.d locald = (com.tencent.mm.ui.base.sortview.d)localIterator.next();
          if (a(paramString, locald)) {
            this.WuA.add(locald);
          }
        }
      }
      Ga(true);
      AppMethodBeat.o(273056);
    }
    
    final void byQ(final String paramString)
    {
      AppMethodBeat.i(34000);
      if (!this.Wuu)
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
          bh.aGY().a(localm, 0);
          AppMethodBeat.o(33991);
        }
      }, 200L);
      AppMethodBeat.o(34000);
    }
    
    final void clearData()
    {
      AppMethodBeat.i(34002);
      this.WuT = 0;
      this.Wuy.clear();
      this.Wux.clear();
      this.Wuz.clear();
      AppMethodBeat.o(34002);
    }
    
    final void dA(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(33999);
      paramString = af.bjy().bm(this.syN, paramString);
      clearData();
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        com.tencent.mm.ao.a.c localc = (com.tencent.mm.ao.a.c)paramString.next();
        bool = localc.bjM();
        if ((bool) && (this.Wuv))
        {
          this.Wuz.add(localc);
        }
        else if ((!bool) && (this.Wuu))
        {
          this.Wuy.add(localc);
          this.Wux.add(localc);
        }
      }
      if (this.Wuu) {
        if (this.Wuy.size() > this.Wut) {
          break label153;
        }
      }
      label153:
      for (boolean bool = true;; bool = false)
      {
        this.WuM = bool;
        Ga(paramBoolean);
        AppMethodBeat.o(33999);
        return;
      }
    }
    
    public final int getCount()
    {
      return this.afI;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(33993);
      BizChatSearchUI.g localg = auS(paramInt);
      if (localg != null)
      {
        paramInt = localg.viewType;
        AppMethodBeat.o(33993);
        return paramInt;
      }
      paramInt = BizChatSearchUI.g.WuW;
      AppMethodBeat.o(33993);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(33995);
      BizChatSearchUI.g localg = auS(paramInt);
      View localView;
      int i;
      BizChatSearchUI.f localf;
      Object localObject2;
      boolean bool1;
      String str;
      Object localObject1;
      if ((localg.viewType == BizChatSearchUI.g.WuX) || (localg.viewType == BizChatSearchUI.g.WuY) || (localg.viewType == BizChatSearchUI.g.Wvc))
      {
        localView = paramView;
        if (paramView == null)
        {
          localView = LayoutInflater.from(this.context).inflate(R.i.fts_contact_item, paramViewGroup, false);
          i = paramViewGroup.getPaddingLeft();
          int j = paramViewGroup.getPaddingRight();
          localView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(paramViewGroup.getWidth(), 1073741824), i + j, -1), View.MeasureSpec.makeMeasureSpec(-2, 1073741824));
          paramView = new BizChatSearchUI.f((byte)0);
          paramView.iZG = ((ImageView)localView.findViewById(R.h.avatar_iv));
          paramView.mNb = ((TextView)localView.findViewById(R.h.title_tv));
          paramView.mrM = ((TextView)localView.findViewById(R.h.desc_tv));
          paramView.contentView = localView.findViewById(R.h.search_item_content_layout);
          localView.setTag(paramView);
        }
        localf = (BizChatSearchUI.f)localView.getTag();
        paramViewGroup = "";
        localObject2 = "";
        bool1 = false;
        str = "";
        if ((localg.bnW instanceof com.tencent.mm.ao.a.c))
        {
          paramView = (com.tencent.mm.ao.a.c)localg.bnW;
          if (paramView == null) {
            break label1414;
          }
          if (!paramView.bjM())
          {
            localObject1 = af.bjz().gm(paramView.field_bizChatServId);
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
            paramViewGroup = com.tencent.mm.plugin.fts.a.f.b(paramViewGroup, this.jkc);
            paramViewGroup = b(this.context, paramViewGroup, b.c.BLU);
            label309:
            if (!bool1) {
              break label686;
            }
            localObject2 = this.context.getString(R.l.eto);
            localObject1 = com.tencent.mm.plugin.fts.a.f.b((CharSequence)localObject1, this.jkc);
          }
          label686:
          for (localObject1 = TextUtils.concat(new CharSequence[] { localObject2, b(this.context, (Spannable)localObject1, b.c.BLU) });; localObject1 = "")
          {
            boolean bool2 = true;
            bool1 = bool2;
            if (localg.viewType == BizChatSearchUI.g.WuX)
            {
              bool1 = bool2;
              if (paramInt == this.WuQ - 1)
              {
                bool1 = bool2;
                if (this.WuQ != this.afI) {
                  bool1 = false;
                }
              }
            }
            n.r(localf.contentView, bool1);
            com.tencent.mm.ay.q.bml().a(paramView, localf.iZG, this.lRp);
            n.a(paramViewGroup, localf.mNb);
            n.a((CharSequence)localObject1, localf.mrM);
            AppMethodBeat.o(33995);
            return localView;
            paramViewGroup = paramView.field_chatName;
            paramView = paramView.field_headImageUrl;
            break;
            if ((localg.bnW instanceof nn))
            {
              localObject1 = (nn)localg.bnW;
              paramView = ((nn)localObject1).RUs;
              paramViewGroup = paramView.tsk;
              paramView = paramView.RUj;
              bool1 = "userid".equals(((nn)localObject1).RUt);
              if (!bool1) {}
              for (i = 1;; i = 0)
              {
                localObject1 = ((nn)localObject1).RUu;
                break;
              }
            }
            if (!(localg.bnW instanceof com.tencent.mm.ui.base.sortview.d)) {
              break label1396;
            }
            qp localqp = (qp)((com.tencent.mm.ui.base.sortview.d)localg.bnW).bnW;
            localObject1 = localObject2;
            paramView = paramViewGroup;
            if (localqp != null)
            {
              if (localqp.contact != null) {
                paramViewGroup = localqp.contact.ays();
              }
              localObject1 = localObject2;
              paramView = paramViewGroup;
              if (localqp.GXj != null)
              {
                localObject1 = localqp.GXj.field_brandIconURL;
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
            paramViewGroup = b(this.context, new SpannableString(paramViewGroup), b.c.BLU);
            break label309;
          }
          if (localg.viewType == BizChatSearchUI.g.Wvb)
          {
            localObject1 = paramView;
            if (paramView == null)
            {
              localObject1 = LayoutInflater.from(this.context).inflate(R.i.ebZ, paramViewGroup, false);
              paramView = new BizChatSearchUI.b((byte)0);
              paramView.tOY = ((TextView)((View)localObject1).findViewById(R.h.tip_tv));
              paramView.BOI = ((View)localObject1).findViewById(R.h.padding_view);
              paramView.contentView = ((View)localObject1).findViewById(R.h.search_item_content_layout);
              ((View)localObject1).setTag(paramView);
            }
            paramViewGroup = (BizChatSearchUI.b)((View)localObject1).getTag();
            if (((Integer)localg.bnW).intValue() == BizChatSearchUI.g.Wve) {
              paramView = this.context.getResources().getString(R.l.etm);
            }
          }
          for (;;)
          {
            n.a(paramView, paramViewGroup.tOY);
            if (paramInt == 0) {
              paramViewGroup.BOI.setVisibility(8);
            }
            for (;;)
            {
              paramViewGroup.contentView.setBackgroundResource(R.g.list_thicklinecell_bg);
              AppMethodBeat.o(33995);
              return localObject1;
              if (((Integer)localg.bnW).intValue() == BizChatSearchUI.g.Wvf)
              {
                paramView = this.context.getResources().getString(R.l.ete);
                break;
              }
              if (((Integer)localg.bnW).intValue() != BizChatSearchUI.g.Wvg) {
                break label1389;
              }
              paramView = this.context.getResources().getString(R.l.etd);
              break;
              paramViewGroup.BOI.setVisibility(0);
            }
            if (localg.viewType == BizChatSearchUI.g.WuZ)
            {
              localObject1 = paramView;
              if (paramView == null)
              {
                localObject1 = LayoutInflater.from(this.context).inflate(R.i.eca, paramViewGroup, false);
                paramView = new BizChatSearchUI.e((byte)0);
                paramView.yZg = ((TextView)((View)localObject1).findViewById(R.h.tip_tv));
                paramView.qps = ((ImageView)((View)localObject1).findViewById(R.h.icon_iv));
                paramView.contentView = ((View)localObject1).findViewById(R.h.search_item_content_layout);
                ((View)localObject1).setTag(paramView);
              }
              paramViewGroup = (BizChatSearchUI.e)((View)localObject1).getTag();
              paramView = "";
              if (((Integer)localg.bnW).intValue() == BizChatSearchUI.g.Wve)
              {
                paramView = this.context.getResources().getString(R.l.etl);
                if ((((Integer)localg.bnW).intValue() != BizChatSearchUI.g.Wve) || (this.WuQ == this.afI)) {
                  break label1383;
                }
              }
            }
            label1377:
            label1383:
            for (bool1 = false;; bool1 = true)
            {
              n.r(paramViewGroup.contentView, bool1);
              paramViewGroup.yZg.setText(paramView);
              paramViewGroup.qps.setImageResource(R.k.fts_more_button_icon);
              AppMethodBeat.o(33995);
              return localObject1;
              if (((Integer)localg.bnW).intValue() == BizChatSearchUI.g.Wvf)
              {
                paramView = this.context.getResources().getString(R.l.etk);
                break;
              }
              if (((Integer)localg.bnW).intValue() != BizChatSearchUI.g.Wvg) {
                break;
              }
              paramView = this.context.getResources().getString(R.l.etj);
              break;
              if (localg.viewType == BizChatSearchUI.g.Wva)
              {
                localObject1 = paramView;
                if (paramView == null)
                {
                  localObject1 = LayoutInflater.from(this.context).inflate(R.i.ehr, paramViewGroup, false);
                  paramView = new BizChatSearchUI.d((byte)0);
                  paramView.yZg = ((TextView)((View)localObject1).findViewById(R.h.tip_tv));
                  paramView.contentView = ((View)localObject1).findViewById(R.h.search_item_content_layout);
                  ((View)localObject1).setTag(paramView);
                }
                paramView = (BizChatSearchUI.d)((View)localObject1).getTag();
                if ((((Integer)localg.bnW).intValue() != BizChatSearchUI.g.Wve) || (this.WuQ == this.afI)) {
                  break label1377;
                }
              }
              for (bool1 = false;; bool1 = true)
              {
                n.r(paramView.contentView, bool1);
                paramView.yZg.setText(this.context.getResources().getString(R.l.etg));
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
      return BizChatSearchUI.g.Wvd;
    }
    
    final boolean hLl()
    {
      return this.scene == 2;
    }
    
    final void hLo()
    {
      AppMethodBeat.i(34005);
      ((BizChatSearchUI)this.context).a(this);
      AppMethodBeat.o(34005);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(33996);
      Object localObject1;
      Object localObject2;
      if ((this.Wuu) && (paramq.getType() == 1364) && ((paramq instanceof m)))
      {
        this.WuN = false;
        localObject1 = (m)paramq;
        if ((((m)localObject1).rr != null) && (d.b.b(((m)localObject1).rr.lBR) != null)) {}
        for (paramString = (no)d.b.b(((m)localObject1).rr.lBR);; paramString = null)
        {
          paramq = paramString.fwe;
          localObject2 = paramString.RUp;
          if ((paramq.equals(this.jkc)) && (((String)localObject2).equals(this.syN)) && (this.WuT == paramString.offset)) {
            break;
          }
          AppMethodBeat.o(33996);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          hLj();
          AppMethodBeat.o(33996);
          return;
        }
        if ((((m)localObject1).rr != null) && (d.c.b(((m)localObject1).rr.lBS) != null)) {}
        for (paramString = (np)d.c.b(((m)localObject1).rr.lBS); (paramString == null) || (paramString.RUv == null) || (paramString.RUv.ret != 0); paramString = null)
        {
          hLj();
          AppMethodBeat.o(33996);
          return;
        }
        localObject1 = paramString.RUw;
        boolean bool = paramString.RUx;
        if (paramq.equals(this.jkc))
        {
          this.WuM = false;
          this.WuT += ((List)localObject1).size();
          if (hLk())
          {
            if (this.Wuy.size() < this.Wux.size())
            {
              dA(paramq, true);
              AppMethodBeat.o(33996);
              return;
            }
            if (this.Wuy.size() > this.Wux.size()) {}
          }
          else
          {
            if (hLl()) {
              this.WuL = bool;
            }
            if (hLm()) {
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
          paramq = (nn)paramString.next();
          localObject1 = paramq.RUs;
          if (!Util.isNullOrNil(((nq)localObject1).RUq))
          {
            localObject2 = this.Wux.iterator();
            com.tencent.mm.ao.a.c localc;
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localc = (com.tencent.mm.ao.a.c)((Iterator)localObject2).next();
            } while (!((nq)localObject1).RUq.equals(localc.field_bizChatServId));
          }
        }
        else
        {
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              break label480;
            }
            this.Wuy.add(paramq);
            break;
            Ga(true);
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
    public View BOI;
    public View contentView;
    public TextView tOY;
  }
  
  static final class c
  {
    View sxC;
    View sxD;
    View sxE;
    
    private void K(boolean paramBoolean1, boolean paramBoolean2)
    {
      int j = 0;
      AppMethodBeat.i(34011);
      View localView = this.sxC;
      if (paramBoolean1)
      {
        i = 0;
        localView.setVisibility(i);
        this.sxD.setVisibility(8);
        localView = this.sxE;
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
        K(false, false);
        AppMethodBeat.o(34010);
        return;
      case 1: 
        K(true, false);
        AppMethodBeat.o(34010);
        return;
      }
      K(false, true);
      AppMethodBeat.o(34010);
    }
  }
  
  static final class d
  {
    public View contentView;
    public TextView yZg;
  }
  
  static final class e
  {
    public View contentView;
    public ImageView qps;
    public TextView yZg;
  }
  
  static final class f
  {
    public View contentView;
    public ImageView iZG;
    public TextView mNb;
    public TextView mrM;
  }
  
  static final class g
  {
    public static int WuW = 0;
    public static int WuX = 1;
    public static int WuY = 2;
    public static int WuZ = 3;
    public static int Wva = 4;
    public static int Wvb = 5;
    public static int Wvc = 6;
    public static int Wvd = 7;
    public static int Wve = 1;
    public static int Wvf = 2;
    public static int Wvg = 3;
    public Object bnW;
    public int viewType;
    
    public g()
    {
      this.viewType = WuW;
      this.bnW = null;
    }
    
    public g(int paramInt, Object paramObject)
    {
      this.viewType = paramInt;
      this.bnW = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchUI
 * JD-Core Version:    0.7.0.1
 */