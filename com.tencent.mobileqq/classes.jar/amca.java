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
import com.tencent.mobileqq.app.addfriendverifi.data.AddFriendBlockedInfo;
import com.tencent.mobileqq.app.addfriendverifi.ui.NewFriendVerifyBlockedListFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.ThemeImageView;
import java.util.List;
import java.util.Locale;

public class amca
  extends BaseAdapter
  implements View.OnClickListener
{
  private amca(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  private void a(amcb paramamcb, View.OnClickListener paramOnClickListener)
  {
    if (paramamcb.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo == null) {
      return;
    }
    if (TextUtils.isEmpty(paramamcb.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_b_of_type_JavaLangString))
    {
      paramamcb.jdField_a_of_type_AndroidWidgetTextView.setText(paramamcb.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_a_of_type_JavaLangString);
      a(paramamcb, paramamcb.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_a_of_type_JavaLangString);
      paramamcb.jdField_a_of_type_AndroidWidgetImageView.setTag(paramamcb);
      ahgy.a(paramamcb.e, paramamcb.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_b_of_type_Int, paramamcb.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_a_of_type_Int, null);
      paramOnClickListener = paramamcb.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_c_of_type_JavaLangString;
      if (TextUtils.isEmpty(paramOnClickListener)) {
        break label210;
      }
      paramOnClickListener = String.format(Locale.getDefault(), alpo.a(2131707881), new Object[] { paramOnClickListener });
      paramamcb.c.setText(paramOnClickListener);
      paramamcb.c.setVisibility(0);
      label128:
      int i = paramamcb.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_c_of_type_Int;
      if (i <= 0) {
        break label222;
      }
      paramOnClickListener = String.format(Locale.getDefault(), "%d位共同好友", new Object[] { Integer.valueOf(i) });
      paramamcb.b.setVisibility(0);
      paramamcb.b.setText(paramOnClickListener);
    }
    for (;;)
    {
      paramamcb.jdField_a_of_type_AndroidWidgetButton.setTag(paramamcb);
      paramamcb.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
      paramamcb.jdField_a_of_type_AndroidWidgetTextView.setText(paramamcb.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_b_of_type_JavaLangString);
      break;
      label210:
      paramamcb.c.setVisibility(8);
      break label128;
      label222:
      paramamcb.b.setVisibility(8);
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
      paramView.setBackgroundResource(2130839218);
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839216);
      return;
    }
    paramView.setBackgroundResource(2130839213);
  }
  
  public AddFriendBlockedInfo a(int paramInt)
  {
    return (AddFriendBlockedInfo)NewFriendVerifyBlockedListFragment.a(this.a).get(paramInt);
  }
  
  public void a()
  {
    NewFriendVerifyBlockedListFragment.a(this.a).a();
    NewFriendVerifyBlockedListFragment.a(this.a).c();
  }
  
  public void a(amcb paramamcb, String paramString)
  {
    if ((paramamcb == null) || (paramamcb.jdField_a_of_type_AndroidWidgetImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Bitmap localBitmap = NewFriendVerifyBlockedListFragment.a(this.a).a(1, paramString);
    if ((localBitmap == null) && (!NewFriendVerifyBlockedListFragment.a(this.a).a())) {
      NewFriendVerifyBlockedListFragment.a(this.a).a(paramString, 1, true);
    }
    paramString = localBitmap;
    if (localBitmap == null) {
      paramString = bdda.a();
    }
    paramamcb.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString);
  }
  
  public void b()
  {
    if (NewFriendVerifyBlockedListFragment.a(this.a).a()) {
      NewFriendVerifyBlockedListFragment.a(this.a).b();
    }
  }
  
  public void c()
  {
    int j = NewFriendVerifyBlockedListFragment.a(this.a).getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = NewFriendVerifyBlockedListFragment.a(this.a).getChildAt(i).getTag();
      if ((localObject instanceof amcb))
      {
        localObject = (amcb)localObject;
        a((amcb)localObject, ((amcb)localObject).jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_a_of_type_JavaLangString);
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
    if (paramView == null)
    {
      paramViewGroup = new amcb(this);
      paramView = LayoutInflater.from(NewFriendVerifyBlockedListFragment.a(this.a)).inflate(2131561318, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361795));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371142));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131375678));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131362215));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131376845));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131375675));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131375665));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView;
      paramView.setOnClickListener(this);
      a(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView);
      paramView.setTag(paramViewGroup);
      AddFriendBlockedInfo localAddFriendBlockedInfo = a(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo = localAddFriendBlockedInfo;
      if (localAddFriendBlockedInfo.jdField_a_of_type_Boolean) {
        break label193;
      }
      a(paramViewGroup.jdField_a_of_type_AndroidViewView, true);
    }
    for (;;)
    {
      a(paramViewGroup, this);
      return paramView;
      paramViewGroup = (amcb)paramView.getTag();
      break;
      label193:
      a(paramViewGroup.jdField_a_of_type_AndroidViewView, false);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          paramView = paramView.getTag();
        } while ((paramView == null) || (!(paramView instanceof amcb)));
        paramView = ((amcb)paramView).jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo;
      } while (paramView == null);
      if (QLog.isColorLevel()) {
        QLog.d("BlockedListFragment", 2, "onClick rlSystemMsg， friendtype=" + 109);
      }
      localObject = new ProfileActivity.AllInOne(paramView.jdField_a_of_type_JavaLangString, 109);
      if (!TextUtils.isEmpty(paramView.jdField_b_of_type_JavaLangString)) {}
      for (((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = paramView.jdField_b_of_type_JavaLangString;; ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = paramView.jdField_a_of_type_JavaLangString)
      {
        ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 120;
        ProfileActivity.a(NewFriendVerifyBlockedListFragment.a(this.a), (ProfileActivity.AllInOne)localObject, 100);
        azmj.b(null, "dc00898", "", "", "0X800A3A8", "0X800A3A8", 0, 0, "", "", "", "");
        return;
      }
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof amcb)));
    if (!bdee.g(NewFriendVerifyBlockedListFragment.a(this.a)))
    {
      QQToast.a(NewFriendVerifyBlockedListFragment.a(this.a), NewFriendVerifyBlockedListFragment.a(this.a).getResources().getString(2131692397), 0).b(NewFriendVerifyBlockedListFragment.a(this.a).getTitleBarHeight());
      return;
    }
    Object localObject = ((amcb)paramView).jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo;
    if (!TextUtils.isEmpty(((AddFriendBlockedInfo)localObject).jdField_b_of_type_JavaLangString)) {}
    for (paramView = ((AddFriendBlockedInfo)localObject).jdField_b_of_type_JavaLangString;; paramView = ((AddFriendBlockedInfo)localObject).jdField_a_of_type_JavaLangString)
    {
      paramView = AddFriendLogicActivity.a(NewFriendVerifyBlockedListFragment.a(this.a), 1, ((AddFriendBlockedInfo)localObject).jdField_a_of_type_JavaLangString, null, 3041, 15, paramView, null, null, NewFriendVerifyBlockedListFragment.a(this.a).getString(2131689628), null);
      NewFriendVerifyBlockedListFragment.a(this.a).startActivityForResult(paramView, 100);
      azmj.b(null, "dc00898", "", "", "0X800A3A7", "0X800A3A7", 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amca
 * JD-Core Version:    0.7.0.1
 */