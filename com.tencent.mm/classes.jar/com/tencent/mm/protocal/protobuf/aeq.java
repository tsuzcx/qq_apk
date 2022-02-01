package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aeq
  extends com.tencent.mm.bx.a
{
  public String DeA;
  public String DeM;
  public String DeN;
  public int DeO;
  public int DeP;
  public String DeQ;
  public String DeR;
  public String DeS;
  public int Dey;
  public String Dez;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32206);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Dey);
      if (this.Dez != null) {
        paramVarArgs.d(2, this.Dez);
      }
      if (this.DeM != null) {
        paramVarArgs.d(3, this.DeM);
      }
      if (this.DeN != null) {
        paramVarArgs.d(4, this.DeN);
      }
      paramVarArgs.aR(5, this.DeO);
      paramVarArgs.aR(6, this.DeP);
      if (this.DeQ != null) {
        paramVarArgs.d(7, this.DeQ);
      }
      if (this.DeA != null) {
        paramVarArgs.d(8, this.DeA);
      }
      if (this.DeR != null) {
        paramVarArgs.d(9, this.DeR);
      }
      if (this.DeS != null) {
        paramVarArgs.d(10, this.DeS);
      }
      AppMethodBeat.o(32206);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Dey) + 0;
      paramInt = i;
      if (this.Dez != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dez);
      }
      i = paramInt;
      if (this.DeM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DeM);
      }
      paramInt = i;
      if (this.DeN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DeN);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.DeO) + f.a.a.b.b.a.bA(6, this.DeP);
      paramInt = i;
      if (this.DeQ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DeQ);
      }
      i = paramInt;
      if (this.DeA != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DeA);
      }
      paramInt = i;
      if (this.DeR != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DeR);
      }
      i = paramInt;
      if (this.DeS != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.DeS);
      }
      AppMethodBeat.o(32206);
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
      AppMethodBeat.o(32206);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aeq localaeq = (aeq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32206);
        return -1;
      case 1: 
        localaeq.Dey = locala.KhF.xS();
        AppMethodBeat.o(32206);
        return 0;
      case 2: 
        localaeq.Dez = locala.KhF.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 3: 
        localaeq.DeM = locala.KhF.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 4: 
        localaeq.DeN = locala.KhF.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 5: 
        localaeq.DeO = locala.KhF.xS();
        AppMethodBeat.o(32206);
        return 0;
      case 6: 
        localaeq.DeP = locala.KhF.xS();
        AppMethodBeat.o(32206);
        return 0;
      case 7: 
        localaeq.DeQ = locala.KhF.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 8: 
        localaeq.DeA = locala.KhF.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 9: 
        localaeq.DeR = locala.KhF.readString();
        AppMethodBeat.o(32206);
        return 0;
      }
      localaeq.DeS = locala.KhF.readString();
      AppMethodBeat.o(32206);
      return 0;
    }
    AppMethodBeat.o(32206);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeq
 * JD-Core Version:    0.7.0.1
 */