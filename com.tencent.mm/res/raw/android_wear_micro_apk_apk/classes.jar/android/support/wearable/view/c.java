package android.support.wearable.view;

 enum c
{
  private final int x;
  private final int y;
  
  private c(int paramInt1, int paramInt2)
  {
    this.x = paramInt1;
    this.y = paramInt2;
  }
  
  static c c(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 != 0.0F)
    {
      if (paramFloat2 > 0.0F) {
        return Cd;
      }
      return Cb;
    }
    if (paramFloat1 != 0.0F)
    {
      if (paramFloat1 > 0.0F) {
        return Cc;
      }
      return Ca;
    }
    return Ce;
  }
  
  final boolean eY()
  {
    return this.y != 0;
  }
  
  final boolean eZ()
  {
    return this.x != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.c
 * JD-Core Version:    0.7.0.1
 */