package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class by
  extends dyl
{
  public String RHs;
  public LinkedList<bx> RHt;
  public String jDL;
  
  public by()
  {
    AppMethodBeat.i(260293);
    this.RHt = new LinkedList();
    AppMethodBeat.o(260293);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260294);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RHs != null) {
        paramVarArgs.f(2, this.RHs);
      }
      if (this.jDL != null) {
        paramVarArgs.f(3, this.jDL);
      }
      paramVarArgs.e(4, 8, this.RHt);
      AppMethodBeat.o(260294);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label526;
      }
    }
    label526:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RHs != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RHs);
      }
      i = paramInt;
      if (this.jDL != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.jDL);
      }
      paramInt = g.a.a.a.c(4, 8, this.RHt);
      AppMethodBeat.o(260294);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RHt.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(260294);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        by localby = (by)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260294);
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
            localby.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260294);
          return 0;
        case 2: 
          localby.RHs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(260294);
          return 0;
        case 3: 
          localby.jDL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(260294);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bx)localObject2).parseFrom((byte[])localObject1);
          }
          localby.RHt.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260294);
        return 0;
      }
      AppMethodBeat.o(260294);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.by
 * JD-Core Version:    0.7.0.1
 */