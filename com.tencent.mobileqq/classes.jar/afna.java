import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x935.oidb_0x935.NotifyInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class afna
  extends bfwn
{
  public int a;
  private afjl jdField_a_of_type_Afjl;
  protected afmm a;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new afnc(this);
  protected View a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bahv a;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  protected List<MessageRecord> a;
  public boolean a;
  private final int jdField_b_of_type_Int = 0;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new afnd(this);
  View jdField_b_of_type_AndroidViewView;
  protected List<RecommendTroopItem> b;
  public boolean b;
  private final int jdField_c_of_type_Int = 1;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new afne(this);
  public List<MessageRecord> c;
  protected boolean c;
  private final int d;
  public boolean d;
  private final int jdField_e_of_type_Int = 3;
  private boolean jdField_e_of_type_Boolean;
  private final int jdField_f_of_type_Int = 4;
  private boolean jdField_f_of_type_Boolean;
  private final int jdField_g_of_type_Int = 5;
  private boolean jdField_g_of_type_Boolean;
  private final int jdField_h_of_type_Int = 6;
  private boolean jdField_h_of_type_Boolean;
  
  public afna(QQAppInterface paramQQAppInterface, Context paramContext, afmm paramafmm, afjl paramafjl)
  {
    this.jdField_d_of_type_Int = 2;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Afmm = paramafmm;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Afjl = paramafjl;
  }
  
  private void a(RecommendTroopItem paramRecommendTroopItem)
  {
    if ((paramRecommendTroopItem == null) || (TextUtils.isEmpty(paramRecommendTroopItem.uin))) {
      QLog.e("TroopReportor.recommend", 1, "notify reportTroopExposure, troopUin == null or troopUin is empty!");
    }
    String str1;
    String str2;
    do
    {
      do
      {
        return;
        str1 = paramRecommendTroopItem.uin;
        str2 = paramRecommendTroopItem.name;
        paramRecommendTroopItem = paramRecommendTroopItem.recomAlgol;
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
      } while (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str1));
      this.jdField_a_of_type_JavaUtilHashMap.put(str1, paramRecommendTroopItem);
      bbbb.a("Grp_contacts_news", "notice", "recom_exp_grp", 0, 0, new String[] { str1, paramRecommendTroopItem });
    } while (!QLog.isColorLevel());
    QLog.d("TroopReportor.recommend", 2, String.format("notify reportTroopExposure, troopUin: %s, troopName: %s, recomAlgol:%s", new Object[] { str1, str2, paramRecommendTroopItem }));
  }
  
  private int c()
  {
    int i = 5;
    this.jdField_g_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    if (j == 0)
    {
      if (this.jdField_f_of_type_Boolean)
      {
        this.jdField_g_of_type_Boolean = true;
        this.jdField_e_of_type_Boolean = true;
        return 2;
      }
      this.jdField_g_of_type_Boolean = false;
      this.jdField_e_of_type_Boolean = false;
      return 1;
    }
    if (((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    if ((this.jdField_d_of_type_Boolean) && (j >= 5)) {}
    while (i < j)
    {
      this.jdField_e_of_type_Boolean = true;
      return i + 1;
      if (this.jdField_a_of_type_Int >= 5) {
        this.jdField_d_of_type_Boolean = true;
      } else if (j >= 3) {
        i = 3;
      } else {
        i = j;
      }
    }
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_g_of_type_Boolean = true;
      this.jdField_e_of_type_Boolean = true;
      return j + 1;
    }
    this.jdField_e_of_type_Boolean = false;
    return j;
  }
  
  public int a()
  {
    if (this.jdField_e_of_type_Boolean) {
      return c() - 1;
    }
    return c();
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof afmr)))
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559705, paramViewGroup, false);
      paramViewGroup = new afmr();
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372551));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372541));
      paramViewGroup.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372548));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372555));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372546));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372552));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372554));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131372547));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131372550));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramView.findViewById(2131377869));
      localObject = (Button)paramView.findViewById(2131377868);
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_b_of_type_Int = paramInt;
      if (paramInt >= this.jdField_a_of_type_Int) {
        break label234;
      }
      afjv.a(paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout, true);
      label201:
      localObject = a(paramInt);
      if ((localObject != null) && ((localObject instanceof MessageForSystemMsg))) {
        break label245;
      }
    }
    for (;;)
    {
      return paramView;
      paramViewGroup = (afmr)paramView.getTag();
      break;
      label234:
      afjv.a(paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout, false);
      break label201;
      label245:
      paramViewGroup.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)localObject).getSystemMsg();
      paramViewGroup.jdField_c_of_type_Long = ((MessageRecord)localObject).uniseq;
      if (localObject != null) {}
      for (int i = ((MessageForSystemMsg)localObject).getSystemMsg().msg_type.get(); i == 2; i = 2)
      {
        this.jdField_a_of_type_Afjl.a(paramViewGroup, paramInt);
        return paramView;
      }
    }
  }
  
  public MessageRecord a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void a(akfd paramakfd)
  {
    ArrayList localArrayList;
    int i;
    Object localObject;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramakfd != null))
    {
      localArrayList = new ArrayList(3);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        localObject = (MessageRecord)localIterator.next();
        if (i < 3) {
          break label70;
        }
      }
      if (paramakfd != null) {
        paramakfd.a(localArrayList);
      }
    }
    return;
    label70:
    if ((localObject instanceof MessageForSystemMsg))
    {
      localObject = ((MessageForSystemMsg)localObject).getSystemMsg();
      oidb_0x935.NotifyInfo localNotifyInfo = new oidb_0x935.NotifyInfo();
      localNotifyInfo.uint64_notify_gc.set(((structmsg.StructMsg)localObject).msg.group_code.get());
      localNotifyInfo.uint32_notify_type.set(((structmsg.StructMsg)localObject).msg.group_msg_type.get());
      localArrayList.add(localNotifyInfo);
      i += 1;
    }
    for (;;)
    {
      break;
    }
  }
  
  public void a(LinearLayout paramLinearLayout)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = actn.a(238.0F, (Resources)localObject);
    localURLDrawableOptions.mRequestHeight = actn.a(161.0F, (Resources)localObject);
    localURLDrawableOptions.mLoadingDrawable = aywk.a;
    localURLDrawableOptions.mFailedDrawable = aywk.a;
    localObject = URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/files/20180622/1bf451e30af44c7c8f49ef5dd5a25822.png", localURLDrawableOptions);
    ((ImageView)paramLinearLayout.findViewById(2131367459)).setImageDrawable((Drawable)localObject);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    RecommendTroopItem localRecommendTroopItem;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0)) {}
        localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      } while (!localIterator.hasNext());
      localRecommendTroopItem = (RecommendTroopItem)localIterator.next();
    } while (!paramString.equals(localRecommendTroopItem.uin));
    localRecommendTroopItem.hasRequestJoin = true;
    if (QLog.isColorLevel()) {
      QLog.d("NotifyAndRecAdapter", 2, "updateJoinStatus, troopUin: " + paramString);
    }
    notifyDataSetChanged();
  }
  
  public void a(List<MessageRecord> paramList)
  {
    if ((QLog.isColorLevel()) && (paramList != null)) {
      QLog.d("NotifyAndRecAdapter", 2, "noti size is " + paramList.size());
    }
    if ((paramList == null) || (this.jdField_a_of_type_JavaUtilList == null)) {}
    for (;;)
    {
      return;
      HashSet localHashSet = new HashSet();
      this.jdField_a_of_type_JavaUtilList.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord instanceof MessageForSystemMsg))
        {
          structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
          if ((localStructMsg != null) && (localStructMsg.msg_seq.has()) && (!localHashSet.contains(Long.valueOf(localStructMsg.msg_seq.get()))))
          {
            localHashSet.add(Long.valueOf(localStructMsg.msg_seq.get()));
            this.jdField_a_of_type_JavaUtilList.add(localMessageRecord);
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0);
  }
  
  public int b()
  {
    int j = this.jdField_b_of_type_JavaUtilList.size();
    int i = j;
    if (this.jdField_h_of_type_Boolean) {
      i = j + 1;
    }
    return i;
  }
  
  public void b()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, TroopActivity.class);
    localIntent.putExtra("_key_mode", 1);
    localIntent.putExtra("key_tab_mode", 2);
    localIntent.putExtra("show_mode", 1);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    bbbb.a("Grp_contacts_news", "notice", "verify_clk", 3, 0, new String[0]);
  }
  
  public void b(List<RecommendTroopItem> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NotifyAndRecAdapter", 2, "setRecData: " + paramList);
    }
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    int i = c();
    int j = b();
    if (QLog.isColorLevel()) {
      QLog.d("NotifyAndRecAdapter", 2, "total count is" + i + "," + j);
    }
    return i + j;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 3;
    }
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() == 0)) && (this.jdField_b_of_type_Boolean)) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      if (i != 0) {
        break label85;
      }
      if (paramInt == 0) {
        break;
      }
      if ((paramInt != c() - 1) || (!this.jdField_e_of_type_Boolean)) {
        break label85;
      }
      return 2;
    }
    label85:
    if (this.jdField_a_of_type_Boolean) {
      return 0;
    }
    i = c();
    if (paramInt == i) {
      return 6;
    }
    if ((paramInt == i - 1) && (this.jdField_e_of_type_Boolean)) {
      return 2;
    }
    if ((paramInt == i + 1) && (this.jdField_h_of_type_Boolean)) {
      return 4;
    }
    if (paramInt <= i - 1) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    RecommendTroopItem localRecommendTroopItem;
    if (i == 1)
    {
      paramInt = paramInt - c() - 1;
      paramViewGroup = paramView;
      if (paramInt >= 0)
      {
        if (paramInt >= this.jdField_b_of_type_JavaUtilList.size()) {
          paramViewGroup = paramView;
        }
      }
      else {
        return paramViewGroup;
      }
      localRecommendTroopItem = (RecommendTroopItem)this.jdField_b_of_type_JavaUtilList.get(paramInt);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface instanceof QQAppInterface))) {
        paramViewGroup = baxt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, localRecommendTroopItem.uin);
      }
    }
    for (;;)
    {
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if ((paramView.getTag() instanceof afdd)) {}
      }
      else
      {
        localView = afda.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_c_of_type_AndroidViewView$OnClickListener);
      }
      afda.a((afdd)localView.getTag(), localRecommendTroopItem, paramViewGroup);
      a(localRecommendTroopItem);
      return localView;
      if (this.jdField_a_of_type_Bahv != null)
      {
        paramViewGroup = this.jdField_a_of_type_Bahv.a(localRecommendTroopItem.uin, true);
        if (paramViewGroup != null)
        {
          paramViewGroup = new BitmapDrawable(paramViewGroup);
          continue;
          if (i == 0) {
            return a(paramInt, paramView, paramViewGroup);
          }
          if (i == 2)
          {
            localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562565, null);
            paramViewGroup = (TextView)localView.findViewById(2131375773);
            if (this.jdField_g_of_type_Boolean) {
              paramView = this.jdField_a_of_type_AndroidContentContext.getString(2131699611);
            }
            for (;;)
            {
              paramViewGroup.setText(paramView);
              localView.setOnClickListener(new afnb(this));
              paramViewGroup = localView;
              if (this.jdField_c_of_type_Boolean) {
                break;
              }
              bbbb.a("Grp_contacts_news", "notice", "verify_exp", 2, 0, new String[0]);
              this.jdField_c_of_type_Boolean = true;
              return localView;
              if (this.jdField_a_of_type_Int > c() - 2) {
                paramView = ajyc.a(2131707632) + this.jdField_a_of_type_Int + ajyc.a(2131707634);
              } else {
                paramView = ajyc.a(2131707631);
              }
            }
          }
          if (i == 4)
          {
            paramInt = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("nearby_troop_count", 0).getInt("troop_num", 0);
            this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560390, null);
            this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370702));
            this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370688);
            if (paramInt != 0)
            {
              paramView = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("nearby_troop_count", 0).getString("troop_wording", "");
              this.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
            }
            for (;;)
            {
              return this.jdField_a_of_type_AndroidViewView;
              this.jdField_b_of_type_AndroidViewView.setVisibility(8);
              this.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
            }
          }
          if (i == 5)
          {
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562566, null);
            ((TextView)paramView.findViewById(2131367471)).setText(ajyc.a(2131707630));
            ((LinearLayout)paramView.findViewById(2131370938)).setVisibility(8);
            return paramView;
          }
          if (i == 6)
          {
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562566, null);
            ((TextView)paramView.findViewById(2131367471)).setText(ajyc.a(2131707629));
            ((LinearLayout)paramView.findViewById(2131370938)).setVisibility(8);
            return paramView;
          }
          if (i == 3)
          {
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562566, null);
            paramViewGroup = (TextView)paramView.findViewById(2131367471);
            paramViewGroup.setText(ajyc.a(2131707633));
            paramViewGroup.setVisibility(8);
            paramViewGroup = (LinearLayout)paramView.findViewById(2131370938);
            paramViewGroup.setVisibility(0);
            a(paramViewGroup);
            return paramView;
          }
          return null;
        }
      }
      paramViewGroup = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afna
 * JD-Core Version:    0.7.0.1
 */