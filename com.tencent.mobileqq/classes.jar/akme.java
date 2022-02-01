import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicBase;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class akme
  extends Handler
{
  private final WeakReference<NewPhotoListActivity> a;
  
  public akme(NewPhotoListActivity paramNewPhotoListActivity)
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
        localObject1 = ((NewPhotoListActivity)this.a.get()).mPhotoListLogic.mPhotoCommonData.selectedPhotoList;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 0: 
          localObject1 = ((NewPhotoListActivity)localObject2).photoListAdapter;
        }
      } while (localObject1 == null);
      localObject2 = new ArrayList();
      ((List)localObject2).addAll(((AbstractPhotoListActivity.PhotoListAdapter)localObject1).mAllImages);
      paramMessage = paramMessage.getData();
      int i = paramMessage.getInt("ALBUMLIST_POSITION");
      long l = paramMessage.getLong("ALBUMLIST_ITEM_DURATION");
      paramMessage = (LocalMediaInfo)((List)localObject2).get(i);
      paramMessage.mDuration = l;
      ((List)localObject2).set(i, paramMessage);
      ((AbstractPhotoListActivity.PhotoListAdapter)localObject1).setPhotoList((List)localObject2);
      ((AbstractPhotoListActivity.PhotoListAdapter)localObject1).notifyDataSetChanged();
      return;
      ((NewPhotoListActivity)localObject2).mPhotoListLogic.handleVideoEncodeSucceed(paramMessage);
      return;
      ((NewPhotoListActivity)localObject2).cancleProgressDailog();
      QLog.e("PhotoListActivity", 2, new Object[] { "onEncodeError = ", Integer.valueOf(((Integer)paramMessage.obj).intValue()) });
      QQToast.a((Context)localObject2, ((NewPhotoListActivity)localObject2).getResources().getString(2131694636), 0).a();
      return;
    } while (!(paramMessage.obj instanceof String));
    String str = (String)paramMessage.obj;
    paramMessage = (Message)localObject1;
    if (localObject1 == null) {
      paramMessage = new ArrayList();
    }
    QLog.d("PhotoListActivity", 2, new Object[] { "MSG_PHOTO_ENCODE_SUCCEED = ", str });
    if (paramMessage.size() < ((NewPhotoListActivity)localObject2).mPhotoListLogic.mPhotoCommonData.maxSelectNum)
    {
      paramMessage.add(str);
      ((NewPhotoListActivity)localObject2).b();
    }
    for (;;)
    {
      ((NewPhotoListActivity)localObject2).a(str);
      return;
      QQToast.a((Context)localObject2, String.format(((NewPhotoListActivity)localObject2).getResources().getString(2131694632), new Object[] { Integer.valueOf(((NewPhotoListActivity)localObject2).mPhotoListLogic.mPhotoCommonData.maxSelectNum) }), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akme
 * JD-Core Version:    0.7.0.1
 */