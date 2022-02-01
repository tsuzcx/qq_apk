package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bqq
  extends dpc
{
  public int LUO;
  public ue LYh;
  public uj LYk;
  public ug LYl;
  public String LYm;
  public int pTZ;
  public String pUa;
  public int qGg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201346);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(201346);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      if (this.LYk != null)
      {
        paramVarArgs.ni(4, this.LYk.computeSize());
        this.LYk.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.qGg);
      paramVarArgs.aM(6, this.LUO);
      if (this.LYl != null)
      {
        paramVarArgs.ni(7, this.LYl.computeSize());
        this.LYl.writeFields(paramVarArgs);
      }
      if (this.LYh != null)
      {
        paramVarArgs.ni(8, this.LYh.computeSize());
        this.LYh.writeFields(paramVarArgs);
      }
      if (this.LYm != null) {
        paramVarArgs.e(9, this.LYm);
      }
      AppMethodBeat.o(201346);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1078;
      }
    }
    label1078:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt;
      if (this.LYk != null) {
        i = paramInt + g.a.a.a.nh(4, this.LYk.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(5, this.qGg) + g.a.a.b.b.a.bu(6, this.LUO);
      paramInt = i;
      if (this.LYl != null) {
        paramInt = i + g.a.a.a.nh(7, this.LYl.computeSize());
      }
      i = paramInt;
      if (this.LYh != null) {
        i = paramInt + g.a.a.a.nh(8, this.LYh.computeSize());
      }
      paramInt = i;
      if (this.LYm != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.LYm);
      }
      AppMethodBeat.o(201346);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(201346);
          throw paramVarArgs;
        }
        AppMethodBeat.o(201346);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bqq localbqq = (bqq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201346);
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
            localbqq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201346);
          return 0;
        case 2: 
          localbqq.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201346);
          return 0;
        case 3: 
          localbqq.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201346);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqq.LYk = ((uj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201346);
          return 0;
        case 5: 
          localbqq.qGg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201346);
          return 0;
        case 6: 
          localbqq.LUO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201346);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ug();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ug)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqq.LYl = ((ug)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201346);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ue();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ue)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqq.LYh = ((ue)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201346);
          return 0;
        }
        localbqq.LYm = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(201346);
        return 0;
      }
      AppMethodBeat.o(201346);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqq
 * JD-Core Version:    0.7.0.1
 */