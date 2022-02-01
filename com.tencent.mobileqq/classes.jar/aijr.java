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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class aijr
  implements ailp, View.OnClickListener
{
  private final int jdField_a_of_type_Int = 3;
  private ailr jdField_a_of_type_Ailr;
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
  
  public aijr(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ailr paramailr, Activity paramActivity)
  {
    this.jdField_a_of_type_JavaLangString = ("AVGameStatusTipsBar." + paramSessionInfo.curType + "." + paramSessionInfo.curFriendUin);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Ailr = paramailr;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private String a()
  {
    Object localObject = (nqg)aqxe.a().a(642);
    if (localObject == null) {
      return null;
    }
    localObject = ((nqg)localObject).a();
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
      localObject2 = bheg.a();
      localObject1 = FaceDrawable.getFaceDrawableFrom(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, ((Player)localObject1).uin, 3, (Drawable)localObject2, (Drawable)localObject2, 4);
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
    Object localObject = (ncz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if ((localObject == null) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return;
    }
    int i;
    int j;
    if (((ncz)localObject).a())
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
      bdla.b(null, "dc00898", "", "", paramString, paramString, i, 0, "" + j, "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, (String)localObject);
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
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296624);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131296623);
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidAppActivity.getSystemService("layout_inflater")).inflate(2131558725, null);
    this.jdField_a_of_type_AndroidViewView.setClickable(true);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363309));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aijs(this));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363308));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new aijt(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363310));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363306));
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    if ((localTroopInfo != null) && (localTroopInfo.isAdmin()))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).addRule(0, 2131363309);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getString(2131690478);
      return;
    }
    this.jdField_b_of_type_JavaLangString = a();
  }
  
  private void b(List<RoomInfo> paramList, int paramInt)
  {
    String str1;
    Object localObject;
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.length() > 0))
    {
      str1 = this.jdField_b_of_type_JavaLangString;
      String str2 = this.jdField_a_of_type_AndroidAppActivity.getString(2131690479);
      localObject = str2;
      if (paramList != null)
      {
        localObject = str2;
        if (paramList.size() > 0)
        {
          if (paramList.size() <= 1) {
            break label233;
          }
          if (paramInt <= paramList.size()) {
            break label223;
          }
          label74:
          localObject = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131690481), new Object[] { Integer.valueOf(paramInt) });
        }
      }
      label99:
      this.jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject + str1);
      localObject = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131363307);
      if (paramList == null) {
        break label319;
      }
    }
    label319:
    for (paramList = a(paramList);; paramList = null)
    {
      a((LinearLayout)localObject, paramList);
      if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839531);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130839521));
        return;
        str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131690478);
        break;
        label223:
        paramInt = paramList.size();
        break label74;
        label233:
        localObject = (RoomInfo)paramList.get(0);
        localObject = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131690480), new Object[] { Integer.valueOf(((RoomInfo)localObject).players.size()) });
        break label99;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-14737633);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130839522));
      return;
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() == 1))
    {
      localObject = (RoomInfo)this.jdField_a_of_type_JavaUtilList.get(0);
      ncz localncz = (ncz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
      if (localncz != null) {
        localncz.a(this.jdField_a_of_type_AndroidAppActivity, 3, String.valueOf(((RoomInfo)localObject).id), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
      }
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
    PublicFragmentActivity.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject, AVGameRoomListFragment.class);
  }
  
  private void d()
  {
    QQCustomDialog localQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setMessage(this.jdField_a_of_type_AndroidAppActivity.getString(2131690476)).setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131690485), new aijv(this)).setNegativeButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131690388), new aiju(this));
    localQQCustomDialog.show();
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
    if (this.jdField_a_of_type_Ailr.a() == this) {
      this.jdField_a_of_type_Ailr.a();
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
    if (this.jdField_a_of_type_Ailr.a() != this) {
      bool = this.jdField_a_of_type_Ailr.a(this, new Object[0]);
    }
    if ((bool) && (!this.jdField_a_of_type_Boolean))
    {
      ncz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
 * Qualified Name:     aijr
 * JD-Core Version:    0.7.0.1
 */