import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.List;

public class alte
  extends RecyclerView.Adapter<alti>
{
  private alth jdField_a_of_type_Alth;
  private altu jdField_a_of_type_Altu;
  private List<ColorNote> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public alti a(ViewGroup paramViewGroup, int paramInt)
  {
    return new alti(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131493250, paramViewGroup, false));
  }
  
  public void a(alth paramalth)
  {
    this.jdField_a_of_type_Alth = paramalth;
  }
  
  public void a(alti paramalti, int paramInt)
  {
    alrv.a((ColorNote)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(paramalti, paramInt, this.jdField_a_of_type_Boolean);
  }
  
  public void a(altu paramaltu)
  {
    this.jdField_a_of_type_Altu = paramaltu;
  }
  
  void a(List<ColorNote> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alte
 * JD-Core Version:    0.7.0.1
 */