import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class aeqt
  implements bdip
{
  int jdField_a_of_type_Int = 1;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<ainj> b;
  WeakReference<XListView> c;
  WeakReference<PullRefreshHeader> d;
  WeakReference<TextView> e;
  
  public aeqt(Context paramContext, XListView paramXListView, ainj paramainj, PullRefreshHeader paramPullRefreshHeader, TextView paramTextView, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.c = new WeakReference(paramXListView);
    this.b = new WeakReference(paramainj);
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
    ainj localainj;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (TextView)this.e.get();
        } while (localObject == null);
        localainj = (ainj)this.b.get();
      } while (localainj == null);
      if ((paramJSONObject != null) && (paramJSONObject.optInt("retcode") == 0)) {
        break;
      }
      if (localXListView.getVisibility() == 8) {
        ((TextView)localObject).setText(ajyc.a(2131705579));
      }
      paramJSONObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramJSONObject == null);
    bcpw.a(paramJSONObject, 1, ajyc.a(2131705581), 0).a();
    localainj.a();
    return;
    ((TextView)localObject).setVisibility(8);
    localXListView.setVisibility(0);
    Object localObject = paramJSONObject.optJSONObject("result");
    label193:
    int j;
    if (this.jdField_a_of_type_Int == 1)
    {
      localainj.b(((JSONObject)localObject).optJSONArray("posts"));
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
      aeqd.i = System.currentTimeMillis();
      return;
      if (((JSONObject)localObject).optInt("isend") == 0)
      {
        localainj.a(((JSONObject)localObject).optJSONArray("posts"));
        localainj.a();
        break label193;
      }
      paramJSONObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramJSONObject != null) {
        bcpw.a(paramJSONObject, 2, ajyc.a(2131705571), 0).a();
      }
      localainj.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeqt
 * JD-Core Version:    0.7.0.1
 */