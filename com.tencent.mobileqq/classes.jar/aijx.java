import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinGifImageDownloader;
import com.tencent.biz.pubaccount.util.GifPlayTimeHttpDownloader;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableParams;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder.ApolloGifDownloader;
import com.tencent.mobileqq.activity.aio.photo.PhotoDecoder;
import com.tencent.mobileqq.apollo.store.ApolloImageDownloader;
import com.tencent.mobileqq.apollo.utils.ApolloDownloader;
import com.tencent.mobileqq.app.FunnyPicHelper.FunnyPicDownloader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.emoticonview.FavoriteDownloader;
import com.tencent.mobileqq.hotpic.HotPicDownLoader;
import com.tencent.mobileqq.hotpic.HotPicOriginDownLoader;
import com.tencent.mobileqq.hotpic.HotVideoPreviewDownloader;
import com.tencent.mobileqq.redtouch.RedTouchPicDownloader;
import com.tencent.mobileqq.transfile.AIOFlowerImgDownloader;
import com.tencent.mobileqq.transfile.AIOPhotoImageDownloader;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.AvatarPendantDownloader;
import com.tencent.mobileqq.transfile.CarrierImgDownloader;
import com.tencent.mobileqq.transfile.ChatImageDownloader;
import com.tencent.mobileqq.transfile.DataLineDownloader;
import com.tencent.mobileqq.transfile.DataLineFaceDownloader;
import com.tencent.mobileqq.transfile.DeviceMsgThumbDownloader;
import com.tencent.mobileqq.transfile.EmotionDownloader;
import com.tencent.mobileqq.transfile.FavoriteImageDownloader;
import com.tencent.mobileqq.transfile.FileAssistantDownloader;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.LBSImageDownloader;
import com.tencent.mobileqq.transfile.LastModifySupportDownloader;
import com.tencent.mobileqq.transfile.LocalBilldDownloader;
import com.tencent.mobileqq.transfile.LocationDownloader;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.transfile.PicEmotionDownloader;
import com.tencent.mobileqq.transfile.ProfileImgDownloader;
import com.tencent.mobileqq.transfile.QZoneCoverDownloader;
import com.tencent.mobileqq.transfile.QZoneRecentPhotoDownloader;
import com.tencent.mobileqq.transfile.RegionalThumbDownloader;
import com.tencent.mobileqq.transfile.ShortVideoThumbDownloader;
import com.tencent.mobileqq.transfile.SignatureTemplateDownloader;
import com.tencent.mobileqq.transfile.ThemeDIYDownloader;
import com.tencent.mobileqq.transfile.ThirdPartAppIconDownloader;
import com.tencent.mobileqq.transfile.VasApngDownloader;
import com.tencent.mobileqq.transfile.VasExtensionDownloader;
import com.tencent.mobileqq.transfile.VideoCoverDownloader;
import com.tencent.mobileqq.transfile.VideoThumbDownloader;

