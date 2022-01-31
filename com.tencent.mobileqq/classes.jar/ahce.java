public abstract class ahce
  extends bbwf
{
  private bbwf a;
  
  public ahce(bbwf parambbwf)
  {
    this.a = parambbwf;
  }
  
  public void onDoneFile(bbwg parambbwg)
  {
    super.onDoneFile(parambbwg);
    if (this.a != null) {
      this.a.onDoneFile(parambbwg);
    }
  }
  
  public void onProgress(bbwg parambbwg)
  {
    super.onProgress(parambbwg);
    if (this.a != null) {
      this.a.onProgress(parambbwg);
    }
  }
  
  public boolean onStart(bbwg parambbwg)
  {
    if (this.a != null) {
      this.a.onStart(parambbwg);
    }
    return super.onStart(parambbwg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahce
 * JD-Core Version:    0.7.0.1
 */