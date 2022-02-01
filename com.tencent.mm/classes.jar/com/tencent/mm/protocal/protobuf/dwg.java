package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwg
  extends com.tencent.mm.bx.a
{
  public dwf EKf;
  public LinkedList<Integer> EKg;
  public int EKh;
  public int EKi;
  public LinkedList<Integer> EzL;
  
  public dwg()
  {
    AppMethodBeat.i(153338);
    this.EKg = new LinkedList();
    this.EzL = new LinkedList();
    AppMethodBeat.o(153338);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153339);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EKf != null)
      {
        paramVarArgs.kX(1, this.EKf.computeSize());
        this.EKf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.EKg);
      paramVarArgs.e(3, 2, this.EzL);
      paramVarArgs.aR(4, this.EKh);
      paramVarArgs.aR(5, this.EKi);
      AppMethodBeat.o(153339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EKf == null) {
        break label528;
      }
    }
    label528:
    for (paramInt = f.a.a.a.kW(1, this.EKf.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 2, this.EKg);
      int j = f.a.a.a.c(3, 2, this.EzL);
      int k = f.a.a.b.b.a.bA(4, this.EKh);
      int m = f.a.a.b.b.a.bA(5, this.EKi);
      AppMethodBeat.o(153339);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EKg.clear();
        this.EzL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwg localdwg = (dwg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153339);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dwf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwg.EKf = ((dwf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153339);
          return 0;
        case 2: 
          localdwg.EKg.add(Integer.valueOf(((f.a.a.a.a)localObject1).KhF.xS()));
          AppMethodBeat.o(153339);
          return 0;
        case 3: 
          localdwg.EzL.add(Integer.valueOf(((f.a.a.a.a)localObject1).KhF.xS()));
          AppMethodBeat.o(153339);
          return 0;
        case 4: 
          localdwg.EKh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(153339);
          return 0;
        }
        localdwg.EKi = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(153339);
        return 0;
      }
      AppMethodBeat.o(153339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwg
 * JD-Core Version:    0.7.0.1
 */