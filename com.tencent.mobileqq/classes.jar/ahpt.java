import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr.DItemInfo;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class ahpt
  implements INetEngine.INetEngineListener
{
  public ahpt(RecentDanceConfigMgr.DItemInfo paramDItemInfo, String paramString) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentDanceConfigMgr", 2, "processNetWork onUpdateProgeress: totalLen=" + paramLong2 + " curOffset=" + paramLong1);
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.jdField_a_of_type_Int == 0)
    {
      paramNetResp = paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
      if (new File(paramNetResp.c).exists())
      {
        str = RecentDanceConfigMgr.a(paramNetResp.c);
        if ((str == null) || ("".equals(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilRecentDanceConfigMgr$DItemInfo.icon_md5)))
        {
          FileUtils.d(paramNetResp.c);
          FileUtils.d(this.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp: item.icon_md5" + this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilRecentDanceConfigMgr$DItemInfo.icon_md5 + " md5=" + str);
          }
        }
      }
      while (!QLog.isColorLevel())
      {
        String str;
        return;
        if (QLog.isColorLevel()) {
          QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp: check success");
        }
        FileUtils.c(paramNetResp.c, this.jdField_a_of_type_JavaLangString);
        RecentDanceConfigMgr.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilRecentDanceConfigMgr$DItemInfo, this.jdField_a_of_type_JavaLangString);
        return;
      }
      QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp[not exists]: mOutPath" + paramNetResp.c);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp: resp.mResult=" + paramNetResp.jdField_a_of_type_Int);
    }
    FileUtils.d(paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahpt
 * JD-Core Version:    0.7.0.1
 */