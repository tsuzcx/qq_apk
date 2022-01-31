import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.adapter.RobotAdapter.5;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;

public class aiot
  extends BaseAdapter
  implements baxz
{
  private int jdField_a_of_type_Int = 0;
  akil jdField_a_of_type_Akil = new aioy(this);
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  public View.OnClickListener a;
  private baxy jdField_a_of_type_Baxy;
  private bfos jdField_a_of_type_Bfos = new aiox(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<aioz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  public View.OnClickListener b;
  private ArrayList<String> b;
  
  public aiot(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, ListView paramListView, String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aiou(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new aiov(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramQQAppInterface);
    paramListView.setOnScrollListener(this.jdField_a_of_type_Bfos);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akil);
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    Object localObject;
    switch (getItemViewType(paramInt))
    {
    default: 
      return null;
    case 0: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561150, null);
      if (paramViewGroup != null)
      {
        localObject = (TextView)paramViewGroup.findViewById(2131369091);
        if (localObject != null)
        {
          ((TextView)localObject).setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getText(2131720641));
          ((TextView)localObject).setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getText(2131720641));
        }
        return paramViewGroup;
      }
      break;
    case 2: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561149, null);
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561151, null);
      if (paramViewGroup != null)
      {
        localObject = new aipa(this);
        ((aipa)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367376));
        ((aipa)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370647));
        ((aipa)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365042));
        Button localButton = (Button)paramViewGroup.findViewById(2131362083);
        ((aipa)localObject).jdField_a_of_type_AndroidWidgetButton = localButton;
        ((aipa)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131370762));
        paramViewGroup.setTag(localObject);
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localButton.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
      return paramViewGroup;
    }
    return paramViewGroup;
  }
  
  private void a(int paramInt, View paramView)
  {
    switch (getItemViewType(paramInt))
    {
    }
    aioz localaioz;
    do
    {
      do
      {
        do
        {
          return;
          localObject = getItem(paramInt);
        } while (!(localObject instanceof aioz));
        localaioz = (aioz)localObject;
      } while (paramView == null);
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof aipa)));
    aipa localaipa = (aipa)paramView;
    String str = String.valueOf(localaioz.a.a());
    Object localObject = this.jdField_a_of_type_Baxy.a(1, str);
    paramView = (View)localObject;
    if (localObject == null)
    {
      localObject = bbef.a();
      paramView = (View)localObject;
      if (!this.jdField_a_of_type_Baxy.a())
      {
        this.jdField_a_of_type_Baxy.a(str, 1, false);
        paramView = (View)localObject;
      }
    }
    localaipa.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
    localaipa.jdField_a_of_type_AndroidWidgetTextView.setText(localaioz.a.a());
    localaipa.jdField_b_of_type_AndroidWidgetTextView.setText(localaioz.a.b());
    localaipa.jdField_a_of_type_JavaLangString = str;
    localaipa.jdField_a_of_type_AndroidWidgetButton.setTag(str);
    localaipa.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(localaioz.a.a());
    localaipa.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(localaioz.a.b());
    paramView = (bamk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    if (paramView != null) {}
    for (boolean bool = paramView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, this.jdField_a_of_type_JavaLangString);; bool = false)
    {
      if (bool) {
        localaipa.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      while (this.jdField_b_of_type_JavaUtilArrayList.contains(str))
      {
        localaipa.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        localaipa.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131693979));
        return;
        localaipa.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      localaipa.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      localaipa.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131689628));
      return;
    }
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
        if ((localObject != null) && ((localObject instanceof aipa)))
        {
          localObject = (aipa)localObject;
          if ((paramString != null) && (TextUtils.equals(paramString, ((aipa)localObject).jdField_a_of_type_JavaLangString))) {
            ((aipa)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new RobotAdapter.5(this, paramString, paramBoolean, paramInt));
  }
  
  public void a()
  {
    this.jdField_a_of_type_Baxy.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akil);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131691476);
    switch (paramInt)
    {
    }
    for (;;)
    {
      bcql.a(BaseApplication.getContext(), 0, str, 1).a();
      return;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692817);
      continue;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692818);
      continue;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131691468);
      continue;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692200);
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_Baxy == null)
    {
      this.jdField_a_of_type_Baxy = new baxy(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramAppInterface);
      this.jdField_a_of_type_Baxy.a(this);
    }
  }
  
  public void a(ArrayList<bamj> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      int i = 0;
      while (i < paramArrayList.size())
      {
        aioz localaioz = new aioz(this, (bamj)paramArrayList.get(i));
        this.jdField_a_of_type_JavaUtilArrayList.add(localaioz);
        i += 1;
      }
      QLog.d("RobotAdapter", 2, "setData arrayList" + paramArrayList.size());
      super.notifyDataSetChanged();
      return;
    }
    QLog.e("RobotAdapter", 2, "setData null");
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
        return 2;
      }
      return this.jdField_a_of_type_JavaUtilArrayList.size() + 1;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (paramInt >= 1)) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      if (paramInt != 0) {}
    }
    while (paramInt == 0)
    {
      return 0;
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = a(paramInt, paramViewGroup);
    }
    a(paramInt, localView);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    a(paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aiot
 * JD-Core Version:    0.7.0.1
 */