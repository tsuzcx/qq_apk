package com.tencent.mm.plugin.recordvideo.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/util/RecordTimeCalculatePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "()V", "timeStartMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "calculate", "tag", "extra", "mark", "release", "", "Companion", "plugin-recordvideo_release"})
public final class e
  implements t
{
  public static final e.a yhw;
  public final HashMap<String, Long> yhv;
  
  static
  {
    AppMethodBeat.i(207147);
    yhw = new e.a((byte)0);
    AppMethodBeat.o(207147);
  }
  
  public e()
  {
    AppMethodBeat.i(207146);
    this.yhv = new HashMap();
    AppMethodBeat.o(207146);
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void azm() {}
  
  public final long iW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207144);
    p.h(paramString1, "tag");
    if (this.yhv.get(paramString1) == null)
    {
      ae.e("MicroMsg.RecordTimeCalculatePlugin", paramString1 + " miss start mark!!!");
      AppMethodBeat.o(207144);
      return -1L;
    }
    paramString1 = (Long)this.yhv.get(paramString1);
    if (paramString1 != null)
    {
      long l = System.currentTimeMillis();
      p.g(paramString1, "this");
      l -= paramString1.longValue();
      ae.i("MicroMsg.RecordTimeCalculatePlugin", paramString2 + " cost time:" + l);
      AppMethodBeat.o(207144);
      return l;
    }
    AppMethodBeat.o(207144);
    return -1L;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(207148);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(207148);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(207145);
    this.yhv.clear();
    AppMethodBeat.o(207145);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.e
 * JD-Core Version:    0.7.0.1
 */