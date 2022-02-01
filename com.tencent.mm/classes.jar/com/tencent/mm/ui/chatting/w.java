package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ad;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.e.a;

public final class w
  implements j
{
  private a OIz;
  private String PgT;
  private boolean Pjh;
  private boolean Pji;
  private int Pjj;
  private as contact;
  
  public w(a parama, as paramas, String paramString)
  {
    AppMethodBeat.i(34684);
    this.Pjh = true;
    this.Pji = true;
    this.OIz = parama;
    this.contact = paramas;
    this.PgT = paramString;
    if (as.IG(this.PgT)) {
      this.Pji = false;
    }
    if (as.bjo(this.PgT)) {
      this.Pjh = false;
    }
    if (as.bjm(this.PgT)) {
      this.Pjh = false;
    }
    if ((this.contact != null) && (as.IG(this.contact.field_username))) {
      parama = this.PgT;
    }
    for (;;)
    {
      if (ab.II(parama)) {
        this.Pji = false;
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
  
  public final void B(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(34685);
    bg.aVF();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.u.g(this.OIz.Pwc.getContext(), this.OIz.Pwc.getContentView());
      AppMethodBeat.o(34685);
      return;
    }
    if (paramEmojiInfo == null)
    {
      AppMethodBeat.o(34685);
      return;
    }
    if ((this.contact.field_username.equals("medianote")) && ((z.aUc() & 0x4000) == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramEmojiInfo.field_start = 0;
      paramEmojiInfo.field_state = EmojiInfo.UuD;
      ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(paramEmojiInfo);
      localObject = new ca();
      ((ca)localObject).setType(47);
      ((ca)localObject).Cy("medianote");
      ((ca)localObject).nv(1);
      if (paramEmojiInfo.NA()) {
        ((ca)localObject).setContent(be.a(z.aTY(), 0L, false, paramEmojiInfo.getMd5(), false, ""));
      }
      ((ca)localObject).Cz(paramEmojiInfo.getMd5());
      ((ca)localObject).setCreateTime(bp.Kw(((eo)localObject).field_talker));
      ((ca)localObject).setStatus(2);
      bg.aVF();
      c.aSQ().aC((ca)localObject);
      AppMethodBeat.o(34685);
      return;
    }
    com.tencent.mm.pluginsdk.a.d locald = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
    if (Util.isNullOrNil(this.PgT)) {}
    for (Object localObject = this.contact.field_username;; localObject = this.PgT)
    {
      locald.a((String)localObject, paramEmojiInfo, null);
      this.OIz.BN(true);
      AppMethodBeat.o(34685);
      return;
    }
  }
  
  /* Error */
  public final void N(EmojiInfo paramEmojiInfo)
  {
    // Byte code:
    //   0: ldc 227
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 74	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   8: pop
    //   9: invokestatic 80	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   12: ifne +32 -> 44
    //   15: aload_0
    //   16: getfield 35	com/tencent/mm/ui/chatting/w:OIz	Lcom/tencent/mm/ui/chatting/e/a;
    //   19: getfield 86	com/tencent/mm/ui/chatting/e/a:Pwc	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   22: invokevirtual 92	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   25: aload_0
    //   26: getfield 35	com/tencent/mm/ui/chatting/w:OIz	Lcom/tencent/mm/ui/chatting/e/a;
    //   29: getfield 86	com/tencent/mm/ui/chatting/e/a:Pwc	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   32: invokevirtual 98	com/tencent/mm/ui/MMFragment:getContentView	()Landroid/view/View;
    //   35: invokestatic 104	com/tencent/mm/ui/base/u:g	(Landroid/content/Context;Landroid/view/View;)V
    //   38: ldc 227
    //   40: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: return
    //   44: aload_1
    //   45: ifnonnull +9 -> 54
    //   48: ldc 227
    //   50: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: return
    //   54: new 229	com/tencent/mm/opensdk/modelmsg/WXMediaMessage
    //   57: dup
    //   58: invokespecial 230	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:<init>	()V
    //   61: astore 6
    //   63: new 232	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   70: astore_3
    //   71: invokestatic 74	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   74: pop
    //   75: aload_3
    //   76: invokestatic 236	com/tencent/mm/model/c:aTd	()Ljava/lang/String;
    //   79: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: invokevirtual 169	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   86: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore 7
    //   94: new 232	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   101: aload 7
    //   103: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 245
    //   108: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 250	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   117: ifeq +98 -> 215
    //   120: new 232	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   127: aload 7
    //   129: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 245
    //   134: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 253	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
    //   143: l2i
    //   144: istore_2
    //   145: aload 6
    //   147: new 232	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   154: aload 7
    //   156: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc 245
    //   161: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: iconst_0
    //   168: iload_2
    //   169: invokestatic 257	com/tencent/mm/vfs/s:aW	(Ljava/lang/String;II)[B
    //   172: putfield 261	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:thumbData	[B
    //   175: aload 6
    //   177: new 263	com/tencent/mm/opensdk/modelmsg/WXEmojiObject
    //   180: dup
    //   181: aload 7
    //   183: invokespecial 265	com/tencent/mm/opensdk/modelmsg/WXEmojiObject:<init>	(Ljava/lang/String;)V
    //   186: putfield 269	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:mediaObject	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage$IMediaObject;
    //   189: aload 6
    //   191: aload_1
    //   192: getfield 272	com/tencent/mm/storage/emotion/EmojiInfo:field_app_id	Ljava/lang/String;
    //   195: aconst_null
    //   196: aload_0
    //   197: getfield 39	com/tencent/mm/ui/chatting/w:PgT	Ljava/lang/String;
    //   200: iconst_1
    //   201: aload_1
    //   202: invokevirtual 169	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   205: invokestatic 277	com/tencent/mm/pluginsdk/model/app/m:a	(Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)I
    //   208: pop
    //   209: ldc 227
    //   211: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: return
    //   215: aload 7
    //   217: invokestatic 281	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   220: astore 4
    //   222: aload 4
    //   224: astore_3
    //   225: aload 6
    //   227: aload 4
    //   229: fconst_1
    //   230: invokestatic 287	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$BitmapFactory:decodeStream	(Ljava/io/InputStream;F)Landroid/graphics/Bitmap;
    //   233: invokevirtual 291	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:setThumbImage	(Landroid/graphics/Bitmap;)V
    //   236: aload 4
    //   238: invokestatic 295	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   241: goto -66 -> 175
    //   244: astore 5
    //   246: aconst_null
    //   247: astore 4
    //   249: aload 4
    //   251: astore_3
    //   252: ldc_w 297
    //   255: aload 5
    //   257: ldc 171
    //   259: iconst_0
    //   260: anewarray 4	java/lang/Object
    //   263: invokestatic 303	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: aload 4
    //   268: astore_3
    //   269: ldc_w 297
    //   272: ldc_w 305
    //   275: invokestatic 309	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: aload 4
    //   280: invokestatic 295	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   283: goto -108 -> 175
    //   286: astore_1
    //   287: aconst_null
    //   288: astore_3
    //   289: aload_3
    //   290: invokestatic 295	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   293: ldc 227
    //   295: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void N(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(232881);
    ChatFooter localChatFooter = ((com.tencent.mm.ui.chatting.d.b.u)this.OIz.bh(com.tencent.mm.ui.chatting.d.b.u.class)).gPO();
    if (paramBoolean)
    {
      this.Pjj = localChatFooter.getCurrentScrollHeight();
      localChatFooter.aiA(ad.bD(this.OIz.Pwc.getContext()) + paramInt);
      localChatFooter.Kjf = false;
      localChatFooter.setIgnoreScroll(Boolean.TRUE);
      AppMethodBeat.o(232881);
      return;
    }
    if (this.Pjj > 0) {
      localChatFooter.aiA(this.Pjj);
    }
    for (;;)
    {
      localChatFooter.Kjf = true;
      localChatFooter.setIgnoreScroll(Boolean.FALSE);
      AppMethodBeat.o(232881);
      return;
      localChatFooter.aiA(ad.bD(this.OIz.Pwc.getContext()) + paramInt);
    }
  }
  
  public final void ein() {}
  
  public final void eio()
  {
    AppMethodBeat.i(232882);
    ((com.tencent.mm.ui.chatting.d.b.u)this.OIz.bh(com.tencent.mm.ui.chatting.d.b.u.class)).gPO().gqi();
    AppMethodBeat.o(232882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.w
 * JD-Core Version:    0.7.0.1
 */