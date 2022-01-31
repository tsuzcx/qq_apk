import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class agno
  implements bfic
{
  int jdField_a_of_type_Int = 1;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<akes> b;
  WeakReference<XListView> c;
  WeakReference<PullRefreshHeader> d;
  WeakReference<TextView> e;
  
  public agno(Context paramContext, XListView paramXListView, akes paramakes, PullRefreshHeader paramPullRefreshHeader, TextView paramTextView, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.c = new WeakReference(paramXListView);
    this.b = new WeakReference(paramakes);
    this.d = new WeakReference(paramPullRefreshHeader);
    this.e = new WeakReference(paramTextView);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat.aio_post_list_req", 2, paramException.getMessage());
    }
    paramException = (PullRefreshHeader)this.d.get();
    if ((paramException != null) && (paramException.getVisibility() == 0)) {
      paramException.a(1);
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.hotchat.aio_post_list_req", 2, "result " + paramJSONObject);
    }
    XListView localXListView = (XListView)this.c.get();
    if (localXListView == null) {}
    akes localakes;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (TextView)this.e.get();
        } while (localObject == null);
        localakes = (akes)this.b.get();
      } while (localakes == null);
      if ((paramJSONObject != null) && (paramJSONObject.optInt("retcode") == 0)) {
        break;
      }
      if (localXListView.getVisibility() == 8) {
        ((TextView)localObject).setText(alpo.a(2131705962));
      }
      paramJSONObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramJSONObject == null);
    QQToast.a(paramJSONObject, 1, alpo.a(2131705964), 0).a();
    localakes.a();
    return;
    ((TextView)localObject).setVisibility(8);
    localXListView.setVisibility(0);
    Object localObject = paramJSONObject.optJSONObject("result");
    label193:
    int j;
    if (this.jdField_a_of_type_Int == 1)
    {
      localakes.b(((JSONObject)localObject).optJSONArray("posts"));
      j = paramJSONObject.optInt("retcode");
      paramJSONObject = (PullRefreshHeader)this.d.get();
      if ((paramJSONObject != null) && (paramJSONObject.getVisibility() == 0)) {
        if (j != 0) {
          break label315;
        }
      }
    }
    label315:
    for (int i = 0;; i = 1)
    {
      paramJSONObject.a(i);
      localXListView.springBackOverScrollHeaderView();
      if (j != 0) {
        break;
      }
      agmy.i = System.currentTimeMillis();
      return;
      if (((JSONObject)localObject).optInt("isend") == 0)
      {
        localakes.a(((JSONObject)localObject).optJSONArray("posts"));
        localakes.a();
        break label193;
      }
      paramJSONObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramJSONObject != null) {
        QQToast.a(paramJSONObject, 2, alpo.a(2131705954), 0).a();
      }
      localakes.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agno
 * JD-Core Version:    0.7.0.1
 */