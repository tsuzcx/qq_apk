package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fby
  extends dyl
{
  public String UBS;
  public LinkedList<fcn> UCb;
  
  public fby()
  {
    AppMethodBeat.i(199519);
    this.UCb = new LinkedList();
    AppMethodBeat.o(199519);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199524);
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
      paramVarArgs.e(3, 8, this.UCb);
      AppMethodBeat.o(199524);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UBS != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UBS);
      }
      paramInt = g.a.a.a.c(3, 8, this.UCb);
      AppMethodBeat.o(199524);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UCb.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199524);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fby localfby = (fby)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(199524);
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
            localfby.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(199524);
          return 0;
        case 2: 
          localfby.UBS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(199524);
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
          localfby.UCb.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(199524);
        return 0;
      }
      AppMethodBeat.o(199524);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fby
 * JD-Core Version:    0.7.0.1
 */