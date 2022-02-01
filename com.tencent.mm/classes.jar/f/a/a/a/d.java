package f.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class d
  implements b
{
  public final byte[] zip(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(214850);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    ZipOutputStream localZipOutputStream = new ZipOutputStream(localByteArrayOutputStream);
    ZipEntry localZipEntry = new ZipEntry("zip");
    localZipEntry.setSize(paramArrayOfByte.length);
    localZipOutputStream.putNextEntry(localZipEntry);
    localZipOutputStream.write(paramArrayOfByte);
    localZipOutputStream.closeEntry();
    localZipOutputStream.close();
    paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    AppMethodBeat.o(214850);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     f.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */