package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class asb
  extends cld
{
  public int Dsm;
  public int Dsn;
  public int Dso;
  public int Dsp;
  public String Dsq;
  public int Dsr;
  public int mBi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101813);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101813);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.mBi);
      paramVarArgs.aR(3, this.Dsm);
      paramVarArgs.aR(4, this.Dsn);
      paramVarArgs.aR(5, this.Dso);
      paramVarArgs.aR(6, this.Dsp);
      if (this.Dsq != null) {
        paramVarArgs.d(7, this.Dsq);
      }
      paramVarArgs.aR(8, this.Dsr);
      AppMethodBeat.o(101813);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label682;
      }
    }
    label682:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mBi) + f.a.a.b.b.a.bA(3, this.Dsm) + f.a.a.b.b.a.bA(4, this.Dsn) + f.a.a.b.b.a.bA(5, this.Dso) + f.a.a.b.b.a.bA(6, this.Dsp);
      paramInt = i;
      if (this.Dsq != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Dsq);
      }
      i = f.a.a.b.b.a.bA(8, this.Dsr);
      AppMethodBeat.o(101813);
      return paramInt + i;
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
          AppMethodBeat.o(101813);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101813);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        asb localasb = (asb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101813);
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
            localasb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101813);
          return 0;
        case 2: 
          localasb.mBi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101813);
          return 0;
        case 3: 
          localasb.Dsm = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101813);
          return 0;
        case 4: 
          localasb.Dsn = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101813);
          return 0;
        case 5: 
          localasb.Dso = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101813);
          return 0;
        case 6: 
          localasb.Dsp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101813);
          return 0;
        case 7: 
          localasb.Dsq = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(101813);
          return 0;
        }
        localasb.Dsr = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(101813);
        return 0;
      }
      AppMethodBeat.o(101813);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asb
 * JD-Core Version:    0.7.0.1
 */