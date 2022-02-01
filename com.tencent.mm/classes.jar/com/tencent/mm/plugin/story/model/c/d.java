package com.tencent.mm.plugin.story.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.c;
import com.tencent.mm.protocal.protobuf.fis;
import com.tencent.mm.storage.br;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "username", "", "fromscene", "Lcom/tencent/mm/storage/FROM_SCENE;", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;Ljava/lang/String;Lcom/tencent/mm/storage/FROM_SCENE;)V", "getFromscene", "()Lcom/tencent/mm/storage/FROM_SCENE;", "setFromscene", "(Lcom/tencent/mm/storage/FROM_SCENE;)V", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "setMediaObj", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "isLegal", "", "uniqueValue", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements c
{
  private br QzO;
  fis SlY;
  String username;
  
  public d(fis paramfis, String paramString, br parambr)
  {
    AppMethodBeat.i(118903);
    this.SlY = paramfis;
    this.username = paramString;
    this.QzO = parambr;
    AppMethodBeat.o(118903);
  }
  
  public final String aUt()
  {
    AppMethodBeat.i(118902);
    Object localObject = (CharSequence)this.SlY.aaTl;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = this.SlY.Id + '_' + this.QzO.tag;
      AppMethodBeat.o(118902);
      return localObject;
    }
    localObject = this.SlY.aaTl + '_' + this.QzO.tag;
    AppMethodBeat.o(118902);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.c.d
 * JD-Core Version:    0.7.0.1
 */