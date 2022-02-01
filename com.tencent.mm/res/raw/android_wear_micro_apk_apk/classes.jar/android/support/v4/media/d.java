package android.support.v4.media;

final class d
  implements s
{
  d(b paramb) {}
  
  public final void onConnected()
  {
    if (this.ip.io != null) {
      this.ip.io.onConnected();
    }
    this.ip.onConnected();
  }
  
  public final void onConnectionFailed()
  {
    this.ip.onConnectionFailed();
  }
  
  public final void onConnectionSuspended()
  {
    if (this.ip.io != null) {
      this.ip.io.onConnectionSuspended();
    }
    this.ip.onConnectionSuspended();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.d
 * JD-Core Version:    0.7.0.1
 */