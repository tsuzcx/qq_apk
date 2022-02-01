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
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.protocal.protobuf.bgf;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.protocal.protobuf.deb;
import com.tencent.mm.protocal.protobuf.ded;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
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
  private LinearLayoutManager fsR;
  private int[] qdJ;
  private RecyclerView vxP;
  private TextView vxQ;
  private String vxR;
  private String vxS;
  private boolean vxT;
  private List<bgf> vxU;
  private b vxV;
  private MobileRemitHistoryRecodUI.c vxW;
  private int vxX;
  private Runnable vxY;
  
  public MobileRemitHistoryRecodUI()
  {
    AppMethodBeat.i(67706);
    this.vxR = null;
    this.vxS = null;
    this.vxT = false;
    this.vxU = new ArrayList();
    this.vxX = 0;
    this.qdJ = new int[2];
    this.vxY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67689);
        if ((MobileRemitHistoryRecodUI.h(MobileRemitHistoryRecodUI.this).getScrollState() == 0) && (!MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).cHI) && (MobileRemitHistoryRecodUI.g(MobileRemitHistoryRecodUI.this).jQ() + 1 == MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount()))
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
    this.vxP = ((RecyclerView)findViewById(2131302379));
    this.vxQ = ((TextView)findViewById(2131302378));
    if (this.vxU.isEmpty())
    {
      this.vxP.setVisibility(8);
      this.vxQ.setVisibility(0);
      AppMethodBeat.o(67708);
      return;
    }
    this.fsR = new LinearLayoutManager();
    this.fsR.setOrientation(1);
    this.vxP.setLayoutManager(this.fsR);
    this.vxW = new MobileRemitHistoryRecodUI.c(getContext());
    this.vxP.a(this.vxW);
    this.vxV = new b(getContext(), this.vxT, this.vxU, new d()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67684);
        ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv click!");
        paramAnonymousView = (bgf)paramAnonymousView.getTag();
        if (paramAnonymousView.vxr != 0) {
          h.a(MobileRemitHistoryRecodUI.this.getContext(), MobileRemitHistoryRecodUI.this.getResources().getString(2131761274), "", MobileRemitHistoryRecodUI.this.getResources().getString(2131761269), false, null).show();
        }
        for (;;)
        {
          MobileRemitHistoryRecodUI.Kz(13);
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
        final bgf localbgf = (bgf)paramAnonymousView.getTag();
        new com.tencent.mm.ui.widget.b.a(MobileRemitHistoryRecodUI.this, paramAnonymousView).a(paramAnonymousView, new View.OnCreateContextMenuListener()new n.d
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(67682);
            paramAnonymous2ContextMenu.add(0, 0, 0, 2131755707);
            AppMethodBeat.o(67682);
          }
        }, new n.d()
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
              ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "delete HisRcvr id:%s", new Object[] { localbgf.id });
              paramAnonymous2MenuItem = new c(localbgf.id);
              MobileRemitHistoryRecodUI.this.doSceneProgress(paramAnonymous2MenuItem, false);
              MobileRemitHistoryRecodUI.b(MobileRemitHistoryRecodUI.this).remove(localbgf);
              MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).aql.notifyChanged();
              MobileRemitHistoryRecodUI.Kz(14);
            }
            AppMethodBeat.o(67683);
          }
        }, MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[0], MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[1]);
        AppMethodBeat.o(67685);
        return true;
      }
    });
    this.vxP.setAdapter(this.vxV);
    this.vxP.a(new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(67687);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt1);
        localb.lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        MobileRemitHistoryRecodUI.a(MobileRemitHistoryRecodUI.this, MobileRemitHistoryRecodUI.g(MobileRemitHistoryRecodUI.this).jQ());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(67687);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(67686);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        ad.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv onScrollStateChanged() newState:%s mLastVisibleItem:%s isFinish:%s itemCount:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(MobileRemitHistoryRecodUI.e(MobileRemitHistoryRecodUI.this)), Boolean.valueOf(MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).cHI), Integer.valueOf(MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount()) });
        if ((paramAnonymousInt == 0) && (!MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).cHI) && (MobileRemitHistoryRecodUI.e(MobileRemitHistoryRecodUI.this) + 1 == MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount())) {
          MobileRemitHistoryRecodUI.f(MobileRemitHistoryRecodUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(67686);
      }
    });
    this.vxV.aql.notifyChanged();
    this.vxP.post(this.vxY);
    this.vxP.a(new MobileRemitHistoryRecodUI.4(this));
    this.vxP.setVisibility(0);
    this.vxQ.setVisibility(8);
    AppMethodBeat.o(67708);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67707);
    super.onCreate(paramBundle);
    this.vxR = getIntent().getStringExtra("key_homepage_ext");
    this.vxT = getIntent().getBooleanExtra("key_finish", true);
    this.vxS = getIntent().getStringExtra("key_last_id");
    paramBundle = getIntent().getParcelableArrayListExtra("key_history_record");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.vxU.addAll(NetSceneMobileRemitGetRecord.eT(paramBundle));
    }
    ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "initData() mFinish:%s mLastId:%s mHisRecord.size:%s", new Object[] { Boolean.valueOf(this.vxT), this.vxS, Integer.valueOf(this.vxU.size()) });
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
        paramString = ((NetSceneMobileRemitGetRecord)paramn).djB();
        if ((paramString != null) && (paramString.ntx == 0))
        {
          this.vxS = paramString.EvD;
          this.vxT = paramString.bOX;
          this.vxV.cHI = this.vxT;
          if (!paramString.EvF.isEmpty()) {
            this.vxU.addAll(paramString.EvF);
          }
          this.vxV.aql.notifyChanged();
          AppMethodBeat.o(67710);
          return true;
        }
        paramn = getContext();
        if ((paramString == null) || (bt.isNullOrNil(paramString.nty))) {}
        for (paramString = getString(2131765224);; paramString = paramString.nty)
        {
          t.makeText(paramn, paramString, 0).show();
          break;
        }
      }
      if ((paramn instanceof NetSceneMobileRemitGetRecvInfo))
      {
        paramString = ((NetSceneMobileRemitGetRecvInfo)paramn).djC();
        if (paramString == null)
        {
          ad.e("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "NetSceneMobileRemitGetRecvInfo rcvrResp is null");
          AppMethodBeat.o(67710);
          return true;
        }
        paramn = ((NetSceneMobileRemitGetRecvInfo)paramn).vxs;
        ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "NetSceneMobileRemitGetRecvInfo rcvrId:%s ret_code:%s ret_msg:%s", new Object[] { paramn, Integer.valueOf(paramString.ntx), paramString.nty });
        if (paramString.ntx != 0)
        {
          if (paramString.vxr == 1)
          {
            localObject = this.vxU.iterator();
            while (((Iterator)localObject).hasNext())
            {
              bgf localbgf = (bgf)((Iterator)localObject).next();
              if (bt.kU(localbgf.id, paramn)) {
                localbgf.vxr = 1;
              }
            }
            this.vxV.aql.notifyChanged();
          }
          paramn = getContext();
          if (bt.isNullOrNil(paramString.nty)) {}
          for (paramString = getString(2131765224);; paramString = paramString.nty)
          {
            h.a(paramn, paramString, "", getResources().getString(2131761269), false, null).show();
            AppMethodBeat.o(67710);
            return true;
          }
        }
        if (paramString.EvG != null)
        {
          ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "show remark or nickname change dialog!");
          l.a(this, paramString.EvG, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dB(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67691);
              ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "wxname_chg_win dialog click jumpItem.action:continue");
              com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitHistoryRecodUI.this.getContext(), paramString);
              AppMethodBeat.o(67691);
            }
            
            public final void djL()
            {
              AppMethodBeat.i(67690);
              ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "wxname_chg_win dialog click jumpItem.action:exit");
              MobileRemitHistoryRecodUI.this.djK();
              AppMethodBeat.o(67690);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(67710);
          return true;
          if (paramString.Evv != null)
          {
            ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "show free oneself from dialog!");
            l.a(this, paramString.Evv, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
            {
              public final void dB(Object paramAnonymousObject)
              {
                AppMethodBeat.i(67693);
                ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "jump_win dialog click jumpItem.action:continue");
                com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitHistoryRecodUI.this.getContext(), paramString);
                AppMethodBeat.o(67693);
              }
              
              public final void djL()
              {
                AppMethodBeat.i(67692);
                ad.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "jump_win dialog click jumpItem.action:exit");
                MobileRemitHistoryRecodUI.this.djK();
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
        if (paramString.vxm == null)
        {
          paramString = null;
          if ((paramString == null) || (paramString.ntx != 0))
          {
            paramn = getContext();
            if ((paramString != null) && (!bt.isNullOrNil(paramString.nty))) {
              break label614;
            }
          }
        }
        label614:
        for (paramString = getString(2131765224);; paramString = paramString.nty)
        {
          t.makeText(paramn, paramString, 0).show();
          AppMethodBeat.o(67710);
          return true;
          paramString = paramString.vxm;
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
    extends RecyclerView.v
  {
    View frN;
    
    public a(View paramView)
    {
      super();
      this.frN = paramView;
    }
  }
  
  public static final class b
    extends RecyclerView.a
  {
    boolean cHI;
    private Context context;
    private List<bgf> vyd;
    private int vye;
    private int vyf;
    private int vyg;
    private MobileRemitHistoryRecodUI.d vyh;
    
    public b(Context paramContext, boolean paramBoolean, List<bgf> paramList, MobileRemitHistoryRecodUI.d paramd)
    {
      AppMethodBeat.i(67697);
      this.context = paramContext;
      this.cHI = paramBoolean;
      this.vyd = paramList;
      this.vyh = paramd;
      this.vye = paramContext.getResources().getColor(2131100021);
      this.vyf = paramContext.getResources().getColor(2131099662);
      this.vyg = paramContext.getResources().getColor(2131099660);
      AppMethodBeat.o(67697);
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
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
    
    public final void a(final RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(67699);
      if ((paramv instanceof MobileRemitHistoryRecodUI.e))
      {
        if ((this.vyd != null) && (paramInt >= 0) && (paramInt < this.vyd.size()))
        {
          paramv = (MobileRemitHistoryRecodUI.e)paramv;
          final bgf localbgf = (bgf)this.vyd.get(paramInt);
          ad.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "onBindViewHolder() i:%s invalid:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localbgf.vxr) });
          paramv.frN.setVisibility(0);
          paramv.vyk.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(67694);
              int i = paramv.vyk.getMeasuredWidth();
              if (i != 0)
              {
                float f1 = paramv.iiN.getPaint().measureText(localbgf.vxp);
                float f2 = paramv.vyl.getPaint().measureText(localbgf.vxq);
                int j = com.tencent.mm.cd.a.fromDPToPix(MobileRemitHistoryRecodUI.b.a(MobileRemitHistoryRecodUI.b.this), 14);
                if (f1 + f2 + j > i)
                {
                  LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramv.iiN.getLayoutParams();
                  localLayoutParams.width = ((int)(i - f2 - j));
                  paramv.iiN.setLayoutParams(localLayoutParams);
                }
              }
              paramv.iiN.setText(localbgf.vxp);
              paramv.vyl.setText(localbgf.vxq);
              AppMethodBeat.o(67694);
            }
          });
          paramv.ljT.setText(localbgf.nrG);
          if (localbgf.vxr == 0)
          {
            paramv.iiN.setTextColor(this.vye);
            paramv.vyl.setTextColor(this.vye);
            paramv.ljT.setTextColor(this.vyf);
            paramv.vwl.setVisibility(8);
          }
          for (;;)
          {
            paramv.frN.setTag(localbgf);
            paramv.frN.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(67695);
                if (MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this) != null) {
                  MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this).onClick(paramAnonymousView);
                }
                AppMethodBeat.o(67695);
              }
            });
            paramv.frN.setOnLongClickListener(new View.OnLongClickListener()
            {
              public final boolean onLongClick(View paramAnonymousView)
              {
                AppMethodBeat.i(67696);
                if (MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this) != null)
                {
                  boolean bool = MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this).onLongClick(paramAnonymousView);
                  AppMethodBeat.o(67696);
                  return bool;
                }
                AppMethodBeat.o(67696);
                return false;
              }
            });
            AppMethodBeat.o(67699);
            return;
            paramv.iiN.setTextColor(this.vyg);
            paramv.vyl.setTextColor(this.vyg);
            paramv.ljT.setTextColor(this.vyg);
            paramv.vwl.setVisibility(0);
          }
        }
      }
      else
      {
        paramv = (MobileRemitHistoryRecodUI.a)paramv;
        if (this.cHI)
        {
          paramv.frN.setVisibility(8);
          AppMethodBeat.o(67699);
          return;
        }
        paramv.frN.setVisibility(0);
      }
      AppMethodBeat.o(67699);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(67701);
      if (this.cHI)
      {
        i = this.vyd.size();
        AppMethodBeat.o(67701);
        return i;
      }
      int i = this.vyd.size();
      AppMethodBeat.o(67701);
      return i + 1;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(67700);
      if (this.cHI)
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
    extends RecyclerView.v
  {
    View frN;
    TextView iiN;
    TextView ljT;
    TextView vwl;
    LinearLayout vyk;
    TextView vyl;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(67705);
      this.frN = paramView;
      this.vyk = ((LinearLayout)paramView.findViewById(2131302660));
      this.iiN = ((TextView)paramView.findViewById(2131302867));
      this.vyl = ((TextView)paramView.findViewById(2131303802));
      this.ljT = ((TextView)paramView.findViewById(2131303236));
      this.vwl = ((TextView)paramView.findViewById(2131305192));
      AppMethodBeat.o(67705);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI
 * JD-Core Version:    0.7.0.1
 */