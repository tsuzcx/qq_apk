package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.a;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.xlabeffect.k;
import com.tencent.mm.plugin.xlabeffect.k.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/filter/VirtualBackgroundFilter;", "", "()V", "ACTION_CLEAR", "", "ACTION_SET_BLUR", "ACTION_SET_IMAGE", "ACTION_SET_VIDEO", "TAG", "", "deviceOrientation", "isInitGL", "", "segmentMode", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect$SegmentMode;", "uiOrientation", "usageDetails", "Lorg/json/JSONArray;", "getUsageDetails", "()Lorg/json/JSONArray;", "setUsageDetails", "(Lorg/json/JSONArray;)V", "attach", "", "clearSettings", "passive", "detach", "getFaceTrackOrientation", "orientation", "hasSetVirtualBackground", "initRenderProc", "markOrientation", "recordAction", "action", "finderObjectId", "render", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "drawWidth", "drawHeight", "setFinder", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setImage", "bitmap", "Landroid/graphics/Bitmap;", "imagePath", "setSegmentBgBlur", "mode", "setVideo", "videoPath", "usageInfo", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final String TAG;
  private static int UNd;
  public static final d UPM;
  public static k.e UPN;
  public static boolean UPO;
  public static JSONArray UPP;
  private static int akjn;
  
  static
  {
    AppMethodBeat.i(292944);
    UPM = new d();
    TAG = "MicroMsg.VirtualBackgroundFilter";
    UPP = new JSONArray();
    AppMethodBeat.o(292944);
  }
  
  public static void GT(boolean paramBoolean)
  {
    AppMethodBeat.i(292905);
    if (!paramBoolean) {
      arr(2);
    }
    UPN = null;
    AppMethodBeat.o(292905);
  }
  
  public static void S(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(292921);
    s.u(paramFinderObject, "finderObject");
    AppMethodBeat.o(292921);
  }
  
  public static void a(k paramk)
  {
    AppMethodBeat.i(292924);
    s.u(paramk, "xLabEffect");
    k.e locale = UPN;
    if (locale != null) {
      paramk.a(true, locale);
    }
    while (locale != null)
    {
      paramk.Jo(true);
      AppMethodBeat.o(292924);
      return;
      paramk.a(false, k.e.XLS);
    }
    paramk.Jo(false);
    AppMethodBeat.o(292924);
  }
  
  public static int aNE(int paramInt)
  {
    AppMethodBeat.i(369827);
    Object localObject = SubCoreVoip.hVp();
    int i;
    if (localObject != null)
    {
      localObject = ((u)localObject).UBF;
      if ((localObject != null) && (!((a)localObject).hVn()))
      {
        i = 1;
        if (i != 0) {
          break label67;
        }
        paramInt -= UNd;
      }
    }
    for (;;)
    {
      paramInt += akjn;
      for (;;)
      {
        i = paramInt;
        if (paramInt >= 0) {
          break;
        }
        paramInt += 360;
      }
      i = 0;
      break;
      label67:
      paramInt = UNd + paramInt;
    }
    while (i >= 360) {
      i -= 360;
    }
    AppMethodBeat.o(369827);
    return i;
  }
  
  private static void arr(int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(292931);
    try
    {
      JSONArray localJSONArray = UPP;
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("action", paramInt);
      Object localObject2 = SubCoreVoip.hVp();
      if (localObject2 == null) {}
      for (;;)
      {
        localJSONObject.put("isFront", localObject1);
        localJSONObject.put("timeStamp", System.currentTimeMillis());
        localObject1 = ah.aiuX;
        localObject1 = localJSONArray.put(localJSONObject);
        s.s(localObject1, "usageDetails.put(\n      …          }\n            )");
        UPP = (JSONArray)localObject1;
        AppMethodBeat.o(292931);
        return;
        localObject2 = ((u)localObject2).UBF;
        if (localObject2 != null)
        {
          boolean bool = ((a)localObject2).hVn();
          localObject1 = Boolean.valueOf(bool);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e(TAG, s.X("recordAction fail: ", localException.getLocalizedMessage()));
      AppMethodBeat.o(292931);
    }
  }
  
  public static void bfQ(String paramString)
  {
    AppMethodBeat.i(292918);
    s.u(paramString, "videoPath");
    AppMethodBeat.o(292918);
  }
  
  public static JSONArray icR()
  {
    return UPP;
  }
  
  public static boolean icS()
  {
    return UPN != null;
  }
  
  public static String icU()
  {
    AppMethodBeat.i(292941);
    long l3 = 0L;
    int j = 2;
    long l4 = 0L;
    int k = 0;
    long l2 = l3;
    for (;;)
    {
      int m;
      boolean bool1;
      int i;
      boolean bool2;
      try
      {
        m = UPP.length();
        l1 = l3;
        if (m > 0)
        {
          bool1 = true;
          l4 = 0L;
          i = 2;
          j = k;
          l1 = l3;
          k = j + 1;
          l2 = l1;
          localObject = UPP.getJSONObject(j);
          l2 = l1;
          j = ((JSONObject)localObject).getInt("action");
          l2 = l1;
          l3 = ((JSONObject)localObject).getLong("timeStamp");
          l2 = l1;
          bool2 = ((JSONObject)localObject).getBoolean("isFront");
          if (bool2 == bool1) {
            continue;
          }
          l2 = l1;
          if (i == 2) {
            break label321;
          }
          l2 = l1 + (l3 - l4);
          break label321;
        }
        l2 = l1;
        if (j != 2)
        {
          l2 = l1;
          l3 = System.currentTimeMillis();
          l2 = l1 + (l3 - l4);
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        Log.e(TAG, s.X("report usageInfo fail: ", localException.getLocalizedMessage()));
        continue;
      }
      localObject = new JSONObject();
      ((JSONObject)localObject).put("details", UPP);
      ((JSONObject)localObject).put("totalUseDurationMs", l2);
      localObject = ((JSONObject)localObject).toString();
      s.s(localObject, "JSONObject().apply {\n   …nMs)\n        }.toString()");
      localObject = n.jP(n.bV((String)localObject, ",", ";"), 1024);
      AppMethodBeat.o(292941);
      return localObject;
      if (j == 2)
      {
        l2 = l1 + (l3 - l4);
        l3 = l4;
      }
      else
      {
        l2 = l1;
        if (i != 2)
        {
          label265:
          l3 = l4;
          l2 = l1;
        }
      }
      label321:
      while (k < m)
      {
        i = k;
        bool1 = bool2;
        k = j;
        l1 = l2;
        j = i;
        l4 = l3;
        i = k;
        break;
        l1 = l2;
        if (j == 2) {
          break label265;
        }
      }
      long l1 = l2;
      l4 = l3;
    }
  }
  
  public static void nU(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (paramInt1 == 0)
    {
      paramInt1 = 0;
      UNd = paramInt1;
      paramInt1 = i;
      switch (paramInt2)
      {
      default: 
        paramInt1 = i;
      }
    }
    for (;;)
    {
      akjn = paramInt1;
      return;
      paramInt1 = 360 - paramInt1;
      break;
      paramInt1 = 90;
      continue;
      paramInt1 = 180;
      continue;
      paramInt1 = 270;
    }
  }
  
  public static void setImage(String paramString)
  {
    AppMethodBeat.i(292916);
    s.u(paramString, "imagePath");
    AppMethodBeat.o(292916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.d
 * JD-Core Version:    0.7.0.1
 */