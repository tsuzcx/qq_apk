import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class afdb
  implements afez, bicl
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private bchh jdField_a_of_type_Bchh;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  
  public afdb(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_AndroidAppActivity = paramTroopChatPie.a();
  }
  
  private boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    boolean bool1;
    boolean bool2;
    label88:
    Object localObject;
    label280:
    int j;
    if ((paramInt3 == 1) && ((paramCharSequence.charAt(paramInt1) == 65312) || (paramCharSequence.charAt(paramInt1) == '@')))
    {
      bool1 = true;
      if ((paramInt3 != 0) || (i <= 0) || ((paramCharSequence.charAt(i - 1) != 65312) && (paramCharSequence.charAt(i - 1) != '@'))) {
        break label547;
      }
      bool2 = true;
      if ((bool1) || (bool2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.A()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.d(true);
        }
        if (this.jdField_a_of_type_Bchh == null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a().findViewById(2131362249) == null)
          {
            paramCharSequence = new View(this.jdField_a_of_type_AndroidAppActivity);
            paramCharSequence.setId(2131362249);
            localObject = new RelativeLayout.LayoutParams(-1, -2);
            ((RelativeLayout.LayoutParams)localObject).addRule(12);
            ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131368344);
            ((RelativeLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131364139)).addView(paramCharSequence, 3, (ViewGroup.LayoutParams)localObject);
          }
          this.jdField_a_of_type_Bchh = new bchh(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setKeyEventPreImeListener(this);
        }
      }
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().lastIndexOf("＠", i - 1);
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().lastIndexOf("@", i - 1);
      if (paramInt1 <= paramInt2) {
        break label553;
      }
      j = bchn.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      paramInt3 = bchn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      if (i - 1 < 0) {
        break label596;
      }
    }
    label547:
    label553:
    label563:
    label569:
    label596:
    for (paramCharSequence = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().substring(i - 1, i);; paramCharSequence = null)
    {
      if ((paramInt3 >= 0) && (paramInt3 == i))
      {
        paramInt2 = 1;
        label348:
        if ((paramInt3 < 0) || (paramInt3 != i - 1) || (paramCharSequence == null) || (!paramCharSequence.equals(" "))) {
          break label563;
        }
        paramInt3 = 1;
        label378:
        if (QLog.isColorLevel()) {
          QLog.d("AIOAtHelper", 2, "selectIndex =" + i + " isFirstAddAt=" + bool1 + " isFirstBackAt=" + bool2 + " max=" + paramInt1 + " lastSpanAt=" + j + " mAtPanel=" + this.jdField_a_of_type_Bchh);
        }
        if ((j >= paramInt1) || (paramInt1 < 0) || (this.jdField_a_of_type_Bchh == null)) {
          break label569;
        }
        paramCharSequence = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().substring(paramInt1 + 1, i);
        bool1 = bchn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131362249);
        this.jdField_a_of_type_Bchh.a((View)localObject, paramCharSequence, bool1);
      }
      for (;;)
      {
        return false;
        bool1 = false;
        break;
        bool2 = false;
        break label88;
        paramInt1 = paramInt2;
        break label280;
        paramInt2 = 0;
        break label348;
        paramInt3 = 0;
        break label378;
        if ((this.jdField_a_of_type_Bchh != null) && (paramInt3 == 0) && (paramInt2 == 0)) {
          this.jdField_a_of_type_Bchh.a();
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bchh != null)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a().findViewById(2131362249);
      if (localView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a().removeView(localView);
      }
      this.jdField_a_of_type_Bchh.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setKeyEventPreImeListener(null);
      this.jdField_a_of_type_Bchh = null;
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAtHelper", 2, " beforeTextChanged:  start=" + paramInt1 + " after=" + paramInt3 + " count=" + paramInt2);
    }
    if ((this.jdField_a_of_type_Bchh != null) && (this.jdField_a_of_type_Bchh.b())) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAtHelper", 2, "beforeTextChanged mAtPanel spanChange");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramInt3 != 0) || (paramInt2 <= 0) || (paramCharSequence.length() <= 0));
        paramCharSequence = bchn.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        paramInt2 = bchn.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      } while ((paramCharSequence == null) || (paramInt2 != paramInt1));
      if (QLog.isColorLevel()) {
        QLog.d("AIOAtHelper", 2, new Object[] { " delete member:", paramCharSequence.a(), " nick:", paramCharSequence.b() });
      }
    } while (this.jdField_a_of_type_Bchh == null);
    this.jdField_a_of_type_Bchh.a(paramCharSequence.a());
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bchh != null) && (this.jdField_a_of_type_Bchh.a());
  }
  
  public boolean a(KeyEvent paramKeyEvent)
  {
    return (paramKeyEvent.getKeyCode() == 4) && (this.jdField_a_of_type_Bchh != null) && (this.jdField_a_of_type_Bchh.a());
  }
  
  public void b(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Bchh != null) && (this.jdField_a_of_type_Bchh.b())) {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAtHelper", 2, "mAtPanel spanChange");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.f() == 3) {
      return;
    }
    a(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdb
 * JD-Core Version:    0.7.0.1
 */