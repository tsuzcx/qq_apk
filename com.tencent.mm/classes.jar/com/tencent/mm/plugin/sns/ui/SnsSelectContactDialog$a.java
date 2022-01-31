package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ab;
import java.util.List;

final class SnsSelectContactDialog$a
  extends BaseAdapter
{
  private Context context;
  private List<String> items;
  private int rEf;
  private int type;
  
  public SnsSelectContactDialog$a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(39189);
    this.rEf = 0;
    Object localObject;
    this.items = localObject;
    this.context = paramInt;
    this.type = 0;
    refresh();
    AppMethodBeat.o(39189);
  }
  
  public final int getCount()
  {
    return this.rEf;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(39191);
    Object localObject = this.items.get(paramInt);
    AppMethodBeat.o(39191);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39192);
    if (paramView == null)
    {
      paramViewGroup = new SnsSelectContactDialog.b();
      if (this.type == 0)
      {
        paramView = View.inflate(this.context, 2130970890, null);
        paramViewGroup.image = ((ImageView)paramView.findViewById(2131820629));
        paramViewGroup.rUs = ((ImageView)paramView.findViewById(2131827903));
        paramView.setTag(paramViewGroup);
        label66:
        paramView.setVisibility(0);
        if (paramInt != this.rEf - 1) {
          break label170;
        }
        paramViewGroup.image.setBackgroundDrawable(null);
        paramViewGroup.image.setImageResource(2130840378);
        paramViewGroup.rUs.setVisibility(8);
        if (this.items.size() >= ab.yxn) {
          paramView.setVisibility(8);
        }
      }
    }
    for (;;)
    {
      paramViewGroup.image.setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(39192);
      return paramView;
      paramView = View.inflate(this.context, 2130970806, null);
      break;
      paramViewGroup = (SnsSelectContactDialog.b)paramView.getTag();
      break label66;
      label170:
      paramViewGroup.image.setBackgroundDrawable(null);
      paramViewGroup.rUs.setVisibility(0);
      Object localObject;
      if (this.type == 0)
      {
        localObject = (String)this.items.get(paramInt);
        a.b.c(paramViewGroup.image, (String)localObject);
      }
      else
      {
        localObject = d.d((String)this.items.get(paramInt), ag.cpn(), ag.cpn(), true);
        paramViewGroup.image.setImageBitmap((Bitmap)localObject);
      }
    }
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(39190);
    if (this.items == null) {}
    for (this.rEf = 0;; this.rEf = this.items.size())
    {
      this.rEf += 1;
      notifyDataSetChanged();
      AppMethodBeat.o(39190);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSelectContactDialog.a
 * JD-Core Version:    0.7.0.1
 */