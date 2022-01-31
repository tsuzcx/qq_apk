import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ahff
  extends ahfb
{
  ahff(ahfc paramahfc) {}
  
  public void a(String paramString1, String paramString2, List<ahfi> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onFace2FaceAddContactPush mSessionId:" + ahfc.a(this.a) + " sessionId:" + paramString2 + " faceFriends:" + paramList + " currentUin:" + paramString1);
    }
    if ((TextUtils.equals(paramString2, ahfc.a(this.a))) && (ahfc.a(this.a) != null) && (TextUtils.equals(paramString1, ahfc.a(this.a).getCurrentAccountUin())) && (paramList != null) && (paramList.size() > 0))
    {
      ahfc.b(this.a);
      if (ahfc.a(this.a) != null) {
        ahfc.a(this.a).a(paramString1, paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onExitFace2FaceAddContact isSuccess:" + paramBoolean + " mSessionId:" + ahfc.a(this.a) + " sessionId:" + paramString1 + " errorCode:" + paramInt + " errorMsg:" + paramString2);
    }
    ahfc.b(this.a);
    if (ahfc.a(this.a) != null) {
      ahfc.a(this.a).a();
    }
  }
  
  public void a(boolean paramBoolean1, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if (QLog.isDebugVersion()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onEnterFace2FaceAddContact isSuccess:" + paramBoolean1 + " mSessionId:" + ahfc.a(this.a) + " sessionId:" + paramString1 + " errorCode:" + paramInt1 + " errorMsg:" + paramString2 + " securityLevel:" + paramInt2 + " verifyUrl:" + paramString3 + " heartbeatTime:" + paramInt3 + " expireTime:" + paramInt4 + " isEnterAfterVerify:" + paramBoolean2);
    }
    if ((paramBoolean1) && (TextUtils.equals(ahfc.a(this.a), paramString1)) && (ahfc.a(this.a) != null)) {
      if (paramInt2 == 2) {
        if (ahfc.a(this.a) != null) {
          ahfc.a(this.a).f();
        }
      }
    }
    while (ahfc.a(this.a) == null)
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (paramInt2 != 3) {
                  break;
                }
              } while (ahfc.a(this.a) == null);
              ahfc.a(this.a).b(paramString3);
              return;
              switch (paramInt1)
              {
              default: 
                return;
              case 0: 
                ahfc.a(this.a, Math.max(paramInt3 * 1000, 10000));
                ahfc.b(this.a, Math.max(paramInt4 * 1000, 10000));
                if (ahfc.a(this.a) != null)
                {
                  ahfc.a(this.a).a(ahfc.a(this.a));
                  ahfc.a(this.a).b(ahfc.b(this.a));
                }
                ahfc.a(this.a);
                return;
              }
            } while (ahfc.a(this.a) == null);
            ahfc.a(this.a).g();
            return;
          } while (ahfc.a(this.a) == null);
          ahfc.a(this.a).c();
          return;
        } while (ahfc.a(this.a) == null);
        ahfc.a(this.a).d();
        return;
      } while (ahfc.a(this.a) == null);
      ahfc.a(this.a).e();
      return;
    }
    ahfc.a(this.a).e();
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onFace2FaceAddContactHeartBeat isSuccess:" + paramBoolean + " mSessionId:" + ahfc.a(this.a) + " sessionId:" + paramString1 + " errorCode:" + paramInt + " errorMsg:" + paramString2 + " missingList:" + paramList);
    }
    if ((paramBoolean) && (TextUtils.equals(paramString1, ahfc.a(this.a)))) {
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (ahfc.a(this.a) == null);
        if ((paramList != null) && (paramList.size() > 0)) {
          ahfc.a(this.a).a(paramList);
        }
        ahfc.a(this.a).b(ahfc.b(this.a));
        return;
      } while (ahfc.a(this.a) == null);
      ahfc.a(this.a).c();
      return;
    } while (ahfc.a(this.a) == null);
    ahfc.a(this.a).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahff
 * JD-Core Version:    0.7.0.1
 */