import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class akpq
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public akpq(akpm paramakpm, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(List<Integer> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ApolloResponseManager", 2, "new actions:" + paramList.toString());
    }
    this.jdField_a_of_type_Int = paramInt;
    Object localObject1;
    int j;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      localObject2 = (aliw)this.jdField_a_of_type_Akpm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155);
      localObject4 = (aknx)this.jdField_a_of_type_Akpm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      localObject3 = new ArrayList();
      localObject1 = new ArrayList();
      i = paramList.size();
      paramInt = 0;
      if (paramInt < i)
      {
        j = ((Integer)paramList.get(paramInt)).intValue();
        ApolloActionData localApolloActionData = ((aliw)localObject2).a(j);
        if (localApolloActionData == null) {}
        for (;;)
        {
          paramInt += 1;
          break;
          if ((localApolloActionData.feeType == 9) && ((((aknx)localObject4).a == null) || (!((aknx)localObject4).a.containsKey(Integer.valueOf(localApolloActionData.actionId)))))
          {
            if (!((aknx)this.jdField_a_of_type_Akpm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153)).b(this.jdField_a_of_type_Akpm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) {
              QLog.e("ApolloResponseManager", 1, "remove vip data:" + localApolloActionData.actionName + ",id:" + j);
            }
          }
          else if ((localApolloActionData.feeType != 1) && ((localApolloActionData.isShow == 0) || (((aknx)localObject4).a == null) || (!((aknx)localObject4).a.containsKey(Integer.valueOf(localApolloActionData.actionId)))))
          {
            QLog.e("ApolloResponseManager", 1, "remove " + localApolloActionData.feeType + " data:" + localApolloActionData.actionName + ",id:" + j);
            continue;
          }
          ((List)localObject1).add(localApolloActionData);
        }
      }
      if (((List)localObject1).size() < 2) {
        QLog.e("ApolloResponseManager", 1, "invalid data size:" + ((List)localObject1).size());
      }
    }
    else
    {
      return;
    }
    Collections.sort((List)localObject1, this.jdField_a_of_type_Akpm.jdField_a_of_type_JavaUtilComparator);
    Object localObject2 = new Random();
    int i = ((List)localObject1).size() - 1;
    paramInt = 0;
    if (paramInt < 2)
    {
      if (i <= 1)
      {
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(((ApolloActionData)((List)localObject1).get(paramInt)).actionId));
        ((List)localObject3).add(Integer.valueOf(((ApolloActionData)((List)localObject1).get(paramInt)).feeType));
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if (((List)localObject1).get(paramInt) != null)
        {
          j = ((ApolloActionData)((List)localObject1).get(paramInt)).feeType;
          if (j == 1)
          {
            int k;
            do
            {
              j = ((Random)localObject2).nextInt(i - paramInt + 1) + paramInt;
              k = ((ApolloActionData)((List)localObject1).get(j)).actionId;
            } while (this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(k)));
            this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(k));
            ((List)localObject3).add(Integer.valueOf(((ApolloActionData)((List)localObject1).get(j)).feeType));
          }
          else
          {
            this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(((ApolloActionData)((List)localObject1).get(paramInt)).actionId));
            ((List)localObject3).add(Integer.valueOf(j));
          }
        }
      }
    }
    notifyDataSetChanged();
    Object localObject4 = String.valueOf(this.jdField_a_of_type_Akpm.jdField_a_of_type_JavaLangString);
    paramInt = ApolloUtil.b(this.jdField_a_of_type_Akpm.jdField_a_of_type_Int);
    i = this.jdField_a_of_type_Int;
    if (paramList.size() > 0)
    {
      localObject1 = String.valueOf(paramList.get(0));
      if (((List)localObject3).size() <= 0) {
        break label867;
      }
      localObject2 = String.valueOf(((List)localObject3).get(0));
      label777:
      if (paramList.size() <= 1) {
        break label874;
      }
      paramList = String.valueOf(paramList.get(1));
      label798:
      if (((List)localObject3).size() <= 1) {
        break label880;
      }
    }
    label867:
    label874:
    label880:
    for (Object localObject3 = String.valueOf(((List)localObject3).get(1));; localObject3 = "0")
    {
      VipUtils.a(null, "cmshow", "Apollo", "quickresponsepv", (String)localObject4, paramInt, i, new String[] { localObject1, localObject2, paramList, localObject3 });
      return;
      localObject1 = "0";
      break;
      localObject2 = "0";
      break label777;
      paramList = "0";
      break label798;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = ((Integer)getItem(paramInt)).intValue();
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      paramViewGroup = new akpp(this.jdField_a_of_type_Akpm);
      paramView = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)paramView).setOrientation(1);
      localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject2).setBackgroundResource(2130838488);
      ((LinearLayout)localObject2).setOrientation(0);
      localObject3 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      int j = aepi.a(28.0F, (Resources)localObject1);
      Object localObject4 = new LinearLayout.LayoutParams(j, j);
      ((LinearLayout.LayoutParams)localObject4).leftMargin = aepi.a(2.2F, (Resources)localObject1);
      ((LinearLayout.LayoutParams)localObject4).gravity = 16;
      ((LinearLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject4).setTextSize(11.0F);
      ((TextView)localObject4).setMaxLines(1);
      ((TextView)localObject4).setIncludeFontPadding(false);
      ((TextView)localObject4).setGravity(1);
      ((TextView)localObject4).setTextColor(((Resources)localObject1).getColor(2131166910));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 16;
      ((LinearLayout)localObject2).addView((View)localObject4, localLayoutParams);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject3);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject4);
      localObject3 = new View(this.jdField_a_of_type_AndroidContentContext);
      paramViewGroup.jdField_a_of_type_AndroidViewView = ((View)localObject3);
      ((LinearLayout)paramView).addView((View)localObject2);
      ((LinearLayout)paramView).addView((View)localObject3);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramView.setTag(2131362662, Integer.valueOf(i));
      paramView.setTag(2131362663, Integer.valueOf(this.jdField_a_of_type_Int));
      localObject2 = paramViewGroup.jdField_a_of_type_AndroidViewView;
      float f;
      if (paramInt == this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        f = 8.0F;
        label333:
        ((View)localObject2).setMinimumHeight(aepi.a(f, (Resources)localObject1));
      }
      try
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Resources)localObject1).getDrawable(2130838425);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Resources)localObject1).getDrawable(2130838427);
        localObject1 = new URL("apollo_gif", "", String.valueOf(i));
        localObject3 = new File(afia.a(i));
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setTag(Integer.valueOf(i));
        if (((File)localObject3).exists())
        {
          localObject1 = URLDrawable.getDrawable((File)localObject3, (URLDrawable.URLDrawableOptions)localObject2);
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        }
        for (;;)
        {
          label454:
          localObject1 = ((aliw)this.jdField_a_of_type_Akpm.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(155)).a(i);
          if (localObject1 != null)
          {
            localObject1 = ((ApolloActionData)localObject1).actionName;
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          }
          paramView.setOnClickListener(this.jdField_a_of_type_Akpm.jdField_a_of_type_AndroidViewView$OnClickListener);
          return paramView;
          paramViewGroup = (akpp)paramView.getTag();
          break;
          f = 5.0F;
          break label333;
          localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject1).setTag(Integer.valueOf(i));
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        }
      }
      catch (Throwable localThrowable)
      {
        break label454;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpq
 * JD-Core Version:    0.7.0.1
 */