public abstract class akso
  extends bhhe
{
  private bhhe a;
  
  public akso(bhhe parambhhe)
  {
    this.a = parambhhe;
  }
  
  public void onDoneFile(bhhf parambhhf)
  {
    super.onDoneFile(parambhhf);
    if (this.a != null) {
      this.a.onDoneFile(parambhhf);
    }
  }
  
  public void onProgress(bhhf parambhhf)
  {
    super.onProgress(parambhhf);
    if (this.a != null) {
      this.a.onProgress(parambhhf);
    }
  }
  
  public boolean onStart(bhhf parambhhf)
  {
    if (this.a != null) {
      this.a.onStart(parambhhf);
    }
    return super.onStart(parambhhf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akso
 * JD-Core Version:    0.7.0.1
 */