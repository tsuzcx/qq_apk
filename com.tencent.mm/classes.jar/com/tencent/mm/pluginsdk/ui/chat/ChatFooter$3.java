package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View.OnClickListener;

final class ChatFooter$3
  implements View.OnClickListener
{
  ChatFooter$3(ChatFooter paramChatFooter) {}
  
  /* Error */
  public final void onClick(android.view.View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$3:sgd	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   6: invokestatic 24	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:a	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/ui/widget/MMEditText;
    //   9: invokevirtual 30	com/tencent/mm/ui/widget/MMEditText:getText	()Landroid/text/Editable;
    //   12: invokevirtual 34	java/lang/Object:toString	()Ljava/lang/String;
    //   15: astore_1
    //   16: ldc 36
    //   18: ldc 38
    //   20: invokestatic 44	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_1
    //   24: invokevirtual 49	java/lang/String:trim	()Ljava/lang/String;
    //   27: invokevirtual 53	java/lang/String:length	()I
    //   30: ifne +67 -> 97
    //   33: aload_1
    //   34: invokevirtual 53	java/lang/String:length	()I
    //   37: ifeq +60 -> 97
    //   40: ldc 36
    //   42: ldc 55
    //   44: invokestatic 44	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_0
    //   48: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$3:sgd	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   51: invokestatic 59	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:l	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/ui/widget/a/c;
    //   54: ifnull +16 -> 70
    //   57: aload_0
    //   58: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$3:sgd	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   61: invokestatic 59	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:l	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/ui/widget/a/c;
    //   64: invokevirtual 65	com/tencent/mm/ui/widget/a/c:isShowing	()Z
    //   67: ifne +27 -> 94
    //   70: aload_0
    //   71: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$3:sgd	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   74: aload_0
    //   75: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$3:sgd	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   78: invokevirtual 69	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   81: getstatic 75	com/tencent/mm/R$l:chatting_empty_message_cant_be_sent	I
    //   84: getstatic 78	com/tencent/mm/R$l:app_tip	I
    //   87: invokestatic 84	com/tencent/mm/ui/base/h:h	(Landroid/content/Context;II)Lcom/tencent/mm/ui/widget/a/c;
    //   90: invokestatic 87	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:a	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;Lcom/tencent/mm/ui/widget/a/c;)Lcom/tencent/mm/ui/widget/a/c;
    //   93: pop
    //   94: aload_0
    //   95: monitorexit
    //   96: return
    //   97: aload_0
    //   98: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$3:sgd	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   101: aload_1
    //   102: invokevirtual 53	java/lang/String:length	()I
    //   105: invokestatic 91	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:b	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;I)V
    //   108: aload_0
    //   109: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$3:sgd	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   112: invokestatic 95	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:j	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/pluginsdk/ui/chat/b;
    //   115: ifnull -21 -> 94
    //   118: aload_0
    //   119: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$3:sgd	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   122: invokestatic 95	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:j	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/pluginsdk/ui/chat/b;
    //   125: aload_1
    //   126: invokeinterface 101 2 0
    //   131: ifeq -37 -> 94
    //   134: aload_0
    //   135: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$3:sgd	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   138: invokestatic 24	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:a	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/ui/widget/MMEditText;
    //   141: invokevirtual 104	com/tencent/mm/ui/widget/MMEditText:clearComposingText	()V
    //   144: aload_0
    //   145: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$3:sgd	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   148: invokestatic 24	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:a	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/ui/widget/MMEditText;
    //   151: ldc 106
    //   153: invokevirtual 110	com/tencent/mm/ui/widget/MMEditText:setText	(Ljava/lang/CharSequence;)V
    //   156: aload_0
    //   157: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$3:sgd	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   160: invokestatic 113	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:m	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   163: goto -69 -> 94
    //   166: astore_1
    //   167: aload_0
    //   168: monitorexit
    //   169: aload_1
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	3
    //   0	171	1	paramView	android.view.View
    // Exception table:
    //   from	to	target	type
    //   2	70	166	finally
    //   70	94	166	finally
    //   97	163	166	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.3
 * JD-Core Version:    0.7.0.1
 */