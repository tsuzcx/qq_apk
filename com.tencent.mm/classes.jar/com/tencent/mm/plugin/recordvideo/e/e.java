package com.tencent.mm.plugin.recordvideo.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/util/RecordTimeCalculatePlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "()V", "timeStartMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "calculate", "tag", "extra", "mark", "release", "", "Companion", "plugin-recordvideo_release"})
public final class e
  implements t
{
  public static final e.a xRD;
  public final HashMap<String, Long> xRC;
  
  static
  {
    AppMethodBeat.i(200889);
    xRD = new e.a((byte)0);
    AppMethodBeat.o(200889);
  }
  
  public e()
  {
    AppMethodBeat.i(200888);
    this.xRC = new HashMap();
    AppMethodBeat.o(200888);
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ayX() {}
  
  public final long iQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(200886);
    p.h(paramString1, "tag");
    if (this.xRC.get(paramString1) == null)
    {
      ad.e("MicroMsg.RecordTimeCalculatePlugin", paramString1 + " miss start mark!!!");
      AppMethodBeat.o(200886);
      return -1L;
    }
    paramString1 = (Long)this.xRC.get(paramString1);
    if (paramString1 != null)
    {
      long l = System.currentTimeMillis();
      p.g(paramString1, "this");
      l -= paramString1.longValue();
      ad.i("MicroMsg.RecordTimeCalculatePlugin", paramString2 + " cost time:" + l);
      AppMethodBeat.o(200886);
      return l;
    }
    AppMethodBeat.o(200886);
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
    AppMethodBeat.i(200890);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(200890);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(200887);
    this.xRC.clear();
    AppMethodBeat.o(200887);
  }
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.e
 * JD-Core Version:    0.7.0.1
 */