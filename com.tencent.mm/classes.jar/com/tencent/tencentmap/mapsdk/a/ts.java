package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

final class ts
  extends LinearLayout
{
  private TextView a;
  private TextView b;
  private Context c;
  
  /* Error */
  public ts(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_1
    //   5: invokespecial 16	android/widget/LinearLayout:<init>	(Landroid/content/Context;)V
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 22	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   13: putfield 24	com/tencent/tencentmap/mapsdk/a/ts:c	Landroid/content/Context;
    //   16: aload_0
    //   17: iconst_1
    //   18: invokevirtual 28	com/tencent/tencentmap/mapsdk/a/ts:setOrientation	(I)V
    //   21: aload_2
    //   22: ifnull +47 -> 69
    //   25: aload_2
    //   26: invokevirtual 34	java/lang/String:isEmpty	()Z
    //   29: ifne +40 -> 69
    //   32: aload_0
    //   33: new 36	android/widget/TextView
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 37	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   41: putfield 39	com/tencent/tencentmap/mapsdk/a/ts:a	Landroid/widget/TextView;
    //   44: aload_0
    //   45: getfield 39	com/tencent/tencentmap/mapsdk/a/ts:a	Landroid/widget/TextView;
    //   48: aload_2
    //   49: invokevirtual 43	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   52: aload_0
    //   53: getfield 39	com/tencent/tencentmap/mapsdk/a/ts:a	Landroid/widget/TextView;
    //   56: ldc 44
    //   58: invokevirtual 47	android/widget/TextView:setTextColor	(I)V
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 39	com/tencent/tencentmap/mapsdk/a/ts:a	Landroid/widget/TextView;
    //   66: invokevirtual 51	com/tencent/tencentmap/mapsdk/a/ts:addView	(Landroid/view/View;)V
    //   69: aload_3
    //   70: ifnull +47 -> 117
    //   73: aload_3
    //   74: invokevirtual 34	java/lang/String:isEmpty	()Z
    //   77: ifne +40 -> 117
    //   80: aload_0
    //   81: new 36	android/widget/TextView
    //   84: dup
    //   85: aload_1
    //   86: invokespecial 37	android/widget/TextView:<init>	(Landroid/content/Context;)V
    //   89: putfield 53	com/tencent/tencentmap/mapsdk/a/ts:b	Landroid/widget/TextView;
    //   92: aload_0
    //   93: getfield 53	com/tencent/tencentmap/mapsdk/a/ts:b	Landroid/widget/TextView;
    //   96: ldc 44
    //   98: invokevirtual 47	android/widget/TextView:setTextColor	(I)V
    //   101: aload_0
    //   102: getfield 53	com/tencent/tencentmap/mapsdk/a/ts:b	Landroid/widget/TextView;
    //   105: aload_3
    //   106: invokevirtual 43	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 53	com/tencent/tencentmap/mapsdk/a/ts:b	Landroid/widget/TextView;
    //   114: invokevirtual 51	com/tencent/tencentmap/mapsdk/a/ts:addView	(Landroid/view/View;)V
    //   117: aload_0
    //   118: getfield 24	com/tencent/tencentmap/mapsdk/a/ts:c	Landroid/content/Context;
    //   121: invokevirtual 57	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   124: ldc 59
    //   126: invokevirtual 65	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   129: astore_1
    //   130: aload_1
    //   131: invokestatic 71	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   134: astore_2
    //   135: aload_2
    //   136: invokevirtual 77	android/graphics/Bitmap:getNinePatchChunk	()[B
    //   139: astore_3
    //   140: new 79	android/graphics/Rect
    //   143: dup
    //   144: invokespecial 82	android/graphics/Rect:<init>	()V
    //   147: astore 4
    //   149: aload 4
    //   151: aload_3
    //   152: bipush 12
    //   154: invokestatic 87	com/tencent/tencentmap/mapsdk/a/sx:a	([BI)I
    //   157: putfield 91	android/graphics/Rect:left	I
    //   160: aload 4
    //   162: aload_3
    //   163: bipush 16
    //   165: invokestatic 87	com/tencent/tencentmap/mapsdk/a/sx:a	([BI)I
    //   168: putfield 94	android/graphics/Rect:right	I
    //   171: aload 4
    //   173: aload_3
    //   174: bipush 20
    //   176: invokestatic 87	com/tencent/tencentmap/mapsdk/a/sx:a	([BI)I
    //   179: putfield 97	android/graphics/Rect:top	I
    //   182: aload 4
    //   184: aload_3
    //   185: bipush 24
    //   187: invokestatic 87	com/tencent/tencentmap/mapsdk/a/sx:a	([BI)I
    //   190: putfield 100	android/graphics/Rect:bottom	I
    //   193: aload_0
    //   194: new 102	android/graphics/drawable/NinePatchDrawable
    //   197: dup
    //   198: aload_0
    //   199: getfield 24	com/tencent/tencentmap/mapsdk/a/ts:c	Landroid/content/Context;
    //   202: invokevirtual 106	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   205: aload_2
    //   206: aload_3
    //   207: aload 4
    //   209: aconst_null
    //   210: invokespecial 109	android/graphics/drawable/NinePatchDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;[BLandroid/graphics/Rect;Ljava/lang/String;)V
    //   213: invokevirtual 113	com/tencent/tencentmap/mapsdk/a/ts:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   216: aload_1
    //   217: invokestatic 116	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   220: return
    //   221: astore_1
    //   222: aload 4
    //   224: astore_1
    //   225: aload_1
    //   226: invokestatic 116	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   229: return
    //   230: astore_2
    //   231: aconst_null
    //   232: astore_1
    //   233: aload_1
    //   234: invokestatic 116	com/tencent/tencentmap/mapsdk/a/sx:a	(Ljava/io/Closeable;)V
    //   237: aload_2
    //   238: athrow
    //   239: astore_2
    //   240: goto -7 -> 233
    //   243: astore_2
    //   244: goto -19 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	ts
    //   0	247	1	paramContext	Context
    //   0	247	2	paramString1	String
    //   0	247	3	paramString2	String
    //   1	222	4	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   117	130	221	java/lang/Exception
    //   117	130	230	finally
    //   130	216	239	finally
    //   130	216	243	java/lang/Exception
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      if (this.a == null)
      {
        this.a = new TextView(this.c);
        this.a.setText(paramString1);
        this.a.setTextColor(-16777216);
        addView(this.a);
      }
      this.a.setText(paramString1);
    }
    do
    {
      while ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        if (this.b == null)
        {
          this.b = new TextView(this.c);
          this.b.setTextColor(-16777216);
          this.b.setText(paramString2);
          addView(this.b);
        }
        this.b.setText(paramString2);
        return;
        if (this.a != null)
        {
          removeView(this.a);
          this.a = null;
        }
      }
    } while (this.b == null);
    removeView(this.b);
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ts
 * JD-Core Version:    0.7.0.1
 */