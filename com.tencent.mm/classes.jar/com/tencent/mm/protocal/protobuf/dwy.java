package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwy
  extends com.tencent.mm.bw.a
{
  public LinkedList<cid> HKC;
  public String Icn;
  public String Ict;
  public String aPp;
  public String aQj;
  public int action;
  public int type;
  
  public dwy()
  {
    AppMethodBeat.i(196288);
    this.HKC = new LinkedList();
    AppMethodBeat.o(196288);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196289);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.aQj != null) {
        paramVarArgs.d(1, this.aQj);
      }
      paramVarArgs.aS(2, this.type);
      if (this.aPp != null) {
        paramVarArgs.d(3, this.aPp);
      }
      paramVarArgs.aS(4, this.action);
      paramVarArgs.e(5, 8, this.HKC);
      if (this.Icn != null) {
        paramVarArgs.d(6, this.Icn);
      }
      if (this.Ict != null) {
        paramVarArgs.d(7, this.Ict);
      }
      AppMethodBeat.o(196289);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aQj == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.b.b.a.e(1, this.aQj) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.type);
      paramInt = i;
      if (this.aPp != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.aPp);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.action) + f.a.a.a.c(5, 8, this.HKC);
      paramInt = i;
      if (this.Icn != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Icn);
      }
      i = paramInt;
      if (this.Ict != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Ict);
      }
      AppMethodBeat.o(196289);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HKC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(196289);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dwy localdwy = (dwy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196289);
          return -1;
        case 1: 
          localdwy.aQj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(196289);
          return 0;
        case 2: 
          localdwy.type = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196289);
          return 0;
        case 3: 
          localdwy.aPp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(196289);
          return 0;
        case 4: 
          localdwy.action = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196289);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cid();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cid)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdwy.HKC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196289);
          return 0;
        case 6: 
          localdwy.Icn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(196289);
          return 0;
        }
        localdwy.Ict = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(196289);
        return 0;
      }
      AppMethodBeat.o(196289);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwy
 * JD-Core Version:    0.7.0.1
 */