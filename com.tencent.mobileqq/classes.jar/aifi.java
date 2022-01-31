import android.text.TextUtils;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aifi
  implements aiud
{
  aifi(aifg paramaifg) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean) {
      if ((paramInt1 > 0) && (!ApolloUtil.c(paramInt1))) {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "role rsc NOT complete.");
        }
      }
    }
    label96:
    do
    {
      do
      {
        return;
        if (paramArrayOfInt != null)
        {
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 >= paramArrayOfInt.length) {
              break label96;
            }
            if (!ApolloUtil.b(paramArrayOfInt[paramInt1]))
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ApolloManager", 2, "dress rsc NOT complete, id:" + paramArrayOfInt[paramInt1]);
              return;
            }
            paramInt1 += 1;
          }
        }
        paramArrayOfInt = new ArrayList(1);
        paramArrayOfInt.add(paramString);
        ((baot)this.a.a.a(71)).notifyUI(2, true, paramArrayOfInt);
      } while (!QLog.isColorLevel());
      QLog.d("ApolloManager", 2, "apollo dress download ok notifyUI uin: " + ApolloUtil.d(paramString));
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        paramArrayOfInt = new ArrayList(1);
        paramArrayOfInt.add(paramString);
        ((baot)this.a.a.a(71)).notifyUI(2, false, paramArrayOfInt);
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, "apollo dress download failed " + ApolloUtil.d(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aifi
 * JD-Core Version:    0.7.0.1
 */