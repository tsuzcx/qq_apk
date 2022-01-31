import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class agqo
  extends akim
{
  agqo(agqk paramagqk) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!bbbd.a(paramString1, this.a.jdField_a_of_type_JavaLangString)));
      if (QLog.isColorLevel()) {
        QLog.i("TroopPhotoController", 2, String.format("onGetTroopAvatar result=%d", new Object[] { Integer.valueOf(paramInt1) }));
      }
    } while (paramInt1 != 0);
    this.a.a(true);
  }
  
  protected void b(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if (!bbbd.a(paramString1, this.a.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onCmdTroopAvatar result=%d", new Object[] { Integer.valueOf(paramInt1) }));
    }
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agqo
 * JD-Core Version:    0.7.0.1
 */