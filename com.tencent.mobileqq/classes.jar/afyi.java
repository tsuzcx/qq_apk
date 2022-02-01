import android.support.annotation.NonNull;

public class afyi
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
  public String g;
  
  public afyi()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_f_of_type_JavaLangString = "";
    this.jdField_g_of_type_JavaLangString = "";
  }
  
  /* Error */
  public static afyi a(long paramLong, byte[] paramArrayOfByte)
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
    //   22: new 2	afyi
    //   25: dup
    //   26: invokespecial 43	afyi:<init>	()V
    //   29: astore 6
    //   31: aload 6
    //   33: lload_0
    //   34: putfield 45	afyi:jdField_a_of_type_Long	J
    //   37: aload 7
    //   39: getfield 49	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   42: invokevirtual 55	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   45: ifeq +17 -> 62
    //   48: aload 6
    //   50: aload 7
    //   52: getfield 49	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   55: invokevirtual 59	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   58: i2l
    //   59: putfield 61	afyi:jdField_b_of_type_Long	J
    //   62: aload 7
    //   64: getfield 65	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_last_action_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   67: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   70: ifeq +16 -> 86
    //   73: aload 6
    //   75: aload 7
    //   77: getfield 65	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_last_action_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   80: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   83: putfield 73	afyi:jdField_c_of_type_Long	J
    //   86: aload 7
    //   88: getfield 76	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_last_change_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   91: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   94: ifeq +16 -> 110
    //   97: aload 6
    //   99: aload 7
    //   101: getfield 76	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_last_change_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   104: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   107: putfield 78	afyi:jdField_d_of_type_Long	J
    //   110: aload 7
    //   112: getfield 81	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_continue_days	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   115: invokevirtual 55	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   118: ifeq +16 -> 134
    //   121: aload 6
    //   123: aload 7
    //   125: getfield 81	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_continue_days	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   128: invokevirtual 59	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   131: putfield 83	afyi:jdField_a_of_type_Int	I
    //   134: aload 7
    //   136: getfield 87	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_wildcard_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   139: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   142: ifeq +19 -> 161
    //   145: aload 6
    //   147: aload 7
    //   149: getfield 87	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_wildcard_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   152: invokevirtual 93	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   155: invokevirtual 99	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   158: putfield 101	afyi:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   161: aload 7
    //   163: getfield 104	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_duplicate_removal_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   166: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   169: ifeq +19 -> 188
    //   172: aload 6
    //   174: aload 7
    //   176: getfield 104	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_duplicate_removal_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   179: invokevirtual 93	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   182: invokevirtual 99	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   185: putfield 106	afyi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   188: aload 7
    //   190: getfield 109	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_notify_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   193: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   196: ifeq +16 -> 212
    //   199: aload 6
    //   201: aload 7
    //   203: getfield 109	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_notify_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   206: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   209: putfield 111	afyi:jdField_e_of_type_Long	J
    //   212: aload 7
    //   214: getfield 114	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_icon_status	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   217: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   220: ifeq +16 -> 236
    //   223: aload 6
    //   225: aload 7
    //   227: getfield 114	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_icon_status	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   230: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   233: putfield 116	afyi:jdField_f_of_type_Long	J
    //   236: aload 7
    //   238: getfield 119	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_icon_status_end_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   241: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   244: ifeq +16 -> 260
    //   247: aload 6
    //   249: aload 7
    //   251: getfield 119	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint64_icon_status_end_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   254: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   257: putfield 121	afyi:jdField_g_of_type_Long	J
    //   260: aload 7
    //   262: getfield 124	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_close_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   265: invokevirtual 55	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   268: ifeq +22 -> 290
    //   271: aload 7
    //   273: getfield 124	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:uint32_close_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   276: invokevirtual 59	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   279: ifeq +273 -> 552
    //   282: iconst_1
    //   283: istore_3
    //   284: aload 6
    //   286: iload_3
    //   287: putfield 126	afyi:jdField_a_of_type_Boolean	Z
    //   290: aload 7
    //   292: getfield 129	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_resource_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   295: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   298: ifeq +188 -> 486
    //   301: new 131	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17
    //   304: dup
    //   305: invokespecial 132	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:<init>	()V
    //   308: astore_2
    //   309: aload_2
    //   310: aload 7
    //   312: getfield 129	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$MutualmarkInfo:bytes_resource_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   315: invokevirtual 93	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   318: invokevirtual 136	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   321: invokevirtual 137	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   324: pop
    //   325: aload_2
    //   326: ifnull +160 -> 486
    //   329: aload_2
    //   330: getfield 140	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_static_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   333: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   336: ifeq +18 -> 354
    //   339: aload 6
    //   341: aload_2
    //   342: getfield 140	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_static_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   345: invokevirtual 93	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   348: invokevirtual 99	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   351: putfield 23	afyi:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   354: aload_2
    //   355: getfield 143	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_dynamic_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   358: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   361: ifeq +18 -> 379
    //   364: aload 6
    //   366: aload_2
    //   367: getfield 143	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_dynamic_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   370: invokevirtual 93	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   373: invokevirtual 99	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   376: putfield 25	afyi:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   379: aload_2
    //   380: getfield 146	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_cartoon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   383: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   386: ifeq +18 -> 404
    //   389: aload 6
    //   391: aload_2
    //   392: getfield 146	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_cartoon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   395: invokevirtual 93	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   398: invokevirtual 99	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   401: putfield 27	afyi:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   404: aload_2
    //   405: getfield 149	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_cartoon_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   408: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   411: ifeq +18 -> 429
    //   414: aload 6
    //   416: aload_2
    //   417: getfield 149	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_cartoon_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   420: invokevirtual 93	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   423: invokevirtual 99	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   426: putfield 29	afyi:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   429: aload_2
    //   430: getfield 152	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_word	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   433: invokevirtual 90	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   436: ifeq +18 -> 454
    //   439: aload 6
    //   441: aload_2
    //   442: getfield 152	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:bytes_word	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   445: invokevirtual 93	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   448: invokevirtual 99	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   451: putfield 31	afyi:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   454: aload_2
    //   455: getfield 155	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:uint32_play_cartoon	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   458: invokevirtual 55	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   461: ifeq +25 -> 486
    //   464: iload 4
    //   466: istore_3
    //   467: aload_2
    //   468: getfield 155	tencent/im/s2c/msgtype0x210/submsgtype0xc7/bussinfo/mutualmark/mutualmark$ResourceInfo_17:uint32_play_cartoon	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   471: invokevirtual 59	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   474: iconst_1
    //   475: if_icmpne +5 -> 480
    //   478: iconst_1
    //   479: istore_3
    //   480: aload 6
    //   482: iload_3
    //   483: putfield 157	afyi:jdField_b_of_type_Boolean	Z
    //   486: invokestatic 162	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq +29 -> 518
    //   492: ldc 164
    //   494: iconst_1
    //   495: new 166	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   502: ldc 169
    //   504: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload 6
    //   509: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   512: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   518: aload 6
    //   520: areturn
    //   521: astore_2
    //   522: ldc 164
    //   524: iconst_1
    //   525: new 166	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   532: ldc 185
    //   534: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: aload_2
    //   538: invokevirtual 188	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   541: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   550: aconst_null
    //   551: areturn
    //   552: iconst_0
    //   553: istore_3
    //   554: goto -270 -> 284
    //   557: astore_2
    //   558: ldc 164
    //   560: iconst_1
    //   561: new 166	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   568: ldc 190
    //   570: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload_2
    //   574: invokevirtual 188	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   577: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 183	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   586: aload 5
    //   588: astore_2
    //   589: goto -264 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	592	0	paramLong	long
    //   0	592	2	paramArrayOfByte	byte[]
    //   283	271	3	bool1	boolean
    //   4	461	4	bool2	boolean
    //   1	586	5	localObject	Object
    //   29	490	6	localafyi	afyi
    //   13	298	7	localMutualmarkInfo	tencent.im.s2c.msgtype0x210.submsgtype0xc7.bussinfo.mutualmark.mutualmark.MutualmarkInfo
    // Exception table:
    //   from	to	target	type
    //   15	22	521	java/lang/Throwable
    //   309	325	557	java/lang/Throwable
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
    localStringBuilder.append("icon_status_end_time:").append(this.jdField_g_of_type_Long).append(", ");
    localStringBuilder.append("wildcard_wording:").append(this.jdField_a_of_type_JavaLangString).append(", ");
    localStringBuilder.append("gray_tip_duplicate_key:").append(this.jdField_b_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_static_url:").append(this.jdField_c_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_dynamic_url:").append(this.jdField_d_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_cartoon_url:").append(this.jdField_e_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_cartoon_md5:").append(this.jdField_f_of_type_JavaLangString).append(", ");
    localStringBuilder.append("icon_name:").append(this.jdField_g_of_type_JavaLangString).append(", ");
    localStringBuilder.append("user_close_flag:").append(this.jdField_a_of_type_Boolean).append(", ");
    localStringBuilder.append("play_cartoon:").append(this.jdField_b_of_type_Boolean).append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyi
 * JD-Core Version:    0.7.0.1
 */