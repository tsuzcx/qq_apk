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
import com.tencent.mm.plugin.fts.ui.m;

public final class g
  extends a
{
  private a.b IAc;
  a.a IAd;
  private CharSequence sEs;
  
  public g(int paramInt)
  {
    super(5, paramInt);
    AppMethodBeat.i(102956);
    this.IAc = new b();
    this.IAd = new a();
    AppMethodBeat.o(102956);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102957);
    parama = new SpannableStringBuilder();
    String[] arrayOfString = this.sxM.sym;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      SpannableString localSpannableString = new SpannableString(str);
      localSpannableString.setSpan(new ForegroundColorSpan(b.b.sBz), 0, str.length(), 33);
      parama.append(localSpannableString);
      parama.append("、");
      i += 1;
    }
    this.sEs = TextUtils.concat(new CharSequence[] { paramContext.getString(2131762984), parama.subSequence(0, parama.length() - 1), paramContext.getString(2131762984) });
    AppMethodBeat.o(102957);
  }
  
  public final a.b aOg()
  {
    return this.IAc;
  }
  
  public final class a
    extends a.a
  {
    public TextView ijE;
    public View jPT;
    
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
      paramViewGroup = (g.a)g.this.IAd;
      paramViewGroup.ijE = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.jPT = paramContext.findViewById(2131300716);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(102954);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102955);
      paramContext = (g.a)parama;
      m.a(g.a((g)parama1), paramContext.ijE);
      if (g.this.position == 0)
      {
        paramContext.jPT.setVisibility(8);
        AppMethodBeat.o(102955);
        return;
      }
      paramContext.jPT.setVisibility(0);
      AppMethodBeat.o(102955);
    }
    
    public final boolean aOh()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.g
 * JD-Core Version:    0.7.0.1
 */