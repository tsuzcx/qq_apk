package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.e.a;

public final class w
  implements j
{
  private String JVG;
  private boolean JXT;
  private boolean JXU;
  private a Jyf;
  private an contact;
  
  public w(a parama, an paraman, String paramString)
  {
    AppMethodBeat.i(34684);
    this.JXT = true;
    this.JXU = true;
    this.Jyf = parama;
    this.contact = paraman;
    this.JVG = paramString;
    if (an.Ac(this.JVG)) {
      this.JXU = false;
    }
    if (an.aUp(this.JVG)) {
      this.JXT = false;
    }
    if (an.aUn(this.JVG)) {
      this.JXT = false;
    }
    if ((this.contact != null) && (an.Ac(this.contact.field_username))) {
      parama = this.JVG;
    }
    for (;;)
    {
      if (x.Ae(parama)) {
        this.JXU = false;
      }
      AppMethodBeat.o(34684);
      return;
      if (this.contact == null) {
        parama = null;
      } else {
        parama = this.contact.field_username;
      }
    }
  }
  
  public final void A(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(34685);
    bc.aCg();
    if (!c.isSDCardAvailable())
    {
      t.g(this.Jyf.Kkd.getContext(), this.Jyf.Kkd.getContentView());
      AppMethodBeat.o(34685);
      return;
    }
    if (paramEmojiInfo == null)
    {
      AppMethodBeat.o(34685);
      return;
    }
    if ((this.contact.field_username.equals("medianote")) && ((v.aAG() & 0x4000) == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramEmojiInfo.field_start = 0;
      paramEmojiInfo.field_state = EmojiInfo.OAi;
      ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(paramEmojiInfo);
      localObject = new bv();
      ((bv)localObject).setType(47);
      ((bv)localObject).ui("medianote");
      ((bv)localObject).kt(1);
      if (paramEmojiInfo.Ee()) {
        ((bv)localObject).setContent(az.a(v.aAC(), 0L, false, paramEmojiInfo.Lj(), false, ""));
      }
      ((bv)localObject).uj(paramEmojiInfo.Lj());
      ((bv)localObject).qN(bl.BQ(((ei)localObject).field_talker));
      ((bv)localObject).setStatus(2);
      bc.aCg();
      c.azI().ar((bv)localObject);
      AppMethodBeat.o(34685);
      return;
    }
    com.tencent.mm.pluginsdk.a.d locald = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
    if (bu.isNullOrNil(this.JVG)) {}
    for (Object localObject = this.contact.field_username;; localObject = this.JVG)
    {
      locald.a((String)localObject, paramEmojiInfo, null);
      this.Jyf.xY(true);
      AppMethodBeat.o(34685);
      return;
    }
  }
  
  /* Error */
  public final void M(EmojiInfo paramEmojiInfo)
  {
    // Byte code:
    //   0: ldc 226
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 72	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
    //   8: pop
    //   9: invokestatic 78	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   12: ifne +32 -> 44
    //   15: aload_0
    //   16: getfield 33	com/tencent/mm/ui/chatting/w:Jyf	Lcom/tencent/mm/ui/chatting/e/a;
    //   19: getfield 84	com/tencent/mm/ui/chatting/e/a:Kkd	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   22: invokevirtual 90	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   25: aload_0
    //   26: getfield 33	com/tencent/mm/ui/chatting/w:Jyf	Lcom/tencent/mm/ui/chatting/e/a;
    //   29: getfield 84	com/tencent/mm/ui/chatting/e/a:Kkd	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   32: invokevirtual 96	com/tencent/mm/ui/MMFragment:getContentView	()Landroid/view/View;
    //   35: invokestatic 102	com/tencent/mm/ui/base/t:g	(Landroid/content/Context;Landroid/view/View;)V
    //   38: ldc 226
    //   40: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: return
    //   44: aload_1
    //   45: ifnonnull +9 -> 54
    //   48: ldc 226
    //   50: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: return
    //   54: new 228	com/tencent/mm/opensdk/modelmsg/WXMediaMessage
    //   57: dup
    //   58: invokespecial 229	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:<init>	()V
    //   61: astore 6
    //   63: new 231	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   70: astore_3
    //   71: invokestatic 72	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
    //   74: pop
    //   75: aload_3
    //   76: invokestatic 235	com/tencent/mm/model/c:azV	()Ljava/lang/String;
    //   79: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: invokevirtual 168	com/tencent/mm/storage/emotion/EmojiInfo:Lj	()Ljava/lang/String;
    //   86: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore 7
    //   94: new 231	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   101: aload 7
    //   103: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 244
    //   108: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 249	com/tencent/mm/vfs/o:fB	(Ljava/lang/String;)Z
    //   117: ifeq +98 -> 215
    //   120: new 231	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   127: aload 7
    //   129: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 244
    //   134: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 252	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   143: l2i
    //   144: istore_2
    //   145: aload 6
    //   147: new 231	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 232	java/lang/StringBuilder:<init>	()V
    //   154: aload 7
    //   156: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc 244
    //   161: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 242	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: iconst_0
    //   168: iload_2
    //   169: invokestatic 256	com/tencent/mm/vfs/o:bb	(Ljava/lang/String;II)[B
    //   172: putfield 260	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:thumbData	[B
    //   175: aload 6
    //   177: new 262	com/tencent/mm/opensdk/modelmsg/WXEmojiObject
    //   180: dup
    //   181: aload 7
    //   183: invokespecial 264	com/tencent/mm/opensdk/modelmsg/WXEmojiObject:<init>	(Ljava/lang/String;)V
    //   186: putfield 268	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:mediaObject	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage$IMediaObject;
    //   189: aload 6
    //   191: aload_1
    //   192: getfield 271	com/tencent/mm/storage/emotion/EmojiInfo:field_app_id	Ljava/lang/String;
    //   195: aconst_null
    //   196: aload_0
    //   197: getfield 37	com/tencent/mm/ui/chatting/w:JVG	Ljava/lang/String;
    //   200: iconst_1
    //   201: aload_1
    //   202: invokevirtual 168	com/tencent/mm/storage/emotion/EmojiInfo:Lj	()Ljava/lang/String;
    //   205: invokestatic 276	com/tencent/mm/pluginsdk/model/app/m:a	(Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)I
    //   208: pop
    //   209: ldc 226
    //   211: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: return
    //   215: aload 7
    //   217: invokestatic 280	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   220: astore 4
    //   222: aload 4
    //   224: astore_3
    //   225: aload 6
    //   227: aload 4
    //   229: fconst_1
    //   230: invokestatic 286	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$b:b	(Ljava/io/InputStream;F)Landroid/graphics/Bitmap;
    //   233: invokevirtual 290	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:setThumbImage	(Landroid/graphics/Bitmap;)V
    //   236: aload 4
    //   238: invokestatic 294	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   241: goto -66 -> 175
    //   244: astore 5
    //   246: aconst_null
    //   247: astore 4
    //   249: aload 4
    //   251: astore_3
    //   252: ldc_w 296
    //   255: aload 5
    //   257: ldc 170
    //   259: iconst_0
    //   260: anewarray 4	java/lang/Object
    //   263: invokestatic 302	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: aload 4
    //   268: astore_3
    //   269: ldc_w 296
    //   272: ldc_w 304
    //   275: invokestatic 308	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: aload 4
    //   280: invokestatic 294	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   283: goto -108 -> 175
    //   286: astore_1
    //   287: aconst_null
    //   288: astore_3
    //   289: aload_3
    //   290: invokestatic 294	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   293: ldc 226
    //   295: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: aload_1
    //   299: athrow
    //   300: astore_1
    //   301: goto -12 -> 289
    //   304: astore 5
    //   306: goto -57 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	w
    //   0	309	1	paramEmojiInfo	EmojiInfo
    //   144	25	2	i	int
    //   70	220	3	localObject	Object
    //   220	59	4	localInputStream	java.io.InputStream
    //   244	12	5	localException1	java.lang.Exception
    //   304	1	5	localException2	java.lang.Exception
    //   61	165	6	localWXMediaMessage	com.tencent.mm.opensdk.modelmsg.WXMediaMessage
    //   92	124	7	str	String
    // Exception table:
    //   from	to	target	type
    //   215	222	244	java/lang/Exception
    //   215	222	286	finally
    //   225	236	300	finally
    //   252	266	300	finally
    //   269	278	300	finally
    //   225	236	304	java/lang/Exception
  }
  
  public final void ddB() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.w
 * JD-Core Version:    0.7.0.1
 */