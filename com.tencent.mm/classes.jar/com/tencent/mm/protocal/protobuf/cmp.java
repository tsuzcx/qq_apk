package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmp
  extends com.tencent.mm.cd.a
{
  public String ROQ;
  public erh Tud;
  public LinkedList<eqh> Tue;
  public erh Tuf;
  
  public cmp()
  {
    AppMethodBeat.i(91526);
    this.Tue = new LinkedList();
    AppMethodBeat.o(91526);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91527);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tud != null)
      {
        paramVarArgs.oE(1, this.Tud.computeSize());
        this.Tud.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Tue);
      if (this.Tuf != null)
      {
        paramVarArgs.oE(3, this.Tuf.computeSize());
        this.Tuf.writeFields(paramVarArgs);
      }
      if (this.ROQ != null) {
        paramVarArgs.f(4, this.ROQ);
      }
      AppMethodBeat.o(91527);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tud == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = g.a.a.a.oD(1, this.Tud.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Tue);
      paramInt = i;
      if (this.Tuf != null) {
        paramInt = i + g.a.a.a.oD(3, this.Tuf.computeSize());
      }
      i = paramInt;
      if (this.ROQ != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.ROQ);
      }
      AppMethodBeat.o(91527);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tue.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91527);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cmp localcmp = (cmp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91527);
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
            localcmp.Tud = ((erh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eqh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eqh)localObject2).parseFrom((byte[])localObject1);
            }
            localcmp.Tue.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        case 3: 
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
            localcmp.Tuf = ((erh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91527);
          return 0;
        }
        localcmp.ROQ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91527);
        return 0;
      }
      AppMethodBeat.o(91527);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmp
 * JD-Core Version:    0.7.0.1
 */