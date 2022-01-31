import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class afic
  extends afhy
{
  afic(afhz paramafhz) {}
  
  public void a(String paramString1, String paramString2, List<afif> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onFace2FaceAddContactPush mSessionId:" + afhz.a(this.a) + " sessionId:" + paramString2 + " faceFriends:" + paramList + " currentUin:" + paramString1);
    }
    if ((TextUtils.equals(paramString2, afhz.a(this.a))) && (afhz.a(this.a) != null) && (TextUtils.equals(paramString1, afhz.a(this.a).getCurrentAccountUin())) && (paramList != null) && (paramList.size() > 0))
    {
      afhz.b(this.a);
      if (afhz.a(this.a) != null) {
        afhz.a(this.a).a(paramString1, paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onExitFace2FaceAddContact isSuccess:" + paramBoolean + " mSessionId:" + afhz.a(this.a) + " sessionId:" + paramString1 + " errorCode:" + paramInt + " errorMsg:" + paramString2);
    }
    afhz.b(this.a);
    if (afhz.a(this.a) != null) {
      afhz.a(this.a).a();
    }
  }
  
  public void a(boolean paramBoolean1, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if (QLog.isDebugVersion()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onEnterFace2FaceAddContact isSuccess:" + paramBoolean1 + " mSessionId:" + afhz.a(this.a) + " sessionId:" + paramString1 + " errorCode:" + paramInt1 + " errorMsg:" + paramString2 + " securityLevel:" + paramInt2 + " verifyUrl:" + paramString3 + " heartbeatTime:" + paramInt3 + " expireTime:" + paramInt4 + " isEnterAfterVerify:" + paramBoolean2);
    }
    if ((paramBoolean1) && (TextUtils.equals(afhz.a(this.a), paramString1)) && (afhz.a(this.a) != null)) {
      if (paramInt2 == 2) {
        if (afhz.a(this.a) != null) {
          afhz.a(this.a).f();
        }
      }
    }
    while (afhz.a(this.a) == null)
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
              } while (afhz.a(this.a) == null);
              afhz.a(this.a).b(paramString3);
              return;
              switch (paramInt1)
              {
              default: 
                return;
              case 0: 
                afhz.a(this.a, Math.max(paramInt3 * 1000, 10000));
                afhz.b(this.a, Math.max(paramInt4 * 1000, 10000));
                if (afhz.a(this.a) != null)
                {
                  afhz.a(this.a).a(afhz.a(this.a));
                  afhz.a(this.a).b(afhz.b(this.a));
                }
                afhz.a(this.a);
                return;
              }
            } while (afhz.a(this.a) == null);
            afhz.a(this.a).g();
            return;
          } while (afhz.a(this.a) == null);
          afhz.a(this.a).c();
          return;
        } while (afhz.a(this.a) == null);
        afhz.a(this.a).d();
        return;
      } while (afhz.a(this.a) == null);
      afhz.a(this.a).e();
      return;
    }
    afhz.a(this.a).e();
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onFace2FaceAddContactHeartBeat isSuccess:" + paramBoolean + " mSessionId:" + afhz.a(this.a) + " sessionId:" + paramString1 + " errorCode:" + paramInt + " errorMsg:" + paramString2 + " missingList:" + paramList);
    }
    if ((paramBoolean) && (TextUtils.equals(paramString1, afhz.a(this.a)))) {
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
        } while (afhz.a(this.a) == null);
        if ((paramList != null) && (paramList.size() > 0)) {
          afhz.a(this.a).a(paramList);
        }
        afhz.a(this.a).b(afhz.b(this.a));
        return;
      } while (afhz.a(this.a) == null);
      afhz.a(this.a).c();
      return;
    } while (afhz.a(this.a) == null);
    afhz.a(this.a).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afic
 * JD-Core Version:    0.7.0.1
 */