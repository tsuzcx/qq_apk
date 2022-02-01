package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czh
  extends cvc
{
  public int FKN;
  public String FRw;
  public String FYR;
  public String Hqd;
  public int dnh;
  public String duW;
  public int scene;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91683);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FYR != null) {
        paramVarArgs.d(2, this.FYR);
      }
      if (this.duW != null) {
        paramVarArgs.d(3, this.duW);
      }
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      if (this.Hqd != null) {
        paramVarArgs.d(5, this.Hqd);
      }
      paramVarArgs.aS(6, this.scene);
      paramVarArgs.aS(7, this.dnh);
      if (this.FRw != null) {
        paramVarArgs.d(8, this.FRw);
      }
      paramVarArgs.aS(9, this.FKN);
      AppMethodBeat.o(91683);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label750;
      }
    }
    label750:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FYR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FYR);
      }
      i = paramInt;
      if (this.duW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.duW);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt;
      if (this.Hqd != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hqd);
      }
      i = i + f.a.a.b.b.a.bz(6, this.scene) + f.a.a.b.b.a.bz(7, this.dnh);
      paramInt = i;
      if (this.FRw != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FRw);
      }
      i = f.a.a.b.b.a.bz(9, this.FKN);
      AppMethodBeat.o(91683);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91683);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czh localczh = (czh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91683);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91683);
          return 0;
        case 2: 
          localczh.FYR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 3: 
          localczh.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 4: 
          localczh.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 5: 
          localczh.Hqd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 6: 
          localczh.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91683);
          return 0;
        case 7: 
          localczh.dnh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91683);
          return 0;
        case 8: 
          localczh.FRw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91683);
          return 0;
        }
        localczh.FKN = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91683);
        return 0;
      }
      AppMethodBeat.o(91683);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czh
 * JD-Core Version:    0.7.0.1
 */