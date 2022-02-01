package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.z;
import java.util.HashMap;
import junit.framework.Assert;

final class d
  extends BaseAdapter
{
  protected CharSequence[] JrH;
  protected CharSequence[] JrI;
  private final Context context;
  private final int style;
  protected String value;
  protected final HashMap<CharSequence, c> values;
  protected int wNr;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(142528);
    this.wNr = -1;
    this.values = new HashMap();
    this.context = paramContext;
    this.style = 1;
    AppMethodBeat.o(142528);
  }
  
  protected final void fzx()
  {
    int i = 0;
    AppMethodBeat.i(142529);
    if (this.JrH == null) {
      this.JrH = new CharSequence[0];
    }
    if (this.JrI == null) {
      this.JrI = new CharSequence[0];
    }
    if (this.JrH.length == this.JrI.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("entries count different", bool);
      this.values.clear();
      while (i < this.JrI.length)
      {
        c localc = new c(this.JrH[i], 1048576 + i);
        this.values.put(this.JrI[i], localc);
        i += 1;
      }
    }
    AppMethodBeat.o(142529);
  }
  
  public final int getCount()
  {
    return this.JrI.length;
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
    AppMethodBeat.i(142530);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = z.jO(this.context).inflate(2131494854, null);
      paramView = new a();
      paramView.wNs = ((TextView)paramViewGroup.findViewById(2131305710));
      paramView.wNt = ((CheckBox)paramViewGroup.findViewById(2131298214));
      paramView.wNu = ((RadioButton)paramViewGroup.findViewById(2131303704));
      paramViewGroup.setTag(paramView);
    }
    paramView = (a)paramViewGroup.getTag();
    paramView.wNs.setText(this.JrH[paramInt]);
    switch (this.style)
    {
    default: 
      paramView.wNt.setVisibility(8);
      paramView.wNu.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(142530);
      return paramViewGroup;
      paramView.wNt.setVisibility(8);
      paramView.wNu.setVisibility(0);
      paramView.wNu.setChecked(this.JrI[paramInt].equals(this.value));
      continue;
      paramView.wNt.setVisibility(0);
      paramView.wNu.setVisibility(8);
      paramView.wNt.setChecked(this.JrI[paramInt].equals(this.value));
    }
  }
  
  static final class a
  {
    TextView wNs;
    CheckBox wNt;
    RadioButton wNu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.d
 * JD-Core Version:    0.7.0.1
 */