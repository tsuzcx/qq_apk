package com.tencent.mm.plugin.story.proxy;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.plugin.story.f.k;
import com.tencent.mm.plugin.story.g.g;
import com.tencent.mm.plugin.story.model.j;
import com.tencent.mm.plugin.story.model.j.b;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/proxy/StoryMixHandler$MixTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "editorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "(Lcom/tencent/mm/plugin/story/storage/StoryEditorData;)V", "isCaptureVideo", "", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "startPerformance", "", "call", "", "runMix", "uniqueId", "", "plugin-story_release"})
public final class c$c
  extends com.tencent.mm.loader.g.c
{
  int eez;
  private boolean fbp;
  com.tencent.mm.plugin.story.h.d sDs;
  private chj syC;
  
  public c$c(com.tencent.mm.plugin.story.h.d paramd)
  {
    AppMethodBeat.i(109746);
    this.sDs = paramd;
    AppMethodBeat.o(109746);
  }
  
  public final String Oy()
  {
    AppMethodBeat.i(109745);
    String str = "mixTask_" + this.sDs + ".localId";
    AppMethodBeat.o(109745);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(109744);
    com.tencent.mm.sdk.g.d.ysm.b((Runnable)new a(this), "StoryMixHandler");
    AppMethodBeat.o(109744);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(c.c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(109742);
      Object localObject1 = c.sDq;
      ab.i(c.a.getTAG(), "call reStart background mix " + this.sDt.sDs.systemRowid + " it " + this.sDt.sDs + " mixRetryTime:" + this.sDt.sDs.field_mixRetryTime);
      localObject1 = (a)new chf();
      Object localObject3 = this.sDt.sDs.field_baseItemData;
      try
      {
        ((a)localObject1).parseFrom((byte[])localObject3);
        localObject1 = (chf)localObject1;
        if (localObject1 != null)
        {
          localObject3 = g.sEy;
          g.md(((chf)localObject1).fbp);
        }
        if (this.sDt.sDs.field_mixRetryTime < 3)
        {
          localObject3 = k.sCp;
          k.mD(this.sDt.sDs.systemRowid);
          if (localObject1 != null)
          {
            localObject1 = j.svi;
            localObject1 = j.b.cAG().mQ(this.sDt.sDs.systemRowid);
            if (localObject1 != null) {
              this.sDt.sDs = ((com.tencent.mm.plugin.story.h.d)localObject1);
            }
          }
          c.c.a(this.sDt);
          AppMethodBeat.o(109742);
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        for (;;)
        {
          ab.a("safeParser", "", new Object[] { localException });
          localObject2 = null;
        }
        localObject3 = c.sDq;
        ab.i(c.a.getTAG(), "retry mix third and still failed");
        localObject3 = k.sCp;
        k.mC(this.sDt.sDs.systemRowid);
        if (localObject2 != null)
        {
          localObject3 = g.sEy;
          g.mf(localObject2.fbp);
        }
        this.sDt.a(h.ePw);
        AppMethodBeat.o(109742);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.c.c
 * JD-Core Version:    0.7.0.1
 */