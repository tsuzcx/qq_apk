package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class cbs
  extends dyl
{
  public int CPw;
  public b Tkb;
  public duk Tkc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206120);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.CPw);
      if (this.Tkb != null) {
        paramVarArgs.c(3, this.Tkb);
      }
      if (this.Tkc != null)
      {
        paramVarArgs.oE(4, this.Tkc.computeSize());
        this.Tkc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(206120);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.CPw);
      paramInt = i;
      if (this.Tkb != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.Tkb);
      }
      i = paramInt;
      if (this.Tkc != null) {
        i = paramInt + g.a.a.a.oD(4, this.Tkc.computeSize());
      }
      AppMethodBeat.o(206120);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(206120);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cbs localcbs = (cbs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206120);
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
            localcbs.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206120);
          return 0;
        case 2: 
          localcbs.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(206120);
          return 0;
        case 3: 
          localcbs.Tkb = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(206120);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new duk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((duk)localObject2).parseFrom((byte[])localObject1);
          }
          localcbs.Tkc = ((duk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(206120);
        return 0;
      }
      AppMethodBeat.o(206120);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbs
 * JD-Core Version:    0.7.0.1
 */