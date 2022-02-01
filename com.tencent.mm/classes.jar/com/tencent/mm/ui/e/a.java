package com.tencent.mm.ui.e;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.db;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;

public final class a
  implements com.tencent.mm.plugin.appbrand.service.n
{
  private static String TAG = "MicroMsg.ConvBoxConversationService";
  
  private static int aip(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(249862);
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(249862);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private static void b(bb parambb1, bb parambb2)
  {
    AppMethodBeat.i(249870);
    Object localObject = jzQ();
    if ((localObject == null) || (TextUtils.isEmpty(((bd)localObject).field_digest)))
    {
      parambb1.BF(MMApplicationContext.getContext().getString(R.l.gDp));
      AppMethodBeat.o(249870);
      return;
    }
    SpannableString localSpannableString = n((bb)localObject);
    if ((((bd)localObject).field_msgType != null) && ((((bd)localObject).field_msgType.equals("47")) || (((bd)localObject).field_msgType.equals("1048625")))) {
      localObject = o((bb)localObject);
    }
    for (;;)
    {
      parambb1.BF(MMApplicationContext.getContext().getString(R.l.gDq, new Object[] { localSpannableString, localObject }));
      localObject = new cc();
      try
      {
        ((cc)localObject).setType(Integer.parseInt(parambb2.field_msgType));
        label127:
        if (((cc)localObject).jbF())
        {
          parambb1.pG(0);
          AppMethodBeat.o(249870);
          return;
          if ((((bd)localObject).field_digest != null) && (((bd)localObject).field_digest.contains(":")))
          {
            localObject = ((bd)localObject).field_digest.substring(((bd)localObject).field_digest.indexOf(":") + 1).replace(" ", "").replace("\n", "");
            parambb1.BF(MMApplicationContext.getContext().getString(R.l.gDq, new Object[] { localSpannableString, localObject }));
            continue;
          }
          localObject = p((bb)localObject);
          continue;
        }
        parambb1.pG(jzP());
        AppMethodBeat.o(249870);
        return;
      }
      catch (Exception parambb2)
      {
        break label127;
      }
    }
  }
  
  private void b(final bb parambb, String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(249874);
    db localdb = new db();
    localdb.hCV.hCY = paramString;
    localdb.hCV.hCX = new a()
    {
      public final void As(long paramAnonymousLong)
      {
        AppMethodBeat.i(249813);
        parambb.gR(paramAnonymousLong);
        if (paramBoolean)
        {
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().c(parambb, "conversationboxservice");
          AppMethodBeat.o(249813);
          return;
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().h(parambb);
        AppMethodBeat.o(249813);
      }
    };
    localdb.asyncPublish(Looper.getMainLooper());
    AppMethodBeat.o(249874);
  }
  
  private static String bAr(String paramString)
  {
    AppMethodBeat.i(249845);
    if ((paramString != null) && (paramString.length() == 32))
    {
      paramString = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoi(paramString);
      AppMethodBeat.o(249845);
      return paramString;
    }
    AppMethodBeat.o(249845);
    return null;
  }
  
  private static int jzP()
  {
    AppMethodBeat.i(249818);
    int i = 0;
    int j = 0;
    bh.bCz();
    Cursor localCursor = c.bzG().a(5, new ArrayList(), "conversationboxservice");
    if (localCursor.moveToFirst()) {
      do
      {
        bb localbb = new bb();
        localbb.convertFrom(localCursor);
        if (localbb.field_unReadCount == 0)
        {
          i = j;
          if (localbb.field_unReadMuteCount == 0) {}
        }
        else
        {
          i = j + 1;
        }
        j = i;
      } while (localCursor.moveToNext());
    }
    localCursor.close();
    AppMethodBeat.o(249818);
    return i;
  }
  
  /* Error */
  private static bb jzQ()
  {
    // Byte code:
    //   0: ldc_w 260
    //   3: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore_1
    //   8: aconst_null
    //   9: astore_3
    //   10: invokestatic 221	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   13: pop
    //   14: invokestatic 227	com/tencent/mm/model/c:bzG	()Lcom/tencent/mm/storage/by;
    //   17: iconst_5
    //   18: new 229	java/util/ArrayList
    //   21: dup
    //   22: invokespecial 230	java/util/ArrayList:<init>	()V
    //   25: ldc 232
    //   27: invokeinterface 237 4 0
    //   32: astore 4
    //   34: aload 4
    //   36: invokeinterface 242 1 0
    //   41: istore_0
    //   42: iload_0
    //   43: ifeq +51 -> 94
    //   46: aconst_null
    //   47: astore_1
    //   48: new 92	com/tencent/mm/storage/bb
    //   51: dup
    //   52: invokespecial 243	com/tencent/mm/storage/bb:<init>	()V
    //   55: astore_2
    //   56: aload_2
    //   57: astore_1
    //   58: aload_2
    //   59: aload 4
    //   61: invokevirtual 247	com/tencent/mm/storage/bb:convertFrom	(Landroid/database/Cursor;)V
    //   64: aload_2
    //   65: astore_3
    //   66: aload_2
    //   67: astore_1
    //   68: aload_2
    //   69: getfield 66	com/tencent/mm/autogen/b/bd:field_digest	Ljava/lang/String;
    //   72: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: ifeq +19 -> 94
    //   78: aload_2
    //   79: astore_1
    //   80: aload 4
    //   82: invokeinterface 256 1 0
    //   87: istore_0
    //   88: iload_0
    //   89: ifne +67 -> 156
    //   92: aload_2
    //   93: astore_3
    //   94: aload 4
    //   96: invokeinterface 259 1 0
    //   101: aload_3
    //   102: astore_1
    //   103: ldc_w 260
    //   106: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_1
    //   110: areturn
    //   111: astore_2
    //   112: getstatic 19	com/tencent/mm/ui/e/a:TAG	Ljava/lang/String;
    //   115: aload_2
    //   116: ldc_w 262
    //   119: iconst_0
    //   120: anewarray 4	java/lang/Object
    //   123: invokestatic 268	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: aload 4
    //   128: invokeinterface 259 1 0
    //   133: goto -30 -> 103
    //   136: astore_1
    //   137: aload 4
    //   139: invokeinterface 259 1 0
    //   144: ldc_w 260
    //   147: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_1
    //   151: athrow
    //   152: astore_2
    //   153: goto -41 -> 112
    //   156: aload_2
    //   157: astore_1
    //   158: goto -110 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   41	48	0	bool	boolean
    //   7	103	1	localObject1	Object
    //   136	15	1	localObject2	Object
    //   157	1	1	localObject3	Object
    //   55	38	2	localbb	bb
    //   111	5	2	localException1	Exception
    //   152	5	2	localException2	Exception
    //   9	93	3	localObject4	Object
    //   32	106	4	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   34	42	111	java/lang/Exception
    //   58	64	111	java/lang/Exception
    //   68	78	111	java/lang/Exception
    //   80	88	111	java/lang/Exception
    //   34	42	136	finally
    //   48	56	136	finally
    //   58	64	136	finally
    //   68	78	136	finally
    //   80	88	136	finally
    //   112	126	136	finally
    //   48	56	152	java/lang/Exception
  }
  
  private static SpannableString n(bb parambb)
  {
    AppMethodBeat.i(249829);
    au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(parambb.field_username);
    Object localObject = SpannableString.valueOf(MMApplicationContext.getContext().getString(R.l.gDu));
    if (localau != null)
    {
      parambb = aa.a(localau, parambb.field_username, true);
      if (au.bwO(localau.field_username))
      {
        parambb = ((e)com.tencent.mm.kernel.h.ax(e.class)).e(MMApplicationContext.getContext(), parambb, com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), R.f.NormalTextSize));
        if (parambb.length() > 0) {
          break label161;
        }
        localObject = new SpannableString(MMApplicationContext.getContext().getString(R.l.gDu));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(249829);
      return localObject;
      parambb = p.d(MMApplicationContext.getContext(), parambb, com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), R.f.NormalTextSize));
      break;
      Log.e(TAG, "contact is null !");
      parambb = (bb)localObject;
      break;
      label161:
      localObject = parambb;
      if (parambb.length() > 10) {
        localObject = SpannableString.valueOf(parambb.subSequence(0, 10) + "...");
      }
    }
  }
  
  private static String o(bb parambb)
  {
    AppMethodBeat.i(249839);
    String str = bAr(parambb.field_digest);
    if (str != null)
    {
      parambb = "[" + str + "]";
      AppMethodBeat.o(249839);
      return parambb;
    }
    if ((parambb.field_digest != null) && (parambb.field_digest.contains(":")))
    {
      parambb = bAr(parambb.field_digest.substring(parambb.field_digest.indexOf(":") + 1).replace(" ", ""));
      if (parambb != null)
      {
        parambb = "[" + parambb + "]";
        AppMethodBeat.o(249839);
        return parambb;
      }
    }
    parambb = MMApplicationContext.getContext().getString(R.l.app_emoji);
    AppMethodBeat.o(249839);
    return parambb;
  }
  
  private static String p(bb parambb)
  {
    AppMethodBeat.i(249856);
    String str1 = "";
    if (!Util.isNullOrNil(parambb.field_digest))
    {
      if (Util.isNullOrNil(parambb.field_digestUser)) {
        break label123;
      }
      if ((parambb.field_isSend != 0) || (!au.bwE(parambb.field_username))) {
        break label82;
      }
    }
    label82:
    String str2;
    label123:
    for (str1 = aa.aV(parambb.field_digestUser, parambb.field_username);; str2 = parambb.field_digest) {
      try
      {
        for (;;)
        {
          str1 = String.format(parambb.field_digest, new Object[] { str1 });
          AppMethodBeat.o(249856);
          return str1;
          str1 = aa.getDisplayName(parambb.field_digestUser);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          str2 = com.tencent.mm.booter.notification.a.h.a(parambb.field_isSend, parambb.field_username, parambb.field_content, aip(parambb.field_msgType), MMApplicationContext.getContext());
        }
      }
    }
  }
  
  public final void a(bb parambb, String paramString)
  {
    AppMethodBeat.i(249895);
    au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString);
    String str;
    if (localau != null)
    {
      localau.aRX();
      v.a(paramString, 1, localau);
      a(parambb, false, true);
      str = TAG;
      if (localau == null) {
        break label101;
      }
    }
    label101:
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, "conversation:%s , add to conv box :%s %s", new Object[] { paramString, Boolean.valueOf(bool), parambb.field_parentRef });
      AppMethodBeat.o(249895);
      return;
    }
  }
  
  public final void a(bb parambb, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(249889);
    if ((parambb != null) && (paramBoolean2))
    {
      parambb.BH("conversationboxservice");
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().c(parambb, parambb.field_username);
    }
    bb localbb = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxM("conversationboxservice");
    if (localbb == null)
    {
      Log.i(TAG, "create parentConv");
      localbb = new bb("conversationboxservice");
      localbb.jaJ();
      if (parambb != null) {
        b(localbb, parambb);
      }
      if (parambb != null) {}
      for (parambb = parambb.field_username;; parambb = "")
      {
        b(localbb, parambb, false);
        AppMethodBeat.o(249889);
        return;
      }
    }
    Log.i(TAG, "ConvBox SuperConv is created");
    localbb.BH(null);
    if (parambb != null) {
      b(localbb, parambb);
    }
    if (paramBoolean1)
    {
      if (parambb != null) {}
      for (parambb = parambb.field_username;; parambb = "")
      {
        b(localbb, parambb, true);
        AppMethodBeat.o(249889);
        return;
      }
    }
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().c(localbb, "conversationboxservice");
    AppMethodBeat.o(249889);
  }
  
  public final void b(bb parambb, String paramString)
  {
    AppMethodBeat.i(249902);
    au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString);
    String str;
    if (localau != null)
    {
      localau.aRY();
      v.a(paramString, 0, localau);
      f(parambb);
      str = TAG;
      if ((localau == null) || (!localau.aMt())) {
        break label107;
      }
    }
    label107:
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, "conversation:%s, del from conv box :%s %s", new Object[] { paramString, Boolean.valueOf(bool), parambb.field_parentRef });
      AppMethodBeat.o(249902);
      return;
    }
  }
  
  public final void cJu()
  {
    AppMethodBeat.i(249885);
    bb localbb = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxM("conversationboxservice");
    Object localObject;
    if (localbb != null)
    {
      localObject = jzQ();
      if ((localObject == null) || (TextUtils.isEmpty(((bd)localObject).field_digest)))
      {
        localbb.BF(MMApplicationContext.getContext().getString(R.l.gDp));
        ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().c(localbb, "conversationboxservice");
      }
    }
    else
    {
      AppMethodBeat.o(249885);
      return;
    }
    jzP();
    SpannableString localSpannableString = n((bb)localObject);
    if ((((bd)localObject).field_msgType != null) && ((((bd)localObject).field_msgType.equals("47")) || (((bd)localObject).field_msgType.equals("1048625")))) {
      localObject = o((bb)localObject);
    }
    for (;;)
    {
      localbb.BF(MMApplicationContext.getContext().getString(R.l.gDq, new Object[] { localSpannableString, localObject }));
      break;
      if ((((bd)localObject).field_digest != null) && (((bd)localObject).field_digest.contains(":")))
      {
        localObject = ((bd)localObject).field_digest.substring(((bd)localObject).field_digest.indexOf(":") + 1).replace(" ", "").replace("\n", "");
        localbb.BF(MMApplicationContext.getContext().getString(R.l.gDq, new Object[] { localSpannableString, localObject }));
      }
      else
      {
        localObject = p((bb)localObject);
      }
    }
  }
  
  public final int cJv()
  {
    i = 0;
    j = 0;
    int k = 0;
    AppMethodBeat.i(249887);
    bh.bCz();
    localCursor = c.bzG().a(5, new ArrayList(), "conversationboxservice");
    try
    {
      if (localCursor.moveToFirst())
      {
        j = k;
        boolean bool;
        do
        {
          i = j + 1;
          j = i;
          bool = localCursor.moveToNext();
          j = i;
        } while (bool);
      }
      localCursor.close();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace(TAG, localException, "getConvBoxCount", new Object[0]);
        localCursor.close();
        i = j;
      }
    }
    finally
    {
      localCursor.close();
      AppMethodBeat.o(249887);
    }
    AppMethodBeat.o(249887);
    return i;
  }
  
  public final void f(bb parambb)
  {
    AppMethodBeat.i(249897);
    int i;
    if (parambb != null)
    {
      parambb.BH(null);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().c(parambb, parambb.field_username);
      i = cJv();
      if (i != 0) {
        break label97;
      }
      bh.bCz();
      c.bzG().bxK("conversationboxservice");
    }
    for (;;)
    {
      Log.i(TAG, "updateForChildConversationUnSet childCvs:%s convBoxCnt:%s", new Object[] { parambb.field_username, Integer.valueOf(i) });
      AppMethodBeat.o(249897);
      return;
      label97:
      cJu();
    }
  }
  
  public static abstract interface a
  {
    public abstract void As(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.e.a
 * JD-Core Version:    0.7.0.1
 */