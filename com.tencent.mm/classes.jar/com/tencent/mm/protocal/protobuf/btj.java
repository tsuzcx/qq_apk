package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class btj
  extends dyy
{
  public int TdA;
  public int TdB;
  public uy TdC;
  public int Tdw;
  public uj Tdx;
  public up Tdy;
  public String Tdz;
  public int tqa;
  public String tqb;
  public int ufi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(249413);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(249413);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      paramVarArgs.aY(4, this.ufi);
      paramVarArgs.aY(5, this.Tdw);
      if (this.Tdx != null)
      {
        paramVarArgs.oE(6, this.Tdx.computeSize());
        this.Tdx.writeFields(paramVarArgs);
      }
      if (this.Tdy != null)
      {
        paramVarArgs.oE(7, this.Tdy.computeSize());
        this.Tdy.writeFields(paramVarArgs);
      }
      if (this.Tdz != null) {
        paramVarArgs.f(8, this.Tdz);
      }
      paramVarArgs.aY(9, this.TdA);
      paramVarArgs.aY(10, this.TdB);
      if (this.TdC != null)
      {
        paramVarArgs.oE(11, this.TdC.computeSize());
        this.TdC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(249413);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1082;
      }
    }
    label1082:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.ufi) + g.a.a.b.b.a.bM(5, this.Tdw);
      paramInt = i;
      if (this.Tdx != null) {
        paramInt = i + g.a.a.a.oD(6, this.Tdx.computeSize());
      }
      i = paramInt;
      if (this.Tdy != null) {
        i = paramInt + g.a.a.a.oD(7, this.Tdy.computeSize());
      }
      paramInt = i;
      if (this.Tdz != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Tdz);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.TdA) + g.a.a.b.b.a.bM(10, this.TdB);
      paramInt = i;
      if (this.TdC != null) {
        paramInt = i + g.a.a.a.oD(11, this.TdC.computeSize());
      }
      AppMethodBeat.o(249413);
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
          AppMethodBeat.o(249413);
          throw paramVarArgs;
        }
        AppMethodBeat.o(249413);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        btj localbtj = (btj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(249413);
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
            localbtj.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(249413);
          return 0;
        case 2: 
          localbtj.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(249413);
          return 0;
        case 3: 
          localbtj.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(249413);
          return 0;
        case 4: 
          localbtj.ufi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(249413);
          return 0;
        case 5: 
          localbtj.Tdw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(249413);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uj)localObject2).parseFrom((byte[])localObject1);
            }
            localbtj.Tdx = ((uj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(249413);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new up();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((up)localObject2).parseFrom((byte[])localObject1);
            }
            localbtj.Tdy = ((up)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(249413);
          return 0;
        case 8: 
          localbtj.Tdz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(249413);
          return 0;
        case 9: 
          localbtj.TdA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(249413);
          return 0;
        case 10: 
          localbtj.TdB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(249413);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new uy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((uy)localObject2).parseFrom((byte[])localObject1);
          }
          localbtj.TdC = ((uy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(249413);
        return 0;
      }
      AppMethodBeat.o(249413);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btj
 * JD-Core Version:    0.7.0.1
 */