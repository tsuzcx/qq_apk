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
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.q;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.ai;
import java.util.List;

public final class m
  extends BaseAdapter
{
  private List<String> IvK;
  private boolean IvL;
  private Context context;
  private List<ai> fwF;
  
  public m(Context paramContext, List<ai> paramList, List<String> paramList1, boolean paramBoolean)
  {
    this.fwF = paramList;
    this.context = paramContext;
    this.IvL = paramBoolean;
    this.IvK = paramList1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37849);
    int i = this.fwF.size();
    AppMethodBeat.o(37849);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(37850);
    Object localObject = this.fwF.get(paramInt);
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
    ai localai = (ai)this.fwF.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new GroupCardSelectUI.a();
      paramView = View.inflate(this.context, 2131494422, null);
      paramViewGroup.tVh = ((TextView)paramView.findViewById(2131300624));
      paramViewGroup.IvW = ((TextView)paramView.findViewById(2131300625));
      paramViewGroup.iKw = ((ImageView)paramView.findViewById(2131300623));
      paramViewGroup.vGm = ((CheckBox)paramView.findViewById(2131304502));
      paramView.setTag(paramViewGroup);
      a.b.c(paramViewGroup.iKw, localai.field_username);
      paramViewGroup.IvW.setText(k.b(this.context, v.wk(localai.field_username), a.au(this.context, 2131165517)));
      paramViewGroup.tVh.setText("(" + q.wb(localai.field_username) + ")");
      if (!w.wr(localai.field_username)) {
        break label290;
      }
      Drawable localDrawable = this.context.getResources().getDrawable(2131691000);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramViewGroup.IvW.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      label232:
      if (this.IvL)
      {
        paramViewGroup.vGm.setVisibility(0);
        if (!this.IvK.contains(localai.field_username)) {
          break label304;
        }
        paramViewGroup.vGm.setChecked(true);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37848);
      return paramView;
      paramViewGroup = (GroupCardSelectUI.a)paramView.getTag();
      break;
      label290:
      paramViewGroup.IvW.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label232;
      label304:
      paramViewGroup.vGm.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.m
 * JD-Core Version:    0.7.0.1
 */