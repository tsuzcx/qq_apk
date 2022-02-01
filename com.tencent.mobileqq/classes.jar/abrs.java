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

public class abrs
  extends BaseShortVideoOprerator
{
  public abrs() {}
  
  public abrs(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public bceh a(Object paramObject, bcev parambcev)
  {
    return null;
  }
  
  public bcfn a(Object paramObject, bcev parambcev)
  {
    if (paramObject == null)
    {
      ayxi.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "unknow obj");
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
      bcfn localbcfn = new bcfn();
      localbcfn.jdField_c_of_type_JavaLangString = str7;
      localbcfn.h = str5;
      localbcfn.j = str4;
      localbcfn.b = m;
      localbcfn.jdField_d_of_type_JavaLangString = str6;
      localbcfn.jdField_e_of_type_Int = ((int)l);
      localbcfn.f = k;
      localbcfn.jdField_e_of_type_JavaLangString = str3;
      localbcfn.jdField_c_of_type_Boolean = bool;
      localbcfn.jdField_c_of_type_Int = j;
      localbcfn.jdField_d_of_type_Int = i;
      localbcfn.jdField_g_of_type_Int = parambcev.a;
      localbcfn.jdField_a_of_type_JavaLangObject = paramObject;
      localbcfn.jdField_g_of_type_JavaLangString = str2;
      localbcfn.l = str1;
      localbcfn.k = ((String)localObject);
      ayxi.a(this.jdField_g_of_type_JavaLangString, this.f, "createShortVideoUploadInfo", "");
      return localbcfn;
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
  
  public MessageRecord a(bceh parambceh)
  {
    return null;
  }
  
  public MessageRecord a(bcfn parambcfn)
  {
    long l = System.currentTimeMillis();
    MessageForDevLittleVideo localMessageForDevLittleVideo = bbzh.a(this.a, parambcfn.jdField_c_of_type_JavaLangString, parambcfn.jdField_d_of_type_JavaLangString, parambcfn.b);
    localMessageForDevLittleVideo.videoFileName = parambcfn.h;
    if (parambcfn.jdField_a_of_type_JavaLangString == null) {
      parambcfn.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.uuid = parambcfn.jdField_a_of_type_JavaLangString;
    if (parambcfn.jdField_e_of_type_JavaLangString == null) {
      parambcfn.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForDevLittleVideo.mediacodecEncode = parambcfn.jdField_c_of_type_Boolean;
    localMessageForDevLittleVideo.md5 = parambcfn.jdField_e_of_type_JavaLangString;
    localMessageForDevLittleVideo.videoFileFormat = 2;
    localMessageForDevLittleVideo.videoFileSize = parambcfn.jdField_e_of_type_Int;
    localMessageForDevLittleVideo.videoFileTime = parambcfn.f;
    localMessageForDevLittleVideo.thumbWidth = parambcfn.jdField_c_of_type_Int;
    localMessageForDevLittleVideo.thumbHeight = parambcfn.jdField_d_of_type_Int;
    localMessageForDevLittleVideo.mThumbFilePath = parambcfn.j;
    localMessageForDevLittleVideo.mVideoFileSourceDir = parambcfn.k;
    localMessageForDevLittleVideo.videoFileStatus = 1001;
    localMessageForDevLittleVideo.videoFileProgress = 0;
    localMessageForDevLittleVideo.extraflag = 32772;
    localMessageForDevLittleVideo.thumbMD5 = parambcfn.jdField_g_of_type_JavaLangString;
    if (parambcfn.l == null) {
      parambcfn.l = "";
    }
    localMessageForDevLittleVideo.fileSource = parambcfn.l;
    localMessageForDevLittleVideo.lastModified = 0L;
    localMessageForDevLittleVideo.issend = 1;
    localMessageForDevLittleVideo.uiOperatorFlag = 1;
    localMessageForDevLittleVideo.msg = anni.a(2131702031);
    localMessageForDevLittleVideo.serial();
    parambcfn.jdField_a_of_type_Long = localMessageForDevLittleVideo.uniseq;
    ayxi.a(this.jdField_g_of_type_JavaLangString, this.f, "packmsg", "cost:" + (System.currentTimeMillis() - l));
    ayxi.a(this.jdField_g_of_type_JavaLangString, this.f, "packMsg", "mr: " + localMessageForDevLittleVideo.toLogString() + "-" + localMessageForDevLittleVideo.toString());
    return localMessageForDevLittleVideo;
  }
  
  public void a(ayyu paramayyu) {}
  
  public void a(bcfn parambcfn)
  {
    ayxi.a(this.jdField_g_of_type_JavaLangString, this.f, "sendPic.start", "");
    ThreadManager.getSubThreadHandler().post(new DevLittleVideoOperator.1(this, parambcfn));
  }
  
  public boolean a(String paramString)
  {
    abqn localabqn = (abqn)this.a.a(51);
    DeviceInfo localDeviceInfo = localabqn.a(Long.parseLong(paramString));
    if (localDeviceInfo == null) {
      return false;
    }
    if (localabqn.a(Long.parseLong(paramString)).booleanValue()) {
      return true;
    }
    if (localDeviceInfo.SSOBid_Platform == 1027) {
      return true;
    }
    if ((localDeviceInfo.SSOBid_Platform == 0) && (localDeviceInfo.SSOBid_Version.equals(""))) {
      return true;
    }
    paramString = localDeviceInfo.SSOBid_Version;
    return (!bgsp.a(paramString)) && (Double.valueOf(paramString).doubleValue() >= 1.3D);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abrs
 * JD-Core Version:    0.7.0.1
 */