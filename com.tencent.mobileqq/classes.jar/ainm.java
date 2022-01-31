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

public class ainm
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private ainq jdField_a_of_type_Ainq;
  private ainr jdField_a_of_type_Ainr;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected LayoutInflater a;
  private View.AccessibilityDelegate jdField_a_of_type_AndroidViewView$AccessibilityDelegate = new ainp(this);
  protected QQAppInterface a;
  protected HashMap<String, Drawable> a;
  protected List<Object> a;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  public ainm(QQAppInterface paramQQAppInterface, Context paramContext, List<andx> paramList, ainq paramainq, ainr paramainr)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    this.jdField_a_of_type_Ainq = paramainq;
    this.jdField_a_of_type_Ainr = paramainr;
    b();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844490);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844501);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
  }
  
  private void a(RedTouch paramRedTouch, andx paramandx, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (byte b1 = 0;; b1 = 1)
    {
      paramandx.jdField_a_of_type_Byte = b1;
      if (QLog.isColorLevel()) {
        QLog.i("LebaListMgrAdapter", 2, "name: " + paramandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + "  cCurFlag:" + paramandx.jdField_a_of_type_Byte);
      }
      long l = NetConnInfoCenter.getServerTimeMillis();
      agca.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId, paramBoolean, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      ((akfg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(31)).a(String.valueOf(paramandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId), paramBoolean, l);
      if (paramBoolean)
      {
        avpq localavpq = (avpq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
        l = paramandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
        localavpq.b("100600." + (100000000L + l) + "");
        if (paramRedTouch != null) {
          paramRedTouch.b();
        }
      }
      b();
      notifyDataSetChanged();
      if (this.jdField_a_of_type_Ainr != null) {
        this.jdField_a_of_type_Ainr.a(paramandx);
      }
      return;
    }
  }
  
  private void a(RedTouch paramRedTouch, String paramString)
  {
    paramString = ((avpq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramString);
    paramRedTouch.a(paramString);
    a(paramString);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((avpq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(paramAppInfo);
  }
  
  private void a(ArrayList<andx> paramArrayList)
  {
    int i = 1;
    if (paramArrayList.size() > 0) {}
    switch (paramArrayList.size())
    {
    default: 
      ((andx)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
      while (i < paramArrayList.size() - 1)
      {
        ((andx)paramArrayList.get(i)).jdField_a_of_type_Int = 3;
        i += 1;
      }
    case 1: 
      ((andx)paramArrayList.get(0)).jdField_a_of_type_Int = 0;
      return;
    }
    ((andx)paramArrayList.get(0)).jdField_a_of_type_Int = 1;
    ((andx)paramArrayList.get(1)).jdField_a_of_type_Int = 2;
    return;
    ((andx)paramArrayList.get(paramArrayList.size() - 1)).jdField_a_of_type_Int = 2;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Ainq == null) {}
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
        if ((localObject instanceof andx))
        {
          localObject = (andx)localObject;
          if ((this.jdField_a_of_type_Ainq.a((andx)localObject)) && (((andx)localObject).jdField_a_of_type_Boolean) && (((andx)localObject).jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.cCanChangeState != 0)) {
            localArrayList.add(localObject);
          } else {
            this.jdField_b_of_type_Int += 1;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    } while (localArrayList.size() <= 0);
    Collections.sort(localArrayList, new ajzr());
    this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
    a(localArrayList);
  }
  
  public void a() {}
  
  public void a(List<andx> paramList)
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
    andx localandx = (andx)getItem(paramInt);
    if ((localandx == null) || (localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null))
    {
      paramViewGroup = paramView;
      return paramViewGroup;
    }
    ains localains;
    label151:
    label184:
    RedTouch localRedTouch;
    label232:
    String str;
    if (paramView == null)
    {
      localains = new ains();
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558987, paramViewGroup, false);
      localains.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369083));
      localains.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369145));
      localains.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369144));
      localains.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)paramView.findViewById(2131363673));
      if (ThemeUtil.isDefaultTheme())
      {
        localains.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849133);
        localains.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166861));
        paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), paramView).c(100).a();
        paramView.setTag(localains);
        localRedTouch = (RedTouch)paramView;
        localains.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
        if (localandx.jdField_a_of_type_Byte != 0) {
          break label688;
        }
        localains.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        localains.jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        localains.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new ainn(this, localRedTouch, localandx));
        if (QLog.isColorLevel()) {
          QLog.i("LebaListMgrAdapter", 2, "getview name: " + localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName + "  cCurFlag:" + localandx.jdField_a_of_type_Byte);
        }
        localains.jdField_a_of_type_AndroidWidgetTextView.setText(localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
        localains.jdField_a_of_type_Andx = localandx;
        if (!this.jdField_a_of_type_Boolean) {
          break label716;
        }
        paramViewGroup = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        label339:
        if (!this.jdField_a_of_type_Boolean) {
          break label724;
        }
        str = localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strGridIconUrl;
        label356:
        if ((localandx == null) || (localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo == null) || (TextUtils.isEmpty(localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strPkgName))) {
          break label749;
        }
        if (TextUtils.isEmpty(str)) {
          break label737;
        }
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = actn.a(26.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localURLDrawableOptions.mRequestHeight = localURLDrawableOptions.mRequestWidth;
        localURLDrawableOptions.mLoadingDrawable = paramViewGroup;
        localURLDrawableOptions.mFailedDrawable = paramViewGroup;
        paramViewGroup = URLDrawable.getDrawable(str, localURLDrawableOptions);
        paramViewGroup.setTargetDensity(this.jdField_a_of_type_Int);
        if (paramViewGroup.getStatus() == 2) {
          paramViewGroup.restartDownload();
        }
        localains.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
        label473:
        if (paramViewGroup != null) {
          ThemeUtil.setThemeFilter(paramViewGroup, ThemeUtil.curThemeId);
        }
        if (localandx.jdField_a_of_type_Byte != 1) {
          break label761;
        }
        long l = localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.uiResId;
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
        bawi.a(localains.jdField_a_of_type_AndroidWidgetTextView, false);
        bawi.a(localains.jdField_a_of_type_ComTencentWidgetSwitch, false);
        bawi.a(localains.jdField_a_of_type_AndroidWidgetImageView, false);
        localains.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(localains.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      if (Build.VERSION.SDK_INT >= 14) {
        localains.jdField_a_of_type_AndroidWidgetRelativeLayout.setAccessibilityDelegate(this.jdField_a_of_type_AndroidViewView$AccessibilityDelegate);
      }
      localains.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new aino(this, localRedTouch, localandx));
      return paramView;
      localains.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130849130);
      localains.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166854));
      break label151;
      localains = (ains)paramView.getTag();
      break label184;
      label688:
      localains.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      localains.jdField_a_of_type_ComTencentWidgetSwitch.setContentDescription(localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResName);
      break label232;
      label716:
      paramViewGroup = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      break label339;
      label724:
      str = localandx.jdField_a_of_type_ComTencentMobileqqDataLebaPluginInfo.strResURL;
      break label356;
      label737:
      localains.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
      break label473;
      label749:
      localains.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramViewGroup);
      break label473;
      label761:
      ((RedTouch)paramView).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ainm
 * JD-Core Version:    0.7.0.1
 */