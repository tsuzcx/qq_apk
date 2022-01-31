package com.tencent.ttpic.baseutils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class IOUtils
{
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  public static final char DIR_SEPARATOR;
  public static final char DIR_SEPARATOR_UNIX = '/';
  public static final char DIR_SEPARATOR_WINDOWS = '\\';
  public static final String LINE_SEPARATOR;
  public static final String LINE_SEPARATOR_UNIX = "\n";
  public static final String LINE_SEPARATOR_WINDOWS = "\r\n";
  
  static
  {
    AppMethodBeat.i(49765);
    DIR_SEPARATOR = File.separatorChar;
    StringWriter localStringWriter = new StringWriter(4);
    new PrintWriter(localStringWriter).println();
    LINE_SEPARATOR = localStringWriter.toString();
    AppMethodBeat.o(49765);
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(49721);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(49721);
        return;
      }
      catch (Throwable paramCloseable)
      {
        LogUtils.e(paramCloseable);
      }
    }
    AppMethodBeat.o(49721);
  }
  
  public static void closeQuietly(InputStream paramInputStream)
  {
    AppMethodBeat.i(49719);
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      AppMethodBeat.o(49719);
      return;
    }
    catch (IOException paramInputStream)
    {
      AppMethodBeat.o(49719);
    }
  }
  
  public static void closeQuietly(OutputStream paramOutputStream)
  {
    AppMethodBeat.i(49720);
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      AppMethodBeat.o(49720);
      return;
    }
    catch (IOException paramOutputStream)
    {
      AppMethodBeat.o(49720);
    }
  }
  
  public static void closeQuietly(Reader paramReader)
  {
    AppMethodBeat.i(49717);
    if (paramReader != null) {}
    try
    {
      paramReader.close();
      AppMethodBeat.o(49717);
      return;
    }
    catch (IOException paramReader)
    {
      AppMethodBeat.o(49717);
    }
  }
  
  public static void closeQuietly(Writer paramWriter)
  {
    AppMethodBeat.i(49718);
    if (paramWriter != null) {}
    try
    {
      paramWriter.close();
      AppMethodBeat.o(49718);
      return;
    }
    catch (IOException paramWriter)
    {
      AppMethodBeat.o(49718);
    }
  }
  
  public static boolean contentEquals(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    AppMethodBeat.i(49763);
    Object localObject = paramInputStream1;
    if (!(paramInputStream1 instanceof BufferedInputStream)) {
      localObject = new BufferedInputStream(paramInputStream1);
    }
    paramInputStream1 = paramInputStream2;
    if (!(paramInputStream2 instanceof BufferedInputStream)) {
      paramInputStream1 = new BufferedInputStream(paramInputStream2);
    }
    for (int i = ((InputStream)localObject).read(); -1 != i; i = ((InputStream)localObject).read()) {
      if (i != paramInputStream1.read())
      {
        AppMethodBeat.o(49763);
        return false;
      }
    }
    if (paramInputStream1.read() == -1)
    {
      AppMethodBeat.o(49763);
      return true;
    }
    AppMethodBeat.o(49763);
    return false;
  }
  
  public static boolean contentEquals(Reader paramReader1, Reader paramReader2)
  {
    AppMethodBeat.i(49764);
    Object localObject = paramReader1;
    if (!(paramReader1 instanceof BufferedReader)) {
      localObject = new BufferedReader(paramReader1);
    }
    paramReader1 = paramReader2;
    if (!(paramReader2 instanceof BufferedReader)) {
      paramReader1 = new BufferedReader(paramReader2);
    }
    for (int i = ((Reader)localObject).read(); -1 != i; i = ((Reader)localObject).read()) {
      if (i != paramReader1.read())
      {
        AppMethodBeat.o(49764);
        return false;
      }
    }
    if (paramReader1.read() == -1)
    {
      AppMethodBeat.o(49764);
      return true;
    }
    AppMethodBeat.o(49764);
    return false;
  }
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(49755);
    long l = copyLarge(paramInputStream, paramOutputStream);
    if (l > 2147483647L)
    {
      AppMethodBeat.o(49755);
      return -1;
    }
    int i = (int)l;
    AppMethodBeat.o(49755);
    return i;
  }
  
  public static int copy(Reader paramReader, Writer paramWriter)
  {
    AppMethodBeat.i(49759);
    long l = copyLarge(paramReader, paramWriter);
    if (l > 2147483647L)
    {
      AppMethodBeat.o(49759);
      return -1;
    }
    int i = (int)l;
    AppMethodBeat.o(49759);
    return i;
  }
  
  public static void copy(InputStream paramInputStream, Writer paramWriter)
  {
    AppMethodBeat.i(49757);
    copy(new InputStreamReader(paramInputStream), paramWriter);
    AppMethodBeat.o(49757);
  }
  
  public static void copy(InputStream paramInputStream, Writer paramWriter, String paramString)
  {
    AppMethodBeat.i(49758);
    if (paramString == null)
    {
      copy(paramInputStream, paramWriter);
      AppMethodBeat.o(49758);
      return;
    }
    copy(new InputStreamReader(paramInputStream, paramString), paramWriter);
    AppMethodBeat.o(49758);
  }
  
  public static void copy(Reader paramReader, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(49761);
    paramOutputStream = new OutputStreamWriter(paramOutputStream);
    copy(paramReader, paramOutputStream);
    paramOutputStream.flush();
    AppMethodBeat.o(49761);
  }
  
  public static void copy(Reader paramReader, OutputStream paramOutputStream, String paramString)
  {
    AppMethodBeat.i(49762);
    if (paramString == null)
    {
      copy(paramReader, paramOutputStream);
      AppMethodBeat.o(49762);
      return;
    }
    paramOutputStream = new OutputStreamWriter(paramOutputStream, paramString);
    copy(paramReader, paramOutputStream);
    paramOutputStream.flush();
    AppMethodBeat.o(49762);
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(49756);
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    AppMethodBeat.o(49756);
    return l;
  }
  
  public static long copyLarge(Reader paramReader, Writer paramWriter)
  {
    AppMethodBeat.i(49760);
    char[] arrayOfChar = new char[4096];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramReader.read(arrayOfChar);
      if (-1 == i) {
        break;
      }
      paramWriter.write(arrayOfChar, 0, i);
    }
    AppMethodBeat.o(49760);
    return l;
  }
  
  public static List readLines(InputStream paramInputStream)
  {
    AppMethodBeat.i(49734);
    paramInputStream = readLines(new InputStreamReader(paramInputStream));
    AppMethodBeat.o(49734);
    return paramInputStream;
  }
  
  public static List readLines(InputStream paramInputStream, String paramString)
  {
    AppMethodBeat.i(49735);
    if (paramString == null)
    {
      paramInputStream = readLines(paramInputStream);
      AppMethodBeat.o(49735);
      return paramInputStream;
    }
    paramInputStream = readLines(new InputStreamReader(paramInputStream, paramString));
    AppMethodBeat.o(49735);
    return paramInputStream;
  }
  
  public static List readLines(Reader paramReader)
  {
    AppMethodBeat.i(49736);
    BufferedReader localBufferedReader = new BufferedReader(paramReader);
    ArrayList localArrayList = new ArrayList();
    for (paramReader = localBufferedReader.readLine(); paramReader != null; paramReader = localBufferedReader.readLine()) {
      localArrayList.add(paramReader);
    }
    AppMethodBeat.o(49736);
    return localArrayList;
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    AppMethodBeat.i(49722);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, localByteArrayOutputStream);
    paramInputStream = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(49722);
    return paramInputStream;
  }
  
  public static byte[] toByteArray(Reader paramReader)
  {
    AppMethodBeat.i(49723);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramReader, localByteArrayOutputStream);
    paramReader = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(49723);
    return paramReader;
  }
  
  public static byte[] toByteArray(Reader paramReader, String paramString)
  {
    AppMethodBeat.i(49724);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramReader, localByteArrayOutputStream, paramString);
    paramReader = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(49724);
    return paramReader;
  }
  
  public static byte[] toByteArray(String paramString)
  {
    AppMethodBeat.i(49725);
    paramString = paramString.getBytes();
    AppMethodBeat.o(49725);
    return paramString;
  }
  
  public static char[] toCharArray(InputStream paramInputStream)
  {
    AppMethodBeat.i(49726);
    CharArrayWriter localCharArrayWriter = new CharArrayWriter();
    copy(paramInputStream, localCharArrayWriter);
    paramInputStream = localCharArrayWriter.toCharArray();
    AppMethodBeat.o(49726);
    return paramInputStream;
  }
  
  public static char[] toCharArray(InputStream paramInputStream, String paramString)
  {
    AppMethodBeat.i(49727);
    CharArrayWriter localCharArrayWriter = new CharArrayWriter();
    copy(paramInputStream, localCharArrayWriter, paramString);
    paramInputStream = localCharArrayWriter.toCharArray();
    AppMethodBeat.o(49727);
    return paramInputStream;
  }
  
  public static char[] toCharArray(Reader paramReader)
  {
    AppMethodBeat.i(49728);
    CharArrayWriter localCharArrayWriter = new CharArrayWriter();
    copy(paramReader, localCharArrayWriter);
    paramReader = localCharArrayWriter.toCharArray();
    AppMethodBeat.o(49728);
    return paramReader;
  }
  
  public static InputStream toInputStream(String paramString)
  {
    AppMethodBeat.i(49738);
    paramString = new ByteArrayInputStream(paramString.getBytes());
    AppMethodBeat.o(49738);
    return paramString;
  }
  
  public static InputStream toInputStream(String paramString1, String paramString2)
  {
    AppMethodBeat.i(49739);
    if (paramString2 != null) {}
    for (paramString1 = paramString1.getBytes(paramString2);; paramString1 = paramString1.getBytes())
    {
      paramString1 = new ByteArrayInputStream(paramString1);
      AppMethodBeat.o(49739);
      return paramString1;
    }
  }
  
  public static InputStream toInputStream(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(49737);
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    AppMethodBeat.o(49737);
    return paramArrayOfByte;
  }
  
  public static String toString(InputStream paramInputStream)
  {
    AppMethodBeat.i(49729);
    StringWriter localStringWriter = new StringWriter();
    copy(paramInputStream, localStringWriter);
    paramInputStream = localStringWriter.toString();
    AppMethodBeat.o(49729);
    return paramInputStream;
  }
  
  public static String toString(InputStream paramInputStream, String paramString)
  {
    AppMethodBeat.i(49730);
    StringWriter localStringWriter = new StringWriter();
    copy(paramInputStream, localStringWriter, paramString);
    paramInputStream = localStringWriter.toString();
    AppMethodBeat.o(49730);
    return paramInputStream;
  }
  
  public static String toString(Reader paramReader)
  {
    AppMethodBeat.i(49731);
    StringWriter localStringWriter = new StringWriter();
    copy(paramReader, localStringWriter);
    paramReader = localStringWriter.toString();
    AppMethodBeat.o(49731);
    return paramReader;
  }
  
  public static String toString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(49732);
    paramArrayOfByte = new String(paramArrayOfByte);
    AppMethodBeat.o(49732);
    return paramArrayOfByte;
  }
  
  public static String toString(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(49733);
    if (paramString == null)
    {
      paramArrayOfByte = new String(paramArrayOfByte);
      AppMethodBeat.o(49733);
      return paramArrayOfByte;
    }
    paramArrayOfByte = new String(paramArrayOfByte, paramString);
    AppMethodBeat.o(49733);
    return paramArrayOfByte;
  }
  
  public static void write(String paramString, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(49747);
    if (paramString != null) {
      paramOutputStream.write(paramString.getBytes());
    }
    AppMethodBeat.o(49747);
  }
  
  public static void write(String paramString1, OutputStream paramOutputStream, String paramString2)
  {
    AppMethodBeat.i(49748);
    if (paramString1 != null)
    {
      if (paramString2 == null)
      {
        write(paramString1, paramOutputStream);
        AppMethodBeat.o(49748);
        return;
      }
      paramOutputStream.write(paramString1.getBytes(paramString2));
    }
    AppMethodBeat.o(49748);
  }
  
  public static void write(String paramString, Writer paramWriter)
  {
    AppMethodBeat.i(49746);
    if (paramString != null) {
      paramWriter.write(paramString);
    }
    AppMethodBeat.o(49746);
  }
  
  public static void write(StringBuffer paramStringBuffer, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(49750);
    if (paramStringBuffer != null) {
      paramOutputStream.write(paramStringBuffer.toString().getBytes());
    }
    AppMethodBeat.o(49750);
  }
  
  public static void write(StringBuffer paramStringBuffer, OutputStream paramOutputStream, String paramString)
  {
    AppMethodBeat.i(49751);
    if (paramStringBuffer != null)
    {
      if (paramString == null)
      {
        write(paramStringBuffer, paramOutputStream);
        AppMethodBeat.o(49751);
        return;
      }
      paramOutputStream.write(paramStringBuffer.toString().getBytes(paramString));
    }
    AppMethodBeat.o(49751);
  }
  
  public static void write(StringBuffer paramStringBuffer, Writer paramWriter)
  {
    AppMethodBeat.i(49749);
    if (paramStringBuffer != null) {
      paramWriter.write(paramStringBuffer.toString());
    }
    AppMethodBeat.o(49749);
  }
  
  public static void write(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(49740);
    if (paramArrayOfByte != null) {
      paramOutputStream.write(paramArrayOfByte);
    }
    AppMethodBeat.o(49740);
  }
  
  public static void write(byte[] paramArrayOfByte, Writer paramWriter)
  {
    AppMethodBeat.i(49741);
    if (paramArrayOfByte != null) {
      paramWriter.write(new String(paramArrayOfByte));
    }
    AppMethodBeat.o(49741);
  }
  
  public static void write(byte[] paramArrayOfByte, Writer paramWriter, String paramString)
  {
    AppMethodBeat.i(49742);
    if (paramArrayOfByte != null)
    {
      if (paramString == null)
      {
        write(paramArrayOfByte, paramWriter);
        AppMethodBeat.o(49742);
        return;
      }
      paramWriter.write(new String(paramArrayOfByte, paramString));
    }
    AppMethodBeat.o(49742);
  }
  
  public static void write(char[] paramArrayOfChar, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(49744);
    if (paramArrayOfChar != null) {
      paramOutputStream.write(new String(paramArrayOfChar).getBytes());
    }
    AppMethodBeat.o(49744);
  }
  
  public static void write(char[] paramArrayOfChar, OutputStream paramOutputStream, String paramString)
  {
    AppMethodBeat.i(49745);
    if (paramArrayOfChar != null)
    {
      if (paramString == null)
      {
        write(paramArrayOfChar, paramOutputStream);
        AppMethodBeat.o(49745);
        return;
      }
      paramOutputStream.write(new String(paramArrayOfChar).getBytes(paramString));
    }
    AppMethodBeat.o(49745);
  }
  
  public static void write(char[] paramArrayOfChar, Writer paramWriter)
  {
    AppMethodBeat.i(49743);
    if (paramArrayOfChar != null) {
      paramWriter.write(paramArrayOfChar);
    }
    AppMethodBeat.o(49743);
  }
  
  public static void writeLines(Collection paramCollection, String paramString, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(49752);
    if (paramCollection == null)
    {
      AppMethodBeat.o(49752);
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = LINE_SEPARATOR;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramString = paramCollection.next();
      if (paramString != null) {
        paramOutputStream.write(paramString.toString().getBytes());
      }
      paramOutputStream.write(str.getBytes());
    }
    AppMethodBeat.o(49752);
  }
  
  public static void writeLines(Collection paramCollection, String paramString1, OutputStream paramOutputStream, String paramString2)
  {
    AppMethodBeat.i(49753);
    if (paramString2 == null)
    {
      writeLines(paramCollection, paramString1, paramOutputStream);
      AppMethodBeat.o(49753);
      return;
    }
    if (paramCollection == null)
    {
      AppMethodBeat.o(49753);
      return;
    }
    String str = paramString1;
    if (paramString1 == null) {
      str = LINE_SEPARATOR;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramString1 = paramCollection.next();
      if (paramString1 != null) {
        paramOutputStream.write(paramString1.toString().getBytes(paramString2));
      }
      paramOutputStream.write(str.getBytes(paramString2));
    }
    AppMethodBeat.o(49753);
  }
  
  public static void writeLines(Collection paramCollection, String paramString, Writer paramWriter)
  {
    AppMethodBeat.i(49754);
    if (paramCollection == null)
    {
      AppMethodBeat.o(49754);
      return;
    }
    String str = paramString;
    if (paramString == null) {
      str = LINE_SEPARATOR;
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramString = paramCollection.next();
      if (paramString != null) {
        paramWriter.write(paramString.toString());
      }
      paramWriter.write(str);
    }
    AppMethodBeat.o(49754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.IOUtils
 * JD-Core Version:    0.7.0.1
 */