package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class egt
  extends esc
{
  public String abmb;
  public String abmc;
  public String abmd;
  public String abme;
  public gol abmf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91631);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91631);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abmb != null) {
        paramVarArgs.g(2, this.abmb);
      }
      if (this.abmc != null) {
        paramVarArgs.g(3, this.abmc);
      }
      if (this.abmd != null) {
        paramVarArgs.g(4, this.abmd);
      }
      if (this.abme != null) {
        paramVarArgs.g(5, this.abme);
      }
      if (this.abmf != null)
      {
        paramVarArgs.qD(6, this.abmf.computeSize());
        this.abmf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91631);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abmb != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abmb);
      }
      i = paramInt;
      if (this.abmc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abmc);
      }
      paramInt = i;
      if (this.abmd != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abmd);
      }
      i = paramInt;
      if (this.abme != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abme);
      }
      paramInt = i;
      if (this.abmf != null) {
        paramInt = i + i.a.a.a.qC(6, this.abmf.computeSize());
      }
      AppMethodBeat.o(91631);
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
          AppMethodBeat.o(91631);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91631);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        egt localegt = (egt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91631);
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
            localegt.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91631);
          return 0;
        case 2: 
          localegt.abmb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91631);
          return 0;
        case 3: 
          localegt.abmc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91631);
          return 0;
        case 4: 
          localegt.abmd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91631);
          return 0;
        case 5: 
          localegt.abme = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91631);
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
          localegt.abmf = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91631);
        return 0;
      }
      AppMethodBeat.o(91631);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egt
 * JD-Core Version:    0.7.0.1
 */