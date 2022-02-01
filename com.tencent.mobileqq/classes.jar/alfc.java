import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONArray;

public class alfc
{
  private static volatile alfc jdField_a_of_type_Alfc;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { anzj.a(2131712201), anzj.a(2131712191), anzj.a(2131712172) };
  private static final String[] b = { anzj.a(2131712197), anzj.a(2131712192), anzj.a(2131712177) };
  
  public static alfc a()
  {
    if (jdField_a_of_type_Alfc == null) {}
    try
    {
      if (jdField_a_of_type_Alfc == null) {
        jdField_a_of_type_Alfc = new alfc();
      }
      return jdField_a_of_type_Alfc;
    }
    finally {}
  }
  
  public int a()
  {
    Object localObject = alil.a();
    if (localObject != null)
    {
      localObject = (alao)((QQAppInterface)localObject).getManager(245);
      if (localObject != null) {
        return ((alao)localObject).a("hb_exclusive", 1, new String[] { "ani_queue_max" });
      }
    }
    return 1;
  }
  
  public String a(int paramInt)
  {
    Object localObject1 = alil.a();
    Object localObject2;
    JSONArray localJSONArray;
    if (localObject1 != null)
    {
      localObject2 = (alao)((QQAppInterface)localObject1).getManager(245);
      if (localObject2 != null) {
        if (paramInt == 0)
        {
          localObject1 = "ask_text_list";
          localJSONArray = ((alao)localObject2).a("hb_exclusive", new String[] { "aio_red", localObject1 });
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
    Object localObject = alil.a();
    if (localObject != null)
    {
      localObject = (alao)((QQAppInterface)localObject).getManager(245);
      if (localObject != null) {
        return ((alao)localObject).a("hb_exclusive", 1, new String[] { "is_display_all" }) == 1;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfc
 * JD-Core Version:    0.7.0.1
 */