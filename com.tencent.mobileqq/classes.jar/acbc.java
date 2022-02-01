import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.data.MessageRecord;

public class acbc
  implements abzb
{
  /* Error */
  private static void a(abxc paramabxc, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    // Byte code:
    //   0: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 25
    //   8: iconst_2
    //   9: ldc 27
    //   11: invokestatic 31	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +11 -> 28
    //   20: ldc 33
    //   22: iconst_2
    //   23: ldc 35
    //   25: invokestatic 31	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: new 37	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody
    //   31: dup
    //   32: invokespecial 38	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:<init>	()V
    //   35: astore 12
    //   37: aload 12
    //   39: aload_2
    //   40: getfield 44	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   43: invokevirtual 48	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   46: pop
    //   47: aload 12
    //   49: getfield 52	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:uint64_to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   52: invokevirtual 58	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   55: lstore 5
    //   57: aload_0
    //   58: invokevirtual 63	abxc:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   61: invokevirtual 69	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   64: astore_2
    //   65: invokestatic 75	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   68: lload 5
    //   70: invokestatic 81	java/lang/Long:toString	(J)Ljava/lang/String;
    //   73: aconst_null
    //   74: ldc 83
    //   76: iconst_0
    //   77: invokestatic 89	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   80: ifne +318 -> 398
    //   83: lload 5
    //   85: invokestatic 81	java/lang/Long:toString	(J)Ljava/lang/String;
    //   88: aload_2
    //   89: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: istore 9
    //   94: iload 9
    //   96: ifeq +302 -> 398
    //   99: aconst_null
    //   100: astore_2
    //   101: aconst_null
    //   102: astore 10
    //   104: aconst_null
    //   105: astore 14
    //   107: aload 12
    //   109: getfield 99	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_tips_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   112: invokevirtual 104	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   115: ifeq +322 -> 437
    //   118: new 91	java/lang/String
    //   121: dup
    //   122: aload 12
    //   124: getfield 99	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_tips_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   127: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   130: invokevirtual 113	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   133: ldc 115
    //   135: invokespecial 118	java/lang/String:<init>	([BLjava/lang/String;)V
    //   138: astore 11
    //   140: aload 11
    //   142: astore_2
    //   143: aload 12
    //   145: getfield 121	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_yes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   148: invokevirtual 104	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   151: ifeq +280 -> 431
    //   154: new 91	java/lang/String
    //   157: dup
    //   158: aload 12
    //   160: getfield 121	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_yes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   163: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   166: invokevirtual 113	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   169: ldc 115
    //   171: invokespecial 118	java/lang/String:<init>	([BLjava/lang/String;)V
    //   174: astore 11
    //   176: aload 11
    //   178: astore 10
    //   180: aload 12
    //   182: getfield 124	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_no_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   185: invokevirtual 104	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   188: ifeq +237 -> 425
    //   191: new 91	java/lang/String
    //   194: dup
    //   195: aload 12
    //   197: getfield 124	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_no_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   200: invokevirtual 107	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   203: invokevirtual 113	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   206: ldc 115
    //   208: invokespecial 118	java/lang/String:<init>	([BLjava/lang/String;)V
    //   211: astore 11
    //   213: aload 11
    //   215: astore 12
    //   217: aload_2
    //   218: astore 11
    //   220: aload 10
    //   222: astore 13
    //   224: invokestatic 75	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   227: lload 5
    //   229: invokestatic 81	java/lang/Long:toString	(J)Ljava/lang/String;
    //   232: aload 11
    //   234: aload 12
    //   236: aload 13
    //   238: invokevirtual 128	com/tencent/common/app/BaseApplicationImpl:setPCActiveNotice	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_0
    //   242: sipush 8013
    //   245: iconst_1
    //   246: iconst_4
    //   247: anewarray 4	java/lang/Object
    //   250: dup
    //   251: iconst_0
    //   252: lload 5
    //   254: invokestatic 81	java/lang/Long:toString	(J)Ljava/lang/String;
    //   257: aastore
    //   258: dup
    //   259: iconst_1
    //   260: aload 11
    //   262: aastore
    //   263: dup
    //   264: iconst_2
    //   265: aload 12
    //   267: aastore
    //   268: dup
    //   269: iconst_3
    //   270: aload 13
    //   272: aastore
    //   273: invokevirtual 131	abxc:a	(IZLjava/lang/Object;)V
    //   276: aload_1
    //   277: getfield 137	OnlinePushPack/MsgInfo:lFromUin	J
    //   280: lstore 5
    //   282: aload_1
    //   283: getfield 141	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   286: istore_3
    //   287: aload_1
    //   288: getfield 144	OnlinePushPack/MsgInfo:lMsgUid	J
    //   291: lstore 7
    //   293: aload_1
    //   294: getfield 147	OnlinePushPack/MsgInfo:shMsgType	S
    //   297: istore 4
    //   299: aload_0
    //   300: invokevirtual 63	abxc:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   303: invokevirtual 151	com/tencent/mobileqq/app/QQAppInterface:getMsgHandler	()Lcom/tencent/mobileqq/app/MessageHandler;
    //   306: lload 5
    //   308: iload_3
    //   309: lload 7
    //   311: iload 4
    //   313: invokestatic 156	bblf:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   316: return
    //   317: astore 11
    //   319: aload 10
    //   321: astore 13
    //   323: aload 14
    //   325: astore 12
    //   327: aload_2
    //   328: astore 11
    //   330: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   333: ifeq -109 -> 224
    //   336: ldc 25
    //   338: iconst_2
    //   339: ldc 158
    //   341: invokestatic 31	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: aload 10
    //   346: astore 13
    //   348: aload 14
    //   350: astore 12
    //   352: aload_2
    //   353: astore 11
    //   355: goto -131 -> 224
    //   358: astore_2
    //   359: aload_2
    //   360: invokevirtual 161	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   363: aload_0
    //   364: sipush 8013
    //   367: iconst_0
    //   368: iconst_4
    //   369: anewarray 4	java/lang/Object
    //   372: dup
    //   373: iconst_0
    //   374: ldc 163
    //   376: aastore
    //   377: dup
    //   378: iconst_1
    //   379: ldc 163
    //   381: aastore
    //   382: dup
    //   383: iconst_2
    //   384: ldc 163
    //   386: aastore
    //   387: dup
    //   388: iconst_3
    //   389: ldc 163
    //   391: aastore
    //   392: invokevirtual 131	abxc:a	(IZLjava/lang/Object;)V
    //   395: goto -119 -> 276
    //   398: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   401: ifeq -125 -> 276
    //   404: ldc 25
    //   406: iconst_2
    //   407: ldc 165
    //   409: invokestatic 31	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: goto -136 -> 276
    //   415: astore 11
    //   417: goto -98 -> 319
    //   420: astore 11
    //   422: goto -103 -> 319
    //   425: aconst_null
    //   426: astore 11
    //   428: goto -215 -> 213
    //   431: aconst_null
    //   432: astore 10
    //   434: goto -254 -> 180
    //   437: aconst_null
    //   438: astore_2
    //   439: goto -296 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	442	0	paramabxc	abxc
    //   0	442	1	paramMsgInfo	MsgInfo
    //   0	442	2	paramMsgType0x210	MsgType0x210
    //   286	23	3	i	int
    //   297	15	4	j	int
    //   55	252	5	l1	long
    //   291	19	7	l2	long
    //   92	3	9	bool	boolean
    //   102	331	10	localObject1	Object
    //   138	123	11	localObject2	Object
    //   317	1	11	localException1	java.lang.Exception
    //   328	26	11	localMsgType0x210	MsgType0x210
    //   415	1	11	localException2	java.lang.Exception
    //   420	1	11	localException3	java.lang.Exception
    //   426	1	11	localObject3	Object
    //   35	316	12	localObject4	Object
    //   222	125	13	localObject5	Object
    //   105	244	14	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   107	140	317	java/lang/Exception
    //   14	28	358	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   28	94	358	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   107	140	358	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   143	176	358	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   180	213	358	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   224	276	358	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   330	344	358	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   398	412	358	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   143	176	415	java/lang/Exception
    //   180	213	420	java/lang/Exception
  }
  
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramabxc, paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acbc
 * JD-Core Version:    0.7.0.1
 */