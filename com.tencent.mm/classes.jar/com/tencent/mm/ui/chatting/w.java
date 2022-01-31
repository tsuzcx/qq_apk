package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class w
  implements j
{
  private Context context;
  private ad dnp;
  private String vjK;
  private boolean vlK = true;
  private boolean vlL = true;
  
  public w(Context paramContext, ad paramad, String paramString)
  {
    this.context = paramContext;
    this.dnp = paramad;
    this.vjK = paramString;
    if (ad.hd(this.vjK)) {
      this.vlL = false;
    }
    if (ad.aaT(this.vjK)) {
      this.vlK = false;
    }
    if (ad.aaR(this.vjK)) {
      this.vlK = false;
    }
    if ((this.dnp != null) && (ad.hd(this.dnp.field_username))) {
      paramContext = this.vjK;
    }
    for (;;)
    {
      if (com.tencent.mm.model.s.hf(paramContext)) {
        this.vlL = false;
      }
      return;
      if (this.dnp == null) {
        paramContext = null;
      } else {
        paramContext = this.dnp.field_username;
      }
    }
  }
  
  public final boolean bhC()
  {
    return this.vlL;
  }
  
  public final boolean bhD()
  {
    return this.vlK;
  }
  
  public final void bhE() {}
  
  public final void m(EmojiInfo paramEmojiInfo)
  {
    au.Hx();
    if (!c.isSDCardAvailable()) {
      com.tencent.mm.ui.base.s.gM(this.context);
    }
    while (paramEmojiInfo == null) {
      return;
    }
    if ((this.dnp.field_username.equals("medianote")) && ((q.Gn() & 0x4000) == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramEmojiInfo.field_start = 0;
      paramEmojiInfo.field_state = EmojiInfo.uDh;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().d(paramEmojiInfo);
      localObject = new bi();
      ((bi)localObject).setType(47);
      ((bi)localObject).ec("medianote");
      ((bi)localObject).fA(1);
      if (paramEmojiInfo.ZH()) {
        ((bi)localObject).setContent(ap.a(q.Gj(), 0L, false, paramEmojiInfo.Wv(), false, ""));
      }
      ((bi)localObject).ed(paramEmojiInfo.Wv());
      ((bi)localObject).bg(bd.iK(((cs)localObject).field_talker));
      ((bi)localObject).setStatus(2);
      au.Hx();
      c.Fy().T((bi)localObject);
      return;
    }
    com.tencent.mm.pluginsdk.a.d locald = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
    if (bk.bl(this.vjK)) {}
    for (Object localObject = this.dnp.field_username;; localObject = this.vjK)
    {
      locald.a((String)localObject, paramEmojiInfo, null);
      return;
    }
  }
  
  /* Error */
  public final void n(EmojiInfo paramEmojiInfo)
  {
    // Byte code:
    //   0: invokestatic 65	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   3: pop
    //   4: invokestatic 70	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   7: ifne +11 -> 18
    //   10: aload_0
    //   11: getfield 26	com/tencent/mm/ui/chatting/w:context	Landroid/content/Context;
    //   14: invokestatic 76	com/tencent/mm/ui/base/s:gM	(Landroid/content/Context;)V
    //   17: return
    //   18: new 198	com/tencent/mm/opensdk/modelmsg/WXMediaMessage
    //   21: dup
    //   22: invokespecial 199	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:<init>	()V
    //   25: astore 6
    //   27: new 201	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   34: astore_3
    //   35: invokestatic 65	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   38: pop
    //   39: aload_3
    //   40: invokestatic 205	com/tencent/mm/model/c:FL	()Ljava/lang/String;
    //   43: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_1
    //   47: invokevirtual 143	com/tencent/mm/storage/emotion/EmojiInfo:Wv	()Ljava/lang/String;
    //   50: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore 7
    //   58: new 201	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   65: aload 7
    //   67: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 214
    //   72: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 219	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   81: ifeq +93 -> 174
    //   84: new 201	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   91: aload 7
    //   93: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 214
    //   98: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 222	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   107: l2i
    //   108: istore_2
    //   109: aload 6
    //   111: new 201	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   118: aload 7
    //   120: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc 214
    //   125: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: iconst_0
    //   132: iload_2
    //   133: invokestatic 226	com/tencent/mm/vfs/e:c	(Ljava/lang/String;II)[B
    //   136: putfield 230	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:thumbData	[B
    //   139: aload 6
    //   141: new 232	com/tencent/mm/opensdk/modelmsg/WXEmojiObject
    //   144: dup
    //   145: aload 7
    //   147: invokespecial 234	com/tencent/mm/opensdk/modelmsg/WXEmojiObject:<init>	(Ljava/lang/String;)V
    //   150: putfield 238	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:mediaObject	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage$IMediaObject;
    //   153: aload 6
    //   155: aload_1
    //   156: getfield 241	com/tencent/mm/storage/emotion/EmojiInfo:field_app_id	Ljava/lang/String;
    //   159: aconst_null
    //   160: aload_0
    //   161: getfield 30	com/tencent/mm/ui/chatting/w:vjK	Ljava/lang/String;
    //   164: iconst_1
    //   165: aload_1
    //   166: invokevirtual 143	com/tencent/mm/storage/emotion/EmojiInfo:Wv	()Ljava/lang/String;
    //   169: invokestatic 246	com/tencent/mm/pluginsdk/model/app/l:a	(Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)I
    //   172: pop
    //   173: return
    //   174: aload 7
    //   176: invokestatic 250	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   179: astore 4
    //   181: aload 4
    //   183: astore_3
    //   184: aload 6
    //   186: aload 4
    //   188: fconst_1
    //   189: invokestatic 255	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$b:a	(Ljava/io/InputStream;F)Landroid/graphics/Bitmap;
    //   192: invokevirtual 259	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:setThumbImage	(Landroid/graphics/Bitmap;)V
    //   195: aload 4
    //   197: invokestatic 263	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   200: goto -61 -> 139
    //   203: astore 5
    //   205: aconst_null
    //   206: astore 4
    //   208: aload 4
    //   210: astore_3
    //   211: ldc_w 265
    //   214: aload 5
    //   216: ldc 145
    //   218: iconst_0
    //   219: anewarray 4	java/lang/Object
    //   222: invokestatic 271	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: aload 4
    //   227: astore_3
    //   228: ldc_w 265
    //   231: ldc_w 273
    //   234: invokestatic 277	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload 4
    //   239: invokestatic 263	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   242: goto -103 -> 139
    //   245: astore_1
    //   246: aconst_null
    //   247: astore_3
    //   248: aload_3
    //   249: invokestatic 263	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   252: aload_1
    //   253: athrow
    //   254: astore_1
    //   255: goto -7 -> 248
    //   258: astore 5
    //   260: goto -52 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	w
    //   0	263	1	paramEmojiInfo	EmojiInfo
    //   108	25	2	i	int
    //   34	215	3	localObject	Object
    //   179	59	4	localInputStream	java.io.InputStream
    //   203	12	5	localException1	java.lang.Exception
    //   258	1	5	localException2	java.lang.Exception
    //   25	160	6	localWXMediaMessage	com.tencent.mm.opensdk.modelmsg.WXMediaMessage
    //   56	119	7	str	String
    // Exception table:
    //   from	to	target	type
    //   174	181	203	java/lang/Exception
    //   174	181	245	finally
    //   184	195	254	finally
    //   211	225	254	finally
    //   228	237	254	finally
    //   184	195	258	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.w
 * JD-Core Version:    0.7.0.1
 */