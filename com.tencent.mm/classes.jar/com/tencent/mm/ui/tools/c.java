package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private List<b.a> bXV;
  private Context context;
  private String kdi;
  private List<b.a> list;
  int[] yuP;
  boolean yuQ;
  
  public c(Context paramContext, List<b.a> paramList)
  {
    AppMethodBeat.i(38986);
    this.bXV = new ArrayList();
    this.yuQ = false;
    this.context = paramContext;
    this.list = paramList;
    ebk();
    ebl();
    AppMethodBeat.o(38986);
  }
  
  private static String Ph(int paramInt)
  {
    AppMethodBeat.i(38993);
    if (LocaleUtil.isTraditionalChineseAppLang())
    {
      String str = Integer.toString(paramInt) + "劃";
      AppMethodBeat.o(38993);
      return str;
    }
    char c = (char)paramInt;
    AppMethodBeat.o(38993);
    return String.valueOf(c);
  }
  
  private void ebk()
  {
    AppMethodBeat.i(38987);
    int i = 0;
    int j = this.list.size();
    while (i < j)
    {
      this.bXV.add(this.list.get(i));
      i += 1;
    }
    AppMethodBeat.o(38987);
  }
  
  private void ebl()
  {
    AppMethodBeat.i(38988);
    this.yuP = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.yuP[i] = ((b.a)this.list.get(i)).jcb;
      i += 1;
    }
    AppMethodBeat.o(38988);
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(38991);
    if (paramString != null)
    {
      this.kdi = paramString.trim();
      this.list.clear();
      int j = this.bXV.size();
      int i = 0;
      while (i < j)
      {
        if ((((b.a)this.bXV.get(i)).jbZ.toUpperCase().contains(this.kdi.toUpperCase())) || (((b.a)this.bXV.get(i)).jca.toUpperCase().contains(this.kdi.toUpperCase())) || (((b.a)this.bXV.get(i)).jbY.contains(this.kdi))) {
          this.list.add(this.bXV.get(i));
        }
        i += 1;
      }
      ebl();
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
      if (!LocaleUtil.isTraditionalChineseAppLang())
      {
        paramView = View.inflate(this.context, 2131493798, null);
        paramViewGroup = new a();
        paramViewGroup.yuS = ((TextView)paramView.findViewById(2131299162));
        paramViewGroup.gwR = ((TextView)paramView.findViewById(2131299167));
        paramViewGroup.yuT = ((TextView)paramView.findViewById(2131299172));
        paramView.setTag(paramViewGroup);
        if (paramInt <= 0) {
          break label201;
        }
        i = this.yuP[(paramInt - 1)];
        label102:
        if (paramInt != 0) {
          break label207;
        }
        paramViewGroup.yuS.setVisibility(0);
        paramViewGroup.yuS.setText(Ph(this.yuP[paramInt]));
        label130:
        paramViewGroup.gwR.setText(locala.jbZ);
        paramViewGroup.yuT.setText(locala.jbY);
        if (!this.yuQ) {
          break label261;
        }
        paramViewGroup.yuT.setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(38992);
      return paramView;
      paramView = View.inflate(this.context, 2131493799, null);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label88;
      label201:
      i = -1;
      break label102;
      label207:
      if ((paramInt > 0) && (this.yuP[paramInt] != i))
      {
        paramViewGroup.yuS.setVisibility(0);
        paramViewGroup.yuS.setText(Ph(this.yuP[paramInt]));
        break label130;
      }
      paramViewGroup.yuS.setVisibility(8);
      break label130;
      label261:
      paramViewGroup.yuT.setVisibility(4);
    }
  }
  
  static final class a
  {
    TextView gwR;
    TextView yuS;
    TextView yuT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */