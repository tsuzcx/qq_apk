public abstract class aiwg
  extends bdvu
{
  private bdvu a;
  
  public aiwg(bdvu parambdvu)
  {
    this.a = parambdvu;
  }
  
  public void onDoneFile(bdvv parambdvv)
  {
    super.onDoneFile(parambdvv);
    if (this.a != null) {
      this.a.onDoneFile(parambdvv);
    }
  }
  
  public void onProgress(bdvv parambdvv)
  {
    super.onProgress(parambdvv);
    if (this.a != null) {
      this.a.onProgress(parambdvv);
    }
  }
  
  public boolean onStart(bdvv parambdvv)
  {
    if (this.a != null) {
      this.a.onStart(parambdvv);
    }
    return super.onStart(parambdvv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwg
 * JD-Core Version:    0.7.0.1
 */