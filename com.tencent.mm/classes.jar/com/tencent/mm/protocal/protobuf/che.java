package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class che
  extends dpc
{
  public ys MmA;
  public fck MmB;
  public dfy MmC;
  public bh MmD;
  public cxi MmE;
  public cgz Mmz;
  public String dNI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123625);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123625);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Mmz != null)
      {
        paramVarArgs.ni(2, this.Mmz.computeSize());
        this.Mmz.writeFields(paramVarArgs);
      }
      if (this.MmA != null)
      {
        paramVarArgs.ni(3, this.MmA.computeSize());
        this.MmA.writeFields(paramVarArgs);
      }
      if (this.MmB != null)
      {
        paramVarArgs.ni(4, this.MmB.computeSize());
        this.MmB.writeFields(paramVarArgs);
      }
      if (this.MmC != null)
      {
        paramVarArgs.ni(5, this.MmC.computeSize());
        this.MmC.writeFields(paramVarArgs);
      }
      if (this.MmD != null)
      {
        paramVarArgs.ni(6, this.MmD.computeSize());
        this.MmD.writeFields(paramVarArgs);
      }
      if (this.MmE != null)
      {
        paramVarArgs.ni(7, this.MmE.computeSize());
        this.MmE.writeFields(paramVarArgs);
      }
      if (this.dNI != null) {
        paramVarArgs.e(8, this.dNI);
      }
      AppMethodBeat.o(123625);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1350;
      }
    }
    label1350:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mmz != null) {
        paramInt = i + g.a.a.a.nh(2, this.Mmz.computeSize());
      }
      i = paramInt;
      if (this.MmA != null) {
        i = paramInt + g.a.a.a.nh(3, this.MmA.computeSize());
      }
      paramInt = i;
      if (this.MmB != null) {
        paramInt = i + g.a.a.a.nh(4, this.MmB.computeSize());
      }
      i = paramInt;
      if (this.MmC != null) {
        i = paramInt + g.a.a.a.nh(5, this.MmC.computeSize());
      }
      paramInt = i;
      if (this.MmD != null) {
        paramInt = i + g.a.a.a.nh(6, this.MmD.computeSize());
      }
      i = paramInt;
      if (this.MmE != null) {
        i = paramInt + g.a.a.a.nh(7, this.MmE.computeSize());
      }
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.dNI);
      }
      AppMethodBeat.o(123625);
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
          AppMethodBeat.o(123625);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123625);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        che localche = (che)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123625);
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
            localche.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localche.Mmz = ((cgz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ys();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ys)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localche.MmA = ((ys)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fck();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fck)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localche.MmB = ((fck)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localche.MmC = ((dfy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localche.MmD = ((bh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localche.MmE = ((cxi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        }
        localche.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123625);
        return 0;
      }
      AppMethodBeat.o(123625);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.che
 * JD-Core Version:    0.7.0.1
 */