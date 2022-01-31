import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.BasePicOprerator;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.NotOnlineImage;

class agkn
  implements RichProtoProc.RichProtoCallback
{
  private volatile long jdField_a_of_type_Long;
  private Random jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
  
  agkn(agkm paramagkm) {}
  
  private int a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_Agkm.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_Agkm.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          if (((PicResult)localIterator.next()).jdField_a_of_type_Int == -2) {
            i += 1;
          }
        }
        else {
          return i;
        }
      }
      finally {}
    }
  }
  
  private im_msg_body.CustomFace a(im_msg_body.NotOnlineImage paramNotOnlineImage)
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    try
    {
      localCustomFace.uint32_file_id.set(paramNotOnlineImage.uint32_file_id.get());
      localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
      localCustomFace.uint32_useful.set(1);
      if (this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
        localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
      }
      localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(paramNotOnlineImage.pic_md5.get().toByteArray()));
      if (paramNotOnlineImage.res_id.has()) {
        localCustomFace.str_file_path.set(paramNotOnlineImage.res_id.get().toStringUtf8());
      }
      for (;;)
      {
        localCustomFace.uint32_origin.set(paramNotOnlineImage.original.get());
        localCustomFace.biz_type.set(4);
        localCustomFace.uint32_source.set(104);
        localCustomFace.uint32_width.set(paramNotOnlineImage.pic_width.get());
        localCustomFace.uint32_height.set(paramNotOnlineImage.pic_height.get());
        localCustomFace.uint32_size.set(paramNotOnlineImage.file_len.get());
        localCustomFace.uint32_thumb_width.set(paramNotOnlineImage.uint32_thumb_width.get());
        localCustomFace.uint32_thumb_height.set(paramNotOnlineImage.uint32_thumb_height.get());
        localCustomFace.image_type.set(paramNotOnlineImage.img_type.get());
        Logger.a(this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.convert2CustomFace", agkm.a(this.jdField_a_of_type_Agkm, localCustomFace));
        return localCustomFace;
        if (paramNotOnlineImage.download_path.has()) {
          localCustomFace.str_file_path.set(paramNotOnlineImage.download_path.get().toStringUtf8());
        }
      }
      return null;
    }
    catch (Exception paramNotOnlineImage)
    {
      Logger.b(this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.convert2CustomFace", "Exception, " + paramNotOnlineImage.toString());
    }
  }
  
  private im_msg_body.NotOnlineImage a(im_msg_body.CustomFace paramCustomFace)
  {
    im_msg_body.NotOnlineImage localNotOnlineImage = new im_msg_body.NotOnlineImage();
    try
    {
      localNotOnlineImage.uint32_file_id.set(paramCustomFace.uint32_file_id.get());
      localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8("BADBADBAD"));
      Object localObject = new StringBuilder();
      long l = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = (1L + l);
      localObject = l + "BADBADBAD" + this.jdField_a_of_type_JavaUtilRandom.nextInt();
      localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8(paramCustomFace.str_file_path.get()));
      localNotOnlineImage.file_len.set(paramCustomFace.uint32_size.get());
      localNotOnlineImage.pic_md5.set(paramCustomFace.bytes_md5.get());
      localNotOnlineImage.pic_height.set(paramCustomFace.uint32_height.get());
      localNotOnlineImage.pic_width.set(paramCustomFace.uint32_width.get());
      localNotOnlineImage.original.set(paramCustomFace.uint32_origin.get());
      localNotOnlineImage.img_type.set(paramCustomFace.image_type.get());
      localNotOnlineImage.biz_type.set(4);
      localNotOnlineImage.uint32_thumb_width.set(paramCustomFace.uint32_thumb_width.get());
      localNotOnlineImage.uint32_thumb_height.set(paramCustomFace.uint32_thumb_height.get());
      Logger.a(this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "OK, " + agkm.a(this.jdField_a_of_type_Agkm, localNotOnlineImage));
      return localNotOnlineImage;
    }
    catch (Exception paramCustomFace)
    {
      Logger.a(this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "Failed, Exception" + paramCustomFace.toString());
    }
    return null;
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_Agkm.b.size();
    int j = a();
    PicResult localPicResult = new PicResult();
    localPicResult.jdField_a_of_type_Int = 0;
    localPicResult.jdField_a_of_type_JavaLangObject = Integer.valueOf(i - j);
    this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.a(6, 0, localPicResult);
  }
  
  private void b()
  {
    new agko(this).execute(new Void[0]);
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    Logger.a(this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.onBusiProtoResp", "start");
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "onBusiProtoResp miao size =  [" + paramRichProtoResp.a.size());
    }
    if ((paramRichProtoReq != null) && (paramRichProtoResp != null))
    {
      i = 0;
      if (i < paramRichProtoResp.a.size())
      {
        Object localObject1 = (PicFowardInfo)this.jdField_a_of_type_Agkm.b.get(i);
        PicResult localPicResult = (PicResult)this.jdField_a_of_type_Agkm.jdField_a_of_type_JavaUtilArrayList.get(i);
        Object localObject2 = (RichProto.RichProtoResp.RespCommon)paramRichProtoResp.a.get(i);
        if ((localObject2 instanceof RichProto.RichProtoResp.C2CPicUpResp))
        {
          localObject2 = (RichProto.RichProtoResp.C2CPicUpResp)localObject2;
          Logger.a(this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.onBusiProtoResp", "C2CPicUpResp[" + i + "]," + ((RichProto.RichProtoResp.C2CPicUpResp)localObject2).toString());
          if ((((RichProto.RichProtoResp.C2CPicUpResp)localObject2).c == 0) && (((RichProto.RichProtoResp.C2CPicUpResp)localObject2).jdField_a_of_type_Boolean))
          {
            localObject2 = this.jdField_a_of_type_Agkm.a((RichProto.RichProtoReq.PicUpReq)paramRichProtoReq.a.get(i), (RichProto.RichProtoResp.C2CPicUpResp)localObject2, i);
            if ((((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b != 1) && (((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b != 3000)) {
              break label410;
            }
            Logger.a(this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2CustomFace for [" + i + "] ");
            localObject1 = a((im_msg_body.NotOnlineImage)localObject2);
            if (localObject1 != null)
            {
              localPicResult.jdField_a_of_type_Int = 0;
              localPicResult.jdField_a_of_type_JavaLangObject = localObject1;
              a();
              if (QLog.isColorLevel()) {
                QLog.d("MultiMsg", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
              }
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label410:
          if (localObject2 != null)
          {
            localPicResult.jdField_a_of_type_Int = 0;
            localPicResult.jdField_a_of_type_JavaLangObject = localObject2;
            a();
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
              continue;
              if ((localObject2 instanceof RichProto.RichProtoResp.GroupPicUpResp))
              {
                localObject2 = (RichProto.RichProtoResp.GroupPicUpResp)localObject2;
                Logger.a(this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.onBusiProtoResp", "GroupPicUpResp[" + i + "]," + ((RichProto.RichProtoResp.GroupPicUpResp)localObject2).toString());
                if ((((RichProto.RichProtoResp.GroupPicUpResp)localObject2).c == 0) && (((RichProto.RichProtoResp.GroupPicUpResp)localObject2).jdField_a_of_type_Boolean))
                {
                  localObject2 = this.jdField_a_of_type_Agkm.a((RichProto.RichProtoReq.PicUpReq)paramRichProtoReq.a.get(i), (RichProto.RichProtoResp.GroupPicUpResp)localObject2, i);
                  if ((((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b == 1) || (((PicFowardInfo)localObject1).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b == 3000))
                  {
                    if (localObject2 != null)
                    {
                      localPicResult.jdField_a_of_type_Int = 0;
                      localPicResult.jdField_a_of_type_JavaLangObject = localObject2;
                      a();
                      if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
                      }
                    }
                  }
                  else
                  {
                    Logger.a(this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2NotOnlineImage for [" + i + "] ");
                    localObject1 = a((im_msg_body.CustomFace)localObject2);
                    if (localObject1 != null)
                    {
                      localPicResult.jdField_a_of_type_Int = 0;
                      localPicResult.jdField_a_of_type_JavaLangObject = localObject1;
                      a();
                      if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg", 2, "[uploadForwardMultiMsgPics] upload [" + i + "] success, picture is exsit");
                      }
                    }
                  }
                }
              }
              else
              {
                Logger.b(this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.onBusiProtoResp", "Unkown response type[" + i + "] " + localObject2.getClass().getSimpleName());
              }
            }
          }
        }
      }
    }
    int i = a();
    if (i > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg", 2, "[uploadForwardMultiMsgPics] need upload [" + i + "] pictures");
      }
      int k = 0;
      for (int j = 0; k < this.jdField_a_of_type_Agkm.jdField_a_of_type_JavaUtilArrayList.size(); j = i)
      {
        paramRichProtoReq = (PicFowardInfo)this.jdField_a_of_type_Agkm.b.get(k);
        paramRichProtoResp = (PicResult)this.jdField_a_of_type_Agkm.jdField_a_of_type_JavaUtilArrayList.get(k);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g);
        }
        i = j;
        if (paramRichProtoResp.jdField_a_of_type_Int == -2)
        {
          i = j;
          if (!BasePicOprerator.a(this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator, paramRichProtoReq))
          {
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g = MultiMsgManager.a(this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_JavaLangString = FileUtils.b(paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g);
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l = 1;
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.j = 242;
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k = 192;
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c = MultiMsgManager.a();
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.h = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g;
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_Int = 192;
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.e = 242;
            paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_f_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_JavaLangString;
            paramRichProtoResp.b = true;
            j = 1;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("MultiMsg", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + paramRichProtoReq.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g);
              i = j;
            }
          }
        }
        k += 1;
      }
      if ((j != 0) && (!this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Agkm.a(new Void[0]);
        return;
      }
      this.jdField_a_of_type_Agkm.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_Boolean = false;
      b();
      return;
    }
    agkm.a(this.jdField_a_of_type_Agkm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agkn
 * JD-Core Version:    0.7.0.1
 */