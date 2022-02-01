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
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.EmotionKeywordLayout;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class aiiz
  extends BaseAdapter
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aijp jdField_a_of_type_Aijp;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  private URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new aijb(this);
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new aija(this);
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmotionKeywordHorizonListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<URLDrawable> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<aiit> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<StickerRecCacheEntity> jdField_b_of_type_JavaUtilList = new ArrayList();
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private List<aijw> jdField_c_of_type_JavaUtilList = new ArrayList();
  private int d;
  private int e;
  private int f;
  private int g;
  private int h = 0;
  
  public aiiz(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, EditText paramEditText, BaseChatPie paramBaseChatPie, EmotionKeywordHorizonListView paramEmotionKeywordHorizonListView)
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
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramBaseActivity.getResources().getDrawable(2130838293);
    this.jdField_a_of_type_Aijp = aijp.a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = paramEmotionKeywordHorizonListView;
  }
  
  private int a(aiit paramaiit)
  {
    int i;
    if (paramaiit == null) {
      i = this.f;
    }
    int j;
    do
    {
      return i;
      if (aijp.a(paramaiit)) {
        return this.f;
      }
      if (!aijp.b(paramaiit)) {
        return this.f;
      }
      paramaiit = (aijj)paramaiit;
      float f1 = paramaiit.g();
      float f2 = paramaiit.h();
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
  private URLDrawable.URLDrawableOptions a(aiit paramaiit)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramaiit.a();
    paramaiit = localURLDrawableOptions;
    if (localURLDrawableOptions == null) {
      paramaiit = URLDrawable.URLDrawableOptions.obtain();
    }
    paramaiit.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramaiit.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramaiit.mPlayGifImage = true;
    paramaiit.mGifRoundCorner = this.g;
    return paramaiit;
  }
  
  private void a(aiit paramaiit)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "sendPic");
    }
    if (paramaiit == null) {}
    do
    {
      return;
      localObject2 = this.jdField_a_of_type_JavaLangString;
      localObject1 = localObject2;
      if (this.h == 1)
      {
        aiki localaiki = ScenesRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localaiki != null) {
          localObject1 = localaiki.c();
        }
      }
      aijp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((String)localObject1);
      if (!aijp.a(paramaiit)) {
        break;
      }
      paramaiit.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramaiit = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    } while (paramaiit == null);
    paramaiit.sendMessage(paramaiit.obtainMessage(92));
    return;
    Object localObject1 = (aijj)paramaiit;
    Object localObject2 = new Intent();
    paramaiit = new ArrayList();
    paramaiit.add(((aijj)localObject1).l());
    ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramaiit);
    ((Intent)localObject2).putExtra("PicContants.NEED_COMPRESS", false);
    ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject2).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
    ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    ((Intent)localObject2).putExtra("send_in_background", true);
    ((Intent)localObject2).putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramaiit);
    ((Intent)localObject2).putExtra("PicContants.NEED_COMPRESS", false);
    ((Intent)localObject2).putExtra("quick_send_original_md5", ((aijj)localObject1).c());
    ((Intent)localObject2).putExtra("quick_send_original_size", ((aijj)localObject1).a());
    ((Intent)localObject2).putExtra("quick_send_thumb_md5", ((aijj)localObject1).f());
    ((Intent)localObject2).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1047);
    ((Intent)localObject2).putExtra("HOT_PIC_HAS_EXTRA", true);
    int i;
    if ((TextUtils.isEmpty(((aijj)localObject1).h())) || (((aijj)localObject1).h().length() <= 100))
    {
      i = 1;
      label374:
      if (i == 0) {
        break label706;
      }
      ((Intent)localObject2).putExtra("key_emotion_source_from", ((aijj)localObject1).e());
      ((Intent)localObject2).putExtra("key_emotion_source_info", ((aijj)localObject1).g());
      ((Intent)localObject2).putExtra("key_emotion_source_weburl", ((aijj)localObject1).h());
      ((Intent)localObject2).putExtra("key_emotion_source_iconurl", "");
      ((Intent)localObject2).putExtra("key_emotion_source_packagename", ((aijj)localObject1).i());
      ((Intent)localObject2).putExtra("key_emotion_source_epid", ((aijj)localObject1).f());
      label455:
      if (QLog.isColorLevel()) {
        QLog.i("StickerRecBarAdapter", 2, "md5:" + ((aijj)localObject1).c() + "srcfrom:" + ((aijj)localObject1).e() + ", desc:" + ((aijj)localObject1).g() + ", webUrl:" + ((aijj)localObject1).h() + ", pack:" + ((aijj)localObject1).i() + ", epid:" + ((aijj)localObject1).f());
      }
      if (!((agnj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(41)).a()) {
        break label757;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
      localObject2 = bfup.a((Editable)localObject1);
      ((awmg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramaiit, false, (String)((Pair)localObject2).first, (ArrayList)((Pair)localObject2).second, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo);
      ahmp.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localObject1.toString(), (ArrayList)((Pair)localObject2).second, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramaiit = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (paramaiit == null) {
        break;
      }
      paramaiit.sendMessage(paramaiit.obtainMessage(92));
      return;
      i = 0;
      break label374;
      label706:
      bcst.b(null, "dc00898", "", "", "0X800A7EA", "0X800A7EA", 0, 0, "", "", "", "");
      if (!QLog.isColorLevel()) {
        break label455;
      }
      QLog.i("StickerRecBarAdapter", 2, "sendPic over limited!");
      break label455;
      label757:
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
    bctj.a(BaseApplication.getContext()).a(null, "StickerRecImgLoad", false, 0L, 0L, localHashMap, "");
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
      bctj.a(BaseApplication.getContext()).a(null, "StickerRecImgLoad", true, paramLong, 0L, localHashMap, "");
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
        Object localObject = (aiit)this.jdField_a_of_type_JavaUtilList.get(j);
        if (localObject == null) {}
        for (;;)
        {
          j += 1;
          break;
          localObject = ((aiit)localObject).a(((aiit)localObject).a(), a((aiit)localObject));
          if (localObject != null)
          {
            ((URLDrawable)localObject).setDecodeHandler(bgey.j);
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
        aiit localaiit = (aiit)((Iterator)localObject).next();
        if (localaiit.c()) {
          localArrayList1.add(localaiit);
        } else {
          localArrayList2.add(localaiit);
        }
      }
      localObject = new aijw();
      ((aijw)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((aijw)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((aijw)localObject).jdField_a_of_type_JavaUtilList = localArrayList1;
      ((aijw)localObject).jdField_b_of_type_JavaUtilList = localArrayList2;
      ((aijw)localObject).jdField_a_of_type_Int = this.h;
      this.jdField_c_of_type_JavaUtilList.add(localObject);
    }
  }
  
  public void a()
  {
    boolean bool2 = true;
    if (((agnk)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(14)).c()) {
      return;
    }
    boolean bool1;
    label34:
    Object localObject;
    if (this.h == 1)
    {
      bool1 = this.jdField_a_of_type_Boolean;
      if (bool1)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        bool1 = bool2;
        if (localObject != null)
        {
          ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(69, this.jdField_c_of_type_JavaLangString));
          bool1 = bool2;
        }
        label71:
        if (!QLog.isColorLevel()) {
          break label181;
        }
        QLog.d("StickerRecBarAdapter", 2, "showEmotionKeywordLayout isshow = " + bool1);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_Aijp.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      String str = ((agnj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(41)).a();
      if (TextUtils.isEmpty(str)) {
        break label183;
      }
      localObject = str;
    }
    label181:
    label183:
    for (;;)
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase((String)localObject)))
      {
        bool1 = true;
        break label34;
      }
      bool1 = false;
      break label34;
      bool1 = false;
      break label71;
      break;
    }
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<aiit> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      QLog.e("StickerRecBarAdapter", 1, "setData data is null or empty");
    }
    do
    {
      return;
      ((agnk)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(14)).c();
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
      aiit localaiit = (aiit)paramList.next();
      if (aijp.b(localaiit)) {
        localStringBuilder.append("thumb=").append(((aijj)localaiit).b()).append(",");
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
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void c(String paramString)
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
    Object localObject1;
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
    {
      QLog.e("StickerRecBarAdapter", 2, "get view position exception , position = " + paramInt + ",size = " + this.jdField_a_of_type_JavaUtilList.size());
      localObject1 = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    Object localObject2 = (aiit)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    label513:
    label556:
    label573:
    boolean bool;
    if (paramView == null)
    {
      localObject1 = new aijd(null);
      ((aijd)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = new EmojiStickerManager.EmotionKeywordLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      paramView = new ViewGroup.LayoutParams(-2, -2);
      ((aijd)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      ((aijd)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Int, this.d);
      ((aijd)localObject1).jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((aijd)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      ((aijd)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setId(2131368378);
      paramView = new RelativeLayout.LayoutParams(a((aiit)localObject2), this.e);
      paramView.addRule(13, -1);
      ((aijd)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((aijd)localObject1).jdField_a_of_type_ComTencentImageURLImageView, paramView);
      ((aijd)localObject1).jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((aijd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130837991));
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(7, 2131368378);
      paramView.addRule(8, 2131368378);
      ((aijd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131691702);
      ((aijd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167143));
      ((aijd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      ((aijd)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((aijd)localObject1).jdField_a_of_type_AndroidWidgetTextView, paramView);
      ((aijd)localObject1).jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((aijd)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838287));
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(7, 2131368378);
      paramView.addRule(8, 2131368378);
      ((aijd)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((aijd)localObject1).jdField_a_of_type_AndroidWidgetImageView, paramView);
      ((aijd)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramView = ObjectAnimator.ofFloat(((aijd)localObject1).jdField_a_of_type_ComTencentImageURLImageView, "alpha", new float[] { 0.0F, 1.0F });
      paramView.setDuration(300L);
      ((aijd)localObject1).jdField_a_of_type_AndroidAnimationAnimator = paramView;
      paramView = ((aijd)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout;
      paramView.setTag(localObject1);
      if (localObject2 != null) {
        break label674;
      }
      QLog.e("StickerRecBarAdapter", 1, "getView stickerRec empty position = " + paramInt);
      ((aijd)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if (!(localObject2 instanceof aije)) {
        break label1014;
      }
      ((aijd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!(localObject2 instanceof aijn)) {
        break label1027;
      }
      bool = ((aijn)localObject2).d();
    }
    for (;;)
    {
      label591:
      localObject2 = ((aijd)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      if (bool) {}
      for (int i = 0;; i = 8)
      {
        ((ImageView)localObject2).setVisibility(i);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          ((aijd)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(this.jdField_a_of_type_JavaLangString);
        }
        localObject1 = paramView;
        break;
        localObject1 = (aijd)paramView.getTag();
        i = a((aiit)localObject2);
        ((aijd)localObject1).jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = i;
        break label513;
        label674:
        ((aijd)localObject1).jdField_a_of_type_Aiit = ((aiit)localObject2);
        Object localObject3 = ((aiit)localObject2).a();
        if (localObject3 == null)
        {
          ((aijd)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label556;
        }
        localObject3 = ((aiit)localObject2).a((URL)localObject3, a((aiit)localObject2));
        ((URLDrawable)localObject3).setDecodeHandler(bgey.j);
        ((aijd)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setTag(localObject2);
        if (((URLDrawable)localObject3).getStatus() != 1)
        {
          ((URLDrawable)localObject3).addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
          ((URLDrawable)localObject3).addHeader("emo_big", "true");
          ((URLDrawable)localObject3).addHeader("report_key_start_download", String.valueOf(System.currentTimeMillis()));
          if ((((URLDrawable)localObject3).getStatus() == 2) || (((URLDrawable)localObject3).getStatus() == 3)) {
            ((URLDrawable)localObject3).restartDownload();
          }
        }
        for (;;)
        {
          ((aijd)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject3);
          ((aijd)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
          ((aijd)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setFocusable(true);
          ((aijd)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setFocusableInTouchMode(true);
          if (aijp.b((aiit)localObject2))
          {
            ((aijj)localObject2).a(true);
            if (QLog.isColorLevel()) {
              QLog.e("StickerRecBarAdapter", 2, "md5:" + ((aijj)localObject2).c());
            }
          }
          paramView.setOnClickListener(this);
          ((aijd)localObject1).jdField_a_of_type_AndroidAnimationAnimator.start();
          break;
          if ((aijp.b((aiit)localObject2)) && (!this.jdField_a_of_type_JavaUtilHashSet.contains(((aijj)localObject2).j())))
          {
            this.jdField_a_of_type_JavaUtilHashSet.add(((aijj)localObject2).j());
            String str = ((aijj)localObject2).l();
            this.jdField_b_of_type_JavaUtilList.add(new StickerRecCacheEntity(str, System.currentTimeMillis(), ((aijj)localObject2).j()));
          }
        }
        label1014:
        ((aijd)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label573;
        label1027:
        if (!(localObject2 instanceof aijl)) {
          break label1055;
        }
        bool = ((aijl)localObject2).d();
        break label591;
      }
      label1055:
      bool = false;
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "onClick");
    }
    Object localObject = paramView.getTag();
    aijd localaijd = null;
    if ((localObject instanceof aijd)) {
      localaijd = (aijd)localObject;
    }
    if (localaijd == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 9501) && ((localaijd.jdField_a_of_type_ComTencentImageURLImageView.getDrawable() instanceof URLDrawable))) {
        if (((URLDrawable)localaijd.jdField_a_of_type_ComTencentImageURLImageView.getDrawable()).getStatus() == 1)
        {
          if (this.jdField_a_of_type_AndroidWidgetEditText != null)
          {
            a(localaijd.jdField_a_of_type_Aiit);
            this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().clear();
            this.jdField_a_of_type_AndroidWidgetEditText.setText("");
            if (aijp.b(localaijd.jdField_a_of_type_Aiit)) {
              ((aijj)localaijd.jdField_a_of_type_Aiit).b(true);
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.e("StickerRecBarAdapter", 2, "onClick input == null");
          }
        }
        else if (QLog.isColorLevel()) {
          QLog.e("StickerRecBarAdapter", 2, "onClick:URLDrawable status != successed");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiiz
 * JD-Core Version:    0.7.0.1
 */