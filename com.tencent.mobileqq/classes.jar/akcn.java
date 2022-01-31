import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.gamecenter.view.ShadowView;
import com.tencent.mobileqq.subaccount.UpArrowView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class akcn
  extends BaseAdapter
{
  public LayoutInflater a;
  public View.OnClickListener a;
  public QQAppInterface a;
  public ArrayList<azyj> a;
  boolean a;
  private boolean b;
  
  public akcn(QQAppInterface paramQQAppInterface, ArrayList<azyj> paramArrayList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_b_of_type_Boolean = azib.b();
  }
  
  private int a(azyj paramazyj)
  {
    if ((paramazyj.jdField_a_of_type_Int != 3) && (paramazyj.jdField_a_of_type_Int != 7)) {}
    label172:
    label174:
    label178:
    for (;;)
    {
      return 0;
      if ((paramazyj.jdField_a_of_type_JavaLangObject instanceof SubAccountMessage)) {
        paramazyj = ((SubAccountMessage)paramazyj.jdField_a_of_type_JavaLangObject).subUin;
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramazyj)) {
          break label178;
        }
        Object localObject = (azyj)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if ((((azyj)localObject).jdField_a_of_type_Int != 2) || (((azyj)localObject).jdField_a_of_type_JavaLangObject == null) || (!(((azyj)localObject).jdField_a_of_type_JavaLangObject instanceof ArrayList))) {
          break;
        }
        localObject = (ArrayList)((azyj)localObject).jdField_a_of_type_JavaLangObject;
        int i = 0;
        for (;;)
        {
          if (i >= ((ArrayList)localObject).size()) {
            break label172;
          }
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)((azyj)((ArrayList)localObject).get(i)).jdField_a_of_type_JavaLangObject;
          if ((!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localSubAccountInfo.subuin.equals(paramazyj)))
          {
            return i;
            if (!(paramazyj.jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)) {
              break label174;
            }
            paramazyj = ((SubAccountInfo)paramazyj.jdField_a_of_type_JavaLangObject).subuin;
            break;
          }
          i += 1;
        }
        break;
        paramazyj = "";
      }
    }
  }
  
  private View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    Object localObject;
    ArrayList localArrayList;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562674, paramViewGroup, false);
      paramViewGroup = new akco(this);
      paramViewGroup.jdField_a_of_type_Akcp = new akcp(this);
      paramViewGroup.jdField_a_of_type_Akcp.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131377884));
      paramViewGroup.jdField_a_of_type_Akcp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a().setFakeBoldText(true);
      paramViewGroup.jdField_a_of_type_Akcp.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131367808));
      paramViewGroup.jdField_a_of_type_Akcp.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367821));
      paramViewGroup.jdField_a_of_type_Akcp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131379271));
      paramViewGroup.jdField_a_of_type_Akcp.d = paramView.findViewById(2131367284);
      paramViewGroup.jdField_b_of_type_Akcp = new akcp(this);
      paramViewGroup.jdField_b_of_type_Akcp.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131377899));
      paramViewGroup.jdField_b_of_type_Akcp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a().setFakeBoldText(true);
      paramViewGroup.jdField_b_of_type_Akcp.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131367813));
      paramViewGroup.jdField_b_of_type_Akcp.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367822));
      paramViewGroup.jdField_b_of_type_Akcp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131379272));
      paramViewGroup.jdField_b_of_type_Akcp.d = paramView.findViewById(2131367285);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131367833);
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131367834);
      paramViewGroup.c = paramView.findViewById(2131362114);
      ((SingleLineTextView)paramView.findViewById(2131362079)).a().setFakeBoldText(true);
      if ((paramViewGroup.c instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramViewGroup.c).a(true);
      }
      paramViewGroup.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setTag(paramViewGroup);
      localObject = (azyj)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_Azyj = ((azyj)localObject);
      a(paramView, (azyj)localObject);
      localArrayList = (ArrayList)((azyj)localObject).jdField_a_of_type_JavaLangObject;
      if (localArrayList.size() != 1) {
        break label469;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.c.setVisibility(0);
      paramInt = i;
    }
    for (;;)
    {
      if ((paramInt >= localArrayList.size()) || (paramInt >= 2)) {
        return paramView;
      }
      azyj localazyj = (azyj)localArrayList.get(paramInt);
      akcp localakcp = paramViewGroup.jdField_a_of_type_Akcp;
      localObject = paramViewGroup.jdField_a_of_type_AndroidViewView;
      if (paramInt == 1)
      {
        localakcp = paramViewGroup.jdField_b_of_type_Akcp;
        localObject = paramViewGroup.jdField_b_of_type_AndroidViewView;
      }
      a(localakcp, localazyj, (View)localObject);
      paramInt += 1;
      continue;
      paramViewGroup = (akco)paramView.getTag();
      break;
      label469:
      paramInt = i;
      if (localArrayList.size() > 1)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.c.setVisibility(8);
        paramInt = i;
      }
    }
    return paramView;
  }
  
  private View a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    int i;
    if (paramView == null)
    {
      i = 2131562670;
      if (paramInt2 == 7)
      {
        i = 2131562671;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(i, paramViewGroup, false);
        paramViewGroup = new akcp(this);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      azyj localazyj = (azyj)getItem(paramInt1);
      paramViewGroup.jdField_a_of_type_Azyj = localazyj;
      if (localazyj != null)
      {
        a(paramView, localazyj);
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if ((AppSetting.c) && (!TextUtils.isEmpty(localazyj.jdField_d_of_type_JavaLangString))) {
          paramView.setContentDescription(localazyj.jdField_d_of_type_JavaLangString);
        }
      }
      return paramView;
      if (paramInt2 != 4) {
        break;
      }
      i = 2131562673;
      break;
      paramViewGroup = (akcp)paramView.getTag();
    }
  }
  
  private void a(akcp paramakcp, azyj paramazyj, View paramView)
  {
    paramakcp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(paramazyj.jdField_a_of_type_JavaLangString);
    Object localObject1 = (SubAccountInfo)paramazyj.jdField_a_of_type_JavaLangObject;
    Object localObject2;
    label115:
    int i;
    if (localObject1 != null)
    {
      localObject2 = bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((SubAccountInfo)localObject1).subuin);
      if (paramazyj.e == 0)
      {
        paramakcp.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        paramakcp.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable((Drawable)localObject2);
        paramakcp.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(((SubAccountInfo)localObject1).subuin);
        localObject1 = azyl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((SubAccountInfo)localObject1).subuin);
        if (((azyq)localObject1).jdField_a_of_type_Int <= 0) {
          break label251;
        }
        bhro.a(paramakcp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 1, ((azyq)localObject1).jdField_a_of_type_Int, 0, 99, null);
      }
    }
    else
    {
      paramakcp.jdField_a_of_type_Azyj = paramazyj;
      if (!paramazyj.jdField_b_of_type_Boolean) {
        break label271;
      }
      paramakcp.d.setScaleX(1.0F);
      paramakcp.d.setScaleY(1.0F);
      boolean bool = azib.a();
      localObject1 = paramakcp.d;
      localObject2 = paramakcp.d.getResources();
      if (!bool) {
        break label263;
      }
      i = 2130845659;
      label173:
      ((View)localObject1).setBackgroundDrawable(((Resources)localObject2).getDrawable(i));
    }
    for (;;)
    {
      paramView.setTag(paramakcp);
      if ((paramView instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramView).a(true);
      }
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((AppSetting.c) && (!TextUtils.isEmpty(paramazyj.jdField_d_of_type_JavaLangString))) {
        paramView.setContentDescription(paramazyj.jdField_d_of_type_JavaLangString);
      }
      return;
      paramakcp.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130849706);
      break;
      label251:
      paramakcp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
      break label115;
      label263:
      i = 2130845658;
      break label173;
      label271:
      paramakcp.d.setScaleX(0.93F);
      paramakcp.d.setScaleY(0.93F);
      paramakcp.d.setBackgroundDrawable(null);
    }
  }
  
  private void a(View paramView, azyj paramazyj)
  {
    if ((paramView == null) || (paramazyj == null)) {
      return;
    }
    Object localObject1;
    Object localObject3;
    Object localObject2;
    switch (paramazyj.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 1: 
    case 2: 
      localObject1 = paramView.findViewById(2131365353);
      float f = bdcb.a();
      View localView;
      if (this.jdField_a_of_type_Boolean)
      {
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localView = paramView.findViewById(2131368574);
        localObject3 = paramView.getLayoutParams();
        if (!paramazyj.jdField_b_of_type_Boolean) {
          break label328;
        }
        localObject2 = paramView.findViewById(2131368555);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = paramView;
        }
        ((View)localObject1).setBackgroundResource(2130839253);
        if (localView != null) {
          localView.setVisibility(0);
        }
        ((ViewGroup.LayoutParams)localObject3).height = ((int)paramView.getResources().getDimension(2131296500));
        localObject1 = (UpArrowView)paramView.findViewById(2131362823);
        localObject2 = (ShadowView)paramView.findViewById(2131362841);
        if (localObject2 != null)
        {
          ((ShadowView)localObject2).setOriginColor(0);
          ((ShadowView)localObject2).setShadowProperties(aekt.a(6.0F, ((ShadowView)localObject2).getResources()), 0.0F, aekt.a(2.0F, ((ShadowView)localObject2).getResources()), Color.parseColor("#B3E0E1E7"));
        }
        if (localObject1 != null)
        {
          if (this.jdField_a_of_type_Boolean) {
            ((UpArrowView)localObject1).setTheme(true);
          }
          b((View)localObject1, paramazyj);
        }
      }
      for (;;)
      {
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        return;
        if (localObject1 == null) {
          break;
        }
        ((View)localObject1).setVisibility(8);
        if (!(((View)localObject1).getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
          break;
        }
        localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
        if (paramazyj.jdField_b_of_type_Int == 1) {}
        for (((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(f * 16.0F + 0.5D));; ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0)
        {
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break;
        }
        label328:
        paramView.setBackgroundResource(2130839253);
        if (localView != null) {
          localView.setVisibility(8);
        }
        ((ViewGroup.LayoutParams)localObject3).height = ((int)paramView.getResources().getDimension(2131296498));
      }
    }
    if (paramazyj.jdField_b_of_type_Boolean)
    {
      localObject1 = paramView.findViewById(2131368555);
      if (localObject1 != null) {
        break label601;
      }
      localObject1 = paramView;
    }
    label599:
    label601:
    for (;;)
    {
      localObject2 = (UpArrowView)paramView.findViewById(2131362823);
      localObject3 = (ShadowView)paramView.findViewById(2131362841);
      if (localObject3 != null)
      {
        ((ShadowView)localObject3).setOriginColor(0);
        ((ShadowView)localObject3).setShadowProperties(aekt.a(6.0F, ((ShadowView)localObject3).getResources()), 0.0F, aekt.a(2.0F, ((ShadowView)localObject3).getResources()), Color.parseColor("#B3E0E1E7"));
      }
      b((View)localObject2, paramazyj);
      ((View)localObject1).setBackgroundResource(2130839253);
      for (;;)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label599;
        }
        localObject1 = paramView.findViewById(2131365353);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        if (!paramazyj.jdField_b_of_type_Boolean) {
          break;
        }
        localObject1 = (UpArrowView)paramView.findViewById(2131362823);
        paramView = (ShadowView)paramView.findViewById(2131362841);
        if (paramView != null)
        {
          paramView.setOriginColor(0);
          paramView.setShadowProperties(aekt.a(6.0F, paramView.getResources()), 0.0F, aekt.a(2.0F, paramView.getResources()), Color.parseColor("#B3E0E1E7"));
        }
        if (localObject1 != null) {
          ((UpArrowView)localObject1).setTheme(true);
        }
        b((View)localObject1, paramazyj);
        return;
        paramView.setBackgroundResource(2130839253);
      }
      break;
    }
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    azyj localazyj;
    int j;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562675, paramViewGroup, false);
      paramViewGroup = new akcp(this);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131367808));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131377884));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131379273));
      if ((paramView instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramView).a(true);
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a().setFakeBoldText(true);
      paramView.setTag(paramViewGroup);
      localazyj = (azyj)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_Azyj = localazyj;
      SimpleAccount localSimpleAccount = (SimpleAccount)localazyj.jdField_a_of_type_JavaLangObject;
      bcxb localbcxb = bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localSimpleAccount.getUin());
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localazyj.jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSimpleAccount.getUin());
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(localbcxb);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
      j = localazyj.jdField_d_of_type_Int;
      if (j <= 0) {
        break label264;
      }
      i = 2130844345;
    }
    label264:
    for (paramInt = 3;; paramInt = 0)
    {
      bhro.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, paramInt, j, i, 99, null);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((AppSetting.c) && (!TextUtils.isEmpty(localazyj.jdField_d_of_type_JavaLangString))) {
        paramView.setContentDescription(localazyj.jdField_d_of_type_JavaLangString);
      }
      return paramView;
      paramViewGroup = (akcp)paramView.getTag();
      break;
    }
  }
  
  private void b(View paramView, azyj paramazyj)
  {
    if ((paramView == null) || (paramazyj == null)) {
      return;
    }
    int i = a(paramazyj);
    paramazyj = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    int j = aekt.a(43.0F, paramView.getResources());
    paramazyj.leftMargin = (i * aekt.a(73.0F, paramView.getResources()) + j - aekt.a(6.0F, paramView.getResources()));
    paramView.setLayoutParams(paramazyj);
  }
  
  private View c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    akcp localakcp;
    azyj localazyj;
    Resources localResources;
    SubAccountMessage localSubAccountMessage;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562669, paramViewGroup, false);
      localakcp = new akcp(this);
      localakcp.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131377884));
      localakcp.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramViewGroup.findViewById(2131367808));
      localakcp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramViewGroup.findViewById(2131379273));
      localakcp.b = ((SingleLineTextView)paramViewGroup.findViewById(2131365127));
      paramViewGroup.setTag(localakcp);
      localazyj = (azyj)getItem(paramInt);
      localakcp.jdField_a_of_type_Azyj = localazyj;
      localResources = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources();
      if (localazyj != null)
      {
        localSubAccountMessage = (SubAccountMessage)localazyj.jdField_a_of_type_JavaLangObject;
        paramView = localSubAccountMessage.sendername;
        if (localSubAccountMessage.istroop == 1) {
          paramView = localResources.getString(2131720438);
        }
        if (!TextUtils.isEmpty(paramView)) {
          break label1171;
        }
      }
    }
    label258:
    label267:
    label526:
    label1171:
    for (Object localObject = localSubAccountMessage.senderuin;; localObject = paramView)
    {
      localakcp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
      if (((localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) && (localSubAccountMessage.msg != null)) {
        localSubAccountMessage.mEmoRecentMsg = new baig(localSubAccountMessage.msg, 3, 16);
      }
      if (localSubAccountMessage.istroop == 1) {
        if (localSubAccountMessage.unreadNum > 0)
        {
          paramView = localResources.getString(2131720439);
          localakcp.b.setText(paramView);
          if ((localSubAccountMessage.mTimeString == null) || (localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) {
            localSubAccountMessage.mTimeString = bdjj.a(localSubAccountMessage.time * 1000L, true, azyl.jdField_a_of_type_JavaLangString);
          }
          if (localSubAccountMessage.istroop != 1) {
            localakcp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(localSubAccountMessage.mTimeString, 0);
          }
          if (!aljq.aD.equals(localSubAccountMessage.senderuin)) {
            break label907;
          }
        }
      }
      try
      {
        paramView = BitmapFactory.decodeResource(localResources, 2130842097);
        if (!this.jdField_b_of_type_Boolean) {
          break label874;
        }
        paramView = QQAppInterface.a(paramView, 3, 50, 50);
        label380:
        localakcp.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(paramView);
      }
      catch (OutOfMemoryError paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT_AssocQQ_Adapter", 2, QLog.getStackTraceString(paramView));
          }
        }
      }
      localakcp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      int n = localSubAccountMessage.unreadNum;
      int i = 0;
      int j = 0;
      if ((n > 0) && (localSubAccountMessage.istroop == 1))
      {
        j = 2130849728;
        i = 1;
        paramView = "";
        paramInt = 0;
      }
      for (;;)
      {
        label441:
        localakcp.b.setExtendText(paramView, 1);
        localakcp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramViewGroup);
        bhro.a(localakcp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, n, j, 99, null);
        StringBuilder localStringBuilder;
        float f;
        if ((AppSetting.c) && (TextUtils.isEmpty(localazyj.jdField_d_of_type_JavaLangString)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject).append(",");
          if (localazyj.jdField_d_of_type_Int == 0)
          {
            if (paramView != null) {
              localStringBuilder.append(paramView + ",");
            }
            localStringBuilder.append(localSubAccountMessage.mEmoRecentMsg).append(",").append(localSubAccountMessage.mTimeString);
            localazyj.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
          }
        }
        else
        {
          f = bdcb.a();
          paramView = localResources.getColorStateList(2131166975);
          localObject = localResources.getColorStateList(2131166901);
          i = localResources.getColor(2131167006);
          localakcp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject);
          localakcp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
          localakcp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
          localakcp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
          localakcp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
          localakcp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
          localakcp.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
          if (paramInt == 0) {
            break label1151;
          }
          localakcp.b.setTextColor(i);
        }
        for (;;)
        {
          localakcp.b.setExtendTextColor(ColorStateList.valueOf(i), 1);
          localakcp.b.setExtendTextPadding((int)(f * 2.0F), 1);
          localakcp.b.setExtendTextSize(14.0F, 1);
          a(paramViewGroup, localazyj);
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          if ((AppSetting.c) && (!TextUtils.isEmpty(localazyj.jdField_d_of_type_JavaLangString))) {
            paramViewGroup.setContentDescription(localazyj.jdField_d_of_type_JavaLangString);
          }
          if (this.jdField_a_of_type_Boolean)
          {
            paramView = paramViewGroup.findViewById(2131365365);
            if (paramView != null) {
              paramView.setVisibility(8);
            }
          }
          return paramViewGroup;
          localakcp = (akcp)paramView.getTag();
          paramViewGroup = paramView;
          break;
          paramView = localResources.getString(2131720440);
          break label258;
          localakcp.b.setText(localSubAccountMessage.mEmoRecentMsg);
          break label267;
          label874:
          paramView = QQAppInterface.a(paramView, 50, 50);
          break label380;
          paramView = bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localSubAccountMessage.senderuin);
          localakcp.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSubAccountMessage.senderuin);
          localakcp.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(paramView);
          localakcp.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setVisibility(0);
          break label389;
          if (n <= 0) {
            break label1163;
          }
          paramInt = 2130849732;
          int k = 3;
          if ((2 == localazyj.c) || (3 == localazyj.c))
          {
            paramView = "[" + localResources.getString(2131717857) + "]";
            m = 0;
            i = k;
            j = paramInt;
            paramInt = m;
            break label441;
          }
          i = k;
          j = paramInt;
          if (!"RED_PACKET".equals(localSubAccountMessage.subExtr)) {
            break label1163;
          }
          paramView = "";
          int m = 1;
          i = k;
          j = paramInt;
          paramInt = m;
          break label441;
          if (localazyj.jdField_d_of_type_Int == 1)
          {
            localStringBuilder.append("有一条未读");
            break label526;
          }
          if (localazyj.jdField_d_of_type_Int == 2)
          {
            localStringBuilder.append("有两条未读");
            break label526;
          }
          if (localazyj.jdField_d_of_type_Int <= 0) {
            break label526;
          }
          localStringBuilder.append("有").append(localazyj.jdField_d_of_type_Int).append("条未读,");
          break label526;
          label1151:
          localakcp.b.setTextColor(paramView);
        }
        paramView = "";
        paramInt = 0;
      }
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return paramInt;
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return ((azyj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.d("SUB_ACCOUNT_AssocQQ_Adapter", 2, "getView() position=" + paramInt + " viewType=" + i);
    }
    switch (i)
    {
    case 5: 
    default: 
      View localView = paramView;
      if (paramView == null) {
        localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562672, paramViewGroup, false);
      }
      return localView;
    case 3: 
      return c(paramInt, paramView, paramViewGroup);
    case 6: 
      return b(paramInt, paramView, paramViewGroup);
    case 2: 
      return a(paramInt, paramView, paramViewGroup);
    }
    return a(paramInt, paramView, paramViewGroup, i);
  }
  
  public int getViewTypeCount()
  {
    return 8;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akcn
 * JD-Core Version:    0.7.0.1
 */