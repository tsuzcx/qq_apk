package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/StickerPack;", "", "()V", "additionStickers", "Ljava/util/ArrayList;", "Lcom/tencent/mm/sticker/StickerInfo;", "Lkotlin/collections/ArrayList;", "getAdditionStickers", "()Ljava/util/ArrayList;", "backgroundSticker", "getBackgroundSticker", "()Lcom/tencent/mm/sticker/StickerInfo;", "setBackgroundSticker", "(Lcom/tencent/mm/sticker/StickerInfo;)V", "faceTrackSticker", "getFaceTrackSticker", "setFaceTrackSticker", "foregroundSticker", "getForegroundSticker", "setForegroundSticker", "lensId", "", "getLensId", "()Ljava/lang/String;", "setLensId", "(Ljava/lang/String;)V", "resPath", "getResPath", "setResPath", "strokeColor", "getStrokeColor", "setStrokeColor", "title", "getTitle", "setTitle", "titleColor", "getTitleColor", "setTitleColor", "transform", "Lcom/tencent/mm/sticker/StickerTransform;", "getTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "setTransform", "(Lcom/tencent/mm/sticker/StickerTransform;)V", "version", "", "getVersion", "()D", "setVersion", "(D)V", "allElement", "", "Lcom/tencent/mm/sticker/StickerElement;", "isValid", "", "parseFromLocal", "", "packDir", "parseFromPack", "Companion", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final String TAG;
  public static final a acCu;
  private g acBW;
  public String acCv;
  public e acCw;
  public e acCx;
  public e acCy;
  public final ArrayList<e> acCz;
  double dFr;
  private String eBX;
  public String nSx;
  public String title;
  public String ygo;
  
  static
  {
    AppMethodBeat.i(105908);
    acCu = new a((byte)0);
    TAG = "MicroMsg.StickerPack";
    AppMethodBeat.o(105908);
  }
  
  public f()
  {
    AppMethodBeat.i(105907);
    this.ygo = "";
    this.eBX = "";
    this.title = "";
    this.nSx = "";
    this.acCv = "";
    this.acBW = new g();
    this.acCz = new ArrayList();
    AppMethodBeat.o(105907);
  }
  
  public final void buM(String paramString)
  {
    AppMethodBeat.i(105904);
    s.u(paramString, "<set-?>");
    this.eBX = paramString;
    AppMethodBeat.o(105904);
  }
  
  public final void buN(String paramString)
  {
    AppMethodBeat.i(105903);
    s.u(paramString, "<set-?>");
    this.ygo = paramString;
    AppMethodBeat.o(105903);
  }
  
  public final void buO(String paramString)
  {
    AppMethodBeat.i(105905);
    s.u(paramString, "packDir");
    for (;;)
    {
      try
      {
        Object localObject1 = h.Fn(y.bEn(s.X(paramString, "config.json")));
        Object localObject2 = ((JSONObject)localObject1).getString("id");
        s.s(localObject2, "jsonObj.getString(KEY_ID)");
        this.ygo = ((String)localObject2);
        this.dFr = ((JSONObject)localObject1).getDouble("version");
        localObject2 = ((JSONObject)localObject1).optString("subtitle");
        s.s(localObject2, "jsonObj.optString(KEY_SUBTITLE)");
        this.title = ((String)localObject2);
        localObject2 = ((JSONObject)localObject1).optString("subtitle_color");
        s.s(localObject2, "jsonObj.optString(KEY_SUBTITLE_COLOR)");
        this.nSx = ((String)localObject2);
        localObject2 = ((JSONObject)localObject1).optString("stroke_color");
        s.s(localObject2, "jsonObj.optString(KEY_SUBTITLE_STROKE_COLOR)");
        this.acCv = ((String)localObject2);
        Object localObject4 = ((JSONObject)localObject1).optString("face_track");
        Object localObject3 = ((JSONObject)localObject1).optString("background");
        localObject2 = ((JSONObject)localObject1).optString("foreground");
        localObject1 = ((JSONObject)localObject1).optString("addition");
        localObject4 = (CharSequence)localObject4;
        if (localObject4 != null)
        {
          if (((CharSequence)localObject4).length() == 0)
          {
            break label514;
            if (i == 0)
            {
              localObject4 = new e();
              ((e)localObject4).buM(s.X(paramString, "face_track/"));
              Object localObject5 = a.acBM;
              a.a.a(s.X(((e)localObject4).eBX, "config.json"), (a)localObject4);
              localObject5 = ah.aiuX;
              this.acCw = ((e)localObject4);
            }
            localObject3 = (CharSequence)localObject3;
            if (localObject3 == null) {
              break label519;
            }
            if (((CharSequence)localObject3).length() == 0)
            {
              break label519;
              if (i == 0)
              {
                localObject3 = new e();
                ((e)localObject3).buM(s.X(paramString, "background/"));
                localObject4 = a.acBM;
                a.a.a(s.X(((e)localObject3).eBX, "config.json"), (a)localObject3);
                localObject4 = ah.aiuX;
                this.acCx = ((e)localObject3);
              }
              localObject2 = (CharSequence)localObject2;
              if (localObject2 == null) {
                break label524;
              }
              if (((CharSequence)localObject2).length() != 0) {
                continue;
              }
              break label524;
              if (i == 0)
              {
                localObject2 = new e();
                ((e)localObject2).buM(s.X(paramString, "foreground/"));
                localObject3 = a.acBM;
                a.a.a(s.X(((e)localObject2).eBX, "config.json"), (a)localObject2);
                localObject3 = ah.aiuX;
                this.acCy = ((e)localObject2);
              }
              localObject2 = (b)b.acCA;
              localObject3 = (CharSequence)localObject1;
              if (localObject3 == null) {
                break label529;
              }
              if (((CharSequence)localObject3).length() != 0) {
                continue;
              }
              break label529;
              if (i != 0) {
                continue;
              }
              this.acCz.clear();
              this.acCz.addAll((Collection)((b)localObject2).invoke(s.X(paramString, localObject1)));
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
      label514:
      continue;
      label519:
      int i = 1;
      continue;
      label524:
      i = 1;
      continue;
      label529:
      i = 1;
    }
  }
  
  public final void buP(String paramString)
  {
    AppMethodBeat.i(105906);
    s.u(paramString, "packDir");
    for (;;)
    {
      int i;
      int k;
      int j;
      Object localObject8;
      Object localObject9;
      Object localObject10;
      try
      {
        paramString = h.Fn(y.bEn(s.X(paramString, "config.json")));
        Log.i(TAG, s.X("parseFromPack: ", paramString));
        this.dFr = paramString.getDouble("version");
        localObject1 = paramString.optJSONObject("custom");
        if (localObject1 != null)
        {
          localObject2 = ((JSONObject)localObject1).optString("subtitle");
          s.s(localObject2, "custom.optString(KEY_SUBTITLE)");
          this.title = ((String)localObject2);
          localObject2 = ((JSONObject)localObject1).optString("subtitle_color");
          s.s(localObject2, "custom.optString(KEY_SUBTITLE_COLOR)");
          this.nSx = ((String)localObject2);
          localObject1 = ((JSONObject)localObject1).optString("stroke_color");
          s.s(localObject1, "custom.optString(KEY_SUBTITLE_STROKE_COLOR)");
          this.acCv = ((String)localObject1);
        }
        paramString = paramString.getJSONObject("params");
        localObject1 = paramString.getJSONArray("elements");
        localObject7 = new HashMap();
        localObject6 = new HashMap();
        localObject5 = new HashMap();
        localObject4 = new HashMap();
        localObject3 = new HashMap();
        localObject2 = new HashMap();
        i = 0;
        k = ((JSONArray)localObject1).length();
        if (k > 0)
        {
          j = i + 1;
          localObject8 = ((JSONArray)localObject1).getString(i);
          localObject9 = paramString.getJSONObject((String)localObject8);
          localObject10 = new d();
          s.s(localObject8, "name");
          ((d)localObject10).setName((String)localObject8);
          s.s(localObject9, "elementObj");
          ((d)localObject10).G((JSONObject)localObject9);
        }
        switch (((d)localObject10).acBS)
        {
        case 0: 
          paramString = paramString.optJSONObject("template_trans_set");
          if (paramString != null) {
            this.acBW.G(paramString);
          }
          paramString = new JSONObject();
          paramString.put("id", this.ygo).put("version", this.dFr).put("cache_version", 2).put("subtitle", this.title).put("subtitle_color", this.nSx).put("stroke_color", this.acCv);
          localObject1 = (m)new c(this);
          if (((HashMap)localObject7).size() <= 0) {
            break label769;
          }
          localObject8 = ((m)localObject1).invoke("Sticker2D", "face_track/");
          localObject9 = (e)localObject8;
          ((e)localObject9).a(this.acBW);
          y.bDX(((e)localObject9).eBX);
          ((e)localObject9).y((HashMap)localObject7);
          localObject7 = ((Map)localObject7).entrySet().iterator();
          if (!((Iterator)localObject7).hasNext()) {
            break label700;
          }
          localObject10 = (Map.Entry)((Iterator)localObject7).next();
          y.qp(s.X(this.eBX, ((Map.Entry)localObject10).getKey()), this.eBX + ((e)localObject9).eBX + (String)((Map.Entry)localObject10).getKey());
          continue;
          ((Map)localObject7).put(localObject8, localObject10);
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace(TAG, (Throwable)paramString, "", new Object[0]);
        AppMethodBeat.o(105906);
        return;
      }
      break label1823;
      ((Map)localObject5).put(localObject8, localObject10);
      break label1823;
      ((Map)localObject6).put(localObject8, localObject10);
      break label1823;
      ((Map)localObject4).put(localObject8, localObject10);
      break label1823;
      ((Map)localObject3).put(localObject8, localObject10);
      break label1823;
      ((Map)localObject2).put(localObject8, localObject10);
      break label1823;
      label700:
      Object localObject7 = a.acBM;
      a.a.a((a)localObject9, this.eBX + ((e)localObject9).eBX + "config.json");
      paramString.put("face_track", ((e)localObject9).eBX);
      localObject7 = ah.aiuX;
      this.acCw = ((e)localObject8);
      label769:
      if (((HashMap)localObject6).size() > 0)
      {
        localObject7 = ((m)localObject1).invoke("Segment", "background/");
        localObject8 = (e)localObject7;
        y.bDX(((e)localObject8).eBX);
        ((e)localObject8).y((HashMap)localObject6);
        localObject6 = ((Map)localObject6).entrySet().iterator();
        while (((Iterator)localObject6).hasNext())
        {
          localObject9 = (Map.Entry)((Iterator)localObject6).next();
          y.qp(s.X(this.eBX, ((Map.Entry)localObject9).getKey()), this.eBX + ((e)localObject8).eBX + (String)((Map.Entry)localObject9).getKey());
        }
        localObject6 = a.acBM;
        a.a.a((a)localObject8, this.eBX + ((e)localObject8).eBX + "config.json");
        paramString.put("background", ((e)localObject8).eBX);
        localObject6 = ah.aiuX;
        this.acCx = ((e)localObject7);
      }
      if (((HashMap)localObject5).size() > 0)
      {
        localObject6 = ((m)localObject1).invoke("StickerFixed", "foreground/");
        localObject7 = (e)localObject6;
        y.bDX(((e)localObject7).eBX);
        ((e)localObject7).y((HashMap)localObject5);
        localObject5 = ((Map)localObject5).entrySet().iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject8 = (Map.Entry)((Iterator)localObject5).next();
          y.qp(s.X(this.eBX, ((Map.Entry)localObject8).getKey()), this.eBX + ((e)localObject7).eBX + (String)((Map.Entry)localObject8).getKey());
        }
        localObject5 = a.acBM;
        a.a.a((a)localObject7, this.eBX + ((e)localObject7).eBX + "config.json");
        paramString.put("foreground", ((e)localObject7).eBX);
        localObject5 = ah.aiuX;
        this.acCy = ((e)localObject6);
      }
      this.acCz.clear();
      Object localObject5 = this.acCz;
      Object localObject6 = (Map)localObject4;
      Object localObject4 = (Collection)new ArrayList(((Map)localObject6).size());
      localObject6 = ((Map)localObject6).entrySet().iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject8 = (Map.Entry)((Iterator)localObject6).next();
        localObject7 = ((m)localObject1).invoke("FaceDeformation", this.eBX + "addition/" + (String)((Map.Entry)localObject8).getKey());
        localObject9 = (e)localObject7;
        y.qp(s.X(this.eBX, ((Map.Entry)localObject8).getKey()), ((e)localObject9).eBX);
        localObject8 = ah.aiuX;
        ((Collection)localObject4).add((e)localObject7);
      }
      ((ArrayList)localObject5).addAll((Collection)localObject4);
      localObject4 = this.acCz;
      localObject5 = (Map)localObject3;
      Object localObject3 = (Collection)new ArrayList(((Map)localObject5).size());
      localObject5 = ((Map)localObject5).entrySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject7 = (Map.Entry)((Iterator)localObject5).next();
        localObject6 = ((m)localObject1).invoke("FaceLiquify", this.eBX + "addition/" + (String)((Map.Entry)localObject7).getKey());
        localObject8 = (e)localObject6;
        y.qp(s.X(this.eBX, ((Map.Entry)localObject7).getKey()), ((e)localObject8).eBX);
        localObject7 = ah.aiuX;
        ((Collection)localObject3).add((e)localObject6);
      }
      ((ArrayList)localObject4).addAll((Collection)localObject3);
      localObject3 = this.acCz;
      localObject4 = (Map)localObject2;
      Object localObject2 = (Collection)new ArrayList(((Map)localObject4).size());
      localObject4 = ((Map)localObject4).entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject6 = (Map.Entry)((Iterator)localObject4).next();
        localObject5 = ((m)localObject1).invoke("Sticker3D", this.eBX + "addition/" + (String)((Map.Entry)localObject6).getKey());
        localObject7 = (e)localObject5;
        y.qp(s.X(this.eBX, ((Map.Entry)localObject6).getKey()), ((e)localObject7).eBX);
        localObject6 = ah.aiuX;
        ((Collection)localObject2).add((e)localObject5);
      }
      ((ArrayList)localObject3).addAll((Collection)localObject2);
      if (this.acCz.size() > 0) {
        paramString.put("addition", "addition/");
      }
      Object localObject1 = s.X(this.eBX, "config.json");
      paramString = paramString.toString();
      s.s(paramString, "saveJson.toString()");
      paramString = paramString.getBytes(kotlin.n.d.UTF_8);
      s.s(paramString, "(this as java.lang.String).getBytes(charset)");
      y.f((String)localObject1, paramString, paramString.length);
      AppMethodBeat.o(105906);
      label1823:
      while (j < k)
      {
        i = j;
        break;
      }
    }
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(233914);
    if ((this.acCw != null) || (this.acCx != null) || (this.acCy != null) || (this.acCz.size() > 0))
    {
      AppMethodBeat.o(233914);
      return true;
    }
    AppMethodBeat.o(233914);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/StickerPack$Companion;", "", "()V", "ADDITION_DIR", "", "BACKGROUND_DIR", "CLIENT_CACHE_VERSION", "", "CONFIG_FILE", "FACE_TRACK_DIR", "FOREGROUND_DIR", "KEY_ADDITION", "KEY_BACKGROUND", "KEY_CACHE_VERSION", "KEY_CUSTOM", "KEY_ELEMENTS", "KEY_FACE_TRACK", "KEY_FOREGROUND", "KEY_ID", "KEY_PARAMS", "KEY_SUBTITLE", "KEY_SUBTITLE_COLOR", "KEY_SUBTITLE_STROKE_COLOR", "KEY_VERSION", "TAG", "TYPE_3D", "TYPE_DEFORMATION", "TYPE_FACE_TRACK", "TYPE_FIXED", "TYPE_LIQUIFY", "TYPE_SEGMENT", "checkLocalCacheVersion", "", "packDir", "createByLocal", "Lcom/tencent/mm/sticker/StickerPack;", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static f buQ(String paramString)
    {
      AppMethodBeat.i(233862);
      s.u(paramString, "packDir");
      f localf = new f();
      localf.buM(paramString);
      localf.buO(paramString);
      AppMethodBeat.o(233862);
      return localf;
    }
    
    public static boolean buR(String paramString)
    {
      AppMethodBeat.i(233866);
      s.u(paramString, "packDir");
      try
      {
        if (!y.ZC(s.X(paramString, "config.json")))
        {
          AppMethodBeat.o(233866);
          return false;
        }
        int i = h.Fn(y.bEn(s.X(paramString, "config.json"))).optInt("cache_version", 0);
        Log.i(f.access$getTAG$cp(), "checkLocalCacheVersion: " + i + ", 2");
        if (i >= 2)
        {
          AppMethodBeat.o(233866);
          return true;
        }
        y.ew(paramString, true);
        AppMethodBeat.o(233866);
        return false;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(233866);
      }
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/sticker/StickerInfo;", "path", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements b<String, List<? extends e>>
  {
    public static final b acCA;
    
    static
    {
      AppMethodBeat.i(233864);
      acCA = new b();
      AppMethodBeat.o(233864);
    }
    
    b()
    {
      super();
    }
    
    private static List<e> buS(String paramString)
    {
      int j = 1;
      AppMethodBeat.i(233859);
      s.u(paramString, "path");
      String[] arrayOfString = new com.tencent.mm.vfs.u(paramString).jKW();
      if (arrayOfString != null)
      {
        int i;
        if (arrayOfString.length == 0)
        {
          i = 1;
          if (i != 0) {
            break label158;
          }
          i = j;
        }
        label158:
        for (;;)
        {
          label42:
          if (i != 0)
          {
            Collection localCollection = (Collection)new ArrayList(arrayOfString.length);
            j = arrayOfString.length;
            i = 0;
            for (;;)
            {
              if (i < j)
              {
                Object localObject = arrayOfString[i];
                e locale = new e();
                locale.buM(paramString + localObject + '/');
                localObject = a.acBM;
                a.a.a(s.X(locale.eBX, "config.json"), (a)locale);
                localCollection.add(locale);
                i += 1;
                continue;
                i = 0;
                break;
                i = 0;
                break label42;
              }
            }
            paramString = (List)localCollection;
            AppMethodBeat.o(233859);
            return paramString;
          }
        }
      }
      paramString = (List)ab.aivy;
      AppMethodBeat.o(233859);
      return paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sticker/StickerInfo;", "type", "", "path"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements m<String, String, e>
  {
    c(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.f
 * JD-Core Version:    0.7.0.1
 */