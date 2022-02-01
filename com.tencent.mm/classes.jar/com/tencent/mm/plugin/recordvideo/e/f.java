package com.tencent.mm.plugin.recordvideo.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/util/RecordTimeCalculatePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "()V", "timeStartMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "calculate", "tag", "extra", "mark", "release", "", "Companion", "plugin-recordvideo_release"})
public final class f
  implements t
{
  public static final f.a Civ;
  private final HashMap<String, Long> Ciu;
  
  static
  {
    AppMethodBeat.i(237995);
    Civ = new f.a((byte)0);
    AppMethodBeat.o(237995);
  }
  
  public f()
  {
    AppMethodBeat.i(237994);
    this.Ciu = new HashMap();
    AppMethodBeat.o(237994);
  }
  
  public final long aLR(String paramString)
  {
    AppMethodBeat.i(237991);
    p.h(paramString, "tag");
    long l = System.currentTimeMillis();
    ((Map)this.Ciu).put(paramString, Long.valueOf(l));
    AppMethodBeat.o(237991);
    return l;
  }
  
  public final void aSs() {}
  
  public final long jH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(237992);
    p.h(paramString1, "tag");
    if (this.Ciu.get(paramString1) == null)
    {
      Log.e("MicroMsg.RecordTimeCalculatePlugin", paramString1 + " miss start mark!!!");
      AppMethodBeat.o(237992);
      return -1L;
    }
    paramString1 = (Long)this.Ciu.get(paramString1);
    if (paramString1 != null)
    {
      long l = System.currentTimeMillis();
      p.g(paramString1, "this");
      l -= paramString1.longValue();
      Log.i("MicroMsg.RecordTimeCalculatePlugin", paramString2 + " cost time:" + l);
      AppMethodBeat.o(237992);
      return l;
    }
    AppMethodBeat.o(237992);
    return -1L;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(237996);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(237996);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(237993);
    this.Ciu.clear();
    AppMethodBeat.o(237993);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.f
 * JD-Core Version:    0.7.0.1
 */