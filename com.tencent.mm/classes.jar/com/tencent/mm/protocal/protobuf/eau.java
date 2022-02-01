package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eau
  extends com.tencent.mm.bw.a
{
  public String IgC;
  public String IgD;
  public LinkedList<String> IgE;
  public int IgF;
  
  public eau()
  {
    AppMethodBeat.i(147784);
    this.IgE = new LinkedList();
    AppMethodBeat.o(147784);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147785);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IgC != null) {
        paramVarArgs.d(1, this.IgC);
      }
      if (this.IgD != null) {
        paramVarArgs.d(2, this.IgD);
      }
      paramVarArgs.e(3, 1, this.IgE);
      paramVarArgs.aS(4, this.IgF);
      AppMethodBeat.o(147785);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IgC == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.IgC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IgD != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.IgD);
      }
      paramInt = f.a.a.a.c(3, 1, this.IgE);
      int j = f.a.a.b.b.a.bz(4, this.IgF);
      AppMethodBeat.o(147785);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IgE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(147785);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eau localeau = (eau)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147785);
          return -1;
        case 1: 
          localeau.IgC = locala.OmT.readString();
          AppMethodBeat.o(147785);
          return 0;
        case 2: 
          localeau.IgD = locala.OmT.readString();
          AppMethodBeat.o(147785);
          return 0;
        case 3: 
          localeau.IgE.add(locala.OmT.readString());
          AppMethodBeat.o(147785);
          return 0;
        }
        localeau.IgF = locala.OmT.zc();
        AppMethodBeat.o(147785);
        return 0;
      }
      AppMethodBeat.o(147785);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eau
 * JD-Core Version:    0.7.0.1
 */