package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.d.b.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.bob;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Map;

final class ContactSearchResultUI$a
  extends BaseAdapter
{
  private Context mContext;
  
  public ContactSearchResultUI$a(ContactSearchResultUI paramContactSearchResultUI, Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final int getCount()
  {
    return ContactSearchResultUI.b(this.pxL).size() + ContactSearchResultUI.c(this.pxL).size();
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 8;
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.mContext, R.i.search_or_recommend_biz_item, null);
      paramViewGroup = new ContactSearchResultUI.c();
      paramViewGroup.doU = ((ImageView)localView.findViewById(R.h.avatarIV));
      paramViewGroup.drB = ((TextView)localView.findViewById(R.h.nicknameTV));
      paramViewGroup.icm = localView.findViewById(R.h.verifyIV);
      paramViewGroup.icn = ((TextView)localView.findViewById(R.h.introduceTV));
      paramViewGroup.icq = localView.findViewById(R.h.bizTrademarkProtectionIV);
      localView.setTag(paramViewGroup);
    }
    while (paramInt >= ContactSearchResultUI.b(this.pxL).size())
    {
      paramView = (bob)ContactSearchResultUI.c(this.pxL).get(paramInt - ContactSearchResultUI.b(this.pxL).size());
      paramViewGroup.username = paramView.hPY;
      a.b.n(paramViewGroup.doU, paramViewGroup.username);
      paramViewGroup.doU.setTag(paramViewGroup.username);
      a.b.a(paramViewGroup.doU, paramViewGroup.username);
      paramViewGroup.icm.setVisibility(8);
      paramViewGroup.icq.setVisibility(8);
      paramViewGroup.icn.setText("");
      try
      {
        paramViewGroup.drB.setText(j.a(this.mContext, paramView.hRf, paramViewGroup.drB.getTextSize()));
        return localView;
      }
      catch (Exception paramView)
      {
        paramViewGroup.drB.setText("");
        return localView;
      }
      paramViewGroup = (ContactSearchResultUI.c)paramView.getTag();
      localView = paramView;
    }
    bnk localbnk = (bnk)ContactSearchResultUI.b(this.pxL).get(paramInt);
    if (localbnk == null)
    {
      y.e("MicroMsg.ContactSearchResultAdapter", "shouldnot be empty");
      return localView;
    }
    paramViewGroup.username = localbnk.sQs.tFO;
    a.b.n(paramViewGroup.doU, paramViewGroup.username);
    paramViewGroup.doU.setTag(paramViewGroup.username);
    a.b.a(paramViewGroup.doU, paramViewGroup.username);
    String str = localbnk.sQs.tFO;
    Object localObject1 = (ContactSearchResultUI.b)ContactSearchResultUI.d(this.pxL).get(str);
    paramView = (View)localObject1;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = new ContactSearchResultUI.b((byte)0);
      ContactSearchResultUI.d(this.pxL).put(str, localObject1);
      paramView = localbnk.tpn;
      if (paramView != null)
      {
        localObject2 = new d();
        ((d)localObject2).field_username = str;
        ((d)localObject2).field_brandFlag = paramView.ffv;
        ((d)localObject2).field_brandIconURL = paramView.ffy;
        ((d)localObject2).field_brandInfo = paramView.ffx;
        ((d)localObject2).field_extInfo = paramView.ffw;
        if (((d)localObject2).bS(false) == null) {
          break label779;
        }
      }
    }
    label779:
    for (paramView = ((d)localObject2).bS(false).LT();; paramView = null)
    {
      boolean bool;
      if (paramView != null)
      {
        if ((!((d)localObject2).bS(false).LV()) || (bk.bl(paramView.efQ))) {
          break label713;
        }
        bool = true;
      }
      for (;;)
      {
        ((ContactSearchResultUI.b)localObject1).ick = bool;
        if (localbnk.tpg != 0)
        {
          bool = true;
          label535:
          ((ContactSearchResultUI.b)localObject1).icj = bool;
          paramView = (View)localObject1;
          localObject1 = paramViewGroup.icm;
          if (!paramView.icj) {
            break label725;
          }
          paramInt = 0;
          ((View)localObject1).setVisibility(paramInt);
          localObject1 = paramViewGroup.icq;
          paramInt = i;
          if (paramView.ick) {
            paramInt = 0;
          }
          ((View)localObject1).setVisibility(paramInt);
          y.v("MicroMsg.ContactSearchResultAdapter", "verifyFlay : %d", new Object[] { Integer.valueOf(localbnk.tpg) });
          paramView = bk.pm(localbnk.ffk);
        }
        try
        {
          paramViewGroup.icn.setText(j.a(this.mContext, paramView, paramViewGroup.icn.getTextSize()));
          try
          {
            localObject1 = paramViewGroup.drB;
            localObject2 = this.mContext;
            if (bk.bl(localbnk.tmw.tFO)) {
              break label744;
            }
            paramView = localbnk.tmw.tFO;
            ((TextView)localObject1).setText(j.a((Context)localObject2, paramView, paramViewGroup.drB.getTextSize()));
            return localView;
          }
          catch (Exception paramView)
          {
            paramViewGroup.drB.setText("");
            return localView;
          }
          label713:
          bool = false;
          continue;
          bool = false;
          break label535;
          label725:
          paramInt = 8;
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            paramViewGroup.icn.setText("");
            continue;
            label744:
            if (!bk.bl(localbnk.ffm)) {
              paramView = localbnk.ffm;
            } else {
              paramView = bk.pm(localbnk.sQs.tFO);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI.a
 * JD-Core Version:    0.7.0.1
 */