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

public class aezx
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public int a;
  public View a;
  public String a;
  public List<afac> a;
  public boolean a;
  public List<afac> b = new ArrayList();
  
  public aezx(ZhituPanelView paramZhituPanelView)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    int i = 0;
    while (i < ZhituPanelView.jdField_a_of_type_Int)
    {
      this.b.add(new afac());
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
    if ((i == 0) || (TextUtils.isEmpty(((afac)this.jdField_a_of_type_JavaUtilList.get(i - 1)).jdField_d_of_type_JavaLangString))) {}
    while (i <= this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = i;
    aezl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).a(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_JavaLangString);
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
        axqy.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "dc00898", "", "", "0X8008C71", "0X8008C71", aezl.a(aezl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).a()), 0, "", "", "", "");
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      while (i < paramInt)
      {
        this.jdField_a_of_type_JavaUtilList.add(new afac());
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
  
  public void a(afac paramafac)
  {
    if (paramafac != null)
    {
      int i = paramafac.jdField_a_of_type_Int;
      if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()))
      {
        afac localafac = (afac)this.jdField_a_of_type_JavaUtilList.get(i);
        localafac.a(paramafac);
        if (localafac.jdField_d_of_type_Boolean)
        {
          if ((ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView) != null) && (ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView) != localafac)) {
            ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).jdField_d_of_type_Boolean = false;
          }
          ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, localafac);
        }
      }
      notifyDataSetChanged();
      if (i == 0)
      {
        ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).setEnabled(true);
        ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).setVisibility(0);
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
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379597);
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
      Object localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379597);
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
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new aezy(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (getItemViewType(paramInt) == 3) {
      break label9;
    }
    label9:
    while (!(paramViewHolder instanceof aezz)) {
      return;
    }
    label24:
    aezz localaezz;
    afac localafac;
    Object localObject;
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      localaezz = (aezz)paramViewHolder;
      localafac = (afac)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localaezz.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localafac);
      localaezz.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      localaezz.jdField_a_of_type_AndroidWidgetRadioButton.setChecked(localafac.jdField_d_of_type_Boolean);
      if (!localafac.jdField_a_of_type_Boolean) {
        break label458;
      }
      localObject = aezl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).b(localafac);
      paramViewHolder = aezl.a((String)localObject);
      localViewHolder = paramViewHolder;
      if (paramViewHolder == null)
      {
        aezl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).c(localafac);
        localViewHolder = paramViewHolder;
        if (QLog.isColorLevel()) {
          QLog.d(ZhituPanelView.b(), 2, "get gif image from cache fail, " + (String)localObject);
        }
      }
    }
    label455:
    label458:
    for (RecyclerView.ViewHolder localViewHolder = paramViewHolder;; localViewHolder = null)
    {
      localaezz.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView);
      if ((localafac.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (localViewHolder != null))
      {
        localaezz.jdField_a_of_type_AndroidWidgetRelativeLayout.setMinimumWidth(0);
        localObject = localafac.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localaezz.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(localafac.jdField_a_of_type_JavaLangString + localafac.jdField_e_of_type_JavaLangString);
        paramViewHolder = (RecyclerView.ViewHolder)localObject;
        if (!localafac.jdField_d_of_type_Boolean)
        {
          paramViewHolder = (RecyclerView.ViewHolder)localObject;
          if (!localafac.jdField_e_of_type_Boolean)
          {
            paramViewHolder = (RecyclerView.ViewHolder)localObject;
            if (localafac.b != null) {
              paramViewHolder = localafac.b;
            }
          }
        }
        if (localViewHolder == null) {
          break label455;
        }
        paramViewHolder = new GifDrawable(localViewHolder);
      }
      for (;;)
      {
        localaezz.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramViewHolder);
        localaezz.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setBackgroundDrawable(null);
        localaezz.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        localaezz.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(0);
        for (;;)
        {
          localaezz.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView);
          if ((localafac.jdField_a_of_type_Afad == null) || (localafac.jdField_a_of_type_Afad.jdField_a_of_type_Boolean)) {
            break;
          }
          aezl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).b(localafac);
          localafac.jdField_a_of_type_Afad.jdField_a_of_type_Boolean = true;
          return;
          paramInt -= 1;
          break label24;
          localaezz.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView));
          localaezz.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          localaezz.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(8);
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
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.getContext()).inflate(2131562648, paramViewGroup, false);
      return new aezz(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, paramViewGroup);
    case 2: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.getContext()).inflate(2131562647, paramViewGroup, false);
      return new aezv(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, paramViewGroup);
    }
    return new aezv(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aezx
 * JD-Core Version:    0.7.0.1
 */