package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkx
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int HSA;
  public int HSB;
  public csx HSx;
  public djx HSy;
  public String HSz;
  public String Id;
  public String nIJ;
  public long timeStamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      paramVarArgs.aS(3, this.CreateTime);
      if (this.HSx != null)
      {
        paramVarArgs.lJ(4, this.HSx.computeSize());
        this.HSx.writeFields(paramVarArgs);
      }
      if (this.HSy != null)
      {
        paramVarArgs.lJ(5, this.HSy.computeSize());
        this.HSy.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(6, this.timeStamp);
      if (this.HSz != null) {
        paramVarArgs.d(7, this.HSz);
      }
      paramVarArgs.aS(8, this.HSA);
      paramVarArgs.aS(9, this.HSB);
      AppMethodBeat.o(118475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = f.a.a.b.b.a.e(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i += f.a.a.b.b.a.bz(3, this.CreateTime);
      paramInt = i;
      if (this.HSx != null) {
        paramInt = i + f.a.a.a.lI(4, this.HSx.computeSize());
      }
      i = paramInt;
      if (this.HSy != null) {
        i = paramInt + f.a.a.a.lI(5, this.HSy.computeSize());
      }
      i += f.a.a.b.b.a.p(6, this.timeStamp);
      paramInt = i;
      if (this.HSz != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HSz);
      }
      i = f.a.a.b.b.a.bz(8, this.HSA);
      int j = f.a.a.b.b.a.bz(9, this.HSB);
      AppMethodBeat.o(118475);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(118475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dkx localdkx = (dkx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118475);
          return -1;
        case 1: 
          localdkx.Id = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 2: 
          localdkx.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 3: 
          localdkx.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118475);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkx.HSx = ((csx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118475);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkx.HSy = ((djx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118475);
          return 0;
        case 6: 
          localdkx.timeStamp = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(118475);
          return 0;
        case 7: 
          localdkx.HSz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 8: 
          localdkx.HSA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118475);
          return 0;
        }
        localdkx.HSB = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118475);
        return 0;
      }
      AppMethodBeat.o(118475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkx
 * JD-Core Version:    0.7.0.1
 */