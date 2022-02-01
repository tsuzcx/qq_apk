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
import android.support.v7.widget.RecyclerView.l;
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
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.plugin.remittance.mobile.cgi.c;
import com.tencent.mm.protocal.protobuf.cbp;
import com.tencent.mm.protocal.protobuf.ejw;
import com.tencent.mm.protocal.protobuf.ejy;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.c.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MobileRemitHistoryRecodUI
  extends MobileRemitBaseUI
{
  private b CmA;
  private MobileRemitHistoryRecodUI.c CmB;
  private int CmC;
  private Runnable CmD;
  private RecyclerView Cmu;
  private TextView Cmv;
  private String Cmw;
  private String Cmx;
  private boolean Cmy;
  private List<cbp> Cmz;
  private LinearLayoutManager gxa;
  private int[] tef;
  
  public MobileRemitHistoryRecodUI()
  {
    AppMethodBeat.i(67706);
    this.Cmw = null;
    this.Cmx = null;
    this.Cmy = false;
    this.Cmz = new ArrayList();
    this.CmC = 0;
    this.tef = new int[2];
    this.CmD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67689);
        if ((MobileRemitHistoryRecodUI.h(MobileRemitHistoryRecodUI.this).getScrollState() == 0) && (!MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).dgZ) && (MobileRemitHistoryRecodUI.g(MobileRemitHistoryRecodUI.this).ku() + 1 == MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount()))
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
    return 2131495669;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67708);
    super.initView();
    setMMTitle(getString(2131763102));
    setBackBtn(new MobileRemitHistoryRecodUI.1(this));
    this.Cmu = ((RecyclerView)findViewById(2131304776));
    this.Cmv = ((TextView)findViewById(2131304775));
    if (this.Cmz.isEmpty())
    {
      this.Cmu.setVisibility(8);
      this.Cmv.setVisibility(0);
      AppMethodBeat.o(67708);
      return;
    }
    this.gxa = new LinearLayoutManager();
    this.gxa.setOrientation(1);
    this.Cmu.setLayoutManager(this.gxa);
    this.CmB = new MobileRemitHistoryRecodUI.c(getContext());
    this.Cmu.a(this.CmB);
    this.CmA = new b(getContext(), this.Cmy, this.Cmz, new d()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67684);
        Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv click!");
        paramAnonymousView = (cbp)paramAnonymousView.getTag();
        if (paramAnonymousView.ClW != 0) {
          h.a(MobileRemitHistoryRecodUI.this.getContext(), MobileRemitHistoryRecodUI.this.getResources().getString(2131763100), "", MobileRemitHistoryRecodUI.this.getResources().getString(2131763095), false, null).show();
        }
        for (;;)
        {
          MobileRemitHistoryRecodUI.Wb(13);
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
        final cbp localcbp = (cbp)paramAnonymousView.getTag();
        new com.tencent.mm.ui.widget.b.a(MobileRemitHistoryRecodUI.this, paramAnonymousView).a(paramAnonymousView, new View.OnCreateContextMenuListener()new o.g
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(67682);
            paramAnonymous2ContextMenu.add(0, 0, 0, 2131755778);
            AppMethodBeat.o(67682);
          }
        }, new o.g()
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
              Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "delete HisRcvr id:%s", new Object[] { localcbp.id });
              paramAnonymous2MenuItem = new c(localcbp.id);
              MobileRemitHistoryRecodUI.this.doSceneProgress(paramAnonymous2MenuItem, false);
              MobileRemitHistoryRecodUI.b(MobileRemitHistoryRecodUI.this).remove(localcbp);
              MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).atj.notifyChanged();
              MobileRemitHistoryRecodUI.Wb(14);
            }
            AppMethodBeat.o(67683);
          }
        }, MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[0], MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[1]);
        AppMethodBeat.o(67685);
        return true;
      }
    });
    this.Cmu.setAdapter(this.CmA);
    this.Cmu.a(new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(67686);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        Log.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv onScrollStateChanged() newState:%s mLastVisibleItem:%s isFinish:%s itemCount:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(MobileRemitHistoryRecodUI.e(MobileRemitHistoryRecodUI.this)), Boolean.valueOf(MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).dgZ), Integer.valueOf(MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount()) });
        if ((paramAnonymousInt == 0) && (!MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).dgZ) && (MobileRemitHistoryRecodUI.e(MobileRemitHistoryRecodUI.this) + 1 == MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount())) {
          MobileRemitHistoryRecodUI.f(MobileRemitHistoryRecodUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(67686);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(67687);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousRecyclerView);
        localb.pH(paramAnonymousInt1);
        localb.pH(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        MobileRemitHistoryRecodUI.a(MobileRemitHistoryRecodUI.this, MobileRemitHistoryRecodUI.g(MobileRemitHistoryRecodUI.this).ku());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(67687);
      }
    });
    this.CmA.atj.notifyChanged();
    this.Cmu.post(this.CmD);
    this.Cmu.a(new MobileRemitHistoryRecodUI.4(this));
    this.Cmu.setVisibility(0);
    this.Cmv.setVisibility(8);
    AppMethodBeat.o(67708);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67707);
    super.onCreate(paramBundle);
    this.Cmw = getIntent().getStringExtra("key_homepage_ext");
    this.Cmy = getIntent().getBooleanExtra("key_finish", true);
    this.Cmx = getIntent().getStringExtra("key_last_id");
    paramBundle = getIntent().getParcelableArrayListExtra("key_history_record");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.Cmz.addAll(NetSceneMobileRemitGetRecord.gp(paramBundle));
    }
    Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "initData() mFinish:%s mLastId:%s mHisRecord.size:%s", new Object[] { Boolean.valueOf(this.Cmy), this.Cmx, Integer.valueOf(this.Cmz.size()) });
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
    AppMethodBeat.i(67710);
    Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof NetSceneMobileRemitGetRecord))
      {
        paramString = ((NetSceneMobileRemitGetRecord)paramq).eNm();
        if ((paramString != null) && (paramString.pTZ == 0))
        {
          this.Cmx = paramString.Nji;
          this.Cmy = paramString.chA;
          this.CmA.dgZ = this.Cmy;
          if (!paramString.Njk.isEmpty()) {
            this.Cmz.addAll(paramString.Njk);
          }
          this.CmA.atj.notifyChanged();
          AppMethodBeat.o(67710);
          return true;
        }
        paramq = getContext();
        if ((paramString == null) || (Util.isNullOrNil(paramString.pUa))) {}
        for (paramString = getString(2131767667);; paramString = paramString.pUa)
        {
          u.makeText(paramq, paramString, 0).show();
          break;
        }
      }
      if ((paramq instanceof NetSceneMobileRemitGetRecvInfo))
      {
        paramString = ((NetSceneMobileRemitGetRecvInfo)paramq).eNn();
        if (paramString == null)
        {
          Log.e("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "NetSceneMobileRemitGetRecvInfo rcvrResp is null");
          AppMethodBeat.o(67710);
          return true;
        }
        paramq = ((NetSceneMobileRemitGetRecvInfo)paramq).ClX;
        Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "NetSceneMobileRemitGetRecvInfo rcvrId:%s ret_code:%s ret_msg:%s", new Object[] { paramq, Integer.valueOf(paramString.pTZ), paramString.pUa });
        if (paramString.pTZ != 0)
        {
          if (paramString.ClW == 1)
          {
            localObject = this.Cmz.iterator();
            while (((Iterator)localObject).hasNext())
            {
              cbp localcbp = (cbp)((Iterator)localObject).next();
              if (Util.isEqual(localcbp.id, paramq)) {
                localcbp.ClW = 1;
              }
            }
            this.CmA.atj.notifyChanged();
          }
          paramq = getContext();
          if (Util.isNullOrNil(paramString.pUa)) {}
          for (paramString = getString(2131767667);; paramString = paramString.pUa)
          {
            h.a(paramq, paramString, "", getResources().getString(2131763095), false, null).show();
            AppMethodBeat.o(67710);
            return true;
          }
        }
        if (paramString.Njl != null)
        {
          Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "show remark or nickname change dialog!");
          l.a(this, paramString.Njl, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dP(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67691);
              Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "wxname_chg_win dialog click jumpItem.action:continue");
              com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitHistoryRecodUI.this.getContext(), paramString);
              AppMethodBeat.o(67691);
            }
            
            public final void eNw()
            {
              AppMethodBeat.i(67690);
              Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "wxname_chg_win dialog click jumpItem.action:exit");
              MobileRemitHistoryRecodUI.this.eNv();
              AppMethodBeat.o(67690);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(67710);
          return true;
          if (paramString.Nja != null)
          {
            Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "show free oneself from dialog!");
            l.a(this, paramString.Nja, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
            {
              public final void dP(Object paramAnonymousObject)
              {
                AppMethodBeat.i(67693);
                Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "jump_win dialog click jumpItem.action:continue");
                com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitHistoryRecodUI.this.getContext(), paramString);
                AppMethodBeat.o(67693);
              }
              
              public final void eNw()
              {
                AppMethodBeat.i(67692);
                Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "jump_win dialog click jumpItem.action:exit");
                MobileRemitHistoryRecodUI.this.eNv();
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
        if (paramString.ClR == null)
        {
          paramString = null;
          if ((paramString == null) || (paramString.pTZ != 0))
          {
            paramq = getContext();
            if ((paramString != null) && (!Util.isNullOrNil(paramString.pUa))) {
              break label614;
            }
          }
        }
        label614:
        for (paramString = getString(2131767667);; paramString = paramString.pUa)
        {
          u.makeText(paramq, paramString, 0).show();
          AppMethodBeat.o(67710);
          return true;
          paramString = paramString.ClR;
          break;
        }
      }
    }
    else if (paramInt2 == 0)
    {
      localObject = getContext();
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = getString(2131763096);
      }
      u.makeText((Context)localObject, paramq, 0).show();
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
    View gvQ;
    
    public a(View paramView)
    {
      super();
      this.gvQ = paramView;
    }
  }
  
  public static final class b
    extends RecyclerView.a
  {
    private List<cbp> CmI;
    private int CmJ;
    private int CmK;
    private int CmL;
    private MobileRemitHistoryRecodUI.d CmM;
    private Context context;
    boolean dgZ;
    
    public b(Context paramContext, boolean paramBoolean, List<cbp> paramList, MobileRemitHistoryRecodUI.d paramd)
    {
      AppMethodBeat.i(67697);
      this.context = paramContext;
      this.dgZ = paramBoolean;
      this.CmI = paramList;
      this.CmM = paramd;
      this.CmJ = paramContext.getResources().getColor(2131100047);
      this.CmK = paramContext.getResources().getColor(2131099665);
      this.CmL = paramContext.getResources().getColor(2131099662);
      AppMethodBeat.o(67697);
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(67698);
      if (paramInt == 0)
      {
        paramViewGroup = new MobileRemitHistoryRecodUI.e(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495670, paramViewGroup, false));
        AppMethodBeat.o(67698);
        return paramViewGroup;
      }
      paramViewGroup = new MobileRemitHistoryRecodUI.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495671, paramViewGroup, false));
      AppMethodBeat.o(67698);
      return paramViewGroup;
    }
    
    public final void a(final RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(67699);
      if ((paramv instanceof MobileRemitHistoryRecodUI.e))
      {
        if ((this.CmI != null) && (paramInt >= 0) && (paramInt < this.CmI.size()))
        {
          paramv = (MobileRemitHistoryRecodUI.e)paramv;
          final cbp localcbp = (cbp)this.CmI.get(paramInt);
          Log.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "onBindViewHolder() i:%s invalid:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localcbp.ClW) });
          paramv.gvQ.setVisibility(0);
          paramv.CmP.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(67694);
              int i = paramv.CmP.getMeasuredWidth();
              if (i != 0)
              {
                float f1 = paramv.kcZ.getPaint().measureText(localcbp.ClU);
                float f2 = paramv.CmQ.getPaint().measureText(localcbp.ClV);
                int j = com.tencent.mm.cb.a.fromDPToPix(MobileRemitHistoryRecodUI.b.a(MobileRemitHistoryRecodUI.b.this), 14);
                if (f1 + f2 + j > i)
                {
                  LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramv.kcZ.getLayoutParams();
                  localLayoutParams.width = ((int)(i - f2 - j));
                  paramv.kcZ.setLayoutParams(localLayoutParams);
                }
              }
              paramv.kcZ.setText(localcbp.ClU);
              paramv.CmQ.setText(localcbp.ClV);
              AppMethodBeat.o(67694);
            }
          });
          paramv.nzh.setText(localcbp.pSm);
          if (localcbp.ClW == 0)
          {
            paramv.kcZ.setTextColor(this.CmJ);
            paramv.CmQ.setTextColor(this.CmJ);
            paramv.nzh.setTextColor(this.CmK);
            paramv.uzB.setVisibility(8);
          }
          for (;;)
          {
            paramv.gvQ.setTag(localcbp);
            paramv.gvQ.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(67695);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                if (MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this) != null) {
                  MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this).onClick(paramAnonymousView);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(67695);
              }
            });
            paramv.gvQ.setOnLongClickListener(new View.OnLongClickListener()
            {
              public final boolean onLongClick(View paramAnonymousView)
              {
                AppMethodBeat.i(67696);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
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
            paramv.kcZ.setTextColor(this.CmL);
            paramv.CmQ.setTextColor(this.CmL);
            paramv.nzh.setTextColor(this.CmL);
            paramv.uzB.setVisibility(0);
          }
        }
      }
      else
      {
        paramv = (MobileRemitHistoryRecodUI.a)paramv;
        if (this.dgZ)
        {
          paramv.gvQ.setVisibility(8);
          AppMethodBeat.o(67699);
          return;
        }
        paramv.gvQ.setVisibility(0);
      }
      AppMethodBeat.o(67699);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(67701);
      if (this.dgZ)
      {
        i = this.CmI.size();
        AppMethodBeat.o(67701);
        return i;
      }
      int i = this.CmI.size();
      AppMethodBeat.o(67701);
      return i + 1;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(67700);
      if (this.dgZ)
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
    LinearLayout CmP;
    TextView CmQ;
    View gvQ;
    TextView kcZ;
    TextView nzh;
    TextView uzB;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(67705);
      this.gvQ = paramView;
      this.CmP = ((LinearLayout)paramView.findViewById(2131305214));
      this.kcZ = ((TextView)paramView.findViewById(2131305440));
      this.CmQ = ((TextView)paramView.findViewById(2131306598));
      this.nzh = ((TextView)paramView.findViewById(2131305904));
      this.uzB = ((TextView)paramView.findViewById(2131308383));
      AppMethodBeat.o(67705);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI
 * JD-Core Version:    0.7.0.1
 */