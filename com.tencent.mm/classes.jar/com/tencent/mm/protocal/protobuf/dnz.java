package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnz
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> ddt;
  public int hiV;
  public String title;
  public String url;
  
  public dnz()
  {
    AppMethodBeat.i(200604);
    this.ddt = new LinkedList();
    AppMethodBeat.o(200604);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127284);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.hiV);
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      paramVarArgs.e(4, 1, this.ddt);
      AppMethodBeat.o(127284);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.hiV) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      paramInt = f.a.a.a.c(4, 1, this.ddt);
      AppMethodBeat.o(127284);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ddt.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(127284);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dnz localdnz = (dnz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127284);
        return -1;
      case 1: 
        localdnz.hiV = locala.OmT.zc();
        AppMethodBeat.o(127284);
        return 0;
      case 2: 
        localdnz.title = locala.OmT.readString();
        AppMethodBeat.o(127284);
        return 0;
      case 3: 
        localdnz.url = locala.OmT.readString();
        AppMethodBeat.o(127284);
        return 0;
      }
      localdnz.ddt.add(locala.OmT.readString());
      AppMethodBeat.o(127284);
      return 0;
    }
    AppMethodBeat.o(127284);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnz
 * JD-Core Version:    0.7.0.1
 */