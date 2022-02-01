package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbb
  extends com.tencent.mm.cd.a
{
  public String TIA;
  public String TIB;
  public String TIm;
  public bds TIn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(242639);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TIm != null) {
        paramVarArgs.f(1, this.TIm);
      }
      if (this.TIA != null) {
        paramVarArgs.f(2, this.TIA);
      }
      if (this.TIB != null) {
        paramVarArgs.f(3, this.TIB);
      }
      if (this.TIn != null)
      {
        paramVarArgs.oE(4, this.TIn.computeSize());
        this.TIn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(242639);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TIm == null) {
        break label468;
      }
    }
    label468:
    for (int i = g.a.a.b.b.a.g(1, this.TIm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TIA != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TIA);
      }
      i = paramInt;
      if (this.TIB != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TIB);
      }
      paramInt = i;
      if (this.TIn != null) {
        paramInt = i + g.a.a.a.oD(4, this.TIn.computeSize());
      }
      AppMethodBeat.o(242639);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(242639);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dbb localdbb = (dbb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(242639);
          return -1;
        case 1: 
          localdbb.TIm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(242639);
          return 0;
        case 2: 
          localdbb.TIA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(242639);
          return 0;
        case 3: 
          localdbb.TIB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(242639);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bds localbds = new bds();
          if ((localObject != null) && (localObject.length > 0)) {
            localbds.parseFrom((byte[])localObject);
          }
          localdbb.TIn = localbds;
          paramInt += 1;
        }
        AppMethodBeat.o(242639);
        return 0;
      }
      AppMethodBeat.o(242639);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbb
 * JD-Core Version:    0.7.0.1
 */