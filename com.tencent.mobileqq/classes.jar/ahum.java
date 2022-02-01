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

public class ahum
  extends agem
  implements View.OnClickListener, aoog
{
  private aoof jdField_a_of_type_Aoof;
  private String jdField_a_of_type_JavaLangString;
  private Map<String, CircleBoarderImageView> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public ahum(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Aoof = new aoof(this.jdField_a_of_type_AndroidContentContext, paramQQAppInterface);
    this.jdField_a_of_type_Aoof.a(this);
    a(paramQQAppInterface);
  }
  
  private View a(View paramView, ahuq paramahuq)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558858, null);
      ahuq.a(paramahuq, (RoundCorneredRelativeLayout)localView.findViewById(2131376773));
      ahuq.a(paramahuq, (RelativeLayout)localView.findViewById(2131376879));
      ahuq.a(paramahuq, (TextView)localView.findViewById(2131379866));
      ahuq.b(paramahuq, (TextView)localView.findViewById(2131379677));
      ahuq.c(paramahuq, (TextView)localView.findViewById(2131379935));
      ahuq.a(paramahuq, (LinearLayout)localView.findViewById(2131370135));
      ahuq.a(paramahuq, localView.findViewById(2131365634));
      ahuq.b(paramahuq, localView.findViewById(2131365635));
      ahuq.d(paramahuq, (TextView)localView.findViewById(2131380093));
      ahuq.e(paramahuq, (TextView)localView.findViewById(2131379757));
      ahuq.c(paramahuq, localView.findViewById(2131365636));
      ahuq.b(paramahuq, (LinearLayout)localView.findViewById(2131370136));
      ahuq.a(paramahuq, (AvatarLayout)localView.findViewById(2131362547));
      ahuq.a(paramahuq, (DynamicAvatarView)localView.findViewById(2131365293));
      ahuq.a(paramahuq, (AioMiniProfileLabelFlowLayout)localView.findViewById(2131366747));
      ahuq.d(paramahuq, localView.findViewById(2131365641));
      ahuq.a(paramahuq, (FrameLayout)localView.findViewById(2131366718));
      ahuq.c(paramahuq, (LinearLayout)localView.findViewById(2131370254));
      ahuq.f(paramahuq, (TextView)localView.findViewById(2131380141));
      ahuq.a(paramahuq, (GridView)localView.findViewById(2131367811));
      ahuq.g(paramahuq, (TextView)localView.findViewById(2131380089));
    }
    return localView;
  }
  
  private void a(ahuq paramahuq, bbcj parambbcj)
  {
    int m = 1;
    if (parambbcj == null)
    {
      ahuq.a(paramahuq).setVisibility(8);
      return;
    }
    ahuq.a(paramahuq).setVisibility(0);
    int i;
    label74:
    label125:
    int k;
    if ((parambbcj.jdField_b_of_type_Int == 1) || (parambbcj.jdField_b_of_type_Int == 2))
    {
      ahuq.a(paramahuq).setVisibility(0);
      TextView localTextView = ahuq.a(paramahuq);
      if (parambbcj.jdField_b_of_type_Int == 1)
      {
        i = 2131693473;
        localTextView.setText(i);
        i = 1;
        if (parambbcj.jdField_a_of_type_Int < 0) {
          break label313;
        }
        ahuq.b(paramahuq).setVisibility(0);
        ahuq.b(paramahuq).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689951, new Object[] { Integer.valueOf(parambbcj.jdField_a_of_type_Int) }));
        j = 1;
        if (TextUtils.isEmpty(parambbcj.jdField_a_of_type_JavaLangString)) {
          break label328;
        }
        ahuq.c(paramahuq).setVisibility(0);
        ahuq.c(paramahuq).setText(parambbcj.jdField_a_of_type_JavaLangString);
        k = 1;
        label157:
        i = i + j + k;
        if (i != 3) {
          break label343;
        }
        ahuq.b(paramahuq).setVisibility(0);
        ahuq.c(paramahuq).setVisibility(0);
        label186:
        if (TextUtils.isEmpty(parambbcj.jdField_b_of_type_JavaLangString)) {
          break label456;
        }
        ahuq.d(paramahuq).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689950, new Object[] { parambbcj.jdField_b_of_type_JavaLangString }));
        i = 1;
        label228:
        if (parambbcj.c <= 0) {
          break label470;
        }
        ahuq.e(paramahuq).setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689653), new Object[] { Integer.valueOf(parambbcj.c) }));
      }
    }
    for (int j = m;; j = 0)
    {
      if ((j == 0) || (i == 0)) {
        break label485;
      }
      ahuq.d(paramahuq).setVisibility(0);
      return;
      i = 2131692060;
      break;
      ahuq.a(paramahuq).setVisibility(8);
      i = 0;
      break label74;
      label313:
      ahuq.b(paramahuq).setVisibility(8);
      j = 0;
      break label125;
      label328:
      ahuq.c(paramahuq).setVisibility(8);
      k = 0;
      break label157;
      label343:
      if (i == 2)
      {
        if ((j == 1) && (k == 1))
        {
          ahuq.b(paramahuq).setVisibility(8);
          ahuq.c(paramahuq).setVisibility(0);
          break label186;
        }
        ahuq.b(paramahuq).setVisibility(0);
        ahuq.c(paramahuq).setVisibility(8);
        break label186;
      }
      if (i == 1)
      {
        ahuq.b(paramahuq).setVisibility(8);
        ahuq.c(paramahuq).setVisibility(8);
        break label186;
      }
      ahuq.b(paramahuq).setVisibility(8);
      ahuq.c(paramahuq).setVisibility(8);
      ahuq.b(paramahuq).setVisibility(8);
      break label186;
      label456:
      ahuq.d(paramahuq).setVisibility(8);
      i = 0;
      break label228;
      label470:
      ahuq.e(paramahuq).setVisibility(8);
    }
    label485:
    ahuq.d(paramahuq).setVisibility(8);
  }
  
  private void a(ahuq paramahuq, bbcl parambbcl)
  {
    ahuq.a(paramahuq).setVisibility(0);
    ahuq.a(paramahuq).setVisibility(0);
    TextView localTextView = ahuq.f(paramahuq);
    if (TextUtils.isEmpty(parambbcl.jdField_a_of_type_JavaLangString)) {}
    for (String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131715820);; str = parambbcl.jdField_a_of_type_JavaLangString)
    {
      localTextView.setText(str);
      if (ahuq.a(paramahuq) == null) {
        break label170;
      }
      if (!ahuq.a(paramahuq).a(parambbcl.jdField_a_of_type_JavaUtilList)) {
        break;
      }
      return;
    }
    ahuq.a(paramahuq).a(false);
    ahuq.a(paramahuq).a();
    for (;;)
    {
      ahuq.a(paramahuq).a(parambbcl.jdField_a_of_type_JavaUtilList);
      ahuq.a(paramahuq).setAdapter(ahuq.a(paramahuq));
      ahuq.a(paramahuq).setClickable(false);
      ahuq.a(paramahuq).setEnabled(false);
      ahuq.a(paramahuq).setOnTouchListener(mvd.a);
      ahuq.a(paramahuq).setOnClickListener(new ahun(this));
      ahuq.g(paramahuq).setVisibility(8);
      return;
      label170:
      ahuq.a(paramahuq, new ampz(this.jdField_a_of_type_AndroidContentContext, false));
    }
  }
  
  private void a(ahuq paramahuq, bbcm parambbcm)
  {
    ahuq.a(paramahuq).setVisibility(0);
    ahuq.a(paramahuq).setVisibility(0);
    ahuq.g(paramahuq).setVisibility(0);
    Object localObject;
    if (parambbcm.jdField_a_of_type_Int != 0)
    {
      localObject = ((bbvd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15)).a(parambbcm.jdField_a_of_type_Int, 200);
      localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
      int i = agej.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
    }
    for (;;)
    {
      ahuq.g(paramahuq).setCompoundDrawables((Drawable)localObject, null, null, null);
      ahuq.g(paramahuq).setText(parambbcm.jdField_a_of_type_JavaLangString + " " + parambbcm.jdField_b_of_type_JavaLangString);
      ahuq.a(paramahuq).setOnTouchListener(mvd.a);
      ahuq.a(paramahuq).setOnClickListener(new ahup(this));
      ahuq.c(paramahuq).setVisibility(8);
      return;
      localObject = null;
    }
  }
  
  private void a(ahuq paramahuq, QQAppInterface paramQQAppInterface)
  {
    if ((paramahuq == null) || (paramQQAppInterface == null)) {}
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
        ahuq.a(paramahuq).setTextColor(i2);
        ahuq.b(paramahuq).setTextColor(i2);
        ahuq.c(paramahuq).setTextColor(i2);
        ahuq.d(paramahuq).setTextColor(i3);
        ahuq.e(paramahuq).setTextColor(i3);
        ahuq.f(paramahuq).setTextColor(i3);
        ahuq.g(paramahuq).setTextColor(i2);
        ahuq.a(paramahuq).setBackgroundColor(i4);
        ahuq.a(paramahuq).setBackgroundColor(i5);
        ahuq.a(paramahuq).setBackgroundColor(i6);
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
        ahuq.a(paramahuq).setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850740));
        return;
        ahuq.a(paramahuq).setTextColor(j);
        ahuq.b(paramahuq).setTextColor(j);
        ahuq.c(paramahuq).setTextColor(j);
        ahuq.d(paramahuq).setTextColor(k);
        ahuq.e(paramahuq).setTextColor(k);
        ahuq.f(paramahuq).setTextColor(k);
        ahuq.g(paramahuq).setTextColor(j);
        ahuq.a(paramahuq).setBackgroundColor(m);
        ahuq.a(paramahuq).setBackgroundColor(n);
        ahuq.a(paramahuq).setBackgroundColor(i1);
      }
    }
    label340:
    ahuq.a(paramahuq).setBackgroundColor(i);
  }
  
  private void a(ahuq paramahuq, boolean paramBoolean)
  {
    paramahuq = ahuq.a(paramahuq).getLayoutParams();
    if (paramBoolean)
    {
      paramahuq.height = -2;
      return;
    }
    paramahuq.height = bhtq.a(60.0F);
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
    afez.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, PublicFragmentActivity.class, SignatureHistoryFragment.class);
  }
  
  private void b(ahuq paramahuq, List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      ahuq.a(paramahuq).setVisibility(8);
      a(paramahuq, false);
      return;
    }
    ahuq.a(paramahuq).setVisibility(0);
    if (ahuq.a(paramahuq) != null) {
      ahuq.a(paramahuq).a();
    }
    for (;;)
    {
      ahuq.a(paramahuq).a(paramList);
      ahuq.a(paramahuq).setAdapter(ahuq.a(paramahuq));
      a(paramahuq, true);
      return;
      ahuq.a(paramahuq, new ammo(this.jdField_a_of_type_AndroidContentContext));
    }
  }
  
  private void b(String paramString, ahuq paramahuq)
  {
    ahuq.a(paramahuq).a(0, ahuq.a(paramahuq), false);
    if ((paramString == null) || (paramString.length() == 0)) {
      ahuq.a(paramahuq).setImageResource(2130840274);
    }
    for (;;)
    {
      ahuq.a(paramahuq).setOnClickListener(this);
      a(paramString, paramahuq);
      return;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, paramString, (byte)3, 0, 100, true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject);
      if (localObject != null) {
        ahuq.a(paramahuq).setImageBitmap((Bitmap)localObject);
      } else {
        ahuq.a(paramahuq).setImageResource(2130840274);
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
      bmtd.a(this.jdField_a_of_type_AndroidContentContext, bmtk.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TofuAioMiniProfileItemBuilder", 1, localException, new Object[0]);
    }
  }
  
  protected agen a()
  {
    return new ahuq();
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    paramMessageRecord = (MessageForTofuAioMiniProfile)paramMessageRecord;
    paramagen = (ahuq)paramagen;
    paramView = a(paramView, paramagen);
    paramagen.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    if (QLog.isColorLevel()) {
      QLog.i("TofuAioMiniProfileItemBuilder", 2, "getItemView and miniCard:" + paramMessageRecord.miniCard);
    }
    if (paramMessageRecord.miniCard != null)
    {
      int i = bhtq.a(16.0F);
      ahuq.a(paramagen).enablePressEffect(true);
      ahuq.a(paramagen).setRadius(i, i, i, i);
      ahuq.a(paramagen).setOnClickListener(this);
      ahuq.a(paramagen).setOnTouchListener(mvd.a);
      paramView.setVisibility(0);
      b(paramagen.jdField_a_of_type_JavaLangString, paramagen);
      a(paramagen, paramMessageRecord.miniCard.jdField_a_of_type_Bbcj);
      b(paramagen, paramMessageRecord.miniCard.jdField_a_of_type_JavaUtilList);
      if ((paramMessageRecord.miniCard.jdField_a_of_type_Bbcl != null) && (paramMessageRecord.miniCard.jdField_a_of_type_Bbcl.jdField_a_of_type_JavaUtilList != null) && (paramMessageRecord.miniCard.jdField_a_of_type_Bbcl.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        a(paramagen, paramMessageRecord.miniCard.jdField_a_of_type_Bbcl);
        this.jdField_a_of_type_JavaLangString = "空间";
        a(paramagen, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (;;)
    {
      if (!paramagen.jdField_a_of_type_Boolean)
      {
        paramagen.jdField_a_of_type_Boolean = true;
        ThreadManagerV2.excute(new TofuAioMiniProfileItemBuilder.1(this, paramagen), 128, null, true);
        bdll.b(null, "dc00898", "", "", "0X800B1A8", "0X800B1A8", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
      }
      return paramView;
      if ((paramMessageRecord.miniCard.b != null) && (paramMessageRecord.miniCard.b.size() > 0))
      {
        a(paramagen, paramMessageRecord.miniCard.b);
        this.jdField_a_of_type_JavaLangString = "精选照片";
        break;
      }
      if (paramMessageRecord.miniCard.jdField_a_of_type_Bbcm != null)
      {
        a(paramagen, paramMessageRecord.miniCard.jdField_a_of_type_Bbcm);
        this.jdField_a_of_type_JavaLangString = "个性签名";
        break;
      }
      ahuq.a(paramagen).setVisibility(8);
      ahuq.a(paramagen).setVisibility(8);
      this.jdField_a_of_type_JavaLangString = "无信息";
      break;
      paramView.setVisibility(8);
    }
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.d();
    }
  }
  
  public void a(ahuq paramahuq, List<bbck> paramList)
  {
    ahuq.a(paramahuq).setVisibility(0);
    ahuq.a(paramahuq).setVisibility(0);
    ahuq.f(paramahuq).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694610));
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (bbck)localIterator.next();
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
    if (ahuq.a(paramahuq) != null)
    {
      if (ahuq.a(paramahuq).a(localArrayList2)) {
        return;
      }
      ahuq.a(paramahuq).a();
      ahuq.a(paramahuq).a(true);
    }
    for (;;)
    {
      ahuq.a(paramahuq).a(localArrayList2);
      ahuq.a(paramahuq).setAdapter(ahuq.a(paramahuq));
      ahuq.a(paramahuq).setClickable(true);
      ahuq.a(paramahuq).setEnabled(true);
      ahuq.a(paramahuq).setOnTouchListener(null);
      ahuq.a(paramahuq).setOnClickListener(null);
      ahuq.a(paramahuq).setOnItemClickListener(new ahuo(this, localArrayList1));
      ahuq.g(paramahuq).setVisibility(8);
      return;
      ahuq.a(paramahuq, new ampz(this.jdField_a_of_type_AndroidContentContext, true));
    }
  }
  
  protected void a(String paramString, ahuq paramahuq)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("TofuAioMiniProfileItemBuilder", 4, "updateFace, " + paramString);
    }
    aoot localaoot = aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (byte)3);
    ahuq.a(paramahuq).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localaoot, 1, paramString, 200, true, true, 8);
  }
  
  public bhum[] a(View paramView)
  {
    return new bhum[0];
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
      bdll.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "空白处");
      c();
      continue;
      bdll.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "头像");
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
 * Qualified Name:     ahum
 * JD-Core Version:    0.7.0.1
 */