import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.3;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.EmotionKeywordLayout;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class aewl
  extends BaseAdapter
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aexb jdField_a_of_type_Aexb;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  private URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new aewn(this);
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new aewm(this);
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmotionKeywordHorizonListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<URLDrawable> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<aewf> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<StickerRecCacheEntity> jdField_b_of_type_JavaUtilList = new ArrayList();
  private int jdField_c_of_type_Int;
  private List<aexh> jdField_c_of_type_JavaUtilList = new ArrayList();
  private int d;
  private int e;
  private int f;
  private int g;
  
  public aewl(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, EditText paramEditText, BaseChatPie paramBaseChatPie, EmotionKeywordHorizonListView paramEmotionKeywordHorizonListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Float * 7.0F));
    this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Float * 7.0F));
    this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_Float * 9.0F));
    this.d = ((int)(this.jdField_a_of_type_Float * 8.0F));
    this.e = ((int)(this.jdField_a_of_type_Float * 64.0F));
    this.f = ((int)(this.jdField_a_of_type_Float * 64.0F));
    this.g = ((int)(this.jdField_a_of_type_Float * 6.0F));
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramBaseActivity.getResources().getDrawable(2130838123);
    this.jdField_a_of_type_Aexb = aexb.a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = paramEmotionKeywordHorizonListView;
  }
  
  private int a(aewf paramaewf)
  {
    int i;
    if (paramaewf == null) {
      i = this.f;
    }
    int j;
    do
    {
      return i;
      if (aexb.a(paramaewf)) {
        return this.f;
      }
      if (!aexb.b(paramaewf)) {
        return this.f;
      }
      paramaewf = (aewv)paramaewf;
      float f1 = paramaewf.g();
      float f2 = paramaewf.h();
      float f3 = f1 / f2;
      if ((f3 > 1.777778F) || (f3 < 0.5625F)) {
        return this.f;
      }
      j = (int)(f1 * this.e / f2);
      i = j;
    } while (j != 0);
    return this.f;
  }
  
  @NotNull
  private URLDrawable.URLDrawableOptions a(aewf paramaewf)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramaewf.a();
    paramaewf = localURLDrawableOptions;
    if (localURLDrawableOptions == null) {
      paramaewf = URLDrawable.URLDrawableOptions.obtain();
    }
    paramaewf.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramaewf.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramaewf.mPlayGifImage = true;
    paramaewf.mGifRoundCorner = this.g;
    return paramaewf;
  }
  
  private void a(aewf paramaewf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "sendPic");
    }
    if (paramaewf == null) {}
    do
    {
      return;
      aexb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_JavaLangString);
      if (!aexb.a(paramaewf)) {
        break;
      }
      paramaewf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramaewf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    } while (paramaewf == null);
    paramaewf.sendMessage(paramaewf.obtainMessage(92));
    return;
    Object localObject1 = (aewv)paramaewf;
    Object localObject2 = new Intent();
    paramaewf = new ArrayList();
    paramaewf.add(((aewv)localObject1).l());
    ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramaewf);
    ((Intent)localObject2).putExtra("PicContants.NEED_COMPRESS", false);
    ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject2).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
    ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    ((Intent)localObject2).putExtra("send_in_background", true);
    ((Intent)localObject2).putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramaewf);
    ((Intent)localObject2).putExtra("PicContants.NEED_COMPRESS", false);
    ((Intent)localObject2).putExtra("quick_send_original_md5", ((aewv)localObject1).b());
    ((Intent)localObject2).putExtra("quick_send_original_size", ((aewv)localObject1).a());
    ((Intent)localObject2).putExtra("quick_send_thumb_md5", ((aewv)localObject1).f());
    ((Intent)localObject2).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1047);
    ((Intent)localObject2).putExtra("HOT_PIC_HAS_EXTRA", true);
    int i;
    if ((TextUtils.isEmpty(((aewv)localObject1).h())) || (((aewv)localObject1).h().length() <= 100))
    {
      i = 1;
      label327:
      if (i == 0) {
        break label659;
      }
      ((Intent)localObject2).putExtra("key_emotion_source_from", ((aewv)localObject1).e());
      ((Intent)localObject2).putExtra("key_emotion_source_info", ((aewv)localObject1).g());
      ((Intent)localObject2).putExtra("key_emotion_source_weburl", ((aewv)localObject1).h());
      ((Intent)localObject2).putExtra("key_emotion_source_iconurl", "");
      ((Intent)localObject2).putExtra("key_emotion_source_packagename", ((aewv)localObject1).i());
      ((Intent)localObject2).putExtra("key_emotion_source_epid", ((aewv)localObject1).f());
      label408:
      if (QLog.isColorLevel()) {
        QLog.i("StickerRecBarAdapter", 2, "md5:" + ((aewv)localObject1).b() + "srcfrom:" + ((aewv)localObject1).e() + ", desc:" + ((aewv)localObject1).g() + ", webUrl:" + ((aewv)localObject1).h() + ", pack:" + ((aewv)localObject1).i() + ", epid:" + ((aewv)localObject1).f());
      }
      if (!((adjf)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(41)).a()) {
        break label710;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
      localObject2 = banb.a((Editable)localObject1);
      ((asju)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramaewf, false, (String)((Pair)localObject2).first, (ArrayList)((Pair)localObject2).second, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo);
      aedx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localObject1.toString(), (ArrayList)((Pair)localObject2).second, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramaewf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (paramaewf == null) {
        break;
      }
      paramaewf.sendMessage(paramaewf.obtainMessage(92));
      return;
      i = 0;
      break label327;
      label659:
      axqy.b(null, "dc00898", "", "", "0X800A7EA", "0X800A7EA", 0, 0, "", "", "", "");
      if (!QLog.isColorLevel()) {
        break label408;
      }
      QLog.i("StickerRecBarAdapter", 2, "sendPic over limited!");
      break label408;
      label710:
      ThreadManager.post(new SendPhotoTask(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject2, null), 8, null, false);
    }
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    paramURLDrawable = paramURLDrawable.getURL();
    if (paramURLDrawable != null) {
      localHashMap.put("sticker_url", paramURLDrawable.toString());
    }
    axrn.a(BaseApplication.getContext()).a(null, "StickerRecImgLoad", false, 0L, 0L, localHashMap, "");
  }
  
  private void a(URLDrawable paramURLDrawable, long paramLong)
  {
    if (paramURLDrawable == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      localHashMap.put("first_sticker", String.valueOf(bool));
      paramURLDrawable = paramURLDrawable.getURL();
      if (paramURLDrawable != null) {
        localHashMap.put("sticker_url", paramURLDrawable.toString());
      }
      axrn.a(BaseApplication.getContext()).a(null, "StickerRecImgLoad", true, paramLong, 0L, localHashMap, "");
      return;
    }
  }
  
  private void c()
  {
    int j = 0;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_JavaUtilList.size() < 5) {}
    for (int i = this.jdField_a_of_type_JavaUtilList.size();; i = 5)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Boolean = false;
      if (j < i)
      {
        Object localObject = (aewf)this.jdField_a_of_type_JavaUtilList.get(j);
        if (localObject == null) {}
        for (;;)
        {
          j += 1;
          break;
          localObject = ((aewf)localObject).a(((aewf)localObject).a(), a((aewf)localObject));
          if (localObject != null)
          {
            ((URLDrawable)localObject).setDecodeHandler(bavw.i);
            ((URLDrawable)localObject).setURLDrawableListener(this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener);
            if (((URLDrawable)localObject).getStatus() != 1)
            {
              this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
              ((URLDrawable)localObject).addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
              ((URLDrawable)localObject).addHeader("emo_big", "true");
              ((URLDrawable)localObject).startDownload();
            }
            else
            {
              this.jdField_a_of_type_Boolean = true;
            }
          }
        }
      }
      a();
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aewf localaewf = (aewf)((Iterator)localObject).next();
        if (localaewf.c()) {
          localArrayList1.add(localaewf);
        } else {
          localArrayList2.add(localaewf);
        }
      }
      localObject = new aexh();
      ((aexh)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((aexh)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((aexh)localObject).jdField_a_of_type_JavaUtilList = localArrayList1;
      ((aexh)localObject).jdField_b_of_type_JavaUtilList = localArrayList2;
      this.jdField_c_of_type_JavaUtilList.add(localObject);
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_Aexb.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
    String str = ((adjf)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(41)).a();
    if (!TextUtils.isEmpty(str)) {
      localObject = str;
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase((String)localObject)))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localObject != null) {
          ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(69));
        }
      }
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecBarAdapter", 2, "showEmotionKeywordLayout isshow = " + bool);
        }
        return;
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<aewf> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      QLog.e("StickerRecBarAdapter", 1, "setData data is null or empty");
    }
    do
    {
      return;
      QLog.e("StickerRecBarAdapter", 1, "setData");
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilHashSet.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.resetCurrentX(0);
      c();
      notifyDataSetChanged();
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setData:");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aewf localaewf = (aewf)paramList.next();
      if (aexb.b(localaewf)) {
        localStringBuilder.append("thumb=").append(((aewv)localaewf).e()).append(",");
      }
    }
    QLog.d("StickerRecBarAdapter", 2, localStringBuilder.toString());
  }
  
  public void b()
  {
    try
    {
      d();
      ArrayList localArrayList1 = new ArrayList(this.jdField_c_of_type_JavaUtilList);
      ArrayList localArrayList2 = new ArrayList(this.jdField_b_of_type_JavaUtilList);
      ThreadManager.getFileThreadHandler().post(new StickerRecBarAdapter.3(this, localArrayList1, localArrayList2));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("StickerRecBarAdapter", 1, "reportData:", localThrowable);
      return;
    }
    finally
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
    {
      QLog.e("StickerRecBarAdapter", 2, "get view position exception , position = " + paramInt + ",size = " + this.jdField_a_of_type_JavaUtilList.size());
      return null;
    }
    Object localObject1 = (aewf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    label512:
    label528:
    boolean bool;
    if (paramView == null)
    {
      paramViewGroup = new aewp(null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = new EmojiStickerManager.EmotionKeywordLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      paramView = new ViewGroup.LayoutParams(-2, -2);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Int, this.d);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setId(2131367906);
      paramView = new RelativeLayout.LayoutParams(a((aewf)localObject1), this.e);
      paramView.addRule(13, -1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView, paramView);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130837704));
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(7, 2131367906);
      paramView.addRule(8, 2131367906);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131691991);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167006));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, paramView);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838117));
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(7, 2131367906);
      paramView.addRule(8, 2131367906);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, paramView);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView = ObjectAnimator.ofFloat(paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView, "alpha", new float[] { 0.0F, 1.0F });
      paramView.setDuration(300L);
      paramViewGroup.jdField_a_of_type_AndroidAnimationAnimator = paramView;
      paramView = paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout;
      paramView.setTag(paramViewGroup);
      if (localObject1 != null) {
        break label619;
      }
      QLog.e("StickerRecBarAdapter", 1, "getView stickerRec empty position = " + paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if (!(localObject1 instanceof aewq)) {
        break label951;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!(localObject1 instanceof aewz)) {
        break label963;
      }
      bool = ((aewz)localObject1).d();
    }
    for (;;)
    {
      label546:
      localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      if (bool) {}
      for (paramInt = 0;; paramInt = 8)
      {
        ((ImageView)localObject1).setVisibility(paramInt);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(this.jdField_a_of_type_JavaLangString);
        }
        return paramView;
        paramViewGroup = (aewp)paramView.getTag();
        int i = a((aewf)localObject1);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = i;
        break;
        label619:
        paramViewGroup.jdField_a_of_type_Aewf = ((aewf)localObject1);
        Object localObject2 = ((aewf)localObject1).a();
        if (localObject2 == null)
        {
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label512;
        }
        localObject2 = ((aewf)localObject1).a((URL)localObject2, a((aewf)localObject1));
        ((URLDrawable)localObject2).setDecodeHandler(bavw.i);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setTag(localObject1);
        if (((URLDrawable)localObject2).getStatus() != 1)
        {
          ((URLDrawable)localObject2).addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          ((URLDrawable)localObject2).addHeader("emo_big", "true");
          ((URLDrawable)localObject2).addHeader("report_key_start_download", String.valueOf(System.currentTimeMillis()));
          if ((((URLDrawable)localObject2).getStatus() == 2) || (((URLDrawable)localObject2).getStatus() == 3)) {
            ((URLDrawable)localObject2).restartDownload();
          }
        }
        for (;;)
        {
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setFocusable(true);
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setFocusableInTouchMode(true);
          if (aexb.b((aewf)localObject1))
          {
            ((aewv)localObject1).a(true);
            if (QLog.isColorLevel()) {
              QLog.e("StickerRecBarAdapter", 2, "md5:" + ((aewv)localObject1).b());
            }
          }
          paramView.setOnClickListener(this);
          paramViewGroup.jdField_a_of_type_AndroidAnimationAnimator.start();
          break;
          if ((aexb.b((aewf)localObject1)) && (!this.jdField_a_of_type_JavaUtilHashSet.contains(((aewv)localObject1).j())))
          {
            this.jdField_a_of_type_JavaUtilHashSet.add(((aewv)localObject1).j());
            String str = ((aewv)localObject1).l();
            this.jdField_b_of_type_JavaUtilList.add(new StickerRecCacheEntity(str, System.currentTimeMillis(), ((aewv)localObject1).j()));
          }
        }
        label951:
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label528;
        label963:
        if (!(localObject1 instanceof aewx)) {
          break label990;
        }
        bool = ((aewx)localObject1).d();
        break label546;
      }
      label990:
      bool = false;
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "onClick");
    }
    Object localObject = paramView.getTag();
    paramView = null;
    if ((localObject instanceof aewp)) {
      paramView = (aewp)localObject;
    }
    if (paramView == null) {}
    label38:
    do
    {
      do
      {
        do
        {
          break label38;
          do
          {
            return;
          } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) || (!(paramView.jdField_a_of_type_ComTencentImageURLImageView.getDrawable() instanceof URLDrawable)));
          if (((URLDrawable)paramView.jdField_a_of_type_ComTencentImageURLImageView.getDrawable()).getStatus() != 1) {
            break label157;
          }
          if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
            break;
          }
          a(paramView.jdField_a_of_type_Aewf);
          this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().clear();
          this.jdField_a_of_type_AndroidWidgetEditText.setText("");
        } while (!aexb.b(paramView.jdField_a_of_type_Aewf));
        ((aewv)paramView.jdField_a_of_type_Aewf).b(true);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("StickerRecBarAdapter", 2, "onClick input == null");
      return;
    } while (!QLog.isColorLevel());
    label157:
    QLog.e("StickerRecBarAdapter", 2, "onClick:URLDrawable status != successed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aewl
 * JD-Core Version:    0.7.0.1
 */