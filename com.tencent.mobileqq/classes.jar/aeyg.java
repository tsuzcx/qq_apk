import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ui.MusicPanelView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;

public class aeyg
  extends aeyy
{
  MusicPanelView a;
  
  public aeyg(BaseChatPie paramBaseChatPie, View.OnClickListener paramOnClickListener)
  {
    super(paramBaseChatPie, paramOnClickListener);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView;
  }
  
  public View a(Object... paramVarArgs)
  {
    return super.a(paramVarArgs);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377529));
    c();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherTipBar", 2, "showBlurView() called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
    }
    QLog.d("ListenTogetherTipBar", 1, new Object[] { "stack......\n", Log.getStackTraceString(new Throwable()) });
    if (aylu.a().c()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
    }
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371154);
      if ((!ThemeUtil.isDefaultOrDIYTheme(false)) && (!ThemeUtil.isSimpleDayTheme(false))) {
        break;
      }
      localView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    } while (!QLog.isColorLevel());
    QLog.d("ListenTogetherTipBar", 2, "showBlurView() visibility called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
    return;
    localView.setBackgroundColor(this.jdField_a_of_type_AndroidViewViewGroup.getResources().getColor(2131166829));
    localView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherTipBar", 2, "showBlurView() gone called mBlurBgView = " + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView)));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = null;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    super.a(paramInt, paramVarArgs);
  }
  
  protected void a(FrameLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView = new MusicPanelView(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.setLayoutParams(paramLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.setId(c());
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.jdField_a_of_type_AndroidViewView$OnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView.setOnTouchListener(muc.a);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView);
  }
  
  public void a(ayno paramayno, QQAppInterface paramQQAppInterface)
  {
    super.a(paramayno, paramQQAppInterface);
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
    super.b();
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiMusicPanelView != null) {}
  }
  
  public int c()
  {
    return 2131369316;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeyg
 * JD-Core Version:    0.7.0.1
 */