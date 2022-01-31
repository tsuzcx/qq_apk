import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import java.io.OutputStream;
import msg.aio_doodle.DoodleMsgProto.DoodleData;
import msg.aio_doodle.DoodleMsgProto.DoodleHeader;

public class addp
  implements addg
{
  public addp(DoodlePanel paramDoodlePanel, OutputStream paramOutputStream) {}
  
  public boolean a(DoodleMsgProto.DoodleData paramDoodleData)
  {
    if (paramDoodleData == null) {
      return false;
    }
    paramDoodleData = paramDoodleData.toByteArray();
    byte[] arrayOfByte = addf.a(paramDoodleData.length);
    try
    {
      this.jdField_a_of_type_JavaIoOutputStream.write(arrayOfByte);
      this.jdField_a_of_type_JavaIoOutputStream.write(paramDoodleData);
      label33:
      return true;
    }
    catch (Exception paramDoodleData)
    {
      break label33;
    }
  }
  
  public boolean a(DoodleMsgProto.DoodleHeader paramDoodleHeader)
  {
    if (paramDoodleHeader == null) {
      return false;
    }
    paramDoodleHeader = paramDoodleHeader.toByteArray();
    byte[] arrayOfByte = addf.a(paramDoodleHeader.length);
    try
    {
      this.jdField_a_of_type_JavaIoOutputStream.write(arrayOfByte);
      this.jdField_a_of_type_JavaIoOutputStream.write(paramDoodleHeader);
      label33:
      return true;
    }
    catch (Exception paramDoodleHeader)
    {
      break label33;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     addp
 * JD-Core Version:    0.7.0.1
 */