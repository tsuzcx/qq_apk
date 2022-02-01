package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecord;
import com.tencent.mm.plugin.remittance.mobile.cgi.NetSceneMobileRemitGetRecvInfo;
import com.tencent.mm.plugin.remittance.mobile.cgi.c;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.czx;
import com.tencent.mm.protocal.protobuf.fpn;
import com.tencent.mm.protocal.protobuf.fpp;
import com.tencent.mm.protocal.protobuf.fpr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.model.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MobileRemitHistoryRecodUI
  extends MobileRemitBaseUI
{
  private int[] AgN;
  private RecyclerView OfZ;
  private TextView Oga;
  private String Ogb;
  private String Ogc;
  private boolean Ogd;
  private List<czx> Oge;
  private b Ogf;
  private MobileRemitHistoryRecodUI.c Ogg;
  private int Ogh;
  private Runnable Ogi;
  private LinearLayoutManager lDn;
  
  public MobileRemitHistoryRecodUI()
  {
    AppMethodBeat.i(67706);
    this.Ogb = null;
    this.Ogc = null;
    this.Ogd = false;
    this.Oge = new ArrayList();
    this.Ogh = 0;
    this.AgN = new int[2];
    this.Ogi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(67689);
        if ((MobileRemitHistoryRecodUI.h(MobileRemitHistoryRecodUI.this).getScrollState() == 0) && (!MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).hcg) && (MobileRemitHistoryRecodUI.g(MobileRemitHistoryRecodUI.this).Jw() + 1 == MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount()))
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
    this.OfZ = ((RecyclerView)findViewById(a.f.mobile_remit_hitory_record_rv));
    this.Oga = ((TextView)findViewById(a.f.mobile_remit_hitory_record_none_tv));
    if (this.Oge.isEmpty())
    {
      this.OfZ.setVisibility(8);
      this.Oga.setVisibility(0);
      AppMethodBeat.o(67708);
      return;
    }
    this.lDn = new LinearLayoutManager();
    this.lDn.setOrientation(1);
    this.OfZ.setLayoutManager(this.lDn);
    this.Ogg = new MobileRemitHistoryRecodUI.c(getContext());
    this.OfZ.a(this.Ogg);
    this.Ogf = new b(getContext(), this.Ogd, this.Oge, new d()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(67684);
        Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv click!");
        paramAnonymousView = (czx)paramAnonymousView.getTag();
        if (paramAnonymousView.OfA != 0) {
          com.tencent.mm.ui.base.k.a(MobileRemitHistoryRecodUI.this.getContext(), MobileRemitHistoryRecodUI.this.getResources().getString(a.i.mobile_remit_history_recod_invalid_dialog_desc), "", MobileRemitHistoryRecodUI.this.getResources().getString(a.i.mobile_remit_confirm), false, null).show();
        }
        for (;;)
        {
          MobileRemitHistoryRecodUI.ahi(13);
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
        final czx localczx = (czx)paramAnonymousView.getTag();
        new com.tencent.mm.ui.widget.b.a(MobileRemitHistoryRecodUI.this, paramAnonymousView).a(paramAnonymousView, new View.OnCreateContextMenuListener()new u.i
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(67682);
            paramAnonymous2ContextMenu.add(0, 0, 0, a.i.app_delete);
            AppMethodBeat.o(67682);
          }
        }, new u.i()
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
              Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "delete HisRcvr id:%s", new Object[] { localczx.id });
              paramAnonymous2MenuItem = new c(localczx.id);
              MobileRemitHistoryRecodUI.this.doSceneProgress(paramAnonymous2MenuItem, false);
              MobileRemitHistoryRecodUI.b(MobileRemitHistoryRecodUI.this).remove(localczx);
              MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).bZE.notifyChanged();
              MobileRemitHistoryRecodUI.ahi(14);
            }
            AppMethodBeat.o(67683);
          }
        }, MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[0], MobileRemitHistoryRecodUI.d(MobileRemitHistoryRecodUI.this)[1]);
        AppMethodBeat.o(67685);
        return true;
      }
    });
    this.OfZ.setAdapter(this.Ogf);
    this.OfZ.a(new RecyclerView.l()
    {
      public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(288894);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
        super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
        Log.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "mHistroyRecordRv onScrollStateChanged() newState:%s mLastVisibleItem:%s isFinish:%s itemCount:%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(MobileRemitHistoryRecodUI.e(MobileRemitHistoryRecodUI.this)), Boolean.valueOf(MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).hcg), Integer.valueOf(MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount()) });
        if ((paramAnonymousInt == 0) && (!MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).hcg) && (MobileRemitHistoryRecodUI.e(MobileRemitHistoryRecodUI.this) + 1 == MobileRemitHistoryRecodUI.c(MobileRemitHistoryRecodUI.this).getItemCount())) {
          MobileRemitHistoryRecodUI.f(MobileRemitHistoryRecodUI.this);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(288894);
      }
      
      public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(288896);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousRecyclerView);
        localb.sc(paramAnonymousInt1);
        localb.sc(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
        super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        MobileRemitHistoryRecodUI.a(MobileRemitHistoryRecodUI.this, MobileRemitHistoryRecodUI.g(MobileRemitHistoryRecodUI.this).Jw());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(288896);
      }
    });
    this.Ogf.bZE.notifyChanged();
    this.OfZ.post(this.Ogi);
    this.OfZ.a(new MobileRemitHistoryRecodUI.4(this));
    this.OfZ.setVisibility(0);
    this.Oga.setVisibility(8);
    AppMethodBeat.o(67708);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67707);
    super.onCreate(paramBundle);
    this.Ogb = getIntent().getStringExtra("key_homepage_ext");
    this.Ogd = getIntent().getBooleanExtra("key_finish", true);
    this.Ogc = getIntent().getStringExtra("key_last_id");
    paramBundle = getIntent().getParcelableArrayListExtra("key_history_record");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.Oge.addAll(NetSceneMobileRemitGetRecord.jV(paramBundle));
    }
    Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "initData() mFinish:%s mLastId:%s mHisRecord.size:%s", new Object[] { Boolean.valueOf(this.Ogd), this.Ogc, Integer.valueOf(this.Oge.size()) });
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    Object localObject = null;
    AppMethodBeat.i(67710);
    Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramp.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof NetSceneMobileRemitGetRecord))
      {
        paramString = ((NetSceneMobileRemitGetRecord)paramp).gLN();
        if ((paramString != null) && (paramString.wuz == 0))
        {
          this.Ogc = paramString.abPv;
          this.Ogd = paramString.mhq;
          this.Ogf.hcg = this.Ogd;
          if (!paramString.abPx.isEmpty()) {
            this.Oge.addAll(paramString.abPx);
          }
          this.Ogf.bZE.notifyChanged();
          AppMethodBeat.o(67710);
          return true;
        }
        paramp = getContext();
        if ((paramString == null) || (Util.isNullOrNil(paramString.wuA))) {}
        for (paramString = getString(a.i.wallet_data_err);; paramString = paramString.wuA)
        {
          aa.makeText(paramp, paramString, 0).show();
          break;
        }
      }
      if ((paramp instanceof NetSceneMobileRemitGetRecvInfo))
      {
        paramString = ((NetSceneMobileRemitGetRecvInfo)paramp).gLO();
        if (paramString == null)
        {
          Log.e("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "NetSceneMobileRemitGetRecvInfo rcvrResp is null");
          AppMethodBeat.o(67710);
          return true;
        }
        paramp = ((NetSceneMobileRemitGetRecvInfo)paramp).OfB;
        Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "NetSceneMobileRemitGetRecvInfo rcvrId:%s ret_code:%s ret_msg:%s", new Object[] { paramp, Integer.valueOf(paramString.wuz), paramString.wuA });
        if (paramString.wuz != 0)
        {
          if (paramString.OfA == 1)
          {
            localObject = this.Oge.iterator();
            while (((Iterator)localObject).hasNext())
            {
              czx localczx = (czx)((Iterator)localObject).next();
              if (Util.isEqual(localczx.id, paramp)) {
                localczx.OfA = 1;
              }
            }
            this.Ogf.bZE.notifyChanged();
          }
          paramp = getContext();
          if (Util.isNullOrNil(paramString.wuA)) {}
          for (paramString = getString(a.i.wallet_data_err);; paramString = paramString.wuA)
          {
            com.tencent.mm.ui.base.k.a(paramp, paramString, "", getResources().getString(a.i.mobile_remit_confirm), false, null).show();
            AppMethodBeat.o(67710);
            return true;
          }
        }
        if (paramString.abPy != null)
        {
          Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "show remark or nickname change dialog!");
          l.a(this, paramString.abPy, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
          {
            public final void dJE()
            {
              AppMethodBeat.i(67690);
              Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "wxname_chg_win dialog click jumpItem.action:exit");
              MobileRemitHistoryRecodUI.this.gLX();
              AppMethodBeat.o(67690);
            }
            
            public final void go(Object paramAnonymousObject)
            {
              AppMethodBeat.i(67691);
              Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "wxname_chg_win dialog click jumpItem.action:continue");
              com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitHistoryRecodUI.this.getContext(), paramString);
              AppMethodBeat.o(67691);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(67710);
          return true;
          if (paramString.abPn != null)
          {
            Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "show free oneself from dialog!");
            l.a(this, paramString.abPn, null, new com.tencent.mm.plugin.remittance.mobile.a.a()
            {
              public final void dJE()
              {
                AppMethodBeat.i(67692);
                Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "jump_win dialog click jumpItem.action:exit");
                MobileRemitHistoryRecodUI.this.gLX();
                AppMethodBeat.o(67692);
              }
              
              public final void go(Object paramAnonymousObject)
              {
                AppMethodBeat.i(67693);
                Log.i("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "jump_win dialog click jumpItem.action:continue");
                com.tencent.mm.plugin.remittance.mobile.a.b.a(MobileRemitHistoryRecodUI.this.getContext(), paramString);
                AppMethodBeat.o(67693);
              }
            });
          }
          else
          {
            com.tencent.mm.plugin.remittance.mobile.a.b.a(getContext(), paramString);
          }
        }
      }
      if ((paramp instanceof c))
      {
        paramString = (c)paramp;
        if (paramString.Ofv == null)
        {
          paramString = (String)localObject;
          if ((paramString == null) || (paramString.wuz != 0))
          {
            paramp = getContext();
            if ((paramString != null) && (!Util.isNullOrNil(paramString.wuA))) {
              break label618;
            }
          }
        }
        label618:
        for (paramString = getString(a.i.wallet_data_err);; paramString = paramString.wuA)
        {
          aa.makeText(paramp, paramString, 0).show();
          AppMethodBeat.o(67710);
          return true;
          paramString = paramString.Ofv;
          break;
        }
      }
    }
    else if (paramInt2 == 0)
    {
      localObject = getContext();
      paramp = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramp = getString(a.i.mobile_remit_data_err);
      }
      aa.makeText((Context)localObject, paramp, 0).show();
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
    View lBX;
    
    public a(View paramView)
    {
      super();
      this.lBX = paramView;
    }
  }
  
  public static final class b
    extends RecyclerView.a
  {
    private List<czx> Ogn;
    private int Ogo;
    private int Ogp;
    private int Ogq;
    private MobileRemitHistoryRecodUI.d Ogr;
    private Context context;
    boolean hcg;
    
    public b(Context paramContext, boolean paramBoolean, List<czx> paramList, MobileRemitHistoryRecodUI.d paramd)
    {
      AppMethodBeat.i(67697);
      this.context = paramContext;
      this.hcg = paramBoolean;
      this.Ogn = paramList;
      this.Ogr = paramd;
      this.Ogo = paramContext.getResources().getColor(a.c.black_text_color);
      this.Ogp = paramContext.getResources().getColor(a.c.BW_0_Alpha_0_5);
      this.Ogq = paramContext.getResources().getColor(a.c.BW_0_Alpha_0_3);
      AppMethodBeat.o(67697);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(288893);
      if (paramInt == 0)
      {
        paramViewGroup = new MobileRemitHistoryRecodUI.e(LayoutInflater.from(paramViewGroup.getContext()).inflate(a.g.mobile_remit_hitory_record_data_item, paramViewGroup, false));
        AppMethodBeat.o(288893);
        return paramViewGroup;
      }
      paramViewGroup = new MobileRemitHistoryRecodUI.a(LayoutInflater.from(paramViewGroup.getContext()).inflate(a.g.mobile_remit_hitory_record_loading_footer, paramViewGroup, false));
      AppMethodBeat.o(288893);
      return paramViewGroup;
    }
    
    public final void d(final RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(288897);
      if ((paramv instanceof MobileRemitHistoryRecodUI.e))
      {
        if ((this.Ogn != null) && (paramInt >= 0) && (paramInt < this.Ogn.size()))
        {
          paramv = (MobileRemitHistoryRecodUI.e)paramv;
          final czx localczx = (czx)this.Ogn.get(paramInt);
          Log.d("MicroMsg.mobileRemit.MobileRemitHistoryRecodUI", "onBindViewHolder() i:%s invalid:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localczx.OfA) });
          paramv.lBX.setVisibility(0);
          paramv.Ogu.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(67694);
              int i = paramv.Ogu.getMeasuredWidth();
              if (i != 0)
              {
                float f1 = paramv.pRg.getPaint().measureText(localczx.Ofy);
                float f2 = paramv.Ogv.getPaint().measureText(localczx.Ofz);
                int j = com.tencent.mm.cd.a.fromDPToPix(MobileRemitHistoryRecodUI.b.a(MobileRemitHistoryRecodUI.b.this), 14);
                if (f1 + f2 + j > i)
                {
                  LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramv.pRg.getLayoutParams();
                  localLayoutParams.width = ((int)(i - f2 - j));
                  paramv.pRg.setLayoutParams(localLayoutParams);
                }
              }
              paramv.pRg.setText(localczx.Ofy);
              paramv.Ogv.setText(localczx.Ofz);
              AppMethodBeat.o(67694);
            }
          });
          paramv.tGB.setText(localczx.wsM);
          if (localczx.OfA == 0)
          {
            paramv.pRg.setTextColor(this.Ogo);
            paramv.Ogv.setTextColor(this.Ogo);
            paramv.tGB.setTextColor(this.Ogp);
            paramv.Dip.setVisibility(8);
          }
          for (;;)
          {
            paramv.lBX.setTag(localczx);
            paramv.lBX.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
            {
              public final void dr(View paramAnonymousView)
              {
                AppMethodBeat.i(288890);
                if (MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this) != null) {
                  MobileRemitHistoryRecodUI.b.b(MobileRemitHistoryRecodUI.b.this).onClick(paramAnonymousView);
                }
                AppMethodBeat.o(288890);
              }
            });
            paramv.lBX.setOnLongClickListener(new View.OnLongClickListener()
            {
              public final boolean onLongClick(View paramAnonymousView)
              {
                AppMethodBeat.i(67696);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemitHistoryRecodUI$HistoryRecordAdapter$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
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
            AppMethodBeat.o(288897);
            return;
            paramv.pRg.setTextColor(this.Ogq);
            paramv.Ogv.setTextColor(this.Ogq);
            paramv.tGB.setTextColor(this.Ogq);
            paramv.Dip.setVisibility(0);
          }
        }
      }
      else
      {
        paramv = (MobileRemitHistoryRecodUI.a)paramv;
        if (this.hcg)
        {
          paramv.lBX.setVisibility(8);
          AppMethodBeat.o(288897);
          return;
        }
        paramv.lBX.setVisibility(0);
      }
      AppMethodBeat.o(288897);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(67701);
      if (this.hcg)
      {
        i = this.Ogn.size();
        AppMethodBeat.o(67701);
        return i;
      }
      int i = this.Ogn.size();
      AppMethodBeat.o(67701);
      return i + 1;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(67700);
      if (this.hcg)
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
    TextView Dip;
    LinearLayout Ogu;
    TextView Ogv;
    View lBX;
    TextView pRg;
    TextView tGB;
    
    public e(View paramView)
    {
      super();
      AppMethodBeat.i(67705);
      this.lBX = paramView;
      this.Ogu = ((LinearLayout)paramView.findViewById(a.f.name_container));
      this.pRg = ((TextView)paramView.findViewById(a.f.nickname_tv));
      this.Ogv = ((TextView)paramView.findViewById(a.f.realname_tv));
      this.tGB = ((TextView)paramView.findViewById(a.f.phone_tv));
      this.Dip = ((TextView)paramView.findViewById(a.f.state_tv));
      AppMethodBeat.o(67705);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemitHistoryRecodUI
 * JD-Core Version:    0.7.0.1
 */