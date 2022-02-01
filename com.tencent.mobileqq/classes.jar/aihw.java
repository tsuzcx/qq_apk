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
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.3;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.EmotionKeywordLayout;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.StringUtil;
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
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aihw
  extends BaseAdapter
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aiin jdField_a_of_type_Aiin;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  private URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new aihy(this);
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new aihx(this);
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmotionKeywordHorizonListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<URLDrawable> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<aihq> jdField_a_of_type_JavaUtilList;
  private CopyOnWriteArrayList<ahpd> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<StickerRecCacheEntity> jdField_b_of_type_JavaUtilList = new ArrayList();
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private List<aiiv> jdField_c_of_type_JavaUtilList = new ArrayList();
  private int d;
  private int e;
  private int f;
  private int g;
  private int h = 0;
  
  public aihw(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, EditText paramEditText, BaseChatPie paramBaseChatPie, EmotionKeywordHorizonListView paramEmotionKeywordHorizonListView)
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramBaseActivity.getResources().getDrawable(2130838341);
    this.jdField_a_of_type_Aiin = aiin.a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = paramEmotionKeywordHorizonListView;
  }
  
  private int a(aihq paramaihq)
  {
    int i;
    if (paramaihq == null) {
      i = this.f;
    }
    int j;
    do
    {
      return i;
      if (aiin.a(paramaihq)) {
        return this.f;
      }
      if (!aiin.b(paramaihq)) {
        return this.f;
      }
      paramaihq = (aiig)paramaihq;
      float f1 = paramaihq.g();
      float f2 = paramaihq.h();
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
  private URLDrawable.URLDrawableOptions a(aihq paramaihq)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramaihq.a();
    paramaihq = localURLDrawableOptions;
    if (localURLDrawableOptions == null) {
      paramaihq = URLDrawable.URLDrawableOptions.obtain();
    }
    paramaihq.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramaihq.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramaihq.mPlayGifImage = true;
    paramaihq.mGifRoundCorner = this.g;
    return paramaihq;
  }
  
  private void a(aihq paramaihq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "sendPic");
    }
    if (paramaihq == null) {}
    do
    {
      return;
      localObject2 = this.jdField_a_of_type_JavaLangString;
      localObject1 = localObject2;
      if (this.h == 1)
      {
        aijh localaijh = ScenesRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localaijh != null) {
          localObject1 = localaijh.c();
        }
      }
      aiin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a((String)localObject1);
      if (!aiin.a(paramaihq)) {
        break;
      }
      paramaihq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo);
      paramaihq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    } while (paramaihq == null);
    paramaihq.sendMessage(paramaihq.obtainMessage(92));
    return;
    Object localObject1 = (aiig)paramaihq;
    Object localObject2 = new Intent();
    paramaihq = new ArrayList();
    paramaihq.add(((aiig)localObject1).m());
    ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramaihq);
    ((Intent)localObject2).putExtra("PicContants.NEED_COMPRESS", false);
    ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    ((Intent)localObject2).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    ((Intent)localObject2).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin);
    ((Intent)localObject2).putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.topicId);
    ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    ((Intent)localObject2).putExtra("send_in_background", true);
    ((Intent)localObject2).putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramaihq);
    ((Intent)localObject2).putExtra("PicContants.NEED_COMPRESS", false);
    ((Intent)localObject2).putExtra("quick_send_original_md5", ((aiig)localObject1).c());
    ((Intent)localObject2).putExtra("quick_send_original_size", ((aiig)localObject1).b());
    ((Intent)localObject2).putExtra("quick_send_thumb_md5", ((aiig)localObject1).g());
    ((Intent)localObject2).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1047);
    ((Intent)localObject2).putExtra("HOT_PIC_HAS_EXTRA", true);
    int i;
    if ((TextUtils.isEmpty(((aiig)localObject1).i())) || (((aiig)localObject1).i().length() <= 100))
    {
      i = 1;
      label374:
      if (i == 0) {
        break label706;
      }
      ((Intent)localObject2).putExtra("key_emotion_source_from", ((aiig)localObject1).e());
      ((Intent)localObject2).putExtra("key_emotion_source_info", ((aiig)localObject1).h());
      ((Intent)localObject2).putExtra("key_emotion_source_weburl", ((aiig)localObject1).i());
      ((Intent)localObject2).putExtra("key_emotion_source_iconurl", "");
      ((Intent)localObject2).putExtra("key_emotion_source_packagename", ((aiig)localObject1).j());
      ((Intent)localObject2).putExtra("key_emotion_source_epid", ((aiig)localObject1).f());
      label455:
      if (QLog.isColorLevel()) {
        QLog.i("StickerRecBarAdapter", 2, "md5:" + ((aiig)localObject1).c() + "srcfrom:" + ((aiig)localObject1).e() + ", desc:" + ((aiig)localObject1).h() + ", webUrl:" + ((aiig)localObject1).i() + ", pack:" + ((aiig)localObject1).j() + ", epid:" + ((aiig)localObject1).f());
      }
      if (!((agkh)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(41)).a()) {
        break label757;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getEditableText();
      localObject2 = TroopUtils.getSendMsg((Editable)localObject1);
      ((awyg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramaihq, false, (String)((Pair)localObject2).first, (ArrayList)((Pair)localObject2).second, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mSourceMsgInfo);
      ahll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localObject1.toString(), (ArrayList)((Pair)localObject2).second, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    }
    for (;;)
    {
      paramaihq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (paramaihq == null) {
        break;
      }
      paramaihq.sendMessage(paramaihq.obtainMessage(92));
      return;
      i = 0;
      break label374;
      label706:
      bdla.b(null, "dc00898", "", "", "0X800A7EA", "0X800A7EA", 0, 0, "", "", "", "");
      if (!QLog.isColorLevel()) {
        break label455;
      }
      QLog.i("StickerRecBarAdapter", 2, "sendPic over limited!");
      break label455;
      label757:
      ThreadManager.post(new SendPhotoTask(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject2, null), 8, null, false);
    }
  }
  
  private void a(aiia paramaiia)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramaiia.jdField_a_of_type_Ahpd)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramaiia.jdField_a_of_type_Ahpd);
      }
      return;
    }
  }
  
  private void a(aiia paramaiia, aiig paramaiig)
  {
    if (paramaiig == null) {}
    label100:
    label111:
    do
    {
      return;
      paramaiig = paramaiig.e();
      if (QLog.isColorLevel()) {
        if ("updateApolloView cmsString = " + paramaiig != null) {
          break label100;
        }
      }
      for (Object localObject = "null";; localObject = paramaiig)
      {
        QLog.d("StickerRecBarAdapter", 2, (String)localObject);
        if (StringUtil.isEmpty(paramaiig)) {
          break;
        }
        try
        {
          localObject = new JSONObject(paramaiig);
          paramaiia.jdField_a_of_type_Ahpd.a((JSONObject)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          paramaiia.b();
          if (!paramaiia.jdField_a_of_type_Ahpd.a()) {
            break label111;
          }
          paramaiia.jdField_a_of_type_Ahpd.a();
          return;
        }
        catch (JSONException paramaiia)
        {
          paramaiia.printStackTrace();
          return;
        }
      }
    } while (!QLog.isColorLevel());
    paramaiia = paramaiig;
    if ("updateApolloView apolloPlayer.isReady = false | cmsString = " + paramaiig == null) {
      paramaiia = "null";
    }
    QLog.d("StickerRecBarAdapter", 2, paramaiia);
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
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgLoad", false, 0L, 0L, localHashMap, "");
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
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgLoad", true, paramLong, 0L, localHashMap, "");
      return;
    }
  }
  
  private void b(aiia paramaiia)
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramaiia.jdField_a_of_type_Ahpd)) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramaiia.jdField_a_of_type_Ahpd);
      }
      if (paramaiia.jdField_a_of_type_Ahpd.a()) {
        paramaiia.jdField_a_of_type_Ahpd.c();
      }
      return;
    }
  }
  
  private void c(aiia paramaiia)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "sendPic");
    }
    if ((paramaiia == null) || (paramaiia.jdField_a_of_type_Ahpd == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecBarAdapter", 2, "sendPic data is null");
      }
      return;
    }
    paramaiia.jdField_a_of_type_Ahpd.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
  }
  
  private void d()
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
        aihq localaihq = (aihq)this.jdField_a_of_type_JavaUtilList.get(j);
        if (localaihq == null) {}
        for (;;)
        {
          j += 1;
          break;
          URLDrawable localURLDrawable = localaihq.a(localaihq.a(), a(localaihq));
          if (localURLDrawable != null) {
            if (((localaihq instanceof aiig)) && (((aiig)localaihq).e() == 3))
            {
              this.jdField_a_of_type_Boolean = true;
            }
            else
            {
              localURLDrawable.setDecodeHandler(bgxc.j);
              localURLDrawable.setURLDrawableListener(this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener);
              if (localURLDrawable.getStatus() != 1)
              {
                this.jdField_a_of_type_JavaUtilArrayList.add(localURLDrawable);
                localURLDrawable.addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
                localURLDrawable.addHeader("emo_big", "true");
                localURLDrawable.startDownload();
              }
              else
              {
                this.jdField_a_of_type_Boolean = true;
              }
            }
          }
        }
      }
      a();
      return;
    }
  }
  
  private void e()
  {
    if (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    for (;;)
    {
      Object localObject3;
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
      {
        j = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size();
        localStringBuilder1.append("log apolloIceBreakShows list info count = " + j + "\n");
        i = 0;
        if (i < j)
        {
          localObject3 = (ahpd)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(i);
          StringBuilder localStringBuilder2 = new StringBuilder().append("log No.").append(i).append(" apolloIceBreakShow is invisible = ");
          if (((ahpd)localObject3).a().getVisibility() != 4) {
            break label390;
          }
          bool = true;
          localStringBuilder1.append(bool + "\n");
          i += 1;
          continue;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView == null)
        {
          QLog.d("StickerRecBarAdapter", 2, localStringBuilder1.toString());
          return;
        }
      }
      int i = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.getFirstVisiblePosition();
      int j = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.getLastVisiblePosition();
      localObject1.append("log mEmotionKeywordList info startIndex = " + i + " | endIndex = " + j + "\n");
      if (i <= j)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.getChildCount() > i)
        {
          ??? = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.getChild(i);
          if ((??? != null) && (((View)???).getTag() != null)) {
            break label286;
          }
        }
        label286:
        while (!(((View)???).getTag() instanceof aiia))
        {
          i += 1;
          break;
        }
        ??? = (aiia)((View)???).getTag();
        localObject3 = new StringBuilder().append("log No.").append(i).append(" mEmotionKeywordList is invisible = ");
        if (((aiia)???).jdField_a_of_type_Ahpd.a().getVisibility() == 4) {}
        for (bool = true;; bool = false)
        {
          localObject1.append(bool + "\n");
          break;
        }
      }
      QLog.d("StickerRecBarAdapter", 2, localObject1.toString());
      return;
      label390:
      boolean bool = false;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aihq localaihq = (aihq)((Iterator)localObject).next();
        if (localaihq.c()) {
          localArrayList1.add(localaihq);
        } else {
          localArrayList2.add(localaihq);
        }
      }
      localObject = new aiiv();
      ((aiiv)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((aiiv)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((aiiv)localObject).jdField_a_of_type_JavaUtilList = localArrayList1;
      ((aiiv)localObject).jdField_b_of_type_JavaUtilList = localArrayList2;
      ((aiiv)localObject).jdField_a_of_type_Int = this.h;
      this.jdField_c_of_type_JavaUtilList.add(localObject);
    }
  }
  
  public void a()
  {
    boolean bool2 = true;
    if (((agki)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(14)).c()) {
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
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getUIHandler();
        bool1 = bool2;
        if (localObject != null)
        {
          ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(69, this.jdField_c_of_type_JavaLangString));
          bool1 = bool2;
        }
        label69:
        if (!QLog.isColorLevel()) {
          break label179;
        }
        QLog.d("StickerRecBarAdapter", 2, "showEmotionKeywordLayout isshow = " + bool1);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_Aiin.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
      String str = ((agkh)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(41)).a();
      if (TextUtils.isEmpty(str)) {
        break label181;
      }
      localObject = str;
    }
    label179:
    label181:
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
      break label69;
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
  
  public void a(List<aihq> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      QLog.e("StickerRecBarAdapter", 1, "setData data is null or empty");
    }
    do
    {
      return;
      ((agki)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(14)).c();
      QLog.e("StickerRecBarAdapter", 1, "setData");
      this.jdField_a_of_type_JavaUtilList.clear();
      b();
      this.jdField_a_of_type_JavaUtilHashSet.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.resetCurrentX(0);
      d();
      notifyDataSetChanged();
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setData:");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aihq localaihq = (aihq)paramList.next();
      if ((localaihq != null) && (aiin.b(localaihq))) {
        localStringBuilder.append("thumb=").append(((aiig)localaihq).b()).append(",");
      }
    }
    QLog.d("StickerRecBarAdapter", 2, localStringBuilder.toString());
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() == 0) {
        return;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      if (localIterator.hasNext()) {
        ((ahpd)localIterator.next()).c();
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void c()
  {
    try
    {
      f();
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
      b();
    }
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
    Object localObject2 = (aihq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i;
    Object localObject3;
    label602:
    boolean bool;
    if (paramView == null)
    {
      localObject1 = new aiia();
      ((aiia)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = new EmojiStickerManager.EmotionKeywordLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      paramView = new ViewGroup.LayoutParams(-2, -2);
      ((aiia)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      ((aiia)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Int, this.d);
      ((aiia)localObject1).jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((aiia)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      ((aiia)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setId(2131368633);
      i = a((aihq)localObject2);
      paramView = new RelativeLayout.LayoutParams(i, this.e);
      paramView.addRule(13, -1);
      ((aiia)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((aiia)localObject1).jdField_a_of_type_ComTencentImageURLImageView, paramView);
      ((aiia)localObject1).jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((aiia)localObject1).jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838037));
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(7, 2131368633);
      paramView.addRule(8, 2131368633);
      ((aiia)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(2131691839);
      ((aiia)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167190));
      ((aiia)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      ((aiia)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((aiia)localObject1).jdField_a_of_type_AndroidWidgetTextView, paramView);
      ((aiia)localObject1).jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      ((aiia)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838335));
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(7, 2131368633);
      paramView.addRule(8, 2131368633);
      ((aiia)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(((aiia)localObject1).jdField_a_of_type_AndroidWidgetImageView, paramView);
      ((aiia)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((aiia)localObject1).jdField_a_of_type_Ahpd = new ahpd(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), this.f, this.e, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramView = ((aiia)localObject1).jdField_a_of_type_Ahpd.a();
      paramView.setId(2131378074);
      localObject3 = new RelativeLayout.LayoutParams(i, this.e);
      ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
      ((aiia)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramView, (ViewGroup.LayoutParams)localObject3);
      paramView.setVisibility(4);
      paramView = ObjectAnimator.ofFloat(((aiia)localObject1).jdField_a_of_type_ComTencentImageURLImageView, "alpha", new float[] { 0.0F, 1.0F });
      paramView.setDuration(300L);
      ((aiia)localObject1).jdField_a_of_type_AndroidAnimationAnimator = paramView;
      paramView = ((aiia)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout;
      paramView.setTag(localObject1);
      if (localObject2 != null) {
        break label774;
      }
      QLog.e("StickerRecBarAdapter", 1, "getView stickerRec empty position = " + paramInt);
      ((aiia)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ((aiia)localObject1).a();
      b((aiia)localObject1);
      label656:
      if (!(localObject2 instanceof aiib)) {
        break label1175;
      }
      ((aiia)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      label673:
      if (!(localObject2 instanceof aiil)) {
        break label1188;
      }
      bool = ((aiil)localObject2).d();
    }
    for (;;)
    {
      label691:
      localObject2 = ((aiia)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      if (bool) {}
      for (i = 0;; i = 8)
      {
        ((ImageView)localObject2).setVisibility(i);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          ((aiia)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(this.jdField_a_of_type_JavaLangString);
        }
        localObject1 = paramView;
        break;
        localObject1 = (aiia)paramView.getTag();
        i = a((aihq)localObject2);
        ((aiia)localObject1).jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = i;
        break label602;
        label774:
        ((aiia)localObject1).jdField_a_of_type_Aihq = ((aihq)localObject2);
        if (aiih.a((aihq)localObject2))
        {
          a((aiia)localObject1, (aiig)localObject2);
          paramView.setOnClickListener(this);
          a((aiia)localObject1);
          if (!aiin.b((aihq)localObject2)) {
            break label656;
          }
          ((aiig)localObject2).a(true);
          break label656;
        }
        ((aiia)localObject1).a();
        b((aiia)localObject1);
        localObject3 = ((aihq)localObject2).a();
        if (localObject3 == null)
        {
          ((aiia)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label656;
        }
        localObject3 = ((aihq)localObject2).a((URL)localObject3, a((aihq)localObject2));
        ((URLDrawable)localObject3).setDecodeHandler(bgxc.j);
        ((aiia)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setTag(localObject2);
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
          ((aiia)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject3);
          ((aiia)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
          ((aiia)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setFocusable(true);
          ((aiia)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setFocusableInTouchMode(true);
          if (aiin.b((aihq)localObject2))
          {
            ((aiig)localObject2).a(true);
            if (QLog.isColorLevel()) {
              QLog.e("StickerRecBarAdapter", 2, "md5:" + ((aiig)localObject2).c());
            }
          }
          paramView.setOnClickListener(this);
          ((aiia)localObject1).jdField_a_of_type_AndroidAnimationAnimator.start();
          break;
          if ((aiin.b((aihq)localObject2)) && (!this.jdField_a_of_type_JavaUtilHashSet.contains(((aiig)localObject2).k())))
          {
            this.jdField_a_of_type_JavaUtilHashSet.add(((aiig)localObject2).k());
            String str = ((aiig)localObject2).m();
            this.jdField_b_of_type_JavaUtilList.add(new StickerRecCacheEntity(str, System.currentTimeMillis(), ((aiig)localObject2).k()));
          }
        }
        label1175:
        ((aiia)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label673;
        label1188:
        if (!(localObject2 instanceof aiij)) {
          break label1216;
        }
        bool = ((aiij)localObject2).d();
        break label691;
      }
      label1216:
      bool = false;
    }
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "onClick");
    }
    Object localObject = paramView.getTag();
    if ((localObject instanceof aiia)) {}
    for (localObject = (aiia)localObject;; localObject = null)
    {
      if (localObject == null) {}
      label216:
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 9501)
        {
          e();
          int i;
          if (aiih.a(((aiia)localObject).jdField_a_of_type_Aihq))
          {
            c((aiia)localObject);
            i = 1;
          }
          for (;;)
          {
            if (i == 0) {
              break label216;
            }
            this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().clear();
            this.jdField_a_of_type_AndroidWidgetEditText.setText("");
            if (!aiin.b(((aiia)localObject).jdField_a_of_type_Aihq)) {
              break;
            }
            ((aiig)((aiia)localObject).jdField_a_of_type_Aihq).b(true);
            break;
            if ((((aiia)localObject).jdField_a_of_type_ComTencentImageURLImageView.getDrawable() instanceof URLDrawable)) {
              if (((URLDrawable)((aiia)localObject).jdField_a_of_type_ComTencentImageURLImageView.getDrawable()).getStatus() == 1)
              {
                if (this.jdField_a_of_type_AndroidWidgetEditText != null)
                {
                  a(((aiia)localObject).jdField_a_of_type_Aihq);
                  i = 1;
                  continue;
                }
                if (QLog.isColorLevel())
                {
                  QLog.e("StickerRecBarAdapter", 2, "onClick input == null");
                  i = 0;
                }
              }
              else if (QLog.isColorLevel())
              {
                QLog.e("StickerRecBarAdapter", 2, "onClick:URLDrawable status != successed");
              }
            }
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihw
 * JD-Core Version:    0.7.0.1
 */