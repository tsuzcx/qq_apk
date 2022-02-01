import android.content.Intent;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.file.DevLittleVideoOperator.1;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.StringUtil;
import mqq.os.MqqHandler;

public class aasf
  extends BaseShortVideoOprerator
{
  public aasf() {}
  
  public aasf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public bbqj a(Object paramObject, bbqx parambbqx)
  {
    return null;
  }
  
  public bbrp a(Object paramObject, bbqx parambbqx)
  {
    if (paramObject == null)
    {
      ayde.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "unknow obj");
      return null;
    }
    String str7 = "0";
    String str6 = "0";
    int m = 0;
    long l = 0L;
    int k = 0;
    String str5 = "";
    String str4 = "";
    Object localObject = "";
    String str3 = "";
    boolean bool = false;
    int j = 0;
    int i = 0;
    String str2 = "";
    String str1 = "";
    if ((paramObject instanceof Intent))
    {
      localObject = (Intent)paramObject;
      str7 = ((Intent)localObject).getStringExtra("uin");
      str6 = ((Intent)localObject).getStringExtra("troop_uin");
      m = ((Intent)localObject).getIntExtra("uintype", 1003);
      l = ((Intent)localObject).getLongExtra("file_send_size", 0L);
      ((Intent)localObject).getIntExtra("file_send_business_type", -1);
      k = ((Intent)localObject).getIntExtra("file_send_duration", -1);
      str5 = ((Intent)localObject).getStringExtra("file_send_path");
      str4 = ((Intent)localObject).getStringExtra("thumbfile_send_path");
      str3 = ((Intent)localObject).getStringExtra("file_shortvideo_md5");
      bool = ((Intent)localObject).getBooleanExtra("mediacodec_encode_enable", false);
      j = ((Intent)localObject).getIntExtra("thumbfile_send_width", 0);
      i = ((Intent)localObject).getIntExtra("thumbfile_send_height", 0);
      str2 = ((Intent)localObject).getStringExtra("thumbfile_md5");
      str1 = ((Intent)localObject).getStringExtra("file_source");
      localObject = ((Intent)localObject).getStringExtra("file_video_source_dir");
    }
    for (;;)
    {
      bbrp localbbrp = new bbrp();
      localbbrp.jdField_c_of_type_JavaLangString = str7;
      localbbrp.h = str5;
      localbbrp.j = str4;
      localbbrp.b = m;
      localbbrp.jdField_d_of_type_JavaLangString = str6;
      localbbrp.jdField_e_of_type_Int = ((int)l);
      localbbrp.f = k;
      localbbrp.jdField_e_of_type_JavaLangString = str3;
      localbbrp.jdField_c_of_type_Boolean = bool;
      localbbrp.jdField_c_of_type_Int = j;
      localbbrp.jdField_d_of_type_Int = i;
      localbbrp.jdField_g_of_type_Int = parambbqx.a;
      localbbrp.jdField_a_of_type_JavaLangObject = paramObject;
      localbbrp.jdField_g_of_type_JavaLangString = str2;
      localbbrp.l = str1;
      localbbrp.k = ((String)localObject);
      ayde.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "");
      return localbbrp;
      if ((paramObject instanceof MessageForDevLittleVideo))
      {
        localObject = (MessageForShortVideo)paramObject;
        str7 = ((MessageForShortVideo)localObject).frienduin;
        str6 = ((MessageForShortVideo)localObject).frienduin;
        m = ((MessageForShortVideo)localObject).istroop;
        l = ((MessageForShortVideo)localObject).videoFileSize;
        k = ((MessageForShortVideo)localObject).videoFileTime;
        str5 = ((MessageForShortVideo)localObject).videoFileName;
        str4 = ShortVideoUtils.getShortVideoThumbPicPath(((MessageForShortVideo)localObject).thumbMD5, "jpg");
        str3 = ((MessageForShortVideo)localObject).md5;
        bool = ((MessageForShortVideo)localObject).mediacodecEncode;
        j = ((MessageForShortVideo)localObject).thumbWidth;
        i = ((MessageForShortVideo)localObject).thumbHeight;
        str2 = ((MessageForShortVideo)localObject).thumbMD5;
        str1 = ((MessageForShortVideo)localObject).fileSource;
        localObject = ((MessageForShortVideo)localObject).mVideoFileSourceDir;
      }
    }
  }
  
  public MessageRecord a(bbqj parambbqj)
  {
    return null;
  }
  
  public MessageRecord a(bbrp parambbrp)
  {
    long l = System.currentTimeMillis();
    MessageForDevLittleVideo localMessageForDevLittleVideo = bbli.a(this.a, parambbrp.jdField_c_of_type_JavaLangString, parambbrp.jdField_d_of_type_JavaLangString, parambbrp.b);
    localMessageForDevLittleVideo.videoFileName = parambbrp.h;
    if (parambbrp.jdField_a_of_type_JavaLangString == null) {
      parambbrp.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.uuid = parambbrp.jdField_a_of_type_JavaLangString;
    if (parambbrp.jdField_e_of_type_JavaLangString == null) {
      parambbrp.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.mediacodecEncode = parambbrp.jdField_c_of_type_Boolean;
    localMessageForDevLittleVideo.md5 = parambbrp.jdField_e_of_type_JavaLangString;
    localMessageForDevLittleVideo.videoFileFormat = 2;
    localMessageForDevLittleVideo.videoFileSize = parambbrp.jdField_e_of_type_Int;
    localMessageForDevLittleVideo.videoFileTime = parambbrp.f;
    localMessageForDevLittleVideo.thumbWidth = parambbrp.jdField_c_of_type_Int;
    localMessageForDevLittleVideo.thumbHeight = parambbrp.jdField_d_of_type_Int;
    localMessageForDevLittleVideo.mThumbFilePath = parambbrp.j;
    localMessageForDevLittleVideo.mVideoFileSourceDir = parambbrp.k;
    localMessageForDevLittleVideo.videoFileStatus = 1001;
    localMessageForDevLittleVideo.videoFileProgress = 0;
    localMessageForDevLittleVideo.extraflag = 32772;
    localMessageForDevLittleVideo.thumbMD5 = parambbrp.jdField_g_of_type_JavaLangString;
    if (parambbrp.l == null) {
      parambbrp.l = "";
    }
    localMessageForDevLittleVideo.fileSource = parambbrp.l;
    localMessageForDevLittleVideo.lastModified = 0L;
    localMessageForDevLittleVideo.issend = 1;
    localMessageForDevLittleVideo.uiOperatorFlag = 1;
    localMessageForDevLittleVideo.msg = amtj.a(2131702373);
    localMessageForDevLittleVideo.serial();
    parambbrp.jdField_a_of_type_Long = localMessageForDevLittleVideo.uniseq;
    ayde.a(this.jdField_g_of_type_JavaLangString, this.f, "packmsg", "cost:" + (System.currentTimeMillis() - l));
    ayde.a(this.jdField_g_of_type_JavaLangString, this.f, "packMsg", "mr: " + localMessageForDevLittleVideo.toLogString() + "-" + localMessageForDevLittleVideo.toString());
    return localMessageForDevLittleVideo;
  }
  
  public void a(bbrp parambbrp)
  {
    ayde.a(this.jdField_g_of_type_JavaLangString, this.f, "sendPic.start", "");
    ThreadManager.getSubThreadHandler().post(new DevLittleVideoOperator.1(this, parambbrp));
  }
  
  public boolean a(String paramString)
  {
    aara localaara = (aara)this.a.getBusinessHandler(51);
    DeviceInfo localDeviceInfo = localaara.a(Long.parseLong(paramString));
    if (localDeviceInfo == null) {
      return false;
    }
    if (localaara.a(Long.parseLong(paramString)).booleanValue()) {
      return true;
    }
    if (localDeviceInfo.SSOBid_Platform == 1027) {
      return true;
    }
    if ((localDeviceInfo.SSOBid_Platform == 0) && (localDeviceInfo.SSOBid_Version.equals(""))) {
      return true;
    }
    paramString = localDeviceInfo.SSOBid_Version;
    return (!StringUtil.isEmpty(paramString)) && (Double.valueOf(paramString).doubleValue() >= 1.3D);
  }
  
  public void updateMsg(ayep paramayep) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aasf
 * JD-Core Version:    0.7.0.1
 */