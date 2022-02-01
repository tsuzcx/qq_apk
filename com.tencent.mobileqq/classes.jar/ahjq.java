import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.TofuAioMiniProfileItemBuilder.1;
import com.tencent.mobileqq.activity.aio.item.TofuAioMiniProfileItemBuilder.6;
import com.tencent.mobileqq.activity.aio.item.view.AioMiniProfileLabelFlowLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.MessageForTofuAioMiniProfile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ahjq
  extends afor
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  private int jdField_a_of_type_Int;
  private azzo jdField_a_of_type_Azzo = new ahjv(this);
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private String jdField_a_of_type_JavaLangString;
  private Map<String, ImageView> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public ahjq(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this.jdField_a_of_type_AndroidContentContext, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_Int = ((int)(Math.random() * azzm.a.length));
    a(paramQQAppInterface);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Azzo);
  }
  
  private View a(View paramView, ahjw paramahjw)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558892, null);
      ahjw.a(paramahjw, (RoundCorneredRelativeLayout)localView.findViewById(2131376802));
      ahjw.a(paramahjw, (ViewGroup)localView.findViewById(2131376898));
      ahjw.a(paramahjw, (TextView)localView.findViewById(2131379950));
      ahjw.b(paramahjw, (TextView)localView.findViewById(2131379763));
      ahjw.c(paramahjw, (TextView)localView.findViewById(2131380019));
      ahjw.b(paramahjw, (ViewGroup)localView.findViewById(2131370304));
      ahjw.a(paramahjw, localView.findViewById(2131365761));
      ahjw.b(paramahjw, localView.findViewById(2131365762));
      ahjw.d(paramahjw, (TextView)localView.findViewById(2131380167));
      ahjw.e(paramahjw, (TextView)localView.findViewById(2131379851));
      ahjw.c(paramahjw, localView.findViewById(2131365763));
      ahjw.c(paramahjw, (ViewGroup)localView.findViewById(2131370305));
      ahjw.a(paramahjw, (AvatarLayout)localView.findViewById(2131362565));
      ahjw.a(paramahjw, (DynamicAvatarView)localView.findViewById(2131365418));
      ahjw.a(paramahjw, (AioMiniProfileLabelFlowLayout)localView.findViewById(2131366890));
      ahjw.d(paramahjw, localView.findViewById(2131365768));
      ahjw.a(paramahjw, (FrameLayout)localView.findViewById(2131366865));
      ahjw.d(paramahjw, (ViewGroup)localView.findViewById(2131370404));
      ahjw.f(paramahjw, (TextView)localView.findViewById(2131380210));
      ahjw.a(paramahjw, (GridView)localView.findViewById(2131367979));
      ahjw.g(paramahjw, (TextView)localView.findViewById(2131380162));
      ahjw.e(paramahjw, (ViewGroup)localView.findViewById(2131370375));
      ahjw.a(paramahjw, (ImageView)localView.findViewById(2131374296));
      ahjw.b(paramahjw, (ImageView)localView.findViewById(2131374294));
      ahjw.c(paramahjw, (ImageView)localView.findViewById(2131374295));
      ahjw.h(paramahjw, (TextView)localView.findViewById(2131374309));
      ahjw.d(paramahjw, (ImageView)localView.findViewById(2131374289));
      ahjw.e(paramahjw, (ImageView)localView.findViewById(2131374290));
      ahjw.i(paramahjw, (TextView)localView.findViewById(2131374305));
    }
    return localView;
  }
  
  private void a(ahjw paramahjw, azzl paramazzl)
  {
    ahjw.a(paramahjw).setVisibility(0);
    ahjw.a(paramahjw).setVisibility(0);
    ahjw.d(paramahjw).setVisibility(0);
    ahjw.h(paramahjw).setText(paramazzl.jdField_b_of_type_JavaLangString);
    ahjw.a(paramahjw).setImageBitmap(a(paramahjw.jdField_a_of_type_JavaLangString, ahjw.a(paramahjw)));
    ahjw.i(paramahjw).setText(paramazzl.jdField_c_of_type_JavaLangString);
    ahjw.c(paramahjw).setVisibility(8);
    ahjw.g(paramahjw).setVisibility(8);
    ahjw.d(paramahjw).setOnClickListener(new ahju(this, paramahjw));
  }
  
  private void a(ahjw paramahjw, bbdn parambbdn)
  {
    int m = 1;
    if (parambbdn == null)
    {
      ahjw.a(paramahjw).setVisibility(8);
      return;
    }
    ahjw.a(paramahjw).setVisibility(0);
    int i;
    label75:
    label127:
    int k;
    if ((parambbdn.jdField_b_of_type_Int == 1) || (parambbdn.jdField_b_of_type_Int == 2))
    {
      ahjw.a(paramahjw).setVisibility(0);
      TextView localTextView = ahjw.a(paramahjw);
      if (parambbdn.jdField_b_of_type_Int == 1)
      {
        i = 2131693752;
        localTextView.setText(i);
        i = 1;
        if (parambbdn.jdField_a_of_type_Int < 0) {
          break label318;
        }
        ahjw.b(paramahjw).setVisibility(0);
        ahjw.b(paramahjw).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689994, new Object[] { Integer.valueOf(parambbdn.jdField_a_of_type_Int) }));
        j = 1;
        if (TextUtils.isEmpty(parambbdn.jdField_a_of_type_JavaLangString)) {
          break label333;
        }
        ahjw.c(paramahjw).setVisibility(0);
        ahjw.c(paramahjw).setText(parambbdn.jdField_a_of_type_JavaLangString);
        k = 1;
        label159:
        i = i + j + k;
        if (i != 3) {
          break label348;
        }
        ahjw.b(paramahjw).setVisibility(0);
        ahjw.c(paramahjw).setVisibility(0);
        label188:
        if (TextUtils.isEmpty(parambbdn.jdField_b_of_type_JavaLangString)) {
          break label461;
        }
        ahjw.d(paramahjw).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689993, new Object[] { parambbdn.jdField_b_of_type_JavaLangString }));
        i = 1;
        label231:
        if (parambbdn.c <= 0) {
          break label475;
        }
        ahjw.e(paramahjw).setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689652), new Object[] { Integer.valueOf(parambbdn.c) }));
      }
    }
    for (int j = m;; j = 0)
    {
      if ((j == 0) || (i == 0)) {
        break label490;
      }
      ahjw.d(paramahjw).setVisibility(0);
      return;
      i = 2131692198;
      break;
      ahjw.a(paramahjw).setVisibility(8);
      i = 0;
      break label75;
      label318:
      ahjw.b(paramahjw).setVisibility(8);
      j = 0;
      break label127;
      label333:
      ahjw.c(paramahjw).setVisibility(8);
      k = 0;
      break label159;
      label348:
      if (i == 2)
      {
        if ((j == 1) && (k == 1))
        {
          ahjw.b(paramahjw).setVisibility(8);
          ahjw.c(paramahjw).setVisibility(0);
          break label188;
        }
        ahjw.b(paramahjw).setVisibility(0);
        ahjw.c(paramahjw).setVisibility(8);
        break label188;
      }
      if (i == 1)
      {
        ahjw.b(paramahjw).setVisibility(8);
        ahjw.c(paramahjw).setVisibility(8);
        break label188;
      }
      ahjw.b(paramahjw).setVisibility(8);
      ahjw.c(paramahjw).setVisibility(8);
      ahjw.b(paramahjw).setVisibility(8);
      break label188;
      label461:
      ahjw.d(paramahjw).setVisibility(8);
      i = 0;
      break label231;
      label475:
      ahjw.e(paramahjw).setVisibility(8);
    }
    label490:
    ahjw.d(paramahjw).setVisibility(8);
  }
  
  private void a(ahjw paramahjw, bbdp parambbdp)
  {
    ahjw.a(paramahjw).setVisibility(0);
    ahjw.a(paramahjw).setVisibility(0);
    ahjw.c(paramahjw).setVisibility(0);
    TextView localTextView = ahjw.f(paramahjw);
    if (TextUtils.isEmpty(parambbdp.jdField_a_of_type_JavaLangString)) {}
    for (String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131716402);; str = parambbdp.jdField_a_of_type_JavaLangString)
    {
      localTextView.setText(str);
      if (ahjw.a(paramahjw) == null) {
        break label187;
      }
      if (!ahjw.a(paramahjw).a(parambbdp.jdField_a_of_type_JavaUtilList)) {
        break;
      }
      return;
    }
    ahjw.a(paramahjw).a(false);
    ahjw.a(paramahjw).a();
    for (;;)
    {
      ahjw.a(paramahjw).a(parambbdp.jdField_a_of_type_JavaUtilList);
      ahjw.a(paramahjw).setAdapter(ahjw.a(paramahjw));
      ahjw.a(paramahjw).setClickable(false);
      ahjw.a(paramahjw).setEnabled(false);
      ahjw.a(paramahjw).setOnTouchListener(mvk.a);
      ahjw.a(paramahjw).setOnClickListener(new ahjr(this));
      ahjw.g(paramahjw).setVisibility(8);
      ahjw.d(paramahjw).setVisibility(8);
      return;
      label187:
      ahjw.a(paramahjw, new amiu(this.jdField_a_of_type_AndroidContentContext, false));
    }
  }
  
  private void a(ahjw paramahjw, bbdq parambbdq)
  {
    ahjw.a(paramahjw).setVisibility(0);
    ahjw.a(paramahjw).setVisibility(0);
    ahjw.g(paramahjw).setVisibility(0);
    Object localObject;
    if (parambbdq.jdField_a_of_type_Int != 0)
    {
      localObject = ((bbvn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER)).a(parambbdq.jdField_a_of_type_Int, 200);
      localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
      int i = AIOUtils.dp2px(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
    }
    for (;;)
    {
      ahjw.g(paramahjw).setCompoundDrawables((Drawable)localObject, null, null, null);
      ahjw.g(paramahjw).setText(parambbdq.jdField_a_of_type_JavaLangString + " " + parambbdq.jdField_b_of_type_JavaLangString);
      ahjw.a(paramahjw).setOnTouchListener(mvk.a);
      ahjw.a(paramahjw).setOnClickListener(new ahjt(this));
      ahjw.c(paramahjw).setVisibility(8);
      ahjw.d(paramahjw).setVisibility(8);
      return;
      localObject = null;
    }
  }
  
  private void a(ahjw paramahjw, QQAppInterface paramQQAppInterface)
  {
    if ((paramahjw == null) || (paramQQAppInterface == null)) {
      return;
    }
    int i = Color.parseColor("#FCFCFC");
    int j = Color.parseColor("#03081A");
    int k = Color.parseColor("#878B99");
    int m = Color.parseColor("#EFEFEF");
    int n = Color.parseColor("#FFFFFF");
    int i1 = Color.parseColor("#FAFAFD");
    int i2 = Color.parseColor("#FFFFFF");
    int i3 = Color.parseColor("#838383");
    int i4 = Color.parseColor("#000000");
    int i5 = Color.parseColor("#1F1F1F");
    int i6 = Color.parseColor("#1C1C1E");
    if (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))
    {
      ahjw.a(paramahjw).setTextColor(i2);
      ahjw.b(paramahjw).setTextColor(i2);
      ahjw.c(paramahjw).setTextColor(i2);
      ahjw.d(paramahjw).setTextColor(i3);
      ahjw.e(paramahjw).setTextColor(i3);
      ahjw.f(paramahjw).setTextColor(i3);
      ahjw.g(paramahjw).setTextColor(i2);
      ahjw.a(paramahjw).setBackgroundColor(i4);
      ahjw.e(paramahjw).setBackgroundColor(i5);
      ahjw.a(paramahjw).setBackgroundColor(i6);
      ahjw.h(paramahjw).setTextColor(i3);
      ahjw.i(paramahjw).setTextColor(i2);
      if ((ThemeUtil.isSimpleDayTheme(false)) && (!ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null)))
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label455;
        }
        if (this.jdField_a_of_type_AndroidContentContext != null) {
          ahjw.a(paramahjw).setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850804));
        }
      }
      label264:
      if (!bdfk.b()) {
        break label466;
      }
      ahjw.b(paramahjw).setImageResource(2130845722);
      ahjw.c(paramahjw).setImageResource(2130845719);
      ahjw.d(paramahjw).setImageResource(2130845721);
      ahjw.e(paramahjw).setImageResource(2130845707);
    }
    for (;;)
    {
      i = this.jdField_a_of_type_Int;
      j = azzm.a.length;
      ahjw.c(paramahjw).clearColorFilter();
      ahjw.c(paramahjw).setColorFilter(azzm.a[(i % j)]);
      return;
      ahjw.a(paramahjw).setTextColor(j);
      ahjw.b(paramahjw).setTextColor(j);
      ahjw.c(paramahjw).setTextColor(j);
      ahjw.d(paramahjw).setTextColor(k);
      ahjw.e(paramahjw).setTextColor(k);
      ahjw.f(paramahjw).setTextColor(k);
      ahjw.g(paramahjw).setTextColor(j);
      ahjw.a(paramahjw).setBackgroundColor(m);
      ahjw.e(paramahjw).setBackgroundColor(n);
      ahjw.a(paramahjw).setBackgroundColor(i1);
      ahjw.h(paramahjw).setTextColor(k);
      ahjw.i(paramahjw).setTextColor(j);
      break;
      label455:
      ahjw.e(paramahjw).setBackgroundColor(i);
      break label264;
      label466:
      ahjw.b(paramahjw).setImageResource(2130845717);
      ahjw.c(paramahjw).setImageResource(2130845718);
      ahjw.d(paramahjw).setImageResource(2130845720);
      ahjw.e(paramahjw).setImageResource(2130845706);
    }
  }
  
  private void a(ahjw paramahjw, boolean paramBoolean)
  {
    paramahjw = ahjw.a(paramahjw).getLayoutParams();
    if (paramBoolean)
    {
      paramahjw.height = -2;
      return;
    }
    paramahjw.height = ViewUtils.dip2px(60.0F);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new TofuAioMiniProfileItemBuilder.6(this), 8, null, false);
  }
  
  private void b()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("gotoSignatureHistory and uin:");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        break label87;
      }
    }
    label87:
    for (Object localObject = "null";; localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)
    {
      QLog.i("TofuAioMiniProfileItemBuilder", 2, (String)localObject + " mContext:" + this.jdField_a_of_type_AndroidContentContext);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) && (this.jdField_a_of_type_AndroidContentContext != null)) {
        break;
      }
      return;
    }
    localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicFragmentActivity.class);
    ((Intent)localObject).putExtra("key_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    ((Intent)localObject).putExtra("key_uin_name", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick);
    ((Intent)localObject).putExtra("key_open_via", "history-liaotian");
    aeow.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, PublicFragmentActivity.class, SignatureHistoryFragment.class);
  }
  
  private void b(ahjw paramahjw, List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      ahjw.a(paramahjw).setVisibility(8);
      a(paramahjw, false);
      return;
    }
    ahjw.a(paramahjw).setVisibility(0);
    if (ahjw.a(paramahjw) != null) {
      ahjw.a(paramahjw).a();
    }
    for (;;)
    {
      ahjw.a(paramahjw).a(paramList);
      ahjw.a(paramahjw).setAdapter(ahjw.a(paramahjw));
      a(paramahjw, true);
      return;
      ahjw.a(paramahjw, new amfi(this.jdField_a_of_type_AndroidContentContext));
    }
  }
  
  private void b(String paramString, ahjw paramahjw)
  {
    ahjw.a(paramahjw).a(0, ahjw.a(paramahjw), false);
    if ((paramString == null) || (paramString.length() == 0)) {
      ahjw.a(paramahjw).setImageResource(2130840348);
    }
    for (;;)
    {
      ahjw.a(paramahjw).setOnClickListener(this);
      a(paramString, paramahjw);
      return;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmapCacheKey(1, paramString, (byte)3, 0, 100, true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBitmapFromCache((String)localObject);
      if (localObject != null) {
        ahjw.a(paramahjw).setImageBitmap((Bitmap)localObject);
      } else {
        ahjw.a(paramahjw).setImageResource(2130840348);
      }
    }
  }
  
  private void c()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("gotoProfileCard and uin:");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        break label87;
      }
    }
    label87:
    for (Object localObject = "null";; localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)
    {
      QLog.i("TofuAioMiniProfileItemBuilder", 2, (String)localObject + " mContext:" + this.jdField_a_of_type_AndroidContentContext);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) && (this.jdField_a_of_type_AndroidContentContext != null)) {
        break;
      }
      return;
    }
    localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 1);
    ProfileActivity.b(this.jdField_a_of_type_AndroidContentContext, (ProfileActivity.AllInOne)localObject);
  }
  
  private void d()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("gotoQZoneUserHome and uin:");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
        break label87;
      }
    }
    label87:
    for (String str = "null";; str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)
    {
      QLog.i("TofuAioMiniProfileItemBuilder", 2, str + " mContext:" + this.jdField_a_of_type_AndroidContentContext);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)) && (this.jdField_a_of_type_AndroidContentContext != null)) {
        break;
      }
      return;
    }
    try
    {
      QZoneHelper.forwardToUserHome(this.jdField_a_of_type_AndroidContentContext, QZoneHelper.UserInfo.getInstance(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 0, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TofuAioMiniProfileItemBuilder", 1, localException, new Object[0]);
    }
  }
  
  protected afos a()
  {
    return new ahjw();
  }
  
  public Bitmap a(String paramString, ImageView paramImageView)
  {
    try
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, paramString);
      if (localBitmap != null) {
        return localBitmap;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, 200, true);
        this.jdField_a_of_type_JavaUtilMap.put(paramString, paramImageView);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    return bheg.a();
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    paramMessageRecord = (MessageForTofuAioMiniProfile)paramMessageRecord;
    paramafos = (ahjw)paramafos;
    paramView = a(paramView, paramafos);
    paramafos.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    if (QLog.isColorLevel()) {
      QLog.i("TofuAioMiniProfileItemBuilder", 2, "getItemView and miniCard:" + paramMessageRecord.miniCard);
    }
    if (paramMessageRecord.miniCard != null)
    {
      int i = ViewUtils.dip2px(16.0F);
      ahjw.a(paramafos).enablePressEffect(true);
      ahjw.a(paramafos).setRadius(i, i, i, i);
      ahjw.a(paramafos).setOnClickListener(this);
      ahjw.a(paramafos).setOnTouchListener(mvk.a);
      paramView.setVisibility(0);
      b(paramafos.jdField_a_of_type_JavaLangString, paramafos);
      a(paramafos, paramMessageRecord.miniCard.jdField_a_of_type_Bbdn);
      b(paramafos, paramMessageRecord.miniCard.jdField_a_of_type_JavaUtilList);
      if ((paramMessageRecord.miniCard.jdField_a_of_type_Bbdp != null) && (paramMessageRecord.miniCard.jdField_a_of_type_Bbdp.jdField_a_of_type_JavaUtilList != null) && (paramMessageRecord.miniCard.jdField_a_of_type_Bbdp.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        a(paramafos, paramMessageRecord.miniCard.jdField_a_of_type_Bbdp);
        this.jdField_a_of_type_JavaLangString = "空间";
      }
    }
    for (;;)
    {
      a(paramafos, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!paramafos.jdField_a_of_type_Boolean)
      {
        paramafos.jdField_a_of_type_Boolean = true;
        ThreadManagerV2.excute(new TofuAioMiniProfileItemBuilder.1(this, paramafos), 128, null, true);
        bdla.b(null, "dc00898", "", "", "0X800B1A8", "0X800B1A8", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
        if (!"匿问我答".equals(this.jdField_a_of_type_JavaLangString)) {}
      }
      try
      {
        paramMessageRecord.miniCard.jdField_a_of_type_Azzl.jdField_c_of_type_Long = Long.parseLong(paramafos.jdField_a_of_type_JavaLangString);
        ((azzn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ANONYMOUS_ANSWER_HANDLER)).a(paramMessageRecord.miniCard.jdField_a_of_type_Azzl);
        bdla.b(null, "dc00898", "", paramafos.jdField_a_of_type_JavaLangString, "0X800B5BE", "0X800B5BE", 0, 0, "", "", "", "");
        return paramView;
        if (paramMessageRecord.miniCard.jdField_a_of_type_Azzl != null)
        {
          a(paramafos, paramMessageRecord.miniCard.jdField_a_of_type_Azzl);
          this.jdField_a_of_type_JavaLangString = "匿问我答";
          continue;
        }
        if ((paramMessageRecord.miniCard.b != null) && (paramMessageRecord.miniCard.b.size() > 0))
        {
          a(paramafos, paramMessageRecord.miniCard.b);
          this.jdField_a_of_type_JavaLangString = "精选照片";
          continue;
        }
        if (paramMessageRecord.miniCard.jdField_a_of_type_Bbdq != null)
        {
          a(paramafos, paramMessageRecord.miniCard.jdField_a_of_type_Bbdq);
          this.jdField_a_of_type_JavaLangString = "个性签名";
          continue;
        }
        ahjw.a(paramafos).setVisibility(8);
        ahjw.a(paramafos).setVisibility(8);
        this.jdField_a_of_type_JavaLangString = "无信息";
        continue;
        paramView.setVisibility(8);
      }
      catch (Exception paramMessageRecord)
      {
        for (;;)
        {
          QLog.e("TofuAioMiniProfileItemBuilder", 1, "report exception " + paramMessageRecord);
        }
      }
    }
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    if (this.jdField_a_of_type_JavaUtilMap != null) {
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Azzo);
  }
  
  public void a(ahjw paramahjw, List<bbdo> paramList)
  {
    ahjw.a(paramahjw).setVisibility(0);
    ahjw.a(paramahjw).setVisibility(0);
    ahjw.c(paramahjw).setVisibility(0);
    ahjw.f(paramahjw).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694929));
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (bbdo)localIterator.next();
      if ((!TextUtils.isEmpty(paramList.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramList.jdField_b_of_type_JavaLangString)))
      {
        localArrayList1.add(paramList.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(paramList.jdField_b_of_type_JavaLangString)) {}
        for (paramList = paramList.jdField_b_of_type_JavaLangString;; paramList = paramList.jdField_a_of_type_JavaLangString)
        {
          localArrayList2.add(paramList);
          break;
        }
      }
    }
    if (ahjw.a(paramahjw) != null)
    {
      if (ahjw.a(paramahjw).a(localArrayList2)) {
        return;
      }
      ahjw.a(paramahjw).a();
      ahjw.a(paramahjw).a(true);
    }
    for (;;)
    {
      ahjw.a(paramahjw).a(localArrayList2);
      ahjw.a(paramahjw).setAdapter(ahjw.a(paramahjw));
      ahjw.a(paramahjw).setClickable(true);
      ahjw.a(paramahjw).setEnabled(true);
      ahjw.a(paramahjw).setOnTouchListener(null);
      ahjw.a(paramahjw).setOnClickListener(null);
      ahjw.a(paramahjw).setOnItemClickListener(new ahjs(this, localArrayList1));
      ahjw.g(paramahjw).setVisibility(8);
      ahjw.d(paramahjw).setVisibility(8);
      return;
      ahjw.a(paramahjw, new amiu(this.jdField_a_of_type_AndroidContentContext, true));
    }
  }
  
  protected void a(String paramString, ahjw paramahjw)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("TofuAioMiniProfileItemBuilder", 4, "updateFace, " + paramString);
    }
    FaceDrawable localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (byte)3);
    ahjw.a(paramahjw).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFaceDrawable, 1, paramString, 200, true, true, 8);
  }
  
  public bhjs[] a(View paramView)
  {
    return new bhjs[0];
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdla.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "空白处");
      c();
      continue;
      bdla.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "头像");
      c();
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = (ImageView)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      paramString.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahjq
 * JD-Core Version:    0.7.0.1
 */