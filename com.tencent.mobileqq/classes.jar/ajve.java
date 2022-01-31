import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.ViewHolder;
import com.tencent.mobileqq.troop.utils.NonMainAppListViewFaceLoader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class ajve
  extends Handler
{
  public ajve(NonMainAppListViewFaceLoader paramNonMainAppListViewFaceLoader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000)
    {
      this.a.a();
      break label17;
    }
    label17:
    while (paramMessage.what != 1002) {
      return;
    }
    if (this.a.jdField_a_of_type_Int == 0) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = (Bundle)paramMessage.obj;
        paramMessage = (Bitmap)((Bundle)localObject1).getParcelable("bmp");
        localObject1 = ((Bundle)localObject1).getString("uin");
        if (paramMessage != null) {
          this.a.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(localObject1, paramMessage);
        }
        if (QLog.isColorLevel()) {
          QLog.d("NonMainAppListViewFaceLoader", 2, "refreshImg, uin:" + (String)localObject1);
        }
        int j = this.a.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
        i = 0;
        if (i >= j) {
          break label17;
        }
        Object localObject2 = this.a.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
        if ((localObject2 instanceof FacePreloadBaseAdapter.ViewHolder))
        {
          localObject2 = (FacePreloadBaseAdapter.ViewHolder)localObject2;
          if ((localObject2 != null) && (((FacePreloadBaseAdapter.ViewHolder)localObject2).a != null) && (((FacePreloadBaseAdapter.ViewHolder)localObject2).a.equals(localObject1))) {
            ((FacePreloadBaseAdapter.ViewHolder)localObject2).c.setImageBitmap(paramMessage);
          }
        }
        else if ((localObject2 instanceof VideoFeedsAdapter.VideoItemHolder))
        {
          localObject2 = (VideoFeedsAdapter.VideoItemHolder)localObject2;
          if ((((VideoFeedsAdapter.VideoItemHolder)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (((VideoFeedsAdapter.VideoItemHolder)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a != null) && ((((VideoFeedsAdapter.VideoItemHolder)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_Int == 1) || (((VideoFeedsAdapter.VideoItemHolder)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.jdField_a_of_type_Int == 6)) && (!TextUtils.isEmpty(((VideoFeedsAdapter.VideoItemHolder)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.j)) && (((VideoFeedsAdapter.VideoItemHolder)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a.j.equals(localObject1))) {
            ((VideoFeedsAdapter.VideoItemHolder)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setImageBitmap(paramMessage);
          }
        }
      }
      catch (Exception paramMessage) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("NonMainAppListViewFaceLoader", 2, "refreshImg, exception:" + paramMessage.toString());
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("NonMainAppListViewFaceLoader", 2, "refreshImg return, listview non-idle, uin:" + MagnifierSDK.a);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajve
 * JD-Core Version:    0.7.0.1
 */