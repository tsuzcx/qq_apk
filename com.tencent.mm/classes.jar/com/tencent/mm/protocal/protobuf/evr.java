package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class evr
  extends dyy
{
  public int Uxh;
  public ha Uxi;
  public ay Uxj;
  public dcb Uxk;
  public hw Uxl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133205);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133205);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Uxh);
      if (this.Uxi != null)
      {
        paramVarArgs.oE(3, this.Uxi.computeSize());
        this.Uxi.writeFields(paramVarArgs);
      }
      if (this.Uxj != null)
      {
        paramVarArgs.oE(4, this.Uxj.computeSize());
        this.Uxj.writeFields(paramVarArgs);
      }
      if (this.Uxk != null)
      {
        paramVarArgs.oE(5, this.Uxk.computeSize());
        this.Uxk.writeFields(paramVarArgs);
      }
      if (this.Uxl != null)
      {
        paramVarArgs.oE(6, this.Uxl.computeSize());
        this.Uxl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133205);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label912;
      }
    }
    label912:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Uxh);
      paramInt = i;
      if (this.Uxi != null) {
        paramInt = i + g.a.a.a.oD(3, this.Uxi.computeSize());
      }
      i = paramInt;
      if (this.Uxj != null) {
        i = paramInt + g.a.a.a.oD(4, this.Uxj.computeSize());
      }
      paramInt = i;
      if (this.Uxk != null) {
        paramInt = i + g.a.a.a.oD(5, this.Uxk.computeSize());
      }
      i = paramInt;
      if (this.Uxl != null) {
        i = paramInt + g.a.a.a.oD(6, this.Uxl.computeSize());
      }
      AppMethodBeat.o(133205);
      return i;
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
          AppMethodBeat.o(133205);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133205);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        evr localevr = (evr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133205);
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
            localevr.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        case 2: 
          localevr.Uxh = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133205);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ha();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ha)localObject2).parseFrom((byte[])localObject1);
            }
            localevr.Uxi = ((ha)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ay();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ay)localObject2).parseFrom((byte[])localObject1);
            }
            localevr.Uxj = ((ay)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dcb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dcb)localObject2).parseFrom((byte[])localObject1);
            }
            localevr.Uxk = ((dcb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133205);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((hw)localObject2).parseFrom((byte[])localObject1);
          }
          localevr.Uxl = ((hw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133205);
        return 0;
      }
      AppMethodBeat.o(133205);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evr
 * JD-Core Version:    0.7.0.1
 */