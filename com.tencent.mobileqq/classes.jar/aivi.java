import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ToastInfo;

public class aivi
  implements aiwf, View.OnClickListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private List<ImageView> jdField_a_of_type_JavaUtilList = new ArrayList();
  private oidb_cmd0xb36.ToastInfo jdField_a_of_type_TencentImOidbCmd0xb36Oidb_cmd0xb36$ToastInfo;
  
  public aivi(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    return 59;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560569, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramVarArgs.findViewById(2131378885));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramVarArgs.findViewById(2131368212));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add((ImageView)paramVarArgs.findViewById(2131363110));
    localArrayList.add((ImageView)paramVarArgs.findViewById(2131363112));
    localArrayList.add((ImageView)paramVarArgs.findViewById(2131363114));
    this.jdField_a_of_type_JavaUtilList = localArrayList;
    paramVarArgs.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = paramVarArgs;
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(aiwh paramaiwh)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    localTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), new aivj(this, localTroopManager, paramaiwh));
  }
  
  public void a(TroopManager paramTroopManager, aiwh paramaiwh, TroopMemberInfo paramTroopMemberInfo)
  {
    paramTroopManager = paramTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((paramTroopManager == null) || ((paramTroopMemberInfo != null) && ((paramTroopMemberInfo.level == 332) || (paramTroopMemberInfo.level == 333))))
    {
      if (paramaiwh.a() == 20) {
        paramaiwh.a();
      }
      this.jdField_a_of_type_TencentImOidbCmd0xb36Oidb_cmd0xb36$ToastInfo = null;
    }
    do
    {
      return;
      this.jdField_a_of_type_TencentImOidbCmd0xb36Oidb_cmd0xb36$ToastInfo = paramTroopManager;
    } while ((!paramaiwh.a(this, new Object[0])) || (this.jdField_a_of_type_AndroidViewView == null));
    if (this.jdField_a_of_type_TencentImOidbCmd0xb36Oidb_cmd0xb36$ToastInfo.type.has())
    {
      paramTroopManager = String.format(Locale.getDefault(), "https://pub.idqqimg.com/pc/misc/group_chain/aio_icon_%d.png", new Object[] { Integer.valueOf(this.jdField_a_of_type_TencentImOidbCmd0xb36Oidb_cmd0xb36$ToastInfo.type.get()) });
      paramaiwh = URLDrawable.URLDrawableOptions.obtain();
      paramaiwh.mRequestWidth = zft.b(this.jdField_a_of_type_AndroidAppActivity, 32.0F);
      paramaiwh.mRequestHeight = paramaiwh.mRequestWidth;
      paramTroopManager = URLDrawable.getDrawable(paramTroopManager, paramaiwh);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramTroopManager);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentImOidbCmd0xb36Oidb_cmd0xb36$ToastInfo.wording.get());
    paramTroopMemberInfo = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    List localList;
    int i;
    if (this.jdField_a_of_type_TencentImOidbCmd0xb36Oidb_cmd0xb36$ToastInfo.uins.has())
    {
      localList = this.jdField_a_of_type_TencentImOidbCmd0xb36Oidb_cmd0xb36$ToastInfo.uins.get();
      i = 0;
      if ((i < localList.size()) && (i < paramTroopMemberInfo.size())) {}
    }
    else
    {
      paramTroopManager = paramTroopMemberInfo.iterator();
    }
    while (paramTroopManager.hasNext())
    {
      paramaiwh = (ImageView)paramTroopManager.next();
      if (paramaiwh != null)
      {
        paramaiwh.setVisibility(8);
        continue;
        ImageView localImageView = (ImageView)paramTroopMemberInfo.get(i);
        localImageView.setVisibility(0);
        paramTroopManager = bhmq.b();
        paramaiwh = aoot.a(xiz.a(), 1, String.valueOf(localList.get(i)), 3, paramTroopManager, paramTroopManager);
        if (paramaiwh == null) {}
        for (;;)
        {
          localImageView.setImageDrawable(paramTroopManager);
          paramTroopMemberInfo.set(i, null);
          i += 1;
          break;
          paramTroopManager = paramaiwh;
        }
      }
    }
    if (this.jdField_a_of_type_TencentImOidbCmd0xb36Oidb_cmd0xb36$ToastInfo.type.get() != 1) {}
    for (paramTroopManager = "1";; paramTroopManager = "2")
    {
      paramaiwh = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      bhju.a("Grp_edu", "Grp_chain", "ChainBanner_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramTroopManager, "", String.valueOf(paramaiwh.dwGroupClassExt) });
      return;
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 20;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_TencentImOidbCmd0xb36Oidb_cmd0xb36$ToastInfo == null)
    {
      QLog.e(".troop.survey", 1, "toast info empty , click error!");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_TencentImOidbCmd0xb36Oidb_cmd0xb36$ToastInfo.link.get());
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject);
    if (this.jdField_a_of_type_TencentImOidbCmd0xb36Oidb_cmd0xb36$ToastInfo.type.get() != 1) {}
    for (localObject = "1";; localObject = "2")
    {
      TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      bhju.a("Grp_edu", "Grp_chain", "ChainBanner_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localObject, "", String.valueOf(localTroopInfo.dwGroupClassExt) });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivi
 * JD-Core Version:    0.7.0.1
 */