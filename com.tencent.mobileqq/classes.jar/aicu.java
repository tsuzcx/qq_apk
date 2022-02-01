import android.content.Intent;
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
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.addfriendverifi.AddFriendBlockedInfo;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerifyBlockedListFragment;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.ThemeImageView;
import java.util.List;
import java.util.Locale;

public class aicu
  extends BaseAdapter
  implements View.OnClickListener
{
  private aicu(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  private void a(aicv paramaicv, View.OnClickListener paramOnClickListener)
  {
    if (paramaicv.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo == null) {
      return;
    }
    if (TextUtils.isEmpty(paramaicv.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_b_of_type_JavaLangString))
    {
      paramaicv.jdField_a_of_type_AndroidWidgetTextView.setText(paramaicv.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_a_of_type_JavaLangString);
      a(paramaicv, paramaicv.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_a_of_type_JavaLangString);
      paramaicv.jdField_a_of_type_AndroidWidgetImageView.setTag(paramaicv);
      aiea.a(paramaicv.e, paramaicv.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_b_of_type_Int, paramaicv.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_a_of_type_Int, null);
      paramOnClickListener = paramaicv.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_c_of_type_JavaLangString;
      if (TextUtils.isEmpty(paramOnClickListener)) {
        break label210;
      }
      paramOnClickListener = String.format(Locale.getDefault(), amtj.a(2131706621), new Object[] { paramOnClickListener });
      paramaicv.c.setText(paramOnClickListener);
      paramaicv.c.setVisibility(0);
      label128:
      int i = paramaicv.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_c_of_type_Int;
      if (i <= 0) {
        break label222;
      }
      paramOnClickListener = String.format(Locale.getDefault(), "%d位共同好友", new Object[] { Integer.valueOf(i) });
      paramaicv.b.setVisibility(0);
      paramaicv.b.setText(paramOnClickListener);
    }
    for (;;)
    {
      paramaicv.jdField_a_of_type_AndroidWidgetButton.setTag(paramaicv);
      paramaicv.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
      paramaicv.jdField_a_of_type_AndroidWidgetTextView.setText(paramaicv.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_b_of_type_JavaLangString);
      break;
      label210:
      paramaicv.c.setVisibility(8);
      break label128;
      label222:
      paramaicv.b.setVisibility(8);
    }
  }
  
  private void a(View paramView)
  {
    if ((paramView instanceof ThemeImageView)) {
      ((ThemeImageView)paramView).setSupportMaskView(true);
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130839439);
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839437);
      return;
    }
    paramView.setBackgroundResource(2130839434);
  }
  
  public AddFriendBlockedInfo a(int paramInt)
  {
    return (AddFriendBlockedInfo)NewFriendVerifyBlockedListFragment.a(this.a).get(paramInt);
  }
  
  public void a()
  {
    NewFriendVerifyBlockedListFragment.a(this.a).cancelPendingRequests();
    NewFriendVerifyBlockedListFragment.a(this.a).pause();
  }
  
  public void a(aicv paramaicv, String paramString)
  {
    if ((paramaicv == null) || (paramaicv.jdField_a_of_type_AndroidWidgetImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Bitmap localBitmap = NewFriendVerifyBlockedListFragment.a(this.a).getBitmapFromCache(1, paramString);
    if ((localBitmap == null) && (!NewFriendVerifyBlockedListFragment.a(this.a).isPausing())) {
      NewFriendVerifyBlockedListFragment.a(this.a).requestDecodeFace(paramString, 1, true);
    }
    paramString = localBitmap;
    if (localBitmap == null) {
      paramString = bfvo.a();
    }
    paramaicv.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString);
  }
  
  public void b()
  {
    if (NewFriendVerifyBlockedListFragment.a(this.a).isPausing()) {
      NewFriendVerifyBlockedListFragment.a(this.a).resume();
    }
  }
  
  public void c()
  {
    int j = NewFriendVerifyBlockedListFragment.a(this.a).getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = NewFriendVerifyBlockedListFragment.a(this.a).getChildAt(i).getTag();
      if ((localObject instanceof aicv))
      {
        localObject = (aicv)localObject;
        a((aicv)localObject, ((aicv)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo.jdField_a_of_type_JavaLangString);
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    if (NewFriendVerifyBlockedListFragment.a(this.a) == null) {
      return 0;
    }
    return NewFriendVerifyBlockedListFragment.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      paramView = new aicv(this);
      localView = LayoutInflater.from(NewFriendVerifyBlockedListFragment.a(this.a)).inflate(2131561488, null);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361795));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371791));
      paramView.b = ((TextView)localView.findViewById(2131376354));
      paramView.e = ((TextView)localView.findViewById(2131362305));
      paramView.c = ((TextView)localView.findViewById(2131377631));
      paramView.d = ((TextView)localView.findViewById(2131376351));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131376341));
      paramView.jdField_a_of_type_AndroidViewView = localView;
      localView.setOnClickListener(this);
      a(paramView.jdField_a_of_type_AndroidWidgetImageView);
      localView.setTag(paramView);
      localObject = a(paramInt);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo = ((AddFriendBlockedInfo)localObject);
      if (((AddFriendBlockedInfo)localObject).jdField_a_of_type_Boolean) {
        break label227;
      }
      a(paramView.jdField_a_of_type_AndroidViewView, true);
    }
    for (;;)
    {
      a(paramView, this);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (aicv)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label227:
      a(paramView.jdField_a_of_type_AndroidViewView, false);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject1 = paramView.getTag();
      if ((localObject1 != null) && ((localObject1 instanceof aicv)))
      {
        localObject1 = ((aicv)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo;
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BlockedListFragment", 2, "onClick rlSystemMsg， friendtype=" + 109);
          }
          localObject2 = new ProfileActivity.AllInOne(((AddFriendBlockedInfo)localObject1).jdField_a_of_type_JavaLangString, 109);
          if (!TextUtils.isEmpty(((AddFriendBlockedInfo)localObject1).jdField_b_of_type_JavaLangString)) {}
          for (((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ((AddFriendBlockedInfo)localObject1).jdField_b_of_type_JavaLangString;; ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_JavaLangString = ((AddFriendBlockedInfo)localObject1).jdField_a_of_type_JavaLangString)
          {
            ((ProfileActivity.AllInOne)localObject2).jdField_h_of_type_Int = 120;
            ProfileActivity.a(NewFriendVerifyBlockedListFragment.a(this.a), (ProfileActivity.AllInOne)localObject2, 100);
            bcef.b(null, "dc00898", "", "", "0X800A3A8", "0X800A3A8", 0, 0, "", "", "", "");
            break;
          }
          localObject1 = paramView.getTag();
          if ((localObject1 != null) && ((localObject1 instanceof aicv)))
          {
            if (NetworkUtil.isNetworkAvailable(NewFriendVerifyBlockedListFragment.a(this.a))) {
              break;
            }
            QQToast.a(NewFriendVerifyBlockedListFragment.a(this.a), NewFriendVerifyBlockedListFragment.a(this.a).getResources().getString(2131692035), 0).b(NewFriendVerifyBlockedListFragment.a(this.a).getTitleBarHeight());
          }
        }
      }
    }
    Object localObject2 = ((aicv)localObject1).jdField_a_of_type_ComTencentMobileqqActivityContactAddfriendverifiAddFriendBlockedInfo;
    if (!TextUtils.isEmpty(((AddFriendBlockedInfo)localObject2).jdField_b_of_type_JavaLangString)) {}
    for (Object localObject1 = ((AddFriendBlockedInfo)localObject2).jdField_b_of_type_JavaLangString;; localObject1 = ((AddFriendBlockedInfo)localObject2).jdField_a_of_type_JavaLangString)
    {
      localObject1 = AddFriendLogicActivity.a(NewFriendVerifyBlockedListFragment.a(this.a), 1, ((AddFriendBlockedInfo)localObject2).jdField_a_of_type_JavaLangString, null, 3041, 15, (String)localObject1, null, null, NewFriendVerifyBlockedListFragment.a(this.a).getString(2131689550), null);
      NewFriendVerifyBlockedListFragment.a(this.a).startActivityForResult((Intent)localObject1, 100);
      bcef.b(null, "dc00898", "", "", "0X800A3A7", "0X800A3A7", 0, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicu
 * JD-Core Version:    0.7.0.1
 */