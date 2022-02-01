import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.intimate.TopAlignSuperscriptSpan;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemNewDnaView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.List;

public class agmt
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private List<agmf> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private agmt(IntimateContentItemNewDnaView paramIntimateContentItemNewDnaView) {}
  
  private SpannableString a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      SpannableString localSpannableString = new SpannableString(paramString);
      Object localObject = paramString.getBytes();
      byte[] arrayOfByte = new byte[paramInt2];
      System.arraycopy(localObject, paramInt1, arrayOfByte, 0, paramInt2);
      localObject = new String(arrayOfByte);
      paramInt1 = paramString.indexOf((String)localObject);
      paramInt2 = ((String)localObject).length() + paramInt1;
      int i = paramString.length() - paramInt2;
      localSpannableString.setSpan(new StyleSpan(0), 0, 0 + paramInt1, 33);
      localSpannableString.setSpan(new TopAlignSuperscriptSpan(0.4F), 0, 0 + paramInt1, 33);
      localSpannableString.setSpan(new AbsoluteSizeSpan(ViewUtils.dip2px(10.0F)), 0, paramInt1 + 0, 33);
      localSpannableString.setSpan(new StyleSpan(0), paramInt2, paramInt2 + i, 33);
      localSpannableString.setSpan(new TopAlignSuperscriptSpan(0.4F), paramInt2, paramInt2 + i, 33);
      localSpannableString.setSpan(new AbsoluteSizeSpan(ViewUtils.dip2px(10.0F)), paramInt2, paramInt2 + i, 33);
      return localSpannableString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IntimateContentItemNewDnaView", 2, "getSpecialContent fail:" + paramString.toString());
      }
    }
    return null;
  }
  
  private void a(int paramInt, agmv paramagmv)
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() == 1) || (this.jdField_a_of_type_JavaUtilList.size() == 2))
    {
      a(paramagmv, -7, 0, -7, -15);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() % 2 == 0)
    {
      if ((paramInt == 0) || (paramInt == 1))
      {
        a(paramagmv, -7, 0, -7, -22);
        return;
      }
      if ((paramInt == this.jdField_a_of_type_JavaUtilList.size() - 1) || (paramInt == this.jdField_a_of_type_JavaUtilList.size() - 2))
      {
        a(paramagmv, -7, -3, -7, -15);
        return;
      }
      a(paramagmv, -7, -3, -7, -22);
      return;
    }
    if ((paramInt == 0) || (paramInt == 1))
    {
      a(paramagmv, -7, 0, -7, -22);
      return;
    }
    if (paramInt == this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      a(paramagmv, -7, -3, -7, -15);
      return;
    }
    if (paramInt == this.jdField_a_of_type_JavaUtilList.size() - 2)
    {
      a(paramagmv, -7, -3, -7, -22);
      return;
    }
    a(paramagmv, -7, -3, -7, -22);
  }
  
  private void a(agmv paramagmv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramagmv.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.setMargins(ViewUtils.dpToPx(paramInt1), ViewUtils.dpToPx(paramInt2), ViewUtils.dpToPx(paramInt3), ViewUtils.dpToPx(paramInt4));
    paramagmv.itemView.setLayoutParams(localLayoutParams);
  }
  
  private void a(LinearLayout paramLinearLayout, ArrayList<agmg> paramArrayList)
  {
    if ((paramLinearLayout != null) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramLinearLayout.removeAllViews();
      int i = 0;
      while ((i < paramArrayList.size()) && (i < 2))
      {
        Object localObject = (agmg)paramArrayList.get(i);
        TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView.a);
        localTextView.setTextSize(1, 17.0F);
        localTextView.setSingleLine(true);
        localTextView.setEllipsize(TextUtils.TruncateAt.END);
        localTextView.setTextColor(ContextCompat.getColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView.a, 2131166808));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.setMargins(0, ViewUtils.dpToPx(2.0F), 0, 0);
        localTextView.setLayoutParams(localLayoutParams);
        localObject = a(((agmg)localObject).jdField_a_of_type_JavaLangString, ((agmg)localObject).jdField_a_of_type_Int, ((agmg)localObject).b);
        if (localObject != null) {
          localTextView.setText((CharSequence)localObject);
        }
        paramLinearLayout.addView(localTextView);
        i += 1;
      }
    }
  }
  
  public void a(List<agmf> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder = (agmv)paramViewHolder;
    Object localObject = (agmf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    bdla.b(null, "dc00898", "", "", "0X800B568", "0X800B568", ((agmf)localObject).jdField_a_of_type_Int, 0, "", "", "", "");
    paramViewHolder.itemView.setTag(localObject);
    if (!TextUtils.isEmpty(((agmf)localObject).jdField_a_of_type_JavaLangString)) {
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((agmf)localObject).jdField_a_of_type_JavaLangString);
    }
    if ((((agmf)localObject).jdField_a_of_type_JavaUtilArrayList != null) && (((agmf)localObject).jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      a(paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout, ((agmf)localObject).jdField_a_of_type_JavaUtilArrayList);
      paramViewHolder.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setCornerRadiusAndMode(ViewUtils.dpToPx(15.0F), 1);
      if (!IntimateContentItemNewDnaView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView)) {
        break label154;
      }
      paramViewHolder.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setVisibility(8);
    }
    for (;;)
    {
      a(paramInt, paramViewHolder);
      return;
      paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      break;
      label154:
      if (!TextUtils.isEmpty(((agmf)localObject).c))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = paramViewHolder.jdField_a_of_type_ComTencentWidgetRoundRectImageView.getWidth();
        localURLDrawableOptions.mRequestHeight = paramViewHolder.jdField_a_of_type_ComTencentWidgetRoundRectImageView.getHeight();
        localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
        localObject = URLDrawable.getDrawable(((agmf)localObject).c, localURLDrawableOptions);
        paramViewHolder.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setImageDrawable((Drawable)localObject);
        paramViewHolder.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setVisibility(0);
      }
      else
      {
        paramViewHolder.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setVisibility(8);
      }
    }
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new agmv(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateViewIntimateContentItemNewDnaView.a).inflate(2131559322, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmt
 * JD-Core Version:    0.7.0.1
 */