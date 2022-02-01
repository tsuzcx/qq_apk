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
import com.tencent.mm.cc.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.q;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.am;
import java.util.List;

public final class m
  extends BaseAdapter
{
  private List<String> Kmq;
  private boolean Kmr;
  private Context context;
  private List<am> fPS;
  
  public m(Context paramContext, List<am> paramList, List<String> paramList1, boolean paramBoolean)
  {
    this.fPS = paramList;
    this.context = paramContext;
    this.Kmr = paramBoolean;
    this.Kmq = paramList1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37849);
    int i = this.fPS.size();
    AppMethodBeat.o(37849);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(37850);
    Object localObject = this.fPS.get(paramInt);
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
    am localam = (am)this.fPS.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new GroupCardSelectUI.a();
      paramView = View.inflate(this.context, 2131494422, null);
      paramViewGroup.uXJ = ((TextView)paramView.findViewById(2131300624));
      paramViewGroup.KmE = ((TextView)paramView.findViewById(2131300625));
      paramViewGroup.jdF = ((ImageView)paramView.findViewById(2131300623));
      paramViewGroup.wNt = ((CheckBox)paramView.findViewById(2131304502));
      paramView.setTag(paramViewGroup);
      a.b.c(paramViewGroup.jdF, localam.field_username);
      paramViewGroup.KmE.setText(k.b(this.context, v.zf(localam.field_username), a.ax(this.context, 2131165517)));
      paramViewGroup.uXJ.setText("(" + q.yS(localam.field_username) + ")");
      if (!w.zm(localam.field_username)) {
        break label290;
      }
      Drawable localDrawable = this.context.getResources().getDrawable(2131691000);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramViewGroup.KmE.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      label232:
      if (this.Kmr)
      {
        paramViewGroup.wNt.setVisibility(0);
        if (!this.Kmq.contains(localam.field_username)) {
          break label304;
        }
        paramViewGroup.wNt.setChecked(true);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37848);
      return paramView;
      paramViewGroup = (GroupCardSelectUI.a)paramView.getTag();
      break;
      label290:
      paramViewGroup.KmE.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label232;
      label304:
      paramViewGroup.wNt.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.m
 * JD-Core Version:    0.7.0.1
 */