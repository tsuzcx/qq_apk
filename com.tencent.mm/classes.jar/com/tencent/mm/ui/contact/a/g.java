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
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.plugin.fts.ui.m;

public final class g
  extends a
{
  private a.b Agn;
  a.a Ago;
  private CharSequence mZb;
  
  public g(int paramInt)
  {
    super(5, paramInt);
    AppMethodBeat.i(105291);
    this.Agn = new b();
    this.Ago = new g.a(this);
    AppMethodBeat.o(105291);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(105292);
    parama = new SpannableStringBuilder();
    String[] arrayOfString = this.mRX.mSy;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      SpannableString localSpannableString = new SpannableString(str);
      localSpannableString.setSpan(new ForegroundColorSpan(b.b.mVQ), 0, str.length(), 33);
      parama.append(localSpannableString);
      parama.append("、");
      i += 1;
    }
    this.mZb = TextUtils.concat(new CharSequence[] { paramContext.getString(2131303040), parama.subSequence(0, parama.length() - 1), paramContext.getString(2131303040) });
    AppMethodBeat.o(105292);
  }
  
  public final a.b aoY()
  {
    return this.Agn;
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
      AppMethodBeat.i(105289);
      paramContext = LayoutInflater.from(paramContext).inflate(2130970666, paramViewGroup, false);
      paramViewGroup = (g.a)g.this.Ago;
      paramViewGroup.gpM = ((TextView)paramContext.findViewById(2131821007));
      paramViewGroup.hrR = paramContext.findViewById(2131827558);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(105289);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(105290);
      paramContext = (g.a)parama;
      m.a(g.a((g)parama1), paramContext.gpM);
      if (g.this.position == 0)
      {
        paramContext.hrR.setVisibility(8);
        AppMethodBeat.o(105290);
        return;
      }
      paramContext.hrR.setVisibility(0);
      AppMethodBeat.o(105290);
    }
    
    public final boolean aoZ()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.g
 * JD-Core Version:    0.7.0.1
 */