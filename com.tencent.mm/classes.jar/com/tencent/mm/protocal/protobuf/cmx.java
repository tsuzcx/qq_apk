package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmx
  extends cvc
{
  public int FYc;
  public long HfW;
  public int HfX;
  public String HfY;
  public int Hgf;
  public int Hgg;
  public int Hgh;
  public String uki;
  public String ukj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32378);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ukj != null) {
        paramVarArgs.d(2, this.ukj);
      }
      if (this.HfY != null) {
        paramVarArgs.d(3, this.HfY);
      }
      paramVarArgs.aS(4, this.FYc);
      paramVarArgs.aY(5, this.HfW);
      paramVarArgs.aS(6, this.HfX);
      if (this.uki != null) {
        paramVarArgs.d(7, this.uki);
      }
      paramVarArgs.aS(8, this.Hgg);
      paramVarArgs.aS(9, this.Hgf);
      paramVarArgs.aS(10, this.Hgh);
      AppMethodBeat.o(32378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ukj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ukj);
      }
      i = paramInt;
      if (this.HfY != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HfY);
      }
      i = i + f.a.a.b.b.a.bz(4, this.FYc) + f.a.a.b.b.a.p(5, this.HfW) + f.a.a.b.b.a.bz(6, this.HfX);
      paramInt = i;
      if (this.uki != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.uki);
      }
      i = f.a.a.b.b.a.bz(8, this.Hgg);
      int j = f.a.a.b.b.a.bz(9, this.Hgf);
      int k = f.a.a.b.b.a.bz(10, this.Hgh);
      AppMethodBeat.o(32378);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cmx localcmx = (cmx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32378);
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
            localcmx.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32378);
          return 0;
        case 2: 
          localcmx.ukj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 3: 
          localcmx.HfY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 4: 
          localcmx.FYc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32378);
          return 0;
        case 5: 
          localcmx.HfW = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32378);
          return 0;
        case 6: 
          localcmx.HfX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32378);
          return 0;
        case 7: 
          localcmx.uki = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32378);
          return 0;
        case 8: 
          localcmx.Hgg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32378);
          return 0;
        case 9: 
          localcmx.Hgf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32378);
          return 0;
        }
        localcmx.Hgh = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32378);
        return 0;
      }
      AppMethodBeat.o(32378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmx
 * JD-Core Version:    0.7.0.1
 */