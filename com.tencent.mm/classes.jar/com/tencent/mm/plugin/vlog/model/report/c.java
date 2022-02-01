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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "editList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "Lkotlin/collections/ArrayList;", "getEditList", "()Ljava/util/ArrayList;", "setEditList", "(Ljava/util/ArrayList;)V", "mediaList", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "getMediaList", "setMediaList", "status", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "getStatus", "()Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "setStatus", "(Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;)V", "toJson", "Lorg/json/JSONObject;", "EditItem", "EditTextItem", "EditorStatus", "ImageItem", "MediaItem", "VideoItem", "plugin-vlog_release"})
public final class c
  extends a
{
  c GBc;
  ArrayList<a> editList;
  ArrayList<e> tGk;
  
  public c()
  {
    AppMethodBeat.i(190826);
    this.tGk = new ArrayList();
    this.editList = new ArrayList();
    this.GBc = new c();
    AppMethodBeat.o(190826);
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(190825);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("status", this.GBc.toJson());
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = ((Iterable)this.tGk).iterator();
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
    AppMethodBeat.o(190825);
    return localJSONObject;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "time", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getTime", "()Ljava/util/ArrayList;", "setTime", "(Ljava/util/ArrayList;)V", "type", "", "getType", "()I", "setType", "(I)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static class a
    extends a
  {
    ArrayList<Long> GBd;
    int type;
    
    public a()
    {
      AppMethodBeat.i(190818);
      this.GBd = new ArrayList();
      AppMethodBeat.o(190818);
    }
    
    public JSONObject toJson()
    {
      AppMethodBeat.i(190817);
      JSONObject localJSONObject = super.toJson();
      localJSONObject.put("type", this.type);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = ((Iterable)this.GBd).iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Number)localIterator.next()).longValue());
      }
      localJSONObject.put("time", localJSONArray);
      AppMethodBeat.o(190817);
      return localJSONObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditTextItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "()V", "font", "", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static final class b
    extends c.a
  {
    private String CeI = "";
    
    public final void setFont(String paramString)
    {
      AppMethodBeat.i(190819);
      p.h(paramString, "<set-?>");
      this.CeI = paramString;
      AppMethodBeat.o(190819);
    }
    
    public final JSONObject toJson()
    {
      AppMethodBeat.i(190820);
      JSONObject localJSONObject = super.toJson();
      if (!Util.isNullOrNil(this.CeI)) {
        localJSONObject.put("font", this.CeI);
      }
      AppMethodBeat.o(190820);
      return localJSONObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "pss", "", "getPss", "()I", "setPss", "(I)V", "thumbCount", "getThumbCount", "setThumbCount", "thumbMem", "getThumbMem", "setThumbMem", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static final class c
    extends a
  {
    int GBe;
    int GBf;
    int GBg;
    
    public final JSONObject toJson()
    {
      AppMethodBeat.i(190821);
      JSONObject localJSONObject = super.toJson();
      localJSONObject.put("pss", this.GBe + 'K');
      localJSONObject.put("thumbCount", this.GBf);
      localJSONObject.put("thumbMem", Util.getSizeMB(this.GBg));
      AppMethodBeat.o(190821);
      return localJSONObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$ImageItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "()V", "plugin-vlog_release"})
  public static final class d
    extends c.e
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "size", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getSize", "()Ljava/util/ArrayList;", "setSize", "(Ljava/util/ArrayList;)V", "time", "", "getTime", "setTime", "type", "getType", "()I", "setType", "(I)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static class e
    extends a
  {
    ArrayList<Long> GBd;
    ArrayList<Integer> GBh;
    int type;
    
    public e()
    {
      AppMethodBeat.i(190823);
      this.GBh = new ArrayList();
      this.GBd = new ArrayList();
      AppMethodBeat.o(190823);
    }
    
    public JSONObject toJson()
    {
      AppMethodBeat.i(190822);
      JSONObject localJSONObject = super.toJson();
      localJSONObject.put("type", this.type);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = ((Iterable)this.GBh).iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Number)localIterator.next()).intValue());
      }
      localJSONObject.put("size", localJSONArray);
      localJSONArray = new JSONArray();
      localIterator = ((Iterable)this.GBd).iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Number)localIterator.next()).longValue());
      }
      localJSONObject.put("time", localJSONArray);
      AppMethodBeat.o(190822);
      return localJSONObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$VideoItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "()V", "audioBitrate", "", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "audioSampleRate", "getAudioSampleRate", "setAudioSampleRate", "bitrate", "getBitrate", "setBitrate", "fps", "", "getFps", "()F", "setFps", "(F)V", "playRate", "getPlayRate", "setPlayRate", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static final class f
    extends c.e
  {
    int audioBitrate;
    int audioSampleRate;
    int bitrate = 1;
    float cKu = 1.0F;
    float mwH = 1.0F;
    
    public final JSONObject toJson()
    {
      AppMethodBeat.i(190824);
      JSONObject localJSONObject = super.toJson();
      if (this.mwH != 1.0F) {
        localJSONObject.put("playRate", Float.valueOf(this.mwH));
      }
      localJSONObject.put("fps", Float.valueOf(this.cKu));
      localJSONObject.put("bitrate", this.bitrate);
      localJSONObject.put("audioSampleRate", this.audioSampleRate);
      localJSONObject.put("audioBitrate", this.audioBitrate);
      AppMethodBeat.o(190824);
      return localJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.report.c
 * JD-Core Version:    0.7.0.1
 */