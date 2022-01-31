import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contacts.view.SimpleSlidingIndicator;
import com.tencent.mobileqq.activity.history.ChatHistoryBaseFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryViewPagerAdapter;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FadeIconImageView;

public class ahvn
  extends ahtz
  implements ahqz, View.OnClickListener
{
  int jdField_a_of_type_Int;
  ahwh jdField_a_of_type_Ahwh;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator;
  ChatHistoryViewPagerAdapter jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter;
  QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  FadeIconImageView jdField_a_of_type_ComTencentWidgetFadeIconImageView;
  int b = -1;
  public int c = 0;
  
  public ahvn(FragmentActivity paramFragmentActivity)
  {
    super(paramFragmentActivity);
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.history.CommonViewController", 2, "onPageChange. position:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter.a(paramInt, this.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setCurrentPosition(paramInt, true);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.history.CommonViewController", 2, "switchToTabPos mCurrentTabPos:" + this.jdField_a_of_type_Int + "  pos:" + paramInt);
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setCurrentPosition(this.jdField_a_of_type_Int, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(this.jdField_a_of_type_Int, false);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Ahwh.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int];
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.history.CommonViewController", 2, "onContactTabChange. position:" + paramInt + " fromUserClick:" + paramBoolean);
    }
    this.b = this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setCurrentItem(paramInt, false);
    return 0;
  }
  
  public ChatHistoryBaseFragment a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter.a(this.jdField_a_of_type_Int, false);
    }
    return null;
  }
  
  public void a()
  {
    super.a();
    a(2131368613).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131368644));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView = ((FadeIconImageView)a(2131368612));
    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator = ((SimpleSlidingIndicator)a(2131376786));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)a(2131364127));
    this.jdField_a_of_type_Ahwh = new ahwh();
    int[] arrayOfInt1 = a();
    int[] arrayOfInt2 = b();
    if ((arrayOfInt1 != null) && (arrayOfInt2 != null))
    {
      this.jdField_a_of_type_Ahwh.a(a(), arrayOfInt1, arrayOfInt2);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setTabData(this.jdField_a_of_type_Ahwh.jdField_a_of_type_ArrayOfJavaLangString, arrayOfInt1);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setOnTabListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter = new ChatHistoryViewPagerAdapter(a(), a(), this, this.jdField_a_of_type_Ahwh, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter);
    if (arrayOfInt1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOffscreenPageLimit(arrayOfInt1.length);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setOnPageChangeListener(new ahvo(this));
    c(0);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1600: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
      return;
    case 1601: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(0);
      return;
    case 1602: 
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690047);
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
      this.c = 1;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690648);
    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
    this.c = 2;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    ChatHistoryBaseFragment localChatHistoryBaseFragment = a();
    if (localChatHistoryBaseFragment != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.CommonViewController", 2, "onActivityResult, cur Fragment = " + localChatHistoryBaseFragment.getClass().getName());
      }
      localChatHistoryBaseFragment.a(paramInt1, paramInt2, paramIntent);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.history.CommonViewController", 2, "onActivityResult, cur Fragment is null ");
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
    }
  }
  
  protected int[] a()
  {
    return null;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
  }
  
  protected int[] b()
  {
    return null;
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.getCurrentItem());
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryViewPagerAdapter.a();
  }
  
  public void e()
  {
    if (this.c == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690047);
      this.c = 1;
      if (this.jdField_a_of_type_Ahwg != null) {
        this.jdField_a_of_type_Ahwg.c();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
        return;
        if (this.c == 1)
        {
          if (this.jdField_a_of_type_Ahwg != null) {
            this.jdField_a_of_type_Ahwg.b();
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690648);
          this.c = 2;
          return;
        }
      } while (this.c != 2);
      if (this.jdField_a_of_type_Ahwg != null) {
        this.jdField_a_of_type_Ahwg.c();
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690047);
      this.c = 1;
      return;
    } while (this.jdField_a_of_type_Ahwg == null);
    this.jdField_a_of_type_Ahwg.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahvn
 * JD-Core Version:    0.7.0.1
 */