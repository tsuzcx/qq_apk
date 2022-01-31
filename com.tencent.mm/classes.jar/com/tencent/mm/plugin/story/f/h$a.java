package com.tencent.mm.plugin.story.f;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.d.g;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/presenter/MultiUserGalleryPresenter$UserData;", "", "username", "", "state", "", "items", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;ILjava/util/ArrayList;)V", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "getState", "()I", "setState", "(I)V", "getUsername", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-story_release"})
public final class h$a
{
  ArrayList<g> cBy;
  int state;
  final String username;
  
  public h$a(String paramString, ArrayList<g> paramArrayList)
  {
    AppMethodBeat.i(109589);
    this.username = paramString;
    this.state = 0;
    this.cBy = paramArrayList;
    AppMethodBeat.o(109589);
  }
  
  public final void V(ArrayList<g> paramArrayList)
  {
    AppMethodBeat.i(109588);
    j.q(paramArrayList, "<set-?>");
    this.cBy = paramArrayList;
    AppMethodBeat.o(109588);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(109592);
    if (this != paramObject)
    {
      if (!(paramObject instanceof a)) {
        break label79;
      }
      paramObject = (a)paramObject;
      if (!j.e(this.username, paramObject.username)) {
        break label79;
      }
      if (this.state != paramObject.state) {
        break label74;
      }
    }
    label74:
    for (int i = 1; (i != 0) && (j.e(this.cBy, paramObject.cBy)); i = 0)
    {
      AppMethodBeat.o(109592);
      return true;
    }
    label79:
    AppMethodBeat.o(109592);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(109591);
    Object localObject = this.username;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      int k = this.state;
      localObject = this.cBy;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(109591);
      return (i * 31 + k) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(109590);
    String str = "UserData(username=" + this.username + ", state=" + this.state + ", items=" + this.cBy + ")";
    AppMethodBeat.o(109590);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.h.a
 * JD-Core Version:    0.7.0.1
 */