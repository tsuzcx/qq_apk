package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abk
  extends com.tencent.mm.bx.a
{
  public String FBS;
  public LinkedList<dmo> FRa;
  public dmo FsP;
  public LinkedList<dmo> Gbe;
  public String Gbf;
  public int state;
  
  public abk()
  {
    AppMethodBeat.i(91427);
    this.FRa = new LinkedList();
    this.Gbe = new LinkedList();
    AppMethodBeat.o(91427);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91428);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.state);
      if (this.FsP != null)
      {
        paramVarArgs.lC(2, this.FsP.computeSize());
        this.FsP.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.FRa);
      paramVarArgs.e(4, 8, this.Gbe);
      if (this.Gbf != null) {
        paramVarArgs.d(5, this.Gbf);
      }
      if (this.FBS != null) {
        paramVarArgs.d(6, this.FBS);
      }
      AppMethodBeat.o(91428);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.state) + 0;
      paramInt = i;
      if (this.FsP != null) {
        paramInt = i + f.a.a.a.lB(2, this.FsP.computeSize());
      }
      i = paramInt + f.a.a.a.c(3, 8, this.FRa) + f.a.a.a.c(4, 8, this.Gbe);
      paramInt = i;
      if (this.Gbf != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gbf);
      }
      i = paramInt;
      if (this.FBS != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FBS);
      }
      AppMethodBeat.o(91428);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FRa.clear();
      this.Gbe.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91428);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      abk localabk = (abk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91428);
        return -1;
      case 1: 
        localabk.state = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91428);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabk.FsP = ((dmo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabk.FRa.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabk.Gbe.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91428);
        return 0;
      case 5: 
        localabk.Gbf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91428);
        return 0;
      }
      localabk.FBS = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(91428);
      return 0;
    }
    AppMethodBeat.o(91428);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abk
 * JD-Core Version:    0.7.0.1
 */