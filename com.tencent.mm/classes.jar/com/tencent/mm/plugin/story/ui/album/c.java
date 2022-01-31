package com.tencent.mm.plugin.story.ui.album;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.cic;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "", "label", "", "storyInfos", "", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getLabel", "()Ljava/lang/String;", "getStoryInfos", "()Ljava/util/List;", "toString", "plugin-story_release"})
public final class c
{
  final String label;
  final List<h> sJd;
  
  public c()
  {
    this(null, null, 3);
  }
  
  public c(String paramString, List<h> paramList)
  {
    AppMethodBeat.i(110159);
    this.label = paramString;
    this.sJd = paramList;
    AppMethodBeat.o(110159);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(110158);
    StringBuilder localStringBuilder1 = new StringBuilder();
    Iterator localIterator = ((Iterable)this.sJd).iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (h)localIterator.next();
      if (((h)localObject2).szQ.cEY().xSK.wOa.size() > 0)
      {
        localObject1 = (chl)((h)localObject2).szQ.cEY().xSK.wOa.get(0);
        label88:
        StringBuilder localStringBuilder2 = new StringBuilder("\t[date=").append(((h)localObject2).field_date).append(" localId=").append((int)((h)localObject2).szQ.systemRowid).append(", storyId=").append(((h)localObject2).szQ.field_storyID).append(", thumb=");
        if (localObject1 == null) {
          break label198;
        }
        localObject2 = ((chl)localObject1).xrS;
        label151:
        localObject2 = localStringBuilder2.append((String)localObject2).append(", video=");
        if (localObject1 == null) {
          break label203;
        }
      }
      label198:
      label203:
      for (localObject1 = ((chl)localObject1).Url;; localObject1 = null)
      {
        localStringBuilder1.append((String)localObject1 + "]\n");
        break;
        localObject1 = null;
        break label88;
        localObject2 = null;
        break label151;
      }
    }
    Object localObject1 = "[" + this.label + "] \n " + localStringBuilder1;
    AppMethodBeat.o(110158);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.c
 * JD-Core Version:    0.7.0.1
 */