import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.GroupIconHelper;
import com.tencent.mobileqq.util.FaceDecoderImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;

public class ajlm
  extends DiscussionObserver
{
  private ajlm(FaceDecoderImpl paramFaceDecoderImpl) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (FaceDecoderImpl.a(this.a) == null) {
      return;
    }
    String str;
    int i;
    if (this.a.jdField_a_of_type_Ajlk != null)
    {
      if (!GroupIconHelper.a(paramString)) {
        break label223;
      }
      str = GroupIconHelper.b(paramString);
      i = 1001;
    }
    for (;;)
    {
      paramString = this.a.a(i, paramString, 0, (byte)1);
      if ((paramBoolean1) && (paramString != null)) {
        if (i != 1001) {
          break label185;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.FaceDecoderImpl", 2, "====faceDecoderImpl onUpdateDiscussionFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + str + ",type: " + i + ",style: " + -1);
        }
        if ((this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) || (this.a.b >= this.a.jdField_a_of_type_Int)) {
          break;
        }
        this.a.e();
        return;
        label185:
        this.a.jdField_a_of_type_Ajlk.onDecodeTaskCompleted(this.a.b + this.a.jdField_a_of_type_JavaUtilLinkedList.size(), i, str, paramString);
      }
      label223:
      i = 101;
      str = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajlm
 * JD-Core Version:    0.7.0.1
 */