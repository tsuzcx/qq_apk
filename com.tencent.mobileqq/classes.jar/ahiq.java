import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.data.SearchHistory;

public final class ahiq
  implements Runnable
{
  public ahiq(int paramInt, String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SearchHistory localSearchHistory = new SearchHistory();
    localSearchHistory.type = this.jdField_a_of_type_Int;
    localSearchHistory.uin = this.jdField_a_of_type_JavaLangString;
    localSearchHistory.troopUin = this.b;
    localSearchHistory.displayName = this.c;
    SearchHistoryManager localSearchHistoryManager = (SearchHistoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
    if (localSearchHistoryManager == null) {
      return;
    }
    localSearchHistoryManager.a(localSearchHistory);
    com.tencent.mobileqq.search.activity.UniteSearchActivity.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahiq
 * JD-Core Version:    0.7.0.1
 */