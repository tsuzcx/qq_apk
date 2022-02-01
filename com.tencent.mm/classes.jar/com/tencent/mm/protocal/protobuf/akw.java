package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class akw
  extends esc
{
  public gol Zsd;
  public int Zse;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152537);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152537);
        throw paramVarArgs;
      }
      if (this.Zsd == null)
      {
        paramVarArgs = new b("Not all required fields were included: PackageBuf");
        AppMethodBeat.o(152537);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Zsd != null)
      {
        paramVarArgs.qD(2, this.Zsd.computeSize());
        this.Zsd.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.vhJ);
      paramVarArgs.bS(4, this.Zse);
      AppMethodBeat.o(152537);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Zsd != null) {
        i = paramInt + i.a.a.a.qC(2, this.Zsd.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.vhJ);
      int j = i.a.a.b.b.a.cJ(4, this.Zse);
      AppMethodBeat.o(152537);
      return i + paramInt + j;
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
          AppMethodBeat.o(152537);
          throw paramVarArgs;
        }
        if (this.Zsd == null)
        {
          paramVarArgs = new b("Not all required fields were included: PackageBuf");
          AppMethodBeat.o(152537);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152537);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        akw localakw = (akw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152537);
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
            localakw.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152537);
          return 0;
        case 2: 
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
            localakw.Zsd = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152537);
          return 0;
        case 3: 
          localakw.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152537);
          return 0;
        }
        localakw.Zse = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(152537);
        return 0;
      }
      AppMethodBeat.o(152537);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akw
 * JD-Core Version:    0.7.0.1
 */