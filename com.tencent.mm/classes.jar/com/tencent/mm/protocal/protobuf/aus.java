package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aus
  extends cvp
{
  public String GsR;
  public String GsS;
  public ebj GsX;
  public int qel;
  public String qem;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91474);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91474);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GsR != null) {
        paramVarArgs.d(2, this.GsR);
      }
      if (this.GsS != null) {
        paramVarArgs.d(3, this.GsS);
      }
      paramVarArgs.aS(4, this.qel);
      if (this.qem != null) {
        paramVarArgs.d(5, this.qem);
      }
      if (this.GsX != null)
      {
        paramVarArgs.lC(6, this.GsX.computeSize());
        this.GsX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91474);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label738;
      }
    }
    label738:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GsR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GsR);
      }
      i = paramInt;
      if (this.GsS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GsS);
      }
      i += f.a.a.b.b.a.bz(4, this.qel);
      paramInt = i;
      if (this.qem != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.qem);
      }
      i = paramInt;
      if (this.GsX != null) {
        i = paramInt + f.a.a.a.lB(6, this.GsX.computeSize());
      }
      AppMethodBeat.o(91474);
      return i;
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
          AppMethodBeat.o(91474);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91474);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aus localaus = (aus)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91474);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaus.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91474);
          return 0;
        case 2: 
          localaus.GsR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91474);
          return 0;
        case 3: 
          localaus.GsS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91474);
          return 0;
        case 4: 
          localaus.qel = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91474);
          return 0;
        case 5: 
          localaus.qem = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91474);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ebj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaus.GsX = ((ebj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91474);
        return 0;
      }
      AppMethodBeat.o(91474);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aus
 * JD-Core Version:    0.7.0.1
 */