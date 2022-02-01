import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.oidb.oidb_0xdea.PassThrough;

public class adhk
  extends adic
{
  public int a()
  {
    return -1000;
  }
  
  protected void a(List<MessageRecord> paramList, StringBuilder paramStringBuilder, im_msg_body.Elem paramElem)
  {
    if ((paramElem.general_flags.has()) && (((im_msg_body.GeneralFlags)paramElem.general_flags.get()).uint32_olympic_torch.has()))
    {
      int i = paramElem.general_flags.uint32_olympic_torch.get();
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("has olympicTorch:").append(i).append(";");
      }
      if ((i > 0) && (!paramList.isEmpty())) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("olympic_torch_flg", i + "");
      }
    }
  }
  
  protected void a(List<MessageRecord> paramList, msg_comm.Msg paramMsg, im_msg_body.Elem paramElem)
  {
    long l;
    int n;
    int m;
    generalflags.ResvAttr localResvAttr;
    if (paramElem.general_flags.has())
    {
      if (paramElem.general_flags.uint64_pendant_id.has())
      {
        l = paramElem.general_flags.uint64_pendant_id.get();
        if (QLog.isColorLevel()) {
          QLog.d("GeneralFlagsElemDecoder", 2, "vip_pendant_id = " + l);
        }
        if ((l >= 0L) && (!paramList.isEmpty())) {
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("vip_pendant_id", String.valueOf(l));
        }
      }
      k = 0;
      n = 0;
      m = 0;
      if (paramElem.general_flags.bytes_pb_reserve.has())
      {
        localResvAttr = new generalflags.ResvAttr();
        j = n;
      }
    }
    for (;;)
    {
      try
      {
        localResvAttr.mergeFrom(paramElem.general_flags.bytes_pb_reserve.get().toByteArray());
        j = n;
        if (localResvAttr.float_sticker_x.has())
        {
          j = n;
          paramElem = new EmojiStickerManager.StickerInfo();
          j = n;
          paramElem.x = localResvAttr.float_sticker_x.get();
          j = n;
          if (!localResvAttr.float_sticker_y.has()) {
            continue;
          }
          j = n;
          f = localResvAttr.float_sticker_y.get();
          j = n;
          paramElem.y = f;
          j = n;
          if (!localResvAttr.float_sticker_width.has()) {
            continue;
          }
          j = n;
          f = localResvAttr.float_sticker_width.get();
          j = n;
          paramElem.width = f;
          j = n;
          if (!localResvAttr.float_sticker_height.has()) {
            continue;
          }
          j = n;
          f = localResvAttr.float_sticker_height.get();
          j = n;
          paramElem.height = f;
          j = n;
          if (!localResvAttr.uint32_sticker_rotate.has()) {
            continue;
          }
          j = n;
          i = localResvAttr.uint32_sticker_rotate.get();
          j = n;
          paramElem.rotate = i;
          j = n;
          if (!localResvAttr.uint64_sticker_host_msgseq.has()) {
            continue;
          }
          j = n;
          l = localResvAttr.uint64_sticker_host_msgseq.get();
          j = n;
          paramElem.hostMsgSeq = l;
          j = n;
          if (!localResvAttr.uint64_sticker_host_msguid.has()) {
            continue;
          }
          j = n;
          l = localResvAttr.uint64_sticker_host_msguid.get();
          j = n;
          paramElem.hostMsgUid = l;
          j = n;
          if (!localResvAttr.uint64_sticker_host_time.has()) {
            continue;
          }
          j = n;
          l = localResvAttr.uint64_sticker_host_time.get();
          j = n;
          paramElem.hostMsgTime = l;
          j = n;
          if (QLog.isColorLevel())
          {
            j = n;
            QLog.d("GeneralFlagsElemDecoder", 2, "decodeC2CMsgPkg_EmojSticker->" + paramElem.toString());
          }
          j = n;
          if (!paramList.isEmpty())
          {
            j = n;
            localObject = (MessageRecord)paramList.get(0);
            if (localObject != null)
            {
              j = n;
              ((MessageRecord)localObject).saveExtInfoToExtStr("sticker_info", paramElem.toJsonString());
              j = n;
              EmojiStickerManager.a((MessageRecord)localObject, paramElem);
              j = n;
              ((MessageRecord)localObject).saveExtInfoToExtStr("message_is_sticker", "true");
            }
          }
        }
        j = n;
        if (!localResvAttr.uint32_mobile_custom_font.has()) {
          continue;
        }
        j = n;
        l = localResvAttr.uint32_mobile_custom_font.get() & 0xFFFFFFFF;
        j = n;
        if (!paramList.isEmpty())
        {
          j = n;
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("vip_font_id", String.valueOf(l));
        }
        j = n;
        if (!QLog.isColorLevel()) {
          continue;
        }
        j = n;
        QLog.d("GeneralFlagsElemDecoder", 2, "vip_font_id = " + l + " fontId = " + gc.a(l) + " type = " + gc.b(l));
      }
      catch (InvalidProtocolBufferMicroException paramElem)
      {
        float f;
        Object localObject;
        paramElem.printStackTrace();
        k = j;
        continue;
        j = i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        j = i;
        QLog.d("VasFont", 2, "diy_font_timestamp not in message");
        continue;
        int i = 1;
        continue;
        boolean bool = false;
        continue;
      }
      j = i;
      if (localResvAttr.uint64_subfont_id.has())
      {
        j = i;
        l = localResvAttr.uint64_subfont_id.get();
        j = i;
        if (!paramList.isEmpty())
        {
          j = i;
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("vip_sub_font_id", String.valueOf(l));
        }
        j = i;
        if (QLog.isColorLevel())
        {
          j = i;
          QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags: subFontId=" + l);
        }
      }
      j = i;
      if (!localResvAttr.uint32_diy_font_timestamp.has()) {
        continue;
      }
      j = i;
      l = localResvAttr.uint32_diy_font_timestamp.get();
      j = i;
      if (!paramList.isEmpty())
      {
        j = i;
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("diy_timestamp", String.valueOf(l));
      }
      j = i;
      if (QLog.isColorLevel())
      {
        j = i;
        QLog.d("VasFont", 2, "diy_font_timestamp = " + l);
      }
      j = i;
      if (localResvAttr.uint32_tail_key.has())
      {
        j = i;
        if (2 == localResvAttr.uint32_tail_key.get())
        {
          j = i;
          if (localResvAttr.uint32_show_tail_flag.has())
          {
            j = i;
            if (1 != localResvAttr.uint32_show_tail_flag.get())
            {
              j = i;
              localResvAttr.uint32_tail_key.clear();
              j = i;
              if (QLog.isColorLevel())
              {
                j = i;
                QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags uint32_show_tail_flag != 1, uint32_tail_key been cleaned ");
              }
            }
          }
        }
      }
      j = i;
      if (localResvAttr.uint32_tail_key.has())
      {
        j = i;
        k = localResvAttr.uint32_tail_key.get();
        j = i;
        if (!paramList.isEmpty())
        {
          j = i;
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("app_tail_id", String.valueOf(k));
        }
        j = i;
        if (QLog.isColorLevel())
        {
          j = i;
          QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags uint32_tail_key = " + k);
        }
      }
      j = i;
      if (localResvAttr.uint32_bot_message_class_id.has())
      {
        j = i;
        k = localResvAttr.uint32_bot_message_class_id.get();
        j = i;
        if (!paramList.isEmpty())
        {
          j = i;
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("robot_news_class_id", String.valueOf(k));
        }
        j = i;
        if (QLog.isColorLevel())
        {
          j = i;
          QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags uint32_bot_message_class_id = " + k);
        }
      }
      j = i;
      if (localResvAttr.uint32_holiday_flag.has())
      {
        j = i;
        k = localResvAttr.uint32_holiday_flag.get();
        if (k == 1)
        {
          j = i;
          if (!paramList.isEmpty())
          {
            j = i;
            ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr(bcrn.c, String.valueOf(k));
          }
        }
        j = i;
        if (QLog.isColorLevel())
        {
          j = i;
          QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags uint32_holiday_flag = " + k);
        }
      }
      j = i;
      paramElem = new StringBuilder("<---decodeMiniProgramPBMsgElems:");
      j = i;
      if (localResvAttr.uint32_service_msg_type.has())
      {
        j = i;
        k = localResvAttr.uint32_service_msg_type.get();
        j = i;
        if (!paramList.isEmpty())
        {
          j = i;
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr(bcrn.z, String.valueOf(k));
        }
        j = i;
        paramElem.append("---uint32_service_msg_type = ").append(k).append("---");
      }
      j = i;
      if (localResvAttr.uint32_service_msg_remind_type.has())
      {
        j = i;
        k = localResvAttr.uint32_service_msg_remind_type.get();
        j = i;
        if (!paramList.isEmpty())
        {
          j = i;
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr(bcrn.A, String.valueOf(k));
        }
        j = i;
        paramElem.append("---uint32_service_msg_remind_type = ").append(k).append("---");
      }
      j = i;
      if (localResvAttr.bytes_service_msg_name.has())
      {
        j = i;
        localObject = localResvAttr.bytes_service_msg_name.get().toStringUtf8();
        j = i;
        if (!paramList.isEmpty())
        {
          j = i;
          ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr(bcrn.B, (String)localObject);
        }
        j = i;
        paramElem.append("---bytes_service_msg_name = ").append((String)localObject).append("---");
      }
      j = i;
      if (QLog.isColorLevel())
      {
        j = i;
        QLog.d("GeneralFlagsElemDecoder", 2, new Object[] { paramElem });
      }
      j = i;
      try
      {
        if (localResvAttr.uint32_msg_info_flag.has())
        {
          j = i;
          k = localResvAttr.uint32_msg_info_flag.get();
          j = i;
          if (!paramList.isEmpty())
          {
            j = i;
            ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(k));
          }
          j = i;
          if (QLog.isColorLevel())
          {
            j = i;
            QLog.i("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags: invoked.  flag: " + k + ", mr: " + paramList.get(0));
          }
        }
      }
      catch (Throwable paramElem)
      {
        continue;
      }
      k = i;
      j = i;
      if (localResvAttr.uint32_comment_flag.has())
      {
        k = i;
        j = i;
        if (localResvAttr.uint64_comment_location.has())
        {
          k = i;
          j = i;
          if (!paramList.isEmpty())
          {
            j = i;
            if (localResvAttr.uint32_comment_flag.get() != 1) {
              continue;
            }
            bool = true;
            j = i;
            l = localResvAttr.uint64_comment_location.get();
            j = i;
            paramElem = (MessageRecord)paramList.get(0);
            j = i;
            if ((paramElem instanceof MessageForReplyText))
            {
              j = i;
              paramElem = (MessageForReplyText)paramElem;
              j = i;
              paramElem.isBarrageMsg = bool;
              j = i;
              paramElem.barrageTimeLocation = l;
              j = i;
              if (paramElem.isBarrageMsg)
              {
                j = i;
                paramElem.saveExtInfoToExtStr("barrage_time_location", String.valueOf(paramElem.barrageTimeLocation));
                j = i;
              }
            }
          }
        }
      }
      try
      {
        localObject = new oidb_0xdea.PassThrough();
        j = i;
        ((oidb_0xdea.PassThrough)localObject).mergeFrom(localResvAttr.bytes_pass_through.get().toByteArray());
        j = i;
        paramElem.barrageSourceMsgType = ((oidb_0xdea.PassThrough)localObject).entrance.get();
      }
      catch (Exception paramElem)
      {
        j = i;
        QLog.i("GeneralFlagsElemDecoder", 1, "handleGeneralSettingFlags fail, " + paramElem);
        continue;
      }
      k = i;
      j = i;
      if (QLog.isColorLevel())
      {
        j = i;
        QLog.d("GeneralFlagsElemDecoder", 2, new Object[] { "receive replay msg, isBarrageMsg: ", Boolean.valueOf(bool), " timeLocation:", Long.valueOf(l) });
        k = i;
      }
      if (k == 0)
      {
        l = bcrw.a(paramMsg);
        if (l >= 0L)
        {
          if (!paramList.isEmpty()) {
            ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("vip_font_id", String.valueOf(l));
          }
          if (QLog.isColorLevel()) {
            QLog.d("GeneralFlagsElemDecoder", 2, "old vip_font_id = " + l + " fontId = " + gc.a(l) + " type = " + gc.b(l));
          }
        }
      }
      return;
      f = 0.0F;
      continue;
      f = 0.0F;
      continue;
      f = 0.0F;
      continue;
      i = 0;
      continue;
      l = 0L;
      continue;
      l = 0L;
      continue;
      l = 0L;
      continue;
      i = m;
      j = n;
      if (QLog.isColorLevel())
      {
        j = n;
        QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags vip_font not has");
        i = m;
      }
    }
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bfoy parambfoy, bcsc parambcsc, bcre parambcre)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      parambfoy = (im_msg_body.Elem)paramList.next();
      a(paramList1, paramStringBuilder, parambfoy);
      a(paramList1, paramMsg, parambfoy);
    }
    return false;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return paramElem.general_flags.has();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adhk
 * JD-Core Version:    0.7.0.1
 */