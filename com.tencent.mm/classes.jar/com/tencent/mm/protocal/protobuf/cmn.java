package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmn
  extends com.tencent.mm.cd.a
{
  public erh RGf;
  public String ROQ;
  public LinkedList<erh> lpz;
  
  public cmn()
  {
    AppMethodBeat.i(91524);
    this.lpz = new LinkedList();
    AppMethodBeat.o(91524);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91525);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RGf != null)
      {
        paramVarArgs.oE(1, this.RGf.computeSize());
        this.RGf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.lpz);
      if (this.ROQ != null) {
        paramVarArgs.f(3, this.ROQ);
      }
      AppMethodBeat.o(91525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RGf == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.a.oD(1, this.RGf.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.lpz);
      paramInt = i;
      if (this.ROQ != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.ROQ);
      }
      AppMethodBeat.o(91525);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.lpz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cmn localcmn = (cmn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        erh localerh;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91525);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localerh = new erh();
            if ((localObject != null) && (localObject.length > 0)) {
              localerh.parseFrom((byte[])localObject);
            }
            localcmn.RGf = localerh;
            paramInt += 1;
          }
          AppMethodBeat.o(91525);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localerh = new erh();
            if ((localObject != null) && (localObject.length > 0)) {
              localerh.parseFrom((byte[])localObject);
            }
            localcmn.lpz.add(localerh);
            paramInt += 1;
          }
          AppMethodBeat.o(91525);
          return 0;
        }
        localcmn.ROQ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91525);
        return 0;
      }
      AppMethodBeat.o(91525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmn
 * JD-Core Version:    0.7.0.1
 */