import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.troopgift.GridListAdapter.1;
import com.tencent.biz.troopgift.GridListAdapter.2;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class aaic
  extends BaseAdapter
{
  protected int a;
  public Context a;
  protected Drawable a;
  protected LayoutInflater a;
  protected TroopGiftPanel a;
  protected String a;
  protected ArrayList<Object> a;
  protected int b;
  
  public aaic(Context paramContext, TroopGiftPanel paramTroopGiftPanel)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130849298);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = AIOUtils.dp2px(9.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = paramTroopGiftPanel;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Object localObject1 = new Canvas(localBitmap);
      Object localObject2 = new Paint();
      ((Paint)localObject2).setColor(paramInt4);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setStrokeWidth(paramFloat2);
      ((Paint)localObject2).setAntiAlias(true);
      ((Canvas)localObject1).drawRoundRect(new RectF(paramFloat2 / 2.0F, paramFloat2 / 2.0F, paramInt1 - paramFloat2 / 2.0F, paramInt2 - paramFloat2 / 2.0F), paramInt3, paramInt3, (Paint)localObject2);
      localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject2 = new Canvas((Bitmap)localObject1);
      Paint localPaint = new Paint();
      ((Canvas)localObject2).drawARGB(0, 0, 0, 0);
      paramFloat1 = (paramInt1 - paramFloat1) / 2.0F;
      ((Canvas)localObject2).drawRect(paramFloat1, 0.0F, paramInt1 - paramFloat1, paramInt3, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
      ((Canvas)localObject2).drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
      localBitmap.recycle();
      return localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public void a(ArrayList<Object> paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("GridListAdapter setData items = ");
      if (paramArrayList != null) {
        break label51;
      }
    }
    label51:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramArrayList.size()))
    {
      QLog.d("zivonchen", 2, localObject);
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      return;
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = new aaid();
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559995, null);
        if (getCount() < 5) {
          break label1628;
        }
        localObject2 = new RelativeLayout.LayoutParams(-2, -1);
        ((ViewGroup.LayoutParams)localObject2).width = (ScreenUtil.SCREEN_WIDTH / 5 + 30);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((aaid)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367278));
        ((aaid)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367736));
        ((aaid)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367742));
        ((aaid)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367747));
        ((aaid)localObject1).g = ((TextView)paramView.findViewById(2131367279));
        ((aaid)localObject1).f = ((TextView)paramView.findViewById(2131378912));
        ((aaid)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367748));
        ((aaid)localObject1).d = ((TextView)paramView.findViewById(2131367739));
        ((aaid)localObject1).e = ((TextView)paramView.findViewById(2131367741));
        ((aaid)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363429);
        ((aaid)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367737));
        ((aaid)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367751));
        paramView.setTag(localObject1);
      }
    }
    for (;;)
    {
      localObject2 = (aaid)paramView.getTag();
      aaik localaaik = (aaik)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      ((aaid)localObject2).jdField_a_of_type_Aaik = localaaik;
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b())
      {
        ((aaid)localObject2).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((aaid)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(localaaik.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20) {
          ((aaid)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        }
        label338:
        if (((aaid)localObject2).jdField_c_of_type_AndroidWidgetImageView != null)
        {
          if ((localaaik.j != 1) || (TextUtils.isEmpty(localaaik.jdField_e_of_type_JavaLangString))) {
            break label789;
          }
          ((aaid)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
          localObject1 = URLDrawable.getDrawable(localaaik.jdField_e_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
          ((aaid)localObject2).jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        }
        label416:
        if ((!localaaik.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c() <= 0)) {
          break label802;
        }
        ((aaid)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        ((aaid)localObject2).g.setVisibility(0);
        ((aaid)localObject2).g.setText("免费x" + this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c());
        label487:
        if (localaaik.jdField_b_of_type_Int != 0) {
          break label1361;
        }
        ((aaid)localObject2).e.setVisibility(0);
        label504:
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        if (!localaaik.jdField_a_of_type_Boolean) {
          break label1505;
        }
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() != 20) {
          break label1374;
        }
        ((aaid)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(4);
        ((aaid)localObject2).jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        ((aaid)localObject2).jdField_a_of_type_AndroidWidgetLinearLayout.post(new GridListAdapter.1(this, (aaid)localObject2));
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        localObject1 = URLDrawable.getDrawable(localaaik.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
        if (!localaaik.jdField_c_of_type_Boolean) {
          break label1602;
        }
        if (!localaaik.jdField_a_of_type_Boolean) {
          break label1576;
        }
        ((aaid)localObject2).d.setVisibility(0);
        ((aaid)localObject2).d.setText(anvx.a(2131704814) + localaaik.i + anvx.a(2131704816));
        label661:
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c()) {
          break label1589;
        }
        ((aaid)localObject2).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        label680:
        ((aaid)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b()) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() != 20) || (TextUtils.isEmpty(localaaik.jdField_d_of_type_JavaLangString))) {
          break label1615;
        }
        ((aaid)localObject2).f.setVisibility(0);
        ((aaid)localObject2).f.setText(localaaik.jdField_d_of_type_JavaLangString);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560677, null);
        break;
        ((aaid)localObject2).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label338;
        label789:
        ((aaid)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        break label416;
        label802:
        if (localaaik.jdField_d_of_type_Boolean)
        {
          if (((aaid)localObject2).g != null) {
            ((aaid)localObject2).g.setVisibility(8);
          }
          ((aaid)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          ((aaid)localObject2).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#bbbbbb"));
          localObject1 = (bgkz)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.b.get(localaaik.jdField_a_of_type_Int);
          if (localObject1 == null)
          {
            localObject1 = anvx.a(2131704817);
            ((aaid)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
            break label487;
          }
          localObject1 = "×" + ((bgkz)localObject1).jdField_b_of_type_Int;
          ((aaid)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          break label487;
        }
        if (((aaid)localObject2).g != null) {
          ((aaid)localObject2).g.setVisibility(8);
        }
        ((aaid)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.jdField_a_of_type_AndroidUtilSparseArray;
        int i;
        if (localaaik.jdField_e_of_type_Int != 0)
        {
          i = localaaik.jdField_e_of_type_Int;
          label993:
          localObject1 = (bgky)((SparseArray)localObject1).get(i);
          if ((localObject1 != null) && (((bgky)localObject1).jdField_b_of_type_Int + ((bgky)localObject1).c != 0)) {
            break label1246;
          }
          ((aaid)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(localaaik.f));
          if ((!localaaik.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.jdField_a_of_type_Aaio.jdField_d_of_type_JavaLangString))) {
            break label1199;
          }
          localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.jdField_a_of_type_Aaio.jdField_d_of_type_JavaLangString;
          label1082:
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1208;
          }
        }
        label1199:
        label1208:
        for (localObject1 = URLDrawable.getDrawable((String)localObject1, URLDrawable.URLDrawableOptions.obtain());; localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
        {
          ((Drawable)localObject1).setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
          ((aaid)localObject2).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
          if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20) {
            ((aaid)localObject2).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(8);
          }
          if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() != 20) {
            break label1229;
          }
          if (!this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b()) {
            break label1217;
          }
          ((aaid)localObject2).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#c3c3c3"));
          break;
          i = localaaik.jdField_a_of_type_Int;
          break label993;
          localObject1 = this.jdField_a_of_type_JavaLangString;
          break label1082;
        }
        label1217:
        ((aaid)localObject2).jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        break label487;
        label1229:
        ((aaid)localObject2).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#bbbbbb"));
        break label487;
        label1246:
        ((aaid)localObject2).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#fe6387"));
        if (((bgky)localObject1).c > 0)
        {
          ((aaid)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131704819) + ((bgky)localObject1).c + anvx.a(2131704815));
          break label487;
        }
        if (((bgky)localObject1).jdField_b_of_type_Int <= 0) {
          break label487;
        }
        ((aaid)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131704818) + ((bgky)localObject1).jdField_b_of_type_Int);
        break label487;
        label1361:
        ((aaid)localObject2).e.setVisibility(8);
        break label504;
        label1374:
        if (localaaik.jdField_d_of_type_Int < 0)
        {
          i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166242);
          ((aaid)localObject2).jdField_c_of_type_AndroidWidgetTextView.setText(localaaik.jdField_d_of_type_JavaLangString);
          ((aaid)localObject2).jdField_c_of_type_AndroidWidgetTextView.setTextColor(i);
        }
        for (;;)
        {
          ((aaid)localObject2).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          ((aaid)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((aaid)localObject2).jdField_a_of_type_AndroidViewView.post(new GridListAdapter.2(this, (aaid)localObject2, localaaik, i));
          break;
          i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166241);
          ((aaid)localObject2).jdField_c_of_type_AndroidWidgetTextView.setText(localaaik.jdField_d_of_type_JavaLangString);
          ((aaid)localObject2).jdField_c_of_type_AndroidWidgetTextView.setTextColor(i);
        }
        label1505:
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20) {
          ((aaid)localObject2).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
        }
        for (;;)
        {
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
          localObject1 = URLDrawable.getDrawable(localaaik.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
          break;
          ((aaid)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(4);
          ((aaid)localObject2).jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        }
        label1576:
        ((aaid)localObject2).d.setVisibility(8);
        break label661;
        label1589:
        ((aaid)localObject2).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label680;
        label1602:
        ((aaid)localObject2).d.setVisibility(8);
        break label680;
        label1615:
        ((aaid)localObject2).f.setVisibility(8);
      }
      label1628:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaic
 * JD-Core Version:    0.7.0.1
 */