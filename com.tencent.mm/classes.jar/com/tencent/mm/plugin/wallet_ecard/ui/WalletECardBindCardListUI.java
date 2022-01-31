package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.plugin.wallet_ecard.a.f;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.a;
import com.tencent.mm.wallet_core.d.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalletECardBindCardListUI
  extends WalletECardBaseUI
{
  private int kbq;
  private TextView uzA;
  private List<hg> uzB;
  private c uzC;
  private boolean uzD;
  private c.a uzE;
  private ListView uzz;
  
  public WalletECardBindCardListUI()
  {
    AppMethodBeat.i(48125);
    this.uzB = new ArrayList();
    this.uzD = true;
    this.uzE = new WalletECardBindCardListUI.2(this);
    AppMethodBeat.o(48125);
  }
  
  private void aso()
  {
    AppMethodBeat.i(48131);
    ab.i("MicroMsg.WalletECardBindCardListUI", "load Data");
    doSceneForceProgress(new f("WEB_DEBIT", this.kbq));
    AppMethodBeat.o(48131);
  }
  
  public final void cXc()
  {
    AppMethodBeat.i(48129);
    Bundle localBundle = new Bundle();
    if (this.kbq == 3) {
      localBundle.putInt("key_bind_scene", 18);
    }
    for (;;)
    {
      localBundle.putBoolean("key_need_bind_response", true);
      localBundle.putBoolean("key_is_bind_bankcard", true);
      localBundle.putString("key_pwd1", getInput().getString("key_pwd1"));
      ab.i("MicroMsg.WalletECardBindCardListUI", "start bind card, scene: %s", new Object[] { Integer.valueOf(this.kbq) });
      com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_ecard.b.a.class, localBundle, this.uzE);
      AppMethodBeat.o(48129);
      return;
      localBundle.putInt("key_bind_scene", 19);
    }
  }
  
  public int getLayoutId()
  {
    return 2130969338;
  }
  
  public void initView()
  {
    AppMethodBeat.i(48127);
    this.uzz = ((ListView)findViewById(2131823465));
    View localView = LayoutInflater.from(this).inflate(2130969339, this.uzz, false);
    this.uzA = ((TextView)localView.findViewById(2131823467));
    this.uzz.addHeaderView(localView, null, false);
    this.uzC = new c((byte)0);
    this.uzz.setAdapter(this.uzC);
    this.uzz.setOnItemClickListener(new WalletECardBindCardListUI.1(this));
    AppMethodBeat.o(48127);
  }
  
  public boolean needConfirmFinish()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48126);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131690709));
    hideActionbarLine();
    this.mNetSceneMgr.addSceneEndListener(1988);
    this.kbq = getInput().getInt(com.tencent.mm.plugin.wallet_ecard.a.a.uyJ, 2);
    ab.i("MicroMsg.WalletECardBindCardListUI", "openScene: %d", new Object[] { Integer.valueOf(this.kbq) });
    setMMTitle("");
    initView();
    this.uzD = true;
    aso();
    AppMethodBeat.o(48126);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(48130);
    super.onDestroy();
    this.mNetSceneMgr.removeSceneEndListener(1988);
    AppMethodBeat.o(48130);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48128);
    if ((paramm instanceof f))
    {
      paramm = (f)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (!bo.isNullOrNil(paramm.uzq.xDw)) {
          this.uzA.setText(paramm.uzq.xDw);
        }
        if (paramm.uzq.koj == 0)
        {
          ab.i("MicroMsg.WalletECardBindCardListUI", "banklist: %s", new Object[] { Integer.valueOf(paramm.uzq.xDx.size()) });
          ab.d("MicroMsg.WalletECardBindCardListUI", "true name: %s", new Object[] { paramm.uzq.ueu });
          getInput().putString(com.tencent.mm.plugin.wallet_ecard.a.a.uza, paramm.uzq.ueu);
          if (paramm.uzq.xDx.size() == 0)
          {
            ab.i("MicroMsg.WalletECardBindCardListUI", "no bind card, isGotoBindCardAfterNoBindCard: %s", new Object[] { Boolean.valueOf(this.uzD) });
            if (this.uzD) {
              cXc();
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(48128);
        return true;
        this.uzB.clear();
        this.uzB.addAll(paramm.uzq.xDx);
        this.uzC.notifyDataSetChanged();
        continue;
        if (!b.a(this, paramm.uzq.wvq))
        {
          paramString = b.d(getContext(), new String[] { paramm.uzq.kok, paramString });
          h.b(getContext(), paramString, "", false);
          continue;
          ab.w("MicroMsg.WalletECardBindCardListUI", "net error: %s", new Object[] { paramm });
          paramString = b.d(getContext(), new String[] { paramString });
          h.b(getContext(), paramString, "", false);
        }
      }
    }
    AppMethodBeat.o(48128);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class c
    extends BaseAdapter
  {
    public final int swv = 0;
    public final int uzG = 1;
    
    private c() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(48118);
      int i = WalletECardBindCardListUI.e(WalletECardBindCardListUI.this).size();
      AppMethodBeat.o(48118);
      return i + 1;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(48119);
      if (paramInt < WalletECardBindCardListUI.e(WalletECardBindCardListUI.this).size())
      {
        Object localObject = WalletECardBindCardListUI.e(WalletECardBindCardListUI.this).get(paramInt);
        AppMethodBeat.o(48119);
        return localObject;
      }
      AppMethodBeat.o(48119);
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(48120);
      if (paramInt >= WalletECardBindCardListUI.e(WalletECardBindCardListUI.this).size())
      {
        AppMethodBeat.o(48120);
        return 1;
      }
      AppMethodBeat.o(48120);
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(48122);
      View localView;
      if (getItemViewType(paramInt) == 1)
      {
        localView = paramView;
        if (paramView == null)
        {
          localView = LayoutInflater.from(WalletECardBindCardListUI.this.getContext()).inflate(2130969341, paramViewGroup, false);
          localView.setTag(new WalletECardBindCardListUI.a(WalletECardBindCardListUI.this, localView));
        }
        ((WalletECardBindCardListUI.a)localView.getTag()).jaY.setText(2131299053);
      }
      for (;;)
      {
        AppMethodBeat.o(48122);
        return localView;
        localView = paramView;
        if (paramView == null)
        {
          localView = LayoutInflater.from(WalletECardBindCardListUI.this.getContext()).inflate(2130969340, paramViewGroup, false);
          localView.setTag(new WalletECardBindCardListUI.d(WalletECardBindCardListUI.this, localView));
        }
        ((WalletECardBindCardListUI.b)localView.getTag()).a(localView, (hg)getItem(paramInt));
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(48121);
      hg localhg = (hg)getItem(paramInt);
      if (localhg != null)
      {
        if (localhg.wtX)
        {
          AppMethodBeat.o(48121);
          return false;
        }
        AppMethodBeat.o(48121);
        return true;
      }
      boolean bool = super.isEnabled(paramInt);
      AppMethodBeat.o(48121);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI
 * JD-Core Version:    0.7.0.1
 */