package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bwo
  extends dpc
{
  public int Mcl;
  public String Mcm;
  public int Mcn;
  public String Mco;
  public int Mcp;
  public LinkedList<dqi> Mcq;
  public String Mcr;
  public int Mcs;
  public String Mct;
  public int Mcu;
  public SKBuiltinBuffer_t Mcv;
  
  public bwo()
  {
    AppMethodBeat.i(152605);
    this.Mcq = new LinkedList();
    AppMethodBeat.o(152605);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152606);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152606);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.Mcl);
      if (this.Mcm != null) {
        paramVarArgs.e(3, this.Mcm);
      }
      paramVarArgs.aM(4, this.Mcn);
      if (this.Mco != null) {
        paramVarArgs.e(5, this.Mco);
      }
      paramVarArgs.aM(6, this.Mcp);
      paramVarArgs.e(7, 8, this.Mcq);
      if (this.Mcr != null) {
        paramVarArgs.e(8, this.Mcr);
      }
      paramVarArgs.aM(9, this.Mcs);
      if (this.Mct != null) {
        paramVarArgs.e(10, this.Mct);
      }
      paramVarArgs.aM(11, this.Mcu);
      if (this.Mcv != null)
      {
        paramVarArgs.ni(12, this.Mcv.computeSize());
        this.Mcv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152606);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1126;
      }
    }
    label1126:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.Mcl);
      paramInt = i;
      if (this.Mcm != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Mcm);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.Mcn);
      paramInt = i;
      if (this.Mco != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Mco);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.Mcp) + g.a.a.a.c(7, 8, this.Mcq);
      paramInt = i;
      if (this.Mcr != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Mcr);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.Mcs);
      paramInt = i;
      if (this.Mct != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.Mct);
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.Mcu);
      paramInt = i;
      if (this.Mcv != null) {
        paramInt = i + g.a.a.a.nh(12, this.Mcv.computeSize());
      }
      AppMethodBeat.o(152606);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mcq.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152606);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152606);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwo localbwo = (bwo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152606);
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
            localbwo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152606);
          return 0;
        case 2: 
          localbwo.Mcl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152606);
          return 0;
        case 3: 
          localbwo.Mcm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 4: 
          localbwo.Mcn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152606);
          return 0;
        case 5: 
          localbwo.Mco = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 6: 
          localbwo.Mcp = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152606);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbwo.Mcq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152606);
          return 0;
        case 8: 
          localbwo.Mcr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 9: 
          localbwo.Mcs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152606);
          return 0;
        case 10: 
          localbwo.Mct = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 11: 
          localbwo.Mcu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152606);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbwo.Mcv = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152606);
        return 0;
      }
      AppMethodBeat.o(152606);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwo
 * JD-Core Version:    0.7.0.1
 */