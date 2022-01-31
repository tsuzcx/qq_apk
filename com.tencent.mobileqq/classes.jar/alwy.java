import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.data.AddressData.NO_LIMIT_ADDRESS;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class alwy
  implements alxp
{
  public alwy(LocationSelectActivity paramLocationSelectActivity) {}
  
  public void a()
  {
    LocationSelectActivity.a(this.a).setRightTextColor(2);
    this.a.jdField_a_of_type_Begr.dismiss();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView == null) {
      return;
    }
    switch (paramInt1)
    {
    }
    label809:
    label812:
    for (;;)
    {
      LocationSelectActivity.a(this.a, LocationSelectActivity.a(this.a), LocationSelectActivity.a(this.a));
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(null);
      this.a.jdField_a_of_type_ArrayOfInt[0] = paramInt2;
      this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[0] = ((BaseAddress)((ArrayList)this.a.jdField_a_of_type_ArrayOfJavaLangObject[0]).get(paramInt2));
      ArrayList localArrayList1 = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[0].getDataList();
      if (localArrayList1.size() > 0)
      {
        this.a.jdField_a_of_type_ArrayOfJavaLangObject[1] = localArrayList1;
        this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1] = ((BaseAddress)localArrayList1.get(0));
        this.a.jdField_a_of_type_ArrayOfInt[1] = 0;
        localArrayList1 = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1].getDataList();
        if (localArrayList1.size() > 0)
        {
          this.a.jdField_a_of_type_ArrayOfJavaLangObject[2] = localArrayList1;
          this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = ((BaseAddress)localArrayList1.get(0));
          this.a.jdField_a_of_type_ArrayOfInt[2] = 0;
        }
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_Int > 1)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1);
          this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.a.jdField_a_of_type_ArrayOfInt[1]);
          if (this.a.jdField_a_of_type_Int == 3)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
            this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.a.jdField_a_of_type_ArrayOfInt[2]);
          }
        }
        this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this);
        break;
        if (this.a.jdField_a_of_type_Int == 3)
        {
          this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = new AddressData.NO_LIMIT_ADDRESS(3);
          this.a.jdField_a_of_type_ArrayOfJavaLangObject[2] = null;
          this.a.jdField_a_of_type_ArrayOfInt[2] = 0;
          continue;
          if (this.a.jdField_a_of_type_Int > 1)
          {
            this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1] = new AddressData.NO_LIMIT_ADDRESS(2);
            this.a.jdField_a_of_type_ArrayOfJavaLangObject[1] = null;
            this.a.jdField_a_of_type_ArrayOfInt[1] = 0;
            if (this.a.jdField_a_of_type_Int == 3)
            {
              this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = new AddressData.NO_LIMIT_ADDRESS(3);
              this.a.jdField_a_of_type_ArrayOfJavaLangObject[2] = null;
              this.a.jdField_a_of_type_ArrayOfInt[2] = 0;
            }
          }
        }
      }
      this.a.jdField_a_of_type_ArrayOfInt[1] = paramInt2;
      this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(null);
      try
      {
        this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1] = ((BaseAddress)((ArrayList)this.a.jdField_a_of_type_ArrayOfJavaLangObject[1]).get(paramInt2));
        localArrayList1 = this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1].getDataList();
        if (localArrayList1.size() > 0)
        {
          this.a.jdField_a_of_type_ArrayOfJavaLangObject[2] = localArrayList1;
          this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = ((BaseAddress)localArrayList1.get(0));
          this.a.jdField_a_of_type_ArrayOfInt[2] = 0;
          if (this.a.jdField_a_of_type_Int > 2)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
            this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.a.jdField_a_of_type_ArrayOfInt[2]);
          }
          this.a.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[1] = new BaseAddress("不限", "0", 2);
          continue;
          if (this.a.jdField_a_of_type_Int > 2)
          {
            this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = new AddressData.NO_LIMIT_ADDRESS(3);
            this.a.jdField_a_of_type_ArrayOfJavaLangObject[2] = null;
            this.a.jdField_a_of_type_ArrayOfInt[2] = 0;
          }
        }
      }
      ArrayList localArrayList2;
      if (Collections.emptyList().equals(this.a.jdField_a_of_type_ArrayOfJavaLangObject[2]))
      {
        if (!QLog.isColorLevel()) {
          break label809;
        }
        QLog.d("LocationSelectActivity", 2, "columnListArray at 2 is empty");
        localArrayList2 = null;
      }
      for (;;)
      {
        if ((localArrayList2 == null) || (paramInt2 >= localArrayList2.size()) || (paramInt2 < 0)) {
          break label812;
        }
        this.a.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchDataBaseAddress[2] = ((BaseAddress)localArrayList2.get(paramInt2));
        this.a.jdField_a_of_type_ArrayOfInt[2] = paramInt2;
        break;
        localArrayList2 = (ArrayList)this.a.jdField_a_of_type_ArrayOfJavaLangObject[2];
        continue;
        localArrayList2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alwy
 * JD-Core Version:    0.7.0.1
 */