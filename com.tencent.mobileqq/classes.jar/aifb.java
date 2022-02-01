import com.tencent.widget.XListView.DrawFinishedListener;

class aifb
  implements XListView.DrawFinishedListener
{
  aifb(aido paramaido) {}
  
  public void drawFinished()
  {
    if ((!this.a.t) && (this.a.u))
    {
      this.a.t = true;
      uuq.a("SUBSCRIPT_AIO_COST", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aifb
 * JD-Core Version:    0.7.0.1
 */