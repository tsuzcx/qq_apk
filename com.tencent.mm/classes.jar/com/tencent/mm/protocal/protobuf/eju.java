package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eju
  extends dpc
{
  public dmp Nja;
  public String Njf;
  public String Njg;
  public int pTZ;
  public String pUa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72591);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      if (this.Njf != null) {
        paramVarArgs.e(4, this.Njf);
      }
      if (this.Njg != null) {
        paramVarArgs.e(5, this.Njg);
      }
      if (this.Nja != null)
      {
        paramVarArgs.ni(6, this.Nja.computeSize());
        this.Nja.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt;
      if (this.Njf != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Njf);
      }
      paramInt = i;
      if (this.Njg != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Njg);
      }
      i = paramInt;
      if (this.Nja != null) {
        i = paramInt + g.a.a.a.nh(6, this.Nja.computeSize());
      }
      AppMethodBeat.o(72591);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eju localeju = (eju)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72591);
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
            localeju.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72591);
          return 0;
        case 2: 
          localeju.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72591);
          return 0;
        case 3: 
          localeju.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72591);
          return 0;
        case 4: 
          localeju.Njf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72591);
          return 0;
        case 5: 
          localeju.Njg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72591);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmp();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeju.Nja = ((dmp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72591);
        return 0;
      }
      AppMethodBeat.o(72591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eju
 * JD-Core Version:    0.7.0.1
 */