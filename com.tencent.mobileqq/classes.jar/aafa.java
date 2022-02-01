import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;
import java.util.Map;

public class aafa
  extends QQUIEventReceiver<aaet, aaep>
{
  public aafa(@NonNull aaet paramaaet)
  {
    super(paramaaet);
  }
  
  public void a(@NonNull aaet paramaaet, @NonNull aaep paramaaep)
  {
    switch (paramaaep.jdField_a_of_type_Int)
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
            paramaaet.i();
            return;
            paramaaet.j();
            return;
            aaet.a(paramaaet, false);
            aaet.a(paramaaet, null);
            aaet.a(paramaaet, null);
          } while (!(paramaaep.jdField_a_of_type_JavaLangObject instanceof Object[]));
          paramaaep = (Object[])paramaaep.jdField_a_of_type_JavaLangObject;
        } while ((paramaaep.length < 2) || (!(paramaaep[0] instanceof CertifiedAccountMeta.StFeed)) || (!(paramaaep[1] instanceof Integer)));
        localStFeed = (CertifiedAccountMeta.StFeed)paramaaep[0];
        i = ((Integer)paramaaep[1]).intValue();
      } while (!paramaaet.a(localStFeed));
      aaet.c(paramaaet).put(Integer.valueOf(i), localStFeed);
      QZLog.i(this.TAG, 1, "EVENT_SET_COMMENT_DATA, position:" + i + ", cellId:" + localStFeed.id.get());
      return;
    }
    aaet.a(paramaaet, (Object[])paramaaep.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return aaep.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafa
 * JD-Core Version:    0.7.0.1
 */