import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.Comparator;

public class adpj
  implements Comparator<adpf>
{
  public adpj(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(adpf paramadpf1, adpf paramadpf2)
  {
    long l = paramadpf1.a.certifiedGrade;
    return (int)(paramadpf2.a.certifiedGrade - l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpj
 * JD-Core Version:    0.7.0.1
 */