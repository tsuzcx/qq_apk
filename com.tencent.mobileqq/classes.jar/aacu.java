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

public class aacu
  extends aabq
{
  protected bbjc a;
  
  private void a(JSONObject paramJSONObject, @NonNull aabm paramaabm)
  {
    paramJSONObject = this.jdField_a_of_type_Aabp.a();
    if ((paramJSONObject instanceof BaseActivity)) {}
    for (int i = ((BaseActivity)paramJSONObject).getTitleBarHeight();; i = 0)
    {
      paramaabm = new aacv(this, i, paramaabm);
      if (this.jdField_a_of_type_Bbjc == null)
      {
        this.jdField_a_of_type_Bbjc = new bbjc(paramJSONObject);
        this.jdField_a_of_type_Bbjc.a(paramJSONObject.getString(2131719497));
        this.jdField_a_of_type_Bbjc.a(a(paramJSONObject));
      }
      this.jdField_a_of_type_Bbjc.a(paramaabm);
      try
      {
        this.jdField_a_of_type_Bbjc.a();
        return;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("DoraemonApi.ShareModule", 2, "actionSheet.show failed!", paramJSONObject);
      }
    }
  }
  
  public static List<bbje>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    bbje localbbje = new bbje();
    localbbje.a = paramContext.getString(2131696695);
    localbbje.jdField_b_of_type_Int = 2130838754;
    localbbje.jdField_b_of_type_Boolean = true;
    localbbje.c = 2;
    localbbje.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbje);
    localbbje = new bbje();
    localbbje.a = paramContext.getString(2131696708);
    localbbje.jdField_b_of_type_Int = 2130838755;
    localbbje.jdField_b_of_type_Boolean = true;
    localbbje.c = 3;
    localbbje.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbje);
    localbbje = new bbje();
    localbbje.a = paramContext.getString(2131696715);
    localbbje.jdField_b_of_type_Int = 2130838758;
    localbbje.c = 9;
    localbbje.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbje);
    localbbje = new bbje();
    localbbje.a = paramContext.getString(2131696698);
    localbbje.jdField_b_of_type_Int = 2130838752;
    localbbje.c = 10;
    localbbje.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbbje);
    return (List[])new ArrayList[] { localArrayList, new ArrayList() };
  }
  
  private void b(JSONObject paramJSONObject, @NonNull aabm paramaabm)
  {
    int i = paramJSONObject.optInt("shareChanel", 0);
    Activity localActivity = this.jdField_a_of_type_Aabp.a();
    if (!bbev.g(BaseApplicationImpl.getContext()))
    {
      aaet.a(paramaabm, -1, "net work not available");
      return;
    }
    Intent localIntent = new Intent(localActivity, TroopCreateLogicActivity.class);
    localIntent.putExtra("type", 8);
    localIntent.putExtra("chanelId", i);
    localIntent.putExtra("params", paramJSONObject.toString());
    localActivity.startActivity(localIntent);
    aaet.a(paramaabm, aabo.a);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull aabm paramaabm)
  {
    switch (paramInt)
    {
    case 28: 
    case 29: 
    default: 
      return false;
    case 30: 
      a(paramJSONObject, paramaabm);
    }
    for (;;)
    {
      return true;
      b(paramJSONObject, paramaabm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aacu
 * JD-Core Version:    0.7.0.1
 */