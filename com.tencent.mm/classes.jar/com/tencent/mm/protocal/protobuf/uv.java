package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class uv
  extends cld
{
  public String CWD;
  public String CWE;
  public int CWL;
  public long CWM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32162);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32162);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CWL);
      if (this.CWD != null) {
        paramVarArgs.d(3, this.CWD);
      }
      if (this.CWE != null) {
        paramVarArgs.d(4, this.CWE);
      }
      paramVarArgs.aG(5, this.CWM);
      AppMethodBeat.o(32162);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label581;
      }
    }
    label581:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CWL);
      paramInt = i;
      if (this.CWD != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CWD);
      }
      i = paramInt;
      if (this.CWE != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CWE);
      }
      paramInt = f.a.a.b.b.a.q(5, this.CWM);
      AppMethodBeat.o(32162);
      return i + paramInt;
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
          AppMethodBeat.o(32162);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32162);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uv localuv = (uv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32162);
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
            localuv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32162);
          return 0;
        case 2: 
          localuv.CWL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32162);
          return 0;
        case 3: 
          localuv.CWD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32162);
          return 0;
        case 4: 
          localuv.CWE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32162);
          return 0;
        }
        localuv.CWM = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(32162);
        return 0;
      }
      AppMethodBeat.o(32162);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uv
 * JD-Core Version:    0.7.0.1
 */