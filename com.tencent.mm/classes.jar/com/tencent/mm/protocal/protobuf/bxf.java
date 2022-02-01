package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bxf
  extends dyl
{
  public boolean Gch;
  public String RFj;
  public b RLO;
  public long klE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192668);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RLO != null) {
        paramVarArgs.c(2, this.RLO);
      }
      paramVarArgs.bm(3, this.klE);
      if (this.RFj != null) {
        paramVarArgs.f(4, this.RFj);
      }
      paramVarArgs.co(5, this.Gch);
      AppMethodBeat.o(192668);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RLO != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.RLO);
      }
      i += g.a.a.b.b.a.p(3, this.klE);
      paramInt = i;
      if (this.RFj != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RFj);
      }
      i = g.a.a.b.b.a.gL(5);
      AppMethodBeat.o(192668);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(192668);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bxf localbxf = (bxf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(192668);
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
            localbxf.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(192668);
          return 0;
        case 2: 
          localbxf.RLO = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(192668);
          return 0;
        case 3: 
          localbxf.klE = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(192668);
          return 0;
        case 4: 
          localbxf.RFj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(192668);
          return 0;
        }
        localbxf.Gch = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(192668);
        return 0;
      }
      AppMethodBeat.o(192668);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxf
 * JD-Core Version:    0.7.0.1
 */