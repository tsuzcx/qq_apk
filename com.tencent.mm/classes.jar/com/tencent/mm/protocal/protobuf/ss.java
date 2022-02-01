package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ss
  extends com.tencent.mm.bx.a
{
  public String FPG;
  public String FPH;
  public String FPI;
  public int FPJ;
  public tg FPK;
  public int FPL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113950);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FPG != null) {
        paramVarArgs.d(1, this.FPG);
      }
      if (this.FPH != null) {
        paramVarArgs.d(2, this.FPH);
      }
      if (this.FPI != null) {
        paramVarArgs.d(3, this.FPI);
      }
      paramVarArgs.aS(4, this.FPJ);
      if (this.FPK != null)
      {
        paramVarArgs.lC(5, this.FPK.computeSize());
        this.FPK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.FPL);
      AppMethodBeat.o(113950);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FPG == null) {
        break label582;
      }
    }
    label582:
    for (int i = f.a.a.b.b.a.e(1, this.FPG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FPH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FPH);
      }
      i = paramInt;
      if (this.FPI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FPI);
      }
      i += f.a.a.b.b.a.bz(4, this.FPJ);
      paramInt = i;
      if (this.FPK != null) {
        paramInt = i + f.a.a.a.lB(5, this.FPK.computeSize());
      }
      i = f.a.a.b.b.a.bz(6, this.FPL);
      AppMethodBeat.o(113950);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113950);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ss localss = (ss)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113950);
          return -1;
        case 1: 
          localss.FPG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 2: 
          localss.FPH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 3: 
          localss.FPI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113950);
          return 0;
        case 4: 
          localss.FPJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113950);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((tg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localss.FPK = ((tg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113950);
          return 0;
        }
        localss.FPL = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(113950);
        return 0;
      }
      AppMethodBeat.o(113950);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ss
 * JD-Core Version:    0.7.0.1
 */