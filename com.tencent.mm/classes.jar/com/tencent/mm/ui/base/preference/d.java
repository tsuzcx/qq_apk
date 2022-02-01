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
  protected CharSequence[] JMw;
  protected CharSequence[] JMx;
  private final Context context;
  private final int style;
  protected String value;
  protected final HashMap<CharSequence, c> values;
  protected int xdf;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(142528);
    this.xdf = -1;
    this.values = new HashMap();
    this.context = paramContext;
    this.style = 1;
    AppMethodBeat.o(142528);
  }
  
  protected final void fDz()
  {
    int i = 0;
    AppMethodBeat.i(142529);
    if (this.JMw == null) {
      this.JMw = new CharSequence[0];
    }
    if (this.JMx == null) {
      this.JMx = new CharSequence[0];
    }
    if (this.JMw.length == this.JMx.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("entries count different", bool);
      this.values.clear();
      while (i < this.JMx.length)
      {
        c localc = new c(this.JMw[i], 1048576 + i);
        this.values.put(this.JMx[i], localc);
        i += 1;
      }
    }
    AppMethodBeat.o(142529);
  }
  
  public final int getCount()
  {
    return this.JMx.length;
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
      paramViewGroup = z.jV(this.context).inflate(2131494854, null);
      paramView = new a();
      paramView.xdg = ((TextView)paramViewGroup.findViewById(2131305710));
      paramView.xdh = ((CheckBox)paramViewGroup.findViewById(2131298214));
      paramView.xdi = ((RadioButton)paramViewGroup.findViewById(2131303704));
      paramViewGroup.setTag(paramView);
    }
    paramView = (a)paramViewGroup.getTag();
    paramView.xdg.setText(this.JMw[paramInt]);
    switch (this.style)
    {
    default: 
      paramView.xdh.setVisibility(8);
      paramView.xdi.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(142530);
      return paramViewGroup;
      paramView.xdh.setVisibility(8);
      paramView.xdi.setVisibility(0);
      paramView.xdi.setChecked(this.JMx[paramInt].equals(this.value));
      continue;
      paramView.xdh.setVisibility(0);
      paramView.xdi.setVisibility(8);
      paramView.xdh.setChecked(this.JMx[paramInt].equals(this.value));
    }
  }
  
  static final class a
  {
    TextView xdg;
    CheckBox xdh;
    RadioButton xdi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.d
 * JD-Core Version:    0.7.0.1
 */