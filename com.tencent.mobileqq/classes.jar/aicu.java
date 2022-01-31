import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class aicu
{
  public static String a;
  public MessageRecord a;
  
  public aicu(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MessageItem", 2, "MessageItem, messageRecord.senderuin = " + paramMessageRecord.senderuin);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public static String a(CharSequence paramCharSequence)
  {
    paramCharSequence = new StringBuilder(paramCharSequence);
    int k = paramCharSequence.length();
    int i = 0;
    if (i < paramCharSequence.length())
    {
      int m = paramCharSequence.codePointAt(i);
      int j;
      if ((m == 20) && (i < k - 1))
      {
        j = i;
        if (paramCharSequence.charAt(i + 1) < bahu.jdField_a_of_type_Int)
        {
          paramCharSequence.replace(i, i + 2, "\001\001");
          j = i + 1;
        }
      }
      for (;;)
      {
        i = j + 1;
        break;
        j = i;
        if (bahu.jdField_a_of_type_AndroidUtilSparseIntArray.get(m, -1) >= 0) {
          if ((m > 65535) && (k >= i + 2))
          {
            paramCharSequence.replace(i, i + 2, "\001\001");
            j = i;
          }
          else
          {
            paramCharSequence.replace(i, i + 1, "\001");
            j = i;
          }
        }
      }
    }
    return paramCharSequence.toString();
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MessageItem", 2, "setKeyword, keyword = " + paramString);
    }
    if ((paramString != null) && (paramString.length() > 0)) {
      jdField_a_of_type_JavaLangString = paramString.toLowerCase(Locale.US);
    }
  }
  
  public SpannableString a(String paramString)
  {
    int i = a(paramString).toLowerCase(Locale.US).indexOf(jdField_a_of_type_JavaLangString);
    if (i > 20)
    {
      int j = i - 20;
      int k = paramString.codePointAt(j - 1);
      if (k != 20)
      {
        i = j;
        if (bahu.jdField_a_of_type_AndroidUtilSparseIntArray.get(k, -1) >= 0)
        {
          i = j;
          if (k <= 65535) {}
        }
      }
      else
      {
        i = j + 1;
      }
      StringBuilder localStringBuilder = new StringBuilder(paramString.length());
      localStringBuilder.append("...");
      localStringBuilder.append(paramString.substring(i));
      paramString = new SpannableString(localStringBuilder.toString());
      paramString.setSpan("...", 0, "...".length(), 33);
      return paramString;
    }
    return new SpannableString(paramString);
  }
  
  public CharSequence a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return "";
    }
    paramString = new baig(a(paramString), 3, 16);
    a(paramString, paramInt);
    return paramString;
  }
  
  public String a(long paramLong)
  {
    return bdjj.a(1000L * paramLong, true, "yyyy-MM-dd");
  }
  
  public void a(Spannable paramSpannable, int paramInt)
  {
    int i = 0;
    int j = 0;
    String str = a(paramSpannable.toString()).toString().toLowerCase(Locale.US);
    int m = jdField_a_of_type_JavaLangString.length();
    String[] arrayOfString = (String[])paramSpannable.getSpans(0, paramSpannable.length(), String.class);
    if (arrayOfString != null)
    {
      int n = arrayOfString.length;
      int k = 0;
      for (;;)
      {
        i = j;
        if (k >= n) {
          break;
        }
        if ("...".equals(arrayOfString[k])) {
          j = "...".length();
        }
        k += 1;
      }
    }
    j = str.indexOf(jdField_a_of_type_JavaLangString, i);
    if ((j >= 0) && (j < str.length()))
    {
      i = j + m;
      paramSpannable.setSpan(new ForegroundColorSpan(paramInt), j, i, 33);
      j = i;
    }
    for (;;)
    {
      if (j >= 0)
      {
        i = j;
        if (j < str.length()) {
          break;
        }
      }
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uniseq = ").append(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
    localStringBuilder.append(", msg = ").append(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aicu
 * JD-Core Version:    0.7.0.1
 */