import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FavEmoRoamingHandler.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.cs.faceroam_sso.faceroam_sso.PlatInfo;
import tencent.im.cs.faceroam_sso.faceroam_sso.ReqBody;
import tencent.im.cs.faceroam_sso.faceroam_sso.ReqDeleteItem;
import tencent.im.cs.faceroam_sso.faceroam_sso.ReqUserInfo;
import tencent.im.cs.faceroam_sso.faceroam_sso.RspBody;
import tencent.im.cs.faceroam_sso.faceroam_sso.RspDeleteItem;
import tencent.im.cs.faceroam_sso.faceroam_sso.RspUserInfo;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr.ModifyReq;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr.ModifyRsp;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr.OcrInfo;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr.PicInfo;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr.ReqBody;
import tencent.im.oidb.cmd0xdc4.FavEmotionOcr.RspBody;
import tencent.im.oidb.cmd0xdcf.EmotionMove.PlatInfo;
import tencent.im.oidb.cmd0xdcf.EmotionMove.ReqBody;
import tencent.im.oidb.cmd0xdcf.EmotionMove.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class alnm
  extends ally<CustomEmotionData>
{
  public alnm(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList2 == null) || (paramList1 == null)) {}
    Object localObject2;
    do
    {
      return;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramList2.size())
      {
        localObject1 = (String)paramList2.get(i);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2 = new apkm((String)localObject1);
          if ((!((apkm)localObject2).a()) || (TextUtils.isEmpty(((apkm)localObject2).c)) || (TextUtils.isEmpty(((apkm)localObject2).d)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FavEmoRoamingHandler", 2, "res id is not valid:" + (String)localObject1);
            }
          }
          else {
            localArrayList.add(localObject2);
          }
        }
      }
      Object localObject1 = new ArrayList();
      i = 0;
      apkm localapkm1;
      if (i < paramList1.size())
      {
        localObject2 = (String)paramList1.get(i);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {}
        for (;;)
        {
          i += 1;
          break;
          localapkm1 = new apkm((String)localObject2);
          if ((!localapkm1.a()) || (TextUtils.isEmpty(localapkm1.c)) || (TextUtils.isEmpty(localapkm1.d)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FavEmoRoamingHandler", 2, "res id is not valid:" + (String)localObject2);
            }
          }
          else {
            ((List)localObject1).add(localapkm1);
          }
        }
      }
      localObject2 = new StringBuilder("");
      i = 0;
      while (i < localArrayList.size())
      {
        localapkm1 = (apkm)localArrayList.get(i);
        int j = 0;
        while (j < ((List)localObject1).size())
        {
          apkm localapkm2 = (apkm)((List)localObject1).get(j);
          if ((localapkm1.c.equals(localapkm2.c)) && (localapkm2.c.equals("0")) && (localapkm2.d.equals(localapkm1.d)))
          {
            paramList1.remove(localapkm2.a);
            ((StringBuilder)localObject2).append(localapkm2.a).append(", ");
          }
          j += 1;
        }
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FavEmoRoamingHandler", 2, "delList=" + paramList1.size() + ", roamingList=" + paramList2.size() + ", del resIds:" + localObject2);
  }
  
  private void b(Object paramObject)
  {
    EmotionMove.RspBody localRspBody;
    if (paramObject != null) {
      localRspBody = new EmotionMove.RspBody();
    }
    try
    {
      localRspBody.mergeFrom((byte[])paramObject);
      if (QLog.isColorLevel()) {
        QLog.d("FavEmoRoamingHandler", 2, "onReceive FAV_REQ_MOVE fail ret = " + localRspBody.ret + " ,errorMsg = " + localRspBody.errmsg);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      QLog.e("FavEmoRoamingHandler", 1, "handleEmotionMove ends, errInfo:" + paramObject.getMessage());
      return;
    }
    catch (OutOfMemoryError paramObject)
    {
      QLog.e("FavEmoRoamingHandler", 1, "handleEmotionMove oom");
      return;
    }
    catch (Exception paramObject)
    {
      QLog.e("FavEmoRoamingHandler", 1, "handleEmotionMove exception : " + paramObject.getMessage());
    }
  }
  
  public void a()
  {
    Object localObject = new faceroam_sso.ReqUserInfo();
    faceroam_sso.PlatInfo localPlatInfo = new faceroam_sso.PlatInfo();
    localPlatInfo.implat.set(109L);
    localPlatInfo.mqqver.set("8.3.3");
    localPlatInfo.osver.set(Build.VERSION.RELEASE);
    faceroam_sso.ReqBody localReqBody = new faceroam_sso.ReqBody();
    localReqBody.uint32_sub_cmd.set(1);
    localReqBody.uint64_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    localReqBody.reqcmd_0x01.set((MessageMicro)localObject);
    localReqBody.comm.set(localPlatInfo);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "Faceroam.OpReq");
    ((ToServiceMsg)localObject).extraData.putInt("cmd_fav_subcmd", 1);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, String paramString)
  {
    if (paramCustomEmotionData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FavEmoRoamingHandler", 2, "favEmoModifyOcr data = null");
      }
      return;
    }
    if ((this.app == null) || (this.app.getApp() == null))
    {
      QLog.e("FavEmoRoamingHandler", 1, "favEmoModifyOcr ocr fail, app is null");
      notifyUI(3, false, this.mApp.getApplication().getString(2131692114));
      return;
    }
    if (!bdee.a())
    {
      notifyUI(3, false, this.app.getApp().getString(2131694061));
      return;
    }
    try
    {
      Object localObject1 = new FavEmotionOcr.ReqBody();
      ((FavEmotionOcr.ReqBody)localObject1).uint32_src_term.set(3);
      ((FavEmotionOcr.ReqBody)localObject1).uint32_cmd_type.set(3);
      ((FavEmotionOcr.ReqBody)localObject1).string_version.set("8.3.3");
      FavEmotionOcr.ModifyReq localModifyReq = new FavEmotionOcr.ModifyReq();
      Object localObject2 = new FavEmotionOcr.PicInfo();
      ((FavEmotionOcr.PicInfo)localObject2).string_pic_md5.set(paramCustomEmotionData.md5);
      ((FavEmotionOcr.PicInfo)localObject2).string_pic_fileid.set(paramCustomEmotionData.resid);
      localModifyReq.pic_info.set((MessageMicro)localObject2);
      localModifyReq.string_self_desc_new.set(paramString);
      localObject2 = new ArrayList();
      ((List)localObject2).add(localModifyReq);
      ((FavEmotionOcr.ReqBody)localObject1).list_modify_req.set((List)localObject2);
      localObject1 = makeOIDBPkg("OidbSvc.0xdc4", 3524, 1, ((FavEmotionOcr.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putInt("cmd_fav_subcmd", 5);
      ((ToServiceMsg)localObject1).extraData.putString("fav_modify_word", paramString);
      ((ToServiceMsg)localObject1).extraData.putInt("fav_modify_emoid", paramCustomEmotionData.emoId);
      super.sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FavEmoRoamingHandler", 1, "favEmoModifyOcr e=" + localException + " modifyWord=" + paramString + " CustomEmotionData=" + paramCustomEmotionData.toString());
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i == 0) {}
    }
    for (;;)
    {
      try
      {
        int j = paramToServiceMsg.extraData.getInt("fav_modify_emoid", -1);
        paramToServiceMsg = paramToServiceMsg.extraData.getString("fav_modify_word");
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramObject.uint32_result.get() != 0) {
          break label701;
        }
        i = 1;
        if (QLog.isColorLevel()) {
          QLog.d("FavEmoRoamingHandler", 1, "handleOcrModify pkg.uint32_result=" + paramObject.uint32_result.get());
        }
        Object localObject = new HashMap();
        if (i == 0) {
          break label707;
        }
        paramFromServiceMsg = "1";
        ((HashMap)localObject).put("param_succ_flag", paramFromServiceMsg);
        ((HashMap)localObject).put("param_version", Build.VERSION.SDK_INT + "");
        ((HashMap)localObject).put("param_resultCode", paramObject.uint32_result.get() + "");
        azmz.a(BaseApplication.getContext()).a(null, "favEmoModifyOcrsSuc", false, 0L, 0L, (HashMap)localObject, null);
        if ((i != 0) && (paramObject.bytes_bodybuffer.has()) && (paramObject.bytes_bodybuffer.get() != null))
        {
          paramFromServiceMsg = new FavEmotionOcr.RspBody();
          paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
          if (paramFromServiceMsg.int32_result.get() != 0) {
            continue;
          }
          paramFromServiceMsg = paramFromServiceMsg.list_modify_rsp.get();
          i = 0;
          if (i < paramFromServiceMsg.size())
          {
            if (QLog.isColorLevel()) {
              QLog.d("FavEmoRoamingHandler", 1, "handleOcrModify resModify.get(i).uint32_result=" + ((FavEmotionOcr.ModifyRsp)paramFromServiceMsg.get(i)).int32_result.get());
            }
            if (((FavEmotionOcr.ModifyRsp)paramFromServiceMsg.get(i)).int32_result.get() == 0)
            {
              paramObject = ((apke)this.app.getManager(149)).a();
              if (paramObject != null)
              {
                paramObject = paramObject.iterator();
                if (paramObject.hasNext())
                {
                  localObject = (CustomEmotionData)paramObject.next();
                  if (j != ((CustomEmotionData)localObject).emoId) {
                    continue;
                  }
                  ((CustomEmotionData)localObject).modifyWord = paramToServiceMsg;
                  notifyUI(3, true, localObject);
                }
              }
            }
            else
            {
              notifyUI(3, false, this.mApp.getApplication().getString(2131692120));
              if (QLog.isColorLevel()) {
                QLog.d("FavEmoRoamingHandler", 1, "handleOcrModify ret = " + ((FavEmotionOcr.ModifyRsp)paramFromServiceMsg.get(i)).int32_result.get());
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        notifyUI(3, false, this.mApp.getApplication().getString(2131692114));
        QLog.e("FavEmoRoamingHandler", 1, "func handleOcrModify ends, errInfo:" + paramFromServiceMsg.getMessage());
        return;
        notifyUI(3, false, this.mApp.getApplication().getString(2131692114));
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("FavEmoRoamingHandler", 1, "handleOcrModify ret = " + paramFromServiceMsg.int32_result.get());
        return;
      }
      catch (OutOfMemoryError paramFromServiceMsg)
      {
        notifyUI(3, false, this.mApp.getApplication().getString(2131692114));
        QLog.e("FavEmoRoamingHandler", 1, "handleOcrModify oom");
        return;
      }
      notifyUI(3, false, this.mApp.getApplication().getString(2131692114));
      QLog.e("FavEmoRoamingHandler", 1, "handleOcrModify error");
      return;
      i += 1;
      continue;
      i = 0;
      break;
      label701:
      i = 0;
      continue;
      label707:
      paramFromServiceMsg = "0";
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject, int paramInt)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i == 0) {}
    }
    for (;;)
    {
      int k;
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramObject.uint32_result.get() != 0) {
          break label838;
        }
        i = 1;
        if (QLog.isColorLevel()) {
          QLog.d("FavEmoRoamingHandler", 1, "handleOcrUpload pkg.uint32_result=" + paramObject.uint32_result.get());
        }
        Object localObject1 = new HashMap();
        if (i == 0) {
          break label844;
        }
        paramFromServiceMsg = "1";
        ((HashMap)localObject1).put("param_succ_flag", paramFromServiceMsg);
        ((HashMap)localObject1).put("param_cmd_type", paramInt + "");
        ((HashMap)localObject1).put("param_version", Build.VERSION.SDK_INT + "");
        ((HashMap)localObject1).put("param_resultCode", paramObject.uint32_result.get() + "");
        azmz.a(BaseApplication.getContext()).a(null, "favEmoGetOcrSuc", false, 0L, 0L, (HashMap)localObject1, null);
        if ((i != 0) && (paramObject.bytes_bodybuffer.has()) && (paramObject.bytes_bodybuffer.get() != null))
        {
          paramFromServiceMsg = new FavEmotionOcr.RspBody();
          paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
          if (!paramFromServiceMsg.list_ocr_info.has()) {
            break label850;
          }
          paramFromServiceMsg = paramFromServiceMsg.list_ocr_info.get();
          paramObject = (apke)this.app.getManager(149);
          localObject1 = paramObject.a();
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
          {
            i = 0;
            k = 0;
            if (k < paramFromServiceMsg.size())
            {
              int m = 0;
              FavEmotionOcr.OcrInfo localOcrInfo = (FavEmotionOcr.OcrInfo)paramFromServiceMsg.get(k);
              Object localObject2 = localOcrInfo.pic_info;
              String str = ((FavEmotionOcr.PicInfo)localObject2).string_pic_fileid.get();
              if ((paramInt == 3) && (QLog.isColorLevel())) {
                QLog.d("FavEmoRoamingHandler", 1, new Object[] { "handleOcrUpload words=", localOcrInfo.string_pic_ocr.get(), " md5=", ((FavEmotionOcr.PicInfo)localObject2).string_pic_md5.get(), " self_decs=", localOcrInfo.string_self_desc.get(), " resid=" + str });
              }
              localObject2 = paramObject.a((List)localObject1, str);
              if (localObject2 == null) {
                break label823;
              }
              int j = m;
              if (localOcrInfo.string_pic_ocr.get() != null) {
                if (((CustomEmotionData)localObject2).ocrWord != null)
                {
                  j = m;
                  if (((CustomEmotionData)localObject2).ocrWord.equals(localOcrInfo.string_pic_ocr.get())) {}
                }
                else
                {
                  m = 1;
                  ((CustomEmotionData)localObject2).ocrWord = localOcrInfo.string_pic_ocr.get();
                  j = m;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("FavEmoRoamingHandler", 1, "handleOcrUpload old ocrWord=" + ((CustomEmotionData)localObject2).ocrWord + " new ocrWord=" + localOcrInfo.string_pic_ocr.get());
                    j = m;
                  }
                }
              }
              m = j;
              if (localOcrInfo.string_self_desc.get() != null) {
                if (((CustomEmotionData)localObject2).modifyWord != null)
                {
                  m = j;
                  if (((CustomEmotionData)localObject2).modifyWord.equals(localOcrInfo.string_self_desc.get())) {}
                }
                else
                {
                  j = 1;
                  ((CustomEmotionData)localObject2).modifyWord = localOcrInfo.string_self_desc.get();
                  m = j;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("FavEmoRoamingHandler", 1, "handleOcrUpload old modifyWord=" + ((CustomEmotionData)localObject2).modifyWord + " new modifyWord=" + localOcrInfo.string_self_desc.get());
                    m = j;
                  }
                }
              }
              if (m == 0) {
                break label823;
              }
              paramObject.b((CustomEmotionBase)localObject2);
              i = 1;
              break label823;
            }
            if (i != 0) {
              agug.a(this.app).h();
            }
          }
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        QLog.e("FavEmoRoamingHandler", 1, "func handleOcrUpload ends, errInfo:" + paramFromServiceMsg.getMessage());
        return;
      }
      catch (OutOfMemoryError paramFromServiceMsg)
      {
        QLog.e("FavEmoRoamingHandler", 1, "handleOcrUpload oom");
        return;
      }
      QLog.e("FavEmoRoamingHandler", 1, "handleOcrUpload ");
      return;
      label823:
      k += 1;
      continue;
      i = 0;
      break;
      label838:
      i = 0;
      continue;
      label844:
      paramFromServiceMsg = "0";
      continue;
      label850:
      paramFromServiceMsg = null;
    }
  }
  
  public void a(Object paramObject)
  {
    faceroam_sso.RspBody localRspBody = new faceroam_sso.RspBody();
    long l;
    try
    {
      localRspBody.mergeFrom((byte[])paramObject);
      paramObject = (faceroam_sso.RspUserInfo)localRspBody.rspcmd_0x01.get();
      l = localRspBody.ret.get();
      if (l != 0L)
      {
        QLog.e("FavEmoRoamingHandler", 1, "handleUserInfoGet ret = " + l);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      QLog.e("FavEmoRoamingHandler", 1, "func handleUserInfoGet ends, errInfo:" + paramObject.getMessage());
      return;
    }
    catch (OutOfMemoryError paramObject)
    {
      QLog.e("FavEmoRoamingHandler", 1, "handleUserInfoGet oom");
      return;
    }
    ThreadManagerV2.excute(new FavEmoRoamingHandler.1(this, paramObject, l), 32, null, true);
  }
  
  public void a(Object paramObject, boolean paramBoolean)
  {
    int j = 0;
    faceroam_sso.RspBody localRspBody = new faceroam_sso.RspBody();
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        localRspBody.mergeFrom((byte[])paramObject);
        Object localObject = (faceroam_sso.RspDeleteItem)localRspBody.rspcmd_0x02.get();
        paramObject = ((faceroam_sso.RspDeleteItem)localObject).ret.get();
        localObject = ((faceroam_sso.RspDeleteItem)localObject).filename.get();
        localArrayList = new ArrayList();
        String str = localRspBody.errmsg.get();
        long l = localRspBody.ret.get();
        int k = localRspBody.sub_cmd.get();
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("FavEmoRoamingHandler", 2, " handle ResId=" + localObject + "errMsg=" + str + " ret=" + l + "subCmd=" + k);
          i = j;
        }
        if (i < ((List)localObject).size()) {
          if (((Long)paramObject.get(i)).longValue() == 0L)
          {
            localArrayList.add(((List)localObject).get(i));
            if (QLog.isColorLevel()) {
              QLog.d("FavEmoRoamingHandler", 2, " delSuccess ResId=" + (String)((List)localObject).get(i));
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("FavEmoRoamingHandler", 2, " delFail ResId=" + (String)((List)localObject).get(i) + "error code = " + paramObject.get(i));
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FavEmoRoamingHandler", 2, "func handleDelMessage ends, errInfo:" + paramObject.getMessage());
        }
        return;
      }
      ((apke)this.app.getManager(149)).c(localArrayList);
      super.notifyUI(0, true, Boolean.valueOf(paramBoolean));
      aube.d("0", 1);
      b(localArrayList);
      return;
      i += 1;
    }
  }
  
  public void a(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {}
    try
    {
      EmotionMove.PlatInfo localPlatInfo = new EmotionMove.PlatInfo();
      localPlatInfo.implat.set(109);
      localPlatInfo.mqqver.set("8.3.3");
      localPlatInfo.osver.set(Build.VERSION.RELEASE);
      EmotionMove.ReqBody localReqBody = new EmotionMove.ReqBody();
      localReqBody.msg_comm_info.set(localPlatInfo);
      localReqBody.str_req_filename.set(paramList);
      paramList = makeOIDBPkg("OidbSvc.0xdcf", 3535, 1, localReqBody.toByteArray());
      paramList.extraData.putInt("cmd_fav_subcmd", 6);
      super.sendPbReq(paramList);
      return;
    }
    catch (Exception paramList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FavEmoRoamingHandler", 2, "moveEmotion exception = " + paramList.getMessage());
    }
  }
  
  public void a(List<CustomEmotionData> paramList, int paramInt)
  {
    int j = 0;
    Object localObject = new ArrayList();
    FavEmotionOcr.ReqBody localReqBody = new FavEmotionOcr.ReqBody();
    int i = 0;
    while (i < paramList.size())
    {
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)paramList.get(i);
      if (!localCustomEmotionData.isMarkFace)
      {
        FavEmotionOcr.PicInfo localPicInfo = new FavEmotionOcr.PicInfo();
        localPicInfo.string_pic_md5.set(localCustomEmotionData.md5);
        localPicInfo.string_pic_fileid.set(localCustomEmotionData.resid);
        ((List)localObject).add(localPicInfo);
      }
      i += 1;
    }
    if (((List)localObject).size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FavEmoRoamingHandler", 2, "favEmoGetOcrs size=0");
      }
      return;
    }
    for (;;)
    {
      try
      {
        localReqBody.uint32_src_term.set(3);
        localReqBody.list_pic_info.set((List)localObject);
        localReqBody.uint32_cmd_type.set(paramInt);
        localReqBody.string_version.set("8.3.3");
        localObject = makeOIDBPkg("OidbSvc.0xdc4", 3524, 1, localReqBody.toByteArray());
        if (paramInt != 1) {
          break label335;
        }
        ((ToServiceMsg)localObject).extraData.putInt("cmd_fav_subcmd", 3);
        super.sendPbReq((ToServiceMsg)localObject);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("FavEmoRoamingHandler", 2, "favEmoGetOcrs error =" + localException.toString() + " cmdtype=" + paramInt + " size=" + paramList.size());
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      paramInt = j;
      while (paramInt < paramList.size())
      {
        QLog.d("FavEmoRoamingHandler", 2, "favEmoGetOcrs data i=" + paramInt + " :=" + paramList.get(paramInt));
        paramInt += 1;
      }
      break;
      label335:
      if (paramInt == 2) {
        localException.extraData.putInt("cmd_fav_subcmd", 4);
      }
    }
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    Object localObject = new faceroam_sso.ReqDeleteItem();
    ((faceroam_sso.ReqDeleteItem)localObject).filename.set(paramList);
    faceroam_sso.PlatInfo localPlatInfo = new faceroam_sso.PlatInfo();
    localPlatInfo.implat.set(109L);
    localPlatInfo.mqqver.set("8.3.3");
    localPlatInfo.osver.set(Build.VERSION.RELEASE);
    paramList = new faceroam_sso.ReqBody();
    paramList.uint32_sub_cmd.set(2);
    paramList.uint64_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    paramList.reqcmd_0x02.set((MessageMicro)localObject);
    paramList.comm.set(localPlatInfo);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "Faceroam.OpReq");
    ((ToServiceMsg)localObject).extraData.putInt("cmd_fav_subcmd", 2);
    ((ToServiceMsg)localObject).extraData.putBoolean("needSync", paramBoolean);
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(List<String> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        apkm localapkm = new apkm((String)paramList.next());
        if (!TextUtils.isEmpty(localapkm.d)) {
          localArrayList.add(localapkm.d);
        }
      }
      if (localArrayList.size() > 0) {
        ((apli)this.app.getManager(141)).a(localArrayList);
      }
    }
  }
  
  protected Class<? extends alkr> observerClass()
  {
    return alnn.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("cmd_fav_subcmd");
    if ((paramObject == null) || (paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
    {
      QLog.e("FavEmoRoamingHandler", 1, "fail to  not send command: " + i + " to server");
      if (i == 1)
      {
        paramToServiceMsg = (apkf)this.mApp.getManager(72);
        if (paramToServiceMsg != null) {
          paramToServiceMsg.a();
        }
      }
      else if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.isSuccess()))
      {
        if (i != 2) {
          break label123;
        }
        aube.d("2006", 1);
      }
    }
    label123:
    do
    {
      do
      {
        return;
        QLog.e("FavEmoRoamingHandler", 1, "getRoamingManager return null");
        break;
        if (i == 1)
        {
          aube.e("2005", 1);
          return;
        }
        if (i == 5)
        {
          notifyUI(3, false, this.mApp.getApplication().getString(2131692114));
          QLog.e("FavEmoRoamingHandler", 1, "modify ocr fail, errInfo:" + paramFromServiceMsg.getBusinessFailMsg());
          return;
        }
      } while (i != 6);
      if (QLog.isColorLevel()) {
        QLog.d("FavEmoRoamingHandler", 2, "onReceive FAV_REQ_MOVE fail！");
      }
      b(paramObject);
      return;
      switch (i)
      {
      default: 
        return;
      case 1: 
        a(paramObject);
        return;
      case 2: 
        a(paramObject, paramToServiceMsg.extraData.getBoolean("needSync"));
        return;
      case 3: 
        if (QLog.isColorLevel()) {
          QLog.d("FavEmoRoamingHandler", 1, "FAV_REQ_DO_OCR_WHEN_UPLOAD");
        }
        a(paramFromServiceMsg, paramObject, 3);
        return;
      case 4: 
        if (QLog.isColorLevel()) {
          QLog.d("FavEmoRoamingHandler", 1, "FAV_REQ_GET_OCR");
        }
        a(paramFromServiceMsg, paramObject, 4);
        return;
      case 5: 
        a(paramFromServiceMsg, paramToServiceMsg, paramObject);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FavEmoRoamingHandler", 2, "onReceive FAV_REQ_MOVE success！");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alnm
 * JD-Core Version:    0.7.0.1
 */