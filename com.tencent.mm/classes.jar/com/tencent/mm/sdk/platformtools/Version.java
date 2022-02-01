package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Version
  implements Comparable<Version>
{
  private String[] version;
  
  public Version(String paramString)
  {
    AppMethodBeat.i(200910);
    this.version = null;
    if (paramString != null) {
      this.version = paramString.split("\\.");
    }
    if ((this.version == null) || (this.version.length == 0)) {
      this.version = new String[] { paramString };
    }
    AppMethodBeat.o(200910);
  }
  
  public int compareTo(Version paramVersion)
  {
    AppMethodBeat.i(200911);
    int i = 0;
    while ((i < paramVersion.version.length) && (i < this.version.length))
    {
      int j = this.version[i].compareTo(paramVersion.version[i]);
      if (j != 0)
      {
        AppMethodBeat.o(200911);
        return j;
      }
      i += 1;
    }
    if (this.version.length > paramVersion.version.length)
    {
      i = this.version[(this.version.length - 1)].compareTo("0");
      AppMethodBeat.o(200911);
      return i;
    }
    i = "0".compareTo(paramVersion.version[(paramVersion.version.length - 1)]);
    AppMethodBeat.o(200911);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.Version
 * JD-Core Version:    0.7.0.1
 */