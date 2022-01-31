import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public class ahyr
  extends BaseAdapter
{
  int jdField_a_of_type_Int = 1;
  List<balr> jdField_a_of_type_JavaUtilList;
  
  public ahyr(ahyo paramahyo) {}
  
  public void a(List<balr> paramList)
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
    //   1: getfield 22	ahyr:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   4: ifnonnull +5 -> 9
    //   7: aload_2
    //   8: areturn
    //   9: aload_2
    //   10: ifnonnull +467 -> 477
    //   13: new 57	ahys
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 60	ahys:<init>	(Lahyr;)V
    //   21: astore 5
    //   23: aload_0
    //   24: getfield 13	ahyr:jdField_a_of_type_Ahyo	Lahyo;
    //   27: getfield 65	ahyo:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   30: invokestatic 71	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   33: ldc 72
    //   35: aload_3
    //   36: iconst_0
    //   37: invokevirtual 76	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   40: astore_3
    //   41: aload_3
    //   42: astore_2
    //   43: aload_2
    //   44: astore_3
    //   45: aload 5
    //   47: aload_2
    //   48: ldc 77
    //   50: invokevirtual 83	android/view/View:findViewById	(I)Landroid/view/View;
    //   53: checkcast 85	android/widget/RelativeLayout
    //   56: putfield 88	ahys:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   59: aload_2
    //   60: astore_3
    //   61: aload 5
    //   63: aload_2
    //   64: ldc 89
    //   66: invokevirtual 83	android/view/View:findViewById	(I)Landroid/view/View;
    //   69: checkcast 91	com/tencent/mobileqq/vas/avatar/VasAvatar
    //   72: putfield 94	ahys:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   75: aload_2
    //   76: astore_3
    //   77: aload 5
    //   79: aload_2
    //   80: ldc 95
    //   82: invokevirtual 83	android/view/View:findViewById	(I)Landroid/view/View;
    //   85: checkcast 97	android/widget/ImageView
    //   88: putfield 100	ahys:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   91: aload_2
    //   92: astore_3
    //   93: aload 5
    //   95: aload_2
    //   96: ldc 101
    //   98: invokevirtual 83	android/view/View:findViewById	(I)Landroid/view/View;
    //   101: checkcast 103	android/widget/TextView
    //   104: putfield 106	ahys:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   107: aload_2
    //   108: astore_3
    //   109: aload 5
    //   111: aload_2
    //   112: ldc 107
    //   114: invokevirtual 83	android/view/View:findViewById	(I)Landroid/view/View;
    //   117: checkcast 97	android/widget/ImageView
    //   120: putfield 110	ahys:b	Landroid/widget/ImageView;
    //   123: aload_2
    //   124: astore_3
    //   125: aload 5
    //   127: getfield 88	ahys:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   130: invokevirtual 114	android/widget/RelativeLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   133: astore 4
    //   135: aload 4
    //   137: ifnull +288 -> 425
    //   140: aload_2
    //   141: astore_3
    //   142: aload 4
    //   144: aload_0
    //   145: getfield 13	ahyr:jdField_a_of_type_Ahyo	Lahyo;
    //   148: getfield 117	ahyo:g	I
    //   151: putfield 122	android/view/ViewGroup$LayoutParams:width	I
    //   154: aload_2
    //   155: astore_3
    //   156: aload 4
    //   158: aload_0
    //   159: getfield 13	ahyr:jdField_a_of_type_Ahyo	Lahyo;
    //   162: getfield 117	ahyo:g	I
    //   165: putfield 125	android/view/ViewGroup$LayoutParams:height	I
    //   168: aload_2
    //   169: astore_3
    //   170: aload 5
    //   172: getfield 88	ahys:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   175: aload 4
    //   177: invokevirtual 129	android/widget/RelativeLayout:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   180: aload_2
    //   181: astore_3
    //   182: aload_2
    //   183: aload 5
    //   185: invokevirtual 133	android/view/View:setTag	(Ljava/lang/Object;)V
    //   188: aload 5
    //   190: astore 4
    //   192: aload_2
    //   193: astore_3
    //   194: aload_0
    //   195: iload_1
    //   196: invokevirtual 135	ahyr:getItem	(I)Ljava/lang/Object;
    //   199: checkcast 137	balr
    //   202: astore 6
    //   204: aload 6
    //   206: ifnull +321 -> 527
    //   209: aload_2
    //   210: astore_3
    //   211: aload 4
    //   213: getfield 106	ahys:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   216: aload 6
    //   218: getfield 140	balr:b	Ljava/lang/String;
    //   221: invokevirtual 144	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   224: aload_2
    //   225: astore_3
    //   226: aload 6
    //   228: getfield 145	balr:jdField_a_of_type_Int	I
    //   231: istore_1
    //   232: aload_2
    //   233: astore_3
    //   234: aload 4
    //   236: getfield 94	ahys:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   239: invokevirtual 149	com/tencent/mobileqq/vas/avatar/VasAvatar:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   242: astore 5
    //   244: aload_2
    //   245: astore_3
    //   246: aload 5
    //   248: instanceof 151
    //   251: ifeq +270 -> 521
    //   254: aload_2
    //   255: astore_3
    //   256: aload 5
    //   258: checkcast 151	com/tencent/image/URLDrawable
    //   261: invokevirtual 154	com/tencent/image/URLDrawable:getCurrDrawable	()Landroid/graphics/drawable/Drawable;
    //   264: astore 5
    //   266: aload_2
    //   267: astore_3
    //   268: new 156	baqk
    //   271: dup
    //   272: iload_1
    //   273: bipush 7
    //   275: ldc 158
    //   277: iconst_1
    //   278: invokespecial 161	baqk:<init>	(IILjava/lang/String;Z)V
    //   281: astore 7
    //   283: aload_2
    //   284: astore_3
    //   285: aload 7
    //   287: aload 5
    //   289: putfield 164	baqk:a	Landroid/graphics/drawable/Drawable;
    //   292: aload_2
    //   293: astore_3
    //   294: aload 4
    //   296: getfield 94	ahys:jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar	Lcom/tencent/mobileqq/vas/avatar/VasAvatar;
    //   299: aconst_null
    //   300: aload 7
    //   302: invokevirtual 168	com/tencent/mobileqq/vas/avatar/VasAvatar:setLoader	(Lcom/tencent/mobileqq/vas/avatar/AvatarLayout;Lbaqk;)V
    //   305: aload_2
    //   306: astore_3
    //   307: aload 4
    //   309: getfield 88	ahys:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   312: aload 6
    //   314: invokevirtual 169	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
    //   317: aload_2
    //   318: astore_3
    //   319: aload_0
    //   320: getfield 13	ahyr:jdField_a_of_type_Ahyo	Lahyo;
    //   323: ldc 171
    //   325: iconst_0
    //   326: invokestatic 177	cooperation/qzone/video/QzoneLiveVideoInterface:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   329: putfield 180	ahyo:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   332: aload_2
    //   333: astore_3
    //   334: aload_0
    //   335: getfield 13	ahyr:jdField_a_of_type_Ahyo	Lahyo;
    //   338: aload_0
    //   339: getfield 13	ahyr:jdField_a_of_type_Ahyo	Lahyo;
    //   342: getfield 180	ahyo:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   345: ldc 182
    //   347: iconst_0
    //   348: invokeinterface 188 3 0
    //   353: putfield 191	ahyo:n	I
    //   356: aload_2
    //   357: astore_3
    //   358: aload_0
    //   359: getfield 13	ahyr:jdField_a_of_type_Ahyo	Lahyo;
    //   362: getfield 191	ahyo:n	I
    //   365: aload 6
    //   367: getfield 145	balr:jdField_a_of_type_Int	I
    //   370: if_icmpne +119 -> 489
    //   373: aload_2
    //   374: astore_3
    //   375: aload_2
    //   376: aload_0
    //   377: getfield 13	ahyr:jdField_a_of_type_Ahyo	Lahyo;
    //   380: getfield 65	ahyo:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   383: invokevirtual 197	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   386: ldc 198
    //   388: invokevirtual 203	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   391: invokevirtual 207	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   394: aload_2
    //   395: astore_3
    //   396: aload 6
    //   398: getfield 145	balr:jdField_a_of_type_Int	I
    //   401: aload_0
    //   402: getfield 13	ahyr:jdField_a_of_type_Ahyo	Lahyo;
    //   405: getfield 210	ahyo:m	I
    //   408: if_icmpne +94 -> 502
    //   411: aload_2
    //   412: astore_3
    //   413: aload 4
    //   415: getfield 100	ahys:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   418: iconst_0
    //   419: invokevirtual 214	android/widget/ImageView:setVisibility	(I)V
    //   422: goto +105 -> 527
    //   425: aload_2
    //   426: astore_3
    //   427: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   430: ifeq +13 -> 443
    //   433: aload_2
    //   434: astore_3
    //   435: ldc 222
    //   437: iconst_2
    //   438: ldc 224
    //   440: invokestatic 228	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   443: aload_2
    //   444: astore_3
    //   445: new 119	android/view/ViewGroup$LayoutParams
    //   448: dup
    //   449: aload_0
    //   450: getfield 13	ahyr:jdField_a_of_type_Ahyo	Lahyo;
    //   453: getfield 117	ahyo:g	I
    //   456: aload_0
    //   457: getfield 13	ahyr:jdField_a_of_type_Ahyo	Lahyo;
    //   460: getfield 231	ahyo:h	I
    //   463: invokespecial 234	android/view/ViewGroup$LayoutParams:<init>	(II)V
    //   466: astore 4
    //   468: goto -300 -> 168
    //   471: astore_2
    //   472: aload_3
    //   473: astore_2
    //   474: goto +53 -> 527
    //   477: aload_2
    //   478: invokevirtual 238	android/view/View:getTag	()Ljava/lang/Object;
    //   481: checkcast 57	ahys
    //   484: astore 4
    //   486: goto -294 -> 192
    //   489: aload_2
    //   490: astore_3
    //   491: aload_2
    //   492: aconst_null
    //   493: invokevirtual 207	android/view/View:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   496: goto -102 -> 394
    //   499: astore_2
    //   500: aload_2
    //   501: athrow
    //   502: aload_2
    //   503: astore_3
    //   504: aload 4
    //   506: getfield 100	ahys:jdField_a_of_type_AndroidWidgetImageView	Landroid/widget/ImageView;
    //   509: bipush 8
    //   511: invokevirtual 214	android/widget/ImageView:setVisibility	(I)V
    //   514: goto +13 -> 527
    //   517: astore_3
    //   518: goto +9 -> 527
    //   521: aconst_null
    //   522: astore 5
    //   524: goto -258 -> 266
    //   527: aload_2
    //   528: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	529	0	this	ahyr
    //   0	529	1	paramInt	int
    //   0	529	2	paramView	android.view.View
    //   0	529	3	paramViewGroup	android.view.ViewGroup
    //   133	372	4	localObject1	Object
    //   21	502	5	localObject2	Object
    //   202	195	6	localbalr	balr
    //   281	20	7	localbaqk	baqk
    // Exception table:
    //   from	to	target	type
    //   45	59	471	java/lang/Throwable
    //   61	75	471	java/lang/Throwable
    //   77	91	471	java/lang/Throwable
    //   93	107	471	java/lang/Throwable
    //   109	123	471	java/lang/Throwable
    //   125	135	471	java/lang/Throwable
    //   142	154	471	java/lang/Throwable
    //   156	168	471	java/lang/Throwable
    //   170	180	471	java/lang/Throwable
    //   182	188	471	java/lang/Throwable
    //   194	204	471	java/lang/Throwable
    //   211	224	471	java/lang/Throwable
    //   226	232	471	java/lang/Throwable
    //   234	244	471	java/lang/Throwable
    //   246	254	471	java/lang/Throwable
    //   256	266	471	java/lang/Throwable
    //   268	283	471	java/lang/Throwable
    //   285	292	471	java/lang/Throwable
    //   294	305	471	java/lang/Throwable
    //   307	317	471	java/lang/Throwable
    //   319	332	471	java/lang/Throwable
    //   334	356	471	java/lang/Throwable
    //   358	373	471	java/lang/Throwable
    //   375	394	471	java/lang/Throwable
    //   396	411	471	java/lang/Throwable
    //   413	422	471	java/lang/Throwable
    //   427	433	471	java/lang/Throwable
    //   435	443	471	java/lang/Throwable
    //   445	468	471	java/lang/Throwable
    //   491	496	471	java/lang/Throwable
    //   504	514	471	java/lang/Throwable
    //   0	7	499	finally
    //   13	41	499	finally
    //   45	59	499	finally
    //   61	75	499	finally
    //   77	91	499	finally
    //   93	107	499	finally
    //   109	123	499	finally
    //   125	135	499	finally
    //   142	154	499	finally
    //   156	168	499	finally
    //   170	180	499	finally
    //   182	188	499	finally
    //   194	204	499	finally
    //   211	224	499	finally
    //   226	232	499	finally
    //   234	244	499	finally
    //   246	254	499	finally
    //   256	266	499	finally
    //   268	283	499	finally
    //   285	292	499	finally
    //   294	305	499	finally
    //   307	317	499	finally
    //   319	332	499	finally
    //   334	356	499	finally
    //   358	373	499	finally
    //   375	394	499	finally
    //   396	411	499	finally
    //   413	422	499	finally
    //   427	433	499	finally
    //   435	443	499	finally
    //   445	468	499	finally
    //   477	486	499	finally
    //   491	496	499	finally
    //   504	514	499	finally
    //   0	7	517	java/lang/Throwable
    //   13	41	517	java/lang/Throwable
    //   477	486	517	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahyr
 * JD-Core Version:    0.7.0.1
 */