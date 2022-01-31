import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.scribble.ScribbleBaseOperator;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils.CombineCallback;
import com.tencent.mobileqq.scribble.ScribbleUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

public class ahca
  extends AsyncTask
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ScribbleMsgUtils.CombineCallback jdField_a_of_type_ComTencentMobileqqScribbleScribbleMsgUtils$CombineCallback;
  private String jdField_a_of_type_JavaLangString = "";
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "";
  private String d = "";
  private String e = "SendAfterCombinePicAndDataTask";
  
  public ahca(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, Bitmap paramBitmap, int paramInt2, ScribbleMsgUtils.CombineCallback paramCombineCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleMsgUtils$CombineCallback = paramCombineCallback;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  int a()
  {
    String str1 = ScribbleMsgUtils.jdField_a_of_type_JavaLangString + "temp/" + System.currentTimeMillis();
    String str2 = ScribbleMsgUtils.jdField_a_of_type_JavaLangString + "temp/" + System.currentTimeMillis() + "_data";
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleMsgUtils$CombineCallback != null) {
      bool = this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleMsgUtils$CombineCallback.a(str2);
    }
    if (!bool) {
      return ScribbleMsgUtils.g;
    }
    if (!FileUtil.a(str2)) {
      return ScribbleMsgUtils.h;
    }
    Object localObject = a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_c_of_type_Int = localObject.length;
    if (!ScribbleUtils.a((byte[])localObject, str2, str1)) {
      return ScribbleMsgUtils.e;
    }
    localObject = ScribbleUtils.a(str1);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return ScribbleMsgUtils.f;
    }
    this.jdField_b_of_type_JavaLangString = ((String)localObject);
    this.jdField_c_of_type_JavaLangString = ScribbleMsgUtils.a(this.jdField_b_of_type_JavaLangString);
    this.d = ScribbleMsgUtils.b(this.jdField_b_of_type_JavaLangString);
    if (!ScribbleUtils.a(str1, this.jdField_c_of_type_JavaLangString).booleanValue()) {
      return ScribbleMsgUtils.e;
    }
    if (!ScribbleUtils.a(str2, this.d).booleanValue()) {
      return ScribbleMsgUtils.e;
    }
    FileUtil.c(str1);
    FileUtil.c(str2);
    return ScribbleMsgUtils.d;
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(a());
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    QLog.i(this.e, 2, "doBeforeSendScribble result = " + paramInteger);
    if (paramInteger.intValue() == ScribbleMsgUtils.d)
    {
      ScribbleBaseOperator localScribbleBaseOperator = new ScribbleBaseOperator(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      MessageForScribble localMessageForScribble = localScribbleBaseOperator.a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      localMessageForScribble.mExistInfo.mCombineFileExist = true;
      localMessageForScribble.mExistInfo.mDataFileExist = true;
      localMessageForScribble.mExistInfo.mLocalPathExist = true;
      localMessageForScribble.mExistInfo.mInit = true;
      localScribbleBaseOperator.a(localMessageForScribble);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleMsgUtils$CombineCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqScribbleScribbleMsgUtils$CombineCallback.a(paramInteger.intValue());
    }
  }
  
  public byte[] a(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahca
 * JD-Core Version:    0.7.0.1
 */