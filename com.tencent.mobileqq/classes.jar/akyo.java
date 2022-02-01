import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import org.json.JSONArray;

public class akyo
{
  private static volatile akyo jdField_a_of_type_Akyo;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { anvx.a(2131712780), anvx.a(2131712770), anvx.a(2131712751) };
  private static final String[] b = { anvx.a(2131712776), anvx.a(2131712771), anvx.a(2131712756) };
  
  public static akyo a()
  {
    if (jdField_a_of_type_Akyo == null) {}
    try
    {
      if (jdField_a_of_type_Akyo == null) {
        jdField_a_of_type_Akyo = new akyo();
      }
      return jdField_a_of_type_Akyo;
    }
    finally {}
  }
  
  public int a()
  {
    Object localObject = albw.a();
    if (localObject != null)
    {
      localObject = (aktz)((QQAppInterface)localObject).getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
      if (localObject != null) {
        return ((aktz)localObject).a("hb_exclusive", 1, new String[] { "ani_queue_max" });
      }
    }
    return 1;
  }
  
  public String a(int paramInt)
  {
    Object localObject1 = albw.a();
    Object localObject2;
    JSONArray localJSONArray;
    if (localObject1 != null)
    {
      localObject2 = (aktz)((QQAppInterface)localObject1).getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
      if (localObject2 != null) {
        if (paramInt == 0)
        {
          localObject1 = "ask_text_list";
          localJSONArray = ((aktz)localObject2).a("hb_exclusive", new String[] { "aio_red", localObject1 });
          if (paramInt != 0) {
            break label110;
          }
          localObject1 = jdField_a_of_type_ArrayOfJavaLangString;
          label59:
          localObject2 = localObject1;
          if (localJSONArray != null)
          {
            if (localJSONArray.length() != 0) {
              break label117;
            }
            localObject2 = localObject1;
          }
        }
      }
    }
    for (;;)
    {
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        return localObject2[(new java.util.Random().nextInt(localObject2.length + 0) + 0)];
        localObject1 = "thx_text_list";
        break;
        label110:
        localObject1 = b;
        break label59;
        label117:
        localObject2 = new String[localJSONArray.length()];
        paramInt = 0;
      }
      while (paramInt < localJSONArray.length())
      {
        localObject2[paramInt] = localJSONArray.optString(paramInt);
        paramInt += 1;
        continue;
        return null;
      }
      continue;
      localObject2 = null;
    }
  }
  
  public boolean a()
  {
    Object localObject = albw.a();
    if (localObject != null)
    {
      localObject = (aktz)((QQAppInterface)localObject).getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
      if (localObject != null) {
        return ((aktz)localObject).a("hb_exclusive", 1, new String[] { "is_display_all" }) == 1;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyo
 * JD-Core Version:    0.7.0.1
 */