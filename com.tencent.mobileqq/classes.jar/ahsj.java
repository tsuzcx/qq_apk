import java.util.HashMap;

public class ahsj
  extends ahsl
{
  long a = 0L;
  long b;
  
  ahsj()
  {
    this.jdField_b_of_type_Long = -1L;
  }
  
  public HashMap a(String paramString)
  {
    if ("ShortVideo.FullscreenPreview".equals(paramString))
    {
      paramString = new HashMap();
      paramString.put("param_uinType", this.jdField_b_of_type_Int + "");
      paramString.put("param_GroupMemberCount", this.c + "");
      paramString.put("param_age", this.d + "");
      paramString.put("param_gender", this.e + "");
      paramString.put("param_shortVideoType", this.f + "");
      paramString.put("param_duration", this.a + "");
      paramString.put("param_reportHour", this.g + "");
      paramString.put("param_netType", this.h + "");
      paramString.put("param_playTimeCost", this.jdField_b_of_type_Long + "");
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahsj
 * JD-Core Version:    0.7.0.1
 */