public abstract class ahcc
  extends bbwt
{
  private bbwt a;
  
  public ahcc(bbwt parambbwt)
  {
    this.a = parambbwt;
  }
  
  public void onDoneFile(bbwu parambbwu)
  {
    super.onDoneFile(parambbwu);
    if (this.a != null) {
      this.a.onDoneFile(parambbwu);
    }
  }
  
  public void onProgress(bbwu parambbwu)
  {
    super.onProgress(parambbwu);
    if (this.a != null) {
      this.a.onProgress(parambbwu);
    }
  }
  
  public boolean onStart(bbwu parambbwu)
  {
    if (this.a != null) {
      this.a.onStart(parambbwu);
    }
    return super.onStart(parambbwu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahcc
 * JD-Core Version:    0.7.0.1
 */