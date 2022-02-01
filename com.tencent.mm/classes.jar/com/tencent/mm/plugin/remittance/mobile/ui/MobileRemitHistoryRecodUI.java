package com.tencent.mm.plugin.remittance.mobile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.plugin.remittance.mobile.cgi.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.cjs;
import com.tencent.mm.protocal.protobuf.eua;
import com.tencent.mm.protocal.protobuf.euc;
import com.tencent.mm.protocal.protobuf.eue;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.c.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MobileRemitHistoryRecodUI
  extends MobileRemitBaseUI
{
  private RecyclerView Ijn;
  private TextView Ijo;
  private String Ijp;
  private String Ijq;
  private boolean Ijr;
  private List<cjs> Ijs;
  private MobileRemitHistoryRecodUI.b Ijt;
  private MobileRemitHistoryRecodUI.c Iju;
  private int Ijv;
  private Runnable Ijw;
  private LinearLayoutManager jbn;
  private int[] wKq;
  
  public MobileRemitHistoryRecodUI()
  {
    AppMethodBeat.i(67706);
    this.Ijp = null;
    this.Ijq = null;
    this.Ijr = false;
    this.Ijs = new ArrayList();
    this.Ijv = 0;
    this.wKq = new int[2];
    this.Ijw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67689);
        if ((MobileRemitHistoryRecodUI.h(MobileRemitHistoryRecodUI.this).getScrollState() == 0) && (!MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).eYG) && (MobileRemitHistoryRecodUI.g(MobileRemitHistoryRecodUI.this).kL() + 1 == MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount()))
        {
          Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "first screen refresh data!");
          MobileRemitHistoryRecodUI.f(MobileRemitHistoryRecodUI.this);
        }
        AppMethodBeat.o(67689);
      }
    };
    AppMethodBeat.o(67706);
  }
  
  public int getLayoutId()
  {
    return a.g.mobile_remit_history_record_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67708);
    super.initView();
    setMMTitle(getString(a.i.mobile_remit_history_recod_title));
    setBackBtn(new MobileRemitHistoryRecodUI.1(this));
    this.Ijn = ((RecyclerView)findViewById(a.f.mobile_remit_hitory_record_rv));
    this.Ijo = ((TextView)findViewById(a.f.mobile_remit_hitory_record_none_tv));
    if (this.Ijs.isEmpty())
    {
      this.Ijn.setVisibility(8);
      this.Ijo.setVisibility(0);
      AppMethodBeat.o(67708);
      return;
    }
    this.jbn = new LinearLayoutManager();
    this.jbn.setOrientation(1);
    this.Ijn.setLayoutManager(this.jbn);
    this.Iju = new MobileRemitHistoryRecodUI.c(getContext());
    this.Ijn.a(this.Iju);
    this.Ijt = new MobileRemitHistoryRecodUI.b(getContext(), this.Ijr, this.Ijs, new MobileRemitHistoryRecodUI.d()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67684);
        Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv click!");
        paramAnonymousView = (cjs)paramAnonymousView.getTag();
        if (paramAnonymousView.IiP != 0) {
          h.a(MobileRemitHistoryRecodUI.this.getContext(), MobileRemitHistoryRecodUI.this.getResources().getString(a.i.mobile_remit_history_recod_invalid_dialog_desc), "", MobileRemitHistoryRecodUI.this.getResources().getString(a.i.mobile_remit_confirm), false, null).show();
        }
        for (;;)
        {
          MobileRemitHistoryRecodUI.acP(13);
          AppMethodBeat.o(67684);
          return;
          paramAnonymousView = new NetSceneMobileRemitGetRecvInfo("", paramAnonymousView.id, MobileRemitHistoryRecodUI.a(MobileRemitHistoryRecodUI.this), 2);
          MobileRemitHistoryRecodUI.this.doSceneProgress(paramAnonymousView, true);
        }
      }
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67685);
        Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv longclick!");
        final cjs localcjs = (cjs)paramAnonymousView.getTag();
        new com.tencent.mm.ui.widget.b.a(MobileRemitHistoryRecodUI.this, paramAnonymousView).a(paramAnonymousView, new View.OnCreateContextMenuListener()new q.g
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(67682);
            paramAnonymous2ContextMenu.add(0, 0, 0, a.i.app_delete);
            AppMethodBeat.o(67682);
          }
        }, new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(67683);
            if (paramAnonymous2MenuItem == null)
            {
              AppMethodBeat.o(67683);
              return;
            }
            if (paramAnonymous2MenuItem.getItemId() == 0)
            {
              Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "delete HisRcvr id:%s", new Object[] { localcjs.id });
              paramAnonymous2MenuItem = new c(localcjs.id);
              MobileRemitHistoryRecodUI.this.doSceneProgress(paramAnonymous2MenuItem, false);
              MobileRemitHistoryRecodUI.b(MobileRemitHistoryRecodUI.this).remove(localcjs);
              MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).alc.notifyChanged();
              MobileRemitHistoryRecodUI.acP(14);
            }
            AppMethodBeat.o(67683);
          }
        }, MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[0], MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[1]);
        AppMethodBeat.o(67685);
        return true;
      }
    });
    this.Ijn.setAdapter(this.Ijt);
    this.Ijn.a(new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(205379);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        Log.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv onScrollStateChanged() newState:%s mLastVisibleItem:%s isFinish:%s itemCount:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(MobileRemitHistoryRecodUI.e(MobileRemitHistoryRecodUI.this)), Boolean.valueOf(MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).eYG), Integer.valueOf(MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount()) });
        if ((paramAnonymousInt == 0) && (!MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).eYG) && (MobileRemitHistoryRecodUI.e(MobileRemitHistoryRecodUI.this) + 1 == MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount())) {
          MobileRemitHistoryRecodUI.f(MobileRemitHistoryRecodUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(205379);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(205380);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousRecyclerView);
        localb.sg(paramAnonymousInt1);
        localb.sg(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        MobileRemitHistoryRecodUI.a(MobileRemitHistoryRecodUI.this, MobileRemitHistoryRecodUI.g(MobileRemitHistoryRecodUI.this).kL());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(205380);
      }
    });
    this.Ijt.alc.notifyChanged();
    this.Ijn.post(this.Ijw);
    this.Ijn.a(new MobileRemitHistoryRecodUI.4(this));
    this.Ijn.setVisibility(0);
    this.Ijo.setVisibility(8);
    AppMethodBeat.o(67708);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67707);
    super.onCreate(paramBundle);
    this.Ijp = getIntent().getStringExtra("key_homepage_ext");
    this.Ijr = getIntent().getBooleanExtra("key_finish", true);
    this.Ijq = getIntent().getStringExtra("key_last_id");
    paramBundle = getIntent().getParcelableArrayListExtra("key_history_record");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.Ijs.addAll(NetSceneMobileRemitGetRecord.gV(paramBundle));
    }
    Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "initData() mFinish:%s mLastId:%s mHisRecord.size:%s", new Object[] { Boolean.valueOf(this.Ijr), this.Ijq, Integer.valueOf(this.Ijs.size()) });
    initView();
    addSceneEndListener(2993);
    addSceneEndListener(1495);
    addSceneEndListener(1275);
    AppMethodBeat.o(67707);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67709);
    super.onDestroy();
    removeSceneEndListener(2993);
    removeSceneEndListener(1495);
    removeSceneEndListener(1275);
    AppMethodBeat.o(67709);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    Object localObject = null;
    AppMethodBeat.i(67710);
    Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof NetSceneMobileRemitGetRecord))
      {
        paramString = ((NetSceneMobileRemitGetRecord)paramq).fAb();
        if ((paramString != null) && (paramString.tqa == 0))
        {
          this.Ijq = paramString.UvQ;
          this.Ijr = paramString.jHM;
          this.Ijt.eYG = this.Ijr;
          if (!paramString.UvS.isEmpty()) {
            this.Ijs.addAll(paramString.UvS);
          }
          this.Ijt.alc.notifyChanged();
          AppMethodBeat.o(67710);
          return true;
        }
        paramq = getContext();
        if ((paramString == null) || (Util.isNullOrNil(paramString.tqb))) {}
        for (paramString = getString(a.i.wallet_data_err);; paramString = paramString.tqb)
        {
          w.makeText(paramq, paramString, 0).show();
          break;
        }
      }
      if ((paramq instanceof NetSceneMobileRemitGetRecvInfo))
      {
        paramString = ((NetSceneMobileRemitGetRecvInfo)paramq).fAc();
        if (paramString == null)
        {
          Log.e("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "NetSceneMobileRemitGetRecvInfo rcvrResp is null");
          AppMethodBeat.o(67710);
          return true;
        }
        paramq = ((NetSceneMobileRemitGetRecvInfo)paramq).IiQ;
        Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "NetSceneMobileRemitGetRecvInfo rcvrId:%s ret_code:%s ret_msg:%s", new Object[] { paramq, Integer.valueOf(paramString.tqa), paramString.tqb });
        if (paramString.tqa != 0)
        {
          if (paramString.IiP == 1)
          {
            localObject = this.Ijs.iterator();
            while (((Iterator)localObject).hasNext())
            {
              cjs localcjs = (cjs)((Iterator)localObject).next();
              if (Util.isEqual(localcjs.id, paramq)) {
                localcjs.IiP = 1;
              }
            }
            this.Ijt.alc.notifyChanged();
          }
          paramq = getContext();
          if (Util.isNullOrNil(paramString.tqb)) {}
          for (paramString = getString(a.i.wallet_data_err);; paramString = paramString.tqb)
          {
            h.a(paramq, paramString, "", getResources().getString(a.i.mobile_remit_confirm), false, null).show();
            AppMethodBeat.o(67710);
            return true;
          }
        }
        if (paramString.UvT != null)
        {
          Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "show remark or nickname change dialog!");
          l.a(this, paramString.UvT, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dS(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67691);
              Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "wxname_chg_win dialog click jumpItem.action:continue");
              com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitHistoryRecodUI.this.getContext(), paramString);
              AppMethodBeat.o(67691);
            }
            
            public final void fAl()
            {
              AppMethodBeat.i(67690);
              Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "wxname_chg_win dialog click jumpItem.action:exit");
              MobileRemitHistoryRecodUI.this.fAk();
              AppMethodBeat.o(67690);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(67710);
          return true;
          if (paramString.UvI != null)
          {
            Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "show free oneself from dialog!");
            l.a(this, paramString.UvI, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
            {
              public final void dS(Object paramAnonymousObject)
              {
                AppMethodBeat.i(67693);
                Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "jump_win dialog click jumpItem.action:continue");
                com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitHistoryRecodUI.this.getContext(), paramString);
                AppMethodBeat.o(67693);
              }
              
              public final void fAl()
              {
                AppMethodBeat.i(67692);
                Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "jump_win dialog click jumpItem.action:exit");
                MobileRemitHistoryRecodUI.this.fAk();
                AppMethodBeat.o(67692);
              }
            });
          }
          else
          {
            com.tencent.mm.plugin.remittance.mobile.a.b.a(getContext(), paramString);
          }
        }
      }
      if ((paramq instanceof c))
      {
        paramString = (c)paramq;
        if (paramString.IiK == null)
        {
          paramString = (String)localObject;
          if ((paramString == null) || (paramString.tqa != 0))
          {
            paramq = getContext();
            if ((paramString != null) && (!Util.isNullOrNil(paramString.tqb))) {
              break label618;
            }
          }
        }
        label618:
        for (paramString = getString(a.i.wallet_data_err);; paramString = paramString.tqb)
        {
          w.makeText(paramq, paramString, 0).show();
          AppMethodBeat.o(67710);
          return true;
          paramString = paramString.IiK;
          break;
        }
      }
    }
    else if (paramInt2 == 0)
    {
      localObject = getContext();
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = getString(a.i.mobile_remit_data_err);
      }
      w.makeText((Context)localObject, paramq, 0).show();
    }
    AppMethodBeat.o(67710);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI
 * JD-Core Version:    0.7.0.1
 */