import android.app.Activity;
import android.view.View;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;

class aeca
  implements bcjq
{
  aeca(aebx paramaebx, boolean paramBoolean) {}
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextItemBuilder", 2, "SingleTap invoked!");
    }
    Object localObject = (AnimationTextView)paramView;
    float f1 = ((AnimationTextView)localObject).touchL - aebx.e;
    float f2 = ((AnimationTextView)localObject).touchT;
    float f3 = aebx.c;
    if (this.jdField_a_of_type_Boolean) {
      f1 = ((AnimationTextView)localObject).touchL - aebx.f;
    }
    localObject = ((AnimationTextView)localObject).getText();
    int k;
    boolean bool2;
    int j;
    boolean bool1;
    if ((localObject instanceof aykk))
    {
      localObject = (aykk)localObject;
      localObject = (aykr[])((aykk)localObject).getSpans(0, ((aykk)localObject).length(), aykr.class);
      if (!(paramView instanceof ETTextView)) {
        break label325;
      }
      paramView = (ETTextView)paramView;
      k = paramView.mClickEpId;
      int m = paramView.mClickcEId;
      if ((paramView.mFont == null) || (paramView.mFont.mFontId == 0) || (paramView.mFont.mFontType != 1)) {
        break label307;
      }
      bool2 = true;
      i = k;
      j = m;
      bool1 = bool2;
      if (bool2)
      {
        i = k;
        j = m;
        bool1 = bool2;
        if (paramView.getETLayout() != null)
        {
          paramView = paramView.getETLayout();
          if (QLog.isColorLevel()) {
            QLog.d("ChatItemBuilder", 2, "isHanYiFont, onlyEmoji: " + paramView.jdField_a_of_type_Boolean);
          }
          if (paramView.jdField_a_of_type_Boolean) {
            break label313;
          }
          bool1 = true;
          label241:
          j = m;
        }
      }
    }
    for (int i = k;; i = -1)
    {
      if ((i != -1) && (j != -1)) {}
      for (bool2 = true;; bool2 = false)
      {
        anzr.a((aykr[])localObject, f1, f2 - f3, bool2, i, j, this.jdField_a_of_type_Aebx.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aebx.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (Activity)this.jdField_a_of_type_Aebx.jdField_a_of_type_AndroidContentContext, bool1);
        return;
        label307:
        bool2 = false;
        break;
        label313:
        bool1 = false;
        break label241;
      }
      label325:
      bool1 = false;
      j = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeca
 * JD-Core Version:    0.7.0.1
 */