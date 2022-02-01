package com.tencent.mm.plugin.vlog.model.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sticker.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "editList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "Lkotlin/collections/ArrayList;", "getEditList", "()Ljava/util/ArrayList;", "setEditList", "(Ljava/util/ArrayList;)V", "mediaList", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "getMediaList", "setMediaList", "status", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "getStatus", "()Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "setStatus", "(Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;)V", "toJson", "Lorg/json/JSONObject;", "EditItem", "EditTextItem", "EditorStatus", "ImageItem", "MediaItem", "VideoItem", "plugin-vlog_release"})
public final class c
  extends a
{
  public c BZp;
  public ArrayList<a> editList;
  public ArrayList<e> tpu;
  
  public c()
  {
    AppMethodBeat.i(191361);
    this.tpu = new ArrayList();
    this.editList = new ArrayList();
    this.BZp = new c();
    AppMethodBeat.o(191361);
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(191360);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("status", this.BZp.toJson());
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = ((Iterable)this.tpu).iterator();
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
    AppMethodBeat.o(191360);
    return localJSONObject;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "time", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getTime", "()Ljava/util/ArrayList;", "setTime", "(Ljava/util/ArrayList;)V", "type", "", "getType", "()I", "setType", "(I)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static class a
    extends a
  {
    public ArrayList<Long> BZq;
    public int type;
    
    public a()
    {
      AppMethodBeat.i(191353);
      this.BZq = new ArrayList();
      AppMethodBeat.o(191353);
    }
    
    public JSONObject toJson()
    {
      AppMethodBeat.i(191352);
      JSONObject localJSONObject = super.toJson();
      localJSONObject.put("type", this.type);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = ((Iterable)this.BZq).iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Number)localIterator.next()).longValue());
      }
      localJSONObject.put("time", localJSONArray);
      AppMethodBeat.o(191352);
      return localJSONObject;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditTextItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "()V", "font", "", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static final class b
    extends c.a
  {
    private String ydG = "";
    
    public final void setFont(String paramString)
    {
      AppMethodBeat.i(191354);
      p.h(paramString, "<set-?>");
      this.ydG = paramString;
      AppMethodBeat.o(191354);
    }
    
    public final JSONObject toJson()
    {
      AppMethodBeat.i(191355);
      JSONObject localJSONObject = super.toJson();
      if (!bu.isNullOrNil(this.ydG)) {
        localJSONObject.put("font", this.ydG);
      }
      AppMethodBeat.o(191355);
      return localJSONObject;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "pss", "", "getPss", "()I", "setPss", "(I)V", "thumbCount", "getThumbCount", "setThumbCount", "thumbMem", "getThumbMem", "setThumbMem", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static final class c
    extends a
  {
    public int BZr;
    public int BZs;
    public int BZt;
    
    public final JSONObject toJson()
    {
      AppMethodBeat.i(191356);
      JSONObject localJSONObject = super.toJson();
      localJSONObject.put("pss", this.BZr + 'K');
      localJSONObject.put("thumbCount", this.BZs);
      localJSONObject.put("thumbMem", bu.DB(this.BZt));
      AppMethodBeat.o(191356);
      return localJSONObject;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$ImageItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "()V", "plugin-vlog_release"})
  public static final class d
    extends c.e
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "size", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getSize", "()Ljava/util/ArrayList;", "setSize", "(Ljava/util/ArrayList;)V", "time", "", "getTime", "setTime", "type", "getType", "()I", "setType", "(I)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static class e
    extends a
  {
    public ArrayList<Long> BZq;
    public ArrayList<Integer> BZu;
    public int type;
    
    public e()
    {
      AppMethodBeat.i(191358);
      this.BZu = new ArrayList();
      this.BZq = new ArrayList();
      AppMethodBeat.o(191358);
    }
    
    public JSONObject toJson()
    {
      AppMethodBeat.i(191357);
      JSONObject localJSONObject = super.toJson();
      localJSONObject.put("type", this.type);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = ((Iterable)this.BZu).iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Number)localIterator.next()).intValue());
      }
      localJSONObject.put("size", localJSONArray);
      localJSONArray = new JSONArray();
      localIterator = ((Iterable)this.BZq).iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Number)localIterator.next()).longValue());
      }
      localJSONObject.put("time", localJSONArray);
      AppMethodBeat.o(191357);
      return localJSONObject;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$VideoItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "()V", "audioBitrate", "", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "audioSampleRate", "getAudioSampleRate", "setAudioSampleRate", "bitrate", "getBitrate", "setBitrate", "fps", "", "getFps", "()F", "setFps", "(F)V", "playRate", "getPlayRate", "setPlayRate", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static final class f
    extends c.e
  {
    public int audioBitrate;
    public int audioSampleRate;
    public int bitrate = 1;
    public float cwp = 1.0F;
    public float lqb = 1.0F;
    
    public final JSONObject toJson()
    {
      AppMethodBeat.i(191359);
      JSONObject localJSONObject = super.toJson();
      if (this.lqb != 1.0F) {
        localJSONObject.put("playRate", Float.valueOf(this.lqb));
      }
      localJSONObject.put("fps", Float.valueOf(this.cwp));
      localJSONObject.put("bitrate", this.bitrate);
      localJSONObject.put("audioSampleRate", this.audioSampleRate);
      localJSONObject.put("audioBitrate", this.audioBitrate);
      AppMethodBeat.o(191359);
      return localJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.report.c
 * JD-Core Version:    0.7.0.1
 */