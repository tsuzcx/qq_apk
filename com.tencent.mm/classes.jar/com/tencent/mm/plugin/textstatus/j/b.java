package com.tencent.mm.plugin.textstatus.j;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.bp.a;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.textstatus.a.a.a;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.f.e.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper;", "", "()V", "FILLED_CACHE", "", "", "Landroid/graphics/Bitmap;", "OUTLINED_CACHE", "TAG", "checkResUpdateCacheFileEventIListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "iconItemMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$IconItem;", "Lkotlin/collections/HashMap;", "lock", "statusResItem", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StatusResItem;", "convertResToDatList", "", "getDataList", "getDescriptionById", "iconId", "getIcon", "id", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "getIconDrawable", "Landroid/graphics/drawable/Drawable;", "iconColor", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;", "getName", "handleUpdate", "", "path", "ifUseOriginalImage", "reset", "CategoryItem", "IconItem", "StatusResItem", "plugin-textstatus_release"})
public final class b
{
  private static HashMap<String, b> GfV;
  private static c GfW;
  private static final Map<String, Bitmap> GfX;
  private static final Map<String, Bitmap> GfY;
  public static final b GfZ;
  private static ArrayList<com.tencent.mm.view.recyclerview.a> kgc;
  private static final Object lock;
  private static final IListener<bp> qxe;
  
  static
  {
    Object localObject2 = null;
    AppMethodBeat.i(216693);
    GfZ = new b();
    GfV = new HashMap();
    kgc = new ArrayList();
    GfX = (Map)new LinkedHashMap();
    GfY = (Map)new LinkedHashMap();
    lock = new Object();
    qxe = (IListener)new d();
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    Object localObject3 = a.GfU;
    localObject1 = a.fwG() + "/TextStateIconConfig.xml";
    if (!new o((String)localObject1).exists())
    {
      localObject3 = a.GfU;
      s.deleteDir(a.fwG());
      localObject3 = a.GfU;
      localObject3 = new o(a.fwG());
      Log.i("MicroMsg.TxtStatus.StatusIconHelper", "unzip file from assets, result:".concat(String.valueOf(n.a(new ZipInputStream(MMApplicationContext.getContext().getAssets().open("TextState.zip")), ((o)localObject3).getAbsolutePath()))));
    }
    if (new o((String)localObject1).exists())
    {
      localObject1 = s.boY(new o((String)localObject1).getAbsolutePath());
      localObject3 = XmlParser.parseXml((String)localObject1, "textStateResource", "");
      if (localObject3 == null)
      {
        Log.e("MicroMsg.TxtStatus.StatusIconHelper", "xmlMap is null, xml:" + Util.secPrint((String)localObject1));
        localObject1 = a.GfU;
        s.deleteDir(a.fwG());
        com.tencent.mm.plugin.textstatus.a.p.UrK = false;
        localObject1 = a.GfU;
        localObject1 = a.getKV();
        if (localObject1 != null) {
          ((MultiProcessMMKV)localObject1).putString("key_icon_res_version", "");
        }
        localObject1 = a.GfU;
        localObject1 = a.getKV();
        if (localObject1 != null) {
          ((MultiProcessMMKV)localObject1).putString("key_icon_res_md5", "");
        }
        h.RTc.aX((Runnable)1.Gga);
      }
    }
    for (;;)
    {
      qxe.alive();
      com.tencent.mm.pluginsdk.j.a.a.b.gnC();
      com.tencent.mm.pluginsdk.j.a.a.b.ahP(86);
      Log.i("MicroMsg.TxtStatus.StatusIconHelper", "init time " + (System.currentTimeMillis() - l));
      AppMethodBeat.o(216693);
      return;
      localObject1 = new c((Map)localObject3);
      GfW = (c)localObject1;
      a((c)localObject1, kgc);
      localObject1 = a.GfU;
      localObject3 = a.getKV();
      if (localObject3 != null)
      {
        localObject1 = GfW;
        if (localObject1 == null) {
          break label503;
        }
      }
      label503:
      for (localObject1 = Integer.valueOf(((c)localObject1).version);; localObject1 = null)
      {
        ((MultiProcessMMKV)localObject3).putString("key_icon_res_version", String.valueOf(localObject1));
        localObject3 = new StringBuilder("load version:");
        c localc = GfW;
        localObject1 = localObject2;
        if (localc != null) {
          localObject1 = Integer.valueOf(localc.version);
        }
        Log.i("MicroMsg.TxtStatus.StatusIconHelper", localObject1);
        break;
      }
      Log.e("MicroMsg.TxtStatus.StatusIconHelper", "configPath no exist");
    }
  }
  
