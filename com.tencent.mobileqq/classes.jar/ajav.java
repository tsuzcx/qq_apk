public abstract class ajav
  extends bead
{
  private bead a;
  
  public ajav(bead parambead)
  {
    this.a = parambead;
  }
  
  public void onDoneFile(beae parambeae)
  {
    super.onDoneFile(parambeae);
    if (this.a != null) {
      this.a.onDoneFile(parambeae);
    }
  }
  
  public void onProgress(beae parambeae)
  {
    super.onProgress(parambeae);
    if (this.a != null) {
      this.a.onProgress(parambeae);
    }
  }
  
  public boolean onStart(beae parambeae)
  {
    if (this.a != null) {
      this.a.onStart(parambeae);
    }
    return super.onStart(parambeae);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajav
 * JD-Core Version:    0.7.0.1
 */