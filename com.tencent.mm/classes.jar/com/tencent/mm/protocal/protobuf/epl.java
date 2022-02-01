package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class epl
  extends com.tencent.mm.bx.a
{
  public dfc abtE;
  public dfc abtF;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72578);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.g(1, this.wording);
      }
      if (this.abtE != null)
      {
        paramVarArgs.qD(2, this.abtE.computeSize());
        this.abtE.writeFields(paramVarArgs);
      }
      if (this.abtF != null)
      {
        paramVarArgs.qD(3, this.abtF.computeSize());
        this.abtF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72578);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label478;
      }
    }
    label478:
    for (int i = i.a.a.b.b.a.h(1, this.wording) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abtE != null) {
        paramInt = i + i.a.a.a.qC(2, this.abtE.computeSize());
      }
      i = paramInt;
      if (this.abtF != null) {
        i = paramInt + i.a.a.a.qC(3, this.abtF.computeSize());
      }
      AppMethodBeat.o(72578);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72578);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        epl localepl = (epl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        dfc localdfc;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72578);
          return -1;
        case 1: 
          localepl.wording = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72578);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdfc = new dfc();
            if ((localObject != null) && (localObject.length > 0)) {
              localdfc.parseFrom((byte[])localObject);
            }
            localepl.abtE = localdfc;
            paramInt += 1;
          }
          AppMethodBeat.o(72578);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localdfc = new dfc();
          if ((localObject != null) && (localObject.length > 0)) {
            localdfc.parseFrom((byte[])localObject);
          }
          localepl.abtF = localdfc;
          paramInt += 1;
        }
        AppMethodBeat.o(72578);
        return 0;
      }
      AppMethodBeat.o(72578);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epl
 * JD-Core Version:    0.7.0.1
 */