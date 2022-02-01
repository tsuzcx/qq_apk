package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ast
  extends com.tencent.mm.bw.a
{
  public int GJM;
  public int GJN;
  public b GJO;
  public LinkedList<String> LGw;
  public int count;
  public int oEe;
  public String path;
  public String pqW;
  public String title;
  public int uoi;
  public String xvd;
  
  public ast()
  {
    AppMethodBeat.i(224432);
    this.LGw = new LinkedList();
    AppMethodBeat.o(224432);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184212);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uoi);
      paramVarArgs.aS(2, this.count);
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.pqW != null) {
        paramVarArgs.d(4, this.pqW);
      }
      paramVarArgs.aS(5, this.GJM);
      if (this.path != null) {
        paramVarArgs.d(6, this.path);
      }
      if (this.xvd != null) {
        paramVarArgs.d(7, this.xvd);
      }
      paramVarArgs.aS(8, this.GJN);
      if (this.GJO != null) {
        paramVarArgs.c(9, this.GJO);
      }
      paramVarArgs.e(10, 1, this.LGw);
      paramVarArgs.aS(11, this.oEe);
      AppMethodBeat.o(184212);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.uoi) + 0 + f.a.a.b.b.a.bz(2, this.count);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.title);
      }
      i = paramInt;
      if (this.pqW != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.pqW);
      }
      i += f.a.a.b.b.a.bz(5, this.GJM);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.path);
      }
      i = paramInt;
      if (this.xvd != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.xvd);
      }
      i += f.a.a.b.b.a.bz(8, this.GJN);
      paramInt = i;
      if (this.GJO != null) {
        paramInt = i + f.a.a.b.b.a.b(9, this.GJO);
      }
      i = f.a.a.a.c(10, 1, this.LGw);
      int j = f.a.a.b.b.a.bz(11, this.oEe);
      AppMethodBeat.o(184212);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LGw.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(184212);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ast localast = (ast)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184212);
        return -1;
      case 1: 
        localast.uoi = locala.OmT.zc();
        AppMethodBeat.o(184212);
        return 0;
      case 2: 
        localast.count = locala.OmT.zc();
        AppMethodBeat.o(184212);
        return 0;
      case 3: 
        localast.title = locala.OmT.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 4: 
        localast.pqW = locala.OmT.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 5: 
        localast.GJM = locala.OmT.zc();
        AppMethodBeat.o(184212);
        return 0;
      case 6: 
        localast.path = locala.OmT.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 7: 
        localast.xvd = locala.OmT.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 8: 
        localast.GJN = locala.OmT.zc();
        AppMethodBeat.o(184212);
        return 0;
      case 9: 
        localast.GJO = locala.OmT.gCk();
        AppMethodBeat.o(184212);
        return 0;
      case 10: 
        localast.LGw.add(locala.OmT.readString());
        AppMethodBeat.o(184212);
        return 0;
      }
      localast.oEe = locala.OmT.zc();
      AppMethodBeat.o(184212);
      return 0;
    }
    AppMethodBeat.o(184212);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ast
 * JD-Core Version:    0.7.0.1
 */