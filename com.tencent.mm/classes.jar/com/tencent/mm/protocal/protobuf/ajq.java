package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajq
  extends com.tencent.mm.bx.a
{
  public String DlE;
  public float dpb;
  public float dqQ;
  public String evA;
  public String evz;
  public String goQ;
  public String htG;
  public String xoe;
  public int xog;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169004);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.x(1, this.dqQ);
      paramVarArgs.x(2, this.dpb);
      if (this.evA != null) {
        paramVarArgs.d(3, this.evA);
      }
      if (this.goQ != null) {
        paramVarArgs.d(4, this.goQ);
      }
      if (this.xoe != null) {
        paramVarArgs.d(5, this.xoe);
      }
      if (this.DlE != null) {
        paramVarArgs.d(6, this.DlE);
      }
      paramVarArgs.aR(7, this.xog);
      if (this.evz != null) {
        paramVarArgs.d(8, this.evz);
      }
      if (this.htG != null) {
        paramVarArgs.d(9, this.htG);
      }
      AppMethodBeat.o(169004);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 4 + 0 + (f.a.a.b.b.a.fY(2) + 4);
      paramInt = i;
      if (this.evA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.evA);
      }
      i = paramInt;
      if (this.goQ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.goQ);
      }
      paramInt = i;
      if (this.xoe != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.xoe);
      }
      i = paramInt;
      if (this.DlE != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DlE);
      }
      i += f.a.a.b.b.a.bA(7, this.xog);
      paramInt = i;
      if (this.evz != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.evz);
      }
      i = paramInt;
      if (this.htG != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.htG);
      }
      AppMethodBeat.o(169004);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(169004);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ajq localajq = (ajq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169004);
        return -1;
      case 1: 
        localajq.dqQ = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(169004);
        return 0;
      case 2: 
        localajq.dpb = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(169004);
        return 0;
      case 3: 
        localajq.evA = locala.KhF.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 4: 
        localajq.goQ = locala.KhF.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 5: 
        localajq.xoe = locala.KhF.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 6: 
        localajq.DlE = locala.KhF.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 7: 
        localajq.xog = locala.KhF.xS();
        AppMethodBeat.o(169004);
        return 0;
      case 8: 
        localajq.evz = locala.KhF.readString();
        AppMethodBeat.o(169004);
        return 0;
      }
      localajq.htG = locala.KhF.readString();
      AppMethodBeat.o(169004);
      return 0;
    }
    AppMethodBeat.o(169004);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajq
 * JD-Core Version:    0.7.0.1
 */