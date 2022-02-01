package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class am
  extends ckq
{
  public String CtT;
  public String CtU;
  public int CtV;
  public LinkedList<rb> CtY;
  public int dye;
  
  public am()
  {
    AppMethodBeat.i(113924);
    this.CtY = new LinkedList();
    AppMethodBeat.o(113924);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.CtY);
      paramVarArgs.aR(3, this.dye);
      if (this.CtT != null) {
        paramVarArgs.d(4, this.CtT);
      }
      if (this.CtU != null) {
        paramVarArgs.d(5, this.CtU);
      }
      paramVarArgs.aR(6, this.CtV);
      AppMethodBeat.o(113925);
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
      int i = paramInt + f.a.a.a.c(2, 8, this.CtY) + f.a.a.b.b.a.bA(3, this.dye);
      paramInt = i;
      if (this.CtT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CtT);
      }
      i = paramInt;
      if (this.CtU != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CtU);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.CtV);
      AppMethodBeat.o(113925);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CtY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(113925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        am localam = (am)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113925);
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
            localam.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113925);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localam.CtY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113925);
          return 0;
        case 3: 
          localam.dye = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(113925);
          return 0;
        case 4: 
          localam.CtT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113925);
          return 0;
        case 5: 
          localam.CtU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(113925);
          return 0;
        }
        localam.CtV = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(113925);
        return 0;
      }
      AppMethodBeat.o(113925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.am
 * JD-Core Version:    0.7.0.1
 */