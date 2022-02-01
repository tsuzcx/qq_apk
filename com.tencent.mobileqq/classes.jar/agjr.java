import android.app.Dialog;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIOJubaoDialogHelper.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import mqq.os.MqqHandler;

public class agjr
  implements agld, agma
{
  Dialog jdField_a_of_type_AndroidAppDialog;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private final SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Dialog b;
  public Dialog c;
  public Dialog d;
  
  public agjr(aglu paramaglu, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    paramaglu.a(this);
  }
  
  public Dialog a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 230: 
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755823);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559009);
      localTextView1 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365479);
      localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365475);
      TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365464);
      TextView localTextView3 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365470);
      localTextView1.setText(2131717322);
      ((TextView)localObject).setText(2131717320);
      localTextView3.setText(2131717321);
      localTextView3.setOnClickListener(new agjs(this));
      localTextView2.setText(2131690582);
      localTextView2.setOnClickListener(new agjt(this));
      return this.jdField_a_of_type_AndroidAppDialog;
    case 231: 
      this.b = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755823);
      this.b.setContentView(2131558434);
      ((TextView)this.b.findViewById(2131365475)).setText(2131717323);
      return this.b;
    case 232: 
      this.c = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755823);
      this.c.setContentView(2131562970);
      localTextView1 = (TextView)this.c.findViewById(2131378459);
      localObject = (ImageView)this.c.findViewById(2131368269);
      localTextView1.setText(2131690605);
      ((ImageView)localObject).setImageResource(2130839584);
      return this.c;
    }
    this.d = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755823);
    this.d.setContentView(2131562970);
    TextView localTextView1 = (TextView)this.d.findViewById(2131378459);
    Object localObject = (ImageView)this.d.findViewById(2131368269);
    localTextView1.setText(2131690603);
    ((ImageView)localObject).setImageResource(2130839571);
    return this.d;
  }
  
  public void a()
  {
    if ((this.b != null) && (this.b.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.dismissDialog(231);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().postDelayed(new AIOJubaoDialogHelper.3(this), 1000L);
  }
  
  public int[] a()
  {
    return new int[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjr
 * JD-Core Version:    0.7.0.1
 */