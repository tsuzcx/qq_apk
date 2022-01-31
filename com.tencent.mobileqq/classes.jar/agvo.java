import com.tencent.image.Utils;

public class agvo
  extends agvp
{
  public agvo(String paramString)
  {
    super(paramString);
    this.a = "PhotoIncompatibleWebp";
    this.b = "reportGenerateHeif";
  }
  
  static boolean a(String paramString)
  {
    return Utils.isHeifFile(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agvo
 * JD-Core Version:    0.7.0.1
 */