import com.tencent.mobileqq.richmedia.dc.DataAdapter;
import java.util.HashMap;

public class agzv
  extends DataAdapter
{
  int jdField_a_of_type_Int = 0;
  boolean jdField_a_of_type_Boolean = false;
  
  public HashMap a(String paramString)
  {
    if ("RealShortVideo.Record".equals(paramString))
    {
      paramString = new HashMap();
      paramString.put("param_cameraID", String.valueOf(this.jdField_a_of_type_Int));
      paramString.put("param_hasMultiSegments", String.valueOf(this.jdField_a_of_type_Boolean));
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agzv
 * JD-Core Version:    0.7.0.1
 */