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
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
import android.text.TextPaint;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
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
import com.tencent.mm.protocal.protobuf.bjx;
import com.tencent.mm.protocal.protobuf.djo;
import com.tencent.mm.protocal.protobuf.djq;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private LinearLayoutManager fwy;
  private int[] qMm;
  private RecyclerView wHU;
  private TextView wHV;
  private String wHW;
  private String wHX;
  private boolean wHY;
  private List<bjx> wHZ;
  private b wIa;
  private MobileRemitHistoryRecodUI.c wIb;
  private int wIc;
  private Runnable wId;
  
  public MobileRemitHistoryRecodUI()
  {
    AppMethodBeat.i(67706);
    this.wHW = null;
    this.wHX = null;
    this.wHY = false;
    this.wHZ = new ArrayList();
    this.wIc = 0;
    this.qMm = new int[2];
    this.wId = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67689);
        if ((MobileRemitHistoryRecodUI.h(MobileRemitHistoryRecodUI.this).getScrollState() == 0) && (!MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).cEQ) && (MobileRemitHistoryRecodUI.g(MobileRemitHistoryRecodUI.this).jY() + 1 == MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount()))
        {
          ac.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "first screen refresh data!");
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
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(67681);
        MobileRemitHistoryRecodUI.this.finish();
        AppMethodBeat.o(67681);
        return true;
      }
    });
    this.wHU = ((RecyclerView)findViewById(2131302379));
    this.wHV = ((TextView)findViewById(2131302378));
    if (this.wHZ.isEmpty())
    {
      this.wHU.setVisibility(8);
      this.wHV.setVisibility(0);
      AppMethodBeat.o(67708);
      return;
    }
    this.fwy = new LinearLayoutManager();
    this.fwy.setOrientation(1);
    this.wHU.setLayoutManager(this.fwy);
    this.wIb = new MobileRemitHistoryRecodUI.c(getContext());
    this.wHU.a(this.wIb);
    this.wIa = new b(getContext(), this.wHY, this.wHZ, new d()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67684);
        ac.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv click!");
        paramAnonymousView = (bjx)paramAnonymousView.getTag();
        if (paramAnonymousView.wHw != 0) {
          h.a(MobileRemitHistoryRecodUI.this.getContext(), MobileRemitHistoryRecodUI.this.getResources().getString(2131761274), "", MobileRemitHistoryRecodUI.this.getResources().getString(2131761269), false, null).show();
        }
        for (;;)
        {
          MobileRemitHistoryRecodUI.My(13);
          AppMethodBeat.o(67684);
          return;
          paramAnonymousView = new NetSceneMobileRemitGetRecvInfo("", paramAnonymousView.id, MobileRemitHistoryRecodUI.a(MobileRemitHistoryRecodUI.this), 2);
          MobileRemitHistoryRecodUI.this.doSceneProgress(paramAnonymousView, true);
        }
      }
      
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67685);
        ac.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv longclick!");
        final bjx localbjx = (bjx)paramAnonymousView.getTag();
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
              ac.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "delete HisRcvr id:%s", new Object[] { localbjx.id });
              paramAnonymous2MenuItem = new c(localbjx.id);
              MobileRemitHistoryRecodUI.this.doSceneProgress(paramAnonymous2MenuItem, false);
              MobileRemitHistoryRecodUI.b(MobileRemitHistoryRecodUI.this).remove(localbjx);
              MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).arg.notifyChanged();
              MobileRemitHistoryRecodUI.My(14);
            }
            AppMethodBeat.o(67683);
          }
        }, MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[0], MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[1]);
        AppMethodBeat.o(67685);
        return true;
      }
    });
    this.wHU.setAdapter(this.wIa);
    this.wHU.a(new RecyclerView.m()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(67687);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt1);
        localb.lS(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        MobileRemitHistoryRecodUI.a(MobileRemitHistoryRecodUI.this, MobileRemitHistoryRecodUI.g(MobileRemitHistoryRecodUI.this).jY());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(67687);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(67686);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        ac.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv onScrollStateChanged() newState:%s mLastVisibleItem:%s isFinish:%s itemCount:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(MobileRemitHistoryRecodUI.e(MobileRemitHistoryRecodUI.this)), Boolean.valueOf(MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).cEQ), Integer.valueOf(MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount()) });
        if ((paramAnonymousInt == 0) && (!MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).cEQ) && (MobileRemitHistoryRecodUI.e(MobileRemitHistoryRecodUI.this) + 1 == MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount())) {
          MobileRemitHistoryRecodUI.f(MobileRemitHistoryRecodUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(67686);
      }
    });
    this.wIa.arg.notifyChanged();
    this.wHU.post(this.wId);
    this.wHU.a(new RecyclerView.l()
    {
      public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(207133);
        MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
        MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
        ac.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "onTouchEvent() (%s, %s)", new Object[] { Integer.valueOf(MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[0]), Integer.valueOf(MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[1]) });
        AppMethodBeat.o(207133);
        return false;
      }
      
      public final void ai(boolean paramAnonymousBoolean) {}
      
      public final void b(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent) {}
    });
    this.wHU.setVisibility(0);
    this.wHV.setVisibility(8);
    AppMethodBeat.o(67708);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67707);
    super.onCreate(paramBundle);
    this.wHW = getIntent().getStringExtra("key_homepage_ext");
    this.wHY = getIntent().getBooleanExtra("key_finish", true);
    this.wHX = getIntent().getStringExtra("key_last_id");
    paramBundle = getIntent().getParcelableArrayListExtra("key_history_record");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.wHZ.addAll(NetSceneMobileRemitGetRecord.eZ(paramBundle));
    }
    ac.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "initData() mFinish:%s mLastId:%s mHisRecord.size:%s", new Object[] { Boolean.valueOf(this.wHY), this.wHX, Integer.valueOf(this.wHZ.size()) });
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
    ac.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof NetSceneMobileRemitGetRecord))
      {
        paramString = ((NetSceneMobileRemitGetRecord)paramn).dxD();
        if ((paramString != null) && (paramString.nWx == 0))
        {
          this.wHX = paramString.FSG;
          this.wHY = paramString.bMF;
          this.wIa.cEQ = this.wHY;
          if (!paramString.FSI.isEmpty()) {
            this.wHZ.addAll(paramString.FSI);
          }
          this.wIa.arg.notifyChanged();
          AppMethodBeat.o(67710);
          return true;
        }
        paramn = getContext();
        if ((paramString == null) || (bs.isNullOrNil(paramString.nWy))) {}
        for (paramString = getString(2131765224);; paramString = paramString.nWy)
        {
          t.makeText(paramn, paramString, 0).show();
          break;
        }
      }
      if ((paramn instanceof NetSceneMobileRemitGetRecvInfo))
      {
        paramString = ((NetSceneMobileRemitGetRecvInfo)paramn).dxE();
        if (paramString == null)
        {
          ac.e("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "NetSceneMobileRemitGetRecvInfo rcvrResp is null");
          AppMethodBeat.o(67710);
          return true;
        }
        paramn = ((NetSceneMobileRemitGetRecvInfo)paramn).wHx;
        ac.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "NetSceneMobileRemitGetRecvInfo rcvrId:%s ret_code:%s ret_msg:%s", new Object[] { paramn, Integer.valueOf(paramString.nWx), paramString.nWy });
        if (paramString.nWx != 0)
        {
          if (paramString.wHw == 1)
          {
            localObject = this.wHZ.iterator();
            while (((Iterator)localObject).hasNext())
            {
              bjx localbjx = (bjx)((Iterator)localObject).next();
              if (bs.lr(localbjx.id, paramn)) {
                localbjx.wHw = 1;
              }
            }
            this.wIa.arg.notifyChanged();
          }
          paramn = getContext();
          if (bs.isNullOrNil(paramString.nWy)) {}
          for (paramString = getString(2131765224);; paramString = paramString.nWy)
          {
            h.a(paramn, paramString, "", getResources().getString(2131761269), false, null).show();
            AppMethodBeat.o(67710);
            return true;
          }
        }
        if (paramString.FSJ != null)
        {
          ac.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "show remark or nickname change dialog!");
          l.a(this, paramString.FSJ, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dC(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67691);
              ac.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "wxname_chg_win dialog click jumpItem.action:continue");
              com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitHistoryRecodUI.this.getContext(), paramString);
              AppMethodBeat.o(67691);
            }
            
            public final void dxN()
            {
              AppMethodBeat.i(67690);
              ac.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "wxname_chg_win dialog click jumpItem.action:exit");
              MobileRemitHistoryRecodUI.this.dxM();
              AppMethodBeat.o(67690);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(67710);
          return true;
          if (paramString.FSy != null)
          {
            ac.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "show free oneself from dialog!");
            l.a(this, paramString.FSy, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
            {
              public final void dC(Object paramAnonymousObject)
              {
                AppMethodBeat.i(67693);
                ac.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "jump_win dialog click jumpItem.action:continue");
                com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitHistoryRecodUI.this.getContext(), paramString);
                AppMethodBeat.o(67693);
              }
              
              public final void dxN()
              {
                AppMethodBeat.i(67692);
                ac.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "jump_win dialog click jumpItem.action:exit");
                MobileRemitHistoryRecodUI.this.dxM();
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
        if (paramString.wHr == null)
        {
          paramString = null;
          if ((paramString == null) || (paramString.nWx != 0))
          {
            paramn = getContext();
            if ((paramString != null) && (!bs.isNullOrNil(paramString.nWy))) {
              break label614;
            }
          }
        }
        label614:
        for (paramString = getString(2131765224);; paramString = paramString.nWy)
        {
          t.makeText(paramn, paramString, 0).show();
          AppMethodBeat.o(67710);
          return true;
          paramString = paramString.wHr;
          break;
        }
      }
    }
    else if (paramInt2 == 0)
    {
      localObject = getContext();
      paramn = paramString;
      if (bs.isNullOrNil(paramString)) {
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
    View fvu;
    
    public a(View paramView)
    {
      super();
      this.fvu = paramView;
    }
  }
  
  public static final class b
    extends RecyclerView.a
  {
    boolean cEQ;
    private Context context;
    private List<bjx> wIi;
    private int wIj;
    private int wIk;
    private int wIl;
    private MobileRemitHistoryRecodUI.d wIm;
    
    public b(Context paramContext, boolean paramBoolean, List<bjx> paramList, MobileRemitHistoryRecodUI.d paramd)
    {
      AppMethodBeat.i(67697);
      this.context = paramContext;
      this.cEQ = paramBoolean;
      this.wIi = paramList;
      this.wIm = paramd;
      this.wIj = paramContext.getResources().getColor(2131100021);
      this.wIk = paramContext.getResources().getColor(2131099662);
      this.wIl = paramContext.getResources().getColor(2131099660);
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
        if ((this.wIi != null) && (paramInt >= 0) && (paramInt < this.wIi.size()))
        {
          paramw = (MobileRemitHistoryRecodUI.e)paramw;
          final bjx localbjx = (bjx)this.wIi.get(paramInt);
          ac.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "onBindViewHolder() i:%s invalid:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localbjx.wHw) });
          paramw.fvu.setVisibility(0);
          paramw.wIp.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(67694);
              int i = paramw.wIp.getMeasuredWidth();
              if (i != 0)
              {
                float f1 = paramw.iIU.getPaint().measureText(localbjx.wHu);
                float f2 = paramw.wIq.getPaint().measureText(localbjx.wHv);
                int j = com.tencent.mm.cc.a.fromDPToPix(MobileRemitHistoryRecodUI.b.a(MobileRemitHistoryRecodUI.b.this), 14);
                if (f1 + f2 + j > i)
                {
                  LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramw.iIU.getLayoutParams();
                  localLayoutParams.width = ((int)(i - f2 - j));
                  paramw.iIU.setLayoutParams(localLayoutParams);
                }
              }
              paramw.iIU.setText(localbjx.wHu);
              paramw.wIq.setText(localbjx.wHv);
              AppMethodBeat.o(67694);
            }
          });
          paramw.lJL.setText(localbjx.nUG);
          if (localbjx.wHw == 0)
          {
            paramw.iIU.setTextColor(this.wIj);
            paramw.wIq.setTextColor(this.wIj);
            paramw.lJL.setTextColor(this.wIk);
            paramw.wGq.setVisibility(8);
          }
          for (;;)
          {
            paramw.fvu.setTag(localbjx);
            paramw.fvu.setOnClickListener(new View.OnClickListener()
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
            paramw.fvu.setOnLongClickListener(new View.OnLongClickListener()
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
            paramw.iIU.setTextColor(this.wIl);
            paramw.wIq.setTextColor(this.wIl);
            paramw.lJL.setTextColor(this.wIl);
            paramw.wGq.setVisibility(0);
          }
        }
      }
      else
      {
        paramw = (MobileRemitHistoryRecodUI.a)paramw;
        if (this.cEQ)
        {
          paramw.fvu.setVisibility(8);
          AppMethodBeat.o(67699);
          return;
        }
        paramw.fvu.setVisibility(0);
      }
      AppMethodBeat.o(67699);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(67701);
      if (this.cEQ)
      {
        i = this.wIi.size();
        AppMethodBeat.o(67701);
        return i;
      }
      int i = this.wIi.size();
      AppMethodBeat.o(67701);
      return i + 1;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(67700);
      if (this.cEQ)
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
    View fvu;
    TextView iIU;
    TextView lJL;
    TextView wGq;
    LinearLayout wIp;
    TextView wIq;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(67705);
      this.fvu = paramView;
      this.wIp = ((LinearLayout)paramView.findViewById(2131302660));
      this.iIU = ((TextView)paramView.findViewById(2131302867));
      this.wIq = ((TextView)paramView.findViewById(2131303802));
      this.lJL = ((TextView)paramView.findViewById(2131303236));
      this.wGq = ((TextView)paramView.findViewById(2131305192));
      AppMethodBeat.o(67705);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI
 * JD-Core Version:    0.7.0.1
 */