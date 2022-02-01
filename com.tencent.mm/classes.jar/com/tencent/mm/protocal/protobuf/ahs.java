package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.i;
import java.util.LinkedList;

public final class ahs
  extends cwj
{
  public LinkedList<i> GxD;
  public int GxE;
  public e.a.a.a GxF;
  public int oGt;
  public String oGu;
  
  public ahs()
  {
    AppMethodBeat.i(91444);
    this.GxD = new LinkedList();
    AppMethodBeat.o(91444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91445);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      paramVarArgs.e(4, 8, this.GxD);
      paramVarArgs.aS(5, this.GxE);
      if (this.GxF != null)
      {
        paramVarArgs.lJ(6, this.GxF.computeSize());
        this.GxF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.GxD) + f.a.a.b.b.a.bz(5, this.GxE);
      paramInt = i;
      if (this.GxF != null) {
        paramInt = i + f.a.a.a.lI(6, this.GxF.computeSize());
      }
      AppMethodBeat.o(91445);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GxD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ahs localahs = (ahs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91445);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localahs.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91445);
          return 0;
        case 2: 
          localahs.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91445);
          return 0;
        case 3: 
          localahs.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91445);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new i();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localahs.GxD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91445);
          return 0;
        case 5: 
          localahs.GxE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91445);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e.a.a.a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((e.a.a.a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localahs.GxF = ((e.a.a.a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91445);
        return 0;
      }
      AppMethodBeat.o(91445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahs
 * JD-Core Version:    0.7.0.1
 */