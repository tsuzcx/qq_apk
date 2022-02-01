import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aivc
  extends aiuy
{
  aivc(aiuz paramaiuz) {}
  
  public void a(String paramString1, String paramString2, List<aivf> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onFace2FaceAddContactPush mSessionId:" + aiuz.a(this.a) + " sessionId:" + paramString2 + " faceFriends:" + paramList + " currentUin:" + paramString1);
    }
    if ((TextUtils.equals(paramString2, aiuz.a(this.a))) && (aiuz.a(this.a) != null) && (TextUtils.equals(paramString1, aiuz.a(this.a).getCurrentAccountUin())) && (paramList != null) && (paramList.size() > 0))
    {
      aiuz.a(this.a);
      if (aiuz.a(this.a) != null) {
        aiuz.a(this.a).a(paramString1, paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onExitFace2FaceAddContact isSuccess:" + paramBoolean + " mSessionId:" + aiuz.a(this.a) + " sessionId:" + paramString1 + " errorCode:" + paramInt + " errorMsg:" + paramString2);
    }
    aiuz.a(this.a);
    if (aiuz.a(this.a) != null) {
      aiuz.a(this.a).a();
    }
  }
  
  public void a(boolean paramBoolean1, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if (QLog.isDebugVersion()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onEnterFace2FaceAddContact isSuccess:" + paramBoolean1 + " mSessionId:" + aiuz.a(this.a) + " sessionId:" + paramString1 + " errorCode:" + paramInt1 + " errorMsg:" + paramString2 + " securityLevel:" + paramInt2 + " verifyUrl:" + paramString3 + " heartbeatTime:" + paramInt3 + " expireTime:" + paramInt4 + " isEnterAfterVerify:" + paramBoolean2);
    }
    aiuz.a(this.a, paramBoolean1, paramString1, paramInt1, paramString2, paramInt2, paramString3, paramInt3, paramInt4, paramBoolean2);
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onFace2FaceAddContactHeartBeat isSuccess:" + paramBoolean + " mSessionId:" + aiuz.a(this.a) + " sessionId:" + paramString1 + " errorCode:" + paramInt + " errorMsg:" + paramString2 + " missingList:" + paramList);
    }
    aiuz.a(this.a, paramBoolean, paramString1, paramInt, paramString2, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivc
 * JD-Core Version:    0.7.0.1
 */