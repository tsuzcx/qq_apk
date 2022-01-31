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

public class agyf
  extends BaseAdapter
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private agyv jdField_a_of_type_Agyv;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  private URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new agyh(this);
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener = new agyg(this);
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmotionKeywordHorizonListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<URLDrawable> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<agxz> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<StickerRecCacheEntity> jdField_b_of_type_JavaUtilList = new ArrayList();
  private int jdField_c_of_type_Int;
  private List<agzb> jdField_c_of_type_JavaUtilList = new ArrayList();
  private int d;
  private int e;
  private int f;
  private int g;
  
  public agyf(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, EditText paramEditText, BaseChatPie paramBaseChatPie, EmotionKeywordHorizonListView paramEmotionKeywordHorizonListView)
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
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramBaseActivity.getResources().getDrawable(2130838180);
    this.jdField_a_of_type_Agyv = agyv.a(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = paramEmotionKeywordHorizonListView;
  }
  
  private int a(agxz paramagxz)
  {
    int i;
    if (paramagxz == null) {
      i = this.f;
    }
    int j;
    do
    {
      return i;
      if (agyv.a(paramagxz)) {
        return this.f;
      }
      if (!agyv.b(paramagxz)) {
        return this.f;
      }
      paramagxz = (agyp)paramagxz;
      float f1 = paramagxz.g();
      float f2 = paramagxz.h();
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
  private URLDrawable.URLDrawableOptions a(agxz paramagxz)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = paramagxz.a();
    paramagxz = localURLDrawableOptions;
    if (localURLDrawableOptions == null) {
      paramagxz = URLDrawable.URLDrawableOptions.obtain();
    }
    paramagxz.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramagxz.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramagxz.mPlayGifImage = true;
    paramagxz.mGifRoundCorner = this.g;
    return paramagxz;
  }
  
  private void a(agxz paramagxz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "sendPic");
    }
    if (paramagxz == null) {}
    do
    {
      return;
      agyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_JavaLangString);
      if (!agyv.a(paramagxz)) {
        break;
      }
      paramagxz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramagxz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    } while (paramagxz == null);
    paramagxz.sendMessage(paramagxz.obtainMessage(92));
    return;
    Object localObject1 = (agyp)paramagxz;
    Object localObject2 = new Intent();
    paramagxz = new ArrayList();
    paramagxz.add(((agyp)localObject1).l());
    ((Intent)localObject2).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramagxz);
    ((Intent)localObject2).putExtra("PicContants.NEED_COMPRESS", false);
    ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    ((Intent)localObject2).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("key_confess_topicid", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e);
    ((Intent)localObject2).putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    ((Intent)localObject2).putExtra("send_in_background", true);
    ((Intent)localObject2).putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramagxz);
    ((Intent)localObject2).putExtra("PicContants.NEED_COMPRESS", false);
    ((Intent)localObject2).putExtra("quick_send_original_md5", ((agyp)localObject1).b());
    ((Intent)localObject2).putExtra("quick_send_original_size", ((agyp)localObject1).a());
    ((Intent)localObject2).putExtra("quick_send_thumb_md5", ((agyp)localObject1).f());
    ((Intent)localObject2).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1047);
    ((Intent)localObject2).putExtra("HOT_PIC_HAS_EXTRA", true);
    int i;
    if ((TextUtils.isEmpty(((agyp)localObject1).h())) || (((agyp)localObject1).h().length() <= 100))
    {
      i = 1;
      label327:
      if (i == 0) {
        break label659;
      }
      ((Intent)localObject2).putExtra("key_emotion_source_from", ((agyp)localObject1).e());
      ((Intent)localObject2).putExtra("key_emotion_source_info", ((agyp)localObject1).g());
      ((Intent)localObject2).putExtra("key_emotion_source_weburl", ((agyp)localObject1).h());
      ((Intent)localObject2).putExtra("key_emotion_source_iconurl", "");
      ((Intent)localObject2).putExtra("key_emotion_source_packagename", ((agyp)localObject1).i());
      ((Intent)localObject2).putExtra("key_emotion_source_epid", ((agyp)localObject1).f());
      label408:
      if (QLog.isColorLevel()) {
        QLog.i("StickerRecBarAdapter", 2, "md5:" + ((agyp)localObject1).b() + "srcfrom:" + ((agyp)localObject1).e() + ", desc:" + ((agyp)localObject1).g() + ", webUrl:" + ((agyp)localObject1).h() + ", pack:" + ((agyp)localObject1).i() + ", epid:" + ((agyp)localObject1).f());
      }
      if (!((afgc)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(41)).a()) {
        break label710;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
      localObject2 = bcpx.a((Editable)localObject1);
      ((aufc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(174)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramagxz, false, (String)((Pair)localObject2).first, (ArrayList)((Pair)localObject2).second, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo);
      agfa.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localObject1.toString(), (ArrayList)((Pair)localObject2).second, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramagxz = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (paramagxz == null) {
        break;
      }
      paramagxz.sendMessage(paramagxz.obtainMessage(92));
      return;
      i = 0;
      break label327;
      label659:
      azqs.b(null, "dc00898", "", "", "0X800A7EA", "0X800A7EA", 0, 0, "", "", "", "");
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
    azri.a(BaseApplication.getContext()).a(null, "StickerRecImgLoad", false, 0L, 0L, localHashMap, "");
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
      azri.a(BaseApplication.getContext()).a(null, "StickerRecImgLoad", true, paramLong, 0L, localHashMap, "");
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
        Object localObject = (agxz)this.jdField_a_of_type_JavaUtilList.get(j);
        if (localObject == null) {}
        for (;;)
        {
          j += 1;
          break;
          localObject = ((agxz)localObject).a(((agxz)localObject).a(), a((agxz)localObject));
          if (localObject != null)
          {
            ((URLDrawable)localObject).setDecodeHandler(bcyz.i);
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
        agxz localagxz = (agxz)((Iterator)localObject).next();
        if (localagxz.c()) {
          localArrayList1.add(localagxz);
        } else {
          localArrayList2.add(localagxz);
        }
      }
      localObject = new agzb();
      ((agzb)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((agzb)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((agzb)localObject).jdField_a_of_type_JavaUtilList = localArrayList1;
      ((agzb)localObject).jdField_b_of_type_JavaUtilList = localArrayList2;
      this.jdField_c_of_type_JavaUtilList.add(localObject);
    }
  }
  
  public void a()
  {
    if (((afgd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(14)).c()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_Agyv.a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString());
    String str = ((afgc)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(41)).a();
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
      for (boolean bool = true; QLog.isColorLevel(); bool = false)
      {
        QLog.d("StickerRecBarAdapter", 2, "showEmotionKeywordLayout isshow = " + bool);
        return;
      }
      break;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<agxz> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      QLog.e("StickerRecBarAdapter", 1, "setData data is null or empty");
    }
    do
    {
      return;
      ((afgd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(14)).c();
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
      agxz localagxz = (agxz)paramList.next();
      if (agyv.b(localagxz)) {
        localStringBuilder.append("thumb=").append(((agyp)localagxz).e()).append(",");
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
    Object localObject1 = (agxz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    label512:
    label528:
    boolean bool;
    if (paramView == null)
    {
      paramViewGroup = new agyj(null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = new EmojiStickerManager.EmotionKeywordLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      paramView = new ViewGroup.LayoutParams(-2, -2);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramView);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_a_of_type_Int, this.d);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setId(2131368053);
      paramView = new RelativeLayout.LayoutParams(a((agxz)localObject1), this.e);
      paramView.addRule(13, -1);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView, paramView);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130837820));
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(7, 2131368053);
      paramView.addRule(8, 2131368053);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(2131692047);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131167059));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup.jdField_a_of_type_AndroidWidgetTextView, paramView);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDrawable(2130838174));
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(7, 2131368053);
      paramView.addRule(8, 2131368053);
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
      if (!(localObject1 instanceof agyk)) {
        break label951;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!(localObject1 instanceof agyt)) {
        break label963;
      }
      bool = ((agyt)localObject1).d();
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
        paramViewGroup = (agyj)paramView.getTag();
        int i = a((agxz)localObject1);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = i;
        break;
        label619:
        paramViewGroup.jdField_a_of_type_Agxz = ((agxz)localObject1);
        Object localObject2 = ((agxz)localObject1).a();
        if (localObject2 == null)
        {
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label512;
        }
        localObject2 = ((agxz)localObject1).a((URL)localObject2, a((agxz)localObject1));
        ((URLDrawable)localObject2).setDecodeHandler(bcyz.i);
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
          if (agyv.b((agxz)localObject1))
          {
            ((agyp)localObject1).a(true);
            if (QLog.isColorLevel()) {
              QLog.e("StickerRecBarAdapter", 2, "md5:" + ((agyp)localObject1).b());
            }
          }
          paramView.setOnClickListener(this);
          paramViewGroup.jdField_a_of_type_AndroidAnimationAnimator.start();
          break;
          if ((agyv.b((agxz)localObject1)) && (!this.jdField_a_of_type_JavaUtilHashSet.contains(((agyp)localObject1).j())))
          {
            this.jdField_a_of_type_JavaUtilHashSet.add(((agyp)localObject1).j());
            String str = ((agyp)localObject1).l();
            this.jdField_b_of_type_JavaUtilList.add(new StickerRecCacheEntity(str, System.currentTimeMillis(), ((agyp)localObject1).j()));
          }
        }
        label951:
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label528;
        label963:
        if (!(localObject1 instanceof agyr)) {
          break label990;
        }
        bool = ((agyr)localObject1).d();
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
    if ((localObject instanceof agyj)) {
      paramView = (agyj)localObject;
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
          a(paramView.jdField_a_of_type_Agxz);
          this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().clear();
          this.jdField_a_of_type_AndroidWidgetEditText.setText("");
        } while (!agyv.b(paramView.jdField_a_of_type_Agxz));
        ((agyp)paramView.jdField_a_of_type_Agxz).b(true);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("StickerRecBarAdapter", 2, "onClick input == null");
      return;
    } while (!QLog.isColorLevel());
    label157:
    QLog.e("StickerRecBarAdapter", 2, "onClick:URLDrawable status != successed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyf
 * JD-Core Version:    0.7.0.1
 */