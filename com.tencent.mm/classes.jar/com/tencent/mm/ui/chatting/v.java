package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class v
  implements j
{
  private ad contact;
  private Context context;
  private boolean zBj;
  private boolean zBk;
  private String zyJ;
  
  public v(Context paramContext, ad paramad, String paramString)
  {
    AppMethodBeat.i(30811);
    this.zBj = true;
    this.zBk = true;
    this.context = paramContext;
    this.contact = paramad;
    this.zyJ = paramString;
    if (ad.nM(this.zyJ)) {
      this.zBk = false;
    }
    if (ad.are(this.zyJ)) {
      this.zBj = false;
    }
    if (ad.arc(this.zyJ)) {
      this.zBj = false;
    }
    if ((this.contact != null) && (ad.nM(this.contact.field_username))) {
      paramContext = this.zyJ;
    }
    for (;;)
    {
      if (com.tencent.mm.model.t.nO(paramContext)) {
        this.zBk = false;
      }
      AppMethodBeat.o(30811);
      return;
      if (this.contact == null) {
        paramContext = null;
      } else {
        paramContext = this.contact.field_username;
      }
    }
  }
  
  public final void B(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(30812);
    aw.aaz();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.ii(this.context);
      AppMethodBeat.o(30812);
      return;
    }
    if (paramEmojiInfo == null)
    {
      AppMethodBeat.o(30812);
      return;
    }
    if ((this.contact.field_username.equals("medianote")) && ((r.Zr() & 0x4000) == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramEmojiInfo.field_start = 0;
      paramEmojiInfo.field_state = EmojiInfo.yPu;
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(paramEmojiInfo);
      localObject = new bi();
      ((bi)localObject).setType(47);
      ((bi)localObject).kj("medianote");
      ((bi)localObject).hL(1);
      if (paramEmojiInfo.vY()) {
        ((bi)localObject).setContent(ap.a(r.Zn(), 0L, false, paramEmojiInfo.Al(), false, ""));
      }
      ((bi)localObject).kk(paramEmojiInfo.Al());
      ((bi)localObject).fQ(bf.py(((dd)localObject).field_talker));
      ((bi)localObject).setStatus(2);
      aw.aaz();
      c.YC().Z((bi)localObject);
      AppMethodBeat.o(30812);
      return;
    }
    com.tencent.mm.pluginsdk.a.d locald = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
    if (bo.isNullOrNil(this.zyJ)) {}
    for (Object localObject = this.contact.field_username;; localObject = this.zyJ)
    {
      locald.a((String)localObject, paramEmojiInfo, null);
      AppMethodBeat.o(30812);
      return;
    }
  }
  
  /* Error */
  public final void C(EmojiInfo paramEmojiInfo)
  {
    // Byte code:
    //   0: sipush 30813
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 70	com/tencent/mm/model/aw:aaz	()Lcom/tencent/mm/model/c;
    //   9: pop
    //   10: invokestatic 76	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   13: ifne +17 -> 30
    //   16: aload_0
    //   17: getfield 32	com/tencent/mm/ui/chatting/v:context	Landroid/content/Context;
    //   20: invokestatic 82	com/tencent/mm/ui/base/t:ii	(Landroid/content/Context;)V
    //   23: sipush 30813
    //   26: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: return
    //   30: aload_1
    //   31: ifnonnull +10 -> 41
    //   34: sipush 30813
    //   37: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: return
    //   41: new 202	com/tencent/mm/opensdk/modelmsg/WXMediaMessage
    //   44: dup
    //   45: invokespecial 203	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:<init>	()V
    //   48: astore 6
    //   50: new 205	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   57: astore_3
    //   58: invokestatic 70	com/tencent/mm/model/aw:aaz	()Lcom/tencent/mm/model/c;
    //   61: pop
    //   62: aload_3
    //   63: invokestatic 209	com/tencent/mm/model/c:YP	()Ljava/lang/String;
    //   66: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_1
    //   70: invokevirtual 148	com/tencent/mm/storage/emotion/EmojiInfo:Al	()Ljava/lang/String;
    //   73: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore 7
    //   81: new 205	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   88: aload 7
    //   90: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc 218
    //   95: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 223	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   104: ifeq +99 -> 203
    //   107: new 205	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   114: aload 7
    //   116: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc 218
    //   121: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 226	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   130: l2i
    //   131: istore_2
    //   132: aload 6
    //   134: new 205	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   141: aload 7
    //   143: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc 218
    //   148: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: iconst_0
    //   155: iload_2
    //   156: invokestatic 229	com/tencent/mm/vfs/e:i	(Ljava/lang/String;II)[B
    //   159: putfield 233	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:thumbData	[B
    //   162: aload 6
    //   164: new 235	com/tencent/mm/opensdk/modelmsg/WXEmojiObject
    //   167: dup
    //   168: aload 7
    //   170: invokespecial 237	com/tencent/mm/opensdk/modelmsg/WXEmojiObject:<init>	(Ljava/lang/String;)V
    //   173: putfield 241	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:mediaObject	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage$IMediaObject;
    //   176: aload 6
    //   178: aload_1
    //   179: getfield 244	com/tencent/mm/storage/emotion/EmojiInfo:field_app_id	Ljava/lang/String;
    //   182: aconst_null
    //   183: aload_0
    //   184: getfield 36	com/tencent/mm/ui/chatting/v:zyJ	Ljava/lang/String;
    //   187: iconst_1
    //   188: aload_1
    //   189: invokevirtual 148	com/tencent/mm/storage/emotion/EmojiInfo:Al	()Ljava/lang/String;
    //   192: invokestatic 249	com/tencent/mm/pluginsdk/model/app/l:a	(Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)I
    //   195: pop
    //   196: sipush 30813
    //   199: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: return
    //   203: aload 7
    //   205: invokestatic 253	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   208: astore 4
    //   210: aload 4
    //   212: astore_3
    //   213: aload 6
    //   215: aload 4
    //   217: fconst_1
    //   218: invokestatic 259	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$b:b	(Ljava/io/InputStream;F)Landroid/graphics/Bitmap;
    //   221: invokevirtual 263	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:setThumbImage	(Landroid/graphics/Bitmap;)V
    //   224: aload 4
    //   226: invokestatic 266	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   229: goto -67 -> 162
    //   232: astore 5
    //   234: aconst_null
    //   235: astore 4
    //   237: aload 4
    //   239: astore_3
    //   240: ldc_w 268
    //   243: aload 5
    //   245: ldc 150
    //   247: iconst_0
    //   248: anewarray 4	java/lang/Object
    //   251: invokestatic 274	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   254: aload 4
    //   256: astore_3
    //   257: ldc_w 268
    //   260: ldc_w 276
    //   263: invokestatic 280	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload 4
    //   268: invokestatic 266	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   271: goto -109 -> 162
    //   274: astore_1
    //   275: aconst_null
    //   276: astore_3
    //   277: aload_3
    //   278: invokestatic 266	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   281: sipush 30813
    //   284: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   287: aload_1
    //   288: athrow
    //   289: astore_1
    //   290: goto -13 -> 277
    //   293: astore 5
    //   295: goto -58 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	v
    //   0	298	1	paramEmojiInfo	EmojiInfo
    //   131	25	2	i	int
    //   57	221	3	localObject	Object
    //   208	59	4	localInputStream	java.io.InputStream
    //   232	12	5	localException1	java.lang.Exception
    //   293	1	5	localException2	java.lang.Exception
    //   48	166	6	localWXMediaMessage	com.tencent.mm.opensdk.modelmsg.WXMediaMessage
    //   79	125	7	str	String
    // Exception table:
    //   from	to	target	type
    //   203	210	232	java/lang/Exception
    //   203	210	274	finally
    //   213	224	289	finally
    //   240	254	289	finally
    //   257	266	289	finally
    //   213	224	293	java/lang/Exception
  }
  
  public final boolean bPD()
  {
    return this.zBk;
  }
  
  public final boolean bPE()
  {
    return this.zBj;
  }
  
  public final void bPF() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.v
 * JD-Core Version:    0.7.0.1
 */