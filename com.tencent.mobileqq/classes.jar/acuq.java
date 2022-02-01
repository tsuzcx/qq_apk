import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.msg.im_msg_body.Elem;>;
import localpb.richMsg.RichMsg.VideoFile;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype27;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.VideoFile;

public class acuq
  extends acve
{
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LightVideoElemDecoder", 2, "lightvideo msg decode failed");
      }
      return;
    }
    Object localObject = null;
    Iterator localIterator = paramList.iterator();
    paramList = (List<im_msg_body.Elem>)localObject;
    label42:
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (im_msg_body.Elem)localIterator.next();
    } while ((!((im_msg_body.Elem)localObject).common_elem.has()) || (((im_msg_body.Elem)localObject).common_elem.uint32_service_type.get() != 27) || (!((im_msg_body.Elem)localObject).common_elem.bytes_pb_elem.has()));
    label630:
    for (;;)
    {
      try
      {
        hummer_commelem.MsgElemInfo_servtype27 localMsgElemInfo_servtype27 = new hummer_commelem.MsgElemInfo_servtype27();
        localMsgElemInfo_servtype27.mergeFrom(((im_msg_body.Elem)localObject).common_elem.bytes_pb_elem.get().toByteArray());
        if (!localMsgElemInfo_servtype27.video_file.has()) {
          break label630;
        }
        localObject = (im_msg_body.VideoFile)localMsgElemInfo_servtype27.video_file.get();
        paramList = (List<im_msg_body.Elem>)localObject;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      break label42;
      if (paramList == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("LightVideoElemDecoder", 2, "lightvideo msg decode failed, videoFile is null");
        return;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:light_video;\n");
      }
      RichMsg.VideoFile localVideoFile = new RichMsg.VideoFile();
      localVideoFile.setHasFlag(true);
      localVideoFile.bytes_file_name.set(paramList.bytes_file_name.get());
      localVideoFile.bytes_file_md5.set(paramList.bytes_file_md5.get());
      localVideoFile.bytes_file_uuid.set(paramList.bytes_file_uuid.get());
      localVideoFile.uint32_file_format.set(paramList.uint32_file_format.get());
      localVideoFile.uint32_file_size.set(paramList.uint32_file_size.get());
      localVideoFile.uint32_file_time.set(paramList.uint32_file_time.get());
      localVideoFile.uint32_thumb_width.set(paramList.uint32_thumb_width.get());
      localVideoFile.uint32_thumb_height.set(paramList.uint32_thumb_height.get());
      localVideoFile.uint32_file_status.set(2008);
      localVideoFile.uint32_file_progress.set(0);
      localVideoFile.bytes_thumb_file_md5.set(paramList.bytes_thumb_file_md5.get());
      localVideoFile.bytes_source.set(paramList.bytes_source.get());
      localVideoFile.uint32_thumb_file_size.set(paramList.uint32_thumb_file_size.get());
      localVideoFile.uint32_busi_type.set(paramList.uint32_busi_type.get());
      localVideoFile.uin32_from_chat_type.set(paramList.uint32_from_chat_type.get());
      localVideoFile.uin32_to_chat_type.set(paramList.uint32_to_chat_type.get());
      localVideoFile.bool_support_progressive.set(paramList.bool_support_progressive.get());
      localVideoFile.uint32_file_width.set(paramList.uint32_file_width.get());
      localVideoFile.uint32_file_height.set(paramList.uint32_file_height.get());
      localVideoFile.uint32_sub_busi_type.set(paramList.uint32_sub_busi_type.get());
      localVideoFile.uint32_video_attr.set(paramList.uint32_video_attr.get());
      paramList = (MessageForLightVideo)bcsa.a(-2071);
      paramList.msgtype = -2071;
      paramList.msgData = localVideoFile.toByteArray();
      paramList.msg = BaseApplication.getContext().getString(2131691255);
      paramList.parse();
      paramList1.add(paramList);
      if (!QLog.isColorLevel()) {
        break;
      }
      paramStringBuilder.append("LightVideo.msg: ").append(paramList.toString() + "\n" + paramList.toLogString()).append("\n");
      return;
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
    return (paramElem.common_elem.has()) && (27 == paramElem.common_elem.uint32_service_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acuq
 * JD-Core Version:    0.7.0.1
 */