import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class akwf
  implements akwe
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
        this.a.add(anvx.a(2131705192));
        this.a.add(anvx.a(2131705197));
        this.a.add(anvx.a(2131705193));
        this.a.add(anvx.a(2131705198));
        this.a.add(anvx.a(2131705194));
        this.a.add(anvx.a(2131705196));
        this.a.add(anvx.a(2131705190));
        this.a.add(anvx.a(2131705203));
        this.a.add(anvx.a(2131705200));
        this.a.add(anvx.a(2131705202));
        this.a.add(anvx.a(2131705201));
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
    return (!TextUtils.isEmpty(paramString)) && (paramString.length() == 4) && (akvs.a(paramString) >= 4);
  }
  
  public InputFilter[] a(int paramInt)
  {
    if ((SystemUtil.isFlyme()) || (SystemUtil.isMeizu())) {}
    for (int i = 1; (i == 0) && (paramInt > 0); i = 0) {
      return new InputFilter[] { new InputFilter.LengthFilter(paramInt) };
    }
    return new InputFilter[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwf
 * JD-Core Version:    0.7.0.1
 */