package com.tencent.mm.plugin.story.model.d;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.h.f;
import com.tencent.mm.plugin.story.model.q;
import com.tencent.mm.plugin.story.model.q.a;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.cic;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem$Companion;", "", "()V", "createStoryGalleryItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "extInfo", "Lcom/tencent/mm/plugin/story/storage/StoryExtInfo;", "story", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "storyItemScene", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItemScene;", "createStoryGalleryItemForSns", "plugin-story_release"})
public final class g$a
{
  public static g a(f paramf)
  {
    AppMethodBeat.i(109313);
    a.f.b.j.q(paramf, "extInfo");
    com.tencent.mm.plugin.story.h.j localj = new com.tencent.mm.plugin.story.h.j();
    localj.field_storyID = paramf.field_syncId;
    localj.field_createTime = paramf.field_storyPostTime;
    localj.field_userName = paramf.getUserName();
    Object localObject1 = q.svz;
    localObject1 = q.a.cAY();
    ((cic)localObject1).jJA = paramf.getUserName();
    ((cic)localObject1).CreateTime = paramf.field_storyPostTime;
    Object localObject2 = q.svz;
    localObject2 = new chl();
    ((chl)localObject2).Id = ("empty_" + cb.abq());
    ((chl)localObject2).xrS = paramf.cER();
    ((chl)localObject2).Url = paramf.cEQ();
    if (paramf.field_duration > 0L) {}
    for (float f = (float)(paramf.field_duration / 1000.0D);; f = 0.0F)
    {
      ((chl)localObject2).duration = f;
      ((cic)localObject1).xSK.wOa.add(localObject2);
      localj.c((cic)localObject1);
      paramf = new g(localj, (cic)localObject1);
      AppMethodBeat.o(109313);
      return paramf;
    }
  }
  
  public static g a(com.tencent.mm.plugin.story.h.j paramj, h paramh)
  {
    AppMethodBeat.i(138770);
    a.f.b.j.q(paramj, "story");
    a.f.b.j.q(paramh, "storyItemScene");
    paramj = new g(paramj, paramj.cEY(), paramh);
    AppMethodBeat.o(138770);
    return paramj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.d.g.a
 * JD-Core Version:    0.7.0.1
 */