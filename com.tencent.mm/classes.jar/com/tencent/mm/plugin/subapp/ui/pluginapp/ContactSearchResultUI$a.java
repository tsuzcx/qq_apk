package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.d.b.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(25517);
    int i = ContactSearchResultUI.b(this.sZz).size();
    int j = ContactSearchResultUI.c(this.sZz).size();
    AppMethodBeat.o(25517);
    return i + j;
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
    AppMethodBeat.i(25518);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.mContext, 2130970630, null);
      paramViewGroup = new ContactSearchResultUI.c();
      paramViewGroup.egq = ((ImageView)localView.findViewById(2131823768));
      paramViewGroup.ejj = ((TextView)localView.findViewById(2131824394));
      paramViewGroup.jTc = localView.findViewById(2131824397);
      paramViewGroup.jTd = ((TextView)localView.findViewById(2131824399));
      paramViewGroup.jTg = localView.findViewById(2131824396);
      localView.setTag(paramViewGroup);
    }
    for (;;)
    {
      if (paramInt >= ContactSearchResultUI.b(this.sZz).size())
      {
        paramView = (bxw)ContactSearchResultUI.c(this.sZz).get(paramInt - ContactSearchResultUI.b(this.sZz).size());
        paramViewGroup.username = paramView.jJA;
        a.b.s(paramViewGroup.egq, paramViewGroup.username);
        paramViewGroup.egq.setTag(paramViewGroup.username);
        a.b.c(paramViewGroup.egq, paramViewGroup.username);
        paramViewGroup.jTc.setVisibility(8);
        paramViewGroup.jTg.setVisibility(8);
        paramViewGroup.jTd.setText("");
        try
        {
          paramViewGroup.ejj.setText(j.b(this.mContext, paramView.jKG, paramViewGroup.ejj.getTextSize()));
          AppMethodBeat.o(25518);
          return localView;
          paramViewGroup = (ContactSearchResultUI.c)paramView.getTag();
          localView = paramView;
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            paramViewGroup.ejj.setText("");
          }
        }
      }
    }
    bxf localbxf = (bxf)ContactSearchResultUI.b(this.sZz).get(paramInt);
    if (localbxf == null)
    {
      ab.e("MicroMsg.ContactSearchResultAdapter", "shouldnot be empty");
      AppMethodBeat.o(25518);
      return localView;
    }
    paramViewGroup.username = localbxf.wOT.xJE;
    a.b.s(paramViewGroup.egq, paramViewGroup.username);
    paramViewGroup.egq.setTag(paramViewGroup.username);
    a.b.c(paramViewGroup.egq, paramViewGroup.username);
    String str = localbxf.wOT.xJE;
    Object localObject1 = (ContactSearchResultUI.b)ContactSearchResultUI.d(this.sZz).get(str);
    paramView = (View)localObject1;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = new ContactSearchResultUI.b((byte)0);
      ContactSearchResultUI.d(this.sZz).put(str, localObject1);
      paramView = localbxf.xpl;
      if (paramView != null)
      {
        localObject2 = new d();
        ((d)localObject2).field_username = str;
        ((d)localObject2).field_brandFlag = paramView.gxd;
        ((d)localObject2).field_brandIconURL = paramView.gxg;
        ((d)localObject2).field_brandInfo = paramView.gxf;
        ((d)localObject2).field_extInfo = paramView.gxe;
        if (((d)localObject2).cU(false) == null) {
          break label797;
        }
      }
    }
    label797:
    for (paramView = ((d)localObject2).cU(false).aeB();; paramView = null)
    {
      boolean bool;
      if (paramView != null)
      {
        if ((!((d)localObject2).cU(false).aeD()) || (bo.isNullOrNil(paramView.fvS))) {
          break label718;
        }
        bool = true;
      }
      for (;;)
      {
        ((ContactSearchResultUI.b)localObject1).jTa = bool;
        if (localbxf.xpe != 0)
        {
          bool = true;
          label547:
          ((ContactSearchResultUI.b)localObject1).jSZ = bool;
          paramView = (View)localObject1;
          localObject1 = paramViewGroup.jTc;
          if (!paramView.jSZ) {
            break label730;
          }
          paramInt = 0;
          ((View)localObject1).setVisibility(paramInt);
          localObject1 = paramViewGroup.jTg;
          paramInt = i;
          if (paramView.jTa) {
            paramInt = 0;
          }
          ((View)localObject1).setVisibility(paramInt);
          ab.v("MicroMsg.ContactSearchResultAdapter", "verifyFlay : %d", new Object[] { Integer.valueOf(localbxf.xpe) });
          paramView = bo.nullAsNil(localbxf.gwS);
        }
        try
        {
          paramViewGroup.jTd.setText(j.b(this.mContext, paramView, paramViewGroup.jTd.getTextSize()));
          try
          {
            localObject1 = paramViewGroup.ejj;
            localObject2 = this.mContext;
            if (bo.isNullOrNil(localbxf.xmi.xJE)) {
              break label749;
            }
            paramView = localbxf.xmi.xJE;
            ((TextView)localObject1).setText(j.b((Context)localObject2, paramView, paramViewGroup.ejj.getTextSize()));
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              paramViewGroup.ejj.setText("");
            }
          }
          AppMethodBeat.o(25518);
          return localView;
          label718:
          bool = false;
          continue;
          bool = false;
          break label547;
          label730:
          paramInt = 8;
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            paramViewGroup.jTd.setText("");
            continue;
            label749:
            if (!bo.isNullOrNil(localbxf.gwU)) {
              paramView = localbxf.gwU;
            } else {
              paramView = bo.nullAsNil(localbxf.wOT.xJE);
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