import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.msg.im_msg_body.Elem;>;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.Attr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GroupFile;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21.ResvAttr;

public class acyq
  extends aczg
{
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    MessageHandler localMessageHandler = localQQAppInterface.a();
    Object localObject = null;
    Iterator localIterator = paramList.iterator();
    do
    {
      paramList = (List<im_msg_body.Elem>)localObject;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (im_msg_body.Elem)localIterator.next();
    } while (!paramList.group_file.has());
    paramList = (im_msg_body.GroupFile)paramList.group_file.get();
    if (paramList == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:GroupFile;\n");
      }
      long l1 = 0L;
      paramStringBuilder = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (paramStringBuilder.discuss_info.has()) {
        l1 = ((msg_comm.DiscussInfo)paramStringBuilder.discuss_info.get()).discuss_uin.get();
      }
      long l4 = paramStringBuilder.from_uin.get();
      long l6 = paramStringBuilder.msg_time.get();
      long l7 = paramStringBuilder.msg_seq.get();
      long l5 = localMessageHandler.app.getLongAccountUin();
      if (anqc.a(localMessageHandler.app, 3000, String.valueOf(l1), String.valueOf(l4), l6, l7)) {
        continue;
      }
      paramStringBuilder = "";
      try
      {
        localObject = new String(paramList.bytes_filename.get().toByteArray(), "UTF-8");
        paramStringBuilder = (StringBuilder)localObject;
        long l3 = 0L;
        l2 = l3;
        if (paramMsg.msg_body.has())
        {
          paramMsg = (im_msg_body.MsgBody)paramMsg.msg_body.get();
          l2 = l3;
          if (paramMsg.rich_text.attr.has()) {
            l2 = bbzj.a(((im_msg_body.Attr)paramMsg.rich_text.attr.get()).random.get());
          }
        }
        paramMsg = (MessageForFile)bbzh.a(-2005);
        paramMsg.msgtype = -2005;
        k = 0;
        m = 0;
        j = m;
        i = k;
        if (paramList.bytes_pb_reserve.has()) {
          localObject = new hummer_resv_21.ResvAttr();
        }
      }
      catch (UnsupportedEncodingException localInvalidProtocolBufferMicroException)
      {
        try
        {
          long l2;
          int k;
          int m;
          ((hummer_resv_21.ResvAttr)localObject).mergeFrom(paramList.bytes_pb_reserve.get().toByteArray());
          int j = m;
          int i = k;
          if (((hummer_resv_21.ResvAttr)localObject).file_image_info.has())
          {
            i = ((hummer_resv_21.ResvAttr)localObject).file_image_info.uint32_file_height.get();
            j = ((hummer_resv_21.ResvAttr)localObject).file_image_info.uint32_file_width.get();
            paramMsg.saveExtInfoToExtStr("file_pic_width", String.valueOf(j));
            paramMsg.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(i));
          }
          paramMsg.uniseq = localMessageHandler.app.a().a(paramMsg.uniseq, l1, l4, l7, l2, l6, paramList, j, i);
          l1 = paramList.uint64_file_size.get();
          if (l4 == l5)
          {
            bool = true;
            paramMsg.msg = bdzv.a(paramStringBuilder, l1, 0, bool);
            paramMsg.doParse();
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          try
          {
            for (;;)
            {
              paramMsg.fileName = atvo.a(new String(paramList.bytes_filename.get().toByteArray(), "UTF-8"));
              paramList1.add(paramMsg);
              ((bdkg)localQQAppInterface.getManager(272)).a(paramMsg);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("GroupFileElemDecoder", 2, "GroupDiscFile.msg: " + paramList.bytes_filename.get() + ";");
              return;
              localUnsupportedEncodingException = localUnsupportedEncodingException;
              localUnsupportedEncodingException.printStackTrace();
              continue;
              localInvalidProtocolBufferMicroException = localInvalidProtocolBufferMicroException;
              localInvalidProtocolBufferMicroException.printStackTrace();
            }
            boolean bool = false;
          }
          catch (UnsupportedEncodingException paramStringBuilder)
          {
            for (;;)
            {
              paramStringBuilder.printStackTrace();
              QLog.e("GroupFileElemDecoder", 1, "internalDiscOfflineFile: Exception is " + paramStringBuilder.toString());
            }
          }
        }
      }
    }
  }
  
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bepr parambepr, bbzl parambbzl, bbyn parambbyn)
  {
    a(paramList, paramList1, paramStringBuilder, paramMsg);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return paramElem.group_file.has();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyq
 * JD-Core Version:    0.7.0.1
 */