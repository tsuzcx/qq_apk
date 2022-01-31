import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.transfile.BaseTransProcessor.StepInfo;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class aich
  implements ITransactionCallback
{
  public aich(NearbyPeoplePhotoUploadProcessor paramNearbyPeoplePhotoUploadProcessor, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.a(l2, l3, l4, l5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    long l5 = SystemClock.uptimeMillis();
    long l1 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l2 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    String str1 = (String)paramHashMap.get("tc_p:");
    String str2 = (String)paramHashMap.get("rep_bdhTrans");
    String str3 = (String)paramHashMap.get("segspercnt");
    String str4 = (String)paramHashMap.get("param_conf_segSize");
    String str5 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel()) {
      QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l5 - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long + " transInfo:" + str2);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", str1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str3);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str4);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.b();
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.s = this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.q;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 50) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 51)) {
      paramHashMap = new Bdh_extinfo.UploadPicExtInfo();
    }
    for (;;)
    {
      try
      {
        paramHashMap.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
        this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.n = paramHashMap.bytes_file_resid.get().toStringUtf8();
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.n))
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.e();
          this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.a(l1, l2, l3, l4);
          this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        continue;
        this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.d();
        continue;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 54)
      {
        paramHashMap = new Bdh_extinfo.UploadPicExtInfo();
        try
        {
          paramHashMap.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
          this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaLangString = paramHashMap.bytes_download_url.get().toStringUtf8();
          this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_b_of_type_JavaLangString = paramHashMap.bytes_thumb_download_url.get().toStringUtf8();
          this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.e();
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          for (;;)
          {
            paramArrayOfByte.printStackTrace();
          }
        }
      }
      else
      {
        paramHashMap = ByteBuffer.wrap(paramArrayOfByte);
        int i = paramHashMap.get();
        if (QLog.isColorLevel()) {
          QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(), business result code = " + i);
        }
        if (i == 0)
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 8) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 64)) {
            NearbyPeoplePhotoUploadProcessor.jdField_a_of_type_Int = Integer.parseInt(new String(paramArrayOfByte, 2, paramHashMap.get() & 0xFF));
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.e();
            break;
            if (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 21)
            {
              i = paramHashMap.get();
              this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaLangString = new String(paramArrayOfByte, 2, i & 0xFF);
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 22)
            {
              i = paramHashMap.get();
              this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaLangString = new String(paramArrayOfByte, 2, i & 0xFF);
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 35)
            {
              this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
            }
            else if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 36) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 37) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 38) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 39) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 40) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 41))
            {
              i = paramHashMap.get();
              int j = paramHashMap.get();
              int k = paramHashMap.get();
              int m = paramHashMap.get();
              this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.m = new String(paramArrayOfByte, 5, (m & 0xFF) << 24 | 0x0 | i | (j & 0xFF) << 8 | (k & 0xFF) << 16);
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 48)
            {
              i = paramHashMap.get();
              this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaLangString = new String(paramArrayOfByte, 2, i & 0xFF);
            }
            else if (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 56)
            {
              try
              {
                paramHashMap.getInt();
                l5 = paramHashMap.getLong();
                i = paramHashMap.getInt();
                this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaLangString = new String(paramArrayOfByte, paramHashMap.position(), i);
                if (QLog.isColorLevel()) {
                  QLog.i("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(). personalityLabel uuid:" + l5 + " url:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaLangString);
                }
                this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.j;
                this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_d_of_type_Long = l5;
                this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i = this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaLangString;
                if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i)) {
                  this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.i = this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i;
                }
              }
              catch (Exception paramArrayOfByte) {}
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 34)
        {
          paramArrayOfByte = new String(paramArrayOfByte);
          this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaLangString = paramArrayOfByte;
          this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.e();
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.d(1005);
          this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.d();
        }
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.d("<BDH_LOG> onTransStart()");
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    NearbyPeoplePhotoUploadProcessor localNearbyPeoplePhotoUploadProcessor = this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor;
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l = paramInt;
    localFileMsg.e = l;
    localNearbyPeoplePhotoUploadProcessor.s = l;
    if ((paramInt <= this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.q) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.o) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.k)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aich
 * JD-Core Version:    0.7.0.1
 */