package com.tencent.mm.plugin.story.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.h.a.c;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.storage.bf;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "username", "", "fromscene", "Lcom/tencent/mm/storage/FROM_SCENE;", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;Ljava/lang/String;Lcom/tencent/mm/storage/FROM_SCENE;)V", "getFromscene", "()Lcom/tencent/mm/storage/FROM_SCENE;", "setFromscene", "(Lcom/tencent/mm/storage/FROM_SCENE;)V", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "setMediaObj", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "isLegal", "", "uniqueValue", "plugin-story_release"})
public final class d
  implements c
{
  String username;
  private bf xYb;
  ddy zup;
  
  public d(ddy paramddy, String paramString, bf parambf)
  {
    AppMethodBeat.i(118903);
    this.zup = paramddy;
    this.username = paramString;
    this.xYb = parambf;
    AppMethodBeat.o(118903);
  }
  
  public final String abW()
  {
    AppMethodBeat.i(118902);
    Object localObject = (CharSequence)this.zup.Fjh;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = this.zup.Id + '_' + this.xYb.tag;
      AppMethodBeat.o(118902);
      return localObject;
    }
    localObject = this.zup.Fjh + '_' + this.xYb.tag;
    AppMethodBeat.o(118902);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c.d
 * JD-Core Version:    0.7.0.1
 */