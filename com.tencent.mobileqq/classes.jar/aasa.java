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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class aasa
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
  
  public aasa(Context paramContext, TroopGiftPanel paramTroopGiftPanel)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130849276);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = afur.a(9.0F, paramContext.getResources());
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
      localObject1 = new aasb();
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559941, null);
        if (getCount() < 5) {
          break label1627;
        }
        localObject2 = new RelativeLayout.LayoutParams(-2, -1);
        ((ViewGroup.LayoutParams)localObject2).width = (bclx.jdField_a_of_type_Int / 5 + 30);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((aasb)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367093));
        ((aasb)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367512));
        ((aasb)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367518));
        ((aasb)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367523));
        ((aasb)localObject1).g = ((TextView)paramView.findViewById(2131367094));
        ((aasb)localObject1).f = ((TextView)paramView.findViewById(2131378693));
        ((aasb)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367524));
        ((aasb)localObject1).d = ((TextView)paramView.findViewById(2131367515));
        ((aasb)localObject1).e = ((TextView)paramView.findViewById(2131367517));
        ((aasb)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363306);
        ((aasb)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367513));
        ((aasb)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367527));
        paramView.setTag(localObject1);
      }
    }
    for (;;)
    {
      localObject2 = (aasb)paramView.getTag();
      aasi localaasi = (aasi)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      ((aasb)localObject2).jdField_a_of_type_Aasi = localaasi;
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b())
      {
        ((aasb)localObject2).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((aasb)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(localaasi.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20) {
          ((aasb)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        }
        label337:
        if (((aasb)localObject2).jdField_c_of_type_AndroidWidgetImageView != null)
        {
          if ((localaasi.j != 1) || (TextUtils.isEmpty(localaasi.jdField_e_of_type_JavaLangString))) {
            break label788;
          }
          ((aasb)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = bdzx.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localObject1 = URLDrawable.getDrawable(localaasi.jdField_e_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
          ((aasb)localObject2).jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        }
        label415:
        if ((!localaasi.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c() <= 0)) {
          break label801;
        }
        ((aasb)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        ((aasb)localObject2).g.setVisibility(0);
        ((aasb)localObject2).g.setText("免费x" + this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c());
        label486:
        if (localaasi.jdField_b_of_type_Int != 0) {
          break label1360;
        }
        ((aasb)localObject2).e.setVisibility(0);
        label503:
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        if (!localaasi.jdField_a_of_type_Boolean) {
          break label1504;
        }
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() != 20) {
          break label1373;
        }
        ((aasb)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(4);
        ((aasb)localObject2).jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        ((aasb)localObject2).jdField_a_of_type_AndroidWidgetLinearLayout.post(new GridListAdapter.1(this, (aasb)localObject2));
        ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = bdzx.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject1 = URLDrawable.getDrawable(localaasi.jdField_b_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
        if (!localaasi.jdField_c_of_type_Boolean) {
          break label1601;
        }
        if (!localaasi.jdField_a_of_type_Boolean) {
          break label1575;
        }
        ((aasb)localObject2).d.setVisibility(0);
        ((aasb)localObject2).d.setText(anni.a(2131704127) + localaasi.i + anni.a(2131704129));
        label660:
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c()) {
          break label1588;
        }
        ((aasb)localObject2).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        label679:
        ((aasb)localObject2).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b()) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() != 20) || (TextUtils.isEmpty(localaasi.jdField_d_of_type_JavaLangString))) {
          break label1614;
        }
        ((aasb)localObject2).f.setVisibility(0);
        ((aasb)localObject2).f.setText(localaasi.jdField_d_of_type_JavaLangString);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560599, null);
        break;
        ((aasb)localObject2).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label337;
        label788:
        ((aasb)localObject2).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        break label415;
        label801:
        if (localaasi.jdField_d_of_type_Boolean)
        {
          if (((aasb)localObject2).g != null) {
            ((aasb)localObject2).g.setVisibility(8);
          }
          ((aasb)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          ((aasb)localObject2).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#bbbbbb"));
          localObject1 = (bfte)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.b.get(localaasi.jdField_a_of_type_Int);
          if (localObject1 == null)
          {
            localObject1 = anni.a(2131704130);
            ((aasb)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
            break label486;
          }
          localObject1 = "×" + ((bfte)localObject1).jdField_b_of_type_Int;
          ((aasb)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          break label486;
        }
        if (((aasb)localObject2).g != null) {
          ((aasb)localObject2).g.setVisibility(8);
        }
        ((aasb)localObject2).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.jdField_a_of_type_AndroidUtilSparseArray;
        int i;
        if (localaasi.jdField_e_of_type_Int != 0)
        {
          i = localaasi.jdField_e_of_type_Int;
          label992:
          localObject1 = (bftd)((SparseArray)localObject1).get(i);
          if ((localObject1 != null) && (((bftd)localObject1).jdField_b_of_type_Int + ((bftd)localObject1).c != 0)) {
            break label1245;
          }
          ((aasb)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(localaasi.f));
          if ((!localaasi.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.jdField_a_of_type_Aasm.jdField_d_of_type_JavaLangString))) {
            break label1198;
          }
          localObject1 = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.jdField_a_of_type_Aasm.jdField_d_of_type_JavaLangString;
          label1081:
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1207;
          }
        }
        label1198:
        label1207:
        for (localObject1 = URLDrawable.getDrawable((String)localObject1, URLDrawable.URLDrawableOptions.obtain());; localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
        {
          ((Drawable)localObject1).setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
          ((aasb)localObject2).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
          if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20) {
            ((aasb)localObject2).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(8);
          }
          if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() != 20) {
            break label1228;
          }
          if (!this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b()) {
            break label1216;
          }
          ((aasb)localObject2).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#c3c3c3"));
          break;
          i = localaasi.jdField_a_of_type_Int;
          break label992;
          localObject1 = this.jdField_a_of_type_JavaLangString;
          break label1081;
        }
        label1216:
        ((aasb)localObject2).jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        break label486;
        label1228:
        ((aasb)localObject2).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#bbbbbb"));
        break label486;
        label1245:
        ((aasb)localObject2).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#fe6387"));
        if (((bftd)localObject1).c > 0)
        {
          ((aasb)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(anni.a(2131704132) + ((bftd)localObject1).c + anni.a(2131704128));
          break label486;
        }
        if (((bftd)localObject1).jdField_b_of_type_Int <= 0) {
          break label486;
        }
        ((aasb)localObject2).jdField_b_of_type_AndroidWidgetTextView.setText(anni.a(2131704131) + ((bftd)localObject1).jdField_b_of_type_Int);
        break label486;
        label1360:
        ((aasb)localObject2).e.setVisibility(8);
        break label503;
        label1373:
        if (localaasi.jdField_d_of_type_Int < 0)
        {
          i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166213);
          ((aasb)localObject2).jdField_c_of_type_AndroidWidgetTextView.setText(localaasi.jdField_d_of_type_JavaLangString);
          ((aasb)localObject2).jdField_c_of_type_AndroidWidgetTextView.setTextColor(i);
        }
        for (;;)
        {
          ((aasb)localObject2).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          ((aasb)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((aasb)localObject2).jdField_a_of_type_AndroidViewView.post(new GridListAdapter.2(this, (aasb)localObject2, localaasi, i));
          break;
          i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166212);
          ((aasb)localObject2).jdField_c_of_type_AndroidWidgetTextView.setText(localaasi.jdField_d_of_type_JavaLangString);
          ((aasb)localObject2).jdField_c_of_type_AndroidWidgetTextView.setTextColor(i);
        }
        label1504:
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20) {
          ((aasb)localObject2).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
        }
        for (;;)
        {
          ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = false;
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = bdzx.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localObject1 = URLDrawable.getDrawable(localaasi.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject1);
          break;
          ((aasb)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(4);
          ((aasb)localObject2).jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        }
        label1575:
        ((aasb)localObject2).d.setVisibility(8);
        break label660;
        label1588:
        ((aasb)localObject2).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label679;
        label1601:
        ((aasb)localObject2).d.setVisibility(8);
        break label679;
        label1614:
        ((aasb)localObject2).f.setVisibility(8);
      }
      label1627:
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aasa
 * JD-Core Version:    0.7.0.1
 */