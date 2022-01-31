import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class afrn
  extends aimb
{
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afro(this);
  public LinkedHashMap<String, List<afrm>> a;
  private boolean jdField_a_of_type_Boolean;
  public int[] a;
  public String[] a;
  
  public afrn(PublicAccountFragment paramPublicAccountFragment)
  {
    this(paramPublicAccountFragment, paramPublicAccountFragment.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramPublicAccountFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPublicAccountFragment.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, true);
  }
  
  public afrn(PublicAccountFragment paramPublicAccountFragment, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramBoolean);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_AndroidGraphicsBitmap = bbdr.a(true);
  }
  
  public int a()
  {
    return 2131559194;
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
  
  protected Bitmap a(String paramString)
  {
    return a(paramString, 0);
  }
  
  protected Bitmap a(String paramString, int paramInt)
  {
    return a(paramString, 115, (byte)0, paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_ArrayOfInt = new int[0];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(View paramView, int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    paramInt = i;
    if (i < 0) {
      paramInt = -(i + 1) - 1;
    }
    if ((paramInt >= this.jdField_a_of_type_ArrayOfJavaLangString.length) || (paramInt < 0)) {}
    while (!(paramView instanceof TextView)) {
      return;
    }
    paramView = (TextView)paramView;
    i = paramView.getPaddingLeft();
    if ((ThemeUtil.isNowThemeDefaultCache) || (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))) {
      paramView.setBackgroundResource(2130849133);
    }
    for (;;)
    {
      paramView.setPadding(i, 0, 0, 0);
      paramView.setText(this.jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
      paramView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColorStateList(2131166931));
      return;
      paramView.setBackgroundColor(553648127);
    }
  }
  
  public boolean a(int paramInt)
  {
    return Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt) >= 0;
  }
  
  public boolean a(View paramView, int paramInt)
  {
    return (!ThemeUtil.isNowThemeDefaultCache) && (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null));
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment.jdField_a_of_type_JavaUtilList.isEmpty())) {}
    Object localObject2;
    label92:
    do
    {
      return;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment.jdField_a_of_type_JavaUtilList.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        afrm localafrm = (afrm)((Iterator)localObject2).next();
        if ((localafrm.jdField_a_of_type_JavaLangString == null) || (localafrm.jdField_a_of_type_JavaLangString.length() == 0))
        {
          localObject1 = "#";
          i = ((String)localObject1).charAt(0);
          if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
            break label197;
          }
        }
        for (localObject1 = ((String)localObject1).toUpperCase();; localObject1 = "#")
        {
          if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1) == null) {
            this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localObject1, new ArrayList());
          }
          ((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject1)).add(localafrm);
          break;
          localObject1 = localafrm.jdField_a_of_type_JavaLangString.substring(0, 1);
          break label92;
        }
      }
      localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap;
      this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
      for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
        if (((LinkedHashMap)localObject1).get(String.valueOf(c)) != null)
        {
          localObject2 = (List)((LinkedHashMap)localObject1).get(String.valueOf(c));
          Collections.sort((List)localObject2, PublicAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment));
          this.jdField_a_of_type_JavaUtilLinkedHashMap.put(String.valueOf(c), localObject2);
        }
      }
      if (((LinkedHashMap)localObject1).get("#") != null)
      {
        localObject2 = (List)((LinkedHashMap)localObject1).get("#");
        Collections.sort((List)localObject2, PublicAccountFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment));
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put("#", localObject2);
      }
      ((LinkedHashMap)localObject1).clear();
      this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().size()];
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[this.jdField_a_of_type_ArrayOfInt.length];
      localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    } while (this.jdField_a_of_type_ArrayOfInt.length == 0);
    label197:
    this.jdField_a_of_type_ArrayOfInt[0] = 0;
    int i = 1;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      localObject2 = this.jdField_a_of_type_ArrayOfInt;
      int j = localObject2[i];
      int k = this.jdField_a_of_type_ArrayOfInt[(i - 1)];
      localObject2[i] = (((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(((Iterator)localObject1).next())).size() + k + 1 + j);
      i += 1;
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)((Iterator)localObject1).next());
      i += 1;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_ArrayOfInt.length == 0) || (!this.jdField_a_of_type_Boolean)) {
      return 0;
    }
    List localList = (List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)]);
    if (localList != null)
    {
      int i = this.jdField_a_of_type_ArrayOfInt[(this.jdField_a_of_type_ArrayOfInt.length - 1)];
      return localList.size() + i + 1;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (i >= 0) {
      return null;
    }
    i = -(i + 1) - 1;
    return (afrm)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = Arrays.binarySearch(this.jdField_a_of_type_ArrayOfInt, paramInt);
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131559439, paramViewGroup, false);
      paramViewGroup = new afrp();
      paramViewGroup.jdField_c_of_type_Int = 115;
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367679));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363816));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131377031));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372101));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372084));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372111));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131377033));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131378220));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131372098);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363800));
      paramView.setTag(paramViewGroup);
      if (!(paramViewGroup.jdField_c_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        break label864;
      }
      ((ThemeImageView)paramViewGroup.jdField_c_of_type_AndroidWidgetImageView).setSupportMaskView(true);
    }
    label418:
    label858:
    label864:
    for (;;)
    {
      Object localObject;
      if (i < 0)
      {
        i = -(i + 1) - 1;
        localObject = (afrm)((List)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_ArrayOfJavaLangString[i])).get(paramInt - this.jdField_a_of_type_ArrayOfInt[i] - 1);
        paramViewGroup.jdField_a_of_type_Afrm = ((afrm)localObject);
        paramViewGroup.jdField_a_of_type_JavaLangString = String.valueOf(((afrm)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.uin);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.f.setVisibility(8);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setText(((afrm)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
        if (((afrm)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.certifiedGrade > 0L)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment.getResources().getDrawable(2130841313);
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ImmersiveUtils.a(15.0F), ImmersiveUtils.a(15.0F));
            ThemeUtil.setThemeFilter(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment.jdField_a_of_type_AndroidGraphicsDrawableDrawable, ThemeUtil.curThemeId);
          }
          paramViewGroup.d.setCompoundDrawables(null, null, this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null);
          paramViewGroup.e.setText(((afrm)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.summary);
          Bitmap localBitmap = a(paramViewGroup.jdField_a_of_type_JavaLangString);
          paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
          if (((afrm)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.extendType != 2) {
            break label858;
          }
        }
      }
      for (boolean bool = nbc.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((afrm)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin(), 1024);; bool = false)
      {
        if (bool)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, ((afrm)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.getUin());
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(-2, ((afrm)localObject).jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if (!bool)
          {
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setTag(-1, "");
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setTag(-2, "");
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(null);
            paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
          }
          paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          if (AppSetting.d)
          {
            localObject = new StringBuilder(24);
            ((StringBuilder)localObject).append(paramViewGroup.d.getText()).append(" 简介 ").append(paramViewGroup.e.getText());
            paramView.setContentDescription((CharSequence)localObject);
            paramView.setFocusable(true);
            paramView.setFocusableInTouchMode(true);
          }
        }
        do
        {
          return paramView;
          paramViewGroup = (afrp)paramView.getTag();
          break;
          paramViewGroup.d.setCompoundDrawables(null, null, null, null);
          break label418;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(-1, "");
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setTag(-2, "");
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          break label544;
          paramViewGroup.jdField_a_of_type_Afrm = null;
          paramViewGroup.jdField_a_of_type_JavaLangString = "";
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
          paramViewGroup.f.setVisibility(0);
          localObject = String.valueOf(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
          paramViewGroup.f.setText((CharSequence)localObject);
          paramInt = paramViewGroup.f.getPaddingLeft();
          paramViewGroup.f.setPadding(paramInt, 0, 0, 0);
        } while (!AppSetting.d);
        paramViewGroup.f.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFragmentPublicAccountFragment.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131691898), new Object[] { ((String)localObject).toLowerCase() }));
        return paramView;
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt != 0) {
      ApngImage.pauseByTag(3);
    }
    if (paramInt == 0) {
      ApngImage.playByTag(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afrn
 * JD-Core Version:    0.7.0.1
 */