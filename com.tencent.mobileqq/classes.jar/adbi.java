import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class adbi
  extends adae
{
  protected ShareActionSheetBuilder a;
  
  private void a(JSONObject paramJSONObject, @NonNull adaa paramadaa)
  {
    paramJSONObject = this.jdField_a_of_type_Adad.a();
    if ((paramJSONObject instanceof BaseActivity)) {}
    for (int i = ((BaseActivity)paramJSONObject).getTitleBarHeight();; i = 0)
    {
      paramadaa = new adbj(this, i, paramadaa);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(paramJSONObject);
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(paramJSONObject.getString(2131718786));
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(paramJSONObject));
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(paramadaa);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.show();
        return;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("DoraemonApi.ShareModule", 2, "actionSheet.show failed!", paramJSONObject);
      }
    }
  }
  
  public static List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696130);
    localActionSheetItem.icon = 2130839146;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696143);
    localActionSheetItem.icon = 2130839147;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696150);
    localActionSheetItem.icon = 2130839150;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696133);
    localActionSheetItem.icon = 2130839144;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, new ArrayList() };
  }
  
  private void b(JSONObject paramJSONObject, @NonNull adaa paramadaa)
  {
    int i = paramJSONObject.optInt("shareChanel", 0);
    Activity localActivity = this.jdField_a_of_type_Adad.a();
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      addh.a(paramadaa, -1, "net work not available");
      return;
    }
    Intent localIntent = new Intent(localActivity, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 8);
    localIntent.putExtra("chanelId", i);
    localIntent.putExtra("params", paramJSONObject.toString());
    localActivity.startActivity(localIntent);
    addh.a(paramadaa, adac.a);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull adaa paramadaa)
  {
    switch (paramInt)
    {
    case 28: 
    case 29: 
    default: 
      return false;
    case 30: 
      a(paramJSONObject, paramadaa);
    }
    for (;;)
    {
      return true;
      b(paramJSONObject, paramadaa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adbi
 * JD-Core Version:    0.7.0.1
 */