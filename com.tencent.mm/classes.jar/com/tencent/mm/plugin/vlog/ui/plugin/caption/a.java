package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.protocal.protobuf.dxl;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditCaptionDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "key", "", "ret", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "transition", "", "filePath", "mediaExtractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "netScene", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", "total", "transResult", "voiceData", "Ljava/nio/ByteBuffer;", "doNetRequest", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "offset", "getTransResult", "loadAudioTrackData", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveBuffer2File", "voiceTransLate", "", "Companion", "plugin-vlog_release"})
public final class a
  implements com.tencent.mm.al.g
{
  public static final a LuE;
  private d LuC;
  private ArrayList<dxl> LuD;
  private String filePath;
  c gqX;
  private int hlk;
  private d.g.a.q<? super String, ? super Integer, ? super ArrayList<dxl>, y> rDO;
  
  static
  {
    AppMethodBeat.i(201177);
    LuE = new a((byte)0);
    AppMethodBeat.o(201177);
  }
  
  public a()
  {
    AppMethodBeat.i(201176);
    this.LuD = new ArrayList();
    this.filePath = "";
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().a(3835, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(201176);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(201175);
    if (paramn == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.NetSceneGetVideoCaption");
      AppMethodBeat.o(201175);
      throw paramString;
    }
    if (k.g(((d)paramn).filePath, this.filePath))
    {
      ad.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.LuD = ((d)paramn).LuW;
        ad.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]scene seq:" + ((d)paramn).htk + " isLastRequest:" + ((d)paramn).LuX + " progress:" + ((d)paramn).getProgress());
        paramString = ((Iterable)this.LuD).iterator();
        paramInt1 = 0;
        Object localObject;
        while (paramString.hasNext())
        {
          localObject = paramString.next();
          if (paramInt1 < 0) {
            j.fvx();
          }
          localObject = (dxl)localObject;
          ad.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]result" + paramInt1 + ": start:" + ((dxl)localObject).LwH + " end:" + ((dxl)localObject).LwI + " text:" + ((dxl)localObject).LwG.toString("UTF-8"));
          paramInt1 += 1;
        }
        ad.i("MicroMsg.EditCaptionDataManager", "\n");
        if (((d)paramn).LuX)
        {
          if (((d)paramn).getProgress() >= 100)
          {
            paramString = this.rDO;
            if (paramString != null)
            {
              paramString.d(this.filePath, Integer.valueOf(0), this.LuD);
              AppMethodBeat.o(201175);
              return;
            }
            AppMethodBeat.o(201175);
            return;
          }
          paramString = this.rDO;
          if (paramString != null) {
            paramString.d(this.filePath, Integer.valueOf(0), this.LuD);
          }
          ad.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]repeat query voice data");
          paramString = this.LuC;
          if (paramString == null) {
            k.fvU();
          }
          paramInt1 = paramString.htk;
          paramInt2 = this.hlk;
          paramString = this.LuC;
          if (paramString != null)
          {
            paramString = paramString.LuY;
            paramn = new d(paramInt1, paramInt2, paramString);
            localObject = new StringBuilder("[").append(hashCode()).append("]do voiceTransLate vid:");
            paramString = paramn.LuY;
            if (paramString == null) {
              break label636;
            }
          }
          label636:
          for (paramString = paramString.toString("UTF-8");; paramString = null)
          {
            ad.i("MicroMsg.EditCaptionDataManager", paramString + " seq:" + paramInt1 + " size:" + null + " offset:0");
            paramString = this.filePath;
            k.h(paramString, "<set-?>");
            paramn.filePath = paramString;
            this.LuC = paramn;
            paramString = com.tencent.mm.kernel.g.afA();
            k.g(paramString, "MMKernel.network()");
            paramString.aeS().b((n)this.LuC);
            AppMethodBeat.o(201175);
            return;
            paramString = null;
            break;
          }
        }
      }
      else
      {
        paramString = this.rDO;
        if (paramString != null)
        {
          paramString.d(this.filePath, Integer.valueOf(-1), null);
          AppMethodBeat.o(201175);
          return;
        }
      }
    }
    AppMethodBeat.o(201175);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditCaptionDataManager$Companion;", "", "()V", "REQUEST_VOICE_SIZE", "", "RESULT_ERROR", "RESULT_LOAD_MORE", "RESULT_OK", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.a
 * JD-Core Version:    0.7.0.1
 */