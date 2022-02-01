package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private Context context;
  private List<b.a> fQE;
  private String jff;
  private List<b.a> list;
  int[] vcp;
  boolean vcq;
  
  public c(Context paramContext, List<b.a> paramList)
  {
    AppMethodBeat.i(38986);
    this.fQE = new ArrayList();
    this.vcq = false;
    this.context = paramContext;
    this.list = paramList;
    dhq();
    dhr();
    AppMethodBeat.o(38986);
  }
  
  private static String Je(int paramInt)
  {
    AppMethodBeat.i(38993);
    if (ad.fok())
    {
      String str = Integer.toString(paramInt) + "劃";
      AppMethodBeat.o(38993);
      return str;
    }
    char c = (char)paramInt;
    AppMethodBeat.o(38993);
    return String.valueOf(c);
  }
  
  private void dhq()
  {
    AppMethodBeat.i(38987);
    int i = 0;
    int j = this.list.size();
    while (i < j)
    {
      this.fQE.add(this.list.get(i));
      i += 1;
    }
    AppMethodBeat.o(38987);
  }
  
  private void dhr()
  {
    AppMethodBeat.i(38988);
    this.vcp = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.vcp[i] = ((b.a)this.list.get(i)).ihg;
      i += 1;
    }
    AppMethodBeat.o(38988);
  }
  
  public final void JN(String paramString)
  {
    AppMethodBeat.i(38991);
    if (paramString != null)
    {
      this.jff = paramString.trim();
      this.list.clear();
      int j = this.fQE.size();
      int i = 0;
      while (i < j)
      {
        if ((((b.a)this.fQE.get(i)).ihe.toUpperCase().contains(this.jff.toUpperCase())) || (((b.a)this.fQE.get(i)).ihf.toUpperCase().contains(this.jff.toUpperCase())) || (((b.a)this.fQE.get(i)).ihd.contains(this.jff))) {
          this.list.add(this.fQE.get(i));
        }
        i += 1;
      }
      dhr();
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
      if (!ad.fok())
      {
        paramView = View.inflate(this.context, 2131493668, null);
        paramViewGroup = new a();
        paramViewGroup.vcs = ((TextView)paramView.findViewById(2131298724));
        paramViewGroup.fRI = ((TextView)paramView.findViewById(2131298729));
        paramViewGroup.vct = ((TextView)paramView.findViewById(2131298734));
        paramView.setTag(paramViewGroup);
        if (paramInt <= 0) {
          break label201;
        }
        i = this.vcp[(paramInt - 1)];
        label102:
        if (paramInt != 0) {
          break label207;
        }
        paramViewGroup.vcs.setVisibility(0);
        paramViewGroup.vcs.setText(Je(this.vcp[paramInt]));
        label130:
        paramViewGroup.fRI.setText(locala.ihe);
        paramViewGroup.vct.setText(locala.ihd);
        if (!this.vcq) {
          break label261;
        }
        paramViewGroup.vct.setVisibility(0);
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
      if ((paramInt > 0) && (this.vcp[paramInt] != i))
      {
        paramViewGroup.vcs.setVisibility(0);
        paramViewGroup.vcs.setText(Je(this.vcp[paramInt]));
        break label130;
      }
      paramViewGroup.vcs.setVisibility(8);
      break label130;
      label261:
      paramViewGroup.vct.setVisibility(4);
    }
  }
  
  static final class a
  {
    TextView fRI;
    TextView vcs;
    TextView vct;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */