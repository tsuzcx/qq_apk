package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ett
  extends dpc
{
  public int CreateTime;
  public int LsZ;
  public long Lta;
  public int NqJ;
  public String NqS;
  public LinkedList<euv> NqT;
  public int gsq;
  
  public ett()
  {
    AppMethodBeat.i(115879);
    this.NqT = new LinkedList();
    AppMethodBeat.o(115879);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115880);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115880);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LsZ);
      paramVarArgs.bb(3, this.Lta);
      paramVarArgs.aM(4, this.CreateTime);
      paramVarArgs.aM(6, this.gsq);
      paramVarArgs.e(7, 8, this.NqT);
      if (this.NqS != null) {
        paramVarArgs.e(8, this.NqS);
      }
      paramVarArgs.aM(9, this.NqJ);
      AppMethodBeat.o(115880);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.b.b.a.bu(4, this.CreateTime) + g.a.a.b.b.a.bu(6, this.gsq) + g.a.a.a.c(7, 8, this.NqT);
      paramInt = i;
      if (this.NqS != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.NqS);
      }
      i = g.a.a.b.b.a.bu(9, this.NqJ);
      AppMethodBeat.o(115880);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NqT.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ett localett = (ett)paramVarArgs[1];
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
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localett.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115880);
          return 0;
        case 2: 
          localett.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115880);
          return 0;
        case 3: 
          localett.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115880);
          return 0;
        case 4: 
          localett.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115880);
          return 0;
        case 6: 
          localett.gsq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115880);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new euv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((euv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localett.NqT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115880);
          return 0;
        case 8: 
          localett.NqS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(115880);
          return 0;
        }
        localett.NqJ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115880);
        return 0;
      }
      AppMethodBeat.o(115880);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ett
 * JD-Core Version:    0.7.0.1
 */