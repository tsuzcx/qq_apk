package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.fng;
import com.tencent.mm.sdk.platformtools.Log;

public final class ar
  implements a
{
  private String aelQ;
  private LinearLayout aelR;
  private a aelS;
  private Context mContext;
  
  public ar(Context paramContext, String paramString, a parama)
  {
    AppMethodBeat.i(253731);
    this.aelQ = paramString;
    this.mContext = paramContext;
    this.aelS = parama;
    this.aelR = new LinearLayout(this.mContext);
    AppMethodBeat.o(253731);
  }
  
  public final void a(k paramk, boolean paramBoolean) {}
  
  public final boolean a(boolean paramBoolean, fng paramfng)
  {
    return false;
  }
  
  public final boolean b(boolean paramBoolean, fng paramfng)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, fng paramfng)
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, fng paramfng)
  {
    return false;
  }
  
  public final boolean fZD()
  {
    return true;
  }
  
  public final String getPath()
  {
    return this.aelQ;
  }
  
  public final View getRoot()
  {
    return this.aelR;
  }
  
  public final boolean ym(boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean yn(boolean paramBoolean)
  {
    AppMethodBeat.i(253736);
    Log.i("MicroMsg.ShowRedDotCompoent", "menuKey:%s，show：%s", new Object[] { this.aelQ, Boolean.valueOf(paramBoolean) });
    this.aelS.aR(paramBoolean, this.aelQ);
    AppMethodBeat.o(253736);
    return true;
  }
  
  public final boolean yo(boolean paramBoolean)
  {
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void aR(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ar
 * JD-Core Version:    0.7.0.1
 */