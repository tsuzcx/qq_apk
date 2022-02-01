package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  private static final String[] Rbc = { "${sdFrom}/MicroMsg/xlog", "${sdTo}/MicroMsg/${accountSalt}/bizmsg", "${sdFrom}/MicroMsg/${accountSalt}/bizmsg", "${sdFrom}/MicroMsg/${accountSalt}/sfs", "${sdTo}/MicroMsg/${accountSalt}/sfs", "${sdFrom}/MicroMsg/wxavideocache", "${sdTo}/MicroMsg/wxavideocache", "${sdFrom}/MicroMsg/wxvideocache", "${sdTo}/MicroMsg/wxvideocache", "${sdTo}/MicroMsg/${accountSalt}/backup", "${sdFrom}/MicroMsg/${accountSalt}/backup" };
  
  static void a(g.a parama)
  {
    AppMethodBeat.i(197204);
    FileSystem[] arrayOfFileSystem = new FileSystem[Rbc.length];
    int i = 0;
    while (i < arrayOfFileSystem.length)
    {
      arrayOfFileSystem[i] = new DeleteAllFileSystem(new NativeFileSystem(Rbc[i]));
      i += 1;
    }
    parama.b("@CleanRubbish", new MaintenanceGroup(arrayOfFileSystem));
    AppMethodBeat.o(197204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.b
 * JD-Core Version:    0.7.0.1
 */