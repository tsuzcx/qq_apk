import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.NumberWheelView;
import com.tencent.mobileqq.app.utils.TimeWheelPanel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.VerticalGallery;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

public class afbt
  extends ReportDialog
  implements DialogInterface.OnCancelListener, DialogInterface.OnShowListener, View.OnClickListener, apea
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TimeWheelPanel jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private TextView c;
  
  public afbt(Context paramContext, QQAppInterface paramQQAppInterface, FormSwitchSimpleItem paramFormSwitchSimpleItem, FormSimpleItem paramFormSimpleItem, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    super(paramContext, 2131755413);
    requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = paramFormSwitchSimpleItem;
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = paramFormSimpleItem;
    this.c = paramFormSimpleItem.a();
    this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = paramOnCheckedChangeListener;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131561098, null);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    paramContext = getWindow();
    paramQQAppInterface = paramContext.getAttributes();
    paramQQAppInterface.width = -1;
    paramQQAppInterface.height = -2;
    paramQQAppInterface.gravity = 81;
    paramContext.setAttributes(paramQQAppInterface);
    paramContext.setWindowAnimations(2131755414);
    paramContext.setFlags(16777216, 16777216);
    setCancelable(true);
    setCanceledOnTouchOutside(true);
    a();
  }
  
  public static String a(long paramLong)
  {
    return a(paramLong, false);
  }
  
  public static String a(long paramLong, boolean paramBoolean)
  {
    boolean bool = DateFormat.is24HourFormat(BaseApplication.getContext());
    paramLong = System.currentTimeMillis() + paramLong;
    if ((!bool) && (!paramBoolean))
    {
      String str = new SimpleDateFormat("hh:mm").format(new Date(paramLong));
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramLong);
      if (localCalendar.get(9) == 0) {
        return anzj.a(2131706526) + str;
      }
      return anzj.a(2131706535) + str;
    }
    return new SimpleDateFormat("HH:mm").format(new Date(paramLong));
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel = ((TimeWheelPanel)this.jdField_a_of_type_AndroidViewView.findViewById(2131372263));
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a(0, 24, 60, 0);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a(true);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.setViewVisibility(0, 8);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.setViewVisibility(3, 0);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.setScrollerStateListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364172));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getContext().getResources().getColor(2131167025));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364970));
    this.b.setTextColor(getContext().getResources().getColor(2131167031));
    this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
    this.b.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
    this.b.setFocusable(true);
    this.b.setEnabled(false);
    this.b.setTextColor(getContext().getResources().getColor(2131167204));
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      String str1 = anzj.a(2131706525);
      String str2 = anzj.a(2131706524);
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(str1);
      this.b.setContentDescription(str2);
    }
    a(null, null);
    setOnCancelListener(this);
  }
  
  private void a(AtomicBoolean paramAtomicBoolean)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = paramAtomicBoolean;
  }
  
  public void a(long paramLong)
  {
    long l = paramLong;
    if ((int)paramLong % 86400 % 3600 % 60 != 0) {
      l = paramLong + 60L;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a = ((int)l / 86400);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.b = ((int)l % 86400 / 3600);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.c = ((int)l % 86400 % 3600 / 60);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.setValues(true);
    String str1 = anzj.a(2131706528) + a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a() * 1000);
    String str2 = anzj.a(2131706540) + a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a() * 1000, true);
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.setEndTime(str1, str2);
  }
  
  public void a(NumberWheelView paramNumberWheelView, VerticalGallery paramVerticalGallery)
  {
    if (paramNumberWheelView != null) {
      this.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a() == 0)
    {
      this.b.setEnabled(false);
      this.b.setTextColor(getContext().getResources().getColor(2131167204));
    }
    for (;;)
    {
      paramNumberWheelView = anzj.a(2131706519) + a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a() * 1000);
      paramVerticalGallery = anzj.a(2131706538) + a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a() * 1000, true);
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.setEndTime(paramNumberWheelView, paramVerticalGallery);
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.b.setEnabled(true);
        this.b.setTextColor(getContext().getResources().getColor(2131167273));
      }
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a(0, 24, 60, 0);
    a(null, null);
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
      dismiss();
      onCancel(null);
      continue;
      dismiss();
      long l1 = this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a() / 60;
      String str = anzj.a(2131706539) + a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a() * 1000);
      this.c.setText(str);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      long l2 = NetConnInfoCenter.getServerTime();
      long l3 = this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a();
      ((anum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a((int)(l3 + l2), "", "not_disturb_from_notify_push_setting_activity");
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsTimeWheelPanel.a(0, 24, 60, 0);
      a(null, null);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8009DD2", "0X8009DD2", 0, 1, l1 + "", "0", "", "");
    }
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbt
 * JD-Core Version:    0.7.0.1
 */