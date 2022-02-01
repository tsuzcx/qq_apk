package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzh
  extends com.tencent.mm.bx.a
{
  public String YMe;
  public eha abeb;
  public LinkedList<fcx> abec;
  
  public dzh()
  {
    AppMethodBeat.i(91568);
    this.abec = new LinkedList();
    AppMethodBeat.o(91568);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91569);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abeb != null)
      {
        paramVarArgs.qD(1, this.abeb.computeSize());
        this.abeb.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.abec);
      if (this.YMe != null) {
        paramVarArgs.g(3, this.YMe);
      }
      AppMethodBeat.o(91569);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abeb == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = i.a.a.a.qC(1, this.abeb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.abec);
      paramInt = i;
      if (this.YMe != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YMe);
      }
      AppMethodBeat.o(91569);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abec.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91569);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dzh localdzh = (dzh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91569);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eha();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eha)localObject2).parseFrom((byte[])localObject1);
            }
            localdzh.abeb = ((eha)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91569);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fcx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fcx)localObject2).parseFrom((byte[])localObject1);
            }
            localdzh.abec.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91569);
          return 0;
        }
        localdzh.YMe = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91569);
        return 0;
      }
      AppMethodBeat.o(91569);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzh
 * JD-Core Version:    0.7.0.1
 */