import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;
import java.util.Map;

public class aajb
  extends QQUIEventReceiver<aaiu, aaiq>
{
  public aajb(@NonNull aaiu paramaaiu)
  {
    super(paramaaiu);
  }
  
  public void a(@NonNull aaiu paramaaiu, @NonNull aaiq paramaaiq)
  {
    switch (paramaaiq.jdField_a_of_type_Int)
    {
    case 4: 
    case 5: 
    default: 
    case 1: 
    case 2: 
    case 3: 
      CertifiedAccountMeta.StFeed localStFeed;
      int i;
      do
      {
        do
        {
          do
          {
            return;
            paramaaiu.i();
            return;
            paramaaiu.j();
            return;
            aaiu.a(paramaaiu, false);
            aaiu.a(paramaaiu, null);
            aaiu.a(paramaaiu, null);
          } while (!(paramaaiq.jdField_a_of_type_JavaLangObject instanceof Object[]));
          paramaaiq = (Object[])paramaaiq.jdField_a_of_type_JavaLangObject;
        } while ((paramaaiq.length < 2) || (!(paramaaiq[0] instanceof CertifiedAccountMeta.StFeed)) || (!(paramaaiq[1] instanceof Integer)));
        localStFeed = (CertifiedAccountMeta.StFeed)paramaaiq[0];
        i = ((Integer)paramaaiq[1]).intValue();
      } while (!paramaaiu.a(localStFeed));
      aaiu.c(paramaaiu).put(Integer.valueOf(i), localStFeed);
      QZLog.i(this.TAG, 1, "EVENT_SET_COMMENT_DATA, position:" + i + ", cellId:" + localStFeed.id.get());
      return;
    }
    aaiu.a(paramaaiu, (Object[])paramaaiq.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return aaiq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aajb
 * JD-Core Version:    0.7.0.1
 */