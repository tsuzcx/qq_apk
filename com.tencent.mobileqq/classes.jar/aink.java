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

public class aink
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private aino jdField_a_of_type_Aino;
  private ainp jdField_a_of_type_Ainp;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected LayoutInflater a;
  private View.AccessibilityDelegate jdField_a_of_type_AndroidViewView$AccessibilityDelegate = new ainn(this);
  protected QQAppInterface a;
  protected HashMap<String, Drawable> a;
  protected List<Object> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  public aink(QQAppInterface paramQQAppInterface, Context paramContext, List<anec> paramList, aino paramaino, ainp paramainp)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.jdField_a_of_type_Aino = paramaino;
    this.jdField_a_of_type_Ainp = paramainp;
    b();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844491);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844502);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private void a(RedTouch paramRedTouch, anec paramanec, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (byte b1 = 0;; b1 = 1)
    {
      paramanec.jdField_a_of_type_Byte = b1;
      if (QLog.isColorLevel()) {
        QLog.i("LebaListMgrAdapter", 2, "name: " + paramanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + "  cCurFlag:" + paramanec.jdField_a_of_type_Byte);
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      agby.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      ((akff)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(31)).a(String.valueOf(paramanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), paramBoolean, l);
      if (paramBoolean)
      {
        avps localavps = (avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        l = paramanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
        localavps.b("100600." + (100000000L + l) + "");
        if (paramRedTouch != null) {
          paramRedTouch.b();
        }
      }
      b();
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Ainp != null) {
        this.jdField_a_of_type_Ainp.a(paramanec);
      }
      return;
    }
  }
  
  private void a(RedTouch paramRedTouch, String paramString)
  {
    paramString = ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramString);
    paramRedTouch.a(paramString);
    a(paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((avps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramAppInfo);
  }
  
  private void a(ArrayList<anec> paramArrayList)
  {
    int i = 1;
    if (paramArrayList.size() > 0) {}
    switch (paramArrayList.size())
    {
    default: 
      ((anec)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
      while (i < paramArrayList.size() - 1)
      {
        ((anec)paramArrayList.get(i)).jdField_a_of_type_Int = 3;
        i += 1;
      }
    case 1: 
      ((anec)paramArrayList.get(0)).jdField_a_of_type_Int = 0;
      return;
    }
    ((anec)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
    ((anec)paramArrayList.get(1)).jdField_a_of_type_Int = 2;
    return;
    ((anec)paramArrayList.get(paramArrayList.size() - 1)).jdField_a_of_type_Int = 2;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Aino == null) {}
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
        if ((localObject instanceof anec))
        {
          localObject = (anec)localObject;
          if ((this.jdField_a_of_type_Aino.a((anec)localObject)) && (((anec)localObject).jdField_a_of_type_Boolean) && (((anec)localObject).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.cCanChangeState != 0)) {
            localArrayList.add(localObject);
          } else {
            this.jdField_b_of_type_Int += 1;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    } while (localArrayList.size() <= 0);
    Collections.sort(localArrayList, new ajzp());
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    a(localArrayList);
  }
  
  public void a() {}
  
  public void a(List<anec> paramList)
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
    anec localanec = (anec)getItem(paramInt);
    if ((localanec == null) || (localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      paramViewGroup = paramView;
      return paramViewGroup;
    }
    ainq localainq;
    label151:
    label184:
    RedTouch localRedTouch;
    label232:
    String str;
    if (paramView == null)
    {
      localainq = new ainq();
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558987, paramViewGroup, false);
      localainq.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369083));
      localainq.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369145));
      localainq.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369144));
      localainq.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)paramView.findViewById(2131363672));
      if (ThemeUtil.isDefaultTheme())
      {
        localainq.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849142);
        localainq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166861));
        paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), paramView).c(100).a();
        paramView.setTag(localainq);
        localRedTouch = (RedTouch)paramView;
        localainq.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (localanec.jdField_a_of_type_Byte != 0) {
          break label688;
        }
        localainq.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        localainq.jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        localainq.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ainl(this, localRedTouch, localanec));
        if (QLog.isColorLevel()) {
          QLog.i("LebaListMgrAdapter", 2, "getview name: " + localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + "  cCurFlag:" + localanec.jdField_a_of_type_Byte);
        }
        localainq.jdField_a_of_type_AndroidWidgetTextView.setText(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        localainq.jdField_a_of_type_Anec = localanec;
        if (!this.jdField_a_of_type_Boolean) {
          break label716;
        }
        paramViewGroup = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        label339:
        if (!this.jdField_a_of_type_Boolean) {
          break label724;
        }
        str = localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl;
        label356:
        if ((localanec == null) || (localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (TextUtils.isEmpty(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName))) {
          break label749;
        }
        if (TextUtils.isEmpty(str)) {
          break label737;
        }
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = actj.a(26.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localURLDrawableOptions.mRequestHeight = localURLDrawableOptions.mRequestWidth;
        localURLDrawableOptions.mLoadingDrawable = paramViewGroup;
        localURLDrawableOptions.mFailedDrawable = paramViewGroup;
        paramViewGroup = URLDrawable.getDrawable(str, localURLDrawableOptions);
        paramViewGroup.setTargetDensity(this.jdField_a_of_type_Int);
        if (paramViewGroup.getStatus() == 2) {
          paramViewGroup.restartDownload();
        }
        localainq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
        label473:
        if (paramViewGroup != null) {
          ThemeUtil.setThemeFilter(paramViewGroup, ThemeUtil.curThemeId);
        }
        if (localanec.jdField_a_of_type_Byte != 1) {
          break label761;
        }
        long l = localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
        a((RedTouch)paramView, "100600." + (100000000L + l) + "");
      }
    }
    for (;;)
    {
      paramViewGroup = paramView;
      if (!AppSetting.d) {
        break;
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        baww.a(localainq.jdField_a_of_type_AndroidWidgetTextView, false);
        baww.a(localainq.jdField_a_of_type_ComTencentWidgetSwitch, false);
        baww.a(localainq.jdField_a_of_type_AndroidWidgetImageView, false);
        localainq.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(localainq.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      if (Build.VERSION.SDK_INT >= 14) {
        localainq.jdField_a_of_type_AndroidWidgetRelativeLayout.setAccessibilityDelegate(this.jdField_a_of_type_AndroidViewView$AccessibilityDelegate);
      }
      localainq.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ainm(this, localRedTouch, localanec));
      return paramView;
      localainq.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849139);
      localainq.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166854));
      break label151;
      localainq = (ainq)paramView.getTag();
      break label184;
      label688:
      localainq.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      localainq.jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
      break label232;
      label716:
      paramViewGroup = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      break label339;
      label724:
      str = localanec.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL;
      break label356;
      label737:
      localainq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
      break label473;
      label749:
      localainq.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
      break label473;
      label761:
      ((RedTouch)paramView).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aink
 * JD-Core Version:    0.7.0.1
 */