import android.content.Context;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class ager
  extends agdi
{
  protected static final String a;
  ageq jdField_a_of_type_Ageq;
  agfb jdField_a_of_type_Agfb;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new agev(this);
  protected TextView a;
  boolean b = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = ager.class.getSimpleName();
  }
  
  public ager(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    k();
    g();
    h();
    i();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365763));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ages(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    agdj localagdj = new agdj(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(localagdj);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(localagdj);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_Agfb.a("");
  }
  
  private void h()
  {
    ((ImageButton)findViewById(2131367678)).setOnClickListener(new aget(this));
  }
  
  private void i()
  {
    Button localButton = (Button)findViewById(2131363479);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new ageu(this));
  }
  
  private void j()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "loadMessageMore, currentKeyword = " + str);
    }
    this.jdField_a_of_type_Ageq.a(System.currentTimeMillis(), str, 2);
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131375735));
    this.jdField_a_of_type_Ageq = new ageq(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bfnk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Agfb = new agfb(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bfnk, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Agfb);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new agew(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new agex(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new agey(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemLongClickListener(new agez(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370876));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719087);
  }
  
  protected void a()
  {
    String str1 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "searchMessage, currentKeyword = " + str1);
    }
    if (str1.length() == 0) {}
    String str2;
    do
    {
      return;
      str2 = this.jdField_a_of_type_Ageq.a();
      if ((this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() != this.jdField_a_of_type_Ageq) || (!str1.equalsIgnoreCase(str2))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "searchMessage, skip, currentKeyword = " + str1 + ", mLastKeyword = " + str2);
    return;
    this.jdField_a_of_type_Ageq.a(System.currentTimeMillis(), str1, 1);
    a(2131690727);
  }
  
  public void dismiss()
  {
    ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    this.jdField_a_of_type_Bfnk.removeMessages(0);
    this.jdField_a_of_type_Bfnk.removeMessages(1);
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
  }
  
  void f()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "handleMessage, msg.what = " + paramMessage.what);
    }
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      c();
      continue;
      d();
      continue;
      b();
      if (this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() != this.jdField_a_of_type_Ageq) {
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ageq);
      }
      if ((paramMessage.obj instanceof List))
      {
        this.jdField_a_of_type_Ageq.a((List)paramMessage.obj, paramMessage.arg1);
        this.jdField_a_of_type_Ageq.notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Ageq.getCount() == 0)
      {
        f();
      }
      else
      {
        e();
        continue;
        if (this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() != this.jdField_a_of_type_Agfb) {
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Agfb);
        }
        this.jdField_a_of_type_Agfb.notifyDataSetChanged();
        e();
      }
    }
  }
  
  public void show()
  {
    super.show();
    this.jdField_a_of_type_Bfnk.removeMessages(0);
    this.jdField_a_of_type_Bfnk.removeMessages(1);
    this.jdField_a_of_type_Bfnk.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ager
 * JD-Core Version:    0.7.0.1
 */