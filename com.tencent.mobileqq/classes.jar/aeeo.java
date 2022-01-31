import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.qphone.base.util.QLog;

class aeeo
  extends bbfq
{
  aeeo(aeeh paramaeeh) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onDownLoadedPluginResult result = " + paramInt);
    }
    if (paramInt == 0) {
      this.a.bu();
    }
    do
    {
      return;
      bbmy.a(this.a.a(), ajjy.a(2131639315), 0).a();
    } while (this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setProgress(0);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onNotifyGameRoomSpeakerStatus uin = " + paramLong2 + " isSeaking = " + paramBoolean);
    }
    if ((!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramLong1))) || (this.a.jdField_a_of_type_Bbfs == null)) {}
    bbfr localbbfr;
    do
    {
      return;
      localbbfr = this.a.jdField_a_of_type_Bbfs.a();
    } while (localbbfr == null);
    localbbfr.a(String.valueOf(paramLong2), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeeo
 * JD-Core Version:    0.7.0.1
 */