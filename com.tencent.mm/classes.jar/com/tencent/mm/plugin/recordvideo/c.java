package com.tencent.mm.plugin.recordvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.b.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.c.h;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/RecordConfig;", "", "()V", "TAG", "", "checkProviderValid", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c NDb;
  
  static
  {
    AppMethodBeat.i(279382);
    NDb = new c();
    AppMethodBeat.o(279382);
  }
  
  public static void f(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(279378);
    s.u(paramRecordConfigProvider, "configProvider");
    Object localObject1;
    Object localObject2;
    if (p.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4) }).contains(Integer.valueOf(paramRecordConfigProvider.scene)))
    {
      if (paramRecordConfigProvider.oXZ == null) {
        paramRecordConfigProvider.oXZ = new SightParams(paramRecordConfigProvider.scene, 0).nLH;
      }
      localObject1 = paramRecordConfigProvider.oXZ;
      if (localObject1 != null)
      {
        Log.i("MicroMsg.RecordConfig", "initLogic init SightRecordConfig ");
        localObject2 = h.NHb;
        h.b((VideoTransPara)localObject1, paramRecordConfigProvider.scene);
      }
    }
    if (h.isInit())
    {
      localObject1 = h.NHb;
      localObject1 = Boolean.valueOf(h.gHz());
      localObject2 = a.nul;
      if (((Boolean)localObject1).booleanValue()) {
        break label161;
      }
    }
    label161:
    for (boolean bool = true;; bool = false)
    {
      a.gi(bool);
      paramRecordConfigProvider.NHT = 3;
      AppMethodBeat.o(279378);
      return;
      localObject1 = paramRecordConfigProvider.NHN;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c
 * JD-Core Version:    0.7.0.1
 */