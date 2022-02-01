package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class iw
  extends com.tencent.mm.bx.a
{
  public int CCC;
  public int CEo;
  public LinkedList<String> CEp;
  public int ReqType;
  
  public iw()
  {
    AppMethodBeat.i(104755);
    this.CEp = new LinkedList();
    AppMethodBeat.o(104755);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104756);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CEo);
      paramVarArgs.aR(2, this.ReqType);
      paramVarArgs.e(3, 1, this.CEp);
      paramVarArgs.aR(4, this.CCC);
      AppMethodBeat.o(104756);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.CEo);
      int i = f.a.a.b.b.a.bA(2, this.ReqType);
      int j = f.a.a.a.c(3, 1, this.CEp);
      int k = f.a.a.b.b.a.bA(4, this.CCC);
      AppMethodBeat.o(104756);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CEp.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(104756);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      iw localiw = (iw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104756);
        return -1;
      case 1: 
        localiw.CEo = locala.KhF.xS();
        AppMethodBeat.o(104756);
        return 0;
      case 2: 
        localiw.ReqType = locala.KhF.xS();
        AppMethodBeat.o(104756);
        return 0;
      case 3: 
        localiw.CEp.add(locala.KhF.readString());
        AppMethodBeat.o(104756);
        return 0;
      }
      localiw.CCC = locala.KhF.xS();
      AppMethodBeat.o(104756);
      return 0;
    }
    AppMethodBeat.o(104756);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iw
 * JD-Core Version:    0.7.0.1
 */