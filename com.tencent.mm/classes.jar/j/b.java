package j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"synchronized", "R", "lock", "", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asUtf8ToByteArray", "", "", "toUtf8String", "ArrayIndexOutOfBoundsException", "Ljava/lang/ArrayIndexOutOfBoundsException;", "Closeable", "Ljava/io/Closeable;", "EOFException", "Ljava/io/EOFException;", "FileNotFoundException", "Ljava/io/FileNotFoundException;", "IOException", "Ljava/io/IOException;", "okio"}, k=2, mv={1, 4, 1})
public final class b
{
  public static final byte[] bKP(String paramString)
  {
    AppMethodBeat.i(186340);
    s.u(paramString, "$this$asUtf8ToByteArray");
    paramString = paramString.getBytes(d.UTF_8);
    s.s(paramString, "(this as java.lang.String).getBytes(charset)");
    AppMethodBeat.o(186340);
    return paramString;
  }
  
  public static final String ec(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186337);
    s.u(paramArrayOfByte, "$this$toUtf8String");
    paramArrayOfByte = new String(paramArrayOfByte, d.UTF_8);
    AppMethodBeat.o(186337);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     j.b
 * JD-Core Version:    0.7.0.1
 */