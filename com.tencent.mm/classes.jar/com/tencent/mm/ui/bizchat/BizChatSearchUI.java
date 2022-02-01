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
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.am.a.j;
import com.tencent.mm.am.a.l;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cfw;
import com.tencent.mm.protocal.protobuf.mh;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.protocal.protobuf.mj;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.protocal.protobuf.oh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  private c GhA;
  private BizChatSearchListView GhB;
  private a GhC;
  String Ghy;
  private String Ghz;
  private TextView ftm;
  com.tencent.mm.modelvoiceaddr.ui.b mUp;
  String mVj;
  private int scene;
  private AbsListView.OnScrollListener sfw;
  
  public BizChatSearchUI()
  {
    AppMethodBeat.i(34012);
    this.sfw = new AbsListView.OnScrollListener()
    {
      boolean mUe = false;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        if (paramAnonymousInt1 + paramAnonymousInt2 == paramAnonymousInt3)
        {
          this.mUe = true;
          return;
        }
        this.mUe = false;
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(33989);
        if ((paramAnonymousInt == 0) && (this.mUe) && (BizChatSearchUI.a(BizChatSearchUI.this).GhX))
        {
          paramAnonymousAbsListView = BizChatSearchUI.a(BizChatSearchUI.this);
          if ((paramAnonymousAbsListView.eTS()) && (!paramAnonymousAbsListView.GhZ))
          {
            paramAnonymousAbsListView.GhZ = true;
            com.tencent.mm.am.a.m localm = new com.tencent.mm.am.a.m(paramAnonymousAbsListView.mVj, paramAnonymousAbsListView.fvQ, paramAnonymousAbsListView.Gif);
            az.aeS().a(localm, 0);
            paramAnonymousAbsListView.eTW();
          }
        }
        AppMethodBeat.o(33989);
      }
    };
    AppMethodBeat.o(34012);
  }
  
  private void Ye(int paramInt)
  {
    AppMethodBeat.i(34025);
    if (this.GhA != null) {
      this.GhA.updateStatus(paramInt);
    }
    AppMethodBeat.o(34025);
  }
  
  public final boolean BX(String paramString)
  {
    AppMethodBeat.i(34018);
    hideVKB();
    AppMethodBeat.o(34018);
    return true;
  }
  
  public final void BY(String paramString)
  {
    a locala = null;
    AppMethodBeat.i(34017);
    if ((bt.isNullOrNil(paramString)) && (this.Ghz != null))
    {
      paramString = this.Ghz;
      this.Ghz = null;
      if (!paramString.equals("")) {
        this.mUp.setSearchContent(paramString);
      }
      com.tencent.mm.modelvoiceaddr.ui.b localb = this.mUp;
      if (a.c(this.GhC)) {
        paramString = getContext().getResources().getString(2131756682);
      }
      for (;;)
      {
        localb.setHint(paramString);
        this.mUp.clearFocus();
        AppMethodBeat.o(34017);
        return;
        if (a.b(this.GhC))
        {
          paramString = getContext().getResources().getString(2131756686);
        }
        else
        {
          paramString = locala;
          if (a.e(this.GhC)) {
            paramString = getContext().getResources().getString(2131756679);
          }
        }
      }
    }
    locala = this.GhC;
    locala.fvQ = paramString;
    if (bt.isNullOrNil(paramString))
    {
      locala.clearData();
      locala.GhY = false;
      locala.Gie = false;
      locala.vV(true);
      AppMethodBeat.o(34017);
      return;
    }
    if (locala.scene == 4) {}
    for (int i = 1; i != 0; i = 0)
    {
      locala.clearData();
      locala.GhY = false;
      locala.Gie = false;
      locala.aKs(paramString);
      AppMethodBeat.o(34017);
      return;
    }
    if (locala.eTS())
    {
      locala.GhY = true;
      locala.Gie = false;
      locala.eTW();
      locala.cF(paramString, false);
      locala.aKt(paramString);
      AppMethodBeat.o(34017);
      return;
    }
    locala.cF(paramString, true);
    if ((locala.GhG) && (locala.GhY)) {
      locala.aKt(paramString);
    }
    if (locala.GhI) {
      locala.aKs(paramString);
    }
    AppMethodBeat.o(34017);
  }
  
  final void a(com.tencent.mm.api.c paramc, int paramInt)
  {
    AppMethodBeat.i(191451);
    com.tencent.mm.am.c localc = com.tencent.mm.am.af.awn().wt(this.Ghy);
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
      long l3 = paramc.Jj();
      h.vKh.f(14507, new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(paramInt) });
      ad.d("MicroMsg.BizChatSearchUI", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(paramInt) });
      AppMethodBeat.o(191451);
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
        this.ftm.setVisibility(8);
        this.GhB.setVisibility(8);
        AppMethodBeat.o(34015);
        return;
      }
      if (parama.getCount() <= 0)
      {
        this.ftm.setVisibility(0);
        this.GhB.setVisibility(8);
        AppMethodBeat.o(34015);
        return;
      }
      this.ftm.setVisibility(8);
      this.GhB.setVisibility(0);
      AppMethodBeat.o(34015);
      return;
    }
    if (bt.isNullOrNil(a.d(parama)))
    {
      this.ftm.setVisibility(0);
      this.ftm.setText("");
      this.GhB.setVisibility(8);
    }
    while (a.b(parama)) {
      if (parama.GhZ)
      {
        Ye(1);
        AppMethodBeat.o(34015);
        return;
        if ((a.b(parama)) && (parama.GhY))
        {
          this.ftm.setVisibility(0);
          this.ftm.setText(2131756680);
          this.GhB.setVisibility(8);
        }
        else if ((a.b(parama)) && (parama.Gie))
        {
          this.ftm.setVisibility(0);
          this.ftm.setText(2131756681);
          this.GhB.setVisibility(8);
        }
        else if (parama.getCount() <= 0)
        {
          this.ftm.setVisibility(0);
          this.ftm.setText(com.tencent.mm.plugin.fts.a.f.a(getString(2131762920), getString(2131762919), com.tencent.mm.plugin.fts.a.a.e.b(a.d(parama), a.d(parama))).rpj);
          this.GhB.setVisibility(8);
        }
        else
        {
          this.ftm.setVisibility(8);
          this.GhB.setVisibility(0);
        }
      }
      else
      {
        if (parama.GhX)
        {
          Ye(2);
          AppMethodBeat.o(34015);
          return;
        }
        Ye(0);
      }
    }
    AppMethodBeat.o(34015);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final void aEh()
  {
    AppMethodBeat.i(34019);
    hideVKB();
    AppMethodBeat.o(34019);
  }
  
  public final void aIj()
  {
    AppMethodBeat.i(34016);
    finish();
    AppMethodBeat.o(34016);
  }
  
  public final void aIk() {}
  
  public final void aIl() {}
  
  public final void aIm() {}
  
  public final boolean bCz()
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
    if (bt.isNullOrNil(this.mVj))
    {
      this.mVj = getIntent().getStringExtra("enterprise_biz_name");
      this.Ghy = getIntent().getStringExtra("enterprise_biz_father_name");
      this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
      this.Ghz = getIntent().getStringExtra("biz_chat_search_text");
      if (bt.isNullOrNil(this.mVj)) {
        finish();
      }
    }
    this.GhB = ((BizChatSearchListView)findViewById(2131297412));
    this.ftm = ((TextView)findViewById(2131302884));
    this.GhC = new a(getContext(), this.mVj, this.Ghy, this.scene);
    if (a.b(this.GhC))
    {
      this.GhA = new c((byte)0);
      BizChatSearchListView localBizChatSearchListView = this.GhB;
      c localc = this.GhA;
      View localView = View.inflate(getContext(), 2131494592, null);
      localc.mUg = localView.findViewById(2131301508);
      localc.mUh = localView.findViewById(2131301499);
      localc.mUi = localView.findViewById(2131301510);
      localc.mUg.setVisibility(8);
      localc.mUh.setVisibility(8);
      localc.mUi.setVisibility(8);
      localBizChatSearchListView.addFooterView(localView);
      Ye(0);
    }
    this.GhB.setAdapter(this.GhC);
    this.GhB.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(33990);
        paramAnonymousAdapterView = BizChatSearchUI.a(BizChatSearchUI.this).Yf(paramAnonymousInt);
        BizChatSearchUI localBizChatSearchUI = BizChatSearchUI.this;
        Object localObject;
        boolean bool1;
        if ((paramAnonymousAdapterView.nBH == BizChatSearchUI.g.Gij) || (paramAnonymousAdapterView.nBH == BizChatSearchUI.g.Gik))
        {
          paramAnonymousLong = -1L;
          if ((paramAnonymousAdapterView.data instanceof com.tencent.mm.am.a.c))
          {
            paramAnonymousAdapterView = (com.tencent.mm.am.a.c)paramAnonymousAdapterView.data;
            if (paramAnonymousAdapterView != null) {
              paramAnonymousLong = paramAnonymousAdapterView.field_bizChatLocalId;
            }
          }
          while ((bt.isNullOrNil(localBizChatSearchUI.mVj)) || (paramAnonymousLong < 0L))
          {
            AppMethodBeat.o(33990);
            return;
            if ((paramAnonymousAdapterView.data instanceof mh))
            {
              paramAnonymousView = ((mh)paramAnonymousAdapterView.data).CIT;
              localObject = localBizChatSearchUI.mVj;
              bool1 = true;
              paramAnonymousAdapterView = new com.tencent.mm.am.a.k();
              paramAnonymousAdapterView.field_userId = paramAnonymousView.CIR;
              paramAnonymousAdapterView.field_userName = paramAnonymousView.nvC;
              paramAnonymousAdapterView.field_brandUserName = ((String)localObject);
              paramAnonymousAdapterView.field_headImageUrl = paramAnonymousView.CIK;
              paramAnonymousAdapterView.field_profileUrl = paramAnonymousView.CIZ;
              paramAnonymousAdapterView.field_UserVersion = paramAnonymousView.ver;
              paramAnonymousAdapterView.field_addMemberUrl = paramAnonymousView.CIO;
              if (!com.tencent.mm.am.af.awi().b(paramAnonymousAdapterView)) {
                bool1 = com.tencent.mm.am.af.awi().a(paramAnonymousAdapterView);
              }
              if (!bool1)
              {
                paramAnonymousLong = -1L;
              }
              else
              {
                paramAnonymousView = new com.tencent.mm.am.a.c();
                paramAnonymousView.field_bizChatServId = paramAnonymousAdapterView.field_userId;
                paramAnonymousView.field_brandUserName = paramAnonymousAdapterView.field_brandUserName;
                paramAnonymousView.field_chatName = paramAnonymousAdapterView.field_userName;
                paramAnonymousView.field_chatType = j.gZo.gZr;
                paramAnonymousAdapterView = com.tencent.mm.am.a.e.e(paramAnonymousView);
                if (paramAnonymousAdapterView == null)
                {
                  paramAnonymousLong = -1L;
                }
                else
                {
                  paramAnonymousView = com.tencent.mm.am.af.awh().mf(paramAnonymousAdapterView.field_bizChatLocalId);
                  paramAnonymousView.field_bizChatId = paramAnonymousAdapterView.field_bizChatLocalId;
                  paramAnonymousView.field_unReadCount = 0;
                  if (bt.isNullOrNil(paramAnonymousView.field_brandUserName))
                  {
                    paramAnonymousView.field_brandUserName = paramAnonymousAdapterView.field_brandUserName;
                    paramAnonymousView.field_lastMsgTime = System.currentTimeMillis();
                    paramAnonymousView.field_flag = paramAnonymousView.field_lastMsgTime;
                  }
                  if (!com.tencent.mm.am.af.awh().b(paramAnonymousView)) {
                    com.tencent.mm.am.af.awh().a(paramAnonymousView);
                  }
                  paramAnonymousLong = paramAnonymousAdapterView.field_bizChatLocalId;
                }
              }
            }
          }
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("Chat_User", localBizChatSearchUI.mVj);
          paramAnonymousAdapterView.putExtra("key_biz_chat_id", paramAnonymousLong);
          paramAnonymousAdapterView.putExtra("finish_direct", true);
          paramAnonymousAdapterView.putExtra("key_need_send_video", false);
          paramAnonymousAdapterView.putExtra("key_is_biz_chat", true);
          com.tencent.mm.bs.d.e(localBizChatSearchUI.getContext(), ".ui.chatting.ChattingUI", paramAnonymousAdapterView);
          AppMethodBeat.o(33990);
          return;
        }
        if (paramAnonymousAdapterView.nBH == BizChatSearchUI.g.Gio) {}
        for (;;)
        {
          com.tencent.mm.api.c localc;
          try
          {
            localObject = (oh)((com.tencent.mm.ui.base.sortview.d)paramAnonymousAdapterView.data).data;
            if (localObject == null)
            {
              AppMethodBeat.o(33990);
              return;
            }
            bool1 = com.tencent.mm.am.f.wM(((oh)localObject).userName);
            boolean bool2 = com.tencent.mm.am.f.pc(((oh)localObject).userName);
            localc = com.tencent.mm.am.f.ei(((oh)localObject).userName);
            if (localc == null)
            {
              paramAnonymousAdapterView = null;
              break label1224;
              if (bool1)
              {
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("rawUrl", paramAnonymousView);
                paramAnonymousAdapterView.putExtra("useJs", true);
                paramAnonymousAdapterView.putExtra("srcUsername", ((oh)localObject).userName);
                paramAnonymousAdapterView.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                paramAnonymousAdapterView.addFlags(67108864);
                com.tencent.mm.bs.d.b(localBizChatSearchUI.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousAdapterView);
                localBizChatSearchUI.a(localc, 2);
                AppMethodBeat.o(33990);
              }
            }
            else
            {
              paramAnonymousAdapterView = localc.Ji();
              break label1224;
            }
            if (bool2)
            {
              paramAnonymousAdapterView = new Intent();
              paramAnonymousAdapterView.putExtra("Contact_User", ((oh)localObject).userName);
              paramAnonymousAdapterView.addFlags(67108864);
              paramAnonymousAdapterView.putExtra("biz_chat_from_scene", 3);
              com.tencent.mm.bs.d.e(localBizChatSearchUI.getContext(), ".ui.bizchat.BizChatConversationUI", paramAnonymousAdapterView);
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
          paramAnonymousAdapterView.putExtra("Chat_User", ((oh)localObject).userName);
          paramAnonymousAdapterView.putExtra("chat_from_scene", 2);
          com.tencent.mm.plugin.brandservice.b.d(paramAnonymousAdapterView, localBizChatSearchUI.getContext());
          localBizChatSearchUI.a(localc, 1);
          AppMethodBeat.o(33990);
          return;
          if (paramAnonymousAdapterView.nBH == BizChatSearchUI.g.Gil)
          {
            if (((Integer)paramAnonymousAdapterView.data).intValue() == BizChatSearchUI.g.Giq)
            {
              paramAnonymousAdapterView = new Intent(localBizChatSearchUI.getContext(), BizChatSearchUI.class);
              paramAnonymousAdapterView.putExtra("enterprise_biz_name", localBizChatSearchUI.mVj);
              paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 2);
              paramAnonymousAdapterView.putExtra("biz_chat_search_text", localBizChatSearchUI.mUp.getSearchContent());
              paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.a(localBizChatSearchUI, paramAnonymousAdapterView.adn(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localBizChatSearchUI.startActivity((Intent)paramAnonymousAdapterView.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(localBizChatSearchUI, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreUserUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(33990);
              return;
            }
            if (((Integer)paramAnonymousAdapterView.data).intValue() == BizChatSearchUI.g.Gir)
            {
              paramAnonymousAdapterView = new Intent(localBizChatSearchUI.getContext(), BizChatSearchUI.class);
              paramAnonymousAdapterView.putExtra("enterprise_biz_name", localBizChatSearchUI.mVj);
              paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 3);
              paramAnonymousAdapterView.putExtra("biz_chat_search_text", localBizChatSearchUI.mUp.getSearchContent());
              paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.a(localBizChatSearchUI, paramAnonymousAdapterView.adn(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreGroupUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localBizChatSearchUI.startActivity((Intent)paramAnonymousAdapterView.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(localBizChatSearchUI, "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreGroupUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(33990);
              return;
            }
            if (((Integer)paramAnonymousAdapterView.data).intValue() == BizChatSearchUI.g.Gis)
            {
              paramAnonymousAdapterView = new Intent(localBizChatSearchUI.getContext(), BizChatSearchUI.class);
              paramAnonymousAdapterView.putExtra("enterprise_biz_name", localBizChatSearchUI.mVj);
              paramAnonymousAdapterView.putExtra("enterprise_biz_father_name", localBizChatSearchUI.Ghy);
              paramAnonymousAdapterView.putExtra("biz_chat_search_scene", 4);
              paramAnonymousAdapterView.putExtra("biz_chat_search_text", localBizChatSearchUI.mUp.getSearchContent());
              paramAnonymousAdapterView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousAdapterView);
              com.tencent.mm.hellhoundlib.a.a.a(localBizChatSearchUI, paramAnonymousAdapterView.adn(), "com/tencent/mm/ui/bizchat/BizChatSearchUI", "goToMoreAppUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localBizChatSearchUI.startActivity((Intent)paramAnonymousAdapterView.lS(0));
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
    this.GhB.setOnTouchListener(this);
    if (a.b(this.GhC)) {
      this.GhB.setOnScrollListener(this.sfw);
    }
    this.mUp = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.mUp.wH(a.c(this.GhC));
    this.mUp.a(this);
    this.mUp.hFB = false;
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
    this.mUp.a(this, paramMenu);
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
    this.mUp.cancel();
    this.mUp.clearFocus();
    AppMethodBeat.o(34020);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(34023);
    this.mUp.a(this, paramMenu);
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
    public static int GhE = 3;
    private int GhF;
    boolean GhG;
    boolean GhH;
    boolean GhI;
    private ArrayList<com.tencent.mm.am.a.c> GhJ;
    private ArrayList<Object> GhK;
    private ArrayList<com.tencent.mm.am.a.c> GhL;
    private ArrayList<com.tencent.mm.ui.base.sortview.d> GhM;
    private List<com.tencent.mm.ui.base.sortview.d> GhN;
    private BizChatSearchUI.g GhO;
    private ArrayList<BizChatSearchUI.g> GhP;
    private BizChatSearchUI.g GhQ;
    private BizChatSearchUI.g GhR;
    private ArrayList<BizChatSearchUI.g> GhS;
    private BizChatSearchUI.g GhT;
    private BizChatSearchUI.g GhU;
    private ArrayList<BizChatSearchUI.g> GhV;
    private BizChatSearchUI.g GhW;
    public boolean GhX;
    public boolean GhY;
    public boolean GhZ;
    private String Ghy;
    private boolean Gia;
    private boolean Gib;
    private int Gic;
    private int Gid;
    public boolean Gie;
    int Gif;
    private int ahd;
    private Context context;
    String fvQ;
    private com.tencent.mm.aw.a.a.c hjG;
    String mVj;
    int scene;
    
    public a(Context paramContext, String paramString1, String paramString2, int paramInt)
    {
      AppMethodBeat.i(191447);
      this.GhJ = new ArrayList();
      this.GhK = new ArrayList();
      this.GhL = new ArrayList();
      this.GhM = new ArrayList();
      this.GhP = new ArrayList();
      this.GhS = new ArrayList();
      this.GhV = new ArrayList();
      this.GhX = true;
      this.GhY = false;
      this.GhZ = false;
      this.Gia = true;
      this.Gib = true;
      this.Gic = 0;
      this.Gid = 0;
      this.ahd = 0;
      this.Gie = false;
      this.Gif = 0;
      this.context = paramContext;
      this.mVj = paramString1;
      this.Ghy = paramString2;
      this.scene = paramInt;
      boolean bool1;
      if ((this.scene == 1) || (this.scene == 2))
      {
        bool1 = true;
        this.GhG = bool1;
        if ((this.scene != 1) && (this.scene != 3)) {
          break label359;
        }
        bool1 = true;
        label204:
        this.GhH = bool1;
        bool1 = bool2;
        if (!bt.isNullOrNil(this.Ghy)) {
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
        this.GhI = bool1;
        if (this.scene != 1) {
          break label365;
        }
      }
      label359:
      label365:
      for (paramInt = GhE;; paramInt = 2147483647)
      {
        this.GhF = paramInt;
        paramContext = new c.a();
        paramContext.prefixPath = com.tencent.mm.am.a.e.dH(this.mVj);
        paramContext.hjU = true;
        paramContext.gjA = true;
        paramContext.hkf = 2131690013;
        this.hjG = paramContext.azc();
        if (this.GhI) {
          this.GhN = getSortEntityList();
        }
        if (this.GhG) {
          az.aeS().a(1364, this);
        }
        AppMethodBeat.o(191447);
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
      AppMethodBeat.i(191449);
      if ((!bt.isNullOrNil(paramString)) && (paramd != null))
      {
        Object localObject = (oh)paramd.data;
        if (localObject == null)
        {
          AppMethodBeat.o(191449);
          return false;
        }
        paramd = ((oh)localObject).contact.ZX();
        String str = ((oh)localObject).contact.Sv();
        localObject = ((oh)localObject).contact.Sw();
        paramString = paramString.toUpperCase();
        if (((!bt.isNullOrNil(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!bt.isNullOrNil(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!bt.isNullOrNil((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString))))
        {
          AppMethodBeat.o(191449);
          return true;
        }
      }
      AppMethodBeat.o(191449);
      return false;
    }
    
    private void eTQ()
    {
      AppMethodBeat.i(33997);
      if (eTS())
      {
        this.GhY = false;
        this.Gie = true;
        eTW();
      }
      AppMethodBeat.o(33997);
    }
    
    private boolean eTR()
    {
      return this.scene == 1;
    }
    
    private boolean eTT()
    {
      return this.scene == 3;
    }
    
    private void eTU()
    {
      int k = 1;
      AppMethodBeat.i(34001);
      int i = this.GhK.size();
      int n = this.GhL.size();
      int m = this.GhM.size();
      boolean bool;
      label82:
      label105:
      int j;
      if (this.scene != 2)
      {
        if (this.GhK.size() > this.GhF)
        {
          bool = true;
          this.GhX = bool;
        }
      }
      else
      {
        if (this.GhL.size() <= this.GhF) {
          break label275;
        }
        bool = true;
        this.Gia = bool;
        if (this.GhM.size() <= this.GhF) {
          break label281;
        }
        bool = true;
        this.Gib = bool;
        if ((i <= 0) && (!this.GhY)) {
          break label310;
        }
        j = Math.min(i, this.GhF) + 1;
        if (!eTR()) {
          break label307;
        }
        if ((!this.GhY) && (!this.GhX)) {
          break label287;
        }
        i = 1;
        label156:
        j = i + j;
      }
      for (;;)
      {
        this.Gic = j;
        i = j;
        if (n > 0)
        {
          j = Math.min(n, this.GhF) + (j + 1);
          if (!eTR()) {
            break label302;
          }
          if (!this.Gia) {
            break label292;
          }
          i = 1;
          label202:
          i += j;
        }
        for (;;)
        {
          this.Gid = i;
          j = i;
          if (m > 0)
          {
            m = i + 1 + Math.min(m, this.GhF);
            j = m;
            if (eTR()) {
              if (!this.Gib) {
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
            this.ahd = j;
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
    
    private void eTV()
    {
      int k = 0;
      AppMethodBeat.i(34004);
      this.GhP.clear();
      this.GhS.clear();
      this.GhV.clear();
      int i = 0;
      while (i < Math.min(this.GhF, this.GhK.size()))
      {
        this.GhP.add(new BizChatSearchUI.g(BizChatSearchUI.g.Gij, this.GhK.get(i)));
        i += 1;
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= Math.min(this.GhF, this.GhL.size())) {
          break;
        }
        this.GhS.add(new BizChatSearchUI.g(BizChatSearchUI.g.Gik, this.GhL.get(i)));
        i += 1;
      }
      while (j < Math.min(this.GhF, this.GhM.size()))
      {
        this.GhV.add(new BizChatSearchUI.g(BizChatSearchUI.g.Gio, this.GhM.get(j)));
        j += 1;
      }
      AppMethodBeat.o(34004);
    }
    
    private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList()
    {
      AppMethodBeat.i(191450);
      ArrayList localArrayList = new ArrayList();
      com.tencent.mm.am.af.awe();
      Cursor localCursor = com.tencent.mm.am.e.L(this.Ghy, true);
      while (localCursor.moveToNext())
      {
        oh localoh = new oh();
        Object localObject;
        if (localCursor != null)
        {
          localObject = new com.tencent.mm.storage.af();
          ((com.tencent.mm.storage.af)localObject).convertFrom(localCursor);
          com.tencent.mm.api.c localc = new com.tencent.mm.api.c();
          localc.convertFrom(localCursor);
          localoh.userName = ((au)localObject).field_username;
          localoh.contact = ((com.tencent.mm.storage.af)localObject);
          localoh.uzN = localc;
        }
        if (localoh.contact != null)
        {
          localObject = new com.tencent.mm.ui.base.sortview.d();
          ((com.tencent.mm.ui.base.sortview.d)localObject).data = localoh;
          if (localoh.uzN.Jg()) {
            ((com.tencent.mm.ui.base.sortview.d)localObject).GgC = "!1";
          }
          for (;;)
          {
            localArrayList.add(localObject);
            break;
            if (localoh.contact.ZS())
            {
              ((com.tencent.mm.ui.base.sortview.d)localObject).GgC = "!2";
            }
            else
            {
              int j = localoh.contact.Zh();
              int i = j;
              if (j >= 97)
              {
                i = j;
                if (j <= 122) {
                  i = j - 32;
                }
              }
              if ((i >= 65) && (i <= 90)) {
                ((com.tencent.mm.ui.base.sortview.d)localObject).GgC = ((char)i);
              } else {
                ((com.tencent.mm.ui.base.sortview.d)localObject).GgC = "#";
              }
            }
          }
        }
      }
      localCursor.close();
      Collections.sort(localArrayList, new a((byte)0));
      AppMethodBeat.o(191450);
      return localArrayList;
    }
    
    public final BizChatSearchUI.g Yf(int paramInt)
    {
      AppMethodBeat.i(33994);
      if (paramInt < this.Gic)
      {
        if (paramInt == 0)
        {
          if (this.GhO == null) {
            this.GhO = new BizChatSearchUI.g(BizChatSearchUI.g.Gin, Integer.valueOf(BizChatSearchUI.g.Giq));
          }
          localg = this.GhO;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.Gic - 1) && (this.GhY) && (eTR()))
        {
          if (this.GhQ == null) {
            this.GhQ = new BizChatSearchUI.g();
          }
          this.GhQ.nBH = BizChatSearchUI.g.Gim;
          this.GhQ.data = Integer.valueOf(BizChatSearchUI.g.Giq);
          localg = this.GhQ;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.Gic - 1) && (this.GhX) && (eTR()))
        {
          if (this.GhQ == null) {
            this.GhQ = new BizChatSearchUI.g();
          }
          this.GhQ.nBH = BizChatSearchUI.g.Gil;
          this.GhQ.data = Integer.valueOf(BizChatSearchUI.g.Giq);
          localg = this.GhQ;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt -= 1;
        if ((paramInt >= 0) && (paramInt < this.GhP.size()))
        {
          localg = (BizChatSearchUI.g)this.GhP.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      else if (paramInt < this.Gid)
      {
        if (paramInt == this.Gic)
        {
          if (this.GhR == null) {
            this.GhR = new BizChatSearchUI.g(BizChatSearchUI.g.Gin, Integer.valueOf(BizChatSearchUI.g.Gir));
          }
          localg = this.GhR;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.ahd - 1) && (this.Gia) && (eTR()))
        {
          if (this.GhT == null) {
            this.GhT = new BizChatSearchUI.g(BizChatSearchUI.g.Gil, Integer.valueOf(BizChatSearchUI.g.Gir));
          }
          localg = this.GhT;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt = paramInt - this.Gic - 1;
        if ((paramInt >= 0) && (paramInt < this.GhS.size()))
        {
          localg = (BizChatSearchUI.g)this.GhS.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      else
      {
        if (paramInt == this.Gid)
        {
          if (this.GhU == null) {
            this.GhU = new BizChatSearchUI.g(BizChatSearchUI.g.Gin, Integer.valueOf(BizChatSearchUI.g.Gis));
          }
          localg = this.GhU;
          AppMethodBeat.o(33994);
          return localg;
        }
        if ((paramInt == this.ahd - 1) && (this.Gib) && (eTR()))
        {
          if (this.GhW == null) {
            this.GhW = new BizChatSearchUI.g(BizChatSearchUI.g.Gil, Integer.valueOf(BizChatSearchUI.g.Gis));
          }
          localg = this.GhW;
          AppMethodBeat.o(33994);
          return localg;
        }
        paramInt = paramInt - this.Gid - 1;
        if ((paramInt >= 0) && (paramInt < this.GhV.size()))
        {
          localg = (BizChatSearchUI.g)this.GhV.get(paramInt);
          AppMethodBeat.o(33994);
          return localg;
        }
      }
      BizChatSearchUI.g localg = new BizChatSearchUI.g();
      AppMethodBeat.o(33994);
      return localg;
    }
    
    final void aKs(String paramString)
    {
      AppMethodBeat.i(191448);
      this.GhM.clear();
      if ((!bt.isNullOrNil(paramString)) && (this.GhN != null))
      {
        Iterator localIterator = this.GhN.iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.ui.base.sortview.d locald = (com.tencent.mm.ui.base.sortview.d)localIterator.next();
          if (a(paramString, locald)) {
            this.GhM.add(locald);
          }
        }
      }
      vV(true);
      AppMethodBeat.o(191448);
    }
    
    final void aKt(final String paramString)
    {
      AppMethodBeat.i(34000);
      if (!this.GhG)
      {
        AppMethodBeat.o(34000);
        return;
      }
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33991);
          if (!paramString.equals(BizChatSearchUI.a.d(BizChatSearchUI.a.this)))
          {
            AppMethodBeat.o(33991);
            return;
          }
          com.tencent.mm.am.a.m localm = new com.tencent.mm.am.a.m(BizChatSearchUI.a.f(BizChatSearchUI.a.this), paramString, 0);
          az.aeS().a(localm, 0);
          AppMethodBeat.o(33991);
        }
      }, 200L);
      AppMethodBeat.o(34000);
    }
    
    final void cF(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(33999);
      paramString = com.tencent.mm.am.af.awh().aV(this.mVj, paramString);
      clearData();
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        com.tencent.mm.am.a.c localc = (com.tencent.mm.am.a.c)paramString.next();
        bool = localc.isGroup();
        if ((bool) && (this.GhH))
        {
          this.GhL.add(localc);
        }
        else if ((!bool) && (this.GhG))
        {
          this.GhK.add(localc);
          this.GhJ.add(localc);
        }
      }
      if (this.GhG) {
        if (this.GhK.size() > this.GhF) {
          break label153;
        }
      }
      label153:
      for (boolean bool = true;; bool = false)
      {
        this.GhY = bool;
        vV(paramBoolean);
        AppMethodBeat.o(33999);
        return;
      }
    }
    
    final void clearData()
    {
      AppMethodBeat.i(34002);
      this.Gif = 0;
      this.GhK.clear();
      this.GhJ.clear();
      this.GhL.clear();
      AppMethodBeat.o(34002);
    }
    
    final boolean eTS()
    {
      return this.scene == 2;
    }
    
    final void eTW()
    {
      AppMethodBeat.i(34005);
      ((BizChatSearchUI)this.context).a(this);
      AppMethodBeat.o(34005);
    }
    
    public final int getCount()
    {
      return this.ahd;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(33993);
      BizChatSearchUI.g localg = Yf(paramInt);
      if (localg != null)
      {
        paramInt = localg.nBH;
        AppMethodBeat.o(33993);
        return paramInt;
      }
      paramInt = BizChatSearchUI.g.Gii;
      AppMethodBeat.o(33993);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(33995);
      BizChatSearchUI.g localg = Yf(paramInt);
      View localView;
      int i;
      BizChatSearchUI.f localf;
      Object localObject2;
      boolean bool1;
      String str;
      Object localObject1;
      if ((localg.nBH == BizChatSearchUI.g.Gij) || (localg.nBH == BizChatSearchUI.g.Gik) || (localg.nBH == BizChatSearchUI.g.Gio))
      {
        localView = paramView;
        if (paramView == null)
        {
          localView = LayoutInflater.from(this.context).inflate(2131494192, paramViewGroup, false);
          i = paramViewGroup.getPaddingLeft();
          int j = paramViewGroup.getPaddingRight();
          localView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(paramViewGroup.getWidth(), 1073741824), i + j, -1), View.MeasureSpec.makeMeasureSpec(-2, 1073741824));
          paramView = new BizChatSearchUI.f((byte)0);
          paramView.frr = ((ImageView)localView.findViewById(2131297008));
          paramView.ica = ((TextView)localView.findViewById(2131305948));
          paramView.hJe = ((TextView)localView.findViewById(2131299008));
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
            localObject1 = com.tencent.mm.am.af.awi().ea(paramView.field_bizChatServId);
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
            paramViewGroup = com.tencent.mm.plugin.fts.a.f.a(paramViewGroup, this.fvQ);
            paramViewGroup = a(this.context, paramViewGroup, com.tencent.mm.plugin.fts.ui.b.c.rsK);
            label309:
            if (!bool1) {
              break label686;
            }
            localObject2 = this.context.getString(2131756687);
            localObject1 = com.tencent.mm.plugin.fts.a.f.a((CharSequence)localObject1, this.fvQ);
          }
          label686:
          for (localObject1 = TextUtils.concat(new CharSequence[] { localObject2, a(this.context, (Spannable)localObject1, com.tencent.mm.plugin.fts.ui.b.c.rsK) });; localObject1 = "")
          {
            boolean bool2 = true;
            bool1 = bool2;
            if (localg.nBH == BizChatSearchUI.g.Gij)
            {
              bool1 = bool2;
              if (paramInt == this.Gic - 1)
              {
                bool1 = bool2;
                if (this.Gic != this.ahd) {
                  bool1 = false;
                }
              }
            }
            com.tencent.mm.plugin.fts.ui.m.q(localf.contentView, bool1);
            o.ayJ().a(paramView, localf.frr, this.hjG);
            com.tencent.mm.plugin.fts.ui.m.a(paramViewGroup, localf.ica);
            com.tencent.mm.plugin.fts.ui.m.a((CharSequence)localObject1, localf.hJe);
            AppMethodBeat.o(33995);
            return localView;
            paramViewGroup = paramView.field_chatName;
            paramView = paramView.field_headImageUrl;
            break;
            if ((localg.data instanceof mh))
            {
              localObject1 = (mh)localg.data;
              paramView = ((mh)localObject1).CIT;
              paramViewGroup = paramView.nvC;
              paramView = paramView.CIK;
              bool1 = "userid".equals(((mh)localObject1).CIU);
              if (!bool1) {}
              for (i = 1;; i = 0)
              {
                localObject1 = ((mh)localObject1).CIV;
                break;
              }
            }
            if (!(localg.data instanceof com.tencent.mm.ui.base.sortview.d)) {
              break label1396;
            }
            oh localoh = (oh)((com.tencent.mm.ui.base.sortview.d)localg.data).data;
            localObject1 = localObject2;
            paramView = paramViewGroup;
            if (localoh != null)
            {
              if (localoh.contact != null) {
                paramViewGroup = localoh.contact.ZX();
              }
              localObject1 = localObject2;
              paramView = paramViewGroup;
              if (localoh.uzN != null)
              {
                localObject1 = localoh.uzN.field_brandIconURL;
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
            paramViewGroup = a(this.context, new SpannableString(paramViewGroup), com.tencent.mm.plugin.fts.ui.b.c.rsK);
            break label309;
          }
          if (localg.nBH == BizChatSearchUI.g.Gin)
          {
            localObject1 = paramView;
            if (paramView == null)
            {
              localObject1 = LayoutInflater.from(this.context).inflate(2131493192, paramViewGroup, false);
              paramView = new BizChatSearchUI.b((byte)0);
              paramView.nOq = ((TextView)((View)localObject1).findViewById(2131305880));
              paramView.rvj = ((View)localObject1).findViewById(2131303131);
              paramView.contentView = ((View)localObject1).findViewById(2131304428);
              ((View)localObject1).setTag(paramView);
            }
            paramViewGroup = (BizChatSearchUI.b)((View)localObject1).getTag();
            if (((Integer)localg.data).intValue() == BizChatSearchUI.g.Giq) {
              paramView = this.context.getResources().getString(2131756685);
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.fts.ui.m.a(paramView, paramViewGroup.nOq);
            if (paramInt == 0) {
              paramViewGroup.rvj.setVisibility(8);
            }
            for (;;)
            {
              paramViewGroup.contentView.setBackgroundResource(2131232878);
              AppMethodBeat.o(33995);
              return localObject1;
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.Gir)
              {
                paramView = this.context.getResources().getString(2131756678);
                break;
              }
              if (((Integer)localg.data).intValue() != BizChatSearchUI.g.Gis) {
                break label1389;
              }
              paramView = this.context.getResources().getString(2131760268);
              break;
              paramViewGroup.rvj.setVisibility(0);
            }
            if (localg.nBH == BizChatSearchUI.g.Gil)
            {
              localObject1 = paramView;
              if (paramView == null)
              {
                localObject1 = LayoutInflater.from(this.context).inflate(2131493193, paramViewGroup, false);
                paramView = new BizChatSearchUI.e((byte)0);
                paramView.ruT = ((TextView)((View)localObject1).findViewById(2131305880));
                paramView.kXS = ((ImageView)((View)localObject1).findViewById(2131300891));
                paramView.contentView = ((View)localObject1).findViewById(2131304428);
                ((View)localObject1).setTag(paramView);
              }
              paramViewGroup = (BizChatSearchUI.e)((View)localObject1).getTag();
              paramView = "";
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.Giq)
              {
                paramView = this.context.getResources().getString(2131756684);
                if ((((Integer)localg.data).intValue() != BizChatSearchUI.g.Giq) || (this.Gic == this.ahd)) {
                  break label1383;
                }
              }
            }
            label1377:
            label1383:
            for (bool1 = false;; bool1 = true)
            {
              com.tencent.mm.plugin.fts.ui.m.q(paramViewGroup.contentView, bool1);
              paramViewGroup.ruT.setText(paramView);
              paramViewGroup.kXS.setImageResource(2131690258);
              AppMethodBeat.o(33995);
              return localObject1;
              if (((Integer)localg.data).intValue() == BizChatSearchUI.g.Gir)
              {
                paramView = this.context.getResources().getString(2131756683);
                break;
              }
              if (((Integer)localg.data).intValue() != BizChatSearchUI.g.Gis) {
                break;
              }
              paramView = this.context.getResources().getString(2131760275);
              break;
              if (localg.nBH == BizChatSearchUI.g.Gim)
              {
                localObject1 = paramView;
                if (paramView == null)
                {
                  localObject1 = LayoutInflater.from(this.context).inflate(2131494207, paramViewGroup, false);
                  paramView = new BizChatSearchUI.d((byte)0);
                  paramView.ruT = ((TextView)((View)localObject1).findViewById(2131305880));
                  paramView.contentView = ((View)localObject1).findViewById(2131304428);
                  ((View)localObject1).setTag(paramView);
                }
                paramView = (BizChatSearchUI.d)((View)localObject1).getTag();
                if ((((Integer)localg.data).intValue() != BizChatSearchUI.g.Giq) || (this.Gic == this.ahd)) {
                  break label1377;
                }
              }
              for (bool1 = false;; bool1 = true)
              {
                com.tencent.mm.plugin.fts.ui.m.q(paramView.contentView, bool1);
                paramView.ruT.setText(this.context.getResources().getString(2131756680));
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
      return BizChatSearchUI.g.Gip;
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(33996);
      Object localObject1;
      Object localObject2;
      if ((this.GhG) && (paramn.getType() == 1364) && ((paramn instanceof com.tencent.mm.am.a.m)))
      {
        this.GhZ = false;
        localObject1 = (com.tencent.mm.am.a.m)paramn;
        if ((((com.tencent.mm.am.a.m)localObject1).rr != null) && (((com.tencent.mm.am.a.m)localObject1).rr.gUS.gUX != null)) {}
        for (paramString = (mi)((com.tencent.mm.am.a.m)localObject1).rr.gUS.gUX;; paramString = null)
        {
          paramn = paramString.dcm;
          localObject2 = paramString.CIQ;
          if ((paramn.equals(this.fvQ)) && (((String)localObject2).equals(this.mVj)) && (this.Gif == paramString.offset)) {
            break;
          }
          AppMethodBeat.o(33996);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          eTQ();
          AppMethodBeat.o(33996);
          return;
        }
        if ((((com.tencent.mm.am.a.m)localObject1).rr != null) && (((com.tencent.mm.am.a.m)localObject1).rr.gUT.gUX != null)) {}
        for (paramString = (mj)((com.tencent.mm.am.a.m)localObject1).rr.gUT.gUX; (paramString == null) || (paramString.CIW == null) || (paramString.CIW.ret != 0); paramString = null)
        {
          eTQ();
          AppMethodBeat.o(33996);
          return;
        }
        localObject1 = paramString.CIX;
        boolean bool = paramString.CIY;
        if (paramn.equals(this.fvQ))
        {
          this.GhY = false;
          this.Gif += ((List)localObject1).size();
          if (eTR())
          {
            if (this.GhK.size() < this.GhJ.size())
            {
              cF(paramn, true);
              AppMethodBeat.o(33996);
              return;
            }
            if (this.GhK.size() > this.GhJ.size()) {}
          }
          else
          {
            if (eTS()) {
              this.GhX = bool;
            }
            if (eTT()) {
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
          paramn = (mh)paramString.next();
          localObject1 = paramn.CIT;
          if (!bt.isNullOrNil(((mk)localObject1).CIR))
          {
            localObject2 = this.GhJ.iterator();
            com.tencent.mm.am.a.c localc;
            do
            {
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localc = (com.tencent.mm.am.a.c)((Iterator)localObject2).next();
            } while (!((mk)localObject1).CIR.equals(localc.field_bizChatServId));
          }
        }
        else
        {
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              break label480;
            }
            this.GhK.add(paramn);
            break;
            vV(true);
            AppMethodBeat.o(33996);
            return;
          }
        }
      }
    }
    
    final void vV(boolean paramBoolean)
    {
      AppMethodBeat.i(34003);
      eTV();
      eTU();
      if (paramBoolean)
      {
        notifyDataSetChanged();
        eTW();
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
    public TextView nOq;
    public View rvj;
  }
  
  static final class c
  {
    View mUg;
    View mUh;
    View mUi;
    
    private void F(boolean paramBoolean1, boolean paramBoolean2)
    {
      int j = 0;
      AppMethodBeat.i(34011);
      View localView = this.mUg;
      if (paramBoolean1)
      {
        i = 0;
        localView.setVisibility(i);
        this.mUh.setVisibility(8);
        localView = this.mUi;
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
        F(false, false);
        AppMethodBeat.o(34010);
        return;
      case 1: 
        F(true, false);
        AppMethodBeat.o(34010);
        return;
      }
      F(false, true);
      AppMethodBeat.o(34010);
    }
  }
  
  static final class d
  {
    public View contentView;
    public TextView ruT;
  }
  
  static final class e
  {
    public View contentView;
    public ImageView kXS;
    public TextView ruT;
  }
  
  static final class f
  {
    public View contentView;
    public ImageView frr;
    public TextView hJe;
    public TextView ica;
  }
  
  static final class g
  {
    public static int Gii = 0;
    public static int Gij = 1;
    public static int Gik = 2;
    public static int Gil = 3;
    public static int Gim = 4;
    public static int Gin = 5;
    public static int Gio = 6;
    public static int Gip = 7;
    public static int Giq = 1;
    public static int Gir = 2;
    public static int Gis = 3;
    public Object data;
    public int nBH;
    
    public g()
    {
      this.nBH = Gii;
      this.data = null;
    }
    
    public g(int paramInt, Object paramObject)
    {
      this.nBH = paramInt;
      this.data = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchUI
 * JD-Core Version:    0.7.0.1
 */