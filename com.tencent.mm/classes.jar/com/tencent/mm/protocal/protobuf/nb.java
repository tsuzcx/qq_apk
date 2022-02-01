package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class nb
  extends esc
{
  public int YCa;
  public int YCd;
  public gol YFI;
  public gol YJl;
  public gol YJr;
  public eto YOE;
  public String YOM;
  public etl YOP;
  public gol YOQ;
  public int YOS;
  public String YOT;
  public String YOU;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155397);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155397);
        throw paramVarArgs;
      }
      if (this.YFI == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(155397);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YOM != null) {
        paramVarArgs.g(2, this.YOM);
      }
      if (this.YFI != null)
      {
        paramVarArgs.qD(3, this.YFI.computeSize());
        this.YFI.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.YCd);
      paramVarArgs.bS(5, this.YOS);
      if (this.YOT != null) {
        paramVarArgs.g(6, this.YOT);
      }
      paramVarArgs.bS(7, this.vhk);
      if (this.YOU != null) {
        paramVarArgs.g(8, this.YOU);
      }
      if (this.YOP != null)
      {
        paramVarArgs.qD(9, this.YOP.computeSize());
        this.YOP.writeFields(paramVarArgs);
      }
      if (this.YJr != null)
      {
        paramVarArgs.qD(10, this.YJr.computeSize());
        this.YJr.writeFields(paramVarArgs);
      }
      if (this.YOQ != null)
      {
        paramVarArgs.qD(11, this.YOQ.computeSize());
        this.YOQ.writeFields(paramVarArgs);
      }
      if (this.YOE != null)
      {
        paramVarArgs.qD(12, this.YOE.computeSize());
        this.YOE.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(13, this.YCa);
      if (this.YJl != null)
      {
        paramVarArgs.qD(14, this.YJl.computeSize());
        this.YJl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155397);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1544;
      }
    }
    label1544:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YOM != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YOM);
      }
      i = paramInt;
      if (this.YFI != null) {
        i = paramInt + i.a.a.a.qC(3, this.YFI.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(4, this.YCd) + i.a.a.b.b.a.cJ(5, this.YOS);
      paramInt = i;
      if (this.YOT != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YOT);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.vhk);
      paramInt = i;
      if (this.YOU != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YOU);
      }
      i = paramInt;
      if (this.YOP != null) {
        i = paramInt + i.a.a.a.qC(9, this.YOP.computeSize());
      }
      paramInt = i;
      if (this.YJr != null) {
        paramInt = i + i.a.a.a.qC(10, this.YJr.computeSize());
      }
      i = paramInt;
      if (this.YOQ != null) {
        i = paramInt + i.a.a.a.qC(11, this.YOQ.computeSize());
      }
      paramInt = i;
      if (this.YOE != null) {
        paramInt = i + i.a.a.a.qC(12, this.YOE.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.YCa);
      paramInt = i;
      if (this.YJl != null) {
        paramInt = i + i.a.a.a.qC(14, this.YJl.computeSize());
      }
      AppMethodBeat.o(155397);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(155397);
          throw paramVarArgs;
        }
        if (this.YFI == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(155397);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155397);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        nb localnb = (nb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155397);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localnb.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 2: 
          localnb.YOM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155397);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localnb.YFI = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 4: 
          localnb.YCd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155397);
          return 0;
        case 5: 
          localnb.YOS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155397);
          return 0;
        case 6: 
          localnb.YOT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155397);
          return 0;
        case 7: 
          localnb.vhk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155397);
          return 0;
        case 8: 
          localnb.YOU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155397);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localnb.YOP = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localnb.YJr = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localnb.YOQ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eto();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eto)localObject2).parseFrom((byte[])localObject1);
            }
            localnb.YOE = ((eto)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155397);
          return 0;
        case 13: 
          localnb.YCa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155397);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localnb.YJl = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155397);
        return 0;
      }
      AppMethodBeat.o(155397);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nb
 * JD-Core Version:    0.7.0.1
 */