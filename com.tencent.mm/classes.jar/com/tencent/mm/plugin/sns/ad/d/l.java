package com.tencent.mm.plugin.sns.ad.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.ad.j.j;
import com.tencent.mm.plugin.sns.ad.j.j.b;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class l
{
  private static boolean POd = false;
  
  public static Cursor a(Cursor paramCursor, com.tencent.mm.storagebase.h paramh, String paramString)
  {
    AppMethodBeat.i(309969);
    Object localObject;
    label95:
    ArrayList localArrayList;
    long l1;
    label150:
    long l2;
    int i;
    if (paramCursor == null)
    {
      int j;
      int k;
      do
      {
        for (;;)
        {
          try
          {
            com.tencent.mm.sdk.platformtools.Log.i("ConsecutiveAdHelper", "the cursor is null!");
            AppMethodBeat.o(309969);
            return null;
          }
          finally
          {
            com.tencent.mm.sdk.platformtools.Log.e("ConsecutiveAdHelper", "there is something wrong in removeConsecutiveAd: " + android.util.Log.getStackTraceString(paramCursor));
            com.tencent.mm.plugin.sns.data.l.a(com.tencent.mm.plugin.sns.data.l.Qnx, "", 0, 0, "");
            paramCursor = f(paramh, paramString);
            AppMethodBeat.o(309969);
            return paramCursor;
          }
          if (!d.isEmpty((Collection)localObject)) {
            break label258;
          }
          paramCursor.moveToFirst();
          AppMethodBeat.o(309969);
          return paramCursor;
          j = paramCursor.getColumnIndex("snsId");
          k = paramCursor.getColumnIndex("sourceType");
          if ((j >= 0) && (k >= 0)) {
            break;
          }
          com.tencent.mm.sdk.platformtools.Log.w("ConsecutiveAdHelper", "the snsid index or source type index is invalid!");
          localObject = null;
        }
        localArrayList = new ArrayList();
        l1 = 0L;
        localObject = localArrayList;
      } while (!paramCursor.moveToNext());
      l2 = paramCursor.getLong(j);
      if ((paramCursor.getInt(k) & 0x20) <= 0) {
        break label341;
      }
      i = 1;
    }
    label258:
    label341:
    label344:
    for (;;)
    {
      if (l1 == 0L)
      {
        com.tencent.mm.sdk.platformtools.Log.i("ConsecutiveAdHelper", "there is first ad sns id is ".concat(String.valueOf(l2)));
        l1 = l2;
        break label150;
      }
      com.tencent.mm.sdk.platformtools.Log.i("ConsecutiveAdHelper", "there is consecutive ad sns id is ".concat(String.valueOf(l2)));
      localArrayList.add(new b(l1, l2));
      break label150;
      paramCursor.close();
      kv((List)localObject);
      com.tencent.mm.plugin.report.service.h.OAn.p(1612L, 30L, ((List)localObject).size());
      j.a(new a((List)localObject));
      com.tencent.mm.sdk.platformtools.Log.d("ConsecutiveAdHelper", "it need to query again!!");
      paramCursor = f(paramh, paramString);
      AppMethodBeat.o(309969);
      return paramCursor;
      if (paramCursor != null) {
        break label95;
      }
      localObject = null;
      break;
      for (;;)
      {
        if (i != 0) {
          break label344;
        }
        l1 = 0L;
        break;
        i = 0;
      }
    }
  }
  
  private static Cursor f(com.tencent.mm.storagebase.h paramh, String paramString)
  {
    AppMethodBeat.i(309982);
    if (paramh != null)
    {
      paramh = paramh.rawQuery(paramString, null);
      AppMethodBeat.o(309982);
      return paramh;
    }
    AppMethodBeat.o(309982);
    return null;
  }
  
  public static void gZO()
  {
    POd = true;
  }
  
  public static boolean gZP()
  {
    AppMethodBeat.i(309951);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      com.tencent.mm.sdk.platformtools.Log.i("ConsecutiveAdHelper", "this is debug mode， isFilterValueInDebug is " + POd);
      boolean bool = POd;
      AppMethodBeat.o(309951);
      return bool;
    }
    AppMethodBeat.o(309951);
    return true;
  }
  
  public static boolean gZQ()
  {
    AppMethodBeat.i(309955);
    try
    {
      int i = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yIf, 0);
      com.tencent.mm.sdk.platformtools.Log.i("ConsecutiveAdHelper", "isConsecutiveFilter exptValue =".concat(String.valueOf(i)));
      return i > 0;
    }
    finally
    {
      AppMethodBeat.o(309955);
    }
    return true;
  }
  
  private static void kv(List<b> paramList)
  {
    AppMethodBeat.i(309976);
    if (d.isEmpty(paramList))
    {
      AppMethodBeat.o(309976);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      long l = ((b)paramList.next()).ibq;
      if (l != 0L)
      {
        com.tencent.mm.sdk.platformtools.Log.i("ConsecutiveAdHelper", "delete sns id ".concat(String.valueOf(l)));
        al.hgE().delete(l);
        al.hgH().vh(l);
        n.vg(l);
      }
    }
    AppMethodBeat.o(309976);
  }
  
  static final class a
    extends j.b
  {
    final List<l.b> POe;
    
    a(List<l.b> paramList)
    {
      this.POe = paramList;
    }
    
    public final void bN(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(310088);
      try
      {
        paramJSONObject.putOpt("snsId", "");
        paramJSONObject.putOpt("uxinfo", "");
        paramJSONObject.putOpt("adExtInfo", "");
        paramJSONObject.putOpt("scene", Integer.valueOf(0));
        return;
      }
      finally
      {
        AppMethodBeat.o(310088);
      }
    }
    
    /* Error */
    public final void bO(JSONObject paramJSONObject)
    {
      // Byte code:
      //   0: ldc 56
      //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 17	com/tencent/mm/plugin/sns/ad/d/l$a:POe	Ljava/util/List;
      //   9: invokestatic 62	com/tencent/mm/plugin/sns/ad/j/d:isEmpty	(Ljava/util/Collection;)Z
      //   12: istore_3
      //   13: iload_3
      //   14: ifeq +9 -> 23
      //   17: ldc 56
      //   19: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   22: return
      //   23: new 64	org/json/JSONArray
      //   26: dup
      //   27: invokespecial 65	org/json/JSONArray:<init>	()V
      //   30: astore 4
      //   32: aload_1
      //   33: ldc 67
      //   35: aload_0
      //   36: getfield 17	com/tencent/mm/plugin/sns/ad/d/l$a:POe	Ljava/util/List;
      //   39: invokeinterface 73 1 0
      //   44: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   47: invokevirtual 39	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   50: pop
      //   51: aload_1
      //   52: ldc 75
      //   54: aload 4
      //   56: invokevirtual 39	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   59: pop
      //   60: aload_0
      //   61: getfield 17	com/tencent/mm/plugin/sns/ad/d/l$a:POe	Ljava/util/List;
      //   64: invokeinterface 79 1 0
      //   69: astore_1
      //   70: iconst_0
      //   71: istore_2
      //   72: aload_1
      //   73: invokeinterface 85 1 0
      //   78: ifeq +78 -> 156
      //   81: aload_1
      //   82: invokeinterface 89 1 0
      //   87: checkcast 91	com/tencent/mm/plugin/sns/ad/d/l$b
      //   90: astore 5
      //   92: aload 5
      //   94: ifnull +52 -> 146
      //   97: new 35	org/json/JSONObject
      //   100: dup
      //   101: invokespecial 92	org/json/JSONObject:<init>	()V
      //   104: astore 6
      //   106: aload 6
      //   108: ldc 31
      //   110: aload 5
      //   112: getfield 96	com/tencent/mm/plugin/sns/ad/d/l$b:ibq	J
      //   115: invokestatic 102	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
      //   118: invokevirtual 39	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   121: pop
      //   122: aload 6
      //   124: ldc 104
      //   126: aload 5
      //   128: getfield 107	com/tencent/mm/plugin/sns/ad/d/l$b:POf	J
      //   131: invokestatic 102	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
      //   134: invokevirtual 39	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   137: pop
      //   138: aload 4
      //   140: aload 6
      //   142: invokevirtual 111	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
      //   145: pop
      //   146: iload_2
      //   147: iconst_1
      //   148: iadd
      //   149: istore_2
      //   150: iload_2
      //   151: bipush 10
      //   153: if_icmplt +21 -> 174
      //   156: ldc 56
      //   158: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   161: return
      //   162: astore_1
      //   163: ldc 56
      //   165: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   168: return
      //   169: astore 5
      //   171: goto -25 -> 146
      //   174: goto -102 -> 72
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	177	0	this	a
      //   0	177	1	paramJSONObject	JSONObject
      //   71	83	2	i	int
      //   12	2	3	bool	boolean
      //   30	109	4	localJSONArray	org.json.JSONArray
      //   90	37	5	localb	l.b
      //   169	1	5	localObject	Object
      //   104	37	6	localJSONObject	JSONObject
      // Exception table:
      //   from	to	target	type
      //   5	13	162	finally
      //   23	70	162	finally
      //   72	92	162	finally
      //   97	146	169	finally
    }
    
    public final String gZE()
    {
      return "sns_ad_remove_consecutive_ad_report";
    }
  }
  
  static final class b
  {
    final long POf;
    final long ibq;
    
    b(long paramLong1, long paramLong2)
    {
      this.POf = paramLong1;
      this.ibq = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.l
 * JD-Core Version:    0.7.0.1
 */