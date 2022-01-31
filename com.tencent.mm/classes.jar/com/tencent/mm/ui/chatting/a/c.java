package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.gridviewheaders.a;
import java.util.Date;

public final class c
  extends RecyclerView.a
{
  public static c.e zDM;
  public static c.f zDN = null;
  private Context mContext;
  public String zDO;
  
  public c(Context paramContext, c.f paramf)
  {
    zDN = paramf;
    this.mContext = paramContext;
  }
  
  private static long io(long paramLong)
  {
    AppMethodBeat.i(31159);
    Date localDate = new Date(paramLong);
    paramLong = a.dNj().b(localDate);
    AppMethodBeat.o(31159);
    return paramLong;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(31155);
    if (paramInt == 2147483647)
    {
      paramViewGroup = new c.d(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2130969685, paramViewGroup, false));
      AppMethodBeat.o(31155);
      return paramViewGroup;
    }
    paramViewGroup = zDN.v(paramViewGroup);
    AppMethodBeat.o(31155);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(31156);
    int i = getItemViewType(paramInt);
    c.b localb = zDN.PD(paramInt);
    Object localObject;
    if (i == 2147483647)
    {
      localObject = zDN.PD(paramInt + 1);
      if ((paramInt == getItemCount() - 1) || (io(((c.b)localObject).timestamp) != io(localb.timestamp)))
      {
        ((c.d)paramv).gpp.setVisibility(8);
        AppMethodBeat.o(31156);
        return;
      }
      ((c.d)paramv).gpp.setVisibility(0);
      ((c.d)paramv).gpp.setText(in(localb.timestamp));
      AppMethodBeat.o(31156);
      return;
    }
    c.a locala = (c.a)paramv;
    locala.ngZ.setTag(Integer.valueOf(paramInt));
    a.b.c(locala.egq, localb.username);
    TextView localTextView = locala.gzk;
    Context localContext = this.mContext;
    if (bo.isNullOrNil(this.zDO)) {
      if (bo.isNullOrNil(localb.bma)) {
        if (bo.isNullOrNil(localb.iXn)) {
          localObject = localb.nickname;
        }
      }
    }
    for (;;)
    {
      localTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.b(localContext, (CharSequence)localObject, locala.gzk.getTextSize()));
      locala.ekh.setText(com.tencent.mm.plugin.fav.ui.j.g(this.mContext, localb.timestamp));
      locala.gpL.setText(localb.title);
      zDN.a((c.a)paramv, paramInt);
      if (!bo.isNullOrNil(this.zDO))
      {
        c.a.c(locala.gzk, this.zDO);
        c.a.c(locala.gpL, this.zDO);
      }
      AppMethodBeat.o(31156);
      return;
      localObject = localb.iXn;
      continue;
      localObject = localb.bma;
      continue;
      if (bo.isNullOrNil(localb.bma))
      {
        if (!bo.isNullOrNil(localb.iXn))
        {
          if ((!bo.isNullOrNil(localb.nickname)) && (localb.nickname.contains(this.zDO))) {
            localObject = localb.iXn + "(" + localb.nickname + ")";
          } else {
            localObject = localb.iXn;
          }
        }
        else {
          localObject = localb.nickname;
        }
      }
      else if ((!bo.isNullOrNil(localb.iXn)) && (localb.iXn.contains(this.zDO))) {
        localObject = localb.bma + "(" + localb.iXn + ")";
      } else if ((!bo.isNullOrNil(localb.nickname)) && (localb.nickname.contains(this.zDO))) {
        localObject = localb.bma + "(" + localb.nickname + ")";
      } else {
        localObject = localb.bma;
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(31157);
    int i;
    if (zDN == null)
    {
      i = 0;
      if (zDN != null) {
        break label67;
      }
    }
    label67:
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.MediaHistoryListAdapter", " null == mIDetail?%s getItemCount:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(31157);
      return i;
      i = zDN.getCount();
      break;
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(31154);
    paramInt = zDN.PD(paramInt).getType();
    AppMethodBeat.o(31154);
    return paramInt;
  }
  
  public final String in(long paramLong)
  {
    AppMethodBeat.i(31158);
    Object localObject = new Date(paramLong);
    localObject = a.dNj().a((Date)localObject, this.mContext);
    AppMethodBeat.o(31158);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.c
 * JD-Core Version:    0.7.0.1
 */