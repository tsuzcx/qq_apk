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
import com.tencent.mm.ui.af;
import java.util.HashMap;
import junit.framework.Assert;

final class d
  extends BaseAdapter
{
  protected int MSi;
  protected CharSequence[] adXV;
  protected CharSequence[] adXW;
  private final Context context;
  private final int style;
  protected String value;
  protected final HashMap<CharSequence, c> values;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(142528);
    this.MSi = -1;
    this.values = new HashMap();
    this.context = paramContext;
    this.style = 1;
    AppMethodBeat.o(142528);
  }
  
  public final int getCount()
  {
    return this.adXW.length;
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
      paramViewGroup = af.mU(this.context).inflate(a.h.mm_preference_dialog_item, null);
      paramView = new a();
      paramView.ElR = ((TextView)paramViewGroup.findViewById(a.g.text));
      paramView.MSj = ((CheckBox)paramViewGroup.findViewById(a.g.check));
      paramView.MSk = ((RadioButton)paramViewGroup.findViewById(a.g.radio));
      paramViewGroup.setTag(paramView);
    }
    paramView = (a)paramViewGroup.getTag();
    paramView.ElR.setText(this.adXV[paramInt]);
    switch (this.style)
    {
    default: 
      paramView.MSj.setVisibility(8);
      paramView.MSk.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(142530);
      return paramViewGroup;
      paramView.MSj.setVisibility(8);
      paramView.MSk.setVisibility(0);
      paramView.MSk.setChecked(this.adXW[paramInt].equals(this.value));
      continue;
      paramView.MSj.setVisibility(0);
      paramView.MSk.setVisibility(8);
      paramView.MSj.setChecked(this.adXW[paramInt].equals(this.value));
    }
  }
  
  protected final void jni()
  {
    int i = 0;
    AppMethodBeat.i(142529);
    if (this.adXV == null) {
      this.adXV = new CharSequence[0];
    }
    if (this.adXW == null) {
      this.adXW = new CharSequence[0];
    }
    if (this.adXV.length == this.adXW.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("entries count different", bool);
      this.values.clear();
      while (i < this.adXW.length)
      {
        c localc = new c(this.adXV[i], 1048576 + i);
        this.values.put(this.adXW[i], localc);
        i += 1;
      }
    }
    AppMethodBeat.o(142529);
  }
  
  static final class a
  {
    TextView ElR;
    CheckBox MSj;
    RadioButton MSk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.d
 * JD-Core Version:    0.7.0.1
 */