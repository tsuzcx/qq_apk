import com.tencent.mobileqq.nearby.now.protocol.CsTask.OnCsError;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentProtocol.GetMomentListCallback;
import com.tencent.qphone.base.util.QLog;

public final class aflq
  implements CsTask.OnCsError
{
  public aflq(NearbyMomentProtocol.GetMomentListCallback paramGetMomentListCallback, int paramInt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    QLog.i("NearbyMomentProtocol", 1, "getMomentList, 0xada_0 errorCode=" + paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentProtocol$GetMomentListCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentProtocol$GetMomentListCallback.a(false, null, true, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aflq
 * JD-Core Version:    0.7.0.1
 */