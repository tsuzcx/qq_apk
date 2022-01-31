import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment;
import com.tencent.qphone.base.util.QLog;

public class allg
  extends RelativeLayout
{
  int jdField_a_of_type_Int = 1;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int = 2;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  int c = 3;
  
  public allg(ApolloGameInfoFragment paramApolloGameInfoFragment, Context paramContext, String paramString)
  {
    super(paramContext);
    a(paramString);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_cmGame_ApolloGameInfoFragment", 2, new Object[] { "[setGameId] gameId:", Integer.valueOf(paramInt) });
    }
    if (paramInt > 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
    }
    setOnClickListener(new allj(this, paramString, paramInt));
  }
  
  public void a(Bitmap paramBitmap, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_cmGame_ApolloGameInfoFragment", 2, new Object[] { "[setPubAccountInfo] uin:", paramString });
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if (paramBitmap != null) {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageBitmap(paramBitmap);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      setOnClickListener(new alli(this));
      return;
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130838400);
      QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, "[setPubAccountInfo] logoUrl is null");
    }
  }
  
  public void a(String paramString)
  {
    int i = Color.parseColor("#FFDEDFE0");
    Object localObject = new ImageView(getContext());
    ((ImageView)localObject).setBackgroundColor(i);
    ((ImageView)localObject).setId(this.jdField_a_of_type_Int);
    addView((View)localObject, new RelativeLayout.LayoutParams(-1, 1));
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(18.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, this.jdField_a_of_type_Int);
    ((RelativeLayout.LayoutParams)localObject).addRule(9);
    ((RelativeLayout.LayoutParams)localObject).setMargins(aepi.a(12.0F, getResources()), aepi.a(17.0F, getResources()), 100, aepi.a(20.0F, getResources()));
    this.jdField_a_of_type_AndroidWidgetTextView.setId(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
    paramString = new ImageView(getContext());
    paramString.setBackgroundColor(i);
    localObject = new RelativeLayout.LayoutParams(-1, 1);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, this.jdField_b_of_type_Int);
    addView(paramString, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849050);
    paramString = new RelativeLayout.LayoutParams(aepi.a(9.0F, getResources()), aepi.a(18.0F, getResources()));
    paramString.addRule(11);
    paramString.addRule(15);
    paramString.rightMargin = aepi.a(27.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.setId(this.c);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, paramString);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-7829368);
    paramString = new RelativeLayout.LayoutParams(-2, -2);
    paramString.rightMargin = aepi.a(11.0F, getResources());
    paramString.addRule(11);
    paramString.rightMargin = aepi.a(27.0F, getResources());
    paramString.addRule(15);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    addView(this.jdField_b_of_type_AndroidWidgetTextView, paramString);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
    paramString = new RelativeLayout.LayoutParams(aepi.a(25.0F, getResources()), aepi.a(25.0F, getResources()));
    paramString.rightMargin = aepi.a(11.0F, getResources());
    paramString.addRule(0, this.c);
    paramString.addRule(15);
    setBackgroundResource(2130839179);
    addView(this.jdField_a_of_type_ComTencentImageURLImageView, paramString);
    setOnClickListener(new allh(this));
  }
  
  public void b(String paramString)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allg
 * JD-Core Version:    0.7.0.1
 */