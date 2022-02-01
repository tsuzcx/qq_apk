import Wallet.RedInfoSyncReq;
import com.tencent.mobileqq.activity.qwallet.red.QWRedConfig;
import com.tencent.mobileqq.activity.qwallet.red.QWRedConfig.RedInfo;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.1;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.manager.Manager;

public class akcq
  implements ajyk, Manager
{
  private QWRedConfig jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public akcq(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "QWalletRedManager init");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig = QWRedConfig.readConfig(paramQQAppInterface);
    a();
  }
  
  private void a()
  {
    ThreadManager.executeOnSubThread(new QWalletRedManager.1(this));
  }
  
  public akcs a(String paramString)
  {
    akcs localakcs = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig.getShowInfoByPath(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "getShowInfo path=" + paramString + ",res=" + localakcs);
    }
    return localakcs;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig.getNotShowListStr();
  }
  
  public void a(String paramString)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig.getCurShowRedInfosByPath(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "doClick" + paramString + "|" + localList);
    }
    paramString = new LinkedList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      QWRedConfig.RedInfo localRedInfo = (QWRedConfig.RedInfo)localIterator.next();
      if (localRedInfo.doClick()) {
        paramString.add(localRedInfo);
      }
    }
    if (paramString.size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig.saveConfig();
      ajvh.a(RedInfoSyncReq.createReq(paramString), new akcr(this));
    }
    if (localList.size() > 0) {
      VACDReportUtil.a(null, "QWalletStat", "QWalletRedClick", "QWalletRedClick", QWRedConfig.RedInfo.transToReportStr(localList), 0, null);
    }
  }
  
  public void a(String paramString1, String paramString2, ajye paramajye)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig.parseConfig(paramajye);
  }
  
  public void a(List<String> paramList)
  {
    if (paramList == null) {}
    LinkedList localLinkedList;
    do
    {
      return;
      localLinkedList = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        localLinkedList.addAll(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedQWRedConfig.getCurShowRedInfosByPath(str));
      }
    } while (localLinkedList.size() <= 0);
    VACDReportUtil.a(null, "QWalletStat", "QWalletRedShow", "QWalletRedShow", QWRedConfig.RedInfo.transToReportStr(localLinkedList), 0, null);
  }
  
  public void b(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    a(localLinkedList);
  }
  
  public void onDestroy()
  {
    ajyg localajyg = (ajyg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(245);
    if (localajyg != null) {
      localajyg.d("redPoint", this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akcq
 * JD-Core Version:    0.7.0.1
 */