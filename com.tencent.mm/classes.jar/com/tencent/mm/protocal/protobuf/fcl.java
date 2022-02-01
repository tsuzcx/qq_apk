package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class fcl
  extends dyl
{
  public String UBS;
  public fcn UCi;
  public b UCn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200161);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UBS != null) {
        paramVarArgs.f(2, this.UBS);
      }
      if (this.UCn != null) {
        paramVarArgs.c(3, this.UCn);
      }
      if (this.UCi != null)
      {
        paramVarArgs.oE(4, this.UCi.computeSize());
        this.UCi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200161);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label542;
      }
    }
    label542:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UBS != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UBS);
      }
      i = paramInt;
      if (this.UCn != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.UCn);
      }
      paramInt = i;
      if (this.UCi != null) {
        paramInt = i + g.a.a.a.oD(4, this.UCi.computeSize());
      }
      AppMethodBeat.o(200161);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(200161);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fcl localfcl = (fcl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200161);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localfcl.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(200161);
          return 0;
        case 2: 
          localfcl.UBS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(200161);
          return 0;
        case 3: 
          localfcl.UCn = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(200161);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fcn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fcn)localObject2).parseFrom((byte[])localObject1);
          }
          localfcl.UCi = ((fcn)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(200161);
        return 0;
      }
      AppMethodBeat.o(200161);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcl
 * JD-Core Version:    0.7.0.1
 */