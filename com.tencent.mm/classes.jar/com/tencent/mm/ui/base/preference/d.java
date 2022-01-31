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
import com.tencent.mm.ui.w;
import java.util.HashMap;
import junit.framework.Assert;

final class d
  extends BaseAdapter
{
  private final Context context;
  protected int pvJ;
  private final int style;
  protected String value;
  protected final HashMap<CharSequence, c> values;
  protected CharSequence[] zqB;
  protected CharSequence[] zqC;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(107151);
    this.pvJ = -1;
    this.values = new HashMap();
    this.context = paramContext;
    this.style = 1;
    AppMethodBeat.o(107151);
  }
  
  protected final void dEH()
  {
    int i = 0;
    AppMethodBeat.i(107152);
    if (this.zqB == null) {
      this.zqB = new CharSequence[0];
    }
    if (this.zqC == null) {
      this.zqC = new CharSequence[0];
    }
    if (this.zqB.length == this.zqC.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("entries count different", bool);
      this.values.clear();
      while (i < this.zqC.length)
      {
        c localc = new c(this.zqB[i], 1048576 + i);
        this.values.put(this.zqC[i], localc);
        i += 1;
      }
    }
    AppMethodBeat.o(107152);
  }
  
  public final int getCount()
  {
    return this.zqC.length;
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
    AppMethodBeat.i(107153);
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = w.hM(this.context).inflate(2130970227, null);
      paramView = new d.a();
      paramView.pvK = ((TextView)paramViewGroup.findViewById(2131820676));
      paramView.pvL = ((CheckBox)paramViewGroup.findViewById(2131826235));
      paramView.pvM = ((RadioButton)paramViewGroup.findViewById(2131820951));
      paramViewGroup.setTag(paramView);
    }
    paramView = (d.a)paramViewGroup.getTag();
    paramView.pvK.setText(this.zqB[paramInt]);
    switch (this.style)
    {
    default: 
      paramView.pvL.setVisibility(8);
      paramView.pvM.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(107153);
      return paramViewGroup;
      paramView.pvL.setVisibility(8);
      paramView.pvM.setVisibility(0);
      paramView.pvM.setChecked(this.zqC[paramInt].equals(this.value));
      continue;
      paramView.pvL.setVisibility(0);
      paramView.pvM.setVisibility(8);
      paramView.pvL.setChecked(this.zqC[paramInt].equals(this.value));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.d
 * JD-Core Version:    0.7.0.1
 */