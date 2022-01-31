import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder.IImageBitmapHandle;

class ajfl
  implements SceneBuilder.IImageBitmapHandle
{
  ajfl(ajfh paramajfh, QQAppInterface paramQQAppInterface) {}
  
  /* Error */
  public android.graphics.Bitmap a(com.tencent.mobileqq.surfaceviewaction.gl.Sprite paramSprite, java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_3
    //   4: ldc 24
    //   6: invokevirtual 30	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +45 -> 54
    //   12: iconst_1
    //   13: iconst_3
    //   14: invokestatic 35	com/tencent/mobileqq/util/FaceDrawable:a	(II)Landroid/graphics/drawable/Drawable;
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 15	ajfl:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   22: iconst_1
    //   23: aload_0
    //   24: getfield 13	ajfl:jdField_a_of_type_Ajfh	Lajfh;
    //   27: getfield 40	ajfh:a	Lcom/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData;
    //   30: getfield 45	com/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   33: iconst_3
    //   34: aload_2
    //   35: aload_2
    //   36: new 47	ajfm
    //   39: dup
    //   40: aload_0
    //   41: aload_1
    //   42: invokespecial 50	ajfm:<init>	(Lajfl;Lcom/tencent/mobileqq/surfaceviewaction/gl/Sprite;)V
    //   45: invokestatic 53	com/tencent/mobileqq/util/FaceDrawable:a	(Lcom/tencent/common/app/AppInterface;ILjava/lang/String;ILandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Lcom/tencent/mobileqq/util/FaceDrawable$OnLoadingStateChangeListener;)Lcom/tencent/mobileqq/util/FaceDrawable;
    //   48: invokestatic 58	com/tencent/mobileqq/troop/utils/TroopUtils:a	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   51: astore_1
    //   52: aload_1
    //   53: areturn
    //   54: aload_3
    //   55: ldc 60
    //   57: invokevirtual 30	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   60: ifeq +228 -> 288
    //   63: aload_0
    //   64: getfield 13	ajfl:jdField_a_of_type_Ajfh	Lajfh;
    //   67: getfield 40	ajfh:a	Lcom/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData;
    //   70: getfield 64	com/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData:jdField_b_of_type_Long	J
    //   73: ldc2_w 65
    //   76: lcmp
    //   77: ifeq +20 -> 97
    //   80: aload_0
    //   81: getfield 13	ajfl:jdField_a_of_type_Ajfh	Lajfh;
    //   84: getfield 40	ajfh:a	Lcom/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData;
    //   87: getfield 64	com/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData:jdField_b_of_type_Long	J
    //   90: ldc2_w 67
    //   93: lcmp
    //   94: ifne +185 -> 279
    //   97: aload_0
    //   98: getfield 13	ajfl:jdField_a_of_type_Ajfh	Lajfh;
    //   101: getfield 40	ajfh:a	Lcom/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData;
    //   104: getfield 71	com/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData:jdField_b_of_type_Int	I
    //   107: iconst_1
    //   108: if_icmplt +171 -> 279
    //   111: aload_0
    //   112: getfield 13	ajfl:jdField_a_of_type_Ajfh	Lajfh;
    //   115: getfield 40	ajfh:a	Lcom/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData;
    //   118: getfield 71	com/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData:jdField_b_of_type_Int	I
    //   121: bipush 8
    //   123: if_icmpgt +156 -> 279
    //   126: aload_0
    //   127: getfield 13	ajfl:jdField_a_of_type_Ajfh	Lajfh;
    //   130: getfield 40	ajfh:a	Lcom/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData;
    //   133: getfield 74	com/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData:c	I
    //   136: iconst_2
    //   137: if_icmpne +64 -> 201
    //   140: new 76	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   147: getstatic 80	com/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   150: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: getfield 13	ajfl:jdField_a_of_type_Ajfh	Lajfh;
    //   157: getfield 40	ajfh:a	Lcom/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData;
    //   160: getfield 86	com/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData:jdField_a_of_type_Int	I
    //   163: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: ldc 91
    //   168: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_0
    //   172: getfield 13	ajfl:jdField_a_of_type_Ajfh	Lajfh;
    //   175: getfield 40	ajfh:a	Lcom/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData;
    //   178: getfield 71	com/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData:jdField_b_of_type_Int	I
    //   181: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: ldc 93
    //   186: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: astore_1
    //   193: aload_1
    //   194: aconst_null
    //   195: invokestatic 102	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   198: astore_1
    //   199: aload_1
    //   200: areturn
    //   201: aload 4
    //   203: astore_1
    //   204: aload_0
    //   205: getfield 13	ajfl:jdField_a_of_type_Ajfh	Lajfh;
    //   208: getfield 40	ajfh:a	Lcom/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData;
    //   211: getfield 74	com/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData:c	I
    //   214: iconst_1
    //   215: if_icmpne -163 -> 52
    //   218: new 76	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   225: getstatic 80	com/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   228: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_0
    //   232: getfield 13	ajfl:jdField_a_of_type_Ajfh	Lajfh;
    //   235: getfield 40	ajfh:a	Lcom/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData;
    //   238: getfield 86	com/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData:jdField_a_of_type_Int	I
    //   241: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: ldc 104
    //   246: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_0
    //   250: getfield 13	ajfl:jdField_a_of_type_Ajfh	Lajfh;
    //   253: getfield 40	ajfh:a	Lcom/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData;
    //   256: getfield 71	com/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController$TroopEnterEffectData:jdField_b_of_type_Int	I
    //   259: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   262: ldc 93
    //   264: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: astore_1
    //   271: aload_1
    //   272: aconst_null
    //   273: invokestatic 102	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   276: astore_1
    //   277: aload_1
    //   278: areturn
    //   279: iconst_1
    //   280: iconst_1
    //   281: getstatic 110	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   284: invokestatic 116	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   287: areturn
    //   288: new 76	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   295: aload_2
    //   296: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc 118
    //   301: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload_3
    //   305: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: aconst_null
    //   312: invokestatic 102	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   315: astore_1
    //   316: aload_1
    //   317: areturn
    //   318: astore_1
    //   319: aconst_null
    //   320: areturn
    //   321: astore_1
    //   322: aconst_null
    //   323: areturn
    //   324: astore_1
    //   325: aconst_null
    //   326: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	ajfl
    //   0	327	1	paramSprite	com.tencent.mobileqq.surfaceviewaction.gl.Sprite
    //   0	327	2	paramString1	java.lang.String
    //   0	327	3	paramString2	java.lang.String
    //   1	201	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   193	199	318	java/lang/OutOfMemoryError
    //   271	277	321	java/lang/OutOfMemoryError
    //   288	316	324	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfl
 * JD-Core Version:    0.7.0.1
 */