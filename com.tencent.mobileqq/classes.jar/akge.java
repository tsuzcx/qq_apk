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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;

public class akge
  extends BaseAdapter
  implements bcwt
{
  private int jdField_a_of_type_Int = 0;
  amab jdField_a_of_type_Amab = new akgj(this);
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  public View.OnClickListener a;
  private bcws jdField_a_of_type_Bcws;
  private bhpo jdField_a_of_type_Bhpo = new akgi(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<akgk> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  public View.OnClickListener b;
  private ArrayList<String> b;
  
  public akge(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, ListView paramListView, String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new akgf(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new akgg(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramQQAppInterface);
    paramListView.setOnScrollListener(this.jdField_a_of_type_Bhpo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amab);
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    Object localObject;
    switch (getItemViewType(paramInt))
    {
    default: 
      return null;
    case 0: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561338, null);
      if (paramViewGroup != null)
      {
        localObject = (TextView)paramViewGroup.findViewById(2131369323);
        if (localObject != null)
        {
          ((TextView)localObject).setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getText(2131721181));
          ((TextView)localObject).setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getText(2131721181));
        }
        return paramViewGroup;
      }
      break;
    case 2: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561337, null);
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).inflate(2131561339, null);
      if (paramViewGroup != null)
      {
        localObject = new akgl(this);
        ((akgl)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367506));
        ((akgl)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370958));
        ((akgl)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131365127));
        Button localButton = (Button)paramViewGroup.findViewById(2131362087);
        ((akgl)localObject).jdField_a_of_type_AndroidWidgetButton = localButton;
        ((akgl)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131371073));
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
    akgk localakgk;
    do
    {
      do
      {
        do
        {
          return;
          localObject = getItem(paramInt);
        } while (!(localObject instanceof akgk));
        localakgk = (akgk)localObject;
      } while (paramView == null);
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof akgl)));
    akgl localakgl = (akgl)paramView;
    String str = String.valueOf(localakgk.a.a());
    Object localObject = this.jdField_a_of_type_Bcws.a(1, str);
    paramView = (View)localObject;
    if (localObject == null)
    {
      localObject = bdda.a();
      paramView = (View)localObject;
      if (!this.jdField_a_of_type_Bcws.a())
      {
        this.jdField_a_of_type_Bcws.a(str, 1, false);
        paramView = (View)localObject;
      }
    }
    localakgl.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
    localakgl.jdField_a_of_type_AndroidWidgetTextView.setText(localakgk.a.a());
    localakgl.jdField_b_of_type_AndroidWidgetTextView.setText(localakgk.a.b());
    localakgl.jdField_a_of_type_JavaLangString = str;
    localakgl.jdField_a_of_type_AndroidWidgetButton.setTag(str);
    localakgl.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(localakgk.a.a());
    localakgl.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(localakgk.a.b());
    paramView = (bckx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    if (paramView != null) {}
    for (boolean bool = paramView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, this.jdField_a_of_type_JavaLangString);; bool = false)
    {
      if (bool) {
        localakgl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      while (this.jdField_b_of_type_JavaUtilArrayList.contains(str))
      {
        localakgl.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        localakgl.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131694095));
        return;
        localakgl.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      localakgl.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      localakgl.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131689628));
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
        if ((localObject != null) && ((localObject instanceof akgl)))
        {
          localObject = (akgl)localObject;
          if ((paramString != null) && (TextUtils.equals(paramString, ((akgl)localObject).jdField_a_of_type_JavaLangString))) {
            ((akgl)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
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
    this.jdField_a_of_type_Bcws.d();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amab);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131691530);
    switch (paramInt)
    {
    }
    for (;;)
    {
      QQToast.a(BaseApplication.getContext(), 0, str, 1).a();
      return;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692899);
      continue;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692900);
      continue;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131691521);
      continue;
      str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131692276);
    }
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_Bcws == null)
    {
      this.jdField_a_of_type_Bcws = new bcws(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramAppInterface);
      this.jdField_a_of_type_Bcws.a(this);
    }
  }
  
  public void a(ArrayList<bckw> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      int i = 0;
      while (i < paramArrayList.size())
      {
        akgk localakgk = new akgk(this, (bckw)paramArrayList.get(i));
        this.jdField_a_of_type_JavaUtilArrayList.add(localakgk);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akge
 * JD-Core Version:    0.7.0.1
 */