import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.Observable;

public class akmd
  extends aklt
{
  private avdb a;
  private View b;
  private RelativeLayout d;
  private RelativeLayout e;
  private boolean f;
  
  public akmd(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramSessionInfo, paramQQAppInterface);
  }
  
  private void A()
  {
    if (this.d == null)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "mGroupMemberView null");
      return;
    }
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "hideGroupMemberDialog");
    this.f = false;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130840143);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840143));
    }
    if (this.e != null) {
      this.e.setVisibility(0);
    }
    this.d.setVisibility(8);
  }
  
  private float a()
  {
    Intent localIntent = ((Activity)this.jdField_a_of_type_AndroidContentContext).getIntent();
    if (localIntent != null) {}
    for (float f1 = localIntent.getFloatExtra("minaio_scaled_ration", 0.78F);; f1 = 0.78F)
    {
      if (!akmh.a()) {
        f1 = 1.0F;
      }
      return f1;
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (this.d == null)
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "mGroupMemberView null");
      return;
    }
    if ((paramInt != 1) && (paramInt != 3000))
    {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "showGroupMemberDialog with wrong uin type");
      return;
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009BE7", "0X8009BE7", 2, 0, "", "", "", "");
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "showGroupMemberDialog");
    if (this.e != null) {
      this.e.setVisibility(4);
    }
    float f1 = a();
    if (this.jdField_a_of_type_Avdb == null)
    {
      this.jdField_a_of_type_Avdb = new avdb(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_Avdb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt, f1);
      paramString = this.jdField_a_of_type_Avdb.a();
      if (paramString != null) {
        this.d.addView(paramString);
      }
    }
    this.f = true;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130840135);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840135));
    }
    this.d.setVisibility(0);
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected void c() {}
  
  protected void g()
  {
    super.g();
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.e = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376744));
      if ((this.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_Int != 3000)) {
        break label592;
      }
      if (this.e != null)
      {
        this.e.setVisibility(0);
        this.e.setOnClickListener(this);
      }
      localObject = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369056);
      if (localObject != null) {
        ((ImageView)localObject).setBackgroundResource(2130840140);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130840143);
      float f1 = a();
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130840143);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365632);
        if (this.jdField_b_of_type_AndroidViewView != null) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
        this.d = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367725));
        localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376731);
        if (localObject != null)
        {
          int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297056);
          if ((f1 > 0.0F) && (f1 <= 1.0F))
          {
            i = (int)(i / f1);
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
            if (localLayoutParams != null)
            {
              localLayoutParams.height = i;
              ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
            }
            i = (int)(16.0D / f1);
            localObject = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378936);
            if (localObject != null)
            {
              ((TextView)localObject).setTextSize(2, i);
              ((TextView)localObject).setTypeface(Typeface.defaultFromStyle(0));
              localLayoutParams = (RelativeLayout.LayoutParams)((TextView)localObject).getLayoutParams();
              localLayoutParams.setMargins((int)(localLayoutParams.leftMargin / f1), (int)(localLayoutParams.topMargin / f1), (int)(localLayoutParams.rightMargin / f1), (int)(localLayoutParams.bottomMargin / f1));
              ((TextView)localObject).setLayoutParams(localLayoutParams);
            }
            localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369042);
            if (localObject != null)
            {
              localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
              if (localLayoutParams != null)
              {
                localLayoutParams.height = ((int)(localLayoutParams.height / f1));
                localLayoutParams.width = ((int)(localLayoutParams.width / f1));
                ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
              }
            }
            localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131368451);
            if (localObject != null)
            {
              localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
              if (localLayoutParams != null)
              {
                localLayoutParams.height = ((int)(localLayoutParams.height / f1));
                localLayoutParams.width = ((int)(localLayoutParams.width / f1));
                localLayoutParams.setMargins((int)(localLayoutParams.leftMargin / f1), (int)(localLayoutParams.topMargin / f1), (int)(localLayoutParams.rightMargin / f1), (int)(localLayoutParams.bottomMargin / f1));
                ((ImageView)localObject).setLayoutParams(localLayoutParams);
              }
            }
            localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369056);
            if (localObject != null)
            {
              localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
              if (localLayoutParams != null)
              {
                i = agej.a(18.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
                localLayoutParams.height = ((int)(i / f1));
                localLayoutParams.width = ((int)(i / f1));
                ((ImageView)localObject).setLayoutParams(localLayoutParams);
              }
            }
          }
        }
      }
      return;
      label592:
      if (this.e != null) {
        this.e.setVisibility(4);
      }
    }
  }
  
  protected void h()
  {
    super.h();
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int);
      continue;
      r();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Akkv.a(19);
  }
  
  public void r()
  {
    if (this.f)
    {
      A();
      return;
    }
    QLog.i(this.jdField_a_of_type_JavaLangString, 2, "doOnFinish");
    if (this.d != null)
    {
      this.d.removeAllViews();
      if (this.jdField_a_of_type_Avdb != null)
      {
        this.jdField_a_of_type_Avdb.a();
        this.jdField_a_of_type_Avdb = null;
      }
    }
    super.r();
    ((Activity)this.jdField_a_of_type_AndroidContentContext).overridePendingTransition(0, 0);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, getClass().getSimpleName() + " update");
    }
    if ((paramObject instanceof aday))
    {
      paramObservable = (aday)paramObject;
      paramObject = (aggv)paramObservable.a;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject.a())))
      {
        if ((this.jdField_a_of_type_Long != paramObject.a()) || (!paramObservable.h) || (!paramObservable.d)) {
          break label146;
        }
        l = this.jdField_a_of_type_Long + 300L - SystemClock.uptimeMillis();
        if (l <= 0L) {
          break label141;
        }
        a(131076, l);
      }
    }
    label141:
    label146:
    while (!QLog.isColorLevel())
    {
      do
      {
        for (;;)
        {
          return;
          long l = 0L;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "refreshMessageContext sync theSameUinAIO return");
      return;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "update--> do nothing");
  }
  
  protected void w()
  {
    ImageButton localImageButton = (ImageButton)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362374);
    if (localImageButton != null) {
      localImageButton.setVisibility(8);
    }
  }
  
  public void x() {}
  
  protected void y()
  {
    this.jdField_a_of_type_JavaLangString = "MiniPieForForward";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmd
 * JD-Core Version:    0.7.0.1
 */