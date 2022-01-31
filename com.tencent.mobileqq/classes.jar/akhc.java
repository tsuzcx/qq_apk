import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.adapter.TroopListAdapter2.2;
import com.tencent.mobileqq.adapter.TroopListAdapter2.5;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.Switch;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class akhc
  extends aked
  implements CompoundButton.OnCheckedChangeListener
{
  int jdField_a_of_type_Int = 0;
  ahko jdField_a_of_type_Ahko;
  akhh jdField_a_of_type_Akhh;
  protected almv a;
  protected amab a;
  Context jdField_a_of_type_AndroidContentContext;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TroopManager a;
  SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  protected HashMap<String, Switch> a;
  public List<akhj> a;
  protected boolean a;
  public int b;
  protected View.OnClickListener b;
  protected List<awbv> b;
  protected boolean b;
  public int c;
  public boolean c;
  public int d;
  protected boolean d;
  public int e;
  public int f;
  public int g;
  
  public akhc(Context paramContext, QQAppInterface paramQQAppInterface, akhh paramakhh, XListView paramXListView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, ahko paramahko)
  {
    super(paramContext, paramQQAppInterface, paramXListView, 4, true);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new akhe(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new akhf(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Akhh = paramakhh;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)paramXListView);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_d_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_Ahko = paramahko;
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramQQAppInterface.getManager(52));
    this.jdField_a_of_type_Almv = ((almv)paramQQAppInterface.getManager(53));
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_AndroidContentContext instanceof TroopActivity)))
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_Amab = new akhd(this, (TroopActivity)this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 1;
    case 4: 
      return 2;
    case 2: 
      return 3;
    }
    return 4;
  }
  
  private List<akhj> a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilHashMap != null)) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    this.jdField_b_of_type_JavaUtilList = ((TroopManager)localObject1).a();
    if (this.jdField_b_of_type_JavaUtilList == null)
    {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
      return localArrayList;
    }
    Object localObject5 = new ArrayList();
    Object localObject2 = ((TroopManager)localObject1).a();
    if (localObject2 != null)
    {
      Collections.sort((List)localObject2, new akhg());
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject5).add(((TroopManager)localObject1).b(((CommonlyUsedTroop)((Iterator)localObject2).next()).troopUin));
      }
      this.e = ((List)localObject5).size();
    }
    Object localObject4 = new ArrayList();
    Object localObject3 = new ArrayList();
    localObject2 = new ArrayList();
    Object localObject6 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject7 = this.jdField_b_of_type_JavaUtilList.iterator();
    label395:
    while (((Iterator)localObject7).hasNext())
    {
      localObject8 = (TroopInfo)((Iterator)localObject7).next();
      int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localObject8).troopuin));
      if (((TroopInfo)localObject8).isQidianPrivateTroop())
      {
        ((List)localObject1).add(new akhk(i, (awbv)localObject8));
      }
      else
      {
        if ((((TroopInfo)localObject8).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject4).add(new akhk(i, (awbv)localObject8));
        }
        for (;;)
        {
          if (((TroopInfo)localObject8).hasSetTroopName()) {
            break label395;
          }
          ((List)localObject6).add(new akhk(i, (awbv)localObject8));
          break;
          if ((((TroopInfo)localObject8).dwCmdUinUinFlag & 1L) == 1L) {
            ((List)localObject3).add(new akhk(i, (awbv)localObject8));
          } else {
            ((List)localObject2).add(new akhk(i, (awbv)localObject8));
          }
        }
      }
    }
    localObject7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    Object localObject8 = ((almv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a();
    if (this.jdField_d_of_type_Boolean)
    {
      localObject8 = ((List)localObject8).iterator();
      label593:
      while (((Iterator)localObject8).hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject8).next();
        RecentUser localRecentUser = ((amjk)localObject7).a(localDiscussionInfo.uin, 3000);
        localDiscussionInfo.lastMsgTime = localRecentUser.lastmsgtime;
        if (localRecentUser.showUpTime != 0L) {
          ((List)localObject5).add(localDiscussionInfo);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(localDiscussionInfo.ownerUin)) {
          ((List)localObject4).add(new akhk(1, localDiscussionInfo));
        }
        for (;;)
        {
          if (localDiscussionInfo.hasRenamed()) {
            break label593;
          }
          ((List)localObject6).add(new akhk(1, localDiscussionInfo));
          break;
          ((List)localObject2).add(new akhk(1, localDiscussionInfo));
        }
      }
      this.e = ((List)localObject5).size();
      this.jdField_b_of_type_Int = ((List)localObject4).size();
      this.jdField_d_of_type_Int = ((List)localObject2).size();
      this.f = ((List)localObject6).size();
    }
    localObject7 = new akhi();
    Collections.sort((List)localObject4, (Comparator)localObject7);
    Collections.sort((List)localObject3, (Comparator)localObject7);
    Collections.sort((List)localObject2, (Comparator)localObject7);
    Collections.sort((List)localObject6, (Comparator)localObject7);
    Collections.sort((List)localObject1, (Comparator)localObject7);
    if (this.e > 0)
    {
      localArrayList.add(new akhj(0, null));
      localObject5 = ((List)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject7 = (awbv)((Iterator)localObject5).next();
        if ((localObject7 instanceof TroopInfo))
        {
          localArrayList.add(new akhj(1, (awbv)localObject7));
        }
        else if ((localObject7 instanceof DiscussionInfo))
        {
          localObject7 = (DiscussionInfo)localObject7;
          localArrayList.add(new akhj(1, (DiscussionInfo)localObject7, this.jdField_a_of_type_Almv.a(((DiscussionInfo)localObject7).uin)));
        }
      }
    }
    if (this.f > 0)
    {
      localArrayList.add(new akhj(8, null));
      localObject5 = ((List)localObject6).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (akhk)((Iterator)localObject5).next();
        if ((((akhk)localObject6).a instanceof TroopInfo))
        {
          localArrayList.add(new akhj(9, ((akhk)localObject6).a));
        }
        else if ((((akhk)localObject6).a instanceof DiscussionInfo))
        {
          localObject6 = (DiscussionInfo)((akhk)localObject6).a;
          localArrayList.add(new akhj(9, (DiscussionInfo)localObject6, this.jdField_a_of_type_Almv.a(((DiscussionInfo)localObject6).uin)));
        }
      }
    }
    if (this.jdField_b_of_type_Int > 0)
    {
      localArrayList.add(new akhj(4, null));
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (akhk)((Iterator)localObject4).next();
        if ((((akhk)localObject5).a instanceof TroopInfo))
        {
          localArrayList.add(new akhj(5, ((akhk)localObject5).a));
        }
        else if ((((akhk)localObject5).a instanceof DiscussionInfo))
        {
          localObject5 = (DiscussionInfo)((akhk)localObject5).a;
          localArrayList.add(new akhj(5, (DiscussionInfo)localObject5, this.jdField_a_of_type_Almv.a(((DiscussionInfo)localObject5).uin)));
        }
      }
    }
    this.jdField_c_of_type_Int = ((List)localObject3).size();
    if (this.jdField_c_of_type_Int > 0)
    {
      localArrayList.add(new akhj(6, null));
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList.add(new akhj(7, ((akhk)((Iterator)localObject3).next()).a));
      }
    }
    if (this.jdField_d_of_type_Int > 0)
    {
      localArrayList.add(new akhj(2, null));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (akhk)((Iterator)localObject2).next();
        if ((((akhk)localObject3).a instanceof TroopInfo))
        {
          localArrayList.add(new akhj(3, ((akhk)localObject3).a));
        }
        else if ((((akhk)localObject3).a instanceof DiscussionInfo))
        {
          localObject3 = (DiscussionInfo)((akhk)localObject3).a;
          localArrayList.add(new akhj(3, (DiscussionInfo)localObject3, this.jdField_a_of_type_Almv.a(((DiscussionInfo)localObject3).uin)));
        }
      }
    }
    this.g = ((List)localObject1).size();
    if (this.g > 0)
    {
      localArrayList.add(new akhj(10, null));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localArrayList.add(new akhj(11, ((akhk)((Iterator)localObject1).next()).a));
      }
    }
    return localArrayList;
  }
  
  private void a(akhj paramakhj, String paramString, boolean paramBoolean)
  {
    ((alzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(paramString, paramakhj.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, paramBoolean, false);
    if (paramBoolean) {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_join", "", "join_page", "set_open", 0, 0, paramakhj.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ahko != null) {
        this.jdField_a_of_type_Ahko.a(paramakhj.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, paramBoolean);
      }
      return;
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_join", "", "join_page", "set_close", 0, 0, paramakhj.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, "", "", "");
    }
  }
  
  public TroopInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((akhj)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
    }
    return null;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_Boolean = true;
    Object localObject3 = (akhj)getItem(paramInt);
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559746, paramViewGroup, false);
      localObject2 = new akhl((View)localObject1);
      ((View)localObject1).setTag(localObject2);
      ((Button)((View)localObject1).findViewById(2131378295)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject1).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      paramViewGroup = (ViewGroup)localObject2;
      paramView = (View)localObject1;
      if (this.jdField_a_of_type_Boolean)
      {
        ((akhl)localObject2).jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this);
        paramView = (View)localObject1;
        paramViewGroup = (ViewGroup)localObject2;
      }
      paramViewGroup.jdField_a_of_type_Akhj = ((akhj)localObject3);
      if ((this.jdField_a_of_type_Boolean) && (paramViewGroup.jdField_a_of_type_Akhj.jdField_a_of_type_Int != 0) && (paramViewGroup.jdField_a_of_type_Akhj.jdField_a_of_type_Int != 4) && (paramViewGroup.jdField_a_of_type_Akhj.jdField_a_of_type_Int != 6) && (paramViewGroup.jdField_a_of_type_Akhj.jdField_a_of_type_Int != 8) && (paramViewGroup.jdField_a_of_type_Akhj.jdField_a_of_type_Int != 2))
      {
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setVisibility(0);
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setTag(paramViewGroup.jdField_a_of_type_Akhj);
        if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) || (paramViewGroup.jdField_a_of_type_Akhj.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d(((akhj)localObject3).jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin))) {
          break label365;
        }
        paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
        label260:
        if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (((akhj)localObject3).jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)) {
          this.jdField_a_of_type_JavaUtilHashMap.put(((akhj)localObject3).jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin, paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch);
        }
      }
      if (((akhj)localObject3).jdField_a_of_type_Int != 0) {
        break label376;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(alpo.a(2131715859));
      paramViewGroup.e.setText(String.valueOf(this.e));
    }
    label365:
    label1007:
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      return paramView;
      paramViewGroup = (akhl)paramView.getTag();
      break;
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
      break label260;
      label376:
      if (((akhj)localObject3).jdField_a_of_type_Int == 2)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(alpo.a(2131716197));
        paramViewGroup.e.setText(String.valueOf(this.jdField_d_of_type_Int));
      }
      else if (((akhj)localObject3).jdField_a_of_type_Int == 4)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(alpo.a(2131716201));
        paramViewGroup.e.setText(String.valueOf(this.jdField_b_of_type_Int));
      }
      else if (((akhj)localObject3).jdField_a_of_type_Int == 6)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(alpo.a(2131716204));
        paramViewGroup.e.setText(String.valueOf(this.jdField_c_of_type_Int));
      }
      else if (((akhj)localObject3).jdField_a_of_type_Int == 8)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(alpo.a(2131716202));
        paramViewGroup.e.setText(String.valueOf(this.f));
      }
      else if (((akhj)localObject3).jdField_a_of_type_Int == 10)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramViewGroup.jdField_d_of_type_AndroidWidgetTextView.setText(alpo.a(2131702952));
        paramViewGroup.e.setText(String.valueOf(this.g));
      }
      else if (((akhj)localObject3).jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        localObject2 = ((akhj)localObject3).jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
        paramViewGroup.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject2).troopuin;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((TroopInfo)localObject2).troopuin) != 3)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          localObject3 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
          if (TextUtils.isEmpty(((TroopInfo)localObject2).getTroopName())) {
            break label930;
          }
          localObject1 = ((TroopInfo)localObject2).getTroopName();
          ((TextView)localObject3).setText((CharSequence)localObject1);
          paramViewGroup.c.setImageBitmap(a(4, ((TroopInfo)localObject2).troopuin));
          if ((((TroopInfo)localObject2).hasSetTroopName()) || (((TroopInfo)localObject2).wMemberNumClient <= 0)) {
            break label940;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject2).wMemberNumClient) }));
          if ((((TroopInfo)localObject2).dwGroupFlagExt & 0x800) == 0L) {
            break label995;
          }
          if (((TroopInfo)localObject2).dwAuthGroupType != 2L) {
            break label952;
          }
          paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843417);
        }
        for (;;)
        {
          if (((TroopInfo)localObject2).troopCreditLevel != 2L) {
            break label1007;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849771);
          break;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849768);
          break label724;
          localObject1 = ((TroopInfo)localObject2).troopuin;
          break label748;
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label824;
          if (((TroopInfo)localObject2).dwAuthGroupType == 1L)
          {
            paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
            paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130843417);
          }
          else
          {
            paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
            continue;
            paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
          }
        }
        if (((TroopInfo)localObject2).troopCreditLevel == 1L)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849769);
        }
        else
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
        }
      }
      else if (((akhj)localObject3).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        localObject1 = ((akhj)localObject3).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
        paramViewGroup.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject1).uin;
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(bdbt.a(this.jdField_a_of_type_AndroidContentContext, (DiscussionInfo)localObject1));
        if (!((DiscussionInfo)localObject1).hasRenamed())
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((akhj)localObject3).jdField_b_of_type_Int) }));
        }
        paramViewGroup.c.setImageBitmap(a(101, ((DiscussionInfo)localObject1).uin));
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    ThreadManager.post(new TroopListAdapter2.2(this), 8, null, true);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        paramCompoundButton = paramCompoundButton.getTag();
      } while (!(paramCompoundButton instanceof akhj));
      paramCompoundButton = (akhj)paramCompoundButton;
    } while (paramCompoundButton.jdField_a_of_type_ComTencentMobileqqDataTroopInfo == null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
    }
    String str1 = paramCompoundButton.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
    String str2 = paramCompoundButton.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin;
    TroopManager localTroopManager = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager;
    if (TextUtils.isEmpty(str1))
    {
      ThreadManager.post(new TroopListAdapter2.5(this, localTroopManager, str2, paramCompoundButton, paramBoolean), 8, null, true);
      return;
    }
    a(paramCompoundButton, str1, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhc
 * JD-Core Version:    0.7.0.1
 */