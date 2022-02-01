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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryController.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.XListView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ajnl
  extends ajmu
  implements ajmx, Handler.Callback, View.OnClickListener
{
  public ajmy a;
  protected ajnm a;
  public final bkys a;
  protected boolean a;
  protected boolean b;
  
  public ajnl(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bkys = new bkys(Looper.getMainLooper(), this);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_Ajmy = ((ajmy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG));
      this.jdField_a_of_type_Ajmy.a(this);
      this.jdField_a_of_type_Ajmy.a(true);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Ajmy != null) {
      this.jdField_a_of_type_Ajmy.b(this);
    }
    this.jdField_a_of_type_Ajmy = null;
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryController", 2, "onMayknowEntryClosed");
    }
    this.jdField_a_of_type_Ajmy.a();
    ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "banner_recomlist_dlt");
  }
  
  public void a()
  {
    a(200L);
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "refreshData  hasdata:" + this.jdField_a_of_type_Bkys.hasMessages(2) + " mHasPaused:" + this.b);
    }
    if (this.b) {}
    while (this.jdField_a_of_type_Bkys.hasMessages(2)) {
      return;
    }
    this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(2, paramLong);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_Ajnm = new ajnm(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ajnm);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131705949));
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setOnClickListener(this);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      if (this.jdField_a_of_type_Ajnm != null) {
        this.jdField_a_of_type_Ajnm.a(paramQQAppInterface);
      }
    }
    f();
    a(50L);
    paramQQAppInterface = this.jdField_a_of_type_Ajmy.a();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ajnm != null) {
      this.jdField_a_of_type_Ajnm.a(paramBoolean);
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
      if (this.jdField_a_of_type_Ajnm != null) {
        this.jdField_a_of_type_Ajnm.notifyDataSetChanged();
      }
      a(500L);
      this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(3, 500L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ajnm != null) {
        this.jdField_a_of_type_Ajnm.d();
      }
      this.b = false;
      return;
      a(0L);
      ajnh localajnh = this.jdField_a_of_type_Ajmy.a();
      if (localajnh != null) {
        localajnh.b();
      }
    }
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "onPause");
    }
    if (this.jdField_a_of_type_Ajnm != null) {
      this.jdField_a_of_type_Ajnm.b();
    }
    this.b = true;
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_Bkys != null) {
      this.jdField_a_of_type_Bkys.removeCallbacksAndMessages(null);
    }
    g();
    this.jdField_a_of_type_Ajmw = null;
    if (this.jdField_a_of_type_Ajnm != null) {
      this.jdField_a_of_type_Ajnm.a();
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
    if (this.jdField_a_of_type_Ajnm != null) {
      this.jdField_a_of_type_Ajnm.a();
    }
    this.jdField_a_of_type_Ajnm = null;
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
      this.jdField_a_of_type_Bkys.removeMessages(1);
      paramMessage = (List)paramMessage.obj;
      if (this.jdField_a_of_type_Ajnm == null)
      {
        this.jdField_a_of_type_Ajnm = new ajnm(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ajnm);
      }
      j = this.jdField_a_of_type_Ajnm.getCount();
      bool2 = a();
      localObject1 = paramMessage.iterator();
      bool1 = false;
      i = 0;
      label120:
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ajmt)((Iterator)localObject1).next();
        if ((localObject2 == null) || (((ajmt)localObject2).jdField_a_of_type_Int != 3) || (!bool2)) {
          break label544;
        }
        bool1 = ((ajmt)localObject2).e;
        if ((bool1) || (!(((ajmt)localObject2).jdField_a_of_type_JavaLangObject instanceof List))) {
          break label541;
        }
        localObject2 = (List)((ajmt)localObject2).jdField_a_of_type_JavaLangObject;
        if (((List)localObject2).size() <= 0) {
          break label541;
        }
        this.jdField_a_of_type_Ajnm.a((List)localObject2);
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
        ((LinearLayout.LayoutParams)localObject1).height = AIOUtils.dp2px(i * 60 + 28, this.jdField_a_of_type_AndroidWidgetFrameLayout.getResources());
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
            localObject1 = (ajmt)paramMessage.next();
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800979E", "0X800979E", ((ajmt)localObject1).jdField_a_of_type_Int, 0, "", "", "", "");
            continue;
            this.jdField_a_of_type_Ajnm.a(null);
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
      if (this.jdField_a_of_type_Ajmw == null) {
        break;
      }
      this.jdField_a_of_type_Ajmw.a();
      return false;
      this.jdField_a_of_type_Bkys.removeMessages(2);
      ThreadManager.excute(new MayKnowPersonEntryController.1(this), 16, null, true);
      return false;
      if (this.jdField_a_of_type_Ajmy == null) {
        break;
      }
      paramMessage = this.jdField_a_of_type_Ajmy.a();
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
    if (paramView.getId() == 2131376360)
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, RecommendFriendActivity.class);
      localIntent.putExtra("EntranceId", 8);
      if (this.jdField_a_of_type_Ajmy != null) {
        break label97;
      }
    }
    label97:
    for (Object localObject = null;; localObject = this.jdField_a_of_type_Ajmy.a())
    {
      if (localObject != null)
      {
        localObject = ((ajnh)localObject).a();
        if (!((ArrayList)localObject).isEmpty()) {
          localIntent.putExtra("may_know_recmmds", (Serializable)localObject);
        }
      }
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "banner_recomlist_clk");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajnl
 * JD-Core Version:    0.7.0.1
 */