import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.StickerRecHelper.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import mqq.os.MqqHandler;

public class acyh
  implements acxg
{
  private long jdField_a_of_type_Long;
  private aels jdField_a_of_type_Aels;
  private aemi jdField_a_of_type_Aemi;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private long b;
  private long c;
  
  public acyh(BaseChatPie paramBaseChatPie)
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
    EmotionKeywordHorizonListView localEmotionKeywordHorizonListView = (EmotionKeywordHorizonListView)localEmotionKeywordLayout.findViewById(2131300025);
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      localEmotionKeywordLayout.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localEmotionKeywordHorizonListView.setBackgroundColor(Color.parseColor("#1F1F1F"));
    }
    this.jdField_a_of_type_Aels = new aels(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramEditText, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, localEmotionKeywordHorizonListView);
    localEmotionKeywordHorizonListView.setAdapter(this.jdField_a_of_type_Aels);
    localEmotionKeywordHorizonListView.setPadding(0, 0, 0, 0);
    if (this.jdField_a_of_type_Aemi == null) {
      this.jdField_a_of_type_Aemi = aemi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Aemi.a(new aelv(this.jdField_a_of_type_Aels));
    localEmotionKeywordLayout.setOnVisibilityListener(new acyi(this));
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
    aemi localaemi;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_Aemi == null);
      this.jdField_a_of_type_Aemi.a(null);
      return;
      localaemi = aemi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while ((localaemi.a()) || (!aemi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false)));
    ThreadManager.executeOnSubThread(new StickerRecHelper.1(this, localaemi));
  }
  
  public void a(Editable paramEditable)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null) || (this.jdField_a_of_type_Aels == null)) {
      return;
    }
    int i = aemi.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 6);
    paramEditable = paramEditable.toString();
    String str = ((acyg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(41)).a();
    if (!TextUtils.isEmpty(str)) {
      paramEditable = str;
    }
    for (;;)
    {
      if (i >= paramEditable.length()) {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
      }
      for (boolean bool = this.jdField_a_of_type_Aemi.a(paramEditable, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; bool = false)
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
    return aemi.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
  }
  
  public int[] a()
  {
    return new int[] { 11, 6 };
  }
  
  public void b()
  {
    this.c = System.currentTimeMillis();
    ((acyg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(41)).b();
  }
  
  public void b(Editable paramEditable)
  {
    if (this.jdField_a_of_type_Aemi == null) {
      this.jdField_a_of_type_Aemi = aemi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (paramEditable.length() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.w();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aemi == null) {
      this.jdField_a_of_type_Aemi = aemi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_Aemi.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acyh
 * JD-Core Version:    0.7.0.1
 */