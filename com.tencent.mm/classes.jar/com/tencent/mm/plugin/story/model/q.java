package com.tencent.mm.plugin.story.model;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper;", "", "()V", "Companion", "ContentObjTAG", "LocationTAG", "MediaObjTAG", "MediaSizeTAG", "TimelineObjectTAG", "plugin-story_release"})
public final class q
{
  private static final String TAG = "MicroMsg.StoryTimelineHelper";
  public static final q.a svz;
  
  static
  {
    AppMethodBeat.i(109153);
    svz = new q.a((byte)0);
    TAG = "MicroMsg.StoryTimelineHelper";
    AppMethodBeat.o(109153);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryTimelineHelper$TimelineObjectTAG;", "", "()V", "TAG_CONTENTDESC", "", "getTAG_CONTENTDESC", "()Ljava/lang/String;", "TAG_CONTENTOBJ", "getTAG_CONTENTOBJ", "TAG_CREATETIME", "getTAG_CREATETIME", "TAG_ID", "getTAG_ID", "TAG_LOCATION", "getTAG_LOCATION", "TAG_SCOPE", "getTAG_SCOPE", "TAG_USERNAME", "getTAG_USERNAME", "plugin-story_release"})
  public static final class d
  {
    private static final String svT = ".StoryObject.id";
    private static final String svU = ".StoryObject.username";
    private static final String svV = ".StoryObject.createTime";
    private static final String svW = ".StoryObject.contentDesc";
    private static final String svX = ".StoryObject.location";
    private static final String svY = ".StoryObject.ContentObject";
    private static final String svZ = ".StoryObject.scope";
    public static final d swa;
    
    static
    {
      AppMethodBeat.i(109152);
      swa = new d();
      svT = ".StoryObject.id";
      svU = ".StoryObject.username";
      svV = ".StoryObject.createTime";
      svW = ".StoryObject.contentDesc";
      svX = ".StoryObject.location";
      svY = ".StoryObject.ContentObject";
      svZ = ".StoryObject.scope";
      AppMethodBeat.o(109152);
    }
    
    public static String cBm()
    {
      return svT;
    }
    
    public static String cBn()
    {
      return svU;
    }
    
    public static String cBo()
    {
      return svV;
    }
    
    public static String cBp()
    {
      return svY;
    }
    
    public static String cBq()
    {
      return svZ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.q
 * JD-Core Version:    0.7.0.1
 */