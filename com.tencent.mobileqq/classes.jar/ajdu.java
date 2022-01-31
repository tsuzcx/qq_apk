import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ajdu
  implements Handler.Callback
{
  protected int a;
  private long jdField_a_of_type_Long;
  protected ajdw a;
  protected ajdx a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private befq jdField_a_of_type_Befq = new befq(Looper.getMainLooper(), this);
  String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  
  public ajdu(ajdw paramajdw, ajdx paramajdx)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Ajdw = paramajdw;
    this.jdField_a_of_type_Ajdx = paramajdx;
  }
  
  private void a(boolean paramBoolean, File paramFile, String paramString)
  {
    int i = 0;
    if (paramBoolean) {}
    try
    {
      a(paramFile, paramString);
      this.jdField_a_of_type_ArrayOfJavaLangString = new File(paramString).list();
      this.jdField_a_of_type_Int = 3;
      if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0)) {
        while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
        {
          this.jdField_a_of_type_ArrayOfJavaLangString[i] = (paramString + this.jdField_a_of_type_ArrayOfJavaLangString[i]);
          i += 1;
        }
      }
      if (this.jdField_a_of_type_Boolean)
      {
        b();
        if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
        {
          this.jdField_c_of_type_Int = 0;
          this.jdField_b_of_type_Boolean = true;
          new ajdv(this, 0).execute(new Integer[] { Integer.valueOf(this.jdField_c_of_type_Int) });
        }
      }
      return;
    }
    catch (Exception paramFile)
    {
      QLog.e("SimpleFrameZipDecoder", 2, paramFile.getMessage());
      this.jdField_a_of_type_Int = 2;
      return;
    }
    catch (OutOfMemoryError paramFile)
    {
      QLog.e("SimpleFrameZipDecoder", 2, paramFile.getMessage());
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 3) {
      b();
    }
    try
    {
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
      {
        this.jdField_c_of_type_Int = 0;
        this.jdField_b_of_type_Boolean = true;
        new ajdv(this, 0).execute(new Integer[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SimpleFrameZipDecoder", 2, localException, new Object[0]);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return;
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (!paramString2.equals(this.jdField_b_of_type_JavaLangString))
      {
        this.jdField_b_of_type_JavaLangString = paramString2;
        this.jdField_a_of_type_Int = 0;
        b();
        this.jdField_a_of_type_ArrayOfJavaLangString = null;
      }
    } while ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 0));
    paramString2 = b(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_JavaLangString = paramString2;
    Object localObject = new File(paramString2);
    ((File)localObject).mkdirs();
    localObject = ((File)localObject).list();
    File localFile = new File(this.jdField_b_of_type_JavaLangString);
    if ((localObject != null) && (localObject.length > 0))
    {
      a(false, localFile, paramString2);
      return;
    }
    if (localFile.exists())
    {
      a(true, localFile, paramString2);
      return;
    }
    if (this.jdField_a_of_type_Ajdw != null)
    {
      this.jdField_a_of_type_Ajdw.a(this, paramString1, this.jdField_b_of_type_JavaLangString, paramString2);
      return;
    }
    this.jdField_a_of_type_Int = 2;
  }
  
  public void a(Bitmap paramBitmap, int paramInt)
  {
    long l2;
    if ((this.jdField_b_of_type_Boolean) && (paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      long l1 = System.currentTimeMillis();
      l2 = l1 - this.jdField_a_of_type_Long;
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      if (l2 <= this.jdField_b_of_type_Int) {
        break label77;
      }
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Befq.obtainMessage(255, this.jdField_c_of_type_Int, 0).sendToTarget();
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = (paramInt + 1);
      return;
      label77:
      paramBitmap = this.jdField_a_of_type_Befq.obtainMessage(255, this.jdField_c_of_type_Int, 0);
      this.jdField_a_of_type_Befq.sendMessageDelayed(paramBitmap, this.jdField_b_of_type_Int - l2);
    }
  }
  
  protected void a(File paramFile, String paramString)
  {
    if ((paramFile.exists()) && (!TextUtils.isEmpty(paramString))) {
      mpx.a(paramFile, paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SimpleFrameZipDecoder", 2, "onDownloadFinish，result:" + paramBoolean + " url:" + paramString1 + " zipFile:" + paramString2 + " folder:" + paramString3);
    }
    if ((this.jdField_b_of_type_JavaLangString != null) && (!this.jdField_b_of_type_JavaLangString.equals(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SimpleFrameZipDecoder", 2, "onDownloadFinish，zipFile unEqual mLocalZipPath:" + this.jdField_b_of_type_JavaLangString);
      }
      return;
    }
    if (paramBoolean)
    {
      paramString1 = new File(paramString2);
      if (paramString1.exists())
      {
        a(true, paramString1, paramString3);
        return;
      }
      this.jdField_a_of_type_Int = 2;
      return;
    }
    this.jdField_a_of_type_Int = 2;
  }
  
  protected String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf(".zip");
      String str = paramString;
      if (i > 0) {
        str = paramString.substring(0, i);
      }
      return str + File.separator;
    }
    return "";
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Befq.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
    } while (!this.jdField_b_of_type_Boolean);
    if (this.jdField_a_of_type_Ajdx == null) {
      return false;
    }
    this.jdField_a_of_type_Ajdx.a(paramMessage.arg1, this.jdField_a_of_type_AndroidGraphicsBitmap);
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_c_of_type_Int >= this.jdField_a_of_type_ArrayOfJavaLangString.length) && (this.jdField_a_of_type_ArrayOfJavaLangString.length != 1)) {
      this.jdField_c_of_type_Int = 0;
    }
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > this.jdField_c_of_type_Int)) {
      new ajdv(this, this.jdField_c_of_type_Int).execute(new Integer[] { Integer.valueOf(this.jdField_c_of_type_Int) });
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      break;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Ajdx.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajdu
 * JD-Core Version:    0.7.0.1
 */