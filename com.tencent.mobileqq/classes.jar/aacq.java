import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class aacq
  extends aabm
{
  protected bbjq a;
  
  private void a(JSONObject paramJSONObject, @NonNull aabi paramaabi)
  {
    paramJSONObject = this.jdField_a_of_type_Aabl.a();
    if ((paramJSONObject instanceof BaseActivity)) {}
    for (int i = ((BaseActivity)paramJSONObject).getTitleBarHeight();; i = 0)
    {
      paramaabi = new aacr(this, i, paramaabi);
      if (this.jdField_a_of_type_Bbjq == null)
      {
        this.jdField_a_of_type_Bbjq = new bbjq(paramJSONObject);
        this.jdField_a_of_type_Bbjq.a(paramJSONObject.getString(2131719508));
        this.jdField_a_of_type_Bbjq.a(a(paramJSONObject));
      }
      this.jdField_a_of_type_Bbjq.a(paramaabi);
      try
      {
        this.jdField_a_of_type_Bbjq.a();
        return;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("DoraemonApi.ShareModule", 2, "actionSheet.show failed!", paramJSONObject);
      }
    }
  }
  
  public static List<bbjs>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    bbjs localbbjs = new bbjs();
    localbbjs.a = paramContext.getString(2131696696);
    localbbjs.jdField_b_of_type_Int = 2130838754;
    localbbjs.jdField_b_of_type_Boolean = true;
    localbbjs.c = 2;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    localbbjs = new bbjs();
    localbbjs.a = paramContext.getString(2131696709);
    localbbjs.jdField_b_of_type_Int = 2130838755;
    localbbjs.jdField_b_of_type_Boolean = true;
    localbbjs.c = 3;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    localbbjs = new bbjs();
    localbbjs.a = paramContext.getString(2131696716);
    localbbjs.jdField_b_of_type_Int = 2130838758;
    localbbjs.c = 9;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    localbbjs = new bbjs();
    localbbjs.a = paramContext.getString(2131696699);
    localbbjs.jdField_b_of_type_Int = 2130838752;
    localbbjs.c = 10;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbjs);
    return (List[])new ArrayList[] { localArrayList, new ArrayList() };
  }
  
  private void b(JSONObject paramJSONObject, @NonNull aabi paramaabi)
  {
    int i = paramJSONObject.optInt("shareChanel", 0);
    Activity localActivity = this.jdField_a_of_type_Aabl.a();
    if (!bbfj.g(BaseApplicationImpl.getContext()))
    {
      aaep.a(paramaabi, -1, "net work not available");
      return;
    }
    Intent localIntent = new Intent(localActivity, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 8);
    localIntent.putExtra("chanelId", i);
    localIntent.putExtra("params", paramJSONObject.toString());
    localActivity.startActivity(localIntent);
    aaep.a(paramaabi, aabk.a);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull aabi paramaabi)
  {
    switch (paramInt)
    {
    case 28: 
    case 29: 
    default: 
      return false;
    case 30: 
      a(paramJSONObject, paramaabi);
    }
    for (;;)
    {
      return true;
      b(paramJSONObject, paramaabi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacq
 * JD-Core Version:    0.7.0.1
 */