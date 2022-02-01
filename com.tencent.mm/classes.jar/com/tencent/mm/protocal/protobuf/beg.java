package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class beg
  extends com.tencent.mm.bx.a
{
  public int Edd;
  public String Ede;
  public String ZOI;
  public String ZOJ;
  public int ZOK;
  public int ZOL;
  public cbp ZOM;
  public int status;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258810);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZOI != null) {
        paramVarArgs.g(1, this.ZOI);
      }
      paramVarArgs.bS(2, this.status);
      if (this.title != null) {
        paramVarArgs.g(3, this.title);
      }
      if (this.ZOJ != null) {
        paramVarArgs.g(4, this.ZOJ);
      }
      paramVarArgs.bS(5, this.ZOK);
      paramVarArgs.bS(6, this.ZOL);
      if (this.ZOM != null)
      {
        paramVarArgs.qD(7, this.ZOM.computeSize());
        this.ZOM.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.Edd);
      if (this.Ede != null) {
        paramVarArgs.g(9, this.Ede);
      }
      AppMethodBeat.o(258810);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZOI == null) {
        break label708;
      }
    }
    label708:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZOI) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.status);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.title);
      }
      i = paramInt;
      if (this.ZOJ != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.ZOJ);
      }
      i = i + i.a.a.b.b.a.cJ(5, this.ZOK) + i.a.a.b.b.a.cJ(6, this.ZOL);
      paramInt = i;
      if (this.ZOM != null) {
        paramInt = i + i.a.a.a.qC(7, this.ZOM.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.Edd);
      paramInt = i;
      if (this.Ede != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Ede);
      }
      AppMethodBeat.o(258810);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258810);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        beg localbeg = (beg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258810);
          return -1;
        case 1: 
          localbeg.ZOI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258810);
          return 0;
        case 2: 
          localbeg.status = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258810);
          return 0;
        case 3: 
          localbeg.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258810);
          return 0;
        case 4: 
          localbeg.ZOJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258810);
          return 0;
        case 5: 
          localbeg.ZOK = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258810);
          return 0;
        case 6: 
          localbeg.ZOL = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258810);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cbp localcbp = new cbp();
            if ((localObject != null) && (localObject.length > 0)) {
              localcbp.parseFrom((byte[])localObject);
            }
            localbeg.ZOM = localcbp;
            paramInt += 1;
          }
          AppMethodBeat.o(258810);
          return 0;
        case 8: 
          localbeg.Edd = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258810);
          return 0;
        }
        localbeg.Ede = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258810);
        return 0;
      }
      AppMethodBeat.o(258810);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beg
 * JD-Core Version:    0.7.0.1
 */