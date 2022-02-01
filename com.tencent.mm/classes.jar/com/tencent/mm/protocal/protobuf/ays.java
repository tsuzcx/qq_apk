package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ays
  extends com.tencent.mm.cd.a
{
  public vj SKK;
  public int SKL;
  public String zKY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198128);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SKK != null)
      {
        paramVarArgs.oE(1, this.SKK.computeSize());
        this.SKK.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.SKL);
      if (this.zKY != null) {
        paramVarArgs.f(3, this.zKY);
      }
      AppMethodBeat.o(198128);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SKK == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = g.a.a.a.oD(1, this.SKK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.SKL);
      paramInt = i;
      if (this.zKY != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.zKY);
      }
      AppMethodBeat.o(198128);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(198128);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ays localays = (ays)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(198128);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            vj localvj = new vj();
            if ((localObject != null) && (localObject.length > 0)) {
              localvj.parseFrom((byte[])localObject);
            }
            localays.SKK = localvj;
            paramInt += 1;
          }
          AppMethodBeat.o(198128);
          return 0;
        case 2: 
          localays.SKL = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(198128);
          return 0;
        }
        localays.zKY = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(198128);
        return 0;
      }
      AppMethodBeat.o(198128);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ays
 * JD-Core Version:    0.7.0.1
 */