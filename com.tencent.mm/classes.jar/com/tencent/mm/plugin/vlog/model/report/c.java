package com.tencent.mm.plugin.vlog.model.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sticker.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "editList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "Lkotlin/collections/ArrayList;", "getEditList", "()Ljava/util/ArrayList;", "setEditList", "(Ljava/util/ArrayList;)V", "mediaList", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "getMediaList", "setMediaList", "status", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "getStatus", "()Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "setStatus", "(Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;)V", "toJson", "Lorg/json/JSONObject;", "EditItem", "EditTextItem", "EditorStatus", "ImageItem", "MediaItem", "VideoItem", "plugin-vlog_release"})
public final class c
  extends a
{
  public c BHQ;
  public ArrayList<a> editList;
  public ArrayList<e> teB;
  
  public c()
  {
    AppMethodBeat.i(195901);
    this.teB = new ArrayList();
    this.editList = new ArrayList();
    this.BHQ = new c();
    AppMethodBeat.o(195901);
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(195900);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("status", this.BHQ.toJson());
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = ((Iterable)this.teB).iterator();
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
    AppMethodBeat.o(195900);
    return localJSONObject;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "time", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getTime", "()Ljava/util/ArrayList;", "setTime", "(Ljava/util/ArrayList;)V", "type", "", "getType", "()I", "setType", "(I)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static class a
    extends a
  {
    public ArrayList<Long> BHR;
    public int type;
    
    public a()
    {
      AppMethodBeat.i(195893);
      this.BHR = new ArrayList();
      AppMethodBeat.o(195893);
    }
    
    public JSONObject toJson()
    {
      AppMethodBeat.i(195892);
      JSONObject localJSONObject = super.toJson();
      localJSONObject.put("type", this.type);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = ((Iterable)this.BHR).iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Number)localIterator.next()).longValue());
      }
      localJSONObject.put("time", localJSONArray);
      AppMethodBeat.o(195892);
      return localJSONObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditTextItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditItem;", "()V", "font", "", "getFont", "()Ljava/lang/String;", "setFont", "(Ljava/lang/String;)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static final class b
    extends c.a
  {
    private String xNN = "";
    
    public final void setFont(String paramString)
    {
      AppMethodBeat.i(195894);
      p.h(paramString, "<set-?>");
      this.xNN = paramString;
      AppMethodBeat.o(195894);
    }
    
    public final JSONObject toJson()
    {
      AppMethodBeat.i(195895);
      JSONObject localJSONObject = super.toJson();
      if (!bt.isNullOrNil(this.xNN)) {
        localJSONObject.put("font", this.xNN);
      }
      AppMethodBeat.o(195895);
      return localJSONObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$EditorStatus;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "pss", "", "getPss", "()I", "setPss", "(I)V", "thumbCount", "getThumbCount", "setThumbCount", "thumbMem", "getThumbMem", "setThumbMem", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static final class c
    extends a
  {
    public int BHS;
    public int BHT;
    public int BHU;
    
    public final JSONObject toJson()
    {
      AppMethodBeat.i(195896);
      JSONObject localJSONObject = super.toJson();
      localJSONObject.put("pss", this.BHS + 'K');
      localJSONObject.put("thumbCount", this.BHT);
      localJSONObject.put("thumbMem", bt.Dd(this.BHU));
      AppMethodBeat.o(195896);
      return localJSONObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$ImageItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "()V", "plugin-vlog_release"})
  public static final class d
    extends c.e
  {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "size", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getSize", "()Ljava/util/ArrayList;", "setSize", "(Ljava/util/ArrayList;)V", "time", "", "getTime", "setTime", "type", "getType", "()I", "setType", "(I)V", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static class e
    extends a
  {
    public ArrayList<Long> BHR;
    public ArrayList<Integer> BHV;
    public int type;
    
    public e()
    {
      AppMethodBeat.i(195898);
      this.BHV = new ArrayList();
      this.BHR = new ArrayList();
      AppMethodBeat.o(195898);
    }
    
    public JSONObject toJson()
    {
      AppMethodBeat.i(195897);
      JSONObject localJSONObject = super.toJson();
      localJSONObject.put("type", this.type);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = ((Iterable)this.BHV).iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Number)localIterator.next()).intValue());
      }
      localJSONObject.put("size", localJSONArray);
      localJSONArray = new JSONArray();
      localIterator = ((Iterable)this.BHR).iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Number)localIterator.next()).longValue());
      }
      localJSONObject.put("time", localJSONArray);
      AppMethodBeat.o(195897);
      return localJSONObject;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$VideoItem;", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson$MediaItem;", "()V", "audioBitrate", "", "getAudioBitrate", "()I", "setAudioBitrate", "(I)V", "audioSampleRate", "getAudioSampleRate", "setAudioSampleRate", "bitrate", "getBitrate", "setBitrate", "fps", "", "getFps", "()F", "setFps", "(F)V", "playRate", "getPlayRate", "setPlayRate", "toJson", "Lorg/json/JSONObject;", "plugin-vlog_release"})
  public static final class f
    extends c.e
  {
    public int audioBitrate;
    public int audioSampleRate;
    public int bitrate = 1;
    public float cvL = 1.0F;
    public float llC = 1.0F;
    
    public final JSONObject toJson()
    {
      AppMethodBeat.i(195899);
      JSONObject localJSONObject = super.toJson();
      if (this.llC != 1.0F) {
        localJSONObject.put("playRate", Float.valueOf(this.llC));
      }
      localJSONObject.put("fps", Float.valueOf(this.cvL));
      localJSONObject.put("bitrate", this.bitrate);
      localJSONObject.put("audioSampleRate", this.audioSampleRate);
      localJSONObject.put("audioBitrate", this.audioBitrate);
      AppMethodBeat.o(195899);
      return localJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.report.c
 * JD-Core Version:    0.7.0.1
 */