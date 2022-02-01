import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.StickerRecHelper.1;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import mqq.os.MqqHandler;

public class agwn
  implements agvc, aiud
{
  private long jdField_a_of_type_Long;
  private aiss jdField_a_of_type_Aiss;
  private aiti jdField_a_of_type_Aiti;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  private long c;
  
  public agwn(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    this.jdField_a_of_type_MqqOsMqqHandler = paramBaseChatPie.a();
  }
  
  public EmotionKeywordHorizonListView a(EditText paramEditText)
  {
    EmotionKeywordLayout localEmotionKeywordLayout = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    localEmotionKeywordLayout.setEnableAnim(true);
    LinearLayout localLinearLayout = (LinearLayout)localEmotionKeywordLayout.findViewById(2131365958);
    EmotionKeywordHorizonListView localEmotionKeywordHorizonListView = (EmotionKeywordHorizonListView)localEmotionKeywordLayout.findViewById(2131365987);
    TextView localTextView = (TextView)localEmotionKeywordLayout.findViewById(2131365957);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      localEmotionKeywordLayout.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localEmotionKeywordHorizonListView.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localLinearLayout.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localTextView.setTextColor(Color.parseColor("#8D8D93"));
    }
    this.jdField_a_of_type_Aiss = new aiss(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramEditText, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localEmotionKeywordHorizonListView);
    localEmotionKeywordHorizonListView.setAdapter(this.jdField_a_of_type_Aiss);
    localEmotionKeywordHorizonListView.setPadding(0, 0, 0, 0);
    if (this.jdField_a_of_type_Aiti == null) {
      this.jdField_a_of_type_Aiti = aiti.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Aiti.a(new aisv(this.jdField_a_of_type_Aiss));
    localEmotionKeywordLayout.setOnVisibilityListener(new agwo(this));
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
    aiti localaiti;
    do
    {
      return;
      if (this.jdField_a_of_type_Aiti != null) {
        this.jdField_a_of_type_Aiti.a(null);
      }
      ScenesRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(null);
      return;
      if ((this.jdField_a_of_type_Aiti != null) && (this.jdField_a_of_type_Aiss != null)) {
        this.jdField_a_of_type_Aiti.a(new aisv(this.jdField_a_of_type_Aiss));
      }
      ScenesRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this);
      return;
      localaiti = aiti.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((localaiti.a()) || (!aiti.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false)));
    ThreadManager.executeOnSubThread(new StickerRecHelper.1(this, localaiti));
  }
  
  public void a(aiub paramaiub)
  {
    QLog.i("ScenesRecommendManager", 0, "handleScenesRec  start");
    if (!b()) {
      QLog.i("ScenesRecommendManager", 0, "handleScenesRec  isEmotionRecSettingOpen = false");
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null) || (this.jdField_a_of_type_Aiss == null) || (paramaiub == null)) {
      return;
    }
    if (this.jdField_a_of_type_Aiti == null) {
      this.jdField_a_of_type_Aiti = aiti.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Aiti.a(paramaiub, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void a(Editable paramEditable)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null) || (this.jdField_a_of_type_Aiss == null)) {
      return;
    }
    int i = aiti.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 6);
    paramEditable = paramEditable.toString();
    String str = ((agwm)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(41)).a();
    if (!TextUtils.isEmpty(str)) {
      paramEditable = str;
    }
    for (;;)
    {
      if (i >= paramEditable.length()) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      for (boolean bool = this.jdField_a_of_type_Aiti.a(paramEditable, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);; bool = false)
      {
        long l = System.currentTimeMillis() - this.b - 3000L;
        if (bool) {
          break;
        }
        if (l > 0L)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.w();
          return;
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(67, -l);
        return;
      }
    }
  }
  
  public boolean a()
  {
    return aiti.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      return false;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    QLog.i("ScenesRecommendManager", 0, "checkUinIsCurrentChat  uin = " + paramString + " | curUin = " + str);
    return str.equalsIgnoreCase(paramString);
  }
  
  public int[] a()
  {
    return new int[] { 13, 7, 5 };
  }
  
  public void b()
  {
    this.c = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    ((agwm)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(41)).b();
  }
  
  public void b(Editable paramEditable)
  {
    if (this.jdField_a_of_type_Aiti == null) {
      this.jdField_a_of_type_Aiti = aiti.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (paramEditable.length() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.w();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aiti == null) {
      this.jdField_a_of_type_Aiti = aiti.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_Aiti.b();
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
 * Qualified Name:     agwn
 * JD-Core Version:    0.7.0.1
 */