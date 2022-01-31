import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class abtn
  extends absj
{
  protected ShareActionSheetBuilder a;
  
  private void a(JSONObject paramJSONObject, @NonNull absf paramabsf)
  {
    paramJSONObject = this.jdField_a_of_type_Absi.a();
    if ((paramJSONObject instanceof BaseActivity)) {}
    for (int i = ((BaseActivity)paramJSONObject).getTitleBarHeight();; i = 0)
    {
      paramabsf = new abto(this, i, paramabsf);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(paramJSONObject);
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetTitle(paramJSONObject.getString(2131720040));
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setActionSheetItems(a(paramJSONObject));
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.setItemClickListener(paramabsf);
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
    localActionSheetItem.label = paramContext.getString(2131696871);
    localActionSheetItem.icon = 2130838916;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696884);
    localActionSheetItem.icon = 2130838917;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696891);
    localActionSheetItem.icon = 2130838920;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131696874);
    localActionSheetItem.icon = 2130838914;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList, new ArrayList() };
  }
  
  private void b(JSONObject paramJSONObject, @NonNull absf paramabsf)
  {
    int i = paramJSONObject.optInt("shareChanel", 0);
    Activity localActivity = this.jdField_a_of_type_Absi.a();
    if (!bdee.g(BaseApplicationImpl.getContext()))
    {
      abvm.a(paramabsf, -1, "net work not available");
      return;
    }
    Intent localIntent = new Intent(localActivity, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 8);
    localIntent.putExtra("chanelId", i);
    localIntent.putExtra("params", paramJSONObject.toString());
    localActivity.startActivity(localIntent);
    abvm.a(paramabsf, absh.a);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull absf paramabsf)
  {
    switch (paramInt)
    {
    case 28: 
    case 29: 
    default: 
      return false;
    case 30: 
      a(paramJSONObject, paramabsf);
    }
    for (;;)
    {
      return true;
      b(paramJSONObject, paramabsf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abtn
 * JD-Core Version:    0.7.0.1
 */