package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class chx
  extends com.tencent.mm.bx.a
{
  public int FileSize;
  public int Fyv;
  public String HbD;
  public int HbE;
  public String HbF;
  public String HbG;
  public String HbH;
  public String HbI;
  public String HbJ;
  public int HbK;
  public String HbL;
  public int Scene;
  public String jdf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195477);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HbD == null)
      {
        paramVarArgs = new b("Not all required fields were included: FileMD5");
        AppMethodBeat.o(195477);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Scene);
      paramVarArgs.aS(2, this.Fyv);
      paramVarArgs.aS(3, this.FileSize);
      if (this.HbD != null) {
        paramVarArgs.d(4, this.HbD);
      }
      paramVarArgs.aS(5, this.HbE);
      if (this.HbF != null) {
        paramVarArgs.d(6, this.HbF);
      }
      if (this.HbG != null) {
        paramVarArgs.d(7, this.HbG);
      }
      if (this.HbH != null) {
        paramVarArgs.d(8, this.HbH);
      }
      if (this.HbI != null) {
        paramVarArgs.d(10, this.HbI);
      }
      if (this.HbJ != null) {
        paramVarArgs.d(11, this.HbJ);
      }
      paramVarArgs.aS(12, this.HbK);
      if (this.jdf != null) {
        paramVarArgs.d(13, this.jdf);
      }
      if (this.HbL != null) {
        paramVarArgs.d(14, this.HbL);
      }
      AppMethodBeat.o(195477);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Scene) + 0 + f.a.a.b.b.a.bz(2, this.Fyv) + f.a.a.b.b.a.bz(3, this.FileSize);
      paramInt = i;
      if (this.HbD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HbD);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HbE);
      paramInt = i;
      if (this.HbF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HbF);
      }
      i = paramInt;
      if (this.HbG != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HbG);
      }
      paramInt = i;
      if (this.HbH != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HbH);
      }
      i = paramInt;
      if (this.HbI != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.HbI);
      }
      paramInt = i;
      if (this.HbJ != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HbJ);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.HbK);
      paramInt = i;
      if (this.jdf != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.jdf);
      }
      i = paramInt;
      if (this.HbL != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.HbL);
      }
      AppMethodBeat.o(195477);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.HbD == null)
      {
        paramVarArgs = new b("Not all required fields were included: FileMD5");
        AppMethodBeat.o(195477);
        throw paramVarArgs;
      }
      AppMethodBeat.o(195477);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      chx localchx = (chx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 9: 
      default: 
        AppMethodBeat.o(195477);
        return -1;
      case 1: 
        localchx.Scene = locala.NPN.zc();
        AppMethodBeat.o(195477);
        return 0;
      case 2: 
        localchx.Fyv = locala.NPN.zc();
        AppMethodBeat.o(195477);
        return 0;
      case 3: 
        localchx.FileSize = locala.NPN.zc();
        AppMethodBeat.o(195477);
        return 0;
      case 4: 
        localchx.HbD = locala.NPN.readString();
        AppMethodBeat.o(195477);
        return 0;
      case 5: 
        localchx.HbE = locala.NPN.zc();
        AppMethodBeat.o(195477);
        return 0;
      case 6: 
        localchx.HbF = locala.NPN.readString();
        AppMethodBeat.o(195477);
        return 0;
      case 7: 
        localchx.HbG = locala.NPN.readString();
        AppMethodBeat.o(195477);
        return 0;
      case 8: 
        localchx.HbH = locala.NPN.readString();
        AppMethodBeat.o(195477);
        return 0;
      case 10: 
        localchx.HbI = locala.NPN.readString();
        AppMethodBeat.o(195477);
        return 0;
      case 11: 
        localchx.HbJ = locala.NPN.readString();
        AppMethodBeat.o(195477);
        return 0;
      case 12: 
        localchx.HbK = locala.NPN.zc();
        AppMethodBeat.o(195477);
        return 0;
      case 13: 
        localchx.jdf = locala.NPN.readString();
        AppMethodBeat.o(195477);
        return 0;
      }
      localchx.HbL = locala.NPN.readString();
      AppMethodBeat.o(195477);
      return 0;
    }
    AppMethodBeat.o(195477);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chx
 * JD-Core Version:    0.7.0.1
 */