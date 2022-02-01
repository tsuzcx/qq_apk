package com.tencent.mm.plugin.story.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.h.a.c;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.storage.bk;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "username", "", "fromscene", "Lcom/tencent/mm/storage/FROM_SCENE;", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;Ljava/lang/String;Lcom/tencent/mm/storage/FROM_SCENE;)V", "getFromscene", "()Lcom/tencent/mm/storage/FROM_SCENE;", "setFromscene", "(Lcom/tencent/mm/storage/FROM_SCENE;)V", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "setMediaObj", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "isLegal", "", "uniqueValue", "plugin-story_release"})
public final class d
  implements c
{
  dkg BdM;
  String username;
  private bk zFp;
  
  public d(dkg paramdkg, String paramString, bk parambk)
  {
    AppMethodBeat.i(118903);
    this.BdM = paramdkg;
    this.username = paramString;
    this.zFp = parambk;
    AppMethodBeat.o(118903);
  }
  
  public final String aeM()
  {
    AppMethodBeat.i(118902);
    Object localObject = (CharSequence)this.BdM.Hmj;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = this.BdM.Id + '_' + this.zFp.tag;
      AppMethodBeat.o(118902);
      return localObject;
    }
    localObject = this.BdM.Hmj + '_' + this.zFp.tag;
    AppMethodBeat.o(118902);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c.d
 * JD-Core Version:    0.7.0.1
 */