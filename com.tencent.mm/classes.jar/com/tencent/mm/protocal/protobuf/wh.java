package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wh
  extends com.tencent.mm.bx.a
{
  public int CEj;
  public int CYi;
  public String fVv;
  public String fVw;
  public String fVx;
  public String fVy;
  public String fVz;
  public int mBM;
  public int oXh;
  public LinkedList<bkb> saZ;
  
  public wh()
  {
    AppMethodBeat.i(143965);
    this.saZ = new LinkedList();
    AppMethodBeat.o(143965);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143966);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.oXh);
      if (this.fVx != null) {
        paramVarArgs.d(7, this.fVx);
      }
      paramVarArgs.aR(2, this.CEj);
      paramVarArgs.aR(3, this.CYi);
      paramVarArgs.e(4, 8, this.saZ);
      if (this.fVv != null) {
        paramVarArgs.d(5, this.fVv);
      }
      if (this.fVw != null) {
        paramVarArgs.d(6, this.fVw);
      }
      if (this.fVy != null) {
        paramVarArgs.d(8, this.fVy);
      }
      if (this.fVz != null) {
        paramVarArgs.d(9, this.fVz);
      }
      paramVarArgs.aR(10, this.mBM);
      AppMethodBeat.o(143966);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.oXh) + 0;
      paramInt = i;
      if (this.fVx != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.fVx);
      }
      i = paramInt + f.a.a.b.b.a.bA(2, this.CEj) + f.a.a.b.b.a.bA(3, this.CYi) + f.a.a.a.c(4, 8, this.saZ);
      paramInt = i;
      if (this.fVv != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.fVv);
      }
      i = paramInt;
      if (this.fVw != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.fVw);
      }
      paramInt = i;
      if (this.fVy != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.fVy);
      }
      i = paramInt;
      if (this.fVz != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.fVz);
      }
      paramInt = f.a.a.b.b.a.bA(10, this.mBM);
      AppMethodBeat.o(143966);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.saZ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(143966);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      wh localwh = (wh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143966);
        return -1;
      case 1: 
        localwh.oXh = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143966);
        return 0;
      case 7: 
        localwh.fVx = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 2: 
        localwh.CEj = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143966);
        return 0;
      case 3: 
        localwh.CYi = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143966);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bkb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bkb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localwh.saZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143966);
        return 0;
      case 5: 
        localwh.fVv = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 6: 
        localwh.fVw = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 8: 
        localwh.fVy = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 9: 
        localwh.fVz = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(143966);
        return 0;
      }
      localwh.mBM = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(143966);
      return 0;
    }
    AppMethodBeat.o(143966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wh
 * JD-Core Version:    0.7.0.1
 */