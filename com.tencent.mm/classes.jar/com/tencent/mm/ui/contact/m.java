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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.an;
import java.util.List;

public final class m
  extends BaseAdapter
{
  private List<String> KIK;
  private boolean KIL;
  private Context context;
  private List<an> fRY;
  
  public m(Context paramContext, List<an> paramList, List<String> paramList1, boolean paramBoolean)
  {
    this.fRY = paramList;
    this.context = paramContext;
    this.KIL = paramBoolean;
    this.KIK = paramList1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37849);
    int i = this.fRY.size();
    AppMethodBeat.o(37849);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(37850);
    Object localObject = this.fRY.get(paramInt);
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
    an localan = (an)this.fRY.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new GroupCardSelectUI.a();
      paramView = View.inflate(this.context, 2131494422, null);
      paramViewGroup.vjx = ((TextView)paramView.findViewById(2131300624));
      paramViewGroup.KIY = ((TextView)paramView.findViewById(2131300625));
      paramViewGroup.jgy = ((ImageView)paramView.findViewById(2131300623));
      paramViewGroup.xdh = ((CheckBox)paramView.findViewById(2131304502));
      paramView.setTag(paramViewGroup);
      a.b.c(paramViewGroup.jgy, localan.field_username);
      paramViewGroup.KIY.setText(k.b(this.context, w.zP(localan.field_username), a.ax(this.context, 2131165517)));
      paramViewGroup.vjx.setText("(" + r.zC(localan.field_username) + ")");
      if (!x.zW(localan.field_username)) {
        break label290;
      }
      Drawable localDrawable = this.context.getResources().getDrawable(2131691000);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramViewGroup.KIY.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      label232:
      if (this.KIL)
      {
        paramViewGroup.xdh.setVisibility(0);
        if (!this.KIK.contains(localan.field_username)) {
          break label304;
        }
        paramViewGroup.xdh.setChecked(true);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37848);
      return paramView;
      paramViewGroup = (GroupCardSelectUI.a)paramView.getTag();
      break;
      label290:
      paramViewGroup.KIY.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label232;
      label304:
      paramViewGroup.xdh.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.m
 * JD-Core Version:    0.7.0.1
 */