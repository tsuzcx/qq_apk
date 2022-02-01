package com.tencent.mm.plugin.textstatus.f.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.plugin.textstatus.g.g;
import com.tencent.mm.plugin.textstatus.g.v;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/model/upload/UploadTask$doUpload$uploadCallback$1", "Lcom/tencent/mm/plugin/textstatus/model/upload/TextStatusUploader$TextStatusUploadCallback;", "onUploadEnd", "", "errorCode", "", "isOk", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-textstatus_release"})
public final class e$b
  implements b.a
{
  e$b(long paramLong) {}
  
  public final void a(int paramInt, boolean paramBoolean, d paramd)
  {
    AppMethodBeat.i(216326);
    StringBuilder localStringBuilder = new StringBuilder("onUploadEnd cost").append(System.currentTimeMillis() - this.qVz).append(".errorCode").append(paramInt).append(",isOk").append(paramBoolean).append(",mediaType");
    Object localObject = e.a(this.Gad).GaU;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((g)localObject).Gat);
      Log.i("MicroMsg.TxtStatus.UploadTask", localObject + ",sceneResult" + paramd);
      if ((paramBoolean) && (paramd != null))
      {
        localObject = (CharSequence)paramd.field_fileUrl;
        if ((localObject != null) && (!n.aL((CharSequence)localObject))) {
          break label278;
        }
        paramInt = 1;
        label133:
        if (paramInt == 0)
        {
          localObject = (CharSequence)paramd.field_thumbUrl;
          if ((localObject != null) && (!n.aL((CharSequence)localObject))) {
            break label283;
          }
        }
      }
    }
    label278:
    label283:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label288;
      }
      paramd = c.FZX;
      paramd = e.a(this.Gad);
      p.h(paramd, "postInfo");
      Log.i("MicroMsg.TxtStatus.UploadManager", "makeCdnFail " + paramd.Gba + ' ' + paramd.GaY + ' ' + paramd.GaZ);
      paramd.GaY += 1;
      c.a(paramd);
      localObject = com.tencent.mm.plugin.textstatus.k.a.UsD;
      com.tencent.mm.plugin.textstatus.k.a.c(paramd.Usb, Long.valueOf(2L));
      c.dYH();
      AppMethodBeat.o(216326);
      return;
      localObject = null;
      break;
      paramInt = 0;
      break label133;
    }
    label288:
    e.a(this.Gad).GaU.Gav = paramd.field_fileUrl;
    e.a(this.Gad).GaU.Gax = paramd.field_thumbUrl;
    new a(e.a(this.Gad)).fwb();
    AppMethodBeat.o(216326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.h.e.b
 * JD-Core Version:    0.7.0.1
 */