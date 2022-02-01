package com.tencent.mm.smiley;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.m.a.b;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.a.p;
import kotlin.g.b.s;

public class o
{
  private static o acyo = null;
  private final String Wqe;
  private String[] acyp;
  private String[] acyq;
  public final List<SmileyPanelConfigInfo> acyr;
  public SparseArray<SmileyPanelConfigInfo> acys;
  private String country;
  private String hCS;
  private final String mga;
  private final String versionName;
  
  private o(Context paramContext)
  {
    AppMethodBeat.i(104920);
    StringBuilder localStringBuilder = new StringBuilder();
    c localc = c.moq;
    this.mga = (c.aWC() + "panel/");
    this.Wqe = "assets:///panel/";
    this.versionName = "config.conf";
    this.hCS = "";
    this.acyr = Collections.synchronizedList(new ArrayList());
    this.acys = new SparseArray();
    this.acyp = paramContext.getResources().getStringArray(a.b.merge_smiley_code_smiley);
    this.acyq = paramContext.getResources().getStringArray(a.b.merge_smiley_unicode_emoji);
    this.acyr.clear();
    this.acys.clear();
    iVi();
    this.country = LocaleUtil.getApplicationLanguage();
    if (!MMApplicationContext.isMainProcess()) {
      iVj();
    }
    AppMethodBeat.o(104920);
  }
  
