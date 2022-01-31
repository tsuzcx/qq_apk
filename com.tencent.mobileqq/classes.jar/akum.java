import com.tencent.plato.mqq.network.ProgressListener;
import com.tencent.plato.mqq.network.ProgressRequestBody;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

public class akum
  extends ForwardingSink
{
  long jdField_a_of_type_Long = 0L;
  long b = 0L;
  
  public akum(ProgressRequestBody paramProgressRequestBody, Sink paramSink)
  {
    super(paramSink);
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    super.write(paramBuffer, paramLong);
    if (this.b == 0L) {
      this.b = this.jdField_a_of_type_ComTencentPlatoMqqNetworkProgressRequestBody.contentLength();
    }
    this.jdField_a_of_type_Long += paramLong;
    paramBuffer = ProgressRequestBody.a(this.jdField_a_of_type_ComTencentPlatoMqqNetworkProgressRequestBody);
    paramLong = this.jdField_a_of_type_Long;
    long l = this.b;
    if (this.jdField_a_of_type_Long == this.b) {}
    for (boolean bool = true;; bool = false)
    {
      paramBuffer.a(paramLong, l, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akum
 * JD-Core Version:    0.7.0.1
 */