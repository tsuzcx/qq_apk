import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.ui.AVGameRoomListFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class aiul
  implements aiwf, View.OnClickListener
{
  private final int jdField_a_of_type_Int = 3;
  private aiwh jdField_a_of_type_Aiwh;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String jdField_a_of_type_JavaLangString;
  private List<RoomInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  
  public aiul(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, aiwh paramaiwh, Activity paramActivity)
  {
    this.jdField_a_of_type_JavaLangString = ("AVGameStatusTipsBar." + paramSessionInfo.jdField_a_of_type_Int + "." + paramSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Aiwh = paramaiwh;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private String a()
  {
    Object localObject = (nht)aran.a().a(642);
    if (localObject == null) {
      return null;
    }
    localObject = ((nht)localObject).a();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    return (String)((List)localObject).get(new Random().nextInt(((List)localObject).size()));
  }
  
  private List<Player> a(List<RoomInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      RoomInfo localRoomInfo;
      if (i < paramList.size())
      {
        localRoomInfo = (RoomInfo)paramList.get(i);
        int j = 3 - localArrayList.size();
        if (localRoomInfo.players.size() >= j) {
          localArrayList.addAll(localRoomInfo.getPlayers().subList(0, j));
        }
      }
      else
      {
        return localArrayList;
      }
      localArrayList.addAll(localRoomInfo.players);
      i += 1;
    }
  }
  
  private void a(LinearLayout paramLinearLayout, List<Player> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    paramLinearLayout.removeAllViews();
    int i = 0;
    label20:
    Object localObject1;
    Object localObject2;
    LinearLayout.LayoutParams localLayoutParams;
    if ((i < paramList.size()) && (i < 3))
    {
      localObject1 = (Player)paramList.get(i);
      localObject2 = bhmq.a();
      localObject1 = aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((Player)localObject1).uin, 3, (Drawable)localObject2, (Drawable)localObject2, 4);
      localObject2 = new ThemeImageView(this.jdField_a_of_type_AndroidAppActivity);
      localLayoutParams = new LinearLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
      if (i != 0) {
        break label152;
      }
    }
    label152:
    for (int j = 0;; j = this.jdField_c_of_type_Int)
    {
      localLayoutParams.leftMargin = j;
      ((ThemeImageView)localObject2).setLayoutParams(localLayoutParams);
      ((ThemeImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((ThemeImageView)localObject2).setBackgroundDrawable((Drawable)localObject1);
      paramLinearLayout.addView((View)localObject2);
      i += 1;
      break label20;
      break;
    }
  }
  
  private void a(String paramString)
  {
    Object localObject = (mxc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(373);
    if ((localObject == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    int i;
    int j;
    if (((mxc)localObject).a())
    {
      i = 1;
      if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label126;
      }
      j = 1;
      label65:
      if (this.jdField_b_of_type_JavaLangString != null) {
        break label131;
      }
    }
    label131:
    for (localObject = "";; localObject = this.jdField_b_of_type_JavaLangString)
    {
      bdll.b(null, "dc00898", "", "", paramString, paramString, i, 0, "" + j, "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject);
      return;
      i = 2;
      break;
      label126:
      j = 2;
      break label65;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      return;
    }
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296568);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296567);
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131558708, null);
    this.jdField_a_of_type_AndroidViewView.setClickable(true);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363215));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aium(this));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363214));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new aiun(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363216));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363212));
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localTroopInfo != null) && (localTroopInfo.isAdmin()))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(0, 2131363215);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131690366);
      return;
    }
    this.jdField_b_of_type_JavaLangString = a();
  }
  
  private void b(List<RoomInfo> paramList, int paramInt)
  {
    String str1;
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0))
    {
      str1 = this.jdField_b_of_type_JavaLangString;
      String str2 = this.jdField_a_of_type_AndroidAppActivity.getString(2131690367);
      localObject = str2;
      if (paramList != null)
      {
        localObject = str2;
        if (paramList.size() > 0)
        {
          if (paramList.size() <= 1) {
            break label225;
          }
          if (paramInt <= paramList.size()) {
            break label215;
          }
        }
      }
    }
    label74:
    for (Object localObject = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131690369), new Object[] { Integer.valueOf(paramInt) });; localObject = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131690368), new Object[] { Integer.valueOf(((RoomInfo)localObject).players.size()) }))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject + str1);
      a((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363213), a(paramList));
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        break label272;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839475);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130839465));
      return;
      str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131690366);
      break;
      label215:
      paramInt = paramList.size();
      break label74;
      label225:
      localObject = (RoomInfo)paramList.get(0);
    }
    label272:
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-14737633);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130839466));
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() == 1))
    {
      localObject = (RoomInfo)this.jdField_a_of_type_JavaUtilList.get(0);
      mxc localmxc = (mxc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(373);
      if (localmxc != null) {
        localmxc.a(this.jdField_a_of_type_AndroidAppActivity, 3, String.valueOf(((RoomInfo)localObject).id), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    PublicFragmentActivity.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject, AVGameRoomListFragment.class);
  }
  
  private void d()
  {
    bhpc localbhpc = bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    localbhpc.setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131690364)).setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131690373), new aiup(this)).setNegativeButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131690310), new aiuo(this));
    localbhpc.show();
  }
  
  public int a()
  {
    return 61;
  }
  
  public View a(Object... paramVarArgs)
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aiwh.a() == this) {
      this.jdField_a_of_type_Aiwh.a();
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(List<RoomInfo> paramList, int paramInt)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      b();
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    b(paramList, paramInt);
    if (this.jdField_a_of_type_Aiwh.a() != this) {
      bool = this.jdField_a_of_type_Aiwh.a(this, new Object[0]);
    }
    if ((bool) && (!this.jdField_a_of_type_Boolean))
    {
      mxc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Boolean = true;
    }
    if (bool) {
      a("0X800B354");
    }
  }
  
  public int[] a()
  {
    return new int[2];
  }
  
  public int b()
  {
    return 2002;
  }
  
  public void onClick(View paramView)
  {
    c();
    a("0X800B01A");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiul
 * JD-Core Version:    0.7.0.1
 */