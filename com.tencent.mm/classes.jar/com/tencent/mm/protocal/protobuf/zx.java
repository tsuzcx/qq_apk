package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class zx
  extends esc
{
  public int Zis;
  public String Zit;
  public String Ziu;
  public String pSi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9587);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(9587);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.pSi != null) {
        paramVarArgs.g(2, this.pSi);
      }
      paramVarArgs.bS(3, this.Zis);
      if (this.Zit != null) {
        paramVarArgs.g(4, this.Zit);
      }
      if (this.Ziu != null) {
        paramVarArgs.g(5, this.Ziu);
      }
      AppMethodBeat.o(9587);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label571;
      }
    }
    label571:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pSi != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.pSi);
      }
      i += i.a.a.b.b.a.cJ(3, this.Zis);
      paramInt = i;
      if (this.Zit != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zit);
      }
      i = paramInt;
      if (this.Ziu != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Ziu);
      }
      AppMethodBeat.o(9587);
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
          AppMethodBeat.o(9587);
          throw paramVarArgs;
        }
        AppMethodBeat.o(9587);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        zx localzx = (zx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9587);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localzx.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(9587);
          return 0;
        case 2: 
          localzx.pSi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(9587);
          return 0;
        case 3: 
          localzx.Zis = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(9587);
          return 0;
        case 4: 
          localzx.Zit = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(9587);
          return 0;
        }
        localzx.Ziu = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(9587);
        return 0;
      }
      AppMethodBeat.o(9587);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zx
 * JD-Core Version:    0.7.0.1
 */