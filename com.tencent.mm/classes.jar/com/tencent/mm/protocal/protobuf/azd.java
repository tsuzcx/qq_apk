package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class azd
  extends cvp
{
  public int Gwu;
  public int Gwv;
  public int Gww;
  public int Gwx;
  public String Gwy;
  public int Gwz;
  public int nDG;
  
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nDG);
      paramVarArgs.aS(3, this.Gwu);
      paramVarArgs.aS(4, this.Gwv);
      paramVarArgs.aS(5, this.Gww);
      paramVarArgs.aS(6, this.Gwx);
      if (this.Gwy != null) {
        paramVarArgs.d(7, this.Gwy);
      }
      paramVarArgs.aS(8, this.Gwz);
      AppMethodBeat.o(101813);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label682;
      }
    }
    label682:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nDG) + f.a.a.b.b.a.bz(3, this.Gwu) + f.a.a.b.b.a.bz(4, this.Gwv) + f.a.a.b.b.a.bz(5, this.Gww) + f.a.a.b.b.a.bz(6, this.Gwx);
      paramInt = i;
      if (this.Gwy != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Gwy);
      }
      i = f.a.a.b.b.a.bz(8, this.Gwz);
      AppMethodBeat.o(101813);
      return paramInt + i;
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
          AppMethodBeat.o(101813);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101813);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azd localazd = (azd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101813);
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
            localazd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101813);
          return 0;
        case 2: 
          localazd.nDG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101813);
          return 0;
        case 3: 
          localazd.Gwu = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101813);
          return 0;
        case 4: 
          localazd.Gwv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101813);
          return 0;
        case 5: 
          localazd.Gww = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101813);
          return 0;
        case 6: 
          localazd.Gwx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101813);
          return 0;
        case 7: 
          localazd.Gwy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101813);
          return 0;
        }
        localazd.Gwz = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(101813);
        return 0;
      }
      AppMethodBeat.o(101813);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azd
 * JD-Core Version:    0.7.0.1
 */