package com.tencent.mm.plugin.remittance.mobile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
import android.text.TextPaint;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.plugin.remittance.mobile.cgi.c;
import com.tencent.mm.protocal.protobuf.box;
import com.tencent.mm.protocal.protobuf.dqa;
import com.tencent.mm.protocal.protobuf.dqc;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.c.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MobileRemitHistoryRecodUI
  extends MobileRemitBaseUI
{
  private LinearLayoutManager fRR;
  private int[] rEA;
  private b ylA;
  private MobileRemitHistoryRecodUI.c ylB;
  private int ylC;
  private Runnable ylD;
  private RecyclerView ylu;
  private TextView ylv;
  private String ylw;
  private String ylx;
  private boolean yly;
  private List<box> ylz;
  
  public MobileRemitHistoryRecodUI()
  {
    AppMethodBeat.i(67706);
    this.ylw = null;
    this.ylx = null;
    this.yly = false;
    this.ylz = new ArrayList();
    this.ylC = 0;
    this.rEA = new int[2];
    this.ylD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67689);
        if ((MobileRemitHistoryRecodUI.h(MobileRemitHistoryRecodUI.this).getScrollState() == 0) && (!MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).cQF) && (MobileRemitHistoryRecodUI.g(MobileRemitHistoryRecodUI.this).ko() + 1 == MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount()))
        {
          ae.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "first screen refresh data!");
          MobileRemitHistoryRecodUI.f(MobileRemitHistoryRecodUI.this);
        }
        AppMethodBeat.o(67689);
      }
    };
    AppMethodBeat.o(67706);
  }
  
  public int getLayoutId()
  {
    return 2131494927;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67708);
    super.initView();
    setMMTitle(getString(2131761276));
    setBackBtn(new MobileRemitHistoryRecodUI.1(this));
    this.ylu = ((RecyclerView)findViewById(2131302379));
    this.ylv = ((TextView)findViewById(2131302378));
    if (this.ylz.isEmpty())
    {
      this.ylu.setVisibility(8);
      this.ylv.setVisibility(0);
      AppMethodBeat.o(67708);
      return;
    }
    this.fRR = new LinearLayoutManager();
    this.fRR.setOrientation(1);
    this.ylu.setLayoutManager(this.fRR);
    this.ylB = new MobileRemitHistoryRecodUI.c(getContext());
    this.ylu.a(this.ylB);
    this.ylA = new b(getContext(), this.yly, this.ylz, new d()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67684);
        ae.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv click!");
        paramAnonymousView = (box)paramAnonymousView.getTag();
        if (paramAnonymousView.ykW != 0) {
          h.a(MobileRemitHistoryRecodUI.this.getContext(), MobileRemitHistoryRecodUI.this.getResources().getString(2131761274), "", MobileRemitHistoryRecodUI.this.getResources().getString(2131761269), false, null).show();
        }
        for (;;)
        {
          MobileRemitHistoryRecodUI.OG(13);
          AppMethodBeat.o(67684);
          return;
          paramAnonymousView = new NetSceneMobileRemitGetRecvInfo("", paramAnonymousView.id, MobileRemitHistoryRecodUI.a(MobileRemitHistoryRecodUI.this), 2);
          MobileRemitHistoryRecodUI.this.doSceneProgress(paramAnonymousView, true);
        }
      }
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67685);
        ae.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv longclick!");
        final box localbox = (box)paramAnonymousView.getTag();
        new com.tencent.mm.ui.widget.b.a(MobileRemitHistoryRecodUI.this, paramAnonymousView).a(paramAnonymousView, new View.OnCreateContextMenuListener()new n.e
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(67682);
            paramAnonymous2ContextMenu.add(0, 0, 0, 2131755707);
            AppMethodBeat.o(67682);
          }
        }, new n.e()
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
              ae.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "delete HisRcvr id:%s", new Object[] { localbox.id });
              paramAnonymous2MenuItem = new c(localbox.id);
              MobileRemitHistoryRecodUI.this.doSceneProgress(paramAnonymous2MenuItem, false);
              MobileRemitHistoryRecodUI.b(MobileRemitHistoryRecodUI.this).remove(localbox);
              MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).asY.notifyChanged();
              MobileRemitHistoryRecodUI.OG(14);
            }
            AppMethodBeat.o(67683);
          }
        }, MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[0], MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[1]);
        AppMethodBeat.o(67685);
        return true;
      }
    });
    this.ylu.setAdapter(this.ylA);
    this.ylu.a(new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(67687);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt1);
        localb.mu(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        MobileRemitHistoryRecodUI.a(MobileRemitHistoryRecodUI.this, MobileRemitHistoryRecodUI.g(MobileRemitHistoryRecodUI.this).ko());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(67687);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(67686);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mu(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        ae.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv onScrollStateChanged() newState:%s mLastVisibleItem:%s isFinish:%s itemCount:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(MobileRemitHistoryRecodUI.e(MobileRemitHistoryRecodUI.this)), Boolean.valueOf(MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).cQF), Integer.valueOf(MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount()) });
        if ((paramAnonymousInt == 0) && (!MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).cQF) && (MobileRemitHistoryRecodUI.e(MobileRemitHistoryRecodUI.this) + 1 == MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount())) {
          MobileRemitHistoryRecodUI.f(MobileRemitHistoryRecodUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(67686);
      }
    });
    this.ylA.asY.notifyChanged();
    this.ylu.post(this.ylD);
    this.ylu.a(new MobileRemitHistoryRecodUI.4(this));
    this.ylu.setVisibility(0);
    this.ylv.setVisibility(8);
    AppMethodBeat.o(67708);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67707);
    super.onCreate(paramBundle);
    this.ylw = getIntent().getStringExtra("key_homepage_ext");
    this.yly = getIntent().getBooleanExtra("key_finish", true);
    this.ylx = getIntent().getStringExtra("key_last_id");
    paramBundle = getIntent().getParcelableArrayListExtra("key_history_record");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.ylz.addAll(NetSceneMobileRemitGetRecord.fu(paramBundle));
    }
    ae.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "initData() mFinish:%s mLastId:%s mHisRecord.size:%s", new Object[] { Boolean.valueOf(this.yly), this.ylx, Integer.valueOf(this.ylz.size()) });
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(67710);
    ae.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof NetSceneMobileRemitGetRecord))
      {
        paramString = ((NetSceneMobileRemitGetRecord)paramn).dMm();
        if ((paramString != null) && (paramString.oGt == 0))
        {
          this.ylx = paramString.HXc;
          this.yly = paramString.bWS;
          this.ylA.cQF = this.yly;
          if (!paramString.HXe.isEmpty()) {
            this.ylz.addAll(paramString.HXe);
          }
          this.ylA.asY.notifyChanged();
          AppMethodBeat.o(67710);
          return true;
        }
        paramn = getContext();
        if ((paramString == null) || (bu.isNullOrNil(paramString.oGu))) {}
        for (paramString = getString(2131765224);; paramString = paramString.oGu)
        {
          t.makeText(paramn, paramString, 0).show();
          break;
        }
      }
      if ((paramn instanceof NetSceneMobileRemitGetRecvInfo))
      {
        paramString = ((NetSceneMobileRemitGetRecvInfo)paramn).dMn();
        if (paramString == null)
        {
          ae.e("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "NetSceneMobileRemitGetRecvInfo rcvrResp is null");
          AppMethodBeat.o(67710);
          return true;
        }
        paramn = ((NetSceneMobileRemitGetRecvInfo)paramn).ykX;
        ae.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "NetSceneMobileRemitGetRecvInfo rcvrId:%s ret_code:%s ret_msg:%s", new Object[] { paramn, Integer.valueOf(paramString.oGt), paramString.oGu });
        if (paramString.oGt != 0)
        {
          if (paramString.ykW == 1)
          {
            localObject = this.ylz.iterator();
            while (((Iterator)localObject).hasNext())
            {
              box localbox = (box)((Iterator)localObject).next();
              if (bu.lX(localbox.id, paramn)) {
                localbox.ykW = 1;
              }
            }
            this.ylA.asY.notifyChanged();
          }
          paramn = getContext();
          if (bu.isNullOrNil(paramString.oGu)) {}
          for (paramString = getString(2131765224);; paramString = paramString.oGu)
          {
            h.a(paramn, paramString, "", getResources().getString(2131761269), false, null).show();
            AppMethodBeat.o(67710);
            return true;
          }
        }
        if (paramString.HXf != null)
        {
          ae.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "show remark or nickname change dialog!");
          l.a(this, paramString.HXf, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dG(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67691);
              ae.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "wxname_chg_win dialog click jumpItem.action:continue");
              com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitHistoryRecodUI.this.getContext(), paramString);
              AppMethodBeat.o(67691);
            }
            
            public final void dMw()
            {
              AppMethodBeat.i(67690);
              ae.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "wxname_chg_win dialog click jumpItem.action:exit");
              MobileRemitHistoryRecodUI.this.dMv();
              AppMethodBeat.o(67690);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(67710);
          return true;
          if (paramString.HWU != null)
          {
            ae.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "show free oneself from dialog!");
            l.a(this, paramString.HWU, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
            {
              public final void dG(Object paramAnonymousObject)
              {
                AppMethodBeat.i(67693);
                ae.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "jump_win dialog click jumpItem.action:continue");
                com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitHistoryRecodUI.this.getContext(), paramString);
                AppMethodBeat.o(67693);
              }
              
              public final void dMw()
              {
                AppMethodBeat.i(67692);
                ae.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "jump_win dialog click jumpItem.action:exit");
                MobileRemitHistoryRecodUI.this.dMv();
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
      if ((paramn instanceof c))
      {
        paramString = (c)paramn;
        if (paramString.ykR == null)
        {
          paramString = null;
          if ((paramString == null) || (paramString.oGt != 0))
          {
            paramn = getContext();
            if ((paramString != null) && (!bu.isNullOrNil(paramString.oGu))) {
              break label614;
            }
          }
        }
        label614:
        for (paramString = getString(2131765224);; paramString = paramString.oGu)
        {
          t.makeText(paramn, paramString, 0).show();
          AppMethodBeat.o(67710);
          return true;
          paramString = paramString.ykR;
          break;
        }
      }
    }
    else if (paramInt2 == 0)
    {
      localObject = getContext();
      paramn = paramString;
      if (bu.isNullOrNil(paramString)) {
        paramn = getString(2131761270);
      }
      t.makeText((Context)localObject, paramn, 0).show();
    }
    AppMethodBeat.o(67710);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static final class a
    extends RecyclerView.w
  {
    View fQH;
    
    public a(View paramView)
    {
      super();
      this.fQH = paramView;
    }
  }
  
  public static final class b
    extends RecyclerView.a
  {
    boolean cQF;
    private Context context;
    private List<box> ylI;
    private int ylJ;
    private int ylK;
    private int ylL;
    private MobileRemitHistoryRecodUI.d ylM;
    
    public b(Context paramContext, boolean paramBoolean, List<box> paramList, MobileRemitHistoryRecodUI.d paramd)
    {
      AppMethodBeat.i(67697);
      this.context = paramContext;
      this.cQF = paramBoolean;
      this.ylI = paramList;
      this.ylM = paramd;
      this.ylJ = paramContext.getResources().getColor(2131100021);
      this.ylK = paramContext.getResources().getColor(2131099662);
      this.ylL = paramContext.getResources().getColor(2131099660);
      AppMethodBeat.o(67697);
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(67698);
      if (paramInt == 0)
      {
        paramViewGroup = new MobileRemitHistoryRecodUI.e(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494928, paramViewGroup, false));
        AppMethodBeat.o(67698);
        return paramViewGroup;
      }
      paramViewGroup = new MobileRemitHistoryRecodUI.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494929, paramViewGroup, false));
      AppMethodBeat.o(67698);
      return paramViewGroup;
    }
    
    public final void a(final RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(67699);
      if ((paramw instanceof MobileRemitHistoryRecodUI.e))
      {
        if ((this.ylI != null) && (paramInt >= 0) && (paramInt < this.ylI.size()))
        {
          paramw = (MobileRemitHistoryRecodUI.e)paramw;
          final box localbox = (box)this.ylI.get(paramInt);
          ae.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "onBindViewHolder() i:%s invalid:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localbox.ykW) });
          paramw.fQH.setVisibility(0);
          paramw.ylP.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(67694);
              int i = paramw.ylP.getMeasuredWidth();
              if (i != 0)
              {
                float f1 = paramw.jeW.getPaint().measureText(localbox.ykU);
                float f2 = paramw.ylQ.getPaint().measureText(localbox.ykV);
                int j = com.tencent.mm.cb.a.fromDPToPix(MobileRemitHistoryRecodUI.b.a(MobileRemitHistoryRecodUI.b.this), 14);
                if (f1 + f2 + j > i)
                {
                  LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramw.jeW.getLayoutParams();
                  localLayoutParams.width = ((int)(i - f2 - j));
                  paramw.jeW.setLayoutParams(localLayoutParams);
                }
              }
              paramw.jeW.setText(localbox.ykU);
              paramw.ylQ.setText(localbox.ykV);
              AppMethodBeat.o(67694);
            }
          });
          paramw.mov.setText(localbox.oED);
          if (localbox.ykW == 0)
          {
            paramw.jeW.setTextColor(this.ylJ);
            paramw.ylQ.setTextColor(this.ylJ);
            paramw.mov.setTextColor(this.ylK);
            paramw.yjQ.setVisibility(8);
          }
          for (;;)
          {
            paramw.fQH.setTag(localbox);
            paramw.fQH.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(67695);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                if (MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this) != null) {
                  MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this).onClick(paramAnonymousView);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67695);
              }
            });
            paramw.fQH.setOnLongClickListener(new View.OnLongClickListener()
            {
              public final boolean onLongClick(View paramAnonymousView)
              {
                AppMethodBeat.i(67696);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
                if (MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this) != null)
                {
                  boolean bool = MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this).onLongClick(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                  AppMethodBeat.o(67696);
                  return bool;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(67696);
                return false;
              }
            });
            AppMethodBeat.o(67699);
            return;
            paramw.jeW.setTextColor(this.ylL);
            paramw.ylQ.setTextColor(this.ylL);
            paramw.mov.setTextColor(this.ylL);
            paramw.yjQ.setVisibility(0);
          }
        }
      }
      else
      {
        paramw = (MobileRemitHistoryRecodUI.a)paramw;
        if (this.cQF)
        {
          paramw.fQH.setVisibility(8);
          AppMethodBeat.o(67699);
          return;
        }
        paramw.fQH.setVisibility(0);
      }
      AppMethodBeat.o(67699);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(67701);
      if (this.cQF)
      {
        i = this.ylI.size();
        AppMethodBeat.o(67701);
        return i;
      }
      int i = this.ylI.size();
      AppMethodBeat.o(67701);
      return i + 1;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(67700);
      if (this.cQF)
      {
        AppMethodBeat.o(67700);
        return 0;
      }
      if (paramInt == getItemCount() - 1)
      {
        AppMethodBeat.o(67700);
        return 1;
      }
      AppMethodBeat.o(67700);
      return 0;
    }
  }
  
  static abstract interface d
  {
    public abstract void onClick(View paramView);
    
    public abstract boolean onLongClick(View paramView);
  }
  
  public static final class e
    extends RecyclerView.w
  {
    View fQH;
    TextView jeW;
    TextView mov;
    TextView yjQ;
    LinearLayout ylP;
    TextView ylQ;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(67705);
      this.fQH = paramView;
      this.ylP = ((LinearLayout)paramView.findViewById(2131302660));
      this.jeW = ((TextView)paramView.findViewById(2131302867));
      this.ylQ = ((TextView)paramView.findViewById(2131303802));
      this.mov = ((TextView)paramView.findViewById(2131303236));
      this.yjQ = ((TextView)paramView.findViewById(2131305192));
      AppMethodBeat.o(67705);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI
 * JD-Core Version:    0.7.0.1
 */