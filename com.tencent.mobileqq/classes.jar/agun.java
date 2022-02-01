import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.xml.sax.XMLReader;

class agun
  implements Html.TagHandler
{
  static
  {
    if (!aguk.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  agun(aguk paramaguk) {}
  
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
        paramXMLReader = aguk.a(this.jdField_a_of_type_Aguk, paramXMLReader, "id");
      } while (TextUtils.isEmpty(paramXMLReader));
      if ((!jdField_a_of_type_Boolean) && (paramXMLReader == null)) {
        throw new AssertionError();
      }
      i = Integer.parseInt(paramXMLReader);
      paramEditable.append(this.jdField_a_of_type_Aguk.a("\024" + (char)i));
    } while (!QLog.isColorLevel());
    QLog.d("FullScreenInputHelper", 2, "[mix]handleTag: " + paramString + " emotionTag: " + paramXMLReader + " emotionId: " + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agun
 * JD-Core Version:    0.7.0.1
 */