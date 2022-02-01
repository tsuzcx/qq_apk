package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.b.p;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/StickerPack;", "", "()V", "TAG", "", "backgroundSticker", "Lcom/tencent/mm/sticker/StickerInfo;", "getBackgroundSticker", "()Lcom/tencent/mm/sticker/StickerInfo;", "setBackgroundSticker", "(Lcom/tencent/mm/sticker/StickerInfo;)V", "faceTrackSticker", "getFaceTrackSticker", "setFaceTrackSticker", "foregroundSticker", "getForegroundSticker", "setForegroundSticker", "lensId", "getLensId", "()Ljava/lang/String;", "setLensId", "(Ljava/lang/String;)V", "resPath", "getResPath", "setResPath", "strokeColor", "getStrokeColor", "setStrokeColor", "title", "getTitle", "setTitle", "titleColor", "getTitleColor", "setTitleColor", "transform", "Lcom/tencent/mm/sticker/StickerTransform;", "getTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "setTransform", "(Lcom/tencent/mm/sticker/StickerTransform;)V", "version", "", "getVersion", "()D", "setVersion", "(D)V", "allElement", "", "Lcom/tencent/mm/sticker/StickerElement;", "isValid", "", "parseFromLocal", "", "packDir", "parseFromPack", "Companion", "plugin-sticker_release"})
public final class f
{
  public static final a IGF;
  public String IGB;
  public e IGC;
  public e IGD;
  public e IGE;
  private String IGb;
  private g IGc;
  private final String TAG;
  private double bNT;
  public String pWT;
  public String title;
  public String titleColor;
  
  static
  {
    AppMethodBeat.i(105908);
    IGF = new a((byte)0);
    AppMethodBeat.o(105908);
  }
  
  public f()
  {
    AppMethodBeat.i(105907);
    this.TAG = "MicroMsg.StickerPack";
    this.pWT = "";
    this.IGb = "";
    this.title = "";
    this.titleColor = "";
    this.IGB = "";
    this.IGc = new g();
    AppMethodBeat.o(105907);
  }
  
  public final void aTv(String paramString)
  {
    AppMethodBeat.i(105903);
    p.h(paramString, "<set-?>");
    this.pWT = paramString;
    AppMethodBeat.o(105903);
  }
  
  public final void aTw(String paramString)
  {
    AppMethodBeat.i(105904);
    p.h(paramString, "<set-?>");
    this.IGb = paramString;
    AppMethodBeat.o(105904);
  }
  
