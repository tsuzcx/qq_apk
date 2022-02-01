package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ug
  extends com.tencent.mm.cd.a
{
  public String SeO;
  public int SeP;
  public String SeQ;
  public up SeR;
  public String SeS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113956);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SeO != null) {
        paramVarArgs.f(1, this.SeO);
      }
      paramVarArgs.aY(2, this.SeP);
      if (this.SeQ != null) {
        paramVarArgs.f(3, this.SeQ);
      }
      if (this.SeR != null)
      {
        paramVarArgs.oE(4, this.SeR.computeSize());
        this.SeR.writeFields(paramVarArgs);
      }
      if (this.SeS != null) {
        paramVarArgs.f(5, this.SeS);
      }
      AppMethodBeat.o(113956);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SeO == null) {
        break label512;
      }
    }
    label512:
    for (paramInt = g.a.a.b.b.a.g(1, this.SeO) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SeP);
      paramInt = i;
      if (this.SeQ != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SeQ);
      }
      i = paramInt;
      if (this.SeR != null) {
        i = paramInt + g.a.a.a.oD(4, this.SeR.computeSize());
      }
      paramInt = i;
      if (this.SeS != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SeS);
      }
      AppMethodBeat.o(113956);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113956);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ug localug = (ug)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113956);
          return -1;
        case 1: 
          localug.SeO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113956);
          return 0;
        case 2: 
          localug.SeP = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(113956);
          return 0;
        case 3: 
          localug.SeQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113956);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            up localup = new up();
            if ((localObject != null) && (localObject.length > 0)) {
              localup.parseFrom((byte[])localObject);
            }
            localug.SeR = localup;
            paramInt += 1;
          }
          AppMethodBeat.o(113956);
          return 0;
        }
        localug.SeS = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(113956);
        return 0;
      }
      AppMethodBeat.o(113956);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ug
 * JD-Core Version:    0.7.0.1
 */