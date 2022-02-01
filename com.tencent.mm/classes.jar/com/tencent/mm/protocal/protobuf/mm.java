package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mm
  extends com.tencent.mm.bx.a
{
  public int CIp;
  public int CIq;
  public int CJc;
  public int CJd;
  public int CJe;
  public xt CJf;
  public int CJg;
  public int CJh;
  public int CJi = 0;
  public int CJj;
  public int CzO;
  public String CzP;
  public String content;
  public String gGR;
  public String ocH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103203);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CJc);
      paramVarArgs.aR(2, this.CzO);
      if (this.CzP != null) {
        paramVarArgs.d(3, this.CzP);
      }
      if (this.ocH != null) {
        paramVarArgs.d(4, this.ocH);
      }
      if (this.gGR != null) {
        paramVarArgs.d(5, this.gGR);
      }
      if (this.content != null) {
        paramVarArgs.d(6, this.content);
      }
      paramVarArgs.aR(7, this.CJd);
      paramVarArgs.aR(8, this.CJe);
      paramVarArgs.aR(9, this.CIp);
      paramVarArgs.aR(10, this.CIq);
      if (this.CJf != null)
      {
        paramVarArgs.kX(11, this.CJf.computeSize());
        this.CJf.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(12, this.CJg);
      paramVarArgs.aR(13, this.CJh);
      paramVarArgs.aR(14, this.CJi);
      paramVarArgs.aR(15, this.CJj);
      AppMethodBeat.o(103203);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.CJc) + 0 + f.a.a.b.b.a.bA(2, this.CzO);
      paramInt = i;
      if (this.CzP != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CzP);
      }
      i = paramInt;
      if (this.ocH != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ocH);
      }
      paramInt = i;
      if (this.gGR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gGR);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.content);
      }
      i = i + f.a.a.b.b.a.bA(7, this.CJd) + f.a.a.b.b.a.bA(8, this.CJe) + f.a.a.b.b.a.bA(9, this.CIp) + f.a.a.b.b.a.bA(10, this.CIq);
      paramInt = i;
      if (this.CJf != null) {
        paramInt = i + f.a.a.a.kW(11, this.CJf.computeSize());
      }
      i = f.a.a.b.b.a.bA(12, this.CJg);
      int j = f.a.a.b.b.a.bA(13, this.CJh);
      int k = f.a.a.b.b.a.bA(14, this.CJi);
      int m = f.a.a.b.b.a.bA(15, this.CJj);
      AppMethodBeat.o(103203);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(103203);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      mm localmm = (mm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(103203);
        return -1;
      case 1: 
        localmm.CJc = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(103203);
        return 0;
      case 2: 
        localmm.CzO = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(103203);
        return 0;
      case 3: 
        localmm.CzP = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 4: 
        localmm.ocH = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 5: 
        localmm.gGR = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 6: 
        localmm.content = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 7: 
        localmm.CJd = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(103203);
        return 0;
      case 8: 
        localmm.CJe = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(103203);
        return 0;
      case 9: 
        localmm.CIp = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(103203);
        return 0;
      case 10: 
        localmm.CIq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(103203);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((xt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localmm.CJf = ((xt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(103203);
        return 0;
      case 12: 
        localmm.CJg = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(103203);
        return 0;
      case 13: 
        localmm.CJh = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(103203);
        return 0;
      case 14: 
        localmm.CJi = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(103203);
        return 0;
      }
      localmm.CJj = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(103203);
      return 0;
    }
    AppMethodBeat.o(103203);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mm
 * JD-Core Version:    0.7.0.1
 */