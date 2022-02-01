public abstract class akxm
  extends bhyn
{
  private bhyn a;
  
  public akxm(bhyn parambhyn)
  {
    this.a = parambhyn;
  }
  
  public void onDoneFile(bhyo parambhyo)
  {
    super.onDoneFile(parambhyo);
    if (this.a != null) {
      this.a.onDoneFile(parambhyo);
    }
  }
  
  public void onProgress(bhyo parambhyo)
  {
    super.onProgress(parambhyo);
    if (this.a != null) {
      this.a.onProgress(parambhyo);
    }
  }
  
  public boolean onStart(bhyo parambhyo)
  {
    if (this.a != null) {
      this.a.onStart(parambhyo);
    }
    return super.onStart(parambhyo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxm
 * JD-Core Version:    0.7.0.1
 */