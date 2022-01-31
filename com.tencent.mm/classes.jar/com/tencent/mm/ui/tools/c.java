package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.au.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private Context context;
  private String gvZ;
  private List<b.a> list;
  private List<b.a> nSn;
  int[] nSp;
  boolean nSq;
  
  public c(Context paramContext, List<b.a> paramList)
  {
    AppMethodBeat.i(34793);
    this.nSn = new ArrayList();
    this.nSq = false;
    this.context = paramContext;
    this.list = paramList;
    bKg();
    bKh();
    AppMethodBeat.o(34793);
  }
  
  private void bKg()
  {
    AppMethodBeat.i(34794);
    int i = 0;
    int j = this.list.size();
    while (i < j)
    {
      this.nSn.add(this.list.get(i));
      i += 1;
    }
    AppMethodBeat.o(34794);
  }
  
  private void bKh()
  {
    AppMethodBeat.i(34795);
    this.nSp = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.nSp[i] = ((b.a)this.list.get(i)).fHV;
      i += 1;
    }
    AppMethodBeat.o(34795);
  }
  
  private static String xN(int paramInt)
  {
    AppMethodBeat.i(34800);
    if (aa.dsE())
    {
      String str = Integer.toString(paramInt) + "劃";
      AppMethodBeat.o(34800);
      return str;
    }
    char c = (char)paramInt;
    AppMethodBeat.o(34800);
    return String.valueOf(c);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(34796);
    int i = this.list.size();
    AppMethodBeat.o(34796);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(34797);
    Object localObject = this.list.get(paramInt);
    AppMethodBeat.o(34797);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34799);
    b.a locala = (b.a)getItem(paramInt);
    label88:
    int i;
    if (paramView == null) {
      if (!aa.dsE())
      {
        paramView = View.inflate(this.context, 2130969280, null);
        paramViewGroup = new c.a();
        paramViewGroup.nSs = ((TextView)paramView.findViewById(2131821089));
        paramViewGroup.ejj = ((TextView)paramView.findViewById(2131821099));
        paramViewGroup.nSt = ((TextView)paramView.findViewById(2131821095));
        paramView.setTag(paramViewGroup);
        if (paramInt <= 0) {
          break label201;
        }
        i = this.nSp[(paramInt - 1)];
        label102:
        if (paramInt != 0) {
          break label207;
        }
        paramViewGroup.nSs.setVisibility(0);
        paramViewGroup.nSs.setText(xN(this.nSp[paramInt]));
        label130:
        paramViewGroup.ejj.setText(locala.fHT);
        paramViewGroup.nSt.setText(locala.fHS);
        if (!this.nSq) {
          break label261;
        }
        paramViewGroup.nSt.setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(34799);
      return paramView;
      paramView = View.inflate(this.context, 2130969281, null);
      break;
      paramViewGroup = (c.a)paramView.getTag();
      break label88;
      label201:
      i = -1;
      break label102;
      label207:
      if ((paramInt > 0) && (this.nSp[paramInt] != i))
      {
        paramViewGroup.nSs.setVisibility(0);
        paramViewGroup.nSs.setText(xN(this.nSp[paramInt]));
        break label130;
      }
      paramViewGroup.nSs.setVisibility(8);
      break label130;
      label261:
      paramViewGroup.nSt.setVisibility(4);
    }
  }
  
  public final void wQ(String paramString)
  {
    AppMethodBeat.i(34798);
    if (paramString != null)
    {
      this.gvZ = paramString.trim();
      this.list.clear();
      int j = this.nSn.size();
      int i = 0;
      while (i < j)
      {
        if ((((b.a)this.nSn.get(i)).fHT.toUpperCase().contains(this.gvZ.toUpperCase())) || (((b.a)this.nSn.get(i)).fHU.toUpperCase().contains(this.gvZ.toUpperCase())) || (((b.a)this.nSn.get(i)).fHS.contains(this.gvZ))) {
          this.list.add(this.nSn.get(i));
        }
        i += 1;
      }
      bKh();
      super.notifyDataSetChanged();
    }
    AppMethodBeat.o(34798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */