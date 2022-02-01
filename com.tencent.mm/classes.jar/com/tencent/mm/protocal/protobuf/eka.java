package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eka
  extends com.tencent.mm.bw.a
{
  public LinkedList<Integer> Ibs;
  public ejt ImM;
  public String Ine;
  public int Inf;
  public int Ing;
  
  public eka()
  {
    AppMethodBeat.i(153345);
    this.Ibs = new LinkedList();
    AppMethodBeat.o(153345);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153346);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ImM != null)
      {
        paramVarArgs.lJ(1, this.ImM.computeSize());
        this.ImM.writeFields(paramVarArgs);
      }
      if (this.Ine != null) {
        paramVarArgs.d(2, this.Ine);
      }
      paramVarArgs.e(3, 2, this.Ibs);
      paramVarArgs.aS(4, this.Inf);
      paramVarArgs.aS(5, this.Ing);
      AppMethodBeat.o(153346);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ImM == null) {
        break label525;
      }
    }
    label525:
    for (paramInt = f.a.a.a.lI(1, this.ImM.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ine != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ine);
      }
      paramInt = f.a.a.a.c(3, 2, this.Ibs);
      int j = f.a.a.b.b.a.bz(4, this.Inf);
      int k = f.a.a.b.b.a.bz(5, this.Ing);
      AppMethodBeat.o(153346);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ibs.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153346);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eka localeka = (eka)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153346);
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
            localeka.ImM = ((ejt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153346);
          return 0;
        case 2: 
          localeka.Ine = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153346);
          return 0;
        case 3: 
          localeka.Ibs.add(Integer.valueOf(((f.a.a.a.a)localObject1).OmT.zc()));
          AppMethodBeat.o(153346);
          return 0;
        case 4: 
          localeka.Inf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153346);
          return 0;
        }
        localeka.Ing = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(153346);
        return 0;
      }
      AppMethodBeat.o(153346);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eka
 * JD-Core Version:    0.7.0.1
 */