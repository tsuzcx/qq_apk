package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzl
  extends com.tencent.mm.bx.a
{
  public String DFo;
  public int DWh;
  public String DWi;
  public int DWj;
  public String DWk;
  public int DWl;
  public String DWm;
  public long DWn;
  public LinkedList<bzc> DWo;
  public String hiN;
  public String uop;
  public String vBv;
  
  public bzl()
  {
    AppMethodBeat.i(91593);
    this.DWo = new LinkedList();
    AppMethodBeat.o(91593);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91594);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DWh);
      if (this.DWi != null) {
        paramVarArgs.d(2, this.DWi);
      }
      if (this.DFo != null) {
        paramVarArgs.d(3, this.DFo);
      }
      paramVarArgs.aR(4, this.DWj);
      if (this.uop != null) {
        paramVarArgs.d(5, this.uop);
      }
      if (this.DWk != null) {
        paramVarArgs.d(6, this.DWk);
      }
      if (this.vBv != null) {
        paramVarArgs.d(7, this.vBv);
      }
      paramVarArgs.aR(8, this.DWl);
      if (this.hiN != null) {
        paramVarArgs.d(9, this.hiN);
      }
      if (this.DWm != null) {
        paramVarArgs.d(10, this.DWm);
      }
      paramVarArgs.aG(11, this.DWn);
      paramVarArgs.e(12, 8, this.DWo);
      AppMethodBeat.o(91594);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.DWh) + 0;
      paramInt = i;
      if (this.DWi != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DWi);
      }
      i = paramInt;
      if (this.DFo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DFo);
      }
      i += f.a.a.b.b.a.bA(4, this.DWj);
      paramInt = i;
      if (this.uop != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.uop);
      }
      i = paramInt;
      if (this.DWk != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DWk);
      }
      paramInt = i;
      if (this.vBv != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vBv);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.DWl);
      paramInt = i;
      if (this.hiN != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.hiN);
      }
      i = paramInt;
      if (this.DWm != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.DWm);
      }
      paramInt = f.a.a.b.b.a.q(11, this.DWn);
      int j = f.a.a.a.c(12, 8, this.DWo);
      AppMethodBeat.o(91594);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DWo.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91594);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bzl localbzl = (bzl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91594);
        return -1;
      case 1: 
        localbzl.DWh = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91594);
        return 0;
      case 2: 
        localbzl.DWi = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 3: 
        localbzl.DFo = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 4: 
        localbzl.DWj = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91594);
        return 0;
      case 5: 
        localbzl.uop = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 6: 
        localbzl.DWk = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 7: 
        localbzl.vBv = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 8: 
        localbzl.DWl = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91594);
        return 0;
      case 9: 
        localbzl.hiN = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 10: 
        localbzl.DWm = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 11: 
        localbzl.DWn = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(91594);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bzc();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bzc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbzl.DWo.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91594);
      return 0;
    }
    AppMethodBeat.o(91594);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzl
 * JD-Core Version:    0.7.0.1
 */