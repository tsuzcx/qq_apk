package android.arch.lifecycle;

abstract class n
{
  final q<T> ah;
  boolean ai;
  int aj = -1;
  
  n(q<T> paramq)
  {
    Object localObject;
    this.ah = localObject;
  }
  
  final void a(boolean paramBoolean)
  {
    int j = 1;
    if (paramBoolean == this.ai) {
      return;
    }
    this.ai = paramBoolean;
    int i;
    label28:
    LiveData localLiveData;
    int k;
    if (LiveData.a(this.ag) == 0)
    {
      i = 1;
      localLiveData = this.ag;
      k = LiveData.a(localLiveData);
      if (!this.ai) {
        break label121;
      }
    }
    for (;;)
    {
      LiveData.a(localLiveData, j + k);
      if ((i != 0) && (this.ai)) {
        this.ag.onActive();
      }
      if ((LiveData.a(this.ag) == 0) && (!this.ai)) {
        this.ag.l();
      }
      if (!this.ai) {
        break;
      }
      LiveData.a(this.ag, this);
      return;
      i = 0;
      break label28;
      label121:
      j = -1;
    }
  }
  
  boolean c(i parami)
  {
    return false;
  }
  
  abstract boolean n();
  
  void o() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.arch.lifecycle.n
 * JD-Core Version:    0.7.0.1
 */