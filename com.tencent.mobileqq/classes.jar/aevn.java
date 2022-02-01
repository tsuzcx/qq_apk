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

public class aevn
  extends ambr
{
  public LinkedHashMap<String, List<aevm>> a;
  public int[] a;
  public String[] a;
  
  public aevn(PublicAccountListActivity paramPublicAccountListActivity)
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
        aevm localaevm = (aevm)((Iterator)localObject2).next();
        if (!PublicAccountListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity, localaevm))
        {
          if ((localaevm.jdField_a_of_type_JavaLangString == null) || (localaevm.jdField_a_of_type_JavaLangString.length() == 0))
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
            ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).add(localaevm);
            break;
            localObject1 = localaevm.jdField_a_of_type_JavaLangString.substring(0, 1);
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
    return 2131559317;
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
    return (aevm)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    aevo localaevo;
    Object localObject;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559622, paramViewGroup, false);
      localaevo = new aevo();
      localaevo.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368138));
      localaevo.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364077));
      localaevo.d = ((TextView)paramView.findViewById(2131378446));
      localaevo.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373028));
      localaevo.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373011));
      localaevo.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373038));
      localaevo.e = ((TextView)paramView.findViewById(2131378448));
      localaevo.f = ((TextView)paramView.findViewById(2131379723));
      localaevo.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373025);
      localaevo.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364064));
      paramView.setTag(localaevo);
      if (i >= 0) {
        break label764;
      }
      i = -(i + 1) - 1;
      localObject = (aevm)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      localaevo.jdField_a_of_type_Aevm = ((aevm)localObject);
      localaevo.jdField_a_of_type_JavaLangString = String.valueOf(((aevm)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.uin);
      localaevo.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localaevo.f.setVisibility(8);
      localaevo.d.setVisibility(0);
      localaevo.d.setText(((aevm)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
      if (((aevm)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.certifiedGrade <= 0L) {
        break label703;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.getResources().getDrawable(2130841741);
        this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
      }
      ThemeUtil.setThemeFilter(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, ThemeUtil.curThemeId);
      localaevo.d.setCompoundDrawables(null, null, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      label398:
      localaevo.e.setText(((aevm)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.summary);
      localaevo.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(super.a(localaevo.jdField_a_of_type_JavaLangString));
      boolean bool = false;
      if (((aevm)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType == 2) {
        bool = nmp.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.app, ((aevm)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin(), 1024);
      }
      if (!bool) {
        break label718;
      }
      localaevo.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, ((aevm)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin());
      localaevo.jdField_a_of_type_AndroidWidgetImageView.setTag(-2, ((aevm)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
      localaevo.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
      localaevo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label533:
      if (!bool)
      {
        localaevo.jdField_b_of_type_AndroidWidgetImageView.setTag(-1, "");
        localaevo.jdField_b_of_type_AndroidWidgetImageView.setTag(-2, "");
        localaevo.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(null);
        localaevo.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      localaevo.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localaevo.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localaevo.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (AppSetting.c)
      {
        localObject = new StringBuilder(24);
        ((StringBuilder)localObject).append(localaevo.d.getText()).append(" 简介 ").append(localaevo.e.getText());
        paramView.setContentDescription((CharSequence)localObject);
        paramView.setFocusable(true);
        paramView.setFocusableInTouchMode(true);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localaevo = (aevo)paramView.getTag();
      break;
      label703:
      localaevo.d.setCompoundDrawables(null, null, null, null);
      break label398;
      label718:
      localaevo.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, "");
      localaevo.jdField_a_of_type_AndroidWidgetImageView.setTag(-2, "");
      localaevo.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
      localaevo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      break label533;
      label764:
      localaevo.jdField_a_of_type_Aevm = null;
      localaevo.jdField_a_of_type_JavaLangString = "";
      localaevo.jdField_a_of_type_AndroidViewView.setVisibility(8);
      localaevo.f.setVisibility(0);
      localObject = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
      localaevo.f.setText((CharSequence)localObject);
      if (AppSetting.c) {
        localaevo.f.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.getString(2131691635), new Object[] { ((String)localObject).toLowerCase() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aevn
 * JD-Core Version:    0.7.0.1
 */