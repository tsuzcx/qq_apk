package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ciq
  extends cld
{
  public int EdW;
  public int EdZ;
  public int Eea;
  public dkz Eeb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32413);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32413);
        throw paramVarArgs;
      }
      if (this.Eeb == null)
      {
        paramVarArgs = new b("Not all required fields were included: NextPiece");
        AppMethodBeat.o(32413);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.EdZ);
      paramVarArgs.aR(3, this.Eea);
      if (this.Eeb != null)
      {
        paramVarArgs.kX(4, this.Eeb.computeSize());
        this.Eeb.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.EdW);
      AppMethodBeat.o(32413);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label705;
      }
    }
    label705:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.EdZ) + f.a.a.b.b.a.bA(3, this.Eea);
      paramInt = i;
      if (this.Eeb != null) {
        paramInt = i + f.a.a.a.kW(4, this.Eeb.computeSize());
      }
      i = f.a.a.b.b.a.bA(5, this.EdW);
      AppMethodBeat.o(32413);
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
          AppMethodBeat.o(32413);
          throw paramVarArgs;
        }
        if (this.Eeb == null)
        {
          paramVarArgs = new b("Not all required fields were included: NextPiece");
          AppMethodBeat.o(32413);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32413);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ciq localciq = (ciq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32413);
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
            localciq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32413);
          return 0;
        case 2: 
          localciq.EdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32413);
          return 0;
        case 3: 
          localciq.Eea = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32413);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localciq.Eeb = ((dkz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32413);
          return 0;
        }
        localciq.EdW = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32413);
        return 0;
      }
      AppMethodBeat.o(32413);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciq
 * JD-Core Version:    0.7.0.1
 */