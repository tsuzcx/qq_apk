import android.os.Bundle;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler.1;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
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
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.selfgif.CameraEmotionRoaming_sso.DelReq;
import tencent.im.selfgif.CameraEmotionRoaming_sso.DelRet;
import tencent.im.selfgif.CameraEmotionRoaming_sso.DelRsp;
import tencent.im.selfgif.CameraEmotionRoaming_sso.GetListReq;
import tencent.im.selfgif.CameraEmotionRoaming_sso.GetListRsp;
import tencent.im.selfgif.CameraEmotionRoaming_sso.ImgInfo;
import tencent.im.selfgif.CameraEmotionRoaming_sso.ReqBody;
import tencent.im.selfgif.CameraEmotionRoaming_sso.RspBody;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadReq;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadRsp;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadState;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadStateReq;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadStateRet;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UpLoadStateRsp;
import tencent.im.selfgif.CameraEmotionRoaming_sso.UploadImgInfo;

public class ajtf
  extends ajul<CameraEmotionData>
{
  private ConcurrentHashMap<Integer, CameraEmotionData> a = new ConcurrentHashMap();
  
  public ajtf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = paramToServiceMsg.extraData.getInt("camera_emo_upload_id");
    QLog.d("CameraEmoRoamingHandler", 1, new Object[] { "timtest handlePrepareUploadInfo start, ", Integer.valueOf(j) });
    CameraEmotionData localCameraEmotionData = (CameraEmotionData)this.a.get(Integer.valueOf(j));
    if ((paramObject == null) || (paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
    {
      paramObject = new StringBuilder().append("fail to  handlePrepareUploadInfo error code is ");
      if (paramFromServiceMsg == null) {}
      for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.getResultCode()))
      {
        QLog.e("CameraEmoRoamingHandler", 1, paramToServiceMsg);
        a(1, false, Integer.valueOf(12), localCameraEmotionData);
        this.a.remove(Integer.valueOf(j));
        return;
      }
    }
    paramToServiceMsg = new CameraEmotionRoaming_sso.RspBody();
    for (;;)
    {
      int i;
      boolean bool;
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = paramToServiceMsg.bytes_fail_msg.get().toStringUtf8();
        if (!paramToServiceMsg.upLoad_rsp.has()) {
          break label575;
        }
        paramToServiceMsg = (CameraEmotionRoaming_sso.UpLoadRsp)paramToServiceMsg.upLoad_rsp.get();
        i = paramToServiceMsg.int32_is_upload.get();
        if (i == 0)
        {
          localCameraEmotionData.resid = paramToServiceMsg.bytes_resource_id.get().toStringUtf8();
          QLog.d("CameraEmoRoamingHandler", 1, "timtest handlePrepareUploadInfo success md5 = " + localCameraEmotionData.md5 + "| resid=" + localCameraEmotionData.resid + " | msg = " + paramFromServiceMsg);
          ((anrx)this.app.getManager(334)).a(localCameraEmotionData);
          paramObject = new HashMap();
          if (i != 0) {
            break label632;
          }
          paramToServiceMsg = "1";
          paramObject.put("sucFlag", paramToServiceMsg);
          paramObject.put("retCode", String.valueOf(i));
          if (paramFromServiceMsg != null) {
            break label638;
          }
          paramToServiceMsg = "";
          paramObject.put("errMsg", paramToServiceMsg);
          paramToServiceMsg = axrn.a(BaseApplication.getContext());
          if (i != 0) {
            break label643;
          }
          bool = true;
          paramToServiceMsg.a(null, "CamEmoPrepareUpload", bool, 0L, 0L, paramObject, null);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        QLog.e("CameraEmoRoamingHandler", 1, "func handlePrepareUploadInfo ends, errInfo:" + paramToServiceMsg.getMessage());
        a(1, false, Integer.valueOf(100), localCameraEmotionData);
        this.a.remove(Integer.valueOf(j));
        return;
      }
      catch (OutOfMemoryError paramToServiceMsg)
      {
        QLog.e("CameraEmoRoamingHandler", 1, "handlePrepareUploadInfo oom");
        a(1, false, Integer.valueOf(100), localCameraEmotionData);
        this.a.remove(Integer.valueOf(j));
        return;
      }
      if (i == 1)
      {
        a(1, false, Integer.valueOf(2), localCameraEmotionData);
        this.a.remove(Integer.valueOf(j));
        QLog.e("CameraEmoRoamingHandler", 1, "func handlePrepareUploadInfo fail, nCanupload:" + i);
      }
      else
      {
        a(1, false, Integer.valueOf(13), localCameraEmotionData);
        this.a.remove(Integer.valueOf(j));
        QLog.e("CameraEmoRoamingHandler", 1, "func handlePrepareUploadInfo fail, nCanupload:" + i);
        continue;
        label575:
        QLog.d("CameraEmoRoamingHandler", 1, "timtest handlePrepareUploadInfo end rspBody.upLoad_rsp no value msg = " + paramFromServiceMsg);
        a(1, false, Integer.valueOf(13), localCameraEmotionData);
        this.a.remove(Integer.valueOf(j));
        i = -1;
        continue;
        label632:
        paramToServiceMsg = "0";
        continue;
        label638:
        paramToServiceMsg = paramFromServiceMsg;
        continue;
        label643:
        bool = false;
      }
    }
  }
  
  private void a(List<CameraEmotionRoaming_sso.ImgInfo> paramList, List<ajtg> paramList1, List<String> paramList2)
  {
    if ((paramList == null) || (paramList1 == null) || (paramList2 == null))
    {
      QLog.e("CameraEmoRoamingHandler", 1, "readSSoImgInfoList param error");
      return;
    }
    Iterator localIterator = paramList.iterator();
    label29:
    String str4;
    String str1;
    String str2;
    String str3;
    ajtg localajtg;
    while (localIterator.hasNext())
    {
      paramList = (CameraEmotionRoaming_sso.ImgInfo)localIterator.next();
      str4 = paramList.bytes_resource_id.get().toStringUtf8();
      str1 = ((ByteStringMicro)paramList.bytes_text.get(0)).toStringUtf8();
      str2 = paramList.url.get().toStringUtf8();
      str3 = paramList.bytes_md5.get().toStringUtf8();
      if (!bbkk.a(str4))
      {
        localajtg = new ajtg();
        localajtg.a = str4;
        if (str1 != null) {
          break label227;
        }
        paramList = "";
        label134:
        localajtg.b = paramList;
        if (str2 != null) {
          break label233;
        }
        paramList = "";
        label148:
        localajtg.c = paramList;
        if (str3 != null) {
          break label239;
        }
      }
    }
    label227:
    label233:
    label239:
    for (paramList = "";; paramList = str3)
    {
      localajtg.d = paramList;
      QLog.e("CameraEmoRoamingHandler", 1, "readSSoImgInfoList get CameraEmoImg content = " + str1 + "| url = " + str2);
      paramList2.add(str4);
      paramList1.add(localajtg);
      break label29;
      break;
      paramList = str1;
      break label134;
      paramList = str2;
      break label148;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = true;
    QLog.d("CameraEmoRoamingHandler", 1, "timtest handleNotifyServerUploadStatus start");
    int i = paramToServiceMsg.extraData.getInt("camera_emo_upload_id");
    CameraEmotionData localCameraEmotionData = (CameraEmotionData)this.a.get(Integer.valueOf(i));
    if ((paramObject == null) || (paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
    {
      paramObject = new StringBuilder().append("fail to  handlePrepareUploadInfo error code is ");
      if (paramFromServiceMsg == null) {}
      for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.getResultCode()))
      {
        QLog.e("CameraEmoRoamingHandler", 1, paramToServiceMsg);
        a(1, false, Integer.valueOf(12), localCameraEmotionData);
        this.a.remove(Integer.valueOf(i));
        return;
      }
    }
    paramToServiceMsg = new CameraEmotionRoaming_sso.RspBody();
    for (;;)
    {
      int j;
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = (CameraEmotionRoaming_sso.UpLoadStateRet)((CameraEmotionRoaming_sso.UpLoadStateRsp)paramToServiceMsg.upLoad_state_rsp.get()).upload_state_ret.get(0);
        j = paramToServiceMsg.int32_upload_state_ret.get();
        if (j == 0)
        {
          localCameraEmotionData.url = paramToServiceMsg.img_info.url.get().toStringUtf8();
          a(1, true, Integer.valueOf(0), localCameraEmotionData);
          this.a.remove(Integer.valueOf(i));
          QLog.e("CameraEmoRoamingHandler", 1, "func handleNotifyServerUploadStatus suc");
          paramFromServiceMsg = new HashMap();
          if (j != 0) {
            break label444;
          }
          paramToServiceMsg = "1";
          paramFromServiceMsg.put("sucFlag", paramToServiceMsg);
          paramFromServiceMsg.put("retCode", String.valueOf(j));
          paramToServiceMsg = axrn.a(BaseApplication.getContext());
          if (j != 0) {
            break label450;
          }
          paramToServiceMsg.a(null, "CamEmoUpdateStat", bool, 0L, 0L, paramFromServiceMsg, null);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        QLog.e("CameraEmoRoamingHandler", 1, "func handleNotifyServerUploadStatus ends, errInfo:" + paramToServiceMsg.getMessage());
        a(1, false, Integer.valueOf(100), localCameraEmotionData);
        this.a.remove(Integer.valueOf(i));
        return;
      }
      catch (OutOfMemoryError paramToServiceMsg)
      {
        QLog.e("CameraEmoRoamingHandler", 1, "handleNotifyServerUploadStatus oom");
        a(1, false, Integer.valueOf(100), localCameraEmotionData);
        this.a.remove(Integer.valueOf(i));
        return;
      }
      a(1, false, Integer.valueOf(13), localCameraEmotionData);
      this.a.remove(Integer.valueOf(i));
      QLog.e("CameraEmoRoamingHandler", 1, new Object[] { "func handleNotifyServerUploadStatus fail, result:", Integer.valueOf(j) });
      continue;
      label444:
      paramToServiceMsg = "0";
      continue;
      label450:
      bool = false;
    }
  }
  
  public void a()
  {
    QLog.d("CameraEmoRoamingHandler", 1, "timtest queryUserEmoRoamingReq start");
    String str = ((anrx)this.app.getManager(334)).a();
    Object localObject = new CameraEmotionRoaming_sso.GetListReq();
    ((CameraEmotionRoaming_sso.GetListReq)localObject).client_timestamp_version.set(ByteStringMicro.copyFrom(str.getBytes()));
    CameraEmotionRoaming_sso.ReqBody localReqBody = new CameraEmotionRoaming_sso.ReqBody();
    localReqBody.uint64_src_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    localReqBody.uint32_cmd_type.set(3);
    localReqBody.uint32_src_term.set(3);
    localReqBody.bytes_version.set(ByteStringMicro.copyFrom("8.3.0".getBytes()));
    localReqBody.get_list_req.set((MessageMicro)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "SelfGif.Op");
    ((ToServiceMsg)localObject).extraData.putInt("cmd_camera_emo_subcmd", 3);
    ((ToServiceMsg)localObject).extraData.putString("cmd_param_data_version", str);
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public final void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    notifyUI(paramInt1, paramBoolean, Integer.valueOf(paramInt2), false);
  }
  
  public final void a(int paramInt, boolean paramBoolean, Object paramObject, CameraEmotionData paramCameraEmotionData)
  {
    notifyUI(paramInt, paramBoolean, new Object[] { paramObject, paramCameraEmotionData }, false);
  }
  
  public void a(CameraEmotionData paramCameraEmotionData, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramCameraEmotionData == null)
    {
      QLog.d("CameraEmoRoamingHandler", 1, "timtest prepareUploadEmoReq start, data is null");
      a(1, false, Integer.valueOf(10), paramCameraEmotionData);
      return;
    }
    QLog.d("CameraEmoRoamingHandler", 1, new Object[] { "timtest prepareUploadEmoReq start, md5:", paramCameraEmotionData.md5, ", size:", Long.valueOf(paramLong), ", emoId:", Integer.valueOf(paramCameraEmotionData.emoId) });
    this.a.put(Integer.valueOf(paramCameraEmotionData.emoId), paramCameraEmotionData);
    Object localObject1 = new CameraEmotionRoaming_sso.UpLoadReq();
    Object localObject2 = new CameraEmotionRoaming_sso.UploadImgInfo();
    ((CameraEmotionRoaming_sso.UploadImgInfo)localObject2).bytes_img_md5.set(ByteStringMicro.copyFrom(paramCameraEmotionData.md5.getBytes()));
    ((CameraEmotionRoaming_sso.UploadImgInfo)localObject2).uint32_img_height.set(paramInt2);
    ((CameraEmotionRoaming_sso.UploadImgInfo)localObject2).uint32_img_width.set(paramInt1);
    ((CameraEmotionRoaming_sso.UploadImgInfo)localObject2).uint64_img_size.set(paramLong);
    ((CameraEmotionRoaming_sso.UpLoadReq)localObject1).img_info.set((MessageMicro)localObject2);
    localObject2 = new CameraEmotionRoaming_sso.ReqBody();
    ((CameraEmotionRoaming_sso.ReqBody)localObject2).uint64_src_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    ((CameraEmotionRoaming_sso.ReqBody)localObject2).uint32_cmd_type.set(1);
    ((CameraEmotionRoaming_sso.ReqBody)localObject2).uint32_src_term.set(3);
    ((CameraEmotionRoaming_sso.ReqBody)localObject2).bytes_version.set(ByteStringMicro.copyFrom("8.3.0".getBytes()));
    ((CameraEmotionRoaming_sso.ReqBody)localObject2).upLoad_req.set((MessageMicro)localObject1);
    localObject1 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "SelfGif.Op");
    ((ToServiceMsg)localObject1).extraData.putInt("cmd_camera_emo_subcmd", 1);
    ((ToServiceMsg)localObject1).extraData.putInt("camera_emo_upload_id", paramCameraEmotionData.emoId);
    ((ToServiceMsg)localObject1).putWupBuffer(((CameraEmotionRoaming_sso.ReqBody)localObject2).toByteArray());
    super.sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(CameraEmotionData paramCameraEmotionData, boolean paramBoolean)
  {
    if (paramCameraEmotionData == null)
    {
      QLog.d("CameraEmoRoamingHandler", 1, "timtest notifyServerUploadStatusReq start, data is null");
      a(1, false, Integer.valueOf(10), paramCameraEmotionData);
      return;
    }
    if (!bbfj.d(BaseApplication.getContext()))
    {
      QLog.d("CameraEmoRoamingHandler", 1, "timtest notifyServerUploadStatusReq start, net not support");
      a(1, false, Integer.valueOf(12), paramCameraEmotionData);
      return;
    }
    QLog.d("CameraEmoRoamingHandler", 1, "timtest notifyServerUploadStatusReq start");
    Object localObject2 = new CameraEmotionRoaming_sso.UpLoadStateReq();
    CameraEmotionRoaming_sso.UpLoadState localUpLoadState = new CameraEmotionRoaming_sso.UpLoadState();
    localUpLoadState.bytes_resource_id.set(ByteStringMicro.copyFrom(paramCameraEmotionData.resid.getBytes()));
    PBRepeatField localPBRepeatField = localUpLoadState.bytes_text;
    Object localObject1;
    if (paramCameraEmotionData.strContext == null)
    {
      localObject1 = "";
      localPBRepeatField.add(ByteStringMicro.copyFrom(((String)localObject1).getBytes()));
      localObject1 = localUpLoadState.int32_upload_state;
      if (!paramBoolean) {
        break label308;
      }
    }
    label308:
    for (int i = 0;; i = 1)
    {
      ((PBInt32Field)localObject1).set(i);
      ((CameraEmotionRoaming_sso.UpLoadStateReq)localObject2).upload_state.add(localUpLoadState);
      localObject1 = new CameraEmotionRoaming_sso.ReqBody();
      ((CameraEmotionRoaming_sso.ReqBody)localObject1).uint64_src_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
      ((CameraEmotionRoaming_sso.ReqBody)localObject1).uint32_cmd_type.set(2);
      ((CameraEmotionRoaming_sso.ReqBody)localObject1).uint32_src_term.set(3);
      ((CameraEmotionRoaming_sso.ReqBody)localObject1).bytes_version.set(ByteStringMicro.copyFrom("8.3.0".getBytes()));
      ((CameraEmotionRoaming_sso.ReqBody)localObject1).upLoad_state_req.set((MessageMicro)localObject2);
      localObject2 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "SelfGif.Op");
      ((ToServiceMsg)localObject2).extraData.putInt("cmd_camera_emo_subcmd", 2);
      ((ToServiceMsg)localObject2).extraData.putInt("camera_emo_upload_id", paramCameraEmotionData.emoId);
      ((ToServiceMsg)localObject2).putWupBuffer(((CameraEmotionRoaming_sso.ReqBody)localObject1).toByteArray());
      super.sendPbReq((ToServiceMsg)localObject2);
      return;
      localObject1 = paramCameraEmotionData.strContext;
      break;
    }
  }
  
  protected void a(Object paramObject, String paramString)
  {
    QLog.d("CameraEmoRoamingHandler", 1, "timtest handleUserInfoGet start");
    Object localObject = new CameraEmotionRoaming_sso.RspBody();
    try
    {
      ((CameraEmotionRoaming_sso.RspBody)localObject).mergeFrom((byte[])paramObject);
      ((CameraEmotionRoaming_sso.RspBody)localObject).bytes_fail_msg.get().toStringUtf8();
      if (((CameraEmotionRoaming_sso.RspBody)localObject).get_list_rsp.has())
      {
        paramObject = (CameraEmotionRoaming_sso.GetListRsp)((CameraEmotionRoaming_sso.RspBody)localObject).get_list_rsp.get();
        localObject = paramObject.server_timestamp_version.get().toStringUtf8();
        if (paramString.equals(localObject))
        {
          QLog.d("CameraEmoRoamingHandler", 1, "timtest handleUserInfoGet same version = " + (String)localObject);
          a(2, true, 0);
        }
      }
      else
      {
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      QLog.e("CameraEmoRoamingHandler", 1, "func handleUserInfoGet ends, errInfo:" + paramObject.getMessage());
      return;
    }
    catch (OutOfMemoryError paramObject)
    {
      QLog.e("CameraEmoRoamingHandler", 1, "handleUserInfoGet oom");
      return;
    }
    paramString = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if (paramObject.rpt_img_info.has()) {
      a(paramObject.rpt_img_info.get(), paramString, localArrayList);
    }
    QLog.d("CameraEmoRoamingHandler", 1, "timtest handleUserInfoGet cameraEmoImgs.size = " + paramString.size());
    ThreadManagerV2.excute(new CameraEmoRoamingHandler.2(this, (String)localObject, paramString, localArrayList), 32, null, true);
  }
  
  protected void a(Object paramObject, boolean paramBoolean)
  {
    QLog.d("CameraEmoRoamingHandler", 1, "timtest handleDelMessage start ");
    Object localObject1 = new CameraEmotionRoaming_sso.RspBody();
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    try
    {
      ((CameraEmotionRoaming_sso.RspBody)localObject1).mergeFrom((byte[])paramObject);
      ((CameraEmotionRoaming_sso.RspBody)localObject1).bytes_fail_msg.get().toStringUtf8();
      if (((CameraEmotionRoaming_sso.RspBody)localObject1).del_rsp.has())
      {
        Object localObject2 = (CameraEmotionRoaming_sso.DelRsp)((CameraEmotionRoaming_sso.RspBody)localObject1).del_rsp.get();
        paramObject = ((CameraEmotionRoaming_sso.DelRsp)localObject2).client_timestamp_version.get().toStringUtf8();
        localObject1 = new ArrayList();
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        if (((CameraEmotionRoaming_sso.DelRsp)localObject2).rpt_img_info.has()) {
          a(((CameraEmotionRoaming_sso.DelRsp)localObject2).rpt_img_info.get(), (List)localObject1, localArrayList2);
        }
        if (!((CameraEmotionRoaming_sso.DelRsp)localObject2).del_ret.has()) {
          break label249;
        }
        localObject2 = ((CameraEmotionRoaming_sso.DelRsp)localObject2).del_ret.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          CameraEmotionRoaming_sso.DelRet localDelRet = (CameraEmotionRoaming_sso.DelRet)((Iterator)localObject2).next();
          if (localDelRet.int32_del_ret.get() == 0) {
            localArrayList1.add(localDelRet.bytes_resource_id.get().toStringUtf8());
          }
        }
      }
      QLog.d("CameraEmoRoamingHandler", 1, "timtest handleDelMessage delResIDList.size = " + localArrayList1.size() + "| cameraEmoImgs.size = " + ((List)localObject1).size());
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      QLog.e("CameraEmoRoamingHandler", 1, "func handleDelMessage ends, errInfo:" + paramObject.getMessage());
      return;
    }
    catch (OutOfMemoryError paramObject)
    {
      QLog.e("CameraEmoRoamingHandler", 1, "handleDelMessage oom");
      return;
    }
    label249:
    ThreadManagerV2.excute(new CameraEmoRoamingHandler.1(this, paramObject, (List)localObject1, localArrayList2, localArrayList1), 32, null, true);
  }
  
  public void a(List<String> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    QLog.d("CameraEmoRoamingHandler", 1, "timtest delUserEmoRoamingReq start size = " + paramList.size());
    Object localObject = new CameraEmotionRoaming_sso.DelReq();
    int i = 0;
    if (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      if (str == null) {}
      for (;;)
      {
        i += 1;
        break;
        ((CameraEmotionRoaming_sso.DelReq)localObject).bytes_resource_id.get().add(ByteStringMicro.copyFrom(str.getBytes()));
      }
    }
    paramList = new CameraEmotionRoaming_sso.ReqBody();
    paramList.uint64_src_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    paramList.uint32_cmd_type.set(4);
    paramList.uint32_src_term.set(3);
    paramList.bytes_version.set(ByteStringMicro.copyFrom("8.3.0".getBytes()));
    paramList.del_req.set((MessageMicro)localObject);
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "SelfGif.Op");
    ((ToServiceMsg)localObject).extraData.putInt("cmd_camera_emo_subcmd", 4);
    ((ToServiceMsg)localObject).extraData.putBoolean("cmd_param_need_sync", paramBoolean);
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  protected Class<? extends ajte> observerClass()
  {
    return ajth.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null)
    {
      QLog.e("CameraEmoRoamingHandler", 1, "timtest onReceive error : ToServiceMsg is null");
      return;
    }
    QLog.d("CameraEmoRoamingHandler", 1, "timtest onReceive start");
    switch (paramToServiceMsg.extraData.getInt("cmd_camera_emo_subcmd"))
    {
    default: 
      return;
    case 1: 
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    case 2: 
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    case 3: 
      if ((paramObject == null) || (paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
      {
        paramObject = new StringBuilder().append("fail to  handleUserInfoGet error code is ");
        if (paramFromServiceMsg == null) {}
        for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.getResultCode()))
        {
          QLog.e("CameraEmoRoamingHandler", 1, paramToServiceMsg);
          if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isSuccess())) {
            break;
          }
          askf.e(String.valueOf(paramFromServiceMsg.getResultCode()), 2);
          return;
        }
        askf.d("3002", 2);
        return;
      }
      a(paramObject, paramToServiceMsg.extraData.getString("cmd_param_data_version", ""));
      return;
    }
    if ((paramObject == null) || (paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()))
    {
      paramObject = new StringBuilder().append("fail to  handleDelMessage error code is ");
      if (paramFromServiceMsg == null) {}
      for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramFromServiceMsg.getResultCode()))
      {
        QLog.e("CameraEmoRoamingHandler", 1, paramToServiceMsg);
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isSuccess())) {
          break;
        }
        askf.d(String.valueOf(paramFromServiceMsg.getResultCode()), 2);
        return;
      }
      askf.d("3003", 2);
      return;
    }
    a(paramObject, paramToServiceMsg.extraData.getBoolean("cmd_param_need_sync"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajtf
 * JD-Core Version:    0.7.0.1
 */