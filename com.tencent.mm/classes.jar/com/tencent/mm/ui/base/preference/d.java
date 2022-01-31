package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ui.y;
import java.util.HashMap;
import junit.framework.Assert;

final class d
  extends BaseAdapter
{
  private final Context context;
  protected int mTD = -1;
  private final int style;
  protected String value;
  protected final HashMap<CharSequence, c> values = new HashMap();
  protected CharSequence[] vca;
  protected CharSequence[] vcb;
  
  public d(Context paramContext)
  {
    this.context = paramContext;
    this.style = 1;
  }
  
  protected final void cBs()
  {
    int i = 0;
    if (this.vca == null) {
      this.vca = new CharSequence[0];
    }
    if (this.vcb == null) {
      this.vcb = new CharSequence[0];
    }
    if (this.vca.length == this.vcb.length) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("entries count different", bool);
      this.values.clear();
      while (i < this.vcb.length)
      {
        c localc = new c(this.vca[i], 1048576 + i);
        this.values.put(this.vcb[i], localc);
        i += 1;
      }
    }
  }
  
  public final int getCount()
  {
    return this.vcb.length;
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
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = y.gt(this.context).inflate(a.h.mm_preference_dialog_item, null);
      paramView = new a();
      paramView.mTE = ((TextView)paramViewGroup.findViewById(a.g.text));
      paramView.mTF = ((CheckBox)paramViewGroup.findViewById(a.g.check));
      paramView.mTG = ((RadioButton)paramViewGroup.findViewById(a.g.radio));
      paramViewGroup.setTag(paramView);
    }
    paramView = (a)paramViewGroup.getTag();
    paramView.mTE.setText(this.vca[paramInt]);
    switch (this.style)
    {
    default: 
      paramView.mTF.setVisibility(8);
      paramView.mTG.setVisibility(8);
      return paramViewGroup;
    case 1: 
      paramView.mTF.setVisibility(8);
      paramView.mTG.setVisibility(0);
      paramView.mTG.setChecked(this.vcb[paramInt].equals(this.value));
      return paramViewGroup;
    }
    paramView.mTF.setVisibility(0);
    paramView.mTG.setVisibility(8);
    paramView.mTF.setChecked(this.vcb[paramInt].equals(this.value));
    return paramViewGroup;
  }
  
  static final class a
  {
    TextView mTE;
    CheckBox mTF;
    RadioButton mTG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.d
 * JD-Core Version:    0.7.0.1
 */