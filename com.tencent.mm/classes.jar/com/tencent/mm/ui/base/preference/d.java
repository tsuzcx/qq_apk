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
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ui.ad;
import java.util.HashMap;
import junit.framework.Assert;

final class d
  extends BaseAdapter
{
  protected int GUG;
  protected CharSequence[] WqG;
  protected CharSequence[] WqH;
  private final Context context;
  private final int style;
  protected String value;
  protected final HashMap<CharSequence, c> values;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(142528);
    this.GUG = -1;
    this.values = new HashMap();
    this.context = paramContext;
    this.style = 1;
    AppMethodBeat.o(142528);
  }
  
  public final int getCount()
  {
    return this.WqH.length;
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
      paramViewGroup = ad.kS(this.context).inflate(a.h.mm_preference_dialog_item, null);
      paramView = new a();
      paramView.zlv = ((TextView)paramViewGroup.findViewById(a.g.text));
      paramView.GUH = ((CheckBox)paramViewGroup.findViewById(a.g.check));
      paramView.GUI = ((RadioButton)paramViewGroup.findViewById(a.g.radio));
      paramViewGroup.setTag(paramView);
    }
    paramView = (a)paramViewGroup.getTag();
    paramView.zlv.setText(this.WqG[paramInt]);
    switch (this.style)
    {
    default: 
      paramView.GUH.setVisibility(8);
      paramView.GUI.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(142530);
      return paramViewGroup;
      paramView.GUH.setVisibility(8);
      paramView.GUI.setVisibility(0);
      paramView.GUI.setChecked(this.WqH[paramInt].equals(this.value));
      continue;
      paramView.GUH.setVisibility(0);
      paramView.GUI.setVisibility(8);
      paramView.GUH.setChecked(this.WqH[paramInt].equals(this.value));
    }
  }
  
  protected final void hKE()
  {
    int i = 0;
    AppMethodBeat.i(142529);
    if (this.WqG == null) {
      this.WqG = new CharSequence[0];
    }
    if (this.WqH == null) {
      this.WqH = new CharSequence[0];
    }
    if (this.WqG.length == this.WqH.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("entries count different", bool);
      this.values.clear();
      while (i < this.WqH.length)
      {
        c localc = new c(this.WqG[i], 1048576 + i);
        this.values.put(this.WqH[i], localc);
        i += 1;
      }
    }
    AppMethodBeat.o(142529);
  }
  
  static final class a
  {
    CheckBox GUH;
    RadioButton GUI;
    TextView zlv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.d
 * JD-Core Version:    0.7.0.1
 */