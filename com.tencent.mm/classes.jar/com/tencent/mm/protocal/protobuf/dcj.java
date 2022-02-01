package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dcj
  extends esc
{
  public String YRQ;
  public elf YRW;
  public String ZpD;
  public String ZpE;
  public int ZpF;
  public cam ZpG;
  public ow ZpH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124518);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124518);
        throw paramVarArgs;
      }
      if (this.YRW == null)
      {
        paramVarArgs = new b("Not all required fields were included: qy_base_resp");
        AppMethodBeat.o(124518);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YRW != null)
      {
        paramVarArgs.qD(2, this.YRW.computeSize());
        this.YRW.writeFields(paramVarArgs);
      }
      if (this.YRQ != null) {
        paramVarArgs.g(3, this.YRQ);
      }
      paramVarArgs.bS(4, this.ZpF);
      if (this.ZpG != null)
      {
        paramVarArgs.qD(5, this.ZpG.computeSize());
        this.ZpG.writeFields(paramVarArgs);
      }
      if (this.ZpH != null)
      {
        paramVarArgs.qD(6, this.ZpH.computeSize());
        this.ZpH.writeFields(paramVarArgs);
      }
      if (this.ZpD != null) {
        paramVarArgs.g(7, this.ZpD);
      }
      if (this.ZpE != null) {
        paramVarArgs.g(8, this.ZpE);
      }
      AppMethodBeat.o(124518);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1006;
      }
    }
    label1006:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YRW != null) {
        paramInt = i + i.a.a.a.qC(2, this.YRW.computeSize());
      }
      i = paramInt;
      if (this.YRQ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YRQ);
      }
      i += i.a.a.b.b.a.cJ(4, this.ZpF);
      paramInt = i;
      if (this.ZpG != null) {
        paramInt = i + i.a.a.a.qC(5, this.ZpG.computeSize());
      }
      i = paramInt;
      if (this.ZpH != null) {
        i = paramInt + i.a.a.a.qC(6, this.ZpH.computeSize());
      }
      paramInt = i;
      if (this.ZpD != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZpD);
      }
      i = paramInt;
      if (this.ZpE != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.ZpE);
      }
      AppMethodBeat.o(124518);
      return i;
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
          AppMethodBeat.o(124518);
          throw paramVarArgs;
        }
        if (this.YRW == null)
        {
          paramVarArgs = new b("Not all required fields were included: qy_base_resp");
          AppMethodBeat.o(124518);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124518);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dcj localdcj = (dcj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124518);
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
            localdcj.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new elf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((elf)localObject2).parseFrom((byte[])localObject1);
            }
            localdcj.YRW = ((elf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 3: 
          localdcj.YRQ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124518);
          return 0;
        case 4: 
          localdcj.ZpF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124518);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cam();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cam)localObject2).parseFrom((byte[])localObject1);
            }
            localdcj.ZpG = ((cam)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ow();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ow)localObject2).parseFrom((byte[])localObject1);
            }
            localdcj.ZpH = ((ow)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 7: 
          localdcj.ZpD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124518);
          return 0;
        }
        localdcj.ZpE = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(124518);
        return 0;
      }
      AppMethodBeat.o(124518);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcj
 * JD-Core Version:    0.7.0.1
 */