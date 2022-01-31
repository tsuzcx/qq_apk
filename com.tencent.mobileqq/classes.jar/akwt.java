import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class akwt
  extends QidianBusinessObserver
{
  public akwt(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  protected void a(boolean paramBoolean, HashMap paramHashMap)
  {
    super.a(paramBoolean, paramHashMap);
    this.a.a();
    if ((paramBoolean) && (paramHashMap != null))
    {
      j = 0;
      i = j;
      if (paramHashMap.containsKey("external"))
      {
        i = j;
        if (paramHashMap.get("external") != null)
        {
          localQidianExternalInfo = (QidianExternalInfo)paramHashMap.get("external");
          if (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a.equals(localQidianExternalInfo.uin)) {
            if (QLog.isColorLevel()) {
              QLog.d("QidianProfileCardActivity", 2, "onGetQidianMasterInfo not current uin");
            }
          }
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        QidianExternalInfo localQidianExternalInfo;
        return;
        int i = j;
        if (!localQidianExternalInfo.equals(this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo))
        {
          this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = localQidianExternalInfo;
          i = 1;
        }
        int j = i;
        if (paramHashMap.containsKey("ConfigGroupInfo"))
        {
          j = i;
          if (paramHashMap.get("ConfigGroupInfo") != null)
          {
            paramHashMap = (QidianProfileUiInfo)paramHashMap.get("ConfigGroupInfo");
            j = i;
            if (!paramHashMap.equals(QidianProfileCardActivity.a(this.a)))
            {
              QidianProfileCardActivity.a(this.a, paramHashMap);
              j = 1;
            }
          }
        }
        if (j != 0)
        {
          this.a.c(6);
          this.a.b();
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QidianProfileCardActivity", 2, "onGetQidianMasterInfo not change");
      return;
    }
    QLog.d("QidianProfileCardActivity", 2, "onGetQidianMasterInfo fail");
  }
  
  protected void d(boolean paramBoolean, HashMap paramHashMap)
  {
    super.d(paramBoolean, paramHashMap);
    this.a.a();
    if ((paramBoolean) && (paramHashMap != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null) && (paramHashMap.containsKey("corp")) && (paramHashMap.get("corp") != null) && (paramHashMap.containsKey("ConfigGroupInfo")) && (paramHashMap.get("ConfigGroupInfo") != null))
    {
      localQidianExternalInfo = (QidianExternalInfo)paramHashMap.get("external");
      localQidianCorpInfo = (QidianCorpInfo)paramHashMap.get("corp");
      paramHashMap = (QidianProfileUiInfo)paramHashMap.get("ConfigGroupInfo");
      if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a.equals(localQidianExternalInfo.uin)) {
        if ((!localQidianExternalInfo.equals(this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo)) || (!localQidianCorpInfo.equals(QidianProfileCardActivity.a(this.a))) || (!paramHashMap.equals(QidianProfileCardActivity.a(this.a))))
        {
          i = 1;
          if (i == 0) {
            break label230;
          }
          this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = localQidianExternalInfo;
          QidianProfileCardActivity.a(this.a, localQidianCorpInfo);
          QidianProfileCardActivity.a(this.a, paramHashMap);
          this.a.c(1);
          this.a.b();
        }
      }
    }
    label230:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          for (;;)
          {
            QidianExternalInfo localQidianExternalInfo;
            QidianCorpInfo localQidianCorpInfo;
            return;
            int i = 0;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QidianProfileCardActivity", 2, "onGetQidianUserDetailInfo not change");
        return;
      } while (!QLog.isColorLevel());
      QLog.d("QidianProfileCardActivity", 2, "onGetQidianUserDetailInfo not current uin");
      return;
    }
    QLog.d("QidianProfileCardActivity", 2, "onGetQidianUserDetailInfo fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akwt
 * JD-Core Version:    0.7.0.1
 */