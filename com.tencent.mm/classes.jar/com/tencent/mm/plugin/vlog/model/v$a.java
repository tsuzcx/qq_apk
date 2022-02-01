package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.protocal.protobuf.dqm;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/VLogDataManager$Companion;", "", "()V", "KEY_VLOG_CONF", "", "TAG", "renderScript", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "script", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "plugin-vlog_release"})
public final class v$a
{
  public static List<i> a(dqm paramdqm)
  {
    AppMethodBeat.i(207622);
    k.h(paramdqm, "script");
    paramdqm = paramdqm.AoH;
    k.g(paramdqm, "script.materials");
    paramdqm = (Iterable)paramdqm;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramdqm.iterator();
    bts localbts;
    long l;
    label139:
    Object localObject;
    if (localIterator.hasNext())
    {
      localbts = (bts)localIterator.next();
      l = localbts.cZM;
      if (l == 2L)
      {
        paramdqm = localbts.path;
        k.g(paramdqm, "materialResp.path");
        paramdqm = (i)new z(paramdqm, localbts.FiW, localbts.FiX, (float)localbts.FiY, localbts.begin_time, localbts.begin_time + localbts.duration);
        if (paramdqm == null) {
          break label311;
        }
        if (localbts.FiU != 3L) {
          break label279;
        }
        localObject = m.AnF;
        label159:
        paramdqm.a((m)localObject);
        if (localbts.Fjb != null) {
          break label286;
        }
      }
    }
    label179:
    label311:
    label314:
    label329:
    for (;;)
    {
      localObject = q.AnO;
      dqm localdqm = paramdqm;
      localdqm.a((q)localObject);
      paramdqm.Anb = ((List)localbts.FiZ);
      paramdqm.Anc = ((List)localbts.Fja);
      for (;;)
      {
        if (paramdqm == null) {
          break label314;
        }
        localCollection.add(paramdqm);
        break;
        if (l == 1L)
        {
          paramdqm = localbts.path;
          k.g(paramdqm, "materialResp.path");
          paramdqm = (i)new g(paramdqm, localbts.begin_time, localbts.begin_time + localbts.duration);
          break label139;
        }
        paramdqm = null;
        break label139;
        localObject = m.AnE;
        break label159;
        if (localbts.Fjb.FiS != 2L) {
          break label329;
        }
        localObject = q.AnP;
        localdqm = paramdqm;
        break label179;
        paramdqm = null;
      }
      break;
      paramdqm = (List)localCollection;
      AppMethodBeat.o(207622);
      return paramdqm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.v.a
 * JD-Core Version:    0.7.0.1
 */