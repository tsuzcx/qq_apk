import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aiat
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private aiax jdField_a_of_type_Aiax;
  private aiay jdField_a_of_type_Aiay;
  private Context jdField_a_of_type_AndroidContentContext;
  protected Drawable a;
  protected LayoutInflater a;
  private View.AccessibilityDelegate jdField_a_of_type_AndroidViewView$AccessibilityDelegate = new aiaw(this);
  protected QQAppInterface a;
  protected HashMap<String, Drawable> a;
  protected List<Object> a;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  public aiat(QQAppInterface paramQQAppInterface, Context paramContext, List<amnq> paramList, aiax paramaiax, aiay paramaiay)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844408);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.jdField_a_of_type_Aiax = paramaiax;
    this.jdField_a_of_type_Aiay = paramaiay;
    b();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844408);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private void a(RedTouch paramRedTouch, amnq paramamnq, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (byte b1 = 0;; b1 = 1)
    {
      paramamnq.jdField_a_of_type_Byte = b1;
      if (QLog.isColorLevel()) {
        QLog.i("LebaListMgrAdapter", 2, "name: " + paramamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + "  cCurFlag:" + paramamnq.jdField_a_of_type_Byte);
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      afqa.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      ((ajqw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(31)).a(String.valueOf(paramamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), paramBoolean, l);
      if (paramBoolean)
      {
        auqh localauqh = (auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        l = paramamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
        localauqh.b("100600." + (100000000L + l) + "");
        if (paramRedTouch != null) {
          paramRedTouch.b();
        }
      }
      b();
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Aiay != null) {
        this.jdField_a_of_type_Aiay.a(paramamnq);
      }
      return;
    }
  }
  
  private void a(RedTouch paramRedTouch, String paramString)
  {
    paramString = ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramString);
    paramRedTouch.a(paramString);
    a(paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((auqh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramAppInfo);
  }
  
  private void a(ArrayList<amnq> paramArrayList)
  {
    int i = 1;
    if (paramArrayList.size() > 0) {}
    switch (paramArrayList.size())
    {
    default: 
      ((amnq)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
      while (i < paramArrayList.size() - 1)
      {
        ((amnq)paramArrayList.get(i)).jdField_a_of_type_Int = 3;
        i += 1;
      }
    case 1: 
      ((amnq)paramArrayList.get(0)).jdField_a_of_type_Int = 0;
      return;
    }
    ((amnq)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
    ((amnq)paramArrayList.get(1)).jdField_a_of_type_Int = 2;
    return;
    ((amnq)paramArrayList.get(paramArrayList.size() - 1)).jdField_a_of_type_Int = 2;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Aiax == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      this.jdField_b_of_type_Int = 0;
      localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof amnq))
        {
          localObject = (amnq)localObject;
          if ((this.jdField_a_of_type_Aiax.a((amnq)localObject)) && (((amnq)localObject).jdField_a_of_type_Boolean) && (((amnq)localObject).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.cCanChangeState != 0)) {
            localArrayList.add(localObject);
          } else {
            this.jdField_b_of_type_Int += 1;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    } while (localArrayList.size() <= 0);
    Collections.sort(localArrayList, new ajlk());
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    a(localArrayList);
  }
  
  public void a() {}
  
  public void a(List<amnq> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    b();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    amnq localamnq = (amnq)getItem(paramInt);
    Object localObject;
    if ((localamnq == null) || (localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      localObject = paramView;
      return localObject;
    }
    label146:
    label185:
    RedTouch localRedTouch;
    if (paramView == null)
    {
      paramView = new aiaz();
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493424, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131303416));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131303477));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131303476));
      paramView.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)paramViewGroup.findViewById(2131298121));
      if (ThemeUtil.isDefaultTheme())
      {
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130848905);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101267));
        localObject = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), paramViewGroup).c(100).a();
        ((View)localObject).setTag(paramView);
        paramViewGroup = paramView;
        paramView = (View)localObject;
        localRedTouch = (RedTouch)paramView;
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (localamnq.jdField_a_of_type_Byte != 0) {
          break label675;
        }
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        label230:
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new aiau(this, localRedTouch, localamnq));
        if (QLog.isColorLevel()) {
          QLog.i("LebaListMgrAdapter", 2, "getview name: " + localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + "  cCurFlag:" + localamnq.jdField_a_of_type_Byte);
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        paramViewGroup.jdField_a_of_type_Amnq = localamnq;
        localObject = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        if ((localamnq == null) || (localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (TextUtils.isEmpty(localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName))) {
          break label715;
        }
        if (TextUtils.isEmpty(localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL)) {
          break label701;
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = aciy.a(26.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        localObject = URLDrawable.getDrawable(localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL, (URLDrawable.URLDrawableOptions)localObject);
        ((URLDrawable)localObject).setTargetDensity(this.jdField_a_of_type_Int);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
        label467:
        if (localObject != null) {
          ThemeUtil.setThemeFilter((Drawable)localObject, ThemeUtil.curThemeId);
        }
        if (localamnq.jdField_a_of_type_Byte != 1) {
          break label729;
        }
        long l = localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
        a((RedTouch)paramView, "100600." + (100000000L + l) + "");
      }
    }
    for (;;)
    {
      localObject = paramView;
      if (!AppSetting.c) {
        break;
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        azve.a(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, false);
        azve.a(paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch, false);
        azve.a(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, false);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      if (Build.VERSION.SDK_INT >= 14) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setAccessibilityDelegate(this.jdField_a_of_type_AndroidViewView$AccessibilityDelegate);
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aiav(this, localRedTouch, localamnq));
      return paramView;
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130848902);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101260));
      break label146;
      paramViewGroup = (aiaz)paramView.getTag();
      break label185;
      label675:
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localamnq.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
      break label230;
      label701:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      break label467;
      label715:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      break label467;
      label729:
      ((RedTouch)paramView).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aiat
 * JD-Core Version:    0.7.0.1
 */