package com.tencent.mm.wear.app.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.mm.wear.a.c.d;
import com.tencent.mm.wear.app.MMApplication;
import com.tencent.mm.wear.app.ui.emoji.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static final boolean abr;
  private static a abs;
  private SparseArray<com.tencent.mm.g.b> abA;
  private SparseArray<com.tencent.mm.g.b> abB;
  private SparseArray<SparseArray<com.tencent.mm.g.b>> abC;
  private SparseArray<String> abD;
  private com.tencent.mm.sdk.platformtools.h<Integer, Bitmap> abE;
  private boolean abF;
  private LinkedList<com.tencent.mm.g.b> abG;
  private int abt;
  private int abu;
  private int abv;
  private int abw;
  private long abx;
  private com.tencent.mm.g.a aby;
  private SparseArray<com.tencent.mm.g.b> abz;
  
  static
  {
    if (Build.VERSION.SDK_INT < 19) {}
    for (boolean bool = true;; bool = false)
    {
      abr = bool;
      return;
    }
  }
  
  /* Error */
  private a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 49	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield 51	com/tencent/mm/wear/app/emoji/a:abt	I
    //   9: aload_0
    //   10: lconst_0
    //   11: putfield 53	com/tencent/mm/wear/app/emoji/a:abx	J
    //   14: aload_0
    //   15: new 55	com/tencent/mm/g/a
    //   18: dup
    //   19: invokespecial 56	com/tencent/mm/g/a:<init>	()V
    //   22: putfield 58	com/tencent/mm/wear/app/emoji/a:aby	Lcom/tencent/mm/g/a;
    //   25: aload_0
    //   26: new 60	android/util/SparseArray
    //   29: dup
    //   30: invokespecial 61	android/util/SparseArray:<init>	()V
    //   33: putfield 63	com/tencent/mm/wear/app/emoji/a:abz	Landroid/util/SparseArray;
    //   36: aload_0
    //   37: new 60	android/util/SparseArray
    //   40: dup
    //   41: invokespecial 61	android/util/SparseArray:<init>	()V
    //   44: putfield 65	com/tencent/mm/wear/app/emoji/a:abA	Landroid/util/SparseArray;
    //   47: aload_0
    //   48: new 60	android/util/SparseArray
    //   51: dup
    //   52: invokespecial 61	android/util/SparseArray:<init>	()V
    //   55: putfield 67	com/tencent/mm/wear/app/emoji/a:abB	Landroid/util/SparseArray;
    //   58: aload_0
    //   59: new 60	android/util/SparseArray
    //   62: dup
    //   63: invokespecial 61	android/util/SparseArray:<init>	()V
    //   66: putfield 69	com/tencent/mm/wear/app/emoji/a:abC	Landroid/util/SparseArray;
    //   69: aload_0
    //   70: aconst_null
    //   71: putfield 71	com/tencent/mm/wear/app/emoji/a:abD	Landroid/util/SparseArray;
    //   74: aload_0
    //   75: new 73	com/tencent/mm/sdk/platformtools/h
    //   78: dup
    //   79: sipush 200
    //   82: invokespecial 76	com/tencent/mm/sdk/platformtools/h:<init>	(I)V
    //   85: putfield 78	com/tencent/mm/wear/app/emoji/a:abE	Lcom/tencent/mm/sdk/platformtools/h;
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 80	com/tencent/mm/wear/app/emoji/a:abF	Z
    //   93: new 82	java/io/DataInputStream
    //   96: dup
    //   97: aload_1
    //   98: invokespecial 84	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   101: astore 5
    //   103: aload 5
    //   105: astore 4
    //   107: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   110: lstore_2
    //   111: aload 5
    //   113: astore 4
    //   115: invokestatic 96	com/tencent/mm/wear/app/MMApplication:getContext	()Landroid/content/Context;
    //   118: astore 6
    //   120: aload 5
    //   122: astore 4
    //   124: aload_0
    //   125: aload 5
    //   127: invokevirtual 100	java/io/DataInputStream:readInt	()I
    //   130: putfield 102	com/tencent/mm/wear/app/emoji/a:abw	I
    //   133: aload 5
    //   135: astore 4
    //   137: aload_0
    //   138: aload 5
    //   140: invokevirtual 105	java/io/DataInputStream:readLong	()J
    //   143: putfield 53	com/tencent/mm/wear/app/emoji/a:abx	J
    //   146: aload 5
    //   148: astore 4
    //   150: aload_0
    //   151: aload 5
    //   153: invokevirtual 100	java/io/DataInputStream:readInt	()I
    //   156: putfield 107	com/tencent/mm/wear/app/emoji/a:abu	I
    //   159: aload 5
    //   161: astore 4
    //   163: aload_0
    //   164: aload_0
    //   165: getfield 107	com/tencent/mm/wear/app/emoji/a:abu	I
    //   168: iconst_4
    //   169: iadd
    //   170: bipush 8
    //   172: iadd
    //   173: iconst_4
    //   174: iadd
    //   175: putfield 109	com/tencent/mm/wear/app/emoji/a:abv	I
    //   178: aload 5
    //   180: astore 4
    //   182: aload_0
    //   183: getfield 107	com/tencent/mm/wear/app/emoji/a:abu	I
    //   186: newarray byte
    //   188: astore 7
    //   190: aload 5
    //   192: astore 4
    //   194: aload 5
    //   196: aload 7
    //   198: invokevirtual 113	java/io/DataInputStream:read	([B)I
    //   201: pop
    //   202: aload 5
    //   204: astore 4
    //   206: aload_0
    //   207: getfield 58	com/tencent/mm/wear/app/emoji/a:aby	Lcom/tencent/mm/g/a;
    //   210: aload 7
    //   212: invokevirtual 117	com/tencent/mm/g/a:h	([B)Lcom/tencent/mm/d/a;
    //   215: pop
    //   216: aload 5
    //   218: astore 4
    //   220: aload_0
    //   221: invokespecial 120	com/tencent/mm/wear/app/emoji/a:my	()V
    //   224: aload 5
    //   226: astore 4
    //   228: aload_0
    //   229: iconst_1
    //   230: putfield 80	com/tencent/mm/wear/app/emoji/a:abF	Z
    //   233: aload 5
    //   235: astore 4
    //   237: aload_0
    //   238: aload 6
    //   240: invokestatic 126	com/tencent/mm/f/a:x	(Landroid/content/Context;)I
    //   243: putfield 51	com/tencent/mm/wear/app/emoji/a:abt	I
    //   246: aload 5
    //   248: astore 4
    //   250: ldc 128
    //   252: ldc 130
    //   254: iconst_2
    //   255: anewarray 4	java/lang/Object
    //   258: dup
    //   259: iconst_0
    //   260: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   263: lload_2
    //   264: lsub
    //   265: invokestatic 136	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   268: aastore
    //   269: dup
    //   270: iconst_1
    //   271: aload_0
    //   272: getfield 102	com/tencent/mm/wear/app/emoji/a:abw	I
    //   275: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: aastore
    //   279: invokestatic 147	com/tencent/mm/wear/a/c/d:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: aload_1
    //   283: invokestatic 151	com/tencent/mm/wear/a/f/c:c	(Ljava/io/InputStream;)V
    //   286: aload 5
    //   288: invokestatic 151	com/tencent/mm/wear/a/f/c:c	(Ljava/io/InputStream;)V
    //   291: return
    //   292: astore 6
    //   294: aconst_null
    //   295: astore 5
    //   297: aload 5
    //   299: astore 4
    //   301: ldc 128
    //   303: aload 6
    //   305: invokestatic 155	com/tencent/mm/wear/a/c/d:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   308: aload 5
    //   310: astore 4
    //   312: aload 6
    //   314: athrow
    //   315: astore 6
    //   317: aload 4
    //   319: astore 5
    //   321: aload 6
    //   323: astore 4
    //   325: aload_1
    //   326: invokestatic 151	com/tencent/mm/wear/a/f/c:c	(Ljava/io/InputStream;)V
    //   329: aload 5
    //   331: invokestatic 151	com/tencent/mm/wear/a/f/c:c	(Ljava/io/InputStream;)V
    //   334: aload 4
    //   336: athrow
    //   337: astore 4
    //   339: aconst_null
    //   340: astore 5
    //   342: goto -17 -> 325
    //   345: astore 6
    //   347: goto -50 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	350	0	this	a
    //   0	350	1	paramInputStream	java.io.InputStream
    //   110	154	2	l	long
    //   105	230	4	localObject1	Object
    //   337	1	4	localObject2	Object
    //   101	240	5	localObject3	Object
    //   118	121	6	localContext	Context
    //   292	21	6	localException1	Exception
    //   315	7	6	localObject4	Object
    //   345	1	6	localException2	Exception
    //   188	23	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   93	103	292	java/lang/Exception
    //   107	111	315	finally
    //   115	120	315	finally
    //   124	133	315	finally
    //   137	146	315	finally
    //   150	159	315	finally
    //   163	178	315	finally
    //   182	190	315	finally
    //   194	202	315	finally
    //   206	216	315	finally
    //   220	224	315	finally
    //   228	233	315	finally
    //   237	246	315	finally
    //   250	282	315	finally
    //   301	308	315	finally
    //   312	315	315	finally
    //   93	103	337	finally
    //   107	111	345	java/lang/Exception
    //   115	120	345	java/lang/Exception
    //   124	133	345	java/lang/Exception
    //   137	146	345	java/lang/Exception
    //   150	159	345	java/lang/Exception
    //   163	178	345	java/lang/Exception
    //   182	190	345	java/lang/Exception
    //   194	202	345	java/lang/Exception
    //   206	216	345	java/lang/Exception
    //   220	224	345	java/lang/Exception
    //   228	233	345	java/lang/Exception
    //   237	246	345	java/lang/Exception
    //   250	282	345	java/lang/Exception
  }
  
  private Drawable a(com.tencent.mm.g.b paramb)
  {
    if (paramb == null) {
      return null;
    }
    try
    {
      Object localObject = (Bitmap)this.abE.get(Integer.valueOf(paramb.Yx));
      if (localObject != null) {
        return new BitmapDrawable(MMApplication.getContext().getResources(), (Bitmap)localObject);
      }
      localObject = com.tencent.mm.wear.a.f.c.e(new File(com.tencent.mm.wear.app.b.h.mh(), "color_emoji_1435827814287").getAbsolutePath(), paramb.Yx + this.abv, paramb.size);
      if (localObject != null)
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length, localOptions);
        if (localObject != null)
        {
          ((Bitmap)localObject).setDensity(240);
          this.abE.put(Integer.valueOf(paramb.Yx), localObject);
          paramb = new BitmapDrawable(MMApplication.getContext().getResources(), (Bitmap)localObject);
          return paramb;
        }
      }
    }
    catch (Exception paramb)
    {
      d.a("MicroMsg.EmojiHelper", paramb);
    }
    return null;
  }
  
  private com.tencent.mm.g.b ag(int paramInt1, int paramInt2)
  {
    Object localObject = this.aby.Yq.iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.g.c localc = (com.tencent.mm.g.c)((Iterator)localObject).next();
      if ((paramInt1 < localc.min) || (paramInt1 > localc.max)) {
        break label123;
      }
      i = 1;
    }
    label123:
    for (;;)
    {
      break;
      if (i == 0) {
        return null;
      }
      localObject = (SparseArray)this.abC.get(paramInt1);
      if (localObject != null)
      {
        if ((((SparseArray)localObject).size() == 1) && (((SparseArray)localObject).get(0) != null)) {
          return (com.tencent.mm.g.b)((SparseArray)localObject).get(0);
        }
        return (com.tencent.mm.g.b)((SparseArray)localObject).get(paramInt2);
      }
      return null;
    }
  }
  
  public static a mw()
  {
    return abs;
  }
  
  public static boolean mx()
  {
    if (abs != null)
    {
      d.c("MicroMsg.EmojiHelper", "Init EmojiHelper Success", new Object[0]);
      return true;
    }
    File localFile = new File(com.tencent.mm.wear.app.b.h.mh(), "color_emoji_1435827814287");
    if (localFile.exists()) {
      try
      {
        localFileInputStream = new FileInputStream(localFile);
        if (localFileInputStream == null) {}
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          try
          {
            FileInputStream localFileInputStream;
            abs = new a(localFileInputStream);
            d.c("MicroMsg.EmojiHelper", "Init EmojiHelper Success", new Object[0]);
            return true;
          }
          catch (Exception localException)
          {
            Object localObject;
            d.b("MicroMsg.EmojiHelper", localException, "init emoji error", new Object[0]);
            localFile.delete();
            return false;
          }
          localFileNotFoundException = localFileNotFoundException;
          localObject = null;
        }
      }
    }
    return false;
  }
  
  private void my()
  {
    this.abG = new LinkedList(this.aby.Yr);
    if ((this.abG == null) || (this.abG.isEmpty())) {
      d.c("MicroMsg.EmojiHelper", "initIndex failed. items is empty.", new Object[0]);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.abG.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.g.b localb = (com.tencent.mm.g.b)localIterator.next();
        if (localb.Ys != 0)
        {
          SparseArray localSparseArray2 = (SparseArray)this.abC.get(localb.Ys);
          SparseArray localSparseArray1 = localSparseArray2;
          if (localSparseArray2 == null)
          {
            localSparseArray1 = new SparseArray();
            this.abC.append(localb.Ys, localSparseArray1);
          }
          localSparseArray1.put(localb.Yt, localb);
          if (localb.Yu != 0) {
            this.abz.append(localb.Yu, localb);
          }
          if (localb.Yv != -1) {
            this.abA.append(localb.Yv, localb);
          }
        }
        else
        {
          this.abB.append(localb.Yw, localb);
        }
      }
    }
  }
  
  public static String mz()
  {
    return "color_emoji_1435827814287";
  }
  
  public final SpannableString a(SpannableString paramSpannableString, int paramInt)
  {
    if ((paramSpannableString == null) || (paramSpannableString.length() == 0)) {
      return paramSpannableString;
    }
    Object localObject2 = paramSpannableString.toString();
    Object localObject1 = new ArrayList();
    int j = 0;
    int n = ((String)localObject2).length();
    int k;
    int m;
    Object localObject3;
    if (j < n)
    {
      i = ((String)localObject2).codePointAt(j);
      k = j + Character.charCount(i);
      if (k >= n) {
        break label246;
      }
      m = ((String)localObject2).codePointAt(k);
      localObject3 = abs.bI(i);
      if (localObject3 == null) {
        break label252;
      }
      ((ArrayList)localObject1).add(new b(this, (com.tencent.mm.g.b)localObject3, j, j + 1, true));
      i = k;
    }
    label160:
    label246:
    for (;;)
    {
      label118:
      if (((ArrayList)localObject1).size() > 300)
      {
        if (((ArrayList)localObject1).size() == 0) {
          break;
        }
        if (abr)
        {
          paramSpannableString = new StringBuilder((String)localObject2);
          localObject2 = ((ArrayList)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (b)((Iterator)localObject2).next();
              if (!((b)localObject3).abI) {
                if ((((b)localObject3).abH.Yu != 0) && (((b)localObject3).end - ((b)localObject3).start == 1))
                {
                  paramSpannableString.replace(((b)localObject3).start, ((b)localObject3).end, String.valueOf((char)((b)localObject3).abH.Yu));
                  continue;
                  m = 0;
                  break;
                  label252:
                  localObject3 = abs.ag(i, m);
                  i = k;
                  if (localObject3 == null) {
                    break label118;
                  }
                  if ((((com.tencent.mm.g.b)localObject3).Yt == 0) && ((127995 > m) || (m > 127999))) {
                    break label445;
                  }
                }
              }
            }
          }
        }
      }
    }
    label445:
    for (int i = k + Character.charCount(m);; i = k)
    {
      ((ArrayList)localObject1).add(new b(this, (com.tencent.mm.g.b)localObject3, j, i, false));
      break label118;
      paramSpannableString.replace(((b)localObject3).start, ((b)localObject3).end, "....".substring(0, ((b)localObject3).end - ((b)localObject3).start));
      break label160;
      paramSpannableString = new SpannableString(paramSpannableString.toString());
      for (;;)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (b)((Iterator)localObject1).next();
          a(paramSpannableString, abs.a(((b)localObject2).abH), ((b)localObject2).start, ((b)localObject2).end, paramInt);
        }
        return paramSpannableString;
      }
      j = i;
      break;
    }
  }
  
  public final void a(Spannable paramSpannable, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = (int)(paramInt3 * 1.3F);
    paramInt3 = (int)(paramInt3 * 1.3F);
    try
    {
      paramDrawable.setBounds(0, 0, i, paramInt3);
      paramDrawable = new g(paramDrawable);
      paramDrawable.bY(this.abt);
      paramSpannable.setSpan(paramDrawable, paramInt1, paramInt2, 33);
      return;
    }
    catch (Exception paramSpannable)
    {
      d.a("MicroMsg.EmojiHelper", paramSpannable);
    }
  }
  
  public final com.tencent.mm.g.b bI(int paramInt)
  {
    if ((paramInt >= 57345) && (paramInt <= 58679)) {
      return (com.tencent.mm.g.b)this.abz.get(paramInt);
    }
    return null;
  }
  
  public final Drawable bJ(int paramInt)
  {
    return a((com.tencent.mm.g.b)this.abB.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.emoji.a
 * JD-Core Version:    0.7.0.1
 */