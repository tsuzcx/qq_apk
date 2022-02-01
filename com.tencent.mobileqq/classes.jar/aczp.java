import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.msg.im_msg_body.Elem;>;
import localpb.richMsg.RichMsg.VideoFile;
import msf.msgcomm.msg_comm.Msg;
import org.jetbrains.annotations.NotNull;
import tencent.im.babyq.babyq_cookie.BabyQCookie;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.im_msg_body.BlessingMessage;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.VideoFile;

public class aczp
  extends aczg
{
  @NotNull
  private MessageForShortVideo a(im_msg_body.GeneralFlags paramGeneralFlags, RichMsg.VideoFile paramVideoFile)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)bbzh.a(-2022);
    localMessageForShortVideo.msgtype = -2022;
    localMessageForShortVideo.msgData = paramVideoFile.toByteArray();
    if (paramVideoFile.uint32_busi_type.get() == 2) {}
    for (localMessageForShortVideo.msg = bcee.b;; localMessageForShortVideo.msg = bcee.a)
    {
      if ((paramGeneralFlags != null) && (paramGeneralFlags.babyq_guide_msg_cookie.has())) {}
      try
      {
        babyq_cookie.BabyQCookie localBabyQCookie = new babyq_cookie.BabyQCookie();
        byte[] arrayOfByte = paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray();
        localBabyQCookie = (babyq_cookie.BabyQCookie)localBabyQCookie.mergeFrom(arrayOfByte);
        if ((localBabyQCookie.uint32_need_not_report.has()) && (localBabyQCookie.uint32_need_not_report.get() == 0))
        {
          String str = bgjw.a(arrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("VideoFileElemDecoder", 2, "decodePBMsgElems_VideoFile, guideMsgCookie: " + str + ",bytes: " + Arrays.toString(paramGeneralFlags.babyq_guide_msg_cookie.get().toByteArray()));
          }
          localMessageForShortVideo.saveExtInfoToExtStr("guide_msg_cookie", str);
        }
        if (localBabyQCookie.uint32_video_type.has())
        {
          int i = localBabyQCookie.uint32_video_type.get();
          if (QLog.isColorLevel()) {
            QLog.d("VideoFileElemDecoder", 2, "decodePBMsgElems_VideoFile, video_type: " + i);
          }
          localMessageForShortVideo.saveExtInfoToExtStr("guide_video_type", String.valueOf(i));
        }
        ((anhp)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(53)).a(arrayOfByte);
      }
      catch (Exception paramGeneralFlags)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoFileElemDecoder", 2, "get video guideMsgCookie error!", paramGeneralFlags);
          }
        }
      }
      localMessageForShortVideo.parse();
      if (localMessageForShortVideo.redBagType == LocalMediaInfo.REDBAG_TYPE_GET)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoFileElemDecoder", 2, "VideoRedbag, decodePBMsgElems_VideoFile");
        }
        bckg.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), false);
        if (VideoRedbagData.queryRewardStat(localMessageForShortVideo.shortVideoId))
        {
          localMessageForShortVideo.redBagStat = 1;
          paramVideoFile.red_envelope_pay_stat.set(1);
        }
      }
      return localMessageForShortVideo;
    }
  }
  
  @NotNull
  private RichMsg.VideoFile a(im_msg_body.VideoFile paramVideoFile, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    RichMsg.VideoFile localVideoFile = new RichMsg.VideoFile();
    localVideoFile.setHasFlag(true);
    localVideoFile.bytes_file_name.set(paramVideoFile.bytes_file_name.get());
    localVideoFile.bytes_file_md5.set(paramVideoFile.bytes_file_md5.get());
    localVideoFile.bytes_file_uuid.set(paramVideoFile.bytes_file_uuid.get());
    localVideoFile.uint32_file_format.set(paramVideoFile.uint32_file_format.get());
    localVideoFile.uint32_file_size.set(paramVideoFile.uint32_file_size.get());
    localVideoFile.uint32_file_time.set(paramVideoFile.uint32_file_time.get());
    localVideoFile.uint32_thumb_width.set(paramVideoFile.uint32_thumb_width.get());
    localVideoFile.uint32_thumb_height.set(paramVideoFile.uint32_thumb_height.get());
    localVideoFile.uint32_file_status.set(2008);
    localVideoFile.uint32_file_progress.set(0);
    localVideoFile.bytes_thumb_file_md5.set(paramVideoFile.bytes_thumb_file_md5.get());
    localVideoFile.bytes_source.set(paramVideoFile.bytes_source.get());
    localVideoFile.uint32_thumb_file_size.set(paramVideoFile.uint32_thumb_file_size.get());
    localVideoFile.uint32_busi_type.set(paramVideoFile.uint32_busi_type.get());
    localVideoFile.uin32_from_chat_type.set(paramVideoFile.uint32_from_chat_type.get());
    localVideoFile.uin32_to_chat_type.set(paramVideoFile.uint32_to_chat_type.get());
    localVideoFile.bool_support_progressive.set(paramVideoFile.bool_support_progressive.get());
    localVideoFile.uint32_file_width.set(paramVideoFile.uint32_file_width.get());
    localVideoFile.uint32_file_height.set(paramVideoFile.uint32_file_height.get());
    localVideoFile.uint32_sub_busi_type.set(paramVideoFile.uint32_sub_busi_type.get());
    localVideoFile.uint32_video_attr.set(paramVideoFile.uint32_video_attr.get());
    videoFile.ResvAttr localResvAttr;
    if (paramVideoFile.bytes_pb_reserve.has()) {
      localResvAttr = new videoFile.ResvAttr();
    }
    try
    {
      localResvAttr.mergeFrom(paramVideoFile.bytes_pb_reserve.get().toByteArray());
      localVideoFile.bytes_hotvideo_icon.set(localResvAttr.bytes_hotvideo_icon.get());
      localVideoFile.bytes_hotvideo_icon_sub.set(localResvAttr.bytes_hotvideo_icon_sub.get());
      localVideoFile.bytes_hotvideo_title.set(localResvAttr.bytes_hotvideo_title.get());
      localVideoFile.bytes_hotvideo_url.set(localResvAttr.bytes_hotvideo_url.get());
      localVideoFile.uint32_special_video_type.set(localResvAttr.uint32_special_video_type.get());
      localVideoFile.uint32_msg_tail_type.set(localResvAttr.uint32_msg_tail_type.get());
      localVideoFile.uint32_long_video_kandian_type.set(localResvAttr.uint32_long_video_kandian_type.get());
      if (localResvAttr.bytes_camera_templateid.has()) {
        localVideoFile.bytes_camera_video_templateid.set(localResvAttr.bytes_camera_templateid.get());
      }
      if (localResvAttr.bytes_camera_templateName.has()) {
        localVideoFile.bytes_camera_video_templatename.set(localResvAttr.bytes_camera_templateName.get());
      }
    }
    catch (InvalidProtocolBufferMicroException paramVideoFile)
    {
      try
      {
        do
        {
          paramVideoFile.mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
          localVideoFile.uint32_red_envelope_type.set(paramVideoFile.uint32_red_envelope_type.get());
          localVideoFile.bytes_shortVideoId.set(paramVideoFile.bytes_shortVideoId.get());
          return localVideoFile;
          paramVideoFile = paramVideoFile;
        } while (!QLog.isColorLevel());
        QLog.d("VideoFileElemDecoder", 2, "ShortVideo doParse error!", paramVideoFile);
      }
      catch (Exception paramVideoFile)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("VideoFileElemDecoder", 2, "ShortVideo doParse generalFlag error!", paramVideoFile);
      }
    }
    if ((paramGeneralFlags != null) && (paramGeneralFlags.bytes_pb_reserve.has())) {
      paramVideoFile = new generalflags.ResvAttr();
    }
    return localVideoFile;
  }
  
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder)
  {
    Object localObject = null;
    boolean bool = true;
    Iterator localIterator = paramList.iterator();
    int i = -1;
    int j = 0;
    im_msg_body.Elem localElem = null;
    paramList = (List<im_msg_body.Elem>)localObject;
    localObject = localElem;
    if (localIterator.hasNext())
    {
      localElem = (im_msg_body.Elem)localIterator.next();
      if (!localElem.video_file.has()) {
        break label334;
      }
      localObject = (im_msg_body.VideoFile)localElem.video_file.get();
    }
    label316:
    label334:
    for (;;)
    {
      if ((localElem.bless_msg.has()) && (localElem.bless_msg.uint32_msg_type.get() == 1)) {
        if (localElem.bless_msg.uint32_ex_flag.has())
        {
          i = localElem.bless_msg.uint32_ex_flag.get();
          j = 1;
        }
      }
      for (;;)
      {
        if (localElem.general_flags.has()) {
          paramList = (im_msg_body.GeneralFlags)localElem.general_flags.get();
        }
        for (;;)
        {
          break;
          if (localObject == null) {
            return;
          }
          if (QLog.isColorLevel()) {
            paramStringBuilder.append("elemType:video_file;\n");
          }
          paramList = a(paramList, a((im_msg_body.VideoFile)localObject, paramList));
          paramList1.add(paramList);
          if (j != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoFileElemDecoder", 2, "decodePBMsgElems, isBlessMsg: true ,updateFlag: " + i);
            }
            paramList.isBlessMsg = true;
            if (i > -1) {
              if ((i & 0x1) != 1) {
                break label316;
              }
            }
          }
          for (;;)
          {
            paramList.needUpdateMsgTag = bool;
            if (!QLog.isColorLevel()) {
              break;
            }
            paramStringBuilder.append("ShortVideo.msg: ").append(paramList.toString() + "\n" + paramList.toLogString()).append("\n");
            return;
            bool = false;
          }
        }
        j = 1;
      }
    }
  }
  
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, bepr parambepr, bbzl parambbzl, bbyn parambbyn)
  {
    a(paramList, paramList1, paramStringBuilder);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return paramElem.video_file.has();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczp
 * JD-Core Version:    0.7.0.1
 */