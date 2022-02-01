package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ax.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private Context context;
  private List<b.a> frK;
  private String iiW;
  private List<b.a> list;
  int[] sGj;
  boolean sGk;
  
  public c(Context paramContext, List<b.a> paramList)
  {
    AppMethodBeat.i(38986);
    this.frK = new ArrayList();
    this.sGk = false;
    this.context = paramContext;
    this.list = paramList;
    cIc();
    cId();
    AppMethodBeat.o(38986);
  }
  
  private static String Fp(int paramInt)
  {
    AppMethodBeat.i(38993);
    if (ac.eFs())
    {
      String str = Integer.toString(paramInt) + "劃";
      AppMethodBeat.o(38993);
      return str;
    }
    char c = (char)paramInt;
    AppMethodBeat.o(38993);
    return String.valueOf(c);
  }
  
  private void cIc()
  {
    AppMethodBeat.i(38987);
    int i = 0;
    int j = this.list.size();
    while (i < j)
    {
      this.frK.add(this.list.get(i));
      i += 1;
    }
    AppMethodBeat.o(38987);
  }
  
  private void cId()
  {
    AppMethodBeat.i(38988);
    this.sGj = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.sGj[i] = ((b.a)this.list.get(i)).hkQ;
      i += 1;
    }
    AppMethodBeat.o(38988);
  }
  
  public final void BW(String paramString)
  {
    AppMethodBeat.i(38991);
    if (paramString != null)
    {
      this.iiW = paramString.trim();
      this.list.clear();
      int j = this.frK.size();
      int i = 0;
      while (i < j)
      {
        if ((((b.a)this.frK.get(i)).hkO.toUpperCase().contains(this.iiW.toUpperCase())) || (((b.a)this.frK.get(i)).hkP.toUpperCase().contains(this.iiW.toUpperCase())) || (((b.a)this.frK.get(i)).hkN.contains(this.iiW))) {
          this.list.add(this.frK.get(i));
        }
        i += 1;
      }
      cId();
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
      if (!ac.eFs())
      {
        paramView = View.inflate(this.context, 2131493668, null);
        paramViewGroup = new a();
        paramViewGroup.sGm = ((TextView)paramView.findViewById(2131298724));
        paramViewGroup.fsI = ((TextView)paramView.findViewById(2131298729));
        paramViewGroup.sGn = ((TextView)paramView.findViewById(2131298734));
        paramView.setTag(paramViewGroup);
        if (paramInt <= 0) {
          break label201;
        }
        i = this.sGj[(paramInt - 1)];
        label102:
        if (paramInt != 0) {
          break label207;
        }
        paramViewGroup.sGm.setVisibility(0);
        paramViewGroup.sGm.setText(Fp(this.sGj[paramInt]));
        label130:
        paramViewGroup.fsI.setText(locala.hkO);
        paramViewGroup.sGn.setText(locala.hkN);
        if (!this.sGk) {
          break label261;
        }
        paramViewGroup.sGn.setVisibility(0);
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
      if ((paramInt > 0) && (this.sGj[paramInt] != i))
      {
        paramViewGroup.sGm.setVisibility(0);
        paramViewGroup.sGm.setText(Fp(this.sGj[paramInt]));
        break label130;
      }
      paramViewGroup.sGm.setVisibility(8);
      break label130;
      label261:
      paramViewGroup.sGn.setVisibility(4);
    }
  }
  
  static final class a
  {
    TextView fsI;
    TextView sGm;
    TextView sGn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */