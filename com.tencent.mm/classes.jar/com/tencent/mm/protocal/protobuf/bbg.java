package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbg
  extends com.tencent.mm.cd.a
{
  public int SMT;
  public String SMU;
  public String SMV;
  public String SMW;
  public String SMX;
  public String SMY;
  public String SMZ;
  public String SNa;
  public boolean playable;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229797);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SMT);
      if (this.SMU != null) {
        paramVarArgs.f(2, this.SMU);
      }
      if (this.SMV != null) {
        paramVarArgs.f(3, this.SMV);
      }
      if (this.SMW != null) {
        paramVarArgs.f(4, this.SMW);
      }
      if (this.SMX != null) {
        paramVarArgs.f(5, this.SMX);
      }
      if (this.SMY != null) {
        paramVarArgs.f(6, this.SMY);
      }
      paramVarArgs.co(7, this.playable);
      if (this.SMZ != null) {
        paramVarArgs.f(8, this.SMZ);
      }
      if (this.SNa != null) {
        paramVarArgs.f(9, this.SNa);
      }
      AppMethodBeat.o(229797);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SMT) + 0;
      paramInt = i;
      if (this.SMU != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SMU);
      }
      i = paramInt;
      if (this.SMV != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SMV);
      }
      paramInt = i;
      if (this.SMW != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SMW);
      }
      i = paramInt;
      if (this.SMX != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SMX);
      }
      paramInt = i;
      if (this.SMY != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SMY);
      }
      i = paramInt + (g.a.a.b.b.a.gL(7) + 1);
      paramInt = i;
      if (this.SMZ != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.SMZ);
      }
      i = paramInt;
      if (this.SNa != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.SNa);
      }
      AppMethodBeat.o(229797);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(229797);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bbg localbbg = (bbg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(229797);
        return -1;
      case 1: 
        localbbg.SMT = locala.abFh.AK();
        AppMethodBeat.o(229797);
        return 0;
      case 2: 
        localbbg.SMU = locala.abFh.readString();
        AppMethodBeat.o(229797);
        return 0;
      case 3: 
        localbbg.SMV = locala.abFh.readString();
        AppMethodBeat.o(229797);
        return 0;
      case 4: 
        localbbg.SMW = locala.abFh.readString();
        AppMethodBeat.o(229797);
        return 0;
      case 5: 
        localbbg.SMX = locala.abFh.readString();
        AppMethodBeat.o(229797);
        return 0;
      case 6: 
        localbbg.SMY = locala.abFh.readString();
        AppMethodBeat.o(229797);
        return 0;
      case 7: 
        localbbg.playable = locala.abFh.AB();
        AppMethodBeat.o(229797);
        return 0;
      case 8: 
        localbbg.SMZ = locala.abFh.readString();
        AppMethodBeat.o(229797);
        return 0;
      }
      localbbg.SNa = locala.abFh.readString();
      AppMethodBeat.o(229797);
      return 0;
    }
    AppMethodBeat.o(229797);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbg
 * JD-Core Version:    0.7.0.1
 */