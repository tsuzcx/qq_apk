package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cym
  extends esc
{
  public String aaDo;
  public String aaDp;
  public flm aaxA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259324);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(259324);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaxA != null)
      {
        paramVarArgs.qD(2, this.aaxA.computeSize());
        this.aaxA.writeFields(paramVarArgs);
      }
      if (this.aaDo != null) {
        paramVarArgs.g(3, this.aaDo);
      }
      if (this.aaDp != null) {
        paramVarArgs.g(4, this.aaDp);
      }
      AppMethodBeat.o(259324);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label586;
      }
    }
    label586:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaxA != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaxA.computeSize());
      }
      i = paramInt;
      if (this.aaDo != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaDo);
      }
      paramInt = i;
      if (this.aaDp != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaDp);
      }
      AppMethodBeat.o(259324);
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
          AppMethodBeat.o(259324);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259324);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cym localcym = (cym)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259324);
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
            localcym.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259324);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new flm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((flm)localObject2).parseFrom((byte[])localObject1);
            }
            localcym.aaxA = ((flm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259324);
          return 0;
        case 3: 
          localcym.aaDo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259324);
          return 0;
        }
        localcym.aaDp = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259324);
        return 0;
      }
      AppMethodBeat.o(259324);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cym
 * JD-Core Version:    0.7.0.1
 */