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
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.ThemeImageView;
import java.util.List;
import java.util.Locale;

public class ajwb
  extends BaseAdapter
  implements View.OnClickListener
{
  private ajwb(NewFriendVerifyBlockedListFragment paramNewFriendVerifyBlockedListFragment) {}
  
  private void a(ajwc paramajwc, View.OnClickListener paramOnClickListener)
  {
    if (paramajwc.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo == null) {
      return;
    }
    if (TextUtils.isEmpty(paramajwc.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_b_of_type_JavaLangString))
    {
      paramajwc.jdField_a_of_type_AndroidWidgetTextView.setText(paramajwc.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_a_of_type_JavaLangString);
      a(paramajwc, paramajwc.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_a_of_type_JavaLangString);
      paramajwc.jdField_a_of_type_AndroidWidgetImageView.setTag(paramajwc);
      aeyf.a(paramajwc.e, paramajwc.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_b_of_type_Int, paramajwc.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_a_of_type_Int, null);
      paramOnClickListener = paramajwc.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_c_of_type_JavaLangString;
      if (TextUtils.isEmpty(paramOnClickListener)) {
        break label210;
      }
      paramOnClickListener = String.format(Locale.getDefault(), ajjy.a(2131641713), new Object[] { paramOnClickListener });
      paramajwc.c.setText(paramOnClickListener);
      paramajwc.c.setVisibility(0);
      label128:
      int i = paramajwc.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_c_of_type_Int;
      if (i <= 0) {
        break label222;
      }
      paramOnClickListener = String.format(Locale.getDefault(), "%d位共同好友", new Object[] { Integer.valueOf(i) });
      paramajwc.b.setVisibility(0);
      paramajwc.b.setText(paramOnClickListener);
    }
    for (;;)
    {
      paramajwc.jdField_a_of_type_AndroidWidgetButton.setTag(paramajwc);
      paramajwc.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
      paramajwc.jdField_a_of_type_AndroidWidgetTextView.setText(paramajwc.jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_b_of_type_JavaLangString);
      break;
      label210:
      paramajwc.c.setVisibility(8);
      break label128;
      label222:
      paramajwc.b.setVisibility(8);
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
      paramView.setBackgroundResource(2130839106);
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839104);
      return;
    }
    paramView.setBackgroundResource(2130839101);
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
  
  public void a(ajwc paramajwc, String paramString)
  {
    if ((paramajwc == null) || (paramajwc.jdField_a_of_type_AndroidWidgetImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Bitmap localBitmap = NewFriendVerifyBlockedListFragment.a(this.a).a(1, paramString);
    if ((localBitmap == null) && (!NewFriendVerifyBlockedListFragment.a(this.a).a())) {
      NewFriendVerifyBlockedListFragment.a(this.a).a(paramString, 1, true);
    }
    paramString = localBitmap;
    if (localBitmap == null) {
      paramString = bacm.a();
    }
    paramajwc.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramString);
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
      if ((localObject instanceof ajwc))
      {
        localObject = (ajwc)localObject;
        a((ajwc)localObject, ((ajwc)localObject).jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo.jdField_a_of_type_JavaLangString);
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
      paramViewGroup = new ajwc(this);
      paramView = LayoutInflater.from(NewFriendVerifyBlockedListFragment.a(this.a)).inflate(2131495544, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296259));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131305159));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131309446));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131296655));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131310547));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131309443));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131309433));
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
      paramViewGroup = (ajwc)paramView.getTag();
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
        } while ((paramView == null) || (!(paramView instanceof ajwc)));
        paramView = ((ajwc)paramView).jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo;
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
        awqx.b(null, "dc00898", "", "", "0X800A3A8", "0X800A3A8", 0, 0, "", "", "", "");
        return;
      }
      paramView = paramView.getTag();
    } while ((paramView == null) || (!(paramView instanceof ajwc)));
    if (!badq.g(NewFriendVerifyBlockedListFragment.a(this.a)))
    {
      bbmy.a(NewFriendVerifyBlockedListFragment.a(this.a), NewFriendVerifyBlockedListFragment.a(this.a).getResources().getString(2131626719), 0).b(NewFriendVerifyBlockedListFragment.a(this.a).getTitleBarHeight());
      return;
    }
    Object localObject = ((ajwc)paramView).jdField_a_of_type_ComTencentMobileqqAppAddfriendverifiDataAddFriendBlockedInfo;
    if (!TextUtils.isEmpty(((AddFriendBlockedInfo)localObject).jdField_b_of_type_JavaLangString)) {}
    for (paramView = ((AddFriendBlockedInfo)localObject).jdField_b_of_type_JavaLangString;; paramView = ((AddFriendBlockedInfo)localObject).jdField_a_of_type_JavaLangString)
    {
      paramView = AddFriendLogicActivity.a(NewFriendVerifyBlockedListFragment.a(this.a), 1, ((AddFriendBlockedInfo)localObject).jdField_a_of_type_JavaLangString, null, 3041, 15, paramView, null, null, NewFriendVerifyBlockedListFragment.a(this.a).getString(2131624088), null);
      NewFriendVerifyBlockedListFragment.a(this.a).startActivityForResult(paramView, 100);
      awqx.b(null, "dc00898", "", "", "0X800A3A7", "0X800A3A7", 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajwb
 * JD-Core Version:    0.7.0.1
 */