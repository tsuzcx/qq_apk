package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dky;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.List;

final class WalletUniversalPayOrderUI$a
  extends BaseAdapter
{
  private Context mContext;
  List<dky> nZP;
  
  public WalletUniversalPayOrderUI$a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private dky TC(int paramInt)
  {
    AppMethodBeat.i(69832);
    if (this.nZP == null)
    {
      AppMethodBeat.o(69832);
      return null;
    }
    dky localdky = (dky)this.nZP.get(paramInt);
    AppMethodBeat.o(69832);
    return localdky;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(69831);
    if (this.nZP == null)
    {
      AppMethodBeat.o(69831);
      return 0;
    }
    int i = this.nZP.size();
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
    paramView = TC(paramInt);
    paramViewGroup = (WalletUniversalPayOrderUI.b)localView.getTag();
    paramViewGroup.Boa.setImageBitmap(null);
    paramViewGroup.Boa.fE(paramView.hhs, 2131234429);
    paramViewGroup.Bob.setText(paramView.tGS);
    AppMethodBeat.o(69833);
    return localView;
  }
  
  public final void iv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(69830);
    ac.i("MicroMsg.WalletUniversalPayOrderUI", "swipe: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    dky localdky = (dky)this.nZP.remove(paramInt1);
    this.nZP.add(paramInt2, localdky);
    AppMethodBeat.o(69830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.a
 * JD-Core Version:    0.7.0.1
 */