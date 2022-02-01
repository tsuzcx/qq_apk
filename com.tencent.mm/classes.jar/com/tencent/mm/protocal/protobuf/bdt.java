package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdt
  extends com.tencent.mm.cd.a
{
  public long MSE;
  public long MSG;
  public int SOR;
  public String SOS;
  public int SOT;
  public aay SOU;
  public FinderContact SOV;
  public float SOW;
  public String SOX;
  public LinkedList<Integer> SOY;
  public int SOZ;
  public int fillMode;
  public long refObjectId;
  
  public bdt()
  {
    AppMethodBeat.i(207195);
    this.SOY = new LinkedList();
    AppMethodBeat.o(207195);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207201);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.MSE);
      paramVarArgs.aY(2, this.SOR);
      paramVarArgs.bm(3, this.refObjectId);
      if (this.SOS != null) {
        paramVarArgs.f(4, this.SOS);
      }
      paramVarArgs.bm(5, this.MSG);
      paramVarArgs.aY(6, this.fillMode);
      paramVarArgs.aY(7, this.SOT);
      if (this.SOU != null)
      {
        paramVarArgs.oE(8, this.SOU.computeSize());
        this.SOU.writeFields(paramVarArgs);
      }
      if (this.SOV != null)
      {
        paramVarArgs.oE(9, this.SOV.computeSize());
        this.SOV.writeFields(paramVarArgs);
      }
      paramVarArgs.i(10, this.SOW);
      if (this.SOX != null) {
        paramVarArgs.f(11, this.SOX);
      }
      paramVarArgs.e(12, 2, this.SOY);
      paramVarArgs.aY(13, this.SOZ);
      AppMethodBeat.o(207201);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.MSE) + 0 + g.a.a.b.b.a.bM(2, this.SOR) + g.a.a.b.b.a.p(3, this.refObjectId);
      paramInt = i;
      if (this.SOS != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SOS);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.MSG) + g.a.a.b.b.a.bM(6, this.fillMode) + g.a.a.b.b.a.bM(7, this.SOT);
      paramInt = i;
      if (this.SOU != null) {
        paramInt = i + g.a.a.a.oD(8, this.SOU.computeSize());
      }
      i = paramInt;
      if (this.SOV != null) {
        i = paramInt + g.a.a.a.oD(9, this.SOV.computeSize());
      }
      i += g.a.a.b.b.a.gL(10) + 4;
      paramInt = i;
      if (this.SOX != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.SOX);
      }
      i = g.a.a.a.c(12, 2, this.SOY);
      int j = g.a.a.b.b.a.bM(13, this.SOZ);
      AppMethodBeat.o(207201);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SOY.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207201);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bdt localbdt = (bdt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207201);
        return -1;
      case 1: 
        localbdt.MSE = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(207201);
        return 0;
      case 2: 
        localbdt.SOR = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(207201);
        return 0;
      case 3: 
        localbdt.refObjectId = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(207201);
        return 0;
      case 4: 
        localbdt.SOS = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(207201);
        return 0;
      case 5: 
        localbdt.MSG = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(207201);
        return 0;
      case 6: 
        localbdt.fillMode = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(207201);
        return 0;
      case 7: 
        localbdt.SOT = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(207201);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aay();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aay)localObject2).parseFrom((byte[])localObject1);
          }
          localbdt.SOU = ((aay)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207201);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderContact();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderContact)localObject2).parseFrom((byte[])localObject1);
          }
          localbdt.SOV = ((FinderContact)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207201);
        return 0;
      case 10: 
        localbdt.SOW = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
        AppMethodBeat.o(207201);
        return 0;
      case 11: 
        localbdt.SOX = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(207201);
        return 0;
      case 12: 
        localbdt.SOY.add(Integer.valueOf(((g.a.a.a.a)localObject1).abFh.AK()));
        AppMethodBeat.o(207201);
        return 0;
      }
      localbdt.SOZ = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(207201);
      return 0;
    }
    AppMethodBeat.o(207201);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdt
 * JD-Core Version:    0.7.0.1
 */