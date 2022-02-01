import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.store.openbox.RoundRectLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.XEditTextEx;
import java.io.File;
import java.util.ArrayList;
import java.util.ArrayList<Laiau;>;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public class aiah
  extends BaseChatPie
{
  public static final String b;
  public static String c;
  private int jdField_a_of_type_Int;
  private aiat jdField_a_of_type_Aiat;
  private aikm jdField_a_of_type_Aikm;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aiam(this);
  protected anyz a;
  private avdr jdField_a_of_type_Avdr;
  private avds jdField_a_of_type_Avds;
  private aved jdField_a_of_type_Aved = new aiai(this);
  private avex jdField_a_of_type_Avex;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private List<aias> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int;
  private aiat jdField_b_of_type_Aiat;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new aian(this);
  private avdr jdField_b_of_type_Avdr;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean = true;
  
  static
  {
    jdField_b_of_type_JavaLangString = avec.jdField_a_of_type_JavaLangString + "GameMsgChatPie";
  }
  
  public aiah(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_a_of_type_Anyz = new aiaq(this);
  }
  
  private String a(avdr paramavdr)
  {
    if (paramavdr == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(300);
    localStringBuilder.append(paramavdr.i).append(paramavdr.k).append("-").append(paramavdr.jdField_f_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    Object localObject = this.mActivity.getIntent();
    String str1 = ((Intent)localObject).getStringExtra("game_msg_friend_role_id");
    String str2 = ((Intent)localObject).getStringExtra("game_msg_my_role_id");
    this.jdField_b_of_type_Int = ((Intent)localObject).getIntExtra("game_msg_open_aio_from", -1);
    QLog.i(jdField_b_of_type_JavaLangString, 1, "friRoleId:" + str1 + ",myRoleId:" + str2);
    this.jdField_a_of_type_Aiat = new aiat(this.app, str2, true, this.mActivity);
    this.jdField_b_of_type_Aiat = new aiat(this.app, str1, false, this.mActivity);
    this.sessionInfo.setFriendRoleId(str1);
    this.sessionInfo.setMyRoleId(str2);
    this.jdField_a_of_type_Avdr = this.jdField_a_of_type_Avds.a(str1);
    this.jdField_b_of_type_Avdr = this.jdField_a_of_type_Avds.a(str2);
    String str3;
    if (this.jdField_a_of_type_Avdr != null)
    {
      str3 = this.jdField_a_of_type_Avdr.jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_Avdr.jdField_c_of_type_Int != 0) {
        break label262;
      }
    }
    label262:
    for (localObject = "1";; localObject = "0")
    {
      avdu.a(str3, "1", "145", "920", "92005", "206350", "", (String)localObject, "8", "0");
      localObject = (avec)this.app.getBusinessHandler(BusinessHandlerFactory.GAME_CENTER_UNISSO_HANDLER);
      ((avec)localObject).a(str2, str1);
      if (this.jdField_a_of_type_Avdr != null)
      {
        ((avec)localObject).a(this.jdField_a_of_type_Avdr.jdField_c_of_type_JavaLangString);
        jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Avdr.jdField_c_of_type_JavaLangString;
      }
      this.jdField_a_of_type_Avex = new avex(this);
      return;
    }
  }
  
  private void a(aiar paramaiar)
  {
    if (paramaiar == null) {
      QLog.i(jdField_b_of_type_JavaLangString, 1, "[doOnButtonClick] buttonInfo is null.");
    }
    for (;;)
    {
      return;
      if (paramaiar.jdField_a_of_type_Int == 1)
      {
        paramaiar = paramaiar.jdField_a_of_type_JavaLangString;
        Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
        localIntent.putExtra("url", paramaiar);
        getActivity().startActivity(localIntent);
      }
      while ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        return;
        if ((paramaiar.jdField_a_of_type_Int == 3) && (this.mActivity != null)) {
          this.mActivity.doOnBackPressed();
        }
      }
    }
  }
  
  private void a(avdr paramavdr)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "[setTitleInfo]");
    }
    if (paramavdr == null) {}
    try
    {
      QLog.w(jdField_b_of_type_JavaLangString, 1, "detail info is null.");
      this.mTitleBtnRightLayout.setVisibility(4);
      this.mTitleText.setText(anvx.a(2131692694));
      return;
    }
    catch (Throwable paramavdr)
    {
      Object localObject;
      QLog.e(jdField_b_of_type_JavaLangString, 1, paramavdr.getMessage());
      return;
    }
    paramavdr.a();
    if (!TextUtils.isEmpty(paramavdr.jdField_e_of_type_JavaLangString))
    {
      this.mTitleText.setText(paramavdr.jdField_e_of_type_JavaLangString);
      localObject = a(paramavdr);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        setSubTitleVisable(true);
        this.mSubTilteText.setText((CharSequence)localObject);
      }
      if (paramavdr.jdField_a_of_type_Int > 0)
      {
        if (this.mCustomTitleView != null) {
          this.mCustomTitleView.setEarIconVisible(false);
        }
        this.mTitleIcon.setVisibility(8);
        if (paramavdr.jdField_a_of_type_Int != 1) {
          break label328;
        }
      }
    }
    label328:
    for (int i = 2130840227;; i = 2130840226)
    {
      this.mTitleIcon2.setVisibility(0);
      this.mTitleIcon2.setImageDrawable(getActivity().getResources().getDrawable(i));
      if (!TextUtils.isEmpty(paramavdr.g))
      {
        this.mTitleIconRight.setVisibility(0);
        localObject = (LinearLayout.LayoutParams)this.mTitleIconRight.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject).width = AIOUtils.dp2px(18.0F, BaseApplication.getContext().getResources());
        ((LinearLayout.LayoutParams)localObject).height = AIOUtils.dp2px(18.0F, BaseApplication.getContext().getResources());
        localObject = URLDrawable.getDrawable(paramavdr.g);
        this.mTitleIconRight.setImageDrawable((Drawable)localObject);
      }
      if (TextUtils.isEmpty(paramavdr.j)) {
        return;
      }
      this.mTitleBtnRightLayout.setVisibility(0);
      this.mTitleBtnRight.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramavdr = URLDrawable.getDrawable(paramavdr.j);
      this.mCustomTitleView.setRight1Icon(paramavdr);
      return;
      this.mTitleText.setText(anvx.a(2131692694));
      break;
    }
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    int j = 0;
    QLog.i(jdField_b_of_type_JavaLangString, 1, "[showGrayTip], content:" + paramString1 + ",start:" + paramInt1 + ",end:" + paramInt2 + ",url:" + paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = this.sessionInfo.curFriendUin;
    paramString1 = new avhz(this.sessionInfo.curFriendUin, this.app.getCurrentUin(), paramString1, 10007, -5020, 656397, bcrg.a());
    localObject = new MessageForUniteGrayTip();
    if (!TextUtils.isEmpty(paramString2)) {
      if (paramInt2 <= paramInt1) {
        break label221;
      }
    }
    label221:
    for (int i = 1;; i = 0)
    {
      if (paramInt1 >= 0) {
        j = 1;
      }
      if ((j & i) != 0)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_action", 1);
        localBundle.putString("textColor", "#40A0FF");
        localBundle.putString("key_action_DATA", paramString2);
        paramString1.a(paramInt1, paramInt2, localBundle);
      }
      ((MessageForUniteGrayTip)localObject).initGrayTipMsg(this.app, paramString1);
      avia.a(this.app, (MessageForUniteGrayTip)localObject);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, aiar paramaiar1, aiar paramaiar2)
  {
    if ((paramaiar1 == null) && (paramaiar2 == null)) {}
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
      {
        if ((paramaiar1 != null) && (paramaiar2 != null)) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.mActivity, 230, paramString1, paramString2, paramaiar1.jdField_b_of_type_JavaLangString, paramaiar2.jdField_b_of_type_JavaLangString, new aiaj(this, paramaiar2), new aiak(this, paramaiar1));
        }
        while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
          return;
          if (paramaiar1 != null) {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.mActivity, 230, paramString1, paramString2, paramaiar1.jdField_b_of_type_JavaLangString, "", null, new aial(this, paramaiar1));
          }
        }
      }
    }
  }
  
  private void a(ArrayList<aiau> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "[createGrayTips]");
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    do
    {
      return;
      Object localObject1 = "";
      Iterator localIterator = paramArrayList.iterator();
      int j = 0;
      int i = 0;
      int k = 0;
      Object localObject2 = "";
      paramArrayList = (ArrayList<aiau>)localObject1;
      localObject1 = localObject2;
      while (localIterator.hasNext())
      {
        aiau localaiau = (aiau)localIterator.next();
        if (i == 0) {
          k = paramArrayList.length();
        }
        localObject2 = localObject1;
        int n = j;
        int m = i;
        if (2 == localaiau.jdField_a_of_type_Int)
        {
          localObject2 = localObject1;
          n = j;
          m = i;
          if (!TextUtils.isEmpty(localaiau.jdField_b_of_type_JavaLangString))
          {
            localObject2 = localObject1;
            n = j;
            m = i;
            if (!TextUtils.isEmpty(localaiau.jdField_a_of_type_JavaLangString))
            {
              localObject2 = localObject1;
              n = j;
              m = i;
              if (j == 0)
              {
                localObject2 = localaiau.jdField_b_of_type_JavaLangString;
                m = k + localaiau.jdField_a_of_type_JavaLangString.length();
                n = 1;
              }
            }
          }
        }
        paramArrayList = paramArrayList + localaiau.jdField_a_of_type_JavaLangString;
        localObject1 = localObject2;
        j = n;
        i = m;
      }
      a(paramArrayList, k, i, (String)localObject1);
    } while (this.jdField_a_of_type_Avdr == null);
    avdu.a(this.jdField_a_of_type_Avdr.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "207652", paramArrayList, "", "8", "");
  }
  
  private boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "[showStartGame]");
    }
    if (a() == null) {
      return false;
    }
    avdu.a(this.mActivity, a());
    return true;
  }
  
  private void b()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.mCustomTitleView != null) {
        this.mCustomTitleView.a(false);
      }
      if ((this.jdField_c_of_type_Boolean) && (getApp() != null) && (this.jdField_a_of_type_Avdr != null))
      {
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("game_center_sp", 0);
        String str = getApp().getCurrentUin() + "_game_msg_chatpie_reddot_click_" + this.jdField_a_of_type_Avdr.jdField_c_of_type_JavaLangString;
        localSharedPreferences.edit().putBoolean(str, true).commit();
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_Aikm = new aikm(this.app, getActivity());
      this.mTipsMgr.a(this.jdField_a_of_type_Aikm);
      this.jdField_a_of_type_Aikm.a(paramString);
      this.mTipsMgr.a(this.jdField_a_of_type_Aikm, new Object[0]);
    }
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_Avdr == null)
    {
      QLog.w(jdField_b_of_type_JavaLangString, 1, "friendGameInfo is null.");
      return false;
    }
    String str = this.jdField_a_of_type_Avdr.i;
    if (TextUtils.isEmpty(str))
    {
      QLog.w(jdField_b_of_type_JavaLangString, 1, "[showDialogIfBlocked], gameName is null.");
      return false;
    }
    str = String.format(anvx.a(2131692700), new Object[] { str });
    bhdj.a(this.mActivity, 230, anvx.a(2131692701), str, anvx.a(2131690697), anvx.a(2131692699), new aiao(this), new aiap(this)).show();
    return true;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  private void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "[showQuickReply], from:" + paramString);
    }
    if (this.jdField_a_of_type_Avdr == null) {
      QLog.w(jdField_b_of_type_JavaLangString, 1, "[showQuickReply], param is null, return.");
    }
    label338:
    for (;;)
    {
      return;
      if (this.jdField_e_of_type_Boolean)
      {
        QLog.w(jdField_b_of_type_JavaLangString, 1, "[showQuickReply], has shown, return.");
        return;
      }
      Object localObject1 = this.jdField_a_of_type_Avds.a(this.jdField_a_of_type_Avdr.jdField_c_of_type_JavaLangString);
      if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
      {
        QLog.i(jdField_b_of_type_JavaLangString, 1, "[showQuickReply], no quick replys, return.");
        return;
      }
      paramString = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        avbx localavbx = new avbx();
        localavbx.jdField_a_of_type_JavaLangString = ((String)localObject2);
        paramString.add(localavbx);
      }
      localObject1 = getAIOList();
      int i = 0;
      if (i < ((List)localObject1).size())
      {
        localObject2 = (ChatMessage)((List)localObject1).get(i);
        if ((localObject2 == null) || ((localObject2 instanceof MessageForUniteGrayTip))) {}
      }
      for (i = 1;; i = 0)
      {
        if ((i != 0) || (this.jdField_a_of_type_Avex == null) || (paramString.size() <= 0)) {
          break label338;
        }
        this.jdField_f_of_type_Boolean = false;
        this.jdField_e_of_type_Boolean = true;
        this.jdField_a_of_type_Avex.a(paramString);
        localObject1 = new StringBuilder(500);
        paramString = paramString.iterator();
        for (;;)
        {
          if (paramString.hasNext())
          {
            ((StringBuilder)localObject1).append(((avbx)paramString.next()).jdField_a_of_type_JavaLangString).append("|");
            continue;
            i += 1;
            break;
          }
        }
        avdu.a(this.jdField_a_of_type_Avdr.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "207648", ((StringBuilder)localObject1).toString(), "", "8", "");
        return;
      }
    }
  }
  
  @TargetApi(14)
  private void d()
  {
    hideAllPanels();
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      Object localObject1 = new RelativeLayout(getActivity());
      Object localObject2 = new RoundRectLinearLayout(getActivity());
      ((RoundRectLinearLayout)localObject2).setRoundRect(AIOUtils.dp2px(15.0F, getActivity().getResources()), -1, false);
      Object localObject3 = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(30.0F, getActivity().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new View(getActivity());
      ((View)localObject2).setBackgroundColor(-1);
      localObject3 = new RelativeLayout.LayoutParams(-1, AIOUtils.dp2px(450.0F, getActivity().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(10.0F, getActivity().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new TextView(getActivity());
      ((TextView)localObject2).setText("游戏中心启动专属特权");
      ((TextView)localObject2).setTextColor(-13421773);
      ((TextView)localObject2).setTextSize(20.0F);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(20.0F, getActivity().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.dp2px(20.0F, getActivity().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new ImageView(getActivity());
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((ImageView)localObject2).setImageResource(2130850902);
      ((ImageView)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(11);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(5.0F, getActivity().getResources());
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = AIOUtils.dp2px(10.0F, getActivity().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new ImageView(getActivity());
      localObject3 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(60.0F, getActivity().getResources()), AIOUtils.dp2px(60.0F, getActivity().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(66.0F, getActivity().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.dp2px(20.0F, getActivity().getResources());
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Avdr.j))
      {
        new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/boxcard/").mkdirs();
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = AIOUtils.dp2px(60.0F, getActivity().getResources());
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = AIOUtils.dp2px(60.0F, getActivity().getResources());
        ((ImageView)localObject2).setImageDrawable(anev.a(Utils.Crc64String(this.jdField_a_of_type_Avdr.j), (URLDrawable.URLDrawableOptions)localObject4, this.jdField_a_of_type_Avdr.j));
      }
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new TextView(getActivity());
      if (this.jdField_a_of_type_Avdr != null) {
        ((TextView)localObject2).setText(this.jdField_a_of_type_Avdr.i);
      }
      ((TextView)localObject2).setTextColor(-13421773);
      ((TextView)localObject2).setTextSize(15.0F);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(75.0F, getActivity().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.dp2px(88.0F, getActivity().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new TextView(getActivity());
      ((TextView)localObject2).setText("启动特权生效中");
      ((TextView)localObject2).setClickable(false);
      ((TextView)localObject2).setTextColor(-32768);
      ((TextView)localObject2).setDuplicateParentStateEnabled(false);
      ((TextView)localObject2).setBackgroundDrawable(new asbh(385843200, AIOUtils.dp2px(4.0F, getActivity().getResources()), AIOUtils.dp2px(80.0F, getActivity().getResources()), AIOUtils.dp2px(18.0F, getActivity().getResources())));
      ((TextView)localObject2).setTextSize(10.0F);
      ((TextView)localObject2).setGravity(17);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(9);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(101.0F, getActivity().getResources());
      ((RelativeLayout.LayoutParams)localObject3).leftMargin = AIOUtils.dp2px(88.0F, getActivity().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject2 = new View(getActivity());
      ((View)localObject2).setBackgroundColor(369098752);
      localObject3 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(335.0F, getActivity().getResources()), 1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.dp2px(142.0F, getActivity().getResources());
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        int i = 0;
        while ((i < this.jdField_a_of_type_JavaUtilList.size()) && (i < 4))
        {
          localObject2 = (aias)this.jdField_a_of_type_JavaUtilList.get(i);
          localObject3 = new ImageView(getActivity());
          ((ImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          localObject4 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(40.0F, getActivity().getResources()), AIOUtils.dp2px(40.0F, getActivity().getResources()));
          ((RelativeLayout.LayoutParams)localObject4).addRule(10);
          ((RelativeLayout.LayoutParams)localObject4).addRule(9);
          ((RelativeLayout.LayoutParams)localObject4).topMargin = AIOUtils.dp2px(158.0F, getActivity().getResources());
          f1 = (float)((DeviceInfoUtil.getPortraitWidth() - AIOUtils.dp2px(40.0F, getActivity().getResources()) * this.jdField_a_of_type_JavaUtilList.size()) / (this.jdField_a_of_type_JavaUtilList.size() + 1));
          ((RelativeLayout.LayoutParams)localObject4).leftMargin = ((int)(f1 + (AIOUtils.dp2px(40.0F, getActivity().getResources()) + f1) * i));
          if (!TextUtils.isEmpty(((aias)localObject2).jdField_a_of_type_JavaLangString)) {
            ((ImageView)localObject3).setImageDrawable(URLDrawable.getDrawable(((aias)localObject2).jdField_a_of_type_JavaLangString));
          }
          ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          localObject3 = new TextView(getActivity());
          ((TextView)localObject3).setText(((aias)localObject2).jdField_b_of_type_JavaLangString);
          ((TextView)localObject3).setTextColor(-2144128205);
          ((TextView)localObject3).setTextSize(12.0F);
          ((TextView)localObject3).setLines(3);
          ((TextView)localObject3).setGravity(3);
          localObject2 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(63.0F, getActivity().getResources()), -2);
          ((RelativeLayout.LayoutParams)localObject2).addRule(10);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9);
          f1 = (float)((DeviceInfoUtil.getPortraitWidth() - AIOUtils.dp2px(63.0F, getActivity().getResources()) * this.jdField_a_of_type_JavaUtilList.size()) / (this.jdField_a_of_type_JavaUtilList.size() + 1));
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(f1 + (AIOUtils.dp2px(63.0F, getActivity().getResources()) + f1) * i));
          ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.dp2px(208.0F, getActivity().getResources());
          ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
          i += 1;
        }
      }
      localObject2 = new RoundRectLinearLayout(getActivity());
      localObject3 = new RelativeLayout.LayoutParams(AIOUtils.dp2px(335.0F, getActivity().getResources()), AIOUtils.dp2px(40.0F, getActivity().getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(12);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.dp2px(32.0F, getActivity().getResources());
      ((RoundRectLinearLayout)localObject2).setGravity(17);
      float f1 = AIOUtils.dp2px(20.0F, getActivity().getResources());
      Object localObject4 = new ShapeDrawable(new RoundRectShape(new float[] { f1, f1, f1, f1, f1, f1, f1, f1 }, null, null));
      LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, AIOUtils.dp2px(335.0F, getActivity().getResources()), 0.0F, -16733441, -16751361, Shader.TileMode.CLAMP);
      ((ShapeDrawable)localObject4).getPaint().setShader(localLinearGradient);
      ((RoundRectLinearLayout)localObject2).setBackgroundDrawable((Drawable)localObject4);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new TextView(getActivity());
      ((TextView)localObject3).setText("立即启动");
      ((TextView)localObject3).setTextColor(-1);
      ((TextView)localObject3).setTextSize(16.0F);
      ((TextView)localObject3).getPaint().setFakeBoldText(true);
      ((TextView)localObject3).setGravity(17);
      ((RoundRectLinearLayout)localObject2).addView((View)localObject3);
      ((RoundRectLinearLayout)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(getActivity(), 2131755829);
      this.jdField_a_of_type_AndroidAppDialog.setContentView((View)localObject1);
      localObject1 = this.jdField_a_of_type_AndroidAppDialog.getWindow();
      ((Window)localObject1).setGravity(80);
      if (Build.VERSION.SDK_INT >= 14) {
        ((Window)localObject1).setDimAmount(0.5F);
      }
      ((Window)localObject1).setWindowAnimations(2131755547);
      ((Window)localObject1).setLayout(-1, AIOUtils.dp2px(460.0F, getActivity().getResources()));
    }
    if (this.jdField_a_of_type_Avdr != null) {
      avdu.a(this.jdField_a_of_type_Avdr.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "207564", "", "", "8", "0");
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public aiat a()
  {
    return this.jdField_a_of_type_Aiat;
  }
  
  public avdr a()
  {
    return this.jdField_a_of_type_Avdr;
  }
  
  public void a(String paramString)
  {
    admo localadmo = new admo();
    setSendTextMsgParams(localadmo);
    admh.a(this.app, this.mContext, this.sessionInfo, paramString, null, localadmo);
    this.jdField_f_of_type_Boolean = true;
  }
  
  public void addBusinessObservers()
  {
    super.addBusinessObservers();
    this.app.addObserver(this.jdField_a_of_type_Aved);
    this.app.addDefaultObservers(this.jdField_a_of_type_Anyz);
  }
  
  public void adjustInputLayout(int paramInt)
  {
    super.adjustInputLayout(paramInt);
    agie localagie = (agie)getHelper(56);
    if (localagie != null) {
      localagie.d();
    }
  }
  
  public aiat b()
  {
    return this.jdField_b_of_type_Aiat;
  }
  
  public boolean doOnCreate(boolean paramBoolean)
  {
    this.jdField_a_of_type_Avds = ((avds)this.app.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER));
    a();
    QLog.i(jdField_b_of_type_JavaLangString, 1, "[doOnCreate]");
    return super.doOnCreate(paramBoolean);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    if (this.jdField_a_of_type_Avex != null) {
      this.jdField_a_of_type_Avex.a();
    }
    if (this.jdField_a_of_type_Aikm != null) {
      this.jdField_a_of_type_Aikm.a();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    agie localagie = (agie)getHelper(56);
    if (localagie != null) {
      localagie.a(getStatusTxtDartElseLight());
    }
    if (this.jdField_a_of_type_Avds != null) {
      this.jdField_a_of_type_Avds.c(this.sessionInfo.curFriendUin);
    }
  }
  
  public void doOnResume_updateUI()
  {
    super.doOnResume_updateUI();
    agie localagie = (agie)getHelper(56);
    if (localagie != null) {
      localagie.a(this.mTitleBtnLeft);
    }
  }
  
  public void doPanelChanged(int paramInt1, int paramInt2)
  {
    super.doPanelChanged(paramInt1, paramInt2);
    agie localagie = (agie)getHelper(56);
    if (localagie != null) {
      localagie.a(paramInt1, paramInt2);
    }
  }
  
  public boolean enableBlur()
  {
    return this.isThemeDefault;
  }
  
  public List<ChatMessage> getAIOList()
  {
    return super.getAIOList();
  }
  
  public List<ChatMessage> getAIOList(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return super.getAIOList(paramQQAppInterface, paramBoolean);
  }
  
  public List<ChatMessage> getAIOList(boolean paramBoolean)
  {
    return super.getAIOList(paramBoolean);
  }
  
  public void getAndParseAIOList()
  {
    super.getAndParseAIOList();
  }
  
  public int initHaveUnRead()
  {
    return super.initHaveUnRead();
  }
  
  public void initHelper()
  {
    super.initHelper();
    this.helperProvider.a(this);
  }
  
  public void initTipsTaskList()
  {
    super.initTipsTaskList();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.jdField_a_of_type_Avdr == null) {
          break;
        }
        if (this.jdField_a_of_type_Avdr != null) {
          avdu.a(this.jdField_a_of_type_Avdr.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206356", "", "", "20", "0");
        }
        if (this.jdField_a_of_type_Avdr.jdField_c_of_type_Int == 0)
        {
          if (b()) {
            continue;
          }
          label122:
          if ((!this.jdField_f_of_type_Boolean) && (this.jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_Avdr != null)) {
            avdu.a(this.jdField_a_of_type_Avdr.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "207647", "", "", "8", this.app.getCurrentAccountUin(), this.sessionInfo.curFriendUin, "");
          }
          this.jdField_f_of_type_Boolean = true;
          break;
        }
        try
        {
          if (this.input.getText().toString().getBytes().length <= this.jdField_a_of_type_Avdr.d) {
            break label122;
          }
          ChatActivityUtils.a(this.mContext, 2131692696, 1);
        }
        catch (Throwable localThrowable) {}
        break;
        if (this.jdField_a_of_type_Avdr != null) {
          avdu.a(this.jdField_a_of_type_Avdr.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "207563", "", "", "20", "0");
        }
        b();
        boolean bool = arqj.a(this.jdField_d_of_type_JavaLangString, BaseApplicationImpl.getApplication());
        QLog.i(jdField_b_of_type_JavaLangString, 1, "mGamePackageName:" + this.jdField_d_of_type_JavaLangString + " isInstall:" + bool);
        if ((a() != null) && (this.jdField_a_of_type_Int == 1) && (bool) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
        {
          d();
        }
        else
        {
          if (!a()) {
            break;
          }
          continue;
          b();
          bool = arqj.a(this.jdField_d_of_type_JavaLangString, BaseApplicationImpl.getApplication());
          QLog.i(jdField_b_of_type_JavaLangString, 1, "mGamePackageName:" + this.jdField_d_of_type_JavaLangString + " isInstall:" + bool);
          if ((a() != null) && (this.jdField_a_of_type_Int == 1) && (bool) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
          {
            if (this.jdField_a_of_type_Avdr != null)
            {
              avdu.a(this.jdField_a_of_type_Avdr.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206357", "1", "", "20", "0");
              avdu.a(this.jdField_a_of_type_Avdr.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "207565", "", "", "20", "0");
            }
            d();
          }
          else
          {
            if (this.jdField_a_of_type_Avdr != null) {
              avdu.a(this.jdField_a_of_type_Avdr.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206357", "0", "", "20", "0");
            }
            if (!a()) {
              break;
            }
          }
        }
      }
      if (this.jdField_a_of_type_Avdr != null) {
        avdu.a(this.jdField_a_of_type_Avdr.jdField_c_of_type_JavaLangString, "1", "145", "920", "92005", "206355", "", "", "20", "0");
      }
    }
  }
  
  public View onCreatePanel(int paramInt)
  {
    if (paramInt == 3)
    {
      long l = System.currentTimeMillis();
      this.mEmoPanel = ((EmoticonMainPanel)View.inflate(this.mContext, 2131559158, null));
      this.mEmoPanel.setCallBack(this);
      this.mEmoPanel.onlySysAndEmoji = true;
      this.mEmoPanel.setHideAllSettingTabs(true);
      this.mEmoPanel.disableMoreEmotionButton = true;
      this.mEmoPanel.disableGuide = true;
      this.mEmoPanel.setOnlySysEmotionEnable(true);
      this.mEmoPanel.setSysEmotionOrder(avdu.a);
      this.mEmoPanel.init(this.app, this.sessionInfo.curType, this.mContext, getTitleBarHeight(), this.defaultEpId, this.defaultPanelType, this);
      this.mEmoPanel.setEmoSettingVisibility(8);
      this.mEmoPanel.hideAllTabs();
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l));
      }
      return this.mEmoPanel;
    }
    return super.onCreatePanel(paramInt);
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    agie localagie = (agie)getHelper(56);
    if (localagie != null) {
      localagie.a(getStatusTxtDartElseLight());
    }
  }
  
  public void onShowFirst(int paramInt)
  {
    super.onShowFirst(paramInt);
    QLog.i(jdField_b_of_type_JavaLangString, 1, "[onShowFirst]");
    c("onShowFirst");
  }
  
  public void refreshListAdapter()
  {
    super.refreshListAdapter();
    a(this.jdField_a_of_type_Avdr);
  }
  
  public void removeBusinessObservers()
  {
    super.removeBusinessObservers();
    this.app.removeObserver(this.jdField_a_of_type_Anyz);
    this.app.removeObserver(this.jdField_a_of_type_Aved);
  }
  
  public void setReaded()
  {
    super.setReaded();
  }
  
  public void setReaded(QQAppInterface paramQQAppInterface)
  {
    super.setReaded(paramQQAppInterface);
  }
  
  public void showBottomBar()
  {
    super.showBottomBar();
    agie localagie = (agie)getHelper(56);
    if (localagie != null) {
      localagie.c();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (((paramObject instanceof MessageRecord)) && (((MessageRecord)paramObject).istroop == 10007) && (this.jdField_b_of_type_Int == 3) && (!this.jdField_d_of_type_Boolean))
    {
      this.app.getProxyManager().a().a(this.sessionInfo.curFriendUin, 10007, 0);
      this.jdField_d_of_type_Boolean = true;
      QLog.d(jdField_b_of_type_JavaLangString, 2, "[update], save conversation.");
    }
  }
  
  public void updateSession_updateSubTitle()
  {
    a(this.jdField_a_of_type_Avdr);
  }
  
  public void updateSession_updateTitle(Intent paramIntent)
  {
    a(this.jdField_a_of_type_Avdr);
  }
  
  public void updateSession_updateTitleLeftView(Intent paramIntent)
  {
    super.updateSession_updateTitleLeftView(paramIntent);
  }
  
  public void updateSession_updateTitleRightView()
  {
    super.updateSession_updateTitleRightView();
  }
  
  public void updateSession_updateUI(Intent paramIntent)
  {
    super.updateSession_updateUI(paramIntent);
    a(this.jdField_a_of_type_Avdr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiah
 * JD-Core Version:    0.7.0.1
 */