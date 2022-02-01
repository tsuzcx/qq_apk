package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ecd
  extends com.tencent.mm.bw.a
{
  public LinkedList<Integer> FWP;
  public String GhJ;
  public int GhK;
  public int GhL;
  public ebw Ghr;
  
  public ecd()
  {
    AppMethodBeat.i(153345);
    this.FWP = new LinkedList();
    AppMethodBeat.o(153345);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153346);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ghr != null)
      {
        paramVarArgs.ln(1, this.Ghr.computeSize());
        this.Ghr.writeFields(paramVarArgs);
      }
      if (this.GhJ != null) {
        paramVarArgs.d(2, this.GhJ);
      }
      paramVarArgs.e(3, 2, this.FWP);
      paramVarArgs.aR(4, this.GhK);
      paramVarArgs.aR(5, this.GhL);
      AppMethodBeat.o(153346);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ghr == null) {
        break label525;
      }
    }
    label525:
    for (paramInt = f.a.a.a.lm(1, this.Ghr.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GhJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GhJ);
      }
      paramInt = f.a.a.a.c(3, 2, this.FWP);
      int j = f.a.a.b.b.a.bx(4, this.GhK);
      int k = f.a.a.b.b.a.bx(5, this.GhL);
      AppMethodBeat.o(153346);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FWP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153346);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ecd localecd = (ecd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153346);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ebw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localecd.Ghr = ((ebw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153346);
          return 0;
        case 2: 
          localecd.GhJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(153346);
          return 0;
        case 3: 
          localecd.FWP.add(Integer.valueOf(((f.a.a.a.a)localObject1).LVo.xF()));
          AppMethodBeat.o(153346);
          return 0;
        case 4: 
          localecd.GhK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153346);
          return 0;
        }
        localecd.GhL = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(153346);
        return 0;
      }
      AppMethodBeat.o(153346);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecd
 * JD-Core Version:    0.7.0.1
 */