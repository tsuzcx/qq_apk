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
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;

public final class h
  extends a
{
  private CharSequence BdX;
  private a.b afki;
  a.a afkj;
  
  public h(int paramInt)
  {
    super(5, paramInt);
    AppMethodBeat.i(102956);
    this.afki = new b();
    this.afkj = new a();
    AppMethodBeat.o(102956);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(102957);
    parama = new SpannableStringBuilder();
    String[] arrayOfString = this.FWt.Htg;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      SpannableString localSpannableString = new SpannableString(str);
      localSpannableString.setSpan(new ForegroundColorSpan(b.b.HwL), 0, str.length(), 33);
      parama.append(localSpannableString);
      parama.append("、");
      i += 1;
    }
    this.BdX = TextUtils.concat(new CharSequence[] { paramContext.getString(a.h.select_contact_create_desc_prefix), parama.subSequence(0, parama.length() - 1), paramContext.getString(a.h.select_contact_create_desc_prefix) });
    AppMethodBeat.o(102957);
  }
  
  public final a.b bVv()
  {
    return this.afki;
  }
  
  protected final a.a bVw()
  {
    return this.afkj;
  }
  
  public final class a
    extends a.a
  {
    public TextView plr;
    public View rpv;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcreatechatroomitem, paramViewGroup, false);
      paramViewGroup = (h.a)h.this.afkj;
      paramViewGroup.plr = ((TextView)paramContext.findViewById(a.e.desc_tv));
      paramViewGroup.rpv = paramContext.findViewById(a.e.header_diviver_view);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(102954);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(102955);
      paramContext = (h.a)parama;
      o.a(h.a((h)parama1), paramContext.plr);
      if (h.this.position == 0)
      {
        paramContext.rpv.setVisibility(8);
        AppMethodBeat.o(102955);
        return;
      }
      paramContext.rpv.setVisibility(0);
      AppMethodBeat.o(102955);
    }
    
    public final boolean a(Context paramContext, View paramView, a parama)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.h
 * JD-Core Version:    0.7.0.1
 */