package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ebh
  extends dpc
{
  public int BsF;
  public int BsG;
  public long Id;
  public int Mts;
  public LinkedList<dzl> Mtt;
  public dzl Nba;
  public String izX;
  public int oUv;
  
  public ebh()
  {
    AppMethodBeat.i(125831);
    this.Mtt = new LinkedList();
    AppMethodBeat.o(125831);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125832);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125832);
        throw paramVarArgs;
      }
      if (this.Nba == null)
      {
        paramVarArgs = new b("Not all required fields were included: BufferUrl");
        AppMethodBeat.o(125832);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.BsG);
      paramVarArgs.aM(3, this.BsF);
      if (this.izX != null) {
        paramVarArgs.e(4, this.izX);
      }
      if (this.Nba != null)
      {
        paramVarArgs.ni(5, this.Nba.computeSize());
        this.Nba.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.Mts);
      paramVarArgs.e(7, 8, this.Mtt);
      paramVarArgs.bb(8, this.Id);
      paramVarArgs.aM(9, this.oUv);
      AppMethodBeat.o(125832);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label994;
      }
    }
    label994:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.BsG) + g.a.a.b.b.a.bu(3, this.BsF);
      paramInt = i;
      if (this.izX != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.izX);
      }
      i = paramInt;
      if (this.Nba != null) {
        i = paramInt + g.a.a.a.nh(5, this.Nba.computeSize());
      }
      paramInt = g.a.a.b.b.a.bu(6, this.Mts);
      int j = g.a.a.a.c(7, 8, this.Mtt);
      int k = g.a.a.b.b.a.r(8, this.Id);
      int m = g.a.a.b.b.a.bu(9, this.oUv);
      AppMethodBeat.o(125832);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mtt.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125832);
          throw paramVarArgs;
        }
        if (this.Nba == null)
        {
          paramVarArgs = new b("Not all required fields were included: BufferUrl");
          AppMethodBeat.o(125832);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125832);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ebh localebh = (ebh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125832);
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
            localebh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 2: 
          localebh.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125832);
          return 0;
        case 3: 
          localebh.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125832);
          return 0;
        case 4: 
          localebh.izX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125832);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebh.Nba = ((dzl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 6: 
          localebh.Mts = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125832);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebh.Mtt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125832);
          return 0;
        case 8: 
          localebh.Id = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125832);
          return 0;
        }
        localebh.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125832);
        return 0;
      }
      AppMethodBeat.o(125832);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebh
 * JD-Core Version:    0.7.0.1
 */