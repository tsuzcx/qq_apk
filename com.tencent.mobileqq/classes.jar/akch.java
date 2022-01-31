import android.text.TextUtils;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

public class akch
  implements Comparator<PhoneContact>
{
  public akch(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    int n = 0;
    Object localObject2 = paramPhoneContact1.pinyinFirst;
    String str = paramPhoneContact2.pinyinFirst;
    Object localObject1 = localObject2;
    if (((String)localObject2).endsWith("#")) {
      localObject1 = "Za";
    }
    localObject2 = str;
    if (str.endsWith("#")) {
      localObject2 = "Za";
    }
    int j = ((String)localObject1).compareTo((String)localObject2);
    int i = j;
    int k;
    label99:
    label112:
    int m;
    if (j == 0)
    {
      if (TextUtils.isEmpty(paramPhoneContact1.uin)) {
        break label176;
      }
      i = 1;
      if ((i == 0) || (paramPhoneContact1.uin.equals("0"))) {
        break label181;
      }
      k = 1;
      if (TextUtils.isEmpty(paramPhoneContact2.uin)) {
        break label187;
      }
      j = 1;
      if ((j == 0) || (paramPhoneContact2.uin.equals("0"))) {
        break label193;
      }
      m = 1;
      label132:
      if (k == 0) {
        break label199;
      }
      i = 0;
    }
    for (;;)
    {
      label139:
      if (m != 0) {
        j = n;
      }
      for (;;)
      {
        i -= j;
        j = i;
        if (i == 0) {
          j = paramPhoneContact1.pinyinAll.compareTo(paramPhoneContact2.pinyinAll);
        }
        return j;
        label176:
        i = 0;
        break;
        label181:
        k = 0;
        break label99;
        label187:
        j = 0;
        break label112;
        label193:
        m = 0;
        break label132;
        label199:
        if (i == 0) {
          break label225;
        }
        i = 1;
        break label139;
        if (j != 0) {
          j = 1;
        } else {
          j = 2;
        }
      }
      label225:
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akch
 * JD-Core Version:    0.7.0.1
 */