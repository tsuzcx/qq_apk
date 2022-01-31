import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class afia
  extends afhw
{
  afia(afhx paramafhx) {}
  
  public void a(String paramString1, String paramString2, List<afid> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onFace2FaceAddContactPush mSessionId:" + afhx.a(this.a) + " sessionId:" + paramString2 + " faceFriends:" + paramList + " currentUin:" + paramString1);
    }
    if ((TextUtils.equals(paramString2, afhx.a(this.a))) && (afhx.a(this.a) != null) && (TextUtils.equals(paramString1, afhx.a(this.a).getCurrentAccountUin())) && (paramList != null) && (paramList.size() > 0))
    {
      afhx.b(this.a);
      if (afhx.a(this.a) != null) {
        afhx.a(this.a).a(paramString1, paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onExitFace2FaceAddContact isSuccess:" + paramBoolean + " mSessionId:" + afhx.a(this.a) + " sessionId:" + paramString1 + " errorCode:" + paramInt + " errorMsg:" + paramString2);
    }
    afhx.b(this.a);
    if (afhx.a(this.a) != null) {
      afhx.a(this.a).a();
    }
  }
  
  public void a(boolean paramBoolean1, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if (QLog.isDebugVersion()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onEnterFace2FaceAddContact isSuccess:" + paramBoolean1 + " mSessionId:" + afhx.a(this.a) + " sessionId:" + paramString1 + " errorCode:" + paramInt1 + " errorMsg:" + paramString2 + " securityLevel:" + paramInt2 + " verifyUrl:" + paramString3 + " heartbeatTime:" + paramInt3 + " expireTime:" + paramInt4 + " isEnterAfterVerify:" + paramBoolean2);
    }
    if ((paramBoolean1) && (TextUtils.equals(afhx.a(this.a), paramString1)) && (afhx.a(this.a) != null)) {
      if (paramInt2 == 2) {
        if (afhx.a(this.a) != null) {
          afhx.a(this.a).f();
        }
      }
    }
    while (afhx.a(this.a) == null)
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
              } while (afhx.a(this.a) == null);
              afhx.a(this.a).b(paramString3);
              return;
              switch (paramInt1)
              {
              default: 
                return;
              case 0: 
                afhx.a(this.a, Math.max(paramInt3 * 1000, 10000));
                afhx.b(this.a, Math.max(paramInt4 * 1000, 10000));
                if (afhx.a(this.a) != null)
                {
                  afhx.a(this.a).a(afhx.a(this.a));
                  afhx.a(this.a).b(afhx.b(this.a));
                }
                afhx.a(this.a);
                return;
              }
            } while (afhx.a(this.a) == null);
            afhx.a(this.a).g();
            return;
          } while (afhx.a(this.a) == null);
          afhx.a(this.a).c();
          return;
        } while (afhx.a(this.a) == null);
        afhx.a(this.a).d();
        return;
      } while (afhx.a(this.a) == null);
      afhx.a(this.a).e();
      return;
    }
    afhx.a(this.a).e();
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, List<String> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddContactPresenter", 2, "onFace2FaceAddContactHeartBeat isSuccess:" + paramBoolean + " mSessionId:" + afhx.a(this.a) + " sessionId:" + paramString1 + " errorCode:" + paramInt + " errorMsg:" + paramString2 + " missingList:" + paramList);
    }
    if ((paramBoolean) && (TextUtils.equals(paramString1, afhx.a(this.a)))) {
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
        } while (afhx.a(this.a) == null);
        if ((paramList != null) && (paramList.size() > 0)) {
          afhx.a(this.a).a(paramList);
        }
        afhx.a(this.a).b(afhx.b(this.a));
        return;
      } while (afhx.a(this.a) == null);
      afhx.a(this.a).c();
      return;
    } while (afhx.a(this.a) == null);
    afhx.a(this.a).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afia
 * JD-Core Version:    0.7.0.1
 */