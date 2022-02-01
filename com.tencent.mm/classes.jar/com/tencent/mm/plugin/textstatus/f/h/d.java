package com.tencent.mm.plugin.textstatus.f.h;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.textstatus.g.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/upload/UploadPackHelper;", "", "()V", "TAG", "", "THUMB_DEFAULT_SCALE", "", "commit", "", "postInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusPostInfo;", "getSendThumbnailPath", "thumbnailPath", "tips", "plugin-textstatus_release"})
public final class d
{
  public static final d Gaa;
  
  static
  {
    AppMethodBeat.i(216325);
    Gaa = new d();
    AppMethodBeat.o(216325);
  }
  
  public static void b(v paramv)
  {
    AppMethodBeat.i(216324);
    p.h(paramv, "postInfo");
    h.RTc.b((Runnable)new a(paramv), "MicroMsg.TxtStatus.UploadPackHelper");
    AppMethodBeat.o(216324);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(216323);
      Object localObject1 = com.tencent.mm.plugin.textstatus.j.e.Ggj;
      Log.i("MicroMsg.TxtStatus.UploadPackHelper", String.valueOf(com.tencent.mm.plugin.textstatus.j.e.c(this.Gab)));
      Object localObject2;
      if (this.Gab.Gba <= 0L)
      {
        localObject1 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        localObject1 = com.tencent.mm.plugin.auth.a.a.ceA();
        p.g(localObject1, "Account.username()");
        localObject2 = this.Gab.GaU;
        p.g(localObject2, "postInfo.textStatusExtInfo");
        long l = com.tencent.mm.plugin.textstatus.b.f.a((String)localObject1, "", (com.tencent.mm.plugin.textstatus.g.g)localObject2, 3);
        this.Gab.Gba = l;
        if (this.Gab.GaW) {
          this.Gab.Gbb = true;
        }
        localObject1 = c.FZX;
        c.a(this.Gab);
      }
      localObject1 = com.tencent.mm.plugin.textstatus.j.a.GfU;
      localObject1 = com.tencent.mm.plugin.auth.a.a.ceA();
      p.g(localObject1, "Account.username()");
      s.deleteFile(com.tencent.mm.plugin.textstatus.j.a.lf("thumb", (String)localObject1));
      localObject1 = com.tencent.mm.plugin.textstatus.j.a.GfU;
      localObject1 = com.tencent.mm.plugin.auth.a.a.ceA();
      p.g(localObject1, "Account.username()");
      s.deleteFile(com.tencent.mm.plugin.textstatus.j.a.lf("image", (String)localObject1));
      localObject1 = com.tencent.mm.plugin.textstatus.j.a.GfU;
      localObject1 = com.tencent.mm.plugin.auth.a.a.ceA();
      p.g(localObject1, "Account.username()");
      s.deleteFile(com.tencent.mm.plugin.textstatus.j.a.aTo((String)localObject1));
      if (this.Gab.GaW)
      {
        new a(this.Gab).fwb();
        AppMethodBeat.o(216323);
        return;
      }
      localObject1 = this.Gab.GaU;
      int i;
      if ((localObject1 != null) && (((com.tencent.mm.plugin.textstatus.g.g)localObject1).Gat == 1))
      {
        localObject1 = this.Gab.thumbPath;
        localObject2 = com.tencent.mm.plugin.textstatus.j.a.GfU;
        localObject2 = com.tencent.mm.plugin.auth.a.a.ceA();
        p.g(localObject2, "Account.username()");
        s.nw((String)localObject1, com.tencent.mm.plugin.textstatus.j.a.lf("thumb", (String)localObject2));
        localObject1 = this.Gab.GaX;
        localObject2 = com.tencent.mm.plugin.textstatus.j.a.GfU;
        localObject2 = com.tencent.mm.plugin.auth.a.a.ceA();
        p.g(localObject2, "Account.username()");
        s.nw((String)localObject1, com.tencent.mm.plugin.textstatus.j.a.lf("image", (String)localObject2));
        localObject2 = new e(this.Gab);
        localObject3 = new e.b((e)localObject2, System.currentTimeMillis());
        localObject1 = b.FZU;
        localObject1 = ((e)localObject2).FYQ.GaU;
        if (localObject1 == null) {
          break label556;
        }
        i = ((com.tencent.mm.plugin.textstatus.g.g)localObject1).Gat;
        label385:
        localObject1 = ((e)localObject2).FYQ.GaX;
        localObject2 = ((e)localObject2).FYQ.thumbPath;
        localObject3 = (b.a)localObject3;
        p.h(localObject3, "uploadCallback");
        localObject4 = (CharSequence)localObject1;
        if ((localObject4 != null) && (!n.aL((CharSequence)localObject4))) {
          break label561;
        }
        j = 1;
        label441:
        if (j == 0)
        {
          localObject4 = (CharSequence)localObject2;
          if ((localObject4 != null) && (!n.aL((CharSequence)localObject4))) {
            break label566;
          }
        }
      }
      label556:
      label561:
      label566:
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          break label571;
        }
        AppMethodBeat.o(216323);
        return;
        localObject1 = this.Gab.thumbPath;
        localObject2 = com.tencent.mm.plugin.textstatus.j.a.GfU;
        localObject2 = com.tencent.mm.plugin.auth.a.a.ceA();
        p.g(localObject2, "Account.username()");
        s.nw((String)localObject1, com.tencent.mm.plugin.textstatus.j.a.lf("thumb", (String)localObject2));
        localObject1 = this.Gab.GaX;
        localObject2 = com.tencent.mm.plugin.textstatus.j.a.GfU;
        localObject2 = com.tencent.mm.plugin.auth.a.a.ceA();
        p.g(localObject2, "Account.username()");
        s.nw((String)localObject1, com.tencent.mm.plugin.textstatus.j.a.aTo((String)localObject2));
        break;
        i = 1;
        break label385;
        j = 0;
        break label441;
      }
      label571:
      Object localObject3 = new b.b((b.a)localObject3);
      if (i == 2)
      {
        Log.d("MicroMsg.TxtStatus.TextStatusUploader", "isVideo");
        localObject3 = (g.a)localObject3;
        localObject4 = new com.tencent.mm.i.g();
        ((com.tencent.mm.i.g)localObject4).taskName = "task_TextStatusUploader_1";
        ((com.tencent.mm.i.g)localObject4).gqy = ((g.a)localObject3);
        ((com.tencent.mm.i.g)localObject4).field_mediaId = MD5Util.getMD5String((String)localObject1);
        ((com.tencent.mm.i.g)localObject4).field_fullpath = ((String)localObject1);
        ((com.tencent.mm.i.g)localObject4).field_thumbpath = ((String)localObject2);
        ((com.tencent.mm.i.g)localObject4).field_talker = "";
        ((com.tencent.mm.i.g)localObject4).field_needStorage = true;
        ((com.tencent.mm.i.g)localObject4).field_fileType = 20302;
        ((com.tencent.mm.i.g)localObject4).field_appType = 256;
        ((com.tencent.mm.i.g)localObject4).gqP = 8;
        ((com.tencent.mm.i.g)localObject4).field_bzScene = 2;
        ((com.tencent.mm.i.g)localObject4).gqC = 600;
        ((com.tencent.mm.i.g)localObject4).gqD = 1200;
        ((com.tencent.mm.i.g)localObject4).field_priority = com.tencent.mm.i.a.gpM;
        com.tencent.mm.an.f.baQ().f((com.tencent.mm.i.g)localObject4);
        AppMethodBeat.o(216323);
        return;
      }
      Log.d("MicroMsg.TxtStatus.TextStatusUploader", "uploadImage");
      localObject3 = (g.a)localObject3;
      Object localObject4 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject4).taskName = "task_TextStatusUploader_2";
      ((com.tencent.mm.i.g)localObject4).gqy = ((g.a)localObject3);
      ((com.tencent.mm.i.g)localObject4).field_mediaId = MD5Util.getMD5String((String)localObject1);
      ((com.tencent.mm.i.g)localObject4).field_fullpath = ((String)localObject1);
      ((com.tencent.mm.i.g)localObject4).field_thumbpath = ((String)localObject2);
      ((com.tencent.mm.i.g)localObject4).field_talker = "";
      ((com.tencent.mm.i.g)localObject4).field_needStorage = true;
      ((com.tencent.mm.i.g)localObject4).field_fileType = 20304;
      ((com.tencent.mm.i.g)localObject4).field_appType = 256;
      ((com.tencent.mm.i.g)localObject4).field_bzScene = 2;
      ((com.tencent.mm.i.g)localObject4).gqC = 60;
      ((com.tencent.mm.i.g)localObject4).gqD = 300;
      ((com.tencent.mm.i.g)localObject4).field_priority = com.tencent.mm.i.a.gpM;
      com.tencent.mm.an.f.baQ().f((com.tencent.mm.i.g)localObject4);
      AppMethodBeat.o(216323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.h.d
 * JD-Core Version:    0.7.0.1
 */