package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class amu
  extends com.tencent.mm.bx.a
{
  public int Gmi;
  public LinkedList<ard> Gmj;
  public int continueFlag;
  public String dwW;
  public int offset;
  public String query;
  public LinkedList<FinderObject> rtM;
  public b sbF;
  
  public amu()
  {
    AppMethodBeat.i(168958);
    this.rtM = new LinkedList();
    this.Gmj = new LinkedList();
    AppMethodBeat.o(168958);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.query != null) {
        paramVarArgs.d(1, this.query);
      }
      paramVarArgs.aS(2, this.offset);
      paramVarArgs.aS(3, this.continueFlag);
      paramVarArgs.e(4, 8, this.rtM);
      if (this.sbF != null) {
        paramVarArgs.c(5, this.sbF);
      }
      paramVarArgs.aS(6, this.Gmi);
      if (this.dwW != null) {
        paramVarArgs.d(7, this.dwW);
      }
      paramVarArgs.e(8, 8, this.Gmj);
      AppMethodBeat.o(168959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.query == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = f.a.a.b.b.a.e(1, this.query) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.offset) + f.a.a.b.b.a.bz(3, this.continueFlag) + f.a.a.a.c(4, 8, this.rtM);
      paramInt = i;
      if (this.sbF != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.sbF);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.Gmi);
      paramInt = i;
      if (this.dwW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dwW);
      }
      i = f.a.a.a.c(8, 8, this.Gmj);
      AppMethodBeat.o(168959);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rtM.clear();
        this.Gmj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(168959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        amu localamu = (amu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168959);
          return -1;
        case 1: 
          localamu.query = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168959);
          return 0;
        case 2: 
          localamu.offset = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168959);
          return 0;
        case 3: 
          localamu.continueFlag = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168959);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localamu.rtM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168959);
          return 0;
        case 5: 
          localamu.sbF = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(168959);
          return 0;
        case 6: 
          localamu.Gmi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(168959);
          return 0;
        case 7: 
          localamu.dwW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(168959);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ard();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ard)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localamu.Gmj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168959);
        return 0;
      }
      AppMethodBeat.o(168959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amu
 * JD-Core Version:    0.7.0.1
 */