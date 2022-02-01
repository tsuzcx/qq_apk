package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class alz
  extends dpc
{
  public LinkedList<cgi> Lhs;
  public dfb LuC;
  public String LuD;
  public String LuE;
  public String LuF;
  public String LuG;
  public float LuH;
  public String LuI;
  public int sPV;
  public String sPW;
  
  public alz()
  {
    AppMethodBeat.i(104361);
    this.Lhs = new LinkedList();
    AppMethodBeat.o(104361);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104362);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104362);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Lhs);
      if (this.LuC != null)
      {
        paramVarArgs.ni(3, this.LuC.computeSize());
        this.LuC.writeFields(paramVarArgs);
      }
      if (this.LuD != null) {
        paramVarArgs.e(4, this.LuD);
      }
      if (this.LuE != null) {
        paramVarArgs.e(5, this.LuE);
      }
      if (this.LuF != null) {
        paramVarArgs.e(6, this.LuF);
      }
      if (this.LuG != null) {
        paramVarArgs.e(7, this.LuG);
      }
      paramVarArgs.E(8, this.LuH);
      paramVarArgs.aM(9, this.sPV);
      if (this.sPW != null) {
        paramVarArgs.e(10, this.sPW);
      }
      if (this.LuI != null) {
        paramVarArgs.e(11, this.LuI);
      }
      AppMethodBeat.o(104362);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1113;
      }
    }
    label1113:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Lhs);
      paramInt = i;
      if (this.LuC != null) {
        paramInt = i + g.a.a.a.nh(3, this.LuC.computeSize());
      }
      i = paramInt;
      if (this.LuD != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.LuD);
      }
      paramInt = i;
      if (this.LuE != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LuE);
      }
      i = paramInt;
      if (this.LuF != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.LuF);
      }
      paramInt = i;
      if (this.LuG != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LuG);
      }
      i = paramInt + (g.a.a.b.b.a.fS(8) + 4) + g.a.a.b.b.a.bu(9, this.sPV);
      paramInt = i;
      if (this.sPW != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.sPW);
      }
      i = paramInt;
      if (this.LuI != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.LuI);
      }
      AppMethodBeat.o(104362);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Lhs.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104362);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104362);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        alz localalz = (alz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104362);
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
            localalz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localalz.Lhs.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localalz.LuC = ((dfb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 4: 
          localalz.LuD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 5: 
          localalz.LuE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 6: 
          localalz.LuF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 7: 
          localalz.LuG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 8: 
          localalz.LuH = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(104362);
          return 0;
        case 9: 
          localalz.sPV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104362);
          return 0;
        case 10: 
          localalz.sPW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104362);
          return 0;
        }
        localalz.LuI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(104362);
        return 0;
      }
      AppMethodBeat.o(104362);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alz
 * JD-Core Version:    0.7.0.1
 */