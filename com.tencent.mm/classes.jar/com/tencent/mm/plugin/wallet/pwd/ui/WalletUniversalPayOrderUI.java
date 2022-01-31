package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.wallet.pwd.a.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cmj;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.List;

public class WalletUniversalPayOrderUI
  extends WalletBaseUI
{
  private ViewGroup kyN;
  private ViewGroup lmd;
  private DragSortListView uaS;
  private a uaT;
  private TextView uaU;
  private TextView uaV;
  private TextView uaW;
  private MMSwitchBtn uaX;
  private TextView uaY;
  private TextView uaZ;
  private Dialog uba;
  private boolean ubb = true;
  
  public int getLayoutId()
  {
    return 2130971171;
  }
  
  public void initView()
  {
    AppMethodBeat.i(46442);
    this.uaS = ((DragSortListView)findViewById(2131829112));
    this.lmd = ((ViewGroup)LayoutInflater.from(this).inflate(2130971169, null, false));
    this.uaU = ((TextView)this.lmd.findViewById(2131829104));
    this.uaV = ((TextView)this.lmd.findViewById(2131829105));
    this.uaW = ((TextView)this.lmd.findViewById(2131829106));
    this.uaX = ((MMSwitchBtn)this.lmd.findViewById(2131829107));
    this.uaY = ((TextView)this.lmd.findViewById(2131829108));
    this.uaS.addHeaderView(this.lmd, null, false);
    this.kyN = ((ViewGroup)LayoutInflater.from(this).inflate(2130971168, null, false));
    this.uaZ = ((TextView)this.kyN.findViewById(2131829103));
    this.uaS.addFooterView(this.kyN, null, false);
    this.uaT = new a(this);
    this.uaS.setAdapter(this.uaT);
    this.uaS.setDropListener(new WalletUniversalPayOrderUI.1(this));
    this.uaS.setRemoveListener(new WalletUniversalPayOrderUI.5(this));
    AppMethodBeat.o(46442);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(46439);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(-1);
    hideActionbarLine();
    setMMTitle("");
    initView();
    ab.i("MicroMsg.WalletUniversalPayOrderUI", "do query uni pay order");
    getString(2131296919);
    this.uba = com.tencent.mm.ui.base.h.b(this, getString(2131305479), false, new WalletUniversalPayOrderUI.6(this));
    new c().adl().b(new WalletUniversalPayOrderUI.7(this));
    com.tencent.mm.plugin.report.service.h.qsU.e(16343, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(46439);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends BaseAdapter
  {
    List<cmj> krw;
    private Context mContext;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    private cmj It(int paramInt)
    {
      AppMethodBeat.i(46435);
      if (this.krw == null)
      {
        AppMethodBeat.o(46435);
        return null;
      }
      cmj localcmj = (cmj)this.krw.get(paramInt);
      AppMethodBeat.o(46435);
      return localcmj;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(46434);
      if (this.krw == null)
      {
        AppMethodBeat.o(46434);
        return 0;
      }
      int i = this.krw.size();
      AppMethodBeat.o(46434);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(46436);
      View localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.mContext).inflate(2130971170, paramViewGroup, false);
        localView.setTag(new WalletUniversalPayOrderUI.b(localView));
      }
      paramView = It(paramInt);
      paramViewGroup = (WalletUniversalPayOrderUI.b)localView.getTag();
      paramViewGroup.ubf.setImageBitmap(null);
      paramViewGroup.ubf.eq(paramView.kmm, 2130840999);
      paramViewGroup.ubg.setText(paramView.nLq);
      AppMethodBeat.o(46436);
      return localView;
    }
    
    public final void gw(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(46433);
      ab.i("MicroMsg.WalletUniversalPayOrderUI", "swipe: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      cmj localcmj = (cmj)this.krw.remove(paramInt1);
      this.krw.add(paramInt2, localcmj);
      AppMethodBeat.o(46433);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI
 * JD-Core Version:    0.7.0.1
 */