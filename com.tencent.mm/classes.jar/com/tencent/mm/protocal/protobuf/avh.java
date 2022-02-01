package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avh
  extends cvw
{
  public int FJf;
  public String FVY;
  public String GMo;
  public String GMr;
  public String GMs;
  public int GMt;
  public String GMu;
  public bb Ghz;
  public String Goz;
  public String GpD;
  public String GpE;
  public String GpF;
  public String GpG;
  public int Scene;
  public String ikm;
  public String uvT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91473);
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
      if (this.GMo != null) {
        paramVarArgs.d(9, this.GMo);
      }
      paramVarArgs.aS(10, this.FJf);
      if (this.uvT != null) {
        paramVarArgs.d(11, this.uvT);
      }
      if (this.GMr != null) {
        paramVarArgs.d(12, this.GMr);
      }
      if (this.GMs != null) {
        paramVarArgs.d(13, this.GMs);
      }
      if (this.Ghz != null)
      {
        paramVarArgs.lJ(14, this.Ghz.computeSize());
        this.Ghz.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(15, this.Scene);
      paramVarArgs.aS(16, this.GMt);
      if (this.GMu != null) {
        paramVarArgs.d(17, this.GMu);
      }
      AppMethodBeat.o(91473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1338;
      }
    }
    label1338:
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
      i = paramInt;
      if (this.GMo != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GMo);
      }
      i += f.a.a.b.b.a.bz(10, this.FJf);
      paramInt = i;
      if (this.uvT != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.uvT);
      }
      i = paramInt;
      if (this.GMr != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GMr);
      }
      paramInt = i;
      if (this.GMs != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.GMs);
      }
      i = paramInt;
      if (this.Ghz != null) {
        i = paramInt + f.a.a.a.lI(14, this.Ghz.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(15, this.Scene) + f.a.a.b.b.a.bz(16, this.GMt);
      paramInt = i;
      if (this.GMu != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.GMu);
      }
      AppMethodBeat.o(91473);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avh localavh = (avh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91473);
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
            localavh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91473);
          return 0;
        case 2: 
          localavh.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 3: 
          localavh.GpD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 4: 
          localavh.FVY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 5: 
          localavh.GpE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 6: 
          localavh.GpF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 7: 
          localavh.GpG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 8: 
          localavh.Goz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 9: 
          localavh.GMo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 10: 
          localavh.FJf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91473);
          return 0;
        case 11: 
          localavh.uvT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 12: 
          localavh.GMr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 13: 
          localavh.GMs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91473);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavh.Ghz = ((bb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91473);
          return 0;
        case 15: 
          localavh.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91473);
          return 0;
        case 16: 
          localavh.GMt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91473);
          return 0;
        }
        localavh.GMu = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91473);
        return 0;
      }
      AppMethodBeat.o(91473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avh
 * JD-Core Version:    0.7.0.1
 */