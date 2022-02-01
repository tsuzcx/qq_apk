import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class akgu
  extends anxg
{
  akgu(akgq paramakgq) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (!bgjw.a(paramString1, this.a.jdField_a_of_type_JavaLangString)));
      if (QLog.isColorLevel()) {
        QLog.i("TroopPhotoController", 2, String.format("onGetTroopAvatar result=%d", new Object[] { Integer.valueOf(paramInt1) }));
      }
    } while (paramInt1 != 0);
    this.a.a(true);
  }
  
  protected void b(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList)
  {
    if (!bgjw.a(paramString1, this.a.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopPhotoController", 2, String.format("onCmdTroopAvatar result=%d", new Object[] { Integer.valueOf(paramInt1) }));
    }
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgu
 * JD-Core Version:    0.7.0.1
 */