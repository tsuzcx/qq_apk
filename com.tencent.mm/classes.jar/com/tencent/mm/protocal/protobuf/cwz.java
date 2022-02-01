package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cwz
  extends esc
{
  public gln aaCw;
  public glo aaCx;
  public glk aaCy;
  public gnm aaCz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50093);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(50093);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaCw != null)
      {
        paramVarArgs.qD(2, this.aaCw.computeSize());
        this.aaCw.writeFields(paramVarArgs);
      }
      if (this.aaCx != null)
      {
        paramVarArgs.qD(3, this.aaCx.computeSize());
        this.aaCx.writeFields(paramVarArgs);
      }
      if (this.aaCy != null)
      {
        paramVarArgs.qD(4, this.aaCy.computeSize());
        this.aaCy.writeFields(paramVarArgs);
      }
      if (this.aaCz != null)
      {
        paramVarArgs.qD(5, this.aaCz.computeSize());
        this.aaCz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(50093);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label860;
      }
    }
    label860:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaCw != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaCw.computeSize());
      }
      i = paramInt;
      if (this.aaCx != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaCx.computeSize());
      }
      paramInt = i;
      if (this.aaCy != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaCy.computeSize());
      }
      i = paramInt;
      if (this.aaCz != null) {
        i = paramInt + i.a.a.a.qC(5, this.aaCz.computeSize());
      }
      AppMethodBeat.o(50093);
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
          AppMethodBeat.o(50093);
          throw paramVarArgs;
        }
        AppMethodBeat.o(50093);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cwz localcwz = (cwz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50093);
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
            localcwz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50093);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gln();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gln)localObject2).parseFrom((byte[])localObject1);
            }
            localcwz.aaCw = ((gln)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50093);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new glo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((glo)localObject2).parseFrom((byte[])localObject1);
            }
            localcwz.aaCx = ((glo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50093);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new glk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((glk)localObject2).parseFrom((byte[])localObject1);
            }
            localcwz.aaCy = ((glk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(50093);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gnm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gnm)localObject2).parseFrom((byte[])localObject1);
          }
          localcwz.aaCz = ((gnm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(50093);
        return 0;
      }
      AppMethodBeat.o(50093);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwz
 * JD-Core Version:    0.7.0.1
 */