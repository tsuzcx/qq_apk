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
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
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

public class akev
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private akez jdField_a_of_type_Akez;
  private akfa jdField_a_of_type_Akfa;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected LayoutInflater a;
  private View.AccessibilityDelegate jdField_a_of_type_AndroidViewView$AccessibilityDelegate = new akey(this);
  protected QQAppInterface a;
  protected HashMap<String, Drawable> a;
  protected List<Object> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  public akev(QQAppInterface paramQQAppInterface, Context paramContext, List<aovj> paramList, akez paramakez, akfa paramakfa)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.jdField_a_of_type_Akez = paramakez;
    this.jdField_a_of_type_Akfa = paramakfa;
    b();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844855);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844866);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private void a(RedTouch paramRedTouch, aovj paramaovj, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (byte b1 = 0;; b1 = 1)
    {
      paramaovj.jdField_a_of_type_Byte = b1;
      if (QLog.isColorLevel()) {
        QLog.i("LebaListMgrAdapter", 2, "name: " + paramaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + "  cCurFlag:" + paramaovj.jdField_a_of_type_Byte);
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      aiab.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      ((alwv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(31)).a(String.valueOf(paramaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), paramBoolean, l);
      if (paramBoolean)
      {
        axho localaxho = (axho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        l = paramaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
        localaxho.b("100600." + (100000000L + l) + "");
        if (paramRedTouch != null) {
          paramRedTouch.d();
        }
      }
      b();
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Akfa != null) {
        this.jdField_a_of_type_Akfa.a(paramaovj);
      }
      return;
    }
  }
  
  private void a(RedTouch paramRedTouch, String paramString)
  {
    paramString = ((axho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramString);
    paramRedTouch.a(paramString);
    a(paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((axho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramAppInfo);
  }
  
  private void a(ArrayList<aovj> paramArrayList)
  {
    int i = 1;
    if (paramArrayList.size() > 0) {}
    switch (paramArrayList.size())
    {
    default: 
      ((aovj)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
      while (i < paramArrayList.size() - 1)
      {
        ((aovj)paramArrayList.get(i)).jdField_a_of_type_Int = 3;
        i += 1;
      }
    case 1: 
      ((aovj)paramArrayList.get(0)).jdField_a_of_type_Int = 0;
      return;
    }
    ((aovj)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
    ((aovj)paramArrayList.get(1)).jdField_a_of_type_Int = 2;
    return;
    ((aovj)paramArrayList.get(paramArrayList.size() - 1)).jdField_a_of_type_Int = 2;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Akez == null) {}
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
        if ((localObject instanceof aovj))
        {
          localObject = (aovj)localObject;
          if ((this.jdField_a_of_type_Akez.a((aovj)localObject)) && (((aovj)localObject).jdField_a_of_type_Boolean) && (((aovj)localObject).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.cCanChangeState != 0)) {
            localArrayList.add(localObject);
          } else {
            this.jdField_b_of_type_Int += 1;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    } while (localArrayList.size() <= 0);
    Collections.sort(localArrayList, new alrd());
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    a(localArrayList);
  }
  
  public void a() {}
  
  public void a(List<aovj> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    b();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
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
    aovj localaovj = (aovj)getItem(paramInt);
    if ((localaovj == null) || (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      paramViewGroup = paramView;
      return paramViewGroup;
    }
    akfb localakfb;
    label151:
    label184:
    RedTouch localRedTouch;
    label232:
    String str;
    if (paramView == null)
    {
      localakfb = new akfb();
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559026, paramViewGroup, false);
      localakfb.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369315));
      localakfb.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369377));
      localakfb.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369376));
      localakfb.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)paramView.findViewById(2131363726));
      if (ThemeUtil.isDefaultTheme())
      {
        localakfb.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849573);
        localakfb.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166908));
        paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), paramView).c(100).a();
        paramView.setTag(localakfb);
        localRedTouch = (RedTouch)paramView;
        localakfb.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (localaovj.jdField_a_of_type_Byte != 0) {
          break label718;
        }
        localakfb.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        localakfb.jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        localakfb.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new akew(this, localRedTouch, localaovj));
        if (QLog.isColorLevel()) {
          QLog.i("LebaListMgrAdapter", 2, "getview name: " + localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + "  cCurFlag:" + localaovj.jdField_a_of_type_Byte);
        }
        localakfb.jdField_a_of_type_AndroidWidgetTextView.setText(localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        localakfb.jdField_a_of_type_Aovj = localaovj;
        if (!this.jdField_a_of_type_Boolean) {
          break label746;
        }
        paramViewGroup = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        label339:
        if (!this.jdField_a_of_type_Boolean) {
          break label754;
        }
        str = localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl;
        label356:
        if (!this.jdField_a_of_type_Boolean) {
          break label767;
        }
        paramInt = aekt.a(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        label377:
        Object localObject = (RelativeLayout.LayoutParams)localakfb.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).width = paramInt;
        ((RelativeLayout.LayoutParams)localObject).height = paramInt;
        localakfb.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if ((localaovj == null) || (localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null)) {
          break label796;
        }
        if (TextUtils.isEmpty(str)) {
          break label784;
        }
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramViewGroup;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramViewGroup;
        paramViewGroup = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions)localObject);
        paramViewGroup.setTargetDensity(this.jdField_a_of_type_Int);
        if (paramViewGroup.getStatus() == 2) {
          paramViewGroup.restartDownload();
        }
        localakfb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
        label503:
        if (paramViewGroup != null) {
          ThemeUtil.setThemeFilter(paramViewGroup, ThemeUtil.curThemeId);
        }
        if (localaovj.jdField_a_of_type_Byte != 1) {
          break label808;
        }
        long l = localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
        a((RedTouch)paramView, "100600." + (100000000L + l) + "");
      }
    }
    for (;;)
    {
      paramViewGroup = paramView;
      if (!AppSetting.c) {
        break;
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        bcvq.a(localakfb.jdField_a_of_type_AndroidWidgetTextView, false);
        bcvq.a(localakfb.jdField_a_of_type_ComTencentWidgetSwitch, false);
        bcvq.a(localakfb.jdField_a_of_type_AndroidWidgetImageView, false);
        localakfb.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(localakfb.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      if (Build.VERSION.SDK_INT >= 14) {
        localakfb.jdField_a_of_type_AndroidWidgetRelativeLayout.setAccessibilityDelegate(this.jdField_a_of_type_AndroidViewView$AccessibilityDelegate);
      }
      localakfb.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new akex(this, localRedTouch, localaovj));
      return paramView;
      localakfb.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849570);
      localakfb.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166901));
      break label151;
      localakfb = (akfb)paramView.getTag();
      break label184;
      label718:
      localakfb.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      localakfb.jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
      break label232;
      label746:
      paramViewGroup = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      break label339;
      label754:
      str = localaovj.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL;
      break label356;
      label767:
      paramInt = aekt.a(26.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      break label377;
      label784:
      localakfb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
      break label503;
      label796:
      localakfb.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
      break label503;
      label808:
      ((RedTouch)paramView).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akev
 * JD-Core Version:    0.7.0.1
 */