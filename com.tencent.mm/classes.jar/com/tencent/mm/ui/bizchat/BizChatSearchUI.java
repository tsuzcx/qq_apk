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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.a.j;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.af;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.protocal.protobuf.mo;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.protocal.protobuf.mr;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
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
  String HHn;
  private String HHo;
  private c HHp;
  private BizChatSearchListView HHq;
  private a HHr;
  private TextView fwT;
  com.tencent.mm.modelvoiceaddr.ui.b nwH;
  String nxJ;
  private int scene;
  private AbsListView.OnScrollListener tnp;
  
  public BizChatSearchUI()
  {
    AppMethodBeat.i(34012);
    this.tnp = new AbsListView.OnScrollListener()
    {
      boolean nww = false;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
        {
          this.nww = true;
          return;
        }
        this.nww = false;
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33989);
        if ((paramAnonymousInt == 0) && (this.nww) && (BizChatSearchUI.a(BizChatSearchUI.this).HHM))
        {
          paramAnonymousAbsListView = BizChatSearchUI.a(BizChatSearchUI.this);
          if ((paramAnonymousAbsListView.fjF()) && (!paramAnonymousAbsListView.HHO))
          {
            paramAnonymousAbsListView.HHO = true;
            com.tencent.mm.al.a.m localm = new com.tencent.mm.al.a.m(paramAnonymousAbsListView.nxJ, paramAnonymousAbsListView.fzx, paramAnonymousAbsListView.HHU);
            az.agi().a(localm, 0);
            paramAnonymousAbsListView.fjJ();
          }
        }
        AppMethodBeat.o(33989);
      }
    };
    AppMethodBeat.o(34012);
  }
  
  private void aap(int paramInt)
  {
    AppMethodBeat.i(34025);
    if (this.HHp != null) {
      this.HHp.updateStatus(paramInt);
    }
    AppMethodBeat.o(34025);
  }
  
  public final boolean Ga(String paramString)
  {
    AppMethodBeat.i(34018);
    hideVKB();
    AppMethodBeat.o(34018);
    return true;
  }
  
  public final void Gb(String paramString)
  {
    a locala = null;
    AppMethodBeat.i(34017);
    if ((bs.isNullOrNil(paramString)) && (this.HHo != null))
    {
      paramString = this.HHo;
      this.HHo = null;
      if (!paramString.equals("")) {
        this.nwH.setSearchContent(paramString);
      }
      com.tencent.mm.modelvoiceaddr.ui.b localb = this.nwH;
      if (a.c(this.HHr)) {
        paramString = getContext().getResources().getString(2131756682);
      }
      for (;;)
      {
        localb.setHint(paramString);
        this.nwH.clearFocus();
        AppMethodBeat.o(34017);
        return;
        if (a.b(this.HHr))
        {
          paramString = getContext().getResources().getString(2131756686);
        }
        else
        {
          paramString = locala;
          if (a.e(this.HHr)) {
            paramString = getContext().getResources().getString(2131756679);
          }
        }
      }
    }
    locala = this.HHr;
    locala.fzx = paramString;
    if (bs.isNullOrNil(paramString))
    {
      locala.clearData();
      locala.HHN = false;
      locala.HHT = false;
      locala.wZ(true);
      AppMethodBeat.o(34017);
      return;
    }
    if (locala.scene == 4) {}
    for (int i = 1; i != 0; i = 0)
    {
      locala.clearData();
      locala.HHN = false;
      locala.HHT = false;
      locala.aPV(paramString);
      AppMethodBeat.o(34017);
      return;
    }
    if (locala.fjF())
    {
      locala.HHN = true;
      locala.HHT = false;
      locala.fjJ();
      locala.cL(paramString, false);
      locala.aPW(paramString);
      AppMethodBeat.o(34017);
      return;
    }
    locala.cL(paramString, true);
    if ((locala.HHv) && (locala.HHN)) {
      locala.aPW(paramString);
    }
    if (locala.HHx) {
      locala.aPV(paramString);
    }
    AppMethodBeat.o(34017);
  }
  
  final void a(com.tencent.mm.api.c paramc, int paramInt)
  {
    AppMethodBeat.i(196389);
    com.tencent.mm.al.c localc = af.aDf().Az(this.HHn);
    long l1;
    if (localc != null)
    {
      l1 = localc.field_wwCorpId;
      if (localc == null) {
        break label171;
      }
    }
    label171:
    for (long l2 = localc.field_wwUserVid;; l2 = 0L)
    {
      long l3 = paramc.IS();
      h.wUl.f(14507, new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(paramInt) });
      ac.d("MicroMsg.BizChatSearchUI", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(paramInt) });
      AppMethodBeat.o(196389);
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
      if (bs.isNullOrNil(a.d(parama)))
      {
        this.fwT.setVisibility(8);
        this.HHq.setVisibility(8);
        AppMethodBeat.o(34015);
        return;
      }
      if (parama.getCount() <= 0)
      {
        this.fwT.setVisibility(0);
        this.HHq.setVisibility(8);
        AppMethodBeat.o(34015);
        return;
      }
      this.fwT.setVisibility(8);
      this.HHq.setVisibility(0);
      AppMethodBeat.o(34015);
      return;
    }
    if (bs.isNullOrNil(a.d(parama)))
    {
      this.fwT.setVisibility(0);
      this.fwT.setText("");
      this.HHq.setVisibility(8);
    }
    while (a.b(parama)) {
      if (parama.HHO)
      {
        aap(1);
        AppMethodBeat.o(34015);
        return;
        if ((a.b(parama)) && (parama.HHN))
        {
          this.fwT.setVisibility(0);
          this.fwT.setText(2131756680);
          this.HHq.setVisibility(8);
        }
        else if ((a.b(parama)) && (parama.HHT))
        {
          this.fwT.setVisibility(0);
          this.fwT.setText(2131756681);
          this.HHq.setVisibility(8);
        }
        else if (parama.getCount() <= 0)
        {
          this.fwT.setVisibility(0);
          this.fwT.setText(com.tencent.mm.plugin.fts.a.f.a(getString(2131762920), getString(2131762919), com.tencent.mm.plugin.fts.a.a.e.c(a.d(parama), a.d(parama))).syd);
          this.HHq.setVisibility(8);
        }
        else
        {
          this.fwT.setVisibility(8);
          this.HHq.setVisibility(0);
        }
      }
      else
      {
        if (parama.HHM)
        {
          aap(2);
          AppMethodBeat.o(34015);
          return;
        }
        aap(0);
      }
    }
    AppMethodBeat.o(34015);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final void aKY()
  {
    AppMethodBeat.i(34019);
    hideVKB();
    AppMethodBeat.o(34019);
  }
  
  public final void aPa()
  {
    AppMethodBeat.i(34016);
    finish();
    AppMethodBeat.o(34016);
  }
  
  public final void aPb() {}
  
  public final void aPc() {}
  
  public final void aPd() {}
  
  public final boolean bJC()
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
    if (bs.isNullOrNil(this.nxJ))
    {
      this.nxJ = getIntent().getStringExtra("enterprise_biz_name");
      this.HHn = getIntent().getStringExtra("enterprise_biz_father_name");
      this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
      this.HHo = getIntent().getStringExtra("biz_chat_search_text");
      if (bs.isNullOrNil(this.nxJ)) {
        finish();
      }
    }
    this.HHq = ((BizChatSearchListView)findViewById(2131297412));
    this.fwT = ((TextView)findViewById(2131302884));
    this.HHr = new a(getContext(), this.nxJ, this.HHn, this.scene);
    if (a.b(this.HHr))
    {
      this.HHp = new c((byte)0);
      BizChatSearchListView localBizChatSearchListView = this.HHq;
      c localc = this.HHp;
      View localView = View.inflate(getContext(), 2131494592, null);
      localc.nwy = localView.findViewById(2131301508);
      localc.nwz = localView.findViewById(2131301499);
      localc.nwA = localView.findViewById(2131301510);
      localc.nwy.setVisibility(8);
      localc.nwz.setVisibility(8);
      localc.nwA.setVisibility(8);
      localBizChatSearchListView.addFooterView(localView);
      aap(0);
    }
    this.HHq.setAdapter(this.HHr);
    this.HHq.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33990);
        paramAnonymousAdapterView = BizChatSearchUI.a(BizChatSearchUI.this).aaq(paramAnonymousInt);
        BizChatSearchUI localBizChatSearchUI = BizChatSearchUI.this;
        Object localObject;
        boolean bool1;
        if ((paramAnonymousAdapterView.oeH == BizChatSearchUI.g.HHY) || (paramAnonymousAdapterView.oeH == BizChatSearchUI.g.HHZ))
        {
          paramAnonymousLong = -1L;
          if ((paramAnonymousAdapterView.data instanceof com.tencent.mm.al.a.c))
          {
            paramAnonymousAdapterView = (com.tencent.mm.al.a.c)paramAnonymousAdapterView.data;
            if (paramAnonymousAdapterView != null) {
              paramAnonymousLong = paramAnonymousAdapterView.field_bizChatLocalId;
            }
          }
          while ((bs.isNullOrNil(localBizChatSearchUI.nxJ)) || (paramAnonymousLong < 0L))
          {
            AppMethodBeat.o(33990);
            return;
            if ((paramAnonymousAdapterView.data instanceof mo))
            {
              paramAnonymousView = ((mo)paramAnonymousAdapterView.data).Ebv;
              localObject = localBizChatSearchUI.nxJ;
              bool1 = true;
              paramAnonymousAdapterView = new com.tencent.mm.al.a.k();
              paramAnonymousAdapterView.field_userId = paramAnonymousView.Ebt;
              paramAnonymousAdapterView.field_userName = paramAnonymousView.nYC;
              paramAnonymousAdapterView.field_brandUserName = ((String)localObject);
              paramAnonymousAdapterView.field_headImageUrl = paramAnonymousView.Ebm;
              paramAnonymousAdapterView.field_profileUrl = paramAnonymousView.EbB;
              paramAnonymousAdapterView.field_UserVersion = paramAnonymousView.ver;
              paramAnonymousAdapterView.field_addMemberUrl = paramAnonymousView.Ebq;
              if (!af.aDa().b(paramAnonymousAdapterView)) {
                bool1 = af.aDa().a(paramAnonymousAdapterView);
              }
              if (!bool1)
              {
                paramAnonymousLong = -1L;
              }
              else
              {
                paramAnonymousView = new com.tencent.mm.al.a.c();
                paramAnonymousView.field_bizChatServId = paramAnonymousAdapterView.field_userId;
                paramAnonymousView.field_brandUserName = paramAnonymousAdapterView.field_brandUserName;
                paramAnonymousView.field_chatName = paramAnonymousAdapterView.field_userName;
                paramAnonymousView.field_chatType = j.hzN.hzQ;
                paramAnonymousAdapterView = com.tencent.mm.al.a.e.e(paramAnonymousView);
                if (paramAnonymousAdapterView == null)
                {
                  paramAnonymousLong = -1L;
                }
                else
                {
                  paramAnonymousView = af.aCZ().pT(paramAnonymousAdapterView.field_bizChatLocalId);
                  paramAnonymousView.field_bizChatId = paramAnonymousAdapterView.field_bizChatLocalId;
                  paramAnonymousView.field_unReadCount = 0;
                  if (bs.isNullOrNil(paramAnonymousView.field_brandUserName))
                  {
                    paramAnonymousView.field_brandUserName = paramAnonymousAdapterView.field_brandUserName;
                    paramAnonymousView.field_lastMsgTime = System.currentTimeMillis();
                    paramAnonymousView.field_flag = paramAnonymousView.field_lastMsgTime;
                  }
                  if (!af.aCZ().b(paramAnonymousView)) {
                    af.aCZ().a(paramAnonymousView);
                  }
                  paramAnonymousLong = paramAnonymousAdapterView.field_bizChatLocalId;
                }
              }
            }
          }
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("Chat_User", localBizChatSearchUI.nxJ);
          paramAnonymousAdapterView.putExtra("key_biz_chat_id", paramAnonymousLong);
          paramAnonymousAdapterView.putExtra("finish_direct", true);
          paramAnonymousAdapterView.putExtra("key_need_send_video", false);
          paramAnonymousAdapterView.putExtra("key_is_biz_chat", true);
          com.tencent.mm.br.d.e(localBizChatSearchUI.getContext(), ".ui.chatting.ChattingUI", paramAnonymousAdapterView);
          AppMethodBeat.o(33990);
          return;
        }
        if (paramAnonymousAdapterView.oeH == BizChatSearchUI.g.HId) {}
        for (;;)
        {
          com.tencent.mm.api.c localc;
          try
          {
            localObject = (oo)((com.tencent.mm.ui.base.sortview.d)paramAnonymousAdapterView.data).data;
            if (localObject == null)
            {
              AppMethodBeat.o(33990);
              return;
            }
            bool1 = com.tencent.mm.al.f.AS(((oo)localObject).userName);
            boolean bool2 = com.tencent.mm.al.f.so(((oo)localObject).userName);
            localc = com.tencent.mm.al.f.dX(((oo)localObject).userName);
            if (localc == null)
            {
              paramAnonymousAdapterView = null;
              break label1224;
              if (bool1)
              {
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("rawUrl", paramAnonymousView);
                paramAnonymousAdapterView.putExtra("useJs", true);
                paramAnonymousAdapterView.putExtra("srcUsername", ((oo)localObject).userName);
                paramAnonymousAdapterView.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                paramAnonymousAdapterView.addFlags(67108864);
                com.tencent.mm.br.d.b(localBizChatSearchUI.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousAdapterView);
                localBizChatSearchUI.a(localc, 2);
                AppMethodBeat.o(33990);
              }
            }
            else
            {
              paramAnonymousAdapterView = localc.IR();
              break label1224;
            }
            if (bool2)
            {
              paramAnonymousAdapterView = new Intent();
              paramAnonymousAdapterView.putExtra("Contact_User", ((oo)localObject).userName);
              paramAnonymousAdapterView.addFlags(67108864);
              paramAnonymousAdapterView.putExtra("biz_chat_from_scene", 3);
              com.tencent.mm.br.d.e(localBizChatSearchUI.getContext(), ".ui.bizchat.BizChatConversationUI", paramAnonymousAdapterView);
              AppMethodBeat.o(33990);
              return;
            }
          }
          catch (Throwable paramAnonymousAdapterView)
          {
            AppMethodBeat.o(33990);
            return;
          }
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.addFlags(67108864);
          paramAnonymousAdapterView.putExtra("finish_direct", true);
          paramAnonymousAdapterView.putExtra("Chat_User", ((oo)localObject).userName);
          paramAnonymousAdapterView.putExtra("chat_from_scene", 2);
          com.tencent.mm.plugin.brandservice.b.d(paramAnonymousAdapterView, localBizChatSearchUI.getContext());
          localBizChatSearchUI.a(localc, 1);
          AppMethodBeat.o(33990);
          return;
          if (paramAnonymousAdapterView.oeH == BizChatSearchUI.g.HIa)
          {
            if (((Integer)paramAnonymousAdapterView.data).intValue() == BizChatSearchUI.g.HIf)
            {
              paramAnonymousAdapterView = new Intent(localBizChatSearchUI.getContext(), BizChatSearchUI.class);
              paramAnonymousAdapterView.putExtra("enterprise_biz_name", localBizChatSearchUI.nxJ);
              paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 2);
              paramAnonymousAdapterView.putExtra("biz_chat_search_text", localBizChatSearchUI.nwH.getSearchContent());
              paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.a(localBizChatSearchUI, paramAnonymousAdapterView.aeD(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localBizChatSearchUI.startActivity((Intent)paramAnonymousAdapterView.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(localBizChatSearchUI, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(33990);
              return;
            }
            if (((Integer)paramAnonymousAdapterView.data).intValue() == BizChatSearchUI.g.HIg)
            {
              paramAnonymousAdapterView = new Intent(localBizChatSearchUI.getContext(), BizChatSearchUI.class);
              paramAnonymousAdapterView.putExtra("enterprise_biz_name", localBizChatSearchUI.nxJ);
              paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 3);
              paramAnonymousAdapterView.putExtra("biz_chat_search_text", localBizChatSearchUI.nwH.getSearchContent());
              paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.a(localBizChatSearchUI, paramAnonymousAdapterView.aeD(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreGroupUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localBizChatSearchUI.startActivity((Intent)paramAnonymousAdapterView.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(localBizChatSearchUI, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreGroupUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(33990);
              return;
            }
            if (((Integer)paramAnonymousAdapterView.data).intValue() == BizChatSearchUI.g.HIh)
            {
              paramAnonymousAdapterView = new Intent(localBizChatSearchUI.getContext(), BizChatSearchUI.class);
              paramAnonymousAdapterView.putExtra("enterprise_biz_name", localBizChatSearchUI.nxJ);
              paramAnonymousAdapterView.putExtra("enterprise_biz_father_name", localBizChatSearchUI.HHn);
              paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 4);
              paramAnonymousAdapterView.putExtra("biz_chat_search_text", localBizChatSearchUI.nwH.getSearchContent());
              paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.a(localBizChatSearchUI, paramAnonymousAdapterView.aeD(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreAppUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localBizChatSearchUI.startActivity((Intent)paramAnonymousAdapterView.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(localBizChatSearchUI, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreAppUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
          AppMethodBeat.o(33990);
          return;
          label1224:
          paramAnonymousView = paramAnonymousAdapterView;
          if (paramAnonymousAdapterView == null) {
            paramAnonymousView = "";
          }
        }
      }
    });
    this.HHq.setOnTouchListener(this);
    if (a.b(this.HHr)) {
      this.HHq.setOnScrollListener(this.tnp);
    }
    this.nwH = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.nwH.xO(a.c(this.HHr));
    this.nwH.a(this);
    this.nwH.igd = false;
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
    this.nwH.a(this, paramMenu);
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
    this.nwH.cancel();
    this.nwH.clearFocus();
    AppMethodBeat.o(34020);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(34023);
    this.nwH.a(this, paramMenu);
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
    implements g
  {
    public static int HHt = 3;
    private ArrayList<com.tencent.mm.al.a.c> HHA;
    private ArrayList<com.tencent.mm.ui.base.sortview.d> HHB;
    private List<com.tencent.mm.ui.base.sortview.d> HHC;
    private BizChatSearchUI.g HHD;
    private ArrayList<BizChatSearchUI.g> HHE;
    private BizChatSearchUI.g HHF;
    private BizChatSearchUI.g HHG;
    private ArrayList<BizChatSearchUI.g> HHH;
    private BizChatSearchUI.g HHI;
    private BizChatSearchUI.g HHJ;
    private ArrayList<BizChatSearchUI.g> HHK;
    private BizChatSearchUI.g HHL;
    public boolean HHM;
    public boolean HHN;
    public boolean HHO;
    private boolean HHP;
    private boolean HHQ;
    private int HHR;
    private int HHS;
    public boolean HHT;
    int HHU;
    private String HHn;
    private int HHu;
    boolean HHv;
    boolean HHw;
    boolean HHx;
    private ArrayList<com.tencent.mm.al.a.c> HHy;
    private ArrayList<Object> HHz;
    private int ahX;
    private Context context;
    String fzx;
    private com.tencent.mm.av.a.a.c hKj;
    String nxJ;
    int scene;
    
    public a(Context paramContext, String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(196385);
      this.HHy = new ArrayList();
      this.HHz = new ArrayList();
      this.HHA = new ArrayList();
      this.HHB = new ArrayList();
      this.HHE = new ArrayList();
      this.HHH = new ArrayList();
      this.HHK = new ArrayList();
      this.HHM = true;
      this.HHN = false;
      this.HHO = false;
      this.HHP = true;
      this.HHQ = true;
      this.HHR = 0;
      this.HHS = 0;
      this.ahX = 0;
      this.HHT = false;
      this.HHU = 0;
      this.context = paramContext;
      this.nxJ = paramString1;
      this.HHn = paramString2;
      this.scene = paramInt;
      boolean bool1;
      if ((this.scene == 1) || (this.scene == 2))
      {
        bool1 = true;
        this.HHv = bool1;
        if ((this.scene != 1) && (this.scene != 3)) {
          break label359;
        }
        bool1 = true;
        label204:
        this.HHw = bool1;
        bool1 = bool2;
        if (!bs.isNullOrNil(this.HHn)) {
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
        this.HHx = bool1;
        if (this.scene != 1) {
          break label365;
        }
      }
      label359:
      label365:
      for (paramInt = HHt;; paramInt = 2147483647)
      {
        this.HHu = paramInt;
        paramContext = new c.a();
        paramContext.prefixPath = com.tencent.mm.al.a.e.dw(this.nxJ);
        paramContext.hKx = true;
        paramContext.gKm = true;
        paramContext.hKI = 2131690013;
        this.hKj = paramContext.aFT();
        if (this.HHx) {
          this.HHC = getSortEntityList();
        }
        if (this.HHv) {
          az.agi().a(1364, this);
        }
        AppMethodBeat.o(196385);
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
      AppMethodBeat.i(196387);
      if ((!bs.isNullOrNil(paramString)) && (paramd != null))
      {
        Object localObject = (oo)paramd.data;
        if (localObject == null)
        {
          AppMethodBeat.o(196387);
          return false;
        }
        paramd = ((oo)localObject).contact.aaS();
        String str = ((oo)localObject).contact.To();
        localObject = ((oo)localObject).contact.Tp();
        paramString = paramString.toUpperCase();
        if (((!bs.isNullOrNil(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!bs.isNullOrNil(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!bs.isNullOrNil((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString))))
        {
          AppMethodBeat.o(196387);
          return true;
        }
      }
      AppMethodBeat.o(196387);
      return false;
    }
    
    private void fjD()
    {
      AppMethodBeat.i(33997);
      if (fjF())
      {
        this.HHN = false;
        this.HHT = true;
        fjJ();
      }
      AppMethodBeat.o(33997);
    }
    
    private boolean fjE()
    {
      return this.scene == 1;
    }
    
    private boolean fjG()
    {
      return this.scene == 3;
    }
    
    private void fjH()
    {
      int k = 1;
      AppMethodBeat.i(34001);
      int i = this.HHz.size();
      int n = this.HHA.size();
      int m = this.HHB.size();
      boolean bool;
      label82:
      label105:
      int j;
      if (this.scene != 2)
      {
        if (this.HHz.size() > this.HHu)
        {
          bool = true;
          this.HHM = bool;
        }
      }
      else
      {
        if (this.HHA.size() <= this.HHu) {
          break label275;
        }
        bool = true;
        this.HHP = bool;
        if (this.HHB.size() <= this.HHu) {
          break label281;
        }
        bool = true;
        this.HHQ = bool;
        if ((i <= 0) && (!this.HHN)) {
          break label310;
        }
        j = Math.min(i, this.HHu) + 1;
        if (!fjE()) {
          break label307;
        }
        if ((!this.HHN) && (!this.HHM)) {
          break label287;
        }
        i = 1;
        label156:
        j = i + j;
      }
      for (;;)
      {
        this.HHR = j;
        i = j;
        if (n > 0)
        {
          j = Math.min(n, this.HHu) + (j + 1);
          if (!fjE()) {
            break label302;
          }
          if (!this.HHP) {
            break label292;
          }
          i = 1;
          label202:
          i += j;
        }
        for (;;)
        {
          this.HHS = i;
          j = i;
          if (m > 0)
          {
            m = i + 1 + Math.min(m, this.HHu);
            j = m;
            if (fjE()) {
              if (!this.HHQ) {
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
            this.ahX = j;
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
    
    private void fjI()
    {
      int k = 0;
      AppMethodBeat.i(34004);
      this.HHE.clear();
      this.HHH.clear();
      this.HHK.clear();
      int i = 0;
      while (i < Math.min(this.HHu, this.HHz.size()))
      {
        this.HHE.add(new BizChatSearchUI.g(BizChatSearchUI.g.HHY, this.HHz.get(i)));
        i += 1;
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= Math.min(this.HHu, this.HHA.size())) {
          break;
        }
        this.HHH.add(new BizChatSearchUI.g(BizChatSearchUI.g.HHZ, this.HHA.get(i)));
        i += 1;
      }
      while (j < Math.min(this.HHu, this.HHB.size()))
      {
        this.HHK.add(new BizChatSearchUI.g(BizChatSearchUI.g.HId, this.HHB.get(j)));
        j += 1;
      }
      AppMethodBeat.o(34004);
    }
    
    private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList()
    {
      AppMethodBeat.i(196388);
      ArrayList localArrayList = new ArrayList();
      af.aCW();
      Cursor localCursor = com.tencent.mm.al.e.M(this.HHn, true);
      while (localCursor.moveToNext())
      {
        oo localoo = new oo();
        Object localObject;
        if (localCursor != null)
        {
          localObject = new ai();
          ((ai)localObject).convertFrom(localCursor);
          com.tencent.mm.api.c localc = new com.tencent.mm.api.c();
          localc.convertFrom(localCursor);
          localoo.userName = ((av)localObject).field_username;
          localoo.contact = ((ai)localObject);
          localoo.vIG = localc;
        }
        if (localoo.contact != null)
        {
          localObject = new com.tencent.mm.ui.base.sortview.d();
          ((com.tencent.mm.ui.base.sortview.d)localObject).data = localoo;
          if (localoo.vIG.IP()) {
            ((com.tencent.mm.ui.base.sortview.d)localObject).HGs = "!1";
          }
          for (;;)
          {
            localArrayList.add(localObject);
            break;
            if (localoo.contact.aaN())
            {
              ((com.tencent.mm.ui.base.sortview.d)localObject).HGs = "!2";
            }
            else
            {
              int j = localoo.contact.aac();
              int i = j;
              if (j >= 97)
              {
                i = j;
                if (j <= 122) {
                  i = j - 32;
                }
              }
              if ((i >= 65) && (i <= 90)) {
                ((com.tencent.mm.ui.base.sortview.d)localObject).HGs = ((char)i);
              } else {
                ((com.tencent.mm.ui.base.sortview.d)localObject).HGs = "#";
              }
            }
          }
        }
      }
      localCursor.close();
      Collections.sort(localArrayList, new a((byte)0));
      AppMethodBeat.o(196388);
      return localArrayList;
    }
    
    final void aPV(String paramString)
    {
      AppMethodBeat.i(196386);
      this.HHB.clear();
      if ((!bs.isNullOrNil(paramString)) && (this.HHC != null))
      {
        Iterator localIterator = this.HHC.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.ui.base.sortview.d locald = (com.tencent.mm.ui.base.sortview.d)localIterator.next();
          if (a(paramString, locald)) {
            this.HHB.add(locald);
          }
        }
      }
      wZ(true);
      AppMethodBeat.o(196386);
    }
    
    final void aPW(final String paramString)
    {
      AppMethodBeat.i(34000);
      if (!this.HHv)
      {
        AppMethodBeat.o(34000);
        return;
      }
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33991);
          if (!paramString.equals(BizChatSearchUI.a.d(BizChatSearchUI.a.this)))
          {
            AppMethodBeat.o(33991);
            return;
          }
          com.tencent.mm.al.a.m localm = new com.tencent.mm.al.a.m(BizChatSearchUI.a.f(BizChatSearchUI.a.this), paramString, 0);
          az.agi().a(localm, 0);
          AppMethodBeat.o(33991);
        }
      }, 200L);
      AppMethodBeat.o(34000);
    }
    
    public final BizChatSearchUI.g aaq(int paramInt)
    {
      AppMethodBeat.i(33994);
      if (paramInt < this.HHR)
      {
        if (paramInt == 0)
        {
          if (this.HHD == null) {
            this.HHD = new BizChatSearchUI.g(BizChatSearchUI.g.HIc, Integer.valueOf(BizChatSearchUI.g.HIf));
          }
          localg = this.HHD;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.HHR - 1) && (this.HHN) && (fjE()))
        {
          if (this.HHF == null) {
            this.HHF = new BizChatSearchUI.g();
          }
          this.HHF.oeH = BizChatSearchUI.g.HIb;
          this.HHF.data = Integer.valueOf(BizChatSearchUI.g.HIf);
          localg = this.HHF;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.HHR - 1) && (this.HHM) && (fjE()))
        {
          if (this.HHF == null) {
            this.HHF = new BizChatSearchUI.g();
          }
          this.HHF.oeH = BizChatSearchUI.g.HIa;
          this.HHF.data = Integer.valueOf(BizChatSearchUI.g.HIf);
          localg = this.HHF;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt -= 1;
        if ((paramInt >= 0) && (paramInt < this.HHE.size()))
        {
          localg = (BizChatSearchUI.g)this.HHE.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      else if (paramInt < this.HHS)
      {
        if (paramInt == this.HHR)
        {
          if (this.HHG == null) {
            this.HHG = new BizChatSearchUI.g(BizChatSearchUI.g.HIc, Integer.valueOf(BizChatSearchUI.g.HIg));
          }
          localg = this.HHG;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.ahX - 1) && (this.HHP) && (fjE()))
        {
          if (this.HHI == null) {
            this.HHI = new BizChatSearchUI.g(BizChatSearchUI.g.HIa, Integer.valueOf(BizChatSearchUI.g.HIg));
          }
          localg = this.HHI;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt = paramInt - this.HHR - 1;
        if ((paramInt >= 0) && (paramInt < this.HHH.size()))
        {
          localg = (BizChatSearchUI.g)this.HHH.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      else
      {
        if (paramInt == this.HHS)
        {
          if (this.HHJ == null) {
            this.HHJ = new BizChatSearchUI.g(BizChatSearchUI.g.HIc, Integer.valueOf(BizChatSearchUI.g.HIh));
          }
          localg = this.HHJ;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.ahX - 1) && (this.HHQ) && (fjE()))
        {
          if (this.HHL == null) {
            this.HHL = new BizChatSearchUI.g(BizChatSearchUI.g.HIa, Integer.valueOf(BizChatSearchUI.g.HIh));
          }
          localg = this.HHL;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt = paramInt - this.HHS - 1;
        if ((paramInt >= 0) && (paramInt < this.HHK.size()))
        {
          localg = (BizChatSearchUI.g)this.HHK.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      BizChatSearchUI.g localg = new BizChatSearchUI.g();
      AppMethodBeat.o(33994);
      return localg;
    }
    
    final void cL(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(33999);
      paramString = af.aCZ().bd(this.nxJ, paramString);
      clearData();
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        com.tencent.mm.al.a.c localc = (com.tencent.mm.al.a.c)paramString.next();
        bool = localc.isGroup();
        if ((bool) && (this.HHw))
        {
          this.HHA.add(localc);
        }
        else if ((!bool) && (this.HHv))
        {
          this.HHz.add(localc);
          this.HHy.add(localc);
        }
      }
      if (this.HHv) {
        if (this.HHz.size() > this.HHu) {
          break label153;
        }
      }
      label153:
      for (boolean bool = true;; bool = false)
      {
        this.HHN = bool;
        wZ(paramBoolean);
        AppMethodBeat.o(33999);
        return;
      }
    }
    
    final void clearData()
    {
      AppMethodBeat.i(34002);
      this.HHU = 0;
      this.HHz.clear();
      this.HHy.clear();
      this.HHA.clear();
      AppMethodBeat.o(34002);
    }
    
    final boolean fjF()
    {
      return this.scene == 2;
    }
    
    final void fjJ()
    {
      AppMethodBeat.i(34005);
      ((BizChatSearchUI)this.context).a(this);
      AppMethodBeat.o(34005);
    }
    
    public final int getCount()
    {
      return this.ahX;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(33993);
      BizChatSearchUI.g localg = aaq(paramInt);
      if (localg != null)
      {
        paramInt = localg.oeH;
        AppMethodBeat.o(33993);
        return paramInt;
      }
      paramInt = BizChatSearchUI.g.HHX;
      AppMethodBeat.o(33993);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(33995);
      BizChatSearchUI.g localg = aaq(paramInt);
      View localView;
      int i;
      BizChatSearchUI.f localf;
      Object localObject2;
      boolean bool1;
      String str;
      Object localObject1;
      if ((localg.oeH == BizChatSearchUI.g.HHY) || (localg.oeH == BizChatSearchUI.g.HHZ) || (localg.oeH == BizChatSearchUI.g.HId))
      {
        localView = paramView;
        if (paramView == null)
        {
          localView = LayoutInflater.from(this.context).inflate(2131494192, paramViewGroup, false);
          i = paramViewGroup.getPaddingLeft();
          int j = paramViewGroup.getPaddingRight();
          localView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(paramViewGroup.getWidth(), 1073741824), i + j, -1), View.MeasureSpec.makeMeasureSpec(-2, 1073741824));
          paramView = new BizChatSearchUI.f((byte)0);
          paramView.fuY = ((ImageView)localView.findViewById(2131297008));
          paramView.iCg = ((TextView)localView.findViewById(2131305948));
          paramView.ijE = ((TextView)localView.findViewById(2131299008));
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
            localObject1 = af.aDa().dP(paramView.field_bizChatServId);
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
            paramViewGroup = com.tencent.mm.plugin.fts.a.f.b(paramViewGroup, this.fzx);
            paramViewGroup = a(this.context, paramViewGroup, com.tencent.mm.plugin.fts.ui.b.c.sBE);
            label309:
            if (!bool1) {
              break label686;
            }
            localObject2 = this.context.getString(2131756687);
            localObject1 = com.tencent.mm.plugin.fts.a.f.b((CharSequence)localObject1, this.fzx);
          }
          label686:
          for (localObject1 = TextUtils.concat(new CharSequence[] { localObject2, a(this.context, (Spannable)localObject1, com.tencent.mm.plugin.fts.ui.b.c.sBE) });; localObject1 = "")
          {
            boolean bool2 = true;
            bool1 = bool2;
            if (localg.oeH == BizChatSearchUI.g.HHY)
            {
              bool1 = bool2;
              if (paramInt == this.HHR - 1)
              {
                bool1 = bool2;
                if (this.HHR != this.ahX) {
                  bool1 = false;
                }
              }
            }
            com.tencent.mm.plugin.fts.ui.m.q(localf.contentView, bool1);
            o.aFB().a(paramView, localf.fuY, this.hKj);
            com.tencent.mm.plugin.fts.ui.m.a(paramViewGroup, localf.iCg);
            com.tencent.mm.plugin.fts.ui.m.a((CharSequence)localObject1, localf.ijE);
            AppMethodBeat.o(33995);
            return localView;
            paramViewGroup = paramView.field_chatName;
            paramView = paramView.field_headImageUrl;
            break;
            if ((localg.data instanceof mo))
            {
              localObject1 = (mo)localg.data;
              paramView = ((mo)localObject1).Ebv;
              paramViewGroup = paramView.nYC;
              paramView = paramView.Ebm;
              bool1 = "userid".equals(((mo)localObject1).Ebw);
              if (!bool1) {}
              for (i = 1;; i = 0)
              {
                localObject1 = ((mo)localObject1).Ebx;
                break;
              }
            }
            if (!(localg.data instanceof com.tencent.mm.ui.base.sortview.d)) {
              break label1396;
            }
            oo localoo = (oo)((com.tencent.mm.ui.base.sortview.d)localg.data).data;
            localObject1 = localObject2;
            paramView = paramViewGroup;
            if (localoo != null)
            {
              if (localoo.contact != null) {
                paramViewGroup = localoo.contact.aaS();
              }
              localObject1 = localObject2;
              paramView = paramViewGroup;
              if (localoo.vIG != null)
              {
                localObject1 = localoo.vIG.field_brandIconURL;
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
            paramViewGroup = a(this.context, new SpannableString(paramViewGroup), com.tencent.mm.plugin.fts.ui.b.c.sBE);
            break label309;
          }
          if (localg.oeH == BizChatSearchUI.g.HIc)
          {
            localObject1 = paramView;
            if (paramView == null)
            {
              localObject1 = LayoutInflater.from(this.context).inflate(2131493192, paramViewGroup, false);
              paramView = new BizChatSearchUI.b((byte)0);
              paramView.ors = ((TextView)((View)localObject1).findViewById(2131305880));
              paramView.sEb = ((View)localObject1).findViewById(2131303131);
              paramView.contentView = ((View)localObject1).findViewById(2131304428);
              ((View)localObject1).setTag(paramView);
            }
            paramViewGroup = (BizChatSearchUI.b)((View)localObject1).getTag();
            if (((Integer)localg.data).intValue() == BizChatSearchUI.g.HIf) {
              paramView = this.context.getResources().getString(2131756685);
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.fts.ui.m.a(paramView, paramViewGroup.ors);
            if (paramInt == 0) {
              paramViewGroup.sEb.setVisibility(8);
            }
            for (;;)
            {
              paramViewGroup.contentView.setBackgroundResource(2131232878);
              AppMethodBeat.o(33995);
              return localObject1;
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.HIg)
              {
                paramView = this.context.getResources().getString(2131756678);
                break;
              }
              if (((Integer)localg.data).intValue() != BizChatSearchUI.g.HIh) {
                break label1389;
              }
              paramView = this.context.getResources().getString(2131760268);
              break;
              paramViewGroup.sEb.setVisibility(0);
            }
            if (localg.oeH == BizChatSearchUI.g.HIa)
            {
              localObject1 = paramView;
              if (paramView == null)
              {
                localObject1 = LayoutInflater.from(this.context).inflate(2131493193, paramViewGroup, false);
                paramView = new BizChatSearchUI.e((byte)0);
                paramView.sDL = ((TextView)((View)localObject1).findViewById(2131305880));
                paramView.lzC = ((ImageView)((View)localObject1).findViewById(2131300891));
                paramView.contentView = ((View)localObject1).findViewById(2131304428);
                ((View)localObject1).setTag(paramView);
              }
              paramViewGroup = (BizChatSearchUI.e)((View)localObject1).getTag();
              paramView = "";
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.HIf)
              {
                paramView = this.context.getResources().getString(2131756684);
                if ((((Integer)localg.data).intValue() != BizChatSearchUI.g.HIf) || (this.HHR == this.ahX)) {
                  break label1383;
                }
              }
            }
            label1377:
            label1383:
            for (bool1 = false;; bool1 = true)
            {
              com.tencent.mm.plugin.fts.ui.m.q(paramViewGroup.contentView, bool1);
              paramViewGroup.sDL.setText(paramView);
              paramViewGroup.lzC.setImageResource(2131690258);
              AppMethodBeat.o(33995);
              return localObject1;
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.HIg)
              {
                paramView = this.context.getResources().getString(2131756683);
                break;
              }
              if (((Integer)localg.data).intValue() != BizChatSearchUI.g.HIh) {
                break;
              }
              paramView = this.context.getResources().getString(2131760275);
              break;
              if (localg.oeH == BizChatSearchUI.g.HIb)
              {
                localObject1 = paramView;
                if (paramView == null)
                {
                  localObject1 = LayoutInflater.from(this.context).inflate(2131494207, paramViewGroup, false);
                  paramView = new BizChatSearchUI.d((byte)0);
                  paramView.sDL = ((TextView)((View)localObject1).findViewById(2131305880));
                  paramView.contentView = ((View)localObject1).findViewById(2131304428);
                  ((View)localObject1).setTag(paramView);
                }
                paramView = (BizChatSearchUI.d)((View)localObject1).getTag();
                if ((((Integer)localg.data).intValue() != BizChatSearchUI.g.HIf) || (this.HHR == this.ahX)) {
                  break label1377;
                }
              }
              for (bool1 = false;; bool1 = true)
              {
                com.tencent.mm.plugin.fts.ui.m.q(paramView.contentView, bool1);
                paramView.sDL.setText(this.context.getResources().getString(2131756680));
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
      return BizChatSearchUI.g.HIe;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(33996);
      Object localObject1;
      Object localObject2;
      if ((this.HHv) && (paramn.getType() == 1364) && ((paramn instanceof com.tencent.mm.al.a.m)))
      {
        this.HHO = false;
        localObject1 = (com.tencent.mm.al.a.m)paramn;
        if ((((com.tencent.mm.al.a.m)localObject1).rr != null) && (((com.tencent.mm.al.a.m)localObject1).rr.hvr.hvw != null)) {}
        for (paramString = (mp)((com.tencent.mm.al.a.m)localObject1).rr.hvr.hvw;; paramString = null)
        {
          paramn = paramString.cZL;
          localObject2 = paramString.Ebs;
          if ((paramn.equals(this.fzx)) && (((String)localObject2).equals(this.nxJ)) && (this.HHU == paramString.offset)) {
            break;
          }
          AppMethodBeat.o(33996);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          fjD();
          AppMethodBeat.o(33996);
          return;
        }
        if ((((com.tencent.mm.al.a.m)localObject1).rr != null) && (((com.tencent.mm.al.a.m)localObject1).rr.hvs.hvw != null)) {}
        for (paramString = (mq)((com.tencent.mm.al.a.m)localObject1).rr.hvs.hvw; (paramString == null) || (paramString.Eby == null) || (paramString.Eby.ret != 0); paramString = null)
        {
          fjD();
          AppMethodBeat.o(33996);
          return;
        }
        localObject1 = paramString.Ebz;
        boolean bool = paramString.EbA;
        if (paramn.equals(this.fzx))
        {
          this.HHN = false;
          this.HHU += ((List)localObject1).size();
          if (fjE())
          {
            if (this.HHz.size() < this.HHy.size())
            {
              cL(paramn, true);
              AppMethodBeat.o(33996);
              return;
            }
            if (this.HHz.size() > this.HHy.size()) {}
          }
          else
          {
            if (fjF()) {
              this.HHM = bool;
            }
            if (fjG()) {
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
          paramn = (mo)paramString.next();
          localObject1 = paramn.Ebv;
          if (!bs.isNullOrNil(((mr)localObject1).Ebt))
          {
            localObject2 = this.HHy.iterator();
            com.tencent.mm.al.a.c localc;
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localc = (com.tencent.mm.al.a.c)((Iterator)localObject2).next();
            } while (!((mr)localObject1).Ebt.equals(localc.field_bizChatServId));
          }
        }
        else
        {
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              break label480;
            }
            this.HHz.add(paramn);
            break;
            wZ(true);
            AppMethodBeat.o(33996);
            return;
          }
        }
      }
    }
    
    final void wZ(boolean paramBoolean)
    {
      AppMethodBeat.i(34003);
      fjI();
      fjH();
      if (paramBoolean)
      {
        notifyDataSetChanged();
        fjJ();
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
    public TextView ors;
    public View sEb;
  }
  
  static final class c
  {
    View nwA;
    View nwy;
    View nwz;
    
    private void G(boolean paramBoolean1, boolean paramBoolean2)
    {
      int j = 0;
      AppMethodBeat.i(34011);
      View localView = this.nwy;
      if (paramBoolean1)
      {
        i = 0;
        localView.setVisibility(i);
        this.nwz.setVisibility(8);
        localView = this.nwA;
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
    public TextView sDL;
  }
  
  static final class e
  {
    public View contentView;
    public ImageView lzC;
    public TextView sDL;
  }
  
  static final class f
  {
    public View contentView;
    public ImageView fuY;
    public TextView iCg;
    public TextView ijE;
  }
  
  static final class g
  {
    public static int HHX = 0;
    public static int HHY = 1;
    public static int HHZ = 2;
    public static int HIa = 3;
    public static int HIb = 4;
    public static int HIc = 5;
    public static int HId = 6;
    public static int HIe = 7;
    public static int HIf = 1;
    public static int HIg = 2;
    public static int HIh = 3;
    public Object data;
    public int oeH;
    
    public g()
    {
      this.oeH = HHX;
      this.data = null;
    }
    
    public g(int paramInt, Object paramObject)
    {
      this.oeH = paramInt;
      this.data = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchUI
 * JD-Core Version:    0.7.0.1
 */