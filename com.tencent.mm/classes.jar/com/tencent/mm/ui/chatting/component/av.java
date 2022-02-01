package com.tencent.mm.ui.chatting.component;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.n;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.messenger.f.b.a;
import com.tencent.mm.plugin.messenger.f.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.chatting.AtSomeoneUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.ak;
import com.tencent.mm.ui.chatting.component.api.g;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=ak.class)
public class av
  extends a
  implements b.b, ak
{
  private com.tencent.mm.ui.chatting.l.a aevf;
  private com.tencent.mm.ui.chatting.l.b aevg;
  private com.tencent.mm.ui.chatting.l.d aevh;
  private com.tencent.mm.plugin.messenger.e.a aevi;
  private com.tencent.mm.ui.chatting.l.c aevj;
  private com.tencent.mm.plugin.selectrecord.e.b aevk;
  private l contextMenuHelper;
  
  /* Error */
  private void a(final View paramView, com.tencent.mm.ui.chatting.h.a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: ldc 43
    //   5: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 55	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   11: pop
    //   12: invokestatic 61	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
    //   15: getstatic 67	com/tencent/mm/storage/at$a:acLU	Lcom/tencent/mm/storage/at$a;
    //   18: getstatic 73	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   21: invokevirtual 79	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
    //   24: aload_2
    //   25: getfield 85	com/tencent/mm/ui/chatting/h/a:hTm	Lcom/tencent/mm/storage/cc;
    //   28: astore 9
    //   30: invokestatic 91	com/tencent/mm/model/cn:bDv	()J
    //   33: aload_2
    //   34: getfield 95	com/tencent/mm/ui/chatting/h/a:aeIp	J
    //   37: lsub
    //   38: ldc2_w 96
    //   41: lcmp
    //   42: iflt +79 -> 121
    //   45: ldc 99
    //   47: ldc 101
    //   49: invokestatic 107	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: getfield 111	com/tencent/mm/ui/chatting/component/av:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   56: getfield 117	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   59: invokevirtual 123	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   62: aload_0
    //   63: getfield 111	com/tencent/mm/ui/chatting/component/av:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   66: getfield 117	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   69: invokevirtual 127	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getMMResources	()Landroid/content/res/Resources;
    //   72: getstatic 133	com/tencent/mm/R$l:gKb	I
    //   75: invokevirtual 139	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   78: aload_0
    //   79: getfield 111	com/tencent/mm/ui/chatting/component/av:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   82: getfield 117	com/tencent/mm/ui/chatting/d/a:aezO	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   85: invokevirtual 127	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getMMResources	()Landroid/content/res/Resources;
    //   88: getstatic 142	com/tencent/mm/R$l:app_tip	I
    //   91: invokevirtual 139	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   94: iconst_1
    //   95: invokestatic 148	com/tencent/mm/ui/base/k:c	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/mm/ui/widget/a/e;
    //   98: pop
    //   99: new 12	com/tencent/mm/ui/chatting/component/av$2
    //   102: dup
    //   103: aload_0
    //   104: aload 9
    //   106: aload_1
    //   107: invokespecial 151	com/tencent/mm/ui/chatting/component/av$2:<init>	(Lcom/tencent/mm/ui/chatting/component/av;Lcom/tencent/mm/storage/cc;Landroid/view/View;)V
    //   110: ldc 153
    //   112: invokestatic 159	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   115: ldc 43
    //   117: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: return
    //   121: aload_2
    //   122: getfield 166	com/tencent/mm/ui/chatting/h/a:aeIo	Ljava/lang/String;
    //   125: astore_1
    //   126: aload_2
    //   127: getfield 169	com/tencent/mm/ui/chatting/h/a:mType	I
    //   130: istore_3
    //   131: iload_3
    //   132: ldc 170
    //   134: if_icmpne +260 -> 394
    //   137: new 172	java/lang/String
    //   140: dup
    //   141: aload_1
    //   142: iconst_0
    //   143: invokestatic 178	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   146: invokespecial 181	java/lang/String:<init>	([B)V
    //   149: ldc 183
    //   151: aconst_null
    //   152: invokestatic 189	com/tencent/mm/sdk/platformtools/XmlParser:parseXml	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   155: astore 6
    //   157: aload 6
    //   159: ifnull +327 -> 486
    //   162: aload 6
    //   164: ldc 191
    //   166: invokeinterface 197 2 0
    //   171: checkcast 172	java/lang/String
    //   174: astore 7
    //   176: aload 6
    //   178: ldc 199
    //   180: invokeinterface 197 2 0
    //   185: checkcast 172	java/lang/String
    //   188: invokestatic 205	com/tencent/mm/sdk/platformtools/Util:safeParseLong	(Ljava/lang/String;)J
    //   191: lstore 4
    //   193: invokestatic 55	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   196: pop
    //   197: invokestatic 209	com/tencent/mm/model/c:bzD	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
    //   200: aload 9
    //   202: getfield 214	com/tencent/mm/autogen/b/fi:field_talker	Ljava/lang/String;
    //   205: lload 4
    //   207: invokeinterface 220 4 0
    //   212: astore 6
    //   214: aload 7
    //   216: astore_1
    //   217: aload 6
    //   219: astore 7
    //   221: aload_1
    //   222: astore 6
    //   224: getstatic 226	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   227: sipush 15037
    //   230: iconst_1
    //   231: anewarray 228	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: iconst_1
    //   237: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   240: aastore
    //   241: invokevirtual 238	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   244: aload_0
    //   245: getfield 111	com/tencent/mm/ui/chatting/component/av:hlc	Lcom/tencent/mm/ui/chatting/d/a;
    //   248: ldc 240
    //   250: invokevirtual 244	com/tencent/mm/ui/chatting/d/a:cm	(Ljava/lang/Class;)Lcom/tencent/mm/ui/chatting/component/aj;
    //   253: checkcast 240	com/tencent/mm/ui/chatting/component/api/x
    //   256: astore_1
    //   257: aload_1
    //   258: invokeinterface 248 1 0
    //   263: invokevirtual 253	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:iMB	()V
    //   266: aload_1
    //   267: invokeinterface 248 1 0
    //   272: iconst_1
    //   273: invokevirtual 256	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:awF	(I)V
    //   276: aload_1
    //   277: invokeinterface 248 1 0
    //   282: new 258	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   289: aload_1
    //   290: invokeinterface 248 1 0
    //   295: invokevirtual 263	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getLastText	()Ljava/lang/String;
    //   298: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload 6
    //   303: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokevirtual 274	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:setLastText	(Ljava/lang/String;)V
    //   312: aload_2
    //   313: aload 9
    //   315: aload_1
    //   316: invokeinterface 248 1 0
    //   321: invokestatic 277	com/tencent/mm/ui/chatting/component/av:a	(Lcom/tencent/mm/ui/chatting/h/a;Lcom/tencent/mm/storage/cc;Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   324: aload 7
    //   326: ifnull +15 -> 341
    //   329: aload_1
    //   330: invokeinterface 248 1 0
    //   335: aload 7
    //   337: invokevirtual 281	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:bC	(Lcom/tencent/mm/storage/cc;)Z
    //   340: pop
    //   341: aload_1
    //   342: invokeinterface 248 1 0
    //   347: getfield 285	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:HDO	Z
    //   350: ifne +12 -> 362
    //   353: aload_1
    //   354: invokeinterface 248 1 0
    //   359: invokevirtual 288	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:showVKB	()V
    //   362: ldc 43
    //   364: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   367: return
    //   368: astore 6
    //   370: ldc 99
    //   372: aload 6
    //   374: ldc_w 290
    //   377: iconst_0
    //   378: anewarray 228	java/lang/Object
    //   381: invokestatic 294	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   384: aload 8
    //   386: astore 7
    //   388: aload_1
    //   389: astore 6
    //   391: goto -167 -> 224
    //   394: aload 8
    //   396: astore 7
    //   398: aload_1
    //   399: astore 6
    //   401: iload_3
    //   402: ldc_w 295
    //   405: if_icmpne -181 -> 224
    //   408: aload_1
    //   409: ldc 183
    //   411: aconst_null
    //   412: invokestatic 189	com/tencent/mm/sdk/platformtools/XmlParser:parseXml	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   415: astore 6
    //   417: aload 6
    //   419: ifnull +64 -> 483
    //   422: aload 6
    //   424: ldc 191
    //   426: invokeinterface 197 2 0
    //   431: checkcast 172	java/lang/String
    //   434: astore 6
    //   436: aload 6
    //   438: astore_1
    //   439: aload 8
    //   441: astore 7
    //   443: aload_1
    //   444: astore 6
    //   446: goto -222 -> 224
    //   449: astore 6
    //   451: ldc 99
    //   453: aload 6
    //   455: ldc_w 297
    //   458: iconst_0
    //   459: anewarray 228	java/lang/Object
    //   462: invokestatic 294	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   465: aload 8
    //   467: astore 7
    //   469: aload_1
    //   470: astore 6
    //   472: goto -248 -> 224
    //   475: astore 6
    //   477: aload 7
    //   479: astore_1
    //   480: goto -110 -> 370
    //   483: goto -44 -> 439
    //   486: aconst_null
    //   487: astore 6
    //   489: goto -272 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	492	0	this	av
    //   0	492	1	paramView	View
    //   0	492	2	parama	com.tencent.mm.ui.chatting.h.a
    //   130	276	3	i	int
    //   191	15	4	l	long
    //   155	147	6	localObject1	Object
    //   368	5	6	localThrowable1	Throwable
    //   389	56	6	localObject2	Object
    //   449	5	6	localThrowable2	Throwable
    //   470	1	6	localView	View
    //   475	1	6	localObject3	Object
    //   487	1	6	localObject4	Object
    //   174	304	7	localObject5	Object
    //   1	465	8	localObject6	Object
    //   28	286	9	localcc	cc
    // Exception table:
    //   from	to	target	type
    //   137	157	368	finally
    //   162	176	368	finally
    //   408	417	449	finally
    //   422	436	449	finally
    //   176	214	475	finally
  }
  
  private void a(View paramView, final LinkedList<String> paramLinkedList, final String paramString)
  {
    AppMethodBeat.i(35515);
    if (this.contextMenuHelper == null) {
      this.contextMenuHelper = new l(this.hlc.aezO.getContext());
    }
    this.contextMenuHelper.b(paramView, new av.3(this), new u.i()
    {
      public final void onMMMenuItemSelected(final MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(35512);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(35512);
          return;
          ((g)av.this.hlc.cm(g.class)).b(-1L, paramLinkedList, 0);
          AppMethodBeat.o(35512);
          return;
          paramAnonymousMenuItem = com.tencent.mm.roomsdk.model.b.btW(av.this.hlc.Uxa.field_username).ai(paramString, av.this.hlc.Uxa.field_username);
          paramAnonymousMenuItem.a(av.this.hlc.aezO.getContext(), av.this.hlc.aezO.getMMResources().getString(R.l.app_tip), av.this.hlc.aezO.getMMResources().getString(R.l.gTC), true, true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(35511);
              paramAnonymousMenuItem.cancel();
              AppMethodBeat.o(35511);
            }
          });
        }
      }
    });
    AppMethodBeat.o(35515);
  }
  
  private static void a(com.tencent.mm.ui.chatting.h.a parama, cc paramcc, ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(255813);
    if ((parama == null) || (paramcc == null) || (paramChatFooter == null))
    {
      AppMethodBeat.o(255813);
      return;
    }
    parama = parama.aeIq;
    if (TextUtils.isEmpty(parama))
    {
      AppMethodBeat.o(255813);
      return;
    }
    try
    {
      String str1 = new String(Base64.decode(parama, 0));
      parama = str1;
    }
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.NewXmlSysMsgComponent", localThrowable, "parse msgSourceStr err", new Object[0]);
      }
      parama = (String)parama.get(".msgsource.atuserlist");
      if (Util.isNullOrNil(parama)) {
        break label267;
      }
      String[] arrayOfString = parama.split(",");
      if ((arrayOfString == null) || (arrayOfString.length <= 0)) {
        break label267;
      }
      bh.bCz();
      aj localaj = com.tencent.mm.model.c.bzK().Ju(paramcc.field_talker);
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str3 = arrayOfString[i];
        if (!TextUtils.isEmpty(str3))
        {
          String str2 = AtSomeoneUI.a(localaj, str3);
          parama = str2;
          if (Util.isNullOrNil(str2))
          {
            bh.bCz();
            au localau = com.tencent.mm.model.c.bzA().bxu(str3);
            parama = str2;
            if (localau != null) {
              parama = localau.aSU();
            }
          }
          if (!TextUtils.isEmpty(parama)) {
            paramChatFooter.by(paramcc.field_talker, str3, parama);
          }
        }
        i += 1;
      }
      AppMethodBeat.o(255813);
    }
    if (!Util.isNullOrNil(parama))
    {
      parama = XmlParser.parseXml(parama, "msgsource", null);
      if (parama == null)
      {
        AppMethodBeat.o(255813);
        return;
      }
    }
    label267:
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<String> paramLinkedList4, LinkedList<String> paramLinkedList5, cc paramcc)
  {
    AppMethodBeat.i(35517);
    Intent localIntent = new Intent(this.hlc.aezO.getContext(), SeeAccessVerifyInfoUI.class);
    localIntent.putExtra("msgLocalId", paramcc.field_msgId);
    localIntent.putExtra("msgSvrId", paramcc.field_msgSvrId);
    localIntent.putExtra("invitertitle", this.hlc.aezO.getMMResources().getString(R.l.gpG, new Object[] { Integer.valueOf(paramLinkedList1.size()) }));
    localIntent.putExtra("inviterusername", paramString1);
    localIntent.putExtra("chatroom", paramString5);
    localIntent.putExtra("inviterappid", paramString2);
    localIntent.putExtra("inviterdescid", paramString3);
    localIntent.putExtra("invitationreason", paramString4);
    localIntent.putExtra("ticket", paramString6);
    localIntent.putExtra("username", Util.listToString(paramLinkedList1, ","));
    localIntent.putExtra("nickname", Util.listToString(paramLinkedList2, ","));
    localIntent.putExtra("descid", Util.listToString(paramLinkedList3, ","));
    localIntent.putExtra("appid", Util.listToString(paramLinkedList4, ","));
    localIntent.putExtra("headimgurl", Util.listToString(paramLinkedList5, ","));
    paramString1 = this.hlc;
    paramString2 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramString1, paramString2.aYi(), "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "dealApproveAddChatRoomMember", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString1.startActivity((Intent)paramString2.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramString1, "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "dealApproveAddChatRoomMember", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35517);
  }
  
  private void c(long paramLong, LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(255825);
    if (((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqV())
    {
      ((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).cy(paramLinkedList);
      AppMethodBeat.o(255825);
      return;
    }
    ((g)this.hlc.cm(g.class)).b(paramLong, paramLinkedList, paramInt);
    AppMethodBeat.o(255825);
  }
  
  public final void a(long paramLong, LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(255850);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0)) {
      c(paramLong, paramLinkedList, paramInt);
    }
    AppMethodBeat.o(255850);
  }
  
  public final void a(View paramView, b.a parama)
  {
    AppMethodBeat.i(255854);
    if ((paramView != null) && (parama != null))
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(parama.username);
      a(paramView, localLinkedList, parama.link);
    }
    AppMethodBeat.o(255854);
  }
  
  public final void a(final View paramView, cc paramcc, final com.tencent.mm.ax.a parama, int paramInt)
  {
    AppMethodBeat.i(35513);
    if ((parama instanceof com.tencent.mm.ax.e))
    {
      paramcc = (com.tencent.mm.ax.e)parama;
      parama = Util.nullAsNil(paramcc.SCENE);
      Log.d("MicroMsg.NewXmlSysMsgComponent", "click delchatroommember link %s,isBizChat:%s", new Object[] { parama, Boolean.valueOf(((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqV()) });
      if (paramcc.oPy == null)
      {
        Log.e("MicroMsg.NewXmlSysMsgComponent", "click members is null!!!");
        AppMethodBeat.o(35513);
        return;
      }
      if ((((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jqW()) || (this.hlc.juF())) {}
      for (paramInt = 1; paramInt == 0; paramInt = 0)
      {
        Log.e("MicroMsg.NewXmlSysMsgComponent", "not group chat !!!!!");
        AppMethodBeat.o(35513);
        return;
      }
      if (parama.equals("invite"))
      {
        c(-1L, paramcc.oPy, 0);
        AppMethodBeat.o(35513);
        return;
      }
      if (parama.equals("qrcode"))
      {
        a(paramView, paramcc.oPy, paramcc.hSC);
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama.equals("webview")) && (!Util.isNullOrNil(paramcc.url)))
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", paramcc.url);
        paramView.putExtra("geta8key_username", z.bAM());
        com.tencent.mm.br.c.b(this.hlc.aezO.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      }
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.ax.d))
    {
      Object localObject = (com.tencent.mm.ax.d)parama;
      if (paramInt == 0)
      {
        paramView = ((com.tencent.mm.ax.d)localObject).oPv;
        parama = ((com.tencent.mm.ax.d)localObject).oPw;
        String str1 = ((com.tencent.mm.ax.d)localObject).oPp;
        String str2 = ((com.tencent.mm.ax.d)localObject).hFb;
        LinkedList localLinkedList1 = ((com.tencent.mm.ax.d)localObject).oPq;
        LinkedList localLinkedList2 = ((com.tencent.mm.ax.d)localObject).oPt;
        localObject = ((com.tencent.mm.ax.d)localObject).oPu;
        a(paramView, "", "", parama, str1, str2, localLinkedList1, localLinkedList2, new LinkedList(), new LinkedList(), (LinkedList)localObject, paramcc);
      }
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.ax.b))
    {
      paramView = (com.tencent.mm.ax.b)parama;
      parama = new ArrayList();
      parama.addAll(paramView.oPq);
      ((g)this.hlc.cm(g.class)).a(parama, paramView.hFb, paramcc);
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.ui.chatting.h.a))
    {
      bh.bCz();
      if (((Boolean)com.tencent.mm.model.c.ban().get(at.a.acLU, Boolean.TRUE)).booleanValue())
      {
        k.a(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.gKa), this.hlc.aezO.getMMResources().getString(R.l.tip_title), this.hlc.aezO.getMMResources().getString(R.l.i_know_it), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35507);
            av.a(av.this, paramView, (com.tencent.mm.ui.chatting.h.a)parama);
            AppMethodBeat.o(35507);
          }
        });
        AppMethodBeat.o(35513);
        return;
      }
      a(paramView, (com.tencent.mm.ui.chatting.h.a)parama);
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.ax.c))
    {
      Log.i("MicroMsg.NewXmlSysMsgComponent", "handleClickMuteSysText");
      if ((this.hlc.juF()) && (this.hlc.aezO.getContext() != null)) {
        if (this.hlc.Uxa.kaf != 0) {
          break label972;
        }
      }
    }
    label972:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.expt.roomexpt.d)h.ax(com.tencent.mm.plugin.expt.roomexpt.d.class)).pe(bool);
      paramcc = new Intent();
      paramcc.putExtra("Chat_User", this.hlc.Uxa.field_username);
      paramcc.putExtra("RoomInfo_Id", this.hlc.getTalkerUserName());
      paramcc.putExtra("Is_Chatroom", this.hlc.juF());
      paramcc.putExtra("fromChatting", true);
      paramcc.putExtra("isShowSetMuteAnimation", true);
      paramcc.setClass(this.hlc.aezO.getContext(), ChatroomInfoUI.class);
      paramView = this.hlc.aezO.getContext();
      paramcc = new com.tencent.mm.hellhoundlib.b.a().cG(paramcc);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, paramcc.aYi(), "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "handleClickMuteSysText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)paramcc.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "handleClickMuteSysText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35513);
      return;
      if ((parama instanceof ca))
      {
        ((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jre();
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama instanceof n))
      {
        ((com.tencent.mm.ui.chatting.component.api.e)this.hlc.cm(com.tencent.mm.ui.chatting.component.api.e.class)).jrf();
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama instanceof com.tencent.mm.openim.b.a.b))
      {
        paramView = (com.tencent.mm.openim.b.a.b)parama;
        if (paramInt == 0) {
          a(paramView.oPv, paramView.pto, paramView.ptp, paramView.oPw, paramView.oPp, paramView.hFb, paramView.oPq, paramView.oPt, paramView.ptm, paramView.ptn, paramView.oPu, paramcc);
        }
      }
      AppMethodBeat.o(35513);
      return;
    }
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(35520);
    super.jjg();
    this.aevh = new com.tencent.mm.ui.chatting.l.d(this);
    this.aevg = new com.tencent.mm.ui.chatting.l.b(this);
    this.aevf = new com.tencent.mm.ui.chatting.l.a(this);
    this.aevi = new com.tencent.mm.plugin.messenger.e.a(this);
    this.aevj = new com.tencent.mm.ui.chatting.l.c(this);
    this.aevk = new com.tencent.mm.plugin.selectrecord.e.b(this);
    AppMethodBeat.o(35520);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35521);
    if (this.aevf != null)
    {
      this.aevf.release();
      this.aevf = null;
    }
    if (this.aevg != null)
    {
      this.aevg.release();
      this.aevg = null;
    }
    if (this.aevh != null)
    {
      this.aevh.release();
      this.aevh = null;
    }
    if (this.aevi != null)
    {
      this.aevi.release();
      this.aevi = null;
    }
    if (this.aevj != null)
    {
      this.aevj.release();
      this.aevj = null;
    }
    if (this.aevk != null)
    {
      this.aevk.release();
      this.aevk = null;
    }
    AppMethodBeat.o(35521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.av
 * JD-Core Version:    0.7.0.1
 */