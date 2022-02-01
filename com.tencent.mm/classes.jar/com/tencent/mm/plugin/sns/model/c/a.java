package com.tencent.mm.plugin.sns.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.cover.c.b;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.bg;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/model/upload/SnsCoverUploadHelper;", "", "()V", "TAG", "", "postFinderWithThumb", "", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "path", "uploadFinderVideoCover", "userName", "uploadSnsImageCover", "source", "thumb", "uploadSnsVideoCover", "video", "imagePath", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a QAM;
  
  static
  {
    AppMethodBeat.i(309496);
    QAM = new a();
    AppMethodBeat.o(309496);
  }
  
  private static final void a(String paramString1, String paramString2, FinderObject paramFinderObject, String paramString3, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(309491);
    s.u(paramString2, "$userName");
    s.u(paramFinderObject, "$finderObject");
    s.u(paramString3, "$thumbPath");
    if (paramBoolean)
    {
      paramString3 = com.tencent.mm.plugin.sns.cover.b.a.QkS;
      paramString3 = com.tencent.mm.plugin.sns.cover.b.a.heu();
      paramString3 = BitmapUtil.decodeFileWithSample(paramString1, paramString3.width, paramString3.height, true);
      paramArrayOfObject = com.tencent.mm.plugin.sns.cover.edit.b.a.QlA;
      s.s(paramString3, "bitmap");
      paramString3 = com.tencent.mm.plugin.sns.cover.edit.b.a.aJ(paramString3);
      paramArrayOfObject = al.hgG();
      s.s(paramString1, "localPath");
      paramArrayOfObject.h(paramString2, -1L, paramString1);
      paramString1 = new bg(7);
      if (y.ZC(paramString3)) {
        paramString1.mo(paramString3, "");
      }
      paramString2 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).getFinderShareObject(paramFinderObject, true);
      if (paramString2 != null)
      {
        paramFinderObject = new e();
        paramFinderObject.oUc = paramString2;
        paramString1.a(paramFinderObject);
        paramString1.akN(1);
        int i = paramString1.FW();
        j.QFS.QGM = i;
        paramString1 = b.Qmn;
        b.akk(i);
      }
      AppMethodBeat.o(309491);
      return;
    }
    Log.e("MicroMsg.SnsCoverUploadHelper", s.X("downloadImage error:", paramString3));
    AppMethodBeat.o(309491);
  }
  
  private static final void b(FinderObject paramFinderObject, String paramString)
  {
    AppMethodBeat.i(309494);
    s.u(paramFinderObject, "$finderObject");
    s.u(paramString, "$userName");
    Object localObject = paramFinderObject.objectDesc;
    if (localObject != null)
    {
      localObject = ((FinderObjectDesc)localObject).media;
      if (localObject != null)
      {
        localObject = (FinderMedia)((LinkedList)localObject).getFirst();
        if (localObject != null)
        {
          localObject = s.X(((FinderMedia)localObject).thumbUrl, ((FinderMedia)localObject).thumb_url_token);
          String str = as.aYD(paramString);
          y.deleteFile(str);
          com.tencent.mm.modelimage.loader.a locala = com.tencent.mm.modelimage.r.bKe();
          c.a locala1 = new c.a();
          locala1.fullPath = str;
          locala1.oKp = true;
          locala.a((String)localObject, locala1.bKx(), new a..ExternalSyntheticLambda0(str, paramString, paramFinderObject, (String)localObject));
        }
      }
    }
    AppMethodBeat.o(309494);
  }
  
  public static void b(String paramString, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(309489);
    s.u(paramString, "userName");
    s.u(paramFinderObject, "finderObject");
    com.tencent.threadpool.h.ahAA.bo(new a..ExternalSyntheticLambda1(paramFinderObject, paramString));
    AppMethodBeat.o(309489);
  }
  
  public static void ba(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(309487);
    bg localbg = new bg(7);
    if (y.ZC(paramString3)) {
      localbg.mo(paramString3, "");
    }
    if (y.ZC(paramString1)) {
      localbg.K(paramString1, paramString2, "", y.bub(paramString1));
    }
    localbg.akN(1);
    int i = localbg.FW();
    j.QFS.QGM = i;
    paramString1 = b.Qmn;
    b.akk(i);
    AppMethodBeat.o(309487);
  }
  
  public static void mq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(309486);
    Object localObject = new bg(7);
    if (y.ZC(paramString2)) {
      ((bg)localObject).mo(paramString2, "");
    }
    if (y.ZC(paramString1)) {
      ((bg)localObject).mo(paramString1, "");
    }
    ((bg)localObject).akN(1);
    int i = ((bg)localObject).FW();
    j.QFS.QGM = i;
    localObject = b.Qmn;
    b.akk(i);
    Log.i("MicroMsg.SnsCoverUploadHelper", "uploadSnsImageCover source:" + paramString1 + "  thumb:" + paramString2);
    AppMethodBeat.o(309486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.c.a
 * JD-Core Version:    0.7.0.1
 */