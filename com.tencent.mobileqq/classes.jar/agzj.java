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

public class agzj
  implements Runnable
{
  public agzj(DCShortVideo paramDCShortVideo, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString2, long paramLong, String paramString3, boolean paramBoolean1, int paramInt3, String paramString4, boolean paramBoolean2) {}
  
  public void run()
  {
    agzt localagzt = new agzt();
    Object localObject3 = new File(this.jdField_a_of_type_JavaLangString);
    if (!((File)localObject3).exists()) {}
    for (;;)
    {
      return;
      localagzt.jdField_a_of_type_Long = ((File)localObject3).length();
      if (localagzt.jdField_a_of_type_Long <= 0L) {
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCShortVideo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_JavaLangString, localagzt);
      localagzt.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      localagzt.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
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
        localagzt.jdField_a_of_type_JavaLangString = ((String)localObject2).replace("/", "//");
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
            localagzt.j = 1002;
            localagzt.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
            if (this.jdField_a_of_type_Boolean)
            {
              if (this.jdField_c_of_type_Int != 0) {
                break label918;
              }
              localagzt.jdField_a_of_type_Int = 0;
            }
          }
        }
        for (;;)
        {
          localagzt.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
          localagzt.k = ((int)((System.currentTimeMillis() - new File(this.jdField_a_of_type_JavaLangString).lastModified()) / 60000L));
          if (localagzt.k == 0) {
            localagzt.k = 1;
          }
          localagzt.m = VideoEnvironment.jdField_a_of_type_Int;
          localagzt.l = (VideoEnvironment.jdField_a_of_type_ComTencentMobileqqShortvideoVideoEnvironment$ShortVideoConfig.jdField_a_of_type_Int + 2000);
          if (QLog.isDevelopLevel()) {
            QLog.d("DCShortVideo", 4, "[reportSend]url=" + localagzt.jdField_a_of_type_JavaLangString + ",shortVideoType=" + localagzt.f + ",shortVideoSourceType = " + localagzt.j + ",uinType = " + localagzt.jdField_b_of_type_Int + ",groupMemCount = " + localagzt.jdField_c_of_type_Int + ",isForward = " + localagzt.jdField_a_of_type_Boolean + ",isExsit = " + localagzt.jdField_b_of_type_Boolean + ",age = " + localagzt.d + ",gender = " + localagzt.e + ",userType = " + localagzt.l + ",reprotHour = " + localagzt.g + ",fileInterval = " + localagzt.k + ",netType = " + localagzt.h + ",forwardSourceGroupMemCount = " + localagzt.i + ",forwardSourceUinType = " + localagzt.jdField_a_of_type_Int + ",duration = " + localagzt.jdField_b_of_type_Long + ",fileSize = " + localagzt.jdField_a_of_type_Long + ",md5 = " + localagzt.jdField_b_of_type_JavaLangString + ", status=" + localagzt.m);
          }
          localObject1 = new agzx("ShortVideo.Send", localagzt.a("ShortVideo.Send"));
          DataReport.a().a((agzx)localObject1);
          return;
          if (((String)localObject1).contains("/qq_collection/"))
          {
            localagzt.j = 1001;
            break;
          }
          if (((String)localObject1).contains("/qqfile_recv/"))
          {
            localagzt.j = 1003;
            break;
          }
          if ((((String)localObject1).contains("/weixin/")) || (((String)localObject1).contains("/wechat/")) || (((String)localObject1).contains("/micromsg/")))
          {
            localagzt.j = 1004;
            break;
          }
          if (StatisticConstants.a((String)localObject1))
          {
            localagzt.j = 1005;
            break;
          }
          localagzt.j = 1006;
          break;
          if (((String)localObject1).equalsIgnoreCase(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath() + File.separator))
          {
            localagzt.j = 1002;
            break;
          }
          if ((((String)localObject2).contains("camera")) || (((String)localObject2).equals("dcim")) || (((String)localObject2).equals("100MEDIA")) || (((String)localObject2).equals("100ANDRO")) || (((String)localObject2).contains("相机")) || (((String)localObject2).contains("照片")) || (((String)localObject2).contains("相片")))
          {
            localagzt.j = 1007;
            break;
          }
          if (StatisticConstants.a((String)localObject1))
          {
            localagzt.j = 1005;
            break;
          }
          localagzt.j = 1006;
          break;
          if (this.jdField_c_of_type_Int == 3000)
          {
            localagzt.jdField_a_of_type_Int = 3000;
          }
          else
          {
            if (this.jdField_c_of_type_Int == 1)
            {
              switch (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.d))
              {
              default: 
                localagzt.jdField_a_of_type_Int = 1;
              }
              for (;;)
              {
                localagzt.i = 0;
                localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                if (localObject1 == null) {
                  break;
                }
                localObject1 = ((TroopManager)localObject1).b(this.d);
                if (localObject1 == null) {
                  break;
                }
                localagzt.i = ((TroopInfo)localObject1).wMemberNum;
                break;
                localagzt.jdField_a_of_type_Int = 1;
                continue;
                localagzt.jdField_a_of_type_Int = 3;
                continue;
                localagzt.jdField_a_of_type_Int = 4;
                continue;
                localagzt.jdField_a_of_type_Int = 2;
              }
            }
            localagzt.jdField_a_of_type_Int = 9999;
          }
        }
        return;
      }
      catch (Exception localException1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agzj
 * JD-Core Version:    0.7.0.1
 */