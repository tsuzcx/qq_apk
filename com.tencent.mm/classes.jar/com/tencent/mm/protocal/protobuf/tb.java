package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class tb
  extends dyl
{
  public b Sci;
  public b Scj;
  public int Sck;
  public int Scl;
  public int Scm;
  public int mbp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258041);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Sci != null) {
        paramVarArgs.c(2, this.Sci);
      }
      paramVarArgs.aY(3, this.mbp);
      if (this.Scj != null) {
        paramVarArgs.c(4, this.Scj);
      }
      paramVarArgs.aY(5, this.Sck);
      paramVarArgs.aY(6, this.Scl);
      paramVarArgs.aY(7, this.Scm);
      AppMethodBeat.o(258041);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label592;
      }
    }
    label592:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Sci != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.Sci);
      }
      i += g.a.a.b.b.a.bM(3, this.mbp);
      paramInt = i;
      if (this.Scj != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.Scj);
      }
      i = g.a.a.b.b.a.bM(5, this.Sck);
      int j = g.a.a.b.b.a.bM(6, this.Scl);
      int k = g.a.a.b.b.a.bM(7, this.Scm);
      AppMethodBeat.o(258041);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(258041);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        tb localtb = (tb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258041);
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
            localtb.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(258041);
          return 0;
        case 2: 
          localtb.Sci = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(258041);
          return 0;
        case 3: 
          localtb.mbp = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(258041);
          return 0;
        case 4: 
          localtb.Scj = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(258041);
          return 0;
        case 5: 
          localtb.Sck = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(258041);
          return 0;
        case 6: 
          localtb.Scl = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(258041);
          return 0;
        }
        localtb.Scm = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(258041);
        return 0;
      }
      AppMethodBeat.o(258041);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tb
 * JD-Core Version:    0.7.0.1
 */