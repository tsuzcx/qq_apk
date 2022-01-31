import android.graphics.Color;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class abeh
  implements View.OnLongClickListener
{
  BackgroundColorSpan jdField_a_of_type_AndroidTextStyleBackgroundColorSpan = null;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new abek(this);
  ausu jdField_a_of_type_Ausu;
  boolean jdField_a_of_type_Boolean = false;
  
  public abeh(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  void a(TextView paramTextView)
  {
    if (paramTextView == null) {}
    Spannable localSpannable;
    do
    {
      return;
      localSpannable = null;
      if ((paramTextView.getText() instanceof Spannable)) {
        localSpannable = (Spannable)paramTextView.getText();
      }
    } while (localSpannable == null);
    localSpannable.removeSpan(this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan);
  }
  
  void a(TextView paramTextView, String paramString)
  {
    if ((paramTextView == null) || (paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      String str = paramTextView.getText().toString();
      int k = str.indexOf(paramString);
      int m = k + paramString.length();
      if ((k >= 0) && (m <= str.length()))
      {
        if ((paramTextView.getText() instanceof Spannable)) {}
        for (paramTextView = (Spannable)paramTextView.getText(); paramTextView != null; paramTextView = null)
        {
          int i;
          if (this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan == null) {
            i = 1714664933;
          }
          try
          {
            int j = Color.parseColor("#33000000");
            i = j;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
            }
          }
          this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan = new BackgroundColorSpan(i);
          paramTextView.setSpan(this.jdField_a_of_type_AndroidTextStyleBackgroundColorSpan, k, m, 17);
          return;
        }
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    bblr localbblr = null;
    if ((this.jdField_a_of_type_Boolean) || (paramView == null) || (!(paramView.getTag() instanceof ausu))) {
      return false;
    }
    Object localObject1 = (ausu)paramView.getTag();
    try
    {
      localMap = (Map)((ausu)localObject1).jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Ausu = ((ausu)localObject1);
      switch (((ausu)localObject1).jdField_a_of_type_Int)
      {
      default: 
        localObject1 = null;
        if ((localbblr != null) && (localbblr.a() > 0))
        {
          this.jdField_a_of_type_Boolean = true;
          if (localMap == null) {
            break label449;
          }
        }
        break;
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        try
        {
          if (localMap.containsKey("xoff")) {
            i = ((Integer)localMap.get("xoff")).intValue();
          }
        }
        catch (Throwable localThrowable2)
        {
          try
          {
            Map localMap;
            if (localMap.containsKey("yoff"))
            {
              j = ((Integer)localMap.get("yoff")).intValue();
              bbcc.a(paramView, i, j, localbblr, this.jdField_a_of_type_AndroidViewView$OnClickListener, (bfps)localObject1);
              return true;
              localThrowable1 = localThrowable1;
              if (QLog.isColorLevel()) {
                QLog.d("FriendProfileCardActivity", 2, localThrowable1, new Object[0]);
              }
              Object localObject2 = null;
              continue;
              paramView.setSelected(true);
              localbblr = new bblr();
              localbblr.a(2131364825, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131691307), 0);
              localObject1 = new abei(this, paramView);
              continue;
              localbblr = new bblr();
              if ((this.jdField_a_of_type_Ausu.jdField_a_of_type_JavaLangObject instanceof ausf))
              {
                ((ausf)this.jdField_a_of_type_Ausu.jdField_a_of_type_JavaLangObject).a(localbblr);
                if ((paramView instanceof TextView)) {
                  a((TextView)paramView, ((ausf)this.jdField_a_of_type_Ausu.jdField_a_of_type_JavaLangObject).a);
                }
                localObject1 = new abej(this, paramView);
                continue;
              }
              if (!(this.jdField_a_of_type_Ausu.jdField_a_of_type_JavaLangObject instanceof String)) {
                continue;
              }
              localbblr.a(2131364825, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131691307), 0);
              if (!(paramView instanceof TextView)) {
                continue;
              }
              a((TextView)paramView, (String)this.jdField_a_of_type_Ausu.jdField_a_of_type_JavaLangObject);
              continue;
              localThrowable2 = localThrowable2;
              i = 0;
              if (QLog.isColorLevel()) {
                QLog.d("FriendProfileCardActivity", 2, localThrowable2, new Object[0]);
              }
              j = 0;
              continue;
            }
          }
          catch (Throwable localThrowable3)
          {
            continue;
            j = 0;
            continue;
          }
          i = 0;
          continue;
        }
        label449:
        int j = 0;
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abeh
 * JD-Core Version:    0.7.0.1
 */