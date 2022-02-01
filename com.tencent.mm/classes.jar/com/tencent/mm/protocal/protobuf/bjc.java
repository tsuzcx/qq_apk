package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjc
  extends ckq
{
  public int DGF;
  public String DGG;
  public LinkedList<String> DGv;
  public int DGx;
  public dvc DGy;
  public String Url;
  public String hnC;
  
  public bjc()
  {
    AppMethodBeat.i(123614);
    this.DGv = new LinkedList();
    AppMethodBeat.o(123614);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123615);
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
      if (this.Url != null) {
        paramVarArgs.d(5, this.Url);
      }
      if (this.DGG != null) {
        paramVarArgs.d(6, this.DGG);
      }
      paramVarArgs.aR(7, this.DGx);
      if (this.DGy != null)
      {
        paramVarArgs.kX(8, this.DGy.computeSize());
        this.DGy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123615);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hnC != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hnC);
      }
      i = i + f.a.a.a.c(3, 1, this.DGv) + f.a.a.b.b.a.bA(4, this.DGF);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Url);
      }
      i = paramInt;
      if (this.DGG != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DGG);
      }
      i += f.a.a.b.b.a.bA(7, this.DGx);
      paramInt = i;
      if (this.DGy != null) {
        paramInt = i + f.a.a.a.kW(8, this.DGy.computeSize());
      }
      AppMethodBeat.o(123615);
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
        AppMethodBeat.o(123615);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bjc localbjc = (bjc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123615);
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
            localbjc.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123615);
          return 0;
        case 2: 
          localbjc.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123615);
          return 0;
        case 3: 
          localbjc.DGv.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(123615);
          return 0;
        case 4: 
          localbjc.DGF = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123615);
          return 0;
        case 5: 
          localbjc.Url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123615);
          return 0;
        case 6: 
          localbjc.DGG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123615);
          return 0;
        case 7: 
          localbjc.DGx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(123615);
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
          localbjc.DGy = ((dvc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123615);
        return 0;
      }
      AppMethodBeat.o(123615);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjc
 * JD-Core Version:    0.7.0.1
 */