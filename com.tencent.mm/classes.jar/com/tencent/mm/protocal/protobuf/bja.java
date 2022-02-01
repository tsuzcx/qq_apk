package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bja
  extends ckq
{
  public int DGF;
  public String DGG;
  public LinkedList<String> DGv;
  public int DGw;
  public int DGx;
  public dvc DGy;
  public String hnC;
  
  public bja()
  {
    AppMethodBeat.i(123611);
    this.DGv = new LinkedList();
    AppMethodBeat.o(123611);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123612);
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
      paramVarArgs.e(3, 1, this.DGv);
      paramVarArgs.aR(4, this.DGF);
      if (this.DGG != null) {
        paramVarArgs.d(6, this.DGG);
      }
      paramVarArgs.aR(7, this.DGw);
      paramVarArgs.aR(8, this.DGx);
      if (this.DGy != null)
      {
        paramVarArgs.kX(9, this.DGy.computeSize());
        this.DGy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hnC != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hnC);
      }
      i = i + f.a.a.a.c(3, 1, this.DGv) + f.a.a.b.b.a.bA(4, this.DGF);
      paramInt = i;
      if (this.DGG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DGG);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.DGw) + f.a.a.b.b.a.bA(8, this.DGx);
      paramInt = i;
      if (this.DGy != null) {
        paramInt = i + f.a.a.a.kW(9, this.DGy.computeSize());
      }
      AppMethodBeat.o(123612);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DGv.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123612);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bja localbja = (bja)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(123612);
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
            localbja.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123612);
          return 0;
        case 2: 
          localbja.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123612);
          return 0;
        case 3: 
          localbja.DGv.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(123612);
          return 0;
        case 4: 
          localbja.DGF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123612);
          return 0;
        case 6: 
          localbja.DGG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123612);
          return 0;
        case 7: 
          localbja.DGw = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123612);
          return 0;
        case 8: 
          localbja.DGx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123612);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dvc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dvc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbja.DGy = ((dvc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123612);
        return 0;
      }
      AppMethodBeat.o(123612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bja
 * JD-Core Version:    0.7.0.1
 */