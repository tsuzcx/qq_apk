package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.product.b.n.a;
import java.util.List;

public final class l
  extends BaseAdapter
{
  private Context mContext;
  List<n.a> pwN;
  
  public l(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private n.a Br(int paramInt)
  {
    AppMethodBeat.i(44134);
    n.a locala = (n.a)this.pwN.get(paramInt);
    AppMethodBeat.o(44134);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(44133);
    if (this.pwN != null)
    {
      int i = this.pwN.size();
      AppMethodBeat.o(44133);
      return i;
    }
    AppMethodBeat.o(44133);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(44135);
    Object localObject = Br(paramInt);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramViewGroup = new m();
      paramView = View.inflate(this.mContext, 2130970456, null);
      paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131826812));
      paramViewGroup.iQd = ((ImageView)paramView.findViewById(2131826811));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.pwO = ((n.a)localObject);
      paramViewGroup.titleTv.setText(((n.a)localObject).title);
      localObject = x.a(new c(((n.a)localObject).iconUrl));
      paramViewGroup.iQd.setImageBitmap((Bitmap)localObject);
      x.a(paramViewGroup);
      AppMethodBeat.o(44135);
      return paramView;
      paramViewGroup = (m)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.l
 * JD-Core Version:    0.7.0.1
 */