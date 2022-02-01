package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import junit.framework.Assert;

final class ProfileMobilePhoneView$a
  extends BaseAdapter
{
  private List<String> cbP;
  private Context mContext;
  
  public ProfileMobilePhoneView$a(Context paramContext, List<String> paramList)
  {
    AppMethodBeat.i(31236);
    this.cbP = null;
    this.mContext = null;
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.mContext = paramContext;
      this.cbP = paramList;
      AppMethodBeat.o(31236);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(31237);
    if (this.cbP == null)
    {
      AppMethodBeat.o(31237);
      return 0;
    }
    int i = this.cbP.size();
    AppMethodBeat.o(31237);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(31238);
    Object localObject = this.cbP.get(paramInt);
    AppMethodBeat.o(31238);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(31239);
    String str = (String)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131493472, paramViewGroup, false);
      paramView = new a((byte)0);
      ((a)paramView).fQp = ((TextView)localView.findViewById(2131305902));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      ((a)paramViewGroup).fQp.setText(str);
      AppMethodBeat.o(31239);
      return localView;
      paramViewGroup = paramView.getTag();
      localView = paramView;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  final class a
  {
    TextView fQp;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView.a
 * JD-Core Version:    0.7.0.1
 */