import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class adxj
  extends alif
{
  public LinkedHashMap<String, List<adxi>> a;
  public int[] a;
  public String[] a;
  
  public adxj(PublicAccountListActivity paramPublicAccountListActivity)
  {
    super(paramPublicAccountListActivity, paramPublicAccountListActivity.app, paramPublicAccountListActivity.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.b == null) {}
    for (;;)
    {
      return;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.b.iterator();
      label89:
      int i;
      while (((Iterator)localObject2).hasNext())
      {
        adxi localadxi = (adxi)((Iterator)localObject2).next();
        if (!PublicAccountListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity, localadxi))
        {
          if ((localadxi.jdField_a_of_type_JavaLangString == null) || (localadxi.jdField_a_of_type_JavaLangString.length() == 0))
          {
            localObject1 = "#";
            i = ((String)localObject1).charAt(0);
            if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
              break label194;
            }
          }
          label194:
          for (localObject1 = ((String)localObject1).toUpperCase();; localObject1 = "#")
          {
            if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1) == null) {
              this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, new ArrayList());
            }
            ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).add(localadxi);
            break;
            localObject1 = localadxi.jdField_a_of_type_JavaLangString.substring(0, 1);
            break label89;
          }
        }
      }
      Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
      this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
      for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
        if (((LinkedHashMap)localObject1).get(String.valueOf(c)) != null)
        {
          localObject2 = (List)((LinkedHashMap)localObject1).get(String.valueOf(c));
          Collections.sort((List)localObject2, PublicAccountListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity));
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c), localObject2);
        }
      }
      if (((LinkedHashMap)localObject1).get("#") != null)
      {
        localObject2 = (List)((LinkedHashMap)localObject1).get("#");
        Collections.sort((List)localObject2, PublicAccountListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity));
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", localObject2);
      }
      ((LinkedHashMap)localObject1).clear();
      this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[this.jdField_a_of_type_ArrayOfInt.length];
      localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      if (this.jdField_a_of_type_ArrayOfInt.length != 0)
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 0;
        i = 1;
        while (i < this.jdField_a_of_type_ArrayOfInt.length)
        {
          localObject2 = this.jdField_a_of_type_ArrayOfInt;
          int j = localObject2[i];
          int k = this.jdField_a_of_type_ArrayOfInt[(i - 1)];
          localObject2[i] = (((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((Iterator)localObject1).next())).size() + k + 1 + j);
          i += 1;
        }
        localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)((Iterator)localObject1).next());
          i += 1;
        }
      }
    }
  }
  
  public int a()
  {
    return 2131559319;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label53;
      }
      if (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  public void a()
  {
    b();
    super.notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    if (paramInt >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
      return;
    }
    ((TextView)paramView).setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfInt.length == 0) {
      return 0;
    }
    int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
    return ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)])).size() + i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (adxi)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    adxk localadxk;
    Object localObject;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559629, paramViewGroup, false);
      localadxk = new adxk();
      localadxk.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368236));
      localadxk.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364140));
      localadxk.d = ((TextView)paramView.findViewById(2131378368));
      localadxk.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373111));
      localadxk.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373094));
      localadxk.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373121));
      localadxk.e = ((TextView)paramView.findViewById(2131378370));
      localadxk.f = ((TextView)paramView.findViewById(2131379673));
      localadxk.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373108);
      localadxk.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364112));
      paramView.setTag(localadxk);
      if (i >= 0) {
        break label764;
      }
      i = -(i + 1) - 1;
      localObject = (adxi)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      localadxk.jdField_a_of_type_Adxi = ((adxi)localObject);
      localadxk.jdField_a_of_type_JavaLangString = String.valueOf(((adxi)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.uin);
      localadxk.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localadxk.f.setVisibility(8);
      localadxk.d.setVisibility(0);
      localadxk.d.setText(((adxi)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
      if (((adxi)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.certifiedGrade <= 0L) {
        break label703;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.getResources().getDrawable(2130841793);
        this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
      }
      ThemeUtil.setThemeFilter(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, ThemeUtil.curThemeId);
      localadxk.d.setCompoundDrawables(null, null, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      label398:
      localadxk.e.setText(((adxi)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.summary);
      localadxk.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(super.a(localadxk.jdField_a_of_type_JavaLangString));
      boolean bool = false;
      if (((adxi)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType == 2) {
        bool = npt.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.app, ((adxi)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin(), 1024);
      }
      if (!bool) {
        break label718;
      }
      localadxk.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, ((adxi)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin());
      localadxk.jdField_a_of_type_AndroidWidgetImageView.setTag(-2, ((adxi)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
      localadxk.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
      localadxk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label533:
      if (!bool)
      {
        localadxk.jdField_b_of_type_AndroidWidgetImageView.setTag(-1, "");
        localadxk.jdField_b_of_type_AndroidWidgetImageView.setTag(-2, "");
        localadxk.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(null);
        localadxk.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      localadxk.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localadxk.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localadxk.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (AppSetting.c)
      {
        localObject = new StringBuilder(24);
        ((StringBuilder)localObject).append(localadxk.d.getText()).append(" 简介 ").append(localadxk.e.getText());
        paramView.setContentDescription((CharSequence)localObject);
        paramView.setFocusable(true);
        paramView.setFocusableInTouchMode(true);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localadxk = (adxk)paramView.getTag();
      break;
      label703:
      localadxk.d.setCompoundDrawables(null, null, null, null);
      break label398;
      label718:
      localadxk.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, "");
      localadxk.jdField_a_of_type_AndroidWidgetImageView.setTag(-2, "");
      localadxk.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
      localadxk.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      break label533;
      label764:
      localadxk.jdField_a_of_type_Adxi = null;
      localadxk.jdField_a_of_type_JavaLangString = "";
      localadxk.jdField_a_of_type_AndroidViewView.setVisibility(8);
      localadxk.f.setVisibility(0);
      localObject = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
      localadxk.f.setText((CharSequence)localObject);
      if (AppSetting.c) {
        localadxk.f.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.getString(2131691682), new Object[] { ((String)localObject).toLowerCase() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxj
 * JD-Core Version:    0.7.0.1
 */