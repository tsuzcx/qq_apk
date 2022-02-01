package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dex
  extends com.tencent.mm.bx.a
{
  public String FOY;
  public di Gzn;
  public LinkedList<cmh> Htn;
  public ahk Hto;
  public LinkedList<crm> Htp;
  public int Htq;
  public int wDB;
  
  public dex()
  {
    AppMethodBeat.i(91694);
    this.Htn = new LinkedList();
    this.Htp = new LinkedList();
    AppMethodBeat.o(91694);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91695);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.wDB);
      paramVarArgs.e(2, 8, this.Htn);
      if (this.Hto != null)
      {
        paramVarArgs.lC(3, this.Hto.computeSize());
        this.Hto.writeFields(paramVarArgs);
      }
      if (this.Gzn != null)
      {
        paramVarArgs.lC(4, this.Gzn.computeSize());
        this.Gzn.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.Htp);
      paramVarArgs.aS(6, this.Htq);
      if (this.FOY != null) {
        paramVarArgs.d(7, this.FOY);
      }
      AppMethodBeat.o(91695);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.wDB) + 0 + f.a.a.a.c(2, 8, this.Htn);
      paramInt = i;
      if (this.Hto != null) {
        paramInt = i + f.a.a.a.lB(3, this.Hto.computeSize());
      }
      i = paramInt;
      if (this.Gzn != null) {
        i = paramInt + f.a.a.a.lB(4, this.Gzn.computeSize());
      }
      i = i + f.a.a.a.c(5, 8, this.Htp) + f.a.a.b.b.a.bz(6, this.Htq);
      paramInt = i;
      if (this.FOY != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FOY);
      }
      AppMethodBeat.o(91695);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Htn.clear();
      this.Htp.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91695);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dex localdex = (dex)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91695);
        return -1;
      case 1: 
        localdex.wDB = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91695);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdex.Htn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ahk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdex.Hto = ((ahk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new di();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((di)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdex.Gzn = ((di)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new crm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdex.Htp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91695);
        return 0;
      case 6: 
        localdex.Htq = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91695);
        return 0;
      }
      localdex.FOY = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(91695);
      return 0;
    }
    AppMethodBeat.o(91695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dex
 * JD-Core Version:    0.7.0.1
 */