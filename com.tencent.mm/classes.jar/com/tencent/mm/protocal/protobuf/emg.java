package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class emg
  extends com.tencent.mm.cd.a
{
  public String UoO;
  public String UoP;
  public int UoQ;
  public String UoR;
  public String UoS;
  public String appId;
  public String appName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(279635);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.f(1, this.appId);
      }
      if (this.appName != null) {
        paramVarArgs.f(2, this.appName);
      }
      if (this.UoO != null) {
        paramVarArgs.f(3, this.UoO);
      }
      if (this.UoP != null) {
        paramVarArgs.f(4, this.UoP);
      }
      paramVarArgs.aY(5, this.UoQ);
      if (this.UoR != null) {
        paramVarArgs.f(6, this.UoR);
      }
      if (this.UoS != null) {
        paramVarArgs.f(7, this.UoS);
      }
      AppMethodBeat.o(279635);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label562;
      }
    }
    label562:
    for (int i = g.a.a.b.b.a.g(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.appName);
      }
      i = paramInt;
      if (this.UoO != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.UoO);
      }
      paramInt = i;
      if (this.UoP != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UoP);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.UoQ);
      paramInt = i;
      if (this.UoR != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UoR);
      }
      i = paramInt;
      if (this.UoS != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.UoS);
      }
      AppMethodBeat.o(279635);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(279635);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        emg localemg = (emg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(279635);
          return -1;
        case 1: 
          localemg.appId = locala.abFh.readString();
          AppMethodBeat.o(279635);
          return 0;
        case 2: 
          localemg.appName = locala.abFh.readString();
          AppMethodBeat.o(279635);
          return 0;
        case 3: 
          localemg.UoO = locala.abFh.readString();
          AppMethodBeat.o(279635);
          return 0;
        case 4: 
          localemg.UoP = locala.abFh.readString();
          AppMethodBeat.o(279635);
          return 0;
        case 5: 
          localemg.UoQ = locala.abFh.AK();
          AppMethodBeat.o(279635);
          return 0;
        case 6: 
          localemg.UoR = locala.abFh.readString();
          AppMethodBeat.o(279635);
          return 0;
        }
        localemg.UoS = locala.abFh.readString();
        AppMethodBeat.o(279635);
        return 0;
      }
      AppMethodBeat.o(279635);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emg
 * JD-Core Version:    0.7.0.1
 */