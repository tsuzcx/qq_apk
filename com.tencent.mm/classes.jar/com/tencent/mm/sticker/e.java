package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/StickerPack;", "", "()V", "TAG", "", "backgroundSticker", "Lcom/tencent/mm/sticker/StickerInfo;", "getBackgroundSticker", "()Lcom/tencent/mm/sticker/StickerInfo;", "setBackgroundSticker", "(Lcom/tencent/mm/sticker/StickerInfo;)V", "faceTrackSticker", "getFaceTrackSticker", "setFaceTrackSticker", "foregroundSticker", "getForegroundSticker", "setForegroundSticker", "lensId", "getLensId", "()Ljava/lang/String;", "setLensId", "(Ljava/lang/String;)V", "resPath", "getResPath", "setResPath", "strokeColor", "getStrokeColor", "setStrokeColor", "title", "getTitle", "setTitle", "titleColor", "getTitleColor", "setTitleColor", "transform", "Lcom/tencent/mm/sticker/StickerTransform;", "getTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "setTransform", "(Lcom/tencent/mm/sticker/StickerTransform;)V", "version", "", "getVersion", "()D", "setVersion", "(D)V", "allElement", "", "Lcom/tencent/mm/sticker/StickerElement;", "isValid", "", "parseFromLocal", "", "packDir", "parseFromPack", "Companion", "plugin-sticker_release"})
public final class e
{
  public static final a Fdd;
  private f FcA;
  public String FcZ;
  private String Fcz;
  public d Fda;
  public d Fdb;
  public d Fdc;
  private final String TAG;
  private double bFX;
  public String gIA;
  public String oJp;
  public String title;
  
  static
  {
    AppMethodBeat.i(105908);
    Fdd = new a((byte)0);
    AppMethodBeat.o(105908);
  }
  
  public e()
  {
    AppMethodBeat.i(105907);
    this.TAG = "MicroMsg.StickerPack";
    this.oJp = "";
    this.Fcz = "";
    this.title = "";
    this.gIA = "";
    this.FcZ = "";
    this.FcA = new f();
    AppMethodBeat.o(105907);
  }
  
  public final void aGY(String paramString)
  {
    AppMethodBeat.i(105903);
    k.h(paramString, "<set-?>");
    this.oJp = paramString;
    AppMethodBeat.o(105903);
  }
  
  public final void aGZ(String paramString)
  {
    AppMethodBeat.i(105904);
    k.h(paramString, "<set-?>");
    this.Fcz = paramString;
    AppMethodBeat.o(105904);
  }
  
