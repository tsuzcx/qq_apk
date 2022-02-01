import android.app.Dialog;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOJubaoDialogHelper.3;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import mqq.os.MqqHandler;

public class afom
  implements afqc, afrc
{
  Dialog jdField_a_of_type_AndroidAppDialog;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Dialog b;
  public Dialog c;
  public Dialog d;
  
  public afom(afqw paramafqw, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.mContext;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.getActivity();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.sessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    paramafqw.a(this);
  }
  
  public Dialog a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 230: 
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755826);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559016);
      localTextView1 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365556);
      localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365552);
      TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365541);
      TextView localTextView3 = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365547);
      localTextView1.setText(2131717682);
      ((TextView)localObject).setText(2131717680);
      localTextView3.setText(2131717681);
      localTextView3.setOnClickListener(new afon(this));
      localTextView2.setText(2131690620);
      localTextView2.setOnClickListener(new afoo(this));
      return this.jdField_a_of_type_AndroidAppDialog;
    case 231: 
      this.b = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755826);
      this.b.setContentView(2131558434);
      ((TextView)this.b.findViewById(2131365552)).setText(2131717683);
      return this.b;
    case 232: 
      this.c = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755826);
      this.c.setContentView(2131562884);
      localTextView1 = (TextView)this.c.findViewById(2131378381);
      localObject = (ImageView)this.c.findViewById(2131368367);
      localTextView1.setText(2131690643);
      ((ImageView)localObject).setImageResource(2130839630);
      return this.c;
    }
    this.d = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755826);
    this.d.setContentView(2131562884);
    TextView localTextView1 = (TextView)this.d.findViewById(2131378381);
    Object localObject = (ImageView)this.d.findViewById(2131368367);
    localTextView1.setText(2131690641);
    ((ImageView)localObject).setImageResource(2130839615);
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler().postDelayed(new AIOJubaoDialogHelper.3(this), 1000L);
  }
  
  public int[] a()
  {
    return new int[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afom
 * JD-Core Version:    0.7.0.1
 */