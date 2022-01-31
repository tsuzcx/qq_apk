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

public class ahio
  extends akis
{
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<ahin> jdField_a_of_type_JavaUtilArrayList;
  
  public ahio(SearchContactsFragment paramSearchContactsFragment, Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
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
  
  public void a(ArrayList<ahin> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment).clear();
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaUtilArrayList.size(); j = k)
    {
      k = j;
      if (((ahin)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == 0)
      {
        paramArrayList = SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        int m = ((ahin)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_b_of_type_Int;
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
    if (((ahin)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int == 2) {}
    switch (((ahin)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_b_of_type_Int)
    {
    case 80000002: 
    default: 
      return ((ahin)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
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
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131559169, paramViewGroup, false);
        }
        paramView = (TextView)((View)localObject1).findViewById(2131377938);
        if (UniteSearchActivity.d == 12) {
          if (((ahin)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString.equals(alud.a(2131714006))) {
            paramView.setText(swy.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getApplication().getApplicationContext()));
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_JavaLangString = ((ahin)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
          if (AppSetting.c)
          {
            ((View)localObject1).setFocusable(true);
            ((View)localObject1).setContentDescription(paramView.getText() + alud.a(2131714012));
          }
          paramViewGroup = ((View)localObject1).findViewById(2131365369);
          if (paramInt <= 0) {
            break;
          }
          paramViewGroup.setVisibility(0);
          return localObject1;
          paramView.setText(((ahin)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
          continue;
          paramView.setText(((ahin)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
        }
        paramView = (View)localObject1;
      } while (paramInt != 0);
      paramViewGroup.setVisibility(8);
      return localObject1;
    case 3: 
      localObject2 = (ahin)getItem(paramInt);
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = nau.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(), paramViewGroup, 5, false, 1);
      }
      paramView = ((ahin)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
      nau.a((View)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(), ((ahin)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record);
      paramViewGroup = (bbph)((View)localObject1).getTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getResources().getColor(2131166908));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000001, String.valueOf(paramView.name.get())));
      paramViewGroup.jdField_a_of_type_JavaLangString = Long.toString(((ahin)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.code.get());
      paramViewGroup.jdField_c_of_type_Int = 4;
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(a(4, paramViewGroup.jdField_a_of_type_JavaLangString));
      paramViewGroup.jdField_a_of_type_Int = a(paramInt);
      paramViewGroup.jdField_b_of_type_JavaLangString = ((ahin)localObject2).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.bytes_join_group_auth.get().toStringUtf8();
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
      return localObject1;
    case 5: 
      if (paramView == null) {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131562341, paramViewGroup, false);
      }
      break;
    }
    for (;;)
    {
      if ((paramView instanceof QzoneSearchResultView))
      {
        paramViewGroup = (QzoneSearchResultView)paramView;
        localObject1 = (ahin)getItem(paramInt);
        paramViewGroup.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, ((ahin)localObject1).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$ResultItem);
        paramViewGroup.setAvartaView(a(1, paramViewGroup.a()));
        paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        return paramView;
        paramViewGroup = paramView;
        if (paramView == null)
        {
          paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131561255, null);
          paramView = new ahic();
          paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131367546));
          paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131371160));
          paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131377875));
          paramView.d = ((TextView)paramViewGroup.findViewById(2131362922));
          paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363450));
          paramViewGroup.setTag(paramView);
        }
        ahic localahic = (ahic)paramViewGroup.getTag();
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
        ahin localahin = (ahin)getItem(paramInt);
        if (localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord != null) {
          nrt.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F29", "0X8006F29", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_JavaLangString, localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get(), String.valueOf(localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()), "");
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
              localObject2 = localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword.get();
              str1 = localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_description.get();
              localObject1 = localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_title.get();
              localObject3 = localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_cover_url.get();
              paramView = localahin.jdField_b_of_type_JavaLangString;
              SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, (String)localObject2);
              SearchContactsFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, String.valueOf(localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.hotword_type.get()));
              localahic.jdField_b_of_type_JavaLangString = SearchContactsFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
              localahic.jdField_c_of_type_JavaLangString = SearchContactsFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
              if (!TextUtils.isEmpty(localahin.jdField_b_of_type_JavaLangString)) {
                SearchContactsFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment, localahin.jdField_b_of_type_JavaLangString);
              }
              localahic.jdField_c_of_type_AndroidWidgetTextView.setText(str2);
              i = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.getResources().getDimensionPixelSize(2131297310);
              if (TextUtils.isEmpty((CharSequence)localObject3)) {}
            }
            try
            {
              localObject3 = URLDrawable.getDrawable((String)localObject3, i, i);
              localahic.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
              label957:
              localahic.jdField_a_of_type_JavaLangString = paramView;
              if (!"".equals(str1)) {
                localahic.d.setText(str1);
              }
              paramViewGroup.setTag(localahic);
              if (!"".equals(localObject2)) {
                localahic.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, (String)localObject2));
              }
              if (paramInt == 0) {
                if (!"".equals(localObject1)) {
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(localahic.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a()) > 1)
                  {
                    localahic.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
                    label1065:
                    localahic.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, (String)localObject1));
                  }
                }
              }
              for (;;)
              {
                paramView = (ImageView)paramViewGroup.findViewById(2131380134);
                paramView.setVisibility(4);
                localObject1 = (ImageView)paramViewGroup.findViewById(2131364881);
                ((ImageView)localObject1).setVisibility(4);
                if ((localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record != null) && (localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.video_article.has()) && (localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.video_article.get() == ayvm.jdField_a_of_type_Int))
                {
                  paramView.setVisibility(0);
                  ((ImageView)localObject1).getBackground().setAlpha(25);
                  ((ImageView)localObject1).setVisibility(0);
                }
                localObject1 = (TextView)paramViewGroup.findViewById(2131367793);
                ((TextView)localObject1).setVisibility(4);
                paramView = paramViewGroup;
                if (paramInt == 0) {
                  break;
                }
                ((TextView)localObject1).setVisibility(0);
                return paramViewGroup;
                localObject2 = localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.name.get();
                str1 = localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_author.get();
                localObject1 = localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.brief.get();
                localObject3 = localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.title_image.get();
                str2 = localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_create_time.get();
                paramView = localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.article_short_url.get();
                localahic.jdField_a_of_type_Long = localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.account_id.get();
                localahic.jdField_a_of_type_Int = localahin.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record.number.get();
                break label879;
                localahic.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(2);
                break label1065;
                localahic.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                continue;
                if (!"".equals(localObject1))
                {
                  localahic.jdField_b_of_type_AndroidWidgetTextView.setMaxLines(1);
                  localahic.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(80000003, (String)localObject1));
                }
                localahic.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(aepi.a(190.0F, paramViewGroup.getResources()));
                localahic.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
                localahic.d.setMaxLines(1);
              }
              localObject1 = paramView;
              if (paramView == null) {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131560772, paramViewGroup, false);
              }
              ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
              paramView = new ahid();
              paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131367546));
              paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131371160));
              paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131379272));
              paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131365127));
              paramView.d = ((TextView)((View)localObject1).findViewById(2131369796));
              paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((ahin)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
              paramView.jdField_b_of_type_Int = ((ahin)getItem(paramInt)).jdField_b_of_type_Int;
              ((View)localObject1).setTag(paramView);
              paramView = (ahid)((View)localObject1).getTag();
              paramView.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record = ((ahin)getItem(paramInt)).jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$record;
              paramView.jdField_b_of_type_Int = ((ahin)getItem(paramInt)).jdField_b_of_type_Int;
              paramView.jdField_c_of_type_Int = a(paramInt);
              paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a(paramView, (ahin)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
              paramView = (View)localObject1;
              if (!AppSetting.c) {
                break;
              }
              ((View)localObject1).setContentDescription(paramViewGroup);
              return localObject1;
              localObject1 = paramView;
              if (paramView == null) {
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.a().getLayoutInflater().inflate(2131560774, paramViewGroup, false);
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_Ahim == null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_Ahim = new ahim(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment);
              }
              ((View)localObject1).setTag(this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
              ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchContactsFragment.jdField_a_of_type_Ahim);
              paramView = (View)localObject1;
              if (!AppSetting.c) {
                break;
              }
              ((View)localObject1).setContentDescription(alud.a(2131714002) + this.jdField_a_of_type_JavaLangString + alud.a(2131714008));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahio
 * JD-Core Version:    0.7.0.1
 */