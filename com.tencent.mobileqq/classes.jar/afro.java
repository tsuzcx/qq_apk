import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class afro
  extends afrl
{
  long jdField_a_of_type_Long;
  afrn jdField_a_of_type_Afrn;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afrs(this);
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  MessageForStructing jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
  String jdField_a_of_type_JavaLangString = "";
  ArrayList<Object> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<afss> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<Long> jdField_a_of_type_JavaUtilSet = new HashSet();
  int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString = "";
  boolean jdField_b_of_type_Boolean = false;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  boolean jdField_c_of_type_Boolean = false;
  private LinearLayout d;
  
  public afro(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    paramContext = paramQQAppInterface.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(paramContext)) && ("1".equals(paramContext.substring(paramContext.length() - 1, paramContext.length())))) {}
    h();
    e();
    g();
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "showHeaderViewByType, needShowType = " + paramInt + ",tips: " + paramString);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.d.setVisibility(8);
      return;
    case 1: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    case 2: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 3: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 4: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.d.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131300167));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new afrp(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    afrm localafrm = new afrm(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(localafrm);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(localafrm);
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_AndroidContentContext.getString(2131625163));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  private void f()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void g()
  {
    ((ImageButton)findViewById(2131302060)).setOnClickListener(new afrq(this));
    Button localButton = (Button)findViewById(2131297934);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new afrr(this));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131309972));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131493643, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView, null, false);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131309309));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131309957));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131309960));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.d = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131305209));
    this.d.setClickable(false);
    this.jdField_b_of_type_AndroidViewView = getLayoutInflater().inflate(2131495880, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_b_of_type_AndroidViewView, null, false);
    this.jdField_b_of_type_AndroidViewView.setClickable(false);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131309309));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131304782));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131653256));
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Afrn = new afrn(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Beez, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afrn);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new afrt(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new afru(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new afrv(this));
  }
  
  protected void a()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "searchMessage, keyword = " + str);
    }
    if (str.length() == 0) {
      return;
    }
    f();
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_Afrn.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "searchMessage, keyword: " + this.jdField_a_of_type_JavaLangString + ", netState: " + AppNetConnInfo.isNetSupport());
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Afrn.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 1);
    a(0, null);
  }
  
  public void a(List<Object> paramList)
  {
    this.jdField_a_of_type_Afrn.a(paramList);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
  }
  
  public void dismiss()
  {
    ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    this.jdField_a_of_type_Beez.removeMessages(0);
    this.jdField_a_of_type_Beez.removeMessages(1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "handleMessage, msg.what = " + paramMessage.what + ",mSearchMode = " + this.jdField_b_of_type_Int);
    }
    switch (i)
    {
    }
    Object localObject;
    long l;
    label314:
    label325:
    do
    {
      do
      {
        return true;
        c();
        return true;
        d();
        return true;
        localObject = paramMessage.getData();
        l = ((Bundle)localObject).getLong("searchSequence", 0L);
        localObject = ((Bundle)localObject).getString("searchKeyword");
        List localList = (List)paramMessage.obj;
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("handleMessage : ACTION_SHOW_MESSAGE searchSequence: ").append(l).append(", keyword: ").append((String)localObject).append(", mCurrentKeyword: ").append(this.jdField_a_of_type_JavaLangString).append(", searchSequence: ").append(l).append(", mSearchSequence: ").append(this.jdField_a_of_type_Long).append(", loadType: ").append(paramMessage.arg1).append(", size: ");
          if (localList != null) {
            break label314;
          }
        }
        for (i = 0;; i = localList.size())
        {
          QLog.d("LinkMessageSearchDialog", 2, i);
          if ((localList != null) && (l == this.jdField_a_of_type_Long) && ((localObject == null) || (((String)localObject).equals(this.jdField_a_of_type_JavaLangString)))) {
            break label325;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("LinkMessageSearchDialog", 2, "handleMessage : ACTION_SHOW_MESSAGE sequence or keyword not equal, no load");
          return true;
        }
        if (((1 == paramMessage.arg1) && (localList.size() > 0) && (localList.size() != 20)) || ((2 == paramMessage.arg1) && (localList.size() == 0)))
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText(ajjy.a(2131635481));
          this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131306299).setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
          if (2 == paramMessage.arg1)
          {
            this.jdField_b_of_type_Boolean = false;
            return true;
          }
        }
        if ((paramMessage.obj instanceof List))
        {
          this.jdField_a_of_type_Afrn.a((List)paramMessage.obj, paramMessage.arg1, this.jdField_c_of_type_Boolean, 0);
          this.jdField_a_of_type_Afrn.notifyDataSetChanged();
        }
        if (this.jdField_a_of_type_Afrn.getCount() == 0) {
          a(4, null);
        }
        for (;;)
        {
          this.jdField_b_of_type_Boolean = false;
          return true;
          this.d.setVisibility(8);
          this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
        }
        paramMessage = (HashMap)paramMessage.obj;
        localObject = (String)paramMessage.get("keyword");
        l = ((Long)paramMessage.get("sequence")).longValue();
        if (QLog.isColorLevel()) {
          QLog.i("LinkMessageSearchDialog", 2, "handleMessage : MSG_TYPE_QUERY_LOCAL_DONE lastRequestKeyWord = " + (String)localObject + ",currentKeyword = " + this.jdField_a_of_type_JavaLangString + ",searchSequence = " + l + ",mCurrentSequence = " + this.jdField_a_of_type_Long + ",mIsComplete: " + this.jdField_c_of_type_Boolean);
        }
      } while ((this.jdField_a_of_type_Long != l) || (TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equals(this.jdField_a_of_type_JavaLangString)) || (l != this.jdField_a_of_type_Long) || (!this.jdField_a_of_type_JavaLangString.equals(localObject)));
      this.jdField_b_of_type_Boolean = false;
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Afrn.a(this.jdField_a_of_type_JavaUtilList, this.jdField_c_of_type_Boolean);
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Afrn.getCount() < 20))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ajjy.a(2131635484));
        this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131306299).setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_Afrn.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afrn);
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      this.jdField_a_of_type_JavaUtilList.clear();
      return true;
      localObject = (HashMap)paramMessage.obj;
      paramMessage = (String)((HashMap)localObject).get("keyword");
      l = ((Long)((HashMap)localObject).get("sequence")).longValue();
      localObject = (List)((HashMap)localObject).get("data");
      if (QLog.isColorLevel()) {
        QLog.i("LinkMessageSearchDialog", 2, "handleMessage: MERGE_LOCAL_MESSAGES_AND_CLOUD_MESSAGES reqKeyWord = " + paramMessage + ",currentKeyword = " + this.jdField_a_of_type_JavaLangString + ",searchSequence = " + l + ",mCurrentSequence = " + this.jdField_a_of_type_Long + ",mIsComplete: " + this.jdField_c_of_type_Boolean);
      }
    } while ((TextUtils.isEmpty(paramMessage)) || (this.jdField_a_of_type_Long != l) || (!this.jdField_a_of_type_JavaLangString.equals(paramMessage)) || (l != this.jdField_a_of_type_Long) || (!this.jdField_a_of_type_JavaLangString.equals(paramMessage)));
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_Afrn.a((List)localObject, this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_Afrn.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Afrn);
    this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    this.jdField_a_of_type_JavaUtilList.clear();
    return true;
  }
  
  public void show()
  {
    super.show();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_Beez);
    this.jdField_a_of_type_Beez.removeMessages(0);
    this.jdField_a_of_type_Beez.removeMessages(1);
    this.jdField_a_of_type_Beez.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afro
 * JD-Core Version:    0.7.0.1
 */