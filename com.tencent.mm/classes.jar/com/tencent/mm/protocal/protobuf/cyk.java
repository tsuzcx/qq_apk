package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyk
  extends cld
{
  public int Ctq;
  public String Emn;
  public int EnI;
  public long Eql;
  public int Eqx;
  public LinkedList<cyi> Eqy;
  
  public cyk()
  {
    AppMethodBeat.i(118450);
    this.Eqy = new LinkedList();
    AppMethodBeat.o(118450);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118451);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118451);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Emn != null) {
        paramVarArgs.d(2, this.Emn);
      }
      paramVarArgs.aR(3, this.Eqx);
      paramVarArgs.e(4, 8, this.Eqy);
      paramVarArgs.aR(5, this.EnI);
      paramVarArgs.aG(6, this.Eql);
      paramVarArgs.aR(7, this.Ctq);
      AppMethodBeat.o(118451);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Emn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Emn);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.Eqx);
      int j = f.a.a.a.c(4, 8, this.Eqy);
      int k = f.a.a.b.b.a.bA(5, this.EnI);
      int m = f.a.a.b.b.a.q(6, this.Eql);
      int n = f.a.a.b.b.a.bA(7, this.Ctq);
      AppMethodBeat.o(118451);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Eqy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118451);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118451);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cyk localcyk = (cyk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118451);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118451);
          return 0;
        case 2: 
          localcyk.Emn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118451);
          return 0;
        case 3: 
          localcyk.Eqx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118451);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyk.Eqy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118451);
          return 0;
        case 5: 
          localcyk.EnI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118451);
          return 0;
        case 6: 
          localcyk.Eql = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(118451);
          return 0;
        }
        localcyk.Ctq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118451);
        return 0;
      }
      AppMethodBeat.o(118451);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyk
 * JD-Core Version:    0.7.0.1
 */