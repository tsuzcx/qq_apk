package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bom
  extends com.tencent.mm.bx.a
{
  public int CIh;
  public int FHr;
  public String FWt;
  public String GJh;
  public ckd GJi;
  public int GJj;
  public int GJk;
  public String GJl;
  public long Gbu;
  public String GyY;
  public int oxC;
  public String ozd;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72505);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GyY != null) {
        paramVarArgs.d(1, this.GyY);
      }
      if (this.FWt != null) {
        paramVarArgs.d(2, this.FWt);
      }
      paramVarArgs.aY(3, this.Gbu);
      paramVarArgs.aS(4, this.state);
      if (this.GJh != null) {
        paramVarArgs.d(5, this.GJh);
      }
      paramVarArgs.aS(6, this.CIh);
      if (this.GJi != null)
      {
        paramVarArgs.lC(7, this.GJi.computeSize());
        this.GJi.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.FHr);
      paramVarArgs.aS(9, this.oxC);
      paramVarArgs.aS(10, this.GJj);
      paramVarArgs.aS(11, this.GJk);
      if (this.GJl != null) {
        paramVarArgs.d(12, this.GJl);
      }
      if (this.ozd != null) {
        paramVarArgs.d(13, this.ozd);
      }
      AppMethodBeat.o(72505);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GyY == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = f.a.a.b.b.a.e(1, this.GyY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FWt != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FWt);
      }
      i = i + f.a.a.b.b.a.p(3, this.Gbu) + f.a.a.b.b.a.bz(4, this.state);
      paramInt = i;
      if (this.GJh != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GJh);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.CIh);
      paramInt = i;
      if (this.GJi != null) {
        paramInt = i + f.a.a.a.lB(7, this.GJi.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.FHr) + f.a.a.b.b.a.bz(9, this.oxC) + f.a.a.b.b.a.bz(10, this.GJj) + f.a.a.b.b.a.bz(11, this.GJk);
      paramInt = i;
      if (this.GJl != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GJl);
      }
      i = paramInt;
      if (this.ozd != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.ozd);
      }
      AppMethodBeat.o(72505);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72505);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bom localbom = (bom)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72505);
          return -1;
        case 1: 
          localbom.GyY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 2: 
          localbom.FWt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 3: 
          localbom.Gbu = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(72505);
          return 0;
        case 4: 
          localbom.state = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72505);
          return 0;
        case 5: 
          localbom.GJh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 6: 
          localbom.CIh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72505);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ckd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbom.GJi = ((ckd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72505);
          return 0;
        case 8: 
          localbom.FHr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72505);
          return 0;
        case 9: 
          localbom.oxC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72505);
          return 0;
        case 10: 
          localbom.GJj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72505);
          return 0;
        case 11: 
          localbom.GJk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72505);
          return 0;
        case 12: 
          localbom.GJl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72505);
          return 0;
        }
        localbom.ozd = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72505);
        return 0;
      }
      AppMethodBeat.o(72505);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bom
 * JD-Core Version:    0.7.0.1
 */