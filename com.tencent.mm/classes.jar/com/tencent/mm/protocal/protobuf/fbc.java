package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fbc
  extends esc
{
  public int Idd;
  public gol YLa;
  public int abBg;
  public int abBi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32447);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32447);
        throw paramVarArgs;
      }
      if (this.YLa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(32447);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YLa != null)
      {
        paramVarArgs.qD(2, this.YLa.computeSize());
        this.YLa.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.Idd);
      paramVarArgs.bS(4, this.abBg);
      paramVarArgs.bS(5, this.abBi);
      AppMethodBeat.o(32447);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label665;
      }
    }
    label665:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YLa != null) {
        i = paramInt + i.a.a.a.qC(2, this.YLa.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.Idd);
      int j = i.a.a.b.b.a.cJ(4, this.abBg);
      int k = i.a.a.b.b.a.cJ(5, this.abBi);
      AppMethodBeat.o(32447);
      return i + paramInt + j + k;
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
          AppMethodBeat.o(32447);
          throw paramVarArgs;
        }
        if (this.YLa == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(32447);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32447);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fbc localfbc = (fbc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32447);
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
            localfbc.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32447);
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
            localfbc.YLa = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32447);
          return 0;
        case 3: 
          localfbc.Idd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32447);
          return 0;
        case 4: 
          localfbc.abBg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32447);
          return 0;
        }
        localfbc.abBi = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32447);
        return 0;
      }
      AppMethodBeat.o(32447);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbc
 * JD-Core Version:    0.7.0.1
 */