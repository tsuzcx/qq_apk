package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.protocal.protobuf.qc;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.g.b.k;
import d.l;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditCaptionDataManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "callback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "key", "", "ret", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "Lkotlin/collections/ArrayList;", "transition", "", "filePath", "mediaExtractor", "Lcom/tencent/mm/compatible/video/VFSMediaExtractor;", "netScene", "Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/NetSceneGetVideoCaption;", "total", "transResult", "voiceData", "Ljava/nio/ByteBuffer;", "doNetRequest", "data", "Lcom/tencent/mm/protobuf/ByteString;", "seq", "offset", "getTransResult", "loadAudioTrackData", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "release", "saveBuffer2File", "voiceTransLate", "", "Companion", "plugin-vlog_release"})
public final class a
  implements com.tencent.mm.ak.g
{
  public static final a AtX;
  private d AtV;
  private ArrayList<qc> AtW;
  private String filePath;
  c gRF;
  private int hLN;
  private d.g.a.q<? super String, ? super Integer, ? super ArrayList<qc>, y> sMG;
  
  static
  {
    AppMethodBeat.i(207862);
    AtX = new a((byte)0);
    AppMethodBeat.o(207862);
  }
  
  public a()
  {
    AppMethodBeat.i(207861);
    this.AtW = new ArrayList();
    this.filePath = "";
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    k.g(localb, "MMKernel.network()");
    localb.agi().a(3835, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(207861);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(207860);
    if (paramn == null)
    {
      paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.ui.plugin.caption.NetSceneGetVideoCaption");
      AppMethodBeat.o(207860);
      throw paramString;
    }
    if (k.g(((d)paramn).filePath, this.filePath))
    {
      ac.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.AtW = ((d)paramn).Auq;
        ac.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]scene seq:" + ((d)paramn).hTM + " isLastRequest:" + ((d)paramn).Aur + " progress:" + ((d)paramn).getProgress());
        paramString = ((Iterable)this.AtW).iterator();
        paramInt1 = 0;
        Object localObject;
        while (paramString.hasNext())
        {
          localObject = paramString.next();
          if (paramInt1 < 0) {
            j.fOc();
          }
          localObject = (qc)localObject;
          ac.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]result" + paramInt1 + ": start:" + ((qc)localObject).EgL + " end:" + ((qc)localObject).EgM + " text:" + ((qc)localObject).EgK.toString("UTF-8"));
          paramInt1 += 1;
        }
        ac.i("MicroMsg.EditCaptionDataManager", "\n");
        if (((d)paramn).Aur)
        {
          if (((d)paramn).getProgress() >= 100)
          {
            paramString = this.sMG;
            if (paramString != null)
            {
              paramString.d(this.filePath, Integer.valueOf(0), this.AtW);
              AppMethodBeat.o(207860);
              return;
            }
            AppMethodBeat.o(207860);
            return;
          }
          paramString = this.sMG;
          if (paramString != null) {
            paramString.d(this.filePath, Integer.valueOf(0), this.AtW);
          }
          ac.i("MicroMsg.EditCaptionDataManager", "[" + hashCode() + "]repeat query voice data");
          paramString = this.AtV;
          if (paramString == null) {
            k.fOy();
          }
          paramInt1 = paramString.hTM;
          paramInt2 = this.hLN;
          paramString = this.AtV;
          if (paramString != null)
          {
            paramString = paramString.Aus;
            paramn = new d(paramInt1, paramInt2, paramString);
            localObject = new StringBuilder("[").append(hashCode()).append("]do voiceTransLate vid:");
            paramString = paramn.Aus;
            if (paramString == null) {
              break label636;
            }
          }
          label636:
          for (paramString = paramString.toString("UTF-8");; paramString = null)
          {
            ac.i("MicroMsg.EditCaptionDataManager", paramString + " seq:" + paramInt1 + " size:" + null + " offset:0");
            paramString = this.filePath;
            k.h(paramString, "<set-?>");
            paramn.filePath = paramString;
            this.AtV = paramn;
            paramString = com.tencent.mm.kernel.g.agQ();
            k.g(paramString, "MMKernel.network()");
            paramString.agi().b((n)this.AtV);
            AppMethodBeat.o(207860);
            return;
            paramString = null;
            break;
          }
        }
      }
      else
      {
        paramString = this.sMG;
        if (paramString != null)
        {
          paramString.d(this.filePath, Integer.valueOf(-1), null);
          AppMethodBeat.o(207860);
          return;
        }
      }
    }
    AppMethodBeat.o(207860);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditCaptionDataManager$Companion;", "", "()V", "REQUEST_VOICE_SIZE", "", "RESULT_ERROR", "RESULT_LOAD_MORE", "RESULT_OK", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.caption.a
 * JD-Core Version:    0.7.0.1
 */