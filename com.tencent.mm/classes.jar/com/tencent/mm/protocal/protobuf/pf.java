package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class pf
  extends com.tencent.mm.bx.a
{
  public long CNp;
  public int CNq;
  public LinkedList<String> CNr;
  public String CNs;
  public int CNt;
  public String Title;
  public int mBk;
  public LinkedList<pm> saZ;
  
  public pf()
  {
    AppMethodBeat.i(117842);
    this.CNr = new LinkedList();
    this.saZ = new LinkedList();
    AppMethodBeat.o(117842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117843);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CNs == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchID");
        AppMethodBeat.o(117843);
        throw paramVarArgs;
      }
      paramVarArgs.aG(1, this.CNp);
      paramVarArgs.aR(2, this.CNq);
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      paramVarArgs.e(4, 1, this.CNr);
      paramVarArgs.e(5, 8, this.saZ);
      paramVarArgs.aR(6, this.mBk);
      if (this.CNs != null) {
        paramVarArgs.d(7, this.CNs);
      }
      paramVarArgs.aR(8, this.CNt);
      AppMethodBeat.o(117843);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.CNp) + 0 + f.a.a.b.b.a.bA(2, this.CNq);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Title);
      }
      i = paramInt + f.a.a.a.c(4, 1, this.CNr) + f.a.a.a.c(5, 8, this.saZ) + f.a.a.b.b.a.bA(6, this.mBk);
      paramInt = i;
      if (this.CNs != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CNs);
      }
      i = f.a.a.b.b.a.bA(8, this.CNt);
      AppMethodBeat.o(117843);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CNr.clear();
      this.saZ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.CNs == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchID");
        AppMethodBeat.o(117843);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117843);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      pf localpf = (pf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117843);
        return -1;
      case 1: 
        localpf.CNp = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(117843);
        return 0;
      case 2: 
        localpf.CNq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117843);
        return 0;
      case 3: 
        localpf.Title = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117843);
        return 0;
      case 4: 
        localpf.CNr.add(((f.a.a.a.a)localObject1).KhF.readString());
        AppMethodBeat.o(117843);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((pm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpf.saZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117843);
        return 0;
      case 6: 
        localpf.mBk = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117843);
        return 0;
      case 7: 
        localpf.CNs = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117843);
        return 0;
      }
      localpf.CNt = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(117843);
      return 0;
    }
    AppMethodBeat.o(117843);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pf
 * JD-Core Version:    0.7.0.1
 */