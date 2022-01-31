package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.gridviewheaders.a;
import java.util.Date;

public final class c
  extends RecyclerView.a
{
  public static e voq;
  public static c.f vor = null;
  private Context mContext;
  public String vos;
  
  public c(Context paramContext, c.f paramf)
  {
    vor = paramf;
    this.mContext = paramContext;
  }
  
  private static long eM(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return a.cIz().b(localDate);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 2147483647) {
      return new c.d(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.gallery_date_item, paramViewGroup, false));
    }
    return vor.q(paramViewGroup);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    int i = getItemViewType(paramInt);
    c.b localb = vor.Ha(paramInt);
    Object localObject;
    if (i == 2147483647)
    {
      localObject = vor.Ha(paramInt + 1);
      if ((paramInt == getItemCount() - 1) || (eM(((c.b)localObject).timestamp) != eM(localb.timestamp)))
      {
        ((c.d)paramv).eXs.setVisibility(8);
        return;
      }
      ((c.d)paramv).eXs.setVisibility(0);
      ((c.d)paramv).eXs.setText(eL(localb.timestamp));
      return;
    }
    c.a locala = (c.a)paramv;
    locala.kKz.setTag(Integer.valueOf(paramInt));
    if (i != 33) {
      a.b.a(locala.doU, localb.username);
    }
    TextView localTextView = locala.fhD;
    Context localContext = this.mContext;
    if (bk.bl(this.vos)) {
      if (bk.bl(localb.aVs)) {
        if (bk.bl(localb.hkV)) {
          localObject = localb.nickname;
        }
      }
    }
    for (;;)
    {
      localTextView.setText(com.tencent.mm.pluginsdk.ui.d.j.a(localContext, (CharSequence)localObject, locala.fhD.getTextSize()));
      locala.dsz.setText(com.tencent.mm.plugin.fav.ui.j.f(this.mContext, localb.timestamp));
      locala.eXO.setText(localb.title);
      vor.a((c.a)paramv, paramInt);
      if (bk.bl(this.vos)) {
        break;
      }
      c.a.e(locala.fhD, this.vos);
      c.a.e(locala.eXO, this.vos);
      return;
      localObject = localb.hkV;
      continue;
      localObject = localb.aVs;
      continue;
      if (bk.bl(localb.aVs))
      {
        if (!bk.bl(localb.hkV))
        {
          if ((!bk.bl(localb.nickname)) && (localb.nickname.contains(this.vos))) {
            localObject = localb.hkV + "(" + localb.nickname + ")";
          } else {
            localObject = localb.hkV;
          }
        }
        else {
          localObject = localb.nickname;
        }
      }
      else if ((!bk.bl(localb.hkV)) && (localb.hkV.contains(this.vos))) {
        localObject = localb.aVs + "(" + localb.hkV + ")";
      } else if ((!bk.bl(localb.nickname)) && (localb.nickname.contains(this.vos))) {
        localObject = localb.aVs + "(" + localb.nickname + ")";
      } else {
        localObject = localb.aVs;
      }
    }
  }
  
  public final String eL(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return a.cIz().a(localDate, this.mContext);
  }
  
  public final int getItemCount()
  {
    int i;
    if (vor == null)
    {
      i = 0;
      if (vor != null) {
        break label55;
      }
    }
    label55:
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.MediaHistoryListAdapter", " null == mIDetail?%s getItemCount:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      return i;
      i = vor.getCount();
      break;
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    return vor.Ha(paramInt).getType();
  }
  
  public static abstract interface e
  {
    public abstract void a(int paramInt, c.b paramb);
    
    public abstract void a(View paramView, int paramInt, c.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.c
 * JD-Core Version:    0.7.0.1
 */