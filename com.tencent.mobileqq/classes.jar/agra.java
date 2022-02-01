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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.TofuAioMiniProfileItemBuilder.1;
import com.tencent.mobileqq.activity.aio.item.TofuAioMiniProfileItemBuilder.5;
import com.tencent.mobileqq.activity.aio.item.view.AioMiniProfileLabelFlowLayout;
import com.tencent.mobileqq.app.QQAppInterface;
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
import com.tencent.mobileqq.widget.CircleBoarderImageView;
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

public class agra
  extends aexf
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private String jdField_a_of_type_JavaLangString;
  private Map<String, CircleBoarderImageView> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public agra(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this.jdField_a_of_type_AndroidContentContext, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    a(paramQQAppInterface);
  }
  
  private View a(View paramView, agre paramagre)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558866, null);
      agre.a(paramagre, (RoundCorneredRelativeLayout)localView.findViewById(2131376543));
      agre.a(paramagre, (RelativeLayout)localView.findViewById(2131376636));
      agre.a(paramagre, (TextView)localView.findViewById(2131379637));
      agre.b(paramagre, (TextView)localView.findViewById(2131379458));
      agre.c(paramagre, (TextView)localView.findViewById(2131379705));
      agre.a(paramagre, (LinearLayout)localView.findViewById(2131370130));
      agre.a(paramagre, localView.findViewById(2131365667));
      agre.b(paramagre, localView.findViewById(2131365668));
      agre.d(paramagre, (TextView)localView.findViewById(2131379840));
      agre.e(paramagre, (TextView)localView.findViewById(2131379540));
      agre.c(paramagre, localView.findViewById(2131365669));
      agre.b(paramagre, (LinearLayout)localView.findViewById(2131370131));
      agre.a(paramagre, (AvatarLayout)localView.findViewById(2131362551));
      agre.a(paramagre, (DynamicAvatarView)localView.findViewById(2131365323));
      agre.a(paramagre, (AioMiniProfileLabelFlowLayout)localView.findViewById(2131366774));
      agre.d(paramagre, localView.findViewById(2131365674));
      agre.a(paramagre, (FrameLayout)localView.findViewById(2131366749));
      agre.c(paramagre, (LinearLayout)localView.findViewById(2131370227));
      agre.f(paramagre, (TextView)localView.findViewById(2131379877));
      agre.a(paramagre, (GridView)localView.findViewById(2131367843));
      agre.g(paramagre, (TextView)localView.findViewById(2131379836));
    }
    return localView;
  }
  
  private void a(agre paramagre, azxe paramazxe)
  {
    int m = 1;
    if (paramazxe == null)
    {
      agre.a(paramagre).setVisibility(8);
      return;
    }
    agre.a(paramagre).setVisibility(0);
    int i;
    label74:
    label125:
    int k;
    if ((paramazxe.jdField_b_of_type_Int == 1) || (paramazxe.jdField_b_of_type_Int == 2))
    {
      agre.a(paramagre).setVisibility(0);
      TextView localTextView = agre.a(paramagre);
      if (paramazxe.jdField_b_of_type_Int == 1)
      {
        i = 2131693568;
        localTextView.setText(i);
        i = 1;
        if (paramazxe.jdField_a_of_type_Int < 0) {
          break label313;
        }
        agre.b(paramagre).setVisibility(0);
        agre.b(paramagre).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689965, new Object[] { Integer.valueOf(paramazxe.jdField_a_of_type_Int) }));
        j = 1;
        if (TextUtils.isEmpty(paramazxe.jdField_a_of_type_JavaLangString)) {
          break label328;
        }
        agre.c(paramagre).setVisibility(0);
        agre.c(paramagre).setText(paramazxe.jdField_a_of_type_JavaLangString);
        k = 1;
        label157:
        i = i + j + k;
        if (i != 3) {
          break label343;
        }
        agre.b(paramagre).setVisibility(0);
        agre.c(paramagre).setVisibility(0);
        label186:
        if (TextUtils.isEmpty(paramazxe.jdField_b_of_type_JavaLangString)) {
          break label456;
        }
        agre.d(paramagre).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689964, new Object[] { paramazxe.jdField_b_of_type_JavaLangString }));
        i = 1;
        label228:
        if (paramazxe.c <= 0) {
          break label470;
        }
        agre.e(paramagre).setText(String.format(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689652), new Object[] { Integer.valueOf(paramazxe.c) }));
      }
    }
    for (int j = m;; j = 0)
    {
      if ((j == 0) || (i == 0)) {
        break label485;
      }
      agre.d(paramagre).setVisibility(0);
      return;
      i = 2131692108;
      break;
      agre.a(paramagre).setVisibility(8);
      i = 0;
      break label74;
      label313:
      agre.b(paramagre).setVisibility(8);
      j = 0;
      break label125;
      label328:
      agre.c(paramagre).setVisibility(8);
      k = 0;
      break label157;
      label343:
      if (i == 2)
      {
        if ((j == 1) && (k == 1))
        {
          agre.b(paramagre).setVisibility(8);
          agre.c(paramagre).setVisibility(0);
          break label186;
        }
        agre.b(paramagre).setVisibility(0);
        agre.c(paramagre).setVisibility(8);
        break label186;
      }
      if (i == 1)
      {
        agre.b(paramagre).setVisibility(8);
        agre.c(paramagre).setVisibility(8);
        break label186;
      }
      agre.b(paramagre).setVisibility(8);
      agre.c(paramagre).setVisibility(8);
      agre.b(paramagre).setVisibility(8);
      break label186;
      label456:
      agre.d(paramagre).setVisibility(8);
      i = 0;
      break label228;
      label470:
      agre.e(paramagre).setVisibility(8);
    }
    label485:
    agre.d(paramagre).setVisibility(8);
  }
  
  private void a(agre paramagre, azxg paramazxg)
  {
    agre.a(paramagre).setVisibility(0);
    agre.a(paramagre).setVisibility(0);
    TextView localTextView = agre.f(paramagre);
    if (TextUtils.isEmpty(paramazxg.jdField_a_of_type_JavaLangString)) {}
    for (String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131716054);; str = paramazxg.jdField_a_of_type_JavaLangString)
    {
      localTextView.setText(str);
      if (agre.a(paramagre) == null) {
        break label170;
      }
      if (!agre.a(paramagre).a(paramazxg.jdField_a_of_type_JavaUtilList)) {
        break;
      }
      return;
    }
    agre.a(paramagre).a(false);
    agre.a(paramagre).a();
    for (;;)
    {
      agre.a(paramagre).a(paramazxg.jdField_a_of_type_JavaUtilList);
      agre.a(paramagre).setAdapter(agre.a(paramagre));
      agre.a(paramagre).setClickable(false);
      agre.a(paramagre).setEnabled(false);
      agre.a(paramagre).setOnTouchListener(mum.a);
      agre.a(paramagre).setOnClickListener(new agrb(this));
      agre.g(paramagre).setVisibility(8);
      return;
      label170:
      agre.a(paramagre, new alkt(this.jdField_a_of_type_AndroidContentContext, false));
    }
  }
  
  private void a(agre paramagre, azxh paramazxh)
  {
    agre.a(paramagre).setVisibility(0);
    agre.a(paramagre).setVisibility(0);
    agre.g(paramagre).setVisibility(0);
    Object localObject;
    if (paramazxh.jdField_a_of_type_Int != 0)
    {
      localObject = ((baoy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(15)).a(paramazxh.jdField_a_of_type_Int, 200);
      localObject = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject);
      int i = AIOUtils.dp2px(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
    }
    for (;;)
    {
      agre.g(paramagre).setCompoundDrawables((Drawable)localObject, null, null, null);
      agre.g(paramagre).setText(paramazxh.jdField_a_of_type_JavaLangString + " " + paramazxh.jdField_b_of_type_JavaLangString);
      agre.a(paramagre).setOnTouchListener(mum.a);
      agre.a(paramagre).setOnClickListener(new agrd(this));
      agre.c(paramagre).setVisibility(8);
      return;
      localObject = null;
    }
  }
  
  private void a(agre paramagre, QQAppInterface paramQQAppInterface)
  {
    if ((paramagre == null) || (paramQQAppInterface == null)) {}
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
        agre.a(paramagre).setTextColor(i2);
        agre.b(paramagre).setTextColor(i2);
        agre.c(paramagre).setTextColor(i2);
        agre.d(paramagre).setTextColor(i3);
        agre.e(paramagre).setTextColor(i3);
        agre.f(paramagre).setTextColor(i3);
        agre.g(paramagre).setTextColor(i2);
        agre.a(paramagre).setBackgroundColor(i4);
        agre.a(paramagre).setBackgroundColor(i5);
        agre.a(paramagre).setBackgroundColor(i6);
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
        agre.a(paramagre).setBackground(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130850668));
        return;
        agre.a(paramagre).setTextColor(j);
        agre.b(paramagre).setTextColor(j);
        agre.c(paramagre).setTextColor(j);
        agre.d(paramagre).setTextColor(k);
        agre.e(paramagre).setTextColor(k);
        agre.f(paramagre).setTextColor(k);
        agre.g(paramagre).setTextColor(j);
        agre.a(paramagre).setBackgroundColor(m);
        agre.a(paramagre).setBackgroundColor(n);
        agre.a(paramagre).setBackgroundColor(i1);
      }
    }
    label340:
    agre.a(paramagre).setBackgroundColor(i);
  }
  
  private void a(agre paramagre, boolean paramBoolean)
  {
    paramagre = agre.a(paramagre).getLayoutParams();
    if (paramBoolean)
    {
      paramagre.height = -2;
      return;
    }
    paramagre.height = ViewUtils.dip2px(60.0F);
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
    adxr.a(this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, PublicFragmentActivity.class, SignatureHistoryFragment.class);
  }
  
  private void b(agre paramagre, List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      agre.a(paramagre).setVisibility(8);
      a(paramagre, false);
      return;
    }
    agre.a(paramagre).setVisibility(0);
    if (agre.a(paramagre) != null) {
      agre.a(paramagre).a();
    }
    for (;;)
    {
      agre.a(paramagre).a(paramList);
      agre.a(paramagre).setAdapter(agre.a(paramagre));
      a(paramagre, true);
      return;
      agre.a(paramagre, new alhi(this.jdField_a_of_type_AndroidContentContext));
    }
  }
  
  private void b(String paramString, agre paramagre)
  {
    agre.a(paramagre).a(0, agre.a(paramagre), false);
    if ((paramString == null) || (paramString.length() == 0)) {
      agre.a(paramagre).setImageResource(2130840312);
    }
    for (;;)
    {
      agre.a(paramagre).setOnClickListener(this);
      a(paramString, paramagre);
      return;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmapCacheKey(1, paramString, (byte)3, 0, 100, true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBitmapFromCache((String)localObject);
      if (localObject != null) {
        agre.a(paramagre).setImageBitmap((Bitmap)localObject);
      } else {
        agre.a(paramagre).setImageResource(2130840312);
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
  
  protected aexg a()
  {
    return new agre();
  }
  
  protected View a(MessageRecord paramMessageRecord, aexg paramaexg, View paramView, LinearLayout paramLinearLayout, afce paramafce)
  {
    paramMessageRecord = (MessageForTofuAioMiniProfile)paramMessageRecord;
    paramaexg = (agre)paramaexg;
    paramView = a(paramView, paramaexg);
    paramaexg.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    if (QLog.isColorLevel()) {
      QLog.i("TofuAioMiniProfileItemBuilder", 2, "getItemView and miniCard:" + paramMessageRecord.miniCard);
    }
    if (paramMessageRecord.miniCard != null)
    {
      int i = ViewUtils.dip2px(16.0F);
      agre.a(paramaexg).enablePressEffect(true);
      agre.a(paramaexg).setRadius(i, i, i, i);
      agre.a(paramaexg).setOnClickListener(this);
      agre.a(paramaexg).setOnTouchListener(mum.a);
      paramView.setVisibility(0);
      b(paramaexg.jdField_a_of_type_JavaLangString, paramaexg);
      a(paramaexg, paramMessageRecord.miniCard.jdField_a_of_type_Azxe);
      b(paramaexg, paramMessageRecord.miniCard.jdField_a_of_type_JavaUtilList);
      if ((paramMessageRecord.miniCard.jdField_a_of_type_Azxg != null) && (paramMessageRecord.miniCard.jdField_a_of_type_Azxg.jdField_a_of_type_JavaUtilList != null) && (paramMessageRecord.miniCard.jdField_a_of_type_Azxg.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        a(paramaexg, paramMessageRecord.miniCard.jdField_a_of_type_Azxg);
        this.jdField_a_of_type_JavaLangString = "空间";
        a(paramaexg, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    for (;;)
    {
      if (!paramaexg.jdField_a_of_type_Boolean)
      {
        paramaexg.jdField_a_of_type_Boolean = true;
        ThreadManagerV2.excute(new TofuAioMiniProfileItemBuilder.1(this, paramaexg), 128, null, true);
        bcef.b(null, "dc00898", "", "", "0X800B1A8", "0X800B1A8", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
      }
      return paramView;
      if ((paramMessageRecord.miniCard.b != null) && (paramMessageRecord.miniCard.b.size() > 0))
      {
        a(paramaexg, paramMessageRecord.miniCard.b);
        this.jdField_a_of_type_JavaLangString = "精选照片";
        break;
      }
      if (paramMessageRecord.miniCard.jdField_a_of_type_Azxh != null)
      {
        a(paramaexg, paramMessageRecord.miniCard.jdField_a_of_type_Azxh);
        this.jdField_a_of_type_JavaLangString = "个性签名";
        break;
      }
      agre.a(paramaexg).setVisibility(8);
      agre.a(paramaexg).setVisibility(8);
      this.jdField_a_of_type_JavaLangString = "无信息";
      break;
      paramView.setVisibility(8);
    }
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
  }
  
  public void a(agre paramagre, List<azxf> paramList)
  {
    agre.a(paramagre).setVisibility(0);
    agre.a(paramagre).setVisibility(0);
    agre.f(paramagre).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694726));
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (azxf)localIterator.next();
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
    if (agre.a(paramagre) != null)
    {
      if (agre.a(paramagre).a(localArrayList2)) {
        return;
      }
      agre.a(paramagre).a();
      agre.a(paramagre).a(true);
    }
    for (;;)
    {
      agre.a(paramagre).a(localArrayList2);
      agre.a(paramagre).setAdapter(agre.a(paramagre));
      agre.a(paramagre).setClickable(true);
      agre.a(paramagre).setEnabled(true);
      agre.a(paramagre).setOnTouchListener(null);
      agre.a(paramagre).setOnClickListener(null);
      agre.a(paramagre).setOnItemClickListener(new agrc(this, localArrayList1));
      agre.g(paramagre).setVisibility(8);
      return;
      agre.a(paramagre, new alkt(this.jdField_a_of_type_AndroidContentContext, true));
    }
  }
  
  protected void a(String paramString, agre paramagre)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("TofuAioMiniProfileItemBuilder", 4, "updateFace, " + paramString);
    }
    FaceDrawable localFaceDrawable = FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (byte)3);
    agre.a(paramagre).setFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFaceDrawable, 1, paramString, 200, true, true, 8);
  }
  
  public bgbb[] a(View paramView)
  {
    return new bgbb[0];
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
      bcef.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "空白处");
      c();
      continue;
      bcef.b(null, "dc00898", "", "", "0X800B1A9", "0X800B1A9", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "头像");
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
 * Qualified Name:     agra
 * JD-Core Version:    0.7.0.1
 */