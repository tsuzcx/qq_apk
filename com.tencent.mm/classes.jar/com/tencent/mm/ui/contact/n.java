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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.cd.a;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storage.au;
import java.util.List;

public final class n
  extends BaseAdapter
{
  private List<String> afdZ;
  private boolean afea;
  private Context context;
  private List<au> lDu;
  
  public n(Context paramContext, List<au> paramList, List<String> paramList1, boolean paramBoolean)
  {
    this.lDu = paramList;
    this.context = paramContext;
    this.afea = paramBoolean;
    this.afdZ = paramList1;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37849);
    int i = this.lDu.size();
    AppMethodBeat.o(37849);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(37850);
    Object localObject = this.lDu.get(paramInt);
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
    au localau = (au)this.lDu.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new GroupCardSelectUI.a();
      paramView = View.inflate(this.context, R.i.gks, null);
      paramViewGroup.JXk = ((TextView)paramView.findViewById(R.h.fJp));
      paramViewGroup.afen = ((TextView)paramView.findViewById(R.h.fJq));
      paramViewGroup.avatar = ((ImageView)paramView.findViewById(R.h.fJo));
      paramViewGroup.MSj = ((CheckBox)paramView.findViewById(R.h.select_cb));
      paramView.setTag(paramViewGroup);
      a.b.g(paramViewGroup.avatar, localau.field_username);
      paramViewGroup.afen.setText(p.d(this.context, aa.getDisplayName(localau.field_username), a.br(this.context, R.f.NormalTextSize)));
      paramViewGroup.JXk.setText("(" + v.getMembersCountByChatRoomName(localau.field_username) + ")");
      if (!ab.IG(localau.field_username)) {
        break label297;
      }
      Drawable localDrawable = this.context.getResources().getDrawable(R.k.open_im_main_logo);
      localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
      paramViewGroup.afen.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      label239:
      if (this.afea)
      {
        paramViewGroup.MSj.setVisibility(0);
        if (!this.afdZ.contains(localau.field_username)) {
          break label311;
        }
        paramViewGroup.MSj.setChecked(true);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(37848);
      return paramView;
      paramViewGroup = (GroupCardSelectUI.a)paramView.getTag();
      break;
      label297:
      paramViewGroup.afen.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      break label239;
      label311:
      paramViewGroup.MSj.setChecked(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.n
 * JD-Core Version:    0.7.0.1
 */