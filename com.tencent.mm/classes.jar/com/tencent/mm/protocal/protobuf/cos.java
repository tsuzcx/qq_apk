package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cos
  extends ckq
{
  public int CAG;
  public int COR;
  public int COS;
  public String COT;
  public int DdJ;
  public ek EiI;
  public String EiJ;
  public String EiK;
  public int EiL;
  public int EiM;
  public String Md5;
  public String ijP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32426);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EiI == null)
      {
        paramVarArgs = new b("Not all required fields were included: Msg");
        AppMethodBeat.o(32426);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EiI != null)
      {
        paramVarArgs.kX(2, this.EiI.computeSize());
        this.EiI.writeFields(paramVarArgs);
      }
      if (this.EiJ != null) {
        paramVarArgs.d(3, this.EiJ);
      }
      paramVarArgs.aR(4, this.DdJ);
      if (this.Md5 != null) {
        paramVarArgs.d(5, this.Md5);
      }
      paramVarArgs.aR(6, this.CAG);
      if (this.ijP != null) {
        paramVarArgs.d(7, this.ijP);
      }
      if (this.EiK != null) {
        paramVarArgs.d(8, this.EiK);
      }
      paramVarArgs.aR(9, this.EiL);
      paramVarArgs.aR(10, this.COR);
      paramVarArgs.aR(11, this.COS);
      paramVarArgs.aR(12, this.EiM);
      if (this.COT != null) {
        paramVarArgs.d(13, this.COT);
      }
      AppMethodBeat.o(32426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1109;
      }
    }
    label1109:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EiI != null) {
        paramInt = i + f.a.a.a.kW(2, this.EiI.computeSize());
      }
      i = paramInt;
      if (this.EiJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EiJ);
      }
      i += f.a.a.b.b.a.bA(4, this.DdJ);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Md5);
      }
      i = paramInt + f.a.a.b.b.a.bA(6, this.CAG);
      paramInt = i;
      if (this.ijP != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ijP);
      }
      i = paramInt;
      if (this.EiK != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EiK);
      }
      i = i + f.a.a.b.b.a.bA(9, this.EiL) + f.a.a.b.b.a.bA(10, this.COR) + f.a.a.b.b.a.bA(11, this.COS) + f.a.a.b.b.a.bA(12, this.EiM);
      paramInt = i;
      if (this.COT != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.COT);
      }
      AppMethodBeat.o(32426);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EiI == null)
        {
          paramVarArgs = new b("Not all required fields were included: Msg");
          AppMethodBeat.o(32426);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cos localcos = (cos)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32426);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcos.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32426);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ek();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ek)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcos.EiI = ((ek)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32426);
          return 0;
        case 3: 
          localcos.EiJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 4: 
          localcos.DdJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32426);
          return 0;
        case 5: 
          localcos.Md5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 6: 
          localcos.CAG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32426);
          return 0;
        case 7: 
          localcos.ijP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 8: 
          localcos.EiK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32426);
          return 0;
        case 9: 
          localcos.EiL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32426);
          return 0;
        case 10: 
          localcos.COR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32426);
          return 0;
        case 11: 
          localcos.COS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32426);
          return 0;
        case 12: 
          localcos.EiM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32426);
          return 0;
        }
        localcos.COT = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32426);
        return 0;
      }
      AppMethodBeat.o(32426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cos
 * JD-Core Version:    0.7.0.1
 */