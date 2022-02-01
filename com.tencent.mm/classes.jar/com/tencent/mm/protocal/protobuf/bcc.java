package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcc
  extends com.tencent.mm.cd.a
{
  public long SND;
  public int SNE;
  public aza yYy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231292);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.yYy != null)
      {
        paramVarArgs.oE(1, this.yYy.computeSize());
        this.yYy.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.SND);
      paramVarArgs.aY(3, this.SNE);
      AppMethodBeat.o(231292);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yYy == null) {
        break label380;
      }
    }
    label380:
    for (paramInt = g.a.a.a.oD(1, this.yYy.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.SND);
      int j = g.a.a.b.b.a.bM(3, this.SNE);
      AppMethodBeat.o(231292);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231292);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bcc localbcc = (bcc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231292);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            aza localaza = new aza();
            if ((localObject != null) && (localObject.length > 0)) {
              localaza.parseFrom((byte[])localObject);
            }
            localbcc.yYy = localaza;
            paramInt += 1;
          }
          AppMethodBeat.o(231292);
          return 0;
        case 2: 
          localbcc.SND = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(231292);
          return 0;
        }
        localbcc.SNE = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(231292);
        return 0;
      }
      AppMethodBeat.o(231292);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcc
 * JD-Core Version:    0.7.0.1
 */