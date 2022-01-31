import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class agrt
  extends Handler
{
  private final WeakReference<NewPhotoListActivity> a;
  
  public agrt(NewPhotoListActivity paramNewPhotoListActivity)
  {
    this.a = new WeakReference(paramNewPhotoListActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.get() == null)) {}
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = (NewPhotoListActivity)this.a.get();
        localObject1 = agsb.a().jdField_a_of_type_JavaUtilArrayList;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 0: 
          localObject1 = ((NewPhotoListActivity)localObject2).jdField_a_of_type_Agru;
        }
      } while (localObject1 == null);
      localObject2 = new ArrayList();
      ((List)localObject2).addAll(((agru)localObject1).jdField_a_of_type_JavaUtilArrayList);
      paramMessage = paramMessage.getData();
      int i = paramMessage.getInt("ALBUMLIST_POSITION");
      long l = paramMessage.getLong("ALBUMLIST_ITEM_DURATION");
      paramMessage = (LocalMediaInfo)((List)localObject2).get(i);
      paramMessage.mDuration = l;
      ((List)localObject2).set(i, paramMessage);
      ((agru)localObject1).a((List)localObject2);
      ((agru)localObject1).notifyDataSetChanged();
      return;
      ((NewPhotoListActivity)this.a.get()).jdField_a_of_type_Agse.a(paramMessage);
      return;
      ((NewPhotoListActivity)localObject2).d();
      QZLog.e("PhotoListActivity", 2, new Object[] { "onEncodeError = ", Integer.valueOf(((Integer)paramMessage.obj).intValue()) });
      bcpw.a((Context)localObject2, ((NewPhotoListActivity)localObject2).getResources().getString(2131695103), 0).a();
      return;
    } while (!(paramMessage.obj instanceof String));
    String str = (String)paramMessage.obj;
    paramMessage = (Message)localObject1;
    if (localObject1 == null) {
      paramMessage = new ArrayList();
    }
    QZLog.d("PhotoListActivity", 2, new Object[] { "MSG_PHOTO_ENCODE_SUCCEED = ", str });
    if (paramMessage.size() < agsb.a().jdField_a_of_type_Int)
    {
      paramMessage.add(str);
      ((NewPhotoListActivity)localObject2).f();
    }
    for (;;)
    {
      ((NewPhotoListActivity)localObject2).a(str);
      return;
      bcpw.a((Context)localObject2, String.format(((NewPhotoListActivity)localObject2).getResources().getString(2131695099), new Object[] { Integer.valueOf(agsb.a().jdField_a_of_type_Int) }), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agrt
 * JD-Core Version:    0.7.0.1
 */