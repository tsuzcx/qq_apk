import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.tendoc.TenDocMessageResultAdapter;
import com.tencent.mobileqq.activity.history.tendoc.TencentDocItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ajhz
  extends ajgd
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TenDocMessageResultAdapter jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTenDocMessageResultAdapter;
  private String jdField_a_of_type_JavaLangString = "";
  private int jdField_b_of_type_Int;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  
  public ajhz(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    this.jdField_b_of_type_Int = paramInt;
    e();
    f();
    g();
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {}
    InputMethodManager localInputMethodManager;
    do
    {
      return;
      localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method");
    } while (localInputMethodManager == null);
    localInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131376951));
    View localView = getLayoutInflater().inflate(2131559342, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131561832, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131371848));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setClickable(false);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131376213).setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131373010).setVisibility(8);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371401)).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131717996));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(localView, null, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_AndroidViewView, null, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTenDocMessageResultAdapter = new TenDocMessageResultAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bjmp, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTenDocMessageResultAdapter);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131368234));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new ajia(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new ajib(this));
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131366179));
    this.jdField_b_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(new ajic(this));
    this.jdField_b_of_type_AndroidWidgetEditText.setImeOptions(3);
    ajge localajge = new ajge(this);
    this.jdField_b_of_type_AndroidWidgetEditText.setOnEditorActionListener(localajge);
    this.jdField_b_of_type_AndroidWidgetEditText.setOnKeyListener(localajge);
    this.jdField_b_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_AndroidContentContext.getString(2131690705));
    this.jdField_b_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_b_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new ajid(this));
    Button localButton = (Button)findViewById(2131363774);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new ajie(this));
  }
  
  protected void a()
  {
    String str = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (QLog.isColorLevel()) {
      QLog.i("TenDocMessageSearchDialog", 2, "searchMessage, keyword = " + str);
    }
    if (TextUtils.isEmpty(str)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("TenDocMessageSearchDialog", 2, "searchMessage, keyword: " + this.jdField_a_of_type_JavaLangString + ", netState: " + AppNetConnInfo.isNetSupport());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTenDocMessageResultAdapter.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTenDocMessageResultAdapter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 1);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A174", "0X800A174", this.jdField_b_of_type_Int, 0, "", "", "s_qq_history_tab", "");
  }
  
  public void a(List<Object> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if ((localObject instanceof TencentDocItem)) {
        localArrayList.add((TencentDocItem)localObject);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTenDocMessageResultAdapter.a(localArrayList);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TenDocMessageSearchDialog", 2, "handleMessage, catch show message");
      }
      Object localObject1 = paramMessage.getData();
      long l = ((Bundle)localObject1).getLong("searchSequence", 0L);
      Object localObject2 = ((Bundle)localObject1).getString("searchKeyword");
      if ((!(paramMessage.obj instanceof List)) || (l != this.jdField_a_of_type_Long) || (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, (CharSequence)localObject2)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TenDocMessageSearchDialog", 2, "handleMessage : ACTION_SHOW_MESSAGE sequence or keyword not equal, no load");
        }
        return true;
      }
      localObject1 = (List)paramMessage.obj;
      int i;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("handleMessage : ACTION_SHOW_MESSAGE searchSequence: ").append(l).append(", keyword: ").append((String)localObject2).append(", mCurrentKeyword: ").append(this.jdField_a_of_type_JavaLangString).append(", searchSequence: ").append(l).append(", mCurrentSearchSequence: ").append(this.jdField_a_of_type_Long).append(", loadType: ").append(paramMessage.arg1).append(", size: ");
        if (localObject1 == null)
        {
          i = 0;
          QLog.d("TenDocMessageSearchDialog", 2, i);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTenDocMessageResultAdapter.a((List)localObject1, paramMessage.arg1);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityHistoryTendocTenDocMessageResultAdapter.getCount() != 0) {
          break label275;
        }
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      for (;;)
      {
        return true;
        i = ((List)localObject1).size();
        break;
        label275:
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    return super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhz
 * JD-Core Version:    0.7.0.1
 */