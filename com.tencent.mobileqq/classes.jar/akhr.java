import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.DecorateInfo;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.RedPacketTemplateInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.Map;

public class akhr
  extends VasQuickUpdateManager.CallBacker
{
  public akhr(IndividualRedPacketResDownloader paramIndividualRedPacketResDownloader) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((16L != paramLong) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    label94:
    boolean bool;
    label118:
    int i;
    if ((QLog.isColorLevel()) || (paramInt1 != 0))
    {
      localObject1 = new StringBuilder().append("callBacker, from:").append(paramString3).append(",httpCode=").append(paramInt2).append(",errorCode:").append(paramInt1).append(", scid:").append(paramString1).append(", cfgScid:").append(paramString2);
      if (paramInt1 != 0)
      {
        paramVasQuickUpdateManager = ", Error ";
        QLog.d("IndividualRedPacketResDownloader", 2, paramVasQuickUpdateManager);
      }
    }
    else
    {
      if (paramInt1 != 0) {
        break label339;
      }
      bool = true;
      if (!bool) {
        break label345;
      }
      i = 2;
    }
    label339:
    label345:
    label351:
    do
    {
      for (;;)
      {
        try
        {
          if (!"iRedPacket_v3.json".equals(paramString1)) {
            break label351;
          }
          this.a.a(true, false);
          if (QLog.isColorLevel()) {
            QLog.d("IndividualRedPacketResDownloader", 2, "callBacker, from:" + paramString3 + ",httpCode=" + paramInt2 + ",errorCode:" + paramInt1 + ", scid:" + paramString1 + ", cfgScid:" + paramString2 + ", downloadOK=" + bool);
          }
          if ((TextUtils.isEmpty(paramString3)) || (!paramString3.startsWith("silent_download.redbag"))) {
            break;
          }
          this.a.a();
          return;
        }
        catch (Exception paramVasQuickUpdateManager)
        {
          QLog.d("IndividualRedPacketResDownloader", 2, "callBacker, from:" + paramString3 + ",httpCode=" + paramInt2 + ",errorCode:" + paramInt1 + ", scid:" + paramString1 + ", cfgScid:" + paramString2 + ", e=" + paramVasQuickUpdateManager.getMessage());
          return;
        }
        paramVasQuickUpdateManager = ", ok ";
        break label94;
        bool = false;
        break label118;
        i = -1;
        continue;
        if ("iRedPacket_v3.char300.json".equals(paramString1))
        {
          if (bool)
          {
            paramVasQuickUpdateManager = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata/vas/redpacket/" + "iRedPacket_v3.char300.json";
            paramVasQuickUpdateManager = VasQuickUpdateManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 16L, "iRedPacket_v3.char300.json", paramVasQuickUpdateManager, false, this.a.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
            this.a.a(true, false, paramString1, paramVasQuickUpdateManager);
          }
          localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          ??? = IndividualRedPacketManager.c;
          if (!bool) {
            break label1071;
          }
          paramVasQuickUpdateManager = "1";
          ReportController.b((QQAppInterface)localObject1, "CliOper", "", "", "0X800612D", "0X800612D", 0, 0, (String)???, paramVasQuickUpdateManager, "1", "");
        }
        else if ("iRedPacket_v3.font.zip".equals(paramString1))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo.e = i;
          if (bool)
          {
            paramVasQuickUpdateManager = new File(IndividualRedPacketManager.a(null, null, 21, 0, 0));
            this.a.a(true, false, paramString1, paramVasQuickUpdateManager);
          }
          localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          ??? = IndividualRedPacketManager.c;
          if (!bool) {
            break label1079;
          }
          paramVasQuickUpdateManager = "1";
          ReportController.b((QQAppInterface)localObject1, "CliOper", "", "", "0X800612C", "0X800612C", 0, 0, (String)???, paramVasQuickUpdateManager, "1", "");
        }
        else
        {
          if (!"iRedPacket_v3.specialChar.zip".equals(paramString1)) {
            break label658;
          }
          this.a.b.e = i;
          if (bool)
          {
            paramVasQuickUpdateManager = new File(IndividualRedPacketManager.a(null, null, 25, 0, 0));
            this.a.a(true, false, paramString1, paramVasQuickUpdateManager);
          }
        }
      }
    } while (!paramString1.startsWith("luckyMoney.item."));
    label464:
    Object localObject1 = IndividualRedPacketManager.a(paramString1);
    label571:
    if (bool)
    {
      paramVasQuickUpdateManager = this.a.a((String)localObject1);
      if ((paramVasQuickUpdateManager != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager != null))
      {
        ??? = IndividualRedPacketManager.a((String)localObject1, null, paramVasQuickUpdateManager.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.f, paramVasQuickUpdateManager.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.d, 0);
        ??? = (String)??? + "_dir2";
        VasQuickUpdateEngine.safeDeleteFile(new File((String)???));
        if (QLog.isColorLevel()) {
          QLog.d("IndividualRedPacketResDownloader", 2, "callBacker delete animateDir: " + (String)???);
        }
      }
    }
    for (;;)
    {
      label658:
      synchronized (this.a.c)
      {
        if (!this.a.c.containsKey(localObject1)) {
          break label1009;
        }
        localObject3 = (List)this.a.c.get(localObject1);
        i = 0;
        if (i < ((List)localObject3).size())
        {
          String str = (String)((List)localObject3).get(i);
          if (TextUtils.isEmpty(str)) {
            break label1087;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(str, paramVasQuickUpdateManager.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.f);
          this.a.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(str + "_tp", paramVasQuickUpdateManager.b.f);
          this.a.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(str + "_send", paramVasQuickUpdateManager.c.f);
        }
      }
      this.a.c.remove(paramVasQuickUpdateManager.jdField_a_of_type_JavaLangString);
      label1009:
      ??? = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Object localObject3 = IndividualRedPacketManager.c;
      if (bool) {}
      for (paramVasQuickUpdateManager = "1";; paramVasQuickUpdateManager = "0")
      {
        ReportController.b((QQAppInterface)???, "CliOper", "", "", "0X800612E", "0X800612E", 0, 0, (String)localObject3, paramVasQuickUpdateManager, "1", (String)localObject1);
        break;
      }
      label1071:
      paramVasQuickUpdateManager = "0";
      break label464;
      label1079:
      paramVasQuickUpdateManager = "0";
      break label571;
      label1087:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhr
 * JD-Core Version:    0.7.0.1
 */