package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecf
  extends com.tencent.mm.bw.a
{
  public String Ncr;
  public String Ncs;
  public int Nct;
  public String Ncu;
  public String Ncv;
  public String appId;
  public String appName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(232382);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.e(1, this.appId);
      }
      if (this.appName != null) {
        paramVarArgs.e(2, this.appName);
      }
      if (this.Ncr != null) {
        paramVarArgs.e(3, this.Ncr);
      }
      if (this.Ncs != null) {
        paramVarArgs.e(4, this.Ncs);
      }
      paramVarArgs.aM(5, this.Nct);
      if (this.Ncu != null) {
        paramVarArgs.e(6, this.Ncu);
      }
      if (this.Ncv != null) {
        paramVarArgs.e(7, this.Ncv);
      }
      AppMethodBeat.o(232382);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label562;
      }
    }
    label562:
    for (int i = g.a.a.b.b.a.f(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.appName);
      }
      i = paramInt;
      if (this.Ncr != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Ncr);
      }
      paramInt = i;
      if (this.Ncs != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Ncs);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.Nct);
      paramInt = i;
      if (this.Ncu != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Ncu);
      }
      i = paramInt;
      if (this.Ncv != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Ncv);
      }
      AppMethodBeat.o(232382);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(232382);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ecf localecf = (ecf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(232382);
          return -1;
        case 1: 
          localecf.appId = locala.UbS.readString();
          AppMethodBeat.o(232382);
          return 0;
        case 2: 
          localecf.appName = locala.UbS.readString();
          AppMethodBeat.o(232382);
          return 0;
        case 3: 
          localecf.Ncr = locala.UbS.readString();
          AppMethodBeat.o(232382);
          return 0;
        case 4: 
          localecf.Ncs = locala.UbS.readString();
          AppMethodBeat.o(232382);
          return 0;
        case 5: 
          localecf.Nct = locala.UbS.zi();
          AppMethodBeat.o(232382);
          return 0;
        case 6: 
          localecf.Ncu = locala.UbS.readString();
          AppMethodBeat.o(232382);
          return 0;
        }
        localecf.Ncv = locala.UbS.readString();
        AppMethodBeat.o(232382);
        return 0;
      }
      AppMethodBeat.o(232382);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecf
 * JD-Core Version:    0.7.0.1
 */