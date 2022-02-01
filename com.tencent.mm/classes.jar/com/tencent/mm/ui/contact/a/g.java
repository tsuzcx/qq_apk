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
  private a.b Kri;
  a.a Krj;
  private CharSequence tBj;
  
  public g(int paramInt)
  {
    super(5, paramInt);
    AppMethodBeat.i(102956);
    this.Kri = new b();
    this.Krj = new a();
    AppMethodBeat.o(102956);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102957);
    parama = new SpannableStringBuilder();
    String[] arrayOfString = this.tun.tuN;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      SpannableString localSpannableString = new SpannableString(str);
      localSpannableString.setSpan(new ForegroundColorSpan(b.b.tya), 0, str.length(), 33);
      parama.append(localSpannableString);
      parama.append("、");
      i += 1;
    }
    this.tBj = TextUtils.concat(new CharSequence[] { paramContext.getString(2131762984), parama.subSequence(0, parama.length() - 1), paramContext.getString(2131762984) });
    AppMethodBeat.o(102957);
  }
  
  public final a.b aRs()
  {
    return this.Kri;
  }
  
  public final class a
    extends a.a
  {
    public TextView iCV;
    public View kke;
    
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
      paramViewGroup = (g.a)g.this.Krj;
      paramViewGroup.iCV = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.kke = paramContext.findViewById(2131300716);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(102954);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102955);
      paramContext = (g.a)parama;
      n.a(g.a((g)parama1), paramContext.iCV);
      if (g.this.position == 0)
      {
        paramContext.kke.setVisibility(8);
        AppMethodBeat.o(102955);
        return;
      }
      paramContext.kke.setVisibility(0);
      AppMethodBeat.o(102955);
    }
    
    public final boolean aRt()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.g
 * JD-Core Version:    0.7.0.1
 */