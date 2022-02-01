package com.tencent.mm.sensitive.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sensitive.business.a.b;
import com.tencent.mm.sensitive.d.a;
import com.tencent.mm.sensitive.d.c;
import com.tencent.mm.sensitive.e;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@com.tencent.mm.ui.base.a(7)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/ui/SysPermissionDialogUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "callbackHashCode", "", "getCallbackHashCode", "()I", "setCallbackHashCode", "(I)V", "permissionEnumList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/sensitive/IPluginSensitive$PERMISSION;", "getPermissionEnumList", "()Ljava/util/ArrayList;", "setPermissionEnumList", "(Ljava/util/ArrayList;)V", "permissionEnumListForDialog", "getPermissionEnumListForDialog", "setPermissionEnumListForDialog", "requestCode", "getRequestCode", "setRequestCode", "getLayoutId", "getSpecifyBusiness", "Lcom/tencent/mm/sensitive/IPluginSensitive$BUSINESS;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "showWxPermissionDialog", "permissionEnum", "onAllShow", "Lkotlin/Function1;", "", "Companion", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SysPermissionDialogUI
  extends MMActivity
{
  public static final SysPermissionDialogUI.a acvX;
  private static final String acwb;
  private static final String acwc;
  private static q<? super Integer, ? super String[], ? super int[], ah> acwd;
  int acvY;
  ArrayList<d.c> acvZ;
  ArrayList<d.c> acwa;
  int hPm = -1;
  
  static
  {
    AppMethodBeat.i(241099);
    acvX = new SysPermissionDialogUI.a((byte)0);
    acwb = "KEY_PERMISSION_LIST";
    acwc = "KEY_PERMISSION_REQUEST_CODE";
    AppMethodBeat.o(241099);
  }
  
  private final void a(d.c paramc, final kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(241064);
    Object localObject = com.tencent.mm.sensitive.d.b.acvJ;
    com.tencent.mm.sensitive.d.b.a(101L, Long.valueOf(paramc.qDL), null, null, 12);
    localObject = a.acvO;
    a.c((Activity)this, paramc, iUy(), (kotlin.g.a.b)new c(paramc, this, paramb));
    AppMethodBeat.o(241064);
  }
  
  private final d.a iUy()
  {
    switch (this.hPm)
    {
    default: 
      return null;
    }
    return d.a.actr;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    int k = 0;
    Object localObject1 = null;
    AppMethodBeat.i(241118);
    super.onCreate(paramBundle);
    com.tencent.mm.ui.statusbar.d.g(getWindow());
    paramBundle = getIntent().getStringArrayListExtra(acwb);
    if (paramBundle == null)
    {
      paramBundle = null;
      this.hPm = getIntent().getIntExtra(acwc, -1);
      if (paramBundle != null) {
        break label122;
      }
    }
    for (paramBundle = (Bundle)localObject1;; paramBundle = ah.aiuX)
    {
      if (paramBundle == null) {
        ((SysPermissionDialogUI)this).finish();
      }
      AppMethodBeat.o(241118);
      return;
      paramBundle = ((Collection)paramBundle).toArray(new String[0]);
      if (paramBundle == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(241118);
        throw paramBundle;
      }
      paramBundle = (String[])paramBundle;
      break;
      label122:
      this.acvZ = new ArrayList();
      int m = paramBundle.length;
      int i = 0;
      if (i < m)
      {
        localObject1 = paramBundle[i];
        localObject2 = com.tencent.mm.sensitive.business.a.acuK;
        localObject1 = (d.c)com.tencent.mm.sensitive.business.a.iUb().get(localObject1);
        int j;
        if (localObject1 != null)
        {
          localObject2 = this.acvZ;
          s.checkNotNull(localObject2);
          if (((ArrayList)localObject2).contains(localObject1)) {
            break label231;
          }
          j = 1;
          label196:
          if (j == 0) {
            break label236;
          }
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            localObject2 = this.acvZ;
            s.checkNotNull(localObject2);
            ((ArrayList)localObject2).add(localObject1);
          }
          i += 1;
          break;
          label231:
          j = 0;
          break label196;
          label236:
          localObject1 = null;
        }
      }
      localObject1 = new ArrayList();
      Object localObject2 = this.acvZ;
      s.checkNotNull(localObject2);
      ((ArrayList)localObject1).addAll((Collection)localObject2);
      localObject2 = ah.aiuX;
      this.acwa = ((ArrayList)localObject1);
      localObject1 = acwd;
      if (localObject1 != null)
      {
        i = localObject1.hashCode();
        this.acvY = i;
        localObject1 = this.acwa;
        s.checkNotNull(localObject1);
        i = k;
        if (!((Collection)localObject1).isEmpty()) {
          i = 1;
        }
        if (i == 0) {
          break label457;
        }
        label338:
        if (localObject1 != null) {
          break label463;
        }
        localObject1 = null;
      }
      label457:
      label463:
      for (;;)
      {
        label346:
        if (localObject1 == null)
        {
          localObject1 = (SysPermissionDialogUI)this;
          localObject2 = ((SysPermissionDialogUI)localObject1).getIntent();
          Object localObject3 = e.actI;
          ((Intent)localObject2).putExtra(e.iTH(), true);
          localObject2 = ((SysPermissionDialogUI)localObject1).acvZ;
          if (localObject2 != null)
          {
            localObject2 = ((Iterable)localObject2).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = (d.c)((Iterator)localObject2).next();
                com.tencent.mm.sensitive.d.b localb = com.tencent.mm.sensitive.d.b.acvJ;
                com.tencent.mm.sensitive.d.b.a(151L, Long.valueOf(((d.c)localObject3).qDL), null, null, 12);
                continue;
                i = 0;
                break;
                localObject1 = null;
                break label338;
                a((d.c)p.oK((List)localObject1), (kotlin.g.a.b)new b(this, paramBundle));
                localObject1 = ah.aiuX;
                break label346;
              }
            }
          }
          androidx.core.app.a.a((Activity)localObject1, paramBundle, ((SysPermissionDialogUI)localObject1).hPm);
        }
      }
    }
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(241128);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    int i = 0;
    int k = paramArrayOfInt.length;
    int j = 0;
    if (j < k)
    {
      localObject1 = com.tencent.mm.sensitive.business.a.acuK;
      localObject1 = (d.c)com.tencent.mm.sensitive.business.a.iUb().get(paramArrayOfString[i]);
      Object localObject2;
      if (localObject1 != null)
      {
        if (paramArrayOfInt[i] != -1) {
          break label155;
        }
        if (!androidx.core.app.a.a((Activity)getContext(), paramArrayOfString[i])) {
          break label127;
        }
        localObject2 = com.tencent.mm.sensitive.d.b.acvJ;
        com.tencent.mm.sensitive.d.b.a(163L, Long.valueOf(((d.c)localObject1).qDL), null, Boolean.TRUE, 4);
      }
      for (;;)
      {
        j += 1;
        i += 1;
        break;
        label127:
        localObject2 = com.tencent.mm.sensitive.d.b.acvJ;
        com.tencent.mm.sensitive.d.b.a(164L, Long.valueOf(((d.c)localObject1).qDL), null, Boolean.TRUE, 4);
        continue;
        label155:
        localObject2 = com.tencent.mm.sensitive.business.a.acuK;
        localObject2 = (a.b)com.tencent.mm.sensitive.business.a.iUa().get(localObject1);
        if (localObject2 != null)
        {
          localObject2 = ((a.b)localObject2).acuV;
          if (localObject2 != null)
          {
            localObject2 = ((Map)localObject2).entrySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
              MultiProcessMMKV localMultiProcessMMKV = ((com.tencent.mm.sensitive.d)h.az(com.tencent.mm.sensitive.d.class)).getPermissionConfigMMkv(((d.c)localObject1).value);
              if (localMultiProcessMMKV != null) {
                localMultiProcessMMKV.putBoolean(((d.a)localEntry.getKey()).value, true);
              }
            }
          }
        }
        localObject2 = com.tencent.mm.sensitive.d.b.acvJ;
        com.tencent.mm.sensitive.d.b.a(162L, Long.valueOf(((d.c)localObject1).qDL), null, Boolean.TRUE, 4);
      }
    }
    finish();
    Object localObject1 = acwd;
    if (localObject1 != null) {
      ((q)localObject1).invoke(Integer.valueOf(paramInt), paramArrayOfString, paramArrayOfInt);
    }
    paramArrayOfString = acwd;
    if (paramArrayOfString != null) {}
    for (paramInt = paramArrayOfString.hashCode();; paramInt = 0)
    {
      if (paramInt == this.acvY) {
        acwd = null;
      }
      AppMethodBeat.o(241128);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isOk", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(SysPermissionDialogUI paramSysPermissionDialogUI, String[] paramArrayOfString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isOk", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    c(d.c paramc, SysPermissionDialogUI paramSysPermissionDialogUI, kotlin.g.a.b<? super Boolean, ah> paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sensitive.ui.SysPermissionDialogUI
 * JD-Core Version:    0.7.0.1
 */