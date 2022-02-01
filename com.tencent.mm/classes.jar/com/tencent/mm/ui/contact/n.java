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
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.ci.a;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.as;
import java.util.List;

public final class n
  extends BaseAdapter
{
  private List<String> Xsy;
  private boolean Xsz;
  private Context context;
  private List<as> jbu;
  
  public n(Context paramContext, List<as> paramList, List<String> paramList1, boolean paramBoolean)
  {
    this.jbu = paramList;
    this.context = paramContext;
    this.Xsz = paramBoolean;
    this.Xsy = paramList1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37849);
    int i = this.jbu.size();
    AppMethodBeat.o(37849);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(37850);
    Object localObject = this.jbu.get(paramInt);
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
    as localas = (as)this.jbu.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new GroupCardSelectUI.a();
      paramView = View.inflate(this.context, R.i.ehx, null);
      paramViewGroup.Efd = ((TextView)paramView.findViewById(R.h.dIc));
      paramViewGroup.XsM = ((TextView)paramView.findViewById(R.h.dId));
      paramViewGroup.mWb = ((ImageView)paramView.findViewById(R.h.dIb));
      paramViewGroup.GUH = ((CheckBox)paramView.findViewById(R.h.select_cb));
      paramView.setTag(paramViewGroup);
      a.b.c(paramViewGroup.mWb, localas.field_username);
      paramViewGroup.XsM.setText(l.d(this.context, aa.PJ(localas.field_username), a.aY(this.context, R.f.NormalTextSize)));
      paramViewGroup.Efd.setText("(" + v.Pu(localas.field_username) + ")");
      if (!ab.PR(localas.field_username)) {
        break label297;
      }
      Drawable localDrawable = this.context.getResources().getDrawable(R.k.open_im_main_logo);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramViewGroup.XsM.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      label239:
      if (this.Xsz)
      {
        paramViewGroup.GUH.setVisibility(0);
        if (!this.Xsy.contains(localas.field_username)) {
          break label311;
        }
        paramViewGroup.GUH.setChecked(true);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37848);
      return paramView;
      paramViewGroup = (GroupCardSelectUI.a)paramView.getTag();
      break;
      label297:
      paramViewGroup.XsM.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label239;
      label311:
      paramViewGroup.GUH.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.n
 * JD-Core Version:    0.7.0.1
 */