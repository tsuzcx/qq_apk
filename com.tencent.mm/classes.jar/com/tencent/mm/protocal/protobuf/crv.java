package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crv
  extends com.tencent.mm.bw.a
{
  public acl HCV;
  public boolean HCW;
  public boolean HCX;
  public boolean HCY;
  public boolean HCZ;
  public boolean HDa;
  public boolean HDb;
  public boolean HDc;
  public boolean HDd;
  public boolean HDe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91659);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HCV != null)
      {
        paramVarArgs.lJ(1, this.HCV.computeSize());
        this.HCV.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(2, this.HCW);
      paramVarArgs.bC(3, this.HCX);
      paramVarArgs.bC(4, this.HCY);
      paramVarArgs.bC(5, this.HCZ);
      paramVarArgs.bC(6, this.HDa);
      paramVarArgs.bC(7, this.HDb);
      paramVarArgs.bC(8, this.HDc);
      paramVarArgs.bC(9, this.HDd);
      paramVarArgs.bC(10, this.HDe);
      AppMethodBeat.o(91659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HCV == null) {
        break label698;
      }
    }
    label698:
    for (paramInt = f.a.a.a.lI(1, this.HCV.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.amF(2);
      int j = f.a.a.b.b.a.amF(3);
      int k = f.a.a.b.b.a.amF(4);
      int m = f.a.a.b.b.a.amF(5);
      int n = f.a.a.b.b.a.amF(6);
      int i1 = f.a.a.b.b.a.amF(7);
      int i2 = f.a.a.b.b.a.amF(8);
      int i3 = f.a.a.b.b.a.amF(9);
      int i4 = f.a.a.b.b.a.amF(10);
      AppMethodBeat.o(91659);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        crv localcrv = (crv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91659);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((acl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcrv.HCV = ((acl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91659);
          return 0;
        case 2: 
          localcrv.HCW = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91659);
          return 0;
        case 3: 
          localcrv.HCX = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91659);
          return 0;
        case 4: 
          localcrv.HCY = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91659);
          return 0;
        case 5: 
          localcrv.HCZ = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91659);
          return 0;
        case 6: 
          localcrv.HDa = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91659);
          return 0;
        case 7: 
          localcrv.HDb = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91659);
          return 0;
        case 8: 
          localcrv.HDc = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91659);
          return 0;
        case 9: 
          localcrv.HDd = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(91659);
          return 0;
        }
        localcrv.HDe = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(91659);
        return 0;
      }
      AppMethodBeat.o(91659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crv
 * JD-Core Version:    0.7.0.1
 */