package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmu
  extends cpx
{
  public LinkedList<String> FbP;
  public int FbR;
  public eat FbS;
  public int FbZ;
  public String Fca;
  public String Url;
  public String hOf;
  
  public bmu()
  {
    AppMethodBeat.i(123614);
    this.FbP = new LinkedList();
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
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hOf != null) {
        paramVarArgs.d(2, this.hOf);
      }
      paramVarArgs.e(3, 1, this.FbP);
      paramVarArgs.aR(4, this.FbZ);
      if (this.Url != null) {
        paramVarArgs.d(5, this.Url);
      }
      if (this.Fca != null) {
        paramVarArgs.d(6, this.Fca);
      }
      paramVarArgs.aR(7, this.FbR);
      if (this.FbS != null)
      {
        paramVarArgs.ln(8, this.FbS.computeSize());
        this.FbS.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hOf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hOf);
      }
      i = i + f.a.a.a.c(3, 1, this.FbP) + f.a.a.b.b.a.bx(4, this.FbZ);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Url);
      }
      i = paramInt;
      if (this.Fca != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Fca);
      }
      i += f.a.a.b.b.a.bx(7, this.FbR);
      paramInt = i;
      if (this.FbS != null) {
        paramInt = i + f.a.a.a.lm(8, this.FbS.computeSize());
      }
      AppMethodBeat.o(123615);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FbP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123615);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmu localbmu = (bmu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123615);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmu.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123615);
          return 0;
        case 2: 
          localbmu.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123615);
          return 0;
        case 3: 
          localbmu.FbP.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(123615);
          return 0;
        case 4: 
          localbmu.FbZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123615);
          return 0;
        case 5: 
          localbmu.Url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123615);
          return 0;
        case 6: 
          localbmu.Fca = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123615);
          return 0;
        case 7: 
          localbmu.FbR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123615);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eat();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eat)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbmu.FbS = ((eat)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmu
 * JD-Core Version:    0.7.0.1
 */