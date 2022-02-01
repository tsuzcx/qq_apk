package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.platformtools.ac;

public final class an
  implements a
{
  private String HQG;
  private LinearLayout HQH;
  private a HQI;
  private Context mContext;
  
  public an(Context paramContext, String paramString, a parama)
  {
    AppMethodBeat.i(196437);
    this.HQG = paramString;
    this.mContext = paramContext;
    this.HQI = parama;
    this.HQH = new LinearLayout(this.mContext);
    AppMethodBeat.o(196437);
  }
  
  public final void a(k paramk, boolean paramBoolean) {}
  
  public final boolean a(boolean paramBoolean, dhn paramdhn)
  {
    return false;
  }
  
  public final boolean b(boolean paramBoolean, dhn paramdhn)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, dhn paramdhn)
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, dhn paramdhn)
  {
    return false;
  }
  
  public final boolean dbk()
  {
    return true;
  }
  
  public final String getPath()
  {
    return this.HQG;
  }
  
  public final View getRoot()
  {
    return this.HQH;
  }
  
  public final boolean nR(boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean nS(boolean paramBoolean)
  {
    AppMethodBeat.i(196438);
    ac.i("MicroMsg.ShowRedDotCompoent", "menuKey:%s，show：%s", new Object[] { this.HQG, Boolean.valueOf(paramBoolean) });
    this.HQI.G(paramBoolean, this.HQG);
    AppMethodBeat.o(196438);
    return true;
  }
  
  public final boolean nT(boolean paramBoolean)
  {
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void G(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.an
 * JD-Core Version:    0.7.0.1
 */