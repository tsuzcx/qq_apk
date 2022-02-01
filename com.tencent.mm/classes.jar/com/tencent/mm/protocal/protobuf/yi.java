package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yi
  extends cvw
{
  public String AXb;
  public String AXc;
  public int FNy;
  public String FVY;
  public bb Ghz;
  public String Goz;
  public String GpD;
  public String GpE;
  public String GpF;
  public String GpG;
  public int GpH;
  public int GpJ;
  public String GpK;
  public int Gqn;
  public int Gqo;
  public String ikm;
  public String nIJ;
  public String uuA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91418);
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
      if (this.nIJ != null) {
        paramVarArgs.d(11, this.nIJ);
      }
      if (this.uuA != null) {
        paramVarArgs.d(12, this.uuA);
      }
      paramVarArgs.aS(13, this.FNy);
      paramVarArgs.aS(14, this.Gqn);
      if (this.AXb != null) {
        paramVarArgs.d(15, this.AXb);
      }
      if (this.AXc != null) {
        paramVarArgs.d(16, this.AXc);
      }
      paramVarArgs.aS(17, this.Gqo);
      paramVarArgs.aS(18, this.GpJ);
      if (this.GpK != null) {
        paramVarArgs.d(19, this.GpK);
      }
      AppMethodBeat.o(91418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1430;
      }
    }
    label1430:
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
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.nIJ);
      }
      paramInt = i;
      if (this.uuA != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.uuA);
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.FNy) + f.a.a.b.b.a.bz(14, this.Gqn);
      paramInt = i;
      if (this.AXb != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.AXb);
      }
      i = paramInt;
      if (this.AXc != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.AXc);
      }
      i = i + f.a.a.b.b.a.bz(17, this.Gqo) + f.a.a.b.b.a.bz(18, this.GpJ);
      paramInt = i;
      if (this.GpK != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.GpK);
      }
      AppMethodBeat.o(91418);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91418);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yi localyi = (yi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91418);
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
            localyi.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91418);
          return 0;
        case 2: 
          localyi.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 3: 
          localyi.GpD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 4: 
          localyi.FVY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 5: 
          localyi.GpE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 6: 
          localyi.GpF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 7: 
          localyi.GpG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 8: 
          localyi.Goz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 9: 
          localyi.GpH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91418);
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
            localyi.Ghz = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91418);
          return 0;
        case 11: 
          localyi.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 12: 
          localyi.uuA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 13: 
          localyi.FNy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91418);
          return 0;
        case 14: 
          localyi.Gqn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91418);
          return 0;
        case 15: 
          localyi.AXb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 16: 
          localyi.AXc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91418);
          return 0;
        case 17: 
          localyi.Gqo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91418);
          return 0;
        case 18: 
          localyi.GpJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91418);
          return 0;
        }
        localyi.GpK = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91418);
        return 0;
      }
      AppMethodBeat.o(91418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yi
 * JD-Core Version:    0.7.0.1
 */