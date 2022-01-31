import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.KeywordResult;
import com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.SchoolTroopHighlightSpan;

public class ajvi
  implements Runnable
{
  public ajvi(SchoolTroopKeywordManager.SchoolTroopHighlightSpan paramSchoolTroopHighlightSpan, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject;
    if (!SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$SchoolTroopHighlightSpan).jdField_a_of_type_Boolean)
    {
      localObject = SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$SchoolTroopHighlightSpan).getCurrentAccountUin();
      localObject = ((TroopManager)SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$SchoolTroopHighlightSpan).getManager(51)).b(SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$SchoolTroopHighlightSpan).jdField_a_of_type_JavaLangString, (String)localObject);
      if (localObject != null)
      {
        if (((TroopMemberInfo)localObject).level != 332) {
          break label186;
        }
        localObject = SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$SchoolTroopHighlightSpan);
        ((SchoolTroopKeywordManager.KeywordResult)localObject).jdField_a_of_type_Int |= 0x4;
      }
    }
    for (;;)
    {
      SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$SchoolTroopHighlightSpan).jdField_a_of_type_Boolean = true;
      ReportController.b(null, "dc00899", this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.c, this.d, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$SchoolTroopHighlightSpan).jdField_a_of_type_JavaLangString, SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$SchoolTroopHighlightSpan).a(), SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$SchoolTroopHighlightSpan).jdField_b_of_type_Int + "", SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$SchoolTroopHighlightSpan).jdField_b_of_type_JavaLangString);
      return;
      label186:
      if (((TroopMemberInfo)localObject).level == 333)
      {
        localObject = SchoolTroopKeywordManager.SchoolTroopHighlightSpan.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsSchoolTroopKeywordManager$SchoolTroopHighlightSpan);
        ((SchoolTroopKeywordManager.KeywordResult)localObject).jdField_a_of_type_Int |= 0x8;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvi
 * JD-Core Version:    0.7.0.1
 */