import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.ConditionSearchManager.ISearchListener;
import com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

public class abqn
  implements ConditionSearchManager.ISearchListener
{
  public abqn(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void a(boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt)
  {
    this.a.a();
    if (paramInt != 1) {
      return;
    }
    if (!paramBoolean1)
    {
      QQToast.a(this.a, 2131437300, 0).b(this.a.getTitleBarHeight());
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QQToast.a(this.a, 2131437301, 0).b(this.a.getTitleBarHeight());
      return;
    }
    SearchResultActivity.a(this.a, this.a.jdField_a_of_type_JavaLangString, this.a.b, this.a.c, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.b(), this.a.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.c(), this.a.e, this.a.d, paramList, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abqn
 * JD-Core Version:    0.7.0.1
 */