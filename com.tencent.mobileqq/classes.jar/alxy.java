import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecDatabaseMgr;
import com.tencent.qqprotect.qsec.QSecDatabaseMgr.LibEntry;
import com.tencent.qqprotect.qsec.QSecLibMgr;

public class alxy
{
  protected boolean a;
  
  private alxy(QSecLibMgr paramQSecLibMgr) {}
  
  public void a()
  {
    if (this.a) {
      QSecLibMgr.a(this.b).a();
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    QSecDatabaseMgr.LibEntry localLibEntry2;
    do
    {
      return;
      localLibEntry2 = QSecLibMgr.a(this.b).a(paramInt1);
    } while ((localLibEntry2 != null) && (paramString1.equals(localLibEntry2.jdField_b_of_type_JavaLangString)) && (paramString2.equals(localLibEntry2.jdField_a_of_type_JavaLangString)) && (paramInt2 == localLibEntry2.jdField_b_of_type_Int) && (paramInt3 == localLibEntry2.c));
    QSecDatabaseMgr.LibEntry localLibEntry1;
    if (localLibEntry2 == null) {
      localLibEntry1 = new QSecDatabaseMgr.LibEntry();
    }
    for (;;)
    {
      localLibEntry1.jdField_a_of_type_Int = paramInt1;
      localLibEntry1.jdField_b_of_type_Int = paramInt2;
      localLibEntry1.c = paramInt3;
      localLibEntry1.jdField_b_of_type_JavaLangString = paramString1;
      localLibEntry1.jdField_a_of_type_JavaLangString = paramString2;
      if (QLog.isColorLevel()) {
        QLog.d("QQProtect.QSec", 2, String.format("Add lost lib: %d,%d,%d,%s", new Object[] { Integer.valueOf(localLibEntry1.jdField_a_of_type_Int), Integer.valueOf(localLibEntry1.jdField_b_of_type_Int), Integer.valueOf(localLibEntry1.c), localLibEntry1.jdField_b_of_type_JavaLangString }));
      }
      QSecLibMgr.a(this.b).a(localLibEntry1, false);
      this.a = true;
      return;
      QSecLibMgr.a(this.b).a(paramInt1, false);
      localLibEntry1 = localLibEntry2;
      if (QLog.isColorLevel())
      {
        QLog.d("QQProtect.QSec", 2, String.format("Database info mismatch for lib: %d", new Object[] { Integer.valueOf(paramInt1) }));
        localLibEntry1 = localLibEntry2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alxy
 * JD-Core Version:    0.7.0.1
 */