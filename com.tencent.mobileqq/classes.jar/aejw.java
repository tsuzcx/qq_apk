import Wallet.AcsAckMsgReq;
import Wallet.AcsAckMsgRsp;
import Wallet.AcsDelMsgReq;
import Wallet.AcsDelMsgRsp;
import Wallet.AcsGetMsgListReq;
import Wallet.AcsGetMsgListRsp;
import Wallet.AcsGetMsgReq;
import Wallet.AcsGetMsgRsp;
import Wallet.AcsHead;
import Wallet.AcsPullMsgReq;
import Wallet.AcsPullMsgRsp;
import Wallet.AcsSubNoticeReq;
import Wallet.AcsSubNoticeRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderServlet.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;

public class aejw
  extends MSFServlet
{
  private static AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private static final String jdField_a_of_type_JavaLangString = aejw.class.getSimpleName();
  
  private static AcsHead a()
  {
    AcsHead localAcsHead = new AcsHead();
    localAcsHead.model = bdcb.i();
    localAcsHead.platform = "Android";
    localAcsHead.version = bdcb.c();
    return localAcsHead;
  }
  
  public static void a()
  {
    jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public static void a(int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    if (jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    AcsGetMsgListReq localAcsGetMsgListReq = new AcsGetMsgListReq();
    localAcsGetMsgListReq.head = a();
    localAcsGetMsgListReq.uin = Long.parseLong(jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localAcsGetMsgListReq.record_start = paramInt1;
    localAcsGetMsgListReq.record_size = paramInt2;
    NewIntent localNewIntent = new NewIntent(jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), aejw.class);
    localNewIntent.putExtra("req", localAcsGetMsgListReq);
    localNewIntent.putExtra("param_req_type", 2000);
    localNewIntent.setObserver(paramBusinessObserver);
    jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(localNewIntent);
  }
  
  private void a(Bundle paramBundle, Packet paramPacket)
  {
    if (jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    ToServiceMsg localToServiceMsg;
    do
    {
      return;
      localToServiceMsg = new ToServiceMsg("mobileqq.service", jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "NoticeSvr.DelMsg");
      paramBundle = (AcsDelMsgReq)paramBundle.getSerializable("req");
      paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
      paramPacket.setFuncName("DelMsg");
      paramPacket.addRequestPacket("req", paramBundle);
      paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
      paramPacket.setTimeout(15000L);
    } while (localToServiceMsg.isNeedCallback());
    paramPacket.setNoResponse();
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public static void a(String paramString1, String paramString2, BusinessObserver paramBusinessObserver)
  {
    if (jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    AcsSubNoticeReq localAcsSubNoticeReq = new AcsSubNoticeReq();
    localAcsSubNoticeReq.head = a();
    localAcsSubNoticeReq.uin = Long.parseLong(jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localAcsSubNoticeReq.msg_id = paramString1;
    localAcsSubNoticeReq.domain = paramString2;
    paramString1 = new NewIntent(jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), aejw.class);
    paramString1.putExtra("req", localAcsSubNoticeReq);
    paramString1.putExtra("param_req_type", 2002);
    paramString1.setObserver(paramBusinessObserver);
    jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramString1);
  }
  
  public static void a(String paramString, BusinessObserver paramBusinessObserver)
  {
    if (jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    AcsDelMsgReq localAcsDelMsgReq = new AcsDelMsgReq();
    localAcsDelMsgReq.head = a();
    localAcsDelMsgReq.uin = Long.parseLong(jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localAcsDelMsgReq.msg_id = paramString;
    paramString = new NewIntent(jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), aejw.class);
    paramString.putExtra("req", localAcsDelMsgReq);
    paramString.putExtra("param_req_type", 2001);
    paramString.setObserver(paramBusinessObserver);
    jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramString);
  }
  
  public static void a(ArrayList<String> paramArrayList, BusinessObserver paramBusinessObserver)
  {
    if (jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    AcsAckMsgReq localAcsAckMsgReq = new AcsAckMsgReq();
    localAcsAckMsgReq.head = a();
    localAcsAckMsgReq.uin = Long.parseLong(jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localAcsAckMsgReq.msg_id_list = paramArrayList;
    paramArrayList = new NewIntent(jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), aejw.class);
    paramArrayList.putExtra("req", localAcsAckMsgReq);
    paramArrayList.putExtra("param_req_type", 2004);
    paramArrayList.setObserver(paramBusinessObserver);
    jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramArrayList);
  }
  
  private void b(Bundle paramBundle, Packet paramPacket)
  {
    if (jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    ToServiceMsg localToServiceMsg;
    do
    {
      return;
      localToServiceMsg = new ToServiceMsg("mobileqq.service", jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "NoticeSvr.GetMsgList");
      paramBundle = (AcsGetMsgListReq)paramBundle.getSerializable("req");
      paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
      paramPacket.setFuncName("GetMsgList");
      paramPacket.addRequestPacket("req", paramBundle);
      paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
      paramPacket.setTimeout(15000L);
    } while (localToServiceMsg.isNeedCallback());
    paramPacket.setNoResponse();
  }
  
  public static void b(String paramString1, String paramString2, BusinessObserver paramBusinessObserver)
  {
    if (jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    AcsGetMsgReq localAcsGetMsgReq = new AcsGetMsgReq();
    localAcsGetMsgReq.head = a();
    localAcsGetMsgReq.uin = Long.parseLong(jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localAcsGetMsgReq.msg_id = paramString1;
    localAcsGetMsgReq.domain = paramString2;
    paramString1 = new NewIntent(jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), aejw.class);
    paramString1.putExtra("req", localAcsGetMsgReq);
    paramString1.putExtra("param_req_type", 2005);
    paramString1.setObserver(paramBusinessObserver);
    jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramString1);
  }
  
  public static void b(String paramString, BusinessObserver paramBusinessObserver)
  {
    if (jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    AcsPullMsgReq localAcsPullMsgReq = new AcsPullMsgReq();
    localAcsPullMsgReq.head = a();
    localAcsPullMsgReq.uin = Long.parseLong(jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localAcsPullMsgReq.day = paramString;
    paramString = new NewIntent(jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), aejw.class);
    paramString.putExtra("req", localAcsPullMsgReq);
    paramString.putExtra("param_req_type", 2003);
    paramString.setObserver(paramBusinessObserver);
    jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramString);
  }
  
  private void c(Bundle paramBundle, Packet paramPacket)
  {
    if (jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    ToServiceMsg localToServiceMsg;
    do
    {
      return;
      localToServiceMsg = new ToServiceMsg("mobileqq.service", jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "NoticeSvr.SubNotice");
      paramBundle = (AcsSubNoticeReq)paramBundle.getSerializable("req");
      paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
      paramPacket.setFuncName("SubNotice");
      paramPacket.addRequestPacket("req", paramBundle);
      paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
      paramPacket.setTimeout(15000L);
    } while (localToServiceMsg.isNeedCallback());
    paramPacket.setNoResponse();
  }
  
  private void d(Bundle paramBundle, Packet paramPacket)
  {
    if (jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    ToServiceMsg localToServiceMsg;
    do
    {
      return;
      localToServiceMsg = new ToServiceMsg("mobileqq.service", jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "NoticeSvr.PullMsg");
      paramBundle = (AcsPullMsgReq)paramBundle.getSerializable("req");
      paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
      paramPacket.setFuncName("PullMsg");
      paramPacket.addRequestPacket("req", paramBundle);
      paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
      paramPacket.setTimeout(15000L);
    } while (localToServiceMsg.isNeedCallback());
    paramPacket.setNoResponse();
  }
  
  private void e(Bundle paramBundle, Packet paramPacket)
  {
    if (jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    ToServiceMsg localToServiceMsg;
    do
    {
      return;
      localToServiceMsg = new ToServiceMsg("mobileqq.service", jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "NoticeSvr.AckMsg");
      paramBundle = (AcsAckMsgReq)paramBundle.getSerializable("req");
      paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
      paramPacket.setFuncName("AckMsg");
      paramPacket.addRequestPacket("req", paramBundle);
      paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
      paramPacket.setTimeout(15000L);
    } while (localToServiceMsg.isNeedCallback());
    paramPacket.setNoResponse();
  }
  
  private void f(Bundle paramBundle, Packet paramPacket)
  {
    if (jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    ToServiceMsg localToServiceMsg;
    do
    {
      return;
      localToServiceMsg = new ToServiceMsg("mobileqq.service", jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "NoticeSvr.GetMsg");
      paramBundle = (AcsGetMsgReq)paramBundle.getSerializable("req");
      paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
      paramPacket.setFuncName("GetMsg");
      paramPacket.addRequestPacket("req", paramBundle);
      paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
      paramPacket.setTimeout(15000L);
    } while (localToServiceMsg.isNeedCallback());
    paramPacket.setNoResponse();
  }
  
  public void notifyObserver(Intent paramIntent, int paramInt, boolean paramBoolean, Bundle paramBundle, Class<? extends BusinessObserver> paramClass)
  {
    int i = paramIntent.getIntExtra("param_req_type", 0);
    if (i == 0) {
      super.notifyObserver(paramIntent, paramInt, paramBoolean, paramBundle, paramClass);
    }
    do
    {
      do
      {
        return;
      } while ((i == 1) && (!(paramIntent instanceof NewIntent)));
      paramIntent = ((NewIntent)paramIntent).getObserver();
    } while (paramIntent == null);
    ThreadManager.post(new QQReminderServlet.1(this, paramIntent, paramInt, paramBoolean, paramBundle), 5, null, true);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "cmd: " + (String)localObject1 + " ");
    }
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      return;
      if (((String)localObject1).equals("NoticeSvr.GetMsgList"))
      {
        localObject1 = new Bundle();
        try
        {
          localObject2 = (AcsGetMsgListRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsGetMsgListRsp());
          if (localObject2 != null) {
            ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
          }
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 2000, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 2000, false, (Bundle)localObject1, null);
          return;
        }
      }
      if (((String)localObject1).equals("NoticeSvr.DelMsg"))
      {
        localObject1 = new Bundle();
        try
        {
          localObject2 = (AcsDelMsgRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsDelMsgRsp());
          if (localObject2 != null) {
            ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
          }
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 2001, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyObserver(paramIntent, 2001, false, (Bundle)localObject1, null);
          return;
        }
      }
      if (((String)localObject1).equals("NoticeSvr.SubNotice"))
      {
        localObject1 = new Bundle();
        try
        {
          localObject2 = (AcsSubNoticeRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsSubNoticeRsp());
          if (localObject2 != null) {
            ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
          }
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 2002, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyObserver(paramIntent, 2002, false, (Bundle)localObject1, null);
          return;
        }
      }
      if (((String)localObject1).equals("NoticeSvr.PullMsg"))
      {
        localObject1 = new Bundle();
        try
        {
          localObject2 = (AcsPullMsgRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsPullMsgRsp());
          if (localObject2 != null) {
            ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
          }
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 2003, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyObserver(paramIntent, 2003, false, (Bundle)localObject1, null);
          return;
        }
      }
      if (((String)localObject1).equals("NoticeSvr.AckMsg"))
      {
        localObject1 = new Bundle();
        try
        {
          localObject2 = (AcsAckMsgRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsAckMsgRsp());
          if (localObject2 != null) {
            ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
          }
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 2004, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyObserver(paramIntent, 2004, false, (Bundle)localObject1, null);
          return;
        }
      }
    } while (!((String)localObject1).equals("NoticeSvr.GetMsg"));
    localObject1 = new Bundle();
    try
    {
      localObject2 = (AcsGetMsgRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsGetMsgRsp());
      if (localObject2 != null) {
        ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
      }
      ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
      notifyObserver(paramIntent, 2005, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      notifyObserver(paramIntent, 2005, false, (Bundle)localObject1, null);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null) {
      return;
    }
    switch (paramIntent.getInt("param_req_type", 0))
    {
    default: 
      return;
    case 2000: 
      b(paramIntent, paramPacket);
      return;
    case 2001: 
      a(paramIntent, paramPacket);
      return;
    case 2002: 
      c(paramIntent, paramPacket);
      return;
    case 2003: 
      d(paramIntent, paramPacket);
      return;
    case 2004: 
      e(paramIntent, paramPacket);
      return;
    }
    f(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejw
 * JD-Core Version:    0.7.0.1
 */