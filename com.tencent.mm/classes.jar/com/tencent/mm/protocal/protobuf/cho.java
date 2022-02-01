package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cho
  extends com.tencent.mm.bx.a
{
  public act Edc;
  public String Edd;
  public String Ede;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104830);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Edc != null)
      {
        paramVarArgs.kX(1, this.Edc.computeSize());
        this.Edc.writeFields(paramVarArgs);
      }
      if (this.Edd != null) {
        paramVarArgs.d(2, this.Edd);
      }
      paramVarArgs.aR(3, this.type);
      if (this.Ede != null) {
        paramVarArgs.d(4, this.Ede);
      }
      AppMethodBeat.o(104830);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Edc == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.a.kW(1, this.Edc.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Edd != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Edd);
      }
      i += f.a.a.b.b.a.bA(3, this.type);
      paramInt = i;
      if (this.Ede != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ede);
      }
      AppMethodBeat.o(104830);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(104830);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cho localcho = (cho)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104830);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new act();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((act)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcho.Edc = ((act)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104830);
          return 0;
        case 2: 
          localcho.Edd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104830);
          return 0;
        case 3: 
          localcho.type = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104830);
          return 0;
        }
        localcho.Ede = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(104830);
        return 0;
      }
      AppMethodBeat.o(104830);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cho
 * JD-Core Version:    0.7.0.1
 */