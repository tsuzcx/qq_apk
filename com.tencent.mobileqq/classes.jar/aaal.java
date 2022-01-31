import android.os.AsyncTask;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.RspBody;

public class aaal
  extends AsyncTask
{
  public aaal(SubAccountMessageProcessor paramSubAccountMessageProcessor, Oidb_0x5d0.RspBody paramRspBody, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  /* Error */
  protected ArrayList a(java.lang.Void... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: new 39	java/util/ArrayList
    //   7: dup
    //   8: invokespecial 40	java/util/ArrayList:<init>	()V
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 16	aaal:jdField_a_of_type_TencentImOidbCmd0x5d0Oidb_0x5d0$RspBody	Ltencent/im/oidb/cmd0x5d0/Oidb_0x5d0$RspBody;
    //   16: getfield 46	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$RspBody:rpt_msg_contentItem	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   19: invokevirtual 52	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   22: invokeinterface 58 1 0
    //   27: astore 4
    //   29: aload 4
    //   31: invokeinterface 64 1 0
    //   36: ifeq +302 -> 338
    //   39: aload 4
    //   41: invokeinterface 68 1 0
    //   46: checkcast 70	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$ContentItem
    //   49: astore 6
    //   51: aload 6
    //   53: getfield 74	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$ContentItem:msg_general_buffer	Ltencent/im/oidb/cmd0x5d0/Oidb_0x5d0$GeneralBuffer;
    //   56: getfield 80	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$GeneralBuffer:bytes_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   59: invokevirtual 85	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   62: ifnull -33 -> 29
    //   65: aload 6
    //   67: getfield 74	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$ContentItem:msg_general_buffer	Ltencent/im/oidb/cmd0x5d0/Oidb_0x5d0$GeneralBuffer;
    //   70: getfield 80	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$GeneralBuffer:bytes_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   73: invokevirtual 85	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   76: invokevirtual 91	com/tencent/mobileqq/pb/ByteStringMicro:size	()I
    //   79: ifle -50 -> 29
    //   82: new 93	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpateBuffer
    //   85: dup
    //   86: invokespecial 94	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpateBuffer:<init>	()V
    //   89: astore 5
    //   91: aload 5
    //   93: aload 6
    //   95: getfield 74	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$ContentItem:msg_general_buffer	Ltencent/im/oidb/cmd0x5d0/Oidb_0x5d0$GeneralBuffer;
    //   98: getfield 80	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$GeneralBuffer:bytes_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   101: invokevirtual 85	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   104: invokevirtual 98	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   107: invokevirtual 102	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpateBuffer:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   110: pop
    //   111: aload 5
    //   113: ifnull -84 -> 29
    //   116: aload 5
    //   118: getfield 105	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpateBuffer:rpt_msg_sns_update_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   121: invokevirtual 108	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   124: ifeq -95 -> 29
    //   127: aload 5
    //   129: getfield 105	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpateBuffer:rpt_msg_sns_update_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   132: invokevirtual 52	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   135: invokeinterface 58 1 0
    //   140: astore 6
    //   142: aload 6
    //   144: invokeinterface 64 1 0
    //   149: ifeq -120 -> 29
    //   152: aload 6
    //   154: invokeinterface 68 1 0
    //   159: checkcast 110	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpdateItem
    //   162: astore 7
    //   164: aload 7
    //   166: ifnull -24 -> 142
    //   169: aload 7
    //   171: getfield 114	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpdateItem:uint32_update_sns_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   174: invokevirtual 117	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   177: ifeq -35 -> 142
    //   180: aload 7
    //   182: getfield 118	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpdateItem:bytes_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   185: invokevirtual 119	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   188: ifeq -46 -> 142
    //   191: aload 7
    //   193: getfield 114	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpdateItem:uint32_update_sns_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   196: invokevirtual 121	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   199: sipush 13573
    //   202: if_icmpne -60 -> 142
    //   205: aload 5
    //   207: getfield 125	tencent/im/oidb/cmd0x5d0/Oidb_0x5d0$SnsUpateBuffer:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   210: invokevirtual 129	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   213: invokestatic 135	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   216: astore 7
    //   218: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +29 -> 250
    //   224: ldc 142
    //   226: iconst_2
    //   227: new 144	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   234: ldc 147
    //   236: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 7
    //   241: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: aload 7
    //   252: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   255: ifne -113 -> 142
    //   258: aload_1
    //   259: aload 7
    //   261: invokevirtual 169	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   264: ifne -122 -> 142
    //   267: aload_1
    //   268: aload 7
    //   270: invokevirtual 172	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   273: pop
    //   274: goto -132 -> 142
    //   277: astore_1
    //   278: aload_1
    //   279: invokevirtual 175	java/lang/Exception:printStackTrace	()V
    //   282: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +11 -> 296
    //   288: ldc 142
    //   290: iconst_2
    //   291: ldc 177
    //   293: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +37 -> 336
    //   302: ldc 142
    //   304: iconst_2
    //   305: new 144	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   312: ldc 179
    //   314: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   320: lload_2
    //   321: lsub
    //   322: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   325: ldc 184
    //   327: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   336: aconst_null
    //   337: areturn
    //   338: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   341: ifeq +37 -> 378
    //   344: ldc 142
    //   346: iconst_2
    //   347: new 144	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   354: ldc 179
    //   356: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   362: lload_2
    //   363: lsub
    //   364: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   367: ldc 184
    //   369: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: aload_1
    //   379: areturn
    //   380: astore_1
    //   381: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   384: ifeq +37 -> 421
    //   387: ldc 142
    //   389: iconst_2
    //   390: new 144	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   397: ldc 179
    //   399: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokestatic 37	java/lang/System:currentTimeMillis	()J
    //   405: lload_2
    //   406: lsub
    //   407: invokevirtual 182	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   410: ldc 184
    //   412: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: aload_1
    //   422: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	this	aaal
    //   0	423	1	paramVarArgs	java.lang.Void[]
    //   3	403	2	l	long
    //   27	13	4	localIterator	java.util.Iterator
    //   89	117	5	localSnsUpateBuffer	tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpateBuffer
    //   49	104	6	localObject1	java.lang.Object
    //   162	107	7	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   4	29	277	java/lang/Exception
    //   29	111	277	java/lang/Exception
    //   116	142	277	java/lang/Exception
    //   142	164	277	java/lang/Exception
    //   169	250	277	java/lang/Exception
    //   250	274	277	java/lang/Exception
    //   4	29	380	finally
    //   29	111	380	finally
    //   116	142	380	finally
    //   142	164	380	finally
    //   169	250	380	finally
    //   250	274	380	finally
    //   278	296	380	finally
  }
  
  protected void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null) {
      SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageSubAccountMessageProcessor.a, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramArrayList, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aaal
 * JD-Core Version:    0.7.0.1
 */