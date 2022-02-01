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

public class akda
  extends akbr
{
  protected static final String a;
  akcz jdField_a_of_type_Akcz;
  akdk jdField_a_of_type_Akdk;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new akde(this);
  protected TextView a;
  boolean b = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = akda.class.getSimpleName();
  }
  
  public akda(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    k();
    g();
    h();
    i();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366280));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new akdb(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    akbs localakbs = new akbs(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(localakbs);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(localakbs);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_Akdk.a("");
  }
  
  private void h()
  {
    ((ImageButton)findViewById(2131368378)).setOnClickListener(new akdc(this));
  }
  
  private void i()
  {
    Button localButton = (Button)findViewById(2131363845);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new akdd(this));
  }
  
  private void j()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "loadMessageMore, currentKeyword = " + str);
    }
    this.jdField_a_of_type_Akcz.a(System.currentTimeMillis(), str, 2);
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131377223));
    this.jdField_a_of_type_Akcz = new akcz(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bkyc, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Akdk = new akdk(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bkyc, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Akdk);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new akdf(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new akdg(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new akdh(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemLongClickListener(new akdi(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372032));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718370);
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
      str2 = this.jdField_a_of_type_Akcz.a();
      if ((this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() != this.jdField_a_of_type_Akcz) || (!str1.equalsIgnoreCase(str2))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "searchMessage, skip, currentKeyword = " + str1 + ", mLastKeyword = " + str2);
    return;
    this.jdField_a_of_type_Akcz.a(System.currentTimeMillis(), str1, 1);
    a(2131690771);
  }
  
  public void dismiss()
  {
    ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    this.jdField_a_of_type_Bkyc.removeMessages(0);
    this.jdField_a_of_type_Bkyc.removeMessages(1);
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
      if (this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() != this.jdField_a_of_type_Akcz) {
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Akcz);
      }
      if ((paramMessage.obj instanceof List))
      {
        this.jdField_a_of_type_Akcz.a((List)paramMessage.obj, paramMessage.arg1);
        this.jdField_a_of_type_Akcz.notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Akcz.getCount() == 0)
      {
        f();
      }
      else
      {
        e();
        continue;
        if (this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter() != this.jdField_a_of_type_Akdk) {
          this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Akdk);
        }
        this.jdField_a_of_type_Akdk.notifyDataSetChanged();
        e();
      }
    }
  }
  
  public void show()
  {
    super.show();
    this.jdField_a_of_type_Bkyc.removeMessages(0);
    this.jdField_a_of_type_Bkyc.removeMessages(1);
    this.jdField_a_of_type_Bkyc.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akda
 * JD-Core Version:    0.7.0.1
 */