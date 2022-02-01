package com.tencent.mm.plugin.vlog.model.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sticker.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "editList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "Lkotlin/collections/ArrayList;", "getEditList", "()Ljava/util/ArrayList;", "setEditList", "(Ljava/util/ArrayList;)V", "mediaList", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "getMediaList", "setMediaList", "needStatus", "", "getNeedStatus", "()Z", "setNeedStatus", "(Z)V", "status", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "getStatus", "()Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "setStatus", "(Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;)V", "toJson", "Lorg/json/JSONObject;", "EditItem", "EditTextItem", "EditorStatus", "ImageItem", "MediaItem", "VideoItem", "plugin-vlog_release"})
public final class c
  extends a
{
  c NoL;
  public boolean NoM;
  public ArrayList<a> editList;
  public ArrayList<e> xoX;
  
  public c()
  {
    AppMethodBeat.i(238551);
    this.xoX = new ArrayList();
    this.editList = new ArrayList();
    this.NoL = new c();
    this.NoM = true;
    AppMethodBeat.o(238551);
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(238548);
    JSONObject localJSONObject = new JSONObject();
    if (this.NoM) {
      localJSONObject.put("status", this.NoL.toJson());
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = ((Iterable)this.xoX).iterator();
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
    AppMethodBeat.o(238548);
    return localJSONObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "time", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getTime", "()Ljava/util/ArrayList;", "setTime", "(Ljava/util/ArrayList;)V", "type", "", "getType", "()I", "setType", "(I)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static class a
    extends a
  {
    public ArrayList<Long> NoN;
    public int type;
    
    public a()
    {
      AppMethodBeat.i(250504);
      this.NoN = new ArrayList();
      AppMethodBeat.o(250504);
    }
    
    public JSONObject toJson()
    {
      AppMethodBeat.i(250501);
      JSONObject localJSONObject = super.toJson();
      localJSONObject.put("type", this.type);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = ((Iterable)this.NoN).iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Number)localIterator.next()).longValue());
      }
      localJSONObject.put("time", localJSONArray);
      AppMethodBeat.o(250501);
      return localJSONObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditTextItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "()V", "font", "", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static final class b
    extends c.a
  {
    private String IbE = "";
    
    public final void setFont(String paramString)
    {
      AppMethodBeat.i(225193);
      p.k(paramString, "<set-?>");
      this.IbE = paramString;
      AppMethodBeat.o(225193);
    }
    
    public final JSONObject toJson()
    {
      AppMethodBeat.i(225195);
      JSONObject localJSONObject = super.toJson();
      if (!Util.isNullOrNil(this.IbE)) {
        localJSONObject.put("font", this.IbE);
      }
      AppMethodBeat.o(225195);
      return localJSONObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "pss", "", "getPss", "()I", "setPss", "(I)V", "thumbCount", "getThumbCount", "setThumbCount", "thumbMem", "getThumbMem", "setThumbMem", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static final class c
    extends a
  {
    int NoO;
    int NoP;
    int NoQ;
    
    public final JSONObject toJson()
    {
      AppMethodBeat.i(249642);
      JSONObject localJSONObject = super.toJson();
      localJSONObject.put("pss", this.NoO + 'K');
      localJSONObject.put("thumbCount", this.NoP);
      localJSONObject.put("thumbMem", Util.getSizeMB(this.NoQ));
      AppMethodBeat.o(249642);
      return localJSONObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$ImageItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "()V", "plugin-vlog_release"})
  public static final class d
    extends c.e
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "size", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getSize", "()Ljava/util/ArrayList;", "setSize", "(Ljava/util/ArrayList;)V", "time", "", "getTime", "setTime", "type", "getType", "()I", "setType", "(I)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static class e
    extends a
  {
    public ArrayList<Long> NoN;
    public ArrayList<Integer> NoR;
    public int type;
    
    public e()
    {
      AppMethodBeat.i(243566);
      this.NoR = new ArrayList();
      this.NoN = new ArrayList();
      AppMethodBeat.o(243566);
    }
    
    public JSONObject toJson()
    {
      AppMethodBeat.i(243565);
      JSONObject localJSONObject = super.toJson();
      localJSONObject.put("type", this.type);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = ((Iterable)this.NoR).iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Number)localIterator.next()).intValue());
      }
      localJSONObject.put("size", localJSONArray);
      localJSONArray = new JSONArray();
      localIterator = ((Iterable)this.NoN).iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Number)localIterator.next()).longValue());
      }
      localJSONObject.put("time", localJSONArray);
      AppMethodBeat.o(243565);
      return localJSONObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$VideoItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "()V", "audioBitrate", "", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "audioMime", "", "getAudioMime", "()Ljava/lang/String;", "setAudioMime", "(Ljava/lang/String;)V", "audioSampleRate", "getAudioSampleRate", "setAudioSampleRate", "bitrate", "getBitrate", "setBitrate", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "fps", "", "getFps", "()F", "setFps", "(F)V", "playRate", "getPlayRate", "setPlayRate", "videoMime", "getVideoMime", "setVideoMime", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static final class f
    extends c.e
  {
    private String NoS = "";
    private String NoT = "";
    public int audioBitrate;
    public int audioSampleRate;
    public int bitrate = 1;
    public float cLa = 1.0F;
    public long duration;
    public float pvh = 1.0F;
    
    public final void bfC(String paramString)
    {
      AppMethodBeat.i(232754);
      p.k(paramString, "<set-?>");
      this.NoS = paramString;
      AppMethodBeat.o(232754);
    }
    
    public final void bfD(String paramString)
    {
      AppMethodBeat.i(232756);
      p.k(paramString, "<set-?>");
      this.NoT = paramString;
      AppMethodBeat.o(232756);
    }
    
    public final JSONObject toJson()
    {
      AppMethodBeat.i(232759);
      JSONObject localJSONObject = super.toJson();
      if (this.pvh != 1.0F) {
        localJSONObject.put("playRate", Float.valueOf(this.pvh));
      }
      localJSONObject.put("duration", this.duration);
      localJSONObject.put("fps", Float.valueOf(this.cLa));
      localJSONObject.put("bitrate", this.bitrate);
      localJSONObject.put("audioSampleRate", this.audioSampleRate);
      localJSONObject.put("audioBitrate", this.audioBitrate);
      localJSONObject.put("videoMime", this.NoS);
      localJSONObject.put("audioMime", this.NoT);
      AppMethodBeat.o(232759);
      return localJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.report.c
 * JD-Core Version:    0.7.0.1
 */