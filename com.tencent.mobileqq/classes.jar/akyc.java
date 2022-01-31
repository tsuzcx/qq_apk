import com.tencent.mobileqq.apollo.sdk.CmShowViewListener.1;
import com.tencent.mobileqq.apollo.sdk.CmShowViewListener.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class akyc
  extends bdqc
  implements akmo
{
  private int jdField_a_of_type_Int = 3;
  private akxj jdField_a_of_type_Akxj;
  private WeakReference<akxn> jdField_a_of_type_JavaLangRefWeakReference;
  
  public akyc(akxn paramakxn, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramakxn);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(akxj paramakxj)
  {
    this.jdField_a_of_type_Akxj = paramakxj;
  }
  
  protected void onApolloDressChange(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_ApolloDrawerInfoViewListener", 2, "[onApolloDressChange], result:" + paramBoolean + ",data:" + paramObject);
    }
    ThreadManager.post(new CmShowViewListener.2(this, paramBoolean, paramObject), 5, null, true);
  }
  
  public void onNotifyLongTouch(String paramString)
  {
    QLog.d("CmShow_ApolloDrawerInfoViewListener", 1, new Object[] { "onNotifyLongTouch name", paramString });
    if (this.jdField_a_of_type_Akxj != null) {
      this.jdField_a_of_type_Akxj.a(paramString);
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_ApolloDrawerInfoViewListener", 2, new Object[] { "[onNotifyStatusChanged], clickPart:", Integer.valueOf(paramInt), ",apolloId:", paramString });
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      akxo localakxo = ((akxn)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
      if (localakxo != null) {
        localakxo.a(akwt.a(paramInt), null, paramString);
      }
    }
    QLog.d("CmShow_ApolloDrawerInfoViewListener", 1, new Object[] { "onNotifyStatusChanged clickPart:", Integer.valueOf(paramInt), " apolloId:" + paramString });
    if (this.jdField_a_of_type_Akxj != null) {
      this.jdField_a_of_type_Akxj.a(paramInt, paramString);
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_ApolloDrawerInfoViewListener", 2, "[onSurfaceReady], w:" + paramInt1 + ",h:" + paramInt2);
    }
    ThreadManager.post(new CmShowViewListener.1(this, paramInt1, paramInt2), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyc
 * JD-Core Version:    0.7.0.1
 */