package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eam
  extends com.tencent.mm.bx.a
{
  public int aaUp;
  public String abfJ;
  public String abfK;
  public String abfL;
  public String abfM;
  public wg abfN;
  public String abfO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114049);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abfJ != null) {
        paramVarArgs.g(1, this.abfJ);
      }
      if (this.abfK != null) {
        paramVarArgs.g(2, this.abfK);
      }
      if (this.abfL != null) {
        paramVarArgs.g(3, this.abfL);
      }
      paramVarArgs.bS(4, this.aaUp);
      if (this.abfM != null) {
        paramVarArgs.g(5, this.abfM);
      }
      if (this.abfN != null)
      {
        paramVarArgs.qD(6, this.abfN.computeSize());
        this.abfN.writeFields(paramVarArgs);
      }
      if (this.abfO != null) {
        paramVarArgs.g(7, this.abfO);
      }
      AppMethodBeat.o(114049);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abfJ == null) {
        break label632;
      }
    }
    label632:
    for (int i = i.a.a.b.b.a.h(1, this.abfJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abfK != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abfK);
      }
      i = paramInt;
      if (this.abfL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abfL);
      }
      i += i.a.a.b.b.a.cJ(4, this.aaUp);
      paramInt = i;
      if (this.abfM != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abfM);
      }
      i = paramInt;
      if (this.abfN != null) {
        i = paramInt + i.a.a.a.qC(6, this.abfN.computeSize());
      }
      paramInt = i;
      if (this.abfO != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abfO);
      }
      AppMethodBeat.o(114049);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114049);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eam localeam = (eam)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114049);
          return -1;
        case 1: 
          localeam.abfJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 2: 
          localeam.abfK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 3: 
          localeam.abfL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 4: 
          localeam.aaUp = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114049);
          return 0;
        case 5: 
          localeam.abfM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            wg localwg = new wg();
            if ((localObject != null) && (localObject.length > 0)) {
              localwg.parseFrom((byte[])localObject);
            }
            localeam.abfN = localwg;
            paramInt += 1;
          }
          AppMethodBeat.o(114049);
          return 0;
        }
        localeam.abfO = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(114049);
        return 0;
      }
      AppMethodBeat.o(114049);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eam
 * JD-Core Version:    0.7.0.1
 */