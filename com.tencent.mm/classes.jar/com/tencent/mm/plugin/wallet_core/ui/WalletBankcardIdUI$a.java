package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

final class WalletBankcardIdUI$a
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  List<t> uno;
  
  public WalletBankcardIdUI$a(Context paramContext, List<t> paramList)
  {
    AppMethodBeat.i(47170);
    this.mInflater = null;
    this.uno = new LinkedList();
    this.mContext = null;
    this.mInflater = LayoutInflater.from(paramContext);
    this.uno = paramList;
    this.mContext = paramContext;
    AppMethodBeat.o(47170);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(47171);
    if (this.uno == null)
    {
      AppMethodBeat.o(47171);
      return 0;
    }
    int i = this.uno.size();
    AppMethodBeat.o(47171);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(47172);
    Object localObject = this.uno.get(paramInt);
    AppMethodBeat.o(47172);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(47173);
    Object localObject;
    if (paramView == null)
    {
      paramView = this.mInflater.inflate(2130971152, paramViewGroup, false);
      paramViewGroup = new WalletBankcardIdUI.a.a(this);
      paramViewGroup.unp = ((ImageView)paramView.findViewById(2131829031));
      paramViewGroup.qgt = ((TextView)paramView.findViewById(2131829032));
      paramViewGroup.unq = ((TextView)paramView.findViewById(2131829033));
      paramViewGroup.unr = ((TextView)paramView.findViewById(2131829034));
      paramView.setTag(paramViewGroup);
      localObject = (t)getItem(paramInt);
      if (bo.isNullOrNil(((t)localObject).ppn)) {
        break label336;
      }
      paramViewGroup.qgt.setText(((t)localObject).ppn);
      paramViewGroup.qgt.setVisibility(0);
      label128:
      if (bo.isNullOrNil(((t)localObject).tUY)) {
        break label348;
      }
      paramViewGroup.unq.setText(((t)localObject).tUY);
      paramViewGroup.unq.setVisibility(0);
      label159:
      if (bo.isNullOrNil(((t)localObject).tUa)) {
        break label360;
      }
      paramViewGroup.unr.setText(((t)localObject).tUa);
      paramViewGroup.unr.setVisibility(0);
    }
    for (;;)
    {
      String str = ((t)localObject).tVe;
      ab.v("Micromsg.WalletInputCardIDUI", "bankType:" + ((t)localObject).tVd + ", logurl:" + str);
      paramViewGroup.unp.setImageBitmap(null);
      if (!bo.isNullOrNil(str))
      {
        localObject = new c.a();
        o.ahH();
        ((c.a)localObject).eOd = null;
        ((c.a)localObject).eNP = e.eQz;
        ((c.a)localObject).eNO = b.WX(str);
        ((c.a)localObject).eNM = true;
        ((c.a)localObject).eOe = true;
        localObject = ((c.a)localObject).ahY();
        o.ahG().a(str, paramViewGroup.unp, (c)localObject);
      }
      AppMethodBeat.o(47173);
      return paramView;
      paramViewGroup = (WalletBankcardIdUI.a.a)paramView.getTag();
      break;
      label336:
      paramViewGroup.qgt.setVisibility(8);
      break label128;
      label348:
      paramViewGroup.unq.setVisibility(8);
      break label159;
      label360:
      paramViewGroup.unr.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI.a
 * JD-Core Version:    0.7.0.1
 */