package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bzf
  extends dpc
{
  public fcd Ljo;
  public int MeE;
  public LinkedList<fdl> MeR;
  public fdl MeS;
  public String MeT;
  public int MeU;
  public String MeV;
  public String MeW;
  public String MeX;
  public String MeY;
  
  public bzf()
  {
    AppMethodBeat.i(123594);
    this.MeR = new LinkedList();
    AppMethodBeat.o(123594);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123595);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123595);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Ljo != null)
      {
        paramVarArgs.ni(2, this.Ljo.computeSize());
        this.Ljo.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.MeR);
      if (this.MeS != null)
      {
        paramVarArgs.ni(4, this.MeS.computeSize());
        this.MeS.writeFields(paramVarArgs);
      }
      if (this.MeT != null) {
        paramVarArgs.e(5, this.MeT);
      }
      paramVarArgs.aM(6, this.MeU);
      if (this.MeV != null) {
        paramVarArgs.e(7, this.MeV);
      }
      if (this.MeW != null) {
        paramVarArgs.e(8, this.MeW);
      }
      if (this.MeX != null) {
        paramVarArgs.e(9, this.MeX);
      }
      if (this.MeY != null) {
        paramVarArgs.e(10, this.MeY);
      }
      paramVarArgs.aM(11, this.MeE);
      AppMethodBeat.o(123595);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1206;
      }
    }
    label1206:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ljo != null) {
        i = paramInt + g.a.a.a.nh(2, this.Ljo.computeSize());
      }
      i += g.a.a.a.c(3, 8, this.MeR);
      paramInt = i;
      if (this.MeS != null) {
        paramInt = i + g.a.a.a.nh(4, this.MeS.computeSize());
      }
      i = paramInt;
      if (this.MeT != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MeT);
      }
      i += g.a.a.b.b.a.bu(6, this.MeU);
      paramInt = i;
      if (this.MeV != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MeV);
      }
      i = paramInt;
      if (this.MeW != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.MeW);
      }
      paramInt = i;
      if (this.MeX != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MeX);
      }
      i = paramInt;
      if (this.MeY != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.MeY);
      }
      paramInt = g.a.a.b.b.a.bu(11, this.MeE);
      AppMethodBeat.o(123595);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MeR.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123595);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123595);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bzf localbzf = (bzf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123595);
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
            localbzf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fcd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fcd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbzf.Ljo = ((fcd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fdl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fdl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbzf.MeR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fdl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fdl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbzf.MeS = ((fdl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123595);
          return 0;
        case 5: 
          localbzf.MeT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 6: 
          localbzf.MeU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123595);
          return 0;
        case 7: 
          localbzf.MeV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 8: 
          localbzf.MeW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 9: 
          localbzf.MeX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123595);
          return 0;
        case 10: 
          localbzf.MeY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123595);
          return 0;
        }
        localbzf.MeE = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(123595);
        return 0;
      }
      AppMethodBeat.o(123595);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzf
 * JD-Core Version:    0.7.0.1
 */