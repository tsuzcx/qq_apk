import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.RspStoryPic;
import com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.RspStoryVideo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor.StepInfo;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.StoryUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.HexUtil;
import java.util.HashMap;

public class aids
  implements ITransactionCallback
{
  public aids(StoryUploadProcessor paramStoryUploadProcessor, long paramLong) {}
  
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
    SLog.c(StoryUploadProcessor.jdField_a_of_type_JavaLangString, "Transaction End : Failed. take time:" + (l1 - this.jdField_a_of_type_Long) + "ms");
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.a(l2, l3, l4, l5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    String str1 = (String)paramHashMap.get("tc_p:");
    String str2 = (String)paramHashMap.get("rep_bdhTrans");
    String str3 = (String)paramHashMap.get("segspercnt");
    String str4 = (String)paramHashMap.get("param_conf_segSize");
    String str5 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    SLog.c(StoryUploadProcessor.jdField_a_of_type_JavaLangString, "Transaction End : Success. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms ,fileSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long + " transInfo:" + str2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", str1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str3);
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str4);
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.b();
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a = 1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.s = this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.q;
    SLog.c(StoryUploadProcessor.jdField_a_of_type_JavaLangString, "ITransactionCallback.onSuccess()");
    if (paramArrayOfByte == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.d();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.a(l2, l3, l4, l5);
      this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
      return;
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 196610)
      {
        paramHashMap = new qqstory_bhd_upload_pic.RspStoryPic();
        try
        {
          paramHashMap.mergeFrom(paramArrayOfByte);
          i = paramHashMap.retcode.get();
          if (i != 0) {
            break label567;
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_b_of_type_JavaLangString = paramHashMap.url.get().toStringUtf8();
          SLog.a(StoryUploadProcessor.jdField_a_of_type_JavaLangString, "upload file %s return url %s", this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.d, this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_b_of_type_JavaLangString);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_b_of_type_JavaLangString)) {
            break label557;
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_j_of_type_Int = 940010;
          this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_j_of_type_JavaLangString = String.format("return illegal arg url:%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_b_of_type_JavaLangString });
          this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.d();
          paramHashMap = HexUtil.a(paramArrayOfByte);
          str1 = StoryUploadProcessor.jdField_a_of_type_JavaLangString;
          paramArrayOfByte = paramHashMap;
          if (paramHashMap == null) {
            paramArrayOfByte = "";
          }
          SLog.e(str1, "url not return %s", new Object[] { paramArrayOfByte });
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          SLog.d(StoryUploadProcessor.jdField_a_of_type_JavaLangString, "parser buffer exception");
          this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.d();
        }
        continue;
        label557:
        this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.e();
        continue;
        label567:
        this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_j_of_type_Int = i;
        this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_j_of_type_JavaLangString = paramHashMap.msg.get().toStringUtf8();
        this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.d();
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 196609) || (this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 327681))
      {
        paramHashMap = new qqstory_bhd_upload_pic.RspStoryVideo();
        try
        {
          paramHashMap.mergeFrom(paramArrayOfByte);
          i = paramHashMap.retcode.get();
          if (i != 0) {
            break label871;
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.n = paramHashMap.cdn_url.get().toStringUtf8();
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 196609) {
            this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.n = UIUtils.a(this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.n, "authkey");
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.m = paramHashMap.file_key.get().toStringUtf8();
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.n)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.m))) {
            break label861;
          }
          this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_j_of_type_Int = 940010;
          this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_j_of_type_JavaLangString = String.format("return illegal arg vid:%s, url:%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.m, this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.n });
          this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.d();
          paramHashMap = HexUtil.a(paramArrayOfByte);
          str1 = StoryUploadProcessor.jdField_a_of_type_JavaLangString;
          paramArrayOfByte = paramHashMap;
          if (paramHashMap == null) {
            paramArrayOfByte = "";
          }
          SLog.e(str1, "url not return %s", new Object[] { paramArrayOfByte });
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          SLog.d(StoryUploadProcessor.jdField_a_of_type_JavaLangString, "parser buffer exception");
          this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.d();
        }
        continue;
        label861:
        this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.e();
        continue;
        label871:
        this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_j_of_type_Int = i;
        this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_j_of_type_JavaLangString = paramHashMap.msg.get().toStringUtf8();
        this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.d();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.d(1005);
        this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.d();
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    SLog.a(StoryUploadProcessor.jdField_a_of_type_JavaLangString, "onTransStart %s", this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i);
    long l1 = System.currentTimeMillis();
    long l2 = StoryUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor);
    String str2 = StoryReportor.a(BaseApplication.getContext());
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b == 196610) {}
    for (String str1 = "pic";; str1 = "video")
    {
      StoryReportor.b("publish_story", "publish_bdh", 0, 0, new String[] { "", String.valueOf(l1 - l2), str2, str1 });
      this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
      StoryUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor, System.currentTimeMillis());
      return;
    }
  }
  
  public void onUpdateProgress(int paramInt)
  {
    StoryUploadProcessor localStoryUploadProcessor = this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor;
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l = paramInt;
    localFileMsg.e = l;
    localStoryUploadProcessor.s = l;
    if ((paramInt <= this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.q) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.o) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.k)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileStoryUploadProcessor.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aids
 * JD-Core Version:    0.7.0.1
 */