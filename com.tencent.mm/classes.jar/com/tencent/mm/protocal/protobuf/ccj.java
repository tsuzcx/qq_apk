package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccj
  extends com.tencent.mm.bx.a
{
  public int DRd;
  public LinkedList<btp> DYN;
  public String DYO;
  public boolean DvV;
  public String doh;
  public String ntj;
  
  public ccj()
  {
    AppMethodBeat.i(176148);
    this.DYN = new LinkedList();
    AppMethodBeat.o(176148);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176149);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.DYN);
      if (this.doh != null) {
        paramVarArgs.d(2, this.doh);
      }
      if (this.DYO != null) {
        paramVarArgs.d(3, this.DYO);
      }
      if (this.ntj != null) {
        paramVarArgs.d(4, this.ntj);
      }
      paramVarArgs.bg(5, this.DvV);
      paramVarArgs.aR(6, this.DRd);
      AppMethodBeat.o(176149);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.DYN) + 0;
      paramInt = i;
      if (this.doh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.doh);
      }
      i = paramInt;
      if (this.DYO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DYO);
      }
      paramInt = i;
      if (this.ntj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ntj);
      }
      i = f.a.a.b.b.a.fY(5);
      int j = f.a.a.b.b.a.bA(6, this.DRd);
      AppMethodBeat.o(176149);
      return paramInt + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DYN.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(176149);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ccj localccj = (ccj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176149);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((btp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localccj.DYN.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176149);
        return 0;
      case 2: 
        localccj.doh = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 3: 
        localccj.DYO = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 4: 
        localccj.ntj = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(176149);
        return 0;
      case 5: 
        localccj.DvV = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(176149);
        return 0;
      }
      localccj.DRd = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(176149);
      return 0;
    }
    AppMethodBeat.o(176149);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccj
 * JD-Core Version:    0.7.0.1
 */