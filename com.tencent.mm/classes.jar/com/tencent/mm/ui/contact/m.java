package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.as;
import java.util.List;

public final class m
  extends BaseAdapter
{
  private List<String> PVI;
  private boolean PVJ;
  private Context context;
  private List<as> gxh;
  
  public m(Context paramContext, List<as> paramList, List<String> paramList1, boolean paramBoolean)
  {
    this.gxh = paramList;
    this.context = paramContext;
    this.PVJ = paramBoolean;
    this.PVI = paramList1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37849);
    int i = this.gxh.size();
    AppMethodBeat.o(37849);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(37850);
    Object localObject = this.gxh.get(paramInt);
    AppMethodBeat.o(37850);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(37848);
    as localas = (as)this.gxh.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new GroupCardSelectUI.a();
      paramView = View.inflate(this.context, 2131494995, null);
      paramViewGroup.yDA = ((TextView)paramView.findViewById(2131302179));
      paramViewGroup.PVW = ((TextView)paramView.findViewById(2131302180));
      paramViewGroup.keC = ((ImageView)paramView.findViewById(2131302178));
      paramViewGroup.BaJ = ((CheckBox)paramView.findViewById(2131307508));
      paramView.setTag(paramViewGroup);
      a.b.c(paramViewGroup.keC, localas.field_username);
      paramViewGroup.PVW.setText(l.e(this.context, aa.getDisplayName(localas.field_username), a.aG(this.context, 2131165535)));
      paramViewGroup.yDA.setText("(" + v.Ie(localas.field_username) + ")");
      if (!ab.Iz(localas.field_username)) {
        break label290;
      }
      Drawable localDrawable = this.context.getResources().getDrawable(2131691298);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramViewGroup.PVW.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      label232:
      if (this.PVJ)
      {
        paramViewGroup.BaJ.setVisibility(0);
        if (!this.PVI.contains(localas.field_username)) {
          break label304;
        }
        paramViewGroup.BaJ.setChecked(true);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37848);
      return paramView;
      paramViewGroup = (GroupCardSelectUI.a)paramView.getTag();
      break;
      label290:
      paramViewGroup.PVW.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label232;
      label304:
      paramViewGroup.BaJ.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.m
 * JD-Core Version:    0.7.0.1
 */