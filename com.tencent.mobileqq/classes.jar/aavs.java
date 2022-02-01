import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class aavs
  implements AdapterView.OnItemClickListener
{
  static String a;
  public static String b;
  public static String c;
  public static String d = "https://spqq.mp.qq.com/pub/get_face_https?img_type=3&uin=";
  protected float a;
  protected int a;
  protected aavu a;
  protected BaseActivity a;
  protected QQAppInterface a;
  protected ShareActionSheetBuilder a;
  protected String e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://imgplat.store.qq.com/bqq_qfpic/520520/%s_%s_face/0";
    jdField_b_of_type_JavaLangString = "https://s.p.qq.com/pub/get_face?img_type=3&uin=";
    jdField_c_of_type_JavaLangString = "https://spqq.mp.qq.com/pub/get_face?img_type=3&uin=";
  }
  
  public aavs(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, aavu paramaavu, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Float = paramBaseActivity.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Aavu = paramaavu;
    this.jdField_a_of_type_Int = paramInt;
    this.e = paramString;
  }
  
  public static String a(String paramString)
  {
    if ((paramString.length() <= 30) && (paramString.getBytes().length <= 100)) {
      return paramString;
    }
    String str = paramString;
    if (paramString.length() > 30) {
      str = paramString.substring(0, 30);
    }
    paramString = str;
    if (Math.min(str.getBytes().length, 100) == 100)
    {
      int i = str.length() / 2;
      paramString = new StringBuilder(str.substring(0, i));
      while (paramString.toString().getBytes().length < 100)
      {
        paramString.append(str.charAt(i));
        i += 1;
      }
      paramString = paramString.toString();
    }
    return paramString + "...";
  }
  
  public static void a(Activity paramActivity, aavu paramaavu, int paramInt, String paramString)
  {
    bkgt.a(paramActivity, 6, paramaavu.jdField_b_of_type_JavaLangString, paramaavu.jdField_c_of_type_JavaLangString, paramString, "mqqapi://card/show_pslcard?src_type=internal&source=sharecard&version=1&uin=" + paramaavu.jdField_a_of_type_JavaLangString, paramaavu.jdField_a_of_type_JavaLangString, paramInt, true);
  }
  
  public static void a(Activity paramActivity, aavu paramaavu, int paramInt, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_req", ForwardRecentActivity.f);
    localBundle.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
    localBundle.putString("key_direct_show_uin", paramActionSheetItem.uin);
    Intent localIntent = new Intent();
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ShareActionSheet shareToFriend");
    }
    localIntent.setClass(paramActivity, ForwardRecentActivity.class);
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("category", paramActivity.getString(2131694697));
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("detail_url", paramString);
    localIntent.putExtra("title", paramaavu.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("forward _key_nojump", true);
    localIntent.putExtra("desc", a(paramaavu.jdField_c_of_type_JavaLangString));
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("struct_share_key_content_action", "plugin");
    localIntent.putExtra("pubUin", paramaavu.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("pluginName", "public_account");
    paramActionSheetItem = "";
    paramString = "";
    if (paramInt == 1)
    {
      localIntent.putExtra("image_url_remote", jdField_b_of_type_JavaLangString + paramaavu.jdField_a_of_type_JavaLangString);
      paramActionSheetItem = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramaavu.jdField_a_of_type_JavaLangString;
      paramString = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=" + paramaavu.jdField_a_of_type_JavaLangString + "&version=1";
    }
    for (;;)
    {
      localIntent.putExtra("struct_share_key_content_a_action_DATA", paramActionSheetItem);
      localIntent.putExtra("struct_share_key_content_i_action_DATA", paramString);
      localIntent.putExtras(localBundle);
      paramaavu = bdow.a(localIntent.getExtras());
      if (paramaavu != null)
      {
        localIntent.putExtra("stuctmsg_bytes", paramaavu.getBytes());
        localIntent.putExtra("from_card", true);
        auxu.a(paramActivity, localIntent, ForwardRecentTranslucentActivity.class, 123, -1, "");
      }
      return;
      if (paramInt == 2)
      {
        long l = Long.parseLong(paramaavu.jdField_a_of_type_JavaLangString);
        paramInt = (int)(l % 256L);
        localIntent.putExtra("image_url_remote", String.format(jdField_a_of_type_JavaLangString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l) }));
        paramActionSheetItem = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramaavu.jdField_a_of_type_JavaLangString;
        paramString = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramaavu.jdField_a_of_type_JavaLangString + "&version=1";
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, aavu paramaavu, int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("title", paramaavu.jdField_b_of_type_JavaLangString);
    localBundle.putString("desc", paramaavu.jdField_c_of_type_JavaLangString);
    localBundle.putString("detail_url", paramString);
    paramString = new ArrayList(1);
    if (paramInt == 1) {
      paramString.add(jdField_b_of_type_JavaLangString + paramaavu.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      localBundle.putStringArrayList("image_url", paramString);
      localBundle.putLong("req_share_id", 0L);
      localBundle.putString("pubUin", paramaavu.jdField_a_of_type_JavaLangString);
      localBundle.putBoolean("from_card", true);
      bmud.a(paramBaseActivity.app, paramBaseActivity, localBundle, null);
      return;
      if (paramInt == 2) {
        try
        {
          long l = Long.parseLong(paramaavu.jdField_a_of_type_JavaLangString);
          paramInt = (int)(l % 256L);
          paramString.add(String.format(jdField_a_of_type_JavaLangString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l) }));
        }
        catch (Exception paramBaseActivity) {}
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, aavu paramaavu, int paramInt1, String paramString, int paramInt2)
  {
    paramInt1 = 0;
    if (!WXShareHelper.a().a())
    {
      zyx.a(0, 2131719399);
      return;
    }
    if (!WXShareHelper.a().b())
    {
      zyx.a(0, 2131719400);
      return;
    }
    String str = String.valueOf(System.currentTimeMillis());
    WXShareHelper.a().a(new aavt(str));
    paramBaseActivity = paramBaseActivity.app.a(paramaavu.jdField_a_of_type_JavaLangString, (byte)1, true);
    if (paramInt2 == 9) {}
    for (;;)
    {
      WXShareHelper.a().b(str, paramaavu.jdField_b_of_type_JavaLangString, paramBaseActivity, paramaavu.jdField_c_of_type_JavaLangString, paramString, paramInt1);
      return;
      paramInt1 = 1;
    }
  }
  
  public static void b(Activity paramActivity, aavu paramaavu, int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ShareActionSheet shareToFriend");
    }
    localIntent.setClass(paramActivity, ForwardRecentActivity.class);
    localIntent.putExtra("key_flag_from_plugin", true);
    localIntent.putExtra("category", paramActivity.getString(2131694697));
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("detail_url", paramString);
    localIntent.putExtra("title", paramaavu.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("forward _key_nojump", true);
    localIntent.putExtra("desc", a(paramaavu.jdField_c_of_type_JavaLangString));
    localIntent.putExtra("req_type", 1);
    localIntent.putExtra("struct_share_key_content_action", "plugin");
    localIntent.putExtra("pubUin", paramaavu.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("pluginName", "public_account");
    String str = "";
    paramString = "";
    if (paramInt == 1)
    {
      localIntent.putExtra("image_url_remote", jdField_b_of_type_JavaLangString + paramaavu.jdField_a_of_type_JavaLangString);
      str = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramaavu.jdField_a_of_type_JavaLangString;
      paramString = "mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=" + paramaavu.jdField_a_of_type_JavaLangString + "&version=1";
    }
    for (;;)
    {
      localIntent.putExtra("struct_share_key_content_a_action_DATA", str);
      localIntent.putExtra("struct_share_key_content_i_action_DATA", paramString);
      paramaavu = bdow.a(localIntent.getExtras());
      if (paramaavu != null)
      {
        localIntent.putExtra("stuctmsg_bytes", paramaavu.getBytes());
        localIntent.putExtra("from_card", true);
        paramActivity.startActivity(localIntent);
      }
      return;
      if (paramInt == 2)
      {
        long l = Long.parseLong(paramaavu.jdField_a_of_type_JavaLangString);
        paramInt = (int)(l % 256L);
        localIntent.putExtra("image_url_remote", String.format(jdField_a_of_type_JavaLangString, new Object[] { Integer.valueOf(paramInt), Long.valueOf(l) }));
        str = "mqqapi://app/action?pkg=com.tencent.mobileqq&account_type=2&uintype=1024&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramaavu.jdField_a_of_type_JavaLangString;
        paramString = "mqqapi://card/show_pslcard?src_type=internal&card_type=qq_bussiness_account&uin=" + paramaavu.jdField_a_of_type_JavaLangString + "&version=1";
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718159));
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(this);
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShareActionSheet", 2, "actionSheet.show exception=" + localException);
    }
  }
  
  protected List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695738);
    localActionSheetItem.icon = 2130839091;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695751);
    localActionSheetItem.icon = 2130839092;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695758);
    localActionSheetItem.icon = 2130839095;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131695741);
    localActionSheetItem.icon = 2130839089;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    bkgt.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localArrayList);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = paramView.getTag();
    if (localObject1 == null)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
    int i = ((bhsc)localObject1).a.action;
    Object localObject3;
    Object localObject2;
    switch (i)
    {
    default: 
      localObject1 = null;
    case 2: 
    case 3: 
      while ((this.jdField_a_of_type_Aavu.jdField_c_of_type_Int == aavu.jdField_b_of_type_Int) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = this.jdField_a_of_type_Aavu.jdField_a_of_type_JavaLangString;
        if (!this.jdField_a_of_type_Aavu.jdField_a_of_type_Boolean) {
          break label447;
        }
        localObject2 = "02";
        bdll.b((QQAppInterface)localObject3, "dc01160", "Pb_account_lifeservice", str, "0X8007CA6", "0X8007CA6", 0, 0, (String)localObject2, (String)localObject1, String.valueOf(this.jdField_a_of_type_Aavu.d), "");
        break;
        b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Aavu, this.jdField_a_of_type_Int, this.e);
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aavu.jdField_a_of_type_JavaLangString, "Grp_tribe", "interest_data", "share_qq");
        localObject1 = "01";
        continue;
        a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Aavu, this.jdField_a_of_type_Int, this.e);
        PublicAccountHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aavu.jdField_a_of_type_JavaLangString, "Grp_tribe", "interest_data", "share_qzone");
        localObject1 = "02";
      }
    case 9: 
    case 10: 
      label150:
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Aavu, this.jdField_a_of_type_Int, this.e, i);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject3 = this.jdField_a_of_type_Aavu.jdField_a_of_type_JavaLangString;
      if (i == 9)
      {
        localObject1 = "share_wechat";
        label338:
        PublicAccountHandler.a((AppInterface)localObject2, (String)localObject3, "Grp_tribe", "interest_data", (String)localObject1);
        ocd.a(null, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_Aavu.jdField_a_of_type_JavaLangString, "0X8005A2C", "0X8005A2C", 0, 0, "", "", "", "", false);
        if (9 != i) {
          break label455;
        }
      }
      break;
    }
    label447:
    label455:
    for (localObject1 = "03"; 10 == i; localObject1 = null)
    {
      localObject1 = "04";
      break;
      localObject1 = "share_circle";
      break label338;
      a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Aavu, this.jdField_a_of_type_Int, this.e);
      localObject1 = null;
      break;
      localObject2 = "01";
      break label150;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aavs
 * JD-Core Version:    0.7.0.1
 */