package com.tencent.mm.sensitive;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.os.Handler;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/CameraHooker;", "", "()V", "TAG", "", "camera1MethodMap", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "camera2MethodMap", "goSysCameraMethodMap", "monitor", "", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final String TAG;
  public static final a acsv;
  private static final HashMap<String, List<Pair<String, String>>> acsw;
  private static final HashMap<String, List<Pair<String, String>>> acsx;
  private static final HashMap<String, List<Pair<String, String>>> acsy;
  
  static
  {
    AppMethodBeat.i(240932);
    acsv = new a();
    TAG = "CameraHooker";
    acsw = new HashMap();
    acsx = new HashMap();
    acsy = new HashMap();
    AppMethodBeat.o(240932);
  }
  
  private static final Object a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(240924);
    paramString1 = com.tencent.mm.sensitive.ui.a.acvO;
    if (!com.tencent.mm.sensitive.ui.a.iUw())
    {
      if (paramArrayOfObject == null)
      {
        paramString1 = null;
        if (paramString1 != null) {
          break label177;
        }
        paramString2 = "";
        label29:
        if (!s.p(paramString2, "android.media.action.IMAGE_CAPTURE")) {
          break label194;
        }
      }
      for (;;)
      {
        if (paramString1 == null) {
          break label199;
        }
        com.tencent.mm.sdk.platformtools.Log.i(TAG, "[CameraHooker] going to sys camera");
        paramString1 = com.tencent.mm.sensitive.ui.a.acvO;
        if (!com.tencent.mm.sensitive.ui.a.bus("openSysCamera")) {
          break label199;
        }
        AppMethodBeat.o(240924);
        return null;
        if (paramArrayOfObject.length == 0)
        {
          i = 1;
          label78:
          if (i != 0) {
            break label127;
          }
          i = 1;
          label86:
          if ((i == 0) || (!(paramArrayOfObject[0] instanceof Intent))) {
            break label133;
          }
          i = 1;
          label104:
          if (i == 0) {
            break label139;
          }
        }
        label133:
        label139:
        for (paramString1 = paramArrayOfObject;; paramString1 = null)
        {
          if (paramString1 != null) {
            break label144;
          }
          paramString1 = null;
          break;
          i = 0;
          break label78;
          label127:
          i = 0;
          break label86;
          i = 0;
          break label104;
        }
        label144:
        paramString1 = paramString1[0];
        if (paramString1 == null)
        {
          paramString1 = new NullPointerException("null cannot be cast to non-null type android.content.Intent");
          AppMethodBeat.o(240924);
          throw paramString1;
        }
        paramString1 = (Intent)paramString1;
        break;
        label177:
        paramString3 = paramString1.getAction();
        paramString2 = paramString3;
        if (paramString3 != null) {
          break label29;
        }
        paramString2 = "";
        break label29;
        label194:
        paramString1 = null;
      }
    }
    label199:
    paramString1 = paramArrayOfObject[0];
    if (paramString1 == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type android.content.Intent");
      AppMethodBeat.o(240924);
      throw paramString1;
    }
    paramString1 = (Intent)paramString1;
    paramString2 = paramArrayOfObject[1];
    if (paramString2 == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(240924);
      throw paramString1;
    }
    int i = ((Integer)paramString2).intValue();
    if (paramObject == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(240924);
      throw paramString1;
    }
    ((Activity)paramObject).startActivityForResult(paramString1, i, null);
    paramString1 = ah.aiuX;
    AppMethodBeat.o(240924);
    return paramString1;
  }
  
  public static void ayW()
  {
    AppMethodBeat.i(240917);
    Map localMap = (Map)acsx;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("startActivityForResult", "(Landroid/content/Intent;I)V"));
    localMap.put("android/app/Activity", localArrayList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)acsx, a..ExternalSyntheticLambda0.INSTANCE);
    localMap = (Map)acsw;
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("open", "()Landroid/hardware/Camera;"));
    localArrayList.add(Pair.create("open", "(I)Landroid/hardware/Camera;"));
    localMap.put("android/hardware/Camera", localArrayList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)acsw, (c)new a());
    localMap = (Map)acsy;
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("openCamera", "(Ljava/lang/String;Landroid/hardware/camera2/CameraDevice$StateCallback;Landroid/os/Handler;)V"));
    localMap.put("android/hardware/camera2/CameraManager", localArrayList);
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a((Map)acsy, (c)new b());
    AppMethodBeat.o(240917);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/sensitive/CameraHooker$monitor$4", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodHookListener;", "onHook", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements c
  {
    public final Object onHook(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Object paramObject, Object[] paramArrayOfObject)
    {
      int j = 1;
      AppMethodBeat.i(240968);
      com.tencent.mm.sdk.platformtools.Log.i(a.aUw(), "[CameraHooker] method:" + paramString4 + ",methodDec:" + paramString5 + ",caller:" + paramObject);
      if (s.p(paramString4, "open"))
      {
        if (s.p(paramString5, "()Landroid/hardware/Camera;"))
        {
          paramString1 = com.tencent.mm.sensitive.ui.a.acvO;
          if (!com.tencent.mm.sensitive.ui.a.iUw())
          {
            paramString1 = com.tencent.mm.sensitive.ui.a.acvO;
            if (com.tencent.mm.sensitive.ui.a.bus(paramString4))
            {
              AppMethodBeat.o(240968);
              return null;
            }
          }
          paramString1 = Camera.open();
          AppMethodBeat.o(240968);
          return paramString1;
        }
        if (s.p(paramString5, "(I)Landroid/hardware/Camera;"))
        {
          paramString1 = com.tencent.mm.sensitive.ui.a.acvO;
          if (!com.tencent.mm.sensitive.ui.a.iUw())
          {
            paramString1 = com.tencent.mm.sensitive.ui.a.acvO;
            if (com.tencent.mm.sensitive.ui.a.bus(paramString4))
            {
              AppMethodBeat.o(240968);
              return null;
            }
          }
          if (paramArrayOfObject != null)
          {
            int i;
            if (paramArrayOfObject.length == 0)
            {
              i = 1;
              if (i != 0) {
                break label224;
              }
              i = j;
              label173:
              if (i == 0) {
                break label230;
              }
              paramString1 = paramArrayOfObject;
              label181:
              if (paramString1 == null) {
                break label240;
              }
              if (!(paramString1[0] instanceof Integer)) {
                break label235;
              }
            }
            for (;;)
            {
              if (paramString1 == null) {
                break label240;
              }
              paramString1 = Camera.open(((Integer)paramString1[0]).intValue());
              AppMethodBeat.o(240968);
              return paramString1;
              i = 0;
              break;
              label224:
              i = 0;
              break label173;
              label230:
              paramString1 = null;
              break label181;
              label235:
              paramString1 = null;
            }
          }
        }
      }
      label240:
      AppMethodBeat.o(240968);
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/sensitive/CameraHooker$monitor$6", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodHookListener;", "onHook", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements c
  {
    public final Object onHook(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(240971);
      com.tencent.mm.sdk.platformtools.Log.i(a.aUw(), "[CameraHooker] method:" + paramString4 + ",methodDec:" + paramString5 + ",caller:" + paramObject);
      if ((s.p(paramString4, "openCamera")) && (s.p(paramString5, "(Ljava/lang/String;Landroid/hardware/camera2/CameraDevice$StateCallback;Landroid/os/Handler;)V")))
      {
        paramString1 = com.tencent.mm.sensitive.ui.a.acvO;
        int i;
        if (!com.tencent.mm.sensitive.ui.a.iUw())
        {
          if (paramArrayOfObject != null) {
            break label196;
          }
          i = 0;
          if (i < 2) {
            break label204;
          }
          i = 1;
          label95:
          if (i == 0) {
            break label210;
          }
          paramString1 = paramArrayOfObject;
          label103:
          if (paramString1 != null) {
            break label215;
          }
          paramString1 = null;
          label109:
          if (paramString1 == null) {
            com.tencent.mm.sdk.platformtools.Log.i(a.aUw(), s.X("using camera2 but StateCallback is not IPluginSensitive.MMCameraStateCallBack, ", android.util.Log.getStackTraceString(new Throwable())));
          }
        }
        if ((paramObject instanceof CameraManager))
        {
          paramString1 = (CameraManager)paramObject;
          label148:
          if (paramArrayOfObject == null) {
            break label315;
          }
          if (paramArrayOfObject.length != 0) {
            break label303;
          }
          i = 1;
          label162:
          if (i != 0) {
            break label309;
          }
          i = 1;
          label170:
          if (i != 1) {
            break label315;
          }
          i = 1;
          label179:
          if (i == 0) {
            break label321;
          }
        }
        for (;;)
        {
          if (paramArrayOfObject != null) {
            break label327;
          }
          AppMethodBeat.o(240971);
          return null;
          label196:
          i = paramArrayOfObject.length;
          break;
          label204:
          i = 0;
          break label95;
          label210:
          paramString1 = null;
          break label103;
          label215:
          if ((paramString1[1] instanceof d.b)) {}
          for (;;)
          {
            if (paramString1 != null) {
              break label238;
            }
            paramString1 = null;
            break;
            paramString1 = null;
          }
          label238:
          paramString1 = paramString1[1];
          if ((paramString1 instanceof d.b)) {}
          for (paramString1 = (d.b)paramString1;; paramString1 = null)
          {
            if (paramString1 != null) {
              break label268;
            }
            paramString1 = null;
            break;
          }
          label268:
          paramString2 = com.tencent.mm.sensitive.ui.a.acvO;
          if (com.tencent.mm.sensitive.ui.a.bus(paramString4))
          {
            paramString1.btB();
            AppMethodBeat.o(240971);
            return null;
          }
          paramString1 = ah.aiuX;
          break label109;
          paramString1 = null;
          break label148;
          label303:
          i = 0;
          break label162;
          label309:
          i = 0;
          break label170;
          label315:
          i = 0;
          break label179;
          label321:
          paramArrayOfObject = null;
        }
        label327:
        if (paramString1 == null)
        {
          AppMethodBeat.o(240971);
          return null;
        }
        paramString3 = (String)paramArrayOfObject[0];
        paramString4 = (CameraDevice.StateCallback)paramArrayOfObject[1];
        paramString2 = paramArrayOfObject[2];
        if ((paramString2 instanceof Handler)) {}
        for (paramString2 = (Handler)paramString2;; paramString2 = null)
        {
          paramString1.openCamera(paramString3, paramString4, paramString2);
          paramString1 = ah.aiuX;
          AppMethodBeat.o(240971);
          return paramString1;
        }
      }
      AppMethodBeat.o(240971);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sensitive.a
 * JD-Core Version:    0.7.0.1
 */