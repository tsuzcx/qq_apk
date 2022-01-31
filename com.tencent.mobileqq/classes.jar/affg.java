import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;

public class affg
  extends BaseAdapter
  implements baxl, nor
{
  private ahnt jdField_a_of_type_Ahnt = new ahnt(paramClassificationSearchFragment.a, this, false);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new affh(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<not> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  
  public affg(ClassificationSearchFragment paramClassificationSearchFragment)
  {
    a(true);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<not> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ahnt != null) {
      this.jdField_a_of_type_Ahnt.a();
    }
  }
  
  public void a(ArrayList<not> paramArrayList, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment) != null)
    {
      if (getCount() == 0)
      {
        ((TextView)ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).findViewById(2131375713)).setText(ajyc.a(2131701911));
        ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).setVisibility(8);
      }
    }
    else
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      paramString = new StringBuilder("onGetRecommendSuccess->isFromRecommend:" + paramBoolean + ", title:" + paramString + ", list:");
      if (paramArrayList != null) {
        break label271;
      }
      paramString.append("null");
    }
    for (;;)
    {
      QLog.d("ClassificationSearchFragment", 2, paramString.toString());
      if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
        return;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramString = (not)paramArrayList.next();
        QLog.d("ClassificationSearchFragment", 2, "onGetRecommendSuccess->" + paramString.toString());
      }
      if (TextUtils.isEmpty(paramString)) {
        ((TextView)ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).findViewById(2131375713)).setText(ajyc.a(2131701916));
      }
      for (;;)
      {
        ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).setVisibility(0);
        notifyDataSetChanged();
        break;
        ((TextView)ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).findViewById(2131375713)).setText(paramString);
      }
      label271:
      paramString.append("size:").append(paramArrayList.size());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    nop.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a, paramBoolean, this);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.getActivity()).inflate(2131559449, null);
    }
    paramView = (not)getItem(paramInt);
    if (paramView != null)
    {
      if (this.jdField_a_of_type_Ahnt != null)
      {
        Drawable localDrawable = this.jdField_a_of_type_Ahnt.a(1008, paramView.jdField_a_of_type_JavaLangString);
        ((URLImageView)paramViewGroup.findViewById(2131367376)).setImageDrawable(localDrawable);
      }
      ((TextView)paramViewGroup.findViewById(2131370647)).setText(paramView.b);
      paramViewGroup.findViewById(2131364657).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewGroup.findViewById(2131364657).setTag(paramView);
      paramViewGroup.setTag(paramView);
    }
    return paramViewGroup;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment) == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      if (((paramBitmap != null) || (paramInt1 <= 0)) && (paramBitmap != null))
      {
        GridView localGridView = (GridView)ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).findViewById(2131375709);
        paramInt2 = localGridView.getChildCount();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          View localView = localGridView.getChildAt(paramInt1);
          if (paramString.equals(((not)localView.getTag()).jdField_a_of_type_JavaLangString)) {
            ((URLImageView)localView.findViewById(2131367376)).setImageBitmap(paramBitmap);
          }
          paramInt1 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     affg
 * JD-Core Version:    0.7.0.1
 */