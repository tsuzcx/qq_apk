package com.tencent.mm.plugin.secdata.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.secdata.d;
import com.tencent.mm.plugin.secdata.e;
import com.tencent.mm.plugin.secdata.f;
import com.tencent.mm.plugin.secdata.h;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.acj;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentActivity;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/secdata/ui/SecDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "listSecDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/secdata/IListSecData;", "Lkotlin/collections/HashMap;", "getListSecDataMap", "()Ljava/util/HashMap;", "pageSecDataMap", "Lcom/tencent/mm/plugin/secdata/ISecData;", "getPageSecDataMap", "reportObjList", "Lcom/tencent/mm/protocal/protobuf/CommonReportObjList;", "getReportObjList", "()Lcom/tencent/mm/protocal/protobuf/CommonReportObjList;", "getCurrentCommonReportObj", "Lcom/tencent/mm/protocal/protobuf/CommonReportObj;", "getCurrentSubReportObj", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "type", "(I)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getListSecData", "getPreSubReportObj", "pageIndex", "clazz", "Ljava/lang/Class;", "(IILjava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getSecData", "initUICData", "", "intent", "Landroid/content/Intent;", "onCreateBefore", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "onStartActivityForResult", "requestCode", "options", "registerSecData", "secData", "Companion", "ui-sec-data_release"})
public final class SecDataUIC
  extends UIComponent
{
  public static final a CWq;
  private final acj CWn;
  private final HashMap<Integer, h<?>> CWo;
  private final HashMap<Integer, f<?>> CWp;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(224085);
    CWq = new a((byte)0);
    AppMethodBeat.o(224085);
  }
  
  public SecDataUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(224084);
    this.TAG = "MicroMsg.SecData.SecDataUIC";
    this.CWn = new acj();
    this.CWo = new HashMap();
    this.CWp = new HashMap();
    AppMethodBeat.o(224084);
  }
  
  private final void aT(Intent paramIntent)
  {
    AppMethodBeat.i(224074);
    this.CWo.clear();
    this.CWp.clear();
    this.CWn.oTA.clear();
    paramIntent = paramIntent.getByteArrayExtra("ReportKey.CommonReportObjKey");
    if (paramIntent != null) {}
    try
    {
      this.CWn.parseFrom(paramIntent);
      label49:
      paramIntent = new aci();
      paramIntent.LmS = getActivity().getClass().getSimpleName();
      paramIntent.LmT = cl.aWA();
      Object localObject = this.CWn.oTA;
      p.g(localObject, "reportObjList.List");
      localObject = (aci)j.kt((List)localObject);
      if (localObject != null)
      {
        paramIntent.KXB = ((aci)localObject).KXB;
        paramIntent.LmU = ((aci)localObject).LmU;
        paramIntent.LmV = 0;
        Log.i(this.TAG, "fromPage:" + ((aci)localObject).LmS + " contextId:" + ((aci)localObject).KXB + " currentPage:" + paramIntent.LmS);
      }
      for (;;)
      {
        this.CWn.oTA.addFirst(paramIntent);
        if (this.CWn.oTA.size() > 5) {
          this.CWn.oTA.removeLast();
        }
        AppMethodBeat.o(224074);
        return;
        localObject = (SecDataUIC)this;
        paramIntent.KXB = UUID.randomUUID().toString();
        paramIntent.LmU = 0;
        paramIntent.LmV = 1;
        Log.i(((SecDataUIC)localObject).TAG, "firstPage:" + paramIntent.LmS + " contextId:" + paramIntent.KXB);
      }
    }
    catch (Exception paramIntent)
    {
      break label49;
    }
  }
  
  private aci eSs()
  {
    AppMethodBeat.i(224083);
    Object localObject = this.CWn.oTA;
    p.g(localObject, "reportObjList.List");
    localObject = (aci)j.kt((List)localObject);
    AppMethodBeat.o(224083);
    return localObject;
  }
  
  public final h<?> Xg(int paramInt)
  {
    AppMethodBeat.i(224078);
    h localh = (h)this.CWo.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(224078);
    return localh;
  }
  
  public final <T extends com.tencent.mm.bw.a> T Xh(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(224080);
    Object localObject1 = Xg(paramInt);
    if (localObject1 != null)
    {
      localObject1 = ((h)localObject1).eSl();
      if ((localObject1 instanceof com.tencent.mm.bw.a)) {
        break label47;
      }
      localObject1 = localObject2;
    }
    label47:
    for (;;)
    {
      AppMethodBeat.o(224080);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public final <T extends com.tencent.mm.bw.a> void a(f<T> paramf)
  {
    AppMethodBeat.i(224076);
    p.h(paramf, "secData");
    ((Map)this.CWp).put(Integer.valueOf(paramf.getType()), paramf);
    AppMethodBeat.o(224076);
  }
  
  public final <T extends com.tencent.mm.bw.a> void a(h<T> paramh)
  {
    AppMethodBeat.i(224075);
    p.h(paramh, "secData");
    ((Map)this.CWo).put(Integer.valueOf(paramh.getType()), paramh);
    AppMethodBeat.o(224075);
  }
  
  public final <T extends com.tencent.mm.bw.a> f<T> eSr()
  {
    AppMethodBeat.i(224079);
    Object localObject2 = this.CWp.get(Integer.valueOf(1));
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof f)) {
      localObject1 = null;
    }
    localObject1 = (f)localObject1;
    AppMethodBeat.o(224079);
    return localObject1;
  }
  
  public final <T extends com.tencent.mm.bw.a> T f(int paramInt, Class<T> paramClass)
  {
    AppMethodBeat.i(224077);
    p.h(paramClass, "clazz");
    Object localObject = this.CWn.oTA;
    int i;
    if (((LinkedList)localObject).size() > 1)
    {
      i = 1;
      if (i == 0) {
        break label174;
      }
      label37:
      if (localObject == null) {
        break label191;
      }
      localObject = (aci)((LinkedList)localObject).get(1);
      if (localObject == null) {
        break label191;
      }
      localObject = ((aci)localObject).LmW;
      if (localObject == null) {
        break label191;
      }
      Iterator localIterator = ((Iterable)localObject).iterator();
      label82:
      if (!localIterator.hasNext()) {
        break label185;
      }
      localObject = localIterator.next();
      if (((ack)localObject).oUv != paramInt) {
        break label180;
      }
      i = 1;
      label115:
      if (i == 0) {
        break label183;
      }
    }
    for (;;)
    {
      localObject = (ack)localObject;
      if (localObject == null) {
        break label191;
      }
      paramClass = paramClass.newInstance();
      p.g(paramClass, "clazz.newInstance()");
      paramClass = (com.tencent.mm.bw.a)paramClass;
      paramClass.parseFrom(((ack)localObject).oTm.toByteArray());
      AppMethodBeat.o(224077);
      return paramClass;
      i = 0;
      break;
      label174:
      localObject = null;
      break label37;
      label180:
      i = 0;
      break label115;
      label183:
      break label82;
      label185:
      localObject = null;
    }
    label191:
    AppMethodBeat.o(224077);
    return null;
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(224073);
    super.onCreateBefore(paramBundle);
    aT(getIntent());
    AppMethodBeat.o(224073);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    int j = 1;
    AppMethodBeat.i(224081);
    Log.i(this.TAG, "onNewIntent ".concat(String.valueOf(paramIntent)));
    int i;
    if (paramIntent != null)
    {
      if (paramIntent.getByteArrayExtra("ReportKey.CommonReportObjKey") != null)
      {
        i = 1;
        if (i == 0) {
          break label70;
        }
      }
      label70:
      for (localIntent = paramIntent;; localIntent = null)
      {
        if (localIntent == null) {
          break label76;
        }
        aT(localIntent);
        AppMethodBeat.o(224081);
        return;
        i = 0;
        break;
      }
    }
    label76:
    SecDataUIC localSecDataUIC = (SecDataUIC)this;
    Intent localIntent = localSecDataUIC.getIntent();
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getByteArrayExtra("ReportKey.CommonReportObjKey");
      if (paramIntent == null) {
        break label135;
      }
      i = j;
      label106:
      if (i == 0) {
        break label140;
      }
    }
    label135:
    label140:
    for (paramIntent = localIntent;; paramIntent = null)
    {
      if (paramIntent == null) {
        break label145;
      }
      localSecDataUIC.aT(paramIntent);
      AppMethodBeat.o(224081);
      return;
      paramIntent = null;
      break;
      i = 0;
      break label106;
    }
    label145:
    AppMethodBeat.o(224081);
  }
  
  public final void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(224082);
    try
    {
      localObject1 = new HashSet();
      localObject2 = this.CWo.values();
      p.g(localObject2, "pageSecDataMap.values");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (h)((Iterator)localObject2).next();
        if (((h)localObject3).aS(paramIntent))
        {
          ack localack = new ack();
          localack.oUv = ((h)localObject3).getType();
          localack.oTm = new b(((h)localObject3).eSl().toByteArray());
          Object localObject4 = eSs();
          if (localObject4 != null)
          {
            localObject4 = ((aci)localObject4).LmW;
            if (localObject4 != null) {
              ((LinkedList)localObject4).add(localack);
            }
          }
          if (!((h)localObject3).eSm()) {
            ((HashSet)localObject1).add(Integer.valueOf(((h)localObject3).getType()));
          }
        }
      }
      localObject1 = ((Iterable)localObject1).iterator();
    }
    catch (Exception paramIntent)
    {
      AppMethodBeat.o(224082);
      return;
    }
    while (((Iterator)localObject1).hasNext())
    {
      int i = ((Number)((Iterator)localObject1).next()).intValue();
      this.CWo.remove(Integer.valueOf(i));
    }
    Object localObject2 = this.TAG;
    Object localObject3 = new StringBuilder("onStartActivityForResult SubObjList.size:");
    Object localObject1 = eSs();
    if (localObject1 != null)
    {
      localObject1 = ((aci)localObject1).LmW;
      if (localObject1 == null) {}
    }
    for (localObject1 = Integer.valueOf(((LinkedList)localObject1).size());; localObject1 = null)
    {
      Log.i((String)localObject2, localObject1 + ", requestCode:" + paramInt + " options:" + paramBundle);
      if (paramIntent != null) {
        paramIntent.putExtra("ReportKey.CommonReportObjKey", this.CWn.toByteArray());
      }
      paramIntent = eSs();
      if (paramIntent == null) {
        break;
      }
      paramIntent = paramIntent.LmW;
      if (paramIntent == null) {
        break;
      }
      paramIntent.clear();
      AppMethodBeat.o(224082);
      return;
    }
    AppMethodBeat.o(224082);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/secdata/ui/SecDataUIC$Companion;", "", "()V", "getDefaultSecDataObj", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "context", "Landroid/content/Context;", "type", "", "clazz", "Ljava/lang/Class;", "(Landroid/content/Context;ILjava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getOneTimeActivitySecDataObj", "activityName", "", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getPreSecDataObj", "pageIndex", "(Landroid/content/Context;IILjava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getSecDataObj", "onDefaultItemChildViewClick", "view", "Landroid/view/View;", "(ILandroid/view/View;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "onDefaultListSecDataGetView", "", "convertView", "data", "(ILandroid/view/View;Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "uic", "Lcom/tencent/mm/plugin/secdata/ui/SecDataUIC;", "ui-sec-data_release"})
  public static final class a
  {
    public static <T extends com.tencent.mm.bw.a> T a(Context paramContext, int paramInt, Class<T> paramClass)
    {
      Object localObject = null;
      AppMethodBeat.i(224068);
      p.h(paramContext, "context");
      p.h(paramClass, "clazz");
      paramContext = gU(paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.Xg(paramInt);
        if (paramContext != null)
        {
          paramContext = paramContext.eSl();
          if ((paramContext instanceof com.tencent.mm.bw.a)) {
            break label66;
          }
          paramContext = localObject;
        }
      }
      label66:
      for (;;)
      {
        AppMethodBeat.o(224068);
        return paramContext;
        paramContext = null;
        break;
      }
    }
    
    public static <T extends com.tencent.mm.bw.a> T a(Context paramContext, String paramString, int paramInt, Class<T> paramClass)
    {
      AppMethodBeat.i(224070);
      p.h(paramContext, "context");
      p.h(paramString, "activityName");
      p.h(paramClass, "clazz");
      Object localObject1 = gU(paramContext);
      if (localObject1 != null) {}
      for (localObject1 = ((SecDataUIC)localObject1).Xg(paramInt);; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          paramString = (h)new com.tencent.mm.plugin.secdata.a(paramString, paramClass, paramInt, false);
          paramContext = gU(paramContext);
          localObject2 = paramString;
          if (paramContext != null)
          {
            paramContext.a(paramString);
            localObject2 = paramString;
          }
        }
        paramString = ((h)localObject2).eSl();
        paramContext = paramString;
        if (!(paramString instanceof com.tencent.mm.bw.a)) {
          paramContext = null;
        }
        AppMethodBeat.o(224070);
        return paramContext;
      }
    }
    
    public static <T extends com.tencent.mm.bw.a> void a(View paramView, T paramT)
    {
      AppMethodBeat.i(224072);
      p.h(paramView, "convertView");
      p.h(paramT, "data");
      Object localObject1 = paramView.getContext();
      p.g(localObject1, "convertView.context");
      localObject1 = gU((Context)localObject1);
      if (localObject1 != null) {}
      for (localObject1 = ((SecDataUIC)localObject1).eSr();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = (f)new d();
          localObject2 = paramView.getContext();
          p.g(localObject2, "convertView.context");
          SecDataUIC localSecDataUIC = gU((Context)localObject2);
          localObject2 = localObject1;
          if (localSecDataUIC != null)
          {
            localSecDataUIC.a((f)localObject1);
            localObject2 = localObject1;
          }
        }
        ((f)localObject2).c(String.valueOf(paramView.hashCode()), paramT);
        AppMethodBeat.o(224072);
        return;
      }
    }
    
    public static <T extends com.tencent.mm.bw.a> T b(Context paramContext, int paramInt, Class<T> paramClass)
    {
      AppMethodBeat.i(224069);
      p.h(paramContext, "context");
      p.h(paramClass, "clazz");
      paramContext = gU(paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.f(paramInt, paramClass);
        AppMethodBeat.o(224069);
        return paramContext;
      }
      AppMethodBeat.o(224069);
      return null;
    }
    
    public static <T extends com.tencent.mm.bw.a> T c(Context paramContext, int paramInt, Class<T> paramClass)
    {
      AppMethodBeat.i(224071);
      p.h(paramContext, "context");
      p.h(paramClass, "clazz");
      Object localObject1 = gU(paramContext);
      if (localObject1 != null) {}
      for (localObject1 = ((SecDataUIC)localObject1).Xg(paramInt);; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          paramClass = (h)new e(paramClass, paramInt);
          paramContext = gU(paramContext);
          localObject2 = paramClass;
          if (paramContext != null)
          {
            paramContext.a(paramClass);
            localObject2 = paramClass;
          }
        }
        paramClass = ((h)localObject2).eSl();
        paramContext = paramClass;
        if (!(paramClass instanceof com.tencent.mm.bw.a)) {
          paramContext = null;
        }
        AppMethodBeat.o(224071);
        return paramContext;
      }
    }
    
    public static SecDataUIC gU(Context paramContext)
    {
      AppMethodBeat.i(224067);
      p.h(paramContext, "context");
      if ((paramContext instanceof UIComponentActivity))
      {
        com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
        paramContext = (SecDataUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramContext).get(SecDataUIC.class);
        AppMethodBeat.o(224067);
        return paramContext;
      }
      AppMethodBeat.o(224067);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.ui.SecDataUIC
 * JD-Core Version:    0.7.0.1
 */