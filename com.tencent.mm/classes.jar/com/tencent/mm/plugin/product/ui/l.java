package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.product.b.n.a;
import java.util.List;

public final class l
  extends BaseAdapter
{
  private Context mContext;
  List<n.a> vHo;
  
  public l(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private n.a Lc(int paramInt)
  {
    AppMethodBeat.i(67041);
    n.a locala = (n.a)this.vHo.get(paramInt);
    AppMethodBeat.o(67041);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(67040);
    if (this.vHo != null)
    {
      int i = this.vHo.size();
      AppMethodBeat.o(67040);
      return i;
    }
    AppMethodBeat.o(67040);
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(67042);
    Object localObject = Lc(paramInt);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramViewGroup = new m();
      paramView = View.inflate(this.mContext, 2131495129, null);
      paramViewGroup.titleTv = ((TextView)paramView.findViewById(2131302110));
      paramViewGroup.fBA = ((ImageView)paramView.findViewById(2131302109));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.vHp = ((n.a)localObject);
      paramViewGroup.titleTv.setText(((n.a)localObject).title);
      localObject = u.a(new c(((n.a)localObject).iconUrl));
      paramViewGroup.fBA.setImageBitmap((Bitmap)localObject);
      u.a(paramViewGroup);
      AppMethodBeat.o(67042);
      return paramView;
      paramViewGroup = (m)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.l
 * JD-Core Version:    0.7.0.1
 */