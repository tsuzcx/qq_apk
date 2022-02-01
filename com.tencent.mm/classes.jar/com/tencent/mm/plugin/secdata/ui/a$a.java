package com.tencent.mm.plugin.secdata.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secdata.d;
import com.tencent.mm.plugin.secdata.e;
import com.tencent.mm.plugin.secdata.f;
import com.tencent.mm.plugin.secdata.h;
import com.tencent.mm.ui.component.UIComponentActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/secdata/ui/SecDataUIC$Companion;", "", "()V", "getDefaultSecDataObj", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "context", "Landroid/content/Context;", "type", "", "clazz", "Ljava/lang/Class;", "(Landroid/content/Context;ILjava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getOneTimeActivitySecDataObj", "activityName", "", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getPreSecDataObj", "pageIndex", "(Landroid/content/Context;IILjava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getSecDataObj", "onDefaultItemChildViewClick", "view", "Landroid/view/View;", "(ILandroid/view/View;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "onDefaultListSecDataGetView", "", "convertView", "data", "(ILandroid/view/View;Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "uic", "Lcom/tencent/mm/plugin/secdata/ui/SecDataUIC;", "ui-sec-data_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  public static <T extends com.tencent.mm.bx.a> T a(Context paramContext, int paramInt, Class<T> paramClass)
  {
    AppMethodBeat.i(261516);
    s.u(paramContext, "context");
    s.u(paramClass, "clazz");
    paramContext = jC(paramContext);
    if (paramContext == null) {
      paramContext = null;
    }
    while ((paramContext instanceof com.tencent.mm.bx.a))
    {
      AppMethodBeat.o(261516);
      return paramContext;
      paramContext = paramContext.aiJ(paramInt);
      if (paramContext == null) {
        paramContext = null;
      } else {
        paramContext = paramContext.gUv();
      }
    }
    AppMethodBeat.o(261516);
    return null;
  }
  
  public static <T extends com.tencent.mm.bx.a> T a(Context paramContext, String paramString, int paramInt, Class<T> paramClass)
  {
    AppMethodBeat.i(261531);
    s.u(paramContext, "context");
    s.u(paramString, "activityName");
    s.u(paramClass, "clazz");
    Object localObject1 = jC(paramContext);
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((a)localObject1).aiJ(paramInt))
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        paramString = (h)new com.tencent.mm.plugin.secdata.a(paramString, paramClass, paramInt, false);
        paramContext = jC(paramContext);
        localObject2 = paramString;
        if (paramContext != null)
        {
          paramContext.a(paramString);
          localObject2 = paramString;
        }
      }
      paramContext = ((h)localObject2).gUv();
      if (!(paramContext instanceof com.tencent.mm.bx.a)) {
        break;
      }
      AppMethodBeat.o(261531);
      return paramContext;
    }
    AppMethodBeat.o(261531);
    return null;
  }
  
  public static <T extends com.tencent.mm.bx.a> void a(View paramView, T paramT)
  {
    AppMethodBeat.i(261546);
    s.u(paramView, "convertView");
    s.u(paramT, "data");
    Object localObject1 = paramView.getContext();
    s.s(localObject1, "convertView.context");
    localObject1 = jC((Context)localObject1);
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((a)localObject1).gUA())
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = (f)new d();
        localObject2 = paramView.getContext();
        s.s(localObject2, "convertView.context");
        a locala = jC((Context)localObject2);
        localObject2 = localObject1;
        if (locala != null)
        {
          locala.a((f)localObject1);
          localObject2 = localObject1;
        }
      }
      ((f)localObject2).c(String.valueOf(paramView.hashCode()), paramT);
      AppMethodBeat.o(261546);
      return;
    }
  }
  
  public static <T extends com.tencent.mm.bx.a> T b(Context paramContext, int paramInt, Class<T> paramClass)
  {
    AppMethodBeat.i(261524);
    s.u(paramContext, "context");
    s.u(paramClass, "clazz");
    paramContext = jC(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(261524);
      return null;
    }
    paramContext = paramContext.c(paramInt, paramClass);
    AppMethodBeat.o(261524);
    return paramContext;
  }
  
  public static <T extends com.tencent.mm.bx.a> T c(Context paramContext, int paramInt, Class<T> paramClass)
  {
    AppMethodBeat.i(261538);
    s.u(paramContext, "context");
    s.u(paramClass, "clazz");
    Object localObject1 = jC(paramContext);
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((a)localObject1).aiJ(paramInt))
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        paramClass = (h)new e(paramClass, paramInt);
        paramContext = jC(paramContext);
        localObject2 = paramClass;
        if (paramContext != null)
        {
          paramContext.a(paramClass);
          localObject2 = paramClass;
        }
      }
      paramContext = ((h)localObject2).gUv();
      if (!(paramContext instanceof com.tencent.mm.bx.a)) {
        break;
      }
      AppMethodBeat.o(261538);
      return paramContext;
    }
    AppMethodBeat.o(261538);
    return null;
  }
  
  public static a jC(Context paramContext)
  {
    AppMethodBeat.i(261508);
    s.u(paramContext, "context");
    if ((paramContext instanceof UIComponentActivity))
    {
      k localk = k.aeZF;
      paramContext = (a)k.d((AppCompatActivity)paramContext).q(a.class);
      AppMethodBeat.o(261508);
      return paramContext;
    }
    AppMethodBeat.o(261508);
    return null;
  }
  
  public static <T extends com.tencent.mm.bx.a> T jb(View paramView)
  {
    int j = 0;
    AppMethodBeat.i(261554);
    s.u(paramView, "view");
    Object localObject = paramView.getContext();
    s.s(localObject, "view.context");
    localObject = jC((Context)localObject);
    if (localObject == null)
    {
      localObject = null;
      if ((localObject == null) || (((Map)localObject).containsKey(String.valueOf(paramView.hashCode())) != true)) {
        break label110;
      }
    }
    label110:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label115;
      }
      paramView = (com.tencent.mm.bx.a)((Map)localObject).get(String.valueOf(paramView.hashCode()));
      AppMethodBeat.o(261554);
      return paramView;
      localObject = ((a)localObject).gUA();
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = ((f)localObject).gUy();
      break;
    }
    label115:
    paramView = paramView.getParent();
    if (paramView != null)
    {
      if ((localObject != null) && (((Map)localObject).containsKey(String.valueOf(paramView.hashCode())) == true)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label166;
        }
        paramView = paramView.getParent();
        break;
      }
    }
    label166:
    if (localObject == null)
    {
      AppMethodBeat.o(261554);
      return null;
    }
    i = j;
    if (paramView != null) {
      i = paramView.hashCode();
    }
    paramView = (com.tencent.mm.bx.a)((Map)localObject).get(String.valueOf(i));
    AppMethodBeat.o(261554);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.ui.a.a
 * JD-Core Version:    0.7.0.1
 */