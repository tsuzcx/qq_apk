package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bjs
  extends com.tencent.mm.bv.a
{
  public String Name;
  public String gwQ;
  public String gwR;
  public String ped;
  public String wOC;
  public String wOD;
  public double wyO;
  public double wyP;
  public String xyb;
  public String xyc;
  public String xyd;
  public String xye;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113787);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.e(1, this.Name);
      }
      if (this.xyb != null) {
        paramVarArgs.e(2, this.xyb);
      }
      paramVarArgs.f(3, this.wyO);
      paramVarArgs.f(4, this.wyP);
      if (this.xyc != null) {
        paramVarArgs.e(5, this.xyc);
      }
      if (this.ped != null) {
        paramVarArgs.e(6, this.ped);
      }
      if (this.xyd != null) {
        paramVarArgs.e(7, this.xyd);
      }
      if (this.gwQ != null) {
        paramVarArgs.e(8, this.gwQ);
      }
      if (this.gwR != null) {
        paramVarArgs.e(9, this.gwR);
      }
      if (this.wOC != null) {
        paramVarArgs.e(10, this.wOC);
      }
      if (this.wOD != null) {
        paramVarArgs.e(11, this.wOD);
      }
      if (this.xye != null) {
        paramVarArgs.e(12, this.xye);
      }
      AppMethodBeat.o(113787);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label860;
      }
    }
    label860:
    for (paramInt = e.a.a.b.b.a.f(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xyb != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xyb);
      }
      i = i + (e.a.a.b.b.a.eW(3) + 8) + (e.a.a.b.b.a.eW(4) + 8);
      paramInt = i;
      if (this.xyc != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xyc);
      }
      i = paramInt;
      if (this.ped != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.ped);
      }
      paramInt = i;
      if (this.xyd != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xyd);
      }
      i = paramInt;
      if (this.gwQ != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.gwQ);
      }
      paramInt = i;
      if (this.gwR != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.gwR);
      }
      i = paramInt;
      if (this.wOC != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.wOC);
      }
      paramInt = i;
      if (this.wOD != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.wOD);
      }
      i = paramInt;
      if (this.xye != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.xye);
      }
      AppMethodBeat.o(113787);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(113787);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bjs localbjs = (bjs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113787);
          return -1;
        case 1: 
          localbjs.Name = locala.CLY.readString();
          AppMethodBeat.o(113787);
          return 0;
        case 2: 
          localbjs.xyb = locala.CLY.readString();
          AppMethodBeat.o(113787);
          return 0;
        case 3: 
          localbjs.wyO = Double.longBitsToDouble(locala.CLY.emy());
          AppMethodBeat.o(113787);
          return 0;
        case 4: 
          localbjs.wyP = Double.longBitsToDouble(locala.CLY.emy());
          AppMethodBeat.o(113787);
          return 0;
        case 5: 
          localbjs.xyc = locala.CLY.readString();
          AppMethodBeat.o(113787);
          return 0;
        case 6: 
          localbjs.ped = locala.CLY.readString();
          AppMethodBeat.o(113787);
          return 0;
        case 7: 
          localbjs.xyd = locala.CLY.readString();
          AppMethodBeat.o(113787);
          return 0;
        case 8: 
          localbjs.gwQ = locala.CLY.readString();
          AppMethodBeat.o(113787);
          return 0;
        case 9: 
          localbjs.gwR = locala.CLY.readString();
          AppMethodBeat.o(113787);
          return 0;
        case 10: 
          localbjs.wOC = locala.CLY.readString();
          AppMethodBeat.o(113787);
          return 0;
        case 11: 
          localbjs.wOD = locala.CLY.readString();
          AppMethodBeat.o(113787);
          return 0;
        }
        localbjs.xye = locala.CLY.readString();
        AppMethodBeat.o(113787);
        return 0;
      }
      AppMethodBeat.o(113787);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjs
 * JD-Core Version:    0.7.0.1
 */