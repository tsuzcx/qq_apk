import android.view.View;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.EditorViewHolderManager.EditViewHolderBase;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.GotoReciteSubViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.ReciteResultSubViewHolder;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.ReciteTextSubViewHolder;

public class aixo
  extends EditorViewHolderManager.EditViewHolderBase
{
  int jdField_a_of_type_Int;
  GotoReciteSubViewHolder jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteGotoReciteSubViewHolder;
  ReciteResultSubViewHolder jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteResultSubViewHolder;
  ReciteTextSubViewHolder jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteTextSubViewHolder;
  
  public aixo(View paramView)
  {
    super(paramView);
    View localView1 = paramView.findViewById(2131368423);
    View localView2 = paramView.findViewById(2131368398);
    paramView = paramView.findViewById(2131368419);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteTextSubViewHolder = new ReciteTextSubViewHolder(localView1);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteGotoReciteSubViewHolder = new GotoReciteSubViewHolder(localView2);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteResultSubViewHolder = new ReciteResultSubViewHolder(paramView);
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem)
  {
    switch (((HWReciteInfo)this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelEditItemInfoBase).jdField_a_of_type_Int)
    {
    default: 
      return;
    case 2: 
      if (this.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteGotoReciteSubViewHolder.a(paramView, paramHWReciteItem, this);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteTextSubViewHolder.a(paramView, paramHWReciteItem, this);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteResultSubViewHolder.a(paramView, paramHWReciteItem, this);
  }
  
  public void a(HWReciteItem paramHWReciteItem, HWReciteInfo paramHWReciteInfo, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramHWReciteInfo.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteTextSubViewHolder.a.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteGotoReciteSubViewHolder.a.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteResultSubViewHolder.a.setVisibility(8);
      return;
    case 2: 
      if (paramInt == 2)
      {
        paramHWReciteInfo.g = 0;
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteTextSubViewHolder.a.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteGotoReciteSubViewHolder.a(paramHWReciteItem, this, paramHWReciteInfo, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteResultSubViewHolder.a.setVisibility(8);
        return;
      }
      paramHWReciteInfo.g = 3;
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteTextSubViewHolder.a(paramHWReciteItem, this, paramHWReciteInfo, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteGotoReciteSubViewHolder.a.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteResultSubViewHolder.a.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteTextSubViewHolder.a.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteGotoReciteSubViewHolder.a.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorUiReciteReciteResultSubViewHolder.a(paramHWReciteItem, this, paramHWReciteInfo, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aixo
 * JD-Core Version:    0.7.0.1
 */