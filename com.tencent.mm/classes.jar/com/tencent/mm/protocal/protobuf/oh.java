package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oh
  extends dyl
{
  public int CPw;
  public String ProductID;
  public String RVx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124431);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.f(2, this.ProductID);
      }
      paramVarArgs.aY(3, this.CPw);
      if (this.RVx != null) {
        paramVarArgs.f(4, this.RVx);
      }
      AppMethodBeat.o(124431);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label452;
      }
    }
    label452:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.ProductID);
      }
      i += g.a.a.b.b.a.bM(3, this.CPw);
      paramInt = i;
      if (this.RVx != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RVx);
      }
      AppMethodBeat.o(124431);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124431);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        oh localoh = (oh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124431);
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
            localoh.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(124431);
          return 0;
        case 2: 
          localoh.ProductID = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124431);
          return 0;
        case 3: 
          localoh.CPw = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(124431);
          return 0;
        }
        localoh.RVx = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(124431);
        return 0;
      }
      AppMethodBeat.o(124431);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oh
 * JD-Core Version:    0.7.0.1
 */