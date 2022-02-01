package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.sdk.platformtools.ad;

public final class an
  implements a
{
  private String JEw;
  private LinearLayout JEx;
  private a JEy;
  private Context mContext;
  
  public an(Context paramContext, String paramString, a parama)
  {
    AppMethodBeat.i(193873);
    this.JEw = paramString;
    this.mContext = paramContext;
    this.JEy = parama;
    this.JEx = new LinearLayout(this.mContext);
    AppMethodBeat.o(193873);
  }
  
  public final void a(k paramk, boolean paramBoolean) {}
  
  public final boolean a(boolean paramBoolean, dnc paramdnc)
  {
    return false;
  }
  
  public final boolean b(boolean paramBoolean, dnc paramdnc)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, dnc paramdnc)
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, dnc paramdnc)
  {
    return false;
  }
  
  public final boolean dkD()
  {
    return true;
  }
  
  public final String getPath()
  {
    return this.JEw;
  }
  
  public final View getRoot()
  {
    return this.JEx;
  }
  
  public final boolean ol(boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean om(boolean paramBoolean)
  {
    AppMethodBeat.i(193874);
    ad.i("MicroMsg.ShowRedDotCompoent", "menuKey:%s，show：%s", new Object[] { this.JEw, Boolean.valueOf(paramBoolean) });
    this.JEy.L(paramBoolean, this.JEw);
    AppMethodBeat.o(193874);
    return true;
  }
  
  public final boolean on(boolean paramBoolean)
  {
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void L(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.an
 * JD-Core Version:    0.7.0.1
 */