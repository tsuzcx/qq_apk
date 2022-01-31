import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.BasePicOprerator;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.NotOnlineImage;

public class agpa
  extends AsyncTask
{
  final RichProtoProc.RichProtoCallback jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = new agpb(this);
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public agpa(BasePicOprerator paramBasePicOprerator, ArrayList paramArrayList) {}
  
  private String a(im_msg_body.CustomFace paramCustomFace)
  {
    if ((!QLog.isColorLevel()) || (paramCustomFace == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[CustomFace]uint32_server_ip:" + paramCustomFace.uint32_server_ip.get());
    localStringBuilder.append(",uint32_server_port:" + paramCustomFace.uint32_server_port.get());
    localStringBuilder.append(",uint32_file_id:" + paramCustomFace.uint32_file_id.get());
    localStringBuilder.append(",bytes_md5:" + HexUtil.bytes2HexStr(paramCustomFace.bytes_md5.get().toByteArray()));
    localStringBuilder.append(",str_file_path:" + paramCustomFace.str_file_path.get());
    localStringBuilder.append(",uint32_origin:" + paramCustomFace.uint32_origin.get());
    localStringBuilder.append(",uint32_width:" + paramCustomFace.uint32_width.get());
    localStringBuilder.append(",uint32_height:" + paramCustomFace.uint32_height.get());
    localStringBuilder.append(",uint32_height:" + paramCustomFace.uint32_height.get());
    localStringBuilder.append(",image_type:" + paramCustomFace.image_type.get());
    return localStringBuilder.toString();
  }
  
  private String a(im_msg_body.NotOnlineImage paramNotOnlineImage)
  {
    if ((!QLog.isColorLevel()) || (paramNotOnlineImage == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[NotOnlineImage]file_path:" + paramNotOnlineImage.file_path.get().toStringUtf8());
    localStringBuilder.append(",file_len:" + paramNotOnlineImage.file_len.get());
    localStringBuilder.append(",download_path:" + paramNotOnlineImage.download_path.get().toStringUtf8());
    localStringBuilder.append(",res_id:" + paramNotOnlineImage.res_id.get().toStringUtf8());
    localStringBuilder.append(",pic_md5:" + HexUtil.bytes2HexStr(paramNotOnlineImage.pic_md5.get().toByteArray()));
    localStringBuilder.append(",pic_height:" + paramNotOnlineImage.pic_height.get());
    localStringBuilder.append(",pic_width:" + paramNotOnlineImage.pic_width.get());
    localStringBuilder.append(",original:" + paramNotOnlineImage.original.get());
    localStringBuilder.append(",img_type:" + paramNotOnlineImage.img_type.get());
    localStringBuilder.append(",uint32_file_id:" + paramNotOnlineImage.uint32_file_id.get());
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.a(5, 0, this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected Void a(Void... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "doInBackground start isReMiao =  " + this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_Boolean);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(this.b.size());
    }
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    int i = 0;
    if (i < this.b.size())
    {
      PicFowardInfo localPicFowardInfo = (PicFowardInfo)this.b.get(i);
      if (!this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_Boolean)
      {
        paramVarArgs = new PicResult();
        paramVarArgs.jdField_a_of_type_ComTencentMobileqqPicPicReq = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramVarArgs);
      }
      RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
      localPicUpReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
      localPicUpReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin;
      localPicUpReq.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
      localPicUpReq.e = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
      boolean bool;
      if (localPicUpReq.jdField_f_of_type_Int == 1006)
      {
        bool = true;
        label220:
        localPicUpReq.jdField_c_of_type_Boolean = bool;
        localPicUpReq.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_JavaLangString);
        if (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l != 1) {
          break label509;
        }
        bool = true;
        label256:
        localPicUpReq.b = bool;
        if (localPicFowardInfo.jdField_a_of_type_Int == 2) {
          localPicUpReq.b = true;
        }
        if ((localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.j == 0) || (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k == 0) || (0L == localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c)) {
          break label514;
        }
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from UploadInfo");
        localPicUpReq.jdField_c_of_type_Int = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.j;
        localPicUpReq.jdField_d_of_type_Int = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k;
        localPicUpReq.jdField_a_of_type_Long = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.c;
        label397:
        if ((localPicUpReq.jdField_f_of_type_Int != 1) && (localPicUpReq.jdField_f_of_type_Int != 3000)) {
          break label746;
        }
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is Troop/Discussion message");
      }
      for (localRichProtoReq.jdField_a_of_type_JavaLangString = "grp_pic_up";; localRichProtoReq.jdField_a_of_type_JavaLangString = "c2c_pic_up")
      {
        localPicUpReq.jdField_a_of_type_JavaLangString = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_JavaLangString;
        localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localPicUpReq);
        i += 1;
        break;
        bool = false;
        break label220;
        label509:
        bool = false;
        break label256;
        label514:
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File");
        if (FileUtils.b(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g)) {
          paramVarArgs = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.g;
        }
        for (;;)
        {
          if (!FileUtils.b(paramVarArgs)) {
            break label693;
          }
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          SafeBitmapFactory.decodeFile(paramVarArgs, localOptions);
          localPicUpReq.jdField_c_of_type_Int = localOptions.outWidth;
          localPicUpReq.jdField_d_of_type_Int = localOptions.outHeight;
          localPicUpReq.jdField_a_of_type_Long = FileUtil.a(paramVarArgs);
          break;
          if (localPicUpReq.b) {}
          for (paramVarArgs = URLDrawableHelper.a(localPicFowardInfo, 131075, null);; paramVarArgs = URLDrawableHelper.a(localPicFowardInfo, 1, null))
          {
            if (paramVarArgs == null) {
              break label688;
            }
            paramVarArgs = AbsDownloader.d(paramVarArgs.toString());
            break;
          }
          label688:
          paramVarArgs = null;
        }
        label693:
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] Get width/height/filesize from File failed, targetPicFilepath = " + paramVarArgs);
        break label397;
        label746:
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "[" + i + "] is C2C message");
      }
    }
    if (!localRichProtoReq.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback;
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProtoReqManager();
      Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics", "requestStart:" + localRichProtoReq.toString());
      RichProtoProc.a(localRichProtoReq);
      return null;
    }
    a();
    return null;
  }
  
  im_msg_body.CustomFace a(RichProto.RichProtoReq.PicUpReq paramPicUpReq, RichProto.RichProtoResp.GroupPicUpResp paramGroupPicUpResp, int paramInt)
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    for (;;)
    {
      PicFowardInfo localPicFowardInfo;
      try
      {
        localPicFowardInfo = (PicFowardInfo)this.b.get(paramInt);
        if (paramGroupPicUpResp != null)
        {
          localCustomFace.uint32_file_id.set((int)paramGroupPicUpResp.jdField_a_of_type_Long);
          if ((paramGroupPicUpResp.jdField_a_of_type_JavaUtilArrayList != null) && (paramGroupPicUpResp.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            paramGroupPicUpResp = (ServerAddr)paramGroupPicUpResp.jdField_a_of_type_JavaUtilArrayList.get(0);
            localCustomFace.uint32_server_ip.set(GroupPicUploadProcessor.a(paramGroupPicUpResp.jdField_a_of_type_JavaLangString));
            localCustomFace.uint32_server_port.set(paramGroupPicUpResp.jdField_a_of_type_Int);
          }
          localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
          localCustomFace.uint32_useful.set(1);
          if (this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
            localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
          }
          if (paramPicUpReq == null) {
            break label443;
          }
          localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(paramPicUpReq.jdField_a_of_type_ArrayOfByte));
          localCustomFace.str_file_path.set(paramPicUpReq.jdField_a_of_type_JavaLangString);
          paramGroupPicUpResp = localCustomFace.uint32_origin;
          if (paramPicUpReq.b)
          {
            i = 1;
            paramGroupPicUpResp.set(i);
            localCustomFace.uint32_width.set(paramPicUpReq.jdField_c_of_type_Int);
            localCustomFace.uint32_height.set(paramPicUpReq.jdField_d_of_type_Int);
            localCustomFace.uint32_size.set((int)paramPicUpReq.jdField_a_of_type_Long);
            localCustomFace.biz_type.set(4);
            localCustomFace.uint32_source.set(104);
            localCustomFace.uint32_thumb_width.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.e);
            localCustomFace.uint32_thumb_height.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_Int);
            localCustomFace.image_type.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.m);
            Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] OK, " + a(localCustomFace));
            return localCustomFace;
          }
        }
        else
        {
          localCustomFace.uint32_file_id.set(0);
          continue;
        }
        int i = 0;
      }
      catch (Exception paramPicUpReq)
      {
        Logger.b(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createCustomFace", "[" + paramInt + "] failed, Exception, " + paramPicUpReq.toString());
        return null;
      }
      continue;
      label443:
      localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
      localCustomFace.str_file_path.set("bad");
      localCustomFace.uint32_origin.set(0);
      localCustomFace.uint32_width.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.j);
      localCustomFace.uint32_height.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k);
      localCustomFace.uint32_size.set(0);
    }
  }
  
  im_msg_body.NotOnlineImage a(RichProto.RichProtoReq.PicUpReq paramPicUpReq, RichProto.RichProtoResp.C2CPicUpResp paramC2CPicUpResp, int paramInt)
  {
    int i = 0;
    im_msg_body.NotOnlineImage localNotOnlineImage = new im_msg_body.NotOnlineImage();
    for (;;)
    {
      try
      {
        PicFowardInfo localPicFowardInfo = (PicFowardInfo)this.b.get(paramInt);
        if (paramPicUpReq != null)
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8(paramPicUpReq.jdField_a_of_type_JavaLangString));
          localNotOnlineImage.file_len.set((int)paramPicUpReq.jdField_a_of_type_Long);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(paramPicUpReq.jdField_a_of_type_ArrayOfByte));
          localNotOnlineImage.pic_height.set(paramPicUpReq.jdField_d_of_type_Int);
          localNotOnlineImage.pic_width.set(paramPicUpReq.jdField_c_of_type_Int);
          PBUInt32Field localPBUInt32Field = localNotOnlineImage.original;
          if (paramPicUpReq.b) {
            i = 1;
          }
          localPBUInt32Field.set(i);
          if (paramC2CPicUpResp != null)
          {
            if (paramC2CPicUpResp.b != null) {
              localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8(paramC2CPicUpResp.b));
            }
            if (paramC2CPicUpResp.jdField_a_of_type_JavaLangString != null) {
              localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8(paramC2CPicUpResp.jdField_a_of_type_JavaLangString));
            }
            localNotOnlineImage.img_type.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.m);
            localNotOnlineImage.biz_type.set(4);
            localNotOnlineImage.uint32_thumb_width.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.e);
            localNotOnlineImage.uint32_thumb_height.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_Int);
            Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] OK, " + a(localNotOnlineImage));
            return localNotOnlineImage;
          }
        }
        else
        {
          localNotOnlineImage.file_path.set(ByteStringMicro.copyFromUtf8("bad"));
          localNotOnlineImage.file_len.set(0);
          localNotOnlineImage.pic_md5.set(ByteStringMicro.copyFrom(new byte[] { 98, 97, 100 }));
          localNotOnlineImage.pic_height.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k);
          localNotOnlineImage.pic_width.set(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.j);
          localNotOnlineImage.original.set(0);
          continue;
        }
        localNotOnlineImage.download_path.set(ByteStringMicro.copyFromUtf8("bad"));
      }
      catch (Exception paramPicUpReq)
      {
        Logger.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.b, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.createNotOnlineImage", "[" + paramInt + "] failed, Exception" + paramPicUpReq.toString());
        return null;
      }
      localNotOnlineImage.res_id.set(ByteStringMicro.copyFromUtf8("bad"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agpa
 * JD-Core Version:    0.7.0.1
 */