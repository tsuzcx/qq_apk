package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aig
  extends com.tencent.mm.bx.a
{
  public LinkedList<ok> FHP;
  public String FHU;
  public String FHY;
  public LinkedList<String> FJN;
  public int FJO;
  public long FJW;
  public int FuX;
  public String GfK;
  public String GfL;
  public String GfM;
  public String GfN;
  public String GfO;
  
  public aig()
  {
    AppMethodBeat.i(207250);
    this.FHP = new LinkedList();
    this.FJN = new LinkedList();
    AppMethodBeat.o(207250);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207251);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GfK != null) {
        paramVarArgs.d(1, this.GfK);
      }
      if (this.GfL != null) {
        paramVarArgs.d(2, this.GfL);
      }
      paramVarArgs.aY(3, this.FJW);
      paramVarArgs.e(4, 8, this.FHP);
      paramVarArgs.aS(5, this.FuX);
      if (this.GfM != null) {
        paramVarArgs.d(6, this.GfM);
      }
      if (this.FHU != null) {
        paramVarArgs.d(7, this.FHU);
      }
      if (this.FHY != null) {
        paramVarArgs.d(8, this.FHY);
      }
      paramVarArgs.e(9, 1, this.FJN);
      paramVarArgs.aS(10, this.FJO);
      if (this.GfN != null) {
        paramVarArgs.d(11, this.GfN);
      }
      if (this.GfO != null) {
        paramVarArgs.d(12, this.GfO);
      }
      AppMethodBeat.o(207251);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GfK == null) {
        break label914;
      }
    }
    label914:
    for (paramInt = f.a.a.b.b.a.e(1, this.GfK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GfL != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GfL);
      }
      i = i + f.a.a.b.b.a.p(3, this.FJW) + f.a.a.a.c(4, 8, this.FHP) + f.a.a.b.b.a.bz(5, this.FuX);
      paramInt = i;
      if (this.GfM != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GfM);
      }
      i = paramInt;
      if (this.FHU != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FHU);
      }
      paramInt = i;
      if (this.FHY != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FHY);
      }
      i = paramInt + f.a.a.a.c(9, 1, this.FJN) + f.a.a.b.b.a.bz(10, this.FJO);
      paramInt = i;
      if (this.GfN != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GfN);
      }
      i = paramInt;
      if (this.GfO != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GfO);
      }
      AppMethodBeat.o(207251);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FHP.clear();
        this.FJN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(207251);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aig localaig = (aig)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207251);
          return -1;
        case 1: 
          localaig.GfK = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(207251);
          return 0;
        case 2: 
          localaig.GfL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(207251);
          return 0;
        case 3: 
          localaig.FJW = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(207251);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ok();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ok)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaig.FHP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207251);
          return 0;
        case 5: 
          localaig.FuX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(207251);
          return 0;
        case 6: 
          localaig.GfM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(207251);
          return 0;
        case 7: 
          localaig.FHU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(207251);
          return 0;
        case 8: 
          localaig.FHY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(207251);
          return 0;
        case 9: 
          localaig.FJN.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(207251);
          return 0;
        case 10: 
          localaig.FJO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(207251);
          return 0;
        case 11: 
          localaig.GfN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(207251);
          return 0;
        }
        localaig.GfO = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(207251);
        return 0;
      }
      AppMethodBeat.o(207251);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aig
 * JD-Core Version:    0.7.0.1
 */