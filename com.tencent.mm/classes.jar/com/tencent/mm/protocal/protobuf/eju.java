package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eju
  extends com.tencent.mm.bw.a
{
  public LinkedList<Integer> Ibs;
  public ejt ImM;
  public LinkedList<Integer> ImN;
  public int ImO;
  public int ImP;
  
  public eju()
  {
    AppMethodBeat.i(153338);
    this.ImN = new LinkedList();
    this.Ibs = new LinkedList();
    AppMethodBeat.o(153338);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153339);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ImM != null)
      {
        paramVarArgs.lJ(1, this.ImM.computeSize());
        this.ImM.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.ImN);
      paramVarArgs.e(3, 2, this.Ibs);
      paramVarArgs.aS(4, this.ImO);
      paramVarArgs.aS(5, this.ImP);
      AppMethodBeat.o(153339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ImM == null) {
        break label528;
      }
    }
    label528:
    for (paramInt = f.a.a.a.lI(1, this.ImM.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 2, this.ImN);
      int j = f.a.a.a.c(3, 2, this.Ibs);
      int k = f.a.a.b.b.a.bz(4, this.ImO);
      int m = f.a.a.b.b.a.bz(5, this.ImP);
      AppMethodBeat.o(153339);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ImN.clear();
        this.Ibs.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eju localeju = (eju)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153339);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ejt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ejt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeju.ImM = ((ejt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153339);
          return 0;
        case 2: 
          localeju.ImN.add(Integer.valueOf(((f.a.a.a.a)localObject1).OmT.zc()));
          AppMethodBeat.o(153339);
          return 0;
        case 3: 
          localeju.Ibs.add(Integer.valueOf(((f.a.a.a.a)localObject1).OmT.zc()));
          AppMethodBeat.o(153339);
          return 0;
        case 4: 
          localeju.ImO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153339);
          return 0;
        }
        localeju.ImP = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(153339);
        return 0;
      }
      AppMethodBeat.o(153339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eju
 * JD-Core Version:    0.7.0.1
 */