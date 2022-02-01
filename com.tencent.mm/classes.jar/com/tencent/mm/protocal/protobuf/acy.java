package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acy
  extends com.tencent.mm.bw.a
{
  public cqm EdD;
  public String EvH;
  public String EvI;
  public int EvJ;
  public String EvK;
  public String ncR;
  public String thh;
  public int tiE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117866);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EdD != null)
      {
        paramVarArgs.ln(1, this.EdD.computeSize());
        this.EdD.writeFields(paramVarArgs);
      }
      if (this.thh != null) {
        paramVarArgs.d(2, this.thh);
      }
      if (this.EvH != null) {
        paramVarArgs.d(3, this.EvH);
      }
      paramVarArgs.aR(4, this.tiE);
      if (this.ncR != null) {
        paramVarArgs.d(5, this.ncR);
      }
      if (this.EvI != null) {
        paramVarArgs.d(6, this.EvI);
      }
      paramVarArgs.aR(7, this.EvJ);
      if (this.EvK != null) {
        paramVarArgs.d(8, this.EvK);
      }
      AppMethodBeat.o(117866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EdD == null) {
        break label706;
      }
    }
    label706:
    for (int i = f.a.a.a.lm(1, this.EdD.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.thh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.thh);
      }
      i = paramInt;
      if (this.EvH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EvH);
      }
      i += f.a.a.b.b.a.bx(4, this.tiE);
      paramInt = i;
      if (this.ncR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ncR);
      }
      i = paramInt;
      if (this.EvI != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.EvI);
      }
      i += f.a.a.b.b.a.bx(7, this.EvJ);
      paramInt = i;
      if (this.EvK != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EvK);
      }
      AppMethodBeat.o(117866);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117866);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        acy localacy = (acy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117866);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cqm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacy.EdD = ((cqm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117866);
          return 0;
        case 2: 
          localacy.thh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 3: 
          localacy.EvH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 4: 
          localacy.tiE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117866);
          return 0;
        case 5: 
          localacy.ncR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 6: 
          localacy.EvI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 7: 
          localacy.EvJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117866);
          return 0;
        }
        localacy.EvK = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117866);
        return 0;
      }
      AppMethodBeat.o(117866);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acy
 * JD-Core Version:    0.7.0.1
 */