import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.view.player.VideoViewTVKImpl;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.util.URLUtil;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import mqq.os.MqqHandler;

public class afdx
  extends SimpleJob
{
  public afdx(VideoViewTVKImpl paramVideoViewTVKImpl, String paramString, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo) {}
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return null;
    }
    if (this.jdField_a_of_type_JavaLangString.contains("qqstocdnd"))
    {
      paramJobContext = ((VideoServerInfoManager)SuperManager.a(4)).a();
      SLog.a("VideoViewTVKImpl", "get url key:%s", paramJobContext);
      if (TextUtils.isEmpty(paramJobContext)) {
        break label111;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerVideoViewTVKImpl.c = URLUtil.a(this.jdField_a_of_type_JavaLangString, "authkey", paramJobContext);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerVideoViewTVKImpl.c = InnerDns.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerVideoViewTVKImpl.c.replace("https://", "http://"), 1012);
      ThreadManager.getUIHandler().post(new afdz(this));
      return null;
      label111:
      ThreadManager.getUIHandler().post(new afdy(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afdx
 * JD-Core Version:    0.7.0.1
 */