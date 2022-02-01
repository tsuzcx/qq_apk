package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebx
  extends com.tencent.mm.bw.a
{
  public LinkedList<Integer> FWP;
  public ebw Ghr;
  public LinkedList<Integer> Ghs;
  public int Ght;
  public int Ghu;
  
  public ebx()
  {
    AppMethodBeat.i(153338);
    this.Ghs = new LinkedList();
    this.FWP = new LinkedList();
    AppMethodBeat.o(153338);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153339);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ghr != null)
      {
        paramVarArgs.ln(1, this.Ghr.computeSize());
        this.Ghr.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.Ghs);
      paramVarArgs.e(3, 2, this.FWP);
      paramVarArgs.aR(4, this.Ght);
      paramVarArgs.aR(5, this.Ghu);
      AppMethodBeat.o(153339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ghr == null) {
        break label528;
      }
    }
    label528:
    for (paramInt = f.a.a.a.lm(1, this.Ghr.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 2, this.Ghs);
      int j = f.a.a.a.c(3, 2, this.FWP);
      int k = f.a.a.b.b.a.bx(4, this.Ght);
      int m = f.a.a.b.b.a.bx(5, this.Ghu);
      AppMethodBeat.o(153339);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ghs.clear();
        this.FWP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(153339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ebx localebx = (ebx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153339);
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
            localebx.Ghr = ((ebw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153339);
          return 0;
        case 2: 
          localebx.Ghs.add(Integer.valueOf(((f.a.a.a.a)localObject1).LVo.xF()));
          AppMethodBeat.o(153339);
          return 0;
        case 3: 
          localebx.FWP.add(Integer.valueOf(((f.a.a.a.a)localObject1).LVo.xF()));
          AppMethodBeat.o(153339);
          return 0;
        case 4: 
          localebx.Ght = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(153339);
          return 0;
        }
        localebx.Ghu = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(153339);
        return 0;
      }
      AppMethodBeat.o(153339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebx
 * JD-Core Version:    0.7.0.1
 */