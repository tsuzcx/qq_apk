package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkh
  extends com.tencent.mm.bw.a
{
  public int HSc;
  public dkf HSd;
  public String HSe;
  public boolean HSf;
  public int HiZ;
  public long HmL;
  public int HmP;
  public String hFO;
  public int hiJ;
  public String md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hFO != null) {
        paramVarArgs.d(1, this.hFO);
      }
      paramVarArgs.aS(2, this.hiJ);
      paramVarArgs.aZ(3, this.HmL);
      paramVarArgs.aS(4, this.HmP);
      if (this.md5 != null) {
        paramVarArgs.d(5, this.md5);
      }
      paramVarArgs.aS(6, this.HiZ);
      paramVarArgs.aS(7, this.HSc);
      if (this.HSd != null)
      {
        paramVarArgs.lJ(8, this.HSd.computeSize());
        this.HSd.writeFields(paramVarArgs);
      }
      if (this.HSe != null) {
        paramVarArgs.d(9, this.HSe);
      }
      paramVarArgs.bC(10, this.HSf);
      AppMethodBeat.o(118455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hFO == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.b.b.a.e(1, this.hFO) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.hiJ) + f.a.a.b.b.a.p(3, this.HmL) + f.a.a.b.b.a.bz(4, this.HmP);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.md5);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.HiZ) + f.a.a.b.b.a.bz(7, this.HSc);
      paramInt = i;
      if (this.HSd != null) {
        paramInt = i + f.a.a.a.lI(8, this.HSd.computeSize());
      }
      i = paramInt;
      if (this.HSe != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HSe);
      }
      paramInt = f.a.a.b.b.a.amF(10);
      AppMethodBeat.o(118455);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(118455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dkh localdkh = (dkh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118455);
          return -1;
        case 1: 
          localdkh.hFO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118455);
          return 0;
        case 2: 
          localdkh.hiJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118455);
          return 0;
        case 3: 
          localdkh.HmL = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(118455);
          return 0;
        case 4: 
          localdkh.HmP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118455);
          return 0;
        case 5: 
          localdkh.md5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118455);
          return 0;
        case 6: 
          localdkh.HiZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118455);
          return 0;
        case 7: 
          localdkh.HSc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118455);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dkf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkh.HSd = ((dkf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118455);
          return 0;
        case 9: 
          localdkh.HSe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118455);
          return 0;
        }
        localdkh.HSf = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(118455);
        return 0;
      }
      AppMethodBeat.o(118455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkh
 * JD-Core Version:    0.7.0.1
 */