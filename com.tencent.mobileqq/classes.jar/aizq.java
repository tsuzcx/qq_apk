import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class aizq
  implements aizp
{
  private List<String> a;
  
  public String a(CopyOnWriteArrayList<String> paramCopyOnWriteArrayList, boolean paramBoolean)
  {
    int i = paramCopyOnWriteArrayList.size() - 1;
    while (i >= 0)
    {
      String str = (String)paramCopyOnWriteArrayList.remove(i);
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
        this.a.add(alud.a(2131706103));
        this.a.add(alud.a(2131706108));
        this.a.add(alud.a(2131706104));
        this.a.add(alud.a(2131706109));
        this.a.add(alud.a(2131706105));
        this.a.add(alud.a(2131706107));
        this.a.add(alud.a(2131706101));
        this.a.add(alud.a(2131706114));
        this.a.add(alud.a(2131706111));
        this.a.add(alud.a(2131706113));
        this.a.add(alud.a(2131706112));
      }
      i = new Random().nextInt(this.a.size());
      if (QLog.isColorLevel()) {
        QLog.i("IdiomWordChainBizImpl", 2, "getRandomIdiom get backIdiom:" + i + " backIdiomListSize:" + this.a.size());
      }
      return (String)this.a.get(i);
    }
    return "";
  }
  
  public boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.length() == 4) && (aizd.a(paramString) >= 4);
  }
  
  public InputFilter[] a(int paramInt)
  {
    if ((bdep.d()) || (bdep.e())) {}
    for (int i = 1; (i == 0) && (paramInt > 0); i = 0) {
      return new InputFilter[] { new InputFilter.LengthFilter(paramInt) };
    }
    return new InputFilter[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizq
 * JD-Core Version:    0.7.0.1
 */