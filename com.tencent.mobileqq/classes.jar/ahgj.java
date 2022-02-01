import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ahgj
  extends bhap
{
  ahgj(ahgc paramahgc) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "onDownLoadedPluginResult result = " + paramInt);
    }
    if (paramInt == 0) {
      this.a.j();
    }
    do
    {
      return;
      QQToast.a(this.a.getActivity(), amtj.a(2131704227), 0).a();
    } while (this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setProgress(0);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.tag, 2, "onNotifyGameRoomSpeakerStatus uin = " + paramLong2 + " isSeaking = " + paramBoolean);
    }
    if ((!this.a.sessionInfo.curFriendUin.equals(String.valueOf(paramLong1))) || (this.a.jdField_a_of_type_Bhar == null)) {}
    bhaq localbhaq;
    do
    {
      return;
      localbhaq = this.a.jdField_a_of_type_Bhar.a();
    } while (localbhaq == null);
    localbhaq.a(String.valueOf(paramLong2), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahgj
 * JD-Core Version:    0.7.0.1
 */