  public final void aTx(String paramString)
  {
    AppMethodBeat.i(105905);
    p.h(paramString, "packDir");
    try
    {
      Object localObject1 = h.xs(o.aZT(paramString + "config.json"));
      Object localObject2 = ((JSONObject)localObject1).getString("id");
      p.g(localObject2, "jsonObj.getString(KEY_ID)");
      this.pWT = ((String)localObject2);
      this.bNT = ((JSONObject)localObject1).getDouble("version");
      localObject2 = ((JSONObject)localObject1).optString("subtitle");
      p.g(localObject2, "jsonObj.optString(KEY_SUBTITLE)");
      this.title = ((String)localObject2);
      localObject2 = ((JSONObject)localObject1).optString("subtitle_color");
      p.g(localObject2, "jsonObj.optString(KEY_SUBTITLE_COLOR)");
      this.titleColor = ((String)localObject2);
      localObject2 = ((JSONObject)localObject1).optString("stroke_color");
      p.g(localObject2, "jsonObj.optString(KEY_SUBTITLE_STROKE_COLOR)");
      this.IGB = ((String)localObject2);
      Object localObject3 = ((JSONObject)localObject1).optString("face_track");
      localObject2 = ((JSONObject)localObject1).optString("background");
      localObject1 = ((JSONObject)localObject1).optString("foreground");
      p.g(localObject3, "faceTrackDir");
      if (((CharSequence)localObject3).length() > 0)
      {
        i = 1;
        if (i != 0)
        {
          localObject3 = new e();
          ((e)localObject3).aTw(paramString + "face_track/");
          a.a locala = a.IFQ;
          a.a.a(((e)localObject3).IGb + "config.json", (a)localObject3);
          this.IGC = ((e)localObject3);
        }
        p.g(localObject2, "backgroundDir");
        if (((CharSequence)localObject2).length() <= 0) {
          break label460;
        }
        i = 1;
        label277:
        if (i != 0)
        {
          localObject2 = new e();
          ((e)localObject2).aTw(paramString + "background/");
          localObject3 = a.IFQ;
          a.a.a(((e)localObject2).IGb + "config.json", (a)localObject2);
          this.IGD = ((e)localObject2);
        }
        p.g(localObject1, "foregroundDir");
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
        ((e)localObject1).aTw(paramString + "foreground/");
        paramString = a.IFQ;
        a.a.a(((e)localObject1).IGb + "config.json", (a)localObject1);
        this.IGE = ((e)localObject1);
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
      ae.printErrStackTrace(this.TAG, (Throwable)paramString, "", new Object[0]);
      AppMethodBeat.o(105905);
    }
  }
  
  public final void aTy(String paramString)
  {
    AppMethodBeat.i(105906);
    p.h(paramString, "packDir");
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
        paramString = h.xs(o.aZT(paramString + "config.json"));
        ae.i(this.TAG, "parseFromPack: ".concat(String.valueOf(paramString)));
        localObject1 = paramString.getString("id");
        if (!bu.isNullOrNil((String)localObject1))
        {
          p.g(localObject1, "it");
          this.pWT = ((String)localObject1);
        }
        this.bNT = paramString.getDouble("version");
        localObject1 = paramString.optJSONObject("custom");
        if (localObject1 != null)
        {
          localObject2 = ((JSONObject)localObject1).optString("subtitle");
          p.g(localObject2, "custom.optString(KEY_SUBTITLE)");
          this.title = ((String)localObject2);
          localObject2 = ((JSONObject)localObject1).optString("subtitle_color");
          p.g(localObject2, "custom.optString(KEY_SUBTITLE_COLOR)");
          this.titleColor = ((String)localObject2);
          localObject1 = ((JSONObject)localObject1).optString("stroke_color");
          p.g(localObject1, "custom.optString(KEY_SUBTITLE_STROKE_COLOR)");
          this.IGB = ((String)localObject1);
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
        p.g(localObject5, "name");
        locald.setName((String)localObject5);
        p.g(localJSONObject, "elementObj");
        locald.bH(localJSONObject);
        if (locald.IFY == 0) {
          ((Map)localObject3).put(localObject5, locald);
        } else if (locald.IFY == 1) {
          ((Map)paramString).put(localObject5, locald);
        }
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace(this.TAG, (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(105906);
        return;
      }
      if (locald.IFY == 2)
      {
        ((Map)localObject2).put(localObject5, locald);
        break label1336;
        label394:
        localObject4 = this.IGc;
        localObject1 = ((JSONObject)localObject1).getJSONObject("template_trans_set");
        p.g(localObject1, "params.getJSONObject(\"template_trans_set\")");
        ((g)localObject4).bH((JSONObject)localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("id", this.pWT).put("version", this.bNT).put("subtitle", this.title).put("subtitle_color", this.titleColor).put("stroke_color", this.IGB);
        if (((HashMap)localObject3).size() > 0)
        {
          localObject4 = new e();
          ((e)localObject4).aTv(this.pWT);
          ((e)localObject4).bNT = this.bNT;
          ((e)localObject4).setType("Sticker2D");
          localObject5 = this.IGc;
          p.h(localObject5, "<set-?>");
          ((e)localObject4).IGc = ((g)localObject5);
          ((e)localObject4).aTw(this.IGb + "face_track/");
          o.aZI(((e)localObject4).IGb);
          ((e)localObject4).p((HashMap)localObject3);
          localObject3 = ((Map)localObject3).entrySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = (Map.Entry)((Iterator)localObject3).next();
            o.cx(this.IGb + (String)((Map.Entry)localObject5).getKey(), ((e)localObject4).IGb + (String)((Map.Entry)localObject5).getKey());
          }
          localObject3 = a.IFQ;
          a.a.a((a)localObject4, ((e)localObject4).IGb + "config.json");
          ((JSONObject)localObject1).put("face_track", ((e)localObject4).IGb);
          this.IGC = ((e)localObject4);
        }
        if (((HashMap)localObject2).size() > 0)
        {
          localObject3 = new e();
          ((e)localObject3).aTv(this.pWT);
          ((e)localObject3).bNT = this.bNT;
          ((e)localObject3).setType("Segment");
          ((e)localObject3).aTw(this.IGb + "background/");
          o.aZI(((e)localObject3).IGb);
          ((e)localObject3).p((HashMap)localObject2);
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (Map.Entry)((Iterator)localObject2).next();
            o.cx(this.IGb + (String)((Map.Entry)localObject4).getKey(), ((e)localObject3).IGb + (String)((Map.Entry)localObject4).getKey());
          }
          localObject2 = a.IFQ;
          a.a.a((a)localObject3, ((e)localObject3).IGb + "config.json");
          ((JSONObject)localObject1).put("background", ((e)localObject3).IGb);
          this.IGD = ((e)localObject3);
        }
        if (paramString.size() > 0)
        {
          localObject2 = new e();
          ((e)localObject2).aTv(this.pWT);
          ((e)localObject2).bNT = this.bNT;
          ((e)localObject2).setType("StickerFixed");
          ((e)localObject2).aTw(this.IGb + "foreground/");
          o.aZI(((e)localObject2).IGb);
          ((e)localObject2).p(paramString);
          paramString = ((Map)paramString).entrySet().iterator();
          while (paramString.hasNext())
          {
            localObject3 = (Map.Entry)paramString.next();
            o.cx(this.IGb + (String)((Map.Entry)localObject3).getKey(), ((e)localObject2).IGb + (String)((Map.Entry)localObject3).getKey());
          }
          paramString = a.IFQ;
          a.a.a((a)localObject2, ((e)localObject2).IGb + "config.json");
          ((JSONObject)localObject1).put("foreground", ((e)localObject2).IGb);
          this.IGE = ((e)localObject2);
        }
        paramString = this.IGb + "config.json";
        localObject1 = ((JSONObject)localObject1).toString();
        p.g(localObject1, "saveJson.toString()");
        localObject2 = d.n.d.UTF_8;
        if (localObject1 == null)
        {
          paramString = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(105906);
          throw paramString;
        }
        localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
        p.g(localObject1, "(this as java.lang.String).getBytes(charset)");
        o.C(paramString, (byte[])localObject1);
        AppMethodBeat.o(105906);
        return;
      }
      label1336:
      i += 1;
    }
  }
  
  public final boolean isValid()
  {
    return (this.IGC != null) || (this.IGD != null) || (this.IGE != null);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/StickerPack$Companion;", "", "()V", "BACKGROUND_DIR", "", "CONFIG_FILE", "FACE_TRACK_DIR", "FOREGROUND_DIR", "KEY_BACKGROUND", "KEY_CUSTOM", "KEY_ELEMENTS", "KEY_FACE_TRACK", "KEY_FOREGROUND", "KEY_ID", "KEY_PARAMS", "KEY_SUBTITLE", "KEY_SUBTITLE_COLOR", "KEY_SUBTITLE_STROKE_COLOR", "KEY_VERSION", "TYPE_FACE_TRACK", "TYPE_FIXED", "TYPE_SEGMENT", "createByLocal", "Lcom/tencent/mm/sticker/StickerPack;", "packDir", "plugin-sticker_release"})
  public static final class a
  {
    public static f aTz(String paramString)
    {
      AppMethodBeat.i(208256);
      p.h(paramString, "packDir");
      f localf = new f();
      localf.aTw(paramString);
      localf.aTx(paramString);
      AppMethodBeat.o(208256);
      return localf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.f
 * JD-Core Version:    0.7.0.1
 */