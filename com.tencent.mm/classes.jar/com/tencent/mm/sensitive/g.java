package com.tencent.mm.sensitive;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/MicrophoneHooker;", "", "()V", "TAG", "", "mAudioMediaMethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "mAudioMediaMethodMap2", "monitor", "", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  private static final String TAG;
  public static final g actM;
  private static final HashMap<String, List<Pair<String, String>>> actN;
  private static final HashMap<String, List<Pair<String, String>>> actO;
  
  static
  {
    AppMethodBeat.i(240911);
    actM = new g();
    TAG = "MicrophoneHooker";
    actN = new HashMap();
    actO = new HashMap();
    AppMethodBeat.o(240911);
  }
  
  public static void ayW()
  {
    AppMethodBeat.i(240902);
    Map localMap = (Map)actN;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("startRecording", "()V"));
    localMap.put("android/media/AudioRecord", localArrayList);
    localMap = (Map)actO;
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("startLocalAudio", "()V"));
    localMap.put("com/tencent/trtc/TRTCCloud", localArrayList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)actN, g..ExternalSyntheticLambda0.INSTANCE);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)actO, g..ExternalSyntheticLambda1.INSTANCE);
    AppMethodBeat.o(240902);
  }
  
  private static final Object c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(240908);
    Log.i(TAG, "HookMicroPhone");
    paramString1 = com.tencent.mm.sensitive.ui.a.acvO;
    if (!com.tencent.mm.sensitive.ui.a.iUw())
    {
      paramString1 = com.tencent.mm.sensitive.ui.a.acvO;
      s.s(paramString4, "methodName");
      if (com.tencent.mm.sensitive.ui.a.bus(paramString4))
      {
        AppMethodBeat.o(240908);
        return null;
      }
    }
    paramObject.getClass().getMethod(paramString4, new Class[0]).invoke(paramObject, new Object[0]);
    AppMethodBeat.o(240908);
    return null;
  }
  
  private static final Object d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(240906);
    Log.i(TAG, "HookMicroPhone");
    paramString1 = com.tencent.mm.sensitive.ui.a.acvO;
    if (!com.tencent.mm.sensitive.ui.a.iUw())
    {
      paramString1 = com.tencent.mm.sensitive.ui.a.acvO;
      s.s(paramString4, "methodName");
      if (com.tencent.mm.sensitive.ui.a.bus(paramString4))
      {
        AppMethodBeat.o(240906);
        return null;
      }
    }
    paramObject.getClass().getMethod(paramString4, new Class[0]).invoke(paramObject, new Object[0]);
    AppMethodBeat.o(240906);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sensitive.g
 * JD-Core Version:    0.7.0.1
 */