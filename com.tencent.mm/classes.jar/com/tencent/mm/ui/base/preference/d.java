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
import com.tencent.mm.ui.aa;
import java.util.HashMap;
import junit.framework.Assert;

final class d
  extends BaseAdapter
{
  protected int BaH;
  protected CharSequence[] OXw;
  protected CharSequence[] OXx;
  private final Context context;
  private final int style;
  protected String value;
  protected final HashMap<CharSequence, c> values;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(142528);
    this.BaH = -1;
    this.values = new HashMap();
    this.context = paramContext;
    this.style = 1;
    AppMethodBeat.o(142528);
  }
  
  protected final void gLC()
  {
    int i = 0;
    AppMethodBeat.i(142529);
    if (this.OXw == null) {
      this.OXw = new CharSequence[0];
    }
    if (this.OXx == null) {
      this.OXx = new CharSequence[0];
    }
    if (this.OXw.length == this.OXx.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("entries count different", bool);
      this.values.clear();
      while (i < this.OXx.length)
      {
        c localc = new c(this.OXw[i], 1048576 + i);
        this.values.put(this.OXx[i], localc);
        i += 1;
      }
    }
    AppMethodBeat.o(142529);
  }
  
  public final int getCount()
  {
    return this.OXx.length;
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
      paramViewGroup = aa.jQ(this.context).inflate(2131495589, null);
      paramView = new a();
      paramView.BaI = ((TextView)paramViewGroup.findViewById(2131308977));
      paramView.BaJ = ((CheckBox)paramViewGroup.findViewById(2131298596));
      paramView.BaK = ((RadioButton)paramViewGroup.findViewById(2131306483));
      paramViewGroup.setTag(paramView);
    }
    paramView = (a)paramViewGroup.getTag();
    paramView.BaI.setText(this.OXw[paramInt]);
    switch (this.style)
    {
    default: 
      paramView.BaJ.setVisibility(8);
      paramView.BaK.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(142530);
      return paramViewGroup;
      paramView.BaJ.setVisibility(8);
      paramView.BaK.setVisibility(0);
      paramView.BaK.setChecked(this.OXx[paramInt].equals(this.value));
      continue;
      paramView.BaJ.setVisibility(0);
      paramView.BaK.setVisibility(8);
      paramView.BaJ.setChecked(this.OXx[paramInt].equals(this.value));
    }
  }
  
  static final class a
  {
    TextView BaI;
    CheckBox BaJ;
    RadioButton BaK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.d
 * JD-Core Version:    0.7.0.1
 */