package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class dxq
  extends dyl
{
  public int RZy;
  public String TNB;
  public b UcZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72579);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UcZ != null) {
        paramVarArgs.c(2, this.UcZ);
      }
      if (this.TNB != null) {
        paramVarArgs.f(3, this.TNB);
      }
      paramVarArgs.aY(4, this.RZy);
      AppMethodBeat.o(72579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label452;
      }
    }
    label452:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UcZ != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.UcZ);
      }
      i = paramInt;
      if (this.TNB != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TNB);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.RZy);
      AppMethodBeat.o(72579);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72579);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dxq localdxq = (dxq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72579);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localdxq.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(72579);
          return 0;
        case 2: 
          localdxq.UcZ = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(72579);
          return 0;
        case 3: 
          localdxq.TNB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72579);
          return 0;
        }
        localdxq.RZy = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(72579);
        return 0;
      }
      AppMethodBeat.o(72579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxq
 * JD-Core Version:    0.7.0.1
 */