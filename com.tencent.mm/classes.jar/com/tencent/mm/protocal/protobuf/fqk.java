package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fqk
  extends dyl
{
  public int CMR;
  public String RMH;
  public String UOh;
  public String vhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152731);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.vhq != null) {
        paramVarArgs.f(2, this.vhq);
      }
      if (this.RMH != null) {
        paramVarArgs.f(3, this.RMH);
      }
      if (this.UOh != null) {
        paramVarArgs.f(4, this.UOh);
      }
      paramVarArgs.aY(5, this.CMR);
      AppMethodBeat.o(152731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label512;
      }
    }
    label512:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vhq != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.vhq);
      }
      i = paramInt;
      if (this.RMH != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RMH);
      }
      paramInt = i;
      if (this.UOh != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UOh);
      }
      i = g.a.a.b.b.a.bM(5, this.CMR);
      AppMethodBeat.o(152731);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152731);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fqk localfqk = (fqk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152731);
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
            localfqk.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(152731);
          return 0;
        case 2: 
          localfqk.vhq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152731);
          return 0;
        case 3: 
          localfqk.RMH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152731);
          return 0;
        case 4: 
          localfqk.UOh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152731);
          return 0;
        }
        localfqk.CMR = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152731);
        return 0;
      }
      AppMethodBeat.o(152731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqk
 * JD-Core Version:    0.7.0.1
 */