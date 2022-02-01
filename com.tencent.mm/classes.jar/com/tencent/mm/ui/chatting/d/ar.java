package com.tencent.mm.ui.chatting.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.bc.e;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.n;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.messenger.e.b.a;
import com.tencent.mm.plugin.messenger.e.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.AtSomeoneUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.tools.m;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.d.a.a(hRc=com.tencent.mm.ui.chatting.d.b.ah.class)
public class ar
  extends a
  implements b.b, com.tencent.mm.ui.chatting.d.b.ah
{
  private com.tencent.mm.ui.chatting.p.a WMX;
  private com.tencent.mm.ui.chatting.p.b WMY;
  private com.tencent.mm.ui.chatting.p.d WMZ;
  private com.tencent.mm.plugin.messenger.d.a WNa;
  private com.tencent.mm.ui.chatting.p.c WNb;
  private com.tencent.mm.plugin.selectrecord.e.b WNc;
  private m contextMenuHelper;
  
  /* Error */
  private void a(final View paramView, com.tencent.mm.ui.chatting.k.a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc 47
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 59	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   11: pop
    //   12: invokestatic 65	com/tencent/mm/model/c:aHp	()Lcom/tencent/mm/storage/ao;
    //   15: getstatic 71	com/tencent/mm/storage/ar$a:VkA	Lcom/tencent/mm/storage/ar$a;
    //   18: getstatic 77	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   21: invokevirtual 83	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   24: aload_2
    //   25: getfield 89	com/tencent/mm/ui/chatting/k/a:fNz	Lcom/tencent/mm/storage/ca;
    //   28: astore 8
    //   30: invokestatic 95	com/tencent/mm/model/cm:bfD	()J
    //   33: aload_2
    //   34: getfield 99	com/tencent/mm/ui/chatting/k/a:WYP	J
    //   37: lsub
    //   38: ldc2_w 100
    //   41: lcmp
    //   42: iflt +79 -> 121
    //   45: ldc 103
    //   47: ldc 105
    //   49: invokestatic 111	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: getfield 115	com/tencent/mm/ui/chatting/d/ar:fgR	Lcom/tencent/mm/ui/chatting/e/a;
    //   56: getfield 121	com/tencent/mm/ui/chatting/e/a:WQv	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   59: invokevirtual 127	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   62: aload_0
    //   63: getfield 115	com/tencent/mm/ui/chatting/d/ar:fgR	Lcom/tencent/mm/ui/chatting/e/a;
    //   66: getfield 121	com/tencent/mm/ui/chatting/e/a:WQv	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   69: invokevirtual 131	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getMMResources	()Landroid/content/res/Resources;
    //   72: getstatic 137	com/tencent/mm/R$l:eIu	I
    //   75: invokevirtual 143	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   78: aload_0
    //   79: getfield 115	com/tencent/mm/ui/chatting/d/ar:fgR	Lcom/tencent/mm/ui/chatting/e/a;
    //   82: getfield 121	com/tencent/mm/ui/chatting/e/a:WQv	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   85: invokevirtual 131	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getMMResources	()Landroid/content/res/Resources;
    //   88: getstatic 146	com/tencent/mm/R$l:app_tip	I
    //   91: invokevirtual 143	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   94: iconst_1
    //   95: invokestatic 152	com/tencent/mm/ui/base/h:c	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/mm/ui/widget/a/d;
    //   98: pop
    //   99: new 12	com/tencent/mm/ui/chatting/d/ar$2
    //   102: dup
    //   103: aload_0
    //   104: aload 8
    //   106: aload_1
    //   107: invokespecial 155	com/tencent/mm/ui/chatting/d/ar$2:<init>	(Lcom/tencent/mm/ui/chatting/d/ar;Lcom/tencent/mm/storage/ca;Landroid/view/View;)V
    //   110: ldc 157
    //   112: invokestatic 163	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   115: ldc 47
    //   117: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: return
    //   121: aload_2
    //   122: getfield 170	com/tencent/mm/ui/chatting/k/a:WYO	Ljava/lang/String;
    //   125: astore_1
    //   126: aload 7
    //   128: astore 6
    //   130: aload_1
    //   131: astore 5
    //   133: aload_2
    //   134: getfield 173	com/tencent/mm/ui/chatting/k/a:mType	I
    //   137: ldc 174
    //   139: if_icmpne +88 -> 227
    //   142: new 176	java/lang/String
    //   145: dup
    //   146: aload_1
    //   147: iconst_0
    //   148: invokestatic 182	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   151: invokespecial 185	java/lang/String:<init>	([B)V
    //   154: ldc 187
    //   156: aconst_null
    //   157: invokestatic 193	com/tencent/mm/sdk/platformtools/XmlParser:parseXml	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   160: astore 5
    //   162: aload 5
    //   164: ifnull +241 -> 405
    //   167: aload 5
    //   169: ldc 195
    //   171: invokeinterface 201 2 0
    //   176: checkcast 176	java/lang/String
    //   179: astore 6
    //   181: aload 5
    //   183: ldc 203
    //   185: invokeinterface 201 2 0
    //   190: checkcast 176	java/lang/String
    //   193: invokestatic 209	com/tencent/mm/sdk/platformtools/Util:safeParseLong	(Ljava/lang/String;)J
    //   196: lstore_3
    //   197: invokestatic 59	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   200: pop
    //   201: invokestatic 213	com/tencent/mm/model/c:bbO	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
    //   204: aload 8
    //   206: getfield 218	com/tencent/mm/f/c/et:field_talker	Ljava/lang/String;
    //   209: lload_3
    //   210: invokeinterface 224 4 0
    //   215: astore 5
    //   217: aload 6
    //   219: astore_1
    //   220: aload 5
    //   222: astore 6
    //   224: aload_1
    //   225: astore 5
    //   227: getstatic 230	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   230: sipush 15037
    //   233: iconst_1
    //   234: anewarray 232	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: iconst_1
    //   240: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   243: aastore
    //   244: invokevirtual 241	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   247: aload_0
    //   248: getfield 115	com/tencent/mm/ui/chatting/d/ar:fgR	Lcom/tencent/mm/ui/chatting/e/a;
    //   251: ldc 243
    //   253: invokevirtual 247	com/tencent/mm/ui/chatting/e/a:bC	(Ljava/lang/Class;)Lcom/tencent/mm/ui/chatting/d/ag;
    //   256: checkcast 243	com/tencent/mm/ui/chatting/d/b/u
    //   259: astore_1
    //   260: aload_1
    //   261: invokeinterface 251 1 0
    //   266: invokevirtual 256	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:hlK	()V
    //   269: aload_1
    //   270: invokeinterface 251 1 0
    //   275: iconst_1
    //   276: invokevirtual 259	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:aqB	(I)V
    //   279: aload_1
    //   280: invokeinterface 251 1 0
    //   285: new 261	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 262	java/lang/StringBuilder:<init>	()V
    //   292: aload_1
    //   293: invokeinterface 251 1 0
    //   298: invokevirtual 266	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getLastText	()Ljava/lang/String;
    //   301: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload 5
    //   306: invokevirtual 270	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokevirtual 277	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:setLastText	(Ljava/lang/String;)V
    //   315: aload_2
    //   316: aload 8
    //   318: aload_1
    //   319: invokeinterface 251 1 0
    //   324: invokestatic 280	com/tencent/mm/ui/chatting/d/ar:a	(Lcom/tencent/mm/ui/chatting/k/a;Lcom/tencent/mm/storage/ca;Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   327: aload 6
    //   329: ifnull +15 -> 344
    //   332: aload_1
    //   333: invokeinterface 251 1 0
    //   338: aload 6
    //   340: invokevirtual 284	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:bm	(Lcom/tencent/mm/storage/ca;)Z
    //   343: pop
    //   344: aload_1
    //   345: invokeinterface 251 1 0
    //   350: getfield 288	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:BSf	Z
    //   353: ifne +12 -> 365
    //   356: aload_1
    //   357: invokeinterface 251 1 0
    //   362: invokevirtual 291	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:showVKB	()V
    //   365: ldc 47
    //   367: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   370: return
    //   371: astore 5
    //   373: ldc 103
    //   375: aload 5
    //   377: ldc_w 293
    //   380: iconst_0
    //   381: anewarray 232	java/lang/Object
    //   384: invokestatic 297	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   387: aload 7
    //   389: astore 6
    //   391: aload_1
    //   392: astore 5
    //   394: goto -167 -> 227
    //   397: astore 5
    //   399: aload 6
    //   401: astore_1
    //   402: goto -29 -> 373
    //   405: aconst_null
    //   406: astore 5
    //   408: goto -188 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	this	ar
    //   0	411	1	paramView	View
    //   0	411	2	parama	com.tencent.mm.ui.chatting.k.a
    //   196	14	3	l	long
    //   131	174	5	localObject1	Object
    //   371	5	5	localThrowable1	Throwable
    //   392	1	5	localView	View
    //   397	1	5	localThrowable2	Throwable
    //   406	1	5	localObject2	Object
    //   128	272	6	localObject3	Object
    //   1	387	7	localObject4	Object
    //   28	289	8	localca	ca
    // Exception table:
    //   from	to	target	type
    //   142	162	371	java/lang/Throwable
    //   167	181	371	java/lang/Throwable
    //   181	217	397	java/lang/Throwable
  }
  
  private void a(View paramView, final LinkedList<String> paramLinkedList, final String paramString)
  {
    AppMethodBeat.i(35515);
    if (this.contextMenuHelper == null) {
      this.contextMenuHelper = new m(this.fgR.WQv.getContext());
    }
    this.contextMenuHelper.b(paramView, new View.OnCreateContextMenuListener()new q.g
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(35510);
        paramAnonymousContextMenu.add(0, 0, 0, paramAnonymousView.getContext().getString(R.l.eRc));
        paramAnonymousContextMenu.add(0, 1, 1, paramAnonymousView.getContext().getString(R.l.eQU));
        AppMethodBeat.o(35510);
      }
    }, new q.g()
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
          ((f)ar.this.fgR.bC(f.class)).b(-1L, paramLinkedList, 0);
          AppMethodBeat.o(35512);
          return;
          paramAnonymousMenuItem = com.tencent.mm.roomsdk.a.b.btX(ar.this.fgR.NKq.field_username).ad(paramString, ar.this.fgR.NKq.field_username);
          paramAnonymousMenuItem.a(ar.this.fgR.WQv.getContext(), ar.this.fgR.WQv.getMMResources().getString(R.l.app_tip), ar.this.fgR.WQv.getMMResources().getString(R.l.eQW), true, true, new DialogInterface.OnCancelListener()
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
  
  private static void a(com.tencent.mm.ui.chatting.k.a parama, ca paramca, ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(286112);
    if ((parama == null) || (paramca == null) || (paramChatFooter == null))
    {
      AppMethodBeat.o(286112);
      return;
    }
    parama = parama.WYQ;
    if (TextUtils.isEmpty(parama))
    {
      AppMethodBeat.o(286112);
      return;
    }
    try
    {
      String str1 = new String(Base64.decode(parama, 0));
      parama = str1;
    }
    catch (Throwable localThrowable)
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
      bh.beI();
      com.tencent.mm.storage.ah localah = com.tencent.mm.model.c.bbV().Rw(paramca.field_talker);
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str3 = arrayOfString[i];
        if (!TextUtils.isEmpty(str3))
        {
          String str2 = AtSomeoneUI.a(localah, str3);
          parama = str2;
          if (Util.isNullOrNil(str2))
          {
            bh.beI();
            as localas = com.tencent.mm.model.c.bbL().bwg(str3);
            parama = str2;
            if (localas != null) {
              parama = localas.ayr();
            }
          }
          if (!TextUtils.isEmpty(parama)) {
            paramChatFooter.be(paramca.field_talker, str3, parama);
          }
        }
        i += 1;
      }
      AppMethodBeat.o(286112);
    }
    if (!Util.isNullOrNil(parama))
    {
      parama = XmlParser.parseXml(parama, "msgsource", null);
      if (parama == null)
      {
        AppMethodBeat.o(286112);
        return;
      }
    }
    label267:
  }
  
  @SuppressLint({"StringFormatMatches"})
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<String> paramLinkedList4, LinkedList<String> paramLinkedList5, ca paramca)
  {
    AppMethodBeat.i(35517);
    Intent localIntent = new Intent(this.fgR.WQv.getContext(), SeeAccessVerifyInfoUI.class);
    localIntent.putExtra("msgLocalId", paramca.field_msgId);
    localIntent.putExtra("msgSvrId", paramca.field_msgSvrId);
    localIntent.putExtra("invitertitle", this.fgR.WQv.getMMResources().getString(R.l.emD, new Object[] { Integer.valueOf(paramLinkedList1.size()) }));
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
    paramString1 = this.fgR;
    paramString2 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramString1, paramString2.aFh(), "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "dealApproveAddChatRoomMember", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString1.startActivity((Intent)paramString2.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramString1, "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "dealApproveAddChatRoomMember", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35517);
  }
  
  private void c(long paramLong, LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(286113);
    if (((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe())
    {
      ((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).ck(paramLinkedList);
      AppMethodBeat.o(286113);
      return;
    }
    ((f)this.fgR.bC(f.class)).b(paramLong, paramLinkedList, paramInt);
    AppMethodBeat.o(286113);
  }
  
  public final void a(long paramLong, LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(286115);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0)) {
      c(paramLong, paramLinkedList, paramInt);
    }
    AppMethodBeat.o(286115);
  }
  
  public final void a(View paramView, b.a parama)
  {
    AppMethodBeat.i(286116);
    if ((paramView != null) && (parama != null))
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(parama.username);
      a(paramView, localLinkedList, parama.link);
    }
    AppMethodBeat.o(286116);
  }
  
  public final void a(final View paramView, ca paramca, final com.tencent.mm.bc.a parama, int paramInt)
  {
    AppMethodBeat.i(35513);
    if ((parama instanceof e))
    {
      paramca = (e)parama;
      parama = Util.nullAsNil(paramca.lWi);
      Log.d("MicroMsg.NewXmlSysMsgComponent", "click delchatroommember link %s,isBizChat:%s", new Object[] { parama, Boolean.valueOf(((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOe()) });
      if (paramca.lWw == null)
      {
        Log.e("MicroMsg.NewXmlSysMsgComponent", "click members is null!!!");
        AppMethodBeat.o(35513);
        return;
      }
      if ((((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOf()) || (this.fgR.hRh())) {}
      for (paramInt = 1; paramInt == 0; paramInt = 0)
      {
        Log.e("MicroMsg.NewXmlSysMsgComponent", "not group chat !!!!!");
        AppMethodBeat.o(35513);
        return;
      }
      if (parama.equals("invite"))
      {
        c(-1L, paramca.lWw, 0);
        AppMethodBeat.o(35513);
        return;
      }
      if (parama.equals("qrcode"))
      {
        a(paramView, paramca.lWw, paramca.fMS);
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama.equals("webview")) && (!Util.isNullOrNil(paramca.url)))
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", paramca.url);
        paramView.putExtra("geta8key_username", z.bcZ());
        com.tencent.mm.by.c.b(this.fgR.WQv.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      }
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.bc.d))
    {
      Object localObject = (com.tencent.mm.bc.d)parama;
      if (paramInt == 0)
      {
        paramView = ((com.tencent.mm.bc.d)localObject).lWt;
        parama = ((com.tencent.mm.bc.d)localObject).lWu;
        String str1 = ((com.tencent.mm.bc.d)localObject).lWn;
        String str2 = ((com.tencent.mm.bc.d)localObject).fAo;
        LinkedList localLinkedList1 = ((com.tencent.mm.bc.d)localObject).lWo;
        LinkedList localLinkedList2 = ((com.tencent.mm.bc.d)localObject).lWr;
        localObject = ((com.tencent.mm.bc.d)localObject).lWs;
        a(paramView, "", "", parama, str1, str2, localLinkedList1, localLinkedList2, new LinkedList(), new LinkedList(), (LinkedList)localObject, paramca);
      }
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.bc.b))
    {
      paramView = (com.tencent.mm.bc.b)parama;
      parama = new ArrayList();
      parama.addAll(paramView.lWo);
      ((f)this.fgR.bC(f.class)).a(parama, paramView.fAo, paramca);
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.ui.chatting.k.a))
    {
      bh.beI();
      if (((Boolean)com.tencent.mm.model.c.aHp().get(ar.a.VkA, Boolean.TRUE)).booleanValue())
      {
        com.tencent.mm.ui.base.h.a(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.eIt), this.fgR.WQv.getMMResources().getString(R.l.tip_title), this.fgR.WQv.getMMResources().getString(R.l.i_know_it), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35507);
            ar.a(ar.this, paramView, (com.tencent.mm.ui.chatting.k.a)parama);
            AppMethodBeat.o(35507);
          }
        });
        AppMethodBeat.o(35513);
        return;
      }
      a(paramView, (com.tencent.mm.ui.chatting.k.a)parama);
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.bc.c))
    {
      Log.i("MicroMsg.NewXmlSysMsgComponent", "handleClickMuteSysText");
      if ((this.fgR.hRh()) && (this.fgR.WQv.getContext() != null)) {
        if (this.fgR.NKq.hDj != 0) {
          break label972;
        }
      }
    }
    label972:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.expt.roomexpt.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.roomexpt.d.class)).nE(bool);
      paramca = new Intent();
      paramca.putExtra("Chat_User", this.fgR.NKq.field_username);
      paramca.putExtra("RoomInfo_Id", this.fgR.getTalkerUserName());
      paramca.putExtra("Is_Chatroom", this.fgR.hRh());
      paramca.putExtra("fromChatting", true);
      paramca.putExtra("isShowSetMuteAnimation", true);
      paramca.setClass(this.fgR.WQv.getContext(), ChatroomInfoUI.class);
      paramView = this.fgR.WQv.getContext();
      paramca = new com.tencent.mm.hellhoundlib.b.a().bm(paramca);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, paramca.aFh(), "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "handleClickMuteSysText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)paramca.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "handleClickMuteSysText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35513);
      return;
      if ((parama instanceof bz))
      {
        ((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOm();
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama instanceof n))
      {
        ((com.tencent.mm.ui.chatting.d.b.d)this.fgR.bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOn();
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama instanceof com.tencent.mm.openim.c.a.b))
      {
        paramView = (com.tencent.mm.openim.c.a.b)parama;
        if (paramInt == 0) {
          a(paramView.lWt, paramView.myx, paramView.myy, paramView.lWu, paramView.lWn, paramView.fAo, paramView.lWo, paramView.lWr, paramView.myv, paramView.myw, paramView.lWs, paramca);
        }
      }
      AppMethodBeat.o(35513);
      return;
    }
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(35520);
    super.hGV();
    this.WMZ = new com.tencent.mm.ui.chatting.p.d(this);
    this.WMY = new com.tencent.mm.ui.chatting.p.b(this);
    this.WMX = new com.tencent.mm.ui.chatting.p.a(this);
    this.WNa = new com.tencent.mm.plugin.messenger.d.a(this);
    this.WNb = new com.tencent.mm.ui.chatting.p.c(this);
    this.WNc = new com.tencent.mm.plugin.selectrecord.e.b(this);
    AppMethodBeat.o(35520);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35521);
    if (this.WMX != null)
    {
      this.WMX.release();
      this.WMX = null;
    }
    if (this.WMY != null)
    {
      this.WMY.release();
      this.WMY = null;
    }
    if (this.WMZ != null)
    {
      this.WMZ.release();
      this.WMZ = null;
    }
    if (this.WNa != null)
    {
      this.WNa.release();
      this.WNa = null;
    }
    if (this.WNb != null)
    {
      this.WNb.release();
      this.WNb = null;
    }
    if (this.WNc != null)
    {
      this.WNc.release();
      this.WNc = null;
    }
    AppMethodBeat.o(35521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ar
 * JD-Core Version:    0.7.0.1
 */