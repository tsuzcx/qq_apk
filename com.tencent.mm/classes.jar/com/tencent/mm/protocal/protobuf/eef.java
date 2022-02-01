package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eef
  extends com.tencent.mm.bx.a
{
  public String abjj;
  public LinkedList<eeg> abjk;
  public LinkedList<eem> abjl;
  public LinkedList<eem> abjm;
  
  public eef()
  {
    AppMethodBeat.i(260160);
    this.abjk = new LinkedList();
    this.abjl = new LinkedList();
    this.abjm = new LinkedList();
    AppMethodBeat.o(260160);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260166);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abjj != null) {
        paramVarArgs.g(1, this.abjj);
      }
      paramVarArgs.e(2, 8, this.abjk);
      paramVarArgs.e(3, 8, this.abjl);
      paramVarArgs.e(4, 8, this.abjm);
      AppMethodBeat.o(260166);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abjj == null) {
        break label572;
      }
    }
    label572:
    for (paramInt = i.a.a.b.b.a.h(1, this.abjj) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.abjk);
      int j = i.a.a.a.c(3, 8, this.abjl);
      int k = i.a.a.a.c(4, 8, this.abjm);
      AppMethodBeat.o(260166);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abjk.clear();
        this.abjl.clear();
        this.abjm.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260166);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eef localeef = (eef)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260166);
          return -1;
        case 1: 
          localeef.abjj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260166);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eeg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eeg)localObject2).parseFrom((byte[])localObject1);
            }
            localeef.abjk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260166);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eem();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eem)localObject2).parseFrom((byte[])localObject1);
            }
            localeef.abjl.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260166);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eem();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eem)localObject2).parseFrom((byte[])localObject1);
          }
          localeef.abjm.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260166);
        return 0;
      }
      AppMethodBeat.o(260166);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eef
 * JD-Core Version:    0.7.0.1
 */