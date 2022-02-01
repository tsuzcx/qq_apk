package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/StickerPack;", "", "()V", "additionStickers", "Ljava/util/ArrayList;", "Lcom/tencent/mm/sticker/StickerInfo;", "Lkotlin/collections/ArrayList;", "getAdditionStickers", "()Ljava/util/ArrayList;", "backgroundSticker", "getBackgroundSticker", "()Lcom/tencent/mm/sticker/StickerInfo;", "setBackgroundSticker", "(Lcom/tencent/mm/sticker/StickerInfo;)V", "faceTrackSticker", "getFaceTrackSticker", "setFaceTrackSticker", "foregroundSticker", "getForegroundSticker", "setForegroundSticker", "lensId", "", "getLensId", "()Ljava/lang/String;", "setLensId", "(Ljava/lang/String;)V", "resPath", "getResPath", "setResPath", "strokeColor", "getStrokeColor", "setStrokeColor", "title", "getTitle", "setTitle", "titleColor", "getTitleColor", "setTitleColor", "transform", "Lcom/tencent/mm/sticker/StickerTransform;", "getTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "setTransform", "(Lcom/tencent/mm/sticker/StickerTransform;)V", "version", "", "getVersion", "()D", "setVersion", "(D)V", "allElement", "", "Lcom/tencent/mm/sticker/StickerElement;", "isValid", "", "parseFromLocal", "", "packDir", "parseFromPack", "Companion", "plugin-sticker_release"})
public final class f
{
  public static final a NNw;
  private static final String TAG = "MicroMsg.StickerPack";
  private g NMS;
  public String NNr;
  public e NNs;
  public e NNt;
  public e NNu;
  public final ArrayList<e> NNv;
  private String cHM;
  public String iyd;
  double jgT;
  public String rnS;
  public String title;
  
  static
  {
    AppMethodBeat.i(105908);
    NNw = new a((byte)0);
    TAG = "MicroMsg.StickerPack";
    AppMethodBeat.o(105908);
  }
  
  public f()
  {
    AppMethodBeat.i(105907);
    this.rnS = "";
    this.cHM = "";
    this.title = "";
    this.iyd = "";
    this.NNr = "";
    this.NMS = new g();
    this.NNv = new ArrayList();
    AppMethodBeat.o(105907);
  }
  
  public final void bip(String paramString)
  {
    AppMethodBeat.i(105904);
    p.h(paramString, "<set-?>");
    this.cHM = paramString;
    AppMethodBeat.o(105904);
  }
  
  public final void biq(String paramString)
  {
    AppMethodBeat.i(105903);
    p.h(paramString, "<set-?>");
    this.rnS = paramString;
    AppMethodBeat.o(105903);
  }
  
