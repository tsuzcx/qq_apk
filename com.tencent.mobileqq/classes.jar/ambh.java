import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class ambh
  extends BaseAdapter
{
  int jdField_a_of_type_Int = 1;
  List<bgwe> jdField_a_of_type_JavaUtilList;
  
  public ambh(ambe paramambe) {}
  
  public void a(List<bgwe> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  /* Error */
  public android.view.View getView(int paramInt, android.view.View paramView, android.view.ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	ambh:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4: astore 5
    //   6: aload 5
    //   8: ifnonnull +29 -> 37
    //   11: aload_2
    //   12: astore 5
    //   14: aload_2
    //   15: astore 6
    //   17: aload 5
    //   19: astore_2
    //   20: invokestatic 61	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   23: iload_1
    //   24: aload_2
    //   25: aload_3
    //   26: aload_0
    //   27: iload_1
    //   28: invokevirtual 63	ambh:getItemId	(I)J
    //   31: invokevirtual 67	com/tencent/qqlive/module/videoreport/collect/EventCollector:onListGetView	(ILandroid/view/View;Landroid/view/ViewGroup;J)V
    //   34: aload 6
    //   36: areturn
    //   37: aload_2
    //   38: ifnonnull +501 -> 539
    //   41: new 69	ambi
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 72	ambi:<init>	(Lambh;)V
    //   49: astore 7
    //   51: aload_0
    //   52: getfield 13	ambh:jdField_a_of_type_Ambe	Lambe;
    //   55: getfield 77	ambe:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   58: invokestatic 83	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   61: ldc 84
    //   63: aload_3
    //   64: iconst_0
    //   65: invokevirtual 88	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   68: astore 5
    //   70: aload 5
    //   72: astore_2
    //   73: aload_2
    //   74: astore 5
    //   76: aload 7
    //   78: aload_2
    //   79: ldc 89
    //   81: invokevirtual 95	android/view/View:findViewById	(I)Landroid/view/View;
    //   84: checkcast 97	android/widget/RelativeLayout
    //   87: putfield 100	ambi:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   90: aload_2
    //   91: astore 5
    //   93: aload 7
    //   95: aload_2
    //   96: ldc 101
    //   98: invokevirtual 95	android/view/View:findViewById	(I)Landroid/view/View;
    //   101: checkcast 103	com/tencent/mobileqq/vas/avatar/VasAvatar
    //   104: putfield 106	ambi:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   107: aload_2
    //   108: astore 5
    //   110: aload 7
    //   112: aload_2
    //   113: ldc 107
    //   115: invokevirtual 95	android/view/View:findViewById	(I)Landroid/view/View;
    //   118: checkcast 109	android/widget/ImageView
    //   121: putfield 112	ambi:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   124: aload_2
    //   125: astore 5
    //   127: aload 7
    //   129: aload_2
    //   130: ldc 113
    //   132: invokevirtual 95	android/view/View:findViewById	(I)Landroid/view/View;
    //   135: checkcast 115	android/widget/TextView
    //   138: putfield 118	ambi:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   141: aload_2
    //   142: astore 5
    //   144: aload 7
    //   146: aload_2
    //   147: ldc 119
    //   149: invokevirtual 95	android/view/View:findViewById	(I)Landroid/view/View;
    //   152: checkcast 109	android/widget/ImageView
    //   155: putfield 122	ambi:b	Landroid/widget/ImageView;
    //   158: aload_2
    //   159: astore 5
    //   161: aload 7
    //   163: getfield 100	ambi:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   166: invokevirtual 126	android/widget/RelativeLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   169: astore 6
    //   171: aload 6
    //   173: ifnull +310 -> 483
    //   176: aload_2
    //   177: astore 5
    //   179: aload 6
    //   181: aload_0
    //   182: getfield 13	ambh:jdField_a_of_type_Ambe	Lambe;
    //   185: getfield 129	ambe:g	I
    //   188: putfield 134	android/view/ViewGroup$LayoutParams:width	I
    //   191: aload_2
    //   192: astore 5
    //   194: aload 6
    //   196: aload_0
    //   197: getfield 13	ambh:jdField_a_of_type_Ambe	Lambe;
    //   200: getfield 129	ambe:g	I
    //   203: putfield 137	android/view/ViewGroup$LayoutParams:height	I
    //   206: aload_2
    //   207: astore 5
    //   209: aload 7
    //   211: getfield 100	ambi:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   214: aload 6
    //   216: invokevirtual 141	android/widget/RelativeLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   219: aload_2
    //   220: astore 5
    //   222: aload_2
    //   223: aload 7
    //   225: invokevirtual 145	android/view/View:setTag	(Ljava/lang/Object;)V
    //   228: aload 7
    //   230: astore 6
    //   232: aload_2
    //   233: astore 5
    //   235: aload_0
    //   236: iload_1
    //   237: invokevirtual 147	ambh:getItem	(I)Ljava/lang/Object;
    //   240: checkcast 149	bgwe
    //   243: astore 8
    //   245: aload 8
    //   247: ifnull +345 -> 592
    //   250: aload_2
    //   251: astore 5
    //   253: aload 6
    //   255: getfield 118	ambi:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   258: aload 8
    //   260: getfield 152	bgwe:b	Ljava/lang/String;
    //   263: invokevirtual 156	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   266: aload_2
    //   267: astore 5
    //   269: aload 8
    //   271: getfield 157	bgwe:jdField_a_of_type_Int	I
    //   274: istore 4
    //   276: aload_2
    //   277: astore 5
    //   279: aload 6
    //   281: getfield 106	ambi:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   284: invokevirtual 161	com/tencent/mobileqq/vas/avatar/VasAvatar:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   287: astore 7
    //   289: aload_2
    //   290: astore 5
    //   292: aload 7
    //   294: instanceof 163
    //   297: ifeq +289 -> 586
    //   300: aload_2
    //   301: astore 5
    //   303: aload 7
    //   305: checkcast 163	com/tencent/image/URLDrawable
    //   308: invokevirtual 166	com/tencent/image/URLDrawable:getCurrDrawable	()Landroid/graphics/drawable/Drawable;
    //   311: astore 7
    //   313: aload_2
    //   314: astore 5
    //   316: new 168	bhbe
    //   319: dup
    //   320: iload 4
    //   322: bipush 7
    //   324: ldc 170
    //   326: iconst_1
    //   327: invokespecial 173	bhbe:<init>	(IILjava/lang/String;Z)V
    //   330: astore 9
    //   332: aload_2
    //   333: astore 5
    //   335: aload 9
    //   337: aload 7
    //   339: putfield 176	bhbe:a	Landroid/graphics/drawable/Drawable;
    //   342: aload_2
    //   343: astore 5
    //   345: aload 6
    //   347: getfield 106	ambi:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   350: aconst_null
    //   351: aload 9
    //   353: invokevirtual 180	com/tencent/mobileqq/vas/avatar/VasAvatar:setLoader	(Lcom/tencent/mobileqq/vas/avatar/AvatarLayout;Lbhbe;)V
    //   356: aload_2
    //   357: astore 5
    //   359: aload 6
    //   361: getfield 100	ambi:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   364: aload 8
    //   366: invokevirtual 181	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
    //   369: aload_2
    //   370: astore 5
    //   372: aload_0
    //   373: getfield 13	ambh:jdField_a_of_type_Ambe	Lambe;
    //   376: ldc 183
    //   378: iconst_0
    //   379: invokestatic 189	cooperation/qzone/video/QzoneLiveVideoInterface:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   382: putfield 192	ambe:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   385: aload_2
    //   386: astore 5
    //   388: aload_0
    //   389: getfield 13	ambh:jdField_a_of_type_Ambe	Lambe;
    //   392: aload_0
    //   393: getfield 13	ambh:jdField_a_of_type_Ambe	Lambe;
    //   396: getfield 192	ambe:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   399: ldc 194
    //   401: iconst_0
    //   402: invokeinterface 200 3 0
    //   407: putfield 203	ambe:n	I
    //   410: aload_2
    //   411: astore 5
    //   413: aload_0
    //   414: getfield 13	ambh:jdField_a_of_type_Ambe	Lambe;
    //   417: getfield 203	ambe:n	I
    //   420: aload 8
    //   422: getfield 157	bgwe:jdField_a_of_type_Int	I
    //   425: if_icmpne +126 -> 551
    //   428: aload_2
    //   429: astore 5
    //   431: aload_2
    //   432: aload_0
    //   433: getfield 13	ambh:jdField_a_of_type_Ambe	Lambe;
    //   436: getfield 77	ambe:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   439: invokevirtual 209	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   442: ldc 210
    //   444: invokevirtual 215	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   447: invokevirtual 219	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   450: aload_2
    //   451: astore 5
    //   453: aload 8
    //   455: getfield 157	bgwe:jdField_a_of_type_Int	I
    //   458: aload_0
    //   459: getfield 13	ambh:jdField_a_of_type_Ambe	Lambe;
    //   462: getfield 222	ambe:m	I
    //   465: if_icmpne +100 -> 565
    //   468: aload_2
    //   469: astore 5
    //   471: aload 6
    //   473: getfield 112	ambi:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   476: iconst_0
    //   477: invokevirtual 226	android/widget/ImageView:setVisibility	(I)V
    //   480: goto +112 -> 592
    //   483: aload_2
    //   484: astore 5
    //   486: invokestatic 232	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq +14 -> 503
    //   492: aload_2
    //   493: astore 5
    //   495: ldc 234
    //   497: iconst_2
    //   498: ldc 236
    //   500: invokestatic 240	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   503: aload_2
    //   504: astore 5
    //   506: new 131	android/view/ViewGroup$LayoutParams
    //   509: dup
    //   510: aload_0
    //   511: getfield 13	ambh:jdField_a_of_type_Ambe	Lambe;
    //   514: getfield 129	ambe:g	I
    //   517: aload_0
    //   518: getfield 13	ambh:jdField_a_of_type_Ambe	Lambe;
    //   521: getfield 243	ambe:h	I
    //   524: invokespecial 246	android/view/ViewGroup$LayoutParams:<init>	(II)V
    //   527: astore 6
    //   529: goto -323 -> 206
    //   532: astore_2
    //   533: aload 5
    //   535: astore_2
    //   536: goto +56 -> 592
    //   539: aload_2
    //   540: invokevirtual 250	android/view/View:getTag	()Ljava/lang/Object;
    //   543: checkcast 69	ambi
    //   546: astore 6
    //   548: goto -316 -> 232
    //   551: aload_2
    //   552: astore 5
    //   554: aload_2
    //   555: aconst_null
    //   556: invokevirtual 219	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   559: goto -109 -> 450
    //   562: astore_2
    //   563: aload_2
    //   564: athrow
    //   565: aload_2
    //   566: astore 5
    //   568: aload 6
    //   570: getfield 112	ambi:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   573: bipush 8
    //   575: invokevirtual 226	android/widget/ImageView:setVisibility	(I)V
    //   578: goto +14 -> 592
    //   581: astore 5
    //   583: goto +9 -> 592
    //   586: aconst_null
    //   587: astore 7
    //   589: goto -276 -> 313
    //   592: aload_2
    //   593: astore 5
    //   595: aload 5
    //   597: astore 6
    //   599: goto -579 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	602	0	this	ambh
    //   0	602	1	paramInt	int
    //   0	602	2	paramView	android.view.View
    //   0	602	3	paramViewGroup	android.view.ViewGroup
    //   274	47	4	i	int
    //   4	563	5	localObject1	Object
    //   581	1	5	localThrowable	java.lang.Throwable
    //   593	3	5	localView	android.view.View
    //   15	583	6	localObject2	Object
    //   49	539	7	localObject3	Object
    //   243	211	8	localbgwe	bgwe
    //   330	22	9	localbhbe	bhbe
    // Exception table:
    //   from	to	target	type
    //   76	90	532	java/lang/Throwable
    //   93	107	532	java/lang/Throwable
    //   110	124	532	java/lang/Throwable
    //   127	141	532	java/lang/Throwable
    //   144	158	532	java/lang/Throwable
    //   161	171	532	java/lang/Throwable
    //   179	191	532	java/lang/Throwable
    //   194	206	532	java/lang/Throwable
    //   209	219	532	java/lang/Throwable
    //   222	228	532	java/lang/Throwable
    //   235	245	532	java/lang/Throwable
    //   253	266	532	java/lang/Throwable
    //   269	276	532	java/lang/Throwable
    //   279	289	532	java/lang/Throwable
    //   292	300	532	java/lang/Throwable
    //   303	313	532	java/lang/Throwable
    //   316	332	532	java/lang/Throwable
    //   335	342	532	java/lang/Throwable
    //   345	356	532	java/lang/Throwable
    //   359	369	532	java/lang/Throwable
    //   372	385	532	java/lang/Throwable
    //   388	410	532	java/lang/Throwable
    //   413	428	532	java/lang/Throwable
    //   431	450	532	java/lang/Throwable
    //   453	468	532	java/lang/Throwable
    //   471	480	532	java/lang/Throwable
    //   486	492	532	java/lang/Throwable
    //   495	503	532	java/lang/Throwable
    //   506	529	532	java/lang/Throwable
    //   554	559	532	java/lang/Throwable
    //   568	578	532	java/lang/Throwable
    //   0	6	562	finally
    //   41	70	562	finally
    //   76	90	562	finally
    //   93	107	562	finally
    //   110	124	562	finally
    //   127	141	562	finally
    //   144	158	562	finally
    //   161	171	562	finally
    //   179	191	562	finally
    //   194	206	562	finally
    //   209	219	562	finally
    //   222	228	562	finally
    //   235	245	562	finally
    //   253	266	562	finally
    //   269	276	562	finally
    //   279	289	562	finally
    //   292	300	562	finally
    //   303	313	562	finally
    //   316	332	562	finally
    //   335	342	562	finally
    //   345	356	562	finally
    //   359	369	562	finally
    //   372	385	562	finally
    //   388	410	562	finally
    //   413	428	562	finally
    //   431	450	562	finally
    //   453	468	562	finally
    //   471	480	562	finally
    //   486	492	562	finally
    //   495	503	562	finally
    //   506	529	562	finally
    //   539	548	562	finally
    //   554	559	562	finally
    //   568	578	562	finally
    //   0	6	581	java/lang/Throwable
    //   41	70	581	java/lang/Throwable
    //   539	548	581	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambh
 * JD-Core Version:    0.7.0.1
 */