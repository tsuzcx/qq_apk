import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.util.Pair;
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
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.searcher.oidb_c2c_searcher.Iterator;

public class aigp
  extends aigc
{
  long jdField_a_of_type_Long;
  public aign a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aigt(this);
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  String jdField_a_of_type_JavaLangString = "";
  private HashMap<String, oidb_c2c_searcher.Iterator> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<aihj> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Set<Long> jdField_a_of_type_JavaUtilSet = new HashSet();
  int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString = "";
  private List<aihj> jdField_b_of_type_JavaUtilList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  boolean jdField_d_of_type_Boolean = false;
  boolean e = false;
  
  public aigp(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramSessionInfo);
    this.jdField_b_of_type_Boolean = paramBoolean;
    paramContext = paramQQAppInterface.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(paramContext)) && ("1".equals(paramContext.substring(paramContext.length() - 1, paramContext.length())))) {
      this.e = true;
    }
    h();
    e();
    g();
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "showHeaderViewByType, needShowType = " + paramInt + ",tips: " + paramString);
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
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    case 1: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 2: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166421));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      return;
    case 3: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166977));
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      return;
    case 4: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131365851));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new aigq(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    aigd localaigd = new aigd(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(localaigd);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(localaigd);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  private void f()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
  }
  
  private void g()
  {
    ((ImageButton)findViewById(2131367817)).setOnClickListener(new aigr(this));
    Button localButton = (Button)findViewById(2131363522);
    localButton.setVisibility(0);
    localButton.setOnClickListener(new aigs(this));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131376283));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView = getLayoutInflater().inflate(2131559255, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidViewView, null, false);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375588));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376247));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376268));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376271));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371211));
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_b_of_type_AndroidViewView = getLayoutInflater().inflate(2131561678, null);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_b_of_type_AndroidViewView, null, false);
    this.jdField_b_of_type_AndroidViewView.setClickable(false);
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131375588));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370767));
    this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131719588));
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Aign = new aign(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bhsl, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aign);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new aigu(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new aigv(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new aigw(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemLongClickListener(new aigx(this));
  }
  
  protected void a()
  {
    String str = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "searchMessage, keyword = " + str);
    }
    if (str.length() == 0) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    f();
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_Aign.a(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "searchMessage, keyword: " + this.jdField_a_of_type_JavaLangString + ", needSearchInCloud: " + this.jdField_b_of_type_Boolean + ", netState: " + AppNetConnInfo.isNetSupport());
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if ((this.jdField_b_of_type_Boolean) && (AppNetConnInfo.isNetSupport()))
    {
      this.jdField_b_of_type_Int = 1;
      a(5, null);
      b(1);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FCB", "0X8005FCB", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FCA", "0X8005FCA", 0, 0, "", "", "", "");
      return;
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Aign.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 1);
      if (this.jdField_b_of_type_Boolean) {
        a(3, this.jdField_a_of_type_AndroidContentContext.getString(2131719598));
      } else {
        a(0, null);
      }
    }
  }
  
  public void b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    oidb_c2c_searcher.Iterator localIterator = (oidb_c2c_searcher.Iterator)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_JavaLangString);
    long l1 = NetConnInfoCenter.getServerTime();
    Object localObject2 = (alxa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    Object localObject1 = ((alxa)localObject2).c();
    long l2;
    int j;
    int k;
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      l2 = ((Long)((alxa)localObject2).a((Calendar)localObject1).second).longValue();
      localObject2 = new StringBuilder();
      int i = ((Calendar)localObject1).get(1);
      j = ((Calendar)localObject1).get(2) + 1;
      k = ((Calendar)localObject1).get(5);
      localStringBuilder = ((StringBuilder)localObject2).append(i).append("-");
      if (j <= 9) {
        break label280;
      }
      localObject1 = Integer.valueOf(j);
      localStringBuilder = localStringBuilder.append(localObject1).append("-");
      if (k <= 9) {
        break label305;
      }
    }
    label280:
    label305:
    for (localObject1 = Integer.valueOf(k);; localObject1 = "0" + k)
    {
      localStringBuilder.append(localObject1);
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.i("C2CMessageSearchDialog", 2, "showSearchDialog--> lastDay:" + ((StringBuilder)localObject2).toString());
        l1 = l2;
      }
      if (localIterator == null) {
        break label331;
      }
      localObject1 = new ArrayList();
      ((List)localObject1).add(localIterator);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt, localArrayList, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, (List)localObject1, 0, l1);
      return;
      localObject1 = "0" + j;
      break;
    }
    label331:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt, localArrayList, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, null, 0, l1);
  }
  
  public void dismiss()
  {
    ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    this.jdField_a_of_type_Bhsl.removeMessages(0);
    this.jdField_a_of_type_Bhsl.removeMessages(1);
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
      QLog.i("C2CMessageSearchDialog", 2, "handleMessage, msg.what = " + paramMessage.what + ",mSearchMode = " + this.jdField_b_of_type_Int);
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
      Object localObject1 = paramMessage.getData();
      long l = ((Bundle)localObject1).getLong("searchSequence", 0L);
      localObject1 = ((Bundle)localObject1).getString("searchKeyword");
      Object localObject2 = (List)paramMessage.obj;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("handleMessage : ACTION_SHOW_MESSAGE searchSequence: ").append(l).append(", keyword: ").append((String)localObject1).append(", mCurrentKeyword: ").append(this.jdField_a_of_type_JavaLangString).append(", searchSequence: ").append(l).append(", mSearchSequence: ").append(this.jdField_a_of_type_Long).append(", loadType: ").append(paramMessage.arg1).append(", size: ");
        if (localObject2 != null) {
          break label320;
        }
      }
      label320:
      for (i = 0;; i = ((List)localObject2).size())
      {
        QLog.d("C2CMessageSearchDialog", 2, i);
        if ((localObject2 != null) && (l == this.jdField_a_of_type_Long) && ((localObject1 == null) || (((String)localObject1).equals(this.jdField_a_of_type_JavaLangString)))) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("C2CMessageSearchDialog", 2, "handleMessage : ACTION_SHOW_MESSAGE sequence or keyword not equal, no load");
        }
        return true;
      }
      if (((1 == paramMessage.arg1) && (((List)localObject2).size() > 0) && (((List)localObject2).size() != 20)) || ((2 == paramMessage.arg1) && (((List)localObject2).size() == 0)))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131701667));
        this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131372333).setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        if (2 == paramMessage.arg1)
        {
          this.jdField_c_of_type_Boolean = false;
          continue;
        }
      }
      if ((paramMessage.obj instanceof List))
      {
        this.jdField_a_of_type_Aign.a((List)paramMessage.obj, paramMessage.arg1, this.jdField_d_of_type_Boolean, 0);
        this.jdField_a_of_type_Aign.notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_Aign.getCount() == 0) {
        a(4, null);
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = false;
        break;
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      }
      paramMessage = (HashMap)paramMessage.obj;
      localObject1 = (String)paramMessage.get("KEYWORD");
      l = ((Long)paramMessage.get("SEARCHSEQUENCE")).longValue();
      i = ((Integer)paramMessage.get("LOADTYPE")).intValue();
      if (QLog.isColorLevel()) {
        QLog.i("C2CMessageSearchDialog", 2, "handleMessage : RSP_SEARCH_TIMEOUT_OR_ERROR_IN_CLOUD ReqkeyWord = " + (String)localObject1 + ",currentKeyword: " + this.jdField_a_of_type_JavaLangString + ", searchSequence: " + l + ",mCurrentSequence: " + this.jdField_a_of_type_Long + ", needSearchInCloud: " + this.jdField_b_of_type_Boolean);
      }
      if ((!this.jdField_b_of_type_Boolean) || (l != this.jdField_a_of_type_Long) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(this.jdField_a_of_type_JavaLangString))) {
        return true;
      }
      if ((l == this.jdField_a_of_type_Long) && (this.jdField_a_of_type_JavaLangString.equals(localObject1)))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_d_of_type_Boolean = true;
        this.jdField_c_of_type_Int = 0;
        if (i == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2CMessageSearchDialog", 2, "LOAD_REFRESH query cloud failed --->>> switch local mode");
          }
          a(0, null);
          this.jdField_b_of_type_Int = 0;
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_Aign.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 1);
        }
        for (;;)
        {
          this.jdField_c_of_type_Boolean = false;
          this.jdField_a_of_type_JavaUtilList.clear();
          break;
          if (QLog.isColorLevel()) {
            QLog.d("C2CMessageSearchDialog", 2, "LOAD_MSG_IN_CLOUD query cloud failed --->>> merge local data");
          }
          this.jdField_a_of_type_Aign.a(this.jdField_a_of_type_JavaUtilList, 4, this.jdField_d_of_type_Boolean, 0);
          this.jdField_a_of_type_Aign.notifyDataSetChanged();
        }
        localObject2 = (HashMap)paramMessage.obj;
        localObject1 = (String)((HashMap)localObject2).get("KEYWORD");
        l = ((Long)((HashMap)localObject2).get("SEARCHSEQUENCE")).longValue();
        int j = ((Integer)((HashMap)localObject2).get("LOADTYPE")).intValue();
        paramMessage = (List)((HashMap)localObject2).get("SEARCHRESULT");
        boolean bool = ((Boolean)((HashMap)localObject2).get("SEARCHCOMPLETE")).booleanValue();
        if (((HashMap)localObject2).get("SEARCHINFO") != null)
        {
          localObject2 = (List)((HashMap)localObject2).get("SEARCHINFO");
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, ((List)localObject2).get(0));
        }
        if (QLog.isColorLevel()) {
          QLog.i("C2CMessageSearchDialog", 2, "handleMessage : RSP_SEARCH_MORE_MESSAGE_IN_CLOUD reqKeyWord: " + (String)localObject1 + ", mCurrentKeyword: " + this.jdField_a_of_type_JavaLangString + ", searchSequence: " + l + ", mCurrentSequence:" + this.jdField_a_of_type_Long + ", searchresult size: " + paramMessage.size() + ", total cache size: " + this.jdField_a_of_type_JavaUtilList.size() + ", IsComplete: " + bool + ", loadType: " + j + ", needSearchInCloud: " + this.jdField_b_of_type_Boolean + ", retryGetMore: " + this.jdField_c_of_type_Int);
        }
        if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Long != l) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(this.jdField_a_of_type_JavaLangString))) {
          return true;
        }
        if ((this.jdField_a_of_type_Long == l) && (this.jdField_a_of_type_JavaLangString.equals(localObject1)))
        {
          this.jdField_c_of_type_Boolean = false;
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          this.jdField_d_of_type_Boolean = bool;
          if (this.jdField_c_of_type_Int == 0) {
            this.jdField_a_of_type_JavaUtilList.clear();
          }
          i = 0;
          while (i < paramMessage.size())
          {
            localObject1 = new aihj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)paramMessage.get(i));
            this.jdField_a_of_type_JavaUtilList.add(localObject1);
            this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(((aihj)localObject1).a.shmsgseq));
            i += 1;
          }
          if ((this.jdField_a_of_type_JavaUtilList.size() < 15) && (!this.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_Int < 4))
          {
            this.jdField_c_of_type_Int += 1;
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.i("C2CMessageSearchDialog", 2, "handleMessage, retry to accumulate more messages for one-screen-display,retryGetMore = " + this.jdField_c_of_type_Int + ",loadType: " + j);
            }
            b(j);
            return true;
          }
          if (!this.jdField_d_of_type_Boolean) {
            if (this.jdField_c_of_type_Int >= 4) {
              break label1530;
            }
          }
          label1530:
          for (bool = this.jdField_d_of_type_Boolean;; bool = true)
          {
            this.jdField_d_of_type_Boolean = bool;
            this.jdField_c_of_type_Int = 0;
            if (j != 1) {
              break label1637;
            }
            a(0, null);
            if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
              break label1536;
            }
            if (QLog.isColorLevel()) {
              QLog.d("C2CMessageSearchDialog", 2, "LOAD_REFRESH, no result at cloud, load local msg, mIsComplete: " + this.jdField_d_of_type_Boolean);
            }
            this.jdField_b_of_type_Int = 0;
            this.jdField_a_of_type_Long = System.currentTimeMillis();
            this.jdField_a_of_type_Aign.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString, 1);
            break;
          }
          label1536:
          if (QLog.isColorLevel()) {
            QLog.d("C2CMessageSearchDialog", 2, "LOAD_REFRESH, has result at cloud size: " + this.jdField_a_of_type_JavaUtilList.size() + ", start merge local msg, mIsComplete: " + this.jdField_d_of_type_Boolean);
          }
          this.jdField_a_of_type_Aign.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FC2", "0X8005FC2", 0, 0, "", "", "", "");
          continue;
          label1637:
          if (QLog.isColorLevel()) {
            QLog.d("C2CMessageSearchDialog", 2, " LOAD_MORE&LOAD_MSG_IN_CLOUD, has rsult at cloud size: " + this.jdField_a_of_type_JavaUtilList.size() + ", mIsComplete: " + this.jdField_d_of_type_Boolean);
          }
          if (this.e) {
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FCC", "0X8005FCC", 0, (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), "", "", "", "");
          }
          this.jdField_a_of_type_Aign.a(this.jdField_a_of_type_JavaUtilList, 4, this.jdField_d_of_type_Boolean, 1);
          this.jdField_a_of_type_Aign.notifyDataSetChanged();
          this.jdField_a_of_type_JavaUtilList.clear();
          continue;
          paramMessage = (HashMap)paramMessage.obj;
          localObject1 = (String)paramMessage.get("keyword");
          l = ((Long)paramMessage.get("sequence")).longValue();
          if (QLog.isColorLevel()) {
            QLog.i("C2CMessageSearchDialog", 2, "handleMessage : MSG_TYPE_QUERY_LOCAL_DONE lastRequestKeyWord = " + (String)localObject1 + ",currentKeyword = " + this.jdField_a_of_type_JavaLangString + ",searchSequence = " + l + ",mCurrentSequence = " + this.jdField_a_of_type_Long + ",mIsComplete: " + this.jdField_d_of_type_Boolean);
          }
          if ((!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Long != l) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(this.jdField_a_of_type_JavaLangString))) {
            return true;
          }
          if ((l == this.jdField_a_of_type_Long) && (this.jdField_a_of_type_JavaLangString.equals(localObject1)))
          {
            azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005FC6", "0X8005FC6", 0, (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long), "", "", "", "");
            this.jdField_c_of_type_Boolean = false;
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            this.jdField_a_of_type_Aign.a(this.jdField_a_of_type_JavaUtilList, this.jdField_d_of_type_Boolean);
            if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_Aign.getCount() < 20))
            {
              this.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131701669));
              this.jdField_c_of_type_AndroidWidgetLinearLayout.findViewById(2131372333).setVisibility(8);
              this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
              this.jdField_b_of_type_AndroidViewView.setVisibility(0);
            }
            this.jdField_a_of_type_Aign.notifyDataSetChanged();
            this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aign);
            this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
            this.jdField_a_of_type_JavaUtilList.clear();
            continue;
            localObject1 = (HashMap)paramMessage.obj;
            paramMessage = (String)((HashMap)localObject1).get("keyword");
            l = ((Long)((HashMap)localObject1).get("sequence")).longValue();
            localObject1 = (List)((HashMap)localObject1).get("data");
            if (QLog.isColorLevel()) {
              QLog.i("C2CMessageSearchDialog", 2, "handleMessage: MERGE_LOCAL_MESSAGES_AND_CLOUD_MESSAGES reqKeyWord = " + paramMessage + ",currentKeyword = " + this.jdField_a_of_type_JavaLangString + ",searchSequence = " + l + ",mCurrentSequence = " + this.jdField_a_of_type_Long + ",mIsComplete: " + this.jdField_d_of_type_Boolean);
            }
            if ((TextUtils.isEmpty(paramMessage)) || (!this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Long != l) || (!this.jdField_a_of_type_JavaLangString.equals(paramMessage))) {
              return true;
            }
            if ((l == this.jdField_a_of_type_Long) && (this.jdField_a_of_type_JavaLangString.equals(paramMessage)))
            {
              this.jdField_c_of_type_Boolean = false;
              this.jdField_b_of_type_AndroidViewView.setVisibility(8);
              this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              this.jdField_a_of_type_Aign.a((List)localObject1, this.jdField_d_of_type_Boolean);
              this.jdField_a_of_type_Aign.notifyDataSetChanged();
              this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aign);
              this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
              this.jdField_a_of_type_JavaUtilList.clear();
            }
          }
        }
      }
    }
  }
  
  public void show()
  {
    super.show();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(getClass(), this.jdField_a_of_type_Bhsl);
    this.jdField_a_of_type_Bhsl.removeMessages(0);
    this.jdField_a_of_type_Bhsl.removeMessages(1);
    this.jdField_a_of_type_Bhsl.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aigp
 * JD-Core Version:    0.7.0.1
 */