package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbx
  extends com.tencent.mm.bx.a
{
  public LinkedList<btp> DYN;
  public String DYO;
  public LinkedList<String> EtD;
  public int EtE;
  public String dlB;
  public String doh;
  public int version;
  
  public dbx()
  {
    AppMethodBeat.i(176151);
    this.EtD = new LinkedList();
    this.DYN = new LinkedList();
    AppMethodBeat.o(176151);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176152);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.EtD);
      paramVarArgs.e(2, 8, this.DYN);
      if (this.doh != null) {
        paramVarArgs.d(3, this.doh);
      }
      paramVarArgs.aR(4, this.EtE);
      if (this.DYO != null) {
        paramVarArgs.d(5, this.DYO);
      }
      if (this.dlB != null) {
        paramVarArgs.d(6, this.dlB);
      }
      paramVarArgs.aR(7, this.version);
      AppMethodBeat.o(176152);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 1, this.EtD) + 0 + f.a.a.a.c(2, 8, this.DYN);
      paramInt = i;
      if (this.doh != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.doh);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.EtE);
      paramInt = i;
      if (this.DYO != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DYO);
      }
      i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.dlB);
      }
      paramInt = f.a.a.b.b.a.bA(7, this.version);
      AppMethodBeat.o(176152);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EtD.clear();
      this.DYN.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(176152);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dbx localdbx = (dbx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176152);
        return -1;
      case 1: 
        localdbx.EtD.add(((f.a.a.a.a)localObject1).KhF.readString());
        AppMethodBeat.o(176152);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((btp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdbx.DYN.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176152);
        return 0;
      case 3: 
        localdbx.doh = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(176152);
        return 0;
      case 4: 
        localdbx.EtE = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(176152);
        return 0;
      case 5: 
        localdbx.DYO = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(176152);
        return 0;
      case 6: 
        localdbx.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(176152);
        return 0;
      }
      localdbx.version = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(176152);
      return 0;
    }
    AppMethodBeat.o(176152);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbx
 * JD-Core Version:    0.7.0.1
 */