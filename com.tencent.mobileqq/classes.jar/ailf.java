import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.subaccount.UpArrowView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class ailf
  extends BaseAdapter
{
  public LayoutInflater a;
  public View.OnClickListener a;
  public QQAppInterface a;
  public ArrayList<ayam> a;
  boolean a;
  
  public ailf(QQAppInterface paramQQAppInterface, ArrayList<ayam> paramArrayList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ayam localayam;
    SubAccountInfo localSubAccountInfo;
    baxt localbaxt;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562471, paramViewGroup, false);
      paramViewGroup = new ailg(this);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131377350));
      paramViewGroup.b = ((SingleLineTextView)paramView.findViewById(2131365043));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131367679));
      paramView.setTag(paramViewGroup);
      localayam = (ayam)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_Ayam = localayam;
      if (localayam != null)
      {
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localayam.jdField_a_of_type_JavaLangString);
        paramViewGroup.b.setText(localayam.jdField_c_of_type_JavaLangString);
        localSubAccountInfo = (SubAccountInfo)localayam.jdField_a_of_type_JavaLangObject;
        if (localSubAccountInfo != null)
        {
          localbaxt = baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localSubAccountInfo.subuin);
          if (localayam.e != 0) {
            break label252;
          }
          paramView.findViewById(2131367690).setBackgroundDrawable(null);
        }
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(localbaxt);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSubAccountInfo.subuin);
      a(paramView, localayam);
      if ((paramView instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramView).a(true);
      }
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((AppSetting.d) && (!TextUtils.isEmpty(localayam.jdField_d_of_type_JavaLangString))) {
        paramView.setContentDescription(localayam.jdField_d_of_type_JavaLangString);
      }
      return paramView;
      paramViewGroup = (ailg)paramView.getTag();
      break;
      label252:
      paramView.findViewById(2131367690).setBackgroundResource(2130849266);
    }
  }
  
  private View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    int i;
    if (paramView == null)
    {
      i = 2131562467;
      if (paramInt2 == 7)
      {
        i = 2131562468;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(i, paramViewGroup, false);
        paramViewGroup = new ailg(this);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      ayam localayam = (ayam)getItem(paramInt1);
      paramViewGroup.jdField_a_of_type_Ayam = localayam;
      if (localayam != null)
      {
        a(paramView, localayam);
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if ((AppSetting.d) && (!TextUtils.isEmpty(localayam.jdField_d_of_type_JavaLangString))) {
          paramView.setContentDescription(localayam.jdField_d_of_type_JavaLangString);
        }
      }
      return paramView;
      if (paramInt2 != 4) {
        break;
      }
      i = 2131562470;
      break;
      paramViewGroup = (ailg)paramView.getTag();
    }
  }
  
  private void a(View paramView, ayam paramayam)
  {
    if ((paramView == null) || (paramayam == null)) {}
    label371:
    for (;;)
    {
      return;
      Object localObject1;
      Object localObject2;
      switch (paramayam.jdField_b_of_type_Int)
      {
      default: 
        return;
      case 1: 
      case 2: 
        localObject1 = paramView.findViewById(2131365269);
        float f = bbct.a();
        View localView;
        if (this.jdField_a_of_type_Boolean)
        {
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(8);
          }
          localView = paramView.findViewById(2131368391);
          localObject2 = paramView.getLayoutParams();
          if (!paramayam.jdField_b_of_type_Boolean) {
            break label245;
          }
          localObject1 = paramView.findViewById(2131368372);
          paramayam = (ayam)localObject1;
          if (localObject1 == null) {
            paramayam = paramView;
          }
          paramayam.setBackgroundResource(2130839169);
          if (localView != null) {
            localView.setVisibility(0);
          }
          ((ViewGroup.LayoutParams)localObject2).height = ((int)(74.0F * f));
          if (this.jdField_a_of_type_Boolean)
          {
            paramayam = (UpArrowView)paramView.findViewById(2131362792);
            if (paramayam != null) {
              paramayam.setTheme(true);
            }
          }
        }
        for (;;)
        {
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          return;
          if (localObject1 == null) {
            break;
          }
          ((View)localObject1).setVisibility(0);
          if (!(((View)localObject1).getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            break;
          }
          localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
          if (paramayam.jdField_b_of_type_Int == 1) {}
          for (((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(16.0F * f + 0.5D));; ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0)
          {
            ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
            break;
          }
          label245:
          paramView.setBackgroundResource(2130839169);
          if (localView != null) {
            localView.setVisibility(8);
          }
          ((ViewGroup.LayoutParams)localObject2).height = ((int)(66.0F * f));
        }
      }
      if (paramayam.jdField_b_of_type_Boolean)
      {
        localObject2 = paramView.findViewById(2131368372);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = paramView;
        }
        ((View)localObject1).setBackgroundResource(2130839169);
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label371;
        }
        localObject1 = paramView.findViewById(2131365269);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        if (!paramayam.jdField_b_of_type_Boolean) {
          break;
        }
        paramView = (UpArrowView)paramView.findViewById(2131362792);
        if (paramView == null) {
          break;
        }
        paramView.setTheme(true);
        return;
        paramView.setBackgroundResource(2130839169);
      }
    }
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ayam localayam;
    FrameLayout localFrameLayout;
    int k;
    int i;
    float f1;
    float f2;
    int j;
    int m;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562473, paramViewGroup, false);
      paramViewGroup = new ailg(this);
      paramView.setTag(paramViewGroup);
      localayam = (ayam)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_Ayam = localayam;
      if (localayam == null) {
        break label631;
      }
      paramViewGroup = (ArrayList)localayam.jdField_a_of_type_JavaLangObject;
      if (paramViewGroup == null) {
        break label624;
      }
      localFrameLayout = (FrameLayout)paramView.findViewById(2131375657);
      k = paramViewGroup.size();
      i = localFrameLayout.getChildCount();
      f1 = bbct.a();
      f2 = (float)bbct.i();
      j = (int)(66.0F * f1 + 0.5F);
      m = (int)(90.0F * f1 + 0.5F);
      if ((f2 - 8.0F * f1) / j >= 5) {
        break label636;
      }
    }
    label624:
    label631:
    label636:
    for (paramInt = (int)(f2 - 8.0F * f1) / j;; paramInt = 5)
    {
      f1 = (f2 - 8.0F * f1 - paramInt * j) / (paramInt - 1) + 0.5F;
      if (f1 < 0.0F) {
        f1 = 0.0F;
      }
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        ailg localailg;
        if (k > i)
        {
          while (i < k)
          {
            localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562472, null, false);
            localObject2 = new FrameLayout.LayoutParams(j, m);
            int n = i / paramInt;
            ((FrameLayout.LayoutParams)localObject2).leftMargin = ((int)(i % paramInt * (j + f1)));
            ((FrameLayout.LayoutParams)localObject2).topMargin = (n * m);
            localailg = new ailg(this);
            localailg.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)((View)localObject1).findViewById(2131367679));
            localailg.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)((View)localObject1).findViewById(2131377350));
            localailg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject1).findViewById(2131378650));
            ((View)localObject1).setTag(localailg);
            if ((localObject1 instanceof AlphaClickableRelativeLayout)) {
              ((AlphaClickableRelativeLayout)localObject1).a(true);
            }
            localFrameLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            i += 1;
          }
          paramViewGroup = (ailg)paramView.getTag();
          break;
        }
        if (k < i)
        {
          paramInt = i - 1;
          while (paramInt >= k)
          {
            localFrameLayout.removeViewAt(paramInt);
            paramInt -= 1;
          }
        }
        paramInt = 0;
        while (paramInt < k)
        {
          localObject1 = (ayam)paramViewGroup.get(paramInt);
          localObject2 = localFrameLayout.getChildAt(paramInt);
          localailg = (ailg)((View)localObject2).getTag();
          localailg.jdField_a_of_type_Ayam = ((ayam)localObject1);
          localailg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(((ayam)localObject1).jdField_a_of_type_JavaLangString);
          SimpleAccount localSimpleAccount = (SimpleAccount)((ayam)localObject1).jdField_a_of_type_JavaLangObject;
          baxt localbaxt = baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localSimpleAccount.getUin());
          localailg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(((ayam)localObject1).jdField_a_of_type_JavaLangString);
          localailg.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSimpleAccount.getUin());
          localailg.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(localbaxt);
          localailg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
          m = ((ayam)localObject1).jdField_d_of_type_Int;
          i = 0;
          j = 0;
          if (m > 0)
          {
            j = 2130849296;
            i = 3;
          }
          localailg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
          bfqb.a(localailg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, m, j, 99, null);
          ((View)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          if ((AppSetting.d) && (!TextUtils.isEmpty(((ayam)localObject1).jdField_d_of_type_JavaLangString))) {
            ((View)localObject2).setContentDescription(((ayam)localObject1).jdField_d_of_type_JavaLangString);
          }
          paramInt += 1;
        }
        a(paramView, localayam);
        return paramView;
      }
    }
  }
  
  private View c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ailg localailg;
    ayam localayam;
    Resources localResources;
    SubAccountMessage localSubAccountMessage;
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562466, paramViewGroup, false);
      localailg = new ailg(this);
      localailg.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131377350));
      localailg.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramViewGroup.findViewById(2131367679));
      localailg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramViewGroup.findViewById(2131378650));
      localailg.b = ((SingleLineTextView)paramViewGroup.findViewById(2131365043));
      paramViewGroup.setTag(localailg);
      localayam = (ayam)getItem(paramInt);
      localailg.jdField_a_of_type_Ayam = localayam;
      localResources = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources();
      if (localayam != null)
      {
        localSubAccountMessage = (SubAccountMessage)localayam.jdField_a_of_type_JavaLangObject;
        localObject = localSubAccountMessage.sendername;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label974;
        }
        localObject = localSubAccountMessage.senderuin;
      }
    }
    label431:
    label946:
    label958:
    label974:
    for (;;)
    {
      localailg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
      if (((localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) && (localSubAccountMessage.msg != null)) {
        localSubAccountMessage.mEmoRecentMsg = new ayki(localSubAccountMessage.msg, 3, 16);
      }
      localailg.b.setText(localSubAccountMessage.mEmoRecentMsg);
      if ((localSubAccountMessage.mTimeString == null) || (localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) {
        localSubAccountMessage.mTimeString = bbkb.a(localSubAccountMessage.time * 1000L, true, ayao.jdField_a_of_type_JavaLangString);
      }
      localailg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(localSubAccountMessage.mTimeString, 0);
      paramView = baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localSubAccountMessage.senderuin);
      localailg.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSubAccountMessage.senderuin);
      localailg.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(paramView);
      localailg.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setVisibility(0);
      localailg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      int m = localSubAccountMessage.unreadNum;
      paramInt = 0;
      int i = 0;
      int j;
      int k;
      if (m > 0)
      {
        j = 2130849292;
        k = 3;
        if ((2 == localayam.jdField_c_of_type_Int) || (3 == localayam.jdField_c_of_type_Int))
        {
          paramView = "[" + localResources.getString(2131717474) + "]";
          paramInt = 0;
          i = j;
        }
      }
      for (;;)
      {
        localailg.b.setExtendText(paramView, 1);
        localailg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramViewGroup);
        bfqb.a(localailg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, k, m, i, 99, null);
        StringBuilder localStringBuilder;
        float f;
        if ((AppSetting.d) && (TextUtils.isEmpty(localayam.jdField_d_of_type_JavaLangString)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject).append(",");
          if (localayam.jdField_d_of_type_Int == 0)
          {
            if (paramView != null) {
              localStringBuilder.append(paramView + ",");
            }
            localStringBuilder.append(localSubAccountMessage.mEmoRecentMsg).append(",").append(localSubAccountMessage.mTimeString);
            localayam.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
          }
        }
        else
        {
          f = bbct.a();
          paramView = localResources.getColorStateList(2131166928);
          localObject = localResources.getColorStateList(2131166854);
          i = localResources.getColor(2131166955);
          localailg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject);
          localailg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
          localailg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
          localailg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
          localailg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
          localailg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
          localailg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
          if (paramInt == 0) {
            break label946;
          }
          localailg.b.setTextColor(i);
        }
        for (;;)
        {
          localailg.b.setExtendTextColor(ColorStateList.valueOf(i), 1);
          localailg.b.setExtendTextPadding((int)(f * 2.0F), 1);
          localailg.b.setExtendTextSize(14.0F, 1);
          a(paramViewGroup, localayam);
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          if ((AppSetting.d) && (!TextUtils.isEmpty(localayam.jdField_d_of_type_JavaLangString))) {
            paramViewGroup.setContentDescription(localayam.jdField_d_of_type_JavaLangString);
          }
          if (this.jdField_a_of_type_Boolean)
          {
            paramView = paramViewGroup.findViewById(2131365281);
            if (paramView != null) {
              paramView.setVisibility(8);
            }
          }
          return paramViewGroup;
          localailg = (ailg)paramView.getTag();
          paramViewGroup = paramView;
          break;
          paramInt = k;
          i = j;
          if (!"RED_PACKET".equals(localSubAccountMessage.subExtr)) {
            break label958;
          }
          paramView = "";
          paramInt = 1;
          i = j;
          break label431;
          if (localayam.jdField_d_of_type_Int == 1)
          {
            localStringBuilder.append("有一条未读");
            break label516;
          }
          if (localayam.jdField_d_of_type_Int == 2)
          {
            localStringBuilder.append("有两条未读");
            break label516;
          }
          if (localayam.jdField_d_of_type_Int <= 0) {
            break label516;
          }
          localStringBuilder.append("有").append(localayam.jdField_d_of_type_Int).append("条未读,");
          break label516;
          localailg.b.setTextColor(paramView);
        }
        paramView = "";
        j = 0;
        k = paramInt;
        paramInt = j;
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return paramInt;
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((ayam)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.d("SUB_ACCOUNT_AssocQQ_Adapter", 2, "getView() position=" + paramInt + " viewType=" + i);
    }
    switch (i)
    {
    case 6: 
    default: 
      View localView = paramView;
      if (paramView == null) {
        localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562469, paramViewGroup, false);
      }
      return localView;
    case 3: 
      return c(paramInt, paramView, paramViewGroup);
    case 5: 
      return b(paramInt, paramView, paramViewGroup);
    case 2: 
      return a(paramInt, paramView, paramViewGroup);
    }
    return a(paramInt, paramView, paramViewGroup, i);
  }
  
  public int getViewTypeCount()
  {
    return 8;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ailf
 * JD-Core Version:    0.7.0.1
 */