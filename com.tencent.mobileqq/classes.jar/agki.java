import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.StickerRecHelper.1;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import mqq.os.MqqHandler;

public class agki
  implements agin, aijj
{
  private long jdField_a_of_type_Long;
  private aihw jdField_a_of_type_Aihw;
  private aiin jdField_a_of_type_Aiin;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  private long c;
  
  public agki(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.app;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.mContext;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.mActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.sessionInfo;
    this.jdField_a_of_type_MqqOsMqqHandler = paramBaseChatPie.getUIHandler();
  }
  
  public EmotionKeywordHorizonListView a(EditText paramEditText)
  {
    EmotionKeywordLayout localEmotionKeywordLayout = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getEmotionKeyWordLayout();
    localEmotionKeywordLayout.setEnableAnim(true);
    LinearLayout localLinearLayout = (LinearLayout)localEmotionKeywordLayout.findViewById(2131366089);
    EmotionKeywordHorizonListView localEmotionKeywordHorizonListView = (EmotionKeywordHorizonListView)localEmotionKeywordLayout.findViewById(2131366118);
    TextView localTextView = (TextView)localEmotionKeywordLayout.findViewById(2131366088);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      localEmotionKeywordLayout.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localEmotionKeywordHorizonListView.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localLinearLayout.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localTextView.setTextColor(Color.parseColor("#8D8D93"));
    }
    this.jdField_a_of_type_Aihw = new aihw(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramEditText, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, localEmotionKeywordHorizonListView);
    localEmotionKeywordHorizonListView.setAdapter(this.jdField_a_of_type_Aihw);
    localEmotionKeywordHorizonListView.setPadding(0, 0, 0, 0);
    if (this.jdField_a_of_type_Aiin == null) {
      this.jdField_a_of_type_Aiin = aiin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Aiin.a(new aihz(this.jdField_a_of_type_Aihw));
    localEmotionKeywordLayout.setOnVisibilityListener(new agkj(this));
    ScenesRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this);
    return localEmotionKeywordHorizonListView;
  }
  
  public void a()
  {
    this.b = System.currentTimeMillis();
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    aiin localaiin;
    do
    {
      return;
      if (this.jdField_a_of_type_Aiin != null) {
        this.jdField_a_of_type_Aiin.a(null);
      }
      if (this.jdField_a_of_type_Aihw != null) {
        this.jdField_a_of_type_Aihw.b();
      }
      ScenesRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(null);
      return;
      if ((this.jdField_a_of_type_Aiin != null) && (this.jdField_a_of_type_Aihw != null)) {
        this.jdField_a_of_type_Aiin.a(new aihz(this.jdField_a_of_type_Aihw));
      }
      ScenesRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this);
      return;
      localaiin = aiin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((localaiin.a()) || (!aiin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false)));
    ThreadManager.executeOnSubThread(new StickerRecHelper.1(this, localaiin));
  }
  
  public void a(aijh paramaijh)
  {
    QLog.i("ScenesRecommendManager", 0, "handleScenesRec  start");
    if (!b()) {
      QLog.i("ScenesRecommendManager", 0, "handleScenesRec  isEmotionRecSettingOpen = false");
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getEmotionKeyWordLayout() == null) || (this.jdField_a_of_type_Aihw == null) || (paramaijh == null)) {
      return;
    }
    if (this.jdField_a_of_type_Aiin == null) {
      this.jdField_a_of_type_Aiin = aiin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Aiin.a(paramaijh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
  }
  
  public void a(Editable paramEditable)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getEmotionKeyWordLayout() == null) || (this.jdField_a_of_type_Aihw == null)) {
      return;
    }
    int i = aiin.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 6);
    paramEditable = paramEditable.toString();
    String str = ((agkh)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(41)).a();
    if (!TextUtils.isEmpty(str)) {
      paramEditable = str;
    }
    for (;;)
    {
      if (i >= paramEditable.length()) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      for (boolean bool = this.jdField_a_of_type_Aiin.a(paramEditable, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);; bool = false)
      {
        long l = System.currentTimeMillis() - this.b - 3000L;
        if (bool) {
          break;
        }
        if (l > 0L)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.handleHiddenEmoticonKeyword();
          return;
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(67, -l);
        return;
      }
    }
  }
  
  public boolean a()
  {
    return aiin.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), false);
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      return false;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
    QLog.i("ScenesRecommendManager", 0, "checkUinIsCurrentChat  uin = " + paramString + " | curUin = " + str);
    return str.equalsIgnoreCase(paramString);
  }
  
  public int[] a()
  {
    return new int[] { 14, 8, 6 };
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aihw != null) {
      this.jdField_a_of_type_Aihw.b();
    }
    this.c = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    ((agkh)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getHelper(41)).b();
  }
  
  public void b(Editable paramEditable)
  {
    if (this.jdField_a_of_type_Aiin == null) {
      this.jdField_a_of_type_Aiin = aiin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (paramEditable.length() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.handleHiddenEmoticonKeyword();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aiin == null) {
      this.jdField_a_of_type_Aiin = aiin.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_Aiin.b();
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agki
 * JD-Core Version:    0.7.0.1
 */