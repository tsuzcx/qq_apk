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
  protected CharSequence[] HDR;
  protected CharSequence[] HDS;
  private final Context context;
  private final int style;
  protected int vGl;
  protected String value;
  protected final HashMap<CharSequence, c> values;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(142528);
    this.vGl = -1;
    this.values = new HashMap();
    this.context = paramContext;
    this.style = 1;
    AppMethodBeat.o(142528);
  }
  
  protected final void fji()
  {
    int i = 0;
    AppMethodBeat.i(142529);
    if (this.HDR == null) {
      this.HDR = new CharSequence[0];
    }
    if (this.HDS == null) {
      this.HDS = new CharSequence[0];
    }
    if (this.HDR.length == this.HDS.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("entries count different", bool);
      this.values.clear();
      while (i < this.HDS.length)
      {
        c localc = new c(this.HDR[i], 1048576 + i);
        this.values.put(this.HDS[i], localc);
        i += 1;
      }
    }
    AppMethodBeat.o(142529);
  }
  
  public final int getCount()
  {
    return this.HDS.length;
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
      paramViewGroup = z.jD(this.context).inflate(2131494854, null);
      paramView = new a();
      paramView.nyS = ((TextView)paramViewGroup.findViewById(2131305710));
      paramView.vGm = ((CheckBox)paramViewGroup.findViewById(2131298214));
      paramView.vGn = ((RadioButton)paramViewGroup.findViewById(2131303704));
      paramViewGroup.setTag(paramView);
    }
    paramView = (a)paramViewGroup.getTag();
    paramView.nyS.setText(this.HDR[paramInt]);
    switch (this.style)
    {
    default: 
      paramView.vGm.setVisibility(8);
      paramView.vGn.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(142530);
      return paramViewGroup;
      paramView.vGm.setVisibility(8);
      paramView.vGn.setVisibility(0);
      paramView.vGn.setChecked(this.HDS[paramInt].equals(this.value));
      continue;
      paramView.vGm.setVisibility(0);
      paramView.vGn.setVisibility(8);
      paramView.vGm.setChecked(this.HDS[paramInt].equals(this.value));
    }
  }
  
  static final class a
  {
    TextView nyS;
    CheckBox vGm;
    RadioButton vGn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.d
 * JD-Core Version:    0.7.0.1
 */