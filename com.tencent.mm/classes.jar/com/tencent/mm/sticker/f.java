package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import d.v;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/StickerPack;", "", "()V", "TAG", "", "backgroundSticker", "Lcom/tencent/mm/sticker/StickerInfo;", "getBackgroundSticker", "()Lcom/tencent/mm/sticker/StickerInfo;", "setBackgroundSticker", "(Lcom/tencent/mm/sticker/StickerInfo;)V", "faceTrackSticker", "getFaceTrackSticker", "setFaceTrackSticker", "foregroundSticker", "getForegroundSticker", "setForegroundSticker", "lensId", "getLensId", "()Ljava/lang/String;", "setLensId", "(Ljava/lang/String;)V", "resPath", "getResPath", "setResPath", "strokeColor", "getStrokeColor", "setStrokeColor", "title", "getTitle", "setTitle", "titleColor", "getTitleColor", "setTitleColor", "transform", "Lcom/tencent/mm/sticker/StickerTransform;", "getTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "setTransform", "(Lcom/tencent/mm/sticker/StickerTransform;)V", "version", "", "getVersion", "()D", "setVersion", "(D)V", "allElement", "", "Lcom/tencent/mm/sticker/StickerElement;", "isValid", "", "parseFromLocal", "", "packDir", "parseFromPack", "Companion", "plugin-sticker_release"})
public final class f
{
  public static final a GAA;
  public String GAw;
  public e GAx;
  public e GAy;
  public e GAz;
  private String GzW;
  private g GzX;
  private final String TAG;
  private double bDF;
  public String pmO;
  public String title;
  public String titleColor;
  
  static
  {
    AppMethodBeat.i(105908);
    GAA = new a((byte)0);
    AppMethodBeat.o(105908);
  }
  
  public f()
  {
    AppMethodBeat.i(105907);
    this.TAG = "MicroMsg.StickerPack";
    this.pmO = "";
    this.GzW = "";
    this.title = "";
    this.titleColor = "";
    this.GAw = "";
    this.GzX = new g();
    AppMethodBeat.o(105907);
  }
  
  public final void aMr(String paramString)
  {
    AppMethodBeat.i(105903);
    k.h(paramString, "<set-?>");
    this.pmO = paramString;
    AppMethodBeat.o(105903);
  }
  
  public final void aMs(String paramString)
  {
    AppMethodBeat.i(105904);
    k.h(paramString, "<set-?>");
    this.GzW = paramString;
    AppMethodBeat.o(105904);
  }
  
