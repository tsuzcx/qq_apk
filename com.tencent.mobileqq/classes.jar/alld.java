import android.view.View.OnClickListener;

class alld
  implements View.OnClickListener
{
  alld(allb paramallb) {}
  
  /* Error */
  public void onClick(android.view.View paramView)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 4
    //   3: aload_0
    //   4: getfield 12	alld:a	Lallb;
    //   7: invokestatic 25	allb:a	(Lallb;)Z
    //   10: ifne +43 -> 53
    //   13: aload_0
    //   14: getfield 12	alld:a	Lallb;
    //   17: invokestatic 28	allb:a	(Lallb;)Landroid/support/v4/app/FragmentActivity;
    //   20: sipush 230
    //   23: ldc 30
    //   25: ldc 31
    //   27: invokestatic 36	amtj:a	(I)Ljava/lang/String;
    //   30: new 38	alle
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 41	alle:<init>	(Lalld;)V
    //   38: aconst_null
    //   39: invokestatic 46	bfur:a	(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   42: invokevirtual 51	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   45: invokestatic 57	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   48: aload_1
    //   49: invokevirtual 60	com/tencent/qqlive/module/videoreport/collect/EventCollector:onViewClicked	(Landroid/view/View;)V
    //   52: return
    //   53: aload_1
    //   54: invokevirtual 66	android/view/View:getTag	()Ljava/lang/Object;
    //   57: astore 8
    //   59: aload 8
    //   61: ifnull -16 -> 45
    //   64: aload 8
    //   66: instanceof 68
    //   69: ifeq -24 -> 45
    //   72: aload_1
    //   73: instanceof 70
    //   76: ifeq +20 -> 96
    //   79: aload_1
    //   80: checkcast 70	android/widget/Button
    //   83: astore 9
    //   85: aload 9
    //   87: ifnull +9 -> 96
    //   90: aload 9
    //   92: iconst_0
    //   93: invokevirtual 74	android/widget/Button:setEnabled	(Z)V
    //   96: aload 8
    //   98: checkcast 68	java/lang/String
    //   101: astore 9
    //   103: aload_0
    //   104: getfield 12	alld:a	Lallb;
    //   107: invokestatic 77	allb:a	(Lallb;)Ljava/lang/String;
    //   110: invokestatic 83	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   113: lstore_2
    //   114: aload 9
    //   116: invokestatic 83	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   119: lstore 6
    //   121: lload 6
    //   123: lstore 4
    //   125: aload_0
    //   126: getfield 12	alld:a	Lallb;
    //   129: invokestatic 86	allb:a	(Lallb;)Ljava/util/ArrayList;
    //   132: aload 9
    //   134: invokevirtual 92	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   137: pop
    //   138: aload_0
    //   139: getfield 12	alld:a	Lallb;
    //   142: invokestatic 95	allb:a	(Lallb;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   145: bipush 20
    //   147: invokevirtual 101	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   150: checkcast 103	anca
    //   153: lload_2
    //   154: lload 4
    //   156: invokevirtual 107	anca:c	(JJ)V
    //   159: aload_0
    //   160: getfield 12	alld:a	Lallb;
    //   163: invokestatic 28	allb:a	(Lallb;)Landroid/support/v4/app/FragmentActivity;
    //   166: ifnull -121 -> 45
    //   169: aload_0
    //   170: getfield 12	alld:a	Lallb;
    //   173: invokestatic 28	allb:a	(Lallb;)Landroid/support/v4/app/FragmentActivity;
    //   176: getfield 113	android/support/v4/app/FragmentActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   179: ldc 115
    //   181: ldc 30
    //   183: ldc 30
    //   185: ldc 30
    //   187: ldc 117
    //   189: iconst_0
    //   190: iconst_0
    //   191: aload 9
    //   193: ldc 30
    //   195: ldc 30
    //   197: ldc 30
    //   199: invokestatic 123	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   202: goto -157 -> 45
    //   205: astore 8
    //   207: lconst_0
    //   208: lstore_2
    //   209: invokestatic 129	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +13 -> 225
    //   215: ldc 131
    //   217: iconst_2
    //   218: ldc 133
    //   220: aload 8
    //   222: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   225: goto -100 -> 125
    //   228: astore 8
    //   230: goto -21 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	alld
    //   0	233	1	paramView	android.view.View
    //   113	96	2	l1	long
    //   1	154	4	l2	long
    //   119	3	6	l3	long
    //   57	40	8	localObject1	Object
    //   205	16	8	localException1	java.lang.Exception
    //   228	1	8	localException2	java.lang.Exception
    //   83	109	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   103	114	205	java/lang/Exception
    //   114	121	228	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alld
 * JD-Core Version:    0.7.0.1
 */