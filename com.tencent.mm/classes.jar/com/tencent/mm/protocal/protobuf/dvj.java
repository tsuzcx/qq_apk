package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvj
  extends com.tencent.mm.bx.a
{
  public String GKK;
  public String GKj;
  public String HHM;
  public String cUM;
  public String duW;
  public String oIu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123678);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.duW != null) {
        paramVarArgs.d(1, this.duW);
      }
      if (this.cUM != null) {
        paramVarArgs.d(2, this.cUM);
      }
      if (this.GKK != null) {
        paramVarArgs.d(3, this.GKK);
      }
      if (this.HHM != null) {
        paramVarArgs.d(4, this.HHM);
      }
      if (this.oIu != null) {
        paramVarArgs.d(5, this.oIu);
      }
      if (this.GKj != null) {
        paramVarArgs.d(6, this.GKj);
      }
      AppMethodBeat.o(123678);
      return 0;
    }
    if (paramInt == 1) {
      if (this.duW == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.duW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cUM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.cUM);
      }
      i = paramInt;
      if (this.GKK != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GKK);
      }
      paramInt = i;
      if (this.HHM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HHM);
      }
      i = paramInt;
      if (this.oIu != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.oIu);
      }
      paramInt = i;
      if (this.GKj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GKj);
      }
      AppMethodBeat.o(123678);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123678);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvj localdvj = (dvj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123678);
          return -1;
        case 1: 
          localdvj.duW = locala.NPN.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 2: 
          localdvj.cUM = locala.NPN.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 3: 
          localdvj.GKK = locala.NPN.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 4: 
          localdvj.HHM = locala.NPN.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 5: 
          localdvj.oIu = locala.NPN.readString();
          AppMethodBeat.o(123678);
          return 0;
        }
        localdvj.GKj = locala.NPN.readString();
        AppMethodBeat.o(123678);
        return 0;
      }
      AppMethodBeat.o(123678);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvj
 * JD-Core Version:    0.7.0.1
 */