  public static Drawable buC(String paramString)
  {
    AppMethodBeat.i(177037);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177037);
      return null;
    }
    SmileyInfo localSmileyInfo = QQSmileyManager.iVq().buF(paramString);
    if (localSmileyInfo != null)
    {
      paramString = QQSmileyManager.iVq();
      s.u(localSmileyInfo, "smileyInfo");
      int i = localSmileyInfo.field_position;
      if (i >= 0)
      {
        paramString = paramString.ayt(i);
        AppMethodBeat.o(177037);
        return paramString;
      }
      paramString = paramString.buE(localSmileyInfo.field_fileName);
      AppMethodBeat.o(177037);
      return paramString;
    }
    EmojiHelper.iUM();
    EmojiHelper.iUM();
    paramString = EmojiHelper.b(EmojiHelper.buw(paramString));
    AppMethodBeat.o(177037);
    return paramString;
  }
  
  private void iVi()
  {
    int k = 0;
    AppMethodBeat.i(104921);
    if ((this.acyp != null) && (this.acyq != null))
    {
      int m = this.acyp.length;
      int j = 0;
      int i = 0;
      SmileyPanelConfigInfo localSmileyPanelConfigInfo;
      while (j < m)
      {
        localSmileyPanelConfigInfo = new SmileyPanelConfigInfo(i, this.acyp[j]);
        this.acyr.add(localSmileyPanelConfigInfo);
        this.acys.put(i, localSmileyPanelConfigInfo);
        j += 1;
        i += 1;
      }
      m = this.acyq.length;
      j = k;
      while (j < m)
      {
        localSmileyPanelConfigInfo = new SmileyPanelConfigInfo(i, this.acyq[j]);
        this.acyr.add(localSmileyPanelConfigInfo);
        this.acys.put(i, localSmileyPanelConfigInfo);
        j += 1;
        i += 1;
      }
    }
    AppMethodBeat.o(104921);
  }
  
  public static o iVl()
  {
    AppMethodBeat.i(104925);
    if (acyo == null) {}
    try
    {
      acyo = new o(MMApplicationContext.getContext());
      o localo = acyo;
      AppMethodBeat.o(104925);
      return localo;
    }
    finally
    {
      AppMethodBeat.o(104925);
    }
  }
  
  public final String ays(int paramInt)
  {
    AppMethodBeat.i(104928);
    List localList = this.acyr;
    if (paramInt >= 0) {}
    try
    {
      if (paramInt >= this.acyr.size())
      {
        Log.w("MicroMsg.MergerSmileyManager", "get text key, error index");
        return "";
      }
      Object localObject1 = (SmileyPanelConfigInfo)this.acyr.get(paramInt);
      if (localObject1 != null)
      {
        localObject1 = ((SmileyPanelConfigInfo)localObject1).field_key;
        return localObject1;
      }
      return "";
    }
    finally
    {
      AppMethodBeat.o(104928);
    }
  }
  
  public final String buD(String paramString)
  {
    AppMethodBeat.i(177038);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177038);
      return "";
    }
    SmileyInfo localSmileyInfo = QQSmileyManager.iVq().buF(paramString);
    if (localSmileyInfo != null)
    {
      if ((this.country.equals("zh_CN")) && (!Util.isNullOrNil(localSmileyInfo.field_cnValue)))
      {
        paramString = localSmileyInfo.field_cnValue;
        AppMethodBeat.o(177038);
        return paramString;
      }
      if (((this.country.equals("zh_TW")) || (this.country.equals("zh_HK"))) && (!Util.isNullOrNil(localSmileyInfo.field_twValue)))
      {
        paramString = localSmileyInfo.field_twValue;
        AppMethodBeat.o(177038);
        return paramString;
      }
      paramString = localSmileyInfo.field_enValue;
      AppMethodBeat.o(177038);
      return paramString;
    }
    AppMethodBeat.o(177038);
    return paramString;
  }
  
  public final boolean containsKey(String paramString)
  {
    AppMethodBeat.i(177036);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(177036);
      return false;
    }
    synchronized (this.acyr)
    {
      Iterator localIterator = this.acyr.iterator();
      while (localIterator.hasNext()) {
        if (Util.isEqual(((SmileyPanelConfigInfo)localIterator.next()).field_key, paramString))
        {
          AppMethodBeat.o(177036);
          return true;
        }
      }
      AppMethodBeat.o(177036);
      return false;
    }
  }
  
  public final boolean iVj()
  {
    AppMethodBeat.i(104922);
    Log.i("MicroMsg.MergerSmileyManager", "checkNewSmiley ");
    ArrayList localArrayList = ((PluginEmoji)h.az(PluginEmoji.class)).getProvider().dzw();
    if ((localArrayList == null) || (localArrayList.isEmpty()))
    {
      iVk();
      AppMethodBeat.o(104922);
      return true;
    }
    iVk();
    AppMethodBeat.o(104922);
    return false;
  }
  
  public final int iVk()
  {
    AppMethodBeat.i(104923);
    Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo");
    this.acyr.clear();
    this.hCS = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getProvider().dzz();
    new ArrayList();
    Object localObject2 = new ArrayList();
    int i = com.tencent.mm.emoji.f.d.Ex(this.mga + "config.conf");
    int j = com.tencent.mm.emoji.f.d.Ex("assets:///panel/config.conf");
    Object localObject4 = this.mga + this.hCS;
    Object localObject3 = "assets:///panel/" + this.hCS;
    Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: local:%s, asset:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    Object localObject1 = localObject2;
    if (i > 0)
    {
      localObject1 = localObject2;
      if (i >= j)
      {
        localObject1 = localObject2;
        if (y.ZC((String)localObject4))
        {
          localObject1 = com.tencent.mm.emoji.f.d.e(new u((String)localObject4));
          Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: localSize %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
        }
      }
    }
    if (((ArrayList)localObject1).size() <= 0)
    {
      localObject1 = com.tencent.mm.emoji.f.d.e(new u((String)localObject3));
      if (((ArrayList)localObject1).size() < 50) {
        Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: from asset xml %s", new Object[] { Integer.valueOf(((ArrayList)localObject1).size()) });
      }
    }
    label556:
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo: %s", new Object[] { y.bEn("assets:///panel/" + this.hCS) });
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
        {
          localObject2 = QQSmileyManager.iVq().acyG.keySet();
          s.s(localObject2, "newEmojiMap.keys");
          localObject3 = p.p((Iterable)localObject2);
          int k = ((ArrayList)localObject1).size();
          j = 0;
          i = 0;
          if (j < k)
          {
            localObject4 = (SmileyPanelConfigInfo)((ArrayList)localObject1).get(j);
            localObject2 = ((SmileyPanelConfigInfo)localObject4).field_key;
            if (!((String)localObject2).matches("^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$")) {
              break label556;
            }
            localObject2 = new String(Base64.decode((String)localObject2, 0));
            ((SmileyPanelConfigInfo)localObject4).field_key = ((String)localObject2);
            if ((((String)localObject2).startsWith("[")) && (!((List)localObject3).contains(localObject2)))
            {
              Log.i("MicroMsg.MergerSmileyManager", "no smiley info. key:%s", new Object[] { localObject2 });
              j += 1;
              continue;
            }
          }
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MergerSmileyManager", localException, "", new Object[0]);
        continue;
        this.acyr.add(localObject4);
        this.acys.put(i, localObject4);
        i += 1;
        continue;
        i = 0;
        AppMethodBeat.o(104923);
        return i;
      }
      iVi();
      Log.i("MicroMsg.MergerSmileyManager", "smiley panel list is null.");
      i = -1;
      continue;
    }
  }
  
  public final List<SmileyPanelConfigInfo> iVm()
  {
    AppMethodBeat.i(177035);
    synchronized (this.acyr)
    {
      ArrayList localArrayList = new ArrayList(this.acyr);
      AppMethodBeat.o(177035);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.o
 * JD-Core Version:    0.7.0.1
 */