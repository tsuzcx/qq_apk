package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ad;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
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
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.chatting.e.a;

public final class w
  implements j
{
  private String WAm;
  private boolean WCJ;
  private boolean WCK;
  private int WCL;
  private a WbU;
  private as contact;
  
  public w(a parama, as paramas, String paramString)
  {
    AppMethodBeat.i(34684);
    this.WCJ = true;
    this.WCK = true;
    this.WbU = parama;
    this.contact = paramas;
    this.WAm = paramString;
    if (as.PY(this.WAm)) {
      this.WCK = false;
    }
    if (as.bvJ(this.WAm)) {
      this.WCJ = false;
    }
    if (as.bvH(this.WAm)) {
      this.WCJ = false;
    }
    if ((this.contact != null) && (as.PY(this.contact.field_username))) {
      parama = this.WAm;
    }
    for (;;)
    {
      if (ab.Qa(parama)) {
        this.WCK = false;
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
  
  public final void A(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(224619);
    ChatFooter localChatFooter = ((u)this.WbU.bC(u.class)).hPj();
    if (paramBoolean)
    {
      this.WCL = localChatFooter.getCurrentScrollHeight();
      localChatFooter.aqC(ad.bC(this.WbU.WQv.getContext()) + paramInt);
      localChatFooter.RjS = false;
      localChatFooter.setIgnoreScroll(Boolean.TRUE);
      AppMethodBeat.o(224619);
      return;
    }
    if (this.WCL > 0) {
      localChatFooter.aqC(this.WCL);
    }
    for (;;)
    {
      localChatFooter.RjS = true;
      localChatFooter.setIgnoreScroll(Boolean.FALSE);
      AppMethodBeat.o(224619);
      return;
      localChatFooter.aqC(ad.bC(this.WbU.WQv.getContext()) + paramInt);
    }
  }
  
  /* Error */
  public final void O(EmojiInfo paramEmojiInfo)
  {
    // Byte code:
    //   0: ldc 127
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 133	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   8: pop
    //   9: invokestatic 139	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   12: ifne +32 -> 44
    //   15: aload_0
    //   16: getfield 35	com/tencent/mm/ui/chatting/w:WbU	Lcom/tencent/mm/ui/chatting/e/a;
    //   19: getfield 92	com/tencent/mm/ui/chatting/e/a:WQv	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   22: invokevirtual 98	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   25: aload_0
    //   26: getfield 35	com/tencent/mm/ui/chatting/w:WbU	Lcom/tencent/mm/ui/chatting/e/a;
    //   29: getfield 92	com/tencent/mm/ui/chatting/e/a:WQv	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   32: invokevirtual 145	com/tencent/mm/ui/MMFragment:getContentView	()Landroid/view/View;
    //   35: invokestatic 151	com/tencent/mm/ui/base/w:g	(Landroid/content/Context;Landroid/view/View;)V
    //   38: ldc 127
    //   40: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: return
    //   44: aload_1
    //   45: ifnonnull +9 -> 54
    //   48: ldc 127
    //   50: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: return
    //   54: new 153	com/tencent/mm/opensdk/modelmsg/WXMediaMessage
    //   57: dup
    //   58: invokespecial 154	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:<init>	()V
    //   61: astore 6
    //   63: new 156	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   70: astore_3
    //   71: invokestatic 133	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   74: pop
    //   75: aload_3
    //   76: invokestatic 161	com/tencent/mm/model/c:bcb	()Ljava/lang/String;
    //   79: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: invokevirtual 170	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   86: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore 7
    //   94: new 156	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   101: aload 7
    //   103: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 175
    //   108: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 180	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   117: ifeq +98 -> 215
    //   120: new 156	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   127: aload 7
    //   129: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 175
    //   134: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 184	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   143: l2i
    //   144: istore_2
    //   145: aload 6
    //   147: new 156	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   154: aload 7
    //   156: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc 175
    //   161: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: iconst_0
    //   168: iload_2
    //   169: invokestatic 188	com/tencent/mm/vfs/u:aY	(Ljava/lang/String;II)[B
    //   172: putfield 192	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:thumbData	[B
    //   175: aload 6
    //   177: new 194	com/tencent/mm/opensdk/modelmsg/WXEmojiObject
    //   180: dup
    //   181: aload 7
    //   183: invokespecial 197	com/tencent/mm/opensdk/modelmsg/WXEmojiObject:<init>	(Ljava/lang/String;)V
    //   186: putfield 201	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:mediaObject	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage$IMediaObject;
    //   189: aload 6
    //   191: aload_1
    //   192: getfield 204	com/tencent/mm/storage/emotion/EmojiInfo:field_app_id	Ljava/lang/String;
    //   195: aconst_null
    //   196: aload_0
    //   197: getfield 39	com/tencent/mm/ui/chatting/w:WAm	Ljava/lang/String;
    //   200: iconst_1
    //   201: aload_1
    //   202: invokevirtual 170	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   205: invokestatic 210	com/tencent/mm/pluginsdk/model/app/m:a	(Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)I
    //   208: pop
    //   209: ldc 127
    //   211: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: return
    //   215: aload 7
    //   217: invokestatic 214	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   220: astore 4
    //   222: aload 4
    //   224: astore_3
    //   225: aload 6
    //   227: aload 4
    //   229: fconst_1
    //   230: invokestatic 220	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$BitmapFactory:decodeStream	(Ljava/io/InputStream;F)Landroid/graphics/Bitmap;
    //   233: invokevirtual 224	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:setThumbImage	(Landroid/graphics/Bitmap;)V
    //   236: aload 4
    //   238: invokestatic 230	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   241: goto -66 -> 175
    //   244: astore 5
    //   246: aconst_null
    //   247: astore 4
    //   249: aload 4
    //   251: astore_3
    //   252: ldc 232
    //   254: aload 5
    //   256: ldc 234
    //   258: iconst_0
    //   259: anewarray 4	java/lang/Object
    //   262: invokestatic 240	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: aload 4
    //   267: astore_3
    //   268: ldc 232
    //   270: ldc 242
    //   272: invokestatic 246	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: aload 4
    //   277: invokestatic 230	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   280: goto -105 -> 175
    //   283: astore_1
    //   284: aconst_null
    //   285: astore_3
    //   286: aload_3
    //   287: invokestatic 230	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   290: ldc 127
    //   292: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   295: aload_1
    //   296: athrow
    //   297: astore_1
    //   298: goto -12 -> 286
    //   301: astore 5
    //   303: goto -54 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	w
    //   0	306	1	paramEmojiInfo	EmojiInfo
    //   144	25	2	i	int
    //   70	217	3	localObject	Object
    //   220	56	4	localInputStream	java.io.InputStream
    //   244	11	5	localException1	java.lang.Exception
    //   301	1	5	localException2	java.lang.Exception
    //   61	165	6	localWXMediaMessage	com.tencent.mm.opensdk.modelmsg.WXMediaMessage
    //   92	124	7	str	String
    // Exception table:
    //   from	to	target	type
    //   215	222	244	java/lang/Exception
    //   215	222	283	finally
    //   225	236	297	finally
    //   252	265	297	finally
    //   268	275	297	finally
    //   225	236	301	java/lang/Exception
  }
  
  public final void cpE() {}
  
  public final void cpF()
  {
    AppMethodBeat.i(224621);
    ((u)this.WbU.bC(u.class)).hPj().hlg();
    AppMethodBeat.o(224621);
  }
  
  public final void o(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(34685);
    bh.beI();
    if (!c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.w.g(this.WbU.WQv.getContext(), this.WbU.WQv.getContentView());
      AppMethodBeat.o(34685);
      return;
    }
    if (paramEmojiInfo == null)
    {
      AppMethodBeat.o(34685);
      return;
    }
    if ((this.contact.field_username.equals("medianote")) && ((z.bdd() & 0x4000) == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramEmojiInfo.field_start = 0;
      paramEmojiInfo.field_state = EmojiInfo.ZuF;
      ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().updateEmojiInfo(paramEmojiInfo);
      localObject = new ca();
      ((ca)localObject).setType(47);
      ((ca)localObject).Jm("medianote");
      ((ca)localObject).pJ(1);
      if (paramEmojiInfo.Qv()) {
        ((ca)localObject).setContent(be.a(z.bcZ(), 0L, false, paramEmojiInfo.getMd5(), false, ""));
      }
      ((ca)localObject).Jn(paramEmojiInfo.getMd5());
      ((ca)localObject).setCreateTime(bq.RP(((et)localObject).field_talker));
      ((ca)localObject).setStatus(2);
      bh.beI();
      c.bbO().aM((ca)localObject);
      AppMethodBeat.o(34685);
      return;
    }
    com.tencent.mm.pluginsdk.b.d locald = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
    if (Util.isNullOrNil(this.WAm)) {}
    for (Object localObject = this.contact.field_username;; localObject = this.WAm)
    {
      locald.a((String)localObject, paramEmojiInfo, null);
      this.WbU.Gi(true);
      AppMethodBeat.o(34685);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.w
 * JD-Core Version:    0.7.0.1
 */