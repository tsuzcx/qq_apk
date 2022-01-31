package com.tencent.mm.wear.app.ui.message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.p;
import com.tencent.mm.wear.app.b.h;
import com.tencent.mm.wear.app.c.a;
import com.tencent.mm.wear.app.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private List<p> agf;
  private Context context;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
    this.agf = new ArrayList();
  }
  
  private p bZ(int paramInt)
  {
    return (p)this.agf.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.agf.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = (c)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localObject = bZ(paramInt);
      a locala = new a();
      locala.acL = paramView.aeA;
      locala.acM = 2130837531;
      locala.width = 60;
      locala.height = 60;
      locala.type = 3;
      locala.acH = ((p)localObject).VN;
      locala.acO = 10;
      h.me().a(locala);
      paramView.agg.setText(this.context.getString(2131165215, new Object[] { String.format("%.2f", new Object[] { Float.valueOf((float)((p)localObject).VP / 100.0F) }) }));
      paramView.afL.setText(((p)localObject).Vp);
      return paramViewGroup;
    }
    if (MMActivity.isRect()) {}
    for (paramView = LayoutInflater.from(this.context).inflate(2130903059, paramViewGroup, false);; paramView = LayoutInflater.from(this.context).inflate(2130903060, paramViewGroup, false))
    {
      paramViewGroup = new c(this, (byte)0);
      paramViewGroup.aeA = ((ImageView)paramView.findViewById(2131558467));
      paramViewGroup.agg = ((TextView)paramView.findViewById(2131558469));
      paramViewGroup.afL = ((TextView)paramView.findViewById(2131558468));
      paramView.setTag(paramViewGroup);
      localObject = paramView;
      paramView = paramViewGroup;
      paramViewGroup = (ViewGroup)localObject;
      break;
    }
  }
  
  public final void l(List<p> paramList)
  {
    this.agf.addAll(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.message.b
 * JD-Core Version:    0.7.0.1
 */