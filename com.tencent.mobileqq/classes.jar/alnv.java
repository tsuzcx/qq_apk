import java.util.Comparator;

class alnv
  implements Comparator<bamx>
{
  alnv(alnu paramalnu) {}
  
  public int a(bamx parambamx1, bamx parambamx2)
  {
    if ((parambamx1 != null) && (parambamx2 != null)) {
      return parambamx1.b - parambamx2.b;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alnv
 * JD-Core Version:    0.7.0.1
 */