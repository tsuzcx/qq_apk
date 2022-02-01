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

public class agss
  implements ague, agvc
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
  
  public agss(aguw paramaguw, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    paramaguw.a(this);
  }
  
  public Dialog a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 230: 
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755824);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559008);
      localTextView1 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365523);
      localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365519);
      TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365508);
      TextView localTextView3 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365514);
      localTextView1.setText(2131717450);
      ((TextView)localObject).setText(2131717448);
      localTextView3.setText(2131717449);
      localTextView3.setOnClickListener(new agst(this));
      localTextView2.setText(2131690580);
      localTextView2.setOnClickListener(new agsu(this));
      return this.jdField_a_of_type_AndroidAppDialog;
    case 231: 
      this.b = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755824);
      this.b.setContentView(2131558434);
      ((TextView)this.b.findViewById(2131365519)).setText(2131717451);
      return this.b;
    case 232: 
      this.c = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755824);
      this.c.setContentView(2131563004);
      localTextView1 = (TextView)this.c.findViewById(2131378617);
      localObject = (ImageView)this.c.findViewById(2131368343);
      localTextView1.setText(2131690603);
      ((ImageView)localObject).setImageResource(2130839593);
      return this.c;
    }
    this.d = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755824);
    this.d.setContentView(2131563004);
    TextView localTextView1 = (TextView)this.d.findViewById(2131378617);
    Object localObject = (ImageView)this.d.findViewById(2131368343);
    localTextView1.setText(2131690601);
    ((ImageView)localObject).setImageResource(2130839580);
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
 * Qualified Name:     agss
 * JD-Core Version:    0.7.0.1
 */