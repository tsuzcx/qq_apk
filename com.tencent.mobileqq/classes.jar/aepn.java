import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.qphone.base.util.QLog;

class aepn
  extends bciq
{
  aepn(aepg paramaepg) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onDownLoadedPluginResult result = " + paramInt);
    }
    if (paramInt == 0) {
      this.a.bw();
    }
    do
    {
      return;
      bcpw.a(this.a.a(), ajyc.a(2131705100), 0).a();
    } while (this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setProgress(0);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onNotifyGameRoomSpeakerStatus uin = " + paramLong2 + " isSeaking = " + paramBoolean);
    }
    if ((!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(paramLong1))) || (this.a.jdField_a_of_type_Bcis == null)) {}
    bcir localbcir;
    do
    {
      return;
      localbcir = this.a.jdField_a_of_type_Bcis.a();
    } while (localbcir == null);
    localbcir.a(String.valueOf(paramLong2), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aepn
 * JD-Core Version:    0.7.0.1
 */