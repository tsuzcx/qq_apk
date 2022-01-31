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

public class aeuk
  extends BaseAdapter
  implements azwh, ndq
{
  private ahbe jdField_a_of_type_Ahbe = new ahbe(paramClassificationSearchFragment.a, this, false);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aeul(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<nds> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  
  public aeuk(ClassificationSearchFragment paramClassificationSearchFragment)
  {
    a(true);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<nds> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ahbe != null) {
      this.jdField_a_of_type_Ahbe.a();
    }
  }
  
  public void a(ArrayList<nds> paramArrayList, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment) != null)
    {
      if (getCount() == 0)
      {
        ((TextView)ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).findViewById(2131309952)).setText(ajjy.a(2131636127));
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
        paramString = (nds)paramArrayList.next();
        QLog.d("ClassificationSearchFragment", 2, "onGetRecommendSuccess->" + paramString.toString());
      }
      if (TextUtils.isEmpty(paramString)) {
        ((TextView)ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).findViewById(2131309952)).setText(ajjy.a(2131636132));
      }
      for (;;)
      {
        ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).setVisibility(0);
        notifyDataSetChanged();
        break;
        ((TextView)ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).findViewById(2131309952)).setText(paramString);
      }
      label271:
      paramString.append("size:").append(paramArrayList.size());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ndo.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a, paramBoolean, this);
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
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.getActivity()).inflate(2131493881, null);
    }
    paramView = (nds)getItem(paramInt);
    if (paramView != null)
    {
      if (this.jdField_a_of_type_Ahbe != null)
      {
        Drawable localDrawable = this.jdField_a_of_type_Ahbe.a(1008, paramView.jdField_a_of_type_JavaLangString);
        ((URLImageView)paramViewGroup.findViewById(2131301766)).setImageDrawable(localDrawable);
      }
      ((TextView)paramViewGroup.findViewById(2131304981)).setText(paramView.b);
      paramViewGroup.findViewById(2131299097).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewGroup.findViewById(2131299097).setTag(paramView);
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
        GridView localGridView = (GridView)ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).findViewById(2131309948);
        paramInt2 = localGridView.getChildCount();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          View localView = localGridView.getChildAt(paramInt1);
          if (paramString.equals(((nds)localView.getTag()).jdField_a_of_type_JavaLangString)) {
            ((URLImageView)localView.findViewById(2131301766)).setImageBitmap(paramBitmap);
          }
          paramInt1 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeuk
 * JD-Core Version:    0.7.0.1
 */