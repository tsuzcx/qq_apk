package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private Context context;
  private List<b.a> fvr;
  private String iJd;
  private List<b.a> list;
  int[] tNQ;
  boolean tNR;
  
  public c(Context paramContext, List<b.a> paramList)
  {
    AppMethodBeat.i(38986);
    this.fvr = new ArrayList();
    this.tNR = false;
    this.context = paramContext;
    this.list = paramList;
    cVn();
    cVo();
    AppMethodBeat.o(38986);
  }
  
  private static String Hk(int paramInt)
  {
    AppMethodBeat.i(38993);
    if (ab.eUM())
    {
      String str = Integer.toString(paramInt) + "劃";
      AppMethodBeat.o(38993);
      return str;
    }
    char c = (char)paramInt;
    AppMethodBeat.o(38993);
    return String.valueOf(c);
  }
  
  private void cVn()
  {
    AppMethodBeat.i(38987);
    int i = 0;
    int j = this.list.size();
    while (i < j)
    {
      this.fvr.add(this.list.get(i));
      i += 1;
    }
    AppMethodBeat.o(38987);
  }
  
  private void cVo()
  {
    AppMethodBeat.i(38988);
    this.tNQ = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.tNQ[i] = ((b.a)this.list.get(i)).hLt;
      i += 1;
    }
    AppMethodBeat.o(38988);
  }
  
  public final void FZ(String paramString)
  {
    AppMethodBeat.i(38991);
    if (paramString != null)
    {
      this.iJd = paramString.trim();
      this.list.clear();
      int j = this.fvr.size();
      int i = 0;
      while (i < j)
      {
        if ((((b.a)this.fvr.get(i)).hLr.toUpperCase().contains(this.iJd.toUpperCase())) || (((b.a)this.fvr.get(i)).hLs.toUpperCase().contains(this.iJd.toUpperCase())) || (((b.a)this.fvr.get(i)).hLq.contains(this.iJd))) {
          this.list.add(this.fvr.get(i));
        }
        i += 1;
      }
      cVo();
      super.notifyDataSetChanged();
    }
    AppMethodBeat.o(38991);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(38989);
    int i = this.list.size();
    AppMethodBeat.o(38989);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(38990);
    Object localObject = this.list.get(paramInt);
    AppMethodBeat.o(38990);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38992);
    b.a locala = (b.a)getItem(paramInt);
    label88:
    int i;
    if (paramView == null) {
      if (!ab.eUM())
      {
        paramView = View.inflate(this.context, 2131493668, null);
        paramViewGroup = new a();
        paramViewGroup.tNT = ((TextView)paramView.findViewById(2131298724));
        paramViewGroup.fwp = ((TextView)paramView.findViewById(2131298729));
        paramViewGroup.tNU = ((TextView)paramView.findViewById(2131298734));
        paramView.setTag(paramViewGroup);
        if (paramInt <= 0) {
          break label201;
        }
        i = this.tNQ[(paramInt - 1)];
        label102:
        if (paramInt != 0) {
          break label207;
        }
        paramViewGroup.tNT.setVisibility(0);
        paramViewGroup.tNT.setText(Hk(this.tNQ[paramInt]));
        label130:
        paramViewGroup.fwp.setText(locala.hLr);
        paramViewGroup.tNU.setText(locala.hLq);
        if (!this.tNR) {
          break label261;
        }
        paramViewGroup.tNU.setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(38992);
      return paramView;
      paramView = View.inflate(this.context, 2131493669, null);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label88;
      label201:
      i = -1;
      break label102;
      label207:
      if ((paramInt > 0) && (this.tNQ[paramInt] != i))
      {
        paramViewGroup.tNT.setVisibility(0);
        paramViewGroup.tNT.setText(Hk(this.tNQ[paramInt]));
        break label130;
      }
      paramViewGroup.tNT.setVisibility(8);
      break label130;
      label261:
      paramViewGroup.tNU.setVisibility(4);
    }
  }
  
  static final class a
  {
    TextView fwp;
    TextView tNT;
    TextView tNU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */