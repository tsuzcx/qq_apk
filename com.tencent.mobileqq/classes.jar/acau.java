import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class acau
  extends alox
{
  public acau(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  private void a(String paramString, ArrayList<azyj> paramArrayList, akcn paramakcn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "updateAssociatedAccountInfo  uin = " + paramString);
    }
    Iterator localIterator = paramArrayList.iterator();
    boolean bool1 = false;
    azyj localazyj;
    if (localIterator.hasNext())
    {
      localazyj = (azyj)localIterator.next();
      if ((localazyj.jdField_a_of_type_Int == 2) && (localazyj.jdField_a_of_type_JavaLangObject != null) && ((localazyj.jdField_a_of_type_JavaLangObject instanceof ArrayList)))
      {
        paramArrayList = ((ArrayList)localazyj.jdField_a_of_type_JavaLangObject).iterator();
        do
        {
          bool2 = bool1;
          if (!paramArrayList.hasNext()) {
            break;
          }
        } while (!paramString.equals(((SubAccountInfo)((azyj)paramArrayList.next()).jdField_a_of_type_JavaLangObject).subuin));
        String str = bdbt.c(this.a.app, paramString, true);
        paramArrayList = str;
        if (TextUtils.isEmpty(str)) {
          paramArrayList = paramString;
        }
        boolean bool2 = bool1;
        if (!paramArrayList.equals(localazyj.jdField_a_of_type_JavaLangString))
        {
          localazyj.jdField_a_of_type_JavaLangString = paramArrayList;
          bool2 = true;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      break;
      if ((localazyj.jdField_a_of_type_Int == 6) && (localazyj.jdField_a_of_type_JavaLangObject != null) && ((localazyj.jdField_a_of_type_JavaLangObject instanceof SimpleAccount)))
      {
        paramArrayList = (SimpleAccount)localazyj.jdField_a_of_type_JavaLangObject;
        if (paramString.equals(paramArrayList.getUin()))
        {
          paramArrayList = azyl.a(this.a.app, paramArrayList);
          if (!paramArrayList.equals(localazyj.jdField_a_of_type_JavaLangString))
          {
            localazyj.jdField_a_of_type_JavaLangString = paramArrayList;
            bool1 = true;
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("AssociatedAccountActivity", 2, "updateAssociatedAccountInfo needUpdate = " + bool1);
            }
            if (bool1) {
              paramakcn.notifyDataSetInvalidated();
            }
            return;
          }
        }
      }
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    int k = 0;
    int i = 0;
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Iterator localIterator;
    label54:
    boolean bool;
    if ((this.a.jdField_a_of_type_JavaUtilArrayList != null) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
      paramBoolean = false;
      bool = paramBoolean;
      if (!localIterator.hasNext()) {
        break label95;
      }
      if (!TextUtils.equals(paramString, ((SubAccountInfo)localIterator.next()).subuin)) {
        break label248;
      }
      paramBoolean = true;
    }
    label95:
    label248:
    for (;;)
    {
      break label54;
      bool = false;
      int j = k;
      if (this.a.jdField_b_of_type_JavaUtilArrayList != null)
      {
        j = k;
        if (this.a.jdField_b_of_type_JavaUtilArrayList.size() > 0)
        {
          localIterator = this.a.jdField_b_of_type_JavaUtilArrayList.iterator();
          for (;;)
          {
            j = i;
            if (!localIterator.hasNext()) {
              break;
            }
            if (TextUtils.equals(paramString, ((SimpleAccount)localIterator.next()).getUin())) {
              i = 1;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "onUpdateCustomHead uin = " + paramString + " needUpdate=" + bool);
      }
      if (bool) {
        this.a.jdField_b_of_type_Akcn.notifyDataSetInvalidated();
      }
      if (j == 0) {
        break;
      }
      this.a.jdField_a_of_type_Akcn.notifyDataSetInvalidated();
      return;
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onUpdateFriendInfo  uin = " + paramString + " isSuccess = " + paramBoolean);
    }
    a(paramString, this.a.d, this.a.jdField_b_of_type_Akcn);
    a(paramString, this.a.c, this.a.jdField_a_of_type_Akcn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acau
 * JD-Core Version:    0.7.0.1
 */