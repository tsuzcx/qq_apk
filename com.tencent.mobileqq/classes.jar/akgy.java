import android.content.SharedPreferences;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerHandler.1;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.ReqBody;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.ReqGetList;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.ReqBody;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class akgy
  extends ajtd
{
  public akgy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private static oidb_sso.OIDBSSOPkg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
      paramToServiceMsg = null;
    }
    for (;;)
    {
      return paramToServiceMsg;
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg.bytes_bodybuffer.get() != null) {
            continue;
          }
        }
        return null;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StrangerHandler", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
          }
        }
      }
    }
  }
  
  /* Error */
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: aload_3
    //   3: invokestatic 66	akgy:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +25 -> 33
    //   11: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +11 -> 25
    //   17: ldc 56
    //   19: iconst_2
    //   20: ldc 68
    //   22: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aload_0
    //   26: iconst_2
    //   27: iconst_0
    //   28: aconst_null
    //   29: invokevirtual 72	akgy:notifyUI	(IZLjava/lang/Object;)V
    //   32: return
    //   33: new 74	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody
    //   36: dup
    //   37: invokespecial 75	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:<init>	()V
    //   40: astore 6
    //   42: aconst_null
    //   43: astore_3
    //   44: aload 6
    //   46: aload_2
    //   47: getfield 43	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   50: invokevirtual 48	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   53: invokevirtual 81	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   56: invokevirtual 82	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   59: pop
    //   60: aload_1
    //   61: ldc 84
    //   63: invokevirtual 90	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   66: checkcast 92	java/lang/Integer
    //   69: invokevirtual 95	java/lang/Integer:intValue	()I
    //   72: istore 5
    //   74: aload 6
    //   76: getfield 99	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   79: getfield 104	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: istore 4
    //   87: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +39 -> 129
    //   93: ldc 56
    //   95: iconst_2
    //   96: new 106	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   103: ldc 109
    //   105: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: iload 5
    //   110: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc 118
    //   115: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload 4
    //   120: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: iload 5
    //   131: iload 4
    //   133: if_icmpeq +474 -> 607
    //   136: aload 6
    //   138: getfield 99	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   141: getfield 126	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   144: invokevirtual 131	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   147: astore_1
    //   148: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +53 -> 204
    //   154: ldc 56
    //   156: iconst_2
    //   157: new 106	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   164: ldc 109
    //   166: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: iload 5
    //   171: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: ldc 118
    //   176: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload 4
    //   181: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: ldc 133
    //   186: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_1
    //   190: invokeinterface 138 1 0
    //   195: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_0
    //   205: getfield 142	akgy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   208: invokevirtual 148	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lauko;
    //   211: invokevirtual 154	auko:createEntityManager	()Laukn;
    //   214: astore_2
    //   215: aload_2
    //   216: ldc 156
    //   218: invokevirtual 161	aukn:a	(Ljava/lang/Class;)Ljava/util/List;
    //   221: astore 6
    //   223: aload 6
    //   225: ifnonnull +432 -> 657
    //   228: new 163	java/util/ArrayList
    //   231: dup
    //   232: invokespecial 164	java/util/ArrayList:<init>	()V
    //   235: astore 6
    //   237: aload_1
    //   238: invokeinterface 168 1 0
    //   243: astore 8
    //   245: aconst_null
    //   246: astore_1
    //   247: aload 8
    //   249: invokeinterface 173 1 0
    //   254: ifeq +193 -> 447
    //   257: aload 8
    //   259: invokeinterface 177 1 0
    //   264: checkcast 179	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList
    //   267: astore_3
    //   268: aload_3
    //   269: getfield 183	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   272: invokevirtual 188	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   275: invokestatic 194	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   278: astore 9
    //   280: aload_3
    //   281: getfield 197	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   284: invokevirtual 48	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   287: invokevirtual 200	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   290: astore 10
    //   292: aload_2
    //   293: ldc 156
    //   295: aload 9
    //   297: invokevirtual 203	aukn:a	(Ljava/lang/Class;Ljava/lang/String;)Laukm;
    //   300: checkcast 156	com/tencent/mobileqq/data/Stranger
    //   303: astore 7
    //   305: aload 7
    //   307: ifnonnull +62 -> 369
    //   310: new 156	com/tencent/mobileqq/data/Stranger
    //   313: dup
    //   314: invokespecial 204	com/tencent/mobileqq/data/Stranger:<init>	()V
    //   317: astore_3
    //   318: aload_3
    //   319: aload 9
    //   321: putfield 207	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   324: aload_3
    //   325: aload 10
    //   327: putfield 210	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   330: aload_2
    //   331: aload_3
    //   332: invokevirtual 213	aukn:a	(Laukm;)V
    //   335: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   338: ifeq +322 -> 660
    //   341: ldc 56
    //   343: iconst_2
    //   344: new 106	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   351: ldc 215
    //   353: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_3
    //   357: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: goto +294 -> 660
    //   369: aload 7
    //   371: aload 10
    //   373: putfield 210	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   376: aload_2
    //   377: aload 7
    //   379: invokevirtual 221	aukn:a	(Laukm;)Z
    //   382: pop
    //   383: aload 6
    //   385: invokeinterface 168 1 0
    //   390: astore 9
    //   392: aload_1
    //   393: astore_3
    //   394: aload 9
    //   396: invokeinterface 173 1 0
    //   401: ifeq +29 -> 430
    //   404: aload 9
    //   406: invokeinterface 177 1 0
    //   411: checkcast 156	com/tencent/mobileqq/data/Stranger
    //   414: astore_3
    //   415: aload_3
    //   416: getfield 207	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   419: aload 7
    //   421: getfield 207	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   424: invokestatic 227	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   427: ifeq -35 -> 392
    //   430: aload 6
    //   432: aload_3
    //   433: invokeinterface 231 2 0
    //   438: pop
    //   439: aload_3
    //   440: astore_1
    //   441: aload 7
    //   443: astore_3
    //   444: goto -109 -> 335
    //   447: aload 6
    //   449: invokeinterface 168 1 0
    //   454: astore_3
    //   455: aload_3
    //   456: invokeinterface 173 1 0
    //   461: ifeq +78 -> 539
    //   464: aload_3
    //   465: invokeinterface 177 1 0
    //   470: checkcast 156	com/tencent/mobileqq/data/Stranger
    //   473: astore_1
    //   474: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   477: ifeq +28 -> 505
    //   480: ldc 56
    //   482: iconst_2
    //   483: new 106	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   490: ldc 233
    //   492: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload_1
    //   496: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   505: aload_2
    //   506: aload_1
    //   507: invokevirtual 235	aukn:b	(Laukm;)Z
    //   510: pop
    //   511: goto -56 -> 455
    //   514: astore_3
    //   515: aload_2
    //   516: astore_1
    //   517: aload_3
    //   518: astore_2
    //   519: aload_2
    //   520: invokevirtual 238	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   523: aload_1
    //   524: ifnull +7 -> 531
    //   527: aload_1
    //   528: invokevirtual 240	aukn:a	()V
    //   531: aload_0
    //   532: iconst_2
    //   533: iconst_0
    //   534: aconst_null
    //   535: invokevirtual 72	akgy:notifyUI	(IZLjava/lang/Object;)V
    //   538: return
    //   539: aload_0
    //   540: getfield 142	akgy:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   543: invokevirtual 244	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   546: invokeinterface 250 1 0
    //   551: astore_1
    //   552: aload_1
    //   553: ldc 252
    //   555: iload 4
    //   557: invokeinterface 258 3 0
    //   562: pop
    //   563: aload_1
    //   564: invokeinterface 261 1 0
    //   569: pop
    //   570: aload_2
    //   571: ldc 156
    //   573: invokevirtual 161	aukn:a	(Ljava/lang/Class;)Ljava/util/List;
    //   576: astore_3
    //   577: aload_3
    //   578: astore_1
    //   579: aload_3
    //   580: ifnonnull +11 -> 591
    //   583: new 163	java/util/ArrayList
    //   586: dup
    //   587: invokespecial 164	java/util/ArrayList:<init>	()V
    //   590: astore_1
    //   591: aload_0
    //   592: iconst_2
    //   593: iconst_1
    //   594: aload_1
    //   595: invokevirtual 72	akgy:notifyUI	(IZLjava/lang/Object;)V
    //   598: aload_2
    //   599: ifnull -567 -> 32
    //   602: aload_2
    //   603: invokevirtual 240	aukn:a	()V
    //   606: return
    //   607: aload_0
    //   608: iconst_2
    //   609: iconst_1
    //   610: aconst_null
    //   611: invokevirtual 72	akgy:notifyUI	(IZLjava/lang/Object;)V
    //   614: iconst_0
    //   615: ifeq -583 -> 32
    //   618: new 263	java/lang/NullPointerException
    //   621: dup
    //   622: invokespecial 264	java/lang/NullPointerException:<init>	()V
    //   625: athrow
    //   626: astore_1
    //   627: aconst_null
    //   628: astore_2
    //   629: aload_2
    //   630: ifnull +7 -> 637
    //   633: aload_2
    //   634: invokevirtual 240	aukn:a	()V
    //   637: aload_1
    //   638: athrow
    //   639: astore_1
    //   640: goto -11 -> 629
    //   643: astore_3
    //   644: aload_1
    //   645: astore_2
    //   646: aload_3
    //   647: astore_1
    //   648: goto -19 -> 629
    //   651: astore_2
    //   652: aload_3
    //   653: astore_1
    //   654: goto -135 -> 519
    //   657: goto -420 -> 237
    //   660: goto -413 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	663	0	this	akgy
    //   0	663	1	paramToServiceMsg	ToServiceMsg
    //   0	663	2	paramFromServiceMsg	FromServiceMsg
    //   0	663	3	paramObject	Object
    //   85	471	4	i	int
    //   72	98	5	j	int
    //   40	408	6	localObject1	Object
    //   303	139	7	localStranger	com.tencent.mobileqq.data.Stranger
    //   243	15	8	localIterator	Iterator
    //   278	127	9	localObject2	Object
    //   290	82	10	str	String
    // Exception table:
    //   from	to	target	type
    //   215	223	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   228	237	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   237	245	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   247	305	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   310	335	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   335	366	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   369	392	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   394	430	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   430	439	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   447	455	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   455	505	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   505	511	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   539	577	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   583	591	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   591	598	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   44	129	626	finally
    //   136	204	626	finally
    //   204	215	626	finally
    //   607	614	626	finally
    //   215	223	639	finally
    //   228	237	639	finally
    //   237	245	639	finally
    //   247	305	639	finally
    //   310	335	639	finally
    //   335	366	639	finally
    //   369	392	639	finally
    //   394	430	639	finally
    //   430	439	639	finally
    //   447	455	639	finally
    //   455	505	639	finally
    //   505	511	639	finally
    //   539	577	639	finally
    //   583	591	639	finally
    //   591	598	639	finally
    //   519	523	643	finally
    //   44	129	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   136	204	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   204	215	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   607	614	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerHandler", 2, "getListLocal ");
    }
    StrangerHandler.1 local1 = new StrangerHandler.1(this);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      this.app.a(local1);
      return;
    }
    local1.run();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    if (paramFromServiceMsg == null)
    {
      notifyUI(4, false, null);
      if (QLog.isColorLevel()) {
        QLog.d("StrangerHandler", 2, "handleDeleteStranger: ssoPkg parse failed");
      }
    }
    for (;;)
    {
      return;
      paramToServiceMsg = new oidb_0x5d4.RspBody();
      try
      {
        paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramObject = this.app.a().a();
        paramFromServiceMsg = paramToServiceMsg.result.get().iterator();
        while (paramFromServiceMsg.hasNext())
        {
          Object localObject = (oidb_0x5d4.DelResult)paramFromServiceMsg.next();
          if (((oidb_0x5d4.DelResult)localObject).res.get() == 0)
          {
            localObject = paramObject.b(String.valueOf(((oidb_0x5d4.DelResult)localObject).uin.get()), 0);
            if (localObject != null) {
              paramObject.b((RecentUser)localObject);
            }
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if (0 != 0) {
          throw new NullPointerException();
        }
        notifyUI(4, false, null);
        return;
        notifyUI(4, true, paramToServiceMsg.result);
      }
      finally
      {
        if (0 != 0) {
          throw new NullPointerException();
        }
      }
    }
  }
  
  public boolean a(List<Long> paramList)
  {
    Object localObject = new oidb_0x5d4.ReqBody();
    ((oidb_0x5d4.ReqBody)localObject).uin_list.set(paramList);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(1492);
    paramList.uint32_result.set(0);
    paramList.uint32_service_type.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d4.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x5d4_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(60000L);
    QLog.d("StrangerHandler", 2, "deleteStrangers request = " + ((ToServiceMsg)localObject).toString());
    sendPbReq((ToServiceMsg)localObject);
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerHandler", 2, "getListRemote force = " + paramBoolean);
    }
    int i = this.app.getPreferences().getInt("strange_oidb_get_list_seq_id", 0);
    if (paramBoolean) {
      i = 0;
    }
    Object localObject = new oidb_0x5d2.ReqBody();
    ((oidb_0x5d2.ReqBody)localObject).sub_cmd.set(1);
    ((oidb_0x5d2.ReqBody)localObject).req_get_list.setHasFlag(true);
    ((oidb_0x5d2.ReqBody)localObject).req_get_list.seq.set(i);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1490);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d2.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x5d2_0");
    ((ToServiceMsg)localObject).addAttribute("StrangerHandlerSubCmd", Integer.valueOf(1));
    ((ToServiceMsg)localObject).addAttribute("StrangerHandlerSeqId", Integer.valueOf(i));
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(60000L);
    QLog.d("StrangerHandler", 2, "getListRemote request = " + ((ToServiceMsg)localObject).toString());
    sendPbReq((ToServiceMsg)localObject);
    return true;
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return akgz.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("OidbSvc.0x5d4_0".equalsIgnoreCase(str)) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while ((!"OidbSvc.0x5d2_0".equalsIgnoreCase(str)) || (((Integer)paramToServiceMsg.getAttribute("StrangerHandlerSubCmd", Integer.valueOf(1))).intValue() != 1)) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akgy
 * JD-Core Version:    0.7.0.1
 */