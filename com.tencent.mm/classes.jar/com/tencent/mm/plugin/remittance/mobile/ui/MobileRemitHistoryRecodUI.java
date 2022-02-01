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
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.plugin.remittance.mobile.cgi.c;
import com.tencent.mm.protocal.protobuf.bof;
import com.tencent.mm.protocal.protobuf.dpd;
import com.tencent.mm.protocal.protobuf.dpf;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private LinearLayoutManager fPL;
  private int[] rwo;
  private RecyclerView xVB;
  private TextView xVC;
  private String xVD;
  private String xVE;
  private boolean xVF;
  private List<bof> xVG;
  private b xVH;
  private MobileRemitHistoryRecodUI.c xVI;
  private int xVJ;
  private Runnable xVK;
  
  public MobileRemitHistoryRecodUI()
  {
    AppMethodBeat.i(67706);
    this.xVD = null;
    this.xVE = null;
    this.xVF = false;
    this.xVG = new ArrayList();
    this.xVJ = 0;
    this.rwo = new int[2];
    this.xVK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67689);
        if ((MobileRemitHistoryRecodUI.h(MobileRemitHistoryRecodUI.this).getScrollState() == 0) && (!MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).cPV) && (MobileRemitHistoryRecodUI.g(MobileRemitHistoryRecodUI.this).ko() + 1 == MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount()))
        {
          ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "first screen refresh data!");
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
    this.xVB = ((RecyclerView)findViewById(2131302379));
    this.xVC = ((TextView)findViewById(2131302378));
    if (this.xVG.isEmpty())
    {
      this.xVB.setVisibility(8);
      this.xVC.setVisibility(0);
      AppMethodBeat.o(67708);
      return;
    }
    this.fPL = new LinearLayoutManager();
    this.fPL.setOrientation(1);
    this.xVB.setLayoutManager(this.fPL);
    this.xVI = new MobileRemitHistoryRecodUI.c(getContext());
    this.xVB.a(this.xVI);
    this.xVH = new b(getContext(), this.xVF, this.xVG, new d()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67684);
        ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv click!");
        paramAnonymousView = (bof)paramAnonymousView.getTag();
        if (paramAnonymousView.xVd != 0) {
          h.a(MobileRemitHistoryRecodUI.this.getContext(), MobileRemitHistoryRecodUI.this.getResources().getString(2131761274), "", MobileRemitHistoryRecodUI.this.getResources().getString(2131761269), false, null).show();
        }
        for (;;)
        {
          MobileRemitHistoryRecodUI.Oa(13);
          AppMethodBeat.o(67684);
          return;
          paramAnonymousView = new NetSceneMobileRemitGetRecvInfo("", paramAnonymousView.id, MobileRemitHistoryRecodUI.a(MobileRemitHistoryRecodUI.this), 2);
          MobileRemitHistoryRecodUI.this.doSceneProgress(paramAnonymousView, true);
        }
      }
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67685);
        ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv longclick!");
        final bof localbof = (bof)paramAnonymousView.getTag();
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
              ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "delete HisRcvr id:%s", new Object[] { localbof.id });
              paramAnonymous2MenuItem = new c(localbof.id);
              MobileRemitHistoryRecodUI.this.doSceneProgress(paramAnonymous2MenuItem, false);
              MobileRemitHistoryRecodUI.b(MobileRemitHistoryRecodUI.this).remove(localbof);
              MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).asY.notifyChanged();
              MobileRemitHistoryRecodUI.Oa(14);
            }
            AppMethodBeat.o(67683);
          }
        }, MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[0], MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[1]);
        AppMethodBeat.o(67685);
        return true;
      }
    });
    this.xVB.setAdapter(this.xVH);
    this.xVB.a(new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(67687);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousRecyclerView);
        localb.mr(paramAnonymousInt1);
        localb.mr(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
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
        localb.mr(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        ad.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv onScrollStateChanged() newState:%s mLastVisibleItem:%s isFinish:%s itemCount:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(MobileRemitHistoryRecodUI.e(MobileRemitHistoryRecodUI.this)), Boolean.valueOf(MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).cPV), Integer.valueOf(MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount()) });
        if ((paramAnonymousInt == 0) && (!MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).cPV) && (MobileRemitHistoryRecodUI.e(MobileRemitHistoryRecodUI.this) + 1 == MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount())) {
          MobileRemitHistoryRecodUI.f(MobileRemitHistoryRecodUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(67686);
      }
    });
    this.xVH.asY.notifyChanged();
    this.xVB.post(this.xVK);
    this.xVB.a(new MobileRemitHistoryRecodUI.4(this));
    this.xVB.setVisibility(0);
    this.xVC.setVisibility(8);
    AppMethodBeat.o(67708);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67707);
    super.onCreate(paramBundle);
    this.xVD = getIntent().getStringExtra("key_homepage_ext");
    this.xVF = getIntent().getBooleanExtra("key_finish", true);
    this.xVE = getIntent().getStringExtra("key_last_id");
    paramBundle = getIntent().getParcelableArrayListExtra("key_history_record");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.xVG.addAll(NetSceneMobileRemitGetRecord.fm(paramBundle));
    }
    ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "initData() mFinish:%s mLastId:%s mHisRecord.size:%s", new Object[] { Boolean.valueOf(this.xVF), this.xVE, Integer.valueOf(this.xVG.size()) });
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
    ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof NetSceneMobileRemitGetRecord))
      {
        paramString = ((NetSceneMobileRemitGetRecord)paramn).dIV();
        if ((paramString != null) && (paramString.ozR == 0))
        {
          this.xVE = paramString.HDp;
          this.xVF = paramString.bWS;
          this.xVH.cPV = this.xVF;
          if (!paramString.HDr.isEmpty()) {
            this.xVG.addAll(paramString.HDr);
          }
          this.xVH.asY.notifyChanged();
          AppMethodBeat.o(67710);
          return true;
        }
        paramn = getContext();
        if ((paramString == null) || (bt.isNullOrNil(paramString.ozS))) {}
        for (paramString = getString(2131765224);; paramString = paramString.ozS)
        {
          t.makeText(paramn, paramString, 0).show();
          break;
        }
      }
      if ((paramn instanceof NetSceneMobileRemitGetRecvInfo))
      {
        paramString = ((NetSceneMobileRemitGetRecvInfo)paramn).dIW();
        if (paramString == null)
        {
          ad.e("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "NetSceneMobileRemitGetRecvInfo rcvrResp is null");
          AppMethodBeat.o(67710);
          return true;
        }
        paramn = ((NetSceneMobileRemitGetRecvInfo)paramn).xVe;
        ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "NetSceneMobileRemitGetRecvInfo rcvrId:%s ret_code:%s ret_msg:%s", new Object[] { paramn, Integer.valueOf(paramString.ozR), paramString.ozS });
        if (paramString.ozR != 0)
        {
          if (paramString.xVd == 1)
          {
            localObject = this.xVG.iterator();
            while (((Iterator)localObject).hasNext())
            {
              bof localbof = (bof)((Iterator)localObject).next();
              if (bt.lQ(localbof.id, paramn)) {
                localbof.xVd = 1;
              }
            }
            this.xVH.asY.notifyChanged();
          }
          paramn = getContext();
          if (bt.isNullOrNil(paramString.ozS)) {}
          for (paramString = getString(2131765224);; paramString = paramString.ozS)
          {
            h.a(paramn, paramString, "", getResources().getString(2131761269), false, null).show();
            AppMethodBeat.o(67710);
            return true;
          }
        }
        if (paramString.HDs != null)
        {
          ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "show remark or nickname change dialog!");
          l.a(this, paramString.HDs, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dF(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67691);
              ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "wxname_chg_win dialog click jumpItem.action:continue");
              com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitHistoryRecodUI.this.getContext(), paramString);
              AppMethodBeat.o(67691);
            }
            
            public final void dJf()
            {
              AppMethodBeat.i(67690);
              ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "wxname_chg_win dialog click jumpItem.action:exit");
              MobileRemitHistoryRecodUI.this.dJe();
              AppMethodBeat.o(67690);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(67710);
          return true;
          if (paramString.HDh != null)
          {
            ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "show free oneself from dialog!");
            l.a(this, paramString.HDh, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
            {
              public final void dF(Object paramAnonymousObject)
              {
                AppMethodBeat.i(67693);
                ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "jump_win dialog click jumpItem.action:continue");
                com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitHistoryRecodUI.this.getContext(), paramString);
                AppMethodBeat.o(67693);
              }
              
              public final void dJf()
              {
                AppMethodBeat.i(67692);
                ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "jump_win dialog click jumpItem.action:exit");
                MobileRemitHistoryRecodUI.this.dJe();
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
        if (paramString.xUY == null)
        {
          paramString = null;
          if ((paramString == null) || (paramString.ozR != 0))
          {
            paramn = getContext();
            if ((paramString != null) && (!bt.isNullOrNil(paramString.ozS))) {
              break label614;
            }
          }
        }
        label614:
        for (paramString = getString(2131765224);; paramString = paramString.ozS)
        {
          t.makeText(paramn, paramString, 0).show();
          AppMethodBeat.o(67710);
          return true;
          paramString = paramString.xUY;
          break;
        }
      }
    }
    else if (paramInt2 == 0)
    {
      localObject = getContext();
      paramn = paramString;
      if (bt.isNullOrNil(paramString)) {
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
    View fOB;
    
    public a(View paramView)
    {
      super();
      this.fOB = paramView;
    }
  }
  
  public static final class b
    extends RecyclerView.a
  {
    boolean cPV;
    private Context context;
    private List<bof> xVP;
    private int xVQ;
    private int xVR;
    private int xVS;
    private MobileRemitHistoryRecodUI.d xVT;
    
    public b(Context paramContext, boolean paramBoolean, List<bof> paramList, MobileRemitHistoryRecodUI.d paramd)
    {
      AppMethodBeat.i(67697);
      this.context = paramContext;
      this.cPV = paramBoolean;
      this.xVP = paramList;
      this.xVT = paramd;
      this.xVQ = paramContext.getResources().getColor(2131100021);
      this.xVR = paramContext.getResources().getColor(2131099662);
      this.xVS = paramContext.getResources().getColor(2131099660);
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
        if ((this.xVP != null) && (paramInt >= 0) && (paramInt < this.xVP.size()))
        {
          paramw = (MobileRemitHistoryRecodUI.e)paramw;
          final bof localbof = (bof)this.xVP.get(paramInt);
          ad.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "onBindViewHolder() i:%s invalid:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localbof.xVd) });
          paramw.fOB.setVisibility(0);
          paramw.xVW.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(67694);
              int i = paramw.xVW.getMeasuredWidth();
              if (i != 0)
              {
                float f1 = paramw.jcd.getPaint().measureText(localbof.xVb);
                float f2 = paramw.xVX.getPaint().measureText(localbof.xVc);
                int j = com.tencent.mm.cc.a.fromDPToPix(MobileRemitHistoryRecodUI.b.a(MobileRemitHistoryRecodUI.b.this), 14);
                if (f1 + f2 + j > i)
                {
                  LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramw.jcd.getLayoutParams();
                  localLayoutParams.width = ((int)(i - f2 - j));
                  paramw.jcd.setLayoutParams(localLayoutParams);
                }
              }
              paramw.jcd.setText(localbof.xVb);
              paramw.xVX.setText(localbof.xVc);
              AppMethodBeat.o(67694);
            }
          });
          paramw.mjy.setText(localbof.oyb);
          if (localbof.xVd == 0)
          {
            paramw.jcd.setTextColor(this.xVQ);
            paramw.xVX.setTextColor(this.xVQ);
            paramw.mjy.setTextColor(this.xVR);
            paramw.xTX.setVisibility(8);
          }
          for (;;)
          {
            paramw.fOB.setTag(localbof);
            paramw.fOB.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(67695);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                if (MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this) != null) {
                  MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this).onClick(paramAnonymousView);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67695);
              }
            });
            paramw.fOB.setOnLongClickListener(new View.OnLongClickListener()
            {
              public final boolean onLongClick(View paramAnonymousView)
              {
                AppMethodBeat.i(67696);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
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
            paramw.jcd.setTextColor(this.xVS);
            paramw.xVX.setTextColor(this.xVS);
            paramw.mjy.setTextColor(this.xVS);
            paramw.xTX.setVisibility(0);
          }
        }
      }
      else
      {
        paramw = (MobileRemitHistoryRecodUI.a)paramw;
        if (this.cPV)
        {
          paramw.fOB.setVisibility(8);
          AppMethodBeat.o(67699);
          return;
        }
        paramw.fOB.setVisibility(0);
      }
      AppMethodBeat.o(67699);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(67701);
      if (this.cPV)
      {
        i = this.xVP.size();
        AppMethodBeat.o(67701);
        return i;
      }
      int i = this.xVP.size();
      AppMethodBeat.o(67701);
      return i + 1;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(67700);
      if (this.cPV)
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
    View fOB;
    TextView jcd;
    TextView mjy;
    TextView xTX;
    LinearLayout xVW;
    TextView xVX;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(67705);
      this.fOB = paramView;
      this.xVW = ((LinearLayout)paramView.findViewById(2131302660));
      this.jcd = ((TextView)paramView.findViewById(2131302867));
      this.xVX = ((TextView)paramView.findViewById(2131303802));
      this.mjy = ((TextView)paramView.findViewById(2131303236));
      this.xTX = ((TextView)paramView.findViewById(2131305192));
      AppMethodBeat.o(67705);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI
 * JD-Core Version:    0.7.0.1
 */