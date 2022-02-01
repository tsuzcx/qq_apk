package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class vr
  extends dyy
{
  public String ShR;
  public LinkedList<amg> ShS;
  public int ShT;
  public int fwx;
  public String tVo;
  public String tVp;
  
  public vr()
  {
    AppMethodBeat.i(91401);
    this.ShS = new LinkedList();
    AppMethodBeat.o(91401);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91402);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91402);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fwx);
      if (this.tVo != null) {
        paramVarArgs.f(3, this.tVo);
      }
      if (this.ShR != null) {
        paramVarArgs.f(4, this.ShR);
      }
      if (this.tVp != null) {
        paramVarArgs.f(5, this.tVp);
      }
      paramVarArgs.e(6, 8, this.ShS);
      paramVarArgs.aY(7, this.ShT);
      AppMethodBeat.o(91402);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label730;
      }
    }
    label730:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.ShR != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.ShR);
      }
      paramInt = i;
      if (this.tVp != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.tVp);
      }
      i = g.a.a.a.c(6, 8, this.ShS);
      int j = g.a.a.b.b.a.bM(7, this.ShT);
      AppMethodBeat.o(91402);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ShS.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91402);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91402);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        vr localvr = (vr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91402);
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
            localvr.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91402);
          return 0;
        case 2: 
          localvr.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91402);
          return 0;
        case 3: 
          localvr.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 4: 
          localvr.ShR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 5: 
          localvr.tVp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91402);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new amg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((amg)localObject2).parseFrom((byte[])localObject1);
            }
            localvr.ShS.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91402);
          return 0;
        }
        localvr.ShT = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91402);
        return 0;
      }
      AppMethodBeat.o(91402);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vr
 * JD-Core Version:    0.7.0.1
 */