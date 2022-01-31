import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class akab
  extends alrl
{
  public akab(SelectMemberActivity paramSelectMemberActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString)
  {
    if (!paramBoolean) {
      SelectMemberActivity.jdField_b_of_type_Boolean = false;
    }
    if (this.a.jdField_a_of_type_Bety != null)
    {
      this.a.jdField_a_of_type_Bety.dismiss();
      if (paramBoolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SelectMemberActivity", 2, "create discussion success: roomId: " + paramLong + ", mSubType: " + this.a.jdField_b_of_type_Int + ", mEntrance: " + this.a.d);
        }
        paramString = new ArrayList();
        Iterator localIterator = this.a.e.iterator();
        while (localIterator.hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)localIterator.next();
          if (localResultRecord.jdField_a_of_type_Int == 5)
          {
            if (localResultRecord.jdField_a_of_type_JavaLangString.startsWith("pstn")) {
              localResultRecord.jdField_a_of_type_JavaLangString = localResultRecord.jdField_a_of_type_JavaLangString.substring("pstn".length());
            }
            paramString.add(localResultRecord.jdField_a_of_type_JavaLangString);
          }
          else if ((localResultRecord.jdField_a_of_type_Int == 4) && (localResultRecord.jdField_a_of_type_JavaLangString.startsWith("+")))
          {
            paramString.add(localResultRecord.jdField_a_of_type_JavaLangString);
          }
        }
        this.a.jdField_a_of_type_AndroidContentIntent.putExtra("roomId", paramLong);
        if (this.a.d == 12) {
          this.a.jdField_a_of_type_AndroidContentIntent.putExtra("select_memeber_discussion_memeber_count", this.a.e.size() + 1);
        }
        this.a.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.a.e);
        this.a.setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
        this.a.finish();
      }
    }
    else
    {
      return;
    }
    QLog.d("SelectMemberActivity", 1, "create discussion fail, errCode=" + paramInt);
    if (paramInt == 1000)
    {
      QQToast.a(this.a, this.a.getString(2131698051), 2000).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
      azqs.b(this.a.app, "dc00899", "Grp_set", "", "Grp_data", "forbid_discuss", 0, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.a, this.a.getString(2131691871), 2000).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (this.a.jdField_a_of_type_Bety != null)
    {
      this.a.jdField_a_of_type_Bety.dismiss();
      if (!paramBoolean) {
        break label231;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectMemberActivity", 2, "add discussion member success: roomId: " + paramLong);
      }
      paramArrayList = new ArrayList();
      Iterator localIterator = this.a.e.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        if (localResultRecord.jdField_a_of_type_Int == 5)
        {
          if (localResultRecord.jdField_a_of_type_JavaLangString.startsWith("pstn")) {
            localResultRecord.jdField_a_of_type_JavaLangString = localResultRecord.jdField_a_of_type_JavaLangString.substring("pstn".length());
          }
          paramArrayList.add(localResultRecord.jdField_a_of_type_JavaLangString);
        }
      }
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("roomId", paramLong);
      this.a.jdField_a_of_type_AndroidContentIntent.putParcelableArrayListExtra("result_set", this.a.e);
      if (!paramBoolean) {
        break label213;
      }
      this.a.setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
    }
    for (;;)
    {
      this.a.finish();
      return;
      label213:
      this.a.setResult(1, this.a.jdField_a_of_type_AndroidContentIntent);
    }
    label231:
    if (QLog.isColorLevel()) {
      QLog.d("SelectMemberActivity", 2, "add discussion member fail");
    }
    if (paramInt == 1000) {
      azqs.b(this.a.app, "dc00899", "Grp_set", "", "Grp_data", "forbid_discuss", 0, 0, "", "", "", "");
    }
    QQToast.a(this.a, this.a.getString(2131691866), 2000).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
  }
  
  protected void a(Object[] paramArrayOfObject)
  {
    if (this.a.jdField_a_of_type_Bety != null) {
      this.a.jdField_a_of_type_Bety.dismiss();
    }
    if (paramArrayOfObject == null) {}
    String str;
    do
    {
      return;
      str = (String)paramArrayOfObject[0];
    } while (!this.a.jdField_c_of_type_JavaLangString.equals(str));
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    QLog.d("SelectMemberActivity", 2, "add discussion member failed, error code: " + i);
    QQToast.a(this.a, this.a.getString(2131691866), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akab
 * JD-Core Version:    0.7.0.1
 */