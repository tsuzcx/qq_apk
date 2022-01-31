import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.PersonalityLabel.GlowCountRecyclerView;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelInfo;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelZan;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class agsu
  extends BaseAdapter
  implements View.OnClickListener
{
  private agsu(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  private void a(agst paramagst, PersonalityLabelInfo paramPersonalityLabelInfo)
  {
    if (this.a.jdField_b_of_type_Boolean)
    {
      if (paramagst.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 8) {
        paramagst.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (paramagst.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        paramagst.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (paramagst.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 8) {
        paramagst.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (paramagst.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        paramagst.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      paramagst.jdField_b_of_type_AndroidViewView.setTag(paramPersonalityLabelInfo);
      paramagst.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      paramagst.jdField_b_of_type_AndroidViewView.setTag(2131370946, Integer.valueOf(4));
      paramagst.jdField_b_of_type_AndroidViewView.setTag(2131362745, paramagst);
      paramagst = paramagst.jdField_b_of_type_AndroidWidgetImageView;
      if (!this.a.jdField_b_of_type_Boolean) {
        break label384;
      }
    }
    label384:
    for (int i = 2130842983;; i = 2130842975)
    {
      paramagst.setImageResource(i);
      return;
      if (PersonalityLabelGalleryActivity.a(this.a))
      {
        if (paramagst.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          paramagst.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        if (paramagst.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 0) {
          paramagst.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        if (paramagst.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 8) {
          paramagst.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        if (paramagst.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 8) {
          paramagst.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        paramagst.jdField_b_of_type_AndroidViewView.setTag(paramPersonalityLabelInfo);
        paramagst.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
        paramagst.jdField_b_of_type_AndroidViewView.setTag(2131370946, Integer.valueOf(1));
        break;
      }
      if (paramagst.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 8) {
        paramagst.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (paramagst.jdField_b_of_type_AndroidWidgetImageView.getVisibility() != 8) {
        paramagst.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      if (paramagst.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 0) {
        paramagst.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if (paramagst.jdField_c_of_type_AndroidWidgetImageView.getVisibility() != 8) {
        paramagst.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramagst.jdField_b_of_type_AndroidViewView.setTag(paramPersonalityLabelInfo);
      paramagst.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      paramagst.jdField_b_of_type_AndroidViewView.setTag(2131370946, Integer.valueOf(3));
      break;
    }
  }
  
  private void b(PersonalityLabelInfo paramPersonalityLabelInfo)
  {
    Intent localIntent = new Intent(this.a, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", Math.min(9, Math.max(PersonalityLabelGalleryActivity.a(this.a).maxPhotoCount - paramPersonalityLabelInfo.photoCount, 0)));
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.a.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("label_id", paramPersonalityLabelInfo.id);
    this.a.startActivity(localIntent);
    AlbumUtil.a(this.a, false, true);
  }
  
  public void a(PersonalityLabelInfo paramPersonalityLabelInfo)
  {
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = this.a.app.getCurrentAccountUin();
    localUserInfo.b = this.a.app.getCurrentNickname();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_title", this.a.getString(2131432719));
    localBundle.putInt("key_personal_album_enter_model", 1);
    localBundle.putBoolean("key_multiple_model_need_download_img", true);
    localBundle.putInt("_input_max", Math.min(9, Math.max(PersonalityLabelGalleryActivity.a(this.a).maxPhotoCount - paramPersonalityLabelInfo.photoCount, 0)));
    localBundle.putBoolean("show_album", false);
    localBundle.putBoolean("key_need_change_to_jpg", true);
    QZoneHelper.a(this.a, localUserInfo, localBundle, 1);
  }
  
  void a(PersonalityLabelInfo paramPersonalityLabelInfo, agst paramagst)
  {
    String str = paramagst.jdField_b_of_type_AndroidWidgetTextView.getText().toString();
    if (paramPersonalityLabelInfo.praiseCount > 0L)
    {
      if (this.a.jdField_a_of_type_Int <= 0) {
        this.a.jdField_a_of_type_Int = ((int)(this.a.getResources().getDisplayMetrics().widthPixels - 95.0F * PersonalityLabelGalleryActivity.a(this.a)));
      }
      if (this.a.jdField_a_of_type_AndroidTextTextPaint == null) {
        this.a.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
      }
      this.a.jdField_a_of_type_AndroidTextTextPaint.setTextSize(PersonalityLabelGalleryActivity.a(this.a) * 14.0F);
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(paramPersonalityLabelInfo.praiseCount);
      localStringBuilder1.insert(0, "共").append("个赞");
      int j = (int)(this.a.jdField_a_of_type_AndroidTextTextPaint.measureText(localStringBuilder1.toString()) + 0.5F);
      StringBuilder localStringBuilder2 = new StringBuilder();
      int i = 0;
      if (i < paramPersonalityLabelInfo.zanUins.size())
      {
        localStringBuilder2.append(((PersonalityLabelZan)paramPersonalityLabelInfo.zanUins.get(i)).nick);
        if (i == paramPersonalityLabelInfo.zanUins.size() - 1) {
          localStringBuilder2.append("，");
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder2.append("、");
        }
      }
      paramPersonalityLabelInfo = TextUtils.ellipsize(localStringBuilder2.toString(), this.a.jdField_a_of_type_AndroidTextTextPaint, this.a.jdField_a_of_type_Int - j, TextUtils.TruncateAt.END).toString();
      paramPersonalityLabelInfo = paramPersonalityLabelInfo + localStringBuilder1.toString();
      if (!TextUtils.equals(paramPersonalityLabelInfo, str)) {
        paramagst.jdField_b_of_type_AndroidWidgetTextView.setText(paramPersonalityLabelInfo);
      }
      paramPersonalityLabelInfo = paramagst.jdField_b_of_type_AndroidWidgetTextView;
      if (!this.a.jdField_b_of_type_Boolean) {
        break label375;
      }
    }
    label375:
    for (float f = 0.5F;; f = 1.0F)
    {
      paramPersonalityLabelInfo.setAlpha(f);
      return;
      paramPersonalityLabelInfo = this.a.getResources().getString(2131439112);
      break;
    }
  }
  
  public int getCount()
  {
    if ((PersonalityLabelGalleryActivity.a(this.a) != null) && (PersonalityLabelGalleryActivity.a(this.a).personalityLabelInfos != null)) {
      return PersonalityLabelGalleryActivity.a(this.a).personalityLabelInfos.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((PersonalityLabelGalleryActivity.a(this.a) != null) && (PersonalityLabelGalleryActivity.a(this.a).personalityLabelInfos != null)) {
      return PersonalityLabelGalleryActivity.a(this.a).personalityLabelInfos.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 0;
    Object localObject1;
    Object localObject2;
    label435:
    boolean bool2;
    boolean bool1;
    if (paramView == null)
    {
      paramView = this.a.getLayoutInflater().inflate(2130970523, paramViewGroup, false);
      paramViewGroup = new agst(null);
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370951);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370941));
      paramViewGroup.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370945);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370946));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370947));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362745));
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370948));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView = ((GlowCountRecyclerView)paramView.findViewById(2131363013));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370950));
      paramViewGroup.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370539);
      paramViewGroup.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131362846);
      paramViewGroup.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      paramViewGroup.jdField_c_of_type_AndroidViewView.setTag(2131370946, Integer.valueOf(5));
      if (!PersonalityLabelGalleryActivity.a(this.a)) {
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setTextSizeDp(12);
      localObject1 = new agss(this.a, null);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject1);
      paramView.setTag(paramViewGroup);
      paramViewGroup.e = paramView;
      localObject1 = (PersonalityLabelInfo)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_Long = ((PersonalityLabelInfo)localObject1).id;
      localObject2 = (Integer)paramViewGroup.jdField_a_of_type_AndroidViewView.getTag(2131370941);
      if ((localObject2 == null) || (((Integer)localObject2).intValue() != ((PersonalityLabelInfo)localObject1).bgColor))
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(((PersonalityLabelInfo)localObject1).bgColor));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(((PersonalityLabelInfo)localObject1).bgColor);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setTag(2131370941, Integer.valueOf(((PersonalityLabelInfo)localObject1).bgColor));
      }
      if (!paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.getText().equals(((PersonalityLabelInfo)localObject1).text)) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((PersonalityLabelInfo)localObject1).text);
      }
      a(paramViewGroup, (PersonalityLabelInfo)localObject1);
      paramViewGroup.jdField_b_of_type_AndroidViewView.setTag(2131370950, paramViewGroup);
      if (!PersonalityLabelGalleryActivity.a(this.a))
      {
        if (((PersonalityLabelInfo)localObject1).praiseFlag <= 0) {
          break label820;
        }
        paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130843004);
      }
      if (PersonalityLabelGalleryActivity.a(this.a))
      {
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTag(localObject1);
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setTag(2131370946, Integer.valueOf(2));
      }
      a((PersonalityLabelInfo)localObject1, paramViewGroup);
      bool2 = this.a.a(paramInt, (PersonalityLabelInfo)localObject1);
      if ((paramInt == 0) && (bool2)) {
        this.a.d = true;
      }
      if (paramViewGroup.jdField_c_of_type_AndroidViewView.getVisibility() != 0) {
        break label833;
      }
      bool1 = true;
      label524:
      if (bool2 != bool1)
      {
        localObject2 = paramViewGroup.jdField_c_of_type_AndroidViewView;
        if (!bool2) {
          break label839;
        }
        paramInt = 0;
        label544:
        ((View)localObject2).setVisibility(paramInt);
      }
      localObject2 = new StaggeredGridLayoutManager(1, 0);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject2);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setAdapter(new agta(this.a, ((PersonalityLabelInfo)localObject1).id));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setText(((PersonalityLabelInfo)localObject1).photoCount + "张");
      this.a.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView);
      if ((((PersonalityLabelInfo)localObject1).personalityLabelPhotos == null) || (((PersonalityLabelInfo)localObject1).personalityLabelPhotos.size() <= 0)) {
        break label845;
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setOnScrollListener(new agsv(this, (PersonalityLabelInfo)localObject1));
      label684:
      localObject2 = paramViewGroup.jdField_d_of_type_AndroidViewView.getTag();
      if (localObject2 != null) {
        break label857;
      }
      bool1 = false;
      label701:
      bool2 = this.a.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(((PersonalityLabelInfo)localObject1).id));
      if (bool2 != bool1)
      {
        localObject1 = (FrameLayout.LayoutParams)paramViewGroup.jdField_d_of_type_AndroidViewView.getLayoutParams();
        if (!bool2) {
          break label870;
        }
      }
    }
    label820:
    label833:
    label839:
    label845:
    label857:
    label870:
    for (paramInt = i;; paramInt = -2)
    {
      ((FrameLayout.LayoutParams)localObject1).height = paramInt;
      paramViewGroup.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramViewGroup.jdField_d_of_type_AndroidViewView.setTag(Boolean.valueOf(bool2));
      if (this.a.jdField_a_of_type_JavaUtilHashSet.size() > 0) {
        this.a.jdField_b_of_type_AndroidOsHandler.post(new agsw(this));
      }
      return paramView;
      paramViewGroup = (agst)paramView.getTag();
      break;
      paramViewGroup.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130842992);
      break label435;
      bool1 = false;
      break label524;
      paramInt = 8;
      break label544;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelGlowCountRecyclerView.setVisibility(8);
      break label684;
      bool1 = ((Boolean)localObject2).booleanValue();
      break label701;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag(2131370946);
    int i;
    if ((localObject1 != null) && ((localObject1 instanceof Integer)))
    {
      i = ((Integer)localObject1).intValue();
      if (i != 1) {
        break label192;
      }
      if (this.a.c)
      {
        this.a.c = false;
        PersonalityLabelGalleryActivity.c(this.a);
        if (this.a.jdField_b_of_type_AndroidOsHandler.hasMessages(2)) {
          this.a.jdField_b_of_type_AndroidOsHandler.removeMessages(2);
        }
        this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
      localObject1 = (PersonalityLabelInfo)paramView.getTag();
      if (localObject1 != null)
      {
        paramView = ActionSheet.a(paramView.getContext());
        paramView.c("从手机相册选择");
        paramView.c("从空间相册选择");
        paramView.d("取消");
        paramView.a(new agsx(this, (PersonalityLabelInfo)localObject1, paramView));
        paramView.show();
        ReportController.b(this.a.app, "dc00898", "", "", "0X8007FD2", "0X8007FD2", 0, 0, "", "", "", "");
      }
    }
    label192:
    do
    {
      return;
      if (i != 2) {
        break;
      }
    } while (this.a.jdField_b_of_type_Boolean);
    paramView = (PersonalityLabelInfo)paramView.getTag();
    localObject1 = new Intent(this.a, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", "https://ti.qq.com/cgi-node/specialtag/labzan?_wv=1027&labelId=" + paramView.id);
    this.a.startActivity((Intent)localObject1);
    return;
    PersonalityLabelInfo localPersonalityLabelInfo;
    Object localObject2;
    if (i == 3)
    {
      localPersonalityLabelInfo = (PersonalityLabelInfo)paramView.getTag();
      if (localPersonalityLabelInfo.praiseFlag <= 0)
      {
        ((PersonalityLabelHandler)this.a.app.a(112)).b(PersonalityLabelGalleryActivity.a(this.a), localPersonalityLabelInfo.id);
        localPersonalityLabelInfo.praiseFlag = 1;
        localPersonalityLabelInfo.praiseCount += 1L;
        localObject2 = null;
        localObject1 = null;
        i = localPersonalityLabelInfo.zanUins.size();
        if (i > 0)
        {
          i -= 1;
          label362:
          localObject2 = localObject1;
          if (i >= 0)
          {
            if (((PersonalityLabelZan)localPersonalityLabelInfo.zanUins.get(i)).uin != Long.valueOf(this.a.getCurrentAccountUin()).longValue()) {
              break label836;
            }
            localObject1 = (PersonalityLabelZan)localPersonalityLabelInfo.zanUins.remove(i);
          }
        }
      }
    }
    label836:
    for (;;)
    {
      i -= 1;
      break label362;
      PersonalityLabelZan localPersonalityLabelZan = new PersonalityLabelZan();
      localPersonalityLabelZan.uin = Long.valueOf(this.a.getCurrentAccountUin()).longValue();
      if (localObject2 != null) {}
      for (localObject1 = ((PersonalityLabelZan)localObject2).nick;; localObject1 = ContactUtils.a(this.a.app, this.a.app.getCurrentAccountUin()))
      {
        localPersonalityLabelZan.nick = ((String)localObject1);
        localPersonalityLabelInfo.zanUins.add(0, localPersonalityLabelZan);
        a(localPersonalityLabelInfo, (agst)paramView.getTag(2131370950));
        ((ImageView)paramView.findViewById(2131370948)).setImageResource(2130843004);
        PersonalityLabelGalleryActivity.b(this.a, true);
        if (this.a.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
          this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        }
        paramView = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, PersonalityLabelGalleryActivity.a(this.a));
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 500L);
        ReportController.b(this.a.app, "dc00898", "", "", "0X8007FD0", "0X8007FD0", 0, 0, "", "", "", "");
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(this.a, "每个标签每天只能点一个赞哦。", 0);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.c()) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.b(this.a.getTitleBarHeight());
      return;
      if (i == 4)
      {
        localObject2 = (PersonalityLabelInfo)paramView.getTag();
        i = ((PersonalityLabelInfo)localObject2).photoCount;
        if (i > 0) {}
        for (localObject1 = String.format("确认删除标签 “%s”，其中包含%d张照片？", new Object[] { ((PersonalityLabelInfo)localObject2).text, Integer.valueOf(i) });; localObject1 = String.format("确认删除标签 “%s”？", new Object[] { ((PersonalityLabelInfo)localObject2).text }))
        {
          DialogUtil.a(this.a, (String)localObject1, 2131433029, 2131434755, new agsy(this, paramView, (PersonalityLabelInfo)localObject2), new agsz(this)).show();
          return;
        }
      }
      if (i != 5) {
        break;
      }
      PersonalityLabelGalleryActivity.c(this.a);
      paramView.setVisibility(8);
      this.a.c = false;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agsu
 * JD-Core Version:    0.7.0.1
 */