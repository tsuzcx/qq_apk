package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dsd
  extends dyy
{
  public eaa RGh;
  public eqi TYR;
  public fip TYS;
  public long TYT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91654);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91654);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TYR != null)
      {
        paramVarArgs.oE(2, this.TYR.computeSize());
        this.TYR.writeFields(paramVarArgs);
      }
      if (this.RGh != null)
      {
        paramVarArgs.oE(3, this.RGh.computeSize());
        this.RGh.writeFields(paramVarArgs);
      }
      if (this.TYS != null)
      {
        paramVarArgs.oE(4, this.TYS.computeSize());
        this.TYS.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(5, this.TYT);
      AppMethodBeat.o(91654);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label778;
      }
    }
    label778:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TYR != null) {
        paramInt = i + g.a.a.a.oD(2, this.TYR.computeSize());
      }
      i = paramInt;
      if (this.RGh != null) {
        i = paramInt + g.a.a.a.oD(3, this.RGh.computeSize());
      }
      paramInt = i;
      if (this.TYS != null) {
        paramInt = i + g.a.a.a.oD(4, this.TYS.computeSize());
      }
      i = g.a.a.b.b.a.p(5, this.TYT);
      AppMethodBeat.o(91654);
      return paramInt + i;
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
          AppMethodBeat.o(91654);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91654);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dsd localdsd = (dsd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91654);
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
            localdsd.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91654);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eqi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eqi)localObject2).parseFrom((byte[])localObject1);
            }
            localdsd.TYR = ((eqi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91654);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaa)localObject2).parseFrom((byte[])localObject1);
            }
            localdsd.RGh = ((eaa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91654);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fip();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fip)localObject2).parseFrom((byte[])localObject1);
            }
            localdsd.TYS = ((fip)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91654);
          return 0;
        }
        localdsd.TYT = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(91654);
        return 0;
      }
      AppMethodBeat.o(91654);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsd
 * JD-Core Version:    0.7.0.1
 */