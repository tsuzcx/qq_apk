import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class aixn
  extends aixl
{
  public long a;
  public String a;
  public WeakReference<QQSettingMe> a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public int f;
  int g = 7;
  private int h;
  
  public aixn(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject, QQSettingMe paramQQSettingMe)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 98;
    this.jdField_b_of_type_Int = paramJSONObject.optInt("entry_id", 1);
    this.jdField_a_of_type_Long = paramJSONObject.optLong("seq", 0L);
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("wording");
    this.jdField_b_of_type_JavaLangString = paramJSONObject.optString("jump_url");
    this.jdField_c_of_type_Int = paramJSONObject.optInt("is_red", 0);
    this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("icon_url");
    this.jdField_d_of_type_Int = paramJSONObject.optInt("action_id", 0);
    this.e = paramJSONObject.optInt("bubble_id", 0);
    this.jdField_d_of_type_JavaLangString = paramJSONObject.optString("scheme");
    this.f = paramJSONObject.optInt("show_sum", 1);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQSettingMe);
  }
  
  public void a(ajfs paramajfs, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExploreDrawerStatus", 2, "[onBubbleClick] " + this.jdField_d_of_type_JavaLangString + "|" + this.jdField_b_of_type_JavaLangString);
    }
    ((airz)paramQQAppInterface.getManager(153)).a(paramQQAppInterface, paramContext, this.jdField_d_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, "drawer");
  }
  
  public void a(ajfs paramajfs, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.h >= this.f) {}
    do
    {
      do
      {
        return;
        this.h += 1;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          ajfj.a(paramajfs, this.jdField_a_of_type_JavaLangString, 9, this.e);
        }
      } while ((TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
      paramajfs = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramajfs == null);
    paramajfs.a(this.jdField_c_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aixn
 * JD-Core Version:    0.7.0.1
 */