import android.annotation.TargetApi;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.together.ui.WatchPanelView;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;

public class aiwk
  implements aiwf
{
  protected View.OnClickListener a;
  protected ViewGroup a;
  protected BaseChatPie a;
  private WatchPanelView a;
  protected QQBlurView a;
  protected boolean a;
  
  public aiwk(BaseChatPie paramBaseChatPie, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private void b(bekj parambekj, QQAppInterface paramQQAppInterface)
  {
    String str2 = parambekj.b(paramQQAppInterface);
    String str1 = str2;
    if (parambekj.jdField_e_of_type_Int == 1)
    {
      str1 = str2;
      if (parambekj.jdField_f_of_type_Int >= 1)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(parambekj.jdField_f_of_type_JavaLangString))
        {
          parambekj = bhlg.h(paramQQAppInterface, parambekj.jdField_e_of_type_JavaLangString, parambekj.jdField_f_of_type_JavaLangString);
          str1 = str2;
          if (!TextUtils.isEmpty(parambekj)) {
            str1 = str2 + " | 发起人" + parambekj;
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.a(0, str1);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      a();
      return this.jdField_a_of_type_AndroidViewViewGroup;
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a()).inflate(2131561067, null));
    a();
    paramVarArgs = new FrameLayout.LayoutParams(-1, agej.a(56.0F, this.jdField_a_of_type_AndroidViewViewGroup.getResources()));
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(c());
    if (localView != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(localView);
    }
    a(paramVarArgs);
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379129));
    c();
    if (QLog.isColorLevel()) {
      QLog.d("TogetherTipsBar", 2, "showBlurView() called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
    }
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372170);
    if ((ThemeUtil.isDefaultOrDIYTheme(false)) || (ThemeUtil.isSimpleDayTheme(false)))
    {
      localView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherTipsBar", 2, "showBlurView() visibility called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
      }
      return;
    }
    localView.setBackgroundColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166964));
    localView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("TogetherTipsBar", 2, "showBlurView() gone called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1000) {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
        if (QLog.isColorLevel()) {
          QLog.d("TogetherTipsBar", 2, "resumeBlurView called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt != 1003) {
            break;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView == null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
      } while (!QLog.isColorLevel());
      QLog.d("TogetherTipsBar", 2, "pauseBlurView called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
      return;
    } while (paramInt != 1004);
    b();
  }
  
  protected void a(FrameLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView = new WatchPanelView(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.jdField_a_of_type_AndroidViewView$OnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.setLayoutParams(paramLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.setId(c());
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView);
  }
  
  public void a(bekj parambekj, QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.c(0);
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.b(this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.getResources().getString(parambekj.d()));
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.a(parambekj.a(paramQQAppInterface), 2131166972);
    }
    try
    {
      b(parambekj, paramQQAppInterface);
      label56:
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.a(parambekj.a());
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.b(parambekj.b());
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.a(parambekj.a());
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      break label56;
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 26;
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherTipsBar", 2, "destroyUI()");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.a(null);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379129));
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      if (QLog.isColorLevel()) {
        QLog.d("TogetherTipsBar", 2, "destroyBlurView called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherUiWatchPanelView.a();
    }
  }
  
  protected int c()
  {
    return 2131379128;
  }
  
  @TargetApi(19)
  protected void c()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView == null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      this.jdField_a_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("TogetherTipsBar", 2, "initBlurView called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwk
 * JD-Core Version:    0.7.0.1
 */