import android.app.Activity;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryController.1;
import com.tencent.mobileqq.activity.contacts.utils.ContactReportUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ahpy
  extends ahpm
  implements ahpp, Handler.Callback, View.OnClickListener
{
  public ahpq a;
  protected ahpz a;
  public final bhow a;
  protected boolean a;
  protected boolean b;
  
  public ahpy(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bhow = new bhow(Looper.getMainLooper(), this);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_Ahpq = ((ahpq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(295));
      this.jdField_a_of_type_Ahpq.a(this);
      this.jdField_a_of_type_Ahpq.a(true);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Ahpq != null) {
      this.jdField_a_of_type_Ahpq.b(this);
    }
    this.jdField_a_of_type_Ahpq = null;
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryController", 2, "onMayknowEntryClosed");
    }
    this.jdField_a_of_type_Ahpq.a();
    ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "banner_recomlist_dlt");
  }
  
  public void a()
  {
    a(200L);
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "refreshData  hasdata:" + this.jdField_a_of_type_Bhow.hasMessages(2) + " mHasPaused:" + this.b);
    }
    if (this.b) {}
    while (this.jdField_a_of_type_Bhow.hasMessages(2)) {
      return;
    }
    this.jdField_a_of_type_Bhow.sendEmptyMessageDelayed(2, paramLong);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_Ahpz = new ahpz(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ahpz);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alpo.a(2131706858));
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setOnClickListener(this);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      if (this.jdField_a_of_type_Ahpz != null) {
        this.jdField_a_of_type_Ahpz.a(paramQQAppInterface);
      }
    }
    f();
    a(50L);
    paramQQAppInterface = this.jdField_a_of_type_Ahpq.a();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ahpz != null) {
      this.jdField_a_of_type_Ahpz.a(paramBoolean);
    }
  }
  
  public void b()
  {
    super.b();
    f();
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "onResume");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.b)
    {
      if (this.jdField_a_of_type_Ahpz != null) {
        this.jdField_a_of_type_Ahpz.notifyDataSetChanged();
      }
      a(500L);
      this.jdField_a_of_type_Bhow.sendEmptyMessageDelayed(3, 500L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ahpz != null) {
        this.jdField_a_of_type_Ahpz.d();
      }
      this.b = false;
      return;
      a(0L);
      ahnp localahnp = this.jdField_a_of_type_Ahpq.a();
      if (localahnp != null) {
        localahnp.b();
      }
    }
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "onPause");
    }
    if (this.jdField_a_of_type_Ahpz != null) {
      this.jdField_a_of_type_Ahpz.b();
    }
    this.b = true;
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_Bhow != null) {
      this.jdField_a_of_type_Bhow.removeCallbacksAndMessages(null);
    }
    g();
    this.jdField_a_of_type_Ahpo = null;
    if (this.jdField_a_of_type_Ahpz != null) {
      this.jdField_a_of_type_Ahpz.a();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    a(0L);
  }
  
  public void e()
  {
    super.e();
    g();
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_Ahpz != null) {
      this.jdField_a_of_type_Ahpz.a();
    }
    this.jdField_a_of_type_Ahpz = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j;
    boolean bool2;
    Object localObject1;
    boolean bool1;
    int i;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      this.jdField_a_of_type_Bhow.removeMessages(1);
      paramMessage = (List)paramMessage.obj;
      if (this.jdField_a_of_type_Ahpz == null)
      {
        this.jdField_a_of_type_Ahpz = new ahpz(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ahpz);
      }
      j = this.jdField_a_of_type_Ahpz.getCount();
      bool2 = a();
      localObject1 = paramMessage.iterator();
      bool1 = false;
      i = 0;
      label120:
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ahpl)((Iterator)localObject1).next();
        if ((localObject2 == null) || (((ahpl)localObject2).jdField_a_of_type_Int != 3) || (!bool2)) {
          break label544;
        }
        bool1 = ((ahpl)localObject2).e;
        if ((bool1) || (!(((ahpl)localObject2).jdField_a_of_type_JavaLangObject instanceof List))) {
          break label541;
        }
        localObject2 = (List)((ahpl)localObject2).jdField_a_of_type_JavaLangObject;
        if (((List)localObject2).size() <= 0) {
          break label541;
        }
        this.jdField_a_of_type_Ahpz.a((List)localObject2);
        i = ((List)localObject2).size();
      }
      break;
    }
    label541:
    label544:
    for (;;)
    {
      break label120;
      if (QLog.isColorLevel()) {
        QLog.d("CTEntryController", 2, "MSG_UPDATE_ENTRY_LIST preCount:" + j + " size:" + i + " userClose:" + bool1 + " shouldShowRecommendEntry: " + bool2);
      }
      if (i > 0)
      {
        localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = aekt.a(i * 60 + 28, this.jdField_a_of_type_AndroidWidgetFrameLayout.getResources());
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        i = 1;
      }
      while (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        paramMessage = paramMessage.iterator();
        for (;;)
        {
          if (paramMessage.hasNext())
          {
            localObject1 = (ahpl)paramMessage.next();
            azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800979E", "0X800979E", ((ahpl)localObject1).jdField_a_of_type_Int, 0, "", "", "", "");
            continue;
            this.jdField_a_of_type_Ahpz.a(null);
            this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
            if ((j > 0) && (!bool1)) {
              h();
            }
            i = 0;
            break;
          }
        }
        if (i != 0) {
          ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "banner_recomlist_exp");
        }
      }
      if (this.jdField_a_of_type_Ahpo == null) {
        break;
      }
      this.jdField_a_of_type_Ahpo.a();
      return false;
      this.jdField_a_of_type_Bhow.removeMessages(2);
      ThreadManager.excute(new MayKnowPersonEntryController.1(this), 16, null, true);
      return false;
      if (this.jdField_a_of_type_Ahpq == null) {
        break;
      }
      paramMessage = this.jdField_a_of_type_Ahpq.a();
      if (paramMessage == null) {
        break;
      }
      paramMessage.b();
      return false;
    }
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    if (paramView.getId() == 2131375431)
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, RecommendFriendActivity.class);
      localIntent.putExtra("EntranceId", 8);
      if (this.jdField_a_of_type_Ahpq != null) {
        break label90;
      }
    }
    label90:
    for (paramView = null;; paramView = this.jdField_a_of_type_Ahpq.a())
    {
      if (paramView != null)
      {
        paramView = paramView.a();
        if (!paramView.isEmpty()) {
          localIntent.putExtra("may_know_recmmds", paramView);
        }
      }
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "banner_recomlist_clk");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpy
 * JD-Core Version:    0.7.0.1
 */