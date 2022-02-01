import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive.RoomIcon;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLiveGoods;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class aadb
  extends RecyclerView.ViewHolder
{
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  RoundImageView jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView;
  Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  TextView f;
  
  public aadb(aacp paramaacp, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370000));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367876));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371716));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView = ((RoundImageView)paramView.findViewById(2131369985));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370002));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370003);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370004));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379795));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131369987));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131369988));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369995));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367556));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367559));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367558));
    this.f = ((TextView)paramView.findViewById(2131367560));
    this.jdField_d_of_type_AndroidWidgetImageView.setColorFilter(1291845632);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setRadiusWithoutRight(ImmersiveUtils.a(12.0F));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367557));
  }
  
  public String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("¥");
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
    aacp.a(this.jdField_a_of_type_Aacp, this.itemView.getResources().getDisplayMetrics().widthPixels);
    aacp.b(this.jdField_a_of_type_Aacp, (int)(aacp.a(this.jdField_a_of_type_Aacp) * 0.5F));
    aacp.c(this.jdField_a_of_type_Aacp, (int)(aacp.a(this.jdField_a_of_type_Aacp) * 0.17F));
    CertifiedAccountMeta.StLive localStLive = paramStFeed.live;
    Object localObject1 = localStLive.roomIcon.get();
    Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).width = aacp.b(this.jdField_a_of_type_Aacp);
    ((RelativeLayout.LayoutParams)localObject2).height = aacp.b(this.jdField_a_of_type_Aacp);
    localObject2 = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).width = aacp.c(this.jdField_a_of_type_Aacp);
    ((RelativeLayout.LayoutParams)localObject2).height = aacp.c(this.jdField_a_of_type_Aacp);
    ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams()).width = aacp.c(this.jdField_a_of_type_Aacp);
    localObject2 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).width = aacp.c(this.jdField_a_of_type_Aacp);
    ((RelativeLayout.LayoutParams)localObject2).height = aacp.c(this.jdField_a_of_type_Aacp);
    localObject1 = ((List)localObject1).iterator();
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
        localObject1 = URLDrawable.getDrawable((String)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqWidgetRoundImageView.setImageDrawable((Drawable)localObject1);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(localStLive.anchorIcon.get()));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localStLive.roomTitle.get());
        this.jdField_b_of_type_AndroidWidgetTextView.setText(localStLive.anchorName.get());
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        this.f.setVisibility(8);
        localObject2 = localStLive.goodsInfo.get();
        int i = 0;
        if (i < ((List)localObject2).size())
        {
          Object localObject3 = (CertifiedAccountMeta.StLiveGoods)((List)localObject2).get(i);
          String str = ((CertifiedAccountMeta.StLiveGoods)localObject3).imgUrl.get();
          if (str != null) {
            localObject1 = URLDrawable.getDrawable(str);
          }
          if (i == 0)
          {
            this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
            localObject3 = a(((CertifiedAccountMeta.StLiveGoods)localObject3).curPrice.get());
            this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
            this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          while (i != 1)
          {
            i += 1;
            break;
          }
          this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          this.f.setText(localStLive.totalGoods.get() + "\n好物");
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
          this.f.setVisibility(0);
        }
        if ("0".equals(localStLive.marketStatus.get()))
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          localObject1 = bdzx.a;
          localObject1 = VasApngUtil.getApngURLDrawable("https://sola.gtimg.cn/aoi/sola/20200527141440_qPH5UYrwne.png", new int[] { 2 }, (Drawable)localObject1, null, null);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
          this.jdField_d_of_type_AndroidWidgetTextView.setText(localStLive.viewer.get() + "");
          if (paramStFeed.poster.has())
          {
            if (((CertifiedAccountMeta.StUser)paramStFeed.poster.get()).followState.get() != 1) {
              break label848;
            }
            this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          label697:
          if ((paramStFeed.live != null) && (paramStFeed.live.roomId.has()))
          {
            if (aacp.d(this.jdField_a_of_type_Aacp) != 0) {
              break label868;
            }
            blyl.a().a(paramStFeed.live.roomId.get() + "", "25", "qq_live", "tab_page", "subscribe", 101, 1, System.currentTimeMillis(), paramStFeed.live.roomId.get() + "");
          }
        }
        label848:
        label868:
        do
        {
          return;
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          localObject1 = bdzx.a;
          localObject1 = VasApngUtil.getApngURLDrawable("https://sola.gtimg.cn/aoi/sola/20200527141440_HYaMnOb55o.png", new int[] { 2 }, (Drawable)localObject1, null, null);
          break;
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
          break label697;
          if (aacp.d(this.jdField_a_of_type_Aacp) == 1)
          {
            blyl.a().a(paramStFeed.live.roomId.get() + "", "25", "qq_live", "find_page", "hot_push", 101, 1, System.currentTimeMillis(), paramStFeed.live.roomId.get() + "");
            return;
          }
        } while (aacp.d(this.jdField_a_of_type_Aacp) != 2);
        blyl.a().a(paramStFeed.live.roomId.get() + "", "25", "qq_live", "shopcart_page", "hot_push", 101, 1, System.currentTimeMillis(), paramStFeed.live.roomId.get() + "");
        return;
        localObject1 = null;
      }
    }
  }
  
  public void a(aadb paramaadb, CertifiedAccountMeta.StFeed paramStFeed)
  {
    String str = String.valueOf(paramStFeed.poster.id.get());
    this.itemView.setOnClickListener(new aadc(this, paramStFeed));
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new aadd(this, paramaadb, str));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aade(this, paramaadb, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadb
 * JD-Core Version:    0.7.0.1
 */