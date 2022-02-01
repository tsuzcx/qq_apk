package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dmk
  extends cld
{
  public int CreateTime;
  public int DdZ;
  public long Dea;
  public int EBU;
  public String ECd;
  public LinkedList<dnm> ECe;
  public int fpb;
  
  public dmk()
  {
    AppMethodBeat.i(115879);
    this.ECe = new LinkedList();
    AppMethodBeat.o(115879);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115880);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115880);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DdZ);
      paramVarArgs.aG(3, this.Dea);
      paramVarArgs.aR(4, this.CreateTime);
      paramVarArgs.aR(6, this.fpb);
      paramVarArgs.e(7, 8, this.ECe);
      if (this.ECd != null) {
        paramVarArgs.d(8, this.ECd);
      }
      paramVarArgs.aR(9, this.EBU);
      AppMethodBeat.o(115880);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DdZ) + f.a.a.b.b.a.q(3, this.Dea) + f.a.a.b.b.a.bA(4, this.CreateTime) + f.a.a.b.b.a.bA(6, this.fpb) + f.a.a.a.c(7, 8, this.ECe);
      paramInt = i;
      if (this.ECd != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ECd);
      }
      i = f.a.a.b.b.a.bA(9, this.EBU);
      AppMethodBeat.o(115880);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ECe.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115880);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115880);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmk localdmk = (dmk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(115880);
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
            localdmk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115880);
          return 0;
        case 2: 
          localdmk.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115880);
          return 0;
        case 3: 
          localdmk.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(115880);
          return 0;
        case 4: 
          localdmk.CreateTime = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115880);
          return 0;
        case 6: 
          localdmk.fpb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115880);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dnm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dnm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmk.ECe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115880);
          return 0;
        case 8: 
          localdmk.ECd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(115880);
          return 0;
        }
        localdmk.EBU = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115880);
        return 0;
      }
      AppMethodBeat.o(115880);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmk
 * JD-Core Version:    0.7.0.1
 */