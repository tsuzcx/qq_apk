import android.text.TextUtils;
import java.io.File;

public class akqi
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  
  public static String a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    if (paramString1.endsWith("/")) {
      return paramString1 + paramLong + "/" + paramInt + "/" + paramString2;
    }
    return paramString1 + "/" + paramLong + "/" + paramInt + "/" + paramString2;
  }
  
  public static boolean a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (100 == paramInt) {
      return new File(aliu.jdField_b_of_type_JavaLangString + paramInt + "_" + paramLong + "_" + paramString1 + File.separator + paramString2).exists();
    }
    return false;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Int + "_" + this.jdField_a_of_type_Long + "_" + this.jdField_a_of_type_JavaLangString;
  }
  
  public String b()
  {
    if (100 == this.jdField_a_of_type_Int) {
      return aliu.jdField_b_of_type_JavaLangString + a() + File.separator;
    }
    return "";
  }
  
  public String c()
  {
    if (100 == this.jdField_a_of_type_Int) {
      return b() + this.jdField_b_of_type_Int + ".zip";
    }
    return "";
  }
  
  public String d()
  {
    if (100 == this.jdField_a_of_type_Int) {
      return b() + this.jdField_b_of_type_Int + "_patch.zip";
    }
    return "";
  }
  
  public String e()
  {
    if (100 == this.jdField_a_of_type_Int) {
      return b() + this.jdField_c_of_type_Int + ".zip";
    }
    return "";
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ContentUpdateCheckResult{");
    localStringBuffer.append("mBuzId=").append(this.jdField_a_of_type_Int);
    localStringBuffer.append(", mItemId=").append(this.jdField_a_of_type_Long);
    localStringBuffer.append(", mName='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", mVersion=").append(this.jdField_b_of_type_Int);
    localStringBuffer.append(", mOldVersion=").append(this.jdField_c_of_type_Int);
    localStringBuffer.append(", mDownloadFileUrl='").append(this.jdField_b_of_type_JavaLangString).append('\'');
    localStringBuffer.append(", mIsPatch=").append(this.jdField_a_of_type_Boolean);
    localStringBuffer.append(", mPatchData=");
    if (this.jdField_a_of_type_ArrayOfByte == null) {
      localStringBuffer.append("null");
    }
    for (;;)
    {
      localStringBuffer.append(", mPatchSize=").append(this.jdField_b_of_type_Long);
      localStringBuffer.append(", mDownloadPatchFileUrl='").append(this.jdField_c_of_type_JavaLangString).append('\'');
      localStringBuffer.append(", mMd5='").append(this.jdField_d_of_type_JavaLangString).append('\'');
      localStringBuffer.append(", mDownloadFileName='").append(this.jdField_e_of_type_JavaLangString).append('\'');
      localStringBuffer.append(", mDownloadPatchFileName='").append(this.jdField_f_of_type_JavaLangString).append('\'');
      localStringBuffer.append(", mFlagWriteIntervalTs=").append(this.jdField_b_of_type_Boolean);
      localStringBuffer.append(", mCheckServerInterval=").append(this.jdField_d_of_type_Int);
      localStringBuffer.append(", mCheckRequestId=").append(this.jdField_e_of_type_Int);
      localStringBuffer.append(", mDomainId=").append(this.jdField_f_of_type_Int);
      localStringBuffer.append('}');
      return localStringBuffer.toString();
      localStringBuffer.append("mPatchData:").append(this.jdField_a_of_type_ArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akqi
 * JD-Core Version:    0.7.0.1
 */