  public final void aMt(String paramString)
  {
    AppMethodBeat.i(105905);
    k.h(paramString, "packDir");
    try
    {
      Object localObject1 = h.tT(i.aSr(paramString + "config.json"));
      Object localObject2 = ((JSONObject)localObject1).getString("id");
      k.g(localObject2, "jsonObj.getString(KEY_ID)");
      this.pmO = ((String)localObject2);
      this.bDF = ((JSONObject)localObject1).getDouble("version");
      localObject2 = ((JSONObject)localObject1).optString("subtitle");
      k.g(localObject2, "jsonObj.optString(KEY_SUBTITLE)");
      this.title = ((String)localObject2);
      localObject2 = ((JSONObject)localObject1).optString("subtitle_color");
      k.g(localObject2, "jsonObj.optString(KEY_SUBTITLE_COLOR)");
      this.titleColor = ((String)localObject2);
      localObject2 = ((JSONObject)localObject1).optString("stroke_color");
      k.g(localObject2, "jsonObj.optString(KEY_SUBTITLE_STROKE_COLOR)");
      this.GAw = ((String)localObject2);
      Object localObject3 = ((JSONObject)localObject1).optString("face_track");
      localObject2 = ((JSONObject)localObject1).optString("background");
      localObject1 = ((JSONObject)localObject1).optString("foreground");
      k.g(localObject3, "faceTrackDir");
      if (((CharSequence)localObject3).length() > 0)
      {
        i = 1;
        if (i != 0)
        {
          localObject3 = new e();
          ((e)localObject3).aMs(paramString + "face_track/");
          a.a locala = a.GzL;
          a.a.a(((e)localObject3).GzW + "config.json", (a)localObject3);
          this.GAx = ((e)localObject3);
        }
        k.g(localObject2, "backgroundDir");
        if (((CharSequence)localObject2).length() <= 0) {
          break label460;
        }
        i = 1;
        label277:
        if (i != 0)
        {
          localObject2 = new e();
          ((e)localObject2).aMs(paramString + "background/");
          localObject3 = a.GzL;
          a.a.a(((e)localObject2).GzW + "config.json", (a)localObject2);
          this.GAy = ((e)localObject2);
        }
        k.g(localObject1, "foregroundDir");
        if (((CharSequence)localObject1).length() <= 0) {
          break label465;
        }
      }
      label460:
      label465:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label488;
        }
        localObject1 = new e();
        ((e)localObject1).aMs(paramString + "foreground/");
        paramString = a.GzL;
        a.a.a(((e)localObject1).GzW + "config.json", (a)localObject1);
        this.GAz = ((e)localObject1);
        AppMethodBeat.o(105905);
        return;
        i = 0;
        break;
        i = 0;
        break label277;
      }
      label488:
      return;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace(this.TAG, (Throwable)paramString, "", new Object[0]);
      AppMethodBeat.o(105905);
    }
  }
  
  public final void aMu(String paramString)
  {
    AppMethodBeat.i(105906);
    k.h(paramString, "packDir");
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      Object localObject4;
      Object localObject3;
      int i;
      Object localObject5;
      d locald;
      try
      {
        paramString = h.tT(i.aSr(paramString + "config.json"));
        ac.i(this.TAG, "parseFromPack: ".concat(String.valueOf(paramString)));
        localObject1 = paramString.getString("id");
        if (!bs.isNullOrNil((String)localObject1))
        {
          k.g(localObject1, "it");
          this.pmO = ((String)localObject1);
        }
        this.bDF = paramString.getDouble("version");
        localObject1 = paramString.optJSONObject("custom");
        if (localObject1 != null)
        {
          localObject2 = ((JSONObject)localObject1).optString("subtitle");
          k.g(localObject2, "custom.optString(KEY_SUBTITLE)");
          this.title = ((String)localObject2);
          localObject2 = ((JSONObject)localObject1).optString("subtitle_color");
          k.g(localObject2, "custom.optString(KEY_SUBTITLE_COLOR)");
          this.titleColor = ((String)localObject2);
          localObject1 = ((JSONObject)localObject1).optString("stroke_color");
          k.g(localObject1, "custom.optString(KEY_SUBTITLE_STROKE_COLOR)");
          this.GAw = ((String)localObject1);
        }
        localObject1 = paramString.getJSONObject("params");
        localObject4 = ((JSONObject)localObject1).getJSONArray("elements");
        localObject3 = new HashMap();
        localObject2 = new HashMap();
        paramString = new HashMap();
        int j = ((JSONArray)localObject4).length();
        i = 0;
        if (i >= j) {
          break label394;
        }
        localObject5 = ((JSONArray)localObject4).getString(i);
        JSONObject localJSONObject = ((JSONObject)localObject1).getJSONObject((String)localObject5);
        locald = new d();
        k.g(localObject5, "name");
        locald.setName((String)localObject5);
        k.g(localJSONObject, "elementObj");
        locald.by(localJSONObject);
        if (locald.GzT == 0) {
          ((Map)localObject3).put(localObject5, locald);
        } else if (locald.GzT == 1) {
          ((Map)paramString).put(localObject5, locald);
        }
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace(this.TAG, (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(105906);
        return;
      }
      if (locald.GzT == 2)
      {
        ((Map)localObject2).put(localObject5, locald);
        break label1336;
        label394:
        localObject4 = this.GzX;
        localObject1 = ((JSONObject)localObject1).getJSONObject("template_trans_set");
        k.g(localObject1, "params.getJSONObject(\"template_trans_set\")");
        ((g)localObject4).by((JSONObject)localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("id", this.pmO).put("version", this.bDF).put("subtitle", this.title).put("subtitle_color", this.titleColor).put("stroke_color", this.GAw);
        if (((HashMap)localObject3).size() > 0)
        {
          localObject4 = new e();
          ((e)localObject4).aMr(this.pmO);
          ((e)localObject4).bDF = this.bDF;
          ((e)localObject4).setType("Sticker2D");
          localObject5 = this.GzX;
          k.h(localObject5, "<set-?>");
          ((e)localObject4).GzX = ((g)localObject5);
          ((e)localObject4).aMs(this.GzW + "face_track/");
          i.aSh(((e)localObject4).GzW);
          ((e)localObject4).o((HashMap)localObject3);
          localObject3 = ((Map)localObject3).entrySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = (Map.Entry)((Iterator)localObject3).next();
            i.ct(this.GzW + (String)((Map.Entry)localObject5).getKey(), ((e)localObject4).GzW + (String)((Map.Entry)localObject5).getKey());
          }
          localObject3 = a.GzL;
          a.a.a((a)localObject4, ((e)localObject4).GzW + "config.json");
          ((JSONObject)localObject1).put("face_track", ((e)localObject4).GzW);
          this.GAx = ((e)localObject4);
        }
        if (((HashMap)localObject2).size() > 0)
        {
          localObject3 = new e();
          ((e)localObject3).aMr(this.pmO);
          ((e)localObject3).bDF = this.bDF;
          ((e)localObject3).setType("Segment");
          ((e)localObject3).aMs(this.GzW + "background/");
          i.aSh(((e)localObject3).GzW);
          ((e)localObject3).o((HashMap)localObject2);
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (Map.Entry)((Iterator)localObject2).next();
            i.ct(this.GzW + (String)((Map.Entry)localObject4).getKey(), ((e)localObject3).GzW + (String)((Map.Entry)localObject4).getKey());
          }
          localObject2 = a.GzL;
          a.a.a((a)localObject3, ((e)localObject3).GzW + "config.json");
          ((JSONObject)localObject1).put("background", ((e)localObject3).GzW);
          this.GAy = ((e)localObject3);
        }
        if (paramString.size() > 0)
        {
          localObject2 = new e();
          ((e)localObject2).aMr(this.pmO);
          ((e)localObject2).bDF = this.bDF;
          ((e)localObject2).setType("StickerFixed");
          ((e)localObject2).aMs(this.GzW + "foreground/");
          i.aSh(((e)localObject2).GzW);
          ((e)localObject2).o(paramString);
          paramString = ((Map)paramString).entrySet().iterator();
          while (paramString.hasNext())
          {
            localObject3 = (Map.Entry)paramString.next();
            i.ct(this.GzW + (String)((Map.Entry)localObject3).getKey(), ((e)localObject2).GzW + (String)((Map.Entry)localObject3).getKey());
          }
          paramString = a.GzL;
          a.a.a((a)localObject2, ((e)localObject2).GzW + "config.json");
          ((JSONObject)localObject1).put("foreground", ((e)localObject2).GzW);
          this.GAz = ((e)localObject2);
        }
        paramString = this.GzW + "config.json";
        localObject1 = ((JSONObject)localObject1).toString();
        k.g(localObject1, "saveJson.toString()");
        localObject2 = d.n.d.UTF_8;
        if (localObject1 == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(105906);
          throw paramString;
        }
        localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
        k.g(localObject1, "(this as java.lang.String).getBytes(charset)");
        i.B(paramString, (byte[])localObject1);
        AppMethodBeat.o(105906);
        return;
      }
      label1336:
      i += 1;
    }
  }
  
  public final boolean isValid()
  {
    return (this.GAx != null) || (this.GAy != null) || (this.GAz != null);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/StickerPack$Companion;", "", "()V", "BACKGROUND_DIR", "", "CONFIG_FILE", "FACE_TRACK_DIR", "FOREGROUND_DIR", "KEY_BACKGROUND", "KEY_CUSTOM", "KEY_ELEMENTS", "KEY_FACE_TRACK", "KEY_FOREGROUND", "KEY_ID", "KEY_PARAMS", "KEY_SUBTITLE", "KEY_SUBTITLE_COLOR", "KEY_SUBTITLE_STROKE_COLOR", "KEY_VERSION", "TYPE_FACE_TRACK", "TYPE_FIXED", "TYPE_SEGMENT", "createByLocal", "Lcom/tencent/mm/sticker/StickerPack;", "packDir", "plugin-sticker_release"})
  public static final class a
  {
    public static f aMv(String paramString)
    {
      AppMethodBeat.i(204908);
      k.h(paramString, "packDir");
      f localf = new f();
      localf.aMs(paramString);
      localf.aMt(paramString);
      AppMethodBeat.o(204908);
      return localf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.f
 * JD-Core Version:    0.7.0.1
 */