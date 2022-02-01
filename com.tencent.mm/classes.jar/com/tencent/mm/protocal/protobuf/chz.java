package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chz
  extends com.tencent.mm.cd.a
{
  public erh RGf;
  public LinkedList<eir> RGi;
  public String ROQ;
  
  public chz()
  {
    AppMethodBeat.i(91514);
    this.RGi = new LinkedList();
    AppMethodBeat.o(91514);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91515);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RGf != null)
      {
        paramVarArgs.oE(1, this.RGf.computeSize());
        this.RGf.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.RGi);
      if (this.ROQ != null) {
        paramVarArgs.f(3, this.ROQ);
      }
      AppMethodBeat.o(91515);
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
      int i = paramInt + g.a.a.a.c(2, 8, this.RGi);
      paramInt = i;
      if (this.ROQ != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.ROQ);
      }
      AppMethodBeat.o(91515);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RGi.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91515);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        chz localchz = (chz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91515);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new erh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((erh)localObject2).parseFrom((byte[])localObject1);
            }
            localchz.RGf = ((erh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91515);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eir();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eir)localObject2).parseFrom((byte[])localObject1);
            }
            localchz.RGi.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91515);
          return 0;
        }
        localchz.ROQ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91515);
        return 0;
      }
      AppMethodBeat.o(91515);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chz
 * JD-Core Version:    0.7.0.1
 */