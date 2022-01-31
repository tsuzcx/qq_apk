import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.binhai.BinHaiHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x98b.oidb_0x98b.JoinActivityReq;
import tencent.im.oidb.cmd0x98b.oidb_0x98b.LBSInfo;
import tencent.im.oidb.cmd0x98b.oidb_0x98b.ReqBody;

public class abrt
  extends SosoInterface.OnLocationListener
{
  public abrt(BinHaiHandler paramBinHaiHandler, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString1);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("BinHaiHandler", 2, "reqJoinActivity, errCode=" + paramInt + ", info=" + paramSosoLbsInfo);
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      oidb_0x98b.JoinActivityReq localJoinActivityReq = new oidb_0x98b.JoinActivityReq();
      localJoinActivityReq.bytes_pic_id.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
      BinHaiHandler.a = BinHaiHandler.a(paramSosoLbsInfo);
      if (BinHaiHandler.a == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiHandler.a(2, false, new Object[] { Integer.valueOf(-1), "定位失败，请开启定位权限。" });
        return;
      }
      paramSosoLbsInfo = new oidb_0x98b.ReqBody();
      paramSosoLbsInfo.msg_join_activity_req.set(localJoinActivityReq);
      paramSosoLbsInfo.msg_lbs_info.set(BinHaiHandler.a);
      paramSosoLbsInfo = this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiHandler.a("OidbSvc.0x98b", 2443, 2, paramSosoLbsInfo.toByteArray());
      paramSosoLbsInfo.addAttribute("action", Integer.valueOf(2));
      this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiHandler.b(paramSosoLbsInfo);
    }
    for (;;)
    {
      if (paramInt == 0) {
        bool = true;
      }
      BinHaiHandler.a("binhai_location", bool, paramInt, true);
      return;
      QLog.d("BinHaiHandler", 1, "location faild, err=" + paramInt);
      this.jdField_a_of_type_ComTencentMobileqqBinhaiBinHaiHandler.a(2, false, new Object[] { Integer.valueOf(-1), "定位失败，请开启定位权限。" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abrt
 * JD-Core Version:    0.7.0.1
 */