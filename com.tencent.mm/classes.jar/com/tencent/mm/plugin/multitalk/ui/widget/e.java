package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.f.a;
import com.tencent.mm.ui.contact.a.f.b;

public final class e
  extends f
{
  private a LtH;
  
  public e(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(114718);
    this.LtH = new a();
    AppMethodBeat.o(114718);
  }
  
  public final com.tencent.mm.ui.contact.a.a.b bVv()
  {
    return this.LtH;
  }
  
  public final class a
    extends f.b
  {
    public a()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(114716);
      paramContext = LayoutInflater.from(paramContext).inflate(a.f.multitalk_listcontactitem, paramViewGroup, false);
      paramViewGroup = (f.a)e.a(e.this);
      paramViewGroup.lBC = ((ImageView)paramContext.findViewById(a.e.avatar_iv));
      paramViewGroup.pJJ = ((TextView)paramContext.findViewById(a.e.title_tv));
      paramViewGroup.plr = ((TextView)paramContext.findViewById(a.e.desc_tv));
      paramViewGroup.contentView = paramContext.findViewById(a.e.select_item_content_layout);
      paramViewGroup.pJL = ((CheckBox)paramContext.findViewById(a.e.select_cb));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(114716);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(114717);
      paramContext = (f.a)parama;
      parama = (f)parama1;
      if ((parama.username != null) && (parama.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.g(paramContext.lBC, parama.username);
        o.a(parama.pJG, paramContext.pJJ);
        if (!e.this.afey) {
          break label171;
        }
        if (!paramBoolean1) {
          break label123;
        }
        paramContext.pJL.setChecked(true);
        paramContext.pJL.setEnabled(false);
        paramContext.pJL.setBackgroundResource(a.g.checkbox_selected_grey_dark);
      }
      for (;;)
      {
        paramContext.pJL.setVisibility(0);
        AppMethodBeat.o(114717);
        return;
        paramContext.lBC.setImageResource(a.d.default_avatar);
        break;
        label123:
        paramContext.pJL.setChecked(paramBoolean2);
        paramContext.pJL.setEnabled(true);
        if (paramBoolean2) {
          paramContext.pJL.setBackgroundResource(a.g.checkbox_selected);
        } else {
          paramContext.pJL.setBackgroundResource(a.d.checkbox_unselected_un);
        }
      }
      label171:
      paramContext.pJL.setVisibility(8);
      AppMethodBeat.o(114717);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */