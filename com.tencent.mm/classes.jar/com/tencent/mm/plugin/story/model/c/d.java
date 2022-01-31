package com.tencent.mm.plugin.story.model.c;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.h.a.c;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.storage.az;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "username", "", "fromscene", "Lcom/tencent/mm/storage/FROM_SCENE;", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;Ljava/lang/String;Lcom/tencent/mm/storage/FROM_SCENE;)V", "getFromscene", "()Lcom/tencent/mm/storage/FROM_SCENE;", "setFromscene", "(Lcom/tencent/mm/storage/FROM_SCENE;)V", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "setMediaObj", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "uniqueValue", "plugin-story_release"})
public final class d
  implements c
{
  private az rjD;
  chl syh;
  String username;
  
  public d(chl paramchl, String paramString, az paramaz)
  {
    AppMethodBeat.i(109300);
    this.syh = paramchl;
    this.username = paramString;
    this.rjD = paramaz;
    AppMethodBeat.o(109300);
  }
  
  public final String Ug()
  {
    AppMethodBeat.i(109299);
    Object localObject = (CharSequence)this.syh.xrS;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = this.syh.Id + '_' + this.rjD.tag;
      AppMethodBeat.o(109299);
      return localObject;
    }
    localObject = this.syh.xrS + '_' + this.rjD.tag;
    AppMethodBeat.o(109299);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.c.d
 * JD-Core Version:    0.7.0.1
 */