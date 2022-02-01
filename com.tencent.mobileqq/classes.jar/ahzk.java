import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import cooperation.qzone.widget.QzoneSearchResultView;
import java.util.ArrayList;
import java.util.Map;

public class ahzk
  extends aliy
{
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<ahzj> jdField_a_of_type_JavaUtilArrayList;
  
  public ahzk(SearchContactsFragment paramSearchContactsFragment, Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
  }
  
  private int a(int paramInt)
  {
    if (paramInt >= 1)
    {
      if (getItemViewType(paramInt - 1) == 0) {
        return 1;
      }
      if ((paramInt >= 2) && (getItemViewType(paramInt - 2) == 0)) {
        return 2;
      }
    }
    return 3;
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131559255, paramViewGroup, false);
    }
    paramView = (TextView)localView.findViewById(2131378707);
    if (UniteSearchActivity.d == 12) {
      if (((ahzj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString.equals(amtj.a(2131712726)))
      {
        paramView.setText(uex.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getApplication().getApplicationContext()));
        this.jdField_a_of_type_JavaLangString = ((ahzj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
        if (AppSetting.c)
        {
          localView.setFocusable(true);
          localView.setContentDescription(paramView.getText() + amtj.a(2131712732));
        }
        paramView = localView.findViewById(2131365682);
        if (paramInt <= 0) {
          break label212;
        }
        paramView.setVisibility(0);
      }
    }
    label212:
    while (paramInt != 0)
    {
      return localView;
      paramView.setText(((ahzj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
      break;
      paramView.setText(((ahzj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
      break;
    }
    paramView.setVisibility(8);
    return localView;
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ahzj localahzj = (ahzj)getItem(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = nmx.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(), paramViewGroup, 5, false, 1);
    }
    paramView = ((ahzj)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
    nmx.a(localView, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(), localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
    paramViewGroup = (bdym)localView.getTag();
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getResources().getColor(2131167017));
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000001, String.valueOf(paramView.name.get())));
    paramViewGroup.jdField_a_of_type_JavaLangString = Long.toString(localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
    paramViewGroup.jdField_c_of_type_Int = 4;
    paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(4, paramViewGroup.jdField_a_of_type_JavaLangString));
    paramViewGroup.jdField_a_of_type_Int = a(paramInt);
    paramViewGroup.jdField_b_of_type_JavaLangString = localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.bytes_join_group_auth.get().toStringUtf8();
    paramViewGroup.jdField_a_of_type_Boolean = localahzj.jdField_a_of_type_Boolean;
    localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
    return localView;
  }
  
  private View c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131562493, paramViewGroup, false);
    }
    for (;;)
    {
      if ((paramView instanceof QzoneSearchResultView))
      {
        paramViewGroup = (QzoneSearchResultView)paramView;
        ahzj localahzj = (ahzj)getItem(paramInt);
        paramViewGroup.bindData(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$ResultItem);
        paramViewGroup.setAvartaView(a(1, paramViewGroup.getUin()));
        paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
      }
      return paramView;
    }
  }
  
  private View d(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131561404, null);
      paramView = new ahyy();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367958));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131371790));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378646));
      paramView.d = ((TextView)paramViewGroup.findViewById(2131363073));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363702));
      paramViewGroup.setTag(paramView);
    }
    ahyy localahyy = (ahyy)paramViewGroup.getTag();
    paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
    ahzj localahzj = (ahzj)getItem(paramInt);
    if (localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) {
      odq.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F29", "0X8006F29", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_JavaLangString, localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
    }
    for (paramInt = 1;; paramInt = 0)
    {
      String str3 = "";
      String str1;
      String str2;
      Object localObject1;
      Object localObject2;
      if (paramInt != 0)
      {
        str1 = localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get();
        str2 = localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_description.get();
        localObject1 = localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_title.get();
        localObject2 = localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_cover_url.get();
        paramView = localahzj.jdField_b_of_type_JavaLangString;
        SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, str1);
        SearchContactsFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, String.valueOf(localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()));
        localahyy.jdField_b_of_type_JavaLangString = SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        localahyy.jdField_c_of_type_JavaLangString = SearchContactsFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(localahzj.jdField_b_of_type_JavaLangString)) {
          SearchContactsFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, localahzj.jdField_b_of_type_JavaLangString);
        }
        localahyy.jdField_c_of_type_AndroidWidgetTextView.setText(str3);
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.getResources().getDimensionPixelSize(2131297456);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
        try
        {
          localObject2 = URLDrawable.getDrawable((String)localObject2, i, i);
          localahyy.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          label398:
          localahyy.jdField_a_of_type_JavaLangString = paramView;
          if (!"".equals(str2)) {
            localahyy.d.setText(str2);
          }
          paramViewGroup.setTag(localahyy);
          if (!"".equals(str1)) {
            localahyy.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, str1));
          }
          if (paramInt == 0) {
            if (!"".equals(localObject1)) {
              if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(localahyy.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a()) > 1)
              {
                localahyy.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
                label506:
                localahyy.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, (String)localObject1));
              }
            }
          }
          for (;;)
          {
            paramView = (ImageView)paramViewGroup.findViewById(2131380989);
            paramView.setVisibility(4);
            localObject1 = (ImageView)paramViewGroup.findViewById(2131365187);
            ((ImageView)localObject1).setVisibility(4);
            if ((localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null) && (localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.video_article.has()) && (localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.video_article.get() == bbgk.jdField_a_of_type_Int))
            {
              paramView.setVisibility(0);
              ((ImageView)localObject1).getBackground().setAlpha(25);
              ((ImageView)localObject1).setVisibility(0);
            }
            paramView = (TextView)paramViewGroup.findViewById(2131368208);
            paramView.setVisibility(4);
            if (paramInt != 0) {
              paramView.setVisibility(0);
            }
            return paramViewGroup;
            str1 = localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get();
            str2 = localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_author.get();
            localObject1 = localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.brief.get();
            localObject2 = localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.title_image.get();
            str3 = localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_create_time.get();
            paramView = localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_short_url.get();
            localahyy.jdField_a_of_type_Long = localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.account_id.get();
            localahyy.jdField_a_of_type_Int = localahzj.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.number.get();
            break;
            localahyy.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
            break label506;
            localahyy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            continue;
            if (!"".equals(localObject1))
            {
              localahyy.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
              localahyy.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, (String)localObject1));
            }
            localahyy.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(AIOUtils.dp2px(190.0F, paramViewGroup.getResources()));
            localahyy.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
            localahyy.d.setMaxLines(1);
          }
        }
        catch (Exception localException)
        {
          break label398;
        }
      }
    }
  }
  
  private View e(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131560877, paramViewGroup, false);
    }
    localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
    paramView = new ahyz();
    paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367958));
    paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371790));
    paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131380110));
    paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365443));
    paramView.d = ((TextView)localView.findViewById(2131370302));
    paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((ahzj)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
    paramView.jdField_b_of_type_Int = ((ahzj)getItem(paramInt)).jdField_b_of_type_Int;
    localView.setTag(paramView);
    paramView = (ahyz)localView.getTag();
    paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((ahzj)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
    paramView.jdField_b_of_type_Int = ((ahzj)getItem(paramInt)).jdField_b_of_type_Int;
    paramView.jdField_c_of_type_Int = a(paramInt);
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(paramView, (ahzj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    if (AppSetting.c) {
      localView.setContentDescription(paramView);
    }
    return localView;
  }
  
  private View f(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131560879, paramViewGroup, false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_Ahzi == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_Ahzi = new ahzi(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
    }
    localView.setTag(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_Ahzi);
    if (AppSetting.c) {
      localView.setContentDescription(amtj.a(2131712722) + this.jdField_a_of_type_JavaLangString + amtj.a(2131712728));
    }
    return localView;
  }
  
  public void a(ArrayList<ahzj> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment).clear();
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilArrayList.size(); j = k)
    {
      k = j;
      if (((ahzj)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == 0)
      {
        paramArrayList = SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        int m = ((ahzj)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_b_of_type_Int;
        k = j + 1;
        paramArrayList.put(Integer.valueOf(m), Integer.valueOf(k));
      }
      i += 1;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (((ahzj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {}
    switch (((ahzj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_b_of_type_Int)
    {
    case 80000002: 
    default: 
      return ((ahzj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    case 80000001: 
      return 3;
    case 80000003: 
      return 4;
    }
    return 5;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = a(paramInt, paramView, paramViewGroup);
      continue;
      paramView = b(paramInt, paramView, paramViewGroup);
      continue;
      paramView = c(paramInt, paramView, paramViewGroup);
      continue;
      paramView = d(paramInt, paramView, paramViewGroup);
      continue;
      paramView = e(paramInt, paramView, paramViewGroup);
      continue;
      paramView = f(paramInt, paramView, paramViewGroup);
    }
  }
  
  public int getViewTypeCount()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzk
 * JD-Core Version:    0.7.0.1
 */