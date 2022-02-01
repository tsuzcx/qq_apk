import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONArray;

public class aktn
{
  private static volatile aktn jdField_a_of_type_Aktn;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { anni.a(2131712092), anni.a(2131712082), anni.a(2131712063) };
  private static final String[] b = { anni.a(2131712088), anni.a(2131712083), anni.a(2131712068) };
  
  public static aktn a()
  {
    if (jdField_a_of_type_Aktn == null) {}
    try
    {
      if (jdField_a_of_type_Aktn == null) {
        jdField_a_of_type_Aktn = new aktn();
      }
      return jdField_a_of_type_Aktn;
    }
    finally {}
  }
  
  public int a()
  {
    Object localObject = akww.a();
    if (localObject != null)
    {
      localObject = (akpd)((QQAppInterface)localObject).getManager(245);
      if (localObject != null) {
        return ((akpd)localObject).a("hb_exclusive", 1, new String[] { "ani_queue_max" });
      }
    }
    return 1;
  }
  
  public String a(int paramInt)
  {
    Object localObject1 = akww.a();
    Object localObject2;
    JSONArray localJSONArray;
    if (localObject1 != null)
    {
      localObject2 = (akpd)((QQAppInterface)localObject1).getManager(245);
      if (localObject2 != null) {
        if (paramInt == 0)
        {
          localObject1 = "ask_text_list";
          localJSONArray = ((akpd)localObject2).a("hb_exclusive", new String[] { "aio_red", localObject1 });
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
    Object localObject = akww.a();
    if (localObject != null)
    {
      localObject = (akpd)((QQAppInterface)localObject).getManager(245);
      if (localObject != null) {
        return ((akpd)localObject).a("hb_exclusive", 1, new String[] { "is_display_all" }) == 1;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aktn
 * JD-Core Version:    0.7.0.1
 */