package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwv
  extends com.tencent.mm.bx.a
{
  public String EKK;
  public String EKL;
  public LinkedList<bxd> EKM;
  public String EKN;
  public int EKO;
  public String Title;
  
  public dwv()
  {
    AppMethodBeat.i(50125);
    this.EKM = new LinkedList();
    AppMethodBeat.o(50125);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50126);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EKK != null) {
        paramVarArgs.d(1, this.EKK);
      }
      if (this.EKL != null) {
        paramVarArgs.d(2, this.EKL);
      }
      paramVarArgs.e(3, 8, this.EKM);
      if (this.EKN != null) {
        paramVarArgs.d(4, this.EKN);
      }
      paramVarArgs.aR(5, this.EKO);
      if (this.Title != null) {
        paramVarArgs.d(6, this.Title);
      }
      AppMethodBeat.o(50126);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EKK == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.b.b.a.e(1, this.EKK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EKL != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.EKL);
      }
      i += f.a.a.a.c(3, 8, this.EKM);
      paramInt = i;
      if (this.EKN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EKN);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.EKO);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Title);
      }
      AppMethodBeat.o(50126);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EKM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(50126);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwv localdwv = (dwv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50126);
          return -1;
        case 1: 
          localdwv.EKK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 2: 
          localdwv.EKL = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bxd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwv.EKM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50126);
          return 0;
        case 4: 
          localdwv.EKN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 5: 
          localdwv.EKO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(50126);
          return 0;
        }
        localdwv.Title = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(50126);
        return 0;
      }
      AppMethodBeat.o(50126);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwv
 * JD-Core Version:    0.7.0.1
 */