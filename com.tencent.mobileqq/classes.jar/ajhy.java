import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.AudioInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.EditItemInfoFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public class ajhy
  extends Handler
{
  WeakReference a;
  
  public ajhy(SubmitHomeWorkFragment paramSubmitHomeWorkFragment, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramSubmitHomeWorkFragment);
  }
  
  void a(SubmitHomeWorkFragment paramSubmitHomeWorkFragment)
  {
    if ((SubmitHomeWorkFragment.a(paramSubmitHomeWorkFragment) == null) || (SubmitHomeWorkFragment.a(paramSubmitHomeWorkFragment) == null)) {}
    do
    {
      do
      {
        return;
        if (SubmitHomeWorkFragment.a(paramSubmitHomeWorkFragment).isEmpty())
        {
          SubmitHomeWorkFragment.a(paramSubmitHomeWorkFragment).setVisibility(8);
          SubmitHomeWorkFragment.b(paramSubmitHomeWorkFragment).a();
          SubmitHomeWorkFragment.b(paramSubmitHomeWorkFragment).setHint(paramSubmitHomeWorkFragment.getActivity().getString(2131430649));
          SubmitHomeWorkFragment.b(paramSubmitHomeWorkFragment).getAdapter().notifyDataSetChanged();
          return;
        }
      } while (SubmitHomeWorkFragment.b(paramSubmitHomeWorkFragment));
      SubmitHomeWorkFragment.a(paramSubmitHomeWorkFragment).b();
      Iterator localIterator = SubmitHomeWorkFragment.a(paramSubmitHomeWorkFragment).iterator();
      while (localIterator.hasNext())
      {
        JSONObject localJSONObject = (JSONObject)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("SubmitHomeWorkFragment", 2, "insert special item: " + localJSONObject.optString("type"));
        }
        SubmitHomeWorkFragment.a(paramSubmitHomeWorkFragment).a(EditItemInfoFactory.a(localJSONObject));
      }
      SubmitHomeWorkFragment.a(paramSubmitHomeWorkFragment, true);
    } while (SubmitHomeWorkFragment.a(paramSubmitHomeWorkFragment) != null);
    SubmitHomeWorkFragment.a(paramSubmitHomeWorkFragment, SubmitHomeWorkFragment.a(paramSubmitHomeWorkFragment).a());
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    SubmitHomeWorkFragment localSubmitHomeWorkFragment = (SubmitHomeWorkFragment)this.a.get();
    if ((localSubmitHomeWorkFragment == null) || (!localSubmitHomeWorkFragment.isAdded())) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3: 
      SubmitHomeWorkFragment.b(localSubmitHomeWorkFragment, true);
      SubmitHomeWorkFragment.a(localSubmitHomeWorkFragment).b(false);
      return;
    case 513: 
      a(localSubmitHomeWorkFragment);
      return;
    case 101: 
      SubmitHomeWorkFragment.b(localSubmitHomeWorkFragment, false);
      SubmitHomeWorkFragment.d(localSubmitHomeWorkFragment);
      return;
    }
    int i = (int)SubmitHomeWorkFragment.a(localSubmitHomeWorkFragment).a();
    if (i < 1000)
    {
      QQToast.a(localSubmitHomeWorkFragment.getActivity(), "录音不能小于1秒,录制失败", 0).a();
      SubmitHomeWorkFragment.a(localSubmitHomeWorkFragment).b();
      return;
    }
    if (!NetworkUtil.d(localSubmitHomeWorkFragment.getActivity()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubmitHomeWorkFragment", 2, "no network toast");
      }
      QQToast.a(localSubmitHomeWorkFragment.getActivity(), 2131430298, 0).a();
      SubmitHomeWorkFragment.b(localSubmitHomeWorkFragment, false);
      SubmitHomeWorkFragment.d(localSubmitHomeWorkFragment);
      return;
    }
    paramMessage = paramMessage.obj.toString();
    File localFile = new File(paramMessage);
    if (localFile.exists()) {}
    for (long l = localFile.length();; l = 0L)
    {
      paramMessage = new AudioInfo(paramMessage, null, i / 1000, (int)l, SubmitHomeWorkFragment.b(localSubmitHomeWorkFragment));
      SubmitHomeWorkFragment.b(localSubmitHomeWorkFragment).a(paramMessage);
      SubmitHomeWorkFragment.b(localSubmitHomeWorkFragment, false);
      SubmitHomeWorkFragment.d(localSubmitHomeWorkFragment);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhy
 * JD-Core Version:    0.7.0.1
 */