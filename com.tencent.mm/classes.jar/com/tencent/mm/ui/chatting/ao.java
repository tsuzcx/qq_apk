package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.sdk.platformtools.ae;

public final class ao
  implements a
{
  private String JZn;
  private LinearLayout JZo;
  private a JZp;
  private Context mContext;
  
  public ao(Context paramContext, String paramString, a parama)
  {
    AppMethodBeat.i(187180);
    this.JZn = paramString;
    this.mContext = paramContext;
    this.JZp = parama;
    this.JZo = new LinearLayout(this.mContext);
    AppMethodBeat.o(187180);
  }
  
  public final void a(k paramk, boolean paramBoolean) {}
  
  public final boolean a(boolean paramBoolean, dnz paramdnz)
  {
    return false;
  }
  
  public final boolean b(boolean paramBoolean, dnz paramdnz)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, dnz paramdnz)
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, dnz paramdnz)
  {
    return false;
  }
  
  public final boolean dnD()
  {
    return true;
  }
  
  public final String getPath()
  {
    return this.JZn;
  }
  
  public final View getRoot()
  {
    return this.JZo;
  }
  
  public final boolean oq(boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean or(boolean paramBoolean)
  {
    AppMethodBeat.i(187181);
    ae.i("MicroMsg.ShowRedDotCompoent", "menuKey:%s，show：%s", new Object[] { this.JZn, Boolean.valueOf(paramBoolean) });
    this.JZp.N(paramBoolean, this.JZn);
    AppMethodBeat.o(187181);
    return true;
  }
  
  public final boolean os(boolean paramBoolean)
  {
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void N(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ao
 * JD-Core Version:    0.7.0.1
 */