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

public class afsg
  extends afrv
  implements afrx, Handler.Callback, View.OnClickListener
{
  public afry a;
  protected afsh a;
  public final bfob a;
  protected boolean a;
  protected boolean b;
  
  public afsg(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bfob = new bfob(Looper.getMainLooper(), this);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_Afry = ((afry)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(295));
      this.jdField_a_of_type_Afry.a(this);
      this.jdField_a_of_type_Afry.a(true);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Afry != null) {
      this.jdField_a_of_type_Afry.b(this);
    }
    this.jdField_a_of_type_Afry = null;
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryController", 2, "onMayknowEntryClosed");
    }
    this.jdField_a_of_type_Afry.a();
    ContactReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "banner_recomlist_dlt");
  }
  
  public void a()
  {
    a(200L);
  }
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "refreshData  hasdata:" + this.jdField_a_of_type_Bfob.hasMessages(2) + " mHasPaused:" + this.b);
    }
    if (this.b) {}
    while (this.jdField_a_of_type_Bfob.hasMessages(2)) {
      return;
    }
    this.jdField_a_of_type_Bfob.sendEmptyMessageDelayed(2, paramLong);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.jdField_a_of_type_Afsh = new afsh(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afsh);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131706486));
    this.jdField_a_of_type_ComTencentWidgetAlphaClickableRelativeLayout.setOnClickListener(this);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    super.a(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      if (this.jdField_a_of_type_Afsh != null) {
        this.jdField_a_of_type_Afsh.a(paramQQAppInterface);
      }
    }
    f();
    a(50L);
    paramQQAppInterface = this.jdField_a_of_type_Afry.a();
    if (paramQQAppInterface != null) {
      paramQQAppInterface.b();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "onResume");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.b)
    {
      if (this.jdField_a_of_type_Afsh != null) {
        this.jdField_a_of_type_Afsh.notifyDataSetChanged();
      }
      a(500L);
      this.jdField_a_of_type_Bfob.sendEmptyMessageDelayed(3, 500L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Afsh != null) {
        this.jdField_a_of_type_Afsh.d();
      }
      this.b = false;
      return;
      a(0L);
      afpy localafpy = this.jdField_a_of_type_Afry.a();
      if (localafpy != null) {
        localafpy.b();
      }
    }
  }
  
  public void b()
  {
    super.b();
    f();
  }
  
  public void c()
  {
    super.c();
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "onPause");
    }
    if (this.jdField_a_of_type_Afsh != null) {
      this.jdField_a_of_type_Afsh.b();
    }
    this.b = true;
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Afsh != null) {
      this.jdField_a_of_type_Afsh.a(paramBoolean);
    }
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryController", 2, "onDestroy");
    }
    if (this.jdField_a_of_type_Bfob != null) {
      this.jdField_a_of_type_Bfob.removeCallbacksAndMessages(null);
    }
    g();
    this.jdField_a_of_type_Afrw = null;
    if (this.jdField_a_of_type_Afsh != null) {
      this.jdField_a_of_type_Afsh.a();
    }
  }
  
  public void e()
  {
    super.e();
    g();
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_Afsh != null) {
      this.jdField_a_of_type_Afsh.a();
    }
    this.jdField_a_of_type_Afsh = null;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j;
    Object localObject1;
    boolean bool;
    int i;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      this.jdField_a_of_type_Bfob.removeMessages(1);
      paramMessage = (List)paramMessage.obj;
      if (this.jdField_a_of_type_Afsh == null)
      {
        this.jdField_a_of_type_Afsh = new afsh(a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXListView, 1, true);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afsh);
      }
      j = this.jdField_a_of_type_Afsh.getCount();
      localObject1 = paramMessage.iterator();
      bool = false;
      i = 0;
      label114:
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (afru)((Iterator)localObject1).next();
        if ((localObject2 == null) || (((afru)localObject2).jdField_a_of_type_Int != 3)) {
          break label530;
        }
        bool = ((afru)localObject2).e;
        if ((bool) || (((afru)localObject2).jdField_a_of_type_JavaLangObject == null) || (!(((afru)localObject2).jdField_a_of_type_JavaLangObject instanceof List))) {
          break label527;
        }
        localObject2 = (List)((afru)localObject2).jdField_a_of_type_JavaLangObject;
        if (((List)localObject2).size() <= 0) {
          break label527;
        }
        this.jdField_a_of_type_Afsh.a((List)localObject2);
        i = ((List)localObject2).size();
      }
      break;
    }
    label527:
    label530:
    for (;;)
    {
      break label114;
      if (QLog.isColorLevel()) {
        QLog.d("CTEntryController", 2, "MSG_UPDATE_ENTRY_LIST preCount:" + j + " size:" + i + " userClose:" + bool);
      }
      if (i > 0)
      {
        localObject1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).height = actj.a(i * 60 + 28, this.jdField_a_of_type_AndroidWidgetFrameLayout.getResources());
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
            localObject1 = (afru)paramMessage.next();
            axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800979E", "0X800979E", ((afru)localObject1).jdField_a_of_type_Int, 0, "", "", "", "");
            continue;
            this.jdField_a_of_type_Afsh.a(null);
            this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
            if ((j > 0) && (!bool)) {
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
      if (this.jdField_a_of_type_Afrw == null) {
        break;
      }
      this.jdField_a_of_type_Afrw.a();
      return false;
      this.jdField_a_of_type_Bfob.removeMessages(2);
      ThreadManager.excute(new MayKnowPersonEntryController.1(this), 16, null, true);
      return false;
      if (this.jdField_a_of_type_Afry == null) {
        break;
      }
      paramMessage = this.jdField_a_of_type_Afry.a();
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
    if (paramView.getId() == 2131374961)
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, RecommendFriendActivity.class);
      localIntent.putExtra("EntranceId", 8);
      if (this.jdField_a_of_type_Afry != null) {
        break label90;
      }
    }
    label90:
    for (paramView = null;; paramView = this.jdField_a_of_type_Afry.a())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afsg
 * JD-Core Version:    0.7.0.1
 */