package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ejk
  extends com.tencent.mm.cd.a
{
  public String TaD;
  public int TxQ;
  public String Ulx;
  public int Uly;
  public int Ulz;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125773);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ulx != null) {
        paramVarArgs.f(1, this.Ulx);
      }
      paramVarArgs.aY(2, this.Uly);
      if (this.UserName != null) {
        paramVarArgs.f(3, this.UserName);
      }
      if (this.TaD != null) {
        paramVarArgs.f(4, this.TaD);
      }
      paramVarArgs.aY(5, this.TxQ);
      paramVarArgs.aY(6, this.Ulz);
      AppMethodBeat.o(125773);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ulx == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = g.a.a.b.b.a.g(1, this.Ulx) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Uly);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.UserName);
      }
      i = paramInt;
      if (this.TaD != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TaD);
      }
      paramInt = g.a.a.b.b.a.bM(5, this.TxQ);
      int j = g.a.a.b.b.a.bM(6, this.Ulz);
      AppMethodBeat.o(125773);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125773);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ejk localejk = (ejk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125773);
          return -1;
        case 1: 
          localejk.Ulx = locala.abFh.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 2: 
          localejk.Uly = locala.abFh.AK();
          AppMethodBeat.o(125773);
          return 0;
        case 3: 
          localejk.UserName = locala.abFh.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 4: 
          localejk.TaD = locala.abFh.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 5: 
          localejk.TxQ = locala.abFh.AK();
          AppMethodBeat.o(125773);
          return 0;
        }
        localejk.Ulz = locala.abFh.AK();
        AppMethodBeat.o(125773);
        return 0;
      }
      AppMethodBeat.o(125773);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejk
 * JD-Core Version:    0.7.0.1
 */