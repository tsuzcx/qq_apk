package com.tencent.mm.plugin.teenmode.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.teenmode.a.f;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.a.a;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.d.a;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.pluginsdk.ui.applet.y.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.aa;
import java.util.HashMap;

public final class k
  implements d
{
  public static k hEz()
  {
    return k.a.SZe;
  }
  
  public final <T extends a> void a(int paramInt, T paramT) {}
  
  public final void a(int paramInt, b paramb) {}
  
  public final void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, d.a parama)
  {
    AppMethodBeat.i(278960);
    j.b(paramActivity, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramBoolean, parama);
    AppMethodBeat.o(278960);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3, String paramString4, Boolean paramBoolean) {}
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong) {}
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(278935);
    Log.w("MicroMsg.TeenModeServiceProxy", "registerTeenModeDataChangedListener not implemented in non-MM process");
    AppMethodBeat.o(278935);
  }
  
  public final boolean a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, y.b paramb, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return true;
  }
  
  public final boolean a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, y.b paramb)
  {
    return false;
  }
  
  public final boolean aBu()
  {
    AppMethodBeat.i(278882);
    Log.w("MicroMsg.TeenModeServiceProxy", "isTeenMode not implemented in non-MM process");
    AppMethodBeat.o(278882);
    return false;
  }
  
  public final a aoi(int paramInt)
  {
    return null;
  }
  
  public final b aoj(int paramInt)
  {
    return null;
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(278940);
    Log.w("MicroMsg.TeenModeServiceProxy", "unregisterTeenModeDataChangedListener not implemented in non-MM process");
    AppMethodBeat.o(278940);
  }
  
  public final boolean bdk(String paramString)
  {
    return false;
  }
  
  public final boolean jdMethod_do(int paramInt, String paramString)
  {
    return false;
  }
  
  public final int eZD()
  {
    AppMethodBeat.i(278896);
    Log.w("MicroMsg.TeenModeServiceProxy", "getFinderOption not implemented in non-MM process");
    AppMethodBeat.o(278896);
    return 0;
  }
  
  public final void hEp() {}
  
  public final int hEq()
  {
    AppMethodBeat.i(278901);
    Log.w("MicroMsg.TeenModeServiceProxy", "getBizAcctOption not implemented in non-MM process");
    AppMethodBeat.o(278901);
    return 0;
  }
  
  public final int hEr()
  {
    AppMethodBeat.i(278908);
    Log.w("MicroMsg.TeenModeServiceProxy", "getMiniProgramOption not implemented in non-MM process");
    AppMethodBeat.o(278908);
    return 0;
  }
  
  public final void hEs()
  {
    AppMethodBeat.i(278943);
    Log.w("MicroMsg.TeenModeServiceProxy", "notifyTeenModeDataChanged not implemented in non-MM process");
    AppMethodBeat.o(278943);
  }
  
  public final boolean hEt()
  {
    AppMethodBeat.i(278929);
    Log.w("MicroMsg.TeenModeServiceProxy", "isHideTeenModeEntrance not implemented in non-MM process");
    AppMethodBeat.o(278929);
    return false;
  }
  
  public final au hEu()
  {
    return null;
  }
  
  public final HashMap<Integer, String> hEv()
  {
    return null;
  }
  
  public final void kg(Context paramContext)
  {
    AppMethodBeat.i(278914);
    aa.y(paramContext, paramContext.getString(a.g.SXR), a.f.icons_outlined_umbrella);
    AppMethodBeat.o(278914);
  }
  
  public final void kh(Context paramContext) {}
  
  public final void n(Activity paramActivity, int paramInt) {}
  
  public final void rG(int paramInt)
  {
    AppMethodBeat.i(278921);
    Log.w("MicroMsg.TeenModeServiceProxy", "report not implemented in non-MM process");
    AppMethodBeat.o(278921);
  }
  
  public final void setScene(int paramInt)
  {
    AppMethodBeat.i(278925);
    Log.w("MicroMsg.TeenModeServiceProxy", "setScene not implemented in non-MM process");
    AppMethodBeat.o(278925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.k
 * JD-Core Version:    0.7.0.1
 */