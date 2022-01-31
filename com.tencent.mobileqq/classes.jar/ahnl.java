import android.os.Environment;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.ShortVideoConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Locale;

public class ahnl
  implements Runnable
{
  public ahnl(DCShortVideo paramDCShortVideo, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2, long paramLong, String paramString3, boolean paramBoolean1, int paramInt3, String paramString4, boolean paramBoolean2) {}
  
  public void run()
  {
    ahnv localahnv = new ahnv();
    Object localObject3 = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject3).exists()) {}
    for (;;)
    {
      return;
      localahnv.jdField_a_of_type_Long = ((File)localObject3).length();
      if (localahnv.jdField_a_of_type_Long <= 0L) {
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCShortVideo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString, localahnv);
      localahnv.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      localahnv.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      try
      {
        Object localObject2 = this.jdField_a_of_type_JavaLangString;
        String str = Environment.getExternalStorageDirectory().toString();
        Object localObject1 = localObject2;
        if (str != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_JavaLangString.contains(str)) {
            localObject1 = this.jdField_a_of_type_JavaLangString.replace(str, "");
          }
        }
        int i = ((String)localObject1).lastIndexOf("/");
        localObject2 = localObject1;
        if (i != -1) {
          localObject2 = ((String)localObject1).substring(0, i);
        }
        localahnv.jdField_a_of_type_JavaLangString = ((String)localObject2).replace("/", "//");
        localObject2 = FileUtil.b(this.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localObject2 != null) {
          localObject1 = ((String)localObject2).toLowerCase(Locale.US);
        }
        localObject2 = null;
        label918:
        try
        {
          localObject3 = ((File)localObject3).getParentFile().getName().toLowerCase(Locale.US);
          localObject2 = localObject3;
        }
        catch (Exception localException2)
        {
          label217:
          break label217;
        }
        if ((localObject1 == null) || (localObject2 == null)) {
          continue;
        }
        if (((String)localObject1).contains("/tencent/")) {
          if (((String)localObject1).contains("/mobileqq/shortvideo/"))
          {
            localahnv.j = 1002;
            localahnv.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
            if (this.jdField_a_of_type_Boolean)
            {
              if (this.jdField_c_of_type_Int != 0) {
                break label918;
              }
              localahnv.jdField_a_of_type_Int = 0;
            }
          }
        }
        for (;;)
        {
          localahnv.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
          localahnv.k = ((int)((System.currentTimeMillis() - new File(this.jdField_a_of_type_JavaLangString).lastModified()) / 60000L));
          if (localahnv.k == 0) {
            localahnv.k = 1;
          }
          localahnv.m = VideoEnvironment.jdField_a_of_type_Int;
          localahnv.l = (VideoEnvironment.jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_Int + 2000);
          if (QLog.isDevelopLevel()) {
            QLog.d("DCShortVideo", 4, "[reportSend]url=" + localahnv.jdField_a_of_type_JavaLangString + ",shortVideoType=" + localahnv.f + ",shortVideoSourceType = " + localahnv.j + ",uinType = " + localahnv.jdField_b_of_type_Int + ",groupMemCount = " + localahnv.jdField_c_of_type_Int + ",isForward = " + localahnv.jdField_a_of_type_Boolean + ",isExsit = " + localahnv.jdField_b_of_type_Boolean + ",age = " + localahnv.d + ",gender = " + localahnv.e + ",userType = " + localahnv.l + ",reprotHour = " + localahnv.g + ",fileInterval = " + localahnv.k + ",netType = " + localahnv.h + ",forwardSourceGroupMemCount = " + localahnv.i + ",forwardSourceUinType = " + localahnv.jdField_a_of_type_Int + ",duration = " + localahnv.jdField_b_of_type_Long + ",fileSize = " + localahnv.jdField_a_of_type_Long + ",md5 = " + localahnv.jdField_b_of_type_JavaLangString + ", status=" + localahnv.m);
          }
          localObject1 = new ahnz("ShortVideo.Send", localahnv.a("ShortVideo.Send"));
          DataReport.a().a((ahnz)localObject1);
          return;
          if (((String)localObject1).contains("/qq_collection/"))
          {
            localahnv.j = 1001;
            break;
          }
          if (((String)localObject1).contains("/qqfile_recv/"))
          {
            localahnv.j = 1003;
            break;
          }
          if ((((String)localObject1).contains("/weixin/")) || (((String)localObject1).contains("/wechat/")) || (((String)localObject1).contains("/micromsg/")))
          {
            localahnv.j = 1004;
            break;
          }
          if (StatisticConstants.a((String)localObject1))
          {
            localahnv.j = 1005;
            break;
          }
          localahnv.j = 1006;
          break;
          if (((String)localObject1).equalsIgnoreCase(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath() + File.separator))
          {
            localahnv.j = 1002;
            break;
          }
          if ((((String)localObject2).contains("camera")) || (((String)localObject2).equals("dcim")) || (((String)localObject2).equals("100MEDIA")) || (((String)localObject2).equals("100ANDRO")) || (((String)localObject2).contains("相机")) || (((String)localObject2).contains("照片")) || (((String)localObject2).contains("相片")))
          {
            localahnv.j = 1007;
            break;
          }
          if (StatisticConstants.a((String)localObject1))
          {
            localahnv.j = 1005;
            break;
          }
          localahnv.j = 1006;
          break;
          if (this.jdField_c_of_type_Int == 3000)
          {
            localahnv.jdField_a_of_type_Int = 3000;
          }
          else
          {
            if (this.jdField_c_of_type_Int == 1)
            {
              switch (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.d))
              {
              default: 
                localahnv.jdField_a_of_type_Int = 1;
              }
              for (;;)
              {
                localahnv.i = 0;
                localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                if (localObject1 == null) {
                  break;
                }
                localObject1 = ((TroopManager)localObject1).b(this.d);
                if (localObject1 == null) {
                  break;
                }
                localahnv.i = ((TroopInfo)localObject1).wMemberNum;
                break;
                localahnv.jdField_a_of_type_Int = 1;
                continue;
                localahnv.jdField_a_of_type_Int = 3;
                continue;
                localahnv.jdField_a_of_type_Int = 4;
                continue;
                localahnv.jdField_a_of_type_Int = 2;
              }
            }
            localahnv.jdField_a_of_type_Int = 9999;
          }
        }
        return;
      }
      catch (Exception localException1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahnl
 * JD-Core Version:    0.7.0.1
 */