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

public class akjk
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private akjo jdField_a_of_type_Akjo;
  private akjp jdField_a_of_type_Akjp;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected LayoutInflater a;
  private View.AccessibilityDelegate jdField_a_of_type_AndroidViewView$AccessibilityDelegate = new akjn(this);
  protected QQAppInterface a;
  protected HashMap<String, Drawable> a;
  protected List<Object> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  public akjk(QQAppInterface paramQQAppInterface, Context paramContext, List<aozs> paramList, akjo paramakjo, akjp paramakjp)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.jdField_a_of_type_Akjo = paramakjo;
    this.jdField_a_of_type_Akjp = paramakjp;
    b();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844927);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844938);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private void a(RedTouch paramRedTouch, aozs paramaozs, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (byte b1 = 0;; b1 = 1)
    {
      paramaozs.jdField_a_of_type_Byte = b1;
      if (QLog.isColorLevel()) {
        QLog.i("LebaListMgrAdapter", 2, "name: " + paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + "  cCurFlag:" + paramaozs.jdField_a_of_type_Byte);
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      aieq.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      ((ambk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(31)).a(String.valueOf(paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), paramBoolean, l);
      if (paramBoolean)
      {
        axlx localaxlx = (axlx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        l = paramaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
        localaxlx.b("100600." + (100000000L + l) + "");
        if (paramRedTouch != null) {
          paramRedTouch.d();
        }
      }
      b();
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Akjp != null) {
        this.jdField_a_of_type_Akjp.a(paramaozs);
      }
      return;
    }
  }
  
  private void a(RedTouch paramRedTouch, String paramString)
  {
    paramString = ((axlx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramString);
    paramRedTouch.a(paramString);
    a(paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((axlx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramAppInfo);
  }
  
  private void a(ArrayList<aozs> paramArrayList)
  {
    int i = 1;
    if (paramArrayList.size() > 0) {}
    switch (paramArrayList.size())
    {
    default: 
      ((aozs)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
      while (i < paramArrayList.size() - 1)
      {
        ((aozs)paramArrayList.get(i)).jdField_a_of_type_Int = 3;
        i += 1;
      }
    case 1: 
      ((aozs)paramArrayList.get(0)).jdField_a_of_type_Int = 0;
      return;
    }
    ((aozs)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
    ((aozs)paramArrayList.get(1)).jdField_a_of_type_Int = 2;
    return;
    ((aozs)paramArrayList.get(paramArrayList.size() - 1)).jdField_a_of_type_Int = 2;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Akjo == null) {}
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
        if ((localObject instanceof aozs))
        {
          localObject = (aozs)localObject;
          if ((this.jdField_a_of_type_Akjo.a((aozs)localObject)) && (((aozs)localObject).jdField_a_of_type_Boolean) && (((aozs)localObject).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.cCanChangeState != 0)) {
            localArrayList.add(localObject);
          } else {
            this.jdField_b_of_type_Int += 1;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    } while (localArrayList.size() <= 0);
    Collections.sort(localArrayList, new alvs());
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    a(localArrayList);
  }
  
  public void a() {}
  
  public void a(List<aozs> paramList)
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
    aozs localaozs = (aozs)getItem(paramInt);
    if ((localaozs == null) || (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      paramViewGroup = paramView;
      return paramViewGroup;
    }
    akjq localakjq;
    label151:
    label184:
    RedTouch localRedTouch;
    label232:
    String str;
    if (paramView == null)
    {
      localakjq = new akjq();
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559025, paramViewGroup, false);
      localakjq.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369333));
      localakjq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369395));
      localakjq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369394));
      localakjq.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)paramView.findViewById(2131363728));
      if (ThemeUtil.isDefaultTheme())
      {
        localakjq.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849646);
        localakjq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166910));
        paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), paramView).c(100).a();
        paramView.setTag(localakjq);
        localRedTouch = (RedTouch)paramView;
        localakjq.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (localaozs.jdField_a_of_type_Byte != 0) {
          break label718;
        }
        localakjq.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        localakjq.jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        localakjq.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new akjl(this, localRedTouch, localaozs));
        if (QLog.isColorLevel()) {
          QLog.i("LebaListMgrAdapter", 2, "getview name: " + localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + "  cCurFlag:" + localaozs.jdField_a_of_type_Byte);
        }
        localakjq.jdField_a_of_type_AndroidWidgetTextView.setText(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        localakjq.jdField_a_of_type_Aozs = localaozs;
        if (!this.jdField_a_of_type_Boolean) {
          break label746;
        }
        paramViewGroup = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        label339:
        if (!this.jdField_a_of_type_Boolean) {
          break label754;
        }
        str = localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl;
        label356:
        if (!this.jdField_a_of_type_Boolean) {
          break label767;
        }
        paramInt = aepi.a(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        label377:
        Object localObject = (RelativeLayout.LayoutParams)localakjq.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).width = paramInt;
        ((RelativeLayout.LayoutParams)localObject).height = paramInt;
        localakjq.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        if ((localaozs == null) || (localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null)) {
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
        localakjq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
        label503:
        if (paramViewGroup != null) {
          ThemeUtil.setThemeFilter(paramViewGroup, ThemeUtil.curThemeId);
        }
        if (localaozs.jdField_a_of_type_Byte != 1) {
          break label808;
        }
        long l = localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
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
        bczz.a(localakjq.jdField_a_of_type_AndroidWidgetTextView, false);
        bczz.a(localakjq.jdField_a_of_type_ComTencentWidgetSwitch, false);
        bczz.a(localakjq.jdField_a_of_type_AndroidWidgetImageView, false);
        localakjq.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(localakjq.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      if (Build.VERSION.SDK_INT >= 14) {
        localakjq.jdField_a_of_type_AndroidWidgetRelativeLayout.setAccessibilityDelegate(this.jdField_a_of_type_AndroidViewView$AccessibilityDelegate);
      }
      localakjq.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new akjm(this, localRedTouch, localaozs));
      return paramView;
      localakjq.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849643);
      localakjq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166903));
      break label151;
      localakjq = (akjq)paramView.getTag();
      break label184;
      label718:
      localakjq.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      localakjq.jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
      break label232;
      label746:
      paramViewGroup = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      break label339;
      label754:
      str = localaozs.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL;
      break label356;
      label767:
      paramInt = aepi.a(26.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      break label377;
      label784:
      localakjq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
      break label503;
      label796:
      localakjq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
      break label503;
      label808:
      ((RedTouch)paramView).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akjk
 * JD-Core Version:    0.7.0.1
 */