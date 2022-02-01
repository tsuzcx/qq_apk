import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype2;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class acux
  extends acve
{
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:PokeMsg;\n");
    }
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      paramStringBuilder = (im_msg_body.Elem)paramList.next();
    } while (!paramStringBuilder.common_elem.has());
    for (paramList = (im_msg_body.CommonElem)paramStringBuilder.common_elem.get();; paramList = null)
    {
      if (paramList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PokeMsg", 2, "decodePBMsgElems_PokeMsg null commomElem!");
        }
        return;
      }
      paramStringBuilder = new MessageForPoke();
      paramStringBuilder.msgtype = -5012;
      if (paramList.uint32_business_type.has()) {
        paramStringBuilder.interactType = paramList.uint32_business_type.get();
      }
      hummer_commelem.MsgElemInfo_servtype2 localMsgElemInfo_servtype2;
      if (paramList.bytes_pb_elem.has()) {
        localMsgElemInfo_servtype2 = new hummer_commelem.MsgElemInfo_servtype2();
      }
      for (;;)
      {
        try
        {
          localMsgElemInfo_servtype2.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
          paramStringBuilder.msg = localMsgElemInfo_servtype2.bytes_poke_summary.get().toStringUtf8();
          paramStringBuilder.doubleHitState = localMsgElemInfo_servtype2.uint32_double_hit.get();
          if (!localMsgElemInfo_servtype2.uint32_vaspoke_id.has()) {
            continue;
          }
          i = localMsgElemInfo_servtype2.uint32_vaspoke_id.get();
          paramStringBuilder.subId = i;
          if (!localMsgElemInfo_servtype2.bytes_vaspoke_name.has()) {
            continue;
          }
          paramList = localMsgElemInfo_servtype2.bytes_vaspoke_name.get().toStringUtf8();
          paramStringBuilder.name = paramList;
          if (!localMsgElemInfo_servtype2.bytes_vaspoke_minver.has()) {
            continue;
          }
          paramList = localMsgElemInfo_servtype2.bytes_vaspoke_minver.get().toStringUtf8();
          paramStringBuilder.minVersion = paramList;
          paramStringBuilder.strength = localMsgElemInfo_servtype2.uint32_poke_strength.get();
          if (!localMsgElemInfo_servtype2.uint32_poke_flag.has()) {
            continue;
          }
          i = localMsgElemInfo_servtype2.uint32_poke_flag.get();
          paramStringBuilder.flag = i;
          if (paramStringBuilder.interactType == 126) {
            VasWebviewUtil.reportCommercialDrainage("", "poke", "receive", "", 0, 0, 0, "", String.valueOf(paramStringBuilder.subId), "none", "", "", "", "", 0, 0, 0, 0);
          }
        }
        catch (Exception paramList)
        {
          int i;
          QLog.d("PokeMsg", 1, "decodePBMsgElems_PokeMsg exception!", paramList);
          continue;
        }
        paramList1.add(paramStringBuilder);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("PokeMsg", 2, "decodePbElems, common_elem type 2, interactType:" + paramStringBuilder.interactType + " ,doubleHitState:" + paramStringBuilder.doubleHitState);
        return;
        i = -1;
        continue;
        paramList = anvx.a(2131706127);
        continue;
        paramList = "";
        continue;
        i = 0;
      }
    }
  }
  
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bffl parambffl, bcse parambcse, bcre parambcre)
  {
    a(paramList, paramList1, paramStringBuilder);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.common_elem.has()) && (2 == paramElem.common_elem.uint32_service_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acux
 * JD-Core Version:    0.7.0.1
 */