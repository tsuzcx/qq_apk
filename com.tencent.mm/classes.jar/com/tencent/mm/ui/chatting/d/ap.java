package com.tencent.mm.ui.chatting.d;

import android.annotation.SuppressLint;
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
import com.tencent.mm.az.e;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.by;
import com.tencent.mm.model.n;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.messenger.d.b.a;
import com.tencent.mm.plugin.messenger.d.b.b;
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
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.chatting.AtSomeoneUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.chatting.d.a.a(gRF=com.tencent.mm.ui.chatting.d.b.ah.class)
public class ap
  extends a
  implements b.b, com.tencent.mm.ui.chatting.d.b.ah
{
  private com.tencent.mm.ui.chatting.o.c PsA;
  private com.tencent.mm.plugin.selectrecord.e.b PsB;
  private com.tencent.mm.ui.chatting.o.a Psw;
  private com.tencent.mm.ui.chatting.o.b Psx;
  private com.tencent.mm.ui.chatting.o.d Psy;
  private com.tencent.mm.plugin.messenger.c.a Psz;
  private l contextMenuHelper;
  
  /* Error */
  private void a(final View paramView, com.tencent.mm.ui.chatting.j.a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc 45
    //   5: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 57	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   11: pop
    //   12: invokestatic 63	com/tencent/mm/model/c:azQ	()Lcom/tencent/mm/storage/ao;
    //   15: getstatic 69	com/tencent/mm/storage/ar$a:NWA	Lcom/tencent/mm/storage/ar$a;
    //   18: getstatic 75	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   21: invokevirtual 81	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   24: aload_2
    //   25: getfield 87	com/tencent/mm/ui/chatting/j/a:dTX	Lcom/tencent/mm/storage/ca;
    //   28: astore 8
    //   30: invokestatic 93	com/tencent/mm/model/cl:aWz	()J
    //   33: aload_2
    //   34: getfield 97	com/tencent/mm/ui/chatting/j/a:PEc	J
    //   37: lsub
    //   38: ldc2_w 98
    //   41: lcmp
    //   42: iflt +77 -> 119
    //   45: ldc 101
    //   47: ldc 103
    //   49: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_0
    //   53: getfield 113	com/tencent/mm/ui/chatting/d/ap:dom	Lcom/tencent/mm/ui/chatting/e/a;
    //   56: getfield 119	com/tencent/mm/ui/chatting/e/a:Pwc	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   59: invokevirtual 125	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getContext	()Landroid/app/Activity;
    //   62: aload_0
    //   63: getfield 113	com/tencent/mm/ui/chatting/d/ap:dom	Lcom/tencent/mm/ui/chatting/e/a;
    //   66: getfield 119	com/tencent/mm/ui/chatting/e/a:Pwc	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   69: invokevirtual 129	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getMMResources	()Landroid/content/res/Resources;
    //   72: ldc 130
    //   74: invokevirtual 136	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   77: aload_0
    //   78: getfield 113	com/tencent/mm/ui/chatting/d/ap:dom	Lcom/tencent/mm/ui/chatting/e/a;
    //   81: getfield 119	com/tencent/mm/ui/chatting/e/a:Pwc	Lcom/tencent/mm/ui/chatting/BaseChattingUIFragment;
    //   84: invokevirtual 129	com/tencent/mm/ui/chatting/BaseChattingUIFragment:getMMResources	()Landroid/content/res/Resources;
    //   87: ldc 137
    //   89: invokevirtual 136	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   92: iconst_1
    //   93: invokestatic 143	com/tencent/mm/ui/base/h:c	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/mm/ui/widget/a/d;
    //   96: pop
    //   97: new 12	com/tencent/mm/ui/chatting/d/ap$2
    //   100: dup
    //   101: aload_0
    //   102: aload 8
    //   104: aload_1
    //   105: invokespecial 146	com/tencent/mm/ui/chatting/d/ap$2:<init>	(Lcom/tencent/mm/ui/chatting/d/ap;Lcom/tencent/mm/storage/ca;Landroid/view/View;)V
    //   108: ldc 148
    //   110: invokestatic 154	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   113: ldc 45
    //   115: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: return
    //   119: aload_2
    //   120: getfield 161	com/tencent/mm/ui/chatting/j/a:PEb	Ljava/lang/String;
    //   123: astore_1
    //   124: aload 7
    //   126: astore 6
    //   128: aload_1
    //   129: astore 5
    //   131: aload_2
    //   132: getfield 165	com/tencent/mm/ui/chatting/j/a:mType	I
    //   135: ldc 166
    //   137: if_icmpne +88 -> 225
    //   140: new 168	java/lang/String
    //   143: dup
    //   144: aload_1
    //   145: iconst_0
    //   146: invokestatic 174	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   149: invokespecial 177	java/lang/String:<init>	([B)V
    //   152: ldc 179
    //   154: aconst_null
    //   155: invokestatic 185	com/tencent/mm/sdk/platformtools/XmlParser:parseXml	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   158: astore 5
    //   160: aload 5
    //   162: ifnull +241 -> 403
    //   165: aload 5
    //   167: ldc 187
    //   169: invokeinterface 193 2 0
    //   174: checkcast 168	java/lang/String
    //   177: astore 6
    //   179: aload 5
    //   181: ldc 195
    //   183: invokeinterface 193 2 0
    //   188: checkcast 168	java/lang/String
    //   191: invokestatic 201	com/tencent/mm/sdk/platformtools/Util:safeParseLong	(Ljava/lang/String;)J
    //   194: lstore_3
    //   195: invokestatic 57	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   198: pop
    //   199: invokestatic 205	com/tencent/mm/model/c:aSQ	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
    //   202: aload 8
    //   204: getfield 210	com/tencent/mm/g/c/eo:field_talker	Ljava/lang/String;
    //   207: lload_3
    //   208: invokeinterface 216 4 0
    //   213: astore 5
    //   215: aload 6
    //   217: astore_1
    //   218: aload 5
    //   220: astore 6
    //   222: aload_1
    //   223: astore 5
    //   225: getstatic 222	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   228: sipush 15037
    //   231: iconst_1
    //   232: anewarray 224	java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: iconst_1
    //   238: invokestatic 230	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   241: aastore
    //   242: invokevirtual 233	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   245: aload_0
    //   246: getfield 113	com/tencent/mm/ui/chatting/d/ap:dom	Lcom/tencent/mm/ui/chatting/e/a;
    //   249: ldc 235
    //   251: invokevirtual 239	com/tencent/mm/ui/chatting/e/a:bh	(Ljava/lang/Class;)Lcom/tencent/mm/ui/chatting/d/af;
    //   254: checkcast 235	com/tencent/mm/ui/chatting/d/b/u
    //   257: astore_1
    //   258: aload_1
    //   259: invokeinterface 243 1 0
    //   264: invokevirtual 248	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:gqL	()V
    //   267: aload_1
    //   268: invokeinterface 243 1 0
    //   273: iconst_1
    //   274: invokevirtual 251	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:aiz	(I)V
    //   277: aload_1
    //   278: invokeinterface 243 1 0
    //   283: new 253	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   290: aload_1
    //   291: invokeinterface 243 1 0
    //   296: invokevirtual 258	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getLastText	()Ljava/lang/String;
    //   299: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload 5
    //   304: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokevirtual 269	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:setLastText	(Ljava/lang/String;)V
    //   313: aload_2
    //   314: aload 8
    //   316: aload_1
    //   317: invokeinterface 243 1 0
    //   322: invokestatic 272	com/tencent/mm/ui/chatting/d/ap:a	(Lcom/tencent/mm/ui/chatting/j/a;Lcom/tencent/mm/storage/ca;Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   325: aload 6
    //   327: ifnull +15 -> 342
    //   330: aload_1
    //   331: invokeinterface 243 1 0
    //   336: aload 6
    //   338: invokevirtual 276	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:aT	(Lcom/tencent/mm/storage/ca;)Z
    //   341: pop
    //   342: aload_1
    //   343: invokeinterface 243 1 0
    //   348: getfield 280	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:xfU	Z
    //   351: ifne +12 -> 363
    //   354: aload_1
    //   355: invokeinterface 243 1 0
    //   360: invokevirtual 283	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:showVKB	()V
    //   363: ldc 45
    //   365: invokestatic 157	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: return
    //   369: astore 5
    //   371: ldc 101
    //   373: aload 5
    //   375: ldc_w 285
    //   378: iconst_0
    //   379: anewarray 224	java/lang/Object
    //   382: invokestatic 289	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   385: aload 7
    //   387: astore 6
    //   389: aload_1
    //   390: astore 5
    //   392: goto -167 -> 225
    //   395: astore 5
    //   397: aload 6
    //   399: astore_1
    //   400: goto -29 -> 371
    //   403: aconst_null
    //   404: astore 5
    //   406: goto -188 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	this	ap
    //   0	409	1	paramView	View
    //   0	409	2	parama	com.tencent.mm.ui.chatting.j.a
    //   194	14	3	l	long
    //   129	174	5	localObject1	Object
    //   369	5	5	localThrowable1	Throwable
    //   390	1	5	localView	View
    //   395	1	5	localThrowable2	Throwable
    //   404	1	5	localObject2	Object
    //   126	272	6	localObject3	Object
    //   1	385	7	localObject4	Object
    //   28	287	8	localca	ca
    // Exception table:
    //   from	to	target	type
    //   140	160	369	java/lang/Throwable
    //   165	179	369	java/lang/Throwable
    //   179	215	395	java/lang/Throwable
  }
  
  private void a(View paramView, final LinkedList<String> paramLinkedList, final String paramString)
  {
    AppMethodBeat.i(35515);
    if (this.contextMenuHelper == null) {
      this.contextMenuHelper = new l(this.dom.Pwc.getContext());
    }
    this.contextMenuHelper.b(paramView, new ap.3(this), new o.g()
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
          ((f)ap.this.dom.bh(f.class)).b(-1L, paramLinkedList, 0);
          AppMethodBeat.o(35512);
          return;
          paramAnonymousMenuItem = com.tencent.mm.roomsdk.a.b.bhF(ap.this.dom.GUe.field_username).Z(paramString, ap.this.dom.GUe.field_username);
          paramAnonymousMenuItem.a(ap.this.dom.Pwc.getContext(), ap.this.dom.Pwc.getMMResources().getString(2131755998), ap.this.dom.Pwc.getMMResources().getString(2131764685), true, true, new DialogInterface.OnCancelListener()
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
  
  private static void a(com.tencent.mm.ui.chatting.j.a parama, ca paramca, ChatFooter paramChatFooter)
  {
    AppMethodBeat.i(233145);
    if ((parama == null) || (paramca == null) || (paramChatFooter == null))
    {
      AppMethodBeat.o(233145);
      return;
    }
    parama = parama.PEd;
    if (TextUtils.isEmpty(parama))
    {
      AppMethodBeat.o(233145);
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
      bg.aVF();
      com.tencent.mm.storage.ah localah = com.tencent.mm.model.c.aSX().Kd(paramca.field_talker);
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
            bg.aVF();
            as localas = com.tencent.mm.model.c.aSN().bjJ(str3);
            parama = str2;
            if (localas != null) {
              parama = localas.arI();
            }
          }
          if (!TextUtils.isEmpty(parama)) {
            paramChatFooter.bj(paramca.field_talker, str3, parama);
          }
        }
        i += 1;
      }
      AppMethodBeat.o(233145);
    }
    if (!Util.isNullOrNil(parama))
    {
      parama = XmlParser.parseXml(parama, "msgsource", null);
      if (parama == null)
      {
        AppMethodBeat.o(233145);
        return;
      }
    }
    label267:
  }
  
  @SuppressLint({"StringFormatMatches"})
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LinkedList<String> paramLinkedList1, LinkedList<String> paramLinkedList2, LinkedList<String> paramLinkedList3, LinkedList<String> paramLinkedList4, LinkedList<String> paramLinkedList5, ca paramca)
  {
    AppMethodBeat.i(35517);
    Intent localIntent = new Intent(this.dom.Pwc.getContext(), SeeAccessVerifyInfoUI.class);
    localIntent.putExtra("msgLocalId", paramca.field_msgId);
    localIntent.putExtra("msgSvrId", paramca.field_msgSvrId);
    localIntent.putExtra("invitertitle", this.dom.Pwc.getMMResources().getString(2131755132, new Object[] { Integer.valueOf(paramLinkedList1.size()) }));
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
    paramString1 = this.dom;
    paramString2 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramString1, paramString2.axQ(), "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "dealApproveAddChatRoomMember", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString1.startActivity((Intent)paramString2.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString1, "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "dealApproveAddChatRoomMember", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Ljava/util/LinkedList;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35517);
  }
  
  private void c(long paramLong, LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(233146);
    if (((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP())
    {
      ((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).bL(paramLinkedList);
      AppMethodBeat.o(233146);
      return;
    }
    ((f)this.dom.bh(f.class)).b(paramLong, paramLinkedList, paramInt);
    AppMethodBeat.o(233146);
  }
  
  public final void a(long paramLong, LinkedList<String> paramLinkedList, int paramInt)
  {
    AppMethodBeat.i(233147);
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0)) {
      c(paramLong, paramLinkedList, paramInt);
    }
    AppMethodBeat.o(233147);
  }
  
  public final void a(View paramView, b.a parama)
  {
    AppMethodBeat.i(233148);
    if ((paramView != null) && (parama != null))
    {
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(parama.username);
      a(paramView, localLinkedList, parama.link);
    }
    AppMethodBeat.o(233148);
  }
  
  public final void a(final View paramView, ca paramca, final com.tencent.mm.az.a parama, int paramInt)
  {
    AppMethodBeat.i(35513);
    if ((parama instanceof e))
    {
      paramca = (e)parama;
      parama = Util.nullAsNil(paramca.jfH);
      Log.d("MicroMsg.NewXmlSysMsgComponent", "click delchatroommember link %s,isBizChat:%s", new Object[] { parama, Boolean.valueOf(((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()) });
      if (paramca.jfV == null)
      {
        Log.e("MicroMsg.NewXmlSysMsgComponent", "click members is null!!!");
        AppMethodBeat.o(35513);
        return;
      }
      if ((((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOQ()) || (this.dom.gRL())) {}
      for (paramInt = 1; paramInt == 0; paramInt = 0)
      {
        Log.e("MicroMsg.NewXmlSysMsgComponent", "not group chat !!!!!");
        AppMethodBeat.o(35513);
        return;
      }
      if (parama.equals("invite"))
      {
        c(-1L, paramca.jfV, 0);
        AppMethodBeat.o(35513);
        return;
      }
      if (parama.equals("qrcode"))
      {
        a(paramView, paramca.jfV, paramca.dTx);
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama.equals("webview")) && (!Util.isNullOrNil(paramca.url)))
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", paramca.url);
        paramView.putExtra("geta8key_username", z.aTY());
        com.tencent.mm.br.c.b(this.dom.Pwc.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
      }
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.az.d))
    {
      Object localObject = (com.tencent.mm.az.d)parama;
      if (paramInt == 0)
      {
        paramView = ((com.tencent.mm.az.d)localObject).jfS;
        parama = ((com.tencent.mm.az.d)localObject).jfT;
        String str1 = ((com.tencent.mm.az.d)localObject).jfM;
        String str2 = ((com.tencent.mm.az.d)localObject).dHx;
        LinkedList localLinkedList1 = ((com.tencent.mm.az.d)localObject).jfN;
        LinkedList localLinkedList2 = ((com.tencent.mm.az.d)localObject).jfQ;
        localObject = ((com.tencent.mm.az.d)localObject).jfR;
        a(paramView, "", "", parama, str1, str2, localLinkedList1, localLinkedList2, new LinkedList(), new LinkedList(), (LinkedList)localObject, paramca);
      }
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.az.b))
    {
      paramView = (com.tencent.mm.az.b)parama;
      parama = new ArrayList();
      parama.addAll(paramView.jfN);
      ((f)this.dom.bh(f.class)).a(parama, paramView.dHx, paramca);
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.ui.chatting.j.a))
    {
      bg.aVF();
      if (((Boolean)com.tencent.mm.model.c.azQ().get(ar.a.NWA, Boolean.TRUE)).booleanValue())
      {
        h.a(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131761863), this.dom.Pwc.getMMResources().getString(2131766783), this.dom.Pwc.getMMResources().getString(2131761757), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(35507);
            ap.a(ap.this, paramView, (com.tencent.mm.ui.chatting.j.a)parama);
            AppMethodBeat.o(35507);
          }
        });
        AppMethodBeat.o(35513);
        return;
      }
      a(paramView, (com.tencent.mm.ui.chatting.j.a)parama);
      AppMethodBeat.o(35513);
      return;
    }
    if ((parama instanceof com.tencent.mm.az.c))
    {
      Log.i("MicroMsg.NewXmlSysMsgComponent", "handleClickMuteSysText");
      if ((this.dom.gRL()) && (this.dom.Pwc.getContext() != null)) {
        if (this.dom.GUe.fuH != 0) {
          break label972;
        }
      }
    }
    label972:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.expt.roomexpt.d)g.af(com.tencent.mm.plugin.expt.roomexpt.d.class)).mr(bool);
      paramca = new Intent();
      paramca.putExtra("Chat_User", this.dom.GUe.field_username);
      paramca.putExtra("RoomInfo_Id", this.dom.getTalkerUserName());
      paramca.putExtra("Is_Chatroom", this.dom.gRL());
      paramca.putExtra("fromChatting", true);
      paramca.putExtra("isShowSetMuteAnimation", true);
      paramca.setClass(this.dom.Pwc.getContext(), ChatroomInfoUI.class);
      paramView = this.dom.Pwc.getContext();
      paramca = new com.tencent.mm.hellhoundlib.b.a().bl(paramca);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramca.axQ(), "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "handleClickMuteSysText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)paramca.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/component/NewXmlSysMsgComponent", "handleClickMuteSysText", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35513);
      return;
      if ((parama instanceof by))
      {
        ((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOW();
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama instanceof n))
      {
        ((com.tencent.mm.ui.chatting.d.b.d)this.dom.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOX();
        AppMethodBeat.o(35513);
        return;
      }
      if ((parama instanceof com.tencent.mm.openim.c.a.b))
      {
        paramView = (com.tencent.mm.openim.c.a.b)parama;
        if (paramInt == 0) {
          a(paramView.jfS, paramView.jHt, paramView.jHu, paramView.jfT, paramView.jfM, paramView.dHx, paramView.jfN, paramView.jfQ, paramView.jHr, paramView.jHs, paramView.jfR, paramca);
        }
      }
      AppMethodBeat.o(35513);
      return;
    }
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(35520);
    super.gIl();
    this.Psy = new com.tencent.mm.ui.chatting.o.d(this);
    this.Psx = new com.tencent.mm.ui.chatting.o.b(this);
    this.Psw = new com.tencent.mm.ui.chatting.o.a(this);
    this.Psz = new com.tencent.mm.plugin.messenger.c.a(this);
    this.PsA = new com.tencent.mm.ui.chatting.o.c(this);
    this.PsB = new com.tencent.mm.plugin.selectrecord.e.b(this);
    AppMethodBeat.o(35520);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35521);
    if (this.Psw != null)
    {
      this.Psw.release();
      this.Psw = null;
    }
    if (this.Psx != null)
    {
      this.Psx.release();
      this.Psx = null;
    }
    if (this.Psy != null)
    {
      this.Psy.release();
      this.Psy = null;
    }
    if (this.Psz != null)
    {
      this.Psz.release();
      this.Psz = null;
    }
    if (this.PsA != null)
    {
      this.PsA.release();
      this.PsA = null;
    }
    if (this.PsB != null)
    {
      this.PsB.release();
      this.PsB = null;
    }
    AppMethodBeat.o(35521);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ap
 * JD-Core Version:    0.7.0.1
 */