package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axu
  extends ckq
{
  public String DwA;
  public int DwB;
  public LinkedList<cmf> DwC;
  public int DwD;
  public String sed;
  
  public axu()
  {
    AppMethodBeat.i(91494);
    this.DwC = new LinkedList();
    AppMethodBeat.o(91494);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91495);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DwA != null) {
        paramVarArgs.d(2, this.DwA);
      }
      paramVarArgs.aR(3, this.DwB);
      paramVarArgs.e(4, 8, this.DwC);
      if (this.sed != null) {
        paramVarArgs.d(5, this.sed);
      }
      paramVarArgs.aR(6, this.DwD);
      AppMethodBeat.o(91495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DwA != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DwA);
      }
      i = i + f.a.a.b.b.a.bA(3, this.DwB) + f.a.a.a.c(4, 8, this.DwC);
      paramInt = i;
      if (this.sed != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.sed);
      }
      i = f.a.a.b.b.a.bA(6, this.DwD);
      AppMethodBeat.o(91495);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DwC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91495);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axu localaxu = (axu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91495);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxu.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91495);
          return 0;
        case 2: 
          localaxu.DwA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91495);
          return 0;
        case 3: 
          localaxu.DwB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91495);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxu.DwC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91495);
          return 0;
        case 5: 
          localaxu.sed = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91495);
          return 0;
        }
        localaxu.DwD = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91495);
        return 0;
      }
      AppMethodBeat.o(91495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axu
 * JD-Core Version:    0.7.0.1
 */