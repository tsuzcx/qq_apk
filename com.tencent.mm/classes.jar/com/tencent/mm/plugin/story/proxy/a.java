package com.tencent.mm.plugin.story.proxy;

import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.dlg;
import com.tencent.mm.protocal.protobuf.eds;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/proxy/IProxyAction;", "", "commitStory", "", "taskId", "", "thumbPath", "location", "Lcom/tencent/mm/protocal/protobuf/RecordLocationInfo;", "captureInfo", "Lcom/tencent/mm/protocal/protobuf/CommonCaptureParams;", "editorInfo", "Lcom/tencent/mm/protocal/protobuf/StoryMediaEditorInfo;", "scope", "groupList", "", "blackList", "srcMd5List", "videoPath", "mediaDes", "isCaptureVideo", "", "favorite", "get", "key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getAccPath", "getVideoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "set", "", "plugin-story_release"})
public abstract interface a
{
  public abstract int commitStory(String paramString1, String paramString2, dlg paramdlg, acg paramacg, eds parameds, int paramInt, List<String> paramList1, List<String> paramList2, List<String> paramList3);
  
  public abstract int commitStory(String paramString1, String paramString2, String paramString3, dlg paramdlg, boolean paramBoolean, eds parameds, int paramInt1, int paramInt2, List<String> paramList1, List<String> paramList2, List<String> paramList3);
  
  @l(hxD={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.a
 * JD-Core Version:    0.7.0.1
 */