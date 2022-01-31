import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.MultiWindowAIOHelper.1;
import com.tencent.mobileqq.activity.aio.helper.MultiWindowAIOHelper.3;
import com.tencent.mobileqq.activity.aio.helper.MultiWindowAIOHelper.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;

public class adis
  implements adih
{
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private Runnable jdField_a_of_type_JavaLangRunnable = new MultiWindowAIOHelper.1(this);
  
  public adis(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private int a()
  {
    aspw localaspw = a();
    if (localaspw == null) {
      return -1;
    }
    return localaspw.c();
  }
  
  private aspw a()
  {
    BaseActivity localBaseActivity = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing())) {}
    int i;
    do
    {
      return null;
      i = localBaseActivity.getIntent().getIntExtra("KEY_MULTI_WINDOW_AIO_CONTEXT_ID", -1);
    } while (i == -1);
    return ((aspv)localBaseActivity.app.getManager(325)).b(i);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "onShowFirst() called");
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "onCreate() called");
    }
    Object localObject = a();
    if ((localObject != null) && (((aspw)localObject).a()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      if (localObject != null) {
        ((ChatXListView)localObject).setOnLayoutListener(new adit(this));
      }
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "onStart() called");
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "onResume() called");
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "onShow() called");
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void i() {}
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "tryRestoreListViewState() called");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acut;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((acut)localObject1).a();
      i = a();
      if ((localObject1 != null) && (((List)localObject1).size() == i))
      {
        localObject1 = a();
        if ((localObject1 != null) && (((aspw)localObject1).a()))
        {
          localObject2 = ((aspw)localObject1).a();
          if (localObject2 != null)
          {
            localObject2 = ((asqa)localObject2).a();
            if (localObject2 != null) {
              break label100;
            }
            QLog.e("MultiWindowAIOHelper", 1, "tryRestoreListViewState: listView == null");
          }
        }
      }
    }
    return;
    label100:
    int i = ((ListView)localObject2).getLastVisiblePosition();
    View localView = ((ListView)localObject2).getChildAt(((ListView)localObject2).getChildCount() - 1);
    int j = ((ListView)localObject2).getBottom() - localView.getBottom();
    if (QLog.isColorLevel()) {
      QLog.d("MultiWindowAIOHelper", 2, "tryRestoreListViewState() anchorPosition = " + i + ", specifyBottom = " + j);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnLayoutListener(null);
    this.jdField_a_of_type_AndroidOsHandler.post(new MultiWindowAIOHelper.3(this, i, j));
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new MultiWindowAIOHelper.4(this, (aspw)localObject1), 350L);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acut != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_Acut.d();
    }
    long l = SystemClock.elapsedRealtime();
    if (l - this.jdField_a_of_type_Long >= 1000L)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300L);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("MultiWindowAIOHelper", 2, "AIO start multi window!  but list idle time lower 2s!  please wait... dif time = " + (l - this.jdField_a_of_type_Long));
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 9: 
    case 10: 
    case 12: 
    case 13: 
    default: 
      return;
    case 2: 
      d();
      return;
    case 3: 
      e();
      return;
    case 4: 
      f();
    case 6: 
      c();
      return;
    case 7: 
      g();
      return;
    case 8: 
      h();
      return;
    case 11: 
      i();
      return;
    }
    b();
  }
  
  public int[] a()
  {
    return new int[] { 2, 4, 6, 7, 8, 11, 14 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adis
 * JD-Core Version:    0.7.0.1
 */