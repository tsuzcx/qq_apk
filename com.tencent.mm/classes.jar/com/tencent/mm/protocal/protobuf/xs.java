package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xs
  extends cvw
{
  public int FNy;
  public String FVY;
  public bb Ghz;
  public String Goz;
  public String GpD;
  public String GpE;
  public String GpF;
  public String GpG;
  public int GpH;
  public String GpI;
  public int GpJ;
  public String GpK;
  public String ikm;
  public String nIJ;
  public String uuA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      if (this.GpD != null) {
        paramVarArgs.d(3, this.GpD);
      }
      if (this.FVY != null) {
        paramVarArgs.d(4, this.FVY);
      }
      if (this.GpE != null) {
        paramVarArgs.d(5, this.GpE);
      }
      if (this.GpF != null) {
        paramVarArgs.d(6, this.GpF);
      }
      if (this.GpG != null) {
        paramVarArgs.d(7, this.GpG);
      }
      if (this.Goz != null) {
        paramVarArgs.d(8, this.Goz);
      }
      paramVarArgs.aS(9, this.GpH);
      if (this.Ghz != null)
      {
        paramVarArgs.lJ(10, this.Ghz.computeSize());
        this.Ghz.writeFields(paramVarArgs);
      }
      if (this.GpI != null) {
        paramVarArgs.d(11, this.GpI);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(12, this.nIJ);
      }
      if (this.uuA != null) {
        paramVarArgs.d(13, this.uuA);
      }
      paramVarArgs.aS(14, this.FNy);
      paramVarArgs.aS(15, this.GpJ);
      if (this.GpK != null) {
        paramVarArgs.d(16, this.GpK);
      }
      AppMethodBeat.o(91416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1278;
      }
    }
    label1278:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ikm);
      }
      i = paramInt;
      if (this.GpD != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GpD);
      }
      paramInt = i;
      if (this.FVY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FVY);
      }
      i = paramInt;
      if (this.GpE != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GpE);
      }
      paramInt = i;
      if (this.GpF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GpF);
      }
      i = paramInt;
      if (this.GpG != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GpG);
      }
      paramInt = i;
      if (this.Goz != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Goz);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.GpH);
      paramInt = i;
      if (this.Ghz != null) {
        paramInt = i + f.a.a.a.lI(10, this.Ghz.computeSize());
      }
      i = paramInt;
      if (this.GpI != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GpI);
      }
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.nIJ);
      }
      i = paramInt;
      if (this.uuA != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.uuA);
      }
      i = i + f.a.a.b.b.a.bz(14, this.FNy) + f.a.a.b.b.a.bz(15, this.GpJ);
      paramInt = i;
      if (this.GpK != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.GpK);
      }
      AppMethodBeat.o(91416);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        xs localxs = (xs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91416);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localxs.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91416);
          return 0;
        case 2: 
          localxs.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 3: 
          localxs.GpD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 4: 
          localxs.FVY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 5: 
          localxs.GpE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 6: 
          localxs.GpF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 7: 
          localxs.GpG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 8: 
          localxs.Goz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 9: 
          localxs.GpH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91416);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localxs.Ghz = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91416);
          return 0;
        case 11: 
          localxs.GpI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 12: 
          localxs.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 13: 
          localxs.uuA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91416);
          return 0;
        case 14: 
          localxs.FNy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91416);
          return 0;
        case 15: 
          localxs.GpJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91416);
          return 0;
        }
        localxs.GpK = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91416);
        return 0;
      }
      AppMethodBeat.o(91416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xs
 * JD-Core Version:    0.7.0.1
 */