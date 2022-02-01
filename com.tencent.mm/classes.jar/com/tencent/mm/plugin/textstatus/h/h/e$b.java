package com.tencent.mm.plugin.textstatus.h.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.plugin.textstatus.i.b;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.bg;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/model/upload/UploadTask$doUpload$uploadCallback$1", "Lcom/tencent/mm/plugin/textstatus/model/upload/TextStatusUploader$TextStatusUploadCallback;", "onUploadEnd", "", "errorCode", "", "isOk", "", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$b
  implements b.a
{
  e$b(long paramLong, e parame) {}
  
  public final void a(int paramInt, boolean paramBoolean, d paramd)
  {
    AppMethodBeat.i(290629);
    StringBuilder localStringBuilder = new StringBuilder("onUploadEnd cost").append(System.currentTimeMillis() - this.Uj).append(".errorCode").append(paramInt).append(",isOk").append(paramBoolean).append(",mediaType");
    Object localObject = e.a(this.Tof).Tqi;
    if (localObject == null)
    {
      localObject = null;
      Log.i("MicroMsg.TextStatus.UploadTask", localObject + ",sceneResult" + paramd);
      if ((paramBoolean) && (paramd != null))
      {
        localObject = (CharSequence)paramd.field_fileUrl;
        if ((localObject != null) && (!n.bp((CharSequence)localObject))) {
          break label278;
        }
        paramInt = 1;
        label126:
        if (paramInt == 0)
        {
          localObject = (CharSequence)paramd.field_thumbUrl;
          if ((localObject != null) && (!n.bp((CharSequence)localObject))) {
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
      paramd = c.Tob;
      paramd = e.a(this.Tof);
      s.u(paramd, "postInfo");
      Log.i("MicroMsg.TextStatus.UploadManager", "makeCdnFail " + paramd.Tqo + ' ' + paramd.Tqm + ' ' + paramd.Tqn);
      paramd.Tqm += 1;
      c.a(paramd);
      localObject = b.Trt;
      b.d(paramd.Tqq, Long.valueOf(2L));
      c.retry();
      AppMethodBeat.o(290629);
      return;
      localObject = Integer.valueOf(((TextStatusExtInfo)localObject).mediaType);
      break;
      paramInt = 0;
      break label126;
    }
    label288:
    e.a(this.Tof).Tqi.mediaUrl = paramd.field_fileUrl;
    e.a(this.Tof).Tqi.mediaThumbUrl = paramd.field_thumbUrl;
    new a(e.a(this.Tof)).hHS();
    AppMethodBeat.o(290629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.h.e.b
 * JD-Core Version:    0.7.0.1
 */