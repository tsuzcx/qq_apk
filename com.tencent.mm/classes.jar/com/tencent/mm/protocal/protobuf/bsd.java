package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bsd
  extends dyy
{
  public String Tco;
  public ve Tcp;
  public int Tcq;
  public eda Tcr;
  public String tpZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114023);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114023);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.tpZ != null) {
        paramVarArgs.f(2, this.tpZ);
      }
      if (this.Tco != null) {
        paramVarArgs.f(3, this.Tco);
      }
      if (this.Tcp != null)
      {
        paramVarArgs.oE(4, this.Tcp.computeSize());
        this.Tcp.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.Tcq);
      if (this.Tcr != null)
      {
        paramVarArgs.oE(6, this.Tcr.computeSize());
        this.Tcr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114023);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label768;
      }
    }
    label768:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tpZ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.tpZ);
      }
      i = paramInt;
      if (this.Tco != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Tco);
      }
      paramInt = i;
      if (this.Tcp != null) {
        paramInt = i + g.a.a.a.oD(4, this.Tcp.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.Tcq);
      paramInt = i;
      if (this.Tcr != null) {
        paramInt = i + g.a.a.a.oD(6, this.Tcr.computeSize());
      }
      AppMethodBeat.o(114023);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114023);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114023);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bsd localbsd = (bsd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114023);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbsd.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114023);
          return 0;
        case 2: 
          localbsd.tpZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114023);
          return 0;
        case 3: 
          localbsd.Tco = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(114023);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ve();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ve)localObject2).parseFrom((byte[])localObject1);
            }
            localbsd.Tcp = ((ve)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114023);
          return 0;
        case 5: 
          localbsd.Tcq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(114023);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eda();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eda)localObject2).parseFrom((byte[])localObject1);
          }
          localbsd.Tcr = ((eda)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(114023);
        return 0;
      }
      AppMethodBeat.o(114023);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsd
 * JD-Core Version:    0.7.0.1
 */