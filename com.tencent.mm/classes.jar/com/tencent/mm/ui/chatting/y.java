package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ae;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.chatting.d.a;

public final class y
  implements j
{
  private a adHw;
  private String aehI;
  private boolean aekc;
  private boolean aekd;
  private int aeke;
  private au contact;
  
  public y(a parama, au paramau, String paramString)
  {
    AppMethodBeat.i(34684);
    this.aekc = true;
    this.aekd = true;
    this.adHw = parama;
    this.contact = paramau;
    this.aehI = paramString;
    if (au.bwS(this.aehI)) {
      this.aekd = false;
    }
    if (au.bwN(this.aehI)) {
      this.aekc = false;
    }
    if (au.bwL(this.aehI)) {
      this.aekc = false;
    }
    if ((this.contact != null) && (au.bwS(this.contact.field_username))) {
      parama = this.aehI;
    }
    for (;;)
    {
      if (au.bwK(parama)) {
        this.aekd = false;
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
  
  /* Error */
  public final void O(EmojiInfo paramEmojiInfo)
  {
    // Byte code:
    //   0: ldc 68
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 74	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   8: pop
    //   9: invokestatic 80	com/tencent/mm/model/c:isSDCardAvailable	()Z
    //   12: ifne +32 -> 44
    //   15: aload_0
    //   16: getfield 35	com/tencent/mm/ui/chatting/y:adHw	Lcom/tencent/mm/ui/chatting/d/a;
    //   19: getfield 86	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   22: invokevirtual 92	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   25: aload_0
    //   26: getfield 35	com/tencent/mm/ui/chatting/y:adHw	Lcom/tencent/mm/ui/chatting/d/a;
    //   29: getfield 86	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   32: invokevirtual 98	com/tencent/mm/ui/MMFragment:getContentView	()Landroid/view/View;
    //   35: invokestatic 104	com/tencent/mm/ui/base/aa:j	(Landroid/content/Context;Landroid/view/View;)V
    //   38: ldc 68
    //   40: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: return
    //   44: aload_1
    //   45: ifnonnull +9 -> 54
    //   48: ldc 68
    //   50: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: return
    //   54: new 106	com/tencent/mm/opensdk/modelmsg/WXMediaMessage
    //   57: dup
    //   58: invokespecial 107	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:<init>	()V
    //   61: astore 6
    //   63: new 109	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   70: astore_3
    //   71: invokestatic 74	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   74: pop
    //   75: aload_3
    //   76: invokestatic 114	com/tencent/mm/model/c:bzQ	()Ljava/lang/String;
    //   79: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: invokevirtual 123	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   86: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore 7
    //   94: new 109	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   101: aload 7
    //   103: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 128
    //   108: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 133	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   117: ifeq +98 -> 215
    //   120: new 109	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   127: aload 7
    //   129: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 128
    //   134: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 137	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   143: l2i
    //   144: istore_2
    //   145: aload 6
    //   147: new 109	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   154: aload 7
    //   156: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc 128
    //   161: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: iconst_0
    //   168: iload_2
    //   169: invokestatic 141	com/tencent/mm/vfs/y:bi	(Ljava/lang/String;II)[B
    //   172: putfield 145	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:thumbData	[B
    //   175: aload 6
    //   177: new 147	com/tencent/mm/opensdk/modelmsg/WXEmojiObject
    //   180: dup
    //   181: aload 7
    //   183: invokespecial 150	com/tencent/mm/opensdk/modelmsg/WXEmojiObject:<init>	(Ljava/lang/String;)V
    //   186: putfield 154	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:mediaObject	Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage$IMediaObject;
    //   189: aload 6
    //   191: aload_1
    //   192: getfield 157	com/tencent/mm/storage/emotion/EmojiInfo:field_app_id	Ljava/lang/String;
    //   195: aconst_null
    //   196: aload_0
    //   197: getfield 39	com/tencent/mm/ui/chatting/y:aehI	Ljava/lang/String;
    //   200: iconst_1
    //   201: aload_1
    //   202: invokevirtual 123	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   205: invokestatic 163	com/tencent/mm/pluginsdk/model/app/n:a	(Lcom/tencent/mm/opensdk/modelmsg/WXMediaMessage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)I
    //   208: pop
    //   209: ldc 68
    //   211: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: return
    //   215: aload 7
    //   217: invokestatic 167	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   220: astore 4
    //   222: aload 4
    //   224: astore_3
    //   225: aload 6
    //   227: aload 4
    //   229: fconst_1
    //   230: invokestatic 173	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$BitmapFactory:decodeStream	(Ljava/io/InputStream;F)Landroid/graphics/Bitmap;
    //   233: invokevirtual 177	com/tencent/mm/opensdk/modelmsg/WXMediaMessage:setThumbImage	(Landroid/graphics/Bitmap;)V
    //   236: aload 4
    //   238: invokestatic 183	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   241: goto -66 -> 175
    //   244: astore 5
    //   246: aconst_null
    //   247: astore 4
    //   249: aload 4
    //   251: astore_3
    //   252: ldc 185
    //   254: aload 5
    //   256: ldc 187
    //   258: iconst_0
    //   259: anewarray 4	java/lang/Object
    //   262: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: aload 4
    //   267: astore_3
    //   268: ldc 185
    //   270: ldc 195
    //   272: invokestatic 199	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: aload 4
    //   277: invokestatic 183	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   280: goto -105 -> 175
    //   283: astore_1
    //   284: aconst_null
    //   285: astore_3
    //   286: aload_3
    //   287: invokestatic 183	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   290: ldc 68
    //   292: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   295: aload_1
    //   296: athrow
    //   297: astore_1
    //   298: goto -12 -> 286
    //   301: astore 5
    //   303: goto -54 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	y
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
  
  public final void cSg() {}
  
  public final void cSh()
  {
    AppMethodBeat.i(253970);
    ((x)this.adHw.cm(x.class)).jsd().iLX();
    AppMethodBeat.o(253970);
  }
  
  public final boolean cSi()
  {
    return false;
  }
  
  public final boolean cSj()
  {
    return false;
  }
  
  public final void o(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(34685);
    bh.bCz();
    if (!c.isSDCardAvailable())
    {
      aa.j(this.adHw.aezO.getContext(), this.adHw.aezO.getContentView());
      AppMethodBeat.o(34685);
      return;
    }
    if (paramEmojiInfo == null)
    {
      AppMethodBeat.o(34685);
      return;
    }
    if ((this.contact.field_username.equals("medianote")) && ((z.bAQ() & 0x4000) == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramEmojiInfo.field_start = 0;
      paramEmojiInfo.field_state = EmojiInfo.aklU;
      ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().updateEmojiInfo(paramEmojiInfo);
      localObject = new cc();
      ((cc)localObject).setType(47);
      ((cc)localObject).BS("medianote");
      ((cc)localObject).pI(1);
      if (paramEmojiInfo.aqJ()) {
        ((cc)localObject).setContent(bg.a(z.bAM(), 0L, false, paramEmojiInfo.getMd5(), false, ""));
      }
      ((cc)localObject).BT(paramEmojiInfo.getMd5());
      ((cc)localObject).setCreateTime(br.JN(((fi)localObject).field_talker));
      ((cc)localObject).setStatus(2);
      bh.bCz();
      c.bzD().ba((cc)localObject);
      AppMethodBeat.o(34685);
      return;
    }
    com.tencent.mm.pluginsdk.b.d locald = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr();
    if (Util.isNullOrNil(this.aehI)) {}
    for (Object localObject = this.contact.field_username;; localObject = this.aehI)
    {
      locald.a((String)localObject, paramEmojiInfo, null);
      this.adHw.jpK();
      AppMethodBeat.o(34685);
      return;
    }
  }
  
  public final void y(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(253967);
    ChatFooter localChatFooter = ((x)this.adHw.cm(x.class)).jsd();
    if (paramBoolean)
    {
      this.aeke = localChatFooter.getCurrentScrollHeight();
      localChatFooter.awH(ae.cp(this.adHw.aezO.getContext()) + paramInt);
      localChatFooter.Ygc = false;
      localChatFooter.setIgnoreScroll(Boolean.TRUE);
      AppMethodBeat.o(253967);
      return;
    }
    if (this.aeke > 0) {
      localChatFooter.awH(this.aeke);
    }
    for (;;)
    {
      localChatFooter.Ygc = true;
      localChatFooter.setIgnoreScroll(Boolean.FALSE);
      AppMethodBeat.o(253967);
      return;
      localChatFooter.awH(ae.cp(this.adHw.aezO.getContext()) + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.y
 * JD-Core Version:    0.7.0.1
 */