  public static Drawable a(String paramString, a.c paramc, a.a parama)
  {
    AppMethodBeat.i(216688);
    p.h(paramc, "iconType");
    p.h(parama, "iconColor");
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(216688);
      return null;
    }
    Bitmap localBitmap;
    switch (c.uqL[paramc.ordinal()])
    {
    default: 
      localBitmap = (Bitmap)GfY.get(paramString);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        Log.i("MicroMsg.TxtStatus.StatusIconHelper", "cache icon ".concat(String.valueOf(paramString)));
        localObject = localBitmap;
        label134:
        if (localObject == null) {
          break label513;
        }
        localObject = (Drawable)new BitmapDrawable((Bitmap)localObject);
        paramString = (b)GfV.get(paramString);
        if (paramString == null) {
          break label389;
        }
      }
      break;
    }
    label386:
    label389:
    for (paramString = paramString.Gge;; paramString = null)
    {
      if (!Util.isEqual(paramString, "1")) {
        break label394;
      }
      AppMethodBeat.o(216688);
      return localObject;
      localBitmap = (Bitmap)GfX.get(paramString);
      break;
      localObject = a.GfU;
      o localo = new o(String.valueOf(a.fwG()));
      localObject = localBitmap;
      if (TextUtils.isEmpty((CharSequence)paramString)) {
        break label134;
      }
      localObject = localBitmap;
      if (!localo.exists()) {
        break label134;
      }
      switch (c.vke[paramc.ordinal()])
      {
      }
      for (localObject = "_filled";; localObject = "_outlined")
      {
        localObject = BitmapUtil.decodeFile(new o(localo, paramString + (String)localObject + ".png").getAbsolutePath(), null);
        if (localObject == null) {
          break label386;
        }
        ((Bitmap)localObject).setDensity(320);
        if (paramc != a.c.FXo) {
          break label371;
        }
        GfX.put(paramString, localObject);
        break;
      }
      label371:
      GfY.put(paramString, localObject);
      break label134;
      break label134;
    }
    label394:
    switch (c.haE[paramc.ordinal()])
    {
    default: 
      paramString = ar.e((Drawable)localObject, MMApplicationContext.getResources().getColor(2131099844));
      p.g(paramString, "WeUIColorHelper.getColor….getColor(R.color.White))");
      AppMethodBeat.o(216688);
      return paramString;
    }
    switch (c.$EnumSwitchMapping$0[parama.ordinal()])
    {
    }
    for (i = MMApplicationContext.getResources().getColor(2131099841);; i = -1)
    {
      paramString = ar.e((Drawable)localObject, i);
      p.g(paramString, "WeUIColorHelper.getColorDrawable(drawable, color)");
      AppMethodBeat.o(216688);
      return paramString;
    }
    label513:
    AppMethodBeat.o(216688);
    return null;
  }
  
  private static void a(c paramc, ArrayList<com.tencent.mm.view.recyclerview.a> paramArrayList)
  {
    AppMethodBeat.i(216692);
    paramArrayList.add(new com.tencent.mm.plugin.textstatus.f.e.b(MMApplicationContext.getContext().getString(2131766729)));
    Iterator localIterator = paramc.lgE.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (a)localIterator.next();
      paramc = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
      if (p.j(paramc, "zh_CN")) {
        paramc = (String)((a)localObject).Ggb.get(paramc);
      }
      for (;;)
      {
        paramArrayList.add(new com.tencent.mm.plugin.textstatus.f.e.a(paramc));
        paramc = ((a)localObject).iHf.iterator();
        while (paramc.hasNext())
        {
          localObject = (b)paramc.next();
          paramArrayList.add(new c(((b)localObject).fwJ(), ((b)localObject).Ggc));
        }
        break;
        if (p.j(paramc, "zh_HK")) {
          paramc = (String)((a)localObject).Ggb.get(paramc);
        } else if (p.j(paramc, "zh_TW")) {
          paramc = (String)((a)localObject).Ggb.get(paramc);
        } else {
          paramc = (String)((a)localObject).Ggb.get("en");
        }
      }
    }
    AppMethodBeat.o(216692);
  }
  
  public static String aTp(String paramString)
  {
    AppMethodBeat.i(216691);
    p.h(paramString, "iconId");
    Iterator localIterator = kgc.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.view.recyclerview.a locala = (com.tencent.mm.view.recyclerview.a)localIterator.next();
      if (((locala instanceof c)) && (p.j(((c)locala).id, paramString)))
      {
        paramString = String.valueOf(((c)locala).name);
        AppMethodBeat.o(216691);
        return paramString;
      }
    }
    AppMethodBeat.o(216691);
    return "";
  }
  
  public static ArrayList<com.tencent.mm.view.recyclerview.a> getDataList()
  {
    return kgc;
  }
  
  public static String getName(String paramString)
  {
    AppMethodBeat.i(216690);
    paramString = (b)((Map)GfV).get(paramString);
    if (paramString != null)
    {
      paramString = paramString.fwJ();
      AppMethodBeat.o(216690);
      return paramString;
    }
    AppMethodBeat.o(216690);
    return null;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$CategoryItem;", "", "prefix", "", "xmlMap", "", "(Ljava/lang/String;Ljava/util/Map;)V", "descMap", "", "getDescMap", "()Ljava/util/Map;", "id", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "items", "", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$IconItem;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getDes", "plugin-textstatus_release"})
  public static final class a
  {
    final Map<String, String> Ggb;
    List<b.b> iHf;
    private String id;
    
    public a(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(216681);
      Object localObject = Util.safeFormatString(Util.nullAs((String)paramMap.get(paramString + ".$categoryId"), ""), new Object[] { "" });
      p.g(localObject, "Util.safeFormatString(Ut…x.\\$categoryId\"], \"\"),\"\")");
      this.id = ((String)localObject);
      this.iHf = ((List)new LinkedList());
      this.Ggb = ((Map)new HashMap());
      String str = paramString + ".iconArray.iconItem";
      localObject = str;
      int i = 1;
      while (paramMap.get(localObject) != null)
      {
        b.b localb = new b.b((String)localObject, paramMap);
        localObject = str + i;
        i += 1;
        this.iHf.add(localb);
        b localb1 = b.GfZ;
        ((Map)b.fwH()).put(localb.Ggc, localb);
      }
      localObject = this.Ggb;
      str = Util.safeFormatString(Util.nullAs((String)paramMap.get(paramString + ".description.zh_CN"), ""), new Object[] { "" });
      p.g(str, "Util.safeFormatString(Ut…cription.zh_CN\"],\"\"), \"\")");
      ((Map)localObject).put("zh_CN", str);
      localObject = this.Ggb;
      str = Util.safeFormatString(Util.nullAs((String)paramMap.get(paramString + ".description.en"), ""), new Object[] { "" });
      p.g(str, "Util.safeFormatString(Ut…description.en\"],\"\"), \"\")");
      ((Map)localObject).put("en", str);
      localObject = this.Ggb;
      str = Util.safeFormatString(Util.nullAs((String)paramMap.get(paramString + ".description.zh_HK"), ""), new Object[] { "" });
      p.g(str, "Util.safeFormatString(Ut…cription.zh_HK\"],\"\"), \"\")");
      ((Map)localObject).put("zh_HK", str);
      localObject = this.Ggb;
      paramString = Util.safeFormatString(Util.nullAs((String)paramMap.get(paramString + ".description.zh_TW"), ""), new Object[] { "" });
      p.g(paramString, "Util.safeFormatString(Ut…cription.zh_TW\"],\"\"), \"\")");
      ((Map)localObject).put("zh_TW", paramString);
      AppMethodBeat.o(216681);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$IconItem;", "", "prefix", "", "xmlMap", "", "(Ljava/lang/String;Ljava/util/Map;)V", "descMap", "", "getDescMap", "()Ljava/util/Map;", "setDescMap", "(Ljava/util/Map;)V", "effectTime", "", "getEffectTime", "()J", "setEffectTime", "(J)V", "iconId", "getIconId", "()Ljava/lang/String;", "setIconId", "(Ljava/lang/String;)V", "useOriginalImage", "getUseOriginalImage", "setUseOriginalImage", "getDes", "plugin-textstatus_release"})
  public static final class b
  {
    private Map<String, String> Ggb;
    String Ggc;
    private long Ggd;
    String Gge;
    
    public b(String paramString, Map<String, String> paramMap)
    {
      AppMethodBeat.i(216683);
      Object localObject = Util.safeFormatString(Util.nullAs((String)paramMap.get(paramString + ".$iconId"), ""), new Object[] { "" });
      p.g(localObject, "Util.safeFormatString(Ut…refix.\\$iconId\"],\"\"), \"\")");
      this.Ggc = ((String)localObject);
      this.Ggd = Util.safeParseLong((String)paramMap.get(paramString + ".effectTime"));
      localObject = Util.safeFormatString(Util.nullAs((String)paramMap.get(paramString + ".useOriginalImage"), ""), new Object[] { "" });
      p.g(localObject, "Util.safeFormatString(Ut…OriginalImage\"], \"\"), \"\")");
      this.Gge = ((String)localObject);
      this.Ggb = ((Map)new HashMap());
      localObject = this.Ggb;
      String str = Util.safeFormatString(Util.nullAs((String)paramMap.get(paramString + ".description.zh_CN"), ""), new Object[] { "" });
      p.g(str, "Util.safeFormatString(Ut…cription.zh_CN\"],\"\"), \"\")");
      ((Map)localObject).put("zh_CN", str);
      localObject = this.Ggb;
      str = Util.safeFormatString(Util.nullAs((String)paramMap.get(paramString + ".description.en"), ""), new Object[] { "" });
      p.g(str, "Util.safeFormatString(Ut…description.en\"],\"\"), \"\")");
      ((Map)localObject).put("en", str);
      localObject = this.Ggb;
      str = Util.safeFormatString(Util.nullAs((String)paramMap.get(paramString + ".description.zh_HK"), ""), new Object[] { "" });
      p.g(str, "Util.safeFormatString(Ut…cription.zh_HK\"],\"\"), \"\")");
      ((Map)localObject).put("zh_HK", str);
      localObject = this.Ggb;
      paramString = Util.safeFormatString(Util.nullAs((String)paramMap.get(paramString + ".description.zh_TW"), ""), new Object[] { "" });
      p.g(paramString, "Util.safeFormatString(Ut…cription.zh_TW\"],\"\"), \"\")");
      ((Map)localObject).put("zh_TW", paramString);
      AppMethodBeat.o(216683);
    }
    
    public final String fwJ()
    {
      AppMethodBeat.i(216682);
      String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
      if (p.j(str, "zh_CN"))
      {
        str = (String)this.Ggb.get(str);
        AppMethodBeat.o(216682);
        return str;
      }
      if (p.j(str, "zh_HK"))
      {
        str = (String)this.Ggb.get(str);
        AppMethodBeat.o(216682);
        return str;
      }
      if (p.j(str, "zh_TW"))
      {
        str = (String)this.Ggb.get(str);
        AppMethodBeat.o(216682);
        return str;
      }
      str = (String)this.Ggb.get("en");
      AppMethodBeat.o(216682);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$StatusResItem;", "", "xmlMap", "", "", "(Ljava/util/Map;)V", "categories", "", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$CategoryItem;", "getCategories", "()Ljava/util/List;", "setCategories", "(Ljava/util/List;)V", "hideItems", "Lcom/tencent/mm/plugin/textstatus/util/StatusIconHelper$IconItem;", "getHideItems", "setHideItems", "version", "", "getVersion", "()I", "setVersion", "(I)V", "plugin-textstatus_release"})
  public static final class c
  {
    private List<b.b> Ggf;
    List<b.a> lgE;
    int version;
    
    public c(Map<String, String> paramMap)
    {
      AppMethodBeat.i(216684);
      this.version = Util.safeParseInt((String)paramMap.get(".textStateResource.version"));
      this.lgE = ((List)new LinkedList());
      String str = ".textStateResource.categoryArray.categoryItem";
      int i = 1;
      Object localObject;
      while (paramMap.get(str) != null)
      {
        localObject = new b.a(str, paramMap);
        str = ".textStateResource.categoryArray.categoryItem" + i;
        i += 1;
        this.lgE.add(localObject);
      }
      this.Ggf = ((List)new LinkedList());
      str = ".textStateResource.otherIcons.iconArray.iconItem";
      i = j;
      while (paramMap.get(str) != null)
      {
        localObject = new b.b(str, paramMap);
        str = ".textStateResource.otherIcons.iconArray.iconItem" + i;
        i += 1;
        this.Ggf.add(localObject);
        b localb = b.GfZ;
        ((Map)b.fwH()).put(((b.b)localObject).Ggc, localObject);
      }
      AppMethodBeat.o(216684);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/util/StatusIconHelper$checkResUpdateCacheFileEventIListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "callback", "", "event", "plugin-textstatus_release"})
  public static final class d
    extends IListener<bp>
  {
    private static boolean a(bp parambp)
    {
      AppMethodBeat.i(216686);
      p.h(parambp, "event");
      Log.i("MicroMsg.TxtStatus.StatusIconHelper", "CheckResUpdateCacheFileEvent callback");
      if (parambp.dEN.dEO == 86) {}
      for (Object localObject1 = b.GfZ;; localObject1 = "") {
        synchronized (b.fwI())
        {
          Log.i("MicroMsg.TxtStatus.StatusIconHelper", "CheckResUpdateCacheFileEvent resTyep:%s subType:%s md5:%s fileVersion:%s", new Object[] { Integer.valueOf(parambp.dEN.dEO), Integer.valueOf(parambp.dEN.subType), parambp.dEN.dER, Integer.valueOf(parambp.dEN.dEP) });
          if (parambp.dEN.subType == 1)
          {
            Log.i("MicroMsg.TxtStatus.StatusIconHelper", "CheckResUpdateCacheFileEvent subType == RES_SUB_TYPE_ICON");
            localObject1 = a.GfU;
            localObject1 = a.getKV();
            if (localObject1 == null) {
              continue;
            }
            String str = ((MultiProcessMMKV)localObject1).getString("key_icon_res_md5", "");
            localObject1 = str;
            if (str == null) {
              continue;
            }
            p.g(localObject1, "PathProvider.getKV()?.ge…Y_ICON_RES_MD5, \"\") ?: \"\"");
            str = s.bhK(parambp.dEN.filePath);
            Log.i("MicroMsg.TxtStatus.StatusIconHelper", "CheckResUpdateCacheFileEvent lastMd5:" + (String)localObject1 + " curMd5:" + str);
            localObject1 = b.GfZ;
            parambp = parambp.dEN.filePath;
            p.g(parambp, "event.data.filePath");
            if (!b.bxd(parambp)) {
              Log.e("MicroMsg.TxtStatus.StatusIconHelper", "update fail");
            }
          }
          parambp = x.SXb;
          AppMethodBeat.o(216686);
          return false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.b
 * JD-Core Version:    0.7.0.1
 */