  public final void bir(String paramString)
  {
    AppMethodBeat.i(105905);
    p.h(paramString, "packDir");
    for (;;)
    {
      try
      {
        Object localObject1 = h.FE(s.boY(paramString + "config.json"));
        Object localObject2 = ((JSONObject)localObject1).getString("id");
        p.g(localObject2, "jsonObj.getString(KEY_ID)");
        this.rnS = ((String)localObject2);
        this.jgT = ((JSONObject)localObject1).getDouble("version");
        localObject2 = ((JSONObject)localObject1).optString("subtitle");
        p.g(localObject2, "jsonObj.optString(KEY_SUBTITLE)");
        this.title = ((String)localObject2);
        localObject2 = ((JSONObject)localObject1).optString("subtitle_color");
        p.g(localObject2, "jsonObj.optString(KEY_SUBTITLE_COLOR)");
        this.iyd = ((String)localObject2);
        localObject2 = ((JSONObject)localObject1).optString("stroke_color");
        p.g(localObject2, "jsonObj.optString(KEY_SUBTITLE_STROKE_COLOR)");
        this.NNr = ((String)localObject2);
        Object localObject4 = ((JSONObject)localObject1).optString("face_track");
        Object localObject3 = ((JSONObject)localObject1).optString("background");
        localObject2 = ((JSONObject)localObject1).optString("foreground");
        localObject1 = ((JSONObject)localObject1).optString("addition");
        localObject4 = (CharSequence)localObject4;
        if (localObject4 != null)
        {
          if (((CharSequence)localObject4).length() == 0)
          {
            break label602;
            if (i == 0)
            {
              localObject4 = new e();
              ((e)localObject4).bip(paramString + "face_track/");
              a.a locala = a.NMI;
              a.a.a(((e)localObject4).cHM + "config.json", (a)localObject4);
              this.NNs = ((e)localObject4);
            }
            localObject3 = (CharSequence)localObject3;
            if (localObject3 == null) {
              break label607;
            }
            if (((CharSequence)localObject3).length() == 0)
            {
              break label607;
              if (i == 0)
              {
                localObject3 = new e();
                ((e)localObject3).bip(paramString + "background/");
                localObject4 = a.NMI;
                a.a.a(((e)localObject3).cHM + "config.json", (a)localObject3);
                this.NNt = ((e)localObject3);
              }
              localObject2 = (CharSequence)localObject2;
              if (localObject2 == null) {
                break label612;
              }
              if (((CharSequence)localObject2).length() != 0) {
                continue;
              }
              break label612;
              if (i == 0)
              {
                localObject2 = new e();
                ((e)localObject2).bip(paramString + "foreground/");
                localObject3 = a.NMI;
                a.a.a(((e)localObject2).cHM + "config.json", (a)localObject2);
                this.NNu = ((e)localObject2);
              }
              localObject2 = (b)b.NNx;
              localObject3 = (CharSequence)localObject1;
              if (localObject3 == null) {
                break label617;
              }
              if (((CharSequence)localObject3).length() != 0) {
                continue;
              }
              break label617;
              if (i != 0) {
                continue;
              }
              this.NNv.clear();
              this.NNv.addAll((Collection)((b)localObject2).invoke(paramString + (String)localObject1));
              AppMethodBeat.o(105905);
            }
          }
          else
          {
            i = 0;
            continue;
          }
          i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
        }
        i = 1;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace(TAG, (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(105905);
        return;
      }
      label602:
      continue;
      label607:
      int i = 1;
      continue;
      label612:
      i = 1;
      continue;
      label617:
      i = 1;
    }
  }
  
  public final void bis(String paramString)
  {
    AppMethodBeat.i(105906);
    p.h(paramString, "packDir");
    for (;;)
    {
      Object localObject7;
      int i;
      Object localObject8;
      Object localObject9;
      Object localObject10;
      try
      {
        paramString = h.FE(s.boY(paramString + "config.json"));
        Log.i(TAG, "parseFromPack: ".concat(String.valueOf(paramString)));
        this.jgT = paramString.getDouble("version");
        localObject1 = paramString.optJSONObject("custom");
        if (localObject1 != null)
        {
          localObject2 = ((JSONObject)localObject1).optString("subtitle");
          p.g(localObject2, "custom.optString(KEY_SUBTITLE)");
          this.title = ((String)localObject2);
          localObject2 = ((JSONObject)localObject1).optString("subtitle_color");
          p.g(localObject2, "custom.optString(KEY_SUBTITLE_COLOR)");
          this.iyd = ((String)localObject2);
          localObject1 = ((JSONObject)localObject1).optString("stroke_color");
          p.g(localObject1, "custom.optString(KEY_SUBTITLE_STROKE_COLOR)");
          this.NNr = ((String)localObject1);
        }
        paramString = paramString.getJSONObject("params");
        localObject1 = paramString.getJSONArray("elements");
        localObject7 = new HashMap();
        localObject6 = new HashMap();
        localObject5 = new HashMap();
        localObject4 = new HashMap();
        localObject3 = new HashMap();
        localObject2 = new HashMap();
        int j = ((JSONArray)localObject1).length();
        i = 0;
        if (i >= j) {
          break label464;
        }
        localObject8 = ((JSONArray)localObject1).getString(i);
        localObject9 = paramString.getJSONObject((String)localObject8);
        localObject10 = new d();
        p.g(localObject8, "name");
        ((d)localObject10).setName((String)localObject8);
        p.g(localObject9, "elementObj");
        ((d)localObject10).au((JSONObject)localObject9);
        switch (((d)localObject10).NMP)
        {
        case 0: 
          ((Map)localObject7).put(localObject8, localObject10);
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace(TAG, (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(105906);
        return;
      }
      ((Map)localObject5).put(localObject8, localObject10);
      break label1963;
      ((Map)localObject6).put(localObject8, localObject10);
      break label1963;
      ((Map)localObject4).put(localObject8, localObject10);
      break label1963;
      ((Map)localObject3).put(localObject8, localObject10);
      break label1963;
      ((Map)localObject2).put(localObject8, localObject10);
      break label1963;
      label464:
      paramString = paramString.optJSONObject("template_trans_set");
      if (paramString != null) {
        this.NMS.au(paramString);
      }
      paramString = new JSONObject();
      paramString.put("id", this.rnS).put("version", this.jgT).put("cache_version", 2).put("subtitle", this.title).put("subtitle_color", this.iyd).put("stroke_color", this.NNr);
      Object localObject1 = (m)new c(this);
      if (((HashMap)localObject7).size() > 0)
      {
        localObject8 = ((m)localObject1).invoke("Sticker2D", "face_track/");
        localObject9 = (e)localObject8;
        ((e)localObject9).a(this.NMS);
        s.boN(((e)localObject9).cHM);
        ((e)localObject9).s((HashMap)localObject7);
        localObject7 = ((Map)localObject7).entrySet().iterator();
        while (((Iterator)localObject7).hasNext())
        {
          localObject10 = (Map.Entry)((Iterator)localObject7).next();
          s.cL(this.cHM + (String)((Map.Entry)localObject10).getKey(), this.cHM + ((e)localObject9).cHM + (String)((Map.Entry)localObject10).getKey());
        }
        localObject7 = a.NMI;
        a.a.a((a)localObject9, this.cHM + ((e)localObject9).cHM + "config.json");
        paramString.put("face_track", ((e)localObject9).cHM);
        localObject7 = x.SXb;
        this.NNs = ((e)localObject8);
      }
      if (((HashMap)localObject6).size() > 0)
      {
        localObject7 = ((m)localObject1).invoke("Segment", "background/");
        localObject8 = (e)localObject7;
        s.boN(((e)localObject8).cHM);
        ((e)localObject8).s((HashMap)localObject6);
        localObject6 = ((Map)localObject6).entrySet().iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject9 = (Map.Entry)((Iterator)localObject6).next();
          s.cL(this.cHM + (String)((Map.Entry)localObject9).getKey(), this.cHM + ((e)localObject8).cHM + (String)((Map.Entry)localObject9).getKey());
        }
        localObject6 = a.NMI;
        a.a.a((a)localObject8, this.cHM + ((e)localObject8).cHM + "config.json");
        paramString.put("background", ((e)localObject8).cHM);
        localObject6 = x.SXb;
        this.NNt = ((e)localObject7);
      }
      if (((HashMap)localObject5).size() > 0)
      {
        localObject6 = ((m)localObject1).invoke("StickerFixed", "foreground/");
        localObject7 = (e)localObject6;
        s.boN(((e)localObject7).cHM);
        ((e)localObject7).s((HashMap)localObject5);
        localObject5 = ((Map)localObject5).entrySet().iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject8 = (Map.Entry)((Iterator)localObject5).next();
          s.cL(this.cHM + (String)((Map.Entry)localObject8).getKey(), this.cHM + ((e)localObject7).cHM + (String)((Map.Entry)localObject8).getKey());
        }
        localObject5 = a.NMI;
        a.a.a((a)localObject7, this.cHM + ((e)localObject7).cHM + "config.json");
        paramString.put("foreground", ((e)localObject7).cHM);
        localObject5 = x.SXb;
        this.NNu = ((e)localObject6);
      }
      this.NNv.clear();
      Object localObject5 = this.NNv;
      Object localObject6 = (Map)localObject4;
      Object localObject4 = (Collection)new ArrayList(((Map)localObject6).size());
      localObject6 = ((Map)localObject6).entrySet().iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject8 = (Map.Entry)((Iterator)localObject6).next();
        localObject7 = ((m)localObject1).invoke("FaceDeformation", this.cHM + "addition/" + (String)((Map.Entry)localObject8).getKey());
        localObject9 = (e)localObject7;
        s.cL(this.cHM + (String)((Map.Entry)localObject8).getKey(), ((e)localObject9).cHM);
        localObject8 = x.SXb;
        ((Collection)localObject4).add((e)localObject7);
      }
      ((ArrayList)localObject5).addAll((Collection)localObject4);
      localObject4 = this.NNv;
      localObject5 = (Map)localObject3;
      Object localObject3 = (Collection)new ArrayList(((Map)localObject5).size());
      localObject5 = ((Map)localObject5).entrySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject7 = (Map.Entry)((Iterator)localObject5).next();
        localObject6 = ((m)localObject1).invoke("FaceLiquify", this.cHM + "addition/" + (String)((Map.Entry)localObject7).getKey());
        localObject8 = (e)localObject6;
        s.cL(this.cHM + (String)((Map.Entry)localObject7).getKey(), ((e)localObject8).cHM);
        localObject7 = x.SXb;
        ((Collection)localObject3).add((e)localObject6);
      }
      ((ArrayList)localObject4).addAll((Collection)localObject3);
      localObject3 = this.NNv;
      localObject4 = (Map)localObject2;
      Object localObject2 = (Collection)new ArrayList(((Map)localObject4).size());
      localObject4 = ((Map)localObject4).entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject6 = (Map.Entry)((Iterator)localObject4).next();
        localObject5 = ((m)localObject1).invoke("Sticker3D", this.cHM + "addition/" + (String)((Map.Entry)localObject6).getKey());
        localObject7 = (e)localObject5;
        s.cL(this.cHM + (String)((Map.Entry)localObject6).getKey(), ((e)localObject7).cHM);
        localObject6 = x.SXb;
        ((Collection)localObject2).add((e)localObject5);
      }
      ((ArrayList)localObject3).addAll((Collection)localObject2);
      if (this.NNv.size() > 0) {
        paramString.put("addition", "addition/");
      }
      localObject1 = this.cHM + "config.json";
      paramString = paramString.toString();
      p.g(paramString, "saveJson.toString()");
      localObject2 = kotlin.n.d.UTF_8;
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(105906);
        throw paramString;
      }
      paramString = paramString.getBytes((Charset)localObject2);
      p.g(paramString, "(this as java.lang.String).getBytes(charset)");
      s.C((String)localObject1, paramString);
      AppMethodBeat.o(105906);
      return;
      label1963:
      i += 1;
    }
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(194221);
    if ((this.NNs != null) || (this.NNt != null) || (this.NNu != null) || (this.NNv.size() > 0))
    {
      AppMethodBeat.o(194221);
      return true;
    }
    AppMethodBeat.o(194221);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/StickerPack$Companion;", "", "()V", "ADDITION_DIR", "", "BACKGROUND_DIR", "CLIENT_CACHE_VERSION", "", "CONFIG_FILE", "FACE_TRACK_DIR", "FOREGROUND_DIR", "KEY_ADDITION", "KEY_BACKGROUND", "KEY_CACHE_VERSION", "KEY_CUSTOM", "KEY_ELEMENTS", "KEY_FACE_TRACK", "KEY_FOREGROUND", "KEY_ID", "KEY_PARAMS", "KEY_SUBTITLE", "KEY_SUBTITLE_COLOR", "KEY_SUBTITLE_STROKE_COLOR", "KEY_VERSION", "TAG", "TYPE_3D", "TYPE_DEFORMATION", "TYPE_FACE_TRACK", "TYPE_FIXED", "TYPE_LIQUIFY", "TYPE_SEGMENT", "checkLocalCacheVersion", "", "packDir", "createByLocal", "Lcom/tencent/mm/sticker/StickerPack;", "plugin-sticker_release"})
  public static final class a
  {
    public static f bit(String paramString)
    {
      AppMethodBeat.i(194216);
      p.h(paramString, "packDir");
      f localf = new f();
      localf.bip(paramString);
      localf.bir(paramString);
      AppMethodBeat.o(194216);
      return localf;
    }
    
    public static boolean biu(String paramString)
    {
      AppMethodBeat.i(194217);
      p.h(paramString, "packDir");
      try
      {
        if (!s.YS(paramString + "config.json"))
        {
          AppMethodBeat.o(194217);
          return false;
        }
        int i = h.FE(s.boY(paramString + "config.json")).optInt("cache_version", 0);
        Log.i(f.access$getTAG$cp(), "checkLocalCacheVersion: " + i + ", 2");
        if (i >= 2)
        {
          AppMethodBeat.o(194217);
          return true;
        }
        s.deleteDir(paramString);
        AppMethodBeat.o(194217);
        return false;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(194217);
      }
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/mm/sticker/StickerInfo;", "path", "", "invoke"})
  static final class b
    extends q
    implements b<String, List<? extends e>>
  {
    public static final b NNx;
    
    static
    {
      AppMethodBeat.i(194219);
      NNx = new b();
      AppMethodBeat.o(194219);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/sticker/StickerInfo;", "type", "", "path", "invoke"})
  static final class c
    extends q
    implements m<String, String, e>
  {
    c(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.f
 * JD-Core Version:    0.7.0.1
 */