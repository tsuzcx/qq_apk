import android.text.Editable;
import android.text.TextUtils;
import com.tencent.mobileqq.tribe.view.TEditText;
import com.tencent.mobileqq.tribe.view.TEditText.OnSelectionChangedListener;
import com.tencent.mobileqq.tribe.view.TribeTitlePrefixPanelView.TitlePrefixItem;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.util.InputMethodUtil;
import java.util.List;

public class aixj
  implements TEditText.OnSelectionChangedListener
{
  public aixj(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    int m = 1;
    int i = this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().length();
    if (this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.getText().length() <= 0) {
      return;
    }
    int j = this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.b.length();
    int k = this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.a.length();
    int n = this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.c.length() + (j + k);
    if ((paramInt1 < this.a.K.length() + n) && (paramInt2 < this.a.K.length() + n))
    {
      if (TroopBarPublishActivity.a(this.a).size() > 1)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.clearFocus();
        InputMethodUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(i);
      return;
    }
    if (paramInt1 < 0) {
      if (paramInt2 > this.a.K.length() + n)
      {
        paramInt1 = paramInt2;
        label195:
        if (paramInt1 <= i) {
          break label431;
        }
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(i);
      return;
      paramInt1 = this.a.K.length() + n;
      break label195;
      if (paramInt2 < 0) {
        if (paramInt1 > this.a.K.length() + n) {
          label250:
          if (paramInt1 <= i) {
            break label426;
          }
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(i);
        return;
        paramInt1 = this.a.K.length() + n;
        break label250;
        if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTribeTitlePrefixPanelView$TitlePrefixItem.b)) {
          break;
        }
        k = 0;
        j = paramInt1;
        if (paramInt1 < this.a.K.length() + n)
        {
          j = n + this.a.K.length();
          k = 1;
        }
        if (paramInt2 < this.a.K.length() + n)
        {
          paramInt1 = n + this.a.K.length();
          k = 1;
        }
        for (;;)
        {
          paramInt2 = j;
          if (j > i)
          {
            k = 1;
            paramInt2 = i;
          }
          if (paramInt1 > i) {
            k = m;
          }
          while (k != 0)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqTribeViewTEditText.setSelection(paramInt2, i);
            return;
            i = paramInt1;
          }
          break;
          paramInt1 = paramInt2;
        }
        label426:
        i = paramInt1;
      }
      label431:
      i = paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aixj
 * JD-Core Version:    0.7.0.1
 */