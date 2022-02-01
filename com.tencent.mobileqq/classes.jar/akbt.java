public abstract class akbt
  extends bgod
{
  private bgod a;
  
  public akbt(bgod parambgod)
  {
    this.a = parambgod;
  }
  
  public void onDoneFile(bgoe parambgoe)
  {
    super.onDoneFile(parambgoe);
    if (this.a != null) {
      this.a.onDoneFile(parambgoe);
    }
  }
  
  public void onProgress(bgoe parambgoe)
  {
    super.onProgress(parambgoe);
    if (this.a != null) {
      this.a.onProgress(parambgoe);
    }
  }
  
  public boolean onStart(bgoe parambgoe)
  {
    if (this.a != null) {
      this.a.onStart(parambgoe);
    }
    return super.onStart(parambgoe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akbt
 * JD-Core Version:    0.7.0.1
 */