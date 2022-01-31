import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.TextViewHolder;

class aiwb
  implements Runnable
{
  aiwb(aiwa paramaiwa) {}
  
  public void run()
  {
    ((InputMethodManager)this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getContext().getSystemService("input_method")).showSoftInput(this.a.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiTextItem$TextViewHolder.a, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiwb
 * JD-Core Version:    0.7.0.1
 */