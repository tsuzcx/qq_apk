import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class acml
  implements Runnable
{
  public acml(EmoticonMainPanel paramEmoticonMainPanel, boolean paramBoolean, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a == null) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      FavroamingDBManager localFavroamingDBManager = (FavroamingDBManager)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a.getManager(148);
      List localList1 = localFavroamingDBManager.a();
      if ((localList1 != null) && (localList1.size() > FavEmoConstant.a))
      {
        List localList2 = localList1.subList(0, localList1.size() - FavEmoConstant.a);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "delListOverflow=" + localList2.toString() + "emolist.size=" + localList1.size());
        }
        localFavroamingDBManager.a(localList2);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i();
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("local_overflow" + this.jdField_a_of_type_JavaLangString, true).apply();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.g();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acml
 * JD-Core Version:    0.7.0.1
 */