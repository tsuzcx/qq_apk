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

public class aeoo
  extends amgf
{
  public LinkedHashMap<String, List<aeon>> a;
  public int[] a;
  public String[] a;
  
  public aeoo(PublicAccountListActivity paramPublicAccountListActivity)
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
        aeon localaeon = (aeon)((Iterator)localObject2).next();
        if (!PublicAccountListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity, localaeon))
        {
          if ((localaeon.jdField_a_of_type_JavaLangString == null) || (localaeon.jdField_a_of_type_JavaLangString.length() == 0))
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
            ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).add(localaeon);
            break;
            localObject1 = localaeon.jdField_a_of_type_JavaLangString.substring(0, 1);
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
    return 2131559369;
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
    return (aeon)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    aeop localaeop;
    Object localObject;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559664, paramViewGroup, false);
      localaeop = new aeop();
      localaeop.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368381));
      localaeop.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364215));
      localaeop.d = ((TextView)paramView.findViewById(2131378659));
      localaeop.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373322));
      localaeop.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373305));
      localaeop.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373332));
      localaeop.e = ((TextView)paramView.findViewById(2131378661));
      localaeop.f = ((TextView)paramView.findViewById(2131379987));
      localaeop.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373319);
      localaeop.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364187));
      paramView.setTag(localaeop);
      if (i >= 0) {
        break label764;
      }
      i = -(i + 1) - 1;
      localObject = (aeon)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
      localaeop.jdField_a_of_type_Aeon = ((aeon)localObject);
      localaeop.jdField_a_of_type_JavaLangString = String.valueOf(((aeon)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.uin);
      localaeop.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localaeop.f.setVisibility(8);
      localaeop.d.setVisibility(0);
      localaeop.d.setText(((aeon)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
      if (((aeon)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.certifiedGrade <= 0L) {
        break label703;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.getResources().getDrawable(2130841803);
        this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
      }
      ThemeUtil.setThemeFilter(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, ThemeUtil.curThemeId);
      localaeop.d.setCompoundDrawables(null, null, this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
      label398:
      localaeop.e.setText(((aeon)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.summary);
      localaeop.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(super.a(localaeop.jdField_a_of_type_JavaLangString));
      boolean bool = false;
      if (((aeon)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType == 2) {
        bool = nwu.a(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.app, ((aeon)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin(), 1024);
      }
      if (!bool) {
        break label718;
      }
      localaeop.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, ((aeon)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin());
      localaeop.jdField_a_of_type_AndroidWidgetImageView.setTag(-2, ((aeon)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
      localaeop.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
      localaeop.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label533:
      if (!bool)
      {
        localaeop.jdField_b_of_type_AndroidWidgetImageView.setTag(-1, "");
        localaeop.jdField_b_of_type_AndroidWidgetImageView.setTag(-2, "");
        localaeop.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(null);
        localaeop.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      localaeop.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      localaeop.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      localaeop.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (AppSetting.c)
      {
        localObject = new StringBuilder(24);
        ((StringBuilder)localObject).append(localaeop.d.getText()).append(" 简介 ").append(localaeop.e.getText());
        paramView.setContentDescription((CharSequence)localObject);
        paramView.setFocusable(true);
        paramView.setFocusableInTouchMode(true);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localaeop = (aeop)paramView.getTag();
      break;
      label703:
      localaeop.d.setCompoundDrawables(null, null, null, null);
      break label398;
      label718:
      localaeop.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, "");
      localaeop.jdField_a_of_type_AndroidWidgetImageView.setTag(-2, "");
      localaeop.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
      localaeop.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      break label533;
      label764:
      localaeop.jdField_a_of_type_Aeon = null;
      localaeop.jdField_a_of_type_JavaLangString = "";
      localaeop.jdField_a_of_type_AndroidViewView.setVisibility(8);
      localaeop.f.setVisibility(0);
      localObject = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
      localaeop.f.setText((CharSequence)localObject);
      if (AppSetting.c) {
        localaeop.f.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityPublicAccountListActivity.getString(2131691767), new Object[] { ((String)localObject).toLowerCase() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeoo
 * JD-Core Version:    0.7.0.1
 */