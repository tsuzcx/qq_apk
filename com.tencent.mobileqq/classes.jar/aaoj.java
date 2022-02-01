import UserGrowth.stReportItem;
import WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageRsp;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.GetMineWSPersonalRequest;
import com.tencent.biz.videostory.widget.view.MineWSPanel.3;
import com.tencent.biz.videostory.widget.view.MineWSPanel.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.List;
import mqq.app.MobileQQ;

public class aaoj
  implements IEventReceiver
{
  private aalb jdField_a_of_type_Aalb;
  private aaoo jdField_a_of_type_Aaoo;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bacw jdField_a_of_type_Bacw;
  private GetMineWSPersonalRequest jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestGetMineWSPersonalRequest;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  
  public aaoj(bacw parambacw)
  {
    this.jdField_a_of_type_Bacw = parambacw;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = parambacw.a();
    this.jdField_a_of_type_Aalb = new aalb(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  @NonNull
  private WSDownloadParams a(int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 3;
    localWSDownloadParams.mLinkStrategyType = 0;
    localWSDownloadParams.mEventId = paramInt;
    stReportItem localstReportItem = vjx.a();
    localstReportItem.pagetype = 1;
    localstReportItem.optype = 115;
    localWSDownloadParams.mStReportItem = localstReportItem;
    return localWSDownloadParams;
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Bacw != null) && ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity)))
    {
      QLog.i("MineWSPanel", 2, "setWeiShiPanelState isShow:" + paramBoolean);
      this.jdField_a_of_type_Bacw.a(paramBoolean);
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      QLog.i("MineWSPanel", 2, "response is null");
      return;
    }
    ThreadManager.excute(new MineWSPanel.3(this, paramArrayOfByte), 32, null, true);
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {}
    label135:
    label142:
    label191:
    for (;;)
    {
      return;
      int i;
      if (this.jdField_a_of_type_Boolean)
      {
        i = 1;
        aanb.a("weishi_share_prof", "entry_clk", i, 0, new String[0]);
        boolean bool = zfn.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
        vit.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, bool, paramBoolean);
        if (bool) {
          break label142;
        }
        aanb.a("weishi_share_prof", "dl_clk", 0, 0, new String[0]);
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, anvx.a(2131706239), 0).a();
        if (!this.jdField_a_of_type_Boolean) {
          break label135;
        }
        i = 201;
        label96:
        WSDownloadParams localWSDownloadParams = a(i);
        vbq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localWSDownloadParams, false);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Aaoo == null) {
          break label191;
        }
        this.jdField_a_of_type_Aaoo.a();
        return;
        i = 2;
        break;
        i = 200;
        break label96;
        if ((this.jdField_a_of_type_Boolean) && (paramBoolean))
        {
          e();
          aanb.a("weishi_share_prof", "clk_ws", 1, 0, new String[0]);
        }
        else
        {
          d();
          aanb.a("weishi_share_prof", "clk_ws", 2, 0, new String[0]);
        }
      }
    }
  }
  
  private void d()
  {
    String str = "weishi://profile?person_id=";
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      str = "weishi://profile?person_id=" + this.jdField_b_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (str = str + "&logsour=2020020031";; str = str + "&logsour=2020020029")
    {
      vmr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "biz_src_jc_gxl", str);
      return;
    }
  }
  
  private void e()
  {
    vmr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "biz_src_jc_gxl", "weishi://camera?logsour=2020020030");
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a()
  {
    QLog.i("MineWSPanel", 2, "requestWeiShiFeedListDataFromServer mUin=" + this.jdField_a_of_type_JavaLangString);
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getApplication().getApplicationContext())) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestGetMineWSPersonalRequest = new GetMineWSPersonalRequest(this.jdField_a_of_type_JavaLangString + "", 1);
    VSNetworkHelper.getInstance().sendRequest(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentBizRichframeworkNetworkRequestGetMineWSPersonalRequest, new aaon(this));
  }
  
  public void a(WEISHI.stGetPersonalPageRsp paramstGetPersonalPageRsp, boolean paramBoolean)
  {
    if (paramstGetPersonalPageRsp == null) {
      QLog.i("MineWSPanel", 2, "rsp is null");
    }
    label211:
    for (;;)
    {
      return;
      int j = paramstGetPersonalPageRsp.feed_num.get();
      this.jdField_b_of_type_JavaLangString = paramstGetPersonalPageRsp.personid.get();
      QLog.i("MineWSPanel", 2, "[MineWSPanel.java][setData] feedNum:" + j + ", isFromDb:" + paramBoolean);
      int i;
      if (j > 0) {
        if (!paramBoolean)
        {
          if (this.jdField_a_of_type_Boolean)
          {
            i = 1;
            aanb.a("weishi_share_prof", "entry_exp", i, 0, new String[0]);
          }
        }
        else
        {
          a(true);
          if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(j + anvx.a(2131706240));
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null) {
          break label211;
        }
        paramstGetPersonalPageRsp = paramstGetPersonalPageRsp.feeds.get();
        if ((paramstGetPersonalPageRsp != null) && (paramstGetPersonalPageRsp.size() != 0)) {
          break label213;
        }
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
        return;
        i = 2;
        break;
        a(false);
        if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
          this.jdField_b_of_type_AndroidWidgetTextView.setText("");
        }
      }
    }
    label213:
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
    QLog.i("MineWSPanel", 2, "setData(),mIsCurrentUser=" + this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Aalb.a(paramstGetPersonalPageRsp, this.jdField_a_of_type_Boolean);
  }
  
  public void a(aaoo paramaaoo)
  {
    this.jdField_a_of_type_Aaoo = paramaaoo;
  }
  
  public void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131371142));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131368381);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371143));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371144));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131381558));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    localLinearLayoutManager.setRecycleChildrenOnDetach(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setHasFixedSize(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aalb);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371544));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new aaok(this));
    this.jdField_a_of_type_Aalb.a(new aaol(this));
    vit.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
    QLog.i("MineWSPanel", 2, "[MineWSPanel.java][initUI] mIsCurrentUser:" + this.jdField_a_of_type_Boolean + ", mUin:" + this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      QLog.i("MineWSPanel", 2, "mMineWeiShiIcon is null");
      return;
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130850297);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130845769);
  }
  
  public void c()
  {
    ThreadManager.excute(new MineWSPanel.4(this), 32, null, true);
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaoj
 * JD-Core Version:    0.7.0.1
 */