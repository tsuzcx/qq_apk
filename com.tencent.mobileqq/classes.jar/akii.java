import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.PublicAccountIntent;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.FollowExt;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.FollowReq;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class akii
  extends MSFServlet
{
  private String a = "com.tencent.mobileqq.applets.NewPublicAccountServlet";
  
  protected byte[] a(FromServiceMsg paramFromServiceMsg)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFromServiceMsg != null)
    {
      localObject1 = localObject2;
      if (paramFromServiceMsg.isSuccess()) {
        localObject1 = bakc.b(paramFromServiceMsg.getWupBuffer());
      }
    }
    return localObject1;
  }
  
  /* Error */
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: aload_0
    //   7: getfield 14	akii:a	Ljava/lang/String;
    //   10: iconst_2
    //   11: ldc 44
    //   13: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_1
    //   17: ldc 50
    //   19: invokevirtual 56	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 6
    //   24: aload_0
    //   25: aload_2
    //   26: invokevirtual 58	akii:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)[B
    //   29: astore 5
    //   31: new 60	android/os/Bundle
    //   34: dup
    //   35: invokespecial 61	android/os/Bundle:<init>	()V
    //   38: astore 7
    //   40: aload 7
    //   42: ldc 63
    //   44: aload 5
    //   46: invokevirtual 67	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   49: aload 7
    //   51: ldc 69
    //   53: aload_2
    //   54: invokevirtual 73	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailCode	()I
    //   57: invokevirtual 77	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   60: ldc 79
    //   62: aload 6
    //   64: invokevirtual 85	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifeq +171 -> 238
    //   70: aload_1
    //   71: checkcast 87	com/tencent/mobileqq/applets/PublicAccountIntent
    //   74: invokevirtual 90	com/tencent/mobileqq/applets/PublicAccountIntent:a	()Lajfe;
    //   77: checkcast 92	akig
    //   80: astore 6
    //   82: aload_2
    //   83: invokevirtual 22	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   86: ifeq +273 -> 359
    //   89: new 94	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   92: dup
    //   93: invokespecial 95	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   96: astore_1
    //   97: aload_1
    //   98: aload 5
    //   100: checkcast 97	[B
    //   103: invokevirtual 101	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   106: checkcast 94	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   109: astore_2
    //   110: aload_2
    //   111: astore_1
    //   112: iconst_m1
    //   113: istore 4
    //   115: iload 4
    //   117: istore_3
    //   118: aload_1
    //   119: ifnull +65 -> 184
    //   122: iload 4
    //   124: istore_3
    //   125: aload_1
    //   126: getfield 105	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   129: invokevirtual 110	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   132: ifeq +52 -> 184
    //   135: aload_1
    //   136: getfield 105	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   139: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   142: istore 4
    //   144: iload 4
    //   146: istore_3
    //   147: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +34 -> 184
    //   153: aload_0
    //   154: getfield 14	akii:a	Ljava/lang/String;
    //   157: iconst_2
    //   158: new 115	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   165: ldc 118
    //   167: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: iload 4
    //   172: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   175: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 132	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: iload 4
    //   183: istore_3
    //   184: iload_3
    //   185: ifne +138 -> 323
    //   188: aload_1
    //   189: getfield 136	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   192: invokevirtual 139	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   195: ifeq +128 -> 323
    //   198: aload_1
    //   199: getfield 136	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   202: invokevirtual 142	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   205: ifnull +118 -> 323
    //   208: aload_1
    //   209: getfield 136	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   212: invokevirtual 142	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   215: invokevirtual 147	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   218: pop
    //   219: aload_0
    //   220: invokespecial 151	mqq/app/MSFServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   223: new 153	com/tencent/mobileqq/applets/NewPublicAccountServlet$1
    //   226: dup
    //   227: aload_0
    //   228: aload 6
    //   230: aload 5
    //   232: invokespecial 156	com/tencent/mobileqq/applets/NewPublicAccountServlet$1:<init>	(Lakii;Lakig;[B)V
    //   235: invokevirtual 162	mqq/app/AppRuntime:runOnUiThread	(Ljava/lang/Runnable;)V
    //   238: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +13 -> 254
    //   244: aload_0
    //   245: getfield 14	akii:a	Ljava/lang/String;
    //   248: iconst_2
    //   249: ldc 164
    //   251: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: return
    //   255: astore_2
    //   256: aload_0
    //   257: getfield 14	akii:a	Ljava/lang/String;
    //   260: iconst_4
    //   261: aload_2
    //   262: invokevirtual 167	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   265: aload_2
    //   266: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   269: goto -157 -> 112
    //   272: astore_1
    //   273: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq -38 -> 238
    //   279: aload_0
    //   280: getfield 14	akii:a	Ljava/lang/String;
    //   283: iconst_2
    //   284: iconst_2
    //   285: anewarray 173	java/lang/Object
    //   288: dup
    //   289: iconst_0
    //   290: ldc 175
    //   292: aastore
    //   293: dup
    //   294: iconst_1
    //   295: aload_1
    //   296: invokevirtual 176	java/lang/Exception:toString	()Ljava/lang/String;
    //   299: aastore
    //   300: invokestatic 179	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   303: goto -65 -> 238
    //   306: astore_2
    //   307: aload_0
    //   308: getfield 14	akii:a	Ljava/lang/String;
    //   311: iconst_4
    //   312: aload_2
    //   313: invokevirtual 180	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   316: aload_2
    //   317: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   320: goto -208 -> 112
    //   323: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq +13 -> 339
    //   329: aload_0
    //   330: getfield 14	akii:a	Ljava/lang/String;
    //   333: iconst_2
    //   334: ldc 182
    //   336: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: aload_0
    //   340: invokespecial 151	mqq/app/MSFServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   343: new 184	com/tencent/mobileqq/applets/NewPublicAccountServlet$2
    //   346: dup
    //   347: aload_0
    //   348: aload 6
    //   350: invokespecial 187	com/tencent/mobileqq/applets/NewPublicAccountServlet$2:<init>	(Lakii;Lakig;)V
    //   353: invokevirtual 162	mqq/app/AppRuntime:runOnUiThread	(Ljava/lang/Runnable;)V
    //   356: goto -118 -> 238
    //   359: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +33 -> 395
    //   365: aload_0
    //   366: getfield 14	akii:a	Ljava/lang/String;
    //   369: iconst_2
    //   370: new 115	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   377: ldc 189
    //   379: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_2
    //   383: invokevirtual 73	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailCode	()I
    //   386: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   389: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: aload_0
    //   396: invokespecial 151	mqq/app/MSFServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   399: new 191	com/tencent/mobileqq/applets/NewPublicAccountServlet$3
    //   402: dup
    //   403: aload_0
    //   404: aload 6
    //   406: invokespecial 192	com/tencent/mobileqq/applets/NewPublicAccountServlet$3:<init>	(Lakii;Lakig;)V
    //   409: invokevirtual 162	mqq/app/AppRuntime:runOnUiThread	(Ljava/lang/Runnable;)V
    //   412: goto -174 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	this	akii
    //   0	415	1	paramIntent	Intent
    //   0	415	2	paramFromServiceMsg	FromServiceMsg
    //   117	68	3	i	int
    //   113	69	4	j	int
    //   29	202	5	arrayOfByte	byte[]
    //   22	383	6	localObject	Object
    //   38	12	7	localBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   97	110	255	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   70	97	272	java/lang/Exception
    //   125	144	272	java/lang/Exception
    //   147	181	272	java/lang/Exception
    //   188	238	272	java/lang/Exception
    //   256	269	272	java/lang/Exception
    //   307	320	272	java/lang/Exception
    //   323	339	272	java/lang/Exception
    //   339	356	272	java/lang/Exception
    //   359	395	272	java/lang/Exception
    //   395	412	272	java/lang/Exception
    //   97	110	306	java/lang/Exception
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "onSend");
    }
    paramIntent.getByteArrayExtra("data");
    Object localObject1 = paramIntent.getStringExtra("BUNDLE_PUBLIC_ACCOUNT_CMD");
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, new Object[] { "cmd=", localObject1 });
    }
    if ("newFollow".equals(localObject1)) {
      paramIntent = (PublicAccountIntent)paramIntent;
    }
    while (!QLog.isColorLevel()) {
      try
      {
        localObject1 = (QQAppInterface)super.getAppRuntime();
        localObject2 = (akig)paramIntent.a();
        ((akig)localObject2).a((QQAppInterface)localObject1);
        ((QQAppInterface)localObject1).addObserver((ajfe)localObject2);
        akil.a((QQAppInterface)localObject1, paramIntent.getBooleanExtra("BUNDLE_PUBLIC_ACCOUNT_IS_FOLLOW", false), paramIntent.getStringExtra("BUNDLE_PUBLIC_ACCOUNT_UIN"), paramIntent.getIntExtra("BUNDLE_PUBLIC_ACCOUNT_SOURCE", 0));
        paramPacket.setSSOCommand(null);
        return;
      }
      catch (ClassCastException localClassCastException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a, 2, new Object[] { "ClassCastException e", localClassCastException.toString() });
        }
        oidb_cmd0xc96.ReqBody localReqBody = new oidb_cmd0xc96.ReqBody();
        localReqBody.puin.set(Long.parseLong(paramIntent.getStringExtra("BUNDLE_PUBLIC_ACCOUNT_UIN")));
        Object localObject2 = new oidb_cmd0xc96.FollowExt();
        ((oidb_cmd0xc96.FollowExt)localObject2).source_from.set(paramIntent.getIntExtra("BUNDLE_PUBLIC_ACCOUNT_SOURCE", 0));
        paramIntent = new oidb_cmd0xc96.FollowReq();
        paramIntent.ext.set((MessageMicro)localObject2);
        localReqBody.follow_req.set(paramIntent);
        localReqBody.cmd_type.set(1);
        paramIntent = new oidb_sso.OIDBSSOPkg();
        paramIntent.uint32_command.set(3222);
        paramIntent.uint32_result.set(0);
        paramIntent.uint32_service_type.set(0);
        paramIntent.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
        paramIntent = paramIntent.toByteArray();
        paramPacket.setSSOCommand("OidbSvc.0xc96");
        paramPacket.putSendData(bakc.a(paramIntent));
      }
    }
    QLog.d(this.a, 2, "onSend exit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akii
 * JD-Core Version:    0.7.0.1
 */