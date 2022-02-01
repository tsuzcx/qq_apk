import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive.RoomIcon;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLiveGoods;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class aahe
  extends RecyclerView.ViewHolder
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  TextView f;
  
  public aahe(aagu paramaagu, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370090));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370094));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)paramView.findViewById(2131370082));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setmRadius(ImmersiveUtils.a(8.0F), false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370101));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363005));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363670));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367625));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367626));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367624));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367627));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367628));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367629));
    this.jdField_d_of_type_AndroidWidgetImageView.setColorFilter(1291845632);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367630));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370099));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367934));
    this.f = ((TextView)paramView.findViewById(2131371823));
  }
  
  public String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = "";
    BigDecimal localBigDecimal = new BigDecimal(paramInt);
    if (paramInt >= 10000000)
    {
      localBigDecimal = localBigDecimal.divide(new BigDecimal(1000000));
      str = "万";
    }
    for (;;)
    {
      return new BigDecimal(localBigDecimal.toPlainString()).setScale(2, 1).stripTrailingZeros().toPlainString() + str;
      if (paramInt >= 10000000000L)
      {
        localBigDecimal = localBigDecimal.divide(new BigDecimal(10000000000L));
        str = "亿";
      }
      else
      {
        localBigDecimal = localBigDecimal.divide(new BigDecimal(100));
      }
    }
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    CertifiedAccountMeta.StLive localStLive = paramStFeed.live;
    Object localObject1 = localStLive.roomIcon.get().iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (CertifiedAccountMeta.StLive.RoomIcon)((Iterator)localObject1).next();
    } while (!"1:1".equals(((CertifiedAccountMeta.StLive.RoomIcon)localObject2).size.get()));
    for (localObject1 = ((CertifiedAccountMeta.StLive.RoomIcon)localObject2).url.get();; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = URLDrawable.getDrawable((String)localObject1, aagu.a(), aagu.a());
        this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageDrawable((Drawable)localObject1);
      }
      for (;;)
      {
        if (aagu.a(this.jdField_a_of_type_Aagu))
        {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setAlpha(0.7F);
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-16777216);
          this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-1);
          this.f.setTextColor(-6775116);
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(localStLive.roomTitle.get());
        this.jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(localStLive.anchorIcon.get()));
        this.f.setText(localStLive.anchorName.get());
        int i;
        label293:
        Object localObject3;
        if (TextUtils.isEmpty(localStLive.typeIcon.get()))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setText("人气" + localStLive.viewer.get() + "");
          localObject2 = localStLive.goodsInfo.get();
          if (((List)localObject2).isEmpty())
          {
            QLog.d("RelativeFeedsAdapter", 1, "current display has no goods message");
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          }
          i = 0;
          if (i >= ((List)localObject2).size()) {
            break label511;
          }
          localObject3 = (CertifiedAccountMeta.StLiveGoods)((List)localObject2).get(i);
          String str = ((CertifiedAccountMeta.StLiveGoods)localObject3).imgUrl.get();
          if (str != null) {
            localObject1 = URLDrawable.getDrawable(str);
          }
          if (i != 0) {
            break label456;
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(((CertifiedAccountMeta.StLiveGoods)localObject3).name.get());
          localObject3 = a(((CertifiedAccountMeta.StLiveGoods)localObject3).curPrice.get());
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
        label456:
        while (i != 1)
        {
          i += 1;
          break label293;
          localObject2 = localStLive.typeIcon.get();
          localObject3 = beyq.a;
          localObject2 = VasApngUtil.getApngURLDrawable((String)localObject2, new int[] { 2 }, (Drawable)localObject3, null, null);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          break;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(localStLive.totalGoods.get() + "\n好物");
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        label511:
        if ((paramStFeed.live != null) && (paramStFeed.live.roomId.has()))
        {
          if (aagu.a(this.jdField_a_of_type_Aagu) != 0) {
            break label622;
          }
          bmzn.a().a(paramStFeed.live.roomId.get() + "", "25", "qq_live", "tab_page", "subscribe", 101, 1, System.currentTimeMillis(), paramStFeed.live.roomId.get() + "");
        }
        label622:
        do
        {
          return;
          if (aagu.a(this.jdField_a_of_type_Aagu) == 1)
          {
            bmzn.a().a(paramStFeed.live.roomId.get() + "", "25", "qq_live", "find_page", "hot_push", 101, 1, System.currentTimeMillis(), paramStFeed.live.roomId.get() + "");
            return;
          }
        } while (aagu.a(this.jdField_a_of_type_Aagu) != 2);
        bmzn.a().a(paramStFeed.live.roomId.get() + "", "25", "qq_live", "shopcart_page", "hot_push", 101, 1, System.currentTimeMillis(), paramStFeed.live.roomId.get() + "");
        return;
        localObject1 = null;
      }
    }
  }
  
  public void a(aahe paramaahe, CertifiedAccountMeta.StFeed paramStFeed)
  {
    String.valueOf(paramStFeed.poster.id.get());
    this.itemView.setOnClickListener(new aahf(this, paramStFeed));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahe
 * JD-Core Version:    0.7.0.1
 */