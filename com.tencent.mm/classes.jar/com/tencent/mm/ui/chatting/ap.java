package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.erx;
import com.tencent.mm.sdk.platformtools.Log;

public final class ap
  implements a
{
  private String WEq;
  private LinearLayout WEr;
  private a WEs;
  private Context mContext;
  
  public ap(Context paramContext, String paramString, a parama)
  {
    AppMethodBeat.i(292190);
    this.WEq = paramString;
    this.mContext = paramContext;
    this.WEs = parama;
    this.WEr = new LinearLayout(this.mContext);
    AppMethodBeat.o(292190);
  }
  
  public final void a(k paramk, boolean paramBoolean) {}
  
  public final boolean a(boolean paramBoolean, erx paramerx)
  {
    return false;
  }
  
  public final boolean b(boolean paramBoolean, erx paramerx)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, erx paramerx)
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, erx paramerx)
  {
    return false;
  }
  
  public final boolean eQW()
  {
    return true;
  }
  
  public final String getPath()
  {
    return this.WEq;
  }
  
  public final View getRoot()
  {
    return this.WEr;
  }
  
  public final boolean tX(boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean tY(boolean paramBoolean)
  {
    AppMethodBeat.i(292192);
    Log.i("MicroMsg.ShowRedDotCompoent", "menuKey:%s，show：%s", new Object[] { this.WEq, Boolean.valueOf(paramBoolean) });
    this.WEs.U(paramBoolean, this.WEq);
    AppMethodBeat.o(292192);
    return true;
  }
  
  public final boolean tZ(boolean paramBoolean)
  {
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void U(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ap
 * JD-Core Version:    0.7.0.1
 */