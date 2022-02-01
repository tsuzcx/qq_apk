package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class chj
  extends com.tencent.mm.bw.a
{
  public String AAG;
  public float AAH;
  public int AAI;
  public LinkedList<Integer> AAJ;
  public int AAK;
  public LinkedList<dqi> AAL;
  public float AAM;
  public String AAN;
  public SKBuiltinBuffer_t AAO;
  public String MmT;
  public SKBuiltinBuffer_t MmU;
  public int MmV;
  public int MmW;
  public String Title;
  public int oUv;
  
  public chj()
  {
    AppMethodBeat.i(116338);
    this.AAJ = new LinkedList();
    this.AAL = new LinkedList();
    AppMethodBeat.o(116338);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116339);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.AAG != null) {
        paramVarArgs.e(1, this.AAG);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      paramVarArgs.E(3, this.AAH);
      paramVarArgs.aM(4, this.AAI);
      paramVarArgs.f(5, 2, this.AAJ);
      paramVarArgs.aM(6, this.AAK);
      paramVarArgs.e(7, 8, this.AAL);
      paramVarArgs.E(8, this.AAM);
      if (this.AAN != null) {
        paramVarArgs.e(9, this.AAN);
      }
      paramVarArgs.aM(10, this.oUv);
      if (this.AAO != null)
      {
        paramVarArgs.ni(11, this.AAO.computeSize());
        this.AAO.writeFields(paramVarArgs);
      }
      if (this.MmT != null) {
        paramVarArgs.e(12, this.MmT);
      }
      if (this.MmU != null)
      {
        paramVarArgs.ni(13, this.MmU.computeSize());
        this.MmU.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(14, this.MmV);
      paramVarArgs.aM(15, this.MmW);
      AppMethodBeat.o(116339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.AAG == null) {
        break label1239;
      }
    }
    label1239:
    for (paramInt = g.a.a.b.b.a.f(1, this.AAG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Title);
      }
      i = i + (g.a.a.b.b.a.fS(3) + 4) + g.a.a.b.b.a.bu(4, this.AAI) + g.a.a.a.d(5, 2, this.AAJ) + g.a.a.b.b.a.bu(6, this.AAK) + g.a.a.a.c(7, 8, this.AAL) + (g.a.a.b.b.a.fS(8) + 4);
      paramInt = i;
      if (this.AAN != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.AAN);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.oUv);
      paramInt = i;
      if (this.AAO != null) {
        paramInt = i + g.a.a.a.nh(11, this.AAO.computeSize());
      }
      i = paramInt;
      if (this.MmT != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.MmT);
      }
      paramInt = i;
      if (this.MmU != null) {
        paramInt = i + g.a.a.a.nh(13, this.MmU.computeSize());
      }
      i = g.a.a.b.b.a.bu(14, this.MmV);
      int j = g.a.a.b.b.a.bu(15, this.MmW);
      AppMethodBeat.o(116339);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.AAJ.clear();
        this.AAL.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(116339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        chj localchj = (chj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116339);
          return -1;
        case 1: 
          localchj.AAG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 2: 
          localchj.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 3: 
          localchj.AAH = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(116339);
          return 0;
        case 4: 
          localchj.AAI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116339);
          return 0;
        case 5: 
          localchj.AAJ = new g.a.a.a.a(((g.a.a.a.a)localObject1).UbS.hPo().zy, unknownTagHandler).UbS.hPm();
          AppMethodBeat.o(116339);
          return 0;
        case 6: 
          localchj.AAK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116339);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchj.AAL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 8: 
          localchj.AAM = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(116339);
          return 0;
        case 9: 
          localchj.AAN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 10: 
          localchj.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116339);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchj.AAO = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 12: 
          localchj.MmT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116339);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localchj.MmU = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116339);
          return 0;
        case 14: 
          localchj.MmV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116339);
          return 0;
        }
        localchj.MmW = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(116339);
        return 0;
      }
      AppMethodBeat.o(116339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chj
 * JD-Core Version:    0.7.0.1
 */