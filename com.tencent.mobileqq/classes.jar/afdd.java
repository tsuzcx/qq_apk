import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity.23.1;
import com.tencent.mobileqq.activity.TroopInfoActivity.23.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public class afdd
  extends aofu
{
  public afdd(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void onGenNewTroopName(String paramString1, String paramString2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopName();
      this.a.c();
    }
  }
  
  protected void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0)) {}
    Object localObject;
    do
    {
      return;
      int i = 0;
      localObject = null;
      if ((localObject == null) && (i < paramArrayList.size()))
      {
        TroopInfo localTroopInfo = (TroopInfo)paramArrayList.get(i);
        if (localTroopInfo == null) {
          localObject = localTroopInfo;
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = localTroopInfo;
          if (!bhbx.a(localTroopInfo.troopuin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
            localObject = null;
          }
        }
      }
    } while (localObject == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localObject;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(localObject, this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  protected void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString)
  {
    if ((paramBoolean) && (paramTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin.equals(paramTroopInfo.troopuin)))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopowneruin = paramTroopInfo.troopowneruin;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopname = paramTroopInfo.troopname;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopface = paramTroopInfo.troopface;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopmemo = paramTroopInfo.troopmemo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.fingertroopmemo = paramTroopInfo.fingertroopmemo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo = paramTroopInfo.mRichFingerMemo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.location = paramTroopInfo.location;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.grade = paramTroopInfo.grade;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.school = paramTroopInfo.school;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.strLocation = paramTroopInfo.strLocation;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopLat = paramTroopInfo.troopLat;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopLon = paramTroopInfo.troopLon;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupFlagExt = paramTroopInfo.dwGroupFlagExt;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopAuthenticateInfo = paramTroopInfo.troopAuthenticateInfo;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopTypeExt = paramTroopInfo.troopTypeExt;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.dwGroupClassExt = paramTroopInfo.dwGroupClassExt;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop = paramTroopInfo.isNewTroop;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopName = paramTroopInfo.hasSetNewTroopName;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopHead = paramTroopInfo.hasSetNewTroopHead;
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTags = paramTroopInfo.mTags;
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo)) {
        break label535;
      }
    }
    for (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.fingertroopmemo;; this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo = HttpUtil.unEscape(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo))
    {
      this.a.jdField_a_of_type_Int = this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopTypeExt;
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.a.app.getCurrentAccountUin());
      if (this.a.jdField_a_of_type_Int != this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt) {
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.troopinfo", 4, "updateTroopInfoToDB");
        }
        ThreadManager.post(new TroopInfoActivity.23.1(this, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo), 8, null, true);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.post(new TroopInfoActivity.23.2(this));
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      return;
      label535:
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo = HttpUtil.removeHtmlTags(this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mRichFingerMemo);
    }
  }
  
  protected void onGetTroopAuditTimes(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if ((!paramBoolean) || (!bhbx.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      return;
    }
    this.a.c = paramInt1;
    this.a.d = paramInt2;
    this.a.e = paramInt3;
    if ((this.a.c == 1) || (this.a.c == 2)) {
      this.a.app.getApplication().getSharedPreferences("auth_troop_info_filename", 4).edit().remove("has_shown_tips").commit();
    }
    if (this.a.c == 2)
    {
      paramString = paramGroupInfo.string_group_name.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopName = paramString;
        this.a.a(10, paramString, true);
      }
      paramString = paramGroupInfo.group_geo_info.bytes_geocontent.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramString)) {
        this.a.a(5, paramString, true);
      }
      paramString = bgst.a(BaseApplication.getContext()).a(this.a, Long.toString(paramGroupInfo.uint32_group_class_ext.get()));
      if (paramString != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt = paramGroupInfo.uint32_group_class_ext.get();
        this.a.a(4, paramString.a(), true);
      }
      paramString = TroopInfo.setTags(paramGroupInfo.rpt_tag_record.get());
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(paramString);
        paramString = TroopInfoActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
        this.a.a(8, paramString, true, 2, true);
      }
      paramString = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo = paramString;
        this.a.a(6, paramString, true);
      }
    }
    TroopInfoActivity.e(this.a);
  }
  
  protected void onGetTroopAuthSubmitTime(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramString != null) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {
      this.a.b = paramInt;
    }
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (!bhbx.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onGetTroopInfoResult|uin = " + paramString);
      }
      paramString = ((TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
    } while (paramString == null);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramString;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(paramString, this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  protected void onGetTroopTagResult(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(paramString1)))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTags = paramString2;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(paramString2);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    }
  }
  
  protected void onModifyTroopInfo(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo)
  {
    if (!bhbx.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(paramLong))) {}
    do
    {
      do
      {
        return;
        if ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramInt))))
        {
          this.a.jdField_a_of_type_JavaUtilList.remove(Integer.valueOf(paramInt));
          if (paramTroopInfo != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
          }
          if (paramBoolean)
          {
            this.a.a(2131693285, 2);
            return;
          }
          this.a.a(2131693284, 1);
          TroopInfoActivity.a(this.a, paramInt);
          return;
        }
      } while ((!paramBoolean) || (paramTroopInfo == null));
      this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
    } while ((this.a.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_JavaUtilList.size() != 0));
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(paramTroopInfo, this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
  
  protected void onOIDB0X88D_1_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    this.a.p();
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 4) {}
    while (paramLong != Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
      return;
    }
    if (paramBoolean)
    {
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      TroopInfoActivity.f(this.a);
      return;
    }
    this.a.a(2131718500, 1);
  }
  
  protected void onSetTroopAuditTimes(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      if (this.a.jdField_a_of_type_Aoep != null)
      {
        this.a.jdField_a_of_type_Aoep.g(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        this.a.jdField_a_of_type_Aoep.a(this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      return;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = this.a.getString(2131693284);
    }
    QQToast.a(localBaseApplication, 1, str, 0).b(this.a.getTitleBarHeight());
  }
  
  protected void onTroopSearch(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    if ((!paramBoolean1) || (paramTroopInfo == null) || (!bhbx.a(paramTroopInfo.troopuin, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.troopinfo", 2, "onTroopSearch|result = " + paramByte + ", p = " + paramTroopInfo);
      }
    } while (paramByte != 0);
    this.a.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = paramTroopInfo;
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(paramTroopInfo, this.a.app.getCurrentAccountUin());
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdd
 * JD-Core Version:    0.7.0.1
 */