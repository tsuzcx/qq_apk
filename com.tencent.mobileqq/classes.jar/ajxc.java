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
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;

public class ajxc
  extends aked
{
  public int a;
  protected almv a;
  amab jdField_a_of_type_Amab = new ajxe(this);
  protected Context a;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected XListView a;
  protected List<ajxg> a;
  private nac jdField_a_of_type_Nac = new ajxd(this);
  public int b;
  public int c;
  public int d;
  public int e;
  private int f;
  private int g;
  private int h;
  
  public ajxc(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.g = paramContext.getResources().getColor(2131166901);
    this.h = Color.parseColor("#808080");
    this.jdField_a_of_type_Almv = ((almv)paramQQAppInterface.getManager(53));
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Amab);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, nac paramnac, ArrayList<String> paramArrayList)
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
    mzy.b(paramQQAppInterface, paramnac, localReqBody.toByteArray(), "OidbSvc.0x88d_0", 2189, 0, (Bundle)localObject);
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
  
  public void a(QQAppInterface paramQQAppInterface, ArrayList<awbv> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1 = (TroopManager)paramQQAppInterface.getManager(52);
    Object localObject4 = new ArrayList();
    Object localObject2 = ((TroopManager)localObject1).a();
    if (localObject2 != null)
    {
      Collections.sort((List)localObject2, new ajxf(this));
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
        i = a(paramQQAppInterface.b(((TroopInfo)localObject7).troopuin));
        if ((((TroopInfo)localObject7).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject3).add(new akhk(i, (awbv)localObject7));
        }
        for (;;)
        {
          if (((TroopInfo)localObject7).hasSetTroopName()) {
            break label330;
          }
          ((List)localObject5).add(new akhk(i, (awbv)localObject7));
          break;
          if ((((TroopInfo)localObject7).dwCmdUinUinFlag & 1L) == 1L) {
            ((List)localObject2).add(new akhk(i, (awbv)localObject7));
          } else {
            ((List)localObject1).add(new akhk(i, (awbv)localObject7));
          }
        }
      }
    }
    localObject6 = paramQQAppInterface.a().a();
    Object localObject7 = ((almv)paramQQAppInterface.getManager(53)).a().iterator();
    label508:
    while (((Iterator)localObject7).hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject7).next();
      RecentUser localRecentUser = ((amjk)localObject6).a(localDiscussionInfo.uin, 3000);
      localDiscussionInfo.lastMsgTime = localRecentUser.lastmsgtime;
      if (localRecentUser.showUpTime != 0L) {
        ((List)localObject4).add(localDiscussionInfo);
      }
      if (paramQQAppInterface.c().equals(localDiscussionInfo.ownerUin)) {
        ((List)localObject3).add(new akhk(1, localDiscussionInfo));
      }
      for (;;)
      {
        if (localDiscussionInfo.hasRenamed()) {
          break label508;
        }
        ((List)localObject5).add(new akhk(1, localDiscussionInfo));
        break;
        ((List)localObject1).add(new akhk(1, localDiscussionInfo));
      }
    }
    this.d = ((List)localObject4).size();
    this.jdField_a_of_type_Int = ((List)localObject3).size();
    this.c = ((List)localObject1).size();
    this.e = ((List)localObject5).size();
    localObject6 = new akhi();
    Collections.sort((List)localObject3, (Comparator)localObject6);
    Collections.sort((List)localObject2, (Comparator)localObject6);
    Collections.sort((List)localObject1, (Comparator)localObject6);
    Collections.sort((List)localObject5, (Comparator)localObject6);
    if (this.d > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new ajxg(this, 0, null));
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject6 = (awbv)((Iterator)localObject4).next();
        if ((localObject6 instanceof TroopInfo))
        {
          this.jdField_a_of_type_JavaUtilList.add(new ajxg(this, 1, (awbv)localObject6));
        }
        else if ((localObject6 instanceof DiscussionInfo))
        {
          localObject6 = (DiscussionInfo)localObject6;
          i = this.jdField_a_of_type_Almv.a(((DiscussionInfo)localObject6).uin);
          this.jdField_a_of_type_JavaUtilList.add(new ajxg(this, 1, (DiscussionInfo)localObject6, i));
        }
      }
    }
    if (this.e > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new ajxg(this, 8, null));
      localObject4 = ((List)localObject5).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (akhk)((Iterator)localObject4).next();
        if ((((akhk)localObject5).a instanceof TroopInfo))
        {
          this.jdField_a_of_type_JavaUtilList.add(new ajxg(this, 3, ((akhk)localObject5).a));
        }
        else if ((((akhk)localObject5).a instanceof DiscussionInfo))
        {
          localObject5 = (DiscussionInfo)((akhk)localObject5).a;
          i = this.jdField_a_of_type_Almv.a(((DiscussionInfo)localObject5).uin);
          this.jdField_a_of_type_JavaUtilList.add(new ajxg(this, 3, (DiscussionInfo)localObject5, i));
        }
      }
    }
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new ajxg(this, 4, null));
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (akhk)((Iterator)localObject3).next();
        if ((((akhk)localObject4).a instanceof TroopInfo))
        {
          this.jdField_a_of_type_JavaUtilList.add(new ajxg(this, 5, ((akhk)localObject4).a));
        }
        else if ((((akhk)localObject4).a instanceof DiscussionInfo))
        {
          localObject4 = (DiscussionInfo)((akhk)localObject4).a;
          i = this.jdField_a_of_type_Almv.a(((DiscussionInfo)localObject4).uin);
          this.jdField_a_of_type_JavaUtilList.add(new ajxg(this, 5, (DiscussionInfo)localObject4, i));
        }
      }
    }
    this.b = ((List)localObject2).size();
    if (this.b > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new ajxg(this, 6, null));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (akhk)((Iterator)localObject2).next();
        this.jdField_a_of_type_JavaUtilList.add(new ajxg(this, 7, ((akhk)localObject3).a));
      }
    }
    if (this.c > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new ajxg(this, 2, null));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (akhk)((Iterator)localObject1).next();
        if ((((akhk)localObject2).a instanceof TroopInfo))
        {
          this.jdField_a_of_type_JavaUtilList.add(new ajxg(this, 3, ((akhk)localObject2).a));
        }
        else if ((((akhk)localObject2).a instanceof DiscussionInfo))
        {
          localObject2 = (DiscussionInfo)((akhk)localObject2).a;
          i = this.jdField_a_of_type_Almv.a(((DiscussionInfo)localObject2).uin);
          this.jdField_a_of_type_JavaUtilList.add(new ajxg(this, 3, (DiscussionInfo)localObject2, i));
        }
      }
    }
    if ((this.jdField_a_of_type_AndroidContentContext instanceof SelectMemberActivity))
    {
      this.f = ((SelectMemberActivity)this.jdField_a_of_type_AndroidContentContext).c();
      if (this.f == 3000)
      {
        localObject1 = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          ((ArrayList)localObject1).add(((TroopInfo)paramArrayList.next()).troopuin);
        }
        a(paramQQAppInterface, this.jdField_a_of_type_Nac, (ArrayList)localObject1);
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amab);
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
    ajxg localajxg = (ajxg)getItem(paramInt);
    if (localajxg == null) {
      localObject1 = paramView;
    }
    View localView;
    Object localObject2;
    label584:
    do
    {
      return localObject1;
      if ((paramView != null) && (paramView.getTag() != null)) {
        paramViewGroup = (ajxh)paramView.getTag();
      }
      for (;;)
      {
        localView = paramView.findViewById(2131378382);
        localObject2 = (TextView)paramView.findViewById(2131378448);
        if (localajxg.jdField_a_of_type_Int != 0) {
          break;
        }
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131696670, new Object[] { String.valueOf(this.d) }));
        return paramView;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562619, this.jdField_a_of_type_ComTencentWidgetXListView, false);
        paramViewGroup = new ajxh(this);
        paramViewGroup.c = ((ImageView)paramView.findViewById(2131365910));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365938));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378414));
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378403));
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362823));
        paramView.setTag(paramViewGroup);
      }
      if (localajxg.jdField_a_of_type_Int == 2)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131696690, new Object[] { String.valueOf(this.c) }));
        return paramView;
      }
      if (localajxg.jdField_a_of_type_Int == 4)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131696603, new Object[] { String.valueOf(this.jdField_a_of_type_Int) }));
        return paramView;
      }
      if (localajxg.jdField_a_of_type_Int == 6)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131696642, new Object[] { String.valueOf(this.b) }));
        return paramView;
      }
      if (localajxg.jdField_a_of_type_Int == 8)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131696784, new Object[] { String.valueOf(this.e) }));
        return paramView;
      }
      if (localajxg.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        localView.setVisibility(0);
        ((TextView)localObject2).setVisibility(8);
        localObject2 = localajxg.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
        paramViewGroup.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject2).troopuin;
        TextView localTextView = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
        if (((TroopInfo)localObject2).getTroopName() != null)
        {
          localObject1 = ((TroopInfo)localObject2).getTroopName();
          localTextView.setText((CharSequence)localObject1);
          paramViewGroup.c.setImageBitmap(a(4, ((TroopInfo)localObject2).troopuin));
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject2);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = null;
          paramViewGroup.jdField_a_of_type_Int = localajxg.jdField_a_of_type_Int;
          if ((((TroopInfo)localObject2).hasSetTroopName()) || (((TroopInfo)localObject2).wMemberNumClient <= 0)) {
            break label676;
          }
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject2).wMemberNumClient) }));
          if ((((TroopInfo)localObject2).isAllowCreateDiscuss()) || (((TroopInfo)localObject2).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) || (((TroopInfo)localObject2).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
            break label688;
          }
          localView.setEnabled(false);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.h);
        }
        for (;;)
        {
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          return paramView;
          localObject1 = ((TroopInfo)localObject2).troopcode;
          break;
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          break label584;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.g);
        }
      }
      localObject1 = paramView;
    } while (localajxg.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo == null);
    label676:
    label688:
    localView.setVisibility(0);
    ((TextView)localObject2).setVisibility(8);
    Object localObject1 = localajxg.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
    paramViewGroup.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject1).uin;
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(bdbt.a(this.jdField_a_of_type_AndroidContentContext, (DiscussionInfo)localObject1));
    paramViewGroup.c.setImageBitmap(a(101, ((DiscussionInfo)localObject1).uin));
    if (!((DiscussionInfo)localObject1).hasRenamed())
    {
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(this.jdField_a_of_type_Almv.a(((DiscussionInfo)localObject1).uin)) }));
    }
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((DiscussionInfo)localObject1);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = null;
    paramViewGroup.jdField_a_of_type_Int = localajxg.jdField_a_of_type_Int;
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.g);
    paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxc
 * JD-Core Version:    0.7.0.1
 */