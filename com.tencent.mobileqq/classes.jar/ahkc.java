import com.tencent.mobileqq.data.MessageForTofuAskAnonymously;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/activity/aio/item/TofuAskAnonymouslyItemBuilder$mAnonymousObserver$1", "Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/handler/AnonymousObserver;", "onGetLatestAnonymousInfo", "", "success", "", "data", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ahkc
  extends azzo
{
  public void a(boolean paramBoolean, @Nullable Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TofuAskAnonymouslyItemBuilder", 2, "onGetLatestAnonymousInfo() success = " + paramBoolean + " and data is " + paramObject);
    }
    if ((paramBoolean) && ((paramObject instanceof Object[])) && (((Object[])paramObject).length == 5))
    {
      ahjx.a(this.a).a(true);
      ahka localahka = ahjx.a(this.a);
      Object localObject = ((Object[])paramObject)[0];
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      }
      localahka.a((String)localObject);
      localahka = ahjx.a(this.a);
      localObject = ((Object[])paramObject)[1];
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
      }
      localahka.a(((Long)localObject).longValue());
      localahka = ahjx.a(this.a);
      localObject = ((Object[])paramObject)[2];
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
      }
      localahka.b(((Boolean)localObject).booleanValue());
      localahka = ahjx.a(this.a);
      localObject = ((Object[])paramObject)[3];
      if (localObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
      }
      localahka.b(((Long)localObject).longValue());
      localahka = ahjx.a(this.a);
      paramObject = ((Object[])paramObject)[4];
      if (paramObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
      }
      localahka.c(((Long)paramObject).longValue());
      if ((ahjx.a(this.a).equals(ahjx.a(this.a).a())) && (ahjx.a(this.a).getAskAnonymouslyQuestion() != null))
      {
        ahjx.a(this.a);
        ahjx.b(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkc
 * JD-Core Version:    0.7.0.1
 */