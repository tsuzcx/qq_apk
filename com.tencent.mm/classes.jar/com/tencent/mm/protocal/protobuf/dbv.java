package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbv
  extends com.tencent.mm.cd.a
{
  public clc Sbb;
  public erh SpR;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91551);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Sbb != null)
      {
        paramVarArgs.oE(1, this.Sbb.computeSize());
        this.Sbb.writeFields(paramVarArgs);
      }
      if (this.SpR != null)
      {
        paramVarArgs.oE(2, this.SpR.computeSize());
        this.SpR.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.type);
      AppMethodBeat.o(91551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Sbb == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.a.oD(1, this.Sbb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SpR != null) {
        i = paramInt + g.a.a.a.oD(2, this.SpR.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(3, this.type);
      AppMethodBeat.o(91551);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dbv localdbv = (dbv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91551);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new clc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((clc)localObject2).parseFrom((byte[])localObject1);
            }
            localdbv.Sbb = ((clc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91551);
          return 0;
        case 2: 
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
            localdbv.SpR = ((erh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91551);
          return 0;
        }
        localdbv.type = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91551);
        return 0;
      }
      AppMethodBeat.o(91551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbv
 * JD-Core Version:    0.7.0.1
 */