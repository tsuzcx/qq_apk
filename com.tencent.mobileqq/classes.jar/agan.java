import android.os.FileObserver;

public class agan
  extends FileObserver
{
  private agak jdField_a_of_type_Agak;
  private final String jdField_a_of_type_JavaLangString = "MediaScannerFileObserver";
  private String b;
  
  public agan(agak paramagak, String paramString)
  {
    super(paramString);
    this.b = paramString;
    this.jdField_a_of_type_Agak = paramagak;
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Agak == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      }
    } while ((paramString == null) || (!paramString.endsWith(".mp4")));
    this.jdField_a_of_type_Agak.a(paramInt, this.b, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agan
 * JD-Core Version:    0.7.0.1
 */