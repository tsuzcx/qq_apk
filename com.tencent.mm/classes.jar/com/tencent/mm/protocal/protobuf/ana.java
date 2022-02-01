package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ana
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String IGU;
  public String IHo;
  public String ProductID;
  public String ZtV;
  public int ZtW;
  public int ZtX;
  public String ZtY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104767);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGU != null) {
        paramVarArgs.g(1, this.IGU);
      }
      if (this.IHo != null) {
        paramVarArgs.g(2, this.IHo);
      }
      if (this.ZtV != null) {
        paramVarArgs.g(3, this.ZtV);
      }
      paramVarArgs.bS(4, this.ZtW);
      if (this.ProductID != null) {
        paramVarArgs.g(5, this.ProductID);
      }
      paramVarArgs.bS(6, this.ZtX);
      if (this.ZtY != null) {
        paramVarArgs.g(7, this.ZtY);
      }
      if (this.IGG != null) {
        paramVarArgs.g(8, this.IGG);
      }
      AppMethodBeat.o(104767);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGU == null) {
        break label606;
      }
    }
    label606:
    for (int i = i.a.a.b.b.a.h(1, this.IGU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IHo != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IHo);
      }
      i = paramInt;
      if (this.ZtV != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZtV);
      }
      i += i.a.a.b.b.a.cJ(4, this.ZtW);
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ProductID);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.ZtX);
      paramInt = i;
      if (this.ZtY != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZtY);
      }
      i = paramInt;
      if (this.IGG != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.IGG);
      }
      AppMethodBeat.o(104767);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104767);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ana localana = (ana)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104767);
          return -1;
        case 1: 
          localana.IGU = locala.ajGk.readString();
          AppMethodBeat.o(104767);
          return 0;
        case 2: 
          localana.IHo = locala.ajGk.readString();
          AppMethodBeat.o(104767);
          return 0;
        case 3: 
          localana.ZtV = locala.ajGk.readString();
          AppMethodBeat.o(104767);
          return 0;
        case 4: 
          localana.ZtW = locala.ajGk.aar();
          AppMethodBeat.o(104767);
          return 0;
        case 5: 
          localana.ProductID = locala.ajGk.readString();
          AppMethodBeat.o(104767);
          return 0;
        case 6: 
          localana.ZtX = locala.ajGk.aar();
          AppMethodBeat.o(104767);
          return 0;
        case 7: 
          localana.ZtY = locala.ajGk.readString();
          AppMethodBeat.o(104767);
          return 0;
        }
        localana.IGG = locala.ajGk.readString();
        AppMethodBeat.o(104767);
        return 0;
      }
      AppMethodBeat.o(104767);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ana
 * JD-Core Version:    0.7.0.1
 */