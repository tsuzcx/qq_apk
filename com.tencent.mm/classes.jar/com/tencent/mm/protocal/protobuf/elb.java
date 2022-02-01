package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class elb
  extends dyl
{
  public String CQx;
  public int RLe;
  public long UmL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125824);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RLe);
      paramVarArgs.bm(3, this.UmL);
      if (this.CQx != null) {
        paramVarArgs.f(4, this.CQx);
      }
      AppMethodBeat.o(125824);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RLe) + g.a.a.b.b.a.p(3, this.UmL);
      paramInt = i;
      if (this.CQx != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CQx);
      }
      AppMethodBeat.o(125824);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125824);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        elb localelb = (elb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125824);
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
            localelb.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(125824);
          return 0;
        case 2: 
          localelb.RLe = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125824);
          return 0;
        case 3: 
          localelb.UmL = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(125824);
          return 0;
        }
        localelb.CQx = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(125824);
        return 0;
      }
      AppMethodBeat.o(125824);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elb
 * JD-Core Version:    0.7.0.1
 */