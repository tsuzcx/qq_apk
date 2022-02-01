package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class emx
  extends com.tencent.mm.bx.a
{
  public String MFq;
  public int Qmp;
  public String XOr;
  public int abrd;
  public int abre;
  public int abrf;
  public String abrg;
  public int abrh;
  public int lsO;
  public int scene;
  public long startTime;
  public String toUser;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260241);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.lsO);
      paramVarArgs.bS(2, this.abrd);
      if (this.XOr != null) {
        paramVarArgs.g(3, this.XOr);
      }
      paramVarArgs.bS(4, this.abre);
      paramVarArgs.bS(5, this.abrf);
      paramVarArgs.bS(6, this.scene);
      if (this.MFq != null) {
        paramVarArgs.g(7, this.MFq);
      }
      if (this.abrg != null) {
        paramVarArgs.g(8, this.abrg);
      }
      paramVarArgs.bS(9, this.Qmp);
      paramVarArgs.bS(10, this.abrh);
      if (this.toUser != null) {
        paramVarArgs.g(11, this.toUser);
      }
      paramVarArgs.bv(12, this.startTime);
      AppMethodBeat.o(260241);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.lsO) + 0 + i.a.a.b.b.a.cJ(2, this.abrd);
      paramInt = i;
      if (this.XOr != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.XOr);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.abre) + i.a.a.b.b.a.cJ(5, this.abrf) + i.a.a.b.b.a.cJ(6, this.scene);
      paramInt = i;
      if (this.MFq != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.MFq);
      }
      i = paramInt;
      if (this.abrg != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.abrg);
      }
      i = i + i.a.a.b.b.a.cJ(9, this.Qmp) + i.a.a.b.b.a.cJ(10, this.abrh);
      paramInt = i;
      if (this.toUser != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.toUser);
      }
      i = i.a.a.b.b.a.q(12, this.startTime);
      AppMethodBeat.o(260241);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260241);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      emx localemx = (emx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260241);
        return -1;
      case 1: 
        localemx.lsO = locala.ajGk.aar();
        AppMethodBeat.o(260241);
        return 0;
      case 2: 
        localemx.abrd = locala.ajGk.aar();
        AppMethodBeat.o(260241);
        return 0;
      case 3: 
        localemx.XOr = locala.ajGk.readString();
        AppMethodBeat.o(260241);
        return 0;
      case 4: 
        localemx.abre = locala.ajGk.aar();
        AppMethodBeat.o(260241);
        return 0;
      case 5: 
        localemx.abrf = locala.ajGk.aar();
        AppMethodBeat.o(260241);
        return 0;
      case 6: 
        localemx.scene = locala.ajGk.aar();
        AppMethodBeat.o(260241);
        return 0;
      case 7: 
        localemx.MFq = locala.ajGk.readString();
        AppMethodBeat.o(260241);
        return 0;
      case 8: 
        localemx.abrg = locala.ajGk.readString();
        AppMethodBeat.o(260241);
        return 0;
      case 9: 
        localemx.Qmp = locala.ajGk.aar();
        AppMethodBeat.o(260241);
        return 0;
      case 10: 
        localemx.abrh = locala.ajGk.aar();
        AppMethodBeat.o(260241);
        return 0;
      case 11: 
        localemx.toUser = locala.ajGk.readString();
        AppMethodBeat.o(260241);
        return 0;
      }
      localemx.startTime = locala.ajGk.aaw();
      AppMethodBeat.o(260241);
      return 0;
    }
    AppMethodBeat.o(260241);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emx
 * JD-Core Version:    0.7.0.1
 */