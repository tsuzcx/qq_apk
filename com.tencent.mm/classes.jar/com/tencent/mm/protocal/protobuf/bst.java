package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bst
  extends com.tencent.mm.bw.a
{
  public boolean Hgr;
  public cth Hgs;
  public String dyI;
  public String kCZ;
  public String kDa;
  public String title;
  public int uIW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91528);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uIW);
      paramVarArgs.bC(2, this.Hgr);
      if (this.dyI != null) {
        paramVarArgs.d(3, this.dyI);
      }
      if (this.kCZ != null) {
        paramVarArgs.d(4, this.kCZ);
      }
      if (this.kDa != null) {
        paramVarArgs.d(5, this.kDa);
      }
      if (this.Hgs != null)
      {
        paramVarArgs.lJ(6, this.Hgs.computeSize());
        this.Hgs.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.d(7, this.title);
      }
      AppMethodBeat.o(91528);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.uIW) + 0 + f.a.a.b.b.a.amF(2);
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dyI);
      }
      i = paramInt;
      if (this.kCZ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.kCZ);
      }
      paramInt = i;
      if (this.kDa != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.kDa);
      }
      i = paramInt;
      if (this.Hgs != null) {
        i = paramInt + f.a.a.a.lI(6, this.Hgs.computeSize());
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.title);
      }
      AppMethodBeat.o(91528);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91528);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bst localbst = (bst)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91528);
        return -1;
      case 1: 
        localbst.uIW = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91528);
        return 0;
      case 2: 
        localbst.Hgr = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(91528);
        return 0;
      case 3: 
        localbst.dyI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 4: 
        localbst.kCZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 5: 
        localbst.kDa = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91528);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cth();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cth)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbst.Hgs = ((cth)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91528);
        return 0;
      }
      localbst.title = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(91528);
      return 0;
    }
    AppMethodBeat.o(91528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bst
 * JD-Core Version:    0.7.0.1
 */