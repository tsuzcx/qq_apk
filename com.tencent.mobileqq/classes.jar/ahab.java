import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.LocationShareTipsBar.1;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.ui.LocationShareFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class ahab
  implements ahan, View.OnClickListener, bdbc
{
  private static long jdField_a_of_type_Long;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private bdbb jdField_a_of_type_Bdbb;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private QQBlurView jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new LocationShareTipsBar.1(this);
  private HashMap<String, ImageView> jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  public ahab(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(3);
    this.jdField_a_of_type_Bdbb = new bdbb(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Bdbb.a(this);
  }
  
  @TargetApi(19)
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373452));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    }
  }
  
  private void a(String paramString, ImageView paramImageView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != BaseActivity.sTopActivity) {
      return;
    }
    Bitmap localBitmap = this.jdField_a_of_type_Bdbb.a(1, paramString);
    if (localBitmap != null)
    {
      paramImageView.setImageBitmap(localBitmap);
      paramImageView.setVisibility(0);
      return;
    }
    paramImageView.setVisibility(4);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramImageView);
    this.jdField_a_of_type_Bdbb.a(paramString, 200, true);
  }
  
  private void b()
  {
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373458);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373451);
    if (bibv.a())
    {
      localView.setBackgroundColor(Color.parseColor("#1F1F1F"));
      localImageView.setImageResource(2130839280);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    }
    localImageView.setImageResource(2130839279);
  }
  
  private void b(boolean paramBoolean, String paramString, int paramInt, List<String> paramList)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    if (this.jdField_a_of_type_AndroidViewViewGroup == null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)View.inflate((Context)localObject, 2131560825, null));
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setClickable(true);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373454).setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373455).setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373456).setVisibility(8);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373453);
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      localTextView.setTextColor(Color.parseColor("#A8A8A8"));
    }
    a();
    if (paramBoolean)
    {
      paramString = "你" + ((Activity)localObject).getString(2131696524);
      localTextView.setText(paramString);
      if (!this.jdField_a_of_type_Boolean)
      {
        azqs.b(null, "CliOper", "", "", "0X800A767", "0X800A767", 1, 0, "", "0", "0", "");
        this.jdField_a_of_type_Boolean = true;
      }
      attk.a(this.jdField_a_of_type_AndroidViewViewGroup, paramString);
      if ((paramList.size() > 0) && (!TextUtils.isEmpty((CharSequence)paramList.get(0)))) {
        a((String)paramList.get(0), (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373454));
      }
      if ((paramList.size() > 1) && (!TextUtils.isEmpty((CharSequence)paramList.get(1)))) {
        a((String)paramList.get(1), (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373455));
      }
      if ((paramList.size() > 2) && (!TextUtils.isEmpty((CharSequence)paramList.get(2)))) {
        a((String)paramList.get(2), (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373456));
      }
      this.jdField_a_of_type_AndroidViewViewGroup.addOnAttachStateChangeListener(new ahac(this));
      b();
      return;
    }
    if (paramInt == 1) {}
    for (localObject = ((Activity)localObject).getString(2131696524);; localObject = String.format(((Activity)localObject).getString(2131696523), new Object[] { Integer.valueOf(paramInt) }))
    {
      String str = paramString + (String)localObject;
      attk.a(paramString, (String)localObject, localTextView);
      if (!this.jdField_a_of_type_Boolean)
      {
        azqs.b(null, "CliOper", "", "", "0X800A767", "0X800A767", 2, 0, "", "0", "0", "");
        this.jdField_a_of_type_Boolean = true;
      }
      attk.a(this.jdField_a_of_type_AndroidViewViewGroup, str + " 点击加入位置共享");
      break;
    }
  }
  
  public int a()
  {
    return 60;
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1000) {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)
      {
        ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 0L);
      }
    }
    while ((paramInt != 1003) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView == null)) {
      return;
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, List<String> paramList)
  {
    b(paramBoolean, paramString, paramInt, paramList);
  }
  
  public int[] a()
  {
    return new int[0];
  }
  
  public int b()
  {
    return 25;
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 1000L) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareTipsBar", 2, new Object[] { "onClick: invoked. ", " v: ", paramView });
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    LocationShareFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 3);
    azqs.b(null, "CliOper", "", "", "0X800A768", "0X800A768", 0, 0, "", "0", "0", "");
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = (ImageView)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null)
    {
      paramString.setImageBitmap(paramBitmap);
      paramString.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahab
 * JD-Core Version:    0.7.0.1
 */