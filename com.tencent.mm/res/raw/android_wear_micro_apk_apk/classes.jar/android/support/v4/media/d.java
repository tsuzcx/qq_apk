package android.support.v4.media;

final class d
  implements s
{
  d(b paramb) {}
  
  public final void onConnected()
  {
    if (this.gs.gr != null) {
      this.gs.gr.onConnected();
    }
    this.gs.onConnected();
  }
  
  public final void onConnectionFailed()
  {
    this.gs.onConnectionFailed();
  }
  
  public final void onConnectionSuspended()
  {
    if (this.gs.gr != null) {
      this.gs.gr.onConnectionSuspended();
    }
    this.gs.onConnectionSuspended();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.media.d
 * JD-Core Version:    0.7.0.1
 */