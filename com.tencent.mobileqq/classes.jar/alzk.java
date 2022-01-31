import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class alzk
{
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "OidbSvc.0xb36_1";
  }
  
  /* Error */
  public static void a(alzf paramalzf, ToServiceMsg paramToServiceMsg, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 22	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc 24
    //   6: invokevirtual 30	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_1
    //   10: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +28 -> 41
    //   16: ldc 38
    //   18: iconst_2
    //   19: new 40	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   26: ldc 45
    //   28: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_2
    //   42: invokevirtual 62	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   45: ifne +47 -> 92
    //   48: ldc 38
    //   50: iconst_1
    //   51: iconst_3
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: ldc 64
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: aload_2
    //   63: invokevirtual 67	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   66: aastore
    //   67: dup
    //   68: iconst_2
    //   69: aload_2
    //   70: invokevirtual 68	com/tencent/qphone/base/remote/FromServiceMsg:toString	()Ljava/lang/String;
    //   73: aastore
    //   74: invokestatic 72	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   77: aload_0
    //   78: iconst_1
    //   79: iconst_0
    //   80: iconst_1
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_1
    //   87: aastore
    //   88: invokevirtual 78	alzf:notifyUI	(IZLjava/lang/Object;)V
    //   91: return
    //   92: new 80	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   95: dup
    //   96: invokespecial 81	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   99: astore_2
    //   100: aload_2
    //   101: aload_3
    //   102: checkcast 83	[B
    //   105: checkcast 83	[B
    //   108: invokevirtual 87	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   111: checkcast 80	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   114: astore_2
    //   115: new 89	tencent/im/oidb/cmd0xb36/oidb_cmd0xb36$RspBody
    //   118: dup
    //   119: invokespecial 90	tencent/im/oidb/cmd0xb36/oidb_cmd0xb36$RspBody:<init>	()V
    //   122: astore_3
    //   123: aload_3
    //   124: aload_2
    //   125: getfield 94	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   128: invokevirtual 100	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   131: invokevirtual 106	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   134: invokevirtual 107	tencent/im/oidb/cmd0xb36/oidb_cmd0xb36$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   137: pop
    //   138: aload_0
    //   139: getfield 111	alzf:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   142: bipush 52
    //   144: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   147: checkcast 119	com/tencent/mobileqq/app/TroopManager
    //   150: aload_3
    //   151: invokevirtual 122	com/tencent/mobileqq/app/TroopManager:a	(Ltencent/im/oidb/cmd0xb36/oidb_cmd0xb36$RspBody;)V
    //   154: aload_0
    //   155: iconst_1
    //   156: iconst_1
    //   157: iconst_1
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_1
    //   164: aastore
    //   165: invokevirtual 78	alzf:notifyUI	(IZLjava/lang/Object;)V
    //   168: return
    //   169: astore_2
    //   170: ldc 38
    //   172: iconst_1
    //   173: ldc 124
    //   175: aload_2
    //   176: invokestatic 127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   179: aload_0
    //   180: iconst_1
    //   181: iconst_0
    //   182: iconst_1
    //   183: anewarray 4	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: aload_1
    //   189: aastore
    //   190: invokevirtual 78	alzf:notifyUI	(IZLjava/lang/Object;)V
    //   193: return
    //   194: astore_2
    //   195: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq -44 -> 154
    //   201: ldc 38
    //   203: iconst_2
    //   204: ldc 129
    //   206: aload_2
    //   207: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   210: goto -56 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	paramalzf	alzf
    //   0	213	1	paramToServiceMsg	ToServiceMsg
    //   0	213	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	213	3	paramObject	Object
    // Exception table:
    //   from	to	target	type
    //   100	115	169	java/lang/Exception
    //   123	154	194	java/lang/Exception
  }
  
  public static void a(alzf paramalzf, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.survey", 2, "send_oidb_0xb36, troopUin = " + paramString);
    }
    Object localObject = new oidb_cmd0xb36.ReqBody();
    try
    {
      long l = Long.parseLong(paramString);
      ((oidb_cmd0xb36.ReqBody)localObject).group_id.set(l);
      ((oidb_cmd0xb36.ReqBody)localObject).red_point_num.set(paramInt);
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(2870);
      localOIDBSSOPkg.uint32_service_type.set(1);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xb36.ReqBody)localObject).toByteArray()));
      localObject = paramalzf.createToServiceMsg(jdField_a_of_type_JavaLangString);
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
      paramalzf.sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (NumberFormatException paramalzf)
    {
      QLog.e(".troop.survey", 1, "send_oidb_0xb36 error! ", paramalzf);
    }
  }
  
  /* Error */
  public static boolean a(alzf paramalzf, bcrz parambcrz, tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum paramSubCmd0x1UpdateAppUnreadNum, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 207	bcrz:jdField_a_of_type_Long	J
    //   4: ldc2_w 208
    //   7: lcmp
    //   8: ifeq +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +70 -> 86
    //   19: ldc 38
    //   21: iconst_2
    //   22: bipush 8
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: ldc 211
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: aload_1
    //   35: getfield 212	bcrz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   38: aastore
    //   39: dup
    //   40: iconst_2
    //   41: ldc 214
    //   43: aastore
    //   44: dup
    //   45: iconst_3
    //   46: aload_1
    //   47: getfield 218	bcrz:b	I
    //   50: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   53: aastore
    //   54: dup
    //   55: iconst_4
    //   56: ldc 226
    //   58: aastore
    //   59: dup
    //   60: iconst_5
    //   61: aload_1
    //   62: getfield 228	bcrz:jdField_a_of_type_Int	I
    //   65: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: aastore
    //   69: dup
    //   70: bipush 6
    //   72: ldc 230
    //   74: aastore
    //   75: dup
    //   76: bipush 7
    //   78: iload_3
    //   79: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   82: aastore
    //   83: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   86: aload_2
    //   87: ifnull +118 -> 205
    //   90: aload_2
    //   91: getfield 238	tencent/im/s2c/msgtype0x210/submsgtype0x26/submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum:msg_app_tip_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x26/submsgtype0x26$AppTipNotify;
    //   94: invokevirtual 243	tencent/im/s2c/msgtype0x210/submsgtype0x26/submsgtype0x26$AppTipNotify:has	()Z
    //   97: ifeq +108 -> 205
    //   100: aload_2
    //   101: getfield 238	tencent/im/s2c/msgtype0x210/submsgtype0x26/submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum:msg_app_tip_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x26/submsgtype0x26$AppTipNotify;
    //   104: getfield 246	tencent/im/s2c/msgtype0x210/submsgtype0x26/submsgtype0x26$AppTipNotify:bytes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   107: invokevirtual 100	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   110: invokevirtual 249	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   113: astore_2
    //   114: aload_2
    //   115: invokestatic 255	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifne +87 -> 205
    //   121: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq +35 -> 159
    //   127: ldc 38
    //   129: iconst_2
    //   130: iconst_4
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: ldc 211
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: aload_1
    //   142: getfield 212	bcrz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   145: aastore
    //   146: dup
    //   147: iconst_2
    //   148: ldc_w 257
    //   151: aastore
    //   152: dup
    //   153: iconst_3
    //   154: aload_2
    //   155: aastore
    //   156: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   159: new 259	org/json/JSONObject
    //   162: dup
    //   163: aload_2
    //   164: invokespecial 262	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   167: astore 4
    //   169: ldc_w 264
    //   172: ldc_w 266
    //   175: aload 4
    //   177: invokevirtual 267	org/json/JSONObject:toString	()Ljava/lang/String;
    //   180: ldc_w 269
    //   183: invokestatic 274	com/tencent/mobileqq/ark/ArkAppCenter:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   186: pop
    //   187: ldc_w 276
    //   190: ldc_w 266
    //   193: aload 4
    //   195: invokevirtual 267	org/json/JSONObject:toString	()Ljava/lang/String;
    //   198: ldc_w 269
    //   201: invokestatic 274	com/tencent/mobileqq/ark/ArkAppCenter:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   204: pop
    //   205: iload_3
    //   206: iconst_2
    //   207: if_icmpeq +10 -> 217
    //   210: aload_1
    //   211: getfield 218	bcrz:b	I
    //   214: ifeq +82 -> 296
    //   217: aload_0
    //   218: aload_1
    //   219: getfield 212	bcrz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   222: aload_1
    //   223: getfield 218	bcrz:b	I
    //   226: invokestatic 278	alzk:a	(Lalzf;Ljava/lang/String;I)V
    //   229: iconst_1
    //   230: ireturn
    //   231: astore 5
    //   233: ldc 38
    //   235: iconst_2
    //   236: ldc_w 280
    //   239: aload 5
    //   241: invokestatic 127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   244: goto -57 -> 187
    //   247: astore 4
    //   249: ldc 38
    //   251: iconst_2
    //   252: new 40	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   259: ldc_w 282
    //   262: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_2
    //   266: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: aload 4
    //   274: invokestatic 127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   277: goto -72 -> 205
    //   280: astore 4
    //   282: ldc 38
    //   284: iconst_2
    //   285: ldc_w 280
    //   288: aload 4
    //   290: invokestatic 127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   293: goto -88 -> 205
    //   296: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq -70 -> 229
    //   302: ldc 38
    //   304: iconst_2
    //   305: bipush 8
    //   307: anewarray 4	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: ldc 211
    //   314: aastore
    //   315: dup
    //   316: iconst_1
    //   317: aload_1
    //   318: getfield 212	bcrz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   321: aastore
    //   322: dup
    //   323: iconst_2
    //   324: ldc 214
    //   326: aastore
    //   327: dup
    //   328: iconst_3
    //   329: aload_1
    //   330: getfield 218	bcrz:b	I
    //   333: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   336: aastore
    //   337: dup
    //   338: iconst_4
    //   339: ldc 226
    //   341: aastore
    //   342: dup
    //   343: iconst_5
    //   344: aload_1
    //   345: getfield 228	bcrz:jdField_a_of_type_Int	I
    //   348: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   351: aastore
    //   352: dup
    //   353: bipush 6
    //   355: ldc_w 284
    //   358: aastore
    //   359: dup
    //   360: bipush 7
    //   362: iload_3
    //   363: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   366: aastore
    //   367: invokestatic 232	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   370: goto -141 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	373	0	paramalzf	alzf
    //   0	373	1	parambcrz	bcrz
    //   0	373	2	paramSubCmd0x1UpdateAppUnreadNum	tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum
    //   0	373	3	paramInt	int
    //   167	27	4	localJSONObject	org.json.JSONObject
    //   247	26	4	localJSONException	org.json.JSONException
    //   280	9	4	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   231	9	5	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   169	187	231	java/lang/UnsatisfiedLinkError
    //   121	159	247	org/json/JSONException
    //   159	169	247	org/json/JSONException
    //   169	187	247	org/json/JSONException
    //   187	205	247	org/json/JSONException
    //   233	244	247	org/json/JSONException
    //   282	293	247	org/json/JSONException
    //   187	205	280	java/lang/UnsatisfiedLinkError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alzk
 * JD-Core Version:    0.7.0.1
 */