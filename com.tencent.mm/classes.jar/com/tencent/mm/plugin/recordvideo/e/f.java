package com.tencent.mm.plugin.recordvideo.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.HashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/util/RecordTimeCalculatePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "()V", "timeStartMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "calculate", "tag", "extra", "mark", "release", "", "Companion", "plugin-recordvideo_release"})
public final class f
  implements t
{
  public static final a LpX;
  public final HashMap<String, Long> LpW;
  
  static
  {
    AppMethodBeat.i(204342);
    LpX = new a((byte)0);
    AppMethodBeat.o(204342);
  }
  
  public f()
  {
    AppMethodBeat.i(204341);
    this.LpW = new HashMap();
    AppMethodBeat.o(204341);
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    return false;
  }
  
  public final long mU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204339);
    k.h(paramString1, "tag");
    if (this.LpW.get(paramString1) == null)
    {
      ad.e("MicroMsg.RecordTimeCalculatePlugin", paramString1 + " miss start mark!!!");
      AppMethodBeat.o(204339);
      return -1L;
    }
    paramString1 = (Long)this.LpW.get(paramString1);
    if (paramString1 != null)
    {
      long l = System.currentTimeMillis();
      k.g(paramString1, "this");
      l -= paramString1.longValue();
      ad.i("MicroMsg.RecordTimeCalculatePlugin", paramString2 + " cost time:" + l);
      AppMethodBeat.o(204339);
      return l;
    }
    AppMethodBeat.o(204339);
    return -1L;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(204340);
    this.LpW.clear();
    AppMethodBeat.o(204340);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/util/RecordTimeCalculatePlugin$Companion;", "", "()V", "TAG", "", "TIME_START", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.f
 * JD-Core Version:    0.7.0.1
 */