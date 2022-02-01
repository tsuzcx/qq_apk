package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.sdk.platformtools.ad;

public final class an
  implements a
{
  private String GqO;
  private LinearLayout GqP;
  private a GqQ;
  private Context mContext;
  
  public an(Context paramContext, String paramString, a parama)
  {
    AppMethodBeat.i(191485);
    this.GqO = paramString;
    this.mContext = paramContext;
    this.GqQ = parama;
    this.GqP = new LinearLayout(this.mContext);
    AppMethodBeat.o(191485);
  }
  
  public final void a(k paramk, boolean paramBoolean) {}
  
  public final boolean a(boolean paramBoolean, dcb paramdcb)
  {
    return false;
  }
  
  public final boolean b(boolean paramBoolean, dcb paramdcb)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, dcb paramdcb)
  {
    return false;
  }
  
  public final boolean cND()
  {
    return true;
  }
  
  public final boolean d(boolean paramBoolean, dcb paramdcb)
  {
    return false;
  }
  
  public final String getPath()
  {
    return this.GqO;
  }
  
  public final View getRoot()
  {
    return this.GqP;
  }
  
  public final boolean mY(boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean mZ(boolean paramBoolean)
  {
    AppMethodBeat.i(191486);
    ad.i("MicroMsg.ShowRedDotCompoent", "menuKey:%s，show：%s", new Object[] { this.GqO, Boolean.valueOf(paramBoolean) });
    this.GqQ.F(paramBoolean, this.GqO);
    AppMethodBeat.o(191486);
    return true;
  }
  
  public final boolean na(boolean paramBoolean)
  {
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void F(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.an
 * JD-Core Version:    0.7.0.1
 */