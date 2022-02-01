package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czj
  extends com.tencent.mm.bw.a
{
  public String GNI;
  public String GnN;
  public String GnO;
  public String Gtg;
  public String Gth;
  public int HIP;
  public cfq HJe;
  public String ikm;
  public int jfV;
  public String nIJ;
  public String nJO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152685);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      if (this.nJO != null) {
        paramVarArgs.d(2, this.nJO);
      }
      if (this.Gtg != null) {
        paramVarArgs.d(3, this.Gtg);
      }
      if (this.Gth != null) {
        paramVarArgs.d(4, this.Gth);
      }
      paramVarArgs.aS(5, this.jfV);
      if (this.GnN != null) {
        paramVarArgs.d(6, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(7, this.GnO);
      }
      if (this.ikm != null) {
        paramVarArgs.d(8, this.ikm);
      }
      paramVarArgs.aS(9, this.HIP);
      if (this.HJe != null)
      {
        paramVarArgs.lJ(10, this.HJe.computeSize());
        this.HJe.writeFields(paramVarArgs);
      }
      if (this.GNI != null) {
        paramVarArgs.d(11, this.GNI);
      }
      AppMethodBeat.o(152685);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label890;
      }
    }
    label890:
    for (int i = f.a.a.b.b.a.e(1, this.nIJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nJO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nJO);
      }
      i = paramInt;
      if (this.Gtg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gtg);
      }
      paramInt = i;
      if (this.Gth != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gth);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.jfV);
      paramInt = i;
      if (this.GnN != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GnN);
      }
      i = paramInt;
      if (this.GnO != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GnO);
      }
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ikm);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.HIP);
      paramInt = i;
      if (this.HJe != null) {
        paramInt = i + f.a.a.a.lI(10, this.HJe.computeSize());
      }
      i = paramInt;
      if (this.GNI != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GNI);
      }
      AppMethodBeat.o(152685);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152685);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czj localczj = (czj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152685);
          return -1;
        case 1: 
          localczj.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 2: 
          localczj.nJO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 3: 
          localczj.Gtg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 4: 
          localczj.Gth = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 5: 
          localczj.jfV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152685);
          return 0;
        case 6: 
          localczj.GnN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 7: 
          localczj.GnO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 8: 
          localczj.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 9: 
          localczj.HIP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152685);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cfq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczj.HJe = ((cfq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152685);
          return 0;
        }
        localczj.GNI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152685);
        return 0;
      }
      AppMethodBeat.o(152685);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czj
 * JD-Core Version:    0.7.0.1
 */