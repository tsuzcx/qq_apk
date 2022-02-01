package com.tencent.mm.plugin.secdata.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.secdata.d;
import com.tencent.mm.plugin.secdata.e;
import com.tencent.mm.plugin.secdata.f;
import com.tencent.mm.plugin.secdata.h;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/secdata/ui/SecDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "listSecDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/secdata/IListSecData;", "Lkotlin/collections/HashMap;", "getListSecDataMap", "()Ljava/util/HashMap;", "pageSecDataMap", "Lcom/tencent/mm/plugin/secdata/ISecData;", "getPageSecDataMap", "reportObjList", "Lcom/tencent/mm/protocal/protobuf/CommonReportObjList;", "getReportObjList", "()Lcom/tencent/mm/protocal/protobuf/CommonReportObjList;", "getCurrentCommonReportObj", "Lcom/tencent/mm/protocal/protobuf/CommonReportObj;", "getCurrentSubReportObj", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "type", "(I)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getListSecData", "getPreSubReportObj", "pageIndex", "clazz", "Ljava/lang/Class;", "(IILjava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getSecData", "initUICData", "", "intent", "Landroid/content/Intent;", "onCreateBefore", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "onStartActivityForResult", "requestCode", "options", "registerSecData", "secData", "Companion", "ui-sec-data_release"})
public final class a
  extends UIComponent
{
  public static final a JbV;
  private final acq JbS;
  private final HashMap<Integer, h<?>> JbT;
  private final HashMap<Integer, f<?>> JbU;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(238444);
    JbV = new a((byte)0);
    AppMethodBeat.o(238444);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(238443);
    this.TAG = "MicroMsg.SecData.SecDataUIC";
    this.JbS = new acq();
    this.JbT = new HashMap();
    this.JbU = new HashMap();
    AppMethodBeat.o(238443);
  }
  
  private final void aS(Intent paramIntent)
  {
    AppMethodBeat.i(238426);
    this.JbT.clear();
    this.JbU.clear();
    this.JbS.rVy.clear();
    try
    {
      paramIntent = paramIntent.getByteArrayExtra("ReportKey.CommonReportObjKey");
      if (paramIntent != null) {
        this.JbS.parseFrom(paramIntent);
      }
    }
    catch (Exception paramIntent)
    {
      label49:
      Object localObject;
      break label49;
    }
    paramIntent = new acp();
    paramIntent.Soj = getActivity().getClass().getSimpleName();
    paramIntent.Sok = cm.bfE();
    localObject = this.JbS.rVy;
    p.j(localObject, "reportObjList.List");
    localObject = (acp)j.lp((List)localObject);
    if (localObject != null)
    {
      paramIntent.RYK = ((acp)localObject).RYK;
      paramIntent.Sol = ((acp)localObject).Sol;
      paramIntent.Som = 0;
      Log.i(this.TAG, "fromPage:" + ((acp)localObject).Soj + " contextId:" + ((acp)localObject).RYK + " currentPage:" + paramIntent.Soj);
    }
    for (;;)
    {
      this.JbS.rVy.addFirst(paramIntent);
      if (this.JbS.rVy.size() > 5) {
        this.JbS.rVy.removeLast();
      }
      AppMethodBeat.o(238426);
      return;
      localObject = (a)this;
      paramIntent.RYK = UUID.randomUUID().toString();
      paramIntent.Sol = 0;
      paramIntent.Som = 1;
      Log.i(((a)localObject).TAG, "firstPage:" + paramIntent.Soj + " contextId:" + paramIntent.RYK);
    }
  }
  
  private acp fFt()
  {
    AppMethodBeat.i(238442);
    Object localObject = this.JbS.rVy;
    p.j(localObject, "reportObjList.List");
    localObject = (acp)j.lp((List)localObject);
    AppMethodBeat.o(238442);
    return localObject;
  }
  
  public final <T extends com.tencent.mm.cd.a> void a(f<T> paramf)
  {
    AppMethodBeat.i(238430);
    p.k(paramf, "secData");
    ((Map)this.JbU).put(Integer.valueOf(paramf.getType()), paramf);
    AppMethodBeat.o(238430);
  }
  
  public final <T extends com.tencent.mm.cd.a> void a(h<T> paramh)
  {
    AppMethodBeat.i(238428);
    p.k(paramh, "secData");
    ((Map)this.JbT).put(Integer.valueOf(paramh.getType()), paramh);
    AppMethodBeat.o(238428);
  }
  
  public final h<?> aee(int paramInt)
  {
    AppMethodBeat.i(238433);
    h localh = (h)this.JbT.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(238433);
    return localh;
  }
  
  public final <T extends com.tencent.mm.cd.a> T aef(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(238436);
    Object localObject1 = aee(paramInt);
    if (localObject1 != null)
    {
      localObject1 = ((h)localObject1).fFn();
      if ((localObject1 instanceof com.tencent.mm.cd.a)) {
        break label47;
      }
      localObject1 = localObject2;
    }
    label47:
    for (;;)
    {
      AppMethodBeat.o(238436);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public final <T extends com.tencent.mm.cd.a> T c(int paramInt, Class<T> paramClass)
  {
    AppMethodBeat.i(238432);
    p.k(paramClass, "clazz");
    Object localObject = this.JbS.rVy;
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
      localObject = (acp)((LinkedList)localObject).get(1);
      if (localObject == null) {
        break label191;
      }
      localObject = ((acp)localObject).Son;
      if (localObject == null) {
        break label191;
      }
      Iterator localIterator = ((Iterable)localObject).iterator();
      label82:
      if (!localIterator.hasNext()) {
        break label185;
      }
      localObject = localIterator.next();
      if (((acr)localObject).rWu != paramInt) {
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
      localObject = (acr)localObject;
      if (localObject == null) {
        break label191;
      }
      paramClass = paramClass.newInstance();
      p.j(paramClass, "clazz.newInstance()");
      paramClass = (com.tencent.mm.cd.a)paramClass;
      paramClass.parseFrom(((acr)localObject).rVk.toByteArray());
      AppMethodBeat.o(238432);
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
    AppMethodBeat.o(238432);
    return null;
  }
  
  public final <T extends com.tencent.mm.cd.a> f<T> fFs()
  {
    AppMethodBeat.i(238434);
    Object localObject2 = this.JbU.get(Integer.valueOf(1));
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof f)) {
      localObject1 = null;
    }
    localObject1 = (f)localObject1;
    AppMethodBeat.o(238434);
    return localObject1;
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(238421);
    super.onCreateBefore(paramBundle);
    aS(getIntent());
    AppMethodBeat.o(238421);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(238439);
    Log.i(this.TAG, "onNewIntent ".concat(String.valueOf(paramIntent)));
    if (paramIntent != null)
    {
      if (paramIntent.getBooleanExtra("ReportKey.CommonReportNewIntentClearKey", false)) {}
      while (paramIntent != null)
      {
        aS(paramIntent);
        AppMethodBeat.o(238439);
        return;
        paramIntent = null;
      }
    }
    a locala = (a)this;
    paramIntent = locala.getIntent();
    if (paramIntent.getBooleanExtra("ReportKey.CommonReportNewIntentClearKey", false)) {}
    while (paramIntent != null)
    {
      locala.aS(paramIntent);
      AppMethodBeat.o(238439);
      return;
      paramIntent = null;
    }
    AppMethodBeat.o(238439);
  }
  
  public final void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(238440);
    try
    {
      localObject1 = new HashSet();
      localObject2 = this.JbT.values();
      p.j(localObject2, "pageSecDataMap.values");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (h)((Iterator)localObject2).next();
        if (((h)localObject3).aR(paramIntent))
        {
          localObject4 = new acr();
          ((acr)localObject4).rWu = ((h)localObject3).getType();
          ((acr)localObject4).rVk = new b(((h)localObject3).fFn().toByteArray());
          Object localObject5 = fFt();
          if (localObject5 != null)
          {
            localObject5 = ((acp)localObject5).Son;
            if (localObject5 != null) {
              ((LinkedList)localObject5).add(localObject4);
            }
          }
          if (!((h)localObject3).fFo()) {
            ((HashSet)localObject1).add(Integer.valueOf(((h)localObject3).getType()));
          }
        }
      }
      localObject1 = ((Iterable)localObject1).iterator();
    }
    catch (Exception paramIntent)
    {
      AppMethodBeat.o(238440);
      return;
    }
    int i;
    while (((Iterator)localObject1).hasNext())
    {
      i = ((Number)((Iterator)localObject1).next()).intValue();
      this.JbT.remove(Integer.valueOf(i));
    }
    Object localObject2 = this.JbS.toByteArray();
    Object localObject3 = this.TAG;
    Object localObject4 = new StringBuilder("onStartActivityForResult SubObjList.size:");
    Object localObject1 = fFt();
    if (localObject1 != null)
    {
      localObject1 = ((acp)localObject1).Son;
      if (localObject1 == null) {}
    }
    for (localObject1 = Integer.valueOf(((LinkedList)localObject1).size());; localObject1 = null)
    {
      Log.i((String)localObject3, localObject1 + ", requestCode:" + paramInt + " options:" + paramBundle + " byteSize:" + localObject2.length);
      paramBundle = (Bundle)localObject2;
      if (localObject2.length > 262144)
      {
        paramInt = localObject2.length;
        paramBundle = this.JbS.rVy;
        p.j(paramBundle, "reportObjList.List");
        paramBundle = (acp)j.lp((List)paramBundle);
        if (paramBundle != null)
        {
          this.JbS.rVy.clear();
          this.JbS.rVy.add(paramBundle);
        }
        paramBundle = this.JbS.toByteArray();
        i = paramBundle.length;
        Log.i(this.TAG, "data size large than 256KB origin:" + Util.getSizeKB(paramInt, 2.0D) + " current:" + Util.getSizeKB(i, 2.0D));
      }
      if (paramBundle.length < 262144) {
        if (paramIntent != null) {
          paramIntent.putExtra("ReportKey.CommonReportObjKey", paramBundle);
        }
      }
      for (;;)
      {
        paramIntent = fFt();
        if (paramIntent == null) {
          break;
        }
        paramIntent = paramIntent.Son;
        if (paramIntent == null) {
          break;
        }
        paramIntent.clear();
        AppMethodBeat.o(238440);
        return;
        Log.w(this.TAG, "data size two large");
      }
      AppMethodBeat.o(238440);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/secdata/ui/SecDataUIC$Companion;", "", "()V", "getDefaultSecDataObj", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "context", "Landroid/content/Context;", "type", "", "clazz", "Ljava/lang/Class;", "(Landroid/content/Context;ILjava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getOneTimeActivitySecDataObj", "activityName", "", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getPreSecDataObj", "pageIndex", "(Landroid/content/Context;IILjava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getSecDataObj", "onDefaultItemChildViewClick", "view", "Landroid/view/View;", "(ILandroid/view/View;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "onDefaultListSecDataGetView", "", "convertView", "data", "(ILandroid/view/View;Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "uic", "Lcom/tencent/mm/plugin/secdata/ui/SecDataUIC;", "ui-sec-data_release"})
  public static final class a
  {
    public static <T extends com.tencent.mm.cd.a> T a(Context paramContext, int paramInt, Class<T> paramClass)
    {
      Object localObject = null;
      AppMethodBeat.i(238389);
      p.k(paramContext, "context");
      p.k(paramClass, "clazz");
      paramContext = hU(paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.aee(paramInt);
        if (paramContext != null)
        {
          paramContext = paramContext.fFn();
          if ((paramContext instanceof com.tencent.mm.cd.a)) {
            break label66;
          }
          paramContext = localObject;
        }
      }
      label66:
      for (;;)
      {
        AppMethodBeat.o(238389);
        return paramContext;
        paramContext = null;
        break;
      }
    }
    
    public static <T extends com.tencent.mm.cd.a> T a(Context paramContext, String paramString, int paramInt, Class<T> paramClass)
    {
      AppMethodBeat.i(238396);
      p.k(paramContext, "context");
      p.k(paramString, "activityName");
      p.k(paramClass, "clazz");
      Object localObject1 = hU(paramContext);
      if (localObject1 != null) {}
      for (localObject1 = ((a)localObject1).aee(paramInt);; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          paramString = (h)new com.tencent.mm.plugin.secdata.a(paramString, paramClass, paramInt, false);
          paramContext = hU(paramContext);
          localObject2 = paramString;
          if (paramContext != null)
          {
            paramContext.a(paramString);
            localObject2 = paramString;
          }
        }
        paramString = ((h)localObject2).fFn();
        paramContext = paramString;
        if (!(paramString instanceof com.tencent.mm.cd.a)) {
          paramContext = null;
        }
        AppMethodBeat.o(238396);
        return paramContext;
      }
    }
    
    public static <T extends com.tencent.mm.cd.a> void a(View paramView, T paramT)
    {
      AppMethodBeat.i(238403);
      p.k(paramView, "convertView");
      p.k(paramT, "data");
      Object localObject1 = paramView.getContext();
      p.j(localObject1, "convertView.context");
      localObject1 = hU((Context)localObject1);
      if (localObject1 != null) {}
      for (localObject1 = ((a)localObject1).fFs();; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject1 = (f)new d();
          localObject2 = paramView.getContext();
          p.j(localObject2, "convertView.context");
          a locala = hU((Context)localObject2);
          localObject2 = localObject1;
          if (locala != null)
          {
            locala.a((f)localObject1);
            localObject2 = localObject1;
          }
        }
        ((f)localObject2).c(String.valueOf(paramView.hashCode()), paramT);
        AppMethodBeat.o(238403);
        return;
      }
    }
    
    public static <T extends com.tencent.mm.cd.a> T b(Context paramContext, int paramInt, Class<T> paramClass)
    {
      AppMethodBeat.i(238393);
      p.k(paramContext, "context");
      p.k(paramClass, "clazz");
      paramContext = hU(paramContext);
      if (paramContext != null)
      {
        paramContext = paramContext.c(paramInt, paramClass);
        AppMethodBeat.o(238393);
        return paramContext;
      }
      AppMethodBeat.o(238393);
      return null;
    }
    
    public static <T extends com.tencent.mm.cd.a> T c(Context paramContext, int paramInt, Class<T> paramClass)
    {
      AppMethodBeat.i(238399);
      p.k(paramContext, "context");
      p.k(paramClass, "clazz");
      Object localObject1 = hU(paramContext);
      if (localObject1 != null) {}
      for (localObject1 = ((a)localObject1).aee(paramInt);; localObject1 = null)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          paramClass = (h)new e(paramClass, paramInt);
          paramContext = hU(paramContext);
          localObject2 = paramClass;
          if (paramContext != null)
          {
            paramContext.a(paramClass);
            localObject2 = paramClass;
          }
        }
        paramClass = ((h)localObject2).fFn();
        paramContext = paramClass;
        if (!(paramClass instanceof com.tencent.mm.cd.a)) {
          paramContext = null;
        }
        AppMethodBeat.o(238399);
        return paramContext;
      }
    }
    
    public static <T extends com.tencent.mm.cd.a> T ga(View paramView)
    {
      AppMethodBeat.i(238405);
      p.k(paramView, "view");
      Object localObject = paramView.getContext();
      p.j(localObject, "view.context");
      localObject = hU((Context)localObject);
      if (localObject != null)
      {
        localObject = ((a)localObject).fFs();
        if (localObject == null) {}
      }
      for (localObject = ((f)localObject).fFq(); (localObject != null) && (((Map)localObject).containsKey(String.valueOf(paramView.hashCode())) == true); localObject = null)
      {
        paramView = (com.tencent.mm.cd.a)((Map)localObject).get(String.valueOf(paramView.hashCode()));
        AppMethodBeat.o(238405);
        return paramView;
      }
      paramView = paramView.getParent();
      if ((paramView == null) || ((localObject != null) && (((Map)localObject).containsKey(String.valueOf(paramView.hashCode())) == true)))
      {
        if (localObject == null) {
          break label176;
        }
        if (paramView == null) {
          break label171;
        }
      }
      label171:
      for (int i = paramView.hashCode();; i = 0)
      {
        paramView = (com.tencent.mm.cd.a)((Map)localObject).get(String.valueOf(i));
        AppMethodBeat.o(238405);
        return paramView;
        paramView = paramView.getParent();
        break;
      }
      label176:
      AppMethodBeat.o(238405);
      return null;
    }
    
    public static a hU(Context paramContext)
    {
      AppMethodBeat.i(238385);
      p.k(paramContext, "context");
      if ((paramContext instanceof UIComponentActivity))
      {
        g localg = g.Xox;
        paramContext = (a)g.b((AppCompatActivity)paramContext).i(a.class);
        AppMethodBeat.o(238385);
        return paramContext;
      }
      AppMethodBeat.o(238385);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.ui.a
 * JD-Core Version:    0.7.0.1
 */