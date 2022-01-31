public abstract class agpp
  extends batl
{
  private batl a;
  
  public agpp(batl parambatl)
  {
    this.a = parambatl;
  }
  
  public void onDoneFile(batm parambatm)
  {
    super.onDoneFile(parambatm);
    if (this.a != null) {
      this.a.onDoneFile(parambatm);
    }
  }
  
  public void onProgress(batm parambatm)
  {
    super.onProgress(parambatm);
    if (this.a != null) {
      this.a.onProgress(parambatm);
    }
  }
  
  public boolean onStart(batm parambatm)
  {
    if (this.a != null) {
      this.a.onStart(parambatm);
    }
    return super.onStart(parambatm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agpp
 * JD-Core Version:    0.7.0.1
 */