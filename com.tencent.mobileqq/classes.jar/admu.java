import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class admu
  extends anmu
{
  public admu(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  private void a(String paramString, ArrayList<bddw> paramArrayList, ambb paramambb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "updateAssociatedAccountInfo  uin = " + paramString);
    }
    Iterator localIterator = paramArrayList.iterator();
    boolean bool1 = false;
    bddw localbddw;
    if (localIterator.hasNext())
    {
      localbddw = (bddw)localIterator.next();
      if ((localbddw.jdField_a_of_type_Int == 2) && (localbddw.jdField_a_of_type_JavaLangObject != null) && ((localbddw.jdField_a_of_type_JavaLangObject instanceof ArrayList)))
      {
        paramArrayList = ((ArrayList)localbddw.jdField_a_of_type_JavaLangObject).iterator();
        do
        {
          bool2 = bool1;
          if (!paramArrayList.hasNext()) {
            break;
          }
        } while (!paramString.equals(((SubAccountInfo)((bddw)paramArrayList.next()).jdField_a_of_type_JavaLangObject).subuin));
        String str = bglf.c(this.a.app, paramString, true);
        paramArrayList = str;
        if (TextUtils.isEmpty(str)) {
          paramArrayList = paramString;
        }
        boolean bool2 = bool1;
        if (!paramArrayList.equals(localbddw.jdField_a_of_type_JavaLangString))
        {
          localbddw.jdField_a_of_type_JavaLangString = paramArrayList;
          bool2 = true;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      break;
      if ((localbddw.jdField_a_of_type_Int == 6) && (localbddw.jdField_a_of_type_JavaLangObject != null) && ((localbddw.jdField_a_of_type_JavaLangObject instanceof SimpleAccount)))
      {
        paramArrayList = (SimpleAccount)localbddw.jdField_a_of_type_JavaLangObject;
        if (paramString.equals(paramArrayList.getUin()))
        {
          paramArrayList = bddy.a(this.a.app, paramArrayList);
          if (!paramArrayList.equals(localbddw.jdField_a_of_type_JavaLangString))
          {
            localbddw.jdField_a_of_type_JavaLangString = paramArrayList;
            bool1 = true;
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("AssociatedAccountActivity", 2, "updateAssociatedAccountInfo needUpdate = " + bool1);
            }
            if (bool1) {
              paramambb.notifyDataSetInvalidated();
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
        this.a.jdField_b_of_type_Ambb.notifyDataSetInvalidated();
      }
      if (j == 0) {
        break;
      }
      this.a.jdField_a_of_type_Ambb.notifyDataSetInvalidated();
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
    a(paramString, this.a.d, this.a.jdField_b_of_type_Ambb);
    a(paramString, this.a.c, this.a.jdField_a_of_type_Ambb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     admu
 * JD-Core Version:    0.7.0.1
 */