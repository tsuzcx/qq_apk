package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class vl
  extends cvp
{
  public String FUi;
  public int FUj;
  public LinkedList<Integer> FUk;
  public int FUn;
  public String desc;
  public int dlw;
  public String paA;
  public String xXy;
  
  public vl()
  {
    AppMethodBeat.i(72446);
    this.FUk = new LinkedList();
    AppMethodBeat.o(72446);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72447);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72447);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dlw);
      if (this.paA != null) {
        paramVarArgs.d(3, this.paA);
      }
      if (this.xXy != null) {
        paramVarArgs.d(4, this.xXy);
      }
      if (this.FUi != null) {
        paramVarArgs.d(5, this.FUi);
      }
      paramVarArgs.aS(6, this.FUj);
      paramVarArgs.e(7, 2, this.FUk);
      if (this.desc != null) {
        paramVarArgs.d(8, this.desc);
      }
      paramVarArgs.aS(9, this.FUn);
      AppMethodBeat.o(72447);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label797;
      }
    }
    label797:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt;
      if (this.xXy != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.xXy);
      }
      paramInt = i;
      if (this.FUi != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FUi);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.FUj) + f.a.a.a.c(7, 2, this.FUk);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.desc);
      }
      i = f.a.a.b.b.a.bz(9, this.FUn);
      AppMethodBeat.o(72447);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FUk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72447);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72447);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vl localvl = (vl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72447);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localvl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72447);
          return 0;
        case 2: 
          localvl.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72447);
          return 0;
        case 3: 
          localvl.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 4: 
          localvl.xXy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 5: 
          localvl.FUi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72447);
          return 0;
        case 6: 
          localvl.FUj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72447);
          return 0;
        case 7: 
          localvl.FUk.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
          AppMethodBeat.o(72447);
          return 0;
        case 8: 
          localvl.desc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72447);
          return 0;
        }
        localvl.FUn = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(72447);
        return 0;
      }
      AppMethodBeat.o(72447);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vl
 * JD-Core Version:    0.7.0.1
 */