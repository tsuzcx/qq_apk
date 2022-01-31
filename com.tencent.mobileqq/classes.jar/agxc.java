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

public class agxc
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public int a;
  public View a;
  public String a;
  public List<agxh> a;
  public boolean a;
  public List<agxh> b = new ArrayList();
  
  public agxc(ZhituPanelView paramZhituPanelView)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    int i = 0;
    while (i < ZhituPanelView.jdField_a_of_type_Int)
    {
      this.b.add(new agxh());
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
    if ((i == 0) || (TextUtils.isEmpty(((agxh)this.jdField_a_of_type_JavaUtilList.get(i - 1)).jdField_d_of_type_JavaLangString))) {}
    while (i <= this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = i;
    agwq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).a(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_JavaLangString);
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
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, "dc00898", "", "", "0X8008C71", "0X8008C71", agwq.a(agwq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).a()), 0, "", "", "", "");
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      while (i < paramInt)
      {
        this.jdField_a_of_type_JavaUtilList.add(new agxh());
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
  
  public void a(agxh paramagxh)
  {
    int i;
    agxh localagxh;
    if (paramagxh != null)
    {
      i = paramagxh.jdField_a_of_type_Int;
      if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()))
      {
        localagxh = (agxh)this.jdField_a_of_type_JavaUtilList.get(i);
        localagxh.a(paramagxh);
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
      if (localagxh.jdField_d_of_type_Boolean)
      {
        if ((ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView) != null) && (ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView) != localagxh)) {
          ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).jdField_d_of_type_Boolean = false;
        }
        ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, localagxh);
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
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380341);
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
      Object localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380341);
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
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new agxd(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (getItemViewType(paramInt) == 3) {
      break label9;
    }
    label9:
    while (!(paramViewHolder instanceof agxe)) {
      return;
    }
    label24:
    agxe localagxe;
    agxh localagxh;
    Object localObject;
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      localagxe = (agxe)paramViewHolder;
      localagxh = (agxh)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localagxe.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localagxh);
      localagxe.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      localagxe.jdField_a_of_type_AndroidWidgetRadioButton.setChecked(localagxh.jdField_d_of_type_Boolean);
      if (!localagxh.jdField_a_of_type_Boolean) {
        break label667;
      }
      localObject = agwq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).b(localagxh);
      paramViewHolder = agwq.a((String)localObject);
      localViewHolder = paramViewHolder;
      if (paramViewHolder == null)
      {
        agwq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).c(localagxh);
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
      localagxe.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a() == 1) {
        if ((localagxh.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (localViewHolder != null))
        {
          QLog.d(ZhituPanelView.b(), 2, "ZhituTest has a drawable data is " + localagxh.toString());
          paramViewHolder = localagxh.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localagxe.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(localagxh.jdField_a_of_type_JavaLangString + localagxh.jdField_e_of_type_JavaLangString);
          if (localViewHolder == null) {
            break label664;
          }
          paramViewHolder = new GifDrawable(localViewHolder);
        }
      }
      for (;;)
      {
        localagxe.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramViewHolder);
        localagxe.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setBackgroundDrawable(null);
        localagxe.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        for (;;)
        {
          localagxe.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView);
          if ((localagxh.jdField_a_of_type_Agxi == null) || (localagxh.jdField_a_of_type_Agxi.jdField_a_of_type_Boolean)) {
            break;
          }
          agwq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).b(localagxh);
          localagxh.jdField_a_of_type_Agxi.jdField_a_of_type_Boolean = true;
          return;
          paramInt -= 1;
          break label24;
          QLog.d(ZhituPanelView.b(), 2, "ZhituTest has no drawable data is " + localagxh.toString());
          localagxe.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView));
          localagxe.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          localagxe.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(8);
        }
        if ((localagxh.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (localViewHolder != null))
        {
          localagxe.jdField_a_of_type_AndroidWidgetRelativeLayout.setMinimumWidth(0);
          localObject = localagxh.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localagxe.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(localagxh.jdField_a_of_type_JavaLangString + localagxh.jdField_e_of_type_JavaLangString);
          paramViewHolder = (RecyclerView.ViewHolder)localObject;
          if (!localagxh.jdField_d_of_type_Boolean)
          {
            paramViewHolder = (RecyclerView.ViewHolder)localObject;
            if (!localagxh.jdField_e_of_type_Boolean)
            {
              paramViewHolder = (RecyclerView.ViewHolder)localObject;
              if (localagxh.b != null) {
                paramViewHolder = localagxh.b;
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
          localagxe.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramViewHolder);
          localagxe.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setBackgroundDrawable(null);
          localagxe.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          localagxe.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(0);
          break;
          localagxe.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView));
          localagxe.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          localagxe.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(8);
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
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.getContext()).inflate(2131562852, paramViewGroup, false);
      return new agxe(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, paramViewGroup);
    case 2: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.getContext()).inflate(2131562851, paramViewGroup, false);
      return new agxa(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, paramViewGroup);
    }
    return new agxa(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agxc
 * JD-Core Version:    0.7.0.1
 */