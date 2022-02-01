package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.plugin.fts.ui.n;

public final class g
  extends a
{
  private a.b KNC;
  a.a KND;
  private CharSequence tMa;
  
  public g(int paramInt)
  {
    super(5, paramInt);
    AppMethodBeat.i(102956);
    this.KNC = new b();
    this.KND = new a();
    AppMethodBeat.o(102956);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102957);
    parama = new SpannableStringBuilder();
    String[] arrayOfString = this.tFe.tFE;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      SpannableString localSpannableString = new SpannableString(str);
      localSpannableString.setSpan(new ForegroundColorSpan(b.b.tIR), 0, str.length(), 33);
      parama.append(localSpannableString);
      parama.append("、");
      i += 1;
    }
    this.tMa = TextUtils.concat(new CharSequence[] { paramContext.getString(2131762984), parama.subSequence(0, parama.length() - 1), paramContext.getString(2131762984) });
    AppMethodBeat.o(102957);
  }
  
  public final a.b aRR()
  {
    return this.KNC;
  }
  
  public final class a
    extends a.a
  {
    public TextView iFO;
    public View knu;
    
    public a()
    {
      super();
    }
  }
  
  public final class b
    extends a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(102954);
      paramContext = LayoutInflater.from(paramContext).inflate(2131495361, paramViewGroup, false);
      paramViewGroup = (g.a)g.this.KND;
      paramViewGroup.iFO = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.knu = paramContext.findViewById(2131300716);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(102954);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102955);
      paramContext = (g.a)parama;
      n.a(g.a((g)parama1), paramContext.iFO);
      if (g.this.position == 0)
      {
        paramContext.knu.setVisibility(8);
        AppMethodBeat.o(102955);
        return;
      }
      paramContext.knu.setVisibility(0);
      AppMethodBeat.o(102955);
    }
    
    public final boolean aRS()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.g
 * JD-Core Version:    0.7.0.1
 */