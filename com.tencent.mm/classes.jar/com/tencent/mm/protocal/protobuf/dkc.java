package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkc
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public csd HyM;
  public djc HyN;
  public String HyO;
  public int HyP;
  public int HyQ;
  public String Id;
  public String nDo;
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
      if (this.nDo != null) {
        paramVarArgs.d(2, this.nDo);
      }
      paramVarArgs.aS(3, this.CreateTime);
      if (this.HyM != null)
      {
        paramVarArgs.lC(4, this.HyM.computeSize());
        this.HyM.writeFields(paramVarArgs);
      }
      if (this.HyN != null)
      {
        paramVarArgs.lC(5, this.HyN.computeSize());
        this.HyN.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.timeStamp);
      if (this.HyO != null) {
        paramVarArgs.d(7, this.HyO);
      }
      paramVarArgs.aS(8, this.HyP);
      paramVarArgs.aS(9, this.HyQ);
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
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nDo);
      }
      i += f.a.a.b.b.a.bz(3, this.CreateTime);
      paramInt = i;
      if (this.HyM != null) {
        paramInt = i + f.a.a.a.lB(4, this.HyM.computeSize());
      }
      i = paramInt;
      if (this.HyN != null) {
        i = paramInt + f.a.a.a.lB(5, this.HyN.computeSize());
      }
      i += f.a.a.b.b.a.p(6, this.timeStamp);
      paramInt = i;
      if (this.HyO != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HyO);
      }
      i = f.a.a.b.b.a.bz(8, this.HyP);
      int j = f.a.a.b.b.a.bz(9, this.HyQ);
      AppMethodBeat.o(118475);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(118475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dkc localdkc = (dkc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118475);
          return -1;
        case 1: 
          localdkc.Id = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 2: 
          localdkc.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 3: 
          localdkc.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118475);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkc.HyM = ((csd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118475);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkc.HyN = ((djc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118475);
          return 0;
        case 6: 
          localdkc.timeStamp = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(118475);
          return 0;
        case 7: 
          localdkc.HyO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(118475);
          return 0;
        case 8: 
          localdkc.HyP = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118475);
          return 0;
        }
        localdkc.HyQ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118475);
        return 0;
      }
      AppMethodBeat.o(118475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkc
 * JD-Core Version:    0.7.0.1
 */