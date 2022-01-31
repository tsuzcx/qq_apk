import com.tencent.ark.ark.PlayerStub;
import com.tencent.ark.ark.PlayerStubFactory;
import com.tencent.mobileqq.ark.ArkMediaPlayer;

public final class abda
  implements ark.PlayerStubFactory
{
  public ark.PlayerStub CreateStub()
  {
    return new ArkMediaPlayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abda
 * JD-Core Version:    0.7.0.1
 */