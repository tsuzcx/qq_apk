package com.tencent.mm.plugin.textstatus.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.a.a.a;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.h.e.c;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.ae;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper;", "Lcom/tencent/mm/plugin/textstatus/util/IStatusIconHelper;", "()V", "FILLED_CACHE", "", "", "Landroid/graphics/Bitmap;", "getFILLED_CACHE", "()Ljava/util/Map;", "OUTLINED_CACHE", "getOUTLINED_CACHE", "READ_CACHE", "getREAD_CACHE", "TAG", "i18NLanguage", "", "getI18NLanguage", "()[Ljava/lang/String;", "[Ljava/lang/String;", "iconItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$IconItem;", "Lkotlin/collections/HashMap;", "getIconItemMap", "()Ljava/util/HashMap;", "setIconItemMap", "(Ljava/util/HashMap;)V", "statusResItem", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StatusResItem;", "getStatusResItem", "()Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StatusResItem;", "setStatusResItem", "(Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StatusResItem;)V", "checkIconResidentConfig", "", "iconId", "getClusterDesByInfo", "topicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "sameTopicSize", "", "name", "type", "getCoverAgendaIconId", "getCoverAgendaIconIdForReport", "getDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "getFolderResVersion", "folderPath", "getIcon", "id", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "getIconDrawable", "Landroid/graphics/drawable/Drawable;", "iconColor", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;", "getIconSpan", "Landroid/text/style/ImageSpan;", "attachView", "Landroid/view/View;", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "size", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getName", "getNameByInfo", "getResVersion", "", "getZipVersion", "filePath", "handleIconConfigResult", "", "rsp", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetIconConfigResp;", "ifUseOriginalImage", "initTextStatusResItem", "initTextStatusResource", "isIconValidForSet", "onCreate", "onDestroy", "replaceTextStatusResource", "updateVersion", "reqNewestIconConfig", "isClientVersionChange", "(Ljava/lang/Boolean;)V", "reset", "setBigIcon", "iv", "Landroid/widget/ImageView;", "setCoverAgendaClickTime", "clickTime", "setCoverAgendaIconId", "setI18NValue", "valuesMap", "xmlMap", "", "prefix", "setIcon", "setIconResident", "updateStatusRes", "resItem", "updateTextStatusResource", "CategoryItem", "IconItem", "StatusResItem", "StyleArray", "StyleArrayItem", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
{
  public static final f TAW;
  private static HashMap<String, b> TAY;
  private static c TAZ;
  private static final Map<String, Bitmap> TBa;
  private static final Map<String, Bitmap> TBb;
  private static final Map<String, Bitmap> TBc;
  private static final String[] TBd;
  
  static
  {
    AppMethodBeat.i(290494);
    TAW = new f();
    TAY = new HashMap();
    TBa = (Map)new LinkedHashMap();
    TBb = (Map)new LinkedHashMap();
    TBc = (Map)new LinkedHashMap();
    TBd = new String[] { "zh_CN", "en", "zh_HK", "zh_TW" };
    AppMethodBeat.o(290494);
  }
  
  private static Drawable a(String paramString, a.c paramc, a.a parama)
  {
    AppMethodBeat.i(290440);
    s.u(paramc, "iconType");
    s.u(parama, "iconColor");
    int i;
    String str;
    Object localObject1;
    Object localObject2;
    label94:
    long l1;
    if (paramString != null)
    {
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label94;
        }
        str = paramString;
      }
      for (;;)
      {
        if (str != null)
        {
          String.valueOf(str);
          localObject1 = null;
          localObject2 = (b)TAY.get(str);
          if (localObject2 == null)
          {
            localObject2 = null;
            if (localObject2 != null) {
              break label333;
            }
            AppMethodBeat.o(290440);
            return null;
            i = 0;
            break;
            str = null;
            continue;
          }
          l1 = k.bR(((b)localObject2).TBf, 0L);
          long l2 = cn.getSyncServerTimeSecond();
          if (l1 <= l2) {
            if (l2 <= 9223372036854775807L)
            {
              i = 1;
              label136:
              if (i == 0) {
                break label315;
              }
              paramString = ((b)localObject2).iconId;
              localObject1 = ((Iterable)((b)localObject2).TBk.bMQ).iterator();
              label164:
              if (!((Iterator)localObject1).hasNext()) {
                break label322;
              }
              localObject2 = (f.e)((Iterator)localObject1).next();
              l2 = k.bR(((f.e)localObject2).beginTime, 0L);
              if ((((f.e)localObject2).endTime > 0L) && (((f.e)localObject2).endTime > ((f.e)localObject2).beginTime)) {
                break label295;
              }
              l1 = 9223372036854775807L;
              label226:
              long l3 = cn.getSyncServerTimeSecond();
              if (l2 > l3) {
                break label310;
              }
              if (l3 > l1) {
                break label305;
              }
              i = 1;
              label250:
              if (i == 0) {
                break label726;
              }
              paramString = paramString + '_' + ((f.e)localObject2).sbV;
            }
          }
        }
      }
    }
    label295:
    label305:
    label310:
    label315:
    label322:
    label333:
    label723:
    label726:
    for (;;)
    {
      break label164;
      i = 0;
      break label136;
      i = 0;
      break label136;
      l1 = ((f.e)localObject2).endTime;
      break label226;
      i = 0;
      break label250;
      i = 0;
      break label250;
      AppMethodBeat.o(290440);
      return null;
      localObject2 = kotlin.ah.aiuX;
      localObject1 = paramString;
      break;
      if ((bel(str)) && (parama == a.a.Thw))
      {
        localObject2 = a.c.ThQ;
        switch (f.$EnumSwitchMapping$0[localObject2.ordinal()])
        {
        default: 
          paramString = (Bitmap)TBb.get(localObject1);
          if ((paramString != null) && (!paramString.isRecycled())) {
            Log.i("MicroMsg.TextStatus.StatusIconHelper", s.X("cache icon ", localObject1));
          }
          break;
        }
      }
      for (;;)
      {
        if (paramString != null)
        {
          paramString = a(paramString, bel(str), paramc, parama);
          AppMethodBeat.o(290440);
          return paramString;
          localObject2 = paramc;
          break;
          paramString = (Bitmap)TBa.get(localObject1);
          break label398;
          paramString = (Bitmap)TBc.get(localObject1);
          break label398;
          Object localObject3 = e.TAU;
          localObject3 = new u(String.valueOf(e.hKm()));
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((u)localObject3).jKS())) {
            break label723;
          }
          switch (f.$EnumSwitchMapping$0[localObject2.ordinal()])
          {
          default: 
            paramString = "_filled";
          }
          for (;;)
          {
            localObject3 = BitmapUtil.decodeFile(com.tencent.mm.vfs.ah.v(new u((u)localObject3, (String)localObject1 + paramString + ".png").jKT()), null);
            paramString = (String)localObject3;
            if (localObject3 == null) {
              break;
            }
            ((Bitmap)localObject3).setDensity(320);
            if (localObject2 != a.c.ThO) {
              break label663;
            }
            TBa.put(localObject1, localObject3);
            paramString = (String)localObject3;
            break;
            paramString = "_outlined";
            continue;
            paramString = "_read";
          }
          if (localObject2 == a.c.ThQ)
          {
            TBc.put(localObject1, localObject3);
            paramString = (String)localObject3;
            continue;
          }
          TBb.put(localObject1, localObject3);
          paramString = (String)localObject3;
          continue;
        }
        AppMethodBeat.o(290440);
        return null;
        AppMethodBeat.o(290440);
        return null;
      }
    }
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(290460);
    Iterator localIterator = ((Iterable)paramc.TBl).iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label186;
      }
      b localb = (b)localIterator.next();
      if (localb.TBh == 1)
      {
        Object localObject2 = localb.iconId;
        Object localObject1 = h.baE().ban().b(at.a.adgM, "");
        localObject2 = "<" + (String)localObject2 + ":1>";
        s.s(localObject1, "residentConfig");
        if ((n.i((CharSequence)localObject1, (CharSequence)localObject2)) && (localb.hKt()))
        {
          localObject1 = ((Iterable)paramc.rbS).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (a)((Iterator)localObject1).next();
            if (!s.p(((a)localObject2).id, localb.TBi)) {
              break;
            }
            ((a)localObject2).bMQ.add(localb);
          }
        }
      }
    }
    label186:
    AppMethodBeat.o(290460);
  }
  
  public static void a(Map<String, String> paramMap1, Map<String, String> paramMap2, String paramString)
  {
    AppMethodBeat.i(290421);
    s.u(paramMap1, "valuesMap");
    s.u(paramMap2, "xmlMap");
    s.u(paramString, "prefix");
    String[] arrayOfString = TBd;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfString[i];
      String str2 = Util.safeFormatString(Util.nullAs((String)paramMap2.get(paramString + '.' + str1), ""), new Object[] { "" });
      s.s(str2, "safeFormatString(Util.nu…\"$prefix.${it}\"],\"\"), \"\")");
      paramMap1.put(str1, str2);
      i += 1;
    }
    AppMethodBeat.o(290421);
  }
  
  private static boolean bel(String paramString)
  {
    AppMethodBeat.i(290446);
    paramString = (b)TAY.get(paramString);
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.TBg)
    {
      boolean bool = Util.isEqual(paramString, "1");
      AppMethodBeat.o(290446);
      return bool;
    }
  }
  
  private static int bem(String paramString)
  {
    AppMethodBeat.i(290468);
    s.u(paramString, "filePath");
    u localu = new u(MMApplicationContext.getContext().getCacheDir(), "TextStatus/temp");
    if (localu.jKS()) {
      y.ew(com.tencent.mm.vfs.ah.v(localu.jKT()), true);
    }
    y.bDX(com.tencent.mm.vfs.ah.v(localu.jKT()));
    int j = y.aA(paramString, com.tencent.mm.vfs.ah.v(localu.jKT()));
    int i = -1;
    if (j == 0)
    {
      paramString = com.tencent.mm.vfs.ah.v(localu.jKT());
      s.s(paramString, "tempOutputFolder.absolutePath");
      i = ben(paramString);
    }
    for (;;)
    {
      y.ew(com.tencent.mm.vfs.ah.v(localu.jKT()), true);
      AppMethodBeat.o(290468);
      return i;
      Log.i("MicroMsg.TextStatus.StatusIconHelper", "getZipVersion unzip fail " + j + ' ' + paramString);
    }
  }
  
  private static int ben(String paramString)
  {
    AppMethodBeat.i(290479);
    s.u(paramString, "folderPath");
    Object localObject1 = s.X(paramString, "/TextStateIconConfig.xml");
    if (y.ZC((String)localObject1))
    {
      localObject1 = XmlParser.parseXml(y.bEn(com.tencent.mm.vfs.ah.v(new u((String)localObject1).jKT())), "textStateResource", "");
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder("getFolderResVersion fail xmlMap is null:").append(paramString).append(' ');
        localObject2 = y.eB(paramString, false);
        if (localObject2 == null) {}
        for (paramString = null;; paramString = (List)paramString)
        {
          Log.i("MicroMsg.TextStatus.StatusIconHelper", paramString);
          AppMethodBeat.o(290479);
          return -1;
          paramString = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            paramString.add(((j)((Iterator)localObject2).next()).name);
          }
        }
      }
      int i = Util.safeParseInt((String)((Map)localObject1).get(".textStateResource.version"));
      Log.i("MicroMsg.TextStatus.StatusIconHelper", s.X("getFolderResVersion unzipVersion ", Integer.valueOf(i)));
      AppMethodBeat.o(290479);
      return i;
    }
    localObject1 = new StringBuilder("getFolderResVersion fail not exist configPath:").append(paramString).append(' ');
    Object localObject2 = y.eB(paramString, false);
    if (localObject2 == null) {}
    for (paramString = null;; paramString = (List)paramString)
    {
      Log.i("MicroMsg.TextStatus.StatusIconHelper", paramString);
      AppMethodBeat.o(290479);
      return -1;
      paramString = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramString.add(((j)((Iterator)localObject2).next()).name);
      }
    }
  }
  
  public static HashMap<String, b> hKq()
  {
    return TAY;
  }
  
  private static void hKr()
  {
    AppMethodBeat.i(290487);
    if (!b.hKg())
    {
      AppMethodBeat.o(290487);
      return;
    }
    reset();
    Object localObject = e.TAU;
    localObject = s.X(e.hKm(), "/TextStateIconConfig.xml");
    if (y.ZC((String)localObject))
    {
      localObject = XmlParser.parseXml(y.bEn(com.tencent.mm.vfs.ah.v(new u((String)localObject).jKT())), "textStateResource", "");
      if (localObject != null)
      {
        localObject = new c((Map)localObject);
        a((c)localObject);
        kotlin.ah localah = kotlin.ah.aiuX;
        TAZ = (c)localObject;
      }
      localObject = TAZ;
      if (localObject == null) {}
      for (int i = -1;; i = ((c)localObject).version)
      {
        Log.i("MicroMsg.TextStatus.StatusIconHelper", s.X("initTextStatusResItem version:", Integer.valueOf(i)));
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1629L, 8L, 1L, false);
        AppMethodBeat.o(290487);
        return;
      }
    }
    Log.i("MicroMsg.TextStatus.StatusIconHelper", s.X("initTextStatusResItem fail config path not exist ", localObject));
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1629L, 7L, 1L, false);
    AppMethodBeat.o(290487);
  }
  
  private static void hu(String paramString, int paramInt)
  {
    AppMethodBeat.i(290492);
    s.u(paramString, "filePath");
    Object localObject = e.TAU;
    localObject = e.hKm();
    y.ew((String)localObject, true);
    if (!y.ZC((String)localObject)) {
      y.bDX((String)localObject);
    }
    int i = y.aA(paramString, (String)localObject);
    localObject = new StringBuilder("replaceTextStatusResource updateVersion currentVersion:");
    paramString = TAZ;
    if (paramString == null) {}
    for (paramString = null;; paramString = Integer.valueOf(paramString.version))
    {
      Log.i("MicroMsg.TextStatus.StatusIconHelper", paramString + " updateVersion:" + paramInt + " unzipRet:" + i);
      if (i != 0) {
        break;
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1629L, 12L, 1L, false);
      hKr();
      AppMethodBeat.o(290492);
      return;
    }
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1629L, 13L, 1L, false);
    AppMethodBeat.o(290492);
  }
  
  private static void reset()
  {
    AppMethodBeat.i(290450);
    TAY.clear();
    TBa.clear();
    TBb.clear();
    TBc.clear();
    AppMethodBeat.o(290450);
  }
  
  public final void G(Boolean paramBoolean) {}
  
  public final ImageSpan a(View paramView, String paramString, a.c paramc, a.a parama, a.b paramb, int paramInt, com.tencent.mm.plugin.textstatus.h.f.b paramb1)
  {
    AppMethodBeat.i(290587);
    s.u(paramc, "iconType");
    s.u(parama, "iconColor");
    paramView = a(paramString, paramc, parama);
    if (paramView != null)
    {
      paramView.setBounds(0, 0, paramInt, paramInt);
      paramView = (ImageSpan)new i(paramView, paramb1, paramb);
      AppMethodBeat.o(290587);
      return paramView;
    }
    AppMethodBeat.o(290587);
    return null;
  }
  
  public final String a(TextStatusTopicInfo paramTextStatusTopicInfo, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(290536);
    s.u(paramString, "name");
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(290536);
      return "";
    case 1: 
      paramTextStatusTopicInfo = MMApplicationContext.getContext().getResources().getString(a.h.TgA, new Object[] { Integer.valueOf(paramInt1), paramString });
      s.s(paramTextStatusTopicInfo, "getContext().resources.g…too, sameTopicSize, name)");
      AppMethodBeat.o(290536);
      return paramTextStatusTopicInfo;
    }
    paramTextStatusTopicInfo = MMApplicationContext.getContext().getResources().getString(a.h.Tgx, new Object[] { Integer.valueOf(paramInt1), paramString });
    s.s(paramTextStatusTopicInfo, "getContext().resources.g…ame, sameTopicSize, name)");
    AppMethodBeat.o(290536);
    return paramTextStatusTopicInfo;
  }
  
  public final void a(ImageView paramImageView, String paramString, a.c paramc, a.a parama)
  {
    AppMethodBeat.i(290624);
    s.u(paramc, "iconType");
    s.u(parama, "iconColor");
    AppMethodBeat.o(290624);
  }
  
  public final void a(ImageView paramImageView, String paramString, a.c paramc, a.a parama, com.tencent.mm.plugin.textstatus.h.f.b paramb)
  {
    AppMethodBeat.i(290619);
    s.u(paramc, "iconType");
    s.u(parama, "iconColor");
    paramString = a(paramString, a.c.ThO, a.a.Thr);
    if (paramImageView != null) {
      paramImageView.setImageDrawable(paramString);
    }
    AppMethodBeat.o(290619);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(290599);
    s.u(paramae, "rsp");
    AppMethodBeat.o(290599);
  }
  
  public final boolean beh(String paramString)
  {
    AppMethodBeat.i(290514);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(290514);
      return false;
    }
    paramString = (b)TAY.get(paramString);
    if ((paramString != null) && (paramString.hKt() == true))
    {
      AppMethodBeat.o(290514);
      return true;
    }
    AppMethodBeat.o(290514);
    return false;
  }
  
  public final String bei(String paramString)
  {
    AppMethodBeat.i(290519);
    paramString = (b)((Map)TAY).get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(290519);
      return "";
    }
    paramString = paramString.hKs();
    if (paramString == null)
    {
      AppMethodBeat.o(290519);
      return "";
    }
    AppMethodBeat.o(290519);
    return paramString;
  }
  
  public final void bej(String paramString)
  {
    AppMethodBeat.i(290565);
    s.u(paramString, "iconId");
    AppMethodBeat.o(290565);
  }
  
  public final void beo(String paramString)
  {
    AppMethodBeat.i(290580);
    s.u(paramString, "filePath");
    Log.i("MicroMsg.TextStatus.StatusIconHelper", "updateTextStatusResource " + paramString + ' ' + y.bEl(paramString));
    int j = bem(paramString);
    c localc = TAZ;
    if (localc == null) {}
    for (int i = -1; i < j; i = localc.version)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1629L, 10L, 1L, false);
      hu(paramString, j);
      AppMethodBeat.o(290580);
      return;
    }
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1629L, 11L, 1L, false);
    Log.i("MicroMsg.TextStatus.StatusIconHelper", s.X("updateTextStatusResource no need to updateVersion currentVersion:-1 updateVersion:", Integer.valueOf(j)));
    AppMethodBeat.o(290580);
  }
  
  public final String f(TextStatusTopicInfo paramTextStatusTopicInfo)
  {
    AppMethodBeat.i(290523);
    if (paramTextStatusTopicInfo == null)
    {
      AppMethodBeat.o(290523);
      return "";
    }
    if (s.p(paramTextStatusTopicInfo.iconId, "userdefine"))
    {
      paramTextStatusTopicInfo = paramTextStatusTopicInfo.title;
      if (paramTextStatusTopicInfo == null)
      {
        AppMethodBeat.o(290523);
        return "";
      }
      AppMethodBeat.o(290523);
      return paramTextStatusTopicInfo;
    }
    paramTextStatusTopicInfo = bei(paramTextStatusTopicInfo.iconId);
    AppMethodBeat.o(290523);
    return paramTextStatusTopicInfo;
  }
  
  public final ArrayList<com.tencent.mm.view.recyclerview.a> getDataList()
  {
    AppMethodBeat.i(290549);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.tencent.mm.plugin.textstatus.h.e.b(MMApplicationContext.getContext().getString(a.h.TgR)));
    Object localObject1 = TAZ;
    if (localObject1 != null)
    {
      Iterator localIterator = ((c)localObject1).rbS.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        Object localObject2 = new LinkedList();
        localObject1 = locala.bMQ.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          b localb = (b)((Iterator)localObject1).next();
          if (localb.hKt()) {
            ((LinkedList)localObject2).add(localb);
          }
        }
        if (((LinkedList)localObject2).size() > 0)
        {
          localObject1 = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
          localObject1 = (String)locala.TBe.get(localObject1);
          int i;
          if (localObject1 != null) {
            if (((CharSequence)localObject1).length() > 0)
            {
              i = 1;
              label183:
              if (i != 1) {
                break label263;
              }
              i = 1;
              label190:
              if (i == 0) {
                break label268;
              }
            }
          }
          for (;;)
          {
            localArrayList.add(new com.tencent.mm.plugin.textstatus.h.e.a((String)localObject1));
            localObject1 = ((LinkedList)localObject2).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (b)((Iterator)localObject1).next();
              localArrayList.add(new c(((b)localObject2).hKs(), ((b)localObject2).iconId));
            }
            break;
            i = 0;
            break label183;
            label263:
            i = 0;
            break label190;
            label268:
            localObject1 = (String)locala.TBe.get("en");
          }
        }
      }
    }
    AppMethodBeat.o(290549);
    return localArrayList;
  }
  
  public final long getResVersion()
  {
    c localc = TAZ;
    if (localc == null) {}
    for (int i = -1;; i = localc.version) {
      return i;
    }
  }
  
  public final String hKe()
  {
    return null;
  }
  
  public final String hKf()
  {
    return "";
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(290498);
    super.onCreate();
    long l = cn.bDw();
    Object localObject1 = e.TAU;
    int i = ben(e.hKm());
    Object localObject2 = y.bi("assets:///text_status_res/TextStatus.zip", 0, -1);
    localObject1 = new u(MMApplicationContext.getContext().getCacheDir(), "TextStatus");
    y.bDX(com.tencent.mm.vfs.ah.v(((u)localObject1).jKT()));
    localObject1 = new u((u)localObject1, "asset.zip");
    if (((u)localObject1).jKS()) {
      ((u)localObject1).diJ();
    }
    y.f(com.tencent.mm.vfs.ah.v(((u)localObject1).jKT()), (byte[])localObject2, localObject2.length);
    localObject2 = com.tencent.mm.vfs.ah.v(((u)localObject1).jKT());
    s.s(localObject2, "tempOutputZip.absolutePath");
    int j = bem((String)localObject2);
    if (j > i)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1629L, 14L, 1L, false);
      localObject2 = com.tencent.mm.vfs.ah.v(((u)localObject1).jKT());
      s.s(localObject2, "tempOutputZip.absolutePath");
      hu((String)localObject2, j);
    }
    for (;;)
    {
      ((u)localObject1).diJ();
      Log.i("MicroMsg.TextStatus.StatusIconHelper", s.X("initTextStatusResource cost:", Long.valueOf(cn.bDw() - l)));
      AppMethodBeat.o(290498);
      return;
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1629L, 15L, 1L, false);
      hKr();
      Log.i("MicroMsg.TextStatus.StatusIconHelper", "initTextStatusResource no need to updateVersion currentVersion:" + i + " assetVersion:" + j);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(290505);
    super.onDestroy();
    AppMethodBeat.o(290505);
  }
  
  public final void wn(long paramLong) {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$CategoryItem;", "", "prefix", "", "xmlMap", "", "(Ljava/lang/String;Ljava/util/Map;)V", "descMap", "", "getDescMap", "()Ljava/util/Map;", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "items", "", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$IconItem;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getDes", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    final Map<String, String> TBe;
    List<f.b> bMQ;
    String id;
    
    public a(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(290333);
      Object localObject = Util.safeFormatString(Util.nullAs((String)paramMap.get(s.X(paramString, ".$categoryId")), ""), new Object[] { "" });
      s.s(localObject, "safeFormatString(Util.nu…x.\\$categoryId\"], \"\"),\"\")");
      this.id = ((String)localObject);
      this.bMQ = ((List)new LinkedList());
      this.TBe = ((Map)new HashMap());
      String str = s.X(paramString, ".iconArray.iconItem");
      localObject = str;
      int i = 1;
      while (paramMap.get(localObject) != null)
      {
        f.b localb = new f.b((String)localObject, paramMap);
        localObject = s.X(str, Integer.valueOf(i));
        i += 1;
        this.bMQ.add(localb);
        f localf = f.TAW;
        ((Map)f.hKq()).put(localb.iconId, localb);
      }
      localObject = f.TAW;
      f.a(this.TBe, paramMap, s.X(paramString, ".description"));
      AppMethodBeat.o(290333);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$IconItem;", "", "prefix", "", "xmlMap", "", "(Ljava/lang/String;Ljava/util/Map;)V", "descMap", "", "getDescMap", "()Ljava/util/Map;", "setDescMap", "(Ljava/util/Map;)V", "effectTime", "", "getEffectTime", "()J", "setEffectTime", "(J)V", "expiredTime", "getExpiredTime", "setExpiredTime", "iconId", "getIconId", "()Ljava/lang/String;", "setIconId", "(Ljava/lang/String;)V", "residentAfterPublish", "", "getResidentAfterPublish", "()I", "setResidentAfterPublish", "(I)V", "residentCategoryId", "getResidentCategoryId", "setResidentCategoryId", "sameFriendsTipMap", "getSameFriendsTipMap", "setSameFriendsTipMap", "styleArray", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StyleArray;", "getStyleArray", "()Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StyleArray;", "setStyleArray", "(Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StyleArray;)V", "useOriginalImage", "getUseOriginalImage", "setUseOriginalImage", "getDes", "getSameFriendsTip", "getStyleIconId", "isIconDrawableValid", "", "isIconValid", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    private long PLi;
    private Map<String, String> TBe;
    long TBf;
    String TBg;
    int TBh;
    String TBi;
    private Map<String, String> TBj;
    f.d TBk;
    String iconId;
    
    public b(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(290339);
      Object localObject = Util.safeFormatString(Util.nullAs((String)paramMap.get(s.X(paramString, ".$iconId")), ""), new Object[] { "" });
      s.s(localObject, "safeFormatString(Util.nu…efix.\\$iconId\"], \"\"), \"\")");
      this.iconId = ((String)localObject);
      this.TBf = Util.safeParseLong((String)paramMap.get(s.X(paramString, ".effectTime")));
      this.PLi = Util.safeParseLong((String)paramMap.get(s.X(paramString, ".expireTime")));
      localObject = Util.safeFormatString(Util.nullAs((String)paramMap.get(s.X(paramString, ".useOriginalImage")), ""), new Object[] { "" });
      s.s(localObject, "safeFormatString(Util.nu…OriginalImage\"], \"\"), \"\")");
      this.TBg = ((String)localObject);
      this.TBh = Util.safeParseInt(Util.nullAs((String)paramMap.get(s.X(paramString, ".residentAfterPublish")), ""));
      localObject = Util.safeFormatString(Util.nullAs((String)paramMap.get(s.X(paramString, ".residentCategoryId")), ""), new Object[] { "" });
      s.s(localObject, "safeFormatString(Util.nu…entCategoryId\"], \"\"), \"\")");
      this.TBi = ((String)localObject);
      this.TBe = ((Map)new HashMap());
      this.TBj = ((Map)new HashMap());
      this.TBk = new f.d(s.X(paramString, ".styleArray"), paramMap);
      localObject = f.TAW;
      f.a(this.TBe, paramMap, s.X(paramString, ".description"));
      localObject = f.TAW;
      f.a(this.TBj, paramMap, s.X(paramString, ".sameFriendsTip"));
      AppMethodBeat.o(290339);
    }
    
    public final String hKs()
    {
      AppMethodBeat.i(290347);
      if (s.p(this.iconId, "userdefine"))
      {
        str = h.baE().ban().b(at.a.adgN, "");
        CharSequence localCharSequence = (CharSequence)str;
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(290347);
          return str;
        }
      }
      String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
      str = (String)this.TBe.get(str);
      if (str != null) {
        if (((CharSequence)str).length() > 0)
        {
          i = 1;
          if (i != 1) {
            break label130;
          }
        }
      }
      label130:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label135;
        }
        AppMethodBeat.o(290347);
        return str;
        i = 0;
        break;
      }
      label135:
      str = (String)this.TBe.get("en");
      AppMethodBeat.o(290347);
      return str;
    }
    
    public final boolean hKt()
    {
      AppMethodBeat.i(290353);
      long l2 = k.bR(this.TBf, 0L);
      if ((this.PLi <= 0L) || (this.PLi <= this.TBf)) {}
      for (long l1 = 9223372036854775807L;; l1 = this.PLi)
      {
        long l3 = cn.getSyncServerTimeSecond();
        if (l2 > l3) {
          break label81;
        }
        if (l3 > l1) {
          break;
        }
        AppMethodBeat.o(290353);
        return true;
      }
      AppMethodBeat.o(290353);
      return false;
      label81:
      AppMethodBeat.o(290353);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StatusResItem;", "", "xmlMap", "", "", "(Ljava/util/Map;)V", "categories", "", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$CategoryItem;", "getCategories", "()Ljava/util/List;", "setCategories", "(Ljava/util/List;)V", "hideItems", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$IconItem;", "getHideItems", "setHideItems", "version", "", "getVersion", "()I", "setVersion", "(I)V", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    List<f.b> TBl;
    List<f.a> rbS;
    int version;
    
    public c(Map<String, String> paramMap)
    {
      AppMethodBeat.i(290355);
      this.version = Util.safeParseInt((String)paramMap.get(".textStateResource.version"));
      this.rbS = ((List)new LinkedList());
      Object localObject1 = ".textStateResource.categoryArray.categoryItem";
      int i = 1;
      Object localObject2;
      while (paramMap.get(localObject1) != null)
      {
        localObject2 = new f.a((String)localObject1, paramMap);
        localObject1 = s.X(".textStateResource.categoryArray.categoryItem", Integer.valueOf(i));
        i += 1;
        this.rbS.add(localObject2);
      }
      this.TBl = ((List)new LinkedList());
      localObject1 = ".textStateResource.otherIcons.iconArray.iconItem";
      i = j;
      while (paramMap.get(localObject1) != null)
      {
        localObject2 = new f.b((String)localObject1, paramMap);
        localObject1 = s.X(".textStateResource.otherIcons.iconArray.iconItem", Integer.valueOf(i));
        i += 1;
        this.TBl.add(localObject2);
        f localf = f.TAW;
        ((Map)f.hKq()).put(((f.b)localObject2).iconId, localObject2);
      }
      paramMap = new StringBuilder("InitStatusResItem categories:").append(this.rbS.size()).append(" iconItemMap:");
      localObject1 = f.TAW;
      Log.i("MicroMsg.TextStatus.StatusIconHelper", f.hKq().size() + " hideItems:" + this.TBl.size());
      AppMethodBeat.o(290355);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.util.f
 * JD-Core Version:    0.7.0.1
 */