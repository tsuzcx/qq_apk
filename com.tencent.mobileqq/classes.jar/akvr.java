import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class akvr
  implements akwe
{
  private long jdField_a_of_type_Long;
  private WordChainHbFragment jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment;
  List<String> jdField_a_of_type_JavaUtilList = new LinkedList();
  private List<String> b;
  
  public akvr(WordChainHbFragment paramWordChainHbFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment = paramWordChainHbFragment;
  }
  
  private int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return 2147483647;
        paramString = b(paramString);
      } while (TextUtils.isEmpty(paramString));
      paramString = paramString.split("-");
    } while (paramString.length < 2);
    try
    {
      int i = Integer.parseInt(paramString[1]);
      return i;
    }
    catch (Throwable paramString) {}
    return 2147483647;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String[] arrayOfString = paramString.split("-");
    int j;
    int i;
    if (arrayOfString.length >= 1)
    {
      j = 2147483647;
      i = j;
    }
    try
    {
      if (arrayOfString.length >= 2) {
        i = Integer.parseInt(arrayOfString[1]);
      }
      a(i);
      this.jdField_a_of_type_JavaUtilList.add(paramString);
      if (this.jdField_a_of_type_JavaUtilList.size() > 50) {
        this.jdField_a_of_type_JavaUtilList.remove(0);
      }
      return arrayOfString[0];
      return "";
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment.b())
    {
      long l = NetConnInfoCenter.getServerTimeMillis();
      if (Math.abs(l - this.jdField_a_of_type_Long) > 1000L)
      {
        this.jdField_a_of_type_Long = l;
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment.a(String.format("该诗词可接龙最大次数是%d，请修改个数", new Object[] { Integer.valueOf(paramInt) }));
      }
    }
  }
  
  private String b(String paramString)
  {
    paramString = paramString + "-";
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if ((!TextUtils.isEmpty(str)) && (str.startsWith(paramString))) {
        return str;
      }
    }
    localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletFragmentWordChainHbFragment.a(3).iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      if ((!TextUtils.isEmpty(str)) && (str.startsWith(paramString))) {
        return str;
      }
    }
    return null;
  }
  
  public String a(List<String> paramList, boolean paramBoolean)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      String str = a((String)paramList.remove(i));
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
      i -= 1;
    }
    if (paramBoolean)
    {
      if (this.b == null)
      {
        this.b = new ArrayList(7);
        this.b.add("海上生明月-7");
        this.b.add("沧海月明珠有泪-3");
        this.b.add("忽如一夜春风来-15");
        this.b.add("老夫聊发少年狂-15");
        this.b.add("莫笑农家腊酒浑-7");
        this.b.add("昔人已乘黄鹤去-7");
      }
      i = new Random().nextInt(this.b.size());
      if (QLog.isColorLevel()) {
        QLog.i("ContinueChainBizImpl", 2, "getRandomIdiom get backIdiom:" + i + " backWordListSize:" + this.b.size());
      }
      return a((String)this.b.get(i));
    }
    return "";
  }
  
  public void a(String paramString)
  {
    a(a(paramString));
  }
  
  public boolean a(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
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
 * Qualified Name:     akvr
 * JD-Core Version:    0.7.0.1
 */