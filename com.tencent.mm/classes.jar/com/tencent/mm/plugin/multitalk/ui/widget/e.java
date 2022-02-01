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
  private a zRS;
  
  public e(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(114718);
    this.zRS = new a();
    AppMethodBeat.o(114718);
  }
  
  public final com.tencent.mm.ui.contact.a.a.b bmx()
  {
    return this.zRS;
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131495729, paramViewGroup, false);
      paramViewGroup = (com.tencent.mm.ui.contact.a.e.a)e.a(e.this);
      paramViewGroup.gvv = ((ImageView)paramContext.findViewById(2131297134));
      paramViewGroup.jVO = ((TextView)paramContext.findViewById(2131309249));
      paramViewGroup.jBR = ((TextView)paramContext.findViewById(2131299510));
      paramViewGroup.contentView = paramContext.findViewById(2131307533);
      paramViewGroup.jVQ = ((CheckBox)paramContext.findViewById(2131307508));
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
        com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.gvv, parama.username);
        n.a(parama.jVL, paramContext.jVO);
        if (!e.this.PWh) {
          break label167;
        }
        if (!paramBoolean1) {
          break label121;
        }
        paramContext.jVQ.setChecked(true);
        paramContext.jVQ.setEnabled(false);
        paramContext.jVQ.setBackgroundResource(2131689955);
      }
      for (;;)
      {
        paramContext.jVQ.setVisibility(0);
        AppMethodBeat.o(114717);
        return;
        paramContext.gvv.setImageResource(2131231957);
        break;
        label121:
        paramContext.jVQ.setChecked(paramBoolean2);
        paramContext.jVQ.setEnabled(true);
        if (paramBoolean2) {
          paramContext.jVQ.setBackgroundResource(2131689951);
        } else {
          paramContext.jVQ.setBackgroundResource(2131231828);
        }
      }
      label167:
      paramContext.jVQ.setVisibility(8);
      AppMethodBeat.o(114717);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */