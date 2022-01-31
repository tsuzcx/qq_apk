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
import com.tencent.widget.ListView;
import cooperation.qzone.widget.QzoneSearchResultView;
import java.util.ArrayList;
import java.util.Map;

public class afgw
  extends aimu
{
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<afgv> jdField_a_of_type_JavaUtilArrayList;
  
  public afgw(SearchContactsFragment paramSearchContactsFragment, Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
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
  
  public void a(ArrayList<afgv> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment).clear();
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilArrayList.size(); j = k)
    {
      k = j;
      if (((afgv)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == 0)
      {
        paramArrayList = SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        int m = ((afgv)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_b_of_type_Int;
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
    if (((afgv)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {}
    switch (((afgv)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_b_of_type_Int)
    {
    case 80000002: 
    default: 
      return ((afgv)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    case 80000001: 
      return 3;
    case 80000003: 
      return 4;
    }
    return 5;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    switch (getItemViewType(paramInt))
    {
    default: 
    case 0: 
      do
      {
        return paramView;
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131559127, paramViewGroup, false);
        }
        paramView = (TextView)((View)localObject1).findViewById(2131377350);
        if (UniteSearchActivity.d == 12) {
          if (((afgv)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString.equals(ajyc.a(2131713611))) {
            paramView.setText(sfh.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getApplication().getApplicationContext()));
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_JavaLangString = ((afgv)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
          if (AppSetting.d)
          {
            ((View)localObject1).setFocusable(true);
            ((View)localObject1).setContentDescription(paramView.getText() + ajyc.a(2131713617));
          }
          paramViewGroup = ((View)localObject1).findViewById(2131365283);
          if (paramInt <= 0) {
            break;
          }
          paramViewGroup.setVisibility(0);
          return localObject1;
          paramView.setText(((afgv)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
          continue;
          paramView.setText(((afgv)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
        }
        paramView = (View)localObject1;
      } while (paramInt != 0);
      paramViewGroup.setVisibility(8);
      return localObject1;
    case 3: 
      localObject2 = (afgv)getItem(paramInt);
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = myd.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(), paramViewGroup, 5, false, 1);
      }
      paramView = ((afgv)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
      myd.a((View)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(), ((afgv)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
      paramViewGroup = (azmn)((View)localObject1).getTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getResources().getColor(2131166859));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000001, String.valueOf(paramView.name.get())));
      paramViewGroup.jdField_a_of_type_JavaLangString = Long.toString(((afgv)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
      paramViewGroup.jdField_c_of_type_Int = 4;
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(4, paramViewGroup.jdField_a_of_type_JavaLangString));
      paramViewGroup.jdField_a_of_type_Int = a(paramInt);
      paramViewGroup.jdField_b_of_type_JavaLangString = ((afgv)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.bytes_join_group_auth.get().toStringUtf8();
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
      return localObject1;
    case 5: 
      if (paramView == null) {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131562132, paramViewGroup, false);
      }
      break;
    }
    for (;;)
    {
      if ((paramView instanceof QzoneSearchResultView))
      {
        paramViewGroup = (QzoneSearchResultView)paramView;
        localObject1 = (afgv)getItem(paramInt);
        paramViewGroup.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, ((afgv)localObject1).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$ResultItem);
        paramViewGroup.setAvartaView(a(1, paramViewGroup.a()));
        paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        return paramView;
        paramViewGroup = paramView;
        if (paramView == null)
        {
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131561052, null);
          paramView = new afgk();
          paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367407));
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370830));
          paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131377291));
          paramView.d = ((TextView)paramViewGroup.findViewById(2131362888));
          paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363412));
          paramViewGroup.setTag(paramView);
        }
        afgk localafgk = (afgk)paramViewGroup.getTag();
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        afgv localafgv = (afgv)getItem(paramInt);
        if (localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) {
          noo.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F29", "0X8006F29", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_JavaLangString, localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
        }
        for (paramInt = 1;; paramInt = 0) {
          for (;;)
          {
            String str2 = "";
            String str1;
            Object localObject3;
            label879:
            int i;
            if (paramInt != 0)
            {
              localObject2 = localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get();
              str1 = localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_description.get();
              localObject1 = localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_title.get();
              localObject3 = localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_cover_url.get();
              paramView = localafgv.jdField_b_of_type_JavaLangString;
              SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, (String)localObject2);
              SearchContactsFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, String.valueOf(localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()));
              localafgk.jdField_b_of_type_JavaLangString = SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
              localafgk.jdField_c_of_type_JavaLangString = SearchContactsFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
              if (!TextUtils.isEmpty(localafgv.jdField_b_of_type_JavaLangString)) {
                SearchContactsFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, localafgv.jdField_b_of_type_JavaLangString);
              }
              localafgk.jdField_c_of_type_AndroidWidgetTextView.setText(str2);
              i = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.getResources().getDimensionPixelSize(2131297291);
              if (TextUtils.isEmpty((CharSequence)localObject3)) {}
            }
            try
            {
              localObject3 = URLDrawable.getDrawable((String)localObject3, i, i);
              localafgk.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
              label957:
              localafgk.jdField_a_of_type_JavaLangString = paramView;
              if (!"".equals(str1)) {
                localafgk.d.setText(str1);
              }
              paramViewGroup.setTag(localafgk);
              if (!"".equals(localObject2)) {
                localafgk.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, (String)localObject2));
              }
              if (paramInt == 0) {
                if (!"".equals(localObject1)) {
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(localafgk.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a()) > 1)
                  {
                    localafgk.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
                    label1065:
                    localafgk.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, (String)localObject1));
                  }
                }
              }
              for (;;)
              {
                paramView = (ImageView)paramViewGroup.findViewById(2131379357);
                paramView.setVisibility(4);
                localObject1 = (ImageView)paramViewGroup.findViewById(2131364799);
                ((ImageView)localObject1).setVisibility(4);
                if ((localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null) && (localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.video_article.has()) && (localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.video_article.get() == awvy.jdField_a_of_type_Int))
                {
                  paramView.setVisibility(0);
                  ((ImageView)localObject1).getBackground().setAlpha(25);
                  ((ImageView)localObject1).setVisibility(0);
                }
                localObject1 = (TextView)paramViewGroup.findViewById(2131367654);
                ((TextView)localObject1).setVisibility(4);
                paramView = paramViewGroup;
                if (paramInt == 0) {
                  break;
                }
                ((TextView)localObject1).setVisibility(0);
                return paramViewGroup;
                localObject2 = localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get();
                str1 = localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_author.get();
                localObject1 = localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.brief.get();
                localObject3 = localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.title_image.get();
                str2 = localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_create_time.get();
                paramView = localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_short_url.get();
                localafgk.jdField_a_of_type_Long = localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.account_id.get();
                localafgk.jdField_a_of_type_Int = localafgv.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.number.get();
                break label879;
                localafgk.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
                break label1065;
                localafgk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                continue;
                if (!"".equals(localObject1))
                {
                  localafgk.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
                  localafgk.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, (String)localObject1));
                }
                localafgk.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(actn.a(190.0F, paramViewGroup.getResources()));
                localafgk.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
                localafgk.d.setMaxLines(1);
              }
              localObject1 = paramView;
              if (paramView == null) {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131560579, paramViewGroup, false);
              }
              ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
              paramView = new afgl();
              paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131367407));
              paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131370830));
              paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131378594));
              paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131365041));
              paramView.d = ((TextView)((View)localObject1).findViewById(2131369516));
              paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((afgv)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
              paramView.jdField_b_of_type_Int = ((afgv)getItem(paramInt)).jdField_b_of_type_Int;
              ((View)localObject1).setTag(paramView);
              paramView = (afgl)((View)localObject1).getTag();
              paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((afgv)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
              paramView.jdField_b_of_type_Int = ((afgv)getItem(paramInt)).jdField_b_of_type_Int;
              paramView.jdField_c_of_type_Int = a(paramInt);
              paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(paramView, (afgv)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
              paramView = (View)localObject1;
              if (!AppSetting.d) {
                break;
              }
              ((View)localObject1).setContentDescription(paramViewGroup);
              return localObject1;
              localObject1 = paramView;
              if (paramView == null) {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131560581, paramViewGroup, false);
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_Afgu == null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_Afgu = new afgu(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
              }
              ((View)localObject1).setTag(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
              ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_Afgu);
              paramView = (View)localObject1;
              if (!AppSetting.d) {
                break;
              }
              ((View)localObject1).setContentDescription(ajyc.a(2131713607) + this.jdField_a_of_type_JavaLangString + ajyc.a(2131713613));
              return localObject1;
            }
            catch (Exception localException)
            {
              break label957;
            }
          }
        }
      }
      return paramView;
    }
  }
  
  public int getViewTypeCount()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afgw
 * JD-Core Version:    0.7.0.1
 */