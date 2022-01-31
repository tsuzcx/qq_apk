package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.qqmail.b.a;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class MailAddrListUI$a
  extends BaseAdapter
{
  private final Context context;
  boolean pNo;
  boolean pNp;
  Map<String, o> pNq;
  
  public MailAddrListUI$a(MailAddrListUI paramMailAddrListUI, Context paramContext)
  {
    AppMethodBeat.i(68318);
    this.pNo = false;
    this.pNp = false;
    this.pNq = new HashMap();
    this.context = paramContext;
    AppMethodBeat.o(68318);
  }
  
  private int BZ(int paramInt)
  {
    if (this.pNp) {
      return paramInt;
    }
    if (paramInt == 0) {
      return 0;
    }
    return paramInt - 1;
  }
  
  private static String d(o paramo)
  {
    AppMethodBeat.i(68324);
    if (paramo == null)
    {
      AppMethodBeat.o(68324);
      return null;
    }
    paramo = a.Xn(paramo.pJg);
    if (paramo.length() > 1) {}
    for (char c = paramo.charAt(0);; c = '~') {
      switch (c)
      {
      case '|': 
      case '}': 
      default: 
        if (!bo.C(c)) {
          break label130;
        }
        AppMethodBeat.o(68324);
        return String.valueOf(c);
      }
    }
    c = paramo.charAt(1);
    if (bo.D(c))
    {
      AppMethodBeat.o(68324);
      return String.valueOf(c);
    }
    AppMethodBeat.o(68324);
    return "~";
    AppMethodBeat.o(68324);
    return "~";
    label130:
    AppMethodBeat.o(68324);
    return "~";
  }
  
  private TextView getTitleTextView()
  {
    AppMethodBeat.i(68322);
    TextView localTextView = new TextView(this.context);
    localTextView.setBackgroundResource(2130839285);
    localTextView.setTextColor(-16777216);
    localTextView.setTextSize(0, this.pNn.getResources().getDimensionPixelSize(2131427758));
    int i = this.pNn.getResources().getDimensionPixelSize(2131427772);
    int j = this.pNn.getResources().getDimensionPixelSize(2131427854);
    localTextView.setPadding(j, i, j, j);
    AppMethodBeat.o(68322);
    return localTextView;
  }
  
  public final o Ca(int paramInt)
  {
    AppMethodBeat.i(68325);
    paramInt = BZ(paramInt);
    o localo = (o)MailAddrListUI.c(this.pNn).get(paramInt);
    AppMethodBeat.o(68325);
    return localo;
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final void c(o paramo)
  {
    AppMethodBeat.i(68319);
    this.pNq.put(paramo.nZR, paramo);
    AppMethodBeat.o(68319);
  }
  
  public final int ces()
  {
    AppMethodBeat.i(68320);
    int i = this.pNq.size();
    AppMethodBeat.o(68320);
    return i;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(68321);
    int i = MailAddrListUI.c(this.pNn).size();
    if (i == 0)
    {
      if (this.pNo)
      {
        AppMethodBeat.o(68321);
        return 1;
      }
      AppMethodBeat.o(68321);
      return 0;
    }
    if (this.pNp)
    {
      AppMethodBeat.o(68321);
      return i;
    }
    AppMethodBeat.o(68321);
    return i + 1;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(68323);
    if (paramInt == 0)
    {
      if (this.pNo)
      {
        paramView = getTitleTextView();
        paramView.setText(2131302118);
        paramInt = this.pNn.getResources().getDimensionPixelSize(2131427772);
        paramView.setPadding(paramInt, paramInt, paramInt, paramInt);
        paramView.setTextSize(0, this.pNn.getResources().getDimensionPixelSize(2131427501));
        paramView.setGravity(17);
        AppMethodBeat.o(68323);
        return paramView;
      }
      if (!this.pNp)
      {
        paramView = getTitleTextView();
        paramView.setText(2131302117);
        AppMethodBeat.o(68323);
        return paramView;
      }
    }
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramViewGroup = new a();
      paramView = View.inflate(this.context, 2130970482, null);
      paramViewGroup.pNr = ((TextView)paramView.findViewById(2131826883));
      paramViewGroup.gzk = ((TextView)paramView.findViewById(2131826885));
      paramViewGroup.pNs = ((TextView)paramView.findViewById(2131826886));
      paramViewGroup.gpN = ((CheckBox)paramView.findViewById(2131826887));
      paramView.setTag(paramViewGroup);
      o localo = Ca(paramInt);
      if ((this.pNp) || (paramInt <= 10)) {
        break label376;
      }
      Object localObject = Ca(paramInt - 1);
      if (paramInt == 11) {
        localObject = null;
      }
      String str = d(localo);
      localObject = d((o)localObject);
      if (str == null) {
        break label364;
      }
      if (str.equals(localObject)) {
        break label352;
      }
      paramViewGroup.pNr.setText(str.toUpperCase());
      paramViewGroup.pNr.setVisibility(0);
      label279:
      paramViewGroup.gzk.setText(localo.name);
      paramViewGroup.pNs.setText(localo.nZR);
      paramViewGroup = paramViewGroup.gpN;
      if (this.pNq.get(localo.nZR) == null) {
        break label388;
      }
    }
    label388:
    for (boolean bool = true;; bool = false)
    {
      paramViewGroup.setChecked(bool);
      AppMethodBeat.o(68323);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label352:
      paramViewGroup.pNr.setVisibility(8);
      break label279;
      label364:
      paramViewGroup.pNr.setVisibility(8);
      break label279;
      label376:
      paramViewGroup.pNr.setVisibility(8);
      break label279;
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    if (paramInt == 0) {
      return this.pNp;
    }
    return true;
  }
  
  final class a
  {
    CheckBox gpN;
    TextView gzk;
    TextView pNr;
    TextView pNs;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.a
 * JD-Core Version:    0.7.0.1
 */