package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctw
  extends dyl
{
  public LinkedList<ctt> TBD;
  public String Tsf;
  
  public ctw()
  {
    AppMethodBeat.i(124532);
    this.TBD = new LinkedList();
    AppMethodBeat.o(124532);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124533);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Tsf != null) {
        paramVarArgs.f(2, this.Tsf);
      }
      paramVarArgs.e(3, 8, this.TBD);
      AppMethodBeat.o(124533);
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
      if (this.Tsf != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Tsf);
      }
      paramInt = g.a.a.a.c(3, 8, this.TBD);
      AppMethodBeat.o(124533);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TBD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124533);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ctw localctw = (ctw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124533);
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
            localctw.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124533);
          return 0;
        case 2: 
          localctw.Tsf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124533);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ctt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ctt)localObject2).parseFrom((byte[])localObject1);
          }
          localctw.TBD.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124533);
        return 0;
      }
      AppMethodBeat.o(124533);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctw
 * JD-Core Version:    0.7.0.1
 */