package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.plugin.scanner.a.a.a;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;
import java.util.Map;

public final class h
  extends Preference
{
  private Context mContext = null;
  List<a.a> mTm = null;
  private View mView = null;
  
  public h(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    setLayoutResource(R.i.product_grid_preference);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    return this.mView;
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    Object localObject = (GridView)this.mView.findViewById(R.h.main_grid);
    paramView = new h.b(this);
    ((GridView)localObject).setAdapter(paramView);
    if (this.mTm != null)
    {
      localObject = this.mTm;
      paramView.nJT.clear();
      paramView.nJX.clear();
      paramView.nJX = ((List)localObject);
      paramView.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.h
 * JD-Core Version:    0.7.0.1
 */