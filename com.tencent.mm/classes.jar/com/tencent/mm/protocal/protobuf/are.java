package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class are
  extends cld
{
  public boolean DrI;
  public int DrJ;
  public int DrK;
  public rc DrL;
  public boolean DrM;
  public int ntx;
  public String nty;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114007);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114007);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      paramVarArgs.bg(4, this.DrI);
      paramVarArgs.aR(5, this.DrJ);
      paramVarArgs.aR(6, this.DrK);
      if (this.DrL != null)
      {
        paramVarArgs.kX(7, this.DrL.computeSize());
        this.DrL.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(8, this.DrM);
      AppMethodBeat.o(114007);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + (f.a.a.b.b.a.fY(4) + 1) + f.a.a.b.b.a.bA(5, this.DrJ) + f.a.a.b.b.a.bA(6, this.DrK);
      paramInt = i;
      if (this.DrL != null) {
        paramInt = i + f.a.a.a.kW(7, this.DrL.computeSize());
      }
      i = f.a.a.b.b.a.fY(8);
      AppMethodBeat.o(114007);
      return paramInt + (i + 1);
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
          AppMethodBeat.o(114007);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114007);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        are localare = (are)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114007);
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
            localare.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114007);
          return 0;
        case 2: 
          localare.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114007);
          return 0;
        case 3: 
          localare.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114007);
          return 0;
        case 4: 
          localare.DrI = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(114007);
          return 0;
        case 5: 
          localare.DrJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114007);
          return 0;
        case 6: 
          localare.DrK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114007);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localare.DrL = ((rc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114007);
          return 0;
        }
        localare.DrM = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(114007);
        return 0;
      }
      AppMethodBeat.o(114007);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.are
 * JD-Core Version:    0.7.0.1
 */