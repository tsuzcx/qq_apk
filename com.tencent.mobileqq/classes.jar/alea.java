public abstract class alea
  extends biht
{
  private biht a;
  
  public alea(biht parambiht)
  {
    this.a = parambiht;
  }
  
  public void onDoneFile(bihu parambihu)
  {
    super.onDoneFile(parambihu);
    if (this.a != null) {
      this.a.onDoneFile(parambihu);
    }
  }
  
  public void onProgress(bihu parambihu)
  {
    super.onProgress(parambihu);
    if (this.a != null) {
      this.a.onProgress(parambihu);
    }
  }
  
  public boolean onStart(bihu parambihu)
  {
    if (this.a != null) {
      this.a.onStart(parambihu);
    }
    return super.onStart(parambihu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alea
 * JD-Core Version:    0.7.0.1
 */