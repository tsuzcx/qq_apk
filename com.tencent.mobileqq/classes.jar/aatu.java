import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipUploadRusult.StoryVideoExtRsp;
import com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipUploadRusult.UploadPicExtInfo;
import com.tencent.mobileqq.arcard.ARRelationShipFileUpload;
import com.tencent.mobileqq.arcard.ARRelationShipFileUpload.ARRelationShipFileUploadCallBack;
import com.tencent.mobileqq.arcard.ARRelationShipFileUpload.ARRelationShipReqInfo;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class aatu
  implements ITransactionCallback
{
  public aatu(ARRelationShipFileUpload paramARRelationShipFileUpload, ARRelationShipFileUpload.ARRelationShipReqInfo paramARRelationShipReqInfo) {}
  
  /* Error */
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 23
    //   5: astore 7
    //   7: aload_0
    //   8: getfield 13	aatu:jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload	Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload;
    //   11: invokestatic 28	com/tencent/mobileqq/arcard/ARRelationShipFileUpload:a	(Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload;)Ljava/lang/Object;
    //   14: astore 8
    //   16: aload 8
    //   18: monitorenter
    //   19: aload 7
    //   21: astore 5
    //   23: aload 6
    //   25: astore_2
    //   26: aload_0
    //   27: getfield 13	aatu:jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload	Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload;
    //   30: invokestatic 31	com/tencent/mobileqq/arcard/ARRelationShipFileUpload:a	(Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload;)Ljava/util/ArrayList;
    //   33: ifnull +117 -> 150
    //   36: iconst_0
    //   37: istore 4
    //   39: aload 7
    //   41: astore 5
    //   43: aload 6
    //   45: astore_2
    //   46: iload 4
    //   48: aload_0
    //   49: getfield 13	aatu:jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload	Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload;
    //   52: invokestatic 31	com/tencent/mobileqq/arcard/ARRelationShipFileUpload:a	(Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload;)Ljava/util/ArrayList;
    //   55: invokevirtual 37	java/util/ArrayList:size	()I
    //   58: if_icmpge +92 -> 150
    //   61: aload_0
    //   62: getfield 13	aatu:jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload	Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload;
    //   65: invokestatic 31	com/tencent/mobileqq/arcard/ARRelationShipFileUpload:a	(Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload;)Ljava/util/ArrayList;
    //   68: iload 4
    //   70: invokevirtual 41	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   73: checkcast 43	aatv
    //   76: getfield 44	aatv:jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload$ARRelationShipReqInfo	Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload$ARRelationShipReqInfo;
    //   79: getfield 50	com/tencent/mobileqq/arcard/ARRelationShipFileUpload$ARRelationShipReqInfo:b	Ljava/lang/String;
    //   82: aload_0
    //   83: getfield 15	aatu:jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload$ARRelationShipReqInfo	Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload$ARRelationShipReqInfo;
    //   86: getfield 50	com/tencent/mobileqq/arcard/ARRelationShipFileUpload$ARRelationShipReqInfo:b	Ljava/lang/String;
    //   89: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: ifeq +126 -> 218
    //   95: aload_0
    //   96: getfield 13	aatu:jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload	Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload;
    //   99: invokestatic 31	com/tencent/mobileqq/arcard/ARRelationShipFileUpload:a	(Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload;)Ljava/util/ArrayList;
    //   102: iload 4
    //   104: invokevirtual 41	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   107: checkcast 43	aatv
    //   110: getfield 59	aatv:jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload$ARRelationShipFileUploadCallBack	Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload$ARRelationShipFileUploadCallBack;
    //   113: astore_2
    //   114: aload_0
    //   115: getfield 13	aatu:jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload	Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload;
    //   118: invokestatic 31	com/tencent/mobileqq/arcard/ARRelationShipFileUpload:a	(Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload;)Ljava/util/ArrayList;
    //   121: iload 4
    //   123: invokevirtual 41	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   126: checkcast 43	aatv
    //   129: getfield 44	aatv:jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload$ARRelationShipReqInfo	Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload$ARRelationShipReqInfo;
    //   132: getfield 50	com/tencent/mobileqq/arcard/ARRelationShipFileUpload$ARRelationShipReqInfo:b	Ljava/lang/String;
    //   135: astore 5
    //   137: aload_0
    //   138: getfield 13	aatu:jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload	Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload;
    //   141: invokestatic 31	com/tencent/mobileqq/arcard/ARRelationShipFileUpload:a	(Lcom/tencent/mobileqq/arcard/ARRelationShipFileUpload;)Ljava/util/ArrayList;
    //   144: iload 4
    //   146: invokevirtual 62	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   149: pop
    //   150: aload 8
    //   152: monitorexit
    //   153: ldc 64
    //   155: iconst_1
    //   156: new 66	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   163: ldc 69
    //   165: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: iload_1
    //   169: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: ldc 78
    //   174: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_3
    //   178: ldc 80
    //   180: invokevirtual 85	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   183: checkcast 52	java/lang/String
    //   186: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc 87
    //   191: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 5
    //   196: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 97	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_2
    //   206: ifnull +11 -> 217
    //   209: aload_2
    //   210: aload 5
    //   212: invokeinterface 102 2 0
    //   217: return
    //   218: iload 4
    //   220: iconst_1
    //   221: iadd
    //   222: istore 4
    //   224: goto -185 -> 39
    //   227: astore_2
    //   228: aload 8
    //   230: monitorexit
    //   231: aload_2
    //   232: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	aatu
    //   0	233	1	paramInt	int
    //   0	233	2	paramArrayOfByte	byte[]
    //   0	233	3	paramHashMap	HashMap
    //   37	186	4	i	int
    //   21	190	5	str1	String
    //   1	43	6	localObject1	Object
    //   5	35	7	str2	String
    //   14	215	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	36	227	finally
    //   46	150	227	finally
    //   150	153	227	finally
    //   228	231	227	finally
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    Object localObject1 = null;
    String str2 = "";
    QLog.i("ARRelationShipFileUpload", 1, "Upload successfully. retCode = , IP = " + (String)paramHashMap.get("ip") + ", sessionId = " + "");
    Object localObject2 = ARRelationShipFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload);
    String str1 = str2;
    paramHashMap = (HashMap)localObject1;
    label261:
    do
    {
      for (;;)
      {
        int i;
        try
        {
          if (ARRelationShipFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload) != null)
          {
            i = 0;
            str1 = str2;
            paramHashMap = (HashMap)localObject1;
            if (i < ARRelationShipFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload).size())
            {
              if (!((aatv)ARRelationShipFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload).get(i)).jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload$ARRelationShipReqInfo.b.equals(this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload$ARRelationShipReqInfo.b)) {
                continue;
              }
              paramHashMap = ((aatv)ARRelationShipFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload).get(i)).jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload$ARRelationShipFileUploadCallBack;
              str1 = ((aatv)ARRelationShipFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload).get(i)).jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload$ARRelationShipReqInfo.b;
              ARRelationShipFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload).remove(i);
            }
          }
          if (this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload$ARRelationShipReqInfo.a != 1) {
            break label261;
          }
          localObject1 = new ARRelationShipUploadRusult.UploadPicExtInfo();
        }
        finally {}
        try
        {
          paramArrayOfByte = (ARRelationShipUploadRusult.UploadPicExtInfo)((ARRelationShipUploadRusult.UploadPicExtInfo)localObject1).mergeFrom(paramArrayOfByte);
          if (paramHashMap != null) {
            paramHashMap.a(str1, paramArrayOfByte);
          }
          return;
        }
        catch (Exception paramArrayOfByte)
        {
          if (paramHashMap == null) {
            continue;
          }
          paramHashMap.a(str1);
          return;
        }
        i += 1;
        continue;
        localObject1 = new ARRelationShipUploadRusult.StoryVideoExtRsp();
        try
        {
          paramArrayOfByte = (ARRelationShipUploadRusult.StoryVideoExtRsp)((ARRelationShipUploadRusult.StoryVideoExtRsp)localObject1).mergeFrom(paramArrayOfByte);
          if (paramHashMap != null)
          {
            paramHashMap.a(str1, paramArrayOfByte);
            return;
          }
        }
        catch (Exception paramArrayOfByte) {}
      }
    } while (paramHashMap == null);
    paramHashMap.a(str1);
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    QLog.i("ARRelationShipFileUpload", 1, "Upload start. sessionId = ");
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARRelationShipFileUpload", 2, "onUpdateProgress. sessionId = " + this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload$ARRelationShipReqInfo.b + ". total size = , transfered size = " + paramInt);
    }
    for (;;)
    {
      synchronized (ARRelationShipFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload))
      {
        if (ARRelationShipFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload) != null)
        {
          int i = 0;
          if (i < ARRelationShipFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload).size())
          {
            if (((aatv)ARRelationShipFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload).get(i)).jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload$ARRelationShipReqInfo.b.equals(this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload$ARRelationShipReqInfo.b))
            {
              ARRelationShipFileUpload.ARRelationShipFileUploadCallBack localARRelationShipFileUploadCallBack = ((aatv)ARRelationShipFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload).get(i)).jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload$ARRelationShipFileUploadCallBack;
              String str = ((aatv)ARRelationShipFileUpload.a(this.jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload).get(i)).jdField_a_of_type_ComTencentMobileqqArcardARRelationShipFileUpload$ARRelationShipReqInfo.b;
              if (localARRelationShipFileUploadCallBack != null) {
                localARRelationShipFileUploadCallBack.a(paramInt);
              }
              return;
            }
            i += 1;
          }
        }
      }
      Object localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aatu
 * JD-Core Version:    0.7.0.1
 */