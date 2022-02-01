package com.tencent.mm.plugin.story.proxy;

import com.tencent.mm.protocal.protobuf.aes;
import com.tencent.mm.protocal.protobuf.enw;
import com.tencent.mm.protocal.protobuf.fir;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "", "commitStory", "", "taskId", "", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "captureInfo", "Lcom/tencent/mm/protocal/protobuf/CommonCaptureParams;", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "groupList", "", "blackList", "srcMd5List", "videoPath", "mediaDes", "isCaptureVideo", "", "favorite", "get", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "set", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public abstract int commitStory(String paramString1, String paramString2, enw paramenw, aes paramaes, fir paramfir, int paramInt, List<String> paramList1, List<String> paramList2, List<String> paramList3);
  
  public abstract int commitStory(String paramString1, String paramString2, String paramString3, enw paramenw, boolean paramBoolean, fir paramfir, int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2, List<String> paramList3);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.a
 * JD-Core Version:    0.7.0.1
 */