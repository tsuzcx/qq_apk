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
import com.tencent.mm.cd.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.af;
import java.util.List;

public final class m
  extends BaseAdapter
{
  private List<String> GVw;
  private boolean GVx;
  private Context context;
  private List<af> fsY;
  
  public m(Context paramContext, List<af> paramList, List<String> paramList1, boolean paramBoolean)
  {
    this.fsY = paramList;
    this.context = paramContext;
    this.GVx = paramBoolean;
    this.GVw = paramList1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37849);
    int i = this.fsY.size();
    AppMethodBeat.o(37849);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(37850);
    Object localObject = this.fsY.get(paramInt);
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
    af localaf = (af)this.fsY.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new GroupCardSelectUI.a();
      paramView = View.inflate(this.context, 2131494422, null);
      paramViewGroup.sNC = ((TextView)paramView.findViewById(2131300624));
      paramViewGroup.GVI = ((TextView)paramView.findViewById(2131300625));
      paramViewGroup.ikp = ((ImageView)paramView.findViewById(2131300623));
      paramViewGroup.uxt = ((CheckBox)paramView.findViewById(2131304502));
      paramView.setTag(paramViewGroup);
      a.b.c(paramViewGroup.ikp, localaf.field_username);
      paramViewGroup.GVI.setText(k.b(this.context, v.sh(localaf.field_username), a.ao(this.context, 2131165517)));
      paramViewGroup.sNC.setText("(" + q.rY(localaf.field_username) + ")");
      if (!w.so(localaf.field_username)) {
        break label290;
      }
      Drawable localDrawable = this.context.getResources().getDrawable(2131691000);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramViewGroup.GVI.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      label232:
      if (this.GVx)
      {
        paramViewGroup.uxt.setVisibility(0);
        if (!this.GVw.contains(localaf.field_username)) {
          break label304;
        }
        paramViewGroup.uxt.setChecked(true);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37848);
      return paramView;
      paramViewGroup = (GroupCardSelectUI.a)paramView.getTag();
      break;
      label290:
      paramViewGroup.GVI.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label232;
      label304:
      paramViewGroup.uxt.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.m
 * JD-Core Version:    0.7.0.1
 */