package com.tencent.mm.plugin.recordvideo.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.HashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/util/RecordTimeCalculatePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "()V", "timeStartMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "calculate", "tag", "extra", "mark", "release", "", "Companion", "plugin-recordvideo_release"})
public final class e
  implements t
{
  public static final a wDW;
  public final HashMap<String, Long> wDV;
  
  static
  {
    AppMethodBeat.i(199462);
    wDW = new a((byte)0);
    AppMethodBeat.o(199462);
  }
  
  public e()
  {
    AppMethodBeat.i(199461);
    this.wDV = new HashMap();
    AppMethodBeat.o(199461);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void awk() {}
  
  public final long iD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(199459);
    k.h(paramString1, "tag");
    if (this.wDV.get(paramString1) == null)
    {
      ac.e("MicroMsg.RecordTimeCalculatePlugin", paramString1 + " miss start mark!!!");
      AppMethodBeat.o(199459);
      return -1L;
    }
    paramString1 = (Long)this.wDV.get(paramString1);
    if (paramString1 != null)
    {
      long l = System.currentTimeMillis();
      k.g(paramString1, "this");
      l -= paramString1.longValue();
      ac.i("MicroMsg.RecordTimeCalculatePlugin", paramString2 + " cost time:" + l);
      AppMethodBeat.o(199459);
      return l;
    }
    AppMethodBeat.o(199459);
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
    AppMethodBeat.i(199460);
    this.wDV.clear();
    AppMethodBeat.o(199460);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/util/RecordTimeCalculatePlugin$Companion;", "", "()V", "TAG", "", "TIME_START", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.e
 * JD-Core Version:    0.7.0.1
 */