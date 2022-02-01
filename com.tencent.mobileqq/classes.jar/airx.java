import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import java.util.Iterator;
import java.util.List;

public class airx
  implements ssu
{
  public airx(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void a(String paramString)
  {
    SearchProtocol.WordItem localWordItem;
    if (paramString != null)
    {
      Iterator localIterator = this.a.b.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localWordItem = (SearchProtocol.WordItem)localIterator.next();
      } while (!paramString.equals(localWordItem.word));
    }
    for (;;)
    {
      if ((localWordItem != null) && (localWordItem.type == 2))
      {
        paramString = new Intent(this.a, QQBrowserActivity.class);
        paramString.putExtra("hide_operation_bar", true);
        paramString.putExtra("url", localWordItem.jumpUrl);
        paramString.putExtra("articalChannelId", 14);
        this.a.startActivity(paramString);
        if (localWordItem != null)
        {
          paramString = "";
          if (this.a.f != ClassificationSearchActivity.jdField_a_of_type_Int) {
            break label333;
          }
          paramString = "kan";
        }
      }
      for (;;)
      {
        if (localWordItem.type != 2) {
          break label352;
        }
        oat.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006818", "0X8006818", 0, 0, localWordItem.word, localWordItem.jumpUrl, paramString, "");
        return;
        if (this.a.f == ClassificationSearchActivity.jdField_a_of_type_Int)
        {
          this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
          if (!TextUtils.isEmpty(paramString.trim()))
          {
            this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.a.jdField_a_of_type_AndroidWidgetEditText.getText().length());
            ClassificationSearchActivity.a(this.a, paramString);
          }
        }
        for (;;)
        {
          if ((this.a.f == ClassificationSearchActivity.d) || (TextUtils.isEmpty(paramString.trim()))) {
            break label331;
          }
          this.a.a(paramString);
          break;
          if (this.a.f == ClassificationSearchActivity.d)
          {
            this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
            this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramString.length());
            ClassificationSearchActivity.a(this.a, paramString);
          }
          else
          {
            this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.a(paramString, false);
          }
        }
        label331:
        break;
        label333:
        if (this.a.f == ClassificationSearchActivity.d) {
          paramString = "quan";
        }
      }
      label352:
      oat.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006818", "0X8006818", 0, 0, localWordItem.word, "0", paramString, "");
      return;
      localWordItem = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airx
 * JD-Core Version:    0.7.0.1
 */