import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.PrinterActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsDeviceAdapter.3;
import com.tencent.mobileqq.activity.contacts.adapter.ContactsDeviceAdapter.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import cooperation.smartdevice.SmartDevicePluginDownloadActivity;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class afpl
  extends aimu
  implements View.OnClickListener
{
  protected int a;
  protected Context a;
  protected QQAppInterface a;
  public ArrayList<DeviceInfo> a;
  public boolean a;
  protected ArrayList<aiqo> b;
  protected boolean b;
  private boolean c;
  private boolean d;
  
  public afpl(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a(View paramView)
  {
    int i = 1;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (bhvv.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label134;
      }
      Intent localIntent1 = new Intent(this.jdField_a_of_type_AndroidContentContext, SmartDevicePluginDownloadActivity.class);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent1);
    }
    for (;;)
    {
      boolean bool;
      try
      {
        bool = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4).getBoolean("enable_public_device_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
        if (bool)
        {
          ymw.a(null, "Usr_NewDevice_Click", i, 0, 0);
          paramView.postDelayed(new ContactsDeviceAdapter.3(this), 1000L);
          return;
        }
      }
      catch (Exception localException1)
      {
        bool = true;
        continue;
        i = 0;
        continue;
      }
      label134:
      Intent localIntent2 = new Intent();
      localIntent2.putExtra("nickname", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
      localIntent2.putExtra("bitmap", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (byte)2, false));
      localIntent2.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
      String str1 = "com.tencent.device.activities.DeviceSearchActivity";
      try
      {
        localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4);
        bool = localSharedPreferences.getBoolean("enable_public_device_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
        str2 = localSharedPreferences.getString("square_url_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
        if (bool)
        {
          str1 = "com.tencent.device.activities.DeviceSquareActivity";
          i = 3;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          try
          {
            SharedPreferences localSharedPreferences;
            String str2;
            if (!TextUtils.isEmpty(str2)) {
              localIntent2.putExtra("url", str2);
            }
            bool = localSharedPreferences.getBoolean("search_device_enable_https_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
            if ((bfni.d()) && (bool)) {
              localIntent2.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
            }
            bhvv.a().a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent2, str1, 0, null, SmartDevicePluginProxyActivity.class);
            ymw.a(null, "Usr_NewDevice_Click", i, 0, 0);
          }
          catch (Exception localException3)
          {
            continue;
          }
          localException2 = localException2;
          i = 2;
          continue;
          i = 2;
        }
      }
    }
  }
  
  private void a(View paramView, Friends paramFriends)
  {
    this.jdField_a_of_type_Boolean = false;
    yak localyak = (yak)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    paramFriends = localyak.a(paramFriends.signature, paramFriends.iTermType);
    localyak.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramFriends, false);
    paramView.postDelayed(new ContactsDeviceAdapter.4(this), 1000L);
    long l;
    if (paramFriends == null)
    {
      l = paramFriends.din;
      if (paramFriends.isAdmin != 1) {
        break label129;
      }
      i = 1;
      ymw.a(null, l, "Usr_LiteApp_Open", i, 0, paramFriends.productId);
      l = paramFriends.din;
      if (paramFriends.userStatus != 10) {
        break label134;
      }
    }
    label129:
    label134:
    for (int i = 1;; i = 2)
    {
      ymw.a(null, l, "Usr_LiteApp_Open_Online", i, 0, paramFriends.productId);
      return;
      i = 2;
      break;
    }
  }
  
  private boolean a(String paramString)
  {
    akfm localakfm = (akfm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10);
    int i;
    if (paramString.equals(ajsf.z)) {
      i = localakfm.a();
    }
    for (;;)
    {
      if ((i == 1) || (i == 2))
      {
        return true;
        if (paramString.equals(ajsf.A)) {
          i = localakfm.b();
        }
      }
      else
      {
        return false;
      }
      i = 0;
    }
  }
  
  private void f()
  {
    ArrayList localArrayList = new ArrayList();
    Friends localFriends = new Friends();
    localFriends.uin = ajsf.z;
    localFriends.remark = ajyc.a(2131694495);
    localFriends.name = ajyc.a(2131694495);
    if (a(ajsf.z))
    {
      i = 10;
      localFriends.status = ((byte)i);
      localFriends.groupid = 1001;
      localArrayList.add(aiqj.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
      if (localFriends.status != 0) {
        this.jdField_a_of_type_Int += 1;
      }
      if ((a(ajsf.A)) || (this.c))
      {
        localFriends = new Friends();
        localFriends.uin = ajsf.A;
        localFriends.remark = this.jdField_a_of_type_AndroidContentContext.getString(2131693965);
        localFriends.name = this.jdField_a_of_type_AndroidContentContext.getString(2131693965);
        if (!a(ajsf.A)) {
          break label535;
        }
        i = 10;
        label179:
        localFriends.status = ((byte)i);
        localFriends.groupid = 1001;
        localArrayList.add(aiqj.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
        if (localFriends.status != 0) {
          this.jdField_a_of_type_Int += 1;
        }
        if (!this.d)
        {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005D18", "0X8005D18", 0, 0, "", "", "", "");
          this.d = true;
          if (QLog.isColorLevel()) {
            QLog.d("ContactsDeviceAdapter", 2, "=== dataline report event show ipad 0X8005D18 ");
          }
        }
      }
      if (((akcw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(74)).a())
      {
        localFriends = new Friends();
        localFriends.uin = ajsf.B;
        localFriends.remark = this.jdField_a_of_type_AndroidContentContext.getString(2131691379);
        localFriends.name = this.jdField_a_of_type_AndroidContentContext.getString(2131691379);
        if (!a(ajsf.A)) {
          break label540;
        }
      }
    }
    label535:
    label540:
    for (int i = 10;; i = 0)
    {
      localFriends.status = ((byte)i);
      localFriends.groupid = 1001;
      localArrayList.add(aiqj.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
      if (localFriends.status != 0) {
        this.jdField_a_of_type_Int += 1;
      }
      if ((!AppSetting.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
      {
        localFriends = new Friends();
        localFriends.uin = ajsf.y;
        localFriends.remark = this.jdField_a_of_type_AndroidContentContext.getString(2131691377);
        localFriends.name = this.jdField_a_of_type_AndroidContentContext.getString(2131691377);
        localFriends.status = 10;
        localFriends.groupid = 1001;
        localArrayList.add(aiqj.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
        this.jdField_a_of_type_Int += 1;
      }
      this.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList);
      if (!AppSetting.jdField_b_of_type_Boolean) {
        b();
      }
      return;
      i = 0;
      break;
      i = 0;
      break label179;
    }
  }
  
  public int a()
  {
    int i = 0;
    while (i < getCount())
    {
      Object localObject1 = getItem(i);
      if ((localObject1 != null) && ((localObject1 instanceof aiqk)))
      {
        localObject1 = (Friends)((aiqk)localObject1).a;
        Object localObject2 = (yak)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
        if (localObject2 != null)
        {
          localObject2 = ((yak)localObject2).b();
          if (((Friends)localObject1).name.equals(localObject2)) {
            return i;
          }
        }
      }
      i += 1;
    }
    return -1;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (this.jdField_b_of_type_JavaUtilArrayList != null) {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
    super.notifyDataSetChanged();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return;
    }
    localObject = ((List)localObject).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext())
    {
      Friends localFriends = (Friends)((aiqo)((Iterator)localObject).next()).a;
      if (((localFriends.uin.equals(ajsf.z)) || (localFriends.uin.equals(ajsf.B))) && ((paramString.equals(ajsf.z)) || (paramString.equals(ajsf.B))))
      {
        if (paramBoolean)
        {
          j = 10;
          label117:
          localFriends.status = ((byte)j);
        }
      }
      else
      {
        if (localFriends.uin.equals(paramString))
        {
          if (!paramBoolean) {
            break label174;
          }
          j = 10;
          label145:
          localFriends.status = ((byte)j);
        }
        if (localFriends.status == 0) {
          break label186;
        }
        i += 1;
      }
    }
    label174:
    label186:
    for (;;)
    {
      break;
      j = 0;
      break label117;
      j = 0;
      break label145;
      this.jdField_a_of_type_Int = i;
      return;
    }
  }
  
  public void b()
  {
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
    ArrayList localArrayList2 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
    HashMap localHashMap = new HashMap();
    yak localyak = (yak)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    DeviceInfo localDeviceInfo;
    Friends localFriends;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localDeviceInfo = (DeviceInfo)localIterator.next();
        if (localDeviceInfo.isAdmin == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("smartdevice::baseim.server_list", 2, "share device[" + localDeviceInfo.name + "] is not binded");
          }
        }
        else
        {
          localFriends = new Friends();
          localFriends.uin = ajsf.aa;
          if (localDeviceInfo.userStatus == 10)
          {
            i = 1;
            label170:
            if (localDeviceInfo.productId != 1000000344) {
              break label545;
            }
            i = 1;
          }
        }
      }
    }
    label545:
    for (;;)
    {
      int j;
      label190:
      byte b1;
      Object localObject;
      if (i != 0)
      {
        j = 10;
        b1 = (byte)j;
        localObject = (String)localHashMap.get(Integer.valueOf(localDeviceInfo.productId));
        if (!"1".equals(localObject)) {
          break label358;
        }
      }
      for (;;)
      {
        if (DeviceHeadMgr.getInstance().isLostQfindDevice(String.valueOf(localDeviceInfo.din))) {
          b1 = 12;
        }
        localFriends.remark = ymx.a(localDeviceInfo);
        localFriends.name = String.valueOf(localDeviceInfo.din);
        localFriends.signature = localDeviceInfo.serialNum;
        localFriends.status = b1;
        localFriends.groupid = 1001;
        localFriends.alias = localDeviceInfo.type;
        localFriends.iTermType = localDeviceInfo.productId;
        if (i == 0) {
          break label479;
        }
        localArrayList1.add(aiqj.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
        this.jdField_a_of_type_Int += 1;
        break;
        i = 0;
        break label170;
        j = 0;
        break label190;
        label358:
        if ("2".equals(localObject))
        {
          b1 = 11;
        }
        else
        {
          localObject = localyak.a(localDeviceInfo.productId);
          if ((localObject != null) && ((((ProductInfo)localObject).deviceType == 13) || (((ProductInfo)localObject).deviceType == 14) || ((((ProductInfo)localObject).deviceType == 17) && (((ProductInfo)localObject).uConnectType == 1))))
          {
            localHashMap.put(Integer.valueOf(localDeviceInfo.productId), "2");
            b1 = 11;
          }
          else if (localObject != null)
          {
            localHashMap.put(Integer.valueOf(localDeviceInfo.productId), "1");
          }
        }
      }
      label479:
      localArrayList2.add(aiqj.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
      break;
      if (localArrayList1.size() > 0) {
        this.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList1);
      }
      if (localArrayList2.size() > 0) {
        this.jdField_b_of_type_JavaUtilArrayList.addAll(localArrayList2);
      }
      return;
    }
  }
  
  public void d()
  {
    int j = 0;
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      return;
    }
    int i = 0;
    if (i < localArrayList.size()) {
      if (!((Friends)((aiqo)localArrayList.get(i)).a).uin.equals(ajsf.B)) {}
    }
    for (;;)
    {
      if (((akcw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(74)).a()) {
        if (i == -1)
        {
          Friends localFriends = new Friends();
          localFriends.uin = ajsf.B;
          localFriends.remark = this.jdField_a_of_type_AndroidContentContext.getString(2131691379);
          localFriends.name = this.jdField_a_of_type_AndroidContentContext.getString(2131691379);
          i = j;
          if (a(ajsf.z)) {
            i = 10;
          }
          localFriends.status = ((byte)i);
          localFriends.groupid = 1001;
          localArrayList.add(aiqj.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
        }
      }
      for (;;)
      {
        a(a(ajsf.z), ajsf.z);
        return;
        i += 1;
        break;
        if (i != -1) {
          localArrayList.remove(i);
        }
      }
      i = -1;
    }
  }
  
  public void e()
  {
    ArrayList localArrayList = this.jdField_b_of_type_JavaUtilArrayList;
    this.c = true;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {}
    label260:
    for (;;)
    {
      return;
      int i = 0;
      if (i < localArrayList.size()) {
        if (!((Friends)((aiqo)localArrayList.get(i)).a).uin.equals(ajsf.A)) {}
      }
      for (;;)
      {
        if (i != -1) {
          break label260;
        }
        Friends localFriends = new Friends();
        localFriends.uin = ajsf.A;
        localFriends.remark = this.jdField_a_of_type_AndroidContentContext.getString(2131693965);
        localFriends.name = this.jdField_a_of_type_AndroidContentContext.getString(2131693965);
        if (a(ajsf.A))
        {
          i = 10;
          label125:
          localFriends.status = ((byte)i);
          localFriends.groupid = 1001;
          localArrayList.add(aiqj.a(5, localFriends, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext));
          if (localFriends.status == 0) {
            break label252;
          }
        }
        label252:
        for (i = 1;; i = 0)
        {
          this.jdField_a_of_type_Int = i;
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005D18", "0X8005D18", 0, 0, "", "", "", "");
          this.d = true;
          if (QLog.isColorLevel()) {
            QLog.d("ContactsDeviceAdapter", 2, "=== dataline report event show ipad 0X8005D18 ");
          }
          ((akfm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(10)).d(1);
          return;
          i += 1;
          break;
          i = 0;
          break label125;
        }
        i = -1;
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    return (aiqo)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = ((aiqo)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt)).a(0, paramInt, paramView, paramViewGroup, null);
    if (paramView != null)
    {
      a((aiqr)paramView.getTag(), null);
      paramView.setOnClickListener(this);
    }
    return paramView;
  }
  
  public void notifyDataSetChanged()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    for (;;)
    {
      f();
      super.notifyDataSetChanged();
      return;
      this.jdField_b_of_type_JavaUtilArrayList.clear();
    }
  }
  
  public void onClick(View paramView)
  {
    aiqr localaiqr = (aiqr)paramView.getTag();
    BaseActivity localBaseActivity = null;
    Object localObject = localBaseActivity;
    if (localaiqr != null)
    {
      localObject = localBaseActivity;
      if ((localaiqr.a instanceof Friends)) {
        localObject = (Friends)localaiqr.a;
      }
    }
    if (localObject == null) {}
    for (;;)
    {
      return;
      if (ajsf.y.equals(((Friends)localObject).uin)) {
        if (QLog.isColorLevel()) {
          QLog.d("SDKQQAgentPerf", 2, "devicesearchEntry:" + System.currentTimeMillis());
        }
      }
      try
      {
        ((avpq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).b("100701.100702");
        label111:
        if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
        {
          localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
          if (Build.VERSION.SDK_INT < 23) {
            break label261;
          }
          if (akwg.a(localBaseActivity)) {
            break label253;
          }
          localBaseActivity.requestPermissions(new afpm(this, paramView, localBaseActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        }
        while (ajsf.z.equals(((Friends)localObject).uin))
        {
          paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
          paramView.putExtra("targetUin", ajsf.z);
          this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800603C", "0X800603C", 0, 0, "", "", "", "");
          return;
          label253:
          a(paramView);
          continue;
          label261:
          a(paramView);
        }
        if (ajsf.A.equals(((Friends)localObject).uin))
        {
          paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, LiteActivity.class);
          paramView.putExtra("targetUin", ajsf.A);
          this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006041", "0X8006041", 0, 0, "", "", "", "");
          return;
        }
        if (ajsf.B.equals(((Friends)localObject).uin))
        {
          paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, PrinterActivity.class);
          this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
          return;
        }
        if ((!ajsf.aa.equals(((Friends)localObject).uin)) || (!this.jdField_a_of_type_Boolean)) {
          continue;
        }
        if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
        {
          localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidContentContext;
          if (Build.VERSION.SDK_INT < 23) {
            continue;
          }
          if (!akwg.a(localBaseActivity))
          {
            localBaseActivity.requestPermissions(new afpn(this, paramView, (Friends)localObject, localBaseActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
            return;
          }
          a(paramView, (Friends)localObject);
          return;
        }
        a(paramView, (Friends)localObject);
        return;
      }
      catch (Exception localException)
      {
        break label111;
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
 * Qualified Name:     afpl
 * JD-Core Version:    0.7.0.1
 */