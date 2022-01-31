import android.support.annotation.NonNull;

public class aclj
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public String f;
  public long g;
  
  public aclj()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
  }
  
  /* Error */
  public static aclj a(long paramLong, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: new 37	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo
    //   9: dup
    //   10: invokespecial 38	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:<init>	()V
    //   13: astore 7
    //   15: aload 7
    //   17: aload_2
    //   18: invokevirtual 42	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   21: pop
    //   22: new 2	aclj
    //   25: dup
    //   26: invokespecial 43	aclj:<init>	()V
    //   29: astore 6
    //   31: aload 6
    //   33: lload_0
    //   34: putfield 45	aclj:jdField_a_of_type_Long	J
    //   37: aload 7
    //   39: getfield 49	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   42: invokevirtual 55	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   45: ifeq +17 -> 62
    //   48: aload 6
    //   50: aload 7
    //   52: getfield 49	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   55: invokevirtual 59	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   58: i2l
    //   59: putfield 61	aclj:jdField_b_of_type_Long	J
    //   62: aload 7
    //   64: getfield 65	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_last_action_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   67: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   70: ifeq +16 -> 86
    //   73: aload 6
    //   75: aload 7
    //   77: getfield 65	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_last_action_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   80: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   83: putfield 73	aclj:jdField_c_of_type_Long	J
    //   86: aload 7
    //   88: getfield 76	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_last_change_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   91: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   94: ifeq +16 -> 110
    //   97: aload 6
    //   99: aload 7
    //   101: getfield 76	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_last_change_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   104: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   107: putfield 78	aclj:jdField_d_of_type_Long	J
    //   110: aload 7
    //   112: getfield 81	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_continue_days	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   115: invokevirtual 55	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   118: ifeq +16 -> 134
    //   121: aload 6
    //   123: aload 7
    //   125: getfield 81	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_continue_days	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   128: invokevirtual 59	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   131: putfield 83	aclj:jdField_a_of_type_Int	I
    //   134: aload 7
    //   136: getfield 87	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_wildcard_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   139: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   142: ifeq +19 -> 161
    //   145: aload 6
    //   147: aload 7
    //   149: getfield 87	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_wildcard_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   152: invokevirtual 93	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   155: invokevirtual 99	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   158: putfield 101	aclj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   161: aload 7
    //   163: getfield 104	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_notify_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   166: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   169: ifeq +16 -> 185
    //   172: aload 6
    //   174: aload 7
    //   176: getfield 104	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_notify_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   179: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   182: putfield 106	aclj:jdField_e_of_type_Long	J
    //   185: aload 7
    //   187: getfield 109	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_icon_status	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   190: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   193: ifeq +16 -> 209
    //   196: aload 6
    //   198: aload 7
    //   200: getfield 109	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_icon_status	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   203: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   206: putfield 111	aclj:jdField_f_of_type_Long	J
    //   209: aload 7
    //   211: getfield 114	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_icon_status_end_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   214: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   217: ifeq +16 -> 233
    //   220: aload 6
    //   222: aload 7
    //   224: getfield 114	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_icon_status_end_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   227: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   230: putfield 116	aclj:g	J
    //   233: aload 7
    //   235: getfield 119	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_close_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   238: invokevirtual 55	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   241: ifeq +22 -> 263
    //   244: aload 7
    //   246: getfield 119	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_close_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   249: invokevirtual 59	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   252: ifeq +273 -> 525
    //   255: iconst_1
    //   256: istore_3
    //   257: aload 6
    //   259: iload_3
    //   260: putfield 121	aclj:jdField_a_of_type_Boolean	Z
    //   263: aload 7
    //   265: getfield 124	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_resource_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   268: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   271: ifeq +188 -> 459
    //   274: new 126	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17
    //   277: dup
    //   278: invokespecial 127	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:<init>	()V
    //   281: astore_2
    //   282: aload_2
    //   283: aload 7
    //   285: getfield 124	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_resource_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   288: invokevirtual 93	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   291: invokevirtual 131	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   294: invokevirtual 132	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   297: pop
    //   298: aload_2
    //   299: ifnull +160 -> 459
    //   302: aload_2
    //   303: getfield 135	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_static_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   306: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   309: ifeq +18 -> 327
    //   312: aload 6
    //   314: aload_2
    //   315: getfield 135	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_static_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   318: invokevirtual 93	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   321: invokevirtual 99	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   324: putfield 23	aclj:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   327: aload_2
    //   328: getfield 138	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_dynamic_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   331: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   334: ifeq +18 -> 352
    //   337: aload 6
    //   339: aload_2
    //   340: getfield 138	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_dynamic_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   343: invokevirtual 93	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   346: invokevirtual 99	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   349: putfield 25	aclj:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   352: aload_2
    //   353: getfield 141	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_cartoon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   356: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   359: ifeq +18 -> 377
    //   362: aload 6
    //   364: aload_2
    //   365: getfield 141	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_cartoon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   368: invokevirtual 93	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   371: invokevirtual 99	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   374: putfield 27	aclj:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   377: aload_2
    //   378: getfield 144	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_cartoon_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   381: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   384: ifeq +18 -> 402
    //   387: aload 6
    //   389: aload_2
    //   390: getfield 144	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_cartoon_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   393: invokevirtual 93	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   396: invokevirtual 99	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   399: putfield 29	aclj:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   402: aload_2
    //   403: getfield 147	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_word	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   406: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   409: ifeq +18 -> 427
    //   412: aload 6
    //   414: aload_2
    //   415: getfield 147	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_word	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   418: invokevirtual 93	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   421: invokevirtual 99	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   424: putfield 31	aclj:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   427: aload_2
    //   428: getfield 150	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:uint32_play_cartoon	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   431: invokevirtual 55	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   434: ifeq +25 -> 459
    //   437: iload 4
    //   439: istore_3
    //   440: aload_2
    //   441: getfield 150	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:uint32_play_cartoon	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   444: invokevirtual 59	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   447: iconst_1
    //   448: if_icmpne +5 -> 453
    //   451: iconst_1
    //   452: istore_3
    //   453: aload 6
    //   455: iload_3
    //   456: putfield 152	aclj:jdField_b_of_type_Boolean	Z
    //   459: invokestatic 157	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq +29 -> 491
    //   465: ldc 159
    //   467: iconst_1
    //   468: new 161	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   475: ldc 164
    //   477: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: aload 6
    //   482: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   491: aload 6
    //   493: areturn
    //   494: astore_2
    //   495: ldc 159
    //   497: iconst_1
    //   498: new 161	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   505: ldc 180
    //   507: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload_2
    //   511: invokevirtual 183	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   514: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: aconst_null
    //   524: areturn
    //   525: iconst_0
    //   526: istore_3
    //   527: goto -270 -> 257
    //   530: astore_2
    //   531: ldc 159
    //   533: iconst_1
    //   534: new 161	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   541: ldc 185
    //   543: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: aload_2
    //   547: invokevirtual 183	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   550: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 178	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   559: aload 5
    //   561: astore_2
    //   562: goto -264 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	565	0	paramLong	long
    //   0	565	2	paramArrayOfByte	byte[]
    //   256	271	3	bool1	boolean
    //   4	434	4	bool2	boolean
    //   1	559	5	localObject	Object
    //   29	463	6	localaclj	aclj
    //   13	271	7	localMutualmarkInfo	tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark.MutualmarkInfo
    // Exception table:
    //   from	to	target	type
    //   15	22	494	java/lang/Throwable
    //   282	298	530	java/lang/Throwable
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtSnsMutualMarkPushInfo{");
    localStringBuilder.append("relation_type:").append(this.jdField_a_of_type_Long).append(", ");
    localStringBuilder.append("relation_level:").append(this.jdField_b_of_type_Long).append(", ");
    localStringBuilder.append("last_action_time:").append(this.jdField_c_of_type_Long).append(", ");
    localStringBuilder.append("last_change_time:").append(this.jdField_d_of_type_Long).append(", ");
    localStringBuilder.append("continue_days:").append(this.jdField_a_of_type_Int).append(", ");
    localStringBuilder.append("notify_time:").append(this.jdField_e_of_type_Long).append(", ");
    localStringBuilder.append("icon_status:").append(this.jdField_f_of_type_Long).append(", ");
    localStringBuilder.append("icon_status_end_time:").append(this.g).append(", ");
    localStringBuilder.append("wildcard_wording:").append(this.jdField_a_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_static_url:").append(this.jdField_b_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_dynamic_url:").append(this.jdField_c_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_cartoon_url:").append(this.jdField_d_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_cartoon_md5:").append(this.jdField_e_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_name:").append(this.jdField_f_of_type_JavaLangString).append(", ");
    localStringBuilder.append("user_close_flag:").append(this.jdField_a_of_type_Boolean).append(", ");
    localStringBuilder.append("play_cartoon:").append(this.jdField_b_of_type_Boolean).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aclj
 * JD-Core Version:    0.7.0.1
 */