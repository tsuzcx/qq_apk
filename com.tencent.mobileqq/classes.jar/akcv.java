import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONArray;

public class akcv
{
  private static volatile akcv jdField_a_of_type_Akcv;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { amtj.a(2131712433), amtj.a(2131712423), amtj.a(2131712404) };
  private static final String[] b = { amtj.a(2131712429), amtj.a(2131712424), amtj.a(2131712409) };
  
  public static akcv a()
  {
    if (jdField_a_of_type_Akcv == null) {}
    try
    {
      if (jdField_a_of_type_Akcv == null) {
        jdField_a_of_type_Akcv = new akcv();
      }
      return jdField_a_of_type_Akcv;
    }
    finally {}
  }
  
  public int a()
  {
    Object localObject = akgd.a();
    if (localObject != null)
    {
      localObject = (ajyg)((QQAppInterface)localObject).getManager(245);
      if (localObject != null) {
        return ((ajyg)localObject).a("hb_exclusive", 1, new String[] { "ani_queue_max" });
      }
    }
    return 1;
  }
  
  public String a(int paramInt)
  {
    Object localObject1 = akgd.a();
    Object localObject2;
    JSONArray localJSONArray;
    if (localObject1 != null)
    {
      localObject2 = (ajyg)((QQAppInterface)localObject1).getManager(245);
      if (localObject2 != null) {
        if (paramInt == 0)
        {
          localObject1 = "ask_text_list";
          localJSONArray = ((ajyg)localObject2).a("hb_exclusive", new String[] { "aio_red", localObject1 });
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
    Object localObject = akgd.a();
    if (localObject != null)
    {
      localObject = (ajyg)((QQAppInterface)localObject).getManager(245);
      if (localObject != null) {
        return ((ajyg)localObject).a("hb_exclusive", 1, new String[] { "is_display_all" }) == 1;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akcv
 * JD-Core Version:    0.7.0.1
 */