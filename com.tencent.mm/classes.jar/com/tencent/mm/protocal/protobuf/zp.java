package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class zp
  extends esc
{
  public String YGP;
  public ml Zij;
  public fe Zik;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257441);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(257441);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YGP != null) {
        paramVarArgs.g(2, this.YGP);
      }
      if (this.Zij != null)
      {
        paramVarArgs.qD(3, this.Zij.computeSize());
        this.Zij.writeFields(paramVarArgs);
      }
      if (this.Zik != null)
      {
        paramVarArgs.qD(4, this.Zik.computeSize());
        this.Zik.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label656;
      }
    }
    label656:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YGP != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YGP);
      }
      i = paramInt;
      if (this.Zij != null) {
        i = paramInt + i.a.a.a.qC(3, this.Zij.computeSize());
      }
      paramInt = i;
      if (this.Zik != null) {
        paramInt = i + i.a.a.a.qC(4, this.Zik.computeSize());
      }
      AppMethodBeat.o(257441);
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
          AppMethodBeat.o(257441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        zp localzp = (zp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257441);
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
            localzp.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257441);
          return 0;
        case 2: 
          localzp.YGP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257441);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ml();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ml)localObject2).parseFrom((byte[])localObject1);
            }
            localzp.Zij = ((ml)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257441);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fe();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fe)localObject2).parseFrom((byte[])localObject1);
          }
          localzp.Zik = ((fe)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257441);
        return 0;
      }
      AppMethodBeat.o(257441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zp
 * JD-Core Version:    0.7.0.1
 */