package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.au.b.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends BaseAdapter
{
  int[] JMc;
  boolean JMd;
  private Context context;
  private List<b.a> dTG;
  private List<b.a> list;
  private String pRp;
  
  public d(Context paramContext, List<b.a> paramList)
  {
    AppMethodBeat.i(38986);
    this.dTG = new ArrayList();
    this.JMd = false;
    this.context = paramContext;
    this.list = paramList;
    fSi();
    fSj();
    AppMethodBeat.o(38986);
  }
  
  private static String Zl(int paramInt)
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
  
  private void fSi()
  {
    AppMethodBeat.i(38987);
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.dTG.add((b.a)this.list.get(i));
      i += 1;
    }
    AppMethodBeat.o(38987);
  }
  
  private void fSj()
  {
    AppMethodBeat.i(38988);
    this.JMc = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.JMc[i] = ((b.a)this.list.get(i)).oLn;
      i += 1;
    }
    AppMethodBeat.o(38988);
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(38991);
    if (paramString != null)
    {
      this.pRp = paramString.trim();
      this.list.clear();
      int j = this.dTG.size();
      int i = 0;
      while (i < j)
      {
        if ((((b.a)this.dTG.get(i)).oLl.toUpperCase().contains(this.pRp.toUpperCase())) || (((b.a)this.dTG.get(i)).oLm.toUpperCase().contains(this.pRp.toUpperCase())) || (((b.a)this.dTG.get(i)).oLk.contains(this.pRp))) {
          this.list.add((b.a)this.dTG.get(i));
        }
        i += 1;
      }
      fSj();
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
    label92:
    int i;
    if (paramView == null) {
      if (!LocaleUtil.isTraditionalChineseAppLang())
      {
        paramView = View.inflate(this.context, R.i.giI, null);
        paramViewGroup = new a();
        paramViewGroup.JMf = ((TextView)paramView.findViewById(R.h.contactitem_catalog));
        paramViewGroup.lDe = ((TextView)paramView.findViewById(R.h.fDq));
        paramViewGroup.JMg = ((TextView)paramView.findViewById(R.h.fDt));
        paramView.setTag(paramViewGroup);
        if (paramInt <= 0) {
          break label206;
        }
        i = this.JMc[(paramInt - 1)];
        label106:
        if (paramInt != 0) {
          break label212;
        }
        paramViewGroup.JMf.setVisibility(0);
        paramViewGroup.JMf.setText(Zl(this.JMc[paramInt]));
        label134:
        paramViewGroup.lDe.setText(locala.oLl);
        paramViewGroup.JMg.setText(locala.oLk);
        if (!this.JMd) {
          break label266;
        }
        paramViewGroup.JMg.setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(38992);
      return paramView;
      paramView = View.inflate(this.context, R.i.giJ, null);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label92;
      label206:
      i = -1;
      break label106;
      label212:
      if ((paramInt > 0) && (this.JMc[paramInt] != i))
      {
        paramViewGroup.JMf.setVisibility(0);
        paramViewGroup.JMf.setText(Zl(this.JMc[paramInt]));
        break label134;
      }
      paramViewGroup.JMf.setVisibility(8);
      break label134;
      label266:
      paramViewGroup.JMg.setVisibility(4);
    }
  }
  
  static final class a
  {
    TextView JMf;
    TextView JMg;
    TextView lDe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.d
 * JD-Core Version:    0.7.0.1
 */