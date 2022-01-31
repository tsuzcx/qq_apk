import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter;
import com.tencent.mobileqq.teamwork.TeamWorkAuthorizeUinListAdapter.ItemData;
import com.tencent.mobileqq.teamwork.TeamWorkObserver;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkAuthorizeSettingFragment;
import com.tencent.pb.teamwork.TimDocSSOMsg.UinRightInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ahyp
  extends TeamWorkObserver
{
  public ahyp(TeamWorkAuthorizeSettingFragment paramTeamWorkAuthorizeSettingFragment) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.a.h();
    if (!paramBoolean) {
      FMToastUtil.a("权限获取失败，请稍后再试。");
    }
    while ((this.a.jdField_a_of_type_Int != paramInt) && (!paramString.equalsIgnoreCase(this.a.jdField_a_of_type_JavaLangString))) {
      return;
    }
    if ((0 == 0) && (QLog.isDevelopLevel())) {
      QLog.i("TeamWorkAuthorizeSettingFragment", 1, "padInfo is null, maybe is newpad");
    }
    this.a.jdField_a_of_type_JavaUtilList.clear();
    if (0 != 0) {
      throw new NullPointerException();
    }
    for (;;)
    {
      TeamWorkAuthorizeSettingFragment.a(this.a, this.a.b);
      TeamWorkAuthorizeSettingFragment.a(this.a);
      TeamWorkAuthorizeSettingFragment.a(this.a, true);
      return;
      this.a.b = 2;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, List paramList)
  {
    this.a.h();
    if (!paramBoolean) {
      FMToastUtil.a("权限获取失败，请稍后再试。");
    }
    while (!paramString.equalsIgnoreCase(this.a.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.a.jdField_a_of_type_JavaUtilList.clear();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (TimDocSSOMsg.UinRightInfo)paramString.next();
      TeamWorkAuthorizeUinListAdapter.ItemData localItemData = new TeamWorkAuthorizeUinListAdapter.ItemData();
      localItemData.jdField_a_of_type_JavaLangString = String.valueOf(paramList.uint64_uin.get());
      localItemData.jdField_a_of_type_ComTencentPbTeamworkTimDocSSOMsg$UinRightInfo = paramList;
      this.a.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkAuthorizeUinListAdapter.a(localItemData);
    }
    this.a.b = paramInt;
    TeamWorkAuthorizeSettingFragment.a(this.a, this.a.b);
    TeamWorkAuthorizeSettingFragment.a(this.a);
    TeamWorkAuthorizeSettingFragment.a(this.a, true);
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt)
  {
    TeamWorkAuthorizeSettingFragment.a(this.a, true);
    this.a.b().setEnabled(true);
    this.a.h();
    if (!paramBoolean) {
      FMToastUtil.a("权限设置失败，请稍后再试。");
    }
    Intent localIntent;
    do
    {
      return;
      FMToastUtil.b("权限设置成功。");
      this.a.h();
      localIntent = new Intent();
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("type", paramInt);
    } while (!this.a.isAdded());
    this.a.getActivity().setResult(1122, localIntent);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahyp
 * JD-Core Version:    0.7.0.1
 */