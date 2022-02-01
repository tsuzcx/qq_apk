import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.QCircleFeedItemBuilder.2;
import com.tencent.mobileqq.activity.aio.item.QCircleFeedItemBuilder.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.data.MessageForQCircleFeed.MediaData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.picload.Option;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ahdl
  extends afor
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static RFWMultiDownloadHelper jdField_a_of_type_ComTencentBizRichframeworkDownloadRFWMultiDownloadHelper = new RFWMultiDownloadHelper();
  private static int j = -1;
  private final int jdField_a_of_type_Int;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  
  static
  {
    jdField_a_of_type_ComTencentBizRichframeworkDownloadRFWMultiDownloadHelper.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/pic/background/img_aio_tofu_ark_bg.9.png", QCircleConfig.getDownloadStrategy()));
    jdField_a_of_type_ComTencentBizRichframeworkDownloadRFWMultiDownloadHelper.start();
  }
  
  public ahdl(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    paramBaseAdapter = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_Int = AIOUtils.dp2px(227.0F, paramBaseAdapter);
    this.c = AIOUtils.dp2px(128.0F, paramBaseAdapter);
    this.d = AIOUtils.dp2px(129.0F, paramBaseAdapter);
    this.jdField_e_of_type_Int = AIOUtils.dp2px(128.0F, paramBaseAdapter);
    this.f = AIOUtils.dp2px(98.0F, paramBaseAdapter);
    this.g = AIOUtils.dp2px(64.0F, paramBaseAdapter);
    this.h = AIOUtils.dp2px(4.0F, paramBaseAdapter);
    this.i = QzoneConfig.getInstance().getConfig("QZoneSetting", "qzoneAioFriendFeedNicknameMaxLength", 10);
    paramQQAppInterface = (afqy)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 12);
    }
  }
  
  private int a(MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    if (paramMessageForQCircleFeed.mediaDatas != null)
    {
      if (paramMessageForQCircleFeed.mediaDatas.size() >= 3) {
        return 2;
      }
      return 1;
    }
    return 0;
  }
  
  private Drawable a(Resources paramResources, String paramString)
  {
    paramString = SafeBitmapFactory.decodeFile(paramString);
    byte[] arrayOfByte = paramString.getNinePatchChunk();
    if (NinePatch.isNinePatchChunk(arrayOfByte)) {
      return new NinePatchDrawable(paramResources, paramString, arrayOfByte, new Rect(), null);
    }
    return new BitmapDrawable(paramResources, paramString);
  }
  
  private View a(View paramView, ahdo paramahdo)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558878, null);
      paramahdo.jdField_b_of_type_AndroidViewView = paramView;
      paramahdo.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362451);
      paramahdo.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362460));
      paramahdo.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362452));
      localView = paramView;
      if (jdField_e_of_type_Boolean)
      {
        paramahdo.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (jdField_e_of_type_Boolean)
    {
      localView.setContentDescription(null);
      paramahdo.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramahdo.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localView;
  }
  
  private static String a(long paramLong)
  {
    return vvx.a(paramLong);
  }
  
  private void a(ahdo paramahdo, int paramInt)
  {
    if (paramahdo == null) {
      return;
    }
    if (paramInt <= 0)
    {
      paramahdo.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    paramahdo.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramahdo.jdField_d_of_type_AndroidWidgetTextView.setText(a(paramInt));
  }
  
  private void a(ahdo paramahdo, MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    switch (a(paramMessageForQCircleFeed))
    {
    }
    for (;;)
    {
      paramMessageForQCircleFeed = bhbx.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, this.i);
      paramahdo.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131697696, new Object[] { paramMessageForQCircleFeed }));
      paramahdo.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramMessageForQCircleFeed = RFWDownloaderFactory.getDownloader(QCircleConfig.getDownloadStrategy()).getDefaultSavePath("https://downv6.qq.com/video_story/qcircle/pic/background/img_aio_tofu_ark_bg.9.png");
      if (!FileUtils.fileExistsAndNotEmpty(paramMessageForQCircleFeed)) {
        break label159;
      }
      if (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        break;
      }
      a(paramahdo.jdField_c_of_type_AndroidViewView);
      return;
      b(paramahdo, paramMessageForQCircleFeed);
      continue;
      c(paramahdo, paramMessageForQCircleFeed);
    }
    ThreadManager.getFileThreadHandler().post(new QCircleFeedItemBuilder.2(this, paramMessageForQCircleFeed, paramahdo));
    paramahdo.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838259);
    return;
    label159:
    paramahdo.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130838259);
  }
  
  private void a(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    paramView.setBackgroundDrawable(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
  
  private void b()
  {
    String str = RFWDownloaderFactory.getDownloader(QCircleConfig.getDownloadStrategy()).getDefaultSavePath("https://downv6.qq.com/video_story/qcircle/pic/background/img_aio_tofu_ark_bg.9.png");
    if (FileUtils.fileExistsAndNotEmpty(str)) {
      ThreadManager.getFileThreadHandler().post(new QCircleFeedItemBuilder.4(this, str));
    }
  }
  
  private void b(ahdo paramahdo, int paramInt)
  {
    if (paramahdo == null) {
      return;
    }
    if (paramInt <= 0)
    {
      paramahdo.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    paramahdo.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramahdo.jdField_e_of_type_AndroidWidgetTextView.setText(a(paramInt));
  }
  
  private void b(ahdo paramahdo, MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    if ((paramMessageForQCircleFeed.mediaDatas == null) || (paramMessageForQCircleFeed.mediaDatas.size() == 0)) {
      return;
    }
    MessageForQCircleFeed.MediaData localMediaData = (MessageForQCircleFeed.MediaData)paramMessageForQCircleFeed.mediaDatas.get(0);
    if (QLog.isColorLevel()) {
      QLog.d("QCircleFeedItemBuilder", 2, "setDataToSinglePicContainer picUrl= " + localMediaData.mediaUrl);
    }
    Object localObject2 = paramMessageForQCircleFeed.coverImageUrl;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = localMediaData.mediaUrl;
    }
    if (paramahdo.jdField_e_of_type_AndroidViewView != null) {
      paramahdo.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramahdo.jdField_d_of_type_AndroidViewView == null)
    {
      paramahdo.jdField_d_of_type_AndroidViewView = ((ViewStub)paramahdo.jdField_b_of_type_AndroidViewView.findViewById(2131362461)).inflate();
      paramahdo.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramahdo.jdField_b_of_type_AndroidViewView.findViewById(2131362453));
      paramahdo.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramahdo.jdField_b_of_type_AndroidViewView.findViewById(2131362462));
      paramahdo.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramahdo.jdField_b_of_type_AndroidViewView.findViewById(2131362449));
      paramahdo.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramahdo.jdField_b_of_type_AndroidViewView.findViewById(2131362464));
      paramahdo.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramahdo.jdField_b_of_type_AndroidViewView.findViewById(2131362448));
      paramahdo.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramahdo.jdField_b_of_type_AndroidViewView.findViewById(2131362463));
      zpz.a(paramahdo.jdField_d_of_type_AndroidWidgetTextView, false);
      zpz.a(paramahdo.jdField_e_of_type_AndroidWidgetTextView, false);
    }
    paramahdo.jdField_d_of_type_AndroidViewView.setVisibility(0);
    if (!TextUtils.isEmpty(paramMessageForQCircleFeed.content)) {
      paramahdo.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQCircleFeed.content);
    }
    a(paramahdo, paramMessageForQCircleFeed.pushCount);
    b(paramahdo, paramMessageForQCircleFeed.likeCount);
    localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_Int;
    ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.c;
    a(paramahdo.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, (String)localObject1, (URLDrawable.URLDrawableOptions)localObject2, new float[] { this.h, this.h, this.h, this.h, this.h, this.h, this.h, this.h });
    paramahdo = paramahdo.jdField_a_of_type_AndroidWidgetImageView;
    if (paramMessageForQCircleFeed.type == 3) {}
    for (int k = 0;; k = 8)
    {
      paramahdo.setVisibility(k);
      QLog.d("QCircleFeedItemBuilder", 2, "message.pushCount=" + paramMessageForQCircleFeed.pushCount + ",message.likecount=" + paramMessageForQCircleFeed.likeCount);
      return;
    }
  }
  
  private void c(ahdo paramahdo, MessageForQCircleFeed paramMessageForQCircleFeed)
  {
    if ((paramMessageForQCircleFeed.mediaDatas == null) || (paramMessageForQCircleFeed.mediaDatas.size() < 3)) {
      return;
    }
    String str1 = ((MessageForQCircleFeed.MediaData)paramMessageForQCircleFeed.mediaDatas.get(0)).mediaUrl;
    String str2 = ((MessageForQCircleFeed.MediaData)paramMessageForQCircleFeed.mediaDatas.get(1)).mediaUrl;
    String str3 = ((MessageForQCircleFeed.MediaData)paramMessageForQCircleFeed.mediaDatas.get(2)).mediaUrl;
    if (paramahdo.jdField_d_of_type_AndroidViewView != null) {
      paramahdo.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
    if (paramahdo.jdField_e_of_type_AndroidViewView == null)
    {
      paramahdo.jdField_e_of_type_AndroidViewView = ((ViewStub)paramahdo.jdField_b_of_type_AndroidViewView.findViewById(2131362459)).inflate();
      paramahdo.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramahdo.jdField_b_of_type_AndroidViewView.findViewById(2131362454));
      paramahdo.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramahdo.jdField_b_of_type_AndroidViewView.findViewById(2131362456));
      paramahdo.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramahdo.jdField_b_of_type_AndroidViewView.findViewById(2131362455));
      paramahdo.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramahdo.jdField_b_of_type_AndroidViewView.findViewById(2131362449));
      paramahdo.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramahdo.jdField_b_of_type_AndroidViewView.findViewById(2131362464));
      paramahdo.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramahdo.jdField_b_of_type_AndroidViewView.findViewById(2131362448));
      paramahdo.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramahdo.jdField_b_of_type_AndroidViewView.findViewById(2131362463));
      zpz.a(paramahdo.jdField_d_of_type_AndroidWidgetTextView, false);
      zpz.a(paramahdo.jdField_e_of_type_AndroidWidgetTextView, false);
    }
    paramahdo.jdField_e_of_type_AndroidViewView.setVisibility(0);
    if (!TextUtils.isEmpty(paramMessageForQCircleFeed.content)) {
      paramahdo.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageForQCircleFeed.content);
    }
    a(paramahdo, paramMessageForQCircleFeed.pushCount);
    b(paramahdo, paramMessageForQCircleFeed.likeCount);
    URLDrawable.URLDrawableOptions localURLDrawableOptions1 = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions1.mRequestWidth = this.d;
    localURLDrawableOptions1.mRequestHeight = this.jdField_e_of_type_Int;
    URLDrawable.URLDrawableOptions localURLDrawableOptions2 = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions2.mRequestWidth = this.f;
    localURLDrawableOptions2.mRequestHeight = this.g;
    a(paramahdo.jdField_b_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, str1, localURLDrawableOptions1, new float[] { this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F, this.h, this.h });
    a(paramahdo.jdField_c_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, str2, localURLDrawableOptions2, new float[] { 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F, 0.0F, 0.0F });
    a(paramahdo.jdField_d_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView, str3, localURLDrawableOptions2, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, this.h, this.h, 0.0F, 0.0F });
    QLog.d("QCircleFeedItemBuilder", 2, "message.pushCount=" + paramMessageForQCircleFeed.pushCount + ",message.likecount=" + paramMessageForQCircleFeed.likeCount);
  }
  
  protected afos a()
  {
    return new ahdo(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCircleFeedItemBuilder", 2, "getItemView: invoked. info: message = " + paramMessageRecord);
    }
    b();
    paramMessageRecord = (MessageForQCircleFeed)paramMessageRecord;
    paramafos = (ahdo)paramafos;
    paramView = a(paramView, paramafos);
    paramafos.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramafos.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    paramafos.jdField_b_of_type_JavaLangString = null;
    a(paramafos, paramMessageRecord);
    paramafos.jdField_c_of_type_AndroidViewView.setOnClickListener(new ahdm(this, paramMessageRecord));
    return paramView;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  protected void a(CornerImageView paramCornerImageView, String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions, float[] paramArrayOfFloat)
  {
    paramCornerImageView.setRadius(paramArrayOfFloat);
    paramCornerImageView = new Option().setUrl(paramString).setTargetView(paramCornerImageView).setFromPreLoad(false).setPredecode(true).setRequestWidth(paramURLDrawableOptions.mRequestWidth).setRequestHeight(paramURLDrawableOptions.mRequestHeight);
    QCircleFeedPicLoader.g().loadImage(paramCornerImageView, new ahdn(this));
  }
  
  public bhjs[] a(View paramView)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdl
 * JD-Core Version:    0.7.0.1
 */