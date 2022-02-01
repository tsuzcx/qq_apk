package com.tencent.tbs.reader.external;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TbsReaderTokenAtom
  implements ITbsReaderAtom
{
  private ITbsReaderAtom a;
  
  public TbsReaderTokenAtom(ITbsReaderAtom paramITbsReaderAtom)
  {
    this.a = paramITbsReaderAtom;
  }
  
  public int getAtomType()
  {
    return 0;
  }
  
  public int init(Object paramObject)
  {
    AppMethodBeat.i(186638);
    if (this.a != null)
    {
      int i = this.a.init(paramObject);
      AppMethodBeat.o(186638);
      return i;
    }
    AppMethodBeat.o(186638);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tbs.reader.external.TbsReaderTokenAtom
 * JD-Core Version:    0.7.0.1
 */