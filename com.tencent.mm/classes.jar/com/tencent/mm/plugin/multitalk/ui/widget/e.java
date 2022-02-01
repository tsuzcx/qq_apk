package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.e.b;

public final class e
  extends com.tencent.mm.ui.contact.a.e
{
  private a wuV;
  
  public e(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(114718);
    this.wuV = new a();
    AppMethodBeat.o(114718);
  }
  
  public final com.tencent.mm.ui.contact.a.a.b aRR()
  {
    return this.wuV;
  }
  
  public final class a
    extends e.b
  {
    public a()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(114716);
      paramContext = LayoutInflater.from(paramContext).inflate(2131494975, paramViewGroup, false);
      paramViewGroup = (com.tencent.mm.ui.contact.a.e.a)e.a(e.this);
      paramViewGroup.fQl = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iYj = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.iFO = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.contentView = paramContext.findViewById(2131304518);
      paramViewGroup.iYl = ((CheckBox)paramContext.findViewById(2131304502));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(114716);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(114717);
      paramContext = (com.tencent.mm.ui.contact.a.e.a)parama;
      parama = (com.tencent.mm.ui.contact.a.e)parama1;
      if ((parama.username != null) && (parama.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.fQl, parama.username);
        n.a(parama.iYg, paramContext.iYj);
        if (!e.this.KJj) {
          break label167;
        }
        if (!paramBoolean1) {
          break label121;
        }
        paramContext.iYl.setChecked(true);
        paramContext.iYl.setEnabled(false);
        paramContext.iYl.setBackgroundResource(2131689939);
      }
      for (;;)
      {
        paramContext.iYl.setVisibility(0);
        AppMethodBeat.o(114717);
        return;
        paramContext.fQl.setImageResource(2131231875);
        break;
        label121:
        paramContext.iYl.setChecked(paramBoolean2);
        paramContext.iYl.setEnabled(true);
        if (paramBoolean2) {
          paramContext.iYl.setBackgroundResource(2131689936);
        } else {
          paramContext.iYl.setBackgroundResource(2131231752);
        }
      }
      label167:
      paramContext.iYl.setVisibility(8);
      AppMethodBeat.o(114717);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */