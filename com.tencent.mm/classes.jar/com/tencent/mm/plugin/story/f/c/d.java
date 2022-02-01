package com.tencent.mm.plugin.story.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.h.a.c;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.storage.bj;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "username", "", "fromscene", "Lcom/tencent/mm/storage/FROM_SCENE;", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;Ljava/lang/String;Lcom/tencent/mm/storage/FROM_SCENE;)V", "getFromscene", "()Lcom/tencent/mm/storage/FROM_SCENE;", "setFromscene", "(Lcom/tencent/mm/storage/FROM_SCENE;)V", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "setMediaObj", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "isLegal", "", "uniqueValue", "plugin-story_release"})
public final class d
  implements c
{
  djl AMk;
  String username;
  private bj zoa;
  
  public d(djl paramdjl, String paramString, bj parambj)
  {
    AppMethodBeat.i(118903);
    this.AMk = paramdjl;
    this.username = paramString;
    this.zoa = parambj;
    AppMethodBeat.o(118903);
  }
  
  public final String aeA()
  {
    AppMethodBeat.i(118902);
    Object localObject = (CharSequence)this.AMk.GSI;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = this.AMk.Id + '_' + this.zoa.tag;
      AppMethodBeat.o(118902);
      return localObject;
    }
    localObject = this.AMk.GSI + '_' + this.zoa.tag;
    AppMethodBeat.o(118902);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c.d
 * JD-Core Version:    0.7.0.1
 */