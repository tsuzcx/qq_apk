package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bqt
  extends com.tencent.mm.bx.a
{
  public String ZYE;
  public String ZYF;
  public String ZYG;
  public String ZYH;
  public int ZYI;
  public String ZYJ;
  public String ZYK;
  public String appName;
  public String nVM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169017);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZYE != null) {
        paramVarArgs.g(1, this.ZYE);
      }
      if (this.ZYF != null) {
        paramVarArgs.g(2, this.ZYF);
      }
      if (this.ZYG != null) {
        paramVarArgs.g(3, this.ZYG);
      }
      if (this.appName != null) {
        paramVarArgs.g(4, this.appName);
      }
      if (this.ZYH != null) {
        paramVarArgs.g(5, this.ZYH);
      }
      if (this.nVM != null) {
        paramVarArgs.g(6, this.nVM);
      }
      paramVarArgs.bS(7, this.ZYI);
      if (this.ZYJ != null) {
        paramVarArgs.g(8, this.ZYJ);
      }
      if (this.ZYK != null) {
        paramVarArgs.g(9, this.ZYK);
      }
      AppMethodBeat.o(169017);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZYE == null) {
        break label682;
      }
    }
    label682:
    for (int i = i.a.a.b.b.a.h(1, this.ZYE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZYF != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZYF);
      }
      i = paramInt;
      if (this.ZYG != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZYG);
      }
      paramInt = i;
      if (this.appName != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.appName);
      }
      i = paramInt;
      if (this.ZYH != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZYH);
      }
      paramInt = i;
      if (this.nVM != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.nVM);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.ZYI);
      paramInt = i;
      if (this.ZYJ != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZYJ);
      }
      i = paramInt;
      if (this.ZYK != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZYK);
      }
      AppMethodBeat.o(169017);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169017);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bqt localbqt = (bqt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169017);
          return -1;
        case 1: 
          localbqt.ZYE = locala.ajGk.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 2: 
          localbqt.ZYF = locala.ajGk.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 3: 
          localbqt.ZYG = locala.ajGk.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 4: 
          localbqt.appName = locala.ajGk.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 5: 
          localbqt.ZYH = locala.ajGk.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 6: 
          localbqt.nVM = locala.ajGk.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 7: 
          localbqt.ZYI = locala.ajGk.aar();
          AppMethodBeat.o(169017);
          return 0;
        case 8: 
          localbqt.ZYJ = locala.ajGk.readString();
          AppMethodBeat.o(169017);
          return 0;
        }
        localbqt.ZYK = locala.ajGk.readString();
        AppMethodBeat.o(169017);
        return 0;
      }
      AppMethodBeat.o(169017);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqt
 * JD-Core Version:    0.7.0.1
 */