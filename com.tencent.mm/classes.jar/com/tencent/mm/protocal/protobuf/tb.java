package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tb
  extends com.tencent.mm.bx.a
{
  public String FQF;
  public String FQG;
  public String FQH;
  public int FQI;
  public String FQJ;
  public tg FQK;
  public String FQL;
  public int FQM;
  public int FQN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FQF != null) {
        paramVarArgs.d(1, this.FQF);
      }
      if (this.FQG != null) {
        paramVarArgs.d(2, this.FQG);
      }
      if (this.FQH != null) {
        paramVarArgs.d(3, this.FQH);
      }
      paramVarArgs.aS(4, this.FQI);
      if (this.FQJ != null) {
        paramVarArgs.d(5, this.FQJ);
      }
      if (this.FQK != null)
      {
        paramVarArgs.lC(6, this.FQK.computeSize());
        this.FQK.writeFields(paramVarArgs);
      }
      if (this.FQL != null) {
        paramVarArgs.d(7, this.FQL);
      }
      paramVarArgs.aS(8, this.FQM);
      paramVarArgs.aS(9, this.FQN);
      AppMethodBeat.o(113959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FQF == null) {
        break label754;
      }
    }
    label754:
    for (int i = f.a.a.b.b.a.e(1, this.FQF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FQG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FQG);
      }
      i = paramInt;
      if (this.FQH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FQH);
      }
      i += f.a.a.b.b.a.bz(4, this.FQI);
      paramInt = i;
      if (this.FQJ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FQJ);
      }
      i = paramInt;
      if (this.FQK != null) {
        i = paramInt + f.a.a.a.lB(6, this.FQK.computeSize());
      }
      paramInt = i;
      if (this.FQL != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FQL);
      }
      i = f.a.a.b.b.a.bz(8, this.FQM);
      int j = f.a.a.b.b.a.bz(9, this.FQN);
      AppMethodBeat.o(113959);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tb localtb = (tb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113959);
          return -1;
        case 1: 
          localtb.FQF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 2: 
          localtb.FQG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 3: 
          localtb.FQH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 4: 
          localtb.FQI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113959);
          return 0;
        case 5: 
          localtb.FQJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((tg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localtb.FQK = ((tg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113959);
          return 0;
        case 7: 
          localtb.FQL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 8: 
          localtb.FQM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113959);
          return 0;
        }
        localtb.FQN = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(113959);
        return 0;
      }
      AppMethodBeat.o(113959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tb
 * JD-Core Version:    0.7.0.1
 */