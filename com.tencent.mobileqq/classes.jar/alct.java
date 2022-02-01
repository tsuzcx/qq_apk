import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class alct
  implements alcs
{
  private List<String> a;
  
  public String a(List<String> paramList, boolean paramBoolean)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      String str = (String)paramList.remove(i);
      if ((!TextUtils.isEmpty(str)) && (str.length() == 4)) {
        return str;
      }
      i -= 1;
    }
    if (paramBoolean)
    {
      if (this.a == null)
      {
        this.a = new ArrayList();
        this.a.add(anzj.a(2131704611));
        this.a.add(anzj.a(2131704616));
        this.a.add(anzj.a(2131704612));
        this.a.add(anzj.a(2131704617));
        this.a.add(anzj.a(2131704613));
        this.a.add(anzj.a(2131704615));
        this.a.add(anzj.a(2131704609));
        this.a.add(anzj.a(2131704622));
        this.a.add(anzj.a(2131704619));
        this.a.add(anzj.a(2131704621));
        this.a.add(anzj.a(2131704620));
      }
      i = new Random().nextInt(this.a.size());
      if (QLog.isColorLevel()) {
        QLog.i("IdiomWordChainBizImpl", 2, "getRandomIdiom get backIdiom:" + i + " backIdiomListSize:" + this.a.size());
      }
      return (String)this.a.get(i);
    }
    return "";
  }
  
  public void a(String paramString) {}
  
  public boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.length() == 4) && (alcg.a(paramString) >= 4);
  }
  
  public InputFilter[] a(int paramInt)
  {
    if ((bhjr.d()) || (bhjr.e())) {}
    for (int i = 1; (i == 0) && (paramInt > 0); i = 0) {
      return new InputFilter[] { new InputFilter.LengthFilter(paramInt) };
    }
    return new InputFilter[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alct
 * JD-Core Version:    0.7.0.1
 */