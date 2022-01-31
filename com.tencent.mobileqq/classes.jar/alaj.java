import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtCanvasFragment4CmGame;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.video.CmGameVideoViewController.5;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class alaj
  implements alao, Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  private alaf jdField_a_of_type_Alaf;
  private alap jdField_a_of_type_Alap;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhtd jdField_a_of_type_Bhtd = new bhtd(Looper.getMainLooper(), this);
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public alaj(RelativeLayout paramRelativeLayout, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameVideoViewController", 2, new Object[] { "[CmGameVideoViewController], isPortrait:", Boolean.valueOf(paramBoolean), ",gameId:", Integer.valueOf(paramInt) });
    }
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    a(paramBoolean);
    o();
  }
  
  private Activity a()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      Context localContext = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext();
      if ((localContext instanceof Activity)) {
        return (Activity)localContext;
      }
    }
    return null;
  }
  
  private ImageView a(int paramInt)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
    if (2 == paramInt) {
      localImageView.setImageDrawable(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext().getResources().getDrawable(2130838394));
    }
    do
    {
      return localImageView;
      if (1 == paramInt)
      {
        localImageView.setImageDrawable(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext().getResources().getDrawable(2130838388));
        return localImageView;
      }
    } while (3 != paramInt);
    localImageView.setImageDrawable(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext().getResources().getDrawable(2130838389));
    return localImageView;
  }
  
  private String a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("bt", String.valueOf(paramLong1));
      ((JSONObject)localObject).put("et", String.valueOf(paramLong2));
      ((JSONObject)localObject).put("bf", String.valueOf(paramLong3));
      ((JSONObject)localObject).put("ef", String.valueOf(paramLong4));
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameVideoViewController", 1, localThrowable, new Object[0]);
    }
    return "";
  }
  
  private void a(double paramDouble, LinearLayout paramLinearLayout)
  {
    int m = 0;
    if ((paramLinearLayout == null) || (paramDouble < 3.0D)) {
      return;
    }
    paramLinearLayout.removeAllViews();
    int n = (int)paramDouble;
    if (((paramDouble > 3.0D) && (paramDouble < 4.0D)) || ((paramDouble > 4.0D) && (paramDouble < 5.0D))) {}
    for (int i = 1;; i = 0)
    {
      int j = aepi.a(15.0F, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
      j = 0;
      if (j < n)
      {
        if (j == 0) {}
        for (localLayoutParams.leftMargin = 0;; localLayoutParams.leftMargin = aepi.a(3.0F, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources()))
        {
          paramLinearLayout.addView(a(1), localLayoutParams);
          j += 1;
          break;
        }
      }
      j = 0;
      int k;
      for (;;)
      {
        k = m;
        if (j >= i) {
          break;
        }
        paramLinearLayout.addView(a(2), localLayoutParams);
        j += 1;
      }
      while (k < 5 - n - i)
      {
        paramLinearLayout.addView(a(3), localLayoutParams);
        k += 1;
      }
      break;
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    ThreadManagerV2.excute(new CmGameVideoViewController.5(this, paramInt, paramLong), 128, null, true);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Alaf == null) {}
    while ((this.jdField_a_of_type_Alaf.jdField_a_of_type_Int != 585) && (this.jdField_a_of_type_Alaf.jdField_a_of_type_Int != 565)) {
      return false;
    }
    return true;
  }
  
  private void i()
  {
    this.jdField_c_of_type_Boolean = true;
    this.g = false;
    this.f = false;
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_d_of_type_Boolean) {}
    for (int i = 1;; i = 2)
    {
      a(6, i, true);
      n();
      b(true);
      return;
    }
  }
  
  private void j()
  {
    int n = 0;
    if (this.jdField_a_of_type_Alaf == null) {
      return;
    }
    int i;
    int m;
    int i1;
    Object localObject;
    int j;
    if ((this.jdField_b_of_type_Boolean) || (this.e))
    {
      i = 1;
      m = this.jdField_a_of_type_Alap.a();
      i1 = this.jdField_a_of_type_Alap.b();
      localObject = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      if (i == 0) {
        break label227;
      }
      j = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
      label78:
      if (i == 0) {
        break label244;
      }
    }
    label227:
    label244:
    for (int k = Math.max(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);; k = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels))
    {
      i1 = (int)(1.0F * j * i1 / m);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      m = n;
      if (i != 0)
      {
        m = n;
        if (!a()) {
          m = (int)(150.0F * k / 1334.0F);
        }
      }
      ((RelativeLayout.LayoutParams)localObject).height = i1;
      ((RelativeLayout.LayoutParams)localObject).width = j;
      ((RelativeLayout.LayoutParams)localObject).topMargin = m;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i1;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = j;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_Alaf.h, (URLDrawable.URLDrawableOptions)localObject));
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      i = 0;
      break;
      j = Math.max(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
      break label78;
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_Alap == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext().getResources().getDrawable(2130838375));
    }
    View localView;
    for (;;)
    {
      localView = this.jdField_a_of_type_Alap.a();
      if (localView != null) {
        break;
      }
      QLog.w("cmgame_process.CmGameVideoViewController", 1, "[setViewStatus], videoView is null.");
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext().getResources().getDrawable(2130838376));
    }
    try
    {
      Object localObject = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379651);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      ((RelativeLayout)localObject).addView(localView, localLayoutParams);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = 1;
      ((RelativeLayout.LayoutParams)localObject).width = 1;
      l();
      localView.setOnClickListener(new alan(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("cmgame_process.CmGameVideoViewController", 1, "fail to addview," + localThrowable);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Alaf == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label646;
        }
        Object localObject1 = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363378);
        localObject7 = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363379);
        ((RelativeLayout)localObject7).setOnClickListener(this);
        ((RelativeLayout)localObject1).setOnClickListener(this);
        if (this.jdField_a_of_type_Alaf.jdField_a_of_type_Int == 185)
        {
          ((RelativeLayout)localObject1).setVisibility(8);
          ((RelativeLayout)localObject7).setVisibility(0);
          localObject4 = (ImageView)((RelativeLayout)localObject7).findViewById(2131362033);
          localObject6 = (TextView)((RelativeLayout)localObject7).findViewById(2131362051);
          localObject3 = (TextView)((RelativeLayout)localObject7).findViewById(2131361972);
          localObject5 = (Button)((RelativeLayout)localObject7).findViewById(2131362060);
          localTextView = (TextView)((RelativeLayout)localObject7).findViewById(2131362043);
          localObject1 = (LinearLayout)((RelativeLayout)localObject7).findViewById(2131362045);
          if (localObject4 != null)
          {
            if (TextUtils.isEmpty(this.jdField_a_of_type_Alaf.f)) {
              break label852;
            }
            localObject7 = URLDrawable.URLDrawableOptions.obtain();
            localObject8 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources();
            ((URLDrawable.URLDrawableOptions)localObject7).mLoadingDrawable = ((Resources)localObject8).getDrawable(2130845085);
            ((URLDrawable.URLDrawableOptions)localObject7).mFailedDrawable = ((Resources)localObject8).getDrawable(2130845085);
            localObject7 = URLDrawable.getDrawable(this.jdField_a_of_type_Alaf.f, (URLDrawable.URLDrawableOptions)localObject7);
            ((URLDrawable)localObject7).setTag(bcyz.b(xsm.a(BaseApplicationImpl.getContext(), 200.0F), xsm.a(BaseApplicationImpl.getContext(), 200.0F), bdaq.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 12.0F)));
            ((URLDrawable)localObject7).setDecodeHandler(bcyz.c);
            ((ImageView)localObject4).setImageDrawable((Drawable)localObject7);
          }
          if (localObject6 != null) {
            ((TextView)localObject6).setText(this.jdField_a_of_type_Alaf.d);
          }
          if (localObject3 != null)
          {
            localObject6 = this.jdField_a_of_type_Alaf.e;
            localObject4 = localObject6;
            if (((String)localObject6).length() > 15)
            {
              localObject4 = ((String)localObject6).substring(0, 15);
              localObject4 = (String)localObject4 + "...";
            }
            ((TextView)localObject3).setText(alud.a(2131702533) + (String)localObject4);
          }
          if (localObject5 != null)
          {
            if ((this.jdField_a_of_type_Alaf.jdField_b_of_type_Int != 12) && (this.jdField_a_of_type_Alaf.jdField_b_of_type_Int != 19)) {
              break label862;
            }
            ((Button)localObject5).setText(alud.a(2131702531));
            ((Button)localObject5).setOnClickListener(this);
          }
          if (localTextView == null) {
            break;
          }
          this.jdField_a_of_type_Alaf.jdField_a_of_type_Double /= 2.0D;
          localObject3 = new StringBuilder(500);
          if ((Double.compare(this.jdField_a_of_type_Alaf.jdField_a_of_type_Double, 0.0D) != 0) && (this.jdField_a_of_type_Alaf.jdField_a_of_type_Double >= 3.0D)) {
            break label876;
          }
          ((StringBuilder)localObject3).append("精品推荐 ");
          if (localObject1 != null) {
            ((LinearLayout)localObject1).setVisibility(8);
          }
          if ((0L != this.jdField_a_of_type_Alaf.jdField_a_of_type_Long) && (this.jdField_a_of_type_Alaf.jdField_a_of_type_Long >= 100000L)) {
            break label931;
          }
          ((StringBuilder)localObject3).append("热门推荐 ");
          localTextView.setText(((StringBuilder)localObject3).toString());
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameVideoViewController", 1, localThrowable, new Object[0]);
        return;
      }
      localThrowable.setVisibility(0);
      ((RelativeLayout)localObject7).setVisibility(8);
      Object localObject4 = (ImageView)localThrowable.findViewById(2131362032);
      Object localObject6 = (TextView)localThrowable.findViewById(2131362050);
      Object localObject3 = (TextView)localThrowable.findViewById(2131361971);
      TextView localTextView = (TextView)localThrowable.findViewById(2131362042);
      Object localObject5 = (Button)localThrowable.findViewById(2131362058);
      Object localObject2 = (LinearLayout)localThrowable.findViewById(2131362044);
      continue;
      label646:
      Object localObject7 = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363378);
      Object localObject8 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject7).getLayoutParams();
      ((RelativeLayout)localObject7).setOnClickListener(this);
      localObject2 = (Button)((RelativeLayout)localObject7).findViewById(2131362061);
      localObject4 = (ImageView)((RelativeLayout)localObject7).findViewById(2131362032);
      localObject6 = (TextView)((RelativeLayout)localObject7).findViewById(2131362050);
      localObject3 = (TextView)((RelativeLayout)localObject7).findViewById(2131361971);
      localTextView = (TextView)((RelativeLayout)localObject7).findViewById(2131362042);
      localObject5 = (Button)((RelativeLayout)localObject7).findViewById(2131362058);
      localObject7 = (LinearLayout)((RelativeLayout)localObject7).findViewById(2131362044);
      if (a())
      {
        ((Button)localObject2).setVisibility(8);
        ((Button)localObject5).setVisibility(0);
        ((RelativeLayout.LayoutParams)localObject8).height = aepi.a(157.0F, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources());
        localObject2 = localObject5;
      }
      for (;;)
      {
        ((Button)localObject2).setOnClickListener(this);
        localObject5 = localObject2;
        localObject2 = localObject7;
        break;
        ((Button)localObject2).setVisibility(0);
        ((Button)localObject5).setVisibility(8);
        ((RelativeLayout.LayoutParams)localObject8).height = aepi.a(104.0F, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources());
      }
      label852:
      ((ImageView)localObject4).setImageResource(2130838400);
      continue;
      label862:
      ((Button)localObject5).setText(alud.a(2131702528));
      continue;
      label876:
      if (localObject2 != null) {
        ((LinearLayout)localObject2).setVisibility(0);
      }
      a(this.jdField_a_of_type_Alaf.jdField_a_of_type_Double, (LinearLayout)localObject2);
      ((StringBuilder)localObject3).append(new DecimalFormat("0.0").format(this.jdField_a_of_type_Alaf.jdField_a_of_type_Double)).append("分 ");
      continue;
      label931:
      if (this.jdField_a_of_type_Alaf.jdField_a_of_type_Long < 1000000L) {
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_Alaf.jdField_a_of_type_Long);
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_Alaf.jdField_b_of_type_Int != 12) && (this.jdField_a_of_type_Alaf.jdField_b_of_type_Int != 19)) {
          break label1082;
        }
        ((StringBuilder)localObject3).append("次下载");
        break;
        if (this.jdField_a_of_type_Alaf.jdField_a_of_type_Long < 100000000L) {
          ((StringBuilder)localObject3).append(new BigDecimal(this.jdField_a_of_type_Alaf.jdField_a_of_type_Long / 10000.0D).setScale(0, 4)).append("万");
        } else {
          ((StringBuilder)localObject3).append(new BigDecimal(this.jdField_a_of_type_Alaf.jdField_a_of_type_Long / 100000000.0D).setScale(0, 4)).append("亿");
        }
      }
      label1082:
      ((StringBuilder)localObject3).append("次浏览");
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_Boolean) {}
    Activity localActivity;
    do
    {
      do
      {
        return;
      } while ((!a()) || (this.jdField_b_of_type_Boolean));
      localActivity = a();
    } while (localActivity == null);
    this.e = true;
    this.jdField_d_of_type_Int = localActivity.getRequestedOrientation();
    localActivity.setRequestedOrientation(1);
  }
  
  private void n()
  {
    if ((a()) && (!this.jdField_b_of_type_Boolean))
    {
      Activity localActivity = a();
      if (localActivity != null)
      {
        this.e = false;
        localActivity.setRequestedOrientation(this.jdField_d_of_type_Int);
      }
    }
  }
  
  private void o()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver != null) {
        return;
      }
      QLog.i("cmgame_process.CmGameVideoViewController", 1, "registerReceiverForApp");
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameVideoViewController", 1, localThrowable, new Object[0]);
    }
  }
  
  private void p()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null) {
        return;
      }
      QLog.i("cmgame_process.CmGameVideoViewController", 1, "unregisterReceiverForApp");
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.unregister(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameVideoViewController", 1, localThrowable, new Object[0]);
    }
  }
  
  public GdtAppReceiver a()
  {
    return this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  }
  
  public GdtHandler.Params a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.jdField_c_of_type_Int = 7;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
    if (paramAdInfo != null) {
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramAdInfo);
    }
    localParams.jdField_a_of_type_Boolean = true;
    localParams.jdField_b_of_type_Boolean = true;
    localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(a());
    localParams.jdField_a_of_type_JavaLangClass = null;
    localParams.jdField_b_of_type_JavaLangClass = GdtCanvasFragment4CmGame.class;
    return localParams;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameVideoViewController", 2, "[onVideoPrepared]");
    }
    if (this.jdField_a_of_type_Alap == null) {}
    do
    {
      do
      {
        return;
        try
        {
          akwd.a().callbackFromRequest(this.jdField_a_of_type_Alaf.jdField_b_of_type_Long, 0, "cs.xy_life_cycle_event_disactivity.local", "{}");
          if (!this.g)
          {
            if (this.jdField_a_of_type_Bhtd != null) {
              this.jdField_a_of_type_Bhtd.obtainMessage(1).sendToTarget();
            }
            this.jdField_a_of_type_Alap.a();
            this.g = true;
            this.jdField_a_of_type_Alap.a(this.jdField_c_of_type_Boolean);
            this.jdField_b_of_type_Int = ((int)((float)this.jdField_a_of_type_Alap.a() / 1000.0F));
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("cmgame_process.CmGameVideoViewController", 1, localException, new Object[0]);
          }
        }
      } while (this.f);
      this.jdField_a_of_type_Alap.a();
    } while (this.jdField_a_of_type_Bhtd == null);
    this.jdField_a_of_type_Bhtd.obtainMessage(4).sendToTarget();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    QLog.w("cmgame_process.CmGameVideoViewController", 1, "[onVideoError], result:" + paramInt1 + ",code:" + paramInt2 + ",msg:" + paramString);
    a(0, 0, false);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Alaf == null) || (this.jdField_a_of_type_Alap == null)) {}
    while ((this.jdField_a_of_type_Boolean) && (!paramBoolean)) {
      return;
    }
    VipUtils.a(null, "cmshow", "Apollo", "video_SPA", this.jdField_a_of_type_Alaf.jdField_c_of_type_Int, paramInt1, new String[] { Integer.toString(this.jdField_c_of_type_Int), Long.toString(this.jdField_b_of_type_Int), Integer.toString(paramInt2), Integer.toString(this.jdField_a_of_type_Alaf.jdField_a_of_type_Int) });
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    label284:
    for (;;)
    {
      return;
      paramLong1 /= 1000L;
      paramLong2 /= 1000L;
      if (paramLong1 == paramLong2)
      {
        a(1, 0L);
        a(1, 0, false);
        if (paramLong1 == (1L + paramLong2) / 2L)
        {
          a(4, 1000L * paramLong1);
          a(1, 50, false);
        }
        if (paramLong2 <= 15L) {
          break label245;
        }
        long l = 15L - (paramLong2 - paramLong1);
        if (l <= 0L) {
          break label233;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131702527) + l);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        if (paramLong1 != paramLong2 - 15L) {
          break label284;
        }
        this.jdField_d_of_type_Boolean = true;
        akwd.a().callbackFromRequest(this.jdField_a_of_type_Alaf.jdField_b_of_type_Long, 0, "sc.game_ad_video_end.local", "{}");
        return;
        if (paramLong1 == paramLong2 - 1L)
        {
          a(2, 0L);
          a(1, 1, false);
          break;
        }
        if (paramLong1 == paramLong2 - 2L)
        {
          a(1, 2, false);
          break;
        }
        if (paramLong1 != paramLong2 - 15L) {
          break;
        }
        a(1, 15, false);
        break;
        label233:
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        continue;
        label245:
        this.jdField_b_of_type_AndroidWidgetTextView.setText(alud.a(2131702534) + paramLong1);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
  }
  
  public void a(alaf paramalaf)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1500L) {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameVideoViewController", 2, "click too quick, not play");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (paramalaf == null)
      {
        QLog.w("cmgame_process.CmGameVideoViewController", 1, "[playVideo], fail to play ads video.");
        return;
      }
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Alaf = paramalaf;
    } while (this.jdField_a_of_type_Bhtd == null);
    this.jdField_a_of_type_Bhtd.obtainMessage(0).sendToTarget();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameVideoViewController", 2, "[adsJumping]");
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      GdtHandler.a(a((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(aasd.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramString)))));
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameVideoViewController", 1, paramString, new Object[0]);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
          return;
        }
        this.jdField_b_of_type_Boolean = paramBoolean;
        LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_b_of_type_AndroidWidgetRelativeLayout.getContext());
        if (paramBoolean)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localLayoutInflater.inflate(2131558634, null));
          this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364332));
          this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362141));
          this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362881));
          this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131372074));
          this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362040));
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379726));
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new alak(this));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameVideoViewController", 1, localThrowable, new Object[0]);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localThrowable.inflate(2131558633, null));
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bhtd != null) {
      this.jdField_a_of_type_Bhtd.obtainMessage(2).sendToTarget();
    }
    if (this.jdField_a_of_type_Alap == null) {
      return;
    }
    this.jdField_a_of_type_Alap.b(this);
    if (!this.jdField_a_of_type_Boolean)
    {
      a(8, this.jdField_a_of_type_Alap.a());
      a(1, 100, false);
    }
    if (!this.jdField_d_of_type_Boolean) {
      akwd.a().callbackFromRequest(this.jdField_a_of_type_Alaf.jdField_b_of_type_Long, 0, "sc.game_ad_video_end.local", "{}");
    }
    this.g = false;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void b(boolean paramBoolean)
  {
    QLog.i("cmgame_process.CmGameVideoViewController", 1, "[closeVideoView], isByUser:" + paramBoolean);
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_Alap == null) || (this.jdField_a_of_type_Alaf == null)) {}
    RelativeLayout localRelativeLayout;
    View localView;
    do
    {
      return;
      localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379651);
      localView = this.jdField_a_of_type_Alap.a();
    } while (localView == null);
    if (paramBoolean) {}
    try
    {
      akwd.a().callbackFromRequest(this.jdField_a_of_type_Alaf.jdField_b_of_type_Long, 0, "sc.game_ad_video_view_close.local", "{}");
      label100:
      this.jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      localRelativeLayout.removeView(localView);
      this.jdField_a_of_type_Alap.b();
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_Alap = null;
      try
      {
        akwd.a().callbackFromRequest(this.jdField_a_of_type_Alaf.jdField_b_of_type_Long, 0, "cs.xy_life_cycle_event_activity.local", "{}");
        return;
      }
      catch (Exception localException)
      {
        QLog.e("cmgame_process.CmGameVideoViewController", 1, localException, new Object[0]);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label100;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameVideoViewController", 2, "[onVideoBufferStart]");
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameVideoViewController", 2, "[onVideoBufferEnd]");
    }
    if (this.jdField_a_of_type_Bhtd != null) {
      this.jdField_a_of_type_Bhtd.obtainMessage(4).sendToTarget();
    }
  }
  
  public void e()
  {
    QLog.i("cmgame_process.CmGameVideoViewController", 1, "[createVideoPlayer]");
    this.jdField_a_of_type_Alap = new alag();
    this.jdField_a_of_type_Alap.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), akwd.a());
    this.jdField_a_of_type_Alap.a(this);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Alap != null)
    {
      if (this.jdField_a_of_type_Alap.c() != 5) {
        this.jdField_a_of_type_Alap.b();
      }
      if (this.jdField_a_of_type_Bhtd != null) {
        this.jdField_a_of_type_Bhtd.obtainMessage(3).sendToTarget();
      }
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Alap != null) && (!this.f) && (this.jdField_a_of_type_Bhtd != null) && (this.jdField_a_of_type_Alap.c() != 5)) {
      this.jdField_a_of_type_Alap.a();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Alap != null) {
      this.jdField_a_of_type_Alap.b();
    }
    p();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return false;
        } while (this.jdField_a_of_type_Alaf == null);
        b(false);
        m();
        e();
        k();
        if (this.jdField_a_of_type_Alap != null) {
          this.jdField_a_of_type_Alap.a(this.jdField_a_of_type_Alaf.j, "sd", 0);
        }
        akwd.a().callbackFromRequest(this.jdField_a_of_type_Alaf.jdField_b_of_type_Long, 0, "sc.game_ad_video_start.local", "{}");
        return false;
      } while ((this.jdField_a_of_type_Alap == null) || (this.jdField_a_of_type_Alap.a() == null));
      j();
      return false;
    case 2: 
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      return false;
    case 3: 
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      return false;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131364332: 
      if (this.jdField_d_of_type_Boolean)
      {
        i();
        return;
      }
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_Alap != null)
          {
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            this.f = true;
            this.jdField_a_of_type_Alap.b();
          }
          Context localContext = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext();
          if (this.jdField_b_of_type_Int > 15)
          {
            paramView = "观看至少15秒视频才可获得有效奖励哦";
            bdgm.a(localContext, 0, null, paramView, alud.a(2131702530), alud.a(2131702529), new alal(this), new alam(this)).show();
            return;
          }
        }
        catch (Throwable paramView)
        {
          QLog.e("cmgame_process.CmGameVideoViewController", 1, "show dialog err, errInfo->" + paramView.getMessage());
          return;
        }
        paramView = alud.a(2131702532);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameVideoViewController", 2, "[click ad btn]");
    }
    a(this.jdField_a_of_type_Alaf.i);
    a(3, 0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alaj
 * JD-Core Version:    0.7.0.1
 */