  public final void aHa(String paramString)
  {
    AppMethodBeat.i(105905);
    k.h(paramString, "packDir");
    try
    {
      Object localObject1 = h.qE(i.aMP(paramString + "config.json"));
      Object localObject2 = ((JSONObject)localObject1).getString("id");
      k.g(localObject2, "jsonObj.getString(KEY_ID)");
      this.oJp = ((String)localObject2);
      this.bFX = ((JSONObject)localObject1).getDouble("version");
      localObject2 = ((JSONObject)localObject1).optString("subtitle");
      k.g(localObject2, "jsonObj.optString(KEY_SUBTITLE)");
      this.title = ((String)localObject2);
      localObject2 = ((JSONObject)localObject1).optString("subtitle_color");
      k.g(localObject2, "jsonObj.optString(KEY_SUBTITLE_COLOR)");
      this.gIA = ((String)localObject2);
      localObject2 = ((JSONObject)localObject1).optString("stroke_color");
      k.g(localObject2, "jsonObj.optString(KEY_SUBTITLE_STROKE_COLOR)");
      this.FcZ = ((String)localObject2);
      Object localObject3 = ((JSONObject)localObject1).optString("face_track");
      localObject2 = ((JSONObject)localObject1).optString("background");
      localObject1 = ((JSONObject)localObject1).optString("foreground");
      k.g(localObject3, "faceTrackDir");
      if (((CharSequence)localObject3).length() > 0)
      {
        i = 1;
        if (i != 0)
        {
          localObject3 = new d();
          ((d)localObject3).aGZ(paramString + "face_track/");
          a.a locala = a.Fct;
          a.a.a(((d)localObject3).Fcz + "config.json", (a)localObject3);
          this.Fda = ((d)localObject3);
        }
        k.g(localObject2, "backgroundDir");
        if (((CharSequence)localObject2).length() <= 0) {
          break label460;
        }
        i = 1;
        label277:
        if (i != 0)
        {
          localObject2 = new d();
          ((d)localObject2).aGZ(paramString + "background/");
          localObject3 = a.Fct;
          a.a.a(((d)localObject2).Fcz + "config.json", (a)localObject2);
          this.Fdb = ((d)localObject2);
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
        localObject1 = new d();
        ((d)localObject1).aGZ(paramString + "foreground/");
        paramString = a.Fct;
        a.a.a(((d)localObject1).Fcz + "config.json", (a)localObject1);
        this.Fdc = ((d)localObject1);
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
      ad.printErrStackTrace(this.TAG, (Throwable)paramString, "", new Object[0]);
      AppMethodBeat.o(105905);
    }
  }
  
  public final void aHb(String paramString)
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
      c localc;
      try
      {
        paramString = h.qE(i.aMP(paramString + "config.json"));
        ad.i(this.TAG, "parseFromPack: ".concat(String.valueOf(paramString)));
        localObject1 = paramString.getString("id");
        if (!bt.isNullOrNil((String)localObject1))
        {
          k.g(localObject1, "it");
          this.oJp = ((String)localObject1);
        }
        this.bFX = paramString.getDouble("version");
        localObject1 = paramString.optJSONObject("custom");
        if (localObject1 != null)
        {
          localObject2 = ((JSONObject)localObject1).optString("subtitle");
          k.g(localObject2, "custom.optString(KEY_SUBTITLE)");
          this.title = ((String)localObject2);
          localObject2 = ((JSONObject)localObject1).optString("subtitle_color");
          k.g(localObject2, "custom.optString(KEY_SUBTITLE_COLOR)");
          this.gIA = ((String)localObject2);
          localObject1 = ((JSONObject)localObject1).optString("stroke_color");
          k.g(localObject1, "custom.optString(KEY_SUBTITLE_STROKE_COLOR)");
          this.FcZ = ((String)localObject1);
        }
        localObject1 = paramString.getJSONObject("params");
        localObject4 = ((JSONObject)localObject1).getJSONArray("elements");
        localObject3 = new HashMap();
        localObject2 = new HashMap();
        paramString = new HashMap();
        int j = ((JSONArray)localObject4).length();
        i = 0;
        if (i >= j) {
          break label395;
        }
        localObject5 = ((JSONArray)localObject4).getString(i);
        JSONObject localJSONObject = ((JSONObject)localObject1).getJSONObject((String)localObject5);
        localc = new c();
        k.g(localObject5, "name");
        localc.setName((String)localObject5);
        k.g(localJSONObject, "elementObj");
        localc.bx(localJSONObject);
        if (localc.Fcw == 0) {
          ((Map)localObject3).put(localObject5, localc);
        } else if (localc.Fcw == 1) {
          ((Map)paramString).put(localObject5, localc);
        }
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace(this.TAG, (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(105906);
        return;
      }
      if (localc.Fcw == 2)
      {
        ((Map)localObject2).put(localObject5, localc);
        break label1337;
        label395:
        localObject4 = this.FcA;
        localObject1 = ((JSONObject)localObject1).getJSONObject("template_trans_set");
        k.g(localObject1, "params.getJSONObject(\"template_trans_set\")");
        ((f)localObject4).bx((JSONObject)localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("id", this.oJp).put("version", this.bFX).put("subtitle", this.title).put("subtitle_color", this.gIA).put("stroke_color", this.FcZ);
        if (((HashMap)localObject3).size() > 0)
        {
          localObject4 = new d();
          ((d)localObject4).aGY(this.oJp);
          ((d)localObject4).bFX = this.bFX;
          ((d)localObject4).setType("Sticker2D");
          localObject5 = this.FcA;
          k.h(localObject5, "<set-?>");
          ((d)localObject4).FcA = ((f)localObject5);
          ((d)localObject4).aGZ(this.Fcz + "face_track/");
          i.aMF(((d)localObject4).Fcz);
          ((d)localObject4).n((HashMap)localObject3);
          localObject3 = ((Map)localObject3).entrySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject5 = (Map.Entry)((Iterator)localObject3).next();
            i.lF(this.Fcz + (String)((Map.Entry)localObject5).getKey(), ((d)localObject4).Fcz + (String)((Map.Entry)localObject5).getKey());
          }
          localObject3 = a.Fct;
          a.a.a((a)localObject4, ((d)localObject4).Fcz + "config.json");
          ((JSONObject)localObject1).put("face_track", ((d)localObject4).Fcz);
          this.Fda = ((d)localObject4);
        }
        if (((HashMap)localObject2).size() > 0)
        {
          localObject3 = new d();
          ((d)localObject3).aGY(this.oJp);
          ((d)localObject3).bFX = this.bFX;
          ((d)localObject3).setType("Segment");
          ((d)localObject3).aGZ(this.Fcz + "background/");
          i.aMF(((d)localObject3).Fcz);
          ((d)localObject3).n((HashMap)localObject2);
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (Map.Entry)((Iterator)localObject2).next();
            i.lF(this.Fcz + (String)((Map.Entry)localObject4).getKey(), ((d)localObject3).Fcz + (String)((Map.Entry)localObject4).getKey());
          }
          localObject2 = a.Fct;
          a.a.a((a)localObject3, ((d)localObject3).Fcz + "config.json");
          ((JSONObject)localObject1).put("background", ((d)localObject3).Fcz);
          this.Fdb = ((d)localObject3);
        }
        if (paramString.size() > 0)
        {
          localObject2 = new d();
          ((d)localObject2).aGY(this.oJp);
          ((d)localObject2).bFX = this.bFX;
          ((d)localObject2).setType("StickerFixed");
          ((d)localObject2).aGZ(this.Fcz + "foreground/");
          i.aMF(((d)localObject2).Fcz);
          ((d)localObject2).n(paramString);
          paramString = ((Map)paramString).entrySet().iterator();
          while (paramString.hasNext())
          {
            localObject3 = (Map.Entry)paramString.next();
            i.lF(this.Fcz + (String)((Map.Entry)localObject3).getKey(), ((d)localObject2).Fcz + (String)((Map.Entry)localObject3).getKey());
          }
          paramString = a.Fct;
          a.a.a((a)localObject2, ((d)localObject2).Fcz + "config.json");
          ((JSONObject)localObject1).put("foreground", ((d)localObject2).Fcz);
          this.Fdc = ((d)localObject2);
        }
        paramString = this.Fcz + "config.json";
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
      label1337:
      i += 1;
    }
  }
  
  public final boolean isValid()
  {
    return (this.Fda != null) || (this.Fdb != null) || (this.Fdc != null);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/StickerPack$Companion;", "", "()V", "BACKGROUND_DIR", "", "CONFIG_FILE", "FACE_TRACK_DIR", "FOREGROUND_DIR", "KEY_BACKGROUND", "KEY_CUSTOM", "KEY_ELEMENTS", "KEY_FACE_TRACK", "KEY_FOREGROUND", "KEY_ID", "KEY_PARAMS", "KEY_SUBTITLE", "KEY_SUBTITLE_COLOR", "KEY_SUBTITLE_STROKE_COLOR", "KEY_VERSION", "TYPE_FACE_TRACK", "TYPE_FIXED", "TYPE_SEGMENT", "createByLocal", "Lcom/tencent/mm/sticker/StickerPack;", "packDir", "plugin-sticker_release"})
  public static final class a
  {
    public static e aWf(String paramString)
    {
      AppMethodBeat.i(202297);
      k.h(paramString, "packDir");
      e locale = new e();
      locale.aGZ(paramString);
      locale.aHa(paramString);
      AppMethodBeat.o(202297);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.e
 * JD-Core Version:    0.7.0.1
 */