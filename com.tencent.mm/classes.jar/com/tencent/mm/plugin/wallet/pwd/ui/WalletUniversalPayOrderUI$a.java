package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dfj;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;

final class WalletUniversalPayOrderUI$a
  extends BaseAdapter
{
  private Context mContext;
  List<dfj> nwP;
  
  public WalletUniversalPayOrderUI$a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private dfj Rt(int paramInt)
  {
    AppMethodBeat.i(69832);
    if (this.nwP == null)
    {
      AppMethodBeat.o(69832);
      return null;
    }
    dfj localdfj = (dfj)this.nwP.get(paramInt);
    AppMethodBeat.o(69832);
    return localdfj;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(69831);
    if (this.nwP == null)
    {
      AppMethodBeat.o(69831);
      return 0;
    }
    int i = this.nwP.size();
    AppMethodBeat.o(69831);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(69833);
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.mContext).inflate(2131495944, paramViewGroup, false);
      localView.setTag(new WalletUniversalPayOrderUI.b(localView));
    }
    paramView = Rt(paramInt);
    paramViewGroup = (WalletUniversalPayOrderUI.b)localView.getTag();
    paramViewGroup.zVG.setImageBitmap(null);
    paramViewGroup.zVG.fz(paramView.gGR, 2131234429);
    paramViewGroup.zVH.setText(paramView.szi);
    AppMethodBeat.o(69833);
    return localView;
  }
  
  public final void ig(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(69830);
    ad.i("MicroMsg.WalletUniversalPayOrderUI", "swipe: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    dfj localdfj = (dfj)this.nwP.remove(paramInt1);
    this.nwP.add(paramInt2, localdfj);
    AppMethodBeat.o(69830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.a
 * JD-Core Version:    0.7.0.1
 */