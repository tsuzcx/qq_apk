package com.tencent.mm.plugin.textstatus.k;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.textstatus.a.a.a;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.b.h;
import com.tencent.mm.plugin.textstatus.g.d.b;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.k.i;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper;", "Lcom/tencent/mm/plugin/textstatus/util/IStatusIconHelper;", "()V", "FILLED_CACHE", "", "", "Landroid/graphics/Bitmap;", "getFILLED_CACHE", "()Ljava/util/Map;", "OUTLINED_CACHE", "getOUTLINED_CACHE", "READ_CACHE", "getREAD_CACHE", "TAG", "i18NLanguage", "", "getI18NLanguage", "()[Ljava/lang/String;", "[Ljava/lang/String;", "iconItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$IconItem;", "Lkotlin/collections/HashMap;", "getIconItemMap", "()Ljava/util/HashMap;", "setIconItemMap", "(Ljava/util/HashMap;)V", "statusResItem", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StatusResItem;", "getStatusResItem", "()Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StatusResItem;", "setStatusResItem", "(Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StatusResItem;)V", "checkIconResidentConfig", "", "iconId", "getDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "getFolderResVersion", "", "folderPath", "getIcon", "id", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "getIconDrawable", "Landroid/graphics/drawable/Drawable;", "iconColor", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;", "getIconSpan", "Landroid/text/style/ImageSpan;", "attachView", "Landroid/view/View;", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "size", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getName", "getNameByInfo", "topicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "getResVersion", "", "getZipVersion", "filePath", "handleIconConfigResult", "", "rsp", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusGetIconConfigResp;", "ifUseOriginalImage", "initTextStatusResItem", "initTextStatusResource", "isIconValidForSet", "onCreate", "onDestroy", "replaceTextStatusResource", "updateVersion", "reqNewestIconConfig", "reset", "setI18NValue", "valuesMap", "xmlMap", "", "prefix", "setIcon", "iv", "Landroid/widget/ImageView;", "setIconResident", "updateStatusRes", "resItem", "updateTextStatusResource", "CategoryItem", "IconItem", "StatusResItem", "StyleArray", "StyleArrayItem", "plugin-textstatus_release"})
public final class g
  extends a
{
  private static final Map<String, Bitmap> MOA;
  private static final Map<String, Bitmap> MOB;
  private static final String[] MOC;
  public static final g MOD;
  private static HashMap<String, b> MOx;
  private static c MOy;
  private static final Map<String, Bitmap> MOz;
  
  static
  {
    AppMethodBeat.i(232264);
    MOD = new g();
    MOx = new HashMap();
    MOz = (Map)new LinkedHashMap();
    MOA = (Map)new LinkedHashMap();
    MOB = (Map)new LinkedHashMap();
    MOC = new String[] { "zh_CN", "en", "zh_HK", "zh_TW" };
    AppMethodBeat.o(232264);
  }
  
  private static Drawable a(String paramString, a.c paramc, a.a parama)
  {
    AppMethodBeat.i(232242);
    kotlin.g.b.p.k(paramc, "iconType");
    kotlin.g.b.p.k(parama, "iconColor");
    String str1;
    label42:
    label93:
    label95:
    String str2;
    label121:
    Object localObject1;
    if (paramString != null)
    {
      int i;
      long l1;
      long l2;
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label239;
        }
        str1 = paramString;
        if (str1 == null) {
          break label681;
        }
        String.valueOf(str1);
        paramString = (b)MOx.get(str1);
        if (paramString == null) {
          break label289;
        }
        l1 = i.be(paramString.MOF, 0L);
        l2 = cm.bfF();
        if (l1 <= l2) {
          break label245;
        }
        i = 0;
        if (i == 0) {
          break label282;
        }
        str2 = paramString.iconId;
        paramString = ((Iterable)paramString.MOL.lxh).iterator();
      }
      label269:
      label280:
      for (;;)
      {
        if (!paramString.hasNext()) {
          break label296;
        }
        localObject1 = (g.e)paramString.next();
        l2 = i.be(((g.e)localObject1).beginTime, 0L);
        label181:
        long l3;
        if ((((g.e)localObject1).endTime <= 0L) || (((g.e)localObject1).endTime <= ((g.e)localObject1).beginTime))
        {
          l1 = 9223372036854775807L;
          l3 = cm.bfF();
          if (l2 <= l3) {
            break label269;
          }
        }
        label195:
        for (i = 0;; i = 1)
        {
          if (i == 0) {
            break label280;
          }
          str2 = str2 + '_' + ((g.e)localObject1).oWy;
          break label121;
          i = 0;
          break;
          label239:
          str1 = null;
          break label42;
          label245:
          if (9223372036854775807L < l2) {
            break label93;
          }
          i = 1;
          break label95;
          l1 = ((g.e)localObject1).endTime;
          break label181;
          if (l1 < l3) {
            break label195;
          }
        }
      }
      label282:
      AppMethodBeat.o(232242);
      return null;
      label289:
      AppMethodBeat.o(232242);
      return null;
      label296:
      if ((beL(str1)) && (parama == a.a.Mzw))
      {
        localObject1 = a.c.MzJ;
        switch (h.$EnumSwitchMapping$0[localObject1.ordinal()])
        {
        default: 
          paramString = (Bitmap)MOA.get(str2);
          label362:
          if ((paramString != null) && (!paramString.isRecycled())) {
            Log.i("MicroMsg.TextStatus.StatusIconHelper", "cache icon ".concat(String.valueOf(str2)));
          }
          break;
        }
      }
    }
    label681:
    label688:
    for (;;)
    {
      if (paramString != null)
      {
        paramString = a(paramString, beL(str1), paramc, parama);
        AppMethodBeat.o(232242);
        return paramString;
        localObject1 = paramc;
        break;
        paramString = (Bitmap)MOz.get(str2);
        break label362;
        paramString = (Bitmap)MOB.get(str2);
        break label362;
        Object localObject2 = f.MOw;
        localObject2 = new q(String.valueOf(f.gnD()));
        if ((TextUtils.isEmpty((CharSequence)str2)) || (!((q)localObject2).ifE())) {
          break label688;
        }
        switch (h.jLJ[localObject1.ordinal()])
        {
        default: 
          paramString = "_filled";
        }
        for (;;)
        {
          localObject2 = BitmapUtil.decodeFile(new q((q)localObject2, str2 + paramString + ".png").bOF(), null);
          paramString = (String)localObject2;
          if (localObject2 == null) {
            break;
          }
          ((Bitmap)localObject2).setDensity(320);
          if (localObject1 != a.c.MzH) {
            break label628;
          }
          MOz.put(str2, localObject2);
          paramString = (String)localObject2;
          break;
          paramString = "_outlined";
          continue;
          paramString = "_read";
        }
        label628:
        if (localObject1 == a.c.MzJ)
        {
          MOB.put(str2, localObject2);
          paramString = (String)localObject2;
          continue;
        }
        MOA.put(str2, localObject2);
        paramString = (String)localObject2;
        continue;
      }
      AppMethodBeat.o(232242);
      return null;
      AppMethodBeat.o(232242);
      return null;
    }
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(232252);
    Iterator localIterator = ((Iterable)paramc.MOM).iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label197;
      }
      b localb = (b)localIterator.next();
      if (localb.MOI == 1)
      {
        Object localObject1 = localb.iconId;
        Object localObject2 = h.aHG();
        kotlin.g.b.p.j(localObject2, "MMKernel.storage()");
        localObject2 = ((com.tencent.mm.kernel.f)localObject2).aHp().a(ar.a.VDL, "");
        localObject1 = "<" + (String)localObject1 + ":1>";
        kotlin.g.b.p.j(localObject2, "residentConfig");
        if ((n.g((CharSequence)localObject2, (CharSequence)localObject1)) && (localb.gnI()))
        {
          localObject1 = ((Iterable)paramc.obg).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (a)((Iterator)localObject1).next();
            if (!kotlin.g.b.p.h(((a)localObject2).id, localb.MOJ)) {
              break;
            }
            ((a)localObject2).lxh.add(localb);
          }
        }
      }
    }
    label197:
    AppMethodBeat.o(232252);
  }
  
  public static void a(Map<String, String> paramMap1, Map<String, String> paramMap2, String paramString)
  {
    AppMethodBeat.i(232238);
    kotlin.g.b.p.k(paramMap1, "valuesMap");
    kotlin.g.b.p.k(paramMap2, "xmlMap");
    kotlin.g.b.p.k(paramString, "prefix");
    String[] arrayOfString = MOC;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = arrayOfString[i];
      String str2 = Util.safeFormatString(Util.nullAs((String)paramMap2.get(paramString + '.' + str1), ""), new Object[] { "" });
      kotlin.g.b.p.j(str2, "Util.safeFormatString(Ut…\"$prefix.${it}\"],\"\"), \"\")");
      paramMap1.put(str1, str2);
      i += 1;
    }
    AppMethodBeat.o(232238);
  }
  
  private static boolean beL(String paramString)
  {
    AppMethodBeat.i(232249);
    paramString = (b)MOx.get(paramString);
    if (paramString != null) {}
    for (paramString = paramString.MOH;; paramString = null)
    {
      boolean bool = Util.isEqual(paramString, "1");
      AppMethodBeat.o(232249);
      return bool;
    }
  }
  
  private static int beM(String paramString)
  {
    AppMethodBeat.i(232253);
    kotlin.g.b.p.k(paramString, "filePath");
    Object localObject = MMApplicationContext.getContext();
    kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
    localObject = new q(((Context)localObject).getCacheDir(), "TextStatus/temp");
    if (((q)localObject).ifE()) {
      u.deleteDir(((q)localObject).bOF());
    }
    u.bBD(((q)localObject).bOF());
    int j = u.gj(paramString, ((q)localObject).bOF());
    int i = -1;
    if (j == 0)
    {
      paramString = ((q)localObject).bOF();
      kotlin.g.b.p.j(paramString, "tempOutputFolder.absolutePath");
      i = beN(paramString);
    }
    for (;;)
    {
      u.deleteDir(((q)localObject).bOF());
      AppMethodBeat.o(232253);
      return i;
      Log.i("MicroMsg.TextStatus.StatusIconHelper", "getZipVersion unzip fail " + j + ' ' + paramString);
    }
  }
  
  private static int beN(String paramString)
  {
    AppMethodBeat.i(232254);
    kotlin.g.b.p.k(paramString, "folderPath");
    Object localObject1 = paramString + "/TextStateIconConfig.xml";
    if (u.agG((String)localObject1))
    {
      localObject1 = XmlParser.parseXml(u.bBS(new q((String)localObject1).bOF()), "textStateResource", "");
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder("getFolderResVersion fail xmlMap is null:").append(paramString).append(' ');
        localObject2 = u.dP(paramString, false);
        if (localObject2 != null)
        {
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            paramString.add(((com.tencent.mm.vfs.f)((Iterator)localObject2).next()).name);
          }
        }
        for (paramString = (List)paramString;; paramString = null)
        {
          Log.i("MicroMsg.TextStatus.StatusIconHelper", paramString);
          AppMethodBeat.o(232254);
          return -1;
        }
      }
      int i = Util.safeParseInt((String)((Map)localObject1).get(".textStateResource.version"));
      Log.i("MicroMsg.TextStatus.StatusIconHelper", "getFolderResVersion unzipVersion ".concat(String.valueOf(i)));
      AppMethodBeat.o(232254);
      return i;
    }
    localObject1 = new StringBuilder("getFolderResVersion fail not exist configPath:").append(paramString).append(' ');
    Object localObject2 = u.dP(paramString, false);
    if (localObject2 != null)
    {
      paramString = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramString.add(((com.tencent.mm.vfs.f)((Iterator)localObject2).next()).name);
      }
    }
    for (paramString = (List)paramString;; paramString = null)
    {
      Log.i("MicroMsg.TextStatus.StatusIconHelper", paramString);
      AppMethodBeat.o(232254);
      return -1;
    }
  }
  
  public static HashMap<String, b> gnF()
  {
    return MOx;
  }
  
  private static void gnG()
  {
    AppMethodBeat.i(232255);
    if (!c.gny())
    {
      AppMethodBeat.o(232255);
      return;
    }
    reset();
    Object localObject1 = new StringBuilder();
    Object localObject2 = f.MOw;
    localObject1 = f.gnD() + "/TextStateIconConfig.xml";
    if (u.agG((String)localObject1))
    {
      localObject1 = XmlParser.parseXml(u.bBS(new q((String)localObject1).bOF()), "textStateResource", "");
      if (localObject1 != null)
      {
        localObject1 = new c((Map)localObject1);
        a((c)localObject1);
        MOy = (c)localObject1;
      }
      localObject1 = new StringBuilder("initTextStatusResItem version:");
      localObject2 = MOy;
      if (localObject2 != null) {}
      for (int i = ((c)localObject2).version;; i = -1)
      {
        Log.i("MicroMsg.TextStatus.StatusIconHelper", i);
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1629L, 8L, 1L, false);
        AppMethodBeat.o(232255);
        return;
      }
    }
    Log.i("MicroMsg.TextStatus.StatusIconHelper", "initTextStatusResItem fail config path not exist ".concat(String.valueOf(localObject1)));
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1629L, 7L, 1L, false);
    AppMethodBeat.o(232255);
  }
  
  private static void gx(String paramString, int paramInt)
  {
    AppMethodBeat.i(232257);
    kotlin.g.b.p.k(paramString, "filePath");
    Object localObject = f.MOw;
    localObject = f.gnD();
    u.deleteDir((String)localObject);
    if (!u.agG((String)localObject)) {
      u.bBD((String)localObject);
    }
    int i = u.gj(paramString, (String)localObject);
    localObject = new StringBuilder("replaceTextStatusResource updateVersion currentVersion:");
    paramString = MOy;
    if (paramString != null) {}
    for (paramString = Integer.valueOf(paramString.version);; paramString = null)
    {
      Log.i("MicroMsg.TextStatus.StatusIconHelper", paramString + " updateVersion:" + paramInt + " unzipRet:" + i);
      if (i != 0) {
        break;
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1629L, 12L, 1L, false);
      gnG();
      AppMethodBeat.o(232257);
      return;
    }
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1629L, 13L, 1L, false);
    AppMethodBeat.o(232257);
  }
  
  private static void reset()
  {
    AppMethodBeat.i(232251);
    MOx.clear();
    MOz.clear();
    MOA.clear();
    MOB.clear();
    AppMethodBeat.o(232251);
  }
  
  public final ImageSpan a(View paramView, String paramString, a.c paramc, a.a parama, a.b paramb, int paramInt, com.tencent.mm.plugin.textstatus.g.e.a parama1)
  {
    AppMethodBeat.i(232259);
    kotlin.g.b.p.k(paramc, "iconType");
    kotlin.g.b.p.k(parama, "iconColor");
    paramView = a(paramString, paramc, parama);
    if (paramView != null)
    {
      paramView.setBounds(0, 0, paramInt, paramInt);
      paramView = (ImageSpan)new k(paramView, parama1, paramb);
      AppMethodBeat.o(232259);
      return paramView;
    }
    AppMethodBeat.o(232259);
    return null;
  }
  
  public final void a(ImageView paramImageView, String paramString, a.c paramc, a.a parama, com.tencent.mm.plugin.textstatus.g.e.a parama1)
  {
    AppMethodBeat.i(232263);
    kotlin.g.b.p.k(paramc, "iconType");
    kotlin.g.b.p.k(parama, "iconColor");
    paramString = a(paramString, a.c.MzH, a.a.Mzt);
    if (paramImageView != null)
    {
      paramImageView.setImageDrawable(paramString);
      AppMethodBeat.o(232263);
      return;
    }
    AppMethodBeat.o(232263);
  }
  
  public final void a(com.tencent.mm.plugin.textstatus.proto.p paramp)
  {
    AppMethodBeat.i(232262);
    kotlin.g.b.p.k(paramp, "rsp");
    AppMethodBeat.o(232262);
  }
  
  public final boolean beI(String paramString)
  {
    AppMethodBeat.i(232239);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.ba(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(232239);
      return false;
    }
    paramString = (b)MOx.get(paramString);
    if ((paramString != null) && (paramString.gnI() == true))
    {
      AppMethodBeat.o(232239);
      return true;
    }
    AppMethodBeat.o(232239);
    return false;
  }
  
  public final String beJ(String paramString)
  {
    AppMethodBeat.i(232245);
    paramString = (b)((Map)MOx).get(paramString);
    if (paramString != null)
    {
      String str = paramString.gnH();
      paramString = str;
      if (str != null) {}
    }
    else
    {
      paramString = "";
    }
    AppMethodBeat.o(232245);
    return paramString;
  }
  
  public final void beO(String paramString)
  {
    AppMethodBeat.i(232256);
    kotlin.g.b.p.k(paramString, "filePath");
    Log.i("MicroMsg.TextStatus.StatusIconHelper", "updateTextStatusResource " + paramString + ' ' + u.bBQ(paramString));
    int j = beM(paramString);
    c localc = MOy;
    if (localc != null) {}
    for (int i = localc.version; i < j; i = -1)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1629L, 10L, 1L, false);
      gx(paramString, j);
      AppMethodBeat.o(232256);
      return;
    }
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1629L, 11L, 1L, false);
    Log.i("MicroMsg.TextStatus.StatusIconHelper", "updateTextStatusResource no need to updateVersion currentVersion:-1 updateVersion:".concat(String.valueOf(j)));
    AppMethodBeat.o(232256);
  }
  
  public final String d(TextStatusTopicInfo paramTextStatusTopicInfo)
  {
    AppMethodBeat.i(232247);
    kotlin.g.b.p.k(paramTextStatusTopicInfo, "topicInfo");
    if (kotlin.g.b.p.h(paramTextStatusTopicInfo.iconId, "custom"))
    {
      paramTextStatusTopicInfo = paramTextStatusTopicInfo.title;
      AppMethodBeat.o(232247);
      return paramTextStatusTopicInfo;
    }
    paramTextStatusTopicInfo = beJ(paramTextStatusTopicInfo.iconId);
    AppMethodBeat.o(232247);
    return paramTextStatusTopicInfo;
  }
  
  public final ArrayList<com.tencent.mm.view.recyclerview.a> getDataList()
  {
    AppMethodBeat.i(232248);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new b(MMApplicationContext.getContext().getString(b.h.MyY)));
    Object localObject1 = MOy;
    if (localObject1 != null)
    {
      Iterator localIterator = ((c)localObject1).obg.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        Object localObject2 = new LinkedList();
        localObject1 = locala.lxh.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          b localb = (b)((Iterator)localObject1).next();
          if (localb.gnI()) {
            ((LinkedList)localObject2).add(localb);
          }
        }
        if (((LinkedList)localObject2).size() > 0)
        {
          localObject1 = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
          localObject1 = (String)locala.MOE.get(localObject1);
          int i;
          if (localObject1 != null) {
            if (((CharSequence)localObject1).length() > 0)
            {
              i = 1;
              label183:
              if (i != 1) {
                break label257;
              }
            }
          }
          for (;;)
          {
            localArrayList.add(new com.tencent.mm.plugin.textstatus.g.d.a((String)localObject1));
            localObject1 = ((LinkedList)localObject2).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (b)((Iterator)localObject1).next();
              localArrayList.add(new com.tencent.mm.plugin.textstatus.g.d.c(((b)localObject2).gnH(), ((b)localObject2).iconId));
            }
            break;
            i = 0;
            break label183;
            label257:
            localObject1 = (String)locala.MOE.get("en");
          }
        }
      }
    }
    AppMethodBeat.o(232248);
    return localArrayList;
  }
  
  public final long getResVersion()
  {
    c localc = MOy;
    if (localc != null) {}
    for (int i = localc.version;; i = -1) {
      return i;
    }
  }
  
  public final void gnx() {}
  
  public final void onCreate()
  {
    AppMethodBeat.i(232235);
    super.onCreate();
    long l = cm.bfE();
    Object localObject1 = f.MOw;
    int i = beN(f.gnD());
    localObject1 = u.aY("assets:///text_status_res/TextStatus.zip", 0, -1);
    Object localObject2 = MMApplicationContext.getContext();
    kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext()");
    localObject2 = new q(((Context)localObject2).getCacheDir(), "TextStatus");
    u.bBD(((q)localObject2).bOF());
    localObject2 = new q((q)localObject2, "asset.zip");
    if (((q)localObject2).ifE()) {
      ((q)localObject2).cFq();
    }
    u.H(((q)localObject2).bOF(), (byte[])localObject1);
    localObject1 = ((q)localObject2).bOF();
    kotlin.g.b.p.j(localObject1, "tempOutputZip.absolutePath");
    int j = beM((String)localObject1);
    if (j > i)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1629L, 14L, 1L, false);
      localObject1 = ((q)localObject2).bOF();
      kotlin.g.b.p.j(localObject1, "tempOutputZip.absolutePath");
      gx((String)localObject1, j);
    }
    for (;;)
    {
      ((q)localObject2).cFq();
      Log.i("MicroMsg.TextStatus.StatusIconHelper", "initTextStatusResource cost:" + (cm.bfE() - l));
      AppMethodBeat.o(232235);
      return;
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1629L, 15L, 1L, false);
      gnG();
      Log.i("MicroMsg.TextStatus.StatusIconHelper", "initTextStatusResource no need to updateVersion currentVersion:" + i + " assetVersion:" + j);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(232236);
    super.onDestroy();
    AppMethodBeat.o(232236);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$CategoryItem;", "", "prefix", "", "xmlMap", "", "(Ljava/lang/String;Ljava/util/Map;)V", "descMap", "", "getDescMap", "()Ljava/util/Map;", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "items", "", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$IconItem;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getDes", "plugin-textstatus_release"})
  public static final class a
  {
    final Map<String, String> MOE;
    String id;
    List<g.b> lxh;
    
    public a(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(238241);
      Object localObject = Util.safeFormatString(Util.nullAs((String)paramMap.get(paramString + ".$categoryId"), ""), new Object[] { "" });
      kotlin.g.b.p.j(localObject, "Util.safeFormatString(Ut…x.\\$categoryId\"], \"\"),\"\")");
      this.id = ((String)localObject);
      this.lxh = ((List)new LinkedList());
      this.MOE = ((Map)new HashMap());
      String str = paramString + ".iconArray.iconItem";
      localObject = str;
      int i = 1;
      while (paramMap.get(localObject) != null)
      {
        g.b localb = new g.b((String)localObject, paramMap);
        localObject = str + i;
        i += 1;
        this.lxh.add(localb);
        g localg = g.MOD;
        ((Map)g.gnF()).put(localb.iconId, localb);
      }
      localObject = g.MOD;
      g.a(this.MOE, paramMap, paramString + ".description");
      AppMethodBeat.o(238241);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$IconItem;", "", "prefix", "", "xmlMap", "", "(Ljava/lang/String;Ljava/util/Map;)V", "descMap", "", "getDescMap", "()Ljava/util/Map;", "setDescMap", "(Ljava/util/Map;)V", "effectTime", "", "getEffectTime", "()J", "setEffectTime", "(J)V", "expiredTime", "getExpiredTime", "setExpiredTime", "iconId", "getIconId", "()Ljava/lang/String;", "setIconId", "(Ljava/lang/String;)V", "residentAfterPublish", "", "getResidentAfterPublish", "()I", "setResidentAfterPublish", "(I)V", "residentCategoryId", "getResidentCategoryId", "setResidentCategoryId", "sameFriendsTipMap", "getSameFriendsTipMap", "setSameFriendsTipMap", "styleArray", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StyleArray;", "getStyleArray", "()Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StyleArray;", "setStyleArray", "(Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StyleArray;)V", "useOriginalImage", "getUseOriginalImage", "setUseOriginalImage", "getDes", "getSameFriendsTip", "getStyleIconId", "isIconDrawableValid", "", "isIconValid", "plugin-textstatus_release"})
  public static final class b
  {
    private Map<String, String> MOE;
    long MOF;
    private long MOG;
    String MOH;
    int MOI;
    String MOJ;
    private Map<String, String> MOK;
    g.d MOL;
    String iconId;
    
    public b(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(237541);
      Object localObject = Util.safeFormatString(Util.nullAs((String)paramMap.get(paramString + ".$iconId"), ""), new Object[] { "" });
      kotlin.g.b.p.j(localObject, "Util.safeFormatString(Ut…efix.\\$iconId\"], \"\"), \"\")");
      this.iconId = ((String)localObject);
      this.MOF = Util.safeParseLong((String)paramMap.get(paramString + ".effectTime"));
      this.MOG = Util.safeParseLong((String)paramMap.get(paramString + ".expireTime"));
      localObject = Util.safeFormatString(Util.nullAs((String)paramMap.get(paramString + ".useOriginalImage"), ""), new Object[] { "" });
      kotlin.g.b.p.j(localObject, "Util.safeFormatString(Ut…OriginalImage\"], \"\"), \"\")");
      this.MOH = ((String)localObject);
      this.MOI = Util.safeParseInt(Util.nullAs((String)paramMap.get(paramString + ".residentAfterPublish"), ""));
      localObject = Util.safeFormatString(Util.nullAs((String)paramMap.get(paramString + ".residentCategoryId"), ""), new Object[] { "" });
      kotlin.g.b.p.j(localObject, "Util.safeFormatString(Ut…entCategoryId\"], \"\"), \"\")");
      this.MOJ = ((String)localObject);
      this.MOE = ((Map)new HashMap());
      this.MOK = ((Map)new HashMap());
      this.MOL = new g.d(paramString + ".styleArray", paramMap);
      localObject = g.MOD;
      g.a(this.MOE, paramMap, paramString + ".description");
      localObject = g.MOD;
      g.a(this.MOK, paramMap, paramString + ".sameFriendsTip");
      AppMethodBeat.o(237541);
    }
    
    public final String gnH()
    {
      AppMethodBeat.i(237538);
      int i;
      if (kotlin.g.b.p.h(this.iconId, "custom"))
      {
        localObject = h.aHG();
        kotlin.g.b.p.j(localObject, "MMKernel.storage()");
        localObject = ((com.tencent.mm.kernel.f)localObject).aHp().a(ar.a.VDM, "");
        CharSequence localCharSequence = (CharSequence)localObject;
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(237538);
          return localObject;
        }
      }
      Object localObject = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
      localObject = (String)this.MOE.get(localObject);
      if (localObject != null)
      {
        if (((CharSequence)localObject).length() > 0) {}
        for (i = 1; i == 1; i = 0)
        {
          AppMethodBeat.o(237538);
          return localObject;
        }
      }
      localObject = (String)this.MOE.get("en");
      AppMethodBeat.o(237538);
      return localObject;
    }
    
    public final boolean gnI()
    {
      AppMethodBeat.i(237539);
      long l2 = i.be(this.MOF, 0L);
      long l1;
      long l3;
      if ((this.MOG <= 0L) || (this.MOG <= this.MOF))
      {
        l1 = 9223372036854775807L;
        l3 = cm.bfF();
        if (l2 <= l3) {
          break label67;
        }
      }
      label67:
      while (l1 < l3)
      {
        AppMethodBeat.o(237539);
        return false;
        l1 = this.MOG;
        break;
      }
      AppMethodBeat.o(237539);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StatusResItem;", "", "xmlMap", "", "", "(Ljava/util/Map;)V", "categories", "", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$CategoryItem;", "getCategories", "()Ljava/util/List;", "setCategories", "(Ljava/util/List;)V", "hideItems", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$IconItem;", "getHideItems", "setHideItems", "version", "", "getVersion", "()I", "setVersion", "(I)V", "plugin-textstatus_release"})
  public static final class c
  {
    List<g.b> MOM;
    List<g.a> obg;
    int version;
    
    public c(Map<String, String> paramMap)
    {
      AppMethodBeat.i(237176);
      this.version = Util.safeParseInt((String)paramMap.get(".textStateResource.version"));
      this.obg = ((List)new LinkedList());
      Object localObject1 = ".textStateResource.categoryArray.categoryItem";
      int i = 1;
      Object localObject2;
      while (paramMap.get(localObject1) != null)
      {
        localObject2 = new g.a((String)localObject1, paramMap);
        localObject1 = ".textStateResource.categoryArray.categoryItem" + i;
        i += 1;
        this.obg.add(localObject2);
      }
      this.MOM = ((List)new LinkedList());
      localObject1 = ".textStateResource.otherIcons.iconArray.iconItem";
      i = j;
      while (paramMap.get(localObject1) != null)
      {
        localObject2 = new g.b((String)localObject1, paramMap);
        localObject1 = ".textStateResource.otherIcons.iconArray.iconItem" + i;
        i += 1;
        this.MOM.add(localObject2);
        g localg = g.MOD;
        ((Map)g.gnF()).put(((g.b)localObject2).iconId, localObject2);
      }
      paramMap = new StringBuilder("InitStatusResItem categories:").append(this.obg.size()).append(" iconItemMap:");
      localObject1 = g.MOD;
      Log.i("MicroMsg.TextStatus.StatusIconHelper", g.gnF().size() + " hideItems:" + this.MOM.size());
      AppMethodBeat.o(237176);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.k.g
 * JD-Core Version:    0.7.0.1
 */