package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cej
  extends cvw
{
  public int FXt;
  public int Hrh;
  public LinkedList<cel> Hri;
  public LinkedList<cei> Hrj;
  
  public cej()
  {
    AppMethodBeat.i(6413);
    this.Hri = new LinkedList();
    this.Hrj = new LinkedList();
    AppMethodBeat.o(6413);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6414);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Hrh);
      paramVarArgs.aS(3, this.FXt);
      paramVarArgs.e(4, 8, this.Hri);
      paramVarArgs.e(5, 8, this.Hrj);
      AppMethodBeat.o(6414);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label697;
      }
    }
    label697:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Hrh);
      int j = f.a.a.b.b.a.bz(3, this.FXt);
      int k = f.a.a.a.c(4, 8, this.Hri);
      int m = f.a.a.a.c(5, 8, this.Hrj);
      AppMethodBeat.o(6414);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hri.clear();
        this.Hrj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(6414);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cej localcej = (cej)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6414);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcej.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6414);
          return 0;
        case 2: 
          localcej.Hrh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(6414);
          return 0;
        case 3: 
          localcej.FXt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(6414);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cel();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cel)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcej.Hri.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6414);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cei();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cei)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcej.Hrj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6414);
        return 0;
      }
      AppMethodBeat.o(6414);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cej
 * JD-Core Version:    0.7.0.1
 */