public class aijx
  extends URLDrawableParams
{
  private ProtocolDownloader jdField_a_of_type_ComTencentImageProtocolDownloader;
  private AIOPhotoImageDownloader jdField_a_of_type_ComTencentMobileqqTransfileAIOPhotoImageDownloader;
  private ProtocolDownloader b;
  private ProtocolDownloader c;
  private ProtocolDownloader d;
  private ProtocolDownloader e;
  private ProtocolDownloader f;
  private ProtocolDownloader g;
  private ProtocolDownloader h;
  
  public aijx(Application paramApplication)
  {
    super(paramApplication);
    this.mFadeInImage = false;
    this.mUseGifAnimation = false;
    this.mMemoryCache = BaseApplicationImpl.sImageCache;
    paramApplication = new ThreadPoolParams();
    paramApplication.poolThreadName = "URLDrawable";
    this.mURLDrawableExecutor = ThreadManager.newFreeThreadPool(paramApplication);
    paramApplication = ThreadManager.newFreeHandlerThread("URLDrawableSub", 0);
    paramApplication.start();
    this.mSubHandler = new Handler(paramApplication.getLooper());
    paramApplication = ThreadManager.newFreeHandlerThread("URLDrawableFile", 0);
    paramApplication.start();
    this.mFileHandler = new Handler(paramApplication.getLooper());
    paramApplication = ThreadManager.newFreeHandlerThread("URLDrawableBatch", 0);
    paramApplication.start();
    this.mBatchHandler = new Handler(paramApplication.getLooper());
  }
  
  protected ProtocolDownloader doGetDownloader(String paramString, Object paramObject)
  {
    boolean bool = true;
    if (("http".equals(paramString)) || ("https".equals(paramString)))
    {
      if (this.jdField_a_of_type_ComTencentImageProtocolDownloader == null) {
        if (BaseApplicationImpl.sProcessId != 1) {
          break label52;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentImageProtocolDownloader = new HttpDownloader(bool, paramObject);
        return this.jdField_a_of_type_ComTencentImageProtocolDownloader;
        label52:
        bool = false;
      }
    }
    if (("nearbyimage".equals(paramString)) || ("nearbylocalimage".equals(paramString)))
    {
      if (this.f == null) {
        this.f = new NearbyImgDownloader();
      }
      return this.f;
    }
    if (("chatthumb".equals(paramString)) || ("chatimg".equals(paramString)) || ("chatraw".equals(paramString)))
    {
      if (this.b == null) {
        this.b = new ChatImageDownloader(BaseApplicationImpl.getApplication());
      }
      return this.b;
    }
    if (("lbsthumb".equals(paramString)) || ("lbsimg".equals(paramString)))
    {
      if (this.c == null) {
        this.c = new LBSImageDownloader(BaseApplicationImpl.getApplication());
      }
      return this.c;
    }
    if ("datalineimage".equals(paramString)) {
      return new DataLineDownloader(BaseApplicationImpl.getApplication());
    }
    if ("datalineface".equals(paramString)) {
      return new DataLineFaceDownloader(BaseApplicationImpl.getApplication());
    }
    if ("emotion".equals(paramString)) {
      return new EmotionDownloader(BaseApplicationImpl.getApplication());
    }
    if ("emotion_pic".equals(paramString)) {
      return new PicEmotionDownloader(BaseApplicationImpl.getApplication());
    }
    if ("favorite".equals(paramString)) {
      return new FavoriteDownloader(BaseApplicationImpl.getApplication());
    }
    if ("albumthumb".equals(paramString)) {
      return new AlbumThumbDownloader(BaseApplicationImpl.getApplication());
    }
    if ("videothumb".equals(paramString)) {
      return new VideoThumbDownloader();
    }
    if ("videocover".equals(paramString)) {
      return new VideoCoverDownloader();
    }
    if ("pubaccountimage".equals(paramString)) {
      return new PubAccountHttpDownloader(BaseApplicationImpl.getApplication());
    }
    if ("location".equals(paramString)) {
      return new LocationDownloader(BaseApplicationImpl.getApplication());
    }
    if (("billdthumb".equals(paramString)) || ("billdimg".equals(paramString)))
    {
      if (this.d == null) {
        this.d = new LocalBilldDownloader(BaseApplicationImpl.getApplication());
      }
      return this.d;
    }
    if (("profile_img_big".equals(paramString)) || ("profile_img_thumb".equals(paramString)) || ("profile_img_icon".equals(paramString)))
    {
      if (this.e == null) {
        this.e = new ProfileImgDownloader();
      }
      return this.e;
    }
    if ("qzone_cover".equals(paramString)) {
      return new QZoneCoverDownloader();
    }
    if ("favimage".equals(paramString)) {
      return new FavoriteImageDownloader(BaseApplicationImpl.getApplication());
    }
    if ("fileassistantimage".equals(paramString)) {
      return new FileAssistantDownloader(BaseApplicationImpl.getApplication());
    }
    if ("troop_photo_qzone".equals(paramString)) {
      return new QZoneRecentPhotoDownloader();
    }
    if ("aiothumb".equals(paramString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileAIOPhotoImageDownloader == null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileAIOPhotoImageDownloader = new AIOPhotoImageDownloader(BaseApplicationImpl.getApplication());
      }
      return this.jdField_a_of_type_ComTencentMobileqqTransfileAIOPhotoImageDownloader;
    }
    if ("protocol_pendant_image".equals(paramString)) {
      return new AvatarPendantDownloader();
    }
    if (("file".equals(paramString)) && (BaseApplicationImpl.sApplication.getProcessName().endsWith(":peak"))) {
      return new PhotoDecoder(BaseApplicationImpl.getApplication());
    }
    if ("regionalthumb".equals(paramString)) {
      return new RegionalThumbDownloader(BaseApplicationImpl.getApplication());
    }
    if ("third_part".equals(paramString)) {
      return new ThirdPartAppIconDownloader(BaseApplicationImpl.getApplication());
    }
    if ("gamead".equals(paramString)) {
      return new LastModifySupportDownloader();
    }
    if ("shortvideothumb".equals(paramString)) {
      return new ShortVideoThumbDownloader();
    }
    if ("devicemsgthumb".equals(paramString)) {
      return new DeviceMsgThumbDownloader();
    }
    if ("carrier".equals(paramString)) {
      return new CarrierImgDownloader();
    }
    if ("aioflower".equals(paramString)) {
      return new AIOFlowerImgDownloader();
    }
    if (("sig_cover".equals(paramString)) || ("sig_zip".equals(paramString))) {
      return new SignatureTemplateDownloader();
    }
    if ("themediydownloader".equals(paramString)) {
      return new ThemeDIYDownloader();
    }
    if ("vasapngdownloader".equals(paramString)) {
      return new VasApngDownloader();
    }
    if ("funny_pic".equals(paramString)) {
      return new FunnyPicHelper.FunnyPicDownloader();
    }
    if ("redtouchpicdownloadprotoc".equals(paramString)) {
      return new RedTouchPicDownloader(BaseApplicationImpl.getApplication());
    }
    if ("protocol_vas_extension_image".equals(paramString)) {
      return new VasExtensionDownloader(BaseApplicationImpl.getApplication());
    }
    if ("apollo_pic".equals(paramString)) {
      return new ApolloDownloader(BaseApplicationImpl.getApplication());
    }
    if ("apollo_gif".equals(paramString)) {
      return new ApolloItemBuilder.ApolloGifDownloader();
    }
    if ("apollo_image".equals(paramString)) {
      return new ApolloImageDownloader();
    }
    if ("hot_pic".equals(paramString))
    {
      if (this.g == null) {
        this.g = new HotPicDownLoader();
      }
      return this.g;
    }
    if ("hot_pic_origin".equals(paramString)) {
      return new HotPicOriginDownLoader();
    }
    if ("hot_video_preview".equals(paramString))
    {
      if (this.h == null) {
        this.h = new HotVideoPreviewDownloader();
      }
      return this.h;
    }
    if ("readinjoy_skin_gif".equals(paramString)) {
      return new SkinGifImageDownloader();
    }
    if ("pubaccountimage_gifplaytime".equals(paramString)) {
      return new GifPlayTimeHttpDownloader(BaseApplicationImpl.getApplication());
    }
    return null;
  }
  
  protected String doGetLocalFilePath(String paramString)
  {
    return null;
  }
  
  protected Drawable getDefaultLoadingDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837615);
      return localDrawable;
    }
    catch (Throwable localThrowable) {}
    return new ColorDrawable(0);
  }
  
  protected Drawable getDefualtFailedDrawable()
  {
    try
    {
      Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837617);
      return localDrawable;
    }
    catch (Throwable localThrowable) {}
    return new ColorDrawable(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijx
 * JD-Core Version:    0.7.0.1
 */