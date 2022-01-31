import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.colornote.data.ColorNote;

public class altx
{
  private alrw jdField_a_of_type_Alrw = new alrw();
  private alsb jdField_a_of_type_Alsb;
  private alsd jdField_a_of_type_Alsd;
  private boolean jdField_a_of_type_Boolean = true;
  
  public altx()
  {
    this.jdField_a_of_type_Alrw.a(new alry());
    this.jdField_a_of_type_Alsb = new alsb();
    this.jdField_a_of_type_Alsb.a(this.jdField_a_of_type_Alrw);
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == 16908289;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Alrw != null) && (this.jdField_a_of_type_Alsd != null))
    {
      localColorNote = this.jdField_a_of_type_Alsd.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Alrw.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
        localColorNote = alsr.a(localColorNote);
        this.jdField_a_of_type_Alrw.a(localColorNote.getServiceType(), localColorNote.getSubType(), true);
      }
    }
    while (!QLog.isColorLevel())
    {
      ColorNote localColorNote;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ColorNoteStateNotice", 1, "onResume: colorNote is null");
      return;
    }
    QLog.e("ColorNoteStateNotice", 1, "onResume: mColorNoteCurd or mServiceInfo is null");
  }
  
  public void a(alrw paramalrw)
  {
    this.jdField_a_of_type_Alrw = paramalrw;
  }
  
  public void a(alry paramalry)
  {
    if (this.jdField_a_of_type_Alrw != null) {
      this.jdField_a_of_type_Alrw.a(paramalry);
    }
  }
  
  public void a(alsd paramalsd)
  {
    this.jdField_a_of_type_Alsd = paramalsd;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Alrw != null) && (this.jdField_a_of_type_Alsd != null))
    {
      localColorNote = this.jdField_a_of_type_Alsd.getColorNote();
      if (localColorNote != null)
      {
        this.jdField_a_of_type_Alrw.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
        localColorNote = alsr.a(localColorNote);
        this.jdField_a_of_type_Alrw.a(localColorNote.getServiceType(), localColorNote.getSubType(), false);
      }
    }
    while (!QLog.isColorLevel())
    {
      ColorNote localColorNote;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ColorNoteStateNotice", 1, "onPause: colorNote is null");
      return;
    }
    QLog.e("ColorNoteStateNotice", 1, "onPause: mColorNoteCurd or mServiceInfo is null");
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Alsd != null) && (this.jdField_a_of_type_Alrw != null) && (this.jdField_a_of_type_Alsb != null))
    {
      int j = 0;
      ColorNote localColorNote = this.jdField_a_of_type_Alsd.getColorNote();
      int i = j;
      if (localColorNote != null)
      {
        i = j;
        if (a(localColorNote.getServiceType())) {
          i = 1;
        }
      }
      if ((i != 0) && (this.jdField_a_of_type_Boolean) && (paramBoolean) && (!this.jdField_a_of_type_Alrw.a(localColorNote.getServiceType(), localColorNote.getSubType())))
      {
        alsr.a(localColorNote);
        this.jdField_a_of_type_Alsb.a(localColorNote);
      }
    }
  }
  
  public void c()
  {
    b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     altx
 * JD-Core Version:    0.7.0.1
 */