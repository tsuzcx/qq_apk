import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONArray;

public class agqo
{
  private static volatile agqo jdField_a_of_type_Agqo;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { ajjy.a(2131647530), ajjy.a(2131647520), ajjy.a(2131647501) };
  private static final String[] b = { ajjy.a(2131647526), ajjy.a(2131647521), ajjy.a(2131647506) };
  
  public static agqo a()
  {
    if (jdField_a_of_type_Agqo == null) {}
    try
    {
      if (jdField_a_of_type_Agqo == null) {
        jdField_a_of_type_Agqo = new agqo();
      }
      return jdField_a_of_type_Agqo;
    }
    finally {}
  }
  
  public int a()
  {
    Object localObject = agwj.a();
    if (localObject != null)
    {
      localObject = (agmq)((QQAppInterface)localObject).getManager(245);
      if (localObject != null) {
        return ((agmq)localObject).a("hb_exclusive", 1, new String[] { "ani_queue_max" });
      }
    }
    return 1;
  }
  
  public String a(int paramInt)
  {
    Object localObject1 = agwj.a();
    Object localObject2;
    JSONArray localJSONArray;
    if (localObject1 != null)
    {
      localObject2 = (agmq)((QQAppInterface)localObject1).getManager(245);
      if (localObject2 != null) {
        if (paramInt == 0)
        {
          localObject1 = "ask_text_list";
          localJSONArray = ((agmq)localObject2).a("hb_exclusive", new String[] { "aio_red", localObject1 });
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
    Object localObject = agwj.a();
    if (localObject != null)
    {
      localObject = (agmq)((QQAppInterface)localObject).getManager(245);
      if (localObject != null) {
        return ((agmq)localObject).a("hb_exclusive", 1, new String[] { "is_display_all" }) == 1;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agqo
 * JD-Core Version:    0.7.0.1
 */