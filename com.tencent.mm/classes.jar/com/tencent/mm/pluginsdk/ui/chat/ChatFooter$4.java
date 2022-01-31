package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View.OnClickListener;

final class ChatFooter$4
  implements View.OnClickListener
{
  ChatFooter$4(ChatFooter paramChatFooter) {}
  
  /* Error */
  public final void onClick(android.view.View paramView)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 27789
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$4:vXU	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   12: invokestatic 30	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:a	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/ui/widget/MMEditText;
    //   15: invokevirtual 36	com/tencent/mm/ui/widget/MMEditText:getText	()Landroid/text/Editable;
    //   18: invokevirtual 40	java/lang/Object:toString	()Ljava/lang/String;
    //   21: astore_1
    //   22: ldc 42
    //   24: ldc 44
    //   26: invokestatic 49	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_1
    //   30: invokevirtual 54	java/lang/String:trim	()Ljava/lang/String;
    //   33: invokevirtual 58	java/lang/String:length	()I
    //   36: ifne +71 -> 107
    //   39: aload_1
    //   40: invokevirtual 58	java/lang/String:length	()I
    //   43: ifeq +64 -> 107
    //   46: ldc 42
    //   48: ldc 60
    //   50: invokestatic 63	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_0
    //   54: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$4:vXU	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   57: invokestatic 67	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:k	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/ui/widget/b/c;
    //   60: ifnull +16 -> 76
    //   63: aload_0
    //   64: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$4:vXU	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   67: invokestatic 67	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:k	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/ui/widget/b/c;
    //   70: invokevirtual 73	com/tencent/mm/ui/widget/b/c:isShowing	()Z
    //   73: ifne +100 -> 173
    //   76: aload_0
    //   77: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$4:vXU	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   80: aload_0
    //   81: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$4:vXU	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   84: invokevirtual 77	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:getContext	()Landroid/content/Context;
    //   87: ldc 78
    //   89: ldc 79
    //   91: invokestatic 85	com/tencent/mm/ui/base/h:h	(Landroid/content/Context;II)Lcom/tencent/mm/ui/widget/b/c;
    //   94: invokestatic 88	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:a	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;Lcom/tencent/mm/ui/widget/b/c;)Lcom/tencent/mm/ui/widget/b/c;
    //   97: pop
    //   98: sipush 27789
    //   101: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_0
    //   105: monitorexit
    //   106: return
    //   107: aload_0
    //   108: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$4:vXU	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   111: aload_1
    //   112: invokevirtual 58	java/lang/String:length	()I
    //   115: invokestatic 94	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:a	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;I)V
    //   118: aload_0
    //   119: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$4:vXU	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   122: invokestatic 97	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:i	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/pluginsdk/ui/chat/b;
    //   125: ifnull +48 -> 173
    //   128: aload_0
    //   129: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$4:vXU	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   132: invokestatic 97	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:i	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/pluginsdk/ui/chat/b;
    //   135: aload_1
    //   136: invokeinterface 103 2 0
    //   141: ifeq +32 -> 173
    //   144: aload_0
    //   145: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$4:vXU	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   148: invokestatic 30	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:a	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/ui/widget/MMEditText;
    //   151: invokevirtual 106	com/tencent/mm/ui/widget/MMEditText:clearComposingText	()V
    //   154: aload_0
    //   155: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$4:vXU	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   158: invokestatic 30	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:a	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)Lcom/tencent/mm/ui/widget/MMEditText;
    //   161: ldc 108
    //   163: invokevirtual 112	com/tencent/mm/ui/widget/MMEditText:setText	(Ljava/lang/CharSequence;)V
    //   166: aload_0
    //   167: getfield 14	com/tencent/mm/pluginsdk/ui/chat/ChatFooter$4:vXU	Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;
    //   170: invokestatic 115	com/tencent/mm/pluginsdk/ui/chat/ChatFooter:l	(Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;)V
    //   173: sipush 27789
    //   176: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: goto -75 -> 104
    //   182: astore_1
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_1
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	4
    //   0	187	1	paramView	android.view.View
    // Exception table:
    //   from	to	target	type
    //   2	76	182	finally
    //   76	104	182	finally
    //   107	173	182	finally
    //   173	179	182	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.4
 * JD-Core Version:    0.7.0.1
 */