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
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.n;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.ad;
import java.util.List;

public final class l
  extends BaseAdapter
{
  private List<String> AcR;
  private boolean AcS;
  private Context context;
  private List<ad> oBz;
  
  public l(Context paramContext, List<ad> paramList, List<String> paramList1, boolean paramBoolean)
  {
    this.oBz = paramList;
    this.context = paramContext;
    this.AcS = paramBoolean;
    this.AcR = paramList1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(153964);
    int i = this.oBz.size();
    AppMethodBeat.o(153964);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(153965);
    Object localObject = this.oBz.get(paramInt);
    AppMethodBeat.o(153965);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(153963);
    ad localad = (ad)this.oBz.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new GroupCardSelectUI.a();
      paramView = View.inflate(this.context, 2130969851, null);
      paramViewGroup.nZD = ((TextView)paramView.findViewById(2131824835));
      paramViewGroup.Ada = ((TextView)paramView.findViewById(2131824834));
      paramViewGroup.gxs = ((ImageView)paramView.findViewById(2131824833));
      paramViewGroup.pvL = ((CheckBox)paramView.findViewById(2131821631));
      paramView.setTag(paramViewGroup);
      a.b.c(paramViewGroup.gxs, localad.field_username);
      paramViewGroup.Ada.setText(j.b(this.context, s.nE(localad.field_username), a.ao(this.context, 2131427809)));
      paramViewGroup.nZD.setText("(" + n.nv(localad.field_username) + ")");
      if (!t.nK(localad.field_username)) {
        break label290;
      }
      Drawable localDrawable = this.context.getResources().getDrawable(2131231831);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramViewGroup.Ada.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      label232:
      if (this.AcS)
      {
        paramViewGroup.pvL.setVisibility(0);
        if (!this.AcR.contains(localad.field_username)) {
          break label304;
        }
        paramViewGroup.pvL.setChecked(true);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(153963);
      return paramView;
      paramViewGroup = (GroupCardSelectUI.a)paramView.getTag();
      break;
      label290:
      paramViewGroup.Ada.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label232;
      label304:
      paramViewGroup.pvL.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.l
 * JD-Core Version:    0.7.0.1
 */