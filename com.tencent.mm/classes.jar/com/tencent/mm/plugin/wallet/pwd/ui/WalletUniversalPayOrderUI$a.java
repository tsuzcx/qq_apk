package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.eli;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

final class WalletUniversalPayOrderUI$a
  extends BaseAdapter
{
  private Context mContext;
  List<eli> pXz;
  
  public WalletUniversalPayOrderUI$a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private eli aeE(int paramInt)
  {
    AppMethodBeat.i(69832);
    if (this.pXz == null)
    {
      AppMethodBeat.o(69832);
      return null;
    }
    eli localeli = (eli)this.pXz.get(paramInt);
    AppMethodBeat.o(69832);
    return localeli;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(69831);
    if (this.pXz == null)
    {
      AppMethodBeat.o(69831);
      return 0;
    }
    int i = this.pXz.size();
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
      localView = LayoutInflater.from(this.mContext).inflate(2131496924, paramViewGroup, false);
      localView.setTag(new WalletUniversalPayOrderUI.b(localView));
    }
    paramView = aeE(paramInt);
    paramViewGroup = (WalletUniversalPayOrderUI.b)localView.getTag();
    paramViewGroup.HLU.setImageBitmap(null);
    paramViewGroup.HLU.gI(paramView.iwv, 2131235359);
    paramViewGroup.HLV.setText(paramView.ynT);
    AppMethodBeat.o(69833);
    return localView;
  }
  
  public final void jS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(69830);
    Log.i("MicroMsg.WalletUniversalPayOrderUI", "swipe: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    eli localeli = (eli)this.pXz.remove(paramInt1);
    this.pXz.add(paramInt2, localeli);
    AppMethodBeat.o(69830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.a
 * JD-Core Version:    0.7.0.1
 */