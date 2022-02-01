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
  private List<b.a> fOy;
  private String jcm;
  private List<b.a> list;
  int[] uQD;
  boolean uQE;
  
  public c(Context paramContext, List<b.a> paramList)
  {
    AppMethodBeat.i(38986);
    this.fOy = new ArrayList();
    this.uQE = false;
    this.context = paramContext;
    this.list = paramList;
    dey();
    dez();
    AppMethodBeat.o(38986);
  }
  
  private static String IG(int paramInt)
  {
    AppMethodBeat.i(38993);
    if (ac.fkq())
    {
      String str = Integer.toString(paramInt) + "劃";
      AppMethodBeat.o(38993);
      return str;
    }
    char c = (char)paramInt;
    AppMethodBeat.o(38993);
    return String.valueOf(c);
  }
  
  private void dey()
  {
    AppMethodBeat.i(38987);
    int i = 0;
    int j = this.list.size();
    while (i < j)
    {
      this.fOy.add(this.list.get(i));
      i += 1;
    }
    AppMethodBeat.o(38987);
  }
  
  private void dez()
  {
    AppMethodBeat.i(38988);
    this.uQD = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.uQD[i] = ((b.a)this.list.get(i)).ieo;
      i += 1;
    }
    AppMethodBeat.o(38988);
  }
  
  public final void Jo(String paramString)
  {
    AppMethodBeat.i(38991);
    if (paramString != null)
    {
      this.jcm = paramString.trim();
      this.list.clear();
      int j = this.fOy.size();
      int i = 0;
      while (i < j)
      {
        if ((((b.a)this.fOy.get(i)).iem.toUpperCase().contains(this.jcm.toUpperCase())) || (((b.a)this.fOy.get(i)).ien.toUpperCase().contains(this.jcm.toUpperCase())) || (((b.a)this.fOy.get(i)).iel.contains(this.jcm))) {
          this.list.add(this.fOy.get(i));
        }
        i += 1;
      }
      dez();
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
      if (!ac.fkq())
      {
        paramView = View.inflate(this.context, 2131493668, null);
        paramViewGroup = new a();
        paramViewGroup.uQG = ((TextView)paramView.findViewById(2131298724));
        paramViewGroup.fPC = ((TextView)paramView.findViewById(2131298729));
        paramViewGroup.uQH = ((TextView)paramView.findViewById(2131298734));
        paramView.setTag(paramViewGroup);
        if (paramInt <= 0) {
          break label201;
        }
        i = this.uQD[(paramInt - 1)];
        label102:
        if (paramInt != 0) {
          break label207;
        }
        paramViewGroup.uQG.setVisibility(0);
        paramViewGroup.uQG.setText(IG(this.uQD[paramInt]));
        label130:
        paramViewGroup.fPC.setText(locala.iem);
        paramViewGroup.uQH.setText(locala.iel);
        if (!this.uQE) {
          break label261;
        }
        paramViewGroup.uQH.setVisibility(0);
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
      if ((paramInt > 0) && (this.uQD[paramInt] != i))
      {
        paramViewGroup.uQG.setVisibility(0);
        paramViewGroup.uQG.setText(IG(this.uQD[paramInt]));
        break label130;
      }
      paramViewGroup.uQG.setVisibility(8);
      break label130;
      label261:
      paramViewGroup.uQH.setVisibility(4);
    }
  }
  
  static final class a
  {
    TextView fPC;
    TextView uQG;
    TextView uQH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */