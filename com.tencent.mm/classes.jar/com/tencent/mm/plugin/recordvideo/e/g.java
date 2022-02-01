package com.tencent.mm.plugin.recordvideo.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.recordvideo.plugin.u.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/util/RecordTimeCalculatePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "()V", "timeStartMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "calculate", "tag", "extra", "mark", "release", "", "Companion", "plugin-recordvideo_release"})
public final class g
  implements u
{
  public static final a Ifm;
  private final HashMap<String, Long> Ifl;
  
  static
  {
    AppMethodBeat.i(221464);
    Ifm = new a((byte)0);
    AppMethodBeat.o(221464);
  }
  
  public g()
  {
    AppMethodBeat.i(221463);
    this.Ifl = new HashMap();
    AppMethodBeat.o(221463);
  }
  
  public final long aWu(String paramString)
  {
    AppMethodBeat.i(221455);
    p.k(paramString, "tag");
    long l = System.currentTimeMillis();
    ((Map)this.Ifl).put(paramString, Long.valueOf(l));
    AppMethodBeat.o(221455);
    return l;
  }
  
  public final void bbp() {}
  
  public final long jW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(221459);
    p.k(paramString1, "tag");
    if (this.Ifl.get(paramString1) == null)
    {
      Log.e("MicroMsg.RecordTimeCalculatePlugin", paramString1 + " miss start mark!!!");
      AppMethodBeat.o(221459);
      return -1L;
    }
    paramString1 = (Long)this.Ifl.get(paramString1);
    if (paramString1 != null)
    {
      long l = System.currentTimeMillis();
      p.j(paramString1, "this");
      l -= paramString1.longValue();
      Log.i("MicroMsg.RecordTimeCalculatePlugin", paramString2 + " cost time:" + l);
      AppMethodBeat.o(221459);
      return l;
    }
    AppMethodBeat.o(221459);
    return -1L;
  }
  
  public final String name()
  {
    AppMethodBeat.i(221466);
    String str = getClass().getName();
    AppMethodBeat.o(221466);
    return str;
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
    AppMethodBeat.i(221469);
    p.k(paramArrayOfString, "permissions");
    p.k(paramArrayOfInt, "grantResults");
    u.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(221469);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(221460);
    this.Ifl.clear();
    AppMethodBeat.o(221460);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/util/RecordTimeCalculatePlugin$Companion;", "", "()V", "TAG", "", "TIME_START", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.g
 * JD-Core Version:    0.7.0.1
 */