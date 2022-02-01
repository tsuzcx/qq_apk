import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class alns
  extends QQLruCache<String, ApolloBaseInfo>
{
  alns(alnr paramalnr, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public ApolloBaseInfo a(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    if (paramApolloBaseInfo != null) {}
    try
    {
      alnr.a(this.a).remove(Long.valueOf(Long.parseLong(paramApolloBaseInfo.uin)));
      return (ApolloBaseInfo)super.put(paramString, paramApolloBaseInfo);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("ApolloManager", 1, localNumberFormatException, new Object[0]);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, ApolloBaseInfo paramApolloBaseInfo1, ApolloBaseInfo paramApolloBaseInfo2)
  {
    super.entryRemoved(paramBoolean, paramString, paramApolloBaseInfo1, paramApolloBaseInfo2);
    if (paramApolloBaseInfo1 != null) {}
    try
    {
      if (alnr.a(this.a).size() < 1024) {
        alnr.a(this.a).add(Long.valueOf(Long.parseLong(paramApolloBaseInfo1.uin)));
      }
      return;
    }
    catch (NumberFormatException paramString)
    {
      QLog.e("ApolloManager", 1, paramString, new Object[0]);
      return;
    }
    catch (OutOfMemoryError paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alns
 * JD-Core Version:    0.7.0.1
 */