import com.tencent.image.Utils;

public class aipl
  extends aipm
{
  public aipl(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipl
 * JD-Core Version:    0.7.0.1
 */