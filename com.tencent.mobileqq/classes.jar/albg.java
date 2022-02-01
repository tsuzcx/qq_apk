import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;

public class albg
  extends aliy
{
  public int a;
  protected amrb a;
  andd jdField_a_of_type_Andd = new albi(this);
  protected Context a;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected XListView a;
  protected List<albk> a;
  private nmf jdField_a_of_type_Nmf = new albh(this);
  public int b;
  public int c;
  public int d;
  public int e;
  private int f;
  private int g;
  private int h;
  
  public albg(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.g = paramContext.getResources().getColor(2131167012);
    this.h = Color.parseColor("#808080");
    this.jdField_a_of_type_Amrb = ((amrb)paramQQAppInterface.getManager(53));
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Andd);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, nmf paramnmf, ArrayList<String> paramArrayList)
  {
    oidb_0x88d.ReqBody localReqBody = new oidb_0x88d.ReqBody();
    localReqBody.uint32_appid.set(AppSetting.a());
    Object localObject = paramArrayList.iterator();
    int i = 0;
    int j;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      String str = (String)((Iterator)localObject).next();
      j = i + 1;
      oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
      localGroupInfo.uint32_app_privilege_flag.set(0);
      oidb_0x88d.ReqGroupInfo localReqGroupInfo = new oidb_0x88d.ReqGroupInfo();
      localReqGroupInfo.uint64_group_code.set(Long.parseLong(str));
      localReqGroupInfo.stgroupinfo.set(localGroupInfo);
      localReqBody.stzreqgroupinfo.add(localReqGroupInfo);
      i = j;
    } while (j != 49);
    localObject = new Bundle();
    if (paramArrayList.size() > 50)
    {
      i = 0;
      while (i < 50)
      {
        paramArrayList.remove(0);
        i += 1;
      }
      ((Bundle)localObject).putStringArrayList("TroopList", paramArrayList);
    }
    nmb.b(paramQQAppInterface, paramnmf, localReqBody.toByteArray(), "OidbSvc.0x88d_0", 2189, 0, (Bundle)localObject);
  }
  
  public int a(int paramInt)
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
  
  public void a(QQAppInterface paramQQAppInterface, ArrayList<Entity> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1 = (TroopManager)paramQQAppInterface.getManager(52);
    Object localObject4 = new ArrayList();
    Object localObject2 = ((TroopManager)localObject1).a();
    if (localObject2 != null)
    {
      Collections.sort((List)localObject2, new albj(this));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((TroopManager)localObject1).b(((CommonlyUsedTroop)((Iterator)localObject2).next()).troopUin);
        if ((localObject3 != null) && (!((TroopInfo)localObject3).isQidianPrivateTroop())) {
          ((List)localObject4).add(localObject3);
        }
      }
      this.d = ((List)localObject4).size();
    }
    Object localObject3 = new ArrayList();
    localObject2 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject5 = new ArrayList();
    Object localObject6 = paramArrayList.iterator();
    int i;
    label330:
    while (((Iterator)localObject6).hasNext())
    {
      localObject7 = (TroopInfo)((Iterator)localObject6).next();
      if (!((TroopInfo)localObject7).isQidianPrivateTroop())
      {
        i = a(paramQQAppInterface.getTroopMask(((TroopInfo)localObject7).troopuin));
        if ((((TroopInfo)localObject7).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject3).add(new almg(i, (Entity)localObject7));
        }
        for (;;)
        {
          if (((TroopInfo)localObject7).hasSetTroopName()) {
            break label330;
          }
          ((List)localObject5).add(new almg(i, (Entity)localObject7));
          break;
          if ((((TroopInfo)localObject7).dwCmdUinUinFlag & 1L) == 1L) {
            ((List)localObject2).add(new almg(i, (Entity)localObject7));
          } else {
            ((List)localObject1).add(new almg(i, (Entity)localObject7));
          }
        }
      }
    }
    localObject6 = paramQQAppInterface.getProxyManager().a();
    Object localObject7 = ((amrb)paramQQAppInterface.getManager(53)).a().iterator();
    label511:
    while (((Iterator)localObject7).hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject7).next();
      RecentUser localRecentUser = (RecentUser)((anuz)localObject6).findRecentUserByUin(localDiscussionInfo.uin, 3000);
      localDiscussionInfo.lastMsgTime = localRecentUser.lastmsgtime;
      if (localRecentUser.showUpTime != 0L) {
        ((List)localObject4).add(localDiscussionInfo);
      }
      if (paramQQAppInterface.getCurrentUin().equals(localDiscussionInfo.ownerUin)) {
        ((List)localObject3).add(new almg(1, localDiscussionInfo));
      }
      for (;;)
      {
        if (localDiscussionInfo.hasRenamed()) {
          break label511;
        }
        ((List)localObject5).add(new almg(1, localDiscussionInfo));
        break;
        ((List)localObject1).add(new almg(1, localDiscussionInfo));
      }
    }
    this.d = ((List)localObject4).size();
    this.jdField_a_of_type_Int = ((List)localObject3).size();
    this.c = ((List)localObject1).size();
    this.e = ((List)localObject5).size();
    localObject6 = new alme();
    Collections.sort((List)localObject3, (Comparator)localObject6);
    Collections.sort((List)localObject2, (Comparator)localObject6);
    Collections.sort((List)localObject1, (Comparator)localObject6);
    Collections.sort((List)localObject5, (Comparator)localObject6);
    if (this.d > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new albk(this, 0, null));
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject6 = (Entity)((Iterator)localObject4).next();
        if ((localObject6 instanceof TroopInfo))
        {
          this.jdField_a_of_type_JavaUtilList.add(new albk(this, 1, (Entity)localObject6));
        }
        else if ((localObject6 instanceof DiscussionInfo))
        {
          localObject6 = (DiscussionInfo)localObject6;
          i = this.jdField_a_of_type_Amrb.a(((DiscussionInfo)localObject6).uin);
          this.jdField_a_of_type_JavaUtilList.add(new albk(this, 1, (DiscussionInfo)localObject6, i));
        }
      }
    }
    if (this.e > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new albk(this, 8, null));
      localObject4 = ((List)localObject5).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (almg)((Iterator)localObject4).next();
        if ((((almg)localObject5).a instanceof TroopInfo))
        {
          this.jdField_a_of_type_JavaUtilList.add(new albk(this, 3, ((almg)localObject5).a));
        }
        else if ((((almg)localObject5).a instanceof DiscussionInfo))
        {
          localObject5 = (DiscussionInfo)((almg)localObject5).a;
          i = this.jdField_a_of_type_Amrb.a(((DiscussionInfo)localObject5).uin);
          this.jdField_a_of_type_JavaUtilList.add(new albk(this, 3, (DiscussionInfo)localObject5, i));
        }
      }
    }
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new albk(this, 4, null));
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (almg)((Iterator)localObject3).next();
        if ((((almg)localObject4).a instanceof TroopInfo))
        {
          this.jdField_a_of_type_JavaUtilList.add(new albk(this, 5, ((almg)localObject4).a));
        }
        else if ((((almg)localObject4).a instanceof DiscussionInfo))
        {
          localObject4 = (DiscussionInfo)((almg)localObject4).a;
          i = this.jdField_a_of_type_Amrb.a(((DiscussionInfo)localObject4).uin);
          this.jdField_a_of_type_JavaUtilList.add(new albk(this, 5, (DiscussionInfo)localObject4, i));
        }
      }
    }
    this.b = ((List)localObject2).size();
    if (this.b > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new albk(this, 6, null));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (almg)((Iterator)localObject2).next();
        this.jdField_a_of_type_JavaUtilList.add(new albk(this, 7, ((almg)localObject3).a));
      }
    }
    if (this.c > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new albk(this, 2, null));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (almg)((Iterator)localObject1).next();
        if ((((almg)localObject2).a instanceof TroopInfo))
        {
          this.jdField_a_of_type_JavaUtilList.add(new albk(this, 3, ((almg)localObject2).a));
        }
        else if ((((almg)localObject2).a instanceof DiscussionInfo))
        {
          localObject2 = (DiscussionInfo)((almg)localObject2).a;
          i = this.jdField_a_of_type_Amrb.a(((DiscussionInfo)localObject2).uin);
          this.jdField_a_of_type_JavaUtilList.add(new albk(this, 3, (DiscussionInfo)localObject2, i));
        }
      }
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof SelectMemberActivity))
    {
      this.f = ((SelectMemberActivity)this.jdField_a_of_type_AndroidContentContext).getType();
      if (this.f == 3000)
      {
        localObject1 = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          ((ArrayList)localObject1).add(((TroopInfo)paramArrayList.next()).troopuin);
        }
        a(paramQQAppInterface, this.jdField_a_of_type_Nmf, (ArrayList)localObject1);
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Andd);
    super.c();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    albk localalbk = (albk)getItem(paramInt);
    Object localObject1;
    if (localalbk == null)
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    label55:
    View localView;
    Object localObject2;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject1 = (albl)paramView.getTag();
      localView = paramView.findViewById(2131379223);
      localObject2 = (TextView)paramView.findViewById(2131379305);
      if (localalbk.jdField_a_of_type_Int != 0) {
        break label242;
      }
      localView.setVisibility(8);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131695679, new Object[] { String.valueOf(this.d) }));
    }
    label520:
    label622:
    for (;;)
    {
      localObject1 = paramView;
      break;
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562788, this.jdField_a_of_type_ComTencentWidgetXListView, false);
      localObject1 = new albl(this);
      ((albl)localObject1).c = ((ImageView)paramView.findViewById(2131366241));
      ((albl)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366267));
      ((albl)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379260));
      ((albl)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379246));
      ((albl)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362968));
      paramView.setTag(localObject1);
      break label55;
      label242:
      if (localalbk.jdField_a_of_type_Int == 2)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131695699, new Object[] { String.valueOf(this.c) }));
      }
      else if (localalbk.jdField_a_of_type_Int == 4)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131695612, new Object[] { String.valueOf(this.jdField_a_of_type_Int) }));
      }
      else if (localalbk.jdField_a_of_type_Int == 6)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131695651, new Object[] { String.valueOf(this.b) }));
      }
      else if (localalbk.jdField_a_of_type_Int == 8)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131695794, new Object[] { String.valueOf(this.e) }));
      }
      else
      {
        if (localalbk.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
        {
          localView.setVisibility(0);
          ((TextView)localObject2).setVisibility(8);
          TroopInfo localTroopInfo = localalbk.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
          ((albl)localObject1).jdField_a_of_type_JavaLangString = localTroopInfo.troopuin;
          TextView localTextView = ((albl)localObject1).jdField_a_of_type_AndroidWidgetTextView;
          if (localTroopInfo.getTroopName() != null)
          {
            localObject2 = localTroopInfo.getTroopName();
            localTextView.setText((CharSequence)localObject2);
            ((albl)localObject1).c.setImageBitmap(a(4, localTroopInfo.troopuin));
            ((albl)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localTroopInfo;
            ((albl)localObject1).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = null;
            ((albl)localObject1).jdField_a_of_type_Int = localalbk.jdField_a_of_type_Int;
            if ((localTroopInfo.hasSetTroopName()) || (localTroopInfo.wMemberNumClient <= 0)) {
              break label718;
            }
            ((albl)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            ((albl)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(localTroopInfo.wMemberNumClient) }));
            if ((localTroopInfo.isAllowCreateDiscuss()) || (localTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (localTroopInfo.isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
              break label731;
            }
            localView.setEnabled(false);
            ((albl)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            ((albl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            ((albl)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.h);
          }
          for (;;)
          {
            paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            break;
            localObject2 = localTroopInfo.troopcode;
            break label520;
            ((albl)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            break label622;
            ((albl)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            ((albl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((albl)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.g);
          }
        }
        if (localalbk.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)
        {
          localView.setVisibility(0);
          ((TextView)localObject2).setVisibility(8);
          localObject2 = localalbk.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
          ((albl)localObject1).jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject2).uin;
          ((albl)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.getDiscussionName(this.jdField_a_of_type_AndroidContentContext, (DiscussionInfo)localObject2));
          ((albl)localObject1).c.setImageBitmap(a(101, ((DiscussionInfo)localObject2).uin));
          if (!((DiscussionInfo)localObject2).hasRenamed())
          {
            ((albl)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            ((albl)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_Amrb.a(((DiscussionInfo)localObject2).uin)) }));
          }
          ((albl)localObject1).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((DiscussionInfo)localObject2);
          ((albl)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = null;
          ((albl)localObject1).jdField_a_of_type_Int = localalbk.jdField_a_of_type_Int;
          ((albl)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          ((albl)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          ((albl)localObject1).jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.g);
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     albg
 * JD-Core Version:    0.7.0.1
 */