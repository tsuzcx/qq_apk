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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class ambb
  extends BaseAdapter
{
  public LayoutInflater a;
  public View.OnClickListener a;
  public QQAppInterface a;
  public ArrayList<bddw> a;
  boolean a;
  private boolean b;
  
  public ambb(QQAppInterface paramQQAppInterface, ArrayList<bddw> paramArrayList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_b_of_type_Boolean = bcnj.b();
  }
  
  private int a(bddw parambddw)
  {
    if ((parambddw.jdField_a_of_type_Int != 3) && (parambddw.jdField_a_of_type_Int != 7)) {}
    label172:
    label174:
    label178:
    for (;;)
    {
      return 0;
      if ((parambddw.jdField_a_of_type_JavaLangObject instanceof SubAccountMessage)) {
        parambddw = ((SubAccountMessage)parambddw.jdField_a_of_type_JavaLangObject).subUin;
      }
      for (;;)
      {
        if (TextUtils.isEmpty(parambddw)) {
          break label178;
        }
        Object localObject = (bddw)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        if ((((bddw)localObject).jdField_a_of_type_Int != 2) || (((bddw)localObject).jdField_a_of_type_JavaLangObject == null) || (!(((bddw)localObject).jdField_a_of_type_JavaLangObject instanceof ArrayList))) {
          break;
        }
        localObject = (ArrayList)((bddw)localObject).jdField_a_of_type_JavaLangObject;
        int i = 0;
        for (;;)
        {
          if (i >= ((ArrayList)localObject).size()) {
            break label172;
          }
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)((bddw)((ArrayList)localObject).get(i)).jdField_a_of_type_JavaLangObject;
          if ((!TextUtils.isEmpty(localSubAccountInfo.subuin)) && (localSubAccountInfo.subuin.equals(parambddw)))
          {
            return i;
            if (!(parambddw.jdField_a_of_type_JavaLangObject instanceof SubAccountInfo)) {
              break label174;
            }
            parambddw = ((SubAccountInfo)parambddw.jdField_a_of_type_JavaLangObject).subuin;
            break;
          }
          i += 1;
        }
        break;
        parambddw = "";
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
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562931, paramViewGroup, false);
      paramViewGroup = new ambc(this);
      paramViewGroup.jdField_a_of_type_Ambd = new ambd(this);
      paramViewGroup.jdField_a_of_type_Ambd.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131378776));
      paramViewGroup.jdField_a_of_type_Ambd.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a().setFakeBoldText(true);
      paramViewGroup.jdField_a_of_type_Ambd.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131368138));
      paramViewGroup.jdField_a_of_type_Ambd.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368153));
      paramViewGroup.jdField_a_of_type_Ambd.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380254));
      paramViewGroup.jdField_a_of_type_Ambd.d = paramView.findViewById(2131367602);
      paramViewGroup.jdField_b_of_type_Ambd = new ambd(this);
      paramViewGroup.jdField_b_of_type_Ambd.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131378791));
      paramViewGroup.jdField_b_of_type_Ambd.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a().setFakeBoldText(true);
      paramViewGroup.jdField_b_of_type_Ambd.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131368144));
      paramViewGroup.jdField_b_of_type_Ambd.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368154));
      paramViewGroup.jdField_b_of_type_Ambd.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380255));
      paramViewGroup.jdField_b_of_type_Ambd.d = paramView.findViewById(2131367603);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368165);
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131368166);
      paramViewGroup.c = paramView.findViewById(2131362175);
      ((SingleLineTextView)paramView.findViewById(2131362139)).a().setFakeBoldText(true);
      if ((paramViewGroup.c instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramViewGroup.c).a(true);
      }
      paramViewGroup.c.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setTag(paramViewGroup);
      localObject = (bddw)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_Bddw = ((bddw)localObject);
      a(paramView, (bddw)localObject);
      localArrayList = (ArrayList)((bddw)localObject).jdField_a_of_type_JavaLangObject;
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
      bddw localbddw = (bddw)localArrayList.get(paramInt);
      ambd localambd = paramViewGroup.jdField_a_of_type_Ambd;
      localObject = paramViewGroup.jdField_a_of_type_AndroidViewView;
      if (paramInt == 1)
      {
        localambd = paramViewGroup.jdField_b_of_type_Ambd;
        localObject = paramViewGroup.jdField_b_of_type_AndroidViewView;
      }
      a(localambd, localbddw, (View)localObject);
      paramInt += 1;
      continue;
      paramViewGroup = (ambc)paramView.getTag();
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
      i = 2131562927;
      if (paramInt2 == 7)
      {
        i = 2131562928;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(i, paramViewGroup, false);
        paramViewGroup = new ambd(this);
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      bddw localbddw = (bddw)getItem(paramInt1);
      paramViewGroup.jdField_a_of_type_Bddw = localbddw;
      if (localbddw != null)
      {
        a(paramView, localbddw);
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if ((AppSetting.c) && (!TextUtils.isEmpty(localbddw.jdField_d_of_type_JavaLangString))) {
          paramView.setContentDescription(localbddw.jdField_d_of_type_JavaLangString);
        }
      }
      return paramView;
      if (paramInt2 != 4) {
        break;
      }
      i = 2131562930;
      break;
      paramViewGroup = (ambd)paramView.getTag();
    }
  }
  
  private void a(ambd paramambd, bddw parambddw, View paramView)
  {
    paramambd.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(parambddw.jdField_a_of_type_JavaLangString);
    Object localObject1 = (SubAccountInfo)parambddw.jdField_a_of_type_JavaLangObject;
    Object localObject2;
    label115:
    int i;
    if (localObject1 != null)
    {
      localObject2 = aoch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((SubAccountInfo)localObject1).subuin);
      if (parambddw.e == 0)
      {
        paramambd.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(null);
        paramambd.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable((Drawable)localObject2);
        paramambd.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(((SubAccountInfo)localObject1).subuin);
        localObject1 = bddy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((SubAccountInfo)localObject1).subuin);
        if (((bded)localObject1).jdField_a_of_type_Int <= 0) {
          break label251;
        }
        bkjh.a(paramambd.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 1, ((bded)localObject1).jdField_a_of_type_Int, 0, 99, null);
      }
    }
    else
    {
      paramambd.jdField_a_of_type_Bddw = parambddw;
      if (!parambddw.jdField_b_of_type_Boolean) {
        break label271;
      }
      paramambd.d.setScaleX(1.0F);
      paramambd.d.setScaleY(1.0F);
      boolean bool = bcnj.a();
      localObject1 = paramambd.d;
      localObject2 = paramambd.d.getResources();
      if (!bool) {
        break label263;
      }
      i = 2130846147;
      label173:
      ((View)localObject1).setBackgroundDrawable(((Resources)localObject2).getDrawable(i));
    }
    for (;;)
    {
      paramView.setTag(paramambd);
      if ((paramView instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramView).a(true);
      }
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((AppSetting.c) && (!TextUtils.isEmpty(parambddw.jdField_d_of_type_JavaLangString))) {
        paramView.setContentDescription(parambddw.jdField_d_of_type_JavaLangString);
      }
      return;
      paramambd.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130850365);
      break;
      label251:
      paramambd.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
      break label115;
      label263:
      i = 2130846146;
      break label173;
      label271:
      paramambd.d.setScaleX(0.93F);
      paramambd.d.setScaleY(0.93F);
      paramambd.d.setBackgroundDrawable(null);
    }
  }
  
  private void a(View paramView, bddw parambddw)
  {
    if ((paramView == null) || (parambddw == null)) {
      return;
    }
    Object localObject1;
    Object localObject3;
    Object localObject2;
    switch (parambddw.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 1: 
    case 2: 
      localObject1 = paramView.findViewById(2131365590);
      float f = bgln.a();
      View localView;
      if (this.jdField_a_of_type_Boolean)
      {
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localView = paramView.findViewById(2131368908);
        localObject3 = paramView.getLayoutParams();
        if (!parambddw.jdField_b_of_type_Boolean) {
          break label328;
        }
        localObject2 = paramView.findViewById(2131368889);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = paramView;
        }
        ((View)localObject1).setBackgroundResource(2130839432);
        if (localView != null) {
          localView.setVisibility(0);
        }
        ((ViewGroup.LayoutParams)localObject3).height = ((int)paramView.getResources().getDimension(2131296534));
        localObject1 = (UpArrowView)paramView.findViewById(2131362936);
        localObject2 = (ShadowView)paramView.findViewById(2131362954);
        if (localObject2 != null)
        {
          ((ShadowView)localObject2).setOriginColor(0);
          ((ShadowView)localObject2).setShadowProperties(afur.a(6.0F, ((ShadowView)localObject2).getResources()), 0.0F, afur.a(2.0F, ((ShadowView)localObject2).getResources()), Color.parseColor("#B3E0E1E7"));
        }
        if (localObject1 != null)
        {
          if (this.jdField_a_of_type_Boolean) {
            ((UpArrowView)localObject1).setTheme(true);
          }
          b((View)localObject1, parambddw);
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
        if (parambddw.jdField_b_of_type_Int == 1) {}
        for (((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(f * 16.0F + 0.5D));; ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0)
        {
          ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break;
        }
        label328:
        paramView.setBackgroundResource(2130839432);
        if (localView != null) {
          localView.setVisibility(8);
        }
        ((ViewGroup.LayoutParams)localObject3).height = ((int)paramView.getResources().getDimension(2131296532));
      }
    }
    if (parambddw.jdField_b_of_type_Boolean)
    {
      localObject1 = paramView.findViewById(2131368889);
      if (localObject1 != null) {
        break label601;
      }
      localObject1 = paramView;
    }
    label599:
    label601:
    for (;;)
    {
      localObject2 = (UpArrowView)paramView.findViewById(2131362936);
      localObject3 = (ShadowView)paramView.findViewById(2131362954);
      if (localObject3 != null)
      {
        ((ShadowView)localObject3).setOriginColor(0);
        ((ShadowView)localObject3).setShadowProperties(afur.a(6.0F, ((ShadowView)localObject3).getResources()), 0.0F, afur.a(2.0F, ((ShadowView)localObject3).getResources()), Color.parseColor("#B3E0E1E7"));
      }
      b((View)localObject2, parambddw);
      ((View)localObject1).setBackgroundResource(2130839432);
      for (;;)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label599;
        }
        localObject1 = paramView.findViewById(2131365590);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        if (!parambddw.jdField_b_of_type_Boolean) {
          break;
        }
        localObject1 = (UpArrowView)paramView.findViewById(2131362936);
        paramView = (ShadowView)paramView.findViewById(2131362954);
        if (paramView != null)
        {
          paramView.setOriginColor(0);
          paramView.setShadowProperties(afur.a(6.0F, paramView.getResources()), 0.0F, afur.a(2.0F, paramView.getResources()), Color.parseColor("#B3E0E1E7"));
        }
        if (localObject1 != null) {
          ((UpArrowView)localObject1).setTheme(true);
        }
        b((View)localObject1, parambddw);
        return;
        paramView.setBackgroundResource(2130839432);
      }
      break;
    }
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    bddw localbddw;
    int j;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562932, paramViewGroup, false);
      paramViewGroup = new ambd(this);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramView.findViewById(2131368138));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131378776));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131380256));
      if ((paramView instanceof AlphaClickableRelativeLayout)) {
        ((AlphaClickableRelativeLayout)paramView).a(true);
      }
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.a().setFakeBoldText(true);
      paramView.setTag(paramViewGroup);
      localbddw = (bddw)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_Bddw = localbddw;
      SimpleAccount localSimpleAccount = (SimpleAccount)localbddw.jdField_a_of_type_JavaLangObject;
      aoch localaoch = aoch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localSimpleAccount.getUin());
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localbddw.jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSimpleAccount.getUin());
      paramViewGroup.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(localaoch);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(1, paramView);
      j = localbddw.jdField_d_of_type_Int;
      if (j <= 0) {
        break label264;
      }
      i = 2130844811;
    }
    label264:
    for (paramInt = 3;; paramInt = 0)
    {
      bkjh.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, paramInt, j, i, 99, null);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((AppSetting.c) && (!TextUtils.isEmpty(localbddw.jdField_d_of_type_JavaLangString))) {
        paramView.setContentDescription(localbddw.jdField_d_of_type_JavaLangString);
      }
      return paramView;
      paramViewGroup = (ambd)paramView.getTag();
      break;
    }
  }
  
  private void b(View paramView, bddw parambddw)
  {
    if ((paramView == null) || (parambddw == null)) {
      return;
    }
    int i = a(parambddw);
    parambddw = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    int j = afur.a(43.0F, paramView.getResources());
    parambddw.leftMargin = (i * afur.a(73.0F, paramView.getResources()) + j - afur.a(6.0F, paramView.getResources()));
    paramView.setLayoutParams(parambddw);
  }
  
  private View c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ambd localambd;
    bddw localbddw;
    Resources localResources;
    SubAccountMessage localSubAccountMessage;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562926, paramViewGroup, false);
      localambd = new ambd(this);
      localambd.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramViewGroup.findViewById(2131378776));
      localambd.jdField_a_of_type_ComTencentWidgetFixSizeImageView = ((FixSizeImageView)paramViewGroup.findViewById(2131368138));
      localambd.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramViewGroup.findViewById(2131380256));
      localambd.b = ((SingleLineTextView)paramViewGroup.findViewById(2131365369));
      paramViewGroup.setTag(localambd);
      localbddw = (bddw)getItem(paramInt);
      localambd.jdField_a_of_type_Bddw = localbddw;
      localResources = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources();
      if (localbddw != null)
      {
        localSubAccountMessage = (SubAccountMessage)localbddw.jdField_a_of_type_JavaLangObject;
        paramView = localSubAccountMessage.sendername;
        if (localSubAccountMessage.istroop == 1) {
          paramView = localResources.getString(2131718304);
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
      localambd.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText((CharSequence)localObject);
      if (((localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) && (localSubAccountMessage.msg != null)) {
        localSubAccountMessage.mEmoRecentMsg = new bdnt(localSubAccountMessage.msg, 3, 16);
      }
      if (localSubAccountMessage.istroop == 1) {
        if (localSubAccountMessage.unreadNum > 0)
        {
          paramView = localResources.getString(2131718305);
          localambd.b.setText(paramView);
          if ((localSubAccountMessage.mTimeString == null) || (localSubAccountMessage.mEmoRecentMsg == null) || (localSubAccountMessage.mEmoRecentMsg.length() == 0)) {
            localSubAccountMessage.mTimeString = bgsu.a(localSubAccountMessage.time * 1000L, true, bddy.jdField_a_of_type_JavaLangString);
          }
          if (localSubAccountMessage.istroop != 1) {
            localambd.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendText(localSubAccountMessage.mTimeString, 0);
          }
          if (!anhk.aD.equals(localSubAccountMessage.senderuin)) {
            break label907;
          }
        }
      }
      try
      {
        paramView = BitmapFactory.decodeResource(localResources, 2130842420);
        if (!this.jdField_b_of_type_Boolean) {
          break label874;
        }
        paramView = QQAppInterface.a(paramView, 3, 50, 50);
        label380:
        localambd.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageBitmap(paramView);
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
      localambd.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      int n = localSubAccountMessage.unreadNum;
      int i = 0;
      int j = 0;
      if ((n > 0) && (localSubAccountMessage.istroop == 1))
      {
        j = 2130850388;
        i = 1;
        paramView = "";
        paramInt = 0;
      }
      for (;;)
      {
        label441:
        localambd.b.setExtendText(paramView, 1);
        localambd.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, paramViewGroup);
        bkjh.a(localambd.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, n, j, 99, null);
        StringBuilder localStringBuilder;
        float f;
        if ((AppSetting.c) && (TextUtils.isEmpty(localbddw.jdField_d_of_type_JavaLangString)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject).append(",");
          if (localbddw.jdField_d_of_type_Int == 0)
          {
            if (paramView != null) {
              localStringBuilder.append(paramView + ",");
            }
            localStringBuilder.append(localSubAccountMessage.mEmoRecentMsg).append(",").append(localSubAccountMessage.mTimeString);
            localbddw.jdField_d_of_type_JavaLangString = localStringBuilder.toString();
          }
        }
        else
        {
          f = bgln.a();
          paramView = localResources.getColorStateList(2131167060);
          localObject = localResources.getColorStateList(2131166986);
          i = localResources.getColor(2131167092);
          localambd.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor((ColorStateList)localObject);
          localambd.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 0);
          localambd.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(12.0F, 0);
          localambd.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setCompoundDrawablePadding((int)(3.0F * f));
          localambd.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextPadding((int)(5.0F * f), 2);
          localambd.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextColor(paramView, 2);
          localambd.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setExtendTextSize(17.0F, 2);
          if (paramInt == 0) {
            break label1151;
          }
          localambd.b.setTextColor(i);
        }
        for (;;)
        {
          localambd.b.setExtendTextColor(ColorStateList.valueOf(i), 1);
          localambd.b.setExtendTextPadding((int)(f * 2.0F), 1);
          localambd.b.setExtendTextSize(14.0F, 1);
          a(paramViewGroup, localbddw);
          paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          if ((AppSetting.c) && (!TextUtils.isEmpty(localbddw.jdField_d_of_type_JavaLangString))) {
            paramViewGroup.setContentDescription(localbddw.jdField_d_of_type_JavaLangString);
          }
          if (this.jdField_a_of_type_Boolean)
          {
            paramView = paramViewGroup.findViewById(2131365604);
            if (paramView != null) {
              paramView.setVisibility(8);
            }
          }
          return paramViewGroup;
          localambd = (ambd)paramView.getTag();
          paramViewGroup = paramView;
          break;
          paramView = localResources.getString(2131718306);
          break label258;
          localambd.b.setText(localSubAccountMessage.mEmoRecentMsg);
          break label267;
          label874:
          paramView = QQAppInterface.a(paramView, 50, 50);
          break label380;
          paramView = aoch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localSubAccountMessage.senderuin);
          localambd.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setTag(localSubAccountMessage.senderuin);
          localambd.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setImageDrawable(paramView);
          localambd.jdField_a_of_type_ComTencentWidgetFixSizeImageView.setVisibility(0);
          break label389;
          if (n <= 0) {
            break label1163;
          }
          paramInt = 2130850392;
          int k = 3;
          if ((2 == localbddw.c) || (3 == localbddw.c))
          {
            paramView = "[" + localResources.getString(2131716033) + "]";
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
          if (localbddw.jdField_d_of_type_Int == 1)
          {
            localStringBuilder.append("有一条未读");
            break label526;
          }
          if (localbddw.jdField_d_of_type_Int == 2)
          {
            localStringBuilder.append("有两条未读");
            break label526;
          }
          if (localbddw.jdField_d_of_type_Int <= 0) {
            break label526;
          }
          localStringBuilder.append("有").append(localbddw.jdField_d_of_type_Int).append("条未读,");
          break label526;
          label1151:
          localambd.b.setTextColor(paramView);
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
      return ((bddw)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (QLog.isDevelopLevel()) {
      QLog.d("SUB_ACCOUNT_AssocQQ_Adapter", 2, "getView() position=" + paramInt + " viewType=" + i);
    }
    View localView;
    switch (i)
    {
    case 5: 
    default: 
      localView = paramView;
      if (paramView == null) {
        localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562929, paramViewGroup, false);
      }
      paramView = localView;
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      localView = c(paramInt, paramView, paramViewGroup);
      continue;
      localView = b(paramInt, paramView, paramViewGroup);
      continue;
      localView = a(paramInt, paramView, paramViewGroup);
      continue;
      localView = a(paramInt, paramView, paramViewGroup, i);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ambb
 * JD-Core Version:    0.7.0.1
 */