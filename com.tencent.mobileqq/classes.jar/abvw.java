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
import mqq.os.MqqHandler;

public class abvw
  extends BaseShortVideoOprerator
{
  public abvw() {}
  
  public abvw(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public bcwz a(Object paramObject, bcxn parambcxn)
  {
    return null;
  }
  
  public bcyf a(Object paramObject, bcxn parambcxn)
  {
    if (paramObject == null)
    {
      azpw.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "unknow obj");
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
      bcyf localbcyf = new bcyf();
      localbcyf.jdField_c_of_type_JavaLangString = str7;
      localbcyf.h = str5;
      localbcyf.j = str4;
      localbcyf.b = m;
      localbcyf.jdField_d_of_type_JavaLangString = str6;
      localbcyf.jdField_e_of_type_Int = ((int)l);
      localbcyf.f = k;
      localbcyf.jdField_e_of_type_JavaLangString = str3;
      localbcyf.jdField_c_of_type_Boolean = bool;
      localbcyf.jdField_c_of_type_Int = j;
      localbcyf.jdField_d_of_type_Int = i;
      localbcyf.jdField_g_of_type_Int = parambcxn.a;
      localbcyf.jdField_a_of_type_JavaLangObject = paramObject;
      localbcyf.jdField_g_of_type_JavaLangString = str2;
      localbcyf.l = str1;
      localbcyf.k = ((String)localObject);
      azpw.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "");
      return localbcyf;
      if ((paramObject instanceof MessageForDevLittleVideo))
      {
        localObject = (MessageForShortVideo)paramObject;
        str7 = ((MessageForShortVideo)localObject).frienduin;
        str6 = ((MessageForShortVideo)localObject).frienduin;
        m = ((MessageForShortVideo)localObject).istroop;
        l = ((MessageForShortVideo)localObject).videoFileSize;
        k = ((MessageForShortVideo)localObject).videoFileTime;
        str5 = ((MessageForShortVideo)localObject).videoFileName;
        str4 = ShortVideoUtils.a(((MessageForShortVideo)localObject).thumbMD5, "jpg");
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
  
  public MessageRecord a(bcwz parambcwz)
  {
    return null;
  }
  
  public MessageRecord a(bcyf parambcyf)
  {
    long l = System.currentTimeMillis();
    MessageForDevLittleVideo localMessageForDevLittleVideo = bcry.a(this.a, parambcyf.jdField_c_of_type_JavaLangString, parambcyf.jdField_d_of_type_JavaLangString, parambcyf.b);
    localMessageForDevLittleVideo.videoFileName = parambcyf.h;
    if (parambcyf.jdField_a_of_type_JavaLangString == null) {
      parambcyf.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.uuid = parambcyf.jdField_a_of_type_JavaLangString;
    if (parambcyf.jdField_e_of_type_JavaLangString == null) {
      parambcyf.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.mediacodecEncode = parambcyf.jdField_c_of_type_Boolean;
    localMessageForDevLittleVideo.md5 = parambcyf.jdField_e_of_type_JavaLangString;
    localMessageForDevLittleVideo.videoFileFormat = 2;
    localMessageForDevLittleVideo.videoFileSize = parambcyf.jdField_e_of_type_Int;
    localMessageForDevLittleVideo.videoFileTime = parambcyf.f;
    localMessageForDevLittleVideo.thumbWidth = parambcyf.jdField_c_of_type_Int;
    localMessageForDevLittleVideo.thumbHeight = parambcyf.jdField_d_of_type_Int;
    localMessageForDevLittleVideo.mThumbFilePath = parambcyf.j;
    localMessageForDevLittleVideo.mVideoFileSourceDir = parambcyf.k;
    localMessageForDevLittleVideo.videoFileStatus = 1001;
    localMessageForDevLittleVideo.videoFileProgress = 0;
    localMessageForDevLittleVideo.extraflag = 32772;
    localMessageForDevLittleVideo.thumbMD5 = parambcyf.jdField_g_of_type_JavaLangString;
    if (parambcyf.l == null) {
      parambcyf.l = "";
    }
    localMessageForDevLittleVideo.fileSource = parambcyf.l;
    localMessageForDevLittleVideo.lastModified = 0L;
    localMessageForDevLittleVideo.issend = 1;
    localMessageForDevLittleVideo.uiOperatorFlag = 1;
    localMessageForDevLittleVideo.msg = anzj.a(2131702138);
    localMessageForDevLittleVideo.serial();
    parambcyf.jdField_a_of_type_Long = localMessageForDevLittleVideo.uniseq;
    azpw.a(this.jdField_g_of_type_JavaLangString, this.f, "packmsg", "cost:" + (System.currentTimeMillis() - l));
    azpw.a(this.jdField_g_of_type_JavaLangString, this.f, "packMsg", "mr: " + localMessageForDevLittleVideo.toLogString() + "-" + localMessageForDevLittleVideo.toString());
    return localMessageForDevLittleVideo;
  }
  
  public void a(azrh paramazrh) {}
  
  public void a(bcyf parambcyf)
  {
    azpw.a(this.jdField_g_of_type_JavaLangString, this.f, "sendPic.start", "");
    ThreadManager.getSubThreadHandler().post(new DevLittleVideoOperator.1(this, parambcyf));
  }
  
  public boolean a(String paramString)
  {
    abur localabur = (abur)this.a.a(51);
    DeviceInfo localDeviceInfo = localabur.a(Long.parseLong(paramString));
    if (localDeviceInfo == null) {
      return false;
    }
    if (localabur.a(Long.parseLong(paramString)).booleanValue()) {
      return true;
    }
    if (localDeviceInfo.SSOBid_Platform == 1027) {
      return true;
    }
    if ((localDeviceInfo.SSOBid_Platform == 0) && (localDeviceInfo.SSOBid_Version.equals(""))) {
      return true;
    }
    paramString = localDeviceInfo.SSOBid_Version;
    return (!bhsr.a(paramString)) && (Double.valueOf(paramString).doubleValue() >= 1.3D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abvw
 * JD-Core Version:    0.7.0.1
 */