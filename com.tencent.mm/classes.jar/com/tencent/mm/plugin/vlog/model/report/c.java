package com.tencent.mm.plugin.vlog.model.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "editList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "Lkotlin/collections/ArrayList;", "getEditList", "()Ljava/util/ArrayList;", "setEditList", "(Ljava/util/ArrayList;)V", "mediaList", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "getMediaList", "setMediaList", "needStatus", "", "getNeedStatus", "()Z", "setNeedStatus", "(Z)V", "status", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "getStatus", "()Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "setStatus", "(Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;)V", "toJson", "Lorg/json/JSONObject;", "EditItem", "EditTextItem", "EditorStatus", "ImageItem", "MediaItem", "VideoItem", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  c Ucn;
  public boolean Uco;
  public ArrayList<a> editList;
  public ArrayList<e> ofu;
  
  public c()
  {
    AppMethodBeat.i(283717);
    this.ofu = new ArrayList();
    this.editList = new ArrayList();
    this.Ucn = new c();
    this.Uco = true;
    AppMethodBeat.o(283717);
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(283723);
    JSONObject localJSONObject = new JSONObject();
    if (this.Uco) {
      localJSONObject.put("status", this.Ucn.toJson());
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = ((Iterable)this.ofu).iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((e)localIterator.next()).toJson());
    }
    localJSONObject.put("mediaList", localJSONArray);
    int i;
    if (!((Collection)this.editList).isEmpty()) {
      i = 1;
    }
    while (i != 0)
    {
      localJSONArray = new JSONArray();
      localIterator = ((Iterable)this.editList).iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localJSONArray.put(((a)localIterator.next()).toJson());
          continue;
          i = 0;
          break;
        }
      }
      localJSONObject.put("editList", localJSONArray);
    }
    AppMethodBeat.o(283723);
    return localJSONObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "time", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getTime", "()Ljava/util/ArrayList;", "setTime", "(Ljava/util/ArrayList;)V", "type", "", "getType", "()I", "setType", "(I)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static class a
    extends a
  {
    public ArrayList<Long> Ucp;
    public int type;
    
    public a()
    {
      AppMethodBeat.i(283722);
      this.Ucp = new ArrayList();
      AppMethodBeat.o(283722);
    }
    
    public JSONObject toJson()
    {
      AppMethodBeat.i(283728);
      JSONObject localJSONObject = super.toJson();
      localJSONObject.put("type", this.type);
      JSONArray localJSONArray = new JSONArray();
      Object localObject = ((Iterable)this.Ucp).iterator();
      while (((Iterator)localObject).hasNext()) {
        localJSONArray.put(((Number)((Iterator)localObject).next()).longValue());
      }
      localObject = ah.aiuX;
      localJSONObject.put("time", localJSONArray);
      AppMethodBeat.o(283728);
      return localJSONObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditTextItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "()V", "font", "", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends c.a
  {
    private String mAD = "";
    
    public final void setFont(String paramString)
    {
      AppMethodBeat.i(283733);
      s.u(paramString, "<set-?>");
      this.mAD = paramString;
      AppMethodBeat.o(283733);
    }
    
    public final JSONObject toJson()
    {
      AppMethodBeat.i(283741);
      JSONObject localJSONObject = super.toJson();
      if (!Util.isNullOrNil(this.mAD)) {
        localJSONObject.put("font", this.mAD);
      }
      AppMethodBeat.o(283741);
      return localJSONObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "pss", "", "getPss", "()I", "setPss", "(I)V", "thumbCount", "getThumbCount", "setThumbCount", "thumbMem", "getThumbMem", "setThumbMem", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends a
  {
    int Ucq;
    int Ucr;
    int Ucs;
    
    public final JSONObject toJson()
    {
      AppMethodBeat.i(283740);
      JSONObject localJSONObject = super.toJson();
      localJSONObject.put("pss", this.Ucq + 'K');
      localJSONObject.put("thumbCount", this.Ucr);
      localJSONObject.put("thumbMem", Util.getSizeMB(this.Ucs));
      AppMethodBeat.o(283740);
      return localJSONObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$ImageItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "()V", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends c.e
  {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "size", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getSize", "()Ljava/util/ArrayList;", "setSize", "(Ljava/util/ArrayList;)V", "time", "", "getTime", "setTime", "type", "getType", "()I", "setType", "(I)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static class e
    extends a
  {
    public ArrayList<Long> Ucp;
    public ArrayList<Integer> Uct;
    public int type;
    
    public e()
    {
      AppMethodBeat.i(283730);
      this.Uct = new ArrayList();
      this.Ucp = new ArrayList();
      AppMethodBeat.o(283730);
    }
    
    public JSONObject toJson()
    {
      AppMethodBeat.i(283737);
      JSONObject localJSONObject = super.toJson();
      localJSONObject.put("type", this.type);
      JSONArray localJSONArray = new JSONArray();
      Object localObject = ((Iterable)this.Uct).iterator();
      while (((Iterator)localObject).hasNext()) {
        localJSONArray.put(((Number)((Iterator)localObject).next()).intValue());
      }
      localObject = ah.aiuX;
      localJSONObject.put("size", localJSONArray);
      localJSONArray = new JSONArray();
      localObject = ((Iterable)this.Ucp).iterator();
      while (((Iterator)localObject).hasNext()) {
        localJSONArray.put(((Number)((Iterator)localObject).next()).longValue());
      }
      localObject = ah.aiuX;
      localJSONObject.put("time", localJSONArray);
      AppMethodBeat.o(283737);
      return localJSONObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$VideoItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "()V", "audioBitrate", "", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "audioMime", "", "getAudioMime", "()Ljava/lang/String;", "setAudioMime", "(Ljava/lang/String;)V", "audioSampleRate", "getAudioSampleRate", "setAudioSampleRate", "bitrate", "getBitrate", "setBitrate", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "fps", "", "getFps", "()F", "setFps", "(F)V", "playRate", "getPlayRate", "setPlayRate", "videoMime", "getVideoMime", "setVideoMime", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends c.e
  {
    private String Ucu = "";
    private String Ucv = "";
    public int audioBitrate;
    public int audioSampleRate;
    public int bitrate = 1;
    public long duration;
    public float eGw = 1.0F;
    public float sAn = 1.0F;
    
    public final void bfj(String paramString)
    {
      AppMethodBeat.i(283726);
      s.u(paramString, "<set-?>");
      this.Ucu = paramString;
      AppMethodBeat.o(283726);
    }
    
    public final void bfk(String paramString)
    {
      AppMethodBeat.i(283731);
      s.u(paramString, "<set-?>");
      this.Ucv = paramString;
      AppMethodBeat.o(283731);
    }
    
    public final JSONObject toJson()
    {
      AppMethodBeat.i(283739);
      JSONObject localJSONObject = super.toJson();
      if (this.sAn == 1.0F) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          localJSONObject.put("playRate", Float.valueOf(this.sAn));
        }
        localJSONObject.put("duration", this.duration);
        localJSONObject.put("fps", Float.valueOf(this.eGw));
        localJSONObject.put("bitrate", this.bitrate);
        localJSONObject.put("audioSampleRate", this.audioSampleRate);
        localJSONObject.put("audioBitrate", this.audioBitrate);
        localJSONObject.put("videoMime", this.Ucu);
        localJSONObject.put("audioMime", this.Ucv);
        AppMethodBeat.o(283739);
        return localJSONObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.report.c
 * JD-Core Version:    0.7.0.1
 */