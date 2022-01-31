import SecurityAccountServer.RespondQueryQQBindingStat;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class akcj
  extends AsyncTask<RespondQueryQQBindingStat, Void, List<PhoneContact>>
{
  private List<String> jdField_a_of_type_JavaUtilList;
  
  private akcj(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  protected List<PhoneContact> a(RespondQueryQQBindingStat... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager.ContactFriendTask", 2, "doInBackground");
    }
    Object localObject = paramVarArgs[0];
    paramVarArgs = new ArrayList();
    paramVarArgs.addAll(PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).values());
    Collections.sort(paramVarArgs, new akck(this));
    ArrayList localArrayList = new ArrayList();
    ajxl localajxl = (ajxl)PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).getManager(51);
    Iterator localIterator;
    if (paramVarArgs.size() > 0)
    {
      localObject = ((RespondQueryQQBindingStat)localObject).mobileNo;
      localIterator = paramVarArgs.iterator();
    }
    PhoneContact localPhoneContact;
    do
    {
      do
      {
        if (localIterator.hasNext())
        {
          paramVarArgs = (PhoneContact)localIterator.next();
          if (!isCancelled()) {}
        }
        else
        {
          Collections.sort(localArrayList, new akcl(this));
          return localArrayList;
        }
      } while ((localObject != null) && (((String)localObject).endsWith(paramVarArgs.mobileNo.trim())));
      localPhoneContact = (PhoneContact)paramVarArgs.clone();
    } while (TextUtils.isEmpty(localPhoneContact.uin));
    if (localPhoneContact.uin.equals("0"))
    {
      paramVarArgs = null;
      label201:
      if ((paramVarArgs == null) || (paramVarArgs.groupid < 0)) {
        break label260;
      }
      localPhoneContact.nickName = paramVarArgs.getFriendNick();
      localPhoneContact.remark = paramVarArgs.remark;
      localPhoneContact.sortWeight = 262144;
    }
    for (;;)
    {
      localArrayList.add(localPhoneContact);
      break;
      paramVarArgs = localajxl.e(localPhoneContact.uin);
      break label201;
      label260:
      localPhoneContact.uin = "0";
      if (localajxl.d(localPhoneContact.nationCode + localPhoneContact.mobileCode))
      {
        localPhoneContact.sortWeight = 131072;
        localPhoneContact.hasSendAddReq = true;
      }
      else if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.contains(localPhoneContact.mobileNo)))
      {
        localPhoneContact.sortWeight = this.jdField_a_of_type_JavaUtilList.indexOf(localPhoneContact.mobileNo);
      }
      else
      {
        localPhoneContact.sortWeight = 65536;
      }
    }
  }
  
  public void a(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected void b(List<PhoneContact> paramList)
  {
    if (!isCancelled()) {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(paramList);
    }
  }
  
  protected void onCancelled()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager.ContactFriendTask", 2, "on cancelled");
    }
    PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akcj
 * JD-Core Version:    0.7.0.1
 */