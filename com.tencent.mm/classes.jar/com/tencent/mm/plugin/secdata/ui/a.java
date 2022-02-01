package com.tencent.mm.plugin.secdata.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.secdata.f;
import com.tencent.mm.plugin.secdata.h;
import com.tencent.mm.protocal.protobuf.aeu;
import com.tencent.mm.protocal.protobuf.aev;
import com.tencent.mm.protocal.protobuf.aew;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/secdata/ui/SecDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "listSecDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/secdata/IListSecData;", "Lkotlin/collections/HashMap;", "getListSecDataMap", "()Ljava/util/HashMap;", "pageSecDataMap", "Lcom/tencent/mm/plugin/secdata/ISecData;", "getPageSecDataMap", "reportObjList", "Lcom/tencent/mm/protocal/protobuf/CommonReportObjList;", "getReportObjList", "()Lcom/tencent/mm/protocal/protobuf/CommonReportObjList;", "getCurrentCommonReportObj", "Lcom/tencent/mm/protocal/protobuf/CommonReportObj;", "getCurrentSubReportObj", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "type", "(I)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getListSecData", "getPreSubReportObj", "pageIndex", "clazz", "Ljava/lang/Class;", "(IILjava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getSecData", "initUICData", "", "intent", "Landroid/content/Intent;", "onCreateBefore", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "onStartActivityForResult", "requestCode", "options", "registerSecData", "secData", "Companion", "ui-sec-data_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
{
  public static final a.a PlI;
  private final aev PlJ;
  private final HashMap<Integer, h<?>> PlK;
  private final HashMap<Integer, f<?>> PlL;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(261523);
    PlI = new a.a((byte)0);
    AppMethodBeat.o(261523);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(261496);
    this.TAG = "MicroMsg.SecData.SecDataUIC";
    this.PlJ = new aev();
    this.PlK = new HashMap();
    this.PlL = new HashMap();
    AppMethodBeat.o(261496);
  }
  
  private final void bq(Intent paramIntent)
  {
    AppMethodBeat.i(261509);
    this.PlK.clear();
    this.PlL.clear();
    this.PlJ.vgO.clear();
    try
    {
      paramIntent = paramIntent.getByteArrayExtra("ReportKey.CommonReportObjKey");
      if (paramIntent != null) {
        this.PlJ.parseFrom(paramIntent);
      }
    }
    catch (Exception paramIntent)
    {
      label49:
      aeu localaeu;
      break label49;
    }
    localaeu = new aeu();
    localaeu.ZmO = getActivity().getClass().getSimpleName();
    localaeu.ZmP = cn.bDw();
    paramIntent = this.PlJ.vgO;
    s.s(paramIntent, "reportObjList.List");
    paramIntent = (aeu)p.oL((List)paramIntent);
    if (paramIntent == null) {}
    for (paramIntent = null;; paramIntent = ah.aiuX)
    {
      if (paramIntent == null)
      {
        paramIntent = (a)this;
        localaeu.YWL = UUID.randomUUID().toString();
        localaeu.ZmQ = 0;
        localaeu.ZmR = 1;
        Log.i(paramIntent.TAG, "firstPage:" + localaeu.ZmO + " contextId:" + localaeu.YWL);
      }
      this.PlJ.vgO.addFirst(localaeu);
      if (this.PlJ.vgO.size() > 5) {
        this.PlJ.vgO.removeLast();
      }
      AppMethodBeat.o(261509);
      return;
      localaeu.YWL = paramIntent.YWL;
      localaeu.ZmQ = paramIntent.ZmQ;
      localaeu.ZmR = 0;
      Log.i(this.TAG, "fromPage:" + paramIntent.ZmO + " contextId:" + paramIntent.YWL + " currentPage:" + localaeu.ZmO);
    }
  }
  
  private aeu gUB()
  {
    AppMethodBeat.i(261514);
    Object localObject = this.PlJ.vgO;
    s.s(localObject, "reportObjList.List");
    localObject = (aeu)p.oL((List)localObject);
    AppMethodBeat.o(261514);
    return localObject;
  }
  
  public final <T extends com.tencent.mm.bx.a> void a(f<T> paramf)
  {
    AppMethodBeat.i(261543);
    s.u(paramf, "secData");
    ((Map)this.PlL).put(Integer.valueOf(paramf.getType()), paramf);
    AppMethodBeat.o(261543);
  }
  
  public final <T extends com.tencent.mm.bx.a> void a(h<T> paramh)
  {
    AppMethodBeat.i(261537);
    s.u(paramh, "secData");
    ((Map)this.PlK).put(Integer.valueOf(paramh.getType()), paramh);
    AppMethodBeat.o(261537);
  }
  
  public final h<?> aiJ(int paramInt)
  {
    AppMethodBeat.i(261563);
    h localh = (h)this.PlK.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(261563);
    return localh;
  }
  
  public final <T extends com.tencent.mm.bx.a> T aiK(int paramInt)
  {
    AppMethodBeat.i(261576);
    Object localObject = aiJ(paramInt);
    if (localObject == null) {}
    for (localObject = null; (localObject instanceof com.tencent.mm.bx.a); localObject = ((h)localObject).gUv())
    {
      AppMethodBeat.o(261576);
      return localObject;
    }
    AppMethodBeat.o(261576);
    return null;
  }
  
  public final <T extends com.tencent.mm.bx.a> T c(int paramInt, Class<T> paramClass)
  {
    AppMethodBeat.i(261553);
    s.u(paramClass, "clazz");
    Object localObject = this.PlJ.vgO;
    int i;
    if (((LinkedList)localObject).size() > 1)
    {
      i = 1;
      if (i == 0) {
        break label165;
      }
      label37:
      if (localObject == null) {
        break label182;
      }
      localObject = (aeu)((LinkedList)localObject).get(1);
      if (localObject == null) {
        break label182;
      }
      localObject = ((aeu)localObject).ZmS;
      if (localObject == null) {
        break label182;
      }
      Iterator localIterator = ((Iterable)localObject).iterator();
      label82:
      if (!localIterator.hasNext()) {
        break label176;
      }
      localObject = localIterator.next();
      if (((aew)localObject).vhJ != paramInt) {
        break label171;
      }
      i = 1;
      label115:
      if (i == 0) {
        break label174;
      }
    }
    for (;;)
    {
      localObject = (aew)localObject;
      if (localObject == null) {
        break label182;
      }
      paramClass = (com.tencent.mm.bx.a)paramClass.newInstance();
      paramClass.parseFrom(((aew)localObject).vgA.toByteArray());
      AppMethodBeat.o(261553);
      return paramClass;
      i = 0;
      break;
      label165:
      localObject = null;
      break label37;
      label171:
      i = 0;
      break label115;
      label174:
      break label82;
      label176:
      localObject = null;
    }
    label182:
    AppMethodBeat.o(261553);
    return null;
  }
  
  public final <T extends com.tencent.mm.bx.a> f<T> gUA()
  {
    AppMethodBeat.i(261571);
    Object localObject = this.PlL.get(Integer.valueOf(1));
    if ((localObject instanceof f))
    {
      localObject = (f)localObject;
      AppMethodBeat.o(261571);
      return localObject;
    }
    AppMethodBeat.o(261571);
    return null;
  }
  
  public final void onCreateBefore(Bundle paramBundle)
  {
    AppMethodBeat.i(261530);
    super.onCreateBefore(paramBundle);
    bq(getIntent());
    AppMethodBeat.o(261530);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(261583);
    Log.i(this.TAG, s.X("onNewIntent ", paramIntent));
    a locala;
    if (paramIntent == null)
    {
      paramIntent = null;
      if (paramIntent == null)
      {
        locala = (a)this;
        paramIntent = locala.getIntent();
        if (!paramIntent.getBooleanExtra("ReportKey.CommonReportNewIntentClearKey", false)) {
          break label104;
        }
      }
    }
    for (;;)
    {
      if (paramIntent != null) {
        locala.bq(paramIntent);
      }
      AppMethodBeat.o(261583);
      return;
      if (paramIntent.getBooleanExtra("ReportKey.CommonReportNewIntentClearKey", false)) {}
      for (;;)
      {
        if (paramIntent != null) {
          break label92;
        }
        paramIntent = null;
        break;
        paramIntent = null;
      }
      label92:
      bq(paramIntent);
      paramIntent = ah.aiuX;
      break;
      label104:
      paramIntent = null;
    }
  }
  
  public final void onStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(261591);
    try
    {
      localObject1 = new HashSet();
      localObject2 = this.PlK.values();
      s.s(localObject2, "pageSecDataMap.values");
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (h)((Iterator)localObject2).next();
        if (((h)localObject3).bp(paramIntent))
        {
          localObject4 = new aew();
          ((aew)localObject4).vhJ = ((h)localObject3).getType();
          ((aew)localObject4).vgA = new b(((h)localObject3).gUv().toByteArray());
          Object localObject5 = gUB();
          if (localObject5 != null)
          {
            localObject5 = ((aeu)localObject5).ZmS;
            if (localObject5 != null) {
              ((LinkedList)localObject5).add(localObject4);
            }
          }
          if (!((h)localObject3).gUw()) {
            ((HashSet)localObject1).add(Integer.valueOf(((h)localObject3).getType()));
          }
        }
      }
      AppMethodBeat.o(261591);
    }
    catch (Exception paramIntent) {}
    return;
    Object localObject1 = ((Iterable)localObject1).iterator();
    int i;
    while (((Iterator)localObject1).hasNext())
    {
      i = ((Number)((Iterator)localObject1).next()).intValue();
      this.PlK.remove(Integer.valueOf(i));
    }
    Object localObject2 = this.PlJ.toByteArray();
    Object localObject3 = this.TAG;
    Object localObject4 = new StringBuilder("onStartActivityForResult SubObjList.size:");
    localObject1 = gUB();
    if (localObject1 == null)
    {
      localObject1 = null;
      label282:
      Log.i((String)localObject3, localObject1 + ", requestCode:" + paramInt + " options:" + paramBundle + " byteSize:" + localObject2.length);
      paramBundle = (Bundle)localObject2;
      if (localObject2.length > 262144)
      {
        paramInt = localObject2.length;
        paramBundle = this.PlJ.vgO;
        s.s(paramBundle, "reportObjList.List");
        paramBundle = (aeu)p.oL((List)paramBundle);
        if (paramBundle != null)
        {
          this.PlJ.vgO.clear();
          this.PlJ.vgO.add(paramBundle);
        }
        paramBundle = this.PlJ.toByteArray();
        i = paramBundle.length;
        Log.i(this.TAG, "data size large than 256KB origin:" + Util.getSizeKB(paramInt, 2.0D) + " current:" + Util.getSizeKB(i, 2.0D));
      }
      if (paramBundle.length >= 262144) {
        break label537;
      }
      if (paramIntent != null) {
        paramIntent.putExtra("ReportKey.CommonReportObjKey", paramBundle);
      }
    }
    for (;;)
    {
      paramIntent = gUB();
      if (paramIntent == null) {
        break;
      }
      paramIntent = paramIntent.ZmS;
      if (paramIntent == null) {
        break;
      }
      paramIntent.clear();
      AppMethodBeat.o(261591);
      return;
      localObject1 = ((aeu)localObject1).ZmS;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label282;
      }
      localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
      break label282;
      label537:
      Log.w(this.TAG, "data size two large");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.ui.a
 * JD-Core Version:    0.7.0.1
 */