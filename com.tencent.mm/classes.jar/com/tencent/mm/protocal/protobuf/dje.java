package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dje
  extends com.tencent.mm.bw.a
{
  public ly HQO;
  public dve HQP;
  public chk HQQ;
  public long HQR;
  public int HQS;
  public long HQT;
  public long HQU;
  public b HQV;
  public long OzM;
  public int mediaType;
  public String objectNonceId;
  public long rRn;
  public String sbR;
  public int sch;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169091);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.rRn);
      if (this.HQO != null)
      {
        paramVarArgs.lJ(2, this.HQO.computeSize());
        this.HQO.writeFields(paramVarArgs);
      }
      if (this.HQP != null)
      {
        paramVarArgs.lJ(3, this.HQP.computeSize());
        this.HQP.writeFields(paramVarArgs);
      }
      if (this.HQQ != null)
      {
        paramVarArgs.lJ(4, this.HQQ.computeSize());
        this.HQQ.writeFields(paramVarArgs);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.d(5, this.objectNonceId);
      }
      if (this.sbR != null) {
        paramVarArgs.d(6, this.sbR);
      }
      paramVarArgs.aZ(7, this.HQR);
      paramVarArgs.aS(8, this.HQS);
      if (this.sessionBuffer != null) {
        paramVarArgs.d(9, this.sessionBuffer);
      }
      paramVarArgs.aZ(10, this.HQT);
      paramVarArgs.aS(11, this.sch);
      paramVarArgs.aZ(12, this.HQU);
      if (this.HQV != null) {
        paramVarArgs.c(13, this.HQV);
      }
      paramVarArgs.aS(14, this.mediaType);
      paramVarArgs.aZ(17, this.OzM);
      AppMethodBeat.o(169091);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.rRn) + 0;
      paramInt = i;
      if (this.HQO != null) {
        paramInt = i + f.a.a.a.lI(2, this.HQO.computeSize());
      }
      i = paramInt;
      if (this.HQP != null) {
        i = paramInt + f.a.a.a.lI(3, this.HQP.computeSize());
      }
      paramInt = i;
      if (this.HQQ != null) {
        paramInt = i + f.a.a.a.lI(4, this.HQQ.computeSize());
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.objectNonceId);
      }
      paramInt = i;
      if (this.sbR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sbR);
      }
      i = paramInt + f.a.a.b.b.a.p(7, this.HQR) + f.a.a.b.b.a.bz(8, this.HQS);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.sessionBuffer);
      }
      i = paramInt + f.a.a.b.b.a.p(10, this.HQT) + f.a.a.b.b.a.bz(11, this.sch) + f.a.a.b.b.a.p(12, this.HQU);
      paramInt = i;
      if (this.HQV != null) {
        paramInt = i + f.a.a.b.b.a.b(13, this.HQV);
      }
      i = f.a.a.b.b.a.bz(14, this.mediaType);
      int j = f.a.a.b.b.a.p(17, this.OzM);
      AppMethodBeat.o(169091);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(169091);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dje localdje = (dje)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 15: 
      case 16: 
      default: 
        AppMethodBeat.o(169091);
        return -1;
      case 1: 
        localdje.rRn = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(169091);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ly();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ly)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdje.HQO = ((ly)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dve();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dve)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdje.HQP = ((dve)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((chk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdje.HQQ = ((chk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 5: 
        localdje.objectNonceId = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169091);
        return 0;
      case 6: 
        localdje.sbR = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169091);
        return 0;
      case 7: 
        localdje.HQR = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(169091);
        return 0;
      case 8: 
        localdje.HQS = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169091);
        return 0;
      case 9: 
        localdje.sessionBuffer = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169091);
        return 0;
      case 10: 
        localdje.HQT = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(169091);
        return 0;
      case 11: 
        localdje.sch = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169091);
        return 0;
      case 12: 
        localdje.HQU = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(169091);
        return 0;
      case 13: 
        localdje.HQV = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(169091);
        return 0;
      case 14: 
        localdje.mediaType = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169091);
        return 0;
      }
      localdje.OzM = ((f.a.a.a.a)localObject1).OmT.zd();
      AppMethodBeat.o(169091);
      return 0;
    }
    AppMethodBeat.o(169091);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dje
 * JD-Core Version:    0.7.0.1
 */