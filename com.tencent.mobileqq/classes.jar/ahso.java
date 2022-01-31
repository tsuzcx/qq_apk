import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.search.SearchInfoInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.adapter.SubBusinessSearchAdapter;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import pb.unite.search.DynamicTabSearch.SubHotWord;

public class ahso
  extends UniteSearchObserver
{
  public ahso(ActiveEntitySearchFragment paramActiveEntitySearchFragment) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    if (!TextUtils.equals(paramString2, this.a.jdField_d_of_type_JavaLangString)) {}
    while ((!ActiveEntitySearchFragment.a(this.a.jdField_a_of_type_ArrayOfLong, paramArrayOfLong)) || (!this.a.jdField_b_of_type_JavaLangString.equals(paramString1))) {
      return;
    }
    this.a.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.a.jdField_e_of_type_Boolean = false;
    this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
    if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.a.g.setVisibility(0);
      if (this.a.jdField_a_of_type_AndroidGraphicsBitmap != null) {}
    }
    for (;;)
    {
      try
      {
        this.a.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(this.a.getResources(), 2130840371);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.a.jdField_a_of_type_AndroidGraphicsBitmap);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setText("网络异常，点击重试");
        this.a.g.setOnClickListener(new ahsp(this));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchError code=" + paramInt + " mask;" + Arrays.toString(paramArrayOfLong) + " key=" + paramString1 + " name=" + this.a.jdField_e_of_type_JavaLangString);
        return;
      }
      catch (OutOfMemoryError paramString2)
      {
        QLog.e(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 1, paramString2, new Object[0]);
        continue;
      }
      this.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new ahsq(this));
    }
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List paramList1, long[] paramArrayOfLong, String paramString3, List paramList2, boolean paramBoolean3)
  {
    if (!TextUtils.equals(paramString2, this.a.jdField_d_of_type_JavaLangString))
    {
      QLog.d(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchResult. reqKeyword=" + paramString1 + " keyword=" + this.a.jdField_b_of_type_JavaLangString + " reqTime=" + paramString2 + " lastReqTime=" + this.a.jdField_d_of_type_JavaLangString + " isEnd1=" + paramBoolean2);
      return;
    }
    if ((!ActiveEntitySearchFragment.a(this.a.jdField_a_of_type_ArrayOfLong, paramArrayOfLong)) || (!paramString1.equals(this.a.jdField_b_of_type_JavaLangString)))
    {
      QLog.d(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchResult. masks=" + this.a.jdField_a_of_type_ArrayOfLong + " reqMasks=" + paramArrayOfLong + " reqKeyword=" + paramString1 + " keyword=" + this.a.jdField_b_of_type_JavaLangString + " isEnd1=" + paramBoolean2);
      return;
    }
    if (paramList1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchResult result=" + paramList1);
      }
      a(paramString1, paramBoolean1, paramString2, -1, "result = null", paramArrayOfLong);
      return;
    }
    long l2 = -1L;
    paramString2 = new HashSet();
    Object localObject1 = paramList1.iterator();
    int j = 0;
    long l1 = -1L;
    label277:
    Object localObject2;
    Object localObject3;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ISearchResultGroupModel)((Iterator)localObject1).next();
      if (((ISearchResultGroupModel)localObject2).a() == null) {
        break label2351;
      }
      long l3 = l1;
      if ((localObject2 instanceof GroupBaseNetSearchModel))
      {
        localObject3 = (GroupBaseNetSearchModel)localObject2;
        Iterator localIterator = ((GroupBaseNetSearchModel)localObject3).a().iterator();
        while (localIterator.hasNext())
        {
          ISearchResultModel localISearchResultModel = (ISearchResultModel)localIterator.next();
          if ((localISearchResultModel instanceof GroupBaseNetSearchModelItem)) {
            paramString2.add(Long.valueOf(((GroupBaseNetSearchModelItem)localISearchResultModel).b()));
          }
        }
        l3 = l1;
        if (l1 == -1L) {
          l3 = ((GroupBaseNetSearchModel)localObject3).a;
        }
        l2 = ((GroupBaseNetSearchModel)localObject3).a;
      }
      i = ((ISearchResultGroupModel)localObject2).a().size();
      l1 = l3;
    }
    label1178:
    label1818:
    label1833:
    label2351:
    for (int i = j + i;; i = j)
    {
      j = i;
      break label277;
      this.a.jdField_b_of_type_JavaUtilList.addAll(paramString2);
      ActiveEntitySearchFragment.a(this.a, paramString3);
      ActiveEntitySearchFragment.a(this.a, paramList2);
      if (!paramBoolean1)
      {
        paramString3 = new ArrayList();
        paramString3.addAll(paramString2);
        SearchUtils.a("sub_result", "load_result", new String[] { this.a.jdField_b_of_type_JavaLangString, SearchUtils.a(paramString3), "", SearchUtils.a("dynamic_tab_search.1", this.a.jdField_a_of_type_ArrayOfLong) });
      }
      if (j == 0) {
        if ((this.a.getActivity() instanceof SearchInfoInterface)) {
          switch (((SearchInfoInterface)this.a.getActivity()).a())
          {
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchResult isFirstReq==" + paramBoolean1 + " newSearchDataCount:" + this.a.jdField_b_of_type_Int + "   newSearchIndex:" + this.a.jdField_a_of_type_Int + " result.size():" + j);
        }
        this.a.jdField_e_of_type_AndroidViewView.setVisibility(8);
        this.a.jdField_f_of_type_AndroidViewView.setVisibility(8);
        this.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.a.jdField_e_of_type_Boolean = false;
        this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
        this.a.jdField_d_of_type_Boolean = paramBoolean2;
        if (paramBoolean2) {
          this.a.c.setVisibility(0);
        }
        if ((TextUtils.isEmpty(ActiveEntitySearchFragment.a(this.a))) || (ActiveEntitySearchFragment.a(this.a).size() <= 0)) {
          break label1818;
        }
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(ActiveEntitySearchFragment.a(this.a));
        this.a.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        paramString2 = this.a.getActivity();
        if ((paramString2 != null) && (!paramString2.isFinishing())) {
          break label1178;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "activity is finished. in handleTabSearchResult.");
        return;
        SearchUtils.a("sub_result", "no_result", new String[] { this.a.jdField_b_of_type_JavaLangString, SearchUtils.a(this.a.jdField_a_of_type_ArrayOfLong), "", SearchUtils.a("dynamic_tab_search.1", paramArrayOfLong) });
        continue;
        SearchUtils.a("all_result", "exp_tab_empty", new String[] { this.a.jdField_b_of_type_JavaLangString, SearchUtils.a(this.a.jdField_a_of_type_ArrayOfLong), "", SearchUtils.a("dynamic_tab_search.1", paramArrayOfLong) });
        continue;
        if ((this.a.jdField_a_of_type_ArrayOfByte == null) && ((this.a.getActivity() instanceof SearchInfoInterface)))
        {
          paramString2 = (SearchInfoInterface)this.a.getActivity();
          switch (paramString2.a())
          {
          case 2: 
          default: 
            break;
          case 1: 
            SearchUtils.a("all_result", "exp_tab_page", new String[] { this.a.jdField_b_of_type_JavaLangString, SearchUtils.a(this.a.jdField_b_of_type_JavaUtilList), "", SearchUtils.a("dynamic_unite_search.1", paramString2.a()) });
            break;
          case 3: 
            SearchUtils.a("sub_result", "exp_result", new String[] { paramString2.a(), SearchUtils.a(this.a.jdField_b_of_type_JavaUtilList), "", SearchUtils.a("dynamic_tab_search.1", paramString2.a()) });
          }
        }
      }
      int k = DisplayUtil.a(paramString2, 8.0F);
      int m = DisplayUtil.a(paramString2, 10.0F);
      int n = DisplayUtil.a(paramString2, 2.0F);
      paramArrayOfByte = new GradientDrawable();
      paramArrayOfByte.setCornerRadius(DisplayUtil.a(this.a.getActivity(), 15.0F));
      i = Color.parseColor("#E2E2E2");
      boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
      if (bool) {
        i = Color.parseColor("#5a86bb");
      }
      paramArrayOfByte.setStroke(1, i);
      paramString3 = ActiveEntitySearchFragment.a(this.a).iterator();
      while (paramString3.hasNext())
      {
        paramList2 = (DynamicTabSearch.SubHotWord)paramString3.next();
        localObject1 = paramList2.show_word.get().toStringUtf8();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = new TextView(paramString2);
          localObject3 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject3).rightMargin = k;
          ((TextView)localObject2).setPadding(m, n, m, n);
          i = Color.parseColor("#000000");
          if (bool) {
            i = Color.parseColor("#5a86bb");
          }
          ((TextView)localObject2).setTextColor(i);
          if (Build.VERSION.SDK_INT < 16) {
            ((TextView)localObject2).setBackgroundDrawable(paramArrayOfByte.mutate());
          }
          for (;;)
          {
            ((TextView)localObject2).setText((CharSequence)localObject1);
            ((TextView)localObject2).setGravity(17);
            ((TextView)localObject2).setTextSize(1, 14.0F);
            ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
            ((TextView)localObject2).setOnClickListener(this.a);
            ((TextView)localObject2).setTag(2131367588, paramList2);
            this.a.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            break;
            ((TextView)localObject2).setBackground(paramArrayOfByte.mutate());
          }
        }
      }
      if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == 0)
      {
        this.a.jdField_d_of_type_AndroidViewView.setVisibility(8);
        if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.isEmpty())) {
          break label2046;
        }
        paramString2 = SearchUtil.a(paramList1, paramBoolean1, this.a.jdField_f_of_type_Boolean);
        if ((paramBoolean1) || (l1 != ActiveEntitySearchFragment.a(this.a)) || (paramBoolean3) || (paramString2 == null) || (paramString2.size() <= 0)) {
          break label1846;
        }
        paramArrayOfByte = (IModel)this.a.jdField_a_of_type_JavaUtilList.get(this.a.jdField_a_of_type_JavaUtilList.size() - 1);
        paramString2.remove(0);
        k = 0;
        i = 0;
        label1640:
        if (i >= paramString2.size()) {
          break label2344;
        }
        if (!((IModel)paramString2.get(i) instanceof GroupSearchModeTitle)) {
          break label1833;
        }
      }
      for (;;)
      {
        if ((paramArrayOfByte instanceof ISearchResultModel))
        {
          paramArrayOfByte = (ISearchResultModel)paramArrayOfByte;
          k = paramArrayOfByte.c();
          SearchViewUtils.a(paramArrayOfByte, k + i, k - 1);
        }
        for (;;)
        {
          m = 0;
          for (;;)
          {
            if (m < i)
            {
              paramArrayOfByte = (IModel)paramString2.get(m);
              if ((paramArrayOfByte instanceof ISearchResultModel)) {
                SearchViewUtils.a((ISearchResultModel)paramArrayOfByte, k + i, k + m);
              }
              m += 1;
              continue;
              if (((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.isEmpty())) && ((paramList1 == null) || (paramList1.isEmpty()))) {
                break;
              }
              this.a.jdField_d_of_type_AndroidViewView.setVisibility(0);
              break;
              this.a.jdField_d_of_type_AndroidViewView.setVisibility(8);
              break;
              k = i;
              i += 1;
              break label1640;
            }
          }
          label1846:
          this.a.jdField_a_of_type_JavaUtilList.addAll(paramString2);
          this.a.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter.a(this.a.jdField_a_of_type_JavaUtilList);
          ActiveEntitySearchFragment.a(this.a, l2);
          if (!this.a.jdField_d_of_type_Boolean)
          {
            paramString2 = this.a;
            paramString2.jdField_b_of_type_Int += j;
            paramString2 = this.a;
            paramString2.jdField_a_of_type_Int += 1;
            if (this.a.jdField_b_of_type_Int > 10)
            {
              this.a.jdField_a_of_type_Int = 0;
              this.a.jdField_b_of_type_Int = 0;
            }
          }
          else
          {
            if (!paramBoolean2) {
              break label2255;
            }
            if (QLog.isColorLevel()) {
              QLog.i(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchResult isEnd = true mask;" + Arrays.toString(paramArrayOfLong) + " key=" + paramString1 + " name=" + this.a.jdField_e_of_type_JavaLangString + "  fragmentMask=" + Arrays.toString(this.a.jdField_a_of_type_ArrayOfLong));
            }
          }
          for (;;)
          {
            com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity.a = true;
            return;
            label2046:
            if ((paramList1 == null) || (paramList1.isEmpty()))
            {
              this.a.g.setVisibility(0);
              if (this.a.jdField_a_of_type_AndroidGraphicsBitmap != null) {}
            }
            for (;;)
            {
              try
              {
                this.a.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(this.a.getResources(), 2130840371);
                this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.a.jdField_a_of_type_AndroidGraphicsBitmap);
                this.a.jdField_b_of_type_AndroidWidgetTextView.setText("没有更多搜索结果");
                this.a.c.setVisibility(8);
                paramString2 = SearchUtil.a(paramList1, paramBoolean1, this.a.jdField_f_of_type_Boolean);
                this.a.jdField_a_of_type_JavaUtilList = paramString2;
                this.a.jdField_a_of_type_ComTencentMobileqqSearchAdapterSubBusinessSearchAdapter.a(this.a.jdField_a_of_type_JavaUtilList);
              }
              catch (OutOfMemoryError paramString2)
              {
                QLog.e(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 1, paramString2, new Object[0]);
                continue;
              }
              this.a.g.setVisibility(8);
            }
            if (this.a.jdField_a_of_type_Int >= 3)
            {
              this.a.jdField_d_of_type_Boolean = true;
              break label1956;
            }
            this.a.b(this.a.jdField_b_of_type_JavaLangString);
            break label1956;
            label2255:
            if (QLog.isColorLevel()) {
              QLog.i(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchResult isEnd = false mask;" + Arrays.toString(paramArrayOfLong) + " key=" + paramString1 + " name=" + this.a.jdField_e_of_type_JavaLangString + "  fragmentMask=" + Arrays.toString(this.a.jdField_a_of_type_ArrayOfLong));
            }
          }
          k = 0;
        }
        i = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahso
 * JD-Core Version:    0.7.0.1
 */