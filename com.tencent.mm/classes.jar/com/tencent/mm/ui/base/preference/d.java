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
import com.tencent.mm.ui.y;
import java.util.HashMap;
import junit.framework.Assert;

final class d
  extends BaseAdapter
{
  protected CharSequence[] Gec;
  protected CharSequence[] Ged;
  private final Context context;
  private final int style;
  protected int uxs;
  protected String value;
  protected final HashMap<CharSequence, c> values;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(142528);
    this.uxs = -1;
    this.values = new HashMap();
    this.context = paramContext;
    this.style = 1;
    AppMethodBeat.o(142528);
  }
  
  protected final void eTw()
  {
    int i = 0;
    AppMethodBeat.i(142529);
    if (this.Gec == null) {
      this.Gec = new CharSequence[0];
    }
    if (this.Ged == null) {
      this.Ged = new CharSequence[0];
    }
    if (this.Gec.length == this.Ged.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("entries count different", bool);
      this.values.clear();
      while (i < this.Ged.length)
      {
        c localc = new c(this.Gec[i], 1048576 + i);
        this.values.put(this.Ged[i], localc);
        i += 1;
      }
    }
    AppMethodBeat.o(142529);
  }
  
  public final int getCount()
  {
    return this.Ged.length;
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
      paramViewGroup = y.js(this.context).inflate(2131494854, null);
      paramView = new a();
      paramView.mWt = ((TextView)paramViewGroup.findViewById(2131305710));
      paramView.uxt = ((CheckBox)paramViewGroup.findViewById(2131298214));
      paramView.uxu = ((RadioButton)paramViewGroup.findViewById(2131303704));
      paramViewGroup.setTag(paramView);
    }
    paramView = (a)paramViewGroup.getTag();
    paramView.mWt.setText(this.Gec[paramInt]);
    switch (this.style)
    {
    default: 
      paramView.uxt.setVisibility(8);
      paramView.uxu.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(142530);
      return paramViewGroup;
      paramView.uxt.setVisibility(8);
      paramView.uxu.setVisibility(0);
      paramView.uxu.setChecked(this.Ged[paramInt].equals(this.value));
      continue;
      paramView.uxt.setVisibility(0);
      paramView.uxu.setVisibility(8);
      paramView.uxt.setChecked(this.Ged[paramInt].equals(this.value));
    }
  }
  
  static final class a
  {
    TextView mWt;
    CheckBox uxt;
    RadioButton uxu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.d
 * JD-Core Version:    0.7.0.1
 */