package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dgw
  extends cld
{
  public String DOr;
  public int Dsm;
  public int Dsn;
  public int Dso;
  public int Dsp;
  public String Dsq;
  public int Dsr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101834);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101834);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DOr != null) {
        paramVarArgs.d(2, this.DOr);
      }
      if (this.Dsq != null) {
        paramVarArgs.d(3, this.Dsq);
      }
      paramVarArgs.aR(4, this.Dsp);
      paramVarArgs.aR(5, this.Dsm);
      paramVarArgs.aR(6, this.Dsn);
      paramVarArgs.aR(7, this.Dso);
      paramVarArgs.aR(8, this.Dsr);
      AppMethodBeat.o(101834);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label714;
      }
    }
    label714:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DOr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DOr);
      }
      i = paramInt;
      if (this.Dsq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Dsq);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.Dsp);
      int j = f.a.a.b.b.a.bA(5, this.Dsm);
      int k = f.a.a.b.b.a.bA(6, this.Dsn);
      int m = f.a.a.b.b.a.bA(7, this.Dso);
      int n = f.a.a.b.b.a.bA(8, this.Dsr);
      AppMethodBeat.o(101834);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(101834);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101834);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgw localdgw = (dgw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101834);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101834);
          return 0;
        case 2: 
          localdgw.DOr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101834);
          return 0;
        case 3: 
          localdgw.Dsq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101834);
          return 0;
        case 4: 
          localdgw.Dsp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101834);
          return 0;
        case 5: 
          localdgw.Dsm = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101834);
          return 0;
        case 6: 
          localdgw.Dsn = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101834);
          return 0;
        case 7: 
          localdgw.Dso = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101834);
          return 0;
        }
        localdgw.Dsr = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(101834);
        return 0;
      }
      AppMethodBeat.o(101834);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgw
 * JD-Core Version:    0.7.0.1
 */