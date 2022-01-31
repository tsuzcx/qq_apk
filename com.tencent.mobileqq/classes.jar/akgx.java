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

public class akgx
  extends ajtb
{
  public akgx(QQAppInterface paramQQAppInterface)
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
    //   3: invokestatic 66	akgx:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;
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
    //   29: invokevirtual 72	akgx:notifyUI	(IZLjava/lang/Object;)V
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
    //   72: istore 4
    //   74: aload 6
    //   76: getfield 99	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   79: getfield 104	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   82: invokevirtual 39	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   85: istore 5
    //   87: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +39 -> 129
    //   93: ldc 56
    //   95: iconst_2
    //   96: new 106	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   103: ldc 109
    //   105: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: iload 4
    //   110: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc 118
    //   115: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload 5
    //   120: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: iload 4
    //   131: iload 5
    //   133: if_icmpeq +476 -> 609
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
    //   169: iload 4
    //   171: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   174: ldc 118
    //   176: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload 5
    //   181: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: ldc 133
    //   186: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_1
    //   190: invokeinterface 138 1 0
    //   195: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_0
    //   205: getfield 142	akgx:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   208: invokevirtual 148	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Laukq;
    //   211: invokevirtual 154	aukq:createEntityManager	()Laukp;
    //   214: astore_2
    //   215: aload_2
    //   216: ldc 156
    //   218: invokevirtual 161	aukp:a	(Ljava/lang/Class;)Ljava/util/List;
    //   221: astore 6
    //   223: aload 6
    //   225: ifnonnull +434 -> 659
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
    //   254: ifeq +195 -> 449
    //   257: aload 8
    //   259: invokeinterface 177 1 0
    //   264: checkcast 179	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList
    //   267: astore 7
    //   269: aload 7
    //   271: getfield 183	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   274: invokevirtual 188	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   277: invokestatic 194	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   280: astore_3
    //   281: aload 7
    //   283: getfield 197	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   286: invokevirtual 48	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   289: invokevirtual 200	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   292: astore 9
    //   294: aload_2
    //   295: ldc 156
    //   297: aload_3
    //   298: invokevirtual 203	aukp:a	(Ljava/lang/Class;Ljava/lang/String;)Lauko;
    //   301: checkcast 156	com/tencent/mobileqq/data/Stranger
    //   304: astore 7
    //   306: aload 7
    //   308: ifnonnull +66 -> 374
    //   311: new 156	com/tencent/mobileqq/data/Stranger
    //   314: dup
    //   315: invokespecial 204	com/tencent/mobileqq/data/Stranger:<init>	()V
    //   318: astore 7
    //   320: aload 7
    //   322: aload_3
    //   323: putfield 207	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   326: aload 7
    //   328: aload 9
    //   330: putfield 210	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   333: aload_2
    //   334: aload 7
    //   336: invokevirtual 213	aukp:a	(Lauko;)V
    //   339: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   342: ifeq +320 -> 662
    //   345: ldc 56
    //   347: iconst_2
    //   348: new 106	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   355: ldc 215
    //   357: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload 7
    //   362: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   371: goto +291 -> 662
    //   374: aload 7
    //   376: aload 9
    //   378: putfield 210	com/tencent/mobileqq/data/Stranger:name	Ljava/lang/String;
    //   381: aload_2
    //   382: aload 7
    //   384: invokevirtual 221	aukp:a	(Lauko;)Z
    //   387: pop
    //   388: aload 6
    //   390: invokeinterface 168 1 0
    //   395: astore 9
    //   397: aload_1
    //   398: astore_3
    //   399: aload 9
    //   401: invokeinterface 173 1 0
    //   406: ifeq +29 -> 435
    //   409: aload 9
    //   411: invokeinterface 177 1 0
    //   416: checkcast 156	com/tencent/mobileqq/data/Stranger
    //   419: astore_3
    //   420: aload_3
    //   421: getfield 207	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   424: aload 7
    //   426: getfield 207	com/tencent/mobileqq/data/Stranger:uin	Ljava/lang/String;
    //   429: invokestatic 227	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   432: ifeq -35 -> 397
    //   435: aload 6
    //   437: aload_3
    //   438: invokeinterface 231 2 0
    //   443: pop
    //   444: aload_3
    //   445: astore_1
    //   446: goto -107 -> 339
    //   449: aload 6
    //   451: invokeinterface 168 1 0
    //   456: astore_1
    //   457: aload_1
    //   458: invokeinterface 173 1 0
    //   463: ifeq +78 -> 541
    //   466: aload_1
    //   467: invokeinterface 177 1 0
    //   472: checkcast 156	com/tencent/mobileqq/data/Stranger
    //   475: astore_3
    //   476: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +28 -> 507
    //   482: ldc 56
    //   484: iconst_2
    //   485: new 106	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   492: ldc 233
    //   494: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload_3
    //   498: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   507: aload_2
    //   508: aload_3
    //   509: invokevirtual 235	aukp:b	(Lauko;)Z
    //   512: pop
    //   513: goto -56 -> 457
    //   516: astore_3
    //   517: aload_2
    //   518: astore_1
    //   519: aload_3
    //   520: astore_2
    //   521: aload_2
    //   522: invokevirtual 238	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   525: aload_1
    //   526: ifnull +7 -> 533
    //   529: aload_1
    //   530: invokevirtual 240	aukp:a	()V
    //   533: aload_0
    //   534: iconst_2
    //   535: iconst_0
    //   536: aconst_null
    //   537: invokevirtual 72	akgx:notifyUI	(IZLjava/lang/Object;)V
    //   540: return
    //   541: aload_0
    //   542: getfield 142	akgx:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   545: invokevirtual 244	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   548: invokeinterface 250 1 0
    //   553: astore_1
    //   554: aload_1
    //   555: ldc 252
    //   557: iload 5
    //   559: invokeinterface 258 3 0
    //   564: pop
    //   565: aload_1
    //   566: invokeinterface 261 1 0
    //   571: pop
    //   572: aload_2
    //   573: ldc 156
    //   575: invokevirtual 161	aukp:a	(Ljava/lang/Class;)Ljava/util/List;
    //   578: astore_3
    //   579: aload_3
    //   580: astore_1
    //   581: aload_3
    //   582: ifnonnull +11 -> 593
    //   585: new 163	java/util/ArrayList
    //   588: dup
    //   589: invokespecial 164	java/util/ArrayList:<init>	()V
    //   592: astore_1
    //   593: aload_0
    //   594: iconst_2
    //   595: iconst_1
    //   596: aload_1
    //   597: invokevirtual 72	akgx:notifyUI	(IZLjava/lang/Object;)V
    //   600: aload_2
    //   601: ifnull -569 -> 32
    //   604: aload_2
    //   605: invokevirtual 240	aukp:a	()V
    //   608: return
    //   609: aload_0
    //   610: iconst_2
    //   611: iconst_1
    //   612: aconst_null
    //   613: invokevirtual 72	akgx:notifyUI	(IZLjava/lang/Object;)V
    //   616: iconst_0
    //   617: ifeq -585 -> 32
    //   620: new 263	java/lang/NullPointerException
    //   623: dup
    //   624: invokespecial 264	java/lang/NullPointerException:<init>	()V
    //   627: athrow
    //   628: astore_1
    //   629: aconst_null
    //   630: astore_2
    //   631: aload_2
    //   632: ifnull +7 -> 639
    //   635: aload_2
    //   636: invokevirtual 240	aukp:a	()V
    //   639: aload_1
    //   640: athrow
    //   641: astore_1
    //   642: goto -11 -> 631
    //   645: astore_3
    //   646: aload_1
    //   647: astore_2
    //   648: aload_3
    //   649: astore_1
    //   650: goto -19 -> 631
    //   653: astore_2
    //   654: aload_3
    //   655: astore_1
    //   656: goto -135 -> 521
    //   659: goto -422 -> 237
    //   662: goto -415 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	665	0	this	akgx
    //   0	665	1	paramToServiceMsg	ToServiceMsg
    //   0	665	2	paramFromServiceMsg	FromServiceMsg
    //   0	665	3	paramObject	Object
    //   72	98	4	i	int
    //   85	473	5	j	int
    //   40	410	6	localObject1	Object
    //   267	158	7	localObject2	Object
    //   243	15	8	localIterator	Iterator
    //   292	118	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   215	223	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   228	237	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   237	245	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   247	306	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   311	339	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   339	371	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   374	397	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   399	435	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   435	444	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   449	457	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   457	507	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   507	513	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   541	579	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   585	593	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   593	600	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   44	129	628	finally
    //   136	204	628	finally
    //   204	215	628	finally
    //   609	616	628	finally
    //   215	223	641	finally
    //   228	237	641	finally
    //   237	245	641	finally
    //   247	306	641	finally
    //   311	339	641	finally
    //   339	371	641	finally
    //   374	397	641	finally
    //   399	435	641	finally
    //   435	444	641	finally
    //   449	457	641	finally
    //   457	507	641	finally
    //   507	513	641	finally
    //   541	579	641	finally
    //   585	593	641	finally
    //   593	600	641	finally
    //   521	525	645	finally
    //   44	129	653	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   136	204	653	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   204	215	653	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   609	616	653	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
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
  
  protected Class<? extends ajte> observerClass()
  {
    return akgy.class;
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
 * Qualified Name:     akgx
 * JD-Core Version:    0.7.0.1
 */