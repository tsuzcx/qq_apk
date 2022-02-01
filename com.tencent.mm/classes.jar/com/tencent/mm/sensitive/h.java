package com.tencent.mm.sensitive;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/OverlayHooker;", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "()V", "TAG", "", "ballInfoType2Business", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/sensitive/IPluginSensitive$BUSINESS;", "isDialogShowing", "", "mOverLayMethodMap", "", "Landroid/util/Pair;", "addPermissionListener", "", "checkBusinessPermission", "ballType", "listener", "Lcom/tencent/mm/sensitive/IPluginSensitive$onDialogOptionListener;", "onResultAllow", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements RequestFloatWindowPermissionDialog.a
{
  private static boolean GXR;
  private static final String TAG;
  public static final h actP;
  private static final HashMap<String, List<Pair<String, String>>> actQ;
  private static final HashMap<Integer, d.a> actR;
  
  static
  {
    AppMethodBeat.i(240899);
    actP = new h();
    TAG = "OverlayHooker";
    actQ = new HashMap();
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put(Integer.valueOf(2), d.a.actf);
    ((Map)localHashMap).put(Integer.valueOf(8), d.a.acsR);
    ((Map)localHashMap).put(Integer.valueOf(16), d.a.acsU);
    ((Map)localHashMap).put(Integer.valueOf(21), d.a.acsO);
    ((Map)localHashMap).put(Integer.valueOf(22), d.a.acsN);
    ((Map)localHashMap).put(Integer.valueOf(23), d.a.acta);
    ((Map)localHashMap).put(Integer.valueOf(32), d.a.acsN);
    ((Map)localHashMap).put(Integer.valueOf(9), d.a.acsJ);
    actR = localHashMap;
    AppMethodBeat.o(240899);
  }
  
  public static boolean a(int paramInt, d.f paramf)
  {
    boolean bool = true;
    AppMethodBeat.i(240893);
    s.u(paramf, "listener");
    if (!GXR)
    {
      Object localObject = com.tencent.mm.sensitive.ui.a.acvO;
      if (!com.tencent.mm.sensitive.ui.a.iUw())
      {
        localObject = (d.a)actR.get(Integer.valueOf(paramInt));
        if (localObject != null)
        {
          if (((d)com.tencent.mm.kernel.h.az(d.class)).checkBusinessPermission(d.c.actB, (d.a)localObject)) {
            break label114;
          }
          GXR = true;
          com.tencent.mm.sensitive.ui.a locala = com.tencent.mm.sensitive.ui.a.acvO;
          com.tencent.mm.sensitive.ui.a.b(d.c.actB, (d.a)localObject, (b)new a(paramf));
          bool = false;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(240893);
      return bool;
      if (GXR)
      {
        bool = false;
        continue;
        label114:
        bool = true;
      }
    }
  }
  
  public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
  {
    AppMethodBeat.i(240903);
    ((d)com.tencent.mm.kernel.h.az(d.class)).openBusinessSwitchOnPermissionGranted(d.c.actB);
    AppMethodBeat.o(240903);
  }
  
  public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog) {}
  
  public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog) {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isOk", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<Boolean, ah>
  {
    a(d.f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sensitive.h
 * JD-Core Version:    0.7.0.1
 */