import SummaryCard.RespCondSearch;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class alll
  extends alox
{
  alll(allj paramallj) {}
  
  protected void onCondSearchFriendResult(long paramLong, boolean paramBoolean, Object paramObject, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "searchseq = " + this.a.jdField_a_of_type_Long + " | seq = " + paramLong + ", isSuccess=" + paramBoolean + ", ret=" + paramInt1 + ", searchFrom=" + paramInt2);
    }
    if (this.a.jdField_a_of_type_Long != paramLong) {
      return;
    }
    if ((paramBoolean) && (paramInt1 == 0))
    {
      paramObject = (RespCondSearch)paramObject;
      allj localallj = this.a;
      if (paramObject.cEndFlag == 0)
      {
        paramBoolean = true;
        localallj.jdField_e_of_type_Boolean = paramBoolean;
        this.a.jdField_f_of_type_Int = paramObject.iPage;
        this.a.jdField_b_of_type_Long = paramObject.dwSessionID;
        if (this.a.jdField_b_of_type_JavaUtilList != null) {
          break label342;
        }
        this.a.jdField_b_of_type_JavaUtilList = paramObject.vUserList;
      }
      for (;;)
      {
        if ((this.a.jdField_g_of_type_Int >= 2) || ((this.a.jdField_b_of_type_JavaUtilList != null) && (this.a.jdField_b_of_type_JavaUtilList.size() >= 10)) || (!this.a.jdField_e_of_type_Boolean)) {
          break label382;
        }
        paramObject = this.a;
        paramObject.jdField_g_of_type_Int += 1;
        ((FriendListHandler)allj.a(this.a).a(1)).a(this.a.jdField_a_of_type_Long, this.a.jdField_f_of_type_Int + 1, this.a.jdField_b_of_type_Long, this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_Int, this.a.jdField_b_of_type_Int, this.a.c, this.a.jdField_f_of_type_ArrayOfJavaLangString, this.a.jdField_g_of_type_ArrayOfJavaLangString, this.a.d, this.a.jdField_e_of_type_Int, paramInt2);
        return;
        paramBoolean = false;
        break;
        label342:
        if ((paramObject.vUserList != null) && (!paramObject.vUserList.isEmpty())) {
          this.a.jdField_b_of_type_JavaUtilList.addAll(paramObject.vUserList);
        }
      }
      label382:
      if ((this.a.jdField_b_of_type_JavaUtilList == null) || (this.a.jdField_b_of_type_JavaUtilList.size() < 6)) {
        this.a.jdField_e_of_type_Boolean = false;
      }
      this.a.a(true, this.a.jdField_b_of_type_JavaUtilList, this.a.jdField_e_of_type_Boolean, paramInt2);
      return;
    }
    if ((paramBoolean) && (paramInt1 != 0))
    {
      this.a.jdField_e_of_type_Boolean = false;
      this.a.a(true, this.a.jdField_b_of_type_JavaUtilList, this.a.jdField_e_of_type_Boolean, paramInt2);
      return;
    }
    if (this.a.jdField_g_of_type_Int == 0)
    {
      this.a.a(false, null, this.a.jdField_e_of_type_Boolean, paramInt2);
      return;
    }
    this.a.a(true, this.a.jdField_b_of_type_JavaUtilList, this.a.jdField_e_of_type_Boolean, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alll
 * JD-Core Version:    0.7.0.1
 */