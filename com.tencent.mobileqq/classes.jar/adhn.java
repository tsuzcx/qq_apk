import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.LifeOnlineElemDecoder.1;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.LifeOnlineElemDecoder.2;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.LifeOnlineAccount;
import tencent.im.msg.im_msg_body.PubAccInfo;

public class adhn
  extends adic
{
  public int a()
  {
    return -1000;
  }
  
  public void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, bfoy parambfoy)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    MessageHandler localMessageHandler = localQQAppInterface.a();
    paramStringBuilder = paramList.iterator();
    im_msg_body.Elem localElem;
    do
    {
      if (!paramStringBuilder.hasNext()) {
        break;
      }
      localElem = (im_msg_body.Elem)paramStringBuilder.next();
    } while (!localElem.life_online.has());
    for (;;)
    {
      if (localElem == null) {
        return;
      }
      long l1;
      label129:
      long l2;
      label157:
      long l3;
      label184:
      long l4;
      label211:
      int j;
      int i3;
      int i4;
      Object localObject3;
      String str;
      label284:
      boolean bool;
      label319:
      int m;
      label358:
      int n;
      label397:
      int i1;
      label436:
      int i5;
      int i6;
      int i;
      label522:
      label561:
      int k;
      label600:
      label629:
      Object localObject1;
      label659:
      label689:
      Object localObject2;
      int i2;
      if ((localElem.life_online.has()) && (localElem.life_online.uint32_ack.has()) && (localElem.life_online.uint32_ack.get() == 1))
      {
        if (localElem.life_online.uint64_unique_id.has())
        {
          l1 = localElem.life_online.uint64_unique_id.get();
          if (!localElem.life_online.uint32_op.has()) {
            break label1318;
          }
          l2 = localElem.life_online.uint32_op.get();
          if (!paramMsg.msg_head.from_uin.has()) {
            break label1324;
          }
          l3 = paramMsg.msg_head.from_uin.get();
          if (!paramMsg.msg_head.to_uin.has()) {
            break label1330;
          }
          l4 = paramMsg.msg_head.to_uin.get();
          obj.a().a(BaseApplication.getContext(), localMessageHandler.app, l1, l2, l3, l4, 1, null);
        }
      }
      else
      {
        j = 0;
        i3 = 0;
        i4 = 0;
        parambfoy = "";
        localObject3 = "";
        str = "";
        if (!localElem.life_online.uint64_unique_id.has()) {
          break label1336;
        }
        l1 = localElem.life_online.uint64_unique_id.get();
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1348;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 1L) != 1L) {
          break label1342;
        }
        bool = true;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1360;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x4) != 4L) {
          break label1354;
        }
        m = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1372;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x40) != 64L) {
          break label1366;
        }
        n = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1384;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x800) != 2048L) {
          break label1378;
        }
        i1 = 1;
        i5 = (int)((localElem.life_online.uint64_bitmap.get() & 0x180) >> 7);
        i6 = (int)((localElem.life_online.uint64_bitmap.get() & 0x600) >> 9);
        if (m == 0) {
          break label1446;
        }
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1396;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x8) != 8L) {
          break label1390;
        }
        i = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1408;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x10) != 16L) {
          break label1402;
        }
        j = 1;
        if (!localElem.life_online.uint64_bitmap.has()) {
          break label1420;
        }
        if ((localElem.life_online.uint64_bitmap.get() & 0x20) != 32L) {
          break label1414;
        }
        k = 1;
        if (!localElem.life_online.gdt_imp_data.has()) {
          break label1426;
        }
        paramStringBuilder = localElem.life_online.gdt_imp_data.get().toStringUtf8();
        if (!localElem.life_online.gdt_cli_data.has()) {
          break label1432;
        }
        parambfoy = localElem.life_online.gdt_cli_data.get().toStringUtf8();
        if (!localElem.life_online.view_id.has()) {
          break label1439;
        }
        localObject1 = localElem.life_online.view_id.get().toStringUtf8();
        localObject2 = paramStringBuilder;
        if (paramStringBuilder.length() > 100) {
          localObject2 = paramStringBuilder.substring(0, 100);
        }
        if (parambfoy.length() <= 100) {
          break label1719;
        }
        paramStringBuilder = parambfoy.substring(0, 100);
        i2 = j;
      }
      label1408:
      label1664:
      for (;;)
      {
        label733:
        if (localElem.life_online.uint64_bitmap.has()) {
          if ((localElem.life_online.uint64_bitmap.get() & 0x1000) == 4096L)
          {
            j = 1;
            if (((j != 0) || ((paramMsg.msg_head.from_uin.has()) && (paramMsg.msg_head.from_uin.get() == 1579646438L))) && (!paramList1.isEmpty())) {
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("kandian_replace_subscribe_msg", "1");
            }
            if (i1 != 0)
            {
              if (!paramList1.isEmpty()) {
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("recent_list_advertisement_message", "1");
              }
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder().append("isRecentAd, uint64_bitmap value is: ");
                if (!localElem.life_online.uint64_bitmap.has()) {
                  break label1579;
                }
                parambfoy = Long.valueOf(localElem.life_online.uint64_bitmap.get());
                QLog.d("LifeOnlineElemDecoder", 2, parambfoy);
              }
              ThreadManager.getSubThreadHandler().postDelayed(new LifeOnlineElemDecoder.1(this, localQQAppInterface), 1000L);
            }
            if (!paramList1.isEmpty())
            {
              parambfoy = (MessageRecord)paramList1.get(0);
              parambfoy.extLong |= 0x1;
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("pa_msgHasRead", "false");
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("pa_msgId", String.valueOf(l1));
              ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("pa_should_report", String.valueOf(bool));
              if (m != 0)
              {
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("isAdMsg", "1");
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("ad_msgHasRead", "false");
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("gdt_msgClick", paramStringBuilder);
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("gdt_msgImp", (String)localObject2);
                parambfoy = (MessageRecord)paramList1.get(0);
                if (i == 0) {
                  break label1587;
                }
                paramStringBuilder = "1";
                label1138:
                parambfoy.saveExtInfoToExtStr("gdt_singleAd", paramStringBuilder);
                parambfoy = (MessageRecord)paramList1.get(0);
                if (i2 == 0) {
                  break label1594;
                }
                paramStringBuilder = "1";
                parambfoy.saveExtInfoToExtStr("gdt_mulAd", paramStringBuilder);
                parambfoy = (MessageRecord)paramList1.get(0);
                if (k == 0) {
                  break label1601;
                }
                paramStringBuilder = "1";
                parambfoy.saveExtInfoToExtStr("gdt_followAd", paramStringBuilder);
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("is_AdArrive_Msg", "1");
                ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("gdt_view_id", (String)localObject1);
              }
            }
            if ((n == 0) || (paramList1.isEmpty())) {
              break label1664;
            }
            paramList = paramList.iterator();
            i = 0;
            label1265:
            if (!paramList.hasNext()) {
              break label1608;
            }
            paramStringBuilder = (im_msg_body.Elem)paramList.next();
            if (!paramStringBuilder.pub_acc_info.uint32_is_inter_num.has()) {
              break label1716;
            }
            i = paramStringBuilder.pub_acc_info.uint32_is_inter_num.get();
          }
        }
        label772:
        label916:
        label1196:
        label1330:
        label1587:
        label1716:
        for (;;)
        {
          break label1265;
          l1 = 0L;
          break label129;
          l2 = 0L;
          break label157;
          l3 = 0L;
          break label184;
          l4 = 0L;
          break label211;
          label1336:
          l1 = 0L;
          break label284;
          label1342:
          bool = false;
          break label319;
          label1348:
          bool = false;
          break label319;
          label1354:
          m = 0;
          break label358;
          label1360:
          m = 0;
          break label358;
          label1366:
          n = 0;
          break label397;
          label1372:
          n = 0;
          break label397;
          label1378:
          i1 = 0;
          break label436;
          label1384:
          i1 = 0;
          break label436;
          label1390:
          i = 0;
          break label522;
          label1396:
          i = 0;
          break label522;
          label1402:
          j = 0;
          break label561;
          j = 0;
          break label561;
          k = 0;
          break label600;
          k = 0;
          break label600;
          paramStringBuilder = "";
          break label629;
          parambfoy = "";
          break label659;
          localObject1 = "";
          break label689;
          i2 = i3;
          k = i4;
          localObject2 = localObject3;
          paramStringBuilder = parambfoy;
          localObject1 = str;
          i = j;
          if (!QLog.isColorLevel()) {
            break label733;
          }
          localObject1 = new StringBuilder().append("isAdArriveMsg is false, uint64_bitmap value is: ");
          if (localElem.life_online.uint64_bitmap.has()) {}
          for (paramStringBuilder = Long.valueOf(localElem.life_online.uint64_bitmap.get());; paramStringBuilder = "null")
          {
            QLog.d("LifeOnlineElemDecoder", 2, paramStringBuilder);
            i2 = i3;
            k = i4;
            localObject2 = localObject3;
            paramStringBuilder = parambfoy;
            localObject1 = str;
            i = j;
            break;
          }
          j = 0;
          break label772;
          j = 0;
          break label772;
          parambfoy = "null";
          break label916;
          paramStringBuilder = "0";
          break label1138;
          label1594:
          paramStringBuilder = "0";
          break label1167;
          label1601:
          paramStringBuilder = "0";
          break label1196;
          label1608:
          paramList = (MessageRecord)paramList1.get(0);
          paramList.saveExtInfoToExtStr("welcome_msg", "true");
          if ((i != 2) && (((paramList instanceof MessageForText)) || ((paramList instanceof MessageForLongMsg)))) {
            ThreadManager.executeOnSubThread(new LifeOnlineElemDecoder.2(this, localMessageHandler, paramMsg));
          }
          if (paramList1.isEmpty()) {
            break;
          }
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("public_account_msg_unread_flag", String.valueOf(i5));
          ((MessageRecord)paramList1.get(0)).saveExtInfoToExtStr("public_account_msg_extra_info_type", String.valueOf(i6));
          return;
        }
        label1167:
        label1318:
        label1324:
        label1719:
        i2 = j;
        label1414:
        label1420:
        label1426:
        label1432:
        label1439:
        label1446:
        label1579:
        paramStringBuilder = parambfoy;
      }
      localElem = null;
    }
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bfoy parambfoy, bcsc parambcsc, bcre parambcre)
  {
    a(paramList, paramList1, paramStringBuilder, paramMsg, parambfoy);
    return false;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return paramElem.life_online.has();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhn
 * JD-Core Version:    0.7.0.1
 */