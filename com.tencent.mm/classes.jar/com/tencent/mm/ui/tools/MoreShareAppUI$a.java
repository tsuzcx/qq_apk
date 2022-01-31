package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.List;

final class MoreShareAppUI$a
  extends ArrayAdapter<f>
{
  private List<f> lee;
  private Context mContext;
  
  public MoreShareAppUI$a(Context paramContext, List<f> paramList)
  {
    super(paramContext, 2130970299, paramList);
    this.mContext = paramContext;
    this.lee = paramList;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34887);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2130970299, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      f localf = (f)getItem(paramInt);
      paramViewGroup.gpL.setText(localf.field_appName);
      paramView.setVisibility(0);
      AppMethodBeat.o(34887);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  static final class a
  {
    TextView gpL;
    MMSwitchBtn iDy;
    ImageView ivs;
    View lef;
    ImageView leg;
    
    public a(View paramView)
    {
      AppMethodBeat.i(34886);
      this.leg = ((ImageView)paramView.findViewById(2131826328));
      this.ivs = ((ImageView)paramView.findViewById(2131823740));
      this.gpL = ((TextView)paramView.findViewById(2131823739));
      this.iDy = ((MMSwitchBtn)paramView.findViewById(2131826329));
      this.lef = paramView.findViewById(2131821084);
      AppMethodBeat.o(34886);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MoreShareAppUI.a
 * JD-Core Version:    0.7.0.1
 */