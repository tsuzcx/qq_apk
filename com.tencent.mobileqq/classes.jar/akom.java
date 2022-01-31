import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.apollo.debug.log.CmGameDebugLogView.1;
import java.util.ArrayList;
import java.util.List;

public class akom
{
  private int jdField_a_of_type_Int;
  private akoo jdField_a_of_type_Akoo;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  
  public akom(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private List<akon> a()
  {
    akoe localakoe = akro.a();
    if (localakoe != null) {
      return localakoe.a(this.jdField_a_of_type_Int);
    }
    return new ArrayList();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a()
  {
    View localView = b();
    a(localView);
    return localView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.post(new CmGameDebugLogView.1(this));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131364382));
    paramView = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_Akoo = new akoo(this.jdField_a_of_type_AndroidContentContext, a());
    paramView = new View(this.jdField_a_of_type_AndroidContentContext);
    paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, bcwh.a(this.jdField_a_of_type_AndroidContentContext, 32.0F)));
    this.jdField_a_of_type_Akoo.a(paramView);
    paramView.setId(2131362625);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Akoo);
    a();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Akoo != null)
    {
      if (paramBoolean) {
        a();
      }
      this.jdField_a_of_type_Akoo.a(a());
      this.jdField_a_of_type_Akoo.notifyDataSetChanged();
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.scrollToPosition(this.jdField_a_of_type_Akoo.getItemCount() - 1);
    }
  }
  
  public View b()
  {
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558831, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akom
 * JD-Core Version:    0.7.0.1
 */