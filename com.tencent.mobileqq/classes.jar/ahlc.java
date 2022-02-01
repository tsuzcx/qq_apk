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
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.TofuAioMiniProfileItemBuilder.1;
import com.tencent.mobileqq.activity.aio.item.TofuAioMiniProfileItemBuilder.5;
import com.tencent.mobileqq.activity.aio.item.view.AioMiniProfileLabelFlowLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.MessageForTofuAioMiniProfile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.CircleBoarderImageView;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ahlc
  extends afuu
  implements View.OnClickListener, aobv
{
  private aobu jdField_a_of_type_Aobu;
  private String jdField_a_of_type_JavaLangString;
  private Map<String, CircleBoarderImageView> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public ahlc(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Aobu = new aobu(this.jdField_a_of_type_AndroidContentContext, paramQQAppInterface);
    this.jdField_a_of_type_Aobu.a(this);
    a(paramQQAppInterface);
  }
  
  private View a(View paramView, ahlg paramahlg)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558860, null);
      ahlg.a(paramahlg, (RoundCorneredRelativeLayout)localView.findViewById(2131376640));
      ahlg.a(paramahlg, (RelativeLayout)localView.findViewById(2131376743));
      ahlg.a(paramahlg, (TextView)localView.findViewById(2131379688));
      ahlg.b(paramahlg, (TextView)localView.findViewById(2131379508));
      ahlg.c(paramahlg, (TextView)localView.findViewById(2131379757));
      ahlg.a(paramahlg, (LinearLayout)localView.findViewById(2131370033));
      ahlg.a(paramahlg, localView.findViewById(2131365592));
      ahlg.b(paramahlg, localView.findViewById(2131365593));
      ahlg.d(paramahlg, (TextView)localView.findViewById(2131379910));
      ahlg.e(paramahlg, (TextView)localView.findViewById(2131379584));
      ahlg.c(paramahlg, localView.findViewById(2131365594));
      ahlg.b(paramahlg, (LinearLayout)localView.findViewById(2131370034));
      ahlg.a(paramahlg, (AvatarLayout)localView.findViewById(2131362532));
      ahlg.a(paramahlg, (DynamicAvatarView)localView.findViewById(2131365249));
      ahlg.a(paramahlg, (AioMiniProfileLabelFlowLayout)localView.findViewById(2131366697));
      ahlg.d(paramahlg, localView.findViewById(2131365598));
      ahlg.a(paramahlg, (FrameLayout)localView.findViewById(2131366668));
      ahlg.c(paramahlg, (LinearLayout)localView.findViewById(2131370155));
      ahlg.f(paramahlg, (TextView)localView.findViewById(2131379957));
      ahlg.a(paramahlg, (GridView)localView.findViewById(2131367742));
      ahlg.g(paramahlg, (TextView)localView.findViewById(2131379906));
    }
    return localView;
  }
  
  private void a(ahlg paramahlg, bajq parambajq)
  {
    int m = 1;
    if (parambajq == null)
    {
      ahlg.a(paramahlg).setVisibility(8);
      return;
    }
    ahlg.a(paramahlg).setVisibility(0);
    int i;
    label74:
    label125:
    int k;
    if ((parambajq.jdField_b_of_type_Int == 1) || (parambajq.jdField_b_of_type_Int == 2))
    {
      ahlg.a(paramahlg).setVisibility(0);
      TextView localTextView = ahlg.a(paramahlg);
      if (parambajq.jdField_b_of_type_Int == 1)
      {
        i = 2131693461;
        localTextView.setText(i);
        i = 1;
        if (parambajq.jdField_a_of_type_Int < 0) {
          break label313;
        }
        ahlg.b(paramahlg).setVisibility(0);
        ahlg.b(paramahlg).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689944, new Object[] { Integer.valueOf(parambajq.jdField_a_of_type_Int) }));
        j = 1;
        if (TextUtils.isEmpty(parambajq.jdField_a_of_type_JavaLangString)) {
          break label328;
        }
        ahlg.c(paramahlg).setVisibility(0);
        ahlg.c(paramahlg).setText(parambajq.jdField_a_of_type_JavaLangString);
        k = 1;
        label157:
        i = i + j + k;
        if (i != 3) {
          break label343;
        }
        ahlg.b(paramahlg).setVisibility(0);
        ahlg.c(paramahlg).setVisibility(0);
        label186:
        if (TextUtils.isEmpty(parambajq.jdField_b_of_type_JavaLangString)) {
          break label456;
        }
        ahlg.d(paramahlg).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689943, new Object[] { parambajq.jdField_b_of_type_JavaLangString }));
        i = 1;
        label228:
        if (parambajq.c <= 0) {
          break label470;
        }
        ahlg.e(paramahlg).setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689651), new Object[] { Integer.valueOf(parambajq.c) }));
      }
    }
    for (int j = m;; j = 0)
    {
      if ((j == 0) || (i == 0)) {
        break label485;
      }
      ahlg.d(paramahlg).setVisibility(0);
      return;
      i = 2131692055;
      break;
      ahlg.a(paramahlg).setVisibility(8);
      i = 0;
      break label74;
      label313:
      ahlg.b(paramahlg).setVisibility(8);
      j = 0;
      break label125;
      label328:
      ahlg.c(paramahlg).setVisibility(8);
      k = 0;
      break label157;
      label343:
      if (i == 2)
      {
        if ((j == 1) && (k == 1))
        {
          ahlg.b(paramahlg).setVisibility(8);
          ahlg.c(paramahlg).setVisibility(0);
          break label186;
        }
        ahlg.b(paramahlg).setVisibility(0);
        ahlg.c(paramahlg).setVisibility(8);
        break label186;
      }
      if (i == 1)
      {
        ahlg.b(paramahlg).setVisibility(8);
        ahlg.c(paramahlg).setVisibility(8);
        break label186;
      }
      ahlg.b(paramahlg).setVisibility(8);
      ahlg.c(paramahlg).setVisibility(8);
      ahlg.b(paramahlg).setVisibility(8);
      break label186;
      label456:
      ahlg.d(paramahlg).setVisibility(8);
      i = 0;
      break label228;
      label470:
      ahlg.e(paramahlg).setVisibility(8);
    }
    label485:
    ahlg.d(paramahlg).setVisibility(8);
  }
  
  private void a(ahlg paramahlg, bajs parambajs)
  {
    ahlg.a(paramahlg).setVisibility(0);
    ahlg.a(paramahlg).setVisibility(0);
    TextView localTextView = ahlg.f(paramahlg);
    if (TextUtils.isEmpty(parambajs.jdField_a_of_type_JavaLangString)) {}
    for (String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131715711);; str = parambajs.jdField_a_of_type_JavaLangString)
    {
      localTextView.setText(str);
      if (ahlg.a(paramahlg) == null) {
        break label170;
      }
      if (!ahlg.a(paramahlg).a(parambajs.jdField_a_of_type_JavaUtilList)) {
        break;
      }
      return;
    }
    ahlg.a(paramahlg).a(false);
    ahlg.a(paramahlg).a();
    for (;;)
    {
      ahlg.a(paramahlg).a(parambajs.jdField_a_of_type_JavaUtilList);
      ahlg.a(paramahlg).setAdapter(ahlg.a(paramahlg));
      ahlg.a(paramahlg).setClickable(false);
      ahlg.a(paramahlg).setEnabled(false);
      ahlg.a(paramahlg).setOnTouchListener(mue.a);
      ahlg.a(paramahlg).setOnClickListener(new ahld(this));
      ahlg.g(paramahlg).setVisibility(8);
      return;
      label170:
      ahlg.a(paramahlg, new amef(this.jdField_a_of_type_AndroidContentContext, false));
    }
  }
  
  private void a(ahlg paramahlg, bajt parambajt)
  {
    ahlg.a(paramahlg).setVisibility(0);
    ahlg.a(paramahlg).setVisibility(0);
    ahlg.g(paramahlg).setVisibility(0);
    Object localObject;
    if (parambajt.jdField_a_of_type_Int != 0)
    {
      localObject = ((bbck)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15)).a(parambajt.jdField_a_of_type_Int, 200);
      localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
      int i = afur.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
    }
    for (;;)
    {
      ahlg.g(paramahlg).setCompoundDrawables((Drawable)localObject, null, null, null);
      ahlg.g(paramahlg).setText(parambajt.jdField_a_of_type_JavaLangString + " " + parambajt.jdField_b_of_type_JavaLangString);
      ahlg.a(paramahlg).setOnTouchListener(mue.a);
      ahlg.a(paramahlg).setOnClickListener(new ahlf(this));
      ahlg.c(paramahlg).setVisibility(8);
      return;
      localObject = null;
    }
  }
  
  private void a(ahlg paramahlg, QQAppInterface paramQQAppInterface)
  {
    if ((paramahlg == null) || (paramQQAppInterface == null)) {}
    int i;
    label338:
    for (;;)
    {
      return;
      i = Color.parseColor("#FCFCFC");
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
        ahlg.a(paramahlg).setTextColor(i2);
        ahlg.b(paramahlg).setTextColor(i2);
        ahlg.c(paramahlg).setTextColor(i2);
        ahlg.d(paramahlg).setTextColor(i3);
        ahlg.e(paramahlg).setTextColor(i3);
        ahlg.f(paramahlg).setTextColor(i3);
        ahlg.g(paramahlg).setTextColor(i2);
        ahlg.a(paramahlg).setBackgroundColor(i4);
        ahlg.a(paramahlg).setBackgroundColor(i5);
        ahlg.a(paramahlg).setBackgroundColor(i6);
      }
      for (;;)
      {
        if ((!ThemeUtil.isSimpleDayTheme(false)) || (ThemeUtil.isNowThemeIsNight(paramQQAppInterface, false, null))) {
          break label338;
        }
        if (Build.VERSION.SDK_INT < 21) {
          break label340;
        }
        if (this.jdField_a_of_type_AndroidContentContext == null) {
          break;
        }
        ahlg.a(paramahlg).setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850721));
        return;
        ahlg.a(paramahlg).setTextColor(j);
        ahlg.b(paramahlg).setTextColor(j);
        ahlg.c(paramahlg).setTextColor(j);
        ahlg.d(paramahlg).setTextColor(k);
        ahlg.e(paramahlg).setTextColor(k);
        ahlg.f(paramahlg).setTextColor(k);
        ahlg.g(paramahlg).setTextColor(j);
        ahlg.a(paramahlg).setBackgroundColor(m);
        ahlg.a(paramahlg).setBackgroundColor(n);
        ahlg.a(paramahlg).setBackgroundColor(i1);
      }
    }
    label340:
    ahlg.a(paramahlg).setBackgroundColor(i);
  }
  
  private void a(ahlg paramahlg, boolean paramBoolean)
  {
    paramahlg = ahlg.a(paramahlg).getLayoutParams();
    if (paramBoolean)
    {
      paramahlg.height = -2;
      return;
    }
    paramahlg.height = bgtn.a(60.0F);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new TofuAioMiniProfileItemBuilder.5(this), 8, null, false);
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
    for (Object localObject = "null";; localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      QLog.i("TofuAioMiniProfileItemBuilder", 2, (String)localObject + " mContext:" + this.jdField_a_of_type_AndroidContentContext);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidContentContext != null)) {
        break;
      }
      return;
    }
    localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, PublicFragmentActivity.class);
    ((Intent)localObject).putExtra("key_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("key_uin_name", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
    ((Intent)localObject).putExtra("key_open_via", "history-liaotian");
    aevv.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, PublicFragmentActivity.class, SignatureHistoryFragment.class);
  }
  
  private void b(ahlg paramahlg, List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      ahlg.a(paramahlg).setVisibility(8);
      a(paramahlg, false);
      return;
    }
    ahlg.a(paramahlg).setVisibility(0);
    if (ahlg.a(paramahlg) != null) {
      ahlg.a(paramahlg).a();
    }
    for (;;)
    {
      ahlg.a(paramahlg).a(paramList);
      ahlg.a(paramahlg).setAdapter(ahlg.a(paramahlg));
      a(paramahlg, true);
      return;
      ahlg.a(paramahlg, new amau(this.jdField_a_of_type_AndroidContentContext));
    }
  }
  
  private void b(String paramString, ahlg paramahlg)
  {
    ahlg.a(paramahlg).a(0, ahlg.a(paramahlg), false);
    if ((paramString == null) || (paramString.length() == 0)) {
      ahlg.a(paramahlg).setImageResource(2130840264);
    }
    for (;;)
    {
      ahlg.a(paramahlg).setOnClickListener(this);
      a(paramString, paramahlg);
      return;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, paramString, (byte)3, 0, 100, true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject);
      if (localObject != null) {
        ahlg.a(paramahlg).setImageBitmap((Bitmap)localObject);
      } else {
        ahlg.a(paramahlg).setImageResource(2130840264);
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
    for (Object localObject = "null";; localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      QLog.i("TofuAioMiniProfileItemBuilder", 2, (String)localObject + " mContext:" + this.jdField_a_of_type_AndroidContentContext);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidContentContext != null)) {
        break;
      }
      return;
    }
    localObject = new ProfileActivity.AllInOne(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 1);
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
    for (String str = "null";; str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
    {
      QLog.i("TofuAioMiniProfileItemBuilder", 2, str + " mContext:" + this.jdField_a_of_type_AndroidContentContext);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_AndroidContentContext != null)) {
        break;
      }
      return;
    }
    try
    {
      blsb.a(this.jdField_a_of_type_AndroidContentContext, blsi.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TofuAioMiniProfileItemBuilder", 1, localException, new Object[0]);
    }
  }
  
  protected afuv a()
  {
    return new ahlg();
  }
  
  protected View a(MessageRecord paramMessageRecord, afuv paramafuv, View paramView, LinearLayout paramLinearLayout, afzq paramafzq)
  {
    paramMessageRecord = (MessageForTofuAioMiniProfile)paramMessageRecord;
    paramafuv = (ahlg)paramafuv;
    paramView = a(paramView, paramafuv);
    paramafuv.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    if (QLog.isColorLevel()) {
      QLog.i("TofuAioMiniProfileItemBuilder", 2, "getItemView and miniCard:" + paramMessageRecord.miniCard);
    }
    if (paramMessageRecord.miniCard != null)
    {
      int i = bgtn.a(16.0F);
      ahlg.a(paramafuv).a(true);
      ahlg.a(paramafuv).setRadius(i, i, i, i);
      ahlg.a(paramafuv).setOnClickListener(this);
      ahlg.a(paramafuv).setOnTouchListener(mue.a);
      paramView.setVisibility(0);
      b(paramafuv.jdField_a_of_type_JavaLangString, paramafuv);
      a(paramafuv, paramMessageRecord.miniCard.jdField_a_of_type_Bajq);
      b(paramafuv, paramMessageRecord.miniCard.jdField_a_of_type_JavaUtilList);
      if ((paramMessageRecord.miniCard.jdField_a_of_type_Bajs != null) && (paramMessageRecord.miniCard.jdField_a_of_type_Bajs.jdField_a_of_type_JavaUtilList != null) && (paramMessageRecord.miniCard.jdField_a_of_type_Bajs.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        a(paramafuv, paramMessageRecord.miniCard.jdField_a_of_type_Bajs);
        this.jdField_a_of_type_JavaLangString = "空间";
        a(paramafuv, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (;;)
    {
      if (!paramafuv.jdField_a_of_type_Boolean)
      {
        paramafuv.jdField_a_of_type_Boolean = true;
        ThreadManagerV2.excute(new TofuAioMiniProfileItemBuilder.1(this, paramafuv), 128, null, true);
        bcst.b(null, "dc00898", "", "", "0X800B1A8", "0X800B1A8", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
      }
      return paramView;
      if ((paramMessageRecord.miniCard.b != null) && (paramMessageRecord.miniCard.b.size() > 0))
      {
        a(paramafuv, paramMessageRecord.miniCard.b);
        this.jdField_a_of_type_JavaLangString = "精选照片";
        break;
      }
      if (paramMessageRecord.miniCard.jdField_a_of_type_Bajt != null)
      {
        a(paramafuv, paramMessageRecord.miniCard.jdField_a_of_type_Bajt);
        this.jdField_a_of_type_JavaLangString = "个性签名";
        break;
      }
      ahlg.a(paramafuv).setVisibility(8);
      ahlg.a(paramafuv).setVisibility(8);
      this.jdField_a_of_type_JavaLangString = "无信息";
      break;
      paramView.setVisibility(8);
    }
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Aobu != null) {
      this.jdField_a_of_type_Aobu.d();
    }
  }
  
  public void a(ahlg paramahlg, List<bajr> paramList)
  {
    ahlg.a(paramahlg).setVisibility(0);
    ahlg.a(paramahlg).setVisibility(0);
    ahlg.f(paramahlg).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694568));
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (bajr)localIterator.next();
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
    if (ahlg.a(paramahlg) != null)
    {
      if (ahlg.a(paramahlg).a(localArrayList2)) {
        return;
      }
      ahlg.a(paramahlg).a();
      ahlg.a(paramahlg).a(true);
    }
    for (;;)
    {
      ahlg.a(paramahlg).a(localArrayList2);
      ahlg.a(paramahlg).setAdapter(ahlg.a(paramahlg));
      ahlg.a(paramahlg).setClickable(true);
      ahlg.a(paramahlg).setEnabled(true);
      ahlg.a(paramahlg).setOnTouchListener(null);
      ahlg.a(paramahlg).setOnClickListener(null);
      ahlg.a(paramahlg).setOnItemClickListener(new ahle(this, localArrayList1));
      ahlg.g(paramahlg).setVisibility(8);
      return;
      ahlg.a(paramahlg, new amef(this.jdField_a_of_type_AndroidContentContext, true));
    }
  }
  
  protected void a(String paramString, ahlg paramahlg)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("TofuAioMiniProfileItemBuilder", 4, "updateFace, " + paramString);
    }
    aoch localaoch = aoch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (byte)3);
    ahlg.a(paramahlg).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoch, 1, paramString, 200, true, true, 8);
  }
  
  public bguj[] a(View paramView)
  {
    return new bguj[0];
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
      bcst.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "空白处");
      c();
      continue;
      bcst.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "头像");
      c();
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = (CircleBoarderImageView)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      paramString.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlc
 * JD-Core Version:    0.7.0.1
 */