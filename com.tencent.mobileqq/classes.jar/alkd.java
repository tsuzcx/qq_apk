import com.squareup.okhttp.ResponseBody;
import com.tencent.plato.mqq.network.ProgressListener;
import com.tencent.plato.mqq.network.ProgressResponseBody;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

public class alkd
  extends ForwardingSource
{
  public alkd(ProgressResponseBody paramProgressResponseBody, Source paramSource)
  {
    super(paramSource);
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    long l1 = super.read(paramBuffer, paramLong);
    paramBuffer = this.a;
    long l2 = ProgressResponseBody.a(this.a);
    if (l1 != -1L)
    {
      paramLong = l1;
      ProgressResponseBody.a(paramBuffer, paramLong + l2);
      paramBuffer = ProgressResponseBody.a(this.a);
      paramLong = ProgressResponseBody.a(this.a);
      l2 = ProgressResponseBody.a(this.a).contentLength();
      if (l1 != -1L) {
        break label102;
      }
    }
    label102:
    for (boolean bool = true;; bool = false)
    {
      paramBuffer.a(paramLong, l2, bool);
      return l1;
      paramLong = 0L;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alkd
 * JD-Core Version:    0.7.0.1
 */