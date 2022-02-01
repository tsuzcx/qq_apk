import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity.10;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;

public class alrg
  extends aopa
{
  public alrg(CreateFaceToFaceDiscussionActivity.10 param10, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt != 0) || (paramSosoLbsInfo == null))
    {
      paramSosoLbsInfo = this.a.this$0.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
      paramSosoLbsInfo.arg1 = 1;
      paramSosoLbsInfo.arg2 = 2131698034;
      paramSosoLbsInfo.sendToTarget();
      return;
    }
    paramSosoLbsInfo = CreateFaceToFaceDiscussionActivity.a(this.a.this$0, paramSosoLbsInfo);
    anqn localanqn = (anqn)this.a.this$0.app.a(33);
    switch (this.a.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      localanqn.a(this.a.this$0.jdField_a_of_type_JavaLangStringBuffer.toString(), this.a.this$0.jdField_a_of_type_Int, paramSosoLbsInfo, this.a.this$0.b, this.a.this$0.h);
      return;
    case 1: 
      localanqn.a(this.a.this$0.jdField_a_of_type_JavaLangStringBuffer.toString(), this.a.this$0.jdField_a_of_type_Int, paramSosoLbsInfo, 2, this.a.this$0.h);
      return;
    case 2: 
      localanqn.a(this.a.this$0.jdField_a_of_type_JavaLangStringBuffer.toString(), this.a.this$0.jdField_a_of_type_Int, paramSosoLbsInfo, true);
      return;
    case 3: 
      localanqn.a(this.a.this$0.jdField_a_of_type_JavaLangStringBuffer.toString(), this.a.this$0.jdField_a_of_type_Int, paramSosoLbsInfo, false);
      return;
    }
    localanqn.a(this.a.this$0.jdField_a_of_type_JavaLangStringBuffer.toString(), this.a.this$0.jdField_a_of_type_Int, paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alrg
 * JD-Core Version:    0.7.0.1
 */