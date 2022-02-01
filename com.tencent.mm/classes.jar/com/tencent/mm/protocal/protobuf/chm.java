package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class chm
  extends com.tencent.mm.bx.a
{
  public String DHP;
  public int EcU;
  public String EcV;
  public String EcW;
  public String EcX;
  public String EcY;
  public bek EcZ;
  public String Eda;
  public String Edb;
  public String lpA;
  public String lpv;
  public String lpw;
  public String lpx;
  public String lpy;
  public int lpz;
  public String odv;
  public double score;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50101);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.lpz);
      paramVarArgs.aR(2, this.EcU);
      if (this.DHP != null) {
        paramVarArgs.d(3, this.DHP);
      }
      if (this.lpx != null) {
        paramVarArgs.d(4, this.lpx);
      }
      if (this.lpy != null) {
        paramVarArgs.d(5, this.lpy);
      }
      if (this.EcV != null) {
        paramVarArgs.d(6, this.EcV);
      }
      if (this.odv != null) {
        paramVarArgs.d(7, this.odv);
      }
      if (this.EcW != null) {
        paramVarArgs.d(8, this.EcW);
      }
      if (this.EcX != null) {
        paramVarArgs.d(9, this.EcX);
      }
      paramVarArgs.e(10, this.score);
      if (this.EcY != null) {
        paramVarArgs.d(11, this.EcY);
      }
      if (this.lpv != null) {
        paramVarArgs.d(12, this.lpv);
      }
      if (this.EcZ != null)
      {
        paramVarArgs.kX(14, this.EcZ.computeSize());
        this.EcZ.writeFields(paramVarArgs);
      }
      if (this.lpw != null) {
        paramVarArgs.d(15, this.lpw);
      }
      if (this.Eda != null) {
        paramVarArgs.d(16, this.Eda);
      }
      if (this.Edb != null) {
        paramVarArgs.d(17, this.Edb);
      }
      if (this.lpA != null) {
        paramVarArgs.d(18, this.lpA);
      }
      AppMethodBeat.o(50101);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.lpz) + 0 + f.a.a.b.b.a.bA(2, this.EcU);
      paramInt = i;
      if (this.DHP != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DHP);
      }
      i = paramInt;
      if (this.lpx != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.lpx);
      }
      paramInt = i;
      if (this.lpy != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.lpy);
      }
      i = paramInt;
      if (this.EcV != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.EcV);
      }
      paramInt = i;
      if (this.odv != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.odv);
      }
      i = paramInt;
      if (this.EcW != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EcW);
      }
      paramInt = i;
      if (this.EcX != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EcX);
      }
      i = paramInt + (f.a.a.b.b.a.fY(10) + 8);
      paramInt = i;
      if (this.EcY != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.EcY);
      }
      i = paramInt;
      if (this.lpv != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.lpv);
      }
      paramInt = i;
      if (this.EcZ != null) {
        paramInt = i + f.a.a.a.kW(14, this.EcZ.computeSize());
      }
      i = paramInt;
      if (this.lpw != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.lpw);
      }
      paramInt = i;
      if (this.Eda != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Eda);
      }
      i = paramInt;
      if (this.Edb != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.Edb);
      }
      paramInt = i;
      if (this.lpA != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.lpA);
      }
      AppMethodBeat.o(50101);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(50101);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      chm localchm = (chm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 13: 
      default: 
        AppMethodBeat.o(50101);
        return -1;
      case 1: 
        localchm.lpz = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(50101);
        return 0;
      case 2: 
        localchm.EcU = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(50101);
        return 0;
      case 3: 
        localchm.DHP = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 4: 
        localchm.lpx = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 5: 
        localchm.lpy = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 6: 
        localchm.EcV = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 7: 
        localchm.odv = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 8: 
        localchm.EcW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 9: 
        localchm.EcX = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 10: 
        localchm.score = Double.longBitsToDouble(((f.a.a.a.a)localObject1).KhF.fHy());
        AppMethodBeat.o(50101);
        return 0;
      case 11: 
        localchm.EcY = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 12: 
        localchm.lpv = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bek();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bek)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localchm.EcZ = ((bek)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(50101);
        return 0;
      case 15: 
        localchm.lpw = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 16: 
        localchm.Eda = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(50101);
        return 0;
      case 17: 
        localchm.Edb = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(50101);
        return 0;
      }
      localchm.lpA = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(50101);
      return 0;
    }
    AppMethodBeat.o(50101);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chm
 * JD-Core Version:    0.7.0.1
 */