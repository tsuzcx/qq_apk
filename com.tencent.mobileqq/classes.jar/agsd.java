import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class agsd
  implements bfml
{
  int jdField_a_of_type_Int = 1;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<akjh> b;
  WeakReference<XListView> c;
  WeakReference<PullRefreshHeader> d;
  WeakReference<TextView> e;
  
  public agsd(Context paramContext, XListView paramXListView, akjh paramakjh, PullRefreshHeader paramPullRefreshHeader, TextView paramTextView, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.c = new WeakReference(paramXListView);
    this.b = new WeakReference(paramakjh);
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
    akjh localakjh;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (TextView)this.e.get();
        } while (localObject == null);
        localakjh = (akjh)this.b.get();
      } while (localakjh == null);
      if ((paramJSONObject != null) && (paramJSONObject.optInt("retcode") == 0)) {
        break;
      }
      if (localXListView.getVisibility() == 8) {
        ((TextView)localObject).setText(alud.a(2131705974));
      }
      paramJSONObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramJSONObject == null);
    QQToast.a(paramJSONObject, 1, alud.a(2131705976), 0).a();
    localakjh.a();
    return;
    ((TextView)localObject).setVisibility(8);
    localXListView.setVisibility(0);
    Object localObject = paramJSONObject.optJSONObject("result");
    label193:
    int j;
    if (this.jdField_a_of_type_Int == 1)
    {
      localakjh.b(((JSONObject)localObject).optJSONArray("posts"));
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
      agrn.i = System.currentTimeMillis();
      return;
      if (((JSONObject)localObject).optInt("isend") == 0)
      {
        localakjh.a(((JSONObject)localObject).optJSONArray("posts"));
        localakjh.a();
        break label193;
      }
      paramJSONObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramJSONObject != null) {
        QQToast.a(paramJSONObject, 2, alud.a(2131705966), 0).a();
      }
      localakjh.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsd
 * JD-Core Version:    0.7.0.1
 */