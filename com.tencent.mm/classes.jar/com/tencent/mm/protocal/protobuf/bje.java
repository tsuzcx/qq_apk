package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bje
  extends ckq
{
  public String DGK;
  public int DGw;
  public int DGx;
  public dvc DGy;
  public int Dbx;
  public String hnC;
  public b mAx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123618);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      if (this.mAx != null) {
        paramVarArgs.c(3, this.mAx);
      }
      if (this.DGK != null) {
        paramVarArgs.d(4, this.DGK);
      }
      paramVarArgs.aR(5, this.DGw);
      paramVarArgs.aR(6, this.DGx);
      if (this.DGy != null)
      {
        paramVarArgs.kX(7, this.DGy.computeSize());
        this.DGy.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.Dbx);
      AppMethodBeat.o(123618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hnC);
      }
      i = paramInt;
      if (this.mAx != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.mAx);
      }
      paramInt = i;
      if (this.DGK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DGK);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.DGw) + f.a.a.b.b.a.bA(6, this.DGx);
      paramInt = i;
      if (this.DGy != null) {
        paramInt = i + f.a.a.a.kW(7, this.DGy.computeSize());
      }
      i = f.a.a.b.b.a.bA(8, this.Dbx);
      AppMethodBeat.o(123618);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bje localbje = (bje)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123618);
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
            localbje.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123618);
          return 0;
        case 2: 
          localbje.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123618);
          return 0;
        case 3: 
          localbje.mAx = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(123618);
          return 0;
        case 4: 
          localbje.DGK = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123618);
          return 0;
        case 5: 
          localbje.DGw = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123618);
          return 0;
        case 6: 
          localbje.DGx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123618);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbje.DGy = ((dvc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123618);
          return 0;
        }
        localbje.Dbx = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(123618);
        return 0;
      }
      AppMethodBeat.o(123618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bje
 * JD-Core Version:    0.7.0.1
 */