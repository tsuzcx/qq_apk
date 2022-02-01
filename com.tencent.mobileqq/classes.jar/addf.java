import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.data.MessageRecord;

public class addf
  implements adci
{
  /* Error */
  private static void a(adan paramadan, MsgType0x210 paramMsgType0x210)
  {
    // Byte code:
    //   0: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 25
    //   8: iconst_2
    //   9: ldc 27
    //   11: invokestatic 31	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: new 33	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody
    //   17: dup
    //   18: invokespecial 34	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:<init>	()V
    //   21: astore 4
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 39	adan:a	(LIMMsgBodyPack/MsgType0x210;)Z
    //   28: ifeq +210 -> 238
    //   31: aload 4
    //   33: aload_1
    //   34: getfield 45	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   37: invokevirtual 49	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   40: pop
    //   41: aload 4
    //   43: getfield 53	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   46: invokevirtual 58	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   49: ifeq +190 -> 239
    //   52: aload 4
    //   54: getfield 53	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   57: invokevirtual 62	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   60: istore_2
    //   61: iload_2
    //   62: iconst_2
    //   63: if_icmpne +56 -> 119
    //   66: aload_0
    //   67: invokevirtual 65	adan:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: invokevirtual 70	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   73: aload 4
    //   75: invokevirtual 75	com/tencent/av/gaudio/AVNotifyCenter:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody;)V
    //   78: ldc 77
    //   80: astore_1
    //   81: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +154 -> 238
    //   87: ldc 25
    //   89: iconst_2
    //   90: iconst_4
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: ldc 79
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: iload_2
    //   102: invokestatic 85	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aastore
    //   106: dup
    //   107: iconst_2
    //   108: ldc 87
    //   110: aastore
    //   111: dup
    //   112: iconst_3
    //   113: aload_1
    //   114: aastore
    //   115: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   118: return
    //   119: aload 4
    //   121: getfield 94	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:str_msg_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   124: invokevirtual 97	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   127: istore_3
    //   128: iload_3
    //   129: ifeq +103 -> 232
    //   132: aload 4
    //   134: getfield 94	tencent/im/s2c/msgtype0x210/submsgtype0x126/submsgtype0x126$MsgBody:str_msg_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   137: invokevirtual 100	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   140: invokevirtual 106	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   143: astore_1
    //   144: new 108	android/os/Bundle
    //   147: dup
    //   148: invokespecial 109	android/os/Bundle:<init>	()V
    //   151: astore 4
    //   153: aload 4
    //   155: ldc 111
    //   157: iload_2
    //   158: invokevirtual 115	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   161: aload 4
    //   163: ldc 117
    //   165: aload_1
    //   166: invokevirtual 121	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload_0
    //   170: invokevirtual 65	adan:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   173: ldc 123
    //   175: bipush 11
    //   177: iconst_1
    //   178: aload 4
    //   180: invokevirtual 127	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   183: goto -102 -> 81
    //   186: astore_0
    //   187: ldc 25
    //   189: iconst_1
    //   190: new 129	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   197: ldc 132
    //   199: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload_0
    //   203: invokevirtual 139	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   206: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: return
    //   216: astore_1
    //   217: invokestatic 23	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq +12 -> 232
    //   223: ldc 25
    //   225: iconst_2
    //   226: ldc 147
    //   228: aload_1
    //   229: invokestatic 151	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   232: ldc 77
    //   234: astore_1
    //   235: goto -91 -> 144
    //   238: return
    //   239: iconst_0
    //   240: istore_2
    //   241: goto -180 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	paramadan	adan
    //   0	244	1	paramMsgType0x210	MsgType0x210
    //   60	181	2	i	int
    //   127	2	3	bool	boolean
    //   21	158	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	61	186	java/lang/Exception
    //   66	78	186	java/lang/Exception
    //   81	118	186	java/lang/Exception
    //   119	128	186	java/lang/Exception
    //   132	144	186	java/lang/Exception
    //   144	183	186	java/lang/Exception
    //   217	232	186	java/lang/Exception
    //   132	144	216	java/lang/Throwable
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addf
 * JD-Core Version:    0.7.0.1
 */