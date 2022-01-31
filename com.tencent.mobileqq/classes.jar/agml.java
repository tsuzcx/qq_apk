import android.os.FileObserver;

public class agml
  extends FileObserver
{
  private agmi jdField_a_of_type_Agmi;
  private final String jdField_a_of_type_JavaLangString = "MediaScannerFileObserver";
  private String b;
  
  public agml(agmi paramagmi, String paramString)
  {
    super(paramString);
    this.b = paramString;
    this.jdField_a_of_type_Agmi = paramagmi;
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Agmi == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      }
    } while ((paramString == null) || (!paramString.endsWith(".mp4")));
    this.jdField_a_of_type_Agmi.a(paramInt, this.b, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agml
 * JD-Core Version:    0.7.0.1
 */