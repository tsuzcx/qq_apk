import com.tencent.mobileqq.apollo.game.ApolloGameInterfaceProxy;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aktv
  extends akzo
{
  public aktv(ApolloGameInterfaceProxy paramApolloGameInterfaceProxy) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (paramObject == null);
    try
    {
      paramObject = new JSONObject(paramObject.toString());
      paramInt = paramObject.optInt("errCode");
      paramObject.remove("errCode");
      ApolloGameInterfaceProxy.a(this.a, paramInt, "cs.ssoMessage.local", paramObject.toString());
      return;
    }
    catch (Throwable paramObject)
    {
      QLog.e("cmgame_process.CmGameObserver", 1, paramObject, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aktv
 * JD-Core Version:    0.7.0.1
 */