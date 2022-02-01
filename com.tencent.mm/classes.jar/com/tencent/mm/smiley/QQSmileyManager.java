package com.tencent.mm.smiley;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.oc;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelemoji.a;
import com.tencent.mm.plugin.m.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/QQSmileyManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "assetDir", "", "bitmapCache", "Lcom/tencent/mm/algorithm/LRUMap;", "Landroid/graphics/Bitmap;", "configName", "itemRepo", "Lcom/tencent/mm/smiley/QQEmojiRepo;", "localDir", "newEmojiMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/storage/emotion/SmileyInfo;", "Lkotlin/collections/HashMap;", "newSmileyKeyList", "", "getNewSmileyKeyList", "()Ljava/util/List;", "newSmileys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "qqEmojiMap", "texts", "", "[Ljava/lang/String;", "textsCh", "textsEn", "textsOld", "textsTh", "textsTw", "useAssets", "", "versionName", "checkNewEmoji", "checkSpan", "Landroid/text/Spannable;", "ss", "sizeInPx", "", "start", "end", "checkUpdateRes", "", "containEmoji", "source", "getNewEmojiDrawable", "Landroid/graphics/drawable/Drawable;", "name", "getQQEmojiDrawable", "pos", "getQQEmojiItemAt", "Lcom/tencent/mm/smiley/QQEmojiItem;", "content", "", "getQQSmileyDataFromSource", "check", "getQQSmileyDrawable", "smileyInfo", "getQQSmileyStringFromSource", "getSmileyDrawable", "item", "getSmileyInfo", "key", "initXMLSmiley", "process", "matchCallback", "Lcom/tencent/mm/smiley/IEmojiMatchCallback;", "redressSelection", "selection", "replace", "replacement", "updateSmiley", "Companion", "MMTrimMemoryEventListener", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class QQSmileyManager
{
  private static QQSmileyManager acyJ;
  private static MMTrimMemoryEventListener acyK;
  private static boolean acyL;
  public static final a acyx;
  private final String Wqe;
  private final String[] acyA;
  private final String[] acyB;
  private final String[] acyC;
  private final String[] acyD;
  private ArrayList<SmileyInfo> acyE;
  private final HashMap<String, SmileyInfo> acyF;
  final HashMap<String, SmileyInfo> acyG;
  private boolean acyH;
  public t acyI;
  private final String[] acyy;
  private final String[] acyz;
  private final String hCS;
  private final com.tencent.mm.b.f<String, Bitmap> ltC;
  private final String mga;
  private final String versionName;
  
  static
  {
    AppMethodBeat.i(104945);
    acyx = new a((byte)0);
    AppMethodBeat.o(104945);
  }
  
  private QQSmileyManager(Context paramContext)
  {
    AppMethodBeat.i(104931);
    this.mga = s.X(com.tencent.mm.loader.i.b.bms(), "emoji/newemoji/");
    this.Wqe = "assets:///newemoji/";
    this.versionName = "config.conf";
    this.hCS = "newemoji-config.xml";
    this.acyE = new ArrayList();
    this.acyF = new HashMap();
    this.acyG = new HashMap();
    this.ltC = ((com.tencent.mm.b.f)new com.tencent.mm.memory.a.b(150, getClass()));
    this.acyH = true;
    this.acyI = new t();
    if (acyK != null)
    {
      localObject = acyK;
      s.checkNotNull(localObject);
      ((MMTrimMemoryEventListener)localObject).dead();
    }
    Object localObject = new MMTrimMemoryEventListener(this);
    acyK = (MMTrimMemoryEventListener)localObject;
    s.checkNotNull(localObject);
    ((MMTrimMemoryEventListener)localObject).alive();
    long l = System.currentTimeMillis();
    localObject = paramContext.getResources().getStringArray(a.b.smiley_values);
    s.s(localObject, "context.resources.getStr…ay(R.array.smiley_values)");
    this.acyy = ((String[])localObject);
    localObject = paramContext.getResources().getStringArray(a.b.smiley_values_old);
    s.s(localObject, "context.resources.getStr….array.smiley_values_old)");
    this.acyz = ((String[])localObject);
    localObject = paramContext.getResources().getStringArray(a.b.smiley_values_ch);
    s.s(localObject, "context.resources.getStr…R.array.smiley_values_ch)");
    this.acyA = ((String[])localObject);
    localObject = paramContext.getResources().getStringArray(a.b.smiley_values_tw);
    s.s(localObject, "context.resources.getStr…R.array.smiley_values_tw)");
    this.acyB = ((String[])localObject);
    localObject = paramContext.getResources().getStringArray(a.b.smiley_values_en);
    s.s(localObject, "context.resources.getStr…R.array.smiley_values_en)");
    this.acyC = ((String[])localObject);
    paramContext = paramContext.getResources().getStringArray(a.b.smiley_values_th);
    s.s(paramContext, "context.resources.getStr…R.array.smiley_values_th)");
    this.acyD = paramContext;
    iVn();
    Log.i("MicroMsg.QQSmileyManager", "QQSmileyManager use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    iVp();
    AppMethodBeat.o(104931);
  }
  
  private final void iVn()
  {
    AppMethodBeat.i(242796);
    int i;
    int k;
    if (this.acyy.length == this.acyA.length)
    {
      i = 0;
      k = this.acyy.length - 1;
      if (k < 0) {
        break label241;
      }
    }
    for (;;)
    {
      int j = i + 1;
      String str1 = this.acyy[i];
      String str2 = this.acyA[i];
      Object localObject1 = this.acyz;
      Object localObject2;
      label103:
      Object localObject3;
      if ((i >= 0) && (i <= k.ad((Object[])localObject1)))
      {
        localObject1 = localObject1[i];
        localObject2 = this.acyB;
        if ((i < 0) || (i > k.ad((Object[])localObject2))) {
          break label208;
        }
        localObject2 = localObject2[i];
        localObject3 = this.acyC;
        if ((i < 0) || (i > k.ad((Object[])localObject3))) {
          break label216;
        }
        localObject3 = localObject3[i];
        label128:
        localObject4 = this.acyD;
        if ((i < 0) || (i > k.ad((Object[])localObject4))) {
          break label224;
        }
      }
      label208:
      label216:
      label224:
      for (Object localObject4 = localObject4[i];; localObject4 = "")
      {
        ((Map)this.acyF).put(str1, new SmileyInfo(str1, (String)localObject1, str2, (String)localObject2, (String)localObject3, (String)localObject4, i));
        if (j <= k) {
          break label248;
        }
        AppMethodBeat.o(242796);
        return;
        localObject1 = "";
        break;
        localObject2 = "";
        break label103;
        localObject3 = "";
        break label128;
      }
      Log.i("MicroMsg.QQSmileyManager", "read smiley array failed.");
      label241:
      AppMethodBeat.o(242796);
      return;
      label248:
      i = j;
    }
  }
  
  public static boolean iVo()
  {
    AppMethodBeat.i(104934);
    Log.i("MicroMsg.QQSmileyManager", "checkNewEmoji");
    AppMethodBeat.o(104934);
    return false;
  }
  
  public static final QQSmileyManager iVq()
  {
    AppMethodBeat.i(104932);
    QQSmileyManager localQQSmileyManager = a.iVq();
    AppMethodBeat.o(104932);
    return localQQSmileyManager;
  }
  
  public final Spannable a(Spannable paramSpannable, int paramInt)
  {
    AppMethodBeat.i(242810);
    paramSpannable = a(paramSpannable, paramInt, 0, -1);
    AppMethodBeat.o(242810);
    return paramSpannable;
  }
  
  public final Spannable a(final Spannable paramSpannable, final int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(242811);
    this.acyI.a((CharSequence)paramSpannable, paramInt2, paramInt3, (m)new b(this, paramSpannable, paramInt1));
    AppMethodBeat.o(242811);
    return paramSpannable;
  }
  
  public final Drawable ayt(int paramInt)
  {
    AppMethodBeat.i(242812);
    String str = paramInt + ".wxam";
    Bitmap localBitmap = (Bitmap)this.ltC.get(str);
    Object localObject = localBitmap;
    if (localBitmap == null)
    {
      localObject = y.bi(s.X("assets:///emoji/qqemoji/", str), 0, -1);
      localObject = MMGIFJNIFactory.Companion.decodeThumb((byte[])localObject);
      if (localObject == null) {
        Log.e("MicroMsg.QQSmileyManager", "qqemoji decoder error");
      }
    }
    for (;;)
    {
      localObject = (Drawable)new BitmapDrawable(MMApplicationContext.getContext().getResources(), (Bitmap)localObject);
      AppMethodBeat.o(242812);
      return localObject;
      this.ltC.put(str, localObject);
    }
  }
  
  final Drawable buE(String paramString)
  {
    AppMethodBeat.i(242814);
    Object localObject4 = s.X(a.bIF(), paramString);
    Object localObject3 = new BitmapFactory.Options();
    Object localObject1 = this.ltC.get(paramString);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      if (!this.acyH) {
        break label265;
      }
      localObject2 = y.bi(s.X(this.Wqe, paramString), 0, -1);
      localObject1 = localObject2;
      if (Util.isNullOrNil((byte[])localObject2))
      {
        localObject1 = localObject2;
        if (y.ZC(s.X(this.mga, paramString)))
        {
          Log.w("MicroMsg.QQSmileyManager", "getQQSmileyDrawable: fallback use local");
          localObject1 = y.bi(s.X(this.mga, paramString), 0, -1);
        }
      }
      localObject2 = MMGIFJNIFactory.Companion.decodeThumb((byte[])localObject1);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label494;
      }
      Log.w("MicroMsg.QQSmileyManager", "[getQQSmileyDrawable] not exist! path:%s name:%s", new Object[] { localObject4, paramString });
      if (MMApplicationContext.isMainProcess()) {
        break label330;
      }
      Log.w("MicroMsg.QQSmileyManager", "checkUpdateRes not mm process, return");
      label161:
      localObject1 = localObject2;
    }
    label265:
    label330:
    label494:
    for (;;)
    {
      try
      {
        localObject4 = (Closeable)MMApplicationContext.getContext().getAssets().open(s.X("newemoji/", paramString));
        try
        {
          localObject3 = BitmapFactory.decodeStream((InputStream)localObject4, null, (BitmapFactory.Options)localObject3);
          localObject2 = localObject3;
          localObject1 = ah.aiuX;
          localObject1 = localObject3;
          kotlin.f.b.a((Closeable)localObject4, null);
          localObject1 = localObject3;
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            this.ltC.put(paramString, localObject1);
            localObject2 = localObject1;
          }
          paramString = (Drawable)new BitmapDrawable(MMApplicationContext.getContext().getResources(), (Bitmap)localObject2);
          AppMethodBeat.o(242814);
          return paramString;
        }
        finally
        {
          try
          {
            AppMethodBeat.o(242814);
            throw localThrowable;
          }
          finally
          {
            localObject1 = localObject2;
            kotlin.f.b.a((Closeable)localObject4, localThrowable);
            localObject1 = localObject2;
            AppMethodBeat.o(242814);
            localObject1 = localObject2;
          }
        }
        localObject2 = y.bi(s.X(this.mga, paramString), 0, -1);
        localObject1 = localObject2;
        if (!Util.isNullOrNil((byte[])localObject2)) {
          break;
        }
        localObject1 = localObject2;
        if (!y.ZC(s.X(this.Wqe, paramString))) {
          break;
        }
        Log.w("MicroMsg.QQSmileyManager", "getQQSmileyDrawable: fallback use asset");
        localObject1 = y.bi(s.X(this.Wqe, paramString), 0, -1);
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.QQSmileyManager", (Throwable)localException, "", new Object[0]);
      }
      if (!h.baz())
      {
        Log.w("MicroMsg.QQSmileyManager", "account not ready");
        break label161;
      }
      Log.w("MicroMsg.QQSmileyManager", "checkUpdateRes: %s", new Object[] { Boolean.valueOf(acyL) });
      if (acyL) {
        break label161;
      }
      acyL = true;
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
      if (y.ZC(com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.nK(37, 1)))
      {
        ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzA();
        break label161;
      }
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf().f(37, 1, -1, false);
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
      com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(37);
      break label161;
    }
  }
  
  public final SmileyInfo buF(String paramString)
  {
    AppMethodBeat.i(104943);
    s.u(paramString, "key");
    SmileyInfo localSmileyInfo2 = (SmileyInfo)this.acyF.get(paramString);
    SmileyInfo localSmileyInfo1 = localSmileyInfo2;
    if (localSmileyInfo2 == null) {
      localSmileyInfo1 = (SmileyInfo)this.acyG.get(paramString);
    }
    if (localSmileyInfo1 != null)
    {
      AppMethodBeat.o(104943);
      return localSmileyInfo1;
    }
    Log.i("MicroMsg.QQSmileyManager", "getSmileyInfo failed. smiley map no contains key:%s", new Object[] { kotlin.n.n.m(paramString, "\\", "\\\\", false) });
    AppMethodBeat.o(104943);
    return null;
  }
  
  public final boolean buu(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(242805);
    s.u(paramString, "source");
    paramString = (CharSequence)paramString;
    s.u(paramString, "check");
    if (Util.isNullOrNil(paramString))
    {
      paramString = (String)localObject;
      if (paramString != null)
      {
        AppMethodBeat.o(242805);
        return true;
      }
    }
    else
    {
      localObject = this.acyI;
      int i = paramString.length();
      localObject = new f((n)((t)localObject).acyv);
      ah.f localf = new ah.f();
      ((f)localObject).b(paramString, 0, i, (m)new t.b(localf));
      paramString = (l)localf.aqH;
      if (!(paramString instanceof r)) {
        break label135;
      }
    }
    label135:
    for (paramString = (r)paramString;; paramString = null)
    {
      break;
      AppMethodBeat.o(242805);
      return false;
    }
  }
  
  public final void iVp()
  {
    long l;
    Object localObject5;
    String str1;
    String str2;
    try
    {
      AppMethodBeat.i(104936);
      l = System.currentTimeMillis();
      this.acyI = new t();
      Object localObject1 = this.acyF.values();
      s.s(localObject1, "qqEmojiMap.values");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (SmileyInfo)((Iterator)localObject1).next();
        localObject5 = this.acyI;
        i = ((SmileyInfo)localObject4).field_position;
        str1 = ((SmileyInfo)localObject4).field_key;
        s.s(str1, "it.field_key");
        str2 = ((SmileyInfo)localObject4).field_key;
        s.s(str2, "it.field_key");
        ((t)localObject5).a(new r(i, str1, str2, ((SmileyInfo)localObject4).field_fileName));
        localObject5 = this.acyI;
        i = ((SmileyInfo)localObject4).field_position;
        str1 = ((SmileyInfo)localObject4).field_key;
        s.s(str1, "it.field_key");
        str2 = ((SmileyInfo)localObject4).field_qqValue;
        s.s(str2, "it.field_qqValue");
        ((t)localObject5).a(new r(i, str1, str2, ((SmileyInfo)localObject4).field_fileName));
        localObject5 = this.acyI;
        i = ((SmileyInfo)localObject4).field_position;
        str1 = ((SmileyInfo)localObject4).field_key;
        s.s(str1, "it.field_key");
        str2 = ((SmileyInfo)localObject4).field_cnValue;
        s.s(str2, "it.field_cnValue");
        ((t)localObject5).a(new r(i, str1, str2, ((SmileyInfo)localObject4).field_fileName));
        localObject5 = this.acyI;
        i = ((SmileyInfo)localObject4).field_position;
        str1 = ((SmileyInfo)localObject4).field_key;
        s.s(str1, "it.field_key");
        str2 = ((SmileyInfo)localObject4).field_twValue;
        s.s(str2, "it.field_twValue");
        ((t)localObject5).a(new r(i, str1, str2, ((SmileyInfo)localObject4).field_fileName));
        localObject5 = this.acyI;
        i = ((SmileyInfo)localObject4).field_position;
        str1 = ((SmileyInfo)localObject4).field_key;
        s.s(str1, "it.field_key");
        str2 = ((SmileyInfo)localObject4).field_enValue;
        s.s(str2, "it.field_enValue");
        ((t)localObject5).a(new r(i, str1, str2, ((SmileyInfo)localObject4).field_fileName));
        localObject5 = this.acyI;
        i = ((SmileyInfo)localObject4).field_position;
        str1 = ((SmileyInfo)localObject4).field_key;
        s.s(str1, "it.field_key");
        str2 = ((SmileyInfo)localObject4).field_thValue;
        s.s(str2, "it.field_thValue");
        ((t)localObject5).a(new r(i, str1, str2, ((SmileyInfo)localObject4).field_fileName));
      }
      this.acyG.clear();
    }
    finally {}
    this.ltC.clear();
    int i = com.tencent.mm.emoji.f.d.Ex(s.X(this.mga, this.versionName));
    int j = com.tencent.mm.emoji.f.d.Ex(s.X(this.Wqe, this.versionName));
    Object localObject4 = s.X(this.mga, this.hCS);
    Object localObject3 = s.X(this.Wqe, this.hCS);
    Log.i("MicroMsg.QQSmileyManager", "updateSmiley: local:%s, asset:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if ((i > 0) && (i >= j) && (y.ZC((String)localObject4)))
    {
      this.acyH = false;
      localObject4 = com.tencent.mm.emoji.f.d.d(new u((String)localObject4));
      s.s(localObject4, "parserSmileyConfig(VFSFile(localConfig))");
      this.acyE = ((ArrayList)localObject4);
      Log.i("MicroMsg.QQSmileyManager", "updateSmiley: local size: %s", new Object[] { Integer.valueOf(this.acyE.size()) });
    }
    for (;;)
    {
      if (this.acyE.size() <= 0)
      {
        this.acyH = true;
        localObject3 = com.tencent.mm.emoji.f.d.d(new u((String)localObject3));
        s.s(localObject3, "parserSmileyConfig(VFSFile(assetConfig))");
        this.acyE = ((ArrayList)localObject3);
        Log.i("MicroMsg.QQSmileyManager", "updateSmiley: asset size: %s", new Object[] { Integer.valueOf(this.acyE.size()) });
      }
      localObject3 = ((Iterable)this.acyE).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (SmileyInfo)((Iterator)localObject3).next();
        localObject5 = (Map)this.acyG;
        str1 = ((SmileyInfo)localObject4).field_key;
        s.s(str1, "it.field_key");
        ((Map)localObject5).put(str1, localObject4);
        localObject5 = this.acyI;
        i = ((SmileyInfo)localObject4).field_position;
        str1 = ((SmileyInfo)localObject4).field_key;
        s.s(str1, "it.field_key");
        str2 = ((SmileyInfo)localObject4).field_key;
        s.s(str2, "it.field_key");
        ((t)localObject5).a(new r(i, str1, str2, ((SmileyInfo)localObject4).field_fileName));
        localObject5 = this.acyI;
        i = ((SmileyInfo)localObject4).field_position;
        str1 = ((SmileyInfo)localObject4).field_key;
        s.s(str1, "it.field_key");
        str2 = ((SmileyInfo)localObject4).field_qqValue;
        s.s(str2, "it.field_qqValue");
        ((t)localObject5).a(new r(i, str1, str2, ((SmileyInfo)localObject4).field_fileName));
        localObject5 = this.acyI;
        i = ((SmileyInfo)localObject4).field_position;
        str1 = ((SmileyInfo)localObject4).field_key;
        s.s(str1, "it.field_key");
        str2 = ((SmileyInfo)localObject4).field_cnValue;
        s.s(str2, "it.field_cnValue");
        ((t)localObject5).a(new r(i, str1, str2, ((SmileyInfo)localObject4).field_fileName));
        localObject5 = this.acyI;
        i = ((SmileyInfo)localObject4).field_position;
        str1 = ((SmileyInfo)localObject4).field_key;
        s.s(str1, "it.field_key");
        str2 = ((SmileyInfo)localObject4).field_twValue;
        s.s(str2, "it.field_twValue");
        ((t)localObject5).a(new r(i, str1, str2, ((SmileyInfo)localObject4).field_fileName));
        localObject5 = this.acyI;
        i = ((SmileyInfo)localObject4).field_position;
        str1 = ((SmileyInfo)localObject4).field_key;
        s.s(str1, "it.field_key");
        str2 = ((SmileyInfo)localObject4).field_enValue;
        s.s(str2, "it.field_enValue");
        ((t)localObject5).a(new r(i, str1, str2, ((SmileyInfo)localObject4).field_fileName));
        localObject5 = this.acyI;
        i = ((SmileyInfo)localObject4).field_position;
        str1 = ((SmileyInfo)localObject4).field_key;
        s.s(str1, "it.field_key");
        str2 = ((SmileyInfo)localObject4).field_thValue;
        s.s(str2, "it.field_thValue");
        ((t)localObject5).a(new r(i, str1, str2, ((SmileyInfo)localObject4).field_fileName));
      }
      this.acyE = new ArrayList();
    }
    Log.i("MicroMsg.QQSmileyManager", "updateSmiley end use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(104936);
  }
  
  public final r l(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(242809);
    if (Util.isNullOrNil(paramCharSequence))
    {
      AppMethodBeat.o(242809);
      return null;
    }
    final ah.f localf = new ah.f();
    this.acyI.a(paramCharSequence, paramInt, -1, (m)new c(paramInt, localf));
    paramCharSequence = (r)localf.aqH;
    AppMethodBeat.o(242809);
    return paramCharSequence;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/QQSmileyManager$MMTrimMemoryEventListener;", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MMTrimMemoryEvent;", "target", "Lcom/tencent/mm/smiley/QQSmileyManager;", "(Lcom/tencent/mm/smiley/QQSmileyManager;)V", "weakTarget", "Ljava/lang/ref/WeakReference;", "callback", "", "event", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class MMTrimMemoryEventListener
    extends IListener<oc>
  {
    private final WeakReference<QQSmileyManager> nph;
    
    public MMTrimMemoryEventListener(QQSmileyManager paramQQSmileyManager)
    {
      super();
      AppMethodBeat.i(242799);
      this.nph = new WeakReference(paramQQSmileyManager);
      AppMethodBeat.o(242799);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/QQSmileyManager$Companion;", "", "()V", "ASSETS_EMOJI_DIR", "", "TAG", "hasChecked", "", "instance", "Lcom/tencent/mm/smiley/QQSmileyManager;", "sTrimMemoryEventListener", "Lcom/tencent/mm/smiley/QQSmileyManager$MMTrimMemoryEventListener;", "getInstance", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static QQSmileyManager iVq()
    {
      AppMethodBeat.i(242869);
      if (QQSmileyManager.iVr() == null) {}
      try
      {
        if (QQSmileyManager.iVr() == null)
        {
          localObject1 = QQSmileyManager.acyx;
          localObject1 = MMApplicationContext.getContext();
          s.s(localObject1, "getContext()");
          QQSmileyManager.a(new QQSmileyManager((Context)localObject1, (byte)0));
        }
        Object localObject1 = ah.aiuX;
        localObject1 = QQSmileyManager.iVr();
        s.checkNotNull(localObject1);
        AppMethodBeat.o(242869);
        return localObject1;
      }
      finally
      {
        AppMethodBeat.o(242869);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/smiley/QQSmileyManager$checkSpan$1", "Lcom/tencent/mm/smiley/IEmojiMatchCallback;", "onMatch", "", "item", "Lcom/tencent/mm/smiley/IEmojiItem;", "startIndex", "", "endIndex", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements m
  {
    b(QQSmileyManager paramQQSmileyManager, Spannable paramSpannable, int paramInt) {}
    
    public final boolean a(l paraml, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242866);
      s.u(paraml, "item");
      QQSmileyManager localQQSmileyManager;
      int i;
      if ((paraml instanceof r))
      {
        localQQSmileyManager = this.acyM;
        paraml = (r)paraml;
        s.u(paraml, "item");
        i = paraml.pos;
        if (i < 0) {
          break label75;
        }
      }
      label75:
      for (paraml = localQQSmileyManager.ayt(i);; paraml = localQQSmileyManager.buE(paraml.name))
      {
        EmojiHelper.iUM();
        EmojiHelper.a(paramSpannable, paraml, paramInt1, paramInt2);
        AppMethodBeat.o(242866);
        return false;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/smiley/QQSmileyManager$getQQEmojiItemAt$1", "Lcom/tencent/mm/smiley/IEmojiMatchCallback;", "onMatch", "", "item", "Lcom/tencent/mm/smiley/IEmojiItem;", "startIndex", "", "endIndex", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements m
  {
    c(int paramInt, ah.f<r> paramf) {}
    
    public final boolean a(l paraml, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242864);
      s.u(paraml, "item");
      if ((paramInt1 == this.apX) && ((paraml instanceof r))) {
        localf.aqH = paraml;
      }
      AppMethodBeat.o(242864);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/smiley/QQSmileyManager$replace$1", "Lcom/tencent/mm/smiley/IEmojiMatchCallback;", "onMatch", "", "item", "Lcom/tencent/mm/smiley/IEmojiItem;", "startIndex", "", "endIndex", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements m
  {
    public d(StringBuilder paramStringBuilder, String paramString1, ah.d paramd, String paramString2) {}
    
    public final boolean a(l paraml, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242863);
      s.u(paraml, "item");
      if ((paraml instanceof r))
      {
        this.wGN.append((CharSequence)this.nhk, this.acyh.aixb, paramInt1);
        this.wGN.append(this.acyO);
        this.acyh.aixb = paramInt2;
      }
      AppMethodBeat.o(242863);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.QQSmileyManager
 * JD-Core Version:    0.7.0.1
 */