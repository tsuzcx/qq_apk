package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fzh
  extends com.tencent.mm.bx.a
{
  public String YWC;
  public gol abRI;
  public int abWG;
  public int oOu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148667);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abRI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(148667);
        throw paramVarArgs;
      }
      if (this.abRI != null)
      {
        paramVarArgs.qD(1, this.abRI.computeSize());
        this.abRI.writeFields(paramVarArgs);
      }
      if (this.YWC != null) {
        paramVarArgs.g(2, this.YWC);
      }
      paramVarArgs.bS(3, this.oOu);
      paramVarArgs.bS(4, this.abWG);
      AppMethodBeat.o(148667);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abRI == null) {
        break label484;
      }
    }
    label484:
    for (paramInt = i.a.a.a.qC(1, this.abRI.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YWC != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YWC);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.oOu);
      int j = i.a.a.b.b.a.cJ(4, this.abWG);
      AppMethodBeat.o(148667);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abRI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(148667);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148667);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fzh localfzh = (fzh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148667);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gol localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localfzh.abRI = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(148667);
          return 0;
        case 2: 
          localfzh.YWC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(148667);
          return 0;
        case 3: 
          localfzh.oOu = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(148667);
          return 0;
        }
        localfzh.abWG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(148667);
        return 0;
      }
      AppMethodBeat.o(148667);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fzh
 * JD-Core Version:    0.7.0.1
 */