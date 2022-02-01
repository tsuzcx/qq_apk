package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class r
  extends dyl
{
  public long RDB;
  public String RDC;
  public String RDi;
  public String RDj;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91326);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RDi != null) {
        paramVarArgs.f(2, this.RDi);
      }
      paramVarArgs.bm(3, this.RDB);
      paramVarArgs.aY(4, this.scene);
      if (this.RDj != null) {
        paramVarArgs.f(5, this.RDj);
      }
      if (this.RDC != null) {
        paramVarArgs.f(6, this.RDC);
      }
      AppMethodBeat.o(91326);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label556;
      }
    }
    label556:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RDi != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RDi);
      }
      i = i + g.a.a.b.b.a.p(3, this.RDB) + g.a.a.b.b.a.bM(4, this.scene);
      paramInt = i;
      if (this.RDj != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RDj);
      }
      i = paramInt;
      if (this.RDC != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.RDC);
      }
      AppMethodBeat.o(91326);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91326);
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
          AppMethodBeat.o(91326);
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
          AppMethodBeat.o(91326);
          return 0;
        case 2: 
          localr.RDi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91326);
          return 0;
        case 3: 
          localr.RDB = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(91326);
          return 0;
        case 4: 
          localr.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91326);
          return 0;
        case 5: 
          localr.RDj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91326);
          return 0;
        }
        localr.RDC = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91326);
        return 0;
      }
      AppMethodBeat.o(91326);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.r
 * JD-Core Version:    0.7.0.1
 */