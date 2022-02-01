package com.tencent.mm.plugin.story.f.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.h.a.c;
import com.tencent.mm.protocal.protobuf.edt;
import com.tencent.mm.storage.bp;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/download/StoryImage;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "username", "", "fromscene", "Lcom/tencent/mm/storage/FROM_SCENE;", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;Ljava/lang/String;Lcom/tencent/mm/storage/FROM_SCENE;)V", "getFromscene", "()Lcom/tencent/mm/storage/FROM_SCENE;", "setFromscene", "(Lcom/tencent/mm/storage/FROM_SCENE;)V", "getMediaObj", "()Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;", "setMediaObj", "(Lcom/tencent/mm/protocal/protobuf/StoryMediaObj;)V", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "isLegal", "", "uniqueValue", "plugin-story_release"})
public final class d
  implements c
{
  private bp DPp;
  edt FoD;
  String username;
  
  public d(edt paramedt, String paramString, bp parambp)
  {
    AppMethodBeat.i(118903);
    this.FoD = paramedt;
    this.username = paramString;
    this.DPp = parambp;
    AppMethodBeat.o(118903);
  }
  
  public final String auA()
  {
    AppMethodBeat.i(118902);
    Object localObject = (CharSequence)this.FoD.Msz;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = this.FoD.Id + '_' + this.DPp.tag;
      AppMethodBeat.o(118902);
      return localObject;
    }
    localObject = this.FoD.Msz + '_' + this.DPp.tag;
    AppMethodBeat.o(118902);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.c.d
 * JD-Core Version:    0.7.0.1
 */