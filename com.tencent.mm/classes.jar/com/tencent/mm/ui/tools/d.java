package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.az.b.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends BaseAdapter
{
  int[] DUT;
  boolean DUU;
  private Context context;
  private List<b.a> iZZ;
  private List<b.a> list;
  private String mUI;
  
  public d(Context paramContext, List<b.a> paramList)
  {
    AppMethodBeat.i(38986);
    this.iZZ = new ArrayList();
    this.DUU = false;
    this.context = paramContext;
    this.list = paramList;
    eKi();
    eKj();
    AppMethodBeat.o(38986);
  }
  
  private static String Vq(int paramInt)
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
  
  private void eKi()
  {
    AppMethodBeat.i(38987);
    int i = 0;
    int j = this.list.size();
    while (i < j)
    {
      this.iZZ.add(this.list.get(i));
      i += 1;
    }
    AppMethodBeat.o(38987);
  }
  
  private void eKj()
  {
    AppMethodBeat.i(38988);
    this.DUT = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.DUT[i] = ((b.a)this.list.get(i)).lSB;
      i += 1;
    }
    AppMethodBeat.o(38988);
  }
  
  public final void aas(String paramString)
  {
    AppMethodBeat.i(38991);
    if (paramString != null)
    {
      this.mUI = paramString.trim();
      this.list.clear();
      int j = this.iZZ.size();
      int i = 0;
      while (i < j)
      {
        if ((((b.a)this.iZZ.get(i)).lSz.toUpperCase().contains(this.mUI.toUpperCase())) || (((b.a)this.iZZ.get(i)).lSA.toUpperCase().contains(this.mUI.toUpperCase())) || (((b.a)this.iZZ.get(i)).lSy.contains(this.mUI))) {
          this.list.add(this.iZZ.get(i));
        }
        i += 1;
      }
      eKj();
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
        paramView = View.inflate(this.context, R.i.efJ, null);
        paramViewGroup = new a();
        paramViewGroup.DUW = ((TextView)paramView.findViewById(R.h.dCx));
        paramViewGroup.jbe = ((TextView)paramView.findViewById(R.h.dCB));
        paramViewGroup.DUX = ((TextView)paramView.findViewById(R.h.dCE));
        paramView.setTag(paramViewGroup);
        if (paramInt <= 0) {
          break label206;
        }
        i = this.DUT[(paramInt - 1)];
        label106:
        if (paramInt != 0) {
          break label212;
        }
        paramViewGroup.DUW.setVisibility(0);
        paramViewGroup.DUW.setText(Vq(this.DUT[paramInt]));
        label134:
        paramViewGroup.jbe.setText(locala.lSz);
        paramViewGroup.DUX.setText(locala.lSy);
        if (!this.DUU) {
          break label266;
        }
        paramViewGroup.DUX.setVisibility(0);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(38992);
      return paramView;
      paramView = View.inflate(this.context, R.i.efK, null);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label92;
      label206:
      i = -1;
      break label106;
      label212:
      if ((paramInt > 0) && (this.DUT[paramInt] != i))
      {
        paramViewGroup.DUW.setVisibility(0);
        paramViewGroup.DUW.setText(Vq(this.DUT[paramInt]));
        break label134;
      }
      paramViewGroup.DUW.setVisibility(8);
      break label134;
      label266:
      paramViewGroup.DUX.setVisibility(4);
    }
  }
  
  static final class a
  {
    TextView DUW;
    TextView DUX;
    TextView jbe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.d
 * JD-Core Version:    0.7.0.1
 */