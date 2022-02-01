import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class ahpp
  extends aldc
{
  ahpp(ahpn paramahpn) {}
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(ahpn.jdField_a_of_type_JavaLangString, 2, "onNotifyMsg btype:" + paramInt + " bid:" + paramString);
    }
    if ((paramInt == 1) && (!TextUtils.isEmpty(paramString)) && (paramBundle != null))
    {
      SparseArray localSparseArray = (SparseArray)this.a.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localSparseArray != null)
      {
        paramInt = 0;
        while (paramInt < localSparseArray.size())
        {
          Object localObject = (WeakReference)localSparseArray.valueAt(paramInt);
          paramBundle = null;
          if (localObject != null) {
            paramBundle = (ahpq)((WeakReference)localObject).get();
          }
          if ((paramBundle != null) && ((paramBundle.a instanceof MessageForQQWalletMsg)))
          {
            localObject = (MessageForQQWalletMsg)paramBundle.a;
            if ((localObject != null) && (((MessageForQQWalletMsg)localObject).messageType == 16) && (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg != null) && (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg.listId != null) && (paramString.equals(((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg.listId))) {
              this.a.a(paramBundle, (MessageForQQWalletMsg)localObject, ((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg.elem);
            }
          }
          paramInt += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahpp
 * JD-Core Version:    0.7.0.1
 */