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
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;

public class ahyc
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener, odt
{
  private aklg jdField_a_of_type_Aklg = new aklg(paramClassificationSearchFragment.a, this, false);
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahyd(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<odv> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  
  public ahyc(ClassificationSearchFragment paramClassificationSearchFragment)
  {
    a(true);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<odv> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aklg != null) {
      this.jdField_a_of_type_Aklg.a();
    }
  }
  
  public void a(ArrayList<odv> paramArrayList, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment) != null)
    {
      if (getCount() == 0)
      {
        ((TextView)ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).findViewById(2131376928)).setText(amtj.a(2131701068));
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
        paramString = (odv)paramArrayList.next();
        QLog.d("ClassificationSearchFragment", 2, "onGetRecommendSuccess->" + paramString.toString());
      }
      if (TextUtils.isEmpty(paramString)) {
        ((TextView)ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).findViewById(2131376928)).setText(amtj.a(2131701073));
      }
      for (;;)
      {
        ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).setVisibility(0);
        notifyDataSetChanged();
        break;
        ((TextView)ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).findViewById(2131376928)).setText(paramString);
      }
      label271:
      paramString.append("size:").append(paramArrayList.size());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    odr.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.a, paramBoolean, this);
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
    if (paramView == null) {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment.getActivity()).inflate(2131559639, null);
    }
    for (;;)
    {
      odv localodv = (odv)getItem(paramInt);
      if (localodv != null)
      {
        if (this.jdField_a_of_type_Aklg != null)
        {
          Drawable localDrawable = this.jdField_a_of_type_Aklg.a(1008, localodv.jdField_a_of_type_JavaLangString);
          ((URLImageView)paramView.findViewById(2131367927)).setImageDrawable(localDrawable);
        }
        ((TextView)paramView.findViewById(2131371615)).setText(localodv.b);
        paramView.findViewById(2131365035).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView.findViewById(2131365035).setTag(localodv);
        paramView.setTag(localodv);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment) == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      if (((paramBitmap != null) || (paramInt1 <= 0)) && (paramBitmap != null))
      {
        GridView localGridView = (GridView)ClassificationSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactClassificationSearchFragment).findViewById(2131376924);
        paramInt2 = localGridView.getChildCount();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          View localView = localGridView.getChildAt(paramInt1);
          if (paramString.equals(((odv)localView.getTag()).jdField_a_of_type_JavaLangString)) {
            ((URLImageView)localView.findViewById(2131367927)).setImageBitmap(paramBitmap);
          }
          paramInt1 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahyc
 * JD-Core Version:    0.7.0.1
 */