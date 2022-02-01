package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.platformtools.Log;

public final class ap
  implements a
{
  private String PkH;
  private LinearLayout PkI;
  private a PkJ;
  private Context mContext;
  
  public ap(Context paramContext, String paramString, a parama)
  {
    AppMethodBeat.i(232923);
    this.PkH = paramString;
    this.mContext = paramContext;
    this.PkJ = parama;
    this.PkI = new LinearLayout(this.mContext);
    AppMethodBeat.o(232923);
  }
  
  public final void a(k paramk, boolean paramBoolean) {}
  
  public final boolean a(boolean paramBoolean, ehv paramehv)
  {
    return false;
  }
  
  public final boolean b(boolean paramBoolean, ehv paramehv)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, ehv paramehv)
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, ehv paramehv)
  {
    return false;
  }
  
  public final boolean ehp()
  {
    return true;
  }
  
  public final String getPath()
  {
    return this.PkH;
  }
  
  public final View getRoot()
  {
    return this.PkI;
  }
  
  public final boolean qV(boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean qW(boolean paramBoolean)
  {
    AppMethodBeat.i(232924);
    Log.i("MicroMsg.ShowRedDotCompoent", "menuKey:%s，show：%s", new Object[] { this.PkH, Boolean.valueOf(paramBoolean) });
    this.PkJ.O(paramBoolean, this.PkH);
    AppMethodBeat.o(232924);
    return true;
  }
  
  public final boolean qX(boolean paramBoolean)
  {
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void O(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ap
 * JD-Core Version:    0.7.0.1
 */