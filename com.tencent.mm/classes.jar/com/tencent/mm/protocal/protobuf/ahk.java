package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahk
  extends com.tencent.mm.bx.a
{
  public dtm Zqu;
  public LinkedList<aki> Zqv;
  public LinkedList<fxx> Zqw;
  public String Zqx;
  
  public ahk()
  {
    AppMethodBeat.i(91431);
    this.Zqv = new LinkedList();
    this.Zqw = new LinkedList();
    AppMethodBeat.o(91431);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91432);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zqu != null)
      {
        paramVarArgs.qD(1, this.Zqu.computeSize());
        this.Zqu.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Zqv);
      paramVarArgs.e(3, 8, this.Zqw);
      if (this.Zqx != null) {
        paramVarArgs.g(4, this.Zqx);
      }
      AppMethodBeat.o(91432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zqu == null) {
        break label580;
      }
    }
    label580:
    for (paramInt = i.a.a.a.qC(1, this.Zqu.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.Zqv) + i.a.a.a.c(3, 8, this.Zqw);
      paramInt = i;
      if (this.Zqx != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zqx);
      }
      AppMethodBeat.o(91432);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zqv.clear();
        this.Zqw.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91432);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ahk localahk = (ahk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91432);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtm)localObject2).parseFrom((byte[])localObject1);
            }
            localahk.Zqu = ((dtm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91432);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aki();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aki)localObject2).parseFrom((byte[])localObject1);
            }
            localahk.Zqv.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91432);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fxx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fxx)localObject2).parseFrom((byte[])localObject1);
            }
            localahk.Zqw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91432);
          return 0;
        }
        localahk.Zqx = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91432);
        return 0;
      }
      AppMethodBeat.o(91432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahk
 * JD-Core Version:    0.7.0.1
 */