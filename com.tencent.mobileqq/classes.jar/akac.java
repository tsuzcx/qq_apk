import android.content.Intent;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class akac
  extends ameq
{
  public akac(SelectMemberActivity paramSelectMemberActivity) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 8)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add troop member fail");
      }
      SelectMemberActivity.a(this.a, paramInt2);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 8)
    {
      if (paramInt2 == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "add troop member success");
        }
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
        if (!this.a.jdField_c_of_type_Boolean)
        {
          paramInt1 = this.a.b();
          this.a.a(paramInt1 + 1);
          azqs.b(this.a.app, "CliOper", "", "", "Grp", "Send_invite", 0, 0, "", "", "", "");
        }
        ArrayList localArrayList = this.a.a();
        this.a.jdField_a_of_type_AndroidContentIntent.putExtra("roomId", Long.parseLong(paramString));
        this.a.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.a.e);
        this.a.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set_for_out_Member ", localArrayList);
        this.a.setResult(-1);
      }
    }
    else {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "add troop member fail, troopUin: " + paramString + " result: " + paramInt2);
    }
    SelectMemberActivity.a(this.a, paramInt2);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    String str = String.valueOf(paramLong1);
    if ((paramBoolean) && (str.equals(this.a.jdField_c_of_type_JavaLangString)))
    {
      this.a.jdField_a_of_type_Long = paramLong2;
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "troop" + str + " get inviteNoAuthLimitNum = " + paramLong2);
      }
      if ((this.a.i >= this.a.jdField_a_of_type_Long) && (this.a.jdField_a_of_type_Long > 0L))
      {
        this.a.d.setVisibility(0);
        azqs.b(this.a.app, "dc00899", "invite_friend", "", "friend_list", "exp_needagree", 0, 0, str, mwu.a(this.a.app, this.a.app.getCurrentAccountUin(), str) + "", "", "");
      }
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong, List<Long> paramList)
  {
    paramLong = String.valueOf(paramLong);
    if ((paramBoolean) && (paramLong.equals(this.a.jdField_c_of_type_JavaLangString)))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        this.a.jdField_a_of_type_JavaUtilList.add(String.valueOf(localLong));
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "troop" + paramLong + " get invitedUinList = " + paramList.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akac
 * JD-Core Version:    0.7.0.1
 */