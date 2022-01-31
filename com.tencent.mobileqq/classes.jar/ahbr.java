import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ahbr
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public int a;
  public View a;
  public String a;
  public List<ahbw> a;
  public boolean a;
  public List<ahbw> b = new ArrayList();
  
  public ahbr(ZhituPanelView paramZhituPanelView)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    int i = 0;
    while (i < ZhituPanelView.jdField_a_of_type_Int)
    {
      this.b.add(new ahbw());
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(this.b);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(ZhituPanelView.b(), 2, "loadMorePic");
    }
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if ((i == 0) || (TextUtils.isEmpty(((ahbw)this.jdField_a_of_type_JavaUtilList.get(i - 1)).jdField_d_of_type_JavaLangString))) {}
    while (i <= this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = i;
    ahbf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).a(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(int paramInt, String paramString)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("ZhituManager", 2, "ZhituPicAdapter setPicItemCount: picCount = " + paramInt + ",mReqKey = " + paramString + ",this.mReqKey =" + this.jdField_a_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramInt > 0)
    {
      if (!paramString.equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "dc00898", "", "", "0X8008C71", "0X8008C71", ahbf.a(ahbf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).a()), 0, "", "", "", "");
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      while (i < paramInt)
      {
        this.jdField_a_of_type_JavaUtilList.add(new ahbw());
        i += 1;
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Boolean = true;
      notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void a(ahbw paramahbw)
  {
    int i;
    ahbw localahbw;
    if (paramahbw != null)
    {
      i = paramahbw.jdField_a_of_type_Int;
      if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()))
      {
        localahbw = (ahbw)this.jdField_a_of_type_JavaUtilList.get(i);
        localahbw.a(paramahbw);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a() != 1) {
          break label98;
        }
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a() != 1) && (i == 0))
      {
        ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).setEnabled(true);
        ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).setVisibility(0);
      }
      return;
      label98:
      if (localahbw.jdField_d_of_type_Boolean)
      {
        if ((ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView) != null) && (ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView) != localahbw)) {
          ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).jdField_d_of_type_Boolean = false;
        }
        ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, localahbw);
      }
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    notifyItemInserted(0);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ZhituPanelView.b(), 2, "[ZhituPicAdapter]-setEmptyAndShowMsg, errorMsg is " + paramString);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380399);
      if (localTextView != null)
      {
        this.jdField_a_of_type_Boolean = false;
        localTextView.setVisibility(0);
        localTextView.setText(paramString);
        paramString = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        paramString.height = -1;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramString);
      }
    }
    notifyDataSetChanged();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(ZhituPanelView.b(), 2, "[ZhituPicAdapter]-resetData");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      Object localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380399);
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(8);
        localObject = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = -2;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    this.jdField_a_of_type_JavaUtilList.addAll(this.b);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = -1;
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int j = 0;; j = this.jdField_a_of_type_JavaUtilList.size())
    {
      int i = j;
      if (this.jdField_a_of_type_Boolean) {
        i = j + 1;
      }
      j = i;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        j = i + 1;
      }
      return j;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == 0)) {
      return 3;
    }
    if ((this.jdField_a_of_type_Boolean) && (paramInt + 1 == getItemCount())) {
      return 2;
    }
    return 1;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new ahbs(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (getItemViewType(paramInt) == 3) {
      break label9;
    }
    label9:
    while (!(paramViewHolder instanceof ahbt)) {
      return;
    }
    label24:
    ahbt localahbt;
    ahbw localahbw;
    Object localObject;
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      localahbt = (ahbt)paramViewHolder;
      localahbw = (ahbw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localahbt.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localahbw);
      localahbt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      localahbt.jdField_a_of_type_AndroidWidgetRadioButton.setChecked(localahbw.jdField_d_of_type_Boolean);
      if (!localahbw.jdField_a_of_type_Boolean) {
        break label667;
      }
      localObject = ahbf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).b(localahbw);
      paramViewHolder = ahbf.a((String)localObject);
      localViewHolder = paramViewHolder;
      if (paramViewHolder == null)
      {
        ahbf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).c(localahbw);
        localViewHolder = paramViewHolder;
        if (QLog.isColorLevel()) {
          QLog.d(ZhituPanelView.b(), 2, "get gif image from cache fail, " + (String)localObject);
        }
      }
    }
    label661:
    label664:
    label667:
    for (RecyclerView.ViewHolder localViewHolder = paramViewHolder;; localViewHolder = null)
    {
      localahbt.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a() == 1) {
        if ((localahbw.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (localViewHolder != null))
        {
          QLog.d(ZhituPanelView.b(), 2, "ZhituTest has a drawable data is " + localahbw.toString());
          paramViewHolder = localahbw.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localahbt.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(localahbw.jdField_a_of_type_JavaLangString + localahbw.jdField_e_of_type_JavaLangString);
          if (localViewHolder == null) {
            break label664;
          }
          paramViewHolder = new GifDrawable(localViewHolder);
        }
      }
      for (;;)
      {
        localahbt.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramViewHolder);
        localahbt.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setBackgroundDrawable(null);
        localahbt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        for (;;)
        {
          localahbt.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView);
          if ((localahbw.jdField_a_of_type_Ahbx == null) || (localahbw.jdField_a_of_type_Ahbx.jdField_a_of_type_Boolean)) {
            break;
          }
          ahbf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).b(localahbw);
          localahbw.jdField_a_of_type_Ahbx.jdField_a_of_type_Boolean = true;
          return;
          paramInt -= 1;
          break label24;
          QLog.d(ZhituPanelView.b(), 2, "ZhituTest has no drawable data is " + localahbw.toString());
          localahbt.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView));
          localahbt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          localahbt.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(8);
        }
        if ((localahbw.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (localViewHolder != null))
        {
          localahbt.jdField_a_of_type_AndroidWidgetRelativeLayout.setMinimumWidth(0);
          localObject = localahbw.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localahbt.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(localahbw.jdField_a_of_type_JavaLangString + localahbw.jdField_e_of_type_JavaLangString);
          paramViewHolder = (RecyclerView.ViewHolder)localObject;
          if (!localahbw.jdField_d_of_type_Boolean)
          {
            paramViewHolder = (RecyclerView.ViewHolder)localObject;
            if (!localahbw.jdField_e_of_type_Boolean)
            {
              paramViewHolder = (RecyclerView.ViewHolder)localObject;
              if (localahbw.b != null) {
                paramViewHolder = localahbw.b;
              }
            }
          }
          if (localViewHolder == null) {
            break label661;
          }
          paramViewHolder = new GifDrawable(localViewHolder);
        }
        for (;;)
        {
          localahbt.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramViewHolder);
          localahbt.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setBackgroundDrawable(null);
          localahbt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          localahbt.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(0);
          break;
          localahbt.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView));
          localahbt.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          localahbt.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(8);
          break;
        }
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.getContext()).inflate(2131562870, paramViewGroup, false);
      return new ahbt(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, paramViewGroup);
    case 2: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.getContext()).inflate(2131562869, paramViewGroup, false);
      return new ahbp(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, paramViewGroup);
    }
    return new ahbp(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbr
 * JD-Core Version:    0.7.0.1
 */