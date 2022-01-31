package com.tencent.mm.plugin.story.proxy;

import a.l;
import com.tencent.mm.plugin.story.h.d;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.chk;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "", "commitStory", "", "storyEditorData", "Lcom/tencent/mm/plugin/story/storage/StoryEditorData;", "thumbPath", "", "location", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "isCaptureVideo", "", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "isImageVideo", "scope", "favorite", "videoPath", "mediaDes", "get", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getRecommendMusic", "", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "callback", "Lkotlin/Function4;", "Lcom/tencent/mm/protocal/protobuf/GetRecommendedMusicResponse;", "getRecommendMusicCallback", "errType", "errCode", "errMsg", "respBytes", "", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "set", "plugin-story_release"})
public abstract interface a
{
  public abstract int commitStory(d paramd, String paramString, chj paramchj, boolean paramBoolean1, chk paramchk, boolean paramBoolean2, int paramInt1, int paramInt2);
  
  public abstract int commitStory(String paramString1, String paramString2, String paramString3, chj paramchj, boolean paramBoolean, chk paramchk, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.a
 * JD-Core Version:    0.7.0.1
 */