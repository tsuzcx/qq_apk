import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONArray;

public class ajbu
{
  private static volatile ajbu jdField_a_of_type_Ajbu;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { alud.a(2131713713), alud.a(2131713703), alud.a(2131713684) };
  private static final String[] b = { alud.a(2131713709), alud.a(2131713704), alud.a(2131713689) };
  
  public static ajbu a()
  {
    if (jdField_a_of_type_Ajbu == null) {}
    try
    {
      if (jdField_a_of_type_Ajbu == null) {
        jdField_a_of_type_Ajbu = new ajbu();
      }
      return jdField_a_of_type_Ajbu;
    }
    finally {}
  }
  
  public int a()
  {
    Object localObject = ajeu.a();
    if (localObject != null)
    {
      localObject = (aixs)((QQAppInterface)localObject).getManager(245);
      if (localObject != null) {
        return ((aixs)localObject).a("hb_exclusive", 1, new String[] { "ani_queue_max" });
      }
    }
    return 1;
  }
  
  public String a(int paramInt)
  {
    Object localObject1 = ajeu.a();
    Object localObject2;
    JSONArray localJSONArray;
    if (localObject1 != null)
    {
      localObject2 = (aixs)((QQAppInterface)localObject1).getManager(245);
      if (localObject2 != null) {
        if (paramInt == 0)
        {
          localObject1 = "ask_text_list";
          localJSONArray = ((aixs)localObject2).a("hb_exclusive", new String[] { "aio_red", localObject1 });
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
    Object localObject = ajeu.a();
    if (localObject != null)
    {
      localObject = (aixs)((QQAppInterface)localObject).getManager(245);
      if (localObject != null) {
        return ((aixs)localObject).a("hb_exclusive", 1, new String[] { "is_display_all" }) == 1;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbu
 * JD-Core Version:    0.7.0.1
 */