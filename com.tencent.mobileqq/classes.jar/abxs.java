import android.text.TextUtils;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.model.QueryTask.Query;

public class abxs
  implements QueryTask.Query
{
  public abxs(EmoticonMainPanel paramEmoticonMainPanel, int paramInt) {}
  
  public Integer a(String paramString)
  {
    EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a);
    int i = this.jdField_a_of_type_Int;
    if (!TextUtils.isEmpty(paramString)) {
      i = EmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel, paramString);
    }
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abxs
 * JD-Core Version:    0.7.0.1
 */