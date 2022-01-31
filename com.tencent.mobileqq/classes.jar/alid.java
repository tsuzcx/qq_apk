import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecCbMgr;
import com.tencent.qqprotect.qsec.QSecDatabaseMgr;
import com.tencent.qqprotect.qsec.QSecDatabaseMgr.LibEntry;
import com.tencent.qqprotect.qsec.QSecLibMgr;
import java.util.concurrent.ConcurrentHashMap;

public class alid
  extends alii
{
  private boolean b;
  
  public alid(QSecLibMgr paramQSecLibMgr)
  {
    super(paramQSecLibMgr, null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      QSecLibMgr.a(this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr).a();
    }
    if (this.b) {
      QSecLibMgr.d(this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      if ((paramInt4 == 1) || (paramInt4 == 2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQProtect.QSec", 2, String.format("Invalid mode: %d", new Object[] { Integer.valueOf(paramInt4) }));
    return;
    QSecDatabaseMgr.LibEntry localLibEntry = QSecLibMgr.a(this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr).a(paramInt1);
    if (localLibEntry != null) {
      QSecLibMgr.a(this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr).a(localLibEntry.jdField_a_of_type_Int, false);
    }
    for (;;)
    {
      localLibEntry.jdField_a_of_type_Int = paramInt1;
      localLibEntry.jdField_b_of_type_Int = paramInt2;
      localLibEntry.c = paramInt3;
      localLibEntry.jdField_b_of_type_JavaLangString = paramString1;
      localLibEntry.jdField_a_of_type_JavaLangString = paramString2;
      QSecLibMgr.a(this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr).a(localLibEntry, false);
      this.jdField_a_of_type_Boolean = true;
      if ((paramInt4 != 1) || (QSecLibMgr.a(this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr).a(paramInt1) != 1)) {
        break;
      }
      this.b = true;
      alif localalif = (alif)QSecLibMgr.a(this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr).get(Integer.valueOf(paramInt1));
      if (localalif == null) {
        break label236;
      }
      QSecLibMgr.a(this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr, localalif, paramString2, paramString1);
      if (localalif.d == 0) {
        break;
      }
      QSecLibMgr.a(this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr).remove(Integer.valueOf(localalif.jdField_a_of_type_Int));
      return;
      localLibEntry = new QSecDatabaseMgr.LibEntry();
    }
    label236:
    paramString1 = QSecLibMgr.a(this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr, localLibEntry);
    QSecLibMgr.a(this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alid
 * JD-Core Version:    0.7.0.1
 */