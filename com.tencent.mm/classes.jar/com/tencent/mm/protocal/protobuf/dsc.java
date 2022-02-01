package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dsc
  extends cvp
{
  public String GUq;
  public int Gwu;
  public int Gwv;
  public int Gww;
  public int Gwx;
  public String Gwy;
  public int Gwz;
  
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GUq != null) {
        paramVarArgs.d(2, this.GUq);
      }
      if (this.Gwy != null) {
        paramVarArgs.d(3, this.Gwy);
      }
      paramVarArgs.aS(4, this.Gwx);
      paramVarArgs.aS(5, this.Gwu);
      paramVarArgs.aS(6, this.Gwv);
      paramVarArgs.aS(7, this.Gww);
      paramVarArgs.aS(8, this.Gwz);
      AppMethodBeat.o(101834);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label714;
      }
    }
    label714:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GUq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GUq);
      }
      i = paramInt;
      if (this.Gwy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gwy);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.Gwx);
      int j = f.a.a.b.b.a.bz(5, this.Gwu);
      int k = f.a.a.b.b.a.bz(6, this.Gwv);
      int m = f.a.a.b.b.a.bz(7, this.Gww);
      int n = f.a.a.b.b.a.bz(8, this.Gwz);
      AppMethodBeat.o(101834);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        dsc localdsc = (dsc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101834);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdsc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101834);
          return 0;
        case 2: 
          localdsc.GUq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101834);
          return 0;
        case 3: 
          localdsc.Gwy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101834);
          return 0;
        case 4: 
          localdsc.Gwx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101834);
          return 0;
        case 5: 
          localdsc.Gwu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101834);
          return 0;
        case 6: 
          localdsc.Gwv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101834);
          return 0;
        case 7: 
          localdsc.Gww = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101834);
          return 0;
        }
        localdsc.Gwz = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(101834);
        return 0;
      }
      AppMethodBeat.o(101834);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsc
 * JD-Core Version:    0.7.0.1
 */