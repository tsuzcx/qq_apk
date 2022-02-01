package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public final class r
  extends dyl
{
  public String jDL;
  public String jDM;
  public long jEe;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(249636);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.jDL != null) {
        paramVarArgs.f(2, this.jDL);
      }
      paramVarArgs.aY(3, this.source);
      paramVarArgs.bm(4, this.jEe);
      if (this.jDM != null) {
        paramVarArgs.f(5, this.jDM);
      }
      AppMethodBeat.o(249636);
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
      if (this.jDL != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.jDL);
      }
      i = i + g.a.a.b.b.a.bM(3, this.source) + g.a.a.b.b.a.p(4, this.jEe);
      paramInt = i;
      if (this.jDM != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.jDM);
      }
      AppMethodBeat.o(249636);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(249636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        r localr = (r)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(249636);
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
            localr.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(249636);
          return 0;
        case 2: 
          localr.jDL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249636);
          return 0;
        case 3: 
          localr.source = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(249636);
          return 0;
        case 4: 
          localr.jEe = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(249636);
          return 0;
        }
        localr.jDM = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(249636);
        return 0;
      }
      AppMethodBeat.o(249636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.t.a.r
 * JD-Core Version:    0.7.0.1
 */