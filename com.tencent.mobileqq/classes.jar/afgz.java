import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.URLThemeImageView;

public class afgz
{
  private afhb jdField_a_of_type_Afhb;
  private View jdField_a_of_type_AndroidViewView;
  private IntimateInfo.MemoryDayInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$MemoryDayInfo;
  
  public afgz(afgx paramafgx, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131559195, null);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(afhb paramafhb)
  {
    this.jdField_a_of_type_Afhb = paramafhb;
  }
  
  public void a(IntimateInfo.MemoryDayInfo paramMemoryDayInfo)
  {
    if (paramMemoryDayInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$MemoryDayInfo = paramMemoryDayInfo;
      if (this.jdField_a_of_type_AndroidViewView != null) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setTag(paramMemoryDayInfo);
    URLThemeImageView localURLThemeImageView = (URLThemeImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367819);
    TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380276);
    TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369500);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370160);
    Object localObject2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363028);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = 686;
    localURLDrawableOptions.mRequestHeight = 124;
    localURLDrawableOptions.mRetryCount = 3;
    localURLDrawableOptions.mPlayGifImage = true;
    Object localObject1 = this.jdField_a_of_type_Afgx.jdField_a_of_type_JavaLangString;
    if (localURLThemeImageView != null)
    {
      if (localURLThemeImageView.a != null) {
        localURLThemeImageView.a.a(bibv.c);
      }
      if (paramMemoryDayInfo.iconUrl != null) {
        localURLThemeImageView.setBackgroundURL(paramMemoryDayInfo.iconUrl);
      }
    }
    if ((localRelativeLayout != null) && (ThemeUtil.isNowThemeIsNight(null, false, null))) {
      localObject1 = this.jdField_a_of_type_Afgx.b;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (localObject2 != null)) {
        ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable((String)localObject1, localURLDrawableOptions));
      }
      for (;;)
      {
        if ((localTextView2 != null) && (paramMemoryDayInfo.wording != null))
        {
          localTextView2.setText(paramMemoryDayInfo.wording);
          localObject2 = "";
          localObject1 = localObject2;
          if (localTextView1 != null)
          {
            localObject1 = localObject2;
            if (paramMemoryDayInfo.linkWording != null) {
              localObject1 = paramMemoryDayInfo.linkWording;
            }
          }
          int i = aepi.a(95.0F, this.jdField_a_of_type_Afgx.jdField_a_of_type_AndroidContentContext.getResources());
          i = afgx.a(this.jdField_a_of_type_Afgx, (String)localObject1, 14.0F, i + 80);
          if (i > 200) {
            localTextView2.setMaxWidth(i);
          }
        }
        else
        {
          if ((localTextView1 == null) || (paramMemoryDayInfo.linkWording == null)) {
            break;
          }
          localTextView1.setText(paramMemoryDayInfo.linkWording);
          if (TextUtils.isEmpty(paramMemoryDayInfo.linkColor)) {}
        }
        try
        {
          localTextView1.setTextColor(Color.parseColor(paramMemoryDayInfo.linkColor));
          localTextView1.setOnClickListener(new afha(this));
          return;
          QLog.e("intimate_relationship", 2, " url is empty");
          continue;
          localTextView2.setMaxWidth(200);
        }
        catch (IllegalArgumentException paramMemoryDayInfo)
        {
          for (;;)
          {
            QLog.e("intimate_relationship", 2, " color parse err");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgz
 * JD-Core Version:    0.7.0.1
 */