package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ff
  extends cvw
{
  public int FPD;
  public int FPE;
  public long FPF;
  public long FPG;
  public pl FPH;
  public int FPI;
  public int FPJ;
  public int FPK;
  public String FPL;
  public int FPc;
  public int FPd;
  public String hCa;
  public int nettype;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103194);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.hCa != null) {
        paramVarArgs.d(3, this.hCa);
      }
      paramVarArgs.aS(4, this.scene);
      paramVarArgs.aS(5, this.FPd);
      paramVarArgs.aS(6, this.nettype);
      if (this.session_id != null) {
        paramVarArgs.d(7, this.session_id);
      }
      paramVarArgs.aS(8, this.FPc);
      paramVarArgs.aS(9, this.FPD);
      paramVarArgs.aS(10, this.FPE);
      paramVarArgs.aZ(11, this.FPF);
      paramVarArgs.aZ(12, this.FPG);
      if (this.FPH != null)
      {
        paramVarArgs.lJ(13, this.FPH.computeSize());
        this.FPH.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(14, this.FPI);
      paramVarArgs.aS(15, this.FPJ);
      paramVarArgs.aS(16, this.FPK);
      if (this.FPL != null) {
        paramVarArgs.d(17, this.FPL);
      }
      AppMethodBeat.o(103194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1198;
      }
    }
    label1198:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.hCa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hCa);
      }
      i = i + f.a.a.b.b.a.bz(4, this.scene) + f.a.a.b.b.a.bz(5, this.FPd) + f.a.a.b.b.a.bz(6, this.nettype);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.session_id);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.FPc) + f.a.a.b.b.a.bz(9, this.FPD) + f.a.a.b.b.a.bz(10, this.FPE) + f.a.a.b.b.a.p(11, this.FPF) + f.a.a.b.b.a.p(12, this.FPG);
      paramInt = i;
      if (this.FPH != null) {
        paramInt = i + f.a.a.a.lI(13, this.FPH.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(14, this.FPI) + f.a.a.b.b.a.bz(15, this.FPJ) + f.a.a.b.b.a.bz(16, this.FPK);
      paramInt = i;
      if (this.FPL != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.FPL);
      }
      AppMethodBeat.o(103194);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(103194);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ff localff = (ff)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(103194);
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
            localff.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103194);
          return 0;
        case 2: 
          localff.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(103194);
          return 0;
        case 3: 
          localff.hCa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(103194);
          return 0;
        case 4: 
          localff.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103194);
          return 0;
        case 5: 
          localff.FPd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103194);
          return 0;
        case 6: 
          localff.nettype = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103194);
          return 0;
        case 7: 
          localff.session_id = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(103194);
          return 0;
        case 8: 
          localff.FPc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103194);
          return 0;
        case 9: 
          localff.FPD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103194);
          return 0;
        case 10: 
          localff.FPE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103194);
          return 0;
        case 11: 
          localff.FPF = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(103194);
          return 0;
        case 12: 
          localff.FPG = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(103194);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localff.FPH = ((pl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103194);
          return 0;
        case 14: 
          localff.FPI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103194);
          return 0;
        case 15: 
          localff.FPJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103194);
          return 0;
        case 16: 
          localff.FPK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(103194);
          return 0;
        }
        localff.FPL = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(103194);
        return 0;
      }
      AppMethodBeat.o(103194);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ff
 * JD-Core Version:    0.7.0.1
 */