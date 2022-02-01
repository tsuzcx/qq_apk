import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.xml.sax.XMLReader;

class aghw
  implements Html.TagHandler
{
  static
  {
    if (!aght.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  aghw(aght paramaght) {}
  
  public void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader)
  {
    if (paramString.equalsIgnoreCase("newLine")) {}
    int i;
    do
    {
      do
      {
        paramEditable.append("\n");
        do
        {
          return;
        } while (!paramString.equalsIgnoreCase("emotion"));
        paramXMLReader = aght.a(this.jdField_a_of_type_Aght, paramXMLReader, "id");
      } while (TextUtils.isEmpty(paramXMLReader));
      if ((!jdField_a_of_type_Boolean) && (paramXMLReader == null)) {
        throw new AssertionError();
      }
      i = Integer.parseInt(paramXMLReader);
      paramEditable.append(this.jdField_a_of_type_Aght.a("\024" + (char)i));
    } while (!QLog.isColorLevel());
    QLog.d("FullScreenInputHelper", 2, "[mix]handleTag: " + paramString + " emotionTag: " + paramXMLReader + " emotionId: " + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghw
 * JD-Core Version:    0.7.0.1
 */